package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class jl
{
  public final Rect a;
  public int[] b;
  public int[] c;
  public int[] d;
  
  public jl()
  {
    AppMethodBeat.i(148708);
    this.a = new Rect();
    AppMethodBeat.o(148708);
  }
  
  public static jl a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148711);
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.nativeOrder());
    if (paramArrayOfByte.get() == 0)
    {
      AppMethodBeat.o(148711);
      return null;
    }
    jl localjl = new jl();
    localjl.b = new int[paramArrayOfByte.get()];
    localjl.c = new int[paramArrayOfByte.get()];
    localjl.d = new int[paramArrayOfByte.get()];
    a(localjl.b.length);
    a(localjl.c.length);
    paramArrayOfByte.getInt();
    paramArrayOfByte.getInt();
    localjl.a.left = paramArrayOfByte.getInt();
    localjl.a.right = paramArrayOfByte.getInt();
    localjl.a.top = paramArrayOfByte.getInt();
    localjl.a.bottom = paramArrayOfByte.getInt();
    paramArrayOfByte.getInt();
    a(localjl.b, paramArrayOfByte);
    a(localjl.c, paramArrayOfByte);
    a(localjl.d, paramArrayOfByte);
    AppMethodBeat.o(148711);
    return localjl;
  }
  
  private static void a(int paramInt)
  {
    AppMethodBeat.i(148710);
    if ((paramInt == 0) || ((paramInt & 0x1) != 0))
    {
      RuntimeException localRuntimeException = new RuntimeException("invalid nine-patch: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(148710);
      throw localRuntimeException;
    }
    AppMethodBeat.o(148710);
  }
  
  private static void a(int[] paramArrayOfInt, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(148709);
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      paramArrayOfInt[i] = paramByteBuffer.getInt();
      i += 1;
    }
    AppMethodBeat.o(148709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jl
 * JD-Core Version:    0.7.0.1
 */