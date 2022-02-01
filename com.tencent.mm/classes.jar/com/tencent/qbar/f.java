package com.tencent.qbar;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.util.List;

public final class f
  extends a
{
  private static volatile boolean ahrr;
  boolean OXQ;
  private WxQbarNative ahrs;
  int ahrt;
  
  static
  {
    AppMethodBeat.i(91167);
    ahrr = true;
    jWR();
    AppMethodBeat.o(91167);
  }
  
  public f()
  {
    AppMethodBeat.i(91157);
    this.ahrs = new WxQbarNative();
    this.ahrt = 0;
    this.OXQ = true;
    AppMethodBeat.o(91157);
  }
  
  public static void jWR()
  {
    AppMethodBeat.i(91158);
    int i = ((c)h.ax(c.class)).a(c.a.zfZ, 0);
    if (i != 1) {}
    for (boolean bool = true;; bool = false)
    {
      ahrr = bool;
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {
        ahrr = true;
      }
      if (ahrr)
      {
        int j = ((c)h.ax(c.class)).a(c.a.zga, 0);
        if (j > 0)
        {
          ActivityManager localActivityManager = (ActivityManager)MMApplicationContext.getContext().getSystemService("activity");
          ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
          localActivityManager.getMemoryInfo(localMemoryInfo);
          if ((localMemoryInfo.totalMem > 0L) && ((float)localMemoryInfo.totalMem * 1.0F / 1048576.0F <= j)) {
            ahrr = false;
          }
          Log.i("MicroMsg.WxQBar", "alvinluo checkMemoryLimit totalMemory: %s bytes, %s MB, config memoryLimit: %d, useNewScanInterface: %b", new Object[] { Long.valueOf(localMemoryInfo.totalMem), Float.valueOf((float)localMemoryInfo.totalMem * 1.0F / 1048576.0F), Integer.valueOf(j), Boolean.valueOf(ahrr) });
        }
      }
      Log.i("MicroMsg.WxQBar", "alvinluo updateUseNewScanInterfaceStatus config: %d, useNewScanInterface: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(ahrr) });
      AppMethodBeat.o(91158);
      return;
    }
  }
  
  public static boolean jWS()
  {
    return ahrr;
  }
  
  public final String GR()
  {
    AppMethodBeat.i(226829);
    try
    {
      if (this.ahqv < 0) {
        return null;
      }
      String str = this.ahrs.GetDebugString(this.ahqv);
      return str;
    }
    finally
    {
      AppMethodBeat.o(226829);
    }
  }
  
  public final int R(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91160);
    Log.i("MicroMsg.WxQBar", "alvinluo scanImage width: %d, height: %d, grayImage: %d, useNewScanInterface: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length), Boolean.valueOf(ahrr) });
    if (ahrr) {
      try
      {
        if (this.ahqv < 0) {
          return -1;
        }
        paramInt1 = this.ahrs.ScanImage712(paramArrayOfByte, paramInt1, paramInt2, this.ahqv);
        return paramInt1;
      }
      finally
      {
        AppMethodBeat.o(91160);
      }
    }
    paramInt1 = super.R(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(91160);
    return paramInt1;
  }
  
  public final int aGX(int paramInt)
  {
    AppMethodBeat.i(176207);
    this.ahrs.AddBlackInternal(paramInt, this.ahqv);
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
    if ((ahrr) && (paramBoolean))
    {
      j = this.ahrs.GetDetailResultsNew(arrayOfQBarResultJNI, arrayOfQBarPoint, arrayOfQBarReportMsg, this.ahqv);
      this.ahrt = (j - 1);
      i = j;
      if (this.OXQ)
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
      this.ahrs.GetDetailResults(arrayOfQBarResultJNI, arrayOfQBarPoint, arrayOfQBarReportMsg, this.ahqv);
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
          if ((this.OXQ) || (paramList.size() <= 0)) {
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
        if ((paramList1 == null) || (!ahrr)) {
          break label584;
        }
        j = 0;
        if (j >= 3) {
          break label584;
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
    label584:
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
    if ((ahrr) && (paramBoolean) && (this.OXQ) && (i > 0))
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
  
  public final int bFs(String paramString)
  {
    AppMethodBeat.i(91164);
    this.ahrs.AddWhiteList(paramString, this.ahqv);
    AppMethodBeat.o(91164);
    return 0;
  }
  
  public final int bFt(String paramString)
  {
    AppMethodBeat.i(91165);
    this.ahrs.AddBlackList(paramString, this.ahqv);
    AppMethodBeat.o(91165);
    return 0;
  }
  
  public final int bs(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(226831);
    int i = this.ahrs.SetTouchCoordinate(this.ahqv, paramFloat1, paramFloat2);
    AppMethodBeat.o(226831);
    return i;
  }
  
  public final int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(91159);
    if (paramBoolean)
    {
      paramInt1 = R(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(91159);
      return paramInt1;
    }
    paramInt1 = super.R(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(91159);
    return paramInt1;
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(226827);
    if (ahrr) {
      try
      {
        if (this.ahqv < 0) {
          return;
        }
        Log.i("MicroMsg.WxQBar", "alvinluo reset WxQBar qbarId: %d, forZoom: %b", new Object[] { Integer.valueOf(this.ahqv), Boolean.valueOf(paramBoolean) });
        this.ahrs.Reset(this.ahqv, paramBoolean);
        return;
      }
      finally
      {
        AppMethodBeat.o(226827);
      }
    }
    AppMethodBeat.o(226827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qbar.f
 * JD-Core Version:    0.7.0.1
 */