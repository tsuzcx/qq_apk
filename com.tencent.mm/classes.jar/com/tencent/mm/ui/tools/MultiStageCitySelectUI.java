package com.tencent.mm.ui.tools;

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
import com.tencent.mm.am.p;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.model.g;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sensitive.d.c;
import com.tencent.mm.sensitive.d.f;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.k;
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
  implements com.tencent.mm.am.h
{
  private static List<RegionCodeDecoder.Region> afJQ;
  private boolean EPk;
  private boolean JYD;
  private String NYS;
  private String afJH;
  private boolean afJI;
  private int afJJ;
  private RegionCodeDecoder.Region[] afJK;
  private boolean afJL;
  private boolean afJM;
  private boolean afJN;
  private boolean afJO;
  private ZoneRecommandPreference afJP;
  private String afJR;
  private ArrayList<String> afJS;
  private Runnable afJT;
  private String cityCode;
  private String countryCode;
  private int hSE;
  private MMHandler handler;
  private s lMw;
  private b.a lsF;
  private boolean mShowSelectedLocation;
  private String oLl;
  private com.tencent.mm.modelgeo.d owr;
  private boolean pUC;
  private String provinceCode;
  private f screen;
  
  public MultiStageCitySelectUI()
  {
    AppMethodBeat.i(39093);
    this.countryCode = null;
    this.provinceCode = null;
    this.cityCode = null;
    this.oLl = null;
    this.afJH = null;
    this.NYS = null;
    this.afJI = false;
    this.hSE = 0;
    this.afJJ = -1;
    this.afJL = false;
    this.afJM = true;
    this.mShowSelectedLocation = true;
    this.afJN = false;
    this.afJO = false;
    this.JYD = false;
    this.pUC = true;
    this.lMw = new s(true);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.lsF = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(250990);
        if (MultiStageCitySelectUI.a(MultiStageCitySelectUI.this) == null)
        {
          AppMethodBeat.o(250990);
          return false;
        }
        if (paramAnonymousBoolean)
        {
          Log.i("MicroMsg.MultiStageCitySelectUI", "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble2) });
          g localg = new g(paramAnonymousFloat2, paramAnonymousFloat1);
          bh.aZW().a(localg, 0);
        }
        for (;;)
        {
          if (MultiStageCitySelectUI.a(MultiStageCitySelectUI.this) != null)
          {
            MultiStageCitySelectUI.a(MultiStageCitySelectUI.this).a(MultiStageCitySelectUI.e(MultiStageCitySelectUI.this));
            MultiStageCitySelectUI.f(MultiStageCitySelectUI.this);
          }
          AppMethodBeat.o(250990);
          return false;
          MultiStageCitySelectUI.b(MultiStageCitySelectUI.this);
          if ((!MultiStageCitySelectUI.c(MultiStageCitySelectUI.this)) && (!com.tencent.mm.modelgeo.d.bJm()))
          {
            MultiStageCitySelectUI.d(MultiStageCitySelectUI.this);
            k.a(MultiStageCitySelectUI.this, MultiStageCitySelectUI.this.getString(R.l.gps_disable_tip), MultiStageCitySelectUI.this.getString(R.l.app_tip), MultiStageCitySelectUI.this.getString(R.l.jump_to_settings), MultiStageCitySelectUI.this.getString(R.l.app_cancel), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(39084);
                com.tencent.mm.modelgeo.d.dP(MultiStageCitySelectUI.this);
                AppMethodBeat.o(39084);
              }
            }, null);
          }
        }
      }
    };
    this.afJT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(250996);
        MultiStageCitySelectUI.n(MultiStageCitySelectUI.this);
        AppMethodBeat.o(250996);
      }
    };
    AppMethodBeat.o(39093);
  }
  
  private void jDf()
  {
    switch (this.hSE)
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
  private static List<RegionCodeDecoder.Region> jDg()
  {
    // Byte code:
    //   0: ldc 172
    //   2: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 178	com/tencent/mm/storage/RegionCodeDecoder:jcF	()Lcom/tencent/mm/storage/RegionCodeDecoder;
    //   8: astore_0
    //   9: aload_0
    //   10: invokestatic 184	com/tencent/mm/sdk/platformtools/LocaleUtil:getApplicationLanguage	()Ljava/lang/String;
    //   13: putfield 187	com/tencent/mm/storage/RegionCodeDecoder:adls	Ljava/lang/String;
    //   16: aload_0
    //   17: invokevirtual 190	com/tencent/mm/storage/RegionCodeDecoder:jcG	()Ljava/lang/String;
    //   20: astore_1
    //   21: aload_1
    //   22: invokestatic 196	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   25: ifeq +43 -> 68
    //   28: ldc 198
    //   30: new 200	java/lang/StringBuilder
    //   33: dup
    //   34: ldc 202
    //   36: invokespecial 205	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: aload_0
    //   40: getfield 187	com/tencent/mm/storage/RegionCodeDecoder:adls	Ljava/lang/String;
    //   43: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aconst_null
    //   53: astore_0
    //   54: aload_0
    //   55: invokestatic 196	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   58: ifeq +34 -> 92
    //   61: ldc 172
    //   63: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aconst_null
    //   67: areturn
    //   68: new 200	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   75: getstatic 221	com/tencent/mm/storage/RegionCodeDecoder:adlr	Ljava/lang/String;
    //   78: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_1
    //   82: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore_0
    //   89: goto -35 -> 54
    //   92: new 223	java/util/ArrayList
    //   95: dup
    //   96: invokespecial 224	java/util/ArrayList:<init>	()V
    //   99: astore 6
    //   101: aload_0
    //   102: invokestatic 230	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   105: astore_3
    //   106: new 232	java/io/InputStreamReader
    //   109: dup
    //   110: aload_3
    //   111: invokespecial 235	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   114: astore_2
    //   115: new 237	java/io/BufferedReader
    //   118: dup
    //   119: aload_2
    //   120: invokespecial 240	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   123: astore 4
    //   125: aconst_null
    //   126: astore_1
    //   127: aconst_null
    //   128: astore_0
    //   129: aload 4
    //   131: invokevirtual 243	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   134: astore 5
    //   136: aload 5
    //   138: ifnull +257 -> 395
    //   141: aload 5
    //   143: ldc 245
    //   145: invokevirtual 251	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   148: astore 7
    //   150: new 253	com/tencent/mm/storage/RegionCodeDecoder$Region
    //   153: dup
    //   154: invokespecial 254	com/tencent/mm/storage/RegionCodeDecoder$Region:<init>	()V
    //   157: astore 5
    //   159: aload 7
    //   161: arraylength
    //   162: iconst_2
    //   163: if_icmpne +438 -> 601
    //   166: aload 5
    //   168: aload 7
    //   170: iconst_1
    //   171: aaload
    //   172: invokevirtual 257	com/tencent/mm/storage/RegionCodeDecoder$Region:setName	(Ljava/lang/String;)V
    //   175: aload 7
    //   177: iconst_0
    //   178: aaload
    //   179: ldc_w 259
    //   182: invokevirtual 251	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   185: astore 7
    //   187: aload 7
    //   189: iconst_0
    //   190: aaload
    //   191: astore 8
    //   193: aload 5
    //   195: aload 8
    //   197: invokevirtual 262	com/tencent/mm/storage/RegionCodeDecoder$Region:setCountryCode	(Ljava/lang/String;)V
    //   200: aload 8
    //   202: invokestatic 196	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   205: ifne -76 -> 129
    //   208: aload 7
    //   210: arraylength
    //   211: iconst_1
    //   212: if_icmpne +44 -> 256
    //   215: aload 5
    //   217: aload 8
    //   219: invokevirtual 265	com/tencent/mm/storage/RegionCodeDecoder$Region:setCode	(Ljava/lang/String;)V
    //   222: aload 5
    //   224: iconst_0
    //   225: invokevirtual 268	com/tencent/mm/storage/RegionCodeDecoder$Region:setProvince	(Z)V
    //   228: aload 5
    //   230: iconst_0
    //   231: invokevirtual 271	com/tencent/mm/storage/RegionCodeDecoder$Region:setCity	(Z)V
    //   234: aload 5
    //   236: iconst_1
    //   237: invokevirtual 274	com/tencent/mm/storage/RegionCodeDecoder$Region:setCountry	(Z)V
    //   240: aload 5
    //   242: astore_1
    //   243: aload 6
    //   245: aload 5
    //   247: invokeinterface 280 2 0
    //   252: pop
    //   253: goto +348 -> 601
    //   256: aload 7
    //   258: arraylength
    //   259: iconst_2
    //   260: if_icmpne +63 -> 323
    //   263: aload 5
    //   265: aload 7
    //   267: iconst_1
    //   268: aaload
    //   269: invokevirtual 265	com/tencent/mm/storage/RegionCodeDecoder$Region:setCode	(Ljava/lang/String;)V
    //   272: aload 5
    //   274: iconst_1
    //   275: invokevirtual 268	com/tencent/mm/storage/RegionCodeDecoder$Region:setProvince	(Z)V
    //   278: aload 5
    //   280: iconst_0
    //   281: invokevirtual 274	com/tencent/mm/storage/RegionCodeDecoder$Region:setCountry	(Z)V
    //   284: aload 5
    //   286: iconst_0
    //   287: invokevirtual 271	com/tencent/mm/storage/RegionCodeDecoder$Region:setCity	(Z)V
    //   290: aload_1
    //   291: ifnull +313 -> 604
    //   294: aload_1
    //   295: invokevirtual 283	com/tencent/mm/storage/RegionCodeDecoder$Region:getCountryCode	()Ljava/lang/String;
    //   298: aload 5
    //   300: invokevirtual 283	com/tencent/mm/storage/RegionCodeDecoder$Region:getCountryCode	()Ljava/lang/String;
    //   303: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   306: ifeq +298 -> 604
    //   309: aload_1
    //   310: iconst_1
    //   311: invokevirtual 289	com/tencent/mm/storage/RegionCodeDecoder$Region:setHasChildren	(Z)V
    //   314: aload 5
    //   316: aload_1
    //   317: invokevirtual 293	com/tencent/mm/storage/RegionCodeDecoder$Region:setParent	(Lcom/tencent/mm/storage/RegionCodeDecoder$Region;)V
    //   320: goto +284 -> 604
    //   323: aload 7
    //   325: arraylength
    //   326: iconst_3
    //   327: if_icmpne +65 -> 392
    //   330: aload 5
    //   332: aload 7
    //   334: iconst_2
    //   335: aaload
    //   336: invokevirtual 265	com/tencent/mm/storage/RegionCodeDecoder$Region:setCode	(Ljava/lang/String;)V
    //   339: aload 5
    //   341: iconst_1
    //   342: invokevirtual 271	com/tencent/mm/storage/RegionCodeDecoder$Region:setCity	(Z)V
    //   345: aload 5
    //   347: iconst_0
    //   348: invokevirtual 274	com/tencent/mm/storage/RegionCodeDecoder$Region:setCountry	(Z)V
    //   351: aload 5
    //   353: iconst_0
    //   354: invokevirtual 268	com/tencent/mm/storage/RegionCodeDecoder$Region:setProvince	(Z)V
    //   357: aload 5
    //   359: iconst_0
    //   360: invokevirtual 289	com/tencent/mm/storage/RegionCodeDecoder$Region:setHasChildren	(Z)V
    //   363: aload_0
    //   364: ifnull +28 -> 392
    //   367: aload_0
    //   368: invokevirtual 296	com/tencent/mm/storage/RegionCodeDecoder$Region:getCode	()Ljava/lang/String;
    //   371: aload 7
    //   373: iconst_1
    //   374: aaload
    //   375: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   378: ifeq +14 -> 392
    //   381: aload 5
    //   383: aload_0
    //   384: invokevirtual 293	com/tencent/mm/storage/RegionCodeDecoder$Region:setParent	(Lcom/tencent/mm/storage/RegionCodeDecoder$Region;)V
    //   387: aload_0
    //   388: iconst_1
    //   389: invokevirtual 289	com/tencent/mm/storage/RegionCodeDecoder$Region:setHasChildren	(Z)V
    //   392: goto -149 -> 243
    //   395: aload_3
    //   396: ifnull +7 -> 403
    //   399: aload_3
    //   400: invokevirtual 301	java/io/InputStream:close	()V
    //   403: aload_2
    //   404: invokevirtual 302	java/io/InputStreamReader:close	()V
    //   407: aload 4
    //   409: invokevirtual 303	java/io/BufferedReader:close	()V
    //   412: ldc 172
    //   414: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   417: aload 6
    //   419: areturn
    //   420: astore_1
    //   421: aconst_null
    //   422: astore_0
    //   423: aconst_null
    //   424: astore_2
    //   425: aconst_null
    //   426: astore_3
    //   427: ldc_w 305
    //   430: aload_1
    //   431: ldc_w 307
    //   434: iconst_1
    //   435: anewarray 309	java/lang/Object
    //   438: dup
    //   439: iconst_0
    //   440: aload_1
    //   441: invokevirtual 312	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   444: aastore
    //   445: invokestatic 316	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   448: aload_3
    //   449: ifnull +7 -> 456
    //   452: aload_3
    //   453: invokevirtual 301	java/io/InputStream:close	()V
    //   456: aload_2
    //   457: ifnull +7 -> 464
    //   460: aload_2
    //   461: invokevirtual 302	java/io/InputStreamReader:close	()V
    //   464: aload_0
    //   465: ifnull -53 -> 412
    //   468: aload_0
    //   469: invokevirtual 303	java/io/BufferedReader:close	()V
    //   472: goto -60 -> 412
    //   475: astore_0
    //   476: goto -64 -> 412
    //   479: astore_0
    //   480: aconst_null
    //   481: astore_1
    //   482: aconst_null
    //   483: astore_2
    //   484: aconst_null
    //   485: astore_3
    //   486: aload_3
    //   487: ifnull +7 -> 494
    //   490: aload_3
    //   491: invokevirtual 301	java/io/InputStream:close	()V
    //   494: aload_2
    //   495: ifnull +7 -> 502
    //   498: aload_2
    //   499: invokevirtual 302	java/io/InputStreamReader:close	()V
    //   502: aload_1
    //   503: ifnull +7 -> 510
    //   506: aload_1
    //   507: invokevirtual 303	java/io/BufferedReader:close	()V
    //   510: ldc 172
    //   512: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   515: aload_0
    //   516: athrow
    //   517: astore_0
    //   518: goto -115 -> 403
    //   521: astore_0
    //   522: goto -115 -> 407
    //   525: astore_0
    //   526: goto -114 -> 412
    //   529: astore_1
    //   530: goto -74 -> 456
    //   533: astore_1
    //   534: goto -70 -> 464
    //   537: astore_3
    //   538: goto -44 -> 494
    //   541: astore_2
    //   542: goto -40 -> 502
    //   545: astore_1
    //   546: goto -36 -> 510
    //   549: astore_0
    //   550: aconst_null
    //   551: astore_1
    //   552: aconst_null
    //   553: astore_2
    //   554: goto -68 -> 486
    //   557: astore_0
    //   558: aconst_null
    //   559: astore_1
    //   560: goto -74 -> 486
    //   563: astore_0
    //   564: aload 4
    //   566: astore_1
    //   567: goto -81 -> 486
    //   570: astore 4
    //   572: aload_0
    //   573: astore_1
    //   574: aload 4
    //   576: astore_0
    //   577: goto -91 -> 486
    //   580: astore_1
    //   581: aconst_null
    //   582: astore_0
    //   583: aconst_null
    //   584: astore_2
    //   585: goto -158 -> 427
    //   588: astore_1
    //   589: aconst_null
    //   590: astore_0
    //   591: goto -164 -> 427
    //   594: astore_1
    //   595: aload 4
    //   597: astore_0
    //   598: goto -171 -> 427
    //   601: goto -472 -> 129
    //   604: aload 5
    //   606: astore_0
    //   607: goto -364 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   8	461	0	localObject1	Object
    //   475	1	0	localIOException1	java.io.IOException
    //   479	37	0	localObject2	Object
    //   517	1	0	localIOException2	java.io.IOException
    //   521	1	0	localIOException3	java.io.IOException
    //   525	1	0	localIOException4	java.io.IOException
    //   549	1	0	localObject3	Object
    //   557	1	0	localObject4	Object
    //   563	10	0	localObject5	Object
    //   576	31	0	localObject6	Object
    //   20	297	1	localObject7	Object
    //   420	21	1	localException1	java.lang.Exception
    //   481	26	1	localObject8	Object
    //   529	1	1	localIOException5	java.io.IOException
    //   533	1	1	localIOException6	java.io.IOException
    //   545	1	1	localIOException7	java.io.IOException
    //   551	23	1	localObject9	Object
    //   580	1	1	localException2	java.lang.Exception
    //   588	1	1	localException3	java.lang.Exception
    //   594	1	1	localException4	java.lang.Exception
    //   114	385	2	localInputStreamReader	java.io.InputStreamReader
    //   541	1	2	localIOException8	java.io.IOException
    //   553	32	2	localObject10	Object
    //   105	386	3	localInputStream	java.io.InputStream
    //   537	1	3	localIOException9	java.io.IOException
    //   123	442	4	localBufferedReader	java.io.BufferedReader
    //   570	26	4	localObject11	Object
    //   134	471	5	localObject12	Object
    //   99	319	6	localArrayList	ArrayList
    //   148	224	7	arrayOfString	String[]
    //   191	27	8	str	String
    // Exception table:
    //   from	to	target	type
    //   101	106	420	java/lang/Exception
    //   468	472	475	java/io/IOException
    //   101	106	479	finally
    //   399	403	517	java/io/IOException
    //   403	407	521	java/io/IOException
    //   407	412	525	java/io/IOException
    //   452	456	529	java/io/IOException
    //   460	464	533	java/io/IOException
    //   490	494	537	java/io/IOException
    //   498	502	541	java/io/IOException
    //   506	510	545	java/io/IOException
    //   106	115	549	finally
    //   115	125	557	finally
    //   129	136	563	finally
    //   141	187	563	finally
    //   193	240	563	finally
    //   243	253	563	finally
    //   256	290	563	finally
    //   294	320	563	finally
    //   323	363	563	finally
    //   367	392	563	finally
    //   427	448	570	finally
    //   106	115	580	java/lang/Exception
    //   115	125	588	java/lang/Exception
    //   129	136	594	java/lang/Exception
    //   141	187	594	java/lang/Exception
    //   193	240	594	java/lang/Exception
    //   243	253	594	java/lang/Exception
    //   256	290	594	java/lang/Exception
    //   294	320	594	java/lang/Exception
    //   323	363	594	java/lang/Exception
    //   367	392	594	java/lang/Exception
  }
  
  private void jDh()
  {
    AppMethodBeat.i(39104);
    if (this.afJP != null) {
      this.afJP.jDv();
    }
    AppMethodBeat.o(39104);
  }
  
  public int getResourceId()
  {
    return R.i.gpj;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39099);
    setMMTitle(R.l.gOn);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(250995);
        MultiStageCitySelectUI.o(MultiStageCitySelectUI.this);
        MultiStageCitySelectUI.this.finish();
        AppMethodBeat.o(250995);
        return true;
      }
    });
    this.afJL = getIntent().getBooleanExtra("GetAddress", false);
    this.countryCode = getIntent().getStringExtra("Country");
    this.provinceCode = getIntent().getStringExtra("Provice");
    this.oLl = getIntent().getStringExtra("CountryName");
    this.afJH = getIntent().getStringExtra("ProviceName");
    Intent localIntent = getIntent();
    boolean bool;
    if (!Util.isOverseasUser(this))
    {
      bool = true;
      this.afJM = localIntent.getBooleanExtra("IsAutoPosition", bool);
      this.afJI = getIntent().getBooleanExtra("IsRealNameVerifyScene", false);
      this.afJO = getIntent().getBooleanExtra("IsSelectNonChinaCountry", false);
      this.afJS = getIntent().getStringArrayListExtra("BlockedCountries");
      if (this.afJS == null) {
        this.afJS = new ArrayList();
      }
      this.JYD = getIntent().getBooleanExtra("IsNeedShowSearchBar", false);
      Log.i("MicroMsg.MultiStageCitySelectUI", " country = " + this.countryCode + " province =" + this.provinceCode + " city = " + this.cityCode + " " + this.oLl + " " + this.afJH + " " + this.afJI + " " + this.afJO);
      if (!this.afJI) {
        break label331;
      }
      this.hSE = 3;
    }
    for (;;)
    {
      jDe();
      AppMethodBeat.o(39099);
      return;
      bool = false;
      break;
      label331:
      if (this.countryCode == null)
      {
        this.hSE = 0;
        this.provinceCode = null;
        this.cityCode = null;
      }
      else if (this.provinceCode == null)
      {
        this.hSE = 1;
        this.cityCode = null;
      }
      else
      {
        this.hSE = 2;
      }
    }
  }
  
  public final void jDe()
  {
    AppMethodBeat.i(39094);
    Object localObject2;
    int j;
    int i;
    Object localObject3;
    if (this.hSE == 3)
    {
      localObject1 = new ArrayList();
      localObject2 = RegionCodeDecoder.jcF().jcH();
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
      localObject2 = RegionCodeDecoder.jcF().byI("CN");
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
      localObject2 = RegionCodeDecoder.jcF().jcH();
      if (this.afJO)
      {
        localObject3 = new ArrayList();
        if (localObject2 != null)
        {
          j = localObject2.length;
          i = 0;
          while (i < j)
          {
            localObject1 = localObject2[i];
            if ((!this.afJS.contains(((RegionCodeDecoder.Region)localObject1).getCode())) && (!"CN".equalsIgnoreCase(((RegionCodeDecoder.Region)localObject1).getCode())) && (!"HK".equalsIgnoreCase(((RegionCodeDecoder.Region)localObject1).getCode())) && (!"TW".equalsIgnoreCase(((RegionCodeDecoder.Region)localObject1).getCode())) && (!"MO".equalsIgnoreCase(((RegionCodeDecoder.Region)localObject1).getCode()))) {
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
      this.afJK = ((RegionCodeDecoder.Region[])localObject1);
      if ((this.afJK != null) && (this.afJK.length > 0)) {
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
          if (!this.afJS.contains(((RegionCodeDecoder.Region)localObject1).getCode())) {
            ((List)localObject3).add(localObject1);
          }
          i += 1;
        }
        localObject1 = new RegionCodeDecoder.Region[((List)localObject3).size()];
        ((List)localObject3).toArray((Object[])localObject1);
        continue;
        if (Util.isNullOrNil(this.provinceCode)) {
          localObject1 = RegionCodeDecoder.jcF().byI(this.countryCode);
        } else {
          localObject1 = RegionCodeDecoder.jcF().pN(this.countryCode, this.provinceCode);
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
      this.afJN = getIntent().getBooleanExtra("NeedUnshowItem", false);
      if (this.afJN)
      {
        localZonePreference = new ZonePreference(this);
        RegionCodeDecoder.Region localRegion = new RegionCodeDecoder.Region();
        localRegion.setName(getString(R.l.finder_settings_unshow));
        localRegion.setHasChildren(false);
        localRegion.setCountry(false);
        localRegion.setCode("unshow");
        localZonePreference.a(localRegion);
        this.screen.c(localZonePreference);
        if ("unshow".equals(localObject1)) {
          localZonePreference.aBk(R.l.setting_zone_selected);
        }
      }
      i = 0;
      label694:
      if (i >= this.afJK.length) {
        break label1003;
      }
      if ((this.afJK[i] != null) && (!Util.isNullOrNil(this.afJK[i].getCode())) && (!Util.isNullOrNil(this.afJK[i].getName())))
      {
        localZonePreference = new ZonePreference(this);
        localZonePreference.a(this.afJK[i]);
        if (!this.mShowSelectedLocation) {
          break label989;
        }
        if ((this.hSE != 0) || (!this.afJK[i].getCode().equalsIgnoreCase((String)localObject1))) {
          break label879;
        }
        this.screen.a(localZonePreference, 0);
        localZonePreference.aBk(R.l.setting_zone_selected_location);
      }
    }
    label989:
    for (;;)
    {
      i += 1;
      break label694;
      bh.bCz();
      localObject1 = (String)c.ban().d(12324, null);
      bh.bCz();
      localObject2 = (String)c.ban().d(12325, null);
      bh.bCz();
      localObject3 = (String)c.ban().d(12326, null);
      break;
      label879:
      if ((this.hSE == 1) && (this.afJK[i].getCode().equalsIgnoreCase((String)localObject2)))
      {
        this.screen.a(localZonePreference, 0);
        localZonePreference.aBk(R.l.setting_zone_selected_location);
      }
      else if ((this.hSE == 2) && (this.afJK[i].getCode().equalsIgnoreCase((String)localObject3)))
      {
        this.screen.a(localZonePreference, 0);
        localZonePreference.aBk(R.l.setting_zone_selected_location);
      }
      else
      {
        this.screen.c(localZonePreference);
        continue;
        this.screen.c(localZonePreference);
      }
    }
    label1003:
    if (this.hSE == 3)
    {
      localObject1 = new ZoneSelectOtherCountryPreference(this);
      ((ZoneSelectOtherCountryPreference)localObject1).text = getString(R.l.setting_zone_non_china_mainland);
      ((ZoneSelectOtherCountryPreference)localObject1).afLW = new ZoneSelectOtherCountryPreference.a()
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
      this.screen.c((Preference)localObject1);
    }
    Object localObject1 = new PreferenceCategory(getContext());
    this.screen.c((Preference)localObject1);
    if ((this.hSE == 0) || (this.hSE == 3))
    {
      if (this.afJM)
      {
        localObject1 = new PreferenceTitleCategory(this);
        ((PreferenceTitleCategory)localObject1).setTitle(R.l.setting_zone_category_get_location);
        this.screen.a((Preference)localObject1, 0);
        this.afJP = new ZoneRecommandPreference(this);
        this.afJP.setKey("current_location");
        this.screen.a(this.afJP, 1);
      }
      localObject1 = new PreferenceTitleCategory(this);
      ((PreferenceTitleCategory)localObject1).setTitle(R.l.setting_zone_category_all_locations);
      if (this.afJM)
      {
        this.screen.a((Preference)localObject1, 2);
        AppMethodBeat.o(39094);
        return;
      }
      this.screen.a((Preference)localObject1, 0);
    }
    AppMethodBeat.o(39094);
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
    jDf();
    super.onBackPressed();
    AppMethodBeat.o(39101);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39096);
    super.onCreate(paramBundle);
    bh.aZW().a(665, this);
    this.screen = getPreferenceScreen();
    initView();
    long l;
    if (this.JYD) {
      if ((afJQ == null) || (afJQ.size() <= 0))
      {
        l = Util.currentTicks();
        paramBundle = RegionCodeDecoder.jcF().jcH();
        if ((paramBundle != null) && (paramBundle.length > 0)) {
          break label108;
        }
      }
    }
    for (;;)
    {
      addSearchMenu(true, this.lMw);
      this.lMw.afKz = new s.c()
      {
        public final boolean SN(String paramAnonymousString)
        {
          AppMethodBeat.i(251010);
          if (!Util.isNullOrNil(paramAnonymousString))
          {
            MultiStageCitySelectUI.a(MultiStageCitySelectUI.this, paramAnonymousString);
            MultiStageCitySelectUI.k(MultiStageCitySelectUI.this).removeAll();
            MultiStageCitySelectUI.m(MultiStageCitySelectUI.this).removeCallbacks(MultiStageCitySelectUI.l(MultiStageCitySelectUI.this));
            MultiStageCitySelectUI.m(MultiStageCitySelectUI.this).postDelayed(MultiStageCitySelectUI.l(MultiStageCitySelectUI.this), 50L);
            AppMethodBeat.o(251010);
            return true;
          }
          AppMethodBeat.o(251010);
          return false;
        }
        
        public final void SO(String paramAnonymousString)
        {
          AppMethodBeat.i(251005);
          if (!Util.isNullOrNil(paramAnonymousString))
          {
            MultiStageCitySelectUI.a(MultiStageCitySelectUI.this, paramAnonymousString);
            MultiStageCitySelectUI.k(MultiStageCitySelectUI.this).removeAll();
            MultiStageCitySelectUI.m(MultiStageCitySelectUI.this).removeCallbacks(MultiStageCitySelectUI.l(MultiStageCitySelectUI.this));
            MultiStageCitySelectUI.m(MultiStageCitySelectUI.this).postDelayed(MultiStageCitySelectUI.l(MultiStageCitySelectUI.this), 50L);
          }
          AppMethodBeat.o(251005);
        }
        
        public final void bWw()
        {
          AppMethodBeat.i(251001);
          MultiStageCitySelectUI.this.hideVKB();
          MultiStageCitySelectUI.j(MultiStageCitySelectUI.this);
          MultiStageCitySelectUI.this.jDe();
          AppMethodBeat.o(251001);
        }
        
        public final void bWx() {}
        
        public final void bWy()
        {
          AppMethodBeat.i(251012);
          MultiStageCitySelectUI.j(MultiStageCitySelectUI.this);
          MultiStageCitySelectUI.this.jDe();
          AppMethodBeat.o(251012);
        }
        
        public final void bWz() {}
      };
      AppMethodBeat.o(39096);
      return;
      label108:
      if ((afJQ == null) || (afJQ.size() <= 0))
      {
        paramBundle = jDg();
        afJQ = paramBundle;
        if (paramBundle != null) {
          Log.i("MicroMsg.MultiStageCitySelectUI", "buildAllSearchRegion used %sms, size: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(afJQ.size()) });
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39098);
    bh.aZW().b(665, this);
    if (this.owr != null) {
      this.owr.a(this.lsF);
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
      localObject1 = ((ZonePreference)paramPreference).afLO;
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
      if (this.hSE == 3)
      {
        this.countryCode = "CN";
        this.provinceCode = ((RegionCodeDecoder.Region)localObject1).getCode();
        this.afJH = ((RegionCodeDecoder.Region)localObject1).getName();
      }
      if (this.hSE == 0)
      {
        this.countryCode = ((RegionCodeDecoder.Region)localObject1).getCode();
        this.oLl = ((RegionCodeDecoder.Region)localObject1).getName();
        if (((RegionCodeDecoder.Region)localObject1).hasChildren()) {
          break label652;
        }
        if (!this.afJL)
        {
          bh.bCz();
          c.ban().B(12324, this.countryCode);
          bh.bCz();
          c.ban().B(12325, this.provinceCode);
          bh.bCz();
          c.ban().B(12326, this.cityCode);
          l.kK(4, 5);
        }
        paramf = new Intent();
        paramf.putExtra("CountryName", this.oLl);
        paramf.putExtra("ProviceName", this.afJH);
        paramf.putExtra("CityName", this.NYS);
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
        if (this.hSE == 1)
        {
          this.provinceCode = ((RegionCodeDecoder.Region)localObject1).getCode();
          this.afJH = ((RegionCodeDecoder.Region)localObject1).getName();
          break;
        }
        if (this.hSE == 2)
        {
          this.cityCode = ((RegionCodeDecoder.Region)localObject1).getCode();
          this.NYS = ((RegionCodeDecoder.Region)localObject1).getName();
          if (("CN".equalsIgnoreCase(this.countryCode)) || ("HK".equalsIgnoreCase(this.countryCode)) || ("MO".equalsIgnoreCase(this.countryCode)) || ("TW".equalsIgnoreCase(this.countryCode)))
          {
            this.oLl = null;
            break;
          }
          this.afJH = null;
          break;
        }
        if (this.hSE != 4) {
          break;
        }
        if ((((RegionCodeDecoder.Region)localObject1).getParent() != null) && (!((RegionCodeDecoder.Region)localObject1).hasChildren()))
        {
          this.cityCode = ((RegionCodeDecoder.Region)localObject1).getCode();
          this.NYS = ((RegionCodeDecoder.Region)localObject1).getName();
          this.provinceCode = ((RegionCodeDecoder.Region)localObject1).getParent().getCode();
          this.afJH = ((RegionCodeDecoder.Region)localObject1).getParent().getName();
          this.countryCode = ((RegionCodeDecoder.Region)localObject1).getCountryCode();
          this.oLl = null;
          break;
        }
        if ((((RegionCodeDecoder.Region)localObject1).hasChildren()) && (((RegionCodeDecoder.Region)localObject1).getParent() != null))
        {
          this.provinceCode = ((RegionCodeDecoder.Region)localObject1).getCode();
          this.afJH = ((RegionCodeDecoder.Region)localObject1).getName();
          this.countryCode = ((RegionCodeDecoder.Region)localObject1).getCountryCode();
          this.oLl = null;
          break;
        }
        this.countryCode = ((RegionCodeDecoder.Region)localObject1).getCode();
        this.oLl = ((RegionCodeDecoder.Region)localObject1).getName();
        this.provinceCode = null;
        this.afJH = null;
        this.cityCode = null;
        this.NYS = null;
        break;
        label652:
        localObject2 = new Intent(this, MultiStageCitySelectUI.class);
        localBundle = new Bundle();
        localBundle.putString("Country", this.countryCode);
        localBundle.putString("Provice", this.provinceCode);
        localBundle.putString("CountryName", this.oLl);
        localBundle.putString("ProviceName", this.afJH);
        localBundle.putBoolean("GetAddress", this.afJL);
        localBundle.putBoolean("ShowSelectedLocation", this.mShowSelectedLocation);
        localBundle.putString("SelectedCountryCode", getIntent().getStringExtra("SelectedCountryCode"));
        localBundle.putString("SelectedProvinceCode", getIntent().getStringExtra("SelectedProvinceCode"));
        localBundle.putString("SelectedCityCode", getIntent().getStringExtra("SelectedCityCode"));
        if (this.afJI)
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
    label1052:
    label1077:
    label1102:
    label1125:
    label1134:
    label1144:
    Intent localIntent;
    if (paramPreference.mKey.equals("current_location"))
    {
      if (this.afJP.status != 1) {
        break label1312;
      }
      i = 1;
      if (i != 0)
      {
        paramf = this.afJP;
        arrayOfRegion = new RegionCodeDecoder.Region[3];
        arrayOfRegion[0] = paramf.afLR;
        arrayOfRegion[1] = paramf.afLS;
        arrayOfRegion[2] = paramf.afLT;
        if (!this.afJL)
        {
          bh.bCz();
          paramPreference = c.ban();
          if (arrayOfRegion[0] != null) {
            break label1317;
          }
          paramf = null;
          paramPreference.B(12324, paramf);
          bh.bCz();
          paramPreference = c.ban();
          if (arrayOfRegion[1] != null) {
            break label1328;
          }
          paramf = null;
          paramPreference.B(12325, paramf);
          bh.bCz();
          paramPreference = c.ban();
          if (arrayOfRegion[2] != null) {
            break label1339;
          }
          paramf = null;
          paramPreference.B(12326, paramf);
          l.kK(4, 5);
        }
        if (arrayOfRegion[0] != null) {
          break label1350;
        }
        localObject1 = null;
        if (arrayOfRegion[0] != null) {
          break label1362;
        }
        paramf = null;
        if (arrayOfRegion[1] != null) {
          break label1373;
        }
        localObject2 = null;
        if (arrayOfRegion[1] != null) {
          break label1385;
        }
        paramPreference = null;
        label1153:
        if ((!"CN".equalsIgnoreCase((String)localObject1)) && (!"HK".equalsIgnoreCase((String)localObject1)) && (!"MO".equalsIgnoreCase((String)localObject1)) && (!"TW".equalsIgnoreCase((String)localObject1))) {
          break label1396;
        }
        paramf = null;
        label1199:
        localIntent = new Intent();
        localIntent.putExtra("CountryName", paramf);
        localIntent.putExtra("ProviceName", paramPreference);
        if (arrayOfRegion[2] != null) {
          break label1401;
        }
        paramf = null;
        label1237:
        localIntent.putExtra("CityName", paramf);
        localIntent.putExtra("Country", (String)localObject1);
        localIntent.putExtra("Contact_Province", (String)localObject2);
        if (arrayOfRegion[2] != null) {
          break label1412;
        }
      }
    }
    label1412:
    for (paramf = localBundle;; paramf = arrayOfRegion[2].getCode())
    {
      localIntent.putExtra("Contact_City", paramf);
      hideVKB();
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(39100);
      return false;
      label1312:
      i = 0;
      break;
      label1317:
      paramf = arrayOfRegion[0].getCode();
      break label1052;
      label1328:
      paramf = arrayOfRegion[1].getCode();
      break label1077;
      label1339:
      paramf = arrayOfRegion[2].getCode();
      break label1102;
      label1350:
      localObject1 = arrayOfRegion[0].getCode();
      break label1125;
      label1362:
      paramf = arrayOfRegion[0].getName();
      break label1134;
      label1373:
      localObject2 = arrayOfRegion[1].getCode();
      break label1144;
      label1385:
      paramPreference = arrayOfRegion[1].getName();
      break label1153;
      label1396:
      paramPreference = null;
      break label1199;
      label1401:
      paramf = arrayOfRegion[2].getName();
      break label1237;
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
        if (this.afJP != null) {
          this.afJP.jDv();
        }
        this.pUC = false;
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39097);
    super.onResume();
    if (this.pUC)
    {
      boolean bool = b.a(this, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 64, null);
      Log.i("MicroMsg.MultiStageCitySelectUI", "settings district,checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        if (this.owr == null) {
          this.owr = com.tencent.mm.modelgeo.d.bJl();
        }
        if (!((com.tencent.mm.sensitive.d)com.tencent.mm.kernel.h.az(com.tencent.mm.sensitive.d.class)).checkAndShowPermissionDialog(d.c.actu, new d.f()
        {
          public final void onOp(Boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(250987);
            if (paramAnonymousBoolean.booleanValue())
            {
              MultiStageCitySelectUI.this.onBusinessPermissionGranted(d.c.actu.value);
              AppMethodBeat.o(250987);
              return;
            }
            MultiStageCitySelectUI.this.onBusinessPermissionDenied(d.c.actu.value);
            AppMethodBeat.o(250987);
          }
        })) {
          this.owr.a(this.lsF, true, false);
        }
      }
    }
    AppMethodBeat.o(39097);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(39103);
    g localg;
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp.getType() != 665) {
        break label329;
      }
      localg = (g)paramp;
      paramp = localg.country;
      paramString = localg.province;
      localObject = localg.city;
      Log.i("MicroMsg.MultiStageCitySelectUI", "current location country %s, province %s, city %s", new Object[] { paramp, paramString, localObject });
      RegionCodeDecoder.Region[] arrayOfRegion = RegionCodeDecoder.jcF().jcH();
      paramInt2 = arrayOfRegion.length;
      paramInt1 = 0;
      if (paramInt1 >= paramInt2) {
        break label336;
      }
      localg = arrayOfRegion[paramInt1];
      if (localg.getCode().equalsIgnoreCase(paramp))
      {
        arrayOfRegion = RegionCodeDecoder.jcF().byI(localg.getCode());
        paramInt2 = arrayOfRegion.length;
        paramInt1 = 0;
        label136:
        if (paramInt1 < paramInt2)
        {
          paramp = arrayOfRegion[paramInt1];
          if (paramp.getCode().equalsIgnoreCase(paramString))
          {
            arrayOfRegion = RegionCodeDecoder.jcF().pN(localg.getCode(), paramp.getCode());
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
      if ((localg == null) && (paramp == null) && (paramString == null))
      {
        if (this.afJP == null) {
          break label318;
        }
        this.afJP.jDv();
        AppMethodBeat.o(39103);
        return;
        paramInt1 += 1;
        break label183;
        paramString = null;
        continue;
        paramInt1 += 1;
        break label136;
        paramString = null;
        paramp = null;
        continue;
        paramInt1 += 1;
        break;
      }
      if (this.afJP != null)
      {
        localObject = this.afJP;
        ((ZoneRecommandPreference)localObject).status = 1;
        ((ZoneRecommandPreference)localObject).afLR = localg;
        ((ZoneRecommandPreference)localObject).afLS = paramp;
        ((ZoneRecommandPreference)localObject).afLT = paramString;
        ((ZoneRecommandPreference)localObject).jDu();
      }
      label318:
      AppMethodBeat.o(39103);
      return;
      jDh();
      label329:
      AppMethodBeat.o(39103);
      return;
      label336:
      paramString = null;
      paramp = null;
      localg = null;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MultiStageCitySelectUI
 * JD-Core Version:    0.7.0.1
 */