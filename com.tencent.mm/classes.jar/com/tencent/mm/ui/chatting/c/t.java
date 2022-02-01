package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.c;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.a.rf;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.ce;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooterBottom;
import com.tencent.mm.pluginsdk.ui.chat.a.a;
import com.tencent.mm.pluginsdk.ui.chat.a.b;
import com.tencent.mm.pluginsdk.ui.chat.a.c;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.c.b.ag;
import com.tencent.mm.ui.chatting.c.b.q;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.c.a.a(eYT=q.class)
public class t
  extends a
  implements k.a, n.b, q
{
  private static ArrayList<a.a> GuC = null;
  private static long GuD = 0L;
  private final ChatFooter.g CbR;
  private com.tencent.mm.ui.chatting.p GuE;
  protected ChatFooterCustom GuF;
  private int GuG;
  private com.tencent.mm.ui.chatting.t GuH;
  private com.tencent.mm.ui.chatting.w GuI;
  private com.tencent.mm.ui.chatting.h GuJ;
  private AnimationSet GuK;
  private String GuL;
  private int GuM;
  private int GuN;
  private boolean GuO;
  public boolean GuP;
  private boolean GuQ;
  public boolean GuR;
  private long GuS;
  private com.tencent.mm.sdk.b.c fpB;
  private com.tencent.mm.sdk.b.c fpC;
  protected ChatFooter twb;
  
  public t()
  {
    AppMethodBeat.i(35314);
    this.GuG = 0;
    this.GuL = null;
    this.GuO = false;
    this.GuP = false;
    this.fpB = new com.tencent.mm.sdk.b.c() {};
    this.fpC = new com.tencent.mm.sdk.b.c() {};
    this.CbR = new ChatFooter.g()
    {
      private Animation GuU;
      private Animation GuV;
      
      public final boolean us(boolean paramAnonymousBoolean)
      {
        int i = 1;
        AppMethodBeat.i(35305);
        if (this.GuU == null)
        {
          this.GuU = AnimationUtils.loadAnimation(t.this.cOd.GzJ.getContext(), 2130772108);
          this.GuV = AnimationUtils.loadAnimation(t.this.cOd.GzJ.getContext(), 2130772106);
        }
        com.tencent.mm.ui.chatting.c.b.d locald;
        String str;
        if (paramAnonymousBoolean)
        {
          ad.i("MicroMsg.ChattingUI.FootComponent", "switchFooterToInput customFooter is %s", new Object[] { t.this.GuF });
          if (t.this.GuF != null) {
            t.this.GuF.startAnimation(this.GuV);
          }
          t.this.eXy();
          t.this.twb.startAnimation(this.GuU);
          t.this.twb.postInvalidateDelayed(this.GuU.getDuration());
          locald = (com.tencent.mm.ui.chatting.c.b.d)t.this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class);
          if (locald != null)
          {
            str = t.this.cOd.getTalkerUserName();
            if (!paramAnonymousBoolean) {
              break label262;
            }
          }
        }
        for (;;)
        {
          locald.fX(str, i);
          AppMethodBeat.o(35305);
          return false;
          t.this.twb.startAnimation(this.GuV);
          t.this.eXx();
          if (t.this.GuF == null) {
            break;
          }
          t.this.GuF.startAnimation(this.GuU);
          t.this.GuF.postInvalidateDelayed(this.GuU.getDuration());
          break;
          label262:
          i = 2;
        }
      }
    };
    this.GuQ = false;
    this.GuR = false;
    this.GuS = 0L;
    AppMethodBeat.o(35314);
  }
  
  private void a(final String paramString, final ar.b.a parama)
  {
    AppMethodBeat.i(163315);
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184961);
        ar.a.gMW.a(paramString, "", parama);
        AppMethodBeat.o(184961);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(184962);
        String str = super.toString() + "|getContactCallBack2";
        AppMethodBeat.o(184962);
        return str;
      }
    });
    AppMethodBeat.o(163315);
  }
  
  private void a(String paramString, com.tencent.mm.storage.af paramaf, ArrayList<a.a> paramArrayList)
  {
    AppMethodBeat.i(163316);
    long l1;
    if (paramaf == null)
    {
      l1 = 0L;
      ad.i("MicroMsg.ChattingUI.FootComponent", "ChatroomBusinessType user %s %s", new Object[] { paramString, Long.valueOf(l1) });
      if ((!this.cOd.eZa()) || (paramaf == null) || (paramaf.evU == 0L)) {
        break label222;
      }
      if (GuC != null) {
        break label166;
      }
      GuC = new ArrayList();
      eXE();
      GuD = ce.asQ();
    }
    for (;;)
    {
      paramString = GuC;
      if ((paramString == null) || (paramString.size() <= 0)) {
        break label222;
      }
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        a.a locala = (a.a)paramString.next();
        if ((locala.Cbt & paramaf.evU) != 0L)
        {
          locala.iJl = paramaf.field_username;
          paramArrayList.add(locala);
        }
      }
      l1 = paramaf.evU;
      break;
      label166:
      l1 = ce.asQ();
      long l2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.puU, 1800);
      if (l1 - GuD > l2)
      {
        GuD = l1;
        GuC.clear();
        eXE();
      }
    }
    label222:
    this.twb.setAppPanelUnCertainEnterArrayList(paramArrayList);
    AppMethodBeat.o(163316);
  }
  
  private void aKI(final String paramString)
  {
    AppMethodBeat.i(35325);
    ad.i("MicroMsg.ChattingUI.FootComponent", "initFooterPanelMenu %s", new Object[] { paramString });
    this.twb.ezc();
    this.twb.eyT();
    int i;
    Object localObject1;
    int j;
    label126:
    boolean bool1;
    if (((com.tencent.mm.ui.chatting.c.b.j)this.cOd.be(com.tencent.mm.ui.chatting.c.b.j.class)).eXi())
    {
      ad.w("MicroMsg.ChattingUI.FootComponent", "match shake, in show mode, do not open short video recode view");
      i = 0;
      if (i == 0) {
        this.twb.eze();
      }
      if (((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWC())
      {
        localObject1 = com.tencent.mm.am.f.ei(this.cOd.getTalkerUserName());
        if ((localObject1 != null) && (((com.tencent.mm.api.c)localObject1).field_enterpriseFather != null)) {
          break label2223;
        }
        j = 0;
        if (j != 0)
        {
          localObject1 = this.twb.Cbx;
          ((AppPanel)localObject1).Cal.Cbc.value = true;
          ((AppPanel)localObject1).eyE();
        }
      }
      if (!this.cOd.eZb()) {
        this.twb.ezl();
      }
      bool1 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.KEg, true);
      localObject1 = this.twb;
      if (!com.tencent.mm.sdk.platformtools.h.DEBUG) {
        break label2277;
      }
      i = 1;
      label206:
      ad.i("MicroMsg.ChattingUI.FootComponent", "isGroupChat:%b enableLive:%b", new Object[] { Boolean.valueOf(this.cOd.eZb()), Boolean.valueOf(bool1) });
      if ((this.cOd.eZb()) && (bool1) && (i != 0)) {
        break label2505;
      }
      this.twb.Cbx.fZG();
      label268:
      if ((this.cOd.zgX != null) && (!com.tencent.mm.n.b.ls(this.cOd.zgX.field_type)) && (!com.tencent.mm.model.w.pF(this.cOd.getTalkerUserName()))) {
        this.twb.ezh();
      }
      if (com.tencent.mm.storage.af.st(paramString))
      {
        this.twb.Cbx.eyw();
        this.twb.Cbx.eyy();
        this.twb.Cbx.eyz();
        this.twb.ezf();
        this.twb.ezg();
        this.twb.Cbx.eyx();
        this.twb.aC(true, true);
        this.twb.ezh();
        this.twb.ezj();
        this.twb.Cbx.eyB();
        this.twb.Cbx.fZG();
      }
      if (com.tencent.mm.storage.af.aHG(paramString))
      {
        this.twb.Cbx.eyw();
        this.twb.Cbx.eyy();
        this.twb.Cbx.eyz();
        this.twb.ezf();
        this.twb.ezg();
        this.twb.Cbx.eyx();
        this.twb.aC(true, true);
        this.twb.ezh();
        this.twb.ezj();
        this.twb.Cbx.eyB();
        this.twb.Cbx.fZG();
      }
      if (com.tencent.mm.storage.af.aHE(paramString))
      {
        this.twb.Cbx.eyw();
        this.twb.Cbx.eyy();
        this.twb.Cbx.eyz();
        this.twb.ezf();
        this.twb.ezb();
        this.twb.ezg();
        this.twb.Cbx.eyx();
        this.twb.aC(true, true);
        this.twb.ezh();
        this.twb.ezj();
        this.twb.Cbx.eyB();
        this.twb.Cbx.fZG();
      }
      if (com.tencent.mm.model.w.sT(paramString))
      {
        this.twb.Cbx.eyw();
        this.twb.Cbx.eyy();
        this.twb.Cbx.eyz();
        this.twb.ezg();
        this.twb.Cbx.eyx();
        this.twb.aC(true, true);
        this.twb.ezh();
        this.twb.ezj();
        this.twb.Cbx.eyB();
        this.twb.Cbx.fZG();
      }
      if (com.tencent.mm.model.w.sQ(paramString))
      {
        this.twb.Cbx.eyw();
        this.twb.aC(true, true);
        this.twb.Cbx.eyx();
        this.twb.Cbx.eyB();
        this.twb.Cbx.fZG();
      }
      az.arV();
      localObject1 = com.tencent.mm.model.c.apM().aHY(paramString);
      if ((localObject1 != null) && (((com.tencent.mm.storage.af)localObject1).eKB()))
      {
        if (!((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWC()) {
          break label2531;
        }
        this.twb.Cbx.eyw();
        this.twb.Cbx.eyz();
        this.twb.Cbx.eyx();
        this.twb.aC(true, true);
        this.twb.ezh();
        this.twb.ezj();
        this.twb.eze();
        this.twb.Cbx.eyA();
        this.twb.ezd();
        this.twb.ezk();
        this.twb.exn();
        this.twb.Cbx.fZG();
      }
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.b.a.ESL.l(new pu());
        if (this.cOd.eZa())
        {
          if (com.tencent.mm.m.g.Zd().getInt("MultitalkBlockCaller", 0) == 0)
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            this.twb.uf(false);
            if ((this.cOd.eZb()) || (this.cOd.eYZ()))
            {
              this.twb.aC(true, true);
              this.twb.ezj();
            }
            com.tencent.mm.bs.d.eBj();
            if (this.cOd.eYZ()) {
              this.twb.Cbx.eyx();
            }
            if (this.cOd.getTalkerUserName().equals(com.tencent.mm.model.u.aqG()))
            {
              this.twb.Cbx.eyx();
              this.twb.aC(true, true);
              this.twb.ezh();
              this.twb.ezj();
              this.twb.Cbx.fZG();
            }
            this.twb.setAppPanelTip(null);
            if ((!com.tencent.mm.storage.af.aHH(this.cOd.zgX.field_username)) && (!com.tencent.mm.model.w.sn(this.cOd.zgX.field_username))) {
              continue;
            }
            com.tencent.mm.kernel.g.afC();
            Object localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.cOd.zgX.field_username);
            ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).bs(((au)localObject3).field_openImAppid, ((au)localObject3).field_descWordingId);
            i = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).Bi(((au)localObject3).field_openImAppid);
            Object localObject2 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(this.cOd.zgX.field_openImAppid, "openim_function_tip", com.tencent.mm.openim.a.b.a.hNA);
            ad.i("MicroMsg.ChattingUI.FootComponent", "openim showFlag:%d username: %s appid: %s tip %s", new Object[] { Integer.valueOf(i), this.cOd.zgX.field_username, ((au)localObject3).field_openImAppid, localObject2 });
            if ((i & 0x1) == 0) {
              this.twb.ezb();
            }
            if ((i & 0x2) == 0) {
              this.twb.ezd();
            }
            if ((i & 0x4) == 0)
            {
              localObject3 = this.twb.Cbx;
              ((AppPanel)localObject3).Cal.CaJ.value = false;
              ((AppPanel)localObject3).eyE();
            }
            if ((i & 0x8) == 0) {
              this.twb.ezf();
            }
            if ((i & 0x10) == 0) {
              this.twb.Cbx.eyy();
            }
            if ((i & 0x20) == 0) {
              this.twb.Cbx.eyw();
            }
            if ((i & 0x40) == 0) {
              this.twb.Cbx.eyB();
            }
            if ((i & 0x80) == 0) {
              this.twb.ezg();
            }
            if (((i & 0x100) == 0) || ((i & 0x2000) == 0))
            {
              localObject3 = this.twb;
              if ((i & 0x100) != 0) {
                continue;
              }
              bool1 = true;
              if ((i & 0x2000) != 0) {
                continue;
              }
              bool2 = true;
              ((ChatFooter)localObject3).aC(bool1, bool2);
            }
            if ((i & 0x200) == 0)
            {
              this.twb.ezh();
              this.twb.ezj();
            }
            if ((i & 0x400) == 0) {
              this.twb.ezi();
            }
            if ((com.tencent.mm.model.w.sn(this.cOd.zgX.field_username)) && ((i & 0x100) == 0)) {
              this.twb.uf(true);
            }
            this.twb.setAppPanelTip((CharSequence)localObject2);
            localObject2 = this.twb;
            com.tencent.mm.bs.d.eBj();
            if (((ChatFooter)localObject2).fSY != null) {
              ((ChatFooter)localObject2).fSY.exo();
            }
            localObject2 = this.twb;
            com.tencent.mm.bs.d.eBj();
            if (!com.tencent.mm.ax.b.azj()) {
              continue;
            }
            bool1 = true;
            ((ChatFooter)localObject2).ug(bool1);
            this.twb.Cbx.eyx();
            if (com.tencent.mm.storage.af.rz(this.cOd.getTalkerUserName()))
            {
              this.twb.eyT();
              this.twb.ezb();
              this.twb.Cbx.eyz();
              this.twb.ezl();
              this.twb.Cbx.fZG();
              this.twb.ezg();
              this.twb.ezd();
              this.twb.ezf();
              this.twb.Cbx.eyw();
              this.twb.eze();
              this.twb.ezg();
              this.twb.ezd();
              this.twb.ezk();
              this.twb.exn();
              this.twb.Cbx.eyA();
              this.twb.aC(true, true);
              this.twb.uf(true);
              this.twb.ug(true);
              this.twb.ezh();
              this.twb.ezj();
              this.twb.Cbx.eyx();
              this.twb.Cbx.eyw();
              this.twb.Cbx.eyy();
              this.twb.Cbx.eyB();
            }
            if ((!com.tencent.mm.chatroom.d.aa.UU()) || (!com.tencent.mm.model.w.sm(this.cOd.getTalkerUserName()))) {
              this.twb.Cbx.eyC();
            }
            if (!((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).adh(this.cOd.getTalkerUserName())) {
              this.twb.Cbx.eyD();
            }
            localObject2 = new ArrayList();
            a(paramString, (com.tencent.mm.storage.af)localObject1, (ArrayList)localObject2);
            paramString = new ar.b.a()
            {
              public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(163312);
                if ((paramAnonymousBoolean) && (bt.kU(t.this.cOd.getTalkerUserName(), paramAnonymousString))) {
                  com.tencent.mm.kernel.g.afE().ax(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(163310);
                      t.a(t.this, t.13.this.cNX, t.13.this.fvY, new ArrayList());
                      aq.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(163309);
                          ChatFooter localChatFooter = t.this.twb;
                          if ((localChatFooter.CbE != null) && (localChatFooter.CbE.getVisibility() == 0)) {
                            localChatFooter.ur(true);
                          }
                          AppMethodBeat.o(163309);
                        }
                      });
                      AppMethodBeat.o(163310);
                    }
                    
                    public final String toString()
                    {
                      AppMethodBeat.i(163311);
                      String str = super.toString() + "|getContactCallBack";
                      AppMethodBeat.o(163311);
                      return str;
                    }
                  });
                }
                AppMethodBeat.o(163312);
              }
            };
            if ((((ArrayList)localObject2).size() != 0) || (localObject1 == null) || (((au)localObject1).evU != 0L)) {
              continue;
            }
            if (!com.tencent.mm.model.w.pF(this.cOd.getTalkerUserName())) {
              continue;
            }
            localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(this.cOd.getTalkerUserName());
            if ((localObject1 != null) && ((((com.tencent.mm.storage.w)localObject1).field_chatroomStatus & 0x8000) != 0L) && ((((com.tencent.mm.storage.w)localObject1).field_chatroomfamilystatusmodifytime == 0L) || (((com.tencent.mm.storage.w)localObject1).field_chatroomfamilystatusmodifytime - ce.asR() >= 86400000L)))
            {
              ((com.tencent.mm.storage.w)localObject1).field_chatroomfamilystatusmodifytime = ce.asR();
              ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().update((com.tencent.mm.sdk.e.c)localObject1, new String[0]);
              a(this.cOd.getTalkerUserName(), paramString);
            }
            AppMethodBeat.o(35325);
            return;
            bool1 = ((com.tencent.mm.ui.chatting.c.b.ae)this.cOd.be(com.tencent.mm.ui.chatting.c.b.ae.class)).eYx();
            bool2 = ((com.tencent.mm.ui.chatting.c.b.ae)this.cOd.be(com.tencent.mm.ui.chatting.c.b.ae.class)).eYw();
            if ((bool1) || (bool2))
            {
              ad.w("MicroMsg.ChattingUI.FootComponent", "match shake, in search mode, do not open short video recode view");
              i = 0;
              break;
            }
            if ((com.tencent.mm.storage.af.aHG(this.cOd.getTalkerUserName())) || (com.tencent.mm.storage.af.st(this.cOd.getTalkerUserName())))
            {
              ad.w("MicroMsg.ChattingUI.FootComponent", "match shake, but is Qcontact or Bcontact");
              i = 0;
              break;
            }
            if (com.tencent.mm.model.w.to(this.cOd.getTalkerUserName()))
            {
              i = 0;
              break;
            }
            i = 1;
            break;
            label2223:
            localObject1 = com.tencent.mm.am.af.awe().wz(((com.tencent.mm.api.c)localObject1).field_enterpriseFather);
            if ((localObject1 != null) && (((Cursor)localObject1).getCount() > 0))
            {
              i = 1;
              j = i;
              if (localObject1 == null) {
                break label126;
              }
              ((Cursor)localObject1).close();
              j = i;
              break label126;
            }
            i = 0;
            continue;
            label2277:
            if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED))
            {
              i = bt.getInt(com.tencent.mm.m.g.Zd().getValue("ChatRoomEnableLive"), 0);
              if (i == 0)
              {
                localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(((ChatFooter)localObject1).Cbw);
                if (localObject1 == null) {
                  break label2837;
                }
                if ((((com.tencent.mm.storage.w)localObject1).field_chatroomStatus & 0x80000) == 524288)
                {
                  j = 1;
                  i = j;
                  if (j != 0) {
                    break label206;
                  }
                  if (com.tencent.mm.kernel.g.afB().afk().getInt(ae.a.LBG, 0) != 1) {
                    continue;
                  }
                  i = 1;
                  break label206;
                }
                j = 0;
                continue;
              }
              if (i == 1)
              {
                j = 1;
                continue;
              }
              j = 0;
              continue;
              i = 0;
              break label206;
            }
            if (((ChatFooter)localObject1).Cbw == null) {
              continue;
            }
            i = bt.getInt(com.tencent.mm.m.g.Zd().getValue("ChatRoomEnableLive"), 0);
            if (i == 0)
            {
              localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(((ChatFooter)localObject1).Cbw);
              if (localObject1 == null) {
                continue;
              }
              if ((((com.tencent.mm.storage.w)localObject1).field_chatroomStatus & 0x80000) == 524288)
              {
                i = 1;
                break label206;
              }
              i = 0;
              break label206;
            }
            if (i == 1)
            {
              i = 1;
              break label206;
            }
            i = 0;
            break label206;
            label2505:
            localObject1 = this.twb.Cbx;
            ((AppPanel)localObject1).Cal.zh(true);
            ((AppPanel)localObject1).eyE();
            break label268;
            label2531:
            this.twb.Cbx.eyw();
            this.twb.aC(true, true);
            this.twb.ezf();
            this.twb.Cbx.eyx();
            this.twb.Cbx.fZG();
            continue;
          }
          i = 0;
          continue;
        }
        this.twb.uf(true);
        continue;
        bool1 = false;
        continue;
        boolean bool2 = false;
        continue;
        if (!com.tencent.mm.model.w.sp(this.cOd.zgX.field_username)) {
          continue;
        }
        i = com.tencent.mm.model.u.arq();
        if ((i & 0x1) == 0) {
          this.twb.uf(true);
        }
        if ((i & 0x2) == 0) {
          this.twb.ezh();
        }
        if ((i & 0x4) != 0) {
          continue;
        }
        this.twb.ezi();
        continue;
        bool1 = false;
        continue;
        if (com.tencent.mm.model.w.sn(this.cOd.getTalkerUserName()))
        {
          localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(this.cOd.getTalkerUserName());
          if ((localObject1 != null) && ((((com.tencent.mm.storage.w)localObject1).eKm().type & 0x4) != 0L) && ((((com.tencent.mm.storage.w)localObject1).field_chatroomfamilystatusmodifytime == 0L) || (((com.tencent.mm.storage.w)localObject1).field_chatroomfamilystatusmodifytime - ce.asR() >= 86400000L)))
          {
            ((com.tencent.mm.storage.w)localObject1).field_chatroomfamilystatusmodifytime = ce.asR();
            ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().update((com.tencent.mm.sdk.e.c)localObject1, new String[0]);
            a(this.cOd.getTalkerUserName(), paramString);
          }
          AppMethodBeat.o(35325);
          return;
        }
        AppMethodBeat.o(35325);
        return;
      }
      catch (Throwable localThrowable)
      {
        continue;
        i = 0;
      }
      break label206;
      label2837:
      j = 0;
    }
  }
  
  private static void aKJ(String paramString)
  {
    AppMethodBeat.i(163318);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(163318);
      return;
    }
    for (;;)
    {
      int i;
      a.a locala;
      Object localObject;
      JSONObject localJSONObject;
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("wxapp");
        int j = localJSONArray.length();
        i = 0;
        if (i >= j) {
          break label646;
        }
        paramString = new JSONObject(localJSONArray.getString(i));
        locala = new a.a();
        locala.Cbi = paramString.optString("enter_id");
        locala.Cbj = paramString.optInt("red_dot");
        locala.uaQ = paramString.optInt("jump_type");
        locala.Cbk = paramString.optString("wa_un");
        locala.Cbl = paramString.optInt("wa_ver");
        locala.Cbm = paramString.optString("wa_path");
        locala.Cbn = paramString.optString("wa_dgmode");
        locala.kXu = paramString.optString("h5_url");
        locala.iconUrl = paramString.optString("icon_url");
        locala.Cbs = paramString.optString("icon_url_dark");
        if (bt.isNullOrNil(locala.iconUrl))
        {
          ad.e("MicroMsg.ChattingUI.FootComponent", "unCertainEnter.iconUrl is null");
        }
        else
        {
          locala.Cbt = paramString.optLong("busi_type");
          localObject = paramString.optJSONObject("title");
          localJSONObject = paramString.optJSONObject("desc");
          if (localObject == null) {
            ad.e("MicroMsg.ChattingUI.FootComponent", "titleJson is null");
          }
        }
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.ChattingUI.FootComponent", "handleAppPanelUnCertainEnterConfig() Exception:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(163318);
        return;
      }
      locala.Cbo.title = ((JSONObject)localObject).optString("zh_cn");
      if (bt.isNullOrNil(locala.Cbo.title))
      {
        ad.e("MicroMsg.ChattingUI.FootComponent", "unCertainEnter.simpleChWord.title is null");
      }
      else
      {
        a.b localb = locala.Cbq;
        if (bt.isNullOrNil(((JSONObject)localObject).optString("zh_tw")))
        {
          paramString = locala.Cbo.title;
          localb.title = paramString;
          localb = locala.Cbp;
          if (!bt.isNullOrNil(((JSONObject)localObject).optString("zh_hk"))) {
            break label586;
          }
          paramString = locala.Cbo.title;
          label391:
          localb.title = paramString;
          localb = locala.Cbr;
          if (!bt.isNullOrNil(((JSONObject)localObject).optString("en"))) {
            break label598;
          }
          paramString = locala.Cbo.title;
          label427:
          localb.title = paramString;
          if (localJSONObject != null)
          {
            locala.Cbo.desc = localJSONObject.optString("zh_cn");
            localObject = locala.Cbq;
            if (!bt.isNullOrNil(localJSONObject.optString("zh_tw"))) {
              break label610;
            }
            paramString = locala.Cbo.desc;
            label484:
            ((a.b)localObject).desc = paramString;
            localObject = locala.Cbp;
            if (!bt.isNullOrNil(localJSONObject.optString("zh_hk"))) {
              break label622;
            }
            paramString = locala.Cbo.desc;
            label520:
            ((a.b)localObject).desc = paramString;
            localObject = locala.Cbr;
            if (!bt.isNullOrNil(localJSONObject.optString("en"))) {
              break label634;
            }
          }
        }
        label586:
        label598:
        label610:
        label622:
        label634:
        for (paramString = locala.Cbo.desc;; paramString = localJSONObject.optString("en"))
        {
          ((a.b)localObject).desc = paramString;
          GuC.add(locala);
          break label653;
          paramString = ((JSONObject)localObject).optString("zh_tw");
          break;
          paramString = ((JSONObject)localObject).optString("zh_hk");
          break label391;
          paramString = ((JSONObject)localObject).optString("en");
          break label427;
          paramString = localJSONObject.optString("zh_tw");
          break label484;
          paramString = localJSONObject.optString("zh_hk");
          break label520;
        }
        label646:
        AppMethodBeat.o(163318);
        return;
      }
      label653:
      i += 1;
    }
  }
  
  private void eXD()
  {
    AppMethodBeat.i(184963);
    if (this.twb == null)
    {
      ad.e("MicroMsg.ChattingUI.FootComponent", "initTodoView footer == null");
      AppMethodBeat.o(184963);
      return;
    }
    ad.i("MicroMsg.ChattingUI.FootComponent", "initTodoView()");
    ((com.tencent.mm.ui.chatting.c.b.u)this.cOd.be(com.tencent.mm.ui.chatting.c.b.u.class)).a(this.twb.getIOnToDoBarCallback());
    this.twb.setIOnTodoViewCallback(new x.c()
    {
      public final int cFo()
      {
        AppMethodBeat.i(185866);
        int i = ((com.tencent.mm.ui.chatting.c.b.u)t.this.cOd.be(com.tencent.mm.ui.chatting.c.b.u.class)).cFo();
        AppMethodBeat.o(185866);
        return i;
      }
      
      public final void we(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(185864);
        ((com.tencent.mm.ui.chatting.c.b.u)t.this.cOd.be(com.tencent.mm.ui.chatting.c.b.u.class)).we(paramAnonymousBoolean);
        AppMethodBeat.o(185864);
      }
      
      public final void wf(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(185865);
        ((com.tencent.mm.ui.chatting.c.b.u)t.this.cOd.be(com.tencent.mm.ui.chatting.c.b.u.class)).wf(paramAnonymousBoolean);
        AppMethodBeat.o(185865);
      }
    });
    AppMethodBeat.o(184963);
  }
  
  private static void eXE()
  {
    AppMethodBeat.i(163317);
    aKJ(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.puK, ""));
    aKJ(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.puL, ""));
    aKJ(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.puM, ""));
    aKJ(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.puN, ""));
    aKJ(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.puO, ""));
    aKJ(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.puP, ""));
    aKJ(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.puQ, ""));
    aKJ(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.puR, ""));
    aKJ(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.puS, ""));
    aKJ(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.puT, ""));
    AppMethodBeat.o(163317);
  }
  
  private void eXu()
  {
    AppMethodBeat.i(35315);
    if (this.cOd.GzJ.isCurrentActivity)
    {
      AppMethodBeat.o(35315);
      return;
    }
    this.cOd.GzL.eVQ();
    if (this.twb != null)
    {
      ChatFooter localChatFooter = this.twb;
      Object localObject = localChatFooter.findViewById(2131298150);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localChatFooter.setSwitchButtonMode(0);
      localChatFooter.mHandler.removeMessages(1002);
      if (localChatFooter.CbE != null) {
        localChatFooter.CbE.setVisibility(8);
      }
      if (localChatFooter.CbF != null) {
        localChatFooter.CbF.setVisibility(8);
      }
      if (localChatFooter.CbG != null) {
        localChatFooter.CbG.setVisibility(8);
      }
      if (localChatFooter.CbJ != null) {
        localChatFooter.CbJ.setVisibility(8);
      }
      if (localChatFooter.CbH != null) {
        localChatFooter.CbH.setVisibility(8);
      }
      if (localChatFooter.CbK != null) {
        localChatFooter.CbK.setVisibility(8);
      }
      localChatFooter.fPz.setVisibility(8);
      if (localChatFooter.qeE != null) {
        localChatFooter.qeE.setVisibility(8);
      }
      if (localChatFooter.CcJ != null) {
        localChatFooter.CcJ.setVisibility(8);
      }
      if (localChatFooter.qeF != null) {
        localChatFooter.qeF.setVisibility(8);
      }
      if (localChatFooter.qeC != null) {
        localChatFooter.qeC.setVisibility(8);
      }
      if (localChatFooter.BWH != null)
      {
        localChatFooter.BWH.setVisibility(8);
        localChatFooter.BWK = false;
        localChatFooter.BWH.destroy();
      }
      if (localChatFooter.CbY != null) {
        localChatFooter.CbY.setVisibility(8);
      }
      if (localChatFooter.yJO != null) {
        localChatFooter.yJO.setVisibility(8);
      }
      if (localChatFooter.yJL != null) {
        localChatFooter.yJL.update();
      }
      if (localChatFooter.Cby != null) {
        localChatFooter.Cby.setVisibility(8);
      }
      if (localChatFooter.CbC != null)
      {
        localChatFooter.CbC.setVisibility(4);
        if (localChatFooter.fSY != null) {
          localChatFooter.fSY.setVisibility(4);
        }
      }
      localChatFooter.Cbx = ((AppPanel)localChatFooter.findViewById(2131297977));
      if (localChatFooter.Cbx != null)
      {
        localChatFooter.setAppPanelVisible(8);
        localObject = localChatFooter.Cbx;
        if (((AppPanel)localObject).vWd != null) {
          ((AppPanel)localObject).vWd.setToScreen(0);
        }
        ((AppPanel)localObject).Caj = 0;
      }
      localChatFooter.a(ChatFooter.h.CfC);
      localChatFooter.g(0, false, -1);
      localChatFooter.CbX = false;
      localChatFooter = this.twb;
      if (!bt.ai(localChatFooter.tqv.getText())) {
        localChatFooter.tqv.setText("");
      }
      localChatFooter.un(false);
      localChatFooter.eyR();
      this.twb.eyS();
      this.twb.CbU.Cfs = null;
    }
    AppMethodBeat.o(35315);
  }
  
  private void eXz()
  {
    AppMethodBeat.i(35319);
    ad.i("MicroMsg.ChattingUI.FootComponent", "[goneFooter] %s", new Object[] { bt.eGN() });
    if (this.twb != null)
    {
      this.twb.g(0, false, -1);
      this.twb.setVisibility(8);
    }
    if (this.GuF != null) {
      this.GuF.setVisibility(8);
    }
    this.twb.un(false);
    this.cOd.hideVKB();
    AppMethodBeat.o(35319);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(35327);
    if (paramObject != null) {
      paramObject.equals("");
    }
    ad.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", new Object[] { paramObject, this.cOd.getTalkerUserName() });
    if (paramObject.equals(this.cOd.getTalkerUserName()))
    {
      aKI(this.cOd.getTalkerUserName());
      eXC();
    }
    AppMethodBeat.o(35327);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(35328);
    if (paramString != null) {
      paramString.equals("");
    }
    ad.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", new Object[] { paramString, this.cOd.getTalkerUserName() });
    if (com.tencent.mm.model.w.sn(this.cOd.getTalkerUserName()))
    {
      aKI(this.cOd.getTalkerUserName());
      eXC();
    }
    AppMethodBeat.o(35328);
  }
  
  public final boolean aC(bl parambl)
  {
    AppMethodBeat.i(35323);
    if (this.twb != null) {
      this.twb.aC(parambl);
    }
    AppMethodBeat.o(35323);
    return true;
  }
  
  public final boolean ak(com.tencent.mm.storage.af paramaf)
  {
    AppMethodBeat.i(35322);
    boolean bool1 = ((com.tencent.mm.ui.chatting.c.b.ae)this.cOd.be(com.tencent.mm.ui.chatting.c.b.ae.class)).eYx();
    boolean bool2 = ((com.tencent.mm.ui.chatting.c.b.ae)this.cOd.be(com.tencent.mm.ui.chatting.c.b.ae.class)).eYw();
    boolean bool3 = ((com.tencent.mm.ui.chatting.c.b.j)this.cOd.be(com.tencent.mm.ui.chatting.c.b.j.class)).eXi();
    boolean bool4 = ((com.tencent.mm.ui.chatting.c.b.o)this.cOd.be(com.tencent.mm.ui.chatting.c.b.o.class)).eXr();
    if (this.GuP)
    {
      AppMethodBeat.o(35322);
      return true;
    }
    if ((bool1) || (bool2) || (bool3) || (bool4))
    {
      ad.i("MicroMsg.ChattingUI.FootComponent", bool1 + ", " + bool2 + ", " + bool3 + ", " + bool4);
      eXz();
      AppMethodBeat.o(35322);
      return false;
    }
    if ((paramaf != null) && (com.tencent.mm.model.w.sA(paramaf.field_username)))
    {
      this.GuJ = new com.tencent.mm.ui.chatting.h(this.GuF);
      this.GuJ.eSK();
      eXx();
      AppMethodBeat.o(35322);
      return true;
    }
    com.tencent.mm.ui.chatting.c.b.d locald;
    Object localObject1;
    int i;
    if ((paramaf != null) && (paramaf.eKB()))
    {
      locald = (com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class);
      if (locald.eWz() != null)
      {
        localObject1 = locald.eWz().bU(false);
        if (localObject1 != null)
        {
          if (((c.b)localObject1).cIj != null) {
            ((c.b)localObject1).cIl = "1".equals(((c.b)localObject1).cIj.optString("IsHideInputToolbarInMsg"));
          }
          if (((c.b)localObject1).cIl)
          {
            ad.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + paramaf.field_username + " is hide tool bar");
            eXz();
            AppMethodBeat.o(35322);
            return false;
          }
        }
        if ((!bt.isNullOrNil(paramaf.field_username)) && (localObject1 != null))
        {
          i = this.cOd.GzJ.getIntExtra("key_temp_session_show_type", 0);
          switch (((c.b)localObject1).Jw())
          {
          default: 
            eXy();
            paramaf = paramaf.field_username;
            if (localObject1 == null) {
              break;
            }
          }
        }
      }
    }
    for (bool1 = true;; bool1 = false)
    {
      ad.e("MicroMsg.ChattingUI.FootComponent", "bizinfo name=%s, %b, %d", new Object[] { paramaf, Boolean.valueOf(bool1), Integer.valueOf(((c.b)localObject1).Jw()) });
      for (;;)
      {
        AppMethodBeat.o(35322);
        return true;
        ad.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + paramaf.field_username + " is show custom menu");
        if (this.GuF == null)
        {
          j.a(this.cOd.GzJ, 2131302671);
          this.GuF = ((ChatFooterCustom)this.cOd.findViewById(2131302673));
          if (this.GuF != null) {
            this.GuF.x((ViewGroup)this.cOd.findViewById(2131298070));
          }
        }
        localObject1 = ((c.b)localObject1).JE();
        try
        {
          Iterator localIterator = ((c.b.c)localObject1).cIU.iterator();
          while (localIterator.hasNext())
          {
            Object localObject2 = (com.tencent.mm.am.j)localIterator.next();
            if (!bt.isNullOrNil(((com.tencent.mm.am.j)localObject2).dDM)) {
              ((com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).a(((com.tencent.mm.am.j)localObject2).dDM, -1, "", bt.by(((com.tencent.mm.am.j)localObject2).name, ""), "", "", 4);
            }
            if (!bt.isNullOrNil(((com.tencent.mm.am.j)localObject2).value)) {
              ((com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).a(((com.tencent.mm.am.j)localObject2).value, -1, "", bt.by(((com.tencent.mm.am.j)localObject2).name, ""), "", "", 4);
            }
            localObject2 = ((com.tencent.mm.am.j)localObject2).gXr.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              com.tencent.mm.am.j localj = (com.tencent.mm.am.j)((Iterator)localObject2).next();
              if (!bt.isNullOrNil(localj.dDM)) {
                ((com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).a(localj.dDM, -1, "", bt.by(localj.name, ""), "", "", 4);
              }
              if (!bt.isNullOrNil(localj.value)) {
                ((com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).a(localj.value, -1, "", bt.by(localj.name, ""), "", "", 4);
              }
            }
          }
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.ChattingUI.FootComponent", localException, "preauth when chat foot", new Object[0]);
          if ((localObject1 != null) && (((c.b.c)localObject1).type == 1))
          {
            this.twb.setSwitchButtonMode(1);
            this.twb.setOnFooterSwitchListener(((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWG());
            eXy();
          }
          else
          {
            this.twb.setSwitchButtonMode(0);
            try
            {
              if (!com.tencent.mm.model.w.sw(paramaf.field_username)) {
                break label1024;
              }
              this.GuI = new com.tencent.mm.ui.chatting.w(this.GuF);
              this.GuI.eSK();
              eXx();
            }
            catch (Exception paramaf)
            {
              if (localObject1 == null) {
                break label1004;
              }
            }
            if ((((c.b.c)localObject1).cIU == null) || (((c.b.c)localObject1).cIU.size() == 0)) {
              label1004:
              eXy();
            }
          }
        }
      }
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.ChattingUI.FootComponent", paramaf, "", new Object[0]);
        break;
        label1024:
        ChatFooterCustom localChatFooterCustom = this.GuF;
        if ((localChatFooterCustom.Glm != null) && (localChatFooterCustom.Gll != null))
        {
          localChatFooterCustom.Glm.setVisibility(0);
          localChatFooterCustom.Gll.setVisibility(0);
        }
        if (localChatFooterCustom.Gln != null) {
          localChatFooterCustom.Gln.eVf();
        }
        this.GuF.setTalker(this.cOd.zgX);
        this.GuF.a(this.cOd.GzJ, locald.eWz(), paramaf.field_username);
        this.GuF.setOnFooterSwitchListener(this.CbR);
        this.GuF.setOnProcessClickListener(((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWF());
        this.twb.setOnFooterSwitchListener(this.CbR);
        if ((((com.tencent.mm.ui.chatting.c.b.aa)this.cOd.be(com.tencent.mm.ui.chatting.c.b.aa.class)).eYp()) && (i == 1))
        {
          eXy();
          break;
        }
        eXx();
        break;
        this.CbR.us(true);
      }
    }
  }
  
  public final void eQA()
  {
    AppMethodBeat.i(191517);
    this.GuP = this.cOd.GzJ.getBooleanExtra("show_footer", false).booleanValue();
    AppMethodBeat.o(191517);
  }
  
  public final void eQB()
  {
    AppMethodBeat.i(35333);
    this.GuQ = false;
    this.GuR = false;
    this.GuS = 0L;
    az.arV();
    Object localObject1 = com.tencent.mm.model.c.apR().aIn(this.cOd.getTalkerUserName());
    if (localObject1 != null) {
      this.GuG = ((ay)localObject1).field_chatmode;
    }
    ad.d("MicroMsg.ChattingUI.FootComponent", "dkcm init old:%d   ", new Object[] { Integer.valueOf(this.GuG) });
    localObject1 = this.cOd.getTalkerUserName();
    if (this.twb == null)
    {
      this.twb = ((ChatFooter)this.cOd.findViewById(2131302672));
      this.twb.a(new ChatFooter.b()
      {
        public final com.tencent.mm.ui.chatting.h.b ezT()
        {
          return t.this.cOd.GzG;
        }
        
        public final String getTalkerUserName()
        {
          AppMethodBeat.i(35307);
          String str = t.this.cOd.getTalkerUserName();
          AppMethodBeat.o(35307);
          return str;
        }
      });
      ((com.tencent.mm.ui.chatting.c.b.p)this.cOd.be(com.tencent.mm.ui.chatting.c.b.p.class)).bw(this.twb);
      eXD();
    }
    this.twb.setCattingRootLayoutId(2131298066);
    ad.i("MicroMsg.ChattingUI.FootComponent", "resetFooter customFooter is %s", new Object[] { this.GuF });
    if (this.GuF != null)
    {
      this.GuF.eUZ();
      this.GuF.setOnFooterSwitchListener(null);
      this.GuF.setOnProcessClickListener(null);
      this.twb.setOnFooterSwitchListener(null);
      this.GuF.eVc();
    }
    eXz();
    this.twb.ezc();
    boolean bool1 = ((com.tencent.mm.ui.chatting.c.b.ae)this.cOd.be(com.tencent.mm.ui.chatting.c.b.ae.class)).eYx();
    boolean bool2 = ((com.tencent.mm.ui.chatting.c.b.ae)this.cOd.be(com.tencent.mm.ui.chatting.c.b.ae.class)).eYw();
    int i;
    if ((!this.GuP) && ((bool1) || (bool2)))
    {
      eXz();
      eXu();
      this.GuE = new com.tencent.mm.ui.chatting.p(this.cOd, this.twb, this.cOd.getTalkerUserName());
      this.GuE.Gno = this.cOd.GzJ.getBooleanExtra("key_need_send_video", true).booleanValue();
      this.twb.setFooterEventListener(this.GuE);
      localObject1 = new v(this.cOd, this.cOd.zgX, this.cOd.getTalkerUserName());
      this.twb.setSmileyPanelCallback((com.tencent.mm.pluginsdk.ui.chat.f)localObject1);
      this.twb.setSmileyPanelCallback2((com.tencent.mm.pluginsdk.ui.chat.j)localObject1);
      eXC();
      this.twb.eyU();
      i = this.cOd.GzJ.getIntExtra("key_temp_session_show_type", 0);
      localObject1 = (com.tencent.mm.ui.chatting.c.b.aa)this.cOd.be(com.tencent.mm.ui.chatting.c.b.aa.class);
      ad.i("MicroMsg.ChattingUI.FootComponent", "isTempSession : %s, showType : %d.", new Object[] { Boolean.valueOf(((com.tencent.mm.ui.chatting.c.b.aa)localObject1).eYp()), Integer.valueOf(i) });
      ad.d("MicroMsg.ChattingUI.FootComponent", "is temp session : %s.", new Object[] { Boolean.valueOf(((com.tencent.mm.ui.chatting.c.b.aa)localObject1).eYp()) });
      if (((com.tencent.mm.ui.chatting.c.b.aa)localObject1).eYp())
      {
        if (i != 1) {
          break label1576;
        }
        this.CbR.us(true);
      }
    }
    for (;;)
    {
      ak(this.cOd.zgX);
      com.tencent.mm.kernel.g.afC();
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().a(this);
      ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().add(this);
      AppMethodBeat.o(35333);
      return;
      if (com.tencent.mm.model.w.sH((String)localObject1))
      {
        eXz();
        j.a(this.cOd.GzJ, 2131302671);
        if (this.GuF == null)
        {
          i = 1;
          this.GuF = ((ChatFooterCustom)this.cOd.findViewById(2131302673));
          if (i != 0) {
            this.GuF.x((ViewGroup)this.cOd.findViewById(2131298070));
          }
          this.GuH = new com.tencent.mm.ui.chatting.t(this.GuF);
          localObject1 = this.GuH;
          if (com.tencent.mm.sdk.platformtools.i.cJR != 1) {
            break label878;
          }
          i = 1;
          label695:
          ((com.tencent.mm.ui.chatting.t)localObject1).Gom.findViewById(2131298098).setVisibility(8);
          ((com.tencent.mm.ui.chatting.t)localObject1).oIh = ((LinearLayout)((com.tencent.mm.ui.chatting.t)localObject1).Gom.findViewById(2131298093));
          ((com.tencent.mm.ui.chatting.t)localObject1).Gom.findViewById(2131298092).setVisibility(8);
          localObject2 = ((com.tencent.mm.ui.chatting.t)localObject1).oIh;
          if (i == 0) {
            break label883;
          }
        }
        label878:
        label883:
        for (float f = 1.0F;; f = 2.0F)
        {
          ((LinearLayout)localObject2).setWeightSum(f);
          ((com.tencent.mm.ui.chatting.t)localObject1).Gon = ((FrameLayout)((com.tencent.mm.ui.chatting.t)localObject1).oIh.getChildAt(0));
          ((com.tencent.mm.ui.chatting.t)localObject1).Gon.setVisibility(0);
          ((com.tencent.mm.ui.chatting.t)localObject1).Gon.setOnClickListener(((com.tencent.mm.ui.chatting.t)localObject1).Gow);
          ((TextView)((com.tencent.mm.ui.chatting.t)localObject1).Gon.findViewById(2131298095)).setText(2131757079);
          ((com.tencent.mm.ui.chatting.t)localObject1).Gon.findViewById(2131298094).setVisibility(8);
          if (i == 0) {
            break label888;
          }
          i = 1;
          while (i < 6)
          {
            ((com.tencent.mm.ui.chatting.t)localObject1).oIh.getChildAt(i).setVisibility(8);
            i += 1;
          }
          i = 0;
          break;
          i = 0;
          break label695;
        }
        label888:
        ((com.tencent.mm.ui.chatting.t)localObject1).Goo = ((FrameLayout)((com.tencent.mm.ui.chatting.t)localObject1).oIh.getChildAt(1));
        ((com.tencent.mm.ui.chatting.t)localObject1).Goo.setVisibility(0);
        ((com.tencent.mm.ui.chatting.t)localObject1).Goo.setOnClickListener(((com.tencent.mm.ui.chatting.t)localObject1).Gox);
        ((com.tencent.mm.ui.chatting.t)localObject1).Gop = ((TextView)((com.tencent.mm.ui.chatting.t)localObject1).Goo.findViewById(2131298095));
        ((com.tencent.mm.ui.chatting.t)localObject1).Goq = ((ImageView)((com.tencent.mm.ui.chatting.t)localObject1).Goo.findViewById(2131298094));
        ((com.tencent.mm.ui.chatting.t)localObject1).Goq.setVisibility(0);
        ((com.tencent.mm.ui.chatting.t)localObject1).eVI();
        az.arV();
        ((com.tencent.mm.ui.chatting.t)localObject1).Gos = ((Integer)com.tencent.mm.model.c.afk().get(ae.a.Fhb, Integer.valueOf(-1))).intValue();
        if (((com.tencent.mm.ui.chatting.t)localObject1).Gos >= 0) {
          ((com.tencent.mm.ui.chatting.t)localObject1).eVK();
        }
        for (;;)
        {
          i = 2;
          while (i < 6)
          {
            ((com.tencent.mm.ui.chatting.t)localObject1).oIh.getChildAt(i).setVisibility(8);
            i += 1;
          }
          ((com.tencent.mm.ui.chatting.t)localObject1).Gop.setText(2131757092);
        }
        ((com.tencent.mm.ui.chatting.t)localObject1).Gov = com.tencent.mm.m.g.Ze().getMailAppEnterUlAndroid();
        if (bt.isNullOrNil(((com.tencent.mm.ui.chatting.t)localObject1).Gov)) {
          ((com.tencent.mm.ui.chatting.t)localObject1).Gov = "qqmail://folderlist?app=weixin&action=list&uin=$uin$";
        }
        az.arV();
        localObject2 = new com.tencent.mm.b.p(bt.l((Integer)com.tencent.mm.model.c.afk().get(9, null))).toString();
        ((com.tencent.mm.ui.chatting.t)localObject1).Gov = ((com.tencent.mm.ui.chatting.t)localObject1).Gov.replace("$uin$", (CharSequence)localObject2);
        ((com.tencent.mm.ui.chatting.t)localObject1).uQR = com.tencent.mm.m.g.Ze().YU();
        ((com.tencent.mm.ui.chatting.t)localObject1).Got = true;
        eXx();
        break;
      }
      this.GuH = null;
      if (com.tencent.mm.model.w.sw((String)localObject1))
      {
        eXz();
        j.a(this.cOd.GzJ, 2131302671);
        if (this.GuF == null) {}
        for (i = 1;; i = 0)
        {
          this.GuF = ((ChatFooterCustom)this.cOd.findViewById(2131302673));
          if (i != 0) {
            this.GuF.x((ViewGroup)this.cOd.findViewById(2131298070));
          }
          this.GuI = new com.tencent.mm.ui.chatting.w(this.GuF);
          this.GuI.eSK();
          eXx();
          break;
        }
      }
      this.GuI = null;
      if (com.tencent.mm.model.w.sA((String)localObject1))
      {
        eXz();
        j.a(this.cOd.GzJ, 2131302671);
        if (this.GuF == null) {}
        for (i = 1;; i = 0)
        {
          this.GuF = ((ChatFooterCustom)this.cOd.findViewById(2131302673));
          if (i != 0) {
            this.GuF.x((ViewGroup)this.cOd.findViewById(2131298070));
          }
          this.GuJ = new com.tencent.mm.ui.chatting.h(this.GuF);
          this.GuJ.eSK();
          eXx();
          break;
        }
      }
      this.GuJ = null;
      if ((!com.tencent.mm.model.w.sI((String)localObject1)) && (!com.tencent.mm.model.w.sw((String)localObject1)) && (!com.tencent.mm.model.w.sH((String)localObject1)) && (!com.tencent.mm.model.w.sA((String)localObject1)))
      {
        com.tencent.mm.model.w.art();
        if ((!com.tencent.mm.model.w.ti((String)localObject1)) && (!com.tencent.mm.model.w.sz((String)localObject1)) && (!com.tencent.mm.model.w.tn((String)localObject1))) {}
      }
      else
      {
        eXz();
        break;
      }
      eXy();
      ak(this.cOd.zgX);
      this.twb.setUserName((String)localObject1);
      aKI((String)localObject1);
      localObject1 = (com.tencent.mm.ui.chatting.c.b.j)this.cOd.be(com.tencent.mm.ui.chatting.c.b.j.class);
      Object localObject2 = (com.tencent.mm.ui.chatting.c.b.ae)this.cOd.be(com.tencent.mm.ui.chatting.c.b.ae.class);
      if (!((com.tencent.mm.ui.chatting.c.b.j)localObject1).eXi()) {
        break;
      }
      if (((com.tencent.mm.ui.chatting.c.b.ae)localObject2).eYu())
      {
        ((com.tencent.mm.ui.chatting.c.b.ae)localObject2).eYt();
        ((com.tencent.mm.ui.chatting.c.b.j)localObject1).eXj();
        break;
      }
      ((com.tencent.mm.ui.chatting.c.b.j)localObject1).eXg();
      break;
      label1576:
      this.CbR.us(false);
    }
  }
  
  public final void eQC() {}
  
  public final void eQD()
  {
    AppMethodBeat.i(35334);
    this.GuL = this.cOd.GzJ.getStringExtra("smiley_product_id");
    if (this.twb.srJ) {
      ((ag)this.cOd.be(ag.class)).keepSignalling();
    }
    if ((com.tencent.mm.model.w.sH(this.cOd.getTalkerUserName())) && (this.GuH != null) && (this.GuH.Got)) {
      this.GuH.eVJ();
    }
    ChatFooter localChatFooter = this.twb;
    Object localObject = this.cOd.GzJ;
    localChatFooter.CcE = ((MMFragment)localObject);
    localChatFooter.a(((MMFragment)localObject).getContext(), ((MMFragment)localObject).thisActivity());
    if ((localChatFooter.Cdf != null) && (localChatFooter.Cdf.isShowing())) {
      localChatFooter.Cdf.dismiss();
    }
    if ((!bt.isNullOrNil(this.GuL)) && (this.twb != null))
    {
      ad.d("MicroMsg.ChattingUI.FootComponent", "deal use smiley panel in product: %s", new Object[] { this.GuL });
      this.twb.setDefaultSmileyByDetail(this.GuL);
      this.twb.eyX();
    }
    this.cOd.GzJ.getContext().getIntent().putExtra("smiley_product_id", "");
    this.twb.setUserName(this.cOd.getTalkerUserName());
    com.tencent.mm.live.d.e.KxY = this.cOd.getTalkerUserName();
    localChatFooter = this.twb;
    localObject = this.cOd.eYX();
    String str = this.cOd.getTalkerUserName();
    localChatFooter.dpv = ((String)localObject);
    localChatFooter.toUser = str;
    if (this.cOd.GzJ.getBooleanExtra("key_show_bottom_app_panel", false).booleanValue())
    {
      localChatFooter = this.twb;
      if (localChatFooter.CbE != null)
      {
        localChatFooter.CbE.performClick();
        ad.d("MicroMsg.ChatFooter", "perform click attach bt to show bottom panel");
      }
    }
    if (ak(this.cOd.zgX))
    {
      if (this.twb != null)
      {
        az.arV();
        bool1 = ((Boolean)com.tencent.mm.model.c.afk().get(66832, Boolean.FALSE)).booleanValue();
        ad.d("MicroMsg.ChattingUI.FootComponent", "jacks refresh Footer Plugin Setting , Enable Enter Button: %B", new Object[] { Boolean.valueOf(bool1) });
        this.twb.ezz();
        if (bool1)
        {
          this.twb.ezm();
          this.twb.eyU();
        }
        if (bool1) {
          this.twb.ezd();
        }
        localChatFooter = this.twb;
        if (localChatFooter.Cbx != null) {
          localChatFooter.Cbx.eyv();
        }
      }
      ((com.tencent.mm.ui.chatting.c.b.aj)this.cOd.be(com.tencent.mm.ui.chatting.c.b.aj.class)).eXn();
      if (this.twb != null)
      {
        this.twb.Cbx.refresh();
        this.twb.addTextChangedListener(new t.a(this, (byte)0));
        ad.i("MicroMsg.ChattingUI.FootComponent", "addTextChangedListener");
      }
    }
    boolean bool1 = ((com.tencent.mm.ui.chatting.c.b.ae)this.cOd.be(com.tencent.mm.ui.chatting.c.b.ae.class)).eYx();
    boolean bool2 = ((com.tencent.mm.ui.chatting.c.b.ae)this.cOd.be(com.tencent.mm.ui.chatting.c.b.ae.class)).eYw();
    boolean bool3 = ((com.tencent.mm.ui.chatting.c.b.j)this.cOd.be(com.tencent.mm.ui.chatting.c.b.j.class)).eXi();
    boolean bool4 = com.tencent.mm.model.w.sz(this.cOd.getTalkerUserName());
    if (((!bool1) && (!bool2) && (!bool3)) || ((this.GuP) && (this.cOd.zgX != null) && (!this.cOd.zgX.eKB()) && (!com.tencent.mm.model.w.tk(this.cOd.getTalkerUserName())) && (!com.tencent.mm.ui.widget.snackbar.b.bcB()) && (!com.tencent.mm.model.w.sA(this.cOd.getTalkerUserName())) && (!bool4)))
    {
      ad.i("MicroMsg.ChattingUI.FootComponent", "call visibleFooter again.");
      eXy();
    }
    for (;;)
    {
      this.fpC.alive();
      this.fpB.alive();
      AppMethodBeat.o(35334);
      return;
      ad.i("MicroMsg.ChattingUI.FootComponent", "no call visibleFooter again.");
    }
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(35335);
    Object localObject;
    if (this.twb != null)
    {
      localObject = this.twb;
      if (((ChatFooter)localObject).Cee != null)
      {
        ((ChatFooter)localObject).tqv.removeTextChangedListener(((ChatFooter)localObject).Cee);
        ((ChatFooter)localObject).Cee = null;
      }
      ad.i("MicroMsg.ChattingUI.FootComponent", "removeTextChangeListener");
      this.twb.onPause();
      this.fpC.dead();
      this.fpB.dead();
      if (!com.tencent.mm.kernel.g.afw())
      {
        ad.w("MicroMsg.ChattingUI.FootComponent", "account not ready");
        AppMethodBeat.o(35335);
      }
    }
    else
    {
      AppMethodBeat.o(35335);
      return;
    }
    az.arV();
    com.tencent.mm.model.c.afk().set(18, Integer.valueOf(this.twb.getMode()));
    ad.d("MicroMsg.ChattingUI.FootComponent", "dkcm old:%d footer:%d ", new Object[] { Integer.valueOf(this.GuG), Integer.valueOf(this.twb.getMode()) });
    if (this.GuG != this.twb.getMode())
    {
      this.GuG = this.twb.getMode();
      az.arV();
      localObject = com.tencent.mm.model.c.apR().aIn(this.cOd.getTalkerUserName());
      if ((localObject != null) && (this.cOd.getTalkerUserName().equals(((ay)localObject).field_username)))
      {
        ((am)localObject).jU(this.GuG);
        az.arV();
        com.tencent.mm.model.c.apR().a((am)localObject, this.cOd.getTalkerUserName());
      }
    }
    this.twb.a(ChatFooter.h.CfE);
    AppMethodBeat.o(35335);
  }
  
  public final void eQF() {}
  
  public final void eWx()
  {
    AppMethodBeat.i(35332);
    super.eWx();
    if (this.twb != null)
    {
      this.twb.setFooterEventListener(null);
      com.tencent.mm.ui.chatting.p.dBh();
      this.GuE = null;
      this.twb.setSmileyPanelCallback(null);
      this.twb.setSmileyPanelCallback2(null);
    }
    if (this.GuF != null)
    {
      this.GuF.eUZ();
      this.GuF = null;
    }
    eXu();
    if (this.GuF != null) {
      this.GuF.eVc();
    }
    com.tencent.mm.pluginsdk.ui.span.k.clearCache();
    if (this.twb != null) {
      this.twb.ezv();
    }
    if ((this.cOd.GzJ.isCurrentActivity) && (this.twb != null)) {
      this.twb.destroy();
    }
    com.tencent.mm.kernel.g.afC();
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().b(this);
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().remove(this);
    AppMethodBeat.o(35332);
  }
  
  public final void eXA()
  {
    AppMethodBeat.i(35320);
    this.GuK = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.GuK.setInterpolator(new DecelerateInterpolator(1.5F));
    this.GuK.addAnimation(localTranslateAnimation);
    this.GuK.addAnimation(localAlphaAnimation);
    this.GuK.setDuration(300L);
    this.GuK.setFillBefore(true);
    if (this.twb != null) {
      this.twb.startAnimation(this.GuK);
    }
    AppMethodBeat.o(35320);
  }
  
  public final void eXB()
  {
    AppMethodBeat.i(35321);
    ad.i("MicroMsg.ChattingUI.FootComponent", "triggerFooter, originChatFooterVisibility:%s", new Object[] { Integer.valueOf(this.GuM) });
    if (this.twb == null)
    {
      this.twb = ((ChatFooter)this.cOd.findViewById(2131302672));
      this.twb.a(new ChatFooter.b()
      {
        public final com.tencent.mm.ui.chatting.h.b ezT()
        {
          return t.this.cOd.GzG;
        }
        
        public final String getTalkerUserName()
        {
          AppMethodBeat.i(35306);
          String str = t.this.cOd.getTalkerUserName();
          AppMethodBeat.o(35306);
          return str;
        }
      });
      ((com.tencent.mm.ui.chatting.c.b.p)this.cOd.be(com.tencent.mm.ui.chatting.c.b.p.class)).bw(this.twb);
      eXD();
    }
    if ((((com.tencent.mm.ui.chatting.c.b.j)this.cOd.be(com.tencent.mm.ui.chatting.c.b.j.class)).eXi()) || (com.tencent.mm.ui.widget.snackbar.b.bcB()))
    {
      if (!this.GuO) {
        this.GuM = this.twb.getVisibility();
      }
      this.twb.g(0, true, -1);
      if (this.GuF != null) {
        if (this.GuO) {}
      }
      for (this.GuN = this.GuF.getVisibility();; this.GuN = -1)
      {
        eXz();
        this.GuO = true;
        AppMethodBeat.o(35321);
        return;
      }
    }
    this.GuO = false;
    if ((this.GuM == 8) && (this.GuN == 8))
    {
      eXz();
      AppMethodBeat.o(35321);
      return;
    }
    if (this.GuM == 0)
    {
      eXy();
      AppMethodBeat.o(35321);
      return;
    }
    eXx();
    AppMethodBeat.o(35321);
  }
  
  public final void eXC()
  {
    AppMethodBeat.i(35324);
    String str = this.cOd.getTalkerUserName();
    int i;
    if ((com.tencent.mm.model.w.sJ(str)) || (com.tencent.mm.storage.af.aHE(str))) {
      i = 1;
    }
    while (i == 2)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.cOd.GzJ.getContext(), "android.permission.RECORD_AUDIO", 80, "", "");
      ad.i("MicroMsg.ChattingUI.FootComponent", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), this.cOd.GzJ.getContext() });
      if (bool) {
        break;
      }
      this.twb.aP(1, false);
      AppMethodBeat.o(35324);
      return;
      if (com.tencent.mm.model.w.ta(str))
      {
        i = 2;
      }
      else
      {
        int j = this.cOd.GzJ.getIntExtra("Chat_Mode", 0);
        ad.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", new Object[] { Integer.valueOf(this.GuG), Integer.valueOf(j) });
        if (this.GuG != 0) {
          j = this.GuG;
        }
        str = com.tencent.mm.m.g.Zd().getValue("DefaultMsgType");
        i = j;
        if (this.GuG == 0)
        {
          i = j;
          if (str != null)
          {
            ad.d("MicroMsg.ChattingUI.FootComponent", "config def chatmode is %s", new Object[] { str });
            i = bt.getInt(com.tencent.mm.m.g.Zd().getValue("DefaultMsgType"), 0);
          }
        }
        j = i;
        if (i == 0)
        {
          j = i;
          if (com.tencent.mm.n.b.ls(this.cOd.zgX.field_type))
          {
            az.arV();
            j = ((Integer)com.tencent.mm.model.c.afk().get(18, Integer.valueOf(0))).intValue();
          }
        }
        i = j;
        if (j == 0) {
          i = 1;
        }
        ad.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", new Object[] { Integer.valueOf(this.GuG), Integer.valueOf(i) });
      }
    }
    this.twb.aP(i, false);
    AppMethodBeat.o(35324);
  }
  
  public final ChatFooter eXs()
  {
    return this.twb;
  }
  
  public final ChatFooterCustom eXt()
  {
    return this.GuF;
  }
  
  public final String eXv()
  {
    return this.GuL;
  }
  
  public final void eXw()
  {
    AppMethodBeat.i(35316);
    try
    {
      if (this.twb.ezq()) {
        this.twb.setBottomPanelVisibility(8);
      }
      AppMethodBeat.o(35316);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(35316);
    }
  }
  
  public final void eXx()
  {
    AppMethodBeat.i(35317);
    this.cOd.hideVKB();
    ad.i("MicroMsg.ChattingUI.FootComponent", "visibleCustomFooter customFooter is %s", new Object[] { this.GuF });
    if (this.GuF == null)
    {
      AppMethodBeat.o(35317);
      return;
    }
    this.GuF.setVisibility(0);
    if (this.twb != null)
    {
      this.twb.g(0, false, -1);
      this.twb.setVisibility(8);
    }
    AppMethodBeat.o(35317);
  }
  
  public final void eXy()
  {
    AppMethodBeat.i(35318);
    if (this.twb == null)
    {
      AppMethodBeat.o(35318);
      return;
    }
    this.twb.setVisibility(0);
    if (this.GuF != null) {
      this.GuF.setVisibility(8);
    }
    AppMethodBeat.o(35318);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35329);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((1111 == paramInt1) && (-1 == paramInt2)) {
      this.twb.eyX();
    }
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 200) || (paramInt1 == 201) || (paramInt1 == 203)) {
        this.twb.clearFocus();
      }
      AppMethodBeat.o(35329);
      return;
    }
    if ((paramInt1 != 217) && (this.GuF != null)) {
      this.GuF.q(paramInt1, paramIntent);
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35329);
      return;
      if (paramIntent == null)
      {
        ad.e("MicroMsg.ChattingUI.FootComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
        AppMethodBeat.o(35329);
        return;
      }
      paramInt1 = paramIntent.getIntExtra("Chat_Mode", 1);
      if (this.twb != null) {
        this.twb.setMode(paramInt1);
      }
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int j = 0;
    AppMethodBeat.i(35331);
    ad.i("MicroMsg.ChattingUI.FootComponent", "chatting onKeyDown, code:%d action:%d", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    if (paramKeyEvent.getKeyCode() == 4) {
      if (!this.cOd.ctF) {
        ad.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown back key fragment not foreground");
      }
    }
    for (;;)
    {
      int i = 0;
      for (;;)
      {
        if (i != 0) {
          break label476;
        }
        boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
        AppMethodBeat.o(35331);
        return bool;
        if ((this.cOd.GzJ.isSupportNavigationSwipeBack()) && (this.cOd.GzJ.getSwipeBackLayout().ezp()))
        {
          ad.w("MicroMsg.ChattingUI.FootComponent", "ashutest::onKeyDown back ScrollToFinishing");
          i = 1;
        }
        else
        {
          if (paramKeyEvent.getAction() == 0)
          {
            this.GuQ = true;
            this.GuS = System.currentTimeMillis();
          }
          if (paramKeyEvent.getAction() != 1) {
            break label356;
          }
          ad.d("MicroMsg.ChattingUI.FootComponent", "hasBack %B, %d", new Object[] { Boolean.valueOf(this.GuQ), Long.valueOf(System.currentTimeMillis() - this.GuS) });
          if ((this.GuQ) && (System.currentTimeMillis() - this.GuS <= 30000L)) {
            break;
          }
          i = 1;
        }
      }
      this.GuR = true;
      Object localObject = (com.tencent.mm.ui.chatting.c.b.j)this.cOd.be(com.tencent.mm.ui.chatting.c.b.j.class);
      com.tencent.mm.ui.chatting.c.b.ae localae = (com.tencent.mm.ui.chatting.c.b.ae)this.cOd.be(com.tencent.mm.ui.chatting.c.b.ae.class);
      if (((com.tencent.mm.ui.chatting.c.b.j)localObject).eXi()) {
        if (localae.eYu())
        {
          localae.eYt();
          ((com.tencent.mm.ui.chatting.c.b.j)localObject).eXj();
          label291:
          i = 1;
          label293:
          if (i == 0) {
            if (this.twb != null)
            {
              localObject = this.twb;
              if ((((ChatFooter)localObject).Ccj == 0) && (!((ChatFooter)localObject).BWK)) {
                break label387;
              }
              if (!((ChatFooter)localObject).BWK) {
                break label376;
              }
              ((ChatFooter)localObject).exL();
              label339:
              i = 1;
            }
          }
        }
      }
      for (;;)
      {
        if (i == 0) {
          this.cOd.GzJ.eUW();
        }
        label356:
        i = 1;
        break;
        ((com.tencent.mm.ui.chatting.c.b.j)localObject).eXg();
        break label291;
        i = 0;
        break label293;
        label376:
        ((ChatFooter)localObject).g(0, true, -1);
        break label339;
        label387:
        i = j;
        if (((ChatFooter)localObject).Cdy != null)
        {
          i = j;
          if (((ChatFooter)localObject).Cdy.getVisibility() == 0)
          {
            ((ChatFooter)localObject).Cdy.dQI();
            i = 1;
          }
        }
      }
      if ((paramKeyEvent.getKeyCode() == 67) && (!this.cOd.ctF)) {
        ad.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown back key fragment not foreground");
      } else if (!this.cOd.ctF) {
        ad.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown fragment not foreground");
      }
    }
    label476:
    AppMethodBeat.o(35331);
    return true;
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(35330);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      if (paramArrayOfInt == null) {}
      for (i = -1;; i = paramArrayOfInt.length)
      {
        ad.w("MicroMsg.ChattingUI.FootComponent", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, bt.eGN() });
        AppMethodBeat.o(35330);
        return;
      }
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35330);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ad.i("MicroMsg.ChattingUI.FootComponent", "summerper doFooterLiveRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.GuE, bt.eGN() });
        if (this.GuE != null) {
          this.GuE.twL.fXT();
        }
        AppMethodBeat.o(35330);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131761860;; paramInt = 2131761871)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(paramInt), this.cOd.GzJ.getMMResources().getString(2131761885), this.cOd.GzJ.getMMResources().getString(2131760598), this.cOd.GzJ.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35311);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = t.this.cOd.GzJ;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/component/FootComponent$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(35311);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35301);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35301);
            }
          });
        }
        AppMethodBeat.o(35330);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        ad.i("MicroMsg.ChattingUI.FootComponent", "summerper doFooterSightRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.GuE, bt.eGN() });
        if (this.GuE != null)
        {
          paramArrayOfString = this.GuE;
          if (!this.twb.Cbx.Cal.CaZ.value) {
            break label446;
          }
        }
        label446:
        for (paramInt = i;; paramInt = 2)
        {
          paramArrayOfString.Yv(paramInt);
          AppMethodBeat.o(35330);
          return;
        }
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131761860;; paramInt = 2131761871)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(paramInt), this.cOd.GzJ.getMMResources().getString(2131761885), this.cOd.GzJ.getMMResources().getString(2131760598), this.cOd.GzJ.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35302);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = t.this.cOd.GzJ;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/component/FootComponent$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(35302);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35303);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35303);
            }
          });
        }
        AppMethodBeat.o(35330);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        if (paramInt == 19)
        {
          ad.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuVideoSelected,footerEventImpl[%s], stack[%s]", new Object[] { this.GuE, bt.eGN() });
          if (this.GuE != null) {
            this.GuE.dcN();
          }
          AppMethodBeat.o(35330);
          return;
        }
        if (paramInt == 21)
        {
          ad.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.GuE, bt.eGN() });
          if (this.GuE != null) {
            this.GuE.eVB();
          }
          AppMethodBeat.o(35330);
          return;
        }
        ad.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnEnterMultiTalk,footerEventImpl[%s], stack[%s]", new Object[] { this.GuE, bt.eGN() });
        if (this.GuE != null) {
          this.GuE.eVz();
        }
        AppMethodBeat.o(35330);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131761860;; paramInt = 2131761871)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(paramInt), this.cOd.GzJ.getMMResources().getString(2131761885), this.cOd.GzJ.getMMResources().getString(2131760598), this.cOd.GzJ.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(163307);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = t.this.cOd.GzJ;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/component/FootComponent$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(163307);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(163308);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(163308);
            }
          });
        }
        AppMethodBeat.o(35330);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        ad.i("MicroMsg.ChattingUI.FootComponent", "summerper doImageSelectTakePhotoRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.GuE, bt.eGN() });
        if (this.GuE != null) {
          this.GuE.eVD();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131761860), this.cOd.GzJ.getMMResources().getString(2131761885), this.cOd.GzJ.getMMResources().getString(2131760598), this.cOd.GzJ.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(169867);
          paramAnonymousDialogInterface = t.this.cOd.GzJ;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/component/FootComponent$15", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$15", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(169867);
        }
      }, null);
      AppMethodBeat.o(35330);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ad.i("MicroMsg.ChattingUI.FootComponent", "summerper doTalkRoomRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.GuE, bt.eGN() });
        if (this.GuE != null) {
          this.GuE.eVC();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131761869), this.cOd.GzJ.getMMResources().getString(2131761885), this.cOd.GzJ.getMMResources().getString(2131760598), this.cOd.GzJ.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(184958);
          paramAnonymousDialogInterface = t.this.cOd.GzJ;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/component/FootComponent$16", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$16", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(184958);
        }
      }, null);
      AppMethodBeat.o(35330);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        if (paramInt == 82)
        {
          ad.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuAudioSelected,footerEventImpl[%s], stack[%s]", new Object[] { this.GuE, bt.eGN() });
          if (this.GuE != null) {
            this.GuE.dcM();
          }
          AppMethodBeat.o(35330);
          return;
        }
        ad.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipAudioRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.GuE, bt.eGN() });
        if (this.GuE != null) {
          this.GuE.eVA();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131761871), this.cOd.GzJ.getMMResources().getString(2131761885), this.cOd.GzJ.getMMResources().getString(2131760598), this.cOd.GzJ.getMMResources().getString(2131756766), false, new t.17(this), null);
      AppMethodBeat.o(35330);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ad.i("MicroMsg.ChattingUI.FootComponent", "doSendFileRequest, footerEventImpl[%s], stack[%s].", new Object[] { this.GuE, bt.eGN() });
        if (this.GuE != null) {
          this.GuE.eVw();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131761878), this.cOd.GzJ.getMMResources().getString(2131761885), this.cOd.GzJ.getMMResources().getString(2131760598), this.cOd.GzJ.getMMResources().getString(2131759760), false, new t.18(this), null);
    }
  }
  
  public final void setVoiceInputShowCallback(ChatFooter.d paramd)
  {
    AppMethodBeat.i(35326);
    this.twb.setVoiceInputShowCallback(paramd);
    AppMethodBeat.o(35326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.t
 * JD-Core Version:    0.7.0.1
 */