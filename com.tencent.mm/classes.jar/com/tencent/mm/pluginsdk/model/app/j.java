package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.g.c.y;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public final class j
  extends com.tencent.mm.sdk.e.j<g>
{
  public static final String[] SQL_CREATE;
  public final f<String, g> Ffo;
  
  static
  {
    AppMethodBeat.i(151751);
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(g.info, "AppInfo") };
    AppMethodBeat.o(151751);
  }
  
  public j(e parame)
  {
    super(parame, g.info, "AppInfo", y.INDEX_CREATE);
    AppMethodBeat.i(151735);
    this.Ffo = new c(50);
    parame = new g();
    parame.field_appId = "wx4310bbd51be7d979";
    if (!super.get(parame, new String[0]))
    {
      parame = new g();
      parame.field_appId = "wx4310bbd51be7d979";
      parame.field_appName = "weixinfile";
      parame.field_packageName = "com.tencent.mm.openapi";
      parame.field_status = -1;
      super.insert(parame);
    }
    AppMethodBeat.o(151735);
  }
  
  private void alb(String paramString)
  {
    AppMethodBeat.i(151737);
    if (!bu.isNullOrNil(paramString)) {
      this.Ffo.remove(paramString);
    }
    AppMethodBeat.o(151737);
  }
  
  public static String gh(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(151745);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.AppInfoStorage", "getIconPath : invalid argument");
      AppMethodBeat.o(151745);
      return null;
    }
    String str = a.dBd();
    k localk1 = new k(str);
    k localk2;
    if (!localk1.exists()) {
      if (!localk1.fTg().exists())
      {
        localk2 = localk1.fTg();
        k localk3 = new k(w.B(localk2.fTh()) + System.currentTimeMillis());
        if (localk3.mkdirs()) {
          localk3.ag(localk2);
        }
      }
      else
      {
        if ((localk1.mkdirs()) && (localk1.isDirectory())) {
          break label191;
        }
        ae.e("MicroMsg.AppInfoStorage", "mkdir error. %s", new Object[] { str });
      }
    }
    while (i == 0)
    {
      AppMethodBeat.o(151745);
      return null;
      ae.e("MicroMsg.AppInfoStorage", "mkdir error, %s", new Object[] { w.B(localk2.fTh()) });
      continue;
      label191:
      i = 1;
    }
    switch (paramInt)
    {
    default: 
      ae.e("MicroMsg.AppInfoStorage", "getIconPath, unknown iconType = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(151745);
      return null;
    case 1: 
      paramString = a.dBd() + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) + ".png";
      AppMethodBeat.o(151745);
      return paramString;
    case 2: 
      paramString = a.dBd() + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) + "_wm.png";
      AppMethodBeat.o(151745);
      return paramString;
    case 3: 
      paramString = a.dBd() + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) + "_sg.png";
      AppMethodBeat.o(151745);
      return paramString;
    case 5: 
      paramString = a.dBd() + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) + "_sl.png";
      AppMethodBeat.o(151745);
      return paramString;
    }
    paramString = a.dBd() + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) + "_sp.png";
    AppMethodBeat.o(151745);
    return paramString;
  }
  
  private void p(g paramg)
  {
    AppMethodBeat.i(151736);
    if ((paramg == null) || (paramg.field_appId == null))
    {
      AppMethodBeat.o(151736);
      return;
    }
    this.Ffo.q(paramg.field_appId, paramg);
    AppMethodBeat.o(151736);
  }
  
  public final boolean a(g paramg, String... paramVarArgs)
  {
    AppMethodBeat.i(151739);
    if ((paramg == null) || (bu.isNullOrNil(paramg.field_appId)))
    {
      AppMethodBeat.o(151739);
      return false;
    }
    if ((g.Ffa.equals(paramg.field_appId)) || (g.Ffc.equals(paramg.field_appId))) {
      ae.i("MicroMsg.AppInfoStorage", "update appinfo: %s, %s, %s, %s, %s", new Object[] { paramg.field_appId, paramg.field_appName, Integer.valueOf(paramg.field_serviceShowFlag), Integer.valueOf(paramg.field_appInfoFlag), bu.fpN() });
    }
    alb(paramg.field_appId);
    boolean bool = super.updateNotify(paramg, false, paramVarArgs);
    if (bool) {
      doNotify(paramg.field_appId, 3, paramg.field_appId);
    }
    AppMethodBeat.o(151739);
    return bool;
  }
  
  public final g aNg(String paramString)
  {
    AppMethodBeat.i(151742);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.AppInfoStorage", "appId is null");
      AppMethodBeat.o(151742);
      return null;
    }
    g localg = (g)this.Ffo.aL(paramString);
    if (localg != null) {}
    while ((localg != null) && (!bu.isNullOrNil(localg.field_appId)))
    {
      AppMethodBeat.o(151742);
      return localg;
      localg = null;
    }
    localg = new g();
    localg.field_appId = paramString;
    if (super.get(localg, new String[0]))
    {
      p(localg);
      AppMethodBeat.o(151742);
      return localg;
    }
    AppMethodBeat.o(151742);
    return null;
  }
  
  public final boolean b(g paramg, String... paramVarArgs)
  {
    AppMethodBeat.i(151740);
    if ((paramg == null) || (bu.isNullOrNil(paramg.field_appId)))
    {
      AppMethodBeat.o(151740);
      return false;
    }
    if ((g.Ffa.equals(paramg.field_appId)) || (g.Ffc.equals(paramg.field_appId))) {
      ae.i("MicroMsg.AppInfoStorage", "delete appinfo: %s, %s, %s, %s, %s", new Object[] { paramg.field_appId, paramg.field_appName, Integer.valueOf(paramg.field_serviceShowFlag), Integer.valueOf(paramg.field_appInfoFlag), bu.fpN() });
    }
    alb(paramg.field_appId);
    boolean bool = super.delete(paramg, false, paramVarArgs);
    if (bool) {
      doNotify(paramg.field_appId, 5, paramg.field_appId);
    }
    AppMethodBeat.o(151740);
    return bool;
  }
  
  public final boolean d(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(151747);
    if ((paramString == null) || (paramString.length() == 0) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ae.e("MicroMsg.AppInfoStorage", "saveIcon, invalid argument");
      AppMethodBeat.o(151747);
      return false;
    }
    Object localObject1 = gh(paramString, paramInt);
    if (localObject1 == null)
    {
      ae.e("MicroMsg.AppInfoStorage", "saveIcon fail, iconPath is null");
      AppMethodBeat.o(151747);
      return false;
    }
    Object localObject2 = new k((String)localObject1);
    if (((k)localObject2).exists()) {
      ((k)localObject2).delete();
    }
    localObject1 = null;
    try
    {
      localObject2 = o.aj((k)localObject2);
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
      ae.printErrStackTrace("MicroMsg.AppInfoStorage", paramString, "", new Object[0]);
      ae.e("MicroMsg.AppInfoStorage", "saveIcon, exception, e = " + paramString.getMessage());
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
  
  public final List<String> fdL()
  {
    AppMethodBeat.i(151741);
    ae.d("MicroMsg.AppInfoStorage", "getNullOpenIdList, maxCount = -1");
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = rawQuery("select appId from AppInfo where openId is NULL ", new String[0]);
    if (localCursor == null)
    {
      ae.e("MicroMsg.AppInfoStorage", "get null cursor");
      AppMethodBeat.o(151741);
      return localArrayList;
    }
    int i = localCursor.getCount();
    if (i <= 0)
    {
      ae.w("MicroMsg.AppInfoStorage", "getNullOpenIdList fail, cursor count = ".concat(String.valueOf(i)));
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
          if (!bu.isNullOrNil(str)) {
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
  
  public final Cursor fdM()
  {
    AppMethodBeat.i(151744);
    Cursor localCursor = rawQuery("select * from AppInfo where appType like '%1,%'", new String[0]);
    if (localCursor == null)
    {
      ae.e("MicroMsg.AppInfoStorage", "getGameApp : cursor is null");
      AppMethodBeat.o(151744);
      return null;
    }
    AppMethodBeat.o(151744);
    return localCursor;
  }
  
  public final Cursor gV(int paramInt1, int paramInt2)
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
      ae.e("MicroMsg.AppInfoStorage", "getServiceByAppInfoFlagAndShowFlag : cursor is null");
      AppMethodBeat.o(151743);
      return null;
    }
    AppMethodBeat.o(151743);
    return localObject;
  }
  
  public final boolean q(g paramg)
  {
    AppMethodBeat.i(151738);
    if ((paramg == null) || (bu.isNullOrNil(paramg.field_appId)))
    {
      AppMethodBeat.o(151738);
      return false;
    }
    if ((g.Ffa.equals(paramg.field_appId)) || (g.Ffc.equals(paramg.field_appId))) {
      ae.i("MicroMsg.AppInfoStorage", "insert appinfo: %s, %s, %s, %s, %s", new Object[] { paramg.field_appId, paramg.field_appName, Integer.valueOf(paramg.field_serviceShowFlag), Integer.valueOf(paramg.field_appInfoFlag), bu.fpN() });
    }
    if (super.insertNotify(paramg, false))
    {
      doNotify(paramg.field_appId, 2, paramg.field_appId);
      p(paramg);
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
      ae.e("MicroMsg.AppInfoStorage", "saveIcon : invalid argument");
      AppMethodBeat.o(151746);
      return false;
    }
    Object localObject = gh(paramString, 1);
    if (localObject == null)
    {
      ae.e("MicroMsg.AppInfoStorage", "saveIcon fail, iconPath is null");
      AppMethodBeat.o(151746);
      return false;
    }
    localObject = new k((String)localObject);
    if (((k)localObject).exists()) {
      ((k)localObject).delete();
    }
    try
    {
      localObject = o.aj((k)localObject);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      ((OutputStream)localObject).close();
      doNotify(paramString);
      AppMethodBeat.o(151746);
      return true;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.AppInfoStorage", paramString, "", new Object[0]);
      ae.e("MicroMsg.AppInfoStorage", "saveIcon : compress occurs an exception");
      AppMethodBeat.o(151746);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.j
 * JD-Core Version:    0.7.0.1
 */