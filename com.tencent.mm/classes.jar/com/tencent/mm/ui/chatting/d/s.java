package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.af;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.findersdk.a.n;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.as;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.i;
import com.tencent.mm.ui.chatting.d.b.u;

@com.tencent.mm.ui.chatting.d.a.a(hRc=as.class)
public class s
  extends a
  implements as
{
  private boolean Cyu = false;
  private boolean WJh = false;
  private String WJi;
  private String WJj;
  private long WJk;
  private long WJl = -1L;
  private s.a WJm = s.a.WJn;
  
  private void hPe()
  {
    AppMethodBeat.i(35274);
    u localu = (u)this.fgR.bC(u.class);
    if (localu.hPj() == null)
    {
      AppMethodBeat.o(35274);
      return;
    }
    if (this.WJm == s.a.WJo) {}
    for (boolean bool = true;; bool = false)
    {
      localu.hPj().Ep(bool);
      AppMethodBeat.o(35274);
      return;
    }
  }
  
  private void hPf()
  {
    AppMethodBeat.i(35275);
    u localu = (u)this.fgR.bC(u.class);
    if (localu.hPj() == null)
    {
      AppMethodBeat.o(35275);
      return;
    }
    localu.hPj().hlJ();
    AppMethodBeat.o(35275);
  }
  
  public final void bp(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(268127);
    u localu = (u)this.fgR.bC(u.class);
    localu.hPj().be(paramString1, paramString2, paramString3);
    paramString1 = localu.hPj().getLastText();
    int j = localu.hPj().getInsertPos();
    int i = j;
    if (j > paramString1.length()) {
      i = paramString1.length();
    }
    paramString1 = paramString1.substring(0, i) + paramString3 + ' ' + paramString1.substring(i);
    j = paramString3.length();
    localu.hPj().setLastContent(paramString1);
    localu.hPj().D(paramString1, i + j + 1, false);
    hPf();
    AppMethodBeat.o(268127);
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(35271);
    Log.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark reset keybord state");
    this.WJm = s.a.WJn;
    if (this.fgR.NKq != null)
    {
      Object localObject = (d)this.fgR.bC(d.class);
      if (((d)localObject).hOe())
      {
        localObject = af.bjy().Gt(((d)localObject).hOs()).field_editingMsg;
        this.WJi = ((String)localObject);
        this.WJj = ((String)localObject);
        AppMethodBeat.o(35271);
        return;
      }
      if (((com.tencent.mm.ui.chatting.d.b.h)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.h.class)).hOK())
      {
        localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).aEB(this.fgR.getTalkerUserName());
        this.WJi = ((String)localObject);
        this.WJj = ((String)localObject);
        AppMethodBeat.o(35271);
        return;
      }
      if (((i)this.fgR.bC(i.class)).hOP())
      {
        localObject = ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.c.class)).aEB(this.fgR.getTalkerUserName());
        this.WJi = ((String)localObject);
        this.WJj = ((String)localObject);
        AppMethodBeat.o(35271);
        return;
      }
      bh.beI();
      localObject = com.tencent.mm.model.c.bbR().bwx(this.fgR.getTalkerUserName());
      if (localObject != null)
      {
        String str = ((bb)localObject).field_editingMsg;
        this.WJi = str;
        this.WJj = str;
        long l = ((bb)localObject).field_editingQuoteMsgId;
        this.WJk = l;
        this.WJl = l;
      }
    }
    AppMethodBeat.o(35271);
  }
  
  public final void hGW() {}
  
  public final void hGX() {}
  
  public final void hGY()
  {
    AppMethodBeat.i(35272);
    Object localObject = (u)this.fgR.bC(u.class);
    u localu;
    if (((u)localObject).hPj() != null)
    {
      if (((u)localObject).hPj().BSf)
      {
        this.WJm = s.a.WJo;
        Log.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: show");
        this.WJi = ((u)localObject).hPj().getLastText();
        this.WJk = ((u)localObject).hPj().getLastQuoteMsgId();
      }
    }
    else
    {
      localu = (u)this.fgR.bC(u.class);
      localObject = (d)this.fgR.bC(d.class);
      if (!((d)localObject).hOe()) {
        break label280;
      }
      localObject = af.bjy().Gt(((d)localObject).hOs());
      if ((localu.hPj() != null) && ((this.WJj == null) || (!localu.hPj().getLastText().trim().equals(this.WJj))))
      {
        this.WJj = localu.hPj().getLastText().trim();
        ((com.tencent.mm.ao.a.a)localObject).field_editingMsg = this.WJj;
        if (!Util.isNullOrNil(((com.tencent.mm.ao.a.a)localObject).field_editingMsg)) {
          break label273;
        }
      }
    }
    label273:
    for (long l = ((com.tencent.mm.ao.a.a)localObject).field_lastMsgTime;; l = System.currentTimeMillis())
    {
      ((com.tencent.mm.ao.a.a)localObject).field_flag = com.tencent.mm.ao.a.b.a((com.tencent.mm.ao.a.a)localObject, 1, l);
      af.bjy().b((com.tencent.mm.ao.a.a)localObject);
      Log.v("MicroMsg.ChattingUI.SearchComponent", "set editMsg history");
      AppMethodBeat.o(35272);
      return;
      this.WJm = s.a.WJn;
      Log.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: hide");
      break;
    }
    label280:
    if (((com.tencent.mm.ui.chatting.d.b.h)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.h.class)).hOK())
    {
      if ((localu.hPj() != null) && ((this.WJj == null) || (!localu.hPj().getLastText().trim().equals(this.WJj))))
      {
        this.WJj = localu.hPj().getLastText().trim();
        ((n)com.tencent.mm.kernel.h.ae(n.class)).hk(this.fgR.getTalkerUserName(), this.WJj);
        AppMethodBeat.o(35272);
      }
    }
    else if (((i)this.fgR.bC(i.class)).hOP())
    {
      if ((localu.hPj() != null) && ((this.WJj == null) || (!localu.hPj().getLastText().trim().equals(this.WJj))))
      {
        this.WJj = localu.hPj().getLastText().trim();
        ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.c.class)).hk(this.fgR.getTalkerUserName(), this.WJj);
        AppMethodBeat.o(35272);
      }
    }
    else
    {
      localObject = null;
      if (com.tencent.mm.kernel.h.aHE().aGM())
      {
        bh.beI();
        localObject = com.tencent.mm.model.c.bbR().bwx(this.fgR.getTalkerUserName());
      }
      if ((localObject != null) || (localu.hPj() == null) || (Util.isNullOrNil(localu.hPj().getLastText().trim()))) {
        break label1026;
      }
      localObject = new az(this.fgR.NKq.field_username);
      ((az)localObject).EB(System.currentTimeMillis());
      if (((ae)this.fgR.bC(ae.class)).hQj()) {
        ((az)localObject).rn(4194304);
      }
      bh.beI();
      com.tencent.mm.model.c.bbR().e((az)localObject);
    }
    label1026:
    for (;;)
    {
      if ((localObject != null) && (localu.hPj() != null))
      {
        if ((this.WJj != null) && (localu.hPj().getLastText().trim().equals(this.WJj))) {
          break label1021;
        }
        this.WJj = localu.hPj().getLastText().trim();
        ((az)localObject).Jd(localu.hPj().getLastText().trim());
        if ("hidden_conv_parent".equalsIgnoreCase(((bb)localObject).field_parentRef))
        {
          ((az)localObject).Jc(null);
          com.tencent.mm.plugin.report.service.h.IzE.a(21170, new Object[] { Integer.valueOf(4), ((bb)localObject).field_username, Integer.valueOf(com.tencent.mm.model.ac.Rl(((bb)localObject).field_username)) });
        }
      }
      label1014:
      label1021:
      for (int i = 1;; i = 0)
      {
        if ((this.WJl == -1L) || (!Util.isEqual(localu.hPj().getLastQuoteMsgId(), this.WJl)))
        {
          this.WJl = localu.hPj().getLastQuoteMsgId();
          ((bb)localObject).field_editingQuoteMsgId = this.WJl;
          ((bb)localObject).hED = true;
          if ("hidden_conv_parent".equalsIgnoreCase(((bb)localObject).field_parentRef))
          {
            ((az)localObject).Jc(null);
            com.tencent.mm.plugin.report.service.h.IzE.a(21170, new Object[] { Integer.valueOf(4), ((bb)localObject).field_username, Integer.valueOf(com.tencent.mm.model.ac.Rl(((bb)localObject).field_username)) });
          }
          i = 1;
        }
        if (i != 0) {
          if ((!Util.isNullOrNil(((bb)localObject).field_editingMsg)) || (((bb)localObject).field_editingQuoteMsgId != 0L)) {
            break label1014;
          }
        }
        for (l = ((bb)localObject).field_conversationTime;; l = System.currentTimeMillis())
        {
          ((az)localObject).EC(com.tencent.mm.plugin.messenger.foundation.a.a.a.a((az)localObject, 1, l));
          bh.beI();
          com.tencent.mm.model.c.bbR().a((az)localObject, ((bb)localObject).field_username, false);
          Log.i("MicroMsg.ChattingUI.SearchComponent", "[doDestroy] set editMsg history! content:%s quoteMsgId:%s username:%s", new Object[] { Util.secPrint(this.WJj), Long.valueOf(this.WJl), this.fgR.getTalkerUserName() });
          AppMethodBeat.o(35272);
          return;
        }
      }
    }
  }
  
  public final void hGZ() {}
  
  public final void hPd()
  {
    AppMethodBeat.i(35273);
    if (Util.isNullOrNil(this.fgR.getTalkerUserName()))
    {
      AppMethodBeat.o(35273);
      return;
    }
    u localu = (u)this.fgR.bC(u.class);
    if (localu.hPj() != null)
    {
      if ((!Util.isNullOrNil(this.WJi)) || (this.WJk != 0L))
      {
        int i;
        boolean bool1;
        if ((localu.hPj().getMode() == 1) && (Util.isNullOrNil(localu.hPm())))
        {
          i = 1;
          bool1 = ((an)this.fgR.bC(an.class)).hQy();
          if ((i == 0) || (bool1)) {
            break label379;
          }
          hPf();
          label129:
          if (this.WJk != 0L) {
            localu.hPj().setLastQuoteMsgId(this.WJk);
          }
          boolean bool2 = ((d)this.fgR.bC(d.class)).hOf();
          if (((!this.fgR.hRh()) && (!bool2)) || (!this.WJh)) {
            break label386;
          }
          this.WJh = false;
          String str1 = localu.hPj().getAtSomebody();
          if (!Util.isNullOrNil(str1))
          {
            int j = localu.hPj().getInsertPos();
            i = j;
            if (j > this.WJi.length()) {
              i = this.WJi.length();
            }
            Object localObject = new StringBuilder().append(this.WJi.substring(0, i)).append(str1).append(' ');
            String str2 = this.WJi;
            localObject = str2.substring(i, str2.length());
            j = str1.length();
            localu.hPj().setLastContent((String)localObject);
            localu.hPj().D((String)localObject, i + j + 1, false);
            localu.hPj().setAtSomebody(null);
            hPf();
          }
        }
        for (;;)
        {
          localu.hPp();
          AppMethodBeat.o(35273);
          return;
          i = 0;
          break;
          label379:
          hPe();
          break label129;
          label386:
          localu.hPj().setLastContent(this.WJi);
          localu.hPj().setLastText(this.WJi);
          if (((!Util.isNullOrNil(this.WJi)) || (this.WJk != 0L)) && (!bool1) && (Util.isNullOrNil(localu.hPm()))) {
            localu.hPt();
          }
        }
      }
      if (((com.tencent.mm.ui.chatting.d.b.ac)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.ac.class)).hQe())
      {
        localu.hPj().setLastText(this.WJi);
        localu.hPj().setHint(this.fgR.WQv.getMMResources().getString(R.l.exn));
        localu.hPj().setLastQuoteMsgId(this.WJk);
        AppMethodBeat.o(35273);
        return;
      }
      if (localu.hPj().getIsVoiceInputPanleShow())
      {
        localu.hPp();
        AppMethodBeat.o(35273);
        return;
      }
      hPe();
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
        u localu = (u)this.fgR.bC(u.class);
        String str = paramIntent.getStringExtra("select_raw_user_name");
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        if (Util.isNullOrNil(paramIntent))
        {
          Log.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", new Object[] { "[nobody]" });
          localu.hPj().setAtSomebody("");
          this.WJh = false;
          AppMethodBeat.o(35268);
          return;
        }
        Log.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", new Object[] { paramIntent });
        localu.hPj().setAtSomebody(paramIntent);
        localu.hPj().be(this.fgR.getTalkerUserName(), str, paramIntent);
        this.WJh = true;
      }
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(35270);
    paramConfiguration = (u)this.fgR.bC(u.class);
    this.WJi = paramConfiguration.hPj().getLastText();
    this.WJk = paramConfiguration.hPj().getLastQuoteMsgId();
    hPd();
    AppMethodBeat.o(35270);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35269);
    Object localObject;
    int i;
    if (paramKeyEvent.getKeyCode() == 67)
    {
      localObject = (u)this.fgR.bC(u.class);
      if (paramKeyEvent.getAction() == 0)
      {
        if (((u)localObject).hPj().getCharAtCursor() != ' ') {
          break label130;
        }
        this.Cyu = true;
      }
      if ((paramKeyEvent.getAction() == 1) && (this.Cyu))
      {
        this.Cyu = false;
        paramKeyEvent = ((u)localObject).hPj();
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
      this.Cyu = false;
      break;
      label138:
      localObject = ((String)localObject).substring(0, i);
      String str = paramKeyEvent.getLastText().substring(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject).append(str);
      paramKeyEvent.setLastText(localStringBuilder.toString());
      paramKeyEvent.KQB.setSelection(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.s
 * JD-Core Version:    0.7.0.1
 */