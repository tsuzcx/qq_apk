package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.e;
import androidx.fragment.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.c;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.tools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

@com.tencent.mm.kernel.k
@SuppressLint({"DefaultLocale", "ValidFragment"})
@TargetApi(11)
public class ChattingUI
  extends MMSecDataFragmentActivity
{
  public ChattingUIFragment WCN;
  public MMHandler WCO;
  
  public ChattingUI()
  {
    AppMethodBeat.i(34694);
    this.WCO = new MMHandler();
    AppMethodBeat.o(34694);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34697);
    Log.d("MicroMsg.ChattingUI", "chatting ui dispatch key event %s", new Object[] { paramKeyEvent });
    if ((this.WCN != null) && (this.WCN.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      AppMethodBeat.o(34697);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(34697);
    return bool;
  }
  
  public void finish()
  {
    AppMethodBeat.i(279777);
    int i;
    Object localObject1;
    long l;
    Object localObject2;
    if ((this.WCN != null) && (((ai)this.WCN.fgR.bC(ai.class)).hQk()) && (!((ai)this.WCN.fgR.bC(ai.class)).hQn()))
    {
      i = ((ai)this.WCN.fgR.bC(ai.class)).hQp();
      getIntent().putExtra("select_record_msg_num", i);
      localObject1 = ((com.tencent.mm.ui.chatting.d.b.k)this.WCN.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hND();
      if (localObject1 != null)
      {
        localObject1 = ((Set)localObject1).iterator();
        l = 9223372036854775807L;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Long)((Iterator)localObject1).next();
          if (((Long)localObject2).longValue() >= l) {
            break label311;
          }
          l = ((Long)localObject2).longValue();
        }
      }
    }
    label311:
    for (;;)
    {
      break;
      getIntent().putExtra("select_record_min_msg_id", l);
      localObject2 = ((ai)this.WCN.fgR.bC(ai.class)).hQo();
      if (localObject2 != null)
      {
        localObject1 = new ArrayList();
        localObject2 = ((Set)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add(String.valueOf(((Long)((Iterator)localObject2).next()).longValue()));
        }
        getIntent().putStringArrayListExtra("key_select_record_msg_black_list", (ArrayList)localObject1);
      }
      Log.i("MicroMsg.ChattingUI", "select record msg %s", new Object[] { Integer.valueOf(i) });
      setResult(-1, getIntent());
      super.finish();
      AppMethodBeat.o(279777);
      return;
    }
  }
  
  protected ChattingUIFragment hLR()
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
    this.WCN.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(34701);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34695);
    getWindow().setFormat(-2);
    if ((!ar.hIH()) && (!ar.hII())) {
      h.aZ(this);
    }
    super.onCreate(null);
    if (c.bD(getIntent()))
    {
      finish();
      AppMethodBeat.o(34695);
      return;
    }
    setContentView(R.i.eeI);
    this.WCN = hLR();
    paramBundle = getIntent().getExtras();
    paramBundle.putBoolean("FROM_CHATTING_ACTIVITY", true);
    this.WCN.setArguments(paramBundle);
    getSupportFragmentManager().beginTransaction().a(R.h.dMA, this.WCN).in();
    getSupportActionBar().show();
    if (getIntent().getBooleanExtra("resend_fail_messages", false))
    {
      MMHandlerThread.postToMainThreadDelayed(new ChattingUI.1(this), 500L);
      getIntent().putExtra("is_need_resend_sns", false);
    }
    initNavigationSwipeBack();
    this.WCO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34693);
        if ((ChattingUI.this.WCN != null) && (!ar.hIH()) && (!ar.hII())) {
          h.a(ChattingUI.this, ChattingUI.this.WCN.getBodyView());
        }
        b.cs(ChattingUI.this.WCN.getContext());
        AppMethodBeat.o(34693);
      }
    });
    AppMethodBeat.o(34695);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34699);
    Log.d("MicroMsg.ChattingUI", "chatting ui on key down, %d, %s", new Object[] { Integer.valueOf(paramInt), paramKeyEvent });
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(34699);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34698);
    Log.d("MicroMsg.ChattingUI", "chatting ui on key up");
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(34698);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(279775);
    super.onPause();
    if (ar.hIH()) {
      bh.getNotification().dI(false);
    }
    AppMethodBeat.o(279775);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(34700);
    Log.i("MicroMsg.ChattingUI", "chatting onRequestPermissionsResult");
    this.WCN.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(34700);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(279774);
    super.onResume();
    if (ar.hIH()) {
      bh.getNotification().dI(true);
    }
    AppMethodBeat.o(279774);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(279778);
    if ((paramIntent != null) && (paramIntent.getComponent() != null))
    {
      y localy = y.XVr;
      y.bAI(paramIntent.getComponent().getClassName());
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(279778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUI
 * JD-Core Version:    0.7.0.1
 */