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
  private int LKO;
  
  public g(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(91168);
    this.LKO = 0;
    this.LPj = new f();
    AppMethodBeat.o(91168);
  }
  
  public final List<a.a> a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<QbarNative.QBarPoint> paramList, List<WxQbarNative.QBarReportMsg> paramList1)
  {
    AppMethodBeat.i(91169);
    synchronized (this.ylo)
    {
      long l = System.currentTimeMillis();
      paramInt1 = ((f)this.LPj).c(paramArrayOfByte, paramInt1, paramInt2, true);
      if (paramInt1 < 0)
      {
        ad.e("WxQBarAIDecoder", "scanImage result ".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(91169);
        return null;
      }
      paramArrayOfByte = new ArrayList();
      paramInt1 = ((f)this.LPj).b(paramArrayOfByte, paramList, paramList1, true);
      this.LKO = ((f)this.LPj).LKO;
      ad.i("WxQBarAIDecoder", String.format("get %d results ,cost %dms", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() - l) }));
      AppMethodBeat.o(91169);
      return paramArrayOfByte;
    }
  }
  
  public final List<a.a> a(int[] paramArrayOfInt, Point paramPoint1, Point paramPoint2, List<QbarNative.QBarPoint> paramList, List<WxQbarNative.QBarReportMsg> paramList1, boolean paramBoolean)
  {
    AppMethodBeat.i(218756);
    ad.i("WxQBarAIDecoder", "decodeFile size: %s, useNewInterface: %b", new Object[] { paramPoint1, Boolean.valueOf(paramBoolean) });
    long l = System.currentTimeMillis();
    if (paramArrayOfInt.length <= 0)
    {
      ad.w("WxQBarAIDecoder", "prepareGrayData , data is null");
      AppMethodBeat.o(218756);
      return null;
    }
    byte[] arrayOfByte = new byte[paramPoint1.x * paramPoint1.y];
    int i = d.a(paramArrayOfInt, arrayOfByte, paramPoint1.x, paramPoint1.y);
    if (i != 0)
    {
      ad.e("WxQBarAIDecoder", "rotate result ".concat(String.valueOf(i)));
      AppMethodBeat.o(218756);
      return null;
    }
    i = ((f)this.LPj).c(arrayOfByte, paramPoint1.x, paramPoint1.y, paramBoolean);
    if (i < 0)
    {
      ad.e("WxQBarAIDecoder", "scanImage result ".concat(String.valueOf(i)));
      AppMethodBeat.o(218756);
      return null;
    }
    if (paramPoint2 != null) {
      ((f)this.LPj).X(paramPoint2.x, paramPoint2.y, com.tencent.mm.cc.a.ip(aj.getContext()), com.tencent.mm.cc.a.iq(aj.getContext()));
    }
    paramArrayOfInt = new ArrayList();
    ad.i("WxQBarAIDecoder", String.format("get %d results ,cost %dms", new Object[] { Integer.valueOf(((f)this.LPj).b(paramArrayOfInt, paramList, paramList1, paramBoolean)), Long.valueOf(System.currentTimeMillis() - l) }));
    AppMethodBeat.o(218756);
    return paramArrayOfInt;
  }
  
  public final int fTB()
  {
    synchronized (this.ylo)
    {
      int i = this.LKO;
      return i;
    }
  }
  
  public final void fTC()
  {
    AppMethodBeat.i(91170);
    b.a((f)this.LPj);
    AppMethodBeat.o(91170);
  }
  
  public final String jJ()
  {
    AppMethodBeat.i(218758);
    synchronized (this.ylo)
    {
      if (this.LPj != null)
      {
        String str = ((f)this.LPj).jJ() + "wait frame: " + this.LKO;
        AppMethodBeat.o(218758);
        return str;
      }
      AppMethodBeat.o(218758);
      return "";
    }
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(218757);
    synchronized (this.ylo)
    {
      if (this.LPj != null) {
        ((f)this.LPj).reset(paramBoolean);
      }
      AppMethodBeat.o(218757);
      return;
    }
  }
  
  public final void setBlackInterval(int paramInt)
  {
    AppMethodBeat.i(176208);
    b.a((f)this.LPj, paramInt);
    AppMethodBeat.o(176208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qbar.g
 * JD-Core Version:    0.7.0.1
 */