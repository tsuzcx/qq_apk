package com.tencent.mm.plugin.priority.model.a.a;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.wa;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  public com.tencent.mm.plugin.priority.model.b xao;
  
  public b(com.tencent.mm.plugin.priority.model.b paramb)
  {
    AppMethodBeat.i(87820);
    this.xao = paramb;
    if (this.xao.ac(65L, 0L) != 7L)
    {
      if (this.xao.ale("C2CChatUsageResult")) {
        this.xao.avL("C2CChatUsageResult");
      }
      this.xao.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, openrmf DOUBLE DEFAULT 0, staytimedev DOUBLE DEFAULT 0,sendmsgrmf DOUBLE DEFAULT 0, consumemsgrmf DOUBLE DEFAULT 0, totallsp DOUBLE DEFAULT 0, rank INTEGER DEFAULT -1, PRIMARY KEY(chat));", new Object[] { "C2CChatUsageResult" }));
      this.xao.ad(65L, 7L);
      AppMethodBeat.o(87820);
      return;
    }
    ae.i("MicroMsg.Priority.C2CChatUsageResultStorage", "Exist Table %s Count %d", new Object[] { "C2CChatUsageResult", Integer.valueOf(this.xao.avK("C2CChatUsageResult")) });
    AppMethodBeat.o(87820);
  }
  
  public final wa avO(String paramString)
  {
    AppMethodBeat.i(161937);
    Object localObject1 = String.format("SELECT * FROM %s WHERE chat = ?", new Object[] { "C2CChatUsageResult" });
    paramString = this.xao.rawQuery((String)localObject1, new String[] { paramString });
    try
    {
      if (paramString.moveToNext())
      {
        localObject1 = new wa();
        ((wa)localObject1).GnT = paramString.getString(0);
        ((wa)localObject1).GnU = paramString.getDouble(1);
        ((wa)localObject1).GnV = paramString.getDouble(2);
        ((wa)localObject1).GnW = paramString.getDouble(3);
        ((wa)localObject1).GnX = paramString.getDouble(4);
        ((wa)localObject1).GnY = paramString.getDouble(5);
        ((wa)localObject1).uvb = paramString.getInt(6);
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
  
  public final List<Pair<String, String>> dCE()
  {
    AppMethodBeat.i(161936);
    Object localObject = String.format("SELECT chat, openrmf, staytimedev, sendmsgrmf, consumemsgrmf, totallsp, rank FROM %s ORDER BY totallsp DESC;", new Object[] { "C2CChatUsageResult" });
    localObject = this.xao.rawQuery((String)localObject, null);
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