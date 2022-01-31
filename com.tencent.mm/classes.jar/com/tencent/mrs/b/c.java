package com.tencent.mrs.b;

import com.tencent.mm.plugin.expt.d.b;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
  implements a
{
  public final float awq(String paramString)
  {
    paramString = get(paramString, "");
    if (bo.isNullOrNil(paramString)) {
      return 0.9F;
    }
    return bo.getFloat(paramString, 0.9F);
  }
  
  public final int get(String paramString, int paramInt)
  {
    paramString = get(paramString, "");
    if (bo.isNullOrNil(paramString)) {
      return paramInt;
    }
    return bo.getInt(paramString, paramInt);
  }
  
  public final long get(String paramString, long paramLong)
  {
    paramString = get(paramString, "");
    if (bo.isNullOrNil(paramString)) {
      return paramLong;
    }
    return bo.getLong(paramString, paramLong);
  }
  
  public final String get(String paramString1, String paramString2)
  {
    return b.btj().b(paramString1, paramString2, false, false);
  }
  
  public final boolean get(String paramString, boolean paramBoolean)
  {
    paramString = get(paramString, "");
    if (bo.isNullOrNil(paramString)) {
      return paramBoolean;
    }
    if (paramBoolean) {}
    for (int i = 1; bo.getInt(paramString, i) != 0; i = 0) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mrs.b.c
 * JD-Core Version:    0.7.0.1
 */