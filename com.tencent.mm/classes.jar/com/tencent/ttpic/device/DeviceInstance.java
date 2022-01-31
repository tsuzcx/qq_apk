package com.tencent.ttpic.device;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;
import java.util.HashMap;

public class DeviceInstance
{
  public static final String BRAND_MEIZU = "MEIZU";
  private static final String[][] BRAND_NAMES;
  public static final String BRAND_VIVO = "VIVO";
  public static final String BRAND_XIAOMI = "XIAOMI";
  private static final DeviceInstance INSTANCE;
  public static final String MODEL_COOLPAD_8150 = "8150";
  public static final String MODEL_K_TOUCH_W619 = "K-Touch W619";
  public static final String MODEL_NEXUS_6 = "MOTOROLA_Nexus_6";
  public static final String MODEL_NEXUS_6P = "HUAWEI_Nexus_6P";
  public static final String NUBIA_NX511J = "NUBIA_NX511J";
  private static final String[][] SOC_SCORE;
  private static String TAG;
  private String mDeviceName;
  private HashMap<String, String> mModelMap;
  private HashMap<String, String> mSocMap;
  
  static
  {
    AppMethodBeat.i(49853);
    TAG = DeviceInstance.class.getSimpleName();
    String[] arrayOfString1 = { "mot", "MOTOROLA" };
    String[] arrayOfString2 = { "FIH", "MOTOROLA" };
    String[] arrayOfString3 = { "Sony Ericsson", "SONYERICSSON" };
    String[] arrayOfString4 = { "Sony", "SONY" };
    String[] arrayOfString5 = { "samsung", "SAMSUNG" };
    String[] arrayOfString6 = { "HUN", "HTC" };
    String[] arrayOfString7 = { "LGE", "LG" };
    String[] arrayOfString8 = { "alps", "OPPO" };
    String[] arrayOfString9 = { "OPPO", "OPPO" };
    String[] arrayOfString10 = { "TCL", "TCL" };
    String[] arrayOfString11 = { "LENOVO", "LENOVO" };
    String[] arrayOfString12 = { "Meizu", "MEIZU" };
    String[] arrayOfString13 = { "Xiaomi", "XIAOMI" };
    String[] arrayOfString14 = { "HUAWEI", "HUAWEI" };
    String[] arrayOfString15 = { "TIANYU", "TIANYU" };
    String[] arrayOfString16 = { "sprd", "TIANYU" };
    String[] arrayOfString17 = { "K-Touch", "TIANYU" };
    String[] arrayOfString18 = { "YuLong", "COOLPAD" };
    String[] arrayOfString19 = { "Amazon", "AMAZON" };
    String[] arrayOfString20 = { "Hisense", "HISENSE" };
    String[] arrayOfString21 = { "Acer", "ACER" };
    String[] arrayOfString22 = { "GIONEE", "JINLI" };
    String[] arrayOfString23 = { "Philips", "PHILIPS" };
    String[] arrayOfString24 = { "asus", "GOOGLE" };
    String[] arrayOfString25 = { "Google", "GOOGLE" };
    String[] arrayOfString26 = { "snda.com", "SHENGDA" };
    String[] arrayOfString27 = { "koobee", "KUBI" };
    String[] arrayOfString28 = { "AMOI", "XIAXIN" };
    String[] arrayOfString29 = { "Fason", "FANSHANG" };
    String[] arrayOfString30 = { "Dell", "DELL" };
    String[] arrayOfString31 = { "dlkjl12389", "DPD" };
    String[] arrayOfString32 = { "sharp", "SHARP" };
    String[] arrayOfString33 = { "BBK", "BBK" };
    String[] arrayOfString34 = { "vivo", "VIVO" };
    String[] arrayOfString35 = { "nubia", "NUBIA" };
    String[] arrayOfString36 = { "Letv", "LESHI" };
    String[] arrayOfString37 = { "Meitu", "MEITU" };
    String[] arrayOfString38 = { "OnePlus", "ONEPLUS" };
    String[] arrayOfString39 = { "360", "QIHOO" };
    String[] arrayOfString40 = { "CMDC", "CMDC" };
    String[] arrayOfString41 = { "DOOV", "DOOV" };
    BRAND_NAMES = new String[][] { { "motorola", "MOTOROLA" }, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4, arrayOfString5, { "HTC", "HTC" }, arrayOfString6, arrayOfString7, arrayOfString8, arrayOfString9, arrayOfString10, arrayOfString11, { "ZTE", "ZTE" }, arrayOfString12, arrayOfString13, arrayOfString14, arrayOfString15, arrayOfString16, arrayOfString17, arrayOfString18, { "CoolPad", "COOLPAD" }, arrayOfString19, arrayOfString20, arrayOfString21, arrayOfString22, arrayOfString23, arrayOfString24, arrayOfString25, arrayOfString26, arrayOfString27, arrayOfString28, arrayOfString29, { "ainol", "AINUO" }, arrayOfString30, arrayOfString31, { "haier", "HAIER" }, arrayOfString32, arrayOfString33, arrayOfString34, arrayOfString35, { "KONKA", "KONKA" }, { "LeMobile", "LESHI" }, arrayOfString36, arrayOfString37, arrayOfString38, arrayOfString39, arrayOfString40, arrayOfString41 };
    arrayOfString1 = new String[] { "Samsung Exynos 8895", "6500" };
    arrayOfString2 = new String[] { "Samsung Exynos 8890", "5300" };
    arrayOfString3 = new String[] { "Qualcomm Snapdragon 835", "6100" };
    arrayOfString4 = new String[] { "HiSilicon Kirin 950", "5100" };
    arrayOfString5 = new String[] { "Qualcomm Snapdragon 653", "3800" };
    arrayOfString6 = new String[] { "Qualcomm Snapdragon 652", "3600" };
    arrayOfString7 = new String[] { "Qualcomm Snapdragon 808", "3300" };
    arrayOfString8 = new String[] { "Qualcomm Snapdragon 626", "3200" };
    arrayOfString9 = new String[] { "Qualcomm Snapdragon 801", "3100" };
    arrayOfString10 = new String[] { "Qualcomm Snapdragon 625", "3100" };
    arrayOfString11 = new String[] { "Mediatek MT6797 Helio X20", "3700" };
    arrayOfString12 = new String[] { "Mediatek M675x Helio P25", "3700" };
    arrayOfString13 = new String[] { "Mediatek M6757 Helio P20", "3600" };
    arrayOfString14 = new String[] { "Mediatek MT6755T Helio P15", "3300" };
    arrayOfString15 = new String[] { "Mediatek MT6755 Helio P10", "3300" };
    arrayOfString16 = new String[] { "Mediatek MT6797M", "3600" };
    arrayOfString17 = new String[] { "Mediatek MT6753T", "3100" };
    arrayOfString18 = new String[] { "HiSilicon Kirin 935", "3500" };
    arrayOfString19 = new String[] { "HiSilicon Kirin 659", "3400" };
    arrayOfString20 = new String[] { "HiSilicon Kirin 655", "3400" };
    arrayOfString21 = new String[] { "HiSilicon Kirin 650", "3300" };
    arrayOfString22 = new String[] { "Samsung Exynos 7420", "3900" };
    arrayOfString23 = new String[] { "Samsung Exynos 7580", "3400" };
    arrayOfString24 = new String[] { "Samsung Exynos 5433", "3300" };
    arrayOfString25 = new String[] { "NVIDIA Tegra X1", "3100" };
    arrayOfString26 = new String[] { "Qualcomm Snapdragon 800", "2700" };
    arrayOfString27 = new String[] { "Qualcomm Snapdragon 617", "2400" };
    arrayOfString28 = new String[] { "Qualcomm Snapdragon 615", "1800" };
    arrayOfString29 = new String[] { "Qualcomm Snapdragon 600", "1800" };
    arrayOfString30 = new String[] { "Qualcomm Snapdragon 435", "2800" };
    arrayOfString31 = new String[] { "Qualcomm Snapdragon 430", "2700" };
    arrayOfString32 = new String[] { "Qualcomm Snapdragon 427", "2600" };
    arrayOfString33 = new String[] { "Qualcomm Snapdragon 410", "1100" };
    arrayOfString34 = new String[] { "Mediatek MT6795", "2600" };
    arrayOfString35 = new String[] { "Mediatek MT6752m", "2900" };
    arrayOfString36 = new String[] { "Mediatek MT6735", "1600" };
    arrayOfString37 = new String[] { "Mediatek MT6595", "2500" };
    arrayOfString38 = new String[] { "Mediatek MT6582", "1600" };
    arrayOfString39 = new String[] { "Mediatek MT6580", "1500" };
    arrayOfString40 = new String[] { "Samsung Exynos 7578", "1800" };
    arrayOfString41 = new String[] { "Samsung Exynos 7570", "1700" };
    String[] arrayOfString42 = { "Samsung Exynos 5800", "2300" };
    String[] arrayOfString43 = { "Samsung Exynos 5422", "2000" };
    String[] arrayOfString44 = { "Samsung Exynos 5420", "2000" };
    String[] arrayOfString45 = { "Samsung Exynos 5410", "1700" };
    String[] arrayOfString46 = { "Samsung Exynos 5260", "1700" };
    String[] arrayOfString47 = { "HiSilicon Kirin 928", "2300" };
    String[] arrayOfString48 = { "HiSilicon Kirin 920 Hi3630", "1800" };
    String[] arrayOfString49 = { "HiSilicon Kirin 925", "2200" };
    String[] arrayOfString50 = { "HiSilicon Kirin 910T", "2200" };
    String[] arrayOfString51 = { "HiSilicon Kirin 620", "2000" };
    String[] arrayOfString52 = { "Intel Atom Z3745", "2100" };
    String[] arrayOfString53 = { "NVIDIA Tegra K1", "2700" };
    String[] arrayOfString54 = { "Qualcomm Snapdragon 400", "900" };
    String[] arrayOfString55 = { "Qualcomm Snapdragon 208", "600" };
    String[] arrayOfString56 = { "Qualcomm Snapdragon 200", "600" };
    String[] arrayOfString57 = { "Qualcomm Snapdragon S4 Plus MSM8227", "600" };
    String[] arrayOfString58 = { "Samsung Exynos 4210", "700" };
    String[] arrayOfString59 = { "Samsung Exynos 3470", "900" };
    String[] arrayOfString60 = { "NVIDIA Tegra 3 T30", "800" };
    String[] arrayOfString61 = { "Ti OMAP 4470", "800" };
    SOC_SCORE = new String[][] { arrayOfString1, arrayOfString2, arrayOfString3, { "Qualcomm Snapdragon 821", "4500" }, { "Qualcomm Snapdragon 820", "4100" }, { "Qualcomm Snapdragon 660", "4100" }, { "Hisilicon Kirin 960", "6000" }, { "HiSilicon Kirin 955", "5300" }, arrayOfString4, { "Mediatek Helio X27", "4800" }, { "Qualcomm Snapdragon 810", "3800" }, arrayOfString5, arrayOfString6, { "Qualcomm Snapdragon 650", "3500" }, arrayOfString7, { "Qualcomm Snapdragon 805", "3200" }, arrayOfString8, arrayOfString9, arrayOfString10, { "Mediatek MT6797T Helio X25", "3800" }, { "Mediatek Helio X23", "3800" }, arrayOfString11, { "Mediatek MT6795 Helio X10", "3400" }, arrayOfString12, arrayOfString13, arrayOfString14, arrayOfString15, arrayOfString16, arrayOfString17, { "Mediatek MT6753", "3100" }, arrayOfString18, { "HiSilicon Kirin 930", "3400" }, arrayOfString19, arrayOfString20, arrayOfString21, arrayOfString22, { "Samsung Exynos 7870", "3400" }, arrayOfString23, arrayOfString24, { "Samsung Exynos 5430", "3100" }, arrayOfString25, { "Intel Atom Z8500", "3100" }, arrayOfString26, arrayOfString27, { "Qualcomm Snapdragon 616", "1900" }, arrayOfString28, arrayOfString29, arrayOfString30, arrayOfString31, arrayOfString32, { "Qualcomm Snapdragon 425", "1700" }, { "Qualcomm Snapdragon 415", "1300" }, { "Qualcomm Snapdragon 412", "1200" }, arrayOfString33, { "Qualcomm Snapdragon S4 MSM8960 Pro", "1200" }, { "Qualcomm Snapdragon S4 Pro APQ8064", "1700" }, arrayOfString34, arrayOfString35, { "Mediatek MT6752", "1800" }, { "Mediatek MT6755M", "2600" }, arrayOfString36, { "Mediatek MT6735P", "1600" }, { "Mediatek MT6737", "1800" }, { "Mediatek MT6750", "2100" }, arrayOfString37, { "Mediatek MT6592", "2200" }, arrayOfString38, arrayOfString39, arrayOfString40, arrayOfString41, arrayOfString42, arrayOfString43, arrayOfString44, arrayOfString45, arrayOfString46, { "Samsung Exynos 5250", "1200" }, { "Samsung Exynos 4412", "1500" }, arrayOfString47, arrayOfString48, { "HiSilicon Kirin 920", "1800" }, arrayOfString49, arrayOfString50, arrayOfString51, { "Intel Atom Z2560", "2800" }, arrayOfString52, arrayOfString53, { "NVIDIA Tegra K1 Denver", "2700" }, { "NVIDIA Tegra 4", "2200" }, arrayOfString54, { "Qualcomm Snapdragon 210", "600" }, arrayOfString55, arrayOfString56, { "Qualcomm Snapdragon S4 MSM8960T", "900" }, { "Qualcomm Snapdragon S4 MSM8960", "800" }, arrayOfString57, arrayOfString58, arrayOfString59, { "NVIDIA Tegra 3 T30L", "900" }, arrayOfString60, arrayOfString61, { "Ti OMAP 4460", "600" }, { "Ti OMAP 4430", "500" } };
    INSTANCE = new DeviceInstance();
    AppMethodBeat.o(49853);
  }
  
