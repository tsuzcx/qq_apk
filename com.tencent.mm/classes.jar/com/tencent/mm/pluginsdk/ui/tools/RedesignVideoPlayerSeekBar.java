package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ag.a.b;
import com.tencent.mm.plugin.ag.a.c;
import com.tencent.mm.plugin.ag.a.d;
import com.tencent.mm.plugin.ag.a.e;
import com.tencent.mm.ui.bb;

public class RedesignVideoPlayerSeekBar
  extends VideoPlayerSeekBar
{
  long Yua = 0L;
  long hqS = 0L;
  long oEj = 0L;
  private ImageView sHD;
  
  public RedesignVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RedesignVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean axi(int paramInt)
  {
    AppMethodBeat.i(134012);
    int j = getVideoTotalTime();
    if ((paramInt == this.oEj) && (j == this.hqS))
    {
      AppMethodBeat.o(134012);
      return false;
    }
    if (System.currentTimeMillis() - this.Yua < 300L)
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
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.sHD.getLayoutParams();
      localLayoutParams.width = paramInt;
      this.sHD.setLayoutParams(localLayoutParams);
      this.oEj = i;
      this.hqS = j;
      AppMethodBeat.o(134012);
      return true;
    }
  }
  
  public int getLayoutId()
  {
    return a.c.redesign_video_player_seek_bar;
  }
  
  public final void init()
  {
    AppMethodBeat.i(134009);
    super.init();
    this.sHD = ((ImageView)this.contentView.findViewById(a.b.player_progress_bar_middle));
    AppMethodBeat.o(134009);
  }
  
  public final void jJ(boolean paramBoolean)
  {
    AppMethodBeat.i(134010);
    setIsPlay(paramBoolean);
    AppMethodBeat.o(134010);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(134011);
    this.hJg = paramBoolean;
    if (paramBoolean)
    {
      this.sHp.setImageDrawable(bb.m(getContext(), a.d.icons_filled_pause, -1));
      this.sHp.setContentDescription(getContext().getString(a.e.app_pause));
      AppMethodBeat.o(134011);
      return;
    }
    this.sHp.setImageDrawable(bb.m(getContext(), a.d.icons_filled_play, -1));
    this.sHp.setContentDescription(getContext().getString(a.e.app_play));
    AppMethodBeat.o(134011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */