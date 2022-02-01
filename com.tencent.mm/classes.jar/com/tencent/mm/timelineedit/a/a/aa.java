package com.tencent.mm.timelineedit.a.a;

import com.google.d.am.a;
import com.google.d.am.f;
import com.google.d.am.j;
import com.google.d.bg;
import com.google.d.bg.a;
import com.google.d.bg.b;
import com.google.d.bg.e;
import com.google.d.bg.f;
import com.google.d.bj;
import com.google.d.c;
import com.google.d.cb;
import com.google.d.cs;
import com.google.d.df;
import com.google.d.dn;
import com.google.d.h;
import com.google.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aa
  extends bg
  implements ab
{
  private static final cs<aa> PARSER;
  private static final aa adrK;
  int adrA;
  int adrB;
  float adrC;
  float adrD;
  int adrE;
  float adrF;
  private i adrG;
  private ac adrH;
  int adrI;
  private y adrJ;
  long adru;
  long adrv;
  long adrw;
  long adrx;
  long adry;
  long adrz;
  private volatile Object efu;
  private byte memoizedIsInitialized = -1;
  int type_;
  
  static
  {
    AppMethodBeat.i(233021);
    adrK = new aa();
    PARSER = new c() {};
    AppMethodBeat.o(233021);
  }
  
  private aa()
  {
    this.efu = "";
    this.type_ = 0;
    this.adrI = 0;
  }
  
  private aa(bg.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private aa(com.google.d.i parami, com.google.d.at paramat)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 55	com/tencent/mm/timelineedit/a/a/aa:<init>	()V
    //   4: ldc 88
    //   6: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_2
    //   10: ifnonnull +18 -> 28
    //   13: new 90	java/lang/NullPointerException
    //   16: dup
    //   17: invokespecial 91	java/lang/NullPointerException:<init>	()V
    //   20: astore_1
    //   21: ldc 88
    //   23: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_1
    //   27: athrow
    //   28: invokestatic 97	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
    //   31: astore 6
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +585 -> 621
    //   39: aload_1
    //   40: invokevirtual 103	com/google/d/i:aac	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+614->661, 0:+620->667, 8:+179->226, 18:+224->271, 24:+257->304, 32:+268->315, 40:+279->326, 48:+290->337, 56:+301->348, 64:+312->359, 72:+323->370, 80:+334->381, 93:+345->392, 101:+356->403, 104:+367->414, 117:+378->425, 122:+389->436, 130:+447->494, 136:+505->552, 146:+516->563
    //   209: aload_1
    //   210: aload 6
    //   212: aload_2
    //   213: iload 4
    //   215: invokevirtual 107	com/tencent/mm/timelineedit/a/a/aa:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
    //   218: ifne +422 -> 640
    //   221: iconst_1
    //   222: istore_3
    //   223: goto +441 -> 664
    //   226: aload_0
    //   227: aload_1
    //   228: invokevirtual 111	com/google/d/i:aad	()J
    //   231: putfield 113	com/tencent/mm/timelineedit/a/a/aa:adru	J
    //   234: goto -199 -> 35
    //   237: astore_1
    //   238: aload_1
    //   239: aload_0
    //   240: putfield 117	com/google/d/bk:dST	Lcom/google/d/ce;
    //   243: ldc 88
    //   245: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: aload_1
    //   249: athrow
    //   250: astore_1
    //   251: aload_0
    //   252: aload 6
    //   254: invokevirtual 123	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   257: putfield 127	com/tencent/mm/timelineedit/a/a/aa:unknownFields	Lcom/google/d/dn;
    //   260: aload_0
    //   261: invokevirtual 130	com/tencent/mm/timelineedit/a/a/aa:makeExtensionsImmutable	()V
    //   264: ldc 88
    //   266: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: aload_1
    //   270: athrow
    //   271: aload_0
    //   272: aload_1
    //   273: invokevirtual 134	com/google/d/i:aaj	()Ljava/lang/String;
    //   276: putfield 71	com/tencent/mm/timelineedit/a/a/aa:efu	Ljava/lang/Object;
    //   279: goto -244 -> 35
    //   282: astore_1
    //   283: new 85	com/google/d/bk
    //   286: dup
    //   287: aload_1
    //   288: invokespecial 137	com/google/d/bk:<init>	(Ljava/io/IOException;)V
    //   291: astore_1
    //   292: aload_1
    //   293: aload_0
    //   294: putfield 117	com/google/d/bk:dST	Lcom/google/d/ce;
    //   297: ldc 88
    //   299: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   302: aload_1
    //   303: athrow
    //   304: aload_0
    //   305: aload_1
    //   306: invokevirtual 140	com/google/d/i:aam	()I
    //   309: putfield 73	com/tencent/mm/timelineedit/a/a/aa:type_	I
    //   312: goto -277 -> 35
    //   315: aload_0
    //   316: aload_1
    //   317: invokevirtual 143	com/google/d/i:aae	()J
    //   320: putfield 145	com/tencent/mm/timelineedit/a/a/aa:adrv	J
    //   323: goto -288 -> 35
    //   326: aload_0
    //   327: aload_1
    //   328: invokevirtual 143	com/google/d/i:aae	()J
    //   331: putfield 147	com/tencent/mm/timelineedit/a/a/aa:adrw	J
    //   334: goto -299 -> 35
    //   337: aload_0
    //   338: aload_1
    //   339: invokevirtual 143	com/google/d/i:aae	()J
    //   342: putfield 149	com/tencent/mm/timelineedit/a/a/aa:adrx	J
    //   345: goto -310 -> 35
    //   348: aload_0
    //   349: aload_1
    //   350: invokevirtual 143	com/google/d/i:aae	()J
    //   353: putfield 151	com/tencent/mm/timelineedit/a/a/aa:adry	J
    //   356: goto -321 -> 35
    //   359: aload_0
    //   360: aload_1
    //   361: invokevirtual 143	com/google/d/i:aae	()J
    //   364: putfield 153	com/tencent/mm/timelineedit/a/a/aa:adrz	J
    //   367: goto -332 -> 35
    //   370: aload_0
    //   371: aload_1
    //   372: invokevirtual 156	com/google/d/i:aaf	()I
    //   375: putfield 158	com/tencent/mm/timelineedit/a/a/aa:adrA	I
    //   378: goto -343 -> 35
    //   381: aload_0
    //   382: aload_1
    //   383: invokevirtual 156	com/google/d/i:aaf	()I
    //   386: putfield 160	com/tencent/mm/timelineedit/a/a/aa:adrB	I
    //   389: goto -354 -> 35
    //   392: aload_0
    //   393: aload_1
    //   394: invokevirtual 164	com/google/d/i:readFloat	()F
    //   397: putfield 166	com/tencent/mm/timelineedit/a/a/aa:adrC	F
    //   400: goto -365 -> 35
    //   403: aload_0
    //   404: aload_1
    //   405: invokevirtual 164	com/google/d/i:readFloat	()F
    //   408: putfield 168	com/tencent/mm/timelineedit/a/a/aa:adrD	F
    //   411: goto -376 -> 35
    //   414: aload_0
    //   415: aload_1
    //   416: invokevirtual 156	com/google/d/i:aaf	()I
    //   419: putfield 170	com/tencent/mm/timelineedit/a/a/aa:adrE	I
    //   422: goto -387 -> 35
    //   425: aload_0
    //   426: aload_1
    //   427: invokevirtual 164	com/google/d/i:readFloat	()F
    //   430: putfield 172	com/tencent/mm/timelineedit/a/a/aa:adrF	F
    //   433: goto -398 -> 35
    //   436: aload_0
    //   437: getfield 174	com/tencent/mm/timelineedit/a/a/aa:adrG	Lcom/tencent/mm/timelineedit/a/a/i;
    //   440: ifnull +215 -> 655
    //   443: aload_0
    //   444: getfield 174	com/tencent/mm/timelineedit/a/a/aa:adrG	Lcom/tencent/mm/timelineedit/a/a/i;
    //   447: invokevirtual 180	com/tencent/mm/timelineedit/a/a/i:jfI	()Lcom/tencent/mm/timelineedit/a/a/i$a;
    //   450: astore 5
    //   452: aload_0
    //   453: aload_1
    //   454: invokestatic 184	com/tencent/mm/timelineedit/a/a/i:parser	()Lcom/google/d/cs;
    //   457: aload_2
    //   458: invokevirtual 187	com/google/d/i:a	(Lcom/google/d/cs;Lcom/google/d/at;)Lcom/google/d/ce;
    //   461: checkcast 176	com/tencent/mm/timelineedit/a/a/i
    //   464: putfield 174	com/tencent/mm/timelineedit/a/a/aa:adrG	Lcom/tencent/mm/timelineedit/a/a/i;
    //   467: aload 5
    //   469: ifnull +171 -> 640
    //   472: aload 5
    //   474: aload_0
    //   475: getfield 174	com/tencent/mm/timelineedit/a/a/aa:adrG	Lcom/tencent/mm/timelineedit/a/a/i;
    //   478: invokevirtual 193	com/tencent/mm/timelineedit/a/a/i$a:c	(Lcom/tencent/mm/timelineedit/a/a/i;)Lcom/tencent/mm/timelineedit/a/a/i$a;
    //   481: pop
    //   482: aload_0
    //   483: aload 5
    //   485: invokevirtual 197	com/tencent/mm/timelineedit/a/a/i$a:jfM	()Lcom/tencent/mm/timelineedit/a/a/i;
    //   488: putfield 174	com/tencent/mm/timelineedit/a/a/aa:adrG	Lcom/tencent/mm/timelineedit/a/a/i;
    //   491: goto -456 -> 35
    //   494: aload_0
    //   495: getfield 199	com/tencent/mm/timelineedit/a/a/aa:adrH	Lcom/tencent/mm/timelineedit/a/a/ac;
    //   498: ifnull +151 -> 649
    //   501: aload_0
    //   502: getfield 199	com/tencent/mm/timelineedit/a/a/aa:adrH	Lcom/tencent/mm/timelineedit/a/a/ac;
    //   505: invokevirtual 205	com/tencent/mm/timelineedit/a/a/ac:jgO	()Lcom/tencent/mm/timelineedit/a/a/ac$a;
    //   508: astore 5
    //   510: aload_0
    //   511: aload_1
    //   512: invokestatic 206	com/tencent/mm/timelineedit/a/a/ac:parser	()Lcom/google/d/cs;
    //   515: aload_2
    //   516: invokevirtual 187	com/google/d/i:a	(Lcom/google/d/cs;Lcom/google/d/at;)Lcom/google/d/ce;
    //   519: checkcast 201	com/tencent/mm/timelineedit/a/a/ac
    //   522: putfield 199	com/tencent/mm/timelineedit/a/a/aa:adrH	Lcom/tencent/mm/timelineedit/a/a/ac;
    //   525: aload 5
    //   527: ifnull +113 -> 640
    //   530: aload 5
    //   532: aload_0
    //   533: getfield 199	com/tencent/mm/timelineedit/a/a/aa:adrH	Lcom/tencent/mm/timelineedit/a/a/ac;
    //   536: invokevirtual 212	com/tencent/mm/timelineedit/a/a/ac$a:e	(Lcom/tencent/mm/timelineedit/a/a/ac;)Lcom/tencent/mm/timelineedit/a/a/ac$a;
    //   539: pop
    //   540: aload_0
    //   541: aload 5
    //   543: invokevirtual 216	com/tencent/mm/timelineedit/a/a/ac$a:jgS	()Lcom/tencent/mm/timelineedit/a/a/ac;
    //   546: putfield 199	com/tencent/mm/timelineedit/a/a/aa:adrH	Lcom/tencent/mm/timelineedit/a/a/ac;
    //   549: goto -514 -> 35
    //   552: aload_0
    //   553: aload_1
    //   554: invokevirtual 140	com/google/d/i:aam	()I
    //   557: putfield 75	com/tencent/mm/timelineedit/a/a/aa:adrI	I
    //   560: goto -525 -> 35
    //   563: aload_0
    //   564: getfield 218	com/tencent/mm/timelineedit/a/a/aa:adrJ	Lcom/tencent/mm/timelineedit/a/a/y;
    //   567: ifnull +76 -> 643
    //   570: aload_0
    //   571: getfield 218	com/tencent/mm/timelineedit/a/a/aa:adrJ	Lcom/tencent/mm/timelineedit/a/a/y;
    //   574: invokevirtual 224	com/tencent/mm/timelineedit/a/a/y:jgs	()Lcom/tencent/mm/timelineedit/a/a/y$a;
    //   577: astore 5
    //   579: aload_0
    //   580: aload_1
    //   581: invokestatic 225	com/tencent/mm/timelineedit/a/a/y:parser	()Lcom/google/d/cs;
    //   584: aload_2
    //   585: invokevirtual 187	com/google/d/i:a	(Lcom/google/d/cs;Lcom/google/d/at;)Lcom/google/d/ce;
    //   588: checkcast 220	com/tencent/mm/timelineedit/a/a/y
    //   591: putfield 218	com/tencent/mm/timelineedit/a/a/aa:adrJ	Lcom/tencent/mm/timelineedit/a/a/y;
    //   594: aload 5
    //   596: ifnull +44 -> 640
    //   599: aload 5
    //   601: aload_0
    //   602: getfield 218	com/tencent/mm/timelineedit/a/a/aa:adrJ	Lcom/tencent/mm/timelineedit/a/a/y;
    //   605: invokevirtual 231	com/tencent/mm/timelineedit/a/a/y$a:d	(Lcom/tencent/mm/timelineedit/a/a/y;)Lcom/tencent/mm/timelineedit/a/a/y$a;
    //   608: pop
    //   609: aload_0
    //   610: aload 5
    //   612: invokevirtual 235	com/tencent/mm/timelineedit/a/a/y$a:jgw	()Lcom/tencent/mm/timelineedit/a/a/y;
    //   615: putfield 218	com/tencent/mm/timelineedit/a/a/aa:adrJ	Lcom/tencent/mm/timelineedit/a/a/y;
    //   618: goto -583 -> 35
    //   621: aload_0
    //   622: aload 6
    //   624: invokevirtual 123	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   627: putfield 127	com/tencent/mm/timelineedit/a/a/aa:unknownFields	Lcom/google/d/dn;
    //   630: aload_0
    //   631: invokevirtual 130	com/tencent/mm/timelineedit/a/a/aa:makeExtensionsImmutable	()V
    //   634: ldc 88
    //   636: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   639: return
    //   640: goto +24 -> 664
    //   643: aconst_null
    //   644: astore 5
    //   646: goto -67 -> 579
    //   649: aconst_null
    //   650: astore 5
    //   652: goto -142 -> 510
    //   655: aconst_null
    //   656: astore 5
    //   658: goto -206 -> 452
    //   661: goto -453 -> 208
    //   664: goto -629 -> 35
    //   667: iconst_1
    //   668: istore_3
    //   669: goto -634 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	672	0	this	aa
    //   0	672	1	parami	com.google.d.i
    //   0	672	2	paramat	com.google.d.at
    //   34	635	3	i	int
    //   43	171	4	j	int
    //   450	207	5	localObject	Object
    //   31	592	6	locala	com.google.d.dn.a
    // Exception table:
    //   from	to	target	type
    //   39	45	237	com/google/d/bk
    //   208	221	237	com/google/d/bk
    //   226	234	237	com/google/d/bk
    //   271	279	237	com/google/d/bk
    //   304	312	237	com/google/d/bk
    //   315	323	237	com/google/d/bk
    //   326	334	237	com/google/d/bk
    //   337	345	237	com/google/d/bk
    //   348	356	237	com/google/d/bk
    //   359	367	237	com/google/d/bk
    //   370	378	237	com/google/d/bk
    //   381	389	237	com/google/d/bk
    //   392	400	237	com/google/d/bk
    //   403	411	237	com/google/d/bk
    //   414	422	237	com/google/d/bk
    //   425	433	237	com/google/d/bk
    //   436	452	237	com/google/d/bk
    //   452	467	237	com/google/d/bk
    //   472	491	237	com/google/d/bk
    //   494	510	237	com/google/d/bk
    //   510	525	237	com/google/d/bk
    //   530	549	237	com/google/d/bk
    //   552	560	237	com/google/d/bk
    //   563	579	237	com/google/d/bk
    //   579	594	237	com/google/d/bk
    //   599	618	237	com/google/d/bk
    //   39	45	250	finally
    //   208	221	250	finally
    //   226	234	250	finally
    //   238	250	250	finally
    //   271	279	250	finally
    //   283	304	250	finally
    //   304	312	250	finally
    //   315	323	250	finally
    //   326	334	250	finally
    //   337	345	250	finally
    //   348	356	250	finally
    //   359	367	250	finally
    //   370	378	250	finally
    //   381	389	250	finally
    //   392	400	250	finally
    //   403	411	250	finally
    //   414	422	250	finally
    //   425	433	250	finally
    //   436	452	250	finally
    //   452	467	250	finally
    //   472	491	250	finally
    //   494	510	250	finally
    //   510	525	250	finally
    //   530	549	250	finally
    //   552	560	250	finally
    //   563	579	250	finally
    //   579	594	250	finally
    //   599	618	250	finally
    //   39	45	282	java/io/IOException
    //   208	221	282	java/io/IOException
    //   226	234	282	java/io/IOException
    //   271	279	282	java/io/IOException
    //   304	312	282	java/io/IOException
    //   315	323	282	java/io/IOException
    //   326	334	282	java/io/IOException
    //   337	345	282	java/io/IOException
    //   348	356	282	java/io/IOException
    //   359	367	282	java/io/IOException
    //   370	378	282	java/io/IOException
    //   381	389	282	java/io/IOException
    //   392	400	282	java/io/IOException
    //   403	411	282	java/io/IOException
    //   414	422	282	java/io/IOException
    //   425	433	282	java/io/IOException
    //   436	452	282	java/io/IOException
    //   452	467	282	java/io/IOException
    //   472	491	282	java/io/IOException
    //   494	510	282	java/io/IOException
    //   510	525	282	java/io/IOException
    //   530	549	282	java/io/IOException
    //   552	560	282	java/io/IOException
    //   563	579	282	java/io/IOException
    //   579	594	282	java/io/IOException
    //   599	618	282	java/io/IOException
  }
  
  public static a b(aa paramaa)
  {
    AppMethodBeat.i(232737);
    paramaa = adrK.jgI().g(paramaa);
    AppMethodBeat.o(232737);
    return paramaa;
  }
  
  public static aa dm(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(232719);
    paramArrayOfByte = (aa)PARSER.parseFrom(paramArrayOfByte);
    AppMethodBeat.o(232719);
    return paramArrayOfByte;
  }
  
  private h jfw()
  {
    AppMethodBeat.i(232709);
    Object localObject = this.efu;
    if ((localObject instanceof String))
    {
      localObject = h.dS((String)localObject);
      this.efu = localObject;
      AppMethodBeat.o(232709);
      return localObject;
    }
    localObject = (h)localObject;
    AppMethodBeat.o(232709);
    return localObject;
  }
  
  public static a jgH()
  {
    AppMethodBeat.i(232727);
    a locala = adrK.jgI();
    AppMethodBeat.o(232727);
    return locala;
  }
  
  public static aa jgJ()
  {
    return adrK;
  }
  
  public static cs<aa> parser()
  {
    return PARSER;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(233185);
    if (paramObject == this)
    {
      AppMethodBeat.o(233185);
      return true;
    }
    if (!(paramObject instanceof aa))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(233185);
      return bool;
    }
    paramObject = (aa)paramObject;
    if (this.adru != paramObject.adru)
    {
      AppMethodBeat.o(233185);
      return false;
    }
    if (!getPath().equals(paramObject.getPath()))
    {
      AppMethodBeat.o(233185);
      return false;
    }
    if (this.type_ != paramObject.type_)
    {
      AppMethodBeat.o(233185);
      return false;
    }
    if (this.adrv != paramObject.adrv)
    {
      AppMethodBeat.o(233185);
      return false;
    }
    if (this.adrw != paramObject.adrw)
    {
      AppMethodBeat.o(233185);
      return false;
    }
    if (this.adrx != paramObject.adrx)
    {
      AppMethodBeat.o(233185);
      return false;
    }
    if (this.adry != paramObject.adry)
    {
      AppMethodBeat.o(233185);
      return false;
    }
    if (this.adrz != paramObject.adrz)
    {
      AppMethodBeat.o(233185);
      return false;
    }
    if (this.adrA != paramObject.adrA)
    {
      AppMethodBeat.o(233185);
      return false;
    }
    if (this.adrB != paramObject.adrB)
    {
      AppMethodBeat.o(233185);
      return false;
    }
    if (Float.floatToIntBits(this.adrC) != Float.floatToIntBits(paramObject.adrC))
    {
      AppMethodBeat.o(233185);
      return false;
    }
    if (Float.floatToIntBits(this.adrD) != Float.floatToIntBits(paramObject.adrD))
    {
      AppMethodBeat.o(233185);
      return false;
    }
    if (this.adrE != paramObject.adrE)
    {
      AppMethodBeat.o(233185);
      return false;
    }
    if (Float.floatToIntBits(this.adrF) != Float.floatToIntBits(paramObject.adrF))
    {
      AppMethodBeat.o(233185);
      return false;
    }
    if (jgA() != paramObject.jgA())
    {
      AppMethodBeat.o(233185);
      return false;
    }
    if ((jgA()) && (!jgB().equals(paramObject.jgB())))
    {
      AppMethodBeat.o(233185);
      return false;
    }
    if (jgC() != paramObject.jgC())
    {
      AppMethodBeat.o(233185);
      return false;
    }
    if ((jgC()) && (!jgD().equals(paramObject.jgD())))
    {
      AppMethodBeat.o(233185);
      return false;
    }
    if (this.adrI != paramObject.adrI)
    {
      AppMethodBeat.o(233185);
      return false;
    }
    if (jgF() != paramObject.jgF())
    {
      AppMethodBeat.o(233185);
      return false;
    }
    if ((jgF()) && (!jgG().equals(paramObject.jgG())))
    {
      AppMethodBeat.o(233185);
      return false;
    }
    if (!this.unknownFields.equals(paramObject.unknownFields))
    {
      AppMethodBeat.o(233185);
      return false;
    }
    AppMethodBeat.o(233185);
    return true;
  }
  
  public final long getEndTimeMs()
  {
    return this.adrw;
  }
  
  public final long getId()
  {
    return this.adru;
  }
  
  public final cs<aa> getParserForType()
  {
    return PARSER;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(233066);
    Object localObject = this.efu;
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(233066);
      return localObject;
    }
    localObject = ((h)localObject).ZV();
    this.efu = localObject;
    AppMethodBeat.o(233066);
    return localObject;
  }
  
  public final float getPlayRate()
  {
    return this.adrF;
  }
  
  public final int getSerializedSize()
  {
    AppMethodBeat.i(233175);
    int i = this.memoizedSize;
    if (i != -1)
    {
      AppMethodBeat.o(233175);
      return i;
    }
    int j = 0;
    if (this.adru != 0L) {
      j = k.r(1, this.adru) + 0;
    }
    i = j;
    if (!jfw().isEmpty()) {
      i = j + bg.computeStringSize(2, this.efu);
    }
    j = i;
    if (this.type_ != o.adqI.getNumber()) {
      j = i + k.cM(3, this.type_);
    }
    i = j;
    if (this.adrv != 0L) {
      i = j + k.q(4, this.adrv);
    }
    j = i;
    if (this.adrw != 0L) {
      j = i + k.q(5, this.adrw);
    }
    i = j;
    if (this.adrx != 0L) {
      i = j + k.q(6, this.adrx);
    }
    j = i;
    if (this.adry != 0L) {
      j = i + k.q(7, this.adry);
    }
    i = j;
    if (this.adrz != 0L) {
      i = j + k.q(8, this.adrz);
    }
    j = i;
    if (this.adrA != 0) {
      j = i + k.cJ(9, this.adrA);
    }
    i = j;
    if (this.adrB != 0) {
      i = j + k.cJ(10, this.adrB);
    }
    j = i;
    if (this.adrC != 0.0F) {
      j = i + k.kl(11);
    }
    i = j;
    if (this.adrD != 0.0F) {
      i = j + k.kl(12);
    }
    j = i;
    if (this.adrE != 0) {
      j = i + k.cJ(13, this.adrE);
    }
    i = j;
    if (this.adrF != 0.0F) {
      i = j + k.kl(14);
    }
    j = i;
    if (this.adrG != null) {
      j = i + k.c(15, jgB());
    }
    i = j;
    if (this.adrH != null) {
      i = j + k.c(16, jgD());
    }
    j = i;
    if (this.adrI != p.adqP.getNumber()) {
      j = i + k.cM(17, this.adrI);
    }
    i = j;
    if (this.adrJ != null) {
      i = j + k.c(18, jgG());
    }
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    AppMethodBeat.o(233175);
    return i;
  }
  
  public final long getStartTimeMs()
  {
    return this.adrv;
  }
  
  public final dn getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public final float getVolume()
  {
    return this.adrD;
  }
  
  public final int hRY()
  {
    return this.adrE;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(233192);
    if (this.memoizedHashCode != 0)
    {
      i = this.memoizedHashCode;
      AppMethodBeat.o(233192);
      return i;
    }
    int j = ((((((((((((((((((((((((((((ae.adsf.hashCode() + 779) * 37 + 1) * 53 + bj.hashLong(this.adru)) * 37 + 2) * 53 + getPath().hashCode()) * 37 + 3) * 53 + this.type_) * 37 + 4) * 53 + bj.hashLong(this.adrv)) * 37 + 5) * 53 + bj.hashLong(this.adrw)) * 37 + 6) * 53 + bj.hashLong(this.adrx)) * 37 + 7) * 53 + bj.hashLong(this.adry)) * 37 + 8) * 53 + bj.hashLong(this.adrz)) * 37 + 9) * 53 + this.adrA) * 37 + 10) * 53 + this.adrB) * 37 + 11) * 53 + Float.floatToIntBits(this.adrC)) * 37 + 12) * 53 + Float.floatToIntBits(this.adrD)) * 37 + 13) * 53 + this.adrE) * 37 + 14) * 53 + Float.floatToIntBits(this.adrF);
    int i = j;
    if (jgA()) {
      i = (j * 37 + 15) * 53 + jgB().hashCode();
    }
    j = i;
    if (jgC()) {
      j = (i * 37 + 16) * 53 + jgD().hashCode();
    }
    j = (j * 37 + 17) * 53 + this.adrI;
    i = j;
    if (jgF()) {
      i = (j * 37 + 18) * 53 + jgG().hashCode();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    AppMethodBeat.o(233192);
    return i;
  }
  
  public final bg.e internalGetFieldAccessorTable()
  {
    AppMethodBeat.i(233048);
    bg.e locale = ae.adsg.b(aa.class, a.class);
    AppMethodBeat.o(233048);
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
  
  public final boolean jgA()
  {
    return this.adrG != null;
  }
  
  public final i jgB()
  {
    AppMethodBeat.i(233125);
    if (this.adrG == null)
    {
      locali = i.jfJ();
      AppMethodBeat.o(233125);
      return locali;
    }
    i locali = this.adrG;
    AppMethodBeat.o(233125);
    return locali;
  }
  
  public final boolean jgC()
  {
    return this.adrH != null;
  }
  
  public final ac jgD()
  {
    AppMethodBeat.i(233137);
    if (this.adrH == null)
    {
      localac = ac.jgP();
      AppMethodBeat.o(233137);
      return localac;
    }
    ac localac = this.adrH;
    AppMethodBeat.o(233137);
    return localac;
  }
  
  public final p jgE()
  {
    AppMethodBeat.i(233144);
    p localp = p.azA(this.adrI);
    if (localp == null)
    {
      localp = p.adqS;
      AppMethodBeat.o(233144);
      return localp;
    }
    AppMethodBeat.o(233144);
    return localp;
  }
  
  public final boolean jgF()
  {
    return this.adrJ != null;
  }
  
  public final y jgG()
  {
    AppMethodBeat.i(233155);
    if (this.adrJ == null)
    {
      localy = y.jgt();
      AppMethodBeat.o(233155);
      return localy;
    }
    y localy = this.adrJ;
    AppMethodBeat.o(233155);
    return localy;
  }
  
  public final a jgI()
  {
    AppMethodBeat.i(233195);
    if (this == adrK)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(233195);
      return locala;
    }
    a locala = new a((byte)0).g(this);
    AppMethodBeat.o(233195);
    return locala;
  }
  
  public final o jgx()
  {
    AppMethodBeat.i(233076);
    o localo = o.azz(this.type_);
    if (localo == null)
    {
      localo = o.adqM;
      AppMethodBeat.o(233076);
      return localo;
    }
    AppMethodBeat.o(233076);
    return localo;
  }
  
  public final long jgy()
  {
    return this.adrx;
  }
  
  public final long jgz()
  {
    return this.adry;
  }
  
  public final Object newInstance(bg.f paramf)
  {
    AppMethodBeat.i(233031);
    paramf = new aa();
    AppMethodBeat.o(233031);
    return paramf;
  }
  
  public final void writeTo(k paramk)
  {
    AppMethodBeat.i(233166);
    if (this.adru != 0L) {
      paramk.n(1, this.adru);
    }
    if (!jfw().isEmpty()) {
      bg.writeString(paramk, 2, this.efu);
    }
    if (this.type_ != o.adqI.getNumber()) {
      paramk.cF(3, this.type_);
    }
    if (this.adrv != 0L) {
      paramk.n(4, this.adrv);
    }
    if (this.adrw != 0L) {
      paramk.n(5, this.adrw);
    }
    if (this.adrx != 0L) {
      paramk.n(6, this.adrx);
    }
    if (this.adry != 0L) {
      paramk.n(7, this.adry);
    }
    if (this.adrz != 0L) {
      paramk.n(8, this.adrz);
    }
    if (this.adrA != 0) {
      paramk.cF(9, this.adrA);
    }
    if (this.adrB != 0) {
      paramk.cF(10, this.adrB);
    }
    if (this.adrC != 0.0F) {
      paramk.l(11, this.adrC);
    }
    if (this.adrD != 0.0F) {
      paramk.l(12, this.adrD);
    }
    if (this.adrE != 0) {
      paramk.cF(13, this.adrE);
    }
    if (this.adrF != 0.0F) {
      paramk.l(14, this.adrF);
    }
    if (this.adrG != null) {
      paramk.a(15, jgB());
    }
    if (this.adrH != null) {
      paramk.a(16, jgD());
    }
    if (this.adrI != p.adqP.getNumber()) {
      paramk.cF(17, this.adrI);
    }
    if (this.adrJ != null) {
      paramk.a(18, jgG());
    }
    this.unknownFields.writeTo(paramk);
    AppMethodBeat.o(233166);
  }
  
  public static final class a
    extends bg.a<a>
    implements ab
  {
    private int adrA;
    private int adrB;
    private float adrC;
    private float adrD;
    private int adrE;
    private float adrF;
    private i adrG;
    private ac adrH;
    private int adrI;
    private y adrJ;
    private df<i, i.a, j> adrL;
    private df<ac, ac.a, ad> adrM;
    private df<y, y.a, z> adrN;
    private long adru;
    private long adrv;
    private long adrw;
    private long adrx;
    private long adry;
    private long adrz;
    private Object efu;
    private int type_;
    
    private a()
    {
      AppMethodBeat.i(232739);
      this.efu = "";
      this.type_ = 0;
      this.adrI = 0;
      aa.ayB();
      AppMethodBeat.o(232739);
    }
    
    private a(bg.b paramb)
    {
      super();
      AppMethodBeat.i(232758);
      this.efu = "";
      this.type_ = 0;
      this.adrI = 0;
      aa.ayB();
      AppMethodBeat.o(232758);
    }
    
    private a U(am.f paramf, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(232878);
      paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
      AppMethodBeat.o(232878);
      return paramf;
    }
    
    /* Error */
    private a U(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: ldc 88
      //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 92	com/tencent/mm/timelineedit/a/a/aa:jgK	()Lcom/google/d/cs;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 98 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/aa
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 102	com/tencent/mm/timelineedit/a/a/aa$a:g	(Lcom/tencent/mm/timelineedit/a/a/aa;)Lcom/tencent/mm/timelineedit/a/a/aa$a;
      //   30: pop
      //   31: ldc 88
      //   33: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 106	com/google/d/bk:dST	Lcom/google/d/ce;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/aa
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 110	com/google/d/bk:aii	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 88
      //   54: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 102	com/tencent/mm/timelineedit/a/a/aa$a:g	(Lcom/tencent/mm/timelineedit/a/a/aa;)Lcom/tencent/mm/timelineedit/a/a/aa$a;
      //   69: pop
      //   70: ldc 88
      //   72: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    private a V(cb paramcb)
    {
      AppMethodBeat.i(232911);
      if ((paramcb instanceof aa))
      {
        paramcb = g((aa)paramcb);
        AppMethodBeat.o(232911);
        return paramcb;
      }
      super.mergeFrom(paramcb);
      AppMethodBeat.o(232911);
      return this;
    }
    
    private a Y(am.j paramj)
    {
      AppMethodBeat.i(232857);
      paramj = (a)super.clearOneof(paramj);
      AppMethodBeat.o(232857);
      return paramj;
    }
    
    private a a(ac paramac)
    {
      AppMethodBeat.i(233008);
      if (this.adrM == null) {
        if (this.adrH != null)
        {
          this.adrH = ac.b(this.adrH).e(paramac).jgS();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(233008);
        return this;
        this.adrH = paramac;
        break;
        this.adrM.c(paramac);
      }
    }
    
    private a aQ(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232820);
      paramf = (a)super.setField(paramf, paramObject);
      AppMethodBeat.o(232820);
      return paramf;
    }
    
    private a aR(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232893);
      paramf = (a)super.addRepeatedField(paramf, paramObject);
      AppMethodBeat.o(232893);
      return paramf;
    }
    
    private a aS(dn paramdn)
    {
      AppMethodBeat.i(233056);
      paramdn = (a)super.setUnknownFields(paramdn);
      AppMethodBeat.o(233056);
      return paramdn;
    }
    
    private a aT(dn paramdn)
    {
      AppMethodBeat.i(233071);
      paramdn = (a)super.mergeUnknownFields(paramdn);
      AppMethodBeat.o(233071);
      return paramdn;
    }
    
    private a ac(am.f paramf)
    {
      AppMethodBeat.i(232838);
      paramf = (a)super.clearField(paramf);
      AppMethodBeat.o(232838);
      return paramf;
    }
    
    private a azL(int paramInt)
    {
      AppMethodBeat.i(232947);
      this.type_ = paramInt;
      onChanged();
      AppMethodBeat.o(232947);
      return this;
    }
    
    private a azP(int paramInt)
    {
      AppMethodBeat.i(233023);
      this.adrI = paramInt;
      onChanged();
      AppMethodBeat.o(233023);
      return this;
    }
    
    private a dN(float paramFloat)
    {
      AppMethodBeat.i(232963);
      this.adrC = paramFloat;
      onChanged();
      AppMethodBeat.o(232963);
      return this;
    }
    
    private a e(i parami)
    {
      AppMethodBeat.i(232987);
      if (this.adrL == null) {
        if (this.adrG != null)
        {
          this.adrG = i.a(this.adrG).c(parami).jfM();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(232987);
        return this;
        this.adrG = parami;
        break;
        this.adrL.c(parami);
      }
    }
    
    private a e(y paramy)
    {
      AppMethodBeat.i(233040);
      if (this.adrN == null) {
        if (this.adrJ != null)
        {
          this.adrJ = y.a(this.adrJ).d(paramy).jgw();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(233040);
        return this;
        this.adrJ = paramy;
        break;
        this.adrN.c(paramy);
      }
    }
    
    private a jgL()
    {
      AppMethodBeat.i(232780);
      super.clear();
      this.adru = 0L;
      this.efu = "";
      this.type_ = 0;
      this.adrv = 0L;
      this.adrw = 0L;
      this.adrx = 0L;
      this.adry = 0L;
      this.adrz = 0L;
      this.adrA = 0;
      this.adrB = 0;
      this.adrC = 0.0F;
      this.adrD = 0.0F;
      this.adrE = 0;
      this.adrF = 0.0F;
      if (this.adrL == null)
      {
        this.adrG = null;
        if (this.adrM != null) {
          break label142;
        }
        this.adrH = null;
        label105:
        this.adrI = 0;
        if (this.adrN != null) {
          break label155;
        }
        this.adrJ = null;
      }
      for (;;)
      {
        AppMethodBeat.o(232780);
        return this;
        this.adrG = null;
        this.adrL = null;
        break;
        label142:
        this.adrH = null;
        this.adrM = null;
        break label105;
        label155:
        this.adrJ = null;
        this.adrN = null;
      }
    }
    
    private aa jgM()
    {
      AppMethodBeat.i(232801);
      Object localObject = jgN();
      if (!((aa)localObject).isInitialized())
      {
        localObject = newUninitializedMessageException((cb)localObject);
        AppMethodBeat.o(232801);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(232801);
      return localObject;
    }
    
    public final a azM(int paramInt)
    {
      AppMethodBeat.i(233227);
      this.adrA = paramInt;
      onChanged();
      AppMethodBeat.o(233227);
      return this;
    }
    
    public final a azN(int paramInt)
    {
      AppMethodBeat.i(233229);
      this.adrB = paramInt;
      onChanged();
      AppMethodBeat.o(233229);
      return this;
    }
    
    public final a azO(int paramInt)
    {
      AppMethodBeat.i(233253);
      this.adrE = paramInt;
      onChanged();
      AppMethodBeat.o(233253);
      return this;
    }
    
    public final a b(o paramo)
    {
      AppMethodBeat.i(233198);
      if (paramo == null)
      {
        paramo = new NullPointerException();
        AppMethodBeat.o(233198);
        throw paramo;
      }
      this.type_ = paramo.getNumber();
      onChanged();
      AppMethodBeat.o(233198);
      return this;
    }
    
    public final a b(p paramp)
    {
      AppMethodBeat.i(233288);
      if (paramp == null)
      {
        paramp = new NullPointerException();
        AppMethodBeat.o(233288);
        throw paramp;
      }
      this.adrI = paramp.getNumber();
      onChanged();
      AppMethodBeat.o(233288);
      return this;
    }
    
    public final a bzy(String paramString)
    {
      AppMethodBeat.i(233186);
      if (paramString == null)
      {
        paramString = new NullPointerException();
        AppMethodBeat.o(233186);
        throw paramString;
      }
      this.efu = paramString;
      onChanged();
      AppMethodBeat.o(233186);
      return this;
    }
    
    public final a d(i parami)
    {
      AppMethodBeat.i(233270);
      if (this.adrL == null)
      {
        if (parami == null)
        {
          parami = new NullPointerException();
          AppMethodBeat.o(233270);
          throw parami;
        }
        this.adrG = parami;
        onChanged();
      }
      for (;;)
      {
        AppMethodBeat.o(233270);
        return this;
        this.adrL.b(parami);
      }
    }
    
    public final a dO(float paramFloat)
    {
      AppMethodBeat.i(233242);
      this.adrD = paramFloat;
      onChanged();
      AppMethodBeat.o(233242);
      return this;
    }
    
    public final a dP(float paramFloat)
    {
      AppMethodBeat.i(233258);
      this.adrF = paramFloat;
      onChanged();
      AppMethodBeat.o(233258);
      return this;
    }
    
    public final int ejR()
    {
      return this.adrA;
    }
    
    public final int ejS()
    {
      return this.adrB;
    }
    
    public final a g(aa paramaa)
    {
      AppMethodBeat.i(233147);
      if (paramaa == aa.jgJ())
      {
        AppMethodBeat.o(233147);
        return this;
      }
      if (paramaa.adru != 0L) {
        zu(paramaa.adru);
      }
      if (!paramaa.getPath().isEmpty())
      {
        this.efu = aa.c(paramaa);
        onChanged();
      }
      if (aa.d(paramaa) != 0) {
        azL(paramaa.type_);
      }
      if (paramaa.adrv != 0L) {
        zv(paramaa.adrv);
      }
      if (paramaa.adrw != 0L) {
        zw(paramaa.adrw);
      }
      if (paramaa.adrx != 0L) {
        zx(paramaa.adrx);
      }
      if (paramaa.adry != 0L) {
        zy(paramaa.adry);
      }
      if (paramaa.adrz != 0L) {
        zz(paramaa.adrz);
      }
      if (paramaa.adrA != 0) {
        azM(paramaa.adrA);
      }
      if (paramaa.adrB != 0) {
        azN(paramaa.adrB);
      }
      if (paramaa.adrC != 0.0F) {
        dN(paramaa.adrC);
      }
      if (paramaa.adrD != 0.0F) {
        dO(paramaa.adrD);
      }
      if (paramaa.adrE != 0) {
        azO(paramaa.adrE);
      }
      if (paramaa.adrF != 0.0F) {
        dP(paramaa.adrF);
      }
      if (paramaa.jgA()) {
        e(paramaa.jgB());
      }
      if (paramaa.jgC()) {
        a(paramaa.jgD());
      }
      if (aa.e(paramaa) != 0) {
        azP(paramaa.adrI);
      }
      if (paramaa.jgF()) {
        e(paramaa.jgG());
      }
      aT(aa.f(paramaa));
      onChanged();
      AppMethodBeat.o(233147);
      return this;
    }
    
    public final am.a getDescriptorForType()
    {
      return ae.adsf;
    }
    
    public final long getEndTimeMs()
    {
      return this.adrw;
    }
    
    public final long getId()
    {
      return this.adru;
    }
    
    public final String getPath()
    {
      AppMethodBeat.i(233178);
      Object localObject = this.efu;
      if (!(localObject instanceof String))
      {
        localObject = ((h)localObject).ZV();
        this.efu = localObject;
        AppMethodBeat.o(233178);
        return localObject;
      }
      localObject = (String)localObject;
      AppMethodBeat.o(233178);
      return localObject;
    }
    
    public final float getPlayRate()
    {
      return this.adrF;
    }
    
    public final long getSourceDuration()
    {
      return this.adrz;
    }
    
    public final long getStartTimeMs()
    {
      return this.adrv;
    }
    
    public final float getVolume()
    {
      return this.adrD;
    }
    
    public final int hRY()
    {
      return this.adrE;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(233104);
      bg.e locale = ae.adsg.b(aa.class, a.class);
      AppMethodBeat.o(233104);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public final i jgB()
    {
      AppMethodBeat.i(233263);
      if (this.adrL == null)
      {
        if (this.adrG == null)
        {
          locali = i.jfJ();
          AppMethodBeat.o(233263);
          return locali;
        }
        locali = this.adrG;
        AppMethodBeat.o(233263);
        return locali;
      }
      i locali = (i)this.adrL.ajm();
      AppMethodBeat.o(233263);
      return locali;
    }
    
    public final p jgE()
    {
      AppMethodBeat.i(233275);
      p localp = p.azA(this.adrI);
      if (localp == null)
      {
        localp = p.adqS;
        AppMethodBeat.o(233275);
        return localp;
      }
      AppMethodBeat.o(233275);
      return localp;
    }
    
    public final aa jgN()
    {
      AppMethodBeat.i(233128);
      aa localaa = new aa(this, (byte)0);
      aa.a(localaa, this.adru);
      aa.a(localaa, this.efu);
      aa.a(localaa, this.type_);
      aa.b(localaa, this.adrv);
      aa.c(localaa, this.adrw);
      aa.d(localaa, this.adrx);
      aa.e(localaa, this.adry);
      aa.f(localaa, this.adrz);
      aa.b(localaa, this.adrA);
      aa.c(localaa, this.adrB);
      aa.a(localaa, this.adrC);
      aa.b(localaa, this.adrD);
      aa.d(localaa, this.adrE);
      aa.c(localaa, this.adrF);
      if (this.adrL == null)
      {
        aa.a(localaa, this.adrG);
        if (this.adrM != null) {
          break label229;
        }
        aa.a(localaa, this.adrH);
        label174:
        aa.e(localaa, this.adrI);
        if (this.adrN != null) {
          break label247;
        }
        aa.a(localaa, this.adrJ);
      }
      for (;;)
      {
        onBuilt();
        AppMethodBeat.o(233128);
        return localaa;
        aa.a(localaa, (i)this.adrL.ajn());
        break;
        label229:
        aa.a(localaa, (ac)this.adrM.ajn());
        break label174;
        label247:
        aa.a(localaa, (y)this.adrN.ajn());
      }
    }
    
    public final o jgx()
    {
      AppMethodBeat.i(233194);
      o localo = o.azz(this.type_);
      if (localo == null)
      {
        localo = o.adqM;
        AppMethodBeat.o(233194);
        return localo;
      }
      AppMethodBeat.o(233194);
      return localo;
    }
    
    public final long jgy()
    {
      return this.adrx;
    }
    
    public final long jgz()
    {
      return this.adry;
    }
    
    public final a zu(long paramLong)
    {
      AppMethodBeat.i(233170);
      this.adru = paramLong;
      onChanged();
      AppMethodBeat.o(233170);
      return this;
    }
    
    public final a zv(long paramLong)
    {
      AppMethodBeat.i(233206);
      this.adrv = paramLong;
      onChanged();
      AppMethodBeat.o(233206);
      return this;
    }
    
    public final a zw(long paramLong)
    {
      AppMethodBeat.i(233212);
      this.adrw = paramLong;
      onChanged();
      AppMethodBeat.o(233212);
      return this;
    }
    
    public final a zx(long paramLong)
    {
      AppMethodBeat.i(233215);
      this.adrx = paramLong;
      onChanged();
      AppMethodBeat.o(233215);
      return this;
    }
    
    public final a zy(long paramLong)
    {
      AppMethodBeat.i(233221);
      this.adry = paramLong;
      onChanged();
      AppMethodBeat.o(233221);
      return this;
    }
    
    public final a zz(long paramLong)
    {
      AppMethodBeat.i(233226);
      this.adrz = paramLong;
      onChanged();
      AppMethodBeat.o(233226);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.aa
 * JD-Core Version:    0.7.0.1
 */