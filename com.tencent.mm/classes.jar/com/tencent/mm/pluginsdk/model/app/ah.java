package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.h.c.r;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.z.a.a;
import com.tencent.mm.plugin.z.a.a.a;
import com.tencent.mm.protocal.c.akw;
import com.tencent.mm.protocal.c.akx;
import com.tencent.mm.protocal.c.ba;
import com.tencent.mm.protocal.c.bir;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.cno;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class ah
  extends x
{
  private int dlO;
  LinkedList<f> rUN;
  private LinkedList<f> rUO;
  private LinkedList<String> rUP;
  
  public ah(String paramString, LinkedList<String> paramLinkedList)
  {
    y.i("MicroMsg.NetSceneGetSuggestionAppList", "offset: 0, limit = 20, lang = " + paramString + "installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      y.i("MicroMsg.NetSceneGetSuggestionAppList", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    this.dlO = 3;
    localObject = new b.a();
    ((b.a)localObject).ecH = new akw();
    ((b.a)localObject).ecI = new akx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getsuggestionapplist";
    ((b.a)localObject).ecG = 409;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.jvQ = ((b.a)localObject).Kt();
    localObject = (akw)this.jvQ.ecE.ecN;
    ((akw)localObject).kSm = 3;
    ((akw)localObject).kUT = 0;
    ((akw)localObject).kUU = 20;
    ((akw)localObject).kUa = paramString;
    paramString = ay(paramLinkedList);
    ((akw)localObject).tgZ = paramString.size();
    ((akw)localObject).kUD = paramString;
    this.rUN = new LinkedList();
    this.rUO = new LinkedList();
    this.rUP = new LinkedList();
    this.rUP.addAll(paramLinkedList);
  }
  
  private static void a(f paramf, ba paramba)
  {
    paramf.cN(paramba.suu);
    paramf.cQ(paramba.kSM);
    paramf.cO(paramba.suw);
    paramf.field_appName = paramba.kVn;
    paramf.field_appIconUrl = paramba.suv;
    paramf.cR(paramba.suy);
    paramf.cvO = paramba.suA;
    paramf.cuS = true;
    a(paramf, paramba.suz);
  }
  
  private static void a(f paramf, bir parambir)
  {
    paramf.cN(parambir.suu);
    paramf.field_appIconUrl = parambir.suv;
    paramf.cM(parambir.tCD);
    paramf.field_appName = parambir.kVn;
    paramf.cO(parambir.suw);
    paramf.field_appType = parambir.sCw;
    paramf.cQ(parambir.kSM);
    paramf.field_packageName = parambir.sux;
    paramf.cR(parambir.suy);
    if (!bk.bl(parambir.suy))
    {
      y.i("MicroMsg.NetSceneGetSuggestionAppList", "google play download url is : %s, download flag is %d", new Object[] { parambir.suy, Integer.valueOf(parambir.tCN) });
      paramf.fd(parambir.tCN);
    }
    paramf.cS(parambir.tCK);
    paramf.cT(parambir.tCL);
    a(paramf, parambir.suz);
    if ((!bk.bl(paramf.field_appType)) && ((paramf.field_appType.startsWith("1")) || (paramf.field_appType.startsWith("6"))))
    {
      if (!paramf.field_appType.endsWith(",")) {
        paramf.field_appType += ",";
      }
      paramf.field_appType = ("," + paramf.field_appType);
    }
  }
  
  private static void a(f paramf, cno paramcno)
  {
    y.v("MicroMsg.NetSceneGetSuggestionAppList", "dealYYBDownloadInfos, appId = %s", new Object[] { paramf.field_appId });
    if (paramcno != null)
    {
      paramf.fd(paramcno.uaj);
      paramf.cW(paramcno.sww);
      paramf.cX(paramcno.kWv);
      paramf.cU(paramcno.uak);
      paramf.cV(paramcno.kWx);
      paramf.cvM = paramcno.kWy;
      paramf.cuS = true;
      paramf.fe(paramcno.kWz);
      y.i("MicroMsg.NetSceneGetSuggestionAppList", "get yyb download infos:[%d],[%s],[%s],[%s],[%s],[%s],[%d]", new Object[] { Integer.valueOf(paramcno.uaj), paramcno.sww, paramcno.kWv, paramcno.uak, paramcno.kWx, paramcno.kWy, Integer.valueOf(paramcno.kWz) });
    }
  }
  
  private void a(i parami, LinkedList<ba> paramLinkedList)
  {
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      Iterator localIterator = paramLinkedList.iterator();
      if (localIterator.hasNext())
      {
        ba localba = (ba)localIterator.next();
        paramLinkedList = g.by(localba.kRX, true);
        if (paramLinkedList != null)
        {
          a(paramLinkedList, localba);
          parami.a(paramLinkedList, new String[0]);
        }
        for (;;)
        {
          this.rUO.add(paramLinkedList);
          break;
          paramLinkedList = new f();
          paramLinkedList.field_appId = localba.kRX;
          a(paramLinkedList, localba);
          parami.l(paramLinkedList);
        }
      }
    }
  }
  
  private static LinkedList<bml> ay(LinkedList<String> paramLinkedList)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramLinkedList == null) {
      return localLinkedList;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      String str = (String)paramLinkedList.next();
      if (!bk.bl(str)) {
        localLinkedList.add(aa.pj(str));
      }
    }
    return localLinkedList;
  }
  
  private void b(i parami, LinkedList<bir> paramLinkedList)
  {
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        bir localbir = (bir)localIterator.next();
        if (bk.bl(localbir.kRX))
        {
          y.e("MicroMsg.NetSceneGetSuggestionAppList", "error appinfo, the appid is null");
        }
        else
        {
          boolean bool4 = true;
          boolean bool1 = true;
          boolean bool3 = false;
          paramLinkedList = g.by(localbir.kRX, true);
          label131:
          boolean bool2;
          if (paramLinkedList != null)
          {
            a(paramLinkedList, localbir);
            if (this.dlO == 3)
            {
              paramLinkedList.field_status = 5;
              if ((bk.bl(paramLinkedList.cvG)) || (bk.bl(paramLinkedList.cvF))) {
                if (paramLinkedList.cvG != null)
                {
                  bool1 = true;
                  if (paramLinkedList.cvF == null) {
                    break label255;
                  }
                  bool2 = true;
                  label141:
                  y.e("MicroMsg.NetSceneGetSuggestionAppList", "wrong suggestion params1, has IntroUrl %s, has IconUrl %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                  bool1 = false;
                }
              }
            }
            for (bool2 = false;; bool2 = parami.a(paramLinkedList, new String[0]))
            {
              y.i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[] { localbir.kRX, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
              label208:
              if ((!bool1) || (this.rUP.contains(localbir.kRX)) || (this.rUN.contains(paramLinkedList))) {
                break label419;
              }
              this.rUN.add(paramLinkedList);
              break;
              bool1 = false;
              break label131;
              label255:
              bool2 = false;
              break label141;
            }
          }
          paramLinkedList = new f();
          paramLinkedList.field_appId = localbir.kRX;
          a(paramLinkedList, localbir);
          if (this.dlO == 3)
          {
            paramLinkedList.field_status = 5;
            if ((bk.bl(paramLinkedList.cvG)) || (bk.bl(paramLinkedList.cvF))) {
              if (paramLinkedList.cvG != null)
              {
                bool1 = true;
                label340:
                if (paramLinkedList.cvF == null) {
                  break label426;
                }
                bool2 = true;
                label350:
                y.e("MicroMsg.NetSceneGetSuggestionAppList", "wrong suggestion params2, has IntroUrl %s, has IconUrl %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                bool1 = false;
                bool2 = bool3;
              }
            }
          }
          for (;;)
          {
            y.i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[] { localbir.kRX, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
            break label208;
            label419:
            break;
            bool1 = false;
            break label340;
            label426:
            bool2 = false;
            break label350;
            bool2 = parami.l(paramLinkedList);
            bool1 = bool4;
          }
        }
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      return;
    }
    paramString = (akx)this.jvQ.ecF.ecN;
    if (paramString == null)
    {
      y.e("MicroMsg.NetSceneGetSuggestionAppList", "resp == null");
      return;
    }
    y.v("MicroMsg.NetSceneGetSuggestionAppList", "suggestion app count = %s, appType = %s, ", new Object[] { Integer.valueOf(paramString.tha), Integer.valueOf(this.dlO) });
    paramq = a.a.bru().brs();
    b(paramq, paramString.thb);
    a(paramq, paramString.kVA);
  }
  
  public final void bi(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      y.e("MicroMsg.NetSceneGetSuggestionAppList", "buf is null");
      return;
    }
    b.c localc = this.jvQ.ecF;
    try
    {
      localc.A(paramArrayOfByte);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      y.e("MicroMsg.NetSceneGetSuggestionAppList", paramArrayOfByte.getMessage());
      y.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", paramArrayOfByte, "", new Object[0]);
    }
  }
  
  public final byte[] ckB()
  {
    try
    {
      byte[] arrayOfByte = ((b.b)this.jvQ.Kv()).HG();
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.NetSceneGetSuggestionAppList", localException.getMessage());
      y.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", localException, "", new Object[0]);
    }
    return null;
  }
  
  public final int getType()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ah
 * JD-Core Version:    0.7.0.1
 */