package com.tencent.mm.ui.chatting.d;

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
import com.tencent.mm.al.ag;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.c;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.emoji.a.c.b.b;
import com.tencent.mm.emoji.a.c.j.b;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.g.b.a.gk;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.ch;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.plugin.expt.b.b.a;
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
import com.tencent.mm.pluginsdk.ui.chat.a.b;
import com.tencent.mm.pluginsdk.ui.chat.a.c;
import com.tencent.mm.pluginsdk.ui.chat.m.5;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI;
import com.tencent.mm.ui.chatting.AtSomeoneUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.d.b.ak;
import com.tencent.mm.ui.chatting.d.b.ao;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.i;
import com.tencent.mm.ui.chatting.u;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.d.a.a(fJv=s.class)
public class v
  extends a
  implements k.a, n.b, s
{
  private static ArrayList<com.tencent.mm.pluginsdk.ui.chat.a.a> KdN = null;
  private static long KdO = 0L;
  private final ChatFooter.g FrM;
  private com.tencent.mm.ui.chatting.q KdP;
  protected ChatFooterCustom KdQ;
  private int KdR;
  private u KdS;
  private com.tencent.mm.ui.chatting.x KdT;
  private i KdU;
  private AnimationSet KdV;
  private String KdW;
  private int KdX;
  private int KdY;
  private boolean KdZ;
  public boolean Kea;
  private boolean Keb;
  public boolean Kec;
  private long Ked;
  private com.tencent.mm.sdk.b.c fNH;
  private com.tencent.mm.sdk.b.c fNI;
  protected ChatFooter vTx;
  
  public v()
  {
    AppMethodBeat.i(35314);
    this.KdR = 0;
    this.KdW = null;
    this.KdZ = false;
    this.Kea = false;
    this.fNH = new com.tencent.mm.sdk.b.c() {};
    this.fNI = new com.tencent.mm.sdk.b.c() {};
    this.FrM = new ChatFooter.g()
    {
      private Animation Kef;
      private Animation Keg;
      
      public final boolean wo(boolean paramAnonymousBoolean)
      {
        int i = 1;
        AppMethodBeat.i(35305);
        if (this.Kef == null)
        {
          this.Kef = AnimationUtils.loadAnimation(v.this.cXJ.Kkd.getContext(), 2130772108);
          this.Keg = AnimationUtils.loadAnimation(v.this.cXJ.Kkd.getContext(), 2130772106);
        }
        com.tencent.mm.ui.chatting.d.b.d locald;
        String str;
        if (paramAnonymousBoolean)
        {
          ae.i("MicroMsg.ChattingUI.FootComponent", "switchFooterToInput customFooter is %s", new Object[] { v.this.KdQ });
          if (v.this.KdQ != null) {
            v.this.KdQ.startAnimation(this.Keg);
          }
          v.this.fHL();
          v.this.vTx.startAnimation(this.Kef);
          v.this.vTx.postInvalidateDelayed(this.Kef.getDuration());
          locald = (com.tencent.mm.ui.chatting.d.b.d)v.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class);
          if (locald != null)
          {
            str = v.this.cXJ.getTalkerUserName();
            if (!paramAnonymousBoolean) {
              break label262;
            }
          }
        }
        for (;;)
        {
          locald.gH(str, i);
          AppMethodBeat.o(35305);
          return false;
          v.this.vTx.startAnimation(this.Keg);
          v.this.fHK();
          if (v.this.KdQ == null) {
            break;
          }
          v.this.KdQ.startAnimation(this.Kef);
          v.this.KdQ.postInvalidateDelayed(this.Kef.getDuration());
          break;
          label262:
          i = 2;
        }
      }
    };
    this.Keb = false;
    this.Kec = false;
    this.Ked = 0L;
    AppMethodBeat.o(35314);
  }
  
  private void a(final String paramString, final au.b.a parama)
  {
    AppMethodBeat.i(163315);
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184961);
        au.a.hIG.a(paramString, "", parama);
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
  
  private void a(String paramString, an paraman, ArrayList<com.tencent.mm.pluginsdk.ui.chat.a.a> paramArrayList)
  {
    AppMethodBeat.i(163316);
    long l1;
    if (paraman == null)
    {
      l1 = 0L;
      ae.i("MicroMsg.ChattingUI.FootComponent", "ChatroomBusinessType user %s %s", new Object[] { paramString, Long.valueOf(l1) });
      if ((!this.cXJ.fJB()) || (paraman == null) || (paraman.eRA == 0L)) {
        break label222;
      }
      if (KdN != null) {
        break label166;
      }
      KdN = new ArrayList();
      fHR();
      KdO = ch.aDa();
    }
    for (;;)
    {
      paramString = KdN;
      if ((paramString == null) || (paramString.size() <= 0)) {
        break label222;
      }
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        com.tencent.mm.pluginsdk.ui.chat.a.a locala = (com.tencent.mm.pluginsdk.ui.chat.a.a)paramString.next();
        if ((locala.Frn & paraman.eRA) != 0L)
        {
          locala.jFV = paraman.field_username;
          paramArrayList.add(locala);
        }
      }
      l1 = paraman.eRA;
      break;
      label166:
      l1 = ch.aDa();
      long l2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLZ, 1800);
      if (l1 - KdO > l2)
      {
        KdO = l1;
        KdN.clear();
        fHR();
      }
    }
    label222:
    this.vTx.setAppPanelUnCertainEnterArrayList(paramArrayList);
    AppMethodBeat.o(163316);
  }
  
  private void aXF(final String paramString)
  {
    AppMethodBeat.i(35325);
    ae.i("MicroMsg.ChattingUI.FootComponent", "initFooterPanelMenu %s", new Object[] { paramString });
    this.vTx.fhk();
    this.vTx.fhb();
    int i;
    Object localObject1;
    int j;
    label126:
    boolean bool1;
    if (((com.tencent.mm.ui.chatting.d.b.l)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.l.class)).fHv())
    {
      ae.w("MicroMsg.ChattingUI.FootComponent", "match shake, in show mode, do not open short video recode view");
      i = 0;
      if (i == 0) {
        this.vTx.fhm();
      }
      if (((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGJ())
      {
        localObject1 = com.tencent.mm.al.g.eX(this.cXJ.getTalkerUserName());
        if ((localObject1 != null) && (((com.tencent.mm.api.c)localObject1).field_enterpriseFather != null)) {
          break label2606;
        }
        j = 0;
        if (j != 0)
        {
          localObject1 = this.vTx.Frs;
          ((AppPanel)localObject1).FpZ.FqR.value = true;
          ((AppPanel)localObject1).fgM();
        }
      }
      if (!this.cXJ.fJC()) {
        this.vTx.fhu();
      }
      bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFP, true);
      localObject1 = this.vTx;
      if (!com.tencent.mm.sdk.platformtools.j.DEBUG) {
        break label2660;
      }
      i = 1;
      label206:
      ae.i("MicroMsg.ChattingUI.FootComponent", "isGroupChat:%b enableLive:%b", new Object[] { Boolean.valueOf(this.cXJ.fJC()), Boolean.valueOf(bool1) });
      if ((this.cXJ.fJC()) && (bool1) && (i != 0)) {
        break label2888;
      }
      this.vTx.Frs.fgL();
      label268:
      if (!com.tencent.mm.model.x.zU(this.cXJ.getTalkerUserName())) {
        this.vTx.Frs.fgL();
      }
      if ((this.cXJ.Cqh != null) && (!com.tencent.mm.contact.c.lO(this.cXJ.Cqh.field_type)) && (!com.tencent.mm.model.x.wb(this.cXJ.getTalkerUserName()))) {
        this.vTx.fhp();
      }
      if (an.Ac(paramString))
      {
        this.vTx.Frs.fgD();
        this.vTx.Frs.fgF();
        this.vTx.Frs.fgG();
        this.vTx.fhn();
        this.vTx.fho();
        this.vTx.Frs.fgE();
        this.vTx.aM(true, true);
        this.vTx.fhp();
        this.vTx.fhr();
        this.vTx.Frs.fgI();
        this.vTx.Frs.fgL();
      }
      if (an.aUp(paramString))
      {
        this.vTx.Frs.fgD();
        this.vTx.Frs.fgF();
        this.vTx.Frs.fgG();
        this.vTx.fhn();
        this.vTx.fho();
        this.vTx.Frs.fgE();
        this.vTx.aM(true, true);
        this.vTx.fhp();
        this.vTx.fhr();
        this.vTx.Frs.fgI();
        this.vTx.Frs.fgL();
      }
      if (an.aUn(paramString))
      {
        this.vTx.Frs.fgD();
        this.vTx.Frs.fgF();
        this.vTx.Frs.fgG();
        this.vTx.fhn();
        this.vTx.fhj();
        this.vTx.fho();
        this.vTx.Frs.fgE();
        this.vTx.aM(true, true);
        this.vTx.fhp();
        this.vTx.fhr();
        this.vTx.Frs.fgI();
        this.vTx.Frs.fgL();
      }
      if (an.aji(paramString))
      {
        this.vTx.fhb();
        this.vTx.fhj();
        this.vTx.Frs.fgG();
        this.vTx.fhu();
        this.vTx.fho();
        this.vTx.fhl();
        this.vTx.Frs.fgD();
        this.vTx.fhm();
        this.vTx.fho();
        this.vTx.fht();
        this.vTx.fft();
        this.vTx.Frs.fgH();
        this.vTx.aM(true, true);
        this.vTx.wa(true);
        this.vTx.wb(true);
        this.vTx.fhp();
        this.vTx.fhr();
        this.vTx.Frs.fgE();
        this.vTx.Frs.fgD();
        this.vTx.Frs.fgF();
        this.vTx.Frs.fgI();
      }
      if (com.tencent.mm.model.x.AD(paramString))
      {
        this.vTx.Frs.fgD();
        this.vTx.Frs.fgF();
        this.vTx.Frs.fgG();
        this.vTx.fho();
        this.vTx.Frs.fgE();
        this.vTx.aM(true, true);
        this.vTx.fhp();
        this.vTx.fhr();
        this.vTx.Frs.fgI();
        this.vTx.Frs.fgL();
      }
      if (com.tencent.mm.model.x.AA(paramString))
      {
        this.vTx.Frs.fgD();
        this.vTx.aM(true, true);
        this.vTx.Frs.fgE();
        this.vTx.Frs.fgI();
        this.vTx.Frs.fgL();
      }
      bc.aCg();
      localObject1 = com.tencent.mm.model.c.azF().BH(paramString);
      if ((localObject1 != null) && (((an)localObject1).fug()))
      {
        if (!((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGJ()) {
          break label2914;
        }
        this.vTx.Frs.fgD();
        this.vTx.Frs.fgG();
        this.vTx.Frs.fgE();
        this.vTx.aM(true, true);
        this.vTx.fhp();
        this.vTx.fhr();
        this.vTx.fhm();
        this.vTx.Frs.fgH();
        this.vTx.fhl();
        this.vTx.fht();
        this.vTx.fft();
        this.vTx.Frs.fgL();
      }
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.b.a.IvT.l(new qp());
        if (this.cXJ.fJB())
        {
          if (com.tencent.mm.n.g.acL().getInt("MultitalkBlockCaller", 0) == 0)
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            this.vTx.wa(false);
            if ((this.cXJ.fJC()) || (this.cXJ.fJA()))
            {
              this.vTx.aM(true, true);
              this.vTx.fhr();
            }
            com.tencent.mm.br.d.fjx();
            if (this.cXJ.fJA()) {
              this.vTx.Frs.fgE();
            }
            if (this.cXJ.getTalkerUserName().equals(com.tencent.mm.model.v.aAC()))
            {
              this.vTx.Frs.fgE();
              this.vTx.aM(true, true);
              this.vTx.fhp();
              this.vTx.fhr();
              this.vTx.Frs.fgL();
            }
            this.vTx.setAppPanelTip(null);
            if ((!an.aUq(this.cXJ.Cqh.field_username)) && (!com.tencent.mm.model.x.zV(this.cXJ.Cqh.field_username))) {
              continue;
            }
            com.tencent.mm.kernel.g.ajS();
            Object localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.cXJ.Cqh.field_username);
            ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).bB(((aw)localObject3).field_openImAppid, ((aw)localObject3).field_descWordingId);
            i = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).Jc(((aw)localObject3).field_openImAppid);
            Object localObject2 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).c(this.cXJ.Cqh.field_openImAppid, "openim_function_tip", com.tencent.mm.openim.a.a.a.iKm);
            ae.i("MicroMsg.ChattingUI.FootComponent", "openim showFlag:%d username: %s appid: %s tip %s", new Object[] { Integer.valueOf(i), this.cXJ.Cqh.field_username, ((aw)localObject3).field_openImAppid, localObject2 });
            if ((i & 0x1) == 0) {
              this.vTx.fhj();
            }
            if ((i & 0x2) == 0) {
              this.vTx.fhl();
            }
            if ((i & 0x4) == 0) {
              this.vTx.fhs();
            }
            if ((i & 0x8) == 0) {
              this.vTx.fhn();
            }
            if ((i & 0x10) == 0) {
              this.vTx.Frs.fgF();
            }
            if ((i & 0x20) == 0) {
              this.vTx.Frs.fgD();
            }
            if ((i & 0x40) == 0) {
              this.vTx.Frs.fgI();
            }
            if ((i & 0x80) == 0) {
              this.vTx.fho();
            }
            if (((i & 0x100) == 0) || ((i & 0x2000) == 0))
            {
              localObject3 = this.vTx;
              if ((i & 0x100) != 0) {
                continue;
              }
              bool1 = true;
              if ((i & 0x2000) != 0) {
                continue;
              }
              bool2 = true;
              ((ChatFooter)localObject3).aM(bool1, bool2);
            }
            if ((i & 0x200) == 0)
            {
              this.vTx.fhp();
              this.vTx.fhr();
            }
            if ((i & 0x400) == 0) {
              this.vTx.fhq();
            }
            if ((com.tencent.mm.model.x.zV(this.cXJ.Cqh.field_username)) && ((i & 0x100) == 0)) {
              this.vTx.wa(true);
            }
            this.vTx.setAppPanelTip((CharSequence)localObject2);
            localObject2 = this.vTx;
            com.tencent.mm.br.d.fjx();
            if (((ChatFooter)localObject2).qdo != null) {
              ((ChatFooter)localObject2).qdo.ffu();
            }
            localObject2 = this.vTx;
            com.tencent.mm.br.d.fjx();
            if (!com.tencent.mm.aw.b.aJB()) {
              continue;
            }
            bool1 = true;
            ((ChatFooter)localObject2).wb(bool1);
            this.vTx.Frs.fgE();
            if (an.zd(this.cXJ.getTalkerUserName()))
            {
              this.vTx.fhb();
              this.vTx.fhj();
              this.vTx.Frs.fgG();
              this.vTx.fhu();
              this.vTx.Frs.fgL();
              this.vTx.fho();
              this.vTx.fhl();
              this.vTx.fhn();
              this.vTx.Frs.fgD();
              this.vTx.fhm();
              this.vTx.fho();
              this.vTx.fhl();
              this.vTx.fht();
              this.vTx.fft();
              this.vTx.Frs.fgH();
              this.vTx.aM(true, true);
              this.vTx.wa(true);
              this.vTx.wb(true);
              this.vTx.fhp();
              this.vTx.fhr();
              this.vTx.Frs.fgE();
              this.vTx.Frs.fgD();
              this.vTx.Frs.fgF();
              this.vTx.Frs.fgI();
            }
            if (an.aUv(paramString))
            {
              this.vTx.fhb();
              if (((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.d.class)).ddt()) {
                continue;
              }
              localObject2 = this.vTx;
              ((ChatFooter)localObject2).Fsd = true;
              ((ChatFooter)localObject2).Frz.setVisibility(8);
              ((ChatFooter)localObject2).wn(false);
              this.vTx.fhj();
              this.vTx.Frs.fgG();
              this.vTx.fhu();
              this.vTx.fho();
              this.vTx.fhl();
              this.vTx.fht();
              this.vTx.fft();
              this.vTx.Frs.fgH();
              this.vTx.aM(true, true);
              this.vTx.wa(true);
              this.vTx.wb(true);
              this.vTx.fhp();
              this.vTx.fhr();
              this.vTx.Frs.fgE();
              this.vTx.Frs.fgD();
              this.vTx.Frs.fgF();
              this.vTx.Frs.fgI();
            }
            if ((!aa.Yr()) || (!com.tencent.mm.model.x.zU(this.cXJ.getTalkerUserName()))) {
              this.vTx.Frs.fgJ();
            }
            if (!((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.j.class)).anN(this.cXJ.getTalkerUserName())) {
              this.vTx.Frs.fgK();
            }
            localObject2 = new ArrayList();
            a(paramString, (an)localObject1, (ArrayList)localObject2);
            paramString = new au.b.a()
            {
              public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(163312);
                if ((paramAnonymousBoolean) && (bu.lX(v.this.cXJ.getTalkerUserName(), paramAnonymousString))) {
                  com.tencent.mm.kernel.g.ajU().aw(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(163310);
                      v.a(v.this, v.15.this.cXC, v.15.this.fVb, new ArrayList());
                      ar.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(163309);
                          v.this.vTx.fhM();
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
            if ((((ArrayList)localObject2).size() != 0) || (localObject1 == null) || (((aw)localObject1).eRA != 0L)) {
              continue;
            }
            if (!com.tencent.mm.model.x.wb(this.cXJ.getTalkerUserName())) {
              continue;
            }
            localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.cXJ.getTalkerUserName());
            if ((localObject1 != null) && ((((com.tencent.mm.storage.ac)localObject1).field_chatroomStatus & 0x8000) != 0L) && ((((com.tencent.mm.storage.ac)localObject1).field_chatroomfamilystatusmodifytime == 0L) || (((com.tencent.mm.storage.ac)localObject1).field_chatroomfamilystatusmodifytime - ch.aDb() >= 86400000L)))
            {
              ((com.tencent.mm.storage.ac)localObject1).field_chatroomfamilystatusmodifytime = ch.aDb();
              ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().update((com.tencent.mm.sdk.e.c)localObject1, new String[0]);
              a(this.cXJ.getTalkerUserName(), paramString);
            }
            AppMethodBeat.o(35325);
            return;
            bool1 = ((com.tencent.mm.ui.chatting.d.b.aj)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.aj.class)).fIQ();
            bool2 = ((com.tencent.mm.ui.chatting.d.b.aj)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.aj.class)).fIP();
            if ((bool1) || (bool2))
            {
              ae.w("MicroMsg.ChattingUI.FootComponent", "match shake, in search mode, do not open short video recode view");
              i = 0;
              break;
            }
            if ((an.aUp(this.cXJ.getTalkerUserName())) || (an.Ac(this.cXJ.getTalkerUserName())))
            {
              ae.w("MicroMsg.ChattingUI.FootComponent", "match shake, but is Qcontact or Bcontact");
              i = 0;
              break;
            }
            if (com.tencent.mm.model.x.AZ(this.cXJ.getTalkerUserName()))
            {
              i = 0;
              break;
            }
            i = 1;
            break;
            label2606:
            localObject1 = ag.aGp().Eg(((com.tencent.mm.api.c)localObject1).field_enterpriseFather);
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
            label2660:
            if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED))
            {
              i = bu.getInt(com.tencent.mm.n.g.acL().getValue("ChatRoomEnableLive"), 0);
              if (i == 0)
              {
                localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(((ChatFooter)localObject1).Frr);
                if (localObject1 == null) {
                  break label3278;
                }
                if ((((com.tencent.mm.storage.ac)localObject1).field_chatroomStatus & 0x80000) == 524288)
                {
                  j = 1;
                  i = j;
                  if (j != 0) {
                    break label206;
                  }
                  if (com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.JdE, 0) != 1) {
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
            if (((ChatFooter)localObject1).Frr == null) {
              continue;
            }
            i = bu.getInt(com.tencent.mm.n.g.acL().getValue("ChatRoomEnableLive"), 0);
            if (i == 0)
            {
              localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(((ChatFooter)localObject1).Frr);
              if (localObject1 == null) {
                continue;
              }
              if ((((com.tencent.mm.storage.ac)localObject1).field_chatroomStatus & 0x80000) == 524288)
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
            label2888:
            localObject1 = this.vTx.Frs;
            ((AppPanel)localObject1).FpZ.wi(true);
            ((AppPanel)localObject1).fgM();
            break label268;
            label2914:
            this.vTx.Frs.fgD();
            this.vTx.aM(true, true);
            this.vTx.fhn();
            this.vTx.Frs.fgE();
            this.vTx.Frs.fgL();
            continue;
          }
          i = 0;
          continue;
        }
        this.vTx.wa(true);
        continue;
        bool1 = false;
        continue;
        boolean bool2 = false;
        continue;
        if (!com.tencent.mm.model.x.zX(this.cXJ.Cqh.field_username)) {
          continue;
        }
        i = com.tencent.mm.model.v.aBw();
        if ((i & 0x1) == 0) {
          this.vTx.wa(true);
        }
        if ((i & 0x2) == 0) {
          this.vTx.fhp();
        }
        if ((i & 0x4) != 0) {
          continue;
        }
        this.vTx.fhq();
        continue;
        bool1 = false;
        continue;
        if (!((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.d.class)).ddu()) {
          this.vTx.fhs();
        }
        if (((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.d.class)).ddv()) {
          continue;
        }
        this.vTx.fhn();
        this.vTx.fhm();
        continue;
        if (com.tencent.mm.model.x.zV(this.cXJ.getTalkerUserName()))
        {
          localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.cXJ.getTalkerUserName());
          if ((localObject1 != null) && ((((com.tencent.mm.storage.ac)localObject1).ftL().type & 0x4) != 0L) && ((((com.tencent.mm.storage.ac)localObject1).field_chatroomfamilystatusmodifytime == 0L) || (((com.tencent.mm.storage.ac)localObject1).field_chatroomfamilystatusmodifytime - ch.aDb() >= 86400000L)))
          {
            ((com.tencent.mm.storage.ac)localObject1).field_chatroomfamilystatusmodifytime = ch.aDb();
            ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().update((com.tencent.mm.sdk.e.c)localObject1, new String[0]);
            a(this.cXJ.getTalkerUserName(), paramString);
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
      label3278:
      j = 0;
    }
  }
  
  private static void aXG(String paramString)
  {
    AppMethodBeat.i(163318);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(163318);
      return;
    }
    for (;;)
    {
      int i;
      com.tencent.mm.pluginsdk.ui.chat.a.a locala;
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
        locala = new com.tencent.mm.pluginsdk.ui.chat.a.a();
        locala.FqZ = paramString.optString("enter_id");
        locala.Fra = paramString.optInt("red_dot");
        locala.uIW = paramString.optInt("jump_type");
        locala.Frb = paramString.optString("wa_un");
        locala.Frd = paramString.optInt("wa_ver");
        locala.Fre = paramString.optString("wa_path");
        locala.Frf = paramString.optString("wa_dgmode");
        locala.mdj = paramString.optString("h5_url");
        locala.iconUrl = paramString.optString("icon_url");
        locala.Frk = paramString.optString("icon_url_dark");
        if (bu.isNullOrNil(locala.iconUrl))
        {
          ae.e("MicroMsg.ChattingUI.FootComponent", "unCertainEnter.iconUrl is null");
        }
        else
        {
          locala.Frn = paramString.optLong("busi_type");
          localObject = paramString.optJSONObject("title");
          localJSONObject = paramString.optJSONObject("desc");
          if (localObject == null) {
            ae.e("MicroMsg.ChattingUI.FootComponent", "titleJson is null");
          }
        }
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.ChattingUI.FootComponent", "handleAppPanelUnCertainEnterConfig() Exception:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(163318);
        return;
      }
      locala.Frg.title = ((JSONObject)localObject).optString("zh_cn");
      if (bu.isNullOrNil(locala.Frg.title))
      {
        ae.e("MicroMsg.ChattingUI.FootComponent", "unCertainEnter.simpleChWord.title is null");
      }
      else
      {
        a.b localb = locala.Fri;
        if (bu.isNullOrNil(((JSONObject)localObject).optString("zh_tw")))
        {
          paramString = locala.Frg.title;
          localb.title = paramString;
          localb = locala.Frh;
          if (!bu.isNullOrNil(((JSONObject)localObject).optString("zh_hk"))) {
            break label586;
          }
          paramString = locala.Frg.title;
          label391:
          localb.title = paramString;
          localb = locala.Frj;
          if (!bu.isNullOrNil(((JSONObject)localObject).optString("en"))) {
            break label598;
          }
          paramString = locala.Frg.title;
          label427:
          localb.title = paramString;
          if (localJSONObject != null)
          {
            locala.Frg.desc = localJSONObject.optString("zh_cn");
            localObject = locala.Fri;
            if (!bu.isNullOrNil(localJSONObject.optString("zh_tw"))) {
              break label610;
            }
            paramString = locala.Frg.desc;
            label484:
            ((a.b)localObject).desc = paramString;
            localObject = locala.Frh;
            if (!bu.isNullOrNil(localJSONObject.optString("zh_hk"))) {
              break label622;
            }
            paramString = locala.Frg.desc;
            label520:
            ((a.b)localObject).desc = paramString;
            localObject = locala.Frj;
            if (!bu.isNullOrNil(localJSONObject.optString("en"))) {
              break label634;
            }
          }
        }
        label586:
        label598:
        label610:
        label622:
        label634:
        for (paramString = locala.Frg.desc;; paramString = localJSONObject.optString("en"))
        {
          ((a.b)localObject).desc = paramString;
          KdN.add(locala);
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
  
  private void fHH()
  {
    AppMethodBeat.i(35315);
    if (this.cXJ.Kkd.isCurrentActivity)
    {
      AppMethodBeat.o(35315);
      return;
    }
    this.cXJ.Kkf.fFU();
    if (this.vTx != null)
    {
      ChatFooter localChatFooter = this.vTx;
      Object localObject = localChatFooter.findViewById(2131298150);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localChatFooter.setSwitchButtonMode(0);
      localChatFooter.mHandler.removeMessages(1002);
      if (localChatFooter.Frz != null) {
        localChatFooter.Frz.setVisibility(8);
      }
      if (localChatFooter.FrA != null) {
        localChatFooter.FrA.setVisibility(8);
      }
      if (localChatFooter.FrB != null) {
        localChatFooter.FrB.setVisibility(8);
      }
      if (localChatFooter.FrE != null) {
        localChatFooter.FrE.setVisibility(8);
      }
      if (localChatFooter.FrC != null) {
        localChatFooter.FrC.setVisibility(8);
      }
      if (localChatFooter.FrF != null) {
        localChatFooter.FrF.setVisibility(8);
      }
      localChatFooter.gpu.setVisibility(8);
      if (localChatFooter.rFv != null) {
        localChatFooter.rFv.setVisibility(8);
      }
      if (localChatFooter.FsI != null) {
        localChatFooter.FsI.setVisibility(8);
      }
      if (localChatFooter.rFw != null) {
        localChatFooter.rFw.setVisibility(8);
      }
      if (localChatFooter.rFt != null) {
        localChatFooter.rFt.setVisibility(8);
      }
      if (localChatFooter.Fmx != null)
      {
        localChatFooter.Fmx.setVisibility(8);
        localChatFooter.FmA = false;
        localChatFooter.Fmx.destroy();
      }
      if (localChatFooter.FrU != null) {
        localChatFooter.FrU.setVisibility(8);
      }
      if (localChatFooter.BGe != null) {
        localChatFooter.BGe.setVisibility(8);
      }
      if (localChatFooter.BGb != null) {
        localChatFooter.BGb.update();
      }
      if (localChatFooter.Frt != null) {
        localChatFooter.Frt.setVisibility(8);
      }
      if (localChatFooter.Frx != null)
      {
        localChatFooter.Frx.setVisibility(4);
        if (localChatFooter.qdo != null) {
          localChatFooter.qdo.setVisibility(4);
        }
      }
      localChatFooter.Frs = ((AppPanel)localChatFooter.findViewById(2131297977));
      if (localChatFooter.Frs != null)
      {
        localChatFooter.setAppPanelVisible(8);
        localObject = localChatFooter.Frs;
        if (((AppPanel)localObject).yKQ != null) {
          ((AppPanel)localObject).yKQ.setToScreen(0);
        }
        ((AppPanel)localObject).FpX = 0;
      }
      localChatFooter.a(ChatFooter.h.FvA);
      localChatFooter.g(0, false, -1);
      localChatFooter.FrS = false;
      localChatFooter = this.vTx;
      if (!bu.ah(localChatFooter.vNt.getText())) {
        localChatFooter.vNt.setText("");
      }
      localChatFooter.wj(false);
      localChatFooter.fgZ();
      this.vTx.fha();
      this.vTx.FrP.Fvq = null;
    }
    AppMethodBeat.o(35315);
  }
  
  private void fHM()
  {
    AppMethodBeat.i(35319);
    ae.i("MicroMsg.ChattingUI.FootComponent", "[goneFooter] %s", new Object[] { bu.fpN() });
    if (this.vTx != null)
    {
      this.vTx.g(0, false, -1);
      this.vTx.setVisibility(8);
    }
    if (this.KdQ != null) {
      this.KdQ.setVisibility(8);
    }
    this.vTx.wj(false);
    this.cXJ.hideVKB();
    AppMethodBeat.o(35319);
  }
  
  private void fHQ()
  {
    AppMethodBeat.i(184963);
    if (this.vTx == null)
    {
      ae.e("MicroMsg.ChattingUI.FootComponent", "initTodoView footer == null");
      AppMethodBeat.o(184963);
      return;
    }
    ae.i("MicroMsg.ChattingUI.FootComponent", "initTodoView()");
    ((com.tencent.mm.ui.chatting.d.b.w)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.w.class)).a(this.vTx.getIOnToDoBarCallback());
    this.vTx.setIOnTodoViewCallback(new z.c()
    {
      public final int dew()
      {
        AppMethodBeat.i(185866);
        int i = ((com.tencent.mm.ui.chatting.d.b.w)v.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.w.class)).dew();
        AppMethodBeat.o(185866);
        return i;
      }
      
      public final void ya(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(185864);
        ((com.tencent.mm.ui.chatting.d.b.w)v.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.w.class)).ya(paramAnonymousBoolean);
        AppMethodBeat.o(185864);
      }
      
      public final void yb(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(185865);
        ((com.tencent.mm.ui.chatting.d.b.w)v.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.w.class)).yb(paramAnonymousBoolean);
        AppMethodBeat.o(185865);
      }
    });
    AppMethodBeat.o(184963);
  }
  
  private static void fHR()
  {
    AppMethodBeat.i(163317);
    aXG(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLP, ""));
    aXG(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLQ, ""));
    aXG(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLR, ""));
    aXG(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLS, ""));
    aXG(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLT, ""));
    aXG(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLU, ""));
    aXG(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLV, ""));
    aXG(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLW, ""));
    aXG(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLX, ""));
    aXG(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLY, ""));
    AppMethodBeat.o(163317);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(35327);
    if (paramObject != null) {
      paramObject.equals("");
    }
    ae.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", new Object[] { paramObject, this.cXJ.getTalkerUserName() });
    if (paramObject.equals(this.cXJ.getTalkerUserName()))
    {
      aXF(this.cXJ.getTalkerUserName());
      fHP();
    }
    AppMethodBeat.o(35327);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(35328);
    if (paramString != null) {
      paramString.equals("");
    }
    ae.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", new Object[] { paramString, this.cXJ.getTalkerUserName() });
    if (com.tencent.mm.model.x.zV(this.cXJ.getTalkerUserName()))
    {
      aXF(this.cXJ.getTalkerUserName());
      fHP();
    }
    AppMethodBeat.o(35328);
  }
  
  public final boolean aG(bv parambv)
  {
    AppMethodBeat.i(35323);
    if (this.vTx != null) {
      this.vTx.aG(parambv);
    }
    AppMethodBeat.o(35323);
    return true;
  }
  
  public final boolean as(an paraman)
  {
    AppMethodBeat.i(35322);
    boolean bool1 = ((com.tencent.mm.ui.chatting.d.b.aj)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.aj.class)).fIQ();
    boolean bool2 = ((com.tencent.mm.ui.chatting.d.b.aj)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.aj.class)).fIP();
    boolean bool3 = ((com.tencent.mm.ui.chatting.d.b.l)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.l.class)).fHv();
    boolean bool4 = ((com.tencent.mm.ui.chatting.d.b.q)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.q.class)).fHE();
    boolean bool5 = ((com.tencent.mm.ui.chatting.d.b.af)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.af.class)).fID();
    if (this.Kea)
    {
      AppMethodBeat.o(35322);
      return true;
    }
    if ((bool1) || (bool2) || (bool3) || (bool4) || (bool5))
    {
      ae.i("MicroMsg.ChattingUI.FootComponent", bool1 + ", " + bool2 + ", " + bool3 + ", " + bool4 + ", " + bool5);
      fHM();
      AppMethodBeat.o(35322);
      return false;
    }
    if ((paraman != null) && (com.tencent.mm.model.x.Ak(paraman.field_username)))
    {
      this.KdU = new i(this.KdQ);
      this.KdU.fCL();
      fHK();
      AppMethodBeat.o(35322);
      return true;
    }
    com.tencent.mm.ui.chatting.d.b.d locald;
    Object localObject1;
    int i;
    if ((paraman != null) && (paraman.fug()))
    {
      locald = (com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class);
      if (locald.fGG() != null)
      {
        localObject1 = locald.fGG().bX(false);
        if (localObject1 != null)
        {
          if (((c.b)localObject1).cRf != null) {
            ((c.b)localObject1).cRh = "1".equals(((c.b)localObject1).cRf.optString("IsHideInputToolbarInMsg"));
          }
          if (((c.b)localObject1).cRh)
          {
            ae.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + paraman.field_username + " is hide tool bar");
            fHM();
            AppMethodBeat.o(35322);
            return false;
          }
        }
        if ((!bu.isNullOrNil(paraman.field_username)) && (localObject1 != null))
        {
          i = this.cXJ.Kkd.getIntExtra("key_temp_session_show_type", 0);
          switch (((c.b)localObject1).KN())
          {
          default: 
            fHL();
            paraman = paraman.field_username;
            if (localObject1 == null) {
              break;
            }
          }
        }
      }
    }
    for (bool1 = true;; bool1 = false)
    {
      ae.e("MicroMsg.ChattingUI.FootComponent", "bizinfo name=%s, %b, %d", new Object[] { paraman, Boolean.valueOf(bool1), Integer.valueOf(((c.b)localObject1).KN()) });
      for (;;)
      {
        AppMethodBeat.o(35322);
        return true;
        ae.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + paraman.field_username + " is show custom menu");
        if (this.KdQ == null)
        {
          l.a(this.cXJ.Kkd, 2131302671);
          this.KdQ = ((ChatFooterCustom)this.cXJ.findViewById(2131302673));
          if (this.KdQ != null) {
            this.KdQ.C((ViewGroup)this.cXJ.findViewById(2131298070));
          }
        }
        localObject1 = ((c.b)localObject1).KU();
        try
        {
          Iterator localIterator = ((c.b.c)localObject1).cRQ.iterator();
          while (localIterator.hasNext())
          {
            Object localObject2 = (com.tencent.mm.al.k)localIterator.next();
            if (!bu.isNullOrNil(((com.tencent.mm.al.k)localObject2).dPb)) {
              ((com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).a(((com.tencent.mm.al.k)localObject2).dPb, -1, "", bu.bI(((com.tencent.mm.al.k)localObject2).name, ""), "", "", 4);
            }
            if (!bu.isNullOrNil(((com.tencent.mm.al.k)localObject2).value)) {
              ((com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).a(((com.tencent.mm.al.k)localObject2).value, -1, "", bu.bI(((com.tencent.mm.al.k)localObject2).name, ""), "", "", 4);
            }
            localObject2 = ((com.tencent.mm.al.k)localObject2).hTd.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              com.tencent.mm.al.k localk = (com.tencent.mm.al.k)((Iterator)localObject2).next();
              if (!bu.isNullOrNil(localk.dPb)) {
                ((com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).a(localk.dPb, -1, "", bu.bI(localk.name, ""), "", "", 4);
              }
              if (!bu.isNullOrNil(localk.value)) {
                ((com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).a(localk.value, -1, "", bu.bI(localk.name, ""), "", "", 4);
              }
            }
          }
        }
        catch (Exception localException)
        {
          ae.printErrStackTrace("MicroMsg.ChattingUI.FootComponent", localException, "preauth when chat foot", new Object[0]);
          if ((localObject1 != null) && (((c.b.c)localObject1).type == 1))
          {
            this.vTx.setSwitchButtonMode(1);
            this.vTx.setOnFooterSwitchListener(((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGN());
            fHL();
          }
          else
          {
            this.vTx.setSwitchButtonMode(0);
            try
            {
              if (!com.tencent.mm.model.x.Af(paraman.field_username)) {
                break label1060;
              }
              this.KdT = new com.tencent.mm.ui.chatting.x(this.KdQ);
              this.KdT.fCL();
              fHK();
            }
            catch (Exception paraman)
            {
              if (localObject1 == null) {
                break label1040;
              }
            }
            if ((((c.b.c)localObject1).cRQ == null) || (((c.b.c)localObject1).cRQ.size() == 0)) {
              label1040:
              fHL();
            }
          }
        }
      }
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.ChattingUI.FootComponent", paraman, "", new Object[0]);
        break;
        label1060:
        ChatFooterCustom localChatFooterCustom = this.KdQ;
        if ((localChatFooterCustom.JTI != null) && (localChatFooterCustom.JTH != null))
        {
          localChatFooterCustom.JTI.setVisibility(0);
          localChatFooterCustom.JTH.setVisibility(0);
        }
        if (localChatFooterCustom.JTJ != null) {
          localChatFooterCustom.JTJ.fFi();
        }
        this.KdQ.setTalker(this.cXJ.Cqh);
        this.KdQ.a(this.cXJ.Kkd, locald.fGG(), paraman.field_username);
        this.KdQ.setOnFooterSwitchListener(this.FrM);
        this.KdQ.setOnProcessClickListener(((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGM());
        this.vTx.setOnFooterSwitchListener(this.FrM);
        if ((((com.tencent.mm.ui.chatting.d.b.ac)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.ac.class)).fIC()) && (i == 1))
        {
          fHL();
          break;
        }
        fHK();
        break;
        this.FrM.wo(true);
      }
    }
  }
  
  public final void fAs()
  {
    AppMethodBeat.i(187333);
    this.Kea = this.cXJ.Kkd.getBooleanExtra("show_footer", false).booleanValue();
    AppMethodBeat.o(187333);
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(35333);
    this.Keb = false;
    this.Kec = false;
    this.Ked = 0L;
    bc.aCg();
    Object localObject1 = com.tencent.mm.model.c.azL().aVa(this.cXJ.getTalkerUserName());
    if (localObject1 != null) {
      this.KdR = ((ba)localObject1).field_chatmode;
    }
    ae.d("MicroMsg.ChattingUI.FootComponent", "dkcm init old:%d   ", new Object[] { Integer.valueOf(this.KdR) });
    localObject1 = this.cXJ.getTalkerUserName();
    if (this.vTx == null)
    {
      this.vTx = ((ChatFooter)this.cXJ.findViewById(2131302672));
      this.vTx.a(new ChatFooter.b()
      {
        public final com.tencent.mm.ui.chatting.i.b fie()
        {
          return v.this.cXJ.Kka;
        }
        
        public final com.tencent.mm.ui.chatting.e.a fif()
        {
          return v.this.cXJ;
        }
        
        public final String getTalkerUserName()
        {
          AppMethodBeat.i(35307);
          String str = v.this.cXJ.getTalkerUserName();
          AppMethodBeat.o(35307);
          return str;
        }
      });
      ((com.tencent.mm.ui.chatting.d.b.r)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.r.class)).bC(this.vTx);
      fHQ();
    }
    this.vTx.setCattingRootLayoutId(2131298066);
    ae.i("MicroMsg.ChattingUI.FootComponent", "resetFooter customFooter is %s", new Object[] { this.KdQ });
    if (this.KdQ != null)
    {
      this.KdQ.fFc();
      this.KdQ.setOnFooterSwitchListener(null);
      this.KdQ.setOnProcessClickListener(null);
      this.vTx.setOnFooterSwitchListener(null);
      this.KdQ.fFf();
    }
    fHM();
    this.vTx.fhk();
    boolean bool1 = ((com.tencent.mm.ui.chatting.d.b.aj)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.aj.class)).fIQ();
    boolean bool2 = ((com.tencent.mm.ui.chatting.d.b.aj)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.aj.class)).fIP();
    boolean bool3 = ((com.tencent.mm.ui.chatting.d.b.af)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.af.class)).fID();
    int i;
    if ((!this.Kea) && ((bool1) || (bool2) || (bool3)))
    {
      fHM();
      fHH();
      this.KdP = new com.tencent.mm.ui.chatting.q(this.cXJ, this.vTx, this.cXJ.getTalkerUserName());
      this.KdP.JVL = this.cXJ.Kkd.getBooleanExtra("key_need_send_video", true).booleanValue();
      this.vTx.setFooterEventListener(this.KdP);
      localObject1 = new com.tencent.mm.ui.chatting.w(this.cXJ, this.cXJ.Cqh, this.cXJ.getTalkerUserName());
      this.vTx.setSmileyPanelCallback((com.tencent.mm.pluginsdk.ui.chat.f)localObject1);
      this.vTx.setSmileyPanelCallback2((com.tencent.mm.pluginsdk.ui.chat.j)localObject1);
      fHP();
      this.vTx.fhc();
      i = this.cXJ.Kkd.getIntExtra("key_temp_session_show_type", 0);
      localObject1 = (com.tencent.mm.ui.chatting.d.b.ac)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.ac.class);
      ae.i("MicroMsg.ChattingUI.FootComponent", "isTempSession : %s, showType : %d.", new Object[] { Boolean.valueOf(((com.tencent.mm.ui.chatting.d.b.ac)localObject1).fIC()), Integer.valueOf(i) });
      ae.d("MicroMsg.ChattingUI.FootComponent", "is temp session : %s.", new Object[] { Boolean.valueOf(((com.tencent.mm.ui.chatting.d.b.ac)localObject1).fIC()) });
      if (((com.tencent.mm.ui.chatting.d.b.ac)localObject1).fIC())
      {
        if (i != 1) {
          break label1622;
        }
        this.FrM.wo(true);
      }
    }
    for (;;)
    {
      as(this.cXJ.Cqh);
      com.tencent.mm.kernel.g.ajS();
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().a(this);
      ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().add(this);
      AppMethodBeat.o(35333);
      return;
      if (com.tencent.mm.model.x.Ar((String)localObject1))
      {
        fHM();
        l.a(this.cXJ.Kkd, 2131302671);
        if (this.KdQ == null)
        {
          i = 1;
          this.KdQ = ((ChatFooterCustom)this.cXJ.findViewById(2131302673));
          if (i != 0) {
            this.KdQ.C((ViewGroup)this.cXJ.findViewById(2131298070));
          }
          this.KdS = new u(this.KdQ);
          localObject1 = this.KdS;
          if (com.tencent.mm.sdk.platformtools.k.cSM != 1) {
            break label903;
          }
          i = 1;
          label720:
          ((u)localObject1).JWJ.findViewById(2131298098).setVisibility(8);
          ((u)localObject1).pVM = ((LinearLayout)((u)localObject1).JWJ.findViewById(2131298093));
          ((u)localObject1).JWJ.findViewById(2131298092).setVisibility(8);
          localObject2 = ((u)localObject1).pVM;
          if (i == 0) {
            break label908;
          }
        }
        label903:
        label908:
        for (float f = 1.0F;; f = 2.0F)
        {
          ((LinearLayout)localObject2).setWeightSum(f);
          ((u)localObject1).JWK = ((FrameLayout)((u)localObject1).pVM.getChildAt(0));
          ((u)localObject1).JWK.setVisibility(0);
          ((u)localObject1).JWK.setOnClickListener(((u)localObject1).JWS);
          ((TextView)((u)localObject1).JWK.findViewById(2131298095)).setText(2131757079);
          ((u)localObject1).JWK.findViewById(2131298094).setVisibility(8);
          if (i == 0) {
            break label913;
          }
          i = 1;
          while (i < 6)
          {
            ((u)localObject1).pVM.getChildAt(i).setVisibility(8);
            i += 1;
          }
          i = 0;
          break;
          i = 0;
          break label720;
        }
        label913:
        ((u)localObject1).JWL = ((FrameLayout)((u)localObject1).pVM.getChildAt(1));
        ((u)localObject1).JWL.setVisibility(0);
        ((u)localObject1).JWL.setOnClickListener(((u)localObject1).JWT);
        ((u)localObject1).JWM = ((TextView)((u)localObject1).JWL.findViewById(2131298095));
        ((u)localObject1).JWN = ((ImageView)((u)localObject1).JWL.findViewById(2131298094));
        ((u)localObject1).JWN.setVisibility(0);
        ((u)localObject1).fFM();
        bc.aCg();
        ((u)localObject1).uFA = ((Integer)com.tencent.mm.model.c.ajA().get(am.a.ILE, Integer.valueOf(-1))).intValue();
        if (((u)localObject1).uFA >= 0) {
          ((u)localObject1).fFO();
        }
        for (;;)
        {
          i = 2;
          while (i < 6)
          {
            ((u)localObject1).pVM.getChildAt(i).setVisibility(8);
            i += 1;
          }
          ((u)localObject1).JWM.setText(2131757092);
        }
        ((u)localObject1).JWR = com.tencent.mm.n.g.acM().getMailAppEnterUlAndroid();
        if (bu.isNullOrNil(((u)localObject1).JWR)) {
          ((u)localObject1).JWR = "qqmail://folderlist?app=weixin&action=list&uin=$uin$";
        }
        bc.aCg();
        localObject2 = new com.tencent.mm.b.p(bu.o((Integer)com.tencent.mm.model.c.ajA().get(9, null))).toString();
        ((u)localObject1).JWR = ((u)localObject1).JWR.replace("$uin$", (CharSequence)localObject2);
        ((u)localObject1).xxj = com.tencent.mm.n.g.acM().acE();
        ((u)localObject1).JWP = true;
        fHK();
        break;
      }
      this.KdS = null;
      if (com.tencent.mm.model.x.Af((String)localObject1))
      {
        fHM();
        l.a(this.cXJ.Kkd, 2131302671);
        if (this.KdQ == null) {}
        for (i = 1;; i = 0)
        {
          this.KdQ = ((ChatFooterCustom)this.cXJ.findViewById(2131302673));
          if (i != 0) {
            this.KdQ.C((ViewGroup)this.cXJ.findViewById(2131298070));
          }
          this.KdT = new com.tencent.mm.ui.chatting.x(this.KdQ);
          this.KdT.fCL();
          fHK();
          break;
        }
      }
      this.KdT = null;
      if (com.tencent.mm.model.x.Ak((String)localObject1))
      {
        fHM();
        l.a(this.cXJ.Kkd, 2131302671);
        if (this.KdQ == null) {}
        for (i = 1;; i = 0)
        {
          this.KdQ = ((ChatFooterCustom)this.cXJ.findViewById(2131302673));
          if (i != 0) {
            this.KdQ.C((ViewGroup)this.cXJ.findViewById(2131298070));
          }
          this.KdU = new i(this.KdQ);
          this.KdU.fCL();
          fHK();
          break;
        }
      }
      this.KdU = null;
      if ((!com.tencent.mm.model.x.As((String)localObject1)) && (!com.tencent.mm.model.x.Af((String)localObject1)) && (!com.tencent.mm.model.x.Ar((String)localObject1)) && (!com.tencent.mm.model.x.Ak((String)localObject1)))
      {
        com.tencent.mm.model.x.aBz();
        if ((!com.tencent.mm.model.x.AS((String)localObject1)) && (!com.tencent.mm.model.x.Ai((String)localObject1)) && (!com.tencent.mm.model.x.AX((String)localObject1))) {}
      }
      else
      {
        fHM();
        break;
      }
      fHL();
      as(this.cXJ.Cqh);
      this.vTx.setUserName((String)localObject1);
      this.vTx.lE(this.cXJ.fJy(), this.cXJ.getTalkerUserName());
      aXF((String)localObject1);
      localObject1 = (com.tencent.mm.ui.chatting.d.b.l)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.l.class);
      Object localObject2 = (com.tencent.mm.ui.chatting.d.b.aj)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.aj.class);
      if (!((com.tencent.mm.ui.chatting.d.b.l)localObject1).fHv()) {
        break;
      }
      if (((com.tencent.mm.ui.chatting.d.b.aj)localObject2).fIN())
      {
        ((com.tencent.mm.ui.chatting.d.b.aj)localObject2).fIM();
        ((com.tencent.mm.ui.chatting.d.b.l)localObject1).fHw();
        break;
      }
      ((com.tencent.mm.ui.chatting.d.b.l)localObject1).fHt();
      break;
      label1622:
      this.FrM.wo(false);
    }
  }
  
  public final void fAu() {}
  
  public final void fAv()
  {
    AppMethodBeat.i(35334);
    this.KdW = this.cXJ.Kkd.getStringExtra("smiley_product_id");
    if (this.vTx.uNO) {
      ((com.tencent.mm.ui.chatting.d.b.al)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.al.class)).keepSignalling();
    }
    if ((com.tencent.mm.model.x.Ar(this.cXJ.getTalkerUserName())) && (this.KdS != null) && (this.KdS.JWP)) {
      this.KdS.fFN();
    }
    ChatFooter localChatFooter = this.vTx;
    BaseChattingUIFragment localBaseChattingUIFragment = this.cXJ.Kkd;
    localChatFooter.FsD = localBaseChattingUIFragment;
    localChatFooter.a(localBaseChattingUIFragment.getContext(), localBaseChattingUIFragment.thisActivity());
    if ((localChatFooter.Fte != null) && (localChatFooter.Fte.isShowing())) {
      localChatFooter.Fte.dismiss();
    }
    if ((!bu.isNullOrNil(this.KdW)) && (this.vTx != null))
    {
      ae.d("MicroMsg.ChattingUI.FootComponent", "deal use smiley panel in product: %s", new Object[] { this.KdW });
      this.vTx.setDefaultSmileyByDetail(this.KdW);
      this.vTx.fhf();
    }
    this.cXJ.Kkd.getContext().getIntent().putExtra("smiley_product_id", "");
    this.vTx.setUserName(this.cXJ.getTalkerUserName());
    com.tencent.mm.live.d.e.haU = this.cXJ.getTalkerUserName();
    this.vTx.lE(this.cXJ.fJy(), this.cXJ.getTalkerUserName());
    if (this.cXJ.Kkd.getBooleanExtra("key_show_bottom_app_panel", false).booleanValue())
    {
      localChatFooter = this.vTx;
      if (localChatFooter.Frz != null)
      {
        localChatFooter.Frz.performClick();
        ae.d("MicroMsg.ChatFooter", "perform click attach bt to show bottom panel");
      }
    }
    if (as(this.cXJ.Cqh))
    {
      if (this.vTx != null)
      {
        bc.aCg();
        bool1 = ((Boolean)com.tencent.mm.model.c.ajA().get(66832, Boolean.FALSE)).booleanValue();
        ae.d("MicroMsg.ChattingUI.FootComponent", "jacks refresh Footer Plugin Setting , Enable Enter Button: %B", new Object[] { Boolean.valueOf(bool1) });
        this.vTx.fhI();
        if (bool1)
        {
          this.vTx.fhv();
          this.vTx.fhc();
        }
        if (bool1) {
          this.vTx.fhl();
        }
        localChatFooter = this.vTx;
        if (localChatFooter.Frs != null) {
          localChatFooter.Frs.fgC();
        }
      }
      ((ao)this.cXJ.bh(ao.class)).fHA();
      if (this.vTx != null)
      {
        this.vTx.Frs.refresh();
        this.vTx.addTextChangedListener(new a((byte)0));
        ae.i("MicroMsg.ChattingUI.FootComponent", "addTextChangedListener");
      }
    }
    boolean bool1 = ((com.tencent.mm.ui.chatting.d.b.aj)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.aj.class)).fIQ();
    boolean bool2 = ((com.tencent.mm.ui.chatting.d.b.aj)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.aj.class)).fIP();
    boolean bool3 = ((com.tencent.mm.ui.chatting.d.b.l)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.l.class)).fHv();
    boolean bool4 = com.tencent.mm.model.x.Ai(this.cXJ.getTalkerUserName());
    boolean bool5 = ((com.tencent.mm.ui.chatting.d.b.af)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.af.class)).fID();
    if (((!bool1) && (!bool2) && (!bool3)) || ((this.Kea) && (this.cXJ.Cqh != null) && (!this.cXJ.Cqh.fug()) && (!com.tencent.mm.model.x.AU(this.cXJ.getTalkerUserName())) && (!com.tencent.mm.ui.widget.snackbar.b.bnS()) && (!com.tencent.mm.model.x.Ak(this.cXJ.getTalkerUserName())) && (!bool4) && (!bool5)))
    {
      ae.i("MicroMsg.ChattingUI.FootComponent", "call visibleFooter again.");
      fHL();
    }
    for (;;)
    {
      this.fNI.alive();
      this.fNH.alive();
      AppMethodBeat.o(35334);
      return;
      ae.i("MicroMsg.ChattingUI.FootComponent", "no call visibleFooter again.");
    }
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(35335);
    Object localObject;
    if (this.vTx != null)
    {
      localObject = this.vTx;
      if (((ChatFooter)localObject).Fud != null)
      {
        ((ChatFooter)localObject).vNt.removeTextChangedListener(((ChatFooter)localObject).Fud);
        ((ChatFooter)localObject).Fud = null;
      }
      ae.i("MicroMsg.ChattingUI.FootComponent", "removeTextChangeListener");
      this.vTx.onPause();
      this.fNI.dead();
      this.fNH.dead();
      if (!com.tencent.mm.kernel.g.ajM())
      {
        ae.w("MicroMsg.ChattingUI.FootComponent", "account not ready");
        AppMethodBeat.o(35335);
      }
    }
    else
    {
      AppMethodBeat.o(35335);
      return;
    }
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(18, Integer.valueOf(this.vTx.getMode()));
    ae.d("MicroMsg.ChattingUI.FootComponent", "dkcm old:%d footer:%d ", new Object[] { Integer.valueOf(this.KdR), Integer.valueOf(this.vTx.getMode()) });
    if (this.KdR != this.vTx.getMode())
    {
      this.KdR = this.vTx.getMode();
      bc.aCg();
      localObject = com.tencent.mm.model.c.azL().aVa(this.cXJ.getTalkerUserName());
      if ((localObject != null) && (this.cXJ.getTalkerUserName().equals(((ba)localObject).field_username)))
      {
        ((au)localObject).ks(this.KdR);
        bc.aCg();
        com.tencent.mm.model.c.azL().a((au)localObject, this.cXJ.getTalkerUserName());
      }
    }
    this.vTx.a(ChatFooter.h.FvC);
    AppMethodBeat.o(35335);
  }
  
  public final void fAx() {}
  
  public final void fGE()
  {
    AppMethodBeat.i(35332);
    super.fGE();
    if (this.vTx != null)
    {
      this.vTx.setFooterEventListener(null);
      com.tencent.mm.ui.chatting.q.efC();
      this.KdP = null;
      this.vTx.setSmileyPanelCallback(null);
      this.vTx.setSmileyPanelCallback2(null);
    }
    if (this.KdQ != null)
    {
      this.KdQ.fFc();
      this.KdQ = null;
    }
    fHH();
    if (this.KdQ != null) {
      this.KdQ.fFf();
    }
    com.tencent.mm.pluginsdk.ui.span.k.clearCache();
    if (this.vTx != null) {
      this.vTx.fhE();
    }
    if ((this.cXJ.Kkd.isCurrentActivity) && (this.vTx != null)) {
      this.vTx.destroy();
    }
    com.tencent.mm.kernel.g.ajS();
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().b(this);
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().remove(this);
    AppMethodBeat.o(35332);
  }
  
  public final ChatFooter fHF()
  {
    return this.vTx;
  }
  
  public final ChatFooterCustom fHG()
  {
    return this.KdQ;
  }
  
  public final String fHI()
  {
    return this.KdW;
  }
  
  public final void fHJ()
  {
    AppMethodBeat.i(35316);
    try
    {
      if (this.vTx.fhz()) {
        this.vTx.setBottomPanelVisibility(8);
      }
      AppMethodBeat.o(35316);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(35316);
    }
  }
  
  public final void fHK()
  {
    AppMethodBeat.i(35317);
    this.cXJ.hideVKB();
    ae.i("MicroMsg.ChattingUI.FootComponent", "visibleCustomFooter customFooter is %s", new Object[] { this.KdQ });
    if (this.KdQ == null)
    {
      AppMethodBeat.o(35317);
      return;
    }
    this.KdQ.setVisibility(0);
    if (this.vTx != null)
    {
      this.vTx.g(0, false, -1);
      this.vTx.setVisibility(8);
    }
    AppMethodBeat.o(35317);
  }
  
  public final void fHL()
  {
    AppMethodBeat.i(35318);
    if (this.vTx == null)
    {
      AppMethodBeat.o(35318);
      return;
    }
    this.vTx.setVisibility(0);
    if (this.KdQ != null) {
      this.KdQ.setVisibility(8);
    }
    AppMethodBeat.o(35318);
  }
  
  public final void fHN()
  {
    AppMethodBeat.i(35320);
    this.KdV = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.KdV.setInterpolator(new DecelerateInterpolator(1.5F));
    this.KdV.addAnimation(localTranslateAnimation);
    this.KdV.addAnimation(localAlphaAnimation);
    this.KdV.setDuration(300L);
    this.KdV.setFillBefore(true);
    if (this.vTx != null) {
      this.vTx.startAnimation(this.KdV);
    }
    AppMethodBeat.o(35320);
  }
  
  public final void fHO()
  {
    AppMethodBeat.i(35321);
    ae.i("MicroMsg.ChattingUI.FootComponent", "triggerFooter, originChatFooterVisibility:%s", new Object[] { Integer.valueOf(this.KdX) });
    if (this.vTx == null)
    {
      this.vTx = ((ChatFooter)this.cXJ.findViewById(2131302672));
      this.vTx.a(new ChatFooter.b()
      {
        public final com.tencent.mm.ui.chatting.i.b fie()
        {
          return v.this.cXJ.Kka;
        }
        
        public final com.tencent.mm.ui.chatting.e.a fif()
        {
          return v.this.cXJ;
        }
        
        public final String getTalkerUserName()
        {
          AppMethodBeat.i(35306);
          String str = v.this.cXJ.getTalkerUserName();
          AppMethodBeat.o(35306);
          return str;
        }
      });
      ((com.tencent.mm.ui.chatting.d.b.r)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.r.class)).bC(this.vTx);
      fHQ();
    }
    boolean bool1 = ((com.tencent.mm.ui.chatting.d.b.l)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.l.class)).fHv();
    boolean bool2 = ((com.tencent.mm.ui.chatting.d.b.af)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.af.class)).fID();
    if ((bool1) || (bool2) || (com.tencent.mm.ui.widget.snackbar.b.bnS()))
    {
      if (!this.KdZ) {
        this.KdX = this.vTx.getVisibility();
      }
      this.vTx.g(0, true, -1);
      if (this.KdQ != null) {
        if (this.KdZ) {}
      }
      for (this.KdY = this.KdQ.getVisibility();; this.KdY = -1)
      {
        fHM();
        this.KdZ = true;
        AppMethodBeat.o(35321);
        return;
      }
    }
    this.KdZ = false;
    if ((this.KdX == 8) && (this.KdY == 8))
    {
      fHM();
      AppMethodBeat.o(35321);
      return;
    }
    if (this.KdX == 0)
    {
      fHL();
      AppMethodBeat.o(35321);
      return;
    }
    fHK();
    AppMethodBeat.o(35321);
  }
  
  public final void fHP()
  {
    AppMethodBeat.i(35324);
    String str = this.cXJ.getTalkerUserName();
    int i;
    if ((com.tencent.mm.model.x.At(str)) || (an.aUn(str))) {
      i = 1;
    }
    while (i == 2)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.cXJ.Kkd.getContext(), "android.permission.RECORD_AUDIO", 80, "", "");
      ae.i("MicroMsg.ChattingUI.FootComponent", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this.cXJ.Kkd.getContext() });
      if (bool) {
        break;
      }
      this.vTx.bg(1, false);
      AppMethodBeat.o(35324);
      return;
      if (com.tencent.mm.model.x.AK(str))
      {
        i = 2;
      }
      else
      {
        int j = this.cXJ.Kkd.getIntExtra("Chat_Mode", 0);
        ae.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", new Object[] { Integer.valueOf(this.KdR), Integer.valueOf(j) });
        if (this.KdR != 0) {
          j = this.KdR;
        }
        str = com.tencent.mm.n.g.acL().getValue("DefaultMsgType");
        i = j;
        if (this.KdR == 0)
        {
          i = j;
          if (str != null)
          {
            ae.d("MicroMsg.ChattingUI.FootComponent", "config def chatmode is %s", new Object[] { str });
            i = bu.getInt(com.tencent.mm.n.g.acL().getValue("DefaultMsgType"), 0);
          }
        }
        j = i;
        if (i == 0)
        {
          j = i;
          if (com.tencent.mm.contact.c.lO(this.cXJ.Cqh.field_type))
          {
            bc.aCg();
            j = ((Integer)com.tencent.mm.model.c.ajA().get(18, Integer.valueOf(0))).intValue();
          }
        }
        i = j;
        if (j == 0) {
          i = 1;
        }
        ae.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", new Object[] { Integer.valueOf(this.KdR), Integer.valueOf(i) });
      }
    }
    this.vTx.bg(i, false);
    AppMethodBeat.o(35324);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35329);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((1111 == paramInt1) && (-1 == paramInt2)) {
      this.vTx.fhf();
    }
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 200) || (paramInt1 == 201) || (paramInt1 == 203)) {
        this.vTx.clearFocus();
      }
      AppMethodBeat.o(35329);
      return;
    }
    if ((paramInt1 != 217) && (this.KdQ != null)) {
      this.KdQ.p(paramInt1, paramIntent);
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
        ae.e("MicroMsg.ChattingUI.FootComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
        AppMethodBeat.o(35329);
        return;
      }
      paramInt1 = paramIntent.getIntExtra("Chat_Mode", 1);
      if (this.vTx != null) {
        this.vTx.setMode(paramInt1);
      }
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int j = 0;
    AppMethodBeat.i(35331);
    ae.i("MicroMsg.ChattingUI.FootComponent", "chatting onKeyDown, code:%d action:%d", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    if (paramKeyEvent.getKeyCode() == 4) {
      if (!this.cXJ.cCq) {
        ae.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown back key fragment not foreground");
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
        if ((this.cXJ.Kkd.isSupportNavigationSwipeBack()) && (this.cXJ.Kkd.getSwipeBackLayout().fhy()))
        {
          ae.w("MicroMsg.ChattingUI.FootComponent", "ashutest::onKeyDown back ScrollToFinishing");
          i = 1;
        }
        else
        {
          if (paramKeyEvent.getAction() == 0)
          {
            this.Keb = true;
            this.Ked = System.currentTimeMillis();
          }
          if (paramKeyEvent.getAction() != 1) {
            break label356;
          }
          ae.d("MicroMsg.ChattingUI.FootComponent", "hasBack %B, %d", new Object[] { Boolean.valueOf(this.Keb), Long.valueOf(System.currentTimeMillis() - this.Ked) });
          if ((this.Keb) && (System.currentTimeMillis() - this.Ked <= 30000L)) {
            break;
          }
          i = 1;
        }
      }
      this.Kec = true;
      Object localObject = (com.tencent.mm.ui.chatting.d.b.l)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.l.class);
      com.tencent.mm.ui.chatting.d.b.aj localaj = (com.tencent.mm.ui.chatting.d.b.aj)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.aj.class);
      if (((com.tencent.mm.ui.chatting.d.b.l)localObject).fHv()) {
        if (localaj.fIN())
        {
          localaj.fIM();
          ((com.tencent.mm.ui.chatting.d.b.l)localObject).fHw();
          label291:
          i = 1;
          label293:
          if (i == 0) {
            if (this.vTx != null)
            {
              localObject = this.vTx;
              if ((((ChatFooter)localObject).Fsg == 0) && (!((ChatFooter)localObject).FmA)) {
                break label387;
              }
              if (!((ChatFooter)localObject).FmA) {
                break label376;
              }
              ((ChatFooter)localObject).ffS();
              label339:
              i = 1;
            }
          }
        }
      }
      for (;;)
      {
        if (i == 0) {
          this.cXJ.Kkd.fEZ();
        }
        label356:
        i = 1;
        break;
        ((com.tencent.mm.ui.chatting.d.b.l)localObject).fHt();
        break label291;
        i = 0;
        break label293;
        label376:
        ((ChatFooter)localObject).g(0, true, -1);
        break label339;
        label387:
        i = j;
        if (((ChatFooter)localObject).Ftx != null)
        {
          i = j;
          if (((ChatFooter)localObject).Ftx.getVisibility() == 0)
          {
            ((ChatFooter)localObject).Ftx.evf();
            i = 1;
          }
        }
      }
      if ((paramKeyEvent.getKeyCode() == 67) && (!this.cXJ.cCq)) {
        ae.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown back key fragment not foreground");
      } else if (!this.cXJ.cCq) {
        ae.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown fragment not foreground");
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
        ae.w("MicroMsg.ChattingUI.FootComponent", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, bu.fpN() });
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
        ae.i("MicroMsg.ChattingUI.FootComponent", "summerper doFooterLiveRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.KdP, bu.fpN() });
        if (this.KdP != null) {
          this.KdP.vUh.dow();
        }
        AppMethodBeat.o(35330);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131761860;; paramInt = 2131761871)
      {
        if (paramArrayOfInt[0] != 0) {
          h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(paramInt), this.cXJ.Kkd.getMMResources().getString(2131761885), this.cXJ.Kkd.getMMResources().getString(2131760598), this.cXJ.Kkd.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35311);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = v.this.cXJ.Kkd;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/component/FootComponent$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
        ae.i("MicroMsg.ChattingUI.FootComponent", "summerper doFooterSightRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.KdP, bu.fpN() });
        if (this.KdP != null)
        {
          paramArrayOfString = this.KdP;
          if (!this.vTx.Frs.FpZ.FqO.value) {
            break label446;
          }
        }
        label446:
        for (paramInt = i;; paramInt = 2)
        {
          paramArrayOfString.ady(paramInt);
          AppMethodBeat.o(35330);
          return;
        }
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131761860;; paramInt = 2131761871)
      {
        if (paramArrayOfInt[0] != 0) {
          h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(paramInt), this.cXJ.Kkd.getMMResources().getString(2131761885), this.cXJ.Kkd.getMMResources().getString(2131760598), this.cXJ.Kkd.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35302);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = v.this.cXJ.Kkd;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/component/FootComponent$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
          ae.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuVideoSelected,footerEventImpl[%s], stack[%s]", new Object[] { this.KdP, bu.fpN() });
          if (this.KdP != null) {
            this.KdP.dEp();
          }
          AppMethodBeat.o(35330);
          return;
        }
        if (paramInt == 21)
        {
          ae.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.KdP, bu.fpN() });
          if (this.KdP != null) {
            this.KdP.fFF();
          }
          AppMethodBeat.o(35330);
          return;
        }
        ae.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnEnterMultiTalk,footerEventImpl[%s], stack[%s]", new Object[] { this.KdP, bu.fpN() });
        if (this.KdP != null) {
          this.KdP.fFD();
        }
        AppMethodBeat.o(35330);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131761860;; paramInt = 2131761871)
      {
        if (paramArrayOfInt[0] != 0) {
          h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(paramInt), this.cXJ.Kkd.getMMResources().getString(2131761885), this.cXJ.Kkd.getMMResources().getString(2131760598), this.cXJ.Kkd.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(163307);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = v.this.cXJ.Kkd;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/component/FootComponent$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
        ae.i("MicroMsg.ChattingUI.FootComponent", "summerper doImageSelectTakePhotoRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.KdP, bu.fpN() });
        if (this.KdP != null) {
          this.KdP.fFH();
        }
        AppMethodBeat.o(35330);
        return;
      }
      h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131761860), this.cXJ.Kkd.getMMResources().getString(2131761885), this.cXJ.Kkd.getMMResources().getString(2131760598), this.cXJ.Kkd.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(169867);
          paramAnonymousDialogInterface = v.this.cXJ.Kkd;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/component/FootComponent$15", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$15", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(169867);
        }
      }, null);
      AppMethodBeat.o(35330);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ae.i("MicroMsg.ChattingUI.FootComponent", "summerper doTalkRoomRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.KdP, bu.fpN() });
        if (this.KdP != null) {
          this.KdP.fFG();
        }
        AppMethodBeat.o(35330);
        return;
      }
      h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131761869), this.cXJ.Kkd.getMMResources().getString(2131761885), this.cXJ.Kkd.getMMResources().getString(2131760598), this.cXJ.Kkd.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(184958);
          paramAnonymousDialogInterface = v.this.cXJ.Kkd;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/component/FootComponent$16", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
          ae.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuAudioSelected,footerEventImpl[%s], stack[%s]", new Object[] { this.KdP, bu.fpN() });
          if (this.KdP != null) {
            this.KdP.dEo();
          }
          AppMethodBeat.o(35330);
          return;
        }
        ae.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipAudioRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.KdP, bu.fpN() });
        if (this.KdP != null) {
          this.KdP.fFE();
        }
        AppMethodBeat.o(35330);
        return;
      }
      h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131761871), this.cXJ.Kkd.getMMResources().getString(2131761885), this.cXJ.Kkd.getMMResources().getString(2131760598), this.cXJ.Kkd.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(187331);
          paramAnonymousDialogInterface = v.this.cXJ.Kkd;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/component/FootComponent$17", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$17", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(187331);
        }
      }, null);
      AppMethodBeat.o(35330);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ae.i("MicroMsg.ChattingUI.FootComponent", "doSendFileRequest, footerEventImpl[%s], stack[%s].", new Object[] { this.KdP, bu.fpN() });
        if (this.KdP != null) {
          this.KdP.fFA();
        }
        AppMethodBeat.o(35330);
        return;
      }
      h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131761878), this.cXJ.Kkd.getMMResources().getString(2131761885), this.cXJ.Kkd.getMMResources().getString(2131760598), this.cXJ.Kkd.getMMResources().getString(2131759760), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(187332);
          paramAnonymousDialogInterface = v.this.cXJ.Kkd;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/component/FootComponent$18", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$18", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(187332);
        }
      }, null);
    }
  }
  
  public final void setVoiceInputShowCallback(ChatFooter.d paramd)
  {
    AppMethodBeat.i(35326);
    this.vTx.setVoiceInputShowCallback(paramd);
    AppMethodBeat.o(35326);
  }
  
  final class a
    implements TextWatcher
  {
    private boolean Kej = false;
    private List<String> Kek = null;
    
    private a() {}
    
    private static boolean gI(String paramString, int paramInt)
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
      ae.i("MicroMsg.ChattingUI.FootComponent", "[onTextChanged]");
      ((com.tencent.mm.ui.chatting.d.b.al)v.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.al.class)).adU(1);
      Object localObject1 = (com.tencent.mm.ui.chatting.d.b.d)v.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class);
      paramCharSequence = String.valueOf(paramCharSequence);
      Object localObject2 = paramCharSequence.substring(paramInt1, paramInt1 + paramInt3);
      Object localObject3;
      Object localObject4;
      if ((v.this.cXJ.fJB()) && ("@".equals(localObject2)) && (!paramCharSequence.equals(v.this.vTx.getLastContent())) && (!v.this.vTx.FrQ))
      {
        v.this.vTx.setLastContent(paramCharSequence);
        v.this.vTx.setInsertPos(paramInt1 + 1);
        if (gI(paramCharSequence, paramInt1))
        {
          localObject3 = bu.m(com.tencent.mm.model.r.zA(v.this.cXJ.getTalkerUserName()), ",");
          localObject4 = new Intent();
          ((Intent)localObject4).setClass(v.this.cXJ.Kkd.getContext(), AtSomeoneUI.class);
          ((Intent)localObject4).putExtra("Block_list", com.tencent.mm.model.v.aAC());
          ((Intent)localObject4).putExtra("Chatroom_member_list", (String)localObject3);
          ((Intent)localObject4).putExtra("Chat_User", v.this.cXJ.getTalkerUserName());
          ((Intent)localObject4).putExtra("Add_address_titile", v.this.cXJ.Kkd.getMMString(2131762574));
          v.this.cXJ.Kkd.startActivityForResult((Intent)localObject4, 212);
        }
        ((ak)v.this.cXJ.bh(ak.class)).H(paramCharSequence, paramInt1, (String)localObject2);
        if ((!((com.tencent.mm.ui.chatting.d.b.d)localObject1).fGJ()) && (!an.aUx(v.this.cXJ.getTalkerUserName())))
        {
          localObject2 = v.this.vTx;
          if ((((ChatFooter)localObject2).FrJ != null) && (((ChatFooter)localObject2).gpu != null))
          {
            ((ChatFooter)localObject2).FrJ.FwA = true;
            localObject1 = ((ChatFooter)localObject2).FrJ;
            localObject2 = ((ChatFooter)localObject2).FsE.getTalkerUserName();
            if (!bu.isNullOrNil(paramCharSequence)) {
              break label769;
            }
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).mHandler.removeMessages(20003);
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).mHandler.sendEmptyMessage(20001);
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).uOk = paramCharSequence;
            if (((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).FwE != null)
            {
              ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).FwE.dead();
              ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).FwE = null;
            }
          }
        }
      }
      for (;;)
      {
        if ((com.tencent.mm.model.x.wb(v.this.cXJ.getTalkerUserName())) && (!v.this.vTx.fhG())) {
          v.this.vTx.aOv(paramCharSequence);
        }
        AppMethodBeat.o(35313);
        return;
        if ((((com.tencent.mm.ui.chatting.d.b.d)localObject1).fGK()) && ("@".equals(localObject2)) && (!paramCharSequence.equals(v.this.vTx.getLastContent())) && (!v.this.vTx.FrQ))
        {
          v.this.vTx.setLastContent(paramCharSequence);
          v.this.vTx.setInsertPos(paramInt1 + 1);
          if (!gI(paramCharSequence, paramInt1)) {
            break;
          }
          localObject3 = ((com.tencent.mm.ui.chatting.d.b.d)localObject1).fGH().field_userList;
          localObject4 = new Intent();
          ((Intent)localObject4).setClass(v.this.cXJ.Kkd.getContext(), BizChatAtSomeoneUI.class);
          ((Intent)localObject4).putExtra("Block_list", ag.aGt().eQ(v.this.cXJ.getTalkerUserName()));
          ((Intent)localObject4).putExtra("Chatroom_member_list", (String)localObject3);
          ((Intent)localObject4).putExtra("Chat_User", v.this.cXJ.getTalkerUserName());
          ((Intent)localObject4).putExtra("Add_address_titile", v.this.cXJ.Kkd.getMMString(2131762574));
          ((Intent)localObject4).putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.d.b.d)v.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGW());
          v.this.cXJ.Kkd.startActivityForResult((Intent)localObject4, 212);
          break;
        }
        if (paramCharSequence.equals(v.this.vTx.getLastContent())) {
          break;
        }
        v.this.vTx.setLastContent(paramCharSequence);
        break;
        label769:
        if (!paramCharSequence.equals(((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).uOk))
        {
          ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).hide();
          if (((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).FwE != null)
          {
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).FwE.dead();
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).FwE = null;
          }
          ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).FwE = new com.tencent.mm.vending.e.c();
          localObject3 = String.valueOf(bu.fpO());
          localObject4 = ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).FwF;
          ((gk)localObject4).dTr = ((gk)localObject4).t("SessionId", (String)localObject3, true);
          localObject4 = ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).FwF;
          ((gk)localObject4).epz = ((gk)localObject4).t("ChatId", (String)localObject2, true);
          ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).FwC.clear();
          ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).FwG = 0;
          localObject4 = new com.tencent.mm.emoji.a.c.b(((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).FwE);
          d.g.b.p.h(localObject3, "sessionId");
          com.tencent.mm.emoji.a.c.f localf = ((com.tencent.mm.emoji.a.c.b)localObject4).gov;
          d.g.b.p.h(localObject3, "sessionId");
          localf.username = ((String)localObject2);
          localf.sessionId = ((String)localObject3);
          localObject2 = new m.5((com.tencent.mm.pluginsdk.ui.chat.m)localObject1, bu.fpO());
          d.g.b.p.h(paramCharSequence, "desc");
          localObject3 = com.tencent.mm.emoji.a.c.d.goH;
          com.tencent.mm.emoji.a.c.d.md(0);
          com.tencent.mm.ac.c.b("EmojiSuggest_searchSuggest", (d.g.a.a)new b.b((com.tencent.mm.emoji.a.c.b)localObject4, paramCharSequence, (j.b)localObject2));
        }
        ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).uOk = paramCharSequence;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.v
 * JD-Core Version:    0.7.0.1
 */