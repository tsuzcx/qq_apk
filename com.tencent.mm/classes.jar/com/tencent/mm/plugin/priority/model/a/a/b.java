package com.tencent.mm.plugin.priority.model.a.a;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.vx;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  public com.tencent.mm.plugin.priority.model.b wKA;
  
  public b(com.tencent.mm.plugin.priority.model.b paramb)
  {
    AppMethodBeat.i(87820);
    this.wKA = paramb;
    if (this.wKA.ad(65L, 0L) != 7L)
    {
      if (this.wKA.akg("C2CChatUsageResult")) {
        this.wKA.auw("C2CChatUsageResult");
      }
      this.wKA.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, openrmf DOUBLE DEFAULT 0, staytimedev DOUBLE DEFAULT 0,sendmsgrmf DOUBLE DEFAULT 0, consumemsgrmf DOUBLE DEFAULT 0, totallsp DOUBLE DEFAULT 0, rank INTEGER DEFAULT -1, PRIMARY KEY(chat));", new Object[] { "C2CChatUsageResult" }));
      this.wKA.ae(65L, 7L);
      AppMethodBeat.o(87820);
      return;
    }
    ad.i("MicroMsg.Priority.C2CChatUsageResultStorage", "Exist Table %s Count %d", new Object[] { "C2CChatUsageResult", Integer.valueOf(this.wKA.auv("C2CChatUsageResult")) });
    AppMethodBeat.o(87820);
  }
  
  public final vx auz(String paramString)
  {
    AppMethodBeat.i(161937);
    Object localObject1 = String.format("SELECT * FROM %s WHERE chat = ?", new Object[] { "C2CChatUsageResult" });
    paramString = this.wKA.rawQuery((String)localObject1, new String[] { paramString });
    try
    {
      if (paramString.moveToNext())
      {
        localObject1 = new vx();
        ((vx)localObject1).FVu = paramString.getString(0);
        ((vx)localObject1).FVv = paramString.getDouble(1);
        ((vx)localObject1).FVw = paramString.getDouble(2);
        ((vx)localObject1).FVx = paramString.getDouble(3);
        ((vx)localObject1).FVy = paramString.getDouble(4);
        ((vx)localObject1).FVz = paramString.getDouble(5);
        ((vx)localObject1).ujD = paramString.getInt(6);
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
  
  public final List<Pair<String, String>> dzn()
  {
    AppMethodBeat.i(161936);
    Object localObject = String.format("SELECT chat, openrmf, staytimedev, sendmsgrmf, consumemsgrmf, totallsp, rank FROM %s ORDER BY totallsp DESC;", new Object[] { "C2CChatUsageResult" });
    localObject = this.wKA.rawQuery((String)localObject, null);
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