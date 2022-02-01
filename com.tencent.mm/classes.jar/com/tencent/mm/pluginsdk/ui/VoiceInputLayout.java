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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import java.util.List;

public abstract class VoiceInputLayout
  extends LinearLayout
{
  private b FmP = null;
  private g FmQ;
  protected a FmR;
  public int currentState = 1;
  private int iAD = g.iBb;
  private final aw iCn = new aw(new aw.a()
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
        VoiceInputLayout.this.Hy(i);
      }
      AppMethodBeat.o(31287);
      return true;
    }
  }, true);
  private aq lVY = new aq()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(31281);
      if (paramAnonymousMessage.what != 0)
      {
        if (paramAnonymousMessage.what == 1) {
          ae.w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
        }
      }
      else
      {
        ae.d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
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
  protected boolean tPX = false;
  private int tPY = 3000;
  private int tPZ = 10000;
  private aq tQa = new aq()
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
        VoiceInputLayout.this.cWZ();
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
  
  protected abstract void Hy(int paramInt);
  
  public final void aOx()
  {
    ae.d("MicroMsg.VoiceInputLayout", "doCancel. state = %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState == 1) {
      return;
    }
    this.currentState = 1;
    if (this.FmP != null) {
      this.FmP.cWH();
    }
    if (this.FmQ != null) {
      this.FmQ.cancel(true);
    }
    onReset();
  }
  
  public final void ad(int paramInt1, int paramInt2, int paramInt3)
  {
    ae.d("MicroMsg.VoiceInputLayout", "doNetworkError localerrorType:%s,errorType:%s,errCode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.currentState = 1;
    onReset();
    if (this.FmP != null) {
      this.FmP.aI(paramInt1, paramInt2, paramInt3);
    }
  }
  
  protected abstract void cWQ();
  
  public final void cWX()
  {
    if ((a.ch(getContext())) || (a.cf(getContext())) || (a.cj(getContext())))
    {
      ae.d("MicroMsg.VoiceInputLayout", "voip is running, cann't record voice");
      onReset();
    }
    do
    {
      do
      {
        return;
        boolean bool = b.n(getContext(), "android.permission.RECORD_AUDIO");
        ae.d("MicroMsg.VoiceInputLayout", "summerper checkPermission checkMicrophone[%s]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        ae.d("MicroMsg.VoiceInputLayout", "doStart currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
      } while (this.currentState != 1);
      this.currentState = 2;
      if (this.FmP != null) {
        this.FmP.cWD();
      }
      this.iCn.ay(50L, 50L);
      cWQ();
      this.FmQ = new g(this.iAD, 0, new g.b()
      {
        public final void aOo()
        {
          AppMethodBeat.i(31282);
          ae.d("MicroMsg.VoiceInputLayout", "onRecordFin() onRecordFin currentState = %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.currentState) });
          if (VoiceInputLayout.c(VoiceInputLayout.this) != null) {
            VoiceInputLayout.c(VoiceInputLayout.this).stopTimer();
          }
          VoiceInputLayout.d(VoiceInputLayout.this).sendEmptyMessage(0);
          AppMethodBeat.o(31282);
        }
        
        public final void aOs()
        {
          AppMethodBeat.i(31283);
          ae.d("MicroMsg.VoiceInputLayout", "onRecognize Finish");
          VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
          VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(1);
          if (VoiceInputLayout.e(VoiceInputLayout.this) != null) {
            VoiceInputLayout.e(VoiceInputLayout.this).cWJ();
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
            ae.d("SucconRes", "str: %s.", new Object[] { paramAnonymousArrayOfString[i] });
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
      this.FmQ.start();
      return;
    } while (!(getContext() instanceof Activity));
    b.b((Activity)getContext(), "android.permission.RECORD_AUDIO", 80);
  }
  
  public final void cWY()
  {
    ae.d("MicroMsg.VoiceInputLayout", "do Stop. currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
    if ((this.currentState == 1) || (this.currentState != 2)) {}
    do
    {
      return;
      this.currentState = 3;
      if (this.FmP != null) {
        this.FmP.cWG();
      }
      if (this.iCn != null) {
        this.iCn.stopTimer();
      }
      this.lVY.removeMessages(0);
      this.lVY.sendEmptyMessageDelayed(0, this.tPY);
      this.lVY.sendEmptyMessageDelayed(1, this.tPZ);
      gu(true);
    } while (this.FmQ == null);
    this.FmQ.stop(true);
  }
  
  public final void cWZ()
  {
    ae.d("MicroMsg.VoiceInputLayout", "doWaiting currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState != 2) {
      return;
    }
    this.currentState = 3;
    this.lVY.removeMessages(0);
    this.lVY.sendEmptyMessageDelayed(0, this.tPY);
    this.lVY.sendEmptyMessageDelayed(1, this.tPZ);
    gu(false);
  }
  
  public final void cXa()
  {
    ad(12, -1, -1);
  }
  
  public final void ffV()
  {
    if (this.lVY != null) {
      this.lVY.removeCallbacksAndMessages(null);
    }
    if (this.tQa != null) {
      this.tQa.removeCallbacksAndMessages(null);
    }
    if (this.iCn != null) {
      this.iCn.stopTimer();
    }
  }
  
  public int getCurrentState()
  {
    return this.currentState;
  }
  
  protected abstract void gu(boolean paramBoolean);
  
  protected abstract void onReset();
  
  protected final void reset(boolean paramBoolean)
  {
    ae.d("MicroMsg.VoiceInputLayout", "reset currentState %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState == 1) {}
    do
    {
      return;
      this.currentState = 1;
      onReset();
    } while ((!paramBoolean) || (this.FmP == null));
    this.FmP.cWI();
  }
  
  public void setFromFullScreen(boolean paramBoolean)
  {
    this.tPX = paramBoolean;
  }
  
  public void setLangType(int paramInt)
  {
    this.iAD = paramInt;
  }
  
  public void setLongClickLisnter(a parama)
  {
    this.FmR = parama;
  }
  
  public void setVoiceDetectListener(b paramb)
  {
    this.FmP = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void cWM();
  }
  
  public static abstract interface b
  {
    public abstract void aI(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void c(String[] paramArrayOfString, List<String> paramList);
    
    public abstract void cWD();
    
    public abstract void cWG();
    
    public abstract void cWH();
    
    public abstract void cWI();
    
    public abstract void cWJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputLayout
 * JD-Core Version:    0.7.0.1
 */