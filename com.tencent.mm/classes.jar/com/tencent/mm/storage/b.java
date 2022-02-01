package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.alf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class b
  extends MAutoStorage<a>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(153157);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.info, "ABTestInfo") };
    AppMethodBeat.o(153157);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.info, "ABTestInfo", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final void I(List<a> paramList, int paramInt)
  {
    AppMethodBeat.i(153151);
    int i = 0;
    long l = Util.nowSecond();
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
      if ((locala1 == null) || (Util.isNullOrNil(locala1.field_abtestkey)))
      {
        Log.e("MicroMsg.ABTestInfoStorage", "saveIfNecessary, Invalid item");
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
        Log.i("MicroMsg.ABTestInfoStorage", "Inserted: %s, Result: %b", new Object[] { locala1.field_abtestkey, Boolean.valueOf(bool) });
        break label147;
      }
      if (((locala1.field_sequence > locala2.field_sequence) && (locala1.field_prioritylevel == locala2.field_prioritylevel)) || (locala1.field_prioritylevel > locala2.field_prioritylevel))
      {
        bool = super.updateNotify(locala1, false, new String[0]);
        Log.i("MicroMsg.ABTestInfoStorage", "Updated: %s, Result: %b, Seq: %d, %d, PriorityLV: %d, %d", new Object[] { locala1.field_abtestkey, Boolean.valueOf(bool), Long.valueOf(locala2.field_sequence), Long.valueOf(locala1.field_sequence), Integer.valueOf(locala2.field_prioritylevel), Integer.valueOf(locala1.field_prioritylevel) });
        break label147;
      }
      Log.i("MicroMsg.ABTestInfoStorage", "Ignored: %s, Seq: %d, %d, PriorityLV: %d, %d", new Object[] { locala1.field_abtestkey, Long.valueOf(locala2.field_sequence), Long.valueOf(locala1.field_sequence), Integer.valueOf(locala2.field_prioritylevel), Integer.valueOf(locala1.field_prioritylevel) });
      bool = false;
      break label147;
      if (paramInt != 0) {
        doNotify("event_updated");
      }
      AppMethodBeat.o(153151);
      return;
    }
  }
  
  public final a buS(String paramString)
  {
    AppMethodBeat.i(153153);
    a locala = new a();
    locala.field_abtestkey = paramString;
    boolean bool = super.get(locala, new String[0]);
    if ((bool) && (locala.field_endTime == 0L)) {
      locala.field_endTime = 9223372036854775807L;
    }
    Log.i("MicroMsg.ABTestInfoStorage", "getByLayerId, id: %s, return: %b", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(153153);
    return locala;
  }
  
  public final int buT(String paramString)
  {
    AppMethodBeat.i(191035);
    paramString = buS(paramString);
    if (paramString.isValid())
    {
      int i = Util.getInt(paramString.field_value, 0);
      AppMethodBeat.o(191035);
      return i;
    }
    AppMethodBeat.o(191035);
    return 0;
  }
  
  public final String buU(String paramString)
  {
    AppMethodBeat.i(153155);
    paramString = buS(paramString);
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
  
  public final LinkedList<alf> hvx()
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
      alf localalf = new alf();
      try
      {
        localalf.SrR = Util.getInt(locala.field_expId, 0);
        localalf.priority = locala.field_prioritylevel;
        localLinkedList.add(localalf);
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
          Log.e("MicroMsg.ABTestInfoStorage", "expId parse failed, %s", new Object[] { locala.field_expId });
        }
      }
    }
  }
  
  public final String hvy()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.b
 * JD-Core Version:    0.7.0.1
 */