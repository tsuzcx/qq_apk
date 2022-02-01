package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class aw
{
  public ImageView PQu;
  public TextView QRC;
  public TimeLineObject RjK;
  public View RjL;
  public VideoSightView RjM;
  public SnsAdTimelineVideoView RjN;
  public View RjO;
  public MMPinProgressBtn RjP;
  public TextView RjQ;
  public ImageView RjR;
  public int RjS = 2;
  public boolean RjT = false;
  public int RjU = 0;
  public String hES;
  public boolean isAd = false;
  public int position;
  
  public final void a(TimeLineObject paramTimeLineObject, int paramInt, String paramString, boolean paramBoolean)
  {
    this.RjK = paramTimeLineObject;
    this.position = paramInt;
    this.hES = paramString;
    this.isAd = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.aw
 * JD-Core Version:    0.7.0.1
 */