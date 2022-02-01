package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.i;
import java.util.Iterator;

public final class z
{
  public boolean zNw = false;
  
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
      ad.w("MicroMsg.TrimSnsDb", "diskDB has not this table !");
      AppMethodBeat.o(97649);
      return -1;
    }
    ad.i("MicroMsg.TrimSnsDb", "create sql %s", new Object[] { paramh1 });
    ad.i("MicroMsg.TrimSnsDb", "create result ".concat(String.valueOf(paramh2.execSQL("", paramh1))));
    AppMethodBeat.o(97649);
    return 1;
  }
  
  public static boolean a(h paramh1, h paramh2)
  {
    AppMethodBeat.i(97648);
    try
    {
      if (bt.isNullOrNil(paramh1.getKey())) {
        paramh2.execSQL("", "ATTACH DATABASE '" + paramh1.getPath() + "' AS old ");
      }
      for (;;)
      {
        ad.i("MicroMsg.TrimSnsDb", "ATTACH DATABASE " + paramh1.getKey());
        AppMethodBeat.o(97648);
        return true;
        paramh2.execSQL("", "ATTACH DATABASE '" + paramh1.getPath() + "' AS old KEY '" + paramh1.getKey() + "'");
      }
      return false;
    }
    catch (Exception paramh1)
    {
      ad.e("MicroMsg.TrimSnsDb", "ERROR : attach disk db [%s] , will do again !", new Object[] { paramh1.getMessage() });
      ad.printErrStackTrace("MicroMsg.TrimSnsDb", paramh1, "", new Object[0]);
      AppMethodBeat.o(97648);
    }
  }
  
  public static void aAA(String paramString)
  {
    AppMethodBeat.i(97650);
    Object localObject = i.de(paramString, false);
    if (localObject == null)
    {
      AppMethodBeat.o(97650);
      return;
    }
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FileSystem.a locala = (FileSystem.a)((Iterator)localObject).next();
      if ((!locala.LjL) && (locala.name.startsWith("SnsMicroMsg.dberr")))
      {
        ad.i("MicroMsg.TrimSnsDb", "find error %s", new Object[] { paramString + locala.name });
        locala.delete();
      }
    }
    AppMethodBeat.o(97650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.z
 * JD-Core Version:    0.7.0.1
 */