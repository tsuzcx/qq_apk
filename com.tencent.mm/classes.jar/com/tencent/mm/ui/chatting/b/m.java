package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.a.b;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.chatting.ag;
import com.tencent.mm.ui.chatting.b.b.ad;
import com.tencent.mm.ui.chatting.b.b.n;
import com.tencent.mm.ui.chatting.b.b.s;
import com.tencent.mm.ui.chatting.b.b.u;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.widget.MMEditText;

@com.tencent.mm.ui.chatting.b.a.a(cFA=ad.class)
public class m
  extends a
  implements ad
{
  private boolean vpO = false;
  private boolean vpP = false;
  private String vpQ;
  private String vpR;
  private m.a vpS = m.a.vpT;
  
  private void cEm()
  {
    Object localObject = (n)this.byx.ac(n.class);
    if (((n)localObject).cEq() == null) {
      return;
    }
    if (this.vpS == m.a.vpU) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = ((n)localObject).cEq();
      bk.hideVKB((View)localObject);
      ((ChatFooter)localObject).lZ(bool);
      return;
    }
  }
  
  public final void cEl()
  {
    if (bk.bl(this.byx.getTalkerUserName())) {}
    n localn;
    label125:
    do
    {
      return;
      localn = (n)this.byx.ac(n.class);
      if ((!bk.bl(this.vpQ)) && (localn.cEq() != null))
      {
        int i;
        if ((localn.cEq().getMode() == 1) && (bk.bl(localn.cEt())))
        {
          i = 1;
          if (i == 0) {
            break label357;
          }
          Object localObject = (n)this.byx.ac(n.class);
          if (((n)localObject).cEq() != null)
          {
            localObject = ((n)localObject).cEq();
            ((ChatFooter)localObject).showVKB();
            ((ChatFooter)localObject).lZ(true);
          }
          boolean bool = ((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDH();
          if (((!this.byx.cFD()) && (!bool)) || (!this.vpO)) {
            break label364;
          }
          this.vpO = false;
          localObject = localn.cEq().getAtSomebody();
          if (!bk.bl((String)localObject))
          {
            int j = localn.cEq().getInsertPos();
            i = j;
            if (j > this.vpQ.length()) {
              i = this.vpQ.length();
            }
            String str = this.vpQ.substring(0, i) + (String)localObject + ' ' + this.vpQ.substring(i, this.vpQ.length());
            j = ((String)localObject).length();
            localn.cEq().setLastContent(str);
            localn.cEq().r(str, i + j + 1, false);
            localn.cEq().setAtSomebody(null);
            localObject = this.byx;
            y.i("MicroMsg.ChattingContext", "[showVKB]");
            ((com.tencent.mm.ui.chatting.c.a)localObject).vtA.showVKB();
          }
        }
        for (;;)
        {
          localn.cEw();
          return;
          i = 0;
          break;
          cEm();
          break label125;
          localn.cEq().setLastContent(this.vpQ);
          localn.cEq().setLastText(this.vpQ);
          if ((!bk.bl(this.vpQ)) && (bk.bl(localn.cEt()))) {
            localn.cEA();
          }
        }
      }
    } while (localn.cEq() == null);
    label357:
    label364:
    if (((s)this.byx.ac(s.class)).cEW())
    {
      localn.cEq().setLastText(this.vpQ);
      localn.cEq().setHint(this.byx.vtz.getMMResources().getString(R.l.chatting_ui_footer_lbs_mode_hint));
      return;
    }
    if (localn.cEq().getIsVoiceInputPanleShow())
    {
      localn.cEw();
      return;
    }
    cEm();
  }
  
  public final void cyN()
  {
    y.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark reset keybord state");
    this.vpS = m.a.vpT;
    if (this.byx.pSb != null)
    {
      localObject = (com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class);
      if (!((com.tencent.mm.ui.chatting.b.b.c)localObject).cDG()) {
        break label73;
      }
      localObject = z.MB().bK(((com.tencent.mm.ui.chatting.b.b.c)localObject).cDS()).field_editingMsg;
      this.vpQ = ((String)localObject);
      this.vpR = ((String)localObject);
    }
    label73:
    do
    {
      return;
      au.Hx();
      localObject = com.tencent.mm.model.c.FB().abv(this.byx.getTalkerUserName());
    } while (localObject == null);
    Object localObject = ((as)localObject).field_editingMsg;
    this.vpQ = ((String)localObject);
    this.vpR = ((String)localObject);
  }
  
  public final void cyO() {}
  
  public final void cyP() {}
  
  public final void cyQ()
  {
    n localn = (n)this.byx.ac(n.class);
    if (localn.cEq() != null)
    {
      if (!localn.cEq().cnI()) {
        break label63;
      }
      this.vpS = m.a.vpU;
      y.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: show");
    }
    for (;;)
    {
      this.vpQ = localn.cEq().getLastText();
      return;
      label63:
      this.vpS = m.a.vpT;
      y.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: hide");
    }
  }
  
  public final void cyR()
  {
    n localn = (n)this.byx.ac(n.class);
    Object localObject = (com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class);
    long l;
    if (((com.tencent.mm.ui.chatting.b.b.c)localObject).cDG())
    {
      localObject = z.MB().bK(((com.tencent.mm.ui.chatting.b.b.c)localObject).cDS());
      if ((localn.cEq() != null) && ((this.vpR == null) || (!localn.cEq().getLastText().trim().equals(this.vpR))))
      {
        this.vpR = localn.cEq().getLastText().trim();
        ((com.tencent.mm.ai.a.a)localObject).field_editingMsg = this.vpR;
        if (!bk.bl(((com.tencent.mm.ai.a.a)localObject).field_editingMsg)) {
          break label156;
        }
      }
      label156:
      for (l = ((com.tencent.mm.ai.a.a)localObject).field_lastMsgTime;; l = System.currentTimeMillis())
      {
        ((com.tencent.mm.ai.a.a)localObject).field_flag = b.a((com.tencent.mm.ai.a.a)localObject, 1, l);
        z.MB().b((com.tencent.mm.ai.a.a)localObject);
        y.v("MicroMsg.ChattingUI.SearchComponent", "set editMsg history");
        return;
      }
    }
    localObject = null;
    if (g.DN().Dc())
    {
      au.Hx();
      localObject = com.tencent.mm.model.c.FB().abv(this.byx.getTalkerUserName());
    }
    if ((localObject == null) && (localn.cEq() != null) && (!bk.bl(localn.cEq().getLastText().trim())))
    {
      localObject = new ak(this.byx.pSb.field_username);
      ((ak)localObject).ba(System.currentTimeMillis());
      if (((u)this.byx.ac(u.class)).cFc()) {
        ((ak)localObject).gT(4194304);
      }
      au.Hx();
      com.tencent.mm.model.c.FB().d((ak)localObject);
    }
    for (;;)
    {
      if ((localObject != null) && (localn.cEq() != null) && ((this.vpR == null) || (!localn.cEq().getLastText().trim().equals(this.vpR))))
      {
        this.vpR = localn.cEq().getLastText().trim();
        ((ak)localObject).dT(localn.cEq().getLastText().trim());
        if (!bk.bl(((as)localObject).field_editingMsg)) {
          break label449;
        }
      }
      label449:
      for (l = ((as)localObject).field_conversationTime;; l = System.currentTimeMillis())
      {
        ((ak)localObject).bb(com.tencent.mm.plugin.messenger.foundation.a.a.a.a((ak)localObject, 1, l));
        au.Hx();
        com.tencent.mm.model.c.FB().a((ak)localObject, ((as)localObject).field_username, false);
        y.i("MicroMsg.ChattingUI.SearchComponent", "[doDestroy] set editMsg history! content:%s username:%s", new Object[] { bk.aac(this.vpR), this.byx.getTalkerUserName() });
        return;
      }
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramIntent == null);
    n localn = (n)this.byx.ac(n.class);
    String str = paramIntent.getStringExtra("select_raw_user_name");
    paramIntent = paramIntent.getStringExtra("Select_Conv_User");
    if (bk.bl(paramIntent))
    {
      y.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", new Object[] { "[nobody]" });
      localn.cEq().setAtSomebody("");
      this.vpO = false;
      return;
    }
    y.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", new Object[] { paramIntent });
    localn.cEq().setAtSomebody(paramIntent);
    localn.cEq().ak(this.byx.getTalkerUserName(), str, paramIntent);
    this.vpO = true;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.vpQ = ((n)this.byx.ac(n.class)).cEq().getLastText();
    cEl();
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 67)
    {
      localObject = (n)this.byx.ac(n.class);
      if (paramKeyEvent.getAction() == 0) {
        if (((n)localObject).cEq().getCharAtCursor() != ' ') {
          break label118;
        }
      }
    }
    int i;
    label118:
    for (this.vpP = true;; this.vpP = false)
    {
      if ((paramKeyEvent.getAction() == 1) && (this.vpP))
      {
        this.vpP = false;
        paramKeyEvent = ((n)localObject).cEq();
        paramInt = paramKeyEvent.getSelectionStart();
        localObject = paramKeyEvent.getLastText().substring(0, paramInt);
        i = ((String)localObject).lastIndexOf('@');
        if ((i < ((String)localObject).length()) && (i >= 0)) {
          break;
        }
      }
      return false;
    }
    Object localObject = ((String)localObject).substring(0, i);
    String str = paramKeyEvent.getLastText().substring(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject).append(str);
    paramKeyEvent.setLastText(localStringBuilder.toString());
    paramKeyEvent.lXN.setSelection(i);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.m
 * JD-Core Version:    0.7.0.1
 */