package com.tencent.tmassistantsdk.downloadservice;

import android.text.TextUtils;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.HashMap;

public class DownloadSetting
{
  public static final String ISDOWNLOADWIFIONLY = "isDownloadWifiOnly";
  public static final String ISTASKAUTORESUME = "isTaskAutoResume";
  public static final String MAXTASKNUM = "maxTaskNum";
  private static final String TAG = "DownloadSetting";
  public static final String TYPE_BOOLEAN = "boolean";
  public static final String TYPE_INTEGER = "Integer";
  protected static DownloadSetting mInstance = null;
  protected boolean isDownloadWifiOnly = false;
  protected boolean isTaskAutoResume = true;
  protected int maxTaskNum = 5;
  
  public DownloadSetting()
  {
    loadFromDB();
  }
  
  public static DownloadSetting getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DownloadSetting();
      }
      DownloadSetting localDownloadSetting = mInstance;
      return localDownloadSetting;
    }
    finally {}
  }
  
  static int getSplitSizeInBytes(String paramString)
  {
    if (paramString.equalsIgnoreCase("WIFI")) {
      throw new UnsupportedOperationException("Split is not allowed in current version. netType: " + paramString);
    }
    if (paramString.contains("net")) {}
    while (!paramString.contains("wap")) {
      return 921600;
    }
    return 409600;
  }
  
  private void loadFromDB()
  {
    boolean bool2 = false;
    Object localObject = DownloadSettingTable.query();
    String str = (String)((HashMap)localObject).get("isTaskAutoResume");
    if ((str != null) && (str.length() > 0))
    {
      if (str.equals("false"))
      {
        bool1 = false;
        this.isTaskAutoResume = bool1;
      }
    }
    else
    {
      str = (String)((HashMap)localObject).get("isDownloadWifiOnly");
      if ((str != null) && (str.length() > 0)) {
        if (!str.equals("false")) {
          break label126;
        }
      }
    }
    label126:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      this.isDownloadWifiOnly = bool1;
      localObject = (String)((HashMap)localObject).get("maxTaskNum");
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        this.maxTaskNum = Integer.valueOf((String)localObject).intValue();
      }
      return;
      bool1 = true;
      break;
    }
  }
  
  public boolean getIsDownloadWifiOnly()
  {
    return this.isDownloadWifiOnly;
  }
  
  public boolean getIsTaskAutoResume()
  {
    return this.isTaskAutoResume;
  }
  
  public int getMaxTaskNum()
  {
    return this.maxTaskNum;
  }
  
  public boolean isAutoDownload()
  {
    if (this.isTaskAutoResume)
    {
      String str = DownloadHelper.getNetStatus();
      if ((str.contains("wifi")) || (str.contains("net"))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isAutoDownload(String paramString1, String paramString2)
  {
    TMLog.i("DownloadSetting", "downloadInfoNetType = " + paramString1);
    TMLog.i("DownloadSetting", "currentNetType = " + paramString2);
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return false;
      if (paramString2.equalsIgnoreCase("WIFI")) {
        return true;
      }
    } while ((!paramString2.contains("net")) || (paramString1.equalsIgnoreCase("WIFI")));
    return true;
  }
  
  public void setIsDownloadWifiOnly(boolean paramBoolean)
  {
    if (mInstance.isDownloadWifiOnly == paramBoolean) {
      return;
    }
    mInstance.isDownloadWifiOnly = paramBoolean;
    DownloadSettingTable.save("isDownloadWifiOnly", String.valueOf(paramBoolean), "boolean");
  }
  
  public void setIsTaskAutoResume(boolean paramBoolean)
  {
    if (mInstance.isTaskAutoResume == paramBoolean) {
      return;
    }
    mInstance.isTaskAutoResume = paramBoolean;
    DownloadSettingTable.save("isTaskAutoResume", String.valueOf(paramBoolean), "boolean");
  }
  
  public void setMaxTaskNum(int paramInt)
  {
    if (mInstance.maxTaskNum == paramInt) {
      return;
    }
    mInstance.maxTaskNum = paramInt;
    DownloadSettingTable.save("maxTaskNum", String.valueOf(paramInt), "Integer");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.DownloadSetting
 * JD-Core Version:    0.7.0.1
 */