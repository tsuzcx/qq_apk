package com.tencent.wework.api;

import android.content.Context;

public class WWAPIFactory
{
  public static IWWAPI ik(Context paramContext)
  {
    return new WWAPIImpl(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wework.api.WWAPIFactory
 * JD-Core Version:    0.7.0.1
 */