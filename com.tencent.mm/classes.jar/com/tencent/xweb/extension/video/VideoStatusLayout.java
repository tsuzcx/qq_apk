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
  private VideoDotPercentIndicator Mre;
  private TextView Mrf;
  private TextView Mrg;
  private LinearLayout Mrh;
  private a Mri;
  private int duration;
  private ImageView oGZ;
  
  public VideoStatusLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(153564);
    this.duration = 1000;
    LayoutInflater.from(paramContext).inflate(2131495438, this);
    this.oGZ = ((ImageView)findViewById(2131300968));
    this.Mre = ((VideoDotPercentIndicator)findViewById(2131303534));
    this.Mrf = ((TextView)findViewById(2131306145));
    this.Mrg = ((TextView)findViewById(2131305749));
    this.Mrh = ((LinearLayout)findViewById(2131301358));
    this.Mri = new a((byte)0);
    setVisibility(8);
    AppMethodBeat.o(153564);
  }
  
  public void setBrightProgress(int paramInt)
  {
    AppMethodBeat.i(153567);
    this.Mre.setProgress(paramInt);
    this.Mre.setVisibility(0);
    this.Mrg.setText(2131766373);
    this.Mrh.setVisibility(0);
    this.oGZ.setImageResource(2131234811);
    this.Mrf.setVisibility(8);
    AppMethodBeat.o(153567);
  }
  
  public void setDuration(int paramInt)
  {
    this.duration = paramInt;
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(153569);
    this.oGZ.setImageResource(paramInt);
    AppMethodBeat.o(153569);
  }
  
  public void setVideoTimeProgress(String paramString)
  {
    AppMethodBeat.i(153568);
    this.Mrf.setText(paramString);
    this.Mrf.setVisibility(0);
    this.Mrh.setVisibility(8);
    AppMethodBeat.o(153568);
  }
  
  public void setVolumnProgress(int paramInt)
  {
    AppMethodBeat.i(153566);
    this.Mre.setProgress(paramInt);
    this.Mre.setVisibility(0);
    this.Mrg.setText(2131766374);
    this.Mrh.setVisibility(0);
    this.oGZ.setImageResource(2131234821);
    this.Mrf.setVisibility(8);
    AppMethodBeat.o(153566);
  }
  
  public final void show()
  {
    AppMethodBeat.i(153565);
    setVisibility(0);
    removeCallbacks(this.Mri);
    postDelayed(this.Mri, this.duration);
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