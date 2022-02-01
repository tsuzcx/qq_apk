package com.tencent.qbar;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.List;

public final class g
  extends com.tencent.scanlib.b.a
{
  private int MhN;
  
  public g(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(91168);
    this.MhN = 0;
    this.Mmg = new f();
    AppMethodBeat.o(91168);
  }
  
  public final List<a.a> a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<QbarNative.QBarPoint> paramList, List<WxQbarNative.QBarReportMsg> paramList1)
  {
    AppMethodBeat.i(91169);
    synchronized (this.yBn)
    {
      long l = System.currentTimeMillis();
      paramInt1 = ((f)this.Mmg).c(paramArrayOfByte, paramInt1, paramInt2, true);
      if (paramInt1 < 0)
      {
        ae.e("WxQBarAIDecoder", "scanImage result ".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(91169);
        return null;
      }
      paramArrayOfByte = new ArrayList();
      paramInt1 = ((f)this.Mmg).b(paramArrayOfByte, paramList, paramList1, true);
      this.MhN = ((f)this.Mmg).MhN;
      ae.i("WxQBarAIDecoder", String.format("get %d results ,cost %dms", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() - l) }));
      AppMethodBeat.o(91169);
      return paramArrayOfByte;
    }
  }
  
  public final List<a.a> a(int[] paramArrayOfInt, Point paramPoint1, Point paramPoint2, List<QbarNative.QBarPoint> paramList, List<WxQbarNative.QBarReportMsg> paramList1, boolean paramBoolean)
  {
    AppMethodBeat.i(196692);
    ae.i("WxQBarAIDecoder", "decodeFile size: %s, useNewInterface: %b", new Object[] { paramPoint1, Boolean.valueOf(paramBoolean) });
    long l = System.currentTimeMillis();
    if (paramArrayOfInt.length <= 0)
    {
      ae.w("WxQBarAIDecoder", "prepareGrayData , data is null");
      AppMethodBeat.o(196692);
      return null;
    }
    byte[] arrayOfByte = new byte[paramPoint1.x * paramPoint1.y];
    int i = d.a(paramArrayOfInt, arrayOfByte, paramPoint1.x, paramPoint1.y);
    if (i != 0)
    {
      ae.e("WxQBarAIDecoder", "rotate result ".concat(String.valueOf(i)));
      AppMethodBeat.o(196692);
      return null;
    }
    i = ((f)this.Mmg).c(arrayOfByte, paramPoint1.x, paramPoint1.y, paramBoolean);
    if (i < 0)
    {
      ae.e("WxQBarAIDecoder", "scanImage result ".concat(String.valueOf(i)));
      AppMethodBeat.o(196692);
      return null;
    }
    if (paramPoint2 != null) {
      ((f)this.Mmg).X(paramPoint2.x, paramPoint2.y, com.tencent.mm.cb.a.iu(ak.getContext()), com.tencent.mm.cb.a.iv(ak.getContext()));
    }
    paramArrayOfInt = new ArrayList();
    ae.i("WxQBarAIDecoder", String.format("get %d results ,cost %dms", new Object[] { Integer.valueOf(((f)this.Mmg).b(paramArrayOfInt, paramList, paramList1, paramBoolean)), Long.valueOf(System.currentTimeMillis() - l) }));
    AppMethodBeat.o(196692);
    return paramArrayOfInt;
  }
  
  public final int fYb()
  {
    synchronized (this.yBn)
    {
      int i = this.MhN;
      return i;
    }
  }
  
  public final void fYc()
  {
    AppMethodBeat.i(91170);
    b.a((f)this.Mmg);
    AppMethodBeat.o(91170);
  }
  
  public final String jJ()
  {
    AppMethodBeat.i(196694);
    synchronized (this.yBn)
    {
      if (this.Mmg != null)
      {
        String str = ((f)this.Mmg).jJ() + "wait frame: " + this.MhN;
        AppMethodBeat.o(196694);
        return str;
      }
      AppMethodBeat.o(196694);
      return "";
    }
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(196693);
    synchronized (this.yBn)
    {
      if (this.Mmg != null) {
        ((f)this.Mmg).reset(paramBoolean);
      }
      AppMethodBeat.o(196693);
      return;
    }
  }
  
  public final void setBlackInterval(int paramInt)
  {
    AppMethodBeat.i(176208);
    b.a((f)this.Mmg, paramInt);
    AppMethodBeat.o(176208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qbar.g
 * JD-Core Version:    0.7.0.1
 */