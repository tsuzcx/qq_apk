package com.tencent.mm.ui.chatting.d;

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
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.mj;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.plugin.bbom.k;
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

@com.tencent.mm.ui.chatting.d.a.a(hRc=ac.class)
public class ak
  extends a
  implements ac
{
  boolean Rjv;
  private Runnable WMB;
  private IListener WMC;
  private boolean WMy;
  private Runnable WMz;
  String fKu;
  private String she;
  
  public ak()
  {
    AppMethodBeat.i(35449);
    this.Rjv = false;
    this.she = null;
    this.WMy = false;
    this.fKu = null;
    this.WMz = new ak.1(this);
    this.WMB = new ak.2(this);
    this.WMC = new IListener() {};
    AppMethodBeat.o(35449);
  }
  
  private void hOa()
  {
    AppMethodBeat.i(35450);
    EventCenter.instance.removeListener(this.WMC);
    AppMethodBeat.o(35450);
  }
  
  public final void a(Button paramButton, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2)
  {
    AppMethodBeat.i(35452);
    if (this.she != null)
    {
      if (this.WMy)
      {
        ((TextView)paramLinearLayout1.findViewById(R.h.dqf)).setText(R.l.evH);
        paramButton.setVisibility(8);
        AppMethodBeat.o(35452);
        return;
      }
      ((TextView)paramLinearLayout1.findViewById(R.h.dqf)).setText(R.l.evI);
      ((Button)paramLinearLayout1.findViewById(R.h.dvs)).setText(R.l.evG);
      AppMethodBeat.o(35452);
      return;
    }
    paramButton = d.bqd().bwX(this.fKu);
    if (paramButton != null)
    {
      ((TextView)paramLinearLayout1.findViewById(R.h.dqf)).setText(paramButton.field_sayhicontent);
      ((Button)paramLinearLayout1.findViewById(R.h.dvs)).setText(R.l.evF);
      AppMethodBeat.o(35452);
      return;
    }
    paramLinearLayout2.setVisibility(8);
    AppMethodBeat.o(35452);
  }
  
  public final void avE(int paramInt)
  {
    AppMethodBeat.i(35453);
    Object localObject;
    if (this.she != null)
    {
      localObject = String.format(this.fgR.WQv.getMMResources().getString(R.l.esy), new Object[] { Util.nullAsNil(z.bdb()) });
      com.tencent.mm.pluginsdk.ui.applet.aa localaa = new com.tencent.mm.pluginsdk.ui.applet.aa(this.fgR.WQv.getContext(), null);
      localaa.content = ((String)localObject);
      localaa.F(Arrays.asList(new String[] { this.fKu }), Arrays.asList(new Integer[] { Integer.valueOf(18) }));
      this.WMy = true;
    }
    for (;;)
    {
      ((com.tencent.mm.ui.chatting.d.b.aa)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.aa.class)).hPN();
      AppMethodBeat.o(35453);
      return;
      localObject = d.bqd().bwX(this.fKu);
      bh.aGY().a(new com.tencent.mm.pluginsdk.model.t(this.fKu, ((bx)localObject).field_ticket, paramInt), 0);
      ((bx)localObject).field_flag = 2;
      d.bqd().update((IAutoDBItem)localObject, new String[0]);
    }
  }
  
  public final void bE(Intent paramIntent)
  {
    AppMethodBeat.i(35454);
    paramIntent.putExtra("Contact_IsLBSFriend", true);
    paramIntent.putExtra("Contact_IsLbsChattingProfile", true);
    paramIntent.putExtra("Contact_Scene", 18);
    AppMethodBeat.o(35454);
  }
  
  public final String bzn(String paramString)
  {
    AppMethodBeat.i(35455);
    if (this.Rjv)
    {
      Log.i("MicroMsg.ChattingUI.LbsComponent", "[oneliang]encrypt:" + this.fKu + ",raw:" + this.fgR.getTalkerUserName());
      if (Util.isNullOrNil(this.fKu)) {
        paramString = this.fgR.getTalkerUserName();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35455);
      return paramString;
      paramString = this.fKu;
    }
  }
  
  public final void g(i parami)
  {
    Object localObject2 = null;
    AppMethodBeat.i(35456);
    Object localObject3;
    Object localObject1;
    if (this.Rjv)
    {
      localObject3 = this.she;
      localObject1 = d.bqd();
      String str1 = this.fKu;
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
        localObject3 = d.bqd().bwX(this.fKu);
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
        parami.lTt = new k((String)localObject2);
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
  
  public final void hGU()
  {
    AppMethodBeat.i(35457);
    this.Rjv = this.fgR.WQv.getBooleanExtra("lbs_mode", false).booleanValue();
    if (Util.isNullOrNil(this.fgR.NKq.field_encryptUsername)) {}
    for (String str = this.fgR.getTalkerUserName();; str = this.fgR.NKq.field_encryptUsername)
    {
      this.fKu = str;
      this.she = this.fgR.WQv.getStringExtra("lbs_ticket");
      AppMethodBeat.o(35457);
      return;
    }
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(35458);
    if (this.Rjv)
    {
      Object localObject = (u)this.fgR.bC(u.class);
      ((u)localObject).hPj().setLbsMode(true);
      ChatFooter localChatFooter = ((u)localObject).hPj();
      if (localChatFooter.Rjb != null) {
        localChatFooter.Rjb.setVisibility(8);
      }
      localChatFooter.Es(false);
      localObject = ((u)localObject).hPj();
      if (((ChatFooter)localObject).RiX != null) {
        ((ChatFooter)localObject).RiX.setVisibility(8);
      }
    }
    AppMethodBeat.o(35458);
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35459);
    EventCenter.instance.addListener(this.WMC);
    AppMethodBeat.o(35459);
  }
  
  public final void hGX() {}
  
  public final void hGY()
  {
    AppMethodBeat.i(35460);
    MMHandlerThread.removeRunnable(this.WMz);
    MMHandlerThread.removeRunnable(this.WMB);
    AppMethodBeat.o(35460);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35461);
    hOa();
    AppMethodBeat.o(35461);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35462);
    super.hNZ();
    hOa();
    AppMethodBeat.o(35462);
  }
  
  public final boolean hOY()
  {
    AppMethodBeat.i(35451);
    if (this.Rjv)
    {
      bx localbx = d.bqd().bwX(this.fKu);
      if ((this.she != null) || (localbx != null)) {
        ((com.tencent.mm.ui.chatting.d.b.aa)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.aa.class)).hPN();
      }
      AppMethodBeat.o(35451);
      return true;
    }
    AppMethodBeat.o(35451);
    return false;
  }
  
  public final boolean hQe()
  {
    return this.Rjv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ak
 * JD-Core Version:    0.7.0.1
 */