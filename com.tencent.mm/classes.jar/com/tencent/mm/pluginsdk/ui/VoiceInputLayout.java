package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Set;

public abstract class VoiceInputLayout
  extends LinearLayout
{
  private int eLu = g.eLT;
  private final am eNb = new am(new VoiceInputLayout.4(this), true);
  ah gNQ = new VoiceInputLayout.1(this);
  public int kFU = 1;
  protected boolean kFZ = false;
  int kGa = 3000;
  int kGb = 10000;
  private ah kGc = new VoiceInputLayout.3(this);
  private b sbo = null;
  private g sbp;
  public a sbq;
  
  public VoiceInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public VoiceInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void I(int paramInt1, int paramInt2, int paramInt3)
  {
    y.d("MicroMsg.VoiceInputLayout", "doNetworkError localerrorType:%s,errorType:%s,errCode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.kFU = 1;
    onReset();
    if (this.sbo != null) {
      this.sbo.ag(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public final void TG()
  {
    y.d("MicroMsg.VoiceInputLayout", "doCancel. state = %s", new Object[] { Integer.valueOf(this.kFU) });
    if (this.kFU == 1) {
      return;
    }
    this.kFU = 1;
    if (this.sbo != null) {
      this.sbo.aWN();
    }
    if (this.sbp != null) {
      this.sbp.cancel(true);
    }
    onReset();
  }
  
  public abstract void aWS();
  
  public final void aWV()
  {
    if ((com.tencent.mm.r.a.bk(getContext())) || (com.tencent.mm.r.a.bi(getContext())))
    {
      y.d("MicroMsg.VoiceInputLayout", "voip is running, cann't record voice");
      onReset();
    }
    do
    {
      do
      {
        return;
        boolean bool = com.tencent.mm.pluginsdk.permission.a.j(getContext(), "android.permission.RECORD_AUDIO");
        y.d("MicroMsg.VoiceInputLayout", "summerper checkPermission checkMicrophone[%s]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break;
        }
        y.d("MicroMsg.VoiceInputLayout", "doStart currentState = %s", new Object[] { Integer.valueOf(this.kFU) });
      } while (this.kFU != 1);
      this.kFU = 2;
      if (this.sbo != null) {
        this.sbo.aWL();
      }
      this.eNb.S(50L, 50L);
      aWS();
      this.sbp = new g(this.eLu, 0, new VoiceInputLayout.2(this));
      this.sbp.start();
      return;
    } while (!(getContext() instanceof Activity));
    com.tencent.mm.pluginsdk.permission.a.b((Activity)getContext(), "android.permission.RECORD_AUDIO", 80);
  }
  
  public final void aWW()
  {
    y.d("MicroMsg.VoiceInputLayout", "do Stop. currentState = %s", new Object[] { Integer.valueOf(this.kFU) });
    if ((this.kFU == 1) || (this.kFU != 2)) {}
    do
    {
      return;
      this.kFU = 3;
      if (this.sbo != null) {
        this.sbo.aWM();
      }
      if (this.eNb != null) {
        this.eNb.stopTimer();
      }
      this.gNQ.removeMessages(0);
      this.gNQ.sendEmptyMessageDelayed(0, this.kGa);
      this.gNQ.sendEmptyMessageDelayed(1, this.kGb);
      db(true);
    } while (this.sbp == null);
    this.sbp.stop(true);
  }
  
  public final void cBV()
  {
    if (this.gNQ != null) {
      this.gNQ.removeCallbacksAndMessages(null);
    }
    if (this.kGc != null) {
      this.kGc.removeCallbacksAndMessages(null);
    }
    if (this.eNb != null) {
      this.eNb.stopTimer();
    }
  }
  
  public final void cmD()
  {
    I(12, -1, -1);
  }
  
  public abstract void db(boolean paramBoolean);
  
  public int getCurrentState()
  {
    return this.kFU;
  }
  
  public abstract void onReset();
  
  public abstract void rH(int paramInt);
  
  public final void reset(boolean paramBoolean)
  {
    y.d("MicroMsg.VoiceInputLayout", "reset currentState %s", new Object[] { Integer.valueOf(this.kFU) });
    if (this.kFU == 1) {}
    do
    {
      return;
      this.kFU = 1;
      onReset();
    } while ((!paramBoolean) || (this.sbo == null));
    this.sbo.aWO();
  }
  
  public void setFromFullScreen(boolean paramBoolean)
  {
    this.kFZ = paramBoolean;
  }
  
  public void setLangType(int paramInt)
  {
    this.eLu = paramInt;
  }
  
  public void setLongClickLisnter(a parama)
  {
    this.sbq = parama;
  }
  
  public void setVoiceDetectListener(b paramb)
  {
    this.sbo = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void aWR();
  }
  
  public static abstract interface b
  {
    public abstract void aWL();
    
    public abstract void aWM();
    
    public abstract void aWN();
    
    public abstract void aWO();
    
    public abstract void aWP();
    
    public abstract void ag(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void b(String[] paramArrayOfString, Set<String> paramSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputLayout
 * JD-Core Version:    0.7.0.1
 */