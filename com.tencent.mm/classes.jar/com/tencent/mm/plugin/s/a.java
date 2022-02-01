package com.tencent.mm.plugin.s;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.y;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.e.3;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eg;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.o;
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
  private static volatile a wRv;
  private l wRA;
  private n wRB;
  private com.tencent.mm.pluginsdk.model.app.e wRC;
  private com.tencent.mm.sdk.b.c wRD;
  private d wRw;
  private com.tencent.mm.pluginsdk.model.app.f wRx;
  private i wRy;
  private j wRz;
  
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
    this.wRD = new a.4(this);
    com.tencent.mm.plugin.s.a.a.a.a(new com.tencent.mm.plugin.s.a.a()
    {
      public final Cursor D(int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(151504);
        j localj = a.dBg();
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
          ae.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
          AppMethodBeat.o(151504);
          return null;
        }
        AppMethodBeat.o(151504);
        return paramAnonymousArrayOfInt;
      }
      
      public final Bitmap a(String paramAnonymousString, int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(151505);
        a.dBg();
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          ae.e("MicroMsg.AppInfoStorage", "getIcon : invalid argument");
          AppMethodBeat.o(151505);
          return null;
        }
        if (paramAnonymousString.equals("wx7fa037cc7dfabad5"))
        {
          paramAnonymousString = BitmapFactory.decodeResource(ak.getContext().getResources(), 2131231045);
          AppMethodBeat.o(151505);
          return paramAnonymousString;
        }
        paramAnonymousString = j.gh(paramAnonymousString, paramAnonymousInt);
        if (!o.fB(paramAnonymousString))
        {
          ae.e("MicroMsg.AppInfoStorage", "icon does not exist, iconPath = " + paramAnonymousString + ", iconType = " + paramAnonymousInt);
          AppMethodBeat.o(151505);
          return null;
        }
        paramAnonymousString = BackwardSupportUtil.b.p(paramAnonymousString, paramAnonymousFloat);
        AppMethodBeat.o(151505);
        return paramAnonymousString;
      }
      
      public final void aJ(LinkedList<String> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(151512);
        a.dBf().bk(paramAnonymousLinkedList);
        AppMethodBeat.o(151512);
      }
      
      public final com.tencent.mm.pluginsdk.model.app.g avk(String paramAnonymousString)
      {
        AppMethodBeat.i(151501);
        if (!com.tencent.mm.kernel.g.ajM())
        {
          AppMethodBeat.o(151501);
          return null;
        }
        paramAnonymousString = a.dBg().aNg(paramAnonymousString);
        AppMethodBeat.o(151501);
        return paramAnonymousString;
      }
      
      public final com.tencent.mm.pluginsdk.model.app.g avl(String paramAnonymousString)
      {
        AppMethodBeat.i(151502);
        a.dBf();
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          AppMethodBeat.o(151502);
          return null;
        }
        Object localObject1 = new LinkedList();
        ((List)localObject1).add(paramAnonymousString);
        localObject1 = new ac((List)localObject1);
        Object localObject2 = new b.a();
        ((b.a)localObject2).hQF = new eg();
        ((b.a)localObject2).hQG = new eh();
        ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/appcenter";
        ((b.a)localObject2).funcId = 452;
        ((b.a)localObject2).hQH = 0;
        ((b.a)localObject2).respCmdId = 0;
        localObject2 = ((b.a)localObject2).aDS();
        Object localObject3 = (eg)((com.tencent.mm.ak.b)localObject2).hQD.hQJ;
        byte[] arrayOfByte = ((ac)localObject1).fdr();
        if (arrayOfByte != null) {
          ((eg)localObject3).ReqBuf = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
        }
        ((eg)localObject3).nJA = 7;
        localObject3 = y.e((com.tencent.mm.ak.b)localObject2);
        if (localObject3 == null)
        {
          ae.e("MicroMsg.AppInfoService", "getSync resp == null");
          AppMethodBeat.o(151502);
          return null;
        }
        ae.e("MicroMsg.AppInfoService", "call getAppInfoList cgi result, errType = %d, errCode = %d", new Object[] { Integer.valueOf(((com.tencent.mm.ak.a.a)localObject3).errType), Integer.valueOf(((com.tencent.mm.ak.a.a)localObject3).errCode) });
        if ((((com.tencent.mm.ak.a.a)localObject3).errType != 0) || (((com.tencent.mm.ak.a.a)localObject3).errCode != 0))
        {
          AppMethodBeat.o(151502);
          return null;
        }
        ((ac)localObject1).ck(z.a(((eh)((com.tencent.mm.ak.a.a)localObject3).hQv).FOC));
        ((ac)localObject1).onGYNetEnd(0, ((com.tencent.mm.ak.a.a)localObject3).errType, ((com.tencent.mm.ak.a.a)localObject3).errCode, ((com.tencent.mm.ak.a.a)localObject3).errMsg, (com.tencent.mm.network.q)localObject2, new byte[0]);
        localObject1 = com.tencent.mm.plugin.s.a.a.a.dBn();
        if (localObject1 == null)
        {
          ae.e("MicroMsg.AppInfoService", "getISubCorePluginBase() == null");
          AppMethodBeat.o(151502);
          return null;
        }
        paramAnonymousString = ((com.tencent.mm.plugin.s.a.a)localObject1).avk(paramAnonymousString);
        AppMethodBeat.o(151502);
        return paramAnonymousString;
      }
      
      public final void avm(String paramAnonymousString)
      {
        AppMethodBeat.i(151507);
        a.dBf().aNf(paramAnonymousString);
        AppMethodBeat.o(151507);
      }
      
      public final Cursor dBk()
      {
        AppMethodBeat.i(151503);
        Cursor localCursor = a.dBg().rawQuery("select * from AppInfo where status = 5 order by modifyTime asc", new String[0]);
        if (localCursor == null)
        {
          ae.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
          AppMethodBeat.o(151503);
          return null;
        }
        AppMethodBeat.o(151503);
        return localCursor;
      }
      
      public final j dBl()
      {
        AppMethodBeat.i(151511);
        j localj = a.dBg();
        AppMethodBeat.o(151511);
        return localj;
      }
      
      public final Cursor dBm()
      {
        AppMethodBeat.i(151514);
        Object localObject = a.dBg();
        StringBuilder localStringBuilder = new StringBuilder(256);
        localStringBuilder.append("select * from AppInfo");
        localStringBuilder.append(" where ");
        localStringBuilder.append("serviceAppType > 0");
        localObject = ((j)localObject).rawQuery(localStringBuilder.toString(), new String[0]);
        if (localObject == null)
        {
          ae.e("MicroMsg.AppInfoStorage", "getAllServices : cursor is null");
          AppMethodBeat.o(151514);
          return null;
        }
        ae.d("MicroMsg.AppInfoStorage", "getAllServices count = %d", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
        AppMethodBeat.o(151514);
        return localObject;
      }
      
      public final void e(com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        AppMethodBeat.i(151508);
        j localj = a.dBg();
        if ((paramAnonymousg != null) && (paramAnonymousg.field_status != 5))
        {
          paramAnonymousg.field_status = 3;
          ae.i("MicroMsg.AppInfoStorage", "setBlack package name = %s", new Object[] { paramAnonymousg.field_packageName });
          localj.a(paramAnonymousg, new String[0]);
        }
        AppMethodBeat.o(151508);
      }
      
      public final void eJ(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(151506);
        a.dBe().gf(paramAnonymousString, paramAnonymousInt);
        AppMethodBeat.o(151506);
      }
      
      public final void f(com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        AppMethodBeat.i(151509);
        j localj = a.dBg();
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
        a.dBg().a(paramAnonymousg, new String[0]);
        AppMethodBeat.o(151510);
      }
      
      public final Cursor gV(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(151513);
        Cursor localCursor = a.dBg().gV(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(151513);
        return localCursor;
      }
    });
    AppMethodBeat.o(151516);
  }
  
  public static d bJV()
  {
    AppMethodBeat.i(151520);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dBb().wRw == null) {
      dBb().wRw = new d(com.tencent.mm.kernel.g.ajR().gDX);
    }
    d locald = dBb().wRw;
    AppMethodBeat.o(151520);
    return locald;
  }
  
  public static a dBb()
  {
    AppMethodBeat.i(151517);
    if (wRv == null) {}
    try
    {
      if (wRv == null) {
        wRv = new a();
      }
      a locala = wRv;
      AppMethodBeat.o(151517);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(151517);
    }
  }
  
  public static String dBc()
  {
    AppMethodBeat.i(151519);
    String str = com.tencent.mm.kernel.g.ajR().gDT + "openapi/";
    AppMethodBeat.o(151519);
    return str;
  }
  
  public static String dBd()
  {
    AppMethodBeat.i(218776);
    String str = com.tencent.mm.kernel.g.ajR().gDT + "openapi_cache/";
    AppMethodBeat.o(218776);
    return str;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.f dBe()
  {
    AppMethodBeat.i(151521);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dBb().wRx == null) {
      dBb().wRx = new com.tencent.mm.pluginsdk.model.app.f();
    }
    com.tencent.mm.pluginsdk.model.app.f localf = dBb().wRx;
    AppMethodBeat.o(151521);
    return localf;
  }
  
  public static i dBf()
  {
    AppMethodBeat.i(151522);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dBb().wRy == null) {
      dBb().wRy = new i();
    }
    i locali = dBb().wRy;
    AppMethodBeat.o(151522);
    return locali;
  }
  
  public static j dBg()
  {
    AppMethodBeat.i(151523);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dBb().wRz == null) {
      dBb().wRz = new j(com.tencent.mm.kernel.g.ajR().gDX);
    }
    j localj = dBb().wRz;
    AppMethodBeat.o(151523);
    return localj;
  }
  
  public static l dBh()
  {
    AppMethodBeat.i(151524);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dBb().wRA == null) {
      dBb().wRA = new l(com.tencent.mm.kernel.g.ajR().gDX);
    }
    l locall = dBb().wRA;
    AppMethodBeat.o(151524);
    return locall;
  }
  
  public static n dBi()
  {
    AppMethodBeat.i(151525);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dBb().wRB == null) {
      dBb().wRB = new n();
    }
    n localn = dBb().wRB;
    AppMethodBeat.o(151525);
    return localn;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.e dBj()
  {
    AppMethodBeat.i(151526);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dBb().wRC == null) {
      dBb().wRC = new com.tencent.mm.pluginsdk.model.app.e();
    }
    com.tencent.mm.pluginsdk.model.app.e locale = dBb().wRC;
    AppMethodBeat.o(151526);
    return locale;
  }
  
  public final List<String> ajY()
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
    com.tencent.mm.model.ai.a.hIE = dBf();
    com.tencent.mm.sdk.b.a.IvT.c(this.wRD);
    AppMethodBeat.o(151527);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151528);
    Object localObject = dBb().wRy;
    if (localObject != null) {
      dBj().b(7, (u)localObject);
    }
    localObject = dBb().wRx;
    if (localObject != null)
    {
      ((com.tencent.mm.pluginsdk.model.app.f)localObject).FeW.clear();
      ((com.tencent.mm.pluginsdk.model.app.f)localObject).gvV.clear();
      ((com.tencent.mm.pluginsdk.model.app.f)localObject).FeX.clear();
    }
    localObject = dBb().wRB;
    if (localObject != null)
    {
      ae.d("MicroMsg.AppSettingService", "stop service");
      ((n)localObject).Ffy.clear();
      dBj().b(1, (u)localObject);
    }
    if (this.wRC != null)
    {
      localObject = this.wRC;
      com.tencent.mm.kernel.g.ajQ().gDv.b(452, (com.tencent.mm.ak.f)localObject);
      ar.f(new e.3((com.tencent.mm.pluginsdk.model.app.e)localObject));
    }
    if (dBb().wRz != null) {
      dBb().wRz.Ffo.clear();
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.wRD);
    ae.i("XPinOpenApi", "onAccountRelease");
    AppMethodBeat.o(151528);
  }
  
  public void onDataBaseClosed(h paramh1, h paramh2)
  {
    AppMethodBeat.i(151529);
    this.wRw = null;
    this.wRz = null;
    ae.i("XPinOpenApi", "onDataBaseClosed");
    AppMethodBeat.o(151529);
  }
  
  public void onDataBaseOpened(h paramh1, h paramh2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.s.a
 * JD-Core Version:    0.7.0.1
 */