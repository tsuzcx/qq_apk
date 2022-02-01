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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.model.ab;
import com.tencent.mm.plugin.webview.model.ai.a;
import com.tencent.mm.plugin.webview.model.z;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cdd;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.protocal.protobuf.coa;
import com.tencent.mm.protocal.protobuf.cxt;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
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
  private static int DZS;
  private boolean DTZ;
  private boolean DZB;
  private SendAuth.Req DZQ;
  private int DZR;
  private av DZT;
  private a DZU;
  private b DZV;
  private com.tencent.mm.ui.widget.b.a DZW;
  private boolean DZX;
  private com.tencent.mm.plugin.webview.model.aj DZY;
  private boolean DZZ;
  private String Eaa;
  private int accountType;
  private String dKk;
  private p fQJ;
  private String mAppId;
  private int nYw;
  private int nYx;
  private n.e obh;
  private long startTime;
  
  public SDKOAuthUI()
  {
    AppMethodBeat.i(79760);
    this.DZZ = true;
    this.DZB = false;
    this.accountType = 2;
    this.obh = new SDKOAuthUI.7(this);
    AppMethodBeat.o(79760);
  }
  
  private void WM(int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(79767);
    ad.i("MicroMsg.SdkOAuthUI", "dealWithCancel");
    if (this.DZB)
    {
      localObject = new aa(2, this.dKk, null, 0);
      com.tencent.mm.kernel.g.aiU().a((n)localObject, 0);
      AppMethodBeat.o(79767);
      return;
    }
    if (this.DZQ == null)
    {
      AppMethodBeat.o(79767);
      return;
    }
    String str1 = aHm(this.mAppId);
    String str2 = this.mAppId;
    String str3 = this.DZQ.state;
    if (this.DZU == null) {}
    for (;;)
    {
      localObject = new com.tencent.mm.plugin.webview.model.ac(2, str2, str3, str1, (LinkedList)localObject, this.DZQ.extData);
      com.tencent.mm.kernel.g.aiU().a((n)localObject, 0);
      localObject = new SendAuth.Resp();
      ((SendAuth.Resp)localObject).transaction = this.DZQ.transaction;
      ((SendAuth.Resp)localObject).errCode = paramInt;
      ((SendAuth.Resp)localObject).lang = eQn();
      ((SendAuth.Resp)localObject).country = getCountry();
      a(str1, (SendAuth.Resp)localObject);
      AppMethodBeat.o(79767);
      return;
      localObject = this.DZU.eRU();
    }
  }
  
  private boolean WN(int paramInt)
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
  
  private void a(int paramInt1, int paramInt2, String paramString, final cxv paramcxv)
  {
    AppMethodBeat.i(79766);
    ad.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    eRL();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ad.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd is_use_newpage %b", new Object[] { Boolean.valueOf(paramcxv.GXr) });
      this.Eaa = paramcxv.kzT;
      if ((paramcxv.GXn) || (paramcxv.GXo))
      {
        ad.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd direct login");
        c.a(this, com.tencent.mm.model.gdpr.a.hIT, this.mAppId, new com.tencent.mm.model.gdpr.b()
        {
          public final void oG(int paramAnonymousInt)
          {
            AppMethodBeat.i(79739);
            ad.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (paramAnonymousInt == 1)
            {
              SDKOAuthUI.a(SDKOAuthUI.this, -4);
              com.tencent.mm.plugin.webview.j.b.EsZ.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), 0, 0, 0);
              SDKOAuthUI.this.finish();
              AppMethodBeat.o(79739);
              return;
            }
            SDKOAuthUI.f(SDKOAuthUI.this).a(ai.a.a(paramcxv), SDKOAuthUI.e(SDKOAuthUI.this).scope);
            com.tencent.mm.plugin.webview.j.b.EsZ.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 1, SDKOAuthUI.c(SDKOAuthUI.this), 0, 0, 0);
            AppMethodBeat.o(79739);
          }
        });
        AppMethodBeat.o(79766);
        return;
      }
      if (paramcxv.GXr)
      {
        if (com.tencent.mm.plugin.webview.model.aj.b(paramcxv))
        {
          paramString = (TextView)findViewById(2131296970);
          localObject1 = paramcxv.GXl.iterator();
          label250:
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (cdg)((Iterator)localObject1).next();
            if ((localObject2 != null) && (("snsapi_userinfo".equals(((cdg)localObject2).scope)) || ("snsapi_login".equals(((cdg)localObject2).scope)) || ("group_sns_login".equals(((cdg)localObject2).scope)))) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (paramInt1 == 0) {
                break label250;
              }
              paramString.setText(((cdg)localObject2).desc);
              break;
            }
          }
          paramString.getPaint().setFakeBoldText(true);
          paramString = (TextView)findViewById(2131296971);
          if (!bt.isNullOrNil(paramcxv.Hpl))
          {
            paramString.setVisibility(0);
            paramString.setText(paramcxv.Hpl);
          }
          for (;;)
          {
            paramString = (ImageView)findViewById(2131302713);
            localObject1 = (TextView)findViewById(2131302716);
            localObject2 = new c.a();
            ((c.a)localObject2).idD = 2131690915;
            ((c.a)localObject2).idK = getResources().getDimension(2131166776);
            ((c.a)localObject2).hfi = true;
            com.tencent.mm.aw.q.aIJ().a(paramcxv.GXm, paramString, ((c.a)localObject2).aJc());
            ((TextView)localObject1).setText(paramcxv.hBg);
            paramString = (Button)findViewById(2131301564);
            localObject1 = (Button)findViewById(2131301567);
            paramString.setOnClickListener(new SDKOAuthUI.10(this, paramcxv));
            ((Button)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(79743);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
                SDKOAuthUI.f(SDKOAuthUI.this);
                localObject = com.tencent.mm.plugin.webview.model.aj.e("snsapi_userinfo", paramcxv.GXl);
                paramAnonymousView = (View)localObject;
                if (localObject == null)
                {
                  SDKOAuthUI.f(SDKOAuthUI.this);
                  paramAnonymousView = com.tencent.mm.plugin.webview.model.aj.e("snsapi_login", paramcxv.GXl);
                }
                if (paramAnonymousView == null)
                {
                  SDKOAuthUI.f(SDKOAuthUI.this);
                  paramAnonymousView = com.tencent.mm.plugin.webview.model.aj.e("group_sns_login", paramcxv.GXl);
                }
                for (;;)
                {
                  com.tencent.mm.plugin.webview.j.b.EsZ.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), 2, 1, 0);
                  SDKOAuthUI.a(SDKOAuthUI.this, paramAnonymousView, paramcxv);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(79743);
                  return;
                }
              }
            });
            DZS = paramcxv.kzQ;
            this.DZW = new com.tencent.mm.ui.widget.b.a(this);
            this.DZV = new b(this, paramcxv.GXq, paramcxv.kzR);
            eRS();
            paramString = (ListView)findViewById(2131297012);
            paramString.setAdapter(this.DZV);
            paramString.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
              public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
              {
                AppMethodBeat.i(79744);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousAdapterView);
                localb.bd(paramAnonymousView);
                localb.mr(paramAnonymousInt);
                localb.qY(paramAnonymousLong);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
                SDKOAuthUI.b.a(SDKOAuthUI.h(SDKOAuthUI.this), SDKOAuthUI.h(SDKOAuthUI.this).Xs(paramAnonymousInt).id);
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
                int i = SDKOAuthUI.h(SDKOAuthUI.this).Xs(paramAnonymousInt).id;
                if ((i != 0) && (i != 1)) {
                  SDKOAuthUI.l(SDKOAuthUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, SDKOAuthUI.this, SDKOAuthUI.i(SDKOAuthUI.this), SDKOAuthUI.j(SDKOAuthUI.this), SDKOAuthUI.k(SDKOAuthUI.this));
                }
                AppMethodBeat.o(79746);
                return true;
              }
            });
            findViewById(2131298852).setOnClickListener(new SDKOAuthUI.15(this));
            this.DZX = paramcxv.kzP;
            if (paramcxv.kzP) {
              findViewById(2131298854).setVisibility(8);
            }
            findViewById(2131302797).setVisibility(0);
            AppMethodBeat.o(79766);
            return;
            paramString.setVisibility(8);
          }
        }
        if (com.tencent.mm.plugin.webview.model.aj.e("snsapi_friend", paramcxv.GXl) != null)
        {
          a(paramcxv, SDKOAuthFriendUI.class, "snsapi_friend");
          com.tencent.mm.plugin.webview.model.aj.aM(this);
          AppMethodBeat.o(79766);
          return;
        }
        if (com.tencent.mm.plugin.webview.model.aj.e("snsapi_wxaapp_info", paramcxv.GXl) != null)
        {
          a(paramcxv, SDKOAuthFriendUI.class, "snsapi_wxaapp_info");
          com.tencent.mm.plugin.webview.model.aj.aM(this);
          AppMethodBeat.o(79766);
          return;
        }
        a(paramcxv, SDKOAuthOtherUI.class, "");
        com.tencent.mm.plugin.webview.model.aj.aM(this);
        AppMethodBeat.o(79766);
        return;
      }
      this.DZZ = false;
      paramString = (ImageView)findViewById(2131296853);
      Object localObject1 = (TextView)findViewById(2131296866);
      Object localObject2 = new c.a();
      ((c.a)localObject2).idD = 2131690915;
      com.tencent.mm.aw.q.aIJ().a(paramcxv.GXm, paramString, ((c.a)localObject2).aJc());
      ((TextView)localObject1).setText(k.b(this, paramcxv.hBg, ((TextView)localObject1).getTextSize()));
      paramString = (ListView)findViewById(2131296973);
      this.DZU = new a(this, paramcxv.GXl);
      paramString.setAdapter(this.DZU);
      ((Button)findViewById(2131301562)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(79741);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.i("MicroMsg.SdkOAuthUI", "accept go  MPGdprPolicyUtil.checkPolicy");
          c.a(SDKOAuthUI.this, com.tencent.mm.model.gdpr.a.hIT, SDKOAuthUI.a(SDKOAuthUI.this), new com.tencent.mm.model.gdpr.b()
          {
            public final void oG(int paramAnonymous2Int)
            {
              AppMethodBeat.i(79740);
              ad.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
              if (paramAnonymous2Int == 1)
              {
                SDKOAuthUI.a(SDKOAuthUI.this, -4);
                com.tencent.mm.plugin.webview.j.b.EsZ.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), 1, 1, 0);
                SDKOAuthUI.this.finish();
                AppMethodBeat.o(79740);
                return;
              }
              if (SDKOAuthUI.9.this.Eac.GXp)
              {
                SDKOAuthUI.a(SDKOAuthUI.this, SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.e(SDKOAuthUI.this).state, SDKOAuthUI.aIJ(SDKOAuthUI.a(SDKOAuthUI.this)), SDKOAuthUI.g(SDKOAuthUI.this).eRU());
                AppMethodBeat.o(79740);
                return;
              }
              com.tencent.mm.plugin.webview.j.b.EsZ.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 1, SDKOAuthUI.c(SDKOAuthUI.this), 1, 1, 0);
              SDKOAuthUI.f(SDKOAuthUI.this).a(ai.a.a(SDKOAuthUI.9.this.Eac), SDKOAuthUI.e(SDKOAuthUI.this).scope);
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
    if (!WN(paramInt1))
    {
      cr(getString(2131766179), true);
      com.tencent.mm.plugin.webview.j.b.EsZ.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
      AppMethodBeat.o(79766);
      return;
    }
    com.tencent.mm.plugin.webview.j.b.EsZ.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
    cr(paramString, true);
    AppMethodBeat.o(79766);
  }
  
  private void a(cxv paramcxv, Class<?> paramClass, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79770);
    a(paramcxv, paramClass, paramInt1, paramInt2, "");
    AppMethodBeat.o(79770);
  }
  
  private void a(cxv paramcxv, Class<?> paramClass, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(79771);
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.mAppId);
    if (this.DZQ != null)
    {
      paramClass.putExtra("1", this.DZQ.transaction);
      paramClass.putExtra("4", this.DZQ.state);
      paramClass.putExtra("7", this.DZQ.extData);
    }
    paramClass.putExtra("3", paramInt1);
    paramClass.putExtra("5", paramInt2);
    paramClass.putExtra("auth_from_scan", this.DZB);
    paramClass.putExtra("auth_raw_url", this.dKk);
    if (!TextUtils.isEmpty(paramString)) {
      paramClass.putExtra("auth_scope", paramString);
    }
    try
    {
      paramClass.putExtra("2", paramcxv.toByteArray());
      paramcxv = new com.tencent.mm.hellhoundlib.b.a().bc(paramClass);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramcxv.ahp(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;IILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramcxv.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;IILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(79771);
      return;
    }
    catch (IOException paramcxv)
    {
      for (;;)
      {
        ad.e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void a(cxv paramcxv, Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(79772);
    ad.i("MicroMsg.SdkOAuthUI", "startScopeActivity %s", new Object[] { paramClass.getSimpleName() });
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.mAppId);
    if (this.DZQ != null)
    {
      paramClass.putExtra("1", this.DZQ.transaction);
      paramClass.putExtra("4", this.DZQ.state);
      paramClass.putExtra("7", this.DZQ.extData);
    }
    paramClass.putExtra("auth_from_scan", this.DZB);
    if (!TextUtils.isEmpty(paramString)) {
      paramClass.putExtra("auth_scope", paramString);
    }
    paramClass.putExtra("auth_raw_url", this.dKk);
    try
    {
      paramClass.putExtra("2", paramcxv.toByteArray());
      paramcxv = new com.tencent.mm.hellhoundlib.b.a().bc(paramClass);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramcxv.ahp(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramcxv.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(79772);
      return;
    }
    catch (IOException paramcxv)
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
    if (this.DTZ)
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
    this.DTZ = true;
    Bundle localBundle = new Bundle();
    paramResp.toBundle(localBundle);
    com.tencent.mm.pluginsdk.model.app.q.bb(localBundle);
    paramResp = new MMessageActV2.Args();
    paramResp.targetPkgName = paramString;
    paramResp.bundle = localBundle;
    MMessageActV2.send(this, paramResp);
    AppMethodBeat.o(79769);
  }
  
  private static String aHm(String paramString)
  {
    AppMethodBeat.i(79783);
    Object localObject = null;
    com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.m(paramString, false, false);
    if (localg != null) {}
    for (paramString = localg.field_packageName;; paramString = localObject)
    {
      AppMethodBeat.o(79783);
      return paramString;
      ad.w("MicroMsg.SdkOAuthUI", "dealWithCancel getAppInfo null; appid: %s", new Object[] { paramString });
    }
  }
  
  private void aII(String paramString)
  {
    AppMethodBeat.i(79776);
    com.tencent.mm.ui.base.h.c(this, paramString, getString(2131761558), true);
    AppMethodBeat.o(79776);
  }
  
  private void byV()
  {
    AppMethodBeat.i(79777);
    if ((this.fQJ != null) && (!this.fQJ.isShowing()))
    {
      this.fQJ.show();
      AppMethodBeat.o(79777);
      return;
    }
    this.fQJ = com.tencent.mm.ui.base.h.b(this, getString(2131761776), true, new SDKOAuthUI.4(this));
    AppMethodBeat.o(79777);
  }
  
  private void cF(int paramInt, String paramString)
  {
    AppMethodBeat.i(79768);
    String str = aHm(this.mAppId);
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.SdkOAuthUI", "dealWithError pkg nil");
      AppMethodBeat.o(79768);
      return;
    }
    SendAuth.Resp localResp = new SendAuth.Resp();
    localResp.transaction = this.DZQ.transaction;
    localResp.errCode = paramInt;
    localResp.errStr = paramString;
    localResp.lang = eQn();
    localResp.country = getCountry();
    a(str, localResp);
    AppMethodBeat.o(79768);
  }
  
  private void cr(final String paramString, final boolean paramBoolean)
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
  
  private String eQn()
  {
    AppMethodBeat.i(79781);
    String str = com.tencent.mm.sdk.platformtools.ac.f(getSharedPreferences(com.tencent.mm.sdk.platformtools.aj.fkC(), 0));
    AppMethodBeat.o(79781);
    return str;
  }
  
  private void eRL()
  {
    AppMethodBeat.i(79779);
    if (this.fQJ == null)
    {
      AppMethodBeat.o(79779);
      return;
    }
    this.fQJ.dismiss();
    AppMethodBeat.o(79779);
  }
  
  private int eRR()
  {
    if (this.DZZ) {
      return 2;
    }
    return 1;
  }
  
  private void eRS()
  {
    AppMethodBeat.i(79773);
    if (this.DZX)
    {
      AppMethodBeat.o(79773);
      return;
    }
    if (this.DZV.getCount() >= DZS)
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
  
  private void eRT()
  {
    AppMethodBeat.i(79778);
    eRL();
    this.fQJ = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new SDKOAuthUI.5(this));
    AppMethodBeat.o(79778);
  }
  
  private static String getCountry()
  {
    AppMethodBeat.i(79782);
    String str = bt.bI((String)com.tencent.mm.kernel.g.ajC().ajl().get(274436, null), null);
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
    ad.i("MicroMsg.SdkOAuthUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      ad.e("MicroMsg.SdkOAuthUI", "Create avatar cancel or failed");
      AppMethodBeat.o(79774);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(79774);
      return;
    }
    cdd localcdd = new cdd();
    localcdd.id = paramIntent.getIntExtra("id", -1);
    localcdd.nickname = paramIntent.getStringExtra("nickname");
    localcdd.kzW = paramIntent.getStringExtra("avatarurl");
    localcdd.desc = null;
    if (this.DZV != null)
    {
      paramIntent = this.DZV;
      if ((localcdd.id != -1) && (paramIntent.Eag != null) && (paramIntent.Eag.size() < DZS)) {
        paramIntent.Eag.add(localcdd);
      }
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        b.a(this.DZV, localcdd.id);
        eRS();
        this.DZV.notifyDataSetChanged();
        AppMethodBeat.o(79774);
        return;
      }
    }
    if (this.DZV == null) {}
    for (;;)
    {
      ad.e("MicroMsg.SdkOAuthUI", "onActivityResult mAvatarAdapter == null:%b", new Object[] { Boolean.valueOf(bool) });
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
        ad.i("MicroMsg.SdkOAuthUI", "BackBtn click");
        com.tencent.mm.plugin.webview.j.b.EsZ.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), SDKOAuthUI.d(SDKOAuthUI.this), 1, 0);
        SDKOAuthUI.a(SDKOAuthUI.this, -2);
        SDKOAuthUI.this.finish();
        AppMethodBeat.o(79732);
      }
    });
    if (!com.tencent.mm.kernel.g.ajx())
    {
      ad.e("MicroMsg.SdkOAuthUI", "start, hasSetUin fail");
      Toast.makeText(this, 2131755124, 1).show();
      AppMethodBeat.o(79761);
      return;
    }
    this.DTZ = false;
    paramBundle = getIntent();
    this.DZB = paramBundle.getBooleanExtra("auth_from_scan", false);
    this.startTime = System.currentTimeMillis();
    ad.i("MicroMsg.SdkOAuthUI", "init isFromQRCodeScan %b", new Object[] { Boolean.valueOf(this.DZB) });
    if (this.DZB)
    {
      this.accountType = 3;
      this.dKk = paramBundle.getStringExtra("auth_raw_url");
      paramBundle = this.dKk;
      ad.i("MicroMsg.SdkOAuthUI", "doQRCodeOauthAuthorize url: %s", new Object[] { paramBundle });
      byV();
      paramBundle = new z(paramBundle);
      com.tencent.mm.kernel.g.aiU().a(paramBundle, 0);
      this.DZY = new com.tencent.mm.plugin.webview.model.aj(this, null, this.dKk);
      com.tencent.mm.plugin.webview.j.b.EsZ.cH(3, "");
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
    Object localObject = com.tencent.mm.pluginsdk.model.app.h.m(str1, false, false);
    if ((localObject != null) && (bt.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject).field_openId)))
    {
      ad.i("MicroMsg.SdkOAuthUI", "checkGetAppSetting appId: %s ", new Object[] { str1 });
      localObject = new ir();
      ((ir)localObject).dvo.appId = str1;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    this.DZQ = new SendAuth.Req(paramBundle);
    com.tencent.mm.plugin.webview.j.b.EsZ.cH(2, this.DZQ.extData);
    this.DZY = new com.tencent.mm.plugin.webview.model.aj(this, this.mAppId, this.DZQ.transaction, this.DZQ.state, this.DZQ.extData);
    if ((!bt.isNullOrNil(this.DZQ.scope)) && (this.DZQ.scope.contains("snsapi_wxaapp_info")) && (!this.DZQ.scope.equals("snsapi_wxaapp_info")))
    {
      cF(-1000, String.format(getContext().getResources().getString(2131766180), new Object[] { "snsapi_wxaapp_info" }));
      finish();
      AppMethodBeat.o(79761);
      return;
    }
    str1 = this.mAppId;
    localObject = this.DZQ.scope;
    String str2 = this.DZQ.state;
    String str3 = aHm(this.mAppId);
    ad.i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorize appid: %s, extData：%s", new Object[] { str1, this.DZQ.extData });
    byV();
    if (bt.isNullOrNil(str3)) {
      paramBundle = null;
    }
    for (;;)
    {
      paramBundle = new ab(str1, (String)localObject, str2, str3, paramBundle, this.DZQ.extData);
      com.tencent.mm.kernel.g.aiU().a(paramBundle, 0);
      AppMethodBeat.o(79761);
      return;
      paramBundle = com.tencent.mm.pluginsdk.model.app.q.bO(this, str3);
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
    if (this.fQJ != null) {
      this.fQJ.dismiss();
    }
    if (this.DZT != null) {
      this.DZT.stopTimer();
    }
    AppMethodBeat.o(79764);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(79765);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      com.tencent.mm.plugin.webview.j.b.EsZ.a(this.mAppId, this.startTime, 0, this.accountType, eRR(), 1, 0);
      WM(-2);
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
    com.tencent.mm.kernel.g.aiU().b(1388, this);
    com.tencent.mm.kernel.g.aiU().b(1346, this);
    com.tencent.mm.kernel.g.aiU().b(2700, this);
    com.tencent.mm.kernel.g.aiU().b(2543, this);
    com.tencent.mm.kernel.g.aiU().b(1137, this);
    AppMethodBeat.o(79763);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(79762);
    super.onResume();
    com.tencent.mm.kernel.g.aiU().a(1346, this);
    com.tencent.mm.kernel.g.aiU().a(1388, this);
    com.tencent.mm.kernel.g.aiU().a(2700, this);
    com.tencent.mm.kernel.g.aiU().a(2543, this);
    com.tencent.mm.kernel.g.aiU().a(1137, this);
    AppMethodBeat.o(79762);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(79784);
    Object localObject;
    if ((paramn instanceof ab))
    {
      a(paramInt1, paramInt2, paramString, (cxv)((ab)paramn).rr.hNL.hNQ);
      com.tencent.mm.plugin.webview.j.b.EsZ.aF(3, (int)(System.currentTimeMillis() - this.startTime), paramInt2);
      if (!(paramn instanceof z)) {
        break label863;
      }
      ad.i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label783;
      }
      localObject = (coa)((z)paramn).rr.hNL.hNQ;
      this.mAppId = ((coa)localObject).duW;
      this.DZY.mAppId = ((coa)localObject).duW;
      if (!((coa)localObject).HgZ) {
        break label617;
      }
      ad.i("MicroMsg.SdkOAuthUI", "fallback to h5");
      com.tencent.mm.plugin.webview.j.b.EsZ.a(this.mAppId, this.startTime, 1, this.accountType, 0, 0, paramInt2);
      d.b(com.tencent.mm.sdk.platformtools.aj.getContext(), "webview", ".ui.tools.WebViewUI", getIntent());
      com.tencent.mm.plugin.webview.model.aj.aM(this);
      paramInt1 = 1;
      label197:
      if (paramInt1 == 0) {
        eRL();
      }
      com.tencent.mm.plugin.webview.j.b.EsZ.aF(3, (int)(System.currentTimeMillis() - this.startTime), paramInt2);
    }
    for (;;)
    {
      eRL();
      AppMethodBeat.o(79784);
      return;
      if ((paramn instanceof com.tencent.mm.plugin.webview.model.ac))
      {
        ad.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (this.DZT != null) {
          this.DZT.stopTimer();
        }
        eRL();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject = ((com.tencent.mm.plugin.webview.model.ac)paramn).eQb();
          com.tencent.mm.plugin.webview.j.b.EsZ.a(this.mAppId, this.startTime, 1, this.accountType, eRR(), 1, 0);
          this.DZY.a(ai.a.a((cxt)localObject), this.DZQ.scope);
          break;
        }
        if (!WN(paramInt1))
        {
          cr(getString(2131766179), false);
          com.tencent.mm.plugin.webview.j.b.EsZ.a(this.mAppId, this.startTime, 2, this.accountType, eRR(), 1, paramInt2);
          break;
        }
        cr(paramString, false);
        com.tencent.mm.plugin.webview.j.b.EsZ.a(this.mAppId, this.startTime, 2, this.accountType, eRR(), 1, paramInt2);
        break;
      }
      if (!(paramn instanceof com.tencent.mm.modelsimple.g)) {
        break;
      }
      ad.i("MicroMsg.SdkOAuthUI", "onAddAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.DZV.Xs(this.DZR).id == b.a(this.DZV)) {
          b.a(this.DZV, this.DZV.Xs(0).id);
        }
        localObject = this.DZV;
        int i = this.DZR;
        if (((b)localObject).Eag == null) {}
        for (boolean bool = false;; bool = ((b)localObject).Eag.remove(((b)localObject).Xs(i)))
        {
          if (!bool) {
            ad.e("MicroMsg.SdkOAuthUI", "remove avatar failed: not found");
          }
          eRS();
          this.DZV.notifyDataSetChanged();
          break;
        }
      }
      if (!WN(paramInt1))
      {
        aII(getString(2131766179));
        break;
      }
      aII(paramString);
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
        paramn = new cxv();
        paramn.BaseResponse = ((coa)localObject).BaseResponse;
        paramn.GXn = false;
        paramn.GXo = false;
        paramn.GXr = true;
        paramn.GXp = false;
        paramn.GXl = ((coa)localObject).GXl;
        paramn.hBg = ((coa)localObject).hBg;
        paramn.GXm = ((coa)localObject).GXm;
        paramn.Fxq = "";
        paramn.GXq = ((coa)localObject).GXq;
        paramn.kzP = ((coa)localObject).kzP;
        paramn.kzQ = ((coa)localObject).kzQ;
        paramn.kzR = ((coa)localObject).kzR;
        paramn.kzS = ((coa)localObject).kzS;
        paramn.kzT = ((coa)localObject).kzT;
      }
      label783:
      if (!WN(paramInt1))
      {
        cr(getString(2131766179), true);
        com.tencent.mm.plugin.webview.j.b.EsZ.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
        paramInt1 = 0;
        break label197;
      }
      com.tencent.mm.plugin.webview.j.b.EsZ.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
      cr(paramString, true);
      paramInt1 = 0;
      break label197;
      label863:
      if ((paramn instanceof aa))
      {
        ad.i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        eRL();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.plugin.webview.j.b.EsZ.a(this.mAppId, this.startTime, 1, this.accountType, eRR(), 1, 0);
          finish();
        }
        else if (!WN(paramInt1))
        {
          cr(getString(2131766179), false);
          com.tencent.mm.plugin.webview.j.b.EsZ.a(this.mAppId, this.startTime, 2, this.accountType, eRR(), 1, paramInt2);
        }
        else
        {
          cr(paramString, false);
          com.tencent.mm.plugin.webview.j.b.EsZ.a(this.mAppId, this.startTime, 2, this.accountType, eRR(), 1, paramInt2);
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
    private LinkedList<cdg> DZM;
    private LayoutInflater mInflater;
    
    public a(Context paramContext, LinkedList<cdg> paramLinkedList)
    {
      AppMethodBeat.i(79749);
      this.mInflater = LayoutInflater.from(paramContext);
      this.DZM = paramLinkedList;
      AppMethodBeat.o(79749);
    }
    
    private cdg Xr(int paramInt)
    {
      AppMethodBeat.i(79752);
      if ((paramInt >= 0) && (paramInt < this.DZM.size()))
      {
        cdg localcdg = (cdg)this.DZM.get(paramInt);
        AppMethodBeat.o(79752);
        return localcdg;
      }
      AppMethodBeat.o(79752);
      return null;
    }
    
    public final LinkedList<String> eRU()
    {
      AppMethodBeat.i(79750);
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < this.DZM.size())
      {
        cdg localcdg = (cdg)this.DZM.get(i);
        if ((localcdg.GXt == 2) || (localcdg.GXt == 3)) {
          localLinkedList.add(localcdg.scope);
        }
        i += 1;
      }
      AppMethodBeat.o(79750);
      return localLinkedList;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(79751);
      if (this.DZM == null)
      {
        AppMethodBeat.o(79751);
        return 0;
      }
      int i = this.DZM.size();
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
      if ((this.DZM == null) || (this.DZM.size() <= 0))
      {
        AppMethodBeat.o(79753);
        return null;
      }
      final cdg localcdg = Xr(paramInt);
      if (localcdg == null)
      {
        AppMethodBeat.o(79753);
        return paramView;
      }
      if (paramView == null)
      {
        paramViewGroup = new a((byte)0);
        paramView = this.mInflater.inflate(2131495313, null, false);
        paramViewGroup.DZP = ((ImageView)paramView.findViewById(2131296682));
        paramViewGroup.nbj = ((TextView)paramView.findViewById(2131296681));
        paramView.setTag(paramViewGroup);
        if (localcdg.GXt != 1) {
          break label177;
        }
        paramViewGroup.DZP.setImageResource(2131690740);
      }
      for (;;)
      {
        paramViewGroup.nbj.setText(localcdg.desc);
        final ImageView localImageView = paramViewGroup.DZP;
        paramViewGroup.DZP.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(79748);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (localcdg.GXt == 2)
            {
              localImageView.setImageResource(2131690740);
              localcdg.GXt = 1;
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(79748);
              return;
              if (localcdg.GXt == 1)
              {
                localImageView.setImageResource(2131690738);
                localcdg.GXt = 2;
              }
            }
          }
        });
        AppMethodBeat.o(79753);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label177:
        if (localcdg.GXt == 3) {
          paramViewGroup.DZP.setImageResource(2131690739);
        } else {
          paramViewGroup.DZP.setImageResource(2131690738);
        }
      }
    }
    
    static final class a
    {
      ImageView DZP;
      TextView nbj;
    }
  }
  
  static final class b
    extends BaseAdapter
  {
    LinkedList<cdd> Eag;
    private c.a Eah;
    private Context Eai;
    private int Eaj;
    private LayoutInflater mInflater;
    
    public b(Context paramContext, LinkedList<cdd> paramLinkedList, int paramInt)
    {
      AppMethodBeat.i(79755);
      this.Eai = paramContext;
      this.mInflater = LayoutInflater.from(paramContext);
      this.Eag = paramLinkedList;
      if (this.Eag == null) {
        this.Eag = new LinkedList();
      }
      ad.i("MicroMsg.SdkOAuthUI", "LoginAvatarListAdapter avatars size:%d", new Object[] { Integer.valueOf(this.Eag.size()) });
      this.Eah = new c.a();
      this.Eah.idD = 2131690915;
      paramContext = this.Eah;
      paramContext.hfi = true;
      paramContext.idK = this.Eai.getResources().getDimension(2131166775);
      this.Eaj = paramInt;
      AppMethodBeat.o(79755);
    }
    
    public final cdd Xs(int paramInt)
    {
      AppMethodBeat.i(79757);
      if ((this.Eag != null) && (paramInt >= 0) && (paramInt < this.Eag.size()))
      {
        cdd localcdd = (cdd)this.Eag.get(paramInt);
        AppMethodBeat.o(79757);
        return localcdd;
      }
      AppMethodBeat.o(79757);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(79756);
      if (this.Eag == null)
      {
        AppMethodBeat.o(79756);
        return 0;
      }
      int i = this.Eag.size();
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
      cdd localcdd = Xs(paramInt);
      if (localcdd == null)
      {
        AppMethodBeat.o(79758);
        return paramView;
      }
      View localView;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localView = this.mInflater.inflate(2131493126, null, false);
        paramView.Eak = ((ImageView)localView.findViewById(2131297005));
        paramView.Eal = ((TextView)localView.findViewById(2131297013));
        paramView.Eam = ((TextView)localView.findViewById(2131297001));
        paramView.Ean = ((ImageView)localView.findViewById(2131297016));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        paramViewGroup.Eal.setText(k.b(this.Eai, localcdd.nickname, paramViewGroup.Eal.getTextSize()));
        com.tencent.mm.aw.q.aIJ().a(localcdd.kzW, paramViewGroup.Eak, this.Eah.aJc());
        if (localcdd.desc == null) {
          break label232;
        }
        paramViewGroup.Eam.setText(localcdd.desc);
        paramViewGroup.Eam.setVisibility(0);
        label190:
        if (localcdd.id != this.Eaj) {
          break label244;
        }
        paramViewGroup.Ean.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(79758);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label232:
        paramViewGroup.Eam.setVisibility(8);
        break label190;
        label244:
        paramViewGroup.Ean.setVisibility(4);
      }
    }
    
    static final class a
    {
      ImageView Eak;
      TextView Eal;
      TextView Eam;
      ImageView Ean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI
 * JD-Core Version:    0.7.0.1
 */