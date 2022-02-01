package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class d
{
  public String md5;
  public String value;
  public long wTP;
  public long wTQ;
  public String wTR;
  public boolean wTS;
  
  public d() {}
  
  public d(long paramLong1, String paramString, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(143832);
    this.wTP = paramLong1;
    this.value = paramString;
    this.wTQ = paramLong2;
    this.wTS = paramBoolean;
    this.wTR = new SimpleDateFormat("[yy-MM-dd HH:mm:ss:SSS]").format(new Date(paramLong2));
    AppMethodBeat.o(143832);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(143833);
    String str = this.wTR + ":" + this.value;
    AppMethodBeat.o(143833);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.d
 * JD-Core Version:    0.7.0.1
 */