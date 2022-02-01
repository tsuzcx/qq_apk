package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.protocal.protobuf.ejz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p
  extends MAutoStorage<o>
{
  public static final String[] SQL_CREATE;
  public h lvy;
  
  static
  {
    AppMethodBeat.i(97594);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(o.info, "SnsReportKv") };
    AppMethodBeat.o(97594);
  }
  
  public p(h paramh)
  {
    super(paramh, o.info, "SnsReportKv", o.INDEX_CREATE);
    this.lvy = paramh;
  }
  
  private int a(ejz paramejz, int paramInt)
  {
    AppMethodBeat.i(97592);
    try
    {
      paramejz = paramejz.toByteArray();
      o localo = new o();
      localo.field_value = paramejz;
      localo.field_logtime = System.currentTimeMillis();
      localo.field_logsize = paramInt;
      localo.field_offset = 0;
      paramejz = localo.convertTo();
      paramInt = (int)this.lvy.insert("SnsReportKv", "", paramejz);
      Log.d("MicroMsg.SnsKvReportStg", "SnsKvReport Insert result ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(97592);
      return paramInt;
    }
    catch (Exception paramejz)
    {
      AppMethodBeat.o(97592);
    }
    return 0;
  }
  
  public final int a(ejz paramejz)
  {
    AppMethodBeat.i(97591);
    ejz localejz = new ejz();
    int k = 0;
    int i = 0;
    int j = 0;
    if (k < paramejz.RHT.size())
    {
      cou localcou = (cou)paramejz.RHT.get(k);
      if (localcou.Twz.UH.length + j > 51200)
      {
        a(localejz, j);
        i += 1;
        localejz.RHT.clear();
        j = 0;
      }
      for (;;)
      {
        k += 1;
        break;
        j += localcou.Twz.UH.length;
        localejz.RHT.add(localcou);
      }
    }
    k = i;
    if (localejz.RHT.size() > 0)
    {
      k = i + 1;
      a(localejz, j);
    }
    AppMethodBeat.o(97591);
    return k;
  }
  
  public final ejz jQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97593);
    Object localObject = "select rowid, *  from SnsReportKv";
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramInt2 > 0) {
      localObject = "select rowid, *  from SnsReportKv" + " where rowid <= " + paramInt2;
    }
    Cursor localCursor = this.lvy.rawQuery((String)localObject, null);
    ejz localejz = new ejz();
    ArrayList localArrayList = new ArrayList();
    localStringBuffer.append("target size " + paramInt1 + " current maxcolid " + paramInt2);
    if (localCursor.moveToFirst()) {
      paramInt2 = 0;
    }
    for (;;)
    {
      o localo = new o();
      localo.convertFrom(localCursor);
      i = localo.field_offset;
      localStringBuffer.append("|offset: ".concat(String.valueOf(i)));
      localObject = new ejz();
      for (;;)
      {
        try
        {
          ((ejz)localObject).parseFrom(localo.field_value);
        }
        catch (Exception localException2)
        {
          cou localcou;
          continue;
          i = 0;
          continue;
          i = 1;
          continue;
        }
        try
        {
          if (i >= ((ejz)localObject).RHT.size()) {
            continue;
          }
          localcou = (cou)((ejz)localObject).RHT.get(i);
          if (localcou.Twz.UH.length + paramInt2 > paramInt1)
          {
            if (paramInt2 != 0) {
              continue;
            }
            localArrayList.add(Integer.valueOf(localo.localid));
            Log.i("MicroMsg.SnsKvReportStg", "error by server for the mini size " + paramInt1 + " vlauesize " + localcou.Twz.UH.length);
            continue;
            localStringBuffer.append("|read end on " + localo.localid + " and get size " + paramInt2);
            if ((i != 0) && (localo.field_offset <= ((ejz)localObject).RHT.size()))
            {
              update(localo.localid, localo);
              localStringBuffer.append("|update new offset " + localo.field_offset);
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
            localo.field_offset = (i + 1);
            localejz.RHT.add(localcou);
            int j = paramInt2 + localcou.Twz.UH.length;
            i += 1;
            paramInt2 = j;
            continue;
          }
          localStringBuffer.append("|read full ");
          localArrayList.add(Integer.valueOf(localo.localid));
          continue;
          if (localCursor.moveToNext()) {
            break;
          }
        }
        catch (Exception localException1)
        {
          Log.printErrStackTrace("MicroMsg.SnsKvReportStg", localException1, "", new Object[0]);
          localArrayList.add(Integer.valueOf(localo.localid));
          Log.i("MicroMsg.SnsKvReportStg", "error paser then delete " + localo.localid);
        }
      }
    }
    for (;;)
    {
      break;
    }
    AppMethodBeat.o(97593);
    return localejz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.p
 * JD-Core Version:    0.7.0.1
 */