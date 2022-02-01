package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.bnz;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s
  extends j<r>
{
  public static final String[] SQL_CREATE;
  public h hpA;
  
  static
  {
    AppMethodBeat.i(97594);
    SQL_CREATE = new String[] { j.getCreateSQLs(r.info, "SnsReportKv") };
    AppMethodBeat.o(97594);
  }
  
  public s(h paramh)
  {
    super(paramh, r.info, "SnsReportKv", r.INDEX_CREATE);
    this.hpA = paramh;
  }
  
  private int a(dal paramdal, int paramInt)
  {
    AppMethodBeat.i(97592);
    try
    {
      paramdal = paramdal.toByteArray();
      r localr = new r();
      localr.field_value = paramdal;
      localr.field_logtime = System.currentTimeMillis();
      localr.field_logsize = paramInt;
      localr.field_offset = 0;
      paramdal = localr.convertTo();
      paramInt = (int)this.hpA.a("SnsReportKv", "", paramdal);
      ac.d("MicroMsg.SnsKvReportStg", "SnsKvReport Insert result ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(97592);
      return paramInt;
    }
    catch (Exception paramdal)
    {
      AppMethodBeat.o(97592);
    }
    return 0;
  }
  
  public final int a(dal paramdal)
  {
    AppMethodBeat.i(97591);
    dal localdal = new dal();
    int k = 0;
    int i = 0;
    int j = 0;
    if (k < paramdal.DPo.size())
    {
      bnz localbnz = (bnz)paramdal.DPo.get(k);
      if (localbnz.Fdy.xy.length + j > 51200)
      {
        a(localdal, j);
        i += 1;
        localdal.DPo.clear();
        j = 0;
      }
      for (;;)
      {
        k += 1;
        break;
        j += localbnz.Fdy.xy.length;
        localdal.DPo.add(localbnz);
      }
    }
    k = i;
    if (localdal.DPo.size() > 0)
    {
      k = i + 1;
      a(localdal, j);
    }
    AppMethodBeat.o(97591);
    return k;
  }
  
  public final dal ht(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97593);
    Object localObject = "select rowid, *  from SnsReportKv";
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramInt2 > 0) {
      localObject = "select rowid, *  from SnsReportKv" + " where rowid <= " + paramInt2;
    }
    Cursor localCursor = this.hpA.a((String)localObject, null, 0);
    dal localdal = new dal();
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
      localObject = new dal();
      for (;;)
      {
        try
        {
          ((dal)localObject).parseFrom(localr.field_value);
        }
        catch (Exception localException2)
        {
          bnz localbnz;
          continue;
          i = 0;
          continue;
          i = 1;
          continue;
        }
        try
        {
          if (i >= ((dal)localObject).DPo.size()) {
            continue;
          }
          localbnz = (bnz)((dal)localObject).DPo.get(i);
          if (localbnz.Fdy.xy.length + paramInt2 > paramInt1)
          {
            if (paramInt2 != 0) {
              continue;
            }
            localArrayList.add(Integer.valueOf(localr.yvp));
            ac.i("MicroMsg.SnsKvReportStg", "error by server for the mini size " + paramInt1 + " vlauesize " + localbnz.Fdy.xy.length);
            continue;
            localStringBuffer.append("|read end on " + localr.yvp + " and get size " + paramInt2);
            if ((i != 0) && (localr.field_offset <= ((dal)localObject).DPo.size()))
            {
              update(localr.yvp, localr);
              localStringBuffer.append("|update new offset " + localr.field_offset);
              if (i == 0) {
                continue;
              }
              ac.i("MicroMsg.SnsKvReportStg", "read info " + localStringBuffer.toString());
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
            localdal.DPo.add(localbnz);
            int j = paramInt2 + localbnz.Fdy.xy.length;
            i += 1;
            paramInt2 = j;
            continue;
          }
          localStringBuffer.append("|read full ");
          localArrayList.add(Integer.valueOf(localr.yvp));
          continue;
          if (localCursor.moveToNext()) {
            break;
          }
        }
        catch (Exception localException1)
        {
          ac.printErrStackTrace("MicroMsg.SnsKvReportStg", localException1, "", new Object[0]);
          localArrayList.add(Integer.valueOf(localr.yvp));
          ac.i("MicroMsg.SnsKvReportStg", "error paser then delete " + localr.yvp);
        }
      }
    }
    for (;;)
    {
      break;
    }
    AppMethodBeat.o(97593);
    return localdal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.s
 * JD-Core Version:    0.7.0.1
 */