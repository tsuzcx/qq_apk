package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.plugin.sns.model.af;

public final class h
{
  public static n OA(String paramString)
  {
    if (v.MJ(paramString)) {
      return af.bDF().gt(v.OU(paramString));
    }
    paramString = af.bDI().gk(v.OU(paramString));
    if (paramString != null) {
      return paramString.bGl();
    }
    return null;
  }
  
  public static n OB(String paramString)
  {
    if (v.MJ(paramString)) {
      return af.bDF().yt(v.OV(paramString));
    }
    paramString = af.bDI().yq(v.OV(paramString));
    if (paramString != null) {
      return paramString.bGl();
    }
    return null;
  }
  
  public static boolean a(String paramString, n paramn)
  {
    if (v.MJ(paramString)) {
      return af.bDF().b(v.OU(paramString), paramn);
    }
    return af.bDI().b(v.OU(paramString), paramn.bGN());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.h
 * JD-Core Version:    0.7.0.1
 */