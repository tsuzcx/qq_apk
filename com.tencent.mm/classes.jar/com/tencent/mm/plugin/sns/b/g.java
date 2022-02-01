package com.tencent.mm.plugin.sns.b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.storage.bj;

public abstract interface g
{
  public abstract Bitmap a(byn parambyn);
  
  public abstract void a(byn parambyn, View paramView, int paramInt, bj parambj);
  
  public abstract void aD(Activity paramActivity);
  
  public abstract void b(byn parambyn, View paramView, int paramInt, bj parambj);
  
  public abstract void dSB();
  
  public abstract void eR(View paramView);
  
  public abstract void pause();
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.b.g
 * JD-Core Version:    0.7.0.1
 */