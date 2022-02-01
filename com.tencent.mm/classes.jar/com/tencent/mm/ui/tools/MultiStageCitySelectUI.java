package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.location.model.g;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MultiStageCitySelectUI
  extends MMPreference
  implements i
{
  private static List<RegionCodeDecoder.Region> XTC;
  private String Icv;
  private boolean XTA;
  private ZoneRecommandPreference XTB;
  private String XTD;
  private ArrayList<String> XTE;
  private Runnable XTF;
  private String XTs;
  private boolean XTt;
  private int XTu;
  private RegionCodeDecoder.Region[] XTv;
  private boolean XTw;
  private boolean XTx;
  private boolean XTy;
  private boolean XTz;
  private String cityCode;
  private String countryCode;
  private int fMU;
  private MMHandler handler;
  private b.a iQJ;
  private t jjS;
  private d lEL;
  private String lSz;
  private boolean mShowSelectedLocation;
  private boolean mXU;
  private String provinceCode;
  private f screen;
  private boolean zHI;
  
  public MultiStageCitySelectUI()
  {
    AppMethodBeat.i(39093);
    this.countryCode = null;
    this.provinceCode = null;
    this.cityCode = null;
    this.lSz = null;
    this.XTs = null;
    this.Icv = null;
    this.XTt = false;
    this.fMU = 0;
    this.XTu = -1;
    this.XTw = false;
    this.XTx = true;
    this.mShowSelectedLocation = true;
    this.XTy = false;
    this.XTz = false;
    this.XTA = false;
    this.mXU = true;
    this.jjS = new t((byte)0);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.iQJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(39085);
        if (MultiStageCitySelectUI.a(MultiStageCitySelectUI.this) == null)
        {
          AppMethodBeat.o(39085);
          return false;
        }
        if (paramAnonymousBoolean)
        {
          Log.i("MicroMsg.MultiStageCitySelectUI", "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble2) });
          g localg = new g(paramAnonymousFloat2, paramAnonymousFloat1);
          bh.aGY().a(localg, 0);
        }
        for (;;)
        {
          if (MultiStageCitySelectUI.a(MultiStageCitySelectUI.this) != null)
          {
            MultiStageCitySelectUI.a(MultiStageCitySelectUI.this).b(MultiStageCitySelectUI.e(MultiStageCitySelectUI.this));
            MultiStageCitySelectUI.f(MultiStageCitySelectUI.this);
          }
          AppMethodBeat.o(39085);
          return false;
          MultiStageCitySelectUI.b(MultiStageCitySelectUI.this);
          if ((!MultiStageCitySelectUI.c(MultiStageCitySelectUI.this)) && (!d.blr()))
          {
            MultiStageCitySelectUI.d(MultiStageCitySelectUI.this);
            h.a(MultiStageCitySelectUI.this, MultiStageCitySelectUI.this.getString(R.l.gps_disable_tip), MultiStageCitySelectUI.this.getString(R.l.app_tip), MultiStageCitySelectUI.this.getString(R.l.jump_to_settings), MultiStageCitySelectUI.this.getString(R.l.app_cancel), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(39084);
                d.cW(MultiStageCitySelectUI.this);
                AppMethodBeat.o(39084);
              }
            }, null);
          }
        }
      }
    };
    this.XTF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39091);
        MultiStageCitySelectUI.n(MultiStageCitySelectUI.this);
        AppMethodBeat.o(39091);
      }
    };
    AppMethodBeat.o(39093);
  }
  
  private void hYw()
  {
    switch (this.fMU)
    {
    default: 
      return;
    case 2: 
      this.cityCode = null;
      return;
    case 1: 
      this.provinceCode = null;
      return;
    }
    this.countryCode = null;
  }
  
  /* Error */
  private static List<RegionCodeDecoder.Region> hYx()
  {
    // Byte code:
    //   0: ldc 166
    //   2: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 172	com/tencent/mm/storage/RegionCodeDecoder:hAC	()Lcom/tencent/mm/storage/RegionCodeDecoder;
    //   8: astore_0
    //   9: aload_0
    //   10: invokestatic 178	com/tencent/mm/sdk/platformtools/LocaleUtil:getApplicationLanguage	()Ljava/lang/String;
    //   13: putfield 181	com/tencent/mm/storage/RegionCodeDecoder:VHv	Ljava/lang/String;
    //   16: aload_0
    //   17: invokevirtual 184	com/tencent/mm/storage/RegionCodeDecoder:hAD	()Ljava/lang/String;
    //   20: astore_1
    //   21: aload_1
    //   22: invokestatic 190	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   25: ifeq +43 -> 68
    //   28: ldc 192
    //   30: new 194	java/lang/StringBuilder
    //   33: dup
    //   34: ldc 196
    //   36: invokespecial 199	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: aload_0
    //   40: getfield 181	com/tencent/mm/storage/RegionCodeDecoder:VHv	Ljava/lang/String;
    //   43: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aconst_null
    //   53: astore_0
    //   54: aload_0
    //   55: invokestatic 190	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   58: ifeq +34 -> 92
    //   61: ldc 166
    //   63: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aconst_null
    //   67: areturn
    //   68: new 194	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   75: getstatic 215	com/tencent/mm/storage/RegionCodeDecoder:VHu	Ljava/lang/String;
    //   78: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_1
    //   82: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore_0
    //   89: goto -35 -> 54
    //   92: new 217	java/util/ArrayList
    //   95: dup
    //   96: invokespecial 218	java/util/ArrayList:<init>	()V
    //   99: astore 6
    //   101: aload_0
    //   102: invokestatic 224	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   105: astore_3
    //   106: new 226	java/io/InputStreamReader
    //   109: dup
    //   110: aload_3
    //   111: invokespecial 229	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   114: astore_2
    //   115: new 231	java/io/BufferedReader
    //   118: dup
    //   119: aload_2
    //   120: invokespecial 234	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   123: astore 4
    //   125: aconst_null
    //   126: astore_1
    //   127: aconst_null
    //   128: astore_0
    //   129: aload 4
    //   131: invokevirtual 237	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   134: astore 5
    //   136: aload 5
    //   138: ifnull +256 -> 394
    //   141: aload 5
    //   143: ldc 239
    //   145: invokevirtual 245	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   148: astore 7
    //   150: new 247	com/tencent/mm/storage/RegionCodeDecoder$Region
    //   153: dup
    //   154: invokespecial 248	com/tencent/mm/storage/RegionCodeDecoder$Region:<init>	()V
    //   157: astore 5
    //   159: aload 7
    //   161: arraylength
    //   162: iconst_2
    //   163: if_icmpne +437 -> 600
    //   166: aload 5
    //   168: aload 7
    //   170: iconst_1
    //   171: aaload
    //   172: invokevirtual 251	com/tencent/mm/storage/RegionCodeDecoder$Region:setName	(Ljava/lang/String;)V
    //   175: aload 7
    //   177: iconst_0
    //   178: aaload
    //   179: ldc 253
    //   181: invokevirtual 245	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   184: astore 7
    //   186: aload 7
    //   188: iconst_0
    //   189: aaload
    //   190: astore 8
    //   192: aload 5
    //   194: aload 8
    //   196: invokevirtual 256	com/tencent/mm/storage/RegionCodeDecoder$Region:setCountryCode	(Ljava/lang/String;)V
    //   199: aload 8
    //   201: invokestatic 190	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   204: ifne -75 -> 129
    //   207: aload 7
    //   209: arraylength
    //   210: iconst_1
    //   211: if_icmpne +44 -> 255
    //   214: aload 5
    //   216: aload 8
    //   218: invokevirtual 259	com/tencent/mm/storage/RegionCodeDecoder$Region:setCode	(Ljava/lang/String;)V
    //   221: aload 5
    //   223: iconst_0
    //   224: invokevirtual 263	com/tencent/mm/storage/RegionCodeDecoder$Region:setProvince	(Z)V
    //   227: aload 5
    //   229: iconst_0
    //   230: invokevirtual 266	com/tencent/mm/storage/RegionCodeDecoder$Region:setCity	(Z)V
    //   233: aload 5
    //   235: iconst_1
    //   236: invokevirtual 269	com/tencent/mm/storage/RegionCodeDecoder$Region:setCountry	(Z)V
    //   239: aload 5
    //   241: astore_1
    //   242: aload 6
    //   244: aload 5
    //   246: invokeinterface 275 2 0
    //   251: pop
    //   252: goto +348 -> 600
    //   255: aload 7
    //   257: arraylength
    //   258: iconst_2
    //   259: if_icmpne +63 -> 322
    //   262: aload 5
    //   264: aload 7
    //   266: iconst_1
    //   267: aaload
    //   268: invokevirtual 259	com/tencent/mm/storage/RegionCodeDecoder$Region:setCode	(Ljava/lang/String;)V
    //   271: aload 5
    //   273: iconst_1
    //   274: invokevirtual 263	com/tencent/mm/storage/RegionCodeDecoder$Region:setProvince	(Z)V
    //   277: aload 5
    //   279: iconst_0
    //   280: invokevirtual 269	com/tencent/mm/storage/RegionCodeDecoder$Region:setCountry	(Z)V
    //   283: aload 5
    //   285: iconst_0
    //   286: invokevirtual 266	com/tencent/mm/storage/RegionCodeDecoder$Region:setCity	(Z)V
    //   289: aload_1
    //   290: ifnull +313 -> 603
    //   293: aload_1
    //   294: invokevirtual 278	com/tencent/mm/storage/RegionCodeDecoder$Region:getCountryCode	()Ljava/lang/String;
    //   297: aload 5
    //   299: invokevirtual 278	com/tencent/mm/storage/RegionCodeDecoder$Region:getCountryCode	()Ljava/lang/String;
    //   302: invokevirtual 281	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   305: ifeq +298 -> 603
    //   308: aload_1
    //   309: iconst_1
    //   310: invokevirtual 284	com/tencent/mm/storage/RegionCodeDecoder$Region:setHasChildren	(Z)V
    //   313: aload 5
    //   315: aload_1
    //   316: invokevirtual 288	com/tencent/mm/storage/RegionCodeDecoder$Region:setParent	(Lcom/tencent/mm/storage/RegionCodeDecoder$Region;)V
    //   319: goto +284 -> 603
    //   322: aload 7
    //   324: arraylength
    //   325: iconst_3
    //   326: if_icmpne +65 -> 391
    //   329: aload 5
    //   331: aload 7
    //   333: iconst_2
    //   334: aaload
    //   335: invokevirtual 259	com/tencent/mm/storage/RegionCodeDecoder$Region:setCode	(Ljava/lang/String;)V
    //   338: aload 5
    //   340: iconst_1
    //   341: invokevirtual 266	com/tencent/mm/storage/RegionCodeDecoder$Region:setCity	(Z)V
    //   344: aload 5
    //   346: iconst_0
    //   347: invokevirtual 269	com/tencent/mm/storage/RegionCodeDecoder$Region:setCountry	(Z)V
    //   350: aload 5
    //   352: iconst_0
    //   353: invokevirtual 263	com/tencent/mm/storage/RegionCodeDecoder$Region:setProvince	(Z)V
    //   356: aload 5
    //   358: iconst_0
    //   359: invokevirtual 284	com/tencent/mm/storage/RegionCodeDecoder$Region:setHasChildren	(Z)V
    //   362: aload_0
    //   363: ifnull +28 -> 391
    //   366: aload_0
    //   367: invokevirtual 291	com/tencent/mm/storage/RegionCodeDecoder$Region:getCode	()Ljava/lang/String;
    //   370: aload 7
    //   372: iconst_1
    //   373: aaload
    //   374: invokevirtual 281	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   377: ifeq +14 -> 391
    //   380: aload 5
    //   382: aload_0
    //   383: invokevirtual 288	com/tencent/mm/storage/RegionCodeDecoder$Region:setParent	(Lcom/tencent/mm/storage/RegionCodeDecoder$Region;)V
    //   386: aload_0
    //   387: iconst_1
    //   388: invokevirtual 284	com/tencent/mm/storage/RegionCodeDecoder$Region:setHasChildren	(Z)V
    //   391: goto -149 -> 242
    //   394: aload_3
    //   395: ifnull +7 -> 402
    //   398: aload_3
    //   399: invokevirtual 296	java/io/InputStream:close	()V
    //   402: aload_2
    //   403: invokevirtual 297	java/io/InputStreamReader:close	()V
    //   406: aload 4
    //   408: invokevirtual 298	java/io/BufferedReader:close	()V
    //   411: ldc 166
    //   413: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   416: aload 6
    //   418: areturn
    //   419: astore_1
    //   420: aconst_null
    //   421: astore_0
    //   422: aconst_null
    //   423: astore_2
    //   424: aconst_null
    //   425: astore_3
    //   426: ldc_w 300
    //   429: aload_1
    //   430: ldc_w 302
    //   433: iconst_1
    //   434: anewarray 304	java/lang/Object
    //   437: dup
    //   438: iconst_0
    //   439: aload_1
    //   440: invokevirtual 307	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   443: aastore
    //   444: invokestatic 311	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   447: aload_3
    //   448: ifnull +7 -> 455
    //   451: aload_3
    //   452: invokevirtual 296	java/io/InputStream:close	()V
    //   455: aload_2
    //   456: ifnull +7 -> 463
    //   459: aload_2
    //   460: invokevirtual 297	java/io/InputStreamReader:close	()V
    //   463: aload_0
    //   464: ifnull -53 -> 411
    //   467: aload_0
    //   468: invokevirtual 298	java/io/BufferedReader:close	()V
    //   471: goto -60 -> 411
    //   474: astore_0
    //   475: goto -64 -> 411
    //   478: astore_0
    //   479: aconst_null
    //   480: astore_1
    //   481: aconst_null
    //   482: astore_2
    //   483: aconst_null
    //   484: astore_3
    //   485: aload_3
    //   486: ifnull +7 -> 493
    //   489: aload_3
    //   490: invokevirtual 296	java/io/InputStream:close	()V
    //   493: aload_2
    //   494: ifnull +7 -> 501
    //   497: aload_2
    //   498: invokevirtual 297	java/io/InputStreamReader:close	()V
    //   501: aload_1
    //   502: ifnull +7 -> 509
    //   505: aload_1
    //   506: invokevirtual 298	java/io/BufferedReader:close	()V
    //   509: ldc 166
    //   511: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   514: aload_0
    //   515: athrow
    //   516: astore_0
    //   517: goto -115 -> 402
    //   520: astore_0
    //   521: goto -115 -> 406
    //   524: astore_0
    //   525: goto -114 -> 411
    //   528: astore_1
    //   529: goto -74 -> 455
    //   532: astore_1
    //   533: goto -70 -> 463
    //   536: astore_3
    //   537: goto -44 -> 493
    //   540: astore_2
    //   541: goto -40 -> 501
    //   544: astore_1
    //   545: goto -36 -> 509
    //   548: astore_0
    //   549: aconst_null
    //   550: astore_1
    //   551: aconst_null
    //   552: astore_2
    //   553: goto -68 -> 485
    //   556: astore_0
    //   557: aconst_null
    //   558: astore_1
    //   559: goto -74 -> 485
    //   562: astore_0
    //   563: aload 4
    //   565: astore_1
    //   566: goto -81 -> 485
    //   569: astore 4
    //   571: aload_0
    //   572: astore_1
    //   573: aload 4
    //   575: astore_0
    //   576: goto -91 -> 485
    //   579: astore_1
    //   580: aconst_null
    //   581: astore_0
    //   582: aconst_null
    //   583: astore_2
    //   584: goto -158 -> 426
    //   587: astore_1
    //   588: aconst_null
    //   589: astore_0
    //   590: goto -164 -> 426
    //   593: astore_1
    //   594: aload 4
    //   596: astore_0
    //   597: goto -171 -> 426
    //   600: goto -471 -> 129
    //   603: aload 5
    //   605: astore_0
    //   606: goto -364 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   8	460	0	localObject1	Object
    //   474	1	0	localIOException1	java.io.IOException
    //   478	37	0	localObject2	Object
    //   516	1	0	localIOException2	java.io.IOException
    //   520	1	0	localIOException3	java.io.IOException
    //   524	1	0	localIOException4	java.io.IOException
    //   548	1	0	localObject3	Object
    //   556	1	0	localObject4	Object
    //   562	10	0	localObject5	Object
    //   575	31	0	localObject6	Object
    //   20	296	1	localObject7	Object
    //   419	21	1	localException1	java.lang.Exception
    //   480	26	1	localObject8	Object
    //   528	1	1	localIOException5	java.io.IOException
    //   532	1	1	localIOException6	java.io.IOException
    //   544	1	1	localIOException7	java.io.IOException
    //   550	23	1	localObject9	Object
    //   579	1	1	localException2	java.lang.Exception
    //   587	1	1	localException3	java.lang.Exception
    //   593	1	1	localException4	java.lang.Exception
    //   114	384	2	localInputStreamReader	java.io.InputStreamReader
    //   540	1	2	localIOException8	java.io.IOException
    //   552	32	2	localObject10	Object
    //   105	385	3	localInputStream	java.io.InputStream
    //   536	1	3	localIOException9	java.io.IOException
    //   123	441	4	localBufferedReader	java.io.BufferedReader
    //   569	26	4	localObject11	Object
    //   134	470	5	localObject12	Object
    //   99	318	6	localArrayList	ArrayList
    //   148	223	7	arrayOfString	String[]
    //   190	27	8	str	String
    // Exception table:
    //   from	to	target	type
    //   101	106	419	java/lang/Exception
    //   467	471	474	java/io/IOException
    //   101	106	478	finally
    //   398	402	516	java/io/IOException
    //   402	406	520	java/io/IOException
    //   406	411	524	java/io/IOException
    //   451	455	528	java/io/IOException
    //   459	463	532	java/io/IOException
    //   489	493	536	java/io/IOException
    //   497	501	540	java/io/IOException
    //   505	509	544	java/io/IOException
    //   106	115	548	finally
    //   115	125	556	finally
    //   129	136	562	finally
    //   141	186	562	finally
    //   192	239	562	finally
    //   242	252	562	finally
    //   255	289	562	finally
    //   293	319	562	finally
    //   322	362	562	finally
    //   366	391	562	finally
    //   426	447	569	finally
    //   106	115	579	java/lang/Exception
    //   115	125	587	java/lang/Exception
    //   129	136	593	java/lang/Exception
    //   141	186	593	java/lang/Exception
    //   192	239	593	java/lang/Exception
    //   242	252	593	java/lang/Exception
    //   255	289	593	java/lang/Exception
    //   293	319	593	java/lang/Exception
    //   322	362	593	java/lang/Exception
    //   366	391	593	java/lang/Exception
  }
  
  private void hYy()
  {
    AppMethodBeat.i(39104);
    if (this.XTB != null) {
      this.XTB.hYM();
    }
    AppMethodBeat.o(39104);
  }
  
  public int getResourceId()
  {
    return R.i.emg;
  }
  
  public final void hYv()
  {
    AppMethodBeat.i(39094);
    Object localObject2;
    int j;
    int i;
    Object localObject3;
    if (this.fMU == 3)
    {
      localObject1 = new ArrayList();
      localObject2 = RegionCodeDecoder.hAC().hAE();
      if (localObject2 != null)
      {
        j = localObject2.length;
        i = 0;
        while (i < j)
        {
          localObject3 = localObject2[i];
          if (("HK".equalsIgnoreCase(((RegionCodeDecoder.Region)localObject3).getCode())) || ("TW".equalsIgnoreCase(((RegionCodeDecoder.Region)localObject3).getCode())) || ("MO".equalsIgnoreCase(((RegionCodeDecoder.Region)localObject3).getCode()))) {
            ((List)localObject1).add(localObject3);
          }
          i += 1;
        }
      }
      localObject2 = RegionCodeDecoder.hAC().bxq("CN");
      j = localObject2.length;
      localObject2 = (RegionCodeDecoder.Region[])Arrays.copyOf((Object[])localObject2, ((List)localObject1).size() + j);
      localObject3 = ((List)localObject1).iterator();
      i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject2[(j + i)] = ((RegionCodeDecoder.Region)((Iterator)localObject3).next());
        i += 1;
      }
    }
    if (Util.isNullOrNil(this.countryCode))
    {
      localObject2 = RegionCodeDecoder.hAC().hAE();
      if (this.XTz)
      {
        localObject3 = new ArrayList();
        if (localObject2 != null)
        {
          j = localObject2.length;
          i = 0;
          while (i < j)
          {
            localObject1 = localObject2[i];
            if ((!this.XTE.contains(((RegionCodeDecoder.Region)localObject1).getCode())) && (!"CN".equalsIgnoreCase(((RegionCodeDecoder.Region)localObject1).getCode())) && (!"HK".equalsIgnoreCase(((RegionCodeDecoder.Region)localObject1).getCode())) && (!"TW".equalsIgnoreCase(((RegionCodeDecoder.Region)localObject1).getCode())) && (!"MO".equalsIgnoreCase(((RegionCodeDecoder.Region)localObject1).getCode()))) {
              ((List)localObject3).add(localObject1);
            }
            i += 1;
          }
        }
        localObject1 = new RegionCodeDecoder.Region[((List)localObject3).size()];
        ((List)localObject3).toArray((Object[])localObject1);
      }
    }
    for (;;)
    {
      this.XTv = ((RegionCodeDecoder.Region[])localObject1);
      if ((this.XTv != null) && (this.XTv.length > 0)) {
        break;
      }
      Log.e("MicroMsg.MultiStageCitySelectUI", "initZoneItems error ,check zone lists!");
      AppMethodBeat.o(39094);
      return;
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject3 = new ArrayList();
        j = localObject2.length;
        i = 0;
        while (i < j)
        {
          localObject1 = localObject2[i];
          if (!this.XTE.contains(((RegionCodeDecoder.Region)localObject1).getCode())) {
            ((List)localObject3).add(localObject1);
          }
          i += 1;
        }
        localObject1 = new RegionCodeDecoder.Region[((List)localObject3).size()];
        ((List)localObject3).toArray((Object[])localObject1);
        continue;
        if (Util.isNullOrNil(this.provinceCode)) {
          localObject1 = RegionCodeDecoder.hAC().bxq(this.countryCode);
        } else {
          localObject1 = RegionCodeDecoder.hAC().nP(this.countryCode, this.provinceCode);
        }
      }
    }
    this.screen.removeAll();
    ZonePreference localZonePreference;
    if (getIntent().getBooleanExtra("SetSelectLocation", false))
    {
      localObject1 = getIntent().getStringExtra("SelectedCountryCode");
      localObject2 = getIntent().getStringExtra("SelectedProvinceCode");
      localObject3 = getIntent().getStringExtra("SelectedCityCode");
      this.mShowSelectedLocation = getIntent().getBooleanExtra("ShowSelectedLocation", true);
      this.XTy = getIntent().getBooleanExtra("NeedUnshowItem", false);
      if (this.XTy)
      {
        localZonePreference = new ZonePreference(this);
        RegionCodeDecoder.Region localRegion = new RegionCodeDecoder.Region();
        localRegion.setName(getString(R.l.finder_settings_unshow));
        localRegion.setHasChildren(false);
        localRegion.setCountry(false);
        localRegion.setCode("unshow");
        localZonePreference.a(localRegion);
        this.screen.b(localZonePreference);
        if ("unshow".equals(localObject1)) {
          localZonePreference.auI(R.l.setting_zone_selected);
        }
      }
      i = 0;
      label694:
      if (i >= this.XTv.length) {
        break label1003;
      }
      if ((this.XTv[i] != null) && (!Util.isNullOrNil(this.XTv[i].getCode())) && (!Util.isNullOrNil(this.XTv[i].getName())))
      {
        localZonePreference = new ZonePreference(this);
        localZonePreference.a(this.XTv[i]);
        if (!this.mShowSelectedLocation) {
          break label989;
        }
        if ((this.fMU != 0) || (!this.XTv[i].getCode().equalsIgnoreCase((String)localObject1))) {
          break label879;
        }
        this.screen.a(localZonePreference, 0);
        localZonePreference.auI(R.l.setting_zone_selected_location);
      }
    }
    label989:
    for (;;)
    {
      i += 1;
      break label694;
      bh.beI();
      localObject1 = (String)c.aHp().b(12324, null);
      bh.beI();
      localObject2 = (String)c.aHp().b(12325, null);
      bh.beI();
      localObject3 = (String)c.aHp().b(12326, null);
      break;
      label879:
      if ((this.fMU == 1) && (this.XTv[i].getCode().equalsIgnoreCase((String)localObject2)))
      {
        this.screen.a(localZonePreference, 0);
        localZonePreference.auI(R.l.setting_zone_selected_location);
      }
      else if ((this.fMU == 2) && (this.XTv[i].getCode().equalsIgnoreCase((String)localObject3)))
      {
        this.screen.a(localZonePreference, 0);
        localZonePreference.auI(R.l.setting_zone_selected_location);
      }
      else
      {
        this.screen.b(localZonePreference);
        continue;
        this.screen.b(localZonePreference);
      }
    }
    label1003:
    if (this.fMU == 3)
    {
      localObject1 = new ZoneSelectOtherCountryPreference(this);
      ((ZoneSelectOtherCountryPreference)localObject1).text = getString(R.l.setting_zone_non_china_mainland);
      ((ZoneSelectOtherCountryPreference)localObject1).XVH = new ZoneSelectOtherCountryPreference.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(39086);
          Intent localIntent = new Intent(MultiStageCitySelectUI.this, MultiStageCitySelectUI.class);
          Bundle localBundle = new Bundle();
          localBundle.putBoolean("GetAddress", MultiStageCitySelectUI.g(MultiStageCitySelectUI.this));
          localBundle.putBoolean("ShowSelectedLocation", MultiStageCitySelectUI.h(MultiStageCitySelectUI.this));
          localBundle.putBoolean("IsSelectNonChinaCountry", true);
          localBundle.putBoolean("IsAutoPosition", false);
          localBundle.putBoolean("IsNeedShowSearchBar", true);
          localIntent.putExtras(localBundle);
          if (!MultiStageCitySelectUI.i(MultiStageCitySelectUI.this).isEmpty()) {
            localIntent.putStringArrayListExtra("BlockedCountries", MultiStageCitySelectUI.i(MultiStageCitySelectUI.this));
          }
          MultiStageCitySelectUI.this.startActivityForResult(localIntent, 1);
          AppMethodBeat.o(39086);
        }
      };
      this.screen.b((Preference)localObject1);
    }
    Object localObject1 = new PreferenceCategory(getContext());
    this.screen.b((Preference)localObject1);
    if ((this.fMU == 0) || (this.fMU == 3))
    {
      if (this.XTx)
      {
        localObject1 = new PreferenceTitleCategory(this);
        ((PreferenceTitleCategory)localObject1).setTitle(R.l.setting_zone_category_get_location);
        this.screen.a((Preference)localObject1, 0);
        this.XTB = new ZoneRecommandPreference(this);
        this.XTB.setKey("current_location");
        this.screen.a(this.XTB, 1);
      }
      localObject1 = new PreferenceTitleCategory(this);
      ((PreferenceTitleCategory)localObject1).setTitle(R.l.setting_zone_category_all_locations);
      if (this.XTx)
      {
        this.screen.a((Preference)localObject1, 2);
        AppMethodBeat.o(39094);
        return;
      }
      this.screen.a((Preference)localObject1, 0);
    }
    AppMethodBeat.o(39094);
  }
  
  public void initView()
  {
    AppMethodBeat.i(39099);
    setMMTitle(R.l.nearby_friend_city_select);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(39092);
        MultiStageCitySelectUI.o(MultiStageCitySelectUI.this);
        MultiStageCitySelectUI.this.finish();
        AppMethodBeat.o(39092);
        return true;
      }
    });
    this.XTw = getIntent().getBooleanExtra("GetAddress", false);
    this.countryCode = getIntent().getStringExtra("Country");
    this.provinceCode = getIntent().getStringExtra("Provice");
    this.lSz = getIntent().getStringExtra("CountryName");
    this.XTs = getIntent().getStringExtra("ProviceName");
    Intent localIntent = getIntent();
    boolean bool;
    if (!Util.isOverseasUser(this))
    {
      bool = true;
      this.XTx = localIntent.getBooleanExtra("IsAutoPosition", bool);
      this.XTt = getIntent().getBooleanExtra("IsRealNameVerifyScene", false);
      this.XTz = getIntent().getBooleanExtra("IsSelectNonChinaCountry", false);
      this.XTE = getIntent().getStringArrayListExtra("BlockedCountries");
      if (this.XTE == null) {
        this.XTE = new ArrayList();
      }
      this.XTA = getIntent().getBooleanExtra("IsNeedShowSearchBar", false);
      Log.i("MicroMsg.MultiStageCitySelectUI", " country = " + this.countryCode + " province =" + this.provinceCode + " city = " + this.cityCode + " " + this.lSz + " " + this.XTs + " " + this.XTt + " " + this.XTz);
      if (!this.XTt) {
        break label331;
      }
      this.fMU = 3;
    }
    for (;;)
    {
      hYv();
      AppMethodBeat.o(39099);
      return;
      bool = false;
      break;
      label331:
      if (this.countryCode == null)
      {
        this.fMU = 0;
        this.provinceCode = null;
        this.cityCode = null;
      }
      else if (this.provinceCode == null)
      {
        this.fMU = 1;
        this.cityCode = null;
      }
      else
      {
        this.fMU = 2;
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(39102);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(39102);
      return;
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(39101);
    hYw();
    super.onBackPressed();
    AppMethodBeat.o(39101);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39096);
    super.onCreate(paramBundle);
    bh.aGY().a(665, this);
    this.screen = getPreferenceScreen();
    initView();
    long l;
    if (this.XTA) {
      if ((XTC == null) || (XTC.size() <= 0))
      {
        l = Util.currentTicks();
        paramBundle = RegionCodeDecoder.hAC().hAE();
        if ((paramBundle != null) && (paramBundle.length > 0)) {
          break label108;
        }
      }
    }
    for (;;)
    {
      addSearchMenu(true, this.jjS);
      this.jjS.XUl = new t.b()
      {
        public final boolean aat(String paramAnonymousString)
        {
          AppMethodBeat.i(39089);
          if (!Util.isNullOrNil(paramAnonymousString))
          {
            MultiStageCitySelectUI.a(MultiStageCitySelectUI.this, paramAnonymousString);
            MultiStageCitySelectUI.k(MultiStageCitySelectUI.this).removeAll();
            MultiStageCitySelectUI.m(MultiStageCitySelectUI.this).removeCallbacks(MultiStageCitySelectUI.l(MultiStageCitySelectUI.this));
            MultiStageCitySelectUI.m(MultiStageCitySelectUI.this).postDelayed(MultiStageCitySelectUI.l(MultiStageCitySelectUI.this), 50L);
            AppMethodBeat.o(39089);
            return true;
          }
          AppMethodBeat.o(39089);
          return false;
        }
        
        public final void aau(String paramAnonymousString)
        {
          AppMethodBeat.i(39088);
          if (!Util.isNullOrNil(paramAnonymousString))
          {
            MultiStageCitySelectUI.a(MultiStageCitySelectUI.this, paramAnonymousString);
            MultiStageCitySelectUI.k(MultiStageCitySelectUI.this).removeAll();
            MultiStageCitySelectUI.m(MultiStageCitySelectUI.this).removeCallbacks(MultiStageCitySelectUI.l(MultiStageCitySelectUI.this));
            MultiStageCitySelectUI.m(MultiStageCitySelectUI.this).postDelayed(MultiStageCitySelectUI.l(MultiStageCitySelectUI.this), 50L);
          }
          AppMethodBeat.o(39088);
        }
        
        public final void bxH()
        {
          AppMethodBeat.i(39087);
          MultiStageCitySelectUI.this.hideVKB();
          MultiStageCitySelectUI.j(MultiStageCitySelectUI.this);
          MultiStageCitySelectUI.this.hYv();
          AppMethodBeat.o(39087);
        }
        
        public final void bxI() {}
        
        public final void bxJ()
        {
          AppMethodBeat.i(39090);
          MultiStageCitySelectUI.j(MultiStageCitySelectUI.this);
          MultiStageCitySelectUI.this.hYv();
          AppMethodBeat.o(39090);
        }
        
        public final void bxK() {}
      };
      AppMethodBeat.o(39096);
      return;
      label108:
      if ((XTC == null) || (XTC.size() <= 0))
      {
        paramBundle = hYx();
        XTC = paramBundle;
        if (paramBundle != null) {
          Log.i("MicroMsg.MultiStageCitySelectUI", "buildAllSearchRegion used %sms, size: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(XTC.size()) });
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39098);
    bh.aGY().b(665, this);
    if (this.lEL != null) {
      this.lEL.b(this.iQJ);
    }
    super.onDestroy();
    AppMethodBeat.o(39098);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    Bundle localBundle = null;
    AppMethodBeat.i(39100);
    Object localObject1;
    label114:
    Object localObject2;
    if ((paramPreference instanceof ZonePreference))
    {
      localObject1 = ((ZonePreference)paramPreference).XVz;
      if ((localObject1 == null) || (Util.isNullOrNil(((RegionCodeDecoder.Region)localObject1).getCode())))
      {
        paramPreference = new StringBuilder("onPreferenceTreeClick error item, code:");
        if (localObject1 == null)
        {
          paramf = Integer.valueOf(-1);
          paramPreference = paramPreference.append(paramf).append(" ,name:");
          if (localObject1 != null) {
            break label114;
          }
        }
        for (paramf = "null";; paramf = ((RegionCodeDecoder.Region)localObject1).getName())
        {
          Log.e("MicroMsg.MultiStageCitySelectUI", paramf);
          AppMethodBeat.o(39100);
          return false;
          paramf = ((RegionCodeDecoder.Region)localObject1).getCode();
          break;
        }
      }
      if (this.fMU == 3)
      {
        this.countryCode = "CN";
        this.provinceCode = ((RegionCodeDecoder.Region)localObject1).getCode();
        this.XTs = ((RegionCodeDecoder.Region)localObject1).getName();
      }
      if (this.fMU == 0)
      {
        this.countryCode = ((RegionCodeDecoder.Region)localObject1).getCode();
        this.lSz = ((RegionCodeDecoder.Region)localObject1).getName();
        if (((RegionCodeDecoder.Region)localObject1).hasChildren()) {
          break label647;
        }
        if (!this.XTw)
        {
          bh.beI();
          c.aHp().i(12324, this.countryCode);
          bh.beI();
          c.aHp().i(12325, this.provinceCode);
          bh.beI();
          c.aHp().i(12326, this.cityCode);
        }
        paramf = new Intent();
        paramf.putExtra("CountryName", this.lSz);
        paramf.putExtra("ProviceName", this.XTs);
        paramf.putExtra("CityName", this.Icv);
        paramf.putExtra("Country", this.countryCode);
        paramf.putExtra("Contact_Province", this.provinceCode);
        paramf.putExtra("Contact_City", this.cityCode);
        hideVKB();
        setResult(-1, paramf);
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(39100);
        return true;
        if (this.fMU == 1)
        {
          this.provinceCode = ((RegionCodeDecoder.Region)localObject1).getCode();
          this.XTs = ((RegionCodeDecoder.Region)localObject1).getName();
          break;
        }
        if (this.fMU == 2)
        {
          this.cityCode = ((RegionCodeDecoder.Region)localObject1).getCode();
          this.Icv = ((RegionCodeDecoder.Region)localObject1).getName();
          if (("CN".equalsIgnoreCase(this.countryCode)) || ("HK".equalsIgnoreCase(this.countryCode)) || ("MO".equalsIgnoreCase(this.countryCode)) || ("TW".equalsIgnoreCase(this.countryCode)))
          {
            this.lSz = null;
            break;
          }
          this.XTs = null;
          break;
        }
        if (this.fMU != 4) {
          break;
        }
        if ((((RegionCodeDecoder.Region)localObject1).getParent() != null) && (!((RegionCodeDecoder.Region)localObject1).hasChildren()))
        {
          this.cityCode = ((RegionCodeDecoder.Region)localObject1).getCode();
          this.Icv = ((RegionCodeDecoder.Region)localObject1).getName();
          this.provinceCode = ((RegionCodeDecoder.Region)localObject1).getParent().getCode();
          this.XTs = ((RegionCodeDecoder.Region)localObject1).getParent().getName();
          this.countryCode = ((RegionCodeDecoder.Region)localObject1).getCountryCode();
          this.lSz = null;
          break;
        }
        if ((((RegionCodeDecoder.Region)localObject1).hasChildren()) && (((RegionCodeDecoder.Region)localObject1).getParent() != null))
        {
          this.provinceCode = ((RegionCodeDecoder.Region)localObject1).getCode();
          this.XTs = ((RegionCodeDecoder.Region)localObject1).getName();
          this.countryCode = ((RegionCodeDecoder.Region)localObject1).getCountryCode();
          this.lSz = null;
          break;
        }
        this.countryCode = ((RegionCodeDecoder.Region)localObject1).getCode();
        this.lSz = ((RegionCodeDecoder.Region)localObject1).getName();
        this.provinceCode = null;
        this.XTs = null;
        this.cityCode = null;
        this.Icv = null;
        break;
        label647:
        localObject2 = new Intent(this, MultiStageCitySelectUI.class);
        localBundle = new Bundle();
        localBundle.putString("Country", this.countryCode);
        localBundle.putString("Provice", this.provinceCode);
        localBundle.putString("CountryName", this.lSz);
        localBundle.putString("ProviceName", this.XTs);
        localBundle.putBoolean("GetAddress", this.XTw);
        localBundle.putBoolean("ShowSelectedLocation", this.mShowSelectedLocation);
        localBundle.putString("SelectedCountryCode", getIntent().getStringExtra("SelectedCountryCode"));
        localBundle.putString("SelectedProvinceCode", getIntent().getStringExtra("SelectedProvinceCode"));
        localBundle.putString("SelectedCityCode", getIntent().getStringExtra("SelectedCityCode"));
        if (this.XTt)
        {
          paramPreference = ((RegionCodeDecoder.Region)localObject1).getCountryCode();
          paramf = paramPreference;
          if (Util.isNullOrNil(paramPreference)) {
            paramf = this.countryCode;
          }
          if (("CN".equalsIgnoreCase(paramf)) || ("HK".equalsIgnoreCase(paramf)) || ("MO".equalsIgnoreCase(paramf)) || ("TW".equalsIgnoreCase(paramf))) {
            localBundle.putBoolean("IsNeedShowSearchBar", true);
          }
          paramf = ((RegionCodeDecoder.Region)localObject1).getCode();
          if (("HK".equalsIgnoreCase(paramf)) || ("MO".equalsIgnoreCase(paramf)) || ("TW".equalsIgnoreCase(paramf)))
          {
            localBundle.putString("Country", paramf);
            localBundle.putString("CountryName", ((RegionCodeDecoder.Region)localObject1).getName());
            localBundle.remove("Provice");
          }
        }
        ((Intent)localObject2).putExtras(localBundle);
        hideVKB();
        startActivityForResult((Intent)localObject2, 1);
      }
    }
    int i;
    RegionCodeDecoder.Region[] arrayOfRegion;
    label1047:
    label1072:
    label1097:
    label1115:
    label1124:
    label1134:
    label1143:
    Intent localIntent;
    if (paramPreference.mKey.equals("current_location"))
    {
      if (this.XTB.status != 1) {
        break label1302;
      }
      i = 1;
      if (i != 0)
      {
        paramf = this.XTB;
        arrayOfRegion = new RegionCodeDecoder.Region[3];
        arrayOfRegion[0] = paramf.XVC;
        arrayOfRegion[1] = paramf.XVD;
        arrayOfRegion[2] = paramf.XVE;
        if (!this.XTw)
        {
          bh.beI();
          paramPreference = c.aHp();
          if (arrayOfRegion[0] != null) {
            break label1307;
          }
          paramf = null;
          paramPreference.i(12324, paramf);
          bh.beI();
          paramPreference = c.aHp();
          if (arrayOfRegion[1] != null) {
            break label1318;
          }
          paramf = null;
          paramPreference.i(12325, paramf);
          bh.beI();
          paramPreference = c.aHp();
          if (arrayOfRegion[2] != null) {
            break label1329;
          }
          paramf = null;
          paramPreference.i(12326, paramf);
        }
        if (arrayOfRegion[0] != null) {
          break label1340;
        }
        localObject1 = null;
        if (arrayOfRegion[0] != null) {
          break label1352;
        }
        paramf = null;
        if (arrayOfRegion[1] != null) {
          break label1363;
        }
        localObject2 = null;
        if (arrayOfRegion[1] != null) {
          break label1375;
        }
        paramPreference = null;
        if ((!"CN".equalsIgnoreCase((String)localObject1)) && (!"HK".equalsIgnoreCase((String)localObject1)) && (!"MO".equalsIgnoreCase((String)localObject1)) && (!"TW".equalsIgnoreCase((String)localObject1))) {
          break label1386;
        }
        paramf = null;
        label1189:
        localIntent = new Intent();
        localIntent.putExtra("CountryName", paramf);
        localIntent.putExtra("ProviceName", paramPreference);
        if (arrayOfRegion[2] != null) {
          break label1391;
        }
        paramf = null;
        label1227:
        localIntent.putExtra("CityName", paramf);
        localIntent.putExtra("Country", (String)localObject1);
        localIntent.putExtra("Contact_Province", (String)localObject2);
        if (arrayOfRegion[2] != null) {
          break label1402;
        }
      }
    }
    label1302:
    label1307:
    label1318:
    label1329:
    label1340:
    label1352:
    label1363:
    label1375:
    label1386:
    label1391:
    label1402:
    for (paramf = localBundle;; paramf = arrayOfRegion[2].getCode())
    {
      localIntent.putExtra("Contact_City", paramf);
      hideVKB();
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(39100);
      return false;
      i = 0;
      break;
      paramf = arrayOfRegion[0].getCode();
      break label1047;
      paramf = arrayOfRegion[1].getCode();
      break label1072;
      paramf = arrayOfRegion[2].getCode();
      break label1097;
      localObject1 = arrayOfRegion[0].getCode();
      break label1115;
      paramf = arrayOfRegion[0].getName();
      break label1124;
      localObject2 = arrayOfRegion[1].getCode();
      break label1134;
      paramPreference = arrayOfRegion[1].getName();
      break label1143;
      paramPreference = null;
      break label1189;
      paramf = arrayOfRegion[2].getName();
      break label1227;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(39105);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.MultiStageCitySelectUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(39105);
      return;
    }
    Log.i("MicroMsg.MultiStageCitySelectUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    if (paramArrayOfInt.length == 0)
    {
      AppMethodBeat.o(39105);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(39105);
      return;
      if (paramArrayOfInt[0] != 0)
      {
        if (this.XTB != null) {
          this.XTB.hYM();
        }
        this.mXU = false;
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39097);
    super.onResume();
    if (this.mXU)
    {
      boolean bool = b.a(this, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 64, null, null);
      Log.i("MicroMsg.MultiStageCitySelectUI", "settings district,checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        if (this.lEL == null) {
          this.lEL = d.blq();
        }
        this.lEL.a(this.iQJ, true);
      }
    }
    AppMethodBeat.o(39097);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(39103);
    g localg;
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq.getType() != 665) {
        break label329;
      }
      localg = (g)paramq;
      paramq = localg.country;
      paramString = localg.province;
      localObject = localg.city;
      Log.i("MicroMsg.MultiStageCitySelectUI", "current location country %s, province %s, city %s", new Object[] { paramq, paramString, localObject });
      RegionCodeDecoder.Region[] arrayOfRegion = RegionCodeDecoder.hAC().hAE();
      paramInt2 = arrayOfRegion.length;
      paramInt1 = 0;
      if (paramInt1 >= paramInt2) {
        break label336;
      }
      localg = arrayOfRegion[paramInt1];
      if (localg.getCode().equalsIgnoreCase(paramq))
      {
        arrayOfRegion = RegionCodeDecoder.hAC().bxq(localg.getCode());
        paramInt2 = arrayOfRegion.length;
        paramInt1 = 0;
        label136:
        if (paramInt1 < paramInt2)
        {
          paramq = arrayOfRegion[paramInt1];
          if (paramq.getCode().equalsIgnoreCase(paramString))
          {
            arrayOfRegion = RegionCodeDecoder.hAC().nP(localg.getCode(), paramq.getCode());
            paramInt2 = arrayOfRegion.length;
            paramInt1 = 0;
            label183:
            if (paramInt1 < paramInt2)
            {
              paramString = arrayOfRegion[paramInt1];
              if (!paramString.getCode().equalsIgnoreCase((String)localObject)) {}
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((localg == null) && (paramq == null) && (paramString == null))
      {
        if (this.XTB == null) {
          break label318;
        }
        this.XTB.hYM();
        AppMethodBeat.o(39103);
        return;
        paramInt1 += 1;
        break label183;
        paramString = null;
        continue;
        paramInt1 += 1;
        break label136;
        paramString = null;
        paramq = null;
        continue;
        paramInt1 += 1;
        break;
      }
      if (this.XTB != null)
      {
        localObject = this.XTB;
        ((ZoneRecommandPreference)localObject).status = 1;
        ((ZoneRecommandPreference)localObject).XVC = localg;
        ((ZoneRecommandPreference)localObject).XVD = paramq;
        ((ZoneRecommandPreference)localObject).XVE = paramString;
        ((ZoneRecommandPreference)localObject).hYL();
      }
      label318:
      AppMethodBeat.o(39103);
      return;
      hYy();
      label329:
      AppMethodBeat.o(39103);
      return;
      label336:
      paramString = null;
      paramq = null;
      localg = null;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MultiStageCitySelectUI
 * JD-Core Version:    0.7.0.1
 */