  private DeviceInstance()
  {
    AppMethodBeat.i(49843);
    this.mModelMap = new HashMap();
    this.mSocMap = new HashMap();
    this.mDeviceName = "";
    int i = 0;
    while (i < BRAND_NAMES.length)
    {
      this.mModelMap.put(BRAND_NAMES[i][0].toUpperCase(), BRAND_NAMES[i][1]);
      i += 1;
    }
    i = 0;
    while (i < SOC_SCORE.length)
    {
      this.mSocMap.put(SOC_SCORE[i][0], SOC_SCORE[i][1]);
      i += 1;
    }
    showDeviceInfo();
    AppMethodBeat.o(49843);
  }
  
  public static DeviceInstance getInstance()
  {
    return INSTANCE;
  }
  
  private void showDeviceInfo()
  {
    AppMethodBeat.i(49852);
    LogUtils.d(TAG, "****** DeviceInfo  (+) *****");
    LogUtils.d(TAG, "DeviceName = " + getDeviceName());
    LogUtils.d(TAG, "SubName = " + getDeviceName() + "_" + Build.DISPLAY.replace(" ", "_").toUpperCase());
    LogUtils.d(TAG, "MODEL = " + Build.MODEL);
    LogUtils.d(TAG, "SDK_INT = " + Build.VERSION.SDK_INT);
    LogUtils.d(TAG, "BRAND = " + Build.BRAND);
    LogUtils.d(TAG, "DEVICE = " + Build.DEVICE);
    LogUtils.d(TAG, "DISPLAY = " + Build.DISPLAY);
    LogUtils.d(TAG, "HARDWARE = " + Build.HARDWARE);
    LogUtils.d(TAG, "MANUFACTURER = " + Build.MANUFACTURER);
    LogUtils.d(TAG, "PRODUCT = " + Build.PRODUCT);
    LogUtils.d(TAG, "TAGS = " + Build.TAGS);
    LogUtils.d(TAG, "USER = " + Build.USER);
    LogUtils.d(TAG, "TYPE = " + Build.TYPE);
    LogUtils.d(TAG, "BOARD = " + Build.BOARD);
    LogUtils.d(TAG, "****** DeviceInfo (-) *****");
    AppMethodBeat.o(49852);
  }
  
