package com.tencent.qbar;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.h;
import java.io.UnsupportedEncodingException;
import java.util.List;

public final class f
  extends a
{
  private static volatile boolean JQV;
  private static boolean xbW;
  private WxQbarNative JQW;
  int JQX;
  
  static
  {
    AppMethodBeat.i(91167);
    JQV = true;
    xbW = true;
    fCj();
    AppMethodBeat.o(91167);
  }
  
  public f()
  {
    AppMethodBeat.i(91157);
    this.JQW = new WxQbarNative();
    this.JQX = 0;
    AppMethodBeat.o(91157);
  }
  
  public static void fCj()
  {
    AppMethodBeat.i(91158);
    int i = ((b)g.ab(b.class)).a(b.a.pWz, 0);
    if (i != 1) {}
    for (boolean bool = true;; bool = false)
    {
      JQV = bool;
      if ((h.IS_FLAVOR_RED) || (h.DEBUG)) {
        JQV = true;
      }
      if (JQV)
      {
        int j = ((b)g.ab(b.class)).a(b.a.pWA, 0);
        if (j > 0)
        {
          ActivityManager localActivityManager = (ActivityManager)ai.getContext().getSystemService("activity");
          ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
          localActivityManager.getMemoryInfo(localMemoryInfo);
          if ((localMemoryInfo.totalMem > 0L) && ((float)localMemoryInfo.totalMem * 1.0F / 1048576.0F <= j)) {
            JQV = false;
          }
          ac.i("MicroMsg.WxQBar", "alvinluo checkMemoryLimit totalMemory: %s bytes, %s MB, config memoryLimit: %d, useNewScanInterface: %b", new Object[] { Long.valueOf(localMemoryInfo.totalMem), Float.valueOf((float)localMemoryInfo.totalMem * 1.0F / 1048576.0F), Integer.valueOf(j), Boolean.valueOf(JQV) });
        }
      }
      ac.i("MicroMsg.WxQBar", "alvinluo updateUseNewScanInterfaceStatus config: %d, useNewScanInterface: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(JQV) });
      AppMethodBeat.o(91158);
      return;
    }
  }
  
  public static boolean fCk()
  {
    return JQV;
  }
  
  public static void yC(boolean paramBoolean)
  {
    AppMethodBeat.i(176206);
    ac.i("MicroMsg.WxQBar", "alvinluo setEnableMultiCode: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    xbW = paramBoolean;
    AppMethodBeat.o(176206);
  }
  
  public final int F(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91160);
    ac.i("MicroMsg.WxQBar", "alvinluo scanImage width: %d, height: %d, grayImage: %d, useNewScanInterface: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length), Boolean.valueOf(JQV) });
    if (JQV) {
      try
      {
        if (this.JQg < 0) {
          return -1;
        }
        paramInt1 = this.JQW.ScanImage712(paramArrayOfByte, paramInt1, paramInt2, this.JQg);
        return paramInt1;
      }
      finally
      {
        AppMethodBeat.o(91160);
      }
    }
    paramInt1 = super.F(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(91160);
    return paramInt1;
  }
  
  public final int W(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(91163);
    this.JQW.SetCenterCoordinate(paramInt1, paramInt2, paramInt3, paramInt4, this.JQg);
    AppMethodBeat.o(91163);
    return 0;
  }
  
  public final int aTe(String paramString)
  {
    AppMethodBeat.i(91164);
    this.JQW.AddWhiteList(paramString, this.JQg);
    AppMethodBeat.o(91164);
    return 0;
  }
  
  public final int aTf(String paramString)
  {
    AppMethodBeat.i(91165);
    this.JQW.AddBlackList(paramString, this.JQg);
    AppMethodBeat.o(91165);
    return 0;
  }
  
  public final int aec(int paramInt)
  {
    AppMethodBeat.i(176207);
    this.JQW.AddBlackInternal(paramInt, this.JQg);
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
    if ((JQV) && (!paramBoolean))
    {
      j = this.JQW.GetDetailResultsNew(arrayOfQBarResultJNI, arrayOfQBarPoint, arrayOfQBarReportMsg, this.JQg);
      this.JQX = (j - 1);
      i = j;
      if (xbW)
      {
        i = j;
        if (j <= 0)
        {
          ac.w("MicroMsg.WxQBar", "alvinluo getResults ret: %d", new Object[] { Integer.valueOf(j) });
          AppMethodBeat.o(91162);
          return 0;
        }
      }
    }
    else
    {
      this.JQW.GetDetailResults(arrayOfQBarResultJNI, arrayOfQBarPoint, arrayOfQBarReportMsg, this.JQg);
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
          if (bs.isNullOrNil(localQBarResultJNI.typeName)) {
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
          if ((xbW) || (paramList.size() <= 0)) {
            continue;
          }
          ac.w("MicroMsg.WxQBar", "alvinluo getResults not enableMultiCode and ignore other results");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          a.a locala;
          ac.e("MicroMsg.WxQBar", "GetResults exp:" + localUnsupportedEncodingException.getMessage());
          continue;
          j += 1;
        }
        if ((paramList1 == null) || (!JQV)) {
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
        if (!bs.isNullOrNil(paramList1.charsetMode)) {
          paramList2.add(paramList1);
        }
        j += 1;
      }
    }
    if ((JQV) && (!paramBoolean) && (xbW) && (i > 0))
    {
      ac.i("MicroMsg.WxQBar", "alvinluo getResults ret: %d, result size: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramList.size()) });
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
      paramInt1 = F(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(91159);
      return paramInt1;
    }
    paramInt1 = super.F(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(91159);
    return paramInt1;
  }
  
  public final String jt()
  {
    AppMethodBeat.i(204946);
    try
    {
      if (this.JQg < 0) {
        return null;
      }
      String str = this.JQW.GetDebugString(this.JQg);
      return str;
    }
    finally
    {
      AppMethodBeat.o(204946);
    }
  }
  
  public final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(204945);
    if (JQV) {
      try
      {
        if (this.JQg < 0) {
          return;
        }
        ac.i("MicroMsg.WxQBar", "alvinluo reset WxQBar qbarId: %d, forZoom: %b", new Object[] { Integer.valueOf(this.JQg), Boolean.valueOf(paramBoolean) });
        this.JQW.Reset(this.JQg, paramBoolean);
        return;
      }
      finally
      {
        AppMethodBeat.o(204945);
      }
    }
    AppMethodBeat.o(204945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.f
 * JD-Core Version:    0.7.0.1
 */