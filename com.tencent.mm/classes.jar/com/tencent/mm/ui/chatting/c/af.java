package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.d;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.plugin.bbom.j;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.w;
import com.tencent.mm.ui.chatting.c.b.y;
import java.util.Arrays;

@com.tencent.mm.ui.chatting.c.a.a(eYT=y.class)
public class af
  extends a
  implements y
{
  boolean CbW;
  private boolean GwU;
  private Runnable GwV;
  private Runnable GwW;
  private com.tencent.mm.sdk.b.c GwX;
  String doQ;
  private String mLJ;
  
  public af()
  {
    AppMethodBeat.i(35449);
    this.CbW = false;
    this.mLJ = null;
    this.GwU = false;
    this.doQ = null;
    this.GwV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35446);
        if (af.this.cOd != null) {
          ((w)af.this.cOd.be(w.class)).eXV();
        }
        AppMethodBeat.o(35446);
      }
    };
    this.GwW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35447);
        if (af.this.cOd != null)
        {
          Object localObject = (com.tencent.mm.ui.chatting.c.b.q)af.this.cOd.be(com.tencent.mm.ui.chatting.c.b.q.class);
          ((com.tencent.mm.ui.chatting.c.b.q)localObject).eXs().setLbsMode(false);
          ((com.tencent.mm.ui.chatting.c.b.q)localObject).eXs().Ccg = false;
          ((com.tencent.mm.ui.chatting.c.b.q)localObject).eXs().eyV();
          ChatFooter localChatFooter = ((com.tencent.mm.ui.chatting.c.b.q)localObject).eXs();
          if (localChatFooter.CbE != null) {
            localChatFooter.CbE.setVisibility(0);
          }
          localChatFooter.ur(true);
          localObject = ((com.tencent.mm.ui.chatting.c.b.q)localObject).eXs();
          if (((ChatFooter)localObject).CbA != null) {
            ((ChatFooter)localObject).CbA.setVisibility(0);
          }
        }
        AppMethodBeat.o(35447);
      }
    };
    this.GwX = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(35449);
  }
  
  private void eWy()
  {
    AppMethodBeat.i(35450);
    com.tencent.mm.sdk.b.a.ESL.d(this.GwX);
    AppMethodBeat.o(35450);
  }
  
  public final void YO(int paramInt)
  {
    AppMethodBeat.i(35453);
    Object localObject;
    if (this.mLJ != null)
    {
      localObject = String.format(this.cOd.GzJ.getMMResources().getString(2131756416), new Object[] { bt.nullAsNil(u.aqI()) });
      aa localaa = new aa(this.cOd.GzJ.getContext(), null);
      localaa.content = ((String)localObject);
      localaa.D(Arrays.asList(new String[] { this.doQ }), Arrays.asList(new Integer[] { Integer.valueOf(18) }));
      this.GwU = true;
    }
    for (;;)
    {
      ((w)this.cOd.be(w.class)).eXV();
      AppMethodBeat.o(35453);
      return;
      localObject = d.aCp().aIM(this.doQ);
      az.aeS().a(new o(this.doQ, ((bi)localObject).field_ticket, paramInt), 0);
      ((bi)localObject).field_flag = 2;
      d.aCp().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    }
  }
  
  public final void a(Button paramButton, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2)
  {
    AppMethodBeat.i(35452);
    if (this.mLJ != null)
    {
      if (this.GwU)
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
    paramButton = d.aCp().aIM(this.doQ);
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
  
  public final String aKK(String paramString)
  {
    AppMethodBeat.i(35455);
    if (this.CbW)
    {
      ad.i("MicroMsg.ChattingUI.LbsComponent", "[oneliang]encrypt:" + this.doQ + ",raw:" + this.cOd.getTalkerUserName());
      if (bt.isNullOrNil(this.doQ)) {
        paramString = this.cOd.getTalkerUserName();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35455);
      return paramString;
      paramString = this.doQ;
    }
  }
  
  public final void bm(Intent paramIntent)
  {
    AppMethodBeat.i(35454);
    paramIntent.putExtra("Contact_IsLBSFriend", true);
    paramIntent.putExtra("Contact_IsLbsChattingProfile", true);
    paramIntent.putExtra("Contact_Scene", 18);
    AppMethodBeat.o(35454);
  }
  
  public final void eQA()
  {
    AppMethodBeat.i(35457);
    this.CbW = this.cOd.GzJ.getBooleanExtra("lbs_mode", false).booleanValue();
    if (bt.isNullOrNil(this.cOd.zgX.field_encryptUsername)) {}
    for (String str = this.cOd.getTalkerUserName();; str = this.cOd.zgX.field_encryptUsername)
    {
      this.doQ = str;
      this.mLJ = this.cOd.GzJ.getStringExtra("lbs_ticket");
      AppMethodBeat.o(35457);
      return;
    }
  }
  
  public final void eQB()
  {
    AppMethodBeat.i(35458);
    if (this.CbW)
    {
      Object localObject = (com.tencent.mm.ui.chatting.c.b.q)this.cOd.be(com.tencent.mm.ui.chatting.c.b.q.class);
      ((com.tencent.mm.ui.chatting.c.b.q)localObject).eXs().setLbsMode(true);
      ChatFooter localChatFooter = ((com.tencent.mm.ui.chatting.c.b.q)localObject).eXs();
      if (localChatFooter.CbE != null) {
        localChatFooter.CbE.setVisibility(8);
      }
      localChatFooter.ur(false);
      localObject = ((com.tencent.mm.ui.chatting.c.b.q)localObject).eXs();
      if (((ChatFooter)localObject).CbA != null) {
        ((ChatFooter)localObject).CbA.setVisibility(8);
      }
    }
    AppMethodBeat.o(35458);
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(35459);
    com.tencent.mm.sdk.b.a.ESL.c(this.GwX);
    AppMethodBeat.o(35459);
  }
  
  public final void eQD() {}
  
  public final void eQE()
  {
    AppMethodBeat.i(35460);
    aq.az(this.GwV);
    aq.az(this.GwW);
    AppMethodBeat.o(35460);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(35461);
    eWy();
    AppMethodBeat.o(35461);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35462);
    super.eWx();
    eWy();
    AppMethodBeat.o(35462);
  }
  
  public final boolean eYj()
  {
    return this.CbW;
  }
  
  public final boolean eYk()
  {
    AppMethodBeat.i(35451);
    if (this.CbW)
    {
      bi localbi = d.aCp().aIM(this.doQ);
      if ((this.mLJ != null) || (localbi != null)) {
        ((w)this.cOd.be(w.class)).eXV();
      }
      AppMethodBeat.o(35451);
      return true;
    }
    AppMethodBeat.o(35451);
    return false;
  }
  
  public final void g(i parami)
  {
    Object localObject2 = null;
    AppMethodBeat.i(35456);
    Object localObject3;
    Object localObject1;
    if (this.CbW)
    {
      localObject3 = this.mLJ;
      localObject1 = d.aCp();
      String str1 = this.doQ;
      String str2 = "SELECT * FROM " + ((bj)localObject1).getTableName() + " where sayhiencryptuser=? and isSend=0 and flag=0 ORDER BY createtime desc LIMIT 1";
      localObject1 = ((bj)localObject1).db.a(str2, new String[] { str1 }, 2);
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
        if (!bt.isNullOrNil(((bi)localObject2).field_ticket)) {
          localObject1 = ((bi)localObject2).field_ticket;
        }
      }
      localObject2 = localObject1;
      if (bt.isNullOrNil((String)localObject1))
      {
        localObject3 = d.aCp().aIM(this.doQ);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (!bt.isNullOrNil(((bi)localObject3).field_ticket)) {
            localObject2 = ((bi)localObject3).field_ticket;
          }
        }
      }
      if (localObject2 != null) {
        parami.hlJ = new j((String)localObject2);
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
        localObject2 = new bi();
        ((bi)localObject2).convertFrom((Cursor)localObject1);
        ((Cursor)localObject1).close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.af
 * JD-Core Version:    0.7.0.1
 */