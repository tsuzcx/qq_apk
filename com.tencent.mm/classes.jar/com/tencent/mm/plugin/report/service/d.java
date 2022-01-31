package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class d
{
  public String cqq;
  public boolean qsA;
  public long qsx;
  public long qsy;
  public String qsz;
  public String value;
  
  public d() {}
  
  public d(long paramLong1, String paramString, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(72719);
    this.qsx = paramLong1;
    this.value = paramString;
    this.qsy = paramLong2;
    this.qsA = paramBoolean;
    this.qsz = new SimpleDateFormat("[yy-MM-dd HH:mm:ss:SSS]").format(new Date(paramLong2));
    AppMethodBeat.o(72719);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(72720);
    String str = this.qsz + ":" + this.value;
    AppMethodBeat.o(72720);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.d
 * JD-Core Version:    0.7.0.1
 */