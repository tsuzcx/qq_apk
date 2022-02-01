package d.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

final class u
  extends d
{
  private static final int[] Nry;
  private final d NrA;
  private final d NrB;
  private final int NrC;
  private final int NrD;
  private final int Nrz;
  private int xbE;
  
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
    Nry = new int[localArrayList.size()];
    i = 0;
    while (i < Nry.length)
    {
      Nry[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    AppMethodBeat.o(59569);
  }
  
  private u(d paramd1, d paramd2)
  {
    AppMethodBeat.i(59555);
    this.xbE = 0;
    this.NrA = paramd1;
    this.NrB = paramd2;
    this.NrC = paramd1.size();
    this.Nrz = (this.NrC + paramd2.size());
    this.NrD = (Math.max(paramd1.grs(), paramd2.grs()) + 1);
    AppMethodBeat.o(59555);
  }
  
  static d a(d paramd1, d paramd2)
  {
    AppMethodBeat.i(59556);
    Object localObject;
    int i;
    if ((paramd1 instanceof u))
    {
      localObject = (u)paramd1;
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
      if ((localObject != null) && (((u)localObject).NrB.size() + paramd2.size() < 128))
      {
        paramd1 = b(((u)localObject).NrB, paramd2);
        paramd1 = new u(((u)localObject).NrA, paramd1);
      }
      else if ((localObject != null) && (((u)localObject).NrA.grs() > ((u)localObject).NrB.grs()) && (((u)localObject).NrD > paramd2.grs()))
      {
        paramd1 = new u(((u)localObject).NrB, paramd2);
        paramd1 = new u(((u)localObject).NrA, paramd1);
      }
      else
      {
        int j = Math.max(paramd1.grs(), paramd2.grs());
        if (i >= Nry[(j + 1)])
        {
          paramd1 = new u(paramd1, paramd2);
        }
        else
        {
          localObject = new a((byte)0);
          ((a)localObject).g(paramd1);
          ((a)localObject).g(paramd2);
          for (paramd2 = (d)((a)localObject).NrE.pop();; paramd2 = new u((d)((a)localObject).NrE.pop(), paramd2, (byte)0))
          {
            paramd1 = paramd2;
            if (((a)localObject).NrE.isEmpty()) {
              break;
            }
          }
          paramd1 = paramd2;
        }
      }
    }
  }
  
  private static p b(d paramd1, d paramd2)
  {
    AppMethodBeat.i(59557);
    int i = paramd1.size();
    int j = paramd2.size();
    byte[] arrayOfByte = new byte[i + j];
    paramd1.i(arrayOfByte, 0, 0, i);
    paramd2.i(arrayOfByte, 0, i, j);
    paramd1 = new p(arrayOfByte);
    AppMethodBeat.o(59557);
    return paramd1;
  }
  
  final void b(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59559);
    if (paramInt1 + paramInt2 <= this.NrC)
    {
      this.NrA.b(paramOutputStream, paramInt1, paramInt2);
      AppMethodBeat.o(59559);
      return;
    }
    if (paramInt1 >= this.NrC)
    {
      this.NrB.b(paramOutputStream, paramInt1 - this.NrC, paramInt2);
      AppMethodBeat.o(59559);
      return;
    }
    int i = this.NrC - paramInt1;
    this.NrA.b(paramOutputStream, paramInt1, i);
    this.NrB.b(paramOutputStream, 0, paramInt2 - i);
    AppMethodBeat.o(59559);
  }
  
  protected final int bb(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(59562);
    if (paramInt2 + paramInt3 <= this.NrC)
    {
      paramInt1 = this.NrA.bb(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(59562);
      return paramInt1;
    }
    if (paramInt2 >= this.NrC)
    {
      paramInt1 = this.NrB.bb(paramInt1, paramInt2 - this.NrC, paramInt3);
      AppMethodBeat.o(59562);
      return paramInt1;
    }
    int i = this.NrC - paramInt2;
    paramInt1 = this.NrA.bb(paramInt1, paramInt2, i);
    paramInt1 = this.NrB.bb(paramInt1, 0, paramInt3 - i);
    AppMethodBeat.o(59562);
    return paramInt1;
  }
  
  protected final int bc(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(59565);
    if (paramInt2 + paramInt3 <= this.NrC)
    {
      paramInt1 = this.NrA.bc(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(59565);
      return paramInt1;
    }
    if (paramInt2 >= this.NrC)
    {
      paramInt1 = this.NrB.bc(paramInt1, paramInt2 - this.NrC, paramInt3);
      AppMethodBeat.o(59565);
      return paramInt1;
    }
    int i = this.NrC - paramInt2;
    paramInt1 = this.NrA.bc(paramInt1, paramInt2, i);
    paramInt1 = this.NrB.bc(paramInt1, 0, paramInt3 - i);
    AppMethodBeat.o(59565);
    return paramInt1;
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
    if (this.Nrz != paramObject.size())
    {
      AppMethodBeat.o(59563);
      return false;
    }
    if (this.Nrz == 0)
    {
      AppMethodBeat.o(59563);
      return true;
    }
    if (this.xbE != 0)
    {
      i = paramObject.gru();
      if ((i != 0) && (this.xbE != i))
      {
        AppMethodBeat.o(59563);
        return false;
      }
    }
    int j = 0;
    b localb1 = new b(this, (byte)0);
    p localp = (p)localb1.next();
    int i = 0;
    b localb2 = new b(paramObject, (byte)0);
    paramObject = (p)localb2.next();
    int k = 0;
    for (;;)
    {
      int i1 = localp.size() - j;
      int n = paramObject.size() - i;
      int m = Math.min(i1, n);
      if (j == 0) {}
      for (boolean bool = localp.a(paramObject, i, m); !bool; bool = paramObject.a(localp, j, m))
      {
        AppMethodBeat.o(59563);
        return false;
      }
      k += m;
      if (k >= this.Nrz)
      {
        if (k == this.Nrz)
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
        localp = (p)localb1.next();
      }
      for (;;)
      {
        if (m != n) {
          break label317;
        }
        i = 0;
        paramObject = (p)localb2.next();
        break;
        j += m;
      }
      label317:
      i += m;
    }
  }
  
  public final d.a gro()
  {
    AppMethodBeat.i(59567);
    c localc = new c((byte)0);
    AppMethodBeat.o(59567);
    return localc;
  }
  
  public final boolean grp()
  {
    AppMethodBeat.i(59561);
    int i = this.NrA.bb(0, 0, this.NrC);
    if (this.NrB.bb(i, 0, this.NrB.size()) == 0)
    {
      AppMethodBeat.o(59561);
      return true;
    }
    AppMethodBeat.o(59561);
    return false;
  }
  
  public final e grq()
  {
    AppMethodBeat.i(59566);
    e locale = e.Y(new d());
    AppMethodBeat.o(59566);
    return locale;
  }
  
  protected final int grs()
  {
    return this.NrD;
  }
  
  protected final boolean grt()
  {
    return this.Nrz >= Nry[this.NrD];
  }
  
  protected final int gru()
  {
    return this.xbE;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59564);
    int j = this.xbE;
    int i = j;
    if (j == 0)
    {
      j = bc(this.Nrz, 0, this.Nrz);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.xbE = i;
    }
    AppMethodBeat.o(59564);
    return i;
  }
  
  protected final void j(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(59558);
    if (paramInt1 + paramInt3 <= this.NrC)
    {
      this.NrA.j(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(59558);
      return;
    }
    if (paramInt1 >= this.NrC)
    {
      this.NrB.j(paramArrayOfByte, paramInt1 - this.NrC, paramInt2, paramInt3);
      AppMethodBeat.o(59558);
      return;
    }
    int i = this.NrC - paramInt1;
    this.NrA.j(paramArrayOfByte, paramInt1, paramInt2, i);
    this.NrB.j(paramArrayOfByte, 0, paramInt2 + i, paramInt3 - i);
    AppMethodBeat.o(59558);
  }
  
  public final int size()
  {
    return this.Nrz;
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
    final Stack<d> NrE;
    
    private a()
    {
      AppMethodBeat.i(59533);
      this.NrE = new Stack();
      AppMethodBeat.o(59533);
    }
    
    private static int alh(int paramInt)
    {
      AppMethodBeat.i(59535);
      int i = Arrays.binarySearch(u.gsa(), paramInt);
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
        if (paramd.grt())
        {
          int i = alh(paramd.size());
          int j = u.gsa()[(i + 1)];
          if ((this.NrE.isEmpty()) || (((d)this.NrE.peek()).size() >= j))
          {
            this.NrE.push(paramd);
            AppMethodBeat.o(59534);
            return;
          }
          i = u.gsa()[i];
          for (Object localObject = (d)this.NrE.pop(); (!this.NrE.isEmpty()) && (((d)this.NrE.peek()).size() < i); localObject = new u((d)this.NrE.pop(), (d)localObject, (byte)0)) {}
          for (paramd = new u((d)localObject, paramd, (byte)0); !this.NrE.isEmpty(); paramd = new u((d)this.NrE.pop(), paramd, (byte)0))
          {
            i = alh(paramd.size());
            i = u.gsa()[(i + 1)];
            if (((d)this.NrE.peek()).size() >= i) {
              break;
            }
          }
          this.NrE.push(paramd);
          AppMethodBeat.o(59534);
          return;
        }
        if (!(paramd instanceof u)) {
          break;
        }
        paramd = (u)paramd;
        g(u.a(paramd));
        paramd = u.b(paramd);
      }
      paramd = String.valueOf(String.valueOf(paramd.getClass()));
      paramd = new IllegalArgumentException(paramd.length() + 49 + "Has a new type of ByteString been created? Found " + paramd);
      AppMethodBeat.o(59534);
      throw paramd;
    }
  }
  
  static final class b
    implements Iterator<p>
  {
    private final Stack<u> NrF;
    private p NrG;
    
    private b(d paramd)
    {
      AppMethodBeat.i(59536);
      this.NrF = new Stack();
      this.NrG = h(paramd);
      AppMethodBeat.o(59536);
    }
    
    private p gsb()
    {
      AppMethodBeat.i(59538);
      for (;;)
      {
        if (this.NrF.isEmpty())
        {
          AppMethodBeat.o(59538);
          return null;
        }
        p localp = h(u.b((u)this.NrF.pop()));
        if (localp.size() == 0) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(59538);
          return localp;
        }
      }
    }
    
    private p h(d paramd)
    {
      AppMethodBeat.i(59537);
      while ((paramd instanceof u))
      {
        paramd = (u)paramd;
        this.NrF.push(paramd);
        paramd = u.a(paramd);
      }
      paramd = (p)paramd;
      AppMethodBeat.o(59537);
      return paramd;
    }
    
    public final p gsc()
    {
      AppMethodBeat.i(59539);
      if (this.NrG == null)
      {
        localObject = new NoSuchElementException();
        AppMethodBeat.o(59539);
        throw ((Throwable)localObject);
      }
      Object localObject = this.NrG;
      this.NrG = gsb();
      AppMethodBeat.o(59539);
      return localObject;
    }
    
    public final boolean hasNext()
    {
      return this.NrG != null;
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
    private final u.b NrH;
    private d.a NrI;
    int NrJ;
    
    private c()
    {
      AppMethodBeat.i(59542);
      this.NrH = new u.b(u.this, (byte)0);
      this.NrI = this.NrH.gsc().gro();
      this.NrJ = u.this.size();
      AppMethodBeat.o(59542);
    }
    
    public final boolean hasNext()
    {
      return this.NrJ > 0;
    }
    
    public final byte nextByte()
    {
      AppMethodBeat.i(59543);
      if (!this.NrI.hasNext()) {
        this.NrI = this.NrH.gsc().gro();
      }
      this.NrJ -= 1;
      byte b = this.NrI.nextByte();
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
  
  final class d
    extends InputStream
  {
    private u.b NrL;
    private p NrM;
    private int NrN;
    private int NrO;
    private int NrP;
    private int mark;
    
    public d()
    {
      AppMethodBeat.i(59546);
      initialize();
      AppMethodBeat.o(59546);
    }
    
    private int K(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(59549);
      int i = paramInt2;
      int j = paramInt1;
      paramInt1 = i;
      for (i = j; paramInt1 > 0; i = j)
      {
        gsd();
        if (this.NrM == null)
        {
          if (paramInt1 != paramInt2) {
            break;
          }
          AppMethodBeat.o(59549);
          return -1;
        }
        int k = Math.min(this.NrN - this.NrO, paramInt1);
        j = i;
        if (paramArrayOfByte != null)
        {
          this.NrM.i(paramArrayOfByte, this.NrO, i, k);
          j = i + k;
        }
        this.NrO += k;
        paramInt1 -= k;
      }
      AppMethodBeat.o(59549);
      return paramInt2 - paramInt1;
    }
    
    private void gsd()
    {
      AppMethodBeat.i(59554);
      if ((this.NrM != null) && (this.NrO == this.NrN))
      {
        this.NrP += this.NrN;
        this.NrO = 0;
        if (this.NrL.hasNext())
        {
          this.NrM = this.NrL.gsc();
          this.NrN = this.NrM.size();
          AppMethodBeat.o(59554);
          return;
        }
        this.NrM = null;
        this.NrN = 0;
      }
      AppMethodBeat.o(59554);
    }
    
    private void initialize()
    {
      AppMethodBeat.i(59553);
      this.NrL = new u.b(u.this, (byte)0);
      this.NrM = this.NrL.gsc();
      this.NrN = this.NrM.size();
      this.NrO = 0;
      this.NrP = 0;
      AppMethodBeat.o(59553);
    }
    
    public final int available()
    {
      AppMethodBeat.i(59551);
      int i = this.NrP;
      int j = this.NrO;
      int k = u.this.size();
      AppMethodBeat.o(59551);
      return k - (i + j);
    }
    
    public final void mark(int paramInt)
    {
      this.mark = (this.NrP + this.NrO);
    }
    
    public final boolean markSupported()
    {
      return true;
    }
    
    public final int read()
    {
      AppMethodBeat.i(59550);
      gsd();
      if (this.NrM == null)
      {
        AppMethodBeat.o(59550);
        return -1;
      }
      p localp = this.NrM;
      int i = this.NrO;
      this.NrO = (i + 1);
      i = localp.akW(i);
      AppMethodBeat.o(59550);
      return i & 0xFF;
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(59547);
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = new NullPointerException();
        AppMethodBeat.o(59547);
        throw paramArrayOfByte;
      }
      if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt2 > paramArrayOfByte.length - paramInt1))
      {
        paramArrayOfByte = new IndexOutOfBoundsException();
        AppMethodBeat.o(59547);
        throw paramArrayOfByte;
      }
      paramInt1 = K(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(59547);
      return paramInt1;
    }
    
    public final void reset()
    {
      try
      {
        AppMethodBeat.i(59552);
        initialize();
        K(null, 0, this.mark);
        AppMethodBeat.o(59552);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final long skip(long paramLong)
    {
      AppMethodBeat.i(59548);
      if (paramLong < 0L)
      {
        IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException();
        AppMethodBeat.o(59548);
        throw localIndexOutOfBoundsException;
      }
      long l = paramLong;
      if (paramLong > 2147483647L) {
        l = 2147483647L;
      }
      paramLong = K(null, 0, (int)l);
      AppMethodBeat.o(59548);
      return paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.h.u
 * JD-Core Version:    0.7.0.1
 */