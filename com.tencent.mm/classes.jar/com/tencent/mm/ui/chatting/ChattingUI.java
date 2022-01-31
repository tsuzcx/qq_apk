package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.kernel.i;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.chatting.c.c;

@i
@SuppressLint({"DefaultLocale", "ValidFragment"})
@TargetApi(11)
public class ChattingUI
  extends MMFragmentActivity
{
  public ChattingUIFragment zBm;
  public ak zBn;
  
  public ChattingUI()
  {
    AppMethodBeat.i(30821);
    this.zBn = new ak();
    AppMethodBeat.o(30821);
  }
  
  protected ChattingUIFragment dFB()
  {
    AppMethodBeat.i(30823);
    ChattingUIFragment localChattingUIFragment = new ChattingUIFragment((byte)0);
    AppMethodBeat.o(30823);
    return localChattingUIFragment;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(30824);
    ab.d("MicroMsg.ChattingUI", "chatting ui dispatch key event %s", new Object[] { paramKeyEvent });
    if ((this.zBm != null) && (this.zBm.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      AppMethodBeat.o(30824);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(30824);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(30828);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.zBm.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(30828);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30822);
    getWindow().setFormat(-2);
    f.ao(this);
    super.onCreate(null);
    if (c.aS(getIntent()))
    {
      finish();
      AppMethodBeat.o(30822);
      return;
    }
    setContentView(2130969146);
    this.zBm = dFB();
    paramBundle = getIntent().getExtras();
    paramBundle.putBoolean("FROM_CHATTING_ACTIVITY", true);
    this.zBm.setArguments(paramBundle);
    getSupportFragmentManager().beginTransaction().a(2131821947, this.zBm).commit();
    getSupportActionBar().show();
    if (getIntent().getBooleanExtra("resend_fail_messages", false))
    {
      al.p(new ChattingUI.1(this), 500L);
      getIntent().putExtra("is_need_resend_sns", false);
    }
    initNavigationSwipeBack();
    this.zBn.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30820);
        if (ChattingUI.this.zBm != null) {
          f.a(ChattingUI.this, ChattingUI.this.zBm.getBodyView());
        }
        b.bJ(ChattingUI.this.zBm.getContext());
        AppMethodBeat.o(30820);
      }
    });
    AppMethodBeat.o(30822);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(30826);
    ab.d("MicroMsg.ChattingUI", "chatting ui on key down, %d, %s", new Object[] { Integer.valueOf(paramInt), paramKeyEvent });
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(30826);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(30825);
    ab.d("MicroMsg.ChattingUI", "chatting ui on key up");
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(30825);
    return bool;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(30827);
    ab.i("MicroMsg.ChattingUI", "chatting onRequestPermissionsResult");
    this.zBm.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(30827);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUI
 * JD-Core Version:    0.7.0.1
 */