package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.b;
import com.tencent.mm.am.ag;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.h;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.widget.MMEditText;

@com.tencent.mm.ui.chatting.d.a.a(fFo=an.class)
public class q
  extends a
  implements an
{
  private boolean JIr = false;
  private boolean JIs = false;
  private String JIt;
  private String JIu;
  private long JIv;
  private long JIw = -1L;
  private q.a JIx = q.a.JIy;
  
  private void fDy()
  {
    AppMethodBeat.i(35274);
    s locals = (s)this.cWM.bh(s.class);
    if (locals.fDC() == null)
    {
      AppMethodBeat.o(35274);
      return;
    }
    if (this.JIx == q.a.JIz) {}
    for (boolean bool = true;; bool = false)
    {
      locals.fDC().wd(bool);
      AppMethodBeat.o(35274);
      return;
    }
  }
  
  private void fDz()
  {
    AppMethodBeat.i(35275);
    s locals = (s)this.cWM.bh(s.class);
    if (locals.fDC() == null)
    {
      AppMethodBeat.o(35275);
      return;
    }
    locals.fDC().fdL();
    AppMethodBeat.o(35275);
  }
  
  public final void fDx()
  {
    AppMethodBeat.i(35273);
    if (bt.isNullOrNil(this.cWM.getTalkerUserName()))
    {
      AppMethodBeat.o(35273);
      return;
    }
    s locals = (s)this.cWM.bh(s.class);
    if (locals.fDC() != null)
    {
      if ((!bt.isNullOrNil(this.JIt)) || (this.JIv != 0L))
      {
        int i;
        boolean bool1;
        if ((locals.fDC().getMode() == 1) && (bt.isNullOrNil(locals.fDF())))
        {
          i = 1;
          bool1 = ((ai)this.cWM.bh(ai.class)).fEO();
          if ((i == 0) || (bool1)) {
            break label375;
          }
          fDz();
          label126:
          if (this.JIv != 0L) {
            locals.fDC().setLastQuoteMsgId(this.JIv);
          }
          boolean bool2 = ((d)this.cWM.bh(d.class)).fCI();
          if (((!this.cWM.fFu()) && (!bool2)) || (!this.JIr)) {
            break label382;
          }
          this.JIr = false;
          String str1 = locals.fDC().getAtSomebody();
          if (!bt.isNullOrNil(str1))
          {
            int j = locals.fDC().getInsertPos();
            i = j;
            if (j > this.JIt.length()) {
              i = this.JIt.length();
            }
            Object localObject = new StringBuilder().append(this.JIt.substring(0, i)).append(str1).append(' ');
            String str2 = this.JIt;
            localObject = str2.substring(i, str2.length());
            j = str1.length();
            locals.fDC().setLastContent((String)localObject);
            locals.fDC().w((String)localObject, i + j + 1, false);
            locals.fDC().setAtSomebody(null);
            fDz();
          }
        }
        for (;;)
        {
          locals.fDI();
          AppMethodBeat.o(35273);
          return;
          i = 0;
          break;
          label375:
          fDy();
          break label126;
          label382:
          locals.fDC().setLastContent(this.JIt);
          locals.fDC().setLastText(this.JIt);
          if (((!bt.isNullOrNil(this.JIt)) || (this.JIv != 0L)) && (!bool1) && (bt.isNullOrNil(locals.fDF()))) {
            locals.fDM();
          }
        }
      }
      if (((aa)this.cWM.bh(aa.class)).fEs())
      {
        locals.fDC().setLastText(this.JIt);
        locals.fDC().setHint(this.cWM.JOR.getMMResources().getString(2131757331));
        locals.fDC().setLastQuoteMsgId(this.JIv);
        AppMethodBeat.o(35273);
        return;
      }
      if (locals.fDC().getIsVoiceInputPanleShow())
      {
        locals.fDI();
        AppMethodBeat.o(35273);
        return;
      }
      fDy();
    }
    AppMethodBeat.o(35273);
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(35271);
    ad.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark reset keybord state");
    this.JIx = q.a.JIy;
    if (this.cWM.BYG != null)
    {
      Object localObject = (d)this.cWM.bh(d.class);
      if (((d)localObject).fCH())
      {
        localObject = ag.aGc().rS(((d)localObject).fCU()).field_editingMsg;
        this.JIt = ((String)localObject);
        this.JIu = ((String)localObject);
        AppMethodBeat.o(35271);
        return;
      }
      if (((h)this.cWM.bh(h.class)).fDl())
      {
        localObject = ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).aih(this.cWM.getTalkerUserName());
        this.JIt = ((String)localObject);
        this.JIu = ((String)localObject);
        AppMethodBeat.o(35271);
        return;
      }
      com.tencent.mm.model.ba.aBQ();
      localObject = c.azv().aTz(this.cWM.getTalkerUserName());
      if (localObject != null)
      {
        String str = ((com.tencent.mm.g.c.ba)localObject).field_editingMsg;
        this.JIt = str;
        this.JIu = str;
        long l = ((com.tencent.mm.g.c.ba)localObject).field_editingQuoteMsgId;
        this.JIv = l;
        this.JIw = l;
      }
    }
    AppMethodBeat.o(35271);
  }
  
  public final void fwu() {}
  
  public final void fwv() {}
  
  public final void fww()
  {
    AppMethodBeat.i(35272);
    Object localObject = (s)this.cWM.bh(s.class);
    s locals;
    if (((s)localObject).fDC() != null)
    {
      if (((s)localObject).fDC().uCj)
      {
        this.JIx = q.a.JIz;
        ad.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: show");
        this.JIt = ((s)localObject).fDC().getLastText();
        this.JIv = ((s)localObject).fDC().getLastQuoteMsgId();
      }
    }
    else
    {
      locals = (s)this.cWM.bh(s.class);
      localObject = (d)this.cWM.bh(d.class);
      if (!((d)localObject).fCH()) {
        break label283;
      }
      localObject = ag.aGc().rS(((d)localObject).fCU());
      if ((locals.fDC() != null) && ((this.JIu == null) || (!locals.fDC().getLastText().trim().equals(this.JIu))))
      {
        this.JIu = locals.fDC().getLastText().trim();
        ((com.tencent.mm.am.a.a)localObject).field_editingMsg = this.JIu;
        if (!bt.isNullOrNil(((com.tencent.mm.am.a.a)localObject).field_editingMsg)) {
          break label276;
        }
      }
    }
    label276:
    for (long l = ((com.tencent.mm.am.a.a)localObject).field_lastMsgTime;; l = System.currentTimeMillis())
    {
      ((com.tencent.mm.am.a.a)localObject).field_flag = b.a((com.tencent.mm.am.a.a)localObject, 1, l);
      ag.aGc().b((com.tencent.mm.am.a.a)localObject);
      ad.v("MicroMsg.ChattingUI.SearchComponent", "set editMsg history");
      AppMethodBeat.o(35272);
      return;
      this.JIx = q.a.JIy;
      ad.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: hide");
      break;
    }
    label283:
    if (((h)this.cWM.bh(h.class)).fDl())
    {
      if ((locals.fDC() != null) && ((this.JIu == null) || (!locals.fDC().getLastText().trim().equals(this.JIu))))
      {
        this.JIu = locals.fDC().getLastText().trim();
        ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).go(this.cWM.getTalkerUserName(), this.JIu);
        AppMethodBeat.o(35272);
      }
    }
    else
    {
      localObject = null;
      if (com.tencent.mm.kernel.g.ajA().aiK())
      {
        com.tencent.mm.model.ba.aBQ();
        localObject = c.azv().aTz(this.cWM.getTalkerUserName());
      }
      if ((localObject != null) || (locals.fDC() == null) || (bt.isNullOrNil(locals.fDC().getLastText().trim()))) {
        break label799;
      }
      localObject = new at(this.cWM.BYG.field_username);
      ((at)localObject).qu(System.currentTimeMillis());
      if (((ac)this.cWM.bh(ac.class)).fEy()) {
        ((at)localObject).lO(4194304);
      }
      com.tencent.mm.model.ba.aBQ();
      c.azv().e((at)localObject);
    }
    label787:
    label794:
    label799:
    for (;;)
    {
      if ((localObject != null) && (locals.fDC() != null))
      {
        if ((this.JIu != null) && (locals.fDC().getLastText().trim().equals(this.JIu))) {
          break label794;
        }
        this.JIu = locals.fDC().getLastText().trim();
        ((at)localObject).tE(locals.fDC().getLastText().trim());
      }
      for (int i = 1;; i = 0)
      {
        if ((this.JIw == -1L) || (!bt.aA(locals.fDC().getLastQuoteMsgId(), this.JIw)))
        {
          this.JIw = locals.fDC().getLastQuoteMsgId();
          ((com.tencent.mm.g.c.ba)localObject).field_editingQuoteMsgId = this.JIw;
          ((com.tencent.mm.g.c.ba)localObject).eQu = true;
          i = 1;
        }
        if (i != 0) {
          if ((!bt.isNullOrNil(((com.tencent.mm.g.c.ba)localObject).field_editingMsg)) || (((com.tencent.mm.g.c.ba)localObject).field_editingQuoteMsgId != 0L)) {
            break label787;
          }
        }
        for (l = ((com.tencent.mm.g.c.ba)localObject).field_conversationTime;; l = System.currentTimeMillis())
        {
          ((at)localObject).qv(com.tencent.mm.plugin.messenger.foundation.a.a.a.a((at)localObject, 1, l));
          com.tencent.mm.model.ba.aBQ();
          c.azv().a((at)localObject, ((com.tencent.mm.g.c.ba)localObject).field_username, false);
          ad.i("MicroMsg.ChattingUI.SearchComponent", "[doDestroy] set editMsg history! content:%s quoteMsgId:%s username:%s", new Object[] { bt.aRp(this.JIu), Long.valueOf(this.JIw), this.cWM.getTalkerUserName() });
          AppMethodBeat.o(35272);
          return;
        }
      }
    }
  }
  
  public final void fwx() {}
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35268);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35268);
      return;
      if (paramIntent != null)
      {
        s locals = (s)this.cWM.bh(s.class);
        String str = paramIntent.getStringExtra("select_raw_user_name");
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        if (bt.isNullOrNil(paramIntent))
        {
          ad.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", new Object[] { "[nobody]" });
          locals.fDC().setAtSomebody("");
          this.JIr = false;
          AppMethodBeat.o(35268);
          return;
        }
        ad.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", new Object[] { paramIntent });
        locals.fDC().setAtSomebody(paramIntent);
        locals.fDC().aY(this.cWM.getTalkerUserName(), str, paramIntent);
        this.JIr = true;
      }
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(35270);
    paramConfiguration = (s)this.cWM.bh(s.class);
    this.JIt = paramConfiguration.fDC().getLastText();
    this.JIv = paramConfiguration.fDC().getLastQuoteMsgId();
    fDx();
    AppMethodBeat.o(35270);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35269);
    Object localObject;
    int i;
    if (paramKeyEvent.getKeyCode() == 67)
    {
      localObject = (s)this.cWM.bh(s.class);
      if (paramKeyEvent.getAction() == 0)
      {
        if (((s)localObject).fDC().getCharAtCursor() != ' ') {
          break label130;
        }
        this.JIs = true;
      }
      if ((paramKeyEvent.getAction() == 1) && (this.JIs))
      {
        this.JIs = false;
        paramKeyEvent = ((s)localObject).fDC();
        paramInt = paramKeyEvent.getSelectionStart();
        localObject = paramKeyEvent.getLastText().substring(0, paramInt);
        i = ((String)localObject).lastIndexOf('@');
        if ((i < ((String)localObject).length()) && (i >= 0)) {
          break label138;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35269);
      return false;
      label130:
      this.JIs = false;
      break;
      label138:
      localObject = ((String)localObject).substring(0, i);
      String str = paramKeyEvent.getLastText().substring(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject).append(str);
      paramKeyEvent.setLastText(localStringBuilder.toString());
      paramKeyEvent.vBp.setSelection(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.q
 * JD-Core Version:    0.7.0.1
 */