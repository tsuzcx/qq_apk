package com.tencent.smtt.export.external.interfaces;

import android.content.Context;

public abstract interface IX5CoreWebViewDB
{
  public abstract void clearFormData(Context paramContext);
  
  public abstract void clearHttpAuthUsernamePassword(Context paramContext);
  
  public abstract void clearUsernamePassword(Context paramContext);
  
  public abstract boolean hasFormData(Context paramContext);
  
  public abstract boolean hasHttpAuthUsernamePassword(Context paramContext);
  
  public abstract boolean hasUsernamePassword(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5CoreWebViewDB
 * JD-Core Version:    0.7.0.1
 */