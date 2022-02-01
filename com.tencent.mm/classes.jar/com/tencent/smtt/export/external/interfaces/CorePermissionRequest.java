package com.tencent.smtt.export.external.interfaces;

public class CorePermissionRequest
{
  public static final int REQ_CALL_PHONE = 8192;
  public static final int REQ_CAMERA = 16;
  public static final int REQ_CONTACTS = 64;
  public static final int REQ_DOWNLOAD = 8;
  public static final int REQ_LOCATION = 2;
  public static final int REQ_PHONE = 1;
  public static final int REQ_QRCODE = 32;
  public static final int REQ_READ_SMS = 128;
  public static final int REQ_RECORD_AUDIO = 1024;
  public static final int REQ_SAVE_OFFLINE = 512;
  public static final int REQ_SCAN_WIFI = 4096;
  public static final int REQ_SEND_SMS = 2048;
  public static final int REQ_STORAGE = 4;
  public static final int REQ_TOOLBOX = 256;
  public int mRequest;
  
  public CorePermissionRequest(int paramInt)
  {
    this.mRequest = paramInt;
  }
  
  public static abstract interface CorePermissionRequestCallback
  {
    public abstract void onPermissionRequestCanceled();
    
    public abstract void onPermissionRequestGranted(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.CorePermissionRequest
 * JD-Core Version:    0.7.0.1
 */