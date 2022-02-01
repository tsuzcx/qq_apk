package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.List;

public final class be
  extends j<bd>
  implements com.tencent.mm.plugin.messenger.foundation.a.a.e
{
  private static final String[] GCW;
  public static final String[] SQL_CREATE;
  public com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(117170);
    SQL_CREATE = new String[] { j.getCreateSQLs(bd.info, "fmessage_msginfo") };
    GCW = new String[] { "CREATE INDEX IF NOT EXISTS  fmessageTalkerIndex ON fmessage_msginfo ( talker )" };
    AppMethodBeat.o(117170);
  }
  
  public be(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, bd.info, "fmessage_msginfo", GCW);
    this.db = parame;
  }
  
  public final bd[] aOe(String paramString)
  {
    AppMethodBeat.i(117162);
    ac.d("MicroMsg.FMessageMsgInfoStorage", "getLastFMessageMsgInfo");
    paramString = "select *, rowid from fmessage_msginfo  where talker = '" + bs.aLh(paramString) + "' order by createTime DESC limit 3";
    paramString = this.db.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      bd localbd = new bd();
      localbd.convertFrom(paramString);
      localArrayList.add(localbd);
    }
    paramString.close();
    paramString = (bd[])localArrayList.toArray(new bd[localArrayList.size()]);
    AppMethodBeat.o(117162);
    return paramString;
  }
  
  public final bd aOf(String paramString)
  {
    AppMethodBeat.i(117164);
    paramString = fR(paramString, 1);
    if ((paramString != null) && (paramString.length > 0))
    {
      paramString = paramString[0];
      AppMethodBeat.o(117164);
      return paramString;
    }
    AppMethodBeat.o(117164);
    return null;
  }
  
  public final bd ala(String paramString)
  {
    AppMethodBeat.i(117163);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.FMessageMsgInfoStorage", "getLastFMsg fail, talker is null");
      AppMethodBeat.o(117163);
      return null;
    }
    paramString = "select * from fmessage_msginfo where talker = '" + bs.aLh(paramString) + "' order by createTime DESC limit 1";
    paramString = this.db.a(paramString, null, 2);
    bd localbd = new bd();
    if (paramString.moveToFirst()) {
      localbd.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117163);
    return localbd;
  }
  
  public final boolean alb(String paramString)
  {
    AppMethodBeat.i(117168);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.FMessageMsgInfoStorage", "deleteByTalker fail, talker is null");
      AppMethodBeat.o(117168);
      return false;
    }
    paramString = "delete from fmessage_msginfo where talker = '" + bs.aLh(paramString) + "'";
    boolean bool = this.db.execSQL("fmessage_msginfo", paramString);
    AppMethodBeat.o(117168);
    return bool;
  }
  
  public final boolean b(bd parambd)
  {
    AppMethodBeat.i(117166);
    if (parambd == null)
    {
      ac.e("MicroMsg.FMessageMsgInfoStorage", "insert fail, fmsgInfo is null");
      AppMethodBeat.o(117166);
      return false;
    }
    if (super.insert(parambd))
    {
      doNotify(parambd.systemRowid);
      AppMethodBeat.o(117166);
      return true;
    }
    AppMethodBeat.o(117166);
    return false;
  }
  
  public final List<bd> dcx()
  {
    AppMethodBeat.i(117167);
    ac.d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, type = 0");
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.db.a("select *, rowid from fmessage_msginfo where type = 0", null, 2);
    while (localCursor.moveToNext())
    {
      bd localbd = new bd();
      localbd.convertFrom(localCursor);
      localArrayList.add(localbd);
    }
    localCursor.close();
    ac.d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, size = " + localArrayList.size());
    AppMethodBeat.o(117167);
    return localArrayList;
  }
  
  public final bd[] fR(String paramString, int paramInt)
  {
    AppMethodBeat.i(117165);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.FMessageMsgInfoStorage", "getLastRecvFMsg fail, talker is null");
      AppMethodBeat.o(117165);
      return null;
    }
    paramString = "select * from fmessage_msginfo where isSend != 1 and talker = '" + bs.aLh(paramString) + "' order by createTime DESC limit " + paramInt;
    paramString = this.db.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      bd localbd = new bd();
      localbd.convertFrom(paramString);
      localArrayList.add(localbd);
    }
    paramString.close();
    paramString = (bd[])localArrayList.toArray(new bd[localArrayList.size()]);
    AppMethodBeat.o(117165);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.be
 * JD-Core Version:    0.7.0.1
 */