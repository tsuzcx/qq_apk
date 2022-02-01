package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;

public final class bb
  extends j<ba>
  implements com.tencent.mm.plugin.messenger.foundation.a.a.e
{
  private static final String[] Ffk;
  public static final String[] SQL_CREATE;
  public com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(117170);
    SQL_CREATE = new String[] { j.getCreateSQLs(ba.info, "fmessage_msginfo") };
    Ffk = new String[] { "CREATE INDEX IF NOT EXISTS  fmessageTalkerIndex ON fmessage_msginfo ( talker )" };
    AppMethodBeat.o(117170);
  }
  
  public bb(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, ba.info, "fmessage_msginfo", Ffk);
    this.db = parame;
  }
  
  public final ba[] aII(String paramString)
  {
    AppMethodBeat.i(117162);
    ad.d("MicroMsg.FMessageMsgInfoStorage", "getLastFMessageMsgInfo");
    paramString = "select *, rowid from fmessage_msginfo  where talker = '" + bt.aFQ(paramString) + "' order by createTime DESC limit 3";
    paramString = this.db.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      ba localba = new ba();
      localba.convertFrom(paramString);
      localArrayList.add(localba);
    }
    paramString.close();
    paramString = (ba[])localArrayList.toArray(new ba[localArrayList.size()]);
    AppMethodBeat.o(117162);
    return paramString;
  }
  
  public final ba aIJ(String paramString)
  {
    AppMethodBeat.i(117164);
    paramString = fN(paramString, 1);
    if ((paramString != null) && (paramString.length > 0))
    {
      paramString = paramString[0];
      AppMethodBeat.o(117164);
      return paramString;
    }
    AppMethodBeat.o(117164);
    return null;
  }
  
  public final ba agg(String paramString)
  {
    AppMethodBeat.i(117163);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.FMessageMsgInfoStorage", "getLastFMsg fail, talker is null");
      AppMethodBeat.o(117163);
      return null;
    }
    paramString = "select * from fmessage_msginfo where talker = '" + bt.aFQ(paramString) + "' order by createTime DESC limit 1";
    paramString = this.db.a(paramString, null, 2);
    ba localba = new ba();
    if (paramString.moveToFirst()) {
      localba.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(117163);
    return localba;
  }
  
  public final boolean agh(String paramString)
  {
    AppMethodBeat.i(117168);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.FMessageMsgInfoStorage", "deleteByTalker fail, talker is null");
      AppMethodBeat.o(117168);
      return false;
    }
    paramString = "delete from fmessage_msginfo where talker = '" + bt.aFQ(paramString) + "'";
    boolean bool = this.db.execSQL("fmessage_msginfo", paramString);
    AppMethodBeat.o(117168);
    return bool;
  }
  
  public final boolean b(ba paramba)
  {
    AppMethodBeat.i(117166);
    if (paramba == null)
    {
      ad.e("MicroMsg.FMessageMsgInfoStorage", "insert fail, fmsgInfo is null");
      AppMethodBeat.o(117166);
      return false;
    }
    if (super.insert(paramba))
    {
      doNotify(paramba.systemRowid);
      AppMethodBeat.o(117166);
      return true;
    }
    AppMethodBeat.o(117166);
    return false;
  }
  
  public final List<ba> cOO()
  {
    AppMethodBeat.i(117167);
    ad.d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, type = 0");
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.db.a("select *, rowid from fmessage_msginfo where type = 0", null, 2);
    while (localCursor.moveToNext())
    {
      ba localba = new ba();
      localba.convertFrom(localCursor);
      localArrayList.add(localba);
    }
    localCursor.close();
    ad.d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, size = " + localArrayList.size());
    AppMethodBeat.o(117167);
    return localArrayList;
  }
  
  public final ba[] fN(String paramString, int paramInt)
  {
    AppMethodBeat.i(117165);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.FMessageMsgInfoStorage", "getLastRecvFMsg fail, talker is null");
      AppMethodBeat.o(117165);
      return null;
    }
    paramString = "select * from fmessage_msginfo where isSend != 1 and talker = '" + bt.aFQ(paramString) + "' order by createTime DESC limit " + paramInt;
    paramString = this.db.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      ba localba = new ba();
      localba.convertFrom(paramString);
      localArrayList.add(localba);
    }
    paramString.close();
    paramString = (ba[])localArrayList.toArray(new ba[localArrayList.size()]);
    AppMethodBeat.o(117165);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.bb
 * JD-Core Version:    0.7.0.1
 */