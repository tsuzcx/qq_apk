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
  private VideoDotPercentIndicator BEV;
  private TextView BEW;
  private TextView BEX;
  private LinearLayout BEY;
  private VideoStatusLayout.a BEZ;
  private int duration;
  private ImageView kvq;
  
  public VideoStatusLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(84568);
    this.duration = 1000;
    LayoutInflater.from(paramContext).inflate(2130970733, this);
    this.kvq = ((ImageView)findViewById(2131827781));
    this.BEV = ((VideoDotPercentIndicator)findViewById(2131827783));
    this.BEW = ((TextView)findViewById(2131827779));
    this.BEX = ((TextView)findViewById(2131827782));
    this.BEY = ((LinearLayout)findViewById(2131827780));
    this.BEZ = new VideoStatusLayout.a(this, (byte)0);
    setVisibility(8);
    AppMethodBeat.o(84568);
  }
  
  public void setBrightProgress(int paramInt)
  {
    AppMethodBeat.i(84571);
    this.BEV.setProgress(paramInt);
    this.BEV.setVisibility(0);
    this.BEX.setText(2131306278);
    this.BEY.setVisibility(0);
    this.kvq.setImageResource(2130840978);
    this.BEW.setVisibility(8);
    AppMethodBeat.o(84571);
  }
  
  public void setDuration(int paramInt)
  {
    this.duration = paramInt;
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(84573);
    this.kvq.setImageResource(paramInt);
    AppMethodBeat.o(84573);
  }
  
  public void setVideoTimeProgress(String paramString)
  {
    AppMethodBeat.i(84572);
    this.BEW.setText(paramString);
    this.BEW.setVisibility(0);
    this.BEY.setVisibility(8);
    AppMethodBeat.o(84572);
  }
  
  public void setVolumnProgress(int paramInt)
  {
    AppMethodBeat.i(84570);
    this.BEV.setProgress(paramInt);
    this.BEV.setVisibility(0);
    this.BEX.setText(2131306279);
    this.BEY.setVisibility(0);
    this.kvq.setImageResource(2130840988);
    this.BEW.setVisibility(8);
    AppMethodBeat.o(84570);
  }
  
  public final void show()
  {
    AppMethodBeat.i(84569);
    setVisibility(0);
    removeCallbacks(this.BEZ);
    postDelayed(this.BEZ, this.duration);
    AppMethodBeat.o(84569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.extension.video.VideoStatusLayout
 * JD-Core Version:    0.7.0.1
 */