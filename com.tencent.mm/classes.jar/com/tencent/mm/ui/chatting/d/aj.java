package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.plugin.bbom.k;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.u;
import java.util.Arrays;

@com.tencent.mm.ui.chatting.d.a.a(gRF=ac.class)
public class aj
  extends a
  implements ac
{
  boolean KiI;
  private boolean PrY;
  private Runnable PrZ;
  private Runnable Psa;
  private IListener Psb;
  String dRe;
  private String pfa;
  
  public aj()
  {
    AppMethodBeat.i(35449);
    this.KiI = false;
    this.pfa = null;
    this.PrY = false;
    this.dRe = null;
    this.PrZ = new aj.1(this);
    this.Psa = new aj.2(this);
    this.Psb = new IListener() {};
    AppMethodBeat.o(35449);
  }
  
  private void gOL()
  {
    AppMethodBeat.i(35450);
    EventCenter.instance.removeListener(this.Psb);
    AppMethodBeat.o(35450);
  }
  
  public final void a(Button paramButton, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2)
  {
    AppMethodBeat.i(35452);
    if (this.pfa != null)
    {
      if (this.PrY)
      {
        ((TextView)paramLinearLayout1.findViewById(2131296531)).setText(2131757425);
        paramButton.setVisibility(8);
        AppMethodBeat.o(35452);
        return;
      }
      ((TextView)paramLinearLayout1.findViewById(2131296531)).setText(2131757426);
      ((Button)paramLinearLayout1.findViewById(2131298315)).setText(2131757424);
      AppMethodBeat.o(35452);
      return;
    }
    paramButton = d.bgO().bky(this.dRe);
    if (paramButton != null)
    {
      ((TextView)paramLinearLayout1.findViewById(2131296531)).setText(paramButton.field_sayhicontent);
      ((Button)paramLinearLayout1.findViewById(2131298315)).setText(2131757423);
      AppMethodBeat.o(35452);
      return;
    }
    paramLinearLayout2.setVisibility(8);
    AppMethodBeat.o(35452);
  }
  
  public final void amD(int paramInt)
  {
    AppMethodBeat.i(35453);
    Object localObject;
    if (this.pfa != null)
    {
      localObject = String.format(this.dom.Pwc.getMMResources().getString(2131756551), new Object[] { Util.nullAsNil(z.aUa()) });
      com.tencent.mm.pluginsdk.ui.applet.aa localaa = new com.tencent.mm.pluginsdk.ui.applet.aa(this.dom.Pwc.getContext(), null);
      localaa.content = ((String)localObject);
      localaa.z(Arrays.asList(new String[] { this.dRe }), Arrays.asList(new Integer[] { Integer.valueOf(18) }));
      this.PrY = true;
    }
    for (;;)
    {
      ((com.tencent.mm.ui.chatting.d.b.aa)this.dom.bh(com.tencent.mm.ui.chatting.d.b.aa.class)).gQr();
      AppMethodBeat.o(35453);
      return;
      localObject = d.bgO().bky(this.dRe);
      bg.azz().a(new p(this.dRe, ((bx)localObject).field_ticket, paramInt), 0);
      ((bx)localObject).field_flag = 2;
      d.bgO().update((IAutoDBItem)localObject, new String[0]);
    }
  }
  
  public final void bD(Intent paramIntent)
  {
    AppMethodBeat.i(35454);
    paramIntent.putExtra("Contact_IsLBSFriend", true);
    paramIntent.putExtra("Contact_IsLbsChattingProfile", true);
    paramIntent.putExtra("Contact_Scene", 18);
    AppMethodBeat.o(35454);
  }
  
  public final String bmM(String paramString)
  {
    AppMethodBeat.i(35455);
    if (this.KiI)
    {
      Log.i("MicroMsg.ChattingUI.LbsComponent", "[oneliang]encrypt:" + this.dRe + ",raw:" + this.dom.getTalkerUserName());
      if (Util.isNullOrNil(this.dRe)) {
        paramString = this.dom.getTalkerUserName();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35455);
      return paramString;
      paramString = this.dRe;
    }
  }
  
  public final void cFx() {}
  
  public final void cFy()
  {
    AppMethodBeat.i(35460);
    MMHandlerThread.removeRunnable(this.PrZ);
    MMHandlerThread.removeRunnable(this.Psa);
    AppMethodBeat.o(35460);
  }
  
  public final void g(i parami)
  {
    Object localObject2 = null;
    AppMethodBeat.i(35456);
    Object localObject3;
    Object localObject1;
    if (this.KiI)
    {
      localObject3 = this.pfa;
      localObject1 = d.bgO();
      String str1 = this.dRe;
      String str2 = "SELECT * FROM " + ((by)localObject1).getTableName() + " where sayhiencryptuser=? and isSend=0 and flag=0 ORDER BY createtime desc LIMIT 1";
      localObject1 = ((by)localObject1).db.rawQuery(str2, new String[] { str1 }, 2);
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
        if (!Util.isNullOrNil(((bx)localObject2).field_ticket)) {
          localObject1 = ((bx)localObject2).field_ticket;
        }
      }
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject3 = d.bgO().bky(this.dRe);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (!Util.isNullOrNil(((bx)localObject3).field_ticket)) {
            localObject2 = ((bx)localObject3).field_ticket;
          }
        }
      }
      if (localObject2 != null) {
        parami.jcU = new k((String)localObject2);
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
        localObject2 = new bx();
        ((bx)localObject2).convertFrom((Cursor)localObject1);
        ((Cursor)localObject1).close();
      }
    }
  }
  
  public final void gIk()
  {
    AppMethodBeat.i(35457);
    this.KiI = this.dom.Pwc.getBooleanExtra("lbs_mode", false).booleanValue();
    if (Util.isNullOrNil(this.dom.GUe.field_encryptUsername)) {}
    for (String str = this.dom.getTalkerUserName();; str = this.dom.GUe.field_encryptUsername)
    {
      this.dRe = str;
      this.pfa = this.dom.Pwc.getStringExtra("lbs_ticket");
      AppMethodBeat.o(35457);
      return;
    }
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(35458);
    if (this.KiI)
    {
      Object localObject = (u)this.dom.bh(u.class);
      ((u)localObject).gPO().setLbsMode(true);
      ChatFooter localChatFooter = ((u)localObject).gPO();
      if (localChatFooter.Kir != null) {
        localChatFooter.Kir.setVisibility(8);
      }
      localChatFooter.Am(false);
      localObject = ((u)localObject).gPO();
      if (((ChatFooter)localObject).Kin != null) {
        ((ChatFooter)localObject).Kin.setVisibility(8);
      }
    }
    AppMethodBeat.o(35458);
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(35459);
    EventCenter.instance.addListener(this.Psb);
    AppMethodBeat.o(35459);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35461);
    gOL();
    AppMethodBeat.o(35461);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35462);
    super.gOK();
    gOL();
    AppMethodBeat.o(35462);
  }
  
  public final boolean gPG()
  {
    AppMethodBeat.i(35451);
    if (this.KiI)
    {
      bx localbx = d.bgO().bky(this.dRe);
      if ((this.pfa != null) || (localbx != null)) {
        ((com.tencent.mm.ui.chatting.d.b.aa)this.dom.bh(com.tencent.mm.ui.chatting.d.b.aa.class)).gQr();
      }
      AppMethodBeat.o(35451);
      return true;
    }
    AppMethodBeat.o(35451);
    return false;
  }
  
  public final boolean gQH()
  {
    return this.KiI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.aj
 * JD-Core Version:    0.7.0.1
 */