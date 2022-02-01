package com.tencent.xweb.xwalk.updater;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.WebViewKind;
import com.tencent.xweb.aa;
import com.tencent.xweb.ao;
import com.tencent.xweb.b.b.a;
import com.tencent.xweb.h.a;
import com.tencent.xweb.h.c;
import com.tencent.xweb.internal.d;
import com.tencent.xweb.util.g;
import com.tencent.xweb.util.l;
import com.tencent.xweb.util.m;
import com.tencent.xweb.xwalk.a.i;
import com.tencent.xweb.xwalk.a.i.a;
import java.io.File;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkDecompressor;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkFileUtil;
import org.xwalk.core.XWalkSharedPreferenceUtil;
import org.xwalk.core.XWalkUpdateConfigUtil;

public final class f
{
  private static volatile boolean aiqP = false;
  
  public static void Pg(boolean paramBoolean)
  {
    boolean bool1 = true;
    AppMethodBeat.i(213076);
    int j = XWalkEnvironment.getAvailableVersion();
    if ((j <= 0) || (XWalkEnvironment.isTestVersion(j)))
    {
      Log.i("XWalkCleaner", "checkFiles, invalid available version, version:".concat(String.valueOf(j)));
      AppMethodBeat.o(213076);
      return;
    }
    SharedPreferences localSharedPreferences = XWalkSharedPreferenceUtil.getSharedPreferencesForUpdateConfig();
    if (localSharedPreferences == null)
    {
      Log.i("XWalkCleaner", "checkFiles, invalid shared preferences");
      AppMethodBeat.o(213076);
      return;
    }
    if ((!paramBoolean) && (!d.cH("CHECK_FILES_MD5_TIME_KEY", 7200000L)))
    {
      Log.i("XWalkCleaner", "checkFiles, skip check");
      AppMethodBeat.o(213076);
      return;
    }
    com.tencent.xweb.b.a.reset();
    Log.i("XWalkCleaner", "checkFiles, start check res files, version:".concat(String.valueOf(j)));
    Object localObject = XWalkFileUtil.getDownloadResFileListConfig(j);
    File localFile = new File((String)localObject);
    int i;
    if (!localFile.exists()) {
      if ((XWalkEnvironment.isTestVersion(j)) || (j < 362))
      {
        i = 1;
        if (i == 0) {
          break label391;
        }
        Log.w("XWalkCleaner", "doCheckResFiles, resConfigFile not exist, maybe test runtime or old runtime, path:".concat(String.valueOf(localObject)));
        paramBoolean = true;
        label172:
        if (!paramBoolean)
        {
          i = localSharedPreferences.getInt("LAST_CHECK_RES_VERSION", -1);
          localSharedPreferences.edit().putInt("LAST_CHECK_RES_VERSION", -1).commit();
          if (i == j) {
            break label457;
          }
          l.Br(77L);
          Log.i("XWalkCleaner", "checkFiles, some res files corrupted at first time");
          label226:
          l.Br(76L);
        }
        Log.i("XWalkCleaner", "checkFiles, start check installed files, version:".concat(String.valueOf(j)));
        localObject = aJT(j);
        if (localObject != null) {
          break label513;
        }
        if (!XWalkEnvironment.isTestVersion(j)) {
          break label467;
        }
        Log.w("XWalkCleaner", "doCheckFiles, configFile not exist, maybe test runtime or old runtime");
        label271:
        if (!bool1)
        {
          i = localSharedPreferences.getInt("LAST_CHECK_VERSION", -1);
          localSharedPreferences.edit().putInt("LAST_CHECK_VERSION", -1).commit();
          if (i == j) {
            break label523;
          }
          l.Br(64L);
          Log.i("XWalkCleaner", "checkFiles, some installed files corrupted at first time");
          label325:
          l.Br(63L);
        }
        if ("true".equalsIgnoreCase(com.tencent.xweb.a.keX().qM("disable_res_check", "tools"))) {
          break label533;
        }
      }
    }
    for (boolean bool2 = bool1 & paramBoolean;; bool2 = bool1)
    {
      if (bool2) {
        break label546;
      }
      com.tencent.xweb.b.a.bW(paramBoolean, bool1);
      Log.e("XWalkCleaner", "checkFiles, check failed");
      XWalkEnvironment.setCoreVersionInfo(-1, null, com.tencent.xweb.util.b.khw());
      AppMethodBeat.o(213076);
      return;
      i = 0;
      break;
      label391:
      l.Br(79L);
      Log.i("XWalkCleaner", "doCheckResFiles, resConfigFile not exist, path:".concat(String.valueOf(localObject)));
      if ("true".equalsIgnoreCase(com.tencent.xweb.a.keX().qM("dis_res_config_file_check", "tools")))
      {
        Log.w("XWalkCleaner", "doCheckResFiles, resConfigFile not exist and dis_res_config_file_check");
        paramBoolean = true;
        break label172;
      }
      paramBoolean = false;
      break label172;
      paramBoolean = com.tencent.xweb.xwalk.b.a.b(j, localFile);
      break label172;
      label457:
      Log.i("XWalkCleaner", "checkFiles, some res files corrupted");
      break label226;
      label467:
      Log.w("XWalkCleaner", "doCheckFiles, no config file");
      l.Br(78L);
      if ("true".equalsIgnoreCase(com.tencent.xweb.a.keX().qM("dis_config_file_check", "tools")))
      {
        Log.i("XWalkCleaner", "doCheckFiles, dis_config_file_check is true");
        break label271;
      }
      bool1 = false;
      break label271;
      label513:
      bool1 = com.tencent.xweb.xwalk.b.a.a(j, (File)localObject);
      break label271;
      label523:
      Log.i("XWalkCleaner", "checkFiles, some installed files corrupted");
      break label325;
      label533:
      Log.i("XWalkCleaner", "checkFiles, ignore res files check");
    }
    label546:
    localSharedPreferences.edit().putInt("LAST_CHECK_VERSION", j).commit();
    Log.i("XWalkCleaner", "checkFiles success");
    AppMethodBeat.o(213076);
  }
  
