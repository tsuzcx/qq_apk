package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class gl
{
  protected static final Comparator<byte[]> a;
  private List<byte[]> b;
  private List<byte[]> c;
  private int d;
  private final int e;
  
  static
  {
    AppMethodBeat.i(148007);
    a = new gl.1();
    AppMethodBeat.o(148007);
  }
  
  public gl(int paramInt)
  {
    AppMethodBeat.i(148004);
    this.b = new LinkedList();
    this.c = new ArrayList(64);
    this.d = 0;
    this.e = paramInt;
    AppMethodBeat.o(148004);
  }
  
  private void a()
  {
    try
    {
      AppMethodBeat.i(99285);
      while (this.d > this.e)
      {
        byte[] arrayOfByte = (byte[])this.b.remove(0);
        this.c.remove(arrayOfByte);
        this.d -= arrayOfByte.length;
      }
      AppMethodBeat.o(99285);
    }
    finally {}
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 65
    //   4: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnull +12 -> 20
    //   11: aload_1
    //   12: arraylength
    //   13: aload_0
    //   14: getfield 51	com/tencent/tencentmap/mapsdk/maps/a/gl:e	I
    //   17: if_icmple +11 -> 28
    //   20: ldc 65
    //   22: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: getfield 41	com/tencent/tencentmap/mapsdk/maps/a/gl:b	Ljava/util/List;
    //   32: aload_1
    //   33: invokeinterface 68 2 0
    //   38: pop
    //   39: aload_0
    //   40: getfield 47	com/tencent/tencentmap/mapsdk/maps/a/gl:c	Ljava/util/List;
    //   43: aload_1
    //   44: getstatic 30	com/tencent/tencentmap/mapsdk/maps/a/gl:a	Ljava/util/Comparator;
    //   47: invokestatic 74	java/util/Collections:binarySearch	(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;)I
    //   50: istore_3
    //   51: iload_3
    //   52: istore_2
    //   53: iload_3
    //   54: ifge +8 -> 62
    //   57: iload_3
    //   58: ineg
    //   59: iconst_1
    //   60: isub
    //   61: istore_2
    //   62: aload_0
    //   63: getfield 47	com/tencent/tencentmap/mapsdk/maps/a/gl:c	Ljava/util/List;
    //   66: iload_2
    //   67: aload_1
    //   68: invokeinterface 77 3 0
    //   73: aload_0
    //   74: aload_0
    //   75: getfield 49	com/tencent/tencentmap/mapsdk/maps/a/gl:d	I
    //   78: aload_1
    //   79: arraylength
    //   80: iadd
    //   81: putfield 49	com/tencent/tencentmap/mapsdk/maps/a/gl:d	I
    //   84: aload_0
    //   85: invokespecial 79	com/tencent/tencentmap/mapsdk/maps/a/gl:a	()V
    //   88: ldc 65
    //   90: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: goto -68 -> 25
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	gl
    //   0	101	1	paramArrayOfByte	byte[]
    //   52	15	2	i	int
    //   50	8	3	j	int
    // Exception table:
    //   from	to	target	type
    //   2	7	96	finally
    //   11	20	96	finally
    //   20	25	96	finally
    //   28	51	96	finally
    //   62	93	96	finally
  }
  
  /* Error */
  public byte[] a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 81
    //   4: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iconst_0
    //   8: istore_2
    //   9: iload_2
    //   10: aload_0
    //   11: getfield 47	com/tencent/tencentmap/mapsdk/maps/a/gl:c	Ljava/util/List;
    //   14: invokeinterface 85 1 0
    //   19: if_icmpge +72 -> 91
    //   22: aload_0
    //   23: getfield 47	com/tencent/tencentmap/mapsdk/maps/a/gl:c	Ljava/util/List;
    //   26: iload_2
    //   27: invokeinterface 88 2 0
    //   32: checkcast 60	[B
    //   35: astore_3
    //   36: aload_3
    //   37: arraylength
    //   38: iload_1
    //   39: if_icmplt +45 -> 84
    //   42: aload_0
    //   43: aload_0
    //   44: getfield 49	com/tencent/tencentmap/mapsdk/maps/a/gl:d	I
    //   47: aload_3
    //   48: arraylength
    //   49: isub
    //   50: putfield 49	com/tencent/tencentmap/mapsdk/maps/a/gl:d	I
    //   53: aload_0
    //   54: getfield 47	com/tencent/tencentmap/mapsdk/maps/a/gl:c	Ljava/util/List;
    //   57: iload_2
    //   58: invokeinterface 58 2 0
    //   63: pop
    //   64: aload_0
    //   65: getfield 41	com/tencent/tencentmap/mapsdk/maps/a/gl:b	Ljava/util/List;
    //   68: aload_3
    //   69: invokeinterface 63 2 0
    //   74: pop
    //   75: ldc 81
    //   77: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_3
    //   83: areturn
    //   84: iload_2
    //   85: iconst_1
    //   86: iadd
    //   87: istore_2
    //   88: goto -79 -> 9
    //   91: iload_1
    //   92: newarray byte
    //   94: astore_3
    //   95: ldc 81
    //   97: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: goto -20 -> 80
    //   103: astore_3
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_3
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	gl
    //   0	108	1	paramInt	int
    //   8	80	2	i	int
    //   35	60	3	arrayOfByte	byte[]
    //   103	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	103	finally
    //   9	80	103	finally
    //   91	100	103	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.gl
 * JD-Core Version:    0.7.0.1
 */