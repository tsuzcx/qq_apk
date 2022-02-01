package com.tencent.mm.pluginsdk.model.app;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.z;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public class g
  extends z
{
  public static String XSb;
  public static String XSc;
  public static String XSd;
  public static String XSe;
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(151678);
    XSb = "wxce6f23b478a3a2a2";
    XSc = "wx7302cee7c7d6d7d6";
    XSd = "wx6fa7e3bab7e15415";
    XSe = "wx3cc22b542de028d4";
    info = z.aJm();
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
    AD("");
    AC("");
    AE("");
    AI("");
    AJ("");
    AK("");
    AppMethodBeat.o(151672);
  }
  
  public final boolean aqJ()
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
  
  public final boolean iIs()
  {
    return this.field_serviceAppType != 0;
  }
  
  public final boolean iIt()
  {
    return (this.field_serviceAppInfoFlag & 0x2) != 0;
  }
  
  public final boolean iIu()
  {
    AppMethodBeat.i(151674);
    if (XSc.equals(this.field_appId))
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