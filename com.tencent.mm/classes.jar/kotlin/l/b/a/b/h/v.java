package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

final class v
  extends d
{
  private static final int[] dUI;
  private final d ajfs;
  private final d ajft;
  private int dIL;
  private final int dUJ;
  private final int dUM;
  private final int dUN;
  
  static
  {
    AppMethodBeat.i(59569);
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    int j = 1;
    for (;;)
    {
      int k = j;
      if (i <= 0) {
        break;
      }
      localArrayList.add(Integer.valueOf(i));
      j = i;
      i = k + i;
    }
    localArrayList.add(Integer.valueOf(2147483647));
    dUI = new int[localArrayList.size()];
    i = 0;
    while (i < dUI.length)
    {
      dUI[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    AppMethodBeat.o(59569);
  }
  
  private v(d paramd1, d paramd2)
  {
    AppMethodBeat.i(59555);
    this.dIL = 0;
    this.ajfs = paramd1;
    this.ajft = paramd2;
    this.dUM = paramd1.size();
    this.dUJ = (this.dUM + paramd2.size());
    this.dUN = (Math.max(paramd1.ZY(), paramd2.ZY()) + 1);
    AppMethodBeat.o(59555);
  }
  
  static d a(d paramd1, d paramd2)
  {
    AppMethodBeat.i(59556);
    Object localObject;
    int i;
    if ((paramd1 instanceof v))
    {
      localObject = (v)paramd1;
      if (paramd2.size() == 0) {
        break label298;
      }
      if (paramd1.size() == 0) {
        break label293;
      }
      i = paramd1.size() + paramd2.size();
      if (i >= 128) {
        break label68;
      }
      paramd1 = b(paramd1, paramd2);
    }
    label293:
    label298:
    for (;;)
    {
      AppMethodBeat.o(59556);
      return paramd1;
      localObject = null;
      break;
      label68:
      if ((localObject != null) && (((v)localObject).ajft.size() + paramd2.size() < 128))
      {
        paramd1 = b(((v)localObject).ajft, paramd2);
        paramd1 = new v(((v)localObject).ajfs, paramd1);
      }
      else if ((localObject != null) && (((v)localObject).ajfs.ZY() > ((v)localObject).ajft.ZY()) && (((v)localObject).dUN > paramd2.ZY()))
      {
        paramd1 = new v(((v)localObject).ajft, paramd2);
        paramd1 = new v(((v)localObject).ajfs, paramd1);
      }
      else
      {
        int j = Math.max(paramd1.ZY(), paramd2.ZY());
        if (i >= dUI[(j + 1)])
        {
          paramd1 = new v(paramd1, paramd2);
        }
        else
        {
          localObject = new a((byte)0);
          ((a)localObject).g(paramd1);
          ((a)localObject).g(paramd2);
          for (paramd2 = (d)((a)localObject).ajfu.pop();; paramd2 = new v((d)((a)localObject).ajfu.pop(), paramd2, (byte)0))
          {
            paramd1 = paramd2;
            if (((a)localObject).ajfu.isEmpty()) {
              break;
            }
          }
          paramd1 = paramd2;
        }
      }
    }
  }
  
  private static q b(d paramd1, d paramd2)
  {
    AppMethodBeat.i(59557);
    int i = paramd1.size();
    int j = paramd2.size();
    byte[] arrayOfByte = new byte[i + j];
    paramd1.b(arrayOfByte, 0, 0, i);
    paramd2.b(arrayOfByte, 0, i, j);
    paramd1 = new q(arrayOfByte);
    AppMethodBeat.o(59557);
    return paramd1;
  }
  
  protected final int Q(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(59562);
    if (paramInt2 + paramInt3 <= this.dUM)
    {
      paramInt1 = this.ajfs.Q(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(59562);
      return paramInt1;
    }
    if (paramInt2 >= this.dUM)
    {
      paramInt1 = this.ajft.Q(paramInt1, paramInt2 - this.dUM, paramInt3);
      AppMethodBeat.o(59562);
      return paramInt1;
    }
    int i = this.dUM - paramInt2;
    paramInt1 = this.ajfs.Q(paramInt1, paramInt2, i);
    paramInt1 = this.ajft.Q(paramInt1, 0, paramInt3 - i);
    AppMethodBeat.o(59562);
    return paramInt1;
  }
  
  protected final int R(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(59565);
    if (paramInt2 + paramInt3 <= this.dUM)
    {
      paramInt1 = this.ajfs.R(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(59565);
      return paramInt1;
    }
    if (paramInt2 >= this.dUM)
    {
      paramInt1 = this.ajft.R(paramInt1, paramInt2 - this.dUM, paramInt3);
      AppMethodBeat.o(59565);
      return paramInt1;
    }
    int i = this.dUM - paramInt2;
    paramInt1 = this.ajfs.R(paramInt1, paramInt2, i);
    paramInt1 = this.ajft.R(paramInt1, 0, paramInt3 - i);
    AppMethodBeat.o(59565);
    return paramInt1;
  }
  
  public final boolean ZW()
  {
    AppMethodBeat.i(59561);
    int i = this.ajfs.Q(0, 0, this.dUM);
    if (this.ajft.Q(i, 0, this.ajft.size()) == 0)
    {
      AppMethodBeat.o(59561);
      return true;
    }
    AppMethodBeat.o(59561);
    return false;
  }
  
  protected final int ZY()
  {
    return this.dUN;
  }
  
  protected final int ZZ()
  {
    return this.dIL;
  }
  
  final void b(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59559);
    if (paramInt1 + paramInt2 <= this.dUM)
    {
      this.ajfs.b(paramOutputStream, paramInt1, paramInt2);
      AppMethodBeat.o(59559);
      return;
    }
    if (paramInt1 >= this.dUM)
    {
      this.ajft.b(paramOutputStream, paramInt1 - this.dUM, paramInt2);
      AppMethodBeat.o(59559);
      return;
    }
    int i = this.dUM - paramInt1;
    this.ajfs.b(paramOutputStream, paramInt1, i);
    this.ajft.b(paramOutputStream, 0, paramInt2 - i);
    AppMethodBeat.o(59559);
  }
  
  protected final void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(59558);
    if (paramInt1 + paramInt3 <= this.dUM)
    {
      this.ajfs.c(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(59558);
      return;
    }
    if (paramInt1 >= this.dUM)
    {
      this.ajft.c(paramArrayOfByte, paramInt1 - this.dUM, paramInt2, paramInt3);
      AppMethodBeat.o(59558);
      return;
    }
    int i = this.dUM - paramInt1;
    this.ajfs.c(paramArrayOfByte, paramInt1, paramInt2, i);
    this.ajft.c(paramArrayOfByte, 0, paramInt2 + i, paramInt3 - i);
    AppMethodBeat.o(59558);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(59563);
    if (paramObject == this)
    {
      AppMethodBeat.o(59563);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(59563);
      return false;
    }
    paramObject = (d)paramObject;
    if (this.dUJ != paramObject.size())
    {
      AppMethodBeat.o(59563);
      return false;
    }
    if (this.dUJ == 0)
    {
      AppMethodBeat.o(59563);
      return true;
    }
    if (this.dIL != 0)
    {
      i = paramObject.ZZ();
      if ((i != 0) && (this.dIL != i))
      {
        AppMethodBeat.o(59563);
        return false;
      }
    }
    int j = 0;
    b localb1 = new b(this, (byte)0);
    q localq = (q)localb1.next();
    int i = 0;
    b localb2 = new b(paramObject, (byte)0);
    paramObject = (q)localb2.next();
    int k = 0;
    for (;;)
    {
      int i1 = localq.size() - j;
      int n = paramObject.size() - i;
      int m = Math.min(i1, n);
      if (j == 0) {}
      for (boolean bool = localq.a(paramObject, i, m); !bool; bool = paramObject.a(localq, j, m))
      {
        AppMethodBeat.o(59563);
        return false;
      }
      k += m;
      if (k >= this.dUJ)
      {
        if (k == this.dUJ)
        {
          AppMethodBeat.o(59563);
          return true;
        }
        paramObject = new IllegalStateException();
        AppMethodBeat.o(59563);
        throw paramObject;
      }
      if (m == i1)
      {
        j = 0;
        localq = (q)localb1.next();
      }
      for (;;)
      {
        if (m != n) {
          break label317;
        }
        i = 0;
        paramObject = (q)localb2.next();
        break;
        j += m;
      }
      label317:
      i += m;
    }
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59564);
    int j = this.dIL;
    int i = j;
    if (j == 0)
    {
      j = R(this.dUJ, 0, this.dUJ);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.dIL = i;
    }
    AppMethodBeat.o(59564);
    return i;
  }
  
  public final d.a kxZ()
  {
    AppMethodBeat.i(59567);
    c localc = new c((byte)0);
    AppMethodBeat.o(59567);
    return localc;
  }
  
  protected final boolean kyb()
  {
    return this.dUJ >= dUI[this.dUN];
  }
  
  public final int size()
  {
    return this.dUJ;
  }
  
  public final String toString(String paramString)
  {
    AppMethodBeat.i(59560);
    paramString = new String(toByteArray(), paramString);
    AppMethodBeat.o(59560);
    return paramString;
  }
  
  static final class a
  {
    final Stack<d> ajfu;
    
    private a()
    {
      AppMethodBeat.i(59533);
      this.ajfu = new Stack();
      AppMethodBeat.o(59533);
    }
    
    private static int aMl(int paramInt)
    {
      AppMethodBeat.i(59535);
      int i = Arrays.binarySearch(v.kyw(), paramInt);
      paramInt = i;
      if (i < 0) {
        paramInt = -(i + 1) - 1;
      }
      AppMethodBeat.o(59535);
      return paramInt;
    }
    
    final void g(d paramd)
    {
      AppMethodBeat.i(59534);
      for (;;)
      {
        if (paramd.kyb())
        {
          int i = aMl(paramd.size());
          int j = v.kyw()[(i + 1)];
          if ((this.ajfu.isEmpty()) || (((d)this.ajfu.peek()).size() >= j))
          {
            this.ajfu.push(paramd);
            AppMethodBeat.o(59534);
            return;
          }
          i = v.kyw()[i];
          for (Object localObject = (d)this.ajfu.pop(); (!this.ajfu.isEmpty()) && (((d)this.ajfu.peek()).size() < i); localObject = new v((d)this.ajfu.pop(), (d)localObject, (byte)0)) {}
          for (paramd = new v((d)localObject, paramd, (byte)0); !this.ajfu.isEmpty(); paramd = new v((d)this.ajfu.pop(), paramd, (byte)0))
          {
            i = aMl(paramd.size());
            i = v.kyw()[(i + 1)];
            if (((d)this.ajfu.peek()).size() >= i) {
              break;
            }
          }
          this.ajfu.push(paramd);
          AppMethodBeat.o(59534);
          return;
        }
        if (!(paramd instanceof v)) {
          break;
        }
        paramd = (v)paramd;
        g(v.a(paramd));
        paramd = v.b(paramd);
      }
      paramd = String.valueOf(String.valueOf(paramd.getClass()));
      paramd = new IllegalArgumentException(paramd.length() + 49 + "Has a new type of ByteString been created? Found " + paramd);
      AppMethodBeat.o(59534);
      throw paramd;
    }
  }
  
  static final class b
    implements Iterator<q>
  {
    private final Stack<v> ajfv;
    private q ajfw;
    
    private b(d paramd)
    {
      AppMethodBeat.i(59536);
      this.ajfv = new Stack();
      this.ajfw = h(paramd);
      AppMethodBeat.o(59536);
    }
    
    private q h(d paramd)
    {
      AppMethodBeat.i(59537);
      while ((paramd instanceof v))
      {
        paramd = (v)paramd;
        this.ajfv.push(paramd);
        paramd = v.a(paramd);
      }
      paramd = (q)paramd;
      AppMethodBeat.o(59537);
      return paramd;
    }
    
    private q kyx()
    {
      AppMethodBeat.i(59538);
      for (;;)
      {
        if (this.ajfv.isEmpty())
        {
          AppMethodBeat.o(59538);
          return null;
        }
        q localq = h(v.b((v)this.ajfv.pop()));
        if (localq.size() == 0) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(59538);
          return localq;
        }
      }
    }
    
    public final boolean hasNext()
    {
      return this.ajfw != null;
    }
    
    public final q kyy()
    {
      AppMethodBeat.i(59539);
      if (this.ajfw == null)
      {
        localObject = new NoSuchElementException();
        AppMethodBeat.o(59539);
        throw ((Throwable)localObject);
      }
      Object localObject = this.ajfw;
      this.ajfw = kyx();
      AppMethodBeat.o(59539);
      return localObject;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(59540);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(59540);
      throw localUnsupportedOperationException;
    }
  }
  
  final class c
    implements d.a
  {
    private final v.b ajfx;
    private d.a ajfy;
    int ajfz;
    
    private c()
    {
      AppMethodBeat.i(59542);
      this.ajfx = new v.b(v.this, (byte)0);
      this.ajfy = this.ajfx.kyy().kxZ();
      this.ajfz = v.this.size();
      AppMethodBeat.o(59542);
    }
    
    public final boolean hasNext()
    {
      return this.ajfz > 0;
    }
    
    public final byte nextByte()
    {
      AppMethodBeat.i(59543);
      if (!this.ajfy.hasNext()) {
        this.ajfy = this.ajfx.kyy().kxZ();
      }
      this.ajfz -= 1;
      byte b = this.ajfy.nextByte();
      AppMethodBeat.o(59543);
      return b;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(59544);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(59544);
      throw localUnsupportedOperationException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.h.v
 * JD-Core Version:    0.7.0.1
 */