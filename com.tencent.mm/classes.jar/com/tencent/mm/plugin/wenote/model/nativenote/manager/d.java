package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d
  extends Thread
{
  private static HashMap<String, b> puN;
  private static Object puO;
  private static be puP;
  private a EzY;
  private k EzZ;
  public boolean isStop;
  private List<String> puD;
  private List<Integer> puE;
  private List<String> puF;
  private List<String> puG;
  private List<Integer> puH;
  private String puK;
  private String puL;
  private boolean puM;
  
  static
  {
    AppMethodBeat.i(30458);
    puN = new HashMap();
    puO = new byte[0];
    AppMethodBeat.o(30458);
  }
  
  public d(List<String> paramList, String paramString1, String paramString2, k paramk, a parama)
  {
    AppMethodBeat.i(30451);
    this.puM = false;
    this.puD = paramList;
    this.puE = new ArrayList();
    this.puF = new ArrayList();
    this.puH = new ArrayList();
    this.puG = new ArrayList();
    this.EzY = parama;
    this.EzZ = paramk;
    this.puL = paramString2;
    this.puK = paramString1;
    AppMethodBeat.o(30451);
  }
  
  private void a(final int paramInt1, String paramString1, String paramString2, int paramInt2, VideoTransPara paramVideoTransPara, Context arg6, final String paramString3)
  {
    AppMethodBeat.i(30453);
    ad.i("MicroMsg.NoteVideoCompress", "finish to import %s to %s | ret %d | duration %d", new Object[] { paramString2, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    d(paramInt1, paramString1, paramString2, paramInt2);
    if (paramInt1 == -50002) {
      al(???, ???.getString(2131764675));
    }
    for (;;)
    {
      if ((this.EzY != null) && (!this.isStop)) {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30447);
            d.b(d.this).a(paramString3, d.a(d.this));
            if ((d.c(d.this)) || (paramInt1 != -50006)) {
              ba.ajF().n(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(30446);
                  d.b(d.this).b(d.d(d.this), d.a(d.this));
                  AppMethodBeat.o(30446);
                }
              }, 80L);
            }
            AppMethodBeat.o(30447);
          }
        });
      }
      AppMethodBeat.o(30453);
      return;
      if (paramInt1 == -50008)
      {
        al(???, ???.getString(2131764673));
      }
      else
      {
        if (paramInt1 == -50006)
        {
          fq(paramString1, paramString2);
          if (puP == null) {
            puP = new be(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
          }
          b localb = new b((byte)0);
          synchronized (puO)
          {
            puN.put(paramString1, localb);
            localb.fileName = paramString1;
            localb.irI = paramString2;
            localb.jNP = this.puL;
            localb.itU = paramVideoTransPara;
            localb.EzY = this.EzY;
            localb.EzZ = this.EzZ;
            puP.c(localb);
          }
        }
        if (paramInt1 < 0) {
          al(???, ???.getString(2131764674));
        } else {
          this.puM = true;
        }
      }
    }
  }
  
  private void al(final Context paramContext, final String paramString)
  {
    AppMethodBeat.i(30454);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30448);
        Toast.makeText(paramContext, paramString, 0).show();
        AppMethodBeat.o(30448);
      }
    });
    AppMethodBeat.o(30454);
  }
  
  private void d(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(30457);
      this.puE.add(Integer.valueOf(paramInt1));
      this.puF.add(paramString1);
      this.puG.add(paramString2);
      this.puH.add(Integer.valueOf(paramInt2));
      AppMethodBeat.o(30457);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public static void d(String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: sipush 30456
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 224	com/tencent/mm/compatible/h/d
    //   9: dup
    //   10: invokespecial 225	com/tencent/mm/compatible/h/d:<init>	()V
    //   13: astore 6
    //   15: aload 6
    //   17: astore 5
    //   19: aload 6
    //   21: aload_0
    //   22: invokevirtual 230	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   25: aload 6
    //   27: astore 5
    //   29: aload 6
    //   31: bipush 18
    //   33: invokevirtual 233	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   36: iconst_0
    //   37: invokestatic 239	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   40: istore_2
    //   41: aload 6
    //   43: astore 5
    //   45: aload 6
    //   47: bipush 19
    //   49: invokevirtual 233	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   52: iconst_0
    //   53: invokestatic 239	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   56: istore_3
    //   57: aload 6
    //   59: invokevirtual 242	android/media/MediaMetadataRetriever:release	()V
    //   62: aload_1
    //   63: iconst_0
    //   64: iload_2
    //   65: iastore
    //   66: aload_1
    //   67: iconst_1
    //   68: iload_3
    //   69: iastore
    //   70: iconst_0
    //   71: istore 4
    //   73: iload 4
    //   75: iconst_3
    //   76: if_icmpge +119 -> 195
    //   79: iload_2
    //   80: iconst_2
    //   81: irem
    //   82: ifne +9 -> 91
    //   85: iload_3
    //   86: iconst_2
    //   87: irem
    //   88: ifeq +69 -> 157
    //   91: sipush 30456
    //   94: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: return
    //   98: astore_0
    //   99: iconst_0
    //   100: istore_2
    //   101: aconst_null
    //   102: astore 6
    //   104: aload 6
    //   106: astore 5
    //   108: ldc 93
    //   110: aload_0
    //   111: ldc 244
    //   113: iconst_0
    //   114: anewarray 97	java/lang/Object
    //   117: invokestatic 248	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: aload 6
    //   122: ifnull +8 -> 130
    //   125: aload 6
    //   127: invokevirtual 242	android/media/MediaMetadataRetriever:release	()V
    //   130: iconst_0
    //   131: istore_3
    //   132: goto -70 -> 62
    //   135: astore_0
    //   136: aconst_null
    //   137: astore 5
    //   139: aload 5
    //   141: ifnull +8 -> 149
    //   144: aload 5
    //   146: invokevirtual 242	android/media/MediaMetadataRetriever:release	()V
    //   149: sipush 30456
    //   152: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aload_0
    //   156: athrow
    //   157: iload_2
    //   158: iload_3
    //   159: if_icmplt +17 -> 176
    //   162: iload_2
    //   163: sipush 640
    //   166: if_icmple +29 -> 195
    //   169: iload_3
    //   170: sipush 480
    //   173: if_icmple +22 -> 195
    //   176: iload_2
    //   177: iload_3
    //   178: if_icmpgt +32 -> 210
    //   181: iload_2
    //   182: sipush 480
    //   185: if_icmple +10 -> 195
    //   188: iload_3
    //   189: sipush 640
    //   192: if_icmpgt +18 -> 210
    //   195: aload_1
    //   196: iconst_0
    //   197: iload_2
    //   198: iastore
    //   199: aload_1
    //   200: iconst_1
    //   201: iload_3
    //   202: iastore
    //   203: sipush 30456
    //   206: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: return
    //   210: iload_2
    //   211: iconst_2
    //   212: idiv
    //   213: istore_2
    //   214: iload_3
    //   215: iconst_2
    //   216: idiv
    //   217: istore_3
    //   218: iload 4
    //   220: iconst_1
    //   221: iadd
    //   222: istore 4
    //   224: goto -151 -> 73
    //   227: astore_0
    //   228: goto -89 -> 139
    //   231: astore_0
    //   232: iconst_0
    //   233: istore_2
    //   234: goto -130 -> 104
    //   237: astore_0
    //   238: goto -134 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	paramString	String
    //   0	241	1	paramArrayOfInt	int[]
    //   40	194	2	i	int
    //   56	162	3	j	int
    //   71	152	4	k	int
    //   17	128	5	locald1	com.tencent.mm.compatible.h.d
    //   13	113	6	locald2	com.tencent.mm.compatible.h.d
    // Exception table:
    //   from	to	target	type
    //   6	15	98	java/lang/Exception
    //   6	15	135	finally
    //   19	25	227	finally
    //   29	41	227	finally
    //   45	57	227	finally
    //   108	120	227	finally
    //   19	25	231	java/lang/Exception
    //   29	41	231	java/lang/Exception
    //   45	57	237	java/lang/Exception
  }
  
  private static void fq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(30455);
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.NoteVideoCompress", "do insertVideoStorage, but file name is null");
      AppMethodBeat.o(30455);
      return;
    }
    s locals = new s();
    locals.fileName = paramString1;
    locals.hHQ = 1;
    locals.dDy = null;
    ba.aBQ();
    locals.itY = ((String)com.tencent.mm.model.c.ajl().get(2, ""));
    locals.createTime = com.tencent.mm.sdk.platformtools.bt.aQJ();
    locals.iud = com.tencent.mm.sdk.platformtools.bt.aQJ();
    locals.iuk = null;
    locals.irI = paramString2;
    if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString2)) {
      locals.iui = 1;
    }
    locals.hMP = 0;
    o.aMJ().b(locals);
    AppMethodBeat.o(30455);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: sipush 30452
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 68	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:puD	Ljava/util/List;
    //   10: ifnull +1263 -> 1273
    //   13: aload_0
    //   14: getfield 68	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:puD	Ljava/util/List;
    //   17: invokeinterface 329 1 0
    //   22: ifle +1251 -> 1273
    //   25: iconst_0
    //   26: istore 6
    //   28: iload 6
    //   30: aload_0
    //   31: getfield 68	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:puD	Ljava/util/List;
    //   34: invokeinterface 329 1 0
    //   39: if_icmpge +1234 -> 1273
    //   42: aload_0
    //   43: getfield 126	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:isStop	Z
    //   46: ifne +1227 -> 1273
    //   49: ldc 93
    //   51: ldc_w 331
    //   54: iconst_1
    //   55: anewarray 97	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_0
    //   61: getfield 68	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:puD	Ljava/util/List;
    //   64: invokevirtual 332	java/lang/Object:toString	()Ljava/lang/String;
    //   67: aastore
    //   68: invokestatic 108	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: new 334	android/content/Intent
    //   74: dup
    //   75: invokespecial 335	android/content/Intent:<init>	()V
    //   78: astore 16
    //   80: aload 16
    //   82: new 148	java/lang/StringBuilder
    //   85: dup
    //   86: ldc_w 337
    //   89: invokespecial 153	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: aload_0
    //   93: getfield 68	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:puD	Ljava/util/List;
    //   96: iload 6
    //   98: invokeinterface 340 2 0
    //   103: checkcast 290	java/lang/String
    //   106: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 349	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   115: invokevirtual 353	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   118: pop
    //   119: invokestatic 359	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   122: astore 17
    //   124: new 148	java/lang/StringBuilder
    //   127: dup
    //   128: ldc_w 361
    //   131: invokespecial 153	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   134: astore 12
    //   136: invokestatic 274	com/tencent/mm/model/ba:aBQ	()Lcom/tencent/mm/model/c;
    //   139: pop
    //   140: aload 12
    //   142: invokestatic 280	com/tencent/mm/model/c:ajl	()Lcom/tencent/mm/storage/ai;
    //   145: iconst_2
    //   146: ldc_w 282
    //   149: invokevirtual 288	com/tencent/mm/storage/ai:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   152: checkcast 290	java/lang/String
    //   155: invokestatic 365	com/tencent/mm/modelvideo/t:Hf	(Ljava/lang/String;)Ljava/lang/String;
    //   158: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: astore 13
    //   166: aload_0
    //   167: getfield 87	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:puK	Ljava/lang/String;
    //   170: invokestatic 252	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   173: ifne +13 -> 186
    //   176: aload_0
    //   177: getfield 85	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:puL	Ljava/lang/String;
    //   180: invokestatic 252	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   183: ifeq +83 -> 266
    //   186: invokestatic 319	com/tencent/mm/modelvideo/o:aMJ	()Lcom/tencent/mm/modelvideo/t;
    //   189: pop
    //   190: aload 13
    //   192: invokestatic 368	com/tencent/mm/modelvideo/t:Hi	(Ljava/lang/String;)Ljava/lang/String;
    //   195: astore 15
    //   197: invokestatic 319	com/tencent/mm/modelvideo/o:aMJ	()Lcom/tencent/mm/modelvideo/t;
    //   200: pop
    //   201: aload 13
    //   203: invokestatic 371	com/tencent/mm/modelvideo/t:Hh	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore 14
    //   208: invokestatic 359	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   211: invokestatic 377	com/tencent/mm/sdk/platformtools/ay:is2G	(Landroid/content/Context;)Z
    //   214: istore 9
    //   216: aload 17
    //   218: aload 16
    //   220: invokestatic 382	com/tencent/mm/compatible/h/a:i	(Landroid/content/Context;Landroid/content/Intent;)Ljava/lang/String;
    //   223: astore 18
    //   225: aload 18
    //   227: invokestatic 252	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   230: ifeq +79 -> 309
    //   233: ldc 93
    //   235: ldc_w 384
    //   238: invokestatic 387	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_0
    //   242: ldc_w 388
    //   245: aload 13
    //   247: aload 18
    //   249: iconst_0
    //   250: aconst_null
    //   251: aload 17
    //   253: aconst_null
    //   254: invokespecial 390	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   257: iload 6
    //   259: iconst_1
    //   260: iadd
    //   261: istore 6
    //   263: goto -235 -> 28
    //   266: aload_0
    //   267: getfield 87	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:puK	Ljava/lang/String;
    //   270: astore 15
    //   272: aload_0
    //   273: getfield 85	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:puL	Ljava/lang/String;
    //   276: aload_0
    //   277: getfield 85	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:puL	Ljava/lang/String;
    //   280: ldc_w 392
    //   283: invokevirtual 396	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   286: iconst_1
    //   287: iadd
    //   288: aload_0
    //   289: getfield 85	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:puL	Ljava/lang/String;
    //   292: invokevirtual 399	java/lang/String:length	()I
    //   295: invokevirtual 403	java/lang/String:substring	(II)Ljava/lang/String;
    //   298: astore 13
    //   300: aload_0
    //   301: getfield 85	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:puL	Ljava/lang/String;
    //   304: astore 14
    //   306: goto -98 -> 208
    //   309: aload 18
    //   311: invokestatic 408	com/tencent/mm/plugin/a/c:Ja	(Ljava/lang/String;)Z
    //   314: istore 8
    //   316: aload 18
    //   318: invokestatic 414	com/tencent/mm/vfs/i:aYo	(Ljava/lang/String;)J
    //   321: lstore 10
    //   323: iload 8
    //   325: ifeq +557 -> 882
    //   328: new 416	com/tencent/mm/pointers/PInt
    //   331: dup
    //   332: invokespecial 417	com/tencent/mm/pointers/PInt:<init>	()V
    //   335: astore 19
    //   337: invokestatic 423	com/tencent/mm/modelcontrol/d:aGQ	()Lcom/tencent/mm/modelcontrol/d;
    //   340: aload 18
    //   342: invokevirtual 426	com/tencent/mm/modelcontrol/d:EV	(Ljava/lang/String;)Z
    //   345: ifeq +162 -> 507
    //   348: ldc 93
    //   350: ldc_w 428
    //   353: iconst_1
    //   354: anewarray 97	java/lang/Object
    //   357: dup
    //   358: iconst_0
    //   359: aload 18
    //   361: aastore
    //   362: invokestatic 108	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   365: aload 19
    //   367: iconst_1
    //   368: putfield 431	com/tencent/mm/pointers/PInt:value	I
    //   371: aconst_null
    //   372: astore 12
    //   374: aload 19
    //   376: getfield 431	com/tencent/mm/pointers/PInt:value	I
    //   379: istore_3
    //   380: ldc 93
    //   382: ldc_w 433
    //   385: iconst_3
    //   386: anewarray 97	java/lang/Object
    //   389: dup
    //   390: iconst_0
    //   391: iload_3
    //   392: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   395: aastore
    //   396: dup
    //   397: iconst_1
    //   398: iload 8
    //   400: invokestatic 438	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   403: aastore
    //   404: dup
    //   405: iconst_2
    //   406: lload 10
    //   408: invokestatic 443	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   411: aastore
    //   412: invokestatic 108	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   415: iload_3
    //   416: tableswitch	default:+64 -> 480, -6:+613->1029, -5:+631->1047, -4:+613->1029, -3:+613->1029, -2:+613->1029, -1:+594->1010, 0:+586->1002, 1:+507->923, 2:+507->923, 3:+507->923, 4:+507->923, 5:+507->923
    //   481: dup2_x1
    //   482: ldc_w 445
    //   485: invokestatic 387	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   488: aload_0
    //   489: ldc_w 446
    //   492: aload 13
    //   494: aload 18
    //   496: iconst_0
    //   497: aconst_null
    //   498: aload 17
    //   500: aconst_null
    //   501: invokespecial 390	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   504: goto -247 -> 257
    //   507: new 448	com/tencent/mm/modelcontrol/VideoTransPara
    //   510: dup
    //   511: invokespecial 449	com/tencent/mm/modelcontrol/VideoTransPara:<init>	()V
    //   514: astore 20
    //   516: new 416	com/tencent/mm/pointers/PInt
    //   519: dup
    //   520: invokespecial 417	com/tencent/mm/pointers/PInt:<init>	()V
    //   523: astore 12
    //   525: new 416	com/tencent/mm/pointers/PInt
    //   528: dup
    //   529: invokespecial 417	com/tencent/mm/pointers/PInt:<init>	()V
    //   532: astore 21
    //   534: new 416	com/tencent/mm/pointers/PInt
    //   537: dup
    //   538: invokespecial 417	com/tencent/mm/pointers/PInt:<init>	()V
    //   541: astore 22
    //   543: new 416	com/tencent/mm/pointers/PInt
    //   546: dup
    //   547: invokespecial 417	com/tencent/mm/pointers/PInt:<init>	()V
    //   550: astore 23
    //   552: new 416	com/tencent/mm/pointers/PInt
    //   555: dup
    //   556: invokespecial 417	com/tencent/mm/pointers/PInt:<init>	()V
    //   559: astore 24
    //   561: aload 18
    //   563: aload 12
    //   565: aload 21
    //   567: aload 22
    //   569: aload 23
    //   571: aload 24
    //   573: invokestatic 454	com/tencent/mm/plugin/sight/base/e:a	(Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Ljava/lang/String;
    //   576: pop
    //   577: aload 20
    //   579: aload 12
    //   581: getfield 431	com/tencent/mm/pointers/PInt:value	I
    //   584: sipush 1000
    //   587: idiv
    //   588: putfield 457	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   591: aload 20
    //   593: aload 21
    //   595: getfield 431	com/tencent/mm/pointers/PInt:value	I
    //   598: putfield 460	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   601: aload 20
    //   603: aload 22
    //   605: getfield 431	com/tencent/mm/pointers/PInt:value	I
    //   608: putfield 463	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   611: aload 20
    //   613: aload 23
    //   615: getfield 431	com/tencent/mm/pointers/PInt:value	I
    //   618: putfield 466	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   621: aload 20
    //   623: aload 24
    //   625: getfield 431	com/tencent/mm/pointers/PInt:value	I
    //   628: putfield 469	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   631: ldc 93
    //   633: ldc_w 471
    //   636: iconst_1
    //   637: anewarray 97	java/lang/Object
    //   640: dup
    //   641: iconst_0
    //   642: aload 20
    //   644: aastore
    //   645: invokestatic 473	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   648: invokestatic 423	com/tencent/mm/modelcontrol/d:aGQ	()Lcom/tencent/mm/modelcontrol/d;
    //   651: aload 20
    //   653: invokevirtual 476	com/tencent/mm/modelcontrol/d:c	(Lcom/tencent/mm/modelcontrol/VideoTransPara;)Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   656: astore 12
    //   658: aload 12
    //   660: ifnonnull +33 -> 693
    //   663: ldc 93
    //   665: ldc_w 478
    //   668: iconst_1
    //   669: anewarray 97	java/lang/Object
    //   672: dup
    //   673: iconst_0
    //   674: aload 20
    //   676: aastore
    //   677: invokestatic 108	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   680: aload 19
    //   682: bipush 251
    //   684: putfield 431	com/tencent/mm/pointers/PInt:value	I
    //   687: aconst_null
    //   688: astore 12
    //   690: goto -316 -> 374
    //   693: ldc 93
    //   695: ldc_w 480
    //   698: iconst_1
    //   699: anewarray 97	java/lang/Object
    //   702: dup
    //   703: iconst_0
    //   704: aload 12
    //   706: aastore
    //   707: invokestatic 473	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   710: aload 20
    //   712: getfield 469	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   715: ldc_w 481
    //   718: if_icmple +16 -> 734
    //   721: aload 12
    //   723: getfield 469	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   726: aload 20
    //   728: getfield 469	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   731: if_icmple +37 -> 768
    //   734: ldc 93
    //   736: ldc_w 483
    //   739: iconst_2
    //   740: anewarray 97	java/lang/Object
    //   743: dup
    //   744: iconst_0
    //   745: aload 12
    //   747: aastore
    //   748: dup
    //   749: iconst_1
    //   750: aload 20
    //   752: aastore
    //   753: invokestatic 108	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   756: aload 19
    //   758: iconst_1
    //   759: putfield 431	com/tencent/mm/pointers/PInt:value	I
    //   762: aconst_null
    //   763: astore 12
    //   765: goto -391 -> 374
    //   768: aload 20
    //   770: getfield 466	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   773: bipush 45
    //   775: if_icmplt +31 -> 806
    //   778: aload 20
    //   780: getfield 457	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   783: sipush 1000
    //   786: imul
    //   787: ldc_w 484
    //   790: if_icmplt +16 -> 806
    //   793: aload 19
    //   795: bipush 250
    //   797: putfield 431	com/tencent/mm/pointers/PInt:value	I
    //   800: aconst_null
    //   801: astore 12
    //   803: goto -429 -> 374
    //   806: invokestatic 359	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   809: invokestatic 377	com/tencent/mm/sdk/platformtools/ay:is2G	(Landroid/content/Context;)Z
    //   812: istore 9
    //   814: aload 12
    //   816: getfield 460	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   819: istore 4
    //   821: aload 12
    //   823: getfield 463	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   826: istore 5
    //   828: iload 9
    //   830: ifeq +38 -> 868
    //   833: ldc_w 485
    //   836: istore_3
    //   837: iload 9
    //   839: ifeq +36 -> 875
    //   842: ldc2_w 486
    //   845: dstore_1
    //   846: aload 19
    //   848: aload 18
    //   850: iload 4
    //   852: iload 5
    //   854: iload_3
    //   855: dload_1
    //   856: ldc_w 488
    //   859: invokestatic 494	com/tencent/mm/plugin/sight/base/SightVideoJNI:shouldRemuxingVFS	(Ljava/lang/String;IIIDI)I
    //   862: putfield 431	com/tencent/mm/pointers/PInt:value	I
    //   865: goto -491 -> 374
    //   868: ldc_w 495
    //   871: istore_3
    //   872: goto -35 -> 837
    //   875: ldc2_w 496
    //   878: dstore_1
    //   879: goto -33 -> 846
    //   882: iload 9
    //   884: ifeq +24 -> 908
    //   887: ldc_w 485
    //   890: istore_3
    //   891: lload 10
    //   893: iload_3
    //   894: i2l
    //   895: lcmp
    //   896: ifle +19 -> 915
    //   899: bipush 251
    //   901: istore_3
    //   902: aconst_null
    //   903: astore 12
    //   905: goto -525 -> 380
    //   908: ldc_w 495
    //   911: istore_3
    //   912: goto -21 -> 891
    //   915: iconst_1
    //   916: istore_3
    //   917: aconst_null
    //   918: astore 12
    //   920: goto -540 -> 380
    //   923: lload 10
    //   925: ldc2_w 498
    //   928: lcmp
    //   929: ifle +65 -> 994
    //   932: aload_0
    //   933: ldc 113
    //   935: aload 13
    //   937: aload 18
    //   939: iconst_0
    //   940: aconst_null
    //   941: aload 17
    //   943: aconst_null
    //   944: invokespecial 390	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   947: iconst_0
    //   948: istore 4
    //   950: ldc 113
    //   952: istore_3
    //   953: aload 17
    //   955: aload 16
    //   957: invokestatic 503	com/tencent/mm/compatible/h/a:j	(Landroid/content/Context;Landroid/content/Intent;)Lcom/tencent/mm/compatible/h/a$a;
    //   960: astore 16
    //   962: aload 16
    //   964: ifnonnull +123 -> 1087
    //   967: ldc 93
    //   969: ldc_w 384
    //   972: invokestatic 387	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   975: aload_0
    //   976: ldc_w 388
    //   979: aload 13
    //   981: aload 18
    //   983: iconst_0
    //   984: aconst_null
    //   985: aload 17
    //   987: aconst_null
    //   988: invokespecial 390	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   991: goto -734 -> 257
    //   994: iconst_0
    //   995: istore 4
    //   997: iconst_0
    //   998: istore_3
    //   999: goto -46 -> 953
    //   1002: iconst_1
    //   1003: istore 4
    //   1005: iconst_0
    //   1006: istore_3
    //   1007: goto -54 -> 953
    //   1010: aload_0
    //   1011: ldc_w 504
    //   1014: aload 13
    //   1016: aload 18
    //   1018: iconst_0
    //   1019: aconst_null
    //   1020: aload 17
    //   1022: aconst_null
    //   1023: invokespecial 390	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1026: goto -769 -> 257
    //   1029: aload_0
    //   1030: ldc 113
    //   1032: aload 13
    //   1034: aload 18
    //   1036: iconst_0
    //   1037: aconst_null
    //   1038: aload 17
    //   1040: aconst_null
    //   1041: invokespecial 390	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1044: goto -787 -> 257
    //   1047: aload_0
    //   1048: ldc 136
    //   1050: aload 13
    //   1052: aload 18
    //   1054: iconst_0
    //   1055: aconst_null
    //   1056: aload 17
    //   1058: aconst_null
    //   1059: invokespecial 390	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1062: goto -805 -> 257
    //   1065: astore 16
    //   1067: ldc 93
    //   1069: aload 16
    //   1071: ldc_w 282
    //   1074: iconst_0
    //   1075: anewarray 97	java/lang/Object
    //   1078: invokestatic 248	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1081: aconst_null
    //   1082: astore 16
    //   1084: goto -122 -> 962
    //   1087: iload 4
    //   1089: ifne +137 -> 1226
    //   1092: aload 18
    //   1094: aload 14
    //   1096: invokestatic 508	com/tencent/mm/vfs/i:mz	(Ljava/lang/String;Ljava/lang/String;)J
    //   1099: pop2
    //   1100: aload 16
    //   1102: getfield 511	com/tencent/mm/compatible/h/a$a:duration	I
    //   1105: i2l
    //   1106: invokestatic 515	com/tencent/mm/sdk/platformtools/bt:Dg	(J)I
    //   1109: istore 7
    //   1111: aload 16
    //   1113: getfield 519	com/tencent/mm/compatible/h/a$a:bitmap	Landroid/graphics/Bitmap;
    //   1116: ifnull +132 -> 1248
    //   1119: aload 16
    //   1121: getfield 519	com/tencent/mm/compatible/h/a$a:bitmap	Landroid/graphics/Bitmap;
    //   1124: bipush 60
    //   1126: getstatic 525	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1129: aload 15
    //   1131: iconst_1
    //   1132: invokestatic 530	com/tencent/mm/sdk/platformtools/g:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   1135: pop
    //   1136: iconst_0
    //   1137: istore 5
    //   1139: iload 5
    //   1141: ifeq +27 -> 1168
    //   1144: ldc_w 531
    //   1147: sipush 320
    //   1150: sipush 480
    //   1153: invokestatic 535	com/tencent/mm/sdk/platformtools/g:aJ	(III)Landroid/graphics/Bitmap;
    //   1156: bipush 60
    //   1158: getstatic 525	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1161: aload 15
    //   1163: iconst_1
    //   1164: invokestatic 530	com/tencent/mm/sdk/platformtools/g:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   1167: pop
    //   1168: iload_3
    //   1169: istore 5
    //   1171: iload 4
    //   1173: ifne +19 -> 1192
    //   1176: iload_3
    //   1177: istore 5
    //   1179: aload 14
    //   1181: invokestatic 538	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   1184: ifne +8 -> 1192
    //   1187: ldc_w 539
    //   1190: istore 5
    //   1192: aload 15
    //   1194: invokestatic 538	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   1197: ifne +8 -> 1205
    //   1200: ldc_w 540
    //   1203: istore 5
    //   1205: aload_0
    //   1206: iload 5
    //   1208: aload 13
    //   1210: aload 18
    //   1212: iload 7
    //   1214: aload 12
    //   1216: aload 17
    //   1218: aload 15
    //   1220: invokespecial 390	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1223: goto -966 -> 257
    //   1226: ldc 138
    //   1228: istore_3
    //   1229: goto -129 -> 1100
    //   1232: astore 16
    //   1234: ldc 93
    //   1236: aload 16
    //   1238: ldc_w 282
    //   1241: iconst_0
    //   1242: anewarray 97	java/lang/Object
    //   1245: invokestatic 248	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1248: iconst_1
    //   1249: istore 5
    //   1251: goto -112 -> 1139
    //   1254: astore 16
    //   1256: ldc 93
    //   1258: aload 16
    //   1260: ldc_w 282
    //   1263: iconst_0
    //   1264: anewarray 97	java/lang/Object
    //   1267: invokestatic 248	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1270: goto -102 -> 1168
    //   1273: sipush 30452
    //   1276: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1279: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1280	0	this	d
    //   845	34	1	d	double
    //   379	850	3	i	int
    //   819	353	4	j	int
    //   826	424	5	k	int
    //   26	236	6	m	int
    //   1109	104	7	n	int
    //   314	85	8	bool1	boolean
    //   214	669	9	bool2	boolean
    //   321	603	10	l	long
    //   134	1081	12	localObject1	Object
    //   164	1045	13	str1	String
    //   206	974	14	str2	String
    //   195	1024	15	str3	String
    //   78	885	16	localObject2	Object
    //   1065	5	16	localException1	Exception
    //   1082	38	16	localObject3	Object
    //   1232	5	16	localException2	Exception
    //   1254	5	16	localException3	Exception
    //   122	1095	17	localContext	Context
    //   223	988	18	str4	String
    //   335	512	19	localPInt1	PInt
    //   514	265	20	localVideoTransPara	VideoTransPara
    //   532	62	21	localPInt2	PInt
    //   541	63	22	localPInt3	PInt
    //   550	64	23	localPInt4	PInt
    //   559	65	24	localPInt5	PInt
    // Exception table:
    //   from	to	target	type
    //   953	962	1065	java/lang/Exception
    //   1119	1136	1232	java/lang/Exception
    //   1144	1168	1254	java/lang/Exception
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, k paramk);
    
    public abstract void b(String paramString, k paramk);
  }
  
  static final class b
    implements be.a
  {
    d.a EzY;
    k EzZ;
    String fileName;
    String irI;
    VideoTransPara itU;
    String jNP;
    private int outputHeight;
    private int outputWidth;
    int puT;
    private boolean puU;
    private int puV = 0;
    
    public final boolean aEm()
    {
      AppMethodBeat.i(30449);
      for (;;)
      {
        synchronized (d.puO)
        {
          int i;
          if (!d.cew().containsKey(this.fileName))
          {
            i = 1;
            j = i;
            if (i == 0)
            {
              if (u.Hy(this.fileName) == null) {
                j = 1;
              }
            }
            else
            {
              if (j == 0) {
                break;
              }
              ad.w("MicroMsg.NoteVideoCompress", "remuxing job has been removed, filename %s", new Object[] { this.fileName });
              AppMethodBeat.o(30449);
              return true;
            }
          }
          else
          {
            i = 0;
          }
        }
        int j = 0;
      }
      if ((this.itU != null) && (!this.itU.isDefault)) {
        this.outputWidth = this.itU.width;
      }
      Object localObject3;
      for (this.outputHeight = this.itU.height;; this.outputHeight = ???[1])
      {
        ??? = new PString();
        localObject3 = new PInt();
        ba.aBQ();
        if ((!com.tencent.mm.model.c.azx().a(this.irI, (PString)???, (PInt)localObject3)) || (i.mz(((PString)???).value, this.jNP) < 0L)) {
          break;
        }
        ad.i("MicroMsg.NoteVideoCompress", "copy remuxing file success, do not remuxing again.");
        this.puT = ((PInt)localObject3).value;
        this.puU = true;
        AppMethodBeat.o(30449);
        return true;
        ??? = new int[2];
        d.d(this.irI, (int[])???);
        this.outputWidth = ???[0];
      }
      long l = com.tencent.mm.sdk.platformtools.bt.HI();
      if (this.itU != null)
      {
        ad.i("MicroMsg.NoteVideoCompress", "remuxing new para %s", new Object[] { this.itU });
        this.puT = SightVideoJNI.remuxingVFS(this.irI, this.jNP, this.outputWidth, this.outputHeight, this.itU.videoBitrate, this.itU.hVf, 8, this.itU.hVe, 25.0F, this.itU.fps, null, 0, false, 0, 51);
        this.puV = ((int)com.tencent.mm.sdk.platformtools.bt.aO(l));
        ad.i("MicroMsg.NoteVideoCompress", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { this.irI, this.jNP, Integer.valueOf(this.puT), Integer.valueOf(this.outputWidth), Integer.valueOf(this.outputHeight) });
        if (this.puT < 0) {
          break label579;
        }
      }
      label579:
      for (boolean bool = true;; bool = false)
      {
        this.puU = bool;
        ??? = new PInt();
        localObject3 = new PInt();
        if (u.a(this.jNP, (PInt)???, (PInt)localObject3)) {
          this.puT = ((PInt)???).value;
        }
        if (this.puU) {
          break label585;
        }
        ad.w("MicroMsg.NoteVideoCompress", "remuxing video error, copy source video to send.");
        i.deleteFile(this.jNP);
        i.mz(this.irI, this.jNP);
        AppMethodBeat.o(30449);
        return true;
        ad.w("MicroMsg.NoteVideoCompress", "remuxing but new para is null. %s", new Object[] { this.fileName });
        this.puT = SightVideoJNI.remuxingVFS(this.irI, this.jNP, this.outputWidth, this.outputHeight, com.tencent.mm.plugin.sight.base.c.yRc, com.tencent.mm.plugin.sight.base.c.yRb, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.c.yRd, null, 0, false, 0, 51);
        break;
      }
      label585:
      ad.i("MicroMsg.NoteVideoCompress", "remuxing video sucess,insert to media duplication storage");
      for (;;)
      {
        PInt localPInt;
        try
        {
          localObject3 = new com.tencent.mm.vfs.e(this.jNP);
          ??? = ((com.tencent.mm.vfs.e)localObject3).getName();
          String str = this.jNP + ".tmp";
          localPInt = new PInt(0);
          if (!com.tencent.mm.plugin.a.e.b(this.jNP, str, localPInt)) {
            break label806;
          }
          bool = ((com.tencent.mm.vfs.e)localObject3).delete();
          localObject3 = new com.tencent.mm.vfs.e(str);
          ad.i("MicroMsg.NoteVideoCompress", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(i.bb(((com.tencent.mm.vfs.e)localObject3).getParent() + "/", ((com.tencent.mm.vfs.e)localObject3).getName(), (String)???)), q.B(((com.tencent.mm.vfs.e)localObject3).fOK()), this.jNP });
          ba.aBQ();
          com.tencent.mm.model.c.azx().al(this.irI, this.jNP, this.puT);
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.NoteVideoCompress", "fast start exception e[%s]", new Object[] { localException.toString() });
        }
        break;
        label806:
        ad.i("MicroMsg.NoteVideoCompress", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", new Object[] { Integer.valueOf(localPInt.value), this.irI, this.jNP });
      }
    }
    
    public final boolean aEn()
    {
      AppMethodBeat.i(30450);
      synchronized (d.puO)
      {
        d.cew().remove(this.fileName);
        if (this.EzY != null) {
          this.EzY.b(this.jNP, this.EzZ);
        }
        AppMethodBeat.o(30450);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.d
 * JD-Core Version:    0.7.0.1
 */