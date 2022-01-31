package com.tencent.util;

import android.os.Build;

public final class h
{
  public static final String DEVICE = Build.DEVICE.toLowerCase();
  public static final String MANUFACTURER = Build.MANUFACTURER.toLowerCase();
  public static final String MODEL;
  private static h xcJ = null;
  private String bJp = null;
  private boolean xcI = false;
  public boolean xcK = false;
  public boolean xcL = false;
  private boolean xcM = false;
  public int xcN = 0;
  private boolean xcO = false;
  public boolean xcP = false;
  private boolean xcQ = false;
  private boolean xcR = false;
  public boolean xcS = false;
  private boolean xcT = false;
  private boolean xcU = false;
  private int xcV = 0;
  private boolean xcW = false;
  private boolean xcX = true;
  private boolean xcY = false;
  
  static
  {
    MODEL = Build.MODEL.toLowerCase();
  }
  
  private h()
  {
    if (this.xcI)
    {
      g.g("PhoneProperty", "******MODEL*****" + Build.MODEL);
      g.g("PhoneProperty", "******BRAND*****" + Build.BRAND);
      g.g("PhoneProperty", "*******DEVICE****" + Build.DEVICE);
      g.g("PhoneProperty", "*****DISPLAY******" + Build.DISPLAY);
      g.g("PhoneProperty", "*****HARDWARE******" + Build.HARDWARE);
      g.g("PhoneProperty", "******MANUFACTURER*****" + Build.MANUFACTURER);
      g.g("PhoneProperty", "*****PRODUCT******" + Build.PRODUCT);
      g.g("PhoneProperty", "******TAGS*****" + Build.TAGS);
      g.g("PhoneProperty", "*****USER******" + Build.USER);
      g.g("PhoneProperty", "****TYPE*******" + Build.TYPE);
    }
  }
  
  public static h cRm()
  {
    if (xcJ == null) {
      xcJ = new h();
    }
    return xcJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.util.h
 * JD-Core Version:    0.7.0.1
 */