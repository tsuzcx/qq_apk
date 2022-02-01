package com.tencent.mm.plugin.wxpaysdk.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public abstract interface c
  extends com.tencent.mm.kernel.c.a
{
  public abstract void a(Activity paramActivity, Bundle paramBundle, a parama);
  
  public abstract void f(Activity paramActivity, String paramString1, String paramString2);
  
  public abstract void h(Activity paramActivity, Bundle paramBundle);
  
  public abstract com.tencent.mm.pluginsdk.c.a kF(Context paramContext);
  
  public abstract com.tencent.mm.pluginsdk.c.a kG(Context paramContext);
  
  public abstract com.tencent.mm.pluginsdk.c.a kH(Context paramContext);
  
  public abstract com.tencent.mm.pluginsdk.c.a kI(Context paramContext);
  
  public static abstract interface a
  {
    public abstract void onProcessEnd(int paramInt, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpaysdk.api.c
 * JD-Core Version:    0.7.0.1
 */