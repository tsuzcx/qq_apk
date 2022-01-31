package com.tencent.mm.plugin.scanner.util;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class b
{
  protected static int quq = 0;
  protected int cpE;
  protected int cpF;
  protected b.a qBY = null;
  protected byte[] qBZ = null;
  public String qCa;
  protected long qCb;
  public boolean[] qCc = null;
  protected byte[] rawData = null;
  protected String typeName;
  
  public b(b.a parama)
  {
    this.qBY = parama;
  }
  
  public final void a(byte[] paramArrayOfByte, Point paramPoint, int paramInt, Rect paramRect)
  {
    ab.d("MicroMsg.scanner.BaseDecoder", "decode task reach");
    d.f(new b.1(this, paramArrayOfByte, paramInt, paramPoint, paramRect), "scan_decode");
  }
  
  public abstract boolean a(byte[] paramArrayOfByte, Point paramPoint, Rect paramRect);
  
  public abstract void pJ();
  
  public abstract void restartDecoder();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.b
 * JD-Core Version:    0.7.0.1
 */