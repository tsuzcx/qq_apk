package com.tencent.mm.plugin.textstatus.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import com.tencent.mm.kernel.c.a;

public abstract interface n
  extends a
{
  public abstract q a(Context paramContext, z paramz, y paramy);
  
  public abstract void a(String paramString, o paramo);
  
  public abstract boolean a(Activity paramActivity, int paramInt, w paramw);
  
  public abstract boolean a(Context paramContext, w paramw);
  
  public abstract boolean a(Context paramContext, w paramw, ResultReceiver paramResultReceiver);
  
  public abstract void bdp(String paramString);
  
  public abstract void g(Activity paramActivity, Intent paramIntent, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.n
 * JD-Core Version:    0.7.0.1
 */