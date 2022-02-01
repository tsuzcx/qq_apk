package com.tencent.mm.plugin.sns.ad.widget.twistad;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sns.ad.widget.gllib.GLViewContainer;
import com.tencent.mm.plugin.sns.ad.widget.gllib.GLViewContainer.3;
import com.tencent.mm.plugin.sns.ad.widget.gllib.b.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public class GLTwistRoateCardsView
  extends GLViewContainer
{
  public boolean POw;
  public int Qic;
  public int Qid;
  private View Qif;
  private int Qjb;
  private int Qjc;
  public int Qjd;
  public int Qje;
  public int Qjf;
  public int Qjg;
  private float Qjh;
  public int Qji;
  public String Qjj;
  public int Qjk;
  public Bitmap Qjl;
  public Handler Qjm;
  private HandlerThread Qjn;
  private int Qjo;
  private a Qjp;
  private final String TAG;
  public Context mContext;
  
  public GLTwistRoateCardsView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(310322);
    this.TAG = "GLTwistRoateCardsView";
    this.Qjb = 0;
    this.Qjc = 0;
    this.Qjh = 1.0F;
    this.POw = false;
    this.Qjo = 0;
    init(paramContext);
    AppMethodBeat.o(310322);
  }
  
  public GLTwistRoateCardsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(310331);
    this.TAG = "GLTwistRoateCardsView";
    this.Qjb = 0;
    this.Qjc = 0;
    this.Qjh = 1.0F;
    this.POw = false;
    this.Qjo = 0;
    init(paramContext);
    AppMethodBeat.o(310331);
  }
  
  private void hdH()
  {
    AppMethodBeat.i(310360);
    Log.i("GLTwistRoateCardsView", "doLayout, child=" + getChildCount() + ", CARD_COUNT=12");
    if (getChildCount() != 12)
    {
      AppMethodBeat.o(310360);
      return;
    }
    int i = 0;
    if (i < 12)
    {
      com.tencent.mm.plugin.sns.ad.widget.gllib.b localb = (com.tencent.mm.plugin.sns.ad.widget.gllib.b)ajW(i);
      double d1;
      int k;
      double d2;
      int j;
      if (this.POw)
      {
        d1 = i * 0.5235987755982988D;
        k = (int)(this.Qjd * Math.cos(d1));
        d2 = this.Qjd;
        j = (int)(Math.sin(d1) * d2);
        localb.di(90 - i * 360 / 12);
      }
      for (;;)
      {
        k += this.Qjb;
        j = this.Qjc - j;
        int m = this.Qic + this.Qjf * 2;
        int n = this.Qid + this.Qjf * 2;
        localb.W(k - m / 2, j - n / 2, k + m / 2, j + n / 2);
        float f1 = this.Qjb;
        float f2 = this.Qjc;
        localb.QfZ = true;
        localb.QfV = f1;
        localb.QfW = f2;
        localb.invalidate();
        i += 1;
        break;
        d1 = -i * 0.5235987755982988D;
        k = (int)(this.Qjd * Math.cos(d1));
        d2 = this.Qjd;
        j = (int)(Math.sin(d1) * d2);
        localb.di(i * 360 / 12 + 90);
      }
    }
    AppMethodBeat.o(310360);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(310342);
    this.mContext = paramContext;
    this.Qjf = a.fromDPToPix(this.mContext, 14);
    this.Qjg = a.fromDPToPix(this.mContext, 8);
    this.Qjn = new HandlerThread("twist_anim_thread");
    this.Qjn.setPriority(10);
    this.Qjn.start();
    this.Qjm = new Handler(this.Qjn.getLooper());
    AppMethodBeat.o(310342);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(310532);
    this.Qjn.quitSafely();
    this.Qjm.removeCallbacksAndMessages(null);
    AppMethodBeat.o(310532);
  }
  
  public final void hdG()
  {
    AppMethodBeat.i(310560);
    Log.i("GLTwistRoateCardsView", "addCardView begin");
    int i = 0;
    while (i < 12)
    {
      com.tencent.mm.plugin.sns.ad.widget.gllib.b localb = new com.tencent.mm.plugin.sns.ad.widget.gllib.b(this.mContext);
      localb.a(new b.a(this.Qic + this.Qjf * 2, this.Qid + this.Qjf * 2));
      localb.setScaleType(0);
      localb.setImageBitmap(this.Qjl);
      localb.setAlpha(0.0F);
      a(localb);
      i += 1;
    }
    queueEvent(new GLViewContainer.3(this));
    invalidate();
    Log.i("GLTwistRoateCardsView", "addCardView end");
    AppMethodBeat.o(310560);
  }
  
  public final void lh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(310575);
    Log.i("GLTwistRoateCardsView", "glOnSizeChanged, w=" + getWidth() + ", h=" + getHeight());
    if ((getWidth() > 0) && (getHeight() > 0))
    {
      this.Qjb = (getWidth() / 2);
      this.Qjc = (getHeight() + a.fromDPToPix(this.mContext, 40));
      hdH();
    }
    AppMethodBeat.o(310575);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(310522);
    super.onDetachedFromWindow();
    clear();
    Log.i("GLTwistRoateCardsView", "onDetachedFromWindow");
    AppMethodBeat.o(310522);
  }
  
  public void setAnimCardView(View paramView)
  {
    this.Qif = paramView;
  }
  
  public void setOnCardAnimListener(a parama)
  {
    this.Qjp = parama;
  }
  
  public static abstract interface a
  {
    public abstract void haT();
    
    public abstract void haV();
    
    public abstract void haW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.twistad.GLTwistRoateCardsView
 * JD-Core Version:    0.7.0.1
 */