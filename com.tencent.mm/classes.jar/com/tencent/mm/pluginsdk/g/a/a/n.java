package com.tencent.mm.pluginsdk.g.a.a;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.pluginsdk.g.a.a.a.a;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.pluginsdk.g.a.c.t;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public abstract class n
  extends m
  implements k
{
  protected static final SparseArray<a> vNW = new SparseArray();
  private volatile f callback;
  protected final List<bvj> vNV = new LinkedList();
  
  n()
  {
    int[] arrayOfInt = i.vNx;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      Object localObject = (a)vNW.get(k);
      if ((localObject == null) || (!((a)localObject).rL(k)))
      {
        localObject = new bvj();
        ((bvj)localObject).jKs = k;
        this.vNV.add(localObject);
      }
      i += 1;
    }
  }
  
  public static void a(a parama)
  {
    vNW.put(39, parama);
  }
  
  protected abstract com.tencent.mm.network.q dmr();
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    this.callback = paramf;
    ab.d(getTag(), "before dispatch");
    Iterator localIterator = this.vNV.iterator();
    while (localIterator.hasNext())
    {
      bvj localbvj = (bvj)localIterator.next();
      int i = localbvj.jKs;
      paramf = q.a.dmz();
      if (!paramf.hsO)
      {
        paramf = null;
        if (paramf != null) {
          break label212;
        }
      }
      Object localObject;
      s locals;
      for (paramf = Collections.emptyList();; paramf = Collections.emptyList())
      {
        localObject = new StringBuilder("{ ");
        paramf = paramf.iterator();
        while (paramf.hasNext())
        {
          locals = (s)paramf.next();
          i = bo.getInt(locals.field_fileVersion, -1);
          if (i >= 0)
          {
            bvh localbvh = new bvh();
            localbvh.xCa = locals.field_subType;
            localbvh.xIX = i;
            localbvh.xIV = locals.field_keyVersion;
            localbvh.vNt = locals.field_EID;
            localbvj.xJc.add(localbvh);
            ((StringBuilder)localObject).append(locals.field_subType).append(", ");
          }
        }
        paramf = paramf.vOE.fnw;
        break;
        label212:
        localObject = paramf.a("ResDownloaderRecordTable", null, "urlKey" + String.format(Locale.US, " like '%d.%%.data'", new Object[] { Integer.valueOf(i) }) + " and groupId1=" + String.format(Locale.US, "'%s'", new Object[] { "CheckResUpdate" }), null, null, null, null, 2);
        if ((localObject != null) && (!((Cursor)localObject).isClosed())) {
          break label315;
        }
      }
      label315:
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
      ab.i(getTag(), "before doScene, add subtypeList(%s) in type(%d)", new Object[] { ((StringBuilder)localObject).toString(), Integer.valueOf(localbvj.jKs) });
    }
    return dispatch(parame, dmr(), this);
  }
  
  protected abstract String getTag();
  
  protected abstract sr h(com.tencent.mm.network.q paramq);
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    ab.i(getTag(), "onGYNetEnd errType(%d), errCode(%d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    String str;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = h(paramq);
      str = getTag();
      if (!bo.es(paramArrayOfByte.wLf)) {
        break label128;
      }
    }
    label128:
    for (paramq = "null";; paramq = String.valueOf(paramArrayOfByte.wLf.size()))
    {
      ab.i(str, "response.Res.size() = %s", new Object[] { paramq });
      if (!bo.es(paramArrayOfByte.wLf)) {
        d.post(new n.1(this, paramArrayOfByte.wLf), "NetSceneCheckResUpdate-ResponseHandlingThread");
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.n
 * JD-Core Version:    0.7.0.1
 */