package com.tencent.mm.plugin.mmsight.ui;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.u.a.c;
import com.tencent.mm.plugin.u.a.d;
import com.tencent.mm.plugin.u.a.e;
import com.tencent.mm.plugin.u.a.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;

public class MMSightRecordButton
  extends FrameLayout
{
  private static final int EP = ;
  private static final float mow = ae.getContext().getResources().getDimensionPixelSize(a.c.mmsight_recorder_button_outer_size_max) / ae.getContext().getResources().getDimensionPixelSize(a.c.mmsight_recorder_button_outer_size_init);
  private boolean bIU = true;
  private ah dPi = new ah(Looper.getMainLooper());
  private float hZz = -1.0F;
  private boolean isAnimating = false;
  View moA;
  private MMSightCircularProgressBar moB;
  private boolean moC = false;
  private boolean moD = false;
  private ViewPropertyAnimator moE;
  private ViewPropertyAnimator moF;
  private ViewPropertyAnimator moG;
  private ViewPropertyAnimator moH;
  private boolean moI = false;
  private MMSightRecordButton.d moJ;
  private MMSightRecordButton.b moK;
  private MMSightRecordButton.c moL;
  private MMSightRecordButton.a moM;
  private Drawable moN;
  private Drawable moO;
  private boolean moP = false;
  private boolean moQ = false;
  private Runnable moR = new MMSightRecordButton.5(this);
  private Runnable moS = new MMSightRecordButton.6(this);
  private long mox = -1L;
  private View moy;
  private View moz;
  
  public MMSightRecordButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MMSightRecordButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void a(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    this.isAnimating = true;
    if (this.moG != null)
    {
      this.moG.cancel();
      this.moG = null;
    }
    this.moG = this.moy.animate().scaleX(1.0F).scaleY(1.0F);
    this.moG.setListener(new MMSightRecordButton.3(this, paramAnimatorListenerAdapter)).setDuration(150L).start();
    if (this.moH != null)
    {
      this.moH.cancel();
      this.moH = null;
    }
    this.moH = this.moz.animate().scaleX(1.0F).scaleY(1.0F);
    this.moH.setDuration(150L).start();
  }
  
  private void init()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", new Object[] { Integer.valueOf(500), Integer.valueOf(EP) });
    this.moN = getContext().getResources().getDrawable(a.d.mmsight_recorder_button_inner);
    this.moO = getContext().getResources().getDrawable(a.d.mmsight_recorder_button_outer);
    com.tencent.mm.ui.y.gt(getContext()).inflate(a.f.mmsight_recorder_button, this, true);
    this.moy = findViewById(a.e.inner);
    this.moz = findViewById(a.e.outer);
    this.moA = findViewById(a.e.progress_bar);
    this.moB = ((MMSightCircularProgressBar)findViewById(a.e.circular_progress));
    this.moy.setBackgroundDrawable(this.moN);
    this.moz.setBackgroundDrawable(this.moO);
    this.bIU = true;
  }
  
  public final void a(int paramInt, MMSightCircularProgressBar.a parama)
  {
    com.tencent.mm.sdk.platformtools.y.l("MicroMsg.MMSightRecordButton", "startProgress, initProgress: %s, maxProgress: %s, duration: %s, callback: %s", new Object[] { Integer.valueOf(0), Integer.valueOf(100), Integer.valueOf(paramInt), parama });
    this.moB.setInitProgress(0);
    this.moB.setMaxProgress(100);
    this.moB.setDuration(paramInt);
    this.moB.setVisibility(0);
    parama = new MMSightRecordButton.1(this, parama);
    this.moB.setProgressCallback(parama);
    parama = this.moB;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMSightCircularProgressBar", "start, initProgress: %s, maxProgress: %s, duration: %s", new Object[] { Integer.valueOf(parama.moo), Integer.valueOf(parama.mop), Integer.valueOf(parama.duration) });
    parama.mon = 0.0F;
    parama.mor = new b(parama.moo, parama.mop, parama.duration);
    b localb = parama.mor;
    MMSightCircularProgressBar.1 local1 = new MMSightCircularProgressBar.1(parama);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ProgressHandlerAnimator", "setAnimationCallback: %s", new Object[] { local1 });
    localb.mpG = local1;
    parama = parama.mor;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ProgressHandlerAnimator", "Start");
    parama.bSr = true;
    parama.iZh = bk.UZ();
    parama.etU.S(20L, 20L);
  }
  
  public final void bka()
  {
    MMSightCircularProgressBar localMMSightCircularProgressBar = this.moB;
    localMMSightCircularProgressBar.mos = null;
    localMMSightCircularProgressBar.moo = 0;
    localMMSightCircularProgressBar.mop = 0;
    localMMSightCircularProgressBar.duration = 0;
    localMMSightCircularProgressBar.bSr = false;
    if (localMMSightCircularProgressBar.mor != null)
    {
      b localb = localMMSightCircularProgressBar.mor;
      localb.bSr = false;
      localb.iZh = 0L;
      localMMSightCircularProgressBar.mor = null;
    }
    this.moB.setVisibility(8);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.bIU) {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMSightRecordButton", "onTouchEvent, not enable, ignore");
    }
    float f1;
    float f2;
    do
    {
      do
      {
        return true;
        switch (paramMotionEvent.getAction())
        {
        default: 
          return true;
        case 0: 
          this.moI = true;
          this.mox = System.currentTimeMillis();
          this.moC = false;
          this.moD = false;
          this.hZz = paramMotionEvent.getRawY();
          if (this.moK != null) {
            this.moK.aKQ();
          }
          this.dPi.postDelayed(this.moR, 550L);
          this.dPi.postDelayed(this.moS, 250L);
          this.moQ = true;
          this.moP = true;
          return true;
        case 2: 
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMSightRecordButton", "move, x: %s, y: %s, top: %s", new Object[] { Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()), Integer.valueOf(getTop()) });
          f1 = paramMotionEvent.getRawY();
        }
      } while ((f1 >= getTop()) || (!this.moD));
      if (this.hZz <= 0.0F)
      {
        this.hZz = paramMotionEvent.getRawY();
        return true;
      }
      f2 = Math.abs(f1 - this.hZz);
      if ((f1 < this.hZz) && (f2 >= 10.0F))
      {
        i = (int)(f2 / 10.0F);
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.moP) });
        i = Math.min(i, 3);
        if (this.moL != null)
        {
          paramMotionEvent = this.moL;
          if (this.moP) {
            i = 1;
          }
          paramMotionEvent.qm(i);
        }
        this.hZz = f1;
        this.moP = false;
        return true;
      }
    } while ((f1 <= this.hZz) || (f2 < 10.0F));
    int i = (int)(f2 / 10.0F);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.moQ) });
    i = Math.min(i, 3);
    if (this.moL != null)
    {
      paramMotionEvent = this.moL;
      if (this.moQ) {
        i = 1;
      }
      paramMotionEvent.qn(i);
    }
    this.moQ = false;
    this.hZz = f1;
    return true;
    this.moI = false;
    this.dPi.removeCallbacks(this.moS, Integer.valueOf(EP));
    this.dPi.removeCallbacks(this.moR);
    if ((this.moE != null) && (this.moF != null))
    {
      this.moE.cancel();
      this.moF.cancel();
    }
    long l = System.currentTimeMillis() - this.mox;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", new Object[] { Boolean.valueOf(this.moD), Boolean.valueOf(this.moC), Long.valueOf(this.mox), Long.valueOf(l) });
    bka();
    a(new MMSightRecordButton.7(this, l));
    return true;
  }
  
  public final void reset()
  {
    setClipChildren(false);
    this.bIU = true;
    this.moy.setScaleX(1.0F);
    this.moy.setScaleY(1.0F);
    this.moz.setScaleX(1.0F);
    this.moz.setScaleY(1.0F);
    this.moA.setVisibility(8);
    bka();
  }
  
  public void setErrorPressCallback(MMSightRecordButton.a parama)
  {
    this.moM = parama;
  }
  
  public void setLongPressCallback(MMSightRecordButton.b paramb)
  {
    this.moK = paramb;
  }
  
  public void setLongPressScrollCallback(MMSightRecordButton.c paramc)
  {
    this.moL = paramc;
  }
  
  public void setSimpleTapCallback(MMSightRecordButton.d paramd)
  {
    this.moJ = paramd;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMSightRecordButton", "setTouchEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.bIU = paramBoolean;
  }
  
  public void setVisibility(int paramInt)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMSightRecordButton", "setVisibility, isAnimating: %s", new Object[] { Boolean.valueOf(this.isAnimating) });
    if (this.isAnimating)
    {
      postDelayed(new MMSightRecordButton.4(this, paramInt), 150L);
      return;
    }
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton
 * JD-Core Version:    0.7.0.1
 */