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
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import java.util.List;

public abstract class VoiceInputLayout
  extends LinearLayout
{
  private b Dpq = null;
  private g Dpr;
  protected a Dps;
  public int currentState = 1;
  private int iep = g.ieO;
  private final au iga = new au(new au.a()
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
        VoiceInputLayout.this.FM(i);
      }
      AppMethodBeat.o(31287);
      return true;
    }
  }, true);
  private ao lso = new ao()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(31281);
      if (paramAnonymousMessage.what != 0)
      {
        if (paramAnonymousMessage.what == 1) {
          ac.w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
        }
      }
      else
      {
        ac.d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
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
  protected boolean sIv = false;
  private int sIw = 3000;
  private int sIx = 10000;
  private ao sIy = new ao()
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
        VoiceInputLayout.this.cMb();
        AppMethodBeat.o(31286);
        return;
        paramAnonymousMessage = paramAnonymousMessage.getData();
        VoiceInputLayout.this.ad(paramAnonymousMessage.getInt("localCode"), paramAnonymousMessage.getInt("errType"), paramAnonymousMessage.getInt("errCode"));
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
  
  protected abstract void FM(int paramInt);
  
  public final void aKQ()
  {
    ac.d("MicroMsg.VoiceInputLayout", "doCancel. state = %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState == 1) {
      return;
    }
    this.currentState = 1;
    if (this.Dpq != null) {
      this.Dpq.cLJ();
    }
    if (this.Dpr != null) {
      this.Dpr.cancel(true);
    }
    onReset();
  }
  
  public final void ad(int paramInt1, int paramInt2, int paramInt3)
  {
    ac.d("MicroMsg.VoiceInputLayout", "doNetworkError localerrorType:%s,errorType:%s,errCode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.currentState = 1;
    onReset();
    if (this.Dpq != null) {
      this.Dpq.aF(paramInt1, paramInt2, paramInt3);
    }
  }
  
  protected abstract void cLS();
  
  public final void cLZ()
  {
    if ((a.ci(getContext())) || (a.cf(getContext())) || (a.ck(getContext())))
    {
      ac.d("MicroMsg.VoiceInputLayout", "voip is running, cann't record voice");
      onReset();
    }
    do
    {
      do
      {
        return;
        boolean bool = b.o(getContext(), "android.permission.RECORD_AUDIO");
        ac.d("MicroMsg.VoiceInputLayout", "summerper checkPermission checkMicrophone[%s]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        ac.d("MicroMsg.VoiceInputLayout", "doStart currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
      } while (this.currentState != 1);
      this.currentState = 2;
      if (this.Dpq != null) {
        this.Dpq.cLF();
      }
      this.iga.au(50L, 50L);
      cLS();
      this.Dpr = new g(this.iep, 0, new g.b()
      {
        public final void aKH()
        {
          AppMethodBeat.i(31282);
          ac.d("MicroMsg.VoiceInputLayout", "onRecordFin() onRecordFin currentState = %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
          if (VoiceInputLayout.c(VoiceInputLayout.this) != null) {
            VoiceInputLayout.c(VoiceInputLayout.this).stopTimer();
          }
          VoiceInputLayout.d(VoiceInputLayout.this).sendEmptyMessage(0);
          AppMethodBeat.o(31282);
        }
        
        public final void aKL()
        {
          AppMethodBeat.i(31283);
          ac.d("MicroMsg.VoiceInputLayout", "onRecognize Finish");
          VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
          VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(1);
          if (VoiceInputLayout.e(VoiceInputLayout.this) != null) {
            VoiceInputLayout.e(VoiceInputLayout.this).cLL();
          }
          VoiceInputLayout.this.reset(false);
          AppMethodBeat.o(31283);
        }
        
        public final void b(String[] paramAnonymousArrayOfString, List<String> paramAnonymousList)
        {
          AppMethodBeat.i(31284);
          int j = paramAnonymousArrayOfString.length;
          int i = 0;
          while (i < j)
          {
            ac.d("SucconRes", "str: %s.", new Object[] { paramAnonymousArrayOfString[i] });
            i += 1;
          }
          if (VoiceInputLayout.e(VoiceInputLayout.this) != null) {
            VoiceInputLayout.e(VoiceInputLayout.this).c(paramAnonymousArrayOfString, paramAnonymousList);
          }
          VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
          VoiceInputLayout.a(VoiceInputLayout.this).sendEmptyMessageDelayed(0, VoiceInputLayout.f(VoiceInputLayout.this));
          AppMethodBeat.o(31284);
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
      this.Dpr.start();
      return;
    } while (!(getContext() instanceof Activity));
    b.b((Activity)getContext(), "android.permission.RECORD_AUDIO", 80);
  }
  
  public final void cMa()
  {
    ac.d("MicroMsg.VoiceInputLayout", "do Stop. currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
    if ((this.currentState == 1) || (this.currentState != 2)) {}
    do
    {
      return;
      this.currentState = 3;
      if (this.Dpq != null) {
        this.Dpq.cLI();
      }
      if (this.iga != null) {
        this.iga.stopTimer();
      }
      this.lso.removeMessages(0);
      this.lso.sendEmptyMessageDelayed(0, this.sIw);
      this.lso.sendEmptyMessageDelayed(1, this.sIx);
      gq(true);
    } while (this.Dpr == null);
    this.Dpr.stop(true);
  }
  
  public final void cMb()
  {
    ac.d("MicroMsg.VoiceInputLayout", "doWaiting currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState != 2) {
      return;
    }
    this.currentState = 3;
    this.lso.removeMessages(0);
    this.lso.sendEmptyMessageDelayed(0, this.sIw);
    this.lso.sendEmptyMessageDelayed(1, this.sIx);
    gq(false);
  }
  
  public final void cMc()
  {
    ad(12, -1, -1);
  }
  
  public final void eNi()
  {
    if (this.lso != null) {
      this.lso.removeCallbacksAndMessages(null);
    }
    if (this.sIy != null) {
      this.sIy.removeCallbacksAndMessages(null);
    }
    if (this.iga != null) {
      this.iga.stopTimer();
    }
  }
  
  public int getCurrentState()
  {
    return this.currentState;
  }
  
  protected abstract void gq(boolean paramBoolean);
  
  protected abstract void onReset();
  
  protected final void reset(boolean paramBoolean)
  {
    ac.d("MicroMsg.VoiceInputLayout", "reset currentState %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState == 1) {}
    do
    {
      return;
      this.currentState = 1;
      onReset();
    } while ((!paramBoolean) || (this.Dpq == null));
    this.Dpq.cLK();
  }
  
  public void setFromFullScreen(boolean paramBoolean)
  {
    this.sIv = paramBoolean;
  }
  
  public void setLangType(int paramInt)
  {
    this.iep = paramInt;
  }
  
  public void setLongClickLisnter(a parama)
  {
    this.Dps = parama;
  }
  
  public void setVoiceDetectListener(b paramb)
  {
    this.Dpq = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void cLO();
  }
  
  public static abstract interface b
  {
    public abstract void aF(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void c(String[] paramArrayOfString, List<String> paramList);
    
    public abstract void cLF();
    
    public abstract void cLI();
    
    public abstract void cLJ();
    
    public abstract void cLK();
    
    public abstract void cLL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputLayout
 * JD-Core Version:    0.7.0.1
 */