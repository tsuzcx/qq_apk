package com.tencent.ttpic.util;

import android.os.Build;
import java.util.HashMap;

public class VideoDeviceInstance
{
  private static final String[] BRAND_KEYS = { "motorola", "mot", "FIH", "Sony Ericsson", "samsung", "HTC", "HUN", "LGE", "alps", "OPPO", "TCL", "LENOVO", "ZTE", "Meizu", "Xiaomi", "HUAWEI", "TIANYU", "sprd", "K-Touch", "YuLong", "CoolPad", "Amazon", "Hisense", "Acer", "GIONEE", "Philips", "asus", "snda.com", "koobee", "AMOI", "Fason", "ainol", "Dell", "dlkjl12389", "haier", "sharp", "BBK", "nubia", "KONKA" };
  private static final String[] BRAND_NAMES = { "MOTOROLA", "MOTOROLA", "MOTOROLA", "SONYERICSSON", "SAMSUNG", "HTC", "HTC", "LG", "OPPO", "OPPO", "TCL", "LENOVO", "ZTE", "MEIZU", "XIAOMI", "HUAWEI", "TIANYU", "TIANYU", "TIANYU", "COOLPAD", "COOLPAD", "AMAZON", "HISENSE", "ACER", "JINLI", "PHILIPS", "GOOGLE", "SHENGDA", "KUBI", "XIAXIN", "FANSHANG", "AINUO", "DELL", "DPD", "HAIER", "SHARP", "BBK", "NUBIA", "KONKA" };
  private static final VideoDeviceInstance INSTANCE = new VideoDeviceInstance();
  public static final String MODEL_COOLPAD_8150 = "8150";
  public static final String MODEL_K_TOUCH_W619 = "K-Touch W619";
  public static final String MODEL_NEXUS_6 = "MOTOROLA_Nexus_6";
  public static final String MODEL_NEXUS_6P = "HUAWEI_Nexus_6P";
  private static String TAG = VideoDeviceInstance.class.getSimpleName();
  private HashMap<String, String> mBrandInterpretMap = new HashMap();
  
  private VideoDeviceInstance()
  {
    int i = 0;
    while (i < BRAND_KEYS.length)
    {
      this.mBrandInterpretMap.put(BRAND_KEYS[i].toUpperCase(), BRAND_NAMES[i]);
      i += 1;
    }
  }
  
  public static VideoDeviceInstance getInstance()
  {
    return INSTANCE;
  }
  
  public String getDeviceTypeName()
  {
    String str;
    if (Build.MODEL.equalsIgnoreCase("K-Touch W619")) {
      str = (String)this.mBrandInterpretMap.get("TIANYU") + " " + Build.MODEL;
    }
    for (;;)
    {
      return str.replace(" ", "_").replace("+", "").replace("(t)", "");
      if ((Build.MODEL.equalsIgnoreCase("8150")) && (Build.BRAND.equalsIgnoreCase("COOLPAD"))) {
        str = (String)this.mBrandInterpretMap.get("COOLPAD") + " " + Build.MODEL;
      } else {
        str = (String)this.mBrandInterpretMap.get(Build.MANUFACTURER.toUpperCase()) + " " + Build.MODEL;
      }
    }
  }
  
  public int getMaxMemorySizeInKB()
  {
    String str = getInstance().getDeviceTypeName().toLowerCase().trim();
    DEVICE_MEM[] arrayOfDEVICE_MEM = DEVICE_MEM.values();
    int j = arrayOfDEVICE_MEM.length;
    int i = 0;
    while (i < j)
    {
      DEVICE_MEM localDEVICE_MEM = arrayOfDEVICE_MEM[i];
      if (str.endsWith(localDEVICE_MEM.device.toLowerCase())) {
        return localDEVICE_MEM.sizeInKB;
      }
      i += 1;
    }
    return 2147483647;
  }
  
  public boolean needLoadAll()
  {
    boolean bool2 = false;
    String str = getInstance().getDeviceTypeName().toLowerCase().trim();
    DEVICE_MEM[] arrayOfDEVICE_MEM = DEVICE_MEM.values();
    int j = arrayOfDEVICE_MEM.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (str.endsWith(arrayOfDEVICE_MEM[i].device.toLowerCase())) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static enum DEVICE_MEM
  {
    GN9010("GN9010", 81920),  vivo_Y23L("vivo_Y23L", 81920),  vivo_Y27("vivo_Y27", 81920);
    
    private final String device;
    private final int sizeInKB;
    
    private DEVICE_MEM(String paramString, int paramInt)
    {
      this.device = paramString;
      this.sizeInKB = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoDeviceInstance
 * JD-Core Version:    0.7.0.1
 */