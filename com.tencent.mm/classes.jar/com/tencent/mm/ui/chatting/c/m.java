package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ae;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.c.b.t;
import com.tencent.mm.ui.chatting.c.b.v;
import com.tencent.mm.ui.widget.MMEditText;

@com.tencent.mm.ui.chatting.c.a.a(dJy=ae.class)
public class m
  extends a
  implements ae
{
  private boolean zFu = false;
  private boolean zFv = false;
  private String zFw;
  private String zFx;
  private m.a zFy = m.a.zFz;
  
  private void dIc()
  {
    AppMethodBeat.i(31384);
    o localo = (o)this.caz.ay(o.class);
    if (localo.dIg() == null)
    {
      AppMethodBeat.o(31384);
      return;
    }
    if (this.zFy == m.a.zFA) {}
    for (boolean bool = true;; bool = false)
    {
      localo.dIg().ps(bool);
      AppMethodBeat.o(31384);
      return;
    }
  }
  
  private void dId()
  {
    AppMethodBeat.i(31385);
    o localo = (o)this.caz.ay(o.class);
    if (localo.dIg() == null)
    {
      AppMethodBeat.o(31385);
      return;
    }
    localo.dIg().doC();
    AppMethodBeat.o(31385);
  }
  
  public final void dBZ()
  {
    AppMethodBeat.i(31381);
    ab.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark reset keybord state");
    this.zFy = m.a.zFz;
    if (this.caz.txj != null)
    {
      Object localObject = (d)this.caz.ay(d.class);
      if (((d)localObject).dHv())
      {
        localObject = com.tencent.mm.aj.z.afl().gF(((d)localObject).dHI()).field_editingMsg;
        this.zFw = ((String)localObject);
        this.zFx = ((String)localObject);
        AppMethodBeat.o(31381);
        return;
      }
      aw.aaz();
      localObject = c.YF().arH(this.caz.getTalkerUserName());
      if (localObject != null)
      {
        localObject = ((au)localObject).field_editingMsg;
        this.zFw = ((String)localObject);
        this.zFx = ((String)localObject);
      }
    }
    AppMethodBeat.o(31381);
  }
  
  public final void dCa() {}
  
  public final void dCb() {}
  
  public final void dCc()
  {
    AppMethodBeat.i(31382);
    Object localObject = (o)this.caz.ay(o.class);
    o localo;
    if (((o)localObject).dIg() != null)
    {
      if (((o)localObject).dIg().vWC)
      {
        this.zFy = m.a.zFA;
        ab.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: show");
        this.zFw = ((o)localObject).dIg().getLastText();
      }
    }
    else
    {
      localo = (o)this.caz.ay(o.class);
      localObject = (d)this.caz.ay(d.class);
      if (!((d)localObject).dHv()) {
        break label252;
      }
      localObject = com.tencent.mm.aj.z.afl().gF(((d)localObject).dHI());
      if ((localo.dIg() != null) && ((this.zFx == null) || (!localo.dIg().getLastText().trim().equals(this.zFx))))
      {
        this.zFx = localo.dIg().getLastText().trim();
        ((com.tencent.mm.aj.a.a)localObject).field_editingMsg = this.zFx;
        if (!bo.isNullOrNil(((com.tencent.mm.aj.a.a)localObject).field_editingMsg)) {
          break label245;
        }
      }
    }
    label245:
    for (long l = ((com.tencent.mm.aj.a.a)localObject).field_lastMsgTime;; l = System.currentTimeMillis())
    {
      ((com.tencent.mm.aj.a.a)localObject).field_flag = b.a((com.tencent.mm.aj.a.a)localObject, 1, l);
      com.tencent.mm.aj.z.afl().b((com.tencent.mm.aj.a.a)localObject);
      ab.v("MicroMsg.ChattingUI.SearchComponent", "set editMsg history");
      AppMethodBeat.o(31382);
      return;
      this.zFy = m.a.zFz;
      ab.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: hide");
      break;
    }
    label252:
    localObject = null;
    if (g.RJ().QU())
    {
      aw.aaz();
      localObject = c.YF().arH(this.caz.getTalkerUserName());
    }
    if ((localObject == null) && (localo.dIg() != null) && (!bo.isNullOrNil(localo.dIg().getLastText().trim())))
    {
      localObject = new ak(this.caz.txj.field_username);
      ((ak)localObject).fK(System.currentTimeMillis());
      if (((v)this.caz.ay(v.class)).dIU()) {
        ((ak)localObject).jg(4194304);
      }
      aw.aaz();
      c.YF().d((ak)localObject);
    }
    for (;;)
    {
      if ((localObject != null) && (localo.dIg() != null) && ((this.zFx == null) || (!localo.dIg().getLastText().trim().equals(this.zFx))))
      {
        this.zFx = localo.dIg().getLastText().trim();
        ((ak)localObject).jZ(localo.dIg().getLastText().trim());
        if (!bo.isNullOrNil(((au)localObject).field_editingMsg)) {
          break label541;
        }
      }
      label541:
      for (l = ((au)localObject).field_conversationTime;; l = System.currentTimeMillis())
      {
        ((ak)localObject).fL(com.tencent.mm.plugin.messenger.foundation.a.a.a.a((ak)localObject, 1, l));
        aw.aaz();
        c.YF().a((ak)localObject, ((au)localObject).field_username, false);
        ab.i("MicroMsg.ChattingUI.SearchComponent", "[doDestroy] set editMsg history! content:%s username:%s", new Object[] { bo.aqg(this.zFx), this.caz.getTalkerUserName() });
        AppMethodBeat.o(31382);
        return;
      }
    }
  }
  
  public final void dCd() {}
  
  public final void dIb()
  {
    AppMethodBeat.i(31383);
    if (bo.isNullOrNil(this.caz.getTalkerUserName()))
    {
      AppMethodBeat.o(31383);
      return;
    }
    o localo = (o)this.caz.ay(o.class);
    if ((!bo.isNullOrNil(this.zFw)) && (localo.dIg() != null))
    {
      int i;
      boolean bool1;
      if ((localo.dIg().getMode() == 1) && (bo.isNullOrNil(localo.dIj())))
      {
        i = 1;
        bool1 = ((com.tencent.mm.ui.chatting.c.b.z)this.caz.ay(com.tencent.mm.ui.chatting.c.b.z.class)).dJd();
        if ((i == 0) || (bool1)) {
          break label350;
        }
        dId();
        label120:
        boolean bool2 = ((d)this.caz.ay(d.class)).dHw();
        if (((!this.caz.dJF()) && (!bool2)) || (!this.zFu)) {
          break label357;
        }
        this.zFu = false;
        String str1 = localo.dIg().getAtSomebody();
        if (!bo.isNullOrNil(str1))
        {
          int j = localo.dIg().getInsertPos();
          i = j;
          if (j > this.zFw.length()) {
            i = this.zFw.length();
          }
          Object localObject = new StringBuilder().append(this.zFw.substring(0, i)).append(str1).append(' ');
          String str2 = this.zFw;
          localObject = str2.substring(i, str2.length());
          j = str1.length();
          localo.dIg().setLastContent((String)localObject);
          localo.dIg().u((String)localObject, i + j + 1, false);
          localo.dIg().setAtSomebody(null);
          this.caz.showVKB();
        }
      }
      for (;;)
      {
        localo.dIm();
        AppMethodBeat.o(31383);
        return;
        i = 0;
        break;
        label350:
        dIc();
        break label120;
        label357:
        localo.dIg().setLastContent(this.zFw);
        localo.dIg().setLastText(this.zFw);
        if ((!bo.isNullOrNil(this.zFw)) && (!bool1) && (bo.isNullOrNil(localo.dIj()))) {
          localo.dIq();
        }
      }
    }
    if (localo.dIg() != null)
    {
      if (((t)this.caz.ay(t.class)).dIO())
      {
        localo.dIg().setLastText(this.zFw);
        localo.dIg().setHint(this.caz.zJz.getMMResources().getString(2131298340));
        AppMethodBeat.o(31383);
        return;
      }
      if (localo.dIg().getIsVoiceInputPanleShow())
      {
        localo.dIm();
        AppMethodBeat.o(31383);
        return;
      }
      dIc();
    }
    AppMethodBeat.o(31383);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(31378);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31378);
      return;
      if (paramIntent != null)
      {
        o localo = (o)this.caz.ay(o.class);
        String str = paramIntent.getStringExtra("select_raw_user_name");
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        if (bo.isNullOrNil(paramIntent))
        {
          ab.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", new Object[] { "[nobody]" });
          localo.dIg().setAtSomebody("");
          this.zFu = false;
          AppMethodBeat.o(31378);
          return;
        }
        ab.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", new Object[] { paramIntent });
        localo.dIg().setAtSomebody(paramIntent);
        localo.dIg().aA(this.caz.getTalkerUserName(), str, paramIntent);
        this.zFu = true;
      }
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(31380);
    this.zFw = ((o)this.caz.ay(o.class)).dIg().getLastText();
    dIb();
    AppMethodBeat.o(31380);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(31379);
    Object localObject;
    int i;
    if (paramKeyEvent.getKeyCode() == 67)
    {
      localObject = (o)this.caz.ay(o.class);
      if (paramKeyEvent.getAction() == 0)
      {
        if (((o)localObject).dIg().getCharAtCursor() != ' ') {
          break label130;
        }
        this.zFv = true;
      }
      if ((paramKeyEvent.getAction() == 1) && (this.zFv))
      {
        this.zFv = false;
        paramKeyEvent = ((o)localObject).dIg();
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
      AppMethodBeat.o(31379);
      return false;
      label130:
      this.zFv = false;
      break;
      label138:
      localObject = ((String)localObject).substring(0, i);
      String str = paramKeyEvent.getLastText().substring(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject).append(str);
      paramKeyEvent.setLastText(localStringBuilder.toString());
      paramKeyEvent.oxm.setSelection(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.m
 * JD-Core Version:    0.7.0.1
 */