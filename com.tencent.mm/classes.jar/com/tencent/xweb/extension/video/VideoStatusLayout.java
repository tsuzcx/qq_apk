package com.tencent.xweb.extension.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VideoStatusLayout
  extends RelativeLayout
{
  private VideoDotPercentIndicator SBe;
  private TextView SBf;
  private TextView SBg;
  private LinearLayout SBh;
  private a SBi;
  private int duration;
  private ImageView qbp;
  
  public VideoStatusLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(153564);
    this.duration = 1000;
    LayoutInflater.from(paramContext).inflate(2131496310, this);
    this.qbp = ((ImageView)findViewById(2131302604));
    this.SBe = ((VideoDotPercentIndicator)findViewById(2131306301));
    this.SBf = ((TextView)findViewById(2131309515));
    this.SBg = ((TextView)findViewById(2131309019));
    this.SBh = ((LinearLayout)findViewById(2131303105));
    this.SBi = new a((byte)0);
    setVisibility(8);
    AppMethodBeat.o(153564);
  }
  
  public void setBrightProgress(int paramInt)
  {
    AppMethodBeat.i(153567);
    this.SBe.setProgress(paramInt);
    this.SBe.setVisibility(0);
    this.SBg.setText(2131768890);
    this.SBh.setVisibility(0);
    this.qbp.setImageResource(2131235803);
    this.SBf.setVisibility(8);
    AppMethodBeat.o(153567);
  }
  
  public void setDuration(int paramInt)
  {
    this.duration = paramInt;
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(153569);
    this.qbp.setImageResource(paramInt);
    AppMethodBeat.o(153569);
  }
  
  public void setVideoTimeProgress(String paramString)
  {
    AppMethodBeat.i(153568);
    this.SBf.setText(paramString);
    this.SBf.setVisibility(0);
    this.SBh.setVisibility(8);
    AppMethodBeat.o(153568);
  }
  
  public void setVolumnProgress(int paramInt)
  {
    AppMethodBeat.i(153566);
    this.SBe.setProgress(paramInt);
    this.SBe.setVisibility(0);
    this.SBg.setText(2131768891);
    this.SBh.setVisibility(0);
    this.qbp.setImageResource(2131235813);
    this.SBf.setVisibility(8);
    AppMethodBeat.o(153566);
  }
  
  public final void show()
  {
    AppMethodBeat.i(153565);
    setVisibility(0);
    removeCallbacks(this.SBi);
    postDelayed(this.SBi, this.duration);
    AppMethodBeat.o(153565);
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(153563);
      VideoStatusLayout.this.setVisibility(8);
      AppMethodBeat.o(153563);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.extension.video.VideoStatusLayout
 * JD-Core Version:    0.7.0.1
 */