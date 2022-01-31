package com.tencent.mm.plugin.qmessage.a;

import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bk;
import junit.framework.Assert;

public final class e
  extends j
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS qcontact ( username text  PRIMARY KEY , qq long  , extinfo text  , needupdate int  , extupdateseq long  , imgupdateseq long  , reserved1 int  , reserved2 int  , reserved3 int  , reserved4 int  , reserved5 text  , reserved6 text  , reserved7 text  , reserved8 text  ) " };
  private h dXo;
  
  public e(h paramh)
  {
    this.dXo = paramh;
  }
  
  public final d Lc(String paramString)
  {
    Object localObject = null;
    paramString = "select qcontact.username,qcontact.qq,qcontact.extinfo,qcontact.needupdate,qcontact.extupdateseq,qcontact.imgupdateseq,qcontact.reserved1,qcontact.reserved2,qcontact.reserved3,qcontact.reserved4,qcontact.reserved5,qcontact.reserved6,qcontact.reserved7,qcontact.reserved8 from qcontact   where qcontact.username = \"" + bk.pl(paramString) + "\"";
    Cursor localCursor = this.dXo.a(paramString, null, 2);
    if (localCursor == null) {
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new d();
      paramString.username = localCursor.getString(0);
      paramString.fgW = localCursor.getLong(1);
      paramString.extInfo = localCursor.getString(2);
      paramString.ncu = localCursor.getInt(3);
      paramString.ncv = localCursor.getLong(4);
      paramString.ncw = localCursor.getLong(5);
      paramString.dXk = localCursor.getInt(6);
      paramString.emn = localCursor.getInt(7);
      paramString.ebP = localCursor.getInt(8);
      paramString.ebQ = localCursor.getInt(9);
      paramString.ncx = localCursor.getString(10);
      paramString.ncy = localCursor.getString(11);
      paramString.ncz = localCursor.getString(12);
      paramString.ncA = localCursor.getString(13);
    }
    localCursor.close();
    return paramString;
  }
  
  public final boolean a(d paramd)
  {
    paramd.bcw = -1;
    paramd = paramd.vf();
    return (int)this.dXo.insert("qcontact", "username", paramd) != -1;
  }
  
  public final boolean a(String paramString, d paramd)
  {
    boolean bool;
    if ((paramString != null) && (paramString.length() > 0))
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramd != null) {
        break label28;
      }
    }
    label28:
    while (this.dXo.update("qcontact", paramd.vf(), "username=?", new String[] { paramString }) <= 0)
    {
      return false;
      bool = false;
      break;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.e
 * JD-Core Version:    0.7.0.1
 */