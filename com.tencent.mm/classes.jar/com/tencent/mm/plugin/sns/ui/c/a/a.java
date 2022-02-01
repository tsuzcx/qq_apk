package com.tencent.mm.plugin.sns.ui.c.a;

import android.view.View;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.an;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;

public abstract class a
{
  public View contentView;
  public View jGG;
  protected TimeLineObject timeLineObject;
  public p wwP;
  public an xOO;
  protected b xta;
  public View xwu;
  
  public abstract void k(View paramView1, View paramView2);
  
  public void onPause() {}
  
  public abstract void refreshView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.a
 * JD-Core Version:    0.7.0.1
 */