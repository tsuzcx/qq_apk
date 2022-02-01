package com.tencent.mm.ui.transmit;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.l;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.model.az;
import com.tencent.mm.model.by;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.contact.ad;
import java.util.Iterator;
import java.util.List;

public final class d
  implements com.tencent.mm.plugin.messenger.a.e
{
  public final void X(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(39447);
    if ((paramString1 == null) || (paramString2 == null))
    {
      ac.w("MicroMsg.SendMsgMgr", "send msg args error, toUser[%s] content[%s]", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(39447);
      return;
    }
    paramString1 = new com.tencent.mm.modelmulti.i(paramString1, paramString2, paramInt, 0);
    az.agi().a(paramString1, 0);
    AppMethodBeat.o(39447);
  }
  
  public final void a(final Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    AppMethodBeat.i(163393);
    if ((paramString1 == null) || (paramString2 == null))
    {
      ac.w("MicroMsg.SendMsgMgr", "sendImg: args error, toUser[%s], fileName[%s]", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(163393);
      return;
    }
    az.ayM();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      ac.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
      com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(180114);
          Toast.makeText(paramContext, 2131761376, 1).show();
          AppMethodBeat.o(180114);
        }
      });
      AppMethodBeat.o(163393);
      return;
    }
    paramContext = new l(u.axw(), paramString1, paramString2, paramInt, paramString3, paramString4, paramLong, paramString5);
    az.agi().a(paramContext, 0);
    by.azu().d(by.hpK, null);
    AppMethodBeat.o(163393);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, dev paramdev, String paramString4, String paramString5)
  {
    AppMethodBeat.i(163392);
    if (paramContext == null)
    {
      ac.w("MicroMsg.SendMsgMgr", "send vedio context is null");
      AppMethodBeat.o(163392);
      return;
    }
    if ((paramString1 == null) || (paramString2 == null))
    {
      ac.w("MicroMsg.SendMsgMgr", "send vedio args error, toUser[%s] fileName[%s]", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(163392);
      return;
    }
    az.ayM();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      ac.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
      com.tencent.e.e.e.et(paramContext).fEo().a(new com.tencent.e.e.a() {});
      AppMethodBeat.o(163392);
      return;
    }
    final MsgRetransmitUI.a locala = new MsgRetransmitUI.a();
    Dialog localDialog = (Dialog)com.tencent.e.e.e.et(paramContext).fEo().a(new com.tencent.e.e.a() {}).take();
    locala.context = paramContext;
    locala.fileName = paramString2;
    locala.IWp = paramString3;
    locala.tipDialog = localDialog;
    locala.userName = paramString1;
    locala.dvs = paramString4;
    locala.IWs = false;
    if (62 == paramInt1) {
      locala.hYQ = 11;
    }
    if (paramInt1 > 0) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      locala.IVI = paramInt1;
      locala.hpy = paramInt2;
      locala.IWq = false;
      locala.IWt = paramdev;
      locala.iaU = paramString5;
      locala.execute(new Object[0]);
      AppMethodBeat.o(163392);
      return;
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5)
  {
    AppMethodBeat.i(163391);
    a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, null, paramString4, paramString5);
    AppMethodBeat.o(163391);
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3)
  {
    AppMethodBeat.i(39451);
    if (paramString1 == null)
    {
      ac.w("MicroMsg.SendMsgMgr", "sendAppMsg: args error, toUser is null");
      AppMethodBeat.o(39451);
      return;
    }
    ac.v("MicroMsg.SendMsgMgr", "for track bug sendAppMsg %s", new Object[] { paramString2 });
    k.b localb = k.b.vA(bs.aLx(paramString2));
    if (localb == null)
    {
      ac.w("MicroMsg.SendMsgMgr", "send: parse app msg content return null");
      AppMethodBeat.o(39451);
      return;
    }
    Object localObject = new com.tencent.mm.pluginsdk.model.app.c();
    ac.i("MicroMsg.SendMsgMgr", "content.attachid %s", new Object[] { localb.cZa });
    paramString2 = (String)localObject;
    if (!bs.isNullOrNil(localb.cZa))
    {
      long l = bs.getLong(localb.cZa, -1L);
      if (l == -1L) {
        break label404;
      }
      com.tencent.mm.pluginsdk.model.app.ap.bEO().get(l, (com.tencent.mm.sdk.e.c)localObject);
      paramString2 = (String)localObject;
      if (((com.tencent.mm.pluginsdk.model.app.c)localObject).systemRowid != l)
      {
        localObject = com.tencent.mm.pluginsdk.model.app.ap.bEO().aGd(localb.cZa);
        if (localObject != null)
        {
          paramString2 = (String)localObject;
          if (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_mediaSvrId.equals(localb.cZa)) {}
        }
        else
        {
          paramString2 = null;
        }
        if (paramString2 != null) {
          break label364;
        }
        ac.i("MicroMsg.SendMsgMgr", "appAttachInfo1  %s", new Object[] { localb.cZa });
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
            az.ayM();
            localObject = m.aj(com.tencent.mm.model.c.awT(), localb.title, localb.hhG);
            com.tencent.mm.vfs.i.lZ(paramString2.field_fileFullPath, (String)localObject);
            ac.i("MicroMsg.SendMsgMgr", "copy from src %s to dest %s size: %s", new Object[] { paramString2.field_fileFullPath, localObject, Long.valueOf(com.tencent.mm.vfs.i.aSp(paramString2.field_fileFullPath)) });
          }
        }
      }
      paramString2 = k.b.a(localb);
      paramString2.hhI = 3;
      m.a(paramString2, localb.appId, localb.appName, paramString1, (String)localObject, paramArrayOfByte, paramString3);
      AppMethodBeat.o(39451);
      return;
      label364:
      ac.i("MicroMsg.SendMsgMgr", "appAttachInfo2  %s : %s : %s", new Object[] { localb.cZa, Long.valueOf(paramString2.systemRowid), paramString2.field_fileFullPath });
      continue;
      label404:
      localObject = com.tencent.mm.pluginsdk.model.app.ap.bEO().aGd(localb.cZa);
      if (localObject != null)
      {
        paramString2 = (String)localObject;
        if (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_mediaSvrId.equals(localb.cZa)) {}
      }
      else
      {
        paramString2 = null;
      }
      if (paramString2 == null) {
        ac.i("MicroMsg.SendMsgMgr", "appAttachInfo3  %s", new Object[] { localb.cZa });
      } else {
        ac.i("MicroMsg.SendMsgMgr", "appAttachInfo4  %s : %s : %s", new Object[] { localb.cZa, Long.valueOf(paramString2.systemRowid), paramString2.field_fileFullPath });
      }
    }
  }
  
  public final void hF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(39453);
    paramString2 = bs.S(bs.bG(paramString2, "").split(","));
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        String str = (String)paramString2.next();
        sk localsk = new sk();
        localsk.dvv.dvw = str;
        localsk.dvv.content = paramString1;
        localsk.dvv.type = w.xt(str);
        localsk.dvv.flags = 0;
        com.tencent.mm.sdk.b.a.GpY.l(localsk);
      }
    }
    AppMethodBeat.o(39453);
  }
  
  public final void q(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(39452);
    if (paramBoolean)
    {
      paramString2 = bs.bG(paramString2, "");
      str = ad.aRb(paramString1);
      if (ai.aNc(paramString1)) {}
      for (i = 66;; i = 42)
      {
        paramString1 = new com.tencent.mm.modelmulti.i(paramString2, str, i, 0);
        az.agi().a(paramString1, 0);
        AppMethodBeat.o(39452);
        return;
      }
    }
    paramString2 = bs.S(bs.bG(paramString2, "").split(","));
    String str = ad.aRb(paramString1);
    int i = 0;
    if (i < paramString2.size())
    {
      Object localObject = (String)paramString2.get(i);
      if (ai.aNc(paramString1)) {}
      for (int j = 66;; j = 42)
      {
        localObject = new com.tencent.mm.modelmulti.i((String)localObject, str, j, 0);
        az.agi().a((n)localObject, 0);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(39452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.d
 * JD-Core Version:    0.7.0.1
 */