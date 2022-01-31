package com.tencent.mm.sandbox.monitor;

import android.os.Build;
import com.tencent.mm.protocal.d;

final class b$a
{
  public String bHk;
  public final String platform = d.dOM + "_" + d.spa + "_" + Build.CPU_ABI;
  public String tag;
  public long timestamp;
  public boolean ubI;
  public String username;
  
  public b$a(String paramString1, String paramString2, long paramLong, String paramString3, boolean paramBoolean)
  {
    this.username = paramString1;
    this.tag = paramString2;
    this.timestamp = paramLong;
    this.bHk = paramString3;
    this.ubI = false;
    this.ubI = paramBoolean;
  }
  
  public final String toString()
  {
    return this.username + "," + this.platform + "," + this.tag + ",time_" + this.timestamp + ",error_" + this.bHk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.b.a
 * JD-Core Version:    0.7.0.1
 */