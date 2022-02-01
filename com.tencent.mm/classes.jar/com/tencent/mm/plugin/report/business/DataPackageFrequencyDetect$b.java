package com.tencent.mm.plugin.report.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$DataPackageInfo;", "", "time", "", "req", "", "type", "", "cgi", "", "length", "(JZILjava/lang/String;J)V", "getCgi", "()Ljava/lang/String;", "getLength", "()J", "getReq", "()Z", "getTime", "getType", "()I", "toString", "plugin-report_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DataPackageFrequencyDetect$b
{
  final boolean Ozi;
  final String cgi;
  private final long length;
  private final long time;
  final int type;
  
  public DataPackageFrequencyDetect$b(long paramLong1, boolean paramBoolean, int paramInt, String paramString, long paramLong2)
  {
    AppMethodBeat.i(261684);
    this.time = paramLong1;
    this.Ozi = paramBoolean;
    this.type = paramInt;
    this.cgi = paramString;
    this.length = paramLong2;
    AppMethodBeat.o(261684);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(261688);
    StringBuilder localStringBuilder = new StringBuilder("DataPackageInfo(time=");
    Object localObject = DataPackageFrequencyDetect.Ozf;
    String str = DataPackageFrequencyDetect.iO(this.time);
    localObject = str;
    if (str == null) {
      localObject = Long.valueOf(this.time);
    }
    localObject = localObject + ", req=" + this.Ozi + ", type=" + this.type + ", cgi='" + this.cgi + "', length=" + this.length + ')';
    AppMethodBeat.o(261688);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.business.DataPackageFrequencyDetect.b
 * JD-Core Version:    0.7.0.1
 */