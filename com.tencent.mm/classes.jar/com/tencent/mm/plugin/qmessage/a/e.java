package com.tencent.mm.plugin.qmessage.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import junit.framework.Assert;

public final class e
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS qcontact ( username text  PRIMARY KEY , qq long  , extinfo text  , needupdate int  , extupdateseq long  , imgupdateseq long  , reserved1 int  , reserved2 int  , reserved3 int  , reserved4 int  , reserved5 text  , reserved6 text  , reserved7 text  , reserved8 text  ) " };
  private h hHS;
  
  public e(h paramh)
  {
    this.hHS = paramh;
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(27722);
    paramd.dDp = -1;
    paramd = paramd.convertTo();
    if ((int)this.hHS.a("qcontact", "username", paramd) != -1)
    {
      AppMethodBeat.o(27722);
      return true;
    }
    AppMethodBeat.o(27722);
    return false;
  }
  
  public final boolean a(String paramString, d paramd)
  {
    AppMethodBeat.i(27723);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (paramd != null) {
        break;
      }
      AppMethodBeat.o(27723);
      return false;
    }
    if (this.hHS.update("qcontact", paramd.convertTo(), "username=?", new String[] { paramString }) > 0)
    {
      AppMethodBeat.o(27723);
      return true;
    }
    AppMethodBeat.o(27723);
    return false;
  }
  
  public final d auT(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(27724);
    paramString = "select qcontact.username,qcontact.qq,qcontact.extinfo,qcontact.needupdate,qcontact.extupdateseq,qcontact.imgupdateseq,qcontact.reserved1,qcontact.reserved2,qcontact.reserved3,qcontact.reserved4,qcontact.reserved5,qcontact.reserved6,qcontact.reserved7,qcontact.reserved8 from qcontact   where qcontact.username = \"" + bt.aQN(String.valueOf(paramString)) + "\"";
    Cursor localCursor = this.hHS.a(paramString, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(27724);
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new d();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(27724);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.e
 * JD-Core Version:    0.7.0.1
 */