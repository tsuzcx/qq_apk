package com.tencent.mm.vfs;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.a.a;
import com.tencent.mm.vfs.a.a.a;
import com.tencent.mm.vfs.a.c;
import com.tencent.mm.vfs.a.c.a;
import com.tencent.mm.vfs.a.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public final class b
{
  private static final String[] agvT;
  private static final String[] agvU;
  private static final String[] agvV;
  private static final String[] agvW;
  private static final String[] agvX;
  private static final String[] agvY;
  private static final Set<String> agvZ;
  private static final Pattern agwa;
  
  static
  {
    AppMethodBeat.i(238442);
    agvT = new String[] { "avatar", "emoji", "xlog", "xlogPrivate" };
    agvU = new String[] { "ext-cache", "data-root", "null", "camera-path-remapfs", "storage-root", "data-cache", "ext-mm", "accPathMigration", "Download", "attachment", "image2", "record", "tinker", "video", "voice2", "xlogPrivate" };
    agvV = new String[] { "avatar" };
    agvW = new String[] { "shared_prefs/XWALKINFOS.xml" };
    agvX = new String[] { "#mmkv_ringtone_manager", "#mmkv_ringtone_params", "mmkv_ringtone_info" };
    agvY = new String[] { "cache/org.chromium.xwalk", "cache/org.chromium.android_webview", "cache/com.tencent.mm.xweb" };
    agvZ = new HashSet();
    agwa = Pattern.compile("^[0-9a-f]{32}$");
    AppMethodBeat.o(238442);
  }
  
  public static Iterable<j> NO(boolean paramBoolean)
  {
    AppMethodBeat.i(238424);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = jKe();
    Map localMap = k.kMs().kMx();
    Object localObject3 = new HashSet(k.kMs().kMw().jKz().keySet());
    ((Set)localObject3).removeAll(g.jKn());
    ((Set)localObject3).removeAll(Arrays.asList(agvU));
    if (paramBoolean) {
      ((Set)localObject3).removeAll(Arrays.asList(agvV));
    }
    HashSet localHashSet = new HashSet(g.jKn());
    localHashSet.removeAll(Arrays.asList(agvU));
    if (paramBoolean) {
      localHashSet.removeAll(Arrays.asList(agvV));
    }
    Object localObject1 = agvW;
    FileSystem.b localb = new NativeFileSystem("${data}").cO(localMap);
    localArrayList.add(new a(Arrays.asList((Object[])localObject1), new a.a()
    {
      final j[] agwg;
      final List<j> agwh;
    }));
    localObject1 = new NativeFileSystem("${data}/files/mmkv").cO(localMap).bDW("");
    if (localObject1 == null) {}
    for (localObject1 = Collections.emptyList();; localObject1 = new c((Iterable)localObject1, new c.a() {}))
    {
      localArrayList.add(localObject1);
      localObject1 = g.jKi();
      localArrayList.add(a(new String[] { "${sdFrom}/MicroMsg", "${sdTo}/MicroMsg", "${sdToCache}" }, (Set)localObject1, localMap));
      localObject1 = new HashSet(g.jKl());
      ((Set)localObject1).addAll(Arrays.asList(new String[] { ".auth_cache", "shared_prefs", "wc_tinker_dir", "cert" }));
      localArrayList.add(a(new String[] { "", "${dataCache}", "" }, (Set)localObject1, localMap));
      localObject1 = new HashSet(g.jKm());
      ((Set)localObject1).addAll(Arrays.asList(new String[] { "public", "mmkv", "kvcomm" }));
      localArrayList.add(a(new String[] { "" }, (Set)localObject1, localMap));
      localArrayList.add(a((Set)localObject3, localMap));
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Pair)((Iterator)localObject1).next();
        localObject2 = new HashMap(localMap);
        ((Map)localObject2).put("account", ((Pair)localObject3).first);
        ((Map)localObject2).put("accountSalt", ((Pair)localObject3).second);
        ((Map)localObject2).put("accountSd", ((Pair)localObject3).second);
        localObject3 = new HashSet(g.jKj());
        ((Set)localObject3).add("corrupted");
        localArrayList.add(a(new String[] { "${sdFrom}/MicroMsg/${account}", "${sdTo}/MicroMsg/${account}", "${sdToCache}/${account}", "${sdFrom}/MicroMsg/${accountSalt}", "${sdTo}/MicroMsg/${accountSalt}", "${sdToCache}/${accountSalt}" }, (Set)localObject3, (Map)localObject2));
        localObject3 = g.jKk();
        localArrayList.add(a(new String[] { "", "${dataCache}/${account}" }, (Set)localObject3, (Map)localObject2));
        localArrayList.add(a(localHashSet, (Map)localObject2));
        localArrayList.add(al("${data}/MicroMsg/${account}", (Map)localObject2));
        localArrayList.add(al("${data}/MicroMsg/${account}/corrupted", (Map)localObject2));
      }
    }
    localObject1 = new c(new e(localArrayList), new c.a()
    {
      private final HashMap<String, j> agwb;
      private long uWn;
    });
    AppMethodBeat.o(238424);
    return localObject1;
  }
  
  private static Iterable<j> a(Set<String> paramSet, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(238407);
    paramSet = new a(paramSet, new a.a() {});
    AppMethodBeat.o(238407);
    return paramSet;
  }
  
  private static Iterable<j> a(String[] paramArrayOfString, Set<String> paramSet, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(238399);
    paramMap = new a.a() {};
    paramSet = new c.a() {};
    a.a local8 = new a.a() {};
    paramArrayOfString = new a(new c(new a(Arrays.asList(paramArrayOfString), paramMap), paramSet), local8);
    AppMethodBeat.o(238399);
    return paramArrayOfString;
  }
  
  private static Iterable<j> al(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(238411);
    paramString = new NativeFileSystem(paramString).cO(paramMap).bDW("");
    if (paramString == null)
    {
      paramString = Collections.emptyList();
      AppMethodBeat.o(238411);
      return paramString;
    }
    paramString = new c(paramString, new c.a() {});
    AppMethodBeat.o(238411);
    return paramString;
  }
  
  static void bEa(String paramString)
  {
    AppMethodBeat.i(238372);
    if (Arrays.binarySearch(agvT, paramString) >= 0)
    {
      AppMethodBeat.o(238372);
      return;
    }
    synchronized (agvZ)
    {
      agvZ.add(paramString);
      AppMethodBeat.o(238372);
      return;
    }
  }
  
  public static Iterable<j> jKd()
  {
    AppMethodBeat.i(238382);
    for (;;)
    {
      synchronized (agvZ)
      {
        Object localObject2 = new HashSet(agvZ);
        localObject2 = new a((Iterable)localObject2, new a.a() {});
        ??? = k.kMs().kMw().bEh("data-root");
        FileSystem.b localb = new NativeFileSystem("${sdToCache}").cO(k.kMs().kMx());
        a locala = new a(Arrays.asList(agvY), new a.a() {});
        if (??? == null)
        {
          ??? = null;
          ??? = new c(new e(new Iterable[] { localObject2, locala, ???, localb.bDW("") }), new c.a()
          {
            final long tick;
          });
          AppMethodBeat.o(238382);
          return ???;
        }
      }
      ??? = ((FileSystem.b)???).bDW("cache");
    }
  }
  
  /* Error */
  static List<Pair<String, String>> jKe()
  {
    // Byte code:
    //   0: ldc_w 407
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 193	com/tencent/mm/vfs/NativeFileSystem
    //   9: dup
    //   10: ldc_w 409
    //   13: invokespecial 198	com/tencent/mm/vfs/NativeFileSystem:<init>	(Ljava/lang/String;)V
    //   16: invokestatic 152	com/tencent/mm/vfs/k:kMs	()Lcom/tencent/mm/vfs/k;
    //   19: invokevirtual 156	com/tencent/mm/vfs/k:kMx	()Ljava/util/Map;
    //   22: invokevirtual 202	com/tencent/mm/vfs/NativeFileSystem:cO	(Ljava/util/Map;)Lcom/tencent/mm/vfs/FileSystem$b;
    //   25: astore 5
    //   27: aload 5
    //   29: ldc 220
    //   31: invokeinterface 226 2 0
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: ifnonnull +7 -> 47
    //   43: invokestatic 231	java/util/Collections:emptyList	()Ljava/util/List;
    //   46: astore_2
    //   47: new 141	java/util/ArrayList
    //   50: dup
    //   51: invokespecial 142	java/util/ArrayList:<init>	()V
    //   54: astore 6
    //   56: aload_2
    //   57: invokeinterface 410 1 0
    //   62: astore 7
    //   64: aload 7
    //   66: invokeinterface 288 1 0
    //   71: ifeq +219 -> 290
    //   74: aload 7
    //   76: invokeinterface 292 1 0
    //   81: checkcast 412	com/tencent/mm/vfs/j
    //   84: astore_2
    //   85: aload_2
    //   86: getfield 416	com/tencent/mm/vfs/j:agxh	Z
    //   89: ifeq -25 -> 64
    //   92: getstatic 132	com/tencent/mm/vfs/b:agwa	Ljava/util/regex/Pattern;
    //   95: aload_2
    //   96: getfield 420	com/tencent/mm/vfs/j:name	Ljava/lang/String;
    //   99: invokevirtual 424	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   102: invokevirtual 429	java/util/regex/Matcher:matches	()Z
    //   105: ifeq -41 -> 64
    //   108: aload_2
    //   109: getfield 420	com/tencent/mm/vfs/j:name	Ljava/lang/String;
    //   112: astore_3
    //   113: aload 5
    //   115: new 431	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 432	java/lang/StringBuilder:<init>	()V
    //   122: aload_2
    //   123: getfield 435	com/tencent/mm/vfs/j:acpB	Ljava/lang/String;
    //   126: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc_w 441
    //   132: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokeinterface 449 2 0
    //   143: astore 8
    //   145: bipush 20
    //   147: newarray byte
    //   149: astore_2
    //   150: iconst_0
    //   151: istore_0
    //   152: iload_0
    //   153: bipush 20
    //   155: if_icmpge +27 -> 182
    //   158: aload 8
    //   160: aload_2
    //   161: iload_0
    //   162: bipush 20
    //   164: iload_0
    //   165: isub
    //   166: invokevirtual 455	java/io/InputStream:read	([BII)I
    //   169: istore_1
    //   170: iload_1
    //   171: iconst_m1
    //   172: if_icmpeq +10 -> 182
    //   175: iload_1
    //   176: iload_0
    //   177: iadd
    //   178: istore_0
    //   179: goto -27 -> 152
    //   182: new 51	java/lang/String
    //   185: dup
    //   186: aload_2
    //   187: iconst_0
    //   188: iload_0
    //   189: invokespecial 458	java/lang/String:<init>	([BII)V
    //   192: astore 4
    //   194: aload 4
    //   196: astore_2
    //   197: aload 8
    //   199: ifnull +11 -> 210
    //   202: aload 8
    //   204: invokevirtual 461	java/io/InputStream:close	()V
    //   207: aload 4
    //   209: astore_2
    //   210: aload 6
    //   212: new 294	android/util/Pair
    //   215: dup
    //   216: aload_3
    //   217: aload_2
    //   218: invokespecial 464	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   221: invokeinterface 216 2 0
    //   226: pop
    //   227: goto -163 -> 64
    //   230: astore_2
    //   231: aload 8
    //   233: ifnull +8 -> 241
    //   236: aload 8
    //   238: invokevirtual 461	java/io/InputStream:close	()V
    //   241: ldc_w 407
    //   244: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: aload_2
    //   248: athrow
    //   249: astore_2
    //   250: ldc_w 466
    //   253: ldc_w 468
    //   256: iconst_2
    //   257: anewarray 4	java/lang/Object
    //   260: dup
    //   261: iconst_0
    //   262: aload_3
    //   263: aastore
    //   264: dup
    //   265: iconst_1
    //   266: aload_2
    //   267: invokevirtual 471	java/io/IOException:getMessage	()Ljava/lang/String;
    //   270: aastore
    //   271: invokestatic 477	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: aload_3
    //   275: astore_2
    //   276: goto -66 -> 210
    //   279: astore 4
    //   281: aload_2
    //   282: aload 4
    //   284: invokevirtual 483	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   287: goto -46 -> 241
    //   290: ldc_w 407
    //   293: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: aload 6
    //   298: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   151	38	0	i	int
    //   169	9	1	j	int
    //   38	180	2	localObject1	Object
    //   230	18	2	localObject2	Object
    //   249	18	2	localIOException	java.io.IOException
    //   275	7	2	localObject3	Object
    //   36	239	3	localObject4	Object
    //   192	16	4	str	String
    //   279	4	4	localThrowable	java.lang.Throwable
    //   25	89	5	localb	FileSystem.b
    //   54	243	6	localArrayList	ArrayList
    //   62	13	7	localIterator	Iterator
    //   143	94	8	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   145	150	230	finally
    //   158	170	230	finally
    //   182	194	230	finally
    //   113	145	249	java/io/IOException
    //   202	207	249	java/io/IOException
    //   241	249	249	java/io/IOException
    //   281	287	249	java/io/IOException
    //   236	241	279	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.b
 * JD-Core Version:    0.7.0.1
 */