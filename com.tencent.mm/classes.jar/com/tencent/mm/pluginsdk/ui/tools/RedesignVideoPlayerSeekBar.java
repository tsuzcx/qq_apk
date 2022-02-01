package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.af.a.b;
import com.tencent.mm.plugin.af.a.c;
import com.tencent.mm.plugin.af.a.d;
import com.tencent.mm.plugin.af.a.e;
import com.tencent.mm.ui.au;

public class RedesignVideoPlayerSeekBar
  extends VideoPlayerSeekBar
{
  long RxK = 0L;
  long fmH = 0L;
  long lLH = 0L;
  private ImageView pCr;
  
  public RedesignVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RedesignVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean arc(int paramInt)
  {
    AppMethodBeat.i(134012);
    int j = getVideoTotalTime();
    if ((paramInt == this.lLH) && (j == this.fmH))
    {
      AppMethodBeat.o(134012);
      return false;
    }
    if (System.currentTimeMillis() - this.RxK < 300L)
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
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.pCr.getLayoutParams();
      localLayoutParams.width = paramInt;
      this.pCr.setLayoutParams(localLayoutParams);
      this.lLH = i;
      this.fmH = j;
      AppMethodBeat.o(134012);
      return true;
    }
  }
  
  public int getLayoutId()
  {
    return a.c.redesign_video_player_seek_bar;
  }
  
  public final void iF(boolean paramBoolean)
  {
    AppMethodBeat.i(134010);
    setIsPlay(paramBoolean);
    AppMethodBeat.o(134010);
  }
  
  public final void init()
  {
    AppMethodBeat.i(134009);
    super.init();
    this.pCr = ((ImageView)this.contentView.findViewById(a.b.player_progress_bar_middle));
    AppMethodBeat.o(134009);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(134011);
    this.fEq = paramBoolean;
    if (paramBoolean)
    {
      this.pCc.setImageDrawable(au.o(getContext(), a.d.icons_filled_pause, -1));
      this.pCc.setContentDescription(getContext().getString(a.e.app_pause));
      AppMethodBeat.o(134011);
      return;
    }
    this.pCc.setImageDrawable(au.o(getContext(), a.d.icons_filled_play, -1));
    this.pCc.setContentDescription(getContext().getString(a.e.app_play));
    AppMethodBeat.o(134011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */