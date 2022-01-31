package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.emojicapture.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.ao;
import com.tencent.mm.ui.chatting.e;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.b.a.a(cFA=com.tencent.mm.ui.chatting.b.b.l.class)
public class o
  extends a
  implements com.tencent.mm.ui.chatting.b.b.l
{
  private com.tencent.mm.sdk.b.c vpY = new o.1(this);
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    boolean bool2 = true;
    boolean bool1;
    label122:
    Object localObject;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool1 = false;
    case 104: 
      do
      {
        return bool1;
        if (parambi.cvo()) {
          break;
        }
        bool1 = bool2;
      } while (!parambi.cvp());
      if (parambi.cvo())
      {
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(parambi.field_imgPath);
        localObject = parambi.field_talker;
        if (com.tencent.mm.model.s.fn((String)localObject))
        {
          parambi = bd.iI(parambi.field_content);
          label144:
          com.tencent.mm.plugin.report.service.h.nFQ.f(12789, new Object[] { Integer.valueOf(3), paramMenuItem.Wv(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, "", "", "", "", "", paramMenuItem.field_activityid });
          ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(parama.vtz.getContext(), paramMenuItem, 0, parambi);
          return true;
        }
      }
      else
      {
        localObject = ap.abP(parambi.field_content);
        paramMenuItem = g.a.M(parambi.field_content, parambi.field_reserved);
        if (paramMenuItem != null) {
          break label1186;
        }
        paramMenuItem = new g.a();
        paramMenuItem.dQx = ((ap)localObject).bIW;
      }
      break;
    }
    label1186:
    for (;;)
    {
      bool1 = bool2;
      if (bk.bl(paramMenuItem.dQx)) {
        break;
      }
      bool1 = bool2;
      if (paramMenuItem.dQx.equals("-1")) {
        break;
      }
      paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(paramMenuItem.dQx);
      break label122;
      return aX(parambi);
      if ((parambi.cvo()) || (parambi.cvp()))
      {
        ao.d(parambi, parama.vtz.getContext());
        return true;
      }
      return false;
      if (!parambi.cvo())
      {
        bool1 = bool2;
        if (!parambi.cvp()) {
          break;
        }
      }
      paramMenuItem = new LinkedList();
      paramMenuItem.add(parambi);
      if ((((com.tencent.mm.ui.chatting.b.b.c)parama.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDH()) || (parama.cFD()))
      {
        bool1 = true;
        label455:
        com.tencent.mm.ui.chatting.l.a(parama.vtz.getContext(), paramMenuItem, bool1, parama.getTalkerUserName(), null);
        if (!parambi.cvo()) {
          break label623;
        }
      }
      for (paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(parambi.field_imgPath);; paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(paramMenuItem.bIW))
      {
        bool1 = bool2;
        if (paramMenuItem == null) {
          break;
        }
        localObject = parama.getTalkerUserName();
        parama = (com.tencent.mm.ui.chatting.c.a)localObject;
        if (com.tencent.mm.model.s.fn((String)localObject)) {
          parama = bd.iI(parambi.field_content);
        }
        com.tencent.mm.plugin.report.service.h.nFQ.f(12789, new Object[] { Integer.valueOf(1), paramMenuItem.Wv(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, parama, "", "", "", paramMenuItem.field_activityid });
        return true;
        bool1 = false;
        break label455;
        label623:
        paramMenuItem = ap.abP(parambi.field_content);
        bool1 = bool2;
        if (bk.bl(paramMenuItem.bIW)) {
          break;
        }
        bool1 = bool2;
        if (paramMenuItem.bIW.equals("-1")) {
          break;
        }
      }
      if (parambi.cvo())
      {
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(parambi.field_imgPath);
        label717:
        if (paramMenuItem != null) {
          com.tencent.mm.plugin.report.service.h.nFQ.f(12789, new Object[] { Integer.valueOf(2), paramMenuItem.Wv(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, "", "", "", "", "", paramMenuItem.field_activityid });
        }
        if (paramMenuItem != null) {
          break label939;
        }
      }
      label939:
      for (paramMenuItem = "";; paramMenuItem = paramMenuItem.field_groupId)
      {
        bool1 = bool2;
        if (bk.bl(paramMenuItem)) {
          break;
        }
        parambi = new Intent();
        parambi.putExtra("preceding_scence", 3);
        parambi.putExtra("download_entrance_scene", 16);
        parambi.putExtra("extra_id", paramMenuItem);
        com.tencent.mm.br.d.b(parama.vtz.getContext(), "emoji", ".ui.EmojiStoreDetailUI", parambi);
        return true;
        paramMenuItem = ap.abP(parambi.field_content);
        bool1 = bool2;
        if (bk.bl(paramMenuItem.bIW)) {
          break;
        }
        bool1 = bool2;
        if (paramMenuItem.bIW.equals("-1")) {
          break;
        }
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(paramMenuItem.bIW);
        break label717;
      }
      if (parambi.cvo())
      {
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(parambi.field_imgPath);
        label977:
        com.tencent.mm.plugin.report.service.h.nFQ.f(12789, new Object[] { Integer.valueOf(5), paramMenuItem.Wv(), Integer.valueOf(0), paramMenuItem.field_designerID, paramMenuItem.field_groupId, "", "", "", "", "", paramMenuItem.field_activityid });
        b.ae(parama.vtz.getContext(), paramMenuItem.Wv());
        return true;
      }
      localObject = ap.abP(parambi.field_content);
      paramMenuItem = g.a.M(parambi.field_content, parambi.field_reserved);
      if (paramMenuItem == null)
      {
        paramMenuItem = new g.a();
        paramMenuItem.dQx = ((ap)localObject).bIW;
      }
      for (;;)
      {
        bool1 = bool2;
        if (bk.bl(paramMenuItem.dQx)) {
          break;
        }
        bool1 = bool2;
        if (paramMenuItem.dQx.equals("-1")) {
          break;
        }
        paramMenuItem = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(paramMenuItem.dQx);
        break label977;
      }
      parambi = (bi)localObject;
      break label144;
    }
  }
  
  public final boolean aX(bi parambi)
  {
    y.i("MicroMsg.ChattingUI.EmojiComponent", "[resendEmoji] %d", new Object[] { Long.valueOf(parambi.field_msgId) });
    if (parambi.cvo())
    {
      au.Hx();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.s.gM(this.byx.vtz.getContext());
        return true;
      }
      y.d("MicroMsg.ChattingUI.EmojiComponent", "resendEmoji");
      if (!this.byx.getTalkerUserName().equals("medianote"))
      {
        au.Hx();
        com.tencent.mm.model.c.Fv().b(new com.tencent.mm.ay.d(parambi.field_talker, parambi.field_msgSvrId));
      }
      am.aJ(parambi);
      return true;
    }
    if (parambi.cvp())
    {
      y.d("MicroMsg.ChattingUI.EmojiComponent", "resendAppMsgEmoji");
      if (!this.byx.getTalkerUserName().equals("medianote"))
      {
        au.Hx();
        com.tencent.mm.model.c.Fv().b(new com.tencent.mm.ay.d(parambi.field_talker, parambi.field_msgSvrId));
      }
      am.aK(parambi);
      this.byx.cCW();
      return true;
    }
    return false;
  }
  
  public final void cyO()
  {
    y.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingEnterAnimEnd]");
    com.tencent.mm.sdk.b.a.udP.c(this.vpY);
  }
  
  public final void cyR()
  {
    y.i("MicroMsg.ChattingUI.EmojiComponent", "[onChattingExitAnimStart]");
    com.tencent.mm.sdk.b.a.udP.d(this.vpY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.o
 * JD-Core Version:    0.7.0.1
 */