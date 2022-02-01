package com.tencent.mm.plugin.music.ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.a.a;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/ui/view/MarqueeLyricView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentLine", "faceOutTask", "Ljava/lang/Runnable;", "fadeIn", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "fadeOut", "hasStartedFadeIn", "", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "mDistance", "mDuration", "mMinDuration", "", "mScroller", "Landroid/widget/Scroller;", "mStartX", "mXPaused", "scrollTask", "calculateScrollingLen", "lyricTxt", "", "computeScroll", "", "doFaceIn", "getLyricLine", "currentTime", "hasNoLyric", "init", "textSize", "", "textColor", "isFocused", "setContent", "lineCnt", "content", "setCurrentTime", "setLyricObj", "startScroll", "stopScroll", "Companion", "plugin-music_release"})
public final class MarqueeLyricView
  extends AppCompatTextView
{
  public static final MarqueeLyricView.a FVl;
  private int Buy;
  private e FTB;
  private int FTC;
  private Runnable FVg;
  private long FVh;
  private Runnable FVi;
  private Animation FVj;
  private boolean FVk;
  private int alM;
  private int asE;
  private int mDistance;
  private Scroller mScroller;
  private Animation wyA;
  
  static
  {
    AppMethodBeat.i(260028);
    FVl = new MarqueeLyricView.a((byte)0);
    AppMethodBeat.o(260028);
  }
  
  public MarqueeLyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MarqueeLyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(260027);
    this.mScroller = new Scroller(getContext(), (Interpolator)new LinearInterpolator());
    this.Buy = (-getWidth());
    this.FVg = ((Runnable)new c(this));
    this.FVh = 200L;
    this.FVi = ((Runnable)new b(this));
    this.wyA = AnimationUtils.loadAnimation(getContext(), a.a.fast_faded_in);
    this.FVj = AnimationUtils.loadAnimation(getContext(), a.a.fast_faded_out);
    this.FTC = -1;
    setScroller(this.mScroller);
    setHorizontallyScrolling(true);
    AppMethodBeat.o(260027);
  }
  
  private final void aSr(String paramString)
  {
    AppMethodBeat.i(260019);
    int i = aSs(paramString);
    int j = i - this.Buy * 3 / 4;
    if (j != 0)
    {
      Log.d("MicroMsg.MarqueeLyricView", "scrollingLen:%s, mXPause:%s, distance:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.Buy), Integer.valueOf(j) });
      this.alM = ((int)(j * 1.0F / aw.fromDPToPix(getContext(), 25) * 1000.0F));
      this.asE = this.Buy;
      this.mDistance = j;
      postDelayed(this.FVg, 1000L);
    }
    AppMethodBeat.o(260019);
  }
  
  private final int aSs(String paramString)
  {
    AppMethodBeat.i(260021);
    TextPaint localTextPaint = getPaint();
    Rect localRect = new Rect();
    localTextPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    if (localRect.width() > 0)
    {
      int i = localRect.width();
      AppMethodBeat.o(260021);
      return i;
    }
    AppMethodBeat.o(260021);
    return 25;
  }
  
  private final void ffG()
  {
    AppMethodBeat.i(260014);
    Animation localAnimation = this.wyA;
    p.j(localAnimation, "fadeIn");
    localAnimation.setDuration(this.FVh);
    startAnimation(this.wyA);
    Log.d("MicroMsg.MarqueeLyricView", "doFaceIn, duration:%s", new Object[] { Long.valueOf(this.FVh) });
    AppMethodBeat.o(260014);
  }
  
  private final void ld()
  {
    AppMethodBeat.i(260023);
    removeCallbacks(this.FVg);
    this.mScroller.startScroll(0, 0, 0, 0, 0);
    AppMethodBeat.o(260023);
  }
  
  public final void bK(int paramInt, String paramString)
  {
    AppMethodBeat.i(260016);
    p.k(paramString, "content");
    e locale = this.FTB;
    int i;
    if (locale != null)
    {
      setText((CharSequence)paramString);
      i = paramInt + 1;
      if (i >= locale.feO()) {
        break label279;
      }
    }
    label265:
    label279:
    for (long l1 = locale.Zm(i).timestamp - locale.Zm(paramInt).timestamp;; l1 = 5000L)
    {
      if (l1 > 1000L) {}
      for (i = 1;; i = 0)
      {
        long l2 = (0.3D * l1);
        this.FVh = i.bf(200L, l2);
        int j = aSs(paramString);
        Log.d("MicroMsg.MarqueeLyricView", "content:%s, width:%s,  contentWidth:%s, duration:%s, duration30Percent:%s, mMinDuration:%s", new Object[] { paramString, Integer.valueOf(getWidth()), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(this.FVh) });
        ld();
        if (this.FVk)
        {
          ffG();
          this.FVk = false;
        }
        if ((getWidth() >= j) || (i == 0)) {
          break;
        }
        Log.d("MicroMsg.MarqueeLyricView", "startScroll");
        aSr(paramString);
        if (locale.feO() - 1 <= paramInt) {
          break label265;
        }
        postDelayed(this.FVi, l1 - this.FVh);
        this.FVk = true;
        AppMethodBeat.o(260016);
        return;
      }
      Log.d("MicroMsg.MarqueeLyricView", "stopScroll");
      AppMethodBeat.o(260016);
      return;
      AppMethodBeat.o(260016);
      return;
    }
  }
  
  public final void computeScroll()
  {
    AppMethodBeat.i(260026);
    super.computeScroll();
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), 0);
      invalidate();
    }
    AppMethodBeat.o(260026);
  }
  
  public final boolean isFocused()
  {
    return true;
  }
  
  public final void setCurrentTime(long paramLong)
  {
    AppMethodBeat.i(260018);
    Log.v("MicroMsg.MarqueeLyricView", "getLyricLine, currentTime:%s", new Object[] { Long.valueOf(paramLong) });
    if (this.FTB != null)
    {
      localObject = this.FTB;
      if (localObject == null) {
        p.iCn();
      }
      if (((e)localObject).feO() > 2) {}
    }
    else
    {
      i = 1;
      if (i == 0) {
        break label134;
      }
      Log.i("MicroMsg.MarqueeLyricView", "getLyricLine, hasNoLyric");
    }
    label134:
    int m;
    label221:
    label373:
    for (int i = -2;; i = this.FTC)
    {
      localObject = this.FTB;
      if (localObject == null) {
        break label831;
      }
      if ((i >= 0) && (i < ((e)localObject).feO()))
      {
        localObject = ((e)localObject).Zm(i).content;
        p.j(localObject, "content");
        bK(i, (String)localObject);
      }
      AppMethodBeat.o(260018);
      return;
      i = 0;
      break;
      if (-1 != this.FTC) {
        break label381;
      }
      this.FTC = 0;
      localObject = this.FTB;
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((e)localObject).Zm(this.FTC).content;
      p.j(localObject, "lyricObj!!.getSentence(currentLine).content");
      localObject = (CharSequence)localObject;
      i = ((CharSequence)localObject).length() - 1;
      k = 0;
      j = 0;
      while (j <= i)
      {
        if (k == 0)
        {
          m = j;
          if (((CharSequence)localObject).charAt(m) > ' ') {
            break label260;
          }
          m = 1;
        }
        for (;;)
        {
          if (k == 0)
          {
            if (m == 0)
            {
              k = 1;
              break;
              m = i;
              break label221;
              m = 0;
              continue;
            }
            j += 1;
            break;
          }
        }
        if (m == 0) {
          break;
        }
        i -= 1;
      }
      if (((CharSequence)((CharSequence)localObject).subSequence(j, i + 1).toString()).length() == 0) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label373;
        }
        this.FTC += 1;
        localObject = this.FTB;
        if (localObject == null) {
          p.iCn();
        }
        localObject = ((e)localObject).Zm(this.FTC).content;
        p.j(localObject, "lyricObj!!.getSentence(currentLine).content");
        break;
      }
    }
    label260:
    label381:
    Object localObject = this.FTB;
    if (localObject == null) {
      p.iCn();
    }
    int k = ((e)localObject).feO();
    int j = 0;
    i = -1;
    label407:
    if (j < k)
    {
      localObject = this.FTB;
      if (localObject == null) {
        p.iCn();
      }
      if (((e)localObject).Zm(j).timestamp < paramLong)
      {
        localObject = this.FTB;
        if (localObject == null) {
          p.iCn();
        }
        if (((e)localObject).Zm(j).FRx) {
          break label838;
        }
        i = j;
      }
    }
    label687:
    label831:
    label838:
    for (;;)
    {
      j += 1;
      break label407;
      if (-1 == i)
      {
        Log.e("MicroMsg.MarqueeLyricView", "getLyricLine, can not found");
        i = -1;
        break;
      }
      if (i == this.FTC)
      {
        Log.v("MicroMsg.MarqueeLyricView", "getLyricLine, same line. [%s]", new Object[] { Integer.valueOf(this.FTC) });
        i = -3;
        break;
      }
      localObject = this.FTB;
      if (localObject == null) {
        p.iCn();
      }
      if (i >= ((e)localObject).feO())
      {
        localObject = this.FTB;
        if (localObject == null) {
          p.iCn();
        }
        Log.e("MicroMsg.MarqueeLyricView", "getLyricLine, over range, tempHighLightIndex:%s, SentenceSize:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(((e)localObject).feO()) });
        i = -5;
        break;
      }
      this.FTC = i;
      localObject = this.FTB;
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((e)localObject).Zm(i).content;
      p.j(localObject, "lyricObj!!.getSentence(tempHighLightIndex).content");
      CharSequence localCharSequence = (CharSequence)localObject;
      j = localCharSequence.length() - 1;
      m = 0;
      k = 0;
      while (k <= j)
      {
        int n;
        if (m == 0)
        {
          n = k;
          if (localCharSequence.charAt(n) > ' ') {
            break label727;
          }
          n = 1;
        }
        for (;;)
        {
          if (m == 0)
          {
            if (n == 0)
            {
              m = 1;
              break;
              n = j;
              break label687;
              label727:
              n = 0;
              continue;
            }
            k += 1;
            break;
          }
        }
        if (n == 0) {
          break;
        }
        j -= 1;
      }
      if (((CharSequence)localCharSequence.subSequence(k, j + 1).toString()).length() == 0) {}
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          break label811;
        }
        Log.v("MicroMsg.MarqueeLyricView", "getLyricLine, content length is 0");
        i = -6;
        break;
      }
      Log.d("MicroMsg.MarqueeLyricView", "lyric:%s", new Object[] { localObject });
      break;
      AppMethodBeat.o(260018);
      return;
    }
  }
  
  public final void setLyricObj(e parame)
  {
    AppMethodBeat.i(260015);
    p.k(parame, "lyricObj");
    setText((CharSequence)"");
    this.FVk = false;
    removeCallbacks(this.FVi);
    ld();
    this.FTB = parame;
    AppMethodBeat.o(260015);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(MarqueeLyricView paramMarqueeLyricView) {}
    
    public final void run()
    {
      AppMethodBeat.i(259874);
      Animation localAnimation = MarqueeLyricView.e(this.FVm);
      p.j(localAnimation, "fadeOut");
      localAnimation.setDuration(MarqueeLyricView.f(this.FVm));
      this.FVm.startAnimation(MarqueeLyricView.e(this.FVm));
      Log.d("MicroMsg.MarqueeLyricView", "doFaceOut, duration:%s", new Object[] { Long.valueOf(MarqueeLyricView.f(this.FVm)) });
      AppMethodBeat.o(259874);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(MarqueeLyricView paramMarqueeLyricView) {}
    
    public final void run()
    {
      AppMethodBeat.i(260201);
      Log.d("MicroMsg.MarqueeLyricView", "scrollTask, mStartX:%s, mDistance:%s, mDuration:%s", new Object[] { Integer.valueOf(MarqueeLyricView.a(this.FVm)), Integer.valueOf(MarqueeLyricView.b(this.FVm)), Integer.valueOf(MarqueeLyricView.c(this.FVm)) });
      MarqueeLyricView.d(this.FVm).startScroll(MarqueeLyricView.a(this.FVm), 0, MarqueeLyricView.b(this.FVm), 0, MarqueeLyricView.c(this.FVm));
      this.FVm.invalidate();
      AppMethodBeat.o(260201);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.MarqueeLyricView
 * JD-Core Version:    0.7.0.1
 */