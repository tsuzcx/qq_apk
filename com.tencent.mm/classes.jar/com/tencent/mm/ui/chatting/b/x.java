package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.bh.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.modelmulti.h;
import com.tencent.mm.plugin.bbom.i;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.chatting.b.b.n;
import com.tencent.mm.ui.chatting.b.b.s;
import java.util.Arrays;

@com.tencent.mm.ui.chatting.b.a.a(cFA=s.class)
public class x
  extends a
  implements s
{
  String bRj = null;
  private String hST = null;
  boolean sfh = false;
  private boolean vrl = false;
  private Runnable vrm = new x.1(this);
  private Runnable vrn = new x.2(this);
  private com.tencent.mm.sdk.b.c vro = new x.3(this);
  
  public final void Hd(int paramInt)
  {
    Object localObject;
    if (this.hST != null)
    {
      localObject = String.format(this.byx.vtz.getMMResources().getString(R.l.banner_lbs_mode_add_friends), new Object[] { bk.pm(com.tencent.mm.model.q.Gl()) });
      localObject = new com.tencent.mm.pluginsdk.model.m(2, Arrays.asList(new String[] { this.bRj }), Arrays.asList(new Integer[] { Integer.valueOf(18) }), (String)localObject, "");
      au.Dk().a((com.tencent.mm.ah.m)localObject, 0);
      this.vrl = true;
    }
    for (;;)
    {
      ((com.tencent.mm.ui.chatting.b.b.q)this.byx.ac(com.tencent.mm.ui.chatting.b.b.q.class)).cEJ();
      return;
      localObject = d.RZ().abX(this.bRj);
      au.Dk().a(new com.tencent.mm.pluginsdk.model.m(this.bRj, ((bf)localObject).field_ticket, paramInt, (byte)0), 0);
      ((bf)localObject).field_flag = 2;
      d.RZ().c((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    }
  }
  
  public final void a(Button paramButton, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2)
  {
    if (this.hST != null)
    {
      if (this.vrl)
      {
        ((TextView)paramLinearLayout1.findViewById(R.h.add_friend_text)).setText(R.l.chatting_lbs_mode_addcontact_send);
        paramButton.setVisibility(8);
        return;
      }
      ((TextView)paramLinearLayout1.findViewById(R.h.add_friend_text)).setText(R.l.chatting_lbs_mode_addcontact_tips);
      ((Button)paramLinearLayout1.findViewById(R.h.chatting_addcontact_btn)).setText(R.l.chatting_lbs_mode_addcontact_btn);
      return;
    }
    paramButton = d.RZ().abX(this.bRj);
    if (paramButton != null)
    {
      ((TextView)paramLinearLayout1.findViewById(R.h.add_friend_text)).setText(paramButton.field_sayhicontent);
      ((Button)paramLinearLayout1.findViewById(R.h.chatting_addcontact_btn)).setText(R.l.chatting_lbs_mode_addcontact_accept_btn);
      return;
    }
    paramLinearLayout2.setVisibility(8);
  }
  
  public final String adu(String paramString)
  {
    if (this.sfh)
    {
      y.i("MicroMsg.ChattingUI.LbsComponent", "[oneliang]encrypt:" + this.bRj + ",raw:" + this.byx.getTalkerUserName());
      if (bk.bl(this.bRj)) {
        return this.byx.getTalkerUserName();
      }
      return this.bRj;
    }
    return paramString;
  }
  
  public final void ar(Intent paramIntent)
  {
    paramIntent.putExtra("Contact_IsLBSFriend", true);
    paramIntent.putExtra("Contact_IsLbsChattingProfile", true);
    paramIntent.putExtra("Contact_Scene", 18);
  }
  
  public final boolean cEW()
  {
    return this.sfh;
  }
  
  public final boolean cEX()
  {
    if (this.sfh)
    {
      bf localbf = d.RZ().abX(this.bRj);
      if ((this.hST != null) || (localbf != null)) {
        ((com.tencent.mm.ui.chatting.b.b.q)this.byx.ac(com.tencent.mm.ui.chatting.b.b.q.class)).cEJ();
      }
      return true;
    }
    return false;
  }
  
  public final void cyM()
  {
    this.sfh = this.byx.vtz.getBooleanExtra("lbs_mode", false).booleanValue();
    if (bk.bl(this.byx.pSb.field_encryptUsername)) {}
    for (String str = this.byx.getTalkerUserName();; str = this.byx.pSb.field_encryptUsername)
    {
      this.bRj = str;
      this.hST = this.byx.vtz.getStringExtra("lbs_ticket");
      return;
    }
  }
  
  public final void cyN()
  {
    if (this.sfh)
    {
      Object localObject = (n)this.byx.ac(n.class);
      ((n)localObject).cEq().setLbsMode(true);
      ChatFooter localChatFooter = ((n)localObject).cEq();
      if (localChatFooter.seX != null) {
        localChatFooter.seX.setVisibility(8);
      }
      localObject = ((n)localObject).cEq();
      if (((ChatFooter)localObject).seU != null) {
        ((ChatFooter)localObject).seU.setVisibility(8);
      }
    }
  }
  
  public final void cyO()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.vro);
  }
  
  public final void cyP() {}
  
  public final void cyQ()
  {
    ai.S(this.vrm);
    ai.S(this.vrn);
  }
  
  public final void cyR()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.vro);
  }
  
  public final void g(h paramh)
  {
    Object localObject2 = null;
    Object localObject3;
    Object localObject1;
    if (this.sfh)
    {
      localObject3 = this.hST;
      localObject1 = d.RZ();
      String str1 = this.bRj;
      String str2 = "SELECT * FROM " + ((bg)localObject1).getTableName() + " where sayhiencryptuser=? and isSend=0 and flag=0 ORDER BY createtime desc LIMIT 1";
      localObject1 = ((bg)localObject1).dXw.a(str2, new String[] { str1 }, 2);
      if (localObject1 != null) {
        break label168;
      }
    }
    for (;;)
    {
      localObject1 = localObject3;
      if (localObject2 != null)
      {
        localObject1 = localObject3;
        if (!bk.bl(((bf)localObject2).field_ticket)) {
          localObject1 = ((bf)localObject2).field_ticket;
        }
      }
      localObject2 = localObject1;
      if (bk.bl((String)localObject1))
      {
        localObject3 = d.RZ().abX(this.bRj);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (!bk.bl(((bf)localObject3).field_ticket)) {
            localObject2 = ((bf)localObject3).field_ticket;
          }
        }
      }
      if (localObject2 != null) {
        paramh.esT = new i((String)localObject2);
      }
      return;
      label168:
      if (!((Cursor)localObject1).moveToFirst())
      {
        ((Cursor)localObject1).close();
      }
      else
      {
        localObject2 = new bf();
        ((bf)localObject2).d((Cursor)localObject1);
        ((Cursor)localObject1).close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.x
 * JD-Core Version:    0.7.0.1
 */