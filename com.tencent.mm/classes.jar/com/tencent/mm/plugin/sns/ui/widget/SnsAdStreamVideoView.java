package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ap;

public class SnsAdStreamVideoView
  extends MMVideoView
{
  public ap smN;
  
  public SnsAdStreamVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(145785);
    this.smN = new ap(new SnsAdStreamVideoView.2(this), false);
    AppMethodBeat.o(145785);
  }
  
  public SnsAdStreamVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(145786);
    this.smN = new ap(new SnsAdStreamVideoView.2(this), false);
    AppMethodBeat.o(145786);
  }
  
  public final int cxE()
  {
    return 2130970799;
  }
  
  public final void cxF()
  {
    AppMethodBeat.i(145787);
    this.mwF.setVisibility(0);
    AppMethodBeat.o(145787);
  }
  
  public final void cxG()
  {
    AppMethodBeat.i(145788);
    this.mwF.setVisibility(4);
    AppMethodBeat.o(145788);
  }
  
  public final b cxH()
  {
    AppMethodBeat.i(145789);
    b local1 = new b()
    {
      public final void aFf()
      {
        AppMethodBeat.i(145782);
        SnsAdStreamVideoView.a(SnsAdStreamVideoView.this).stopTimer();
        AppMethodBeat.o(145782);
      }
      
      public final void on(int paramAnonymousInt)
      {
        AppMethodBeat.i(145783);
        if (SnsAdStreamVideoView.this.d(paramAnonymousInt, true)) {
          SnsAdStreamVideoView.b(SnsAdStreamVideoView.this);
        }
        SnsAdStreamVideoView.c(SnsAdStreamVideoView.this).setIsPlay(true);
        AppMethodBeat.o(145783);
      }
    };
    AppMethodBeat.o(145789);
    return local1;
  }
  
  public final void cxI()
  {
    AppMethodBeat.i(145790);
    this.smN.ag(5000L, 0L);
    AppMethodBeat.o(145790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdStreamVideoView
 * JD-Core Version:    0.7.0.1
 */