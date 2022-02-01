package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.g;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.am.g.c;
import com.tencent.mm.autogen.a.np;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.b;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cc;

public final class i
  implements g
{
  public final g.b b(g.a parama)
  {
    AppMethodBeat.i(30937);
    dl localdl = parama.mpN;
    if ((localdl == null) || (localdl.IIs != 47))
    {
      Log.f("MicroMsg.EmojiExtension", "parseEmojiMsg failed, invalid cmdAM");
      AppMethodBeat.o(30937);
      return null;
    }
    Object localObject2 = w.a(localdl.YFE);
    Object localObject1 = w.a(localdl.YFF);
    bh.bCz();
    cc localcc;
    label171:
    long l;
    if (((String)c.ban().d(2, null)).equals(localObject2))
    {
      String str = w.a(localdl.YFG);
      if (!((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().a((String)localObject1, str, localdl.Njv, localdl.YFJ, parama))
      {
        Log.w("MicroMsg.EmojiExtension", "emoji plugin not found");
        localcc = new cc();
        localcc.setType(47);
        localcc.BS((String)localObject1);
        if (!z.Iy((String)localObject2)) {
          break label516;
        }
        i = 1;
        localcc.pI(i);
        localcc.BT("no_plugin_md5");
        localcc.gX(localdl.Njv);
        localcc.setContent(str);
        if (localcc.field_isSend != 1) {
          break label521;
        }
        l = br.JN(localcc.field_talker);
        label219:
        localcc.setCreateTime(l);
        localcc.setStatus(3);
        localcc.AU(localdl.YFJ);
        br.a(localcc, parama);
        bh.bCz();
        c.bzD().ba(localcc);
      }
      localObject1 = br.JP(localdl.YFJ);
      if (localObject1 != null)
      {
        Log.i("MicroMsg.EmojiExtension", "bizClientMsgId = %s", new Object[] { ((br.b)localObject1).olR });
        if ((((br.b)localObject1).olW != null) && (((br.b)localObject1).scene == 1))
        {
          parama = w.a(localdl.YFE);
          bh.bCz();
          c.ban().B(73729, Integer.valueOf(1));
          localObject2 = new bz();
          ((bz)localObject2).field_content = MMApplicationContext.getContext().getString(R.l.gOu);
          ((bz)localObject2).field_createtime = Util.nowSecond();
          ((bz)localObject2).field_imgpath = "";
          ((bz)localObject2).field_sayhicontent = ((bz)localObject2).field_content;
          ((bz)localObject2).field_sayhiuser = parama;
          ((bz)localObject2).field_scene = 18;
          if (localdl.vhk <= 3) {
            break label539;
          }
        }
      }
    }
    label516:
    label521:
    label539:
    for (int i = localdl.vhk;; i = 3)
    {
      ((bz)localObject2).field_status = i;
      ((bz)localObject2).field_svrid = localdl.Njv;
      ((bz)localObject2).field_talker = parama;
      ((bz)localObject2).field_type = localdl.IIs;
      ((bz)localObject2).field_isSend = 0;
      ((bz)localObject2).field_sayhiencryptuser = parama;
      ((bz)localObject2).field_ticket = ((br.b)localObject1).olW;
      com.tencent.mm.modelverify.d.bNJ().a((bz)localObject2);
      localObject1 = new np();
      ((np)localObject1).hPZ.hQa = parama;
      ((np)localObject1).publish();
      AppMethodBeat.o(30937);
      return null;
      localObject1 = localObject2;
      break;
      i = 0;
      break label171;
      l = br.D(localcc.field_talker, localdl.CreateTime);
      break label219;
    }
  }
  
  public final void b(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.i
 * JD-Core Version:    0.7.0.1
 */