  /* Error */
  public static void Z(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 227
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iload_1
    //   6: ifne +14 -> 20
    //   9: ldc 229
    //   11: ldc2_w 230
    //   14: invokestatic 72	com/tencent/xweb/internal/d:cH	(Ljava/lang/String;J)Z
    //   17: ifeq +681 -> 698
    //   20: aload_0
    //   21: ifnull +20 -> 41
    //   24: aload_0
    //   25: invokevirtual 237	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   28: ifnull +13 -> 41
    //   31: aload_0
    //   32: invokevirtual 237	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   35: getfield 243	android/content/pm/ApplicationInfo:dataDir	Ljava/lang/String;
    //   38: ifnonnull +16 -> 54
    //   41: ldc 34
    //   43: ldc 245
    //   45: invokestatic 182	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: ldc 227
    //   50: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: return
    //   54: new 88	java/io/File
    //   57: dup
    //   58: aload_0
    //   59: invokevirtual 237	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   62: getfield 243	android/content/pm/ApplicationInfo:dataDir	Ljava/lang/String;
    //   65: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual 96	java/io/File:exists	()Z
    //   73: ifne +37 -> 110
    //   76: ldc 34
    //   78: ldc 247
    //   80: invokestatic 182	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: ldc 227
    //   85: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: return
    //   89: astore_0
    //   90: ldc 34
    //   92: ldc 249
    //   94: aload_0
    //   95: invokestatic 101	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   98: invokevirtual 46	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   101: invokestatic 182	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: ldc 227
    //   106: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: return
    //   110: aload_0
    //   111: invokevirtual 253	java/io/File:listFiles	()[Ljava/io/File;
    //   114: astore_0
    //   115: aload_0
    //   116: ifnonnull +16 -> 132
    //   119: ldc 34
    //   121: ldc 255
    //   123: invokestatic 182	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: ldc 227
    //   128: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: return
    //   132: invokestatic 161	com/tencent/xweb/a:keX	()Lcom/tencent/xweb/a;
    //   135: ldc_w 257
    //   138: ldc 165
    //   140: invokevirtual 169	com/tencent/xweb/a:qM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   143: astore 10
    //   145: ldc 34
    //   147: ldc_w 259
    //   150: aload 10
    //   152: invokestatic 101	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   155: invokevirtual 46	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   158: invokestatic 51	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: new 261	java/util/HashSet
    //   164: dup
    //   165: invokespecial 263	java/util/HashSet:<init>	()V
    //   168: astore 9
    //   170: aload 10
    //   172: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   175: ifne +68 -> 243
    //   178: aload 10
    //   180: ldc_w 271
    //   183: invokevirtual 275	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   186: astore 10
    //   188: aload 10
    //   190: ifnull +53 -> 243
    //   193: aload 10
    //   195: arraylength
    //   196: istore_3
    //   197: iconst_0
    //   198: istore_2
    //   199: iload_2
    //   200: iload_3
    //   201: if_icmpge +42 -> 243
    //   204: aload 10
    //   206: iload_2
    //   207: aaload
    //   208: astore 11
    //   210: aload 11
    //   212: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   215: ifne +500 -> 715
    //   218: aload 11
    //   220: invokevirtual 278	java/lang/String:trim	()Ljava/lang/String;
    //   223: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   226: ifne +489 -> 715
    //   229: aload 9
    //   231: aload 11
    //   233: invokevirtual 278	java/lang/String:trim	()Ljava/lang/String;
    //   236: invokevirtual 282	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   239: pop
    //   240: goto +475 -> 715
    //   243: iconst_0
    //   244: istore_2
    //   245: invokestatic 285	org/xwalk/core/XWalkEnvironment:getInstalledNewstVersionForCurAbi	()I
    //   248: istore 5
    //   250: aload_0
    //   251: arraylength
    //   252: istore 6
    //   254: iconst_0
    //   255: istore_3
    //   256: iload_3
    //   257: iload 6
    //   259: if_icmpge +35 -> 294
    //   262: aload_0
    //   263: iload_3
    //   264: aaload
    //   265: invokestatic 289	com/tencent/xweb/xwalk/updater/f:al	(Ljava/io/File;)I
    //   268: istore 4
    //   270: iload 4
    //   272: iflt +440 -> 712
    //   275: iload 4
    //   277: iload 5
    //   279: if_icmpeq +433 -> 712
    //   282: iload 4
    //   284: iload_2
    //   285: if_icmplt +427 -> 712
    //   288: iload 4
    //   290: istore_2
    //   291: goto +431 -> 722
    //   294: ldc_w 291
    //   297: invokestatic 295	org/xwalk/core/XWalkEnvironment:getInstalledNewstVersion	(Ljava/lang/String;)I
    //   300: istore 6
    //   302: ldc_w 297
    //   305: invokestatic 295	org/xwalk/core/XWalkEnvironment:getInstalledNewstVersion	(Ljava/lang/String;)I
    //   308: istore 7
    //   310: ldc 34
    //   312: new 299	java/lang/StringBuilder
    //   315: dup
    //   316: ldc_w 301
    //   319: invokespecial 302	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   322: iload 5
    //   324: invokevirtual 306	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: ldc_w 308
    //   330: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: iload_2
    //   334: invokevirtual 306	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   337: ldc_w 313
    //   340: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: iload 6
    //   345: invokevirtual 306	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   348: ldc_w 315
    //   351: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: iload 7
    //   356: invokevirtual 306	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   359: invokevirtual 318	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 51	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: aload_0
    //   366: arraylength
    //   367: istore 5
    //   369: iconst_0
    //   370: istore_3
    //   371: iload_3
    //   372: iload 5
    //   374: if_icmpge +318 -> 692
    //   377: aload_0
    //   378: iload_3
    //   379: aaload
    //   380: astore 10
    //   382: aload 10
    //   384: invokestatic 289	com/tencent/xweb/xwalk/updater/f:al	(Ljava/io/File;)I
    //   387: istore 8
    //   389: iload 8
    //   391: ifge +32 -> 423
    //   394: ldc 34
    //   396: new 299	java/lang/StringBuilder
    //   399: dup
    //   400: ldc_w 320
    //   403: invokespecial 302	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   406: aload 10
    //   408: invokevirtual 323	java/io/File:getName	()Ljava/lang/String;
    //   411: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 318	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 51	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   420: goto +309 -> 729
    //   423: aload 9
    //   425: iload 8
    //   427: invokestatic 42	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   430: invokevirtual 326	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   433: ifeq +22 -> 455
    //   436: ldc 34
    //   438: ldc_w 328
    //   441: iload 8
    //   443: invokestatic 42	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   446: invokevirtual 46	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   449: invokestatic 51	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   452: goto +277 -> 729
    //   455: iload 8
    //   457: ifle +279 -> 736
    //   460: iload 8
    //   462: iload_2
    //   463: if_icmpge +273 -> 736
    //   466: invokestatic 28	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   469: istore 4
    //   471: iload 8
    //   473: iload 4
    //   475: if_icmpeq +261 -> 736
    //   478: iload 8
    //   480: iload 6
    //   482: if_icmpeq +254 -> 736
    //   485: iload 8
    //   487: iload 7
    //   489: if_icmpeq +247 -> 736
    //   492: iconst_1
    //   493: istore 4
    //   495: iload 4
    //   497: ifeq +72 -> 569
    //   500: aload 10
    //   502: invokevirtual 331	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   505: invokestatic 336	com/tencent/xweb/util/g:bHZ	(Ljava/lang/String;)Z
    //   508: pop
    //   509: ldc 34
    //   511: ldc_w 338
    //   514: iload 8
    //   516: invokestatic 42	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   519: invokevirtual 46	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   522: invokestatic 51	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: ldc2_w 339
    //   528: ldc2_w 341
    //   531: lconst_1
    //   532: invokestatic 346	com/tencent/xweb/util/l:y	(JJJ)V
    //   535: goto +194 -> 729
    //   538: astore 10
    //   540: ldc 34
    //   542: ldc_w 348
    //   545: aload 10
    //   547: invokestatic 101	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   550: invokevirtual 46	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   553: invokestatic 51	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   556: ldc2_w 339
    //   559: ldc2_w 349
    //   562: lconst_1
    //   563: invokestatic 346	com/tencent/xweb/util/l:y	(JJJ)V
    //   566: goto +163 -> 729
    //   569: ldc 34
    //   571: ldc_w 352
    //   574: iload 8
    //   576: invokestatic 42	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   579: invokevirtual 46	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   582: invokestatic 51	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   585: ldc 34
    //   587: ldc_w 354
    //   590: iload 8
    //   592: invokestatic 42	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   595: invokevirtual 46	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   598: invokestatic 51	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   601: new 88	java/io/File
    //   604: dup
    //   605: iload 8
    //   607: invokestatic 357	org/xwalk/core/XWalkFileUtil:getVersionDir	(I)Ljava/lang/String;
    //   610: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   613: astore 10
    //   615: aload 10
    //   617: invokevirtual 96	java/io/File:exists	()Z
    //   620: ifeq +11 -> 631
    //   623: aload 10
    //   625: invokevirtual 360	java/io/File:isDirectory	()Z
    //   628: ifne +14 -> 642
    //   631: ldc 34
    //   633: ldc_w 362
    //   636: invokestatic 104	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   639: goto +90 -> 729
    //   642: new 88	java/io/File
    //   645: dup
    //   646: aload 10
    //   648: ldc_w 364
    //   651: invokespecial 367	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   654: astore 10
    //   656: aload 10
    //   658: invokevirtual 96	java/io/File:exists	()Z
    //   661: ifeq +68 -> 729
    //   664: aload 10
    //   666: invokevirtual 360	java/io/File:isDirectory	()Z
    //   669: ifeq +60 -> 729
    //   672: ldc 34
    //   674: ldc_w 369
    //   677: invokestatic 51	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   680: aload 10
    //   682: invokevirtual 331	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   685: invokestatic 336	com/tencent/xweb/util/g:bHZ	(Ljava/lang/String;)Z
    //   688: pop
    //   689: goto +40 -> 729
    //   692: ldc 227
    //   694: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   697: return
    //   698: ldc 34
    //   700: ldc_w 371
    //   703: invokestatic 51	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   706: ldc 227
    //   708: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   711: return
    //   712: goto +10 -> 722
    //   715: iload_2
    //   716: iconst_1
    //   717: iadd
    //   718: istore_2
    //   719: goto -520 -> 199
    //   722: iload_3
    //   723: iconst_1
    //   724: iadd
    //   725: istore_3
    //   726: goto -470 -> 256
    //   729: iload_3
    //   730: iconst_1
    //   731: iadd
    //   732: istore_3
    //   733: goto -362 -> 371
    //   736: iconst_0
    //   737: istore 4
    //   739: goto -244 -> 495
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	742	0	paramContext	Context
    //   0	742	1	paramBoolean	boolean
    //   198	521	2	i	int
    //   196	537	3	j	int
    //   268	470	4	k	int
    //   248	127	5	m	int
    //   252	231	6	n	int
    //   308	182	7	i1	int
    //   387	219	8	i2	int
    //   168	256	9	localHashSet	java.util.HashSet
    //   143	358	10	localObject1	Object
    //   538	8	10	localObject2	Object
    //   613	68	10	localFile	File
    //   208	24	11	localCharSequence	java.lang.CharSequence
    // Exception table:
    //   from	to	target	type
    //   24	41	89	finally
    //   41	53	89	finally
    //   54	88	89	finally
    //   110	115	89	finally
    //   119	131	89	finally
    //   132	188	89	finally
    //   193	197	89	finally
    //   210	240	89	finally
    //   245	254	89	finally
    //   262	270	89	finally
    //   294	369	89	finally
    //   382	389	89	finally
    //   394	420	89	finally
    //   423	452	89	finally
    //   466	471	89	finally
    //   540	566	89	finally
    //   569	631	89	finally
    //   631	639	89	finally
    //   642	689	89	finally
    //   500	535	538	finally
  }
  
