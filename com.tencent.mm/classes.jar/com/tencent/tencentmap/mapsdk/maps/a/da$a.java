package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class da$a
{
  public String a;
  public boolean b = false;
  public boolean c = false;
  public String d = "";
  public Bundle e;
  private int f;
  
  public da$a(int paramInt, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, Bundle paramBundle)
  {
    this.f = paramInt;
    this.a = paramString1;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramString2;
    this.e = paramBundle;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(147395);
    String str = "appid:" + this.f + "," + this.a + "," + this.b + "," + this.c + "," + this.d;
    AppMethodBeat.o(147395);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.da.a
 * JD-Core Version:    0.7.0.1
 */