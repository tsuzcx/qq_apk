package com.tencent.mm.plugin.sns.ui.c.a;

import android.view.View;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;

public abstract class b
{
  public SnsInfo PNI;
  protected c PZr;
  public aw Qcj;
  public View Qcs;
  public View RoA;
  public View contentView;
  protected TimeLineObject timeLineObject;
  
  public void onPause() {}
  
  public void onUIDestroy() {}
  
  public abstract void refreshView();
  
  public abstract void t(View paramView1, View paramView2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.b
 * JD-Core Version:    0.7.0.1
 */