  public static boolean aJS(int paramInt)
  {
    AppMethodBeat.i(213149);
    Log.i("XWalkCleaner", "clearVersion start, version:".concat(String.valueOf(paramInt)));
    if (paramInt <= 0)
    {
      Log.e("XWalkCleaner", "clearVersion failed, version is not valid");
      AppMethodBeat.o(213149);
      return false;
    }
    Object localObject = XWalkEnvironment.getApplicationContext();
    if ((localObject == null) || (((Context)localObject).getApplicationInfo() == null) || (((Context)localObject).getApplicationInfo().dataDir == null))
    {
      Log.e("XWalkCleaner", "clearVersion failed, context is null");
      AppMethodBeat.o(213149);
      return false;
    }
    localObject = new File(((Context)localObject).getApplicationInfo().dataDir);
    if (!((File)localObject).exists())
    {
      Log.e("XWalkCleaner", "clearVersion failed, dataDir not exist");
      AppMethodBeat.o(213149);
      return false;
    }
    localObject = ((File)localObject).listFiles();
    if (localObject == null)
    {
      Log.e("XWalkCleaner", "clearVersion failed, files is null");
      AppMethodBeat.o(213149);
      return false;
    }
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      File localFile = localObject[i];
      int k = al(localFile);
      if ((k > 0) && (k == paramInt) && (g.bHZ(localFile.getAbsolutePath())))
      {
        Log.i("XWalkCleaner", "clearVersion, version:".concat(String.valueOf(k)));
        AppMethodBeat.o(213149);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(213149);
    return false;
  }
  
  public static File aJT(int paramInt)
  {
    AppMethodBeat.i(213153);
    try
    {
      String str = XWalkFileUtil.getPatchFileListConfig(paramInt);
      File localFile = new File(str);
      if (localFile.exists()) {
        return localFile;
      }
      str = XWalkFileUtil.getDownloadZipFileListConfig(paramInt);
      localFile = new File(str);
      if (localFile.exists()) {
        return localFile;
      }
      AppMethodBeat.o(213153);
      return null;
    }
    finally
    {
      Log.e("XWalkCleaner", "getFileListConfigFile error:".concat(String.valueOf(localObject)));
      AppMethodBeat.o(213153);
    }
    return null;
  }
  
  public static int al(File paramFile)
  {
    AppMethodBeat.i(213159);
    if (paramFile == null)
    {
      AppMethodBeat.o(213159);
      return -1;
    }
    String str = paramFile.getName();
    if ((str != null) && (str.startsWith("app_xwalk_")) && (paramFile.isDirectory()))
    {
      paramFile = str.substring(10);
      try
      {
        int i = Integer.parseInt(paramFile);
        AppMethodBeat.o(213159);
        return i;
      }
      finally
      {
        Log.e("XWalkCleaner", "getApkVersion error, strApkVer:" + paramFile + ", error:" + localObject);
      }
    }
    AppMethodBeat.o(213159);
    return -1;
  }
  
  private static void bIu(String paramString)
  {
    AppMethodBeat.i(213130);
    paramString = new File(paramString);
    if (!paramString.isDirectory())
    {
      AppMethodBeat.o(213130);
      return;
    }
    paramString = paramString.listFiles();
    if (paramString == null)
    {
      Log.w("XWalkCleaner", "removeOptDexRecursively, files is null");
      AppMethodBeat.o(213130);
      return;
    }
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramString[i];
      if (localObject != null)
      {
        if (!"oat".equalsIgnoreCase(localObject.getName())) {
          break label124;
        }
        g.bHZ(localObject.getAbsolutePath());
        Log.i("XWalkCleaner", "removeOptDexRecursively, remove oat dir:" + localObject.getAbsolutePath());
      }
      for (;;)
      {
        i += 1;
        break;
        label124:
        if (localObject.getName().endsWith(".odex"))
        {
          g.bHZ(localObject.getAbsolutePath());
          Log.i("XWalkCleaner", "removeOptDexRecursively, remove odex file:" + localObject.getAbsolutePath());
        }
        else if (localObject.getName().endsWith(".vdex"))
        {
          g.bHZ(localObject.getAbsolutePath());
          Log.i("XWalkCleaner", "removeOptDexRecursively, remove vdex file:" + localObject.getAbsolutePath());
        }
        else if (localObject.isDirectory())
        {
          bIu(localObject.getAbsolutePath());
        }
      }
    }
    AppMethodBeat.o(213130);
  }
  