  public String getDeviceName()
  {
    AppMethodBeat.i(49844);
    if (TextUtils.isEmpty(this.mDeviceName))
    {
      if (!Build.MODEL.equalsIgnoreCase("K-Touch W619")) {
        break label116;
      }
      this.mDeviceName = ((String)this.mModelMap.get("TIANYU") + " " + Build.MODEL);
    }
    for (;;)
    {
      this.mDeviceName = this.mDeviceName.replace(" ", "_").replace("+", "").replace("(t)", "");
      String str = this.mDeviceName;
      AppMethodBeat.o(49844);
      return str;
      label116:
      if ((Build.MODEL.equalsIgnoreCase("8150")) && (Build.BRAND.equalsIgnoreCase("COOLPAD"))) {
        this.mDeviceName = ((String)this.mModelMap.get("COOLPAD") + " " + Build.MODEL);
      } else {
        this.mDeviceName = ((String)this.mModelMap.get(Build.MANUFACTURER.toUpperCase()) + " " + Build.MODEL);
      }
    }
  }
  
  public DeviceInstance.SOC_CLASS getDeviceSocClass(String paramString)
  {
    AppMethodBeat.i(49845);
    LogUtils.d(TAG, "[getDeviceSocClass] + BEGIN, socInfo = ".concat(String.valueOf(paramString)));
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      str1 = str2;
      if (this.mSocMap != null)
      {
        str1 = str2;
        if (this.mSocMap.containsKey(paramString)) {
          str1 = (String)this.mSocMap.get(paramString);
        }
      }
    }
    LogUtils.d(TAG, "[getDeviceSocClass] scoreValue = ".concat(String.valueOf(str1)));
    paramString = DeviceInstance.SOC_CLASS.NULL;
    int i;
    if (!TextUtils.isEmpty(str1))
    {
      i = Integer.parseInt(str1);
      if (i >= DeviceInstance.SOC_CLASS.HIGH.score) {
        paramString = DeviceInstance.SOC_CLASS.HIGH;
      }
    }
    for (;;)
    {
      LogUtils.d(TAG, "[getDeviceSocClass] + END, socClass = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(49845);
      return paramString;
      if (i >= DeviceInstance.SOC_CLASS.NORMAL.score) {
        paramString = DeviceInstance.SOC_CLASS.NORMAL;
      } else if (i >= DeviceInstance.SOC_CLASS.LOW.score) {
        paramString = DeviceInstance.SOC_CLASS.LOW;
      } else if (i > DeviceInstance.SOC_CLASS.V_LOW.score) {
        paramString = DeviceInstance.SOC_CLASS.V_LOW;
      }
    }
  }
  
