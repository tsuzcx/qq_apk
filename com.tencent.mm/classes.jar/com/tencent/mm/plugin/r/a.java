package com.tencent.mm.plugin.r;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ab;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.jh;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.r.a.a.a;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.pluginsdk.model.app.e.3;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storagebase.h;
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
  private static volatile a ANq;
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.pluginsdk.model.app.d ANr;
  private com.tencent.mm.pluginsdk.model.app.f ANs;
  private com.tencent.mm.pluginsdk.model.app.i ANt;
  private j ANu;
  private l ANv;
  private n ANw;
  private com.tencent.mm.pluginsdk.model.app.e ANx;
  private IListener ANy;
  
  static
  {
    AppMethodBeat.i(151530);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("APPATTACHINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.pluginsdk.model.app.d.SQL_CREATE;
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
    this.ANy = new IListener() {};
    a.a.a(new com.tencent.mm.plugin.r.a.a()
    {
      public final Cursor H(int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(151504);
        j localj = a.eAS();
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
        a.eAS();
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          Log.e("MicroMsg.AppInfoStorage", "getIcon : invalid argument");
          AppMethodBeat.o(151505);
          return null;
        }
        if (paramAnonymousString.equals("wx7fa037cc7dfabad5"))
        {
          paramAnonymousString = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), 2131231078);
          AppMethodBeat.o(151505);
          return paramAnonymousString;
        }
        paramAnonymousString = j.gF(paramAnonymousString, paramAnonymousInt);
        if (!com.tencent.mm.vfs.s.YS(paramAnonymousString))
        {
          Log.e("MicroMsg.AppInfoStorage", "icon does not exist, iconPath = " + paramAnonymousString + ", iconType = " + paramAnonymousInt);
          AppMethodBeat.o(151505);
          return null;
        }
        paramAnonymousString = BackwardSupportUtil.BitmapFactory.decodeFile(paramAnonymousString, paramAnonymousFloat);
        AppMethodBeat.o(151505);
        return paramAnonymousString;
      }
      
      public final com.tencent.mm.pluginsdk.model.app.g aJw(String paramAnonymousString)
      {
        AppMethodBeat.i(151501);
        if (!com.tencent.mm.kernel.g.aAc())
        {
          AppMethodBeat.o(151501);
          return null;
        }
        paramAnonymousString = a.eAS().bdG(paramAnonymousString);
        AppMethodBeat.o(151501);
        return paramAnonymousString;
      }
      
      public final com.tencent.mm.pluginsdk.model.app.g aJx(String paramAnonymousString)
      {
        AppMethodBeat.i(151502);
        a.eAR();
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          AppMethodBeat.o(151502);
          return null;
        }
        Object localObject1 = new LinkedList();
        ((List)localObject1).add(paramAnonymousString);
        localObject1 = new ac((List)localObject1);
        Object localObject2 = new d.a();
        ((d.a)localObject2).iLN = new et();
        ((d.a)localObject2).iLO = new eu();
        ((d.a)localObject2).uri = "/cgi-bin/micromsg-bin/appcenter";
        ((d.a)localObject2).funcId = 452;
        ((d.a)localObject2).iLP = 0;
        ((d.a)localObject2).respCmdId = 0;
        localObject2 = ((d.a)localObject2).aXF();
        Object localObject3 = (et)((com.tencent.mm.ak.d)localObject2).iLK.iLR;
        byte[] arrayOfByte = ((ac)localObject1).gmB();
        if (arrayOfByte != null) {
          ((et)localObject3).ReqBuf = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
        }
        ((et)localObject3).oUv = 7;
        localObject3 = ab.e((com.tencent.mm.ak.d)localObject2);
        if (localObject3 == null)
        {
          Log.e("MicroMsg.AppInfoService", "getSync resp == null");
          AppMethodBeat.o(151502);
          return null;
        }
        Log.e("MicroMsg.AppInfoService", "call getAppInfoList cgi result, errType = %d, errCode = %d", new Object[] { Integer.valueOf(((c.a)localObject3).errType), Integer.valueOf(((c.a)localObject3).errCode) });
        if ((((c.a)localObject3).errType != 0) || (((c.a)localObject3).errCode != 0))
        {
          AppMethodBeat.o(151502);
          return null;
        }
        ((ac)localObject1).cB(z.a(((eu)((c.a)localObject3).iLC).KIk));
        ((ac)localObject1).onGYNetEnd(0, ((c.a)localObject3).errType, ((c.a)localObject3).errCode, ((c.a)localObject3).errMsg, (com.tencent.mm.network.s)localObject2, new byte[0]);
        localObject1 = a.a.eAZ();
        if (localObject1 == null)
        {
          Log.e("MicroMsg.AppInfoService", "getISubCorePluginBase() == null");
          AppMethodBeat.o(151502);
          return null;
        }
        paramAnonymousString = ((com.tencent.mm.plugin.r.a.a)localObject1).aJw(paramAnonymousString);
        AppMethodBeat.o(151502);
        return paramAnonymousString;
      }
      
      public final String aJy(String paramAnonymousString)
      {
        AppMethodBeat.i(223698);
        a.eAS();
        paramAnonymousString = j.gF(paramAnonymousString, 1);
        AppMethodBeat.o(223698);
        return paramAnonymousString;
      }
      
      public final void aJz(String paramAnonymousString)
      {
        AppMethodBeat.i(151507);
        a.eAR().bdF(paramAnonymousString);
        AppMethodBeat.o(151507);
      }
      
      public final void bg(LinkedList<String> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(151512);
        a.eAR().bF(paramAnonymousLinkedList);
        AppMethodBeat.o(151512);
      }
      
      public final void e(com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        AppMethodBeat.i(151508);
        j localj = a.eAS();
        if ((paramAnonymousg != null) && (paramAnonymousg.field_status != 5))
        {
          paramAnonymousg.field_status = 3;
          Log.i("MicroMsg.AppInfoStorage", "setBlack package name = %s", new Object[] { paramAnonymousg.field_packageName });
          localj.a(paramAnonymousg, new String[0]);
        }
        AppMethodBeat.o(151508);
      }
      
      public final Cursor eAW()
      {
        AppMethodBeat.i(151503);
        Cursor localCursor = a.eAS().rawQuery("select * from AppInfo where status = 5 order by modifyTime asc", new String[0]);
        if (localCursor == null)
        {
          Log.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
          AppMethodBeat.o(151503);
          return null;
        }
        AppMethodBeat.o(151503);
        return localCursor;
      }
      
      public final j eAX()
      {
        AppMethodBeat.i(258496);
        j localj = a.eAS();
        AppMethodBeat.o(258496);
        return localj;
      }
      
      public final Cursor eAY()
      {
        AppMethodBeat.i(151514);
        Object localObject = a.eAS();
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
      
      public final void eZ(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(151506);
        a.eAQ().gD(paramAnonymousString, paramAnonymousInt);
        AppMethodBeat.o(151506);
      }
      
      public final void f(com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        AppMethodBeat.i(151509);
        j localj = a.eAS();
        if ((paramAnonymousg == null) || (paramAnonymousg.field_status != 3))
        {
          AppMethodBeat.o(151509);
          return;
        }
        paramAnonymousg.field_status = 4;
        localj.a(paramAnonymousg, new String[0]);
        AppMethodBeat.o(151509);
      }
      
      public final void g(com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        AppMethodBeat.i(151510);
        a.eAS().a(paramAnonymousg, new String[0]);
        AppMethodBeat.o(151510);
      }
      
      public final Cursor hG(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(151513);
        Cursor localCursor = a.eAS().hG(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(151513);
        return localCursor;
      }
    });
    AppMethodBeat.o(151516);
  }
  
  public static com.tencent.mm.pluginsdk.model.app.d cgO()
  {
    AppMethodBeat.i(151520);
    com.tencent.mm.kernel.g.aAf().azk();
    if (eAN().ANr == null) {
      eAN().ANr = new com.tencent.mm.pluginsdk.model.app.d(com.tencent.mm.kernel.g.aAh().hqK);
    }
    com.tencent.mm.pluginsdk.model.app.d locald = eAN().ANr;
    AppMethodBeat.o(151520);
    return locald;
  }
  
  public static a eAN()
  {
    AppMethodBeat.i(151517);
    if (ANq == null) {}
    try
    {
      if (ANq == null) {
        ANq = new a();
      }
      a locala = ANq;
      AppMethodBeat.o(151517);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(151517);
    }
  }
  
  public static String eAO()
  {
    AppMethodBeat.i(151519);
    String str = com.tencent.mm.kernel.g.aAh().hqG + "openapi/";
    AppMethodBeat.o(151519);
    return str;
  }
  
  public static String eAP()
  {
    AppMethodBeat.i(223700);
    String str = com.tencent.mm.kernel.g.aAh().hqG + "openapi_cache/";
    AppMethodBeat.o(223700);
    return str;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.f eAQ()
  {
    AppMethodBeat.i(151521);
    com.tencent.mm.kernel.g.aAf().azk();
    if (eAN().ANs == null) {
      eAN().ANs = new com.tencent.mm.pluginsdk.model.app.f();
    }
    com.tencent.mm.pluginsdk.model.app.f localf = eAN().ANs;
    AppMethodBeat.o(151521);
    return localf;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.i eAR()
  {
    AppMethodBeat.i(151522);
    com.tencent.mm.kernel.g.aAf().azk();
    if (eAN().ANt == null) {
      eAN().ANt = new com.tencent.mm.pluginsdk.model.app.i();
    }
    com.tencent.mm.pluginsdk.model.app.i locali = eAN().ANt;
    AppMethodBeat.o(151522);
    return locali;
  }
  
  public static j eAS()
  {
    AppMethodBeat.i(151523);
    com.tencent.mm.kernel.g.aAf().azk();
    if (eAN().ANu == null) {
      eAN().ANu = new j(com.tencent.mm.kernel.g.aAh().hqK);
    }
    j localj = eAN().ANu;
    AppMethodBeat.o(151523);
    return localj;
  }
  
  public static l eAT()
  {
    AppMethodBeat.i(151524);
    com.tencent.mm.kernel.g.aAf().azk();
    if (eAN().ANv == null) {
      eAN().ANv = new l(com.tencent.mm.kernel.g.aAh().hqK);
    }
    l locall = eAN().ANv;
    AppMethodBeat.o(151524);
    return locall;
  }
  
  public static n eAU()
  {
    AppMethodBeat.i(151525);
    com.tencent.mm.kernel.g.aAf().azk();
    if (eAN().ANw == null) {
      eAN().ANw = new n();
    }
    n localn = eAN().ANw;
    AppMethodBeat.o(151525);
    return localn;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.e eAV()
  {
    AppMethodBeat.i(151526);
    com.tencent.mm.kernel.g.aAf().azk();
    if (eAN().ANx == null) {
      eAN().ANx = new com.tencent.mm.pluginsdk.model.app.e();
    }
    com.tencent.mm.pluginsdk.model.app.e locale = eAN().ANx;
    AppMethodBeat.o(151526);
    return locale;
  }
  
  public final List<String> aAo()
  {
    AppMethodBeat.i(151518);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "openapi/", "openapi_cache/" });
    AppMethodBeat.o(151518);
    return localLinkedList;
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(151527);
    com.tencent.mm.model.am.a.iDo = eAR();
    EventCenter.instance.addListener(this.ANy);
    AppMethodBeat.o(151527);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151528);
    Object localObject = eAN().ANt;
    if (localObject != null) {
      eAV().b(7, (u)localObject);
    }
    localObject = eAN().ANs;
    if (localObject != null)
    {
      ((com.tencent.mm.pluginsdk.model.app.f)localObject).JVN.clear();
      ((com.tencent.mm.pluginsdk.model.app.f)localObject).hiK.clear();
      ((com.tencent.mm.pluginsdk.model.app.f)localObject).JVO.clear();
    }
    localObject = eAN().ANw;
    if (localObject != null)
    {
      Log.d("MicroMsg.AppSettingService", "stop service");
      ((n)localObject).JWp.clear();
      eAV().b(1, (u)localObject);
    }
    if (this.ANx != null)
    {
      localObject = this.ANx;
      com.tencent.mm.kernel.g.aAg().hqi.b(452, (com.tencent.mm.ak.i)localObject);
      MMHandlerThread.postToMainThread(new e.3((com.tencent.mm.pluginsdk.model.app.e)localObject));
    }
    if (eAN().ANu != null) {
      eAN().ANu.JWf.clear();
    }
    EventCenter.instance.removeListener(this.ANy);
    Log.i("XPinOpenApi", "onAccountRelease");
    AppMethodBeat.o(151528);
  }
  
  public void onDataBaseClosed(h paramh1, h paramh2)
  {
    AppMethodBeat.i(151529);
    this.ANr = null;
    this.ANu = null;
    Log.i("XPinOpenApi", "onDataBaseClosed");
    AppMethodBeat.o(151529);
  }
  
  public void onDataBaseOpened(h paramh1, h paramh2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.r.a
 * JD-Core Version:    0.7.0.1
 */