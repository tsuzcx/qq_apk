package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;

public final class bi
  extends j<bh>
  implements com.tencent.mm.plugin.messenger.foundation.a.a.e
{
  private static final String[] Ipp;
  public static final String[] SQL_CREATE;
  public com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(117170);
    SQL_CREATE = new String[] { j.getCreateSQLs(bh.info, "fmessage_msginfo") };
    Ipp = new String[] { "CREATE INDEX IF NOT EXISTS  fmessageTalkerIndex ON fmessage_msginfo ( talker )" };
    AppMethodBeat.o(117170);
  }
  
  public bi(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, bh.info, "fmessage_msginfo", Ipp);
    this.db = parame;
  }
  
  public final bh[] aTV(String paramString)
  {
    AppMethodBeat.i(117162);
    ad.d("MicroMsg.FMessageMsgInfoStorage", "getLastFMessageMsgInfo");
    paramString = "select *, rowid from fmessage_msginfo  where talker = '" + bt.aQN(paramString) + "' order by createTime DESC limit 3";
    paramString = this.db.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      bh localbh = new bh();
      localbh.convertFrom(paramString);
      localArrayList.add(localbh);
    }
    paramString.close();
    paramString = (bh[])localArrayList.toArray(new bh[localArrayList.size()]);
    AppMethodBeat.o(117162);
    return paramString;
  }
  
  public final bh aTW(String paramString)
  {
    AppMethodBeat.i(117164);
    paramString = go(paramString, 1);
    if ((paramString != null) && (paramString.length > 0))
    {
      paramString = paramString[0];
      AppMethodBeat.o(117164);
      return paramString;
    }
    AppMethodBeat.o(117164);
    return null;
  }
  
  public final bh apM(String paramString)
  {
    AppMethodBeat.i(117163);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.FMessageMsgInfoStorage", "getLastFMsg fail, talker is null");
      AppMethodBeat.o(117163);
      return null;
    }
    paramString = "select * from fmessage_msginfo where talker = '" + bt.aQN(paramString) + "' order by createTime DESC limit 1";
    paramString = this.db.a(paramString, null, 2);
    bh localbh = new bh();
    if (paramString.moveToFirst()) {
      localbh.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117163);
    return localbh;
  }
  
  public final boolean apN(String paramString)
  {
    AppMethodBeat.i(117168);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.FMessageMsgInfoStorage", "deleteByTalker fail, talker is null");
      AppMethodBeat.o(117168);
      return false;
    }
    paramString = "delete from fmessage_msginfo where talker = '" + bt.aQN(paramString) + "'";
    boolean bool = this.db.execSQL("fmessage_msginfo", paramString);
    AppMethodBeat.o(117168);
    return bool;
  }
  
  public final boolean b(bh parambh)
  {
    AppMethodBeat.i(117166);
    if (parambh == null)
    {
      ad.e("MicroMsg.FMessageMsgInfoStorage", "insert fail, fmsgInfo is null");
      AppMethodBeat.o(117166);
      return false;
    }
    if (super.insert(parambh))
    {
      doNotify(parambh.systemRowid);
      AppMethodBeat.o(117166);
      return true;
    }
    AppMethodBeat.o(117166);
    return false;
  }
  
  public final List<bh> dlP()
  {
    AppMethodBeat.i(117167);
    ad.d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, type = 0");
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.db.a("select *, rowid from fmessage_msginfo where type = 0", null, 2);
    while (localCursor.moveToNext())
    {
      bh localbh = new bh();
      localbh.convertFrom(localCursor);
      localArrayList.add(localbh);
    }
    localCursor.close();
    ad.d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, size = " + localArrayList.size());
    AppMethodBeat.o(117167);
    return localArrayList;
  }
  
  public final bh[] go(String paramString, int paramInt)
  {
    AppMethodBeat.i(117165);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.FMessageMsgInfoStorage", "getLastRecvFMsg fail, talker is null");
      AppMethodBeat.o(117165);
      return null;
    }
    paramString = "select * from fmessage_msginfo where isSend != 1 and talker = '" + bt.aQN(paramString) + "' order by createTime DESC limit " + paramInt;
    paramString = this.db.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      bh localbh = new bh();
      localbh.convertFrom(paramString);
      localArrayList.add(localbh);
    }
    paramString.close();
    paramString = (bh[])localArrayList.toArray(new bh[localArrayList.size()]);
    AppMethodBeat.o(117165);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.bi
 * JD-Core Version:    0.7.0.1
 */