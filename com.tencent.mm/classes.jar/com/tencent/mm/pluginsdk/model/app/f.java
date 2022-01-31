package com.tencent.mm.pluginsdk.model.app;

import android.content.ContentValues;
import com.tencent.mm.h.c.r;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.lang.reflect.Field;
import java.util.Map;

public class f
  extends r
{
  protected static c.a buS;
  public static String rUa = "wxce6f23b478a3a2a2";
  public static String rUb = "wx7302cee7c7d6d7d6";
  public static String rUc = "wx6fa7e3bab7e15415";
  public static String rUd = "wx3cc22b542de028d4";
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[26];
    locala.columns = new String[27];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.ujN.put("appId", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "appId";
    locala.columns[1] = "appName";
    locala.ujN.put("appName", "TEXT");
    localStringBuilder.append(" appName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "appDiscription";
    locala.ujN.put("appDiscription", "TEXT");
    localStringBuilder.append(" appDiscription TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "appIconUrl";
    locala.ujN.put("appIconUrl", "TEXT");
    localStringBuilder.append(" appIconUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "appStoreUrl";
    locala.ujN.put("appStoreUrl", "TEXT");
    localStringBuilder.append(" appStoreUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "appVersion";
    locala.ujN.put("appVersion", "INTEGER");
    localStringBuilder.append(" appVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "appWatermarkUrl";
    locala.ujN.put("appWatermarkUrl", "TEXT");
    localStringBuilder.append(" appWatermarkUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "packageName";
    locala.ujN.put("packageName", "TEXT");
    localStringBuilder.append(" packageName TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "status";
    locala.ujN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "signature";
    locala.ujN.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "modifyTime";
    locala.ujN.put("modifyTime", "LONG");
    localStringBuilder.append(" modifyTime LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "appName_en";
    locala.ujN.put("appName_en", "TEXT");
    localStringBuilder.append(" appName_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "appName_tw";
    locala.ujN.put("appName_tw", "TEXT");
    localStringBuilder.append(" appName_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "appName_hk";
    locala.ujN.put("appName_hk", "TEXT");
    localStringBuilder.append(" appName_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "appDiscription_en";
    locala.ujN.put("appDiscription_en", "TEXT");
    localStringBuilder.append(" appDiscription_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "appDiscription_tw";
    locala.ujN.put("appDiscription_tw", "TEXT");
    localStringBuilder.append(" appDiscription_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "appType";
    locala.ujN.put("appType", "TEXT");
    localStringBuilder.append(" appType TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "openId";
    locala.ujN.put("openId", "TEXT");
    localStringBuilder.append(" openId TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "authFlag";
    locala.ujN.put("authFlag", "INTEGER");
    localStringBuilder.append(" authFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "appInfoFlag";
    locala.ujN.put("appInfoFlag", "INTEGER default '-1' ");
    localStringBuilder.append(" appInfoFlag INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "lvbuff";
    locala.ujN.put("lvbuff", "BLOB");
    localStringBuilder.append(" lvbuff BLOB");
    localStringBuilder.append(", ");
    locala.columns[21] = "serviceAppType";
    locala.ujN.put("serviceAppType", "INTEGER default '0' ");
    localStringBuilder.append(" serviceAppType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[22] = "serviceAppInfoFlag";
    locala.ujN.put("serviceAppInfoFlag", "INTEGER default '0' ");
    localStringBuilder.append(" serviceAppInfoFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[23] = "serviceShowFlag";
    locala.ujN.put("serviceShowFlag", "INTEGER default '0' ");
    localStringBuilder.append(" serviceShowFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[24] = "appSupportContentType";
    locala.ujN.put("appSupportContentType", "LONG default '0' ");
    localStringBuilder.append(" appSupportContentType LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[25] = "svrAppSupportContentType";
    locala.ujN.put("svrAppSupportContentType", "LONG default '0' ");
    localStringBuilder.append(" svrAppSupportContentType LONG default '0' ");
    locala.columns[26] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public f()
  {
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
    cM("");
    cL("");
    cN("");
    cR("");
    cS("");
    cT("");
  }
  
  public final boolean ZH()
  {
    if (bk.bl(this.field_appType)) {}
    for (;;)
    {
      return false;
      String[] arrayOfString = this.field_appType.split(",");
      if ((arrayOfString != null) && (arrayOfString.length != 0))
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equals("1")) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public final boolean ckN()
  {
    return this.field_serviceAppType != 0;
  }
  
  public final boolean ckO()
  {
    return (this.field_serviceAppInfoFlag & 0x2) != 0;
  }
  
  public final boolean ckP()
  {
    return rUb.equals(this.field_appId);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
    } while (!(paramObject instanceof f));
    return ((f)paramObject).field_appId.equals(this.field_appId);
  }
  
  public int hashCode()
  {
    if (!bk.bl(this.field_appId)) {
      return this.field_appId.hashCode();
    }
    return super.hashCode();
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public final ContentValues vf()
  {
    if ((!bk.bl(this.field_appType)) && ((this.field_appType.startsWith("1")) || (this.field_appType.startsWith("6")))) {
      this.field_appType = ("," + this.field_appType);
    }
    return super.vf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.f
 * JD-Core Version:    0.7.0.1
 */