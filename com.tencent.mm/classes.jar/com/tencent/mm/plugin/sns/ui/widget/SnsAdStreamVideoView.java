package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public class SnsAdStreamVideoView
  extends MMVideoView
{
  public MTimerHandler FeB;
  
  public SnsAdStreamVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100473);
    this.FeB = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(100472);
        SnsAdStreamVideoView.this.setIsShowBasicControls(false);
        AppMethodBeat.o(100472);
        return true;
      }
    }, false);
    AppMethodBeat.o(100473);
  }
  
  public SnsAdStreamVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100474);
    this.FeB = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(100472);
        SnsAdStreamVideoView.this.setIsShowBasicControls(false);
        AppMethodBeat.o(100472);
        return true;
      }
    }, false);
    AppMethodBeat.o(100474);
  }
  
  public final int dEP()
  {
    return 2131496405;
  }
  
  public final void fld()
  {
    AppMethodBeat.i(100475);
    this.mEx.setVisibility(0);
    AppMethodBeat.o(100475);
  }
  
  public final void fle()
  {
    AppMethodBeat.i(100476);
    this.mEx.setVisibility(4);
    AppMethodBeat.o(100476);
  }
  
  public final b flf()
  {
    AppMethodBeat.i(100477);
    b local1 = new b()
    {
      public final void aJq()
      {
        AppMethodBeat.i(100470);
        SnsAdStreamVideoView.a(SnsAdStreamVideoView.this).stopTimer();
        AppMethodBeat.o(100470);
      }
      
      public final void rk(int paramAnonymousInt)
      {
        AppMethodBeat.i(100471);
        if (SnsAdStreamVideoView.a(SnsAdStreamVideoView.this, paramAnonymousInt)) {
          SnsAdStreamVideoView.b(SnsAdStreamVideoView.this);
        }
        SnsAdStreamVideoView.c(SnsAdStreamVideoView.this).setIsPlay(true);
        AppMethodBeat.o(100471);
      }
    };
    AppMethodBeat.o(100477);
    return local1;
  }
  
  public final void flg()
  {
    AppMethodBeat.i(100478);
    this.FeB.startTimer(5000L, 0L);
    AppMethodBeat.o(100478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdStreamVideoView
 * JD-Core Version:    0.7.0.1
 */