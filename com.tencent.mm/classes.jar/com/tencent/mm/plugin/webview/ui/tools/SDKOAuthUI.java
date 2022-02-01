package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.a.jh;
import com.tencent.mm.kernel.e;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.model.ab;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.ai.a;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.model.z;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.cue;
import com.tencent.mm.protocal.protobuf.cuh;
import com.tencent.mm.protocal.protobuf.dgt;
import com.tencent.mm.protocal.protobuf.dri;
import com.tencent.mm.protocal.protobuf.drk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.g;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public final class SDKOAuthUI
  extends MMActivity
  implements i
{
  private static int Jfb;
  private boolean IYZ;
  private boolean JeK;
  private SendAuth.Req JeZ;
  private int Jfa;
  private MTimerHandler Jfc;
  private a Jfd;
  private b Jfe;
  private com.tencent.mm.ui.widget.b.a Jff;
  private boolean Jfg;
  private aj Jfh;
  private boolean Jfi;
  private String Jfj;
  private int accountType;
  private String edo;
  private com.tencent.mm.ui.base.q gxX;
  private String mAppId;
  private int ppd;
  private int ppe;
  private o.g pso;
  private long startTime;
  
  public SDKOAuthUI()
  {
    AppMethodBeat.i(79760);
    this.Jfi = true;
    this.JeK = false;
    this.accountType = 2;
    this.pso = new SDKOAuthUI.7(this);
    AppMethodBeat.o(79760);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, final drk paramdrk)
  {
    AppMethodBeat.i(79766);
    Log.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    gep();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd is_use_newpage %b", new Object[] { Boolean.valueOf(paramdrk.Mzy) });
      this.Jfj = paramdrk.lHJ;
      if ((paramdrk.Mzu) || (paramdrk.Mzv))
      {
        Log.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd direct login");
        com.tencent.mm.model.gdpr.c.a(this, com.tencent.mm.model.gdpr.a.iGO, this.mAppId, new com.tencent.mm.model.gdpr.b()
        {
          public final void sx(int paramAnonymousInt)
          {
            AppMethodBeat.i(79739);
            Log.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (paramAnonymousInt == 1)
            {
              SDKOAuthUI.a(SDKOAuthUI.this, -4);
              com.tencent.mm.plugin.webview.k.b.JBk.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), 0, 0, 0);
              SDKOAuthUI.this.finish();
              AppMethodBeat.o(79739);
              return;
            }
            SDKOAuthUI.f(SDKOAuthUI.this).a(ai.a.a(paramdrk), SDKOAuthUI.e(SDKOAuthUI.this).scope);
            com.tencent.mm.plugin.webview.k.b.JBk.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 1, SDKOAuthUI.c(SDKOAuthUI.this), 0, 0, 0);
            AppMethodBeat.o(79739);
          }
        });
        AppMethodBeat.o(79766);
        return;
      }
      if (paramdrk.Mzy)
      {
        if (aj.b(paramdrk))
        {
          paramString = (TextView)findViewById(2131297089);
          localObject1 = paramdrk.Mzs.iterator();
          label246:
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (cuh)((Iterator)localObject1).next();
            if ((localObject2 != null) && (("snsapi_userinfo".equals(((cuh)localObject2).scope)) || ("snsapi_login".equals(((cuh)localObject2).scope)) || ("group_sns_login".equals(((cuh)localObject2).scope)))) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (paramInt1 == 0) {
                break label246;
              }
              paramString.setText(((cuh)localObject2).desc);
              break;
            }
          }
          paramString.getPaint().setFakeBoldText(true);
          paramString = (TextView)findViewById(2131297090);
          if (!Util.isNullOrNil(paramdrk.MUa))
          {
            paramString.setVisibility(0);
            paramString.setText(paramdrk.MUa);
          }
          for (;;)
          {
            paramString = (ImageView)findViewById(2131305280);
            localObject1 = (TextView)findViewById(2131305283);
            localObject2 = new c.a();
            ((c.a)localObject2).jbq = 2131691211;
            ((c.a)localObject2).jbx = getResources().getDimension(2131166899);
            ((c.a)localObject2).iaT = true;
            com.tencent.mm.av.q.bcV().a(paramdrk.Mzt, paramString, ((c.a)localObject2).bdv());
            ((TextView)localObject1).setText(paramdrk.ixZ);
            paramString = (Button)findViewById(2131303786);
            localObject1 = (Button)findViewById(2131303789);
            paramString.setOnClickListener(new SDKOAuthUI.10(this, paramdrk));
            ((Button)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(79743);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
                SDKOAuthUI.f(SDKOAuthUI.this);
                localObject = aj.e("snsapi_userinfo", paramdrk.Mzs);
                paramAnonymousView = (View)localObject;
                if (localObject == null)
                {
                  SDKOAuthUI.f(SDKOAuthUI.this);
                  paramAnonymousView = aj.e("snsapi_login", paramdrk.Mzs);
                }
                if (paramAnonymousView == null)
                {
                  SDKOAuthUI.f(SDKOAuthUI.this);
                  paramAnonymousView = aj.e("group_sns_login", paramdrk.Mzs);
                }
                for (;;)
                {
                  com.tencent.mm.plugin.webview.k.b.JBk.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), 2, 1, 0);
                  SDKOAuthUI.a(SDKOAuthUI.this, paramAnonymousView, paramdrk);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(79743);
                  return;
                }
              }
            });
            Jfb = paramdrk.lHG;
            this.Jff = new com.tencent.mm.ui.widget.b.a(this);
            this.Jfe = new b(this, paramdrk.Mzx, paramdrk.lHH);
            gex();
            paramString = (ListView)findViewById(2131297139);
            paramString.setAdapter(this.Jfe);
            paramString.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
              public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
              {
                AppMethodBeat.i(79744);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bm(paramAnonymousAdapterView);
                localb.bm(paramAnonymousView);
                localb.pH(paramAnonymousInt);
                localb.zo(paramAnonymousLong);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
                SDKOAuthUI.b.a(SDKOAuthUI.h(SDKOAuthUI.this), SDKOAuthUI.h(SDKOAuthUI.this).agF(paramAnonymousInt).id);
                SDKOAuthUI.h(SDKOAuthUI.this).notifyDataSetChanged();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(79744);
              }
            });
            paramString.setOnTouchListener(new SDKOAuthUI.13(this));
            paramString.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
            {
              public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
              {
                AppMethodBeat.i(79746);
                SDKOAuthUI.d(SDKOAuthUI.this, paramAnonymousInt);
                int i = SDKOAuthUI.h(SDKOAuthUI.this).agF(paramAnonymousInt).id;
                if ((i != 0) && (i != 1)) {
                  SDKOAuthUI.l(SDKOAuthUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, SDKOAuthUI.this, SDKOAuthUI.i(SDKOAuthUI.this), SDKOAuthUI.j(SDKOAuthUI.this), SDKOAuthUI.k(SDKOAuthUI.this));
                }
                AppMethodBeat.o(79746);
                return true;
              }
            });
            findViewById(2131299318).setOnClickListener(new SDKOAuthUI.15(this));
            this.Jfg = paramdrk.lHF;
            if (paramdrk.lHF) {
              findViewById(2131299320).setVisibility(8);
            }
            findViewById(2131305367).setVisibility(0);
            AppMethodBeat.o(79766);
            return;
            paramString.setVisibility(8);
          }
        }
        if (aj.e("snsapi_friend", paramdrk.Mzs) != null)
        {
          a(paramdrk, SDKOAuthFriendUI.class, "snsapi_friend");
          aj.aT(this);
          AppMethodBeat.o(79766);
          return;
        }
        if (aj.e("snsapi_wxaapp_info", paramdrk.Mzs) != null)
        {
          a(paramdrk, SDKOAuthFriendUI.class, "snsapi_wxaapp_info");
          aj.aT(this);
          AppMethodBeat.o(79766);
          return;
        }
        a(paramdrk, SDKOAuthOtherUI.class, "");
        aj.aT(this);
        AppMethodBeat.o(79766);
        return;
      }
      this.Jfi = false;
      paramString = (ImageView)findViewById(2131296945);
      Object localObject1 = (TextView)findViewById(2131296959);
      Object localObject2 = new c.a();
      ((c.a)localObject2).jbq = 2131691211;
      com.tencent.mm.av.q.bcV().a(paramdrk.Mzt, paramString, ((c.a)localObject2).bdv());
      ((TextView)localObject1).setText(l.b(this, paramdrk.ixZ, ((TextView)localObject1).getTextSize()));
      paramString = (ListView)findViewById(2131297092);
      this.Jfd = new a(this, paramdrk.Mzs);
      paramString.setAdapter(this.Jfd);
      ((Button)findViewById(2131303784)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(79741);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.SdkOAuthUI", "accept go  MPGdprPolicyUtil.checkPolicy");
          com.tencent.mm.model.gdpr.c.a(SDKOAuthUI.this, com.tencent.mm.model.gdpr.a.iGO, SDKOAuthUI.a(SDKOAuthUI.this), new com.tencent.mm.model.gdpr.b()
          {
            public final void sx(int paramAnonymous2Int)
            {
              AppMethodBeat.i(79740);
              Log.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
              if (paramAnonymous2Int == 1)
              {
                SDKOAuthUI.a(SDKOAuthUI.this, -4);
                com.tencent.mm.plugin.webview.k.b.JBk.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), 1, 1, 0);
                SDKOAuthUI.this.finish();
                AppMethodBeat.o(79740);
                return;
              }
              if (SDKOAuthUI.9.this.Jfl.Mzw)
              {
                SDKOAuthUI.a(SDKOAuthUI.this, SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.e(SDKOAuthUI.this).state, SDKOAuthUI.baj(SDKOAuthUI.a(SDKOAuthUI.this)), SDKOAuthUI.g(SDKOAuthUI.this).gez());
                AppMethodBeat.o(79740);
                return;
              }
              com.tencent.mm.plugin.webview.k.b.JBk.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 1, SDKOAuthUI.c(SDKOAuthUI.this), 1, 1, 0);
              SDKOAuthUI.f(SDKOAuthUI.this).a(ai.a.a(SDKOAuthUI.9.this.Jfl), SDKOAuthUI.e(SDKOAuthUI.this).scope);
              AppMethodBeat.o(79740);
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(79741);
        }
      });
      findViewById(2131307157).setVisibility(0);
      AppMethodBeat.o(79766);
      return;
    }
    if (!agc(paramInt1))
    {
      cQ(getString(2131768655), true);
      com.tencent.mm.plugin.webview.k.b.JBk.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
      AppMethodBeat.o(79766);
      return;
    }
    com.tencent.mm.plugin.webview.k.b.JBk.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
    cQ(paramString, true);
    AppMethodBeat.o(79766);
  }
  
  private void a(drk paramdrk, Class<?> paramClass, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79770);
    a(paramdrk, paramClass, paramInt1, paramInt2, "");
    AppMethodBeat.o(79770);
  }
  
  private void a(drk paramdrk, Class<?> paramClass, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(79771);
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.mAppId);
    if (this.JeZ != null)
    {
      paramClass.putExtra("1", this.JeZ.transaction);
      paramClass.putExtra("4", this.JeZ.state);
      paramClass.putExtra("7", this.JeZ.extData);
    }
    paramClass.putExtra("3", paramInt1);
    paramClass.putExtra("5", paramInt2);
    paramClass.putExtra("auth_from_scan", this.JeK);
    paramClass.putExtra("auth_raw_url", this.edo);
    if (!TextUtils.isEmpty(paramString)) {
      paramClass.putExtra("auth_scope", paramString);
    }
    try
    {
      paramClass.putExtra("2", paramdrk.toByteArray());
      paramdrk = new com.tencent.mm.hellhoundlib.b.a().bl(paramClass);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramdrk.axQ(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;IILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramdrk.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;IILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(79771);
      return;
    }
    catch (IOException paramdrk)
    {
      for (;;)
      {
        Log.e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void a(drk paramdrk, Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(79772);
    Log.i("MicroMsg.SdkOAuthUI", "startScopeActivity %s", new Object[] { paramClass.getSimpleName() });
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.mAppId);
    if (this.JeZ != null)
    {
      paramClass.putExtra("1", this.JeZ.transaction);
      paramClass.putExtra("4", this.JeZ.state);
      paramClass.putExtra("7", this.JeZ.extData);
    }
    paramClass.putExtra("auth_from_scan", this.JeK);
    if (!TextUtils.isEmpty(paramString)) {
      paramClass.putExtra("auth_scope", paramString);
    }
    paramClass.putExtra("auth_raw_url", this.edo);
    try
    {
      paramClass.putExtra("2", paramdrk.toByteArray());
      paramdrk = new com.tencent.mm.hellhoundlib.b.a().bl(paramClass);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramdrk.axQ(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramdrk.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(79772);
      return;
    }
    catch (IOException paramdrk)
    {
      for (;;)
      {
        Log.e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void a(String paramString, SendAuth.Resp paramResp)
  {
    AppMethodBeat.i(79769);
    if (this.IYZ)
    {
      Log.i("MicroMsg.SdkOAuthUI", "doCallback has callback");
      AppMethodBeat.o(79769);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79769);
      return;
    }
    this.IYZ = true;
    Bundle localBundle = new Bundle();
    paramResp.toBundle(localBundle);
    com.tencent.mm.pluginsdk.model.app.q.bo(localBundle);
    paramResp = new MMessageActV2.Args();
    paramResp.targetPkgName = paramString;
    paramResp.bundle = localBundle;
    MMessageActV2.send(this, paramResp);
    AppMethodBeat.o(79769);
  }
  
  private static String aYG(String paramString)
  {
    AppMethodBeat.i(79783);
    Object localObject = null;
    com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.o(paramString, false, false);
    if (localg != null) {}
    for (paramString = localg.field_packageName;; paramString = localObject)
    {
      AppMethodBeat.o(79783);
      return paramString;
      Log.w("MicroMsg.SdkOAuthUI", "dealWithCancel getAppInfo null; appid: %s", new Object[] { paramString });
    }
  }
  
  private void agb(int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(79767);
    Log.i("MicroMsg.SdkOAuthUI", "dealWithCancel");
    if (this.JeK)
    {
      localObject = new aa(2, this.edo, null, 0);
      com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject, 0);
      AppMethodBeat.o(79767);
      return;
    }
    if (this.JeZ == null)
    {
      AppMethodBeat.o(79767);
      return;
    }
    String str1 = aYG(this.mAppId);
    String str2 = this.mAppId;
    String str3 = this.JeZ.state;
    if (this.Jfd == null) {}
    for (;;)
    {
      localObject = new ac(2, str2, str3, str1, (LinkedList)localObject, this.JeZ.extData);
      com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject, 0);
      localObject = new SendAuth.Resp();
      ((SendAuth.Resp)localObject).transaction = this.JeZ.transaction;
      ((SendAuth.Resp)localObject).errCode = paramInt;
      ((SendAuth.Resp)localObject).lang = gcM();
      ((SendAuth.Resp)localObject).country = getCountry();
      a(str1, (SendAuth.Resp)localObject);
      AppMethodBeat.o(79767);
      return;
      localObject = this.Jfd.gez();
    }
  }
  
  private boolean agc(int paramInt)
  {
    AppMethodBeat.i(79780);
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8))
    {
      Log.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, errType = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(79780);
      return false;
    }
    if (!NetStatusUtil.isConnected(this))
    {
      Log.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, not connected");
      AppMethodBeat.o(79780);
      return false;
    }
    AppMethodBeat.o(79780);
    return true;
  }
  
  private void bWL()
  {
    AppMethodBeat.i(79777);
    if ((this.gxX != null) && (!this.gxX.isShowing()))
    {
      this.gxX.show();
      AppMethodBeat.o(79777);
      return;
    }
    this.gxX = com.tencent.mm.ui.base.h.a(this, getString(2131763747), true, new SDKOAuthUI.4(this));
    AppMethodBeat.o(79777);
  }
  
  private void bai(String paramString)
  {
    AppMethodBeat.i(79776);
    com.tencent.mm.ui.base.h.c(this, paramString, getString(2131763524), true);
    AppMethodBeat.o(79776);
  }
  
  private void cQ(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(79775);
    com.tencent.mm.ui.base.h.d(this, paramString, getString(2131768654), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(79734);
        if (!SDKOAuthUI.o(SDKOAuthUI.this)) {
          SDKOAuthUI.a(SDKOAuthUI.this, paramString);
        }
        if (paramBoolean) {
          SDKOAuthUI.this.finish();
        }
        AppMethodBeat.o(79734);
      }
    });
    AppMethodBeat.o(79775);
  }
  
  private void cY(int paramInt, String paramString)
  {
    AppMethodBeat.i(79768);
    String str = aYG(this.mAppId);
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.SdkOAuthUI", "dealWithError pkg nil");
      AppMethodBeat.o(79768);
      return;
    }
    SendAuth.Resp localResp = new SendAuth.Resp();
    localResp.transaction = this.JeZ.transaction;
    localResp.errCode = paramInt;
    localResp.errStr = paramString;
    localResp.lang = gcM();
    localResp.country = getCountry();
    a(str, localResp);
    AppMethodBeat.o(79768);
  }
  
  private String gcM()
  {
    AppMethodBeat.i(79781);
    String str = LocaleUtil.loadApplicationLanguage(getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this);
    AppMethodBeat.o(79781);
    return str;
  }
  
  private void gep()
  {
    AppMethodBeat.i(79779);
    if (this.gxX == null)
    {
      AppMethodBeat.o(79779);
      return;
    }
    this.gxX.dismiss();
    AppMethodBeat.o(79779);
  }
  
  private static String getCountry()
  {
    AppMethodBeat.i(79782);
    String str = Util.nullAs((String)com.tencent.mm.kernel.g.aAh().azQ().get(274436, null), null);
    AppMethodBeat.o(79782);
    return str;
  }
  
  private int gew()
  {
    if (this.Jfi) {
      return 2;
    }
    return 1;
  }
  
  private void gex()
  {
    AppMethodBeat.i(79773);
    if (this.Jfg)
    {
      AppMethodBeat.o(79773);
      return;
    }
    if (this.Jfe.getCount() >= Jfb)
    {
      findViewById(2131299318).setVisibility(8);
      findViewById(2131309622).setVisibility(0);
      findViewById(2131309623).setVisibility(4);
      AppMethodBeat.o(79773);
      return;
    }
    findViewById(2131299318).setVisibility(0);
    findViewById(2131309622).setVisibility(8);
    findViewById(2131309623).setVisibility(0);
    AppMethodBeat.o(79773);
  }
  
  private void gey()
  {
    AppMethodBeat.i(79778);
    gep();
    this.gxX = com.tencent.mm.ui.base.h.a(this, getString(2131756029), true, new SDKOAuthUI.5(this));
    AppMethodBeat.o(79778);
  }
  
  public final int getLayoutId()
  {
    return 2131496173;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(79774);
    Log.i("MicroMsg.SdkOAuthUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      Log.e("MicroMsg.SdkOAuthUI", "Create avatar cancel or failed");
      AppMethodBeat.o(79774);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(79774);
      return;
    }
    cue localcue = new cue();
    localcue.id = paramIntent.getIntExtra("id", -1);
    localcue.nickname = paramIntent.getStringExtra("nickname");
    localcue.lHM = paramIntent.getStringExtra("avatarurl");
    localcue.desc = null;
    if (this.Jfe != null)
    {
      paramIntent = this.Jfe;
      if ((localcue.id != -1) && (paramIntent.Jfp != null) && (paramIntent.Jfp.size() < Jfb)) {
        paramIntent.Jfp.add(localcue);
      }
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        b.a(this.Jfe, localcue.id);
        gex();
        this.Jfe.notifyDataSetChanged();
        AppMethodBeat.o(79774);
        return;
      }
    }
    if (this.Jfe == null) {}
    for (;;)
    {
      Log.e("MicroMsg.SdkOAuthUI", "onActivityResult mAvatarAdapter == null:%b", new Object[] { Boolean.valueOf(bool) });
      break;
      bool = false;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79761);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.azz().a(1346, this);
    com.tencent.mm.kernel.g.azz().a(1388, this);
    com.tencent.mm.kernel.g.azz().a(2700, this);
    com.tencent.mm.kernel.g.azz().a(2543, this);
    com.tencent.mm.kernel.g.azz().a(1137, this);
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    ((TextView)findViewById(2131303133)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(211044);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.SdkOAuthUI", "BackBtn click");
        com.tencent.mm.plugin.webview.k.b.JBk.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), SDKOAuthUI.d(SDKOAuthUI.this), 1, 0);
        SDKOAuthUI.a(SDKOAuthUI.this, -2);
        SDKOAuthUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(211044);
      }
    });
    if (!com.tencent.mm.kernel.g.aAc())
    {
      Log.e("MicroMsg.SdkOAuthUI", "start, hasSetUin fail");
      Toast.makeText(this, 2131755139, 1).show();
      AppMethodBeat.o(79761);
      return;
    }
    this.IYZ = false;
    paramBundle = getIntent();
    this.JeK = paramBundle.getBooleanExtra("auth_from_scan", false);
    this.startTime = System.currentTimeMillis();
    Log.i("MicroMsg.SdkOAuthUI", "init isFromQRCodeScan %b", new Object[] { Boolean.valueOf(this.JeK) });
    if (this.JeK)
    {
      this.accountType = 3;
      this.edo = paramBundle.getStringExtra("auth_raw_url");
      paramBundle = this.edo;
      Log.i("MicroMsg.SdkOAuthUI", "doQRCodeOauthAuthorize url: %s", new Object[] { paramBundle });
      bWL();
      paramBundle = new z(paramBundle);
      com.tencent.mm.kernel.g.azz().a(paramBundle, 0);
      this.Jfh = new aj(this, null, this.edo);
      com.tencent.mm.plugin.webview.k.b.JBk.da(3, "");
      AppMethodBeat.o(79761);
      return;
    }
    paramBundle = getIntent().getExtras();
    String str1 = paramBundle.getString("_mmessage_content");
    if (Util.isNullOrNil(str1))
    {
      Log.e("MicroMsg.SdkOAuthUI", "init content is nil");
      AppMethodBeat.o(79761);
      return;
    }
    this.mAppId = Uri.parse(str1).getQueryParameter("appid");
    if (Util.isNullOrNil(this.mAppId))
    {
      Log.i("MicroMsg.SdkOAuthUI", "parseAppId try case not sensitive, content:%s", new Object[] { str1 });
      this.mAppId = Uri.parse(str1.toLowerCase()).getQueryParameter("appid");
    }
    str1 = this.mAppId;
    Object localObject = com.tencent.mm.pluginsdk.model.app.h.o(str1, false, false);
    if ((localObject != null) && (Util.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject).field_openId)))
    {
      Log.i("MicroMsg.SdkOAuthUI", "checkGetAppSetting appId: %s ", new Object[] { str1 });
      localObject = new jh();
      ((jh)localObject).dOa.appId = str1;
      EventCenter.instance.publish((IEvent)localObject);
    }
    this.JeZ = new SendAuth.Req(paramBundle);
    com.tencent.mm.plugin.webview.k.b.JBk.da(2, this.JeZ.extData);
    this.Jfh = new aj(this, this.mAppId, this.JeZ.transaction, this.JeZ.state, this.JeZ.extData);
    if ((!Util.isNullOrNil(this.JeZ.scope)) && (this.JeZ.scope.contains("snsapi_wxaapp_info")) && (!this.JeZ.scope.equals("snsapi_wxaapp_info")))
    {
      cY(-1000, String.format(getContext().getResources().getString(2131768656), new Object[] { "snsapi_wxaapp_info" }));
      finish();
      AppMethodBeat.o(79761);
      return;
    }
    str1 = this.mAppId;
    localObject = this.JeZ.scope;
    String str2 = this.JeZ.state;
    String str3 = aYG(this.mAppId);
    Log.i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorize appid: %s, extData：%s", new Object[] { str1, this.JeZ.extData });
    bWL();
    if (Util.isNullOrNil(str3)) {
      paramBundle = null;
    }
    for (;;)
    {
      paramBundle = new ab(str1, (String)localObject, str2, str3, paramBundle, this.JeZ.extData);
      com.tencent.mm.kernel.g.azz().a(paramBundle, 0);
      AppMethodBeat.o(79761);
      return;
      paramBundle = com.tencent.mm.pluginsdk.model.app.q.cj(this, str3);
      if ((paramBundle == null) || (paramBundle.length == 0))
      {
        Log.e("MicroMsg.SdkOAuthUI", "getSignature signatures failed");
        paramBundle = null;
      }
      else
      {
        paramBundle = com.tencent.mm.b.g.getMessageDigest(paramBundle[0].toByteArray());
      }
    }
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(79785);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 1, 0, getString(2131763523));
    AppMethodBeat.o(79785);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(79764);
    super.onDestroy();
    if (this.gxX != null) {
      this.gxX.dismiss();
    }
    if (this.Jfc != null) {
      this.Jfc.stopTimer();
    }
    com.tencent.mm.kernel.g.azz().b(1388, this);
    com.tencent.mm.kernel.g.azz().b(1346, this);
    com.tencent.mm.kernel.g.azz().b(2700, this);
    com.tencent.mm.kernel.g.azz().b(2543, this);
    com.tencent.mm.kernel.g.azz().b(1137, this);
    AppMethodBeat.o(79764);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(79765);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      com.tencent.mm.plugin.webview.k.b.JBk.a(this.mAppId, this.startTime, 0, this.accountType, gew(), 1, 0);
      agb(-2);
      Log.i("MicroMsg.SdkOAuthUI", "key back click");
      finish();
      AppMethodBeat.o(79765);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(79765);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(79763);
    super.onPause();
    AppMethodBeat.o(79763);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(79762);
    super.onResume();
    AppMethodBeat.o(79762);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(79784);
    Object localObject;
    if ((paramq instanceof ab))
    {
      a(paramInt1, paramInt2, paramString, (drk)((ab)paramq).rr.iLL.iLR);
      com.tencent.mm.plugin.webview.k.b.JBk.aO(3, (int)(System.currentTimeMillis() - this.startTime), paramInt2);
      if (!(paramq instanceof z)) {
        break label863;
      }
      Log.i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label783;
      }
      localObject = (dgt)((z)paramq).rr.iLL.iLR;
      this.mAppId = ((dgt)localObject).dNI;
      this.Jfh.mAppId = ((dgt)localObject).dNI;
      if (!((dgt)localObject).MLk) {
        break label617;
      }
      Log.i("MicroMsg.SdkOAuthUI", "fallback to h5");
      com.tencent.mm.plugin.webview.k.b.JBk.a(this.mAppId, this.startTime, 1, this.accountType, 0, 0, paramInt2);
      com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", getIntent());
      aj.aT(this);
      paramInt1 = 1;
      label197:
      if (paramInt1 == 0) {
        gep();
      }
      com.tencent.mm.plugin.webview.k.b.JBk.aO(3, (int)(System.currentTimeMillis() - this.startTime), paramInt2);
    }
    for (;;)
    {
      gep();
      AppMethodBeat.o(79784);
      return;
      if ((paramq instanceof ac))
      {
        Log.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (this.Jfc != null) {
          this.Jfc.stopTimer();
        }
        gep();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject = ((ac)paramq).gcA();
          com.tencent.mm.plugin.webview.k.b.JBk.a(this.mAppId, this.startTime, 1, this.accountType, gew(), 1, 0);
          this.Jfh.a(ai.a.a((dri)localObject), this.JeZ.scope);
          break;
        }
        if (!agc(paramInt1))
        {
          cQ(getString(2131768655), false);
          com.tencent.mm.plugin.webview.k.b.JBk.a(this.mAppId, this.startTime, 2, this.accountType, gew(), 1, paramInt2);
          break;
        }
        cQ(paramString, false);
        com.tencent.mm.plugin.webview.k.b.JBk.a(this.mAppId, this.startTime, 2, this.accountType, gew(), 1, paramInt2);
        break;
      }
      if (!(paramq instanceof com.tencent.mm.modelsimple.h)) {
        break;
      }
      Log.i("MicroMsg.SdkOAuthUI", "onAddAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.Jfe.agF(this.Jfa).id == b.a(this.Jfe)) {
          b.a(this.Jfe, this.Jfe.agF(0).id);
        }
        localObject = this.Jfe;
        int i = this.Jfa;
        if (((b)localObject).Jfp == null) {}
        for (boolean bool = false;; bool = ((b)localObject).Jfp.remove(((b)localObject).agF(i)))
        {
          if (!bool) {
            Log.e("MicroMsg.SdkOAuthUI", "remove avatar failed: not found");
          }
          gex();
          this.Jfe.notifyDataSetChanged();
          break;
        }
      }
      if (!agc(paramInt1))
      {
        bai(getString(2131768655));
        break;
      }
      bai(paramString);
      break;
      label617:
      if (localObject == null) {
        paramq = null;
      }
      for (;;)
      {
        a(paramInt1, paramInt2, paramString, paramq);
        paramInt1 = 0;
        break;
        paramq = new drk();
        paramq.BaseResponse = ((dgt)localObject).BaseResponse;
        paramq.Mzu = false;
        paramq.Mzv = false;
        paramq.Mzy = true;
        paramq.Mzw = false;
        paramq.Mzs = ((dgt)localObject).Mzs;
        paramq.ixZ = ((dgt)localObject).ixZ;
        paramq.Mzt = ((dgt)localObject).Mzt;
        paramq.KJw = "";
        paramq.Mzx = ((dgt)localObject).Mzx;
        paramq.lHF = ((dgt)localObject).lHF;
        paramq.lHG = ((dgt)localObject).lHG;
        paramq.lHH = ((dgt)localObject).lHH;
        paramq.lHI = ((dgt)localObject).lHI;
        paramq.lHJ = ((dgt)localObject).lHJ;
      }
      label783:
      if (!agc(paramInt1))
      {
        cQ(getString(2131768655), true);
        com.tencent.mm.plugin.webview.k.b.JBk.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
        paramInt1 = 0;
        break label197;
      }
      com.tencent.mm.plugin.webview.k.b.JBk.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
      cQ(paramString, true);
      paramInt1 = 0;
      break label197;
      label863:
      if ((paramq instanceof aa))
      {
        Log.i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        gep();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.plugin.webview.k.b.JBk.a(this.mAppId, this.startTime, 1, this.accountType, gew(), 1, 0);
          finish();
        }
        else if (!agc(paramInt1))
        {
          cQ(getString(2131768655), false);
          com.tencent.mm.plugin.webview.k.b.JBk.a(this.mAppId, this.startTime, 2, this.accountType, gew(), 1, paramInt2);
        }
        else
        {
          cQ(paramString, false);
          com.tencent.mm.plugin.webview.k.b.JBk.a(this.mAppId, this.startTime, 2, this.accountType, gew(), 1, paramInt2);
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    private LinkedList<cuh> JeV;
    private LayoutInflater mInflater;
    
    public a(Context paramContext, LinkedList<cuh> paramLinkedList)
    {
      AppMethodBeat.i(79749);
      this.mInflater = LayoutInflater.from(paramContext);
      this.JeV = paramLinkedList;
      AppMethodBeat.o(79749);
    }
    
    private cuh agE(int paramInt)
    {
      AppMethodBeat.i(79752);
      if ((paramInt >= 0) && (paramInt < this.JeV.size()))
      {
        cuh localcuh = (cuh)this.JeV.get(paramInt);
        AppMethodBeat.o(79752);
        return localcuh;
      }
      AppMethodBeat.o(79752);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(79751);
      if (this.JeV == null)
      {
        AppMethodBeat.o(79751);
        return 0;
      }
      int i = this.JeV.size();
      AppMethodBeat.o(79751);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(79753);
      if ((this.JeV == null) || (this.JeV.size() <= 0))
      {
        AppMethodBeat.o(79753);
        return null;
      }
      final cuh localcuh = agE(paramInt);
      if (localcuh == null)
      {
        AppMethodBeat.o(79753);
        return paramView;
      }
      if (paramView == null)
      {
        paramViewGroup = new a((byte)0);
        paramView = this.mInflater.inflate(2131496171, null, false);
        paramViewGroup.JeY = ((ImageView)paramView.findViewById(2131296771));
        paramViewGroup.oqe = ((TextView)paramView.findViewById(2131296770));
        paramView.setTag(paramViewGroup);
        if (localcuh.MzA != 1) {
          break label177;
        }
        paramViewGroup.JeY.setImageResource(2131691023);
      }
      for (;;)
      {
        paramViewGroup.oqe.setText(localcuh.desc);
        final ImageView localImageView = paramViewGroup.JeY;
        paramViewGroup.JeY.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(79748);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (localcuh.MzA == 2)
            {
              localImageView.setImageResource(2131691023);
              localcuh.MzA = 1;
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(79748);
              return;
              if (localcuh.MzA == 1)
              {
                localImageView.setImageResource(2131691021);
                localcuh.MzA = 2;
              }
            }
          }
        });
        AppMethodBeat.o(79753);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label177:
        if (localcuh.MzA == 3) {
          paramViewGroup.JeY.setImageResource(2131691022);
        } else {
          paramViewGroup.JeY.setImageResource(2131691021);
        }
      }
    }
    
    public final LinkedList<String> gez()
    {
      AppMethodBeat.i(79750);
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < this.JeV.size())
      {
        cuh localcuh = (cuh)this.JeV.get(i);
        if ((localcuh.MzA == 2) || (localcuh.MzA == 3)) {
          localLinkedList.add(localcuh.scope);
        }
        i += 1;
      }
      AppMethodBeat.o(79750);
      return localLinkedList;
    }
    
    static final class a
    {
      ImageView JeY;
      TextView oqe;
    }
  }
  
  static final class b
    extends BaseAdapter
  {
    LinkedList<cue> Jfp;
    private c.a Jfq;
    private Context Jfr;
    private int Jfs;
    private LayoutInflater mInflater;
    
    public b(Context paramContext, LinkedList<cue> paramLinkedList, int paramInt)
    {
      AppMethodBeat.i(79755);
      this.Jfr = paramContext;
      this.mInflater = LayoutInflater.from(paramContext);
      this.Jfp = paramLinkedList;
      if (this.Jfp == null) {
        this.Jfp = new LinkedList();
      }
      Log.i("MicroMsg.SdkOAuthUI", "LoginAvatarListAdapter avatars size:%d", new Object[] { Integer.valueOf(this.Jfp.size()) });
      this.Jfq = new c.a();
      this.Jfq.jbq = 2131691211;
      paramContext = this.Jfq;
      paramContext.iaT = true;
      paramContext.jbx = this.Jfr.getResources().getDimension(2131166898);
      this.Jfs = paramInt;
      AppMethodBeat.o(79755);
    }
    
    public final cue agF(int paramInt)
    {
      AppMethodBeat.i(79757);
      if ((this.Jfp != null) && (paramInt >= 0) && (paramInt < this.Jfp.size()))
      {
        cue localcue = (cue)this.Jfp.get(paramInt);
        AppMethodBeat.o(79757);
        return localcue;
      }
      AppMethodBeat.o(79757);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(79756);
      if (this.Jfp == null)
      {
        AppMethodBeat.o(79756);
        return 0;
      }
      int i = this.Jfp.size();
      AppMethodBeat.o(79756);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(79758);
      cue localcue = agF(paramInt);
      if (localcue == null)
      {
        AppMethodBeat.o(79758);
        return paramView;
      }
      View localView;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localView = this.mInflater.inflate(2131493169, null, false);
        paramView.Jft = ((ImageView)localView.findViewById(2131297131));
        paramView.Jfu = ((TextView)localView.findViewById(2131297140));
        paramView.Jfv = ((TextView)localView.findViewById(2131297127));
        paramView.Jfw = ((ImageView)localView.findViewById(2131297143));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        paramViewGroup.Jfu.setText(l.b(this.Jfr, localcue.nickname, paramViewGroup.Jfu.getTextSize()));
        com.tencent.mm.av.q.bcV().a(localcue.lHM, paramViewGroup.Jft, this.Jfq.bdv());
        if (localcue.desc == null) {
          break label232;
        }
        paramViewGroup.Jfv.setText(localcue.desc);
        paramViewGroup.Jfv.setVisibility(0);
        label190:
        if (localcue.id != this.Jfs) {
          break label244;
        }
        paramViewGroup.Jfw.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(79758);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label232:
        paramViewGroup.Jfv.setVisibility(8);
        break label190;
        label244:
        paramViewGroup.Jfw.setVisibility(4);
      }
    }
    
    static final class a
    {
      ImageView Jft;
      TextView Jfu;
      TextView Jfv;
      ImageView Jfw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI
 * JD-Core Version:    0.7.0.1
 */