package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.e;
import java.util.Iterator;
import java.util.List;

public final class w
{
  public boolean oLX = false;
  
  public static void OY(String paramString)
  {
    Object localObject = e.aeT(paramString);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FileSystem.a locala = (FileSystem.a)((Iterator)localObject).next();
        if (locala.name.startsWith("SnsMicroMsg.dberr"))
        {
          y.i("MicroMsg.TrimSnsDb", "find error %s", new Object[] { paramString + locala.name });
          locala.delete();
        }
      }
    }
  }
  
  public static int a(h paramh1, h paramh2, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
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
      y.w("MicroMsg.TrimSnsDb", "diskDB has not this table !");
      return -1;
    }
    y.i("MicroMsg.TrimSnsDb", "create sql %s", new Object[] { paramh1 });
    boolean bool = paramh2.gk("", paramh1);
    y.i("MicroMsg.TrimSnsDb", "create result " + bool);
    return 1;
  }
  
  public static boolean a(h paramh1, h paramh2)
  {
    try
    {
      if (bk.bl(paramh1.getKey())) {
        paramh2.gk("", "ATTACH DATABASE '" + paramh1.getPath() + "' AS old ");
      }
      for (;;)
      {
        y.i("MicroMsg.TrimSnsDb", "ATTACH DATABASE " + paramh1.getKey());
        return true;
        paramh2.gk("", "ATTACH DATABASE '" + paramh1.getPath() + "' AS old KEY '" + paramh1.getKey() + "'");
      }
      return false;
    }
    catch (Exception paramh1)
    {
      y.e("MicroMsg.TrimSnsDb", "ERROR : attach disk db [%s] , will do again !", new Object[] { paramh1.getMessage() });
      y.printErrStackTrace("MicroMsg.TrimSnsDb", paramh1, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.w
 * JD-Core Version:    0.7.0.1
 */