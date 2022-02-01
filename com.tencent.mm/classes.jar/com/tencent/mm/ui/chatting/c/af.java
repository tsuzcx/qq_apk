package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.plugin.bbom.j;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.w;
import com.tencent.mm.ui.chatting.c.b.y;
import java.util.Arrays;

@com.tencent.mm.ui.chatting.c.a.a(foJ=y.class)
public class af
  extends a
  implements y
{
  boolean Duo;
  private boolean HWL;
  private Runnable HWM;
  private Runnable HWN;
  private com.tencent.mm.sdk.b.c HWO;
  String dmy;
  private String nnS;
  
  public af()
  {
    AppMethodBeat.i(35449);
    this.Duo = false;
    this.nnS = null;
    this.HWL = false;
    this.dmy = null;
    this.HWM = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35446);
        if (af.this.cLy != null) {
          ((w)af.this.cLy.bf(w.class)).fnH();
        }
        AppMethodBeat.o(35446);
      }
    };
    this.HWN = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35447);
        if (af.this.cLy != null)
        {
          Object localObject = (com.tencent.mm.ui.chatting.c.b.q)af.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.q.class);
          ((com.tencent.mm.ui.chatting.c.b.q)localObject).fne().setLbsMode(false);
          ((com.tencent.mm.ui.chatting.c.b.q)localObject).fne().Duy = false;
          ((com.tencent.mm.ui.chatting.c.b.q)localObject).fne().eOp();
          ChatFooter localChatFooter = ((com.tencent.mm.ui.chatting.c.b.q)localObject).fne();
          if (localChatFooter.DtW != null) {
            localChatFooter.DtW.setVisibility(0);
          }
          localChatFooter.vt(true);
          localObject = ((com.tencent.mm.ui.chatting.c.b.q)localObject).fne();
          if (((ChatFooter)localObject).DtS != null) {
            ((ChatFooter)localObject).DtS.setVisibility(0);
          }
        }
        AppMethodBeat.o(35447);
      }
    };
    this.HWO = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(35449);
  }
  
  private void fmk()
  {
    AppMethodBeat.i(35450);
    com.tencent.mm.sdk.b.a.GpY.d(this.HWO);
    AppMethodBeat.o(35450);
  }
  
  public final void a(Button paramButton, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2)
  {
    AppMethodBeat.i(35452);
    if (this.nnS != null)
    {
      if (this.HWL)
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
    paramButton = d.aJf().aOi(this.dmy);
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
  
  public final String aQn(String paramString)
  {
    AppMethodBeat.i(35455);
    if (this.Duo)
    {
      ac.i("MicroMsg.ChattingUI.LbsComponent", "[oneliang]encrypt:" + this.dmy + ",raw:" + this.cLy.getTalkerUserName());
      if (bs.isNullOrNil(this.dmy)) {
        paramString = this.cLy.getTalkerUserName();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35455);
      return paramString;
      paramString = this.dmy;
    }
  }
  
  public final void aaZ(int paramInt)
  {
    AppMethodBeat.i(35453);
    Object localObject;
    if (this.nnS != null)
    {
      localObject = String.format(this.cLy.HZF.getMMResources().getString(2131756416), new Object[] { bs.nullAsNil(u.axy()) });
      aa localaa = new aa(this.cLy.HZF.getContext(), null);
      localaa.content = ((String)localObject);
      localaa.C(Arrays.asList(new String[] { this.dmy }), Arrays.asList(new Integer[] { Integer.valueOf(18) }));
      this.HWL = true;
    }
    for (;;)
    {
      ((w)this.cLy.bf(w.class)).fnH();
      AppMethodBeat.o(35453);
      return;
      localObject = d.aJf().aOi(this.dmy);
      az.agi().a(new o(this.dmy, ((bl)localObject).field_ticket, paramInt), 0);
      ((bl)localObject).field_flag = 2;
      d.aJf().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    }
  }
  
  public final void bn(Intent paramIntent)
  {
    AppMethodBeat.i(35454);
    paramIntent.putExtra("Contact_IsLBSFriend", true);
    paramIntent.putExtra("Contact_IsLbsChattingProfile", true);
    paramIntent.putExtra("Contact_Scene", 18);
    AppMethodBeat.o(35454);
  }
  
  public final void fgg()
  {
    AppMethodBeat.i(35457);
    this.Duo = this.cLy.HZF.getBooleanExtra("lbs_mode", false).booleanValue();
    if (bs.isNullOrNil(this.cLy.AzG.field_encryptUsername)) {}
    for (String str = this.cLy.getTalkerUserName();; str = this.cLy.AzG.field_encryptUsername)
    {
      this.dmy = str;
      this.nnS = this.cLy.HZF.getStringExtra("lbs_ticket");
      AppMethodBeat.o(35457);
      return;
    }
  }
  
  public final void fgh()
  {
    AppMethodBeat.i(35458);
    if (this.Duo)
    {
      Object localObject = (com.tencent.mm.ui.chatting.c.b.q)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.q.class);
      ((com.tencent.mm.ui.chatting.c.b.q)localObject).fne().setLbsMode(true);
      ChatFooter localChatFooter = ((com.tencent.mm.ui.chatting.c.b.q)localObject).fne();
      if (localChatFooter.DtW != null) {
        localChatFooter.DtW.setVisibility(8);
      }
      localChatFooter.vt(false);
      localObject = ((com.tencent.mm.ui.chatting.c.b.q)localObject).fne();
      if (((ChatFooter)localObject).DtS != null) {
        ((ChatFooter)localObject).DtS.setVisibility(8);
      }
    }
    AppMethodBeat.o(35458);
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(35459);
    com.tencent.mm.sdk.b.a.GpY.c(this.HWO);
    AppMethodBeat.o(35459);
  }
  
  public final void fgj() {}
  
  public final void fgk()
  {
    AppMethodBeat.i(35460);
    ap.aB(this.HWM);
    ap.aB(this.HWN);
    AppMethodBeat.o(35460);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(35461);
    fmk();
    AppMethodBeat.o(35461);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35462);
    super.fmj();
    fmk();
    AppMethodBeat.o(35462);
  }
  
  public final boolean fnV()
  {
    return this.Duo;
  }
  
  public final boolean fnW()
  {
    AppMethodBeat.i(35451);
    if (this.Duo)
    {
      bl localbl = d.aJf().aOi(this.dmy);
      if ((this.nnS != null) || (localbl != null)) {
        ((w)this.cLy.bf(w.class)).fnH();
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
    if (this.Duo)
    {
      localObject3 = this.nnS;
      localObject1 = d.aJf();
      String str1 = this.dmy;
      String str2 = "SELECT * FROM " + ((bm)localObject1).getTableName() + " where sayhiencryptuser=? and isSend=0 and flag=0 ORDER BY createtime desc LIMIT 1";
      localObject1 = ((bm)localObject1).db.a(str2, new String[] { str1 }, 2);
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
        if (!bs.isNullOrNil(((bl)localObject2).field_ticket)) {
          localObject1 = ((bl)localObject2).field_ticket;
        }
      }
      localObject2 = localObject1;
      if (bs.isNullOrNil((String)localObject1))
      {
        localObject3 = d.aJf().aOi(this.dmy);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (!bs.isNullOrNil(((bl)localObject3).field_ticket)) {
            localObject2 = ((bl)localObject3).field_ticket;
          }
        }
      }
      if (localObject2 != null) {
        parami.hMm = new j((String)localObject2);
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
        localObject2 = new bl();
        ((bl)localObject2).convertFrom((Cursor)localObject1);
        ((Cursor)localObject1).close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.af
 * JD-Core Version:    0.7.0.1
 */