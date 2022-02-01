package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.af;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.c.b.ae;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.q;
import com.tencent.mm.ui.chatting.c.b.y;
import com.tencent.mm.ui.widget.MMEditText;

@com.tencent.mm.ui.chatting.c.a.a(foJ=aj.class)
public class o
  extends a
  implements aj
{
  private boolean HTT = false;
  private boolean HTU = false;
  private String HTV;
  private String HTW;
  private long HTX;
  private long HTY = -1L;
  private o.a HTZ = o.a.HUa;
  
  private void fna()
  {
    AppMethodBeat.i(35274);
    q localq = (q)this.cLy.bf(q.class);
    if (localq.fne() == null)
    {
      AppMethodBeat.o(35274);
      return;
    }
    if (this.HTZ == o.a.HUb) {}
    for (boolean bool = true;; bool = false)
    {
      localq.fne().vr(bool);
      AppMethodBeat.o(35274);
      return;
    }
  }
  
  private void fnb()
  {
    AppMethodBeat.i(35275);
    q localq = (q)this.cLy.bf(q.class);
    if (localq.fne() == null)
    {
      AppMethodBeat.o(35275);
      return;
    }
    localq.fne().eOL();
    AppMethodBeat.o(35275);
  }
  
  public final void fgh()
  {
    AppMethodBeat.i(35271);
    ac.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark reset keybord state");
    this.HTZ = o.a.HUa;
    if (this.cLy.AzG != null)
    {
      Object localObject = (d)this.cLy.bf(d.class);
      if (((d)localObject).fmo())
      {
        localObject = af.aCZ().pT(((d)localObject).fmB()).field_editingMsg;
        this.HTV = ((String)localObject);
        this.HTW = ((String)localObject);
        AppMethodBeat.o(35271);
        return;
      }
      com.tencent.mm.model.az.ayM();
      localObject = c.awG().aNI(this.cLy.getTalkerUserName());
      if (localObject != null)
      {
        String str = ((com.tencent.mm.g.c.az)localObject).field_editingMsg;
        this.HTV = str;
        this.HTW = str;
        long l = ((com.tencent.mm.g.c.az)localObject).field_editingQuoteMsgId;
        this.HTX = l;
        this.HTY = l;
      }
    }
    AppMethodBeat.o(35271);
  }
  
  public final void fgi() {}
  
  public final void fgj() {}
  
  public final void fgk()
  {
    AppMethodBeat.i(35272);
    Object localObject = (q)this.cLy.bf(q.class);
    q localq;
    if (((q)localObject).fne() != null)
    {
      if (((q)localObject).fne().tzA)
      {
        this.HTZ = o.a.HUb;
        ac.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: show");
        this.HTV = ((q)localObject).fne().getLastText();
        this.HTX = ((q)localObject).fne().getLastQuoteMsgId();
      }
    }
    else
    {
      localq = (q)this.cLy.bf(q.class);
      localObject = (d)this.cLy.bf(d.class);
      if (!((d)localObject).fmo()) {
        break label278;
      }
      localObject = af.aCZ().pT(((d)localObject).fmB());
      if ((localq.fne() != null) && ((this.HTW == null) || (!localq.fne().getLastText().trim().equals(this.HTW))))
      {
        this.HTW = localq.fne().getLastText().trim();
        ((com.tencent.mm.al.a.a)localObject).field_editingMsg = this.HTW;
        if (!bs.isNullOrNil(((com.tencent.mm.al.a.a)localObject).field_editingMsg)) {
          break label271;
        }
      }
    }
    label271:
    for (long l = ((com.tencent.mm.al.a.a)localObject).field_lastMsgTime;; l = System.currentTimeMillis())
    {
      ((com.tencent.mm.al.a.a)localObject).field_flag = b.a((com.tencent.mm.al.a.a)localObject, 1, l);
      af.aCZ().b((com.tencent.mm.al.a.a)localObject);
      ac.v("MicroMsg.ChattingUI.SearchComponent", "set editMsg history");
      AppMethodBeat.o(35272);
      return;
      this.HTZ = o.a.HUa;
      ac.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: hide");
      break;
    }
    label278:
    localObject = null;
    if (g.agP().afY())
    {
      com.tencent.mm.model.az.ayM();
      localObject = c.awG().aNI(this.cLy.getTalkerUserName());
    }
    if ((localObject == null) && (localq.fne() != null) && (!bs.isNullOrNil(localq.fne().getLastText().trim())))
    {
      localObject = new ap(this.cLy.AzG.field_username);
      ((ap)localObject).ou(System.currentTimeMillis());
      if (((aa)this.cLy.bf(aa.class)).fob()) {
        ((ap)localObject).lp(4194304);
      }
      com.tencent.mm.model.az.ayM();
      c.awG().e((ap)localObject);
    }
    for (;;)
    {
      if ((localObject != null) && (localq.fne() != null))
      {
        if ((this.HTW != null) && (localq.fne().getLastText().trim().equals(this.HTW))) {
          break label677;
        }
        this.HTW = localq.fne().getLastText().trim();
        ((ap)localObject).qU(localq.fne().getLastText().trim());
      }
      label670:
      label677:
      for (int i = 1;; i = 0)
      {
        if ((this.HTY == -1L) || (!bs.av(localq.fne().getLastQuoteMsgId(), this.HTY)))
        {
          this.HTY = localq.fne().getLastQuoteMsgId();
          ((com.tencent.mm.g.c.az)localObject).field_editingQuoteMsgId = this.HTY;
          ((com.tencent.mm.g.c.az)localObject).eyW = true;
          i = 1;
        }
        if (i != 0) {
          if ((!bs.isNullOrNil(((com.tencent.mm.g.c.az)localObject).field_editingMsg)) || (((com.tencent.mm.g.c.az)localObject).field_editingQuoteMsgId != 0L)) {
            break label670;
          }
        }
        for (l = ((com.tencent.mm.g.c.az)localObject).field_conversationTime;; l = System.currentTimeMillis())
        {
          ((ap)localObject).ov(com.tencent.mm.plugin.messenger.foundation.a.a.a.a((ap)localObject, 1, l));
          com.tencent.mm.model.az.ayM();
          c.awG().a((ap)localObject, ((com.tencent.mm.g.c.az)localObject).field_username, false);
          ac.i("MicroMsg.ChattingUI.SearchComponent", "[doDestroy] set editMsg history! content:%s quoteMsgId:%s username:%s", new Object[] { bs.aLJ(this.HTW), Long.valueOf(this.HTY), this.cLy.getTalkerUserName() });
          AppMethodBeat.o(35272);
          return;
        }
      }
    }
  }
  
  public final void fgl() {}
  
  public final void fmZ()
  {
    AppMethodBeat.i(35273);
    if (bs.isNullOrNil(this.cLy.getTalkerUserName()))
    {
      AppMethodBeat.o(35273);
      return;
    }
    q localq = (q)this.cLy.bf(q.class);
    if (localq.fne() != null)
    {
      if ((!bs.isNullOrNil(this.HTV)) || (this.HTX != 0L))
      {
        int i;
        boolean bool1;
        if ((localq.fne().getMode() == 1) && (bs.isNullOrNil(localq.fnh())))
        {
          i = 1;
          bool1 = ((ae)this.cLy.bf(ae.class)).fok();
          if ((i == 0) || (bool1)) {
            break label379;
          }
          fnb();
          label129:
          if (this.HTX != 0L) {
            localq.fne().setLastQuoteMsgId(this.HTX);
          }
          boolean bool2 = ((d)this.cLy.bf(d.class)).fmp();
          if (((!this.cLy.foP()) && (!bool2)) || (!this.HTT)) {
            break label386;
          }
          this.HTT = false;
          String str1 = localq.fne().getAtSomebody();
          if (!bs.isNullOrNil(str1))
          {
            int j = localq.fne().getInsertPos();
            i = j;
            if (j > this.HTV.length()) {
              i = this.HTV.length();
            }
            Object localObject = new StringBuilder().append(this.HTV.substring(0, i)).append(str1).append(' ');
            String str2 = this.HTV;
            localObject = str2.substring(i, str2.length());
            j = str1.length();
            localq.fne().setLastContent((String)localObject);
            localq.fne().w((String)localObject, i + j + 1, false);
            localq.fne().setAtSomebody(null);
            fnb();
          }
        }
        for (;;)
        {
          localq.fnk();
          AppMethodBeat.o(35273);
          return;
          i = 0;
          break;
          label379:
          fna();
          break label129;
          label386:
          localq.fne().setLastContent(this.HTV);
          localq.fne().setLastText(this.HTV);
          if (((!bs.isNullOrNil(this.HTV)) || (this.HTX != 0L)) && (!bool1) && (bs.isNullOrNil(localq.fnh()))) {
            localq.fno();
          }
        }
      }
      if (((y)this.cLy.bf(y.class)).fnV())
      {
        localq.fne().setLastText(this.HTV);
        localq.fne().setHint(this.cLy.HZF.getMMResources().getString(2131757331));
        localq.fne().setLastQuoteMsgId(this.HTX);
        AppMethodBeat.o(35273);
        return;
      }
      if (localq.fne().getIsVoiceInputPanleShow())
      {
        localq.fnk();
        AppMethodBeat.o(35273);
        return;
      }
      fna();
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
        q localq = (q)this.cLy.bf(q.class);
        String str = paramIntent.getStringExtra("select_raw_user_name");
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        if (bs.isNullOrNil(paramIntent))
        {
          ac.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", new Object[] { "[nobody]" });
          localq.fne().setAtSomebody("");
          this.HTT = false;
          AppMethodBeat.o(35268);
          return;
        }
        ac.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", new Object[] { paramIntent });
        localq.fne().setAtSomebody(paramIntent);
        localq.fne().aQ(this.cLy.getTalkerUserName(), str, paramIntent);
        this.HTT = true;
      }
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(35270);
    paramConfiguration = (q)this.cLy.bf(q.class);
    this.HTV = paramConfiguration.fne().getLastText();
    this.HTX = paramConfiguration.fne().getLastQuoteMsgId();
    fmZ();
    AppMethodBeat.o(35270);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35269);
    Object localObject;
    int i;
    if (paramKeyEvent.getKeyCode() == 67)
    {
      localObject = (q)this.cLy.bf(q.class);
      if (paramKeyEvent.getAction() == 0)
      {
        if (((q)localObject).fne().getCharAtCursor() != ' ') {
          break label130;
        }
        this.HTU = true;
      }
      if ((paramKeyEvent.getAction() == 1) && (this.HTU))
      {
        this.HTU = false;
        paramKeyEvent = ((q)localObject).fne();
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
      this.HTU = false;
      break;
      label138:
      localObject = ((String)localObject).substring(0, i);
      String str = paramKeyEvent.getLastText().substring(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject).append(str);
      paramKeyEvent.setLastText(localStringBuilder.toString());
      paramKeyEvent.uyM.setSelection(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.o
 * JD-Core Version:    0.7.0.1
 */