package com.tencent.mm.plugin.sns.waid;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONArray;
import org.json.JSONObject;

public class WaidProvider
  extends ContentProvider
{
  private static final Uri AUTHORITY_URI;
  private static String[] xZA;
  public static final Uri xZx;
  public static final Uri xZy;
  private static String[] xZz;
  private d xZB;
  private d xZC;
  private UriMatcher xZD;
  private f xZE;
  private boolean xZF;
  
  static
  {
    AppMethodBeat.i(100606);
    Uri localUri = Uri.parse("content://com.tencent.mm.waidProvider");
    AUTHORITY_URI = localUri;
    xZx = Uri.withAppendedPath(localUri, "waid");
    xZy = Uri.withAppendedPath(AUTHORITY_URI, "cfg");
    xZz = new String[] { "waid" };
    xZA = new String[] { "pkg", "waid", "expire", "timeStamp", "type" };
    AppMethodBeat.o(100606);
  }
  
  public WaidProvider()
  {
    AppMethodBeat.i(100598);
    this.xZD = new UriMatcher(-1);
    this.xZF = false;
    AppMethodBeat.o(100598);
  }
  
  private void Ob(int paramInt)
  {
    AppMethodBeat.i(100605);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      str1 = bt.nullAsNil(getCallingPackage());
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          String str1;
          localJSONObject.put("srcPkg", str1);
          localJSONObject.put("appWaidNum", this.xZB.getCount());
          localJSONObject.put("pubWaidNum", this.xZC.getCount());
          ad.i("ad.waid.WaidProvider", "reportModify, action=" + paramInt + ", data=" + localJSONObject.toString() + ", isKernelInted=" + this.xZF);
          if (this.xZF) {
            com.tencent.mm.plugin.report.service.h.vKh.f(18666, new Object[] { Integer.valueOf(paramInt), localJSONObject.toString() });
          }
          AppMethodBeat.o(100605);
          return;
        }
        catch (Throwable localThrowable)
        {
          String str2;
          ad.e("ad.waid.WaidProvider", "reportQuery exp=" + localThrowable.toString());
          AppMethodBeat.o(100605);
        }
        localException = localException;
        ad.e("ad.waid.WaidProvider", "reportQuery getCallingPackage exp=" + localException.toString());
        str2 = "";
      }
    }
  }
  
  private boolean dEC()
  {
    boolean bool4 = false;
    boolean bool3 = false;
    AppMethodBeat.i(100603);
    bool2 = bool4;
    try
    {
      String str1 = getCallingPackage();
      bool2 = bool4;
      String str2 = getContext().getPackageName();
      bool1 = bool3;
      if (str1 != null)
      {
        bool1 = bool3;
        bool2 = bool4;
        if (str1.equals(str2)) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      ad.i("ad.waid.WaidProvider", "isReqFromMM, ret=" + bool1 + ", srcPkg=" + str1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("ad.waid.WaidProvider", "isReqFromMM, exp=" + localException.toString());
        boolean bool1 = bool2;
      }
    }
    AppMethodBeat.o(100603);
    return bool1;
  }
  
  private void r(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100604);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("srcPkg", paramString1);
      localJSONObject.put("reqPkg", paramString2);
      localJSONObject.put("appWaidNum", this.xZB.getCount());
      localJSONObject.put("pubWaidNum", this.xZC.getCount());
      localJSONObject.put("idType", paramInt2);
      localJSONObject.put("ret", paramInt1);
      ad.i("ad.waid.WaidProvider", "reportQuery data=" + localJSONObject.toString() + ", isKernelInted=" + this.xZF);
      if (this.xZF) {
        com.tencent.mm.plugin.report.service.h.vKh.f(18666, new Object[] { Integer.valueOf(1), localJSONObject.toString() });
      }
      AppMethodBeat.o(100604);
      return;
    }
    catch (Throwable paramString1)
    {
      ad.e("ad.waid.WaidProvider", "reportQuery exp=" + paramString1.toString());
      AppMethodBeat.o(100604);
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(100601);
    try
    {
      long l1 = System.currentTimeMillis();
      if (this.xZD.match(paramUri) == 1)
      {
        if (!dEC())
        {
          ad.w("ad.waid.WaidProvider", "delete ret=false, !isReqFromMM");
          Ob(2);
          AppMethodBeat.o(100601);
          return 0;
        }
        paramString = "";
        paramUri = paramString;
        if (paramArrayOfString != null)
        {
          paramUri = paramString;
          if (paramArrayOfString.length > 0) {
            paramUri = paramArrayOfString[0];
          }
        }
        if (!TextUtils.isEmpty(paramUri))
        {
          paramString = new h();
          paramString.dvP = paramUri;
          paramString.type = 1;
          boolean bool = this.xZB.b(paramString);
          long l2 = System.currentTimeMillis();
          ad.i("ad.waid.WaidProvider", "delete, timeCost=" + (l2 - l1) + ", ret=" + bool + ", pkg=" + paramUri + ", thread=" + Thread.currentThread());
          if (bool)
          {
            AppMethodBeat.o(100601);
            return 1;
          }
          AppMethodBeat.o(100601);
          return 0;
        }
        ad.w("ad.waid.WaidProvider", "delete, pkg=null");
      }
    }
    catch (Throwable paramUri)
    {
      for (;;)
      {
        ad.e("ad.waid.WaidProvider", "delete exp=" + paramUri.toString());
      }
    }
    AppMethodBeat.o(100601);
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(100600);
    int i;
    Object localObject;
    int j;
    label384:
    label479:
    do
    {
      long l1;
      try
      {
        l1 = System.currentTimeMillis();
        if ((!dEC()) || (paramContentValues == null))
        {
          ad.w("ad.waid.WaidProvider", "insert ret=false, !isReqFromMM");
          Ob(3);
          AppMethodBeat.o(100600);
          return null;
        }
        i = this.xZD.match(paramUri);
        if (i != 1) {
          continue;
        }
        paramContentValues = bt.nullAsNil(paramContentValues.getAsString("waid_array"));
        ad.i("ad.waid.WaidProvider", "insert, jsonStr=" + paramContentValues + ", thread=" + Thread.currentThread());
        this.xZB.dEB();
        this.xZC.dEB();
        bool1 = TextUtils.isEmpty(paramContentValues);
        if (bool1)
        {
          AppMethodBeat.o(100600);
          return null;
        }
        paramContentValues = new JSONArray(paramContentValues);
        i = 0;
        if (i >= paramContentValues.length()) {
          break label479;
        }
        localObject = paramContentValues.optJSONObject(i);
        if (localObject == null) {
          break;
        }
        localObject = h.aH((JSONObject)localObject);
        if (localObject == null) {
          break;
        }
        try
        {
          ((h)localObject).xZv = ce.asT();
          if (!((h)localObject).isValid()) {
            ad.e("ad.waid.WaidProvider", "invalid item, pass");
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ((h)localObject).xZv = ((int)(System.currentTimeMillis() / 1000L));
            ad.e("ad.waid.WaidProvider", "insert timeStamp exp=" + localThrowable.toString());
          }
        }
        if (((h)localObject).type != 1) {
          break label384;
        }
      }
      catch (Throwable paramUri)
      {
        ad.e("ad.waid.WaidProvider", "insert exp=" + paramUri.toString());
        AppMethodBeat.o(100600);
        return null;
      }
      j = this.xZB.getCount();
      int k = this.xZE.xZr;
      if (j >= k)
      {
        ad.w("ad.waid.WaidProvider", "appWaid > max, curCount=" + j + ", max=" + k);
        this.xZB.dEA();
      }
      this.xZB.a((h)localObject);
      break;
      if (((h)localObject).type != 2) {
        break;
      }
      j = this.xZC.getCount();
      k = this.xZE.xZs;
      if (j >= k)
      {
        ad.w("ad.waid.WaidProvider", "pubWaid >= max, curCnt=" + j + ", max=" + k);
        this.xZC.dEA();
      }
      this.xZC.a((h)localObject);
      break;
      long l2 = System.currentTimeMillis();
      ad.i("ad.waid.WaidProvider", "insert, totalTime=" + (l2 - l1));
      AppMethodBeat.o(100600);
      return paramUri;
    } while (i != 2);
    boolean bool2 = false;
    ad.i("ad.waid.WaidProvider", "insert, cfg old=" + this.xZE);
    boolean bool1 = bool2;
    if (paramContentValues.containsKey("maxAppWaidCount"))
    {
      j = bt.l(paramContentValues.getAsInteger("maxAppWaidCount"));
      if (j <= 0) {
        break label858;
      }
      i = j;
      if (j > 100) {
        break label858;
      }
      label595:
      bool1 = bool2;
      if (i != this.xZE.xZr)
      {
        this.xZE.xZr = i;
        bool1 = true;
      }
    }
    bool2 = bool1;
    if (paramContentValues.containsKey("maxPubWaidCount"))
    {
      j = bt.l(paramContentValues.getAsInteger("maxPubWaidCount"));
      if (j <= 0) {
        break label864;
      }
      i = j;
      if (j > 10) {
        break label864;
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (i != this.xZE.xZs)
      {
        this.xZE.xZs = i;
        bool2 = true;
      }
      bool1 = bool2;
      if (paramContentValues.containsKey("pubWaidSwitch"))
      {
        i = bt.l(paramContentValues.getAsInteger("pubWaidSwitch"));
        bool1 = bool2;
        if (i != this.xZE.xZt)
        {
          this.xZE.xZt = i;
          bool1 = true;
        }
      }
      ad.i("ad.waid.WaidProvider", "insert, cfg changed=".concat(String.valueOf(bool1)));
      if (bool1)
      {
        paramContentValues = getContext();
        localObject = this.xZE;
        if (localObject == null) {
          break label839;
        }
        localObject = ((f)localObject).toString();
        paramContentValues.getSharedPreferences("waid_cfg_sp", 0).edit().putString("cfg_data", (String)localObject).apply();
        ad.i("ad.waid.WaidCfg", "saveWaidCfg cfgStr=".concat(String.valueOf(localObject)));
      }
      for (;;)
      {
        AppMethodBeat.o(100600);
        return paramUri;
        label839:
        ad.e("ad.waid.WaidCfg", "saveWaidCfg cfg==null");
      }
      i += 1;
      break;
      label858:
      i = 100;
      break label595;
      label864:
      i = 10;
    }
  }
  
  public boolean onCreate()
  {
    AppMethodBeat.i(100599);
    long l = System.currentTimeMillis();
    try
    {
      this.xZD.addURI("com.tencent.mm.waidProvider", "waid", 1);
      this.xZD.addURI("com.tencent.mm.waidProvider", "cfg", 2);
      this.xZB = new a();
      this.xZB.init(getContext());
      this.xZC = new e();
      this.xZC.init(getContext());
      this.xZE = f.fY(getContext());
      g.afC().a(new WaidProvider.1(this));
      ad.i("ad.waid.WaidProvider", "onCreate, timeCost=" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(100599);
      return true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ad.i("ad.waid.WaidProvider", "onCreate, exp=" + localThrowable.toString());
      }
    }
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(100602);
    String str1;
    boolean bool;
    long l1;
    label277:
    int i;
    if (this.xZD.match(paramUri) == 1)
    {
      String str2 = "";
      paramString2 = "";
      str1 = getCallingPackage();
      bool = dEC();
      paramArrayOfString1 = paramString2;
      try
      {
        l1 = System.currentTimeMillis();
        paramString1 = str2;
        paramUri = paramString2;
        if (paramArrayOfString2 != null)
        {
          paramString1 = str2;
          paramUri = paramString2;
          paramArrayOfString1 = paramString2;
          if (paramArrayOfString2.length > 0)
          {
            paramString1 = paramArrayOfString2[0];
            paramUri = paramArrayOfString2[0];
          }
        }
        paramArrayOfString1 = paramUri;
        paramArrayOfString2 = paramString1;
        if (!TextUtils.isEmpty(paramString1)) {
          break label746;
        }
        paramArrayOfString2 = str1;
      }
      catch (Throwable paramUri)
      {
        ad.e("ad.waid.WaidProvider", "query exp=" + paramUri.toString());
        paramUri = paramArrayOfString1;
      }
      paramArrayOfString1 = paramUri;
      ad.i("ad.waid.WaidProvider", "query, paramPkg=" + paramUri + ", appIdCount=" + this.xZB.getCount() + ", pubIdCount=" + this.xZC.getCount() + ", thread=" + Thread.currentThread());
      if ((!bool) && (paramString1 != null))
      {
        paramArrayOfString1 = paramUri;
        if (!paramString1.equals(str1))
        {
          paramArrayOfString1 = paramUri;
          ad.w("ad.waid.WaidProvider", "query ret=null, !isReqFromMM && pkg!=self");
          paramArrayOfString1 = paramUri;
          r(str1, paramUri, 0, 0);
          AppMethodBeat.o(100602);
          return null;
        }
      }
      paramArrayOfString1 = paramUri;
      paramArrayOfString2 = this.xZB.aqU(paramString1);
      if (paramArrayOfString2 != null)
      {
        paramArrayOfString1 = paramUri;
        if (paramArrayOfString2.isExpired())
        {
          paramArrayOfString1 = paramUri;
          ad.w("ad.waid.WaidProvider", "appWaid is expire, delete");
          paramArrayOfString1 = paramUri;
          this.xZB.b(paramArrayOfString2);
          paramString1 = null;
          paramArrayOfString1 = paramString1;
          if (paramString1 != null) {
            break label760;
          }
          paramArrayOfString1 = paramUri;
          if (this.xZE.xZt != 1) {
            break label596;
          }
          i = 1;
          if (i == 0) {
            break label621;
          }
          paramArrayOfString1 = paramUri;
          paramString1 = this.xZC.dEz();
          if (paramString1 == null) {
            break label602;
          }
          paramArrayOfString1 = paramUri;
          if (!paramString1.isExpired()) {
            break label602;
          }
          paramArrayOfString1 = paramUri;
          ad.w("ad.waid.WaidProvider", "pubWaid is expire, delete");
          paramArrayOfString1 = paramUri;
          this.xZC.b(paramString1);
          paramString1 = null;
        }
      }
    }
    for (;;)
    {
      label354:
      long l2;
      if (paramString1 != null) {
        if (bool)
        {
          paramArrayOfString1 = paramUri;
          paramArrayOfString2 = new MatrixCursor(xZA, 1);
          paramArrayOfString1 = paramUri;
          paramString2 = paramArrayOfString2.newRow();
          paramArrayOfString1 = paramUri;
          paramString2.add("pkg", paramString1.dvP);
          paramArrayOfString1 = paramUri;
          paramString2.add("waid", paramString1.xZu);
          paramArrayOfString1 = paramUri;
          paramString2.add("expire", Integer.valueOf(paramString1.xZw));
          paramArrayOfString1 = paramUri;
          paramString2.add("timeStamp", Integer.valueOf(paramString1.xZv));
          paramArrayOfString1 = paramUri;
          paramString2.add("type", Integer.valueOf(paramString1.type));
          paramArrayOfString1 = paramUri;
          l2 = System.currentTimeMillis();
          paramArrayOfString1 = paramUri;
          ad.i("ad.waid.WaidProvider", "query from self, timeCost=" + (l2 - l1) + ", ret=" + paramString1);
          paramUri = paramArrayOfString2;
          label514:
          AppMethodBeat.o(100602);
          return paramUri;
          paramString1 = paramArrayOfString2;
          if (paramArrayOfString2 != null) {
            break label277;
          }
          paramArrayOfString1 = paramUri;
          ad.w("ad.waid.WaidProvider", "appWaid is null");
          paramString1 = paramArrayOfString2;
          break label277;
        }
      }
      for (;;)
      {
        if (!bool) {
          r(str1, paramUri, 0, 0);
        }
        AppMethodBeat.o(100602);
        return null;
        label596:
        i = 0;
        break;
        label602:
        paramArrayOfString1 = paramString1;
        if (paramString1 != null) {
          break label760;
        }
        paramArrayOfString1 = paramUri;
        ad.w("ad.waid.WaidProvider", "pubWaid is null");
        break label354;
        label621:
        paramArrayOfString1 = paramUri;
        ad.w("ad.waid.WaidProvider", "pubWaid is disabled");
        paramArrayOfString1 = paramString1;
        break label760;
        paramArrayOfString1 = paramUri;
        paramArrayOfString2 = new MatrixCursor(xZz, 1);
        paramArrayOfString1 = paramUri;
        paramArrayOfString2.newRow().add("waid", paramString1.xZu);
        paramArrayOfString1 = paramUri;
        l2 = System.currentTimeMillis();
        paramArrayOfString1 = paramUri;
        ad.i("ad.waid.WaidProvider", "query from other, timeCost=" + (l2 - l1) + ", ret=" + paramString1);
        paramArrayOfString1 = paramUri;
        r(str1, paramUri, 1, paramString1.type);
        paramUri = paramArrayOfString2;
        break label514;
        paramArrayOfString1 = paramUri;
        ad.w("ad.waid.WaidProvider", "query ret=null");
      }
      label746:
      paramString1 = paramArrayOfString2;
      if (paramArrayOfString2 != null) {
        break;
      }
      paramString1 = "";
      break;
      label760:
      paramString1 = paramArrayOfString1;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.WaidProvider
 * JD-Core Version:    0.7.0.1
 */