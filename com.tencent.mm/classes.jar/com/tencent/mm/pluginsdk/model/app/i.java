package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.g.c.t;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public final class i
  extends com.tencent.mm.sdk.e.j<f>
{
  public static final String[] SQL_CREATE;
  public final com.tencent.mm.a.f<String, f> vLk;
  
  static
  {
    AppMethodBeat.i(79326);
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(f.info, "AppInfo") };
    AppMethodBeat.o(79326);
  }
  
  public i(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, f.info, "AppInfo", t.INDEX_CREATE);
    AppMethodBeat.i(79309);
    this.vLk = new c(50);
    parame = new f();
    parame.field_appId = "wx4310bbd51be7d979";
    if (!super.get(parame, new String[0]))
    {
      parame = new f();
      parame.field_appId = "wx4310bbd51be7d979";
      parame.field_appName = "weixinfile";
      parame.field_packageName = "com.tencent.mm.openapi";
      parame.field_status = -1;
      super.insert(parame);
    }
    AppMethodBeat.o(79309);
  }
  
  private void OP(String paramString)
  {
    AppMethodBeat.i(79311);
    if (!bo.isNullOrNil(paramString)) {
      this.vLk.remove(paramString);
    }
    AppMethodBeat.o(79311);
  }
  
  public static String en(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(79319);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.AppInfoStorage", "getIconPath : invalid argument");
      AppMethodBeat.o(79319);
      return null;
    }
    String str = a.bZZ();
    b localb1 = new b(str);
    b localb2;
    if (!localb1.exists()) {
      if (!localb1.dQI().exists())
      {
        localb2 = localb1.dQI();
        b localb3 = new b(com.tencent.mm.vfs.j.p(localb2.dQJ()) + System.currentTimeMillis());
        if (localb3.mkdirs()) {
          localb3.p(localb2);
        }
      }
      else
      {
        if ((localb1.mkdirs()) && (localb1.isDirectory())) {
          break label191;
        }
        ab.e("MicroMsg.AppInfoStorage", "mkdir error. %s", new Object[] { str });
      }
    }
    while (i == 0)
    {
      AppMethodBeat.o(79319);
      return null;
      ab.e("MicroMsg.AppInfoStorage", "mkdir error, %s", new Object[] { com.tencent.mm.vfs.j.p(localb2.dQJ()) });
      continue;
      label191:
      i = 1;
    }
    switch (paramInt)
    {
    default: 
      ab.e("MicroMsg.AppInfoStorage", "getIconPath, unknown iconType = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(79319);
      return null;
    case 1: 
      paramString = a.bZZ() + g.w(paramString.getBytes()) + ".png";
      AppMethodBeat.o(79319);
      return paramString;
    case 2: 
      paramString = a.bZZ() + g.w(paramString.getBytes()) + "_wm.png";
      AppMethodBeat.o(79319);
      return paramString;
    case 3: 
      paramString = a.bZZ() + g.w(paramString.getBytes()) + "_sg.png";
      AppMethodBeat.o(79319);
      return paramString;
    case 5: 
      paramString = a.bZZ() + g.w(paramString.getBytes()) + "_sl.png";
      AppMethodBeat.o(79319);
      return paramString;
    }
    paramString = a.bZZ() + g.w(paramString.getBytes()) + "_sp.png";
    AppMethodBeat.o(79319);
    return paramString;
  }
  
  private void o(f paramf)
  {
    AppMethodBeat.i(79310);
    if ((paramf == null) || (paramf.field_appId == null))
    {
      AppMethodBeat.o(79310);
      return;
    }
    this.vLk.f(paramf.field_appId, paramf);
    AppMethodBeat.o(79310);
  }
  
  public final boolean a(f paramf, String... paramVarArgs)
  {
    AppMethodBeat.i(79313);
    if ((paramf == null) || (bo.isNullOrNil(paramf.field_appId)))
    {
      AppMethodBeat.o(79313);
      return false;
    }
    if ((f.vKX.equals(paramf.field_appId)) || (f.vKZ.equals(paramf.field_appId))) {
      ab.i("MicroMsg.AppInfoStorage", "update appinfo: %s, %s, %s, %s, %s", new Object[] { paramf.field_appId, paramf.field_appName, Integer.valueOf(paramf.field_serviceShowFlag), Integer.valueOf(paramf.field_appInfoFlag), bo.dtY() });
    }
    OP(paramf.field_appId);
    boolean bool = super.updateNotify(paramf, false, paramVarArgs);
    if (bool) {
      doNotify(paramf.field_appId, 3, paramf.field_appId);
    }
    AppMethodBeat.o(79313);
    return bool;
  }
  
  public final f als(String paramString)
  {
    AppMethodBeat.i(79316);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.AppInfoStorage", "appId is null");
      AppMethodBeat.o(79316);
      return null;
    }
    f localf = (f)this.vLk.Y(paramString);
    if (localf != null) {}
    while ((localf != null) && (!bo.isNullOrNil(localf.field_appId)))
    {
      AppMethodBeat.o(79316);
      return localf;
      localf = null;
    }
    localf = new f();
    localf.field_appId = paramString;
    if (super.get(localf, new String[0]))
    {
      o(localf);
      AppMethodBeat.o(79316);
      return localf;
    }
    AppMethodBeat.o(79316);
    return null;
  }
  
  public final boolean b(f paramf, String... paramVarArgs)
  {
    AppMethodBeat.i(79314);
    if ((paramf == null) || (bo.isNullOrNil(paramf.field_appId)))
    {
      AppMethodBeat.o(79314);
      return false;
    }
    if ((f.vKX.equals(paramf.field_appId)) || (f.vKZ.equals(paramf.field_appId))) {
      ab.i("MicroMsg.AppInfoStorage", "delete appinfo: %s, %s, %s, %s, %s", new Object[] { paramf.field_appId, paramf.field_appName, Integer.valueOf(paramf.field_serviceShowFlag), Integer.valueOf(paramf.field_appInfoFlag), bo.dtY() });
    }
    OP(paramf.field_appId);
    boolean bool = super.delete(paramf, false, paramVarArgs);
    if (bool) {
      doNotify(paramf.field_appId, 5, paramf.field_appId);
    }
    AppMethodBeat.o(79314);
    return bool;
  }
  
  public final List<String> dlC()
  {
    AppMethodBeat.i(79315);
    ab.d("MicroMsg.AppInfoStorage", "getNullOpenIdList, maxCount = -1");
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = rawQuery("select appId from AppInfo where openId is NULL ", new String[0]);
    if (localCursor == null)
    {
      ab.e("MicroMsg.AppInfoStorage", "get null cursor");
      AppMethodBeat.o(79315);
      return localArrayList;
    }
    int i = localCursor.getCount();
    if (i <= 0)
    {
      ab.w("MicroMsg.AppInfoStorage", "getNullOpenIdList fail, cursor count = ".concat(String.valueOf(i)));
      localCursor.close();
      AppMethodBeat.o(79315);
      return localArrayList;
    }
    if (localCursor.moveToFirst()) {
      while (!localCursor.isAfterLast())
      {
        i = localCursor.getColumnIndex("appId");
        if (i >= 0)
        {
          String str = localCursor.getString(i);
          if (!bo.isNullOrNil(str)) {
            localArrayList.add(str);
          }
        }
        localCursor.moveToNext();
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(79315);
    return localArrayList;
  }
  
  public final Cursor dlD()
  {
    AppMethodBeat.i(79318);
    Cursor localCursor = rawQuery("select * from AppInfo where appType like '%1,%'", new String[0]);
    if (localCursor == null)
    {
      ab.e("MicroMsg.AppInfoStorage", "getGameApp : cursor is null");
      AppMethodBeat.o(79318);
      return null;
    }
    AppMethodBeat.o(79318);
    return localCursor;
  }
  
  public final boolean e(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(79321);
    if ((paramString == null) || (paramString.length() == 0) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ab.e("MicroMsg.AppInfoStorage", "saveIcon, invalid argument");
      AppMethodBeat.o(79321);
      return false;
    }
    Object localObject1 = en(paramString, paramInt);
    if (localObject1 == null)
    {
      ab.e("MicroMsg.AppInfoStorage", "saveIcon fail, iconPath is null");
      AppMethodBeat.o(79321);
      return false;
    }
    Object localObject2 = new b((String)localObject1);
    if (((b)localObject2).exists()) {
      ((b)localObject2).delete();
    }
    localObject1 = null;
    try
    {
      localObject2 = com.tencent.mm.vfs.e.r((b)localObject2);
      localObject1 = localObject2;
      ((OutputStream)localObject2).write(paramArrayOfByte);
      localObject1 = localObject2;
      ((OutputStream)localObject2).close();
      localObject1 = localObject2;
      doNotify(paramString);
      AppMethodBeat.o(79321);
      return true;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.AppInfoStorage", paramString, "", new Object[0]);
      ab.e("MicroMsg.AppInfoStorage", "saveIcon, exception, e = " + paramString.getMessage());
      if (localObject1 == null) {}
    }
    try
    {
      ((OutputStream)localObject1).close();
      label190:
      AppMethodBeat.o(79321);
      return false;
    }
    catch (IOException paramString)
    {
      break label190;
    }
  }
  
  public final Cursor eZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79317);
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
      ab.e("MicroMsg.AppInfoStorage", "getServiceByAppInfoFlagAndShowFlag : cursor is null");
      AppMethodBeat.o(79317);
      return null;
    }
    AppMethodBeat.o(79317);
    return localObject;
  }
  
  public final boolean p(f paramf)
  {
    AppMethodBeat.i(79312);
    if ((paramf == null) || (bo.isNullOrNil(paramf.field_appId)))
    {
      AppMethodBeat.o(79312);
      return false;
    }
    if ((f.vKX.equals(paramf.field_appId)) || (f.vKZ.equals(paramf.field_appId))) {
      ab.i("MicroMsg.AppInfoStorage", "insert appinfo: %s, %s, %s, %s, %s", new Object[] { paramf.field_appId, paramf.field_appName, Integer.valueOf(paramf.field_serviceShowFlag), Integer.valueOf(paramf.field_appInfoFlag), bo.dtY() });
    }
    if (super.insertNotify(paramf, false))
    {
      doNotify(paramf.field_appId, 2, paramf.field_appId);
      o(paramf);
      AppMethodBeat.o(79312);
      return true;
    }
    AppMethodBeat.o(79312);
    return false;
  }
  
  public final boolean t(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(79320);
    if ((paramString == null) || (paramString.length() == 0) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      ab.e("MicroMsg.AppInfoStorage", "saveIcon : invalid argument");
      AppMethodBeat.o(79320);
      return false;
    }
    Object localObject = en(paramString, 1);
    if (localObject == null)
    {
      ab.e("MicroMsg.AppInfoStorage", "saveIcon fail, iconPath is null");
      AppMethodBeat.o(79320);
      return false;
    }
    localObject = new b((String)localObject);
    if (((b)localObject).exists()) {
      ((b)localObject).delete();
    }
    try
    {
      localObject = com.tencent.mm.vfs.e.r((b)localObject);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      ((OutputStream)localObject).close();
      doNotify(paramString);
      AppMethodBeat.o(79320);
      return true;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.AppInfoStorage", paramString, "", new Object[0]);
      ab.e("MicroMsg.AppInfoStorage", "saveIcon : compress occurs an exception");
      AppMethodBeat.o(79320);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.i
 * JD-Core Version:    0.7.0.1
 */