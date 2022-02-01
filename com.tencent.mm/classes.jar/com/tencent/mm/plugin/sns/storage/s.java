package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.protocal.protobuf.cuz;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s
  extends j<r>
{
  public static final String[] SQL_CREATE;
  public h gPa;
  
  static
  {
    AppMethodBeat.i(97594);
    SQL_CREATE = new String[] { j.getCreateSQLs(r.info, "SnsReportKv") };
    AppMethodBeat.o(97594);
  }
  
  public s(h paramh)
  {
    super(paramh, r.info, "SnsReportKv", r.INDEX_CREATE);
    this.gPa = paramh;
  }
  
  private int a(cuz paramcuz, int paramInt)
  {
    AppMethodBeat.i(97592);
    try
    {
      paramcuz = paramcuz.toByteArray();
      r localr = new r();
      localr.field_value = paramcuz;
      localr.field_logtime = System.currentTimeMillis();
      localr.field_logsize = paramInt;
      localr.field_offset = 0;
      paramcuz = localr.convertTo();
      paramInt = (int)this.gPa.a("SnsReportKv", "", paramcuz);
      ad.d("MicroMsg.SnsKvReportStg", "SnsKvReport Insert result ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(97592);
      return paramInt;
    }
    catch (Exception paramcuz)
    {
      AppMethodBeat.o(97592);
    }
    return 0;
  }
  
  public final int a(cuz paramcuz)
  {
    AppMethodBeat.i(97591);
    cuz localcuz = new cuz();
    int k = 0;
    int i = 0;
    int j = 0;
    if (k < paramcuz.CwS.size())
    {
      bkf localbkf = (bkf)paramcuz.CwS.get(k);
      if (localbkf.DId.wA.length + j > 51200)
      {
        a(localcuz, j);
        i += 1;
        localcuz.CwS.clear();
        j = 0;
      }
      for (;;)
      {
        k += 1;
        break;
        j += localbkf.DId.wA.length;
        localcuz.CwS.add(localbkf);
      }
    }
    k = i;
    if (localcuz.CwS.size() > 0)
    {
      k = i + 1;
      a(localcuz, j);
    }
    AppMethodBeat.o(97591);
    return k;
  }
  
  public final cuz hk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97593);
    Object localObject = "select rowid, *  from SnsReportKv";
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramInt2 > 0) {
      localObject = "select rowid, *  from SnsReportKv" + " where rowid <= " + paramInt2;
    }
    Cursor localCursor = this.gPa.a((String)localObject, null, 0);
    cuz localcuz = new cuz();
    ArrayList localArrayList = new ArrayList();
    localStringBuffer.append("target size " + paramInt1 + " current maxcolid " + paramInt2);
    if (localCursor.moveToFirst()) {
      paramInt2 = 0;
    }
    for (;;)
    {
      r localr = new r();
      localr.convertFrom(localCursor);
      i = localr.field_offset;
      localStringBuffer.append("|offset: ".concat(String.valueOf(i)));
      localObject = new cuz();
      for (;;)
      {
        try
        {
          ((cuz)localObject).parseFrom(localr.field_value);
        }
        catch (Exception localException2)
        {
          bkf localbkf;
          continue;
          i = 0;
          continue;
          i = 1;
          continue;
        }
        try
        {
          if (i >= ((cuz)localObject).CwS.size()) {
            continue;
          }
          localbkf = (bkf)((cuz)localObject).CwS.get(i);
          if (localbkf.DId.wA.length + paramInt2 > paramInt1)
          {
            if (paramInt2 != 0) {
              continue;
            }
            localArrayList.add(Integer.valueOf(localr.xiB));
            ad.i("MicroMsg.SnsKvReportStg", "error by server for the mini size " + paramInt1 + " vlauesize " + localbkf.DId.wA.length);
            continue;
            localStringBuffer.append("|read end on " + localr.xiB + " and get size " + paramInt2);
            if ((i != 0) && (localr.field_offset <= ((cuz)localObject).CwS.size()))
            {
              update(localr.xiB, localr);
              localStringBuffer.append("|update new offset " + localr.field_offset);
              if (i == 0) {
                continue;
              }
              ad.i("MicroMsg.SnsKvReportStg", "read info " + localStringBuffer.toString());
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
            localr.field_offset = (i + 1);
            localcuz.CwS.add(localbkf);
            int j = paramInt2 + localbkf.DId.wA.length;
            i += 1;
            paramInt2 = j;
            continue;
          }
          localStringBuffer.append("|read full ");
          localArrayList.add(Integer.valueOf(localr.xiB));
          continue;
          if (localCursor.moveToNext()) {
            break;
          }
        }
        catch (Exception localException1)
        {
          ad.printErrStackTrace("MicroMsg.SnsKvReportStg", localException1, "", new Object[0]);
          localArrayList.add(Integer.valueOf(localr.xiB));
          ad.i("MicroMsg.SnsKvReportStg", "error paser then delete " + localr.xiB);
        }
      }
    }
    for (;;)
    {
      break;
    }
    AppMethodBeat.o(97593);
    return localcuz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.s
 * JD-Core Version:    0.7.0.1
 */