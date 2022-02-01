package com.tencent.qbar;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
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
  private static boolean IPn;
  private static volatile boolean ZmU;
  private WxQbarNative ZmV;
  int ZmW;
  
  static
  {
    AppMethodBeat.i(91167);
    ZmU = true;
    IPn = true;
    inI();
    AppMethodBeat.o(91167);
  }
  
  public f()
  {
    AppMethodBeat.i(91157);
    this.ZmV = new WxQbarNative();
    this.ZmW = 0;
    AppMethodBeat.o(91157);
  }
  
  public static void Io(boolean paramBoolean)
  {
    AppMethodBeat.i(176206);
    Log.i("MicroMsg.WxQBar", "alvinluo setEnableMultiCode: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    IPn = paramBoolean;
    AppMethodBeat.o(176206);
  }
  
  public static void inI()
  {
    AppMethodBeat.i(91158);
    int i = ((b)h.ae(b.class)).a(b.a.vNS, 0);
    if (i != 1) {}
    for (boolean bool = true;; bool = false)
    {
      ZmU = bool;
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {
        ZmU = true;
      }
      if (ZmU)
      {
        int j = ((b)h.ae(b.class)).a(b.a.vNT, 0);
        if (j > 0)
        {
          ActivityManager localActivityManager = (ActivityManager)MMApplicationContext.getContext().getSystemService("activity");
          ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
          localActivityManager.getMemoryInfo(localMemoryInfo);
          if ((localMemoryInfo.totalMem > 0L) && ((float)localMemoryInfo.totalMem * 1.0F / 1048576.0F <= j)) {
            ZmU = false;
          }
          Log.i("MicroMsg.WxQBar", "alvinluo checkMemoryLimit totalMemory: %s bytes, %s MB, config memoryLimit: %d, useNewScanInterface: %b", new Object[] { Long.valueOf(localMemoryInfo.totalMem), Float.valueOf((float)localMemoryInfo.totalMem * 1.0F / 1048576.0F), Integer.valueOf(j), Boolean.valueOf(ZmU) });
        }
      }
      Log.i("MicroMsg.WxQBar", "alvinluo updateUseNewScanInterfaceStatus config: %d, useNewScanInterface: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(ZmU) });
      AppMethodBeat.o(91158);
      return;
    }
  }
  
  public static boolean inJ()
  {
    return ZmU;
  }
  
  public final int U(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91160);
    Log.i("MicroMsg.WxQBar", "alvinluo scanImage width: %d, height: %d, grayImage: %d, useNewScanInterface: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length), Boolean.valueOf(ZmU) });
    if (ZmU) {
      try
      {
        if (this.Zmb < 0) {
          return -1;
        }
        paramInt1 = this.ZmV.ScanImage712(paramArrayOfByte, paramInt1, paramInt2, this.Zmb);
        return paramInt1;
      }
      finally
      {
        AppMethodBeat.o(91160);
      }
    }
    paramInt1 = super.U(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(91160);
    return paramInt1;
  }
  
  public final int aAl(int paramInt)
  {
    AppMethodBeat.i(176207);
    this.ZmV.AddBlackInternal(paramInt, this.Zmb);
    AppMethodBeat.o(176207);
    return 0;
  }
  
  public final int aN(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(193446);
    int i = this.ZmV.SetTouchCoordinate(this.Zmb, paramFloat1, paramFloat2);
    AppMethodBeat.o(193446);
    return i;
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
    if ((ZmU) && (paramBoolean))
    {
      j = this.ZmV.GetDetailResultsNew(arrayOfQBarResultJNI, arrayOfQBarPoint, arrayOfQBarReportMsg, this.Zmb);
      this.ZmW = (j - 1);
      i = j;
      if (IPn)
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
      this.ZmV.GetDetailResults(arrayOfQBarResultJNI, arrayOfQBarPoint, arrayOfQBarReportMsg, this.Zmb);
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
          if ((IPn) || (paramList.size() <= 0)) {
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
        if ((paramList1 == null) || (!ZmU)) {
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
    if ((ZmU) && (paramBoolean) && (IPn) && (i > 0))
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
  
  public final int bCO(String paramString)
  {
    AppMethodBeat.i(91164);
    this.ZmV.AddWhiteList(paramString, this.Zmb);
    AppMethodBeat.o(91164);
    return 0;
  }
  
  public final int bCP(String paramString)
  {
    AppMethodBeat.i(91165);
    this.ZmV.AddBlackList(paramString, this.Zmb);
    AppMethodBeat.o(91165);
    return 0;
  }
  
  public final int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(91159);
    if (paramBoolean)
    {
      paramInt1 = U(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(91159);
      return paramInt1;
    }
    paramInt1 = super.U(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(91159);
    return paramInt1;
  }
  
  public final String iN()
  {
    AppMethodBeat.i(193417);
    try
    {
      if (this.Zmb < 0) {
        return null;
      }
      String str = this.ZmV.GetDebugString(this.Zmb);
      return str;
    }
    finally
    {
      AppMethodBeat.o(193417);
    }
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(193412);
    if (ZmU) {
      try
      {
        if (this.Zmb < 0) {
          return;
        }
        Log.i("MicroMsg.WxQBar", "alvinluo reset WxQBar qbarId: %d, forZoom: %b", new Object[] { Integer.valueOf(this.Zmb), Boolean.valueOf(paramBoolean) });
        this.ZmV.Reset(this.Zmb, paramBoolean);
        return;
      }
      finally
      {
        AppMethodBeat.o(193412);
      }
    }
    AppMethodBeat.o(193412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.f
 * JD-Core Version:    0.7.0.1
 */