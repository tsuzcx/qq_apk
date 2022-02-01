package com.tencent.mm.plugin.sns.ui.c.a;

import android.view.View;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;

public abstract class b
{
  protected c JIp;
  public av JKG;
  public SnsInfo Jzk;
  public View KON;
  public View contentView;
  public View oFW;
  protected TimeLineObject timeLineObject;
  
  public abstract void n(View paramView1, View paramView2);
  
  public void onPause() {}
  
  public abstract void refreshView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.b
 * JD-Core Version:    0.7.0.1
 */