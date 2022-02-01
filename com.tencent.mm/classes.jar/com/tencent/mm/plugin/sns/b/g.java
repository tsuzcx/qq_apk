package com.tencent.mm.plugin.sns.b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.storage.bk;

public abstract interface g
{
  public abstract Bitmap a(bzh parambzh);
  
  public abstract void a(bzh parambzh, View paramView, int paramInt, bk parambk);
  
  public abstract void aE(Activity paramActivity);
  
  public abstract void b(bzh parambzh, View paramView, int paramInt, bk parambk);
  
  public abstract void dVZ();
  
  public abstract void eQ(View paramView);
  
  public abstract void pause();
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.b.g
 * JD-Core Version:    0.7.0.1
 */