package com.tencent.mm.ui.transmit;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.wp;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.t;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.d;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.plugin.messenger.a.d.a;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.contact.ak;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.e.e;
import java.util.Iterator;
import java.util.List;

public final class f
  implements com.tencent.mm.plugin.messenger.a.d
{
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, fjp paramfjp, String paramString4, String paramString5, d.a parama)
  {
    AppMethodBeat.i(250929);
    if (paramContext == null)
    {
      Log.w("MicroMsg.SendMsgMgr", "send vedio context is null");
      AppMethodBeat.o(250929);
      return;
    }
    if ((paramString1 == null) || (paramString2 == null))
    {
      Log.w("MicroMsg.SendMsgMgr", "send vedio args error, toUser[%s] fileName[%s]", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(250929);
      return;
    }
    bh.bCz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      Log.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
      e.hh(paramContext).jZl().a(new com.tencent.threadpool.e.a() {});
      AppMethodBeat.o(250929);
      return;
    }
    final MsgRetransmitUI.a locala = new MsgRetransmitUI.a();
    Dialog localDialog = (Dialog)e.hh(paramContext).jZl().a(new com.tencent.threadpool.e.a() {}).jZk();
    locala.context = paramContext;
    locala.fileName = paramString2;
    locala.afNu = paramString3;
    locala.tipDialog = localDialog;
    locala.userName = paramString1;
    locala.iah = paramString4;
    locala.afNx = false;
    if (62 == paramInt1) {
      locala.oYP = 11;
    }
    if (paramInt1 > 0) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      locala.afMH = paramInt1;
      locala.omT = paramInt2;
      locala.afNv = false;
      locala.afNy = paramfjp;
      locala.pbn = paramString5;
      locala.afNB = parama;
      locala.execute(new Object[0]);
      AppMethodBeat.o(250929);
      return;
    }
  }
  
  public final void B(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(39452);
    Object localObject;
    if (paramBoolean)
    {
      paramString2 = Util.nullAs(paramString2, "");
      str = ak.bCc(paramString1);
      localObject = t.OH(paramString2);
      ((t.e)localObject).toUser = paramString2;
      ((t.e)localObject).content = str;
      if (au.bwO(paramString1)) {}
      for (i = 66;; i = 42)
      {
        paramString1 = ((t.e)localObject).wF(i);
        paramString1.eQp = 0;
        paramString1.oNj = 4;
        paramString1.bKW().aXz();
        AppMethodBeat.o(39452);
        return;
      }
    }
    paramString2 = Util.stringsToList(Util.nullAs(paramString2, "").split(","));
    String str = ak.bCc(paramString1);
    int i = 0;
    if (i < paramString2.size())
    {
      localObject = (String)paramString2.get(i);
      t.e locale = t.OH((String)localObject);
      locale.toUser = ((String)localObject);
      locale.content = str;
      if (au.bwO(paramString1)) {}
      for (int j = 66;; j = 42)
      {
        localObject = locale.wF(j);
        ((t.e)localObject).eQp = 0;
        ((t.e)localObject).oNj = 4;
        ((t.e)localObject).bKW().aXz();
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(39452);
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
    bh.bCz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      Log.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(180114);
          Toast.makeText(paramContext, R.l.gOd, 1).show();
          AppMethodBeat.o(180114);
        }
      });
      AppMethodBeat.o(163393);
      return;
    }
    paramContext = z.bAM();
    t.e locale = t.a(t.d.oNd).wg(4);
    locale.hQQ = paramContext;
    locale.toUser = paramString1;
    locale.oIx = paramString2;
    locale.oGu = paramInt;
    locale.oNk = null;
    locale.hOX = 0;
    locale.oGC = paramString3;
    locale.thumbPath = paramString4;
    locale.oNn = true;
    locale.oNm = R.g.chat_img_template;
    locale.oNo = paramLong;
    locale.oNq = paramString5;
    locale.oNj = 13;
    locale.bKW().aXz();
    ch.bDg().f(ch.oni, null);
    AppMethodBeat.o(163393);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, fjp paramfjp, String paramString4, String paramString5)
  {
    AppMethodBeat.i(163392);
    a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramfjp, paramString4, paramString5, null);
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
    AppMethodBeat.i(250936);
    a(paramContext, paramString1, paramString2, paramString3, 1, paramInt, null, paramString4, paramString5, parama);
    AppMethodBeat.o(250936);
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3)
  {
    AppMethodBeat.i(39451);
    a(paramString1, paramArrayOfByte, paramString2, paramString3, null);
    AppMethodBeat.o(39451);
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(250947);
    if (paramString1 == null)
    {
      Log.w("MicroMsg.SendMsgMgr", "sendAppMsg: args error, toUser is null");
      AppMethodBeat.o(250947);
      return;
    }
    Log.v("MicroMsg.SendMsgMgr", "for track bug sendAppMsg %s", new Object[] { paramString2 });
    k.b localb = k.b.Hf(Util.processXml(paramString2));
    if (localb == null)
    {
      Log.w("MicroMsg.SendMsgMgr", "send: parse app msg content return null");
      AppMethodBeat.o(250947);
      return;
    }
    Object localObject1 = new com.tencent.mm.pluginsdk.model.app.c();
    Log.i("MicroMsg.SendMsgMgr", "content.attachid %s", new Object[] { localb.hzM });
    paramString2 = (String)localObject1;
    if (!Util.isNullOrNil(localb.hzM))
    {
      long l = Util.getLong(localb.hzM, -1L);
      if (l == -1L) {
        break label438;
      }
      as.cWJ().get(l, (IAutoDBItem)localObject1);
      paramString2 = (String)localObject1;
      if (((com.tencent.mm.pluginsdk.model.app.c)localObject1).systemRowid != l)
      {
        localObject1 = as.cWJ().bpI(localb.hzM);
        if (localObject1 != null)
        {
          paramString2 = (String)localObject1;
          if (((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_mediaSvrId.equals(localb.hzM)) {}
        }
        else
        {
          paramString2 = null;
        }
        if (paramString2 != null) {
          break label398;
        }
        Log.i("MicroMsg.SendMsgMgr", "appAttachInfo1  %s", new Object[] { localb.hzM });
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
            bh.bCz();
            localObject1 = n.aK(com.tencent.mm.model.c.bzT(), localb.title, localb.nRe);
            y.O(paramString2.field_fileFullPath, (String)localObject1, false);
            Log.i("MicroMsg.SendMsgMgr", "copy from src %s to dest %s size: %s", new Object[] { paramString2.field_fileFullPath, localObject1, Long.valueOf(y.bEl(paramString2.field_fileFullPath)) });
          }
        }
      }
      paramString2 = k.b.a(localb);
      paramString2.nRg = 3;
      localObject2 = (com.tencent.mm.message.a)paramString2.aK(com.tencent.mm.message.a.class);
      if (localObject2 != null) {
        ((com.tencent.mm.message.a)localObject2).nPl = false;
      }
      n.a(paramString2, localb.appId, localb.appName, paramString1, (String)localObject1, paramArrayOfByte, paramString3, "", paramString4);
      AppMethodBeat.o(250947);
      return;
      label398:
      Log.i("MicroMsg.SendMsgMgr", "appAttachInfo2  %s : %s : %s", new Object[] { localb.hzM, Long.valueOf(paramString2.systemRowid), paramString2.field_fileFullPath });
      continue;
      label438:
      localObject1 = as.cWJ().bpI(localb.hzM);
      if (localObject1 != null)
      {
        paramString2 = (String)localObject1;
        if (((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_mediaSvrId.equals(localb.hzM)) {}
      }
      else
      {
        paramString2 = null;
      }
      if (paramString2 == null) {
        Log.i("MicroMsg.SendMsgMgr", "appAttachInfo3  %s", new Object[] { localb.hzM });
      } else {
        Log.i("MicroMsg.SendMsgMgr", "appAttachInfo4  %s : %s : %s", new Object[] { localb.hzM, Long.valueOf(paramString2.systemRowid), paramString2.field_fileFullPath });
      }
    }
  }
  
  public final void ap(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(39447);
    if ((paramString1 == null) || (paramString2 == null))
    {
      Log.w("MicroMsg.SendMsgMgr", "send msg args error, toUser[%s] content[%s]", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(39447);
      return;
    }
    t.e locale = t.OH(paramString1);
    locale.toUser = paramString1;
    locale.content = paramString2;
    paramString1 = locale.wF(paramInt);
    paramString1.eQp = 0;
    paramString1.oNj = 4;
    paramString1.bKW().aXz();
    AppMethodBeat.o(39447);
  }
  
  public final void g(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(250954);
    Object localObject;
    if (paramBoolean)
    {
      paramString2 = Util.nullAs(paramString2, "");
      localObject = t.OH(paramString2);
      ((t.e)localObject).toUser = paramString2;
      ((t.e)localObject).content = paramString3;
      if (au.bwO(paramString1)) {}
      for (i = 66;; i = 42)
      {
        paramString1 = ((t.e)localObject).wF(i);
        paramString1.eQp = 0;
        paramString1.oNj = 4;
        paramString1.bKW().aXz();
        AppMethodBeat.o(250954);
        return;
      }
    }
    paramString2 = Util.stringsToList(Util.nullAs(paramString2, "").split(","));
    int i = 0;
    if (i < paramString2.size())
    {
      localObject = (String)paramString2.get(i);
      t.e locale = t.OH((String)localObject);
      locale.toUser = ((String)localObject);
      locale.content = paramString3;
      if (au.bwO(paramString1)) {}
      for (int j = 66;; j = 42)
      {
        localObject = locale.wF(j);
        ((t.e)localObject).eQp = 0;
        ((t.e)localObject).oNj = 4;
        ((t.e)localObject).bKW().aXz();
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(250954);
  }
  
  public final void ke(String paramString1, String paramString2)
  {
    AppMethodBeat.i(39453);
    paramString2 = Util.stringsToList(Util.nullAs(paramString2, "").split(","));
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        String str = (String)paramString2.next();
        wp localwp = new wp();
        localwp.iak.hgl = str;
        localwp.iak.content = paramString1;
        localwp.iak.type = ab.IX(str);
        localwp.iak.flags = 0;
        localwp.publish();
      }
    }
    AppMethodBeat.o(39453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.f
 * JD-Core Version:    0.7.0.1
 */