package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class b
  extends i<a>
{
  public static final String[] dXp = { i.a(a.buS, "ABTestInfo") };
  private e dXw;
  
  public b(e parame)
  {
    super(parame, a.buS, "ABTestInfo", null);
    this.dXw = parame;
  }
  
  public final a aaB(String paramString)
  {
    a locala = new a();
    locala.field_abtestkey = paramString;
    boolean bool = super.b(locala, new String[0]);
    if ((bool) && (locala.field_endTime == 0L)) {
      locala.field_endTime = 9223372036854775807L;
    }
    y.i("MicroMsg.ABTestInfoStorage", "getByLayerId, id: %s, return: %b", new Object[] { paramString, Boolean.valueOf(bool) });
    return locala;
  }
  
  public final LinkedList<we> ctp()
  {
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = aAn();
    if (localCursor == null) {
      return localLinkedList;
    }
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      return localLinkedList;
    }
    a locala = new a();
    for (;;)
    {
      locala.d(localCursor);
      we localwe = new we();
      try
      {
        localwe.sQD = bk.getInt(locala.field_expId, 0);
        localwe.priority = locala.field_prioritylevel;
        localLinkedList.add(localwe);
        if (localCursor.moveToNext()) {
          continue;
        }
        localCursor.close();
        return localLinkedList;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.ABTestInfoStorage", "expId parse failed, %s", new Object[] { locala.field_expId });
        }
      }
    }
  }
  
  public final String ctq()
  {
    Cursor localCursor = aAn();
    if (localCursor == null) {
      return "null cursor!!";
    }
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      return "cursor empty!!";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    a locala = new a();
    do
    {
      localStringBuilder.append("============\n");
      locala.d(localCursor);
      localStringBuilder.append("abtestkey = ").append(locala.field_abtestkey).append("\n");
      localStringBuilder.append("sequence = ").append(locala.field_sequence).append("\n");
      localStringBuilder.append("priorityLV = ").append(locala.field_prioritylevel).append("\n");
      localStringBuilder.append("expId = ").append(locala.field_expId).append("\n");
    } while (localCursor.moveToNext());
    localCursor.close();
    return localStringBuilder.toString();
  }
  
  public final int dt(String paramString, int paramInt)
  {
    paramString = aaB(paramString);
    int i = paramInt;
    if (paramString.isValid()) {
      i = bk.getInt(paramString.field_value, paramInt);
    }
    return i;
  }
  
  public final String getExpIdByKey(String paramString)
  {
    paramString = aaB(paramString);
    if (paramString.isValid())
    {
      if (paramString.field_expId == null) {
        return "";
      }
      return paramString.field_expId;
    }
    return "";
  }
  
  public final void k(List<a> paramList, int paramInt)
  {
    int i = 0;
    long l = bk.UX();
    this.dXw.delete("ABTestInfo", String.format(Locale.US, "%s<>0 and %s<%d", new Object[] { "endTime", "endTime", Long.valueOf(l) }), null);
    a locala1;
    if (1 == paramInt)
    {
      locala1 = new a();
      locala1.field_prioritylevel = 1;
      a(locala1, false, new String[] { "prioritylevel" });
    }
    paramList = paramList.iterator();
    paramInt = i;
    boolean bool;
    if (paramList.hasNext())
    {
      locala1 = (a)paramList.next();
      if ((locala1 == null) || (bk.bl(locala1.field_abtestkey)))
      {
        y.e("MicroMsg.ABTestInfoStorage", "saveIfNecessary, Invalid item");
        bool = false;
        label142:
        if (!bool) {
          break label433;
        }
        paramInt = 1;
      }
    }
    label433:
    for (;;)
    {
      break;
      a locala2 = new a();
      locala2.field_abtestkey = locala1.field_abtestkey;
      if (!super.b(locala2, new String[0]))
      {
        bool = super.a(locala1, false);
        y.i("MicroMsg.ABTestInfoStorage", "Inserted: %s, Result: %b", new Object[] { locala1.field_abtestkey, Boolean.valueOf(bool) });
        break label142;
      }
      if (((locala1.field_sequence > locala2.field_sequence) && (locala1.field_prioritylevel == locala2.field_prioritylevel)) || (locala1.field_prioritylevel > locala2.field_prioritylevel))
      {
        bool = super.b(locala1, false, new String[0]);
        y.i("MicroMsg.ABTestInfoStorage", "Updated: %s, Result: %b, Seq: %d, %d, PriorityLV: %d, %d", new Object[] { locala1.field_abtestkey, Boolean.valueOf(bool), Long.valueOf(locala2.field_sequence), Long.valueOf(locala1.field_sequence), Integer.valueOf(locala2.field_prioritylevel), Integer.valueOf(locala1.field_prioritylevel) });
        break label142;
      }
      y.i("MicroMsg.ABTestInfoStorage", "Ignored: %s, Seq: %d, %d, PriorityLV: %d, %d", new Object[] { locala1.field_abtestkey, Long.valueOf(locala2.field_sequence), Long.valueOf(locala1.field_sequence), Integer.valueOf(locala2.field_prioritylevel), Integer.valueOf(locala1.field_prioritylevel) });
      bool = false;
      break label142;
      if (paramInt != 0) {
        aam("event_updated");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.b
 * JD-Core Version:    0.7.0.1
 */