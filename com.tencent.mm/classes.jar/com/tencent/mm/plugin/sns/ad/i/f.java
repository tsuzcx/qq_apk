package com.tencent.mm.plugin.sns.ad.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;

public final class f
{
  public static a a(long paramLong, a parama)
  {
    AppMethodBeat.i(214021);
    a locala = parama;
    if (parama == null) {
      locala = new a();
    }
    locala.day = ((int)(paramLong / 86400000L));
    locala.hour = ((int)((paramLong - locala.day * 86400000L) / 3600000L));
    locala.JLz = ((int)((paramLong - locala.day * 86400000L - locala.hour * 3600000L) / 60000L));
    locala.second = ((int)((paramLong - locala.day * 86400000L - locala.hour * 3600000L - locala.JLz * 60000L) / 1000L));
    AppMethodBeat.o(214021);
    return locala;
  }
  
  public static boolean aA(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(214023);
    long l2 = cm.bfE();
    long l1 = paramLong1;
    if (paramLong1 == 0L) {
      l1 = l2;
    }
    if ((l1 < 0L) || (l1 > l2) || (paramLong2 < l2))
    {
      AppMethodBeat.o(214023);
      return false;
    }
    if ((int)((paramLong2 - l2) / 86400000L) < 100)
    {
      AppMethodBeat.o(214023);
      return true;
    }
    AppMethodBeat.o(214023);
    return false;
  }
  
  public static String afg(int paramInt)
  {
    AppMethodBeat.i(214022);
    if ((paramInt > 9) || (paramInt < 0))
    {
      AppMethodBeat.o(214022);
      return String.valueOf(paramInt);
    }
    String str = "0".concat(String.valueOf(paramInt));
    AppMethodBeat.o(214022);
    return str;
  }
  
  public static class a
  {
    public int JLz;
    public int day;
    public int hour;
    public int second;
    
    public String toString()
    {
      AppMethodBeat.i(244096);
      String str = "DateTime{day=" + this.day + ", hour=" + this.hour + ", minute=" + this.JLz + ", second=" + this.second + '}' + '@' + hashCode();
      AppMethodBeat.o(244096);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.i.f
 * JD-Core Version:    0.7.0.1
 */