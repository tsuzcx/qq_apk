package com.tencent.qbar;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.util.List;

public final class f
  extends a
{
  private static boolean CJM;
  private static volatile boolean RKm;
  private WxQbarNative RKn;
  int RKo;
  
  static
  {
    AppMethodBeat.i(91167);
    RKm = true;
    CJM = true;
    hkl();
    AppMethodBeat.o(91167);
  }
  
  public f()
  {
    AppMethodBeat.i(91157);
    this.RKn = new WxQbarNative();
    this.RKo = 0;
    AppMethodBeat.o(91157);
  }
  
  public static void DN(boolean paramBoolean)
  {
    AppMethodBeat.i(176206);
    Log.i("MicroMsg.WxQBar", "alvinluo setEnableMultiCode: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    CJM = paramBoolean;
    AppMethodBeat.o(176206);
  }
  
  public static void hkl()
  {
    AppMethodBeat.i(91158);
    int i = ((b)g.af(b.class)).a(b.a.sen, 0);
    if (i != 1) {}
    for (boolean bool = true;; bool = false)
    {
      RKm = bool;
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {
        RKm = true;
      }
      if (RKm)
      {
        int j = ((b)g.af(b.class)).a(b.a.seo, 0);
        if (j > 0)
        {
          ActivityManager localActivityManager = (ActivityManager)MMApplicationContext.getContext().getSystemService("activity");
          ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
          localActivityManager.getMemoryInfo(localMemoryInfo);
          if ((localMemoryInfo.totalMem > 0L) && ((float)localMemoryInfo.totalMem * 1.0F / 1048576.0F <= j)) {
            RKm = false;
          }
          Log.i("MicroMsg.WxQBar", "alvinluo checkMemoryLimit totalMemory: %s bytes, %s MB, config memoryLimit: %d, useNewScanInterface: %b", new Object[] { Long.valueOf(localMemoryInfo.totalMem), Float.valueOf((float)localMemoryInfo.totalMem * 1.0F / 1048576.0F), Integer.valueOf(j), Boolean.valueOf(RKm) });
        }
      }
      Log.i("MicroMsg.WxQBar", "alvinluo updateUseNewScanInterfaceStatus config: %d, useNewScanInterface: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(RKm) });
      AppMethodBeat.o(91158);
      return;
    }
  }
  
  public static boolean hkm()
  {
    return RKm;
  }
  
  public final int S(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91160);
    Log.i("MicroMsg.WxQBar", "alvinluo scanImage width: %d, height: %d, grayImage: %d, useNewScanInterface: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length), Boolean.valueOf(RKm) });
    if (RKm) {
      try
      {
        if (this.RJt < 0) {
          return -1;
        }
        paramInt1 = this.RKn.ScanImage712(paramArrayOfByte, paramInt1, paramInt2, this.RJt);
        return paramInt1;
      }
      finally
      {
        AppMethodBeat.o(91160);
      }
    }
    paramInt1 = super.S(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(91160);
    return paramInt1;
  }
  
  public final int aG(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(194830);
    int i = this.RKn.SetTouchCoordinate(this.RJt, paramFloat1, paramFloat2);
    AppMethodBeat.o(194830);
    return i;
  }
  
  public final int aqy(int paramInt)
  {
    AppMethodBeat.i(176207);
    this.RKn.AddBlackInternal(paramInt, this.RJt);
    AppMethodBeat.o(176207);
    return 0;
  }
  
  public final int b(List<a.a> paramList, List<QbarNative.QBarPoint> paramList1, List<WxQbarNative.QBarReportMsg> paramList2, boolean paramBoolean)
  {
    AppMethodBeat.i(91162);
    QbarNative.QBarResultJNI[] arrayOfQBarResultJNI = new QbarNative.QBarResultJNI[3];
    QbarNative.QBarPoint[] arrayOfQBarPoint = new QbarNative.QBarPoint[3];
    WxQbarNative.QBarReportMsg[] arrayOfQBarReportMsg = new WxQbarNative.QBarReportMsg[3];
    int i = 0;
    while (i < 3)
    {
      arrayOfQBarResultJNI[i] = new QbarNative.QBarResultJNI();
      arrayOfQBarResultJNI[i].charset = new String();
      arrayOfQBarResultJNI[i].data = new byte[1024];
      arrayOfQBarResultJNI[i].typeName = new String();
      arrayOfQBarPoint[i] = new QbarNative.QBarPoint();
      arrayOfQBarReportMsg[i] = new WxQbarNative.QBarReportMsg();
      arrayOfQBarReportMsg[i].binaryMethod = new String();
      arrayOfQBarReportMsg[i].charsetMode = new String();
      arrayOfQBarReportMsg[i].ecLevel = new String();
      arrayOfQBarReportMsg[i].scaleList = new String();
      i += 1;
    }
    i = 0;
    if ((RKm) && (paramBoolean))
    {
      j = this.RKn.GetDetailResultsNew(arrayOfQBarResultJNI, arrayOfQBarPoint, arrayOfQBarReportMsg, this.RJt);
      this.RKo = (j - 1);
      i = j;
      if (CJM)
      {
        i = j;
        if (j <= 0)
        {
          Log.w("MicroMsg.WxQBar", "alvinluo getResults ret: %d", new Object[] { Integer.valueOf(j) });
          AppMethodBeat.o(91162);
          return 0;
        }
      }
    }
    else
    {
      this.RKn.GetDetailResults(arrayOfQBarResultJNI, arrayOfQBarPoint, arrayOfQBarReportMsg, this.RJt);
    }
    int j = 0;
    for (;;)
    {
      QbarNative.QBarResultJNI localQBarResultJNI;
      if (j < 3) {
        localQBarResultJNI = arrayOfQBarResultJNI[j];
      }
      for (;;)
      {
        try
        {
          if (Util.isNullOrNil(localQBarResultJNI.typeName)) {
            continue;
          }
          locala = new a.a();
          locala.charset = localQBarResultJNI.charset;
          locala.typeID = localQBarResultJNI.typeID;
          locala.typeName = localQBarResultJNI.typeName;
          locala.rawData = localQBarResultJNI.data;
          locala.priorityLevel = localQBarResultJNI.priorityLevel;
          if (!locala.charset.equals("ANY")) {
            continue;
          }
          locala.data = new String(localQBarResultJNI.data, "UTF-8");
          if (locala.data.length() == 0) {
            locala.data = new String(localQBarResultJNI.data, "ASCII");
          }
          paramList.add(locala);
          if ((CJM) || (paramList.size() <= 0)) {
            continue;
          }
          Log.w("MicroMsg.WxQBar", "alvinluo getResults not enableMultiCode and ignore other results");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          a.a locala;
          Log.e("MicroMsg.WxQBar", "GetResults exp:" + localUnsupportedEncodingException.getMessage());
          continue;
          j += 1;
        }
        if ((paramList1 == null) || (!RKm)) {
          break label582;
        }
        j = 0;
        if (j >= 3) {
          break label582;
        }
        arrayOfQBarResultJNI = arrayOfQBarPoint[j];
        if (arrayOfQBarResultJNI.point_cnt != 0) {
          paramList1.add(arrayOfQBarResultJNI);
        }
        j += 1;
        continue;
        locala.data = new String(localQBarResultJNI.data, locala.charset);
      }
    }
    label582:
    if (paramList2 != null)
    {
      j = 0;
      while (j < 3)
      {
        paramList1 = arrayOfQBarReportMsg[j];
        if (!Util.isNullOrNil(paramList1.charsetMode)) {
          paramList2.add(paramList1);
        }
        j += 1;
      }
    }
    if ((RKm) && (paramBoolean) && (CJM) && (i > 0))
    {
      Log.i("MicroMsg.WxQBar", "alvinluo getResults ret: %d, result size: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramList.size()) });
      i = paramList.size();
      AppMethodBeat.o(91162);
      return i;
    }
    i = paramList.size();
    AppMethodBeat.o(91162);
    return i;
  }
  
  public final int bpW(String paramString)
  {
    AppMethodBeat.i(91164);
    this.RKn.AddWhiteList(paramString, this.RJt);
    AppMethodBeat.o(91164);
    return 0;
  }
  
  public final int bpX(String paramString)
  {
    AppMethodBeat.i(91165);
    this.RKn.AddBlackList(paramString, this.RJt);
    AppMethodBeat.o(91165);
    return 0;
  }
  
  public final int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(91159);
    if (paramBoolean)
    {
      paramInt1 = S(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(91159);
      return paramInt1;
    }
    paramInt1 = super.S(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(91159);
    return paramInt1;
  }
  
  public final String jS()
  {
    AppMethodBeat.i(194829);
    try
    {
      if (this.RJt < 0) {
        return null;
      }
      String str = this.RKn.GetDebugString(this.RJt);
      return str;
    }
    finally
    {
      AppMethodBeat.o(194829);
    }
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(194828);
    if (RKm) {
      try
      {
        if (this.RJt < 0) {
          return;
        }
        Log.i("MicroMsg.WxQBar", "alvinluo reset WxQBar qbarId: %d, forZoom: %b", new Object[] { Integer.valueOf(this.RJt), Boolean.valueOf(paramBoolean) });
        this.RKn.Reset(this.RJt, paramBoolean);
        return;
      }
      finally
      {
        AppMethodBeat.o(194828);
      }
    }
    AppMethodBeat.o(194828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.f
 * JD-Core Version:    0.7.0.1
 */