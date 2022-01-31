package com.tencent.mm.sandbox.monitor;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;

final class b$a
{
  public String bjm;
  public final String platform;
  public String tag;
  public long timestamp;
  public String username;
  public boolean yjX;
  
  public b$a(String paramString1, String paramString2, long paramLong, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(28784);
    this.platform = (d.eQs + "_" + d.whH + "_" + Build.CPU_ABI);
    this.username = paramString1;
    this.tag = paramString2;
    this.timestamp = paramLong;
    this.bjm = paramString3;
    this.yjX = false;
    this.yjX = paramBoolean;
    AppMethodBeat.o(28784);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(28785);
    String str = this.username + "," + this.platform + "," + this.tag + ",time_" + this.timestamp + ",error_" + this.bjm;
    AppMethodBeat.o(28785);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.b.a
 * JD-Core Version:    0.7.0.1
 */