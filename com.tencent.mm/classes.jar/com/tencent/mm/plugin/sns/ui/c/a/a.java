package com.tencent.mm.plugin.sns.ui.c.a;

import android.view.View;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;

public abstract class a
{
  public aq AKJ;
  public View ArR;
  public View contentView;
  public View kFh;
  protected TimeLineObject timeLineObject;
  public p znm;
  protected c zrv;
  
  public abstract void m(View paramView1, View paramView2);
  
  public void onPause() {}
  
  public abstract void refreshView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.a
 * JD-Core Version:    0.7.0.1
 */