package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class av
{
  public ImageView JAL;
  public TimeLineObject KKi;
  public View KKj;
  public VideoSightView KKk;
  public SnsAdTimelineVideoView KKl;
  public View KKm;
  public MMPinProgressBtn KKn;
  public TextView KKo;
  public ImageView KKp;
  public int KKq = 2;
  public boolean KKr = false;
  public int KKs = 0;
  public TextView Ktc;
  public String fAg;
  public boolean isAd = false;
  public int position;
  
  public final void a(TimeLineObject paramTimeLineObject, int paramInt, String paramString, boolean paramBoolean)
  {
    this.KKi = paramTimeLineObject;
    this.position = paramInt;
    this.fAg = paramString;
    this.isAd = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.av
 * JD-Core Version:    0.7.0.1
 */