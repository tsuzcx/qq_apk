package com.tencent.xweb.extension.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.R.drawable;
import org.xwalk.core.R.id;
import org.xwalk.core.R.layout;
import org.xwalk.core.R.string;

public class VideoStatusLayout
  extends RelativeLayout
{
  private VideoDotPercentIndicator aabZ;
  private TextView aaca;
  private TextView aacb;
  private LinearLayout aacc;
  private a aacd;
  private int duration;
  private ImageView txm;
  
  public VideoStatusLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(153564);
    this.duration = 1000;
    LayoutInflater.from(paramContext).inflate(R.layout.show_change_layout, this);
    this.txm = ((ImageView)findViewById(R.id.image_xweb_video_status));
    this.aabZ = ((VideoDotPercentIndicator)findViewById(R.id.progress_xweb_video_status));
    this.aaca = ((TextView)findViewById(R.id.tv_progress));
    this.aacb = ((TextView)findViewById(R.id.text_xweb_video_status));
    this.aacc = ((LinearLayout)findViewById(R.id.layout_xweb_video_status));
    this.aacd = new a((byte)0);
    setVisibility(8);
    AppMethodBeat.o(153564);
  }
  
  public void setBrightProgress(int paramInt)
  {
    AppMethodBeat.i(153567);
    this.aabZ.setProgress(paramInt);
    this.aabZ.setVisibility(0);
    this.aacb.setText(R.string.xweb_video_brightness);
    this.aacc.setVisibility(0);
    this.txm.setImageResource(R.drawable.xweb_video_brightness_icon);
    this.aaca.setVisibility(8);
    AppMethodBeat.o(153567);
  }
  
  public void setDuration(int paramInt)
  {
    this.duration = paramInt;
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(153569);
    this.txm.setImageResource(paramInt);
    AppMethodBeat.o(153569);
  }
  
  public void setVideoTimeProgress(String paramString)
  {
    AppMethodBeat.i(153568);
    this.aaca.setText(paramString);
    this.aaca.setVisibility(0);
    this.aacc.setVisibility(8);
    AppMethodBeat.o(153568);
  }
  
  public void setVolumnProgress(int paramInt)
  {
    AppMethodBeat.i(153566);
    this.aabZ.setProgress(paramInt);
    this.aabZ.setVisibility(0);
    this.aacb.setText(R.string.xweb_video_volume);
    this.aacc.setVisibility(0);
    this.txm.setImageResource(R.drawable.xweb_video_volume_icon);
    this.aaca.setVisibility(8);
    AppMethodBeat.o(153566);
  }
  
  public final void show()
  {
    AppMethodBeat.i(153565);
    setVisibility(0);
    removeCallbacks(this.aacd);
    postDelayed(this.aacd, this.duration);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.extension.video.VideoStatusLayout
 * JD-Core Version:    0.7.0.1
 */