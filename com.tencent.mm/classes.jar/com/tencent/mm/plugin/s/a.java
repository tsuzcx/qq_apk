package com.tencent.mm.plugin.s;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.y;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.pluginsdk.model.app.ad;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.e.3;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ec;
import com.tencent.mm.protocal.protobuf.ed;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
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
  private static HashMap<Integer, h.b> baseDBFactories;
  private static volatile a vwq;
  private d vwr;
  private com.tencent.mm.pluginsdk.model.app.f vws;
  private com.tencent.mm.pluginsdk.model.app.i vwt;
  private j vwu;
  private l vwv;
  private n vww;
  private com.tencent.mm.pluginsdk.model.app.e vwx;
  private com.tencent.mm.sdk.b.c vwy;
  
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
    this.vwy = new a.4(this);
    a.a.a(new com.tencent.mm.plugin.s.a.a()
    {
      public final Cursor C(int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(151504);
        j localj = a.dny();
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
          ac.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
          AppMethodBeat.o(151504);
          return null;
        }
        AppMethodBeat.o(151504);
        return paramAnonymousArrayOfInt;
      }
      
      public final Bitmap a(String paramAnonymousString, int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(151505);
        a.dny();
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          ac.e("MicroMsg.AppInfoStorage", "getIcon : invalid argument");
          AppMethodBeat.o(151505);
          return null;
        }
        if (paramAnonymousString.equals("wx7fa037cc7dfabad5"))
        {
          paramAnonymousString = BitmapFactory.decodeResource(ai.getContext().getResources(), 2131231045);
          AppMethodBeat.o(151505);
          return paramAnonymousString;
        }
        paramAnonymousString = j.fB(paramAnonymousString, paramAnonymousInt);
        if (!com.tencent.mm.vfs.i.eA(paramAnonymousString))
        {
          ac.e("MicroMsg.AppInfoStorage", "icon does not exist, iconPath = " + paramAnonymousString + ", iconType = " + paramAnonymousInt);
          AppMethodBeat.o(151505);
          return null;
        }
        paramAnonymousString = BackwardSupportUtil.b.n(paramAnonymousString, paramAnonymousFloat);
        AppMethodBeat.o(151505);
        return paramAnonymousString;
      }
      
      public final void aH(LinkedList<String> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(151512);
        a.dnx().bi(paramAnonymousLinkedList);
        AppMethodBeat.o(151512);
      }
      
      public final com.tencent.mm.pluginsdk.model.app.g aoV(String paramAnonymousString)
      {
        AppMethodBeat.i(151501);
        if (!com.tencent.mm.kernel.g.agM())
        {
          AppMethodBeat.o(151501);
          return null;
        }
        paramAnonymousString = a.dny().aGk(paramAnonymousString);
        AppMethodBeat.o(151501);
        return paramAnonymousString;
      }
      
      public final com.tencent.mm.pluginsdk.model.app.g aoW(String paramAnonymousString)
      {
        AppMethodBeat.i(151502);
        a.dnx();
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          AppMethodBeat.o(151502);
          return null;
        }
        Object localObject1 = new LinkedList();
        ((List)localObject1).add(paramAnonymousString);
        localObject1 = new ad((List)localObject1);
        Object localObject2 = new b.a();
        ((b.a)localObject2).hvt = new ec();
        ((b.a)localObject2).hvu = new ed();
        ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/appcenter";
        ((b.a)localObject2).funcId = 452;
        ((b.a)localObject2).reqCmdId = 0;
        ((b.a)localObject2).respCmdId = 0;
        localObject2 = ((b.a)localObject2).aAz();
        Object localObject3 = (ec)((com.tencent.mm.ak.b)localObject2).hvr.hvw;
        byte[] arrayOfByte = ((ad)localObject1).eKJ();
        if (arrayOfByte != null) {
          ((ec)localObject3).ReqBuf = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
        }
        ((ec)localObject3).ndI = 7;
        localObject3 = y.e((com.tencent.mm.ak.b)localObject2);
        if (localObject3 == null)
        {
          ac.e("MicroMsg.AppInfoService", "getSync resp == null");
          AppMethodBeat.o(151502);
          return null;
        }
        ac.e("MicroMsg.AppInfoService", "call getAppInfoList cgi result, errType = %d, errCode = %d", new Object[] { Integer.valueOf(((c.a)localObject3).errType), Integer.valueOf(((c.a)localObject3).errCode) });
        if ((((c.a)localObject3).errType != 0) || (((c.a)localObject3).errCode != 0))
        {
          AppMethodBeat.o(151502);
          return null;
        }
        ((ad)localObject1).ca(z.a(((ed)((c.a)localObject3).hvj).DQM));
        ((ad)localObject1).onGYNetEnd(0, ((c.a)localObject3).errType, ((c.a)localObject3).errCode, ((c.a)localObject3).errMsg, (com.tencent.mm.network.q)localObject2, new byte[0]);
        localObject1 = a.a.dnF();
        if (localObject1 == null)
        {
          ac.e("MicroMsg.AppInfoService", "getISubCorePluginBase() == null");
          AppMethodBeat.o(151502);
          return null;
        }
        paramAnonymousString = ((com.tencent.mm.plugin.s.a.a)localObject1).aoV(paramAnonymousString);
        AppMethodBeat.o(151502);
        return paramAnonymousString;
      }
      
      public final void aoX(String paramAnonymousString)
      {
        AppMethodBeat.i(151507);
        a.dnx().aGj(paramAnonymousString);
        AppMethodBeat.o(151507);
      }
      
      public final Cursor dnC()
      {
        AppMethodBeat.i(151503);
        Cursor localCursor = a.dny().rawQuery("select * from AppInfo where status = 5 order by modifyTime asc", new String[0]);
        if (localCursor == null)
        {
          ac.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
          AppMethodBeat.o(151503);
          return null;
        }
        AppMethodBeat.o(151503);
        return localCursor;
      }
      
      public final j dnD()
      {
        AppMethodBeat.i(151511);
        j localj = a.dny();
        AppMethodBeat.o(151511);
        return localj;
      }
      
      public final Cursor dnE()
      {
        AppMethodBeat.i(151514);
        Object localObject = a.dny();
        StringBuilder localStringBuilder = new StringBuilder(256);
        localStringBuilder.append("select * from AppInfo");
        localStringBuilder.append(" where ");
        localStringBuilder.append("serviceAppType > 0");
        localObject = ((j)localObject).rawQuery(localStringBuilder.toString(), new String[0]);
        if (localObject == null)
        {
          ac.e("MicroMsg.AppInfoStorage", "getAllServices : cursor is null");
          AppMethodBeat.o(151514);
          return null;
        }
        ac.d("MicroMsg.AppInfoStorage", "getAllServices count = %d", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
        AppMethodBeat.o(151514);
        return localObject;
      }
      
      public final void e(com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        AppMethodBeat.i(151508);
        j localj = a.dny();
        if ((paramAnonymousg != null) && (paramAnonymousg.field_status != 5))
        {
          paramAnonymousg.field_status = 3;
          ac.i("MicroMsg.AppInfoStorage", "setBlack package name = %s", new Object[] { paramAnonymousg.field_packageName });
          localj.a(paramAnonymousg, new String[0]);
        }
        AppMethodBeat.o(151508);
      }
      
      public final void ej(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(151506);
        a.dnw().fz(paramAnonymousString, paramAnonymousInt);
        AppMethodBeat.o(151506);
      }
      
      public final void f(com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        AppMethodBeat.i(151509);
        j localj = a.dny();
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
        a.dny().a(paramAnonymousg, new String[0]);
        AppMethodBeat.o(151510);
      }
      
      public final Cursor gC(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(151513);
        Cursor localCursor = a.dny().gC(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(151513);
        return localCursor;
      }
    });
    AppMethodBeat.o(151516);
  }
  
  public static d bEO()
  {
    AppMethodBeat.i(151520);
    com.tencent.mm.kernel.g.agP().afT();
    if (dnt().vwr == null) {
      dnt().vwr = new d(com.tencent.mm.kernel.g.agR().ghG);
    }
    d locald = dnt().vwr;
    AppMethodBeat.o(151520);
    return locald;
  }
  
  public static n dnA()
  {
    AppMethodBeat.i(151525);
    com.tencent.mm.kernel.g.agP().afT();
    if (dnt().vww == null) {
      dnt().vww = new n();
    }
    n localn = dnt().vww;
    AppMethodBeat.o(151525);
    return localn;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.e dnB()
  {
    AppMethodBeat.i(151526);
    com.tencent.mm.kernel.g.agP().afT();
    if (dnt().vwx == null) {
      dnt().vwx = new com.tencent.mm.pluginsdk.model.app.e();
    }
    com.tencent.mm.pluginsdk.model.app.e locale = dnt().vwx;
    AppMethodBeat.o(151526);
    return locale;
  }
  
  public static a dnt()
  {
    AppMethodBeat.i(151517);
    if (vwq == null) {}
    try
    {
      if (vwq == null) {
        vwq = new a();
      }
      a locala = vwq;
      AppMethodBeat.o(151517);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(151517);
    }
  }
  
  public static String dnu()
  {
    AppMethodBeat.i(151519);
    String str = com.tencent.mm.kernel.g.agR().ghC + "openapi/";
    AppMethodBeat.o(151519);
    return str;
  }
  
  public static String dnv()
  {
    AppMethodBeat.i(192639);
    String str = com.tencent.mm.kernel.g.agR().ghC + "openapi_cache/";
    AppMethodBeat.o(192639);
    return str;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.f dnw()
  {
    AppMethodBeat.i(151521);
    com.tencent.mm.kernel.g.agP().afT();
    if (dnt().vws == null) {
      dnt().vws = new com.tencent.mm.pluginsdk.model.app.f();
    }
    com.tencent.mm.pluginsdk.model.app.f localf = dnt().vws;
    AppMethodBeat.o(151521);
    return localf;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.i dnx()
  {
    AppMethodBeat.i(151522);
    com.tencent.mm.kernel.g.agP().afT();
    if (dnt().vwt == null) {
      dnt().vwt = new com.tencent.mm.pluginsdk.model.app.i();
    }
    com.tencent.mm.pluginsdk.model.app.i locali = dnt().vwt;
    AppMethodBeat.o(151522);
    return locali;
  }
  
  public static j dny()
  {
    AppMethodBeat.i(151523);
    com.tencent.mm.kernel.g.agP().afT();
    if (dnt().vwu == null) {
      dnt().vwu = new j(com.tencent.mm.kernel.g.agR().ghG);
    }
    j localj = dnt().vwu;
    AppMethodBeat.o(151523);
    return localj;
  }
  
  public static l dnz()
  {
    AppMethodBeat.i(151524);
    com.tencent.mm.kernel.g.agP().afT();
    if (dnt().vwv == null) {
      dnt().vwv = new l(com.tencent.mm.kernel.g.agR().ghG);
    }
    l locall = dnt().vwv;
    AppMethodBeat.o(151524);
    return locall;
  }
  
  public final List<String> agY()
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
    com.tencent.mm.model.ag.a.hnu = dnx();
    com.tencent.mm.sdk.b.a.GpY.c(this.vwy);
    AppMethodBeat.o(151527);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151528);
    Object localObject = dnt().vwt;
    if (localObject != null) {
      dnB().b(7, (u)localObject);
    }
    localObject = dnt().vws;
    if (localObject != null)
    {
      ((com.tencent.mm.pluginsdk.model.app.f)localObject).DhO.clear();
      ((com.tencent.mm.pluginsdk.model.app.f)localObject).fZS.clear();
      ((com.tencent.mm.pluginsdk.model.app.f)localObject).DhP.clear();
    }
    localObject = dnt().vww;
    if (localObject != null)
    {
      ac.d("MicroMsg.AppSettingService", "stop service");
      ((n)localObject).Din.clear();
      dnB().b(1, (u)localObject);
    }
    if (this.vwx != null)
    {
      localObject = this.vwx;
      com.tencent.mm.kernel.g.agQ().ghe.b(452, (com.tencent.mm.ak.g)localObject);
      ap.f(new e.3((com.tencent.mm.pluginsdk.model.app.e)localObject));
    }
    if (dnt().vwu != null) {
      dnt().vwu.Dig.clear();
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.vwy);
    ac.i("XPinOpenApi", "onAccountRelease");
    AppMethodBeat.o(151528);
  }
  
  public void onDataBaseClosed(h paramh1, h paramh2)
  {
    AppMethodBeat.i(151529);
    this.vwr = null;
    this.vwu = null;
    ac.i("XPinOpenApi", "onDataBaseClosed");
    AppMethodBeat.o(151529);
  }
  
  public void onDataBaseOpened(h paramh1, h paramh2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.s.a
 * JD-Core Version:    0.7.0.1
 */