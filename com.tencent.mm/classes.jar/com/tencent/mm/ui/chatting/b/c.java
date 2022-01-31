package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.ai.a.d.a;
import com.tencent.mm.ai.a.j;
import com.tencent.mm.ai.a.v;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.d.b.c;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.h.a.eb;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bf;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.r.a;
import com.tencent.mm.storage.r.b;
import com.tencent.mm.ui.bizchat.BizChatroomInfoUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.b.b.q;
import com.tencent.mm.ui.chatting.b.b.u;
import com.tencent.mm.ui.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.chatting.b.a.a(cFA=com.tencent.mm.ui.chatting.b.b.c.class)
public class c
  extends a
  implements com.tencent.mm.ai.n, com.tencent.mm.ui.chatting.b.b.c
{
  public boolean kax = false;
  private com.tencent.mm.ai.d mVy;
  public j mWL;
  private com.tencent.mm.ui.widget.a.c mWU = null;
  private d.a veU = new c.9(this);
  public com.tencent.mm.ai.a.c veo;
  protected final ChatFooter.e vhh = new c.8(this);
  protected final c.a vik = new c.1(this);
  private com.tencent.mm.app.plugin.a.a voA;
  private long voB = 0L;
  public boolean voC = false;
  private long voD = -1L;
  private RelativeLayout voE;
  private TextView voF;
  private int voG;
  private boolean voH = false;
  private e.a voI = new c.10(this);
  private boolean voJ = false;
  
  private String aD(LinkedList<String> paramLinkedList)
  {
    if (paramLinkedList.size() <= 0) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(this.veo.gV((String)paramLinkedList.get(0)));
    int i = 1;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append(this.byx.vtz.getContext().getString(R.l.chatroom_sys_msg_invite_split)).append(this.veo.gV((String)paramLinkedList.get(i)));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean aq(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("Chat_User");
    boolean bool = paramIntent.getBooleanExtra("key_is_biz_chat", false);
    if ((!bool) && (str == null))
    {
      y.e("MicroMsg.ChattingUI.BizComponent", "talker is null !!!");
      return true;
    }
    if ((bool) && (paramIntent.getLongExtra("key_biz_chat_id", -1L) == -1L))
    {
      y.e("MicroMsg.ChattingUI.BizComponent", "bizChatId is null !!");
      return true;
    }
    return false;
  }
  
  private void cDU()
  {
    if (!this.kax) {
      return;
    }
    com.tencent.mm.ai.z.MG();
    v localv = new v(this.byx.getTalkerUserName(), this.veo.field_bizChatServId, (int)(System.currentTimeMillis() / 1000L));
    com.tencent.mm.kernel.g.DO().dJT.a(localv, 0);
  }
  
  private boolean f(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1) && ((this.mVy == null) || (this.mVy.bS(false) == null) || (this.mVy.bS(false).LY() == null) || (this.mVy.bS(false).LY().efJ == null) || (this.mVy.bS(false).LY().efJ.isEmpty()))) {
      ((com.tencent.mm.ui.chatting.b.b.n)this.byx.ac(com.tencent.mm.ui.chatting.b.b.n.class)).cEq().cnd();
    }
    return false;
  }
  
  public final void a(int paramInt, m paramm)
  {
    if (paramm.getType() == 1357)
    {
      this.byx.dismissDialog();
      if (paramInt != 0) {
        Toast.makeText(ae.getContext(), this.byx.vtz.getMMResources().getString(R.l.room_change_fail), 0).show();
      }
    }
  }
  
  public final void aC(LinkedList<String> paramLinkedList)
  {
    com.tencent.mm.ai.z.MA().aj(cDS());
    LinkedList localLinkedList = new LinkedList();
    List localList = this.veo.MN();
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
        com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.room_delete_member_deleted), null, this.byx.vtz.getMMResources().getString(R.l.room_delete_member_got_it), new c.2(this));
        return;
      }
      com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.room_delete_member_all_left), null, this.byx.vtz.getMMResources().getString(R.l.room_delete_member_got_it), new c.3(this));
      return;
    }
    paramLinkedList = this.byx.vtz.getMMResources().getString(R.l.room_delete_member_alert, new Object[] { aD(localLinkedList) });
    com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), paramLinkedList, null, this.byx.vtz.getMMResources().getString(R.l.room_delete_member_remove_it), this.byx.vtz.getMMResources().getString(R.l.app_cancel), true, new c.4(this, localLinkedList), new c.5(this));
  }
  
  public final String adq(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("http://weixin.qq.com/emoticonstore/")))
    {
      paramString = paramString.substring(paramString.lastIndexOf("/") + 1);
      if ((com.tencent.mm.n.a.gR(this.byx.pSb.field_type)) && (this.byx.pSb.cua()) && (this.mVy != null))
      {
        d.b localb = this.mVy.bS(false);
        if ((localb != null) && (!TextUtils.isEmpty(localb.LX())) && (paramString.contains(localb.LX()))) {
          return paramString;
        }
      }
    }
    return null;
  }
  
  public final com.tencent.mm.ai.d cDD()
  {
    return this.mVy;
  }
  
  public final com.tencent.mm.ai.a.c cDE()
  {
    return this.veo;
  }
  
  public final j cDF()
  {
    return this.mWL;
  }
  
  public final boolean cDG()
  {
    return this.kax;
  }
  
  public final boolean cDH()
  {
    return this.voC;
  }
  
  public final boolean cDI()
  {
    if (this.kax)
    {
      int i;
      if (this.voC)
      {
        i = com.tencent.mm.ai.a.e.bQ(cDS());
        if (bk.bl(this.veo.field_chatName)) {
          if (i == 0) {
            this.byx.vtz.setMMTitle(this.byx.vtz.getMMResources().getString(R.l.chatting_roominfo_noname));
          }
        }
      }
      for (;;)
      {
        return true;
        this.byx.vtz.setMMTitle(this.byx.vtz.getMMResources().getString(R.l.fmt_chatting_title_group, new Object[] { this.byx.vtz.getMMResources().getString(R.l.chatting_roominfo_noname), Integer.valueOf(i) }));
        continue;
        ((q)this.byx.ac(q.class)).N(this.byx.vtz.getMMResources().getString(R.l.fmt_chatting_title_group, new Object[] { this.veo.field_chatName, Integer.valueOf(i) }));
        continue;
        this.byx.vtz.setMMTitle(this.mWL.field_userName);
      }
    }
    return false;
  }
  
  public final c.a cDJ()
  {
    return this.vik;
  }
  
  public final ChatFooter.e cDK()
  {
    return this.vhh;
  }
  
  public final List<bi> cDL()
  {
    int i = 100;
    com.tencent.mm.ai.a.a locala = com.tencent.mm.ai.z.MB().bK(cDS());
    if (locala.field_unReadCount > 100) {}
    for (;;)
    {
      au.Hx();
      return com.tencent.mm.model.c.Fz().k(this.byx.pSb.field_username, cDS(), i);
      i = locala.field_unReadCount;
    }
  }
  
  public final boolean cDM()
  {
    return this.voJ;
  }
  
  public final void cDN()
  {
    if (this.mVy == null) {
      return;
    }
    boolean bool;
    String str;
    if ((!com.tencent.mm.modelgeo.c.Oc()) && (!com.tencent.mm.modelgeo.c.Od()))
    {
      bool = true;
      if ((this.mVy.field_hadAlert != 0) || (!bool)) {
        break label127;
      }
      str = this.byx.vtz.getMMResources().getString(R.l.chatting_biz_report_location_confirm_nogps, new Object[] { this.byx.pSb.Bq() });
    }
    for (;;)
    {
      this.mWU = com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), str, this.byx.vtz.getMMResources().getString(R.l.app_tip), new c.13(this, bool), new c.14(this));
      return;
      bool = false;
      break;
      label127:
      if (bool) {
        str = this.byx.vtz.getMMResources().getString(R.l.chatting_biz_report_location_need_gps);
      } else {
        str = this.byx.vtz.getMMResources().getString(R.l.chatting_biz_report_location_confirm, new Object[] { this.byx.pSb.Bq() });
      }
    }
  }
  
  public final int cDO()
  {
    return this.voG;
  }
  
  public final String cDP()
  {
    if (this.kax) {
      if (this.voC) {
        if (this.veo != null) {}
      }
    }
    while (this.byx.pSb == null)
    {
      do
      {
        return null;
        return this.veo.field_chatName;
      } while (this.mWL == null);
      return this.mWL.field_userName;
    }
    return this.byx.pSb.field_nickname;
  }
  
  public final boolean cDQ()
  {
    Intent localIntent1 = new Intent(this.byx.vtz.getContext(), ChatroomInfoUI.class);
    if ((this.byx.cFD()) || (this.voC)) {}
    for (int i = 1; (i != 0) && (!this.kax); i = 0)
    {
      localIntent1.putExtra("Chat_User", this.byx.pSb.field_username);
      localIntent1.putExtra("RoomInfo_Id", this.byx.getTalkerUserName());
      localIntent1.putExtra("Is_Chatroom", this.byx.cFD());
      localIntent1.putExtra("fromChatting", true);
      this.byx.startActivity(localIntent1);
      return true;
    }
    if (this.kax)
    {
      localIntent1.setClass(this.byx.vtz.getContext(), BizChatroomInfoUI.class);
      localIntent1.putExtra("Chat_User", this.byx.pSb.field_username);
      localIntent1.putExtra("key_biz_chat_id", cDS());
      if ((this.byx.vtz.thisActivity() instanceof ChattingUI)) {
        localIntent1.putExtra("key_biz_chat_info_from_scene", 1);
      }
      for (;;)
      {
        this.byx.vtz.startActivity(localIntent1);
        return true;
        localIntent1.putExtra("key_biz_chat_info_from_scene", 2);
      }
    }
    if ((com.tencent.mm.model.s.hR(this.byx.getTalkerUserName())) || (ad.aaR(this.byx.getTalkerUserName())) || (ad.aaT(this.byx.getTalkerUserName())) || (com.tencent.mm.model.s.hN(this.byx.getTalkerUserName())) || (ad.hd(this.byx.getTalkerUserName())) || (this.byx.pSb.cua()))
    {
      localIntent1 = new Intent();
      com.tencent.mm.ui.contact.e.m(localIntent1, this.byx.getTalkerUserName());
      if (this.byx.vtz.getIntExtra("chat_from_scene", 0) == 2)
      {
        localIntent1.putExtra("Kdel_from", 2);
        localIntent1.putExtra("chat_from_scene", this.byx.vtz.getIntExtra("chat_from_scene", 0));
        Intent localIntent2 = this.byx.vtz.getContext().getIntent();
        i = localIntent2.getIntExtra("key_temp_session_scene", 5);
        if ((i != 16) && (i != 17) && (!localIntent2.getBooleanExtra("key_biz_profile_stay_after_follow_op", false))) {
          break label641;
        }
        localIntent1.putExtra("Kdel_from", 1);
      }
    }
    label641:
    for (boolean bool = true;; bool = false)
    {
      localIntent1.putExtra("key_biz_profile_stay_after_follow_op", bool);
      if ((((u)this.byx.ac(u.class)).cFc()) && (i.ads(this.byx.getTalkerUserName())))
      {
        if (i != 16) {
          break label588;
        }
        localIntent1.putExtra("Contact_Scene", 92);
      }
      for (;;)
      {
        if (this.byx.getTalkerUserName().equals("gh_43f2581f6fd6"))
        {
          com.tencent.mm.plugin.sport.b.d.jdMethod_if(2);
          com.tencent.mm.plugin.y.a.bov();
          if (com.tencent.mm.aw.c.iW(com.tencent.mm.aw.b.evh))
          {
            com.tencent.mm.plugin.y.a.bot();
            com.tencent.mm.aw.d.iX(com.tencent.mm.aw.b.evh);
            localIntent1.putExtra("key_from_wesport_right_newtips", true);
          }
        }
        localIntent1.putExtra("KOpenArticleSceneFromScene", 0);
        com.tencent.mm.br.d.b(this.byx.vtz.getContext(), "profile", ".ui.ContactInfoUI", localIntent1, 213);
        return true;
        localIntent1.putExtra("Kdel_from", 0);
        break;
        label588:
        if (i == 17) {
          localIntent1.putExtra("Contact_Scene", 93);
        } else if (i == 18) {
          localIntent1.putExtra("Contact_Scene", 94);
        } else {
          localIntent1.putExtra("Contact_Scene", 81);
        }
      }
      return false;
    }
  }
  
  public final boolean cDR()
  {
    if (this.byx == null) {
      y.e("MicroMsg.ChattingUI.BizComponent", "[writeOpLogAndMarkReadTContact] mChattingContext is null!");
    }
    Object localObject1;
    do
    {
      return false;
      if ((!this.byx.pSb.cua()) || (this.mVy == null)) {
        break;
      }
      if (this.kax) {
        return com.tencent.mm.ai.z.MB().bM(cDS());
      }
      if (!this.mVy.Lz()) {
        break label204;
      }
      if ((this.mVy.bS(false) == null) || (this.mVy.bS(false).Mb() == null) || (bk.bl(this.mVy.LG()))) {
        break;
      }
      au.Hx();
      localObject1 = com.tencent.mm.model.c.FB().abK(this.mVy.LG());
      if ((localObject1 == null) || (!((as)localObject1).field_username.equals(this.byx.getTalkerUserName())) || (((as)localObject1).field_unReadCount <= 0)) {
        break;
      }
    } while (this.byx.vtz.getIntExtra("chat_from_scene", 0) == 2);
    au.Hx();
    com.tencent.mm.model.c.FB().abx(this.mVy.LG());
    while (com.tencent.mm.model.s.hK(this.byx.getTalkerUserName()))
    {
      return true;
      label204:
      if ((!this.mVy.Lv()) && (!this.mVy.Lx())) {
        if (!com.tencent.mm.storage.s.ctL())
        {
          au.Hx();
          localObject1 = com.tencent.mm.model.c.FB().cuN();
          if ((localObject1 != null) && (((as)localObject1).field_username.equals(this.byx.getTalkerUserName())) && (((as)localObject1).field_unReadCount > 0))
          {
            au.Hx();
            com.tencent.mm.model.c.FB().abx("officialaccounts");
          }
        }
        else if (com.tencent.mm.ai.z.ME().ctF() > 0)
        {
          localObject1 = com.tencent.mm.ai.z.ME();
          Object localObject2 = this.byx.getTalkerUserName();
          localObject2 = "update BizTimeLineInfo set hasShow = 1 where hasShow != 1  and talker = '" + (String)localObject2 + "' ";
          ((r)localObject1).dXo.gk("BizTimeLineInfo", (String)localObject2);
          localObject2 = new r.a();
          ((r.a)localObject2).unb = r.b.unf;
          ((r)localObject1).b((r.a)localObject2);
        }
      }
    }
    au.Hx();
    return com.tencent.mm.model.c.FB().abx(this.byx.getTalkerUserName());
  }
  
  public final long cDS()
  {
    if (this.veo == null) {
      return -1L;
    }
    return this.veo.field_bizChatLocalId;
  }
  
  public final void cDT()
  {
    au.DS().k(new c.15(this), 500L);
  }
  
  public final void cyM()
  {
    boolean bool2 = false;
    this.voD = this.byx.vtz.getLongExtra("key_biz_chat_id", -1L);
    this.kax = this.byx.vtz.getBooleanExtra("key_is_biz_chat", false).booleanValue();
    if (this.kax)
    {
      this.veo = com.tencent.mm.ai.z.MA().aj(this.voD);
      this.veo = com.tencent.mm.ai.a.e.a(this.veo, this.voD);
      this.voG = com.tencent.mm.ai.z.MB().bK(cDS()).field_unReadCount;
    }
    boolean bool1 = bool2;
    if (this.kax)
    {
      bool1 = bool2;
      if (com.tencent.mm.ai.a.e.lr(this.veo.field_bizChatServId)) {
        bool1 = true;
      }
    }
    this.voC = bool1;
    if ((this.kax) && (!this.voC))
    {
      this.mWL = com.tencent.mm.ai.z.MC().bY(this.veo.field_bizChatServId);
      this.mWL = com.tencent.mm.ai.a.e.a(this.mWL, this.veo.field_bizChatServId);
    }
    if (this.voC) {
      this.voJ = com.tencent.mm.ai.a.e.c(this.veo);
    }
    this.mVy = f.kX(this.byx.getTalkerUserName());
  }
  
  public final void cyN()
  {
    this.voB = System.currentTimeMillis();
    com.tencent.mm.storage.s.aaK(this.byx.getTalkerUserName());
    this.byx.vtz.getLongExtra("key_biz_chat_id", -1L);
    if (this.kax)
    {
      y.d("MicroMsg.ChattingUI.BizComponent", "getBizChatInfo");
      au.DS().k(new c.7(this), 500L);
    }
    if ((this.byx.pSb != null) && (this.byx.pSb.cua())) {
      com.tencent.mm.ai.z.MK().kC(this.byx.pSb.field_username);
    }
    this.voD = this.byx.vtz.getLongExtra("key_biz_chat_id", -1L);
    if ((com.tencent.mm.app.plugin.a.a.a(this.mVy)) && (this.voA == null))
    {
      y.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s", new Object[] { cDP() });
      this.voA = new com.tencent.mm.app.plugin.a.a(this.byx);
    }
    if (this.byx.pSb.cua()) {
      com.tencent.mm.be.d.chatType = 2;
    }
    if (this.kax) {
      com.tencent.mm.ai.z.MA().a(this.veU, Looper.getMainLooper());
    }
    if ((this.byx.pSb != null) && (this.byx.pSb.cua())) {
      com.tencent.mm.ai.z.My().a(this.voI, Looper.getMainLooper());
    }
  }
  
  public final void cyO()
  {
    if ((com.tencent.mm.n.a.gR(this.byx.pSb.field_type)) && (this.byx.pSb.cua()) && (com.tencent.mm.n.a.gR(this.byx.pSb.field_type)) && (this.byx.pSb.cua()) && (!f.eW(this.byx.getTalkerUserName())))
    {
      localObject = (com.tencent.mm.ui.chatting.b.b.g)this.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class);
      if (((com.tencent.mm.ui.chatting.b.b.g)localObject).getCount() <= 0) {
        break label140;
      }
    }
    label140:
    for (Object localObject = ((com.tencent.mm.ui.chatting.b.b.g)localObject).GW(((com.tencent.mm.ui.chatting.b.b.g)localObject).getCount() - 1);; localObject = null)
    {
      int i = this.byx.vtz.getIntExtra("specific_chat_from_scene", 0);
      com.tencent.mm.ai.z.MJ().a(this.byx.getTalkerUserName(), (bi)localObject, i);
      return;
    }
  }
  
  public final void cyP()
  {
    this.voH = true;
    bf.x("bizflag", ((u)this.byx.ac(u.class)).cFc());
    int i;
    if ((this.mVy != null) && (!com.tencent.mm.app.plugin.a.a.a(this.mVy)))
    {
      this.byx.vtz.setMMSubTitle(null);
      Object localObject1 = this.mVy;
      if ((localObject1 == null) || (localObject1 == null)) {
        break label546;
      }
      localObject1 = ((com.tencent.mm.ai.d)localObject1).bS(false);
      if ((localObject1 == null) || (!((d.b)localObject1).LI())) {
        break label546;
      }
      i = 1;
      label89:
      if (i != 0) {
        au.DS().O(new c.11(this));
      }
      if ((!com.tencent.mm.n.a.gR(this.byx.pSb.field_type)) || (!this.byx.pSb.cua()) || (this.mVy == null)) {
        break label567;
      }
      localObject1 = this.mVy.bS(false);
      if ((localObject1 != null) && (((d.b)localObject1).Lu()))
      {
        if (this.mVy.field_hadAlert != 0) {
          break label551;
        }
        Object localObject2 = this.byx.vtz.getContext().getResources().getString(R.l.chatting_biz_report_location_sys_msg, new Object[] { this.byx.pSb.Bq() });
        String str = this.byx.vtz.getContext().getResources().getString(R.l.chatting_biz_report_location_sys_msg_link);
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
        ((bi)localObject2).ec(this.byx.getTalkerUserName());
        ((bi)localObject2).fA(2);
        ((bi)localObject2).setType(10002);
        ((bi)localObject2).bg(bd.HM());
        ((bi)localObject2).setContent(((StringBuffer)localObject1).toString());
        bd.h((bi)localObject2);
        this.mVy.field_hadAlert = 1;
        com.tencent.mm.ai.z.My().c(this.mVy, new String[0]);
      }
      label407:
      if ((this.mVy.Ls()) && ((!this.byx.pSb.cua()) || (!com.tencent.mm.ai.a.Lp())))
      {
        am.a.dVy.V(this.byx.pSb.field_username, "");
        com.tencent.mm.ag.b.ka(this.byx.pSb.field_username);
      }
      if (this.mVy.field_status == 1)
      {
        this.mVy.field_status = 0;
        com.tencent.mm.ai.z.My().e(this.mVy);
      }
    }
    for (;;)
    {
      cDT();
      return;
      y.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, onresume: %s, notify switch view enter chattingui", new Object[] { cDP() });
      if (this.voA == null) {
        break;
      }
      this.voA.a(1, this.mVy);
      break;
      label546:
      i = 0;
      break label89;
      label551:
      com.tencent.mm.ai.z.MJ().lj(this.byx.getTalkerUserName());
      break label407;
      label567:
      if ((!this.byx.vtz.getBooleanExtra("key_has_add_contact", false).booleanValue()) && (!com.tencent.mm.n.a.gR(this.byx.pSb.field_type)) && (this.byx.pSb.cua())) {
        ai.d(new c.12(this));
      }
    }
  }
  
  public final void cyQ()
  {
    this.voH = false;
    if ((com.tencent.mm.n.a.gR(this.byx.pSb.field_type)) && (this.byx.pSb.cua()) && (this.mVy != null))
    {
      com.tencent.mm.ai.z.MJ().Mr();
      if (this.mWU != null) {
        this.mWU.dismiss();
      }
    }
  }
  
  public final void cyR()
  {
    bf.x("bizflag", false);
    Object localObject;
    if (this.kax)
    {
      cDU();
      com.tencent.mm.ai.z.ML();
      localObject = this.veo;
      if (com.tencent.mm.kernel.a.hw(com.tencent.mm.kernel.g.DN().dJB))
      {
        String str = String.format("%s;%s;%d", new Object[] { ((com.tencent.mm.ai.a.c)localObject).field_brandUserName, ((com.tencent.mm.ai.a.c)localObject).field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000L) });
        com.tencent.mm.modelsimple.z.b(((com.tencent.mm.ai.a.c)localObject).field_brandUserName, 8, "EnterpriseChatStatus", str);
        y.d("MicroMsg.BizChatStatusNotifyService", "quitChat:arg:%s", new Object[] { str });
      }
    }
    if (au.DK())
    {
      if (this.kax) {
        com.tencent.mm.ai.z.MA().a(this.veU);
      }
      if ((this.byx.pSb != null) && (this.byx.pSb.cua())) {
        com.tencent.mm.ai.z.My().a(this.voI);
      }
      if ((com.tencent.mm.n.a.gR(this.byx.pSb.field_type)) && (this.byx.pSb.cua()) && (!f.eW(this.byx.getTalkerUserName())))
      {
        com.tencent.mm.ai.z.MJ();
        com.tencent.mm.ai.k.li(this.byx.getTalkerUserName());
      }
    }
    if ((com.tencent.mm.app.plugin.a.a.a(this.mVy)) && (this.voA != null))
    {
      y.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s, notify exit chattingui", new Object[] { cDP() });
      this.voA.a(2, this.mVy);
      this.byx.vtz.setMMSubTitle(null);
    }
    if ((com.tencent.mm.n.a.gR(this.byx.pSb.field_type)) && (this.byx.pSb.cua()) && (this.voB != 0L))
    {
      int i = this.byx.vtz.getIntExtra("specific_chat_from_scene", 0);
      int j = com.tencent.mm.storage.s.getSessionId();
      com.tencent.mm.plugin.report.service.h.nFQ.f(10638, new Object[] { this.byx.getTalkerUserName(), Integer.valueOf((int)(System.currentTimeMillis() - this.voB) / 1000), Integer.valueOf(this.byx.vtz.getIntExtra("biz_click_item_unread_count", 0)), Integer.valueOf(this.byx.vtz.getIntExtra("biz_click_item_position", 0)), Integer.valueOf(i), Integer.valueOf(j) });
      this.voB = 0L;
    }
    if (this.voA != null)
    {
      localObject = this.voA;
      y.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now release the event listener");
      if (((com.tencent.mm.app.plugin.a.a)localObject).byy != null)
      {
        com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.app.plugin.a.a)localObject).byy);
        ((com.tencent.mm.app.plugin.a.a)localObject).byy = null;
        if (((com.tencent.mm.app.plugin.a.a)localObject).byB != null) {
          ((com.tencent.mm.app.plugin.a.a)localObject).byB.clear();
        }
      }
      ((com.tencent.mm.app.plugin.a.a)localObject).byC = false;
      if (((com.tencent.mm.app.plugin.a.a)localObject).byz != null)
      {
        com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.app.plugin.a.a)localObject).byz);
        ((com.tencent.mm.app.plugin.a.a)localObject).byz = null;
      }
      this.voA = null;
    }
    com.tencent.mm.storage.s.aaK(null);
  }
  
  public final String lt(String paramString)
  {
    paramString = this.veo.lo(paramString);
    if (paramString != null) {
      return paramString.field_headImageUrl;
    }
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.voA == null);
      paramIntent = this.voA;
      if (paramIntent.byx == null)
      {
        y.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null, maybe has been released");
        return;
      }
      if (paramInt2 == -1)
      {
        Toast.makeText(paramIntent.byx.vtz.getContext(), R.l.exdevice_open_bt_success, 0).show();
        eb localeb = new eb();
        localeb.bKB.op = 0;
        localeb.bKB.userName = paramIntent.byx.getTalkerUserName();
        localeb.bKB.context = paramIntent.byx.vtz.getContext();
        com.tencent.mm.sdk.b.a.udP.m(localeb);
        return;
      }
    } while (paramInt2 != 0);
    Toast.makeText(paramIntent.byx.vtz.getContext(), R.l.exdevice_open_bt_failed, 0).show();
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return f(paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.c
 * JD-Core Version:    0.7.0.1
 */