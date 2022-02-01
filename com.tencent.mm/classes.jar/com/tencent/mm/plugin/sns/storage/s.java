package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.bsl;
import com.tencent.mm.protocal.protobuf.dfy;
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
  public h hHS;
  
  static
  {
    AppMethodBeat.i(97594);
    SQL_CREATE = new String[] { j.getCreateSQLs(r.info, "SnsReportKv") };
    AppMethodBeat.o(97594);
  }
  
  public s(h paramh)
  {
    super(paramh, r.info, "SnsReportKv", r.INDEX_CREATE);
    this.hHS = paramh;
  }
  
  private int a(dfy paramdfy, int paramInt)
  {
    AppMethodBeat.i(97592);
    try
    {
      paramdfy = paramdfy.toByteArray();
      r localr = new r();
      localr.field_value = paramdfy;
      localr.field_logtime = System.currentTimeMillis();
      localr.field_logsize = paramInt;
      localr.field_offset = 0;
      paramdfy = localr.convertTo();
      paramInt = (int)this.hHS.a("SnsReportKv", "", paramdfy);
      ad.d("MicroMsg.SnsKvReportStg", "SnsKvReport Insert result ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(97592);
      return paramInt;
    }
    catch (Exception paramdfy)
    {
      AppMethodBeat.o(97592);
    }
    return 0;
  }
  
  public final int a(dfy paramdfy)
  {
    AppMethodBeat.i(97591);
    dfy localdfy = new dfy();
    int k = 0;
    int i = 0;
    int j = 0;
    if (k < paramdfy.Fuy.size())
    {
      bsl localbsl = (bsl)paramdfy.Fuy.get(k);
      if (localbsl.GNb.zr.length + j > 51200)
      {
        a(localdfy, j);
        i += 1;
        localdfy.Fuy.clear();
        j = 0;
      }
      for (;;)
      {
        k += 1;
        break;
        j += localbsl.GNb.zr.length;
        localdfy.Fuy.add(localbsl);
      }
    }
    k = i;
    if (localdfy.Fuy.size() > 0)
    {
      k = i + 1;
      a(localdfy, j);
    }
    AppMethodBeat.o(97591);
    return k;
  }
  
  public final dfy hK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97593);
    Object localObject = "select rowid, *  from SnsReportKv";
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramInt2 > 0) {
      localObject = "select rowid, *  from SnsReportKv" + " where rowid <= " + paramInt2;
    }
    Cursor localCursor = this.hHS.a((String)localObject, null, 0);
    dfy localdfy = new dfy();
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
      localObject = new dfy();
      for (;;)
      {
        try
        {
          ((dfy)localObject).parseFrom(localr.field_value);
        }
        catch (Exception localException2)
        {
          bsl localbsl;
          continue;
          i = 0;
          continue;
          i = 1;
          continue;
        }
        try
        {
          if (i >= ((dfy)localObject).Fuy.size()) {
            continue;
          }
          localbsl = (bsl)((dfy)localObject).Fuy.get(i);
          if (localbsl.GNb.zr.length + paramInt2 > paramInt1)
          {
            if (paramInt2 != 0) {
              continue;
            }
            localArrayList.add(Integer.valueOf(localr.zMC));
            ad.i("MicroMsg.SnsKvReportStg", "error by server for the mini size " + paramInt1 + " vlauesize " + localbsl.GNb.zr.length);
            continue;
            localStringBuffer.append("|read end on " + localr.zMC + " and get size " + paramInt2);
            if ((i != 0) && (localr.field_offset <= ((dfy)localObject).Fuy.size()))
            {
              update(localr.zMC, localr);
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
            localdfy.Fuy.add(localbsl);
            int j = paramInt2 + localbsl.GNb.zr.length;
            i += 1;
            paramInt2 = j;
            continue;
          }
          localStringBuffer.append("|read full ");
          localArrayList.add(Integer.valueOf(localr.zMC));
          continue;
          if (localCursor.moveToNext()) {
            break;
          }
        }
        catch (Exception localException1)
        {
          ad.printErrStackTrace("MicroMsg.SnsKvReportStg", localException1, "", new Object[0]);
          localArrayList.add(Integer.valueOf(localr.zMC));
          ad.i("MicroMsg.SnsKvReportStg", "error paser then delete " + localr.zMC);
        }
      }
    }
    for (;;)
    {
      break;
    }
    AppMethodBeat.o(97593);
    return localdfy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.s
 * JD-Core Version:    0.7.0.1
 */