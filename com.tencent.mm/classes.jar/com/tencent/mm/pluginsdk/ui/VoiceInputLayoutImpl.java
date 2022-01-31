package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

@TargetApi(16)
public class VoiceInputLayoutImpl
  extends VoiceInputLayout
{
  private View.OnLongClickListener asI;
  private View nbZ;
  private boolean ncc;
  private long nce;
  private View.OnTouchListener ncf;
  private k vSz;
  
  public VoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27594);
    this.ncc = false;
    this.asI = new VoiceInputLayoutImpl.1(this);
    this.ncf = new VoiceInputLayoutImpl.2(this);
    init(paramContext);
    AppMethodBeat.o(27594);
  }
  
  public VoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27593);
    this.ncc = false;
    this.asI = new VoiceInputLayoutImpl.1(this);
    this.ncf = new VoiceInputLayoutImpl.2(this);
    init(paramContext);
    AppMethodBeat.o(27593);
  }
  
  private void az(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(27604);
    log_13905 locallog_13905 = new log_13905();
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    if (paramBoolean) {
      if (this.ncm)
      {
        localVoiceInputBehavior.fullScreenVoiceLongClick = paramInt;
        if ((paramInt != 4) && (this.ncc) && (this.nce != 0L)) {
          localVoiceInputBehavior.fullScreenVoiceLongClickTime = bo.av(this.nce);
        }
      }
    }
    for (;;)
    {
      locallog_13905.viOp_ = localVoiceInputBehavior;
      h.qsU.c(13905, locallog_13905);
      ab.i("MicroMsg.VoiceInputLayoutImp", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(localVoiceInputBehavior.cancel), Integer.valueOf(localVoiceInputBehavior.send), Integer.valueOf(localVoiceInputBehavior.click), Integer.valueOf(localVoiceInputBehavior.longClick), Long.valueOf(localVoiceInputBehavior.longClickTime), Integer.valueOf(localVoiceInputBehavior.textClick), Integer.valueOf(localVoiceInputBehavior.textChangeCount), Long.valueOf(localVoiceInputBehavior.textChangeTime), Integer.valueOf(localVoiceInputBehavior.textChangeReturn), Long.valueOf(localVoiceInputBehavior.voiceInputTime), Integer.valueOf(localVoiceInputBehavior.fail), Integer.valueOf(localVoiceInputBehavior.clear), Integer.valueOf(localVoiceInputBehavior.smileIconClick), Integer.valueOf(localVoiceInputBehavior.voiceIconClick), Integer.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClickTime) });
      AppMethodBeat.o(27604);
      return;
      localVoiceInputBehavior.longClick = paramInt;
      if ((paramInt != 4) && (this.ncc) && (this.nce != 0L))
      {
        localVoiceInputBehavior.longClickTime = bo.av(this.nce);
        continue;
        localVoiceInputBehavior.click = paramInt;
      }
    }
  }
  
  private void bDA()
  {
    AppMethodBeat.i(27597);
    runOnUiThread(new VoiceInputLayoutImpl.3(this));
    bDI();
    AppMethodBeat.o(27597);
  }
  
  private static boolean bDC()
  {
    AppMethodBeat.i(27598);
    int i = aw.Rc().adt();
    if ((i == 4) || (i == 6))
    {
      AppMethodBeat.o(27598);
      return true;
    }
    AppMethodBeat.o(27598);
    return false;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(27595);
    this.nbZ = inflate(paramContext, 2130971088, this).findViewById(2131824403);
    this.nbZ.setLayerType(1, null);
    this.vSz = new k(paramContext);
    this.nbZ.setBackground(this.vSz);
    this.nbZ.setEnabled(true);
    this.nbZ.setOnTouchListener(this.ncf);
    this.nbZ.setOnLongClickListener(this.asI);
    reset(true);
    if (isInEditMode())
    {
      AppMethodBeat.o(27595);
      return;
    }
    if (!bDC()) {
      bDA();
    }
    AppMethodBeat.o(27595);
  }
  
  private static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(27603);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      al.d(paramRunnable);
      AppMethodBeat.o(27603);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(27603);
  }
  
  public final void B(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(27596);
    ab.d("MicroMsg.VoiceInputLayoutImp", "directStart currentState = %s longUp = %s clickUp = %s", new Object[] { Integer.valueOf(this.currentState), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (this.currentState == 1)
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        if (!bDC())
        {
          bDA();
          AppMethodBeat.o(27596);
          return;
        }
        bDF();
        AppMethodBeat.o(27596);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        az(4, this.ncc);
        az(this.currentState, this.ncc);
        this.vSz.bDo();
        AppMethodBeat.o(27596);
      }
    }
    else
    {
      if (this.currentState == 2)
      {
        if (!paramBoolean2)
        {
          if (paramBoolean1) {
            az(4, this.ncc);
          }
          az(this.currentState, this.ncc);
          bDG();
          AppMethodBeat.o(27596);
          return;
        }
        this.vSz.bDo();
        amT();
        if (this.vSx != null) {
          this.vSx.bDz();
        }
        az(5, this.ncc);
        AppMethodBeat.o(27596);
        return;
      }
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        az(this.currentState, this.ncc);
        amT();
        AppMethodBeat.o(27596);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        az(4, this.ncc);
        az(this.currentState, this.ncc);
        this.vSz.bDo();
      }
    }
    AppMethodBeat.o(27596);
  }
  
  protected final void bDD()
  {
    AppMethodBeat.i(27599);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(27589);
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).pc(this.nch);
        AppMethodBeat.o(27589);
      }
    });
    AppMethodBeat.o(27599);
  }
  
  protected final void ef(boolean paramBoolean)
  {
    AppMethodBeat.i(27600);
    if (!paramBoolean) {
      az(17, false);
    }
    runOnUiThread(new VoiceInputLayoutImpl.5(this));
    AppMethodBeat.o(27600);
  }
  
  protected final void onReset()
  {
    AppMethodBeat.i(27601);
    runOnUiThread(new VoiceInputLayoutImpl.6(this));
    AppMethodBeat.o(27601);
  }
  
  protected final void wF(int paramInt)
  {
    AppMethodBeat.i(27602);
    runOnUiThread(new VoiceInputLayoutImpl.7(this, paramInt));
    AppMethodBeat.o(27602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl
 * JD-Core Version:    0.7.0.1
 */