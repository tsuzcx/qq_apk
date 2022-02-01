package com.tencent.mm.pluginsdk.model.app;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.y;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.reflect.Field;
import java.util.Map;

public class g
  extends y
{
  public static String Ffa;
  public static String Ffb;
  public static String Ffc;
  public static String Ffd;
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(151678);
    Ffa = "wxce6f23b478a3a2a2";
    Ffb = "wx7302cee7c7d6d7d6";
    Ffc = "wx6fa7e3bab7e15415";
    Ffd = "wx3cc22b542de028d4";
    c.a locala = new c.a();
    locala.IBL = new Field[26];
    locala.columns = new String[27];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.IBN.put("appId", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "appId";
    locala.columns[1] = "appName";
    locala.IBN.put("appName", "TEXT");
    localStringBuilder.append(" appName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "appDiscription";
    locala.IBN.put("appDiscription", "TEXT");
    localStringBuilder.append(" appDiscription TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "appIconUrl";
    locala.IBN.put("appIconUrl", "TEXT");
    localStringBuilder.append(" appIconUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "appStoreUrl";
    locala.IBN.put("appStoreUrl", "TEXT");
    localStringBuilder.append(" appStoreUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "appVersion";
    locala.IBN.put("appVersion", "INTEGER");
    localStringBuilder.append(" appVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "appWatermarkUrl";
    locala.IBN.put("appWatermarkUrl", "TEXT");
    localStringBuilder.append(" appWatermarkUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "packageName";
    locala.IBN.put("packageName", "TEXT");
    localStringBuilder.append(" packageName TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "status";
    locala.IBN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "signature";
    locala.IBN.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "modifyTime";
    locala.IBN.put("modifyTime", "LONG");
    localStringBuilder.append(" modifyTime LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "appName_en";
    locala.IBN.put("appName_en", "TEXT");
    localStringBuilder.append(" appName_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "appName_tw";
    locala.IBN.put("appName_tw", "TEXT");
    localStringBuilder.append(" appName_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "appName_hk";
    locala.IBN.put("appName_hk", "TEXT");
    localStringBuilder.append(" appName_hk TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "appDiscription_en";
    locala.IBN.put("appDiscription_en", "TEXT");
    localStringBuilder.append(" appDiscription_en TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "appDiscription_tw";
    locala.IBN.put("appDiscription_tw", "TEXT");
    localStringBuilder.append(" appDiscription_tw TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "appType";
    locala.IBN.put("appType", "TEXT");
    localStringBuilder.append(" appType TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "openId";
    locala.IBN.put("openId", "TEXT");
    localStringBuilder.append(" openId TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "authFlag";
    locala.IBN.put("authFlag", "INTEGER");
    localStringBuilder.append(" authFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "appInfoFlag";
    locala.IBN.put("appInfoFlag", "INTEGER default '-1' ");
    localStringBuilder.append(" appInfoFlag INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "lvbuff";
    locala.IBN.put("lvbuff", "BLOB");
    localStringBuilder.append(" lvbuff BLOB");
    localStringBuilder.append(", ");
    locala.columns[21] = "serviceAppType";
    locala.IBN.put("serviceAppType", "INTEGER default '0' ");
    localStringBuilder.append(" serviceAppType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[22] = "serviceAppInfoFlag";
    locala.IBN.put("serviceAppInfoFlag", "INTEGER default '0' ");
    localStringBuilder.append(" serviceAppInfoFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[23] = "serviceShowFlag";
    locala.IBN.put("serviceShowFlag", "INTEGER default '0' ");
    localStringBuilder.append(" serviceShowFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[24] = "appSupportContentType";
    locala.IBN.put("appSupportContentType", "LONG default '0' ");
    localStringBuilder.append(" appSupportContentType LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[25] = "svrAppSupportContentType";
    locala.IBN.put("svrAppSupportContentType", "LONG default '0' ");
    localStringBuilder.append(" svrAppSupportContentType LONG default '0' ");
    locala.columns[26] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
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
    sT("");
    this.eJa = "";
    this.eIy = true;
    sU("");
    sY("");
    sZ("");
    ta("");
    AppMethodBeat.o(151672);
  }
  
  public final boolean Ee()
  {
    AppMethodBeat.i(151673);
    if (bu.isNullOrNil(this.field_appType))
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
    if ((!bu.isNullOrNil(this.field_appType)) && ((this.field_appType.startsWith("1")) || (this.field_appType.startsWith("6")))) {
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
  
  public final boolean fdF()
  {
    return this.field_serviceAppType != 0;
  }
  
  public final boolean fdG()
  {
    return (this.field_serviceAppInfoFlag & 0x2) != 0;
  }
  
  public final boolean fdH()
  {
    return (this.field_serviceAppInfoFlag & 0x1) != 0;
  }
  
  public final boolean fdI()
  {
    AppMethodBeat.i(151674);
    if (Ffb.equals(this.field_appId))
    {
      AppMethodBeat.o(151674);
      return true;
    }
    AppMethodBeat.o(151674);
    return false;
  }
  
  public c.a getDBInfo()
  {
    return info;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(151677);
    if (!bu.isNullOrNil(this.field_appId))
    {
      i = this.field_appId.hashCode();
      AppMethodBeat.o(151677);
      return i;
    }
    int i = super.hashCode();
    AppMethodBeat.o(151677);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.g
 * JD-Core Version:    0.7.0.1
 */