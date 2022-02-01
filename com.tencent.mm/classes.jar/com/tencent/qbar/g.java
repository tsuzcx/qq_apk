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
  private int ZmW;
  
  public g(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(91168);
    this.ZmW = 0;
    this.Zrj = new f();
    AppMethodBeat.o(91168);
  }
  
  public final List<a.a> a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<QbarNative.QBarPoint> paramList, List<WxQbarNative.QBarReportMsg> paramList1)
  {
    AppMethodBeat.i(91169);
    synchronized (this.Brg)
    {
      long l = System.currentTimeMillis();
      paramInt1 = ((f)this.Zrj).d(paramArrayOfByte, paramInt1, paramInt2, true);
      if (paramInt1 < 0)
      {
        Log.e("WxQBarAIDecoder", "scanImage result ".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(91169);
        return null;
      }
      paramArrayOfByte = new ArrayList();
      paramInt1 = ((f)this.Zrj).b(paramArrayOfByte, paramList, paramList1, true);
      this.ZmW = ((f)this.Zrj).ZmW;
      Log.i("WxQBarAIDecoder", String.format("get %d results ,cost %dms", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() - l) }));
      AppMethodBeat.o(91169);
      return paramArrayOfByte;
    }
  }
  
  public final List<a.a> a(int[] paramArrayOfInt, Point paramPoint, PointF paramPointF, List<QbarNative.QBarPoint> paramList, List<WxQbarNative.QBarReportMsg> paramList1, boolean paramBoolean)
  {
    AppMethodBeat.i(193322);
    Log.i("WxQBarAIDecoder", "decodeFile size: %s, useNewInterface: %b", new Object[] { paramPoint, Boolean.valueOf(paramBoolean) });
    long l = System.currentTimeMillis();
    if (paramArrayOfInt.length <= 0)
    {
      Log.w("WxQBarAIDecoder", "prepareGrayData , data is null");
      AppMethodBeat.o(193322);
      return null;
    }
    byte[] arrayOfByte = new byte[paramPoint.x * paramPoint.y];
    int i = d.a(paramArrayOfInt, arrayOfByte, paramPoint.x, paramPoint.y);
    if (i != 0)
    {
      Log.e("WxQBarAIDecoder", "rotate result ".concat(String.valueOf(i)));
      AppMethodBeat.o(193322);
      return null;
    }
    i = ((f)this.Zrj).d(arrayOfByte, paramPoint.x, paramPoint.y, paramBoolean);
    if (i < 0)
    {
      Log.e("WxQBarAIDecoder", "scanImage result ".concat(String.valueOf(i)));
      AppMethodBeat.o(193322);
      return null;
    }
    if (paramPointF != null) {
      ((f)this.Zrj).aN(paramPointF.x, paramPointF.y);
    }
    paramArrayOfInt = new ArrayList();
    Log.i("WxQBarAIDecoder", String.format("get %d results ,cost %dms", new Object[] { Integer.valueOf(((f)this.Zrj).b(paramArrayOfInt, paramList, paramList1, paramBoolean)), Long.valueOf(System.currentTimeMillis() - l) }));
    AppMethodBeat.o(193322);
    return paramArrayOfInt;
  }
  
  public final String iN()
  {
    AppMethodBeat.i(193332);
    synchronized (this.Brg)
    {
      if (this.Zrj != null)
      {
        String str = ((f)this.Zrj).iN() + "wait frame: " + this.ZmW;
        AppMethodBeat.o(193332);
        return str;
      }
      AppMethodBeat.o(193332);
      return "";
    }
  }
  
  public final int inK()
  {
    synchronized (this.Brg)
    {
      int i = this.ZmW;
      return i;
    }
  }
  
  public final void inL()
  {
    AppMethodBeat.i(91170);
    b.a((f)this.Zrj);
    AppMethodBeat.o(91170);
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(193327);
    synchronized (this.Brg)
    {
      if (this.Zrj != null) {
        ((f)this.Zrj).reset(paramBoolean);
      }
      AppMethodBeat.o(193327);
      return;
    }
  }
  
  public final void setBlackInterval(int paramInt)
  {
    AppMethodBeat.i(176208);
    b.a((f)this.Zrj, paramInt);
    AppMethodBeat.o(176208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.g
 * JD-Core Version:    0.7.0.1
 */