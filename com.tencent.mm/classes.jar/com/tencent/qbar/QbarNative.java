package com.tencent.qbar;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class QbarNative
{
  public byte[] BhC;
  public int[] BhD;
  public byte[] BhE;
  public int[] BhF;
  public int BhG;
  public byte[] data;
  public byte[] type;
  
  static
  {
    AppMethodBeat.i(56476);
    System.loadLibrary("wechatQrMod");
    AppMethodBeat.o(56476);
  }
  
  public QbarNative()
  {
    AppMethodBeat.i(56461);
    this.type = new byte[100];
    this.data = new byte[3000];
    this.BhC = new byte[100];
    this.BhD = new int[4];
    this.BhE = new byte[300];
    this.BhF = new int[2];
    this.BhG = -1;
    AppMethodBeat.o(56461);
  }
  
  private static native int Encode(byte[] paramArrayOfByte, int[] paramArrayOfInt, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3);
  
  private static native int EncodeBitmap(String paramString1, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5);
  
  public static native int FocusInit(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4);
  
  public static native boolean FocusPro(byte[] paramArrayOfByte, boolean paramBoolean, boolean[] paramArrayOfBoolean);
  
  public static native int FocusRelease();
  
  private native int GetCodeDetectInfo(QbarNative.QBarCodeDetectInfo[] paramArrayOfQBarCodeDetectInfo, QBarPoint[] paramArrayOfQBarPoint, int paramInt);
  
  private native int GetDetailResults(QbarNative.QBarResultJNI[] paramArrayOfQBarResultJNI, QBarPoint[] paramArrayOfQBarPoint, QBarReportMsg[] paramArrayOfQBarReportMsg, int paramInt);
  
  private native int GetDetectInfoByFrames(QbarNative.QBarCodeDetectInfo paramQBarCodeDetectInfo, QBarPoint paramQBarPoint, int paramInt);
  
  private native int GetOneResult(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int[] paramArrayOfInt, int paramInt);
  
  private native int GetOneResultReport(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt);
  
  private native int GetResults(QbarNative.QBarResultJNI[] paramArrayOfQBarResultJNI, int paramInt);
  
  private static native String GetVersion();
  
  private native int Init(int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  private native int Init(int paramInt1, int paramInt2, String paramString1, String paramString2, QbarNative.QbarAiModelParam paramQbarAiModelParam);
  
  public static native int QIPUtilYUVCrop(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  private native int Release(int paramInt);
  
  private native int ScanImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native int SetReaders(int[] paramArrayOfInt, int paramInt1, int paramInt2);
  
  public static int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(56472);
    if (paramArrayOfByte2 == null)
    {
      AppMethodBeat.o(56472);
      return -1;
    }
    paramInt1 = nativeYUVrotate(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2);
    AppMethodBeat.o(56472);
    return paramInt1;
  }
  
  public static int a(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(56474);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(56474);
      return -1;
    }
    paramInt1 = nativeYuvToCropIntArray(paramArrayOfByte, paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.o(56474);
    return paramInt1;
  }
  
  public static int a(byte[] paramArrayOfByte, int[] paramArrayOfInt, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(56463);
    paramInt1 = Encode(paramArrayOfByte, paramArrayOfInt, paramString1, paramInt1, paramInt2, paramString2, -1);
    AppMethodBeat.o(56463);
    return paramInt1;
  }
  
  public static int a(byte[] paramArrayOfByte1, int[] paramArrayOfInt, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(56471);
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null))
    {
      AppMethodBeat.o(56471);
      return -1;
    }
    paramInt1 = nativeGrayRotateCropSub(paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfByte1, paramArrayOfInt, paramInt7, 0);
    AppMethodBeat.o(56471);
    return paramInt1;
  }
  
  public static int b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(56473);
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null))
    {
      AppMethodBeat.o(56473);
      return -1;
    }
    paramInt1 = nativeCropGray2(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, 0);
    AppMethodBeat.o(56473);
    return paramInt1;
  }
  
  public static native int focusedEngineForBankcardInit(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public static native int focusedEngineGetVersion();
  
  public static native int focusedEngineProcess(byte[] paramArrayOfByte);
  
  public static native int focusedEngineRelease();
  
  public static String getVersion()
  {
    AppMethodBeat.i(56462);
    String str = GetVersion();
    AppMethodBeat.o(56462);
    return str;
  }
  
  private static boolean isNullOrNil(String paramString)
  {
    AppMethodBeat.i(56475);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(56475);
      return true;
    }
    AppMethodBeat.o(56475);
    return false;
  }
  
  private static native int nativeArrayConvert(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int[] paramArrayOfInt);
  
  private static native int nativeCropGray2(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  private static native int nativeGrayRotateCropSub(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt7, int paramInt8);
  
  public static native int nativeRelease();
  
  private static native int nativeTransBytes(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private static native int nativeTransPixels(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private static native int nativeYUVrotate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  private static native int nativeYUVrotateLess(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private static native int nativeYuvToCropIntArray(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public final int A(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(56466);
    ScanImage(paramArrayOfByte, paramInt1, paramInt2, 0, this.BhG);
    if (dUc().size() > 0)
    {
      AppMethodBeat.o(56466);
      return 0;
    }
    AppMethodBeat.o(56466);
    return -1;
  }
  
  native int AddBlackInternal(int paramInt1, int paramInt2);
  
  native int AddBlackList(String paramString, int paramInt);
  
  native int AddWhiteList(String paramString, int paramInt);
  
  public native int GetZoomInfo(QbarNative.QBarZoomInfo paramQBarZoomInfo, int paramInt);
  
  public native int SetCenterCoordinate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public final int a(int paramInt, String paramString1, String paramString2, QbarNative.QbarAiModelParam paramQbarAiModelParam)
  {
    AppMethodBeat.i(56464);
    if (this.BhG < 0) {
      if (paramQbarAiModelParam == null) {
        break label45;
      }
    }
    label45:
    for (this.BhG = Init(1, paramInt, paramString1, paramString2, paramQbarAiModelParam); this.BhG < 0; this.BhG = Init(1, paramInt, paramString1, paramString2))
    {
      AppMethodBeat.o(56464);
      return -1;
    }
    AppMethodBeat.o(56464);
    return 0;
  }
  
  public final List<QbarNative.QBarResult> dUc()
  {
    int j = 0;
    AppMethodBeat.i(56468);
    QbarNative.QBarResultJNI[] arrayOfQBarResultJNI = new QbarNative.QBarResultJNI[3];
    int i = 0;
    while (i < 3)
    {
      arrayOfQBarResultJNI[i] = new QbarNative.QBarResultJNI();
      arrayOfQBarResultJNI[i].charset = new String();
      arrayOfQBarResultJNI[i].data = new byte[1024];
      arrayOfQBarResultJNI[i].typeName = new String();
      i += 1;
    }
    GetResults(arrayOfQBarResultJNI, this.BhG);
    ArrayList localArrayList = new ArrayList();
    i = j;
    for (;;)
    {
      if (i < 3)
      {
        QbarNative.QBarResultJNI localQBarResultJNI = arrayOfQBarResultJNI[i];
        try
        {
          if (isNullOrNil(localQBarResultJNI.typeName)) {
            break label296;
          }
          QbarNative.QBarResult localQBarResult = new QbarNative.QBarResult();
          localQBarResult.charset = localQBarResultJNI.charset;
          localQBarResult.typeID = localQBarResultJNI.typeID;
          localQBarResult.typeName = localQBarResultJNI.typeName;
          localQBarResult.rawData = localQBarResultJNI.data;
          if (localQBarResult.charset.equals("ANY"))
          {
            localQBarResult.data = new String(localQBarResultJNI.data, "UTF-8");
            if (localQBarResult.data.length() != 0) {}
          }
          for (localQBarResult.data = new String(localQBarResultJNI.data, "ASCII");; localQBarResult.data = new String(localQBarResultJNI.data, localQBarResult.charset))
          {
            localArrayList.add(localQBarResult);
            break;
          }
          AppMethodBeat.o(56468);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          new StringBuilder("GetResults exp:").append(localUnsupportedEncodingException.getMessage());
        }
      }
      else
      {
        return localArrayList;
      }
      label296:
      i += 1;
    }
  }
  
  public final int i(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(56465);
    paramInt = SetReaders(paramArrayOfInt, paramInt, this.BhG);
    AppMethodBeat.o(56465);
    return paramInt;
  }
  
  public final int release()
  {
    AppMethodBeat.i(56467);
    int i = Release(this.BhG);
    this.BhG = -1;
    AppMethodBeat.o(56467);
    return i;
  }
  
  public final int w(List<QbarNative.QBarResult> paramList, List<QBarReportMsg> paramList1)
  {
    AppMethodBeat.i(56469);
    QbarNative.QBarResultJNI[] arrayOfQBarResultJNI = new QbarNative.QBarResultJNI[3];
    Object localObject2 = new QBarPoint[3];
    QBarReportMsg[] arrayOfQBarReportMsg = new QBarReportMsg[3];
    int i = 0;
    while (i < 3)
    {
      arrayOfQBarResultJNI[i] = new QbarNative.QBarResultJNI();
      arrayOfQBarResultJNI[i].charset = new String();
      arrayOfQBarResultJNI[i].data = new byte[1024];
      arrayOfQBarResultJNI[i].typeName = new String();
      localObject2[i] = new QBarPoint();
      arrayOfQBarReportMsg[i] = new QBarReportMsg();
      arrayOfQBarReportMsg[i].binaryMethod = new String();
      arrayOfQBarReportMsg[i].charsetMode = new String();
      arrayOfQBarReportMsg[i].ecLevel = new String();
      arrayOfQBarReportMsg[i].scaleList = new String();
      i += 1;
    }
    paramList.clear();
    paramList1.clear();
    GetDetailResults(arrayOfQBarResultJNI, (QBarPoint[])localObject2, arrayOfQBarReportMsg, this.BhG);
    i = 0;
    for (;;)
    {
      if (i < 3)
      {
        localObject2 = arrayOfQBarResultJNI[i];
        try
        {
          if (isNullOrNil(((QbarNative.QBarResultJNI)localObject2).typeName)) {
            break label441;
          }
          QbarNative.QBarResult localQBarResult = new QbarNative.QBarResult();
          localQBarResult.charset = ((QbarNative.QBarResultJNI)localObject2).charset;
          localQBarResult.typeID = ((QbarNative.QBarResultJNI)localObject2).typeID;
          localQBarResult.typeName = ((QbarNative.QBarResultJNI)localObject2).typeName;
          localQBarResult.rawData = ((QbarNative.QBarResultJNI)localObject2).data;
          if (localQBarResult.charset.equals("ANY"))
          {
            localQBarResult.data = new String(((QbarNative.QBarResultJNI)localObject2).data, "UTF-8");
            if (localQBarResult.data.length() != 0) {}
          }
          for (localQBarResult.data = new String(((QbarNative.QBarResultJNI)localObject2).data, "ASCII");; localQBarResult.data = new String(((QbarNative.QBarResultJNI)localObject2).data, localQBarResult.charset))
          {
            paramList.add(localQBarResult);
            break;
          }
          i = 0;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          new StringBuilder("GetResults exp:").append(localUnsupportedEncodingException.getMessage());
        }
      }
      else
      {
        while (i < 3)
        {
          Object localObject1 = arrayOfQBarReportMsg[i];
          if (!isNullOrNil(localObject1.charsetMode)) {
            paramList1.add(localObject1);
          }
          i += 1;
        }
        i = paramList.size();
        AppMethodBeat.o(56469);
        return i;
      }
      label441:
      i += 1;
    }
  }
  
  public final int x(List<QbarNative.QBarCodeDetectInfo> paramList, List<QBarPoint> paramList1)
  {
    int k = 0;
    AppMethodBeat.i(56470);
    if (this.BhG < 0)
    {
      AppMethodBeat.o(56470);
      return 0;
    }
    QbarNative.QBarCodeDetectInfo[] arrayOfQBarCodeDetectInfo = new QbarNative.QBarCodeDetectInfo[3];
    QBarPoint[] arrayOfQBarPoint = new QBarPoint[3];
    int i = 0;
    while (i < 3)
    {
      arrayOfQBarCodeDetectInfo[i] = new QbarNative.QBarCodeDetectInfo();
      arrayOfQBarPoint[i] = new QBarPoint();
      i += 1;
    }
    paramList.clear();
    paramList1.clear();
    GetCodeDetectInfo(arrayOfQBarCodeDetectInfo, arrayOfQBarPoint, this.BhG);
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 3) {
        break;
      }
      QbarNative.QBarCodeDetectInfo localQBarCodeDetectInfo = arrayOfQBarCodeDetectInfo[i];
      if (localQBarCodeDetectInfo.readerId > 0) {
        paramList.add(localQBarCodeDetectInfo);
      }
      i += 1;
    }
    while (j < 3)
    {
      arrayOfQBarCodeDetectInfo = arrayOfQBarPoint[j];
      if (arrayOfQBarCodeDetectInfo.point_cnt != 0) {
        paramList1.add(arrayOfQBarCodeDetectInfo);
      }
      j += 1;
    }
    i = paramList.size();
    AppMethodBeat.o(56470);
    return i;
  }
  
  public static class QBarPoint
  {
    public int point_cnt;
    public float x0;
    public float x1;
    public float x2;
    public float x3;
    public float y0;
    public float y1;
    public float y2;
    public float y3;
  }
  
  public static class QBarReportMsg
  {
    public String binaryMethod;
    public String charsetMode;
    public float decodeScale;
    public int detectTime;
    public String ecLevel;
    public boolean inBlackList;
    public boolean inWhiteList;
    public int pyramidLv;
    public int qrcodeVersion;
    public String scaleList;
    public int srTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qbar.QbarNative
 * JD-Core Version:    0.7.0.1
 */