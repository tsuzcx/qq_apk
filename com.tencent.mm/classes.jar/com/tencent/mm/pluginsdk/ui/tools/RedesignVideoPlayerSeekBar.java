package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.am;

public class RedesignVideoPlayerSeekBar
  extends VideoPlayerSeekBar
{
  long Cnt = 0L;
  long cTt = 0L;
  long hep = 0L;
  private ImageView ktw;
  
  public RedesignVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RedesignVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean Vr(int paramInt)
  {
    AppMethodBeat.i(134012);
    int j = getVideoTotalTime();
    if ((paramInt == this.hep) && (j == this.cTt))
    {
      AppMethodBeat.o(134012);
      return false;
    }
    if (System.currentTimeMillis() - this.Cnt < 300L)
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
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ktw.getLayoutParams();
      localLayoutParams.width = paramInt;
      this.ktw.setLayoutParams(localLayoutParams);
      this.hep = i;
      this.cTt = j;
      AppMethodBeat.o(134012);
      return true;
    }
  }
  
  public int getLayoutId()
  {
    return 2131495232;
  }
  
  public final void gp(boolean paramBoolean)
  {
    AppMethodBeat.i(134010);
    setIsPlay(paramBoolean);
    AppMethodBeat.o(134010);
  }
  
  public final void init()
  {
    AppMethodBeat.i(134009);
    super.init();
    this.ktw = ((ImageView)this.contentView.findViewById(2131303303));
    AppMethodBeat.o(134009);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(134011);
    this.dkr = paramBoolean;
    if (paramBoolean)
    {
      this.kth.setImageDrawable(am.i(getContext(), 2131690445, -1));
      AppMethodBeat.o(134011);
      return;
    }
    this.kth.setImageDrawable(am.i(getContext(), 2131690459, -1));
    AppMethodBeat.o(134011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */