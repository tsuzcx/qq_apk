package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
{
  private Context a;
  private int b;
  private boolean c;
  private String d;
  private String e;
  private String f;
  private boolean g;
  private int h;
  
  public q(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(149614);
    this.d = "";
    this.e = "";
    this.f = "0M100WJ33N1CQ08O";
    this.g = false;
    this.h = -1;
    this.a = paramContext.getApplicationContext();
    this.b = paramInt;
    this.c = true;
    this.d = paramString1;
    this.e = paramString2;
    AppMethodBeat.o(149614);
  }
  
  public final Context a()
  {
    return this.a;
  }
  
  public final String b()
  {
    return this.e;
  }
  
  public final String c()
  {
    return this.d;
  }
  
  public final boolean d()
  {
    return this.c;
  }
  
  public final int e()
  {
    return this.b;
  }
  
  public final boolean f()
  {
    return this.g;
  }
  
  public final int g()
  {
    return this.h;
  }
  
  public final String h()
  {
    return this.f;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149615);
    Object localObject = new StringBuilder("[");
    ((StringBuilder)localObject).append("appid:" + this.b);
    ((StringBuilder)localObject).append(",uuid:" + this.d);
    ((StringBuilder)localObject).append(",channelid:" + this.e);
    ((StringBuilder)localObject).append(",isSDKMode:" + this.c);
    ((StringBuilder)localObject).append(",isTest:" + this.g);
    ((StringBuilder)localObject).append(",testAppid:" + this.h);
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(149615);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.q
 * JD-Core Version:    0.7.0.1
 */