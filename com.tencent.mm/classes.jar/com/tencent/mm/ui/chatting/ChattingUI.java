package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.k;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.kernel.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.chatting.c.c;

@i
@SuppressLint({"DefaultLocale", "ValidFragment"})
@TargetApi(11)
public class ChattingUI
  extends MMFragmentActivity
{
  public ChattingUIFragment GpA;
  public ap GpB;
  
  public ChattingUI()
  {
    AppMethodBeat.i(34694);
    this.GpB = new ap();
    AppMethodBeat.o(34694);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34697);
    ad.d("MicroMsg.ChattingUI", "chatting ui dispatch key event %s", new Object[] { paramKeyEvent });
    if ((this.GpA != null) && (this.GpA.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      AppMethodBeat.o(34697);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(34697);
    return bool;
  }
  
  protected ChattingUIFragment eUw()
  {
    AppMethodBeat.i(34696);
    ChattingUIFragment localChattingUIFragment = new ChattingUIFragment((byte)0);
    AppMethodBeat.o(34696);
    return localChattingUIFragment;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34701);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.GpA.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(34701);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34695);
    getWindow().setFormat(-2);
    com.tencent.mm.pluginsdk.g.aJ(this);
    super.onCreate(null);
    if (c.bl(getIntent()))
    {
      finish();
      AppMethodBeat.o(34695);
      return;
    }
    setContentView(2131493526);
    this.GpA = eUw();
    paramBundle = getIntent().getExtras();
    paramBundle.putBoolean("FROM_CHATTING_ACTIVITY", true);
    this.GpA.setArguments(paramBundle);
    getSupportFragmentManager().beginTransaction().a(2131302341, this.GpA).commit();
    getSupportActionBar().show();
    if (getIntent().getBooleanExtra("resend_fail_messages", false))
    {
      aq.n(new ChattingUI.1(this), 500L);
      getIntent().putExtra("is_need_resend_sns", false);
    }
    initNavigationSwipeBack();
    this.GpB.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34693);
        if (ChattingUI.this.GpA != null) {
          com.tencent.mm.pluginsdk.g.a(ChattingUI.this, ChattingUI.this.GpA.getBodyView());
        }
        b.bY(ChattingUI.this.GpA.getContext());
        AppMethodBeat.o(34693);
      }
    });
    AppMethodBeat.o(34695);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34699);
    ad.d("MicroMsg.ChattingUI", "chatting ui on key down, %d, %s", new Object[] { Integer.valueOf(paramInt), paramKeyEvent });
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(34699);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34698);
    ad.d("MicroMsg.ChattingUI", "chatting ui on key up");
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(34698);
    return bool;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(34700);
    ad.i("MicroMsg.ChattingUI", "chatting onRequestPermissionsResult");
    this.GpA.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(34700);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUI
 * JD-Core Version:    0.7.0.1
 */