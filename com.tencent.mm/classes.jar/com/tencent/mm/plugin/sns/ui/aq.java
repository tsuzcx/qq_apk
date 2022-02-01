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
  public TimeLineObject AnF;
  public View AnG;
  public VideoSightView AnH;
  public SnsAdTimelineVideoView AnI;
  public View AnJ;
  public MMPinProgressBtn AnK;
  public TextView AnL;
  public int AnM = 2;
  public boolean AnN = false;
  public int AnO = 0;
  public boolean AnP = false;
  public String dqc;
  public boolean isAd = false;
  public int position;
  public ImageView zWJ;
  public TextView zWK;
  
  public final void a(TimeLineObject paramTimeLineObject, int paramInt, String paramString, boolean paramBoolean)
  {
    this.AnF = paramTimeLineObject;
    this.position = paramInt;
    this.dqc = paramString;
    this.isAd = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.aq
 * JD-Core Version:    0.7.0.1
 */