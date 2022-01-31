package com.tencent.mm.pluginsdk.g.a.a;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.pluginsdk.g.a.a.a.a;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.pluginsdk.g.a.c.t;
import com.tencent.mm.protocal.c.blr;
import com.tencent.mm.protocal.c.blv;
import com.tencent.mm.protocal.c.blw;
import com.tencent.mm.protocal.c.blx;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public abstract class n
  extends m
  implements k
{
  protected static final SparseArray<a> rXe = new SparseArray();
  private volatile f dmL;
  protected final List<blx> rXd = new LinkedList();
  
  n()
  {
    int[] arrayOfInt = i.rWF;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      Object localObject = (a)rXe.get(k);
      if ((localObject == null) || (!((a)localObject).nY(k)))
      {
        localObject = new blx();
        ((blx)localObject).hQR = k;
        this.rXd.add(localObject);
      }
      i += 1;
    }
  }
  
  public static void a(a parama)
  {
    rXe.put(39, parama);
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    y.d(getTag(), "before dispatch");
    Iterator localIterator = this.rXd.iterator();
    while (localIterator.hasNext())
    {
      blx localblx = (blx)localIterator.next();
      int i = localblx.hQR;
      paramf = q.a.clL();
      if (!paramf.gaO)
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
          i = bk.getInt(locals.field_fileVersion, -1);
          if (i >= 0)
          {
            blv localblv = new blv();
            localblv.tAu = locals.field_subType;
            localblv.tFr = i;
            localblv.tFp = locals.field_keyVersion;
            localblv.rWB = locals.field_EID;
            localblx.tFw.add(localblv);
            ((StringBuilder)localObject).append(locals.field_subType).append(", ");
          }
        }
        paramf = paramf.rXN.dXo;
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
          locals.d((Cursor)localObject);
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
      y.i(getTag(), "before doScene, add subtypeList(%s) in type(%d)", new Object[] { ((StringBuilder)localObject).toString(), Integer.valueOf(localblx.hQR) });
    }
    return a(parame, clE(), this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i(getTag(), "onGYNetEnd errType(%d), errCode(%d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    String str;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = i(paramq);
      str = getTag();
      if (!bk.dk(paramArrayOfByte.sNp)) {
        break label128;
      }
    }
    label128:
    for (paramq = "null";; paramq = String.valueOf(paramArrayOfByte.sNp.size()))
    {
      y.i(str, "response.Res.size() = %s", new Object[] { paramq });
      if (!bk.dk(paramArrayOfByte.sNp)) {
        com.tencent.mm.sdk.f.e.post(new Runnable()
        {
          public final void run()
          {
            Iterator localIterator = this.rXf.iterator();
            if (localIterator.hasNext())
            {
              blw localblw = (blw)localIterator.next();
              Object localObject2 = n.this.getTag();
              int i = localblw.hQR;
              if (bk.dk(localblw.tFv)) {}
              for (Object localObject1 = "null";; localObject1 = String.valueOf(localblw.tFv.size()))
              {
                y.i((String)localObject2, "resType(%d) responses.size() = %s", new Object[] { Integer.valueOf(i), localObject1 });
                if (bk.dk(localblw.tFv)) {
                  break;
                }
                localObject1 = localblw.tFv.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (blr)((Iterator)localObject1).next();
                  n.a(n.this, localblw.hQR, (blr)localObject2);
                }
                break;
              }
            }
          }
        }, "NetSceneCheckResUpdate-ResponseHandlingThread");
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
  }
  
  protected abstract com.tencent.mm.network.q clE();
  
  protected abstract String getTag();
  
  protected abstract pn i(com.tencent.mm.network.q paramq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.n
 * JD-Core Version:    0.7.0.1
 */