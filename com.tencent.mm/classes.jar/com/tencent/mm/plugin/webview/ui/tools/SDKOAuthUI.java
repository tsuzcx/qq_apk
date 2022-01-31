package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.he;
import com.tencent.mm.model.au;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.plugin.webview.model.ad;
import com.tencent.mm.protocal.c.azp;
import com.tencent.mm.protocal.c.azs;
import com.tencent.mm.protocal.c.bnd;
import com.tencent.mm.protocal.c.bnf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public final class SDKOAuthUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private static int rmd;
  private com.tencent.mm.ui.base.p dpF;
  private int idy;
  private int idz;
  private n.d ifj = new SDKOAuthUI.13(this);
  private String mAppId;
  private boolean rfN;
  private SendAuth.Req rmb;
  private int rmc;
  private am rme;
  private SDKOAuthUI.a rmf;
  private SDKOAuthUI.b rmg;
  private com.tencent.mm.ui.widget.b.a rmh;
  private boolean rmi;
  private ad rmj;
  
  private void Ca(int paramInt)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SdkOAuthUI", "dealWithCancel");
    if (this.rmb == null) {
      return;
    }
    String str1 = Sf(this.mAppId);
    String str2 = this.mAppId;
    String str3 = this.rmb.state;
    if (this.rmf == null) {}
    for (Object localObject = null;; localObject = this.rmf.cdG())
    {
      localObject = new com.tencent.mm.plugin.webview.model.y(2, str2, str3, str1, (LinkedList)localObject);
      au.Dk().a((m)localObject, 0);
      localObject = new SendAuth.Resp();
      ((SendAuth.Resp)localObject).transaction = this.rmb.transaction;
      ((SendAuth.Resp)localObject).errCode = paramInt;
      ((SendAuth.Resp)localObject).lang = cbS();
      ((SendAuth.Resp)localObject).country = getCountry();
      a(str1, (SendAuth.Resp)localObject);
      return;
    }
  }
  
  private boolean Cu(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, errType = " + paramInt);
      return false;
    }
    if (!aq.isConnected(this))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, not connected");
      return false;
    }
    return true;
  }
  
  private void Dg(String paramString)
  {
    com.tencent.mm.ui.base.h.a(this, paramString, getString(R.l.wechat_auth_failed), new SDKOAuthUI.9(this, paramString));
  }
  
  private static String Sf(String paramString)
  {
    com.tencent.mm.pluginsdk.model.app.f localf = com.tencent.mm.pluginsdk.model.app.g.by(paramString, false);
    if (localf != null) {
      return localf.field_packageName;
    }
    com.tencent.mm.sdk.platformtools.y.w("MicroMsg.SdkOAuthUI", "dealWithCancel getAppInfo null; appid: %s", new Object[] { paramString });
    return null;
  }
  
  private void Tf(String paramString)
  {
    String str1 = null;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SdkOAuthUI", "dealWithLoginCallback url : %s", new Object[] { paramString });
    String str2 = Sf(this.mAppId);
    if (bk.bl(str2))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SdkOAuthUI", "dealWithLoginCallback pkg nil");
      return;
    }
    SendAuth.Resp localResp = new SendAuth.Resp();
    localResp.transaction = this.rmb.transaction;
    localResp.lang = cbS();
    localResp.country = getCountry();
    if (!bk.bl(paramString)) {}
    for (Uri localUri = Uri.parse(paramString);; localUri = null)
    {
      if (localUri != null)
      {
        str1 = localUri.getQueryParameter("code");
        localResp.state = localUri.getQueryParameter("state");
        localResp.errStr = localUri.getQueryParameter("reason");
      }
      if (bk.bl(str1)) {
        localResp.errCode = -1;
      }
      for (;;)
      {
        localResp.url = paramString;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SdkOAuthUI", "dealWithLoginCallback, pkg:%s code:%s errCode:%d state:%s", new Object[] { str2, localResp.code, Integer.valueOf(localResp.errCode), localResp.state });
        a(str2, localResp);
        finish();
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
  
  private void Tg(String paramString)
  {
    com.tencent.mm.ui.base.h.b(this, paramString, getString(R.l.new_sdk_oauth_login_delavatar_failed), true);
  }
  
  private void a(bnf parambnf, Class<?> paramClass)
  {
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.mAppId);
    paramClass.putExtra("1", this.rmb.transaction);
    paramClass.putExtra("4", this.rmb.state);
    try
    {
      paramClass.putExtra("2", parambnf.toByteArray());
      startActivity(paramClass);
      return;
    }
    catch (IOException parambnf)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void a(bnf parambnf, Class<?> paramClass, int paramInt1, int paramInt2)
  {
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.mAppId);
    paramClass.putExtra("1", this.rmb.transaction);
    paramClass.putExtra("4", this.rmb.state);
    paramClass.putExtra("3", paramInt1);
    paramClass.putExtra("5", paramInt2);
    try
    {
      paramClass.putExtra("2", parambnf.toByteArray());
      startActivity(paramClass);
      return;
    }
    catch (IOException parambnf)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void a(String paramString, SendAuth.Resp paramResp)
  {
    if (this.rfN) {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SdkOAuthUI", "doCallback has callback");
    }
    while (bk.bl(paramString)) {
      return;
    }
    this.rfN = true;
    Bundle localBundle = new Bundle();
    paramResp.toBundle(localBundle);
    com.tencent.mm.pluginsdk.model.app.p.ak(localBundle);
    paramResp = new MMessageActV2.Args();
    paramResp.targetPkgName = paramString;
    paramResp.bundle = localBundle;
    MMessageActV2.send(this, paramResp);
  }
  
  private String cbS()
  {
    return com.tencent.mm.sdk.platformtools.x.d(getSharedPreferences(ae.cqR(), 0));
  }
  
  private void cdD()
  {
    if (this.rmi) {
      return;
    }
    if (this.rmg.getCount() >= rmd)
    {
      findViewById(R.h.create_avatar).setVisibility(8);
      findViewById(R.h.upper_bound_hint).setVisibility(0);
      findViewById(R.h.upper_bound_hint_line).setVisibility(4);
      return;
    }
    findViewById(R.h.create_avatar).setVisibility(0);
    findViewById(R.h.upper_bound_hint).setVisibility(8);
    findViewById(R.h.upper_bound_hint_line).setVisibility(0);
  }
  
  private void cdE()
  {
    if ((this.dpF != null) && (!this.dpF.isShowing()))
    {
      this.dpF.show();
      return;
    }
    this.dpF = com.tencent.mm.ui.base.h.b(this, getString(R.l.oauth_logining), true, new SDKOAuthUI.10(this));
  }
  
  private void cdF()
  {
    if (this.dpF == null) {
      return;
    }
    this.dpF.dismiss();
  }
  
  private static String getCountry()
  {
    au.Hx();
    return bk.aM((String)com.tencent.mm.model.c.Dz().get(274436, null), null);
  }
  
  protected final int getLayoutId()
  {
    return R.i.sdk_oauth;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SdkOAuthUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SdkOAuthUI", "Create avatar cancel or failed");
    }
    for (;;)
    {
      return;
      switch (paramInt1)
      {
      default: 
        return;
      }
      azp localazp = new azp();
      localazp.id = paramIntent.getIntExtra("id", -1);
      localazp.nickname = paramIntent.getStringExtra("nickname");
      localazp.tgf = paramIntent.getStringExtra("avatarurl");
      localazp.desc = null;
      paramIntent = this.rmg;
      if ((localazp.id != -1) && (paramIntent.rmp.size() < rmd)) {
        paramIntent.rmp.add(localazp);
      }
      for (paramInt1 = i; paramInt1 != 0; paramInt1 = 0)
      {
        SDKOAuthUI.b.a(this.rmg, localazp.id);
        cdD();
        this.rmg.notifyDataSetChanged();
        return;
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    super.onCreate(paramBundle);
    setMMTitle(getString(R.l.new_sdk_oauth_login_title));
    mT(false);
    b(null, new SDKOAuthUI.1(this));
    if (!au.DK())
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SdkOAuthUI", "start, hasSetUin fail");
      Toast.makeText(this, R.l.account_not_login, 1).show();
      return;
    }
    this.rfN = false;
    paramBundle = getIntent().getExtras();
    String str1 = paramBundle.getString("_mmessage_content");
    if (bk.bl(str1))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SdkOAuthUI", "init content is nil");
      return;
    }
    this.mAppId = Uri.parse(str1).getQueryParameter("appid");
    if (bk.bl(this.mAppId))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SdkOAuthUI", "parseAppId try case not sensitive, content:%s", new Object[] { str1 });
      this.mAppId = Uri.parse(str1.toLowerCase()).getQueryParameter("appid");
    }
    str1 = this.mAppId;
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.g.by(str1, false);
    if ((localObject2 != null) && (bk.bl(((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_openId)))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SdkOAuthUI", "checkGetAppSetting appId: %s ", new Object[] { str1 });
      localObject2 = new he();
      ((he)localObject2).bPb.appId = str1;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
    }
    this.rmb = new SendAuth.Req(paramBundle);
    this.rmj = new ad(this, this.mAppId, this.rmb.transaction, this.rmb.state);
    str1 = this.mAppId;
    localObject2 = this.rmb.scope;
    String str2 = this.rmb.state;
    String str3 = Sf(this.mAppId);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorize appid: %s", new Object[] { str1 });
    cdE();
    if (bk.bl(str3)) {
      paramBundle = localObject1;
    }
    for (;;)
    {
      paramBundle = new com.tencent.mm.plugin.webview.model.x(str1, (String)localObject2, str2, str3, paramBundle);
      au.Dk().a(paramBundle, 0);
      return;
      paramBundle = com.tencent.mm.pluginsdk.model.app.p.bj(this, str3);
      if ((paramBundle == null) || (paramBundle.length == 0))
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SdkOAuthUI", "getSignature signatures failed");
        paramBundle = localObject1;
      }
      else
      {
        paramBundle = com.tencent.mm.a.g.o(paramBundle[0].toByteArray());
      }
    }
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 1, 0, getString(R.l.new_sdk_oauth_login_delavatar));
  }
  
  protected final void onDestroy()
  {
    super.onDestroy();
    if (this.dpF != null) {
      this.dpF.dismiss();
    }
    if (this.rme != null) {
      this.rme.stopTimer();
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      Ca(-2);
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected final void onPause()
  {
    super.onPause();
    au.Dk().b(1388, this);
    au.Dk().b(1346, this);
    au.Dk().b(2700, this);
  }
  
  protected final void onResume()
  {
    super.onResume();
    au.Dk().a(1346, this);
    au.Dk().a(1388, this);
    au.Dk().a(2700, this);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.webview.model.x))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      cdF();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (bnf)((com.tencent.mm.plugin.webview.model.x)paramm).dmK.ecF.ecN;
        if ((paramString.tvK) || (paramString.tvL))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd direct login");
          com.tencent.mm.model.gdpr.c.a(this, com.tencent.mm.model.gdpr.a.dYv, this.mAppId, new SDKOAuthUI.12(this, paramString));
        }
      }
    }
    do
    {
      return;
      if (paramString.tGl)
      {
        if (ad.d("snsapi_userinfo", paramString.tvI) != null)
        {
          paramm = (TextView)findViewById(R.h.auth_content);
          localObject1 = paramString.tvI.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (azs)((Iterator)localObject1).next();
            if (((azs)localObject2).scope.equals("snsapi_userinfo")) {
              paramm.setText(((azs)localObject2).desc);
            }
          }
          paramm.getPaint().setFakeBoldText(true);
          paramm = (ImageView)findViewById(R.h.new_app_icon_iv);
          localObject1 = (TextView)findViewById(R.h.new_app_name_tv);
          localObject2 = new c.a();
          ((c.a)localObject2).eru = R.k.native_oauth_default_head_img;
          o.ON().a(paramString.tvJ, paramm, ((c.a)localObject2).OV());
          ((TextView)localObject1).setText(paramString.dRQ);
          ((TextView)localObject1).getPaint().setFakeBoldText(true);
          paramm = (Button)findViewById(R.h.login_btn_agree_new);
          localObject1 = (Button)findViewById(R.h.login_btn_disagree_new);
          localObject2 = ad.d("snsapi_userinfo", paramString.tvI);
          paramm.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              SDKOAuthUI.a(SDKOAuthUI.this, paramString);
            }
          });
          ((Button)localObject1).setOnClickListener(new SDKOAuthUI.18(this, (azs)localObject2, paramString));
          rmd = paramString.tGn;
          this.rmh = new com.tencent.mm.ui.widget.b.a(this);
          this.rmg = new SDKOAuthUI.b(this, paramString.tGk, paramString.tGo);
          cdD();
          paramm = (ListView)findViewById(R.h.avatar_list);
          paramm.setAdapter(this.rmg);
          paramm.setOnItemClickListener(new SDKOAuthUI.19(this));
          paramm.setOnTouchListener(new SDKOAuthUI.20(this));
          paramm.setOnItemLongClickListener(new SDKOAuthUI.2(this));
          findViewById(R.h.create_avatar).setOnClickListener(new SDKOAuthUI.3(this));
          this.rmi = paramString.tGm;
          if (paramString.tGm) {
            findViewById(R.h.create_avatar_entry).setVisibility(8);
          }
          findViewById(R.h.new_root).setVisibility(0);
          return;
        }
        if (ad.d("snsapi_friend", paramString.tvI) != null)
        {
          a(paramString, SDKOAuthFriendUI.class);
          new ah().postDelayed(new SDKOAuthUI.14(this), 1000L);
          return;
        }
        a(paramString, SDKOAuthOtherUI.class);
        new ah().postDelayed(new SDKOAuthUI.15(this), 1000L);
        return;
      }
      paramm = (ImageView)findViewById(R.h.app_icon_iv);
      Object localObject1 = (TextView)findViewById(R.h.app_name_tv);
      Object localObject2 = new c.a();
      ((c.a)localObject2).eru = R.k.native_oauth_default_head_img;
      o.ON().a(paramString.tvJ, paramm, ((c.a)localObject2).OV());
      ((TextView)localObject1).setText(paramString.dRQ);
      paramm = (ListView)findViewById(R.h.auth_content_list);
      this.rmf = new SDKOAuthUI.a(this, paramString.tvI);
      paramm.setAdapter(this.rmf);
      ((Button)findViewById(R.h.login_btn)).setOnClickListener(new SDKOAuthUI.16(this, paramString));
      findViewById(R.h.root).setVisibility(0);
      return;
      if (!Cu(paramInt1))
      {
        Dg(getString(R.l.wechat_auth_network_failed));
        return;
      }
      Dg(paramString);
      return;
      if ((paramm instanceof com.tencent.mm.plugin.webview.model.y))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (this.rme != null) {
          this.rme.stopTimer();
        }
        cdF();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          Tf(((com.tencent.mm.plugin.webview.model.y)paramm).cbN().sLy);
          return;
        }
        if (!Cu(paramInt1))
        {
          Dg(getString(R.l.wechat_auth_network_failed));
          return;
        }
        Dg(paramString);
        return;
      }
    } while (!(paramm instanceof com.tencent.mm.plugin.webview.model.h));
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SdkOAuthUI", "onAddAvatarEnd errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.rmg.CA(this.rmc).id == SDKOAuthUI.b.a(this.rmg)) {
        SDKOAuthUI.b.a(this.rmg, this.rmg.CA(0).id);
      }
      paramString = this.rmg;
      paramInt1 = this.rmc;
      if (!paramString.rmp.remove(paramString.CA(paramInt1))) {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SdkOAuthUI", "remove avatar failed: not found");
      }
      cdD();
      this.rmg.notifyDataSetChanged();
      return;
    }
    if (!Cu(paramInt1))
    {
      Tg(getString(R.l.wechat_auth_network_failed));
      return;
    }
    Tg(paramString);
  }
  
  private static final class a$a
  {
    ImageView fYe;
    TextView fYf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI
 * JD-Core Version:    0.7.0.1
 */