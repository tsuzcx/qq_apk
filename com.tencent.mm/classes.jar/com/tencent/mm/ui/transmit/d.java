package com.tencent.mm.ui.transmit;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.e.e.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.contact.ad;
import java.util.Iterator;
import java.util.List;

public final class d
  implements com.tencent.mm.plugin.messenger.a.d
{
  public final void a(final Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    AppMethodBeat.i(163393);
    if ((paramString1 == null) || (paramString2 == null))
    {
      ae.w("MicroMsg.SendMsgMgr", "sendImg: args error, toUser[%s], fileName[%s]", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(163393);
      return;
    }
    bc.aCg();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      ae.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
      ar.f(new Runnable()
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
    paramContext = v.aAC();
    o.e locale = com.tencent.mm.modelmulti.o.a(o.d.iiQ).pn(4);
    locale.dzZ = paramContext;
    locale.toUser = paramString1;
    locale.iey = paramString2;
    locale.icr = paramInt;
    locale.iiW = null;
    locale.dyw = 0;
    locale.icA = paramString3;
    locale.thumbPath = paramString4;
    locale.iiZ = true;
    locale.iiY = 2131231564;
    locale.ija = paramLong;
    locale.ijc = paramString5;
    locale.iiV = 13;
    locale.aJO().execute();
    cb.aCN().d(cb.hKU, null);
    AppMethodBeat.o(163393);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, dld paramdld, String paramString4, String paramString5)
  {
    AppMethodBeat.i(163392);
    if (paramContext == null)
    {
      ae.w("MicroMsg.SendMsgMgr", "send vedio context is null");
      AppMethodBeat.o(163392);
      return;
    }
    if ((paramString1 == null) || (paramString2 == null))
    {
      ae.w("MicroMsg.SendMsgMgr", "send vedio args error, toUser[%s] fileName[%s]", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(163392);
      return;
    }
    bc.aCg();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      ae.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
      e.ez(paramContext).gaf().a(new com.tencent.e.e.a() {});
      AppMethodBeat.o(163392);
      return;
    }
    final MsgRetransmitUI.a locala = new MsgRetransmitUI.a();
    Dialog localDialog = (Dialog)e.ez(paramContext).gaf().a(new com.tencent.e.e.a() {}).take();
    locala.context = paramContext;
    locala.fileName = paramString2;
    locala.LjR = paramString3;
    locala.tipDialog = localDialog;
    locala.userName = paramString1;
    locala.dIA = paramString4;
    locala.LjU = false;
    if (62 == paramInt1) {
      locala.ivg = 11;
    }
    if (paramInt1 > 0) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      locala.Ljk = paramInt1;
      locala.hKI = paramInt2;
      locala.LjS = false;
      locala.LjV = paramdld;
      locala.ixk = paramString5;
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
      ae.w("MicroMsg.SendMsgMgr", "sendAppMsg: args error, toUser is null");
      AppMethodBeat.o(39451);
      return;
    }
    ae.v("MicroMsg.SendMsgMgr", "for track bug sendAppMsg %s", new Object[] { paramString2 });
    k.b localb = k.b.zb(bu.aSA(paramString2));
    if (localb == null)
    {
      ae.w("MicroMsg.SendMsgMgr", "send: parse app msg content return null");
      AppMethodBeat.o(39451);
      return;
    }
    Object localObject = new com.tencent.mm.pluginsdk.model.app.c();
    ae.i("MicroMsg.SendMsgMgr", "content.attachid %s", new Object[] { localb.dlu });
    paramString2 = (String)localObject;
    if (!bu.isNullOrNil(localb.dlu))
    {
      long l = bu.getLong(localb.dlu, -1L);
      if (l == -1L) {
        break label406;
      }
      ao.bJV().get(l, (com.tencent.mm.sdk.e.c)localObject);
      paramString2 = (String)localObject;
      if (((com.tencent.mm.pluginsdk.model.app.c)localObject).systemRowid != l)
      {
        localObject = ao.bJV().aMZ(localb.dlu);
        if (localObject != null)
        {
          paramString2 = (String)localObject;
          if (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_mediaSvrId.equals(localb.dlu)) {}
        }
        else
        {
          paramString2 = null;
        }
        if (paramString2 != null) {
          break label366;
        }
        ae.i("MicroMsg.SendMsgMgr", "appAttachInfo1  %s", new Object[] { localb.dlu });
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
            bc.aCg();
            localObject = m.aq(com.tencent.mm.model.c.azY(), localb.title, localb.hCD);
            com.tencent.mm.vfs.o.mF(paramString2.field_fileFullPath, (String)localObject);
            ae.i("MicroMsg.SendMsgMgr", "copy from src %s to dest %s size: %s", new Object[] { paramString2.field_fileFullPath, localObject, Long.valueOf(com.tencent.mm.vfs.o.aZR(paramString2.field_fileFullPath)) });
          }
        }
      }
      paramString2 = k.b.a(localb);
      paramString2.hCF = 3;
      m.a(paramString2, localb.appId, localb.appName, paramString1, (String)localObject, paramArrayOfByte, paramString3);
      AppMethodBeat.o(39451);
      return;
      label366:
      ae.i("MicroMsg.SendMsgMgr", "appAttachInfo2  %s : %s : %s", new Object[] { localb.dlu, Long.valueOf(paramString2.systemRowid), paramString2.field_fileFullPath });
      continue;
      label406:
      localObject = ao.bJV().aMZ(localb.dlu);
      if (localObject != null)
      {
        paramString2 = (String)localObject;
        if (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_mediaSvrId.equals(localb.dlu)) {}
      }
      else
      {
        paramString2 = null;
      }
      if (paramString2 == null) {
        ae.i("MicroMsg.SendMsgMgr", "appAttachInfo3  %s", new Object[] { localb.dlu });
      } else {
        ae.i("MicroMsg.SendMsgMgr", "appAttachInfo4  %s : %s : %s", new Object[] { localb.dlu, Long.valueOf(paramString2.systemRowid), paramString2.field_fileFullPath });
      }
    }
  }
  
  public final void aa(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(39447);
    if ((paramString1 == null) || (paramString2 == null))
    {
      ae.w("MicroMsg.SendMsgMgr", "send msg args error, toUser[%s] content[%s]", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(39447);
      return;
    }
    o.e locale = com.tencent.mm.modelmulti.o.Gz(paramString1);
    locale.toUser = paramString1;
    locale.content = paramString2;
    locale.type = paramInt;
    locale.dEu = 0;
    locale.iiV = 4;
    locale.aJO().execute();
    AppMethodBeat.o(39447);
  }
  
  public final void hW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(39453);
    paramString2 = bu.U(bu.bI(paramString2, "").split(","));
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        String str = (String)paramString2.next();
        sy localsy = new sy();
        localsy.dID.cUB = str;
        localsy.dID.content = paramString1;
        localsy.dID.type = x.Bb(str);
        localsy.dID.flags = 0;
        com.tencent.mm.sdk.b.a.IvT.l(localsy);
      }
    }
    AppMethodBeat.o(39453);
  }
  
  public final void q(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(39452);
    Object localObject;
    if (paramBoolean)
    {
      paramString2 = bu.bI(paramString2, "");
      str = ad.aYA(paramString1);
      localObject = com.tencent.mm.modelmulti.o.Gz(paramString2);
      ((o.e)localObject).toUser = paramString2;
      ((o.e)localObject).content = str;
      if (an.aUq(paramString1)) {}
      for (i = 66;; i = 42)
      {
        ((o.e)localObject).type = i;
        ((o.e)localObject).dEu = 0;
        ((o.e)localObject).iiV = 4;
        ((o.e)localObject).aJO().execute();
        AppMethodBeat.o(39452);
        return;
      }
    }
    paramString2 = bu.U(bu.bI(paramString2, "").split(","));
    String str = ad.aYA(paramString1);
    int i = 0;
    if (i < paramString2.size())
    {
      localObject = (String)paramString2.get(i);
      o.e locale = com.tencent.mm.modelmulti.o.Gz((String)localObject);
      locale.toUser = ((String)localObject);
      locale.content = str;
      if (an.aUq(paramString1)) {}
      for (int j = 66;; j = 42)
      {
        locale.type = j;
        locale.dEu = 0;
        locale.iiV = 4;
        locale.aJO().execute();
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