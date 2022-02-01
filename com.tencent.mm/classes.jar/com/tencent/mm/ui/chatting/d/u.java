package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.MenuItem;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.api.ad;
import com.tencent.mm.bd.f;
import com.tencent.mm.emoji.e.c.a;
import com.tencent.mm.f.a.v;
import com.tencent.mm.f.a.v.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.protocal.protobuf.dig;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.q;
import com.tencent.mm.ui.chatting.viewitems.m.b;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(hRc=q.class)
public class u
  extends a
  implements q
{
  private com.tencent.mm.search.d.b UXl;
  private IListener WJs;
  
  public u()
  {
    AppMethodBeat.i(35286);
    this.WJs = new IListener() {};
    AppMethodBeat.o(35286);
  }
  
  private void a(ca paramca, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(35294);
    if ((!paramca.hzB()) && (!paramca.hzC()))
    {
      AppMethodBeat.o(35294);
      return;
    }
    Object localObject2 = cw(paramca);
    if (localObject2 == null)
    {
      AppMethodBeat.o(35294);
      return;
    }
    paramca = com.tencent.mm.search.c.b.UWY;
    com.tencent.mm.search.c.b.F((EmojiInfo)localObject2);
    paramca = ((com.tencent.mm.ui.chatting.d.b.u)parama.bC(com.tencent.mm.ui.chatting.d.b.u.class)).hPj();
    int j = paramca.getCurrentScrollHeight();
    paramca.aqC(ad.bC(parama.WQv.getContext()));
    Object localObject3 = (k)parama.bC(k.class);
    int i = ((k)localObject3).getCount() - 1;
    Object localObject1 = new dih();
    Object localObject4;
    Object localObject5;
    while ((i >= 0) && (((dih)localObject1).TPC.size() <= 20))
    {
      localObject4 = new dig();
      localObject5 = ((k)localObject3).avt(i);
      ((dig)localObject4).TPw = ((ca)localObject5).getType();
      ((dig)localObject4).TPx = com.tencent.mm.aj.l.v((ca)localObject5);
      ((dig)localObject4).TPy = com.tencent.mm.aj.l.w((ca)localObject5);
      ((dig)localObject4).TPz = ((et)localObject5).field_createTime;
      ((dig)localObject4).TPA = ((et)localObject5).field_isSend;
      if (((ca)localObject5).hzB())
      {
        localObject5 = cw((ca)localObject5);
        if (localObject5 != null)
        {
          ((dig)localObject4).CSe = ((EmojiInfo)localObject5).field_md5;
          if (((EmojiInfo)localObject5).field_md5.equals(((EmojiInfo)localObject2).field_md5))
          {
            ((dig)localObject4).TPB = 1;
            ((dig)localObject4).LensId = ((EmojiInfo)localObject5).field_lensId;
          }
        }
      }
      i -= 1;
      ((dih)localObject1).TPC.add(localObject4);
    }
    Log.i("MicroMsg.ChattingUI.EmojiComponent", " add ctxs size:%d", new Object[] { Integer.valueOf(((dih)localObject1).TPC.size()) });
    localObject3 = new com.tencent.mm.ui.chatting.w(parama, parama.NKq, parama.getTalkerUserName());
    for (boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDV, true);; bool = false) {
      try
      {
        localObject2 = ((EmojiInfo)localObject2).field_md5;
        localObject4 = parama.getTalkerUserName();
        localObject5 = com.tencent.mm.search.c.b.UWY;
        localObject1 = new SimilarEmojiQueryModel("", (String)localObject2, (String)localObject4, com.tencent.mm.search.c.b.getTimestamp(), 3, parama.getTalkerUserName(), com.tencent.mm.cd.b.cU(((dih)localObject1).toByteArray()), bool, (com.tencent.mm.pluginsdk.ui.chat.j)localObject3);
        if (paramca.jJL == 1)
        {
          bool = true;
          if (bool)
          {
            paramca.setIgnoreScroll(Boolean.TRUE);
            paramca.hideVKB();
          }
          this.UXl = null;
          this.UXl = new com.tencent.mm.search.d.b(parama.WQv.getContext(), (SimilarEmojiQueryModel)localObject1, new u.3(this, bool, paramca, j));
          paramca = this.UXl.getWindow();
          if (paramca != null)
          {
            paramca.setDimAmount(0.0F);
            paramca.setFlags(131072, 131072);
            paramca.setSoftInputMode(48);
          }
          this.UXl.show();
          AppMethodBeat.o(35294);
          return;
        }
      }
      catch (IOException paramca)
      {
        Log.i("MicroMsg.ChattingUI.EmojiComponent", "SimilarEmojiQueryModel make error");
        AppMethodBeat.o(35294);
        return;
      }
    }
  }
  
  private void cd(ca paramca)
  {
    AppMethodBeat.i(35293);
    Log.d("MicroMsg.ChattingUI.EmojiComponent", "resendAppMsgEmoji");
    if (!this.fgR.getTalkerUserName().equals("medianote"))
    {
      bh.beI();
      com.tencent.mm.model.c.bbK().d(new f(paramca.field_talker, paramca.field_msgSvrId));
    }
    ak.cd(paramca);
    this.fgR.Gi(true);
    AppMethodBeat.o(35293);
  }
  
  private void cv(ca paramca)
  {
    AppMethodBeat.i(35292);
    bh.beI();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.w.g(this.fgR.WQv.getContext(), this.fgR.WQv.getContentView());
      AppMethodBeat.o(35292);
      return;
    }
    Log.d("MicroMsg.ChattingUI.EmojiComponent", "resendEmoji");
    if (!this.fgR.getTalkerUserName().equals("medianote"))
    {
      bh.beI();
      com.tencent.mm.model.c.bbK().d(new f(paramca.field_talker, paramca.field_msgSvrId));
    }
    ak.cc(paramca);
    AppMethodBeat.o(35292);
  }
  
  private static EmojiInfo cw(ca paramca)
  {
    AppMethodBeat.i(35295);
    if (paramca.hzB())
    {
      paramca = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(paramca.field_imgPath);
      AppMethodBeat.o(35295);
      return paramca;
    }
    be localbe = be.bwQ(paramca.field_content);
    paramca = k.b.aG(paramca.field_content, paramca.field_reserved);
    if (paramca == null)
    {
      paramca = new k.b();
      paramca.llZ = localbe.md5;
    }
    for (;;)
    {
      if ((Util.isNullOrNil(paramca.llZ)) || (paramca.llZ.equals("-1")))
      {
        AppMethodBeat.o(35295);
        return null;
      }
      paramca = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(paramca.llZ);
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(35287);
    Object localObject1;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(35287);
      return false;
    case 104: 
      if ((paramca.hzB()) || (paramca.hzC()))
      {
        localObject1 = cw(paramca);
        if (localObject1 != null)
        {
          paramMenuItem = paramca.field_talker;
          if (!ab.Lj(paramMenuItem)) {
            break label1130;
          }
          paramMenuItem = bq.RL(paramca.field_content);
        }
      }
      break;
    }
    label515:
    label580:
    label710:
    label716:
    label987:
    label1130:
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(12789, new Object[] { Integer.valueOf(3), ((EmojiInfo)localObject1).getMd5(), Integer.valueOf(0), ((EmojiInfo)localObject1).field_designerID, ((EmojiInfo)localObject1).field_groupId, "", "", "", "", "", ((EmojiInfo)localObject1).field_activityid });
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(parama.WQv.getContext(), (EmojiInfo)localObject1, 0, paramMenuItem);
      AppMethodBeat.o(35287);
      return true;
      boolean bool = cu(paramca);
      AppMethodBeat.o(35287);
      return bool;
      if ((paramca.hzB()) || (paramca.hzC()))
      {
        an.d(paramca, parama.WQv.getContext());
        AppMethodBeat.o(35287);
        return true;
      }
      AppMethodBeat.o(35287);
      return false;
      if ((paramca.hzB()) || (paramca.hzC()))
      {
        localObject1 = null;
        if (!paramca.hzB()) {
          break label515;
        }
        localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(paramca.field_imgPath);
        paramMenuItem = new c.a()
        {
          public final void ep(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(269335);
            LinkedList localLinkedList;
            if (paramAnonymousBoolean)
            {
              localLinkedList = new LinkedList();
              localLinkedList.add(this.lrk);
              if ((!((com.tencent.mm.ui.chatting.d.b.d)parama.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOf()) && (!parama.hRh())) {
                break label90;
              }
            }
            label90:
            for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
            {
              com.tencent.mm.ui.chatting.l.a(parama.WQv.getContext(), localLinkedList, paramAnonymousBoolean, parama.getTalkerUserName(), null);
              AppMethodBeat.o(269335);
              return;
            }
          }
        };
        if (localObject1 == null) {
          break label716;
        }
        new com.tencent.mm.emoji.e.c(parama.WQv.getContext(), (EmojiInfo)localObject1, true, paramMenuItem);
        parama = parama.getTalkerUserName();
        paramMenuItem = parama;
        if (ab.Lj(parama)) {
          paramMenuItem = bq.RL(paramca.field_content);
        }
        com.tencent.mm.plugin.report.service.h.IzE.a(12789, new Object[] { Integer.valueOf(1), ((EmojiInfo)localObject1).getMd5(), Integer.valueOf(0), ((EmojiInfo)localObject1).field_designerID, ((EmojiInfo)localObject1).field_groupId, paramMenuItem, "", "", "", ((EmojiInfo)localObject1).field_activityid });
      }
      for (;;)
      {
        AppMethodBeat.o(35287);
        return true;
        Object localObject2 = paramca.field_content;
        paramMenuItem = (MenuItem)localObject1;
        if (localObject2 != null)
        {
          localObject2 = k.b.aG((String)localObject2, paramca.field_reserved);
          paramMenuItem = (MenuItem)localObject1;
          if (localObject2 != null) {
            paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(((k.b)localObject2).llZ);
          }
        }
        if (paramMenuItem != null)
        {
          bool = true;
          Log.i("MicroMsg.ChattingUI.EmojiComponent", "longCLickRetransmitEmoji: emoji from xml %s", new Object[] { Boolean.valueOf(bool) });
          localObject1 = paramMenuItem;
          if (paramMenuItem != null) {
            break;
          }
          localObject2 = be.bwQ(paramca.field_content);
          localObject1 = paramMenuItem;
          if (!Util.isNullOrNil(((be)localObject2).md5))
          {
            localObject1 = paramMenuItem;
            if (!((be)localObject2).md5.equals("-1")) {
              localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(((be)localObject2).md5);
            }
          }
          if (localObject1 == null) {
            break label710;
          }
        }
        for (bool = true;; bool = false)
        {
          Log.i("MicroMsg.ChattingUI.EmojiComponent", "longCLickRetransmitEmoji: emoji from content %s", new Object[] { Boolean.valueOf(bool) });
          break;
          bool = false;
          break label580;
        }
        if (paramca.hzC()) {
          paramMenuItem.ep(true);
        }
      }
      if (paramca.hzB())
      {
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(paramca.field_imgPath);
        if (paramMenuItem != null) {
          com.tencent.mm.plugin.report.service.h.IzE.a(12789, new Object[] { Integer.valueOf(2), paramMenuItem.getMd5(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, "", "", "", "", "", paramMenuItem.field_activityid });
        }
        if (paramMenuItem != null) {
          break label987;
        }
      }
      for (paramMenuItem = "";; paramMenuItem = paramMenuItem.field_groupId)
      {
        if (!Util.isNullOrNil(paramMenuItem))
        {
          paramca = new Intent();
          paramca.putExtra("preceding_scence", 3);
          paramca.putExtra("download_entrance_scene", 16);
          paramca.putExtra("extra_id", paramMenuItem);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "emoji", ".ui.EmojiStoreDetailUI", paramca);
        }
        do
        {
          AppMethodBeat.o(35287);
          return true;
          paramMenuItem = be.bwQ(paramca.field_content);
        } while ((Util.isNullOrNil(paramMenuItem.md5)) || (paramMenuItem.md5.equals("-1")));
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(paramMenuItem.md5);
        break;
      }
      paramMenuItem = cw(paramca);
      if (paramMenuItem != null)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(12789, new Object[] { Integer.valueOf(5), paramMenuItem.getMd5(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, "", "", "", "", "", paramMenuItem.field_activityid });
        com.tencent.mm.plugin.emojicapture.api.b.z(parama.WQv.getContext(), paramMenuItem.getMd5(), parama.getTalkerUserName());
      }
      AppMethodBeat.o(35287);
      return true;
      a(paramca, parama);
      AppMethodBeat.o(35287);
      return true;
    }
  }
  
  public final boolean cu(ca paramca)
  {
    AppMethodBeat.i(35291);
    Log.i("MicroMsg.ChattingUI.EmojiComponent", "[resendEmoji] %d", new Object[] { Long.valueOf(paramca.field_msgId) });
    if (paramca.hzB())
    {
      cv(paramca);
      AppMethodBeat.o(35291);
      return true;
    }
    if (paramca.hzC())
    {
      cd(paramca);
      AppMethodBeat.o(35291);
      return true;
    }
    AppMethodBeat.o(35291);
    return false;
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35288);
    Log.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingEnterAnimEnd]");
    EventCenter.instance.addListener(this.WJs);
    AppMethodBeat.o(35288);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35289);
    Log.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingExitAnimStart]");
    EventCenter.instance.removeListener(this.WJs);
    AppMethodBeat.o(35289);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35290);
    super.hNZ();
    Log.i("MicroMsg.ChattingUI.EmojiComponent", "[onComponentUnInstall]");
    EventCenter.instance.removeListener(this.WJs);
    AppMethodBeat.o(35290);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(35296);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.UXl != null) && (this.UXl.isShowing()))
    {
      this.UXl.dismiss();
      this.UXl = null;
    }
    AppMethodBeat.o(35296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.u
 * JD-Core Version:    0.7.0.1
 */