package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.g;
import com.tencent.mm.h.c.r;
import com.tencent.mm.plugin.z.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public final class i
  extends com.tencent.mm.sdk.e.i<f>
{
  public static final String[] dXp = { com.tencent.mm.sdk.e.i.a(f.buS, "AppInfo") };
  public final com.tencent.mm.a.f<String, f> rUm = new com.tencent.mm.a.f(50);
  
  public i(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, f.buS, "AppInfo", r.cqY);
    parame = new f();
    parame.field_appId = "wx4310bbd51be7d979";
    if (!super.b(parame, new String[0]))
    {
      parame = new f();
      parame.field_appId = "wx4310bbd51be7d979";
      parame.field_appName = "weixinfile";
      parame.field_packageName = "com.tencent.mm.openapi";
      parame.field_status = -1;
      super.b(parame);
    }
  }
  
  private void DG(String paramString)
  {
    if (!bk.bl(paramString)) {
      this.rUm.remove(paramString);
    }
  }
  
  public static f ckU()
  {
    f localf = new f();
    localf.field_appName = "invalid_appname";
    localf.field_packageName = "";
    localf.field_signature = "";
    localf.field_status = 3;
    return localf;
  }
  
  public static String di(String paramString, int paramInt)
  {
    int i = 0;
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.AppInfoStorage", "getIconPath : invalid argument");
      return null;
    }
    String str = a.brk();
    b localb1 = new b(str);
    b localb2;
    if (!localb1.exists()) {
      if (!localb1.cLq().exists())
      {
        localb2 = localb1.cLq();
        b localb3 = new b(j.n(localb2.cLr()) + System.currentTimeMillis());
        if (localb3.mkdirs()) {
          localb3.n(localb2);
        }
      }
      else
      {
        if ((localb1.mkdirs()) && (localb1.isDirectory())) {
          break label232;
        }
        y.e("MicroMsg.AppInfoStorage", "mkdir error. %s", new Object[] { str });
      }
    }
    while (i != 0) {
      switch (paramInt)
      {
      default: 
        y.e("MicroMsg.AppInfoStorage", "getIconPath, unknown iconType = " + paramInt);
        return null;
        y.e("MicroMsg.AppInfoStorage", "mkdir error, %s", new Object[] { j.n(localb2.cLr()) });
        continue;
        label232:
        i = 1;
      }
    }
    return a.brk() + g.o(paramString.getBytes()) + ".png";
    return a.brk() + g.o(paramString.getBytes()) + "_wm.png";
    return a.brk() + g.o(paramString.getBytes()) + "_sg.png";
    return a.brk() + g.o(paramString.getBytes()) + "_sl.png";
    return a.brk() + g.o(paramString.getBytes()) + "_sp.png";
  }
  
  private void k(f paramf)
  {
    if ((paramf == null) || (paramf.field_appId == null)) {
      return;
    }
    this.rUm.f(paramf.field_appId, paramf);
  }
  
  public final f VU(String paramString)
  {
    Object localObject;
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.AppInfoStorage", "appId is null");
      localObject = null;
      return localObject;
    }
    f localf = (f)this.rUm.get(paramString);
    if (localf != null) {}
    for (;;)
    {
      if (localf != null)
      {
        localObject = localf;
        if (!bk.bl(localf.field_appId)) {
          break;
        }
      }
      localf = new f();
      localf.field_appId = paramString;
      if (!super.b(localf, new String[0])) {
        break label91;
      }
      k(localf);
      return localf;
      localf = null;
    }
    label91:
    return null;
  }
  
  public final boolean a(f paramf, String... paramVarArgs)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramf != null)
    {
      if (!bk.bl(paramf.field_appId)) {
        break label25;
      }
      bool1 = bool2;
    }
    label25:
    do
    {
      return bool1;
      DG(paramf.field_appId);
      bool2 = super.b(paramf, false, paramVarArgs);
      bool1 = bool2;
    } while (!bool2);
    b(paramf.field_appId, 3, paramf.field_appId);
    return bool2;
  }
  
  public final boolean b(f paramf, String... paramVarArgs)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramf != null)
    {
      if (!bk.bl(paramf.field_appId)) {
        break label25;
      }
      bool1 = bool2;
    }
    label25:
    do
    {
      return bool1;
      DG(paramf.field_appId);
      bool2 = super.a(paramf, false, paramVarArgs);
      bool1 = bool2;
    } while (!bool2);
    b(paramf.field_appId, 5, paramf.field_appId);
    return bool2;
  }
  
  public final List<String> ckS()
  {
    y.d("MicroMsg.AppInfoStorage", "getNullOpenIdList, maxCount = -1");
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = rawQuery("select appId from AppInfo where openId is NULL ", new String[0]);
    if (localCursor == null) {
      y.e("MicroMsg.AppInfoStorage", "get null cursor");
    }
    do
    {
      return localArrayList;
      int i = localCursor.getCount();
      if (i <= 0)
      {
        y.w("MicroMsg.AppInfoStorage", "getNullOpenIdList fail, cursor count = " + i);
        localCursor.close();
        return localArrayList;
      }
      if (localCursor.moveToFirst()) {
        while (!localCursor.isAfterLast())
        {
          i = localCursor.getColumnIndex("appId");
          if (i >= 0)
          {
            String str = localCursor.getString(i);
            if (!bk.bl(str)) {
              localArrayList.add(str);
            }
          }
          localCursor.moveToNext();
        }
      }
    } while (localCursor == null);
    localCursor.close();
    return localArrayList;
  }
  
  public final Cursor ckT()
  {
    Cursor localCursor2 = rawQuery("select * from AppInfo where appType like '%1,%'", new String[0]);
    Cursor localCursor1 = localCursor2;
    if (localCursor2 == null)
    {
      y.e("MicroMsg.AppInfoStorage", "getGameApp : cursor is null");
      localCursor1 = null;
    }
    return localCursor1;
  }
  
  public final Cursor dz(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder(256);
    ((StringBuilder)localObject).append("select * from AppInfo");
    ((StringBuilder)localObject).append(" where ");
    if (paramInt1 != 0) {
      ((StringBuilder)localObject).append(" ( serviceAppInfoFlag & ").append(paramInt1).append(" ) != 0 and ");
    }
    ((StringBuilder)localObject).append(" ( serviceShowFlag & ").append(paramInt2).append(" ) != 0");
    localObject = rawQuery(((StringBuilder)localObject).toString(), new String[0]);
    if (localObject == null)
    {
      y.e("MicroMsg.AppInfoStorage", "getServiceByAppInfoFlagAndShowFlag : cursor is null");
      return null;
    }
    y.d("MicroMsg.AppInfoStorage", "getServiceByAppInfoFlagAndShowFlag count = %d", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
    return localObject;
  }
  
  public final boolean e(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      y.e("MicroMsg.AppInfoStorage", "saveIcon, invalid argument");
    }
    Object localObject1;
    do
    {
      return false;
      localObject1 = di(paramString, paramInt);
      if (localObject1 == null)
      {
        y.e("MicroMsg.AppInfoStorage", "saveIcon fail, iconPath is null");
        return false;
      }
      Object localObject2 = new b((String)localObject1);
      if (((b)localObject2).exists()) {
        ((b)localObject2).delete();
      }
      localObject1 = null;
      try
      {
        localObject2 = com.tencent.mm.vfs.e.p((b)localObject2);
        localObject1 = localObject2;
        ((OutputStream)localObject2).write(paramArrayOfByte);
        localObject1 = localObject2;
        ((OutputStream)localObject2).close();
        localObject1 = localObject2;
        aam(paramString);
        return true;
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.AppInfoStorage", paramString, "", new Object[0]);
        y.e("MicroMsg.AppInfoStorage", "saveIcon, exception, e = " + paramString.getMessage());
      }
    } while (localObject1 == null);
    try
    {
      ((OutputStream)localObject1).close();
      return false;
    }
    catch (IOException paramString) {}
    return false;
  }
  
  public final boolean l(f paramf)
  {
    if ((paramf == null) || (bk.bl(paramf.field_appId))) {}
    while (!super.a(paramf, false)) {
      return false;
    }
    b(paramf.field_appId, 2, paramf.field_appId);
    k(paramf);
    return true;
  }
  
  public final boolean r(String paramString, Bitmap paramBitmap)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      y.e("MicroMsg.AppInfoStorage", "saveIcon : invalid argument");
      return false;
    }
    Object localObject = di(paramString, 1);
    if (localObject == null)
    {
      y.e("MicroMsg.AppInfoStorage", "saveIcon fail, iconPath is null");
      return false;
    }
    localObject = new b((String)localObject);
    if (((b)localObject).exists()) {
      ((b)localObject).delete();
    }
    try
    {
      localObject = com.tencent.mm.vfs.e.p((b)localObject);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      ((OutputStream)localObject).close();
      aam(paramString);
      return true;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.AppInfoStorage", paramString, "", new Object[0]);
      y.e("MicroMsg.AppInfoStorage", "saveIcon : compress occurs an exception");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.i
 * JD-Core Version:    0.7.0.1
 */