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
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.List;

public abstract class VoiceInputLayout
  extends LinearLayout
{
  public int currentState = 1;
  private int gbb = g.gbA;
  private final ap gcG = new ap(new VoiceInputLayout.4(this), true);
  private ak ipC = new VoiceInputLayout.1(this);
  protected boolean ncm = false;
  private int ncn = 3000;
  private int nco = 10000;
  private ak ncp = new ak()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(27584);
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(27584);
        return;
        VoiceInputLayout.this.bDH();
        AppMethodBeat.o(27584);
        return;
        paramAnonymousMessage = paramAnonymousMessage.getData();
        VoiceInputLayout.this.U(paramAnonymousMessage.getInt("localCode"), paramAnonymousMessage.getInt("errType"), paramAnonymousMessage.getInt("errCode"));
      }
    }
  };
  private b vSv = null;
  private g vSw;
  protected a vSx;
  
  public VoiceInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public VoiceInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void U(int paramInt1, int paramInt2, int paramInt3)
  {
    ab.d("MicroMsg.VoiceInputLayout", "doNetworkError localerrorType:%s,errorType:%s,errCode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.currentState = 1;
    onReset();
    if (this.vSv != null) {
      this.vSv.at(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public final void amT()
  {
    ab.d("MicroMsg.VoiceInputLayout", "doCancel. state = %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState == 1) {
      return;
    }
    this.currentState = 1;
    if (this.vSv != null) {
      this.vSv.bDu();
    }
    if (this.vSw != null) {
      this.vSw.cancel(true);
    }
    onReset();
  }
  
  protected abstract void bDD();
  
  public final void bDF()
  {
    if ((a.bO(getContext())) || (a.bM(getContext())))
    {
      ab.d("MicroMsg.VoiceInputLayout", "voip is running, cann't record voice");
      onReset();
    }
    do
    {
      do
      {
        return;
        boolean bool = b.o(getContext(), "android.permission.RECORD_AUDIO");
        ab.d("MicroMsg.VoiceInputLayout", "summerper checkPermission checkMicrophone[%s]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        ab.d("MicroMsg.VoiceInputLayout", "doStart currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
      } while (this.currentState != 1);
      this.currentState = 2;
      if (this.vSv != null) {
        this.vSv.bDq();
      }
      this.gcG.ag(50L, 50L);
      bDD();
      this.vSw = new g(this.gbb, 0, new VoiceInputLayout.2(this));
      this.vSw.start();
      return;
    } while (!(getContext() instanceof Activity));
    b.b((Activity)getContext(), "android.permission.RECORD_AUDIO", 80);
  }
  
  public final void bDG()
  {
    ab.d("MicroMsg.VoiceInputLayout", "do Stop. currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
    if ((this.currentState == 1) || (this.currentState != 2)) {}
    do
    {
      return;
      this.currentState = 3;
      if (this.vSv != null) {
        this.vSv.bDt();
      }
      if (this.gcG != null) {
        this.gcG.stopTimer();
      }
      this.ipC.removeMessages(0);
      this.ipC.sendEmptyMessageDelayed(0, this.ncn);
      this.ipC.sendEmptyMessageDelayed(1, this.nco);
      ef(true);
    } while (this.vSw == null);
    this.vSw.stop(true);
  }
  
  public final void bDH()
  {
    ab.d("MicroMsg.VoiceInputLayout", "doWaiting currentState = %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState != 2) {
      return;
    }
    this.currentState = 3;
    this.ipC.removeMessages(0);
    this.ipC.sendEmptyMessageDelayed(0, this.ncn);
    this.ipC.sendEmptyMessageDelayed(1, this.nco);
    ef(false);
  }
  
  public final void bDI()
  {
    U(12, -1, -1);
  }
  
  public final void dnu()
  {
    if (this.ipC != null) {
      this.ipC.removeCallbacksAndMessages(null);
    }
    if (this.ncp != null) {
      this.ncp.removeCallbacksAndMessages(null);
    }
    if (this.gcG != null) {
      this.gcG.stopTimer();
    }
  }
  
  protected abstract void ef(boolean paramBoolean);
  
  public int getCurrentState()
  {
    return this.currentState;
  }
  
  protected abstract void onReset();
  
  protected final void reset(boolean paramBoolean)
  {
    ab.d("MicroMsg.VoiceInputLayout", "reset currentState %s", new Object[] { Integer.valueOf(this.currentState) });
    if (this.currentState == 1) {}
    do
    {
      return;
      this.currentState = 1;
      onReset();
    } while ((!paramBoolean) || (this.vSv == null));
    this.vSv.bDv();
  }
  
  public void setFromFullScreen(boolean paramBoolean)
  {
    this.ncm = paramBoolean;
  }
  
  public void setLangType(int paramInt)
  {
    this.gbb = paramInt;
  }
  
  public void setLongClickLisnter(a parama)
  {
    this.vSx = parama;
  }
  
  public void setVoiceDetectListener(b paramb)
  {
    this.vSv = paramb;
  }
  
  protected abstract void wF(int paramInt);
  
  public static abstract interface a
  {
    public abstract void bDz();
  }
  
  public static abstract interface b
  {
    public abstract void at(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void bDq();
    
    public abstract void bDt();
    
    public abstract void bDu();
    
    public abstract void bDv();
    
    public abstract void bDw();
    
    public abstract void c(String[] paramArrayOfString, List<String> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputLayout
 * JD-Core Version:    0.7.0.1
 */