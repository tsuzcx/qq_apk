package com.tencent.mm.pluginsdk.g.a.c;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.cg.h;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class t
  extends j<s>
{
  private static final String[] SQL_CREATE;
  private static final String vOK;
  @SuppressLint({"UseSparseArrays"})
  private static final HashMap<Integer, h.d> vOL;
  public final h fnw;
  private final HashMap<String, Object> vOM;
  
  static
  {
    AppMethodBeat.i(79637);
    SQL_CREATE = new String[] { j.getCreateSQLs(s.info, "ResDownloaderRecordTable") };
    vOK = ac.eQv + g.w(String.format("mm%d", new Object[] { Integer.valueOf(-2147483648) }).getBytes()) + "/";
    Object localObject = new HashMap();
    vOL = (HashMap)localObject;
    ((HashMap)localObject).put(Integer.valueOf("RES_DOWNLOADER_RECORD_TABLE".hashCode()), new t.1());
    localObject = r.dmA().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    AppMethodBeat.o(79637);
  }
  
  private t(h paramh)
  {
    super(paramh, s.info, "ResDownloaderRecordTable", null);
    AppMethodBeat.i(79630);
    this.vOM = new HashMap();
    this.fnw = paramh;
    paramh = r.dmA().iterator();
    while (paramh.hasNext()) {
      paramh.next();
    }
    AppMethodBeat.o(79630);
  }
  
  static t dmB()
  {
    AppMethodBeat.i(79631);
    try
    {
      new File(vOK).mkdirs();
      Object localObject = new h();
      String str1 = vOK + "ResDown.db";
      String str2 = vOK + "EnResDown.db";
      q.bP(true);
      if (!((h)localObject).a(str1, str2, -2147483648L, vOL))
      {
        ab.f("MicroMsg.ResDownloaderStorage", "res downloader db init failed");
        AppMethodBeat.o(79631);
        return null;
      }
      localObject = new t((h)localObject);
      AppMethodBeat.o(79631);
      return localObject;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ResDownloaderStorage", "new storage failed, exception = %s", new Object[] { localException });
      AppMethodBeat.o(79631);
    }
    return null;
  }
  
  public final s alQ(String paramString)
  {
    AppMethodBeat.i(79635);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.ResDownloaderStorage", "query with null or nil urlKey, return null");
      AppMethodBeat.o(79635);
      return null;
    }
    s locals = new s();
    locals.field_urlKey_hashcode = paramString.hashCode();
    if (super.get(locals, new String[] { "urlKey_hashcode" }))
    {
      AppMethodBeat.o(79635);
      return locals;
    }
    AppMethodBeat.o(79635);
    return null;
  }
  
  public final boolean i(s params)
  {
    AppMethodBeat.i(79633);
    if (bo.isNullOrNil(params.field_urlKey))
    {
      AppMethodBeat.o(79633);
      return false;
    }
    params.field_urlKey_hashcode = params.field_urlKey.hashCode();
    boolean bool = super.update(params, new String[] { "urlKey_hashcode" });
    AppMethodBeat.o(79633);
    return bool;
  }
  
  public final boolean j(s params)
  {
    AppMethodBeat.i(79634);
    if (bo.isNullOrNil(params.field_urlKey))
    {
      AppMethodBeat.o(79634);
      return false;
    }
    params.field_urlKey_hashcode = params.field_urlKey.hashCode();
    boolean bool = super.insert(params);
    AppMethodBeat.o(79634);
    return bool;
  }
  
  public final boolean qD(String paramString)
  {
    AppMethodBeat.i(79632);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.ResDownloaderStorage", "delete with null or nil urlKey, return false");
      AppMethodBeat.o(79632);
      return false;
    }
    s locals = new s();
    locals.field_urlKey_hashcode = paramString.hashCode();
    boolean bool = super.delete(locals, new String[] { "urlKey_hashcode" });
    AppMethodBeat.o(79632);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.t
 * JD-Core Version:    0.7.0.1
 */