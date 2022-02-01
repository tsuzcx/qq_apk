package com.tencent.qbar;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import java.io.UnsupportedEncodingException;
import java.util.List;

public final class f
  extends a
{
  private static volatile boolean Ipl;
  private static boolean vRl;
  private WxQbarNative Ipm;
  int Ipn;
  
  static
  {
    AppMethodBeat.i(91167);
    Ipl = true;
    vRl = true;
    flS();
    AppMethodBeat.o(91167);
  }
  
  public f()
  {
    AppMethodBeat.i(91157);
    this.Ipm = new WxQbarNative();
    this.Ipn = 0;
    AppMethodBeat.o(91157);
  }
  
  public static void flS()
  {
    AppMethodBeat.i(91158);
    int i = ((b)g.ab(b.class)).a(b.a.psq, 0);
    if (i != 1) {}
    for (boolean bool = true;; bool = false)
    {
      Ipl = bool;
      if ((h.IS_FLAVOR_RED) || (h.DEBUG)) {
        Ipl = true;
      }
      if (Ipl)
      {
        int j = ((b)g.ab(b.class)).a(b.a.psr, 0);
        if (j > 0)
        {
          ActivityManager localActivityManager = (ActivityManager)aj.getContext().getSystemService("activity");
          ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
          localActivityManager.getMemoryInfo(localMemoryInfo);
          if ((localMemoryInfo.totalMem > 0L) && ((float)localMemoryInfo.totalMem * 1.0F / 1048576.0F <= j)) {
            Ipl = false;
          }
          ad.i("MicroMsg.WxQBar", "alvinluo checkMemoryLimit totalMemory: %s bytes, %s MB, config memoryLimit: %d, useNewScanInterface: %b", new Object[] { Long.valueOf(localMemoryInfo.totalMem), Float.valueOf((float)localMemoryInfo.totalMem * 1.0F / 1048576.0F), Integer.valueOf(j), Boolean.valueOf(Ipl) });
        }
      }
      ad.i("MicroMsg.WxQBar", "alvinluo updateUseNewScanInterfaceStatus config: %d, useNewScanInterface: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(Ipl) });
      AppMethodBeat.o(91158);
      return;
    }
  }
  
  public static boolean flT()
  {
    return Ipl;
  }
  
  public static void xs(boolean paramBoolean)
  {
    AppMethodBeat.i(176206);
    ad.i("MicroMsg.WxQBar", "alvinluo setEnableMultiCode: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    vRl = paramBoolean;
    AppMethodBeat.o(176206);
  }
  
  public final int G(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91160);
    ad.i("MicroMsg.WxQBar", "alvinluo scanImage width: %d, height: %d, grayImage: %d, useNewScanInterface: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length), Boolean.valueOf(Ipl) });
    if (Ipl) {
      try
      {
        if (this.Iov < 0) {
          return -1;
        }
        paramInt1 = this.Ipm.ScanImage712(paramArrayOfByte, paramInt1, paramInt2, this.Iov);
        return paramInt1;
      }
      finally
      {
        AppMethodBeat.o(91160);
      }
    }
    paramInt1 = super.G(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(91160);
    return paramInt1;
  }
  
  public final int U(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(91163);
    this.Ipm.SetCenterCoordinate(paramInt1, paramInt2, paramInt3, paramInt4, this.Iov);
    AppMethodBeat.o(91163);
    return 0;
  }
  
  public final int aNB(String paramString)
  {
    AppMethodBeat.i(91164);
    this.Ipm.AddWhiteList(paramString, this.Iov);
    AppMethodBeat.o(91164);
    return 0;
  }
  
  public final int aNC(String paramString)
  {
    AppMethodBeat.i(91165);
    this.Ipm.AddBlackList(paramString, this.Iov);
    AppMethodBeat.o(91165);
    return 0;
  }
  
  public final int abJ(int paramInt)
  {
    AppMethodBeat.i(176207);
    this.Ipm.AddBlackInternal(paramInt, this.Iov);
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
    if ((Ipl) && (!paramBoolean))
    {
      j = this.Ipm.GetDetailResultsNew(arrayOfQBarResultJNI, arrayOfQBarPoint, arrayOfQBarReportMsg, this.Iov);
      this.Ipn = (j - 1);
      i = j;
      if (vRl)
      {
        i = j;
        if (j <= 0)
        {
          ad.w("MicroMsg.WxQBar", "alvinluo getResults ret: %d", new Object[] { Integer.valueOf(j) });
          AppMethodBeat.o(91162);
          return 0;
        }
      }
    }
    else
    {
      this.Ipm.GetDetailResults(arrayOfQBarResultJNI, arrayOfQBarPoint, arrayOfQBarReportMsg, this.Iov);
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
          if (bt.isNullOrNil(localQBarResultJNI.typeName)) {
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
          if ((vRl) || (paramList.size() <= 0)) {
            continue;
          }
          ad.w("MicroMsg.WxQBar", "alvinluo getResults not enableMultiCode and ignore other results");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          a.a locala;
          ad.e("MicroMsg.WxQBar", "GetResults exp:" + localUnsupportedEncodingException.getMessage());
          continue;
          j += 1;
        }
        if ((paramList1 == null) || (!Ipl)) {
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
        if (!bt.isNullOrNil(paramList1.charsetMode)) {
          paramList2.add(paramList1);
        }
        j += 1;
      }
    }
    if ((Ipl) && (!paramBoolean) && (vRl) && (i > 0))
    {
      ad.i("MicroMsg.WxQBar", "alvinluo getResults ret: %d, result size: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramList.size()) });
      i = paramList.size();
      AppMethodBeat.o(91162);
      return i;
    }
    i = paramList.size();
    AppMethodBeat.o(91162);
    return i;
  }
  
  public final int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(91159);
    if (!paramBoolean)
    {
      paramInt1 = G(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(91159);
      return paramInt1;
    }
    paramInt1 = super.G(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(91159);
    return paramInt1;
  }
  
  public final String jl()
  {
    AppMethodBeat.i(190143);
    try
    {
      if (this.Iov < 0) {
        return null;
      }
      String str = this.Ipm.GetDebugString(this.Iov);
      return str;
    }
    finally
    {
      AppMethodBeat.o(190143);
    }
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(190142);
    if (Ipl) {
      try
      {
        if (this.Iov < 0) {
          return;
        }
        ad.i("MicroMsg.WxQBar", "alvinluo reset WxQBar qbarId: %d, forZoom: %b", new Object[] { Integer.valueOf(this.Iov), Boolean.valueOf(paramBoolean) });
        this.Ipm.Reset(this.Iov, paramBoolean);
        return;
      }
      finally
      {
        AppMethodBeat.o(190142);
      }
    }
    AppMethodBeat.o(190142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.f
 * JD-Core Version:    0.7.0.1
 */