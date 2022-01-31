package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.al.c;
import com.tencent.mm.al.f;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.e;
import java.io.File;

final class d$b
{
  static void a(com.tencent.mm.ui.chatting.d.a parama, bi parambi, String paramString)
  {
    AppMethodBeat.i(32806);
    Object localObject1 = bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend);
    Intent localIntent = new Intent(parama.zJz.getContext(), MsgRetransmitUI.class);
    localIntent.putExtra("Retr_Msg_content", (String)localObject1);
    localIntent.putExtra("Retr_MsgFromScene", 2);
    localObject1 = j.b.mY((String)localObject1);
    if ((localObject1 != null) && (19 == ((j.b)localObject1).type)) {
      localIntent.putExtra("Retr_Msg_Type", 10);
    }
    for (;;)
    {
      localIntent.putExtra("Retr_Msg_Id", parambi.field_msgId);
      if ((localObject1 != null) && (((j.b)localObject1).type == 6)) {
        break label471;
      }
      parama.startActivity(localIntent);
      AppMethodBeat.o(32806);
      return;
      if ((localObject1 != null) && (24 == ((j.b)localObject1).type))
      {
        localIntent.putExtra("Retr_Msg_Type", 10);
      }
      else
      {
        if ((localObject1 == null) || (16 != ((j.b)localObject1).type)) {
          break;
        }
        localIntent.putExtra("Retr_Msg_Type", 14);
      }
    }
    localIntent.putExtra("Retr_Msg_Type", 2);
    Object localObject2 = parambi.field_talker;
    Object localObject3 = v.oQ(parambi.field_msgSvrId);
    localIntent.putExtra("reportSessionId", (String)localObject3);
    localObject3 = v.aae().z((String)localObject3, true);
    ((v.b)localObject3).i("prePublishId", "msg_" + parambi.field_msgSvrId);
    ((v.b)localObject3).i("preUsername", paramString);
    ((v.b)localObject3).i("preChatName", localObject2);
    if ((localObject1 != null) && (((j.b)localObject1).R(com.tencent.mm.af.a.class) != null))
    {
      ((v.b)localObject3).i("appservicetype", Integer.valueOf(((com.tencent.mm.af.a)((j.b)localObject1).R(com.tencent.mm.af.a.class)).ffe));
      localIntent.putExtra("Retr_MsgAppBrandServiceType", ((com.tencent.mm.af.a)((j.b)localObject1).R(com.tencent.mm.af.a.class)).ffe);
    }
    if ((localObject1 != null) && (33 == ((j.b)localObject1).type))
    {
      if (!parama.dJG()) {
        break label447;
      }
      ((v.b)localObject3).i("fromScene", Integer.valueOf(2));
      localIntent.putExtra("Retr_MsgAppBrandFromScene", 2);
    }
    for (;;)
    {
      localIntent.putExtra("Retr_MsgFromUserName", paramString);
      localIntent.putExtra("Retr_MsgTalker", parambi.field_talker);
      ((v.b)localObject3).i("sendAppMsgScene", Integer.valueOf(1));
      ((i)com.tencent.mm.kernel.g.E(i.class)).a("adExtStr", (v.b)localObject3, parambi);
      break;
      label447:
      ((v.b)localObject3).i("fromScene", Integer.valueOf(1));
      localIntent.putExtra("Retr_MsgAppBrandFromScene", 1);
    }
    label471:
    localObject2 = com.tencent.mm.plugin.report.service.h.qsU;
    localObject3 = ((j.b)localObject1).fgL;
    int i;
    if (((j.b)localObject1).fgA == 1)
    {
      i = 7;
      ((com.tencent.mm.plugin.report.service.h)localObject2).e(14665, new Object[] { localObject3, Integer.valueOf(i), Integer.valueOf(((j.b)localObject1).fgw), Integer.valueOf(2), Long.valueOf((System.currentTimeMillis() - parambi.field_createTime) / 1000L), ((j.b)localObject1).fgx });
      if ((((j.b)localObject1).fgA == 0) && (((j.b)localObject1).fgw <= 26214400)) {
        break label663;
      }
    }
    label663:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("Retr_Big_File", bool);
      localObject2 = l.alv(((j.b)localObject1).cmN);
      if (localObject2 == null) {
        break label812;
      }
      localObject3 = new File(((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath);
      if ((!((File)localObject3).exists()) || (((File)localObject3).length() != ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_totalLen)) {
        break label669;
      }
      parama.startActivity(localIntent);
      AppMethodBeat.o(32806);
      return;
      i = 5;
      break;
    }
    label669:
    if ((((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_offset > 0L) && (((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_totalLen > ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_offset))
    {
      paramString = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath;
      if ((parambi.dyc()) || (e(parambi, paramString)))
      {
        ab.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
        com.tencent.mm.ui.base.h.a(parama.zJz.getContext(), parama.zJz.getContext().getString(2131299882), parama.zJz.getContext().getString(2131297087), new d.b.3());
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          com.tencent.mm.ui.base.h.b(parama.zJz.getContext(), parama.zJz.getMMResources().getString(2131298861), "", true);
        }
        AppMethodBeat.o(32806);
        return;
      }
    }
    label812:
    ab.i("MicroMsg.AppMessageUtil", "summerbig retrans content.attachlen[%d], cdnAttachUrl[%s], aesKey[%s]", new Object[] { Integer.valueOf(((j.b)localObject1).fgw), ((j.b)localObject1).fgL, bo.aqg(((j.b)localObject1).ewj) });
    if (!bool)
    {
      a(parama, localIntent, parambi);
      AppMethodBeat.o(32806);
      return;
    }
    localIntent.putExtra("Retr_Big_File", bool);
    localObject3 = new com.tencent.mm.i.g();
    ((com.tencent.mm.i.g)localObject3).edp = new d.b.1(parama, localIntent, parambi, (com.tencent.mm.pluginsdk.model.app.b)localObject2);
    ((com.tencent.mm.i.g)localObject3).field_mediaId = c.a("checkExist", bo.aoy(), paramString, parambi.field_msgId);
    ((com.tencent.mm.i.g)localObject3).field_fileId = ((j.b)localObject1).fgL;
    ((com.tencent.mm.i.g)localObject3).field_aesKey = ((j.b)localObject1).ewj;
    ((com.tencent.mm.i.g)localObject3).field_filemd5 = ((j.b)localObject1).filemd5;
    ((com.tencent.mm.i.g)localObject3).field_fileType = com.tencent.mm.i.a.ecH;
    ((com.tencent.mm.i.g)localObject3).field_talker = paramString;
    ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.ecF;
    ((com.tencent.mm.i.g)localObject3).field_svr_signature = "";
    ((com.tencent.mm.i.g)localObject3).field_onlycheckexist = true;
    bool = f.afO().e((com.tencent.mm.i.g)localObject3);
    ab.i("MicroMsg.AppMessageUtil", "summerbig retrans to startupDownloadMedia ret[%b], field_fileId[%s], field_mediaId[%s], field_aesKey[%s]", new Object[] { Boolean.valueOf(bool), ((com.tencent.mm.i.g)localObject3).field_fileId, ((com.tencent.mm.i.g)localObject3).field_mediaId, bo.aqg(((com.tencent.mm.i.g)localObject3).field_aesKey) });
    if (!bool) {
      a(parama, localIntent, parambi);
    }
    AppMethodBeat.o(32806);
  }
  
  static boolean a(Context paramContext, j.b paramb)
  {
    AppMethodBeat.i(32805);
    if ((paramb == null) || (paramContext == null))
    {
      AppMethodBeat.o(32805);
      return false;
    }
    boolean bool;
    if (paramb.type == 3)
    {
      bool = com.tencent.mm.pluginsdk.model.app.g.o(paramContext, 16L);
      AppMethodBeat.o(32805);
      return bool;
    }
    if (paramb.type == 4)
    {
      bool = com.tencent.mm.pluginsdk.model.app.g.o(paramContext, 8L);
      AppMethodBeat.o(32805);
      return bool;
    }
    if (paramb.type == 5)
    {
      bool = com.tencent.mm.pluginsdk.model.app.g.o(paramContext, 32L);
      AppMethodBeat.o(32805);
      return bool;
    }
    if (paramb.type == 6)
    {
      paramb = c.a.akT(paramb.fgx);
      if (paramb == null)
      {
        AppMethodBeat.o(32805);
        return false;
      }
      bool = com.tencent.mm.pluginsdk.model.app.g.o(paramContext, paramb.longValue());
      AppMethodBeat.o(32805);
      return bool;
    }
    AppMethodBeat.o(32805);
    return false;
  }
  
  private static boolean a(com.tencent.mm.ui.chatting.d.a parama, Intent paramIntent, bi parambi)
  {
    AppMethodBeat.i(155501);
    if ((parambi.dyc()) || (e(parambi, null)))
    {
      ab.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
      com.tencent.mm.ui.base.h.a(parama.zJz.getContext(), parama.zJz.getContext().getString(2131299882), parama.zJz.getContext().getString(2131297087), new d.b.2());
      AppMethodBeat.o(155501);
      return true;
    }
    parama.startActivity(paramIntent);
    AppMethodBeat.o(155501);
    return false;
  }
  
  static boolean aul(String paramString)
  {
    AppMethodBeat.i(153914);
    boolean bool = bo.aqj(paramString);
    AppMethodBeat.o(153914);
    return bool;
  }
  
  public static boolean aum(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(32809);
    Object localObject = o.ahC().c(paramString, false, true);
    if (!e.cN((String)localObject))
    {
      AppMethodBeat.o(32809);
      return false;
    }
    paramString = new BitmapFactory.Options();
    paramString.inJustDecodeBounds = true;
    localObject = d.decodeFile((String)localObject, paramString);
    if (paramString.outWidth * paramString.outHeight > 1048576)
    {
      ab.i("MicroMsg.AppMessageUtil", "Bitmap to big:%d/%d", new Object[] { Integer.valueOf(paramString.outWidth), Integer.valueOf(paramString.outHeight) });
      bool = true;
    }
    if (localObject != null) {
      ((Bitmap)localObject).recycle();
    }
    AppMethodBeat.o(32809);
    return bool;
  }
  
  public static boolean e(bi parambi, String paramString)
  {
    AppMethodBeat.i(32808);
    if ((System.currentTimeMillis() - parambi.field_createTime > 259200000L) && ((bo.isNullOrNil(paramString)) || (!e.cN(paramString))))
    {
      AppMethodBeat.o(32808);
      return true;
    }
    AppMethodBeat.o(32808);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.b
 * JD-Core Version:    0.7.0.1
 */