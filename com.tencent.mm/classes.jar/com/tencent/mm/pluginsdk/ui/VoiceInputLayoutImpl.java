package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

@TargetApi(16)
public class VoiceInputLayoutImpl
  extends VoiceInputLayout
{
  private View.OnLongClickListener aqp = new VoiceInputLayoutImpl.1(this);
  private View kFk;
  private boolean kFn = false;
  private long kFo;
  private View.OnTouchListener kFq = new VoiceInputLayoutImpl.2(this);
  private l sbs;
  
  public VoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public VoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void ak(int paramInt, boolean paramBoolean)
  {
    log_13905 locallog_13905 = new log_13905();
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    if (paramBoolean) {
      if (this.kFZ)
      {
        localVoiceInputBehavior.fullScreenVoiceLongClick = paramInt;
        if ((paramInt != 4) && (this.kFn) && (this.kFo != 0L)) {
          localVoiceInputBehavior.fullScreenVoiceLongClickTime = bk.cp(this.kFo);
        }
      }
    }
    for (;;)
    {
      locallog_13905.viOp_ = localVoiceInputBehavior;
      h.nFQ.c(13905, locallog_13905);
      y.i("MicroMsg.VoiceInputLayoutImp", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(localVoiceInputBehavior.cancel), Integer.valueOf(localVoiceInputBehavior.send), Integer.valueOf(localVoiceInputBehavior.click), Integer.valueOf(localVoiceInputBehavior.longClick), Long.valueOf(localVoiceInputBehavior.longClickTime), Integer.valueOf(localVoiceInputBehavior.textClick), Integer.valueOf(localVoiceInputBehavior.textChangeCount), Long.valueOf(localVoiceInputBehavior.textChangeTime), Integer.valueOf(localVoiceInputBehavior.textChangeReturn), Long.valueOf(localVoiceInputBehavior.voiceInputTime), Integer.valueOf(localVoiceInputBehavior.fail), Integer.valueOf(localVoiceInputBehavior.clear), Integer.valueOf(localVoiceInputBehavior.smileIconClick), Integer.valueOf(localVoiceInputBehavior.voiceIconClick), Integer.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClickTime) });
      return;
      localVoiceInputBehavior.longClick = paramInt;
      if ((paramInt != 4) && (this.kFn) && (this.kFo != 0L))
      {
        localVoiceInputBehavior.longClickTime = bk.cp(this.kFo);
        continue;
        localVoiceInputBehavior.click = paramInt;
      }
    }
  }
  
  private void cmE()
  {
    runOnUiThread(new VoiceInputLayoutImpl.3(this));
    cmD();
  }
  
  private static boolean cmF()
  {
    int i = au.Dk().KG();
    return (i == 4) || (i == 6);
  }
  
  private void init(Context paramContext)
  {
    this.kFk = inflate(paramContext, R.i.voice_input_layout, this).findViewById(R.h.voice_search_start_btn);
    this.kFk.setLayerType(1, null);
    this.sbs = new l(paramContext);
    this.kFk.setBackground(this.sbs);
    this.kFk.setEnabled(true);
    this.kFk.setOnTouchListener(this.kFq);
    this.kFk.setOnLongClickListener(this.aqp);
    reset(true);
    if (isInEditMode()) {}
    while (cmF()) {
      return;
    }
    cmE();
  }
  
  private static void runOnUiThread(Runnable paramRunnable)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      ai.d(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  protected final void aWS()
  {
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        VoiceInputLayoutImpl.a(VoiceInputLayoutImpl.this).lQ(this.kFt);
      }
    });
  }
  
  protected final void db(boolean paramBoolean)
  {
    if (!paramBoolean) {
      ak(17, false);
    }
    runOnUiThread(new VoiceInputLayoutImpl.5(this));
  }
  
  protected final void onReset()
  {
    runOnUiThread(new VoiceInputLayoutImpl.6(this));
  }
  
  protected final void rH(int paramInt)
  {
    runOnUiThread(new VoiceInputLayoutImpl.7(this, paramInt));
  }
  
  public final void y(boolean paramBoolean1, boolean paramBoolean2)
  {
    y.d("MicroMsg.VoiceInputLayoutImp", "directStart currentState = %s longUp = %s clickUp = %s", new Object[] { Integer.valueOf(this.kFU), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (this.kFU == 1) {
      if ((!paramBoolean1) && (!paramBoolean2)) {
        if (!cmF()) {
          cmE();
        }
      }
    }
    do
    {
      do
      {
        return;
        aWV();
        return;
      } while ((!paramBoolean1) || (paramBoolean2));
      ak(4, this.kFn);
      ak(this.kFU, this.kFn);
      this.sbs.aWU();
      return;
      if (this.kFU == 2)
      {
        if (!paramBoolean2)
        {
          if (paramBoolean1) {
            ak(4, this.kFn);
          }
          ak(this.kFU, this.kFn);
          aWW();
          return;
        }
        this.sbs.aWU();
        TG();
        if (this.sbq != null) {
          this.sbq.aWR();
        }
        ak(5, this.kFn);
        return;
      }
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        ak(this.kFU, this.kFn);
        TG();
        return;
      }
    } while ((!paramBoolean1) || (paramBoolean2));
    ak(4, this.kFn);
    ak(this.kFU, this.kFn);
    this.sbs.aWU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl
 * JD-Core Version:    0.7.0.1
 */