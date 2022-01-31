package com.tencent.qbar;

import android.graphics.Bitmap;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class QbarNative
{
  public byte[] data = new byte[3000];
  public byte[] type = new byte[100];
  public byte[] wKc = new byte[100];
  public int[] wKd = new int[4];
  public byte[] wKe = new byte[300];
  public int[] wKf = new int[2];
  public int wKg = -1;
  
  static
  {
    k.b("wechatQrMod", QbarNative.class.getClassLoader());
  }
  
  private static native int Encode(byte[] paramArrayOfByte, int[] paramArrayOfInt, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3);
  
  private static native int EncodeBitmap(String paramString1, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5);
  
  public static native int FocusInit(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4);
  
  public static native boolean FocusPro(byte[] paramArrayOfByte, boolean paramBoolean, boolean[] paramArrayOfBoolean);
  
  public static native int FocusRelease();
  
  private native int GetCodeDetectInfo(QbarNative.QBarCodeDetectInfo[] paramArrayOfQBarCodeDetectInfo, QbarNative.QBarPoint[] paramArrayOfQBarPoint, int paramInt);
  
  private native int GetDetailResults(QbarNative.QBarResultJNI[] paramArrayOfQBarResultJNI, QbarNative.QBarPoint[] paramArrayOfQBarPoint, QbarNative.QBarReportMsg[] paramArrayOfQBarReportMsg, int paramInt);
  
  private native int GetDetectInfoByFrames(QbarNative.QBarCodeDetectInfo paramQBarCodeDetectInfo, int paramInt);
  
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
    if (paramArrayOfByte2 == null) {
      return -1;
    }
    return nativeYUVrotate(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2);
  }
  
  public static int a(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    return nativeYuvToCropIntArray(paramArrayOfByte, paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public static int a(byte[] paramArrayOfByte, int[] paramArrayOfInt, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    return Encode(paramArrayOfByte, paramArrayOfInt, paramString1, paramInt1, paramInt2, paramString2, -1);
  }
  
  public static int a(byte[] paramArrayOfByte1, int[] paramArrayOfInt, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return -1;
    }
    return nativeGrayRotateCropSub(paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfByte1, paramArrayOfInt, paramInt7, 0);
  }
  
  public static int b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return -1;
    }
    return nativeCropGray2(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, 0);
  }
  
  public static native int focusedEngineForBankcardInit(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public static native int focusedEngineGetVersion();
  
  public static native int focusedEngineProcess(byte[] paramArrayOfByte);
  
  public static native int focusedEngineRelease();
  
  public static String getVersion()
  {
    return GetVersion();
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
  
  public native int GetZoomInfo(QbarNative.QBarZoomInfo paramQBarZoomInfo, int paramInt);
  
  public native int SetCenterCoordinate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public final int a(int paramInt, String paramString1, String paramString2, QbarNative.QbarAiModelParam paramQbarAiModelParam)
  {
    if (this.wKg < 0) {
      if (paramQbarAiModelParam == null) {
        break label35;
      }
    }
    label35:
    for (this.wKg = Init(1, paramInt, paramString1, paramString2, paramQbarAiModelParam); this.wKg < 0; this.wKg = Init(1, paramInt, paramString1, paramString2)) {
      return -1;
    }
    return 0;
  }
  
  public final List<QbarNative.QBarResult> cOp()
  {
    int j = 0;
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
    GetResults(arrayOfQBarResultJNI, this.wKg);
    ArrayList localArrayList = new ArrayList();
    i = j;
    for (;;)
    {
      if (i < 3)
      {
        QbarNative.QBarResultJNI localQBarResultJNI = arrayOfQBarResultJNI[i];
        try
        {
          if (!bk.bl(localQBarResultJNI.typeName))
          {
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
            return localArrayList;
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          y.e("QbarNative", "GetResults exp:" + localUnsupportedEncodingException.getMessage());
        }
      }
      i += 1;
    }
  }
  
  public final int h(int[] paramArrayOfInt, int paramInt)
  {
    return SetReaders(paramArrayOfInt, paramInt, this.wKg);
  }
  
  public final int m(List<QbarNative.QBarResult> paramList, List<QbarNative.QBarReportMsg> paramList1)
  {
    QbarNative.QBarResultJNI[] arrayOfQBarResultJNI = new QbarNative.QBarResultJNI[3];
    Object localObject2 = new QbarNative.QBarPoint[3];
    QbarNative.QBarReportMsg[] arrayOfQBarReportMsg = new QbarNative.QBarReportMsg[3];
    int i = 0;
    while (i < 3)
    {
      arrayOfQBarResultJNI[i] = new QbarNative.QBarResultJNI();
      arrayOfQBarResultJNI[i].charset = new String();
      arrayOfQBarResultJNI[i].data = new byte[1024];
      arrayOfQBarResultJNI[i].typeName = new String();
      localObject2[i] = new QbarNative.QBarPoint();
      arrayOfQBarReportMsg[i] = new QbarNative.QBarReportMsg();
      arrayOfQBarReportMsg[i].binaryMethod = new String();
      arrayOfQBarReportMsg[i].charsetMode = new String();
      arrayOfQBarReportMsg[i].ecLevel = new String();
      arrayOfQBarReportMsg[i].scaleList = new String();
      i += 1;
    }
    paramList.clear();
    paramList1.clear();
    GetDetailResults(arrayOfQBarResultJNI, (QbarNative.QBarPoint[])localObject2, arrayOfQBarReportMsg, this.wKg);
    i = 0;
    for (;;)
    {
      if (i < 3)
      {
        localObject2 = arrayOfQBarResultJNI[i];
        try
        {
          if (bk.bl(((QbarNative.QBarResultJNI)localObject2).typeName)) {
            break label434;
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
          y.e("QbarNative", "GetResults exp:" + localUnsupportedEncodingException.getMessage());
        }
      }
      else
      {
        while (i < 3)
        {
          Object localObject1 = arrayOfQBarReportMsg[i];
          if (!bk.bl(localObject1.charsetMode)) {
            paramList1.add(localObject1);
          }
          i += 1;
        }
        return paramList.size();
      }
      label434:
      i += 1;
    }
  }
  
  public final int n(List<QbarNative.QBarCodeDetectInfo> paramList, List<QbarNative.QBarPoint> paramList1)
  {
    int k = 0;
    if (this.wKg < 0) {
      return 0;
    }
    QbarNative.QBarCodeDetectInfo[] arrayOfQBarCodeDetectInfo = new QbarNative.QBarCodeDetectInfo[3];
    QbarNative.QBarPoint[] arrayOfQBarPoint = new QbarNative.QBarPoint[3];
    int i = 0;
    while (i < 3)
    {
      arrayOfQBarCodeDetectInfo[i] = new QbarNative.QBarCodeDetectInfo();
      arrayOfQBarPoint[i] = new QbarNative.QBarPoint();
      i += 1;
    }
    paramList.clear();
    paramList1.clear();
    GetCodeDetectInfo(arrayOfQBarCodeDetectInfo, arrayOfQBarPoint, this.wKg);
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
    return paramList.size();
  }
  
  public final int release()
  {
    int i = Release(this.wKg);
    this.wKg = -1;
    return i;
  }
  
  public final int w(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ScanImage(paramArrayOfByte, paramInt1, paramInt2, 0, this.wKg);
    if (cOp().size() > 0) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qbar.QbarNative
 * JD-Core Version:    0.7.0.1
 */