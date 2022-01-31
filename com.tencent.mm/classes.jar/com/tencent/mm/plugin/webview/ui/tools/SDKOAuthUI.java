package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.hi;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.ad;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.protocal.protobuf.bgs;
import com.tencent.mm.protocal.protobuf.bgv;
import com.tencent.mm.protocal.protobuf.bpg;
import com.tencent.mm.protocal.protobuf.bwy;
import com.tencent.mm.protocal.protobuf.bxa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public final class SDKOAuthUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private static int vbI;
  private int accountType;
  private String cJr;
  private com.tencent.mm.ui.base.p ehb;
  private int jUm;
  private int jUn;
  private n.d jWw;
  private String mAppId;
  private long startTime;
  private boolean uWa;
  private SendAuth.Req vbG;
  private int vbH;
  private ap vbJ;
  private SDKOAuthUI.a vbK;
  private SDKOAuthUI.b vbL;
  private com.tencent.mm.ui.widget.c.a vbM;
  private boolean vbN;
  private ai vbO;
  private boolean vbP;
  private String vbQ;
  private boolean vbq;
  
  public SDKOAuthUI()
  {
    AppMethodBeat.i(7551);
    this.vbP = true;
    this.vbq = false;
    this.accountType = 2;
    this.jWw = new SDKOAuthUI.7(this);
    AppMethodBeat.o(7551);
  }
  
  private void JU(int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(7559);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SdkOAuthUI", "dealWithCancel");
    if (this.vbq)
    {
      localObject = new com.tencent.mm.plugin.webview.model.ab(2, this.cJr, null, 0);
      com.tencent.mm.kernel.g.Rc().a((m)localObject, 0);
      AppMethodBeat.o(7559);
      return;
    }
    if (this.vbG == null)
    {
      AppMethodBeat.o(7559);
      return;
    }
    String str1 = ahb(this.mAppId);
    String str2 = this.mAppId;
    String str3 = this.vbG.state;
    if (this.vbK == null) {}
    for (;;)
    {
      localObject = new ad(2, str2, str3, str1, (LinkedList)localObject);
      com.tencent.mm.kernel.g.Rc().a((m)localObject, 0);
      localObject = new SendAuth.Resp();
      ((SendAuth.Resp)localObject).transaction = this.vbG.transaction;
      ((SendAuth.Resp)localObject).errCode = paramInt;
      ((SendAuth.Resp)localObject).lang = dbV();
      ((SendAuth.Resp)localObject).country = getCountry();
      a(str1, (SendAuth.Resp)localObject);
      AppMethodBeat.o(7559);
      return;
      localObject = this.vbK.ddG();
    }
  }
  
  private boolean JV(int paramInt)
  {
    AppMethodBeat.i(7569);
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, errType = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(7569);
      return false;
    }
    if (!at.isConnected(this))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, not connected");
      AppMethodBeat.o(7569);
      return false;
    }
    AppMethodBeat.o(7569);
    return true;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, bxa parambxa)
  {
    AppMethodBeat.i(7557);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    ddv();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd is_use_newpage %b", new Object[] { Boolean.valueOf(parambxa.xKd) });
      this.vbQ = parambxa.xDp;
      if ((parambxa.xvV) || (parambxa.xvW))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd direct login");
        c.a(this, com.tencent.mm.model.gdpr.a.foA, this.mAppId, new SDKOAuthUI.8(this, parambxa));
        AppMethodBeat.o(7557);
        return;
      }
      if (parambxa.xKd)
      {
        if (ai.a(parambxa))
        {
          paramString = (TextView)findViewById(2131827469);
          localObject1 = parambxa.xvT.iterator();
          label251:
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (bgv)((Iterator)localObject1).next();
            if ((localObject2 != null) && (("snsapi_userinfo".equals(((bgv)localObject2).scope)) || ("snsapi_login".equals(((bgv)localObject2).scope)) || ("group_sns_login".equals(((bgv)localObject2).scope)))) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (paramInt1 == 0) {
                break label251;
              }
              paramString.setText(((bgv)localObject2).desc);
              break;
            }
          }
          paramString.getPaint().setFakeBoldText(true);
          paramString = (ImageView)findViewById(2131827467);
          localObject1 = (TextView)findViewById(2131827468);
          localObject2 = new c.a();
          ((c.a)localObject2).eNY = 2131231748;
          ((c.a)localObject2).eOl = getResources().getDimension(2131428650);
          ((c.a)localObject2).eOk = true;
          o.ahG().a(parambxa.xvU, paramString, ((c.a)localObject2).ahY());
          ((TextView)localObject1).setText(parambxa.fhP);
          paramString = (Button)findViewById(2131827474);
          localObject1 = (Button)findViewById(2131827475);
          paramString.setOnClickListener(new SDKOAuthUI.10(this, parambxa));
          ((Button)localObject1).setOnClickListener(new SDKOAuthUI.11(this, parambxa));
          vbI = parambxa.xDm;
          this.vbM = new com.tencent.mm.ui.widget.c.a(this);
          this.vbL = new SDKOAuthUI.b(this, parambxa.xDk, parambxa.xDn);
          ddE();
          paramString = (ListView)findViewById(2131824772);
          paramString.setAdapter(this.vbL);
          paramString.setOnItemClickListener(new SDKOAuthUI.12(this));
          paramString.setOnTouchListener(new SDKOAuthUI.13(this));
          paramString.setOnItemLongClickListener(new SDKOAuthUI.14(this));
          findViewById(2131827471).setOnClickListener(new SDKOAuthUI.15(this));
          this.vbN = parambxa.xDl;
          if (parambxa.xDl) {
            findViewById(2131827470).setVisibility(8);
          }
          findViewById(2131827466).setVisibility(0);
          AppMethodBeat.o(7557);
          return;
        }
        if (ai.d("snsapi_friend", parambxa.xvT) != null)
        {
          a(parambxa, SDKOAuthFriendUI.class);
          ai.an(this);
          AppMethodBeat.o(7557);
          return;
        }
        a(parambxa, SDKOAuthOtherUI.class);
        ai.an(this);
        AppMethodBeat.o(7557);
        return;
      }
      this.vbP = false;
      paramString = (ImageView)findViewById(2131821155);
      Object localObject1 = (TextView)findViewById(2131821156);
      Object localObject2 = new c.a();
      ((c.a)localObject2).eNY = 2131231748;
      o.ahG().a(parambxa.xvU, paramString, ((c.a)localObject2).ahY());
      ((TextView)localObject1).setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, parambxa.fhP, ((TextView)localObject1).getTextSize()));
      paramString = (ListView)findViewById(2131821158);
      this.vbK = new SDKOAuthUI.a(this, parambxa.xvT);
      paramString.setAdapter(this.vbK);
      ((Button)findViewById(2131825455)).setOnClickListener(new SDKOAuthUI.9(this, parambxa));
      findViewById(2131821003).setVisibility(0);
      AppMethodBeat.o(7557);
      return;
    }
    if (!JV(paramInt1))
    {
      bO(getString(2131305934), true);
      com.tencent.mm.plugin.webview.f.a.vtM.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
      AppMethodBeat.o(7557);
      return;
    }
    com.tencent.mm.plugin.webview.f.a.vtM.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
    bO(paramString, true);
    AppMethodBeat.o(7557);
  }
  
  private void a(bxa parambxa, Class<?> paramClass)
  {
    AppMethodBeat.i(7562);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SdkOAuthUI", "startScopeActivity %s", new Object[] { paramClass.getSimpleName() });
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.mAppId);
    if (this.vbG != null)
    {
      paramClass.putExtra("1", this.vbG.transaction);
      paramClass.putExtra("4", this.vbG.state);
    }
    paramClass.putExtra("auth_from_scan", this.vbq);
    paramClass.putExtra("auth_raw_url", this.cJr);
    try
    {
      paramClass.putExtra("2", parambxa.toByteArray());
      startActivity(paramClass);
      AppMethodBeat.o(7562);
      return;
    }
    catch (IOException parambxa)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void a(bxa parambxa, Class<?> paramClass, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7561);
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.mAppId);
    if (this.vbG != null)
    {
      paramClass.putExtra("1", this.vbG.transaction);
      paramClass.putExtra("4", this.vbG.state);
    }
    paramClass.putExtra("3", paramInt1);
    paramClass.putExtra("5", paramInt2);
    paramClass.putExtra("auth_from_scan", this.vbq);
    paramClass.putExtra("auth_raw_url", this.cJr);
    try
    {
      paramClass.putExtra("2", parambxa.toByteArray());
      startActivity(paramClass);
      AppMethodBeat.o(7561);
      return;
    }
    catch (IOException parambxa)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void a(String paramString, SendAuth.Resp paramResp)
  {
    AppMethodBeat.i(7560);
    if (this.uWa)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SdkOAuthUI", "doCallback has callback");
      AppMethodBeat.o(7560);
      return;
    }
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7560);
      return;
    }
    this.uWa = true;
    Bundle localBundle = new Bundle();
    paramResp.toBundle(localBundle);
    com.tencent.mm.pluginsdk.model.app.p.aC(localBundle);
    paramResp = new MMessageActV2.Args();
    paramResp.targetPkgName = paramString;
    paramResp.bundle = localBundle;
    MMessageActV2.send(this, paramResp);
    AppMethodBeat.o(7560);
  }
  
  private static String ahb(String paramString)
  {
    AppMethodBeat.i(7572);
    Object localObject = null;
    com.tencent.mm.pluginsdk.model.app.f localf = com.tencent.mm.pluginsdk.model.app.g.ca(paramString, false);
    if (localf != null) {}
    for (paramString = localf.field_packageName;; paramString = localObject)
    {
      AppMethodBeat.o(7572);
      return paramString;
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.SdkOAuthUI", "dealWithCancel getAppInfo null; appid: %s", new Object[] { paramString });
    }
  }
  
  private void aih(String paramString)
  {
    String str1 = null;
    AppMethodBeat.i(7558);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SdkOAuthUI", "dealWithLoginCallback url : %s", new Object[] { paramString });
    String str2 = ahb(this.mAppId);
    if (bo.isNullOrNil(str2))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SdkOAuthUI", "dealWithLoginCallback pkg nil");
      AppMethodBeat.o(7558);
      return;
    }
    SendAuth.Resp localResp = new SendAuth.Resp();
    localResp.transaction = this.vbG.transaction;
    localResp.lang = dbV();
    localResp.country = getCountry();
    if (!bo.isNullOrNil(paramString)) {}
    for (Uri localUri = Uri.parse(paramString);; localUri = null)
    {
      if (localUri != null)
      {
        str1 = localUri.getQueryParameter("code");
        localResp.state = localUri.getQueryParameter("state");
        localResp.errStr = localUri.getQueryParameter("reason");
      }
      if (bo.isNullOrNil(str1)) {
        localResp.errCode = -1;
      }
      for (;;)
      {
        localResp.url = paramString;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SdkOAuthUI", "dealWithLoginCallback, pkg:%s code:%s errCode:%d state:%s", new Object[] { str2, localResp.code, Integer.valueOf(localResp.errCode), localResp.state });
        a(str2, localResp);
        finish();
        AppMethodBeat.o(7558);
        return;
        if (str1.toLowerCase().equals("authdeny"))
        {
          localResp.errCode = -4;
        }
        else
        {
          localResp.errCode = 0;
          localResp.code = str1;
        }
      }
    }
  }
  
  private void aii(String paramString)
  {
    AppMethodBeat.i(7566);
    h.b(this, paramString, getString(2131301808), true);
    AppMethodBeat.o(7566);
  }
  
  private void bO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(7565);
    h.a(this, paramString, getString(2131305933), new SDKOAuthUI.3(this, paramString, paramBoolean));
    AppMethodBeat.o(7565);
  }
  
  private String dbV()
  {
    AppMethodBeat.i(7570);
    String str = com.tencent.mm.sdk.platformtools.aa.f(getSharedPreferences(ah.dsP(), 0));
    AppMethodBeat.o(7570);
    return str;
  }
  
  private int ddD()
  {
    if (this.vbP) {
      return 2;
    }
    return 1;
  }
  
  private void ddE()
  {
    AppMethodBeat.i(7563);
    if (this.vbN)
    {
      AppMethodBeat.o(7563);
      return;
    }
    if (this.vbL.getCount() >= vbI)
    {
      findViewById(2131827471).setVisibility(8);
      findViewById(2131827472).setVisibility(0);
      findViewById(2131827473).setVisibility(4);
      AppMethodBeat.o(7563);
      return;
    }
    findViewById(2131827471).setVisibility(0);
    findViewById(2131827472).setVisibility(8);
    findViewById(2131827473).setVisibility(0);
    AppMethodBeat.o(7563);
  }
  
  private void ddF()
  {
    AppMethodBeat.i(153192);
    ddv();
    this.ehb = h.b(this, getString(2131297112), true, new SDKOAuthUI.5(this));
    AppMethodBeat.o(153192);
  }
  
  private void ddu()
  {
    AppMethodBeat.i(7567);
    if ((this.ehb != null) && (!this.ehb.isShowing()))
    {
      this.ehb.show();
      AppMethodBeat.o(7567);
      return;
    }
    this.ehb = h.b(this, getString(2131301992), true, new SDKOAuthUI.4(this));
    AppMethodBeat.o(7567);
  }
  
  private void ddv()
  {
    AppMethodBeat.i(7568);
    if (this.ehb == null)
    {
      AppMethodBeat.o(7568);
      return;
    }
    this.ehb.dismiss();
    AppMethodBeat.o(7568);
  }
  
  private static String getCountry()
  {
    AppMethodBeat.i(7571);
    String str = bo.bf((String)com.tencent.mm.kernel.g.RL().Ru().get(274436, null), null);
    AppMethodBeat.o(7571);
    return str;
  }
  
  public final int getLayoutId()
  {
    return 2130970620;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    AppMethodBeat.i(7564);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SdkOAuthUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SdkOAuthUI", "Create avatar cancel or failed");
      AppMethodBeat.o(7564);
      return;
    }
    switch (paramInt1)
    {
    }
    label209:
    for (;;)
    {
      AppMethodBeat.o(7564);
      return;
      bgs localbgs = new bgs();
      localbgs.id = paramIntent.getIntExtra("id", -1);
      localbgs.nickname = paramIntent.getStringExtra("nickname");
      localbgs.xeE = paramIntent.getStringExtra("avatarurl");
      localbgs.desc = null;
      paramIntent = this.vbL;
      if ((localbgs.id != -1) && (paramIntent.vbW.size() < vbI)) {
        paramIntent.vbW.add(localbgs);
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label209;
        }
        SDKOAuthUI.b.a(this.vbL, localbgs.id);
        ddE();
        this.vbL.notifyDataSetChanged();
        break;
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(7552);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131689615));
    hideActionbarLine();
    setMMTitle(getString(2131301817));
    setBackBtnVisible(false);
    setTitleBarClickListener(null, new SDKOAuthUI.1(this));
    if (!com.tencent.mm.kernel.g.RG())
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SdkOAuthUI", "start, hasSetUin fail");
      Toast.makeText(this, 2131296397, 1).show();
      AppMethodBeat.o(7552);
      return;
    }
    this.uWa = false;
    paramBundle = getIntent();
    this.vbq = paramBundle.getBooleanExtra("auth_from_scan", false);
    this.startTime = System.currentTimeMillis();
    if (this.vbq)
    {
      this.accountType = 3;
      this.cJr = paramBundle.getStringExtra("auth_raw_url");
      paramBundle = this.cJr;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SdkOAuthUI", "doQRCodeOauthAuthorize url: %s", new Object[] { paramBundle });
      ddu();
      paramBundle = new com.tencent.mm.plugin.webview.model.aa(paramBundle);
      com.tencent.mm.kernel.g.Rc().a(paramBundle, 0);
      this.vbO = new ai(this, null, this.cJr);
      com.tencent.mm.plugin.webview.f.a.vtM.reset(3);
      AppMethodBeat.o(7552);
      return;
    }
    com.tencent.mm.plugin.webview.f.a.vtM.reset(2);
    paramBundle = getIntent().getExtras();
    String str1 = paramBundle.getString("_mmessage_content");
    if (bo.isNullOrNil(str1))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SdkOAuthUI", "init content is nil");
      AppMethodBeat.o(7552);
      return;
    }
    this.mAppId = Uri.parse(str1).getQueryParameter("appid");
    if (bo.isNullOrNil(this.mAppId))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SdkOAuthUI", "parseAppId try case not sensitive, content:%s", new Object[] { str1 });
      this.mAppId = Uri.parse(str1.toLowerCase()).getQueryParameter("appid");
    }
    str1 = this.mAppId;
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.g.ca(str1, false);
    if ((localObject2 != null) && (bo.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_openId)))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SdkOAuthUI", "checkGetAppSetting appId: %s ", new Object[] { str1 });
      localObject2 = new hi();
      ((hi)localObject2).cwu.appId = str1;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
    }
    this.vbG = new SendAuth.Req(paramBundle);
    this.vbO = new ai(this, this.mAppId, this.vbG.transaction, this.vbG.state);
    str1 = this.mAppId;
    localObject2 = this.vbG.scope;
    String str2 = this.vbG.state;
    String str3 = ahb(this.mAppId);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorize appid: %s", new Object[] { str1 });
    ddu();
    if (bo.isNullOrNil(str3)) {
      paramBundle = localObject1;
    }
    for (;;)
    {
      paramBundle = new ac(str1, (String)localObject2, str2, str3, paramBundle);
      com.tencent.mm.kernel.g.Rc().a(paramBundle, 0);
      AppMethodBeat.o(7552);
      return;
      paramBundle = com.tencent.mm.pluginsdk.model.app.p.bv(this, str3);
      if ((paramBundle == null) || (paramBundle.length == 0))
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SdkOAuthUI", "getSignature signatures failed");
        paramBundle = localObject1;
      }
      else
      {
        paramBundle = com.tencent.mm.a.g.w(paramBundle[0].toByteArray());
      }
    }
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(7574);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 1, 0, getString(2131301807));
    AppMethodBeat.o(7574);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(7555);
    super.onDestroy();
    if (this.ehb != null) {
      this.ehb.dismiss();
    }
    if (this.vbJ != null) {
      this.vbJ.stopTimer();
    }
    AppMethodBeat.o(7555);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(7556);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      com.tencent.mm.plugin.webview.f.a.vtM.a(this.mAppId, this.startTime, 0, this.accountType, ddD(), 1, 0);
      JU(-2);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SdkOAuthUI", "key back click");
      finish();
      AppMethodBeat.o(7556);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(7556);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(7554);
    super.onPause();
    com.tencent.mm.kernel.g.Rc().b(1388, this);
    com.tencent.mm.kernel.g.Rc().b(1346, this);
    com.tencent.mm.kernel.g.Rc().b(2700, this);
    com.tencent.mm.kernel.g.Rc().b(2543, this);
    com.tencent.mm.kernel.g.Rc().b(1137, this);
    AppMethodBeat.o(7554);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(7553);
    super.onResume();
    com.tencent.mm.kernel.g.Rc().a(1346, this);
    com.tencent.mm.kernel.g.Rc().a(1388, this);
    com.tencent.mm.kernel.g.Rc().a(2700, this);
    com.tencent.mm.kernel.g.Rc().a(2543, this);
    com.tencent.mm.kernel.g.Rc().a(1137, this);
    AppMethodBeat.o(7553);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(7573);
    Object localObject;
    if ((paramm instanceof ac))
    {
      a(paramInt1, paramInt2, paramString, (bxa)((ac)paramm).rr.fsW.fta);
      com.tencent.mm.plugin.webview.f.a.vtM.ap(3, (int)(System.currentTimeMillis() - this.startTime), paramInt2);
      if (!(paramm instanceof com.tencent.mm.plugin.webview.model.aa)) {
        break label835;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label755;
      }
      localObject = (bpg)((com.tencent.mm.plugin.webview.model.aa)paramm).rr.fsW.fta;
      this.mAppId = ((bpg)localObject).cwc;
      this.vbO.mAppId = ((bpg)localObject).cwc;
      if (!((bpg)localObject).xDj) {
        break label589;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SdkOAuthUI", "fallback to h5");
      com.tencent.mm.plugin.webview.f.a.vtM.a(this.mAppId, this.startTime, 1, this.accountType, 0, 0, paramInt2);
      d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", getIntent());
      ai.an(this);
      paramInt1 = 1;
      label197:
      if (paramInt1 == 0) {
        ddv();
      }
      com.tencent.mm.plugin.webview.f.a.vtM.ap(3, (int)(System.currentTimeMillis() - this.startTime), paramInt2);
    }
    for (;;)
    {
      ddv();
      AppMethodBeat.o(7573);
      return;
      if ((paramm instanceof ad))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (this.vbJ != null) {
          this.vbJ.stopTimer();
        }
        ddv();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject = ((ad)paramm).dbQ();
          com.tencent.mm.plugin.webview.f.a.vtM.a(this.mAppId, this.startTime, 1, this.accountType, ddD(), 1, 0);
          aih(((bwy)localObject).wqy);
          break;
        }
        if (!JV(paramInt1))
        {
          bO(getString(2131305934), false);
          com.tencent.mm.plugin.webview.f.a.vtM.a(this.mAppId, this.startTime, 2, this.accountType, ddD(), 1, paramInt2);
          break;
        }
        bO(paramString, false);
        com.tencent.mm.plugin.webview.f.a.vtM.a(this.mAppId, this.startTime, 2, this.accountType, ddD(), 1, paramInt2);
        break;
      }
      if (!(paramm instanceof com.tencent.mm.plugin.webview.model.j)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SdkOAuthUI", "onAddAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.vbL.Kt(this.vbH).id == SDKOAuthUI.b.a(this.vbL)) {
          SDKOAuthUI.b.a(this.vbL, this.vbL.Kt(0).id);
        }
        localObject = this.vbL;
        int i = this.vbH;
        if (!((SDKOAuthUI.b)localObject).vbW.remove(((SDKOAuthUI.b)localObject).Kt(i))) {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SdkOAuthUI", "remove avatar failed: not found");
        }
        ddE();
        this.vbL.notifyDataSetChanged();
        break;
      }
      if (!JV(paramInt1))
      {
        aii(getString(2131305934));
        break;
      }
      aii(paramString);
      break;
      label589:
      if (localObject == null) {
        paramm = null;
      }
      for (;;)
      {
        a(paramInt1, paramInt2, paramString, paramm);
        paramInt1 = 0;
        break;
        paramm = new bxa();
        paramm.BaseResponse = ((bpg)localObject).BaseResponse;
        paramm.xvV = false;
        paramm.xvW = false;
        paramm.xKd = true;
        paramm.xvX = false;
        paramm.xvT = ((bpg)localObject).xvT;
        paramm.fhP = ((bpg)localObject).fhP;
        paramm.xvU = ((bpg)localObject).xvU;
        paramm.wqy = "";
        paramm.xDk = ((bpg)localObject).xDk;
        paramm.xDl = ((bpg)localObject).xDl;
        paramm.xDm = ((bpg)localObject).xDm;
        paramm.xDn = ((bpg)localObject).xDn;
        paramm.xDo = ((bpg)localObject).xDo;
        paramm.xDp = ((bpg)localObject).xDp;
      }
      label755:
      if (!JV(paramInt1))
      {
        bO(getString(2131305934), true);
        com.tencent.mm.plugin.webview.f.a.vtM.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
        paramInt1 = 0;
        break label197;
      }
      com.tencent.mm.plugin.webview.f.a.vtM.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, paramInt2);
      bO(paramString, true);
      paramInt1 = 0;
      break label197;
      label835:
      if ((paramm instanceof com.tencent.mm.plugin.webview.model.ab))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        ddv();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.plugin.webview.f.a.vtM.a(this.mAppId, this.startTime, 1, this.accountType, ddD(), 1, 0);
          finish();
        }
        else if (!JV(paramInt1))
        {
          bO(getString(2131305934), false);
          com.tencent.mm.plugin.webview.f.a.vtM.a(this.mAppId, this.startTime, 2, this.accountType, ddD(), 1, paramInt2);
        }
        else
        {
          bO(paramString, false);
          com.tencent.mm.plugin.webview.f.a.vtM.a(this.mAppId, this.startTime, 2, this.accountType, ddD(), 1, paramInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI
 * JD-Core Version:    0.7.0.1
 */