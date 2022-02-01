package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.kernel.c.a;

public abstract interface p
  extends a
{
  public abstract String B(Context paramContext, String paramString);
  
  public abstract boolean a(Context paramContext, String paramString, DialogInterface.OnDismissListener paramOnDismissListener);
  
  public abstract boolean iI(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.p
 * JD-Core Version:    0.7.0.1
 */