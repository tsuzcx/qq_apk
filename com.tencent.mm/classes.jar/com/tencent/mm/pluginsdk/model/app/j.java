package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.f.c.y;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.plugin.ab.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public final class j
  extends MAutoStorage<g>
{
  public static final String[] SQL_CREATE;
  public final f<String, g> QWu;
  
  static
  {
    AppMethodBeat.i(151751);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(g.info, "AppInfo") };
    AppMethodBeat.o(151751);
  }
  
  public j(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, g.info, "AppInfo", y.INDEX_CREATE);
    AppMethodBeat.i(151735);
    this.QWu = new c(50);
    paramISQLiteDatabase = new g();
    paramISQLiteDatabase.field_appId = "wx4310bbd51be7d979";
    if (!super.get(paramISQLiteDatabase, new String[0]))
    {
      paramISQLiteDatabase = new g();
      paramISQLiteDatabase.field_appId = "wx4310bbd51be7d979";
      paramISQLiteDatabase.field_appName = "weixinfile";
      paramISQLiteDatabase.field_packageName = "com.tencent.mm.openapi";
      paramISQLiteDatabase.field_status = -1;
      super.insert(paramISQLiteDatabase);
    }
    AppMethodBeat.o(151735);
  }
  
  private void aHy(String paramString)
  {
    AppMethodBeat.i(151737);
    if (!Util.isNullOrNil(paramString)) {
      this.QWu.remove(paramString);
    }
    AppMethodBeat.o(151737);
  }
  
  public static String ho(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(151745);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppInfoStorage", "getIconPath : invalid argument");
      AppMethodBeat.o(151745);
      return null;
    }
    String str = a.fmw();
    q localq1 = new q(str);
    q localq2;
    if (!localq1.ifE()) {
      if (!localq1.ifB().ifE())
      {
        localq2 = localq1.ifB();
        q localq3 = new q(localq2.bOF() + System.currentTimeMillis());
        if (localq3.ifK()) {
          localq3.aj(localq2);
        }
      }
      else
      {
        if ((localq1.ifK()) && (localq1.isDirectory())) {
          break label185;
        }
        Log.e("MicroMsg.AppInfoStorage", "mkdir error. %s", new Object[] { str });
      }
    }
    while (i == 0)
    {
      AppMethodBeat.o(151745);
      return null;
      Log.e("MicroMsg.AppInfoStorage", "mkdir error, %s", new Object[] { localq2.bOF() });
      continue;
      label185:
      i = 1;
    }
    switch (paramInt)
    {
    default: 
      Log.e("MicroMsg.AppInfoStorage", "getIconPath, unknown iconType = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(151745);
      return null;
    case 1: 
      paramString = a.fmw() + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) + ".png";
      AppMethodBeat.o(151745);
      return paramString;
    case 2: 
      paramString = a.fmw() + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) + "_wm.png";
      AppMethodBeat.o(151745);
      return paramString;
    case 3: 
      paramString = a.fmw() + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) + "_sg.png";
      AppMethodBeat.o(151745);
      return paramString;
    case 5: 
      paramString = a.fmw() + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) + "_sl.png";
      AppMethodBeat.o(151745);
      return paramString;
    }
    paramString = a.fmw() + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) + "_sp.png";
    AppMethodBeat.o(151745);
    return paramString;
  }
  
  private void q(g paramg)
  {
    AppMethodBeat.i(151736);
    if ((paramg == null) || (paramg.field_appId == null))
    {
      AppMethodBeat.o(151736);
      return;
    }
    this.QWu.q(paramg.field_appId, paramg);
    AppMethodBeat.o(151736);
  }
  
  public final boolean a(g paramg, String... paramVarArgs)
  {
    AppMethodBeat.i(151739);
    if ((paramg == null) || (Util.isNullOrNil(paramg.field_appId)))
    {
      AppMethodBeat.o(151739);
      return false;
    }
    if ((g.QWe.equals(paramg.field_appId)) || (g.QWg.equals(paramg.field_appId))) {
      Log.i("MicroMsg.AppInfoStorage", "update appinfo: %s, %s, %s, %s, %s", new Object[] { paramg.field_appId, paramg.field_appName, Integer.valueOf(paramg.field_serviceShowFlag), Integer.valueOf(paramg.field_appInfoFlag), Util.getStack() });
    }
    aHy(paramg.field_appId);
    boolean bool = super.updateNotify(paramg, false, paramVarArgs);
    if (bool) {
      doNotify(paramg.field_appId, 3, paramg.field_appId);
    }
    AppMethodBeat.o(151739);
    return bool;
  }
  
  public final boolean b(g paramg, String... paramVarArgs)
  {
    AppMethodBeat.i(151740);
    if ((paramg == null) || (Util.isNullOrNil(paramg.field_appId)))
    {
      AppMethodBeat.o(151740);
      return false;
    }
    if ((g.QWe.equals(paramg.field_appId)) || (g.QWg.equals(paramg.field_appId))) {
      Log.i("MicroMsg.AppInfoStorage", "delete appinfo: %s, %s, %s, %s, %s", new Object[] { paramg.field_appId, paramg.field_appName, Integer.valueOf(paramg.field_serviceShowFlag), Integer.valueOf(paramg.field_appInfoFlag), Util.getStack() });
    }
    aHy(paramg.field_appId);
    boolean bool = super.delete(paramg, false, paramVarArgs);
    if (bool) {
      doNotify(paramg.field_appId, 5, paramg.field_appId);
    }
    AppMethodBeat.o(151740);
    return bool;
  }
  
  public final g bqc(String paramString)
  {
    AppMethodBeat.i(151742);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppInfoStorage", "appId is null");
      AppMethodBeat.o(151742);
      return null;
    }
    g localg = (g)this.QWu.aX(paramString);
    if (localg != null) {}
    while ((localg != null) && (!Util.isNullOrNil(localg.field_appId)))
    {
      AppMethodBeat.o(151742);
      return localg;
      localg = null;
    }
    localg = new g();
    localg.field_appId = paramString;
    if (super.get(localg, new String[0]))
    {
      q(localg);
      AppMethodBeat.o(151742);
      return localg;
    }
    AppMethodBeat.o(151742);
    return null;
  }
  
  public final boolean d(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(151747);
    if ((paramString == null) || (paramString.length() == 0) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      Log.e("MicroMsg.AppInfoStorage", "saveIcon, invalid argument");
      AppMethodBeat.o(151747);
      return false;
    }
    Object localObject1 = ho(paramString, paramInt);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.AppInfoStorage", "saveIcon fail, iconPath is null");
      AppMethodBeat.o(151747);
      return false;
    }
    Object localObject2 = new q((String)localObject1);
    if (((q)localObject2).ifE()) {
      ((q)localObject2).cFq();
    }
    localObject1 = null;
    try
    {
      localObject2 = u.an((q)localObject2);
      localObject1 = localObject2;
      ((OutputStream)localObject2).write(paramArrayOfByte);
      localObject1 = localObject2;
      ((OutputStream)localObject2).close();
      localObject1 = localObject2;
      doNotify(paramString);
      AppMethodBeat.o(151747);
      return true;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.AppInfoStorage", paramString, "", new Object[0]);
      Log.e("MicroMsg.AppInfoStorage", "saveIcon, exception, e = " + paramString.getMessage());
      if (localObject1 == null) {}
    }
    try
    {
      ((OutputStream)localObject1).close();
      label190:
      AppMethodBeat.o(151747);
      return false;
    }
    catch (IOException paramString)
    {
      break label190;
    }
  }
  
  public final List<String> hhx()
  {
    AppMethodBeat.i(151741);
    Log.d("MicroMsg.AppInfoStorage", "getNullOpenIdList, maxCount = -1");
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = rawQuery("select appId from AppInfo where openId is NULL ", new String[0]);
    if (localCursor == null)
    {
      Log.e("MicroMsg.AppInfoStorage", "get null cursor");
      AppMethodBeat.o(151741);
      return localArrayList;
    }
    int i = localCursor.getCount();
    if (i <= 0)
    {
      Log.w("MicroMsg.AppInfoStorage", "getNullOpenIdList fail, cursor count = ".concat(String.valueOf(i)));
      localCursor.close();
      AppMethodBeat.o(151741);
      return localArrayList;
    }
    if (localCursor.moveToFirst()) {
      while (!localCursor.isAfterLast())
      {
        i = localCursor.getColumnIndex("appId");
        if (i >= 0)
        {
          String str = localCursor.getString(i);
          if (!Util.isNullOrNil(str)) {
            localArrayList.add(str);
          }
        }
        localCursor.moveToNext();
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(151741);
    return localArrayList;
  }
  
  public final Cursor hhy()
  {
    AppMethodBeat.i(151744);
    Cursor localCursor = rawQuery("select * from AppInfo where appType like '%1,%'", new String[0]);
    if (localCursor == null)
    {
      Log.e("MicroMsg.AppInfoStorage", "getGameApp : cursor is null");
      AppMethodBeat.o(151744);
      return null;
    }
    AppMethodBeat.o(151744);
    return localCursor;
  }
  
  public final Cursor iL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151743);
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
      Log.e("MicroMsg.AppInfoStorage", "getServiceByAppInfoFlagAndShowFlag : cursor is null");
      AppMethodBeat.o(151743);
      return null;
    }
    AppMethodBeat.o(151743);
    return localObject;
  }
  
  public final boolean r(g paramg)
  {
    AppMethodBeat.i(151738);
    if ((paramg == null) || (Util.isNullOrNil(paramg.field_appId)))
    {
      AppMethodBeat.o(151738);
      return false;
    }
    if ((g.QWe.equals(paramg.field_appId)) || (g.QWg.equals(paramg.field_appId))) {
      Log.i("MicroMsg.AppInfoStorage", "insert appinfo: %s, %s, %s, %s, %s", new Object[] { paramg.field_appId, paramg.field_appName, Integer.valueOf(paramg.field_serviceShowFlag), Integer.valueOf(paramg.field_appInfoFlag), Util.getStack() });
    }
    if (super.insertNotify(paramg, false))
    {
      doNotify(paramg.field_appId, 2, paramg.field_appId);
      q(paramg);
      AppMethodBeat.o(151738);
      return true;
    }
    AppMethodBeat.o(151738);
    return false;
  }
  
  public final boolean u(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(151746);
    if ((paramString == null) || (paramString.length() == 0) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      Log.e("MicroMsg.AppInfoStorage", "saveIcon : invalid argument");
      AppMethodBeat.o(151746);
      return false;
    }
    Object localObject = ho(paramString, 1);
    if (localObject == null)
    {
      Log.e("MicroMsg.AppInfoStorage", "saveIcon fail, iconPath is null");
      AppMethodBeat.o(151746);
      return false;
    }
    localObject = new q((String)localObject);
    if (((q)localObject).ifE()) {
      ((q)localObject).cFq();
    }
    try
    {
      localObject = u.an((q)localObject);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      ((OutputStream)localObject).close();
      doNotify(paramString);
      AppMethodBeat.o(151746);
      return true;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.AppInfoStorage", paramString, "", new Object[0]);
      Log.e("MicroMsg.AppInfoStorage", "saveIcon : compress occurs an exception");
      AppMethodBeat.o(151746);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.j
 * JD-Core Version:    0.7.0.1
 */