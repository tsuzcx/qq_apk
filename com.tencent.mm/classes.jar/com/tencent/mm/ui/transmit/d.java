package com.tencent.mm.ui.transmit;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.e.e.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.vfs.i;
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
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SendMsgMgr", "sendImg: args error, toUser[%s], fileName[%s]", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(163393);
      return;
    }
    ba.aBQ();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
      aq.f(new Runnable()
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
    paramContext = u.aAm();
    o.e locale = o.a(o.d.ifX).pk(4);
    locale.dyU = paramContext;
    locale.toUser = paramString1;
    locale.ibF = paramString2;
    locale.hZz = paramInt;
    locale.igd = null;
    locale.dxr = 0;
    locale.hZI = paramString3;
    locale.thumbPath = paramString4;
    locale.igg = true;
    locale.igf = 2131231564;
    locale.igh = paramLong;
    locale.igj = paramString5;
    locale.igc = 13;
    locale.aJv().execute();
    bz.aCx().d(bz.hIc, null);
    AppMethodBeat.o(163393);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, dki paramdki, String paramString4, String paramString5)
  {
    AppMethodBeat.i(163392);
    if (paramContext == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SendMsgMgr", "send vedio context is null");
      AppMethodBeat.o(163392);
      return;
    }
    if ((paramString1 == null) || (paramString2 == null))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SendMsgMgr", "send vedio args error, toUser[%s] fileName[%s]", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(163392);
      return;
    }
    ba.aBQ();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
      e.ew(paramContext).fVG().a(new com.tencent.e.e.a() {});
      AppMethodBeat.o(163392);
      return;
    }
    final MsgRetransmitUI.a locala = new MsgRetransmitUI.a();
    Dialog localDialog = (Dialog)e.ew(paramContext).fVG().a(new com.tencent.e.e.a() {}).take();
    locala.context = paramContext;
    locala.fileName = paramString2;
    locala.KNt = paramString3;
    locala.tipDialog = localDialog;
    locala.userName = paramString1;
    locala.dHv = paramString4;
    locala.KNw = false;
    if (62 == paramInt1) {
      locala.ism = 11;
    }
    if (paramInt1 > 0) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      locala.KMM = paramInt1;
      locala.hHQ = paramInt2;
      locala.KNu = false;
      locala.KNx = paramdki;
      locala.iuq = paramString5;
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
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SendMsgMgr", "sendAppMsg: args error, toUser is null");
      AppMethodBeat.o(39451);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.SendMsgMgr", "for track bug sendAppMsg %s", new Object[] { paramString2 });
    k.b localb = k.b.yr(bt.aRd(paramString2));
    if (localb == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SendMsgMgr", "send: parse app msg content return null");
      AppMethodBeat.o(39451);
      return;
    }
    Object localObject = new com.tencent.mm.pluginsdk.model.app.c();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SendMsgMgr", "content.attachid %s", new Object[] { localb.dks });
    paramString2 = (String)localObject;
    if (!bt.isNullOrNil(localb.dks))
    {
      long l = bt.getLong(localb.dks, -1L);
      if (l == -1L) {
        break label406;
      }
      ao.bIX().get(l, (com.tencent.mm.sdk.e.c)localObject);
      paramString2 = (String)localObject;
      if (((com.tencent.mm.pluginsdk.model.app.c)localObject).systemRowid != l)
      {
        localObject = ao.bIX().aLD(localb.dks);
        if (localObject != null)
        {
          paramString2 = (String)localObject;
          if (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_mediaSvrId.equals(localb.dks)) {}
        }
        else
        {
          paramString2 = null;
        }
        if (paramString2 != null) {
          break label366;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SendMsgMgr", "appAttachInfo1  %s", new Object[] { localb.dks });
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
            ba.aBQ();
            localObject = m.aq(com.tencent.mm.model.c.azI(), localb.title, localb.hzP);
            i.mz(paramString2.field_fileFullPath, (String)localObject);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SendMsgMgr", "copy from src %s to dest %s size: %s", new Object[] { paramString2.field_fileFullPath, localObject, Long.valueOf(i.aYo(paramString2.field_fileFullPath)) });
          }
        }
      }
      paramString2 = k.b.a(localb);
      paramString2.hzR = 3;
      m.a(paramString2, localb.appId, localb.appName, paramString1, (String)localObject, paramArrayOfByte, paramString3);
      AppMethodBeat.o(39451);
      return;
      label366:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SendMsgMgr", "appAttachInfo2  %s : %s : %s", new Object[] { localb.dks, Long.valueOf(paramString2.systemRowid), paramString2.field_fileFullPath });
      continue;
      label406:
      localObject = ao.bIX().aLD(localb.dks);
      if (localObject != null)
      {
        paramString2 = (String)localObject;
        if (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_mediaSvrId.equals(localb.dks)) {}
      }
      else
      {
        paramString2 = null;
      }
      if (paramString2 == null) {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SendMsgMgr", "appAttachInfo3  %s", new Object[] { localb.dks });
      } else {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SendMsgMgr", "appAttachInfo4  %s : %s : %s", new Object[] { localb.dks, Long.valueOf(paramString2.systemRowid), paramString2.field_fileFullPath });
      }
    }
  }
  
  public final void aa(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(39447);
    if ((paramString1 == null) || (paramString2 == null))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SendMsgMgr", "send msg args error, toUser[%s] content[%s]", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(39447);
      return;
    }
    o.e locale = o.FX(paramString1);
    locale.toUser = paramString1;
    locale.content = paramString2;
    locale.type = paramInt;
    locale.dDp = 0;
    locale.igc = 4;
    locale.aJv().execute();
    AppMethodBeat.o(39447);
  }
  
  public final void hP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(39453);
    paramString2 = bt.U(bt.bI(paramString2, "").split(","));
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        String str = (String)paramString2.next();
        sx localsx = new sx();
        localsx.dHy.dHz = str;
        localsx.dHy.content = paramString1;
        localsx.dHy.type = w.Ar(str);
        localsx.dHy.flags = 0;
        com.tencent.mm.sdk.b.a.IbL.l(localsx);
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
      paramString2 = bt.bI(paramString2, "");
      str = com.tencent.mm.ui.contact.ad.aWZ(paramString1);
      localObject = o.FX(paramString2);
      ((o.e)localObject).toUser = paramString2;
      ((o.e)localObject).content = str;
      if (am.aSQ(paramString1)) {}
      for (i = 66;; i = 42)
      {
        ((o.e)localObject).type = i;
        ((o.e)localObject).dDp = 0;
        ((o.e)localObject).igc = 4;
        ((o.e)localObject).aJv().execute();
        AppMethodBeat.o(39452);
        return;
      }
    }
    paramString2 = bt.U(bt.bI(paramString2, "").split(","));
    String str = com.tencent.mm.ui.contact.ad.aWZ(paramString1);
    int i = 0;
    if (i < paramString2.size())
    {
      localObject = (String)paramString2.get(i);
      o.e locale = o.FX((String)localObject);
      locale.toUser = ((String)localObject);
      locale.content = str;
      if (am.aSQ(paramString1)) {}
      for (int j = 66;; j = 42)
      {
        locale.type = j;
        locale.dDp = 0;
        locale.igc = 4;
        locale.aJv().execute();
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