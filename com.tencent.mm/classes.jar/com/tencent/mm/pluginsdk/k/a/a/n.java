package com.tencent.mm.pluginsdk.k.a.a;

import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.pluginsdk.k.a.a.a.a;
import com.tencent.mm.pluginsdk.k.a.c.p;
import com.tencent.mm.pluginsdk.k.a.c.p.a;
import com.tencent.mm.pluginsdk.k.a.c.r;
import com.tencent.mm.protocal.protobuf.dyr;
import com.tencent.mm.protocal.protobuf.dyv;
import com.tencent.mm.protocal.protobuf.dyw;
import com.tencent.mm.protocal.protobuf.dyx;
import com.tencent.mm.protocal.protobuf.zm;
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
  extends q
  implements m
{
  protected static final SparseArray<a> Rag = new SparseArray();
  protected final List<dyx> Raf = new LinkedList();
  private volatile com.tencent.mm.an.i callback;
  
  n()
  {
    int[] arrayOfInt = i.QZI;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      Object localObject = (a)Rag.get(k);
      if ((localObject == null) || (!((a)localObject).Gn(k)))
      {
        localObject = new dyx();
        ((dyx)localObject).rWu = k;
        this.Raf.add(localObject);
      }
      i += 1;
    }
  }
  
  public static void a(a parama)
  {
    Rag.put(39, parama);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    this.callback = parami;
    Log.d(getTag(), "before dispatch");
    try
    {
      Iterator localIterator = this.Raf.iterator();
      if (localIterator.hasNext())
      {
        localdyx = (dyx)localIterator.next();
        i = localdyx.rWu;
        parami = p.a.hiK();
        if (!parami.omY)
        {
          parami = null;
          if (parami != null) {
            break label225;
          }
          parami = Collections.emptyList();
          localObject = new StringBuilder("{ ");
          parami = parami.iterator();
          for (;;)
          {
            if (!parami.hasNext()) {
              break label472;
            }
            localr = (r)parami.next();
            i = Util.getInt(localr.field_fileVersion, -1);
            if (i >= 0)
            {
              if (37 != localr.field_resType) {
                break;
              }
              b.hii();
              if (!TextUtils.isEmpty(b.lV(localr.field_resType, localr.field_subType))) {
                break;
              }
              if (i.hir()) {
                b.hii().g(localr.field_resType, localr.field_subType, Util.getInt(localr.field_fileVersion, -1), false);
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
        dyx localdyx;
        int i;
        r localr;
        Log.e(getTag(), "doScene get SQLException(%s), return -1", new Object[] { paramg });
        return -1;
        parami = parami.RaN.lvy;
        continue;
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
              localr = new r();
              localr.convertFrom((Cursor)localObject);
              parami.add(localr);
            } while (((Cursor)localObject).moveToNext());
          }
          for (;;)
          {
            ((Cursor)localObject).close();
            break;
            parami = Collections.emptyList();
          }
          dyv localdyv = new dyv();
          localdyv.TVM = localr.field_subType;
          localdyv.UeB = i;
          localdyv.Uez = localr.field_keyVersion;
          localdyv.QZD = localr.field_EID;
          localdyx.UeH.add(localdyv);
          ((StringBuilder)localObject).append(localr.field_subType).append(", ");
          continue;
          label472:
          ((StringBuilder)localObject).append(" }");
          Log.i(getTag(), "before doScene, add subtypeList(%s) in type(%d)", new Object[] { ((StringBuilder)localObject).toString(), Integer.valueOf(localdyx.rWu) });
        }
      }
      return dispatch(paramg, hiz(), this);
    }
    catch (SQLException paramg)
    {
      label195:
      label225:
      break label195;
    }
  }
  
  protected abstract String getTag();
  
  protected abstract com.tencent.mm.network.s hiz();
  
  protected abstract zm i(com.tencent.mm.network.s params);
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    Log.i(getTag(), "onGYNetEnd errType(%d), errCode(%d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    String str;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = i(params);
      str = getTag();
      if (!Util.isNullOrNil(paramArrayOfByte.SlL)) {
        break label128;
      }
    }
    label128:
    for (params = "null";; params = String.valueOf(paramArrayOfByte.SlL.size()))
    {
      Log.i(str, "response.Res.size() = %s", new Object[] { params });
      if (!Util.isNullOrNil(paramArrayOfByte.SlL)) {
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(152002);
            Iterator localIterator = this.Rah.iterator();
            if (localIterator.hasNext())
            {
              dyw localdyw = (dyw)localIterator.next();
              Object localObject2 = n.this.getTag();
              int i = localdyw.rWu;
              if (Util.isNullOrNil(localdyw.UeG)) {}
              for (Object localObject1 = "null";; localObject1 = String.valueOf(localdyw.UeG.size()))
              {
                Log.i((String)localObject2, "resType(%d) responses.size() = %s", new Object[] { Integer.valueOf(i), localObject1 });
                if (Util.isNullOrNil(localdyw.UeG)) {
                  break;
                }
                localObject1 = localdyw.UeG.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (dyr)((Iterator)localObject1).next();
                  n.a(n.this, localdyw.rWu, (dyr)localObject2);
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
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.a.n
 * JD-Core Version:    0.7.0.1
 */