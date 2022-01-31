package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.cg.h;
import com.tencent.mm.protocal.protobuf.ayx;
import com.tencent.mm.protocal.protobuf.cec;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
  extends j<p>
{
  public static final String[] SQL_CREATE;
  public h fnw;
  
  static
  {
    AppMethodBeat.i(37975);
    SQL_CREATE = new String[] { j.getCreateSQLs(p.info, "SnsReportKv") };
    AppMethodBeat.o(37975);
  }
  
  public q(h paramh)
  {
    super(paramh, p.info, "SnsReportKv", p.INDEX_CREATE);
    this.fnw = paramh;
  }
  
  private int a(cec paramcec, int paramInt)
  {
    AppMethodBeat.i(37973);
    try
    {
      paramcec = paramcec.toByteArray();
      p localp = new p();
      localp.field_value = paramcec;
      localp.field_logtime = System.currentTimeMillis();
      localp.field_logsize = paramInt;
      localp.field_offset = 0;
      paramcec = localp.convertTo();
      paramInt = (int)this.fnw.a("SnsReportKv", "", paramcec);
      ab.d("MicroMsg.SnsKvReportStg", "SnsKvReport Insert result ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(37973);
      return paramInt;
    }
    catch (Exception paramcec)
    {
      AppMethodBeat.o(37973);
    }
    return 0;
  }
  
  public final int a(cec paramcec)
  {
    AppMethodBeat.i(37972);
    cec localcec = new cec();
    int k = 0;
    int i = 0;
    int j = 0;
    if (k < paramcec.wok.size())
    {
      ayx localayx = (ayx)paramcec.wok.get(k);
      if (localayx.xop.pW.length + j > 51200)
      {
        a(localcec, j);
        i += 1;
        localcec.wok.clear();
        j = 0;
      }
      for (;;)
      {
        k += 1;
        break;
        j += localayx.xop.pW.length;
        localcec.wok.add(localayx);
      }
    }
    k = i;
    if (localcec.wok.size() > 0)
    {
      k = i + 1;
      a(localcec, j);
    }
    AppMethodBeat.o(37972);
    return k;
  }
  
  public final cec fE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37974);
    Object localObject = "select rowid, *  from SnsReportKv";
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramInt2 > 0) {
      localObject = "select rowid, *  from SnsReportKv" + " where rowid <= " + paramInt2;
    }
    Cursor localCursor = this.fnw.a((String)localObject, null, 0);
    cec localcec = new cec();
    ArrayList localArrayList = new ArrayList();
    localStringBuffer.append("target size " + paramInt1 + " current maxcolid " + paramInt2);
    if (localCursor.moveToFirst()) {
      paramInt2 = 0;
    }
    for (;;)
    {
      p localp = new p();
      localp.convertFrom(localCursor);
      i = localp.field_offset;
      localStringBuffer.append("|offset: ".concat(String.valueOf(i)));
      localObject = new cec();
      for (;;)
      {
        try
        {
          ((cec)localObject).parseFrom(localp.field_value);
        }
        catch (Exception localException2)
        {
          ayx localayx;
          continue;
          i = 0;
          continue;
          i = 1;
          continue;
        }
        try
        {
          if (i >= ((cec)localObject).wok.size()) {
            continue;
          }
          localayx = (ayx)((cec)localObject).wok.get(i);
          if (localayx.xop.pW.length + paramInt2 > paramInt1)
          {
            if (paramInt2 != 0) {
              continue;
            }
            localArrayList.add(Integer.valueOf(localp.rCV));
            ab.i("MicroMsg.SnsKvReportStg", "error by server for the mini size " + paramInt1 + " vlauesize " + localayx.xop.pW.length);
            continue;
            localStringBuffer.append("|read end on " + localp.rCV + " and get size " + paramInt2);
            if ((i != 0) && (localp.field_offset <= ((cec)localObject).wok.size()))
            {
              update(localp.rCV, localp);
              localStringBuffer.append("|update new offset " + localp.field_offset);
              if (i == 0) {
                continue;
              }
              ab.i("MicroMsg.SnsKvReportStg", "read info " + localStringBuffer.toString());
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
            localp.field_offset = (i + 1);
            localcec.wok.add(localayx);
            int j = paramInt2 + localayx.xop.pW.length;
            i += 1;
            paramInt2 = j;
            continue;
          }
          localStringBuffer.append("|read full ");
          localArrayList.add(Integer.valueOf(localp.rCV));
          continue;
          if (localCursor.moveToNext()) {
            break;
          }
        }
        catch (Exception localException1)
        {
          ab.printErrStackTrace("MicroMsg.SnsKvReportStg", localException1, "", new Object[0]);
          localArrayList.add(Integer.valueOf(localp.rCV));
          ab.i("MicroMsg.SnsKvReportStg", "error paser then delete " + localp.rCV);
        }
      }
    }
    for (;;)
    {
      break;
    }
    AppMethodBeat.o(37974);
    return localcec;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.q
 * JD-Core Version:    0.7.0.1
 */