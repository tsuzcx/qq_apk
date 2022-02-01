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
import com.tencent.mm.model.ce;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONArray;
import org.json.JSONObject;

public class WaidProvider
  extends ContentProvider
{
  private static final Uri AUTHORITY_URI;
  private static String[] zmA;
  public static final Uri zmx;
  public static final Uri zmy;
  private static String[] zmz;
  private d zmB;
  private d zmC;
  private UriMatcher zmD;
  private f zmE;
  private boolean zmF;
  
  static
  {
    AppMethodBeat.i(100606);
    Uri localUri = Uri.parse("content://com.tencent.mm.waidProvider");
    AUTHORITY_URI = localUri;
    zmx = Uri.withAppendedPath(localUri, "waid");
    zmy = Uri.withAppendedPath(AUTHORITY_URI, "cfg");
    zmz = new String[] { "waid" };
    zmA = new String[] { "pkg", "waid", "expire", "timeStamp", "type" };
    AppMethodBeat.o(100606);
  }
  
  public WaidProvider()
  {
    AppMethodBeat.i(100598);
    this.zmD = new UriMatcher(-1);
    this.zmF = false;
    AppMethodBeat.o(100598);
  }
  
  private void Qg(int paramInt)
  {
    AppMethodBeat.i(100605);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      str1 = bs.nullAsNil(getCallingPackage());
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          String str1;
          localJSONObject.put("srcPkg", str1);
          localJSONObject.put("appWaidNum", this.zmB.getCount());
          localJSONObject.put("pubWaidNum", this.zmC.getCount());
          ac.i("ad.waid.WaidProvider", "reportModify, action=" + paramInt + ", data=" + localJSONObject.toString() + ", isKernelInted=" + this.zmF);
          if (this.zmF) {
            com.tencent.mm.plugin.report.service.h.wUl.f(18666, new Object[] { Integer.valueOf(paramInt), localJSONObject.toString() });
          }
          AppMethodBeat.o(100605);
          return;
        }
        catch (Throwable localThrowable)
        {
          String str2;
          ac.e("ad.waid.WaidProvider", "reportQuery exp=" + localThrowable.toString());
          AppMethodBeat.o(100605);
        }
        localException = localException;
        ac.e("ad.waid.WaidProvider", "reportQuery getCallingPackage exp=" + localException.toString());
        str2 = "";
      }
    }
  }
  
  private boolean dTb()
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
      ac.i("ad.waid.WaidProvider", "isReqFromMM, ret=" + bool1 + ", srcPkg=" + str1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("ad.waid.WaidProvider", "isReqFromMM, exp=" + localException.toString());
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
      localJSONObject.put("appWaidNum", this.zmB.getCount());
      localJSONObject.put("pubWaidNum", this.zmC.getCount());
      localJSONObject.put("idType", paramInt2);
      localJSONObject.put("ret", paramInt1);
      ac.i("ad.waid.WaidProvider", "reportQuery data=" + localJSONObject.toString() + ", isKernelInted=" + this.zmF);
      if (this.zmF) {
        com.tencent.mm.plugin.report.service.h.wUl.f(18666, new Object[] { Integer.valueOf(1), localJSONObject.toString() });
      }
      AppMethodBeat.o(100604);
      return;
    }
    catch (Throwable paramString1)
    {
      ac.e("ad.waid.WaidProvider", "reportQuery exp=" + paramString1.toString());
      AppMethodBeat.o(100604);
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(100601);
    try
    {
      long l1 = System.currentTimeMillis();
      if (this.zmD.match(paramUri) == 1)
      {
        if (!dTb())
        {
          ac.w("ad.waid.WaidProvider", "delete ret=false, !isReqFromMM");
          Qg(2);
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
          paramString.dtC = paramUri;
          paramString.type = 1;
          boolean bool = this.zmB.b(paramString);
          long l2 = System.currentTimeMillis();
          ac.i("ad.waid.WaidProvider", "delete, timeCost=" + (l2 - l1) + ", ret=" + bool + ", pkg=" + paramUri + ", thread=" + Thread.currentThread());
          if (bool)
          {
            AppMethodBeat.o(100601);
            return 1;
          }
          AppMethodBeat.o(100601);
          return 0;
        }
        ac.w("ad.waid.WaidProvider", "delete, pkg=null");
      }
    }
    catch (Throwable paramUri)
    {
      for (;;)
      {
        ac.e("ad.waid.WaidProvider", "delete exp=" + paramUri.toString());
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
        if ((!dTb()) || (paramContentValues == null))
        {
          ac.w("ad.waid.WaidProvider", "insert ret=false, !isReqFromMM");
          Qg(3);
          AppMethodBeat.o(100600);
          return null;
        }
        i = this.zmD.match(paramUri);
        if (i != 1) {
          continue;
        }
        paramContentValues = bs.nullAsNil(paramContentValues.getAsString("waid_array"));
        ac.i("ad.waid.WaidProvider", "insert, jsonStr=" + paramContentValues + ", thread=" + Thread.currentThread());
        this.zmB.dTa();
        this.zmC.dTa();
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
        localObject = h.aI((JSONObject)localObject);
        if (localObject == null) {
          break;
        }
        try
        {
          ((h)localObject).zmv = ce.azK();
          if (!((h)localObject).isValid()) {
            ac.e("ad.waid.WaidProvider", "invalid item, pass");
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ((h)localObject).zmv = ((int)(System.currentTimeMillis() / 1000L));
            ac.e("ad.waid.WaidProvider", "insert timeStamp exp=" + localThrowable.toString());
          }
        }
        if (((h)localObject).type != 1) {
          break label384;
        }
      }
      catch (Throwable paramUri)
      {
        ac.e("ad.waid.WaidProvider", "insert exp=" + paramUri.toString());
        AppMethodBeat.o(100600);
        return null;
      }
      j = this.zmB.getCount();
      int k = this.zmE.zmr;
      if (j >= k)
      {
        ac.w("ad.waid.WaidProvider", "appWaid > max, curCount=" + j + ", max=" + k);
        this.zmB.dSZ();
      }
      this.zmB.a((h)localObject);
      break;
      if (((h)localObject).type != 2) {
        break;
      }
      j = this.zmC.getCount();
      k = this.zmE.zms;
      if (j >= k)
      {
        ac.w("ad.waid.WaidProvider", "pubWaid >= max, curCnt=" + j + ", max=" + k);
        this.zmC.dSZ();
      }
      this.zmC.a((h)localObject);
      break;
      long l2 = System.currentTimeMillis();
      ac.i("ad.waid.WaidProvider", "insert, totalTime=" + (l2 - l1));
      AppMethodBeat.o(100600);
      return paramUri;
    } while (i != 2);
    boolean bool2 = false;
    ac.i("ad.waid.WaidProvider", "insert, cfg old=" + this.zmE);
    boolean bool1 = bool2;
    if (paramContentValues.containsKey("maxAppWaidCount"))
    {
      j = bs.m(paramContentValues.getAsInteger("maxAppWaidCount"));
      if (j <= 0) {
        break label858;
      }
      i = j;
      if (j > 100) {
        break label858;
      }
      label595:
      bool1 = bool2;
      if (i != this.zmE.zmr)
      {
        this.zmE.zmr = i;
        bool1 = true;
      }
    }
    bool2 = bool1;
    if (paramContentValues.containsKey("maxPubWaidCount"))
    {
      j = bs.m(paramContentValues.getAsInteger("maxPubWaidCount"));
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
      if (i != this.zmE.zms)
      {
        this.zmE.zms = i;
        bool2 = true;
      }
      bool1 = bool2;
      if (paramContentValues.containsKey("pubWaidSwitch"))
      {
        i = bs.m(paramContentValues.getAsInteger("pubWaidSwitch"));
        bool1 = bool2;
        if (i != this.zmE.zmt)
        {
          this.zmE.zmt = i;
          bool1 = true;
        }
      }
      ac.i("ad.waid.WaidProvider", "insert, cfg changed=".concat(String.valueOf(bool1)));
      if (bool1)
      {
        paramContentValues = getContext();
        localObject = this.zmE;
        if (localObject == null) {
          break label839;
        }
        localObject = ((f)localObject).toString();
        paramContentValues.getSharedPreferences("waid_cfg_sp", 0).edit().putString("cfg_data", (String)localObject).apply();
        ac.i("ad.waid.WaidCfg", "saveWaidCfg cfgStr=".concat(String.valueOf(localObject)));
      }
      for (;;)
      {
        AppMethodBeat.o(100600);
        return paramUri;
        label839:
        ac.e("ad.waid.WaidCfg", "saveWaidCfg cfg==null");
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
      this.zmD.addURI("com.tencent.mm.waidProvider", "waid", 1);
      this.zmD.addURI("com.tencent.mm.waidProvider", "cfg", 2);
      this.zmB = new a();
      this.zmB.init(getContext());
      this.zmC = new e();
      this.zmC.init(getContext());
      this.zmE = f.gk(getContext());
      com.tencent.mm.kernel.g.agS().a(new com.tencent.mm.kernel.api.g()
      {
        public final void Lh()
        {
          AppMethodBeat.i(162067);
          WaidProvider.a(WaidProvider.this);
          ac.i("ad.waid.WaidProvider", "kernel, onStartupDone");
          try
          {
            com.tencent.mm.kernel.g.agS().b(this);
            AppMethodBeat.o(162067);
            return;
          }
          catch (Exception localException)
          {
            ac.e("ad.waid.WaidProvider", "removeKernelCallback, exp=" + localException.toString());
            AppMethodBeat.o(162067);
          }
        }
        
        public final void cf(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(162068);
          ac.i("ad.waid.WaidProvider", "kernel, onExit");
          AppMethodBeat.o(162068);
        }
      });
      ac.i("ad.waid.WaidProvider", "onCreate, timeCost=" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(100599);
      return true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ac.i("ad.waid.WaidProvider", "onCreate, exp=" + localThrowable.toString());
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
    if (this.zmD.match(paramUri) == 1)
    {
      String str2 = "";
      paramString2 = "";
      str1 = getCallingPackage();
      bool = dTb();
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
        ac.e("ad.waid.WaidProvider", "query exp=" + paramUri.toString());
        paramUri = paramArrayOfString1;
      }
      paramArrayOfString1 = paramUri;
      ac.i("ad.waid.WaidProvider", "query, paramPkg=" + paramUri + ", appIdCount=" + this.zmB.getCount() + ", pubIdCount=" + this.zmC.getCount() + ", thread=" + Thread.currentThread());
      if ((!bool) && (paramString1 != null))
      {
        paramArrayOfString1 = paramUri;
        if (!paramString1.equals(str1))
        {
          paramArrayOfString1 = paramUri;
          ac.w("ad.waid.WaidProvider", "query ret=null, !isReqFromMM && pkg!=self");
          paramArrayOfString1 = paramUri;
          r(str1, paramUri, 0, 0);
          AppMethodBeat.o(100602);
          return null;
        }
      }
      paramArrayOfString1 = paramUri;
      paramArrayOfString2 = this.zmB.awd(paramString1);
      if (paramArrayOfString2 != null)
      {
        paramArrayOfString1 = paramUri;
        if (paramArrayOfString2.isExpired())
        {
          paramArrayOfString1 = paramUri;
          ac.w("ad.waid.WaidProvider", "appWaid is expire, delete");
          paramArrayOfString1 = paramUri;
          this.zmB.b(paramArrayOfString2);
          paramString1 = null;
          paramArrayOfString1 = paramString1;
          if (paramString1 != null) {
            break label760;
          }
          paramArrayOfString1 = paramUri;
          if (this.zmE.zmt != 1) {
            break label596;
          }
          i = 1;
          if (i == 0) {
            break label621;
          }
          paramArrayOfString1 = paramUri;
          paramString1 = this.zmC.dSY();
          if (paramString1 == null) {
            break label602;
          }
          paramArrayOfString1 = paramUri;
          if (!paramString1.isExpired()) {
            break label602;
          }
          paramArrayOfString1 = paramUri;
          ac.w("ad.waid.WaidProvider", "pubWaid is expire, delete");
          paramArrayOfString1 = paramUri;
          this.zmC.b(paramString1);
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
          paramArrayOfString2 = new MatrixCursor(zmA, 1);
          paramArrayOfString1 = paramUri;
          paramString2 = paramArrayOfString2.newRow();
          paramArrayOfString1 = paramUri;
          paramString2.add("pkg", paramString1.dtC);
          paramArrayOfString1 = paramUri;
          paramString2.add("waid", paramString1.zmu);
          paramArrayOfString1 = paramUri;
          paramString2.add("expire", Integer.valueOf(paramString1.zmw));
          paramArrayOfString1 = paramUri;
          paramString2.add("timeStamp", Integer.valueOf(paramString1.zmv));
          paramArrayOfString1 = paramUri;
          paramString2.add("type", Integer.valueOf(paramString1.type));
          paramArrayOfString1 = paramUri;
          l2 = System.currentTimeMillis();
          paramArrayOfString1 = paramUri;
          ac.i("ad.waid.WaidProvider", "query from self, timeCost=" + (l2 - l1) + ", ret=" + paramString1);
          paramUri = paramArrayOfString2;
          label514:
          AppMethodBeat.o(100602);
          return paramUri;
          paramString1 = paramArrayOfString2;
          if (paramArrayOfString2 != null) {
            break label277;
          }
          paramArrayOfString1 = paramUri;
          ac.w("ad.waid.WaidProvider", "appWaid is null");
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
        ac.w("ad.waid.WaidProvider", "pubWaid is null");
        break label354;
        label621:
        paramArrayOfString1 = paramUri;
        ac.w("ad.waid.WaidProvider", "pubWaid is disabled");
        paramArrayOfString1 = paramString1;
        break label760;
        paramArrayOfString1 = paramUri;
        paramArrayOfString2 = new MatrixCursor(zmz, 1);
        paramArrayOfString1 = paramUri;
        paramArrayOfString2.newRow().add("waid", paramString1.zmu);
        paramArrayOfString1 = paramUri;
        l2 = System.currentTimeMillis();
        paramArrayOfString1 = paramUri;
        ac.i("ad.waid.WaidProvider", "query from other, timeCost=" + (l2 - l1) + ", ret=" + paramString1);
        paramArrayOfString1 = paramUri;
        r(str1, paramUri, 1, paramString1.type);
        paramUri = paramArrayOfString2;
        break label514;
        paramArrayOfString1 = paramUri;
        ac.w("ad.waid.WaidProvider", "query ret=null");
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