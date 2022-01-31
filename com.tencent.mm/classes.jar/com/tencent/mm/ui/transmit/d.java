package com.tencent.mm.ui.transmit;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.contact.aa;
import com.tencent.mm.vfs.e;
import java.util.Iterator;
import java.util.List;

public final class d
  implements com.tencent.mm.plugin.messenger.a.d
{
  public final void K(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(35240);
    if ((paramString1 == null) || (paramString2 == null))
    {
      ab.w("MicroMsg.SendMsgMgr", "send msg args error, toUser[%s] content[%s]", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(35240);
      return;
    }
    paramString1 = new com.tencent.mm.modelmulti.h(paramString1, paramString2, paramInt);
    aw.Rc().a(paramString1, 0);
    AppMethodBeat.o(35240);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(35243);
    if ((paramString1 == null) || (paramString2 == null))
    {
      ab.w("MicroMsg.SendMsgMgr", "sendImg: args error, toUser[%s], fileName[%s]", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(35243);
      return;
    }
    aw.aaz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      ab.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
      Toast.makeText(paramContext, 2131301644, 1).show();
      AppMethodBeat.o(35243);
      return;
    }
    paramContext = new com.tencent.mm.at.l(4, r.Zn(), paramString1, paramString2, paramInt, null, 0, paramString3, paramString4, true, 2130838228);
    aw.Rc().a(paramContext, 0);
    bv.abc().c(bv.fnI, null);
    AppMethodBeat.o(35243);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, cii paramcii, String paramString4)
  {
    int i = 1;
    AppMethodBeat.i(35242);
    if (paramContext == null)
    {
      ab.w("MicroMsg.SendMsgMgr", "send vedio context is null");
      AppMethodBeat.o(35242);
      return;
    }
    if ((paramString1 == null) || (paramString2 == null))
    {
      ab.w("MicroMsg.SendMsgMgr", "send vedio args error, toUser[%s] fileName[%s]", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(35242);
      return;
    }
    aw.aaz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      ab.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
      Toast.makeText(paramContext, 2131301644, 1).show();
      AppMethodBeat.o(35242);
      return;
    }
    MsgRetransmitUI.a locala = new MsgRetransmitUI.a();
    paramContext.getResources().getString(2131297087);
    com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getResources().getString(2131297069), true, new d.1(this, locala));
    locala.context = paramContext;
    locala.fileName = paramString2;
    locala.AzH = paramString3;
    locala.gKM = localp;
    locala.userName = paramString1;
    locala.cGU = paramString4;
    locala.AzK = false;
    if (62 == paramInt1) {
      locala.fVF = 11;
    }
    if (paramInt1 > 0) {}
    for (paramInt1 = i;; paramInt1 = 0)
    {
      locala.Azc = paramInt1;
      locala.fXx = paramInt2;
      locala.AzI = false;
      locala.AzL = paramcii;
      locala.execute(new Object[0]);
      AppMethodBeat.o(35242);
      return;
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(35241);
    a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, null, paramString4);
    AppMethodBeat.o(35241);
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3)
  {
    AppMethodBeat.i(35244);
    if (paramString1 == null)
    {
      ab.w("MicroMsg.SendMsgMgr", "sendAppMsg: args error, toUser is null");
      AppMethodBeat.o(35244);
      return;
    }
    ab.v("MicroMsg.SendMsgMgr", "for track bug sendAppMsg %s", new Object[] { paramString2 });
    j.b localb = j.b.mY(bo.apU(paramString2));
    if (localb == null)
    {
      ab.w("MicroMsg.SendMsgMgr", "send: parse app msg content return null");
      AppMethodBeat.o(35244);
      return;
    }
    Object localObject = new b();
    ab.i("MicroMsg.SendMsgMgr", "content.attachid %s", new Object[] { localb.cmN });
    paramString2 = (String)localObject;
    if (!bo.isNullOrNil(localb.cmN))
    {
      long l = bo.getLong(localb.cmN, -1L);
      if (l == -1L) {
        break label404;
      }
      al.aUJ().get(l, (com.tencent.mm.sdk.e.c)localObject);
      paramString2 = (String)localObject;
      if (((b)localObject).systemRowid != l)
      {
        localObject = al.aUJ().alo(localb.cmN);
        if (localObject != null)
        {
          paramString2 = (String)localObject;
          if (((b)localObject).field_mediaSvrId.equals(localb.cmN)) {}
        }
        else
        {
          paramString2 = null;
        }
        if (paramString2 != null) {
          break label364;
        }
        ab.i("MicroMsg.SendMsgMgr", "appAttachInfo1  %s", new Object[] { localb.cmN });
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
            aw.aaz();
            localObject = com.tencent.mm.pluginsdk.model.app.l.Z(com.tencent.mm.model.c.YS(), localb.title, localb.fgx);
            e.C(paramString2.field_fileFullPath, (String)localObject);
            ab.i("MicroMsg.SendMsgMgr", "copy from src %s to dest %s size: %s", new Object[] { paramString2.field_fileFullPath, localObject, Long.valueOf(e.avI(paramString2.field_fileFullPath)) });
          }
        }
      }
      paramString2 = j.b.a(localb);
      paramString2.fgz = 3;
      com.tencent.mm.pluginsdk.model.app.l.a(paramString2, localb.appId, localb.appName, paramString1, (String)localObject, paramArrayOfByte, paramString3);
      AppMethodBeat.o(35244);
      return;
      label364:
      ab.i("MicroMsg.SendMsgMgr", "appAttachInfo2  %s : %s : %s", new Object[] { localb.cmN, Long.valueOf(paramString2.systemRowid), paramString2.field_fileFullPath });
      continue;
      label404:
      localObject = al.aUJ().alo(localb.cmN);
      if (localObject != null)
      {
        paramString2 = (String)localObject;
        if (((b)localObject).field_mediaSvrId.equals(localb.cmN)) {}
      }
      else
      {
        paramString2 = null;
      }
      if (paramString2 == null) {
        ab.i("MicroMsg.SendMsgMgr", "appAttachInfo3  %s", new Object[] { localb.cmN });
      } else {
        ab.i("MicroMsg.SendMsgMgr", "appAttachInfo4  %s : %s : %s", new Object[] { localb.cmN, Long.valueOf(paramString2.systemRowid), paramString2.field_fileFullPath });
      }
    }
  }
  
  public final void fh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(35246);
    paramString2 = bo.P(bo.bf(paramString2, "").split(","));
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        String str = (String)paramString2.next();
        qj localqj = new qj();
        localqj.cGX.cGY = str;
        localqj.cGX.content = paramString1;
        localqj.cGX.type = t.oF(str);
        localqj.cGX.flags = 0;
        a.ymk.l(localqj);
      }
    }
    AppMethodBeat.o(35246);
  }
  
  public final void q(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(35245);
    if (paramBoolean)
    {
      paramString2 = bo.bf(paramString2, "");
      str = aa.auE(paramString1);
      if (ad.arf(paramString1)) {}
      for (i = 66;; i = 42)
      {
        paramString1 = new com.tencent.mm.modelmulti.h(paramString2, str, i);
        aw.Rc().a(paramString1, 0);
        AppMethodBeat.o(35245);
        return;
      }
    }
    paramString2 = bo.P(bo.bf(paramString2, "").split(","));
    String str = aa.auE(paramString1);
    int i = 0;
    if (i < paramString2.size())
    {
      Object localObject = (String)paramString2.get(i);
      if (ad.arf(paramString1)) {}
      for (int j = 66;; j = 42)
      {
        localObject = new com.tencent.mm.modelmulti.h((String)localObject, str, j);
        aw.Rc().a((m)localObject, 0);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(35245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.d
 * JD-Core Version:    0.7.0.1
 */