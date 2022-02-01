package com.tencent.qbar;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import java.io.UnsupportedEncodingException;
import java.util.List;

public final class f
  extends a
{
  private static volatile boolean MhL;
  private static boolean yFX;
  private WxQbarNative MhM;
  int MhN;
  
  static
  {
    AppMethodBeat.i(91167);
    MhL = true;
    yFX = true;
    fXZ();
    AppMethodBeat.o(91167);
  }
  
  public f()
  {
    AppMethodBeat.i(91157);
    this.MhM = new WxQbarNative();
    this.MhN = 0;
    AppMethodBeat.o(91157);
  }
  
  public static void fXZ()
  {
    AppMethodBeat.i(91158);
    int i = ((b)g.ab(b.class)).a(b.a.qIQ, 0);
    if (i != 1) {}
    for (boolean bool = true;; bool = false)
    {
      MhL = bool;
      if ((j.IS_FLAVOR_RED) || (j.DEBUG)) {
        MhL = true;
      }
      if (MhL)
      {
        int j = ((b)g.ab(b.class)).a(b.a.qIR, 0);
        if (j > 0)
        {
          ActivityManager localActivityManager = (ActivityManager)ak.getContext().getSystemService("activity");
          ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
          localActivityManager.getMemoryInfo(localMemoryInfo);
          if ((localMemoryInfo.totalMem > 0L) && ((float)localMemoryInfo.totalMem * 1.0F / 1048576.0F <= j)) {
            MhL = false;
          }
          ae.i("MicroMsg.WxQBar", "alvinluo checkMemoryLimit totalMemory: %s bytes, %s MB, config memoryLimit: %d, useNewScanInterface: %b", new Object[] { Long.valueOf(localMemoryInfo.totalMem), Float.valueOf((float)localMemoryInfo.totalMem * 1.0F / 1048576.0F), Integer.valueOf(j), Boolean.valueOf(MhL) });
        }
      }
      ae.i("MicroMsg.WxQBar", "alvinluo updateUseNewScanInterfaceStatus config: %d, useNewScanInterface: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(MhL) });
      AppMethodBeat.o(91158);
      return;
    }
  }
  
  public static boolean fYa()
  {
    return MhL;
  }
  
  public static void zD(boolean paramBoolean)
  {
    AppMethodBeat.i(176206);
    ae.i("MicroMsg.WxQBar", "alvinluo setEnableMultiCode: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    yFX = paramBoolean;
    AppMethodBeat.o(176206);
  }
  
  public final int H(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91160);
    ae.i("MicroMsg.WxQBar", "alvinluo scanImage width: %d, height: %d, grayImage: %d, useNewScanInterface: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length), Boolean.valueOf(MhL) });
    if (MhL) {
      try
      {
        if (this.MgS < 0) {
          return -1;
        }
        paramInt1 = this.MhM.ScanImage712(paramArrayOfByte, paramInt1, paramInt2, this.MgS);
        return paramInt1;
      }
      finally
      {
        AppMethodBeat.o(91160);
      }
    }
    paramInt1 = super.H(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(91160);
    return paramInt1;
  }
  
  public final int X(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(91163);
    this.MhM.SetCenterCoordinate(paramInt1, paramInt2, paramInt3, paramInt4, this.MgS);
    AppMethodBeat.o(91163);
    return 0;
  }
  
  public final int ahl(int paramInt)
  {
    AppMethodBeat.i(176207);
    this.MhM.AddBlackInternal(paramInt, this.MgS);
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
    if ((MhL) && (paramBoolean))
    {
      j = this.MhM.GetDetailResultsNew(arrayOfQBarResultJNI, arrayOfQBarPoint, arrayOfQBarReportMsg, this.MgS);
      this.MhN = (j - 1);
      i = j;
      if (yFX)
      {
        i = j;
        if (j <= 0)
        {
          ae.w("MicroMsg.WxQBar", "alvinluo getResults ret: %d", new Object[] { Integer.valueOf(j) });
          AppMethodBeat.o(91162);
          return 0;
        }
      }
    }
    else
    {
      this.MhM.GetDetailResults(arrayOfQBarResultJNI, arrayOfQBarPoint, arrayOfQBarReportMsg, this.MgS);
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
          if (bu.isNullOrNil(localQBarResultJNI.typeName)) {
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
          if ((yFX) || (paramList.size() <= 0)) {
            continue;
          }
          ae.w("MicroMsg.WxQBar", "alvinluo getResults not enableMultiCode and ignore other results");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          a.a locala;
          ae.e("MicroMsg.WxQBar", "GetResults exp:" + localUnsupportedEncodingException.getMessage());
          continue;
          j += 1;
        }
        if ((paramList1 == null) || (!MhL)) {
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
        if (!bu.isNullOrNil(paramList1.charsetMode)) {
          paramList2.add(paramList1);
        }
        j += 1;
      }
    }
    if ((MhL) && (paramBoolean) && (yFX) && (i > 0))
    {
      ae.i("MicroMsg.WxQBar", "alvinluo getResults ret: %d, result size: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramList.size()) });
      i = paramList.size();
      AppMethodBeat.o(91162);
      return i;
    }
    i = paramList.size();
    AppMethodBeat.o(91162);
    return i;
  }
  
  public final int baH(String paramString)
  {
    AppMethodBeat.i(91164);
    this.MhM.AddWhiteList(paramString, this.MgS);
    AppMethodBeat.o(91164);
    return 0;
  }
  
  public final int baI(String paramString)
  {
    AppMethodBeat.i(91165);
    this.MhM.AddBlackList(paramString, this.MgS);
    AppMethodBeat.o(91165);
    return 0;
  }
  
  public final int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(91159);
    if (paramBoolean)
    {
      paramInt1 = H(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(91159);
      return paramInt1;
    }
    paramInt1 = super.H(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(91159);
    return paramInt1;
  }
  
  public final String jJ()
  {
    AppMethodBeat.i(196691);
    try
    {
      if (this.MgS < 0) {
        return null;
      }
      String str = this.MhM.GetDebugString(this.MgS);
      return str;
    }
    finally
    {
      AppMethodBeat.o(196691);
    }
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(196690);
    if (MhL) {
      try
      {
        if (this.MgS < 0) {
          return;
        }
        ae.i("MicroMsg.WxQBar", "alvinluo reset WxQBar qbarId: %d, forZoom: %b", new Object[] { Integer.valueOf(this.MgS), Boolean.valueOf(paramBoolean) });
        this.MhM.Reset(this.MgS, paramBoolean);
        return;
      }
      finally
      {
        AppMethodBeat.o(196690);
      }
    }
    AppMethodBeat.o(196690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qbar.f
 * JD-Core Version:    0.7.0.1
 */