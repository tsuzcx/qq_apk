package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
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
public class SDKOAuthOtherUI
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
  private SDKOAuthOtherUI.a vbw;
  
  private void ao(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(7521);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SDKOAuthOtherUI", "accept go  MPGdprPolicyUtil.checkPolicy");
    c.a(this, com.tencent.mm.model.gdpr.a.foA, this.appId, new SDKOAuthOtherUI.5(this, paramInt3, paramInt1, paramInt2));
    AppMethodBeat.o(7521);
  }
  
  private void ddv()
  {
    AppMethodBeat.i(153187);
    if (this.ehb == null)
    {
      AppMethodBeat.o(153187);
      return;
    }
    this.ehb.dismiss();
    AppMethodBeat.o(153187);
  }
  
  public int getLayoutId()
  {
    return 2130970623;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(7516);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131689615));
    hideActionbarLine();
    setMMTitle(getString(2131301817));
    setBackBtnVisible(false);
    setTitleBarClickListener(null, new SDKOAuthOtherUI.2(this));
    paramBundle = getIntent();
    this.appId = paramBundle.getStringExtra("0");
    this.transaction = paramBundle.getStringExtra("1");
    label588:
    for (;;)
    {
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
          Object localObject1 = (TextView)findViewById(2131827486);
          ((TextView)localObject1).setText(2131301816);
          ((TextView)localObject1).getPaint().setFakeBoldText(true);
          localObject1 = (ImageView)findViewById(2131827484);
          localObject2 = (TextView)findViewById(2131827485);
          Object localObject3 = new c.a();
          ((c.a)localObject3).eNY = 2131231748;
          ((c.a)localObject3).eOl = getResources().getDimension(2131428650);
          ((c.a)localObject3).eOk = true;
          o.ahG().a(this.vbo.xvU, (ImageView)localObject1, ((c.a)localObject3).ahY());
          ((TextView)localObject2).setText(this.vbo.fhP);
          localObject1 = (ListView)findViewById(2131827487);
          localObject2 = new LinkedList();
          localObject3 = this.vbo.xvT.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            continue;
          }
          bgv localbgv = (bgv)((Iterator)localObject3).next();
          if ((localbgv.scope.equals("snsapi_userinfo")) || (localbgv.scope.equals("snsapi_login")) || (localbgv.scope.equals("group_sns_login")) || (localbgv.scope.equals("snsapi_friend"))) {
            break label588;
          }
          ((LinkedList)localObject2).add(localbgv);
          if (localbgv.xwa != 3) {
            break label588;
          }
          bool = true;
          continue;
        }
      }
      catch (IOException localIOException)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SDKOAuthOtherUI", "SdkOauthAuthorizeResp parseFrom byteArray failed");
        continue;
        this.vbn = new ai(this, this.appId, this.transaction, this.state);
        continue;
        this.vbw = new SDKOAuthOtherUI.a(this, (LinkedList)localObject2);
        localIOException.setAdapter(this.vbw);
        Button localButton = (Button)findViewById(2131827488);
        Object localObject2 = (Button)findViewById(2131827489);
        int i = paramBundle.getIntExtra("5", -2);
        int j = paramBundle.getIntExtra("6", -2);
        this.startTime = System.currentTimeMillis();
        localButton.setOnClickListener(new SDKOAuthOtherUI.3(this, i, j));
        ((Button)localObject2).setOnClickListener(new SDKOAuthOtherUI.4(this, bool, i, j));
        AppMethodBeat.o(7516);
        return;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(153186);
    super.onDestroy();
    ddv();
    AppMethodBeat.o(153186);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(7519);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      com.tencent.mm.plugin.webview.f.a.vtM.a(this.appId, this.startTime, 0, this.accountType, 4, 1, 0);
      this.vbn.JU(-2);
      finish();
      AppMethodBeat.o(7519);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(7519);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(7518);
    super.onPause();
    g.Rc().b(1346, this);
    g.Rc().b(1137, this);
    AppMethodBeat.o(7518);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(7517);
    super.onResume();
    g.Rc().a(1346, this);
    g.Rc().a(1137, this);
    AppMethodBeat.o(7517);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(7520);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.webview.f.a.vtM.a(this.appId, this.startTime, 2, this.accountType, 4, 1, paramInt2);
    }
    ddv();
    if ((paramm instanceof ad))
    {
      this.vbn.h(paramInt1, paramInt2, paramString, paramm);
      AppMethodBeat.o(7520);
      return;
    }
    if ((paramm instanceof com.tencent.mm.plugin.webview.model.ab)) {
      this.vbn.C(paramInt1, paramInt2, paramString);
    }
    AppMethodBeat.o(7520);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI
 * JD-Core Version:    0.7.0.1
 */