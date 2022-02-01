package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class b
  extends j<a>
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(153157);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "ABTestInfo") };
    AppMethodBeat.o(153157);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "ABTestInfo", null);
    this.db = parame;
  }
  
  public final void B(List<a> paramList, int paramInt)
  {
    AppMethodBeat.i(153151);
    int i = 0;
    long l = bu.aRi();
    this.db.delete("ABTestInfo", String.format(Locale.US, "%s<>0 and %s<%d", new Object[] { "endTime", "endTime", Long.valueOf(l) }), null);
    a locala1;
    if (1 == paramInt)
    {
      locala1 = new a();
      locala1.field_prioritylevel = 1;
      delete(locala1, false, new String[] { "prioritylevel" });
    }
    paramList = paramList.iterator();
    paramInt = i;
    boolean bool;
    if (paramList.hasNext())
    {
      locala1 = (a)paramList.next();
      if ((locala1 == null) || (bu.isNullOrNil(locala1.field_abtestkey)))
      {
        ae.e("MicroMsg.ABTestInfoStorage", "saveIfNecessary, Invalid item");
        bool = false;
        label147:
        if (!bool) {
          break label441;
        }
        paramInt = 1;
      }
    }
    label441:
    for (;;)
    {
      break;
      a locala2 = new a();
      locala2.field_abtestkey = locala1.field_abtestkey;
      if (!super.get(locala2, new String[0]))
      {
        bool = super.insertNotify(locala1, false);
        ae.i("MicroMsg.ABTestInfoStorage", "Inserted: %s, Result: %b", new Object[] { locala1.field_abtestkey, Boolean.valueOf(bool) });
        break label147;
      }
      if (((locala1.field_sequence > locala2.field_sequence) && (locala1.field_prioritylevel == locala2.field_prioritylevel)) || (locala1.field_prioritylevel > locala2.field_prioritylevel))
      {
        bool = super.updateNotify(locala1, false, new String[0]);
        ae.i("MicroMsg.ABTestInfoStorage", "Updated: %s, Result: %b, Seq: %d, %d, PriorityLV: %d, %d", new Object[] { locala1.field_abtestkey, Boolean.valueOf(bool), Long.valueOf(locala2.field_sequence), Long.valueOf(locala1.field_sequence), Integer.valueOf(locala2.field_prioritylevel), Integer.valueOf(locala1.field_prioritylevel) });
        break label147;
      }
      ae.i("MicroMsg.ABTestInfoStorage", "Ignored: %s, Seq: %d, %d, PriorityLV: %d, %d", new Object[] { locala1.field_abtestkey, Long.valueOf(locala2.field_sequence), Long.valueOf(locala1.field_sequence), Integer.valueOf(locala2.field_prioritylevel), Integer.valueOf(locala1.field_prioritylevel) });
      bool = false;
      break label147;
      if (paramInt != 0) {
        doNotify("event_updated");
      }
      AppMethodBeat.o(153151);
      return;
    }
  }
  
  public final a aTG(String paramString)
  {
    AppMethodBeat.i(153153);
    a locala = new a();
    locala.field_abtestkey = paramString;
    boolean bool = super.get(locala, new String[0]);
    if ((bool) && (locala.field_endTime == 0L)) {
      locala.field_endTime = 9223372036854775807L;
    }
    ae.i("MicroMsg.ABTestInfoStorage", "getByLayerId, id: %s, return: %b", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(153153);
    return locala;
  }
  
  public final LinkedList<ahq> fsw()
  {
    AppMethodBeat.i(153152);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = getAll();
    if (localCursor == null)
    {
      AppMethodBeat.o(153152);
      return localLinkedList;
    }
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(153152);
      return localLinkedList;
    }
    a locala = new a();
    for (;;)
    {
      locala.convertFrom(localCursor);
      ahq localahq = new ahq();
      try
      {
        localahq.GuP = bu.getInt(locala.field_expId, 0);
        localahq.priority = locala.field_prioritylevel;
        localLinkedList.add(localahq);
        if (localCursor.moveToNext()) {
          continue;
        }
        localCursor.close();
        AppMethodBeat.o(153152);
        return localLinkedList;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.e("MicroMsg.ABTestInfoStorage", "expId parse failed, %s", new Object[] { locala.field_expId });
        }
      }
    }
  }
  
  public final String fsx()
  {
    AppMethodBeat.i(153156);
    Object localObject = getAll();
    if (localObject == null)
    {
      AppMethodBeat.o(153156);
      return "null cursor!!";
    }
    if (!((Cursor)localObject).moveToFirst())
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(153156);
      return "cursor empty!!";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    a locala = new a();
    do
    {
      localStringBuilder.append("============\n");
      locala.convertFrom((Cursor)localObject);
      localStringBuilder.append("abtestkey = ").append(locala.field_abtestkey).append("\n");
      localStringBuilder.append("sequence = ").append(locala.field_sequence).append("\n");
      localStringBuilder.append("priorityLV = ").append(locala.field_prioritylevel).append("\n");
      localStringBuilder.append("expId = ").append(locala.field_expId).append("\n");
    } while (((Cursor)localObject).moveToNext());
    ((Cursor)localObject).close();
    localObject = localStringBuilder.toString();
    AppMethodBeat.o(153156);
    return localObject;
  }
  
  public final String getExpIdByKey(String paramString)
  {
    AppMethodBeat.i(153155);
    paramString = aTG(paramString);
    if (paramString.isValid())
    {
      if (paramString.field_expId == null)
      {
        AppMethodBeat.o(153155);
        return "";
      }
      paramString = paramString.field_expId;
      AppMethodBeat.o(153155);
      return paramString;
    }
    AppMethodBeat.o(153155);
    return "";
  }
  
  public final int gv(String paramString, int paramInt)
  {
    AppMethodBeat.i(153154);
    paramString = aTG(paramString);
    if (paramString.isValid())
    {
      paramInt = bu.getInt(paramString.field_value, paramInt);
      AppMethodBeat.o(153154);
      return paramInt;
    }
    AppMethodBeat.o(153154);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.b
 * JD-Core Version:    0.7.0.1
 */