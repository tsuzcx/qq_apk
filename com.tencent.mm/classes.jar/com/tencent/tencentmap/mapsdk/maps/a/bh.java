package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

public final class bh
  extends bn
{
  public final boolean a(byte[] paramArrayOfByte, int paramInt1, boolean paramBoolean, Object paramObject, bn.a parama, int paramInt2)
  {
    AppMethodBeat.i(147290);
    long l = SystemClock.elapsedRealtime();
    this.b = parama;
    this.a = paramObject;
    parama = new HashMap();
    parama.put("B-Length", String.valueOf(paramInt1));
    if (paramInt2 == 1) {
      paramObject = "devlog";
    }
    for (;;)
    {
      parama.put("HLReportCmd", paramObject);
      paramArrayOfByte = bb.a("https://up-hl.3g.qq.com/upreport", false, parama, paramArrayOfByte, 20000, dd.d(), false, null);
      paramArrayOfByte.p = false;
      paramArrayOfByte.a("event");
      paramArrayOfByte = new bi(this, paramArrayOfByte, l);
      try
      {
        aq.a().b().execute(paramArrayOfByte);
        AppMethodBeat.o(147290);
        return true;
      }
      catch (Throwable paramArrayOfByte)
      {
        this.b.a(false, this.a);
        AppMethodBeat.o(147290);
      }
      if (paramBoolean) {
        paramObject = "realtime_speed";
      } else {
        paramObject = "hllog";
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.bh
 * JD-Core Version:    0.7.0.1
 */