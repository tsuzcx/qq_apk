package com.tencent.ttpic.logic.watermark;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.ttpic.model.WMElement;
import com.tencent.ttpic.util.VideoPrefsUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LogicDataManager
{
  public static final String ALTITUDE = "[altitude]";
  private static final String DATA_DEFAULT_LOCATION = "中国";
  private static final String DATA_DEFAULT_NO_NETWORK = "无网络";
  private static final String DATA_DEFAULT_TEMPERATURE = "0";
  private static final String DATA_DEFAULT_WEATHER = "晴";
  private static final String DATA_DEFAULT_WEATHER_TYPE = "";
  public static final String DATE = "[date]";
  public static final String DATE_D = "[date:D]";
  public static final String DATE_EEE = "[date:EEE]";
  public static final String DATE_EEEE = "[date:EEEE]";
  public static final String DATE_H = "[date:H]";
  public static final String DATE_H0 = "[date:H0]";
  public static final String DATE_H1 = "[date:H1]";
  public static final String DATE_HH = "[date:HH]";
  public static final String DATE_M = "[date:M]";
  public static final String DATE_M0 = "[date:M0]";
  public static final String DATE_M1 = "[date:M1]";
  public static final String DATE_MM = "[date:MM]";
  public static final String DATE_MMM = "[date:MMM]";
  public static final String DATE_MMMM = "[date:MMMM]";
  public static final String DATE_W = "[date:W]";
  public static final String DATE_Y0 = "[date:Y0]";
  public static final String DATE_Y1 = "[date:Y1]";
  public static final String DATE_Y2 = "[date:Y2]";
  public static final String DATE_Y3 = "[date:Y3]";
  public static final String DATE_YY = "[date:YY]";
  public static final String DATE_YYYY = "[date:YYYY]";
  public static final String DATE_a = "[date:a]";
  public static final String DATE_d = "[date:d]";
  public static final String DATE_d0 = "[date:d0]";
  public static final String DATE_d1 = "[date:d1]";
  public static final String DATE_dd = "[date:dd]";
  public static final String DATE_e = "[date:e]";
  public static final String DATE_h = "[date:h]";
  public static final String DATE_h0 = "[date:h0]";
  public static final String DATE_h1 = "[date:h1]";
  public static final String DATE_hh = "[date:hh]";
  public static final String DATE_m = "[date:m]";
  public static final String DATE_m0 = "[date:m0]";
  public static final String DATE_m1 = "[date:m1]";
  public static final String DATE_mm = "[date:mm]";
  public static final String DATE_s = "[date:s]";
  public static final String DATE_s0 = "[date:s0]";
  public static final String DATE_s1 = "[date:s1]";
  public static final String DATE_ss = "[date:ss]";
  public static final String DATE_w = "[date:w]";
  public static final String DATE_y0 = "[date:y0]";
  public static final String DATE_y1 = "[date:y1]";
  public static final String DATE_y2 = "[date:y2]";
  public static final String DATE_y3 = "[date:y3]";
  public static final String DATE_yy = "[date:yy]";
  public static final String DATE_yyyy = "[date:yyyy]";
  public static final String DB = "[db]";
  private static final int DECIBEL_UPDATE_INTERVAL = 500;
  public static final String LOCATION = "[location]";
  public static final String SPEED = "[speed]";
  public static final String TEMPERATURE = "[temperature]";
  public static final String TEMPERATURE_0 = "[temperature_0]";
  public static final String TEMPERATURE_1 = "[temperature_1]";
  public static final String TEMPERATURE_s = "[temperature_s]";
  public static final String WEATHER = "[weather]";
  public static final String WEATHER_TYPE = "[weatherType]";
  private static LogicDataManager mInstance;
  private final String TAG = LogicDataManager.class.getSimpleName();
  private String mAltitude = "无网络";
  private int mDecibel;
  private long mDecibelUpdateTimestamp = 0L;
  private List<WMElement> mEditableWMElements = new ArrayList();
  private String mLocation = "中国";
  private boolean mNeedDecibel = false;
  private Map<String, LogicDataManager.LogicValueProvider> mProviderMap = new HashMap();
  private String mTemperature = "0";
  private boolean mUseDecibelFromCameraRecorder = false;
  private String mWeather = "晴";
  private String mWeatherType = "";
  
  private void buildDataProviderMap()
  {
    this.mProviderMap.put("[date]", new LogicDataManager.1(this));
    this.mProviderMap.put("[date:yy]", new LogicDataManager.2(this));
    this.mProviderMap.put("[date:yyyy]", new LogicDataManager.3(this));
    this.mProviderMap.put("[date:y0]", new LogicDataManager.4(this));
    this.mProviderMap.put("[date:y1]", new LogicDataManager.5(this));
    this.mProviderMap.put("[date:y2]", new LogicDataManager.6(this));
    this.mProviderMap.put("[date:y3]", new LogicDataManager.7(this));
    this.mProviderMap.put("[date:M]", new LogicDataManager.8(this));
    this.mProviderMap.put("[date:MM]", new LogicDataManager.9(this));
    this.mProviderMap.put("[date:MMM]", new LogicDataManager.LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getMMM();
      }
    });
    this.mProviderMap.put("[date:MMMM]", new LogicDataManager.11(this));
    this.mProviderMap.put("[date:M0]", new LogicDataManager.12(this));
    this.mProviderMap.put("[date:M1]", new LogicDataManager.13(this));
    this.mProviderMap.put("[date:w]", new LogicDataManager.14(this));
    this.mProviderMap.put("[date:W]", new LogicDataManager.15(this));
    this.mProviderMap.put("[date:d]", new LogicDataManager.16(this));
    this.mProviderMap.put("[date:dd]", new LogicDataManager.17(this));
    this.mProviderMap.put("[date:d0]", new LogicDataManager.18(this));
    this.mProviderMap.put("[date:d1]", new LogicDataManager.19(this));
    this.mProviderMap.put("[date:D]", new LogicDataManager.20(this));
    this.mProviderMap.put("[date:e]", new LogicDataManager.21(this));
    this.mProviderMap.put("[date:EEE]", new LogicDataManager.LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getEEE();
      }
    });
    this.mProviderMap.put("[date:EEEE]", new LogicDataManager.LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getEEEE();
      }
    });
    this.mProviderMap.put("[date:a]", new LogicDataManager.LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.geta();
      }
    });
    this.mProviderMap.put("[date:h]", new LogicDataManager.25(this));
    this.mProviderMap.put("[date:hh]", new LogicDataManager.LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.gethh();
      }
    });
    this.mProviderMap.put("[date:h0]", new LogicDataManager.27(this));
    this.mProviderMap.put("[date:h1]", new LogicDataManager.28(this));
    this.mProviderMap.put("[date:H]", new LogicDataManager.29(this));
    this.mProviderMap.put("[date:HH]", new LogicDataManager.30(this));
    this.mProviderMap.put("[date:H0]", new LogicDataManager.31(this));
    this.mProviderMap.put("[date:H1]", new LogicDataManager.32(this));
    this.mProviderMap.put("[date:m]", new LogicDataManager.33(this));
    this.mProviderMap.put("[date:mm]", new LogicDataManager.34(this));
    this.mProviderMap.put("[date:m0]", new LogicDataManager.35(this));
    this.mProviderMap.put("[date:m1]", new LogicDataManager.36(this));
    this.mProviderMap.put("[date:s]", new LogicDataManager.37(this));
    this.mProviderMap.put("[date:ss]", new LogicDataManager.LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.getss();
      }
    });
    this.mProviderMap.put("[date:s0]", new LogicDataManager.LogicValueProvider()
    {
      public String getValue()
      {
        return LogicDataManager.this.gets(0);
      }
    });
    this.mProviderMap.put("[date:s1]", new LogicDataManager.40(this));
    this.mProviderMap.put("[db]", new LogicDataManager.41(this));
    this.mProviderMap.put("[altitude]", new LogicDataManager.42(this));
    this.mProviderMap.put("[location]", new LogicDataManager.43(this));
    this.mProviderMap.put("[weather]", new LogicDataManager.44(this));
    this.mProviderMap.put("[weatherType]", new LogicDataManager.45(this));
    this.mProviderMap.put("[temperature]", new LogicDataManager.46(this));
    this.mProviderMap.put("[temperature_0]", new LogicDataManager.47(this));
    this.mProviderMap.put("[temperature_1]", new LogicDataManager.48(this));
    this.mProviderMap.put("[temperature_s]", new LogicDataManager.49(this));
  }
  
  private String getAltitude()
  {
    return this.mAltitude;
  }
  
  private String getD()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("D").format(localDate);
  }
  
  private String getDB()
  {
    if (!this.mUseDecibelFromCameraRecorder)
    {
      DecibelDetector.getInstance().init();
      int i = DecibelDetector.getInstance().getDecibel();
      if (i != 0) {
        setDecibel(i);
      }
    }
    return String.valueOf(this.mDecibel);
  }
  
  private String getEEE()
  {
    int i = 0;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    int j = localCalendar.get(7) - 1;
    if (j < 0) {}
    for (;;)
    {
      return new String[] { "Sun.", "Mon.", "Tues.", "Wed.", "Thur.", "Fri.", "Sat." }[i];
      i = j;
    }
  }
  
  private String getEEEE()
  {
    int i = 0;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    int j = localCalendar.get(7) - 1;
    if (j < 0) {}
    for (;;)
    {
      return new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }[i];
      i = j;
    }
  }
  
  private String getH()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("H").format(localDate);
  }
  
  private String getH(int paramInt)
  {
    return getHH().substring(paramInt, paramInt + 1);
  }
  
  private String getHH()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("HH").format(localDate);
  }
  
  public static LogicDataManager getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new LogicDataManager();
      }
      LogicDataManager localLogicDataManager = mInstance;
      return localLogicDataManager;
    }
    finally {}
  }
  
  private String getM()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("M").format(localDate);
  }
  
  private String getM(int paramInt)
  {
    return getMM().substring(paramInt, paramInt + 1);
  }
  
  private String getMM()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("MM").format(localDate);
  }
  
  private String getMMM()
  {
    int i = Integer.parseInt(getM(0));
    if (i == 0) {}
    for (i = Integer.parseInt(getM(1)); i < 12; i = i * 10 + Integer.parseInt(getM(1))) {
      return new String[] { "Jan.", "Feb.", "Mar.", "Apr.", "May.", "Jun.", "Jul.", "Aug.", "Sept.", "Oct.", "Nov.", "Dec." }[i];
    }
    return "";
  }
  
  private String getMMMM()
  {
    int i = Integer.parseInt(getM(0));
    if (i == 0) {}
    for (i = Integer.parseInt(getM(1)); i < 12; i = i * 10 + Integer.parseInt(getM(1))) {
      return new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }[i];
    }
    return "";
  }
  
  private String getTemperature()
  {
    return this.mTemperature;
  }
  
  private String getTemperature(int paramInt)
  {
    if (!TextUtils.isEmpty(this.mTemperature)) {
      try
      {
        if (Integer.parseInt(this.mTemperature) >= 0)
        {
          if (paramInt + 1 <= this.mTemperature.length()) {
            return this.mTemperature.substring(paramInt, paramInt + 1);
          }
        }
        else if (paramInt + 2 <= this.mTemperature.length())
        {
          String str = this.mTemperature.substring(paramInt + 1, paramInt + 2);
          return str;
        }
      }
      catch (Exception localException) {}
    }
    return "";
  }
  
  private String getTemperatureSymbol()
  {
    if (!TextUtils.isEmpty(this.mTemperature)) {
      try
      {
        if (Integer.parseInt(this.mTemperature) >= 0) {
          return "+";
        }
        return "-";
      }
      catch (Exception localException) {}
    }
    return "";
  }
  
  private String getTimestamp()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(localDate);
  }
  
  private String getW()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("W").format(localDate);
  }
  
  private String geta()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("a").format(localDate);
  }
  
  private String getd()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("d").format(localDate);
  }
  
  private String getd(int paramInt)
  {
    return getdd().substring(paramInt, paramInt + 1);
  }
  
  private String getdd()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("dd").format(localDate);
  }
  
  private String gete()
  {
    int i = 0;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    int j = localCalendar.get(7) - 1;
    if (j < 0) {}
    for (;;)
    {
      return new String[] { "日", "一", "二", "三", "四", "五", "六" }[i];
      i = j;
    }
  }
  
  private String geth()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("h").format(localDate);
  }
  
  private String geth(int paramInt)
  {
    Date localDate = new Date();
    return new SimpleDateFormat("hh").format(localDate).substring(paramInt, paramInt + 1);
  }
  
  private String gethh()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("hh").format(localDate);
  }
  
  private String getm()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("m").format(localDate);
  }
  
  private String getm(int paramInt)
  {
    return getmm().substring(paramInt, paramInt + 1);
  }
  
  private String getmm()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("mm").format(localDate);
  }
  
  private String gets()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("s").format(localDate);
  }
  
  private String gets(int paramInt)
  {
    return getss().substring(paramInt, paramInt + 1);
  }
  
  private String getss()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("ss").format(localDate);
  }
  
  private String getw()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("w").format(localDate);
  }
  
  private String gety(int paramInt)
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yyyy").format(localDate).substring(paramInt, paramInt + 1);
  }
  
  private String getyy()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yy").format(localDate);
  }
  
  private String getyyyy()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yyyy").format(localDate);
  }
  
  private void resetParams()
  {
    this.mNeedDecibel = false;
    this.mUseDecibelFromCameraRecorder = false;
    this.mDecibelUpdateTimestamp = 0L;
  }
  
  public void addEditableWMElement(WMElement paramWMElement)
  {
    this.mEditableWMElements.add(paramWMElement);
  }
  
  public void addWatermarkDict(Map<String, String> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      this.mProviderMap.put("[" + (String)localEntry.getKey() + "]", new LogicDataManager.50(this, localEntry));
    }
  }
  
  public void destroy()
  {
    destroyDecibelDetector();
  }
  
  public void destroyDecibelDetector()
  {
    DecibelDetector.getInstance().destroy();
  }
  
  public List<WMElement> getEditableWMElement()
  {
    return this.mEditableWMElements;
  }
  
  public String getLocation()
  {
    return this.mLocation;
  }
  
  public String getValue(String paramString)
  {
    String str = paramString;
    if (this.mProviderMap.containsKey(paramString)) {
      str = ((LogicDataManager.LogicValueProvider)this.mProviderMap.get(paramString)).getValue();
    }
    return str;
  }
  
  public boolean hasObtainedServerData()
  {
    return (!"中国".equals(this.mLocation)) && (!"晴".equals(this.mWeather)) && (!"0".equals(this.mTemperature)) && (!"无网络".equals(this.mAltitude));
  }
  
  public void init()
  {
    resetParams();
    buildDataProviderMap();
  }
  
  public String mapWeatherCode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "晴";
    case 1: 
      return "多云";
    case 2: 
      return "阴";
    case 3: 
      return "雨";
    case 4: 
      return "雪";
    case 5: 
      return "雾";
    case 6: 
      return "雨加雪";
    case 7: 
      return "雷阵雨";
    case 8: 
      return "沙尘暴";
    }
    return "大风";
  }
  
  public boolean needDecibel()
  {
    return this.mNeedDecibel;
  }
  
  public void recordDate(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1.equals("since")) {
      VideoPrefsUtil.getDefaultPrefs().edit().putString("prefs_key_watermark_since_" + paramString2, paramString3).apply();
    }
    while (!paramString1.equals("countdown")) {
      return;
    }
    VideoPrefsUtil.getDefaultPrefs().edit().putString("prefs_key_watermark_countdown_" + paramString2, paramString3).apply();
  }
  
  public void removeEditableWMElement(WMElement paramWMElement)
  {
    this.mEditableWMElements.remove(paramWMElement);
  }
  
  public String replaceWithData(String paramString, Set<String> paramSet)
  {
    Iterator localIterator = paramSet.iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.mProviderMap.containsKey(str)) {}
      for (paramSet = ((LogicDataManager.LogicValueProvider)this.mProviderMap.get(str)).getValue();; paramSet = "")
      {
        paramString = paramString.replace(str, paramSet);
        break;
      }
    }
    return paramString;
  }
  
  public void setAltitude(String paramString)
  {
    this.mAltitude = paramString;
  }
  
  public void setDecibel(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - this.mDecibelUpdateTimestamp > 500L)
    {
      this.mDecibel = paramInt;
      this.mDecibelUpdateTimestamp = l;
    }
  }
  
  public void setDecibelFromCameraRecorder(boolean paramBoolean)
  {
    this.mUseDecibelFromCameraRecorder = paramBoolean;
  }
  
  public void setLocation(String paramString)
  {
    this.mLocation = paramString;
  }
  
  public void setNeedDB(boolean paramBoolean)
  {
    this.mNeedDecibel = paramBoolean;
  }
  
  public void setTemperature(String paramString)
  {
    this.mTemperature = paramString;
  }
  
  public void setWeather(int paramInt)
  {
    this.mWeather = mapWeatherCode(paramInt);
  }
  
  public void setWeatherType(int paramInt)
  {
    this.mWeatherType = String.valueOf(paramInt);
  }
  
  public void test()
  {
    Iterator localIterator = this.mProviderMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      new StringBuilder().append((String)localEntry.getKey()).append(": ").append(((LogicDataManager.LogicValueProvider)localEntry.getValue()).getValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.logic.watermark.LogicDataManager
 * JD-Core Version:    0.7.0.1
 */