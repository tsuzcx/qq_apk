package com.tencent.qbar;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.ArrayList;
import java.util.List;

public final class g
  extends com.tencent.scanlib.b.a
{
  private int JQX;
  
  public g(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(91168);
    this.JQX = 0;
    this.JVo = new f();
    AppMethodBeat.o(91168);
  }
  
  public final List<a.a> a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<QbarNative.QBarPoint> paramList, List<WxQbarNative.QBarReportMsg> paramList1)
  {
    AppMethodBeat.i(91169);
    synchronized (this.wXD)
    {
      long l = System.currentTimeMillis();
      paramInt1 = ((f)this.JVo).c(paramArrayOfByte, paramInt1, paramInt2, false);
      if (paramInt1 < 0)
      {
        ac.e("WxQBarAIDecoder", "scanImage result ".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(91169);
        return null;
      }
      paramArrayOfByte = new ArrayList();
      paramInt1 = ((f)this.JVo).b(paramArrayOfByte, paramList, paramList1, false);
      this.JQX = ((f)this.JVo).JQX;
      ac.i("WxQBarAIDecoder", String.format("get %d results ,cost %dms", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() - l) }));
      AppMethodBeat.o(91169);
      return paramArrayOfByte;
    }
  }
  
  public final List<a.a> a(int[] paramArrayOfInt, Point paramPoint1, Point paramPoint2, List<WxQbarNative.QBarReportMsg> paramList)
  {
    AppMethodBeat.i(91171);
    ac.i("WxQBarAIDecoder", String.format("decode, size %s", new Object[] { paramPoint1.toString() }));
    long l = System.currentTimeMillis();
    if (paramArrayOfInt.length <= 0)
    {
      ac.w("WxQBarAIDecoder", "prepareGrayData , data is null");
      AppMethodBeat.o(91171);
      return null;
    }
    byte[] arrayOfByte = new byte[paramPoint1.x * paramPoint1.y];
    int i = d.a(paramArrayOfInt, arrayOfByte, paramPoint1.x, paramPoint1.y);
    if (i != 0)
    {
      ac.e("WxQBarAIDecoder", "rotate result ".concat(String.valueOf(i)));
      AppMethodBeat.o(91171);
      return null;
    }
    i = ((f)this.JVo).c(arrayOfByte, paramPoint1.x, paramPoint1.y, true);
    if (i < 0)
    {
      ac.e("WxQBarAIDecoder", "scanImage result ".concat(String.valueOf(i)));
      AppMethodBeat.o(91171);
      return null;
    }
    if (paramPoint2 != null) {
      ((f)this.JVo).W(paramPoint2.x, paramPoint2.y, com.tencent.mm.cc.a.ig(ai.getContext()), com.tencent.mm.cc.a.ih(ai.getContext()));
    }
    paramArrayOfInt = new ArrayList();
    ac.i("WxQBarAIDecoder", String.format("get %d results ,cost %dms", new Object[] { Integer.valueOf(((f)this.JVo).b(paramArrayOfInt, null, paramList, true)), Long.valueOf(System.currentTimeMillis() - l) }));
    AppMethodBeat.o(91171);
    return paramArrayOfInt;
  }
  
  public final int fCl()
  {
    synchronized (this.wXD)
    {
      int i = this.JQX;
      return i;
    }
  }
  
  public final void fCm()
  {
    AppMethodBeat.i(91170);
    b.a((f)this.JVo);
    AppMethodBeat.o(91170);
  }
  
  public final String jt()
  {
    AppMethodBeat.i(204948);
    synchronized (this.wXD)
    {
      if (this.JVo != null)
      {
        String str = ((f)this.JVo).jt() + "wait frame: " + this.JQX;
        AppMethodBeat.o(204948);
        return str;
      }
      AppMethodBeat.o(204948);
      return "";
    }
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(204947);
    synchronized (this.wXD)
    {
      if (this.JVo != null) {
        ((f)this.JVo).reset(paramBoolean);
      }
      AppMethodBeat.o(204947);
      return;
    }
  }
  
  public final void setBlackInterval(int paramInt)
  {
    AppMethodBeat.i(176208);
    b.a((f)this.JVo, paramInt);
    AppMethodBeat.o(176208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.g
 * JD-Core Version:    0.7.0.1
 */