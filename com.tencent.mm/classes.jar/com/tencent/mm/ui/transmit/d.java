package com.tencent.mm.ui.transmit;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.pe;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.protocal.c.bwa;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.contact.z;
import com.tencent.mm.vfs.e;
import java.util.Iterator;
import java.util.List;

public final class d
  implements com.tencent.mm.plugin.messenger.a.d
{
  public final void D(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString2 == null))
    {
      y.w("MicroMsg.SendMsgMgr", "send msg args error, toUser[%s] content[%s]", new Object[] { paramString1, paramString2 });
      return;
    }
    paramString1 = new com.tencent.mm.modelmulti.h(paramString1, paramString2, paramInt);
    au.Dk().a(paramString1, 0);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if ((paramString1 == null) || (paramString2 == null))
    {
      y.w("MicroMsg.SendMsgMgr", "sendImg: args error, toUser[%s], fileName[%s]", new Object[] { paramString1, paramString2 });
      return;
    }
    au.Hx();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      y.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
      Toast.makeText(paramContext, R.l.msgretr_share_nosdcard_fail, 1).show();
      return;
    }
    paramContext = new com.tencent.mm.as.l(4, q.Gj(), paramString1, paramString2, paramInt, null, 0, paramString3, paramString4, true, R.g.chat_img_template);
    au.Dk().a(paramContext, 0);
    bt.If().d(bt.dXD, null);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, bwa parambwa, String paramString4)
  {
    int i = 1;
    if (paramContext == null)
    {
      y.w("MicroMsg.SendMsgMgr", "send vedio context is null");
      return;
    }
    if ((paramString1 == null) || (paramString2 == null))
    {
      y.w("MicroMsg.SendMsgMgr", "send vedio args error, toUser[%s] fileName[%s]", new Object[] { paramString1, paramString2 });
      return;
    }
    au.Hx();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      y.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
      Toast.makeText(paramContext, R.l.msgretr_share_nosdcard_fail, 1).show();
      return;
    }
    MsgRetransmitUI.a locala = new MsgRetransmitUI.a();
    paramContext.getResources().getString(R.l.app_tip);
    com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getResources().getString(R.l.app_sending), true, new d.1(this, locala));
    locala.context = paramContext;
    locala.fileName = paramString2;
    locala.wgQ = paramString3;
    locala.ftk = localp;
    locala.userName = paramString1;
    locala.bYN = paramString4;
    locala.wgT = false;
    if (62 == paramInt1) {
      locala.eFO = 11;
    }
    if (paramInt1 > 0) {}
    for (paramInt1 = i;; paramInt1 = 0)
    {
      locala.wgl = paramInt1;
      locala.eHH = paramInt2;
      locala.wgR = false;
      locala.wgU = parambwa;
      locala.execute(new Object[0]);
      return;
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, null, paramString4);
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3)
  {
    if (paramString1 == null)
    {
      y.w("MicroMsg.SendMsgMgr", "sendAppMsg: args error, toUser is null");
      return;
    }
    y.v("MicroMsg.SendMsgMgr", "for track bug sendAppMsg %s", new Object[] { paramString2 });
    g.a locala = g.a.gp(bk.ZQ(paramString2));
    if (locala == null)
    {
      y.w("MicroMsg.SendMsgMgr", "send: parse app msg content return null");
      return;
    }
    Object localObject = new b();
    y.i("MicroMsg.SendMsgMgr", "content.attachid %s", new Object[] { locala.bFE });
    paramString2 = (String)localObject;
    if (!bk.bl(locala.bFE))
    {
      long l = bk.getLong(locala.bFE, -1L);
      if (l == -1L) {
        break label384;
      }
      ap.avh().b(l, (com.tencent.mm.sdk.e.c)localObject);
      paramString2 = (String)localObject;
      if (((b)localObject).ujK != l)
      {
        localObject = ap.avh().VQ(locala.bFE);
        if (localObject != null)
        {
          paramString2 = (String)localObject;
          if (((b)localObject).field_mediaSvrId.equals(locala.bFE)) {}
        }
        else
        {
          paramString2 = null;
        }
        if (paramString2 != null) {
          break label344;
        }
        y.i("MicroMsg.SendMsgMgr", "appAttachInfo1  %s", new Object[] { locala.bFE });
      }
    }
    for (;;)
    {
      String str = "";
      localObject = str;
      if (paramString2 != null)
      {
        localObject = str;
        if (paramString2.field_fileFullPath != null)
        {
          localObject = str;
          if (!paramString2.field_fileFullPath.equals(""))
          {
            au.Hx();
            localObject = com.tencent.mm.pluginsdk.model.app.l.aj(com.tencent.mm.model.c.FO(), locala.title, locala.dQw);
            e.r(paramString2.field_fileFullPath, (String)localObject);
            y.i("MicroMsg.SendMsgMgr", "copy from src %s to dest %s size: %s", new Object[] { paramString2.field_fileFullPath, localObject, Long.valueOf(e.aeQ(paramString2.field_fileFullPath)) });
          }
        }
      }
      paramString2 = g.a.a(locala);
      paramString2.dQy = 3;
      com.tencent.mm.pluginsdk.model.app.l.a(paramString2, locala.appId, locala.appName, paramString1, (String)localObject, paramArrayOfByte, paramString3);
      return;
      label344:
      y.i("MicroMsg.SendMsgMgr", "appAttachInfo2  %s : %s : %s", new Object[] { locala.bFE, Long.valueOf(paramString2.ujK), paramString2.field_fileFullPath });
      continue;
      label384:
      localObject = ap.avh().VQ(locala.bFE);
      if (localObject != null)
      {
        paramString2 = (String)localObject;
        if (((b)localObject).field_mediaSvrId.equals(locala.bFE)) {}
      }
      else
      {
        paramString2 = null;
      }
      if (paramString2 == null) {
        y.i("MicroMsg.SendMsgMgr", "appAttachInfo3  %s", new Object[] { locala.bFE });
      } else {
        y.i("MicroMsg.SendMsgMgr", "appAttachInfo4  %s : %s : %s", new Object[] { locala.bFE, Long.valueOf(paramString2.ujK), paramString2.field_fileFullPath });
      }
    }
  }
  
  public final void dO(String paramString1, String paramString2)
  {
    paramString2 = bk.G(bk.aM(paramString2, "").split(","));
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        String str = (String)paramString2.next();
        pe localpe = new pe();
        localpe.bYQ.bYR = str;
        localpe.bYQ.content = paramString1;
        localpe.bYQ.type = s.hW(str);
        localpe.bYQ.flags = 0;
        a.udP.m(localpe);
      }
    }
  }
  
  public final void o(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramString2 = bk.aM(paramString2, "");
      str = z.adW(paramString1);
      if (ad.aaU(paramString1)) {}
      for (i = 66;; i = 42)
      {
        paramString1 = new com.tencent.mm.modelmulti.h(paramString2, str, i);
        au.Dk().a(paramString1, 0);
        return;
      }
    }
    paramString2 = bk.G(bk.aM(paramString2, "").split(","));
    String str = z.adW(paramString1);
    int i = 0;
    label85:
    Object localObject;
    if (i < paramString2.size())
    {
      localObject = (String)paramString2.get(i);
      if (!ad.aaU(paramString1)) {
        break label154;
      }
    }
    label154:
    for (int j = 66;; j = 42)
    {
      localObject = new com.tencent.mm.modelmulti.h((String)localObject, str, j);
      au.Dk().a((m)localObject, 0);
      i += 1;
      break label85;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.d
 * JD-Core Version:    0.7.0.1
 */