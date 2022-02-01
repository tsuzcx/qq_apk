package com.tencent.mm.pluginsdk.res.downloader.checkresupdate;

import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.pluginsdk.res.downloader.checkresupdate.a.a;
import com.tencent.mm.pluginsdk.res.downloader.model.p.a;
import com.tencent.mm.pluginsdk.res.downloader.model.r;
import com.tencent.mm.protocal.protobuf.abj;
import com.tencent.mm.protocal.protobuf.erv;
import com.tencent.mm.protocal.protobuf.erz;
import com.tencent.mm.protocal.protobuf.esa;
import com.tencent.mm.protocal.protobuf.esb;
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
  extends com.tencent.mm.am.p
  implements m
{
  protected static final SparseArray<a> XWk = new SparseArray();
  protected final List<esb> XWj = new LinkedList();
  private volatile h callback;
  
  n()
  {
    int[] arrayOfInt = i.XVM;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      Object localObject = (a)XWk.get(k);
      if ((localObject == null) || (!((a)localObject).GM(k)))
      {
        localObject = new esb();
        ((esb)localObject).vhJ = k;
        this.XWj.add(localObject);
      }
      i += 1;
    }
  }
  
  public static void a(a parama)
  {
    XWk.put(39, parama);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    this.callback = paramh;
    Log.d(getTag(), "before dispatch");
    try
    {
      Iterator localIterator = this.XWj.iterator();
      if (localIterator.hasNext())
      {
        localesb = (esb)localIterator.next();
        i = localesb.vhJ;
        paramh = p.a.iJK();
        if (!paramh.rqI)
        {
          paramh = null;
          if (paramh != null) {
            break label225;
          }
          paramh = Collections.emptyList();
          localObject = new StringBuilder("{ ");
          paramh = paramh.iterator();
          for (;;)
          {
            if (!paramh.hasNext()) {
              break label611;
            }
            localr = (r)paramh.next();
            i = Util.getInt(localr.field_fileVersion, -1);
            if (i >= 0)
            {
              if (37 != localr.field_resType) {
                break;
              }
              b.iJf();
              if (!TextUtils.isEmpty(b.nK(localr.field_resType, localr.field_subType))) {
                break;
              }
              if (i.iJq()) {
                b.iJf().f(localr.field_resType, localr.field_subType, Util.getInt(localr.field_fileVersion, -1), false);
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
        esb localesb;
        int i;
        r localr;
        Log.e(getTag(), "doScene get SQLException(%s), return -1", new Object[] { paramg });
        return -1;
        paramh = paramh.XWT.omV;
        continue;
        Object localObject = paramh.query("ResDownloaderRecordTable", null, "urlKey" + String.format(Locale.US, " like '%d.%%.data'", new Object[] { Integer.valueOf(i) }) + " and groupId1=" + String.format(Locale.US, "'%s'", new Object[] { "CheckResUpdate" }), null, null, null, null, 2);
        if ((localObject == null) || (((Cursor)localObject).isClosed()))
        {
          paramh = Collections.emptyList();
        }
        else
        {
          if (((Cursor)localObject).moveToFirst())
          {
            paramh = new LinkedList();
            do
            {
              localr = new r();
              localr.convertFrom((Cursor)localObject);
              paramh.add(localr);
            } while (((Cursor)localObject).moveToNext());
          }
          for (;;)
          {
            ((Cursor)localObject).close();
            break;
            paramh = Collections.emptyList();
          }
          if (96 == localr.field_resType)
          {
            b.iJf();
            if (TextUtils.isEmpty(b.nK(localr.field_resType, localr.field_subType))) {
              b.iJf().f(localr.field_resType, localr.field_subType, Util.getInt(localr.field_fileVersion, -1), false);
            }
          }
          if ((38 == localr.field_resType) && (localr.field_needRetry))
          {
            b.iJf();
            if (TextUtils.isEmpty(b.nK(localr.field_resType, localr.field_subType)))
            {
              Log.i(getTag(), "before doScene, res(%d.%d) needRetry and cachedFilePath isEmpty, skip add fileVersion into req", new Object[] { Integer.valueOf(localr.field_resType), Integer.valueOf(localr.field_subType) });
              continue;
            }
          }
          erz localerz = new erz();
          localerz.abmA = localr.field_subType;
          localerz.abvO = i;
          localerz.abvM = localr.field_keyVersion;
          localerz.XVH = localr.field_EID;
          localesb.abvU.add(localerz);
          ((StringBuilder)localObject).append(localr.field_subType).append(", ");
          continue;
          ((StringBuilder)localObject).append(" }");
          Log.i(getTag(), "before doScene, add subtypeList(%s) in type(%d)", new Object[] { ((StringBuilder)localObject).toString(), Integer.valueOf(localesb.vhJ) });
        }
      }
      return dispatch(paramg, iJy(), this);
    }
    catch (SQLException paramg)
    {
      label195:
      label225:
      label611:
      break label195;
    }
  }
  
  protected abstract String getTag();
  
  protected abstract abj i(com.tencent.mm.network.s params);
  
  protected abstract com.tencent.mm.network.s iJy();
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    Log.i(getTag(), "onGYNetEnd errType(%d), errCode(%d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    String str;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = i(params);
      str = getTag();
      if (!Util.isNullOrNil(paramArrayOfByte.ZjV)) {
        break label128;
      }
    }
    label128:
    for (params = "null";; params = String.valueOf(paramArrayOfByte.ZjV.size()))
    {
      Log.i(str, "response.Res.size() = %s", new Object[] { params });
      if (!Util.isNullOrNil(paramArrayOfByte.ZjV)) {
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(152002);
            Iterator localIterator = this.XWl.iterator();
            if (localIterator.hasNext())
            {
              esa localesa = (esa)localIterator.next();
              Object localObject2 = n.this.getTag();
              int i = localesa.vhJ;
              if (Util.isNullOrNil(localesa.abvT)) {}
              for (Object localObject1 = "null";; localObject1 = String.valueOf(localesa.abvT.size()))
              {
                Log.i((String)localObject2, "resType(%d) responses.size() = %s", new Object[] { Integer.valueOf(i), localObject1 });
                if (Util.isNullOrNil(localesa.abvT)) {
                  break;
                }
                localObject1 = localesa.abvT.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (erv)((Iterator)localObject1).next();
                  n.a(n.this, localesa.vhJ, (erv)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.checkresupdate.n
 * JD-Core Version:    0.7.0.1
 */