package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.a.e;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.cb;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d
  extends Thread
{
  private static HashMap<String, b> xzl;
  private static Object xzm;
  private static QueueWorkerThread xzn;
  private a XAX;
  private k XAY;
  public boolean isStop;
  private List<String> xzb;
  private List<Integer> xzc;
  private List<String> xzd;
  private List<String> xze;
  private List<Integer> xzf;
  private String xzi;
  private String xzj;
  private boolean xzk;
  
  static
  {
    AppMethodBeat.i(30458);
    xzl = new HashMap();
    xzm = new byte[0];
    AppMethodBeat.o(30458);
  }
  
  public d(List<String> paramList, String paramString1, String paramString2, k paramk, a parama)
  {
    AppMethodBeat.i(30451);
    this.xzk = false;
    this.xzb = paramList;
    this.xzc = new ArrayList();
    this.xzd = new ArrayList();
    this.xzf = new ArrayList();
    this.xze = new ArrayList();
    this.XAX = parama;
    this.XAY = paramk;
    this.xzj = paramString2;
    this.xzi = paramString1;
    AppMethodBeat.o(30451);
  }
  
  private void a(final int paramInt1, String paramString1, String paramString2, int paramInt2, VideoTransPara paramVideoTransPara, Context arg6, final String paramString3)
  {
    AppMethodBeat.i(30453);
    Log.i("MicroMsg.NoteVideoCompress", "finish to import %s to %s | ret %d | duration %d", new Object[] { paramString2, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    c(paramInt1, paramString1, paramString2, paramInt2);
    if (paramInt1 == -50002) {
      ax(???, ???.getString(R.l.video_export_file_too_big));
    }
    for (;;)
    {
      if ((this.XAX != null) && (!this.isStop)) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30447);
            d.b(d.this).a(paramString3, d.a(d.this));
            if ((d.c(d.this)) || (paramInt1 != -50006)) {
              bh.baH().postToWorkerDelayed(new Runnable()
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
        ax(???, ???.getString(R.l.video_export_duration_too_long));
      }
      else
      {
        b localb;
        if (paramInt1 == -50006)
        {
          gC(paramString1, paramString2);
          if (xzn == null) {
            xzn = new QueueWorkerThread(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
          }
          localb = new b((byte)0);
        }
        synchronized (xzm)
        {
          xzl.put(paramString1, localb);
          localb.fileName = paramString1;
          localb.oYj = paramString2;
          localb.rBg = this.xzj;
          localb.paR = paramVideoTransPara;
          b.a(localb, this.XAX);
          localb.XAY = this.XAY;
          xzn.add(localb);
        }
        continue;
        this.xzk = true;
      }
    }
  }
  
  private void ax(final Context paramContext, final String paramString)
  {
    AppMethodBeat.i(30454);
    MMHandlerThread.postToMainThread(new Runnable()
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
  
  private void c(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(30457);
      this.xzc.add(Integer.valueOf(paramInt1));
      this.xzd.add(paramString1);
      this.xze.add(paramString2);
      this.xzf.add(Integer.valueOf(paramInt2));
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
  public static void c(String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: sipush 30456
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 230	com/tencent/mm/compatible/i/d
    //   9: dup
    //   10: invokespecial 231	com/tencent/mm/compatible/i/d:<init>	()V
    //   13: astore 6
    //   15: aload 6
    //   17: astore 5
    //   19: aload 6
    //   21: aload_0
    //   22: invokevirtual 236	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   25: aload 6
    //   27: astore 5
    //   29: aload 6
    //   31: bipush 18
    //   33: invokevirtual 239	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   36: iconst_0
    //   37: invokestatic 245	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   40: istore_2
    //   41: aload 6
    //   43: astore 5
    //   45: aload 6
    //   47: bipush 19
    //   49: invokevirtual 239	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   52: iconst_0
    //   53: invokestatic 245	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   56: istore_3
    //   57: aload 6
    //   59: invokevirtual 248	android/media/MediaMetadataRetriever:release	()V
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
    //   111: ldc 250
    //   113: iconst_0
    //   114: anewarray 97	java/lang/Object
    //   117: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: aload 6
    //   122: ifnull +8 -> 130
    //   125: aload 6
    //   127: invokevirtual 248	android/media/MediaMetadataRetriever:release	()V
    //   130: iconst_0
    //   131: istore_3
    //   132: goto -70 -> 62
    //   135: astore_0
    //   136: aconst_null
    //   137: astore 5
    //   139: aload 5
    //   141: ifnull +8 -> 149
    //   144: aload 5
    //   146: invokevirtual 248	android/media/MediaMetadataRetriever:release	()V
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
    //   17	128	5	locald1	com.tencent.mm.compatible.i.d
    //   13	113	6	locald2	com.tencent.mm.compatible.i.d
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
  
  private static void gC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(30455);
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.NoteVideoCompress", "do insertVideoStorage, but file name is null");
      AppMethodBeat.o(30455);
      return;
    }
    z localz = new z();
    localz.fileName = paramString1;
    localz.omT = 1;
    localz.hVQ = null;
    bh.bCz();
    localz.paV = ((String)c.ban().d(2, ""));
    localz.createTime = Util.nowSecond();
    localz.pba = Util.nowSecond();
    localz.pbh = null;
    localz.oYj = paramString2;
    if (!Util.isNullOrNil(paramString2)) {
      localz.pbf = 1;
    }
    localz.osy = 0;
    v.bOh().b(localz);
    AppMethodBeat.o(30455);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: sipush 30452
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 68	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:xzb	Ljava/util/List;
    //   10: ifnull +1264 -> 1274
    //   13: aload_0
    //   14: getfield 68	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:xzb	Ljava/util/List;
    //   17: invokeinterface 338 1 0
    //   22: ifle +1252 -> 1274
    //   25: iconst_0
    //   26: istore 6
    //   28: iload 6
    //   30: aload_0
    //   31: getfield 68	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:xzb	Ljava/util/List;
    //   34: invokeinterface 338 1 0
    //   39: if_icmpge +1235 -> 1274
    //   42: aload_0
    //   43: getfield 131	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:isStop	Z
    //   46: ifne +1228 -> 1274
    //   49: ldc 93
    //   51: ldc_w 340
    //   54: iconst_1
    //   55: anewarray 97	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_0
    //   61: getfield 68	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:xzb	Ljava/util/List;
    //   64: invokevirtual 341	java/lang/Object:toString	()Ljava/lang/String;
    //   67: aastore
    //   68: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: new 343	android/content/Intent
    //   74: dup
    //   75: invokespecial 344	android/content/Intent:<init>	()V
    //   78: astore 16
    //   80: aload 16
    //   82: new 155	java/lang/StringBuilder
    //   85: dup
    //   86: ldc_w 346
    //   89: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: aload_0
    //   93: getfield 68	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:xzb	Ljava/util/List;
    //   96: iload 6
    //   98: invokeinterface 350 2 0
    //   103: checkcast 299	java/lang/String
    //   106: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 359	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   115: invokevirtual 363	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   118: pop
    //   119: invokestatic 369	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   122: astore 17
    //   124: new 155	java/lang/StringBuilder
    //   127: dup
    //   128: ldc_w 371
    //   131: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   134: astore 12
    //   136: invokestatic 284	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   139: pop
    //   140: aload 12
    //   142: invokestatic 290	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
    //   145: iconst_2
    //   146: ldc_w 292
    //   149: invokevirtual 297	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
    //   152: checkcast 299	java/lang/String
    //   155: invokestatic 375	com/tencent/mm/modelvideo/aa:PV	(Ljava/lang/String;)Ljava/lang/String;
    //   158: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: astore 13
    //   166: aload_0
    //   167: getfield 87	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:xzi	Ljava/lang/String;
    //   170: invokestatic 263	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   173: ifne +13 -> 186
    //   176: aload_0
    //   177: getfield 85	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:xzj	Ljava/lang/String;
    //   180: invokestatic 263	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   183: ifeq +83 -> 266
    //   186: invokestatic 328	com/tencent/mm/modelvideo/v:bOh	()Lcom/tencent/mm/modelvideo/aa;
    //   189: pop
    //   190: aload 13
    //   192: invokestatic 378	com/tencent/mm/modelvideo/aa:PY	(Ljava/lang/String;)Ljava/lang/String;
    //   195: astore 15
    //   197: invokestatic 328	com/tencent/mm/modelvideo/v:bOh	()Lcom/tencent/mm/modelvideo/aa;
    //   200: pop
    //   201: aload 13
    //   203: invokestatic 381	com/tencent/mm/modelvideo/aa:PX	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore 14
    //   208: invokestatic 369	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   211: invokestatic 387	com/tencent/mm/sdk/platformtools/NetStatusUtil:is2G	(Landroid/content/Context;)Z
    //   214: istore 9
    //   216: aload 17
    //   218: aload 16
    //   220: invokestatic 392	com/tencent/mm/compatible/i/a:i	(Landroid/content/Context;Landroid/content/Intent;)Ljava/lang/String;
    //   223: astore 18
    //   225: aload 18
    //   227: invokestatic 263	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   230: ifeq +79 -> 309
    //   233: ldc 93
    //   235: ldc_w 394
    //   238: invokestatic 397	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_0
    //   242: ldc_w 398
    //   245: aload 13
    //   247: aload 18
    //   249: iconst_0
    //   250: aconst_null
    //   251: aload 17
    //   253: aconst_null
    //   254: invokespecial 400	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   257: iload 6
    //   259: iconst_1
    //   260: iadd
    //   261: istore 6
    //   263: goto -235 -> 28
    //   266: aload_0
    //   267: getfield 87	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:xzi	Ljava/lang/String;
    //   270: astore 15
    //   272: aload_0
    //   273: getfield 85	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:xzj	Ljava/lang/String;
    //   276: aload_0
    //   277: getfield 85	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:xzj	Ljava/lang/String;
    //   280: ldc_w 402
    //   283: invokevirtual 406	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   286: iconst_1
    //   287: iadd
    //   288: aload_0
    //   289: getfield 85	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:xzj	Ljava/lang/String;
    //   292: invokevirtual 409	java/lang/String:length	()I
    //   295: invokevirtual 413	java/lang/String:substring	(II)Ljava/lang/String;
    //   298: astore 13
    //   300: aload_0
    //   301: getfield 85	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:xzj	Ljava/lang/String;
    //   304: astore 14
    //   306: goto -98 -> 208
    //   309: aload 18
    //   311: invokestatic 418	com/tencent/mm/plugin/a/c:Sm	(Ljava/lang/String;)Z
    //   314: istore 8
    //   316: aload 18
    //   318: invokestatic 424	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   321: lstore 10
    //   323: iload 8
    //   325: ifeq +557 -> 882
    //   328: new 426	com/tencent/mm/pointers/PInt
    //   331: dup
    //   332: invokespecial 427	com/tencent/mm/pointers/PInt:<init>	()V
    //   335: astore 19
    //   337: invokestatic 433	com/tencent/mm/modelcontrol/e:bIg	()Lcom/tencent/mm/modelcontrol/e;
    //   340: aload 18
    //   342: invokevirtual 436	com/tencent/mm/modelcontrol/e:NE	(Ljava/lang/String;)Z
    //   345: ifeq +162 -> 507
    //   348: ldc 93
    //   350: ldc_w 438
    //   353: iconst_1
    //   354: anewarray 97	java/lang/Object
    //   357: dup
    //   358: iconst_0
    //   359: aload 18
    //   361: aastore
    //   362: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   365: aload 19
    //   367: iconst_1
    //   368: putfield 441	com/tencent/mm/pointers/PInt:value	I
    //   371: aconst_null
    //   372: astore 12
    //   374: aload 19
    //   376: getfield 441	com/tencent/mm/pointers/PInt:value	I
    //   379: istore_3
    //   380: ldc 93
    //   382: ldc_w 443
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
    //   400: invokestatic 448	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   403: aastore
    //   404: dup
    //   405: iconst_2
    //   406: lload 10
    //   408: invokestatic 453	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   411: aastore
    //   412: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   415: iload_3
    //   416: tableswitch	default:+64 -> 480, -6:+613->1029, -5:+631->1047, -4:+613->1029, -3:+613->1029, -2:+613->1029, -1:+594->1010, 0:+586->1002, 1:+507->923, 2:+507->923, 3:+507->923, 4:+507->923, 5:+507->923
    //   481: dup2_x1
    //   482: ldc_w 455
    //   485: invokestatic 397	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   488: aload_0
    //   489: ldc_w 456
    //   492: aload 13
    //   494: aload 18
    //   496: iconst_0
    //   497: aconst_null
    //   498: aload 17
    //   500: aconst_null
    //   501: invokespecial 400	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   504: goto -247 -> 257
    //   507: new 458	com/tencent/mm/modelcontrol/VideoTransPara
    //   510: dup
    //   511: invokespecial 459	com/tencent/mm/modelcontrol/VideoTransPara:<init>	()V
    //   514: astore 20
    //   516: new 426	com/tencent/mm/pointers/PInt
    //   519: dup
    //   520: invokespecial 427	com/tencent/mm/pointers/PInt:<init>	()V
    //   523: astore 12
    //   525: new 426	com/tencent/mm/pointers/PInt
    //   528: dup
    //   529: invokespecial 427	com/tencent/mm/pointers/PInt:<init>	()V
    //   532: astore 21
    //   534: new 426	com/tencent/mm/pointers/PInt
    //   537: dup
    //   538: invokespecial 427	com/tencent/mm/pointers/PInt:<init>	()V
    //   541: astore 22
    //   543: new 426	com/tencent/mm/pointers/PInt
    //   546: dup
    //   547: invokespecial 427	com/tencent/mm/pointers/PInt:<init>	()V
    //   550: astore 23
    //   552: new 426	com/tencent/mm/pointers/PInt
    //   555: dup
    //   556: invokespecial 427	com/tencent/mm/pointers/PInt:<init>	()V
    //   559: astore 24
    //   561: aload 18
    //   563: aload 12
    //   565: aload 21
    //   567: aload 22
    //   569: aload 23
    //   571: aload 24
    //   573: invokestatic 464	com/tencent/mm/plugin/sight/base/f:a	(Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Ljava/lang/String;
    //   576: pop
    //   577: aload 20
    //   579: aload 12
    //   581: getfield 441	com/tencent/mm/pointers/PInt:value	I
    //   584: sipush 1000
    //   587: idiv
    //   588: putfield 467	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   591: aload 20
    //   593: aload 21
    //   595: getfield 441	com/tencent/mm/pointers/PInt:value	I
    //   598: putfield 470	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   601: aload 20
    //   603: aload 22
    //   605: getfield 441	com/tencent/mm/pointers/PInt:value	I
    //   608: putfield 473	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   611: aload 20
    //   613: aload 23
    //   615: getfield 441	com/tencent/mm/pointers/PInt:value	I
    //   618: putfield 476	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   621: aload 20
    //   623: aload 24
    //   625: getfield 441	com/tencent/mm/pointers/PInt:value	I
    //   628: putfield 479	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   631: ldc 93
    //   633: ldc_w 481
    //   636: iconst_1
    //   637: anewarray 97	java/lang/Object
    //   640: dup
    //   641: iconst_0
    //   642: aload 20
    //   644: aastore
    //   645: invokestatic 483	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   648: invokestatic 433	com/tencent/mm/modelcontrol/e:bIg	()Lcom/tencent/mm/modelcontrol/e;
    //   651: aload 20
    //   653: invokevirtual 486	com/tencent/mm/modelcontrol/e:c	(Lcom/tencent/mm/modelcontrol/VideoTransPara;)Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   656: astore 12
    //   658: aload 12
    //   660: ifnonnull +33 -> 693
    //   663: ldc 93
    //   665: ldc_w 488
    //   668: iconst_1
    //   669: anewarray 97	java/lang/Object
    //   672: dup
    //   673: iconst_0
    //   674: aload 20
    //   676: aastore
    //   677: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   680: aload 19
    //   682: bipush 251
    //   684: putfield 441	com/tencent/mm/pointers/PInt:value	I
    //   687: aconst_null
    //   688: astore 12
    //   690: goto -316 -> 374
    //   693: ldc 93
    //   695: ldc_w 490
    //   698: iconst_1
    //   699: anewarray 97	java/lang/Object
    //   702: dup
    //   703: iconst_0
    //   704: aload 12
    //   706: aastore
    //   707: invokestatic 483	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   710: aload 20
    //   712: getfield 479	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   715: ldc_w 491
    //   718: if_icmple +16 -> 734
    //   721: aload 12
    //   723: getfield 479	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   726: aload 20
    //   728: getfield 479	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   731: if_icmple +37 -> 768
    //   734: ldc 93
    //   736: ldc_w 493
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
    //   753: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   756: aload 19
    //   758: iconst_1
    //   759: putfield 441	com/tencent/mm/pointers/PInt:value	I
    //   762: aconst_null
    //   763: astore 12
    //   765: goto -391 -> 374
    //   768: aload 20
    //   770: getfield 476	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   773: bipush 45
    //   775: if_icmplt +31 -> 806
    //   778: aload 20
    //   780: getfield 467	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   783: sipush 1000
    //   786: imul
    //   787: ldc_w 494
    //   790: if_icmplt +16 -> 806
    //   793: aload 19
    //   795: bipush 250
    //   797: putfield 441	com/tencent/mm/pointers/PInt:value	I
    //   800: aconst_null
    //   801: astore 12
    //   803: goto -429 -> 374
    //   806: invokestatic 369	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   809: invokestatic 387	com/tencent/mm/sdk/platformtools/NetStatusUtil:is2G	(Landroid/content/Context;)Z
    //   812: istore 9
    //   814: aload 12
    //   816: getfield 470	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   819: istore 4
    //   821: aload 12
    //   823: getfield 473	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   826: istore 5
    //   828: iload 9
    //   830: ifeq +38 -> 868
    //   833: ldc_w 495
    //   836: istore_3
    //   837: iload 9
    //   839: ifeq +36 -> 875
    //   842: ldc2_w 496
    //   845: dstore_1
    //   846: aload 19
    //   848: aload 18
    //   850: iload 4
    //   852: iload 5
    //   854: iload_3
    //   855: dload_1
    //   856: ldc_w 498
    //   859: invokestatic 504	com/tencent/mm/plugin/sight/base/SightVideoJNI:shouldRemuxingVFS	(Ljava/lang/String;IIIDI)I
    //   862: putfield 441	com/tencent/mm/pointers/PInt:value	I
    //   865: goto -491 -> 374
    //   868: ldc_w 505
    //   871: istore_3
    //   872: goto -35 -> 837
    //   875: ldc2_w 506
    //   878: dstore_1
    //   879: goto -33 -> 846
    //   882: iload 9
    //   884: ifeq +24 -> 908
    //   887: ldc_w 495
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
    //   908: ldc_w 505
    //   911: istore_3
    //   912: goto -21 -> 891
    //   915: iconst_1
    //   916: istore_3
    //   917: aconst_null
    //   918: astore 12
    //   920: goto -540 -> 380
    //   923: lload 10
    //   925: ldc2_w 508
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
    //   944: invokespecial 400	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   947: iconst_0
    //   948: istore 4
    //   950: ldc 113
    //   952: istore_3
    //   953: aload 17
    //   955: aload 16
    //   957: invokestatic 513	com/tencent/mm/compatible/i/a:j	(Landroid/content/Context;Landroid/content/Intent;)Lcom/tencent/mm/compatible/i/a$a;
    //   960: astore 16
    //   962: aload 16
    //   964: ifnonnull +123 -> 1087
    //   967: ldc 93
    //   969: ldc_w 394
    //   972: invokestatic 397	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   975: aload_0
    //   976: ldc_w 398
    //   979: aload 13
    //   981: aload 18
    //   983: iconst_0
    //   984: aconst_null
    //   985: aload 17
    //   987: aconst_null
    //   988: invokespecial 400	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
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
    //   1011: ldc_w 514
    //   1014: aload 13
    //   1016: aload 18
    //   1018: iconst_0
    //   1019: aconst_null
    //   1020: aload 17
    //   1022: aconst_null
    //   1023: invokespecial 400	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1026: goto -769 -> 257
    //   1029: aload_0
    //   1030: ldc 113
    //   1032: aload 13
    //   1034: aload 18
    //   1036: iconst_0
    //   1037: aconst_null
    //   1038: aload 17
    //   1040: aconst_null
    //   1041: invokespecial 400	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1044: goto -787 -> 257
    //   1047: aload_0
    //   1048: ldc 141
    //   1050: aload 13
    //   1052: aload 18
    //   1054: iconst_0
    //   1055: aconst_null
    //   1056: aload 17
    //   1058: aconst_null
    //   1059: invokespecial 400	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1062: goto -805 -> 257
    //   1065: astore 16
    //   1067: ldc 93
    //   1069: aload 16
    //   1071: ldc_w 292
    //   1074: iconst_0
    //   1075: anewarray 97	java/lang/Object
    //   1078: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1081: aconst_null
    //   1082: astore 16
    //   1084: goto -122 -> 962
    //   1087: iload 4
    //   1089: ifne +138 -> 1227
    //   1092: aload 18
    //   1094: aload 14
    //   1096: iconst_0
    //   1097: invokestatic 518	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   1100: pop2
    //   1101: aload 16
    //   1103: getfield 521	com/tencent/mm/compatible/i/a$a:duration	I
    //   1106: i2l
    //   1107: invokestatic 525	com/tencent/mm/sdk/platformtools/Util:videoMsToSec	(J)I
    //   1110: istore 7
    //   1112: aload 16
    //   1114: getfield 529	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   1117: ifnull +132 -> 1249
    //   1120: aload 16
    //   1122: getfield 529	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   1125: bipush 60
    //   1127: getstatic 535	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1130: aload 15
    //   1132: iconst_1
    //   1133: invokestatic 541	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   1136: pop
    //   1137: iconst_0
    //   1138: istore 5
    //   1140: iload 5
    //   1142: ifeq +27 -> 1169
    //   1145: ldc_w 542
    //   1148: sipush 320
    //   1151: sipush 480
    //   1154: invokestatic 546	com/tencent/mm/sdk/platformtools/BitmapUtil:createColorBitmap	(III)Landroid/graphics/Bitmap;
    //   1157: bipush 60
    //   1159: getstatic 535	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1162: aload 15
    //   1164: iconst_1
    //   1165: invokestatic 541	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   1168: pop
    //   1169: iload_3
    //   1170: istore 5
    //   1172: iload 4
    //   1174: ifne +19 -> 1193
    //   1177: iload_3
    //   1178: istore 5
    //   1180: aload 14
    //   1182: invokestatic 549	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   1185: ifne +8 -> 1193
    //   1188: ldc_w 550
    //   1191: istore 5
    //   1193: aload 15
    //   1195: invokestatic 549	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   1198: ifne +8 -> 1206
    //   1201: ldc_w 551
    //   1204: istore 5
    //   1206: aload_0
    //   1207: iload 5
    //   1209: aload 13
    //   1211: aload 18
    //   1213: iload 7
    //   1215: aload 12
    //   1217: aload 17
    //   1219: aload 15
    //   1221: invokespecial 400	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1224: goto -967 -> 257
    //   1227: ldc 145
    //   1229: istore_3
    //   1230: goto -129 -> 1101
    //   1233: astore 16
    //   1235: ldc 93
    //   1237: aload 16
    //   1239: ldc_w 292
    //   1242: iconst_0
    //   1243: anewarray 97	java/lang/Object
    //   1246: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1249: iconst_1
    //   1250: istore 5
    //   1252: goto -112 -> 1140
    //   1255: astore 16
    //   1257: ldc 93
    //   1259: aload 16
    //   1261: ldc_w 292
    //   1264: iconst_0
    //   1265: anewarray 97	java/lang/Object
    //   1268: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1271: goto -102 -> 1169
    //   1274: sipush 30452
    //   1277: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1280: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1281	0	this	d
    //   845	34	1	d	double
    //   379	851	3	i	int
    //   819	354	4	j	int
    //   826	425	5	k	int
    //   26	236	6	m	int
    //   1110	104	7	n	int
    //   314	85	8	bool1	boolean
    //   214	669	9	bool2	boolean
    //   321	603	10	l	long
    //   134	1082	12	localObject1	Object
    //   164	1046	13	str1	String
    //   206	975	14	str2	String
    //   195	1025	15	str3	String
    //   78	885	16	localObject2	Object
    //   1065	5	16	localException1	Exception
    //   1082	39	16	localObject3	Object
    //   1233	5	16	localException2	Exception
    //   1255	5	16	localException3	Exception
    //   122	1096	17	localContext	Context
    //   223	989	18	str4	String
    //   335	512	19	localPInt1	PInt
    //   514	265	20	localVideoTransPara	VideoTransPara
    //   532	62	21	localPInt2	PInt
    //   541	63	22	localPInt3	PInt
    //   550	64	23	localPInt4	PInt
    //   559	65	24	localPInt5	PInt
    // Exception table:
    //   from	to	target	type
    //   953	962	1065	java/lang/Exception
    //   1120	1137	1233	java/lang/Exception
    //   1145	1169	1255	java/lang/Exception
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, k paramk);
    
    public abstract void b(String paramString, k paramk);
  }
  
  static final class b
    implements QueueWorkerThread.ThreadObject
  {
    private d.a XAX;
    k XAY;
    String fileName;
    String oYj;
    private int outputHeight;
    private int outputWidth;
    VideoTransPara paR;
    String rBg;
    int xzs;
    private boolean xzt;
    private int xzu = 0;
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(30449);
      for (;;)
      {
        synchronized (d.xzm)
        {
          int i;
          if (!d.dwz().containsKey(this.fileName))
          {
            i = 1;
            j = i;
            if (i == 0)
            {
              if (ab.Qo(this.fileName) == null) {
                j = 1;
              }
            }
            else
            {
              if (j == 0) {
                break;
              }
              Log.w("MicroMsg.NoteVideoCompress", "remuxing job has been removed, filename %s", new Object[] { this.fileName });
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
      if ((this.paR != null) && (!this.paR.oBZ)) {
        this.outputWidth = this.paR.width;
      }
      Object localObject3;
      for (this.outputHeight = this.paR.height;; this.outputHeight = ???[1])
      {
        ??? = new PString();
        localObject3 = new PInt();
        bh.bCz();
        if ((!c.bzI().a(this.oYj, (PString)???, (PInt)localObject3)) || (y.O(((PString)???).value, this.rBg, false) < 0L)) {
          break;
        }
        Log.i("MicroMsg.NoteVideoCompress", "copy remuxing file success, do not remuxing again.");
        this.xzs = ((PInt)localObject3).value;
        this.xzt = true;
        AppMethodBeat.o(30449);
        return true;
        ??? = new int[2];
        d.c(this.oYj, (int[])???);
        this.outputWidth = ???[0];
      }
      long l = Util.currentTicks();
      if (this.paR != null)
      {
        Log.i("MicroMsg.NoteVideoCompress", "remuxing new para %s", new Object[] { this.paR });
        this.xzs = SightVideoJNI.remuxingVFS(this.oYj, this.rBg, this.outputWidth, this.outputHeight, this.paR.videoBitrate, this.paR.oBP, 8, this.paR.oBO, 25.0F, this.paR.fps, null, 0, false, 0, 51);
        this.xzu = ((int)Util.ticksToNow(l));
        Log.i("MicroMsg.NoteVideoCompress", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { this.oYj, this.rBg, Integer.valueOf(this.xzs), Integer.valueOf(this.outputWidth), Integer.valueOf(this.outputHeight) });
        if (this.xzs < 0) {
          break label581;
        }
      }
      label581:
      for (boolean bool = true;; bool = false)
      {
        this.xzt = bool;
        ??? = new PInt();
        localObject3 = new PInt();
        if (ab.a(this.rBg, (PInt)???, (PInt)localObject3)) {
          this.xzs = ((PInt)???).value;
        }
        if (this.xzt) {
          break label587;
        }
        Log.w("MicroMsg.NoteVideoCompress", "remuxing video error, copy source video to send.");
        y.deleteFile(this.rBg);
        y.O(this.oYj, this.rBg, false);
        AppMethodBeat.o(30449);
        return true;
        Log.w("MicroMsg.NoteVideoCompress", "remuxing but new para is null. %s", new Object[] { this.fileName });
        this.xzs = SightVideoJNI.remuxingVFS(this.oYj, this.rBg, this.outputWidth, this.outputHeight, com.tencent.mm.plugin.sight.base.d.PFk, com.tencent.mm.plugin.sight.base.d.PFj, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.d.PFl, null, 0, false, 0, 51);
        break;
      }
      label587:
      Log.i("MicroMsg.NoteVideoCompress", "remuxing video sucess,insert to media duplication storage");
      for (;;)
      {
        PInt localPInt;
        try
        {
          localObject3 = new u(this.rBg);
          ??? = ((u)localObject3).getName();
          String str = this.rBg + ".tmp";
          localPInt = new PInt(0);
          if (!e.b(this.rBg, str, localPInt)) {
            break label808;
          }
          bool = ((u)localObject3).diJ();
          localObject3 = new u(str);
          Log.i("MicroMsg.NoteVideoCompress", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(y.bF(((u)localObject3).jKO() + "/", ((u)localObject3).getName(), (String)???)), ah.v(((u)localObject3).jKT()), this.rBg });
          bh.bCz();
          c.bzI().aO(this.oYj, this.rBg, this.xzs);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.NoteVideoCompress", "fast start exception e[%s]", new Object[] { localException.toString() });
        }
        break;
        label808:
        Log.i("MicroMsg.NoteVideoCompress", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", new Object[] { Integer.valueOf(localPInt.value), this.oYj, this.rBg });
      }
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(30450);
      synchronized (d.xzm)
      {
        d.dwz().remove(this.fileName);
        if (this.XAX != null) {
          this.XAX.b(this.rBg, this.XAY);
        }
        AppMethodBeat.o(30450);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.d
 * JD-Core Version:    0.7.0.1
 */