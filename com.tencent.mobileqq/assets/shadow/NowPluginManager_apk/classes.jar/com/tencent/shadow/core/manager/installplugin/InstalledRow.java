package com.tencent.shadow.core.manager.installplugin;

import android.content.ContentValues;
import java.util.Arrays;
import org.json.JSONArray;

public class InstalledRow
{
  public String UUID;
  public String businessName;
  public String[] dependsOn;
  public String filePath;
  public String hash;
  public String[] hostWhiteList;
  public long installedTime;
  public String partKey;
  public int type;
  public String version;
  
  public InstalledRow() {}
  
  public InstalledRow(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.hash = paramString1;
    this.partKey = paramString2;
    this.filePath = paramString3;
    this.type = paramInt;
  }
  
  public InstalledRow(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString1, String paramString4, int paramInt, String[] paramArrayOfString2)
  {
    this(paramString1, paramString3, paramString4, paramInt);
    this.businessName = paramString2;
    this.dependsOn = paramArrayOfString1;
    this.hostWhiteList = paramArrayOfString2;
  }
  
  public ContentValues toContentValues()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("hash", this.hash);
    localContentValues.put("installedTime", Long.valueOf(this.installedTime));
    if (this.businessName != null) {
      localContentValues.put("businessName", this.businessName);
    }
    if (this.partKey != null) {
      localContentValues.put("partKey", this.partKey);
    }
    if (this.dependsOn != null) {
      localContentValues.put("dependsOn", new JSONArray(Arrays.asList(this.dependsOn)).toString());
    }
    if (this.hostWhiteList != null) {
      localContentValues.put("hostWhiteList", new JSONArray(Arrays.asList(this.hostWhiteList)).toString());
    }
    localContentValues.put("type", Integer.valueOf(this.type));
    localContentValues.put("uuid", this.UUID);
    localContentValues.put("version", this.version);
    localContentValues.put("filePath", this.filePath);
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.manager.installplugin.InstalledRow
 * JD-Core Version:    0.7.0.1
 */