package com.tencent.mm.plugin.sns.b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.storage.bf;

public abstract interface g
{
  public abstract Bitmap a(btz parambtz);
  
  public abstract void a(btz parambtz, View paramView, int paramInt, bf parambf);
  
  public abstract void aD(Activity paramActivity);
  
  public abstract void b(btz parambtz, View paramView, int paramInt, bf parambf);
  
  public abstract void dGo();
  
  public abstract void eB(View paramView);
  
  public abstract void pause();
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.b.g
 * JD-Core Version:    0.7.0.1
 */