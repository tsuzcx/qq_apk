package com.tencent.mm.plugin.sns.c;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.storage.br;

public abstract interface i
{
  public abstract Bitmap a(dmz paramdmz);
  
  public abstract void a(dmz paramdmz, View paramView, int paramInt, br parambr);
  
  public abstract void b(dmz paramdmz, View paramView, int paramInt, br parambr);
  
  public abstract void bq(Activity paramActivity);
  
  public abstract void heg();
  
  public abstract void jq(View paramView);
  
  public abstract Bitmap lS(String paramString1, String paramString2);
  
  public abstract void pause();
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.c.i
 * JD-Core Version:    0.7.0.1
 */