  private static void bn(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(213123);
    Log.i("XWalkCleaner", "tryAbandonThisVersion, scene:".concat(String.valueOf(paramString)));
    long l1 = com.tencent.xweb.internal.c.c(paramString, WebView.WebViewKind.aifI).aijV;
    if (!"true".equalsIgnoreCase(com.tencent.xweb.a.keX().qM("enable_reinstall_for_crash_at_".concat(String.valueOf(paramString)), "tools")))
    {
      AppMethodBeat.o(213123);
      return;
    }
    if (l1 >= 15L)
    {
      paramString = "LAST_" + paramString + "_ABANDON_COUNT";
      long l2 = XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForXWEBUpdater().getLong(paramString, 100000L);
      Log.i("XWalkCleaner", "tryAbandonThisVersion, try count:" + l1 + ",  last abandon count:" + l2);
      if (l1 < l2)
      {
        Log.i("XWalkCleaner", "tryAbandonThisVersion, should abandon this version ");
        try
        {
          aJS(XWalkEnvironment.getInstalledNewstVersionForCurAbi());
          XWalkEnvironment.setCoreVersionInfo(-1, null, com.tencent.xweb.util.b.khw());
          XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForXWEBUpdater().edit().putLong(paramString, l1).commit();
          l.Br(paramInt1);
          AppMethodBeat.o(213123);
          return;
        }
        finally
        {
          Log.e("XWalkCleaner", "tryAbandonThisVersion, clear version failed, error:".concat(String.valueOf(paramString)));
          AppMethodBeat.o(213123);
          return;
        }
      }
      if (l1 - 2L > l2)
      {
        Log.i("XWalkCleaner", "tryAbandonThisVersion cant not fix ");
        l.Br(paramInt2);
      }
    }
    AppMethodBeat.o(213123);
  }
  
