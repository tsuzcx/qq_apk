package com.tencent.mm.pluginsdk.model.app;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.t;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.Map;

public class f
  extends t
{
  protected static c.a info;
  public static String vKX;
  public static String vKY;
  public static String vKZ;
  public static String vLa;
  
  static
  {
    AppMethodBeat.i(79254);
    vKX = "wxce6f23b478a3a2a2";
    vKY = "wx7302cee7c7d6d7d6";
    vKZ = "wx6fa7e3bab7e15415";
    vLa = "wx3cc22b542de028d4";
    c.a locala = new c.a();
    locala.yrK = new Field[26];
    locala.columns = new String[27];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.yrM.put("appId", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "appId";
    locala.columns[1] = "appName";
    locala.yrM.put("appName", "TEXT");
    localStringBuilder.append(" appName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "appDiscription";
    locala.yrM.put("appDiscription", "TEXT");
    localStringBuilder.append(" appDiscription TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "appIconUrl";
    locala.yrM.put("appIconUrl", "TEXT");
    localStringBuilder.append(" appIconUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "appStoreUrl";
    locala.yrM.put("appStoreUrl", "TEXT");
    localStringBuilder.append(" appStoreUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "appVersion";
    locala.yrM.put("appVersion", "INTEGER");
    localStringBuilder.append(" appVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "appWatermarkUrl";
    locala.yrM.put("appWatermarkUrl", "TEXT");
    localStringBuilder.append(" appWatermarkUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "packageName";
    locala.yrM.put("packageName", "TEXT");
    localStringBuilder.append(" packageName TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "status";
    locala.yrM.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "signature";
    locala.yrM.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "modifyTime";
    locala.yrM.put("modifyTime", "LONG");
    localStringBuilder.append(" modifyTime LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "appName_en";
    locala.yrM.put("appName_en", "TEXT");
    localStringBuilder.append(" appName_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "appName_tw";
    locala.yrM.put("appName_tw", "TEXT");
    localStringBuilder.append(" appName_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "appName_hk";
    locala.yrM.put("appName_hk", "TEXT");
    localStringBuilder.append(" appName_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "appDiscription_en";
    locala.yrM.put("appDiscription_en", "TEXT");
    localStringBuilder.append(" appDiscription_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "appDiscription_tw";
    locala.yrM.put("appDiscription_tw", "TEXT");
    localStringBuilder.append(" appDiscription_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "appType";
    locala.yrM.put("appType", "TEXT");
    localStringBuilder.append(" appType TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "openId";
    locala.yrM.put("openId", "TEXT");
    localStringBuilder.append(" openId TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "authFlag";
    locala.yrM.put("authFlag", "INTEGER");
    localStringBuilder.append(" authFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "appInfoFlag";
    locala.yrM.put("appInfoFlag", "INTEGER default '-1' ");
    localStringBuilder.append(" appInfoFlag INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "lvbuff";
    locala.yrM.put("lvbuff", "BLOB");
    localStringBuilder.append(" lvbuff BLOB");
    localStringBuilder.append(", ");
    locala.columns[21] = "serviceAppType";
    locala.yrM.put("serviceAppType", "INTEGER default '0' ");
    localStringBuilder.append(" serviceAppType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[22] = "serviceAppInfoFlag";
    locala.yrM.put("serviceAppInfoFlag", "INTEGER default '0' ");
    localStringBuilder.append(" serviceAppInfoFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[23] = "serviceShowFlag";
    locala.yrM.put("serviceShowFlag", "INTEGER default '0' ");
    localStringBuilder.append(" serviceShowFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[24] = "appSupportContentType";
    locala.yrM.put("appSupportContentType", "LONG default '0' ");
    localStringBuilder.append(" appSupportContentType LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[25] = "svrAppSupportContentType";
    locala.yrM.put("svrAppSupportContentType", "LONG default '0' ");
    localStringBuilder.append(" svrAppSupportContentType LONG default '0' ");
    locala.columns[26] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(79254);
  }
  
  public f()
  {
    AppMethodBeat.i(79248);
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
    iU("");
    this.djH = "";
    this.dje = true;
    iV("");
    iZ("");
    ja("");
    jb("");
    AppMethodBeat.o(79248);
  }
  
  public ContentValues convertTo()
  {
    AppMethodBeat.i(79251);
    if ((!bo.isNullOrNil(this.field_appType)) && ((this.field_appType.startsWith("1")) || (this.field_appType.startsWith("6")))) {
      this.field_appType = ("," + this.field_appType);
    }
    ContentValues localContentValues = super.convertTo();
    AppMethodBeat.o(79251);
    return localContentValues;
  }
  
  public final boolean dlw()
  {
    return this.field_serviceAppType != 0;
  }
  
  public final boolean dlx()
  {
    return (this.field_serviceAppInfoFlag & 0x2) != 0;
  }
  
  public final boolean dly()
  {
    return (this.field_serviceAppInfoFlag & 0x1) != 0;
  }
  
  public final boolean dlz()
  {
    AppMethodBeat.i(79250);
    if (vKY.equals(this.field_appId))
    {
      AppMethodBeat.o(79250);
      return true;
    }
    AppMethodBeat.o(79250);
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(79252);
    if (paramObject == null)
    {
      AppMethodBeat.o(79252);
      return false;
    }
    if (paramObject == this)
    {
      AppMethodBeat.o(79252);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(79252);
      return false;
    }
    boolean bool = ((f)paramObject).field_appId.equals(this.field_appId);
    AppMethodBeat.o(79252);
    return bool;
  }
  
  public c.a getDBInfo()
  {
    return info;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(79253);
    if (!bo.isNullOrNil(this.field_appId))
    {
      i = this.field_appId.hashCode();
      AppMethodBeat.o(79253);
      return i;
    }
    int i = super.hashCode();
    AppMethodBeat.o(79253);
    return i;
  }
  
  public final boolean vY()
  {
    AppMethodBeat.i(79249);
    if (bo.isNullOrNil(this.field_appType))
    {
      AppMethodBeat.o(79249);
      return false;
    }
    String[] arrayOfString = this.field_appType.split(",");
    if ((arrayOfString == null) || (arrayOfString.length == 0))
    {
      AppMethodBeat.o(79249);
      return false;
    }
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals("1"))
      {
        AppMethodBeat.o(79249);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(79249);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.f
 * JD-Core Version:    0.7.0.1
 */