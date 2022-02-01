package com.tencent.mm.plugin.music.ui.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetrics;
import android.os.Looper;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.music.a.b;
import com.tencent.mm.plugin.music.a.c;
import com.tencent.mm.plugin.music.a.f;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.plugin.music.a.j;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.xwalk.core.Log;

@SuppressLint({"StaticFieldLeak"})
public class MusicPlayerLyricView
  extends AppCompatTextView
{
  private boolean BNw;
  private e FTB;
  private boolean FUf;
  private TextPaint FVA;
  private TextPaint FVB;
  private Paint.FontMetrics FVC;
  private int FVD;
  private float FVE;
  private int FVF;
  private int FVG;
  private float FVH;
  private int FVI;
  private int FVJ;
  private int FVK;
  private int FVL;
  private int FVM;
  private int FVN;
  private String FVO;
  private float FVP;
  private b FVQ;
  private int FVR;
  private boolean FVS;
  private int FVT;
  private int FVU;
  private final int FVV;
  private final int FVW;
  private GestureDetector.SimpleOnGestureListener FVX;
  private Runnable FVY;
  private List<a> FVz;
  private ValueAnimator eYu;
  private int height;
  private boolean isInit;
  private int lineHeight;
  private long mAnimationDuration;
  private Scroller mScroller;
  private GestureDetector pCU;
  private int textPadding;
  private int textSize;
  private int width;
  private float xrL;
  
  public MusicPlayerLyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(259837);
    f(null);
    AppMethodBeat.o(259837);
  }
  
  public MusicPlayerLyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(259839);
    this.FVz = new ArrayList();
    this.FVA = new TextPaint();
    this.FVB = new TextPaint();
    this.FVF = 256;
    this.FVI = 256;
    this.FVK = 256;
    this.textPadding = 0;
    this.textSize = ((int)this.FVE);
    this.FVU = 0;
    this.isInit = false;
    this.FVV = 0;
    this.FVW = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 24);
    this.lineHeight = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 52);
    this.FVX = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(260539);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(260539);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(260538);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(260538);
        return bool;
      }
      
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(260525);
        if ((MusicPlayerLyricView.this.ffI()) && (MusicPlayerLyricView.c(MusicPlayerLyricView.this) != null))
        {
          MusicPlayerLyricView.d(MusicPlayerLyricView.this).forceFinished(true);
          MusicPlayerLyricView.this.removeCallbacks(MusicPlayerLyricView.e(MusicPlayerLyricView.this));
          MusicPlayerLyricView.f(MusicPlayerLyricView.this);
          MusicPlayerLyricView.a(MusicPlayerLyricView.this, true);
          MusicPlayerLyricView.this.invalidate();
          AppMethodBeat.o(260525);
          return true;
        }
        boolean bool = super.onDown(paramAnonymousMotionEvent);
        AppMethodBeat.o(260525);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(260530);
        if (MusicPlayerLyricView.this.ffI())
        {
          MusicPlayerLyricView.d(MusicPlayerLyricView.this).fling(0, (int)MusicPlayerLyricView.g(MusicPlayerLyricView.this), 0, (int)paramAnonymousFloat2, 0, 0, (int)MusicPlayerLyricView.c(MusicPlayerLyricView.this, MusicPlayerLyricView.h(MusicPlayerLyricView.this).size() - 1), (int)MusicPlayerLyricView.c(MusicPlayerLyricView.this, 0));
          MusicPlayerLyricView.i(MusicPlayerLyricView.this);
          AppMethodBeat.o(260530);
          return true;
        }
        boolean bool = super.onFling(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(260530);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(260536);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(260536);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(260527);
        if (MusicPlayerLyricView.this.ffI())
        {
          MusicPlayerLyricView.a(MusicPlayerLyricView.this, MusicPlayerLyricView.g(MusicPlayerLyricView.this) + -paramAnonymousFloat2);
          MusicPlayerLyricView.a(MusicPlayerLyricView.this, Math.min(MusicPlayerLyricView.g(MusicPlayerLyricView.this), MusicPlayerLyricView.c(MusicPlayerLyricView.this, 0)));
          MusicPlayerLyricView.a(MusicPlayerLyricView.this, Math.max(MusicPlayerLyricView.g(MusicPlayerLyricView.this), MusicPlayerLyricView.c(MusicPlayerLyricView.this, MusicPlayerLyricView.h(MusicPlayerLyricView.this).size() - 1)));
          MusicPlayerLyricView.this.invalidate();
          AppMethodBeat.o(260527);
          return true;
        }
        boolean bool = super.onScroll(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(260527);
        return bool;
      }
      
      public final boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(260532);
        if ((MusicPlayerLyricView.this.ffI()) && (MusicPlayerLyricView.b(MusicPlayerLyricView.this)))
        {
          int i = MusicPlayerLyricView.d(MusicPlayerLyricView.this, (int)paramAnonymousMotionEvent.getY());
          MusicPlayerLyricView.h(MusicPlayerLyricView.this).get(i);
          MusicPlayerLyricView.j(MusicPlayerLyricView.this);
          if ((MusicPlayerLyricView.c(MusicPlayerLyricView.this) != null) && (MusicPlayerLyricView.c(MusicPlayerLyricView.this).ffN()))
          {
            MusicPlayerLyricView.a(MusicPlayerLyricView.this, false);
            MusicPlayerLyricView.this.removeCallbacks(MusicPlayerLyricView.e(MusicPlayerLyricView.this));
            MusicPlayerLyricView.a(MusicPlayerLyricView.this, i);
            MusicPlayerLyricView.this.invalidate();
            AppMethodBeat.o(260532);
            return true;
          }
        }
        boolean bool = super.onSingleTapConfirmed(paramAnonymousMotionEvent);
        AppMethodBeat.o(260532);
        return bool;
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(260534);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(260534);
        return bool;
      }
    };
    this.FVY = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(260400);
        if ((MusicPlayerLyricView.this.ffI()) && (MusicPlayerLyricView.b(MusicPlayerLyricView.this)))
        {
          MusicPlayerLyricView.a(MusicPlayerLyricView.this, false);
          MusicPlayerLyricView.b(MusicPlayerLyricView.this, MusicPlayerLyricView.a(MusicPlayerLyricView.this));
        }
        AppMethodBeat.o(260400);
      }
    };
    f(paramAttributeSet);
    AppMethodBeat.o(259839);
  }
  
  private float ZA(int paramInt)
  {
    AppMethodBeat.i(259864);
    if (((a)this.FVz.get(paramInt)).offset == 1.4E-45F)
    {
      f = this.lineHeight;
      int i = 1;
      while (i <= paramInt)
      {
        int j = ((a)this.FVz.get(i - 1)).getHeight();
        f -= (((a)this.FVz.get(i)).getHeight() + j >> 1) + this.FVU;
        i += 1;
      }
      ((a)this.FVz.get(paramInt)).offset = f;
    }
    float f = ((a)this.FVz.get(paramInt)).offset;
    AppMethodBeat.o(259864);
    return f;
  }
  
  private void a(Canvas paramCanvas, StaticLayout paramStaticLayout, float paramFloat)
  {
    AppMethodBeat.i(259849);
    paramCanvas.save();
    paramCanvas.translate(this.FVP, paramFloat - (paramStaticLayout.getHeight() >> 1));
    paramStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(259849);
  }
  
  private void endAnimation()
  {
    AppMethodBeat.i(259861);
    if ((this.eYu != null) && (this.eYu.isRunning())) {
      this.eYu.end();
    }
    AppMethodBeat.o(259861);
  }
  
  @TargetApi(3)
  private void f(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(259840);
    TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, a.j.LrcView);
    this.FVH = localTypedArray.getDimension(a.j.LrcView_lrcTextSize, getResources().getDimension(a.c.lrc_text_size));
    this.FVE = localTypedArray.getDimension(a.j.LrcView_lrcNormalTextSize, getResources().getDimension(a.c.lrc_text_size));
    if (this.FVE == 0.0F) {
      this.FVE = this.FVH;
    }
    this.FVU = this.FVW;
    int i = getResources().getInteger(a.f.lrc_animation_duration);
    this.mAnimationDuration = localTypedArray.getInt(a.j.LrcView_lrcAnimationDuration, i);
    long l;
    if (this.mAnimationDuration < 0L)
    {
      l = i;
      this.mAnimationDuration = l;
      this.FVD = localTypedArray.getColor(a.j.LrcView_lrcNormalTextColor, getResources().getColor(a.b.lrc_normal_text_color));
      this.FVG = localTypedArray.getColor(a.j.LrcView_lrcCurrentTextColor, getResources().getColor(a.b.lrc_current_text_color));
      this.FVJ = localTypedArray.getColor(a.j.LrcView_lrcTimelineTextColor, getResources().getColor(a.b.lrc_timeline_text_color));
      this.FVO = localTypedArray.getString(a.j.LrcView_lrcLabel);
      if (!TextUtils.isEmpty(this.FVO)) {
        break label506;
      }
    }
    label506:
    for (paramAttributeSet = getContext().getString(a.h.lrc_label);; paramAttributeSet = this.FVO)
    {
      this.FVO = paramAttributeSet;
      this.FVP = 0.0F;
      this.FVL = localTypedArray.getColor(a.j.LrcView_lrcTimelineColor, getResources().getColor(a.b.lrc_timeline_color));
      float f1 = localTypedArray.getDimension(a.j.LrcView_lrcTimelineHeight, getResources().getDimension(a.c.lrc_timeline_height));
      this.FVM = localTypedArray.getColor(a.j.LrcView_lrcTimeTextColor, getResources().getColor(a.b.lrc_time_text_color));
      float f2 = localTypedArray.getDimension(a.j.LrcView_lrcTimeTextSize, getResources().getDimension(a.c.lrc_time_text_size));
      this.FVT = localTypedArray.getInteger(a.j.LrcView_lrcTextGravity, 1);
      localTypedArray.recycle();
      this.FVN = ((int)getResources().getDimension(a.c.lrc_time_width));
      this.FVA.setAntiAlias(true);
      this.FVA.setTextSize(this.textSize);
      this.FVA.setTextAlign(Paint.Align.LEFT);
      this.FVB.setAntiAlias(true);
      this.FVB.setTextSize(f2);
      this.FVB.setTextAlign(Paint.Align.CENTER);
      this.FVB.setStrokeWidth(f1);
      this.FVB.setStrokeCap(Paint.Cap.ROUND);
      this.FVC = this.FVB.getFontMetrics();
      this.pCU = new GestureDetector(getContext(), this.FVX);
      this.pCU.setIsLongpressEnabled(false);
      this.mScroller = new Scroller(getContext());
      ffJ();
      AppMethodBeat.o(259840);
      return;
      l = this.mAnimationDuration;
      break;
    }
  }
  
  private void ffJ()
  {
    AppMethodBeat.i(259855);
    if ((ffI()) || (this.width == 0) || (this.isInit))
    {
      AppMethodBeat.o(259855);
      return;
    }
    if (this.FTB == null)
    {
      Log.e("MicroMsg.Music.MusicPlayerLyricView", "null == lyricObj, maybe you not setLyricObj, check ！！！");
      AppMethodBeat.o(259855);
      return;
    }
    int i = 0;
    while (i < this.FTB.FRr.size())
    {
      Object localObject = this.FTB.Zm(i);
      if (!((e.a)localObject).isEmpty())
      {
        localObject = new a(((e.a)localObject).timestamp, ((e.a)localObject).content);
        ((a)localObject).a(this.FVA, (int)getLrcWidth(), this.FVT);
        this.FVz.add(localObject);
      }
      i += 1;
    }
    this.xrL = this.lineHeight;
    this.isInit = true;
    AppMethodBeat.o(259855);
  }
  
  private void ffK()
  {
    AppMethodBeat.i(259857);
    s(getCenterLine(), 100L);
    AppMethodBeat.o(259857);
  }
  
  private static void ffL()
  {
    AppMethodBeat.i(259858);
    try
    {
      Field localField = ValueAnimator.class.getDeclaredField("sDurationScale");
      localField.setAccessible(true);
      localField.setFloat(null, 1.0F);
      AppMethodBeat.o(259858);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(259858);
    }
  }
  
  private int getCenterLine()
  {
    AppMethodBeat.i(259862);
    float f = 3.4028235E+38F;
    int i = 0;
    int j = 0;
    if (i < this.FVz.size())
    {
      if (Math.abs(this.xrL - ZA(i)) >= f) {
        break label75;
      }
      f = Math.abs(this.xrL - ZA(i));
      j = i;
    }
    label75:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(259862);
      return j;
    }
  }
  
  private float getLrcWidth()
  {
    return this.width - this.FVP * 2.0F;
  }
  
  private void s(int paramInt, long paramLong)
  {
    AppMethodBeat.i(259860);
    float f = ZA(paramInt);
    endAnimation();
    this.eYu = ValueAnimator.ofFloat(new float[] { this.xrL, f });
    this.eYu.setDuration(paramLong);
    this.eYu.setInterpolator(new LinearInterpolator());
    this.eYu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(259951);
        MusicPlayerLyricView.a(MusicPlayerLyricView.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        MusicPlayerLyricView.this.invalidate();
        AppMethodBeat.o(259951);
      }
    });
    ffL();
    this.eYu.start();
    AppMethodBeat.o(259860);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(259851);
    if (this.mScroller.computeScrollOffset())
    {
      this.xrL = this.mScroller.getCurrY();
      invalidate();
    }
    if ((this.BNw) && (this.mScroller.isFinished()))
    {
      this.BNw = false;
      if ((ffI()) && (!this.FUf))
      {
        ffK();
        postDelayed(this.FVY, 1000L);
      }
    }
    AppMethodBeat.o(259851);
  }
  
  public final boolean ffI()
  {
    AppMethodBeat.i(259844);
    if (!this.FVz.isEmpty())
    {
      AppMethodBeat.o(259844);
      return true;
    }
    AppMethodBeat.o(259844);
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(259853);
    removeCallbacks(this.FVY);
    super.onDetachedFromWindow();
    AppMethodBeat.o(259853);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(259848);
    super.onDraw(paramCanvas);
    if ((this.height == 0) || (this.width == 0))
    {
      this.height = getMeasuredHeight();
      this.width = getMeasuredWidth();
    }
    int i = this.lineHeight;
    if (this.FTB == null)
    {
      this.FVA.setColor(this.FVG);
      a(paramCanvas, new StaticLayout(this.FVO, this.FVA, (int)getLrcWidth(), Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false), i);
      AppMethodBeat.o(259848);
      return;
    }
    ffJ();
    int j = getCenterLine();
    int k;
    if (this.FVS)
    {
      this.FVB.setColor(this.FVM);
      long l = ((a)this.FVz.get(j)).timestamp;
      k = (int)(l / 60000L);
      int m = (int)(l / 1000L % 60L);
      String str1 = String.format(Locale.getDefault(), "%02d", new Object[] { Integer.valueOf(k) });
      String str2 = String.format(Locale.getDefault(), "%02d", new Object[] { Integer.valueOf(m) });
      paramCanvas.drawText(str1 + ":" + str2, this.width - this.FVN, i - (this.FVC.descent + this.FVC.ascent) / 2.0F, this.FVB);
    }
    paramCanvas.translate(0.0F, this.xrL);
    i = 0;
    if (i < this.FVz.size())
    {
      float f2 = f1;
      if (i > 0)
      {
        k = ((a)this.FVz.get(i - 1)).getHeight();
        f2 = f1 + ((((a)this.FVz.get(i)).getHeight() + k >> 1) + this.FVU);
      }
      if (i == this.FVR)
      {
        this.FVA.setTextSize(this.FVH);
        this.FVA.setColor(this.FVG);
        this.FVA.setFakeBoldText(true);
        this.FVA.setAlpha(this.FVI);
      }
      for (;;)
      {
        a(paramCanvas, ((a)this.FVz.get(i)).kgD, f2);
        i += 1;
        f1 = f2;
        break;
        if ((this.FVS) && (i == j))
        {
          this.FVA.setShader(null);
          this.FVA.setColor(this.FVJ);
          this.FVA.setAlpha(this.FVK);
        }
        else
        {
          this.FVA.setShader(null);
          this.FVA.setFakeBoldText(false);
          this.FVA.setTextSize(this.FVE);
          this.FVA.setColor(this.FVD);
          this.FVA.setAlpha(this.FVF);
        }
      }
    }
    AppMethodBeat.o(259848);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(259846);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      ffJ();
      if (ffI()) {
        s(this.FVR, 0L);
      }
    }
    AppMethodBeat.o(259846);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(259847);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.height = paramInt2;
    this.width = paramInt1;
    AppMethodBeat.o(259847);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(259850);
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      this.FUf = false;
      if ((ffI()) && (!this.BNw))
      {
        ffK();
        postDelayed(this.FVY, 1000L);
      }
    }
    GestureDetector localGestureDetector = this.pCU;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, paramMotionEvent.aFh(), "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.sf(0)), "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(259850);
    return bool;
  }
  
  public void setCurrentTextSize(float paramFloat)
  {
    this.FVH = paramFloat;
  }
  
  public void setCurrentTime(final long paramLong)
  {
    AppMethodBeat.i(259845);
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(260641);
        if (!MusicPlayerLyricView.this.ffI())
        {
          AppMethodBeat.o(260641);
          return;
        }
        int i = MusicPlayerLyricView.a(MusicPlayerLyricView.this, paramLong);
        if (i != MusicPlayerLyricView.a(MusicPlayerLyricView.this))
        {
          MusicPlayerLyricView.a(MusicPlayerLyricView.this, i);
          if (!MusicPlayerLyricView.b(MusicPlayerLyricView.this))
          {
            MusicPlayerLyricView.b(MusicPlayerLyricView.this, i);
            AppMethodBeat.o(260641);
            return;
          }
          MusicPlayerLyricView.this.invalidate();
        }
        AppMethodBeat.o(260641);
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local1.run();
      AppMethodBeat.o(259845);
      return;
    }
    post(local1);
    AppMethodBeat.o(259845);
  }
  
  public void setLyricObj(e parame)
  {
    AppMethodBeat.i(259854);
    this.FTB = parame;
    invalidate();
    AppMethodBeat.o(259854);
  }
  
  public void setNormalTextSize(float paramFloat)
  {
    this.FVE = paramFloat;
  }
  
  public void setTimeTextColor(int paramInt)
  {
    AppMethodBeat.i(259842);
    this.FVM = paramInt;
    postInvalidate();
    AppMethodBeat.o(259842);
  }
  
  final class a
    implements Comparable<a>
  {
    private String FWb;
    StaticLayout kgD;
    float offset = 1.4E-45F;
    private String text;
    long timestamp;
    
    a(long paramLong, String paramString)
    {
      this.timestamp = paramLong;
      this.text = paramString;
    }
    
    private String ffM()
    {
      AppMethodBeat.i(259805);
      if (!TextUtils.isEmpty(this.FWb))
      {
        str = this.text + "\n" + this.FWb;
        AppMethodBeat.o(259805);
        return str;
      }
      String str = this.text;
      AppMethodBeat.o(259805);
      return str;
    }
    
    final void a(TextPaint paramTextPaint, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(259800);
      Layout.Alignment localAlignment;
      switch (paramInt2)
      {
      default: 
        localAlignment = Layout.Alignment.ALIGN_CENTER;
      }
      for (;;)
      {
        this.kgD = new StaticLayout(ffM(), paramTextPaint, paramInt1, localAlignment, 0.0F, 0.0F, false);
        this.offset = 1.4E-45F;
        AppMethodBeat.o(259800);
        return;
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
        continue;
        localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
      }
    }
    
    final int getHeight()
    {
      AppMethodBeat.i(259803);
      if (this.kgD == null)
      {
        AppMethodBeat.o(259803);
        return 0;
      }
      int i = this.kgD.getHeight();
      AppMethodBeat.o(259803);
      return i;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean ffN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.MusicPlayerLyricView
 * JD-Core Version:    0.7.0.1
 */