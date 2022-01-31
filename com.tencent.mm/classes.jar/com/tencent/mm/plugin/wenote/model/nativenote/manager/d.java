package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d
  extends Thread
{
  private static HashMap<String, d.b> rHO = new HashMap();
  private static Object rHP = new byte[0];
  private static av rHQ;
  public boolean isStop;
  private List<String> rHE;
  private List<Integer> rHF;
  private List<String> rHG;
  private List<String> rHH;
  private List<Integer> rHI;
  private d.a rHJ;
  private k rHK;
  private String rHL;
  private String rHM;
  private boolean rHN = false;
  
  public d(List<String> paramList, String paramString1, String paramString2, k paramk, d.a parama)
  {
    this.rHE = paramList;
    this.rHF = new ArrayList();
    this.rHG = new ArrayList();
    this.rHI = new ArrayList();
    this.rHH = new ArrayList();
    this.rHJ = parama;
    this.rHK = paramk;
    this.rHM = paramString2;
    this.rHL = paramString1;
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, int paramInt2, VideoTransPara paramVideoTransPara, Context arg6, String paramString3)
  {
    y.i("MicroMsg.NoteVideoCompress", "finish to import %s to %s | ret %d | duration %d", new Object[] { paramString2, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    e(paramInt1, paramString1, paramString2, paramInt2);
    if (paramInt1 == -50002) {
      be(???, ???.getString(R.l.video_export_file_too_big));
    }
    for (;;)
    {
      if ((this.rHJ != null) && (!this.isStop)) {
        ai.d(new d.1(this, paramString3, paramInt1));
      }
      return;
      if (paramInt1 == -50008)
      {
        be(???, ???.getString(R.l.video_export_duration_too_long));
      }
      else
      {
        if (paramInt1 == -50006)
        {
          d.b localb;
          if (bk.bl(paramString1))
          {
            y.w("MicroMsg.NoteVideoCompress", "do insertVideoStorage, but file name is null");
            if (rHQ == null) {
              rHQ = new av(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
            }
            localb = new d.b((byte)0);
          }
          synchronized (rHP)
          {
            rHO.put(paramString1, localb);
            localb.fileName = paramString1;
            localb.eFj = paramString2;
            localb.rHT = this.rHM;
            localb.eHv = paramVideoTransPara;
            localb.rHJ = this.rHJ;
            localb.rHK = this.rHK;
            rHQ.c(localb);
            continue;
            ??? = new s();
            ???.fileName = paramString1;
            ???.eHH = 1;
            ???.bVI = null;
            au.Hx();
            ???.eHA = ((String)c.Dz().get(2, ""));
            ???.createTime = bk.UX();
            ???.eHF = bk.UX();
            ???.eHN = null;
            ???.eFj = paramString2;
            if (!bk.bl(paramString2)) {
              ???.eHL = 1;
            }
            ???.ebK = 0;
            o.Sr().b(???);
          }
        }
        if (paramInt1 < 0) {
          be(???, ???.getString(R.l.video_export_file_error));
        } else {
          this.rHN = true;
        }
      }
    }
  }
  
  private void be(Context paramContext, String paramString)
  {
    ai.d(new d.2(this, paramContext, paramString));
  }
  
  /* Error */
  public static void c(String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: new 285	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 286	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: astore 5
    //   13: aload 6
    //   15: aload_0
    //   16: invokevirtual 289	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   19: aload 6
    //   21: astore 5
    //   23: aload 6
    //   25: bipush 18
    //   27: invokevirtual 292	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   30: iconst_0
    //   31: invokestatic 296	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   34: istore_2
    //   35: aload 6
    //   37: astore 5
    //   39: aload 6
    //   41: bipush 19
    //   43: invokevirtual 292	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   46: iconst_0
    //   47: invokestatic 296	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   50: istore_3
    //   51: aload 6
    //   53: invokevirtual 299	android/media/MediaMetadataRetriever:release	()V
    //   56: aload_1
    //   57: iconst_0
    //   58: iload_2
    //   59: iastore
    //   60: aload_1
    //   61: iconst_1
    //   62: iload_3
    //   63: iastore
    //   64: iconst_0
    //   65: istore 4
    //   67: iload 4
    //   69: iconst_3
    //   70: if_icmpge +108 -> 178
    //   73: iload_2
    //   74: iconst_2
    //   75: irem
    //   76: ifne +9 -> 85
    //   79: iload_3
    //   80: iconst_2
    //   81: irem
    //   82: ifeq +58 -> 140
    //   85: return
    //   86: astore_0
    //   87: iconst_0
    //   88: istore_2
    //   89: aconst_null
    //   90: astore 6
    //   92: aload 6
    //   94: astore 5
    //   96: ldc 77
    //   98: aload_0
    //   99: ldc_w 301
    //   102: iconst_0
    //   103: anewarray 81	java/lang/Object
    //   106: invokestatic 305	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: aload 6
    //   111: ifnull +8 -> 119
    //   114: aload 6
    //   116: invokevirtual 299	android/media/MediaMetadataRetriever:release	()V
    //   119: iconst_0
    //   120: istore_3
    //   121: goto -65 -> 56
    //   124: astore_0
    //   125: aconst_null
    //   126: astore 5
    //   128: aload 5
    //   130: ifnull +8 -> 138
    //   133: aload 5
    //   135: invokevirtual 299	android/media/MediaMetadataRetriever:release	()V
    //   138: aload_0
    //   139: athrow
    //   140: iload_2
    //   141: iload_3
    //   142: if_icmplt +17 -> 159
    //   145: iload_2
    //   146: sipush 640
    //   149: if_icmple +29 -> 178
    //   152: iload_3
    //   153: sipush 480
    //   156: if_icmple +22 -> 178
    //   159: iload_2
    //   160: iload_3
    //   161: if_icmpgt +26 -> 187
    //   164: iload_2
    //   165: sipush 480
    //   168: if_icmple +10 -> 178
    //   171: iload_3
    //   172: sipush 640
    //   175: if_icmpgt +12 -> 187
    //   178: aload_1
    //   179: iconst_0
    //   180: iload_2
    //   181: iastore
    //   182: aload_1
    //   183: iconst_1
    //   184: iload_3
    //   185: iastore
    //   186: return
    //   187: iload_2
    //   188: iconst_2
    //   189: idiv
    //   190: istore_2
    //   191: iload_3
    //   192: iconst_2
    //   193: idiv
    //   194: istore_3
    //   195: iload 4
    //   197: iconst_1
    //   198: iadd
    //   199: istore 4
    //   201: goto -134 -> 67
    //   204: astore_0
    //   205: goto -77 -> 128
    //   208: astore_0
    //   209: iconst_0
    //   210: istore_2
    //   211: goto -119 -> 92
    //   214: astore_0
    //   215: goto -123 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramString	String
    //   0	218	1	paramArrayOfInt	int[]
    //   34	177	2	i	int
    //   50	145	3	j	int
    //   65	135	4	k	int
    //   11	123	5	localMediaMetadataRetriever1	android.media.MediaMetadataRetriever
    //   7	108	6	localMediaMetadataRetriever2	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   0	9	86	java/lang/Exception
    //   0	9	124	finally
    //   13	19	204	finally
    //   23	35	204	finally
    //   39	51	204	finally
    //   96	109	204	finally
    //   13	19	208	java/lang/Exception
    //   23	35	208	java/lang/Exception
    //   39	51	214	java/lang/Exception
  }
  
  private void e(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    try
    {
      this.rHF.add(Integer.valueOf(paramInt1));
      this.rHG.add(paramString1);
      this.rHH.add(paramString2);
      this.rHI.add(Integer.valueOf(paramInt2));
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:rHE	Ljava/util/List;
    //   4: ifnull +1256 -> 1260
    //   7: aload_0
    //   8: getfield 51	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:rHE	Ljava/util/List;
    //   11: invokeinterface 322 1 0
    //   16: ifle +1244 -> 1260
    //   19: iconst_0
    //   20: istore 6
    //   22: iload 6
    //   24: aload_0
    //   25: getfield 51	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:rHE	Ljava/util/List;
    //   28: invokeinterface 322 1 0
    //   33: if_icmpge +1227 -> 1260
    //   36: aload_0
    //   37: getfield 116	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:isStop	Z
    //   40: ifne +1220 -> 1260
    //   43: ldc 77
    //   45: ldc_w 324
    //   48: iconst_1
    //   49: anewarray 81	java/lang/Object
    //   52: dup
    //   53: iconst_0
    //   54: aload_0
    //   55: getfield 51	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:rHE	Ljava/util/List;
    //   58: invokevirtual 325	java/lang/Object:toString	()Ljava/lang/String;
    //   61: aastore
    //   62: invokestatic 93	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: new 327	android/content/Intent
    //   68: dup
    //   69: invokespecial 328	android/content/Intent:<init>	()V
    //   72: astore 16
    //   74: aload 16
    //   76: new 150	java/lang/StringBuilder
    //   79: dup
    //   80: ldc_w 330
    //   83: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   86: aload_0
    //   87: getfield 51	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:rHE	Ljava/util/List;
    //   90: iload 6
    //   92: invokeinterface 333 2 0
    //   97: checkcast 236	java/lang/String
    //   100: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 342	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   109: invokevirtual 346	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   112: pop
    //   113: invokestatic 352	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   116: astore 17
    //   118: new 150	java/lang/StringBuilder
    //   121: dup
    //   122: ldc_w 354
    //   125: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: astore 12
    //   130: invokestatic 220	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   133: pop
    //   134: aload 12
    //   136: invokestatic 226	com/tencent/mm/model/c:Dz	()Lcom/tencent/mm/storage/z;
    //   139: iconst_2
    //   140: ldc 228
    //   142: invokevirtual 234	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   145: checkcast 236	java/lang/String
    //   148: invokestatic 358	com/tencent/mm/modelvideo/t:nR	(Ljava/lang/String;)Ljava/lang/String;
    //   151: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: astore 13
    //   159: aload_0
    //   160: getfield 70	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:rHL	Ljava/lang/String;
    //   163: invokestatic 138	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   166: ifne +13 -> 179
    //   169: aload_0
    //   170: getfield 68	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:rHM	Ljava/lang/String;
    //   173: invokestatic 138	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   176: ifeq +83 -> 259
    //   179: invokestatic 265	com/tencent/mm/modelvideo/o:Sr	()Lcom/tencent/mm/modelvideo/t;
    //   182: pop
    //   183: aload 13
    //   185: invokestatic 361	com/tencent/mm/modelvideo/t:nT	(Ljava/lang/String;)Ljava/lang/String;
    //   188: astore 15
    //   190: invokestatic 265	com/tencent/mm/modelvideo/o:Sr	()Lcom/tencent/mm/modelvideo/t;
    //   193: pop
    //   194: aload 13
    //   196: invokestatic 364	com/tencent/mm/modelvideo/t:nS	(Ljava/lang/String;)Ljava/lang/String;
    //   199: astore 14
    //   201: invokestatic 352	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   204: invokestatic 370	com/tencent/mm/sdk/platformtools/aq:is2G	(Landroid/content/Context;)Z
    //   207: istore 9
    //   209: aload 17
    //   211: aload 16
    //   213: invokestatic 376	com/tencent/mm/compatible/j/a:g	(Landroid/content/Context;Landroid/content/Intent;)Ljava/lang/String;
    //   216: astore 18
    //   218: aload 18
    //   220: invokestatic 138	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   223: ifeq +79 -> 302
    //   226: ldc 77
    //   228: ldc_w 378
    //   231: invokestatic 380	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: aload_0
    //   235: ldc_w 381
    //   238: aload 13
    //   240: aload 18
    //   242: iconst_0
    //   243: aconst_null
    //   244: aload 17
    //   246: aconst_null
    //   247: invokespecial 383	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   250: iload 6
    //   252: iconst_1
    //   253: iadd
    //   254: istore 6
    //   256: goto -234 -> 22
    //   259: aload_0
    //   260: getfield 70	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:rHL	Ljava/lang/String;
    //   263: astore 15
    //   265: aload_0
    //   266: getfield 68	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:rHM	Ljava/lang/String;
    //   269: aload_0
    //   270: getfield 68	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:rHM	Ljava/lang/String;
    //   273: ldc_w 385
    //   276: invokevirtual 389	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   279: iconst_1
    //   280: iadd
    //   281: aload_0
    //   282: getfield 68	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:rHM	Ljava/lang/String;
    //   285: invokevirtual 392	java/lang/String:length	()I
    //   288: invokevirtual 396	java/lang/String:substring	(II)Ljava/lang/String;
    //   291: astore 13
    //   293: aload_0
    //   294: getfield 68	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:rHM	Ljava/lang/String;
    //   297: astore 14
    //   299: goto -98 -> 201
    //   302: aload 18
    //   304: invokestatic 401	com/tencent/mm/plugin/a/c:pp	(Ljava/lang/String;)Z
    //   307: istore 8
    //   309: aload 18
    //   311: invokestatic 407	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   314: lstore 10
    //   316: iload 8
    //   318: ifeq +556 -> 874
    //   321: new 409	com/tencent/mm/pointers/PInt
    //   324: dup
    //   325: invokespecial 410	com/tencent/mm/pointers/PInt:<init>	()V
    //   328: astore 19
    //   330: invokestatic 416	com/tencent/mm/modelcontrol/d:Nl	()Lcom/tencent/mm/modelcontrol/d;
    //   333: aload 18
    //   335: invokevirtual 419	com/tencent/mm/modelcontrol/d:lQ	(Ljava/lang/String;)Z
    //   338: ifeq +161 -> 499
    //   341: ldc 77
    //   343: ldc_w 421
    //   346: iconst_1
    //   347: anewarray 81	java/lang/Object
    //   350: dup
    //   351: iconst_0
    //   352: aload 18
    //   354: aastore
    //   355: invokestatic 93	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   358: aload 19
    //   360: iconst_1
    //   361: putfield 424	com/tencent/mm/pointers/PInt:value	I
    //   364: aconst_null
    //   365: astore 12
    //   367: aload 19
    //   369: getfield 424	com/tencent/mm/pointers/PInt:value	I
    //   372: istore_3
    //   373: ldc 77
    //   375: ldc_w 426
    //   378: iconst_3
    //   379: anewarray 81	java/lang/Object
    //   382: dup
    //   383: iconst_0
    //   384: iload_3
    //   385: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   388: aastore
    //   389: dup
    //   390: iconst_1
    //   391: iload 8
    //   393: invokestatic 431	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   396: aastore
    //   397: dup
    //   398: iconst_2
    //   399: lload 10
    //   401: invokestatic 436	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   404: aastore
    //   405: invokestatic 93	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   408: iload_3
    //   409: tableswitch	default:+63 -> 472, -6:+612->1021, -5:+630->1039, -4:+612->1021, -3:+612->1021, -2:+612->1021, -1:+593->1002, 0:+585->994, 1:+506->915, 2:+506->915, 3:+506->915, 4:+506->915, 5:+506->915
    //   473: astore_2
    //   474: ldc_w 438
    //   477: invokestatic 380	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: aload_0
    //   481: ldc_w 439
    //   484: aload 13
    //   486: aload 18
    //   488: iconst_0
    //   489: aconst_null
    //   490: aload 17
    //   492: aconst_null
    //   493: invokespecial 383	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   496: goto -246 -> 250
    //   499: new 441	com/tencent/mm/modelcontrol/VideoTransPara
    //   502: dup
    //   503: invokespecial 442	com/tencent/mm/modelcontrol/VideoTransPara:<init>	()V
    //   506: astore 20
    //   508: new 409	com/tencent/mm/pointers/PInt
    //   511: dup
    //   512: invokespecial 410	com/tencent/mm/pointers/PInt:<init>	()V
    //   515: astore 12
    //   517: new 409	com/tencent/mm/pointers/PInt
    //   520: dup
    //   521: invokespecial 410	com/tencent/mm/pointers/PInt:<init>	()V
    //   524: astore 21
    //   526: new 409	com/tencent/mm/pointers/PInt
    //   529: dup
    //   530: invokespecial 410	com/tencent/mm/pointers/PInt:<init>	()V
    //   533: astore 22
    //   535: new 409	com/tencent/mm/pointers/PInt
    //   538: dup
    //   539: invokespecial 410	com/tencent/mm/pointers/PInt:<init>	()V
    //   542: astore 23
    //   544: new 409	com/tencent/mm/pointers/PInt
    //   547: dup
    //   548: invokespecial 410	com/tencent/mm/pointers/PInt:<init>	()V
    //   551: astore 24
    //   553: aload 18
    //   555: aload 12
    //   557: aload 21
    //   559: aload 22
    //   561: aload 23
    //   563: aload 24
    //   565: invokestatic 447	com/tencent/mm/plugin/sight/base/d:a	(Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Ljava/lang/String;
    //   568: pop
    //   569: aload 20
    //   571: aload 12
    //   573: getfield 424	com/tencent/mm/pointers/PInt:value	I
    //   576: sipush 1000
    //   579: idiv
    //   580: putfield 450	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   583: aload 20
    //   585: aload 21
    //   587: getfield 424	com/tencent/mm/pointers/PInt:value	I
    //   590: putfield 453	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   593: aload 20
    //   595: aload 22
    //   597: getfield 424	com/tencent/mm/pointers/PInt:value	I
    //   600: putfield 456	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   603: aload 20
    //   605: aload 23
    //   607: getfield 424	com/tencent/mm/pointers/PInt:value	I
    //   610: putfield 459	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   613: aload 20
    //   615: aload 24
    //   617: getfield 424	com/tencent/mm/pointers/PInt:value	I
    //   620: putfield 462	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   623: ldc 77
    //   625: ldc_w 464
    //   628: iconst_1
    //   629: anewarray 81	java/lang/Object
    //   632: dup
    //   633: iconst_0
    //   634: aload 20
    //   636: aastore
    //   637: invokestatic 466	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   640: invokestatic 416	com/tencent/mm/modelcontrol/d:Nl	()Lcom/tencent/mm/modelcontrol/d;
    //   643: aload 20
    //   645: invokevirtual 469	com/tencent/mm/modelcontrol/d:b	(Lcom/tencent/mm/modelcontrol/VideoTransPara;)Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   648: astore 12
    //   650: aload 12
    //   652: ifnonnull +33 -> 685
    //   655: ldc 77
    //   657: ldc_w 471
    //   660: iconst_1
    //   661: anewarray 81	java/lang/Object
    //   664: dup
    //   665: iconst_0
    //   666: aload 20
    //   668: aastore
    //   669: invokestatic 93	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   672: aload 19
    //   674: bipush 251
    //   676: putfield 424	com/tencent/mm/pointers/PInt:value	I
    //   679: aconst_null
    //   680: astore 12
    //   682: goto -315 -> 367
    //   685: ldc 77
    //   687: ldc_w 473
    //   690: iconst_1
    //   691: anewarray 81	java/lang/Object
    //   694: dup
    //   695: iconst_0
    //   696: aload 12
    //   698: aastore
    //   699: invokestatic 466	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   702: aload 20
    //   704: getfield 462	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   707: ldc_w 474
    //   710: if_icmple +16 -> 726
    //   713: aload 12
    //   715: getfield 462	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   718: aload 20
    //   720: getfield 462	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   723: if_icmple +37 -> 760
    //   726: ldc 77
    //   728: ldc_w 476
    //   731: iconst_2
    //   732: anewarray 81	java/lang/Object
    //   735: dup
    //   736: iconst_0
    //   737: aload 12
    //   739: aastore
    //   740: dup
    //   741: iconst_1
    //   742: aload 20
    //   744: aastore
    //   745: invokestatic 93	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   748: aload 19
    //   750: iconst_1
    //   751: putfield 424	com/tencent/mm/pointers/PInt:value	I
    //   754: aconst_null
    //   755: astore 12
    //   757: goto -390 -> 367
    //   760: aload 20
    //   762: getfield 459	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   765: bipush 45
    //   767: if_icmplt +31 -> 798
    //   770: aload 20
    //   772: getfield 450	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   775: sipush 1000
    //   778: imul
    //   779: ldc_w 477
    //   782: if_icmplt +16 -> 798
    //   785: aload 19
    //   787: bipush 250
    //   789: putfield 424	com/tencent/mm/pointers/PInt:value	I
    //   792: aconst_null
    //   793: astore 12
    //   795: goto -428 -> 367
    //   798: invokestatic 352	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   801: invokestatic 370	com/tencent/mm/sdk/platformtools/aq:is2G	(Landroid/content/Context;)Z
    //   804: istore 9
    //   806: aload 12
    //   808: getfield 453	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   811: istore 4
    //   813: aload 12
    //   815: getfield 456	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   818: istore 5
    //   820: iload 9
    //   822: ifeq +38 -> 860
    //   825: ldc_w 478
    //   828: istore_3
    //   829: iload 9
    //   831: ifeq +36 -> 867
    //   834: ldc2_w 479
    //   837: dstore_1
    //   838: aload 19
    //   840: aload 18
    //   842: iload 4
    //   844: iload 5
    //   846: iload_3
    //   847: dload_1
    //   848: ldc_w 481
    //   851: invokestatic 487	com/tencent/mm/plugin/sight/base/SightVideoJNI:shouldRemuxing	(Ljava/lang/String;IIIDI)I
    //   854: putfield 424	com/tencent/mm/pointers/PInt:value	I
    //   857: goto -490 -> 367
    //   860: ldc_w 488
    //   863: istore_3
    //   864: goto -35 -> 829
    //   867: ldc2_w 489
    //   870: dstore_1
    //   871: goto -33 -> 838
    //   874: iload 9
    //   876: ifeq +24 -> 900
    //   879: ldc_w 478
    //   882: istore_3
    //   883: lload 10
    //   885: iload_3
    //   886: i2l
    //   887: lcmp
    //   888: ifle +19 -> 907
    //   891: bipush 251
    //   893: istore_3
    //   894: aconst_null
    //   895: astore 12
    //   897: goto -524 -> 373
    //   900: ldc_w 488
    //   903: istore_3
    //   904: goto -21 -> 883
    //   907: iconst_1
    //   908: istore_3
    //   909: aconst_null
    //   910: astore 12
    //   912: goto -539 -> 373
    //   915: lload 10
    //   917: ldc2_w 491
    //   920: lcmp
    //   921: ifle +65 -> 986
    //   924: aload_0
    //   925: ldc 98
    //   927: aload 13
    //   929: aload 18
    //   931: iconst_0
    //   932: aconst_null
    //   933: aload 17
    //   935: aconst_null
    //   936: invokespecial 383	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   939: iconst_0
    //   940: istore 4
    //   942: ldc 98
    //   944: istore_3
    //   945: aload 17
    //   947: aload 16
    //   949: invokestatic 496	com/tencent/mm/compatible/j/a:h	(Landroid/content/Context;Landroid/content/Intent;)Lcom/tencent/mm/compatible/j/a$a;
    //   952: astore 16
    //   954: aload 16
    //   956: ifnonnull +122 -> 1078
    //   959: ldc 77
    //   961: ldc_w 378
    //   964: invokestatic 380	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   967: aload_0
    //   968: ldc_w 381
    //   971: aload 13
    //   973: aload 18
    //   975: iconst_0
    //   976: aconst_null
    //   977: aload 17
    //   979: aconst_null
    //   980: invokespecial 383	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   983: goto -733 -> 250
    //   986: iconst_0
    //   987: istore 4
    //   989: iconst_0
    //   990: istore_3
    //   991: goto -46 -> 945
    //   994: iconst_1
    //   995: istore 4
    //   997: iconst_0
    //   998: istore_3
    //   999: goto -54 -> 945
    //   1002: aload_0
    //   1003: ldc_w 497
    //   1006: aload 13
    //   1008: aload 18
    //   1010: iconst_0
    //   1011: aconst_null
    //   1012: aload 17
    //   1014: aconst_null
    //   1015: invokespecial 383	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1018: goto -768 -> 250
    //   1021: aload_0
    //   1022: ldc 98
    //   1024: aload 13
    //   1026: aload 18
    //   1028: iconst_0
    //   1029: aconst_null
    //   1030: aload 17
    //   1032: aconst_null
    //   1033: invokespecial 383	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1036: goto -786 -> 250
    //   1039: aload_0
    //   1040: ldc 128
    //   1042: aload 13
    //   1044: aload 18
    //   1046: iconst_0
    //   1047: aconst_null
    //   1048: aload 17
    //   1050: aconst_null
    //   1051: invokespecial 383	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1054: goto -804 -> 250
    //   1057: astore 16
    //   1059: ldc 77
    //   1061: aload 16
    //   1063: ldc 228
    //   1065: iconst_0
    //   1066: anewarray 81	java/lang/Object
    //   1069: invokestatic 305	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1072: aconst_null
    //   1073: astore 16
    //   1075: goto -121 -> 954
    //   1078: iload 4
    //   1080: ifne +135 -> 1215
    //   1083: aload 18
    //   1085: aload 14
    //   1087: invokestatic 501	com/tencent/mm/vfs/e:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   1090: pop2
    //   1091: aload 16
    //   1093: getfield 504	com/tencent/mm/compatible/j/a$a:duration	I
    //   1096: i2l
    //   1097: invokestatic 508	com/tencent/mm/sdk/platformtools/bk:hv	(J)I
    //   1100: istore 7
    //   1102: aload 16
    //   1104: getfield 512	com/tencent/mm/compatible/j/a$a:bitmap	Landroid/graphics/Bitmap;
    //   1107: ifnull +129 -> 1236
    //   1110: aload 16
    //   1112: getfield 512	com/tencent/mm/compatible/j/a$a:bitmap	Landroid/graphics/Bitmap;
    //   1115: bipush 60
    //   1117: getstatic 518	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1120: aload 15
    //   1122: iconst_1
    //   1123: invokestatic 523	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   1126: iconst_0
    //   1127: istore 5
    //   1129: iload 5
    //   1131: ifeq +26 -> 1157
    //   1134: ldc_w 524
    //   1137: sipush 320
    //   1140: sipush 480
    //   1143: invokestatic 528	com/tencent/mm/sdk/platformtools/c:ah	(III)Landroid/graphics/Bitmap;
    //   1146: bipush 60
    //   1148: getstatic 518	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1151: aload 15
    //   1153: iconst_1
    //   1154: invokestatic 523	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   1157: iload_3
    //   1158: istore 5
    //   1160: iload 4
    //   1162: ifne +19 -> 1181
    //   1165: iload_3
    //   1166: istore 5
    //   1168: aload 14
    //   1170: invokestatic 531	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   1173: ifne +8 -> 1181
    //   1176: ldc_w 532
    //   1179: istore 5
    //   1181: aload 15
    //   1183: invokestatic 531	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   1186: ifne +8 -> 1194
    //   1189: ldc_w 533
    //   1192: istore 5
    //   1194: aload_0
    //   1195: iload 5
    //   1197: aload 13
    //   1199: aload 18
    //   1201: iload 7
    //   1203: aload 12
    //   1205: aload 17
    //   1207: aload 15
    //   1209: invokespecial 383	com/tencent/mm/plugin/wenote/model/nativenote/manager/d:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1212: goto -962 -> 250
    //   1215: ldc 132
    //   1217: istore_3
    //   1218: goto -127 -> 1091
    //   1221: astore 16
    //   1223: ldc 77
    //   1225: aload 16
    //   1227: ldc 228
    //   1229: iconst_0
    //   1230: anewarray 81	java/lang/Object
    //   1233: invokestatic 305	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1236: iconst_1
    //   1237: istore 5
    //   1239: goto -110 -> 1129
    //   1242: astore 16
    //   1244: ldc 77
    //   1246: aload 16
    //   1248: ldc 228
    //   1250: iconst_0
    //   1251: anewarray 81	java/lang/Object
    //   1254: invokestatic 305	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1257: goto -100 -> 1157
    //   1260: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1261	0	this	d
    //   837	34	1	d	double
    //   372	846	3	i	int
    //   811	350	4	j	int
    //   818	420	5	k	int
    //   20	235	6	m	int
    //   1100	102	7	n	int
    //   307	85	8	bool1	boolean
    //   207	668	9	bool2	boolean
    //   314	602	10	l	long
    //   128	1076	12	localObject1	Object
    //   157	1041	13	str1	String
    //   199	970	14	str2	String
    //   188	1020	15	str3	String
    //   72	883	16	localObject2	Object
    //   1057	5	16	localException1	java.lang.Exception
    //   1073	38	16	localObject3	Object
    //   1221	5	16	localException2	java.lang.Exception
    //   1242	5	16	localException3	java.lang.Exception
    //   116	1090	17	localContext	Context
    //   216	984	18	str4	String
    //   328	511	19	localPInt1	com.tencent.mm.pointers.PInt
    //   506	265	20	localVideoTransPara	VideoTransPara
    //   524	62	21	localPInt2	com.tencent.mm.pointers.PInt
    //   533	63	22	localPInt3	com.tencent.mm.pointers.PInt
    //   542	64	23	localPInt4	com.tencent.mm.pointers.PInt
    //   551	65	24	localPInt5	com.tencent.mm.pointers.PInt
    // Exception table:
    //   from	to	target	type
    //   945	954	1057	java/lang/Exception
    //   1110	1126	1221	java/lang/Exception
    //   1134	1157	1242	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.d
 * JD-Core Version:    0.7.0.1
 */