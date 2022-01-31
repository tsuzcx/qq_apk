package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.j;
import android.support.v4.app.o;
import android.support.v7.app.ActionBar;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.chatting.c.a;

public class AppBrandServiceChattingUI
  extends MMFragmentActivity
{
  public AppBrandServiceChattingUI.a vha;
  public ah vhb = new ah();
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    y.d("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingUI dispatch key event %s", new Object[] { paramKeyEvent });
    if ((this.vha != null) && (this.vha.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    getWindow().setFormat(-2);
    com.tencent.mm.pluginsdk.e.S(this);
    overridePendingTransition(0, 0);
    super.onCreate(null);
    if (getIntent().getStringExtra("Chat_User") == null)
    {
      finish();
      y.e("MicroMsg.AppBrandServiceChattingUI", "talker is null !!!");
      return;
    }
    setContentView(R.i.chattingui_activity_container);
    this.vha = new AppBrandServiceChattingUI.a((byte)0);
    paramBundle = getIntent().getExtras();
    paramBundle.putBoolean("FROM_APP_BRAND_CHATTING_ACTIVITY", true);
    this.vha.setArguments(paramBundle);
    getSupportFragmentManager().bP().a(R.h.mm_root_view, this.vha).commit();
    getSupportActionBar().show();
    if (getIntent().getBooleanExtra("resend_fail_messages", false))
    {
      ai.l(new AppBrandServiceChattingUI.1(this), 500L);
      getIntent().putExtra("is_need_resend_sns", false);
    }
    initNavigationSwipeBack();
    this.vhb.post(new AppBrandServiceChattingUI.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppBrandServiceChattingUI
 * JD-Core Version:    0.7.0.1
 */