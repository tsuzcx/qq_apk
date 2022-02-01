package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class an
{
  public String ddB;
  public boolean isAd = false;
  public int position;
  public TimeLineObject yFb;
  public View yFc;
  public VideoSightView yFd;
  public SnsAdTimelineVideoView yFe;
  public View yFf;
  public MMPinProgressBtn yFg;
  public TextView yFh;
  public int yFi = 2;
  public boolean yFj = false;
  public int yFk = 0;
  public boolean yFl = false;
  public ImageView yoI;
  public TextView yoJ;
  
  public final void a(TimeLineObject paramTimeLineObject, int paramInt, String paramString, boolean paramBoolean)
  {
    this.yFb = paramTimeLineObject;
    this.position = paramInt;
    this.ddB = paramString;
    this.isAd = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.an
 * JD-Core Version:    0.7.0.1
 */