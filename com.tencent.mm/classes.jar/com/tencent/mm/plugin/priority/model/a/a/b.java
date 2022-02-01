package com.tencent.mm.plugin.priority.model.a.a;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  public com.tencent.mm.plugin.priority.model.b uuB;
  
  public b(com.tencent.mm.plugin.priority.model.b paramb)
  {
    AppMethodBeat.i(87820);
    this.uuB = paramb;
    if (this.uuB.ae(65L, 0L) != 7L)
    {
      if (this.uuB.aaQ("C2CChatUsageResult")) {
        this.uuB.akr("C2CChatUsageResult");
      }
      this.uuB.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, openrmf DOUBLE DEFAULT 0, staytimedev DOUBLE DEFAULT 0,sendmsgrmf DOUBLE DEFAULT 0, consumemsgrmf DOUBLE DEFAULT 0, totallsp DOUBLE DEFAULT 0, rank INTEGER DEFAULT -1, PRIMARY KEY(chat));", new Object[] { "C2CChatUsageResult" }));
      this.uuB.af(65L, 7L);
      AppMethodBeat.o(87820);
      return;
    }
    ad.i("MicroMsg.Priority.C2CChatUsageResultStorage", "Exist Table %s Count %d", new Object[] { "C2CChatUsageResult", Integer.valueOf(this.uuB.akq("C2CChatUsageResult")) });
    AppMethodBeat.o(87820);
  }
  
  public final ts aku(String paramString)
  {
    AppMethodBeat.i(161937);
    Object localObject1 = String.format("SELECT * FROM %s WHERE chat = ?", new Object[] { "C2CChatUsageResult" });
    paramString = this.uuB.rawQuery((String)localObject1, new String[] { paramString });
    try
    {
      if (paramString.moveToNext())
      {
        localObject1 = new ts();
        ((ts)localObject1).CVB = paramString.getString(0);
        ((ts)localObject1).CVC = paramString.getDouble(1);
        ((ts)localObject1).CVD = paramString.getDouble(2);
        ((ts)localObject1).CVE = paramString.getDouble(3);
        ((ts)localObject1).CVF = paramString.getDouble(4);
        ((ts)localObject1).CVG = paramString.getDouble(5);
        ((ts)localObject1).sdA = paramString.getInt(6);
        return localObject1;
      }
      return null;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(161937);
    }
  }
  
  public final List<Pair<String, String>> dbd()
  {
    AppMethodBeat.i(161936);
    Object localObject = String.format("SELECT chat, openrmf, staytimedev, sendmsgrmf, consumemsgrmf, totallsp, rank FROM %s ORDER BY totallsp DESC;", new Object[] { "C2CChatUsageResult" });
    localObject = this.uuB.rawQuery((String)localObject, null);
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (((Cursor)localObject).moveToNext()) {}
      String str;
      return localList;
    }
    finally
    {
      if (localObject != null) {
        ((Cursor)localObject).close();
      }
      AppMethodBeat.o(161936);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.a.b
 * JD-Core Version:    0.7.0.1
 */