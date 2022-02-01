package com.tencent.mm.plugin.music.ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/ui/view/MarqueeLyricView;", "Landroid/support/v7/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentLine", "faceOutTask", "Ljava/lang/Runnable;", "fadeIn", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "fadeOut", "hasStartedFadeIn", "", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "mDistance", "mDuration", "mMinDuration", "", "mScroller", "Landroid/widget/Scroller;", "mStartX", "mXPaused", "scrollTask", "calculateScrollingLen", "lyricTxt", "", "computeScroll", "", "doFaceIn", "getLyricLine", "currentTime", "hasNoLyric", "init", "textSize", "", "textColor", "isFocused", "setContent", "lineCnt", "content", "setCurrentTime", "setLyricObj", "startScroll", "stopScroll", "Companion", "plugin-music_release"})
public final class MarqueeLyricView
  extends AppCompatTextView
{
  public static final MarqueeLyricView.a Aof;
  private e Amv;
  private int Amw;
  private Runnable Aoa;
  private long Aob;
  private Runnable Aoc;
  private Animation Aod;
  private boolean Aoe;
  private int Dm;
  private int atU;
  private int mDistance;
  private Scroller mScroller;
  private Animation sSE;
  private int wDQ;
  
  static
  {
    AppMethodBeat.i(220023);
    Aof = new MarqueeLyricView.a((byte)0);
    AppMethodBeat.o(220023);
  }
  
  public MarqueeLyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MarqueeLyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(220022);
    this.mScroller = new Scroller(getContext(), (Interpolator)new LinearInterpolator());
    this.wDQ = (-getWidth());
    this.Aoa = ((Runnable)new c(this));
    this.Aob = 200L;
    this.Aoc = ((Runnable)new b(this));
    this.sSE = AnimationUtils.loadAnimation(getContext(), 2130772059);
    this.Aod = AnimationUtils.loadAnimation(getContext(), 2130772060);
    this.Amw = -1;
    setScroller(this.mScroller);
    setHorizontallyScrolling(true);
    AppMethodBeat.o(220022);
  }
  
  private final void aIb(String paramString)
  {
    AppMethodBeat.i(220018);
    int i = aIc(paramString);
    int j = i - this.wDQ * 3 / 4;
    if (j != 0)
    {
      Log.d("MicroMsg.MarqueeLyricView", "scrollingLen:%s, mXPause:%s, distance:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.wDQ), Integer.valueOf(j) });
      this.atU = ((int)(j * 1.0F / at.fromDPToPix(getContext(), 25) * 1000.0F));
      this.Dm = this.wDQ;
      this.mDistance = j;
      postDelayed(this.Aoa, 1000L);
    }
    AppMethodBeat.o(220018);
  }
  
  private final int aIc(String paramString)
  {
    AppMethodBeat.i(220019);
    TextPaint localTextPaint = getPaint();
    Rect localRect = new Rect();
    localTextPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    if (localRect.width() > 0)
    {
      int i = localRect.width();
      AppMethodBeat.o(220019);
      return i;
    }
    AppMethodBeat.o(220019);
    return 25;
  }
  
  private final void evn()
  {
    AppMethodBeat.i(220014);
    Animation localAnimation = this.sSE;
    p.g(localAnimation, "fadeIn");
    localAnimation.setDuration(this.Aob);
    startAnimation(this.sSE);
    Log.d("MicroMsg.MarqueeLyricView", "doFaceIn, duration:%s", new Object[] { Long.valueOf(this.Aob) });
    AppMethodBeat.o(220014);
  }
  
  private final void kQ()
  {
    AppMethodBeat.i(220020);
    removeCallbacks(this.Aoa);
    this.mScroller.startScroll(0, 0, 0, 0, 0);
    AppMethodBeat.o(220020);
  }
  
  public final void bM(int paramInt, String paramString)
  {
    AppMethodBeat.i(220016);
    p.h(paramString, "content");
    e locale = this.Amv;
    int i;
    if (locale != null)
    {
      setText((CharSequence)paramString);
      i = paramInt + 1;
      if (i >= locale.euw()) {
        break label279;
      }
    }
    label265:
    label279:
    for (long l1 = locale.SQ(i).timestamp - locale.SQ(paramInt).timestamp;; l1 = 5000L)
    {
      if (l1 > 1000L) {}
      for (i = 1;; i = 0)
      {
        long l2 = (0.3D * l1);
        this.Aob = j.aN(200L, l2);
        int j = aIc(paramString);
        Log.d("MicroMsg.MarqueeLyricView", "content:%s, width:%s,  contentWidth:%s, duration:%s, duration30Percent:%s, mMinDuration:%s", new Object[] { paramString, Integer.valueOf(getWidth()), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(this.Aob) });
        kQ();
        if (this.Aoe)
        {
          evn();
          this.Aoe = false;
        }
        if ((getWidth() >= j) || (i == 0)) {
          break;
        }
        Log.d("MicroMsg.MarqueeLyricView", "startScroll");
        aIb(paramString);
        if (locale.euw() - 1 <= paramInt) {
          break label265;
        }
        postDelayed(this.Aoc, l1 - this.Aob);
        this.Aoe = true;
        AppMethodBeat.o(220016);
        return;
      }
      Log.d("MicroMsg.MarqueeLyricView", "stopScroll");
      AppMethodBeat.o(220016);
      return;
      AppMethodBeat.o(220016);
      return;
    }
  }
  
  public final void computeScroll()
  {
    AppMethodBeat.i(220021);
    super.computeScroll();
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), 0);
      invalidate();
    }
    AppMethodBeat.o(220021);
  }
  
  public final boolean isFocused()
  {
    return true;
  }
  
  public final void setCurrentTime(long paramLong)
  {
    AppMethodBeat.i(220017);
    Log.v("MicroMsg.MarqueeLyricView", "getLyricLine, currentTime:%s", new Object[] { Long.valueOf(paramLong) });
    if (this.Amv != null)
    {
      localObject = this.Amv;
      if (localObject == null) {
        p.hyc();
      }
      if (((e)localObject).euw() > 2) {}
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
    for (int i = -2;; i = this.Amw)
    {
      localObject = this.Amv;
      if (localObject == null) {
        break label831;
      }
      if ((i >= 0) && (i < ((e)localObject).euw()))
      {
        localObject = ((e)localObject).SQ(i).content;
        p.g(localObject, "content");
        bM(i, (String)localObject);
      }
      AppMethodBeat.o(220017);
      return;
      i = 0;
      break;
      if (-1 != this.Amw) {
        break label381;
      }
      this.Amw = 0;
      localObject = this.Amv;
      if (localObject == null) {
        p.hyc();
      }
      localObject = ((e)localObject).SQ(this.Amw).content;
      p.g(localObject, "lyricObj!!.getSentence(currentLine).content");
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
        this.Amw += 1;
        localObject = this.Amv;
        if (localObject == null) {
          p.hyc();
        }
        localObject = ((e)localObject).SQ(this.Amw).content;
        p.g(localObject, "lyricObj!!.getSentence(currentLine).content");
        break;
      }
    }
    label260:
    label381:
    Object localObject = this.Amv;
    if (localObject == null) {
      p.hyc();
    }
    int k = ((e)localObject).euw();
    int j = 0;
    i = -1;
    label407:
    if (j < k)
    {
      localObject = this.Amv;
      if (localObject == null) {
        p.hyc();
      }
      if (((e)localObject).SQ(j).timestamp < paramLong)
      {
        localObject = this.Amv;
        if (localObject == null) {
          p.hyc();
        }
        if (((e)localObject).SQ(j).Akt) {
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
      if (i == this.Amw)
      {
        Log.v("MicroMsg.MarqueeLyricView", "getLyricLine, same line. [%s]", new Object[] { Integer.valueOf(this.Amw) });
        i = -3;
        break;
      }
      localObject = this.Amv;
      if (localObject == null) {
        p.hyc();
      }
      if (i >= ((e)localObject).euw())
      {
        localObject = this.Amv;
        if (localObject == null) {
          p.hyc();
        }
        Log.e("MicroMsg.MarqueeLyricView", "getLyricLine, over range, tempHighLightIndex:%s, SentenceSize:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(((e)localObject).euw()) });
        i = -5;
        break;
      }
      this.Amw = i;
      localObject = this.Amv;
      if (localObject == null) {
        p.hyc();
      }
      localObject = ((e)localObject).SQ(i).content;
      p.g(localObject, "lyricObj!!.getSentence(tempHighLightIndex).content");
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
      AppMethodBeat.o(220017);
      return;
    }
  }
  
  public final void setLyricObj(e parame)
  {
    AppMethodBeat.i(220015);
    p.h(parame, "lyricObj");
    setText((CharSequence)"");
    this.Aoe = false;
    removeCallbacks(this.Aoc);
    kQ();
    this.Amv = parame;
    AppMethodBeat.o(220015);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(MarqueeLyricView paramMarqueeLyricView) {}
    
    public final void run()
    {
      AppMethodBeat.i(220012);
      Animation localAnimation = MarqueeLyricView.e(this.Aog);
      p.g(localAnimation, "fadeOut");
      localAnimation.setDuration(MarqueeLyricView.f(this.Aog));
      this.Aog.startAnimation(MarqueeLyricView.e(this.Aog));
      Log.d("MicroMsg.MarqueeLyricView", "doFaceOut, duration:%s", new Object[] { Long.valueOf(MarqueeLyricView.f(this.Aog)) });
      AppMethodBeat.o(220012);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(MarqueeLyricView paramMarqueeLyricView) {}
    
    public final void run()
    {
      AppMethodBeat.i(220013);
      Log.d("MicroMsg.MarqueeLyricView", "scrollTask, mStartX:%s, mDistance:%s, mDuration:%s", new Object[] { Integer.valueOf(MarqueeLyricView.a(this.Aog)), Integer.valueOf(MarqueeLyricView.b(this.Aog)), Integer.valueOf(MarqueeLyricView.c(this.Aog)) });
      MarqueeLyricView.d(this.Aog).startScroll(MarqueeLyricView.a(this.Aog), 0, MarqueeLyricView.b(this.Aog), 0, MarqueeLyricView.c(this.Aog));
      this.Aog.invalidate();
      AppMethodBeat.o(220013);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.MarqueeLyricView
 * JD-Core Version:    0.7.0.1
 */