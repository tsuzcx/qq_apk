package com.tencent.mm.plugin.sns.ui.c.a;

import android.view.View;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;

public abstract class a
{
  public SnsInfo DsC;
  protected c Dyw;
  public View EAV;
  public at EUK;
  public View contentView;
  public View lJI;
  protected TimeLineObject timeLineObject;
  
  public abstract void n(View paramView1, View paramView2);
  
  public void onPause() {}
  
  public abstract void refreshView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.a
 * JD-Core Version:    0.7.0.1
 */