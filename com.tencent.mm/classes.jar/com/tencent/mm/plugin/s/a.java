package com.tencent.mm.plugin.s;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.c.a;
import com.tencent.mm.al.y;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.e.3;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ea;
import com.tencent.mm.protocal.protobuf.eb;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
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
  private static volatile a unu;
  private n unA;
  private com.tencent.mm.pluginsdk.model.app.e unB;
  private com.tencent.mm.sdk.b.c unC;
  private d unv;
  private com.tencent.mm.pluginsdk.model.app.f unw;
  private com.tencent.mm.pluginsdk.model.app.i unx;
  private j uny;
  private l unz;
  
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
    baseDBFactories.put(Integer.valueOf("APPINFO_TABLE".hashCode()), new a.3());
    AppMethodBeat.o(151530);
  }
  
  private a()
  {
    AppMethodBeat.i(151516);
    this.unC = new a.4(this);
    a.a.a(new com.tencent.mm.plugin.s.a.a()
    {
      public final Cursor C(int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(151504);
        j localj = a.cZQ();
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
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
          AppMethodBeat.o(151504);
          return null;
        }
        AppMethodBeat.o(151504);
        return paramAnonymousArrayOfInt;
      }
      
      public final Bitmap a(String paramAnonymousString, int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(151505);
        a.cZQ();
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppInfoStorage", "getIcon : invalid argument");
          AppMethodBeat.o(151505);
          return null;
        }
        if (paramAnonymousString.equals("wx7fa037cc7dfabad5"))
        {
          paramAnonymousString = BitmapFactory.decodeResource(aj.getContext().getResources(), 2131231045);
          AppMethodBeat.o(151505);
          return paramAnonymousString;
        }
        paramAnonymousString = j.fw(paramAnonymousString, paramAnonymousInt);
        if (!com.tencent.mm.vfs.i.eK(paramAnonymousString))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppInfoStorage", "icon does not exist, iconPath = " + paramAnonymousString + ", iconType = " + paramAnonymousInt);
          AppMethodBeat.o(151505);
          return null;
        }
        paramAnonymousString = BackwardSupportUtil.b.n(paramAnonymousString, paramAnonymousFloat);
        AppMethodBeat.o(151505);
        return paramAnonymousString;
      }
      
      public final void aA(LinkedList<String> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(151512);
        a.cZP().bb(paramAnonymousLinkedList);
        AppMethodBeat.o(151512);
      }
      
      public final com.tencent.mm.pluginsdk.model.app.g ajX(String paramAnonymousString)
      {
        AppMethodBeat.i(151501);
        if (!com.tencent.mm.kernel.g.afw())
        {
          AppMethodBeat.o(151501);
          return null;
        }
        paramAnonymousString = a.cZQ().aAS(paramAnonymousString);
        AppMethodBeat.o(151501);
        return paramAnonymousString;
      }
      
      public final com.tencent.mm.pluginsdk.model.app.g ajY(String paramAnonymousString)
      {
        AppMethodBeat.i(151502);
        a.cZP();
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          AppMethodBeat.o(151502);
          return null;
        }
        Object localObject1 = new LinkedList();
        ((List)localObject1).add(paramAnonymousString);
        localObject1 = new com.tencent.mm.pluginsdk.model.app.ad((List)localObject1);
        Object localObject2 = new b.a();
        ((b.a)localObject2).gUU = new ea();
        ((b.a)localObject2).gUV = new eb();
        ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/appcenter";
        ((b.a)localObject2).funcId = 452;
        ((b.a)localObject2).reqCmdId = 0;
        ((b.a)localObject2).respCmdId = 0;
        localObject2 = ((b.a)localObject2).atI();
        Object localObject3 = (ea)((com.tencent.mm.al.b)localObject2).gUS.gUX;
        byte[] arrayOfByte = ((com.tencent.mm.pluginsdk.model.app.ad)localObject1).evp();
        if (arrayOfByte != null) {
          ((ea)localObject3).ReqBuf = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
        }
        ((ea)localObject3).mBH = 7;
        localObject3 = y.e((com.tencent.mm.al.b)localObject2);
        if (localObject3 == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppInfoService", "getSync resp == null");
          AppMethodBeat.o(151502);
          return null;
        }
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppInfoService", "call getAppInfoList cgi result, errType = %d, errCode = %d", new Object[] { Integer.valueOf(((c.a)localObject3).errType), Integer.valueOf(((c.a)localObject3).errCode) });
        if ((((c.a)localObject3).errType != 0) || (((c.a)localObject3).errCode != 0))
        {
          AppMethodBeat.o(151502);
          return null;
        }
        ((com.tencent.mm.pluginsdk.model.app.ad)localObject1).cb(z.a(((eb)((c.a)localObject3).gUK).Cyq));
        ((com.tencent.mm.pluginsdk.model.app.ad)localObject1).onGYNetEnd(0, ((c.a)localObject3).errType, ((c.a)localObject3).errCode, ((c.a)localObject3).errMsg, (com.tencent.mm.network.q)localObject2, new byte[0]);
        localObject1 = a.a.cZX();
        if (localObject1 == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppInfoService", "getISubCorePluginBase() == null");
          AppMethodBeat.o(151502);
          return null;
        }
        paramAnonymousString = ((com.tencent.mm.plugin.s.a.a)localObject1).ajX(paramAnonymousString);
        AppMethodBeat.o(151502);
        return paramAnonymousString;
      }
      
      public final void ajZ(String paramAnonymousString)
      {
        AppMethodBeat.i(151507);
        a.cZP().aAR(paramAnonymousString);
        AppMethodBeat.o(151507);
      }
      
      public final Cursor cZU()
      {
        AppMethodBeat.i(151503);
        Cursor localCursor = a.cZQ().rawQuery("select * from AppInfo where status = 5 order by modifyTime asc", new String[0]);
        if (localCursor == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
          AppMethodBeat.o(151503);
          return null;
        }
        AppMethodBeat.o(151503);
        return localCursor;
      }
      
      public final j cZV()
      {
        AppMethodBeat.i(151511);
        j localj = a.cZQ();
        AppMethodBeat.o(151511);
        return localj;
      }
      
      public final Cursor cZW()
      {
        AppMethodBeat.i(151514);
        Object localObject = a.cZQ();
        StringBuilder localStringBuilder = new StringBuilder(256);
        localStringBuilder.append("select * from AppInfo");
        localStringBuilder.append(" where ");
        localStringBuilder.append("serviceAppType > 0");
        localObject = ((j)localObject).rawQuery(localStringBuilder.toString(), new String[0]);
        if (localObject == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppInfoStorage", "getAllServices : cursor is null");
          AppMethodBeat.o(151514);
          return null;
        }
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppInfoStorage", "getAllServices count = %d", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
        AppMethodBeat.o(151514);
        return localObject;
      }
      
      public final void e(com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        AppMethodBeat.i(151508);
        j localj = a.cZQ();
        if ((paramAnonymousg != null) && (paramAnonymousg.field_status != 5))
        {
          paramAnonymousg.field_status = 3;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppInfoStorage", "setBlack package name = %s", new Object[] { paramAnonymousg.field_packageName });
          localj.a(paramAnonymousg, new String[0]);
        }
        AppMethodBeat.o(151508);
      }
      
      public final void ec(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(151506);
        a.cZO().fu(paramAnonymousString, paramAnonymousInt);
        AppMethodBeat.o(151506);
      }
      
      public final void f(com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        AppMethodBeat.i(151509);
        j localj = a.cZQ();
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
        a.cZQ().a(paramAnonymousg, new String[0]);
        AppMethodBeat.o(151510);
      }
      
      public final Cursor gv(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(151513);
        Cursor localCursor = a.cZQ().gv(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(151513);
        return localCursor;
      }
    });
    AppMethodBeat.o(151516);
  }
  
  public static d bxS()
  {
    AppMethodBeat.i(151520);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cZL().unv == null) {
      cZL().unv = new d(com.tencent.mm.kernel.g.afB().gda);
    }
    d locald = cZL().unv;
    AppMethodBeat.o(151520);
    return locald;
  }
  
  public static a cZL()
  {
    AppMethodBeat.i(151517);
    if (unu == null) {}
    try
    {
      if (unu == null) {
        unu = new a();
      }
      a locala = unu;
      AppMethodBeat.o(151517);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(151517);
    }
  }
  
  public static String cZM()
  {
    AppMethodBeat.i(151519);
    String str = com.tencent.mm.kernel.g.afB().gcW + "openapi/";
    AppMethodBeat.o(151519);
    return str;
  }
  
  public static String cZN()
  {
    AppMethodBeat.i(190742);
    String str = com.tencent.mm.kernel.g.afB().gcW + "openapi_cache/";
    AppMethodBeat.o(190742);
    return str;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.f cZO()
  {
    AppMethodBeat.i(151521);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cZL().unw == null) {
      cZL().unw = new com.tencent.mm.pluginsdk.model.app.f();
    }
    com.tencent.mm.pluginsdk.model.app.f localf = cZL().unw;
    AppMethodBeat.o(151521);
    return localf;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.i cZP()
  {
    AppMethodBeat.i(151522);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cZL().unx == null) {
      cZL().unx = new com.tencent.mm.pluginsdk.model.app.i();
    }
    com.tencent.mm.pluginsdk.model.app.i locali = cZL().unx;
    AppMethodBeat.o(151522);
    return locali;
  }
  
  public static j cZQ()
  {
    AppMethodBeat.i(151523);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cZL().uny == null) {
      cZL().uny = new j(com.tencent.mm.kernel.g.afB().gda);
    }
    j localj = cZL().uny;
    AppMethodBeat.o(151523);
    return localj;
  }
  
  public static l cZR()
  {
    AppMethodBeat.i(151524);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cZL().unz == null) {
      cZL().unz = new l(com.tencent.mm.kernel.g.afB().gda);
    }
    l locall = cZL().unz;
    AppMethodBeat.o(151524);
    return locall;
  }
  
  public static n cZS()
  {
    AppMethodBeat.i(151525);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cZL().unA == null) {
      cZL().unA = new n();
    }
    n localn = cZL().unA;
    AppMethodBeat.o(151525);
    return localn;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.e cZT()
  {
    AppMethodBeat.i(151526);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cZL().unB == null) {
      cZL().unB = new com.tencent.mm.pluginsdk.model.app.e();
    }
    com.tencent.mm.pluginsdk.model.app.e locale = cZL().unB;
    AppMethodBeat.o(151526);
    return locale;
  }
  
  public final List<String> afI()
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
    com.tencent.mm.model.ag.a.gMU = cZP();
    com.tencent.mm.sdk.b.a.ESL.c(this.unC);
    AppMethodBeat.o(151527);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151528);
    Object localObject = cZL().unx;
    if (localObject != null) {
      cZT().b(7, (u)localObject);
    }
    localObject = cZL().unw;
    if (localObject != null)
    {
      ((com.tencent.mm.pluginsdk.model.app.f)localObject).BPA.clear();
      ((com.tencent.mm.pluginsdk.model.app.f)localObject).fVX.clear();
      ((com.tencent.mm.pluginsdk.model.app.f)localObject).BPB.clear();
    }
    localObject = cZL().unA;
    if (localObject != null)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppSettingService", "stop service");
      ((n)localObject).BPZ.clear();
      cZT().b(1, (u)localObject);
    }
    if (this.unB != null)
    {
      localObject = this.unB;
      com.tencent.mm.kernel.g.afA().gcy.b(452, (com.tencent.mm.al.g)localObject);
      aq.f(new e.3((com.tencent.mm.pluginsdk.model.app.e)localObject));
    }
    if (cZL().uny != null) {
      cZL().uny.BPS.clear();
    }
    com.tencent.mm.sdk.b.a.ESL.d(this.unC);
    com.tencent.mm.sdk.platformtools.ad.i("XPinOpenApi", "onAccountRelease");
    AppMethodBeat.o(151528);
  }
  
  public void onDataBaseClosed(h paramh1, h paramh2)
  {
    AppMethodBeat.i(151529);
    this.unv = null;
    this.uny = null;
    com.tencent.mm.sdk.platformtools.ad.i("XPinOpenApi", "onDataBaseClosed");
    AppMethodBeat.o(151529);
  }
  
  public void onDataBaseOpened(h paramh1, h paramh2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.s.a
 * JD-Core Version:    0.7.0.1
 */