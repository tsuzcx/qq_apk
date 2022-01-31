package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aaj;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class d
  extends j<c>
{
  public static final String[] SQL_CREATE;
  private final e db;
  
  static
  {
    AppMethodBeat.i(118217);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "ABTestItem") };
    AppMethodBeat.o(118217);
  }
  
  public d(e parame)
  {
    super(parame, c.info, "ABTestItem", null);
    this.db = parame;
  }
  
  public final Map<String, c> aqN(String paramString)
  {
    AppMethodBeat.i(118213);
    if (bo.isNullOrNil(paramString)) {}
    for (paramString = null; (paramString == null) || (!paramString.moveToFirst()); paramString = rawQuery(String.format("select * from %s where %s = %s", new Object[] { "ABTestItem", "business", paramString }), new String[0]))
    {
      if (paramString != null) {
        paramString.close();
      }
      paramString = new HashMap(0);
      AppMethodBeat.o(118213);
      return paramString;
    }
    HashMap localHashMap = new HashMap();
    do
    {
      c localc = new c();
      localc.convertFrom(paramString);
      localHashMap.put(localc.field_layerId, localc);
    } while (paramString.moveToNext());
    paramString.close();
    AppMethodBeat.o(118213);
    return localHashMap;
  }
  
  public final LinkedList<aaj> dvL()
  {
    AppMethodBeat.i(118216);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = getAll();
    if ((localCursor == null) || (!localCursor.moveToFirst()))
    {
      AppMethodBeat.o(118216);
      return localLinkedList;
    }
    c localc = new c();
    for (;;)
    {
      localc.convertFrom(localCursor);
      aaj localaaj = new aaj();
      try
      {
        localaaj.wPe = bo.getInt(localc.field_expId, 0);
        localaaj.priority = localc.field_prioritylevel;
        localLinkedList.add(localaaj);
        if (localCursor.moveToNext()) {
          continue;
        }
        localCursor.close();
        AppMethodBeat.o(118216);
        return localLinkedList;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.ABTestStorage", "expId parse failed, %s", new Object[] { localc.field_expId });
        }
      }
    }
  }
  
  public final String dvM()
  {
    AppMethodBeat.i(118215);
    Object localObject = getAll();
    if (localObject == null)
    {
      AppMethodBeat.o(118215);
      return "null cursor!!";
    }
    if (!((Cursor)localObject).moveToFirst())
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(118215);
      return "cursor empty!!";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    c localc = new c();
    do
    {
      localStringBuilder.append("============\n");
      localc.convertFrom((Cursor)localObject);
      localStringBuilder.append("layerId = ").append(localc.field_layerId).append("\n");
      localStringBuilder.append("sequence = ").append(localc.field_sequence).append("\n");
      localStringBuilder.append("priorityLV = ").append(localc.field_prioritylevel).append("\n");
      localStringBuilder.append("expId = ").append(localc.field_expId).append("\n");
    } while (((Cursor)localObject).moveToNext());
    ((Cursor)localObject).close();
    localObject = localStringBuilder.toString();
    AppMethodBeat.o(118215);
    return localObject;
  }
  
  public final c me(String paramString)
  {
    AppMethodBeat.i(118212);
    c localc = new c();
    localc.field_layerId = paramString;
    boolean bool = super.get(localc, new String[0]);
    if ((bool) && (localc.field_endTime == 0L)) {
      localc.field_endTime = 9223372036854775807L;
    }
    ab.i("MicroMsg.ABTestStorage", "getByLayerId, id: %s, return: %b", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(118212);
    return localc;
  }
  
  public final void r(List<c> paramList, int paramInt)
  {
    AppMethodBeat.i(118214);
    int i = 0;
    long l = bo.aox();
    this.db.delete("ABTestItem", String.format(Locale.US, "%s<>0 and %s<%d", new Object[] { "endTime", "endTime", Long.valueOf(l) }), null);
    c localc1;
    if (paramInt == 0)
    {
      localc1 = new c();
      localc1.field_prioritylevel = 1;
      delete(localc1, false, new String[] { "prioritylevel" });
    }
    paramList = paramList.iterator();
    paramInt = i;
    boolean bool;
    if (paramList.hasNext())
    {
      localc1 = (c)paramList.next();
      if ((localc1 == null) || (bo.isNullOrNil(localc1.field_layerId)))
      {
        ab.e("MicroMsg.ABTestStorage", "saveIfNecessary, Invalid item");
        bool = false;
        label147:
        if (!bool) {
          break label445;
        }
        paramInt = 1;
      }
    }
    label445:
    for (;;)
    {
      break;
      c localc2 = new c();
      localc2.field_layerId = localc1.field_layerId;
      if (!super.get(localc2, new String[0]))
      {
        bool = super.insertNotify(localc1, false);
        ab.i("MicroMsg.ABTestStorage", "Inserted: %s, Result: %b", new Object[] { localc1.field_layerId, Boolean.valueOf(bool) });
        break label147;
      }
      if (((localc1.field_sequence > localc2.field_sequence) && (localc1.field_prioritylevel == localc2.field_prioritylevel)) || (localc1.field_prioritylevel > localc2.field_prioritylevel))
      {
        bool = super.updateNotify(localc1, false, new String[0]);
        ab.i("MicroMsg.ABTestStorage", "Updated: %s, Result: %b, Seq: %d, %d, PriorityLV: %d, %d", new Object[] { localc1.field_layerId, Boolean.valueOf(bool), Long.valueOf(localc2.field_sequence), Long.valueOf(localc1.field_sequence), Integer.valueOf(localc2.field_prioritylevel), Integer.valueOf(localc1.field_prioritylevel) });
        break label147;
      }
      ab.i("MicroMsg.ABTestStorage", "Ignored: %s, Seq: %d, %d, PriorityLV: %d, %d", new Object[] { localc1.field_layerId, Long.valueOf(localc2.field_sequence), Long.valueOf(localc1.field_sequence), Integer.valueOf(localc2.field_prioritylevel), Integer.valueOf(localc1.field_prioritylevel) });
      bool = false;
      break label147;
      if (paramInt != 0) {
        doNotify("event_updated");
      }
      AppMethodBeat.o(118214);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.d
 * JD-Core Version:    0.7.0.1
 */