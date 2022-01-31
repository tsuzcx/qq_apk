package com.tencent.xweb.extension.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import org.xwalk.core.R.drawable;
import org.xwalk.core.R.id;
import org.xwalk.core.R.layout;
import org.xwalk.core.R.string;

public class VideoStatusLayout
  extends RelativeLayout
{
  private int duration = 1000;
  private ImageView iul;
  private VideoDotPercentIndicator xhI;
  private TextView xhJ;
  private TextView xhK;
  private LinearLayout xhL;
  private VideoStatusLayout.a xhM;
  
  public VideoStatusLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(R.layout.show_change_layout, this);
    this.iul = ((ImageView)findViewById(R.id.image_xweb_video_status));
    this.xhI = ((VideoDotPercentIndicator)findViewById(R.id.progress_xweb_video_status));
    this.xhJ = ((TextView)findViewById(R.id.tv_progress));
    this.xhK = ((TextView)findViewById(R.id.text_xweb_video_status));
    this.xhL = ((LinearLayout)findViewById(R.id.layout_xweb_video_status));
    this.xhM = new VideoStatusLayout.a(this, (byte)0);
    setVisibility(8);
  }
  
  public void setBrightProgress(int paramInt)
  {
    this.xhI.setProgress(paramInt);
    this.xhI.setVisibility(0);
    this.xhK.setText(R.string.xweb_video_brightness);
    this.xhL.setVisibility(0);
    this.iul.setImageResource(R.drawable.xweb_video_brightness_icon);
    this.xhJ.setVisibility(8);
  }
  
  public void setDuration(int paramInt)
  {
    this.duration = paramInt;
  }
  
  public void setImageResource(int paramInt)
  {
    this.iul.setImageResource(paramInt);
  }
  
  public void setVideoTimeProgress(String paramString)
  {
    this.xhJ.setText(paramString);
    this.xhJ.setVisibility(0);
    this.xhL.setVisibility(8);
  }
  
  public void setVolumnProgress(int paramInt)
  {
    this.xhI.setProgress(paramInt);
    this.xhI.setVisibility(0);
    this.xhK.setText(R.string.xweb_video_volume);
    this.xhL.setVisibility(0);
    this.iul.setImageResource(R.drawable.xweb_video_volume_icon);
    this.xhJ.setVisibility(8);
  }
  
  public final void show()
  {
    setVisibility(0);
    removeCallbacks(this.xhM);
    postDelayed(this.xhM, this.duration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.extension.video.VideoStatusLayout
 * JD-Core Version:    0.7.0.1
 */