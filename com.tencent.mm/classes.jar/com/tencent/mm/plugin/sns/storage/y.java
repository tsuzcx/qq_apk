package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.dfo;
import com.tencent.mm.protocal.protobuf.feh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class y
  extends MAutoStorage<x>
{
  public static final String[] SQL_CREATE;
  public h omV;
  
  static
  {
    AppMethodBeat.i(97594);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(x.info, "SnsReportKv") };
    AppMethodBeat.o(97594);
  }
  
  public y(h paramh)
  {
    super(paramh, x.info, "SnsReportKv", x.INDEX_CREATE);
    this.omV = paramh;
  }
  
  private int a(feh paramfeh, int paramInt)
  {
    AppMethodBeat.i(97592);
    try
    {
      paramfeh = paramfeh.toByteArray();
      x localx = new x();
      localx.field_value = paramfeh;
      localx.field_logtime = System.currentTimeMillis();
      localx.field_logsize = paramInt;
      localx.field_offset = 0;
      paramfeh = localx.convertTo();
      paramInt = (int)this.omV.insert("SnsReportKv", "", paramfeh);
      Log.d("MicroMsg.SnsKvReportStg", "SnsKvReport Insert result ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(97592);
      return paramInt;
    }
    catch (Exception paramfeh)
    {
      AppMethodBeat.o(97592);
    }
    return 0;
  }
  
  public final int a(feh paramfeh)
  {
    AppMethodBeat.i(97591);
    feh localfeh = new feh();
    int k = 0;
    int i = 0;
    int j = 0;
    if (k < paramfeh.YEW.size())
    {
      dfo localdfo = (dfo)paramfeh.YEW.get(k);
      if (localdfo.aaLg.Op.length + j > 51200)
      {
        a(localfeh, j);
        i += 1;
        localfeh.YEW.clear();
        j = 0;
      }
      for (;;)
      {
        k += 1;
        break;
        j += localdfo.aaLg.Op.length;
        localfeh.YEW.add(localdfo);
      }
    }
    k = i;
    if (localfeh.YEW.size() > 0)
    {
      k = i + 1;
      a(localfeh, j);
    }
    AppMethodBeat.o(97591);
    return k;
  }
  
  public final feh lC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97593);
    Object localObject = "select rowid, *  from SnsReportKv";
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramInt2 > 0) {
      localObject = "select rowid, *  from SnsReportKv" + " where rowid <= " + paramInt2;
    }
    Cursor localCursor = this.omV.rawQuery((String)localObject, null);
    feh localfeh = new feh();
    ArrayList localArrayList = new ArrayList();
    localStringBuffer.append("target size " + paramInt1 + " current maxcolid " + paramInt2);
    if (localCursor.moveToFirst()) {
      paramInt2 = 0;
    }
    for (;;)
    {
      x localx = new x();
      localx.convertFrom(localCursor);
      i = localx.field_offset;
      localStringBuffer.append("|offset: ".concat(String.valueOf(i)));
      localObject = new feh();
      for (;;)
      {
        try
        {
          ((feh)localObject).parseFrom(localx.field_value);
        }
        catch (Exception localException2)
        {
          dfo localdfo;
          continue;
          i = 0;
          continue;
          i = 1;
          continue;
        }
        try
        {
          if (i >= ((feh)localObject).YEW.size()) {
            continue;
          }
          localdfo = (dfo)((feh)localObject).YEW.get(i);
          if (localdfo.aaLg.Op.length + paramInt2 > paramInt1)
          {
            if (paramInt2 != 0) {
              continue;
            }
            localArrayList.add(Integer.valueOf(localx.localid));
            Log.i("MicroMsg.SnsKvReportStg", "error by server for the mini size " + paramInt1 + " vlauesize " + localdfo.aaLg.Op.length);
            continue;
            localStringBuffer.append("|read end on " + localx.localid + " and get size " + paramInt2);
            if ((i != 0) && (localx.field_offset <= ((feh)localObject).YEW.size()))
            {
              update(localx.localid, localx);
              localStringBuffer.append("|update new offset " + localx.field_offset);
              if (i == 0) {
                continue;
              }
              Log.i("MicroMsg.SnsKvReportStg", "read info " + localStringBuffer.toString());
              localCursor.close();
              localObject = localArrayList.iterator();
              if (!((Iterator)localObject).hasNext()) {
                continue;
              }
              delete(((Integer)((Iterator)localObject).next()).intValue());
              continue;
            }
          }
          else
          {
            localx.field_offset = (i + 1);
            localfeh.YEW.add(localdfo);
            int j = paramInt2 + localdfo.aaLg.Op.length;
            i += 1;
            paramInt2 = j;
            continue;
          }
          localStringBuffer.append("|read full ");
          localArrayList.add(Integer.valueOf(localx.localid));
          continue;
          if (localCursor.moveToNext()) {
            break;
          }
        }
        catch (Exception localException1)
        {
          Log.printErrStackTrace("MicroMsg.SnsKvReportStg", localException1, "", new Object[0]);
          localArrayList.add(Integer.valueOf(localx.localid));
          Log.i("MicroMsg.SnsKvReportStg", "error paser then delete " + localx.localid);
        }
      }
    }
    for (;;)
    {
      break;
    }
    AppMethodBeat.o(97593);
    return localfeh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.y
 * JD-Core Version:    0.7.0.1
 */