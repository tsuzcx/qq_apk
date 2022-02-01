package com.tencent.mm.wear.app.d;

import com.tencent.mm.e.a.k;
import com.tencent.mm.wear.app.b.h;
import java.io.IOException;

public final class a
{
  public static final void ak(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      paramInt2 = 0;
    }
    for (;;)
    {
      k localk = new k();
      localk.Xq = 13195;
      localk.Xv = String.format("%d,%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      try
      {
        m(localk.toByteArray());
        return;
      }
      catch (IOException localIOException) {}
      paramInt2 = 2;
      continue;
      paramInt2 = 3;
      continue;
      paramInt2 = 1;
      continue;
      paramInt2 = 5;
      continue;
      paramInt2 = 4;
      continue;
      paramInt2 = 6;
      continue;
      paramInt2 = 7;
    }
  }
  
  public static final void cg(int paramInt)
  {
    k localk = new k();
    localk.Xq = 13193;
    localk.Xv = String.valueOf(paramInt);
    try
    {
      m(localk.toByteArray());
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public static final void ch(int paramInt)
  {
    ak(paramInt, 0);
  }
  
  public static final void ci(int paramInt)
  {
    k localk = new k();
    localk.Xq = 13194;
    localk.Xv = String.format("%d", new Object[] { Integer.valueOf(paramInt) });
    try
    {
      m(localk.toByteArray());
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public static final void cj(int paramInt)
  {
    k localk = new k();
    localk.Xq = 13196;
    localk.Xv = String.format("%d", new Object[] { Integer.valueOf(paramInt) });
    try
    {
      m(localk.toByteArray());
      return;
    }
    catch (IOException localIOException) {}
  }
  
  private static final void m(byte[] paramArrayOfByte)
  {
    b localb = new b((byte)0);
    localb.data = paramArrayOfByte;
    h.mP().a(localb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.a
 * JD-Core Version:    0.7.0.1
 */