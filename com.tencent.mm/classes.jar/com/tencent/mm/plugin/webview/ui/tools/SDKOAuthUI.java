package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.f.a.jx;
import com.tencent.mm.kernel.f;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.model.ab;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.ai.a;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.model.z;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.ddg;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.protocal.protobuf.dqo;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.protocal.protobuf.ebg;
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
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public final class SDKOAuthUI
  extends MMActivity
  implements i
{
  private static int Qce;
  private int Omq;
  private boolean PVr;
  private boolean QbN;
  private SendAuth.Req Qcc;
  private int Qcd;
  private MTimerHandler Qcf;
  private SDKOAuthUI.a Qcg;
  private SDKOAuthUI.b Qch;
  private com.tencent.mm.ui.widget.b.a Qci;
  private boolean Qcj;
  private aj Qck;
  private boolean Qcl;
  private String Qcm;
  private String fXu;
  private s jhZ;
  private String mAppId;
  private q.g sBv;
  private long startTime;
  private int syc;
  private int syd;
  
  public SDKOAuthUI()
  {
    AppMethodBeat.i(79760);
    this.Qcl = true;
    this.QbN = false;
    this.Omq = 2;
    this.sBv = new q.g()
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
  
  private void a(int paramInt1, int paramInt2, String paramString, final ebg paramebg)
  {
    AppMethodBeat.i(79766);
    Log.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    gXr();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      boolean bool = paramebg.TLe;
      if (paramebg.Ugc != null) {}
      for (paramInt1 = paramebg.Ugc.UH.length;; paramInt1 = 0)
      {
        Log.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd is_use_newpage %b, bufferSize=%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
        this.Qcm = paramebg.oDS;
        this.Qck.PVt = paramebg.Ugc;
        if ((!paramebg.TLa) && (!paramebg.TLb)) {
          break;
        }
        Log.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd direct login");
        com.tencent.mm.model.gdpr.c.a(this, com.tencent.mm.model.gdpr.a.lwQ, this.mAppId, new com.tencent.mm.model.gdpr.b()
        {
          public final void vu(int paramAnonymousInt)
          {
            AppMethodBeat.i(79739);
            Log.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (paramAnonymousInt == 1)
            {
              SDKOAuthUI.a(SDKOAuthUI.this, -4);
              com.tencent.mm.plugin.webview.k.b.QzJ.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), 0, 0, 0);
              SDKOAuthUI.this.finish();
              AppMethodBeat.o(79739);
              return;
            }
            SDKOAuthUI.f(SDKOAuthUI.this).a(ai.a.a(paramebg), SDKOAuthUI.e(SDKOAuthUI.this).scope);
            com.tencent.mm.plugin.webview.k.b.QzJ.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 1, SDKOAuthUI.c(SDKOAuthUI.this), 0, 0, 0);
            AppMethodBeat.o(79739);
          }
        });
        AppMethodBeat.o(79766);
        return;
      }
      if (paramebg.TLe)
      {
        if (aj.b(paramebg))
        {
          paramString = (TextView)findViewById(c.f.auth_content);
          localObject1 = paramebg.TKY.iterator();
          label293:
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ddj)((Iterator)localObject1).next();
            if ((localObject2 != null) && (("snsapi_userinfo".equals(((ddj)localObject2).scope)) || ("snsapi_login".equals(((ddj)localObject2).scope)) || ("group_sns_login".equals(((ddj)localObject2).scope)))) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (paramInt1 == 0) {
                break label293;
              }
              paramString.setText(((ddj)localObject2).desc);
              break;
            }
          }
          paramString.getPaint().setFakeBoldText(true);
          paramString = (TextView)findViewById(c.f.auth_content_detail);
          if (!Util.isNullOrNil(paramebg.Ugj))
          {
            paramString.setVisibility(0);
            paramString.setText(paramebg.Ugj);
          }
          for (;;)
          {
            paramString = (ImageView)findViewById(c.f.new_app_icon_iv);
            localObject1 = (TextView)findViewById(c.f.new_app_name_tv);
            localObject2 = new c.a();
            ((c.a)localObject2).lRP = c.h.native_oauth_default_head_img;
            ((c.a)localObject2).lRW = getResources().getDimension(c.d.sdk_oauth_header_corners_size);
            ((c.a)localObject2).kPz = true;
            com.tencent.mm.ay.q.bml().a(paramebg.TKZ, paramString, ((c.a)localObject2).bmL());
            ((TextView)localObject1).setText(paramebg.lnp);
            paramString = (Button)findViewById(c.f.login_btn_agree_new);
            localObject1 = (Button)findViewById(c.f.login_btn_disagree_new);
            paramString.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(79742);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                SDKOAuthUI.a(SDKOAuthUI.this, paramebg);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(79742);
              }
            });
            ((Button)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(79743);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
                SDKOAuthUI.f(SDKOAuthUI.this);
                localObject = aj.f("snsapi_userinfo", paramebg.TKY);
                paramAnonymousView = (View)localObject;
                if (localObject == null)
                {
                  SDKOAuthUI.f(SDKOAuthUI.this);
                  paramAnonymousView = aj.f("snsapi_login", paramebg.TKY);
                }
                if (paramAnonymousView == null)
                {
                  SDKOAuthUI.f(SDKOAuthUI.this);
                  paramAnonymousView = aj.f("group_sns_login", paramebg.TKY);
                }
                for (;;)
                {
                  com.tencent.mm.plugin.webview.k.b.QzJ.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), 2, 1, 0);
                  SDKOAuthUI.a(SDKOAuthUI.this, paramAnonymousView, paramebg);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(79743);
                  return;
                }
              }
            });
            Qce = paramebg.oDP;
            this.Qci = new com.tencent.mm.ui.widget.b.a(this);
            this.Qch = new SDKOAuthUI.b(this, paramebg.TLd, paramebg.oDQ);
            gXy();
            paramString = (ListView)findViewById(c.f.avatar_list);
            paramString.setAdapter(this.Qch);
            paramString.setOnItemClickListener(new SDKOAuthUI.12(this));
            paramString.setOnTouchListener(new SDKOAuthUI.13(this));
            paramString.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
            {
              public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
              {
                AppMethodBeat.i(79746);
                SDKOAuthUI.d(SDKOAuthUI.this, paramAnonymousInt);
                int i = SDKOAuthUI.h(SDKOAuthUI.this).aou(paramAnonymousInt).id;
                if ((i != 0) && (i != 1)) {
                  SDKOAuthUI.l(SDKOAuthUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, SDKOAuthUI.this, SDKOAuthUI.i(SDKOAuthUI.this), SDKOAuthUI.j(SDKOAuthUI.this), SDKOAuthUI.k(SDKOAuthUI.this));
                }
                AppMethodBeat.o(79746);
                return true;
              }
            });
            findViewById(c.f.create_avatar).setOnClickListener(new SDKOAuthUI.15(this));
            this.Qcj = paramebg.oDO;
            if (paramebg.oDO) {
              findViewById(c.f.create_avatar_entry).setVisibility(8);
            }
            findViewById(c.f.new_root).setVisibility(0);
            AppMethodBeat.o(79766);
            return;
            paramString.setVisibility(8);
          }
        }
        if (aj.f("snsapi_friend", paramebg.TKY) != null)
        {
          a(paramebg, SDKOAuthFriendUI.class, "snsapi_friend");
          aj.aY(this);
          AppMethodBeat.o(79766);
          return;
        }
        if (aj.f("snsapi_wxaapp_info", paramebg.TKY) != null)
        {
          a(paramebg, SDKOAuthFriendUI.class, "snsapi_wxaapp_info");
          aj.aY(this);
          AppMethodBeat.o(79766);
          return;
        }
        a(paramebg, SDKOAuthOtherUI.class, "");
        aj.aY(this);
        AppMethodBeat.o(79766);
        return;
      }
      this.Qcl = false;
      paramString = (ImageView)findViewById(c.f.app_icon_iv);
      Object localObject1 = (TextView)findViewById(c.f.app_name_tv);
      Object localObject2 = new c.a();
      ((c.a)localObject2).lRP = c.h.native_oauth_default_head_img;
      com.tencent.mm.ay.q.bml().a(paramebg.TKZ, paramString, ((c.a)localObject2).bmL());
      ((TextView)localObject1).setText(l.b(this, paramebg.lnp, ((TextView)localObject1).getTextSize()));
      paramString = (ListView)findViewById(c.f.auth_content_list);
      this.Qcg = new SDKOAuthUI.a(this, paramebg.TKY);
      paramString.setAdapter(this.Qcg);
      ((Button)findViewById(c.f.login_btn)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(79741);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.SdkOAuthUI", "accept go  MPGdprPolicyUtil.checkPolicy");
          com.tencent.mm.model.gdpr.c.a(SDKOAuthUI.this, com.tencent.mm.model.gdpr.a.lwQ, SDKOAuthUI.a(SDKOAuthUI.this), new com.tencent.mm.model.gdpr.b()
          {
            public final void vu(int paramAnonymous2Int)
            {
              AppMethodBeat.i(79740);
              Log.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
              if (paramAnonymous2Int == 1)
              {
                SDKOAuthUI.a(SDKOAuthUI.this, -4);
                com.tencent.mm.plugin.webview.k.b.QzJ.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), 1, 1, 0);
                SDKOAuthUI.this.finish();
                AppMethodBeat.o(79740);
                return;
              }
              if (SDKOAuthUI.9.this.Qco.TLc)
              {
                SDKOAuthUI.a(SDKOAuthUI.this, SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.e(SDKOAuthUI.this).state, SDKOAuthUI.bme(SDKOAuthUI.a(SDKOAuthUI.this)), SDKOAuthUI.g(SDKOAuthUI.this).gXA());
                AppMethodBeat.o(79740);
                return;
              }
              com.tencent.mm.plugin.webview.k.b.QzJ.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 1, SDKOAuthUI.c(SDKOAuthUI.this), 1, 1, 0);
              SDKOAuthUI.f(SDKOAuthUI.this).a(ai.a.a(SDKOAuthUI.9.this.Qco), SDKOAuthUI.e(SDKOAuthUI.this).scope);
              AppMethodBeat.o(79740);
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(79741);
        }
      });
      findViewById(c.f.root).setVisibility(0);
      AppMethodBeat.o(79766);
      return;
    }
    if (!anQ(paramInt1))
    {
      de(getString(c.i.wechat_auth_network_failed), true);
      com.tencent.mm.plugin.webview.k.b.QzJ.a(this.mAppId, this.startTime, 2, this.Omq, 0, 0, paramInt2);
      AppMethodBeat.o(79766);
      return;
    }
    com.tencent.mm.plugin.webview.k.b.QzJ.a(this.mAppId, this.startTime, 2, this.Omq, 0, 0, paramInt2);
    de(paramString, true);
    AppMethodBeat.o(79766);
  }
  
  private void a(ebg paramebg, Class<?> paramClass, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79770);
    a(paramebg, paramClass, paramInt1, paramInt2, "");
    AppMethodBeat.o(79770);
  }
  
  private void a(ebg paramebg, Class<?> paramClass, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(79771);
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.mAppId);
    if (this.Qcc != null)
    {
      paramClass.putExtra("1", this.Qcc.transaction);
      paramClass.putExtra("4", this.Qcc.state);
      paramClass.putExtra("7", this.Qcc.extData);
    }
    paramClass.putExtra("3", paramInt1);
    paramClass.putExtra("5", paramInt2);
    paramClass.putExtra("auth_from_scan", this.QbN);
    paramClass.putExtra("auth_raw_url", this.fXu);
    if (!TextUtils.isEmpty(paramString)) {
      paramClass.putExtra("auth_scope", paramString);
    }
    try
    {
      paramClass.putExtra("2", paramebg.toByteArray());
      paramebg = new com.tencent.mm.hellhoundlib.b.a().bm(paramClass);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramebg.aFh(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;IILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramebg.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;IILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(79771);
      return;
    }
    catch (IOException paramebg)
    {
      for (;;)
      {
        Log.e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void a(ebg paramebg, Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(79772);
    Log.i("MicroMsg.SdkOAuthUI", "startScopeActivity %s", new Object[] { paramClass.getSimpleName() });
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.mAppId);
    if (this.Qcc != null)
    {
      paramClass.putExtra("1", this.Qcc.transaction);
      paramClass.putExtra("4", this.Qcc.state);
      paramClass.putExtra("7", this.Qcc.extData);
    }
    paramClass.putExtra("auth_from_scan", this.QbN);
    if (!TextUtils.isEmpty(paramString)) {
      paramClass.putExtra("auth_scope", paramString);
    }
    paramClass.putExtra("auth_raw_url", this.fXu);
    try
    {
      paramClass.putExtra("2", paramebg.toByteArray());
      paramebg = new com.tencent.mm.hellhoundlib.b.a().bm(paramClass);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramebg.aFh(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramebg.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(79772);
      return;
    }
    catch (IOException paramebg)
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
    if (this.PVr)
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
    this.PVr = true;
    Bundle localBundle = new Bundle();
    paramResp.toBundle(localBundle);
    com.tencent.mm.pluginsdk.model.app.q.bm(localBundle);
    paramResp = new MMessageActV2.Args();
    paramResp.targetPkgName = paramString;
    paramResp.bundle = localBundle;
    MMessageActV2.send(this, paramResp);
    AppMethodBeat.o(79769);
  }
  
  private void anP(int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(79767);
    Log.i("MicroMsg.SdkOAuthUI", "dealWithCancel");
    if (this.QbN)
    {
      localObject = new aa(2, this.fXu, null, 0);
      com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject, 0);
      AppMethodBeat.o(79767);
      return;
    }
    if (this.Qcc == null)
    {
      AppMethodBeat.o(79767);
      return;
    }
    String str1 = bkA(this.mAppId);
    String str2 = this.mAppId;
    String str3 = this.Qcc.state;
    if (this.Qcg == null) {}
    for (;;)
    {
      localObject = new ac(2, str2, str3, str1, (LinkedList)localObject, 0, this.Qcc.extData, this.Qck.PVt);
      com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject, 0);
      localObject = new SendAuth.Resp();
      ((SendAuth.Resp)localObject).transaction = this.Qcc.transaction;
      ((SendAuth.Resp)localObject).errCode = paramInt;
      ((SendAuth.Resp)localObject).lang = gVJ();
      ((SendAuth.Resp)localObject).country = getCountry();
      a(str1, (SendAuth.Resp)localObject);
      AppMethodBeat.o(79767);
      return;
      localObject = this.Qcg.gXA();
    }
  }
  
  private boolean anQ(int paramInt)
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
  
  private static String bkA(String paramString)
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
  
  private void bmd(String paramString)
  {
    AppMethodBeat.i(79776);
    com.tencent.mm.ui.base.h.c(this, paramString, getString(c.i.new_sdk_oauth_login_delavatar_failed), true);
    AppMethodBeat.o(79776);
  }
  
  private void cY(int paramInt, String paramString)
  {
    AppMethodBeat.i(79768);
    String str = bkA(this.mAppId);
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.SdkOAuthUI", "dealWithError pkg nil");
      AppMethodBeat.o(79768);
      return;
    }
    SendAuth.Resp localResp = new SendAuth.Resp();
    localResp.transaction = this.Qcc.transaction;
    localResp.errCode = paramInt;
    localResp.errStr = paramString;
    localResp.lang = gVJ();
    localResp.country = getCountry();
    a(str, localResp);
    AppMethodBeat.o(79768);
  }
  
  private void cjp()
  {
    AppMethodBeat.i(79777);
    if ((this.jhZ != null) && (!this.jhZ.isShowing()))
    {
      this.jhZ.show();
      AppMethodBeat.o(79777);
      return;
    }
    this.jhZ = com.tencent.mm.ui.base.h.a(this, getString(c.i.oauth_logining), true, new SDKOAuthUI.4(this));
    AppMethodBeat.o(79777);
  }
  
  private void de(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(79775);
    com.tencent.mm.ui.base.h.d(this, paramString, getString(c.i.wechat_auth_failed), new DialogInterface.OnClickListener()
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
  
  private String gVJ()
  {
    AppMethodBeat.i(79781);
    String str = LocaleUtil.loadApplicationLanguage(getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this);
    AppMethodBeat.o(79781);
    return str;
  }
  
  private void gXr()
  {
    AppMethodBeat.i(79779);
    if (this.jhZ == null)
    {
      AppMethodBeat.o(79779);
      return;
    }
    this.jhZ.dismiss();
    AppMethodBeat.o(79779);
  }
  
  private int gXx()
  {
    if (this.Qcl) {
      return 2;
    }
    return 1;
  }
  
  private void gXy()
  {
    AppMethodBeat.i(79773);
    if (this.Qcj)
    {
      AppMethodBeat.o(79773);
      return;
    }
    if (this.Qch.getCount() >= Qce)
    {
      findViewById(c.f.create_avatar).setVisibility(8);
      findViewById(c.f.upper_bound_hint).setVisibility(0);
      findViewById(c.f.upper_bound_hint_line).setVisibility(4);
      AppMethodBeat.o(79773);
      return;
    }
    findViewById(c.f.create_avatar).setVisibility(0);
    findViewById(c.f.upper_bound_hint).setVisibility(8);
    findViewById(c.f.upper_bound_hint_line).setVisibility(0);
    AppMethodBeat.o(79773);
  }
  
  private void gXz()
  {
    AppMethodBeat.i(79778);
    gXr();
    this.jhZ = com.tencent.mm.ui.base.h.a(this, getString(c.i.app_waiting), true, new SDKOAuthUI.5(this));
    AppMethodBeat.o(79778);
  }
  
  private static String getCountry()
  {
    AppMethodBeat.i(79782);
    String str = Util.nullAs((String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null), null);
    AppMethodBeat.o(79782);
    return str;
  }
  
  public final int getLayoutId()
  {
    return c.g.sdk_oauth;
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
    ddg localddg = new ddg();
    localddg.id = paramIntent.getIntExtra("id", -1);
    localddg.nickname = paramIntent.getStringExtra("nickname");
    localddg.oDV = paramIntent.getStringExtra("avatarurl");
    localddg.desc = null;
    if (this.Qch != null)
    {
      paramIntent = this.Qch;
      if ((localddg.id != -1) && (paramIntent.Qcs != null) && (paramIntent.Qcs.size() < Qce)) {
        paramIntent.Qcs.add(localddg);
      }
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        SDKOAuthUI.b.a(this.Qch, localddg.id);
        gXy();
        this.Qch.notifyDataSetChanged();
        AppMethodBeat.o(79774);
        return;
      }
    }
    if (this.Qch == null) {}
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
    com.tencent.mm.kernel.h.aGY().a(1346, this);
    com.tencent.mm.kernel.h.aGY().a(1388, this);
    com.tencent.mm.kernel.h.aGY().a(2700, this);
    com.tencent.mm.kernel.h.aGY().a(2543, this);
    com.tencent.mm.kernel.h.aGY().a(1137, this);
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    ((TextView)findViewById(c.f.leftClose)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216300);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.SdkOAuthUI", "BackBtn click");
        com.tencent.mm.plugin.webview.k.b.QzJ.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), SDKOAuthUI.d(SDKOAuthUI.this), 1, 0);
        SDKOAuthUI.a(SDKOAuthUI.this, -2);
        SDKOAuthUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216300);
      }
    });
    if (!com.tencent.mm.kernel.h.aHB())
    {
      Log.e("MicroMsg.SdkOAuthUI", "start, hasSetUin fail");
      Toast.makeText(this, c.i.account_not_login, 1).show();
      AppMethodBeat.o(79761);
      return;
    }
    this.PVr = false;
    paramBundle = getIntent();
    this.QbN = paramBundle.getBooleanExtra("auth_from_scan", false);
    this.startTime = System.currentTimeMillis();
    Log.i("MicroMsg.SdkOAuthUI", "init isFromQRCodeScan %b", new Object[] { Boolean.valueOf(this.QbN) });
    if (this.QbN)
    {
      this.Omq = 3;
      this.fXu = paramBundle.getStringExtra("auth_raw_url");
      paramBundle = this.fXu;
      Log.i("MicroMsg.SdkOAuthUI", "doQRCodeOauthAuthorize url: %s", new Object[] { paramBundle });
      cjp();
      paramBundle = new z(paramBundle);
      com.tencent.mm.kernel.h.aGY().a(paramBundle, 0);
      this.Qck = new aj(this, null, this.fXu);
      com.tencent.mm.plugin.webview.k.b.QzJ.da(3, "");
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
      localObject = new jx();
      ((jx)localObject).fHl.appId = str1;
      EventCenter.instance.publish((IEvent)localObject);
    }
    this.Qcc = new SendAuth.Req(paramBundle);
    com.tencent.mm.plugin.webview.k.b.QzJ.da(2, this.Qcc.extData);
    this.Qck = new aj(this, this.mAppId, this.Qcc.transaction, this.Qcc.state, this.Qcc.extData);
    if ((!Util.isNullOrNil(this.Qcc.scope)) && (this.Qcc.scope.contains("snsapi_wxaapp_info")) && (!this.Qcc.scope.equals("snsapi_wxaapp_info")))
    {
      cY(-1000, String.format(getContext().getResources().getString(c.i.wechat_auth_scope_can_only_authorized_separately), new Object[] { "snsapi_wxaapp_info" }));
      finish();
      AppMethodBeat.o(79761);
      return;
    }
    str1 = this.mAppId;
    localObject = this.Qcc.scope;
    String str2 = this.Qcc.state;
    String str3 = bkA(this.mAppId);
    Log.i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorize appid: %s, extData：%s", new Object[] { str1, this.Qcc.extData });
    cjp();
    if (Util.isNullOrNil(str3)) {
      paramBundle = null;
    }
    for (;;)
    {
      paramBundle = new ab(str1, (String)localObject, str2, str3, paramBundle, this.Qcc.extData);
      com.tencent.mm.kernel.h.aGY().a(paramBundle, 0);
      AppMethodBeat.o(79761);
      return;
      paramBundle = com.tencent.mm.pluginsdk.model.app.q.cv(this, str3);
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
    paramContextMenu.add(0, 1, 0, getString(c.i.new_sdk_oauth_login_delavatar));
    AppMethodBeat.o(79785);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(79764);
    super.onDestroy();
    if (this.jhZ != null) {
      this.jhZ.dismiss();
    }
    if (this.Qcf != null) {
      this.Qcf.stopTimer();
    }
    com.tencent.mm.kernel.h.aGY().b(1388, this);
    com.tencent.mm.kernel.h.aGY().b(1346, this);
    com.tencent.mm.kernel.h.aGY().b(2700, this);
    com.tencent.mm.kernel.h.aGY().b(2543, this);
    com.tencent.mm.kernel.h.aGY().b(1137, this);
    AppMethodBeat.o(79764);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(79765);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      com.tencent.mm.plugin.webview.k.b.QzJ.a(this.mAppId, this.startTime, 0, this.Omq, gXx(), 1, 0);
      anP(-2);
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(79784);
    Object localObject;
    if ((paramq instanceof ab))
    {
      a(paramInt1, paramInt2, paramString, (ebg)d.c.b(((ab)paramq).rr.lBS));
      com.tencent.mm.plugin.webview.k.b.QzJ.aS(3, (int)(System.currentTimeMillis() - this.startTime), paramInt2);
      if (!(paramq instanceof z)) {
        break label863;
      }
      Log.i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label783;
      }
      localObject = (dqo)d.c.b(((z)paramq).rr.lBS);
      this.mAppId = ((dqo)localObject).appid;
      this.Qck.mAppId = ((dqo)localObject).appid;
      if (!((dqo)localObject).TXf) {
        break label617;
      }
      Log.i("MicroMsg.SdkOAuthUI", "fallback to h5");
      com.tencent.mm.plugin.webview.k.b.QzJ.a(this.mAppId, this.startTime, 1, this.Omq, 0, 0, paramInt2);
      com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", getIntent());
      aj.aY(this);
      paramInt1 = 1;
      label197:
      if (paramInt1 == 0) {
        gXr();
      }
      com.tencent.mm.plugin.webview.k.b.QzJ.aS(3, (int)(System.currentTimeMillis() - this.startTime), paramInt2);
    }
    for (;;)
    {
      gXr();
      AppMethodBeat.o(79784);
      return;
      if ((paramq instanceof ac))
      {
        Log.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (this.Qcf != null) {
          this.Qcf.stopTimer();
        }
        gXr();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject = ((ac)paramq).gVv();
          com.tencent.mm.plugin.webview.k.b.QzJ.a(this.mAppId, this.startTime, 1, this.Omq, gXx(), 1, 0);
          this.Qck.a(ai.a.a((ebe)localObject), this.Qcc.scope);
          break;
        }
        if (!anQ(paramInt1))
        {
          de(getString(c.i.wechat_auth_network_failed), false);
          com.tencent.mm.plugin.webview.k.b.QzJ.a(this.mAppId, this.startTime, 2, this.Omq, gXx(), 1, paramInt2);
          break;
        }
        de(paramString, false);
        com.tencent.mm.plugin.webview.k.b.QzJ.a(this.mAppId, this.startTime, 2, this.Omq, gXx(), 1, paramInt2);
        break;
      }
      if (!(paramq instanceof com.tencent.mm.modelsimple.h)) {
        break;
      }
      Log.i("MicroMsg.SdkOAuthUI", "onAddAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.Qch.aou(this.Qcd).id == SDKOAuthUI.b.a(this.Qch)) {
          SDKOAuthUI.b.a(this.Qch, this.Qch.aou(0).id);
        }
        localObject = this.Qch;
        int i = this.Qcd;
        if (((SDKOAuthUI.b)localObject).Qcs == null) {}
        for (boolean bool = false;; bool = ((SDKOAuthUI.b)localObject).Qcs.remove(((SDKOAuthUI.b)localObject).aou(i)))
        {
          if (!bool) {
            Log.e("MicroMsg.SdkOAuthUI", "remove avatar failed: not found");
          }
          gXy();
          this.Qch.notifyDataSetChanged();
          break;
        }
      }
      if (!anQ(paramInt1))
      {
        bmd(getString(c.i.wechat_auth_network_failed));
        break;
      }
      bmd(paramString);
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
        paramq = new ebg();
        paramq.BaseResponse = ((dqo)localObject).BaseResponse;
        paramq.TLa = false;
        paramq.TLb = false;
        paramq.TLe = true;
        paramq.TLc = false;
        paramq.TKY = ((dqo)localObject).TKY;
        paramq.lnp = ((dqo)localObject).lnp;
        paramq.TKZ = ((dqo)localObject).TKZ;
        paramq.SjB = "";
        paramq.TLd = ((dqo)localObject).TLd;
        paramq.oDO = ((dqo)localObject).oDO;
        paramq.oDP = ((dqo)localObject).oDP;
        paramq.oDQ = ((dqo)localObject).oDQ;
        paramq.oDR = ((dqo)localObject).oDR;
        paramq.oDS = ((dqo)localObject).oDS;
      }
      label783:
      if (!anQ(paramInt1))
      {
        de(getString(c.i.wechat_auth_network_failed), true);
        com.tencent.mm.plugin.webview.k.b.QzJ.a(this.mAppId, this.startTime, 2, this.Omq, 0, 0, paramInt2);
        paramInt1 = 0;
        break label197;
      }
      com.tencent.mm.plugin.webview.k.b.QzJ.a(this.mAppId, this.startTime, 2, this.Omq, 0, 0, paramInt2);
      de(paramString, true);
      paramInt1 = 0;
      break label197;
      label863:
      if ((paramq instanceof aa))
      {
        Log.i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        gXr();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.plugin.webview.k.b.QzJ.a(this.mAppId, this.startTime, 1, this.Omq, gXx(), 1, 0);
          finish();
        }
        else if (!anQ(paramInt1))
        {
          de(getString(c.i.wechat_auth_network_failed), false);
          com.tencent.mm.plugin.webview.k.b.QzJ.a(this.mAppId, this.startTime, 2, this.Omq, gXx(), 1, paramInt2);
        }
        else
        {
          de(paramString, false);
          com.tencent.mm.plugin.webview.k.b.QzJ.a(this.mAppId, this.startTime, 2, this.Omq, gXx(), 1, paramInt2);
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI
 * JD-Core Version:    0.7.0.1
 */