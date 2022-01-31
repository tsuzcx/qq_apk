package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.webview.model.ad;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.protocal.protobuf.bgv;
import com.tencent.mm.protocal.protobuf.bxa;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class SDKOAuthFriendUI
  extends MMActivity
  implements f
{
  private int accountType = 2;
  private String appId;
  private String cJr;
  private com.tencent.mm.ui.base.p ehb;
  private long startTime;
  private String state;
  private String transaction;
  private ai vbn;
  private bxa vbo;
  private int vbp;
  private boolean vbq = false;
  
  private void Kr(int paramInt)
  {
    AppMethodBeat.i(7501);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SDKOAuthFriendUI", "accept go  MPGdprPolicyUtil.checkPolicy");
    c.a(this, com.tencent.mm.model.gdpr.a.foA, this.appId, new SDKOAuthFriendUI.6(this, paramInt));
    AppMethodBeat.o(7501);
  }
  
  private void a(bxa parambxa, Class<?> paramClass, int paramInt)
  {
    AppMethodBeat.i(7502);
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.appId);
    paramClass.putExtra("1", this.transaction);
    paramClass.putExtra("4", this.state);
    paramClass.putExtra("6", paramInt);
    paramClass.putExtra("auth_raw_url", this.cJr);
    paramClass.putExtra("auth_from_scan", this.vbq);
    try
    {
      paramClass.putExtra("2", parambxa.toByteArray());
      startActivity(paramClass);
      AppMethodBeat.o(7502);
      return;
    }
    catch (IOException parambxa)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void a(bxa parambxa, Class<?> paramClass, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(7503);
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.appId);
    paramClass.putExtra("1", this.transaction);
    paramClass.putExtra("4", this.state);
    paramClass.putExtra("3", paramInt1);
    paramClass.putExtra("5", paramInt2);
    paramClass.putExtra("6", paramInt3);
    paramClass.putExtra("auth_raw_url", this.cJr);
    paramClass.putExtra("auth_from_scan", this.vbq);
    try
    {
      paramClass.putExtra("2", parambxa.toByteArray());
      startActivity(paramClass);
      AppMethodBeat.o(7503);
      return;
    }
    catch (IOException parambxa)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void ddv()
  {
    AppMethodBeat.i(153180);
    if (this.ehb == null)
    {
      AppMethodBeat.o(153180);
      return;
    }
    this.ehb.dismiss();
    AppMethodBeat.o(153180);
  }
  
  private void gO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7500);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SDKOAuthFriendUI", "accept go  MPGdprPolicyUtil.checkPolicy");
    c.a(this, com.tencent.mm.model.gdpr.a.foA, this.appId, new SDKOAuthFriendUI.5(this, paramInt1, paramInt2));
    AppMethodBeat.o(7500);
  }
  
  public int getLayoutId()
  {
    return 2130970622;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(7495);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131689615));
    hideActionbarLine();
    setMMTitle(getString(2131301817));
    setBackBtnVisible(false);
    setTitleBarClickListener(null, new SDKOAuthFriendUI.2(this));
    paramBundle = getIntent();
    this.appId = paramBundle.getStringExtra("0");
    this.transaction = paramBundle.getStringExtra("1");
    try
    {
      this.vbo = ((bxa)new bxa().parseFrom(paramBundle.getByteArrayExtra("2")));
      this.state = paramBundle.getStringExtra("4");
      this.vbq = paramBundle.getBooleanExtra("auth_from_scan", false);
      if (this.vbq)
      {
        this.accountType = 3;
        this.cJr = paramBundle.getStringExtra("auth_raw_url");
        this.vbn = new ai(this, this.appId, this.cJr);
        this.vbp = paramBundle.getIntExtra("3", -1);
        TextView localTextView = (TextView)findViewById(2131827481);
        localObject2 = this.vbo.xvT.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bgv)((Iterator)localObject2).next();
          if (((bgv)localObject3).scope.equals("snsapi_friend")) {
            localTextView.setText(((bgv)localObject3).desc);
          }
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp parseFrom byteArray failed");
        continue;
        this.vbn = new ai(this, this.appId, this.transaction, this.state);
      }
      localIOException.getPaint().setFakeBoldText(true);
      Object localObject1 = (ImageView)findViewById(2131827479);
      Object localObject2 = (TextView)findViewById(2131827480);
      Object localObject3 = new c.a();
      ((c.a)localObject3).eNY = 2131231748;
      ((c.a)localObject3).eOl = getResources().getDimension(2131428650);
      ((c.a)localObject3).eOk = true;
      o.ahG().a(this.vbo.xvU, (ImageView)localObject1, ((c.a)localObject3).ahY());
      ((TextView)localObject2).setText(this.vbo.fhP);
      localObject1 = (Button)findViewById(2131827482);
      localObject2 = (Button)findViewById(2131827483);
      localObject3 = ai.d("snsapi_friend", this.vbo.xvT);
      int i = paramBundle.getIntExtra("5", -1);
      this.startTime = System.currentTimeMillis();
      ((Button)localObject1).setOnClickListener(new SDKOAuthFriendUI.3(this, i));
      ((Button)localObject2).setOnClickListener(new SDKOAuthFriendUI.4(this, (bgv)localObject3, i));
      AppMethodBeat.o(7495);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(153179);
    super.onDestroy();
    ddv();
    AppMethodBeat.o(153179);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(7498);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.vbn.JU(-2);
      com.tencent.mm.plugin.webview.f.a.vtM.a(this.appId, this.startTime, 0, this.accountType, 3, 1, 0);
      finish();
      AppMethodBeat.o(7498);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(7498);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(7497);
    super.onPause();
    g.Rc().b(1346, this);
    g.Rc().b(1137, this);
    AppMethodBeat.o(7497);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(7496);
    super.onResume();
    g.Rc().a(1346, this);
    g.Rc().a(1137, this);
    AppMethodBeat.o(7496);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(7499);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.webview.f.a.vtM.a(this.appId, this.startTime, 2, this.accountType, 3, 1, paramInt2);
    }
    ddv();
    if ((paramm instanceof ad))
    {
      this.vbn.h(paramInt1, paramInt2, paramString, paramm);
      AppMethodBeat.o(7499);
      return;
    }
    if ((paramm instanceof com.tencent.mm.plugin.webview.model.ab)) {
      this.vbn.C(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(7499);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthFriendUI
 * JD-Core Version:    0.7.0.1
 */