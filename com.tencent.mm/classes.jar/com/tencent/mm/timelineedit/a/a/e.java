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

public final class e
  extends bg
  implements f
{
  private static final cs<e> PARSER;
  private static final e adqe;
  private q adpP;
  private List<aa> adpU;
  long adpV;
  long adpW;
  boolean adpX;
  private c adpY;
  private List<l> adpZ;
  private af adqa;
  boolean adqb;
  private List<g> adqc;
  private q adqd;
  private byte memoizedIsInitialized;
  
  static
  {
    AppMethodBeat.i(232356);
    adqe = new e();
    PARSER = new com.google.d.c() {};
    AppMethodBeat.o(232356);
  }
  
  private e()
  {
    AppMethodBeat.i(232135);
    this.memoizedIsInitialized = -1;
    this.adpU = Collections.emptyList();
    this.adpZ = Collections.emptyList();
    this.adqc = Collections.emptyList();
    AppMethodBeat.o(232135);
  }
  
  private e(bg.a<?> parama)
  {
    super(parama);
    this.memoizedIsInitialized = -1;
  }
  
  private e(i parami, at paramat)
  {
    this();
    AppMethodBeat.i(232158);
    if (paramat == null)
    {
      parami = new NullPointerException();
      AppMethodBeat.o(232158);
      throw parami;
    }
    dn.a locala = dn.ajE();
    int i1 = 0;
    int i = 0;
    for (;;)
    {
      label38:
      int k;
      int m;
      int j;
      if (i1 == 0)
      {
        k = i;
        m = i;
        j = i;
      }
      for (;;)
      {
        int n;
        try
        {
          n = parami.aac();
          switch (n)
          {
          case 10: 
            k = i;
            m = i;
            j = i;
            if (parseUnknownField(parami, locala, paramat, n)) {
              break label1102;
            }
            j = 1;
            break label1136;
            n = i;
            if ((i & 0x1) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.adpU = new ArrayList();
              n = i | 0x1;
            }
            k = n;
            m = n;
            j = n;
            this.adpU.add(parami.a(aa.parser(), paramat));
            i = n;
            break label38;
          }
        }
        catch (bk parami)
        {
          try
          {
            parami.dST = this;
            AppMethodBeat.o(232158);
            throw parami;
          }
          finally
          {
            j = k;
            if ((j & 0x1) != 0) {
              this.adpU = Collections.unmodifiableList(this.adpU);
            }
            if ((j & 0x2) != 0) {
              this.adpZ = Collections.unmodifiableList(this.adpZ);
            }
            if ((j & 0x4) != 0) {
              this.adqc = Collections.unmodifiableList(this.adqc);
            }
            this.unknownFields = locala.ajH();
            makeExtensionsImmutable();
            AppMethodBeat.o(232158);
          }
          k = i;
          m = i;
          j = i;
          this.adpV = parami.aae();
          break;
        }
        catch (IOException parami)
        {
          j = m;
          parami = new bk(parami);
          j = m;
          parami.dST = this;
          j = m;
          AppMethodBeat.o(232158);
          j = m;
          throw parami;
        }
        finally
        {
          continue;
          k = i;
          m = i;
          j = i;
          this.adpW = parami.aae();
        }
        break;
        k = i;
        m = i;
        j = i;
        this.adpX = parami.aai();
        break;
        k = i;
        m = i;
        j = i;
        if (this.adpY != null)
        {
          k = i;
          m = i;
          j = i;
        }
        for (Object localObject = this.adpY.jeR();; localObject = null)
        {
          k = i;
          m = i;
          j = i;
          this.adpY = ((c)parami.a(c.parser(), paramat));
          if (localObject != null)
          {
            k = i;
            m = i;
            j = i;
            ((c.a)localObject).d(this.adpY);
            k = i;
            m = i;
            j = i;
            this.adpY = ((c.a)localObject).jeX();
            break;
            n = i;
            if ((i & 0x2) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.adpZ = new ArrayList();
              n = i | 0x2;
            }
            k = n;
            m = n;
            j = n;
            this.adpZ.add(parami.a(l.parser(), paramat));
            i = n;
            break;
            k = i;
            m = i;
            j = i;
            if (this.adqa == null) {
              break label1121;
            }
            k = i;
            m = i;
            j = i;
          }
          label1102:
          label1109:
          label1115:
          label1121:
          for (localObject = this.adqa.jgX();; localObject = null)
          {
            k = i;
            m = i;
            j = i;
            this.adqa = ((af)parami.a(af.parser(), paramat));
            if (localObject != null)
            {
              k = i;
              m = i;
              j = i;
              ((af.a)localObject).f(this.adqa);
              k = i;
              m = i;
              j = i;
              this.adqa = ((af.a)localObject).jhb();
              break;
              k = i;
              m = i;
              j = i;
              this.adqb = parami.aai();
              break;
              n = i;
              if ((i & 0x4) == 0)
              {
                k = i;
                m = i;
                j = i;
                this.adqc = new ArrayList();
                n = i | 0x4;
              }
              k = n;
              m = n;
              j = n;
              this.adqc.add(parami.a(g.parser(), paramat));
              i = n;
              break;
              k = i;
              m = i;
              j = i;
              if (this.adqd == null) {
                break label1115;
              }
              k = i;
              m = i;
              j = i;
            }
            for (localObject = this.adqd.jfT();; localObject = null)
            {
              k = i;
              m = i;
              j = i;
              this.adqd = ((q)parami.a(q.parser(), paramat));
              if (localObject != null)
              {
                k = i;
                m = i;
                j = i;
                ((q.a)localObject).l(this.adqd);
                k = i;
                m = i;
                j = i;
                this.adqd = ((q.a)localObject).jfY();
                break;
                k = i;
                m = i;
                j = i;
                if (this.adpP == null) {
                  break label1109;
                }
                k = i;
                m = i;
                j = i;
              }
              for (localObject = this.adpP.jfT();; localObject = null)
              {
                k = i;
                m = i;
                j = i;
                this.adpP = ((q)parami.a(q.parser(), paramat));
                if (localObject != null)
                {
                  k = i;
                  m = i;
                  j = i;
                  ((q.a)localObject).l(this.adpP);
                  k = i;
                  m = i;
                  j = i;
                  this.adpP = ((q.a)localObject).jfY();
                  break;
                  if ((i & 0x1) != 0) {
                    this.adpU = Collections.unmodifiableList(this.adpU);
                  }
                  if ((i & 0x2) != 0) {
                    this.adpZ = Collections.unmodifiableList(this.adpZ);
                  }
                  if ((i & 0x4) != 0) {
                    this.adqc = Collections.unmodifiableList(this.adqc);
                  }
                  this.unknownFields = locala.ajH();
                  makeExtensionsImmutable();
                  AppMethodBeat.o(232158);
                  return;
                }
                j = i1;
                break label1136;
              }
            }
          }
        }
      }
      label1136:
      i1 = j;
      continue;
      i1 = 1;
    }
  }
  
  public static e dk(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(232166);
    paramArrayOfByte = (e)PARSER.parseFrom(paramArrayOfByte);
    AppMethodBeat.o(232166);
    return paramArrayOfByte;
  }
  
  private a jfi()
  {
    AppMethodBeat.i(232175);
    if (this == adqe)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(232175);
      return locala;
    }
    a locala = new a((byte)0).e(this);
    AppMethodBeat.o(232175);
    return locala;
  }
  
  public static e jfj()
  {
    return adqe;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(232728);
    if (paramObject == this)
    {
      AppMethodBeat.o(232728);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(232728);
      return bool;
    }
    paramObject = (e)paramObject;
    if (!this.adpU.equals(paramObject.adpU))
    {
      AppMethodBeat.o(232728);
      return false;
    }
    if (this.adpV != paramObject.adpV)
    {
      AppMethodBeat.o(232728);
      return false;
    }
    if (this.adpW != paramObject.adpW)
    {
      AppMethodBeat.o(232728);
      return false;
    }
    if (this.adpX != paramObject.adpX)
    {
      AppMethodBeat.o(232728);
      return false;
    }
    if (jfc() != paramObject.jfc())
    {
      AppMethodBeat.o(232728);
      return false;
    }
    if ((jfc()) && (!jfd().equals(paramObject.jfd())))
    {
      AppMethodBeat.o(232728);
      return false;
    }
    if (!this.adpZ.equals(paramObject.adpZ))
    {
      AppMethodBeat.o(232728);
      return false;
    }
    if (jfe() != paramObject.jfe())
    {
      AppMethodBeat.o(232728);
      return false;
    }
    if ((jfe()) && (!jff().equals(paramObject.jff())))
    {
      AppMethodBeat.o(232728);
      return false;
    }
    if (this.adqb != paramObject.adqb)
    {
      AppMethodBeat.o(232728);
      return false;
    }
    if (!this.adqc.equals(paramObject.adqc))
    {
      AppMethodBeat.o(232728);
      return false;
    }
    if (jfg() != paramObject.jfg())
    {
      AppMethodBeat.o(232728);
      return false;
    }
    if ((jfg()) && (!jfh().equals(paramObject.jfh())))
    {
      AppMethodBeat.o(232728);
      return false;
    }
    if (jeP() != paramObject.jeP())
    {
      AppMethodBeat.o(232728);
      return false;
    }
    if ((jeP()) && (!jeQ().equals(paramObject.jeQ())))
    {
      AppMethodBeat.o(232728);
      return false;
    }
    if (!this.unknownFields.equals(paramObject.unknownFields))
    {
      AppMethodBeat.o(232728);
      return false;
    }
    AppMethodBeat.o(232728);
    return true;
  }
  
  public final cs<e> getParserForType()
  {
    return PARSER;
  }
  
  public final int getSerializedSize()
  {
    int m = 0;
    AppMethodBeat.i(232711);
    int i = this.memoizedSize;
    if (i != -1)
    {
      AppMethodBeat.o(232711);
      return i;
    }
    int j = 0;
    i = 0;
    while (j < this.adpU.size())
    {
      i += k.c(1, (ce)this.adpU.get(j));
      j += 1;
    }
    j = i;
    if (this.adpV != 0L) {
      j = i + k.q(2, this.adpV);
    }
    i = j;
    if (this.adpW != 0L) {
      i = j + k.q(3, this.adpW);
    }
    j = i;
    if (this.adpX) {
      j = i + k.kn(4);
    }
    i = j;
    if (this.adpY != null) {
      i = j + k.c(5, jfd());
    }
    j = 0;
    while (j < this.adpZ.size())
    {
      i += k.c(6, (ce)this.adpZ.get(j));
      j += 1;
    }
    j = i;
    if (this.adqa != null) {
      j = i + k.c(7, jff());
    }
    int k = m;
    i = j;
    if (this.adqb)
    {
      i = j + k.kn(8);
      k = m;
    }
    while (k < this.adqc.size())
    {
      i += k.c(9, (ce)this.adqc.get(k));
      k += 1;
    }
    j = i;
    if (this.adqd != null) {
      j = i + k.c(10, jfh());
    }
    i = j;
    if (this.adpP != null) {
      i = j + k.c(11, jeQ());
    }
    i = this.unknownFields.getSerializedSize() + i;
    this.memoizedSize = i;
    AppMethodBeat.o(232711);
    return i;
  }
  
  public final dn getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(232746);
    if (this.memoizedHashCode != 0)
    {
      i = this.memoizedHashCode;
      AppMethodBeat.o(232746);
      return i;
    }
    int j = ae.adsx.hashCode() + 779;
    int i = j;
    if (this.adpU.size() > 0) {
      i = (j * 37 + 1) * 53 + this.adpU.hashCode();
    }
    j = (((((i * 37 + 2) * 53 + bj.hashLong(this.adpV)) * 37 + 3) * 53 + bj.hashLong(this.adpW)) * 37 + 4) * 53 + bj.hashBoolean(this.adpX);
    i = j;
    if (jfc()) {
      i = (j * 37 + 5) * 53 + jfd().hashCode();
    }
    j = i;
    if (this.adpZ.size() > 0) {
      j = (i * 37 + 6) * 53 + this.adpZ.hashCode();
    }
    i = j;
    if (jfe()) {
      i = (j * 37 + 7) * 53 + jff().hashCode();
    }
    j = (i * 37 + 8) * 53 + bj.hashBoolean(this.adqb);
    i = j;
    if (this.adqc.size() > 0) {
      i = (j * 37 + 9) * 53 + this.adqc.hashCode();
    }
    j = i;
    if (jfg()) {
      j = (i * 37 + 10) * 53 + jfh().hashCode();
    }
    i = j;
    if (jeP()) {
      i = (j * 37 + 11) * 53 + jeQ().hashCode();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    AppMethodBeat.o(232746);
    return i;
  }
  
  public final bg.e internalGetFieldAccessorTable()
  {
    AppMethodBeat.i(232386);
    bg.e locale = ae.adsy.b(e.class, a.class);
    AppMethodBeat.o(232386);
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
  
  public final boolean jeP()
  {
    return this.adpP != null;
  }
  
  public final q jeQ()
  {
    AppMethodBeat.i(232688);
    if (this.adpP == null)
    {
      localq = q.jfU();
      AppMethodBeat.o(232688);
      return localq;
    }
    q localq = this.adpP;
    AppMethodBeat.o(232688);
    return localq;
  }
  
  public final List<aa> jfa()
  {
    return this.adpU;
  }
  
  public final boolean jfb()
  {
    return this.adpX;
  }
  
  public final boolean jfc()
  {
    return this.adpY != null;
  }
  
  public final c jfd()
  {
    AppMethodBeat.i(232409);
    if (this.adpY == null)
    {
      localc = c.jeS();
      AppMethodBeat.o(232409);
      return localc;
    }
    c localc = this.adpY;
    AppMethodBeat.o(232409);
    return localc;
  }
  
  public final boolean jfe()
  {
    return this.adqa != null;
  }
  
  public final af jff()
  {
    AppMethodBeat.i(232425);
    if (this.adqa == null)
    {
      localaf = af.jgY();
      AppMethodBeat.o(232425);
      return localaf;
    }
    af localaf = this.adqa;
    AppMethodBeat.o(232425);
    return localaf;
  }
  
  public final boolean jfg()
  {
    return this.adqd != null;
  }
  
  public final q jfh()
  {
    AppMethodBeat.i(232438);
    if (this.adqd == null)
    {
      localq = q.jfU();
      AppMethodBeat.o(232438);
      return localq;
    }
    q localq = this.adqd;
    AppMethodBeat.o(232438);
    return localq;
  }
  
  public final Object newInstance(bg.f paramf)
  {
    AppMethodBeat.i(232369);
    paramf = new e();
    AppMethodBeat.o(232369);
    return paramf;
  }
  
  public final void writeTo(k paramk)
  {
    int j = 0;
    AppMethodBeat.i(232698);
    int i = 0;
    while (i < this.adpU.size())
    {
      paramk.a(1, (ce)this.adpU.get(i));
      i += 1;
    }
    if (this.adpV != 0L) {
      paramk.n(2, this.adpV);
    }
    if (this.adpW != 0L) {
      paramk.n(3, this.adpW);
    }
    if (this.adpX) {
      paramk.I(4, this.adpX);
    }
    if (this.adpY != null) {
      paramk.a(5, jfd());
    }
    i = 0;
    while (i < this.adpZ.size())
    {
      paramk.a(6, (ce)this.adpZ.get(i));
      i += 1;
    }
    if (this.adqa != null) {
      paramk.a(7, jff());
    }
    i = j;
    if (this.adqb)
    {
      paramk.I(8, this.adqb);
      i = j;
    }
    while (i < this.adqc.size())
    {
      paramk.a(9, (ce)this.adqc.get(i));
      i += 1;
    }
    if (this.adqd != null) {
      paramk.a(10, jfh());
    }
    if (this.adpP != null) {
      paramk.a(11, jeQ());
    }
    this.unknownFields.writeTo(paramk);
    AppMethodBeat.o(232698);
  }
  
  public static final class a
    extends bg.a<a>
    implements f
  {
    private q adpP;
    private df<q, q.a, r> adpT;
    private List<aa> adpU;
    private long adpV;
    private long adpW;
    private boolean adpX;
    private c adpY;
    private List<l> adpZ;
    private af adqa;
    private boolean adqb;
    private List<g> adqc;
    private q adqd;
    private da<aa, aa.a, ab> adqf;
    private df<c, c.a, d> adqg;
    private da<l, l.a, m> adqh;
    private df<af, af.a, ag> adqi;
    private da<g, g.a, h> adqj;
    private df<q, q.a, r> adqk;
    private int bitField0_;
    
    private a()
    {
      AppMethodBeat.i(232440);
      this.adpU = Collections.emptyList();
      this.adpZ = Collections.emptyList();
      this.adqc = Collections.emptyList();
      maybeForceBuilderInitialization();
      AppMethodBeat.o(232440);
    }
    
    private a(bg.b paramb)
    {
      super();
      AppMethodBeat.i(232446);
      this.adpU = Collections.emptyList();
      this.adpZ = Collections.emptyList();
      this.adqc = Collections.emptyList();
      maybeForceBuilderInitialization();
      AppMethodBeat.o(232446);
    }
    
    private a KJ(boolean paramBoolean)
    {
      AppMethodBeat.i(232565);
      this.adpX = paramBoolean;
      onChanged();
      AppMethodBeat.o(232565);
      return this;
    }
    
    private a KK(boolean paramBoolean)
    {
      AppMethodBeat.i(232595);
      this.adqb = paramBoolean;
      onChanged();
      AppMethodBeat.o(232595);
      return this;
    }
    
    private a L(am.f paramf, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(232510);
      paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
      AppMethodBeat.o(232510);
      return paramf;
    }
    
    /* Error */
    private a L(i parami, at paramat)
    {
      // Byte code:
      //   0: ldc 108
      //   2: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 112	com/tencent/mm/timelineedit/a/a/e:jfm	()Lcom/google/d/cs;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 118 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/e
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 122	com/tencent/mm/timelineedit/a/a/e$a:e	(Lcom/tencent/mm/timelineedit/a/a/e;)Lcom/tencent/mm/timelineedit/a/a/e$a;
      //   30: pop
      //   31: ldc 108
      //   33: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 126	com/google/d/bk:dST	Lcom/google/d/ce;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/e
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 130	com/google/d/bk:aii	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 108
      //   54: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 122	com/tencent/mm/timelineedit/a/a/e$a:e	(Lcom/tencent/mm/timelineedit/a/a/e;)Lcom/tencent/mm/timelineedit/a/a/e$a;
      //   69: pop
      //   70: ldc 108
      //   72: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    private a M(cb paramcb)
    {
      AppMethodBeat.i(232524);
      if ((paramcb instanceof e))
      {
        paramcb = e((e)paramcb);
        AppMethodBeat.o(232524);
        return paramcb;
      }
      super.mergeFrom(paramcb);
      AppMethodBeat.o(232524);
      return this;
    }
    
    private a P(am.j paramj)
    {
      AppMethodBeat.i(232505);
      paramj = (a)super.clearOneof(paramj);
      AppMethodBeat.o(232505);
      return paramj;
    }
    
    private a T(am.f paramf)
    {
      AppMethodBeat.i(232497);
      paramf = (a)super.clearField(paramf);
      AppMethodBeat.o(232497);
      return paramf;
    }
    
    private a a(af paramaf)
    {
      AppMethodBeat.i(232591);
      if (this.adqi == null) {
        if (this.adqa != null)
        {
          this.adqa = af.b(this.adqa).f(paramaf).jhb();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(232591);
        return this;
        this.adqa = paramaf;
        break;
        this.adqi.c(paramaf);
      }
    }
    
    private a aA(dn paramdn)
    {
      AppMethodBeat.i(232625);
      paramdn = (a)super.setUnknownFields(paramdn);
      AppMethodBeat.o(232625);
      return paramdn;
    }
    
    private a aB(dn paramdn)
    {
      AppMethodBeat.i(232629);
      paramdn = (a)super.mergeUnknownFields(paramdn);
      AppMethodBeat.o(232629);
      return paramdn;
    }
    
    private a ay(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232491);
      paramf = (a)super.setField(paramf, paramObject);
      AppMethodBeat.o(232491);
      return paramf;
    }
    
    private a az(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232516);
      paramf = (a)super.addRepeatedField(paramf, paramObject);
      AppMethodBeat.o(232516);
      return paramf;
    }
    
    private a d(q paramq)
    {
      AppMethodBeat.i(232614);
      if (this.adqk == null) {
        if (this.adqd != null)
        {
          this.adqd = q.j(this.adqd).l(paramq).jfY();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(232614);
        return this;
        this.adqd = paramq;
        break;
        this.adqk.c(paramq);
      }
    }
    
    private a e(c paramc)
    {
      AppMethodBeat.i(232571);
      if (this.adqg == null) {
        if (this.adpY != null)
        {
          this.adpY = c.a(this.adpY).d(paramc).jeX();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(232571);
        return this;
        this.adpY = paramc;
        break;
        this.adqg.c(paramc);
      }
    }
    
    private a e(q paramq)
    {
      AppMethodBeat.i(232619);
      if (this.adpT == null) {
        if (this.adpP != null)
        {
          this.adpP = q.j(this.adpP).l(paramq).jfY();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(232619);
        return this;
        this.adpP = paramq;
        break;
        this.adpT.c(paramq);
      }
    }
    
    private a jfn()
    {
      AppMethodBeat.i(232462);
      super.clear();
      if (this.adqf == null)
      {
        this.adpU = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
        this.adpV = 0L;
        this.adpW = 0L;
        this.adpX = false;
        if (this.adqg != null) {
          break label170;
        }
        this.adpY = null;
        label62:
        if (this.adqh != null) {
          break label183;
        }
        this.adpZ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFD;
        label87:
        if (this.adqi != null) {
          break label193;
        }
        this.adqa = null;
        label99:
        this.adqb = false;
        if (this.adqj != null) {
          break label206;
        }
        this.adqc = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFB;
        label129:
        if (this.adqk != null) {
          break label216;
        }
        this.adqd = null;
        label141:
        if (this.adpT != null) {
          break label229;
        }
        this.adpP = null;
      }
      for (;;)
      {
        AppMethodBeat.o(232462);
        return this;
        this.adqf.clear();
        break;
        label170:
        this.adpY = null;
        this.adqg = null;
        break label62;
        label183:
        this.adqh.clear();
        break label87;
        label193:
        this.adqa = null;
        this.adqi = null;
        break label99;
        label206:
        this.adqj.clear();
        break label129;
        label216:
        this.adqd = null;
        this.adqk = null;
        break label141;
        label229:
        this.adpP = null;
        this.adpT = null;
      }
    }
    
    private e jfo()
    {
      AppMethodBeat.i(232469);
      Object localObject = jfp();
      if (!((e)localObject).isInitialized())
      {
        localObject = newUninitializedMessageException((cb)localObject);
        AppMethodBeat.o(232469);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(232469);
      return localObject;
    }
    
    private e jfp()
    {
      AppMethodBeat.i(232483);
      e locale = new e(this, (byte)0);
      if (this.adqf == null)
      {
        if ((this.bitField0_ & 0x1) != 0)
        {
          this.adpU = Collections.unmodifiableList(this.adpU);
          this.bitField0_ &= 0xFFFFFFFE;
        }
        e.a(locale, this.adpU);
        e.a(locale, this.adpV);
        e.b(locale, this.adpW);
        e.a(locale, this.adpX);
        if (this.adqg != null) {
          break label284;
        }
        e.a(locale, this.adpY);
        label106:
        if (this.adqh != null) {
          break label302;
        }
        if ((this.bitField0_ & 0x2) != 0)
        {
          this.adpZ = Collections.unmodifiableList(this.adpZ);
          this.bitField0_ &= 0xFFFFFFFD;
        }
        e.b(locale, this.adpZ);
        label153:
        if (this.adqi != null) {
          break label317;
        }
        e.a(locale, this.adqa);
        label169:
        e.b(locale, this.adqb);
        if (this.adqj != null) {
          break label335;
        }
        if ((this.bitField0_ & 0x4) != 0)
        {
          this.adqc = Collections.unmodifiableList(this.adqc);
          this.bitField0_ &= 0xFFFFFFFB;
        }
        e.c(locale, this.adqc);
        label225:
        if (this.adqk != null) {
          break label350;
        }
        e.a(locale, this.adqd);
        label241:
        if (this.adpT != null) {
          break label368;
        }
        e.b(locale, this.adpP);
      }
      for (;;)
      {
        onBuilt();
        AppMethodBeat.o(232483);
        return locale;
        e.a(locale, this.adqf.build());
        break;
        label284:
        e.a(locale, (c)this.adqg.ajn());
        break label106;
        label302:
        e.b(locale, this.adqh.build());
        break label153;
        label317:
        e.a(locale, (af)this.adqi.ajn());
        break label169;
        label335:
        e.c(locale, this.adqj.build());
        break label225;
        label350:
        e.a(locale, (q)this.adqk.ajn());
        break label241;
        label368:
        e.b(locale, (q)this.adpT.ajn());
      }
    }
    
    private void jfq()
    {
      AppMethodBeat.i(232540);
      if ((this.bitField0_ & 0x1) == 0)
      {
        this.adpU = new ArrayList(this.adpU);
        this.bitField0_ |= 0x1;
      }
      AppMethodBeat.o(232540);
    }
    
    private da<aa, aa.a, ab> jfr()
    {
      AppMethodBeat.i(232547);
      Object localObject;
      if (this.adqf == null)
      {
        localObject = this.adpU;
        if ((this.bitField0_ & 0x1) == 0) {
          break label68;
        }
      }
      label68:
      for (boolean bool = true;; bool = false)
      {
        this.adqf = new da((List)localObject, bool, getParentForChildren(), isClean());
        this.adpU = null;
        localObject = this.adqf;
        AppMethodBeat.o(232547);
        return localObject;
      }
    }
    
    private void jfs()
    {
      AppMethodBeat.i(232578);
      if ((this.bitField0_ & 0x2) == 0)
      {
        this.adpZ = new ArrayList(this.adpZ);
        this.bitField0_ |= 0x2;
      }
      AppMethodBeat.o(232578);
    }
    
    private da<l, l.a, m> jft()
    {
      AppMethodBeat.i(232584);
      Object localObject;
      if (this.adqh == null)
      {
        localObject = this.adpZ;
        if ((this.bitField0_ & 0x2) == 0) {
          break label68;
        }
      }
      label68:
      for (boolean bool = true;; bool = false)
      {
        this.adqh = new da((List)localObject, bool, getParentForChildren(), isClean());
        this.adpZ = null;
        localObject = this.adqh;
        AppMethodBeat.o(232584);
        return localObject;
      }
    }
    
    private void jfu()
    {
      AppMethodBeat.i(232601);
      if ((this.bitField0_ & 0x4) == 0)
      {
        this.adqc = new ArrayList(this.adqc);
        this.bitField0_ |= 0x4;
      }
      AppMethodBeat.o(232601);
    }
    
    private da<g, g.a, h> jfv()
    {
      AppMethodBeat.i(232608);
      Object localObject;
      if (this.adqj == null)
      {
        localObject = this.adqc;
        if ((this.bitField0_ & 0x4) == 0) {
          break label68;
        }
      }
      label68:
      for (boolean bool = true;; bool = false)
      {
        this.adqj = new da((List)localObject, bool, getParentForChildren(), isClean());
        this.adqc = null;
        localObject = this.adqj;
        AppMethodBeat.o(232608);
        return localObject;
      }
    }
    
    private void maybeForceBuilderInitialization()
    {
      AppMethodBeat.i(232451);
      if (e.ayB())
      {
        jfr();
        jft();
        jfv();
      }
      AppMethodBeat.o(232451);
    }
    
    private a zn(long paramLong)
    {
      AppMethodBeat.i(232553);
      this.adpV = paramLong;
      onChanged();
      AppMethodBeat.o(232553);
      return this;
    }
    
    private a zo(long paramLong)
    {
      AppMethodBeat.i(232560);
      this.adpW = paramLong;
      onChanged();
      AppMethodBeat.o(232560);
      return this;
    }
    
    public final a e(e parame)
    {
      Object localObject2 = null;
      AppMethodBeat.i(232708);
      if (parame == e.jfj())
      {
        AppMethodBeat.o(232708);
        return this;
      }
      if (this.adqf == null) {
        if (!e.a(parame).isEmpty())
        {
          if (this.adpU.isEmpty())
          {
            this.adpU = e.a(parame);
            this.bitField0_ &= 0xFFFFFFFE;
            onChanged();
          }
        }
        else
        {
          label77:
          if (parame.adpV != 0L) {
            zn(parame.adpV);
          }
          if (parame.adpW != 0L) {
            zo(parame.adpW);
          }
          if (parame.adpX) {
            KJ(parame.adpX);
          }
          if (parame.jfc()) {
            e(parame.jfd());
          }
          if (this.adqh != null) {
            break label473;
          }
          if (!e.b(parame).isEmpty())
          {
            if (!this.adpZ.isEmpty()) {
              break label452;
            }
            this.adpZ = e.b(parame);
            this.bitField0_ &= 0xFFFFFFFD;
            label195:
            onChanged();
          }
          label199:
          if (parame.jfe()) {
            a(parame.jff());
          }
          if (parame.adqb) {
            KK(parame.adqb);
          }
          if (this.adqj != null) {
            break label587;
          }
          if (!e.c(parame).isEmpty())
          {
            if (!this.adqc.isEmpty()) {
              break label566;
            }
            this.adqc = e.c(parame);
            this.bitField0_ &= 0xFFFFFFFB;
            label281:
            onChanged();
          }
        }
      }
      for (;;)
      {
        if (parame.jfg()) {
          d(parame.jfh());
        }
        if (parame.jeP()) {
          e(parame.jeQ());
        }
        aB(e.d(parame));
        onChanged();
        AppMethodBeat.o(232708);
        return this;
        jfq();
        this.adpU.addAll(e.a(parame));
        break;
        if (e.a(parame).isEmpty()) {
          break label77;
        }
        Object localObject1;
        if (this.adqf.isEmpty())
        {
          this.adqf.dUC = null;
          this.adqf = null;
          this.adpU = e.a(parame);
          this.bitField0_ &= 0xFFFFFFFE;
          if (e.czS()) {}
          for (localObject1 = jfr();; localObject1 = null)
          {
            this.adqf = ((da)localObject1);
            break;
          }
        }
        this.adqf.a(e.a(parame));
        break label77;
        label452:
        jfs();
        this.adpZ.addAll(e.b(parame));
        break label195;
        label473:
        if (e.b(parame).isEmpty()) {
          break label199;
        }
        if (this.adqh.isEmpty())
        {
          this.adqh.dUC = null;
          this.adqh = null;
          this.adpZ = e.b(parame);
          this.bitField0_ &= 0xFFFFFFFD;
          if (e.jfk()) {}
          for (localObject1 = jft();; localObject1 = null)
          {
            this.adqh = ((da)localObject1);
            break;
          }
        }
        this.adqh.a(e.b(parame));
        break label199;
        label566:
        jfu();
        this.adqc.addAll(e.c(parame));
        break label281;
        label587:
        if (!e.c(parame).isEmpty()) {
          if (this.adqj.isEmpty())
          {
            this.adqj.dUC = null;
            this.adqj = null;
            this.adqc = e.c(parame);
            this.bitField0_ &= 0xFFFFFFFB;
            localObject1 = localObject2;
            if (e.jfl()) {
              localObject1 = jfv();
            }
            this.adqj = ((da)localObject1);
          }
          else
          {
            this.adqj.a(e.c(parame));
          }
        }
      }
    }
    
    public final am.a getDescriptorForType()
    {
      return ae.adsx;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(232689);
      bg.e locale = ae.adsy.b(e.class, a.class);
      AppMethodBeat.o(232689);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.e
 * JD-Core Version:    0.7.0.1
 */