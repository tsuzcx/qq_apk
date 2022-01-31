package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class ay
  extends j<ax>
  implements com.tencent.mm.plugin.messenger.foundation.a.a.e
{
  public static final String[] SQL_CREATE;
  private static final String[] yxa;
  public com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(1302);
    SQL_CREATE = new String[] { j.getCreateSQLs(ax.info, "fmessage_msginfo") };
    yxa = new String[] { "CREATE INDEX IF NOT EXISTS  fmessageTalkerIndex ON fmessage_msginfo ( talker )" };
    AppMethodBeat.o(1302);
  }
  
  public ay(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, ax.info, "fmessage_msginfo", yxa);
    this.db = parame;
  }
  
  public final boolean Td(String paramString)
  {
    AppMethodBeat.i(1300);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.FMessageMsgInfoStorage", "deleteByTalker fail, talker is null");
      AppMethodBeat.o(1300);
      return false;
    }
    paramString = "delete from fmessage_msginfo where talker = '" + bo.wC(paramString) + "'";
    boolean bool = this.db.execSQL("fmessage_msginfo", paramString);
    AppMethodBeat.o(1300);
    return bool;
  }
  
  public final ax[] asc(String paramString)
  {
    AppMethodBeat.i(1294);
    ab.d("MicroMsg.FMessageMsgInfoStorage", "getLastFMessageMsgInfo");
    paramString = "select *, rowid from fmessage_msginfo  where talker = '" + bo.wC(paramString) + "' order by createTime DESC limit 3";
    paramString = this.db.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      ax localax = new ax();
      localax.convertFrom(paramString);
      localArrayList.add(localax);
    }
    paramString.close();
    paramString = (ax[])localArrayList.toArray(new ax[localArrayList.size()]);
    AppMethodBeat.o(1294);
    return paramString;
  }
  
  public final ax asd(String paramString)
  {
    AppMethodBeat.i(1295);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.FMessageMsgInfoStorage", "getLastFMsg fail, talker is null");
      AppMethodBeat.o(1295);
      return null;
    }
    paramString = "select * from fmessage_msginfo where talker = '" + bo.wC(paramString) + "' order by createTime DESC limit 1";
    paramString = this.db.a(paramString, null, 2);
    ax localax = new ax();
    if (paramString.moveToFirst()) {
      localax.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(1295);
    return localax;
  }
  
  public final ax ase(String paramString)
  {
    AppMethodBeat.i(1296);
    paramString = eE(paramString, 1);
    if ((paramString != null) && (paramString.length > 0))
    {
      paramString = paramString[0];
      AppMethodBeat.o(1296);
      return paramString;
    }
    AppMethodBeat.o(1296);
    return null;
  }
  
  public final boolean b(ax paramax)
  {
    AppMethodBeat.i(1298);
    if (paramax == null)
    {
      ab.e("MicroMsg.FMessageMsgInfoStorage", "insert fail, fmsgInfo is null");
      AppMethodBeat.o(1298);
      return false;
    }
    if (super.insert(paramax))
    {
      doNotify(paramax.systemRowid);
      AppMethodBeat.o(1298);
      return true;
    }
    AppMethodBeat.o(1298);
    return false;
  }
  
  public final List<ax> bPV()
  {
    AppMethodBeat.i(1299);
    ab.d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, type = 0");
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.db.a("select *, rowid from fmessage_msginfo where type = 0", null, 2);
    while (localCursor.moveToNext())
    {
      ax localax = new ax();
      localax.convertFrom(localCursor);
      localArrayList.add(localax);
    }
    localCursor.close();
    ab.d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, size = " + localArrayList.size());
    AppMethodBeat.o(1299);
    return localArrayList;
  }
  
  public final ax[] eE(String paramString, int paramInt)
  {
    AppMethodBeat.i(1297);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.FMessageMsgInfoStorage", "getLastRecvFMsg fail, talker is null");
      AppMethodBeat.o(1297);
      return null;
    }
    paramString = "select * from fmessage_msginfo where isSend != 1 and talker = '" + bo.wC(paramString) + "' order by createTime DESC limit " + paramInt;
    paramString = this.db.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      ax localax = new ax();
      localax.convertFrom(paramString);
      localArrayList.add(localax);
    }
    paramString.close();
    paramString = (ax[])localArrayList.toArray(new ax[localArrayList.size()]);
    AppMethodBeat.o(1297);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ay
 * JD-Core Version:    0.7.0.1
 */