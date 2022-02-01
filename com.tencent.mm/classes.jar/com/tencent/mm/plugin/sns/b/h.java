package com.tencent.mm.plugin.sns.b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.storage.bp;

public abstract interface h
{
  public abstract Bitmap a(cvt paramcvt);
  
  public abstract void a(cvt paramcvt, View paramView, int paramInt, bp parambp);
  
  public abstract void aO(Activity paramActivity);
  
  public abstract void b(cvt paramcvt, View paramView, int paramInt, bp parambp);
  
  public abstract void fNa();
  
  public abstract void gm(View paramView);
  
  public abstract void pause();
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.b.h
 * JD-Core Version:    0.7.0.1
 */