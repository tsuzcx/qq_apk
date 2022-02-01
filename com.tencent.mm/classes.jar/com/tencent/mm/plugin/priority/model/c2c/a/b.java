package com.tencent.mm.plugin.priority.model.c2c.a;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.zj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public class b
{
  public com.tencent.mm.plugin.priority.model.b MPs;
  
  public b(com.tencent.mm.plugin.priority.model.b paramb)
  {
    AppMethodBeat.i(87820);
    this.MPs = paramb;
    if (this.MPs.aY(65L, 0L) != 7L)
    {
      if (this.MPs.aDZ("C2CChatUsageResult")) {
        this.MPs.aRI("C2CChatUsageResult");
      }
      this.MPs.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, openrmf DOUBLE DEFAULT 0, staytimedev DOUBLE DEFAULT 0,sendmsgrmf DOUBLE DEFAULT 0, consumemsgrmf DOUBLE DEFAULT 0, totallsp DOUBLE DEFAULT 0, rank INTEGER DEFAULT -1, PRIMARY KEY(chat));", new Object[] { "C2CChatUsageResult" }));
      this.MPs.aZ(65L, 7L);
      AppMethodBeat.o(87820);
      return;
    }
    Log.i("MicroMsg.Priority.C2CChatUsageResultStorage", "Exist Table %s Count %d", new Object[] { "C2CChatUsageResult", Integer.valueOf(this.MPs.aRH("C2CChatUsageResult")) });
    AppMethodBeat.o(87820);
  }
  
  public final zj aRM(String paramString)
  {
    AppMethodBeat.i(161937);
    Object localObject1 = String.format("SELECT * FROM %s WHERE chat = ?", new Object[] { "C2CChatUsageResult" });
    paramString = this.MPs.rawQuery((String)localObject1, new String[] { paramString });
    try
    {
      if (paramString.moveToNext())
      {
        localObject1 = new zj();
        ((zj)localObject1).Zid = paramString.getString(0);
        ((zj)localObject1).Zie = paramString.getDouble(1);
        ((zj)localObject1).Zif = paramString.getDouble(2);
        ((zj)localObject1).Zig = paramString.getDouble(3);
        ((zj)localObject1).Zih = paramString.getDouble(4);
        ((zj)localObject1).Zii = paramString.getDouble(5);
        ((zj)localObject1).ILB = paramString.getInt(6);
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
  
  public final List<Pair<String, String>> gzT()
  {
    AppMethodBeat.i(161936);
    Object localObject = String.format("SELECT chat, openrmf, staytimedev, sendmsgrmf, consumemsgrmf, totallsp, rank FROM %s ORDER BY totallsp DESC;", new Object[] { "C2CChatUsageResult" });
    localObject = this.MPs.rawQuery((String)localObject, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.c2c.a.b
 * JD-Core Version:    0.7.0.1
 */