package com.tencent.mm.plugin.sns.b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.storage.bp;

public abstract interface g
{
  public abstract void a(cnb paramcnb, View paramView, int paramInt, bp parambp);
  
  public abstract void aI(Activity paramActivity);
  
  public abstract Bitmap b(cnb paramcnb);
  
  public abstract void b(cnb paramcnb, View paramView, int paramInt, bp parambp);
  
  public abstract void eZk();
  
  public abstract void ff(View paramView);
  
  public abstract void pause();
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.b.g
 * JD-Core Version:    0.7.0.1
 */