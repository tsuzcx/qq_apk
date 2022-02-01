package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class at
{
  public ImageView EeS;
  public TextView EeT;
  public boolean EwA = false;
  public TimeLineObject Ewq;
  public View Ewr;
  public VideoSightView Ews;
  public SnsAdTimelineVideoView Ewt;
  public View Ewu;
  public MMPinProgressBtn Ewv;
  public TextView Eww;
  public int Ewx = 2;
  public boolean Ewy = false;
  public int Ewz = 0;
  public String dHp;
  public boolean isAd = false;
  public int position;
  
  public final void a(TimeLineObject paramTimeLineObject, int paramInt, String paramString, boolean paramBoolean)
  {
    this.Ewq = paramTimeLineObject;
    this.position = paramInt;
    this.dHp = paramString;
    this.isAd = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.at
 * JD-Core Version:    0.7.0.1
 */