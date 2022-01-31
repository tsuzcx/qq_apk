package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class ca
  extends i<bz>
{
  public static final String[] dXp = { i.a(bz.buS, "UserOpenIdInApp") };
  public e dXw;
  
  public ca(e parame)
  {
    super(parame, bz.buS, "UserOpenIdInApp", null);
    this.dXw = parame;
    parame.gk("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppAppIdUsernameIndex ON UserOpenIdInApp ( appId,username )");
    parame.gk("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppOpenIdIndex ON UserOpenIdInApp ( openId )");
  }
  
  public final boolean a(bz parambz)
  {
    if ((parambz == null) || (bk.bl(parambz.field_appId)) || (bk.bl(parambz.field_openId)) || (bk.bl(parambz.field_username)))
    {
      y.w("MicroMsg.scanner.UserOpenIdInAppStorage", "wrong argument");
      return false;
    }
    ContentValues localContentValues = parambz.vf();
    if (this.dXw.replace("UserOpenIdInApp", bz.buS.ujM, localContentValues) > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.scanner.UserOpenIdInAppStorage", "replace: appId=%s, username=%s, ret=%s ", new Object[] { parambz.field_appId, parambz.field_username, Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public final bz acu(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    Cursor localCursor = this.dXw.a("UserOpenIdInApp", null, "openId=?", new String[] { bk.pl(paramString) }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      y.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with openId:" + paramString);
      localCursor.close();
      return null;
    }
    paramString = new bz();
    paramString.d(localCursor);
    localCursor.close();
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.ca
 * JD-Core Version:    0.7.0.1
 */