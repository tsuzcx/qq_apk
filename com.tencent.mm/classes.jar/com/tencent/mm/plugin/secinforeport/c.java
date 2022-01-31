package com.tencent.mm.plugin.secinforeport;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.w;
import com.tencent.mm.plugin.normsg.Normsg.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.bku;
import com.tencent.mm.protocal.c.bkv;
import java.nio.charset.Charset;

 enum c
  implements com.tencent.mm.plugin.secinforeport.a.c
{
  private c() {}
  
  public final boolean M(int paramInt, long paramLong)
  {
    return c.a.M(paramInt, paramLong);
  }
  
  public final void dI(int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = Normsg.b.vn(paramInt2);
    if (arrayOfByte != null) {
      o(paramInt1, arrayOfByte);
    }
  }
  
  public final void o(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = new b.a();
    ((b.a)localObject).uri = com.tencent.mm.plugin.normsg.a.b.mGK.Kd("");
    ((b.a)localObject).ecG = 771;
    ((b.a)localObject).ecH = new bku();
    ((b.a)localObject).ecI = new bkv();
    localObject = ((b.a)localObject).Kt();
    bku localbku = (bku)((com.tencent.mm.ah.b)localObject).ecE.ecN;
    localbku.tEv = paramInt;
    localbku.tEu = new com.tencent.mm.bv.b(paramArrayOfByte);
    f.nEG.a(416L, 0L, 1L, false);
    w.a((com.tencent.mm.ah.b)localObject, new c.1(this, paramInt), false);
  }
  
  public final void wZ(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<st><Manufacturer>").append(Build.MANUFACTURER).append("</Manufacturer><Model>").append(Build.MODEL).append("</Model><VersionRelease>").append(Build.VERSION.RELEASE).append("</VersionRelease><VersionIncremental>").append(Build.VERSION.INCREMENTAL).append("</VersionIncremental><Display>").append(Build.DISPLAY).append("</Display></st>");
    o(paramInt, localStringBuilder.toString().getBytes(Charset.forName("UTF-8")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.c
 * JD-Core Version:    0.7.0.1
 */