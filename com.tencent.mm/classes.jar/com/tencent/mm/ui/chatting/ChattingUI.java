package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.o;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.c;

@com.tencent.mm.kernel.j
@SuppressLint({"DefaultLocale", "ValidFragment"})
@TargetApi(11)
public class ChattingUI
  extends MMFragmentActivity
{
  public ah vhb = new ah();
  public y vlN;
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUI", "chatting ui dispatch key event %s", new Object[] { paramKeyEvent });
    if ((this.vlN != null) && (this.vlN.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.vlN.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    getWindow().setFormat(-2);
    e.S(this);
    super.onCreate(null);
    if (c.aq(getIntent()))
    {
      finish();
      return;
    }
    setContentView(R.i.chattingui_activity_container);
    this.vlN = new y((byte)0);
    paramBundle = getIntent().getExtras();
    paramBundle.putBoolean("FROM_CHATTING_ACTIVITY", true);
    this.vlN.setArguments(paramBundle);
    getSupportFragmentManager().bP().a(R.h.mm_root_view, this.vlN).commit();
    getSupportActionBar().show();
    if (getIntent().getBooleanExtra("resend_fail_messages", false))
    {
      ai.l(new Runnable()
      {
        public final void run()
        {
          h.a(ChattingUI.this, ChattingUI.this.getString(R.l.notification_need_resend_dialog_prompt), "", ChattingUI.this.getString(R.l.notification_need_resend_dialog_prompt_resend_now), ChattingUI.this.getString(R.l.app_cancel), new ChattingUI.1.1(this), new ChattingUI.1.2(this));
        }
      }, 500L);
      getIntent().putExtra("is_need_resend_sns", false);
    }
    initNavigationSwipeBack();
    this.vhb.post(new Runnable()
    {
      public final void run()
      {
        if (ChattingUI.this.vlN != null) {
          e.a(ChattingUI.this, ChattingUI.this.vlN.getBodyView());
        }
        b.bf(ChattingUI.this.vlN.getContext());
      }
    });
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUI", "chatting ui on key down, %d, %s", new Object[] { Integer.valueOf(paramInt), paramKeyEvent });
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUI", "chatting ui on key up");
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI", "chatting onRequestPermissionsResult");
    this.vlN.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUI
 * JD-Core Version:    0.7.0.1
 */