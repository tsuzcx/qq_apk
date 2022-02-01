package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.tencent.mm.al.a.l;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.c;
import com.tencent.mm.emoji.a.b.b.b;
import com.tencent.mm.emoji.a.b.j.b;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.g.b.a.fj;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
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
import com.tencent.mm.pluginsdk.ui.chat.m.5;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI;
import com.tencent.mm.ui.chatting.AtSomeoneUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.c.b.ag;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.c.a.a(foJ=com.tencent.mm.ui.chatting.c.b.q.class)
public class t
  extends a
  implements k.a, n.b, com.tencent.mm.ui.chatting.c.b.q
{
  private static ArrayList<a.a> HUt = null;
  private static long HUu = 0L;
  private final ChatFooter.g Duj;
  private com.tencent.mm.ui.chatting.h HUA;
  private AnimationSet HUB;
  private String HUC;
  private int HUD;
  private int HUE;
  private boolean HUF;
  public boolean HUG;
  private boolean HUH;
  public boolean HUI;
  private long HUJ;
  private com.tencent.mm.ui.chatting.p HUv;
  protected ChatFooterCustom HUw;
  private int HUx;
  private com.tencent.mm.ui.chatting.t HUy;
  private com.tencent.mm.ui.chatting.w HUz;
  private com.tencent.mm.sdk.b.c ftd;
  private com.tencent.mm.sdk.b.c fte;
  protected ChatFooter uEt;
  
  public t()
  {
    AppMethodBeat.i(35314);
    this.HUx = 0;
    this.HUC = null;
    this.HUF = false;
    this.HUG = false;
    this.ftd = new com.tencent.mm.sdk.b.c() {};
    this.fte = new com.tencent.mm.sdk.b.c() {};
    this.Duj = new ChatFooter.g()
    {
      private Animation HUL;
      private Animation HUM;
      
      public final boolean vu(boolean paramAnonymousBoolean)
      {
        int i = 1;
        AppMethodBeat.i(35305);
        if (this.HUL == null)
        {
          this.HUL = AnimationUtils.loadAnimation(t.this.cLy.HZF.getContext(), 2130772108);
          this.HUM = AnimationUtils.loadAnimation(t.this.cLy.HZF.getContext(), 2130772106);
        }
        com.tencent.mm.ui.chatting.c.b.d locald;
        String str;
        if (paramAnonymousBoolean)
        {
          ac.i("MicroMsg.ChattingUI.FootComponent", "switchFooterToInput customFooter is %s", new Object[] { t.this.HUw });
          if (t.this.HUw != null) {
            t.this.HUw.startAnimation(this.HUM);
          }
          t.this.fnk();
          t.this.uEt.startAnimation(this.HUL);
          t.this.uEt.postInvalidateDelayed(this.HUL.getDuration());
          locald = (com.tencent.mm.ui.chatting.c.b.d)t.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class);
          if (locald != null)
          {
            str = t.this.cLy.getTalkerUserName();
            if (!paramAnonymousBoolean) {
              break label262;
            }
          }
        }
        for (;;)
        {
          locald.gb(str, i);
          AppMethodBeat.o(35305);
          return false;
          t.this.uEt.startAnimation(this.HUM);
          t.this.fnj();
          if (t.this.HUw == null) {
            break;
          }
          t.this.HUw.startAnimation(this.HUL);
          t.this.HUw.postInvalidateDelayed(this.HUL.getDuration());
          break;
          label262:
          i = 2;
        }
      }
    };
    this.HUH = false;
    this.HUI = false;
    this.HUJ = 0L;
    AppMethodBeat.o(35314);
  }
  
  private void a(final String paramString, final ar.b.a parama)
  {
    AppMethodBeat.i(163315);
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184961);
        ar.a.hnw.a(paramString, "", parama);
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
  
  private void a(String paramString, ai paramai, ArrayList<a.a> paramArrayList)
  {
    AppMethodBeat.i(163316);
    long l1;
    if (paramai == null)
    {
      l1 = 0L;
      ac.i("MicroMsg.ChattingUI.FootComponent", "ChatroomBusinessType user %s %s", new Object[] { paramString, Long.valueOf(l1) });
      if ((!this.cLy.foP()) || (paramai == null) || (paramai.eyr == 0L)) {
        break label222;
      }
      if (HUt != null) {
        break label166;
      }
      HUt = new ArrayList();
      fnq();
      HUu = ce.azH();
    }
    for (;;)
    {
      paramString = HUt;
      if ((paramString == null) || (paramString.size() <= 0)) {
        break label222;
      }
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        a.a locala = (a.a)paramString.next();
        if ((locala.DtL & paramai.eyr) != 0L)
        {
          locala.jjp = paramai.field_username;
          paramArrayList.add(locala);
        }
      }
      l1 = paramai.eyr;
      break;
      label166:
      l1 = ce.azH();
      long l2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pZi, 1800);
      if (l1 - HUu > l2)
      {
        HUu = l1;
        HUt.clear();
        fnq();
      }
    }
    label222:
    this.uEt.setAppPanelUnCertainEnterArrayList(paramArrayList);
    AppMethodBeat.o(163316);
  }
  
  private void aQl(final String paramString)
  {
    AppMethodBeat.i(35325);
    ac.i("MicroMsg.ChattingUI.FootComponent", "initFooterPanelMenu %s", new Object[] { paramString });
    this.uEt.eOw();
    this.uEt.eOn();
    int i;
    Object localObject1;
    int j;
    label126:
    boolean bool1;
    if (((com.tencent.mm.ui.chatting.c.b.j)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.j.class)).fmU())
    {
      ac.w("MicroMsg.ChattingUI.FootComponent", "match shake, in show mode, do not open short video recode view");
      i = 0;
      if (i == 0) {
        this.uEt.eOy();
      }
      if (((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmo())
      {
        localObject1 = com.tencent.mm.al.f.dX(this.cLy.getTalkerUserName());
        if ((localObject1 != null) && (((com.tencent.mm.api.c)localObject1).field_enterpriseFather != null)) {
          break label2246;
        }
        j = 0;
        if (j != 0)
        {
          localObject1 = this.uEt.DtP;
          ((AppPanel)localObject1).DsB.Dtt.value = true;
          ((AppPanel)localObject1).eNZ();
        }
      }
      if (!this.cLy.foQ()) {
        this.uEt.eOF();
      }
      bool1 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pUd, true);
      localObject1 = this.uEt;
      if (!com.tencent.mm.sdk.platformtools.h.DEBUG) {
        break label2300;
      }
      i = 1;
      label206:
      ac.i("MicroMsg.ChattingUI.FootComponent", "isGroupChat:%b enableLive:%b", new Object[] { Boolean.valueOf(this.cLy.foQ()), Boolean.valueOf(bool1) });
      if ((this.cLy.foQ()) && (bool1) && (i != 0)) {
        break label2528;
      }
      this.uEt.DtP.eNY();
      label268:
      if (!com.tencent.mm.model.w.wp(this.cLy.getTalkerUserName())) {
        this.uEt.DtP.eNY();
      }
      if ((this.cLy.AzG != null) && (!com.tencent.mm.n.b.ln(this.cLy.AzG.field_type)) && (!com.tencent.mm.model.w.sQ(this.cLy.getTalkerUserName()))) {
        this.uEt.eOB();
      }
      if (ai.ww(paramString))
      {
        this.uEt.DtP.eNQ();
        this.uEt.DtP.eNS();
        this.uEt.DtP.eNT();
        this.uEt.eOz();
        this.uEt.eOA();
        this.uEt.DtP.eNR();
        this.uEt.aG(true, true);
        this.uEt.eOB();
        this.uEt.eOD();
        this.uEt.DtP.eNV();
        this.uEt.DtP.eNY();
      }
      if (ai.aNb(paramString))
      {
        this.uEt.DtP.eNQ();
        this.uEt.DtP.eNS();
        this.uEt.DtP.eNT();
        this.uEt.eOz();
        this.uEt.eOA();
        this.uEt.DtP.eNR();
        this.uEt.aG(true, true);
        this.uEt.eOB();
        this.uEt.eOD();
        this.uEt.DtP.eNV();
        this.uEt.DtP.eNY();
      }
      if (ai.aMZ(paramString))
      {
        this.uEt.DtP.eNQ();
        this.uEt.DtP.eNS();
        this.uEt.DtP.eNT();
        this.uEt.eOz();
        this.uEt.eOv();
        this.uEt.eOA();
        this.uEt.DtP.eNR();
        this.uEt.aG(true, true);
        this.uEt.eOB();
        this.uEt.eOD();
        this.uEt.DtP.eNV();
        this.uEt.DtP.eNY();
      }
      if (com.tencent.mm.model.w.wW(paramString))
      {
        this.uEt.DtP.eNQ();
        this.uEt.DtP.eNS();
        this.uEt.DtP.eNT();
        this.uEt.eOA();
        this.uEt.DtP.eNR();
        this.uEt.aG(true, true);
        this.uEt.eOB();
        this.uEt.eOD();
        this.uEt.DtP.eNV();
        this.uEt.DtP.eNY();
      }
      if (com.tencent.mm.model.w.wT(paramString))
      {
        this.uEt.DtP.eNQ();
        this.uEt.aG(true, true);
        this.uEt.DtP.eNR();
        this.uEt.DtP.eNV();
        this.uEt.DtP.eNY();
      }
      com.tencent.mm.model.az.ayM();
      localObject1 = com.tencent.mm.model.c.awB().aNt(paramString);
      if ((localObject1 != null) && (((ai)localObject1).fad()))
      {
        if (!((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmo()) {
          break label2554;
        }
        this.uEt.DtP.eNQ();
        this.uEt.DtP.eNT();
        this.uEt.DtP.eNR();
        this.uEt.aG(true, true);
        this.uEt.eOB();
        this.uEt.eOD();
        this.uEt.eOy();
        this.uEt.DtP.eNU();
        this.uEt.eOx();
        this.uEt.eOE();
        this.uEt.eMH();
        this.uEt.DtP.eNY();
      }
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.b.a.GpY.l(new qd());
        if (this.cLy.foP())
        {
          if (com.tencent.mm.m.g.ZY().getInt("MultitalkBlockCaller", 0) == 0)
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            this.uEt.vg(false);
            if ((this.cLy.foQ()) || (this.cLy.foO()))
            {
              this.uEt.aG(true, true);
              this.uEt.eOD();
            }
            com.tencent.mm.br.d.eQD();
            if (this.cLy.foO()) {
              this.uEt.DtP.eNR();
            }
            if (this.cLy.getTalkerUserName().equals(com.tencent.mm.model.u.axw()))
            {
              this.uEt.DtP.eNR();
              this.uEt.aG(true, true);
              this.uEt.eOB();
              this.uEt.eOD();
              this.uEt.DtP.eNY();
            }
            this.uEt.setAppPanelTip(null);
            if ((!ai.aNc(this.cLy.AzG.field_username)) && (!com.tencent.mm.model.w.wq(this.cLy.AzG.field_username))) {
              continue;
            }
            com.tencent.mm.kernel.g.agS();
            Object localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.cLy.AzG.field_username);
            ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).bA(((av)localObject3).field_openImAppid, ((av)localObject3).field_descWordingId);
            i = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).Fn(((av)localObject3).field_openImAppid);
            Object localObject2 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(this.cLy.AzG.field_openImAppid, "openim_function_tip", com.tencent.mm.openim.a.b.a.inW);
            ac.i("MicroMsg.ChattingUI.FootComponent", "openim showFlag:%d username: %s appid: %s tip %s", new Object[] { Integer.valueOf(i), this.cLy.AzG.field_username, ((av)localObject3).field_openImAppid, localObject2 });
            if ((i & 0x1) == 0) {
              this.uEt.eOv();
            }
            if ((i & 0x2) == 0) {
              this.uEt.eOx();
            }
            if ((i & 0x4) == 0)
            {
              localObject3 = this.uEt.DtP;
              ((AppPanel)localObject3).DsB.Dta.value = false;
              ((AppPanel)localObject3).eNZ();
            }
            if ((i & 0x8) == 0) {
              this.uEt.eOz();
            }
            if ((i & 0x10) == 0) {
              this.uEt.DtP.eNS();
            }
            if ((i & 0x20) == 0) {
              this.uEt.DtP.eNQ();
            }
            if ((i & 0x40) == 0) {
              this.uEt.DtP.eNV();
            }
            if ((i & 0x80) == 0) {
              this.uEt.eOA();
            }
            if (((i & 0x100) == 0) || ((i & 0x2000) == 0))
            {
              localObject3 = this.uEt;
              if ((i & 0x100) != 0) {
                continue;
              }
              bool1 = true;
              if ((i & 0x2000) != 0) {
                continue;
              }
              bool2 = true;
              ((ChatFooter)localObject3).aG(bool1, bool2);
            }
            if ((i & 0x200) == 0)
            {
              this.uEt.eOB();
              this.uEt.eOD();
            }
            if ((i & 0x400) == 0) {
              this.uEt.eOC();
            }
            if ((com.tencent.mm.model.w.wq(this.cLy.AzG.field_username)) && ((i & 0x100) == 0)) {
              this.uEt.vg(true);
            }
            this.uEt.setAppPanelTip((CharSequence)localObject2);
            localObject2 = this.uEt;
            com.tencent.mm.br.d.eQD();
            if (((ChatFooter)localObject2).fWT != null) {
              ((ChatFooter)localObject2).fWT.eMI();
            }
            localObject2 = this.uEt;
            com.tencent.mm.br.d.eQD();
            if (!com.tencent.mm.aw.b.aGa()) {
              continue;
            }
            bool1 = true;
            ((ChatFooter)localObject2).vh(bool1);
            this.uEt.DtP.eNR();
            if (ai.vC(this.cLy.getTalkerUserName()))
            {
              this.uEt.eOn();
              this.uEt.eOv();
              this.uEt.DtP.eNT();
              this.uEt.eOF();
              this.uEt.DtP.eNY();
              this.uEt.eOA();
              this.uEt.eOx();
              this.uEt.eOz();
              this.uEt.DtP.eNQ();
              this.uEt.eOy();
              this.uEt.eOA();
              this.uEt.eOx();
              this.uEt.eOE();
              this.uEt.eMH();
              this.uEt.DtP.eNU();
              this.uEt.aG(true, true);
              this.uEt.vg(true);
              this.uEt.vh(true);
              this.uEt.eOB();
              this.uEt.eOD();
              this.uEt.DtP.eNR();
              this.uEt.DtP.eNQ();
              this.uEt.DtP.eNS();
              this.uEt.DtP.eNV();
            }
            if ((!com.tencent.mm.chatroom.d.aa.VQ()) || (!com.tencent.mm.model.w.wp(this.cLy.getTalkerUserName()))) {
              this.uEt.DtP.eNW();
            }
            if (!((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).ahZ(this.cLy.getTalkerUserName())) {
              this.uEt.DtP.eNX();
            }
            localObject2 = new ArrayList();
            a(paramString, (ai)localObject1, (ArrayList)localObject2);
            paramString = new ar.b.a()
            {
              public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(163312);
                if ((paramAnonymousBoolean) && (bs.lr(t.this.cLy.getTalkerUserName(), paramAnonymousString))) {
                  com.tencent.mm.kernel.g.agU().az(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(163310);
                      t.a(t.this, t.15.this.cLs, t.15.this.fzF, new ArrayList());
                      com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(163309);
                          ChatFooter localChatFooter = t.this.uEt;
                          if ((localChatFooter.DtW != null) && (localChatFooter.DtW.getVisibility() == 0)) {
                            localChatFooter.vt(true);
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
            if ((((ArrayList)localObject2).size() != 0) || (localObject1 == null) || (((av)localObject1).eyr != 0L)) {
              continue;
            }
            if (!com.tencent.mm.model.w.sQ(this.cLy.getTalkerUserName())) {
              continue;
            }
            localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.cLy.getTalkerUserName());
            if ((localObject1 != null) && ((((x)localObject1).field_chatroomStatus & 0x8000) != 0L) && ((((x)localObject1).field_chatroomfamilystatusmodifytime == 0L) || (((x)localObject1).field_chatroomfamilystatusmodifytime - ce.azI() >= 86400000L)))
            {
              ((x)localObject1).field_chatroomfamilystatusmodifytime = ce.azI();
              ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().update((com.tencent.mm.sdk.e.c)localObject1, new String[0]);
              a(this.cLy.getTalkerUserName(), paramString);
            }
            AppMethodBeat.o(35325);
            return;
            bool1 = ((com.tencent.mm.ui.chatting.c.b.ae)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.ae.class)).foj();
            bool2 = ((com.tencent.mm.ui.chatting.c.b.ae)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.ae.class)).foi();
            if ((bool1) || (bool2))
            {
              ac.w("MicroMsg.ChattingUI.FootComponent", "match shake, in search mode, do not open short video recode view");
              i = 0;
              break;
            }
            if ((ai.aNb(this.cLy.getTalkerUserName())) || (ai.ww(this.cLy.getTalkerUserName())))
            {
              ac.w("MicroMsg.ChattingUI.FootComponent", "match shake, but is Qcontact or Bcontact");
              i = 0;
              break;
            }
            if (com.tencent.mm.model.w.xr(this.cLy.getTalkerUserName()))
            {
              i = 0;
              break;
            }
            i = 1;
            break;
            label2246:
            localObject1 = com.tencent.mm.al.af.aCW().AF(((com.tencent.mm.api.c)localObject1).field_enterpriseFather);
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
            label2300:
            if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED))
            {
              i = bs.getInt(com.tencent.mm.m.g.ZY().getValue("ChatRoomEnableLive"), 0);
              if (i == 0)
              {
                localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(((ChatFooter)localObject1).DtO);
                if (localObject1 == null) {
                  break label2860;
                }
                if ((((x)localObject1).field_chatroomStatus & 0x80000) == 524288)
                {
                  j = 1;
                  i = j;
                  if (j != 0) {
                    break label206;
                  }
                  if (com.tencent.mm.kernel.g.agR().agA().getInt(ah.a.GWb, 0) != 1) {
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
            if (((ChatFooter)localObject1).DtO == null) {
              continue;
            }
            i = bs.getInt(com.tencent.mm.m.g.ZY().getValue("ChatRoomEnableLive"), 0);
            if (i == 0)
            {
              localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(((ChatFooter)localObject1).DtO);
              if (localObject1 == null) {
                continue;
              }
              if ((((x)localObject1).field_chatroomStatus & 0x80000) == 524288)
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
            label2528:
            localObject1 = this.uEt.DtP;
            ((AppPanel)localObject1).DsB.vo(true);
            ((AppPanel)localObject1).eNZ();
            break label268;
            label2554:
            this.uEt.DtP.eNQ();
            this.uEt.aG(true, true);
            this.uEt.eOz();
            this.uEt.DtP.eNR();
            this.uEt.DtP.eNY();
            continue;
          }
          i = 0;
          continue;
        }
        this.uEt.vg(true);
        continue;
        bool1 = false;
        continue;
        boolean bool2 = false;
        continue;
        if (!com.tencent.mm.model.w.ws(this.cLy.AzG.field_username)) {
          continue;
        }
        i = com.tencent.mm.model.u.ayg();
        if ((i & 0x1) == 0) {
          this.uEt.vg(true);
        }
        if ((i & 0x2) == 0) {
          this.uEt.eOB();
        }
        if ((i & 0x4) != 0) {
          continue;
        }
        this.uEt.eOC();
        continue;
        bool1 = false;
        continue;
        if (com.tencent.mm.model.w.wq(this.cLy.getTalkerUserName()))
        {
          localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.cLy.getTalkerUserName());
          if ((localObject1 != null) && ((((x)localObject1).eZJ().type & 0x4) != 0L) && ((((x)localObject1).field_chatroomfamilystatusmodifytime == 0L) || (((x)localObject1).field_chatroomfamilystatusmodifytime - ce.azI() >= 86400000L)))
          {
            ((x)localObject1).field_chatroomfamilystatusmodifytime = ce.azI();
            ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().update((com.tencent.mm.sdk.e.c)localObject1, new String[0]);
            a(this.cLy.getTalkerUserName(), paramString);
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
      label2860:
      j = 0;
    }
  }
  
  private static void aQm(String paramString)
  {
    AppMethodBeat.i(163318);
    if (bs.isNullOrNil(paramString))
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
        locala.DtA = paramString.optString("enter_id");
        locala.DtB = paramString.optInt("red_dot");
        locala.vjP = paramString.optInt("jump_type");
        locala.DtC = paramString.optString("wa_un");
        locala.DtD = paramString.optInt("wa_ver");
        locala.DtE = paramString.optString("wa_path");
        locala.DtF = paramString.optString("wa_dgmode");
        locala.lze = paramString.optString("h5_url");
        locala.iconUrl = paramString.optString("icon_url");
        locala.DtK = paramString.optString("icon_url_dark");
        if (bs.isNullOrNil(locala.iconUrl))
        {
          ac.e("MicroMsg.ChattingUI.FootComponent", "unCertainEnter.iconUrl is null");
        }
        else
        {
          locala.DtL = paramString.optLong("busi_type");
          localObject = paramString.optJSONObject("title");
          localJSONObject = paramString.optJSONObject("desc");
          if (localObject == null) {
            ac.e("MicroMsg.ChattingUI.FootComponent", "titleJson is null");
          }
        }
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.ChattingUI.FootComponent", "handleAppPanelUnCertainEnterConfig() Exception:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(163318);
        return;
      }
      locala.DtG.title = ((JSONObject)localObject).optString("zh_cn");
      if (bs.isNullOrNil(locala.DtG.title))
      {
        ac.e("MicroMsg.ChattingUI.FootComponent", "unCertainEnter.simpleChWord.title is null");
      }
      else
      {
        a.b localb = locala.DtI;
        if (bs.isNullOrNil(((JSONObject)localObject).optString("zh_tw")))
        {
          paramString = locala.DtG.title;
          localb.title = paramString;
          localb = locala.DtH;
          if (!bs.isNullOrNil(((JSONObject)localObject).optString("zh_hk"))) {
            break label586;
          }
          paramString = locala.DtG.title;
          label391:
          localb.title = paramString;
          localb = locala.DtJ;
          if (!bs.isNullOrNil(((JSONObject)localObject).optString("en"))) {
            break label598;
          }
          paramString = locala.DtG.title;
          label427:
          localb.title = paramString;
          if (localJSONObject != null)
          {
            locala.DtG.desc = localJSONObject.optString("zh_cn");
            localObject = locala.DtI;
            if (!bs.isNullOrNil(localJSONObject.optString("zh_tw"))) {
              break label610;
            }
            paramString = locala.DtG.desc;
            label484:
            ((a.b)localObject).desc = paramString;
            localObject = locala.DtH;
            if (!bs.isNullOrNil(localJSONObject.optString("zh_hk"))) {
              break label622;
            }
            paramString = locala.DtG.desc;
            label520:
            ((a.b)localObject).desc = paramString;
            localObject = locala.DtJ;
            if (!bs.isNullOrNil(localJSONObject.optString("en"))) {
              break label634;
            }
          }
        }
        label586:
        label598:
        label610:
        label622:
        label634:
        for (paramString = locala.DtG.desc;; paramString = localJSONObject.optString("en"))
        {
          ((a.b)localObject).desc = paramString;
          HUt.add(locala);
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
  
  private void fng()
  {
    AppMethodBeat.i(35315);
    if (this.cLy.HZF.isCurrentActivity)
    {
      AppMethodBeat.o(35315);
      return;
    }
    this.cLy.HZH.flC();
    if (this.uEt != null)
    {
      ChatFooter localChatFooter = this.uEt;
      Object localObject = localChatFooter.findViewById(2131298150);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localChatFooter.setSwitchButtonMode(0);
      localChatFooter.mHandler.removeMessages(1002);
      if (localChatFooter.DtW != null) {
        localChatFooter.DtW.setVisibility(8);
      }
      if (localChatFooter.DtX != null) {
        localChatFooter.DtX.setVisibility(8);
      }
      if (localChatFooter.DtY != null) {
        localChatFooter.DtY.setVisibility(8);
      }
      if (localChatFooter.Dub != null) {
        localChatFooter.Dub.setVisibility(8);
      }
      if (localChatFooter.DtZ != null) {
        localChatFooter.DtZ.setVisibility(8);
      }
      if (localChatFooter.Duc != null) {
        localChatFooter.Duc.setVisibility(8);
      }
      localChatFooter.fTu.setVisibility(8);
      if (localChatFooter.qNh != null) {
        localChatFooter.qNh.setVisibility(8);
      }
      if (localChatFooter.Dvb != null) {
        localChatFooter.Dvb.setVisibility(8);
      }
      if (localChatFooter.qNi != null) {
        localChatFooter.qNi.setVisibility(8);
      }
      if (localChatFooter.qNf != null) {
        localChatFooter.qNf.setVisibility(8);
      }
      if (localChatFooter.DoY != null)
      {
        localChatFooter.DoY.setVisibility(8);
        localChatFooter.Dpb = false;
        localChatFooter.DoY.destroy();
      }
      if (localChatFooter.Duq != null) {
        localChatFooter.Duq.setVisibility(8);
      }
      if (localChatFooter.zXb != null) {
        localChatFooter.zXb.setVisibility(8);
      }
      if (localChatFooter.zWY != null) {
        localChatFooter.zWY.update();
      }
      if (localChatFooter.DtQ != null) {
        localChatFooter.DtQ.setVisibility(8);
      }
      if (localChatFooter.DtU != null)
      {
        localChatFooter.DtU.setVisibility(4);
        if (localChatFooter.fWT != null) {
          localChatFooter.fWT.setVisibility(4);
        }
      }
      localChatFooter.DtP = ((AppPanel)localChatFooter.findViewById(2131297977));
      if (localChatFooter.DtP != null)
      {
        localChatFooter.setAppPanelVisible(8);
        localObject = localChatFooter.DtP;
        if (((AppPanel)localObject).xgP != null) {
          ((AppPanel)localObject).xgP.setToScreen(0);
        }
        ((AppPanel)localObject).Dsz = 0;
      }
      localChatFooter.a(ChatFooter.h.DxT);
      localChatFooter.g(0, false, -1);
      localChatFooter.Dup = false;
      localChatFooter = this.uEt;
      if (!bs.aj(localChatFooter.uyM.getText())) {
        localChatFooter.uyM.setText("");
      }
      localChatFooter.vp(false);
      localChatFooter.eOl();
      this.uEt.eOm();
      this.uEt.Dum.DxJ = null;
    }
    AppMethodBeat.o(35315);
  }
  
  private void fnl()
  {
    AppMethodBeat.i(35319);
    ac.i("MicroMsg.ChattingUI.FootComponent", "[goneFooter] %s", new Object[] { bs.eWi() });
    if (this.uEt != null)
    {
      this.uEt.g(0, false, -1);
      this.uEt.setVisibility(8);
    }
    if (this.HUw != null) {
      this.HUw.setVisibility(8);
    }
    this.uEt.vp(false);
    this.cLy.hideVKB();
    AppMethodBeat.o(35319);
  }
  
  private void fnp()
  {
    AppMethodBeat.i(184963);
    if (this.uEt == null)
    {
      ac.e("MicroMsg.ChattingUI.FootComponent", "initTodoView footer == null");
      AppMethodBeat.o(184963);
      return;
    }
    ac.i("MicroMsg.ChattingUI.FootComponent", "initTodoView()");
    ((com.tencent.mm.ui.chatting.c.b.u)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.u.class)).a(this.uEt.getIOnToDoBarCallback());
    this.uEt.setIOnTodoViewCallback(new x.c()
    {
      public final int cSy()
      {
        AppMethodBeat.i(185866);
        int i = ((com.tencent.mm.ui.chatting.c.b.u)t.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.u.class)).cSy();
        AppMethodBeat.o(185866);
        return i;
      }
      
      public final void xi(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(185864);
        ((com.tencent.mm.ui.chatting.c.b.u)t.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.u.class)).xi(paramAnonymousBoolean);
        AppMethodBeat.o(185864);
      }
      
      public final void xj(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(185865);
        ((com.tencent.mm.ui.chatting.c.b.u)t.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.u.class)).xj(paramAnonymousBoolean);
        AppMethodBeat.o(185865);
      }
    });
    AppMethodBeat.o(184963);
  }
  
  private static void fnq()
  {
    AppMethodBeat.i(163317);
    aQm(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pYY, ""));
    aQm(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pYZ, ""));
    aQm(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pZa, ""));
    aQm(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pZb, ""));
    aQm(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pZc, ""));
    aQm(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pZd, ""));
    aQm(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pZe, ""));
    aQm(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pZf, ""));
    aQm(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pZg, ""));
    aQm(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pZh, ""));
    AppMethodBeat.o(163317);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(35327);
    if (paramObject != null) {
      paramObject.equals("");
    }
    ac.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", new Object[] { paramObject, this.cLy.getTalkerUserName() });
    if (paramObject.equals(this.cLy.getTalkerUserName()))
    {
      aQl(this.cLy.getTalkerUserName());
      fno();
    }
    AppMethodBeat.o(35327);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(35328);
    if (paramString != null) {
      paramString.equals("");
    }
    ac.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", new Object[] { paramString, this.cLy.getTalkerUserName() });
    if (com.tencent.mm.model.w.wq(this.cLy.getTalkerUserName()))
    {
      aQl(this.cLy.getTalkerUserName());
      fno();
    }
    AppMethodBeat.o(35328);
  }
  
  public final boolean aE(bo parambo)
  {
    AppMethodBeat.i(35323);
    if (this.uEt != null) {
      this.uEt.aE(parambo);
    }
    AppMethodBeat.o(35323);
    return true;
  }
  
  public final boolean al(ai paramai)
  {
    AppMethodBeat.i(35322);
    boolean bool1 = ((com.tencent.mm.ui.chatting.c.b.ae)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.ae.class)).foj();
    boolean bool2 = ((com.tencent.mm.ui.chatting.c.b.ae)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.ae.class)).foi();
    boolean bool3 = ((com.tencent.mm.ui.chatting.c.b.j)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.j.class)).fmU();
    boolean bool4 = ((com.tencent.mm.ui.chatting.c.b.o)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.o.class)).fnd();
    if (this.HUG)
    {
      AppMethodBeat.o(35322);
      return true;
    }
    if ((bool1) || (bool2) || (bool3) || (bool4))
    {
      ac.i("MicroMsg.ChattingUI.FootComponent", bool1 + ", " + bool2 + ", " + bool3 + ", " + bool4);
      fnl();
      AppMethodBeat.o(35322);
      return false;
    }
    if ((paramai != null) && (com.tencent.mm.model.w.wD(paramai.field_username)))
    {
      this.HUA = new com.tencent.mm.ui.chatting.h(this.HUw);
      this.HUA.fiu();
      fnj();
      AppMethodBeat.o(35322);
      return true;
    }
    com.tencent.mm.ui.chatting.c.b.d locald;
    Object localObject1;
    int i;
    if ((paramai != null) && (paramai.fad()))
    {
      locald = (com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class);
      if (locald.fml() != null)
      {
        localObject1 = locald.fml().bV(false);
        if (localObject1 != null)
        {
          if (((c.b)localObject1).cFq != null) {
            ((c.b)localObject1).cFs = "1".equals(((c.b)localObject1).cFq.optString("IsHideInputToolbarInMsg"));
          }
          if (((c.b)localObject1).cFs)
          {
            ac.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + paramai.field_username + " is hide tool bar");
            fnl();
            AppMethodBeat.o(35322);
            return false;
          }
        }
        if ((!bs.isNullOrNil(paramai.field_username)) && (localObject1 != null))
        {
          i = this.cLy.HZF.getIntExtra("key_temp_session_show_type", 0);
          switch (((c.b)localObject1).Jf())
          {
          default: 
            fnk();
            paramai = paramai.field_username;
            if (localObject1 == null) {
              break;
            }
          }
        }
      }
    }
    for (bool1 = true;; bool1 = false)
    {
      ac.e("MicroMsg.ChattingUI.FootComponent", "bizinfo name=%s, %b, %d", new Object[] { paramai, Boolean.valueOf(bool1), Integer.valueOf(((c.b)localObject1).Jf()) });
      for (;;)
      {
        AppMethodBeat.o(35322);
        return true;
        ac.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + paramai.field_username + " is show custom menu");
        if (this.HUw == null)
        {
          j.a(this.cLy.HZF, 2131302671);
          this.HUw = ((ChatFooterCustom)this.cLy.findViewById(2131302673));
          if (this.HUw != null) {
            this.HUw.y((ViewGroup)this.cLy.findViewById(2131298070));
          }
        }
        localObject1 = ((c.b)localObject1).Jn();
        try
        {
          Iterator localIterator = ((c.b.c)localObject1).cGb.iterator();
          while (localIterator.hasNext())
          {
            Object localObject2 = (com.tencent.mm.al.j)localIterator.next();
            if (!bs.isNullOrNil(((com.tencent.mm.al.j)localObject2).dBy)) {
              ((com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).a(((com.tencent.mm.al.j)localObject2).dBy, -1, "", bs.bG(((com.tencent.mm.al.j)localObject2).name, ""), "", "", 4);
            }
            if (!bs.isNullOrNil(((com.tencent.mm.al.j)localObject2).value)) {
              ((com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).a(((com.tencent.mm.al.j)localObject2).value, -1, "", bs.bG(((com.tencent.mm.al.j)localObject2).name, ""), "", "", 4);
            }
            localObject2 = ((com.tencent.mm.al.j)localObject2).hxQ.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              com.tencent.mm.al.j localj = (com.tencent.mm.al.j)((Iterator)localObject2).next();
              if (!bs.isNullOrNil(localj.dBy)) {
                ((com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).a(localj.dBy, -1, "", bs.bG(localj.name, ""), "", "", 4);
              }
              if (!bs.isNullOrNil(localj.value)) {
                ((com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).a(localj.value, -1, "", bs.bG(localj.name, ""), "", "", 4);
              }
            }
          }
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.ChattingUI.FootComponent", localException, "preauth when chat foot", new Object[0]);
          if ((localObject1 != null) && (((c.b.c)localObject1).type == 1))
          {
            this.uEt.setSwitchButtonMode(1);
            this.uEt.setOnFooterSwitchListener(((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fms());
            fnk();
          }
          else
          {
            this.uEt.setSwitchButtonMode(0);
            try
            {
              if (!com.tencent.mm.model.w.wz(paramai.field_username)) {
                break label1024;
              }
              this.HUz = new com.tencent.mm.ui.chatting.w(this.HUw);
              this.HUz.fiu();
              fnj();
            }
            catch (Exception paramai)
            {
              if (localObject1 == null) {
                break label1004;
              }
            }
            if ((((c.b.c)localObject1).cGb == null) || (((c.b.c)localObject1).cGb.size() == 0)) {
              label1004:
              fnk();
            }
          }
        }
      }
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.ChattingUI.FootComponent", paramai, "", new Object[0]);
        break;
        label1024:
        ChatFooterCustom localChatFooterCustom = this.HUw;
        if ((localChatFooterCustom.HLb != null) && (localChatFooterCustom.HLa != null))
        {
          localChatFooterCustom.HLb.setVisibility(0);
          localChatFooterCustom.HLa.setVisibility(0);
        }
        if (localChatFooterCustom.HLc != null) {
          localChatFooterCustom.HLc.fkR();
        }
        this.HUw.setTalker(this.cLy.AzG);
        this.HUw.a(this.cLy.HZF, locald.fml(), paramai.field_username);
        this.HUw.setOnFooterSwitchListener(this.Duj);
        this.HUw.setOnProcessClickListener(((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmr());
        this.uEt.setOnFooterSwitchListener(this.Duj);
        if ((((com.tencent.mm.ui.chatting.c.b.aa)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.aa.class)).fob()) && (i == 1))
        {
          fnk();
          break;
        }
        fnj();
        break;
        this.Duj.vu(true);
      }
    }
  }
  
  public final void fgg()
  {
    AppMethodBeat.i(196474);
    this.HUG = this.cLy.HZF.getBooleanExtra("show_footer", false).booleanValue();
    AppMethodBeat.o(196474);
  }
  
  public final void fgh()
  {
    AppMethodBeat.i(35333);
    this.HUH = false;
    this.HUI = false;
    this.HUJ = 0L;
    com.tencent.mm.model.az.ayM();
    Object localObject1 = com.tencent.mm.model.c.awG().aNI(this.cLy.getTalkerUserName());
    if (localObject1 != null) {
      this.HUx = ((com.tencent.mm.g.c.az)localObject1).field_chatmode;
    }
    ac.d("MicroMsg.ChattingUI.FootComponent", "dkcm init old:%d   ", new Object[] { Integer.valueOf(this.HUx) });
    localObject1 = this.cLy.getTalkerUserName();
    if (this.uEt == null)
    {
      this.uEt = ((ChatFooter)this.cLy.findViewById(2131302672));
      this.uEt.a(new ChatFooter.b()
      {
        public final com.tencent.mm.ui.chatting.h.b ePn()
        {
          return t.this.cLy.HZC;
        }
        
        public final String getTalkerUserName()
        {
          AppMethodBeat.i(35307);
          String str = t.this.cLy.getTalkerUserName();
          AppMethodBeat.o(35307);
          return str;
        }
      });
      ((com.tencent.mm.ui.chatting.c.b.p)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.p.class)).bw(this.uEt);
      fnp();
    }
    this.uEt.setCattingRootLayoutId(2131298066);
    ac.i("MicroMsg.ChattingUI.FootComponent", "resetFooter customFooter is %s", new Object[] { this.HUw });
    if (this.HUw != null)
    {
      this.HUw.fkL();
      this.HUw.setOnFooterSwitchListener(null);
      this.HUw.setOnProcessClickListener(null);
      this.uEt.setOnFooterSwitchListener(null);
      this.HUw.fkO();
    }
    fnl();
    this.uEt.eOw();
    boolean bool1 = ((com.tencent.mm.ui.chatting.c.b.ae)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.ae.class)).foj();
    boolean bool2 = ((com.tencent.mm.ui.chatting.c.b.ae)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.ae.class)).foi();
    int i;
    if ((!this.HUG) && ((bool1) || (bool2)))
    {
      fnl();
      fng();
      this.HUv = new com.tencent.mm.ui.chatting.p(this.cLy, this.uEt, this.cLy.getTalkerUserName());
      this.HUv.HNe = this.cLy.HZF.getBooleanExtra("key_need_send_video", true).booleanValue();
      this.uEt.setFooterEventListener(this.HUv);
      localObject1 = new v(this.cLy, this.cLy.AzG, this.cLy.getTalkerUserName());
      this.uEt.setSmileyPanelCallback((com.tencent.mm.pluginsdk.ui.chat.f)localObject1);
      this.uEt.setSmileyPanelCallback2((com.tencent.mm.pluginsdk.ui.chat.j)localObject1);
      fno();
      this.uEt.eOo();
      i = this.cLy.HZF.getIntExtra("key_temp_session_show_type", 0);
      localObject1 = (com.tencent.mm.ui.chatting.c.b.aa)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.aa.class);
      ac.i("MicroMsg.ChattingUI.FootComponent", "isTempSession : %s, showType : %d.", new Object[] { Boolean.valueOf(((com.tencent.mm.ui.chatting.c.b.aa)localObject1).fob()), Integer.valueOf(i) });
      ac.d("MicroMsg.ChattingUI.FootComponent", "is temp session : %s.", new Object[] { Boolean.valueOf(((com.tencent.mm.ui.chatting.c.b.aa)localObject1).fob()) });
      if (((com.tencent.mm.ui.chatting.c.b.aa)localObject1).fob())
      {
        if (i != 1) {
          break label1576;
        }
        this.Duj.vu(true);
      }
    }
    for (;;)
    {
      al(this.cLy.AzG);
      com.tencent.mm.kernel.g.agS();
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().a(this);
      ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().add(this);
      AppMethodBeat.o(35333);
      return;
      if (com.tencent.mm.model.w.wK((String)localObject1))
      {
        fnl();
        j.a(this.cLy.HZF, 2131302671);
        if (this.HUw == null)
        {
          i = 1;
          this.HUw = ((ChatFooterCustom)this.cLy.findViewById(2131302673));
          if (i != 0) {
            this.HUw.y((ViewGroup)this.cLy.findViewById(2131298070));
          }
          this.HUy = new com.tencent.mm.ui.chatting.t(this.HUw);
          localObject1 = this.HUy;
          if (com.tencent.mm.sdk.platformtools.i.cGY != 1) {
            break label878;
          }
          i = 1;
          label695:
          ((com.tencent.mm.ui.chatting.t)localObject1).HOd.findViewById(2131298098).setVisibility(8);
          ((com.tencent.mm.ui.chatting.t)localObject1).plH = ((LinearLayout)((com.tencent.mm.ui.chatting.t)localObject1).HOd.findViewById(2131298093));
          ((com.tencent.mm.ui.chatting.t)localObject1).HOd.findViewById(2131298092).setVisibility(8);
          localObject2 = ((com.tencent.mm.ui.chatting.t)localObject1).plH;
          if (i == 0) {
            break label883;
          }
        }
        label878:
        label883:
        for (float f = 1.0F;; f = 2.0F)
        {
          ((LinearLayout)localObject2).setWeightSum(f);
          ((com.tencent.mm.ui.chatting.t)localObject1).HOe = ((FrameLayout)((com.tencent.mm.ui.chatting.t)localObject1).plH.getChildAt(0));
          ((com.tencent.mm.ui.chatting.t)localObject1).HOe.setVisibility(0);
          ((com.tencent.mm.ui.chatting.t)localObject1).HOe.setOnClickListener(((com.tencent.mm.ui.chatting.t)localObject1).HOn);
          ((TextView)((com.tencent.mm.ui.chatting.t)localObject1).HOe.findViewById(2131298095)).setText(2131757079);
          ((com.tencent.mm.ui.chatting.t)localObject1).HOe.findViewById(2131298094).setVisibility(8);
          if (i == 0) {
            break label888;
          }
          i = 1;
          while (i < 6)
          {
            ((com.tencent.mm.ui.chatting.t)localObject1).plH.getChildAt(i).setVisibility(8);
            i += 1;
          }
          i = 0;
          break;
          i = 0;
          break label695;
        }
        label888:
        ((com.tencent.mm.ui.chatting.t)localObject1).HOf = ((FrameLayout)((com.tencent.mm.ui.chatting.t)localObject1).plH.getChildAt(1));
        ((com.tencent.mm.ui.chatting.t)localObject1).HOf.setVisibility(0);
        ((com.tencent.mm.ui.chatting.t)localObject1).HOf.setOnClickListener(((com.tencent.mm.ui.chatting.t)localObject1).HOo);
        ((com.tencent.mm.ui.chatting.t)localObject1).HOg = ((TextView)((com.tencent.mm.ui.chatting.t)localObject1).HOf.findViewById(2131298095));
        ((com.tencent.mm.ui.chatting.t)localObject1).HOh = ((ImageView)((com.tencent.mm.ui.chatting.t)localObject1).HOf.findViewById(2131298094));
        ((com.tencent.mm.ui.chatting.t)localObject1).HOh.setVisibility(0);
        ((com.tencent.mm.ui.chatting.t)localObject1).flu();
        com.tencent.mm.model.az.ayM();
        ((com.tencent.mm.ui.chatting.t)localObject1).HOj = ((Integer)com.tencent.mm.model.c.agA().get(ah.a.GEP, Integer.valueOf(-1))).intValue();
        if (((com.tencent.mm.ui.chatting.t)localObject1).HOj >= 0) {
          ((com.tencent.mm.ui.chatting.t)localObject1).flw();
        }
        for (;;)
        {
          i = 2;
          while (i < 6)
          {
            ((com.tencent.mm.ui.chatting.t)localObject1).plH.getChildAt(i).setVisibility(8);
            i += 1;
          }
          ((com.tencent.mm.ui.chatting.t)localObject1).HOg.setText(2131757092);
        }
        ((com.tencent.mm.ui.chatting.t)localObject1).HOm = com.tencent.mm.m.g.ZZ().getMailAppEnterUlAndroid();
        if (bs.isNullOrNil(((com.tencent.mm.ui.chatting.t)localObject1).HOm)) {
          ((com.tencent.mm.ui.chatting.t)localObject1).HOm = "qqmail://folderlist?app=weixin&action=list&uin=$uin$";
        }
        com.tencent.mm.model.az.ayM();
        localObject2 = new com.tencent.mm.b.p(bs.m((Integer)com.tencent.mm.model.c.agA().get(9, null))).toString();
        ((com.tencent.mm.ui.chatting.t)localObject1).HOm = ((com.tencent.mm.ui.chatting.t)localObject1).HOm.replace("$uin$", (CharSequence)localObject2);
        ((com.tencent.mm.ui.chatting.t)localObject1).vZG = com.tencent.mm.m.g.ZZ().ZR();
        ((com.tencent.mm.ui.chatting.t)localObject1).HOk = true;
        fnj();
        break;
      }
      this.HUy = null;
      if (com.tencent.mm.model.w.wz((String)localObject1))
      {
        fnl();
        j.a(this.cLy.HZF, 2131302671);
        if (this.HUw == null) {}
        for (i = 1;; i = 0)
        {
          this.HUw = ((ChatFooterCustom)this.cLy.findViewById(2131302673));
          if (i != 0) {
            this.HUw.y((ViewGroup)this.cLy.findViewById(2131298070));
          }
          this.HUz = new com.tencent.mm.ui.chatting.w(this.HUw);
          this.HUz.fiu();
          fnj();
          break;
        }
      }
      this.HUz = null;
      if (com.tencent.mm.model.w.wD((String)localObject1))
      {
        fnl();
        j.a(this.cLy.HZF, 2131302671);
        if (this.HUw == null) {}
        for (i = 1;; i = 0)
        {
          this.HUw = ((ChatFooterCustom)this.cLy.findViewById(2131302673));
          if (i != 0) {
            this.HUw.y((ViewGroup)this.cLy.findViewById(2131298070));
          }
          this.HUA = new com.tencent.mm.ui.chatting.h(this.HUw);
          this.HUA.fiu();
          fnj();
          break;
        }
      }
      this.HUA = null;
      if ((!com.tencent.mm.model.w.wL((String)localObject1)) && (!com.tencent.mm.model.w.wz((String)localObject1)) && (!com.tencent.mm.model.w.wK((String)localObject1)) && (!com.tencent.mm.model.w.wD((String)localObject1)))
      {
        com.tencent.mm.model.w.ayj();
        if ((!com.tencent.mm.model.w.xl((String)localObject1)) && (!com.tencent.mm.model.w.wC((String)localObject1)) && (!com.tencent.mm.model.w.xq((String)localObject1))) {}
      }
      else
      {
        fnl();
        break;
      }
      fnk();
      al(this.cLy.AzG);
      this.uEt.setUserName((String)localObject1);
      aQl((String)localObject1);
      localObject1 = (com.tencent.mm.ui.chatting.c.b.j)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.j.class);
      Object localObject2 = (com.tencent.mm.ui.chatting.c.b.ae)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.ae.class);
      if (!((com.tencent.mm.ui.chatting.c.b.j)localObject1).fmU()) {
        break;
      }
      if (((com.tencent.mm.ui.chatting.c.b.ae)localObject2).fog())
      {
        ((com.tencent.mm.ui.chatting.c.b.ae)localObject2).fof();
        ((com.tencent.mm.ui.chatting.c.b.j)localObject1).fmV();
        break;
      }
      ((com.tencent.mm.ui.chatting.c.b.j)localObject1).fmS();
      break;
      label1576:
      this.Duj.vu(false);
    }
  }
  
  public final void fgi() {}
  
  public final void fgj()
  {
    AppMethodBeat.i(35334);
    this.HUC = this.cLy.HZF.getStringExtra("smiley_product_id");
    if (this.uEt.tzA) {
      ((ag)this.cLy.bf(ag.class)).keepSignalling();
    }
    if ((com.tencent.mm.model.w.wK(this.cLy.getTalkerUserName())) && (this.HUy != null) && (this.HUy.HOk)) {
      this.HUy.flv();
    }
    ChatFooter localChatFooter = this.uEt;
    Object localObject = this.cLy.HZF;
    localChatFooter.DuW = ((MMFragment)localObject);
    localChatFooter.a(((MMFragment)localObject).getContext(), ((MMFragment)localObject).thisActivity());
    if ((localChatFooter.Dvx != null) && (localChatFooter.Dvx.isShowing())) {
      localChatFooter.Dvx.dismiss();
    }
    if ((!bs.isNullOrNil(this.HUC)) && (this.uEt != null))
    {
      ac.d("MicroMsg.ChattingUI.FootComponent", "deal use smiley panel in product: %s", new Object[] { this.HUC });
      this.uEt.setDefaultSmileyByDetail(this.HUC);
      this.uEt.eOr();
    }
    this.cLy.HZF.getContext().getIntent().putExtra("smiley_product_id", "");
    this.uEt.setUserName(this.cLy.getTalkerUserName());
    com.tencent.mm.live.d.e.gEy = this.cLy.getTalkerUserName();
    localChatFooter = this.uEt;
    localObject = this.cLy.foM();
    String str = this.cLy.getTalkerUserName();
    localChatFooter.dng = ((String)localObject);
    localChatFooter.toUser = str;
    if (this.cLy.HZF.getBooleanExtra("key_show_bottom_app_panel", false).booleanValue())
    {
      localChatFooter = this.uEt;
      if (localChatFooter.DtW != null)
      {
        localChatFooter.DtW.performClick();
        ac.d("MicroMsg.ChatFooter", "perform click attach bt to show bottom panel");
      }
    }
    if (al(this.cLy.AzG))
    {
      if (this.uEt != null)
      {
        com.tencent.mm.model.az.ayM();
        bool1 = ((Boolean)com.tencent.mm.model.c.agA().get(66832, Boolean.FALSE)).booleanValue();
        ac.d("MicroMsg.ChattingUI.FootComponent", "jacks refresh Footer Plugin Setting , Enable Enter Button: %B", new Object[] { Boolean.valueOf(bool1) });
        this.uEt.eOT();
        if (bool1)
        {
          this.uEt.eOG();
          this.uEt.eOo();
        }
        if (bool1) {
          this.uEt.eOx();
        }
        localChatFooter = this.uEt;
        if (localChatFooter.DtP != null) {
          localChatFooter.DtP.eNP();
        }
      }
      ((com.tencent.mm.ui.chatting.c.b.aj)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.aj.class)).fmZ();
      if (this.uEt != null)
      {
        this.uEt.DtP.refresh();
        this.uEt.addTextChangedListener(new a((byte)0));
        ac.i("MicroMsg.ChattingUI.FootComponent", "addTextChangedListener");
      }
    }
    boolean bool1 = ((com.tencent.mm.ui.chatting.c.b.ae)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.ae.class)).foj();
    boolean bool2 = ((com.tencent.mm.ui.chatting.c.b.ae)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.ae.class)).foi();
    boolean bool3 = ((com.tencent.mm.ui.chatting.c.b.j)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.j.class)).fmU();
    boolean bool4 = com.tencent.mm.model.w.wC(this.cLy.getTalkerUserName());
    if (((!bool1) && (!bool2) && (!bool3)) || ((this.HUG) && (this.cLy.AzG != null) && (!this.cLy.AzG.fad()) && (!com.tencent.mm.model.w.xn(this.cLy.getTalkerUserName())) && (!com.tencent.mm.ui.widget.snackbar.b.bjw()) && (!com.tencent.mm.model.w.wD(this.cLy.getTalkerUserName())) && (!bool4)))
    {
      ac.i("MicroMsg.ChattingUI.FootComponent", "call visibleFooter again.");
      fnk();
    }
    for (;;)
    {
      this.fte.alive();
      this.ftd.alive();
      AppMethodBeat.o(35334);
      return;
      ac.i("MicroMsg.ChattingUI.FootComponent", "no call visibleFooter again.");
    }
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(35335);
    Object localObject;
    if (this.uEt != null)
    {
      localObject = this.uEt;
      if (((ChatFooter)localObject).Dww != null)
      {
        ((ChatFooter)localObject).uyM.removeTextChangedListener(((ChatFooter)localObject).Dww);
        ((ChatFooter)localObject).Dww = null;
      }
      ac.i("MicroMsg.ChattingUI.FootComponent", "removeTextChangeListener");
      this.uEt.onPause();
      this.fte.dead();
      this.ftd.dead();
      if (!com.tencent.mm.kernel.g.agM())
      {
        ac.w("MicroMsg.ChattingUI.FootComponent", "account not ready");
        AppMethodBeat.o(35335);
      }
    }
    else
    {
      AppMethodBeat.o(35335);
      return;
    }
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.agA().set(18, Integer.valueOf(this.uEt.getMode()));
    ac.d("MicroMsg.ChattingUI.FootComponent", "dkcm old:%d footer:%d ", new Object[] { Integer.valueOf(this.HUx), Integer.valueOf(this.uEt.getMode()) });
    if (this.HUx != this.uEt.getMode())
    {
      this.HUx = this.uEt.getMode();
      com.tencent.mm.model.az.ayM();
      localObject = com.tencent.mm.model.c.awG().aNI(this.cLy.getTalkerUserName());
      if ((localObject != null) && (this.cLy.getTalkerUserName().equals(((com.tencent.mm.g.c.az)localObject).field_username)))
      {
        ((com.tencent.mm.storage.ap)localObject).jS(this.HUx);
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.model.c.awG().a((com.tencent.mm.storage.ap)localObject, this.cLy.getTalkerUserName());
      }
    }
    this.uEt.a(ChatFooter.h.DxV);
    AppMethodBeat.o(35335);
  }
  
  public final void fgl() {}
  
  public final void fmj()
  {
    AppMethodBeat.i(35332);
    super.fmj();
    if (this.uEt != null)
    {
      this.uEt.setFooterEventListener(null);
      com.tencent.mm.ui.chatting.p.dPE();
      this.HUv = null;
      this.uEt.setSmileyPanelCallback(null);
      this.uEt.setSmileyPanelCallback2(null);
    }
    if (this.HUw != null)
    {
      this.HUw.fkL();
      this.HUw = null;
    }
    fng();
    if (this.HUw != null) {
      this.HUw.fkO();
    }
    com.tencent.mm.pluginsdk.ui.span.k.clearCache();
    if (this.uEt != null) {
      this.uEt.eOP();
    }
    if ((this.cLy.HZF.isCurrentActivity) && (this.uEt != null)) {
      this.uEt.destroy();
    }
    com.tencent.mm.kernel.g.agS();
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().b(this);
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().remove(this);
    AppMethodBeat.o(35332);
  }
  
  public final ChatFooter fne()
  {
    return this.uEt;
  }
  
  public final ChatFooterCustom fnf()
  {
    return this.HUw;
  }
  
  public final String fnh()
  {
    return this.HUC;
  }
  
  public final void fni()
  {
    AppMethodBeat.i(35316);
    try
    {
      if (this.uEt.eOK()) {
        this.uEt.setBottomPanelVisibility(8);
      }
      AppMethodBeat.o(35316);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(35316);
    }
  }
  
  public final void fnj()
  {
    AppMethodBeat.i(35317);
    this.cLy.hideVKB();
    ac.i("MicroMsg.ChattingUI.FootComponent", "visibleCustomFooter customFooter is %s", new Object[] { this.HUw });
    if (this.HUw == null)
    {
      AppMethodBeat.o(35317);
      return;
    }
    this.HUw.setVisibility(0);
    if (this.uEt != null)
    {
      this.uEt.g(0, false, -1);
      this.uEt.setVisibility(8);
    }
    AppMethodBeat.o(35317);
  }
  
  public final void fnk()
  {
    AppMethodBeat.i(35318);
    if (this.uEt == null)
    {
      AppMethodBeat.o(35318);
      return;
    }
    this.uEt.setVisibility(0);
    if (this.HUw != null) {
      this.HUw.setVisibility(8);
    }
    AppMethodBeat.o(35318);
  }
  
  public final void fnm()
  {
    AppMethodBeat.i(35320);
    this.HUB = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.HUB.setInterpolator(new DecelerateInterpolator(1.5F));
    this.HUB.addAnimation(localTranslateAnimation);
    this.HUB.addAnimation(localAlphaAnimation);
    this.HUB.setDuration(300L);
    this.HUB.setFillBefore(true);
    if (this.uEt != null) {
      this.uEt.startAnimation(this.HUB);
    }
    AppMethodBeat.o(35320);
  }
  
  public final void fnn()
  {
    AppMethodBeat.i(35321);
    ac.i("MicroMsg.ChattingUI.FootComponent", "triggerFooter, originChatFooterVisibility:%s", new Object[] { Integer.valueOf(this.HUD) });
    if (this.uEt == null)
    {
      this.uEt = ((ChatFooter)this.cLy.findViewById(2131302672));
      this.uEt.a(new ChatFooter.b()
      {
        public final com.tencent.mm.ui.chatting.h.b ePn()
        {
          return t.this.cLy.HZC;
        }
        
        public final String getTalkerUserName()
        {
          AppMethodBeat.i(35306);
          String str = t.this.cLy.getTalkerUserName();
          AppMethodBeat.o(35306);
          return str;
        }
      });
      ((com.tencent.mm.ui.chatting.c.b.p)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.p.class)).bw(this.uEt);
      fnp();
    }
    if ((((com.tencent.mm.ui.chatting.c.b.j)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.j.class)).fmU()) || (com.tencent.mm.ui.widget.snackbar.b.bjw()))
    {
      if (!this.HUF) {
        this.HUD = this.uEt.getVisibility();
      }
      this.uEt.g(0, true, -1);
      if (this.HUw != null) {
        if (this.HUF) {}
      }
      for (this.HUE = this.HUw.getVisibility();; this.HUE = -1)
      {
        fnl();
        this.HUF = true;
        AppMethodBeat.o(35321);
        return;
      }
    }
    this.HUF = false;
    if ((this.HUD == 8) && (this.HUE == 8))
    {
      fnl();
      AppMethodBeat.o(35321);
      return;
    }
    if (this.HUD == 0)
    {
      fnk();
      AppMethodBeat.o(35321);
      return;
    }
    fnj();
    AppMethodBeat.o(35321);
  }
  
  public final void fno()
  {
    AppMethodBeat.i(35324);
    String str = this.cLy.getTalkerUserName();
    int i;
    if ((com.tencent.mm.model.w.wM(str)) || (ai.aMZ(str))) {
      i = 1;
    }
    while (i == 2)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.cLy.HZF.getContext(), "android.permission.RECORD_AUDIO", 80, "", "");
      ac.i("MicroMsg.ChattingUI.FootComponent", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this.cLy.HZF.getContext() });
      if (bool) {
        break;
      }
      this.uEt.aT(1, false);
      AppMethodBeat.o(35324);
      return;
      if (com.tencent.mm.model.w.xd(str))
      {
        i = 2;
      }
      else
      {
        int j = this.cLy.HZF.getIntExtra("Chat_Mode", 0);
        ac.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", new Object[] { Integer.valueOf(this.HUx), Integer.valueOf(j) });
        if (this.HUx != 0) {
          j = this.HUx;
        }
        str = com.tencent.mm.m.g.ZY().getValue("DefaultMsgType");
        i = j;
        if (this.HUx == 0)
        {
          i = j;
          if (str != null)
          {
            ac.d("MicroMsg.ChattingUI.FootComponent", "config def chatmode is %s", new Object[] { str });
            i = bs.getInt(com.tencent.mm.m.g.ZY().getValue("DefaultMsgType"), 0);
          }
        }
        j = i;
        if (i == 0)
        {
          j = i;
          if (com.tencent.mm.n.b.ln(this.cLy.AzG.field_type))
          {
            com.tencent.mm.model.az.ayM();
            j = ((Integer)com.tencent.mm.model.c.agA().get(18, Integer.valueOf(0))).intValue();
          }
        }
        i = j;
        if (j == 0) {
          i = 1;
        }
        ac.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", new Object[] { Integer.valueOf(this.HUx), Integer.valueOf(i) });
      }
    }
    this.uEt.aT(i, false);
    AppMethodBeat.o(35324);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35329);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((1111 == paramInt1) && (-1 == paramInt2)) {
      this.uEt.eOr();
    }
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 200) || (paramInt1 == 201) || (paramInt1 == 203)) {
        this.uEt.clearFocus();
      }
      AppMethodBeat.o(35329);
      return;
    }
    if ((paramInt1 != 217) && (this.HUw != null)) {
      this.HUw.q(paramInt1, paramIntent);
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
        ac.e("MicroMsg.ChattingUI.FootComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
        AppMethodBeat.o(35329);
        return;
      }
      paramInt1 = paramIntent.getIntExtra("Chat_Mode", 1);
      if (this.uEt != null) {
        this.uEt.setMode(paramInt1);
      }
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int j = 0;
    AppMethodBeat.i(35331);
    ac.i("MicroMsg.ChattingUI.FootComponent", "chatting onKeyDown, code:%d action:%d", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    if (paramKeyEvent.getKeyCode() == 4) {
      if (!this.cLy.cqM) {
        ac.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown back key fragment not foreground");
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
        if ((this.cLy.HZF.isSupportNavigationSwipeBack()) && (this.cLy.HZF.getSwipeBackLayout().eOJ()))
        {
          ac.w("MicroMsg.ChattingUI.FootComponent", "ashutest::onKeyDown back ScrollToFinishing");
          i = 1;
        }
        else
        {
          if (paramKeyEvent.getAction() == 0)
          {
            this.HUH = true;
            this.HUJ = System.currentTimeMillis();
          }
          if (paramKeyEvent.getAction() != 1) {
            break label356;
          }
          ac.d("MicroMsg.ChattingUI.FootComponent", "hasBack %B, %d", new Object[] { Boolean.valueOf(this.HUH), Long.valueOf(System.currentTimeMillis() - this.HUJ) });
          if ((this.HUH) && (System.currentTimeMillis() - this.HUJ <= 30000L)) {
            break;
          }
          i = 1;
        }
      }
      this.HUI = true;
      Object localObject = (com.tencent.mm.ui.chatting.c.b.j)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.j.class);
      com.tencent.mm.ui.chatting.c.b.ae localae = (com.tencent.mm.ui.chatting.c.b.ae)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.ae.class);
      if (((com.tencent.mm.ui.chatting.c.b.j)localObject).fmU()) {
        if (localae.fog())
        {
          localae.fof();
          ((com.tencent.mm.ui.chatting.c.b.j)localObject).fmV();
          label291:
          i = 1;
          label293:
          if (i == 0) {
            if (this.uEt != null)
            {
              localObject = this.uEt;
              if ((((ChatFooter)localObject).DuB == 0) && (!((ChatFooter)localObject).Dpb)) {
                break label387;
              }
              if (!((ChatFooter)localObject).Dpb) {
                break label376;
              }
              ((ChatFooter)localObject).eNf();
              label339:
              i = 1;
            }
          }
        }
      }
      for (;;)
      {
        if (i == 0) {
          this.cLy.HZF.fkI();
        }
        label356:
        i = 1;
        break;
        ((com.tencent.mm.ui.chatting.c.b.j)localObject).fmS();
        break label291;
        i = 0;
        break label293;
        label376:
        ((ChatFooter)localObject).g(0, true, -1);
        break label339;
        label387:
        i = j;
        if (((ChatFooter)localObject).DvQ != null)
        {
          i = j;
          if (((ChatFooter)localObject).DvQ.getVisibility() == 0)
          {
            ((ChatFooter)localObject).DvQ.efh();
            i = 1;
          }
        }
      }
      if ((paramKeyEvent.getKeyCode() == 67) && (!this.cLy.cqM)) {
        ac.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown back key fragment not foreground");
      } else if (!this.cLy.cqM) {
        ac.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown fragment not foreground");
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
        ac.w("MicroMsg.ChattingUI.FootComponent", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, bs.eWi() });
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
        ac.i("MicroMsg.ChattingUI.FootComponent", "summerper doFooterLiveRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.HUv, bs.eWi() });
        if (this.HUv != null) {
          this.HUv.uFd.dcb();
        }
        AppMethodBeat.o(35330);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131761860;; paramInt = 2131761871)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(paramInt), this.cLy.HZF.getMMResources().getString(2131761885), this.cLy.HZF.getMMResources().getString(2131760598), this.cLy.HZF.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35311);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = t.this.cLy.HZF;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/component/FootComponent$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
        ac.i("MicroMsg.ChattingUI.FootComponent", "summerper doFooterSightRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.HUv, bs.eWi() });
        if (this.HUv != null)
        {
          paramArrayOfString = this.HUv;
          if (!this.uEt.DtP.DsB.Dtq.value) {
            break label446;
          }
        }
        label446:
        for (paramInt = i;; paramInt = 2)
        {
          paramArrayOfString.aaG(paramInt);
          AppMethodBeat.o(35330);
          return;
        }
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131761860;; paramInt = 2131761871)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(paramInt), this.cLy.HZF.getMMResources().getString(2131761885), this.cLy.HZF.getMMResources().getString(2131760598), this.cLy.HZF.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35302);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = t.this.cLy.HZF;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/component/FootComponent$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
          ac.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuVideoSelected,footerEventImpl[%s], stack[%s]", new Object[] { this.HUv, bs.eWi() });
          if (this.HUv != null) {
            this.HUv.dqv();
          }
          AppMethodBeat.o(35330);
          return;
        }
        if (paramInt == 21)
        {
          ac.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.HUv, bs.eWi() });
          if (this.HUv != null) {
            this.HUv.fln();
          }
          AppMethodBeat.o(35330);
          return;
        }
        ac.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnEnterMultiTalk,footerEventImpl[%s], stack[%s]", new Object[] { this.HUv, bs.eWi() });
        if (this.HUv != null) {
          this.HUv.fll();
        }
        AppMethodBeat.o(35330);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131761860;; paramInt = 2131761871)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(paramInt), this.cLy.HZF.getMMResources().getString(2131761885), this.cLy.HZF.getMMResources().getString(2131760598), this.cLy.HZF.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(163307);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = t.this.cLy.HZF;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/component/FootComponent$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
        ac.i("MicroMsg.ChattingUI.FootComponent", "summerper doImageSelectTakePhotoRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.HUv, bs.eWi() });
        if (this.HUv != null) {
          this.HUv.flp();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131761860), this.cLy.HZF.getMMResources().getString(2131761885), this.cLy.HZF.getMMResources().getString(2131760598), this.cLy.HZF.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(169867);
          paramAnonymousDialogInterface = t.this.cLy.HZF;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/component/FootComponent$15", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$15", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(169867);
        }
      }, null);
      AppMethodBeat.o(35330);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ac.i("MicroMsg.ChattingUI.FootComponent", "summerper doTalkRoomRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.HUv, bs.eWi() });
        if (this.HUv != null) {
          this.HUv.flo();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131761869), this.cLy.HZF.getMMResources().getString(2131761885), this.cLy.HZF.getMMResources().getString(2131760598), this.cLy.HZF.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(184958);
          paramAnonymousDialogInterface = t.this.cLy.HZF;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/component/FootComponent$16", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
          ac.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuAudioSelected,footerEventImpl[%s], stack[%s]", new Object[] { this.HUv, bs.eWi() });
          if (this.HUv != null) {
            this.HUv.dqu();
          }
          AppMethodBeat.o(35330);
          return;
        }
        ac.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipAudioRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.HUv, bs.eWi() });
        if (this.HUv != null) {
          this.HUv.flm();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131761871), this.cLy.HZF.getMMResources().getString(2131761885), this.cLy.HZF.getMMResources().getString(2131760598), this.cLy.HZF.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(196472);
          paramAnonymousDialogInterface = t.this.cLy.HZF;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/component/FootComponent$17", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$17", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(196472);
        }
      }, null);
      AppMethodBeat.o(35330);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ac.i("MicroMsg.ChattingUI.FootComponent", "doSendFileRequest, footerEventImpl[%s], stack[%s].", new Object[] { this.HUv, bs.eWi() });
        if (this.HUv != null) {
          this.HUv.fli();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131761878), this.cLy.HZF.getMMResources().getString(2131761885), this.cLy.HZF.getMMResources().getString(2131760598), this.cLy.HZF.getMMResources().getString(2131759760), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(196473);
          paramAnonymousDialogInterface = t.this.cLy.HZF;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/component/FootComponent$18", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$18", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(196473);
        }
      }, null);
    }
  }
  
  public final void setVoiceInputShowCallback(ChatFooter.d paramd)
  {
    AppMethodBeat.i(35326);
    this.uEt.setVoiceInputShowCallback(paramd);
    AppMethodBeat.o(35326);
  }
  
  final class a
    implements TextWatcher
  {
    private boolean HUP = false;
    private List<String> HUQ = null;
    
    private a() {}
    
    private static boolean gc(String paramString, int paramInt)
    {
      AppMethodBeat.i(35312);
      if ((paramString == null) || (paramInt < 0) || (paramString.length() <= paramInt))
      {
        AppMethodBeat.o(35312);
        return false;
      }
      if (paramInt == 0)
      {
        AppMethodBeat.o(35312);
        return true;
      }
      AppMethodBeat.o(35312);
      return true;
    }
    
    public final void afterTextChanged(Editable paramEditable) {}
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(35313);
      ac.i("MicroMsg.ChattingUI.FootComponent", "[onTextChanged]");
      ((ag)t.this.cLy.bf(ag.class)).abb(1);
      Object localObject1 = (com.tencent.mm.ui.chatting.c.b.d)t.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class);
      paramCharSequence = String.valueOf(paramCharSequence);
      Object localObject2 = paramCharSequence.substring(paramInt1, paramInt1 + paramInt3);
      Object localObject3;
      Object localObject4;
      if ((t.this.cLy.foP()) && ("@".equals(localObject2)) && (!paramCharSequence.equals(t.this.uEt.getLastContent())) && (!t.this.uEt.Dun))
      {
        t.this.uEt.setLastContent(paramCharSequence);
        t.this.uEt.setInsertPos(paramInt1 + 1);
        if (gc(paramCharSequence, paramInt1))
        {
          localObject3 = bs.n(com.tencent.mm.model.q.vZ(t.this.cLy.getTalkerUserName()), ",");
          localObject4 = new Intent();
          ((Intent)localObject4).setClass(t.this.cLy.HZF.getContext(), AtSomeoneUI.class);
          ((Intent)localObject4).putExtra("Block_list", com.tencent.mm.model.u.axw());
          ((Intent)localObject4).putExtra("Chatroom_member_list", (String)localObject3);
          ((Intent)localObject4).putExtra("Chat_User", t.this.cLy.getTalkerUserName());
          ((Intent)localObject4).putExtra("Add_address_titile", t.this.cLy.HZF.getMMString(2131762574));
          t.this.cLy.HZF.startActivityForResult((Intent)localObject4, 212);
        }
        ((com.tencent.mm.ui.chatting.c.b.af)t.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.af.class)).E(paramCharSequence, paramInt1, (String)localObject2);
        if (!((com.tencent.mm.ui.chatting.c.b.d)localObject1).fmo())
        {
          localObject2 = t.this.uEt;
          if ((((ChatFooter)localObject2).Dug != null) && (((ChatFooter)localObject2).fTu != null))
          {
            ((ChatFooter)localObject2).Dug.DyT = true;
            localObject1 = ((ChatFooter)localObject2).Dug;
            localObject2 = ((ChatFooter)localObject2).DuX.getTalkerUserName();
            if (!bs.isNullOrNil(paramCharSequence)) {
              break label753;
            }
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).mHandler.removeMessages(20003);
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).mHandler.sendEmptyMessage(20001);
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).tzW = paramCharSequence;
            if (((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).DyX != null)
            {
              ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).DyX.dead();
              ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).DyX = null;
            }
          }
        }
      }
      for (;;)
      {
        if ((com.tencent.mm.model.w.sQ(t.this.cLy.getTalkerUserName())) && (!t.this.uEt.eOR())) {
          t.this.uEt.aHv(paramCharSequence);
        }
        AppMethodBeat.o(35313);
        return;
        if ((((com.tencent.mm.ui.chatting.c.b.d)localObject1).fmp()) && ("@".equals(localObject2)) && (!paramCharSequence.equals(t.this.uEt.getLastContent())) && (!t.this.uEt.Dun))
        {
          t.this.uEt.setLastContent(paramCharSequence);
          t.this.uEt.setInsertPos(paramInt1 + 1);
          if (!gc(paramCharSequence, paramInt1)) {
            break;
          }
          localObject3 = ((com.tencent.mm.ui.chatting.c.b.d)localObject1).fmm().field_userList;
          localObject4 = new Intent();
          ((Intent)localObject4).setClass(t.this.cLy.HZF.getContext(), BizChatAtSomeoneUI.class);
          ((Intent)localObject4).putExtra("Block_list", com.tencent.mm.al.af.aDa().dQ(t.this.cLy.getTalkerUserName()));
          ((Intent)localObject4).putExtra("Chatroom_member_list", (String)localObject3);
          ((Intent)localObject4).putExtra("Chat_User", t.this.cLy.getTalkerUserName());
          ((Intent)localObject4).putExtra("Add_address_titile", t.this.cLy.HZF.getMMString(2131762574));
          ((Intent)localObject4).putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.c.b.d)t.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmB());
          t.this.cLy.HZF.startActivityForResult((Intent)localObject4, 212);
          break;
        }
        if (paramCharSequence.equals(t.this.uEt.getLastContent())) {
          break;
        }
        t.this.uEt.setLastContent(paramCharSequence);
        break;
        label753:
        if (!paramCharSequence.equals(((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).tzW))
        {
          ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).hide();
          if (((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).DyX != null)
          {
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).DyX.dead();
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).DyX = null;
          }
          ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).DyX = new com.tencent.mm.vending.e.c();
          localObject3 = String.valueOf(bs.eWj());
          localObject4 = ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).DyY;
          ((fj)localObject4).dFe = ((fj)localObject4).t("SessionId", (String)localObject3, true);
          localObject4 = ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).DyY;
          ((fj)localObject4).dXA = ((fj)localObject4).t("ChatId", (String)localObject2, true);
          ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).DyV.clear();
          ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).DyZ = 0;
          localObject4 = new com.tencent.mm.emoji.a.b.b(((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).DyX);
          d.g.b.k.h(localObject3, "sessionId");
          com.tencent.mm.emoji.a.b.f localf = ((com.tencent.mm.emoji.a.b.b)localObject4).fSv;
          d.g.b.k.h(localObject3, "sessionId");
          localf.username = ((String)localObject2);
          localf.sessionId = ((String)localObject3);
          localObject2 = new m.5((com.tencent.mm.pluginsdk.ui.chat.m)localObject1, bs.eWj());
          d.g.b.k.h(paramCharSequence, "desc");
          localObject3 = com.tencent.mm.emoji.a.b.d.fSH;
          com.tencent.mm.emoji.a.b.d.lA(0);
          com.tencent.mm.ac.c.b("EmojiSuggest_searchSuggest", (d.g.a.a)new b.b((com.tencent.mm.emoji.a.b.b)localObject4, paramCharSequence, (j.b)localObject2));
        }
        ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).tzW = paramCharSequence;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.t
 * JD-Core Version:    0.7.0.1
 */