package com.tencent.mm.ui.transmit;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.e.e.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.a.uz;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.messenger.a.d.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.af;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.List;

public final class f
  implements com.tencent.mm.plugin.messenger.a.d
{
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, eor parameor, String paramString4, String paramString5, d.a parama)
  {
    AppMethodBeat.i(281007);
    if (paramContext == null)
    {
      Log.w("MicroMsg.SendMsgMgr", "send vedio context is null");
      AppMethodBeat.o(281007);
      return;
    }
    if ((paramString1 == null) || (paramString2 == null))
    {
      Log.w("MicroMsg.SendMsgMgr", "send vedio args error, toUser[%s] fileName[%s]", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(281007);
      return;
    }
    bh.beI();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      Log.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
      e.eJ(paramContext).ipR().a(new com.tencent.e.e.a() {});
      AppMethodBeat.o(281007);
      return;
    }
    final MsgRetransmitUI.a locala = new MsgRetransmitUI.a();
    Dialog localDialog = (Dialog)e.eJ(paramContext).ipR().a(new com.tencent.e.e.a() {}).ipQ();
    locala.context = paramContext;
    locala.fileName = paramString2;
    locala.XXa = paramString3;
    locala.tipDialog = localDialog;
    locala.userName = paramString1;
    locala.fUk = paramString4;
    locala.XXd = false;
    if (62 == paramInt1) {
      locala.mfT = 11;
    }
    if (paramInt1 > 0) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      locala.XWq = paramInt1;
      locala.lvw = paramInt2;
      locala.XXb = false;
      locala.XXe = parameor;
      locala.mic = paramString5;
      locala.XXh = parama;
      locala.execute(new Object[0]);
      AppMethodBeat.o(281007);
      return;
    }
  }
  
  public final void a(final Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    AppMethodBeat.i(163393);
    if ((paramString1 == null) || (paramString2 == null))
    {
      Log.w("MicroMsg.SendMsgMgr", "sendImg: args error, toUser[%s], fileName[%s]", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(163393);
      return;
    }
    bh.beI();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      Log.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(180114);
          Toast.makeText(paramContext, R.l.eMf, 1).show();
          AppMethodBeat.o(180114);
        }
      });
      AppMethodBeat.o(163393);
      return;
    }
    paramContext = z.bcZ();
    o.e locale = o.a(o.d.lUk).wb(4);
    locale.fLi = paramContext;
    locale.toUser = paramString1;
    locale.lPO = paramString2;
    locale.lNK = paramInt;
    locale.lUr = null;
    locale.fJu = 0;
    locale.lNS = paramString3;
    locale.thumbPath = paramString4;
    locale.lUu = true;
    locale.lUt = R.g.chat_img_template;
    locale.lUv = paramLong;
    locale.lUx = paramString5;
    locale.lUq = 13;
    locale.bnl().aEv();
    cg.bfp().e(cg.lvK, null);
    AppMethodBeat.o(163393);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, eor parameor, String paramString4, String paramString5)
  {
    AppMethodBeat.i(163392);
    a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, parameor, paramString4, paramString5, null);
    AppMethodBeat.o(163392);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5)
  {
    AppMethodBeat.i(163391);
    a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, null, paramString4, paramString5, null);
    AppMethodBeat.o(163391);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, d.a parama)
  {
    AppMethodBeat.i(281006);
    a(paramContext, paramString1, paramString2, paramString3, 1, paramInt, null, paramString4, paramString5, parama);
    AppMethodBeat.o(281006);
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3)
  {
    AppMethodBeat.i(39451);
    if (paramString1 == null)
    {
      Log.w("MicroMsg.SendMsgMgr", "sendAppMsg: args error, toUser is null");
      AppMethodBeat.o(39451);
      return;
    }
    Log.v("MicroMsg.SendMsgMgr", "for track bug sendAppMsg %s", new Object[] { paramString2 });
    k.b localb = k.b.OQ(Util.processXml(paramString2));
    if (localb == null)
    {
      Log.w("MicroMsg.SendMsgMgr", "send: parse app msg content return null");
      AppMethodBeat.o(39451);
      return;
    }
    Object localObject1 = new com.tencent.mm.pluginsdk.model.app.c();
    Log.i("MicroMsg.SendMsgMgr", "content.attachid %s", new Object[] { localb.fvr });
    paramString2 = (String)localObject1;
    if (!Util.isNullOrNil(localb.fvr))
    {
      long l = Util.getLong(localb.fvr, -1L);
      if (l == -1L) {
        break label431;
      }
      ao.ctZ().get(l, (IAutoDBItem)localObject1);
      paramString2 = (String)localObject1;
      if (((com.tencent.mm.pluginsdk.model.app.c)localObject1).systemRowid != l)
      {
        localObject1 = ao.ctZ().bpR(localb.fvr);
        if (localObject1 != null)
        {
          paramString2 = (String)localObject1;
          if (((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_mediaSvrId.equals(localb.fvr)) {}
        }
        else
        {
          paramString2 = null;
        }
        if (paramString2 != null) {
          break label391;
        }
        Log.i("MicroMsg.SendMsgMgr", "appAttachInfo1  %s", new Object[] { localb.fvr });
      }
    }
    for (;;)
    {
      Object localObject2 = "";
      localObject1 = localObject2;
      if (paramString2 != null)
      {
        localObject1 = localObject2;
        if (paramString2.field_fileFullPath != null)
        {
          localObject1 = localObject2;
          if (!paramString2.field_fileFullPath.equals(""))
          {
            bh.beI();
            localObject1 = m.aw(com.tencent.mm.model.c.bce(), localb.title, localb.llY);
            u.on(paramString2.field_fileFullPath, (String)localObject1);
            Log.i("MicroMsg.SendMsgMgr", "copy from src %s to dest %s size: %s", new Object[] { paramString2.field_fileFullPath, localObject1, Long.valueOf(u.bBQ(paramString2.field_fileFullPath)) });
          }
        }
      }
      paramString2 = k.b.a(localb);
      paramString2.lma = 3;
      localObject2 = (com.tencent.mm.aj.a)paramString2.ar(com.tencent.mm.aj.a.class);
      if (localObject2 != null) {
        ((com.tencent.mm.aj.a)localObject2).lkz = false;
      }
      m.a(paramString2, localb.appId, localb.appName, paramString1, (String)localObject1, paramArrayOfByte, paramString3);
      AppMethodBeat.o(39451);
      return;
      label391:
      Log.i("MicroMsg.SendMsgMgr", "appAttachInfo2  %s : %s : %s", new Object[] { localb.fvr, Long.valueOf(paramString2.systemRowid), paramString2.field_fileFullPath });
      continue;
      label431:
      localObject1 = ao.ctZ().bpR(localb.fvr);
      if (localObject1 != null)
      {
        paramString2 = (String)localObject1;
        if (((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_mediaSvrId.equals(localb.fvr)) {}
      }
      else
      {
        paramString2 = null;
      }
      if (paramString2 == null) {
        Log.i("MicroMsg.SendMsgMgr", "appAttachInfo3  %s", new Object[] { localb.fvr });
      } else {
        Log.i("MicroMsg.SendMsgMgr", "appAttachInfo4  %s : %s : %s", new Object[] { localb.fvr, Long.valueOf(paramString2.systemRowid), paramString2.field_fileFullPath });
      }
    }
  }
  
  public final void ai(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(39447);
    if ((paramString1 == null) || (paramString2 == null))
    {
      Log.w("MicroMsg.SendMsgMgr", "send msg args error, toUser[%s] content[%s]", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(39447);
      return;
    }
    o.e locale = o.WI(paramString1);
    locale.toUser = paramString1;
    locale.content = paramString2;
    paramString1 = locale.wD(paramInt);
    paramString1.cUP = 0;
    paramString1.lUq = 4;
    paramString1.bnl().aEv();
    AppMethodBeat.o(39447);
  }
  
  public final void f(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(281009);
    Object localObject;
    if (paramBoolean)
    {
      paramString2 = Util.nullAs(paramString2, "");
      localObject = o.WI(paramString2);
      ((o.e)localObject).toUser = paramString2;
      ((o.e)localObject).content = paramString3;
      if (as.bvK(paramString1)) {}
      for (i = 66;; i = 42)
      {
        paramString1 = ((o.e)localObject).wD(i);
        paramString1.cUP = 0;
        paramString1.lUq = 4;
        paramString1.bnl().aEv();
        AppMethodBeat.o(281009);
        return;
      }
    }
    paramString2 = Util.stringsToList(Util.nullAs(paramString2, "").split(","));
    int i = 0;
    if (i < paramString2.size())
    {
      localObject = (String)paramString2.get(i);
      o.e locale = o.WI((String)localObject);
      locale.toUser = ((String)localObject);
      locale.content = paramString3;
      if (as.bvK(paramString1)) {}
      for (int j = 66;; j = 42)
      {
        localObject = locale.wD(j);
        ((o.e)localObject).cUP = 0;
        ((o.e)localObject).lUq = 4;
        ((o.e)localObject).bnl().aEv();
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(281009);
  }
  
  public final void iQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(39453);
    paramString2 = Util.stringsToList(Util.nullAs(paramString2, "").split(","));
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        String str = (String)paramString2.next();
        uz localuz = new uz();
        localuz.fUn.fcD = str;
        localuz.fUn.content = paramString1;
        localuz.fUn.type = ab.QZ(str);
        localuz.fUn.flags = 0;
        EventCenter.instance.publish(localuz);
      }
    }
    AppMethodBeat.o(39453);
  }
  
  public final void u(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(39452);
    Object localObject;
    if (paramBoolean)
    {
      paramString2 = Util.nullAs(paramString2, "");
      str = af.bAj(paramString1);
      localObject = o.WI(paramString2);
      ((o.e)localObject).toUser = paramString2;
      ((o.e)localObject).content = str;
      if (as.bvK(paramString1)) {}
      for (i = 66;; i = 42)
      {
        paramString1 = ((o.e)localObject).wD(i);
        paramString1.cUP = 0;
        paramString1.lUq = 4;
        paramString1.bnl().aEv();
        AppMethodBeat.o(39452);
        return;
      }
    }
    paramString2 = Util.stringsToList(Util.nullAs(paramString2, "").split(","));
    String str = af.bAj(paramString1);
    int i = 0;
    if (i < paramString2.size())
    {
      localObject = (String)paramString2.get(i);
      o.e locale = o.WI((String)localObject);
      locale.toUser = ((String)localObject);
      locale.content = str;
      if (as.bvK(paramString1)) {}
      for (int j = 66;; j = 42)
      {
        localObject = locale.wD(j);
        ((o.e)localObject).cUP = 0;
        ((o.e)localObject).lUq = 4;
        ((o.e)localObject).bnl().aEv();
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(39452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.f
 * JD-Core Version:    0.7.0.1
 */