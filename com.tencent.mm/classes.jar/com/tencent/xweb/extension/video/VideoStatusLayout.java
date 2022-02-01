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
  private LinearLayout aigA;
  private a aigB;
  private VideoDotPercentIndicator aigx;
  private TextView aigy;
  private TextView aigz;
  private int duration;
  private ImageView wBJ;
  
  public VideoStatusLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(153564);
    this.duration = 1000;
    LayoutInflater.from(paramContext).inflate(R.layout.xweb_video_status, this);
    this.aigy = ((TextView)findViewById(R.id.tv_progress));
    this.wBJ = ((ImageView)findViewById(R.id.image_xweb_video_status));
    this.aigx = ((VideoDotPercentIndicator)findViewById(R.id.progress_xweb_video_status));
    this.aigz = ((TextView)findViewById(R.id.text_xweb_video_status));
    this.aigA = ((LinearLayout)findViewById(R.id.layout_xweb_video_status));
    this.aigB = new a((byte)0);
    setVisibility(8);
    AppMethodBeat.o(153564);
  }
  
  public void setBrightProgress(int paramInt)
  {
    AppMethodBeat.i(153567);
    this.aigx.setProgress(paramInt);
    this.aigx.setVisibility(0);
    this.aigz.setText(R.string.xweb_video_brightness);
    this.aigA.setVisibility(0);
    this.wBJ.setImageResource(R.drawable.xweb_video_brightness_icon);
    this.aigy.setVisibility(8);
    AppMethodBeat.o(153567);
  }
  
  public void setDuration(int paramInt)
  {
    this.duration = paramInt;
  }
  
  public void setVideoTimeProgress(String paramString)
  {
    AppMethodBeat.i(153568);
    this.aigy.setText(paramString);
    this.aigy.setVisibility(0);
    this.aigA.setVisibility(8);
    AppMethodBeat.o(153568);
  }
  
  public void setVolumeProgress(int paramInt)
  {
    AppMethodBeat.i(212734);
    this.aigx.setProgress(paramInt);
    this.aigx.setVisibility(0);
    this.aigz.setText(R.string.xweb_video_volume);
    this.aigA.setVisibility(0);
    this.wBJ.setImageResource(R.drawable.xweb_video_volume_icon);
    this.aigy.setVisibility(8);
    AppMethodBeat.o(212734);
  }
  
  public final void show()
  {
    AppMethodBeat.i(153565);
    setVisibility(0);
    removeCallbacks(this.aigB);
    postDelayed(this.aigB, this.duration);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.xweb.extension.video.VideoStatusLayout
 * JD-Core Version:    0.7.0.1
 */