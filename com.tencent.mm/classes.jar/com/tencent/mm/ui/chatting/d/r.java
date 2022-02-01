package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.i.a.n;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.ar;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.i;
import com.tencent.mm.ui.chatting.d.b.u;

@com.tencent.mm.ui.chatting.d.a.a(gRF=ar.class)
public class r
  extends a
  implements ar
{
  private boolean PoQ = false;
  private boolean PoR = false;
  private String PoS;
  private String PoT;
  private long PoU;
  private long PoV = -1L;
  private r.a PoW = r.a.PoX;
  
  private void gPK()
  {
    AppMethodBeat.i(35274);
    u localu = (u)this.dom.bh(u.class);
    if (localu.gPO() == null)
    {
      AppMethodBeat.o(35274);
      return;
    }
    if (this.PoW == r.a.PoY) {}
    for (boolean bool = true;; bool = false)
    {
      localu.gPO().Aj(bool);
      AppMethodBeat.o(35274);
      return;
    }
  }
  
  private void gPL()
  {
    AppMethodBeat.i(35275);
    u localu = (u)this.dom.bh(u.class);
    if (localu.gPO() == null)
    {
      AppMethodBeat.o(35275);
      return;
    }
    localu.gPO().gqK();
    AppMethodBeat.o(35275);
  }
  
  public final void cFx() {}
  
  public final void cFy()
  {
    AppMethodBeat.i(35272);
    Object localObject = (u)this.dom.bh(u.class);
    u localu;
    if (((u)localObject).gPO() != null)
    {
      if (((u)localObject).gPO().xfU)
      {
        this.PoW = r.a.PoY;
        Log.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: show");
        this.PoS = ((u)localObject).gPO().getLastText();
        this.PoU = ((u)localObject).gPO().getLastQuoteMsgId();
      }
    }
    else
    {
      localu = (u)this.dom.bh(u.class);
      localObject = (d)this.dom.bh(d.class);
      if (!((d)localObject).gOP()) {
        break label278;
      }
      localObject = ag.bak().Al(((d)localObject).gPc());
      if ((localu.gPO() != null) && ((this.PoT == null) || (!localu.gPO().getLastText().trim().equals(this.PoT))))
      {
        this.PoT = localu.gPO().getLastText().trim();
        ((com.tencent.mm.al.a.a)localObject).field_editingMsg = this.PoT;
        if (!Util.isNullOrNil(((com.tencent.mm.al.a.a)localObject).field_editingMsg)) {
          break label271;
        }
      }
    }
    label271:
    for (long l = ((com.tencent.mm.al.a.a)localObject).field_lastMsgTime;; l = System.currentTimeMillis())
    {
      ((com.tencent.mm.al.a.a)localObject).field_flag = b.a((com.tencent.mm.al.a.a)localObject, 1, l);
      ag.bak().b((com.tencent.mm.al.a.a)localObject);
      Log.v("MicroMsg.ChattingUI.SearchComponent", "set editMsg history");
      AppMethodBeat.o(35272);
      return;
      this.PoW = r.a.PoX;
      Log.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: hide");
      break;
    }
    label278:
    if (((com.tencent.mm.ui.chatting.d.b.h)this.dom.bh(com.tencent.mm.ui.chatting.d.b.h.class)).gPu())
    {
      if ((localu.gPO() != null) && ((this.PoT == null) || (!localu.gPO().getLastText().trim().equals(this.PoT))))
      {
        this.PoT = localu.gPO().getLastText().trim();
        ((n)g.af(n.class)).gT(this.dom.getTalkerUserName(), this.PoT);
        AppMethodBeat.o(35272);
      }
    }
    else if (((i)this.dom.bh(i.class)).gPw())
    {
      if ((localu.gPO() != null) && ((this.PoT == null) || (!localu.gPO().getLastText().trim().equals(this.PoT))))
      {
        this.PoT = localu.gPO().getLastText().trim();
        ((com.tencent.mm.plugin.gamelife.a.c)g.af(com.tencent.mm.plugin.gamelife.a.c.class)).gT(this.dom.getTalkerUserName(), this.PoT);
        AppMethodBeat.o(35272);
      }
    }
    else
    {
      localObject = null;
      if (g.aAf().azp())
      {
        bg.aVF();
        localObject = com.tencent.mm.model.c.aST().bjY(this.dom.getTalkerUserName());
      }
      if ((localObject != null) || (localu.gPO() == null) || (Util.isNullOrNil(localu.gPO().getLastText().trim()))) {
        break label1023;
      }
      localObject = new az(this.dom.GUe.field_username);
      ((az)localObject).yA(System.currentTimeMillis());
      if (((ae)this.dom.bh(ae.class)).gQM()) {
        ((az)localObject).oT(4194304);
      }
      bg.aVF();
      com.tencent.mm.model.c.aST().e((az)localObject);
    }
    label1011:
    label1018:
    label1023:
    for (;;)
    {
      if ((localObject != null) && (localu.gPO() != null))
      {
        if ((this.PoT != null) && (localu.gPO().getLastText().trim().equals(this.PoT))) {
          break label1018;
        }
        this.PoT = localu.gPO().getLastText().trim();
        ((az)localObject).Cp(localu.gPO().getLastText().trim());
        if ("hidden_conv_parent".equalsIgnoreCase(((bb)localObject).field_parentRef))
        {
          ((az)localObject).Co(null);
          com.tencent.mm.plugin.report.service.h.CyF.a(21170, new Object[] { Integer.valueOf(4), ((bb)localObject).field_username, Integer.valueOf(com.tencent.mm.model.ac.JT(((bb)localObject).field_username)) });
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((this.PoV == -1L) || (!Util.isEqual(localu.gPO().getLastQuoteMsgId(), this.PoV)))
        {
          this.PoV = localu.gPO().getLastQuoteMsgId();
          ((bb)localObject).field_editingQuoteMsgId = this.PoV;
          ((bb)localObject).fvI = true;
          if ("hidden_conv_parent".equalsIgnoreCase(((bb)localObject).field_parentRef))
          {
            ((az)localObject).Co(null);
            com.tencent.mm.plugin.report.service.h.CyF.a(21170, new Object[] { Integer.valueOf(4), ((bb)localObject).field_username, Integer.valueOf(com.tencent.mm.model.ac.JT(((bb)localObject).field_username)) });
          }
          i = 1;
        }
        if (i != 0) {
          if ((!Util.isNullOrNil(((bb)localObject).field_editingMsg)) || (((bb)localObject).field_editingQuoteMsgId != 0L)) {
            break label1011;
          }
        }
        for (l = ((bb)localObject).field_conversationTime;; l = System.currentTimeMillis())
        {
          ((az)localObject).yB(com.tencent.mm.plugin.messenger.foundation.a.a.a.a((az)localObject, 1, l));
          bg.aVF();
          com.tencent.mm.model.c.aST().a((az)localObject, ((bb)localObject).field_username, false);
          Log.i("MicroMsg.ChattingUI.SearchComponent", "[doDestroy] set editMsg history! content:%s quoteMsgId:%s username:%s", new Object[] { Util.secPrint(this.PoT), Long.valueOf(this.PoV), this.dom.getTalkerUserName() });
          AppMethodBeat.o(35272);
          return;
        }
      }
    }
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(35271);
    Log.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark reset keybord state");
    this.PoW = r.a.PoX;
    if (this.dom.GUe != null)
    {
      Object localObject = (d)this.dom.bh(d.class);
      if (((d)localObject).gOP())
      {
        localObject = ag.bak().Al(((d)localObject).gPc()).field_editingMsg;
        this.PoS = ((String)localObject);
        this.PoT = ((String)localObject);
        AppMethodBeat.o(35271);
        return;
      }
      if (((com.tencent.mm.ui.chatting.d.b.h)this.dom.bh(com.tencent.mm.ui.chatting.d.b.h.class)).gPu())
      {
        localObject = ((n)g.af(n.class)).avh(this.dom.getTalkerUserName());
        this.PoS = ((String)localObject);
        this.PoT = ((String)localObject);
        AppMethodBeat.o(35271);
        return;
      }
      if (((i)this.dom.bh(i.class)).gPw())
      {
        localObject = ((com.tencent.mm.plugin.gamelife.a.c)g.af(com.tencent.mm.plugin.gamelife.a.c.class)).avh(this.dom.getTalkerUserName());
        this.PoS = ((String)localObject);
        this.PoT = ((String)localObject);
        AppMethodBeat.o(35271);
        return;
      }
      bg.aVF();
      localObject = com.tencent.mm.model.c.aST().bjY(this.dom.getTalkerUserName());
      if (localObject != null)
      {
        String str = ((bb)localObject).field_editingMsg;
        this.PoS = str;
        this.PoT = str;
        long l = ((bb)localObject).field_editingQuoteMsgId;
        this.PoU = l;
        this.PoV = l;
      }
    }
    AppMethodBeat.o(35271);
  }
  
  public final void gIm() {}
  
  public final void gIn() {}
  
  public final void gPJ()
  {
    AppMethodBeat.i(35273);
    if (Util.isNullOrNil(this.dom.getTalkerUserName()))
    {
      AppMethodBeat.o(35273);
      return;
    }
    u localu = (u)this.dom.bh(u.class);
    if (localu.gPO() != null)
    {
      if ((!Util.isNullOrNil(this.PoS)) || (this.PoU != 0L))
      {
        int i;
        boolean bool1;
        if ((localu.gPO().getMode() == 1) && (Util.isNullOrNil(localu.gPR())))
        {
          i = 1;
          bool1 = ((am)this.dom.bh(am.class)).gRb();
          if ((i == 0) || (bool1)) {
            break label379;
          }
          gPL();
          label129:
          if (this.PoU != 0L) {
            localu.gPO().setLastQuoteMsgId(this.PoU);
          }
          boolean bool2 = ((d)this.dom.bh(d.class)).gOQ();
          if (((!this.dom.gRL()) && (!bool2)) || (!this.PoQ)) {
            break label386;
          }
          this.PoQ = false;
          String str1 = localu.gPO().getAtSomebody();
          if (!Util.isNullOrNil(str1))
          {
            int j = localu.gPO().getInsertPos();
            i = j;
            if (j > this.PoS.length()) {
              i = this.PoS.length();
            }
            Object localObject = new StringBuilder().append(this.PoS.substring(0, i)).append(str1).append(' ');
            String str2 = this.PoS;
            localObject = str2.substring(i, str2.length());
            j = str1.length();
            localu.gPO().setLastContent((String)localObject);
            localu.gPO().z((String)localObject, i + j + 1, false);
            localu.gPO().setAtSomebody(null);
            gPL();
          }
        }
        for (;;)
        {
          localu.gPU();
          AppMethodBeat.o(35273);
          return;
          i = 0;
          break;
          label379:
          gPK();
          break label129;
          label386:
          localu.gPO().setLastContent(this.PoS);
          localu.gPO().setLastText(this.PoS);
          if (((!Util.isNullOrNil(this.PoS)) || (this.PoU != 0L)) && (!bool1) && (Util.isNullOrNil(localu.gPR()))) {
            localu.gPY();
          }
        }
      }
      if (((com.tencent.mm.ui.chatting.d.b.ac)this.dom.bh(com.tencent.mm.ui.chatting.d.b.ac.class)).gQH())
      {
        localu.gPO().setLastText(this.PoS);
        localu.gPO().setHint(this.dom.Pwc.getMMResources().getString(2131757545));
        localu.gPO().setLastQuoteMsgId(this.PoU);
        AppMethodBeat.o(35273);
        return;
      }
      if (localu.gPO().getIsVoiceInputPanleShow())
      {
        localu.gPU();
        AppMethodBeat.o(35273);
        return;
      }
      gPK();
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
        u localu = (u)this.dom.bh(u.class);
        String str = paramIntent.getStringExtra("select_raw_user_name");
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        if (Util.isNullOrNil(paramIntent))
        {
          Log.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", new Object[] { "[nobody]" });
          localu.gPO().setAtSomebody("");
          this.PoQ = false;
          AppMethodBeat.o(35268);
          return;
        }
        Log.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", new Object[] { paramIntent });
        localu.gPO().setAtSomebody(paramIntent);
        localu.gPO().bj(this.dom.getTalkerUserName(), str, paramIntent);
        this.PoQ = true;
      }
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(35270);
    paramConfiguration = (u)this.dom.bh(u.class);
    this.PoS = paramConfiguration.gPO().getLastText();
    this.PoU = paramConfiguration.gPO().getLastQuoteMsgId();
    gPJ();
    AppMethodBeat.o(35270);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35269);
    Object localObject;
    int i;
    if (paramKeyEvent.getKeyCode() == 67)
    {
      localObject = (u)this.dom.bh(u.class);
      if (paramKeyEvent.getAction() == 0)
      {
        if (((u)localObject).gPO().getCharAtCursor() != ' ') {
          break label130;
        }
        this.PoR = true;
      }
      if ((paramKeyEvent.getAction() == 1) && (this.PoR))
      {
        this.PoR = false;
        paramKeyEvent = ((u)localObject).gPO();
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
      this.PoR = false;
      break;
      label138:
      localObject = ((String)localObject).substring(0, i);
      String str = paramKeyEvent.getLastText().substring(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject).append(str);
      paramKeyEvent.setLastText(localStringBuilder.toString());
      paramKeyEvent.ECK.setSelection(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.r
 * JD-Core Version:    0.7.0.1
 */