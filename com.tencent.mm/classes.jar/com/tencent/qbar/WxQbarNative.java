package com.tencent.qbar;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WxQbarNative
{
  static
  {
    AppMethodBeat.i(158877);
    System.loadLibrary("wechatQrMod");
    AppMethodBeat.o(158877);
  }
  
  public static native int FocusInit(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4);
  
  public static native boolean FocusPro(byte[] paramArrayOfByte, boolean paramBoolean, boolean[] paramArrayOfBoolean);
  
  public static native int FocusRelease();
  
  public static native int QIPUtilYUVCrop(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public static native int focusedEngineForBankcardInit(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public static native int focusedEngineGetVersion();
  
  public static native int focusedEngineProcess(byte[] paramArrayOfByte);
  
  public static native int focusedEngineRelease();
  
  protected native int AddBlackInternal(int paramInt1, int paramInt2);
  
  protected native int AddBlackList(String paramString, int paramInt);
  
  protected native int AddWhiteList(String paramString, int paramInt);
  
  protected native String GetDebugString(int paramInt);
  
  protected native int GetDetailResults(QbarNative.QBarResultJNI[] paramArrayOfQBarResultJNI, QbarNative.QBarPoint[] paramArrayOfQBarPoint, QBarReportMsg[] paramArrayOfQBarReportMsg, int paramInt);
  
  protected native int GetDetailResultsNew(QbarNative.QBarResultJNI[] paramArrayOfQBarResultJNI, QbarNative.QBarPoint[] paramArrayOfQBarPoint, QBarReportMsg[] paramArrayOfQBarReportMsg, int paramInt);
  
  protected native int GetDetectInfoByFrames(QbarNative.QBarCodeDetectInfo paramQBarCodeDetectInfo, QbarNative.QBarPoint paramQBarPoint, int paramInt);
  
  protected native int GetOneResultReport(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt);
  
  protected native int GetZoomInfo(QbarNative.QBarZoomInfo paramQBarZoomInfo, int paramInt);
  
  protected native void Reset(int paramInt, boolean paramBoolean);
  
  protected native int ScanImage712(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  protected native int SetCenterCoordinate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.WxQbarNative
 * JD-Core Version:    0.7.0.1
 */