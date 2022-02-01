package com.tencent.tmassistantsdk.downloadservice;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
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
  protected boolean isDownloadWifiOnly;
  protected boolean isTaskAutoResume;
  protected int maxTaskNum;
  
  public DownloadSetting()
  {
    AppMethodBeat.i(101980);
    this.isTaskAutoResume = true;
    this.isDownloadWifiOnly = false;
    this.maxTaskNum = 5;
    loadFromDB();
    AppMethodBeat.o(101980);
  }
  
  public static DownloadSetting getInstance()
  {
    try
    {
      AppMethodBeat.i(101981);
      if (mInstance == null) {
        mInstance = new DownloadSetting();
      }
      DownloadSetting localDownloadSetting = mInstance;
      AppMethodBeat.o(101981);
      return localDownloadSetting;
    }
    finally {}
  }
  
  static int getSplitSizeInBytes(String paramString)
  {
    AppMethodBeat.i(101982);
    if (paramString.equalsIgnoreCase("WIFI"))
    {
      paramString = new UnsupportedOperationException("Split is not allowed in current version. netType: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(101982);
      throw paramString;
    }
    if (paramString.contains("net"))
    {
      AppMethodBeat.o(101982);
      return 921600;
    }
    if (paramString.contains("wap"))
    {
      AppMethodBeat.o(101982);
      return 409600;
    }
    AppMethodBeat.o(101982);
    return 921600;
  }
  
  private void loadFromDB()
  {
    boolean bool2 = true;
    AppMethodBeat.i(101986);
    Object localObject = DownloadSettingTable.query();
    String str = (String)((HashMap)localObject).get("isTaskAutoResume");
    if ((str != null) && (str.length() > 0)) {
      if (!str.equals("false")) {
        break label131;
      }
    }
    label131:
    for (boolean bool1 = false;; bool1 = true)
    {
      this.isTaskAutoResume = bool1;
      str = (String)((HashMap)localObject).get("isDownloadWifiOnly");
      if ((str != null) && (str.length() > 0))
      {
        bool1 = bool2;
        if (str.equals("false")) {
          bool1 = false;
        }
        this.isDownloadWifiOnly = bool1;
      }
      localObject = (String)((HashMap)localObject).get("maxTaskNum");
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        this.maxTaskNum = bu.getInt((String)localObject, 0);
      }
      AppMethodBeat.o(101986);
      return;
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
    AppMethodBeat.i(101987);
    if (this.isTaskAutoResume)
    {
      String str = DownloadHelper.getNetStatus();
      if ((str.contains("wifi")) || (str.contains("net")))
      {
        AppMethodBeat.o(101987);
        return true;
      }
    }
    AppMethodBeat.o(101987);
    return false;
  }
  
  public boolean isAutoDownload(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101988);
    TMLog.i("DownloadSetting", "downloadInfoNetType = ".concat(String.valueOf(paramString1)));
    TMLog.i("DownloadSetting", "currentNetType = ".concat(String.valueOf(paramString2)));
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(101988);
      return false;
    }
    if (paramString2.equalsIgnoreCase("WIFI"))
    {
      AppMethodBeat.o(101988);
      return true;
    }
    if ((paramString2.contains("net")) && (!paramString1.equalsIgnoreCase("WIFI")))
    {
      AppMethodBeat.o(101988);
      return true;
    }
    AppMethodBeat.o(101988);
    return false;
  }
  
  public void setIsDownloadWifiOnly(boolean paramBoolean)
  {
    AppMethodBeat.i(101984);
    if (mInstance.isDownloadWifiOnly == paramBoolean)
    {
      AppMethodBeat.o(101984);
      return;
    }
    mInstance.isDownloadWifiOnly = paramBoolean;
    DownloadSettingTable.save("isDownloadWifiOnly", String.valueOf(paramBoolean), "boolean");
    AppMethodBeat.o(101984);
  }
  
  public void setIsTaskAutoResume(boolean paramBoolean)
  {
    AppMethodBeat.i(101983);
    if (mInstance.isTaskAutoResume == paramBoolean)
    {
      AppMethodBeat.o(101983);
      return;
    }
    mInstance.isTaskAutoResume = paramBoolean;
    DownloadSettingTable.save("isTaskAutoResume", String.valueOf(paramBoolean), "boolean");
    AppMethodBeat.o(101983);
  }
  
  public void setMaxTaskNum(int paramInt)
  {
    AppMethodBeat.i(101985);
    if (mInstance.maxTaskNum == paramInt)
    {
      AppMethodBeat.o(101985);
      return;
    }
    mInstance.maxTaskNum = paramInt;
    DownloadSettingTable.save("maxTaskNum", String.valueOf(paramInt), "Integer");
    AppMethodBeat.o(101985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.DownloadSetting
 * JD-Core Version:    0.7.0.1
 */