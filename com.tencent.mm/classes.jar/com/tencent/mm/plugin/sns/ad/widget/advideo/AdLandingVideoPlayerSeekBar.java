package com.tencent.mm.plugin.sns.ad.widget.advideo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.Log;

public class AdLandingVideoPlayerSeekBar
  extends VideoPlayerSeekBar
{
  public AdLandingVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdLandingVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int getLayoutId()
  {
    return b.g.ad_landing_video_player_seek_bar;
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(310143);
    this.hJg = paramBoolean;
    if (this.sHp == null)
    {
      Log.e("AdLandingVideoPlayerSeekBar", "in adLandingVideoPlayerSeekBar setIsPlay, mPlayBtn is null");
      AppMethodBeat.o(310143);
      return;
    }
    if (paramBoolean)
    {
      this.sHp.setImageResource(b.i.media_player_btn_cur_status_on);
      AppMethodBeat.o(310143);
      return;
    }
    this.sHp.setImageResource(b.i.media_player_btn_cur_status_off);
    AppMethodBeat.o(310143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.advideo.AdLandingVideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */