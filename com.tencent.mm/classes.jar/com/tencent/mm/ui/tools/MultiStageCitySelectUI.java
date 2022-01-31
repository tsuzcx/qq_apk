package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.List;

public class MultiStageCitySelectUI
  extends MMPreference
  implements com.tencent.mm.ah.f
{
  private static List<RegionCodeDecoder.Region> wdU;
  private int bTs = 0;
  private String countryCode = null;
  private String dXu = null;
  private String dXv = null;
  private a.a dig = new MultiStageCitySelectUI.1(this);
  private com.tencent.mm.ui.base.preference.f dnn;
  private n drn = new n((byte)0);
  private com.tencent.mm.modelgeo.c egs;
  private String esg = null;
  private ah handler = new ah(Looper.getMainLooper());
  private String wdJ = null;
  private String wdK = null;
  private boolean wdL = false;
  private int wdM = -1;
  private RegionCodeDecoder.Region[] wdN;
  private boolean wdO = false;
  private boolean wdP = true;
  private boolean wdQ = true;
  private boolean wdR = false;
  private boolean wdS = false;
  private ZoneRecommandPreference wdT;
  private String wdV;
  private Runnable wdW = new Runnable()
  {
    public final void run()
    {
      MultiStageCitySelectUI.k(MultiStageCitySelectUI.this);
    }
  };
  
  private void cJb()
  {
    if (this.egs == null) {
      this.egs = com.tencent.mm.modelgeo.c.Ob();
    }
    this.egs.a(this.dig, true);
  }
  
  private void cJc()
  {
    switch (this.bTs)
    {
    default: 
      return;
    case 2: 
      this.dXu = null;
      return;
    case 1: 
      this.dXv = null;
      return;
    }
    this.countryCode = null;
  }
  
  /* Error */
  private static List<RegionCodeDecoder.Region> cJd()
  {
    // Byte code:
    //   0: invokestatic 146	com/tencent/mm/storage/RegionCodeDecoder:cvV	()Lcom/tencent/mm/storage/RegionCodeDecoder;
    //   3: astore_0
    //   4: aload_0
    //   5: invokestatic 152	com/tencent/mm/sdk/platformtools/x:cqJ	()Ljava/lang/String;
    //   8: putfield 155	com/tencent/mm/storage/RegionCodeDecoder:uCH	Ljava/lang/String;
    //   11: aload_0
    //   12: invokevirtual 158	com/tencent/mm/storage/RegionCodeDecoder:cvW	()Ljava/lang/String;
    //   15: astore_1
    //   16: aload_1
    //   17: invokestatic 164	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   20: ifeq +38 -> 58
    //   23: ldc 166
    //   25: new 168	java/lang/StringBuilder
    //   28: dup
    //   29: ldc 170
    //   31: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   34: aload_0
    //   35: getfield 155	com/tencent/mm/storage/RegionCodeDecoder:uCH	Ljava/lang/String;
    //   38: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 186	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aconst_null
    //   48: astore_0
    //   49: aload_0
    //   50: invokestatic 164	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   53: ifeq +29 -> 82
    //   56: aconst_null
    //   57: areturn
    //   58: new 168	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   65: getstatic 190	com/tencent/mm/storage/RegionCodeDecoder:uCG	Ljava/lang/String;
    //   68: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_1
    //   72: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore_0
    //   79: goto -30 -> 49
    //   82: new 192	java/util/ArrayList
    //   85: dup
    //   86: invokespecial 193	java/util/ArrayList:<init>	()V
    //   89: astore 6
    //   91: aload_0
    //   92: invokestatic 199	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   95: astore_3
    //   96: new 201	java/io/InputStreamReader
    //   99: dup
    //   100: aload_3
    //   101: invokespecial 204	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   104: astore_2
    //   105: new 206	java/io/BufferedReader
    //   108: dup
    //   109: aload_2
    //   110: invokespecial 209	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   113: astore 4
    //   115: aconst_null
    //   116: astore_1
    //   117: aconst_null
    //   118: astore_0
    //   119: aload 4
    //   121: invokevirtual 212	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   124: astore 5
    //   126: aload 5
    //   128: ifnull +256 -> 384
    //   131: aload 5
    //   133: ldc 214
    //   135: invokevirtual 220	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   138: astore 7
    //   140: new 222	com/tencent/mm/storage/RegionCodeDecoder$Region
    //   143: dup
    //   144: invokespecial 223	com/tencent/mm/storage/RegionCodeDecoder$Region:<init>	()V
    //   147: astore 5
    //   149: aload 7
    //   151: arraylength
    //   152: iconst_2
    //   153: if_icmpne +427 -> 580
    //   156: aload 5
    //   158: aload 7
    //   160: iconst_1
    //   161: aaload
    //   162: invokevirtual 226	com/tencent/mm/storage/RegionCodeDecoder$Region:setName	(Ljava/lang/String;)V
    //   165: aload 7
    //   167: iconst_0
    //   168: aaload
    //   169: ldc 228
    //   171: invokevirtual 220	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   174: astore 7
    //   176: aload 7
    //   178: iconst_0
    //   179: aaload
    //   180: astore 8
    //   182: aload 5
    //   184: aload 8
    //   186: invokevirtual 231	com/tencent/mm/storage/RegionCodeDecoder$Region:setCountryCode	(Ljava/lang/String;)V
    //   189: aload 8
    //   191: invokestatic 164	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   194: ifne -75 -> 119
    //   197: aload 7
    //   199: arraylength
    //   200: iconst_1
    //   201: if_icmpne +44 -> 245
    //   204: aload 5
    //   206: aload 8
    //   208: invokevirtual 234	com/tencent/mm/storage/RegionCodeDecoder$Region:setCode	(Ljava/lang/String;)V
    //   211: aload 5
    //   213: iconst_0
    //   214: invokevirtual 238	com/tencent/mm/storage/RegionCodeDecoder$Region:setProvince	(Z)V
    //   217: aload 5
    //   219: iconst_0
    //   220: invokevirtual 241	com/tencent/mm/storage/RegionCodeDecoder$Region:setCity	(Z)V
    //   223: aload 5
    //   225: iconst_1
    //   226: invokevirtual 244	com/tencent/mm/storage/RegionCodeDecoder$Region:setCountry	(Z)V
    //   229: aload 5
    //   231: astore_1
    //   232: aload 6
    //   234: aload 5
    //   236: invokeinterface 250 2 0
    //   241: pop
    //   242: goto +338 -> 580
    //   245: aload 7
    //   247: arraylength
    //   248: iconst_2
    //   249: if_icmpne +63 -> 312
    //   252: aload 5
    //   254: aload 7
    //   256: iconst_1
    //   257: aaload
    //   258: invokevirtual 234	com/tencent/mm/storage/RegionCodeDecoder$Region:setCode	(Ljava/lang/String;)V
    //   261: aload 5
    //   263: iconst_1
    //   264: invokevirtual 238	com/tencent/mm/storage/RegionCodeDecoder$Region:setProvince	(Z)V
    //   267: aload 5
    //   269: iconst_0
    //   270: invokevirtual 244	com/tencent/mm/storage/RegionCodeDecoder$Region:setCountry	(Z)V
    //   273: aload 5
    //   275: iconst_0
    //   276: invokevirtual 241	com/tencent/mm/storage/RegionCodeDecoder$Region:setCity	(Z)V
    //   279: aload_1
    //   280: ifnull +303 -> 583
    //   283: aload_1
    //   284: invokevirtual 253	com/tencent/mm/storage/RegionCodeDecoder$Region:getCountryCode	()Ljava/lang/String;
    //   287: aload 5
    //   289: invokevirtual 253	com/tencent/mm/storage/RegionCodeDecoder$Region:getCountryCode	()Ljava/lang/String;
    //   292: invokevirtual 256	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   295: ifeq +288 -> 583
    //   298: aload_1
    //   299: iconst_1
    //   300: invokevirtual 259	com/tencent/mm/storage/RegionCodeDecoder$Region:setHasChildren	(Z)V
    //   303: aload 5
    //   305: aload_1
    //   306: invokevirtual 263	com/tencent/mm/storage/RegionCodeDecoder$Region:setParent	(Lcom/tencent/mm/storage/RegionCodeDecoder$Region;)V
    //   309: goto +274 -> 583
    //   312: aload 7
    //   314: arraylength
    //   315: iconst_3
    //   316: if_icmpne +65 -> 381
    //   319: aload 5
    //   321: aload 7
    //   323: iconst_2
    //   324: aaload
    //   325: invokevirtual 234	com/tencent/mm/storage/RegionCodeDecoder$Region:setCode	(Ljava/lang/String;)V
    //   328: aload 5
    //   330: iconst_1
    //   331: invokevirtual 241	com/tencent/mm/storage/RegionCodeDecoder$Region:setCity	(Z)V
    //   334: aload 5
    //   336: iconst_0
    //   337: invokevirtual 244	com/tencent/mm/storage/RegionCodeDecoder$Region:setCountry	(Z)V
    //   340: aload 5
    //   342: iconst_0
    //   343: invokevirtual 238	com/tencent/mm/storage/RegionCodeDecoder$Region:setProvince	(Z)V
    //   346: aload 5
    //   348: iconst_0
    //   349: invokevirtual 259	com/tencent/mm/storage/RegionCodeDecoder$Region:setHasChildren	(Z)V
    //   352: aload_0
    //   353: ifnull +28 -> 381
    //   356: aload_0
    //   357: invokevirtual 266	com/tencent/mm/storage/RegionCodeDecoder$Region:getCode	()Ljava/lang/String;
    //   360: aload 7
    //   362: iconst_1
    //   363: aaload
    //   364: invokevirtual 256	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   367: ifeq +14 -> 381
    //   370: aload 5
    //   372: aload_0
    //   373: invokevirtual 263	com/tencent/mm/storage/RegionCodeDecoder$Region:setParent	(Lcom/tencent/mm/storage/RegionCodeDecoder$Region;)V
    //   376: aload_0
    //   377: iconst_1
    //   378: invokevirtual 259	com/tencent/mm/storage/RegionCodeDecoder$Region:setHasChildren	(Z)V
    //   381: goto -149 -> 232
    //   384: aload_3
    //   385: ifnull +7 -> 392
    //   388: aload_3
    //   389: invokevirtual 271	java/io/InputStream:close	()V
    //   392: aload_2
    //   393: invokevirtual 272	java/io/InputStreamReader:close	()V
    //   396: aload 4
    //   398: invokevirtual 273	java/io/BufferedReader:close	()V
    //   401: aload 6
    //   403: areturn
    //   404: astore_1
    //   405: aconst_null
    //   406: astore_0
    //   407: aconst_null
    //   408: astore_2
    //   409: aconst_null
    //   410: astore_3
    //   411: ldc_w 275
    //   414: aload_1
    //   415: ldc_w 277
    //   418: iconst_1
    //   419: anewarray 279	java/lang/Object
    //   422: dup
    //   423: iconst_0
    //   424: aload_1
    //   425: invokevirtual 282	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   428: aastore
    //   429: invokestatic 286	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   432: aload_3
    //   433: ifnull +7 -> 440
    //   436: aload_3
    //   437: invokevirtual 271	java/io/InputStream:close	()V
    //   440: aload_2
    //   441: ifnull +7 -> 448
    //   444: aload_2
    //   445: invokevirtual 272	java/io/InputStreamReader:close	()V
    //   448: aload_0
    //   449: ifnull -48 -> 401
    //   452: aload_0
    //   453: invokevirtual 273	java/io/BufferedReader:close	()V
    //   456: goto -55 -> 401
    //   459: astore_0
    //   460: goto -59 -> 401
    //   463: astore_0
    //   464: aconst_null
    //   465: astore_1
    //   466: aconst_null
    //   467: astore_2
    //   468: aconst_null
    //   469: astore_3
    //   470: aload_3
    //   471: ifnull +7 -> 478
    //   474: aload_3
    //   475: invokevirtual 271	java/io/InputStream:close	()V
    //   478: aload_2
    //   479: ifnull +7 -> 486
    //   482: aload_2
    //   483: invokevirtual 272	java/io/InputStreamReader:close	()V
    //   486: aload_1
    //   487: ifnull +7 -> 494
    //   490: aload_1
    //   491: invokevirtual 273	java/io/BufferedReader:close	()V
    //   494: aload_0
    //   495: athrow
    //   496: astore_0
    //   497: goto -105 -> 392
    //   500: astore_0
    //   501: goto -105 -> 396
    //   504: astore_0
    //   505: goto -104 -> 401
    //   508: astore_1
    //   509: goto -69 -> 440
    //   512: astore_1
    //   513: goto -65 -> 448
    //   516: astore_3
    //   517: goto -39 -> 478
    //   520: astore_2
    //   521: goto -35 -> 486
    //   524: astore_1
    //   525: goto -31 -> 494
    //   528: astore_0
    //   529: aconst_null
    //   530: astore_1
    //   531: aconst_null
    //   532: astore_2
    //   533: goto -63 -> 470
    //   536: astore_0
    //   537: aconst_null
    //   538: astore_1
    //   539: goto -69 -> 470
    //   542: astore_0
    //   543: aload 4
    //   545: astore_1
    //   546: goto -76 -> 470
    //   549: astore 4
    //   551: aload_0
    //   552: astore_1
    //   553: aload 4
    //   555: astore_0
    //   556: goto -86 -> 470
    //   559: astore_1
    //   560: aconst_null
    //   561: astore_0
    //   562: aconst_null
    //   563: astore_2
    //   564: goto -153 -> 411
    //   567: astore_1
    //   568: aconst_null
    //   569: astore_0
    //   570: goto -159 -> 411
    //   573: astore_1
    //   574: aload 4
    //   576: astore_0
    //   577: goto -166 -> 411
    //   580: goto -461 -> 119
    //   583: aload 5
    //   585: astore_0
    //   586: goto -354 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	450	0	localObject1	Object
    //   459	1	0	localIOException1	java.io.IOException
    //   463	32	0	localObject2	Object
    //   496	1	0	localIOException2	java.io.IOException
    //   500	1	0	localIOException3	java.io.IOException
    //   504	1	0	localIOException4	java.io.IOException
    //   528	1	0	localObject3	Object
    //   536	1	0	localObject4	Object
    //   542	10	0	localObject5	Object
    //   555	31	0	localObject6	Object
    //   15	291	1	localObject7	Object
    //   404	21	1	localException1	java.lang.Exception
    //   465	26	1	localObject8	Object
    //   508	1	1	localIOException5	java.io.IOException
    //   512	1	1	localIOException6	java.io.IOException
    //   524	1	1	localIOException7	java.io.IOException
    //   530	23	1	localObject9	Object
    //   559	1	1	localException2	java.lang.Exception
    //   567	1	1	localException3	java.lang.Exception
    //   573	1	1	localException4	java.lang.Exception
    //   104	379	2	localInputStreamReader	java.io.InputStreamReader
    //   520	1	2	localIOException8	java.io.IOException
    //   532	32	2	localObject10	Object
    //   95	380	3	localInputStream	java.io.InputStream
    //   516	1	3	localIOException9	java.io.IOException
    //   113	431	4	localBufferedReader	java.io.BufferedReader
    //   549	26	4	localObject11	Object
    //   124	460	5	localObject12	Object
    //   89	313	6	localArrayList	ArrayList
    //   138	223	7	arrayOfString	String[]
    //   180	27	8	str	String
    // Exception table:
    //   from	to	target	type
    //   91	96	404	java/lang/Exception
    //   452	456	459	java/io/IOException
    //   91	96	463	finally
    //   388	392	496	java/io/IOException
    //   392	396	500	java/io/IOException
    //   396	401	504	java/io/IOException
    //   436	440	508	java/io/IOException
    //   444	448	512	java/io/IOException
    //   474	478	516	java/io/IOException
    //   482	486	520	java/io/IOException
    //   490	494	524	java/io/IOException
    //   96	105	528	finally
    //   105	115	536	finally
    //   119	126	542	finally
    //   131	176	542	finally
    //   182	229	542	finally
    //   232	242	542	finally
    //   245	279	542	finally
    //   283	309	542	finally
    //   312	352	542	finally
    //   356	381	542	finally
    //   411	432	549	finally
    //   96	105	559	java/lang/Exception
    //   105	115	567	java/lang/Exception
    //   119	126	573	java/lang/Exception
    //   131	176	573	java/lang/Exception
    //   182	229	573	java/lang/Exception
    //   232	242	573	java/lang/Exception
    //   245	279	573	java/lang/Exception
    //   283	309	573	java/lang/Exception
    //   312	352	573	java/lang/Exception
    //   356	381	573	java/lang/Exception
  }
  
  private void cJe()
  {
    if (this.wdT != null) {
      this.wdT.cJp();
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    Object localObject3 = null;
    Object localObject1;
    label100:
    Object localObject2;
    if ((paramPreference instanceof ZonePreference))
    {
      paramPreference = ((ZonePreference)paramPreference).wfy;
      if ((paramPreference == null) || (bk.bl(paramPreference.getCode())))
      {
        localObject1 = new StringBuilder("onPreferenceTreeClick error item, code:");
        if (paramPreference == null)
        {
          paramf = Integer.valueOf(-1);
          localObject1 = ((StringBuilder)localObject1).append(paramf).append(" ,name:");
          if (paramPreference != null) {
            break label100;
          }
        }
        for (paramf = "null";; paramf = paramPreference.getName())
        {
          y.e("MicroMsg.MultiStageCitySelectUI", paramf);
          return false;
          paramf = paramPreference.getCode();
          break;
        }
      }
      if (this.bTs == 3)
      {
        this.countryCode = "CN";
        this.dXv = paramPreference.getCode();
        this.wdJ = paramPreference.getName();
      }
      if (this.bTs == 0)
      {
        this.countryCode = paramPreference.getCode();
        this.esg = paramPreference.getName();
        if (paramPreference.hasChildren()) {
          break label603;
        }
        if (!this.wdO)
        {
          au.Hx();
          com.tencent.mm.model.c.Dz().o(12324, this.countryCode);
          au.Hx();
          com.tencent.mm.model.c.Dz().o(12325, this.dXv);
          au.Hx();
          com.tencent.mm.model.c.Dz().o(12326, this.dXu);
        }
        paramf = new Intent();
        paramf.putExtra("CountryName", this.esg);
        paramf.putExtra("ProviceName", this.wdJ);
        paramf.putExtra("CityName", this.wdK);
        paramf.putExtra("Country", this.countryCode);
        paramf.putExtra("Contact_Province", this.dXv);
        paramf.putExtra("Contact_City", this.dXu);
        XM();
        setResult(-1, paramf);
        finish();
      }
      for (;;)
      {
        return true;
        if (this.bTs == 1)
        {
          this.dXv = paramPreference.getCode();
          this.wdJ = paramPreference.getName();
          break;
        }
        if (this.bTs == 2)
        {
          this.dXu = paramPreference.getCode();
          this.wdK = paramPreference.getName();
          if (("CN".equalsIgnoreCase(this.countryCode)) || ("HK".equalsIgnoreCase(this.countryCode)) || ("MO".equalsIgnoreCase(this.countryCode)) || ("TW".equalsIgnoreCase(this.countryCode)))
          {
            this.esg = null;
            break;
          }
          this.wdJ = null;
          break;
        }
        if (this.bTs != 4) {
          break;
        }
        if ((paramPreference.getParent() != null) && (!paramPreference.hasChildren()))
        {
          this.dXu = paramPreference.getCode();
          this.wdK = paramPreference.getName();
          this.dXv = paramPreference.getParent().getCode();
          this.wdJ = paramPreference.getParent().getName();
          this.countryCode = paramPreference.getCountryCode();
          this.esg = null;
          break;
        }
        if ((paramPreference.hasChildren()) && (paramPreference.getParent() != null))
        {
          this.dXv = paramPreference.getCode();
          this.wdJ = paramPreference.getName();
          this.countryCode = paramPreference.getCountryCode();
          this.esg = null;
          break;
        }
        this.countryCode = paramPreference.getCode();
        this.esg = paramPreference.getName();
        this.dXv = null;
        this.wdJ = null;
        this.dXu = null;
        this.wdK = null;
        break;
        label603:
        localObject1 = new Intent(this, MultiStageCitySelectUI.class);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("Country", this.countryCode);
        ((Bundle)localObject2).putString("Provice", this.dXv);
        ((Bundle)localObject2).putString("CountryName", this.esg);
        ((Bundle)localObject2).putString("ProviceName", this.wdJ);
        ((Bundle)localObject2).putBoolean("GetAddress", this.wdO);
        ((Bundle)localObject2).putBoolean("ShowSelectedLocation", this.wdQ);
        if (this.wdL)
        {
          paramPreference = paramPreference.getCountryCode();
          paramf = paramPreference;
          if (bk.bl(paramPreference)) {
            paramf = this.countryCode;
          }
          if (("CN".equalsIgnoreCase(paramf)) || ("HK".equalsIgnoreCase(paramf)) || ("MO".equalsIgnoreCase(paramf)) || ("TW".equalsIgnoreCase(paramf))) {
            ((Bundle)localObject2).putBoolean("IsNeedShowSearchBar", true);
          }
        }
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        XM();
        startActivityForResult((Intent)localObject1, 1);
      }
    }
    int i;
    RegionCodeDecoder.Region[] arrayOfRegion;
    label875:
    label1017:
    Intent localIntent;
    if (paramPreference.mKey.equals("current_location"))
    {
      if (this.wdT.status != 1) {
        break label1124;
      }
      i = 1;
      if (i != 0)
      {
        paramf = this.wdT;
        arrayOfRegion = new RegionCodeDecoder.Region[3];
        arrayOfRegion[0] = paramf.wfB;
        arrayOfRegion[1] = paramf.wfC;
        arrayOfRegion[2] = paramf.wfD;
        au.Hx();
        paramPreference = com.tencent.mm.model.c.Dz();
        if (arrayOfRegion[0] != null) {
          break label1129;
        }
        paramf = null;
        paramPreference.o(12324, paramf);
        au.Hx();
        paramPreference = com.tencent.mm.model.c.Dz();
        if (arrayOfRegion[1] != null) {
          break label1140;
        }
        paramf = null;
        label900:
        paramPreference.o(12325, paramf);
        au.Hx();
        paramPreference = com.tencent.mm.model.c.Dz();
        if (arrayOfRegion[2] != null) {
          break label1151;
        }
        paramf = null;
        label925:
        paramPreference.o(12326, paramf);
        if (arrayOfRegion[0] != null) {
          break label1162;
        }
        localObject1 = null;
        label943:
        if (arrayOfRegion[0] != null) {
          break label1174;
        }
        paramf = null;
        label952:
        if (arrayOfRegion[1] != null) {
          break label1185;
        }
        localObject2 = null;
        label962:
        if (arrayOfRegion[1] != null) {
          break label1197;
        }
        paramPreference = null;
        label971:
        if ((!"CN".equalsIgnoreCase((String)localObject1)) && (!"HK".equalsIgnoreCase((String)localObject1)) && (!"MO".equalsIgnoreCase((String)localObject1)) && (!"TW".equalsIgnoreCase((String)localObject1))) {
          break label1208;
        }
        paramf = null;
        localIntent = new Intent();
        localIntent.putExtra("CountryName", paramf);
        localIntent.putExtra("ProviceName", paramPreference);
        if (arrayOfRegion[2] != null) {
          break label1213;
        }
        paramf = null;
        label1055:
        localIntent.putExtra("CityName", paramf);
        localIntent.putExtra("Country", (String)localObject1);
        localIntent.putExtra("Contact_Province", (String)localObject2);
        if (arrayOfRegion[2] != null) {
          break label1224;
        }
      }
    }
    label1162:
    label1174:
    label1185:
    label1197:
    label1208:
    label1213:
    label1224:
    for (paramf = localObject3;; paramf = arrayOfRegion[2].getCode())
    {
      localIntent.putExtra("Contact_City", paramf);
      XM();
      setResult(-1, localIntent);
      finish();
      return false;
      label1124:
      i = 0;
      break;
      label1129:
      paramf = arrayOfRegion[0].getCode();
      break label875;
      label1140:
      paramf = arrayOfRegion[1].getCode();
      break label900;
      label1151:
      paramf = arrayOfRegion[2].getCode();
      break label925;
      localObject1 = arrayOfRegion[0].getCode();
      break label943;
      paramf = arrayOfRegion[0].getName();
      break label952;
      localObject2 = arrayOfRegion[1].getCode();
      break label962;
      paramPreference = arrayOfRegion[1].getName();
      break label971;
      paramPreference = null;
      break label1017;
      paramf = arrayOfRegion[2].getName();
      break label1055;
    }
  }
  
  public final void cJa()
  {
    if (this.bTs == 3)
    {
      localObject1 = RegionCodeDecoder.cvV().acn("CN");
      this.wdN = ((RegionCodeDecoder.Region[])localObject1);
      if ((this.wdN != null) && (this.wdN.length > 0)) {
        break label252;
      }
      y.e("MicroMsg.MultiStageCitySelectUI", "initZoneItems error ,check zone lists!");
    }
    label252:
    do
    {
      return;
      if (bk.bl(this.countryCode))
      {
        localObject2 = RegionCodeDecoder.cvV().cvX();
        localObject1 = localObject2;
        if (!this.wdR) {
          break;
        }
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
        break;
      }
      if (bk.bl(this.dXv))
      {
        localObject1 = RegionCodeDecoder.cvV().acn(this.countryCode);
        break;
      }
      localObject1 = RegionCodeDecoder.cvV().gq(this.countryCode, this.dXv);
      break;
      this.dnn.removeAll();
      au.Hx();
      localObject1 = (String)com.tencent.mm.model.c.Dz().get(12324, null);
      au.Hx();
      Object localObject2 = (String)com.tencent.mm.model.c.Dz().get(12325, null);
      au.Hx();
      Object localObject3 = (String)com.tencent.mm.model.c.Dz().get(12326, null);
      this.wdQ = getIntent().getBooleanExtra("ShowSelectedLocation", true);
      int i = 0;
      if (i < this.wdN.length)
      {
        ZonePreference localZonePreference;
        if ((this.wdN[i] != null) && (!bk.bl(this.wdN[i].getCode())) && (!bk.bl(this.wdN[i].getName())))
        {
          localZonePreference = new ZonePreference(this);
          localZonePreference.a(this.wdN[i]);
          if (!this.wdQ) {
            break label572;
          }
          if ((this.bTs != 0) || (!this.wdN[i].getCode().equalsIgnoreCase((String)localObject1))) {
            break label462;
          }
          this.dnn.a(localZonePreference, 0);
          localZonePreference.setSummary(R.l.setting_zone_selected_location);
        }
        for (;;)
        {
          i += 1;
          break;
          if ((this.bTs == 1) && (this.wdN[i].getCode().equalsIgnoreCase((String)localObject2)))
          {
            this.dnn.a(localZonePreference, 0);
            localZonePreference.setSummary(R.l.setting_zone_selected_location);
          }
          else if ((this.bTs == 2) && (this.wdN[i].getCode().equalsIgnoreCase((String)localObject3)))
          {
            this.dnn.a(localZonePreference, 0);
            localZonePreference.setSummary(R.l.setting_zone_selected_location);
          }
          else
          {
            this.dnn.a(localZonePreference);
            continue;
            this.dnn.a(localZonePreference);
          }
        }
      }
      if (this.bTs == 3)
      {
        localObject1 = new ZoneSelectOtherCountryPreference(this);
        ((ZoneSelectOtherCountryPreference)localObject1).text = getString(R.l.setting_zone_non_china_mainland);
        ((ZoneSelectOtherCountryPreference)localObject1).wfG = new MultiStageCitySelectUI.2(this);
        this.dnn.a((Preference)localObject1);
      }
      localObject1 = new PreferenceCategory(this.mController.uMN);
      this.dnn.a((Preference)localObject1);
    } while ((this.bTs != 0) && (this.bTs != 3));
    label462:
    if (this.wdP)
    {
      localObject1 = new PreferenceTitleCategory(this);
      ((PreferenceTitleCategory)localObject1).setTitle(R.l.setting_zone_category_get_location);
      this.dnn.a((Preference)localObject1, 0);
      this.wdT = new ZoneRecommandPreference(this);
      this.wdT.setKey("current_location");
      this.dnn.a(this.wdT, 1);
      boolean bool = a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
      y.i("MicroMsg.MultiStageCitySelectUI", "settings district,checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        cJb();
      }
    }
    label572:
    Object localObject1 = new PreferenceTitleCategory(this);
    ((PreferenceTitleCategory)localObject1).setTitle(R.l.setting_zone_category_all_locations);
    if (this.wdP)
    {
      this.dnn.a((Preference)localObject1, 2);
      return;
    }
    this.dnn.a((Preference)localObject1, 0);
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.nearby_friend_city_select);
    setBackBtn(new MultiStageCitySelectUI.5(this));
    this.wdO = getIntent().getBooleanExtra("GetAddress", false);
    this.countryCode = getIntent().getStringExtra("Country");
    this.dXv = getIntent().getStringExtra("Provice");
    this.esg = getIntent().getStringExtra("CountryName");
    this.wdJ = getIntent().getStringExtra("ProviceName");
    Intent localIntent = getIntent();
    boolean bool;
    if (!bk.fV(this))
    {
      bool = true;
      this.wdP = localIntent.getBooleanExtra("IsAutoPosition", bool);
      this.wdL = getIntent().getBooleanExtra("IsRealNameVerifyScene", false);
      this.wdR = getIntent().getBooleanExtra("IsSelectNonChinaCountry", false);
      this.wdS = getIntent().getBooleanExtra("IsNeedShowSearchBar", false);
      y.i("MicroMsg.MultiStageCitySelectUI", " country = " + this.countryCode + " province =" + this.dXv + " city = " + this.dXu + " " + this.esg + " " + this.wdJ + " " + this.wdL + " " + this.wdR);
      if (!this.wdL) {
        break label287;
      }
      this.bTs = 3;
    }
    for (;;)
    {
      cJa();
      return;
      bool = false;
      break;
      label287:
      if (this.countryCode == null)
      {
        this.bTs = 0;
        this.dXv = null;
        this.dXu = null;
      }
      else if (this.dXv == null)
      {
        this.bTs = 1;
        this.dXu = null;
      }
      else
      {
        this.bTs = 2;
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    setResult(-1, paramIntent);
    finish();
  }
  
  public void onBackPressed()
  {
    cJc();
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    au.Dk().a(665, this);
    this.dnn = this.vdd;
    initView();
    long l;
    if (this.wdS) {
      if ((wdU == null) || (wdU.size() <= 0))
      {
        l = bk.UZ();
        paramBundle = RegionCodeDecoder.cvV().cvX();
        if ((paramBundle != null) && (paramBundle.length > 0)) {
          break label95;
        }
      }
    }
    for (;;)
    {
      a(this.drn);
      this.drn.weq = new n.b()
      {
        public final void Wl()
        {
          MultiStageCitySelectUI.this.XM();
          MultiStageCitySelectUI.g(MultiStageCitySelectUI.this);
          MultiStageCitySelectUI.this.cJa();
        }
        
        public final void Wm() {}
        
        public final void Wn()
        {
          MultiStageCitySelectUI.g(MultiStageCitySelectUI.this);
          MultiStageCitySelectUI.this.cJa();
        }
        
        public final void Wo() {}
        
        public final boolean pB(String paramAnonymousString)
        {
          if (!bk.bl(paramAnonymousString))
          {
            MultiStageCitySelectUI.a(MultiStageCitySelectUI.this, paramAnonymousString);
            MultiStageCitySelectUI.h(MultiStageCitySelectUI.this).removeAll();
            MultiStageCitySelectUI.j(MultiStageCitySelectUI.this).removeCallbacks(MultiStageCitySelectUI.i(MultiStageCitySelectUI.this));
            MultiStageCitySelectUI.j(MultiStageCitySelectUI.this).postDelayed(MultiStageCitySelectUI.i(MultiStageCitySelectUI.this), 50L);
            return true;
          }
          return false;
        }
        
        public final void pC(String paramAnonymousString)
        {
          if (!bk.bl(paramAnonymousString))
          {
            MultiStageCitySelectUI.a(MultiStageCitySelectUI.this, paramAnonymousString);
            MultiStageCitySelectUI.h(MultiStageCitySelectUI.this).removeAll();
            MultiStageCitySelectUI.j(MultiStageCitySelectUI.this).removeCallbacks(MultiStageCitySelectUI.i(MultiStageCitySelectUI.this));
            MultiStageCitySelectUI.j(MultiStageCitySelectUI.this).postDelayed(MultiStageCitySelectUI.i(MultiStageCitySelectUI.this), 50L);
          }
        }
      };
      return;
      label95:
      if ((wdU == null) || (wdU.size() <= 0))
      {
        paramBundle = cJd();
        wdU = paramBundle;
        if (paramBundle != null) {
          y.i("MicroMsg.MultiStageCitySelectUI", "buildAllSearchRegion used %sms, size: %s", new Object[] { Long.valueOf(bk.cp(l)), Integer.valueOf(wdU.size()) });
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    au.Dk().b(665, this);
    if (this.egs != null) {
      this.egs.c(this.dig);
    }
    super.onDestroy();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.MultiStageCitySelectUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    do
    {
      return;
      if ((paramArrayOfInt[0] == 0) && (this.wdT != null))
      {
        cJb();
        return;
      }
    } while (this.wdT == null);
    this.wdT.cJp();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 0;
    j localj;
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramm.getType() == 665)
      {
        localj = (j)paramm;
        paramm = localj.country;
        paramString = localj.cCA;
        localObject = localj.cCB;
        y.i("MicroMsg.MultiStageCitySelectUI", "current location country %s, province %s, city %s", new Object[] { paramm, paramString, localObject });
        RegionCodeDecoder.Region[] arrayOfRegion = RegionCodeDecoder.cvV().cvX();
        paramInt2 = arrayOfRegion.length;
        paramInt1 = 0;
        if (paramInt1 >= paramInt2) {
          break label316;
        }
        localj = arrayOfRegion[paramInt1];
        if (!localj.getCode().equalsIgnoreCase(paramm)) {
          break label259;
        }
        arrayOfRegion = RegionCodeDecoder.cvV().acn(localj.getCode());
        paramInt2 = arrayOfRegion.length;
        paramInt1 = 0;
        label133:
        if (paramInt1 >= paramInt2) {
          break label251;
        }
        paramm = arrayOfRegion[paramInt1];
        if (!paramm.getCode().equalsIgnoreCase(paramString)) {
          break label244;
        }
        arrayOfRegion = RegionCodeDecoder.cvV().gq(localj.getCode(), paramm.getCode());
        paramInt2 = arrayOfRegion.length;
        paramInt1 = i;
        label181:
        if (paramInt1 >= paramInt2) {
          break label239;
        }
        paramString = arrayOfRegion[paramInt1];
        if (!paramString.getCode().equalsIgnoreCase((String)localObject)) {
          break label232;
        }
      }
    }
    for (;;)
    {
      label203:
      if ((localj == null) && (paramm == null) && (paramString == null)) {
        if (this.wdT != null) {
          this.wdT.cJp();
        }
      }
      label232:
      label239:
      label244:
      label251:
      while (this.wdT == null)
      {
        return;
        paramInt1 += 1;
        break label181;
        paramString = null;
        break label203;
        paramInt1 += 1;
        break label133;
        paramString = null;
        paramm = null;
        break label203;
        paramInt1 += 1;
        break;
      }
      label259:
      localObject = this.wdT;
      ((ZoneRecommandPreference)localObject).status = 1;
      ((ZoneRecommandPreference)localObject).wfB = localj;
      ((ZoneRecommandPreference)localObject).wfC = paramm;
      ((ZoneRecommandPreference)localObject).wfD = paramString;
      ((ZoneRecommandPreference)localObject).cJo();
      return;
      cJe();
      return;
      label316:
      paramString = null;
      paramm = null;
      localj = null;
    }
  }
  
  public final int xj()
  {
    return R.i.zoneselect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MultiStageCitySelectUI
 * JD-Core Version:    0.7.0.1
 */