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
  long FDp = 0L;
  long ddi = 0L;
  long iap = 0L;
  private ImageView lwj;
  
  public RedesignVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RedesignVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean aac(int paramInt)
  {
    AppMethodBeat.i(134012);
    int j = getVideoTotalTime();
    if ((paramInt == this.iap) && (j == this.ddi))
    {
      AppMethodBeat.o(134012);
      return false;
    }
    if (System.currentTimeMillis() - this.FDp < 300L)
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
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lwj.getLayoutParams();
      localLayoutParams.width = paramInt;
      this.lwj.setLayoutParams(localLayoutParams);
      this.iap = i;
      this.ddi = j;
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
    this.lwj = ((ImageView)this.contentView.findViewById(2131303303));
    AppMethodBeat.o(134009);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(134011);
    this.duq = paramBoolean;
    if (paramBoolean)
    {
      this.lvU.setImageDrawable(ao.k(getContext(), 2131690445, -1));
      this.lvU.setContentDescription(getContext().getString(2131755838));
      AppMethodBeat.o(134011);
      return;
    }
    this.lvU.setImageDrawable(ao.k(getContext(), 2131690459, -1));
    this.lvU.setContentDescription(getContext().getString(2131755856));
    AppMethodBeat.o(134011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */