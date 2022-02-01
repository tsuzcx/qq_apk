package com.tencent.mm.plugin.music.model.d;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;

public final class e
{
  public static long hOz;
  public static int scene;
  public static int vFP;
  public static boolean wBp;
  public static boolean wBq;
  public static int wBr;
  private static com.tencent.mm.plugin.music.model.e.a wBs;
  
  public static final void Ma(int paramInt)
  {
    AppMethodBeat.i(63149);
    if (paramInt == 2)
    {
      f localf = com.tencent.mm.ay.a.aKc();
      if (localf != null) {
        h.i(bu.getLong(localf.ikx, 0L), 1, 0);
      }
    }
    AppMethodBeat.o(63149);
  }
  
  public static final void Mb(int paramInt)
  {
    AppMethodBeat.i(63150);
    if (paramInt == 2)
    {
      f localf = com.tencent.mm.ay.a.aKc();
      if (localf != null) {
        h.i(bu.getLong(localf.ikx, 0L), 0, 0);
      }
    }
    AppMethodBeat.o(63150);
  }
  
  public static final void Mc(int paramInt)
  {
    AppMethodBeat.i(63151);
    com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dwe();
    if (locala != null)
    {
      ae.i("MicroMsg.Music.MusicReportUtil", "ReportMusicPlayerShareStat ShareType:%d, MusicId:%s, MusicTitle:%s, Singer:%s, AppId:%s", new Object[] { Integer.valueOf(paramInt), locala.field_musicId, locala.field_songName, locala.field_songSinger, locala.field_appId });
      g.yxI.f(12836, new Object[] { Integer.valueOf(paramInt), locala.field_musicId, locala.field_songName, locala.field_songSinger, locala.field_appId });
    }
    AppMethodBeat.o(63151);
  }
  
