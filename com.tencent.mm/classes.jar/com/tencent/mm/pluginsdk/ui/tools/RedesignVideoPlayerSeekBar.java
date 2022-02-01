package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;

public class RedesignVideoPlayerSeekBar
  extends VideoPlayerSeekBar
{
  long FkR = 0L;
  long dcg = 0L;
  long hXx = 0L;
  private ImageView lrJ;
  
  public RedesignVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RedesignVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean Zw(int paramInt)
  {
    AppMethodBeat.i(134012);
    int j = getVideoTotalTime();
    if ((paramInt == this.hXx) && (j == this.dcg))
    {
      AppMethodBeat.o(134012);
      return false;
    }
    if (System.currentTimeMillis() - this.FkR < 300L)
    {
      AppMethodBeat.o(134012);
      return false;
    }
    if ((paramInt < 0) || (j < 0))
    {
      AppMethodBeat.o(134012);
      return false;
    }
    int i = paramInt;
    if (paramInt > j) {
      i = j;
    }
    paramInt = getBarLen();
    if (paramInt <= 0)
    {
      AppMethodBeat.o(134012);
      return true;
    }
    if (j == 0) {}
    for (paramInt = 0;; paramInt = (int)(paramInt * (i * 1.0D / j)))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lrJ.getLayoutParams();
      localLayoutParams.width = paramInt;
      this.lrJ.setLayoutParams(localLayoutParams);
      this.hXx = i;
      this.dcg = j;
      AppMethodBeat.o(134012);
      return true;
    }
  }
  
  public final void gS(boolean paramBoolean)
  {
    AppMethodBeat.i(134010);
    setIsPlay(paramBoolean);
    AppMethodBeat.o(134010);
  }
  
  public int getLayoutId()
  {
    return 2131495232;
  }
  
  public final void init()
  {
    AppMethodBeat.i(134009);
    super.init();
    this.lrJ = ((ImageView)this.contentView.findViewById(2131303303));
    AppMethodBeat.o(134009);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(134011);
    this.dtk = paramBoolean;
    if (paramBoolean)
    {
      this.lru.setImageDrawable(ao.k(getContext(), 2131690445, -1));
      this.lru.setContentDescription(getContext().getString(2131755838));
      AppMethodBeat.o(134011);
      return;
    }
    this.lru.setImageDrawable(ao.k(getContext(), 2131690459, -1));
    this.lru.setContentDescription(getContext().getString(2131755856));
    AppMethodBeat.o(134011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */