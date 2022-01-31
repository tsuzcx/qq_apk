package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelmulti.h;
import com.tencent.mm.plugin.bbom.i;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pluginsdk.ui.applet.s;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.c.b.t;
import java.util.Arrays;

@com.tencent.mm.ui.chatting.c.a.a(dJy=t.class)
public class y
  extends a
  implements t
{
  String cyL;
  private String jMG;
  boolean vWm;
  private boolean zGQ;
  private Runnable zGR;
  private Runnable zGS;
  private com.tencent.mm.sdk.b.c zGT;
  
  public y()
  {
    AppMethodBeat.i(31555);
    this.vWm = false;
    this.jMG = null;
    this.zGQ = false;
    this.cyL = null;
    this.zGR = new y.1(this);
    this.zGS = new y.2(this);
    this.zGT = new y.3(this);
    AppMethodBeat.o(31555);
  }
  
  private void dHr()
  {
    AppMethodBeat.i(31556);
    com.tencent.mm.sdk.b.a.ymk.d(this.zGT);
    AppMethodBeat.o(31556);
  }
  
  public final void PH(int paramInt)
  {
    AppMethodBeat.i(31559);
    Object localObject;
    if (this.jMG != null)
    {
      localObject = String.format(this.caz.zJz.getMMResources().getString(2131297529), new Object[] { bo.nullAsNil(com.tencent.mm.model.r.Zp()) });
      s locals = new s(this.caz.zJz.getContext(), null);
      locals.content = ((String)localObject);
      locals.r(Arrays.asList(new String[] { this.cyL }), Arrays.asList(new Integer[] { Integer.valueOf(18) }));
      this.zGQ = true;
    }
    for (;;)
    {
      ((com.tencent.mm.ui.chatting.c.b.r)this.caz.ay(com.tencent.mm.ui.chatting.c.b.r.class)).dIA();
      AppMethodBeat.o(31559);
      return;
      localObject = d.alj().ash(this.cyL);
      aw.Rc().a(new m(this.cyL, ((bf)localObject).field_ticket, paramInt), 0);
      ((bf)localObject).field_flag = 2;
      d.alj().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    }
  }
  
  public final void a(Button paramButton, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2)
  {
    AppMethodBeat.i(31558);
    if (this.jMG != null)
    {
      if (this.zGQ)
      {
        ((TextView)paramLinearLayout1.findViewById(2131822757)).setText(2131298224);
        paramButton.setVisibility(8);
        AppMethodBeat.o(31558);
        return;
      }
      ((TextView)paramLinearLayout1.findViewById(2131822757)).setText(2131298225);
      ((Button)paramLinearLayout1.findViewById(2131822758)).setText(2131298223);
      AppMethodBeat.o(31558);
      return;
    }
    paramButton = d.alj().ash(this.cyL);
    if (paramButton != null)
    {
      ((TextView)paramLinearLayout1.findViewById(2131822757)).setText(paramButton.field_sayhicontent);
      ((Button)paramLinearLayout1.findViewById(2131822758)).setText(2131298222);
      AppMethodBeat.o(31558);
      return;
    }
    paramLinearLayout2.setVisibility(8);
    AppMethodBeat.o(31558);
  }
  
  public final void aT(Intent paramIntent)
  {
    AppMethodBeat.i(31560);
    paramIntent.putExtra("Contact_IsLBSFriend", true);
    paramIntent.putExtra("Contact_IsLbsChattingProfile", true);
    paramIntent.putExtra("Contact_Scene", 18);
    AppMethodBeat.o(31560);
  }
  
  public final String atW(String paramString)
  {
    AppMethodBeat.i(31561);
    if (this.vWm)
    {
      ab.i("MicroMsg.ChattingUI.LbsComponent", "[oneliang]encrypt:" + this.cyL + ",raw:" + this.caz.getTalkerUserName());
      if (bo.isNullOrNil(this.cyL)) {
        paramString = this.caz.getTalkerUserName();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(31561);
      return paramString;
      paramString = this.cyL;
    }
  }
  
  public final void dBY()
  {
    AppMethodBeat.i(31563);
    this.vWm = this.caz.zJz.getBooleanExtra("lbs_mode", false).booleanValue();
    if (bo.isNullOrNil(this.caz.txj.field_encryptUsername)) {}
    for (String str = this.caz.getTalkerUserName();; str = this.caz.txj.field_encryptUsername)
    {
      this.cyL = str;
      this.jMG = this.caz.zJz.getStringExtra("lbs_ticket");
      AppMethodBeat.o(31563);
      return;
    }
  }
  
  public final void dBZ()
  {
    AppMethodBeat.i(31564);
    if (this.vWm)
    {
      Object localObject = (o)this.caz.ay(o.class);
      ((o)localObject).dIg().setLbsMode(true);
      ChatFooter localChatFooter = ((o)localObject).dIg();
      if (localChatFooter.vWc != null) {
        localChatFooter.vWc.setVisibility(8);
      }
      localObject = ((o)localObject).dIg();
      if (((ChatFooter)localObject).vVY != null) {
        ((ChatFooter)localObject).vVY.setVisibility(8);
      }
    }
    AppMethodBeat.o(31564);
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(31565);
    com.tencent.mm.sdk.b.a.ymk.c(this.zGT);
    AppMethodBeat.o(31565);
  }
  
  public final void dCb() {}
  
  public final void dCc()
  {
    AppMethodBeat.i(31566);
    al.ae(this.zGR);
    al.ae(this.zGS);
    AppMethodBeat.o(31566);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31567);
    dHr();
    AppMethodBeat.o(31567);
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31568);
    super.dHq();
    dHr();
    AppMethodBeat.o(31568);
  }
  
  public final boolean dIO()
  {
    return this.vWm;
  }
  
  public final boolean dIP()
  {
    AppMethodBeat.i(31557);
    if (this.vWm)
    {
      bf localbf = d.alj().ash(this.cyL);
      if ((this.jMG != null) || (localbf != null)) {
        ((com.tencent.mm.ui.chatting.c.b.r)this.caz.ay(com.tencent.mm.ui.chatting.c.b.r.class)).dIA();
      }
      AppMethodBeat.o(31557);
      return true;
    }
    AppMethodBeat.o(31557);
    return false;
  }
  
  public final void g(h paramh)
  {
    Object localObject2 = null;
    AppMethodBeat.i(31562);
    Object localObject3;
    Object localObject1;
    if (this.vWm)
    {
      localObject3 = this.jMG;
      localObject1 = d.alj();
      String str1 = this.cyL;
      String str2 = "SELECT * FROM " + ((bg)localObject1).getTableName() + " where sayhiencryptuser=? and isSend=0 and flag=0 ORDER BY createtime desc LIMIT 1";
      localObject1 = ((bg)localObject1).db.a(str2, new String[] { str1 }, 2);
      if (localObject1 != null) {
        break label180;
      }
    }
    for (;;)
    {
      localObject1 = localObject3;
      if (localObject2 != null)
      {
        localObject1 = localObject3;
        if (!bo.isNullOrNil(((bf)localObject2).field_ticket)) {
          localObject1 = ((bf)localObject2).field_ticket;
        }
      }
      localObject2 = localObject1;
      if (bo.isNullOrNil((String)localObject1))
      {
        localObject3 = d.alj().ash(this.cyL);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (!bo.isNullOrNil(((bf)localObject3).field_ticket)) {
            localObject2 = ((bf)localObject3).field_ticket;
          }
        }
      }
      if (localObject2 != null) {
        paramh.fIG = new i((String)localObject2);
      }
      AppMethodBeat.o(31562);
      return;
      label180:
      if (!((Cursor)localObject1).moveToFirst())
      {
        ((Cursor)localObject1).close();
      }
      else
      {
        localObject2 = new bf();
        ((bf)localObject2).convertFrom((Cursor)localObject1);
        ((Cursor)localObject1).close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.y
 * JD-Core Version:    0.7.0.1
 */