  private static void Md(int paramInt)
  {
    AppMethodBeat.i(63154);
    ae.i("MicroMsg.Music.MusicReportUtil", "idKeyReportExoMusicPlayerSum scene:%d", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(797);
    localIDKey1.SetKey(0);
    localIDKey1.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(797);
    localIDKey2.SetKey(b.LV(paramInt));
    localIDKey2.SetValue(1L);
    localArrayList.add(localIDKey1);
    localArrayList.add(localIDKey2);
    g.yxI.b(localArrayList, true);
    AppMethodBeat.o(63154);
  }
  
  public static void a(int paramInt, com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63152);
    if (parama == null)
    {
      ae.e("MicroMsg.Music.MusicReportUtil", "kvReportMusicNotificationStat music is null, err");
      AppMethodBeat.o(63152);
      return;
    }
    ae.i("MicroMsg.Music.MusicReportUtil", "kvReportMusicNotificationStat scene:%d, action:%d, src:%s, title:%s, singer:%s", new Object[] { Integer.valueOf(parama.field_musicType), Integer.valueOf(paramInt), parama.field_songWifiUrl, parama.field_songName, parama.field_songSinger });
    g.yxI.f(15106, new Object[] { Integer.valueOf(parama.field_musicType), Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()), parama.field_songWifiUrl, parama.field_songName, parama.field_songSinger });
    AppMethodBeat.o(63152);
  }
  
  public static void a(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(63153);
    if (paramf == null)
    {
      ae.e("MicroMsg.Music.MusicReportUtil", "idKeyReportMusicPlayerSum music is null");
      AppMethodBeat.o(63153);
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
      g.yxI.b(localArrayList, true);
      AppMethodBeat.o(63153);
      return;
      if (com.tencent.mm.plugin.music.h.c.Q(paramf))
      {
        Md(paramf.ijX);
        AppMethodBeat.o(63153);
        return;
      }
      if (com.tencent.mm.plugin.music.h.c.Mi(paramf.ijX))
      {
        localIDKey2.SetKey(2);
        localIDKey3.SetKey(c.LZ(paramf.ijX));
        localArrayList.add(localIDKey3);
        g.yxI.f(14174, new Object[] { Integer.valueOf(1), Integer.valueOf(paramf.ijX) });
        if (com.tencent.mm.plugin.music.model.a.b.atR(paramf.playUrl))
        {
          paramf = new IDKey();
          paramf.SetID(558);
          paramf.SetKey(216);
          paramf.SetValue(1L);
          localArrayList.add(paramf);
        }
      }
      else
      {
        localIDKey2.SetKey(1);
        localIDKey3.SetKey(c.LY(paramf.ijX));
        localArrayList.add(localIDKey3);
        g.yxI.f(14174, new Object[] { Integer.valueOf(0), Integer.valueOf(paramf.ijX) });
        if (com.tencent.mm.plugin.music.model.a.b.atR(paramf.playUrl))
        {
          paramf = new IDKey();
          paramf.SetID(558);
          paramf.SetKey(215);
          paramf.SetValue(1L);
          localArrayList.add(paramf);
        }
      }
    }
  }
  
  public static final void aJV()
  {
    AppMethodBeat.i(63147);
    if (hOz > 0L)
    {
      vFP = (int)(vFP + (System.currentTimeMillis() - hOz) / 1000L);
      hOz = 0L;
    }
    AppMethodBeat.o(63147);
  }
  
  public static final void an(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(63144);
    com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dwe();
    if (locala != null)
    {
      ae.v("MicroMsg.Music.MusicReportUtil", "kvReportShakeReport: %d, %d, %d, %s, %s, %s, %s, %d %s, %s", new Object[] { Integer.valueOf(13042), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), locala.field_musicId, locala.field_songName, locala.field_songAlbum, Integer.valueOf(locala.field_songId), Integer.valueOf(paramInt3), locala.field_songSinger, locala.field_appId });
      g.yxI.f(13042, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), locala.field_musicId, locala.field_songName, locala.field_songAlbum, Integer.valueOf(locala.field_songId), Integer.valueOf(paramInt3), locala.field_songSinger, locala.field_appId });
    }
    AppMethodBeat.o(63144);
  }
  
  /* Error */
  public static final void dwC()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 230
    //   7: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: getstatic 232	com/tencent/mm/plugin/music/model/d/e:wBs	Lcom/tencent/mm/plugin/music/model/e/a;
    //   13: ifnull +328 -> 341
    //   16: invokestatic 234	com/tencent/mm/plugin/music/model/d/e:aJV	()V
    //   19: getstatic 232	com/tencent/mm/plugin/music/model/d/e:wBs	Lcom/tencent/mm/plugin/music/model/e/a;
    //   22: getfield 81	com/tencent/mm/plugin/music/model/e/a:field_musicId	Ljava/lang/String;
    //   25: astore 6
    //   27: getstatic 232	com/tencent/mm/plugin/music/model/d/e:wBs	Lcom/tencent/mm/plugin/music/model/e/a;
    //   30: getfield 84	com/tencent/mm/plugin/music/model/e/a:field_songName	Ljava/lang/String;
    //   33: astore 7
    //   35: getstatic 232	com/tencent/mm/plugin/music/model/d/e:wBs	Lcom/tencent/mm/plugin/music/model/e/a;
    //   38: getfield 222	com/tencent/mm/plugin/music/model/e/a:field_songAlbum	Ljava/lang/String;
    //   41: astore 8
    //   43: getstatic 232	com/tencent/mm/plugin/music/model/d/e:wBs	Lcom/tencent/mm/plugin/music/model/e/a;
    //   46: getfield 225	com/tencent/mm/plugin/music/model/e/a:field_songId	I
    //   49: istore_3
    //   50: getstatic 236	com/tencent/mm/plugin/music/model/d/e:wBr	I
    //   53: istore 4
    //   55: getstatic 212	com/tencent/mm/plugin/music/model/d/e:vFP	I
    //   58: istore 5
    //   60: getstatic 238	com/tencent/mm/plugin/music/model/d/e:wBp	Z
    //   63: ifeq +315 -> 378
    //   66: iconst_1
    //   67: istore_0
    //   68: getstatic 240	com/tencent/mm/plugin/music/model/d/e:wBq	Z
    //   71: ifeq +312 -> 383
    //   74: iconst_1
    //   75: istore_1
    //   76: ldc 68
    //   78: ldc 242
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
    //   152: getstatic 244	com/tencent/mm/plugin/music/model/d/e:scene	I
    //   155: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   158: aastore
    //   159: dup
    //   160: bipush 10
    //   162: getstatic 232	com/tencent/mm/plugin/music/model/d/e:wBs	Lcom/tencent/mm/plugin/music/model/e/a;
    //   165: getfield 87	com/tencent/mm/plugin/music/model/e/a:field_songSinger	Ljava/lang/String;
    //   168: aastore
    //   169: dup
    //   170: bipush 11
    //   172: getstatic 232	com/tencent/mm/plugin/music/model/d/e:wBs	Lcom/tencent/mm/plugin/music/model/e/a;
    //   175: getfield 90	com/tencent/mm/plugin/music/model/e/a:field_appId	Ljava/lang/String;
    //   178: aastore
    //   179: invokestatic 228	com/tencent/mm/sdk/platformtools/ae:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: getstatic 101	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   185: astore 6
    //   187: getstatic 232	com/tencent/mm/plugin/music/model/d/e:wBs	Lcom/tencent/mm/plugin/music/model/e/a;
    //   190: getfield 81	com/tencent/mm/plugin/music/model/e/a:field_musicId	Ljava/lang/String;
    //   193: astore 7
    //   195: getstatic 232	com/tencent/mm/plugin/music/model/d/e:wBs	Lcom/tencent/mm/plugin/music/model/e/a;
    //   198: getfield 84	com/tencent/mm/plugin/music/model/e/a:field_songName	Ljava/lang/String;
    //   201: astore 8
    //   203: getstatic 232	com/tencent/mm/plugin/music/model/d/e:wBs	Lcom/tencent/mm/plugin/music/model/e/a;
    //   206: getfield 222	com/tencent/mm/plugin/music/model/e/a:field_songAlbum	Ljava/lang/String;
    //   209: astore 9
    //   211: getstatic 232	com/tencent/mm/plugin/music/model/d/e:wBs	Lcom/tencent/mm/plugin/music/model/e/a;
    //   214: getfield 225	com/tencent/mm/plugin/music/model/e/a:field_songId	I
    //   217: istore_3
    //   218: getstatic 236	com/tencent/mm/plugin/music/model/d/e:wBr	I
    //   221: istore 4
    //   223: getstatic 212	com/tencent/mm/plugin/music/model/d/e:vFP	I
    //   226: istore 5
    //   228: getstatic 238	com/tencent/mm/plugin/music/model/d/e:wBp	Z
    //   231: ifeq +157 -> 388
    //   234: iconst_1
    //   235: istore_0
    //   236: getstatic 240	com/tencent/mm/plugin/music/model/d/e:wBq	Z
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
    //   311: getstatic 244	com/tencent/mm/plugin/music/model/d/e:scene	I
    //   314: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   317: aastore
    //   318: dup
    //   319: bipush 9
    //   321: getstatic 232	com/tencent/mm/plugin/music/model/d/e:wBs	Lcom/tencent/mm/plugin/music/model/e/a;
    //   324: getfield 87	com/tencent/mm/plugin/music/model/e/a:field_songSinger	Ljava/lang/String;
    //   327: aastore
    //   328: dup
    //   329: bipush 10
    //   331: getstatic 232	com/tencent/mm/plugin/music/model/d/e:wBs	Lcom/tencent/mm/plugin/music/model/e/a;
    //   334: getfield 90	com/tencent/mm/plugin/music/model/e/a:field_appId	Ljava/lang/String;
    //   337: aastore
    //   338: invokevirtual 105	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   341: aconst_null
    //   342: putstatic 232	com/tencent/mm/plugin/music/model/d/e:wBs	Lcom/tencent/mm/plugin/music/model/e/a;
    //   345: iconst_0
    //   346: putstatic 238	com/tencent/mm/plugin/music/model/d/e:wBp	Z
    //   349: iconst_0
    //   350: putstatic 240	com/tencent/mm/plugin/music/model/d/e:wBq	Z
    //   353: iconst_0
    //   354: putstatic 236	com/tencent/mm/plugin/music/model/d/e:wBr	I
    //   357: iconst_0
    //   358: putstatic 212	com/tencent/mm/plugin/music/model/d/e:vFP	I
    //   361: lconst_0
    //   362: putstatic 210	com/tencent/mm/plugin/music/model/d/e:hOz	J
    //   365: iconst_0
    //   366: putstatic 244	com/tencent/mm/plugin/music/model/d/e:scene	I
    //   369: ldc 230
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
  
  public static final void dwD()
  {
    AppMethodBeat.i(63148);
    g.yxI.idkeyStat(285L, 4L, 1L, false);
    AppMethodBeat.o(63148);
  }
  
  public static void f(com.tencent.mm.plugin.music.model.e.a parama)
  {
    try
    {
      wBs = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static final void gO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(63145);
    com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dwe();
    if (locala != null)
    {
      ae.v("MicroMsg.Music.MusicReportUtil", "kvReportAction: %d, %s, %s, %s, %s, %d, %d, %s, %s", new Object[] { Integer.valueOf(13232), locala.field_musicId, locala.field_songName, locala.field_songAlbum, Integer.valueOf(locala.field_songId), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), locala.field_songSinger, locala.field_appId });
      g.yxI.f(13232, new Object[] { locala.field_musicId, locala.field_songName, locala.field_songAlbum, Integer.valueOf(locala.field_songId), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), locala.field_songSinger, locala.field_appId });
    }
    AppMethodBeat.o(63145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d.e
 * JD-Core Version:    0.7.0.1
 */