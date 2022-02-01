package com.tencent.mm.plugin.qmessage.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import junit.framework.Assert;

public final class d
  extends MStorage
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS qcontact ( username text  PRIMARY KEY , qq long  , extinfo text  , needupdate int  , extupdateseq long  , imgupdateseq long  , reserved1 int  , reserved2 int  , reserved3 int  , reserved4 int  , reserved5 text  , reserved6 text  , reserved7 text  , reserved8 text  ) " };
  private h omV;
  
  public d(h paramh)
  {
    this.omV = paramh;
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(27722);
    paramc.eQp = -1;
    paramc = paramc.convertTo();
    if ((int)this.omV.insert("qcontact", "username", paramc) != -1)
    {
      AppMethodBeat.o(27722);
      return true;
    }
    AppMethodBeat.o(27722);
    return false;
  }
  
  public final boolean a(String paramString, c paramc)
  {
    AppMethodBeat.i(27723);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (paramc != null) {
        break;
      }
      AppMethodBeat.o(27723);
      return false;
    }
    if (this.omV.update("qcontact", paramc.convertTo(), "username=?", new String[] { paramString }) > 0)
    {
      AppMethodBeat.o(27723);
      return true;
    }
    AppMethodBeat.o(27723);
    return false;
  }
  
  public final c aSj(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(27724);
    paramString = "select qcontact.username,qcontact.qq,qcontact.extinfo,qcontact.needupdate,qcontact.extupdateseq,qcontact.imgupdateseq,qcontact.reserved1,qcontact.reserved2,qcontact.reserved3,qcontact.reserved4,qcontact.reserved5,qcontact.reserved6,qcontact.reserved7,qcontact.reserved8 from qcontact   where qcontact.username = \"" + Util.escapeSqlValue(String.valueOf(paramString)) + "\"";
    Cursor localCursor = this.omV.rawQuery(paramString, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(27724);
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new c();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(27724);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.model.d
 * JD-Core Version:    0.7.0.1
 */