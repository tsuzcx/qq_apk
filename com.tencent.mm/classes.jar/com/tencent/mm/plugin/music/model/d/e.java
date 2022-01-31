package com.tencent.mm.plugin.music.model.d;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class e
{
  public static long fqZ;
  public static boolean pap;
  public static boolean paq;
  public static int par;
  public static int pas;
  private static com.tencent.mm.plugin.music.model.e.a pat;
  public static int scene;
  
  public static final void Ar(int paramInt)
  {
    AppMethodBeat.i(105016);
    if (paramInt == 2)
    {
      com.tencent.mm.aw.e locale = com.tencent.mm.aw.a.aiz();
      if (locale != null) {
        com.tencent.mm.plugin.fav.a.h.i(bo.getLong(locale.fKH, 0L), 1, 0);
      }
    }
    AppMethodBeat.o(105016);
  }
  
  public static final void As(int paramInt)
  {
    AppMethodBeat.i(105017);
    if (paramInt == 2)
    {
      com.tencent.mm.aw.e locale = com.tencent.mm.aw.a.aiz();
      if (locale != null) {
        com.tencent.mm.plugin.fav.a.h.i(bo.getLong(locale.fKH, 0L), 0, 0);
      }
    }
    AppMethodBeat.o(105017);
  }
  
  public static final void At(int paramInt)
  {
    AppMethodBeat.i(105018);
    com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.e.e.class)).bVw();
    if (locala != null)
    {
      ab.i("MicroMsg.Music.MusicReportUtil", "ReportMusicPlayerShareStat ShareType:%d, MusicId:%s, MusicTitle:%s, Singer:%s, AppId:%s", new Object[] { Integer.valueOf(paramInt), locala.field_musicId, locala.field_songName, locala.field_songSinger, locala.field_appId });
      com.tencent.mm.plugin.report.service.h.qsU.e(12836, new Object[] { Integer.valueOf(paramInt), locala.field_musicId, locala.field_songName, locala.field_songSinger, locala.field_appId });
    }
    AppMethodBeat.o(105018);
  }
  
  private static void Au(int paramInt)
  {
    AppMethodBeat.i(151918);
    ab.i("MicroMsg.Music.MusicReportUtil", "idKeyReportExoMusicPlayerSum scene:%d", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(797);
    localIDKey1.SetKey(0);
    localIDKey1.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(797);
    localIDKey2.SetKey(b.Am(paramInt));
    localIDKey2.SetValue(1L);
    localArrayList.add(localIDKey1);
    localArrayList.add(localIDKey2);
    com.tencent.mm.plugin.report.service.h.qsU.b(localArrayList, true);
    AppMethodBeat.o(151918);
  }
  
  public static final void KP()
  {
    AppMethodBeat.i(105014);
    if (fqZ > 0L)
    {
      pas = (int)(pas + (System.currentTimeMillis() - fqZ) / 1000L);
      fqZ = 0L;
    }
    AppMethodBeat.o(105014);
  }
  
  public static void a(int paramInt, com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(105019);
    if (parama == null)
    {
      ab.e("MicroMsg.Music.MusicReportUtil", "kvReportMusicNotificationStat music is null, err");
      AppMethodBeat.o(105019);
      return;
    }
    ab.i("MicroMsg.Music.MusicReportUtil", "kvReportMusicNotificationStat scene:%d, action:%d, src:%s, title:%s, singer:%s", new Object[] { Integer.valueOf(parama.field_musicType), Integer.valueOf(paramInt), parama.field_songWifiUrl, parama.field_songName, parama.field_songSinger });
    com.tencent.mm.plugin.report.service.h.qsU.e(15106, new Object[] { Integer.valueOf(parama.field_musicType), Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()), parama.field_songWifiUrl, parama.field_songName, parama.field_songSinger });
    AppMethodBeat.o(105019);
  }
  
  public static void a(com.tencent.mm.aw.e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(151917);
    if (parame == null)
    {
      ab.e("MicroMsg.Music.MusicReportUtil", "idKeyReportMusicPlayerSum music is null");
      AppMethodBeat.o(151917);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(558);
    localIDKey1.SetKey(0);
    localIDKey1.SetValue(1L);
    IDKey localIDKey3 = new IDKey();
    localIDKey3.SetID(558);
    localIDKey3.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(558);
    localIDKey2.SetValue(1L);
    if (paramBoolean) {
      localIDKey2.SetKey(10);
    }
    for (;;)
    {
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      com.tencent.mm.plugin.report.service.h.qsU.b(localArrayList, true);
      AppMethodBeat.o(151917);
      return;
      if (com.tencent.mm.plugin.music.h.c.M(parame))
      {
        Au(parame.fKh);
        AppMethodBeat.o(151917);
        return;
      }
      if (com.tencent.mm.plugin.music.h.c.Az(parame.fKh))
      {
        localIDKey2.SetKey(2);
        localIDKey3.SetKey(c.Aq(parame.fKh));
        localArrayList.add(localIDKey3);
        com.tencent.mm.plugin.report.service.h.qsU.e(14174, new Object[] { Integer.valueOf(1), Integer.valueOf(parame.fKh) });
        if (com.tencent.mm.plugin.music.model.a.b.Vx(parame.playUrl))
        {
          parame = new IDKey();
          parame.SetID(558);
          parame.SetKey(216);
          parame.SetValue(1L);
          localArrayList.add(parame);
        }
      }
      else
      {
        localIDKey2.SetKey(1);
        localIDKey3.SetKey(c.Ap(parame.fKh));
        localArrayList.add(localIDKey3);
        com.tencent.mm.plugin.report.service.h.qsU.e(14174, new Object[] { Integer.valueOf(0), Integer.valueOf(parame.fKh) });
        if (com.tencent.mm.plugin.music.model.a.b.Vx(parame.playUrl))
        {
          parame = new IDKey();
          parame.SetID(558);
          parame.SetKey(215);
          parame.SetValue(1L);
          localArrayList.add(parame);
        }
      }
    }
  }
  
  public static final void ac(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(105011);
    com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.e.e.class)).bVw();
    if (locala != null)
    {
      ab.v("MicroMsg.Music.MusicReportUtil", "kvReportShakeReport: %d, %d, %d, %s, %s, %s, %s, %d %s, %s", new Object[] { Integer.valueOf(13042), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), locala.field_musicId, locala.field_songName, locala.field_songAlbum, Integer.valueOf(locala.field_songId), Integer.valueOf(paramInt3), locala.field_songSinger, locala.field_appId });
      com.tencent.mm.plugin.report.service.h.qsU.e(13042, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), locala.field_musicId, locala.field_songName, locala.field_songAlbum, Integer.valueOf(locala.field_songId), Integer.valueOf(paramInt3), locala.field_songSinger, locala.field_appId });
    }
    AppMethodBeat.o(105011);
  }
  
  /* Error */
  public static final void bVU()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 229
    //   7: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: getstatic 231	com/tencent/mm/plugin/music/model/d/e:pat	Lcom/tencent/mm/plugin/music/model/e/a;
    //   13: ifnull +328 -> 341
    //   16: invokestatic 233	com/tencent/mm/plugin/music/model/d/e:KP	()V
    //   19: getstatic 231	com/tencent/mm/plugin/music/model/d/e:pat	Lcom/tencent/mm/plugin/music/model/e/a;
    //   22: getfield 81	com/tencent/mm/plugin/music/model/e/a:field_musicId	Ljava/lang/String;
    //   25: astore 6
    //   27: getstatic 231	com/tencent/mm/plugin/music/model/d/e:pat	Lcom/tencent/mm/plugin/music/model/e/a;
    //   30: getfield 84	com/tencent/mm/plugin/music/model/e/a:field_songName	Ljava/lang/String;
    //   33: astore 7
    //   35: getstatic 231	com/tencent/mm/plugin/music/model/d/e:pat	Lcom/tencent/mm/plugin/music/model/e/a;
    //   38: getfield 221	com/tencent/mm/plugin/music/model/e/a:field_songAlbum	Ljava/lang/String;
    //   41: astore 8
    //   43: getstatic 231	com/tencent/mm/plugin/music/model/d/e:pat	Lcom/tencent/mm/plugin/music/model/e/a;
    //   46: getfield 224	com/tencent/mm/plugin/music/model/e/a:field_songId	I
    //   49: istore_3
    //   50: getstatic 235	com/tencent/mm/plugin/music/model/d/e:par	I
    //   53: istore 4
    //   55: getstatic 148	com/tencent/mm/plugin/music/model/d/e:pas	I
    //   58: istore 5
    //   60: getstatic 237	com/tencent/mm/plugin/music/model/d/e:pap	Z
    //   63: ifeq +315 -> 378
    //   66: iconst_1
    //   67: istore_0
    //   68: getstatic 239	com/tencent/mm/plugin/music/model/d/e:paq	Z
    //   71: ifeq +312 -> 383
    //   74: iconst_1
    //   75: istore_1
    //   76: ldc 68
    //   78: ldc 241
    //   80: bipush 12
    //   82: anewarray 4	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: sipush 13044
    //   90: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   93: aastore
    //   94: dup
    //   95: iconst_1
    //   96: aload 6
    //   98: aastore
    //   99: dup
    //   100: iconst_2
    //   101: aload 7
    //   103: aastore
    //   104: dup
    //   105: iconst_3
    //   106: aload 8
    //   108: aastore
    //   109: dup
    //   110: iconst_4
    //   111: iload_3
    //   112: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: aastore
    //   116: dup
    //   117: iconst_5
    //   118: iload 4
    //   120: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   123: aastore
    //   124: dup
    //   125: bipush 6
    //   127: iload 5
    //   129: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   132: aastore
    //   133: dup
    //   134: bipush 7
    //   136: iload_0
    //   137: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: aastore
    //   141: dup
    //   142: bipush 8
    //   144: iload_1
    //   145: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: aastore
    //   149: dup
    //   150: bipush 9
    //   152: getstatic 243	com/tencent/mm/plugin/music/model/d/e:scene	I
    //   155: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   158: aastore
    //   159: dup
    //   160: bipush 10
    //   162: getstatic 231	com/tencent/mm/plugin/music/model/d/e:pat	Lcom/tencent/mm/plugin/music/model/e/a;
    //   165: getfield 87	com/tencent/mm/plugin/music/model/e/a:field_songSinger	Ljava/lang/String;
    //   168: aastore
    //   169: dup
    //   170: bipush 11
    //   172: getstatic 231	com/tencent/mm/plugin/music/model/d/e:pat	Lcom/tencent/mm/plugin/music/model/e/a;
    //   175: getfield 90	com/tencent/mm/plugin/music/model/e/a:field_appId	Ljava/lang/String;
    //   178: aastore
    //   179: invokestatic 227	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: getstatic 101	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   185: astore 6
    //   187: getstatic 231	com/tencent/mm/plugin/music/model/d/e:pat	Lcom/tencent/mm/plugin/music/model/e/a;
    //   190: getfield 81	com/tencent/mm/plugin/music/model/e/a:field_musicId	Ljava/lang/String;
    //   193: astore 7
    //   195: getstatic 231	com/tencent/mm/plugin/music/model/d/e:pat	Lcom/tencent/mm/plugin/music/model/e/a;
    //   198: getfield 84	com/tencent/mm/plugin/music/model/e/a:field_songName	Ljava/lang/String;
    //   201: astore 8
    //   203: getstatic 231	com/tencent/mm/plugin/music/model/d/e:pat	Lcom/tencent/mm/plugin/music/model/e/a;
    //   206: getfield 221	com/tencent/mm/plugin/music/model/e/a:field_songAlbum	Ljava/lang/String;
    //   209: astore 9
    //   211: getstatic 231	com/tencent/mm/plugin/music/model/d/e:pat	Lcom/tencent/mm/plugin/music/model/e/a;
    //   214: getfield 224	com/tencent/mm/plugin/music/model/e/a:field_songId	I
    //   217: istore_3
    //   218: getstatic 235	com/tencent/mm/plugin/music/model/d/e:par	I
    //   221: istore 4
    //   223: getstatic 148	com/tencent/mm/plugin/music/model/d/e:pas	I
    //   226: istore 5
    //   228: getstatic 237	com/tencent/mm/plugin/music/model/d/e:pap	Z
    //   231: ifeq +157 -> 388
    //   234: iconst_1
    //   235: istore_0
    //   236: getstatic 239	com/tencent/mm/plugin/music/model/d/e:paq	Z
    //   239: ifeq +154 -> 393
    //   242: iload_2
    //   243: istore_1
    //   244: aload 6
    //   246: sipush 13044
    //   249: bipush 11
    //   251: anewarray 4	java/lang/Object
    //   254: dup
    //   255: iconst_0
    //   256: aload 7
    //   258: aastore
    //   259: dup
    //   260: iconst_1
    //   261: aload 8
    //   263: aastore
    //   264: dup
    //   265: iconst_2
    //   266: aload 9
    //   268: aastore
    //   269: dup
    //   270: iconst_3
    //   271: iload_3
    //   272: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   275: aastore
    //   276: dup
    //   277: iconst_4
    //   278: iload 4
    //   280: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: aastore
    //   284: dup
    //   285: iconst_5
    //   286: iload 5
    //   288: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   291: aastore
    //   292: dup
    //   293: bipush 6
    //   295: iload_0
    //   296: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   299: aastore
    //   300: dup
    //   301: bipush 7
    //   303: iload_1
    //   304: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   307: aastore
    //   308: dup
    //   309: bipush 8
    //   311: getstatic 243	com/tencent/mm/plugin/music/model/d/e:scene	I
    //   314: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   317: aastore
    //   318: dup
    //   319: bipush 9
    //   321: getstatic 231	com/tencent/mm/plugin/music/model/d/e:pat	Lcom/tencent/mm/plugin/music/model/e/a;
    //   324: getfield 87	com/tencent/mm/plugin/music/model/e/a:field_songSinger	Ljava/lang/String;
    //   327: aastore
    //   328: dup
    //   329: bipush 10
    //   331: getstatic 231	com/tencent/mm/plugin/music/model/d/e:pat	Lcom/tencent/mm/plugin/music/model/e/a;
    //   334: getfield 90	com/tencent/mm/plugin/music/model/e/a:field_appId	Ljava/lang/String;
    //   337: aastore
    //   338: invokevirtual 105	com/tencent/mm/plugin/report/service/h:e	(I[Ljava/lang/Object;)V
    //   341: aconst_null
    //   342: putstatic 231	com/tencent/mm/plugin/music/model/d/e:pat	Lcom/tencent/mm/plugin/music/model/e/a;
    //   345: iconst_0
    //   346: putstatic 237	com/tencent/mm/plugin/music/model/d/e:pap	Z
    //   349: iconst_0
    //   350: putstatic 239	com/tencent/mm/plugin/music/model/d/e:paq	Z
    //   353: iconst_0
    //   354: putstatic 235	com/tencent/mm/plugin/music/model/d/e:par	I
    //   357: iconst_0
    //   358: putstatic 148	com/tencent/mm/plugin/music/model/d/e:pas	I
    //   361: lconst_0
    //   362: putstatic 146	com/tencent/mm/plugin/music/model/d/e:fqZ	J
    //   365: iconst_0
    //   366: putstatic 243	com/tencent/mm/plugin/music/model/d/e:scene	I
    //   369: ldc 229
    //   371: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   374: ldc 2
    //   376: monitorexit
    //   377: return
    //   378: iconst_2
    //   379: istore_0
    //   380: goto -312 -> 68
    //   383: iconst_2
    //   384: istore_1
    //   385: goto -309 -> 76
    //   388: iconst_2
    //   389: istore_0
    //   390: goto -154 -> 236
    //   393: iconst_2
    //   394: istore_1
    //   395: goto -151 -> 244
    //   398: astore 6
    //   400: ldc 2
    //   402: monitorexit
    //   403: aload 6
    //   405: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   67	323	0	i	int
    //   75	320	1	j	int
    //   1	242	2	k	int
    //   49	223	3	m	int
    //   53	226	4	n	int
    //   58	229	5	i1	int
    //   25	220	6	localObject1	Object
    //   398	6	6	localObject2	Object
    //   33	224	7	str1	java.lang.String
    //   41	221	8	str2	java.lang.String
    //   209	58	9	str3	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   5	66	398	finally
    //   68	74	398	finally
    //   76	234	398	finally
    //   236	242	398	finally
    //   244	341	398	finally
    //   341	374	398	finally
  }
  
  public static final void bVV()
  {
    AppMethodBeat.i(105015);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(285L, 4L, 1L, false);
    AppMethodBeat.o(105015);
  }
  
  public static final void eS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105012);
    com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.e.e.class)).bVw();
    if (locala != null)
    {
      ab.v("MicroMsg.Music.MusicReportUtil", "kvReportAction: %d, %s, %s, %s, %s, %d, %d, %s, %s", new Object[] { Integer.valueOf(13232), locala.field_musicId, locala.field_songName, locala.field_songAlbum, Integer.valueOf(locala.field_songId), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), locala.field_songSinger, locala.field_appId });
      com.tencent.mm.plugin.report.service.h.qsU.e(13232, new Object[] { locala.field_musicId, locala.field_songName, locala.field_songAlbum, Integer.valueOf(locala.field_songId), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), locala.field_songSinger, locala.field_appId });
    }
    AppMethodBeat.o(105012);
  }
  
  public static void f(com.tencent.mm.plugin.music.model.e.a parama)
  {
    try
    {
      pat = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d.e
 * JD-Core Version:    0.7.0.1
 */