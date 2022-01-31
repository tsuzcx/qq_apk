package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import java.util.ArrayList;
import java.util.List;

public class MultiStageCitySelectUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  private static List<RegionCodeDecoder.Region> AwD;
  private boolean AwA;
  private boolean AwB;
  private ZoneRecommandPreference AwC;
  private String AwE;
  private Runnable AwF;
  private String Awt;
  private boolean Awu;
  private int Awv;
  private RegionCodeDecoder.Region[] Aww;
  private boolean Awx;
  private boolean Awy;
  private boolean Awz;
  private int cAX;
  private String countryCode;
  private b.a dZA;
  private String eSL;
  private q eiV;
  private String fHT;
  private String fnB;
  private String fnC;
  private d fwu;
  private boolean gzb;
  private ak handler;
  private boolean ogA;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public MultiStageCitySelectUI()
  {
    AppMethodBeat.i(34899);
    this.countryCode = null;
    this.fnC = null;
    this.fnB = null;
    this.fHT = null;
    this.Awt = null;
    this.eSL = null;
    this.Awu = false;
    this.cAX = 0;
    this.Awv = -1;
    this.Awx = false;
    this.Awy = true;
    this.Awz = true;
    this.AwA = false;
    this.AwB = false;
    this.gzb = true;
    this.eiV = new q((byte)0);
    this.handler = new ak(Looper.getMainLooper());
    this.dZA = new MultiStageCitySelectUI.1(this);
    this.AwF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34897);
        MultiStageCitySelectUI.m(MultiStageCitySelectUI.this);
        AppMethodBeat.o(34897);
      }
    };
    AppMethodBeat.o(34899);
  }
  
  private void dNR()
  {
    switch (this.cAX)
    {
    default: 
      return;
    case 2: 
      this.fnB = null;
      return;
    case 1: 
      this.fnC = null;
      return;
    }
    this.countryCode = null;
  }
  
  /* Error */
  private static List<RegionCodeDecoder.Region> dNS()
  {
    // Byte code:
    //   0: ldc 153
    //   2: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 159	com/tencent/mm/storage/RegionCodeDecoder:dyE	()Lcom/tencent/mm/storage/RegionCodeDecoder;
    //   8: astore_0
    //   9: aload_0
    //   10: invokestatic 165	com/tencent/mm/sdk/platformtools/aa:dsG	()Ljava/lang/String;
    //   13: putfield 168	com/tencent/mm/storage/RegionCodeDecoder:yOT	Ljava/lang/String;
    //   16: aload_0
    //   17: invokevirtual 171	com/tencent/mm/storage/RegionCodeDecoder:dyF	()Ljava/lang/String;
    //   20: astore_1
    //   21: aload_1
    //   22: invokestatic 177	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   25: ifeq +43 -> 68
    //   28: ldc 179
    //   30: new 181	java/lang/StringBuilder
    //   33: dup
    //   34: ldc 183
    //   36: invokespecial 186	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: aload_0
    //   40: getfield 168	com/tencent/mm/storage/RegionCodeDecoder:yOT	Ljava/lang/String;
    //   43: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 199	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aconst_null
    //   53: astore_0
    //   54: aload_0
    //   55: invokestatic 177	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   58: ifeq +34 -> 92
    //   61: ldc 153
    //   63: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aconst_null
    //   67: areturn
    //   68: new 181	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   75: getstatic 203	com/tencent/mm/storage/RegionCodeDecoder:yOS	Ljava/lang/String;
    //   78: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_1
    //   82: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore_0
    //   89: goto -35 -> 54
    //   92: new 205	java/util/ArrayList
    //   95: dup
    //   96: invokespecial 206	java/util/ArrayList:<init>	()V
    //   99: astore 6
    //   101: aload_0
    //   102: invokestatic 212	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   105: astore_3
    //   106: new 214	java/io/InputStreamReader
    //   109: dup
    //   110: aload_3
    //   111: invokespecial 217	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   114: astore_2
    //   115: new 219	java/io/BufferedReader
    //   118: dup
    //   119: aload_2
    //   120: invokespecial 222	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   123: astore 4
    //   125: aconst_null
    //   126: astore_1
    //   127: aconst_null
    //   128: astore_0
    //   129: aload 4
    //   131: invokevirtual 225	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   134: astore 5
    //   136: aload 5
    //   138: ifnull +256 -> 394
    //   141: aload 5
    //   143: ldc 227
    //   145: invokevirtual 233	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   148: astore 7
    //   150: new 235	com/tencent/mm/storage/RegionCodeDecoder$Region
    //   153: dup
    //   154: invokespecial 236	com/tencent/mm/storage/RegionCodeDecoder$Region:<init>	()V
    //   157: astore 5
    //   159: aload 7
    //   161: arraylength
    //   162: iconst_2
    //   163: if_icmpne +437 -> 600
    //   166: aload 5
    //   168: aload 7
    //   170: iconst_1
    //   171: aaload
    //   172: invokevirtual 239	com/tencent/mm/storage/RegionCodeDecoder$Region:setName	(Ljava/lang/String;)V
    //   175: aload 7
    //   177: iconst_0
    //   178: aaload
    //   179: ldc 241
    //   181: invokevirtual 233	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   184: astore 7
    //   186: aload 7
    //   188: iconst_0
    //   189: aaload
    //   190: astore 8
    //   192: aload 5
    //   194: aload 8
    //   196: invokevirtual 244	com/tencent/mm/storage/RegionCodeDecoder$Region:setCountryCode	(Ljava/lang/String;)V
    //   199: aload 8
    //   201: invokestatic 177	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   204: ifne -75 -> 129
    //   207: aload 7
    //   209: arraylength
    //   210: iconst_1
    //   211: if_icmpne +44 -> 255
    //   214: aload 5
    //   216: aload 8
    //   218: invokevirtual 247	com/tencent/mm/storage/RegionCodeDecoder$Region:setCode	(Ljava/lang/String;)V
    //   221: aload 5
    //   223: iconst_0
    //   224: invokevirtual 251	com/tencent/mm/storage/RegionCodeDecoder$Region:setProvince	(Z)V
    //   227: aload 5
    //   229: iconst_0
    //   230: invokevirtual 254	com/tencent/mm/storage/RegionCodeDecoder$Region:setCity	(Z)V
    //   233: aload 5
    //   235: iconst_1
    //   236: invokevirtual 257	com/tencent/mm/storage/RegionCodeDecoder$Region:setCountry	(Z)V
    //   239: aload 5
    //   241: astore_1
    //   242: aload 6
    //   244: aload 5
    //   246: invokeinterface 263 2 0
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
    //   268: invokevirtual 247	com/tencent/mm/storage/RegionCodeDecoder$Region:setCode	(Ljava/lang/String;)V
    //   271: aload 5
    //   273: iconst_1
    //   274: invokevirtual 251	com/tencent/mm/storage/RegionCodeDecoder$Region:setProvince	(Z)V
    //   277: aload 5
    //   279: iconst_0
    //   280: invokevirtual 257	com/tencent/mm/storage/RegionCodeDecoder$Region:setCountry	(Z)V
    //   283: aload 5
    //   285: iconst_0
    //   286: invokevirtual 254	com/tencent/mm/storage/RegionCodeDecoder$Region:setCity	(Z)V
    //   289: aload_1
    //   290: ifnull +313 -> 603
    //   293: aload_1
    //   294: invokevirtual 266	com/tencent/mm/storage/RegionCodeDecoder$Region:getCountryCode	()Ljava/lang/String;
    //   297: aload 5
    //   299: invokevirtual 266	com/tencent/mm/storage/RegionCodeDecoder$Region:getCountryCode	()Ljava/lang/String;
    //   302: invokevirtual 269	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   305: ifeq +298 -> 603
    //   308: aload_1
    //   309: iconst_1
    //   310: invokevirtual 272	com/tencent/mm/storage/RegionCodeDecoder$Region:setHasChildren	(Z)V
    //   313: aload 5
    //   315: aload_1
    //   316: invokevirtual 276	com/tencent/mm/storage/RegionCodeDecoder$Region:setParent	(Lcom/tencent/mm/storage/RegionCodeDecoder$Region;)V
    //   319: goto +284 -> 603
    //   322: aload 7
    //   324: arraylength
    //   325: iconst_3
    //   326: if_icmpne +65 -> 391
    //   329: aload 5
    //   331: aload 7
    //   333: iconst_2
    //   334: aaload
    //   335: invokevirtual 247	com/tencent/mm/storage/RegionCodeDecoder$Region:setCode	(Ljava/lang/String;)V
    //   338: aload 5
    //   340: iconst_1
    //   341: invokevirtual 254	com/tencent/mm/storage/RegionCodeDecoder$Region:setCity	(Z)V
    //   344: aload 5
    //   346: iconst_0
    //   347: invokevirtual 257	com/tencent/mm/storage/RegionCodeDecoder$Region:setCountry	(Z)V
    //   350: aload 5
    //   352: iconst_0
    //   353: invokevirtual 251	com/tencent/mm/storage/RegionCodeDecoder$Region:setProvince	(Z)V
    //   356: aload 5
    //   358: iconst_0
    //   359: invokevirtual 272	com/tencent/mm/storage/RegionCodeDecoder$Region:setHasChildren	(Z)V
    //   362: aload_0
    //   363: ifnull +28 -> 391
    //   366: aload_0
    //   367: invokevirtual 279	com/tencent/mm/storage/RegionCodeDecoder$Region:getCode	()Ljava/lang/String;
    //   370: aload 7
    //   372: iconst_1
    //   373: aaload
    //   374: invokevirtual 269	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   377: ifeq +14 -> 391
    //   380: aload 5
    //   382: aload_0
    //   383: invokevirtual 276	com/tencent/mm/storage/RegionCodeDecoder$Region:setParent	(Lcom/tencent/mm/storage/RegionCodeDecoder$Region;)V
    //   386: aload_0
    //   387: iconst_1
    //   388: invokevirtual 272	com/tencent/mm/storage/RegionCodeDecoder$Region:setHasChildren	(Z)V
    //   391: goto -149 -> 242
    //   394: aload_3
    //   395: ifnull +7 -> 402
    //   398: aload_3
    //   399: invokevirtual 284	java/io/InputStream:close	()V
    //   402: aload_2
    //   403: invokevirtual 285	java/io/InputStreamReader:close	()V
    //   406: aload 4
    //   408: invokevirtual 286	java/io/BufferedReader:close	()V
    //   411: ldc 153
    //   413: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   416: aload 6
    //   418: areturn
    //   419: astore_1
    //   420: aconst_null
    //   421: astore_0
    //   422: aconst_null
    //   423: astore_2
    //   424: aconst_null
    //   425: astore_3
    //   426: ldc_w 288
    //   429: aload_1
    //   430: ldc_w 290
    //   433: iconst_1
    //   434: anewarray 292	java/lang/Object
    //   437: dup
    //   438: iconst_0
    //   439: aload_1
    //   440: invokevirtual 295	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   443: aastore
    //   444: invokestatic 299	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   447: aload_3
    //   448: ifnull +7 -> 455
    //   451: aload_3
    //   452: invokevirtual 284	java/io/InputStream:close	()V
    //   455: aload_2
    //   456: ifnull +7 -> 463
    //   459: aload_2
    //   460: invokevirtual 285	java/io/InputStreamReader:close	()V
    //   463: aload_0
    //   464: ifnull -53 -> 411
    //   467: aload_0
    //   468: invokevirtual 286	java/io/BufferedReader:close	()V
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
    //   490: invokevirtual 284	java/io/InputStream:close	()V
    //   493: aload_2
    //   494: ifnull +7 -> 501
    //   497: aload_2
    //   498: invokevirtual 285	java/io/InputStreamReader:close	()V
    //   501: aload_1
    //   502: ifnull +7 -> 509
    //   505: aload_1
    //   506: invokevirtual 286	java/io/BufferedReader:close	()V
    //   509: ldc 153
    //   511: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private void dNT()
  {
    AppMethodBeat.i(34910);
    if (this.AwC != null) {
      this.AwC.dOf();
    }
    AppMethodBeat.o(34910);
  }
  
  public final void dNQ()
  {
    AppMethodBeat.i(34900);
    if (this.cAX == 3) {
      localObject1 = RegionCodeDecoder.dyE().asz("CN");
    }
    for (;;)
    {
      this.Aww = ((RegionCodeDecoder.Region[])localObject1);
      if ((this.Aww != null) && (this.Aww.length > 0)) {
        break;
      }
      ab.e("MicroMsg.MultiStageCitySelectUI", "initZoneItems error ,check zone lists!");
      AppMethodBeat.o(34900);
      return;
      if (bo.isNullOrNil(this.countryCode))
      {
        localObject2 = RegionCodeDecoder.dyE().dyG();
        localObject1 = localObject2;
        if (this.AwA)
        {
          localObject3 = new ArrayList();
          if (localObject2 != null)
          {
            int j = localObject2.length;
            i = 0;
            while (i < j)
            {
              localObject1 = localObject2[i];
              if ((!"CN".equalsIgnoreCase(((RegionCodeDecoder.Region)localObject1).getCode())) && (!"HK".equalsIgnoreCase(((RegionCodeDecoder.Region)localObject1).getCode())) && (!"TW".equalsIgnoreCase(((RegionCodeDecoder.Region)localObject1).getCode())) && (!"MO".equalsIgnoreCase(((RegionCodeDecoder.Region)localObject1).getCode()))) {
                ((List)localObject3).add(localObject1);
              }
              i += 1;
            }
          }
          localObject1 = new RegionCodeDecoder.Region[((List)localObject3).size()];
          ((List)localObject3).toArray((Object[])localObject1);
        }
      }
      else if (bo.isNullOrNil(this.fnC))
      {
        localObject1 = RegionCodeDecoder.dyE().asz(this.countryCode);
      }
      else
      {
        localObject1 = RegionCodeDecoder.dyE().ir(this.countryCode, this.fnC);
      }
    }
    this.screen.removeAll();
    aw.aaz();
    Object localObject1 = (String)c.Ru().get(12324, null);
    aw.aaz();
    Object localObject2 = (String)c.Ru().get(12325, null);
    aw.aaz();
    Object localObject3 = (String)c.Ru().get(12326, null);
    this.Awz = getIntent().getBooleanExtra("ShowSelectedLocation", true);
    int i = 0;
    if (i < this.Aww.length)
    {
      ZonePreference localZonePreference;
      if ((this.Aww[i] != null) && (!bo.isNullOrNil(this.Aww[i].getCode())) && (!bo.isNullOrNil(this.Aww[i].getName())))
      {
        localZonePreference = new ZonePreference(this);
        localZonePreference.a(this.Aww[i]);
        if (!this.Awz) {
          break label569;
        }
        if ((this.cAX != 0) || (!this.Aww[i].getCode().equalsIgnoreCase((String)localObject1))) {
          break label459;
        }
        this.screen.a(localZonePreference, 0);
        localZonePreference.setSummary(2131303186);
      }
      label569:
      for (;;)
      {
        i += 1;
        break;
        label459:
        if ((this.cAX == 1) && (this.Aww[i].getCode().equalsIgnoreCase((String)localObject2)))
        {
          this.screen.a(localZonePreference, 0);
          localZonePreference.setSummary(2131303186);
        }
        else if ((this.cAX == 2) && (this.Aww[i].getCode().equalsIgnoreCase((String)localObject3)))
        {
          this.screen.a(localZonePreference, 0);
          localZonePreference.setSummary(2131303186);
        }
        else
        {
          this.screen.b(localZonePreference);
          continue;
          this.screen.b(localZonePreference);
        }
      }
    }
    if (this.cAX == 3)
    {
      localObject1 = new ZoneSelectOtherCountryPreference(this);
      ((ZoneSelectOtherCountryPreference)localObject1).text = getString(2131303182);
      ((ZoneSelectOtherCountryPreference)localObject1).Ayw = new ZoneSelectOtherCountryPreference.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(34892);
          Intent localIntent = new Intent(MultiStageCitySelectUI.this, MultiStageCitySelectUI.class);
          Bundle localBundle = new Bundle();
          localBundle.putBoolean("GetAddress", MultiStageCitySelectUI.g(MultiStageCitySelectUI.this));
          localBundle.putBoolean("ShowSelectedLocation", MultiStageCitySelectUI.h(MultiStageCitySelectUI.this));
          localBundle.putBoolean("IsSelectNonChinaCountry", true);
          localBundle.putBoolean("IsAutoPosition", false);
          localBundle.putBoolean("IsNeedShowSearchBar", true);
          localIntent.putExtras(localBundle);
          MultiStageCitySelectUI.this.startActivityForResult(localIntent, 1);
          AppMethodBeat.o(34892);
        }
      };
      this.screen.b((Preference)localObject1);
    }
    localObject1 = new PreferenceCategory(getContext());
    this.screen.b((Preference)localObject1);
    if ((this.cAX == 0) || (this.cAX == 3))
    {
      if (this.Awy)
      {
        localObject1 = new PreferenceTitleCategory(this);
        ((PreferenceTitleCategory)localObject1).setTitle(2131303180);
        this.screen.a((Preference)localObject1, 0);
        this.AwC = new ZoneRecommandPreference(this);
        this.AwC.setKey("current_location");
        this.screen.a(this.AwC, 1);
      }
      localObject1 = new PreferenceTitleCategory(this);
      ((PreferenceTitleCategory)localObject1).setTitle(2131303179);
      if (this.Awy)
      {
        this.screen.a((Preference)localObject1, 2);
        AppMethodBeat.o(34900);
        return;
      }
      this.screen.a((Preference)localObject1, 0);
    }
    AppMethodBeat.o(34900);
  }
  
  public int getResourceId()
  {
    return 2130971345;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34905);
    setMMTitle(2131301747);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(34898);
        MultiStageCitySelectUI.n(MultiStageCitySelectUI.this);
        MultiStageCitySelectUI.this.finish();
        AppMethodBeat.o(34898);
        return true;
      }
    });
    this.Awx = getIntent().getBooleanExtra("GetAddress", false);
    this.countryCode = getIntent().getStringExtra("Country");
    this.fnC = getIntent().getStringExtra("Provice");
    this.fHT = getIntent().getStringExtra("CountryName");
    this.Awt = getIntent().getStringExtra("ProviceName");
    Intent localIntent = getIntent();
    boolean bool;
    if (!bo.hl(this))
    {
      bool = true;
      this.Awy = localIntent.getBooleanExtra("IsAutoPosition", bool);
      this.Awu = getIntent().getBooleanExtra("IsRealNameVerifyScene", false);
      this.AwA = getIntent().getBooleanExtra("IsSelectNonChinaCountry", false);
      this.AwB = getIntent().getBooleanExtra("IsNeedShowSearchBar", false);
      ab.i("MicroMsg.MultiStageCitySelectUI", " country = " + this.countryCode + " province =" + this.fnC + " city = " + this.fnB + " " + this.fHT + " " + this.Awt + " " + this.Awu + " " + this.AwA);
      if (!this.Awu) {
        break label299;
      }
      this.cAX = 3;
    }
    for (;;)
    {
      dNQ();
      AppMethodBeat.o(34905);
      return;
      bool = false;
      break;
      label299:
      if (this.countryCode == null)
      {
        this.cAX = 0;
        this.fnC = null;
        this.fnB = null;
      }
      else if (this.fnC == null)
      {
        this.cAX = 1;
        this.fnB = null;
      }
      else
      {
        this.cAX = 2;
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34908);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(34908);
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
    AppMethodBeat.i(34907);
    dNR();
    super.onBackPressed();
    AppMethodBeat.o(34907);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34902);
    super.onCreate(paramBundle);
    aw.Rc().a(665, this);
    this.screen = getPreferenceScreen();
    initView();
    long l;
    if (this.AwB) {
      if ((AwD == null) || (AwD.size() <= 0))
      {
        l = bo.yB();
        paramBundle = RegionCodeDecoder.dyE().dyG();
        if ((paramBundle != null) && (paramBundle.length > 0)) {
          break label108;
        }
      }
    }
    for (;;)
    {
      addSearchMenu(true, this.eiV);
      this.eiV.Axg = new q.b()
      {
        public final void apN()
        {
          AppMethodBeat.i(34893);
          MultiStageCitySelectUI.this.hideVKB();
          MultiStageCitySelectUI.i(MultiStageCitySelectUI.this);
          MultiStageCitySelectUI.this.dNQ();
          AppMethodBeat.o(34893);
        }
        
        public final void apO() {}
        
        public final void apP()
        {
          AppMethodBeat.i(34896);
          MultiStageCitySelectUI.i(MultiStageCitySelectUI.this);
          MultiStageCitySelectUI.this.dNQ();
          AppMethodBeat.o(34896);
        }
        
        public final void apQ() {}
        
        public final boolean wR(String paramAnonymousString)
        {
          AppMethodBeat.i(34895);
          if (!bo.isNullOrNil(paramAnonymousString))
          {
            MultiStageCitySelectUI.a(MultiStageCitySelectUI.this, paramAnonymousString);
            MultiStageCitySelectUI.j(MultiStageCitySelectUI.this).removeAll();
            MultiStageCitySelectUI.l(MultiStageCitySelectUI.this).removeCallbacks(MultiStageCitySelectUI.k(MultiStageCitySelectUI.this));
            MultiStageCitySelectUI.l(MultiStageCitySelectUI.this).postDelayed(MultiStageCitySelectUI.k(MultiStageCitySelectUI.this), 50L);
            AppMethodBeat.o(34895);
            return true;
          }
          AppMethodBeat.o(34895);
          return false;
        }
        
        public final void wS(String paramAnonymousString)
        {
          AppMethodBeat.i(34894);
          if (!bo.isNullOrNil(paramAnonymousString))
          {
            MultiStageCitySelectUI.a(MultiStageCitySelectUI.this, paramAnonymousString);
            MultiStageCitySelectUI.j(MultiStageCitySelectUI.this).removeAll();
            MultiStageCitySelectUI.l(MultiStageCitySelectUI.this).removeCallbacks(MultiStageCitySelectUI.k(MultiStageCitySelectUI.this));
            MultiStageCitySelectUI.l(MultiStageCitySelectUI.this).postDelayed(MultiStageCitySelectUI.k(MultiStageCitySelectUI.this), 50L);
          }
          AppMethodBeat.o(34894);
        }
      };
      AppMethodBeat.o(34902);
      return;
      label108:
      if ((AwD == null) || (AwD.size() <= 0))
      {
        paramBundle = dNS();
        AwD = paramBundle;
        if (paramBundle != null) {
          ab.i("MicroMsg.MultiStageCitySelectUI", "buildAllSearchRegion used %sms, size: %s", new Object[] { Long.valueOf(bo.av(l)), Integer.valueOf(AwD.size()) });
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34904);
    aw.Rc().b(665, this);
    if (this.fwu != null) {
      this.fwu.c(this.dZA);
    }
    super.onDestroy();
    AppMethodBeat.o(34904);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    Object localObject3 = null;
    AppMethodBeat.i(34906);
    Object localObject1;
    label112:
    Object localObject2;
    if ((paramPreference instanceof ZonePreference))
    {
      paramPreference = ((ZonePreference)paramPreference).Ayo;
      if ((paramPreference == null) || (bo.isNullOrNil(paramPreference.getCode())))
      {
        localObject1 = new StringBuilder("onPreferenceTreeClick error item, code:");
        if (paramPreference == null)
        {
          paramf = Integer.valueOf(-1);
          localObject1 = ((StringBuilder)localObject1).append(paramf).append(" ,name:");
          if (paramPreference != null) {
            break label112;
          }
        }
        for (paramf = "null";; paramf = paramPreference.getName())
        {
          ab.e("MicroMsg.MultiStageCitySelectUI", paramf);
          AppMethodBeat.o(34906);
          return false;
          paramf = paramPreference.getCode();
          break;
        }
      }
      if (this.cAX == 3)
      {
        this.countryCode = "CN";
        this.fnC = paramPreference.getCode();
        this.Awt = paramPreference.getName();
      }
      if (this.cAX == 0)
      {
        this.countryCode = paramPreference.getCode();
        this.fHT = paramPreference.getName();
        if (paramPreference.hasChildren()) {
          break label621;
        }
        if (!this.Awx)
        {
          aw.aaz();
          c.Ru().set(12324, this.countryCode);
          aw.aaz();
          c.Ru().set(12325, this.fnC);
          aw.aaz();
          c.Ru().set(12326, this.fnB);
        }
        paramf = new Intent();
        paramf.putExtra("CountryName", this.fHT);
        paramf.putExtra("ProviceName", this.Awt);
        paramf.putExtra("CityName", this.eSL);
        paramf.putExtra("Country", this.countryCode);
        paramf.putExtra("Contact_Province", this.fnC);
        paramf.putExtra("Contact_City", this.fnB);
        hideVKB();
        setResult(-1, paramf);
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(34906);
        return true;
        if (this.cAX == 1)
        {
          this.fnC = paramPreference.getCode();
          this.Awt = paramPreference.getName();
          break;
        }
        if (this.cAX == 2)
        {
          this.fnB = paramPreference.getCode();
          this.eSL = paramPreference.getName();
          if (("CN".equalsIgnoreCase(this.countryCode)) || ("HK".equalsIgnoreCase(this.countryCode)) || ("MO".equalsIgnoreCase(this.countryCode)) || ("TW".equalsIgnoreCase(this.countryCode)))
          {
            this.fHT = null;
            break;
          }
          this.Awt = null;
          break;
        }
        if (this.cAX != 4) {
          break;
        }
        if ((paramPreference.getParent() != null) && (!paramPreference.hasChildren()))
        {
          this.fnB = paramPreference.getCode();
          this.eSL = paramPreference.getName();
          this.fnC = paramPreference.getParent().getCode();
          this.Awt = paramPreference.getParent().getName();
          this.countryCode = paramPreference.getCountryCode();
          this.fHT = null;
          break;
        }
        if ((paramPreference.hasChildren()) && (paramPreference.getParent() != null))
        {
          this.fnC = paramPreference.getCode();
          this.Awt = paramPreference.getName();
          this.countryCode = paramPreference.getCountryCode();
          this.fHT = null;
          break;
        }
        this.countryCode = paramPreference.getCode();
        this.fHT = paramPreference.getName();
        this.fnC = null;
        this.Awt = null;
        this.fnB = null;
        this.eSL = null;
        break;
        label621:
        localObject1 = new Intent(this, MultiStageCitySelectUI.class);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("Country", this.countryCode);
        ((Bundle)localObject2).putString("Provice", this.fnC);
        ((Bundle)localObject2).putString("CountryName", this.fHT);
        ((Bundle)localObject2).putString("ProviceName", this.Awt);
        ((Bundle)localObject2).putBoolean("GetAddress", this.Awx);
        ((Bundle)localObject2).putBoolean("ShowSelectedLocation", this.Awz);
        if (this.Awu)
        {
          paramPreference = paramPreference.getCountryCode();
          paramf = paramPreference;
          if (bo.isNullOrNil(paramPreference)) {
            paramf = this.countryCode;
          }
          if (("CN".equalsIgnoreCase(paramf)) || ("HK".equalsIgnoreCase(paramf)) || ("MO".equalsIgnoreCase(paramf)) || ("TW".equalsIgnoreCase(paramf))) {
            ((Bundle)localObject2).putBoolean("IsNeedShowSearchBar", true);
          }
        }
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        hideVKB();
        startActivityForResult((Intent)localObject1, 1);
      }
    }
    int i;
    RegionCodeDecoder.Region[] arrayOfRegion;
    label893:
    Intent localIntent;
    if (paramPreference.mKey.equals("current_location"))
    {
      if (this.AwC.status != 1) {
        break label1148;
      }
      i = 1;
      if (i != 0)
      {
        paramf = this.AwC;
        arrayOfRegion = new RegionCodeDecoder.Region[3];
        arrayOfRegion[0] = paramf.Ayr;
        arrayOfRegion[1] = paramf.Ays;
        arrayOfRegion[2] = paramf.Ayt;
        aw.aaz();
        paramPreference = c.Ru();
        if (arrayOfRegion[0] != null) {
          break label1153;
        }
        paramf = null;
        paramPreference.set(12324, paramf);
        aw.aaz();
        paramPreference = c.Ru();
        if (arrayOfRegion[1] != null) {
          break label1164;
        }
        paramf = null;
        label918:
        paramPreference.set(12325, paramf);
        aw.aaz();
        paramPreference = c.Ru();
        if (arrayOfRegion[2] != null) {
          break label1175;
        }
        paramf = null;
        label943:
        paramPreference.set(12326, paramf);
        if (arrayOfRegion[0] != null) {
          break label1186;
        }
        localObject1 = null;
        label961:
        if (arrayOfRegion[0] != null) {
          break label1198;
        }
        paramf = null;
        label970:
        if (arrayOfRegion[1] != null) {
          break label1209;
        }
        localObject2 = null;
        label980:
        if (arrayOfRegion[1] != null) {
          break label1221;
        }
        paramPreference = null;
        label989:
        if ((!"CN".equalsIgnoreCase((String)localObject1)) && (!"HK".equalsIgnoreCase((String)localObject1)) && (!"MO".equalsIgnoreCase((String)localObject1)) && (!"TW".equalsIgnoreCase((String)localObject1))) {
          break label1232;
        }
        paramf = null;
        label1035:
        localIntent = new Intent();
        localIntent.putExtra("CountryName", paramf);
        localIntent.putExtra("ProviceName", paramPreference);
        if (arrayOfRegion[2] != null) {
          break label1237;
        }
        paramf = null;
        label1073:
        localIntent.putExtra("CityName", paramf);
        localIntent.putExtra("Country", (String)localObject1);
        localIntent.putExtra("Contact_Province", (String)localObject2);
        if (arrayOfRegion[2] != null) {
          break label1248;
        }
      }
    }
    label1153:
    label1164:
    label1175:
    label1186:
    label1198:
    label1209:
    label1221:
    label1232:
    label1237:
    label1248:
    for (paramf = localObject3;; paramf = arrayOfRegion[2].getCode())
    {
      localIntent.putExtra("Contact_City", paramf);
      hideVKB();
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(34906);
      return false;
      label1148:
      i = 0;
      break;
      paramf = arrayOfRegion[0].getCode();
      break label893;
      paramf = arrayOfRegion[1].getCode();
      break label918;
      paramf = arrayOfRegion[2].getCode();
      break label943;
      localObject1 = arrayOfRegion[0].getCode();
      break label961;
      paramf = arrayOfRegion[0].getName();
      break label970;
      localObject2 = arrayOfRegion[1].getCode();
      break label980;
      paramPreference = arrayOfRegion[1].getName();
      break label989;
      paramPreference = null;
      break label1035;
      paramf = arrayOfRegion[2].getName();
      break label1073;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(34911);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.MultiStageCitySelectUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(34911);
      return;
    }
    ab.i("MicroMsg.MultiStageCitySelectUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    if (paramArrayOfInt.length == 0)
    {
      AppMethodBeat.o(34911);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(34911);
      return;
      if (paramArrayOfInt[0] != 0)
      {
        if (this.AwC != null) {
          this.AwC.dOf();
        }
        this.gzb = false;
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34903);
    super.onResume();
    if (this.gzb)
    {
      boolean bool = b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
      ab.i("MicroMsg.MultiStageCitySelectUI", "settings district,checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        if (this.fwu == null) {
          this.fwu = d.agQ();
        }
        this.fwu.a(this.dZA, true);
      }
    }
    AppMethodBeat.o(34903);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(34909);
    l locall;
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramm.getType() != 665) {
        break label329;
      }
      locall = (l)paramm;
      paramm = locall.country;
      paramString = locall.province;
      localObject = locall.city;
      ab.i("MicroMsg.MultiStageCitySelectUI", "current location country %s, province %s, city %s", new Object[] { paramm, paramString, localObject });
      RegionCodeDecoder.Region[] arrayOfRegion = RegionCodeDecoder.dyE().dyG();
      paramInt2 = arrayOfRegion.length;
      paramInt1 = 0;
      if (paramInt1 >= paramInt2) {
        break label336;
      }
      locall = arrayOfRegion[paramInt1];
      if (locall.getCode().equalsIgnoreCase(paramm))
      {
        arrayOfRegion = RegionCodeDecoder.dyE().asz(locall.getCode());
        paramInt2 = arrayOfRegion.length;
        paramInt1 = 0;
        label136:
        if (paramInt1 < paramInt2)
        {
          paramm = arrayOfRegion[paramInt1];
          if (paramm.getCode().equalsIgnoreCase(paramString))
          {
            arrayOfRegion = RegionCodeDecoder.dyE().ir(locall.getCode(), paramm.getCode());
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
      if ((locall == null) && (paramm == null) && (paramString == null))
      {
        if (this.AwC == null) {
          break label318;
        }
        this.AwC.dOf();
        AppMethodBeat.o(34909);
        return;
        paramInt1 += 1;
        break label183;
        paramString = null;
        continue;
        paramInt1 += 1;
        break label136;
        paramString = null;
        paramm = null;
        continue;
        paramInt1 += 1;
        break;
      }
      if (this.AwC != null)
      {
        localObject = this.AwC;
        ((ZoneRecommandPreference)localObject).status = 1;
        ((ZoneRecommandPreference)localObject).Ayr = locall;
        ((ZoneRecommandPreference)localObject).Ays = paramm;
        ((ZoneRecommandPreference)localObject).Ayt = paramString;
        ((ZoneRecommandPreference)localObject).dOe();
      }
      label318:
      AppMethodBeat.o(34909);
      return;
      dNT();
      label329:
      AppMethodBeat.o(34909);
      return;
      label336:
      paramString = null;
      paramm = null;
      locall = null;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MultiStageCitySelectUI
 * JD-Core Version:    0.7.0.1
 */