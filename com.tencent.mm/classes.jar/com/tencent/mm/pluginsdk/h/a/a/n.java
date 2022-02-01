package com.tencent.mm.pluginsdk.h.a.a;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.mm.al.g;
import com.tencent.mm.network.k;
import com.tencent.mm.pluginsdk.h.a.a.a.a;
import com.tencent.mm.pluginsdk.h.a.c.q.a;
import com.tencent.mm.pluginsdk.h.a.c.s;
import com.tencent.mm.pluginsdk.h.a.c.t;
import com.tencent.mm.protocal.protobuf.cla;
import com.tencent.mm.protocal.protobuf.clc;
import com.tencent.mm.protocal.protobuf.vk;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public abstract class n
  extends com.tencent.mm.al.n
  implements k
{
  protected static final SparseArray<a> BSW = new SparseArray();
  protected final List<clc> BSV = new LinkedList();
  private volatile g callback;
  
  n()
  {
    int[] arrayOfInt = i.BSy;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      Object localObject = (a)BSW.get(k);
      if ((localObject == null) || (!((a)localObject).xq(k)))
      {
        localObject = new clc();
        ((clc)localObject).mBH = k;
        this.BSV.add(localObject);
      }
      i += 1;
    }
  }
  
  public static void a(a parama)
  {
    BSW.put(39, parama);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    this.callback = paramg;
    ad.d(getTag(), "before dispatch");
    Iterator localIterator = this.BSV.iterator();
    while (localIterator.hasNext())
    {
      clc localclc = (clc)localIterator.next();
      int i = localclc.mBH;
      paramg = q.a.ewL();
      if (!paramg.jqw)
      {
        paramg = null;
        if (paramg != null) {
          break label212;
        }
      }
      Object localObject;
      s locals;
      for (paramg = Collections.emptyList();; paramg = Collections.emptyList())
      {
        localObject = new StringBuilder("{ ");
        paramg = paramg.iterator();
        while (paramg.hasNext())
        {
          locals = (s)paramg.next();
          i = bt.getInt(locals.field_fileVersion, -1);
          if (i >= 0)
          {
            cla localcla = new cla();
            localcla.DYI = locals.field_subType;
            localcla.Egx = i;
            localcla.Egv = locals.field_keyVersion;
            localcla.BSu = locals.field_EID;
            localclc.EgC.add(localcla);
            ((StringBuilder)localObject).append(locals.field_subType).append(", ");
          }
        }
        paramg = paramg.BTE.gPa;
        break;
        label212:
        localObject = paramg.a("ResDownloaderRecordTable", null, "urlKey" + String.format(Locale.US, " like '%d.%%.data'", new Object[] { Integer.valueOf(i) }) + " and groupId1=" + String.format(Locale.US, "'%s'", new Object[] { "CheckResUpdate" }), null, null, null, null, 2);
        if ((localObject != null) && (!((Cursor)localObject).isClosed())) {
          break label314;
        }
      }
      label314:
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
      ad.i(getTag(), "before doScene, add subtypeList(%s) in type(%d)", new Object[] { ((StringBuilder)localObject).toString(), Integer.valueOf(localclc.mBH) });
    }
    return dispatch(parame, ewD(), this);
  }
  
  protected abstract com.tencent.mm.network.q ewD();
  
  protected abstract String getTag();
  
  protected abstract vk h(com.tencent.mm.network.q paramq);
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    ad.i(getTag(), "onGYNetEnd errType(%d), errCode(%d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    String str;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = h(paramq);
      str = getTag();
      if (!bt.gL(paramArrayOfByte.CXx)) {
        break label128;
      }
    }
    label128:
    for (paramq = "null";; paramq = String.valueOf(paramArrayOfByte.CXx.size()))
    {
      ad.i(str, "response.Res.size() = %s", new Object[] { paramq });
      if (!bt.gL(paramArrayOfByte.CXx)) {
        b.c(new n.1(this, paramArrayOfByte.CXx), "NetSceneCheckResUpdate-ResponseHandlingThread");
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.n
 * JD-Core Version:    0.7.0.1
 */