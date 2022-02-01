package com.tencent.mm.plugin.sns.ad.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;

public final class f
{
  public static a a(long paramLong, a parama)
  {
    AppMethodBeat.i(309698);
    a locala = parama;
    if (parama == null) {
      locala = new a();
    }
    locala.day = ((int)(paramLong / 86400000L));
    locala.hour = ((int)((paramLong - locala.day * 86400000L) / 3600000L));
    locala.Qdm = ((int)((paramLong - locala.day * 86400000L - locala.hour * 3600000L) / 60000L));
    locala.second = ((int)((paramLong - locala.day * 86400000L - locala.hour * 3600000L - locala.Qdm * 60000L) / 1000L));
    AppMethodBeat.o(309698);
    return locala;
  }
  
  public static String ajP(int paramInt)
  {
    AppMethodBeat.i(309706);
    if ((paramInt > 9) || (paramInt < 0))
    {
      AppMethodBeat.o(309706);
      return String.valueOf(paramInt);
    }
    String str = "0".concat(String.valueOf(paramInt));
    AppMethodBeat.o(309706);
    return str;
  }
  
  public static boolean bk(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(309711);
    long l2 = cn.bDw();
    long l1 = paramLong1;
    if (paramLong1 == 0L) {
      l1 = l2;
    }
    if ((l1 < 0L) || (l1 > l2) || (paramLong2 < l2))
    {
      AppMethodBeat.o(309711);
      return false;
    }
    if ((int)((paramLong2 - l2) / 86400000L) < 100)
    {
      AppMethodBeat.o(309711);
      return true;
    }
    AppMethodBeat.o(309711);
    return false;
  }
  
  public static class a
  {
    public int Qdm;
    public int day;
    public int hour;
    public int second;
    
    public String toString()
    {
      AppMethodBeat.i(309827);
      String str = "DateTime{day=" + this.day + ", hour=" + this.hour + ", minute=" + this.Qdm + ", second=" + this.second + '}' + '@' + hashCode();
      AppMethodBeat.o(309827);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.j.f
 * JD-Core Version:    0.7.0.1
 */