  public int getMaxMemorySizeInKB()
  {
    AppMethodBeat.i(49850);
    String str = getDeviceName().toLowerCase().trim();
    DeviceInstance.DEVICE_MEM[] arrayOfDEVICE_MEM = DeviceInstance.DEVICE_MEM.values();
    int j = arrayOfDEVICE_MEM.length;
    int i = 0;
    while (i < j)
    {
      DeviceInstance.DEVICE_MEM localDEVICE_MEM = arrayOfDEVICE_MEM[i];
      if (str.endsWith(DeviceInstance.DEVICE_MEM.access$000(localDEVICE_MEM).toLowerCase()))
      {
        i = DeviceInstance.DEVICE_MEM.access$100(localDEVICE_MEM);
        AppMethodBeat.o(49850);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(49850);
    return 2147483647;
  }
  
  public boolean isMeiZuDevice()
  {
    AppMethodBeat.i(49849);
    LogUtils.d(TAG, "[isMeiZuDevice] + BEGIN");
    boolean bool2 = false;
    String str = getDeviceName();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str))
    {
      bool1 = bool2;
      if (str.startsWith("MEIZU")) {
        bool1 = true;
      }
    }
    LogUtils.d(TAG, "[isMeiZuDevice] + END, isMeizu = ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(49849);
    return bool1;
  }
  
  public boolean isViVoDevice()
  {
    AppMethodBeat.i(49847);
    LogUtils.d(TAG, "[isViVoDevice] + BEGIN");
    boolean bool2 = false;
    String str = getDeviceName();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str))
    {
      bool1 = bool2;
      if (str.startsWith("VIVO")) {
        bool1 = true;
      }
    }
    LogUtils.d(TAG, "[isViVoDevice] + END, isViVo = ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(49847);
    return bool1;
  }
  
