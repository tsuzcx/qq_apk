package com.tencent.mm.plugin.sns.ad.widget.advideo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
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
    return i.g.ad_landing_video_player_seek_bar;
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(194707);
    this.fEq = paramBoolean;
    if (this.pCc == null)
    {
      Log.e("AdLandingVideoPlayerSeekBar", "in adLandingVideoPlayerSeekBar setIsPlay, mPlayBtn is null");
      AppMethodBeat.o(194707);
      return;
    }
    if (paramBoolean)
    {
      this.pCc.setImageResource(i.i.media_player_btn_cur_status_on);
      AppMethodBeat.o(194707);
      return;
    }
    this.pCc.setImageResource(i.i.media_player_btn_cur_status_off);
    AppMethodBeat.o(194707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.advideo.AdLandingVideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */