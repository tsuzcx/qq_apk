package com.tencent.mm.pluginsdk.h.a.a;

import android.database.Cursor;
import android.database.SQLException;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.k;
import com.tencent.mm.pluginsdk.h.a.a.a.a;
import com.tencent.mm.pluginsdk.h.a.c.q.a;
import com.tencent.mm.pluginsdk.h.a.c.s;
import com.tencent.mm.pluginsdk.h.a.c.t;
import com.tencent.mm.protocal.protobuf.cqd;
import com.tencent.mm.protocal.protobuf.cqh;
import com.tencent.mm.protocal.protobuf.cqi;
import com.tencent.mm.protocal.protobuf.cqj;
import com.tencent.mm.protocal.protobuf.vu;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  protected static final SparseArray<a> Dlm = new SparseArray();
  protected final List<cqj> Dll = new LinkedList();
  private volatile g callback;
  
  n()
  {
    int[] arrayOfInt = i.DkO;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      Object localObject = (a)Dlm.get(k);
      if ((localObject == null) || (!((a)localObject).yi(k)))
      {
        localObject = new cqj();
        ((cqj)localObject).ndI = k;
        this.Dll.add(localObject);
      }
      i += 1;
    }
  }
  
  public static void a(a parama)
  {
    Dlm.put(39, parama);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    this.callback = paramg;
    ac.d(getTag(), "before dispatch");
    try
    {
      Iterator localIterator = this.Dll.iterator();
      if (localIterator.hasNext())
      {
        localcqj = (cqj)localIterator.next();
        i = localcqj.ndI;
        paramg = q.a.eMf();
        if (!paramg.jQO)
        {
          paramg = null;
          if (paramg != null) {
            break label232;
          }
          paramg = Collections.emptyList();
          localObject = new StringBuilder("{ ");
          paramg = paramg.iterator();
          while (paramg.hasNext())
          {
            locals = (s)paramg.next();
            i = bs.getInt(locals.field_fileVersion, -1);
            if (i >= 0)
            {
              cqh localcqh = new cqh();
              localcqh.FvC = locals.field_subType;
              localcqh.FDx = i;
              localcqh.FDv = locals.field_keyVersion;
              localcqh.DkK = locals.field_EID;
              localcqj.FDC.add(localcqh);
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
        cqj localcqj;
        int i;
        s locals;
        ac.e(getTag(), "doScene get SQLException(%s), return -1", new Object[] { parame });
        return -1;
        paramg = paramg.DlU.hpA;
        continue;
        Object localObject = paramg.a("ResDownloaderRecordTable", null, "urlKey" + String.format(Locale.US, " like '%d.%%.data'", new Object[] { Integer.valueOf(i) }) + " and groupId1=" + String.format(Locale.US, "'%s'", new Object[] { "CheckResUpdate" }), null, null, null, null, 2);
        if ((localObject == null) || (((Cursor)localObject).isClosed()))
        {
          paramg = Collections.emptyList();
        }
        else
        {
          if (((Cursor)localObject).moveToFirst())
          {
            paramg = new LinkedList();
            do
            {
              locals = new s();
              locals.convertFrom((Cursor)localObject);
              paramg.add(locals);
            } while (((Cursor)localObject).moveToNext());
          }
          for (;;)
          {
            ((Cursor)localObject).close();
            break;
            paramg = Collections.emptyList();
          }
          ((StringBuilder)localObject).append(" }");
          ac.i(getTag(), "before doScene, add subtypeList(%s) in type(%d)", new Object[] { ((StringBuilder)localObject).toString(), Integer.valueOf(localcqj.ndI) });
        }
      }
      return dispatch(parame, eLX(), this);
    }
    catch (SQLException parame)
    {
      label202:
      label232:
      break label202;
    }
  }
  
  protected abstract com.tencent.mm.network.q eLX();
  
  protected abstract String getTag();
  
  protected abstract vu h(com.tencent.mm.network.q paramq);
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    ac.i(getTag(), "onGYNetEnd errType(%d), errCode(%d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    String str;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = h(paramq);
      str = getTag();
      if (!bs.gY(paramArrayOfByte.Eqg)) {
        break label128;
      }
    }
    label128:
    for (paramq = "null";; paramq = String.valueOf(paramArrayOfByte.Eqg.size()))
    {
      ac.i(str, "response.Res.size() = %s", new Object[] { paramq });
      if (!bs.gY(paramArrayOfByte.Eqg)) {
        b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(152002);
            Iterator localIterator = this.Dln.iterator();
            if (localIterator.hasNext())
            {
              cqi localcqi = (cqi)localIterator.next();
              Object localObject2 = n.this.getTag();
              int i = localcqi.ndI;
              if (bs.gY(localcqi.FDB)) {}
              for (Object localObject1 = "null";; localObject1 = String.valueOf(localcqi.FDB.size()))
              {
                ac.i((String)localObject2, "resType(%d) responses.size() = %s", new Object[] { Integer.valueOf(i), localObject1 });
                if (bs.gY(localcqi.FDB)) {
                  break;
                }
                localObject1 = localcqi.FDB.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (cqd)((Iterator)localObject1).next();
                  n.a(n.this, localcqi.ndI, (cqd)localObject2);
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
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.n
 * JD-Core Version:    0.7.0.1
 */