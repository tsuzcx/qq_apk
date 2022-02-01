package com.tencent.mm.timelineedit.a.a;

import com.google.d.am.a;
import com.google.d.am.f;
import com.google.d.am.j;
import com.google.d.at;
import com.google.d.bg;
import com.google.d.bg.a;
import com.google.d.bg.b;
import com.google.d.bg.e;
import com.google.d.bg.f;
import com.google.d.bj;
import com.google.d.bk;
import com.google.d.cb;
import com.google.d.ce;
import com.google.d.cs;
import com.google.d.da;
import com.google.d.df;
import com.google.d.dn;
import com.google.d.dn.a;
import com.google.d.i;
import com.google.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c
  extends bg
  implements d
{
  private static final cs<c> PARSER;
  private static final c adpQ;
  private q adpM;
  private List<a> adpN;
  boolean adpO;
  private q adpP;
  private byte memoizedIsInitialized;
  
  static
  {
    AppMethodBeat.i(232203);
    adpQ = new c();
    PARSER = new com.google.d.c() {};
    AppMethodBeat.o(232203);
  }
  
  private c()
  {
    AppMethodBeat.i(232107);
    this.memoizedIsInitialized = -1;
    this.adpN = Collections.emptyList();
    AppMethodBeat.o(232107);
  }
  
  private c(bg.a<?> parama)
  {
    super(parama);
    this.memoizedIsInitialized = -1;
  }
  
  private c(i parami, at paramat)
  {
    this();
    AppMethodBeat.i(232123);
    if (paramat == null)
    {
      parami = new NullPointerException();
      AppMethodBeat.o(232123);
      throw parami;
    }
    dn.a locala1 = dn.ajE();
    int k = 0;
    int i = 0;
    for (;;)
    {
      label38:
      int n;
      int i1;
      int m;
      if (k == 0)
      {
        n = i;
        i1 = i;
        m = i;
      }
      int j;
      for (;;)
      {
        try
        {
          j = parami.aac();
          switch (j)
          {
          case 10: 
            n = i;
            i1 = i;
            m = i;
            if (parseUnknownField(parami, locala1, paramat, j)) {
              break label570;
            }
            j = 1;
            break label592;
            n = i;
            i1 = i;
            m = i;
            if (this.adpM == null) {
              break label583;
            }
            n = i;
            i1 = i;
            m = i;
            locala = this.adpM.jfT();
            n = i;
            i1 = i;
            m = i;
            this.adpM = ((q)parami.a(q.parser(), paramat));
            if (locala == null) {
              break label570;
            }
            n = i;
            i1 = i;
            m = i;
            locala.l(this.adpM);
            n = i;
            i1 = i;
            m = i;
            this.adpM = locala.jfY();
            break label38;
          }
        }
        catch (bk parami)
        {
          try
          {
            parami.dST = this;
            AppMethodBeat.o(232123);
            throw parami;
          }
          finally
          {
            m = n;
            if ((m & 0x1) != 0) {
              this.adpN = Collections.unmodifiableList(this.adpN);
            }
            this.unknownFields = locala1.ajH();
            makeExtensionsImmutable();
            AppMethodBeat.o(232123);
          }
          j = i;
          if ((i & 0x1) == 0)
          {
            n = i;
            i1 = i;
            m = i;
            this.adpN = new ArrayList();
            j = i | 0x1;
          }
          n = j;
          i1 = j;
          m = j;
          this.adpN.add(parami.a(a.parser(), paramat));
          i = j;
          break;
        }
        catch (IOException parami)
        {
          m = i1;
          parami = new bk(parami);
          m = i1;
          parami.dST = this;
          m = i1;
          AppMethodBeat.o(232123);
          m = i1;
          throw parami;
        }
        finally
        {
          continue;
          n = i;
          i1 = i;
          m = i;
          this.adpO = parami.aai();
        }
        break;
        n = i;
        i1 = i;
        m = i;
        if (this.adpP != null)
        {
          n = i;
          i1 = i;
          m = i;
        }
        for (q.a locala = this.adpP.jfT();; locala = null)
        {
          n = i;
          i1 = i;
          m = i;
          this.adpP = ((q)parami.a(q.parser(), paramat));
          if (locala != null)
          {
            n = i;
            i1 = i;
            m = i;
            locala.l(this.adpP);
            n = i;
            i1 = i;
            m = i;
            this.adpP = locala.jfY();
            break;
            if ((i & 0x1) != 0) {
              this.adpN = Collections.unmodifiableList(this.adpN);
            }
            this.unknownFields = locala1.ajH();
            makeExtensionsImmutable();
            AppMethodBeat.o(232123);
            return;
          }
          label570:
          j = k;
          break label592;
        }
        label583:
        locala = null;
      }
      label592:
      k = j;
      continue;
      k = 1;
    }
  }
  
  public static a a(c paramc)
  {
    AppMethodBeat.i(232130);
    paramc = adpQ.jeR().d(paramc);
    AppMethodBeat.o(232130);
    return paramc;
  }
  
  public static c jeS()
  {
    return adpQ;
  }
  
  public static cs<c> parser()
  {
    return PARSER;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(232303);
    if (paramObject == this)
    {
      AppMethodBeat.o(232303);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(232303);
      return bool;
    }
    paramObject = (c)paramObject;
    if (jeN() != paramObject.jeN())
    {
      AppMethodBeat.o(232303);
      return false;
    }
    if ((jeN()) && (!jeO().equals(paramObject.jeO())))
    {
      AppMethodBeat.o(232303);
      return false;
    }
    if (!this.adpN.equals(paramObject.adpN))
    {
      AppMethodBeat.o(232303);
      return false;
    }
    if (this.adpO != paramObject.adpO)
    {
      AppMethodBeat.o(232303);
      return false;
    }
    if (jeP() != paramObject.jeP())
    {
      AppMethodBeat.o(232303);
      return false;
    }
    if ((jeP()) && (!jeQ().equals(paramObject.jeQ())))
    {
      AppMethodBeat.o(232303);
      return false;
    }
    if (!this.unknownFields.equals(paramObject.unknownFields))
    {
      AppMethodBeat.o(232303);
      return false;
    }
    AppMethodBeat.o(232303);
    return true;
  }
  
  public final cs<c> getParserForType()
  {
    return PARSER;
  }
  
  public final int getSerializedSize()
  {
    int j = 0;
    AppMethodBeat.i(232289);
    int i = this.memoizedSize;
    if (i != -1)
    {
      AppMethodBeat.o(232289);
      return i;
    }
    if (this.adpM != null) {
      i = k.c(1, jeO()) + 0;
    }
    for (;;)
    {
      if (j < this.adpN.size())
      {
        int k = k.c(2, (ce)this.adpN.get(j));
        j += 1;
        i = k + i;
      }
      else
      {
        j = i;
        if (this.adpO) {
          j = i + k.kn(3);
        }
        i = j;
        if (this.adpP != null) {
          i = j + k.c(4, jeQ());
        }
        i = this.unknownFields.getSerializedSize() + i;
        this.memoizedSize = i;
        AppMethodBeat.o(232289);
        return i;
        i = 0;
      }
    }
  }
  
  public final dn getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(232315);
    if (this.memoizedHashCode != 0)
    {
      i = this.memoizedHashCode;
      AppMethodBeat.o(232315);
      return i;
    }
    int j = ae.adsp.hashCode() + 779;
    int i = j;
    if (jeN()) {
      i = (j * 37 + 1) * 53 + jeO().hashCode();
    }
    j = i;
    if (this.adpN.size() > 0) {
      j = (i * 37 + 2) * 53 + this.adpN.hashCode();
    }
    j = (j * 37 + 3) * 53 + bj.hashBoolean(this.adpO);
    i = j;
    if (jeP()) {
      i = (j * 37 + 4) * 53 + jeQ().hashCode();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    AppMethodBeat.o(232315);
    return i;
  }
  
  public final bg.e internalGetFieldAccessorTable()
  {
    AppMethodBeat.i(232224);
    bg.e locale = ae.adsq.b(c.class, a.class);
    AppMethodBeat.o(232224);
    return locale;
  }
  
  public final boolean isInitialized()
  {
    int i = this.memoizedIsInitialized;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public final boolean jeN()
  {
    return this.adpM != null;
  }
  
  public final q jeO()
  {
    AppMethodBeat.i(232240);
    if (this.adpM == null)
    {
      localq = q.jfU();
      AppMethodBeat.o(232240);
      return localq;
    }
    q localq = this.adpM;
    AppMethodBeat.o(232240);
    return localq;
  }
  
  public final boolean jeP()
  {
    return this.adpP != null;
  }
  
  public final q jeQ()
  {
    AppMethodBeat.i(232255);
    if (this.adpP == null)
    {
      localq = q.jfU();
      AppMethodBeat.o(232255);
      return localq;
    }
    q localq = this.adpP;
    AppMethodBeat.o(232255);
    return localq;
  }
  
  public final a jeR()
  {
    AppMethodBeat.i(232327);
    if (this == adpQ)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(232327);
      return locala;
    }
    a locala = new a((byte)0).d(this);
    AppMethodBeat.o(232327);
    return locala;
  }
  
  public final Object newInstance(bg.f paramf)
  {
    AppMethodBeat.i(232210);
    paramf = new c();
    AppMethodBeat.o(232210);
    return paramf;
  }
  
  public final void writeTo(k paramk)
  {
    AppMethodBeat.i(232276);
    if (this.adpM != null) {
      paramk.a(1, jeO());
    }
    int i = 0;
    while (i < this.adpN.size())
    {
      paramk.a(2, (ce)this.adpN.get(i));
      i += 1;
    }
    if (this.adpO) {
      paramk.I(3, this.adpO);
    }
    if (this.adpP != null) {
      paramk.a(4, jeQ());
    }
    this.unknownFields.writeTo(paramk);
    AppMethodBeat.o(232276);
  }
  
  public static final class a
    extends bg.a<a>
    implements d
  {
    private q adpM;
    private List<a> adpN;
    private boolean adpO;
    private q adpP;
    private df<q, q.a, r> adpR;
    private da<a, a.a, b> adpS;
    private df<q, q.a, r> adpT;
    private int bitField0_;
    
    private a()
    {
      AppMethodBeat.i(232520);
      this.adpN = Collections.emptyList();
      maybeForceBuilderInitialization();
      AppMethodBeat.o(232520);
    }
    
    private a(bg.b paramb)
    {
      super();
      AppMethodBeat.i(232528);
      this.adpN = Collections.emptyList();
      maybeForceBuilderInitialization();
      AppMethodBeat.o(232528);
    }
    
    private a K(am.f paramf, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(232576);
      paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
      AppMethodBeat.o(232576);
      return paramf;
    }
    
    /* Error */
    private a K(i parami, at paramat)
    {
      // Byte code:
      //   0: ldc 72
      //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 76	com/tencent/mm/timelineedit/a/a/c:jeU	()Lcom/google/d/cs;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 82 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/c
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 86	com/tencent/mm/timelineedit/a/a/c$a:d	(Lcom/tencent/mm/timelineedit/a/a/c;)Lcom/tencent/mm/timelineedit/a/a/c$a;
      //   30: pop
      //   31: ldc 72
      //   33: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 90	com/google/d/bk:dST	Lcom/google/d/ce;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/c
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 94	com/google/d/bk:aii	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 72
      //   54: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 86	com/tencent/mm/timelineedit/a/a/c$a:d	(Lcom/tencent/mm/timelineedit/a/a/c;)Lcom/tencent/mm/timelineedit/a/a/c$a;
      //   69: pop
      //   70: ldc 72
      //   72: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   75: aload_1
      //   76: athrow
      //   77: astore_1
      //   78: aload_3
      //   79: astore_2
      //   80: goto -20 -> 60
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	83	0	this	a
      //   0	83	1	parami	i
      //   0	83	2	paramat	at
      //   6	73	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	21	38	com/google/d/bk
      //   47	59	59	finally
      //   7	21	77	finally
      //   39	47	77	finally
    }
    
    private a KI(boolean paramBoolean)
    {
      AppMethodBeat.i(232622);
      this.adpO = paramBoolean;
      onChanged();
      AppMethodBeat.o(232622);
      return this;
    }
    
    private a L(cb paramcb)
    {
      AppMethodBeat.i(232589);
      if ((paramcb instanceof c))
      {
        paramcb = d((c)paramcb);
        AppMethodBeat.o(232589);
        return paramcb;
      }
      super.mergeFrom(paramcb);
      AppMethodBeat.o(232589);
      return this;
    }
    
    private a O(am.j paramj)
    {
      AppMethodBeat.i(232570);
      paramj = (a)super.clearOneof(paramj);
      AppMethodBeat.o(232570);
      return paramj;
    }
    
    private a S(am.f paramf)
    {
      AppMethodBeat.i(232566);
      paramf = (a)super.clearField(paramf);
      AppMethodBeat.o(232566);
      return paramf;
    }
    
    private a aw(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232558);
      paramf = (a)super.setField(paramf, paramObject);
      AppMethodBeat.o(232558);
      return paramf;
    }
    
    private a ax(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232583);
      paramf = (a)super.addRepeatedField(paramf, paramObject);
      AppMethodBeat.o(232583);
      return paramf;
    }
    
    private a ay(dn paramdn)
    {
      AppMethodBeat.i(232632);
      paramdn = (a)super.setUnknownFields(paramdn);
      AppMethodBeat.o(232632);
      return paramdn;
    }
    
    private a az(dn paramdn)
    {
      AppMethodBeat.i(232635);
      paramdn = (a)super.mergeUnknownFields(paramdn);
      AppMethodBeat.o(232635);
      return paramdn;
    }
    
    private a b(q paramq)
    {
      AppMethodBeat.i(232606);
      if (this.adpR == null) {
        if (this.adpM != null)
        {
          this.adpM = q.j(this.adpM).l(paramq).jfY();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(232606);
        return this;
        this.adpM = paramq;
        break;
        this.adpR.c(paramq);
      }
    }
    
    private a c(q paramq)
    {
      AppMethodBeat.i(232627);
      if (this.adpT == null) {
        if (this.adpP != null)
        {
          this.adpP = q.j(this.adpP).l(paramq).jfY();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(232627);
        return this;
        this.adpP = paramq;
        break;
        this.adpT.c(paramq);
      }
    }
    
    private a jeV()
    {
      AppMethodBeat.i(232546);
      super.clear();
      if (this.adpR == null)
      {
        this.adpM = null;
        if (this.adpS != null) {
          break label84;
        }
        this.adpN = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
        label47:
        this.adpO = false;
        if (this.adpT != null) {
          break label94;
        }
        this.adpP = null;
      }
      for (;;)
      {
        AppMethodBeat.o(232546);
        return this;
        this.adpM = null;
        this.adpR = null;
        break;
        label84:
        this.adpS.clear();
        break label47;
        label94:
        this.adpP = null;
        this.adpT = null;
      }
    }
    
    private c jeW()
    {
      AppMethodBeat.i(232552);
      Object localObject = jeX();
      if (!((c)localObject).isInitialized())
      {
        localObject = newUninitializedMessageException((cb)localObject);
        AppMethodBeat.o(232552);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(232552);
      return localObject;
    }
    
    private void jeY()
    {
      AppMethodBeat.i(232612);
      if ((this.bitField0_ & 0x1) == 0)
      {
        this.adpN = new ArrayList(this.adpN);
        this.bitField0_ |= 0x1;
      }
      AppMethodBeat.o(232612);
    }
    
    private da<a, a.a, b> jeZ()
    {
      AppMethodBeat.i(232617);
      Object localObject;
      if (this.adpS == null)
      {
        localObject = this.adpN;
        if ((this.bitField0_ & 0x1) == 0) {
          break label66;
        }
      }
      label66:
      for (boolean bool = true;; bool = false)
      {
        this.adpS = new da((List)localObject, bool, getParentForChildren(), isClean());
        this.adpN = null;
        localObject = this.adpS;
        AppMethodBeat.o(232617);
        return localObject;
      }
    }
    
    private void maybeForceBuilderInitialization()
    {
      AppMethodBeat.i(232535);
      if (c.ayB()) {
        jeZ();
      }
      AppMethodBeat.o(232535);
    }
    
    public final a d(c paramc)
    {
      da localda = null;
      AppMethodBeat.i(232714);
      if (paramc == c.jeS())
      {
        AppMethodBeat.o(232714);
        return this;
      }
      if (paramc.jeN()) {
        b(paramc.jeO());
      }
      if (this.adpS == null) {
        if (!c.b(paramc).isEmpty())
        {
          if (!this.adpN.isEmpty()) {
            break label146;
          }
          this.adpN = c.b(paramc);
          this.bitField0_ &= 0xFFFFFFFE;
          onChanged();
        }
      }
      for (;;)
      {
        if (paramc.adpO) {
          KI(paramc.adpO);
        }
        if (paramc.jeP()) {
          c(paramc.jeQ());
        }
        az(c.c(paramc));
        onChanged();
        AppMethodBeat.o(232714);
        return this;
        label146:
        jeY();
        this.adpN.addAll(c.b(paramc));
        break;
        if (!c.b(paramc).isEmpty()) {
          if (this.adpS.isEmpty())
          {
            this.adpS.dUC = null;
            this.adpS = null;
            this.adpN = c.b(paramc);
            this.bitField0_ &= 0xFFFFFFFE;
            if (c.jeT()) {
              localda = jeZ();
            }
            this.adpS = localda;
          }
          else
          {
            this.adpS.a(c.b(paramc));
          }
        }
      }
    }
    
    public final am.a getDescriptorForType()
    {
      return ae.adsp;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(232690);
      bg.e locale = ae.adsq.b(c.class, a.class);
      AppMethodBeat.o(232690);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public final c jeX()
    {
      AppMethodBeat.i(232702);
      c localc = new c(this, (byte)0);
      if (this.adpR == null)
      {
        c.a(localc, this.adpM);
        if (this.adpS != null) {
          break label134;
        }
        if ((this.bitField0_ & 0x1) != 0)
        {
          this.adpN = Collections.unmodifiableList(this.adpN);
          this.bitField0_ &= 0xFFFFFFFE;
        }
        c.a(localc, this.adpN);
        label79:
        c.a(localc, this.adpO);
        if (this.adpT != null) {
          break label149;
        }
        c.b(localc, this.adpP);
      }
      for (;;)
      {
        onBuilt();
        AppMethodBeat.o(232702);
        return localc;
        c.a(localc, (q)this.adpR.ajn());
        break;
        label134:
        c.a(localc, this.adpS.build());
        break label79;
        label149:
        c.b(localc, (q)this.adpT.ajn());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.c
 * JD-Core Version:    0.7.0.1
 */