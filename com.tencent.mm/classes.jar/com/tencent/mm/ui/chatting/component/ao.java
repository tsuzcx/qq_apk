package com.tencent.mm.ui.chatting.component;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.modelverify.d;
import com.tencent.mm.plugin.bbom.k;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.ad;
import com.tencent.mm.ui.chatting.component.api.af;
import com.tencent.mm.ui.chatting.component.api.x;
import java.util.Arrays;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=af.class)
public class ao
  extends a
  implements af
{
  boolean YfF;
  private boolean aeuD;
  private Runnable aeuE;
  private Runnable aeuF;
  private IListener aeuG;
  String hQa;
  private String vsZ;
  
  public ao()
  {
    AppMethodBeat.i(35449);
    this.YfF = false;
    this.vsZ = null;
    this.aeuD = false;
    this.hQa = null;
    this.aeuE = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35446);
        if (ao.this.hlc != null) {
          ((ad)ao.this.hlc.cm(ad.class)).jsK();
        }
        AppMethodBeat.o(35446);
      }
    };
    this.aeuF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35447);
        if (ao.this.hlc != null)
        {
          Object localObject = (x)ao.this.hlc.cm(x.class);
          ((x)localObject).jsd().setLbsMode(false);
          ((x)localObject).jsd().YfT = false;
          ((x)localObject).jsd().iMc();
          ChatFooter localChatFooter = ((x)localObject).jsd();
          localChatFooter.YfU = false;
          if (localChatFooter.Yfi != null) {
            localChatFooter.Yfi.setVisibility(0);
          }
          localChatFooter.Kd(true);
          localObject = ((x)localObject).jsd();
          if (((ChatFooter)localObject).Yfe != null) {
            ((ChatFooter)localObject).Yfe.setVisibility(0);
          }
        }
        AppMethodBeat.o(35447);
      }
    };
    this.aeuG = new LbsComponent.3(this, f.hfK);
    AppMethodBeat.o(35449);
  }
  
  public final void a(Button paramButton, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2)
  {
    AppMethodBeat.i(35452);
    if (this.vsZ != null)
    {
      if (this.aeuD)
      {
        ((TextView)paramLinearLayout1.findViewById(R.h.fqt)).setText(R.l.gyi);
        paramButton.setVisibility(8);
        AppMethodBeat.o(35452);
        return;
      }
      ((TextView)paramLinearLayout1.findViewById(R.h.fqt)).setText(R.l.gyj);
      ((Button)paramLinearLayout1.findViewById(R.h.fvI)).setText(R.l.gyh);
      AppMethodBeat.o(35452);
      return;
    }
    paramButton = d.bNJ().byq(this.hQa);
    if (paramButton != null)
    {
      ((TextView)paramLinearLayout1.findViewById(R.h.fqt)).setText(paramButton.field_sayhicontent);
      ((Button)paramLinearLayout1.findViewById(R.h.fvI)).setText(R.l.gyg);
      AppMethodBeat.o(35452);
      return;
    }
    paramLinearLayout2.setVisibility(8);
    AppMethodBeat.o(35452);
  }
  
  public final void aCg(int paramInt)
  {
    AppMethodBeat.i(35453);
    Object localObject;
    if (this.vsZ != null)
    {
      localObject = String.format(this.hlc.aezO.getMMResources().getString(R.l.gvz), new Object[] { Util.nullAsNil(z.bAO()) });
      ab localab = new ab(this.hlc.aezO.getContext(), null);
      localab.content = ((String)localObject);
      localab.S(Arrays.asList(new String[] { this.hQa }), Arrays.asList(new Integer[] { Integer.valueOf(18) }));
      this.aeuD = true;
    }
    for (;;)
    {
      ((ad)this.hlc.cm(ad.class)).jsK();
      AppMethodBeat.o(35453);
      return;
      localObject = d.bNJ().byq(this.hQa);
      bh.aZW().a(new v(this.hQa, ((bz)localObject).field_ticket, paramInt), 0);
      ((bz)localObject).field_flag = 2;
      d.bNJ().update((IAutoDBItem)localObject, new String[0]);
    }
  }
  
  public final String bAQ(String paramString)
  {
    AppMethodBeat.i(35455);
    if (this.YfF)
    {
      Log.i("MicroMsg.ChattingUI.LbsComponent", "[oneliang]encrypt:" + this.hQa + ",raw:" + this.hlc.getTalkerUserName());
      if (Util.isNullOrNil(this.hQa)) {
        paramString = this.hlc.getTalkerUserName();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35455);
      return paramString;
      paramString = this.hQa;
    }
  }
  
  public final void ch(Intent paramIntent)
  {
    AppMethodBeat.i(35454);
    paramIntent.putExtra("Contact_IsLBSFriend", true);
    paramIntent.putExtra("Contact_IsLbsChattingProfile", true);
    paramIntent.putExtra("Contact_Scene", 18);
    AppMethodBeat.o(35454);
  }
  
  public final void g(n paramn)
  {
    Object localObject2 = null;
    AppMethodBeat.i(35456);
    Object localObject3;
    Object localObject1;
    if (this.YfF)
    {
      localObject3 = this.vsZ;
      localObject1 = d.bNJ();
      String str1 = this.hQa;
      String str2 = "SELECT * FROM " + ((ca)localObject1).getTableName() + " where sayhiencryptuser=? and isSend=0 and flag=0 ORDER BY createtime desc LIMIT 1";
      localObject1 = ((ca)localObject1).db.rawQuery(str2, new String[] { str1 }, 2);
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
        if (!Util.isNullOrNil(((bz)localObject2).field_ticket)) {
          localObject1 = ((bz)localObject2).field_ticket;
        }
      }
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject3 = d.bNJ().byq(this.hQa);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (!Util.isNullOrNil(((bz)localObject3).field_ticket)) {
            localObject2 = ((bz)localObject3).field_ticket;
          }
        }
      }
      if (localObject2 != null) {
        paramn.oMm = new k((String)localObject2);
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
        localObject2 = new bz();
        ((bz)localObject2).convertFrom((Cursor)localObject1);
        ((Cursor)localObject1).close();
      }
    }
  }
  
  public final void jjf()
  {
    AppMethodBeat.i(35457);
    this.YfF = this.hlc.aezO.getBooleanExtra("lbs_mode", false).booleanValue();
    if (Util.isNullOrNil(this.hlc.Uxa.field_encryptUsername)) {}
    for (String str = this.hlc.getTalkerUserName();; str = this.hlc.Uxa.field_encryptUsername)
    {
      this.hQa = str;
      this.vsZ = this.hlc.aezO.getStringExtra("lbs_ticket");
      AppMethodBeat.o(35457);
      return;
    }
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(35458);
    if (this.YfF)
    {
      Object localObject = (x)this.hlc.cm(x.class);
      ((x)localObject).jsd().setLbsMode(true);
      ChatFooter localChatFooter = ((x)localObject).jsd();
      if (localChatFooter.Yfi != null) {
        localChatFooter.Yfi.setVisibility(8);
      }
      localChatFooter.Kd(false);
      localObject = ((x)localObject).jsd();
      if (((ChatFooter)localObject).Yfe != null) {
        ((ChatFooter)localObject).Yfe.setVisibility(8);
      }
    }
    AppMethodBeat.o(35458);
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(35459);
    this.aeuG.alive();
    AppMethodBeat.o(35459);
  }
  
  public final void jji() {}
  
  public final void jjj()
  {
    AppMethodBeat.i(35460);
    MMHandlerThread.removeRunnable(this.aeuE);
    MMHandlerThread.removeRunnable(this.aeuF);
    AppMethodBeat.o(35460);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35461);
    this.aeuG.dead();
    AppMethodBeat.o(35461);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35462);
    super.jqF();
    this.aeuG.dead();
    AppMethodBeat.o(35462);
  }
  
  public final boolean jrO()
  {
    AppMethodBeat.i(35451);
    if (this.YfF)
    {
      bz localbz = d.bNJ().byq(this.hQa);
      if ((this.vsZ != null) || (localbz != null)) {
        ((ad)this.hlc.cm(ad.class)).jsK();
      }
      AppMethodBeat.o(35451);
      return true;
    }
    AppMethodBeat.o(35451);
    return false;
  }
  
  public final boolean jtc()
  {
    return this.YfF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.ao
 * JD-Core Version:    0.7.0.1
 */