package com.tencent.mm.pluginsdk.j.a.a;

import android.database.Cursor;
import android.database.SQLException;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.k;
import com.tencent.mm.pluginsdk.j.a.a.a.a;
import com.tencent.mm.pluginsdk.j.a.c.q.a;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.pluginsdk.j.a.c.t;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.cwg;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.protocal.protobuf.cwi;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.wcdb.database.SQLiteException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public abstract class n
  extends com.tencent.mm.ak.n
  implements k
{
  protected static final SparseArray<a> FiJ = new SparseArray();
  protected final List<cwi> FiI = new LinkedList();
  private volatile f callback;
  
  n()
  {
    int[] arrayOfInt = i.Fil;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      Object localObject = (a)FiJ.get(k);
      if ((localObject == null) || (!((a)localObject).zb(k)))
      {
        localObject = new cwi();
        ((cwi)localObject).nJA = k;
        this.FiI.add(localObject);
      }
      i += 1;
    }
  }
  
  public static void a(a parama)
  {
    FiJ.put(39, parama);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    this.callback = paramf;
    ae.d(getTag(), "before dispatch");
    try
    {
      Iterator localIterator = this.FiI.iterator();
      if (localIterator.hasNext())
      {
        localcwi = (cwi)localIterator.next();
        i = localcwi.nJA;
        paramf = q.a.feQ();
        if (!paramf.kot)
        {
          paramf = null;
          if (paramf != null) {
            break label232;
          }
          paramf = Collections.emptyList();
          localObject = new StringBuilder("{ ");
          paramf = paramf.iterator();
          while (paramf.hasNext())
          {
            locals = (s)paramf.next();
            i = bu.getInt(locals.field_fileVersion, -1);
            if (i >= 0)
            {
              cwg localcwg = new cwg();
              localcwg.Hzh = locals.field_subType;
              localcwg.HHk = i;
              localcwg.HHi = locals.field_keyVersion;
              localcwg.Fih = locals.field_EID;
              localcwi.HHp.add(localcwg);
              ((StringBuilder)localObject).append(locals.field_subType).append(", ");
            }
          }
        }
      }
    }
    catch (SQLiteException parame)
    {
      for (;;)
      {
        cwi localcwi;
        int i;
        s locals;
        ae.e(getTag(), "doScene get SQLException(%s), return -1", new Object[] { parame });
        return -1;
        paramf = paramf.Fjr.hKK;
        continue;
        Object localObject = paramf.a("ResDownloaderRecordTable", null, "urlKey" + String.format(Locale.US, " like '%d.%%.data'", new Object[] { Integer.valueOf(i) }) + " and groupId1=" + String.format(Locale.US, "'%s'", new Object[] { "CheckResUpdate" }), null, null, null, null, 2);
        if ((localObject == null) || (((Cursor)localObject).isClosed()))
        {
          paramf = Collections.emptyList();
        }
        else
        {
          if (((Cursor)localObject).moveToFirst())
          {
            paramf = new LinkedList();
            do
            {
              locals = new s();
              locals.convertFrom((Cursor)localObject);
              paramf.add(locals);
            } while (((Cursor)localObject).moveToNext());
          }
          for (;;)
          {
            ((Cursor)localObject).close();
            break;
            paramf = Collections.emptyList();
          }
          ((StringBuilder)localObject).append(" }");
          ae.i(getTag(), "before doScene, add subtypeList(%s) in type(%d)", new Object[] { ((StringBuilder)localObject).toString(), Integer.valueOf(localcwi.nJA) });
        }
      }
      return dispatch(parame, feI(), this);
    }
    catch (SQLException parame)
    {
      label202:
      label232:
      break label202;
    }
  }
  
  protected abstract com.tencent.mm.network.q feI();
  
  protected abstract String getTag();
  
  protected abstract xw h(com.tencent.mm.network.q paramq);
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    ae.i(getTag(), "onGYNetEnd errType(%d), errCode(%d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    String str;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = h(paramq);
      str = getTag();
      if (!bu.ht(paramArrayOfByte.GpQ)) {
        break label128;
      }
    }
    label128:
    for (paramq = "null";; paramq = String.valueOf(paramArrayOfByte.GpQ.size()))
    {
      ae.i(str, "response.Res.size() = %s", new Object[] { paramq });
      if (!bu.ht(paramArrayOfByte.GpQ)) {
        b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(152002);
            Iterator localIterator = this.FiK.iterator();
            if (localIterator.hasNext())
            {
              cwh localcwh = (cwh)localIterator.next();
              Object localObject2 = n.this.getTag();
              int i = localcwh.nJA;
              if (bu.ht(localcwh.HHo)) {}
              for (Object localObject1 = "null";; localObject1 = String.valueOf(localcwh.HHo.size()))
              {
                ae.i((String)localObject2, "resType(%d) responses.size() = %s", new Object[] { Integer.valueOf(i), localObject1 });
                if (bu.ht(localcwh.HHo)) {
                  break;
                }
                localObject1 = localcwh.HHo.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (cwc)((Iterator)localObject1).next();
                  n.a(n.this, localcwh.nJA, (cwc)localObject2);
                }
                break;
              }
            }
            AppMethodBeat.o(152002);
          }
        }, "NetSceneCheckResUpdate-ResponseHandlingThread");
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.n
 * JD-Core Version:    0.7.0.1
 */