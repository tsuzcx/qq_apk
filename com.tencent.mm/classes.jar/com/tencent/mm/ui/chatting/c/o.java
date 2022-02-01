package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.b;
import com.tencent.mm.am.af;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.c.b.ae;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.q;
import com.tencent.mm.ui.chatting.c.b.y;
import com.tencent.mm.ui.widget.MMEditText;

@com.tencent.mm.ui.chatting.c.a.a(eYT=aj.class)
public class o
  extends a
  implements aj
{
  private boolean Gua = false;
  private boolean Gub = false;
  private String Guc;
  private String Gud;
  private long Gue;
  private long Guf = -1L;
  private o.a Gug = o.a.Guh;
  
  private void eXo()
  {
    AppMethodBeat.i(35274);
    q localq = (q)this.cOd.be(q.class);
    if (localq.eXs() == null)
    {
      AppMethodBeat.o(35274);
      return;
    }
    if (this.Gug == o.a.Gui) {}
    for (boolean bool = true;; bool = false)
    {
      localq.eXs().up(bool);
      AppMethodBeat.o(35274);
      return;
    }
  }
  
  private void eXp()
  {
    AppMethodBeat.i(35275);
    q localq = (q)this.cOd.be(q.class);
    if (localq.eXs() == null)
    {
      AppMethodBeat.o(35275);
      return;
    }
    localq.eXs().ezr();
    AppMethodBeat.o(35275);
  }
  
  public final void eQB()
  {
    AppMethodBeat.i(35271);
    ad.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark reset keybord state");
    this.Gug = o.a.Guh;
    if (this.cOd.zgX != null)
    {
      Object localObject = (d)this.cOd.be(d.class);
      if (((d)localObject).eWC())
      {
        localObject = af.awh().mf(((d)localObject).eWP()).field_editingMsg;
        this.Guc = ((String)localObject);
        this.Gud = ((String)localObject);
        AppMethodBeat.o(35271);
        return;
      }
      az.arV();
      localObject = c.apR().aIn(this.cOd.getTalkerUserName());
      if (localObject != null)
      {
        String str = ((ay)localObject).field_editingMsg;
        this.Guc = str;
        this.Gud = str;
        long l = ((ay)localObject).field_editingQuoteMsgId;
        this.Gue = l;
        this.Guf = l;
      }
    }
    AppMethodBeat.o(35271);
  }
  
  public final void eQC() {}
  
  public final void eQD() {}
  
  public final void eQE()
  {
    AppMethodBeat.i(35272);
    Object localObject = (q)this.cOd.be(q.class);
    q localq;
    if (((q)localObject).eXs() != null)
    {
      if (((q)localObject).eXs().srJ)
      {
        this.Gug = o.a.Gui;
        ad.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: show");
        this.Guc = ((q)localObject).eXs().getLastText();
        this.Gue = ((q)localObject).eXs().getLastQuoteMsgId();
      }
    }
    else
    {
      localq = (q)this.cOd.be(q.class);
      localObject = (d)this.cOd.be(d.class);
      if (!((d)localObject).eWC()) {
        break label278;
      }
      localObject = af.awh().mf(((d)localObject).eWP());
      if ((localq.eXs() != null) && ((this.Gud == null) || (!localq.eXs().getLastText().trim().equals(this.Gud))))
      {
        this.Gud = localq.eXs().getLastText().trim();
        ((com.tencent.mm.am.a.a)localObject).field_editingMsg = this.Gud;
        if (!bt.isNullOrNil(((com.tencent.mm.am.a.a)localObject).field_editingMsg)) {
          break label271;
        }
      }
    }
    label271:
    for (long l = ((com.tencent.mm.am.a.a)localObject).field_lastMsgTime;; l = System.currentTimeMillis())
    {
      ((com.tencent.mm.am.a.a)localObject).field_flag = b.a((com.tencent.mm.am.a.a)localObject, 1, l);
      af.awh().b((com.tencent.mm.am.a.a)localObject);
      ad.v("MicroMsg.ChattingUI.SearchComponent", "set editMsg history");
      AppMethodBeat.o(35272);
      return;
      this.Gug = o.a.Guh;
      ad.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: hide");
      break;
    }
    label278:
    localObject = null;
    if (g.afz().aeI())
    {
      az.arV();
      localObject = c.apR().aIn(this.cOd.getTalkerUserName());
    }
    if ((localObject == null) && (localq.eXs() != null) && (!bt.isNullOrNil(localq.eXs().getLastText().trim())))
    {
      localObject = new am(this.cOd.zgX.field_username);
      ((am)localObject).kS(System.currentTimeMillis());
      if (((aa)this.cOd.be(aa.class)).eYp()) {
        ((am)localObject).lu(4194304);
      }
      az.arV();
      c.apR().e((am)localObject);
    }
    for (;;)
    {
      if ((localObject != null) && (localq.eXs() != null))
      {
        if ((this.Gud != null) && (localq.eXs().getLastText().trim().equals(this.Gud))) {
          break label677;
        }
        this.Gud = localq.eXs().getLastText().trim();
        ((am)localObject).nO(localq.eXs().getLastText().trim());
      }
      label670:
      label677:
      for (int i = 1;; i = 0)
      {
        if ((this.Guf == -1L) || (!bt.aw(localq.eXs().getLastQuoteMsgId(), this.Guf)))
        {
          this.Guf = localq.eXs().getLastQuoteMsgId();
          ((ay)localObject).field_editingQuoteMsgId = this.Guf;
          ((ay)localObject).ewz = true;
          i = 1;
        }
        if (i != 0) {
          if ((!bt.isNullOrNil(((ay)localObject).field_editingMsg)) || (((ay)localObject).field_editingQuoteMsgId != 0L)) {
            break label670;
          }
        }
        for (l = ((ay)localObject).field_conversationTime;; l = System.currentTimeMillis())
        {
          ((am)localObject).kT(com.tencent.mm.plugin.messenger.foundation.a.a.a.a((am)localObject, 1, l));
          az.arV();
          c.apR().a((am)localObject, ((ay)localObject).field_username, false);
          ad.i("MicroMsg.ChattingUI.SearchComponent", "[doDestroy] set editMsg history! content:%s quoteMsgId:%s username:%s", new Object[] { bt.aGs(this.Gud), Long.valueOf(this.Guf), this.cOd.getTalkerUserName() });
          AppMethodBeat.o(35272);
          return;
        }
      }
    }
  }
  
  public final void eQF() {}
  
  public final void eXn()
  {
    AppMethodBeat.i(35273);
    if (bt.isNullOrNil(this.cOd.getTalkerUserName()))
    {
      AppMethodBeat.o(35273);
      return;
    }
    q localq = (q)this.cOd.be(q.class);
    if (localq.eXs() != null)
    {
      if ((!bt.isNullOrNil(this.Guc)) || (this.Gue != 0L))
      {
        int i;
        boolean bool1;
        if ((localq.eXs().getMode() == 1) && (bt.isNullOrNil(localq.eXv())))
        {
          i = 1;
          bool1 = ((ae)this.cOd.be(ae.class)).eYy();
          if ((i == 0) || (bool1)) {
            break label379;
          }
          eXp();
          label129:
          if (this.Gue != 0L) {
            localq.eXs().setLastQuoteMsgId(this.Gue);
          }
          boolean bool2 = ((d)this.cOd.be(d.class)).eWD();
          if (((!this.cOd.eZa()) && (!bool2)) || (!this.Gua)) {
            break label386;
          }
          this.Gua = false;
          String str1 = localq.eXs().getAtSomebody();
          if (!bt.isNullOrNil(str1))
          {
            int j = localq.eXs().getInsertPos();
            i = j;
            if (j > this.Guc.length()) {
              i = this.Guc.length();
            }
            Object localObject = new StringBuilder().append(this.Guc.substring(0, i)).append(str1).append(' ');
            String str2 = this.Guc;
            localObject = str2.substring(i, str2.length());
            j = str1.length();
            localq.eXs().setLastContent((String)localObject);
            localq.eXs().w((String)localObject, i + j + 1, false);
            localq.eXs().setAtSomebody(null);
            eXp();
          }
        }
        for (;;)
        {
          localq.eXy();
          AppMethodBeat.o(35273);
          return;
          i = 0;
          break;
          label379:
          eXo();
          break label129;
          label386:
          localq.eXs().setLastContent(this.Guc);
          localq.eXs().setLastText(this.Guc);
          if (((!bt.isNullOrNil(this.Guc)) || (this.Gue != 0L)) && (!bool1) && (bt.isNullOrNil(localq.eXv()))) {
            localq.eXC();
          }
        }
      }
      if (((y)this.cOd.be(y.class)).eYj())
      {
        localq.eXs().setLastText(this.Guc);
        localq.eXs().setHint(this.cOd.GzJ.getMMResources().getString(2131757331));
        localq.eXs().setLastQuoteMsgId(this.Gue);
        AppMethodBeat.o(35273);
        return;
      }
      if (localq.eXs().getIsVoiceInputPanleShow())
      {
        localq.eXy();
        AppMethodBeat.o(35273);
        return;
      }
      eXo();
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
        q localq = (q)this.cOd.be(q.class);
        String str = paramIntent.getStringExtra("select_raw_user_name");
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        if (bt.isNullOrNil(paramIntent))
        {
          ad.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", new Object[] { "[nobody]" });
          localq.eXs().setAtSomebody("");
          this.Gua = false;
          AppMethodBeat.o(35268);
          return;
        }
        ad.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", new Object[] { paramIntent });
        localq.eXs().setAtSomebody(paramIntent);
        localq.eXs().aN(this.cOd.getTalkerUserName(), str, paramIntent);
        this.Gua = true;
      }
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(35270);
    paramConfiguration = (q)this.cOd.be(q.class);
    this.Guc = paramConfiguration.eXs().getLastText();
    this.Gue = paramConfiguration.eXs().getLastQuoteMsgId();
    eXn();
    AppMethodBeat.o(35270);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35269);
    Object localObject;
    int i;
    if (paramKeyEvent.getKeyCode() == 67)
    {
      localObject = (q)this.cOd.be(q.class);
      if (paramKeyEvent.getAction() == 0)
      {
        if (((q)localObject).eXs().getCharAtCursor() != ' ') {
          break label130;
        }
        this.Gub = true;
      }
      if ((paramKeyEvent.getAction() == 1) && (this.Gub))
      {
        this.Gub = false;
        paramKeyEvent = ((q)localObject).eXs();
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
      this.Gub = false;
      break;
      label138:
      localObject = ((String)localObject).substring(0, i);
      String str = paramKeyEvent.getLastText().substring(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject).append(str);
      paramKeyEvent.setLastText(localStringBuilder.toString());
      paramKeyEvent.tqv.setSelection(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.o
 * JD-Core Version:    0.7.0.1
 */