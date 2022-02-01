package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.a.lc;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.plugin.bbom.k;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bt;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.d.b.y;
import java.util.Arrays;

@com.tencent.mm.ui.chatting.d.a.a(fJv=com.tencent.mm.ui.chatting.d.b.aa.class)
public class ah
  extends a
  implements com.tencent.mm.ui.chatting.d.b.aa
{
  boolean FrR;
  private boolean Kgg;
  private Runnable Kgh;
  private Runnable Kgi;
  private com.tencent.mm.sdk.b.c Kgj;
  String dzr;
  private String nUm;
  
  public ah()
  {
    AppMethodBeat.i(35449);
    this.FrR = false;
    this.nUm = null;
    this.Kgg = false;
    this.dzr = null;
    this.Kgh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35446);
        if (ah.this.cXJ != null) {
          ((y)ah.this.cXJ.bh(y.class)).fIh();
        }
        AppMethodBeat.o(35446);
      }
    };
    this.Kgi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35447);
        if (ah.this.cXJ != null)
        {
          Object localObject = (s)ah.this.cXJ.bh(s.class);
          ((s)localObject).fHF().setLbsMode(false);
          ((s)localObject).fHF().Fsc = false;
          ((s)localObject).fHF().fhd();
          ChatFooter localChatFooter = ((s)localObject).fHF();
          localChatFooter.Fsd = false;
          if (localChatFooter.Frz != null) {
            localChatFooter.Frz.setVisibility(0);
          }
          localChatFooter.wn(true);
          localObject = ((s)localObject).fHF();
          if (((ChatFooter)localObject).Frv != null) {
            ((ChatFooter)localObject).Frv.setVisibility(0);
          }
        }
        AppMethodBeat.o(35447);
      }
    };
    this.Kgj = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(35449);
  }
  
  private void fGF()
  {
    AppMethodBeat.i(35450);
    com.tencent.mm.sdk.b.a.IvT.d(this.Kgj);
    AppMethodBeat.o(35450);
  }
  
  public final void a(Button paramButton, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2)
  {
    AppMethodBeat.i(35452);
    if (this.nUm != null)
    {
      if (this.Kgg)
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
    paramButton = d.aMN().aVA(this.dzr);
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
  
  public final String aXH(String paramString)
  {
    AppMethodBeat.i(35455);
    if (this.FrR)
    {
      ae.i("MicroMsg.ChattingUI.LbsComponent", "[oneliang]encrypt:" + this.dzr + ",raw:" + this.cXJ.getTalkerUserName());
      if (bu.isNullOrNil(this.dzr)) {
        paramString = this.cXJ.getTalkerUserName();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35455);
      return paramString;
      paramString = this.dzr;
    }
  }
  
  public final void adS(int paramInt)
  {
    AppMethodBeat.i(35453);
    Object localObject;
    if (this.nUm != null)
    {
      localObject = String.format(this.cXJ.Kkd.getMMResources().getString(2131756416), new Object[] { bu.nullAsNil(v.aAE()) });
      com.tencent.mm.pluginsdk.ui.applet.aa localaa = new com.tencent.mm.pluginsdk.ui.applet.aa(this.cXJ.Kkd.getContext(), null);
      localaa.content = ((String)localObject);
      localaa.D(Arrays.asList(new String[] { this.dzr }), Arrays.asList(new Integer[] { Integer.valueOf(18) }));
      this.Kgg = true;
    }
    for (;;)
    {
      ((y)this.cXJ.bh(y.class)).fIh();
      AppMethodBeat.o(35453);
      return;
      localObject = d.aMN().aVA(this.dzr);
      bc.ajj().a(new o(this.dzr, ((bs)localObject).field_ticket, paramInt), 0);
      ((bs)localObject).field_flag = 2;
      d.aMN().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    }
  }
  
  public final void bt(Intent paramIntent)
  {
    AppMethodBeat.i(35454);
    paramIntent.putExtra("Contact_IsLBSFriend", true);
    paramIntent.putExtra("Contact_IsLbsChattingProfile", true);
    paramIntent.putExtra("Contact_Scene", 18);
    AppMethodBeat.o(35454);
  }
  
  public final void fAs()
  {
    AppMethodBeat.i(35457);
    this.FrR = this.cXJ.Kkd.getBooleanExtra("lbs_mode", false).booleanValue();
    if (bu.isNullOrNil(this.cXJ.Cqh.field_encryptUsername)) {}
    for (String str = this.cXJ.getTalkerUserName();; str = this.cXJ.Cqh.field_encryptUsername)
    {
      this.dzr = str;
      this.nUm = this.cXJ.Kkd.getStringExtra("lbs_ticket");
      AppMethodBeat.o(35457);
      return;
    }
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(35458);
    if (this.FrR)
    {
      Object localObject = (s)this.cXJ.bh(s.class);
      ((s)localObject).fHF().setLbsMode(true);
      ChatFooter localChatFooter = ((s)localObject).fHF();
      if (localChatFooter.Frz != null) {
        localChatFooter.Frz.setVisibility(8);
      }
      localChatFooter.wn(false);
      localObject = ((s)localObject).fHF();
      if (((ChatFooter)localObject).Frv != null) {
        ((ChatFooter)localObject).Frv.setVisibility(8);
      }
    }
    AppMethodBeat.o(35458);
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(35459);
    com.tencent.mm.sdk.b.a.IvT.c(this.Kgj);
    AppMethodBeat.o(35459);
  }
  
  public final void fAv() {}
  
  public final void fAw()
  {
    AppMethodBeat.i(35460);
    ar.ay(this.Kgh);
    ar.ay(this.Kgi);
    AppMethodBeat.o(35460);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35461);
    fGF();
    AppMethodBeat.o(35461);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35462);
    super.fGE();
    fGF();
    AppMethodBeat.o(35462);
  }
  
  public final boolean fIw()
  {
    return this.FrR;
  }
  
  public final boolean fIx()
  {
    AppMethodBeat.i(35451);
    if (this.FrR)
    {
      bs localbs = d.aMN().aVA(this.dzr);
      if ((this.nUm != null) || (localbs != null)) {
        ((y)this.cXJ.bh(y.class)).fIh();
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
    if (this.FrR)
    {
      localObject3 = this.nUm;
      localObject1 = d.aMN();
      String str1 = this.dzr;
      String str2 = "SELECT * FROM " + ((bt)localObject1).getTableName() + " where sayhiencryptuser=? and isSend=0 and flag=0 ORDER BY createtime desc LIMIT 1";
      localObject1 = ((bt)localObject1).db.a(str2, new String[] { str1 }, 2);
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
        if (!bu.isNullOrNil(((bs)localObject2).field_ticket)) {
          localObject1 = ((bs)localObject2).field_ticket;
        }
      }
      localObject2 = localObject1;
      if (bu.isNullOrNil((String)localObject1))
      {
        localObject3 = d.aMN().aVA(this.dzr);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (!bu.isNullOrNil(((bs)localObject3).field_ticket)) {
            localObject2 = ((bs)localObject3).field_ticket;
          }
        }
      }
      if (localObject2 != null) {
        parami.ihZ = new k((String)localObject2);
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
        localObject2 = new bs();
        ((bs)localObject2).convertFrom((Cursor)localObject1);
        ((Cursor)localObject1).close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ah
 * JD-Core Version:    0.7.0.1
 */