package com.tencent.mm.plugin.s;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.y;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.e.3;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eg;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
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
  private static volatile a wBK;
  private d wBL;
  private com.tencent.mm.pluginsdk.model.app.f wBM;
  private com.tencent.mm.pluginsdk.model.app.i wBN;
  private j wBO;
  private l wBP;
  private n wBQ;
  private com.tencent.mm.pluginsdk.model.app.e wBR;
  private com.tencent.mm.sdk.b.c wBS;
  
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
    this.wBS = new a.4(this);
    com.tencent.mm.plugin.s.a.a.a.a(new com.tencent.mm.plugin.s.a.a()
    {
      public final Cursor C(int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(151504);
        j localj = a.dxQ();
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
          ad.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
          AppMethodBeat.o(151504);
          return null;
        }
        AppMethodBeat.o(151504);
        return paramAnonymousArrayOfInt;
      }
      
      public final Bitmap a(String paramAnonymousString, int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(151505);
        a.dxQ();
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          ad.e("MicroMsg.AppInfoStorage", "getIcon : invalid argument");
          AppMethodBeat.o(151505);
          return null;
        }
        if (paramAnonymousString.equals("wx7fa037cc7dfabad5"))
        {
          paramAnonymousString = BitmapFactory.decodeResource(aj.getContext().getResources(), 2131231045);
          AppMethodBeat.o(151505);
          return paramAnonymousString;
        }
        paramAnonymousString = j.fY(paramAnonymousString, paramAnonymousInt);
        if (!com.tencent.mm.vfs.i.fv(paramAnonymousString))
        {
          ad.e("MicroMsg.AppInfoStorage", "icon does not exist, iconPath = " + paramAnonymousString + ", iconType = " + paramAnonymousInt);
          AppMethodBeat.o(151505);
          return null;
        }
        paramAnonymousString = BackwardSupportUtil.b.o(paramAnonymousString, paramAnonymousFloat);
        AppMethodBeat.o(151505);
        return paramAnonymousString;
      }
      
      public final void aI(LinkedList<String> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(151512);
        a.dxP().bj(paramAnonymousLinkedList);
        AppMethodBeat.o(151512);
      }
      
      public final com.tencent.mm.pluginsdk.model.app.g atV(String paramAnonymousString)
      {
        AppMethodBeat.i(151501);
        if (!com.tencent.mm.kernel.g.ajx())
        {
          AppMethodBeat.o(151501);
          return null;
        }
        paramAnonymousString = a.dxQ().aLK(paramAnonymousString);
        AppMethodBeat.o(151501);
        return paramAnonymousString;
      }
      
      public final com.tencent.mm.pluginsdk.model.app.g atW(String paramAnonymousString)
      {
        AppMethodBeat.i(151502);
        a.dxP();
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          AppMethodBeat.o(151502);
          return null;
        }
        Object localObject1 = new LinkedList();
        ((List)localObject1).add(paramAnonymousString);
        localObject1 = new ac((List)localObject1);
        Object localObject2 = new b.a();
        ((b.a)localObject2).hNM = new eg();
        ((b.a)localObject2).hNN = new eh();
        ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/appcenter";
        ((b.a)localObject2).funcId = 452;
        ((b.a)localObject2).hNO = 0;
        ((b.a)localObject2).respCmdId = 0;
        localObject2 = ((b.a)localObject2).aDC();
        Object localObject3 = (eg)((com.tencent.mm.al.b)localObject2).hNK.hNQ;
        byte[] arrayOfByte = ((ac)localObject1).eZD();
        if (arrayOfByte != null) {
          ((eg)localObject3).ReqBuf = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
        }
        ((eg)localObject3).nEf = 7;
        localObject3 = y.e((com.tencent.mm.al.b)localObject2);
        if (localObject3 == null)
        {
          ad.e("MicroMsg.AppInfoService", "getSync resp == null");
          AppMethodBeat.o(151502);
          return null;
        }
        ad.e("MicroMsg.AppInfoService", "call getAppInfoList cgi result, errType = %d, errCode = %d", new Object[] { Integer.valueOf(((com.tencent.mm.al.a.a)localObject3).errType), Integer.valueOf(((com.tencent.mm.al.a.a)localObject3).errCode) });
        if ((((com.tencent.mm.al.a.a)localObject3).errType != 0) || (((com.tencent.mm.al.a.a)localObject3).errCode != 0))
        {
          AppMethodBeat.o(151502);
          return null;
        }
        ((ac)localObject1).ch(z.a(((eh)((com.tencent.mm.al.a.a)localObject3).hNC).Fwe));
        ((ac)localObject1).onGYNetEnd(0, ((com.tencent.mm.al.a.a)localObject3).errType, ((com.tencent.mm.al.a.a)localObject3).errCode, ((com.tencent.mm.al.a.a)localObject3).errMsg, (com.tencent.mm.network.q)localObject2, new byte[0]);
        localObject1 = com.tencent.mm.plugin.s.a.a.a.dxX();
        if (localObject1 == null)
        {
          ad.e("MicroMsg.AppInfoService", "getISubCorePluginBase() == null");
          AppMethodBeat.o(151502);
          return null;
        }
        paramAnonymousString = ((com.tencent.mm.plugin.s.a.a)localObject1).atV(paramAnonymousString);
        AppMethodBeat.o(151502);
        return paramAnonymousString;
      }
      
      public final void atX(String paramAnonymousString)
      {
        AppMethodBeat.i(151507);
        a.dxP().aLJ(paramAnonymousString);
        AppMethodBeat.o(151507);
      }
      
      public final Cursor dxU()
      {
        AppMethodBeat.i(151503);
        Cursor localCursor = a.dxQ().rawQuery("select * from AppInfo where status = 5 order by modifyTime asc", new String[0]);
        if (localCursor == null)
        {
          ad.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
          AppMethodBeat.o(151503);
          return null;
        }
        AppMethodBeat.o(151503);
        return localCursor;
      }
      
      public final j dxV()
      {
        AppMethodBeat.i(151511);
        j localj = a.dxQ();
        AppMethodBeat.o(151511);
        return localj;
      }
      
      public final Cursor dxW()
      {
        AppMethodBeat.i(151514);
        Object localObject = a.dxQ();
        StringBuilder localStringBuilder = new StringBuilder(256);
        localStringBuilder.append("select * from AppInfo");
        localStringBuilder.append(" where ");
        localStringBuilder.append("serviceAppType > 0");
        localObject = ((j)localObject).rawQuery(localStringBuilder.toString(), new String[0]);
        if (localObject == null)
        {
          ad.e("MicroMsg.AppInfoStorage", "getAllServices : cursor is null");
          AppMethodBeat.o(151514);
          return null;
        }
        ad.d("MicroMsg.AppInfoStorage", "getAllServices count = %d", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
        AppMethodBeat.o(151514);
        return localObject;
      }
      
      public final void e(com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        AppMethodBeat.i(151508);
        j localj = a.dxQ();
        if ((paramAnonymousg != null) && (paramAnonymousg.field_status != 5))
        {
          paramAnonymousg.field_status = 3;
          ad.i("MicroMsg.AppInfoStorage", "setBlack package name = %s", new Object[] { paramAnonymousg.field_packageName });
          localj.a(paramAnonymousg, new String[0]);
        }
        AppMethodBeat.o(151508);
      }
      
      public final void eB(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(151506);
        a.dxO().fW(paramAnonymousString, paramAnonymousInt);
        AppMethodBeat.o(151506);
      }
      
      public final void f(com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        AppMethodBeat.i(151509);
        j localj = a.dxQ();
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
        a.dxQ().a(paramAnonymousg, new String[0]);
        AppMethodBeat.o(151510);
      }
      
      public final Cursor gU(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(151513);
        Cursor localCursor = a.dxQ().gU(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(151513);
        return localCursor;
      }
    });
    AppMethodBeat.o(151516);
  }
  
  public static d bIX()
  {
    AppMethodBeat.i(151520);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dxL().wBL == null) {
      dxL().wBL = new d(com.tencent.mm.kernel.g.ajC().gBq);
    }
    d locald = dxL().wBL;
    AppMethodBeat.o(151520);
    return locald;
  }
  
  public static a dxL()
  {
    AppMethodBeat.i(151517);
    if (wBK == null) {}
    try
    {
      if (wBK == null) {
        wBK = new a();
      }
      a locala = wBK;
      AppMethodBeat.o(151517);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(151517);
    }
  }
  
  public static String dxM()
  {
    AppMethodBeat.i(151519);
    String str = com.tencent.mm.kernel.g.ajC().gBm + "openapi/";
    AppMethodBeat.o(151519);
    return str;
  }
  
  public static String dxN()
  {
    AppMethodBeat.i(195323);
    String str = com.tencent.mm.kernel.g.ajC().gBm + "openapi_cache/";
    AppMethodBeat.o(195323);
    return str;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.f dxO()
  {
    AppMethodBeat.i(151521);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dxL().wBM == null) {
      dxL().wBM = new com.tencent.mm.pluginsdk.model.app.f();
    }
    com.tencent.mm.pluginsdk.model.app.f localf = dxL().wBM;
    AppMethodBeat.o(151521);
    return localf;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.i dxP()
  {
    AppMethodBeat.i(151522);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dxL().wBN == null) {
      dxL().wBN = new com.tencent.mm.pluginsdk.model.app.i();
    }
    com.tencent.mm.pluginsdk.model.app.i locali = dxL().wBN;
    AppMethodBeat.o(151522);
    return locali;
  }
  
  public static j dxQ()
  {
    AppMethodBeat.i(151523);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dxL().wBO == null) {
      dxL().wBO = new j(com.tencent.mm.kernel.g.ajC().gBq);
    }
    j localj = dxL().wBO;
    AppMethodBeat.o(151523);
    return localj;
  }
  
  public static l dxR()
  {
    AppMethodBeat.i(151524);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dxL().wBP == null) {
      dxL().wBP = new l(com.tencent.mm.kernel.g.ajC().gBq);
    }
    l locall = dxL().wBP;
    AppMethodBeat.o(151524);
    return locall;
  }
  
  public static n dxS()
  {
    AppMethodBeat.i(151525);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dxL().wBQ == null) {
      dxL().wBQ = new n();
    }
    n localn = dxL().wBQ;
    AppMethodBeat.o(151525);
    return localn;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.e dxT()
  {
    AppMethodBeat.i(151526);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dxL().wBR == null) {
      dxL().wBR = new com.tencent.mm.pluginsdk.model.app.e();
    }
    com.tencent.mm.pluginsdk.model.app.e locale = dxL().wBR;
    AppMethodBeat.o(151526);
    return locale;
  }
  
  public final List<String> ajJ()
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
    com.tencent.mm.model.ah.a.hFM = dxP();
    com.tencent.mm.sdk.b.a.IbL.c(this.wBS);
    AppMethodBeat.o(151527);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151528);
    Object localObject = dxL().wBN;
    if (localObject != null) {
      dxT().b(7, (u)localObject);
    }
    localObject = dxL().wBM;
    if (localObject != null)
    {
      ((com.tencent.mm.pluginsdk.model.app.f)localObject).EMz.clear();
      ((com.tencent.mm.pluginsdk.model.app.f)localObject).gto.clear();
      ((com.tencent.mm.pluginsdk.model.app.f)localObject).EMA.clear();
    }
    localObject = dxL().wBQ;
    if (localObject != null)
    {
      ad.d("MicroMsg.AppSettingService", "stop service");
      ((n)localObject).ENb.clear();
      dxT().b(1, (u)localObject);
    }
    if (this.wBR != null)
    {
      localObject = this.wBR;
      com.tencent.mm.kernel.g.ajB().gAO.b(452, (com.tencent.mm.al.f)localObject);
      aq.f(new e.3((com.tencent.mm.pluginsdk.model.app.e)localObject));
    }
    if (dxL().wBO != null) {
      dxL().wBO.EMR.clear();
    }
    com.tencent.mm.sdk.b.a.IbL.d(this.wBS);
    ad.i("XPinOpenApi", "onAccountRelease");
    AppMethodBeat.o(151528);
  }
  
  public void onDataBaseClosed(h paramh1, h paramh2)
  {
    AppMethodBeat.i(151529);
    this.wBL = null;
    this.wBO = null;
    ad.i("XPinOpenApi", "onDataBaseClosed");
    AppMethodBeat.o(151529);
  }
  
  public void onDataBaseOpened(h paramh1, h paramh2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.s.a
 * JD-Core Version:    0.7.0.1
 */