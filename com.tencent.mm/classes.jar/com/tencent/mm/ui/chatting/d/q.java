package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.model.bc;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.aj;
import com.tencent.mm.ui.chatting.d.b.ao;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.h;
import com.tencent.mm.ui.chatting.d.b.i;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.widget.MMEditText;

@com.tencent.mm.ui.chatting.d.a.a(fJv=ao.class)
public class q
  extends a
  implements ao
{
  private boolean Kdn = false;
  private boolean Kdo = false;
  private String Kdp;
  private String Kdq;
  private long Kdr;
  private long Kds = -1L;
  private q.a Kdt = q.a.Kdu;
  
  private void fHB()
  {
    AppMethodBeat.i(35274);
    s locals = (s)this.cXJ.bh(s.class);
    if (locals.fHF() == null)
    {
      AppMethodBeat.o(35274);
      return;
    }
    if (this.Kdt == q.a.Kdv) {}
    for (boolean bool = true;; bool = false)
    {
      locals.fHF().wl(bool);
      AppMethodBeat.o(35274);
      return;
    }
  }
  
  private void fHC()
  {
    AppMethodBeat.i(35275);
    s locals = (s)this.cXJ.bh(s.class);
    if (locals.fHF() == null)
    {
      AppMethodBeat.o(35275);
      return;
    }
    locals.fHF().fhA();
    AppMethodBeat.o(35275);
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(35271);
    ae.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark reset keybord state");
    this.Kdt = q.a.Kdu;
    if (this.cXJ.Cqh != null)
    {
      Object localObject = (d)this.cXJ.bh(d.class);
      if (((d)localObject).fGJ())
      {
        localObject = ag.aGs().sf(((d)localObject).fGW()).field_editingMsg;
        this.Kdp = ((String)localObject);
        this.Kdq = ((String)localObject);
        AppMethodBeat.o(35271);
        return;
      }
      if (((h)this.cXJ.bh(h.class)).fHo())
      {
        localObject = ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).aje(this.cXJ.getTalkerUserName());
        this.Kdp = ((String)localObject);
        this.Kdq = ((String)localObject);
        AppMethodBeat.o(35271);
        return;
      }
      if (((i)this.cXJ.bh(i.class)).fHq())
      {
        localObject = ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.c.class)).aje(this.cXJ.getTalkerUserName());
        this.Kdp = ((String)localObject);
        this.Kdq = ((String)localObject);
        AppMethodBeat.o(35271);
        return;
      }
      bc.aCg();
      localObject = com.tencent.mm.model.c.azL().aVa(this.cXJ.getTalkerUserName());
      if (localObject != null)
      {
        String str = ((ba)localObject).field_editingMsg;
        this.Kdp = str;
        this.Kdq = str;
        long l = ((ba)localObject).field_editingQuoteMsgId;
        this.Kdr = l;
        this.Kds = l;
      }
    }
    AppMethodBeat.o(35271);
  }
  
  public final void fAu() {}
  
  public final void fAv() {}
  
  public final void fAw()
  {
    AppMethodBeat.i(35272);
    Object localObject = (s)this.cXJ.bh(s.class);
    s locals;
    if (((s)localObject).fHF() != null)
    {
      if (((s)localObject).fHF().uNO)
      {
        this.Kdt = q.a.Kdv;
        ae.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: show");
        this.Kdp = ((s)localObject).fHF().getLastText();
        this.Kdr = ((s)localObject).fHF().getLastQuoteMsgId();
      }
    }
    else
    {
      locals = (s)this.cXJ.bh(s.class);
      localObject = (d)this.cXJ.bh(d.class);
      if (!((d)localObject).fGJ()) {
        break label278;
      }
      localObject = ag.aGs().sf(((d)localObject).fGW());
      if ((locals.fHF() != null) && ((this.Kdq == null) || (!locals.fHF().getLastText().trim().equals(this.Kdq))))
      {
        this.Kdq = locals.fHF().getLastText().trim();
        ((com.tencent.mm.al.a.a)localObject).field_editingMsg = this.Kdq;
        if (!bu.isNullOrNil(((com.tencent.mm.al.a.a)localObject).field_editingMsg)) {
          break label271;
        }
      }
    }
    label271:
    for (long l = ((com.tencent.mm.al.a.a)localObject).field_lastMsgTime;; l = System.currentTimeMillis())
    {
      ((com.tencent.mm.al.a.a)localObject).field_flag = b.a((com.tencent.mm.al.a.a)localObject, 1, l);
      ag.aGs().b((com.tencent.mm.al.a.a)localObject);
      ae.v("MicroMsg.ChattingUI.SearchComponent", "set editMsg history");
      AppMethodBeat.o(35272);
      return;
      this.Kdt = q.a.Kdu;
      ae.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: hide");
      break;
    }
    label278:
    if (((h)this.cXJ.bh(h.class)).fHo())
    {
      if ((locals.fHF() != null) && ((this.Kdq == null) || (!locals.fHF().getLastText().trim().equals(this.Kdq))))
      {
        this.Kdq = locals.fHF().getLastText().trim();
        ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).gt(this.cXJ.getTalkerUserName(), this.Kdq);
        AppMethodBeat.o(35272);
      }
    }
    else if (((i)this.cXJ.bh(i.class)).fHq())
    {
      if ((locals.fHF() != null) && ((this.Kdq == null) || (!locals.fHF().getLastText().trim().equals(this.Kdq))))
      {
        this.Kdq = locals.fHF().getLastText().trim();
        ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.c.class)).gt(this.cXJ.getTalkerUserName(), this.Kdq);
        AppMethodBeat.o(35272);
      }
    }
    else
    {
      localObject = null;
      if (com.tencent.mm.kernel.g.ajP().aiZ())
      {
        bc.aCg();
        localObject = com.tencent.mm.model.c.azL().aVa(this.cXJ.getTalkerUserName());
      }
      if ((localObject != null) || (locals.fHF() == null) || (bu.isNullOrNil(locals.fHF().getLastText().trim()))) {
        break label900;
      }
      localObject = new au(this.cXJ.Cqh.field_username);
      ((au)localObject).qH(System.currentTimeMillis());
      if (((ac)this.cXJ.bh(ac.class)).fIC()) {
        ((au)localObject).lQ(4194304);
      }
      bc.aCg();
      com.tencent.mm.model.c.azL().e((au)localObject);
    }
    label900:
    for (;;)
    {
      if ((localObject != null) && (locals.fHF() != null))
      {
        if ((this.Kdq != null) && (locals.fHF().getLastText().trim().equals(this.Kdq))) {
          break label895;
        }
        this.Kdq = locals.fHF().getLastText().trim();
        ((au)localObject).tZ(locals.fHF().getLastText().trim());
      }
      label888:
      label895:
      for (int i = 1;; i = 0)
      {
        if ((this.Kds == -1L) || (!bu.az(locals.fHF().getLastQuoteMsgId(), this.Kds)))
        {
          this.Kds = locals.fHF().getLastQuoteMsgId();
          ((ba)localObject).field_editingQuoteMsgId = this.Kds;
          ((ba)localObject).eSf = true;
          i = 1;
        }
        if (i != 0) {
          if ((!bu.isNullOrNil(((ba)localObject).field_editingMsg)) || (((ba)localObject).field_editingQuoteMsgId != 0L)) {
            break label888;
          }
        }
        for (l = ((ba)localObject).field_conversationTime;; l = System.currentTimeMillis())
        {
          ((au)localObject).qI(com.tencent.mm.plugin.messenger.foundation.a.a.a.a((au)localObject, 1, l));
          bc.aCg();
          com.tencent.mm.model.c.azL().a((au)localObject, ((ba)localObject).field_username, false);
          ae.i("MicroMsg.ChattingUI.SearchComponent", "[doDestroy] set editMsg history! content:%s quoteMsgId:%s username:%s", new Object[] { bu.aSM(this.Kdq), Long.valueOf(this.Kds), this.cXJ.getTalkerUserName() });
          AppMethodBeat.o(35272);
          return;
        }
      }
    }
  }
  
  public final void fAx() {}
  
  public final void fHA()
  {
    AppMethodBeat.i(35273);
    if (bu.isNullOrNil(this.cXJ.getTalkerUserName()))
    {
      AppMethodBeat.o(35273);
      return;
    }
    s locals = (s)this.cXJ.bh(s.class);
    if (locals.fHF() != null)
    {
      if ((!bu.isNullOrNil(this.Kdp)) || (this.Kdr != 0L))
      {
        int i;
        boolean bool1;
        if ((locals.fHF().getMode() == 1) && (bu.isNullOrNil(locals.fHI())))
        {
          i = 1;
          bool1 = ((aj)this.cXJ.bh(aj.class)).fIR();
          if ((i == 0) || (bool1)) {
            break label379;
          }
          fHC();
          label129:
          if (this.Kdr != 0L) {
            locals.fHF().setLastQuoteMsgId(this.Kdr);
          }
          boolean bool2 = ((d)this.cXJ.bh(d.class)).fGK();
          if (((!this.cXJ.fJB()) && (!bool2)) || (!this.Kdn)) {
            break label386;
          }
          this.Kdn = false;
          String str1 = locals.fHF().getAtSomebody();
          if (!bu.isNullOrNil(str1))
          {
            int j = locals.fHF().getInsertPos();
            i = j;
            if (j > this.Kdp.length()) {
              i = this.Kdp.length();
            }
            Object localObject = new StringBuilder().append(this.Kdp.substring(0, i)).append(str1).append(' ');
            String str2 = this.Kdp;
            localObject = str2.substring(i, str2.length());
            j = str1.length();
            locals.fHF().setLastContent((String)localObject);
            locals.fHF().w((String)localObject, i + j + 1, false);
            locals.fHF().setAtSomebody(null);
            fHC();
          }
        }
        for (;;)
        {
          locals.fHL();
          AppMethodBeat.o(35273);
          return;
          i = 0;
          break;
          label379:
          fHB();
          break label129;
          label386:
          locals.fHF().setLastContent(this.Kdp);
          locals.fHF().setLastText(this.Kdp);
          if (((!bu.isNullOrNil(this.Kdp)) || (this.Kdr != 0L)) && (!bool1) && (bu.isNullOrNil(locals.fHI()))) {
            locals.fHP();
          }
        }
      }
      if (((aa)this.cXJ.bh(aa.class)).fIw())
      {
        locals.fHF().setLastText(this.Kdp);
        locals.fHF().setHint(this.cXJ.Kkd.getMMResources().getString(2131757331));
        locals.fHF().setLastQuoteMsgId(this.Kdr);
        AppMethodBeat.o(35273);
        return;
      }
      if (locals.fHF().getIsVoiceInputPanleShow())
      {
        locals.fHL();
        AppMethodBeat.o(35273);
        return;
      }
      fHB();
    }
    AppMethodBeat.o(35273);
  }
  
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
        s locals = (s)this.cXJ.bh(s.class);
        String str = paramIntent.getStringExtra("select_raw_user_name");
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        if (bu.isNullOrNil(paramIntent))
        {
          ae.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", new Object[] { "[nobody]" });
          locals.fHF().setAtSomebody("");
          this.Kdn = false;
          AppMethodBeat.o(35268);
          return;
        }
        ae.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", new Object[] { paramIntent });
        locals.fHF().setAtSomebody(paramIntent);
        locals.fHF().aZ(this.cXJ.getTalkerUserName(), str, paramIntent);
        this.Kdn = true;
      }
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(35270);
    paramConfiguration = (s)this.cXJ.bh(s.class);
    this.Kdp = paramConfiguration.fHF().getLastText();
    this.Kdr = paramConfiguration.fHF().getLastQuoteMsgId();
    fHA();
    AppMethodBeat.o(35270);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35269);
    Object localObject;
    int i;
    if (paramKeyEvent.getKeyCode() == 67)
    {
      localObject = (s)this.cXJ.bh(s.class);
      if (paramKeyEvent.getAction() == 0)
      {
        if (((s)localObject).fHF().getCharAtCursor() != ' ') {
          break label130;
        }
        this.Kdo = true;
      }
      if ((paramKeyEvent.getAction() == 1) && (this.Kdo))
      {
        this.Kdo = false;
        paramKeyEvent = ((s)localObject).fHF();
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
      this.Kdo = false;
      break;
      label138:
      localObject = ((String)localObject).substring(0, i);
      String str = paramKeyEvent.getLastText().substring(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject).append(str);
      paramKeyEvent.setLastText(localStringBuilder.toString());
      paramKeyEvent.vNt.setSelection(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.q
 * JD-Core Version:    0.7.0.1
 */