package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.List;

public abstract class VoiceInputLayout
  extends LinearLayout
{
  private b KdH = null;
  private g KdI;
  protected VoiceInputLayout.a KdJ;
  public int currentState = 1;
  private int jvS = g.jwq;
  private final MTimerHandler jxC = new MTimerHandler(new MTimerHandler.CallBack()
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(31287);
      if (VoiceInputLayout.b(VoiceInputLayout.this) == null)
      {
        AppMethodBeat.o(31287);
        return true;
      }
      int i = VoiceInputLayout.b(VoiceInputLayout.this).getMaxAmplitudeRate();
      if (VoiceInputLayout.this.currentState == 2) {
        VoiceInputLayout.this.Ny(i);
      }
      AppMethodBeat.o(31287);
      return true;
    }
  }, true);
  private MMHandler ndA = new MMHandler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(31281);
      if (paramAnonymousMessage.what != 0)
      {
        if (paramAnonymousMessage.what == 1) {
          Log.w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
        }
      }
      else
      {
        Log.d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
        if (VoiceInputLayout.this.currentState == 3) {
          break label94;
        }
        AppMethodBeat.o(31281);
        return;
      }
      AppMethodBeat.o(31281);
      return;
      label94:
      VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
      VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(1);
      if (VoiceInputLayout.b(VoiceInputLayout.this) != null) {
        VoiceInputLayout.b(VoiceInputLayout.this).cancel(true);
      }
      VoiceInputLayout.this.reset(true);
      AppMethodBeat.o(31281);
    }
  };
  protected boolean xhk = false;
  private int xhl = 3000;
  private int xhm = 10000;
  private MMHandler xhn = new MMHandler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(31286);
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(31286);
        return;
        VoiceInputLayout.this.dQo();
        AppMethodBeat.o(31286);
        return;
        paramAnonymousMessage = paramAnonymousMessage.getData();
        VoiceInputLayout.this.ai(paramAnonymousMessage.getInt("localCode"), paramAnonymousMessage.getInt("errType"), paramAnonymousMessage.getInt("errCode"));
      }
    }
  };
  
  public VoiceInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public VoiceInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected abstract void Ny(int paramInt);
  
  public final void ai(int paramInt1, int paramInt2, int paramInt3)
  {
    Log.d("MicroMsg.VoiceInputLayout", "doNetworkError localerrorType:%s,errorType:%s,errCode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.currentState = 1;
    onReset();
    if (this.KdH != null) {
      this.KdH.aQ(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public final void biE()
  {
    Log.d("MicroMsg.VoiceInputLayout", "doCancel. state = %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState == 1) {
      return;
    }
    this.currentState = 1;
    if (this.KdH != null) {
      this.KdH.dPR();
    }
    if (this.KdI != null) {
      this.KdI.cancel(true);
    }
    onReset();
  }
  
  protected abstract void dPZ();
  
  public final void dQm()
  {
    if ((a.cC(getContext())) || (a.cA(getContext())) || (a.cE(getContext())))
    {
      Log.d("MicroMsg.VoiceInputLayout", "voip is running, cann't record voice");
      onReset();
    }
    do
    {
      do
      {
        return;
        boolean bool = b.n(getContext(), "android.permission.RECORD_AUDIO");
        Log.d("MicroMsg.VoiceInputLayout", "summerper checkPermission checkMicrophone[%s]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        Log.d("MicroMsg.VoiceInputLayout", "doStart currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
      } while (this.currentState != 1);
      this.currentState = 2;
      if (this.KdH != null) {
        this.KdH.dPN();
      }
      this.jxC.startTimer(50L);
      dPZ();
      this.KdI = new g(this.jvS, 0, new g.b()
      {
        public final void b(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
        {
          AppMethodBeat.i(31284);
          int j = paramAnonymousArrayOfString.length;
          int i = 0;
          while (i < j)
          {
            Log.d("SucconRes", "str: %s.", new Object[] { paramAnonymousArrayOfString[i] });
            i += 1;
          }
          if (VoiceInputLayout.e(VoiceInputLayout.this) != null) {
            VoiceInputLayout.e(VoiceInputLayout.this).c(paramAnonymousArrayOfString, paramAnonymousList);
          }
          VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
          VoiceInputLayout.a(VoiceInputLayout.this).sendEmptyMessageDelayed(0, VoiceInputLayout.f(VoiceInputLayout.this));
          AppMethodBeat.o(31284);
        }
        
        public final void biv()
        {
          AppMethodBeat.i(31282);
          Log.d("MicroMsg.VoiceInputLayout", "onRecordFin() onRecordFin currentState = %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
          if (VoiceInputLayout.c(VoiceInputLayout.this) != null) {
            VoiceInputLayout.c(VoiceInputLayout.this).stopTimer();
          }
          VoiceInputLayout.d(VoiceInputLayout.this).sendEmptyMessage(0);
          AppMethodBeat.o(31282);
        }
        
        public final void biz()
        {
          AppMethodBeat.i(31283);
          Log.d("MicroMsg.VoiceInputLayout", "onRecognize Finish");
          VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
          VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(1);
          if (VoiceInputLayout.e(VoiceInputLayout.this) != null) {
            VoiceInputLayout.e(VoiceInputLayout.this).dPT();
          }
          VoiceInputLayout.this.reset(false);
          AppMethodBeat.o(31283);
        }
        
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong)
        {
          AppMethodBeat.i(31285);
          VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
          VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(1);
          Message localMessage = new Message();
          Bundle localBundle = new Bundle();
          localBundle.putInt("localCode", paramAnonymousInt1);
          localBundle.putInt("errType", paramAnonymousInt2);
          localBundle.putInt("errCode", paramAnonymousInt3);
          localMessage.setData(localBundle);
          localMessage.what = 1;
          VoiceInputLayout.d(VoiceInputLayout.this).sendMessage(localMessage);
          AppMethodBeat.o(31285);
        }
      });
      this.KdI.start();
      return;
    } while (!(getContext() instanceof Activity));
    b.b((Activity)getContext(), "android.permission.RECORD_AUDIO", 80);
  }
  
  public final void dQn()
  {
    Log.d("MicroMsg.VoiceInputLayout", "do Stop. currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
    if ((this.currentState == 1) || (this.currentState != 2)) {}
    do
    {
      return;
      this.currentState = 3;
      if (this.KdH != null) {
        this.KdH.dPQ();
      }
      if (this.jxC != null) {
        this.jxC.stopTimer();
      }
      this.ndA.removeMessages(0);
      this.ndA.sendEmptyMessageDelayed(0, this.xhl);
      this.ndA.sendEmptyMessageDelayed(1, this.xhm);
      hs(true);
    } while (this.KdI == null);
    this.KdI.stop(true);
  }
  
  public final void dQo()
  {
    Log.d("MicroMsg.VoiceInputLayout", "doWaiting currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState != 2) {
      return;
    }
    this.currentState = 3;
    this.ndA.removeMessages(0);
    this.ndA.sendEmptyMessageDelayed(0, this.xhl);
    this.ndA.sendEmptyMessageDelayed(1, this.xhm);
    hs(false);
  }
  
  public final void dQp()
  {
    ai(12, -1, -1);
  }
  
  public int getCurrentState()
  {
    return this.currentState;
  }
  
  public final void gpe()
  {
    if (this.ndA != null) {
      this.ndA.removeCallbacksAndMessages(null);
    }
    if (this.xhn != null) {
      this.xhn.removeCallbacksAndMessages(null);
    }
    if (this.jxC != null) {
      this.jxC.stopTimer();
    }
  }
  
  protected abstract void hs(boolean paramBoolean);
  
  protected abstract void onReset();
  
  protected final void reset(boolean paramBoolean)
  {
    Log.d("MicroMsg.VoiceInputLayout", "reset currentState %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState == 1) {}
    do
    {
      return;
      this.currentState = 1;
      onReset();
    } while ((!paramBoolean) || (this.KdH == null));
    this.KdH.dPS();
  }
  
  public void setFromFullScreen(boolean paramBoolean)
  {
    this.xhk = paramBoolean;
  }
  
  public void setLangType(int paramInt)
  {
    this.jvS = paramInt;
  }
  
  public void setLongClickLisnter(VoiceInputLayout.a parama)
  {
    this.KdJ = parama;
  }
  
  public void setVoiceDetectListener(b paramb)
  {
    this.KdH = paramb;
  }
  
  public static abstract interface b
  {
    public abstract void aQ(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void c(String[] paramArrayOfString, List<String> paramList);
    
    public abstract void dPN();
    
    public abstract void dPQ();
    
    public abstract void dPR();
    
    public abstract void dPS();
    
    public abstract void dPT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputLayout
 * JD-Core Version:    0.7.0.1
 */