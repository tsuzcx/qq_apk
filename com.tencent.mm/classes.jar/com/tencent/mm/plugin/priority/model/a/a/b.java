package com.tencent.mm.plugin.priority.model.a.a;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.uc;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  public com.tencent.mm.plugin.priority.model.b vDu;
  
  public b(com.tencent.mm.plugin.priority.model.b paramb)
  {
    AppMethodBeat.i(87820);
    this.vDu = paramb;
    if (this.vDu.ab(65L, 0L) != 7L)
    {
      if (this.vDu.afI("C2CChatUsageResult")) {
        this.vDu.apq("C2CChatUsageResult");
      }
      this.vDu.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, openrmf DOUBLE DEFAULT 0, staytimedev DOUBLE DEFAULT 0,sendmsgrmf DOUBLE DEFAULT 0, consumemsgrmf DOUBLE DEFAULT 0, totallsp DOUBLE DEFAULT 0, rank INTEGER DEFAULT -1, PRIMARY KEY(chat));", new Object[] { "C2CChatUsageResult" }));
      this.vDu.ac(65L, 7L);
      AppMethodBeat.o(87820);
      return;
    }
    ac.i("MicroMsg.Priority.C2CChatUsageResultStorage", "Exist Table %s Count %d", new Object[] { "C2CChatUsageResult", Integer.valueOf(this.vDu.app("C2CChatUsageResult")) });
    AppMethodBeat.o(87820);
  }
  
  public final uc apt(String paramString)
  {
    AppMethodBeat.i(161937);
    Object localObject1 = String.format("SELECT * FROM %s WHERE chat = ?", new Object[] { "C2CChatUsageResult" });
    paramString = this.vDu.rawQuery((String)localObject1, new String[] { paramString });
    try
    {
      if (paramString.moveToNext())
      {
        localObject1 = new uc();
        ((uc)localObject1).Eol = paramString.getString(0);
        ((uc)localObject1).Eom = paramString.getDouble(1);
        ((uc)localObject1).Eon = paramString.getDouble(2);
        ((uc)localObject1).Eoo = paramString.getDouble(3);
        ((uc)localObject1).Eop = paramString.getDouble(4);
        ((uc)localObject1).Eoq = paramString.getDouble(5);
        ((uc)localObject1).tlu = paramString.getInt(6);
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
  
  public final List<Pair<String, String>> doL()
  {
    AppMethodBeat.i(161936);
    Object localObject = String.format("SELECT chat, openrmf, staytimedev, sendmsgrmf, consumemsgrmf, totallsp, rank FROM %s ORDER BY totallsp DESC;", new Object[] { "C2CChatUsageResult" });
    localObject = this.vDu.rawQuery((String)localObject, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.a.b
 * JD-Core Version:    0.7.0.1
 */