package com.tencent.mm.ui.transmit;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.f.e.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.messenger.a.d.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.ad;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.List;

public final class f
  implements com.tencent.mm.plugin.messenger.a.d
{
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, eeq parameeq, String paramString4, String paramString5, d.a parama)
  {
    AppMethodBeat.i(234535);
    if (paramContext == null)
    {
      Log.w("MicroMsg.SendMsgMgr", "send vedio context is null");
      AppMethodBeat.o(234535);
      return;
    }
    if ((paramString1 == null) || (paramString2 == null))
    {
      Log.w("MicroMsg.SendMsgMgr", "send vedio args error, toUser[%s] fileName[%s]", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(234535);
      return;
    }
    bg.aVF();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      Log.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
      e.eD(paramContext).hmq().a(new com.tencent.f.e.a() {});
      AppMethodBeat.o(234535);
      return;
    }
    final MsgRetransmitUI.a locala = new MsgRetransmitUI.a();
    Dialog localDialog = (Dialog)e.eD(paramContext).hmq().a(new com.tencent.f.e.a() {}).take();
    locala.context = paramContext;
    locala.fileName = paramString2;
    locala.QyR = paramString3;
    locala.tipDialog = localDialog;
    locala.userName = paramString1;
    locala.ean = paramString4;
    locala.QyU = false;
    if (62 == paramInt1) {
      locala.jqs = 11;
    }
    if (paramInt1 > 0) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      locala.Qyk = paramInt1;
      locala.iFw = paramInt2;
      locala.QyS = false;
      locala.QyV = parameeq;
      locala.jsz = paramString5;
      locala.QyY = parama;
      locala.execute(new Object[0]);
      AppMethodBeat.o(234535);
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
    bg.aVF();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      Log.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(180114);
          Toast.makeText(paramContext, 2131763211, 1).show();
          AppMethodBeat.o(180114);
        }
      });
      AppMethodBeat.o(163393);
      return;
    }
    paramContext = z.aTY();
    o.e locale = o.a(o.d.jdL).tc(4);
    locale.dRL = paramContext;
    locale.toUser = paramString1;
    locale.iZt = paramString2;
    locale.iXp = paramInt;
    locale.jdS = null;
    locale.dQd = 0;
    locale.iXy = paramString3;
    locale.thumbPath = paramString4;
    locale.jdV = true;
    locale.jdU = 2131231628;
    locale.jdW = paramLong;
    locale.jdY = paramString5;
    locale.jdR = 13;
    locale.bdQ().execute();
    cf.aWl().f(cf.iFI, null);
    AppMethodBeat.o(163393);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, eeq parameeq, String paramString4, String paramString5)
  {
    AppMethodBeat.i(163392);
    a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, parameeq, paramString4, paramString5, null);
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
    AppMethodBeat.i(234534);
    a(paramContext, paramString1, paramString2, paramString3, 1, paramInt, null, paramString4, paramString5, parama);
    AppMethodBeat.o(234534);
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
    k.b localb = k.b.HD(Util.processXml(paramString2));
    if (localb == null)
    {
      Log.w("MicroMsg.SendMsgMgr", "send: parse app msg content return null");
      AppMethodBeat.o(39451);
      return;
    }
    Object localObject1 = new com.tencent.mm.pluginsdk.model.app.c();
    Log.i("MicroMsg.SendMsgMgr", "content.attachid %s", new Object[] { localb.dCK });
    paramString2 = (String)localObject1;
    if (!Util.isNullOrNil(localb.dCK))
    {
      long l = Util.getLong(localb.dCK, -1L);
      if (l == -1L) {
        break label429;
      }
      ao.cgO().get(l, (IAutoDBItem)localObject1);
      paramString2 = (String)localObject1;
      if (((com.tencent.mm.pluginsdk.model.app.c)localObject1).systemRowid != l)
      {
        localObject1 = ao.cgO().bdx(localb.dCK);
        if (localObject1 != null)
        {
          paramString2 = (String)localObject1;
          if (((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_mediaSvrId.equals(localb.dCK)) {}
        }
        else
        {
          paramString2 = null;
        }
        if (paramString2 != null) {
          break label389;
        }
        Log.i("MicroMsg.SendMsgMgr", "appAttachInfo1  %s", new Object[] { localb.dCK });
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
            bg.aVF();
            localObject1 = m.aB(com.tencent.mm.model.c.aTg(), localb.title, localb.iwJ);
            s.nw(paramString2.field_fileFullPath, (String)localObject1);
            Log.i("MicroMsg.SendMsgMgr", "copy from src %s to dest %s size: %s", new Object[] { paramString2.field_fileFullPath, localObject1, Long.valueOf(s.boW(paramString2.field_fileFullPath)) });
          }
        }
      }
      paramString2 = k.b.a(localb);
      paramString2.iwL = 3;
      localObject2 = (com.tencent.mm.ag.a)paramString2.as(com.tencent.mm.ag.a.class);
      if (localObject2 != null) {
        ((com.tencent.mm.ag.a)localObject2).ivq = false;
      }
      m.a(paramString2, localb.appId, localb.appName, paramString1, (String)localObject1, paramArrayOfByte, paramString3);
      AppMethodBeat.o(39451);
      return;
      label389:
      Log.i("MicroMsg.SendMsgMgr", "appAttachInfo2  %s : %s : %s", new Object[] { localb.dCK, Long.valueOf(paramString2.systemRowid), paramString2.field_fileFullPath });
      continue;
      label429:
      localObject1 = ao.cgO().bdx(localb.dCK);
      if (localObject1 != null)
      {
        paramString2 = (String)localObject1;
        if (((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_mediaSvrId.equals(localb.dCK)) {}
      }
      else
      {
        paramString2 = null;
      }
      if (paramString2 == null) {
        Log.i("MicroMsg.SendMsgMgr", "appAttachInfo3  %s", new Object[] { localb.dCK });
      } else {
        Log.i("MicroMsg.SendMsgMgr", "appAttachInfo4  %s : %s : %s", new Object[] { localb.dCK, Long.valueOf(paramString2.systemRowid), paramString2.field_fileFullPath });
      }
    }
  }
  
  public final void ad(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(39447);
    if ((paramString1 == null) || (paramString2 == null))
    {
      Log.w("MicroMsg.SendMsgMgr", "send msg args error, toUser[%s] content[%s]", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(39447);
      return;
    }
    o.e locale = o.Pl(paramString1);
    locale.toUser = paramString1;
    locale.content = paramString2;
    paramString1 = locale.tD(paramInt);
    paramString1.cSx = 0;
    paramString1.jdR = 4;
    paramString1.bdQ().execute();
    AppMethodBeat.o(39447);
  }
  
  public final void e(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(234536);
    Object localObject;
    if (paramBoolean)
    {
      paramString2 = Util.nullAs(paramString2, "");
      localObject = o.Pl(paramString2);
      ((o.e)localObject).toUser = paramString2;
      ((o.e)localObject).content = paramString3;
      if (as.bjp(paramString1)) {}
      for (i = 66;; i = 42)
      {
        paramString1 = ((o.e)localObject).tD(i);
        paramString1.cSx = 0;
        paramString1.jdR = 4;
        paramString1.bdQ().execute();
        AppMethodBeat.o(234536);
        return;
      }
    }
    paramString2 = Util.stringsToList(Util.nullAs(paramString2, "").split(","));
    int i = 0;
    if (i < paramString2.size())
    {
      localObject = (String)paramString2.get(i);
      o.e locale = o.Pl((String)localObject);
      locale.toUser = ((String)localObject);
      locale.content = paramString3;
      if (as.bjp(paramString1)) {}
      for (int j = 66;; j = 42)
      {
        localObject = locale.tD(j);
        ((o.e)localObject).cSx = 0;
        ((o.e)localObject).jdR = 4;
        ((o.e)localObject).bdQ().execute();
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(234536);
  }
  
  public final void iF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(39453);
    paramString2 = Util.stringsToList(Util.nullAs(paramString2, "").split(","));
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        String str = (String)paramString2.next();
        tw localtw = new tw();
        localtw.eaq.dkV = str;
        localtw.eaq.content = paramString1;
        localtw.eaq.type = ab.JG(str);
        localtw.eaq.flags = 0;
        EventCenter.instance.publish(localtw);
      }
    }
    AppMethodBeat.o(39453);
  }
  
  public final void s(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(39452);
    Object localObject;
    if (paramBoolean)
    {
      paramString2 = Util.nullAs(paramString2, "");
      str = ad.bnD(paramString1);
      localObject = o.Pl(paramString2);
      ((o.e)localObject).toUser = paramString2;
      ((o.e)localObject).content = str;
      if (as.bjp(paramString1)) {}
      for (i = 66;; i = 42)
      {
        paramString1 = ((o.e)localObject).tD(i);
        paramString1.cSx = 0;
        paramString1.jdR = 4;
        paramString1.bdQ().execute();
        AppMethodBeat.o(39452);
        return;
      }
    }
    paramString2 = Util.stringsToList(Util.nullAs(paramString2, "").split(","));
    String str = ad.bnD(paramString1);
    int i = 0;
    if (i < paramString2.size())
    {
      localObject = (String)paramString2.get(i);
      o.e locale = o.Pl((String)localObject);
      locale.toUser = ((String)localObject);
      locale.content = str;
      if (as.bjp(paramString1)) {}
      for (int j = 66;; j = 42)
      {
        localObject = locale.tD(j);
        ((o.e)localObject).cSx = 0;
        ((o.e)localObject).jdR = 4;
        ((o.e)localObject).bdQ().execute();
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(39452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.f
 * JD-Core Version:    0.7.0.1
 */