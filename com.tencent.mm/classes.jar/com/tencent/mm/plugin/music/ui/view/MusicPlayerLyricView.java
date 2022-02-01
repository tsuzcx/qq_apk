package com.tencent.mm.plugin.music.ui.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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

public class MusicPlayerLyricView
  extends AppCompatTextView
{
  private float AOV;
  private boolean EKW;
  private e LOA;
  private boolean LPf;
  private Paint.FontMetrics LQA;
  private int LQB;
  private float LQC;
  private int LQD;
  private int LQE;
  private float LQF;
  private int LQG;
  private int LQH;
  private int LQI;
  private int LQJ;
  private int LQK;
  private int LQL;
  private String LQM;
  private float LQN;
  private b LQO;
  private int LQP;
  private boolean LQQ;
  private int LQR;
  private int LQS;
  private int LQT;
  private final int LQU;
  private final int LQV;
  private GestureDetector.SimpleOnGestureListener LQW;
  private Runnable LQX;
  private List<a> LQx;
  private TextPaint LQy;
  private TextPaint LQz;
  private ValueAnimator hbU;
  private int height;
  private boolean isInit;
  private int lineHeight;
  private long mAnimationDuration;
  private GestureDetector mQj;
  private Scroller mScroller;
  private int textSize;
  private int width;
  
  public MusicPlayerLyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(270986);
    f(null);
    AppMethodBeat.o(270986);
  }
  
  public MusicPlayerLyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(270993);
    this.LQx = new ArrayList();
    this.LQy = new TextPaint();
    this.LQz = new TextPaint();
    this.LQD = 256;
    this.LQG = 256;
    this.LQI = 256;
    this.LQS = 0;
    this.textSize = ((int)this.LQC);
    this.LQT = 0;
    this.isInit = false;
    this.LQU = 0;
    this.LQV = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 24);
    this.lineHeight = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 52);
    this.LQW = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(271092);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(271092);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(271086);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(271086);
        return bool;
      }
      
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(271051);
        if ((MusicPlayerLyricView.this.goW()) && (MusicPlayerLyricView.c(MusicPlayerLyricView.this) != null))
        {
          MusicPlayerLyricView.d(MusicPlayerLyricView.this).forceFinished(true);
          MusicPlayerLyricView.this.removeCallbacks(MusicPlayerLyricView.e(MusicPlayerLyricView.this));
          MusicPlayerLyricView.f(MusicPlayerLyricView.this);
          MusicPlayerLyricView.a(MusicPlayerLyricView.this, true);
          MusicPlayerLyricView.this.invalidate();
          AppMethodBeat.o(271051);
          return true;
        }
        boolean bool = super.onDown(paramAnonymousMotionEvent);
        AppMethodBeat.o(271051);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(271065);
        if (MusicPlayerLyricView.this.goW())
        {
          MusicPlayerLyricView.d(MusicPlayerLyricView.this).fling(0, (int)MusicPlayerLyricView.g(MusicPlayerLyricView.this), 0, (int)paramAnonymousFloat2, 0, 0, (int)MusicPlayerLyricView.c(MusicPlayerLyricView.this, MusicPlayerLyricView.h(MusicPlayerLyricView.this).size() - 1), (int)MusicPlayerLyricView.c(MusicPlayerLyricView.this, 0));
          MusicPlayerLyricView.i(MusicPlayerLyricView.this);
          AppMethodBeat.o(271065);
          return true;
        }
        boolean bool = super.onFling(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(271065);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(271082);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(271082);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(271059);
        if (MusicPlayerLyricView.this.goW())
        {
          MusicPlayerLyricView.a(MusicPlayerLyricView.this, -paramAnonymousFloat2);
          MusicPlayerLyricView.b(MusicPlayerLyricView.this, Math.min(MusicPlayerLyricView.g(MusicPlayerLyricView.this), MusicPlayerLyricView.c(MusicPlayerLyricView.this, 0)));
          MusicPlayerLyricView.b(MusicPlayerLyricView.this, Math.max(MusicPlayerLyricView.g(MusicPlayerLyricView.this), MusicPlayerLyricView.c(MusicPlayerLyricView.this, MusicPlayerLyricView.h(MusicPlayerLyricView.this).size() - 1)));
          MusicPlayerLyricView.this.invalidate();
          AppMethodBeat.o(271059);
          return true;
        }
        boolean bool = super.onScroll(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(271059);
        return bool;
      }
      
      public final boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(271073);
        if ((MusicPlayerLyricView.this.goW()) && (MusicPlayerLyricView.b(MusicPlayerLyricView.this)))
        {
          int i = MusicPlayerLyricView.d(MusicPlayerLyricView.this, (int)paramAnonymousMotionEvent.getY());
          MusicPlayerLyricView.h(MusicPlayerLyricView.this).get(i);
          MusicPlayerLyricView.j(MusicPlayerLyricView.this);
          if ((MusicPlayerLyricView.c(MusicPlayerLyricView.this) != null) && (MusicPlayerLyricView.c(MusicPlayerLyricView.this).gpb()))
          {
            MusicPlayerLyricView.a(MusicPlayerLyricView.this, false);
            MusicPlayerLyricView.this.removeCallbacks(MusicPlayerLyricView.e(MusicPlayerLyricView.this));
            MusicPlayerLyricView.a(MusicPlayerLyricView.this, i);
            MusicPlayerLyricView.this.invalidate();
            AppMethodBeat.o(271073);
            return true;
          }
        }
        boolean bool = super.onSingleTapConfirmed(paramAnonymousMotionEvent);
        AppMethodBeat.o(271073);
        return bool;
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(271079);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(271079);
        return bool;
      }
    };
    this.LQX = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(271046);
        if ((MusicPlayerLyricView.this.goW()) && (MusicPlayerLyricView.b(MusicPlayerLyricView.this)))
        {
          MusicPlayerLyricView.a(MusicPlayerLyricView.this, false);
          MusicPlayerLyricView.b(MusicPlayerLyricView.this, MusicPlayerLyricView.a(MusicPlayerLyricView.this));
        }
        AppMethodBeat.o(271046);
      }
    };
    f(paramAttributeSet);
    AppMethodBeat.o(270993);
  }
  
  private void a(Canvas paramCanvas, StaticLayout paramStaticLayout, float paramFloat)
  {
    AppMethodBeat.i(271011);
    paramCanvas.save();
    paramCanvas.translate(this.LQN, paramFloat - (paramStaticLayout.getHeight() >> 1));
    paramStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(271011);
  }
  
  private float adN(int paramInt)
  {
    AppMethodBeat.i(271064);
    if (((a)this.LQx.get(paramInt)).offset == 1.4E-45F)
    {
      f = this.lineHeight;
      int i = 1;
      while (i <= paramInt)
      {
        int j = ((a)this.LQx.get(i - 1)).getHeight();
        f -= (((a)this.LQx.get(i)).getHeight() + j >> 1) + this.LQT;
        i += 1;
      }
      ((a)this.LQx.get(paramInt)).offset = f;
    }
    float f = ((a)this.LQx.get(paramInt)).offset;
    AppMethodBeat.o(271064);
    return f;
  }
  
  private void endAnimation()
  {
    AppMethodBeat.i(271047);
    if ((this.hbU != null) && (this.hbU.isRunning())) {
      this.hbU.end();
    }
    AppMethodBeat.o(271047);
  }
  
  private void f(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(271006);
    TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, a.j.LrcView);
    this.LQF = localTypedArray.getDimension(a.j.LrcView_lrcTextSize, getResources().getDimension(a.c.lrc_text_size));
    this.LQC = localTypedArray.getDimension(a.j.LrcView_lrcNormalTextSize, getResources().getDimension(a.c.lrc_text_size));
    if (this.LQC == 0.0F) {
      this.LQC = this.LQF;
    }
    this.LQT = this.LQV;
    int i = getResources().getInteger(a.f.lrc_animation_duration);
    this.mAnimationDuration = localTypedArray.getInt(a.j.LrcView_lrcAnimationDuration, i);
    long l;
    if (this.mAnimationDuration < 0L)
    {
      l = i;
      this.mAnimationDuration = l;
      this.LQB = localTypedArray.getColor(a.j.LrcView_lrcNormalTextColor, getResources().getColor(a.b.lrc_normal_text_color));
      this.LQE = localTypedArray.getColor(a.j.LrcView_lrcCurrentTextColor, getResources().getColor(a.b.lrc_current_text_color));
      this.LQH = localTypedArray.getColor(a.j.LrcView_lrcTimelineTextColor, getResources().getColor(a.b.lrc_timeline_text_color));
      this.LQM = localTypedArray.getString(a.j.LrcView_lrcLabel);
      if (!TextUtils.isEmpty(this.LQM)) {
        break label504;
      }
    }
    label504:
    for (paramAttributeSet = getContext().getString(a.h.lrc_label);; paramAttributeSet = this.LQM)
    {
      this.LQM = paramAttributeSet;
      this.LQN = 0.0F;
      this.LQJ = localTypedArray.getColor(a.j.LrcView_lrcTimelineColor, getResources().getColor(a.b.lrc_timeline_color));
      float f1 = localTypedArray.getDimension(a.j.LrcView_lrcTimelineHeight, getResources().getDimension(a.c.lrc_timeline_height));
      this.LQK = localTypedArray.getColor(a.j.LrcView_lrcTimeTextColor, getResources().getColor(a.b.lrc_time_text_color));
      float f2 = localTypedArray.getDimension(a.j.LrcView_lrcTimeTextSize, getResources().getDimension(a.c.lrc_time_text_size));
      this.LQR = localTypedArray.getInteger(a.j.LrcView_lrcTextGravity, 1);
      localTypedArray.recycle();
      this.LQL = ((int)getResources().getDimension(a.c.lrc_time_width));
      this.LQy.setAntiAlias(true);
      this.LQy.setTextSize(this.textSize);
      this.LQy.setTextAlign(Paint.Align.LEFT);
      this.LQz.setAntiAlias(true);
      this.LQz.setTextSize(f2);
      this.LQz.setTextAlign(Paint.Align.CENTER);
      this.LQz.setStrokeWidth(f1);
      this.LQz.setStrokeCap(Paint.Cap.ROUND);
      this.LQA = this.LQz.getFontMetrics();
      this.mQj = new GestureDetector(getContext(), this.LQW);
      this.mQj.setIsLongpressEnabled(false);
      this.mScroller = new Scroller(getContext());
      goX();
      AppMethodBeat.o(271006);
      return;
      l = this.mAnimationDuration;
      break;
    }
  }
  
  private int getCenterLine()
  {
    AppMethodBeat.i(271053);
    float f = 3.4028235E+38F;
    int i = 0;
    int j = 0;
    if (i < this.LQx.size())
    {
      if (Math.abs(this.AOV - adN(i)) >= f) {
        break label75;
      }
      f = Math.abs(this.AOV - adN(i));
      j = i;
    }
    label75:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(271053);
      return j;
    }
  }
  
  private float getLrcWidth()
  {
    return this.width - this.LQN * 2.0F;
  }
  
  private void goX()
  {
    AppMethodBeat.i(271021);
    if ((goW()) || (this.width == 0) || (this.isInit))
    {
      AppMethodBeat.o(271021);
      return;
    }
    if (this.LOA == null)
    {
      Log.e("MicroMsg.Music.MusicPlayerLyricView", "null == lyricObj, maybe you not setLyricObj, check ！！！");
      AppMethodBeat.o(271021);
      return;
    }
    int i = 0;
    while (i < this.LOA.LMm.size())
    {
      Object localObject = this.LOA.adz(i);
      if (!((e.a)localObject).isEmpty())
      {
        localObject = new a(((e.a)localObject).timestamp, ((e.a)localObject).content);
        ((a)localObject).a(this.LQy, (int)getLrcWidth(), this.LQR);
        this.LQx.add(localObject);
      }
      i += 1;
    }
    this.AOV = this.lineHeight;
    this.isInit = true;
    AppMethodBeat.o(271021);
  }
  
  private void goY()
  {
    AppMethodBeat.i(271028);
    w(getCenterLine(), 100L);
    AppMethodBeat.o(271028);
  }
  
  private static void goZ()
  {
    AppMethodBeat.i(271034);
    try
    {
      Field localField = ValueAnimator.class.getDeclaredField("sDurationScale");
      localField.setAccessible(true);
      localField.setFloat(null, 1.0F);
      AppMethodBeat.o(271034);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(271034);
    }
  }
  
  private void w(int paramInt, long paramLong)
  {
    AppMethodBeat.i(271038);
    float f = adN(paramInt);
    endAnimation();
    this.hbU = ValueAnimator.ofFloat(new float[] { this.AOV, f });
    this.hbU.setDuration(paramLong);
    this.hbU.setInterpolator(new LinearInterpolator());
    this.hbU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(271041);
        MusicPlayerLyricView.b(MusicPlayerLyricView.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        MusicPlayerLyricView.this.invalidate();
        AppMethodBeat.o(271041);
      }
    });
    goZ();
    this.hbU.start();
    AppMethodBeat.o(271038);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(271211);
    if (this.mScroller.computeScrollOffset())
    {
      this.AOV = this.mScroller.getCurrY();
      invalidate();
    }
    if ((this.EKW) && (this.mScroller.isFinished()))
    {
      this.EKW = false;
      if ((goW()) && (!this.LPf))
      {
        goY();
        postDelayed(this.LQX, 1000L);
      }
    }
    AppMethodBeat.o(271211);
  }
  
  public final boolean goW()
  {
    AppMethodBeat.i(271159);
    if (!this.LQx.isEmpty())
    {
      AppMethodBeat.o(271159);
      return true;
    }
    AppMethodBeat.o(271159);
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(271213);
    removeCallbacks(this.LQX);
    super.onDetachedFromWindow();
    AppMethodBeat.o(271213);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(271198);
    super.onDraw(paramCanvas);
    if ((this.height == 0) || (this.width == 0))
    {
      this.height = getMeasuredHeight();
      this.width = getMeasuredWidth();
    }
    int i = this.lineHeight;
    if (this.LOA == null)
    {
      this.LQy.setColor(this.LQE);
      a(paramCanvas, new StaticLayout(this.LQM, this.LQy, (int)getLrcWidth(), Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false), i);
      AppMethodBeat.o(271198);
      return;
    }
    goX();
    int j = getCenterLine();
    int k;
    if (this.LQQ)
    {
      this.LQz.setColor(this.LQK);
      long l = ((a)this.LQx.get(j)).timestamp;
      k = (int)(l / 60000L);
      int m = (int)(l / 1000L % 60L);
      String str1 = String.format(Locale.getDefault(), "%02d", new Object[] { Integer.valueOf(k) });
      String str2 = String.format(Locale.getDefault(), "%02d", new Object[] { Integer.valueOf(m) });
      paramCanvas.drawText(str1 + ":" + str2, this.width - this.LQL, i - (this.LQA.descent + this.LQA.ascent) / 2.0F, this.LQz);
    }
    paramCanvas.translate(0.0F, this.AOV);
    i = 0;
    if (i < this.LQx.size())
    {
      float f2 = f1;
      if (i > 0)
      {
        k = ((a)this.LQx.get(i - 1)).getHeight();
        f2 = f1 + ((((a)this.LQx.get(i)).getHeight() + k >> 1) + this.LQT);
      }
      if (i == this.LQP)
      {
        this.LQy.setTextSize(this.LQF);
        this.LQy.setColor(this.LQE);
        this.LQy.setFakeBoldText(true);
        this.LQy.setAlpha(this.LQG);
      }
      for (;;)
      {
        a(paramCanvas, ((a)this.LQx.get(i)).mGW, f2);
        i += 1;
        f1 = f2;
        break;
        if ((this.LQQ) && (i == j))
        {
          this.LQy.setShader(null);
          this.LQy.setColor(this.LQH);
          this.LQy.setAlpha(this.LQI);
        }
        else
        {
          this.LQy.setShader(null);
          this.LQy.setFakeBoldText(false);
          this.LQy.setTextSize(this.LQC);
          this.LQy.setColor(this.LQB);
          this.LQy.setAlpha(this.LQD);
        }
      }
    }
    AppMethodBeat.o(271198);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(271175);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      goX();
      if (goW()) {
        w(this.LQP, 0L);
      }
    }
    AppMethodBeat.o(271175);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(271183);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.height = paramInt2;
    this.width = paramInt1;
    AppMethodBeat.o(271183);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(271203);
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      this.LPf = false;
      if ((goW()) && (!this.EKW))
      {
        goY();
        postDelayed(this.LQX, 1000L);
      }
    }
    GestureDetector localGestureDetector = this.mQj;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, paramMotionEvent.aYi(), "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.sb(0)), "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(271203);
    return bool;
  }
  
  public void setCurrentTextSize(float paramFloat)
  {
    this.LQF = paramFloat;
  }
  
  public void setCurrentTime(final long paramLong)
  {
    AppMethodBeat.i(271167);
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(271052);
        if (!MusicPlayerLyricView.this.goW())
        {
          AppMethodBeat.o(271052);
          return;
        }
        int i = MusicPlayerLyricView.a(MusicPlayerLyricView.this, paramLong);
        if (i != MusicPlayerLyricView.a(MusicPlayerLyricView.this))
        {
          MusicPlayerLyricView.a(MusicPlayerLyricView.this, i);
          if (!MusicPlayerLyricView.b(MusicPlayerLyricView.this))
          {
            MusicPlayerLyricView.b(MusicPlayerLyricView.this, i);
            AppMethodBeat.o(271052);
            return;
          }
          MusicPlayerLyricView.this.invalidate();
        }
        AppMethodBeat.o(271052);
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local1.run();
      AppMethodBeat.o(271167);
      return;
    }
    post(local1);
    AppMethodBeat.o(271167);
  }
  
  public void setLyricObj(e parame)
  {
    AppMethodBeat.i(271219);
    this.LOA = parame;
    invalidate();
    AppMethodBeat.o(271219);
  }
  
  public void setNormalTextSize(float paramFloat)
  {
    this.LQC = paramFloat;
  }
  
  public void setTimeTextColor(int paramInt)
  {
    AppMethodBeat.i(271152);
    this.LQK = paramInt;
    postInvalidate();
    AppMethodBeat.o(271152);
  }
  
  final class a
    implements Comparable<a>
  {
    private String LRa;
    StaticLayout mGW;
    float offset = 1.4E-45F;
    private String text;
    long timestamp;
    
    a(long paramLong, String paramString)
    {
      this.timestamp = paramLong;
      this.text = paramString;
    }
    
    private String gpa()
    {
      AppMethodBeat.i(271060);
      if (!TextUtils.isEmpty(this.LRa))
      {
        str = this.text + "\n" + this.LRa;
        AppMethodBeat.o(271060);
        return str;
      }
      String str = this.text;
      AppMethodBeat.o(271060);
      return str;
    }
    
    final void a(TextPaint paramTextPaint, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(271066);
      Layout.Alignment localAlignment;
      switch (paramInt2)
      {
      default: 
        localAlignment = Layout.Alignment.ALIGN_CENTER;
      }
      for (;;)
      {
        this.mGW = new StaticLayout(gpa(), paramTextPaint, paramInt1, localAlignment, 0.0F, 0.0F, false);
        this.offset = 1.4E-45F;
        AppMethodBeat.o(271066);
        return;
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
        continue;
        localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
      }
    }
    
    final int getHeight()
    {
      AppMethodBeat.i(271071);
      if (this.mGW == null)
      {
        AppMethodBeat.o(271071);
        return 0;
      }
      int i = this.mGW.getHeight();
      AppMethodBeat.o(271071);
      return i;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean gpb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.MusicPlayerLyricView
 * JD-Core Version:    0.7.0.1
 */