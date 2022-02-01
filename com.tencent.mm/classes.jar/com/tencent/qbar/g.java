package com.tencent.qbar;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;
import java.util.List;

public final class g
  extends com.tencent.scanlib.b.a
{
  private int Ipn;
  
  public g(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(91168);
    this.Ipn = 0;
    this.ItF = new f();
    AppMethodBeat.o(91168);
  }
  
  public final List<a.a> a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<QbarNative.QBarPoint> paramList, List<WxQbarNative.QBarReportMsg> paramList1)
  {
    AppMethodBeat.i(91169);
    synchronized (this.vNi)
    {
      long l = System.currentTimeMillis();
      paramInt1 = ((f)this.ItF).c(paramArrayOfByte, paramInt1, paramInt2, false);
      if (paramInt1 < 0)
      {
        ad.e("WxQBarAIDecoder", "scanImage result ".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(91169);
        return null;
      }
      paramArrayOfByte = new ArrayList();
      paramInt1 = ((f)this.ItF).b(paramArrayOfByte, paramList, paramList1, false);
      this.Ipn = ((f)this.ItF).Ipn;
      ad.i("WxQBarAIDecoder", String.format("get %d results ,cost %dms", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() - l) }));
      AppMethodBeat.o(91169);
      return paramArrayOfByte;
    }
  }
  
  public final List<a.a> a(int[] paramArrayOfInt, Point paramPoint1, Point paramPoint2, List<WxQbarNative.QBarReportMsg> paramList)
  {
    AppMethodBeat.i(91171);
    ad.i("WxQBarAIDecoder", String.format("decode, size %s", new Object[] { paramPoint1.toString() }));
    long l = System.currentTimeMillis();
    if (paramArrayOfInt.length <= 0)
    {
      ad.w("WxQBarAIDecoder", "prepareGrayData , data is null");
      AppMethodBeat.o(91171);
      return null;
    }
    byte[] arrayOfByte = new byte[paramPoint1.x * paramPoint1.y];
    int i = d.a(paramArrayOfInt, arrayOfByte, paramPoint1.x, paramPoint1.y);
    if (i != 0)
    {
      ad.e("WxQBarAIDecoder", "rotate result ".concat(String.valueOf(i)));
      AppMethodBeat.o(91171);
      return null;
    }
    i = ((f)this.ItF).c(arrayOfByte, paramPoint1.x, paramPoint1.y, true);
    if (i < 0)
    {
      ad.e("WxQBarAIDecoder", "scanImage result ".concat(String.valueOf(i)));
      AppMethodBeat.o(91171);
      return null;
    }
    if (paramPoint2 != null) {
      ((f)this.ItF).U(paramPoint2.x, paramPoint2.y, com.tencent.mm.cd.a.hV(aj.getContext()), com.tencent.mm.cd.a.hW(aj.getContext()));
    }
    paramArrayOfInt = new ArrayList();
    ad.i("WxQBarAIDecoder", String.format("get %d results ,cost %dms", new Object[] { Integer.valueOf(((f)this.ItF).b(paramArrayOfInt, null, paramList, true)), Long.valueOf(System.currentTimeMillis() - l) }));
    AppMethodBeat.o(91171);
    return paramArrayOfInt;
  }
  
  public final int flU()
  {
    synchronized (this.vNi)
    {
      int i = this.Ipn;
      return i;
    }
  }
  
  public final void flV()
  {
    AppMethodBeat.i(91170);
    b.a((f)this.ItF);
    AppMethodBeat.o(91170);
  }
  
  public final String jl()
  {
    AppMethodBeat.i(190145);
    synchronized (this.vNi)
    {
      if (this.ItF != null)
      {
        String str = ((f)this.ItF).jl() + "wait frame: " + this.Ipn;
        AppMethodBeat.o(190145);
        return str;
      }
      AppMethodBeat.o(190145);
      return "";
    }
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(190144);
    synchronized (this.vNi)
    {
      if (this.ItF != null) {
        ((f)this.ItF).reset(paramBoolean);
      }
      AppMethodBeat.o(190144);
      return;
    }
  }
  
  public final void setBlackInterval(int paramInt)
  {
    AppMethodBeat.i(176208);
    b.a((f)this.ItF, paramInt);
    AppMethodBeat.o(176208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.g
 * JD-Core Version:    0.7.0.1
 */