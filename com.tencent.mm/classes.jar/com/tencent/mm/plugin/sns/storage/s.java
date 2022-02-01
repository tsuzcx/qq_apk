package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.protocal.protobuf.dgs;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s
  extends j<r>
{
  public static final String[] SQL_CREATE;
  public h hKK;
  
  static
  {
    AppMethodBeat.i(97594);
    SQL_CREATE = new String[] { j.getCreateSQLs(r.info, "SnsReportKv") };
    AppMethodBeat.o(97594);
  }
  
  public s(h paramh)
  {
    super(paramh, r.info, "SnsReportKv", r.INDEX_CREATE);
    this.hKK = paramh;
  }
  
  private int a(dgs paramdgs, int paramInt)
  {
    AppMethodBeat.i(97592);
    try
    {
      paramdgs = paramdgs.toByteArray();
      r localr = new r();
      localr.field_value = paramdgs;
      localr.field_logtime = System.currentTimeMillis();
      localr.field_logsize = paramInt;
      localr.field_offset = 0;
      paramdgs = localr.convertTo();
      paramInt = (int)this.hKK.a("SnsReportKv", "", paramdgs);
      ae.d("MicroMsg.SnsKvReportStg", "SnsKvReport Insert result ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(97592);
      return paramInt;
    }
    catch (Exception paramdgs)
    {
      AppMethodBeat.o(97592);
    }
    return 0;
  }
  
  public final int a(dgs paramdgs)
  {
    AppMethodBeat.i(97591);
    dgs localdgs = new dgs();
    int k = 0;
    int i = 0;
    int j = 0;
    if (k < paramdgs.FMW.size())
    {
      btf localbtf = (btf)paramdgs.FMW.get(k);
      if (localbtf.HgB.zr.length + j > 51200)
      {
        a(localdgs, j);
        i += 1;
        localdgs.FMW.clear();
        j = 0;
      }
      for (;;)
      {
        k += 1;
        break;
        j += localbtf.HgB.zr.length;
        localdgs.FMW.add(localbtf);
      }
    }
    k = i;
    if (localdgs.FMW.size() > 0)
    {
      k = i + 1;
      a(localdgs, j);
    }
    AppMethodBeat.o(97591);
    return k;
  }
  
  public final dgs hN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97593);
    Object localObject = "select rowid, *  from SnsReportKv";
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramInt2 > 0) {
      localObject = "select rowid, *  from SnsReportKv" + " where rowid <= " + paramInt2;
    }
    Cursor localCursor = this.hKK.a((String)localObject, null, 0);
    dgs localdgs = new dgs();
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
      localObject = new dgs();
      for (;;)
      {
        try
        {
          ((dgs)localObject).parseFrom(localr.field_value);
        }
        catch (Exception localException2)
        {
          btf localbtf;
          continue;
          i = 0;
          continue;
          i = 1;
          continue;
        }
        try
        {
          if (i >= ((dgs)localObject).FMW.size()) {
            continue;
          }
          localbtf = (btf)((dgs)localObject).FMW.get(i);
          if (localbtf.HgB.zr.length + paramInt2 > paramInt1)
          {
            if (paramInt2 != 0) {
              continue;
            }
            localArrayList.add(Integer.valueOf(localr.AdJ));
            ae.i("MicroMsg.SnsKvReportStg", "error by server for the mini size " + paramInt1 + " vlauesize " + localbtf.HgB.zr.length);
            continue;
            localStringBuffer.append("|read end on " + localr.AdJ + " and get size " + paramInt2);
            if ((i != 0) && (localr.field_offset <= ((dgs)localObject).FMW.size()))
            {
              update(localr.AdJ, localr);
              localStringBuffer.append("|update new offset " + localr.field_offset);
              if (i == 0) {
                continue;
              }
              ae.i("MicroMsg.SnsKvReportStg", "read info " + localStringBuffer.toString());
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
            localdgs.FMW.add(localbtf);
            int j = paramInt2 + localbtf.HgB.zr.length;
            i += 1;
            paramInt2 = j;
            continue;
          }
          localStringBuffer.append("|read full ");
          localArrayList.add(Integer.valueOf(localr.AdJ));
          continue;
          if (localCursor.moveToNext()) {
            break;
          }
        }
        catch (Exception localException1)
        {
          ae.printErrStackTrace("MicroMsg.SnsKvReportStg", localException1, "", new Object[0]);
          localArrayList.add(Integer.valueOf(localr.AdJ));
          ae.i("MicroMsg.SnsKvReportStg", "error paser then delete " + localr.AdJ);
        }
      }
    }
    for (;;)
    {
      break;
    }
    AppMethodBeat.o(97593);
    return localdgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.s
 * JD-Core Version:    0.7.0.1
 */