package com.tencent.tencentmap.mapsdk.a;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

public final class ft
  extends fz
{
  public final boolean a(byte[] paramArrayOfByte, int paramInt1, boolean paramBoolean, Object paramObject, fz.a parama, int paramInt2)
  {
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
      paramArrayOfByte = fm.a("https://up-hl.3g.qq.com/upreport", false, parama, paramArrayOfByte, 20000, hq.d(), false, null);
      paramArrayOfByte.p = false;
      paramArrayOfByte.a("event");
      paramArrayOfByte = new fu(this, paramArrayOfByte, l);
      try
      {
        fb.a().b().execute(paramArrayOfByte);
        return true;
      }
      catch (Throwable paramArrayOfByte)
      {
        this.b.a(false, this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ft
 * JD-Core Version:    0.7.0.1
 */