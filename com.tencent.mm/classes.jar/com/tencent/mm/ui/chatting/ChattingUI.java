package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.g;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.g.a.sj;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.c;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.tools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

@i
@SuppressLint({"DefaultLocale", "ValidFragment"})
@TargetApi(11)
public class ChattingUI
  extends MMSecDataFragmentActivity
{
  public ChattingUIFragment Pjl;
  public MMHandler Pjm;
  
  public ChattingUI()
  {
    AppMethodBeat.i(34694);
    this.Pjm = new MMHandler();
    AppMethodBeat.o(34694);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34697);
    Log.d("MicroMsg.ChattingUI", "chatting ui dispatch key event %s", new Object[] { paramKeyEvent });
    if ((this.Pjl != null) && (this.Pjl.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
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
    AppMethodBeat.i(232885);
    int i;
    Object localObject1;
    long l;
    Object localObject2;
    if ((this.Pjl != null) && (((ai)this.Pjl.dom.bh(ai.class)).gQN()) && (!((ai)this.Pjl.dom.bh(ai.class)).gQQ()))
    {
      i = ((ai)this.Pjl.dom.bh(ai.class)).gQS();
      getIntent().putExtra("select_record_msg_num", i);
      localObject1 = ((com.tencent.mm.ui.chatting.d.b.k)this.Pjl.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOs();
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
      localObject2 = ((ai)this.Pjl.dom.bh(ai.class)).gQR();
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
      AppMethodBeat.o(232885);
      return;
    }
  }
  
  protected ChattingUIFragment gMI()
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
    this.Pjl.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(34701);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34695);
    getWindow().setFormat(-2);
    if (!ao.gJK()) {
      com.tencent.mm.pluginsdk.h.aU(this);
    }
    super.onCreate(null);
    if (c.bC(getIntent()))
    {
      finish();
      AppMethodBeat.o(34695);
      return;
    }
    setContentView(2131493638);
    this.Pjl = gMI();
    paramBundle = getIntent().getExtras();
    paramBundle.putBoolean("FROM_CHATTING_ACTIVITY", true);
    this.Pjl.setArguments(paramBundle);
    getSupportFragmentManager().beginTransaction().a(2131304736, this.Pjl).commit();
    getSupportActionBar().show();
    if (getIntent().getBooleanExtra("resend_fail_messages", false))
    {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34692);
          com.tencent.mm.ui.base.h.c(ChattingUI.this, ChattingUI.this.getString(2131763672), "", ChattingUI.this.getString(2131763673), ChattingUI.this.getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(34690);
              paramAnonymous2DialogInterface = new sj();
              EventCenter.instance.publish(paramAnonymous2DialogInterface);
              AppMethodBeat.o(34690);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(34691);
              paramAnonymous2DialogInterface = new oh();
              EventCenter.instance.publish(paramAnonymous2DialogInterface);
              AppMethodBeat.o(34691);
            }
          });
          AppMethodBeat.o(34692);
        }
      }, 500L);
      getIntent().putExtra("is_need_resend_sns", false);
    }
    initNavigationSwipeBack();
    this.Pjm.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34693);
        if ((ChattingUI.this.Pjl != null) && (!ao.gJK())) {
          com.tencent.mm.pluginsdk.h.a(ChattingUI.this, ChattingUI.this.Pjl.getBodyView());
        }
        b.cw(ChattingUI.this.Pjl.getContext());
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
    AppMethodBeat.i(232884);
    super.onPause();
    if (ao.gJK()) {
      bg.getNotification().di(false);
    }
    AppMethodBeat.o(232884);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(34700);
    Log.i("MicroMsg.ChattingUI", "chatting onRequestPermissionsResult");
    this.Pjl.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(34700);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(232883);
    super.onResume();
    if (ao.gJK()) {
      bg.getNotification().di(true);
    }
    AppMethodBeat.o(232883);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(232886);
    if ((paramIntent != null) && (paramIntent.getComponent() != null))
    {
      x localx = x.Qxl;
      x.bnV(paramIntent.getComponent().getClassName());
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(232886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUI
 * JD-Core Version:    0.7.0.1
 */