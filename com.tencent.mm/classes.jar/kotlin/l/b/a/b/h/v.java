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
  private static final int[] abgB;
  private final int abgC;
  private final d abgD;
  private final d abgE;
  private final int abgF;
  private final int abgG;
  private int bPh;
  
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
    abgB = new int[localArrayList.size()];
    i = 0;
    while (i < abgB.length)
    {
      abgB[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    AppMethodBeat.o(59569);
  }
  
  private v(d paramd1, d paramd2)
  {
    AppMethodBeat.i(59555);
    this.bPh = 0;
    this.abgD = paramd1;
    this.abgE = paramd2;
    this.abgF = paramd1.size();
    this.abgC = (this.abgF + paramd2.size());
    this.abgG = (Math.max(paramd1.iNI(), paramd2.iNI()) + 1);
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
      if ((localObject != null) && (((v)localObject).abgE.size() + paramd2.size() < 128))
      {
        paramd1 = b(((v)localObject).abgE, paramd2);
        paramd1 = new v(((v)localObject).abgD, paramd1);
      }
      else if ((localObject != null) && (((v)localObject).abgD.iNI() > ((v)localObject).abgE.iNI()) && (((v)localObject).abgG > paramd2.iNI()))
      {
        paramd1 = new v(((v)localObject).abgE, paramd2);
        paramd1 = new v(((v)localObject).abgD, paramd1);
      }
      else
      {
        int j = Math.max(paramd1.iNI(), paramd2.iNI());
        if (i >= abgB[(j + 1)])
        {
          paramd1 = new v(paramd1, paramd2);
        }
        else
        {
          localObject = new a((byte)0);
          ((a)localObject).g(paramd1);
          ((a)localObject).g(paramd2);
          for (paramd2 = (d)((a)localObject).abgH.pop();; paramd2 = new v((d)((a)localObject).abgH.pop(), paramd2, (byte)0))
          {
            paramd1 = paramd2;
            if (((a)localObject).abgH.isEmpty()) {
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
    paramd1.k(arrayOfByte, 0, 0, i);
    paramd2.k(arrayOfByte, 0, i, j);
    paramd1 = new q(arrayOfByte);
    AppMethodBeat.o(59557);
    return paramd1;
  }
  
  public final boolean Aq()
  {
    AppMethodBeat.i(59561);
    int i = this.abgD.bn(0, 0, this.abgF);
    if (this.abgE.bn(i, 0, this.abgE.size()) == 0)
    {
      AppMethodBeat.o(59561);
      return true;
    }
    AppMethodBeat.o(59561);
    return false;
  }
  
  protected final int As()
  {
    return this.bPh;
  }
  
  final void b(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59559);
    if (paramInt1 + paramInt2 <= this.abgF)
    {
      this.abgD.b(paramOutputStream, paramInt1, paramInt2);
      AppMethodBeat.o(59559);
      return;
    }
    if (paramInt1 >= this.abgF)
    {
      this.abgE.b(paramOutputStream, paramInt1 - this.abgF, paramInt2);
      AppMethodBeat.o(59559);
      return;
    }
    int i = this.abgF - paramInt1;
    this.abgD.b(paramOutputStream, paramInt1, i);
    this.abgE.b(paramOutputStream, 0, paramInt2 - i);
    AppMethodBeat.o(59559);
  }
  
  protected final int bn(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(59562);
    if (paramInt2 + paramInt3 <= this.abgF)
    {
      paramInt1 = this.abgD.bn(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(59562);
      return paramInt1;
    }
    if (paramInt2 >= this.abgF)
    {
      paramInt1 = this.abgE.bn(paramInt1, paramInt2 - this.abgF, paramInt3);
      AppMethodBeat.o(59562);
      return paramInt1;
    }
    int i = this.abgF - paramInt2;
    paramInt1 = this.abgD.bn(paramInt1, paramInt2, i);
    paramInt1 = this.abgE.bn(paramInt1, 0, paramInt3 - i);
    AppMethodBeat.o(59562);
    return paramInt1;
  }
  
  protected final int bo(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(59565);
    if (paramInt2 + paramInt3 <= this.abgF)
    {
      paramInt1 = this.abgD.bo(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(59565);
      return paramInt1;
    }
    if (paramInt2 >= this.abgF)
    {
      paramInt1 = this.abgE.bo(paramInt1, paramInt2 - this.abgF, paramInt3);
      AppMethodBeat.o(59565);
      return paramInt1;
    }
    int i = this.abgF - paramInt2;
    paramInt1 = this.abgD.bo(paramInt1, paramInt2, i);
    paramInt1 = this.abgE.bo(paramInt1, 0, paramInt3 - i);
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
    if (this.abgC != paramObject.size())
    {
      AppMethodBeat.o(59563);
      return false;
    }
    if (this.abgC == 0)
    {
      AppMethodBeat.o(59563);
      return true;
    }
    if (this.bPh != 0)
    {
      i = paramObject.As();
      if ((i != 0) && (this.bPh != i))
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
      if (k >= this.abgC)
      {
        if (k == this.abgC)
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
    int j = this.bPh;
    int i = j;
    if (j == 0)
    {
      j = bo(this.abgC, 0, this.abgC);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.bPh = i;
    }
    AppMethodBeat.o(59564);
    return i;
  }
  
  public final d.a iNG()
  {
    AppMethodBeat.i(59567);
    c localc = new c((byte)0);
    AppMethodBeat.o(59567);
    return localc;
  }
  
  protected final int iNI()
  {
    return this.abgG;
  }
  
  protected final boolean iNJ()
  {
    return this.abgC >= abgB[this.abgG];
  }
  
  protected final void m(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(59558);
    if (paramInt1 + paramInt3 <= this.abgF)
    {
      this.abgD.m(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(59558);
      return;
    }
    if (paramInt1 >= this.abgF)
    {
      this.abgE.m(paramArrayOfByte, paramInt1 - this.abgF, paramInt2, paramInt3);
      AppMethodBeat.o(59558);
      return;
    }
    int i = this.abgF - paramInt1;
    this.abgD.m(paramArrayOfByte, paramInt1, paramInt2, i);
    this.abgE.m(paramArrayOfByte, 0, paramInt2 + i, paramInt3 - i);
    AppMethodBeat.o(59558);
  }
  
  public final int size()
  {
    return this.abgC;
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
    final Stack<d> abgH;
    
    private a()
    {
      AppMethodBeat.i(59533);
      this.abgH = new Stack();
      AppMethodBeat.o(59533);
    }
    
    private static int aFx(int paramInt)
    {
      AppMethodBeat.i(59535);
      int i = Arrays.binarySearch(v.iOe(), paramInt);
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
        if (paramd.iNJ())
        {
          int i = aFx(paramd.size());
          int j = v.iOe()[(i + 1)];
          if ((this.abgH.isEmpty()) || (((d)this.abgH.peek()).size() >= j))
          {
            this.abgH.push(paramd);
            AppMethodBeat.o(59534);
            return;
          }
          i = v.iOe()[i];
          for (Object localObject = (d)this.abgH.pop(); (!this.abgH.isEmpty()) && (((d)this.abgH.peek()).size() < i); localObject = new v((d)this.abgH.pop(), (d)localObject, (byte)0)) {}
          for (paramd = new v((d)localObject, paramd, (byte)0); !this.abgH.isEmpty(); paramd = new v((d)this.abgH.pop(), paramd, (byte)0))
          {
            i = aFx(paramd.size());
            i = v.iOe()[(i + 1)];
            if (((d)this.abgH.peek()).size() >= i) {
              break;
            }
          }
          this.abgH.push(paramd);
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
    private final Stack<v> abgI;
    private q abgJ;
    
    private b(d paramd)
    {
      AppMethodBeat.i(59536);
      this.abgI = new Stack();
      this.abgJ = h(paramd);
      AppMethodBeat.o(59536);
    }
    
    private q h(d paramd)
    {
      AppMethodBeat.i(59537);
      while ((paramd instanceof v))
      {
        paramd = (v)paramd;
        this.abgI.push(paramd);
        paramd = v.a(paramd);
      }
      paramd = (q)paramd;
      AppMethodBeat.o(59537);
      return paramd;
    }
    
    private q iOf()
    {
      AppMethodBeat.i(59538);
      for (;;)
      {
        if (this.abgI.isEmpty())
        {
          AppMethodBeat.o(59538);
          return null;
        }
        q localq = h(v.b((v)this.abgI.pop()));
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
      return this.abgJ != null;
    }
    
    public final q iOg()
    {
      AppMethodBeat.i(59539);
      if (this.abgJ == null)
      {
        localObject = new NoSuchElementException();
        AppMethodBeat.o(59539);
        throw ((Throwable)localObject);
      }
      Object localObject = this.abgJ;
      this.abgJ = iOf();
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
    private final v.b abgK;
    private d.a abgL;
    int abgM;
    
    private c()
    {
      AppMethodBeat.i(59542);
      this.abgK = new v.b(v.this, (byte)0);
      this.abgL = this.abgK.iOg().iNG();
      this.abgM = v.this.size();
      AppMethodBeat.o(59542);
    }
    
    public final boolean hasNext()
    {
      return this.abgM > 0;
    }
    
    public final byte nextByte()
    {
      AppMethodBeat.i(59543);
      if (!this.abgL.hasNext()) {
        this.abgL = this.abgK.iOg().iNG();
      }
      this.abgM -= 1;
      byte b = this.abgL.nextByte();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.h.v
 * JD-Core Version:    0.7.0.1
 */