package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.sql.Timestamp;
import java.util.Date;

class fd$15$1
  extends eb<Timestamp>
{
  fd$15$1(fd.15 param15, eb parameb) {}
  
  public Timestamp a(ff paramff)
  {
    AppMethodBeat.i(147767);
    paramff = (Date)this.a.b(paramff);
    if (paramff != null)
    {
      paramff = new Timestamp(paramff.getTime());
      AppMethodBeat.o(147767);
      return paramff;
    }
    AppMethodBeat.o(147767);
    return null;
  }
  
  public void a(fh paramfh, Timestamp paramTimestamp)
  {
    AppMethodBeat.i(147768);
    this.a.a(paramfh, paramTimestamp);
    AppMethodBeat.o(147768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd.15.1
 * JD-Core Version:    0.7.0.1
 */