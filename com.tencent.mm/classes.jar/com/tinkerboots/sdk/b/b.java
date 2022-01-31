package com.tinkerboots.sdk.b;

import android.content.Context;

public final class b
{
  public static Context context;
  
  public static Context getContext()
  {
    if (context == null) {
      throw new RuntimeException("TinkerClientContext, context is null, please init first");
    }
    return context;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tinkerboots.sdk.b.b
 * JD-Core Version:    0.7.0.1
 */