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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.chatting.c.c;

@i
@SuppressLint({"DefaultLocale", "ValidFragment"})
@TargetApi(11)
public class ChattingUI
  extends MMFragmentActivity
{
  public ChattingUIFragment HPr;
  public ao HPs;
  
  public ChattingUI()
  {
    AppMethodBeat.i(34694);
    this.HPs = new ao();
    AppMethodBeat.o(34694);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34697);
    ac.d("MicroMsg.ChattingUI", "chatting ui dispatch key event %s", new Object[] { paramKeyEvent });
    if ((this.HPr != null) && (this.HPr.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      AppMethodBeat.o(34697);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(34697);
    return bool;
  }
  
  protected ChattingUIFragment fkj()
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
    this.HPr.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(34701);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34695);
    getWindow().setFormat(-2);
    com.tencent.mm.pluginsdk.g.aN(this);
    super.onCreate(null);
    if (c.bm(getIntent()))
    {
      finish();
      AppMethodBeat.o(34695);
      return;
    }
    setContentView(2131493526);
    this.HPr = fkj();
    paramBundle = getIntent().getExtras();
    paramBundle.putBoolean("FROM_CHATTING_ACTIVITY", true);
    this.HPr.setArguments(paramBundle);
    getSupportFragmentManager().beginTransaction().a(2131302341, this.HPr).commit();
    getSupportActionBar().show();
    if (getIntent().getBooleanExtra("resend_fail_messages", false))
    {
      ap.n(new ChattingUI.1(this), 500L);
      getIntent().putExtra("is_need_resend_sns", false);
    }
    initNavigationSwipeBack();
    this.HPs.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34693);
        if (ChattingUI.this.HPr != null) {
          com.tencent.mm.pluginsdk.g.a(ChattingUI.this, ChattingUI.this.HPr.getBodyView());
        }
        b.cb(ChattingUI.this.HPr.getContext());
        AppMethodBeat.o(34693);
      }
    });
    AppMethodBeat.o(34695);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34699);
    ac.d("MicroMsg.ChattingUI", "chatting ui on key down, %d, %s", new Object[] { Integer.valueOf(paramInt), paramKeyEvent });
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(34699);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34698);
    ac.d("MicroMsg.ChattingUI", "chatting ui on key up");
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(34698);
    return bool;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(34700);
    ac.i("MicroMsg.ChattingUI", "chatting onRequestPermissionsResult");
    this.HPr.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(34700);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUI
 * JD-Core Version:    0.7.0.1
 */