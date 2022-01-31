package com.tencent.mm.plugin.scanner.util;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qbar.QbarNative;

public abstract class b
{
  protected static int nOq = 0;
  protected int bIj;
  protected int bIk;
  protected b.a nOn = null;
  protected byte[] nOo = null;
  public String nOp;
  protected long nOr;
  public boolean[] nOs = null;
  protected byte[] rawData = null;
  
  public b(b.a parama)
  {
    this.nOn = parama;
  }
  
  public final void a(final byte[] paramArrayOfByte, final Point paramPoint, final int paramInt, final Rect paramRect)
  {
    y.d("MicroMsg.scanner.BaseDecoder", "decode task reach");
    e.a(new Runnable()
    {
      public final void run()
      {
        byte[] arrayOfByte1 = paramArrayOfByte;
        if (270 == paramInt)
        {
          byte[] arrayOfByte2 = new byte[paramArrayOfByte.length];
          QbarNative.a(arrayOfByte2, paramArrayOfByte, paramPoint.x, paramPoint.y);
          arrayOfByte1 = new byte[paramArrayOfByte.length];
          QbarNative.a(arrayOfByte1, arrayOfByte2, paramPoint.y, paramPoint.x);
          QbarNative.nativeRelease();
        }
        y.d("MicroMsg.scanner.BaseDecoder", "asyncDecode() resolution:%s, coverage:%s", new Object[] { paramPoint.toString(), paramRect.toString() });
        if ((arrayOfByte1 != null) && (b.this.a(arrayOfByte1, paramPoint, paramRect)))
        {
          ai.d(new Runnable()
          {
            public final void run()
            {
              if (b.this.nOn != null) {
                b.this.nOn.b(b.nOq, b.this.nOp, b.this.rawData, b.this.nOo, b.this.bIj, b.this.bIk);
              }
            }
          });
          return;
        }
        ai.d(new Runnable()
        {
          public final void run()
          {
            if (b.this.nOn != null)
            {
              y.d("MicroMsg.scanner.BaseDecoder", "failed in asyncDecode() resolution:%s, coverage:%s", new Object[] { b.1.this.nMA.toString(), b.1.this.nMB.toString() });
              b.this.nOn.fB(b.this.nOr);
            }
          }
        });
      }
    }, "scan_decode", 10);
  }
  
  public abstract boolean a(byte[] paramArrayOfByte, Point paramPoint, Rect paramRect);
  
  public abstract void byg();
  
  public abstract void nm();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.b
 * JD-Core Version:    0.7.0.1
 */