package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.webview.model.ad;
import com.tencent.mm.protocal.c.azs;
import com.tencent.mm.protocal.c.bnf;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class SDKOAuthFriendUI
  extends MMActivity
  implements f
{
  private String appId;
  private ad rlL;
  private bnf rlM;
  private int rlN;
  private String state;
  private String transaction;
  
  private void Cy(int paramInt)
  {
    y.i("MicroMsg.SDKOAuthFriendUI", "accept go  MPGdprPolicyUtil.checkPolicy");
    c.a(this, com.tencent.mm.model.gdpr.a.dYv, this.appId, new SDKOAuthFriendUI.9(this, paramInt));
  }
  
  private void a(bnf parambnf, Class<?> paramClass, int paramInt)
  {
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.appId);
    paramClass.putExtra("1", this.transaction);
    paramClass.putExtra("4", this.state);
    paramClass.putExtra("6", paramInt);
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
        y.e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void a(bnf parambnf, Class<?> paramClass, int paramInt1, int paramInt2, int paramInt3)
  {
    paramClass = new Intent(this, paramClass);
    paramClass.putExtra("0", this.appId);
    paramClass.putExtra("1", this.transaction);
    paramClass.putExtra("4", this.state);
    paramClass.putExtra("3", paramInt1);
    paramClass.putExtra("5", paramInt2);
    paramClass.putExtra("6", paramInt3);
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
        y.e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp toByteArray failed");
      }
    }
  }
  
  private void eJ(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.SDKOAuthFriendUI", "accept go  MPGdprPolicyUtil.checkPolicy");
    c.a(this, com.tencent.mm.model.gdpr.a.dYv, this.appId, new SDKOAuthFriendUI.8(this, paramInt1, paramInt2));
  }
  
  protected final int getLayoutId()
  {
    return R.i.sdkoauth_friend_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(getString(R.l.new_sdk_oauth_login_title));
    mT(false);
    b(null, new SDKOAuthFriendUI.1(this));
    paramBundle = getIntent();
    this.appId = paramBundle.getStringExtra("0");
    this.transaction = paramBundle.getStringExtra("1");
    try
    {
      this.rlM = ((bnf)new bnf().aH(paramBundle.getByteArrayExtra("2")));
      this.state = paramBundle.getStringExtra("4");
      this.rlL = new ad(this, this.appId, this.transaction, this.state);
      this.rlN = paramBundle.getIntExtra("3", -1);
      TextView localTextView = (TextView)findViewById(R.h.auth_content_friendpage);
      localObject2 = this.rlM.tvI.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (azs)((Iterator)localObject2).next();
        if (((azs)localObject3).scope.equals("snsapi_friend")) {
          localTextView.setText(((azs)localObject3).desc);
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp parseFrom byteArray failed");
      }
      localIOException.getPaint().setFakeBoldText(true);
      Object localObject1 = (ImageView)findViewById(R.h.new_app_icon_iv_friendpage);
      Object localObject2 = (TextView)findViewById(R.h.new_app_name_tv_friendpage);
      Object localObject3 = new c.a();
      ((c.a)localObject3).eru = R.k.native_oauth_default_head_img;
      o.ON().a(this.rlM.tvJ, (ImageView)localObject1, ((c.a)localObject3).OV());
      ((TextView)localObject2).setText(this.rlM.dRQ);
      ((TextView)localObject2).getPaint().setFakeBoldText(true);
      localObject1 = (Button)findViewById(R.h.login_btn_agree_friendpage);
      localObject2 = (Button)findViewById(R.h.login_btn_disagree_friendpage);
      localObject3 = ad.d("snsapi_friend", this.rlM.tvI);
      int i = paramBundle.getIntExtra("5", -1);
      ((Button)localObject1).setOnClickListener(new SDKOAuthFriendUI.2(this, i));
      ((Button)localObject2).setOnClickListener(new SDKOAuthFriendUI.3(this, (azs)localObject3, i));
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.rlL.Ca(-2);
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    au.Dk().b(1346, this);
  }
  
  protected void onResume()
  {
    super.onResume();
    au.Dk().a(1346, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    this.rlL.k(paramInt1, paramInt2, paramString, paramm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthFriendUI
 * JD-Core Version:    0.7.0.1
 */