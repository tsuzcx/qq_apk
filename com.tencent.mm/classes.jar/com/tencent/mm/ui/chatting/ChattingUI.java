package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.g;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.g.a.no;
import com.tencent.mm.g.a.rm;
import com.tencent.mm.kernel.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.chatting.d.b.af;
import com.tencent.mm.ui.chatting.d.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

@i
@SuppressLint({"DefaultLocale", "ValidFragment"})
@TargetApi(11)
public class ChattingUI
  extends MMFragmentActivity
{
  public ChattingUIFragment JDf;
  public ap JDg;
  
  public ChattingUI()
  {
    AppMethodBeat.i(34694);
    this.JDg = new ap();
    AppMethodBeat.o(34694);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34697);
    ad.d("MicroMsg.ChattingUI", "chatting ui dispatch key event %s", new Object[] { paramKeyEvent });
    if ((this.JDf != null) && (this.JDf.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      AppMethodBeat.o(34697);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(34697);
    return bool;
  }
  
  protected ChattingUIFragment fAy()
  {
    AppMethodBeat.i(34696);
    ChattingUIFragment localChattingUIFragment = new ChattingUIFragment((byte)0);
    AppMethodBeat.o(34696);
    return localChattingUIFragment;
  }
  
  public void finish()
  {
    AppMethodBeat.i(193856);
    int i;
    Object localObject1;
    long l;
    Object localObject2;
    if ((((af)this.JDf.cWM.bh(af.class)).fEz()) && (!((af)this.JDf.cWM.bh(af.class)).fEC()))
    {
      i = ((af)this.JDf.cWM.bh(af.class)).fEE();
      getIntent().putExtra("select_record_msg_num", i);
      localObject1 = ((com.tencent.mm.ui.chatting.d.b.k)this.JDf.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCk();
      if (localObject1 != null)
      {
        localObject1 = ((Set)localObject1).iterator();
        l = 9223372036854775807L;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Long)((Iterator)localObject1).next();
          if (((Long)localObject2).longValue() >= l) {
            break label304;
          }
          l = ((Long)localObject2).longValue();
        }
      }
    }
    label304:
    for (;;)
    {
      break;
      getIntent().putExtra("select_record_min_msg_id", l);
      localObject2 = ((af)this.JDf.cWM.bh(af.class)).fED();
      if (localObject2 != null)
      {
        localObject1 = new ArrayList();
        localObject2 = ((Set)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add(String.valueOf(((Long)((Iterator)localObject2).next()).longValue()));
        }
        getIntent().putStringArrayListExtra("key_select_record_msg_black_list", (ArrayList)localObject1);
      }
      ad.i("MicroMsg.ChattingUI", "select record msg %s", new Object[] { Integer.valueOf(i) });
      setResult(-1, getIntent());
      super.finish();
      AppMethodBeat.o(193856);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34701);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.JDf.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(34701);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34695);
    getWindow().setFormat(-2);
    com.tencent.mm.pluginsdk.h.aN(this);
    super.onCreate(null);
    if (c.br(getIntent()))
    {
      finish();
      AppMethodBeat.o(34695);
      return;
    }
    setContentView(2131493526);
    this.JDf = fAy();
    paramBundle = getIntent().getExtras();
    paramBundle.putBoolean("FROM_CHATTING_ACTIVITY", true);
    this.JDf.setArguments(paramBundle);
    getSupportFragmentManager().beginTransaction().a(2131302341, this.JDf).commit();
    getSupportActionBar().show();
    if (getIntent().getBooleanExtra("resend_fail_messages", false))
    {
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34692);
          com.tencent.mm.ui.base.h.e(ChattingUI.this, ChattingUI.this.getString(2131761704), "", ChattingUI.this.getString(2131761705), ChattingUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(34690);
              paramAnonymous2DialogInterface = new rm();
              com.tencent.mm.sdk.b.a.IbL.l(paramAnonymous2DialogInterface);
              AppMethodBeat.o(34690);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(34691);
              paramAnonymous2DialogInterface = new no();
              com.tencent.mm.sdk.b.a.IbL.l(paramAnonymous2DialogInterface);
              AppMethodBeat.o(34691);
            }
          });
          AppMethodBeat.o(34692);
        }
      }, 500L);
      getIntent().putExtra("is_need_resend_sns", false);
    }
    initNavigationSwipeBack();
    this.JDg.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34693);
        if (ChattingUI.this.JDf != null) {
          com.tencent.mm.pluginsdk.h.a(ChattingUI.this, ChattingUI.this.JDf.getBodyView());
        }
        b.bZ(ChattingUI.this.JDf.getContext());
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
    this.JDf.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
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