package com.tencent.mm.pluginsdk.j.a.a;

import android.database.Cursor;
import android.database.SQLException;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.network.k;
import com.tencent.mm.pluginsdk.j.a.a.a.a;
import com.tencent.mm.pluginsdk.j.a.c.q.a;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.pluginsdk.j.a.c.t;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.protocal.protobuf.cvm;
import com.tencent.mm.protocal.protobuf.cvn;
import com.tencent.mm.protocal.protobuf.cvo;
import com.tencent.mm.protocal.protobuf.xt;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.wcdb.database.SQLiteException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public abstract class n
  extends com.tencent.mm.al.n
  implements k
{
  protected static final SparseArray<a> EQo = new SparseArray();
  protected final List<cvo> EQn = new LinkedList();
  private volatile f callback;
  
  n()
  {
    int[] arrayOfInt = i.EPQ;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      Object localObject = (a)EQo.get(k);
      if ((localObject == null) || (!((a)localObject).yS(k)))
      {
        localObject = new cvo();
        ((cvo)localObject).nEf = k;
        this.EQn.add(localObject);
      }
      i += 1;
    }
  }
  
  public static void a(a parama)
  {
    EQo.put(39, parama);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    this.callback = paramf;
    ad.d(getTag(), "before dispatch");
    try
    {
      Iterator localIterator = this.EQn.iterator();
      if (localIterator.hasNext())
      {
        localcvo = (cvo)localIterator.next();
        i = localcvo.nEf;
        paramf = q.a.fbc();
        if (!paramf.kld)
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
            i = bt.getInt(locals.field_fileVersion, -1);
            if (i >= 0)
            {
              cvm localcvm = new cvm();
              localcvm.HfH = locals.field_subType;
              localcvm.HnK = i;
              localcvm.HnI = locals.field_keyVersion;
              localcvm.EPM = locals.field_EID;
              localcvo.HnP.add(localcvm);
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
        cvo localcvo;
        int i;
        s locals;
        ad.e(getTag(), "doScene get SQLException(%s), return -1", new Object[] { parame });
        return -1;
        paramf = paramf.EQW.hHS;
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
          ad.i(getTag(), "before doScene, add subtypeList(%s) in type(%d)", new Object[] { ((StringBuilder)localObject).toString(), Integer.valueOf(localcvo.nEf) });
        }
      }
      return dispatch(parame, faU(), this);
    }
    catch (SQLException parame)
    {
      label202:
      label232:
      break label202;
    }
  }
  
  protected abstract com.tencent.mm.network.q faU();
  
  protected abstract String getTag();
  
  protected abstract xt h(com.tencent.mm.network.q paramq);
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    ad.i(getTag(), "onGYNetEnd errType(%d), errCode(%d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    String str;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = h(paramq);
      str = getTag();
      if (!bt.hj(paramArrayOfByte.FXr)) {
        break label128;
      }
    }
    label128:
    for (paramq = "null";; paramq = String.valueOf(paramArrayOfByte.FXr.size()))
    {
      ad.i(str, "response.Res.size() = %s", new Object[] { paramq });
      if (!bt.hj(paramArrayOfByte.FXr)) {
        b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(152002);
            Iterator localIterator = this.EQp.iterator();
            if (localIterator.hasNext())
            {
              cvn localcvn = (cvn)localIterator.next();
              Object localObject2 = n.this.getTag();
              int i = localcvn.nEf;
              if (bt.hj(localcvn.HnO)) {}
              for (Object localObject1 = "null";; localObject1 = String.valueOf(localcvn.HnO.size()))
              {
                ad.i((String)localObject2, "resType(%d) responses.size() = %s", new Object[] { Integer.valueOf(i), localObject1 });
                if (bt.hj(localcvn.HnO)) {
                  break;
                }
                localObject1 = localcvn.HnO.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (cvi)((Iterator)localObject1).next();
                  n.a(n.this, localcvn.nEf, (cvi)localObject2);
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