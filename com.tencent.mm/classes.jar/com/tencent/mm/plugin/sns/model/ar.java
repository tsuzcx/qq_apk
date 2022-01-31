package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.h.a.at;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bfg;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import java.util.LinkedList;
import java.util.Map;

public final class ar
  implements f.a
{
  boolean eGA = false;
  boolean eGB = false;
  f eGE = null;
  c otA = new c() {};
  ay otJ = null;
  LinkedList<ay> otK = null;
  Map<String, ay> otL = null;
  LinkedList<com.tencent.mm.plugin.sns.storage.n> otM = null;
  c otN = new ar.9(this);
  c otz = new ar.10(this);
  
  public ar()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.otN);
    com.tencent.mm.sdk.b.a.udP.c(this.otz);
    com.tencent.mm.sdk.b.a.udP.c(this.otA);
  }
  
  public final void a(f paramf, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramf == null)
    {
      y.e("MicroMsg.SnsVideoService", "%d on preload finish but scene is null?", new Object[] { Integer.valueOf(hashCode()) });
      return;
    }
    if (this.eGE != paramf) {
      y.w("MicroMsg.SnsVideoService", "%d on preload finish, but scene callback not same object.", new Object[] { Integer.valueOf(hashCode()) });
    }
    y.i("MicroMsg.SnsVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", new Object[] { Integer.valueOf(hashCode()), paramf.getTips(), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.kernel.g.DS().O(new ar.4(this, paramf));
  }
  
  final boolean a(ay paramay, boolean paramBoolean)
  {
    Object localObject1 = aq.a(paramay.bJQ, paramay.bZK);
    if (!bk.bl((String)localObject1))
    {
      y.i("MicroMsg.SnsVideoService", "this video[%s] already download finish, do nothing. [%s, %s]", new Object[] { paramay.eFo, paramay.bJQ, localObject1 });
      return false;
    }
    boolean bool = com.tencent.mm.vfs.e.nb(aq.NL(paramay.bZK.lsK));
    localObject1 = aq.D(paramay.bZK);
    Object localObject2 = aq.NM(paramay.bJQ);
    if (localObject2 == null) {
      aq.ct(paramay.bJQ, paramay.dmi);
    }
    for (;;)
    {
      y.i("MicroMsg.SnsVideoService", "prepare stream download sns video %s mkDir %b", new Object[] { localObject1, Boolean.valueOf(bool) });
      localObject2 = new com.tencent.mm.plugin.sns.model.a.a(paramay.bZK.lsK);
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).oqa = paramay.bZK;
      az localaz = az.cvd();
      localaz.time = paramay.enw;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).ouK = localaz;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).ouI = true;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).url = paramay.bZK.kSC;
      int i = paramay.bZK.hQR;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).ouH = false;
      com.tencent.mm.modelvideo.n.Sp();
      com.tencent.mm.modelvideo.o.Ss();
      localObject1 = com.tencent.mm.ak.e.a(((com.tencent.mm.plugin.sns.model.a.a)localObject2).ouK, ((com.tencent.mm.plugin.sns.model.a.a)localObject2).url, (String)localObject1, aq.nR(paramay.bJQ), paramay.dmg);
      if (localObject1 == null) {
        break;
      }
      localObject2 = paramay.ouG;
      ((com.tencent.mm.j.g)localObject1).dmh = ((String)localObject2);
      ((com.tencent.mm.j.g)localObject1).bRO = ((String)localObject2);
      try
      {
        localObject2 = aj.p(af.bDF().OB(paramay.bJQ));
        if (localObject2 != null)
        {
          ((com.tencent.mm.j.g)localObject1).bRV = ((bto)localObject2).sGd;
          ((com.tencent.mm.j.g)localObject1).dml = ((bto)localObject2).tKn.tzV;
        }
      }
      catch (Exception localException)
      {
        label322:
        break label322;
      }
      this.otJ = paramay;
      this.otJ.eFo = ((com.tencent.mm.j.g)localObject1).field_mediaId;
      y.i("MicroMsg.SnsVideoService", "start stream download sns video cdnMediaId %s delay %b", new Object[] { this.otJ.eFo, Boolean.valueOf(paramBoolean) });
      com.tencent.mm.modelvideo.o.Ss().a((com.tencent.mm.j.g)localObject1, paramBoolean);
      return true;
      aq.c((s)localObject2, paramay.dmi);
    }
  }
  
  public final boolean a(awd paramawd, int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    int i = 0;
    if (paramawd.trO == 2)
    {
      y.w("MicroMsg.SnsVideoService", "add video task, but url is weixin, do nothing");
      return false;
    }
    ay localay = new ay();
    localay.eFo = aq.aI(paramInt1, paramawd.kSC);
    localay.bZK = paramawd;
    localay.enw = paramInt1;
    localay.bJQ = paramString;
    paramInt1 = i;
    if (paramBoolean1) {
      paramInt1 = 1;
    }
    localay.dmg = paramInt1;
    localay.dmi = paramInt2;
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DS().O(new ar.6(this, localay, paramBoolean2));
    if (paramBoolean2) {
      bEm();
    }
    return true;
  }
  
  public final void bEj()
  {
    com.tencent.mm.kernel.g.DS().O(new ar.3(this));
  }
  
  public final void bEk()
  {
    y.d("MicroMsg.SnsVideoService", "%d stop preload %s", new Object[] { Integer.valueOf(hashCode()), bk.csb() });
    com.tencent.mm.kernel.g.DS().O(new ar.1(this));
  }
  
  /* Error */
  final boolean bEl()
  {
    // Byte code:
    //   0: invokestatic 383	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   3: lstore_2
    //   4: ldc_w 385
    //   7: invokestatic 389	com/tencent/mm/kernel/g:r	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   10: checkcast 385	com/tencent/mm/plugin/zero/b/a
    //   13: invokeinterface 393 1 0
    //   18: ldc_w 395
    //   21: iconst_1
    //   22: invokevirtual 401	com/tencent/mm/m/e:getInt	(Ljava/lang/String;I)I
    //   25: istore_1
    //   26: invokestatic 404	com/tencent/mm/sdk/platformtools/bk:UX	()J
    //   29: iload_1
    //   30: i2l
    //   31: ldc2_w 405
    //   34: lmul
    //   35: lsub
    //   36: lstore 4
    //   38: ldc 100
    //   40: ldc_w 408
    //   43: iconst_4
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aload_0
    //   50: invokevirtual 106	java/lang/Object:hashCode	()I
    //   53: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: iconst_1
    //   60: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   63: aastore
    //   64: dup
    //   65: iconst_2
    //   66: sipush 130
    //   69: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   72: aastore
    //   73: dup
    //   74: iconst_3
    //   75: lload 4
    //   77: invokestatic 413	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   80: aastore
    //   81: invokestatic 139	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: invokestatic 417	com/tencent/mm/modelvideo/o:Sr	()Lcom/tencent/mm/modelvideo/t;
    //   87: sipush 130
    //   90: lload 4
    //   92: invokevirtual 423	com/tencent/mm/modelvideo/t:m	(IJ)Ljava/util/List;
    //   95: astore 6
    //   97: aload 6
    //   99: ifnull +13 -> 112
    //   102: aload 6
    //   104: invokeinterface 428 1 0
    //   109: ifeq +5 -> 114
    //   112: iconst_0
    //   113: ireturn
    //   114: aload 6
    //   116: invokeinterface 432 1 0
    //   121: astore 7
    //   123: iconst_0
    //   124: istore_1
    //   125: aload 7
    //   127: invokeinterface 437 1 0
    //   132: ifeq +203 -> 335
    //   135: aload 7
    //   137: invokeinterface 441 1 0
    //   142: checkcast 443	com/tencent/mm/modelvideo/s
    //   145: astore 8
    //   147: aload 8
    //   149: ifnull -24 -> 125
    //   152: aload 8
    //   154: invokevirtual 446	com/tencent/mm/modelvideo/s:getFileName	()Ljava/lang/String;
    //   157: invokestatic 449	com/tencent/mm/plugin/sns/model/aq:NK	(Ljava/lang/String;)Ljava/lang/String;
    //   160: astore 9
    //   162: invokestatic 284	com/tencent/mm/plugin/sns/model/af:bDF	()Lcom/tencent/mm/plugin/sns/storage/o;
    //   165: aload 9
    //   167: invokevirtual 290	com/tencent/mm/plugin/sns/storage/o:OB	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/storage/n;
    //   170: invokevirtual 455	com/tencent/mm/plugin/sns/storage/n:bGe	()Lcom/tencent/mm/protocal/c/bxk;
    //   173: getfield 461	com/tencent/mm/protocal/c/bxk:tNr	Lcom/tencent/mm/protocal/c/rp;
    //   176: getfield 466	com/tencent/mm/protocal/c/rp:sPJ	Ljava/util/LinkedList;
    //   179: iconst_0
    //   180: invokevirtual 470	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   183: checkcast 175	com/tencent/mm/protocal/c/awd
    //   186: invokestatic 191	com/tencent/mm/plugin/sns/model/aq:D	(Lcom/tencent/mm/protocal/c/awd;)Ljava/lang/String;
    //   189: astore 9
    //   191: aload 9
    //   193: invokestatic 168	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   196: ifne +213 -> 409
    //   199: new 472	com/tencent/mm/vfs/b
    //   202: dup
    //   203: aload 9
    //   205: invokespecial 473	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   208: astore 10
    //   210: aload 10
    //   212: invokevirtual 476	com/tencent/mm/vfs/b:exists	()Z
    //   215: ifeq +194 -> 409
    //   218: aload 10
    //   220: invokevirtual 479	com/tencent/mm/vfs/b:length	()J
    //   223: lstore 4
    //   225: ldc 100
    //   227: ldc_w 481
    //   230: iconst_5
    //   231: anewarray 4	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: aload 8
    //   238: invokevirtual 446	com/tencent/mm/modelvideo/s:getFileName	()Ljava/lang/String;
    //   241: aastore
    //   242: dup
    //   243: iconst_1
    //   244: lload 4
    //   246: invokestatic 413	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   249: aastore
    //   250: dup
    //   251: iconst_2
    //   252: aload 8
    //   254: getfield 484	com/tencent/mm/modelvideo/s:bRT	I
    //   257: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   260: aastore
    //   261: dup
    //   262: iconst_3
    //   263: aload 8
    //   265: getfield 487	com/tencent/mm/modelvideo/s:eHF	J
    //   268: invokestatic 413	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   271: aastore
    //   272: dup
    //   273: iconst_4
    //   274: aload 9
    //   276: aastore
    //   277: invokestatic 139	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   280: lload 4
    //   282: lconst_0
    //   283: lcmp
    //   284: ifle +125 -> 409
    //   287: lload 4
    //   289: aload 8
    //   291: getfield 484	com/tencent/mm/modelvideo/s:bRT	I
    //   294: i2l
    //   295: lcmp
    //   296: ifgt +113 -> 409
    //   299: aload 10
    //   301: invokevirtual 490	com/tencent/mm/vfs/b:delete	()Z
    //   304: pop
    //   305: iload_1
    //   306: iconst_1
    //   307: iadd
    //   308: istore_1
    //   309: aload 8
    //   311: iconst_0
    //   312: putfield 484	com/tencent/mm/modelvideo/s:bRT	I
    //   315: aload 8
    //   317: iconst_1
    //   318: putfield 493	com/tencent/mm/modelvideo/s:bcw	I
    //   321: aload 8
    //   323: invokestatic 499	com/tencent/mm/modelvideo/u:f	(Lcom/tencent/mm/modelvideo/s;)Z
    //   326: pop
    //   327: goto -202 -> 125
    //   330: astore 8
    //   332: goto -207 -> 125
    //   335: getstatic 505	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   338: ldc2_w 506
    //   341: ldc2_w 508
    //   344: iload_1
    //   345: i2l
    //   346: iconst_0
    //   347: invokevirtual 512	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   350: ldc 100
    //   352: ldc_w 514
    //   355: iconst_4
    //   356: anewarray 4	java/lang/Object
    //   359: dup
    //   360: iconst_0
    //   361: aload_0
    //   362: invokevirtual 106	java/lang/Object:hashCode	()I
    //   365: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   368: aastore
    //   369: dup
    //   370: iconst_1
    //   371: aload 6
    //   373: invokeinterface 517 1 0
    //   378: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   381: aastore
    //   382: dup
    //   383: iconst_2
    //   384: iload_1
    //   385: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   388: aastore
    //   389: dup
    //   390: iconst_3
    //   391: lload_2
    //   392: invokestatic 521	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   395: invokestatic 413	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   398: aastore
    //   399: invokestatic 139	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   402: iconst_0
    //   403: ireturn
    //   404: astore 8
    //   406: goto -74 -> 332
    //   409: goto -100 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	412	0	this	ar
    //   25	360	1	i	int
    //   3	389	2	l1	long
    //   36	252	4	l2	long
    //   95	277	6	localList	java.util.List
    //   121	15	7	localIterator	java.util.Iterator
    //   145	177	8	locals	s
    //   330	1	8	localException1	Exception
    //   404	1	8	localException2	Exception
    //   160	115	9	str	String
    //   208	92	10	localb	com.tencent.mm.vfs.b
    // Exception table:
    //   from	to	target	type
    //   152	280	330	java/lang/Exception
    //   287	305	330	java/lang/Exception
    //   309	327	404	java/lang/Exception
  }
  
  final void bEm()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DS().O(new ar.7(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ar
 * JD-Core Version:    0.7.0.1
 */