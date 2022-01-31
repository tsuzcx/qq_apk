package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.R.c;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.a.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.m.6;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI;
import com.tencent.mm.ui.chatting.AtSomeoneUI;
import com.tencent.mm.ui.chatting.b.b.aa;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class q$a
  implements TextWatcher
{
  private boolean vqv = false;
  private List<String> vqw = null;
  
  private q$a(q paramq) {}
  
  private static void b(List<String> paramList, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if ((str.length() > 0) && (str.substring(str.length() - 1, str.length()).matches("[_0-9a-zA-Z]$"))) {
        paramList.add(str);
      }
      i += 1;
    }
  }
  
  private boolean dF(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramInt < 0) || (paramString.length() <= paramInt)) {
      return false;
    }
    if (paramInt == 0) {
      return true;
    }
    if (paramString.substring(paramInt - 1, paramInt).matches("[_0-9a-zA-Z]$"))
    {
      if (this.vqw == null)
      {
        this.vqw = new LinkedList();
        localObject = this.vqu.byx.vtz.getMMResources().getStringArray(R.c.merge_smiley_code_smiley);
        b(this.vqw, (String[])localObject);
        localObject = this.vqu.byx.vtz.getMMResources().getStringArray(R.c.merge_smiley_softbank_emoji);
        b(this.vqw, (String[])localObject);
      }
      paramString = paramString.substring(0, paramInt);
      Object localObject = this.vqw.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramString.endsWith((String)((Iterator)localObject).next())) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.ChattingUI.FootComponent", "[onTextChanged]");
    ((aa)this.vqu.byx.ac(aa.class)).Hf(1);
    Object localObject = (com.tencent.mm.ui.chatting.b.b.c)this.vqu.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class);
    paramCharSequence = String.valueOf(paramCharSequence);
    String str1 = paramCharSequence.substring(paramInt1, paramInt1 + paramInt3);
    String str2;
    Intent localIntent;
    if ((this.vqu.byx.cFD()) && ("@".equals(str1)) && (!paramCharSequence.equals(this.vqu.maV.getLastContent())) && (!this.vqu.maV.sfg))
    {
      this.vqu.maV.setLastContent(paramCharSequence);
      this.vqu.maV.setInsertPos(paramInt1 + 1);
      if (dF(paramCharSequence, paramInt1))
      {
        str2 = bk.c(com.tencent.mm.model.m.gK(this.vqu.byx.getTalkerUserName()), ",");
        localIntent = new Intent();
        localIntent.setClass(this.vqu.byx.vtz.getContext(), AtSomeoneUI.class);
        localIntent.putExtra("Block_list", com.tencent.mm.model.q.Gj());
        localIntent.putExtra("Chatroom_member_list", str2);
        localIntent.putExtra("Chat_User", this.vqu.byx.getTalkerUserName());
        localIntent.putExtra("Add_address_titile", this.vqu.byx.vtz.getMMString(R.l.room_at_someone));
        this.vqu.byx.vtz.startActivityForResult(localIntent, 212);
      }
    }
    for (;;)
    {
      ((com.tencent.mm.ui.chatting.b.b.z)this.vqu.byx.ac(com.tencent.mm.ui.chatting.b.b.z.class)).B(paramCharSequence, paramInt1, str1);
      if (!((com.tencent.mm.ui.chatting.b.b.c)localObject).cDG())
      {
        localObject = this.vqu.maV;
        if ((((ChatFooter)localObject).sfc != null) && (((ChatFooter)localObject).lXO != null))
        {
          ((ChatFooter)localObject).sfc.sgM = true;
          localObject = ((ChatFooter)localObject).sfc;
          if ((!bk.bl(paramCharSequence)) && (!paramCharSequence.equals(((com.tencent.mm.pluginsdk.ui.chat.m)localObject).sgL))) {
            g.DS().O(new m.6((com.tencent.mm.pluginsdk.ui.chat.m)localObject, paramCharSequence));
          }
          ((com.tencent.mm.pluginsdk.ui.chat.m)localObject).sgL = paramCharSequence;
        }
      }
      return;
      if ((((com.tencent.mm.ui.chatting.b.b.c)localObject).cDH()) && ("@".equals(str1)) && (!paramCharSequence.equals(this.vqu.maV.getLastContent())) && (!this.vqu.maV.sfg))
      {
        this.vqu.maV.setLastContent(paramCharSequence);
        this.vqu.maV.setInsertPos(paramInt1 + 1);
        if (dF(paramCharSequence, paramInt1))
        {
          str2 = ((com.tencent.mm.ui.chatting.b.b.c)localObject).cDE().field_userList;
          localIntent = new Intent();
          localIntent.setClass(this.vqu.byx.vtz.getContext(), BizChatAtSomeoneUI.class);
          localIntent.putExtra("Block_list", com.tencent.mm.ai.z.MC().bZ(this.vqu.byx.getTalkerUserName()));
          localIntent.putExtra("Chatroom_member_list", str2);
          localIntent.putExtra("Chat_User", this.vqu.byx.getTalkerUserName());
          localIntent.putExtra("Add_address_titile", this.vqu.byx.vtz.getMMString(R.l.room_at_someone));
          localIntent.putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.b.b.c)this.vqu.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDS());
          this.vqu.byx.vtz.startActivityForResult(localIntent, 212);
        }
      }
      else if (!paramCharSequence.equals(this.vqu.maV.getLastContent()))
      {
        this.vqu.maV.setLastContent(paramCharSequence);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.q.a
 * JD-Core Version:    0.7.0.1
 */