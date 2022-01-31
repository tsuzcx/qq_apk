package com.tencent.mm.plugin.sns.b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.storage.az;

public abstract interface f
{
  public abstract String a(bcs parambcs);
  
  public abstract void a(bcs parambcs, View paramView, int paramInt, az paramaz);
  
  public abstract void ah(Activity paramActivity);
  
  public abstract Bitmap b(bcs parambcs);
  
  public abstract void b(bcs parambcs, View paramView, int paramInt, az paramaz);
  
  public abstract void cnM();
  
  public abstract void dC(View paramView);
  
  public abstract void pause();
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.b.f
 * JD-Core Version:    0.7.0.1
 */