package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.h.c.r;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.z.a;
import com.tencent.mm.protocal.c.abe;
import com.tencent.mm.protocal.c.abf;
import com.tencent.mm.protocal.c.ij;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ae
  extends x
{
  private static final String[] rUL = { "wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b" };
  
  public ae(List<String> paramList)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new abe();
    ((b.a)localObject).ecI = new abf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getappinfolist";
    ((b.a)localObject).ecG = 451;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.jvQ = ((b.a)localObject).Kt();
    localObject = (abe)this.jvQ.ecE.ecN;
    LinkedList localLinkedList = new LinkedList();
    if (paramList != null)
    {
      String[] arrayOfString = new String[paramList.size()];
      paramList.toArray(arrayOfString);
      int j = arrayOfString.length;
      while (i < j)
      {
        paramList = arrayOfString[i];
        if (!bk.bl(paramList)) {
          localLinkedList.add(aa.pj(paramList));
        }
        i += 1;
      }
    }
    ((abe)localObject).taH = localLinkedList;
    ((abe)localObject).hPS = localLinkedList.size();
  }
  
  private static void a(f paramf, ij paramij)
  {
    int k = 0;
    if (paramf == null)
    {
      paramf = new f();
      paramf.field_appId = paramij.euK;
    }
    for (int i = 1;; i = 0)
    {
      y.i("MicroMsg.NetSceneGetAppInfoList", "appid:[%s], appinfoflag:[%d] AppSupportContentType:%d", new Object[] { paramij.euK, Integer.valueOf(paramij.kSe), Long.valueOf(paramij.sCC) });
      y.i("MicroMsg.NetSceneGetAppInfoList", "appId=%s, appName=%s, status=%s, appInfoFlag=%s", new Object[] { paramf.field_appId, paramf.field_appName, Integer.valueOf(paramf.field_status), Integer.valueOf(paramf.field_appInfoFlag) });
      if ((!paramf.ckN()) || (bk.bl(paramf.field_appName))) {
        paramf.field_appName = paramij.kRZ;
      }
      if ((!paramf.ckN()) || (bk.bl(paramf.field_appName_en))) {
        paramf.field_appName_en = paramij.sCn;
      }
      if ((!paramf.ckN()) || (bk.bl(paramf.field_appName_tw))) {
        paramf.field_appName_tw = paramij.sCp;
      }
      paramf.field_appDiscription = paramij.sxZ;
      paramf.field_appDiscription_en = paramij.sCo;
      paramf.field_appDiscription_tw = paramij.sCq;
      paramf.field_appWatermarkUrl = paramij.sCu;
      paramf.field_packageName = paramij.sux;
      paramf.field_signature = p.VY(paramij.sCv);
      y.i("MicroMsg.NetSceneGetAppInfoList", "get signature, server sig : %s, gen sig: %s ", new Object[] { paramij.sCv, paramf.field_signature });
      paramf.field_appType = paramij.sCw;
      if ((!bk.bl(paramf.field_appType)) && ((paramf.field_appType.startsWith("1")) || (paramf.field_appType.startsWith("6")))) {
        paramf.field_appType = ("," + paramf.field_appType);
      }
      paramf.field_appInfoFlag = paramij.kSe;
      paramf.field_appVersion = paramij.sCy;
      paramf.cM(paramij.sCx);
      paramf.field_appWatermarkUrl = paramij.sCu;
      if ((!bk.bl(paramij.sww)) && (!bk.bl(paramij.sCB)))
      {
        y.i("MicroMsg.NetSceneGetAppInfoList", "get app download url and download md5 : [%s], [%s], [%s]", new Object[] { paramf.field_appName, paramij.sww, paramij.sCB });
        paramf.cN(paramij.sww);
        paramf.cQ(paramij.sCB);
      }
      paramf.cR(paramij.suy);
      paramf.field_svrAppSupportContentType = paramij.sCC;
      if (paramij.sCz > paramf.cvz)
      {
        paramf.cvA = 1;
        paramf.cuS = true;
      }
      paramf.cvz = paramij.sCz;
      paramf.cuS = true;
      Object localObject = paramij.sux;
      String str = paramij.sux;
      int j;
      if ((localObject == null) || (((String)localObject).length() == 0) || (str == null) || (str.length() == 0))
      {
        j = 1;
        if (j != 0) {
          y.e("MicroMsg.NetSceneGetAppInfoList", "no android app, packageName = " + paramij.sux + "appid: " + paramf.field_appId);
        }
        if (paramf.ZH()) {
          com.tencent.mm.pluginsdk.ui.tools.b.WU(paramf.field_appId);
        }
        localObject = a.brn();
        if (i == 0) {
          break label736;
        }
        if (j == 0) {
          break label668;
        }
        i = 3;
        label587:
        paramf.field_status = i;
        paramf.field_modifyTime = System.currentTimeMillis();
        paramf.field_appIconUrl = paramij.sCs;
        if (paramf.field_appId != null) {
          i = k;
        }
      }
      for (;;)
      {
        if (i < rUL.length)
        {
          if (paramf.field_appId.equals(rUL[i])) {
            paramf.field_status = -1;
          }
        }
        else
        {
          if (((i)localObject).l(paramf)) {
            break label680;
          }
          y.e("MicroMsg.NetSceneGetAppInfoList", "onGYNetEnd : insert fail");
          return;
          j = 0;
          break;
          label668:
          i = 4;
          break label587;
        }
        i += 1;
      }
      label680:
      a.brl().dg(paramf.field_appId, 1);
      a.brl().dg(paramf.field_appId, 2);
      a.brl().dg(paramf.field_appId, 3);
      a.brl().dg(paramf.field_appId, 4);
      a.brl().dg(paramf.field_appId, 5);
      return;
      label736:
      label756:
      boolean bool;
      if (j != 0)
      {
        i = 3;
        paramf.field_status = i;
        if (paramf.field_appId != null)
        {
          i = 0;
          if (i < rUL.length)
          {
            if (!paramf.field_appId.equals(rUL[i])) {
              break label957;
            }
            paramf.field_status = -1;
          }
        }
        if ((paramf != null) && (paramf.field_appIconUrl != null) && (paramf.field_appIconUrl.length() != 0)) {
          break label964;
        }
        i = 1;
        label807:
        if (i == 0) {
          break label1014;
        }
        y.i("MicroMsg.NetSceneGetAppInfoList", "oldIcon = %s, newIcon = %s", new Object[] { paramf.field_appIconUrl, paramij.sCs });
        paramf.field_appIconUrl = paramij.sCs;
        bool = ((i)localObject).a(paramf, new String[0]);
        a.brl().dg(paramf.field_appId, 1);
        a.brl().dg(paramf.field_appId, 2);
        a.brl().dg(paramf.field_appId, 3);
        a.brl().dg(paramf.field_appId, 4);
        a.brl().dg(paramf.field_appId, 5);
      }
      for (;;)
      {
        y.i("MicroMsg.NetSceneGetAppInfoList", "update appinfo " + bool + ", appid = " + paramij.euK);
        return;
        i = paramf.field_status;
        break;
        label957:
        i += 1;
        break label756;
        label964:
        if ((paramij == null) || (paramij.sCA == null) || (paramij.sCA.length() == 0))
        {
          i = 0;
          break label807;
        }
        if (!paramf.field_appIconUrl.equals(paramij.sCs))
        {
          i = 1;
          break label807;
        }
        i = 0;
        break label807;
        label1014:
        bool = ((i)localObject).a(paramf, new String[0]);
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetAppInfoList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      y.e("MicroMsg.NetSceneGetAppInfoList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    }
    for (;;)
    {
      return;
      paramString = ((abf)this.jvQ.ecF.ecN).taI;
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          paramq = (ij)paramString.next();
          if (paramq != null) {
            a(g.by(paramq.euK, false), paramq);
          }
        }
      }
    }
  }
  
  public final void bi(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      y.e("MicroMsg.NetSceneGetAppInfoList", "buf is null");
      return;
    }
    try
    {
      this.jvQ.ecF.A(paramArrayOfByte);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      y.e("MicroMsg.NetSceneGetAppInfoList", "parse error: " + paramArrayOfByte.getMessage());
      y.printErrStackTrace("MicroMsg.NetSceneGetAppInfoList", paramArrayOfByte, "", new Object[0]);
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
      y.e("MicroMsg.NetSceneGetAppInfoList", "toProtBuf failed: " + localException.getMessage());
    }
    return null;
  }
  
  public final int getType()
  {
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ae
 * JD-Core Version:    0.7.0.1
 */