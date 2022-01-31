package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.a.k;
import com.tencent.mm.aj.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.m;
import com.tencent.mm.pluginsdk.ui.chat.m.6;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI;
import com.tencent.mm.ui.chatting.AtSomeoneUI;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.d.a;
import java.util.List;

final class q$a
  implements TextWatcher
{
  private boolean zGb = false;
  private List<String> zGc = null;
  
  private q$a(q paramq) {}
  
  private static boolean eP(String paramString, int paramInt)
  {
    AppMethodBeat.i(31417);
    if ((paramString == null) || (paramInt < 0) || (paramString.length() <= paramInt))
    {
      AppMethodBeat.o(31417);
      return false;
    }
    if (paramInt == 0)
    {
      AppMethodBeat.o(31417);
      return true;
    }
    AppMethodBeat.o(31417);
    return true;
  }
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(31418);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "[onTextChanged]");
    ((com.tencent.mm.ui.chatting.c.b.ab)this.zGa.caz.ay(com.tencent.mm.ui.chatting.c.b.ab.class)).PJ(1);
    Object localObject = (d)this.zGa.caz.ay(d.class);
    paramCharSequence = String.valueOf(paramCharSequence);
    String str1 = paramCharSequence.substring(paramInt1, paramInt1 + paramInt3);
    String str2;
    Intent localIntent;
    if ((this.zGa.caz.dJF()) && ("@".equals(str1)) && (!paramCharSequence.equals(this.zGa.oBw.getLastContent())) && (!this.zGa.oBw.vWl))
    {
      this.zGa.oBw.setLastContent(paramCharSequence);
      this.zGa.oBw.setInsertPos(paramInt1 + 1);
      if (eP(paramCharSequence, paramInt1))
      {
        str2 = bo.d(n.nt(this.zGa.caz.getTalkerUserName()), ",");
        localIntent = new Intent();
        localIntent.setClass(this.zGa.caz.zJz.getContext(), AtSomeoneUI.class);
        localIntent.putExtra("Block_list", r.Zn());
        localIntent.putExtra("Chatroom_member_list", str2);
        localIntent.putExtra("Chat_User", this.zGa.caz.getTalkerUserName());
        localIntent.putExtra("Add_address_titile", this.zGa.caz.zJz.getMMString(2131302665));
        this.zGa.caz.zJz.startActivityForResult(localIntent, 212);
      }
    }
    for (;;)
    {
      ((aa)this.zGa.caz.ay(aa.class)).z(paramCharSequence, paramInt1, str1);
      if (!((d)localObject).dHv())
      {
        localObject = this.zGa.oBw;
        if ((((ChatFooter)localObject).vWh != null) && (((ChatFooter)localObject).oxn != null))
        {
          ((ChatFooter)localObject).vWh.vZf = true;
          localObject = ((ChatFooter)localObject).vWh;
          if ((!bo.isNullOrNil(paramCharSequence)) && (!paramCharSequence.equals(((m)localObject).vZe))) {
            g.RO().ac(new m.6((m)localObject, paramCharSequence));
          }
          ((m)localObject).vZe = paramCharSequence;
        }
      }
      AppMethodBeat.o(31418);
      return;
      if ((((d)localObject).dHw()) && ("@".equals(str1)) && (!paramCharSequence.equals(this.zGa.oBw.getLastContent())) && (!this.zGa.oBw.vWl))
      {
        this.zGa.oBw.setLastContent(paramCharSequence);
        this.zGa.oBw.setInsertPos(paramInt1 + 1);
        if (eP(paramCharSequence, paramInt1))
        {
          str2 = ((d)localObject).dHt().field_userList;
          localIntent = new Intent();
          localIntent.setClass(this.zGa.caz.zJz.getContext(), BizChatAtSomeoneUI.class);
          localIntent.putExtra("Block_list", z.afm().dg(this.zGa.caz.getTalkerUserName()));
          localIntent.putExtra("Chatroom_member_list", str2);
          localIntent.putExtra("Chat_User", this.zGa.caz.getTalkerUserName());
          localIntent.putExtra("Add_address_titile", this.zGa.caz.zJz.getMMString(2131302665));
          localIntent.putExtra("key_biz_chat_id", ((d)this.zGa.caz.ay(d.class)).dHI());
          this.zGa.caz.zJz.startActivityForResult(localIntent, 212);
        }
      }
      else if (!paramCharSequence.equals(this.zGa.oBw.getLastContent()))
      {
        this.zGa.oBw.setLastContent(paramCharSequence);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.q.a
 * JD-Core Version:    0.7.0.1
 */