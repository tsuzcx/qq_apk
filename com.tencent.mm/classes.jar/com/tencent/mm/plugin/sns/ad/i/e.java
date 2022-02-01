package com.tencent.mm.plugin.sns.ad.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;

public final class e
{
  public static String XS(int paramInt)
  {
    AppMethodBeat.i(202357);
    if ((paramInt > 9) || (paramInt < 0))
    {
      AppMethodBeat.o(202357);
      return String.valueOf(paramInt);
    }
    String str = "0".concat(String.valueOf(paramInt));
    AppMethodBeat.o(202357);
    return str;
  }
  
  public static a a(long paramLong, a parama)
  {
    AppMethodBeat.i(202356);
    a locala = parama;
    if (parama == null) {
      locala = new a();
    }
    locala.grV = ((int)(paramLong / 86400000L));
    locala.hour = ((int)((paramLong - locala.grV * 86400000L) / 3600000L));
    locala.minute = ((int)((paramLong - locala.grV * 86400000L - locala.hour * 3600000L) / 60000L));
    locala.second = ((int)((paramLong - locala.grV * 86400000L - locala.hour * 3600000L - locala.minute * 60000L) / 1000L));
    AppMethodBeat.o(202356);
    return locala;
  }
  
  public static boolean ap(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(202358);
    long l2 = cl.aWA();
    long l1 = paramLong1;
    if (paramLong1 == 0L) {
      l1 = l2;
    }
    if ((l1 < 0L) || (l1 > l2) || (paramLong2 < l2))
    {
      AppMethodBeat.o(202358);
      return false;
    }
    if ((int)((paramLong2 - l2) / 86400000L) < 100)
    {
      AppMethodBeat.o(202358);
      return true;
    }
    AppMethodBeat.o(202358);
    return false;
  }
  
  public static final class a
  {
    public int grV;
    public int hour;
    public int minute;
    public int second;
    
    public final String toString()
    {
      AppMethodBeat.i(202355);
      String str = "DateTime{day=" + this.grV + ", hour=" + this.hour + ", minute=" + this.minute + ", second=" + this.second + '}' + '@' + hashCode();
      AppMethodBeat.o(202355);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.i.e
 * JD-Core Version:    0.7.0.1
 */