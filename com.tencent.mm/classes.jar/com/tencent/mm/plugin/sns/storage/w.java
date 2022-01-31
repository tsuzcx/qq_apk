package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.e;
import java.util.Iterator;
import java.util.List;

public final class w
{
  public boolean rDI = false;
  
  public static int a(h paramh1, h paramh2, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(38030);
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
      ab.w("MicroMsg.TrimSnsDb", "diskDB has not this table !");
      AppMethodBeat.o(38030);
      return -1;
    }
    ab.i("MicroMsg.TrimSnsDb", "create sql %s", new Object[] { paramh1 });
    ab.i("MicroMsg.TrimSnsDb", "create result ".concat(String.valueOf(paramh2.execSQL("", paramh1))));
    AppMethodBeat.o(38030);
    return 1;
  }
  
  public static boolean a(h paramh1, h paramh2)
  {
    AppMethodBeat.i(38029);
    try
    {
      if (bo.isNullOrNil(paramh1.getKey())) {
        paramh2.execSQL("", "ATTACH DATABASE '" + paramh1.getPath() + "' AS old ");
      }
      for (;;)
      {
        ab.i("MicroMsg.TrimSnsDb", "ATTACH DATABASE " + paramh1.getKey());
        AppMethodBeat.o(38029);
        return true;
        paramh2.execSQL("", "ATTACH DATABASE '" + paramh1.getPath() + "' AS old KEY '" + paramh1.getKey() + "'");
      }
      return false;
    }
    catch (Exception paramh1)
    {
      ab.e("MicroMsg.TrimSnsDb", "ERROR : attach disk db [%s] , will do again !", new Object[] { paramh1.getMessage() });
      ab.printErrStackTrace("MicroMsg.TrimSnsDb", paramh1, "", new Object[0]);
      AppMethodBeat.o(38029);
    }
  }
  
  public static void abS(String paramString)
  {
    AppMethodBeat.i(38031);
    Object localObject = e.cs(paramString, false);
    if (localObject == null)
    {
      AppMethodBeat.o(38031);
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FileSystem.a locala = (FileSystem.a)((Iterator)localObject).next();
      if (locala.name.startsWith("SnsMicroMsg.dberr"))
      {
        ab.i("MicroMsg.TrimSnsDb", "find error %s", new Object[] { paramString + locala.name });
        locala.delete();
      }
    }
    AppMethodBeat.o(38031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.w
 * JD-Core Version:    0.7.0.1
 */