package com.tencent.qbar;

import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.scanlib.b.a;
import java.util.ArrayList;
import java.util.List;

public final class g
  extends a
{
  private int RKo;
  
  public g(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(91168);
    this.RKo = 0;
    this.ROD = new f();
    AppMethodBeat.o(91168);
  }
  
  public final List<a.a> a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<QbarNative.QBarPoint> paramList, List<WxQbarNative.QBarReportMsg> paramList1)
  {
    AppMethodBeat.i(91169);
    synchronized (this.CCt)
    {
      long l = System.currentTimeMillis();
      paramInt1 = ((f)this.ROD).d(paramArrayOfByte, paramInt1, paramInt2, true);
      if (paramInt1 < 0)
      {
        Log.e("WxQBarAIDecoder", "scanImage result ".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(91169);
        return null;
      }
      paramArrayOfByte = new ArrayList();
      paramInt1 = ((f)this.ROD).b(paramArrayOfByte, paramList, paramList1, true);
      this.RKo = ((f)this.ROD).RKo;
      Log.i("WxQBarAIDecoder", String.format("get %d results ,cost %dms", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() - l) }));
      AppMethodBeat.o(91169);
      return paramArrayOfByte;
    }
  }
  
  public final List<a.a> a(int[] paramArrayOfInt, Point paramPoint, PointF paramPointF, List<QbarNative.QBarPoint> paramList, List<WxQbarNative.QBarReportMsg> paramList1, boolean paramBoolean)
  {
    AppMethodBeat.i(194831);
    Log.i("WxQBarAIDecoder", "decodeFile size: %s, useNewInterface: %b", new Object[] { paramPoint, Boolean.valueOf(paramBoolean) });
    long l = System.currentTimeMillis();
    if (paramArrayOfInt.length <= 0)
    {
      Log.w("WxQBarAIDecoder", "prepareGrayData , data is null");
      AppMethodBeat.o(194831);
      return null;
    }
    byte[] arrayOfByte = new byte[paramPoint.x * paramPoint.y];
    int i = d.a(paramArrayOfInt, arrayOfByte, paramPoint.x, paramPoint.y);
    if (i != 0)
    {
      Log.e("WxQBarAIDecoder", "rotate result ".concat(String.valueOf(i)));
      AppMethodBeat.o(194831);
      return null;
    }
    i = ((f)this.ROD).d(arrayOfByte, paramPoint.x, paramPoint.y, paramBoolean);
    if (i < 0)
    {
      Log.e("WxQBarAIDecoder", "scanImage result ".concat(String.valueOf(i)));
      AppMethodBeat.o(194831);
      return null;
    }
    if (paramPointF != null) {
      ((f)this.ROD).aG(paramPointF.x, paramPointF.y);
    }
    paramArrayOfInt = new ArrayList();
    Log.i("WxQBarAIDecoder", String.format("get %d results ,cost %dms", new Object[] { Integer.valueOf(((f)this.ROD).b(paramArrayOfInt, paramList, paramList1, paramBoolean)), Long.valueOf(System.currentTimeMillis() - l) }));
    AppMethodBeat.o(194831);
    return paramArrayOfInt;
  }
  
  public final int hkn()
  {
    synchronized (this.CCt)
    {
      int i = this.RKo;
      return i;
    }
  }
  
  public final void hko()
  {
    AppMethodBeat.i(91170);
    b.a((f)this.ROD);
    AppMethodBeat.o(91170);
  }
  
  public final String jS()
  {
    AppMethodBeat.i(194833);
    synchronized (this.CCt)
    {
      if (this.ROD != null)
      {
        String str = ((f)this.ROD).jS() + "wait frame: " + this.RKo;
        AppMethodBeat.o(194833);
        return str;
      }
      AppMethodBeat.o(194833);
      return "";
    }
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(194832);
    synchronized (this.CCt)
    {
      if (this.ROD != null) {
        ((f)this.ROD).reset(paramBoolean);
      }
      AppMethodBeat.o(194832);
      return;
    }
  }
  
  public final void setBlackInterval(int paramInt)
  {
    AppMethodBeat.i(176208);
    b.a((f)this.ROD, paramInt);
    AppMethodBeat.o(176208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.g
 * JD-Core Version:    0.7.0.1
 */