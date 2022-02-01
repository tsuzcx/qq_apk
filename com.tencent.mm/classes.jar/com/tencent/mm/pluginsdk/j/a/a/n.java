package com.tencent.mm.pluginsdk.j.a.a;

import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.pluginsdk.j.a.a.a.a;
import com.tencent.mm.pluginsdk.j.a.c.q.a;
import com.tencent.mm.pluginsdk.j.a.c.t;
import com.tencent.mm.protocal.protobuf.dov;
import com.tencent.mm.protocal.protobuf.doz;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.protocal.protobuf.dpb;
import com.tencent.mm.protocal.protobuf.zi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.wcdb.database.SQLiteException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public abstract class n
  extends com.tencent.mm.ak.q
  implements m
{
  protected static final SparseArray<a> JZD = new SparseArray();
  protected final List<dpb> JZC = new LinkedList();
  private volatile com.tencent.mm.ak.i callback;
  
  n()
  {
    int[] arrayOfInt = i.JZf;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      Object localObject = (a)JZD.get(k);
      if ((localObject == null) || (!((a)localObject).CI(k)))
      {
        localObject = new dpb();
        ((dpb)localObject).oUv = k;
        this.JZC.add(localObject);
      }
      i += 1;
    }
  }
  
  public static void a(a parama)
  {
    JZD.put(39, parama);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    this.callback = parami;
    Log.d(getTag(), "before dispatch");
    try
    {
      Iterator localIterator = this.JZC.iterator();
      if (localIterator.hasNext())
      {
        localdpb = (dpb)localIterator.next();
        i = localdpb.oUv;
        parami = q.a.goa();
        if (!parami.lsb)
        {
          parami = null;
          if (parami != null) {
            break label267;
          }
          parami = Collections.emptyList();
          localObject = new StringBuilder("{ ");
          parami = parami.iterator();
          while (parami.hasNext())
          {
            locals = (com.tencent.mm.pluginsdk.j.a.c.s)parami.next();
            i = Util.getInt(locals.field_fileVersion, -1);
            if (i >= 0) {
              if (37 == locals.field_resType)
              {
                b.gnC();
                if (TextUtils.isEmpty(b.kC(locals.field_resType, locals.field_subType))) {}
              }
              else
              {
                doz localdoz = new doz();
                localdoz.MJT = locals.field_subType;
                localdoz.MSu = i;
                localdoz.MSs = locals.field_keyVersion;
                localdoz.JZb = locals.field_EID;
                localdpb.MSA.add(localdoz);
                ((StringBuilder)localObject).append(locals.field_subType).append(", ");
              }
            }
          }
        }
      }
    }
    catch (SQLiteException paramg)
    {
      for (;;)
      {
        dpb localdpb;
        int i;
        com.tencent.mm.pluginsdk.j.a.c.s locals;
        Log.e(getTag(), "doScene get SQLException(%s), return -1", new Object[] { paramg });
        return -1;
        parami = parami.Kak.iFy;
        continue;
        label267:
        Object localObject = parami.query("ResDownloaderRecordTable", null, "urlKey" + String.format(Locale.US, " like '%d.%%.data'", new Object[] { Integer.valueOf(i) }) + " and groupId1=" + String.format(Locale.US, "'%s'", new Object[] { "CheckResUpdate" }), null, null, null, null, 2);
        if ((localObject == null) || (((Cursor)localObject).isClosed()))
        {
          parami = Collections.emptyList();
        }
        else
        {
          if (((Cursor)localObject).moveToFirst())
          {
            parami = new LinkedList();
            do
            {
              locals = new com.tencent.mm.pluginsdk.j.a.c.s();
              locals.convertFrom((Cursor)localObject);
              parami.add(locals);
            } while (((Cursor)localObject).moveToNext());
          }
          for (;;)
          {
            ((Cursor)localObject).close();
            break;
            parami = Collections.emptyList();
          }
          ((StringBuilder)localObject).append(" }");
          Log.i(getTag(), "before doScene, add subtypeList(%s) in type(%d)", new Object[] { ((StringBuilder)localObject).toString(), Integer.valueOf(localdpb.oUv) });
        }
      }
      return dispatch(paramg, gnS(), this);
    }
    catch (SQLException paramg)
    {
      label236:
      break label236;
    }
  }
  
  protected abstract String getTag();
  
  protected abstract com.tencent.mm.network.s gnS();
  
  protected abstract zi h(com.tencent.mm.network.s params);
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    Log.i(getTag(), "onGYNetEnd errType(%d), errCode(%d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    String str;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = h(params);
      str = getTag();
      if (!Util.isNullOrNil(paramArrayOfByte.LkC)) {
        break label128;
      }
    }
    label128:
    for (params = "null";; params = String.valueOf(paramArrayOfByte.LkC.size()))
    {
      Log.i(str, "response.Res.size() = %s", new Object[] { params });
      if (!Util.isNullOrNil(paramArrayOfByte.LkC)) {
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(152002);
            Iterator localIterator = this.JZE.iterator();
            if (localIterator.hasNext())
            {
              dpa localdpa = (dpa)localIterator.next();
              Object localObject2 = n.this.getTag();
              int i = localdpa.oUv;
              if (Util.isNullOrNil(localdpa.MSz)) {}
              for (Object localObject1 = "null";; localObject1 = String.valueOf(localdpa.MSz.size()))
              {
                Log.i((String)localObject2, "resType(%d) responses.size() = %s", new Object[] { Integer.valueOf(i), localObject1 });
                if (Util.isNullOrNil(localdpa.MSz)) {
                  break;
                }
                localObject1 = localdpa.MSz.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (dov)((Iterator)localObject1).next();
                  n.a(n.this, localdpa.oUv, (dov)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.n
 * JD-Core Version:    0.7.0.1
 */