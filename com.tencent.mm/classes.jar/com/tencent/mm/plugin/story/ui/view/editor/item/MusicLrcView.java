package com.tencent.mm.plugin.story.ui.view.editor.item;

import a.l;
import a.l.m;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/editor/item/MusicLrcView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isRunningShow", "", "()Z", "setRunningShow", "(Z)V", "mFirst", "mScroller", "Landroid/widget/Scroller;", "mXPaused", "value", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "player", "getPlayer", "()Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setPlayer", "(Lcom/google/android/exoplayer2/SimpleExoPlayer;)V", "rndDuration", "getRndDuration", "()I", "setRndDuration", "(I)V", "scrollFirstDelay", "getScrollFirstDelay", "setScrollFirstDelay", "calculateScrollingLen", "computeScroll", "", "fillText", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/MusicLrcBean;", "Lkotlin/collections/ArrayList;", "hlString", "", "resumeScroll", "setShow", "isShow", "spanForQuery", "", "source", "startScroll", "stopScroll", "plugin-story_release"})
@SuppressLint({"AppCompatCustomView"})
public final class MusicLrcView
  extends TextView
{
  private Scroller mScroller;
  private boolean sLb;
  private v sLe;
  private int sRg;
  private int sRh;
  private boolean sRi;
  private int sRj;
  
  public MusicLrcView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public MusicLrcView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110686);
    this.sRg = 10000;
    this.sRh = (-getWidth());
    this.sRi = true;
    AppMethodBeat.o(110686);
  }
  
  private final CharSequence a(String paramString, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(110684);
    SpannableString localSpannableString = new SpannableString((CharSequence)paramString);
    int k = paramCharSequence.length();
    int j;
    for (int i = 0;; i = j)
    {
      int m = m.a((CharSequence)paramString, paramCharSequence.toString(), i, false);
      j = i;
      if (m != -1)
      {
        j = i + (m + k);
        if (!isSelected()) {
          break label112;
        }
      }
      label112:
      for (i = -16777216;; i = -1)
      {
        localSpannableString.setSpan(new ForegroundColorSpan(i), m, m + k, 33);
        if (m != -1) {
          break;
        }
        paramString = (CharSequence)localSpannableString;
        AppMethodBeat.o(110684);
        return paramString;
      }
    }
  }
  
  private void cFU()
  {
    AppMethodBeat.i(110681);
    if (!this.sLb)
    {
      AppMethodBeat.o(110681);
      return;
    }
    this.sRh = (-getWidth());
    setHorizontallyScrolling(true);
    if (this.mScroller == null)
    {
      this.mScroller = new Scroller(getContext(), (Interpolator)new LinearInterpolator());
      setScroller(this.mScroller);
    }
    int j = cFV();
    int i = j - this.sRh * 3 / 4;
    if (i != 0)
    {
      j = this.sRg * i / j;
      if (this.sRi)
      {
        postDelayed((Runnable)new MusicLrcView.b(this, i, j), this.sRj);
        AppMethodBeat.o(110681);
        return;
      }
      Scroller localScroller = this.mScroller;
      if (localScroller == null) {
        a.f.b.j.ebi();
      }
      localScroller.startScroll(this.sRh, 0, i, 0, j);
      invalidate();
    }
    AppMethodBeat.o(110681);
  }
  
  private final int cFV()
  {
    AppMethodBeat.i(151288);
    TextPaint localTextPaint = getPaint();
    Rect localRect = new Rect();
    String str = getText().toString();
    localTextPaint.getTextBounds(str, 0, str.length(), localRect);
    if (localRect.width() > 0)
    {
      i = localRect.width();
      AppMethodBeat.o(151288);
      return i;
    }
    int i = getWidth();
    AppMethodBeat.o(151288);
    return i;
  }
  
  public final void bNM()
  {
    AppMethodBeat.i(151287);
    if (this.sLb)
    {
      this.sRh = getWidth();
      this.sRi = true;
      cFU();
    }
    AppMethodBeat.o(151287);
  }
  
  public final void computeScroll()
  {
    AppMethodBeat.i(110685);
    super.computeScroll();
    if (this.mScroller == null)
    {
      AppMethodBeat.o(110685);
      return;
    }
    Scroller localScroller = this.mScroller;
    if (localScroller == null) {
      a.f.b.j.ebi();
    }
    if (localScroller.isFinished())
    {
      this.sRh = (-getWidth());
      this.sRi = false;
      cFU();
    }
    AppMethodBeat.o(110685);
  }
  
  public final void f(ArrayList<e> paramArrayList, String paramString)
  {
    AppMethodBeat.i(110682);
    int i;
    Object localObject1;
    if (paramArrayList != null)
    {
      if (!((Collection)paramArrayList).isEmpty()) {
        i = 1;
      }
      while (i != 0)
      {
        localObject1 = new StringBuilder();
        Object localObject2 = ((Iterable)paramArrayList).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            ((StringBuilder)localObject1).append(((e)((Iterator)localObject2).next()).sRe).append("  ");
            continue;
            i = 0;
            break;
          }
        }
        if (paramString == null) {
          break label230;
        }
        if (((CharSequence)paramString).length() <= 0) {
          break label225;
        }
        i = 1;
        if (i == 0) {
          break label230;
        }
        localObject2 = ((StringBuilder)localObject1).toString();
        a.f.b.j.p(localObject2, "sb.toString()");
        if (!m.a((CharSequence)localObject2, (CharSequence)paramString, false)) {
          break label230;
        }
        localObject1 = ((StringBuilder)localObject1).toString();
        a.f.b.j.p(localObject1, "sb.toString()");
      }
    }
    label225:
    label230:
    for (paramString = a((String)localObject1, (CharSequence)paramString);; paramString = (CharSequence)((StringBuilder)localObject1).toString())
    {
      setText(paramString);
      this.sRg = (((e)a.a.j.fS((List)paramArrayList)).sRf - ((e)a.a.j.fQ((List)paramArrayList)).startTime);
      if (this.sRg == 0) {
        this.sRg = 10000;
      }
      AppMethodBeat.o(110682);
      return;
      i = 0;
      break;
    }
  }
  
  public final v getPlayer()
  {
    return this.sLe;
  }
  
  public final int getRndDuration()
  {
    return this.sRg;
  }
  
  public final int getScrollFirstDelay()
  {
    return this.sRj;
  }
  
  public final void setPlayer(v paramv)
  {
    AppMethodBeat.i(110679);
    if (paramv != null)
    {
      this.sLe = paramv;
      paramv = this.sLe;
      if (paramv != null)
      {
        paramv.a((q.a)new MusicLrcView.a(this));
        AppMethodBeat.o(110679);
        return;
      }
    }
    AppMethodBeat.o(110679);
  }
  
  public final void setRndDuration(int paramInt)
  {
    this.sRg = paramInt;
  }
  
  public final void setRunningShow(boolean paramBoolean)
  {
    this.sLb = paramBoolean;
  }
  
  public final void setScrollFirstDelay(int paramInt)
  {
    this.sRj = paramInt;
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(110680);
    this.sLb = paramBoolean;
    if (!this.sLb)
    {
      if (this.mScroller != null)
      {
        Scroller localScroller = this.mScroller;
        if (localScroller == null) {
          a.f.b.j.ebi();
        }
        localScroller.startScroll(0, 0, 0, 0, 0);
      }
      AppMethodBeat.o(110680);
      return;
    }
    bNM();
    AppMethodBeat.o(110680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.item.MusicLrcView
 * JD-Core Version:    0.7.0.1
 */