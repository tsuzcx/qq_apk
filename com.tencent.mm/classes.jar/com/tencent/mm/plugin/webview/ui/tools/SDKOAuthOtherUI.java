package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
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
public class SDKOAuthOtherUI
  extends MMActivity
  implements f
{
  private String appId;
  private ad rlL;
  private bnf rlM;
  private int rlN;
  private SDKOAuthOtherUI.a rlT;
  private String state;
  private String transaction;
  
  private void ac(int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.SDKOAuthOtherUI", "accept go  MPGdprPolicyUtil.checkPolicy");
    c.a(this, com.tencent.mm.model.gdpr.a.dYv, this.appId, new SDKOAuthOtherUI.4(this, paramInt3, paramInt1, paramInt2));
  }
  
  protected final int getLayoutId()
  {
    return R.i.sdkoauth_other_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.onCreate(paramBundle);
    setMMTitle(getString(R.l.new_sdk_oauth_login_title));
    mT(false);
    b(null, new SDKOAuthOtherUI.1(this));
    paramBundle = getIntent();
    this.appId = paramBundle.getStringExtra("0");
    this.transaction = paramBundle.getStringExtra("1");
    label460:
    for (;;)
    {
      try
      {
        this.rlM = ((bnf)new bnf().aH(paramBundle.getByteArrayExtra("2")));
        this.state = paramBundle.getStringExtra("4");
        this.rlL = new ad(this, this.appId, this.transaction, this.state);
        this.rlN = paramBundle.getIntExtra("3", -1);
        Object localObject1 = (TextView)findViewById(R.h.auth_content_otherpage);
        ((TextView)localObject1).setText(R.l.new_sdk_oauth_login_third_scope_auth_content);
        ((TextView)localObject1).getPaint().setFakeBoldText(true);
        localObject1 = (ImageView)findViewById(R.h.new_app_icon_iv_otherpage);
        localObject2 = (TextView)findViewById(R.h.new_app_name_tv_otherpage);
        Object localObject3 = new c.a();
        ((c.a)localObject3).eru = R.k.native_oauth_default_head_img;
        o.ON().a(this.rlM.tvJ, (ImageView)localObject1, ((c.a)localObject3).OV());
        ((TextView)localObject2).setText(this.rlM.dRQ);
        ((TextView)localObject2).getPaint().setFakeBoldText(true);
        localObject1 = (ListView)findViewById(R.h.auth_content_list_otherpage);
        localObject2 = new LinkedList();
        localObject3 = this.rlM.tvI.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          azs localazs = (azs)((Iterator)localObject3).next();
          if ((localazs.scope.equals("snsapi_userinfo")) || (localazs.scope.equals("snsapi_friend"))) {
            break label460;
          }
          ((LinkedList)localObject2).add(localazs);
          if (localazs.tvP != 3) {
            break label460;
          }
          bool = true;
        }
      }
      catch (IOException localIOException)
      {
        y.e("MicroMsg.SDKOAuthOtherUI", "SdkOauthAuthorizeResp parseFrom byteArray failed");
        continue;
        this.rlT = new SDKOAuthOtherUI.a(this, (LinkedList)localObject2);
        localIOException.setAdapter(this.rlT);
        Button localButton = (Button)findViewById(R.h.login_btn_agree_otherpage);
        Object localObject2 = (Button)findViewById(R.h.login_btn_disagree_otherpage);
        int i = paramBundle.getIntExtra("5", -2);
        int j = paramBundle.getIntExtra("6", -2);
        localButton.setOnClickListener(new SDKOAuthOtherUI.2(this, i, j));
        ((Button)localObject2).setOnClickListener(new SDKOAuthOtherUI.3(this, bool, i, j));
        return;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI
 * JD-Core Version:    0.7.0.1
 */