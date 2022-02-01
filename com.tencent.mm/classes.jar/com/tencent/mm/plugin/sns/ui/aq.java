package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class aq
{
  public String doX;
  public boolean isAd = false;
  public int position;
  public ImageView zFD;
  public TextView zFE;
  public View zWA;
  public MMPinProgressBtn zWB;
  public TextView zWC;
  public int zWD = 2;
  public boolean zWE = false;
  public int zWF = 0;
  public boolean zWG = false;
  public TimeLineObject zWw;
  public View zWx;
  public VideoSightView zWy;
  public SnsAdTimelineVideoView zWz;
  
  public final void a(TimeLineObject paramTimeLineObject, int paramInt, String paramString, boolean paramBoolean)
  {
    this.zWw = paramTimeLineObject;
    this.position = paramInt;
    this.doX = paramString;
    this.isAd = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.aq
 * JD-Core Version:    0.7.0.1
 */