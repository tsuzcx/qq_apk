package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.bv.b;
import com.tencent.mm.cf.h;
import com.tencent.mm.protocal.c.asw;
import com.tencent.mm.protocal.c.btm;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
  extends i<p>
{
  public static final String[] dXp = { i.a(p.buS, "SnsReportKv") };
  public h dXo;
  
  public q(h paramh)
  {
    super(paramh, p.buS, "SnsReportKv", p.cqY);
    this.dXo = paramh;
  }
  
  private int a(btm parambtm, int paramInt)
  {
    try
    {
      parambtm = parambtm.toByteArray();
      p localp = new p();
      localp.field_value = parambtm;
      localp.field_logtime = System.currentTimeMillis();
      localp.field_logsize = paramInt;
      localp.field_offset = 0;
      parambtm = localp.vf();
      paramInt = (int)this.dXo.insert("SnsReportKv", "", parambtm);
      y.d("MicroMsg.SnsKvReportStg", "SnsKvReport Insert result " + paramInt);
      return paramInt;
    }
    catch (Exception parambtm) {}
    return 0;
  }
  
  public final int a(btm parambtm)
  {
    btm localbtm = new btm();
    int k = 0;
    int i = 0;
    int j = 0;
    if (k < parambtm.sve.size())
    {
      asw localasw = (asw)parambtm.sve.get(k);
      if (localasw.tov.oY.length + j > 51200)
      {
        a(localbtm, j);
        i += 1;
        localbtm.sve.clear();
        j = 0;
      }
      for (;;)
      {
        k += 1;
        break;
        j += localasw.tov.oY.length;
        localbtm.sve.add(localasw);
      }
    }
    k = i;
    if (localbtm.sve.size() > 0)
    {
      k = i + 1;
      a(localbtm, j);
    }
    return k;
  }
  
  public final btm dS(int paramInt1, int paramInt2)
  {
    Object localObject = "select rowid, *  from SnsReportKv";
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramInt2 > 0) {
      localObject = "select rowid, *  from SnsReportKv" + " where rowid <= " + paramInt2;
    }
    Cursor localCursor = this.dXo.a((String)localObject, null, 0);
    btm localbtm = new btm();
    ArrayList localArrayList = new ArrayList();
    localStringBuffer.append("target size " + paramInt1 + " current maxcolid " + paramInt2);
    if (localCursor.moveToFirst()) {
      paramInt2 = 0;
    }
    for (;;)
    {
      p localp = new p();
      localp.d(localCursor);
      i = localp.field_offset;
      localStringBuffer.append("|offset: " + i);
      localObject = new btm();
      for (;;)
      {
        try
        {
          ((btm)localObject).aH(localp.field_value);
        }
        catch (Exception localException2)
        {
          asw localasw;
          continue;
          i = 0;
          continue;
          i = 1;
          continue;
        }
        try
        {
          if (i >= ((btm)localObject).sve.size()) {
            continue;
          }
          localasw = (asw)((btm)localObject).sve.get(i);
          if (localasw.tov.oY.length + paramInt2 > paramInt1)
          {
            if (paramInt2 != 0) {
              continue;
            }
            localArrayList.add(Integer.valueOf(localp.oLk));
            y.i("MicroMsg.SnsKvReportStg", "error by server for the mini size " + paramInt1 + " vlauesize " + localasw.tov.oY.length);
            continue;
            localStringBuffer.append("|read end on " + localp.oLk + " and get size " + paramInt2);
            if ((i != 0) && (localp.field_offset <= ((btm)localObject).sve.size()))
            {
              a(localp.oLk, localp);
              localStringBuffer.append("|update new offset " + localp.field_offset);
              if (i == 0) {
                continue;
              }
              y.i("MicroMsg.SnsKvReportStg", "read info " + localStringBuffer.toString());
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
            localbtm.sve.add(localasw);
            int j = paramInt2 + localasw.tov.oY.length;
            i += 1;
            paramInt2 = j;
            continue;
          }
          localStringBuffer.append("|read full ");
          localArrayList.add(Integer.valueOf(localp.oLk));
          continue;
          if (localCursor.moveToNext()) {
            break;
          }
        }
        catch (Exception localException1)
        {
          y.printErrStackTrace("MicroMsg.SnsKvReportStg", localException1, "", new Object[0]);
          localArrayList.add(Integer.valueOf(localp.oLk));
          y.i("MicroMsg.SnsKvReportStg", "error paser then delete " + localp.oLk);
        }
      }
    }
    for (;;)
    {
      break;
    }
    return localbtm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.q
 * JD-Core Version:    0.7.0.1
 */