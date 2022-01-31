package com.tencent.youtu.ytagreflectlivecheck.controller;

import android.os.Build;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.YTColorSeqReq;

class InitController$ColorSeqReqInner
{
  public String app_id;
  public String build_brand = Build.BRAND;
  public String build_device = Build.DEVICE;
  public String build_display = Build.DISPLAY;
  public String build_hardware = Build.HARDWARE;
  public String build_id = Build.ID;
  public String build_model = Build.MODEL;
  public String build_product = Build.PRODUCT;
  public String build_serial = Build.SERIAL;
  public String build_test = null;
  public String business_name;
  public String person_id;
  public int platform;
  
  public InitController$ColorSeqReqInner(InitController paramInitController, RGBConfigRequester.YTColorSeqReq paramYTColorSeqReq)
  {
    this.app_id = paramYTColorSeqReq.app_id;
    this.business_name = paramYTColorSeqReq.business_name;
    this.person_id = paramYTColorSeqReq.person_id;
    this.platform = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.InitController.ColorSeqReqInner
 * JD-Core Version:    0.7.0.1
 */