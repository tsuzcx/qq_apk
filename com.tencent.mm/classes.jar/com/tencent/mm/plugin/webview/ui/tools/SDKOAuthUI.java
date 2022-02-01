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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.ij;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.model.z;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bym;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public final class SDKOAuthUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private static int Cwk;
  private boolean Cqx;
  private boolean CvT;
  private SendAuth.Req Cwi;
  private int Cwj;
  private au Cwl;
  private a Cwm;
  private b Cwn;
  private com.tencent.mm.ui.widget.b.a Cwo;
  private boolean Cwp;
  private com.tencent.mm.plugin.webview.model.ai Cwq;
  private boolean Cwr;
  private String Cws;
  private int accountType;
  private String dxX;
  private p fxw;
  private String mAppId;
  private n.d nAc;
  private int nwY;
  private int nwZ;
  private long startTime;
  
  public SDKOAuthUI()
  {
    AppMethodBeat.i(79760);
    this.Cwr = true;
    this.CvT = false;
    this.accountType = 2;
    this.nAc = new n.d()
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
  
  private void UW(int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(79767);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", "dealWithCancel");
    if (this.CvT)
    {
      localObject = new aa(2, this.dxX, null, 0);
      com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
      AppMethodBeat.o(79767);
      return;
    }
    if (this.Cwi == null)
    {
      AppMethodBeat.o(79767);
      return;
    }
    String str1 = aBM(this.mAppId);
    String str2 = this.mAppId;
    String str3 = this.Cwi.state;
    if (this.Cwm == null) {}
    for (;;)
    {
      localObject = new com.tencent.mm.plugin.webview.model.ac(2, str2, str3, str1, (LinkedList)localObject, this.Cwi.extData);
      com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
      localObject = new SendAuth.Resp();
      ((SendAuth.Resp)localObject).transaction = this.Cwi.transaction;
      ((SendAuth.Resp)localObject).errCode = paramInt;
      ((SendAuth.Resp)localObject).lang = eBt();
      ((SendAuth.Resp)localObject).country = getCountry();
      a(str1, (SendAuth.Resp)localObject);
      AppMethodBeat.o(79767);
      return;
      localObject = this.Cwm.eDc();
    }
  }
  
  private boolean UX(int paramInt)
  {
    AppMethodBeat.i(79780);
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, errType = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(79780);
      return false;
    }
    if (!ax.isConnected(this))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, not connected");
      AppMethodBeat.o(79780);
      return false;
    }
    AppMethodBeat.o(79780);
    return true;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, final csl paramcsl)
  {
    AppMethodBeat.i(79766);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    eCU();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd is_use_newpage %b", new Object[] { Boolean.valueOf(paramcsl.FnI) });
      this.Cws = paramcsl.kff;
      if ((paramcsl.FnE) || (paramcsl.FnF))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd direct login");
        c.a(this, com.tencent.mm.model.gdpr.a.hqB, this.mAppId, new com.tencent.mm.model.gdpr.b()
        {
          public final void og(int paramAnonymousInt)
          {
            AppMethodBeat.i(79739);
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (paramAnonymousInt == 1)
            {
              SDKOAuthUI.a(SDKOAuthUI.this, -4);
              com.tencent.mm.plugin.webview.j.b.COZ.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), 0, 0, 0);
              SDKOAuthUI.this.finish();
              AppMethodBeat.o(79739);
              return;
            }
            SDKOAuthUI.f(SDKOAuthUI.this).cg(paramcsl.DRX, SDKOAuthUI.e(SDKOAuthUI.this).scope.trim().equals("snsapi_wxaapp_info"));
            com.tencent.mm.plugin.webview.j.b.COZ.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 1, SDKOAuthUI.c(SDKOAuthUI.this), 0, 0, 0);
            AppMethodBeat.o(79739);
          }
        });
        AppMethodBeat.o(79766);
        return;
      }
      if (paramcsl.FnI)
      {
        if (com.tencent.mm.plugin.webview.model.ai.a(paramcsl))
        {
          paramString = (TextView)findViewById(2131296970);
          localObject1 = paramcsl.FnC.iterator();
          label251:
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (byp)((Iterator)localObject1).next();
            if ((localObject2 != null) && (("snsapi_userinfo".equals(((byp)localObject2).scope)) || ("snsapi_login".equals(((byp)localObject2).scope)) || ("group_sns_login".equals(((byp)localObject2).scope)))) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (paramInt1 == 0) {
                break label251;
              }
              paramString.setText(((byp)localObject2).desc);
              break;
            }
          }
          paramString.getPaint().setFakeBoldText(true);
          paramString = (TextView)findViewById(2131296971);
          if (!bs.isNullOrNil(paramcsl.FEM))
          {
            paramString.setVisibility(0);
            paramString.setText(paramcsl.FEM);
          }
          for (;;)
          {
            paramString = (ImageView)findViewById(2131302713);
            localObject1 = (TextView)findViewById(2131302716);
            localObject2 = new c.a();
            ((c.a)localObject2).hKI = 2131690915;
            ((c.a)localObject2).hKP = getResources().getDimension(2131166776);
            ((c.a)localObject2).gLt = true;
            o.aFB().a(paramcsl.FnD, paramString, ((c.a)localObject2).aFT());
            ((TextView)localObject1).setText(paramcsl.hiX);
            paramString = (Button)findViewById(2131301564);
            localObject1 = (Button)findViewById(2131301567);
            paramString.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(79742);
                SDKOAuthUI.a(SDKOAuthUI.this, paramcsl);
                AppMethodBeat.o(79742);
              }
            });
            ((Button)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(79743);
                SDKOAuthUI.f(SDKOAuthUI.this);
                byp localbyp = com.tencent.mm.plugin.webview.model.ai.e("snsapi_userinfo", paramcsl.FnC);
                paramAnonymousView = localbyp;
                if (localbyp == null)
                {
                  SDKOAuthUI.f(SDKOAuthUI.this);
                  paramAnonymousView = com.tencent.mm.plugin.webview.model.ai.e("snsapi_login", paramcsl.FnC);
                }
                if (paramAnonymousView == null)
                {
                  SDKOAuthUI.f(SDKOAuthUI.this);
                  paramAnonymousView = com.tencent.mm.plugin.webview.model.ai.e("group_sns_login", paramcsl.FnC);
                }
                for (;;)
                {
                  com.tencent.mm.plugin.webview.j.b.COZ.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), 2, 1, 0);
                  SDKOAuthUI.a(SDKOAuthUI.this, paramAnonymousView, paramcsl);
                  AppMethodBeat.o(79743);
                  return;
                }
              }
            });
            Cwk = paramcsl.kfc;
            this.Cwo = new com.tencent.mm.ui.widget.b.a(this);
            this.Cwn = new b(this, paramcsl.FnH, paramcsl.kfd);
            eDa();
            paramString = (ListView)findViewById(2131297012);
            paramString.setAdapter(this.Cwn);
            paramString.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
              public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
              {
                AppMethodBeat.i(79744);
                SDKOAuthUI.b.a(SDKOAuthUI.h(SDKOAuthUI.this), SDKOAuthUI.h(SDKOAuthUI.this).VD(paramAnonymousInt).id);
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
                int i = SDKOAuthUI.h(SDKOAuthUI.this).VD(paramAnonymousInt).id;
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
            this.Cwp = paramcsl.kfb;
            if (paramcsl.kfb) {
              findViewById(2131298854).setVisibility(8);
            }
            findViewById(2131302797).setVisibility(0);
            AppMethodBeat.o(79766);
            return;
            paramString.setVisibility(8);
          }
        }
        if (com.tencent.mm.plugin.webview.model.ai.e("snsapi_friend", paramcsl.FnC) != null)
        {
          a(paramcsl, SDKOAuthFriendUI.class, "snsapi_friend");
          com.tencent.mm.plugin.webview.model.ai.aM(this);
          AppMethodBeat.o(79766);
          return;
        }
        if (com.tencent.mm.plugin.webview.model.ai.e("snsapi_wxaapp_info", paramcsl.FnC) != null)
        {
          a(paramcsl, SDKOAuthFriendUI.class, "snsapi_wxaapp_info");
          com.tencent.mm.plugin.webview.model.ai.aM(this);
          AppMethodBeat.o(79766);
          return;
        }
        a(paramcsl, SDKOAuthOtherUI.class, "");
        com.tencent.mm.plugin.webview.model.ai.aM(this);
        AppMethodBeat.o(79766);
        return;
      }
      this.Cwr = false;
      paramString = (ImageView)findViewById(2131296853);
      Object localObject1 = (TextView)findViewById(2131296866);
      Object localObject2 = new c.a();
      ((c.a)localObject2).hKI = 2131690915;
      o.aFB().a(paramcsl.FnD, paramString, ((c.a)localObject2).aFT());
      ((TextView)localObject1).setText(k.b(this, paramcsl.hiX, ((TextView)localObject1).getTextSize()));
      paramString = (ListView)findViewById(2131296973);
      this.Cwm = new a(this, paramcsl.FnC);
      paramString.setAdapter(this.Cwm);
      ((Button)findViewById(2131301562)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(79741);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", "accept go  MPGdprPolicyUtil.checkPolicy");
          c.a(SDKOAuthUI.this, com.tencent.mm.model.gdpr.a.hqB, SDKOAuthUI.a(SDKOAuthUI.this), new com.tencent.mm.model.gdpr.b()
          {
            public final void og(int paramAnonymous2Int)
            {
              AppMethodBeat.i(79740);
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
              if (paramAnonymous2Int == 1)
              {
                SDKOAuthUI.a(SDKOAuthUI.this, -4);
                com.tencent.mm.plugin.webview.j.b.COZ.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), 1, 1, 0);
                SDKOAuthUI.this.finish();
                AppMethodBeat.o(79740);
                return;
              }
              if (SDKOAuthUI.9.this.Cwu.FnG)
              {
                SDKOAuthUI.a(SDKOAuthUI.this, SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.e(SDKOAuthUI.this).state, SDKOAuthUI.aDi(SDKOAuthUI.a(SDKOAuthUI.this)), SDKOAuthUI.g(SDKOAuthUI.this).eDc());
                AppMethodBeat.o(79740);
                return;
              }
              com.tencent.mm.plugin.webview.j.b.COZ.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 1, SDKOAuthUI.c(SDKOAuthUI.this), 1, 1, 0);
              SDKOAuthUI.f(SDKOAuthUI.this).cg(SDKOAuthUI.9.this.Cwu.DRX, SDKOAuthUI.e(SDKOAuthUI.this).scope.trim().equals("snsapi_wxaapp_info"));
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
    if (!UX(paramInt1))
    {
      ck(getString(2131766179), true);
      com.tencent.mm.plugin.webview.j.b.COZ.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
      AppMethodBeat.o(79766);
      return;
    }
    com.tencent.mm.plugin.webview.j.b.COZ.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
    ck(paramString, true);
    AppMethodBeat.o(79766);
  }
  
  private void a(csl paramcsl, Class<?> paramClass, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79770);
    a(paramcsl, paramClass, paramInt1, paramInt2, "");
    AppMethodBeat.o(79770);
  }
  
  private void a(csl paramcsl, Class<?> paramClass, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(79771);
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.mAppId);
    if (this.Cwi != null)
    {
      paramClass.putExtra("1", this.Cwi.transaction);
      paramClass.putExtra("4", this.Cwi.state);
      paramClass.putExtra("7", this.Cwi.extData);
    }
    paramClass.putExtra("3", paramInt1);
    paramClass.putExtra("5", paramInt2);
    paramClass.putExtra("auth_from_scan", this.CvT);
    paramClass.putExtra("auth_raw_url", this.dxX);
    if (!TextUtils.isEmpty(paramString)) {
      paramClass.putExtra("auth_scope", paramString);
    }
    try
    {
      paramClass.putExtra("2", paramcsl.toByteArray());
      paramcsl = new com.tencent.mm.hellhoundlib.b.a().ba(paramClass);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramcsl.aeD(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;IILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramcsl.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;IILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(79771);
      return;
    }
    catch (IOException paramcsl)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void a(csl paramcsl, Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(79772);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", "startScopeActivity %s", new Object[] { paramClass.getSimpleName() });
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.mAppId);
    if (this.Cwi != null)
    {
      paramClass.putExtra("1", this.Cwi.transaction);
      paramClass.putExtra("4", this.Cwi.state);
      paramClass.putExtra("7", this.Cwi.extData);
    }
    paramClass.putExtra("auth_from_scan", this.CvT);
    if (!TextUtils.isEmpty(paramString)) {
      paramClass.putExtra("auth_scope", paramString);
    }
    paramClass.putExtra("auth_raw_url", this.dxX);
    try
    {
      paramClass.putExtra("2", paramcsl.toByteArray());
      paramcsl = new com.tencent.mm.hellhoundlib.b.a().ba(paramClass);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramcsl.aeD(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramcsl.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(79772);
      return;
    }
    catch (IOException paramcsl)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void a(String paramString, SendAuth.Resp paramResp)
  {
    AppMethodBeat.i(79769);
    if (this.Cqx)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", "doCallback has callback");
      AppMethodBeat.o(79769);
      return;
    }
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79769);
      return;
    }
    this.Cqx = true;
    Bundle localBundle = new Bundle();
    paramResp.toBundle(localBundle);
    com.tencent.mm.pluginsdk.model.app.q.aW(localBundle);
    paramResp = new MMessageActV2.Args();
    paramResp.targetPkgName = paramString;
    paramResp.bundle = localBundle;
    MMessageActV2.send(this, paramResp);
    AppMethodBeat.o(79769);
  }
  
  private static String aBM(String paramString)
  {
    AppMethodBeat.i(79783);
    Object localObject = null;
    com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.k(paramString, false, false);
    if (localg != null) {}
    for (paramString = localg.field_packageName;; paramString = localObject)
    {
      AppMethodBeat.o(79783);
      return paramString;
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.SdkOAuthUI", "dealWithCancel getAppInfo null; appid: %s", new Object[] { paramString });
    }
  }
  
  private void aDh(String paramString)
  {
    AppMethodBeat.i(79776);
    com.tencent.mm.ui.base.h.c(this, paramString, getString(2131761558), true);
    AppMethodBeat.o(79776);
  }
  
  private void buQ()
  {
    AppMethodBeat.i(79777);
    if ((this.fxw != null) && (!this.fxw.isShowing()))
    {
      this.fxw.show();
      AppMethodBeat.o(79777);
      return;
    }
    this.fxw = com.tencent.mm.ui.base.h.b(this, getString(2131761776), true, new DialogInterface.OnCancelListener()
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
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SdkOAuthUI", "showProgressDlg onCancel exp: %s ", new Object[] { paramAnonymousDialogInterface.getLocalizedMessage() });
          AppMethodBeat.o(79735);
        }
      }
    });
    AppMethodBeat.o(79777);
  }
  
  private void ck(final String paramString, final boolean paramBoolean)
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
  
  private void cz(int paramInt, String paramString)
  {
    AppMethodBeat.i(79768);
    String str = aBM(this.mAppId);
    if (bs.isNullOrNil(str))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SdkOAuthUI", "dealWithError pkg nil");
      AppMethodBeat.o(79768);
      return;
    }
    SendAuth.Resp localResp = new SendAuth.Resp();
    localResp.transaction = this.Cwi.transaction;
    localResp.errCode = paramInt;
    localResp.errStr = paramString;
    localResp.lang = eBt();
    localResp.country = getCountry();
    a(str, localResp);
    AppMethodBeat.o(79768);
  }
  
  private String eBt()
  {
    AppMethodBeat.i(79781);
    String str = com.tencent.mm.sdk.platformtools.ab.f(getSharedPreferences(com.tencent.mm.sdk.platformtools.ai.eUX(), 0));
    AppMethodBeat.o(79781);
    return str;
  }
  
  private void eCU()
  {
    AppMethodBeat.i(79779);
    if (this.fxw == null)
    {
      AppMethodBeat.o(79779);
      return;
    }
    this.fxw.dismiss();
    AppMethodBeat.o(79779);
  }
  
  private int eCZ()
  {
    if (this.Cwr) {
      return 2;
    }
    return 1;
  }
  
  private void eDa()
  {
    AppMethodBeat.i(79773);
    if (this.Cwp)
    {
      AppMethodBeat.o(79773);
      return;
    }
    if (this.Cwn.getCount() >= Cwk)
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
  
  private void eDb()
  {
    AppMethodBeat.i(79778);
    eCU();
    this.fxw = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
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
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SdkOAuthUI", "showProgressDlg onCancel exp: %s ", new Object[] { paramAnonymousDialogInterface.getLocalizedMessage() });
          AppMethodBeat.o(79736);
        }
      }
    });
    AppMethodBeat.o(79778);
  }
  
  private static String getCountry()
  {
    AppMethodBeat.i(79782);
    String str = bs.bG((String)com.tencent.mm.kernel.g.agR().agA().get(274436, null), null);
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SdkOAuthUI", "Create avatar cancel or failed");
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
      bym localbym = new bym();
      localbym.id = paramIntent.getIntExtra("id", -1);
      localbym.nickname = paramIntent.getStringExtra("nickname");
      localbym.kfi = paramIntent.getStringExtra("avatarurl");
      localbym.desc = null;
      paramIntent = this.Cwn;
      if ((localbym.id != -1) && (paramIntent.Cwy != null) && (paramIntent.Cwy.size() < Cwk)) {
        paramIntent.Cwy.add(localbym);
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label216;
        }
        b.a(this.Cwn, localbym.id);
        eDa();
        this.Cwn.notifyDataSetChanged();
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
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", "BackBtn click");
        com.tencent.mm.plugin.webview.j.b.COZ.a(SDKOAuthUI.a(SDKOAuthUI.this), SDKOAuthUI.b(SDKOAuthUI.this), 0, SDKOAuthUI.c(SDKOAuthUI.this), SDKOAuthUI.d(SDKOAuthUI.this), 1, 0);
        SDKOAuthUI.a(SDKOAuthUI.this, -2);
        SDKOAuthUI.this.finish();
        AppMethodBeat.o(79732);
      }
    });
    if (!com.tencent.mm.kernel.g.agM())
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SdkOAuthUI", "start, hasSetUin fail");
      Toast.makeText(this, 2131755124, 1).show();
      AppMethodBeat.o(79761);
      return;
    }
    this.Cqx = false;
    paramBundle = getIntent();
    this.CvT = paramBundle.getBooleanExtra("auth_from_scan", false);
    this.startTime = System.currentTimeMillis();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", "init isFromQRCodeScan %b", new Object[] { Boolean.valueOf(this.CvT) });
    if (this.CvT)
    {
      this.accountType = 3;
      this.dxX = paramBundle.getStringExtra("auth_raw_url");
      paramBundle = this.dxX;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", "doQRCodeOauthAuthorize url: %s", new Object[] { paramBundle });
      buQ();
      paramBundle = new z(paramBundle);
      com.tencent.mm.kernel.g.agi().a(paramBundle, 0);
      this.Cwq = new com.tencent.mm.plugin.webview.model.ai(this, null, this.dxX);
      com.tencent.mm.plugin.webview.j.b.COZ.cB(3, "");
      AppMethodBeat.o(79761);
      return;
    }
    paramBundle = getIntent().getExtras();
    String str1 = paramBundle.getString("_mmessage_content");
    if (bs.isNullOrNil(str1))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SdkOAuthUI", "init content is nil");
      AppMethodBeat.o(79761);
      return;
    }
    this.mAppId = Uri.parse(str1).getQueryParameter("appid");
    if (bs.isNullOrNil(this.mAppId))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", "parseAppId try case not sensitive, content:%s", new Object[] { str1 });
      this.mAppId = Uri.parse(str1.toLowerCase()).getQueryParameter("appid");
    }
    str1 = this.mAppId;
    Object localObject = com.tencent.mm.pluginsdk.model.app.h.k(str1, false, false);
    if ((localObject != null) && (bs.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject).field_openId)))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", "checkGetAppSetting appId: %s ", new Object[] { str1 });
      localObject = new ij();
      ((ij)localObject).djB.appId = str1;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    }
    this.Cwi = new SendAuth.Req(paramBundle);
    com.tencent.mm.plugin.webview.j.b.COZ.cB(2, this.Cwi.extData);
    this.Cwq = new com.tencent.mm.plugin.webview.model.ai(this, this.mAppId, this.Cwi.transaction, this.Cwi.state, this.Cwi.extData);
    if ((!bs.isNullOrNil(this.Cwi.scope)) && (this.Cwi.scope.contains("snsapi_wxaapp_info")) && (!this.Cwi.scope.equals("snsapi_wxaapp_info")))
    {
      cz(-1000, String.format(getContext().getResources().getString(2131766180), new Object[] { "snsapi_wxaapp_info" }));
      finish();
      AppMethodBeat.o(79761);
      return;
    }
    str1 = this.mAppId;
    localObject = this.Cwi.scope;
    String str2 = this.Cwi.state;
    String str3 = aBM(this.mAppId);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorize appid: %s, extData：%s", new Object[] { str1, this.Cwi.extData });
    buQ();
    if (bs.isNullOrNil(str3)) {
      paramBundle = null;
    }
    for (;;)
    {
      paramBundle = new com.tencent.mm.plugin.webview.model.ab(str1, (String)localObject, str2, str3, paramBundle, this.Cwi.extData);
      com.tencent.mm.kernel.g.agi().a(paramBundle, 0);
      AppMethodBeat.o(79761);
      return;
      paramBundle = com.tencent.mm.pluginsdk.model.app.q.bK(this, str3);
      if ((paramBundle == null) || (paramBundle.length == 0))
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SdkOAuthUI", "getSignature signatures failed");
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
    if (this.fxw != null) {
      this.fxw.dismiss();
    }
    if (this.Cwl != null) {
      this.Cwl.stopTimer();
    }
    AppMethodBeat.o(79764);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(79765);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      com.tencent.mm.plugin.webview.j.b.COZ.a(this.mAppId, this.startTime, 0, this.accountType, eCZ(), 1, 0);
      UW(-2);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", "key back click");
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
    com.tencent.mm.kernel.g.agi().b(1388, this);
    com.tencent.mm.kernel.g.agi().b(1346, this);
    com.tencent.mm.kernel.g.agi().b(2700, this);
    com.tencent.mm.kernel.g.agi().b(2543, this);
    com.tencent.mm.kernel.g.agi().b(1137, this);
    AppMethodBeat.o(79763);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(79762);
    super.onResume();
    com.tencent.mm.kernel.g.agi().a(1346, this);
    com.tencent.mm.kernel.g.agi().a(1388, this);
    com.tencent.mm.kernel.g.agi().a(2700, this);
    com.tencent.mm.kernel.g.agi().a(2543, this);
    com.tencent.mm.kernel.g.agi().a(1137, this);
    AppMethodBeat.o(79762);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(79784);
    Object localObject;
    if ((paramn instanceof com.tencent.mm.plugin.webview.model.ab))
    {
      a(paramInt1, paramInt2, paramString, (csl)((com.tencent.mm.plugin.webview.model.ab)paramn).rr.hvs.hvw);
      com.tencent.mm.plugin.webview.j.b.COZ.aD(3, (int)(System.currentTimeMillis() - this.startTime), paramInt2);
      if (!(paramn instanceof z)) {
        break label872;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label792;
      }
      localObject = (cja)((z)paramn).rr.hvs.hvw;
      this.mAppId = ((cja)localObject).djj;
      this.Cwq.mAppId = ((cja)localObject).djj;
      if (!((cja)localObject).FwU) {
        break label626;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", "fallback to h5");
      com.tencent.mm.plugin.webview.j.b.COZ.a(this.mAppId, this.startTime, 1, this.accountType, 0, 0, paramInt2);
      d.b(com.tencent.mm.sdk.platformtools.ai.getContext(), "webview", ".ui.tools.WebViewUI", getIntent());
      com.tencent.mm.plugin.webview.model.ai.aM(this);
      paramInt1 = 1;
      label197:
      if (paramInt1 == 0) {
        eCU();
      }
      com.tencent.mm.plugin.webview.j.b.COZ.aD(3, (int)(System.currentTimeMillis() - this.startTime), paramInt2);
    }
    for (;;)
    {
      eCU();
      AppMethodBeat.o(79784);
      return;
      if ((paramn instanceof com.tencent.mm.plugin.webview.model.ac))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (this.Cwl != null) {
          this.Cwl.stopTimer();
        }
        eCU();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject = ((com.tencent.mm.plugin.webview.model.ac)paramn).eBj();
          com.tencent.mm.plugin.webview.j.b.COZ.a(this.mAppId, this.startTime, 1, this.accountType, eCZ(), 1, 0);
          this.Cwq.cg(((csj)localObject).DRX, this.Cwi.scope.trim().equals("snsapi_wxaapp_info"));
          break;
        }
        if (!UX(paramInt1))
        {
          ck(getString(2131766179), false);
          com.tencent.mm.plugin.webview.j.b.COZ.a(this.mAppId, this.startTime, 2, this.accountType, eCZ(), 1, paramInt2);
          break;
        }
        ck(paramString, false);
        com.tencent.mm.plugin.webview.j.b.COZ.a(this.mAppId, this.startTime, 2, this.accountType, eCZ(), 1, paramInt2);
        break;
      }
      if (!(paramn instanceof com.tencent.mm.modelsimple.g)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", "onAddAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.Cwn.VD(this.Cwj).id == b.a(this.Cwn)) {
          b.a(this.Cwn, this.Cwn.VD(0).id);
        }
        localObject = this.Cwn;
        int i = this.Cwj;
        if (((b)localObject).Cwy == null) {}
        for (boolean bool = false;; bool = ((b)localObject).Cwy.remove(((b)localObject).VD(i)))
        {
          if (!bool) {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SdkOAuthUI", "remove avatar failed: not found");
          }
          eDa();
          this.Cwn.notifyDataSetChanged();
          break;
        }
      }
      if (!UX(paramInt1))
      {
        aDh(getString(2131766179));
        break;
      }
      aDh(paramString);
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
        paramn = new csl();
        paramn.BaseResponse = ((cja)localObject).BaseResponse;
        paramn.FnE = false;
        paramn.FnF = false;
        paramn.FnI = true;
        paramn.FnG = false;
        paramn.FnC = ((cja)localObject).FnC;
        paramn.hiX = ((cja)localObject).hiX;
        paramn.FnD = ((cja)localObject).FnD;
        paramn.DRX = "";
        paramn.FnH = ((cja)localObject).FnH;
        paramn.kfb = ((cja)localObject).kfb;
        paramn.kfc = ((cja)localObject).kfc;
        paramn.kfd = ((cja)localObject).kfd;
        paramn.kfe = ((cja)localObject).kfe;
        paramn.kff = ((cja)localObject).kff;
      }
      label792:
      if (!UX(paramInt1))
      {
        ck(getString(2131766179), true);
        com.tencent.mm.plugin.webview.j.b.COZ.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
        paramInt1 = 0;
        break label197;
      }
      com.tencent.mm.plugin.webview.j.b.COZ.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
      ck(paramString, true);
      paramInt1 = 0;
      break label197;
      label872:
      if ((paramn instanceof aa))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        eCU();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.plugin.webview.j.b.COZ.a(this.mAppId, this.startTime, 1, this.accountType, eCZ(), 1, 0);
          finish();
        }
        else if (!UX(paramInt1))
        {
          ck(getString(2131766179), false);
          com.tencent.mm.plugin.webview.j.b.COZ.a(this.mAppId, this.startTime, 2, this.accountType, eCZ(), 1, paramInt2);
        }
        else
        {
          ck(paramString, false);
          com.tencent.mm.plugin.webview.j.b.COZ.a(this.mAppId, this.startTime, 2, this.accountType, eCZ(), 1, paramInt2);
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
    private LinkedList<byp> Cwe;
    private LayoutInflater mInflater;
    
    public a(Context paramContext, LinkedList<byp> paramLinkedList)
    {
      AppMethodBeat.i(79749);
      this.mInflater = LayoutInflater.from(paramContext);
      this.Cwe = paramLinkedList;
      AppMethodBeat.o(79749);
    }
    
    private byp VC(int paramInt)
    {
      AppMethodBeat.i(79752);
      if ((paramInt >= 0) && (paramInt < this.Cwe.size()))
      {
        byp localbyp = (byp)this.Cwe.get(paramInt);
        AppMethodBeat.o(79752);
        return localbyp;
      }
      AppMethodBeat.o(79752);
      return null;
    }
    
    public final LinkedList<String> eDc()
    {
      AppMethodBeat.i(79750);
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < this.Cwe.size())
      {
        byp localbyp = (byp)this.Cwe.get(i);
        if ((localbyp.FnK == 2) || (localbyp.FnK == 3)) {
          localLinkedList.add(localbyp.scope);
        }
        i += 1;
      }
      AppMethodBeat.o(79750);
      return localLinkedList;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(79751);
      if (this.Cwe == null)
      {
        AppMethodBeat.o(79751);
        return 0;
      }
      int i = this.Cwe.size();
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
      if ((this.Cwe == null) || (this.Cwe.size() <= 0))
      {
        AppMethodBeat.o(79753);
        return null;
      }
      final byp localbyp = VC(paramInt);
      if (localbyp == null)
      {
        AppMethodBeat.o(79753);
        return paramView;
      }
      if (paramView == null)
      {
        paramViewGroup = new a((byte)0);
        paramView = this.mInflater.inflate(2131495313, null, false);
        paramViewGroup.Cwh = ((ImageView)paramView.findViewById(2131296682));
        paramViewGroup.mAB = ((TextView)paramView.findViewById(2131296681));
        paramView.setTag(paramViewGroup);
        if (localbyp.FnK != 1) {
          break label177;
        }
        paramViewGroup.Cwh.setImageResource(2131690740);
      }
      for (;;)
      {
        paramViewGroup.mAB.setText(localbyp.desc);
        final ImageView localImageView = paramViewGroup.Cwh;
        paramViewGroup.Cwh.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(79748);
            if (localbyp.FnK == 2)
            {
              localImageView.setImageResource(2131690740);
              localbyp.FnK = 1;
              AppMethodBeat.o(79748);
              return;
            }
            if (localbyp.FnK == 1)
            {
              localImageView.setImageResource(2131690738);
              localbyp.FnK = 2;
            }
            AppMethodBeat.o(79748);
          }
        });
        AppMethodBeat.o(79753);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label177:
        if (localbyp.FnK == 3) {
          paramViewGroup.Cwh.setImageResource(2131690739);
        } else {
          paramViewGroup.Cwh.setImageResource(2131690738);
        }
      }
    }
    
    static final class a
    {
      ImageView Cwh;
      TextView mAB;
    }
  }
  
  static final class b
    extends BaseAdapter
  {
    private Context CwA;
    private int CwB;
    LinkedList<bym> Cwy;
    private c.a Cwz;
    private LayoutInflater mInflater;
    
    public b(Context paramContext, LinkedList<bym> paramLinkedList, int paramInt)
    {
      AppMethodBeat.i(79755);
      this.CwA = paramContext;
      this.mInflater = LayoutInflater.from(paramContext);
      this.Cwy = paramLinkedList;
      if (this.Cwy == null) {
        this.Cwy = new LinkedList();
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SdkOAuthUI", "LoginAvatarListAdapter avatars size:%d", new Object[] { Integer.valueOf(this.Cwy.size()) });
      this.Cwz = new c.a();
      this.Cwz.hKI = 2131690915;
      paramContext = this.Cwz;
      paramContext.gLt = true;
      paramContext.hKP = this.CwA.getResources().getDimension(2131166775);
      this.CwB = paramInt;
      AppMethodBeat.o(79755);
    }
    
    public final bym VD(int paramInt)
    {
      AppMethodBeat.i(79757);
      if ((this.Cwy != null) && (paramInt >= 0) && (paramInt < this.Cwy.size()))
      {
        bym localbym = (bym)this.Cwy.get(paramInt);
        AppMethodBeat.o(79757);
        return localbym;
      }
      AppMethodBeat.o(79757);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(79756);
      if (this.Cwy == null)
      {
        AppMethodBeat.o(79756);
        return 0;
      }
      int i = this.Cwy.size();
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
      bym localbym = VD(paramInt);
      if (localbym == null)
      {
        AppMethodBeat.o(79758);
        return paramView;
      }
      View localView;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localView = this.mInflater.inflate(2131493126, null, false);
        paramView.CwC = ((ImageView)localView.findViewById(2131297005));
        paramView.CwD = ((TextView)localView.findViewById(2131297013));
        paramView.CwE = ((TextView)localView.findViewById(2131297001));
        paramView.CwF = ((ImageView)localView.findViewById(2131297016));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        paramViewGroup.CwD.setText(k.b(this.CwA, localbym.nickname, paramViewGroup.CwD.getTextSize()));
        o.aFB().a(localbym.kfi, paramViewGroup.CwC, this.Cwz.aFT());
        if (localbym.desc == null) {
          break label232;
        }
        paramViewGroup.CwE.setText(localbym.desc);
        paramViewGroup.CwE.setVisibility(0);
        label190:
        if (localbym.id != this.CwB) {
          break label244;
        }
        paramViewGroup.CwF.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(79758);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label232:
        paramViewGroup.CwE.setVisibility(8);
        break label190;
        label244:
        paramViewGroup.CwF.setVisibility(4);
      }
    }
    
    static final class a
    {
      ImageView CwC;
      TextView CwD;
      TextView CwE;
      ImageView CwF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI
 * JD-Core Version:    0.7.0.1
 */