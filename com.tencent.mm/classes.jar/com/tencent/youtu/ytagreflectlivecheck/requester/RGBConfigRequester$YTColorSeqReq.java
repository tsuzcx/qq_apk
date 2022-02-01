package com.tencent.youtu.ytagreflectlivecheck.requester;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RGBConfigRequester$YTColorSeqReq
{
  public String android_apilevel;
  public String android_version;
  public String app_id;
  public String build_brand;
  public String build_device;
  public String build_display;
  public String build_hardware;
  public String build_id;
  public String build_model;
  public String build_product;
  public String build_serial;
  public String build_test;
  public String business_name;
  public String person_id;
  public int platform;
  
  public RGBConfigRequester$YTColorSeqReq(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(43405);
    this.build_brand = Build.BRAND;
    this.build_model = Build.MODEL;
    this.build_hardware = Build.HARDWARE;
    this.build_serial = Build.SERIAL;
    this.build_id = Build.ID;
    this.build_display = Build.DISPLAY;
    this.build_product = Build.PRODUCT;
    this.build_device = Build.DEVICE;
    this.build_test = null;
    this.android_apilevel = Build.VERSION.SDK_INT;
    this.android_version = Build.VERSION.RELEASE;
    this.app_id = paramString1;
    this.business_name = paramString2;
    this.person_id = paramString3;
    this.platform = 2;
    AppMethodBeat.o(43405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.YTColorSeqReq
 * JD-Core Version:    0.7.0.1
 */