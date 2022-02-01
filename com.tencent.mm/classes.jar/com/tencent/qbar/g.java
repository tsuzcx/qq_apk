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
  private int ahrt;
  
  public g(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(91168);
    this.ahrt = 0;
    this.ahvY = new f();
    AppMethodBeat.o(91168);
  }
  
  public final String GR()
  {
    AppMethodBeat.i(226841);
    synchronized (this.GXz)
    {
      if (this.ahvY != null)
      {
        String str = ((f)this.ahvY).GR() + "wait frame: " + this.ahrt;
        AppMethodBeat.o(226841);
        return str;
      }
      AppMethodBeat.o(226841);
      return "";
    }
  }
  
  public final void Oq(boolean paramBoolean)
  {
    AppMethodBeat.i(226833);
    f localf = (f)this.ahvY;
    Log.i("MicroMsg.WxQBar", "setEnableMultiCode: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    localf.OXQ = paramBoolean;
    AppMethodBeat.o(226833);
  }
  
  public final List<a.a> a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<QbarNative.QBarPoint> paramList, List<WxQbarNative.QBarReportMsg> paramList1)
  {
    AppMethodBeat.i(91169);
    synchronized (this.GXz)
    {
      long l = System.currentTimeMillis();
      paramInt1 = ((f)this.ahvY).d(paramArrayOfByte, paramInt1, paramInt2, true);
      if (paramInt1 < 0)
      {
        Log.e("WxQBarAIDecoder", "scanImage result ".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(91169);
        return null;
      }
      paramArrayOfByte = new ArrayList();
      paramInt1 = ((f)this.ahvY).b(paramArrayOfByte, paramList, paramList1, true);
      this.ahrt = ((f)this.ahvY).ahrt;
      Log.i("WxQBarAIDecoder", String.format("get %d results ,cost %dms", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() - l) }));
      AppMethodBeat.o(91169);
      return paramArrayOfByte;
    }
  }
  
  public final List<a.a> a(int[] paramArrayOfInt, Point paramPoint, PointF paramPointF, List<QbarNative.QBarPoint> paramList, List<WxQbarNative.QBarReportMsg> paramList1, boolean paramBoolean)
  {
    AppMethodBeat.i(226838);
    Log.i("WxQBarAIDecoder", "decodeFile size: %s, useNewInterface: %b", new Object[] { paramPoint, Boolean.valueOf(paramBoolean) });
    long l = System.currentTimeMillis();
    if (paramArrayOfInt.length <= 0)
    {
      Log.w("WxQBarAIDecoder", "prepareGrayData , data is null");
      AppMethodBeat.o(226838);
      return null;
    }
    byte[] arrayOfByte = new byte[paramPoint.x * paramPoint.y];
    int i = d.a(paramArrayOfInt, arrayOfByte, paramPoint.x, paramPoint.y);
    if (i != 0)
    {
      Log.e("WxQBarAIDecoder", "rotate result ".concat(String.valueOf(i)));
      AppMethodBeat.o(226838);
      return null;
    }
    i = ((f)this.ahvY).d(arrayOfByte, paramPoint.x, paramPoint.y, paramBoolean);
    if (i < 0)
    {
      Log.e("WxQBarAIDecoder", "scanImage result ".concat(String.valueOf(i)));
      AppMethodBeat.o(226838);
      return null;
    }
    if (paramPointF != null) {
      ((f)this.ahvY).bs(paramPointF.x, paramPointF.y);
    }
    paramArrayOfInt = new ArrayList();
    Log.i("WxQBarAIDecoder", String.format("get %d results ,cost %dms", new Object[] { Integer.valueOf(((f)this.ahvY).b(paramArrayOfInt, paramList, paramList1, paramBoolean)), Long.valueOf(System.currentTimeMillis() - l) }));
    AppMethodBeat.o(226838);
    return paramArrayOfInt;
  }
  
  public final int jWT()
  {
    synchronized (this.GXz)
    {
      int i = this.ahrt;
      return i;
    }
  }
  
  public final void jWU()
  {
    AppMethodBeat.i(91170);
    b.a((f)this.ahvY);
    AppMethodBeat.o(91170);
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(226840);
    synchronized (this.GXz)
    {
      if (this.ahvY != null) {
        ((f)this.ahvY).reset(paramBoolean);
      }
      AppMethodBeat.o(226840);
      return;
    }
  }
  
  public final void setBlackInterval(int paramInt)
  {
    AppMethodBeat.i(176208);
    b.a((f)this.ahvY, paramInt);
    AppMethodBeat.o(176208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qbar.g
 * JD-Core Version:    0.7.0.1
 */