  public static boolean isBusy()
  {
    AppMethodBeat.i(213036);
    Log.i("XWalkCleaner", "isBusy:" + aiqP);
    boolean bool = aiqP;
    AppMethodBeat.o(213036);
    return bool;
  }
  
  public static void kkd()
  {
    AppMethodBeat.i(213097);
    if (!d.cH("should_try_generate_jar", 172800000L))
    {
      AppMethodBeat.o(213097);
      return;
    }
    m.q(XWalkEnvironment.getInstalledNewstVersionForCurAbi(), XWalkFileUtil.getExtractedCoreDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi()), false);
    AppMethodBeat.o(213097);
  }
  
  public static void kke()
  {
    AppMethodBeat.i(213102);
    if (d.cH("clear_test_settings", 2592000000L))
    {
      Log.i("XWalkCleaner", "tryClearTestSetting");
      try
      {
        aa.kfE().a("tools", WebView.WebViewKind.aifH);
        aa.kfE().a("appbrand", WebView.WebViewKind.aifH);
        aa.kfE().a("support", WebView.WebViewKind.aifH);
        aa.kfE().a("mm", WebView.WebViewKind.aifH);
        aa.kfE().a("toolsmp", WebView.WebViewKind.aifH);
        aa.kfE().b("tools", WebView.WebViewKind.aifH);
        aa.kfE().b("appbrand", WebView.WebViewKind.aifH);
        aa.kfE().b("support", WebView.WebViewKind.aifH);
        aa.kfE().b("mm", WebView.WebViewKind.aifH);
        aa.kfE().b("toolsmp", WebView.WebViewKind.aifH);
        aa.kfE();
        aa.a(com.tencent.xweb.h.aier, h.a.aiet);
        aa.kfE();
        aa.a(com.tencent.xweb.h.aier, h.c.aiey);
        ao.setTestBaseConfigUrl(null);
        XWalkUpdateConfigUtil.setTestPluginConfigUrl("");
        ao.setGrayValueForTest(0);
        AppMethodBeat.o(213102);
        return;
      }
      finally
      {
        Log.e("XWalkCleaner", "tryClearTestSetting error:".concat(String.valueOf(localObject)));
      }
    }
    AppMethodBeat.o(213102);
  }
  
  public static void kkf()
  {
    int j = 1;
    AppMethodBeat.i(213109);
    if (com.tencent.xweb.internal.c.c("LOAD_CORE", WebView.WebViewKind.aifI).aijV >= 6L) {}
    for (int i = 1; i != 0; i = 0)
    {
      l.Br(252L);
      if (!"true".equalsIgnoreCase(com.tencent.xweb.a.keX().qM("enable_check_dex", "tools"))) {
        break;
      }
      i = j;
      if (i != 0) {
        break label146;
      }
      Log.i("XWalkCleaner", "checkNeedFixDex, no need try fix dex");
      AppMethodBeat.o(213109);
      return;
    }
    if (com.tencent.xweb.internal.c.c("CREATE_WEBVIEW", WebView.WebViewKind.aifI).aijV >= 6L) {}
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        l.Br(247L);
        i = j;
        if ("true".equalsIgnoreCase(com.tencent.xweb.a.keX().qM("enable_check_dex_new_web", "tools"))) {
          break;
        }
      }
      i = 0;
      break;
    }
    label146:
    if (!d.cH("check_need_fix_dex", 43200000L))
    {
      Log.i("XWalkCleaner", "checkNeedFixDex, currently no need try fix dex");
      AppMethodBeat.o(213109);
      return;
    }
    kkg();
    if (!kki())
    {
      l.Br(248L);
      aJS(XWalkEnvironment.getInstalledNewstVersionForCurAbi());
      XWalkEnvironment.setCoreVersionInfo(-1, null, com.tencent.xweb.util.b.khw());
    }
    AppMethodBeat.o(213109);
  }
  
  public static void kkg()
  {
    AppMethodBeat.i(213115);
    bn("LOAD_CORE", 243, 244);
    bn("CREATE_WEBVIEW", 245, 246);
    AppMethodBeat.o(213115);
  }
  
  private static boolean kkh()
  {
    AppMethodBeat.i(213127);
    m.q(XWalkEnvironment.getInstalledNewstVersionForCurAbi(), XWalkFileUtil.getExtractedCoreDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi()), true);
    if (!com.tencent.xweb.a.keX().Q("DIS_REMOVE_ODEX_IN_DEX_CRRUPTION", "tools", false)) {
      bIu(XWalkFileUtil.getVersionDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi()));
    }
    if (g.bHZ(XWalkFileUtil.getOptimizedDexDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi())))
    {
      Log.i("XWalkCleaner", "tryRemoveOptDex success");
      AppMethodBeat.o(213127);
      return true;
    }
    Log.i("XWalkCleaner", "tryRemoveOptDex failed");
    AppMethodBeat.o(213127);
    return false;
  }
  
  public static boolean kki()
  {
    AppMethodBeat.i(213137);
    int i = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
    if (i <= 0)
    {
      Log.i("XWalkCleaner", "doFixDex, no xweb currently");
      AppMethodBeat.o(213137);
      return false;
    }
    Log.i("XWalkCleaner", "doFixDex start");
    Object localObject1 = aJT(i);
    if (localObject1 == null)
    {
      Log.e("XWalkCleaner", "doFixDex, no filelist.config");
      AppMethodBeat.o(213137);
      return false;
    }
    if (!com.tencent.xweb.xwalk.b.a.a(i, (File)localObject1))
    {
      Log.e("XWalkCleaner", "doFixDex, checkFileListMd5 failed");
      AppMethodBeat.o(213137);
      return false;
    }
    String str1 = XWalkFileUtil.getExtractedCoreDir(i);
    localObject1 = XWalkFileUtil.getExtractedCoreDir(i) + "_bk";
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = com.tencent.xweb.xwalk.b.a.aJW(i);
    if (localObject2 == null)
    {
      Log.e("XWalkCleaner", "doFixDex, reslist.config not exist");
      AppMethodBeat.o(213137);
      return false;
    }
    if (!XWalkDecompressor.extractResource(XWalkFileUtil.getDownloadApkPath(i), (String)localObject1, (String[])localObject2))
    {
      Log.e("XWalkCleaner", "doFixDex, extract resource failed");
      AppMethodBeat.o(213137);
      return false;
    }
    localObject2 = str1 + File.separator + "classes.dex";
    String str2 = (String)localObject1 + File.separator + "classes.dex";
    str1 = com.tencent.xweb.util.h.getMD5((String)localObject2);
    localObject1 = str1;
    if (TextUtils.isEmpty(str1)) {
      localObject1 = "";
    }
    boolean bool;
    if (!((String)localObject1).equalsIgnoreCase(com.tencent.xweb.util.h.getMD5(str2)))
    {
      i = 1;
      if (i == 0) {
        break label386;
      }
      l.Br(253L);
      Log.i("XWalkCleaner", "doFixDex, dex corrupted");
      if (!g.bHZ((String)localObject2)) {
        break label367;
      }
      if (!g.copyFile(str2, (String)localObject2)) {
        break label348;
      }
      Log.i("XWalkCleaner", "doFixDex, copy dex to replace success");
      bool = true;
      label331:
      kkh();
    }
    for (;;)
    {
      AppMethodBeat.o(213137);
      return bool;
      i = 0;
      break;
      label348:
      l.Br(249L);
      Log.i("XWalkCleaner", "doFixDex, copy dex to replace failed");
      bool = false;
      break label331;
      label367:
      l.Br(250L);
      Log.i("XWalkCleaner", "doFixDex, delete corrupted dex failed");
      bool = false;
      break label331;
      label386:
      if (kkh())
      {
        l.Br(254L);
        Log.i("XWalkCleaner", "doFixDex, try remove opt dex success");
        bool = true;
      }
      else
      {
        Log.i("XWalkCleaner", "doFixDex, try remove opt dex failed");
        l.Br(255L);
        bool = false;
      }
    }
  }
  
  public static void pe(Context paramContext)
  {
    AppMethodBeat.i(213043);
    com.tencent.threadpool.k.c.bq(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213029);
        Log.i("XWalkCleaner", "tryClean start");
        f.Pg(false);
        f.kkf();
        f.Z(f.this, false);
        f.kke();
        f.kkd();
        f.pf(f.this);
        f.aAs();
        Log.i("XWalkCleaner", "tryClean finished");
        AppMethodBeat.o(213029);
      }
    });
    aiqP = true;
    AppMethodBeat.o(213043);
  }
  
  public static void pf(Context paramContext)
  {
    AppMethodBeat.i(213066);
    if (aa.kfE() != null)
    {
      aa.kfE();
      if (aa.kfJ()) {}
    }
    else if (!com.tencent.xweb.a.keX().Q("enable_check_storage", "tools", false))
    {
      Log.i("XWalkCleaner", "checkStorage, disabled by command");
      AppMethodBeat.o(213066);
      return;
    }
    if ((paramContext == null) || (paramContext.getApplicationInfo() == null) || (paramContext.getApplicationInfo().dataDir == null))
    {
      Log.e("XWalkCleaner", "checkStorage failed, context is null");
      AppMethodBeat.o(213066);
      return;
    }
    paramContext = new File(paramContext.getApplicationInfo().dataDir);
    if (!paramContext.exists())
    {
      Log.e("XWalkCleaner", "checkStorage failed, dataDir not exist");
      AppMethodBeat.o(213066);
      return;
    }
    paramContext = paramContext.listFiles();
    if (paramContext == null)
    {
      Log.e("XWalkCleaner", "checkStorage failed, files is null");
      AppMethodBeat.o(213066);
      return;
    }
    com.tencent.xweb.b.b localb = new com.tencent.xweb.b.b();
    long l2 = 0L;
    int k = paramContext.length;
    int i = 0;
    long l3;
    long l1;
    int j;
    label477:
    boolean bool;
    label530:
    label563:
    long l4;
    String str;
    int n;
    if (i < k)
    {
      Object localObject1 = paramContext[i];
      Object localObject2 = ((File)localObject1).getName();
      int m;
      if ((((String)localObject2).startsWith("app_xwalk_")) && (((File)localObject1).isDirectory()))
      {
        l3 = g.b((File)localObject1, false);
        l1 = l2;
        if (l3 > 0L)
        {
          l2 += l3;
          Log.i("XWalkCleaner", "checkStorage, xweb dir:" + (String)localObject2 + ", size:" + g.Bq(l3));
          j = al((File)localObject1);
          if (j > 0) {
            localb.aili.add(new b.a(localb, j, l3));
          }
          localObject1 = ((File)localObject1).listFiles();
          l1 = l2;
          if (localObject1 != null)
          {
            m = localObject1.length;
            j = 0;
            for (;;)
            {
              l1 = l2;
              if (j >= m) {
                break;
              }
              localObject2 = localObject1[j];
              Log.i("XWalkCleaner", "checkStorage, xweb sub dir:" + ((File)localObject2).getName() + ", size:" + g.Bq(g.b((File)localObject2, true)));
              j += 1;
            }
          }
        }
      }
      else
      {
        if ((!((String)localObject2).startsWith("app_xwalkconfig")) || (!((File)localObject1).isDirectory())) {
          break label477;
        }
        l3 = g.b((File)localObject1, true);
        l1 = l2 + l3;
        Log.i("XWalkCleaner", "checkStorage, config dir:" + (String)localObject2 + ", size:" + g.Bq(l3));
        localb.ailf = l3;
      }
      do
      {
        do
        {
          i += 1;
          l2 = l1;
          break;
          l1 = l2;
        } while (!((String)localObject2).startsWith("app_xwalkplugin"));
        l1 = l2;
      } while (!((File)localObject1).isDirectory());
      l1 = 0L;
      localObject1 = ((File)localObject1).listFiles();
      l3 = l1;
      if (localObject1 != null)
      {
        m = localObject1.length;
        j = 0;
        l3 = l1;
        if (j < m)
        {
          localObject2 = localObject1[j];
          if (!"cache".equalsIgnoreCase(((File)localObject2).getName()))
          {
            bool = true;
            l4 = g.b((File)localObject2, bool);
            if (l4 <= 0L) {
              break label1468;
            }
            l3 = l1 + l4;
            Log.i("XWalkCleaner", "checkStorage, plugin dir:" + ((File)localObject2).getName() + ", size:" + g.Bq(l4));
            localObject2 = i.aj((File)localObject2);
            l1 = l3;
            if (localObject2 != null)
            {
              str = ((i.a)localObject2).MPj;
              n = ((i.a)localObject2).aipR;
              l1 = l3;
              if (!TextUtils.isEmpty(str))
              {
                if (!str.startsWith("XFilesPDFReader")) {
                  break label720;
                }
                localb.ailj.add(new b.a(localb, n, l4));
                l1 = l3;
              }
            }
          }
        }
      }
    }
    label1468:
    for (;;)
    {
      j += 1;
      break label530;
      bool = false;
      break label563;
      label720:
      if (str.startsWith("XFilesWordReader"))
      {
        localb.ailk.add(new b.a(localb, n, l4));
        l1 = l3;
      }
      else if (str.startsWith("XFilesExcelReader"))
      {
        localb.aill.add(new b.a(localb, n, l4));
        l1 = l3;
      }
      else if (str.startsWith("XFilesPPTReader"))
      {
        localb.ailm.add(new b.a(localb, n, l4));
        l1 = l3;
      }
      else if (str.startsWith("XFilesOfficeReader"))
      {
        localb.ailn.add(new b.a(localb, n, l4));
        l1 = l3;
      }
      else
      {
        l1 = l3;
        if (str.startsWith("FullScreenVideo"))
        {
          localb.ailo.add(new b.a(localb, n, l4));
          l1 = l3;
          continue;
          l1 = l2;
          if (l3 <= 0L) {
            break;
          }
          Log.i("XWalkCleaner", "checkStorage, plugin total size:" + g.Bq(l3));
          localb.ailg = l3;
          l1 = l2;
          break;
          if (l2 > 0L)
          {
            Log.i("XWalkCleaner", "checkStorage, app_xwalk total size:" + g.Bq(l2));
            localb.ailh = l2;
            l.ev(24156, ao.kge() + "," + XWalkEnvironment.getInstalledNewstVersionForCurAbi() + "," + XWalkEnvironment.getInstalledPluginVersion(XWalkEnvironment.getApplicationContext(), "FullScreenVideo") + "," + XWalkEnvironment.getInstalledPluginVersion(XWalkEnvironment.getApplicationContext(), "XFilesPDFReader") + "," + XWalkEnvironment.getInstalledPluginVersion(XWalkEnvironment.getApplicationContext(), "XFilesWordReader") + "," + XWalkEnvironment.getInstalledPluginVersion(XWalkEnvironment.getApplicationContext(), "XFilesExcelReader") + "," + XWalkEnvironment.getInstalledPluginVersion(XWalkEnvironment.getApplicationContext(), "XFilesPPTReader") + "," + XWalkEnvironment.getInstalledPluginVersion(XWalkEnvironment.getApplicationContext(), "XFilesOfficeReader") + "," + com.tencent.xweb.b.b.oB(localb.aili) + "," + com.tencent.xweb.b.b.oB(localb.ailo) + "," + com.tencent.xweb.b.b.oB(localb.ailj) + "," + com.tencent.xweb.b.b.oB(localb.ailk) + "," + com.tencent.xweb.b.b.oB(localb.aill) + "," + com.tencent.xweb.b.b.oB(localb.ailm) + "," + com.tencent.xweb.b.b.oB(localb.ailn) + "," + localb.ailf + "," + localb.ailg + "," + localb.ailh + "," + localb.aili.size() + "," + localb.ailo.size() + "," + localb.ailj.size() + "," + localb.ailk.size() + "," + localb.aill.size() + "," + localb.ailm.size() + "," + localb.ailn.size());
          }
          AppMethodBeat.o(213066);
          return;
        }
      }
    }
  }
  
  public static void pg(Context paramContext)
  {
    AppMethodBeat.i(213085);
    if ((paramContext == null) || (paramContext.getApplicationInfo() == null) || (paramContext.getApplicationInfo().dataDir == null))
    {
      Log.e("XWalkCleaner", "tryCleanAllDownloadedZip failed, context is null");
      AppMethodBeat.o(213085);
      return;
    }
    paramContext = new File(paramContext.getApplicationInfo().dataDir);
    if (!paramContext.exists())
    {
      Log.e("XWalkCleaner", "tryCleanAllDownloadedZip failed, dataDir not exist");
      AppMethodBeat.o(213085);
      return;
    }
    paramContext = paramContext.listFiles();
    if (paramContext == null)
    {
      Log.e("XWalkCleaner", "tryCleanAllDownloadedZip failed, files is null");
      AppMethodBeat.o(213085);
      return;
    }
    int j = paramContext.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramContext[i];
      int k;
      if ((((File)localObject).getName().startsWith("app_xwalk_")) && (((File)localObject).isDirectory()))
      {
        k = al((File)localObject);
        if (k > 0)
        {
          Log.i("XWalkCleaner", "tryCleanAllDownloadedZip, clean version:".concat(String.valueOf(k)));
          if (new File(XWalkFileUtil.getDownloadApkPath(k)).exists()) {
            break label197;
          }
          Log.w("XWalkCleaner", "tryCleanDownloadedZip, base.apk file not exist");
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label197:
        if (!new File(XWalkFileUtil.getExtractedCoreDir(k)).exists())
        {
          Log.w("XWalkCleaner", "tryCleanDownloadedZip, extracted_core directory not exist");
        }
        else
        {
          localObject = XWalkFileUtil.getDownloadZipPath(k);
          boolean bool = g.deleteFile((String)localObject);
          Log.i("XWalkCleaner", "tryCleanDownloadedZip, delete result:" + bool + ", path:" + (String)localObject);
        }
      }
    }
    AppMethodBeat.o(213085);
  }
  
  public static void ph(Context paramContext)
  {
    AppMethodBeat.i(213141);
    if ((paramContext == null) || (paramContext.getApplicationInfo() == null) || (paramContext.getApplicationInfo().dataDir == null))
    {
      Log.e("XWalkCleaner", "clearAllVersion failed, context is null");
      AppMethodBeat.o(213141);
      return;
    }
    paramContext = new File(paramContext.getApplicationInfo().dataDir);
    if (!paramContext.exists())
    {
      Log.e("XWalkCleaner", "clearAllVersion failed, dataDir not exist");
      AppMethodBeat.o(213141);
      return;
    }
    paramContext = paramContext.listFiles();
    if (paramContext == null)
    {
      Log.e("XWalkCleaner", "clearAllVersion failed, files is null");
      AppMethodBeat.o(213141);
      return;
    }
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramContext[i];
      String str = localObject.getName();
      if ((str.startsWith("app_xwalk_")) && (localObject.isDirectory()))
      {
        Log.i("XWalkCleaner", "clearAllVersion, version:".concat(String.valueOf(str)));
        g.bHZ(localObject.getAbsolutePath());
      }
      i += 1;
    }
    XWalkEnvironment.setCoreVersionInfo(-1, null, "armeabi-v7a");
    XWalkEnvironment.setCoreVersionInfo(-1, null, "arm64-v8a");
    AppMethodBeat.o(213141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.f
 * JD-Core Version:    0.7.0.1
 */