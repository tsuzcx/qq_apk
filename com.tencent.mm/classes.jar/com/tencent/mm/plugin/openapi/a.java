package com.tencent.mm.plugin.openapi;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.openapi.a.a.a;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.e.3;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storagebase.h.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.e, com.tencent.mm.kernel.b.c
{
  private static volatile a MDv;
  private static HashMap<Integer, h.b> baseDBFactories;
  private l MDA;
  private q MDB;
  private com.tencent.mm.pluginsdk.model.app.e MDC;
  private IListener MDD;
  private d MDw;
  private com.tencent.mm.pluginsdk.model.app.f MDx;
  private i MDy;
  private j MDz;
  
  static
  {
    AppMethodBeat.i(151530);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("APPATTACHINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return d.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("APPINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return j.SQL_CREATE;
      }
    });
    AppMethodBeat.o(151530);
  }
  
  private a()
  {
    AppMethodBeat.i(151516);
    this.MDD = new PinOpenApi.4(this, com.tencent.mm.app.f.hfK);
    a.a.a(new com.tencent.mm.plugin.openapi.a.a()
    {
      public final Cursor K(int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(151504);
        j localj = a.gxn();
        String str = "select * from AppInfo where ";
        int i = 0;
        while (i <= 0)
        {
          str = str + " status = " + paramAnonymousArrayOfInt[0];
          i += 1;
        }
        paramAnonymousArrayOfInt = localj.rawQuery(str + " order by status desc, modifyTime asc", new String[0]);
        if (paramAnonymousArrayOfInt == null)
        {
          Log.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
          AppMethodBeat.o(151504);
          return null;
        }
        AppMethodBeat.o(151504);
        return paramAnonymousArrayOfInt;
      }
      
      public final Bitmap a(String paramAnonymousString, int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(151505);
        a.gxn();
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          Log.e("MicroMsg.AppInfoStorage", "getIcon : invalid argument");
          AppMethodBeat.o(151505);
          return null;
        }
        if (paramAnonymousString.equals("wx7fa037cc7dfabad5"))
        {
          paramAnonymousString = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), c.d.app_icon);
          AppMethodBeat.o(151505);
          return paramAnonymousString;
        }
        paramAnonymousString = j.it(paramAnonymousString, paramAnonymousInt);
        if (!com.tencent.mm.vfs.y.ZC(paramAnonymousString))
        {
          Log.e("MicroMsg.AppInfoStorage", "icon does not exist, iconPath = " + paramAnonymousString + ", iconType = " + paramAnonymousInt);
          AppMethodBeat.o(151505);
          return null;
        }
        paramAnonymousString = BackwardSupportUtil.BitmapFactory.decodeFile(paramAnonymousString, paramAnonymousFloat);
        AppMethodBeat.o(151505);
        return paramAnonymousString;
      }
      
      public final g aQY(String paramAnonymousString)
      {
        AppMethodBeat.i(151501);
        if (!com.tencent.mm.kernel.h.baz())
        {
          AppMethodBeat.o(151501);
          return null;
        }
        paramAnonymousString = a.gxn().bpR(paramAnonymousString);
        AppMethodBeat.o(151501);
        return paramAnonymousString;
      }
      
      public final g aQZ(String paramAnonymousString)
      {
        AppMethodBeat.i(151502);
        a.gxm();
        paramAnonymousString = i.bpQ(paramAnonymousString);
        AppMethodBeat.o(151502);
        return paramAnonymousString;
      }
      
      public final String aRa(String paramAnonymousString)
      {
        AppMethodBeat.i(260961);
        a.gxn();
        paramAnonymousString = j.it(paramAnonymousString, 1);
        AppMethodBeat.o(260961);
        return paramAnonymousString;
      }
      
      public final void aRb(String paramAnonymousString)
      {
        AppMethodBeat.i(151507);
        a.gxm().bpP(paramAnonymousString);
        AppMethodBeat.o(151507);
      }
      
      public final void bJ(LinkedList<String> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(151512);
        a.gxm().cq(paramAnonymousLinkedList);
        AppMethodBeat.o(151512);
      }
      
      public final void e(g paramAnonymousg)
      {
        AppMethodBeat.i(151508);
        j localj = a.gxn();
        if ((paramAnonymousg != null) && (paramAnonymousg.field_status != 5))
        {
          paramAnonymousg.field_status = 3;
          Log.i("MicroMsg.AppInfoStorage", "setBlack package name = %s", new Object[] { paramAnonymousg.field_packageName });
          localj.a(paramAnonymousg, new String[0]);
        }
        AppMethodBeat.o(151508);
      }
      
      public final void f(g paramAnonymousg)
      {
        AppMethodBeat.i(151509);
        j localj = a.gxn();
        if ((paramAnonymousg == null) || (paramAnonymousg.field_status != 3))
        {
          AppMethodBeat.o(151509);
          return;
        }
        paramAnonymousg.field_status = 4;
        localj.a(paramAnonymousg, new String[0]);
        AppMethodBeat.o(151509);
      }
      
      public final void g(g paramAnonymousg)
      {
        AppMethodBeat.i(151510);
        a.gxn().a(paramAnonymousg, new String[0]);
        AppMethodBeat.o(151510);
      }
      
      public final void gt(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(151506);
        a.gxl().ir(paramAnonymousString, paramAnonymousInt);
        AppMethodBeat.o(151506);
      }
      
      public final Cursor gxr()
      {
        AppMethodBeat.i(151503);
        Cursor localCursor = a.gxn().rawQuery("select * from AppInfo where status = 5 order by modifyTime asc", new String[0]);
        if (localCursor == null)
        {
          Log.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
          AppMethodBeat.o(151503);
          return null;
        }
        AppMethodBeat.o(151503);
        return localCursor;
      }
      
      public final j gxs()
      {
        AppMethodBeat.i(369708);
        j localj = a.gxn();
        AppMethodBeat.o(369708);
        return localj;
      }
      
      public final Cursor gxt()
      {
        AppMethodBeat.i(151514);
        Object localObject = a.gxn();
        StringBuilder localStringBuilder = new StringBuilder(256);
        localStringBuilder.append("select * from AppInfo");
        localStringBuilder.append(" where ");
        localStringBuilder.append("serviceAppType > 0");
        localObject = ((j)localObject).rawQuery(localStringBuilder.toString(), new String[0]);
        if (localObject == null)
        {
          Log.e("MicroMsg.AppInfoStorage", "getAllServices : cursor is null");
          AppMethodBeat.o(151514);
          return null;
        }
        Log.d("MicroMsg.AppInfoStorage", "getAllServices count = %d", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
        AppMethodBeat.o(151514);
        return localObject;
      }
      
      public final Cursor kr(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(151513);
        Cursor localCursor = a.gxn().kr(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(151513);
        return localCursor;
      }
    });
    AppMethodBeat.o(151516);
  }
  
  public static d cWJ()
  {
    AppMethodBeat.i(151520);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (gxf().MDw == null) {
      gxf().MDw = new d(com.tencent.mm.kernel.h.baE().mCN);
    }
    d locald = gxf().MDw;
    AppMethodBeat.o(151520);
    return locald;
  }
  
  public static a gxf()
  {
    AppMethodBeat.i(151517);
    if (MDv == null) {}
    try
    {
      if (MDv == null) {
        MDv = new a();
      }
      a locala = MDv;
      AppMethodBeat.o(151517);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(151517);
    }
  }
  
  public static String gxg()
  {
    AppMethodBeat.i(151519);
    String str = com.tencent.mm.kernel.h.baE().mCJ + "openapi/";
    AppMethodBeat.o(151519);
    return str;
  }
  
  public static void gxh()
  {
    AppMethodBeat.i(260957);
    if ((!com.tencent.mm.vfs.y.ZC(gxg())) && (!com.tencent.mm.vfs.y.bDX(gxg()))) {
      Log.e("XPinOpenApi", "alvinluo checkAccOpenApiPath mkdirs failed");
    }
    AppMethodBeat.o(260957);
  }
  
  public static String gxi()
  {
    AppMethodBeat.i(260959);
    String str = gxg() + "thumb/";
    AppMethodBeat.o(260959);
    return str;
  }
  
  public static String gxj()
  {
    AppMethodBeat.i(260960);
    String str = com.tencent.mm.kernel.h.baE().mCJ + "share_img_tmp/";
    AppMethodBeat.o(260960);
    return str;
  }
  
  public static String gxk()
  {
    AppMethodBeat.i(260962);
    String str = com.tencent.mm.kernel.h.baE().mCJ + "openapi_cache/";
    AppMethodBeat.o(260962);
    return str;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.f gxl()
  {
    AppMethodBeat.i(151521);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (gxf().MDx == null) {
      gxf().MDx = new com.tencent.mm.pluginsdk.model.app.f();
    }
    com.tencent.mm.pluginsdk.model.app.f localf = gxf().MDx;
    AppMethodBeat.o(151521);
    return localf;
  }
  
  public static i gxm()
  {
    AppMethodBeat.i(151522);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (gxf().MDy == null) {
      gxf().MDy = new i();
    }
    i locali = gxf().MDy;
    AppMethodBeat.o(151522);
    return locali;
  }
  
  public static j gxn()
  {
    AppMethodBeat.i(151523);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (gxf().MDz == null) {
      gxf().MDz = new j(com.tencent.mm.kernel.h.baE().mCN);
    }
    j localj = gxf().MDz;
    AppMethodBeat.o(151523);
    return localj;
  }
  
  public static l gxo()
  {
    AppMethodBeat.i(151524);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (gxf().MDA == null) {
      gxf().MDA = new l(com.tencent.mm.kernel.h.baE().mCN);
    }
    l locall = gxf().MDA;
    AppMethodBeat.o(151524);
    return locall;
  }
  
  public static q gxp()
  {
    AppMethodBeat.i(151525);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (gxf().MDB == null) {
      gxf().MDB = new q();
    }
    q localq = gxf().MDB;
    AppMethodBeat.o(151525);
    return localq;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.e gxq()
  {
    AppMethodBeat.i(151526);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (gxf().MDC == null) {
      gxf().MDC = new com.tencent.mm.pluginsdk.model.app.e();
    }
    com.tencent.mm.pluginsdk.model.app.e locale = gxf().MDC;
    AppMethodBeat.o(151526);
    return locale;
  }
  
  public final List<String> baM()
  {
    AppMethodBeat.i(151518);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "openapi/", "openapi_cache/", "share_img_tmp/" });
    AppMethodBeat.o(151518);
    return localLinkedList;
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(151527);
    com.tencent.mm.model.am.a.okN = gxm();
    this.MDD.alive();
    AppMethodBeat.o(151527);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151528);
    Object localObject = gxf().MDy;
    if (localObject != null) {
      gxq().b(7, (com.tencent.mm.pluginsdk.model.app.y)localObject);
    }
    localObject = gxf().MDx;
    if (localObject != null)
    {
      ((com.tencent.mm.pluginsdk.model.app.f)localObject).XRX.clear();
      ((com.tencent.mm.pluginsdk.model.app.f)localObject).muZ.clear();
      ((com.tencent.mm.pluginsdk.model.app.f)localObject).XRY.clear();
    }
    localObject = gxf().MDB;
    if (localObject != null)
    {
      Log.d("MicroMsg.AppSettingService", "stop service");
      ((q)localObject).XSF.clear();
      gxq().b(1, (com.tencent.mm.pluginsdk.model.app.y)localObject);
    }
    if (this.MDC != null)
    {
      localObject = this.MDC;
      com.tencent.mm.kernel.h.baD().mCm.b(452, (com.tencent.mm.am.h)localObject);
      MMHandlerThread.postToMainThread(new e.3((com.tencent.mm.pluginsdk.model.app.e)localObject));
    }
    if (gxf().MDz != null) {
      gxf().MDz.XSr.clear();
    }
    this.MDD.dead();
    Log.i("XPinOpenApi", "onAccountRelease");
    AppMethodBeat.o(151528);
  }
  
  public void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(151529);
    this.MDw = null;
    this.MDz = null;
    Log.i("XPinOpenApi", "onDataBaseClosed");
    AppMethodBeat.o(151529);
  }
  
  public void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.openapi.a
 * JD-Core Version:    0.7.0.1
 */