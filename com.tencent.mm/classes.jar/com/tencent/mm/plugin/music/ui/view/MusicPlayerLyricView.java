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
import android.support.v7.widget.AppCompatTextView;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.music.a.a;
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
  private boolean AmY;
  private e Amv;
  private int AoA;
  private int AoB;
  private int AoC;
  private int AoD;
  private int AoE;
  private int AoF;
  private String AoG;
  private float AoH;
  private b AoI;
  private int AoJ;
  private boolean AoK;
  private int AoL;
  private int AoM;
  private final int AoN;
  private final int AoO;
  private GestureDetector.SimpleOnGestureListener AoP;
  private Runnable AoQ;
  private List<a> Aor;
  private TextPaint Aos;
  private TextPaint Aot;
  private Paint.FontMetrics Aou;
  private int Aov;
  private float Aow;
  private int Aox;
  private int Aoy;
  private float Aoz;
  private ValueAnimator dgN;
  private int height;
  private boolean isInit;
  private int lineHeight;
  private long mAnimationDuration;
  private GestureDetector mDJ;
  private Scroller mScroller;
  private int textPadding;
  private int textSize;
  private int width;
  private boolean xbw;
  private float yYt;
  
  public MusicPlayerLyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(219907);
    init(null);
    AppMethodBeat.o(219907);
  }
  
  public MusicPlayerLyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(219908);
    this.Aor = new ArrayList();
    this.Aos = new TextPaint();
    this.Aot = new TextPaint();
    this.Aox = 256;
    this.AoA = 256;
    this.AoC = 256;
    this.textPadding = 0;
    this.textSize = ((int)this.Aow);
    this.AoM = 0;
    this.isInit = false;
    this.AoN = 0;
    this.AoO = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 24);
    this.lineHeight = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 52);
    this.AoP = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(219901);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(219901);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(219900);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(219900);
        return bool;
      }
      
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(219894);
        if ((MusicPlayerLyricView.this.evp()) && (MusicPlayerLyricView.c(MusicPlayerLyricView.this) != null))
        {
          MusicPlayerLyricView.d(MusicPlayerLyricView.this).forceFinished(true);
          MusicPlayerLyricView.this.removeCallbacks(MusicPlayerLyricView.e(MusicPlayerLyricView.this));
          MusicPlayerLyricView.f(MusicPlayerLyricView.this);
          MusicPlayerLyricView.a(MusicPlayerLyricView.this, true);
          MusicPlayerLyricView.this.invalidate();
          AppMethodBeat.o(219894);
          return true;
        }
        boolean bool = super.onDown(paramAnonymousMotionEvent);
        AppMethodBeat.o(219894);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(219896);
        if (MusicPlayerLyricView.this.evp())
        {
          MusicPlayerLyricView.d(MusicPlayerLyricView.this).fling(0, (int)MusicPlayerLyricView.g(MusicPlayerLyricView.this), 0, (int)paramAnonymousFloat2, 0, 0, (int)MusicPlayerLyricView.c(MusicPlayerLyricView.this, MusicPlayerLyricView.h(MusicPlayerLyricView.this).size() - 1), (int)MusicPlayerLyricView.c(MusicPlayerLyricView.this, 0));
          MusicPlayerLyricView.i(MusicPlayerLyricView.this);
          AppMethodBeat.o(219896);
          return true;
        }
        boolean bool = super.onFling(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(219896);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(219899);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(219899);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(219895);
        if (MusicPlayerLyricView.this.evp())
        {
          MusicPlayerLyricView.a(MusicPlayerLyricView.this, MusicPlayerLyricView.g(MusicPlayerLyricView.this) + -paramAnonymousFloat2);
          MusicPlayerLyricView.a(MusicPlayerLyricView.this, Math.min(MusicPlayerLyricView.g(MusicPlayerLyricView.this), MusicPlayerLyricView.c(MusicPlayerLyricView.this, 0)));
          MusicPlayerLyricView.a(MusicPlayerLyricView.this, Math.max(MusicPlayerLyricView.g(MusicPlayerLyricView.this), MusicPlayerLyricView.c(MusicPlayerLyricView.this, MusicPlayerLyricView.h(MusicPlayerLyricView.this).size() - 1)));
          MusicPlayerLyricView.this.invalidate();
          AppMethodBeat.o(219895);
          return true;
        }
        boolean bool = super.onScroll(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(219895);
        return bool;
      }
      
      public final boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(219897);
        if ((MusicPlayerLyricView.this.evp()) && (MusicPlayerLyricView.b(MusicPlayerLyricView.this)))
        {
          int i = MusicPlayerLyricView.d(MusicPlayerLyricView.this, (int)paramAnonymousMotionEvent.getY());
          MusicPlayerLyricView.h(MusicPlayerLyricView.this).get(i);
          MusicPlayerLyricView.j(MusicPlayerLyricView.this);
          if ((MusicPlayerLyricView.c(MusicPlayerLyricView.this) != null) && (MusicPlayerLyricView.c(MusicPlayerLyricView.this).evu()))
          {
            MusicPlayerLyricView.a(MusicPlayerLyricView.this, false);
            MusicPlayerLyricView.this.removeCallbacks(MusicPlayerLyricView.e(MusicPlayerLyricView.this));
            MusicPlayerLyricView.a(MusicPlayerLyricView.this, i);
            MusicPlayerLyricView.this.invalidate();
            AppMethodBeat.o(219897);
            return true;
          }
        }
        boolean bool = super.onSingleTapConfirmed(paramAnonymousMotionEvent);
        AppMethodBeat.o(219897);
        return bool;
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(219898);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(219898);
        return bool;
      }
    };
    this.AoQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219902);
        if ((MusicPlayerLyricView.this.evp()) && (MusicPlayerLyricView.b(MusicPlayerLyricView.this)))
        {
          MusicPlayerLyricView.a(MusicPlayerLyricView.this, false);
          MusicPlayerLyricView.b(MusicPlayerLyricView.this, MusicPlayerLyricView.a(MusicPlayerLyricView.this));
        }
        AppMethodBeat.o(219902);
      }
    };
    init(paramAttributeSet);
    AppMethodBeat.o(219908);
  }
  
  private float Tg(int paramInt)
  {
    AppMethodBeat.i(219927);
    if (((a)this.Aor.get(paramInt)).offset == 1.4E-45F)
    {
      f = this.lineHeight;
      int i = 1;
      while (i <= paramInt)
      {
        int j = ((a)this.Aor.get(i - 1)).getHeight();
        f -= (((a)this.Aor.get(i)).getHeight() + j >> 1) + this.AoM;
        i += 1;
      }
      ((a)this.Aor.get(paramInt)).offset = f;
    }
    float f = ((a)this.Aor.get(paramInt)).offset;
    AppMethodBeat.o(219927);
    return f;
  }
  
  private void a(Canvas paramCanvas, StaticLayout paramStaticLayout, float paramFloat)
  {
    AppMethodBeat.i(219916);
    paramCanvas.save();
    paramCanvas.translate(this.AoH, paramFloat - (paramStaticLayout.getHeight() >> 1));
    paramStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(219916);
  }
  
  private void endAnimation()
  {
    AppMethodBeat.i(219925);
    if ((this.dgN != null) && (this.dgN.isRunning())) {
      this.dgN.end();
    }
    AppMethodBeat.o(219925);
  }
  
  private void evq()
  {
    AppMethodBeat.i(219921);
    if ((evp()) || (this.width == 0) || (this.isInit))
    {
      AppMethodBeat.o(219921);
      return;
    }
    if (this.Amv == null)
    {
      Log.e("MicroMsg.Music.MusicPlayerLyricView", "null == lyricObj, maybe you not setLyricObj, check ！！！");
      AppMethodBeat.o(219921);
      return;
    }
    int i = 0;
    while (i < this.Amv.Akn.size())
    {
      Object localObject = this.Amv.SQ(i);
      if (!((e.a)localObject).isEmpty())
      {
        localObject = new a(((e.a)localObject).timestamp, ((e.a)localObject).content);
        ((a)localObject).a(this.Aos, (int)getLrcWidth(), this.AoL);
        this.Aor.add(localObject);
      }
      i += 1;
    }
    this.yYt = this.lineHeight;
    this.isInit = true;
    AppMethodBeat.o(219921);
  }
  
  private void evr()
  {
    AppMethodBeat.i(219922);
    s(getCenterLine(), 100L);
    AppMethodBeat.o(219922);
  }
  
  private static void evs()
  {
    AppMethodBeat.i(219923);
    try
    {
      Field localField = ValueAnimator.class.getDeclaredField("sDurationScale");
      localField.setAccessible(true);
      localField.setFloat(null, 1.0F);
      AppMethodBeat.o(219923);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(219923);
    }
  }
  
  private int getCenterLine()
  {
    AppMethodBeat.i(219926);
    float f = 3.4028235E+38F;
    int i = 0;
    int j = 0;
    if (i < this.Aor.size())
    {
      if (Math.abs(this.yYt - Tg(i)) >= f) {
        break label75;
      }
      f = Math.abs(this.yYt - Tg(i));
      j = i;
    }
    label75:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(219926);
      return j;
    }
  }
  
  private float getLrcWidth()
  {
    return this.width - this.AoH * 2.0F;
  }
  
  @TargetApi(3)
  private void init(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(219909);
    TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, a.a.LrcView);
    this.Aoz = localTypedArray.getDimension(9, getResources().getDimension(2131166599));
    this.Aow = localTypedArray.getDimension(5, getResources().getDimension(2131166599));
    if (this.Aow == 0.0F) {
      this.Aow = this.Aoz;
    }
    this.AoM = this.AoO;
    int i = getResources().getInteger(2131361805);
    this.mAnimationDuration = localTypedArray.getInt(0, i);
    long l;
    if (this.mAnimationDuration < 0L)
    {
      l = i;
      this.mAnimationDuration = l;
      this.Aov = localTypedArray.getColor(4, getResources().getColor(2131100725));
      this.Aoy = localTypedArray.getColor(1, getResources().getColor(2131100724));
      this.AoB = localTypedArray.getColor(14, getResources().getColor(2131100728));
      this.AoG = localTypedArray.getString(3);
      if (!TextUtils.isEmpty(this.AoG)) {
        break label489;
      }
    }
    label489:
    for (paramAttributeSet = getContext().getString(2131762564);; paramAttributeSet = this.AoG)
    {
      this.AoG = paramAttributeSet;
      this.AoH = 0.0F;
      this.AoD = localTypedArray.getColor(12, getResources().getColor(2131100727));
      float f1 = localTypedArray.getDimension(13, getResources().getDimension(2131166602));
      this.AoE = localTypedArray.getColor(10, getResources().getColor(2131100726));
      float f2 = localTypedArray.getDimension(11, getResources().getDimension(2131166600));
      this.AoL = localTypedArray.getInteger(8, 1);
      localTypedArray.recycle();
      this.AoF = ((int)getResources().getDimension(2131166601));
      this.Aos.setAntiAlias(true);
      this.Aos.setTextSize(this.textSize);
      this.Aos.setTextAlign(Paint.Align.LEFT);
      this.Aot.setAntiAlias(true);
      this.Aot.setTextSize(f2);
      this.Aot.setTextAlign(Paint.Align.CENTER);
      this.Aot.setStrokeWidth(f1);
      this.Aot.setStrokeCap(Paint.Cap.ROUND);
      this.Aou = this.Aot.getFontMetrics();
      this.mDJ = new GestureDetector(getContext(), this.AoP);
      this.mDJ.setIsLongpressEnabled(false);
      this.mScroller = new Scroller(getContext());
      evq();
      AppMethodBeat.o(219909);
      return;
      l = this.mAnimationDuration;
      break;
    }
  }
  
  private void s(int paramInt, long paramLong)
  {
    AppMethodBeat.i(219924);
    float f = Tg(paramInt);
    endAnimation();
    this.dgN = ValueAnimator.ofFloat(new float[] { this.yYt, f });
    this.dgN.setDuration(paramLong);
    this.dgN.setInterpolator(new LinearInterpolator());
    this.dgN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(219903);
        MusicPlayerLyricView.a(MusicPlayerLyricView.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        MusicPlayerLyricView.this.invalidate();
        AppMethodBeat.o(219903);
      }
    });
    evs();
    this.dgN.start();
    AppMethodBeat.o(219924);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(219918);
    if (this.mScroller.computeScrollOffset())
    {
      this.yYt = this.mScroller.getCurrY();
      invalidate();
    }
    if ((this.xbw) && (this.mScroller.isFinished()))
    {
      this.xbw = false;
      if ((evp()) && (!this.AmY))
      {
        evr();
        postDelayed(this.AoQ, 1000L);
      }
    }
    AppMethodBeat.o(219918);
  }
  
  public final boolean evp()
  {
    AppMethodBeat.i(219911);
    if (!this.Aor.isEmpty())
    {
      AppMethodBeat.o(219911);
      return true;
    }
    AppMethodBeat.o(219911);
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(219919);
    removeCallbacks(this.AoQ);
    super.onDetachedFromWindow();
    AppMethodBeat.o(219919);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(219915);
    super.onDraw(paramCanvas);
    if ((this.height == 0) || (this.width == 0))
    {
      this.height = getMeasuredHeight();
      this.width = getMeasuredWidth();
    }
    int i = this.lineHeight;
    if (this.Amv == null)
    {
      this.Aos.setColor(this.Aoy);
      a(paramCanvas, new StaticLayout(this.AoG, this.Aos, (int)getLrcWidth(), Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false), i);
      AppMethodBeat.o(219915);
      return;
    }
    evq();
    int j = getCenterLine();
    int k;
    if (this.AoK)
    {
      this.Aot.setColor(this.AoE);
      long l = ((a)this.Aor.get(j)).timestamp;
      k = (int)(l / 60000L);
      int m = (int)(l / 1000L % 60L);
      String str1 = String.format(Locale.getDefault(), "%02d", new Object[] { Integer.valueOf(k) });
      String str2 = String.format(Locale.getDefault(), "%02d", new Object[] { Integer.valueOf(m) });
      paramCanvas.drawText(str1 + ":" + str2, this.width - this.AoF, i - (this.Aou.descent + this.Aou.ascent) / 2.0F, this.Aot);
    }
    paramCanvas.translate(0.0F, this.yYt);
    i = 0;
    if (i < this.Aor.size())
    {
      float f2 = f1;
      if (i > 0)
      {
        k = ((a)this.Aor.get(i - 1)).getHeight();
        f2 = f1 + ((((a)this.Aor.get(i)).getHeight() + k >> 1) + this.AoM);
      }
      if (i == this.AoJ)
      {
        this.Aos.setTextSize(this.Aoz);
        this.Aos.setColor(this.Aoy);
        this.Aos.setFakeBoldText(true);
        this.Aos.setAlpha(this.AoA);
      }
      for (;;)
      {
        a(paramCanvas, ((a)this.Aor.get(i)).huH, f2);
        i += 1;
        f1 = f2;
        break;
        if ((this.AoK) && (i == j))
        {
          this.Aos.setShader(null);
          this.Aos.setColor(this.AoB);
          this.Aos.setAlpha(this.AoC);
        }
        else
        {
          this.Aos.setShader(null);
          this.Aos.setFakeBoldText(false);
          this.Aos.setTextSize(this.Aow);
          this.Aos.setColor(this.Aov);
          this.Aos.setAlpha(this.Aox);
        }
      }
    }
    AppMethodBeat.o(219915);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(219913);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      evq();
      if (evp()) {
        s(this.AoJ, 0L);
      }
    }
    AppMethodBeat.o(219913);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(219914);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.height = paramInt2;
    this.width = paramInt1;
    AppMethodBeat.o(219914);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219917);
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      this.AmY = false;
      if ((evp()) && (!this.xbw))
      {
        evr();
        postDelayed(this.AoQ, 1000L);
      }
    }
    GestureDetector localGestureDetector = this.mDJ;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, paramMotionEvent.axQ(), "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.pG(0)), "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(219917);
    return bool;
  }
  
  public void setCurrentTextSize(float paramFloat)
  {
    this.Aoz = paramFloat;
  }
  
  public void setCurrentTime(final long paramLong)
  {
    AppMethodBeat.i(219912);
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219893);
        if (!MusicPlayerLyricView.this.evp())
        {
          AppMethodBeat.o(219893);
          return;
        }
        int i = MusicPlayerLyricView.a(MusicPlayerLyricView.this, paramLong);
        if (i != MusicPlayerLyricView.a(MusicPlayerLyricView.this))
        {
          MusicPlayerLyricView.a(MusicPlayerLyricView.this, i);
          if (!MusicPlayerLyricView.b(MusicPlayerLyricView.this))
          {
            MusicPlayerLyricView.b(MusicPlayerLyricView.this, i);
            AppMethodBeat.o(219893);
            return;
          }
          MusicPlayerLyricView.this.invalidate();
        }
        AppMethodBeat.o(219893);
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local1.run();
      AppMethodBeat.o(219912);
      return;
    }
    post(local1);
    AppMethodBeat.o(219912);
  }
  
  public void setLyricObj(e parame)
  {
    AppMethodBeat.i(219920);
    this.Amv = parame;
    invalidate();
    AppMethodBeat.o(219920);
  }
  
  public void setNormalTextSize(float paramFloat)
  {
    this.Aow = paramFloat;
  }
  
  public void setTimeTextColor(int paramInt)
  {
    AppMethodBeat.i(219910);
    this.AoE = paramInt;
    postInvalidate();
    AppMethodBeat.o(219910);
  }
  
  final class a
    implements Comparable<a>
  {
    private String AoT;
    StaticLayout huH;
    float offset = 1.4E-45F;
    private String text;
    long timestamp;
    
    a(long paramLong, String paramString)
    {
      this.timestamp = paramLong;
      this.text = paramString;
    }
    
    private String evt()
    {
      AppMethodBeat.i(219906);
      if (!TextUtils.isEmpty(this.AoT))
      {
        str = this.text + "\n" + this.AoT;
        AppMethodBeat.o(219906);
        return str;
      }
      String str = this.text;
      AppMethodBeat.o(219906);
      return str;
    }
    
    final void a(TextPaint paramTextPaint, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(219904);
      Layout.Alignment localAlignment;
      switch (paramInt2)
      {
      default: 
        localAlignment = Layout.Alignment.ALIGN_CENTER;
      }
      for (;;)
      {
        this.huH = new StaticLayout(evt(), paramTextPaint, paramInt1, localAlignment, 0.0F, 0.0F, false);
        this.offset = 1.4E-45F;
        AppMethodBeat.o(219904);
        return;
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
        continue;
        localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
      }
    }
    
    final int getHeight()
    {
      AppMethodBeat.i(219905);
      if (this.huH == null)
      {
        AppMethodBeat.o(219905);
        return 0;
      }
      int i = this.huH.getHeight();
      AppMethodBeat.o(219905);
      return i;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean evu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.MusicPlayerLyricView
 * JD-Core Version:    0.7.0.1
 */