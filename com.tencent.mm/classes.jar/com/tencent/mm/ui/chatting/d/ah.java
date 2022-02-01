package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.bk.d;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.plugin.bbom.k;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bs;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.d.b.y;
import java.util.Arrays;

@com.tencent.mm.ui.chatting.d.a.a(fFo=com.tencent.mm.ui.chatting.d.b.aa.class)
public class ah
  extends a
  implements com.tencent.mm.ui.chatting.d.b.aa
{
  boolean EZt;
  private boolean JLk;
  private Runnable JLl;
  private Runnable JLm;
  private com.tencent.mm.sdk.b.c JLn;
  String dym;
  private String nOG;
  
  public ah()
  {
    AppMethodBeat.i(35449);
    this.EZt = false;
    this.nOG = null;
    this.JLk = false;
    this.dym = null;
    this.JLl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35446);
        if (ah.this.cWM != null) {
          ((y)ah.this.cWM.bh(y.class)).fEe();
        }
        AppMethodBeat.o(35446);
      }
    };
    this.JLm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35447);
        if (ah.this.cWM != null)
        {
          Object localObject = (s)ah.this.cWM.bh(s.class);
          ((s)localObject).fDC().setLbsMode(false);
          ((s)localObject).fDC().EZE = false;
          ((s)localObject).fDC().fdo();
          ChatFooter localChatFooter = ((s)localObject).fDC();
          localChatFooter.EZF = false;
          if (localChatFooter.EZb != null) {
            localChatFooter.EZb.setVisibility(0);
          }
          localChatFooter.wf(true);
          localObject = ((s)localObject).fDC();
          if (((ChatFooter)localObject).EYX != null) {
            ((ChatFooter)localObject).EYX.setVisibility(0);
          }
        }
        AppMethodBeat.o(35447);
      }
    };
    this.JLn = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(35449);
  }
  
  private void fCD()
  {
    AppMethodBeat.i(35450);
    com.tencent.mm.sdk.b.a.IbL.d(this.JLn);
    AppMethodBeat.o(35450);
  }
  
  public final void a(Button paramButton, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2)
  {
    AppMethodBeat.i(35452);
    if (this.nOG != null)
    {
      if (this.JLk)
      {
        ((TextView)paramLinearLayout1.findViewById(2131296458)).setText(2131757213);
        paramButton.setVisibility(8);
        AppMethodBeat.o(35452);
        return;
      }
      ((TextView)paramLinearLayout1.findViewById(2131296458)).setText(2131757214);
      ((Button)paramLinearLayout1.findViewById(2131297974)).setText(2131757212);
      AppMethodBeat.o(35452);
      return;
    }
    paramButton = d.aMp().aTZ(this.dym);
    if (paramButton != null)
    {
      ((TextView)paramLinearLayout1.findViewById(2131296458)).setText(paramButton.field_sayhicontent);
      ((Button)paramLinearLayout1.findViewById(2131297974)).setText(2131757211);
      AppMethodBeat.o(35452);
      return;
    }
    paramLinearLayout2.setVisibility(8);
    AppMethodBeat.o(35452);
  }
  
  public final String aWg(String paramString)
  {
    AppMethodBeat.i(35455);
    if (this.EZt)
    {
      ad.i("MicroMsg.ChattingUI.LbsComponent", "[oneliang]encrypt:" + this.dym + ",raw:" + this.cWM.getTalkerUserName());
      if (bt.isNullOrNil(this.dym)) {
        paramString = this.cWM.getTalkerUserName();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35455);
      return paramString;
      paramString = this.dym;
    }
  }
  
  public final void adl(int paramInt)
  {
    AppMethodBeat.i(35453);
    Object localObject;
    if (this.nOG != null)
    {
      localObject = String.format(this.cWM.JOR.getMMResources().getString(2131756416), new Object[] { bt.nullAsNil(u.aAo()) });
      com.tencent.mm.pluginsdk.ui.applet.aa localaa = new com.tencent.mm.pluginsdk.ui.applet.aa(this.cWM.JOR.getContext(), null);
      localaa.content = ((String)localObject);
      localaa.E(Arrays.asList(new String[] { this.dym }), Arrays.asList(new Integer[] { Integer.valueOf(18) }));
      this.JLk = true;
    }
    for (;;)
    {
      ((y)this.cWM.bh(y.class)).fEe();
      AppMethodBeat.o(35453);
      return;
      localObject = d.aMp().aTZ(this.dym);
      ba.aiU().a(new o(this.dym, ((br)localObject).field_ticket, paramInt), 0);
      ((br)localObject).field_flag = 2;
      d.aMp().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    }
  }
  
  public final void bs(Intent paramIntent)
  {
    AppMethodBeat.i(35454);
    paramIntent.putExtra("Contact_IsLBSFriend", true);
    paramIntent.putExtra("Contact_IsLbsChattingProfile", true);
    paramIntent.putExtra("Contact_Scene", 18);
    AppMethodBeat.o(35454);
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35462);
    super.fCC();
    fCD();
    AppMethodBeat.o(35462);
  }
  
  public final boolean fEs()
  {
    return this.EZt;
  }
  
  public final boolean fEt()
  {
    AppMethodBeat.i(35451);
    if (this.EZt)
    {
      br localbr = d.aMp().aTZ(this.dym);
      if ((this.nOG != null) || (localbr != null)) {
        ((y)this.cWM.bh(y.class)).fEe();
      }
      AppMethodBeat.o(35451);
      return true;
    }
    AppMethodBeat.o(35451);
    return false;
  }
  
  public final void fws()
  {
    AppMethodBeat.i(35457);
    this.EZt = this.cWM.JOR.getBooleanExtra("lbs_mode", false).booleanValue();
    if (bt.isNullOrNil(this.cWM.BYG.field_encryptUsername)) {}
    for (String str = this.cWM.getTalkerUserName();; str = this.cWM.BYG.field_encryptUsername)
    {
      this.dym = str;
      this.nOG = this.cWM.JOR.getStringExtra("lbs_ticket");
      AppMethodBeat.o(35457);
      return;
    }
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(35458);
    if (this.EZt)
    {
      Object localObject = (s)this.cWM.bh(s.class);
      ((s)localObject).fDC().setLbsMode(true);
      ChatFooter localChatFooter = ((s)localObject).fDC();
      if (localChatFooter.EZb != null) {
        localChatFooter.EZb.setVisibility(8);
      }
      localChatFooter.wf(false);
      localObject = ((s)localObject).fDC();
      if (((ChatFooter)localObject).EYX != null) {
        ((ChatFooter)localObject).EYX.setVisibility(8);
      }
    }
    AppMethodBeat.o(35458);
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(35459);
    com.tencent.mm.sdk.b.a.IbL.c(this.JLn);
    AppMethodBeat.o(35459);
  }
  
  public final void fwv() {}
  
  public final void fww()
  {
    AppMethodBeat.i(35460);
    aq.aA(this.JLl);
    aq.aA(this.JLm);
    AppMethodBeat.o(35460);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35461);
    fCD();
    AppMethodBeat.o(35461);
  }
  
  public final void g(i parami)
  {
    Object localObject2 = null;
    AppMethodBeat.i(35456);
    Object localObject3;
    Object localObject1;
    if (this.EZt)
    {
      localObject3 = this.nOG;
      localObject1 = d.aMp();
      String str1 = this.dym;
      String str2 = "SELECT * FROM " + ((bs)localObject1).getTableName() + " where sayhiencryptuser=? and isSend=0 and flag=0 ORDER BY createtime desc LIMIT 1";
      localObject1 = ((bs)localObject1).db.a(str2, new String[] { str1 }, 2);
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
        if (!bt.isNullOrNil(((br)localObject2).field_ticket)) {
          localObject1 = ((br)localObject2).field_ticket;
        }
      }
      localObject2 = localObject1;
      if (bt.isNullOrNil((String)localObject1))
      {
        localObject3 = d.aMp().aTZ(this.dym);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (!bt.isNullOrNil(((br)localObject3).field_ticket)) {
            localObject2 = ((br)localObject3).field_ticket;
          }
        }
      }
      if (localObject2 != null) {
        parami.ifg = new k((String)localObject2);
      }
      AppMethodBeat.o(35456);
      return;
      label180:
      if (!((Cursor)localObject1).moveToFirst())
      {
        ((Cursor)localObject1).close();
      }
      else
      {
        localObject2 = new br();
        ((br)localObject2).convertFrom((Cursor)localObject1);
        ((Cursor)localObject1).close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ah
 * JD-Core Version:    0.7.0.1
 */