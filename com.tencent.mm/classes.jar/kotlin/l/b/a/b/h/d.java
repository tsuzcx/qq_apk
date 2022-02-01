package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class d
  implements Iterable<Byte>
{
  public static final d ajeU;
  
  static
  {
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ajeU = new q(new byte[0]);
      return;
    }
  }
  
  public static d G(Iterable<d> paramIterable)
  {
    ArrayList localArrayList;
    if (!(paramIterable instanceof Collection))
    {
      localArrayList = new ArrayList();
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        localArrayList.add((d)paramIterable.next());
      }
    }
    for (paramIterable = localArrayList; paramIterable.isEmpty(); paramIterable = (Collection)paramIterable) {
      return ajeU;
    }
    return a(paramIterable.iterator(), paramIterable.size());
  }
  
  public static d V(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new q(arrayOfByte);
  }
  
  private static d a(Iterator<d> paramIterator, int paramInt)
  {
    assert (paramInt > 0);
    if (paramInt == 1) {
      return (d)paramIterator.next();
    }
    int i = paramInt >>> 1;
    return a(paramIterator, i).a(a(paramIterator, paramInt - i));
  }
  
  public static d bJj(String paramString)
  {
    try
    {
      paramString = new q(paramString.getBytes("UTF-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported?", paramString);
    }
  }
  
  public static d dJ(byte[] paramArrayOfByte)
  {
    return V(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static b kya()
  {
    return new b();
  }
  
  protected abstract int Q(int paramInt1, int paramInt2, int paramInt3);
  
  protected abstract int R(int paramInt1, int paramInt2, int paramInt3);
  
  public final String ZV()
  {
    try
    {
      String str = toString("UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 not supported?", localUnsupportedEncodingException);
    }
  }
  
  public abstract boolean ZW();
  
  protected abstract int ZY();
  
  protected abstract int ZZ();
  
  public final d a(d paramd)
  {
    int i = size();
    int j = paramd.size();
    if (i + j >= 2147483647L) {
      throw new IllegalArgumentException(53 + "ByteString would be too long: " + i + "+" + j);
    }
    return v.a(this, paramd);
  }
  
  final void a(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IndexOutOfBoundsException(30 + "Source offset < 0: " + paramInt1);
    }
    if (paramInt2 < 0) {
      throw new IndexOutOfBoundsException(23 + "Length < 0: " + paramInt2);
    }
    if (paramInt1 + paramInt2 > size()) {
      throw new IndexOutOfBoundsException(39 + "Source end offset exceeded: " + (paramInt1 + paramInt2));
    }
    if (paramInt2 > 0) {
      b(paramOutputStream, paramInt1, paramInt2);
    }
  }
  
  abstract void b(OutputStream paramOutputStream, int paramInt1, int paramInt2);
  
  public final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < 0) {
      throw new IndexOutOfBoundsException(30 + "Source offset < 0: " + paramInt1);
    }
    if (paramInt2 < 0) {
      throw new IndexOutOfBoundsException(30 + "Target offset < 0: " + paramInt2);
    }
    if (paramInt3 < 0) {
      throw new IndexOutOfBoundsException(23 + "Length < 0: " + paramInt3);
    }
    if (paramInt1 + paramInt3 > size()) {
      throw new IndexOutOfBoundsException(34 + "Source end offset < 0: " + (paramInt1 + paramInt3));
    }
    if (paramInt2 + paramInt3 > paramArrayOfByte.length) {
      throw new IndexOutOfBoundsException(34 + "Target end offset < 0: " + (paramInt2 + paramInt3));
    }
    if (paramInt3 > 0) {
      c(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    }
  }
  
  protected abstract void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract a kxZ();
  
  protected abstract boolean kyb();
  
  public abstract int size();
  
  public final byte[] toByteArray()
  {
    int i = size();
    if (i == 0) {
      return k.EMPTY_BYTE_ARRAY;
    }
    byte[] arrayOfByte = new byte[i];
    c(arrayOfByte, 0, 0, i);
    return arrayOfByte;
  }
  
  public String toString()
  {
    return String.format("<ByteString@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
  }
  
  public abstract String toString(String paramString);
  
  public static abstract interface a
    extends Iterator<Byte>
  {
    public abstract byte nextByte();
  }
  
  public static final class b
    extends OutputStream
  {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private final int ajeV;
    private final ArrayList<d> ajeW;
    private int ajeX;
    private byte[] buffer;
    private int dXt;
    
    b()
    {
      AppMethodBeat.i(59370);
      this.ajeV = 128;
      this.ajeW = new ArrayList();
      this.buffer = new byte[''];
      AppMethodBeat.o(59370);
    }
    
    private void aMh(int paramInt)
    {
      AppMethodBeat.i(59375);
      this.ajeW.add(new q(this.buffer));
      this.ajeX += this.buffer.length;
      this.buffer = new byte[Math.max(this.ajeV, Math.max(paramInt, this.ajeX >>> 1))];
      this.dXt = 0;
      AppMethodBeat.o(59375);
    }
    
    private int size()
    {
      try
      {
        int i = this.ajeX;
        int j = this.dXt;
        return i + j;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    /* Error */
    public final d kyc()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 70
      //   4: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 65	kotlin/l/b/a/b/h/d$b:dXt	I
      //   11: aload_0
      //   12: getfield 41	kotlin/l/b/a/b/h/d$b:buffer	[B
      //   15: arraylength
      //   16: if_icmpge +88 -> 104
      //   19: aload_0
      //   20: getfield 65	kotlin/l/b/a/b/h/d$b:dXt	I
      //   23: ifle +46 -> 69
      //   26: aload_0
      //   27: getfield 41	kotlin/l/b/a/b/h/d$b:buffer	[B
      //   30: astore_2
      //   31: aload_0
      //   32: getfield 65	kotlin/l/b/a/b/h/d$b:dXt	I
      //   35: istore_1
      //   36: iload_1
      //   37: newarray byte
      //   39: astore_3
      //   40: aload_2
      //   41: iconst_0
      //   42: aload_3
      //   43: iconst_0
      //   44: aload_2
      //   45: arraylength
      //   46: iload_1
      //   47: invokestatic 73	java/lang/Math:min	(II)I
      //   50: invokestatic 79	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   53: aload_0
      //   54: getfield 39	kotlin/l/b/a/b/h/d$b:ajeW	Ljava/util/ArrayList;
      //   57: new 48	kotlin/l/b/a/b/h/q
      //   60: dup
      //   61: aload_3
      //   62: invokespecial 51	kotlin/l/b/a/b/h/q:<init>	([B)V
      //   65: invokevirtual 55	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   68: pop
      //   69: aload_0
      //   70: aload_0
      //   71: getfield 57	kotlin/l/b/a/b/h/d$b:ajeX	I
      //   74: aload_0
      //   75: getfield 65	kotlin/l/b/a/b/h/d$b:dXt	I
      //   78: iadd
      //   79: putfield 57	kotlin/l/b/a/b/h/d$b:ajeX	I
      //   82: aload_0
      //   83: iconst_0
      //   84: putfield 65	kotlin/l/b/a/b/h/d$b:dXt	I
      //   87: aload_0
      //   88: getfield 39	kotlin/l/b/a/b/h/d$b:ajeW	Ljava/util/ArrayList;
      //   91: invokestatic 83	kotlin/l/b/a/b/h/d:G	(Ljava/lang/Iterable;)Lkotlin/l/b/a/b/h/d;
      //   94: astore_2
      //   95: ldc 70
      //   97: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   100: aload_0
      //   101: monitorexit
      //   102: aload_2
      //   103: areturn
      //   104: aload_0
      //   105: getfield 39	kotlin/l/b/a/b/h/d$b:ajeW	Ljava/util/ArrayList;
      //   108: new 48	kotlin/l/b/a/b/h/q
      //   111: dup
      //   112: aload_0
      //   113: getfield 41	kotlin/l/b/a/b/h/d$b:buffer	[B
      //   116: invokespecial 51	kotlin/l/b/a/b/h/q:<init>	([B)V
      //   119: invokevirtual 55	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   122: pop
      //   123: aload_0
      //   124: getstatic 21	kotlin/l/b/a/b/h/d$b:EMPTY_BYTE_ARRAY	[B
      //   127: putfield 41	kotlin/l/b/a/b/h/d$b:buffer	[B
      //   130: goto -61 -> 69
      //   133: astore_2
      //   134: aload_0
      //   135: monitorexit
      //   136: aload_2
      //   137: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	138	0	this	b
      //   35	12	1	i	int
      //   30	73	2	localObject1	Object
      //   133	4	2	localObject2	Object
      //   39	23	3	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   2	69	133	finally
      //   69	100	133	finally
      //   104	130	133	finally
    }
    
    public final String toString()
    {
      AppMethodBeat.i(59374);
      String str = String.format("<ByteString.Output@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
      AppMethodBeat.o(59374);
      return str;
    }
    
    public final void write(int paramInt)
    {
      try
      {
        AppMethodBeat.i(59371);
        if (this.dXt == this.buffer.length) {
          aMh(1);
        }
        byte[] arrayOfByte = this.buffer;
        int i = this.dXt;
        this.dXt = (i + 1);
        arrayOfByte[i] = ((byte)paramInt);
        AppMethodBeat.o(59371);
        return;
      }
      finally {}
    }
    
    /* Error */
    public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 118
      //   4: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: iload_3
      //   8: aload_0
      //   9: getfield 41	kotlin/l/b/a/b/h/d$b:buffer	[B
      //   12: arraylength
      //   13: aload_0
      //   14: getfield 65	kotlin/l/b/a/b/h/d$b:dXt	I
      //   17: isub
      //   18: if_icmpgt +35 -> 53
      //   21: aload_1
      //   22: iload_2
      //   23: aload_0
      //   24: getfield 41	kotlin/l/b/a/b/h/d$b:buffer	[B
      //   27: aload_0
      //   28: getfield 65	kotlin/l/b/a/b/h/d$b:dXt	I
      //   31: iload_3
      //   32: invokestatic 79	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   35: aload_0
      //   36: aload_0
      //   37: getfield 65	kotlin/l/b/a/b/h/d$b:dXt	I
      //   40: iload_3
      //   41: iadd
      //   42: putfield 65	kotlin/l/b/a/b/h/d$b:dXt	I
      //   45: ldc 118
      //   47: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   50: aload_0
      //   51: monitorexit
      //   52: return
      //   53: aload_0
      //   54: getfield 41	kotlin/l/b/a/b/h/d$b:buffer	[B
      //   57: arraylength
      //   58: aload_0
      //   59: getfield 65	kotlin/l/b/a/b/h/d$b:dXt	I
      //   62: isub
      //   63: istore 4
      //   65: aload_1
      //   66: iload_2
      //   67: aload_0
      //   68: getfield 41	kotlin/l/b/a/b/h/d$b:buffer	[B
      //   71: aload_0
      //   72: getfield 65	kotlin/l/b/a/b/h/d$b:dXt	I
      //   75: iload 4
      //   77: invokestatic 79	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   80: iload_3
      //   81: iload 4
      //   83: isub
      //   84: istore_3
      //   85: aload_0
      //   86: iload_3
      //   87: invokespecial 116	kotlin/l/b/a/b/h/d$b:aMh	(I)V
      //   90: aload_1
      //   91: iload_2
      //   92: iload 4
      //   94: iadd
      //   95: aload_0
      //   96: getfield 41	kotlin/l/b/a/b/h/d$b:buffer	[B
      //   99: iconst_0
      //   100: iload_3
      //   101: invokestatic 79	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   104: aload_0
      //   105: iload_3
      //   106: putfield 65	kotlin/l/b/a/b/h/d$b:dXt	I
      //   109: ldc 118
      //   111: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   114: goto -64 -> 50
      //   117: astore_1
      //   118: aload_0
      //   119: monitorexit
      //   120: aload_1
      //   121: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	122	0	this	b
      //   0	122	1	paramArrayOfByte	byte[]
      //   0	122	2	paramInt1	int
      //   0	122	3	paramInt2	int
      //   63	32	4	i	int
      // Exception table:
      //   from	to	target	type
      //   2	50	117	finally
      //   53	80	117	finally
      //   85	114	117	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.h.d
 * JD-Core Version:    0.7.0.1
 */