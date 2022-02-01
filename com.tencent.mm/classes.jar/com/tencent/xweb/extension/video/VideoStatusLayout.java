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
  private VideoDotPercentIndicator MOi;
  private TextView MOj;
  private TextView MOk;
  private LinearLayout MOl;
  private a MOm;
  private int duration;
  private ImageView oNB;
  
  public VideoStatusLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(153564);
    this.duration = 1000;
    LayoutInflater.from(paramContext).inflate(2131495438, this);
    this.oNB = ((ImageView)findViewById(2131300968));
    this.MOi = ((VideoDotPercentIndicator)findViewById(2131303534));
    this.MOj = ((TextView)findViewById(2131306145));
    this.MOk = ((TextView)findViewById(2131305749));
    this.MOl = ((LinearLayout)findViewById(2131301358));
    this.MOm = new a((byte)0);
    setVisibility(8);
    AppMethodBeat.o(153564);
  }
  
  public void setBrightProgress(int paramInt)
  {
    AppMethodBeat.i(153567);
    this.MOi.setProgress(paramInt);
    this.MOi.setVisibility(0);
    this.MOk.setText(2131766373);
    this.MOl.setVisibility(0);
    this.oNB.setImageResource(2131234811);
    this.MOj.setVisibility(8);
    AppMethodBeat.o(153567);
  }
  
  public void setDuration(int paramInt)
  {
    this.duration = paramInt;
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(153569);
    this.oNB.setImageResource(paramInt);
    AppMethodBeat.o(153569);
  }
  
  public void setVideoTimeProgress(String paramString)
  {
    AppMethodBeat.i(153568);
    this.MOj.setText(paramString);
    this.MOj.setVisibility(0);
    this.MOl.setVisibility(8);
    AppMethodBeat.o(153568);
  }
  
  public void setVolumnProgress(int paramInt)
  {
    AppMethodBeat.i(153566);
    this.MOi.setProgress(paramInt);
    this.MOi.setVisibility(0);
    this.MOk.setText(2131766374);
    this.MOl.setVisibility(0);
    this.oNB.setImageResource(2131234821);
    this.MOj.setVisibility(8);
    AppMethodBeat.o(153566);
  }
  
  public final void show()
  {
    AppMethodBeat.i(153565);
    setVisibility(0);
    removeCallbacks(this.MOm);
    postDelayed(this.MOm, this.duration);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.extension.video.VideoStatusLayout
 * JD-Core Version:    0.7.0.1
 */