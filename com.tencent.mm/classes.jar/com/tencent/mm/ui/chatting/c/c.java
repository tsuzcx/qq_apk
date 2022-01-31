package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.a.d.a;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.d.b.c;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.n;
import com.tencent.mm.aj.z;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.g.a.ee;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.e;
import com.tencent.mm.protocal.protobuf.caf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r.a;
import com.tencent.mm.storage.r.b;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.bizchat.BizChatroomInfoUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.c.b.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.chatting.c.a.a(dJy=com.tencent.mm.ui.chatting.c.b.d.class)
public class c
  extends a
  implements n, com.tencent.mm.ui.chatting.c.b.d
{
  private caf fwz;
  public boolean muT;
  private com.tencent.mm.aj.d pyd;
  public j pzG;
  private com.tencent.mm.ui.widget.b.c pzP;
  private com.tencent.mm.app.plugin.a.a zEa;
  private long zEb;
  private bi zEc;
  public boolean zEd;
  private long zEe;
  private RelativeLayout zEf;
  private TextView zEg;
  private int zEh;
  private boolean zEi;
  private boolean zEj;
  private e.a zEk;
  private boolean zEl;
  public com.tencent.mm.aj.a.c zsO;
  private d.a ztt;
  protected final ChatFooter.e zwc;
  protected final c.a zxe;
  
  public c()
  {
    AppMethodBeat.i(31208);
    this.zEb = 0L;
    this.muT = false;
    this.zEd = false;
    this.zEe = -1L;
    this.pzP = null;
    this.fwz = null;
    this.zxe = new c.1(this);
    this.zwc = new c.8(this);
    this.ztt = new c.9(this);
    this.zEi = false;
    this.zEj = false;
    this.zEk = new c.10(this);
    this.zEl = false;
    AppMethodBeat.o(31208);
  }
  
  private String aN(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(31223);
    if (paramLinkedList.size() <= 0)
    {
      AppMethodBeat.o(31223);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(this.zsO.nE((String)paramLinkedList.get(0)));
    int i = 1;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append(this.caz.zJz.getContext().getString(2131298140)).append(this.zsO.nE((String)paramLinkedList.get(i)));
      i += 1;
    }
    paramLinkedList = localStringBuilder.toString();
    AppMethodBeat.o(31223);
    return paramLinkedList;
  }
  
  public static boolean aS(Intent paramIntent)
  {
    AppMethodBeat.i(31209);
    String str = paramIntent.getStringExtra("Chat_User");
    boolean bool = paramIntent.getBooleanExtra("key_is_biz_chat", false);
    if ((!bool) && (str == null))
    {
      ab.e("MicroMsg.ChattingUI.BizComponent", "talker is null !!!");
      AppMethodBeat.o(31209);
      return true;
    }
    if ((bool) && (paramIntent.getLongExtra("key_biz_chat_id", -1L) == -1L))
    {
      ab.e("MicroMsg.ChattingUI.BizComponent", "bizChatId is null !!");
      AppMethodBeat.o(31209);
      return true;
    }
    AppMethodBeat.o(31209);
    return false;
  }
  
  private void dHK()
  {
    AppMethodBeat.i(31224);
    if (!this.muT)
    {
      AppMethodBeat.o(31224);
      return;
    }
    z.afq();
    com.tencent.mm.aj.a.h.h(this.caz.getTalkerUserName(), this.zsO.field_bizChatServId, (int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(31224);
  }
  
  private void dnu()
  {
    AppMethodBeat.i(31213);
    bh.B("bizflag", false);
    Object localObject;
    if (this.muT)
    {
      dHK();
      z.afv();
      localObject = this.zsO;
      if (com.tencent.mm.kernel.a.jM(g.RJ().eHa))
      {
        String str = String.format("%s;%s;%d", new Object[] { ((com.tencent.mm.aj.a.c)localObject).field_brandUserName, ((com.tencent.mm.aj.a.c)localObject).field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000L) });
        aa.b(((com.tencent.mm.aj.a.c)localObject).field_brandUserName, 8, "EnterpriseChatStatus", str);
        ab.d("MicroMsg.BizChatStatusNotifyService", "quitChat:arg:%s", new Object[] { str });
      }
    }
    if (this.zEb != 0L) {}
    for (int i = (int)(System.currentTimeMillis() - this.zEb) / 1000;; i = 0)
    {
      if (aw.RG())
      {
        if (this.muT) {
          z.afk().a(this.ztt);
        }
        if ((this.caz.txj != null) && (this.caz.txj.dwz())) {
          z.afi().a(this.zEk);
        }
        if ((com.tencent.mm.n.a.je(this.caz.txj.field_type)) && (this.caz.txj.dwz()) && (!f.lg(this.caz.getTalkerUserName())))
        {
          if ((this.pyd != null) && (this.pyd.aed()))
          {
            if (this.fwz == null) {
              this.fwz = new caf();
            }
            this.fwz.xLI = i;
            this.fwz.xLM = this.caz.zJz.getIntExtra("Main_IndexInSessionList", 0);
            this.fwz.xLK = this.caz.zJz.getIntExtra("Main_UnreadCount", 0);
            if (this.zEc != null)
            {
              this.fwz.xLL = this.zEc.getType();
              if (this.fwz.xLK > 0) {
                this.fwz.xLJ = ((int)(this.zEb - this.zEc.field_createTime) / 1000);
              }
            }
          }
          z.aft().a(this.caz.getTalkerUserName(), this.fwz);
        }
      }
      if ((com.tencent.mm.app.plugin.a.a.a(this.pyd)) && (this.zEa != null))
      {
        ab.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s, notify exit chattingui", new Object[] { dHF() });
        this.zEa.a(2, this.pyd);
        this.caz.zJz.setMMSubTitle(null);
      }
      if ((com.tencent.mm.n.a.je(this.caz.txj.field_type)) && (this.caz.txj.dwz()) && (i != 0))
      {
        int j = this.caz.zJz.getIntExtra("specific_chat_from_scene", 0);
        int k = s.getSessionId();
        com.tencent.mm.plugin.report.service.h.qsU.e(10638, new Object[] { this.caz.getTalkerUserName(), Integer.valueOf(i), Integer.valueOf(this.caz.zJz.getIntExtra("biz_click_item_unread_count", 0)), Integer.valueOf(this.caz.zJz.getIntExtra("biz_click_item_position", 0)), Integer.valueOf(j), Integer.valueOf(k) });
      }
      if (this.zEa != null)
      {
        localObject = this.zEa;
        ab.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now release the event listener");
        if (((com.tencent.mm.app.plugin.a.a)localObject).caA != null)
        {
          com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.app.plugin.a.a)localObject).caA);
          ((com.tencent.mm.app.plugin.a.a)localObject).caA = null;
          if (((com.tencent.mm.app.plugin.a.a)localObject).caD != null) {
            ((com.tencent.mm.app.plugin.a.a)localObject).caD.clear();
          }
        }
        ((com.tencent.mm.app.plugin.a.a)localObject).caE = false;
        if (((com.tencent.mm.app.plugin.a.a)localObject).caB != null)
        {
          com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.app.plugin.a.a)localObject).caB);
          ((com.tencent.mm.app.plugin.a.a)localObject).caB = null;
        }
        this.zEa = null;
      }
      s.aqU(null);
      this.zEb = 0L;
      AppMethodBeat.o(31213);
      return;
    }
  }
  
  private boolean f(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(31216);
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1) && ((this.pyd == null) || (this.pyd.cU(false) == null) || (this.pyd.cU(false).aeF() == null) || (this.pyd.cU(false).aeF().fvL == null) || (this.pyd.cU(false).aeF().fvL.isEmpty()))) {
      ((com.tencent.mm.ui.chatting.c.b.o)this.caz.ay(com.tencent.mm.ui.chatting.c.b.o.class)).dIg().dof();
    }
    AppMethodBeat.o(31216);
    return false;
  }
  
  public final void a(int paramInt, m paramm)
  {
    AppMethodBeat.i(31219);
    if (paramm.getType() == 1357)
    {
      this.caz.dismissDialog();
      if (paramInt != 0) {
        Toast.makeText(ah.getContext(), this.caz.zJz.getMMResources().getString(2131302675), 0).show();
      }
    }
    AppMethodBeat.o(31219);
  }
  
  public final void aM(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(31222);
    z.afk().aG(dHI());
    LinkedList localLinkedList = new LinkedList();
    List localList = this.zsO.afx();
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((localList != null) && (localList.contains(str))) {
        localLinkedList.add(str);
      }
    }
    if (localLinkedList.size() == 0)
    {
      if (paramLinkedList.size() == 1)
      {
        com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131302694), null, this.caz.zJz.getMMResources().getString(2131302695), new c.2(this));
        AppMethodBeat.o(31222);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131302689), null, this.caz.zJz.getMMResources().getString(2131302695), new c.3(this));
      AppMethodBeat.o(31222);
      return;
    }
    paramLinkedList = this.caz.zJz.getMMResources().getString(2131302688, new Object[] { aN(localLinkedList) });
    com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), paramLinkedList, null, this.caz.zJz.getMMResources().getString(2131302696), this.caz.zJz.getMMResources().getString(2131296888), true, new c.4(this, localLinkedList), new c.5(this));
    AppMethodBeat.o(31222);
  }
  
  public final String atR(String paramString)
  {
    AppMethodBeat.i(31221);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("http://weixin.qq.com/emoticonstore/")))
    {
      paramString = paramString.substring(paramString.lastIndexOf("/") + 1);
      if ((com.tencent.mm.n.a.je(this.caz.txj.field_type)) && (this.caz.txj.dwz()) && (this.pyd != null))
      {
        d.b localb = this.pyd.cU(false);
        if ((localb != null) && (!TextUtils.isEmpty(localb.aeE())) && (paramString.contains(localb.aeE())))
        {
          AppMethodBeat.o(31221);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(31221);
    return null;
  }
  
  public final void dBY()
  {
    boolean bool2 = false;
    AppMethodBeat.i(31227);
    this.zEe = this.caz.zJz.getLongExtra("key_biz_chat_id", -1L);
    this.muT = this.caz.zJz.getBooleanExtra("key_is_biz_chat", false).booleanValue();
    if (this.muT)
    {
      this.zsO = z.afk().aG(this.zEe);
      this.zsO = com.tencent.mm.aj.a.e.a(this.zsO, this.zEe);
      this.zEh = z.afl().gF(dHI()).field_unReadCount;
    }
    boolean bool1 = bool2;
    if (this.muT)
    {
      bool1 = bool2;
      if (com.tencent.mm.aj.a.e.sn(this.zsO.field_bizChatServId)) {
        bool1 = true;
      }
    }
    this.zEd = bool1;
    if ((this.muT) && (!this.zEd))
    {
      this.pzG = z.afm().df(this.zsO.field_bizChatServId);
      this.pzG = com.tencent.mm.aj.a.e.a(this.pzG, this.zsO.field_bizChatServId);
    }
    if (this.zEd) {
      this.zEl = com.tencent.mm.aj.a.e.c(this.zsO);
    }
    this.pyd = f.rS(this.caz.getTalkerUserName());
    this.zEi = true;
    AppMethodBeat.o(31227);
  }
  
  public final void dBZ()
  {
    AppMethodBeat.i(31228);
    this.zEb = System.currentTimeMillis();
    Object localObject = (com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class);
    if (((com.tencent.mm.ui.chatting.c.b.h)localObject).getCount() > 0) {}
    for (localObject = ((com.tencent.mm.ui.chatting.c.b.h)localObject).Pz(((com.tencent.mm.ui.chatting.c.b.h)localObject).getCount() - 1);; localObject = null)
    {
      this.zEc = ((bi)localObject);
      s.aqU(this.caz.getTalkerUserName());
      this.caz.zJz.getLongExtra("key_biz_chat_id", -1L);
      if (this.muT)
      {
        ab.d("MicroMsg.ChattingUI.BizComponent", "getBizChatInfo");
        aw.RO().o(new c.7(this), 500L);
      }
      if ((this.caz.txj != null) && (this.caz.txj.dwz())) {
        z.afu().rw(this.caz.txj.field_username);
      }
      this.zEe = this.caz.zJz.getLongExtra("key_biz_chat_id", -1L);
      if ((com.tencent.mm.app.plugin.a.a.a(this.pyd)) && (this.zEa == null))
      {
        ab.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s", new Object[] { dHF() });
        this.zEa = new com.tencent.mm.app.plugin.a.a(this.caz);
      }
      if (this.caz.txj.dwz()) {
        com.tencent.mm.bf.d.chatType = 2;
      }
      if (this.muT) {
        z.afk().a(this.ztt, Looper.getMainLooper());
      }
      if ((this.caz.txj != null) && (this.caz.txj.dwz())) {
        z.afi().a(this.zEk, Looper.getMainLooper());
      }
      AppMethodBeat.o(31228);
      return;
    }
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(31229);
    if ((com.tencent.mm.n.a.je(this.caz.txj.field_type)) && (this.caz.txj.dwz()) && (com.tencent.mm.n.a.je(this.caz.txj.field_type)) && (this.caz.txj.dwz()) && (!f.lg(this.caz.getTalkerUserName())))
    {
      int i = this.caz.zJz.getIntExtra("specific_chat_from_scene", 0);
      if (this.fwz == null) {
        this.fwz = new caf();
      }
      this.fwz.xLM = this.caz.zJz.getIntExtra("Main_IndexInSessionList", 0);
      this.fwz.xLK = this.caz.zJz.getIntExtra("Main_UnreadCount", 0);
      if (this.zEc != null)
      {
        this.fwz.xLL = this.zEc.getType();
        if (this.fwz.xLK > 0) {
          this.fwz.xLJ = ((int)(this.zEb - this.zEc.field_createTime) / 1000);
        }
      }
      z.aft().a(this.caz.getTalkerUserName(), this.zEc, i, this.fwz);
    }
    AppMethodBeat.o(31229);
  }
  
  public final void dCb()
  {
    AppMethodBeat.i(31230);
    this.zEj = true;
    bh.B("bizflag", ((v)this.caz.ay(v.class)).dIU());
    int i;
    if ((this.pyd != null) && (!com.tencent.mm.app.plugin.a.a.a(this.pyd)))
    {
      this.caz.zJz.setMMSubTitle(null);
      Object localObject1 = this.pyd;
      if ((localObject1 == null) || (localObject1 == null)) {
        break label558;
      }
      localObject1 = ((com.tencent.mm.aj.d)localObject1).cU(false);
      if ((localObject1 == null) || (!((d.b)localObject1).aeq())) {
        break label558;
      }
      i = 1;
      label95:
      if (i != 0) {
        aw.RO().ac(new c.11(this));
      }
      if ((!com.tencent.mm.n.a.je(this.caz.txj.field_type)) || (!this.caz.txj.dwz()) || (this.pyd == null)) {
        break label579;
      }
      localObject1 = this.pyd.cU(false);
      if ((localObject1 != null) && (((d.b)localObject1).aec()))
      {
        if (this.pyd.field_hadAlert != 0) {
          break label563;
        }
        Object localObject2 = this.caz.zJz.getContext().getResources().getString(2131298153, new Object[] { this.caz.txj.Of() });
        String str = this.caz.zJz.getContext().getResources().getString(2131298154);
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append("<sysmsg type=\"reportbizlocation\">");
        ((StringBuffer)localObject1).append("<reportbizlocation>");
        ((StringBuffer)localObject1).append("<text><![CDATA[").append((String)localObject2).append("]]></text>");
        ((StringBuffer)localObject1).append("<link>");
        ((StringBuffer)localObject1).append("<scene>reportbizlocation</scene>");
        ((StringBuffer)localObject1).append("<text><![CDATA[").append(str).append("]]></text>");
        ((StringBuffer)localObject1).append("</link>");
        ((StringBuffer)localObject1).append("</reportbizlocation>");
        ((StringBuffer)localObject1).append("</sysmsg>");
        localObject2 = new bi();
        ((bi)localObject2).kj(this.caz.getTalkerUserName());
        ((bi)localObject2).hL(2);
        ((bi)localObject2).setType(10002);
        ((bi)localObject2).fQ(bf.aaM());
        ((bi)localObject2).setContent(((StringBuffer)localObject1).toString());
        bf.l((bi)localObject2);
        this.pyd.field_hadAlert = 1;
        z.afi().update(this.pyd, new String[0]);
      }
      label413:
      if ((this.pyd.aea()) && ((!this.caz.txj.dwz()) || (!com.tencent.mm.aj.a.adX())))
      {
        ao.a.flI.am(this.caz.txj.field_username, "");
        com.tencent.mm.ah.b.qT(this.caz.txj.field_username);
      }
      if (this.pyd.field_status == 1)
      {
        this.pyd.field_status = 0;
        z.afi().e(this.pyd);
      }
    }
    for (;;)
    {
      dHJ();
      AppMethodBeat.o(31230);
      return;
      ab.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, onresume: %s, notify switch view enter chattingui", new Object[] { dHF() });
      if (this.zEa == null) {
        break;
      }
      this.zEa.a(1, this.pyd);
      break;
      label558:
      i = 0;
      break label95;
      label563:
      z.aft().se(this.caz.getTalkerUserName());
      break label413;
      label579:
      if ((!this.caz.zJz.getBooleanExtra("key_has_add_contact", false).booleanValue()) && (!com.tencent.mm.n.a.je(this.caz.txj.field_type)) && (this.caz.txj.dwz())) {
        al.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(31204);
            if ((!com.tencent.mm.n.a.je(c.this.caz.txj.field_type)) && (c.this.caz.txj.dwz())) {
              c.this.caz.zJz.setMMSubTitle(2131298149);
            }
            AppMethodBeat.o(31204);
          }
        });
      }
    }
  }
  
  public final void dCc()
  {
    AppMethodBeat.i(31231);
    this.zEj = false;
    if ((com.tencent.mm.n.a.je(this.caz.txj.field_type)) && (this.caz.txj.dwz()) && (this.pyd != null))
    {
      z.aft().afa();
      if (this.pzP != null) {
        this.pzP.dismiss();
      }
    }
    AppMethodBeat.o(31231);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31232);
    this.zEi = false;
    dnu();
    AppMethodBeat.o(31232);
  }
  
  public final List<bi> dHA()
  {
    int i = 100;
    AppMethodBeat.i(31212);
    Object localObject = z.afl().gF(dHI());
    if (((com.tencent.mm.aj.a.a)localObject).field_unReadCount > 100) {}
    for (;;)
    {
      aw.aaz();
      localObject = com.tencent.mm.model.c.YD().o(this.caz.txj.field_username, dHI(), i);
      AppMethodBeat.o(31212);
      return localObject;
      i = ((com.tencent.mm.aj.a.a)localObject).field_unReadCount;
    }
  }
  
  public final boolean dHB()
  {
    return this.zEl;
  }
  
  public final void dHC()
  {
    AppMethodBeat.i(31214);
    if (this.pyd == null)
    {
      AppMethodBeat.o(31214);
      return;
    }
    final boolean bool;
    String str;
    if ((!com.tencent.mm.modelgeo.d.agR()) && (!com.tencent.mm.modelgeo.d.agS()))
    {
      bool = true;
      if ((this.pyd.field_hadAlert != 0) || (!bool)) {
        break label144;
      }
      str = this.caz.zJz.getMMResources().getString(2131298151, new Object[] { this.caz.txj.Of() });
    }
    for (;;)
    {
      this.pzP = com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), str, this.caz.zJz.getMMResources().getString(2131297087), new DialogInterface.OnClickListener()new c.14
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(31205);
          c.c(c.this).field_hadAlert = 1;
          paramAnonymousDialogInterface = c.c(c.this);
          if (paramAnonymousDialogInterface != null)
          {
            paramAnonymousDialogInterface.field_brandFlag |= 0x4;
            f.g(paramAnonymousDialogInterface);
          }
          if (bool)
          {
            paramAnonymousDialogInterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            c.this.caz.zJz.startActivity(paramAnonymousDialogInterface);
            AppMethodBeat.o(31205);
            return;
          }
          z.aft().se(c.this.caz.getTalkerUserName());
          AppMethodBeat.o(31205);
        }
      }, new c.14(this));
      AppMethodBeat.o(31214);
      return;
      bool = false;
      break;
      label144:
      if (bool) {
        str = this.caz.zJz.getMMResources().getString(2131298152);
      } else {
        str = this.caz.zJz.getMMResources().getString(2131298150, new Object[] { this.caz.txj.Of() });
      }
    }
  }
  
  public final void dHD()
  {
    AppMethodBeat.i(31215);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", this.caz.getTalkerUserName());
    localIntent.putExtra("key_start_biz_profile_setting_from_scene", 1);
    com.tencent.mm.bq.d.b(this.caz.zJz.getContext(), "profile", ".ui.newbizinfo.NewBizInfoSettingUI", localIntent);
    AppMethodBeat.o(31215);
  }
  
  public final int dHE()
  {
    return this.zEh;
  }
  
  public final String dHF()
  {
    if (this.muT) {
      if (this.zEd) {
        if (this.zsO != null) {}
      }
    }
    while (this.caz.txj == null)
    {
      do
      {
        return null;
        return this.zsO.field_chatName;
      } while (this.pzG == null);
      return this.pzG.field_userName;
    }
    return this.caz.txj.field_nickname;
  }
  
  public final boolean dHG()
  {
    AppMethodBeat.i(31217);
    Intent localIntent1 = new Intent(this.caz.zJz.getContext(), ChatroomInfoUI.class);
    if ((this.caz.dJF()) || (this.zEd)) {}
    for (int i = 1; (i != 0) && (!this.muT); i = 0)
    {
      localIntent1.putExtra("Chat_User", this.caz.txj.field_username);
      localIntent1.putExtra("RoomInfo_Id", this.caz.getTalkerUserName());
      localIntent1.putExtra("Is_Chatroom", this.caz.dJF());
      localIntent1.putExtra("fromChatting", true);
      this.caz.startActivity(localIntent1);
      AppMethodBeat.o(31217);
      return true;
    }
    if (this.muT)
    {
      localIntent1.setClass(this.caz.zJz.getContext(), BizChatroomInfoUI.class);
      localIntent1.putExtra("Chat_User", this.caz.txj.field_username);
      localIntent1.putExtra("key_biz_chat_id", dHI());
      if ((this.caz.zJz.thisActivity() instanceof ChattingUI)) {
        localIntent1.putExtra("key_biz_chat_info_from_scene", 1);
      }
      for (;;)
      {
        this.caz.zJz.startActivity(localIntent1);
        AppMethodBeat.o(31217);
        return true;
        localIntent1.putExtra("key_biz_chat_info_from_scene", 2);
      }
    }
    if ((t.oA(this.caz.getTalkerUserName())) || (ad.arc(this.caz.getTalkerUserName())) || (ad.are(this.caz.getTalkerUserName())) || (t.ow(this.caz.getTalkerUserName())) || (ad.nM(this.caz.getTalkerUserName())) || (this.caz.txj.dwz()))
    {
      localIntent1 = new Intent();
      com.tencent.mm.ui.contact.e.r(localIntent1, this.caz.getTalkerUserName());
      if (this.caz.zJz.getIntExtra("chat_from_scene", 0) == 2)
      {
        localIntent1.putExtra("Kdel_from", 2);
        localIntent1.putExtra("chat_from_scene", this.caz.zJz.getIntExtra("chat_from_scene", 0));
        localIntent1.putExtra("preUsername", this.caz.getTalkerUserName());
        localIntent1.putExtra("preChatName", this.caz.getTalkerUserName());
        if ((this.pyd == null) || (!this.pyd.aed())) {
          break label684;
        }
        i = 6;
        label439:
        localIntent1.putExtra("preChatTYPE", this.caz.zJz.getIntExtra("preChatTYPE", i));
        Intent localIntent2 = this.caz.zJz.getContext().getIntent();
        i = localIntent2.getIntExtra("key_temp_session_scene", 5);
        if ((i != 16) && (i != 17) && (!localIntent2.getBooleanExtra("key_biz_profile_stay_after_follow_op", false))) {
          break label749;
        }
        localIntent1.putExtra("Kdel_from", 1);
      }
    }
    label684:
    label690:
    label749:
    for (boolean bool = true;; bool = false)
    {
      localIntent1.putExtra("key_biz_profile_stay_after_follow_op", bool);
      if ((((v)this.caz.ay(v.class)).dIU()) && (i.atT(this.caz.getTalkerUserName())))
      {
        if (i != 16) {
          break label690;
        }
        localIntent1.putExtra("Contact_Scene", 92);
      }
      for (;;)
      {
        if (this.caz.getTalkerUserName().equals("gh_43f2581f6fd6"))
        {
          com.tencent.mm.plugin.sport.a.d.kS(2);
          com.tencent.mm.plugin.r.a.bWU();
          if (com.tencent.mm.ax.c.lO(com.tencent.mm.ax.b.fKU))
          {
            com.tencent.mm.plugin.r.a.bWS();
            com.tencent.mm.ax.d.lP(com.tencent.mm.ax.b.fKU);
            localIntent1.putExtra("key_from_wesport_right_newtips", true);
          }
        }
        localIntent1.putExtra("KOpenArticleSceneFromScene", 0);
        com.tencent.mm.bq.d.b(this.caz.zJz.getContext(), "profile", ".ui.ContactInfoUI", localIntent1, 213);
        AppMethodBeat.o(31217);
        return true;
        localIntent1.putExtra("Kdel_from", 0);
        break;
        i = 7;
        break label439;
        if (i == 17) {
          localIntent1.putExtra("Contact_Scene", 93);
        } else if (i == 18) {
          localIntent1.putExtra("Contact_Scene", 94);
        } else {
          localIntent1.putExtra("Contact_Scene", 81);
        }
      }
      AppMethodBeat.o(31217);
      return false;
    }
  }
  
  public final boolean dHH()
  {
    int i = 0;
    AppMethodBeat.i(31218);
    if (this.caz == null)
    {
      ab.e("MicroMsg.ChattingUI.BizComponent", "[writeOpLogAndMarkReadTContact] mChattingContext is null!");
      AppMethodBeat.o(31218);
      return false;
    }
    Object localObject1;
    if ((this.caz.txj.dwz()) && (this.pyd != null))
    {
      if (this.muT)
      {
        bool = z.afl().gH(dHI());
        AppMethodBeat.o(31218);
        return bool;
      }
      if (!this.pyd.aeh()) {
        break label240;
      }
      if ((this.pyd.cU(false) != null) && (this.pyd.cU(false).aeI() != null) && (!bo.isNullOrNil(this.pyd.aeo())))
      {
        aw.aaz();
        localObject1 = com.tencent.mm.model.c.YF().arU(this.pyd.aeo());
        if ((localObject1 != null) && (((au)localObject1).field_username.equals(this.caz.getTalkerUserName())) && (((au)localObject1).field_unReadCount > 0))
        {
          if (this.caz.zJz.getIntExtra("chat_from_scene", 0) == 2)
          {
            AppMethodBeat.o(31218);
            return false;
          }
          aw.aaz();
          com.tencent.mm.model.c.YF().arJ(this.pyd.aeo());
        }
      }
    }
    label434:
    while (t.ot(this.caz.getTalkerUserName()))
    {
      AppMethodBeat.o(31218);
      return true;
      label240:
      if ((!this.pyd.aed()) && (!this.pyd.aef())) {
        if (!s.aWl())
        {
          aw.aaz();
          localObject1 = com.tencent.mm.model.c.YF().dxn();
          if ((localObject1 != null) && (((au)localObject1).field_username.equals(this.caz.getTalkerUserName())) && (((au)localObject1).field_unReadCount > 0))
          {
            aw.aaz();
            com.tencent.mm.model.c.YF().arJ("officialaccounts");
          }
        }
        else
        {
          localObject1 = z.afo();
          Object localObject2 = ((com.tencent.mm.storage.r)localObject1).dwc();
          if (localObject2 == null) {}
          for (;;)
          {
            if (i <= 0) {
              break label434;
            }
            localObject1 = z.afo();
            localObject2 = this.caz.getTalkerUserName();
            localObject2 = "update BizTimeLineInfo set hasShow = 1 where hasShow < 1  and talker = '" + (String)localObject2 + "' ";
            ((com.tencent.mm.storage.r)localObject1).fnw.execSQL("BizTimeLineInfo", (String)localObject2);
            localObject2 = new r.a();
            ((r.a)localObject2).ywM = r.b.ywQ;
            ((com.tencent.mm.storage.r)localObject1).a((r.a)localObject2);
            break;
            i = ((com.tencent.mm.storage.r)localObject1).of(((q)localObject2).field_orderFlag);
          }
        }
      }
    }
    aw.aaz();
    boolean bool = com.tencent.mm.model.c.YF().arJ(this.caz.getTalkerUserName());
    AppMethodBeat.o(31218);
    return bool;
  }
  
  public final long dHI()
  {
    if (this.zsO == null) {
      return -1L;
    }
    return this.zsO.field_bizChatLocalId;
  }
  
  public final void dHJ()
  {
    AppMethodBeat.i(31220);
    aw.RO().o(new c.15(this), 500L);
    AppMethodBeat.o(31220);
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31233);
    super.dHq();
    dnu();
    AppMethodBeat.o(31233);
  }
  
  public final com.tencent.mm.aj.d dHs()
  {
    return this.pyd;
  }
  
  public final com.tencent.mm.aj.a.c dHt()
  {
    return this.zsO;
  }
  
  public final j dHu()
  {
    return this.pzG;
  }
  
  public final boolean dHv()
  {
    return this.muT;
  }
  
  public final boolean dHw()
  {
    return this.zEd;
  }
  
  public final boolean dHx()
  {
    AppMethodBeat.i(31210);
    if (this.muT)
    {
      int i;
      if (this.zEd)
      {
        i = com.tencent.mm.aj.a.e.gL(dHI());
        if (bo.isNullOrNil(this.zsO.field_chatName)) {
          if (i == 0) {
            this.caz.zJz.setMMTitle(this.caz.zJz.getMMResources().getString(2131298302));
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(31210);
        return true;
        this.caz.zJz.setMMTitle(this.caz.zJz.getMMResources().getString(2131300029, new Object[] { this.caz.zJz.getMMResources().getString(2131298302), Integer.valueOf(i) }));
        continue;
        ((com.tencent.mm.ui.chatting.c.b.r)this.caz.ay(com.tencent.mm.ui.chatting.c.b.r.class)).setMMTitle(this.caz.zJz.getMMResources().getString(2131300029, new Object[] { this.zsO.field_chatName, Integer.valueOf(i) }));
        continue;
        this.caz.zJz.setMMTitle(this.pzG.field_userName);
      }
    }
    AppMethodBeat.o(31210);
    return false;
  }
  
  public final c.a dHy()
  {
    return this.zxe;
  }
  
  public final ChatFooter.e dHz()
  {
    return this.zwc;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(31226);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31226);
      return;
      if (this.zEa != null)
      {
        paramIntent = this.zEa;
        if (paramIntent.caz == null)
        {
          ab.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null, maybe has been released");
          AppMethodBeat.o(31226);
          return;
        }
        if (paramInt2 == -1)
        {
          Toast.makeText(paramIntent.caz.zJz.getContext(), 2131299431, 0).show();
          ee localee = new ee();
          localee.crV.op = 0;
          localee.crV.userName = paramIntent.caz.getTalkerUserName();
          localee.crV.context = paramIntent.caz.zJz.getContext();
          com.tencent.mm.sdk.b.a.ymk.l(localee);
          AppMethodBeat.o(31226);
          return;
        }
        if (paramInt2 == 0) {
          Toast.makeText(paramIntent.caz.zJz.getContext(), 2131299430, 0).show();
        }
      }
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(31225);
    boolean bool = f(paramKeyEvent);
    AppMethodBeat.o(31225);
    return bool;
  }
  
  public final String sp(String paramString)
  {
    AppMethodBeat.i(31211);
    paramString = this.zsO.sj(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_headImageUrl;
      AppMethodBeat.o(31211);
      return paramString;
    }
    AppMethodBeat.o(31211);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.c
 * JD-Core Version:    0.7.0.1
 */