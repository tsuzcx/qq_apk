package com.tencent.mm.timelineedit.a.a;

import com.google.b.aj.a;
import com.google.b.aj.f;
import com.google.b.bb;
import com.google.b.bb.a;
import com.google.b.bb.b;
import com.google.b.bb.e;
import com.google.b.be;
import com.google.b.bt;
import com.google.b.c;
import com.google.b.ci;
import com.google.b.cs;
import com.google.b.da;
import com.google.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aa
  extends bb
  implements ab
{
  private static final aa VNF;
  private static final ci<aa> bRf;
  float VNA;
  private i VNB;
  private ac VNC;
  int VND;
  private y VNE;
  long VNp;
  long VNq;
  long VNr;
  long VNs;
  long VNt;
  long VNu;
  int VNv;
  int VNw;
  float VNx;
  float VNy;
  int VNz;
  private byte bRd = -1;
  private volatile Object coo;
  int type_;
  
  static
  {
    AppMethodBeat.i(261561);
    VNF = new aa();
    bRf = new c() {};
    AppMethodBeat.o(261561);
  }
  
  private aa()
  {
    this.coo = "";
    this.type_ = 0;
    this.VND = 0;
  }
  
  private aa(bb.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private aa(com.google.b.h paramh, com.google.b.ap paramap)
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
    //   28: invokestatic 97	com/google/b/da:Jj	()Lcom/google/b/da$a;
    //   31: astore 6
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +585 -> 621
    //   39: aload_1
    //   40: invokevirtual 103	com/google/b/h:Av	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+614->661, 0:+620->667, 8:+179->226, 18:+224->271, 24:+257->304, 32:+268->315, 40:+279->326, 48:+290->337, 56:+301->348, 64:+312->359, 72:+323->370, 80:+334->381, 93:+345->392, 101:+356->403, 104:+367->414, 117:+378->425, 122:+389->436, 130:+447->494, 136:+505->552, 146:+516->563
    //   209: aload_1
    //   210: aload 6
    //   212: aload_2
    //   213: iload 4
    //   215: invokevirtual 106	com/tencent/mm/timelineedit/a/a/aa:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
    //   218: ifne +422 -> 640
    //   221: iconst_1
    //   222: istore_3
    //   223: goto +441 -> 664
    //   226: aload_0
    //   227: aload_1
    //   228: invokevirtual 110	com/google/b/h:Aw	()J
    //   231: putfield 112	com/tencent/mm/timelineedit/a/a/aa:VNp	J
    //   234: goto -199 -> 35
    //   237: astore_1
    //   238: aload_1
    //   239: aload_0
    //   240: putfield 116	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   243: ldc 88
    //   245: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: aload_1
    //   249: athrow
    //   250: astore_1
    //   251: aload_0
    //   252: aload 6
    //   254: invokevirtual 122	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   257: putfield 126	com/tencent/mm/timelineedit/a/a/aa:bVW	Lcom/google/b/da;
    //   260: aload_0
    //   261: invokevirtual 129	com/tencent/mm/timelineedit/a/a/aa:HZ	()V
    //   264: ldc 88
    //   266: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: aload_1
    //   270: athrow
    //   271: aload_0
    //   272: aload_1
    //   273: invokevirtual 133	com/google/b/h:AC	()Ljava/lang/String;
    //   276: putfield 71	com/tencent/mm/timelineedit/a/a/aa:coo	Ljava/lang/Object;
    //   279: goto -244 -> 35
    //   282: astore_1
    //   283: new 85	com/google/b/bf
    //   286: dup
    //   287: aload_1
    //   288: invokespecial 136	com/google/b/bf:<init>	(Ljava/io/IOException;)V
    //   291: astore_1
    //   292: aload_1
    //   293: aload_0
    //   294: putfield 116	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   297: ldc 88
    //   299: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   302: aload_1
    //   303: athrow
    //   304: aload_0
    //   305: aload_1
    //   306: invokevirtual 139	com/google/b/h:AF	()I
    //   309: putfield 73	com/tencent/mm/timelineedit/a/a/aa:type_	I
    //   312: goto -277 -> 35
    //   315: aload_0
    //   316: aload_1
    //   317: invokevirtual 142	com/google/b/h:Ax	()J
    //   320: putfield 144	com/tencent/mm/timelineedit/a/a/aa:VNq	J
    //   323: goto -288 -> 35
    //   326: aload_0
    //   327: aload_1
    //   328: invokevirtual 142	com/google/b/h:Ax	()J
    //   331: putfield 146	com/tencent/mm/timelineedit/a/a/aa:VNr	J
    //   334: goto -299 -> 35
    //   337: aload_0
    //   338: aload_1
    //   339: invokevirtual 142	com/google/b/h:Ax	()J
    //   342: putfield 148	com/tencent/mm/timelineedit/a/a/aa:VNs	J
    //   345: goto -310 -> 35
    //   348: aload_0
    //   349: aload_1
    //   350: invokevirtual 142	com/google/b/h:Ax	()J
    //   353: putfield 150	com/tencent/mm/timelineedit/a/a/aa:VNt	J
    //   356: goto -321 -> 35
    //   359: aload_0
    //   360: aload_1
    //   361: invokevirtual 142	com/google/b/h:Ax	()J
    //   364: putfield 152	com/tencent/mm/timelineedit/a/a/aa:VNu	J
    //   367: goto -332 -> 35
    //   370: aload_0
    //   371: aload_1
    //   372: invokevirtual 155	com/google/b/h:Ay	()I
    //   375: putfield 157	com/tencent/mm/timelineedit/a/a/aa:VNv	I
    //   378: goto -343 -> 35
    //   381: aload_0
    //   382: aload_1
    //   383: invokevirtual 155	com/google/b/h:Ay	()I
    //   386: putfield 159	com/tencent/mm/timelineedit/a/a/aa:VNw	I
    //   389: goto -354 -> 35
    //   392: aload_0
    //   393: aload_1
    //   394: invokevirtual 163	com/google/b/h:readFloat	()F
    //   397: putfield 165	com/tencent/mm/timelineedit/a/a/aa:VNx	F
    //   400: goto -365 -> 35
    //   403: aload_0
    //   404: aload_1
    //   405: invokevirtual 163	com/google/b/h:readFloat	()F
    //   408: putfield 167	com/tencent/mm/timelineedit/a/a/aa:VNy	F
    //   411: goto -376 -> 35
    //   414: aload_0
    //   415: aload_1
    //   416: invokevirtual 155	com/google/b/h:Ay	()I
    //   419: putfield 169	com/tencent/mm/timelineedit/a/a/aa:VNz	I
    //   422: goto -387 -> 35
    //   425: aload_0
    //   426: aload_1
    //   427: invokevirtual 163	com/google/b/h:readFloat	()F
    //   430: putfield 171	com/tencent/mm/timelineedit/a/a/aa:VNA	F
    //   433: goto -398 -> 35
    //   436: aload_0
    //   437: getfield 173	com/tencent/mm/timelineedit/a/a/aa:VNB	Lcom/tencent/mm/timelineedit/a/a/i;
    //   440: ifnull +215 -> 655
    //   443: aload_0
    //   444: getfield 173	com/tencent/mm/timelineedit/a/a/aa:VNB	Lcom/tencent/mm/timelineedit/a/a/i;
    //   447: invokevirtual 179	com/tencent/mm/timelineedit/a/a/i:hDA	()Lcom/tencent/mm/timelineedit/a/a/i$a;
    //   450: astore 5
    //   452: aload_0
    //   453: aload_1
    //   454: invokestatic 183	com/tencent/mm/timelineedit/a/a/i:hCD	()Lcom/google/b/ci;
    //   457: aload_2
    //   458: invokevirtual 186	com/google/b/h:a	(Lcom/google/b/ci;Lcom/google/b/ap;)Lcom/google/b/bw;
    //   461: checkcast 175	com/tencent/mm/timelineedit/a/a/i
    //   464: putfield 173	com/tencent/mm/timelineedit/a/a/aa:VNB	Lcom/tencent/mm/timelineedit/a/a/i;
    //   467: aload 5
    //   469: ifnull +171 -> 640
    //   472: aload 5
    //   474: aload_0
    //   475: getfield 173	com/tencent/mm/timelineedit/a/a/aa:VNB	Lcom/tencent/mm/timelineedit/a/a/i;
    //   478: invokevirtual 192	com/tencent/mm/timelineedit/a/a/i$a:c	(Lcom/tencent/mm/timelineedit/a/a/i;)Lcom/tencent/mm/timelineedit/a/a/i$a;
    //   481: pop
    //   482: aload_0
    //   483: aload 5
    //   485: invokevirtual 196	com/tencent/mm/timelineedit/a/a/i$a:hDD	()Lcom/tencent/mm/timelineedit/a/a/i;
    //   488: putfield 173	com/tencent/mm/timelineedit/a/a/aa:VNB	Lcom/tencent/mm/timelineedit/a/a/i;
    //   491: goto -456 -> 35
    //   494: aload_0
    //   495: getfield 198	com/tencent/mm/timelineedit/a/a/aa:VNC	Lcom/tencent/mm/timelineedit/a/a/ac;
    //   498: ifnull +151 -> 649
    //   501: aload_0
    //   502: getfield 198	com/tencent/mm/timelineedit/a/a/aa:VNC	Lcom/tencent/mm/timelineedit/a/a/ac;
    //   505: invokevirtual 204	com/tencent/mm/timelineedit/a/a/ac:hED	()Lcom/tencent/mm/timelineedit/a/a/ac$a;
    //   508: astore 5
    //   510: aload_0
    //   511: aload_1
    //   512: invokestatic 205	com/tencent/mm/timelineedit/a/a/ac:hCD	()Lcom/google/b/ci;
    //   515: aload_2
    //   516: invokevirtual 186	com/google/b/h:a	(Lcom/google/b/ci;Lcom/google/b/ap;)Lcom/google/b/bw;
    //   519: checkcast 200	com/tencent/mm/timelineedit/a/a/ac
    //   522: putfield 198	com/tencent/mm/timelineedit/a/a/aa:VNC	Lcom/tencent/mm/timelineedit/a/a/ac;
    //   525: aload 5
    //   527: ifnull +113 -> 640
    //   530: aload 5
    //   532: aload_0
    //   533: getfield 198	com/tencent/mm/timelineedit/a/a/aa:VNC	Lcom/tencent/mm/timelineedit/a/a/ac;
    //   536: invokevirtual 211	com/tencent/mm/timelineedit/a/a/ac$a:e	(Lcom/tencent/mm/timelineedit/a/a/ac;)Lcom/tencent/mm/timelineedit/a/a/ac$a;
    //   539: pop
    //   540: aload_0
    //   541: aload 5
    //   543: invokevirtual 215	com/tencent/mm/timelineedit/a/a/ac$a:hEG	()Lcom/tencent/mm/timelineedit/a/a/ac;
    //   546: putfield 198	com/tencent/mm/timelineedit/a/a/aa:VNC	Lcom/tencent/mm/timelineedit/a/a/ac;
    //   549: goto -514 -> 35
    //   552: aload_0
    //   553: aload_1
    //   554: invokevirtual 139	com/google/b/h:AF	()I
    //   557: putfield 75	com/tencent/mm/timelineedit/a/a/aa:VND	I
    //   560: goto -525 -> 35
    //   563: aload_0
    //   564: getfield 217	com/tencent/mm/timelineedit/a/a/aa:VNE	Lcom/tencent/mm/timelineedit/a/a/y;
    //   567: ifnull +76 -> 643
    //   570: aload_0
    //   571: getfield 217	com/tencent/mm/timelineedit/a/a/aa:VNE	Lcom/tencent/mm/timelineedit/a/a/y;
    //   574: invokevirtual 223	com/tencent/mm/timelineedit/a/a/y:hEh	()Lcom/tencent/mm/timelineedit/a/a/y$a;
    //   577: astore 5
    //   579: aload_0
    //   580: aload_1
    //   581: invokestatic 224	com/tencent/mm/timelineedit/a/a/y:hCD	()Lcom/google/b/ci;
    //   584: aload_2
    //   585: invokevirtual 186	com/google/b/h:a	(Lcom/google/b/ci;Lcom/google/b/ap;)Lcom/google/b/bw;
    //   588: checkcast 219	com/tencent/mm/timelineedit/a/a/y
    //   591: putfield 217	com/tencent/mm/timelineedit/a/a/aa:VNE	Lcom/tencent/mm/timelineedit/a/a/y;
    //   594: aload 5
    //   596: ifnull +44 -> 640
    //   599: aload 5
    //   601: aload_0
    //   602: getfield 217	com/tencent/mm/timelineedit/a/a/aa:VNE	Lcom/tencent/mm/timelineedit/a/a/y;
    //   605: invokevirtual 230	com/tencent/mm/timelineedit/a/a/y$a:d	(Lcom/tencent/mm/timelineedit/a/a/y;)Lcom/tencent/mm/timelineedit/a/a/y$a;
    //   608: pop
    //   609: aload_0
    //   610: aload 5
    //   612: invokevirtual 234	com/tencent/mm/timelineedit/a/a/y$a:hEk	()Lcom/tencent/mm/timelineedit/a/a/y;
    //   615: putfield 217	com/tencent/mm/timelineedit/a/a/aa:VNE	Lcom/tencent/mm/timelineedit/a/a/y;
    //   618: goto -583 -> 35
    //   621: aload_0
    //   622: aload 6
    //   624: invokevirtual 122	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   627: putfield 126	com/tencent/mm/timelineedit/a/a/aa:bVW	Lcom/google/b/da;
    //   630: aload_0
    //   631: invokevirtual 129	com/tencent/mm/timelineedit/a/a/aa:HZ	()V
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
    //   0	672	1	paramh	com.google.b.h
    //   0	672	2	paramap	com.google.b.ap
    //   34	635	3	i	int
    //   43	171	4	j	int
    //   450	207	5	localObject	Object
    //   31	592	6	locala	com.google.b.da.a
    // Exception table:
    //   from	to	target	type
    //   39	45	237	com/google/b/bf
    //   208	221	237	com/google/b/bf
    //   226	234	237	com/google/b/bf
    //   271	279	237	com/google/b/bf
    //   304	312	237	com/google/b/bf
    //   315	323	237	com/google/b/bf
    //   326	334	237	com/google/b/bf
    //   337	345	237	com/google/b/bf
    //   348	356	237	com/google/b/bf
    //   359	367	237	com/google/b/bf
    //   370	378	237	com/google/b/bf
    //   381	389	237	com/google/b/bf
    //   392	400	237	com/google/b/bf
    //   403	411	237	com/google/b/bf
    //   414	422	237	com/google/b/bf
    //   425	433	237	com/google/b/bf
    //   436	452	237	com/google/b/bf
    //   452	467	237	com/google/b/bf
    //   472	491	237	com/google/b/bf
    //   494	510	237	com/google/b/bf
    //   510	525	237	com/google/b/bf
    //   530	549	237	com/google/b/bf
    //   552	560	237	com/google/b/bf
    //   563	579	237	com/google/b/bf
    //   579	594	237	com/google/b/bf
    //   599	618	237	com/google/b/bf
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
    AppMethodBeat.i(261534);
    paramaa = VNF.hEw().g(paramaa);
    AppMethodBeat.o(261534);
    return paramaa;
  }
  
  public static aa dj(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(261530);
    paramArrayOfByte = (aa)bRf.w(paramArrayOfByte);
    AppMethodBeat.o(261530);
    return paramArrayOfByte;
  }
  
  public static ci<aa> hCD()
  {
    return bRf;
  }
  
  private g hDp()
  {
    AppMethodBeat.i(261500);
    Object localObject = this.coo;
    if ((localObject instanceof String))
    {
      localObject = g.ct((String)localObject);
      this.coo = localObject;
      AppMethodBeat.o(261500);
      return localObject;
    }
    localObject = (g)localObject;
    AppMethodBeat.o(261500);
    return localObject;
  }
  
  public static a hEv()
  {
    AppMethodBeat.i(261532);
    a locala = VNF.hEw();
    AppMethodBeat.o(261532);
    return locala;
  }
  
  public static aa hEx()
  {
    return VNF;
  }
  
  public final int Ad()
  {
    AppMethodBeat.i(261521);
    int i = this.bOZ;
    if (i != -1)
    {
      AppMethodBeat.o(261521);
      return i;
    }
    int j = 0;
    if (this.VNp != 0L) {
      j = com.google.b.i.q(1, this.VNp) + 0;
    }
    i = j;
    if (!hDp().isEmpty()) {
      i = j + bb.f(2, this.coo);
    }
    j = i;
    if (this.type_ != o.VMD.getNumber()) {
      j = i + com.google.b.i.bO(3, this.type_);
    }
    i = j;
    if (this.VNq != 0L) {
      i = j + com.google.b.i.p(4, this.VNq);
    }
    j = i;
    if (this.VNr != 0L) {
      j = i + com.google.b.i.p(5, this.VNr);
    }
    i = j;
    if (this.VNs != 0L) {
      i = j + com.google.b.i.p(6, this.VNs);
    }
    j = i;
    if (this.VNt != 0L) {
      j = i + com.google.b.i.p(7, this.VNt);
    }
    i = j;
    if (this.VNu != 0L) {
      i = j + com.google.b.i.p(8, this.VNu);
    }
    j = i;
    if (this.VNv != 0) {
      j = i + com.google.b.i.bM(9, this.VNv);
    }
    i = j;
    if (this.VNw != 0) {
      i = j + com.google.b.i.bM(10, this.VNw);
    }
    j = i;
    if (this.VNx != 0.0F) {
      j = i + com.google.b.i.gJ(11);
    }
    i = j;
    if (this.VNy != 0.0F) {
      i = j + com.google.b.i.gJ(12);
    }
    j = i;
    if (this.VNz != 0) {
      j = i + com.google.b.i.bM(13, this.VNz);
    }
    i = j;
    if (this.VNA != 0.0F) {
      i = j + com.google.b.i.gJ(14);
    }
    j = i;
    if (this.VNB != null) {
      j = i + com.google.b.i.c(15, hEp());
    }
    i = j;
    if (this.VNC != null) {
      i = j + com.google.b.i.c(16, hEr());
    }
    j = i;
    if (this.VND != p.VMK.getNumber()) {
      j = i + com.google.b.i.bO(17, this.VND);
    }
    i = j;
    if (this.VNE != null) {
      i = j + com.google.b.i.c(18, hEu());
    }
    i += this.bVW.Ad();
    this.bOZ = i;
    AppMethodBeat.o(261521);
    return i;
  }
  
  public final da Ca()
  {
    return this.bVW;
  }
  
  public final bb.e Cb()
  {
    AppMethodBeat.i(261496);
    bb.e locale = ae.VOb.b(aa.class, a.class);
    AppMethodBeat.o(261496);
    return locale;
  }
  
  public final ci<aa> Co()
  {
    return bRf;
  }
  
  public final void a(com.google.b.i parami)
  {
    AppMethodBeat.i(261517);
    if (this.VNp != 0L) {
      parami.n(1, this.VNp);
    }
    if (!hDp().isEmpty()) {
      bb.a(parami, 2, this.coo);
    }
    if (this.type_ != o.VMD.getNumber()) {
      parami.bJ(3, this.type_);
    }
    if (this.VNq != 0L) {
      parami.n(4, this.VNq);
    }
    if (this.VNr != 0L) {
      parami.n(5, this.VNr);
    }
    if (this.VNs != 0L) {
      parami.n(6, this.VNs);
    }
    if (this.VNt != 0L) {
      parami.n(7, this.VNt);
    }
    if (this.VNu != 0L) {
      parami.n(8, this.VNu);
    }
    if (this.VNv != 0) {
      parami.bJ(9, this.VNv);
    }
    if (this.VNw != 0) {
      parami.bJ(10, this.VNw);
    }
    if (this.VNx != 0.0F) {
      parami.i(11, this.VNx);
    }
    if (this.VNy != 0.0F) {
      parami.i(12, this.VNy);
    }
    if (this.VNz != 0) {
      parami.bJ(13, this.VNz);
    }
    if (this.VNA != 0.0F) {
      parami.i(14, this.VNA);
    }
    if (this.VNB != null) {
      parami.a(15, hEp());
    }
    if (this.VNC != null) {
      parami.a(16, hEr());
    }
    if (this.VND != p.VMK.getNumber()) {
      parami.bJ(17, this.VND);
    }
    if (this.VNE != null) {
      parami.a(18, hEu());
    }
    this.bVW.a(parami);
    AppMethodBeat.o(261517);
  }
  
  public final int aVr()
  {
    return this.VNz;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(261525);
    if (paramObject == this)
    {
      AppMethodBeat.o(261525);
      return true;
    }
    if (!(paramObject instanceof aa))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(261525);
      return bool;
    }
    paramObject = (aa)paramObject;
    if (this.VNp != paramObject.VNp)
    {
      AppMethodBeat.o(261525);
      return false;
    }
    if (!getPath().equals(paramObject.getPath()))
    {
      AppMethodBeat.o(261525);
      return false;
    }
    if (this.type_ != paramObject.type_)
    {
      AppMethodBeat.o(261525);
      return false;
    }
    if (this.VNq != paramObject.VNq)
    {
      AppMethodBeat.o(261525);
      return false;
    }
    if (this.VNr != paramObject.VNr)
    {
      AppMethodBeat.o(261525);
      return false;
    }
    if (this.VNs != paramObject.VNs)
    {
      AppMethodBeat.o(261525);
      return false;
    }
    if (this.VNt != paramObject.VNt)
    {
      AppMethodBeat.o(261525);
      return false;
    }
    if (this.VNu != paramObject.VNu)
    {
      AppMethodBeat.o(261525);
      return false;
    }
    if (this.VNv != paramObject.VNv)
    {
      AppMethodBeat.o(261525);
      return false;
    }
    if (this.VNw != paramObject.VNw)
    {
      AppMethodBeat.o(261525);
      return false;
    }
    if (Float.floatToIntBits(this.VNx) != Float.floatToIntBits(paramObject.VNx))
    {
      AppMethodBeat.o(261525);
      return false;
    }
    if (Float.floatToIntBits(this.VNy) != Float.floatToIntBits(paramObject.VNy))
    {
      AppMethodBeat.o(261525);
      return false;
    }
    if (this.VNz != paramObject.VNz)
    {
      AppMethodBeat.o(261525);
      return false;
    }
    if (Float.floatToIntBits(this.VNA) != Float.floatToIntBits(paramObject.VNA))
    {
      AppMethodBeat.o(261525);
      return false;
    }
    if (hEo() != paramObject.hEo())
    {
      AppMethodBeat.o(261525);
      return false;
    }
    if ((hEo()) && (!hEp().equals(paramObject.hEp())))
    {
      AppMethodBeat.o(261525);
      return false;
    }
    if (hEq() != paramObject.hEq())
    {
      AppMethodBeat.o(261525);
      return false;
    }
    if ((hEq()) && (!hEr().equals(paramObject.hEr())))
    {
      AppMethodBeat.o(261525);
      return false;
    }
    if (this.VND != paramObject.VND)
    {
      AppMethodBeat.o(261525);
      return false;
    }
    if (hEt() != paramObject.hEt())
    {
      AppMethodBeat.o(261525);
      return false;
    }
    if ((hEt()) && (!hEu().equals(paramObject.hEu())))
    {
      AppMethodBeat.o(261525);
      return false;
    }
    if (!this.bVW.equals(paramObject.bVW))
    {
      AppMethodBeat.o(261525);
      return false;
    }
    AppMethodBeat.o(261525);
    return true;
  }
  
  public final long getEndTimeMs()
  {
    return this.VNr;
  }
  
  public final long getId()
  {
    return this.VNp;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(261499);
    Object localObject = this.coo;
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(261499);
      return localObject;
    }
    localObject = ((g)localObject).Ap();
    this.coo = localObject;
    AppMethodBeat.o(261499);
    return localObject;
  }
  
  public final float getPlayRate()
  {
    return this.VNA;
  }
  
  public final long getStartTimeMs()
  {
    return this.VNq;
  }
  
  public final float getVolume()
  {
    return this.VNy;
  }
  
  public final o hEl()
  {
    AppMethodBeat.i(261502);
    o localo = o.atj(this.type_);
    if (localo == null)
    {
      localo = o.VMH;
      AppMethodBeat.o(261502);
      return localo;
    }
    AppMethodBeat.o(261502);
    return localo;
  }
  
  public final long hEm()
  {
    return this.VNs;
  }
  
  public final long hEn()
  {
    return this.VNt;
  }
  
  public final boolean hEo()
  {
    return this.VNB != null;
  }
  
  public final i hEp()
  {
    AppMethodBeat.i(261505);
    if (this.VNB == null)
    {
      locali = i.hDB();
      AppMethodBeat.o(261505);
      return locali;
    }
    i locali = this.VNB;
    AppMethodBeat.o(261505);
    return locali;
  }
  
  public final boolean hEq()
  {
    return this.VNC != null;
  }
  
  public final ac hEr()
  {
    AppMethodBeat.i(261507);
    if (this.VNC == null)
    {
      localac = ac.hEE();
      AppMethodBeat.o(261507);
      return localac;
    }
    ac localac = this.VNC;
    AppMethodBeat.o(261507);
    return localac;
  }
  
  public final p hEs()
  {
    AppMethodBeat.i(261508);
    p localp = p.atk(this.VND);
    if (localp == null)
    {
      localp = p.VMN;
      AppMethodBeat.o(261508);
      return localp;
    }
    AppMethodBeat.o(261508);
    return localp;
  }
  
  public final boolean hEt()
  {
    return this.VNE != null;
  }
  
  public final y hEu()
  {
    AppMethodBeat.i(261511);
    if (this.VNE == null)
    {
      localy = y.hEi();
      AppMethodBeat.o(261511);
      return localy;
    }
    y localy = this.VNE;
    AppMethodBeat.o(261511);
    return localy;
  }
  
  public final a hEw()
  {
    AppMethodBeat.i(261535);
    if (this == VNF)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(261535);
      return locala;
    }
    a locala = new a((byte)0).g(this);
    AppMethodBeat.o(261535);
    return locala;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(261528);
    if (this.bPa != 0)
    {
      i = this.bPa;
      AppMethodBeat.o(261528);
      return i;
    }
    int j = ((((((((((((((((((((((((((((ae.VOa.hashCode() + 779) * 37 + 1) * 53 + be.aJ(this.VNp)) * 37 + 2) * 53 + getPath().hashCode()) * 37 + 3) * 53 + this.type_) * 37 + 4) * 53 + be.aJ(this.VNq)) * 37 + 5) * 53 + be.aJ(this.VNr)) * 37 + 6) * 53 + be.aJ(this.VNs)) * 37 + 7) * 53 + be.aJ(this.VNt)) * 37 + 8) * 53 + be.aJ(this.VNu)) * 37 + 9) * 53 + this.VNv) * 37 + 10) * 53 + this.VNw) * 37 + 11) * 53 + Float.floatToIntBits(this.VNx)) * 37 + 12) * 53 + Float.floatToIntBits(this.VNy)) * 37 + 13) * 53 + this.VNz) * 37 + 14) * 53 + Float.floatToIntBits(this.VNA);
    int i = j;
    if (hEo()) {
      i = (j * 37 + 15) * 53 + hEp().hashCode();
    }
    j = i;
    if (hEq()) {
      j = (i * 37 + 16) * 53 + hEr().hashCode();
    }
    j = (j * 37 + 17) * 53 + this.VND;
    i = j;
    if (hEt()) {
      i = (j * 37 + 18) * 53 + hEu().hashCode();
    }
    i = i * 29 + this.bVW.hashCode();
    this.bPa = i;
    AppMethodBeat.o(261528);
    return i;
  }
  
  public final boolean isInitialized()
  {
    int i = this.bRd;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    this.bRd = 1;
    return true;
  }
  
  public static final class a
    extends bb.a<a>
    implements ab
  {
    private float VNA;
    private i VNB;
    private ac VNC;
    private int VND;
    private y VNE;
    private cs<i, i.a, j> VNG;
    private cs<ac, ac.a, ad> VNH;
    private cs<y, y.a, z> VNI;
    private long VNp;
    private long VNq;
    private long VNr;
    private long VNs;
    private long VNt;
    private long VNu;
    private int VNv;
    private int VNw;
    private float VNx;
    private float VNy;
    private int VNz;
    private Object coo;
    private int type_;
    
    private a()
    {
      AppMethodBeat.i(261402);
      this.coo = "";
      this.type_ = 0;
      this.VND = 0;
      AppMethodBeat.o(261402);
    }
    
    private a(bb.b paramb)
    {
      super();
      AppMethodBeat.i(261404);
      this.coo = "";
      this.type_ = 0;
      this.VND = 0;
      AppMethodBeat.o(261404);
    }
    
    private a X(bt parambt)
    {
      AppMethodBeat.i(261413);
      if ((parambt instanceof aa))
      {
        parambt = g((aa)parambt);
        AppMethodBeat.o(261413);
        return parambt;
      }
      super.a(parambt);
      AppMethodBeat.o(261413);
      return this;
    }
    
    /* Error */
    private a Y(com.google.b.h paramh, com.google.b.ap paramap)
    {
      // Byte code:
      //   0: ldc 92
      //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 96	com/tencent/mm/timelineedit/a/a/aa:hEy	()Lcom/google/b/ci;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 102 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/aa
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 84	com/tencent/mm/timelineedit/a/a/aa$a:g	(Lcom/tencent/mm/timelineedit/a/a/aa;)Lcom/tencent/mm/timelineedit/a/a/aa$a;
      //   30: pop
      //   31: ldc 92
      //   33: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 106	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/aa
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 110	com/google/b/bf:Im	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 92
      //   54: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 84	com/tencent/mm/timelineedit/a/a/aa$a:g	(Lcom/tencent/mm/timelineedit/a/a/aa;)Lcom/tencent/mm/timelineedit/a/a/aa$a;
      //   69: pop
      //   70: ldc 92
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
      //   0	83	1	paramh	com.google.b.h
      //   0	83	2	paramap	com.google.b.ap
      //   6	73	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	21	38	com/google/b/bf
      //   47	59	59	finally
      //   7	21	77	finally
      //   39	47	77	finally
    }
    
    private a a(ac paramac)
    {
      AppMethodBeat.i(261443);
      if (this.VNH == null) {
        if (this.VNC != null)
        {
          this.VNC = ac.b(this.VNC).e(paramac).hEG();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(261443);
        return this;
        this.VNC = paramac;
        break;
        this.VNH.c(paramac);
      }
    }
    
    private a aU(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(261409);
      paramf = (a)super.d(paramf, paramObject);
      AppMethodBeat.o(261409);
      return paramf;
    }
    
    private a aV(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(261411);
      paramf = (a)super.c(paramf, paramObject);
      AppMethodBeat.o(261411);
      return paramf;
    }
    
    private a aW(da paramda)
    {
      AppMethodBeat.i(261453);
      paramda = (a)super.e(paramda);
      AppMethodBeat.o(261453);
      return paramda;
    }
    
    private a aX(da paramda)
    {
      AppMethodBeat.i(261454);
      paramda = (a)super.d(paramda);
      AppMethodBeat.o(261454);
      return paramda;
    }
    
    private a atv(int paramInt)
    {
      AppMethodBeat.i(261422);
      this.type_ = paramInt;
      onChanged();
      AppMethodBeat.o(261422);
      return this;
    }
    
    private a atz(int paramInt)
    {
      AppMethodBeat.i(261446);
      this.VND = paramInt;
      onChanged();
      AppMethodBeat.o(261446);
      return this;
    }
    
    private a cB(float paramFloat)
    {
      AppMethodBeat.i(261435);
      this.VNx = paramFloat;
      onChanged();
      AppMethodBeat.o(261435);
      return this;
    }
    
    private a e(i parami)
    {
      AppMethodBeat.i(261442);
      if (this.VNG == null) {
        if (this.VNB != null)
        {
          this.VNB = i.a(this.VNB).c(parami).hDD();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(261442);
        return this;
        this.VNB = parami;
        break;
        this.VNG.c(parami);
      }
    }
    
    private a e(y paramy)
    {
      AppMethodBeat.i(261452);
      if (this.VNI == null) {
        if (this.VNE != null)
        {
          this.VNE = y.a(this.VNE).d(paramy).hEk();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(261452);
        return this;
        this.VNE = paramy;
        break;
        this.VNI.c(paramy);
      }
    }
    
    private aa hEz()
    {
      AppMethodBeat.i(261406);
      Object localObject = hEA();
      if (!((aa)localObject).isInitialized())
      {
        localObject = b((bt)localObject);
        AppMethodBeat.o(261406);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(261406);
      return localObject;
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(261400);
      bb.e locale = ae.VOb.b(aa.class, a.class);
      AppMethodBeat.o(261400);
      return locale;
    }
    
    public final aj.a Cv()
    {
      return ae.VOa;
    }
    
    public final a Vm(long paramLong)
    {
      AppMethodBeat.i(261418);
      this.VNp = paramLong;
      onChanged();
      AppMethodBeat.o(261418);
      return this;
    }
    
    public final a Vn(long paramLong)
    {
      AppMethodBeat.i(261427);
      this.VNq = paramLong;
      onChanged();
      AppMethodBeat.o(261427);
      return this;
    }
    
    public final a Vo(long paramLong)
    {
      AppMethodBeat.i(261428);
      this.VNr = paramLong;
      onChanged();
      AppMethodBeat.o(261428);
      return this;
    }
    
    public final a Vp(long paramLong)
    {
      AppMethodBeat.i(261429);
      this.VNs = paramLong;
      onChanged();
      AppMethodBeat.o(261429);
      return this;
    }
    
    public final a Vq(long paramLong)
    {
      AppMethodBeat.i(261430);
      this.VNt = paramLong;
      onChanged();
      AppMethodBeat.o(261430);
      return this;
    }
    
    public final a Vr(long paramLong)
    {
      AppMethodBeat.i(261432);
      this.VNu = paramLong;
      onChanged();
      AppMethodBeat.o(261432);
      return this;
    }
    
    public final int aVr()
    {
      return this.VNz;
    }
    
    public final a atw(int paramInt)
    {
      AppMethodBeat.i(261433);
      this.VNv = paramInt;
      onChanged();
      AppMethodBeat.o(261433);
      return this;
    }
    
    public final a atx(int paramInt)
    {
      AppMethodBeat.i(261434);
      this.VNw = paramInt;
      onChanged();
      AppMethodBeat.o(261434);
      return this;
    }
    
    public final a aty(int paramInt)
    {
      AppMethodBeat.i(261437);
      this.VNz = paramInt;
      onChanged();
      AppMethodBeat.o(261437);
      return this;
    }
    
    public final a b(o paramo)
    {
      AppMethodBeat.i(261425);
      if (paramo == null)
      {
        paramo = new NullPointerException();
        AppMethodBeat.o(261425);
        throw paramo;
      }
      this.type_ = paramo.getNumber();
      onChanged();
      AppMethodBeat.o(261425);
      return this;
    }
    
    public final a b(p paramp)
    {
      AppMethodBeat.i(261451);
      if (paramp == null)
      {
        paramp = new NullPointerException();
        AppMethodBeat.o(261451);
        throw paramp;
      }
      this.VND = paramp.getNumber();
      onChanged();
      AppMethodBeat.o(261451);
      return this;
    }
    
    public final a byd(String paramString)
    {
      AppMethodBeat.i(261420);
      if (paramString == null)
      {
        paramString = new NullPointerException();
        AppMethodBeat.o(261420);
        throw paramString;
      }
      this.coo = paramString;
      onChanged();
      AppMethodBeat.o(261420);
      return this;
    }
    
    public final a cC(float paramFloat)
    {
      AppMethodBeat.i(261436);
      this.VNy = paramFloat;
      onChanged();
      AppMethodBeat.o(261436);
      return this;
    }
    
    public final a cD(float paramFloat)
    {
      AppMethodBeat.i(261439);
      this.VNA = paramFloat;
      onChanged();
      AppMethodBeat.o(261439);
      return this;
    }
    
    public final a d(i parami)
    {
      AppMethodBeat.i(261441);
      if (this.VNG == null)
      {
        if (parami == null)
        {
          parami = new NullPointerException();
          AppMethodBeat.o(261441);
          throw parami;
        }
        this.VNB = parami;
        onChanged();
      }
      for (;;)
      {
        AppMethodBeat.o(261441);
        return this;
        this.VNG.b(parami);
      }
    }
    
    public final a g(aa paramaa)
    {
      AppMethodBeat.i(261416);
      if (paramaa == aa.hEx())
      {
        AppMethodBeat.o(261416);
        return this;
      }
      if (paramaa.VNp != 0L) {
        Vm(paramaa.VNp);
      }
      if (!paramaa.getPath().isEmpty())
      {
        this.coo = aa.c(paramaa);
        onChanged();
      }
      if (aa.d(paramaa) != 0) {
        atv(paramaa.type_);
      }
      if (paramaa.VNq != 0L) {
        Vn(paramaa.VNq);
      }
      if (paramaa.VNr != 0L) {
        Vo(paramaa.VNr);
      }
      if (paramaa.VNs != 0L) {
        Vp(paramaa.VNs);
      }
      if (paramaa.VNt != 0L) {
        Vq(paramaa.VNt);
      }
      if (paramaa.VNu != 0L) {
        Vr(paramaa.VNu);
      }
      if (paramaa.VNv != 0) {
        atw(paramaa.VNv);
      }
      if (paramaa.VNw != 0) {
        atx(paramaa.VNw);
      }
      if (paramaa.VNx != 0.0F) {
        cB(paramaa.VNx);
      }
      if (paramaa.VNy != 0.0F) {
        cC(paramaa.VNy);
      }
      if (paramaa.VNz != 0) {
        aty(paramaa.VNz);
      }
      if (paramaa.VNA != 0.0F) {
        cD(paramaa.VNA);
      }
      if (paramaa.hEo()) {
        e(paramaa.hEp());
      }
      if (paramaa.hEq()) {
        a(paramaa.hEr());
      }
      if (aa.e(paramaa) != 0) {
        atz(paramaa.VND);
      }
      if (paramaa.hEt()) {
        e(paramaa.hEu());
      }
      aX(aa.f(paramaa));
      onChanged();
      AppMethodBeat.o(261416);
      return this;
    }
    
    public final long getEndTimeMs()
    {
      return this.VNr;
    }
    
    public final long getId()
    {
      return this.VNp;
    }
    
    public final String getPath()
    {
      AppMethodBeat.i(261419);
      Object localObject = this.coo;
      if (!(localObject instanceof String))
      {
        localObject = ((g)localObject).Ap();
        this.coo = localObject;
        AppMethodBeat.o(261419);
        return localObject;
      }
      localObject = (String)localObject;
      AppMethodBeat.o(261419);
      return localObject;
    }
    
    public final float getPlayRate()
    {
      return this.VNA;
    }
    
    public final long getSourceDuration()
    {
      return this.VNu;
    }
    
    public final long getStartTimeMs()
    {
      return this.VNq;
    }
    
    public final float getVolume()
    {
      return this.VNy;
    }
    
    public final aa hEA()
    {
      AppMethodBeat.i(261407);
      aa localaa = new aa(this, (byte)0);
      aa.a(localaa, this.VNp);
      aa.a(localaa, this.coo);
      aa.a(localaa, this.type_);
      aa.b(localaa, this.VNq);
      aa.c(localaa, this.VNr);
      aa.d(localaa, this.VNs);
      aa.e(localaa, this.VNt);
      aa.f(localaa, this.VNu);
      aa.b(localaa, this.VNv);
      aa.c(localaa, this.VNw);
      aa.a(localaa, this.VNx);
      aa.b(localaa, this.VNy);
      aa.d(localaa, this.VNz);
      aa.c(localaa, this.VNA);
      if (this.VNG == null)
      {
        aa.a(localaa, this.VNB);
        if (this.VNH != null) {
          break label229;
        }
        aa.a(localaa, this.VNC);
        label174:
        aa.e(localaa, this.VND);
        if (this.VNI != null) {
          break label247;
        }
        aa.a(localaa, this.VNE);
      }
      for (;;)
      {
        Ib();
        AppMethodBeat.o(261407);
        return localaa;
        aa.a(localaa, (i)this.VNG.IV());
        break;
        label229:
        aa.a(localaa, (ac)this.VNH.IV());
        break label174;
        label247:
        aa.a(localaa, (y)this.VNI.IV());
      }
    }
    
    public final int hEB()
    {
      return this.VNv;
    }
    
    public final int hEC()
    {
      return this.VNw;
    }
    
    public final o hEl()
    {
      AppMethodBeat.i(261424);
      o localo = o.atj(this.type_);
      if (localo == null)
      {
        localo = o.VMH;
        AppMethodBeat.o(261424);
        return localo;
      }
      AppMethodBeat.o(261424);
      return localo;
    }
    
    public final long hEm()
    {
      return this.VNs;
    }
    
    public final long hEn()
    {
      return this.VNt;
    }
    
    public final i hEp()
    {
      AppMethodBeat.i(261440);
      if (this.VNG == null)
      {
        if (this.VNB == null)
        {
          locali = i.hDB();
          AppMethodBeat.o(261440);
          return locali;
        }
        locali = this.VNB;
        AppMethodBeat.o(261440);
        return locali;
      }
      i locali = (i)this.VNG.IU();
      AppMethodBeat.o(261440);
      return locali;
    }
    
    public final p hEs()
    {
      AppMethodBeat.i(261449);
      p localp = p.atk(this.VND);
      if (localp == null)
      {
        localp = p.VMN;
        AppMethodBeat.o(261449);
        return localp;
      }
      AppMethodBeat.o(261449);
      return localp;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.aa
 * JD-Core Version:    0.7.0.1
 */