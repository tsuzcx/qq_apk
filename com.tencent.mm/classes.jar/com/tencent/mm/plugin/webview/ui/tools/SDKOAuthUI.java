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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.is;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.model.ab;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.ai.a;
import com.tencent.mm.plugin.webview.model.z;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cdx;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.protocal.protobuf.cyn;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.p;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public final class SDKOAuthUI
  extends MMActivity
  implements f
{
  private static int ErU;
  private boolean ElZ;
  private boolean ErD;
  private SendAuth.Req ErS;
  private int ErT;
  private aw ErV;
  private a ErW;
  private b ErX;
  private com.tencent.mm.ui.widget.b.a ErY;
  private boolean ErZ;
  private com.tencent.mm.plugin.webview.model.aj Esa;
  private boolean Esb;
  private String Esc;
  private int accountType;
  private String dLz;
  private p fSP;
  private String mAppId;
  private int oef;
  private int oeg;
  private n.e ogY;
  private long startTime;
  
  public SDKOAuthUI()
  {
    AppMethodBeat.i(79760);
    this.Esb = true;
    this.ErD = false;
    this.accountType = 2;
    this.ogY = new SDKOAuthUI.7(this);
    AppMethodBeat.o(79760);
  }
  
  private void Xt(int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(79767);
    ae.i("MicroMsg.SdkOAuthUI", "dealWithCancel");
    if (this.ErD)
    {
      localObject = new aa(2, this.dLz, null, 0);
      com.tencent.mm.kernel.g.ajj().a((n)localObject, 0);
      AppMethodBeat.o(79767);
      return;
    }
    if (this.ErS == null)
    {
      AppMethodBeat.o(79767);
      return;
    }
    String str1 = aIF(this.mAppId);
    String str2 = this.mAppId;
    String str3 = this.ErS.state;
    if (this.ErW == null) {}
    for (;;)
    {
      localObject = new ac(2, str2, str3, str1, (LinkedList)localObject, this.ErS.extData);
      com.tencent.mm.kernel.g.ajj().a((n)localObject, 0);
      localObject = new SendAuth.Resp();
      ((SendAuth.Resp)localObject).transaction = this.ErS.transaction;
      ((SendAuth.Resp)localObject).errCode = paramInt;
      ((SendAuth.Resp)localObject).lang = eTZ();
      ((SendAuth.Resp)localObject).country = getCountry();
      a(str1, (SendAuth.Resp)localObject);
      AppMethodBeat.o(79767);
      return;
      localObject = this.ErW.eVG();
    }
  }
  
  private boolean Xu(int paramInt)
  {
    AppMethodBeat.i(79780);
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8))
    {
      ae.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, errType = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(79780);
      return false;
    }
    if (!az.isConnected(this))
    {
      ae.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, not connected");
      AppMethodBeat.o(79780);
      return false;
    }
    AppMethodBeat.o(79780);
    return true;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, final cyp paramcyp)
  {
    AppMethodBeat.i(79766);
    ae.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    eVx();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ae.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd is_use_newpage %b", new Object[] { Boolean.valueOf(paramcyp.HqR) });
      this.Esc = paramcyp.kDi;
      if ((paramcyp.HqN) || (paramcyp.HqO))
      {
        ae.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd direct login");
        c.a(this, com.tencent.mm.model.gdpr.a.hLM, this.mAppId, new com.tencent.mm.model.gdpr.b()
        {
          public final void oJ(int paramAnonymousInt)
          {
            AppMethodBeat.i(79739);
            ae.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (paramAnonymousInt == 1)
            {
              SDKOAuthUI.a(SDKOAuthUI.this, -4);
              com.tencent.mm.plugin.webview.j.b.ELt.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), 0, 0, 0);
              SDKOAuthUI.this.finish();
              AppMethodBeat.o(79739);
              return;
            }
            SDKOAuthUI.f(SDKOAuthUI.this).a(ai.a.a(paramcyp), SDKOAuthUI.e(SDKOAuthUI.this).scope);
            com.tencent.mm.plugin.webview.j.b.ELt.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 1, SDKOAuthUI.c(SDKOAuthUI.this), 0, 0, 0);
            AppMethodBeat.o(79739);
          }
        });
        AppMethodBeat.o(79766);
        return;
      }
      if (paramcyp.HqR)
      {
        if (com.tencent.mm.plugin.webview.model.aj.b(paramcyp))
        {
          paramString = (TextView)findViewById(2131296970);
          localObject1 = paramcyp.HqL.iterator();
          label250:
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (cea)((Iterator)localObject1).next();
            if ((localObject2 != null) && (("snsapi_userinfo".equals(((cea)localObject2).scope)) || ("snsapi_login".equals(((cea)localObject2).scope)) || ("group_sns_login".equals(((cea)localObject2).scope)))) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (paramInt1 == 0) {
                break label250;
              }
              paramString.setText(((cea)localObject2).desc);
              break;
            }
          }
          paramString.getPaint().setFakeBoldText(true);
          paramString = (TextView)findViewById(2131296971);
          if (!bu.isNullOrNil(paramcyp.HIN))
          {
            paramString.setVisibility(0);
            paramString.setText(paramcyp.HIN);
          }
          for (;;)
          {
            paramString = (ImageView)findViewById(2131302713);
            localObject1 = (TextView)findViewById(2131302716);
            localObject2 = new c.a();
            ((c.a)localObject2).igv = 2131690915;
            ((c.a)localObject2).igC = getResources().getDimension(2131166776);
            ((c.a)localObject2).hhW = true;
            com.tencent.mm.av.q.aJb().a(paramcyp.HqM, paramString, ((c.a)localObject2).aJu());
            ((TextView)localObject1).setText(paramcyp.hDU);
            paramString = (Button)findViewById(2131301564);
            localObject1 = (Button)findViewById(2131301567);
            paramString.setOnClickListener(new SDKOAuthUI.10(this, paramcyp));
            ((Button)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(79743);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
                SDKOAuthUI.f(SDKOAuthUI.this);
                localObject = com.tencent.mm.plugin.webview.model.aj.e("snsapi_userinfo", paramcyp.HqL);
                paramAnonymousView = (View)localObject;
                if (localObject == null)
                {
                  SDKOAuthUI.f(SDKOAuthUI.this);
                  paramAnonymousView = com.tencent.mm.plugin.webview.model.aj.e("snsapi_login", paramcyp.HqL);
                }
                if (paramAnonymousView == null)
                {
                  SDKOAuthUI.f(SDKOAuthUI.this);
                  paramAnonymousView = com.tencent.mm.plugin.webview.model.aj.e("group_sns_login", paramcyp.HqL);
                }
                for (;;)
                {
                  com.tencent.mm.plugin.webview.j.b.ELt.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), 2, 1, 0);
                  SDKOAuthUI.a(SDKOAuthUI.this, paramAnonymousView, paramcyp);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(79743);
                  return;
                }
              }
            });
            ErU = paramcyp.kDf;
            this.ErY = new com.tencent.mm.ui.widget.b.a(this);
            this.ErX = new b(this, paramcyp.HqQ, paramcyp.kDg);
            eVE();
            paramString = (ListView)findViewById(2131297012);
            paramString.setAdapter(this.ErX);
            paramString.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
              public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
              {
                AppMethodBeat.i(79744);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousAdapterView);
                localb.bd(paramAnonymousView);
                localb.mu(paramAnonymousInt);
                localb.rl(paramAnonymousLong);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
                SDKOAuthUI.b.a(SDKOAuthUI.h(SDKOAuthUI.this), SDKOAuthUI.h(SDKOAuthUI.this).XY(paramAnonymousInt).id);
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
                int i = SDKOAuthUI.h(SDKOAuthUI.this).XY(paramAnonymousInt).id;
                if ((i != 0) && (i != 1)) {
                  SDKOAuthUI.l(SDKOAuthUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, SDKOAuthUI.this, SDKOAuthUI.i(SDKOAuthUI.this), SDKOAuthUI.j(SDKOAuthUI.this), SDKOAuthUI.k(SDKOAuthUI.this));
                }
                AppMethodBeat.o(79746);
                return true;
              }
            });
            findViewById(2131298852).setOnClickListener(new SDKOAuthUI.15(this));
            this.ErZ = paramcyp.kDe;
            if (paramcyp.kDe) {
              findViewById(2131298854).setVisibility(8);
            }
            findViewById(2131302797).setVisibility(0);
            AppMethodBeat.o(79766);
            return;
            paramString.setVisibility(8);
          }
        }
        if (com.tencent.mm.plugin.webview.model.aj.e("snsapi_friend", paramcyp.HqL) != null)
        {
          a(paramcyp, SDKOAuthFriendUI.class, "snsapi_friend");
          com.tencent.mm.plugin.webview.model.aj.aN(this);
          AppMethodBeat.o(79766);
          return;
        }
        if (com.tencent.mm.plugin.webview.model.aj.e("snsapi_wxaapp_info", paramcyp.HqL) != null)
        {
          a(paramcyp, SDKOAuthFriendUI.class, "snsapi_wxaapp_info");
          com.tencent.mm.plugin.webview.model.aj.aN(this);
          AppMethodBeat.o(79766);
          return;
        }
        a(paramcyp, SDKOAuthOtherUI.class, "");
        com.tencent.mm.plugin.webview.model.aj.aN(this);
        AppMethodBeat.o(79766);
        return;
      }
      this.Esb = false;
      paramString = (ImageView)findViewById(2131296853);
      Object localObject1 = (TextView)findViewById(2131296866);
      Object localObject2 = new c.a();
      ((c.a)localObject2).igv = 2131690915;
      com.tencent.mm.av.q.aJb().a(paramcyp.HqM, paramString, ((c.a)localObject2).aJu());
      ((TextView)localObject1).setText(k.b(this, paramcyp.hDU, ((TextView)localObject1).getTextSize()));
      paramString = (ListView)findViewById(2131296973);
      this.ErW = new a(this, paramcyp.HqL);
      paramString.setAdapter(this.ErW);
      ((Button)findViewById(2131301562)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(79741);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicroMsg.SdkOAuthUI", "accept go  MPGdprPolicyUtil.checkPolicy");
          c.a(SDKOAuthUI.this, com.tencent.mm.model.gdpr.a.hLM, SDKOAuthUI.a(SDKOAuthUI.this), new com.tencent.mm.model.gdpr.b()
          {
            public final void oJ(int paramAnonymous2Int)
            {
              AppMethodBeat.i(79740);
              ae.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
              if (paramAnonymous2Int == 1)
              {
                SDKOAuthUI.a(SDKOAuthUI.this, -4);
                com.tencent.mm.plugin.webview.j.b.ELt.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), 1, 1, 0);
                SDKOAuthUI.this.finish();
                AppMethodBeat.o(79740);
                return;
              }
              if (SDKOAuthUI.9.this.Ese.HqP)
              {
                SDKOAuthUI.a(SDKOAuthUI.this, SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.e(SDKOAuthUI.this).state, SDKOAuthUI.aKc(SDKOAuthUI.a(SDKOAuthUI.this)), SDKOAuthUI.g(SDKOAuthUI.this).eVG());
                AppMethodBeat.o(79740);
                return;
              }
              com.tencent.mm.plugin.webview.j.b.ELt.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 1, SDKOAuthUI.c(SDKOAuthUI.this), 1, 1, 0);
              SDKOAuthUI.f(SDKOAuthUI.this).a(ai.a.a(SDKOAuthUI.9.this.Ese), SDKOAuthUI.e(SDKOAuthUI.this).scope);
              AppMethodBeat.o(79740);
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(79741);
        }
      });
      findViewById(2131304239).setVisibility(0);
      AppMethodBeat.o(79766);
      return;
    }
    if (!Xu(paramInt1))
    {
      cv(getString(2131766179), true);
      com.tencent.mm.plugin.webview.j.b.ELt.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
      AppMethodBeat.o(79766);
      return;
    }
    com.tencent.mm.plugin.webview.j.b.ELt.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
    cv(paramString, true);
    AppMethodBeat.o(79766);
  }
  
  private void a(cyp paramcyp, Class<?> paramClass, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79770);
    a(paramcyp, paramClass, paramInt1, paramInt2, "");
    AppMethodBeat.o(79770);
  }
  
  private void a(cyp paramcyp, Class<?> paramClass, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(79771);
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.mAppId);
    if (this.ErS != null)
    {
      paramClass.putExtra("1", this.ErS.transaction);
      paramClass.putExtra("4", this.ErS.state);
      paramClass.putExtra("7", this.ErS.extData);
    }
    paramClass.putExtra("3", paramInt1);
    paramClass.putExtra("5", paramInt2);
    paramClass.putExtra("auth_from_scan", this.ErD);
    paramClass.putExtra("auth_raw_url", this.dLz);
    if (!TextUtils.isEmpty(paramString)) {
      paramClass.putExtra("auth_scope", paramString);
    }
    try
    {
      paramClass.putExtra("2", paramcyp.toByteArray());
      paramcyp = new com.tencent.mm.hellhoundlib.b.a().bc(paramClass);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramcyp.ahE(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;IILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramcyp.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;IILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(79771);
      return;
    }
    catch (IOException paramcyp)
    {
      for (;;)
      {
        ae.e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void a(cyp paramcyp, Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(79772);
    ae.i("MicroMsg.SdkOAuthUI", "startScopeActivity %s", new Object[] { paramClass.getSimpleName() });
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.mAppId);
    if (this.ErS != null)
    {
      paramClass.putExtra("1", this.ErS.transaction);
      paramClass.putExtra("4", this.ErS.state);
      paramClass.putExtra("7", this.ErS.extData);
    }
    paramClass.putExtra("auth_from_scan", this.ErD);
    if (!TextUtils.isEmpty(paramString)) {
      paramClass.putExtra("auth_scope", paramString);
    }
    paramClass.putExtra("auth_raw_url", this.dLz);
    try
    {
      paramClass.putExtra("2", paramcyp.toByteArray());
      paramcyp = new com.tencent.mm.hellhoundlib.b.a().bc(paramClass);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramcyp.ahE(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramcyp.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(79772);
      return;
    }
    catch (IOException paramcyp)
    {
      for (;;)
      {
        ae.e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void a(String paramString, SendAuth.Resp paramResp)
  {
    AppMethodBeat.i(79769);
    if (this.ElZ)
    {
      ae.i("MicroMsg.SdkOAuthUI", "doCallback has callback");
      AppMethodBeat.o(79769);
      return;
    }
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79769);
      return;
    }
    this.ElZ = true;
    Bundle localBundle = new Bundle();
    paramResp.toBundle(localBundle);
    com.tencent.mm.pluginsdk.model.app.q.bc(localBundle);
    paramResp = new MMessageActV2.Args();
    paramResp.targetPkgName = paramString;
    paramResp.bundle = localBundle;
    MMessageActV2.send(this, paramResp);
    AppMethodBeat.o(79769);
  }
  
  private static String aIF(String paramString)
  {
    AppMethodBeat.i(79783);
    Object localObject = null;
    com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.m(paramString, false, false);
    if (localg != null) {}
    for (paramString = localg.field_packageName;; paramString = localObject)
    {
      AppMethodBeat.o(79783);
      return paramString;
      ae.w("MicroMsg.SdkOAuthUI", "dealWithCancel getAppInfo null; appid: %s", new Object[] { paramString });
    }
  }
  
  private void aKb(String paramString)
  {
    AppMethodBeat.i(79776);
    com.tencent.mm.ui.base.h.c(this, paramString, getString(2131761558), true);
    AppMethodBeat.o(79776);
  }
  
  private void bzQ()
  {
    AppMethodBeat.i(79777);
    if ((this.fSP != null) && (!this.fSP.isShowing()))
    {
      this.fSP.show();
      AppMethodBeat.o(79777);
      return;
    }
    this.fSP = com.tencent.mm.ui.base.h.b(this, getString(2131761776), true, new SDKOAuthUI.4(this));
    AppMethodBeat.o(79777);
  }
  
  private void cF(int paramInt, String paramString)
  {
    AppMethodBeat.i(79768);
    String str = aIF(this.mAppId);
    if (bu.isNullOrNil(str))
    {
      ae.e("MicroMsg.SdkOAuthUI", "dealWithError pkg nil");
      AppMethodBeat.o(79768);
      return;
    }
    SendAuth.Resp localResp = new SendAuth.Resp();
    localResp.transaction = this.ErS.transaction;
    localResp.errCode = paramInt;
    localResp.errStr = paramString;
    localResp.lang = eTZ();
    localResp.country = getCountry();
    a(str, localResp);
    AppMethodBeat.o(79768);
  }
  
  private void cv(final String paramString, final boolean paramBoolean)
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
  
  private String eTZ()
  {
    AppMethodBeat.i(79781);
    String str = ad.f(getSharedPreferences(ak.fow(), 0));
    AppMethodBeat.o(79781);
    return str;
  }
  
  private int eVD()
  {
    if (this.Esb) {
      return 2;
    }
    return 1;
  }
  
  private void eVE()
  {
    AppMethodBeat.i(79773);
    if (this.ErZ)
    {
      AppMethodBeat.o(79773);
      return;
    }
    if (this.ErX.getCount() >= ErU)
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
  
  private void eVF()
  {
    AppMethodBeat.i(79778);
    eVx();
    this.fSP = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new SDKOAuthUI.5(this));
    AppMethodBeat.o(79778);
  }
  
  private void eVx()
  {
    AppMethodBeat.i(79779);
    if (this.fSP == null)
    {
      AppMethodBeat.o(79779);
      return;
    }
    this.fSP.dismiss();
    AppMethodBeat.o(79779);
  }
  
  private static String getCountry()
  {
    AppMethodBeat.i(79782);
    String str = bu.bI((String)com.tencent.mm.kernel.g.ajR().ajA().get(274436, null), null);
    AppMethodBeat.o(79782);
    return str;
  }
  
  public final int getLayoutId()
  {
    return 2131495315;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(79774);
    ae.i("MicroMsg.SdkOAuthUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      ae.e("MicroMsg.SdkOAuthUI", "Create avatar cancel or failed");
      AppMethodBeat.o(79774);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(79774);
      return;
    }
    cdx localcdx = new cdx();
    localcdx.id = paramIntent.getIntExtra("id", -1);
    localcdx.nickname = paramIntent.getStringExtra("nickname");
    localcdx.kDl = paramIntent.getStringExtra("avatarurl");
    localcdx.desc = null;
    if (this.ErX != null)
    {
      paramIntent = this.ErX;
      if ((localcdx.id != -1) && (paramIntent.Esi != null) && (paramIntent.Esi.size() < ErU)) {
        paramIntent.Esi.add(localcdx);
      }
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        b.a(this.ErX, localcdx.id);
        eVE();
        this.ErX.notifyDataSetChanged();
        AppMethodBeat.o(79774);
        return;
      }
    }
    if (this.ErX == null) {}
    for (;;)
    {
      ae.e("MicroMsg.SdkOAuthUI", "onActivityResult mAvatarAdapter == null:%b", new Object[] { Boolean.valueOf(bool) });
      break;
      bool = false;
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
        ae.i("MicroMsg.SdkOAuthUI", "BackBtn click");
        com.tencent.mm.plugin.webview.j.b.ELt.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), SDKOAuthUI.d(SDKOAuthUI.this), 1, 0);
        SDKOAuthUI.a(SDKOAuthUI.this, -2);
        SDKOAuthUI.this.finish();
        AppMethodBeat.o(79732);
      }
    });
    if (!com.tencent.mm.kernel.g.ajM())
    {
      ae.e("MicroMsg.SdkOAuthUI", "start, hasSetUin fail");
      Toast.makeText(this, 2131755124, 1).show();
      AppMethodBeat.o(79761);
      return;
    }
    this.ElZ = false;
    paramBundle = getIntent();
    this.ErD = paramBundle.getBooleanExtra("auth_from_scan", false);
    this.startTime = System.currentTimeMillis();
    ae.i("MicroMsg.SdkOAuthUI", "init isFromQRCodeScan %b", new Object[] { Boolean.valueOf(this.ErD) });
    if (this.ErD)
    {
      this.accountType = 3;
      this.dLz = paramBundle.getStringExtra("auth_raw_url");
      paramBundle = this.dLz;
      ae.i("MicroMsg.SdkOAuthUI", "doQRCodeOauthAuthorize url: %s", new Object[] { paramBundle });
      bzQ();
      paramBundle = new z(paramBundle);
      com.tencent.mm.kernel.g.ajj().a(paramBundle, 0);
      this.Esa = new com.tencent.mm.plugin.webview.model.aj(this, null, this.dLz);
      com.tencent.mm.plugin.webview.j.b.ELt.cH(3, "");
      AppMethodBeat.o(79761);
      return;
    }
    paramBundle = getIntent().getExtras();
    String str1 = paramBundle.getString("_mmessage_content");
    if (bu.isNullOrNil(str1))
    {
      ae.e("MicroMsg.SdkOAuthUI", "init content is nil");
      AppMethodBeat.o(79761);
      return;
    }
    this.mAppId = Uri.parse(str1).getQueryParameter("appid");
    if (bu.isNullOrNil(this.mAppId))
    {
      ae.i("MicroMsg.SdkOAuthUI", "parseAppId try case not sensitive, content:%s", new Object[] { str1 });
      this.mAppId = Uri.parse(str1.toLowerCase()).getQueryParameter("appid");
    }
    str1 = this.mAppId;
    Object localObject = com.tencent.mm.pluginsdk.model.app.h.m(str1, false, false);
    if ((localObject != null) && (bu.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject).field_openId)))
    {
      ae.i("MicroMsg.SdkOAuthUI", "checkGetAppSetting appId: %s ", new Object[] { str1 });
      localObject = new is();
      ((is)localObject).dwt.appId = str1;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    }
    this.ErS = new SendAuth.Req(paramBundle);
    com.tencent.mm.plugin.webview.j.b.ELt.cH(2, this.ErS.extData);
    this.Esa = new com.tencent.mm.plugin.webview.model.aj(this, this.mAppId, this.ErS.transaction, this.ErS.state, this.ErS.extData);
    if ((!bu.isNullOrNil(this.ErS.scope)) && (this.ErS.scope.contains("snsapi_wxaapp_info")) && (!this.ErS.scope.equals("snsapi_wxaapp_info")))
    {
      cF(-1000, String.format(getContext().getResources().getString(2131766180), new Object[] { "snsapi_wxaapp_info" }));
      finish();
      AppMethodBeat.o(79761);
      return;
    }
    str1 = this.mAppId;
    localObject = this.ErS.scope;
    String str2 = this.ErS.state;
    String str3 = aIF(this.mAppId);
    ae.i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorize appid: %s, extData：%s", new Object[] { str1, this.ErS.extData });
    bzQ();
    if (bu.isNullOrNil(str3)) {
      paramBundle = null;
    }
    for (;;)
    {
      paramBundle = new ab(str1, (String)localObject, str2, str3, paramBundle, this.ErS.extData);
      com.tencent.mm.kernel.g.ajj().a(paramBundle, 0);
      AppMethodBeat.o(79761);
      return;
      paramBundle = com.tencent.mm.pluginsdk.model.app.q.bP(this, str3);
      if ((paramBundle == null) || (paramBundle.length == 0))
      {
        ae.e("MicroMsg.SdkOAuthUI", "getSignature signatures failed");
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
    if (this.fSP != null) {
      this.fSP.dismiss();
    }
    if (this.ErV != null) {
      this.ErV.stopTimer();
    }
    AppMethodBeat.o(79764);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(79765);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      com.tencent.mm.plugin.webview.j.b.ELt.a(this.mAppId, this.startTime, 0, this.accountType, eVD(), 1, 0);
      Xt(-2);
      ae.i("MicroMsg.SdkOAuthUI", "key back click");
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
    com.tencent.mm.kernel.g.ajj().b(1388, this);
    com.tencent.mm.kernel.g.ajj().b(1346, this);
    com.tencent.mm.kernel.g.ajj().b(2700, this);
    com.tencent.mm.kernel.g.ajj().b(2543, this);
    com.tencent.mm.kernel.g.ajj().b(1137, this);
    AppMethodBeat.o(79763);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(79762);
    super.onResume();
    com.tencent.mm.kernel.g.ajj().a(1346, this);
    com.tencent.mm.kernel.g.ajj().a(1388, this);
    com.tencent.mm.kernel.g.ajj().a(2700, this);
    com.tencent.mm.kernel.g.ajj().a(2543, this);
    com.tencent.mm.kernel.g.ajj().a(1137, this);
    AppMethodBeat.o(79762);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(79784);
    Object localObject;
    if ((paramn instanceof ab))
    {
      a(paramInt1, paramInt2, paramString, (cyp)((ab)paramn).rr.hQE.hQJ);
      com.tencent.mm.plugin.webview.j.b.ELt.aG(3, (int)(System.currentTimeMillis() - this.startTime), paramInt2);
      if (!(paramn instanceof z)) {
        break label863;
      }
      ae.i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label783;
      }
      localObject = (cou)((z)paramn).rr.hQE.hQJ;
      this.mAppId = ((cou)localObject).dwb;
      this.Esa.mAppId = ((cou)localObject).dwb;
      if (!((cou)localObject).HAz) {
        break label617;
      }
      ae.i("MicroMsg.SdkOAuthUI", "fallback to h5");
      com.tencent.mm.plugin.webview.j.b.ELt.a(this.mAppId, this.startTime, 1, this.accountType, 0, 0, paramInt2);
      d.b(ak.getContext(), "webview", ".ui.tools.WebViewUI", getIntent());
      com.tencent.mm.plugin.webview.model.aj.aN(this);
      paramInt1 = 1;
      label197:
      if (paramInt1 == 0) {
        eVx();
      }
      com.tencent.mm.plugin.webview.j.b.ELt.aG(3, (int)(System.currentTimeMillis() - this.startTime), paramInt2);
    }
    for (;;)
    {
      eVx();
      AppMethodBeat.o(79784);
      return;
      if ((paramn instanceof ac))
      {
        ae.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (this.ErV != null) {
          this.ErV.stopTimer();
        }
        eVx();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject = ((ac)paramn).eTN();
          com.tencent.mm.plugin.webview.j.b.ELt.a(this.mAppId, this.startTime, 1, this.accountType, eVD(), 1, 0);
          this.Esa.a(ai.a.a((cyn)localObject), this.ErS.scope);
          break;
        }
        if (!Xu(paramInt1))
        {
          cv(getString(2131766179), false);
          com.tencent.mm.plugin.webview.j.b.ELt.a(this.mAppId, this.startTime, 2, this.accountType, eVD(), 1, paramInt2);
          break;
        }
        cv(paramString, false);
        com.tencent.mm.plugin.webview.j.b.ELt.a(this.mAppId, this.startTime, 2, this.accountType, eVD(), 1, paramInt2);
        break;
      }
      if (!(paramn instanceof com.tencent.mm.modelsimple.h)) {
        break;
      }
      ae.i("MicroMsg.SdkOAuthUI", "onAddAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.ErX.XY(this.ErT).id == b.a(this.ErX)) {
          b.a(this.ErX, this.ErX.XY(0).id);
        }
        localObject = this.ErX;
        int i = this.ErT;
        if (((b)localObject).Esi == null) {}
        for (boolean bool = false;; bool = ((b)localObject).Esi.remove(((b)localObject).XY(i)))
        {
          if (!bool) {
            ae.e("MicroMsg.SdkOAuthUI", "remove avatar failed: not found");
          }
          eVE();
          this.ErX.notifyDataSetChanged();
          break;
        }
      }
      if (!Xu(paramInt1))
      {
        aKb(getString(2131766179));
        break;
      }
      aKb(paramString);
      break;
      label617:
      if (localObject == null) {
        paramn = null;
      }
      for (;;)
      {
        a(paramInt1, paramInt2, paramString, paramn);
        paramInt1 = 0;
        break;
        paramn = new cyp();
        paramn.BaseResponse = ((cou)localObject).BaseResponse;
        paramn.HqN = false;
        paramn.HqO = false;
        paramn.HqR = true;
        paramn.HqP = false;
        paramn.HqL = ((cou)localObject).HqL;
        paramn.hDU = ((cou)localObject).hDU;
        paramn.HqM = ((cou)localObject).HqM;
        paramn.FPO = "";
        paramn.HqQ = ((cou)localObject).HqQ;
        paramn.kDe = ((cou)localObject).kDe;
        paramn.kDf = ((cou)localObject).kDf;
        paramn.kDg = ((cou)localObject).kDg;
        paramn.kDh = ((cou)localObject).kDh;
        paramn.kDi = ((cou)localObject).kDi;
      }
      label783:
      if (!Xu(paramInt1))
      {
        cv(getString(2131766179), true);
        com.tencent.mm.plugin.webview.j.b.ELt.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
        paramInt1 = 0;
        break label197;
      }
      com.tencent.mm.plugin.webview.j.b.ELt.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
      cv(paramString, true);
      paramInt1 = 0;
      break label197;
      label863:
      if ((paramn instanceof aa))
      {
        ae.i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        eVx();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.plugin.webview.j.b.ELt.a(this.mAppId, this.startTime, 1, this.accountType, eVD(), 1, 0);
          finish();
        }
        else if (!Xu(paramInt1))
        {
          cv(getString(2131766179), false);
          com.tencent.mm.plugin.webview.j.b.ELt.a(this.mAppId, this.startTime, 2, this.accountType, eVD(), 1, paramInt2);
        }
        else
        {
          cv(paramString, false);
          com.tencent.mm.plugin.webview.j.b.ELt.a(this.mAppId, this.startTime, 2, this.accountType, eVD(), 1, paramInt2);
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
    private LinkedList<cea> ErO;
    private LayoutInflater mInflater;
    
    public a(Context paramContext, LinkedList<cea> paramLinkedList)
    {
      AppMethodBeat.i(79749);
      this.mInflater = LayoutInflater.from(paramContext);
      this.ErO = paramLinkedList;
      AppMethodBeat.o(79749);
    }
    
    private cea XX(int paramInt)
    {
      AppMethodBeat.i(79752);
      if ((paramInt >= 0) && (paramInt < this.ErO.size()))
      {
        cea localcea = (cea)this.ErO.get(paramInt);
        AppMethodBeat.o(79752);
        return localcea;
      }
      AppMethodBeat.o(79752);
      return null;
    }
    
    public final LinkedList<String> eVG()
    {
      AppMethodBeat.i(79750);
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < this.ErO.size())
      {
        cea localcea = (cea)this.ErO.get(i);
        if ((localcea.HqT == 2) || (localcea.HqT == 3)) {
          localLinkedList.add(localcea.scope);
        }
        i += 1;
      }
      AppMethodBeat.o(79750);
      return localLinkedList;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(79751);
      if (this.ErO == null)
      {
        AppMethodBeat.o(79751);
        return 0;
      }
      int i = this.ErO.size();
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
      if ((this.ErO == null) || (this.ErO.size() <= 0))
      {
        AppMethodBeat.o(79753);
        return null;
      }
      final cea localcea = XX(paramInt);
      if (localcea == null)
      {
        AppMethodBeat.o(79753);
        return paramView;
      }
      if (paramView == null)
      {
        paramViewGroup = new a((byte)0);
        paramView = this.mInflater.inflate(2131495313, null, false);
        paramViewGroup.ErR = ((ImageView)paramView.findViewById(2131296682));
        paramViewGroup.ngr = ((TextView)paramView.findViewById(2131296681));
        paramView.setTag(paramViewGroup);
        if (localcea.HqT != 1) {
          break label177;
        }
        paramViewGroup.ErR.setImageResource(2131690740);
      }
      for (;;)
      {
        paramViewGroup.ngr.setText(localcea.desc);
        final ImageView localImageView = paramViewGroup.ErR;
        paramViewGroup.ErR.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(79748);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (localcea.HqT == 2)
            {
              localImageView.setImageResource(2131690740);
              localcea.HqT = 1;
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(79748);
              return;
              if (localcea.HqT == 1)
              {
                localImageView.setImageResource(2131690738);
                localcea.HqT = 2;
              }
            }
          }
        });
        AppMethodBeat.o(79753);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label177:
        if (localcea.HqT == 3) {
          paramViewGroup.ErR.setImageResource(2131690739);
        } else {
          paramViewGroup.ErR.setImageResource(2131690738);
        }
      }
    }
    
    static final class a
    {
      ImageView ErR;
      TextView ngr;
    }
  }
  
  static final class b
    extends BaseAdapter
  {
    LinkedList<cdx> Esi;
    private c.a Esj;
    private Context Esk;
    private int Esl;
    private LayoutInflater mInflater;
    
    public b(Context paramContext, LinkedList<cdx> paramLinkedList, int paramInt)
    {
      AppMethodBeat.i(79755);
      this.Esk = paramContext;
      this.mInflater = LayoutInflater.from(paramContext);
      this.Esi = paramLinkedList;
      if (this.Esi == null) {
        this.Esi = new LinkedList();
      }
      ae.i("MicroMsg.SdkOAuthUI", "LoginAvatarListAdapter avatars size:%d", new Object[] { Integer.valueOf(this.Esi.size()) });
      this.Esj = new c.a();
      this.Esj.igv = 2131690915;
      paramContext = this.Esj;
      paramContext.hhW = true;
      paramContext.igC = this.Esk.getResources().getDimension(2131166775);
      this.Esl = paramInt;
      AppMethodBeat.o(79755);
    }
    
    public final cdx XY(int paramInt)
    {
      AppMethodBeat.i(79757);
      if ((this.Esi != null) && (paramInt >= 0) && (paramInt < this.Esi.size()))
      {
        cdx localcdx = (cdx)this.Esi.get(paramInt);
        AppMethodBeat.o(79757);
        return localcdx;
      }
      AppMethodBeat.o(79757);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(79756);
      if (this.Esi == null)
      {
        AppMethodBeat.o(79756);
        return 0;
      }
      int i = this.Esi.size();
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
      cdx localcdx = XY(paramInt);
      if (localcdx == null)
      {
        AppMethodBeat.o(79758);
        return paramView;
      }
      View localView;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localView = this.mInflater.inflate(2131493126, null, false);
        paramView.Esm = ((ImageView)localView.findViewById(2131297005));
        paramView.Esn = ((TextView)localView.findViewById(2131297013));
        paramView.Eso = ((TextView)localView.findViewById(2131297001));
        paramView.Esp = ((ImageView)localView.findViewById(2131297016));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        paramViewGroup.Esn.setText(k.b(this.Esk, localcdx.nickname, paramViewGroup.Esn.getTextSize()));
        com.tencent.mm.av.q.aJb().a(localcdx.kDl, paramViewGroup.Esm, this.Esj.aJu());
        if (localcdx.desc == null) {
          break label232;
        }
        paramViewGroup.Eso.setText(localcdx.desc);
        paramViewGroup.Eso.setVisibility(0);
        label190:
        if (localcdx.id != this.Esl) {
          break label244;
        }
        paramViewGroup.Esp.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(79758);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label232:
        paramViewGroup.Eso.setVisibility(8);
        break label190;
        label244:
        paramViewGroup.Esp.setVisibility(4);
      }
    }
    
    static final class a
    {
      ImageView Esm;
      TextView Esn;
      TextView Eso;
      ImageView Esp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI
 * JD-Core Version:    0.7.0.1
 */