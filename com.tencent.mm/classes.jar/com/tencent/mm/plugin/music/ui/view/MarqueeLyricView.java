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
import com.tencent.mm.ui.bd;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/ui/view/MarqueeLyricView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentLine", "faceOutTask", "Ljava/lang/Runnable;", "fadeIn", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "fadeOut", "hasStartedFadeIn", "", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "mDistance", "mDuration", "mMinDuration", "", "mScroller", "Landroid/widget/Scroller;", "mStartX", "mXPaused", "scrollTask", "calculateScrollingLen", "lyricTxt", "", "computeScroll", "", "doFaceIn", "getLyricLine", "currentTime", "hasNoLyric", "init", "textSize", "", "textColor", "isFocused", "setContent", "lineCnt", "content", "setCurrentTime", "setLyricObj", "startScroll", "stopScroll", "Companion", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MarqueeLyricView
  extends AppCompatTextView
{
  public static final MarqueeLyricView.a LQh;
  private int Hbj;
  private e LOA;
  private int LOB;
  private Runnable LQi;
  private long LQj;
  private Runnable LQk;
  private Animation LQl;
  private boolean LQm;
  private int cam;
  private int chn;
  private int mDistance;
  private Scroller mScroller;
  private Animation zUH;
  
  static
  {
    AppMethodBeat.i(271083);
    LQh = new MarqueeLyricView.a((byte)0);
    AppMethodBeat.o(271083);
  }
  
  public MarqueeLyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(271035);
    AppMethodBeat.o(271035);
  }
  
  public MarqueeLyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(271043);
    this.mScroller = new Scroller(getContext(), (Interpolator)new LinearInterpolator());
    this.Hbj = (-getWidth());
    this.LQi = new MarqueeLyricView..ExternalSyntheticLambda0(this);
    this.LQj = 200L;
    this.LQk = new MarqueeLyricView..ExternalSyntheticLambda1(this);
    this.zUH = AnimationUtils.loadAnimation(getContext(), a.a.fast_faded_in);
    this.LQl = AnimationUtils.loadAnimation(getContext(), a.a.fast_faded_out);
    this.LOB = -1;
    setScroller(this.mScroller);
    setHorizontallyScrolling(true);
    AppMethodBeat.o(271043);
  }
  
  private final void JO()
  {
    AppMethodBeat.i(271070);
    removeCallbacks(this.LQi);
    this.mScroller.startScroll(0, 0, 0, 0, 0);
    AppMethodBeat.o(271070);
  }
  
  private static final void a(MarqueeLyricView paramMarqueeLyricView)
  {
    AppMethodBeat.i(271074);
    s.u(paramMarqueeLyricView, "this$0");
    Log.d("MicroMsg.MarqueeLyricView", "scrollTask, mStartX:%s, mDistance:%s, mDuration:%s", new Object[] { Integer.valueOf(paramMarqueeLyricView.chn), Integer.valueOf(paramMarqueeLyricView.mDistance), Integer.valueOf(paramMarqueeLyricView.cam) });
    paramMarqueeLyricView.mScroller.startScroll(paramMarqueeLyricView.chn, 0, paramMarqueeLyricView.mDistance, 0, paramMarqueeLyricView.cam);
    paramMarqueeLyricView.invalidate();
    AppMethodBeat.o(271074);
  }
  
  private final void aPl(String paramString)
  {
    AppMethodBeat.i(271057);
    int i = aPm(paramString);
    int j = i - this.Hbj * 3 / 4;
    if (j != 0)
    {
      Log.d("MicroMsg.MarqueeLyricView", "scrollingLen:%s, mXPause:%s, distance:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.Hbj), Integer.valueOf(j) });
      this.cam = ((int)(j * 1.0F / bd.fromDPToPix(getContext(), 25) * 1000.0F));
      this.chn = this.Hbj;
      this.mDistance = j;
      postDelayed(this.LQi, 1000L);
    }
    AppMethodBeat.o(271057);
  }
  
  private final int aPm(String paramString)
  {
    AppMethodBeat.i(271063);
    TextPaint localTextPaint = getPaint();
    Rect localRect = new Rect();
    localTextPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    if (localRect.width() > 0)
    {
      int i = localRect.width();
      AppMethodBeat.o(271063);
      return i;
    }
    AppMethodBeat.o(271063);
    return 25;
  }
  
  private static final void b(MarqueeLyricView paramMarqueeLyricView)
  {
    AppMethodBeat.i(271081);
    s.u(paramMarqueeLyricView, "this$0");
    paramMarqueeLyricView.LQl.setDuration(paramMarqueeLyricView.LQj);
    paramMarqueeLyricView.startAnimation(paramMarqueeLyricView.LQl);
    Log.d("MicroMsg.MarqueeLyricView", "doFaceOut, duration:%s", new Object[] { Long.valueOf(paramMarqueeLyricView.LQj) });
    AppMethodBeat.o(271081);
  }
  
  private final void goU()
  {
    AppMethodBeat.i(271049);
    this.zUH.setDuration(this.LQj);
    startAnimation(this.zUH);
    Log.d("MicroMsg.MarqueeLyricView", "doFaceIn, duration:%s", new Object[] { Long.valueOf(this.LQj) });
    AppMethodBeat.o(271049);
  }
  
  public final void computeScroll()
  {
    AppMethodBeat.i(271108);
    super.computeScroll();
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), 0);
      invalidate();
    }
    AppMethodBeat.o(271108);
  }
  
  public final void cs(int paramInt, String paramString)
  {
    AppMethodBeat.i(271101);
    s.u(paramString, "content");
    e locale = this.LOA;
    int i;
    if (locale != null)
    {
      setText((CharSequence)paramString);
      i = paramInt + 1;
      if (i >= locale.LMm.size()) {
        break label278;
      }
    }
    label271:
    label278:
    for (long l1 = locale.adz(i).timestamp - locale.adz(paramInt).timestamp;; l1 = 5000L)
    {
      if (l1 > 1000L) {}
      for (i = 1;; i = 0)
      {
        long l2 = (0.3D * l1);
        this.LQj = k.bS(200L, l2);
        int j = aPm(paramString);
        Log.d("MicroMsg.MarqueeLyricView", "content:%s, width:%s,  contentWidth:%s, duration:%s, duration30Percent:%s, mMinDuration:%s", new Object[] { paramString, Integer.valueOf(getWidth()), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(this.LQj) });
        JO();
        if (this.LQm)
        {
          goU();
          this.LQm = false;
        }
        if ((getWidth() >= j) || (i == 0)) {
          break;
        }
        Log.d("MicroMsg.MarqueeLyricView", "startScroll");
        aPl(paramString);
        if (locale.LMm.size() - 1 <= paramInt) {
          break label271;
        }
        postDelayed(this.LQk, l1 - this.LQj);
        this.LQm = true;
        AppMethodBeat.o(271101);
        return;
      }
      Log.d("MicroMsg.MarqueeLyricView", "stopScroll");
      AppMethodBeat.o(271101);
      return;
    }
  }
  
  public final boolean isFocused()
  {
    return true;
  }
  
  public final void setCurrentTime(long paramLong)
  {
    int k = -1;
    AppMethodBeat.i(271105);
    Log.v("MicroMsg.MarqueeLyricView", "getLyricLine, currentTime:%s", new Object[] { Long.valueOf(paramLong) });
    if (this.LOA != null)
    {
      localObject = this.LOA;
      s.checkNotNull(localObject);
      if (((e)localObject).LMm.size() > 2) {}
    }
    else
    {
      i = 1;
      if (i == 0) {
        break label140;
      }
      Log.i("MicroMsg.MarqueeLyricView", "getLyricLine, hasNoLyric");
    }
    label140:
    int j;
    int m;
    label224:
    label376:
    for (int i = -2;; i = this.LOB)
    {
      localObject = this.LOA;
      if ((localObject != null) && (i >= 0) && (i < ((e)localObject).LMm.size()))
      {
        localObject = ((e)localObject).adz(i).content;
        s.s(localObject, "content");
        cs(i, (String)localObject);
      }
      AppMethodBeat.o(271105);
      return;
      i = 0;
      break;
      if (-1 != this.LOB) {
        break label384;
      }
      this.LOB = 0;
      localObject = this.LOA;
      s.checkNotNull(localObject);
      localObject = ((e)localObject).adz(this.LOB).content;
      s.s(localObject, "lyricObj!!.getSentence(currentLine).content");
      localObject = (CharSequence)localObject;
      i = ((CharSequence)localObject).length() - 1;
      k = 0;
      j = 0;
      while (j <= i)
      {
        if (k == 0)
        {
          m = j;
          if (s.compare(((CharSequence)localObject).charAt(m), 32) > 0) {
            break label266;
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
              break label224;
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
          break label376;
        }
        this.LOB += 1;
        localObject = this.LOA;
        s.checkNotNull(localObject);
        localObject = ((e)localObject).adz(this.LOB).content;
        s.s(localObject, "lyricObj!!.getSentence(currentLine).content");
        break;
      }
    }
    label266:
    Object localObject = this.LOA;
    label384:
    s.checkNotNull(localObject);
    int n = ((e)localObject).LMm.size();
    if (n > 0)
    {
      i = 0;
      j = -1;
      label415:
      m = i + 1;
      localObject = this.LOA;
      s.checkNotNull(localObject);
      if (((e)localObject).adz(i).timestamp < paramLong)
      {
        localObject = this.LOA;
        s.checkNotNull(localObject);
        if (!((e)localObject).adz(i).LMr) {
          j = i;
        }
        if (m < n) {
          break label837;
        }
        i = j;
      }
    }
    for (;;)
    {
      if (-1 == i)
      {
        Log.e("MicroMsg.MarqueeLyricView", "getLyricLine, can not found");
        i = k;
        break;
        i = j;
        continue;
      }
      if (i == this.LOB)
      {
        Log.v("MicroMsg.MarqueeLyricView", "getLyricLine, same line. [%s]", new Object[] { Integer.valueOf(this.LOB) });
        i = -3;
        break;
      }
      localObject = this.LOA;
      s.checkNotNull(localObject);
      if (i >= ((e)localObject).LMm.size())
      {
        localObject = this.LOA;
        s.checkNotNull(localObject);
        Log.e("MicroMsg.MarqueeLyricView", "getLyricLine, over range, tempHighLightIndex:%s, SentenceSize:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(((e)localObject).LMm.size()) });
        i = -5;
        break;
      }
      this.LOB = i;
      localObject = this.LOA;
      s.checkNotNull(localObject);
      localObject = ((e)localObject).adz(i).content;
      s.s(localObject, "lyricObj!!.getSentence(tempHighLightIndex).content");
      CharSequence localCharSequence = (CharSequence)localObject;
      j = localCharSequence.length() - 1;
      m = 0;
      k = 0;
      while (k <= j)
      {
        if (m == 0)
        {
          n = k;
          label690:
          if (s.compare(localCharSequence.charAt(n), 32) > 0) {
            break label733;
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
              break label690;
              label733:
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
          break label817;
        }
        Log.v("MicroMsg.MarqueeLyricView", "getLyricLine, content length is 0");
        i = -6;
        break;
      }
      label817:
      Log.d("MicroMsg.MarqueeLyricView", "lyric:%s", new Object[] { localObject });
      break;
      label837:
      i = m;
      break label415;
      i = -1;
    }
  }
  
  public final void setLyricObj(e parame)
  {
    AppMethodBeat.i(271098);
    s.u(parame, "lyricObj");
    setText((CharSequence)"");
    this.LQm = false;
    removeCallbacks(this.LQk);
    JO();
    this.LOA = parame;
    AppMethodBeat.o(271098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.MarqueeLyricView
 * JD-Core Version:    0.7.0.1
 */