package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.plugin.webview.model.z;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.btv;
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.protocal.protobuf.cdx;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public final class SDKOAuthUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private static int BdY;
  private boolean AYk;
  private boolean BdH;
  private SendAuth.Req BdW;
  private int BdX;
  private av BdZ;
  private a Bea;
  private b Beb;
  private com.tencent.mm.ui.widget.b.a Bec;
  private boolean Bed;
  private ai Bee;
  private boolean Bef;
  private String Beg;
  private int accountType;
  private String dAl;
  private p ftP;
  private String mAppId;
  private int mUE;
  private int mUF;
  private n.d mXD;
  private long startTime;
  
  public SDKOAuthUI()
  {
    AppMethodBeat.i(79760);
    this.Bef = true;
    this.BdH = false;
    this.accountType = 2;
    this.mXD = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(79738);
        SDKOAuthUI.r(SDKOAuthUI.this);
        AppMethodBeat.o(79738);
      }
    };
    AppMethodBeat.o(79760);
  }
  
  private void SO(int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(79767);
    ad.i("MicroMsg.SdkOAuthUI", "dealWithCancel");
    if (this.BdH)
    {
      localObject = new aa(2, this.dAl, null, 0);
      com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
      AppMethodBeat.o(79767);
      return;
    }
    if (this.BdW == null)
    {
      AppMethodBeat.o(79767);
      return;
    }
    String str1 = awu(this.mAppId);
    String str2 = this.mAppId;
    String str3 = this.BdW.state;
    if (this.Bea == null) {}
    for (;;)
    {
      localObject = new com.tencent.mm.plugin.webview.model.ac(2, str2, str3, str1, (LinkedList)localObject, this.BdW.extData);
      com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
      localObject = new SendAuth.Resp();
      ((SendAuth.Resp)localObject).transaction = this.BdW.transaction;
      ((SendAuth.Resp)localObject).errCode = paramInt;
      ((SendAuth.Resp)localObject).lang = elX();
      ((SendAuth.Resp)localObject).country = getCountry();
      a(str1, (SendAuth.Resp)localObject);
      AppMethodBeat.o(79767);
      return;
      localObject = this.Bea.enJ();
    }
  }
  
  private boolean SP(int paramInt)
  {
    AppMethodBeat.i(79780);
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8))
    {
      ad.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, errType = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(79780);
      return false;
    }
    if (!ay.isConnected(this))
    {
      ad.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, not connected");
      AppMethodBeat.o(79780);
      return false;
    }
    AppMethodBeat.o(79780);
    return true;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, final cne paramcne)
  {
    AppMethodBeat.i(79766);
    ad.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    enB();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ad.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd is_use_newpage %b", new Object[] { Boolean.valueOf(paramcne.DRq) });
      this.Beg = paramcne.jEI;
      if ((paramcne.DRm) || (paramcne.DRn))
      {
        ad.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd direct login");
        c.a(this, com.tencent.mm.model.gdpr.a.gQb, this.mAppId, new com.tencent.mm.model.gdpr.b()
        {
          public final void ns(int paramAnonymousInt)
          {
            AppMethodBeat.i(79739);
            ad.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (paramAnonymousInt == 1)
            {
              SDKOAuthUI.a(SDKOAuthUI.this, -4);
              com.tencent.mm.plugin.webview.j.b.BwR.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), 0, 0, 0);
              SDKOAuthUI.this.finish();
              AppMethodBeat.o(79739);
              return;
            }
            SDKOAuthUI.f(SDKOAuthUI.this).ca(paramcne.CzB, SDKOAuthUI.e(SDKOAuthUI.this).scope.trim().equals("snsapi_wxaapp_info"));
            com.tencent.mm.plugin.webview.j.b.BwR.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 1, SDKOAuthUI.c(SDKOAuthUI.this), 0, 0, 0);
            AppMethodBeat.o(79739);
          }
        });
        AppMethodBeat.o(79766);
        return;
      }
      if (paramcne.DRq)
      {
        if (ai.a(paramcne))
        {
          paramString = (TextView)findViewById(2131296970);
          localObject1 = paramcne.DRk.iterator();
          label251:
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (bty)((Iterator)localObject1).next();
            if ((localObject2 != null) && (("snsapi_userinfo".equals(((bty)localObject2).scope)) || ("snsapi_login".equals(((bty)localObject2).scope)) || ("group_sns_login".equals(((bty)localObject2).scope)))) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (paramInt1 == 0) {
                break label251;
              }
              paramString.setText(((bty)localObject2).desc);
              break;
            }
          }
          paramString.getPaint().setFakeBoldText(true);
          paramString = (TextView)findViewById(2131296971);
          if (!bt.isNullOrNil(paramcne.EhO))
          {
            paramString.setVisibility(0);
            paramString.setText(paramcne.EhO);
          }
          for (;;)
          {
            paramString = (ImageView)findViewById(2131302713);
            localObject1 = (TextView)findViewById(2131302716);
            localObject2 = new c.a();
            ((c.a)localObject2).hkf = 2131690915;
            ((c.a)localObject2).hkm = getResources().getDimension(2131166776);
            ((c.a)localObject2).gkG = true;
            o.ayJ().a(paramcne.DRl, paramString, ((c.a)localObject2).azc());
            ((TextView)localObject1).setText(paramcne.gIw);
            paramString = (Button)findViewById(2131301564);
            localObject1 = (Button)findViewById(2131301567);
            paramString.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(79742);
                SDKOAuthUI.a(SDKOAuthUI.this, paramcne);
                AppMethodBeat.o(79742);
              }
            });
            ((Button)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(79743);
                SDKOAuthUI.f(SDKOAuthUI.this);
                bty localbty = ai.e("snsapi_userinfo", paramcne.DRk);
                paramAnonymousView = localbty;
                if (localbty == null)
                {
                  SDKOAuthUI.f(SDKOAuthUI.this);
                  paramAnonymousView = ai.e("snsapi_login", paramcne.DRk);
                }
                if (paramAnonymousView == null)
                {
                  SDKOAuthUI.f(SDKOAuthUI.this);
                  paramAnonymousView = ai.e("group_sns_login", paramcne.DRk);
                }
                for (;;)
                {
                  com.tencent.mm.plugin.webview.j.b.BwR.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), 2, 1, 0);
                  SDKOAuthUI.a(SDKOAuthUI.this, paramAnonymousView, paramcne);
                  AppMethodBeat.o(79743);
                  return;
                }
              }
            });
            BdY = paramcne.jEF;
            this.Bec = new com.tencent.mm.ui.widget.b.a(this);
            this.Beb = new b(this, paramcne.DRp, paramcne.jEG);
            enH();
            paramString = (ListView)findViewById(2131297012);
            paramString.setAdapter(this.Beb);
            paramString.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
              public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
              {
                AppMethodBeat.i(79744);
                SDKOAuthUI.b.a(SDKOAuthUI.h(SDKOAuthUI.this), SDKOAuthUI.h(SDKOAuthUI.this).Tv(paramAnonymousInt).id);
                SDKOAuthUI.h(SDKOAuthUI.this).notifyDataSetChanged();
                AppMethodBeat.o(79744);
              }
            });
            paramString.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(79745);
                switch (paramAnonymousMotionEvent.getAction())
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(79745);
                  return false;
                  SDKOAuthUI.b(SDKOAuthUI.this, (int)paramAnonymousMotionEvent.getRawX());
                  SDKOAuthUI.c(SDKOAuthUI.this, (int)paramAnonymousMotionEvent.getRawY());
                }
              }
            });
            paramString.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
            {
              public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
              {
                AppMethodBeat.i(79746);
                SDKOAuthUI.d(SDKOAuthUI.this, paramAnonymousInt);
                int i = SDKOAuthUI.h(SDKOAuthUI.this).Tv(paramAnonymousInt).id;
                if ((i != 0) && (i != 1)) {
                  SDKOAuthUI.l(SDKOAuthUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, SDKOAuthUI.this, SDKOAuthUI.i(SDKOAuthUI.this), SDKOAuthUI.j(SDKOAuthUI.this), SDKOAuthUI.k(SDKOAuthUI.this));
                }
                AppMethodBeat.o(79746);
                return true;
              }
            });
            findViewById(2131298852).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(79747);
                paramAnonymousView = new Intent(SDKOAuthUI.this, CreateAvatarUI.class);
                paramAnonymousView.putExtra("0", SDKOAuthUI.a(SDKOAuthUI.this));
                paramAnonymousView.putExtra("default_fileid", SDKOAuthUI.m(SDKOAuthUI.this));
                SDKOAuthUI.this.startActivityForResult(paramAnonymousView, 6);
                AppMethodBeat.o(79747);
              }
            });
            this.Bed = paramcne.jEE;
            if (paramcne.jEE) {
              findViewById(2131298854).setVisibility(8);
            }
            findViewById(2131302797).setVisibility(0);
            AppMethodBeat.o(79766);
            return;
            paramString.setVisibility(8);
          }
        }
        if (ai.e("snsapi_friend", paramcne.DRk) != null)
        {
          a(paramcne, SDKOAuthFriendUI.class, "snsapi_friend");
          ai.aI(this);
          AppMethodBeat.o(79766);
          return;
        }
        if (ai.e("snsapi_wxaapp_info", paramcne.DRk) != null)
        {
          a(paramcne, SDKOAuthFriendUI.class, "snsapi_wxaapp_info");
          ai.aI(this);
          AppMethodBeat.o(79766);
          return;
        }
        a(paramcne, SDKOAuthOtherUI.class, "");
        ai.aI(this);
        AppMethodBeat.o(79766);
        return;
      }
      this.Bef = false;
      paramString = (ImageView)findViewById(2131296853);
      Object localObject1 = (TextView)findViewById(2131296866);
      Object localObject2 = new c.a();
      ((c.a)localObject2).hkf = 2131690915;
      o.ayJ().a(paramcne.DRl, paramString, ((c.a)localObject2).azc());
      ((TextView)localObject1).setText(k.b(this, paramcne.gIw, ((TextView)localObject1).getTextSize()));
      paramString = (ListView)findViewById(2131296973);
      this.Bea = new a(this, paramcne.DRk);
      paramString.setAdapter(this.Bea);
      ((Button)findViewById(2131301562)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(79741);
          ad.i("MicroMsg.SdkOAuthUI", "accept go  MPGdprPolicyUtil.checkPolicy");
          c.a(SDKOAuthUI.this, com.tencent.mm.model.gdpr.a.gQb, SDKOAuthUI.a(SDKOAuthUI.this), new com.tencent.mm.model.gdpr.b()
          {
            public final void ns(int paramAnonymous2Int)
            {
              AppMethodBeat.i(79740);
              ad.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
              if (paramAnonymous2Int == 1)
              {
                SDKOAuthUI.a(SDKOAuthUI.this, -4);
                com.tencent.mm.plugin.webview.j.b.BwR.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), 1, 1, 0);
                SDKOAuthUI.this.finish();
                AppMethodBeat.o(79740);
                return;
              }
              if (SDKOAuthUI.9.this.Bei.DRo)
              {
                SDKOAuthUI.a(SDKOAuthUI.this, SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.e(SDKOAuthUI.this).state, SDKOAuthUI.axQ(SDKOAuthUI.a(SDKOAuthUI.this)), SDKOAuthUI.g(SDKOAuthUI.this).enJ());
                AppMethodBeat.o(79740);
                return;
              }
              com.tencent.mm.plugin.webview.j.b.BwR.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 1, SDKOAuthUI.c(SDKOAuthUI.this), 1, 1, 0);
              SDKOAuthUI.f(SDKOAuthUI.this).ca(SDKOAuthUI.9.this.Bei.CzB, SDKOAuthUI.e(SDKOAuthUI.this).scope.trim().equals("snsapi_wxaapp_info"));
              AppMethodBeat.o(79740);
            }
          });
          AppMethodBeat.o(79741);
        }
      });
      findViewById(2131304239).setVisibility(0);
      AppMethodBeat.o(79766);
      return;
    }
    if (!SP(paramInt1))
    {
      ce(getString(2131766179), true);
      com.tencent.mm.plugin.webview.j.b.BwR.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
      AppMethodBeat.o(79766);
      return;
    }
    com.tencent.mm.plugin.webview.j.b.BwR.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
    ce(paramString, true);
    AppMethodBeat.o(79766);
  }
  
  private void a(cne paramcne, Class<?> paramClass, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79770);
    a(paramcne, paramClass, paramInt1, paramInt2, "");
    AppMethodBeat.o(79770);
  }
  
  private void a(cne paramcne, Class<?> paramClass, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(79771);
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.mAppId);
    if (this.BdW != null)
    {
      paramClass.putExtra("1", this.BdW.transaction);
      paramClass.putExtra("4", this.BdW.state);
      paramClass.putExtra("7", this.BdW.extData);
    }
    paramClass.putExtra("3", paramInt1);
    paramClass.putExtra("5", paramInt2);
    paramClass.putExtra("auth_from_scan", this.BdH);
    paramClass.putExtra("auth_raw_url", this.dAl);
    if (!TextUtils.isEmpty(paramString)) {
      paramClass.putExtra("auth_scope", paramString);
    }
    try
    {
      paramClass.putExtra("2", paramcne.toByteArray());
      paramcne = new com.tencent.mm.hellhoundlib.b.a().bd(paramClass);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramcne.adn(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;IILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramcne.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;IILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(79771);
      return;
    }
    catch (IOException paramcne)
    {
      for (;;)
      {
        ad.e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void a(cne paramcne, Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(79772);
    ad.i("MicroMsg.SdkOAuthUI", "startScopeActivity %s", new Object[] { paramClass.getSimpleName() });
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.mAppId);
    if (this.BdW != null)
    {
      paramClass.putExtra("1", this.BdW.transaction);
      paramClass.putExtra("4", this.BdW.state);
      paramClass.putExtra("7", this.BdW.extData);
    }
    paramClass.putExtra("auth_from_scan", this.BdH);
    if (!TextUtils.isEmpty(paramString)) {
      paramClass.putExtra("auth_scope", paramString);
    }
    paramClass.putExtra("auth_raw_url", this.dAl);
    try
    {
      paramClass.putExtra("2", paramcne.toByteArray());
      paramcne = new com.tencent.mm.hellhoundlib.b.a().bd(paramClass);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramcne.adn(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramcne.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(79772);
      return;
    }
    catch (IOException paramcne)
    {
      for (;;)
      {
        ad.e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void a(String paramString, SendAuth.Resp paramResp)
  {
    AppMethodBeat.i(79769);
    if (this.AYk)
    {
      ad.i("MicroMsg.SdkOAuthUI", "doCallback has callback");
      AppMethodBeat.o(79769);
      return;
    }
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79769);
      return;
    }
    this.AYk = true;
    Bundle localBundle = new Bundle();
    paramResp.toBundle(localBundle);
    com.tencent.mm.pluginsdk.model.app.q.aS(localBundle);
    paramResp = new MMessageActV2.Args();
    paramResp.targetPkgName = paramString;
    paramResp.bundle = localBundle;
    MMessageActV2.send(this, paramResp);
    AppMethodBeat.o(79769);
  }
  
  private static String awu(String paramString)
  {
    AppMethodBeat.i(79783);
    Object localObject = null;
    com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.j(paramString, false, false);
    if (localg != null) {}
    for (paramString = localg.field_packageName;; paramString = localObject)
    {
      AppMethodBeat.o(79783);
      return paramString;
      ad.w("MicroMsg.SdkOAuthUI", "dealWithCancel getAppInfo null; appid: %s", new Object[] { paramString });
    }
  }
  
  private void axP(String paramString)
  {
    AppMethodBeat.i(79776);
    com.tencent.mm.ui.base.h.c(this, paramString, getString(2131761558), true);
    AppMethodBeat.o(79776);
  }
  
  private void bnU()
  {
    AppMethodBeat.i(79777);
    if ((this.ftP != null) && (!this.ftP.isShowing()))
    {
      this.ftP.show();
      AppMethodBeat.o(79777);
      return;
    }
    this.ftP = com.tencent.mm.ui.base.h.b(this, getString(2131761776), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(79735);
        try
        {
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(79735);
          return;
        }
        catch (Exception paramAnonymousDialogInterface)
        {
          ad.e("MicroMsg.SdkOAuthUI", "showProgressDlg onCancel exp: %s ", new Object[] { paramAnonymousDialogInterface.getLocalizedMessage() });
          AppMethodBeat.o(79735);
        }
      }
    });
    AppMethodBeat.o(79777);
  }
  
  private void ce(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(79775);
    com.tencent.mm.ui.base.h.d(this, paramString, getString(2131766178), new DialogInterface.OnClickListener()
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
  
  private void cw(int paramInt, String paramString)
  {
    AppMethodBeat.i(79768);
    String str = awu(this.mAppId);
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.SdkOAuthUI", "dealWithError pkg nil");
      AppMethodBeat.o(79768);
      return;
    }
    SendAuth.Resp localResp = new SendAuth.Resp();
    localResp.transaction = this.BdW.transaction;
    localResp.errCode = paramInt;
    localResp.errStr = paramString;
    localResp.lang = elX();
    localResp.country = getCountry();
    a(str, localResp);
    AppMethodBeat.o(79768);
  }
  
  private String elX()
  {
    AppMethodBeat.i(79781);
    String str = com.tencent.mm.sdk.platformtools.ac.f(getSharedPreferences(aj.eFD(), 0));
    AppMethodBeat.o(79781);
    return str;
  }
  
  private void enB()
  {
    AppMethodBeat.i(79779);
    if (this.ftP == null)
    {
      AppMethodBeat.o(79779);
      return;
    }
    this.ftP.dismiss();
    AppMethodBeat.o(79779);
  }
  
  private int enG()
  {
    if (this.Bef) {
      return 2;
    }
    return 1;
  }
  
  private void enH()
  {
    AppMethodBeat.i(79773);
    if (this.Bed)
    {
      AppMethodBeat.o(79773);
      return;
    }
    if (this.Beb.getCount() >= BdY)
    {
      findViewById(2131298852).setVisibility(8);
      findViewById(2131306223).setVisibility(0);
      findViewById(2131306224).setVisibility(4);
      AppMethodBeat.o(79773);
      return;
    }
    findViewById(2131298852).setVisibility(0);
    findViewById(2131306223).setVisibility(8);
    findViewById(2131306224).setVisibility(0);
    AppMethodBeat.o(79773);
  }
  
  private void enI()
  {
    AppMethodBeat.i(79778);
    enB();
    this.ftP = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(79736);
        try
        {
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(79736);
          return;
        }
        catch (Exception paramAnonymousDialogInterface)
        {
          ad.e("MicroMsg.SdkOAuthUI", "showProgressDlg onCancel exp: %s ", new Object[] { paramAnonymousDialogInterface.getLocalizedMessage() });
          AppMethodBeat.o(79736);
        }
      }
    });
    AppMethodBeat.o(79778);
  }
  
  private static String getCountry()
  {
    AppMethodBeat.i(79782);
    String str = bt.by((String)com.tencent.mm.kernel.g.afB().afk().get(274436, null), null);
    AppMethodBeat.o(79782);
    return str;
  }
  
  public final int getLayoutId()
  {
    return 2131495315;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    AppMethodBeat.i(79774);
    ad.i("MicroMsg.SdkOAuthUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      ad.e("MicroMsg.SdkOAuthUI", "Create avatar cancel or failed");
      AppMethodBeat.o(79774);
      return;
    }
    switch (paramInt1)
    {
    }
    label216:
    for (;;)
    {
      AppMethodBeat.o(79774);
      return;
      btv localbtv = new btv();
      localbtv.id = paramIntent.getIntExtra("id", -1);
      localbtv.nickname = paramIntent.getStringExtra("nickname");
      localbtv.jEL = paramIntent.getStringExtra("avatarurl");
      localbtv.desc = null;
      paramIntent = this.Beb;
      if ((localbtv.id != -1) && (paramIntent.Bem != null) && (paramIntent.Bem.size() < BdY)) {
        paramIntent.Bem.add(localbtv);
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label216;
        }
        b.a(this.Beb, localbtv.id);
        enH();
        this.Beb.notifyDataSetChanged();
        break;
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79761);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    setMMTitle(getString(2131761567));
    setBackBtnVisible(false);
    setTitleBarClickListener(null, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(79732);
        ad.i("MicroMsg.SdkOAuthUI", "BackBtn click");
        com.tencent.mm.plugin.webview.j.b.BwR.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), SDKOAuthUI.d(SDKOAuthUI.this), 1, 0);
        SDKOAuthUI.a(SDKOAuthUI.this, -2);
        SDKOAuthUI.this.finish();
        AppMethodBeat.o(79732);
      }
    });
    if (!com.tencent.mm.kernel.g.afw())
    {
      ad.e("MicroMsg.SdkOAuthUI", "start, hasSetUin fail");
      Toast.makeText(this, 2131755124, 1).show();
      AppMethodBeat.o(79761);
      return;
    }
    this.AYk = false;
    paramBundle = getIntent();
    this.BdH = paramBundle.getBooleanExtra("auth_from_scan", false);
    this.startTime = System.currentTimeMillis();
    ad.i("MicroMsg.SdkOAuthUI", "init isFromQRCodeScan %b", new Object[] { Boolean.valueOf(this.BdH) });
    if (this.BdH)
    {
      this.accountType = 3;
      this.dAl = paramBundle.getStringExtra("auth_raw_url");
      paramBundle = this.dAl;
      ad.i("MicroMsg.SdkOAuthUI", "doQRCodeOauthAuthorize url: %s", new Object[] { paramBundle });
      bnU();
      paramBundle = new z(paramBundle);
      com.tencent.mm.kernel.g.aeS().a(paramBundle, 0);
      this.Bee = new ai(this, null, this.dAl);
      com.tencent.mm.plugin.webview.j.b.BwR.cy(3, "");
      AppMethodBeat.o(79761);
      return;
    }
    paramBundle = getIntent().getExtras();
    String str1 = paramBundle.getString("_mmessage_content");
    if (bt.isNullOrNil(str1))
    {
      ad.e("MicroMsg.SdkOAuthUI", "init content is nil");
      AppMethodBeat.o(79761);
      return;
    }
    this.mAppId = Uri.parse(str1).getQueryParameter("appid");
    if (bt.isNullOrNil(this.mAppId))
    {
      ad.i("MicroMsg.SdkOAuthUI", "parseAppId try case not sensitive, content:%s", new Object[] { str1 });
      this.mAppId = Uri.parse(str1.toLowerCase()).getQueryParameter("appid");
    }
    str1 = this.mAppId;
    Object localObject = com.tencent.mm.pluginsdk.model.app.h.j(str1, false, false);
    if ((localObject != null) && (bt.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject).field_openId)))
    {
      ad.i("MicroMsg.SdkOAuthUI", "checkGetAppSetting appId: %s ", new Object[] { str1 });
      localObject = new ic();
      ((ic)localObject).dlT.appId = str1;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    this.BdW = new SendAuth.Req(paramBundle);
    com.tencent.mm.plugin.webview.j.b.BwR.cy(2, this.BdW.extData);
    this.Bee = new ai(this, this.mAppId, this.BdW.transaction, this.BdW.state, this.BdW.extData);
    if ((this.BdW.scope.contains("snsapi_wxaapp_info")) && (!this.BdW.scope.equals("snsapi_wxaapp_info")))
    {
      cw(-1000, String.format(getContext().getResources().getString(2131766180), new Object[] { "snsapi_wxaapp_info" }));
      finish();
      AppMethodBeat.o(79761);
      return;
    }
    str1 = this.mAppId;
    localObject = this.BdW.scope;
    String str2 = this.BdW.state;
    String str3 = awu(this.mAppId);
    ad.i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorize appid: %s, extData：%s", new Object[] { str1, this.BdW.extData });
    bnU();
    if (bt.isNullOrNil(str3)) {
      paramBundle = null;
    }
    for (;;)
    {
      paramBundle = new com.tencent.mm.plugin.webview.model.ab(str1, (String)localObject, str2, str3, paramBundle, this.BdW.extData);
      com.tencent.mm.kernel.g.aeS().a(paramBundle, 0);
      AppMethodBeat.o(79761);
      return;
      paramBundle = com.tencent.mm.pluginsdk.model.app.q.bJ(this, str3);
      if ((paramBundle == null) || (paramBundle.length == 0))
      {
        ad.e("MicroMsg.SdkOAuthUI", "getSignature signatures failed");
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
    paramContextMenu.add(0, 1, 0, getString(2131761557));
    AppMethodBeat.o(79785);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(79764);
    super.onDestroy();
    if (this.ftP != null) {
      this.ftP.dismiss();
    }
    if (this.BdZ != null) {
      this.BdZ.stopTimer();
    }
    AppMethodBeat.o(79764);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(79765);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      com.tencent.mm.plugin.webview.j.b.BwR.a(this.mAppId, this.startTime, 0, this.accountType, enG(), 1, 0);
      SO(-2);
      ad.i("MicroMsg.SdkOAuthUI", "key back click");
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
    com.tencent.mm.kernel.g.aeS().b(1388, this);
    com.tencent.mm.kernel.g.aeS().b(1346, this);
    com.tencent.mm.kernel.g.aeS().b(2700, this);
    com.tencent.mm.kernel.g.aeS().b(2543, this);
    com.tencent.mm.kernel.g.aeS().b(1137, this);
    AppMethodBeat.o(79763);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(79762);
    super.onResume();
    com.tencent.mm.kernel.g.aeS().a(1346, this);
    com.tencent.mm.kernel.g.aeS().a(1388, this);
    com.tencent.mm.kernel.g.aeS().a(2700, this);
    com.tencent.mm.kernel.g.aeS().a(2543, this);
    com.tencent.mm.kernel.g.aeS().a(1137, this);
    AppMethodBeat.o(79762);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(79784);
    Object localObject;
    if ((paramn instanceof com.tencent.mm.plugin.webview.model.ab))
    {
      a(paramInt1, paramInt2, paramString, (cne)((com.tencent.mm.plugin.webview.model.ab)paramn).rr.gUT.gUX);
      com.tencent.mm.plugin.webview.j.b.BwR.aC(3, (int)(System.currentTimeMillis() - this.startTime), paramInt2);
      if (!(paramn instanceof z)) {
        break label872;
      }
      ad.i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label792;
      }
      localObject = (cdx)((z)paramn).rr.gUT.gUX;
      this.mAppId = ((cdx)localObject).dlB;
      this.Bee.mAppId = ((cdx)localObject).dlB;
      if (!((cdx)localObject).DZZ) {
        break label626;
      }
      ad.i("MicroMsg.SdkOAuthUI", "fallback to h5");
      com.tencent.mm.plugin.webview.j.b.BwR.a(this.mAppId, this.startTime, 1, this.accountType, 0, 0, paramInt2);
      d.b(aj.getContext(), "webview", ".ui.tools.WebViewUI", getIntent());
      ai.aI(this);
      paramInt1 = 1;
      label197:
      if (paramInt1 == 0) {
        enB();
      }
      com.tencent.mm.plugin.webview.j.b.BwR.aC(3, (int)(System.currentTimeMillis() - this.startTime), paramInt2);
    }
    for (;;)
    {
      enB();
      AppMethodBeat.o(79784);
      return;
      if ((paramn instanceof com.tencent.mm.plugin.webview.model.ac))
      {
        ad.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (this.BdZ != null) {
          this.BdZ.stopTimer();
        }
        enB();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject = ((com.tencent.mm.plugin.webview.model.ac)paramn).elN();
          com.tencent.mm.plugin.webview.j.b.BwR.a(this.mAppId, this.startTime, 1, this.accountType, enG(), 1, 0);
          this.Bee.ca(((cnc)localObject).CzB, this.BdW.scope.trim().equals("snsapi_wxaapp_info"));
          break;
        }
        if (!SP(paramInt1))
        {
          ce(getString(2131766179), false);
          com.tencent.mm.plugin.webview.j.b.BwR.a(this.mAppId, this.startTime, 2, this.accountType, enG(), 1, paramInt2);
          break;
        }
        ce(paramString, false);
        com.tencent.mm.plugin.webview.j.b.BwR.a(this.mAppId, this.startTime, 2, this.accountType, enG(), 1, paramInt2);
        break;
      }
      if (!(paramn instanceof com.tencent.mm.modelsimple.g)) {
        break;
      }
      ad.i("MicroMsg.SdkOAuthUI", "onAddAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.Beb.Tv(this.BdX).id == b.a(this.Beb)) {
          b.a(this.Beb, this.Beb.Tv(0).id);
        }
        localObject = this.Beb;
        int i = this.BdX;
        if (((b)localObject).Bem == null) {}
        for (boolean bool = false;; bool = ((b)localObject).Bem.remove(((b)localObject).Tv(i)))
        {
          if (!bool) {
            ad.e("MicroMsg.SdkOAuthUI", "remove avatar failed: not found");
          }
          enH();
          this.Beb.notifyDataSetChanged();
          break;
        }
      }
      if (!SP(paramInt1))
      {
        axP(getString(2131766179));
        break;
      }
      axP(paramString);
      break;
      label626:
      if (localObject == null) {
        paramn = null;
      }
      for (;;)
      {
        a(paramInt1, paramInt2, paramString, paramn);
        paramInt1 = 0;
        break;
        paramn = new cne();
        paramn.BaseResponse = ((cdx)localObject).BaseResponse;
        paramn.DRm = false;
        paramn.DRn = false;
        paramn.DRq = true;
        paramn.DRo = false;
        paramn.DRk = ((cdx)localObject).DRk;
        paramn.gIw = ((cdx)localObject).gIw;
        paramn.DRl = ((cdx)localObject).DRl;
        paramn.CzB = "";
        paramn.DRp = ((cdx)localObject).DRp;
        paramn.jEE = ((cdx)localObject).jEE;
        paramn.jEF = ((cdx)localObject).jEF;
        paramn.jEG = ((cdx)localObject).jEG;
        paramn.jEH = ((cdx)localObject).jEH;
        paramn.jEI = ((cdx)localObject).jEI;
      }
      label792:
      if (!SP(paramInt1))
      {
        ce(getString(2131766179), true);
        com.tencent.mm.plugin.webview.j.b.BwR.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
        paramInt1 = 0;
        break label197;
      }
      com.tencent.mm.plugin.webview.j.b.BwR.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
      ce(paramString, true);
      paramInt1 = 0;
      break label197;
      label872:
      if ((paramn instanceof aa))
      {
        ad.i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        enB();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.plugin.webview.j.b.BwR.a(this.mAppId, this.startTime, 1, this.accountType, enG(), 1, 0);
          finish();
        }
        else if (!SP(paramInt1))
        {
          ce(getString(2131766179), false);
          com.tencent.mm.plugin.webview.j.b.BwR.a(this.mAppId, this.startTime, 2, this.accountType, enG(), 1, paramInt2);
        }
        else
        {
          ce(paramString, false);
          com.tencent.mm.plugin.webview.j.b.BwR.a(this.mAppId, this.startTime, 2, this.accountType, enG(), 1, paramInt2);
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
    private LinkedList<bty> BdS;
    private LayoutInflater mInflater;
    
    public a(Context paramContext, LinkedList<bty> paramLinkedList)
    {
      AppMethodBeat.i(79749);
      this.mInflater = LayoutInflater.from(paramContext);
      this.BdS = paramLinkedList;
      AppMethodBeat.o(79749);
    }
    
    private bty Tu(int paramInt)
    {
      AppMethodBeat.i(79752);
      if ((paramInt >= 0) && (paramInt < this.BdS.size()))
      {
        bty localbty = (bty)this.BdS.get(paramInt);
        AppMethodBeat.o(79752);
        return localbty;
      }
      AppMethodBeat.o(79752);
      return null;
    }
    
    public final LinkedList<String> enJ()
    {
      AppMethodBeat.i(79750);
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < this.BdS.size())
      {
        bty localbty = (bty)this.BdS.get(i);
        if ((localbty.DRs == 2) || (localbty.DRs == 3)) {
          localLinkedList.add(localbty.scope);
        }
        i += 1;
      }
      AppMethodBeat.o(79750);
      return localLinkedList;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(79751);
      if (this.BdS == null)
      {
        AppMethodBeat.o(79751);
        return 0;
      }
      int i = this.BdS.size();
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
      if ((this.BdS == null) || (this.BdS.size() <= 0))
      {
        AppMethodBeat.o(79753);
        return null;
      }
      final bty localbty = Tu(paramInt);
      if (localbty == null)
      {
        AppMethodBeat.o(79753);
        return paramView;
      }
      if (paramView == null)
      {
        paramViewGroup = new a((byte)0);
        paramView = this.mInflater.inflate(2131495313, null, false);
        paramViewGroup.BdV = ((ImageView)paramView.findViewById(2131296682));
        paramViewGroup.lYz = ((TextView)paramView.findViewById(2131296681));
        paramView.setTag(paramViewGroup);
        if (localbty.DRs != 1) {
          break label177;
        }
        paramViewGroup.BdV.setImageResource(2131690740);
      }
      for (;;)
      {
        paramViewGroup.lYz.setText(localbty.desc);
        final ImageView localImageView = paramViewGroup.BdV;
        paramViewGroup.BdV.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(79748);
            if (localbty.DRs == 2)
            {
              localImageView.setImageResource(2131690740);
              localbty.DRs = 1;
              AppMethodBeat.o(79748);
              return;
            }
            if (localbty.DRs == 1)
            {
              localImageView.setImageResource(2131690738);
              localbty.DRs = 2;
            }
            AppMethodBeat.o(79748);
          }
        });
        AppMethodBeat.o(79753);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label177:
        if (localbty.DRs == 3) {
          paramViewGroup.BdV.setImageResource(2131690739);
        } else {
          paramViewGroup.BdV.setImageResource(2131690738);
        }
      }
    }
    
    static final class a
    {
      ImageView BdV;
      TextView lYz;
    }
  }
  
  static final class b
    extends BaseAdapter
  {
    LinkedList<btv> Bem;
    private c.a Ben;
    private Context Beo;
    private int Bep;
    private LayoutInflater mInflater;
    
    public b(Context paramContext, LinkedList<btv> paramLinkedList, int paramInt)
    {
      AppMethodBeat.i(79755);
      this.Beo = paramContext;
      this.mInflater = LayoutInflater.from(paramContext);
      this.Bem = paramLinkedList;
      if (this.Bem == null) {
        this.Bem = new LinkedList();
      }
      ad.i("MicroMsg.SdkOAuthUI", "LoginAvatarListAdapter avatars size:%d", new Object[] { Integer.valueOf(this.Bem.size()) });
      this.Ben = new c.a();
      this.Ben.hkf = 2131690915;
      paramContext = this.Ben;
      paramContext.gkG = true;
      paramContext.hkm = this.Beo.getResources().getDimension(2131166775);
      this.Bep = paramInt;
      AppMethodBeat.o(79755);
    }
    
    public final btv Tv(int paramInt)
    {
      AppMethodBeat.i(79757);
      if ((this.Bem != null) && (paramInt >= 0) && (paramInt < this.Bem.size()))
      {
        btv localbtv = (btv)this.Bem.get(paramInt);
        AppMethodBeat.o(79757);
        return localbtv;
      }
      AppMethodBeat.o(79757);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(79756);
      if (this.Bem == null)
      {
        AppMethodBeat.o(79756);
        return 0;
      }
      int i = this.Bem.size();
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
      btv localbtv = Tv(paramInt);
      if (localbtv == null)
      {
        AppMethodBeat.o(79758);
        return paramView;
      }
      View localView;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localView = this.mInflater.inflate(2131493126, null, false);
        paramView.Beq = ((ImageView)localView.findViewById(2131297005));
        paramView.Ber = ((TextView)localView.findViewById(2131297013));
        paramView.Bes = ((TextView)localView.findViewById(2131297001));
        paramView.Bet = ((ImageView)localView.findViewById(2131297016));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        paramViewGroup.Ber.setText(k.b(this.Beo, localbtv.nickname, paramViewGroup.Ber.getTextSize()));
        o.ayJ().a(localbtv.jEL, paramViewGroup.Beq, this.Ben.azc());
        if (localbtv.desc == null) {
          break label232;
        }
        paramViewGroup.Bes.setText(localbtv.desc);
        paramViewGroup.Bes.setVisibility(0);
        label190:
        if (localbtv.id != this.Bep) {
          break label244;
        }
        paramViewGroup.Bet.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(79758);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label232:
        paramViewGroup.Bes.setVisibility(8);
        break label190;
        label244:
        paramViewGroup.Bet.setVisibility(4);
      }
    }
    
    static final class a
    {
      ImageView Beq;
      TextView Ber;
      TextView Bes;
      ImageView Bet;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI
 * JD-Core Version:    0.7.0.1
 */