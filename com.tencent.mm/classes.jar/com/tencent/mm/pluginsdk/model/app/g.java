package com.tencent.mm.pluginsdk.model.app;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.y;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public class g
  extends y
{
  public static String QWe;
  public static String QWf;
  public static String QWg;
  public static String QWh;
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(151678);
    QWe = "wxce6f23b478a3a2a2";
    QWf = "wx7302cee7c7d6d7d6";
    QWg = "wx6fa7e3bab7e15415";
    QWh = "wx3cc22b542de028d4";
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[26];
    localMAutoDBInfo.columns = new String[27];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "appId";
    localMAutoDBInfo.columns[1] = "appName";
    localMAutoDBInfo.colsMap.put("appName", "TEXT");
    localStringBuilder.append(" appName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "appDiscription";
    localMAutoDBInfo.colsMap.put("appDiscription", "TEXT");
    localStringBuilder.append(" appDiscription TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "appIconUrl";
    localMAutoDBInfo.colsMap.put("appIconUrl", "TEXT");
    localStringBuilder.append(" appIconUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "appStoreUrl";
    localMAutoDBInfo.colsMap.put("appStoreUrl", "TEXT");
    localStringBuilder.append(" appStoreUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "appVersion";
    localMAutoDBInfo.colsMap.put("appVersion", "INTEGER");
    localStringBuilder.append(" appVersion INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "appWatermarkUrl";
    localMAutoDBInfo.colsMap.put("appWatermarkUrl", "TEXT");
    localStringBuilder.append(" appWatermarkUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "packageName";
    localMAutoDBInfo.colsMap.put("packageName", "TEXT");
    localStringBuilder.append(" packageName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "signature";
    localMAutoDBInfo.colsMap.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "modifyTime";
    localMAutoDBInfo.colsMap.put("modifyTime", "LONG");
    localStringBuilder.append(" modifyTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "appName_en";
    localMAutoDBInfo.colsMap.put("appName_en", "TEXT");
    localStringBuilder.append(" appName_en TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "appName_tw";
    localMAutoDBInfo.colsMap.put("appName_tw", "TEXT");
    localStringBuilder.append(" appName_tw TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "appName_hk";
    localMAutoDBInfo.colsMap.put("appName_hk", "TEXT");
    localStringBuilder.append(" appName_hk TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "appDiscription_en";
    localMAutoDBInfo.colsMap.put("appDiscription_en", "TEXT");
    localStringBuilder.append(" appDiscription_en TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "appDiscription_tw";
    localMAutoDBInfo.colsMap.put("appDiscription_tw", "TEXT");
    localStringBuilder.append(" appDiscription_tw TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "appType";
    localMAutoDBInfo.colsMap.put("appType", "TEXT");
    localStringBuilder.append(" appType TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "openId";
    localMAutoDBInfo.colsMap.put("openId", "TEXT");
    localStringBuilder.append(" openId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "authFlag";
    localMAutoDBInfo.colsMap.put("authFlag", "INTEGER");
    localStringBuilder.append(" authFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "appInfoFlag";
    localMAutoDBInfo.colsMap.put("appInfoFlag", "INTEGER default '-1' ");
    localStringBuilder.append(" appInfoFlag INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "lvbuff";
    localMAutoDBInfo.colsMap.put("lvbuff", "BLOB");
    localStringBuilder.append(" lvbuff BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "serviceAppType";
    localMAutoDBInfo.colsMap.put("serviceAppType", "INTEGER default '0' ");
    localStringBuilder.append(" serviceAppType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "serviceAppInfoFlag";
    localMAutoDBInfo.colsMap.put("serviceAppInfoFlag", "INTEGER default '0' ");
    localStringBuilder.append(" serviceAppInfoFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "serviceShowFlag";
    localMAutoDBInfo.colsMap.put("serviceShowFlag", "INTEGER default '0' ");
    localStringBuilder.append(" serviceShowFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "appSupportContentType";
    localMAutoDBInfo.colsMap.put("appSupportContentType", "LONG default '0' ");
    localStringBuilder.append(" appSupportContentType LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "svrAppSupportContentType";
    localMAutoDBInfo.colsMap.put("svrAppSupportContentType", "LONG default '0' ");
    localStringBuilder.append(" svrAppSupportContentType LONG default '0' ");
    localMAutoDBInfo.columns[26] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(151678);
  }
  
  public g()
  {
    AppMethodBeat.i(151672);
    this.field_appId = "";
    this.field_appName = "";
    this.field_appDiscription = "";
    this.field_appIconUrl = "";
    this.field_appStoreUrl = "";
    this.field_appVersion = 0;
    this.field_appWatermarkUrl = "";
    this.field_packageName = "";
    this.field_status = 4;
    this.field_signature = "";
    this.field_modifyTime = 0L;
    this.field_appName_en = "";
    this.field_appName_tw = "";
    this.field_appName_hk = "";
    this.field_appDiscription_en = "";
    this.field_appDiscription_tw = "";
    this.field_appInfoFlag = 0;
    this.field_appType = "";
    this.field_openId = "";
    this.field_authFlag = 0;
    this.field_appInfoFlag = 0;
    HY("");
    HX("");
    HZ("");
    Id("");
    Ie("");
    If("");
    AppMethodBeat.o(151672);
  }
  
  public final boolean Qv()
  {
    AppMethodBeat.i(151673);
    if (Util.isNullOrNil(this.field_appType))
    {
      AppMethodBeat.o(151673);
      return false;
    }
    String[] arrayOfString = this.field_appType.split(",");
    if ((arrayOfString == null) || (arrayOfString.length == 0))
    {
      AppMethodBeat.o(151673);
      return false;
    }
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals("1"))
      {
        AppMethodBeat.o(151673);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(151673);
    return false;
  }
  
  public ContentValues convertTo()
  {
    AppMethodBeat.i(151675);
    if ((!Util.isNullOrNil(this.field_appType)) && ((this.field_appType.startsWith("1")) || (this.field_appType.startsWith("6")))) {
      this.field_appType = ("," + this.field_appType);
    }
    ContentValues localContentValues = super.convertTo();
    AppMethodBeat.o(151675);
    return localContentValues;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(151676);
    if (paramObject == null)
    {
      AppMethodBeat.o(151676);
      return false;
    }
    if (paramObject == this)
    {
      AppMethodBeat.o(151676);
      return true;
    }
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(151676);
      return false;
    }
    boolean bool = ((g)paramObject).field_appId.equals(this.field_appId);
    AppMethodBeat.o(151676);
    return bool;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(151677);
    if (!Util.isNullOrNil(this.field_appId))
    {
      i = this.field_appId.hashCode();
      AppMethodBeat.o(151677);
      return i;
    }
    int i = super.hashCode();
    AppMethodBeat.o(151677);
    return i;
  }
  
  public final boolean hhs()
  {
    return this.field_serviceAppType != 0;
  }
  
  public final boolean hht()
  {
    return (this.field_serviceAppInfoFlag & 0x2) != 0;
  }
  
  public final boolean hhu()
  {
    AppMethodBeat.i(151674);
    if (QWf.equals(this.field_appId))
    {
      AppMethodBeat.o(151674);
      return true;
    }
    AppMethodBeat.o(151674);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.g
 * JD-Core Version:    0.7.0.1
 */