package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.c;
import com.tencent.mm.vfs.o;
import java.util.Iterator;

public final class z
{
  public boolean AeD = false;
  
  public static int a(h paramh1, h paramh2, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(97649);
    paramString = paramh1.a(" select sql from sqlite_master where tbl_name=\"" + paramString + "\" and type = \"table\"", null, 0);
    paramh1 = localObject2;
    if (paramString != null)
    {
      paramh1 = localObject1;
      if (paramString.getCount() == 1)
      {
        paramString.moveToFirst();
        paramh1 = paramString.getString(0);
      }
      paramString.close();
    }
    if (paramh1 == null)
    {
      ae.w("MicroMsg.TrimSnsDb", "diskDB has not this table !");
      AppMethodBeat.o(97649);
      return -1;
    }
    ae.i("MicroMsg.TrimSnsDb", "create sql %s", new Object[] { paramh1 });
    ae.i("MicroMsg.TrimSnsDb", "create result ".concat(String.valueOf(paramh2.execSQL("", paramh1))));
    AppMethodBeat.o(97649);
    return 1;
  }
  
  public static boolean a(h paramh1, h paramh2)
  {
    AppMethodBeat.i(97648);
    try
    {
      if (bu.isNullOrNil(paramh1.getKey())) {
        paramh2.execSQL("", "ATTACH DATABASE '" + paramh1.getPath() + "' AS old ");
      }
      for (;;)
      {
        ae.i("MicroMsg.TrimSnsDb", "ATTACH DATABASE " + paramh1.getKey());
        AppMethodBeat.o(97648);
        return true;
        paramh2.execSQL("", "ATTACH DATABASE '" + paramh1.getPath() + "' AS old KEY '" + paramh1.getKey() + "'");
      }
      return false;
    }
    catch (Exception paramh1)
    {
      ae.e("MicroMsg.TrimSnsDb", "ERROR : attach disk db [%s] , will do again !", new Object[] { paramh1.getMessage() });
      ae.printErrStackTrace("MicroMsg.TrimSnsDb", paramh1, "", new Object[0]);
      AppMethodBeat.o(97648);
    }
  }
  
  public static void aBR(String paramString)
  {
    AppMethodBeat.i(97650);
    Object localObject = o.dh(paramString, false);
    if (localObject == null)
    {
      AppMethodBeat.o(97650);
      return;
    }
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      c localc = (c)((Iterator)localObject).next();
      if ((!localc.LGd) && (localc.name.startsWith("SnsMicroMsg.dberr")))
      {
        ae.i("MicroMsg.TrimSnsDb", "find error %s", new Object[] { paramString + localc.name });
        localc.delete();
      }
    }
    AppMethodBeat.o(97650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.z
 * JD-Core Version:    0.7.0.1
 */