package com.tencent.mm.ui.chatting.component;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MenuItem;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ae;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.emoji.f.b.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.l;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.protocal.protobuf.eaq;
import com.tencent.mm.protocal.protobuf.ear;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.ap;
import com.tencent.mm.ui.chatting.component.api.e;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.component.api.t;
import com.tencent.mm.ui.chatting.n;
import com.tencent.mm.ui.chatting.y;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import kotlin.ah;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=t.class)
public class x
  extends a
  implements t
{
  private com.tencent.mm.search.d.b acss;
  private IListener aerz;
  
  public x()
  {
    AppMethodBeat.i(35286);
    this.aerz = new EmojiComponent.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(35286);
  }
  
  private void b(final cc paramcc, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(256172);
    if ((!paramcc.jbG()) && (!paramcc.jbH()))
    {
      AppMethodBeat.o(256172);
      return;
    }
    Object localObject2 = cS(paramcc);
    if (localObject2 == null)
    {
      AppMethodBeat.o(256172);
      return;
    }
    paramcc = com.tencent.mm.search.c.b.acsj;
    com.tencent.mm.search.c.b.F((EmojiInfo)localObject2);
    paramcc = ((com.tencent.mm.ui.chatting.component.api.x)parama.cm(com.tencent.mm.ui.chatting.component.api.x.class)).jsd();
    final int j = paramcc.getCurrentScrollHeight();
    paramcc.awH(ae.cp(parama.aezO.getContext()));
    Object localObject3 = (m)parama.cm(m.class);
    int i = ((m)localObject3).getCount() - 1;
    Object localObject1 = new ear();
    Object localObject4;
    Object localObject5;
    while ((i >= 0) && (((ear)localObject1).abfY.size() <= 20))
    {
      localObject4 = new eaq();
      localObject5 = ((m)localObject3).aBV(i);
      ((eaq)localObject4).abfS = ((cc)localObject5).getType();
      ((eaq)localObject4).abfT = l.v((cc)localObject5);
      ((eaq)localObject4).abfU = l.w((cc)localObject5);
      ((eaq)localObject4).abfV = ((cc)localObject5).getCreateTime();
      ((eaq)localObject4).abfW = ((fi)localObject5).field_isSend;
      if (((cc)localObject5).jbG())
      {
        localObject5 = cS((cc)localObject5);
        if (localObject5 != null)
        {
          ((eaq)localObject4).IMu = ((EmojiInfo)localObject5).field_md5;
          if (((EmojiInfo)localObject5).field_md5.equals(((EmojiInfo)localObject2).field_md5))
          {
            ((eaq)localObject4).abfX = 1;
            ((eaq)localObject4).LensId = ((EmojiInfo)localObject5).field_lensId;
          }
        }
      }
      i -= 1;
      ((ear)localObject1).abfY.add(localObject4);
    }
    Log.i("MicroMsg.ChattingUI.EmojiComponent", " add ctxs size:%d", new Object[] { Integer.valueOf(((ear)localObject1).abfY.size()) });
    localObject3 = new y(parama, parama.Uxa, parama.getTalkerUserName());
    for (final boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yTc, true);; bool = false) {
      try
      {
        localObject2 = ((EmojiInfo)localObject2).field_md5;
        localObject4 = parama.getTalkerUserName();
        localObject5 = com.tencent.mm.search.c.b.acsj;
        localObject1 = new SimilarEmojiQueryModel("", (String)localObject2, (String)localObject4, com.tencent.mm.search.c.b.getTimestamp(), 3, parama.getTalkerUserName(), com.tencent.mm.bx.b.cX(((ear)localObject1).toByteArray()), bool, (com.tencent.mm.pluginsdk.ui.chat.j)localObject3);
        if (paramcc.mjd == 1)
        {
          bool = true;
          if (bool)
          {
            paramcc.setIgnoreScroll(Boolean.TRUE);
            paramcc.hideVKB();
          }
          this.acss = null;
          this.acss = new com.tencent.mm.search.d.b(parama.aezO.getContext(), (SimilarEmojiQueryModel)localObject1, new kotlin.g.a.a() {});
          paramcc = this.acss.getWindow();
          if (paramcc != null)
          {
            paramcc.setDimAmount(0.0F);
            paramcc.setFlags(131072, 131072);
            paramcc.setSoftInputMode(48);
          }
          this.acss.show();
          AppMethodBeat.o(256172);
          return;
        }
      }
      catch (IOException paramcc)
      {
        Log.i("MicroMsg.ChattingUI.EmojiComponent", "SimilarEmojiQueryModel make error");
        AppMethodBeat.o(256172);
        return;
      }
    }
  }
  
  private void cR(cc paramcc)
  {
    AppMethodBeat.i(35292);
    bh.bCz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      aa.j(this.hlc.aezO.getContext(), this.hlc.aezO.getContentView());
      AppMethodBeat.o(35292);
      return;
    }
    Log.d("MicroMsg.ChattingUI.EmojiComponent", "resendEmoji");
    if (!this.hlc.getTalkerUserName().equals("medianote"))
    {
      bh.bCz();
      com.tencent.mm.model.c.bzz().d(new com.tencent.mm.ay.f(paramcc.field_talker, paramcc.field_msgSvrId));
    }
    an.cq(paramcc);
    AppMethodBeat.o(35292);
  }
  
  private static EmojiInfo cS(cc paramcc)
  {
    AppMethodBeat.i(35295);
    if (paramcc.jbG())
    {
      paramcc = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramcc.field_imgPath);
      AppMethodBeat.o(35295);
      return paramcc;
    }
    bg localbg = bg.byj(paramcc.field_content);
    paramcc = k.b.aP(paramcc.field_content, paramcc.field_reserved);
    if (paramcc == null)
    {
      paramcc = new k.b();
      paramcc.nRf = localbg.md5;
    }
    for (;;)
    {
      if ((Util.isNullOrNil(paramcc.nRf)) || (paramcc.nRf.equals("-1")))
      {
        AppMethodBeat.o(35295);
        return null;
      }
      paramcc = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramcc.nRf);
      break;
    }
  }
  
  private void cr(cc paramcc)
  {
    AppMethodBeat.i(35293);
    Log.d("MicroMsg.ChattingUI.EmojiComponent", "resendAppMsgEmoji");
    if (!this.hlc.getTalkerUserName().equals("medianote"))
    {
      bh.bCz();
      com.tencent.mm.model.c.bzz().d(new com.tencent.mm.ay.f(paramcc.field_talker, paramcc.field_msgSvrId));
    }
    an.cr(paramcc);
    this.hlc.jpK();
    AppMethodBeat.o(35293);
  }
  
  public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(35287);
    Object localObject1;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(35287);
      return false;
    case 104: 
      if ((paramcc.jbG()) || (paramcc.jbH()))
      {
        localObject1 = cS(paramcc);
        if (localObject1 != null)
        {
          paramMenuItem = paramcc.field_talker;
          if (!au.bwE(paramMenuItem)) {
            break label1175;
          }
          paramMenuItem = br.JJ(paramcc.field_content);
        }
      }
      break;
    }
    label1175:
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(12789, new Object[] { Integer.valueOf(3), ((EmojiInfo)localObject1).getMd5(), Integer.valueOf(0), ((EmojiInfo)localObject1).field_designerID, ((EmojiInfo)localObject1).field_groupId, "", "", "", "", "", ((EmojiInfo)localObject1).field_activityid });
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().a(parama.aezO.getContext(), (EmojiInfo)localObject1, 0, paramMenuItem);
      AppMethodBeat.o(35287);
      return true;
      boolean bool = cQ(paramcc);
      AppMethodBeat.o(35287);
      return bool;
      if ((paramcc.jbG()) || (paramcc.jbH()))
      {
        ap.d(paramcc, parama.aezO.getContext());
        AppMethodBeat.o(35287);
        return true;
      }
      AppMethodBeat.o(35287);
      return false;
      if ((paramcc.jbG()) || (paramcc.jbH()))
      {
        localObject1 = null;
        if (!paramcc.jbG()) {
          break label510;
        }
        localObject1 = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramcc.field_imgPath);
        paramMenuItem = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(255791);
            LinkedList localLinkedList = new LinkedList();
            localLinkedList.add(x.this);
            if ((((e)parama.cm(e.class)).jqW()) || (parama.juF())) {}
            for (boolean bool = true;; bool = false)
            {
              n.a(parama.aezO.getContext(), localLinkedList, bool, parama.getTalkerUserName(), null);
              AppMethodBeat.o(255791);
              return;
            }
          }
        };
        if (localObject1 == null) {
          break label711;
        }
        paramMenuItem.run();
        parama = parama.getTalkerUserName();
        paramMenuItem = parama;
        if (au.bwE(parama)) {
          paramMenuItem = br.JJ(paramcc.field_content);
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(12789, new Object[] { Integer.valueOf(1), ((EmojiInfo)localObject1).getMd5(), Integer.valueOf(0), ((EmojiInfo)localObject1).field_designerID, ((EmojiInfo)localObject1).field_groupId, paramMenuItem, "", "", "", ((EmojiInfo)localObject1).field_activityid });
      }
      for (;;)
      {
        AppMethodBeat.o(35287);
        return true;
        label510:
        Object localObject2 = paramcc.field_content;
        paramMenuItem = (MenuItem)localObject1;
        if (localObject2 != null)
        {
          localObject2 = k.b.aP((String)localObject2, paramcc.field_reserved);
          paramMenuItem = (MenuItem)localObject1;
          if (localObject2 != null) {
            paramMenuItem = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(((k.b)localObject2).nRf);
          }
        }
        if (paramMenuItem != null)
        {
          bool = true;
          label575:
          Log.i("MicroMsg.ChattingUI.EmojiComponent", "longCLickRetransmitEmoji: emoji from xml %s", new Object[] { Boolean.valueOf(bool) });
          localObject1 = paramMenuItem;
          if (paramMenuItem != null) {
            break;
          }
          localObject2 = bg.byj(paramcc.field_content);
          localObject1 = paramMenuItem;
          if (!Util.isNullOrNil(((bg)localObject2).md5))
          {
            localObject1 = paramMenuItem;
            if (!((bg)localObject2).md5.equals("-1")) {
              localObject1 = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(((bg)localObject2).md5);
            }
          }
          if (localObject1 == null) {
            break label705;
          }
        }
        label705:
        for (bool = true;; bool = false)
        {
          Log.i("MicroMsg.ChattingUI.EmojiComponent", "longCLickRetransmitEmoji: emoji from content %s", new Object[] { Boolean.valueOf(bool) });
          break;
          bool = false;
          break label575;
        }
        label711:
        if (paramcc.jbH()) {
          paramMenuItem.run();
        }
      }
      if (paramcc.jbG())
      {
        paramMenuItem = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramcc.field_imgPath);
        if (paramMenuItem != null) {
          com.tencent.mm.plugin.report.service.h.OAn.b(12789, new Object[] { Integer.valueOf(2), paramMenuItem.getMd5(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, "", "", "", "", "", paramMenuItem.field_activityid });
        }
        if (paramMenuItem != null) {
          break label991;
        }
      }
      label991:
      for (paramMenuItem = "";; paramMenuItem = paramMenuItem.field_groupId)
      {
        if (!Util.isNullOrNil(paramMenuItem))
        {
          paramcc = new Intent();
          paramcc.putExtra("preceding_scence", 3);
          paramcc.putExtra("download_entrance_scene", 16);
          paramcc.putExtra("extra_id", paramMenuItem);
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "emoji", ".ui.EmojiStoreDetailUI", paramcc);
        }
        do
        {
          AppMethodBeat.o(35287);
          return true;
          paramMenuItem = bg.byj(paramcc.field_content);
        } while ((paramMenuItem == null) || (Util.isNullOrNil(paramMenuItem.md5)) || (paramMenuItem.md5.equals("-1")));
        paramMenuItem = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramMenuItem.md5);
        break;
      }
      paramMenuItem = cS(paramcc);
      if (paramMenuItem != null)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(12789, new Object[] { Integer.valueOf(5), paramMenuItem.getMd5(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, "", "", "", "", "", paramMenuItem.field_activityid });
        paramcc = w.a(parama.aezO.getContext(), parama.aezO.getContext().getString(h.h.loading_tips), false, 0, null);
        new com.tencent.mm.emoji.f.a(parama.aezO.getContext(), paramMenuItem, null, new b.a()
        {
          public final void onResult(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(255785);
            x.this.dismiss();
            if (paramAnonymousBoolean) {
              com.tencent.mm.plugin.emojicapture.api.b.A(parama.aezO.getContext(), paramMenuItem.getMd5(), parama.getTalkerUserName());
            }
            AppMethodBeat.o(255785);
          }
        });
      }
      AppMethodBeat.o(35287);
      return true;
      b(paramcc, parama);
      AppMethodBeat.o(35287);
      return true;
    }
  }
  
  public final boolean cQ(cc paramcc)
  {
    AppMethodBeat.i(35291);
    Log.i("MicroMsg.ChattingUI.EmojiComponent", "[resendEmoji] %d", new Object[] { Long.valueOf(paramcc.field_msgId) });
    if (paramcc.jbG())
    {
      cR(paramcc);
      AppMethodBeat.o(35291);
      return true;
    }
    if (paramcc.jbH())
    {
      cr(paramcc);
      AppMethodBeat.o(35291);
      return true;
    }
    AppMethodBeat.o(35291);
    return false;
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(35288);
    Log.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingEnterAnimEnd]");
    this.aerz.alive();
    AppMethodBeat.o(35288);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35289);
    Log.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingExitAnimStart]");
    this.aerz.dead();
    AppMethodBeat.o(35289);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35290);
    super.jqF();
    Log.i("MicroMsg.ChattingUI.EmojiComponent", "[onComponentUnInstall]");
    this.aerz.dead();
    AppMethodBeat.o(35290);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(35296);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.acss != null) && (this.acss.isShowing()))
    {
      this.acss.dismiss();
      this.acss = null;
    }
    AppMethodBeat.o(35296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.x
 * JD-Core Version:    0.7.0.1
 */