  public boolean isVivoY23LDevice()
  {
    AppMethodBeat.i(49848);
    String str = getDeviceName();
    if ((!TextUtils.isEmpty(str)) && (str.equals("VIVO_vivo_Y23L")))
    {
      AppMethodBeat.o(49848);
      return true;
    }
    AppMethodBeat.o(49848);
    return false;
  }
  
  public boolean isXiaoMiDevice()
  {
    AppMethodBeat.i(49846);
    LogUtils.d(TAG, "[isXiaoMiDevice] + BEGIN");
    boolean bool2 = false;
    String str = getDeviceName();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str))
    {
      bool1 = bool2;
      if (str.startsWith("XIAOMI")) {
        bool1 = true;
      }
    }
    LogUtils.d(TAG, "[isXiaoMiDevice] + END, isXiaomi = ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(49846);
    return bool1;
  }
  
  public boolean needLoadAll()
  {
    AppMethodBeat.i(49851);
    String str = getDeviceName().toLowerCase().trim();
    DeviceInstance.DEVICE_MEM[] arrayOfDEVICE_MEM = DeviceInstance.DEVICE_MEM.values();
    int j = arrayOfDEVICE_MEM.length;
    int i = 0;
    while (i < j)
    {
      if (str.endsWith(DeviceInstance.DEVICE_MEM.access$000(arrayOfDEVICE_MEM[i]).toLowerCase()))
      {
        AppMethodBeat.o(49851);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(49851);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.device.DeviceInstance
 * JD-Core Version:    0.7.0.1
 */