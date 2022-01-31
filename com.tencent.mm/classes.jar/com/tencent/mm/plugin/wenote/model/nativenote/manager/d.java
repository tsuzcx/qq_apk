package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d
  extends Thread
{
  private static HashMap<String, d.b> vyv;
  private static Object vyw;
  private static az vyx;
  public boolean isStop;
  private List<String> vyl;
  private List<Integer> vym;
  private List<String> vyn;
  private List<String> vyo;
  private List<Integer> vyp;
  private d.a vyq;
  private k vyr;
  private String vys;
  private String vyt;
  private boolean vyu;
  
  static
  {
    AppMethodBeat.i(26765);
    vyv = new HashMap();
    vyw = new byte[0];
    AppMethodBeat.o(26765);
  }
  
  public d(List<String> paramList, String paramString1, String paramString2, k paramk, d.a parama)
  {
    AppMethodBeat.i(26758);
    this.vyu = false;
    this.vyl = paramList;
    this.vym = new ArrayList();
    this.vyn = new ArrayList();
    this.vyp = new ArrayList();
    this.vyo = new ArrayList();
    this.vyq = parama;
    this.vyr = paramk;
    this.vyt = paramString2;
    this.vys = paramString1;
    AppMethodBeat.o(26758);
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, int paramInt2, VideoTransPara paramVideoTransPara, Context arg6, String paramString3)
  {
    AppMethodBeat.i(26760);
    ab.i("MicroMsg.NoteVideoCompress", "finish to import %s to %s | ret %d | duration %d", new Object[] { paramString2, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    f(paramInt1, paramString1, paramString2, paramInt2);
    if (paramInt1 == -50002) {
      bq(???, ???.getString(2131304514));
    }
    for (;;)
    {
      if ((this.vyq != null) && (!this.isStop)) {
        al.d(new d.1(this, paramString3, paramInt1));
      }
      AppMethodBeat.o(26760);
      return;
      if (paramInt1 == -50008)
      {
        bq(???, ???.getString(2131304512));
      }
      else
      {
        if (paramInt1 == -50006)
        {
          hH(paramString1, paramString2);
          if (vyx == null) {
            vyx = new az(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
          }
          d.b localb = new d.b((byte)0);
          synchronized (vyw)
          {
            vyv.put(paramString1, localb);
            localb.fileName = paramString1;
            localb.fVa = paramString2;
            localb.hAo = this.vyt;
            localb.fXm = paramVideoTransPara;
            localb.vyq = this.vyq;
            localb.vyr = this.vyr;
            vyx.e(localb);
          }
        }
        if (paramInt1 < 0) {
          bq(???, ???.getString(2131304513));
        } else {
          this.vyu = true;
        }
      }
    }
  }
  
  private void bq(Context paramContext, String paramString)
  {
    AppMethodBeat.i(26761);
    al.d(new d.2(this, paramContext, paramString));
    AppMethodBeat.o(26761);
  }
  
  /* Error */
  public static void c(String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: sipush 26763
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 215	android/media/MediaMetadataRetriever
    //   9: dup
    //   10: invokespecial 216	android/media/MediaMetadataRetriever:<init>	()V
    //   13: astore 6
    //   15: aload 6
    //   17: astore 5
    //   19: aload 6
    //   21: aload_0
    //   22: invokevirtual 219	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   25: aload 6
    //   27: astore 5
    //   29: aload 6
    //   31: bipush 18
    //   33: invokevirtual 222	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   36: iconst_0
    //   37: invokestatic 228	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   40: istore_2
    //   41: aload 6
    //   43: astore 5
    //   45: aload 6
    //   47: bipush 19
    //   49: invokevirtual 222	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   52: iconst_0
    //   53: invokestatic 228	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   56: istore_3
    //   57: aload 6
    //   59: invokevirtual 231	android/media/MediaMetadataRetriever:release	()V
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
    //   91: sipush 26763
    //   94: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: return
    //   98: astore_0
    //   99: iconst_0
    //   100: istore_2
    //   101: aconst_null
    //   102: astore 6
    //   104: aload 6
    //   106: astore 5
    //   108: ldc 86
    //   110: aload_0
    //   111: ldc 233
    //   113: iconst_0
    //   114: anewarray 90	java/lang/Object
    //   117: invokestatic 237	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: aload 6
    //   122: ifnull +8 -> 130
    //   125: aload 6
    //   127: invokevirtual 231	android/media/MediaMetadataRetriever:release	()V
    //   130: iconst_0
    //   131: istore_3
    //   132: goto -70 -> 62
    //   135: astore_0
    //   136: aconst_null
    //   137: astore 5
    //   139: aload 5
    //   141: ifnull +8 -> 149
    //   144: aload 5
    //   146: invokevirtual 231	android/media/MediaMetadataRetriever:release	()V
    //   149: sipush 26763
    //   152: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   203: sipush 26763
    //   206: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   17	128	5	localMediaMetadataRetriever1	android.media.MediaMetadataRetriever
    //   13	113	6	localMediaMetadataRetriever2	android.media.MediaMetadataRetriever
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
  
  private void f(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(26764);
      this.vym.add(Integer.valueOf(paramInt1));
      this.vyn.add(paramString1);
      this.vyo.add(paramString2);
      this.vyp.add(Integer.valueOf(paramInt2));
      AppMethodBeat.o(26764);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  private static void hH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26762);
    if (bo.isNullOrNil(paramString1))
    {
      ab.w("MicroMsg.NoteVideoCompress", "do insertVideoStorage, but file name is null");
      AppMethodBeat.o(26762);
      return;
    }
    s locals = new s();
    locals.fileName = paramString1;
    locals.fXx = 1;
    locals.cDt = null;
    aw.aaz();
    locals.fXq = ((String)c.Ru().get(2, ""));
    locals.createTime = bo.aox();
    locals.fXv = bo.aox();
    locals.fXD = null;
    locals.fVa = paramString2;
    if (!bo.isNullOrNil(paramString2)) {
      locals.fXB = 1;
    }
    locals.fsd = 0;
    o.alE().b(locals);
    AppMethodBeat.o(26762);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: sipush 26759
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 60	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:vyl	Ljava/util/List;
    //   10: ifnull +1261 -> 1271
    //   13: aload_0
    //   14: getfield 60	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:vyl	Ljava/util/List;
    //   17: invokeinterface 326 1 0
    //   22: ifle +1249 -> 1271
    //   25: iconst_0
    //   26: istore 6
    //   28: iload 6
    //   30: aload_0
    //   31: getfield 60	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:vyl	Ljava/util/List;
    //   34: invokeinterface 326 1 0
    //   39: if_icmpge +1232 -> 1271
    //   42: aload_0
    //   43: getfield 119	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:isStop	Z
    //   46: ifne +1225 -> 1271
    //   49: ldc 86
    //   51: ldc_w 328
    //   54: iconst_1
    //   55: anewarray 90	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_0
    //   61: getfield 60	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:vyl	Ljava/util/List;
    //   64: invokevirtual 329	java/lang/Object:toString	()Ljava/lang/String;
    //   67: aastore
    //   68: invokestatic 101	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: new 331	android/content/Intent
    //   74: dup
    //   75: invokespecial 332	android/content/Intent:<init>	()V
    //   78: astore 16
    //   80: aload 16
    //   82: new 143	java/lang/StringBuilder
    //   85: dup
    //   86: ldc_w 334
    //   89: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: aload_0
    //   93: getfield 60	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:vyl	Ljava/util/List;
    //   96: iload 6
    //   98: invokeinterface 337 2 0
    //   103: checkcast 287	java/lang/String
    //   106: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 346	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   115: invokevirtual 350	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   118: pop
    //   119: invokestatic 356	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   122: astore 17
    //   124: new 143	java/lang/StringBuilder
    //   127: dup
    //   128: ldc_w 358
    //   131: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   134: astore 12
    //   136: invokestatic 271	com/tencent/mm/model/aw:aaz	()Lcom/tencent/mm/model/c;
    //   139: pop
    //   140: aload 12
    //   142: invokestatic 277	com/tencent/mm/model/c:Ru	()Lcom/tencent/mm/storage/z;
    //   145: iconst_2
    //   146: ldc_w 279
    //   149: invokevirtual 285	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   152: checkcast 287	java/lang/String
    //   155: invokestatic 362	com/tencent/mm/modelvideo/t:ve	(Ljava/lang/String;)Ljava/lang/String;
    //   158: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: astore 13
    //   166: aload_0
    //   167: getfield 79	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:vys	Ljava/lang/String;
    //   170: invokestatic 249	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   173: ifne +13 -> 186
    //   176: aload_0
    //   177: getfield 77	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:vyt	Ljava/lang/String;
    //   180: invokestatic 249	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   183: ifeq +83 -> 266
    //   186: invokestatic 316	com/tencent/mm/modelvideo/o:alE	()Lcom/tencent/mm/modelvideo/t;
    //   189: pop
    //   190: aload 13
    //   192: invokestatic 365	com/tencent/mm/modelvideo/t:vg	(Ljava/lang/String;)Ljava/lang/String;
    //   195: astore 15
    //   197: invokestatic 316	com/tencent/mm/modelvideo/o:alE	()Lcom/tencent/mm/modelvideo/t;
    //   200: pop
    //   201: aload 13
    //   203: invokestatic 368	com/tencent/mm/modelvideo/t:vf	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore 14
    //   208: invokestatic 356	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   211: invokestatic 374	com/tencent/mm/sdk/platformtools/at:is2G	(Landroid/content/Context;)Z
    //   214: istore 9
    //   216: aload 17
    //   218: aload 16
    //   220: invokestatic 379	com/tencent/mm/compatible/j/a:i	(Landroid/content/Context;Landroid/content/Intent;)Ljava/lang/String;
    //   223: astore 18
    //   225: aload 18
    //   227: invokestatic 249	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   230: ifeq +79 -> 309
    //   233: ldc 86
    //   235: ldc_w 381
    //   238: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_0
    //   242: ldc_w 384
    //   245: aload 13
    //   247: aload 18
    //   249: iconst_0
    //   250: aconst_null
    //   251: aload 17
    //   253: aconst_null
    //   254: invokespecial 386	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   257: iload 6
    //   259: iconst_1
    //   260: iadd
    //   261: istore 6
    //   263: goto -235 -> 28
    //   266: aload_0
    //   267: getfield 79	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:vys	Ljava/lang/String;
    //   270: astore 15
    //   272: aload_0
    //   273: getfield 77	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:vyt	Ljava/lang/String;
    //   276: aload_0
    //   277: getfield 77	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:vyt	Ljava/lang/String;
    //   280: ldc_w 388
    //   283: invokevirtual 392	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   286: iconst_1
    //   287: iadd
    //   288: aload_0
    //   289: getfield 77	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:vyt	Ljava/lang/String;
    //   292: invokevirtual 395	java/lang/String:length	()I
    //   295: invokevirtual 399	java/lang/String:substring	(II)Ljava/lang/String;
    //   298: astore 13
    //   300: aload_0
    //   301: getfield 77	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:vyt	Ljava/lang/String;
    //   304: astore 14
    //   306: goto -98 -> 208
    //   309: aload 18
    //   311: invokestatic 404	com/tencent/mm/plugin/a/c:wE	(Ljava/lang/String;)Z
    //   314: istore 8
    //   316: aload 18
    //   318: invokestatic 410	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   321: lstore 10
    //   323: iload 8
    //   325: ifeq +557 -> 882
    //   328: new 412	com/tencent/mm/pointers/PInt
    //   331: dup
    //   332: invokespecial 413	com/tencent/mm/pointers/PInt:<init>	()V
    //   335: astore 19
    //   337: invokestatic 419	com/tencent/mm/modelcontrol/d:afW	()Lcom/tencent/mm/modelcontrol/d;
    //   340: aload 18
    //   342: invokevirtual 422	com/tencent/mm/modelcontrol/d:sO	(Ljava/lang/String;)Z
    //   345: ifeq +162 -> 507
    //   348: ldc 86
    //   350: ldc_w 424
    //   353: iconst_1
    //   354: anewarray 90	java/lang/Object
    //   357: dup
    //   358: iconst_0
    //   359: aload 18
    //   361: aastore
    //   362: invokestatic 101	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   365: aload 19
    //   367: iconst_1
    //   368: putfield 427	com/tencent/mm/pointers/PInt:value	I
    //   371: aconst_null
    //   372: astore 12
    //   374: aload 19
    //   376: getfield 427	com/tencent/mm/pointers/PInt:value	I
    //   379: istore_3
    //   380: ldc 86
    //   382: ldc_w 429
    //   385: iconst_3
    //   386: anewarray 90	java/lang/Object
    //   389: dup
    //   390: iconst_0
    //   391: iload_3
    //   392: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   395: aastore
    //   396: dup
    //   397: iconst_1
    //   398: iload 8
    //   400: invokestatic 434	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   403: aastore
    //   404: dup
    //   405: iconst_2
    //   406: lload 10
    //   408: invokestatic 439	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   411: aastore
    //   412: invokestatic 101	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   415: iload_3
    //   416: tableswitch	default:+64 -> 480, -6:+613->1029, -5:+631->1047, -4:+613->1029, -3:+613->1029, -2:+613->1029, -1:+594->1010, 0:+586->1002, 1:+507->923, 2:+507->923, 3:+507->923, 4:+507->923, 5:+507->923
    //   481: sastore
    //   482: ldc_w 441
    //   485: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   488: aload_0
    //   489: ldc_w 442
    //   492: aload 13
    //   494: aload 18
    //   496: iconst_0
    //   497: aconst_null
    //   498: aload 17
    //   500: aconst_null
    //   501: invokespecial 386	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   504: goto -247 -> 257
    //   507: new 444	com/tencent/mm/modelcontrol/VideoTransPara
    //   510: dup
    //   511: invokespecial 445	com/tencent/mm/modelcontrol/VideoTransPara:<init>	()V
    //   514: astore 20
    //   516: new 412	com/tencent/mm/pointers/PInt
    //   519: dup
    //   520: invokespecial 413	com/tencent/mm/pointers/PInt:<init>	()V
    //   523: astore 12
    //   525: new 412	com/tencent/mm/pointers/PInt
    //   528: dup
    //   529: invokespecial 413	com/tencent/mm/pointers/PInt:<init>	()V
    //   532: astore 21
    //   534: new 412	com/tencent/mm/pointers/PInt
    //   537: dup
    //   538: invokespecial 413	com/tencent/mm/pointers/PInt:<init>	()V
    //   541: astore 22
    //   543: new 412	com/tencent/mm/pointers/PInt
    //   546: dup
    //   547: invokespecial 413	com/tencent/mm/pointers/PInt:<init>	()V
    //   550: astore 23
    //   552: new 412	com/tencent/mm/pointers/PInt
    //   555: dup
    //   556: invokespecial 413	com/tencent/mm/pointers/PInt:<init>	()V
    //   559: astore 24
    //   561: aload 18
    //   563: aload 12
    //   565: aload 21
    //   567: aload 22
    //   569: aload 23
    //   571: aload 24
    //   573: invokestatic 450	com/tencent/mm/plugin/sight/base/d:a	(Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Ljava/lang/String;
    //   576: pop
    //   577: aload 20
    //   579: aload 12
    //   581: getfield 427	com/tencent/mm/pointers/PInt:value	I
    //   584: sipush 1000
    //   587: idiv
    //   588: putfield 453	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   591: aload 20
    //   593: aload 21
    //   595: getfield 427	com/tencent/mm/pointers/PInt:value	I
    //   598: putfield 456	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   601: aload 20
    //   603: aload 22
    //   605: getfield 427	com/tencent/mm/pointers/PInt:value	I
    //   608: putfield 459	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   611: aload 20
    //   613: aload 23
    //   615: getfield 427	com/tencent/mm/pointers/PInt:value	I
    //   618: putfield 462	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   621: aload 20
    //   623: aload 24
    //   625: getfield 427	com/tencent/mm/pointers/PInt:value	I
    //   628: putfield 465	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   631: ldc 86
    //   633: ldc_w 467
    //   636: iconst_1
    //   637: anewarray 90	java/lang/Object
    //   640: dup
    //   641: iconst_0
    //   642: aload 20
    //   644: aastore
    //   645: invokestatic 469	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   648: invokestatic 419	com/tencent/mm/modelcontrol/d:afW	()Lcom/tencent/mm/modelcontrol/d;
    //   651: aload 20
    //   653: invokevirtual 472	com/tencent/mm/modelcontrol/d:c	(Lcom/tencent/mm/modelcontrol/VideoTransPara;)Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   656: astore 12
    //   658: aload 12
    //   660: ifnonnull +33 -> 693
    //   663: ldc 86
    //   665: ldc_w 474
    //   668: iconst_1
    //   669: anewarray 90	java/lang/Object
    //   672: dup
    //   673: iconst_0
    //   674: aload 20
    //   676: aastore
    //   677: invokestatic 101	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   680: aload 19
    //   682: bipush 251
    //   684: putfield 427	com/tencent/mm/pointers/PInt:value	I
    //   687: aconst_null
    //   688: astore 12
    //   690: goto -316 -> 374
    //   693: ldc 86
    //   695: ldc_w 476
    //   698: iconst_1
    //   699: anewarray 90	java/lang/Object
    //   702: dup
    //   703: iconst_0
    //   704: aload 12
    //   706: aastore
    //   707: invokestatic 469	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   710: aload 20
    //   712: getfield 465	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   715: ldc_w 477
    //   718: if_icmple +16 -> 734
    //   721: aload 12
    //   723: getfield 465	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   726: aload 20
    //   728: getfield 465	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   731: if_icmple +37 -> 768
    //   734: ldc 86
    //   736: ldc_w 479
    //   739: iconst_2
    //   740: anewarray 90	java/lang/Object
    //   743: dup
    //   744: iconst_0
    //   745: aload 12
    //   747: aastore
    //   748: dup
    //   749: iconst_1
    //   750: aload 20
    //   752: aastore
    //   753: invokestatic 101	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   756: aload 19
    //   758: iconst_1
    //   759: putfield 427	com/tencent/mm/pointers/PInt:value	I
    //   762: aconst_null
    //   763: astore 12
    //   765: goto -391 -> 374
    //   768: aload 20
    //   770: getfield 462	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   773: bipush 45
    //   775: if_icmplt +31 -> 806
    //   778: aload 20
    //   780: getfield 453	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   783: sipush 1000
    //   786: imul
    //   787: ldc_w 480
    //   790: if_icmplt +16 -> 806
    //   793: aload 19
    //   795: bipush 250
    //   797: putfield 427	com/tencent/mm/pointers/PInt:value	I
    //   800: aconst_null
    //   801: astore 12
    //   803: goto -429 -> 374
    //   806: invokestatic 356	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   809: invokestatic 374	com/tencent/mm/sdk/platformtools/at:is2G	(Landroid/content/Context;)Z
    //   812: istore 9
    //   814: aload 12
    //   816: getfield 456	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   819: istore 4
    //   821: aload 12
    //   823: getfield 459	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   826: istore 5
    //   828: iload 9
    //   830: ifeq +38 -> 868
    //   833: ldc_w 481
    //   836: istore_3
    //   837: iload 9
    //   839: ifeq +36 -> 875
    //   842: ldc2_w 482
    //   845: dstore_1
    //   846: aload 19
    //   848: aload 18
    //   850: iload 4
    //   852: iload 5
    //   854: iload_3
    //   855: dload_1
    //   856: ldc_w 484
    //   859: invokestatic 490	com/tencent/mm/plugin/sight/base/SightVideoJNI:shouldRemuxing	(Ljava/lang/String;IIIDI)I
    //   862: putfield 427	com/tencent/mm/pointers/PInt:value	I
    //   865: goto -491 -> 374
    //   868: ldc_w 491
    //   871: istore_3
    //   872: goto -35 -> 837
    //   875: ldc2_w 492
    //   878: dstore_1
    //   879: goto -33 -> 846
    //   882: iload 9
    //   884: ifeq +24 -> 908
    //   887: ldc_w 481
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
    //   908: ldc_w 491
    //   911: istore_3
    //   912: goto -21 -> 891
    //   915: iconst_1
    //   916: istore_3
    //   917: aconst_null
    //   918: astore 12
    //   920: goto -540 -> 380
    //   923: lload 10
    //   925: ldc2_w 494
    //   928: lcmp
    //   929: ifle +65 -> 994
    //   932: aload_0
    //   933: ldc 106
    //   935: aload 13
    //   937: aload 18
    //   939: iconst_0
    //   940: aconst_null
    //   941: aload 17
    //   943: aconst_null
    //   944: invokespecial 386	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   947: iconst_0
    //   948: istore 4
    //   950: ldc 106
    //   952: istore_3
    //   953: aload 17
    //   955: aload 16
    //   957: invokestatic 499	com/tencent/mm/compatible/j/a:j	(Landroid/content/Context;Landroid/content/Intent;)Lcom/tencent/mm/compatible/j/a$a;
    //   960: astore 16
    //   962: aload 16
    //   964: ifnonnull +123 -> 1087
    //   967: ldc 86
    //   969: ldc_w 381
    //   972: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   975: aload_0
    //   976: ldc_w 384
    //   979: aload 13
    //   981: aload 18
    //   983: iconst_0
    //   984: aconst_null
    //   985: aload 17
    //   987: aconst_null
    //   988: invokespecial 386	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
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
    //   1011: ldc_w 500
    //   1014: aload 13
    //   1016: aload 18
    //   1018: iconst_0
    //   1019: aconst_null
    //   1020: aload 17
    //   1022: aconst_null
    //   1023: invokespecial 386	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1026: goto -769 -> 257
    //   1029: aload_0
    //   1030: ldc 106
    //   1032: aload 13
    //   1034: aload 18
    //   1036: iconst_0
    //   1037: aconst_null
    //   1038: aload 17
    //   1040: aconst_null
    //   1041: invokespecial 386	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1044: goto -787 -> 257
    //   1047: aload_0
    //   1048: ldc 131
    //   1050: aload 13
    //   1052: aload 18
    //   1054: iconst_0
    //   1055: aconst_null
    //   1056: aload 17
    //   1058: aconst_null
    //   1059: invokespecial 386	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1062: goto -805 -> 257
    //   1065: astore 16
    //   1067: ldc 86
    //   1069: aload 16
    //   1071: ldc_w 279
    //   1074: iconst_0
    //   1075: anewarray 90	java/lang/Object
    //   1078: invokestatic 237	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1081: aconst_null
    //   1082: astore 16
    //   1084: goto -122 -> 962
    //   1087: iload 4
    //   1089: ifne +135 -> 1224
    //   1092: aload 18
    //   1094: aload 14
    //   1096: invokestatic 504	com/tencent/mm/vfs/e:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   1099: pop2
    //   1100: aload 16
    //   1102: getfield 507	com/tencent/mm/compatible/j/a$a:duration	I
    //   1105: i2l
    //   1106: invokestatic 511	com/tencent/mm/sdk/platformtools/bo:nX	(J)I
    //   1109: istore 7
    //   1111: aload 16
    //   1113: getfield 515	com/tencent/mm/compatible/j/a$a:bitmap	Landroid/graphics/Bitmap;
    //   1116: ifnull +130 -> 1246
    //   1119: aload 16
    //   1121: getfield 515	com/tencent/mm/compatible/j/a$a:bitmap	Landroid/graphics/Bitmap;
    //   1124: bipush 60
    //   1126: getstatic 521	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1129: aload 15
    //   1131: iconst_1
    //   1132: invokestatic 526	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   1135: iconst_0
    //   1136: istore 5
    //   1138: iload 5
    //   1140: ifeq +26 -> 1166
    //   1143: ldc_w 527
    //   1146: sipush 320
    //   1149: sipush 480
    //   1152: invokestatic 531	com/tencent/mm/sdk/platformtools/d:au	(III)Landroid/graphics/Bitmap;
    //   1155: bipush 60
    //   1157: getstatic 521	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1160: aload 15
    //   1162: iconst_1
    //   1163: invokestatic 526	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   1166: iload_3
    //   1167: istore 5
    //   1169: iload 4
    //   1171: ifne +19 -> 1190
    //   1174: iload_3
    //   1175: istore 5
    //   1177: aload 14
    //   1179: invokestatic 534	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   1182: ifne +8 -> 1190
    //   1185: ldc_w 535
    //   1188: istore 5
    //   1190: aload 15
    //   1192: invokestatic 534	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   1195: ifne +8 -> 1203
    //   1198: ldc_w 536
    //   1201: istore 5
    //   1203: aload_0
    //   1204: iload 5
    //   1206: aload 13
    //   1208: aload 18
    //   1210: iload 7
    //   1212: aload 12
    //   1214: aload 17
    //   1216: aload 15
    //   1218: invokespecial 386	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1221: goto -964 -> 257
    //   1224: ldc 133
    //   1226: istore_3
    //   1227: goto -127 -> 1100
    //   1230: astore 16
    //   1232: ldc 86
    //   1234: aload 16
    //   1236: ldc_w 279
    //   1239: iconst_0
    //   1240: anewarray 90	java/lang/Object
    //   1243: invokestatic 237	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1246: iconst_1
    //   1247: istore 5
    //   1249: goto -111 -> 1138
    //   1252: astore 16
    //   1254: ldc 86
    //   1256: aload 16
    //   1258: ldc_w 279
    //   1261: iconst_0
    //   1262: anewarray 90	java/lang/Object
    //   1265: invokestatic 237	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1268: goto -102 -> 1166
    //   1271: sipush 26759
    //   1274: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1277: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1278	0	this	d
    //   845	34	1	d	double
    //   379	848	3	i	int
    //   819	351	4	j	int
    //   826	422	5	k	int
    //   26	236	6	m	int
    //   1109	102	7	n	int
    //   314	85	8	bool1	boolean
    //   214	669	9	bool2	boolean
    //   321	603	10	l	long
    //   134	1079	12	localObject1	Object
    //   164	1043	13	str1	String
    //   206	972	14	str2	String
    //   195	1022	15	str3	String
    //   78	885	16	localObject2	Object
    //   1065	5	16	localException1	java.lang.Exception
    //   1082	38	16	localObject3	Object
    //   1230	5	16	localException2	java.lang.Exception
    //   1252	5	16	localException3	java.lang.Exception
    //   122	1093	17	localContext	Context
    //   223	986	18	str4	String
    //   335	512	19	localPInt1	com.tencent.mm.pointers.PInt
    //   514	265	20	localVideoTransPara	VideoTransPara
    //   532	62	21	localPInt2	com.tencent.mm.pointers.PInt
    //   541	63	22	localPInt3	com.tencent.mm.pointers.PInt
    //   550	64	23	localPInt4	com.tencent.mm.pointers.PInt
    //   559	65	24	localPInt5	com.tencent.mm.pointers.PInt
    // Exception table:
    //   from	to	target	type
    //   953	962	1065	java/lang/Exception
    //   1119	1135	1230	java/lang/Exception
    //   1143	1166	1252	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.d
 * JD-Core Version:    0.7.0.1
 */