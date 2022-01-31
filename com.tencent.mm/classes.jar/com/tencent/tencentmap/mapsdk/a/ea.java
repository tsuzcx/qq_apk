package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;

public final class ea
{
  private Context a;
  private int b;
  private boolean c;
  private String d = "";
  private String e = "";
  private String f = "0M100WJ33N1CQ08O";
  private boolean g = false;
  private int h = -1;
  
  public ea(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramInt;
    this.c = true;
    this.d = paramString1;
    this.e = paramString2;
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
    StringBuilder localStringBuilder = new StringBuilder("[");
    localStringBuilder.append("appid:" + this.b);
    localStringBuilder.append(",uuid:" + this.d);
    localStringBuilder.append(",channelid:" + this.e);
    localStringBuilder.append(",isSDKMode:" + this.c);
    localStringBuilder.append(",isTest:" + this.g);
    localStringBuilder.append(",testAppid:" + this.h);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ea
 * JD-Core Version:    0.7.0.1
 */