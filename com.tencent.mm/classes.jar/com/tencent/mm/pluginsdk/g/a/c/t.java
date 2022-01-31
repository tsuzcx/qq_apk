package com.tencent.mm.pluginsdk.g.a.c;

import android.annotation.SuppressLint;
import com.tencent.mm.a.g;
import com.tencent.mm.cf.h;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class t
  extends i<s>
{
  private static final String[] dXp = { i.a(s.buS, "ResDownloaderRecordTable") };
  private static final String rXT = ac.dOP + g.o(String.format("mm%d", new Object[] { Integer.valueOf(-2147483648) }).getBytes()) + "/";
  @SuppressLint({"UseSparseArrays"})
  private static final HashMap<Integer, h.d> rXU;
  public final h dXo;
  private final HashMap<String, Object> rXV = new HashMap();
  
  static
  {
    Object localObject = new HashMap();
    rXU = (HashMap)localObject;
    ((HashMap)localObject).put(Integer.valueOf("RES_DOWNLOADER_RECORD_TABLE".hashCode()), new t.1());
    localObject = r.clM().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
  }
  
  private t(h paramh)
  {
    super(paramh, s.buS, "ResDownloaderRecordTable", null);
    this.dXo = paramh;
    paramh = r.clM().iterator();
    while (paramh.hasNext()) {
      paramh.next();
    }
  }
  
  static t clN()
  {
    try
    {
      new File(rXT).mkdirs();
      Object localObject = new h();
      if (!((h)localObject).a(rXT + "ResDown.db", rXT + "EnResDown.db", -2147483648L, q.zf(), rXU))
      {
        y.f("MicroMsg.ResDownloaderStorage", "res downloader db init failed");
        return null;
      }
      localObject = new t((h)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ResDownloaderStorage", "new storage failed, exception = %s", new Object[] { localException });
    }
    return null;
  }
  
  public final s Wl(String paramString)
  {
    if (bk.bl(paramString)) {
      y.e("MicroMsg.ResDownloaderStorage", "query with null or nil urlKey, return null");
    }
    s locals;
    do
    {
      return null;
      locals = new s();
      locals.field_urlKey_hashcode = paramString.hashCode();
    } while (!super.b(locals, new String[] { "urlKey_hashcode" }));
    return locals;
  }
  
  public final boolean h(s params)
  {
    if (bk.bl(params.field_urlKey)) {
      return false;
    }
    params.field_urlKey_hashcode = params.field_urlKey.hashCode();
    return super.c(params, new String[] { "urlKey_hashcode" });
  }
  
  public final boolean i(s params)
  {
    if (bk.bl(params.field_urlKey)) {
      return false;
    }
    params.field_urlKey_hashcode = params.field_urlKey.hashCode();
    return super.b(params);
  }
  
  public final boolean jJ(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.ResDownloaderStorage", "delete with null or nil urlKey, return false");
      return false;
    }
    s locals = new s();
    locals.field_urlKey_hashcode = paramString.hashCode();
    return super.a(locals, new String[] { "urlKey_hashcode" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.t
 * JD-Core Version:    0.7.0.1
 */