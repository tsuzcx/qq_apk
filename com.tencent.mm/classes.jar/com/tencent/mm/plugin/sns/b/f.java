package com.tencent.mm.plugin.sns.b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.storage.az;

public abstract interface f
{
  public abstract void M(Activity paramActivity);
  
  public abstract String a(awd paramawd);
  
  public abstract void a(awd paramawd, View paramView, int paramInt, az paramaz);
  
  public abstract Bitmap b(awd paramawd);
  
  public abstract void b(awd paramawd, View paramView, int paramInt, az paramaz);
  
  public abstract void bCm();
  
  public abstract void cM(View paramView);
  
  public abstract void pause();
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.b.f
 * JD-Core Version:    0.7.0.1
 */