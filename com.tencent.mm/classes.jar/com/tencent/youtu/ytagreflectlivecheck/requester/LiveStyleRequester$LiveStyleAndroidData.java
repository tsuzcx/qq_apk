package com.tencent.youtu.ytagreflectlivecheck.requester;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LiveStyleRequester$LiveStyleAndroidData
{
  public String android_apilevel;
  public String android_version;
  public String build_brand;
  public String build_device;
  public String build_display;
  public String build_hardware;
  public String build_model;
  public String build_product;
  public float lux;
  
  public LiveStyleRequester$LiveStyleAndroidData()
  {
    AppMethodBeat.i(43401);
    this.lux = 0.0F;
    this.build_brand = Build.BRAND;
    this.build_model = Build.MODEL;
    this.build_hardware = Build.HARDWARE;
    this.build_display = Build.DISPLAY;
    this.build_product = Build.PRODUCT;
    this.build_device = Build.DEVICE;
    this.android_apilevel = Build.VERSION.SDK_INT;
    this.android_version = Build.VERSION.RELEASE;
    AppMethodBeat.o(43401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.LiveStyleAndroidData
 * JD-Core Version:    0.7.0.1
 */