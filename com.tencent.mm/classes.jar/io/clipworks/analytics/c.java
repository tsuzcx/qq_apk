package io.clipworks.analytics;

import com.google.d.am.a;
import com.google.d.am.f;
import com.google.d.am.g;
import com.google.d.am.j;
import com.google.d.bg;
import com.google.d.bg.a;
import com.google.d.bg.b;
import com.google.d.bg.e;
import com.google.d.bg.f;
import com.google.d.bj;
import com.google.d.bt;
import com.google.d.bt.a;
import com.google.d.bv;
import com.google.d.bv.c;
import com.google.d.bv.d;
import com.google.d.cb;
import com.google.d.cs;
import com.google.d.dn;
import com.google.d.du.a;
import com.google.d.h;
import com.google.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  private static final am.a aium;
  private static final bg.e aiun;
  private static final am.a aiuo;
  private static final bg.e aiup;
  private static am.g descriptor;
  
  static
  {
    AppMethodBeat.i(189520);
    am.g localg = am.g.a(new String[] { "\n\013ALS12.proto\022\005ALS12\"Ð\001\n\016AnalyticsEvent\022\f\n\004time\030\001 \001(\004\022\021\n\ttimestamp\030\002 \001(\004\022\f\n\004name\030\003 \001(\t\0221\n\006params\030\004 \003(\0132!.ALS12.AnalyticsEvent.ParamsEntry\022\026\n\016global_seq_num\030\005 \001(\005\022\025\n\rlocal_seq_num\030\006 \001(\005\032-\n\013ParamsEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001B\037\n\026io.clipworks.analyticsB\005ALS12b\006proto3" }, new am.g[0]);
    descriptor = localg;
    aium = (am.a)localg.ahs().get(0);
    aiun = new bg.e(aium, new String[] { "Time", "Timestamp", "Name", "Params", "GlobalSeqNum", "LocalSeqNum" });
    aiuo = (am.a)aium.ahb().get(0);
    aiup = new bg.e(aiuo, new String[] { "Key", "Value" });
    AppMethodBeat.o(189520);
  }
  
  public static final class a
    extends bg
    implements d
  {
    private static final cs<a> PARSER;
    private static final a aiuv;
    long aiuq;
    long aiur;
    private bv<String, String> aius;
    int aiut;
    int aiuu;
    private byte memoizedIsInitialized = -1;
    private volatile Object name_;
    
    static
    {
      AppMethodBeat.i(189641);
      aiuv = new a();
      PARSER = new com.google.d.c() {};
      AppMethodBeat.o(189641);
    }
    
    private a()
    {
      this.name_ = "";
    }
    
    private a(bg.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private a(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 46	io/clipworks/analytics/c$a:<init>	()V
      //   4: ldc 75
      //   6: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_2
      //   10: ifnonnull +18 -> 28
      //   13: new 77	java/lang/NullPointerException
      //   16: dup
      //   17: invokespecial 78	java/lang/NullPointerException:<init>	()V
      //   20: astore_1
      //   21: ldc 75
      //   23: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   26: aload_1
      //   27: athrow
      //   28: invokestatic 84	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
      //   31: astore 6
      //   33: iconst_0
      //   34: istore_3
      //   35: iconst_0
      //   36: istore 4
      //   38: iload_3
      //   39: ifne +279 -> 318
      //   42: aload_1
      //   43: invokevirtual 90	com/google/d/i:aac	()I
      //   46: istore 5
      //   48: iload 5
      //   50: lookupswitch	default:+290->340, 0:+296->346, 8:+84->134, 16:+129->179, 26:+162->212, 34:+173->223, 40:+246->296, 48:+257->307
      //   117: aload_1
      //   118: aload 6
      //   120: aload_2
      //   121: iload 5
      //   123: invokevirtual 94	io/clipworks/analytics/c$a:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
      //   126: ifne +211 -> 337
      //   129: iconst_1
      //   130: istore_3
      //   131: goto +212 -> 343
      //   134: aload_0
      //   135: aload_1
      //   136: invokevirtual 98	com/google/d/i:aad	()J
      //   139: putfield 100	io/clipworks/analytics/c$a:aiuq	J
      //   142: goto -104 -> 38
      //   145: astore_1
      //   146: aload_1
      //   147: aload_0
      //   148: putfield 104	com/google/d/bk:dST	Lcom/google/d/ce;
      //   151: ldc 75
      //   153: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   156: aload_1
      //   157: athrow
      //   158: astore_1
      //   159: aload_0
      //   160: aload 6
      //   162: invokevirtual 110	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   165: putfield 114	io/clipworks/analytics/c$a:unknownFields	Lcom/google/d/dn;
      //   168: aload_0
      //   169: invokevirtual 117	io/clipworks/analytics/c$a:makeExtensionsImmutable	()V
      //   172: ldc 75
      //   174: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   177: aload_1
      //   178: athrow
      //   179: aload_0
      //   180: aload_1
      //   181: invokevirtual 98	com/google/d/i:aad	()J
      //   184: putfield 119	io/clipworks/analytics/c$a:aiur	J
      //   187: goto -149 -> 38
      //   190: astore_1
      //   191: new 72	com/google/d/bk
      //   194: dup
      //   195: aload_1
      //   196: invokespecial 122	com/google/d/bk:<init>	(Ljava/io/IOException;)V
      //   199: astore_1
      //   200: aload_1
      //   201: aload_0
      //   202: putfield 104	com/google/d/bk:dST	Lcom/google/d/ce;
      //   205: ldc 75
      //   207: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   210: aload_1
      //   211: athrow
      //   212: aload_0
      //   213: aload_1
      //   214: invokevirtual 126	com/google/d/i:aaj	()Ljava/lang/String;
      //   217: putfield 62	io/clipworks/analytics/c$a:name_	Ljava/lang/Object;
      //   220: goto -182 -> 38
      //   223: iload 4
      //   225: istore 5
      //   227: iload 4
      //   229: iconst_1
      //   230: iand
      //   231: ifne +19 -> 250
      //   234: aload_0
      //   235: getstatic 130	io/clipworks/analytics/c$a$b:dTI	Lcom/google/d/bt;
      //   238: invokestatic 136	com/google/d/bv:d	(Lcom/google/d/bt;)Lcom/google/d/bv;
      //   241: putfield 138	io/clipworks/analytics/c$a:aius	Lcom/google/d/bv;
      //   244: iload 4
      //   246: iconst_1
      //   247: ior
      //   248: istore 5
      //   250: aload_1
      //   251: getstatic 130	io/clipworks/analytics/c$a$b:dTI	Lcom/google/d/bt;
      //   254: invokevirtual 144	com/google/d/bt:getParserForType	()Lcom/google/d/cs;
      //   257: aload_2
      //   258: invokevirtual 147	com/google/d/i:a	(Lcom/google/d/cs;Lcom/google/d/at;)Lcom/google/d/ce;
      //   261: checkcast 140	com/google/d/bt
      //   264: astore 7
      //   266: aload_0
      //   267: getfield 138	io/clipworks/analytics/c$a:aius	Lcom/google/d/bv;
      //   270: invokevirtual 151	com/google/d/bv:aiH	()Ljava/util/Map;
      //   273: aload 7
      //   275: getfield 154	com/google/d/bt:key	Ljava/lang/Object;
      //   278: aload 7
      //   280: getfield 157	com/google/d/bt:value	Ljava/lang/Object;
      //   283: invokeinterface 163 3 0
      //   288: pop
      //   289: iload 5
      //   291: istore 4
      //   293: goto -255 -> 38
      //   296: aload_0
      //   297: aload_1
      //   298: invokevirtual 166	com/google/d/i:aaf	()I
      //   301: putfield 168	io/clipworks/analytics/c$a:aiut	I
      //   304: goto -266 -> 38
      //   307: aload_0
      //   308: aload_1
      //   309: invokevirtual 166	com/google/d/i:aaf	()I
      //   312: putfield 170	io/clipworks/analytics/c$a:aiuu	I
      //   315: goto -277 -> 38
      //   318: aload_0
      //   319: aload 6
      //   321: invokevirtual 110	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   324: putfield 114	io/clipworks/analytics/c$a:unknownFields	Lcom/google/d/dn;
      //   327: aload_0
      //   328: invokevirtual 117	io/clipworks/analytics/c$a:makeExtensionsImmutable	()V
      //   331: ldc 75
      //   333: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   336: return
      //   337: goto +6 -> 343
      //   340: goto -224 -> 116
      //   343: goto -305 -> 38
      //   346: iconst_1
      //   347: istore_3
      //   348: goto -310 -> 38
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	351	0	this	a
      //   0	351	1	parami	com.google.d.i
      //   0	351	2	paramat	com.google.d.at
      //   34	314	3	i	int
      //   36	256	4	j	int
      //   46	244	5	k	int
      //   31	289	6	locala	com.google.d.dn.a
      //   264	15	7	localbt	bt
      // Exception table:
      //   from	to	target	type
      //   42	48	145	com/google/d/bk
      //   116	129	145	com/google/d/bk
      //   134	142	145	com/google/d/bk
      //   179	187	145	com/google/d/bk
      //   212	220	145	com/google/d/bk
      //   234	244	145	com/google/d/bk
      //   250	289	145	com/google/d/bk
      //   296	304	145	com/google/d/bk
      //   307	315	145	com/google/d/bk
      //   42	48	158	finally
      //   116	129	158	finally
      //   134	142	158	finally
      //   146	158	158	finally
      //   179	187	158	finally
      //   191	212	158	finally
      //   212	220	158	finally
      //   234	244	158	finally
      //   250	289	158	finally
      //   296	304	158	finally
      //   307	315	158	finally
      //   42	48	190	java/io/IOException
      //   116	129	190	java/io/IOException
      //   134	142	190	java/io/IOException
      //   179	187	190	java/io/IOException
      //   212	220	190	java/io/IOException
      //   234	244	190	java/io/IOException
      //   250	289	190	java/io/IOException
      //   296	304	190	java/io/IOException
      //   307	315	190	java/io/IOException
    }
    
    public static a L(ByteBuffer paramByteBuffer)
    {
      AppMethodBeat.i(189536);
      paramByteBuffer = (a)PARSER.parseFrom(paramByteBuffer);
      AppMethodBeat.o(189536);
      return paramByteBuffer;
    }
    
    private h getNameBytes()
    {
      AppMethodBeat.i(189527);
      Object localObject = this.name_;
      if ((localObject instanceof String))
      {
        localObject = h.dS((String)localObject);
        this.name_ = localObject;
        AppMethodBeat.o(189527);
        return localObject;
      }
      localObject = (h)localObject;
      AppMethodBeat.o(189527);
      return localObject;
    }
    
    private a kkH()
    {
      AppMethodBeat.i(189543);
      if (this == aiuv)
      {
        locala = new a((byte)0);
        AppMethodBeat.o(189543);
        return locala;
      }
      a locala = new a((byte)0).e(this);
      AppMethodBeat.o(189543);
      return locala;
    }
    
    public static a kkI()
    {
      return aiuv;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(189722);
      if (paramObject == this)
      {
        AppMethodBeat.o(189722);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(189722);
        return bool;
      }
      paramObject = (a)paramObject;
      if (this.aiuq != paramObject.aiuq)
      {
        AppMethodBeat.o(189722);
        return false;
      }
      if (this.aiur != paramObject.aiur)
      {
        AppMethodBeat.o(189722);
        return false;
      }
      if (!getName().equals(paramObject.getName()))
      {
        AppMethodBeat.o(189722);
        return false;
      }
      if (!kkG().equals(paramObject.kkG()))
      {
        AppMethodBeat.o(189722);
        return false;
      }
      if (this.aiut != paramObject.aiut)
      {
        AppMethodBeat.o(189722);
        return false;
      }
      if (this.aiuu != paramObject.aiuu)
      {
        AppMethodBeat.o(189722);
        return false;
      }
      if (!this.unknownFields.equals(paramObject.unknownFields))
      {
        AppMethodBeat.o(189722);
        return false;
      }
      AppMethodBeat.o(189722);
      return true;
    }
    
    public final String getName()
    {
      AppMethodBeat.i(189685);
      Object localObject = this.name_;
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        AppMethodBeat.o(189685);
        return localObject;
      }
      localObject = ((h)localObject).ZV();
      this.name_ = localObject;
      AppMethodBeat.o(189685);
      return localObject;
    }
    
    public final cs<a> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      AppMethodBeat.i(189711);
      int i = this.memoizedSize;
      if (i != -1)
      {
        AppMethodBeat.o(189711);
        return i;
      }
      int j = 0;
      if (this.aiuq != 0L) {
        j = k.r(1, this.aiuq) + 0;
      }
      i = j;
      if (this.aiur != 0L) {
        i = j + k.r(2, this.aiur);
      }
      j = i;
      if (!getNameBytes().isEmpty()) {
        j = i + bg.computeStringSize(3, this.name_);
      }
      Iterator localIterator = kkG().aiG().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        j = k.c(4, b.dTI.aiA().by(localEntry.getKey()).bz(localEntry.getValue()).aiD()) + j;
      }
      i = j;
      if (this.aiut != 0) {
        i = j + k.cJ(5, this.aiut);
      }
      j = i;
      if (this.aiuu != 0) {
        j = i + k.cJ(6, this.aiuu);
      }
      i = this.unknownFields.getSerializedSize() + j;
      this.memoizedSize = i;
      AppMethodBeat.o(189711);
      return i;
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(189726);
      if (this.memoizedHashCode != 0)
      {
        i = this.memoizedHashCode;
        AppMethodBeat.o(189726);
        return i;
      }
      int j = ((((((c.aium.hashCode() + 779) * 37 + 1) * 53 + bj.hashLong(this.aiuq)) * 37 + 2) * 53 + bj.hashLong(this.aiur)) * 37 + 3) * 53 + getName().hashCode();
      int i = j;
      if (!kkG().aiG().isEmpty()) {
        i = (j * 37 + 4) * 53 + kkG().hashCode();
      }
      i = ((((i * 37 + 5) * 53 + this.aiut) * 37 + 6) * 53 + this.aiuu) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      AppMethodBeat.o(189726);
      return i;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(189674);
      bg.e locale = c.aiun.b(a.class, a.class);
      AppMethodBeat.o(189674);
      return locale;
    }
    
    public final bv internalGetMapField(int paramInt)
    {
      AppMethodBeat.i(189664);
      switch (paramInt)
      {
      default: 
        localObject = new RuntimeException("Invalid map field number: ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(189664);
        throw ((Throwable)localObject);
      }
      Object localObject = kkG();
      AppMethodBeat.o(189664);
      return localObject;
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
    
    final bv<String, String> kkG()
    {
      AppMethodBeat.i(189695);
      if (this.aius == null)
      {
        localbv = bv.c(b.dTI);
        AppMethodBeat.o(189695);
        return localbv;
      }
      bv localbv = this.aius;
      AppMethodBeat.o(189695);
      return localbv;
    }
    
    public final Object newInstance(bg.f paramf)
    {
      AppMethodBeat.i(189647);
      paramf = new a();
      AppMethodBeat.o(189647);
      return paramf;
    }
    
    public final void writeTo(k paramk)
    {
      AppMethodBeat.i(189705);
      if (this.aiuq != 0L) {
        paramk.n(1, this.aiuq);
      }
      if (this.aiur != 0L) {
        paramk.n(2, this.aiur);
      }
      if (!getNameBytes().isEmpty()) {
        bg.writeString(paramk, 3, this.name_);
      }
      bg.serializeStringMapTo(paramk, kkG(), b.dTI, 4);
      if (this.aiut != 0) {
        paramk.cF(5, this.aiut);
      }
      if (this.aiuu != 0) {
        paramk.cF(6, this.aiuu);
      }
      this.unknownFields.writeTo(paramk);
      AppMethodBeat.o(189705);
    }
    
    public static final class a
      extends bg.a<a>
      implements d
    {
      private long aiuq;
      private long aiur;
      private bv<String, String> aius;
      private int aiut;
      private int aiuu;
      private Object name_;
      
      private a()
      {
        AppMethodBeat.i(189501);
        this.name_ = "";
        c.a.dxo();
        AppMethodBeat.o(189501);
      }
      
      private a(bg.b paramb)
      {
        super();
        AppMethodBeat.i(189506);
        this.name_ = "";
        c.a.dxo();
        AppMethodBeat.o(189506);
      }
      
      private a BB(long paramLong)
      {
        AppMethodBeat.i(189584);
        this.aiuq = paramLong;
        onChanged();
        AppMethodBeat.o(189584);
        return this;
      }
      
      private a BC(long paramLong)
      {
        AppMethodBeat.i(189592);
        this.aiur = paramLong;
        onChanged();
        AppMethodBeat.o(189592);
        return this;
      }
      
      private a X(am.f paramf, int paramInt, Object paramObject)
      {
        AppMethodBeat.i(189564);
        paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
        AppMethodBeat.o(189564);
        return paramf;
      }
      
      /* Error */
      private a X(com.google.d.i parami, com.google.d.at paramat)
      {
        // Byte code:
        //   0: ldc 77
        //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: invokestatic 81	io/clipworks/analytics/c$a:kkJ	()Lcom/google/d/cs;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 87 3 0
        //   17: checkcast 9	io/clipworks/analytics/c$a
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 91	io/clipworks/analytics/c$a$a:e	(Lio/clipworks/analytics/c$a;)Lio/clipworks/analytics/c$a$a;
        //   30: pop
        //   31: ldc 77
        //   33: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 95	com/google/d/bk:dST	Lcom/google/d/ce;
        //   43: checkcast 9	io/clipworks/analytics/c$a
        //   46: astore_2
        //   47: aload_1
        //   48: invokevirtual 99	com/google/d/bk:aii	()Ljava/io/IOException;
        //   51: astore_1
        //   52: ldc 77
        //   54: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_2
        //   61: ifnull +9 -> 70
        //   64: aload_0
        //   65: aload_2
        //   66: invokevirtual 91	io/clipworks/analytics/c$a$a:e	(Lio/clipworks/analytics/c$a;)Lio/clipworks/analytics/c$a$a;
        //   69: pop
        //   70: ldc 77
        //   72: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   75: aload_1
        //   76: athrow
        //   77: astore_1
        //   78: aload_3
        //   79: astore_2
        //   80: goto -20 -> 60
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	parami	com.google.d.i
        //   0	83	2	paramat	com.google.d.at
        //   6	73	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	com/google/d/bk
        //   47	59	59	finally
        //   7	21	77	finally
        //   39	47	77	finally
      }
      
      private a Y(cb paramcb)
      {
        AppMethodBeat.i(189573);
        if ((paramcb instanceof c.a))
        {
          paramcb = e((c.a)paramcb);
          AppMethodBeat.o(189573);
          return paramcb;
        }
        super.mergeFrom(paramcb);
        AppMethodBeat.o(189573);
        return this;
      }
      
      private a aKa(int paramInt)
      {
        AppMethodBeat.i(189609);
        this.aiut = paramInt;
        onChanged();
        AppMethodBeat.o(189609);
        return this;
      }
      
      private a aKb(int paramInt)
      {
        AppMethodBeat.i(189619);
        this.aiuu = paramInt;
        onChanged();
        AppMethodBeat.o(189619);
        return this;
      }
      
      private a aW(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(189540);
        paramf = (a)super.setField(paramf, paramObject);
        AppMethodBeat.o(189540);
        return paramf;
      }
      
      private a aX(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(189568);
        paramf = (a)super.addRepeatedField(paramf, paramObject);
        AppMethodBeat.o(189568);
        return paramf;
      }
      
      private a aY(dn paramdn)
      {
        AppMethodBeat.i(189623);
        paramdn = (a)super.setUnknownFields(paramdn);
        AppMethodBeat.o(189623);
        return paramdn;
      }
      
      private a aZ(dn paramdn)
      {
        AppMethodBeat.i(189629);
        paramdn = (a)super.mergeUnknownFields(paramdn);
        AppMethodBeat.o(189629);
        return paramdn;
      }
      
      private a ab(am.j paramj)
      {
        AppMethodBeat.i(189556);
        paramj = (a)super.clearOneof(paramj);
        AppMethodBeat.o(189556);
        return paramj;
      }
      
      private a af(am.f paramf)
      {
        AppMethodBeat.i(189549);
        paramf = (a)super.clearField(paramf);
        AppMethodBeat.o(189549);
        return paramf;
      }
      
      private bv<String, String> kkG()
      {
        AppMethodBeat.i(189596);
        if (this.aius == null)
        {
          localbv = bv.c(c.a.b.dTI);
          AppMethodBeat.o(189596);
          return localbv;
        }
        bv localbv = this.aius;
        AppMethodBeat.o(189596);
        return localbv;
      }
      
      private a kkK()
      {
        AppMethodBeat.i(189512);
        super.clear();
        this.aiuq = 0L;
        this.aiur = 0L;
        this.name_ = "";
        bv localbv = kkN();
        localbv.dTF = new bv.c(localbv, new LinkedHashMap());
        localbv.dTE = bv.d.dTO;
        this.aiut = 0;
        this.aiuu = 0;
        AppMethodBeat.o(189512);
        return this;
      }
      
      private c.a kkL()
      {
        AppMethodBeat.i(189519);
        Object localObject = kkM();
        if (!((c.a)localObject).isInitialized())
        {
          localObject = newUninitializedMessageException((cb)localObject);
          AppMethodBeat.o(189519);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(189519);
        return localObject;
      }
      
      private c.a kkM()
      {
        AppMethodBeat.i(189529);
        c.a locala = new c.a(this, (byte)0);
        c.a.a(locala, this.aiuq);
        c.a.b(locala, this.aiur);
        c.a.a(locala, this.name_);
        c.a.a(locala, kkG());
        c.a.a(locala).dIE = false;
        c.a.a(locala, this.aiut);
        c.a.b(locala, this.aiuu);
        onBuilt();
        AppMethodBeat.o(189529);
        return locala;
      }
      
      private bv<String, String> kkN()
      {
        AppMethodBeat.i(189603);
        onChanged();
        if (this.aius == null) {
          this.aius = bv.d(c.a.b.dTI);
        }
        if (!this.aius.dIE) {
          this.aius = this.aius.aiI();
        }
        bv localbv = this.aius;
        AppMethodBeat.o(189603);
        return localbv;
      }
      
      public final a e(c.a parama)
      {
        AppMethodBeat.i(189689);
        if (parama == c.a.kkI())
        {
          AppMethodBeat.o(189689);
          return this;
        }
        if (parama.aiuq != 0L) {
          BB(parama.aiuq);
        }
        if (parama.aiur != 0L) {
          BC(parama.aiur);
        }
        if (!parama.getName().isEmpty())
        {
          this.name_ = c.a.b(parama);
          onChanged();
        }
        kkN().a(c.a.c(parama));
        if (parama.aiut != 0) {
          aKa(parama.aiut);
        }
        if (parama.aiuu != 0) {
          aKb(parama.aiuu);
        }
        aZ(c.a.d(parama));
        onChanged();
        AppMethodBeat.o(189689);
        return this;
      }
      
      public final am.a getDescriptorForType()
      {
        AppMethodBeat.i(189679);
        am.a locala = c.aium;
        AppMethodBeat.o(189679);
        return locala;
      }
      
      public final bg.e internalGetFieldAccessorTable()
      {
        AppMethodBeat.i(189670);
        bg.e locale = c.aiun.b(c.a.class, a.class);
        AppMethodBeat.o(189670);
        return locale;
      }
      
      public final bv internalGetMapField(int paramInt)
      {
        AppMethodBeat.i(189653);
        switch (paramInt)
        {
        default: 
          localObject = new RuntimeException("Invalid map field number: ".concat(String.valueOf(paramInt)));
          AppMethodBeat.o(189653);
          throw ((Throwable)localObject);
        }
        Object localObject = kkG();
        AppMethodBeat.o(189653);
        return localObject;
      }
      
      public final bv internalGetMutableMapField(int paramInt)
      {
        AppMethodBeat.i(189661);
        switch (paramInt)
        {
        default: 
          localObject = new RuntimeException("Invalid map field number: ".concat(String.valueOf(paramInt)));
          AppMethodBeat.o(189661);
          throw ((Throwable)localObject);
        }
        Object localObject = kkN();
        AppMethodBeat.o(189661);
        return localObject;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
    
    static final class b
    {
      static final bt<String, String> dTI;
      
      static
      {
        AppMethodBeat.i(189497);
        dTI = bt.a(c.kkF(), du.a.dWO, "", du.a.dWO, "");
        AppMethodBeat.o(189497);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     io.clipworks.analytics.c
 * JD-Core Version:    0.7.0.1
 */