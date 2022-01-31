package com.tencent.mm.plugin.sns.ui.c.a;

import android.view.View;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;

public abstract class a
{
  public View contentView;
  public n rMD;
  protected b rOV;
  public View rOw;
  public aj sfG;
  protected TimeLineObject timeLineObject;
  
  public abstract void g(View paramView1, View paramView2);
  
  public abstract void refreshView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.a
 * JD-Core Version:    0.7.0.1
 */