package kotlin.l.b.a.b.h;

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
  private static final int[] TDS;
  private final int TDT;
  private final d TDU;
  private final d TDV;
  private final int TDW;
  private final int TDX;
  private int bNi;
  
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
    TDS = new int[localArrayList.size()];
    i = 0;
    while (i < TDS.length)
    {
      TDS[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    AppMethodBeat.o(59569);
  }
  
  private u(d paramd1, d paramd2)
  {
    AppMethodBeat.i(59555);
    this.bNi = 0;
    this.TDU = paramd1;
    this.TDV = paramd2;
    this.TDW = paramd1.size();
    this.TDT = (this.TDW + paramd2.size());
    this.TDX = (Math.max(paramd1.hJp(), paramd2.hJp()) + 1);
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
      if ((localObject != null) && (((u)localObject).TDV.size() + paramd2.size() < 128))
      {
        paramd1 = b(((u)localObject).TDV, paramd2);
        paramd1 = new u(((u)localObject).TDU, paramd1);
      }
      else if ((localObject != null) && (((u)localObject).TDU.hJp() > ((u)localObject).TDV.hJp()) && (((u)localObject).TDX > paramd2.hJp()))
      {
        paramd1 = new u(((u)localObject).TDV, paramd2);
        paramd1 = new u(((u)localObject).TDU, paramd1);
      }
      else
      {
        int j = Math.max(paramd1.hJp(), paramd2.hJp());
        if (i >= TDS[(j + 1)])
        {
          paramd1 = new u(paramd1, paramd2);
        }
        else
        {
          localObject = new a((byte)0);
          ((a)localObject).g(paramd1);
          ((a)localObject).g(paramd2);
          for (paramd2 = (d)((a)localObject).TDY.pop();; paramd2 = new u((d)((a)localObject).TDY.pop(), paramd2, (byte)0))
          {
            paramd1 = paramd2;
            if (((a)localObject).TDY.isEmpty()) {
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
    paramd1.j(arrayOfByte, 0, 0, i);
    paramd2.j(arrayOfByte, 0, i, j);
    paramd1 = new p(arrayOfByte);
    AppMethodBeat.o(59557);
    return paramd1;
  }
  
  final void b(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59559);
    if (paramInt1 + paramInt2 <= this.TDW)
    {
      this.TDU.b(paramOutputStream, paramInt1, paramInt2);
      AppMethodBeat.o(59559);
      return;
    }
    if (paramInt1 >= this.TDW)
    {
      this.TDV.b(paramOutputStream, paramInt1 - this.TDW, paramInt2);
      AppMethodBeat.o(59559);
      return;
    }
    int i = this.TDW - paramInt1;
    this.TDU.b(paramOutputStream, paramInt1, i);
    this.TDV.b(paramOutputStream, 0, paramInt2 - i);
    AppMethodBeat.o(59559);
  }
  
  protected final int bi(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(59562);
    if (paramInt2 + paramInt3 <= this.TDW)
    {
      paramInt1 = this.TDU.bi(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(59562);
      return paramInt1;
    }
    if (paramInt2 >= this.TDW)
    {
      paramInt1 = this.TDV.bi(paramInt1, paramInt2 - this.TDW, paramInt3);
      AppMethodBeat.o(59562);
      return paramInt1;
    }
    int i = this.TDW - paramInt2;
    paramInt1 = this.TDU.bi(paramInt1, paramInt2, i);
    paramInt1 = this.TDV.bi(paramInt1, 0, paramInt3 - i);
    AppMethodBeat.o(59562);
    return paramInt1;
  }
  
  protected final int bj(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(59565);
    if (paramInt2 + paramInt3 <= this.TDW)
    {
      paramInt1 = this.TDU.bj(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(59565);
      return paramInt1;
    }
    if (paramInt2 >= this.TDW)
    {
      paramInt1 = this.TDV.bj(paramInt1, paramInt2 - this.TDW, paramInt3);
      AppMethodBeat.o(59565);
      return paramInt1;
    }
    int i = this.TDW - paramInt2;
    paramInt1 = this.TDU.bj(paramInt1, paramInt2, i);
    paramInt1 = this.TDV.bj(paramInt1, 0, paramInt3 - i);
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
    if (this.TDT != paramObject.size())
    {
      AppMethodBeat.o(59563);
      return false;
    }
    if (this.TDT == 0)
    {
      AppMethodBeat.o(59563);
      return true;
    }
    if (this.bNi != 0)
    {
      i = paramObject.hJr();
      if ((i != 0) && (this.bNi != i))
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
      if (k >= this.TDT)
      {
        if (k == this.TDT)
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
  
  public final d.a hJm()
  {
    AppMethodBeat.i(59567);
    c localc = new c((byte)0);
    AppMethodBeat.o(59567);
    return localc;
  }
  
  public final e hJn()
  {
    AppMethodBeat.i(59566);
    e locale = e.V(new d());
    AppMethodBeat.o(59566);
    return locale;
  }
  
  protected final int hJp()
  {
    return this.TDX;
  }
  
  protected final boolean hJq()
  {
    return this.TDT >= TDS[this.TDX];
  }
  
  protected final int hJr()
  {
    return this.bNi;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59564);
    int j = this.bNi;
    int i = j;
    if (j == 0)
    {
      j = bj(this.TDT, 0, this.TDT);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.bNi = i;
    }
    AppMethodBeat.o(59564);
    return i;
  }
  
  protected final void l(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(59558);
    if (paramInt1 + paramInt3 <= this.TDW)
    {
      this.TDU.l(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(59558);
      return;
    }
    if (paramInt1 >= this.TDW)
    {
      this.TDV.l(paramArrayOfByte, paramInt1 - this.TDW, paramInt2, paramInt3);
      AppMethodBeat.o(59558);
      return;
    }
    int i = this.TDW - paramInt1;
    this.TDU.l(paramArrayOfByte, paramInt1, paramInt2, i);
    this.TDV.l(paramArrayOfByte, 0, paramInt2 + i, paramInt3 - i);
    AppMethodBeat.o(59558);
  }
  
  public final int size()
  {
    return this.TDT;
  }
  
  public final String toString(String paramString)
  {
    AppMethodBeat.i(59560);
    paramString = new String(toByteArray(), paramString);
    AppMethodBeat.o(59560);
    return paramString;
  }
  
  public final boolean yP()
  {
    AppMethodBeat.i(59561);
    int i = this.TDU.bi(0, 0, this.TDW);
    if (this.TDV.bi(i, 0, this.TDV.size()) == 0)
    {
      AppMethodBeat.o(59561);
      return true;
    }
    AppMethodBeat.o(59561);
    return false;
  }
  
  static final class a
  {
    final Stack<d> TDY;
    
    private a()
    {
      AppMethodBeat.i(59533);
      this.TDY = new Stack();
      AppMethodBeat.o(59533);
    }
    
    private static int avD(int paramInt)
    {
      AppMethodBeat.i(59535);
      int i = Arrays.binarySearch(u.hJN(), paramInt);
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
        if (paramd.hJq())
        {
          int i = avD(paramd.size());
          int j = u.hJN()[(i + 1)];
          if ((this.TDY.isEmpty()) || (((d)this.TDY.peek()).size() >= j))
          {
            this.TDY.push(paramd);
            AppMethodBeat.o(59534);
            return;
          }
          i = u.hJN()[i];
          for (Object localObject = (d)this.TDY.pop(); (!this.TDY.isEmpty()) && (((d)this.TDY.peek()).size() < i); localObject = new u((d)this.TDY.pop(), (d)localObject, (byte)0)) {}
          for (paramd = new u((d)localObject, paramd, (byte)0); !this.TDY.isEmpty(); paramd = new u((d)this.TDY.pop(), paramd, (byte)0))
          {
            i = avD(paramd.size());
            i = u.hJN()[(i + 1)];
            if (((d)this.TDY.peek()).size() >= i) {
              break;
            }
          }
          this.TDY.push(paramd);
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
    private final Stack<u> TDZ;
    private p TEa;
    
    private b(d paramd)
    {
      AppMethodBeat.i(59536);
      this.TDZ = new Stack();
      this.TEa = h(paramd);
      AppMethodBeat.o(59536);
    }
    
    private p h(d paramd)
    {
      AppMethodBeat.i(59537);
      while ((paramd instanceof u))
      {
        paramd = (u)paramd;
        this.TDZ.push(paramd);
        paramd = u.a(paramd);
      }
      paramd = (p)paramd;
      AppMethodBeat.o(59537);
      return paramd;
    }
    
    private p hJO()
    {
      AppMethodBeat.i(59538);
      for (;;)
      {
        if (this.TDZ.isEmpty())
        {
          AppMethodBeat.o(59538);
          return null;
        }
        p localp = h(u.b((u)this.TDZ.pop()));
        if (localp.size() == 0) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(59538);
          return localp;
        }
      }
    }
    
    public final p hJP()
    {
      AppMethodBeat.i(59539);
      if (this.TEa == null)
      {
        localObject = new NoSuchElementException();
        AppMethodBeat.o(59539);
        throw ((Throwable)localObject);
      }
      Object localObject = this.TEa;
      this.TEa = hJO();
      AppMethodBeat.o(59539);
      return localObject;
    }
    
    public final boolean hasNext()
    {
      return this.TEa != null;
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
    private final u.b TEb;
    private d.a TEc;
    int TEd;
    
    private c()
    {
      AppMethodBeat.i(59542);
      this.TEb = new u.b(u.this, (byte)0);
      this.TEc = this.TEb.hJP().hJm();
      this.TEd = u.this.size();
      AppMethodBeat.o(59542);
    }
    
    public final boolean hasNext()
    {
      return this.TEd > 0;
    }
    
    public final byte nextByte()
    {
      AppMethodBeat.i(59543);
      if (!this.TEc.hasNext()) {
        this.TEc = this.TEb.hJP().hJm();
      }
      this.TEd -= 1;
      byte b = this.TEc.nextByte();
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
    private u.b TEf;
    private p TEg;
    private int TEh;
    private int TEi;
    private int TEj;
    private int mark;
    
    public d()
    {
      AppMethodBeat.i(59546);
      initialize();
      AppMethodBeat.o(59546);
    }
    
    private int W(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(59549);
      int i = paramInt2;
      int j = paramInt1;
      paramInt1 = i;
      for (i = j; paramInt1 > 0; i = j)
      {
        hJQ();
        if (this.TEg == null)
        {
          if (paramInt1 != paramInt2) {
            break;
          }
          AppMethodBeat.o(59549);
          return -1;
        }
        int k = Math.min(this.TEh - this.TEi, paramInt1);
        j = i;
        if (paramArrayOfByte != null)
        {
          this.TEg.j(paramArrayOfByte, this.TEi, i, k);
          j = i + k;
        }
        this.TEi += k;
        paramInt1 -= k;
      }
      AppMethodBeat.o(59549);
      return paramInt2 - paramInt1;
    }
    
    private void hJQ()
    {
      AppMethodBeat.i(59554);
      if ((this.TEg != null) && (this.TEi == this.TEh))
      {
        this.TEj += this.TEh;
        this.TEi = 0;
        if (this.TEf.hasNext())
        {
          this.TEg = this.TEf.hJP();
          this.TEh = this.TEg.size();
          AppMethodBeat.o(59554);
          return;
        }
        this.TEg = null;
        this.TEh = 0;
      }
      AppMethodBeat.o(59554);
    }
    
    private void initialize()
    {
      AppMethodBeat.i(59553);
      this.TEf = new u.b(u.this, (byte)0);
      this.TEg = this.TEf.hJP();
      this.TEh = this.TEg.size();
      this.TEi = 0;
      this.TEj = 0;
      AppMethodBeat.o(59553);
    }
    
    public final int available()
    {
      AppMethodBeat.i(59551);
      int i = this.TEj;
      int j = this.TEi;
      int k = u.this.size();
      AppMethodBeat.o(59551);
      return k - (i + j);
    }
    
    public final void mark(int paramInt)
    {
      this.mark = (this.TEj + this.TEi);
    }
    
    public final boolean markSupported()
    {
      return true;
    }
    
    public final int read()
    {
      AppMethodBeat.i(59550);
      hJQ();
      if (this.TEg == null)
      {
        AppMethodBeat.o(59550);
        return -1;
      }
      p localp = this.TEg;
      int i = this.TEi;
      this.TEi = (i + 1);
      i = localp.fB(i);
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
      paramInt1 = W(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(59547);
      return paramInt1;
    }
    
    public final void reset()
    {
      try
      {
        AppMethodBeat.i(59552);
        initialize();
        W(null, 0, this.mark);
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
      paramLong = W(null, 0, (int)l);
      AppMethodBeat.o(59548);
      return paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.h.u
 * JD-Core Version:    0.7.0.1
 */