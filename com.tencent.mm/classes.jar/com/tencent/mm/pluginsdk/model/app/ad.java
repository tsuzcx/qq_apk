package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.g.c.t;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.s.a.a;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.protocal.protobuf.aqj;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.bg;
import com.tencent.mm.protocal.protobuf.brj;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class ad
  extends x
{
  private int edl;
  LinkedList<f> vLB;
  private LinkedList<f> vLC;
  private LinkedList<String> vLD;
  
  public ad(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(79384);
    ab.i("MicroMsg.NetSceneGetSuggestionAppList", "offset: 0, limit = 20, lang = " + paramString + "installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ab.i("MicroMsg.NetSceneGetSuggestionAppList", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    this.edl = 3;
    localObject = new b.a();
    ((b.a)localObject).fsX = new aqj();
    ((b.a)localObject).fsY = new aqk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getsuggestionapplist";
    ((b.a)localObject).funcId = 409;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.lFp = ((b.a)localObject).ado();
    localObject = (aqj)this.lFp.fsV.fta;
    ((aqj)localObject).nqn = 3;
    ((aqj)localObject).nsV = 0;
    ((aqj)localObject).nsW = 20;
    ((aqj)localObject).nsa = paramString;
    paramString = aI(paramLinkedList);
    ((aqj)localObject).xfN = paramString.size();
    ((aqj)localObject).nsF = paramString;
    this.vLB = new LinkedList();
    this.vLC = new LinkedList();
    this.vLD = new LinkedList();
    this.vLD.addAll(paramLinkedList);
    AppMethodBeat.o(79384);
  }
  
  private static void a(f paramf, bg parambg)
  {
    AppMethodBeat.i(79392);
    paramf.iV(parambg.wny);
    paramf.iY(parambg.nqL);
    paramf.iW(parambg.wnA);
    paramf.field_appName = parambg.ntp;
    paramf.field_appIconUrl = parambg.wnz;
    paramf.iZ(parambg.wnC);
    paramf.jh(parambg.wnE);
    a(paramf, parambg.wnD);
    AppMethodBeat.o(79392);
  }
  
  private static void a(f paramf, brj parambrj)
  {
    AppMethodBeat.i(79389);
    paramf.iV(parambrj.wny);
    paramf.field_appIconUrl = parambrj.wnz;
    paramf.iU(parambrj.xET);
    paramf.field_appName = parambrj.ntp;
    paramf.iW(parambrj.wnA);
    paramf.field_appType = parambrj.wwV;
    paramf.iY(parambrj.nqL);
    paramf.field_packageName = parambrj.wnB;
    paramf.iZ(parambrj.wnC);
    if (!bo.isNullOrNil(parambrj.wnC))
    {
      ab.i("MicroMsg.NetSceneGetSuggestionAppList", "google play download url is : %s, download flag is %d", new Object[] { parambrj.wnC, Integer.valueOf(parambrj.xFd) });
      paramf.ho(parambrj.xFd);
    }
    paramf.ja(parambrj.xFa);
    paramf.jb(parambrj.xFb);
    a(paramf, parambrj.wnD);
    q(paramf);
    AppMethodBeat.o(79389);
  }
  
  private static void a(f paramf, dbw paramdbw)
  {
    AppMethodBeat.i(79391);
    ab.v("MicroMsg.NetSceneGetSuggestionAppList", "dealYYBDownloadInfos, appId = %s", new Object[] { paramf.field_appId });
    if (paramdbw != null)
    {
      paramf.ho(paramdbw.yic);
      paramf.je(paramdbw.wxa);
      paramf.jf(paramdbw.nux);
      paramf.jc(paramdbw.yid);
      paramf.jd(paramdbw.nuz);
      paramf.jg(paramdbw.nuA);
      paramf.hp(paramdbw.nuB);
      ab.i("MicroMsg.NetSceneGetSuggestionAppList", "get yyb download infos:[%d],[%s],[%s],[%s],[%s],[%s],[%d]", new Object[] { Integer.valueOf(paramdbw.yic), paramdbw.wxa, paramdbw.nux, paramdbw.yid, paramdbw.nuz, paramdbw.nuA, Integer.valueOf(paramdbw.nuB) });
    }
    AppMethodBeat.o(79391);
  }
  
  private void a(i parami, LinkedList<bg> paramLinkedList)
  {
    AppMethodBeat.i(79386);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      Iterator localIterator = paramLinkedList.iterator();
      if (localIterator.hasNext())
      {
        bg localbg = (bg)localIterator.next();
        paramLinkedList = g.ca(localbg.npZ, true);
        if (paramLinkedList != null)
        {
          a(paramLinkedList, localbg);
          parami.a(paramLinkedList, new String[0]);
        }
        for (;;)
        {
          this.vLC.add(paramLinkedList);
          break;
          paramLinkedList = new f();
          paramLinkedList.field_appId = localbg.npZ;
          a(paramLinkedList, localbg);
          parami.p(paramLinkedList);
        }
      }
    }
    AppMethodBeat.o(79386);
  }
  
  private static LinkedList<bwc> aI(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(79388);
    LinkedList localLinkedList = new LinkedList();
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(79388);
      return localLinkedList;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      String str = (String)paramLinkedList.next();
      if (!bo.isNullOrNil(str)) {
        localLinkedList.add(aa.wA(str));
      }
    }
    AppMethodBeat.o(79388);
    return localLinkedList;
  }
  
  private void b(i parami, LinkedList<brj> paramLinkedList)
  {
    AppMethodBeat.i(79387);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        brj localbrj = (brj)localIterator.next();
        if (bo.isNullOrNil(localbrj.npZ))
        {
          ab.e("MicroMsg.NetSceneGetSuggestionAppList", "error appinfo, the appid is null");
        }
        else
        {
          boolean bool4 = true;
          boolean bool1 = true;
          boolean bool3 = false;
          paramLinkedList = g.ca(localbrj.npZ, true);
          label137:
          boolean bool2;
          if (paramLinkedList != null)
          {
            a(paramLinkedList, localbrj);
            if (this.edl == 3)
            {
              paramLinkedList.field_status = 5;
              if ((bo.isNullOrNil(paramLinkedList.djR)) || (bo.isNullOrNil(paramLinkedList.djQ))) {
                if (paramLinkedList.djR != null)
                {
                  bool1 = true;
                  if (paramLinkedList.djQ == null) {
                    break label261;
                  }
                  bool2 = true;
                  label147:
                  ab.e("MicroMsg.NetSceneGetSuggestionAppList", "wrong suggestion params1, has IntroUrl %s, has IconUrl %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                  bool1 = false;
                }
              }
            }
            for (bool2 = false;; bool2 = parami.a(paramLinkedList, new String[0]))
            {
              ab.i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[] { localbrj.npZ, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
              label214:
              if ((!bool1) || (this.vLD.contains(localbrj.npZ)) || (this.vLB.contains(paramLinkedList))) {
                break label425;
              }
              this.vLB.add(paramLinkedList);
              break;
              bool1 = false;
              break label137;
              label261:
              bool2 = false;
              break label147;
            }
          }
          paramLinkedList = new f();
          paramLinkedList.field_appId = localbrj.npZ;
          a(paramLinkedList, localbrj);
          if (this.edl == 3)
          {
            paramLinkedList.field_status = 5;
            if ((bo.isNullOrNil(paramLinkedList.djR)) || (bo.isNullOrNil(paramLinkedList.djQ))) {
              if (paramLinkedList.djR != null)
              {
                bool1 = true;
                label346:
                if (paramLinkedList.djQ == null) {
                  break label432;
                }
                bool2 = true;
                label356:
                ab.e("MicroMsg.NetSceneGetSuggestionAppList", "wrong suggestion params2, has IntroUrl %s, has IconUrl %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                bool1 = false;
                bool2 = bool3;
              }
            }
          }
          for (;;)
          {
            ab.i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[] { localbrj.npZ, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
            break label214;
            label425:
            break;
            bool1 = false;
            break label346;
            label432:
            bool2 = false;
            break label356;
            bool2 = parami.p(paramLinkedList);
            bool1 = bool4;
          }
        }
      }
    }
    AppMethodBeat.o(79387);
  }
  
  private static void q(f paramf)
  {
    AppMethodBeat.i(79390);
    if ((!bo.isNullOrNil(paramf.field_appType)) && ((paramf.field_appType.startsWith("1")) || (paramf.field_appType.startsWith("6"))))
    {
      if (!paramf.field_appType.endsWith(",")) {
        paramf.field_appType += ",";
      }
      paramf.field_appType = ("," + paramf.field_appType);
    }
    AppMethodBeat.o(79390);
  }
  
  public final void bJ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(79394);
    if (paramArrayOfByte == null)
    {
      ab.e("MicroMsg.NetSceneGetSuggestionAppList", "buf is null");
      AppMethodBeat.o(79394);
      return;
    }
    b.c localc = this.lFp.fsW;
    try
    {
      localc.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(79394);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ab.e("MicroMsg.NetSceneGetSuggestionAppList", paramArrayOfByte.getMessage());
      ab.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(79394);
    }
  }
  
  public final int dlH()
  {
    return ((aqk)this.lFp.fsW.fta).xfO;
  }
  
  public final byte[] dli()
  {
    AppMethodBeat.i(79393);
    try
    {
      byte[] arrayOfByte = ((b.b)this.lFp.getReqObj()).toProtoBuf();
      AppMethodBeat.o(79393);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.NetSceneGetSuggestionAppList", localException.getMessage());
      ab.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", localException, "", new Object[0]);
      AppMethodBeat.o(79393);
    }
    return null;
  }
  
  public final int getType()
  {
    return 4;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(79385);
    ab.i("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(79385);
      return;
    }
    paramString = (aqk)this.lFp.fsW.fta;
    if (paramString == null)
    {
      ab.e("MicroMsg.NetSceneGetSuggestionAppList", "resp == null");
      AppMethodBeat.o(79385);
      return;
    }
    ab.v("MicroMsg.NetSceneGetSuggestionAppList", "suggestion app count = %s, appType = %s, ", new Object[] { Integer.valueOf(paramString.xfO), Integer.valueOf(this.edl) });
    paramq = a.a.caj().cah();
    b(paramq, paramString.xfP);
    a(paramq, paramString.ntB);
    AppMethodBeat.o(79385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ad
 * JD-Core Version:    0.7.0.1
 */