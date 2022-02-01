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
import com.tencent.mm.am.ag;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.c;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.emoji.a.b.b.b;
import com.tencent.mm.emoji.a.b.j.b;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.g.b.a.gi;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI;
import com.tencent.mm.ui.chatting.AtSomeoneUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.af;
import com.tencent.mm.ui.chatting.d.b.aj;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.r;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.d.a.a(fFo=s.class)
public class v
  extends a
  implements k.a, n.b, s
{
  private static ArrayList<a.a> JIR = null;
  private static long JIS = 0L;
  private final ChatFooter.g EZo;
  private com.tencent.mm.ui.chatting.p JIT;
  protected ChatFooterCustom JIU;
  private int JIV;
  private t JIW;
  private com.tencent.mm.ui.chatting.w JIX;
  private com.tencent.mm.ui.chatting.h JIY;
  private AnimationSet JIZ;
  private String JJa;
  private int JJb;
  private int JJc;
  private boolean JJd;
  public boolean JJe;
  private boolean JJf;
  public boolean JJg;
  private long JJh;
  private com.tencent.mm.sdk.b.c fLD;
  private com.tencent.mm.sdk.b.c fLE;
  protected ChatFooter vHt;
  
  public v()
  {
    AppMethodBeat.i(35314);
    this.JIV = 0;
    this.JJa = null;
    this.JJd = false;
    this.JJe = false;
    this.fLD = new com.tencent.mm.sdk.b.c() {};
    this.fLE = new com.tencent.mm.sdk.b.c() {};
    this.EZo = new ChatFooter.g()
    {
      private Animation JJj;
      private Animation JJk;
      
      public final boolean wg(boolean paramAnonymousBoolean)
      {
        int i = 1;
        AppMethodBeat.i(35305);
        if (this.JJj == null)
        {
          this.JJj = AnimationUtils.loadAnimation(v.this.cWM.JOR.getContext(), 2130772108);
          this.JJk = AnimationUtils.loadAnimation(v.this.cWM.JOR.getContext(), 2130772106);
        }
        com.tencent.mm.ui.chatting.d.b.d locald;
        String str;
        if (paramAnonymousBoolean)
        {
          ad.i("MicroMsg.ChattingUI.FootComponent", "switchFooterToInput customFooter is %s", new Object[] { v.this.JIU });
          if (v.this.JIU != null) {
            v.this.JIU.startAnimation(this.JJk);
          }
          v.this.fDI();
          v.this.vHt.startAnimation(this.JJj);
          v.this.vHt.postInvalidateDelayed(this.JJj.getDuration());
          locald = (com.tencent.mm.ui.chatting.d.b.d)v.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class);
          if (locald != null)
          {
            str = v.this.cWM.getTalkerUserName();
            if (!paramAnonymousBoolean) {
              break label262;
            }
          }
        }
        for (;;)
        {
          locald.gy(str, i);
          AppMethodBeat.o(35305);
          return false;
          v.this.vHt.startAnimation(this.JJk);
          v.this.fDH();
          if (v.this.JIU == null) {
            break;
          }
          v.this.JIU.startAnimation(this.JJj);
          v.this.JIU.postInvalidateDelayed(this.JJj.getDuration());
          break;
          label262:
          i = 2;
        }
      }
    };
    this.JJf = false;
    this.JJg = false;
    this.JJh = 0L;
    AppMethodBeat.o(35314);
  }
  
  private void a(final String paramString, final as.b.a parama)
  {
    AppMethodBeat.i(163315);
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184961);
        as.a.hFO.a(paramString, "", parama);
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
  
  private void a(String paramString, am paramam, ArrayList<a.a> paramArrayList)
  {
    AppMethodBeat.i(163316);
    long l1;
    if (paramam == null)
    {
      l1 = 0L;
      ad.i("MicroMsg.ChattingUI.FootComponent", "ChatroomBusinessType user %s %s", new Object[] { paramString, Long.valueOf(l1) });
      if ((!this.cWM.fFu()) || (paramam == null) || (paramam.ePP == 0L)) {
        break label222;
      }
      if (JIR != null) {
        break label166;
      }
      JIR = new ArrayList();
      fDO();
      JIS = cf.aCK();
    }
    for (;;)
    {
      paramString = JIR;
      if ((paramString == null) || (paramString.size() <= 0)) {
        break label222;
      }
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        a.a locala = (a.a)paramString.next();
        if ((locala.EYQ & paramam.ePP) != 0L)
        {
          locala.jCX = paramam.field_username;
          paramArrayList.add(locala);
        }
      }
      l1 = paramam.ePP;
      break;
      label166:
      l1 = cf.aCK();
      long l2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qEu, 1800);
      if (l1 - JIS > l2)
      {
        JIS = l1;
        JIR.clear();
        fDO();
      }
    }
    label222:
    this.vHt.setAppPanelUnCertainEnterArrayList(paramArrayList);
    AppMethodBeat.o(163316);
  }
  
  private void aWe(final String paramString)
  {
    AppMethodBeat.i(35325);
    ad.i("MicroMsg.ChattingUI.FootComponent", "initFooterPanelMenu %s", new Object[] { paramString });
    this.vHt.fdv();
    this.vHt.fdm();
    int i;
    Object localObject1;
    int j;
    label126:
    boolean bool1;
    if (((com.tencent.mm.ui.chatting.d.b.l)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.l.class)).fDs())
    {
      ad.w("MicroMsg.ChattingUI.FootComponent", "match shake, in show mode, do not open short video recode view");
      i = 0;
      if (i == 0) {
        this.vHt.fdx();
      }
      if (((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH())
      {
        localObject1 = com.tencent.mm.am.g.eS(this.cWM.getTalkerUserName());
        if ((localObject1 != null) && (((com.tencent.mm.api.c)localObject1).field_enterpriseFather != null)) {
          break label2661;
        }
        j = 0;
        if (j != 0)
        {
          localObject1 = this.vHt.EYU;
          ((AppPanel)localObject1).EXF.EYx.value = true;
          ((AppPanel)localObject1).fcY();
        }
      }
      if (!this.cWM.fFv()) {
        this.vHt.fdF();
      }
      bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qyJ, true);
      localObject1 = this.vHt;
      if (!i.DEBUG) {
        break label2715;
      }
      i = 1;
      label206:
      ad.i("MicroMsg.ChattingUI.FootComponent", "isGroupChat:%b enableLive:%b", new Object[] { Boolean.valueOf(this.cWM.fFv()), Boolean.valueOf(bool1) });
      if ((this.cWM.fFv()) && (bool1) && (i != 0)) {
        break label2943;
      }
      this.vHt.EYU.fcX();
      label268:
      if (!com.tencent.mm.model.w.zk(this.cWM.getTalkerUserName())) {
        this.vHt.EYU.fcX();
      }
      if ((this.cWM.BYG != null) && (!com.tencent.mm.o.b.lM(this.cWM.BYG.field_type)) && (!com.tencent.mm.model.w.vF(this.cWM.getTalkerUserName()))) {
        this.vHt.fdA();
      }
      if (am.zs(paramString))
      {
        this.vHt.EYU.fcP();
        this.vHt.EYU.fcR();
        this.vHt.EYU.fcS();
        this.vHt.fdy();
        this.vHt.fdz();
        this.vHt.EYU.fcQ();
        this.vHt.aN(true, true);
        this.vHt.fdA();
        this.vHt.fdC();
        this.vHt.EYU.fcU();
        this.vHt.EYU.fcX();
      }
      if (am.aSP(paramString))
      {
        this.vHt.EYU.fcP();
        this.vHt.EYU.fcR();
        this.vHt.EYU.fcS();
        this.vHt.fdy();
        this.vHt.fdz();
        this.vHt.EYU.fcQ();
        this.vHt.aN(true, true);
        this.vHt.fdA();
        this.vHt.fdC();
        this.vHt.EYU.fcU();
        this.vHt.EYU.fcX();
      }
      if (am.aSN(paramString))
      {
        this.vHt.EYU.fcP();
        this.vHt.EYU.fcR();
        this.vHt.EYU.fcS();
        this.vHt.fdy();
        this.vHt.fdu();
        this.vHt.fdz();
        this.vHt.EYU.fcQ();
        this.vHt.aN(true, true);
        this.vHt.fdA();
        this.vHt.fdC();
        this.vHt.EYU.fcU();
        this.vHt.EYU.fcX();
      }
      if (am.ail(paramString))
      {
        this.vHt.fdm();
        this.vHt.fdu();
        this.vHt.EYU.fcS();
        this.vHt.fdF();
        this.vHt.fdz();
        this.vHt.fdw();
        this.vHt.EYU.fcP();
        this.vHt.fdx();
        this.vHt.fdz();
        this.vHt.fdE();
        this.vHt.fbF();
        this.vHt.EYU.fcT();
        this.vHt.aN(true, true);
        this.vHt.vS(true);
        this.vHt.vT(true);
        this.vHt.fdA();
        this.vHt.fdC();
        this.vHt.EYU.fcQ();
        this.vHt.EYU.fcP();
        this.vHt.EYU.fcR();
        this.vHt.EYU.fcU();
      }
      if (com.tencent.mm.model.w.zT(paramString))
      {
        this.vHt.EYU.fcP();
        this.vHt.EYU.fcR();
        this.vHt.EYU.fcS();
        this.vHt.fdz();
        this.vHt.EYU.fcQ();
        this.vHt.aN(true, true);
        this.vHt.fdA();
        this.vHt.fdC();
        this.vHt.EYU.fcU();
        this.vHt.EYU.fcX();
      }
      if (com.tencent.mm.model.w.zQ(paramString))
      {
        this.vHt.EYU.fcP();
        this.vHt.aN(true, true);
        this.vHt.EYU.fcQ();
        this.vHt.EYU.fcU();
        this.vHt.EYU.fcX();
      }
      com.tencent.mm.model.ba.aBQ();
      localObject1 = com.tencent.mm.model.c.azp().Bf(paramString);
      if ((localObject1 != null) && (((am)localObject1).fqg()))
      {
        if (!((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH()) {
          break label2969;
        }
        this.vHt.EYU.fcP();
        this.vHt.EYU.fcS();
        this.vHt.EYU.fcQ();
        this.vHt.aN(true, true);
        this.vHt.fdA();
        this.vHt.fdC();
        this.vHt.fdx();
        this.vHt.EYU.fcT();
        this.vHt.fdw();
        this.vHt.fdE();
        this.vHt.fbF();
        this.vHt.EYU.fcX();
      }
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.b.a.IbL.l(new qo());
        if (this.cWM.fFu())
        {
          if (com.tencent.mm.n.g.acA().getInt("MultitalkBlockCaller", 0) == 0)
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            this.vHt.vS(false);
            if ((this.cWM.fFv()) || (this.cWM.fFt()))
            {
              this.vHt.aN(true, true);
              this.vHt.fdC();
            }
            com.tencent.mm.bs.d.ffH();
            if (this.cWM.fFt()) {
              this.vHt.EYU.fcQ();
            }
            if (this.cWM.getTalkerUserName().equals(u.aAm()))
            {
              this.vHt.EYU.fcQ();
              this.vHt.aN(true, true);
              this.vHt.fdA();
              this.vHt.fdC();
              this.vHt.EYU.fcX();
            }
            this.vHt.setAppPanelTip(null);
            if ((!am.aSQ(this.cWM.BYG.field_username)) && (!com.tencent.mm.model.w.zl(this.cWM.BYG.field_username))) {
              continue;
            }
            com.tencent.mm.kernel.g.ajD();
            Object localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(this.cWM.BYG.field_username);
            ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).bB(((aw)localObject3).field_openImAppid, ((aw)localObject3).field_descWordingId);
            i = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).ID(((aw)localObject3).field_openImAppid);
            Object localObject2 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(this.cWM.BYG.field_openImAppid, "openim_function_tip", com.tencent.mm.openim.a.b.a.iHt);
            ad.i("MicroMsg.ChattingUI.FootComponent", "openim showFlag:%d username: %s appid: %s tip %s", new Object[] { Integer.valueOf(i), this.cWM.BYG.field_username, ((aw)localObject3).field_openImAppid, localObject2 });
            if ((i & 0x1) == 0) {
              this.vHt.fdu();
            }
            if ((i & 0x2) == 0) {
              this.vHt.fdw();
            }
            if ((i & 0x4) == 0) {
              this.vHt.fdD();
            }
            if ((i & 0x8) == 0) {
              this.vHt.fdy();
            }
            if ((i & 0x10) == 0) {
              this.vHt.EYU.fcR();
            }
            if ((i & 0x20) == 0) {
              this.vHt.EYU.fcP();
            }
            if ((i & 0x40) == 0) {
              this.vHt.EYU.fcU();
            }
            if ((i & 0x80) == 0) {
              this.vHt.fdz();
            }
            if (((i & 0x100) == 0) || ((i & 0x2000) == 0))
            {
              localObject3 = this.vHt;
              if ((i & 0x100) != 0) {
                continue;
              }
              bool1 = true;
              if ((i & 0x2000) != 0) {
                continue;
              }
              bool2 = true;
              ((ChatFooter)localObject3).aN(bool1, bool2);
            }
            if ((i & 0x200) == 0)
            {
              this.vHt.fdA();
              this.vHt.fdC();
            }
            if ((i & 0x400) == 0) {
              this.vHt.fdB();
            }
            if ((com.tencent.mm.model.w.zl(this.cWM.BYG.field_username)) && ((i & 0x100) == 0)) {
              this.vHt.vS(true);
            }
            this.vHt.setAppPanelTip((CharSequence)localObject2);
            localObject2 = this.vHt;
            com.tencent.mm.bs.d.ffH();
            if (((ChatFooter)localObject2).pWJ != null) {
              ((ChatFooter)localObject2).pWJ.fbG();
            }
            localObject2 = this.vHt;
            com.tencent.mm.bs.d.ffH();
            if (!com.tencent.mm.ax.b.aJj()) {
              continue;
            }
            bool1 = true;
            ((ChatFooter)localObject2).vT(bool1);
            this.vHt.EYU.fcQ();
            if (am.yt(this.cWM.getTalkerUserName()))
            {
              this.vHt.fdm();
              this.vHt.fdu();
              this.vHt.EYU.fcS();
              this.vHt.fdF();
              this.vHt.EYU.fcX();
              this.vHt.fdz();
              this.vHt.fdw();
              this.vHt.fdy();
              this.vHt.EYU.fcP();
              this.vHt.fdx();
              this.vHt.fdz();
              this.vHt.fdw();
              this.vHt.fdE();
              this.vHt.fbF();
              this.vHt.EYU.fcT();
              this.vHt.aN(true, true);
              this.vHt.vS(true);
              this.vHt.vT(true);
              this.vHt.fdA();
              this.vHt.fdC();
              this.vHt.EYU.fcQ();
              this.vHt.EYU.fcP();
              this.vHt.EYU.fcR();
              this.vHt.EYU.fcU();
            }
            if (am.aSV(paramString))
            {
              this.vHt.fdm();
              if (!((com.tencent.mm.plugin.game.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.c.class)).cWE())
              {
                ad.i("MicroMsg.ChattingUI.FootComponent", "gamelife attachBtn disabled");
                localObject2 = this.vHt;
                ((ChatFooter)localObject2).EZF = true;
                ((ChatFooter)localObject2).EZb.setVisibility(8);
                ((ChatFooter)localObject2).wf(false);
              }
              localObject2 = this.vHt.EYU;
              ((AppPanel)localObject2).EXF.EYD.value = true;
              ((AppPanel)localObject2).fcY();
              this.vHt.fdu();
              this.vHt.EYU.fcS();
              this.vHt.fdF();
              this.vHt.fdD();
              this.vHt.fdz();
              this.vHt.fdw();
              this.vHt.fdy();
              this.vHt.fdx();
              this.vHt.fdE();
              this.vHt.fbF();
              this.vHt.EYU.fcT();
              this.vHt.aN(true, true);
              this.vHt.vS(true);
              this.vHt.vT(true);
              this.vHt.fdA();
              this.vHt.fdC();
              this.vHt.EYU.fcQ();
              this.vHt.EYU.fcP();
              this.vHt.EYU.fcR();
              this.vHt.EYU.fcU();
            }
            if ((!aa.Yh()) || (!com.tencent.mm.model.w.zk(this.cWM.getTalkerUserName()))) {
              this.vHt.EYU.fcV();
            }
            if (!((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.j.class)).amM(this.cWM.getTalkerUserName())) {
              this.vHt.EYU.fcW();
            }
            localObject2 = new ArrayList();
            a(paramString, (am)localObject1, (ArrayList)localObject2);
            paramString = new as.b.a()
            {
              public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(163312);
                if ((paramAnonymousBoolean) && (bt.lQ(v.this.cWM.getTalkerUserName(), paramAnonymousString))) {
                  com.tencent.mm.kernel.g.ajF().ay(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(163310);
                      v.a(v.this, v.15.this.cWF, v.15.this.fSV, new ArrayList());
                      aq.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(163309);
                          ChatFooter localChatFooter = v.this.vHt;
                          if ((localChatFooter.EZb != null) && (localChatFooter.EZb.getVisibility() == 0)) {
                            localChatFooter.wf(true);
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
            if ((((ArrayList)localObject2).size() != 0) || (localObject1 == null) || (((aw)localObject1).ePP != 0L)) {
              continue;
            }
            if (!com.tencent.mm.model.w.vF(this.cWM.getTalkerUserName())) {
              continue;
            }
            localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(this.cWM.getTalkerUserName());
            if ((localObject1 != null) && ((((ab)localObject1).field_chatroomStatus & 0x8000) != 0L) && ((((ab)localObject1).field_chatroomfamilystatusmodifytime == 0L) || (((ab)localObject1).field_chatroomfamilystatusmodifytime - cf.aCL() >= 86400000L)))
            {
              ((ab)localObject1).field_chatroomfamilystatusmodifytime = cf.aCL();
              ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().update((com.tencent.mm.sdk.e.c)localObject1, new String[0]);
              a(this.cWM.getTalkerUserName(), paramString);
            }
            AppMethodBeat.o(35325);
            return;
            bool1 = ((com.tencent.mm.ui.chatting.d.b.ai)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.ai.class)).fEN();
            bool2 = ((com.tencent.mm.ui.chatting.d.b.ai)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.ai.class)).fEM();
            if ((bool1) || (bool2))
            {
              ad.w("MicroMsg.ChattingUI.FootComponent", "match shake, in search mode, do not open short video recode view");
              i = 0;
              break;
            }
            if ((am.aSP(this.cWM.getTalkerUserName())) || (am.zs(this.cWM.getTalkerUserName())))
            {
              ad.w("MicroMsg.ChattingUI.FootComponent", "match shake, but is Qcontact or Bcontact");
              i = 0;
              break;
            }
            if (com.tencent.mm.model.w.Ap(this.cWM.getTalkerUserName()))
            {
              i = 0;
              break;
            }
            i = 1;
            break;
            label2661:
            localObject1 = ag.aFZ().DE(((com.tencent.mm.api.c)localObject1).field_enterpriseFather);
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
            label2715:
            if ((i.IS_FLAVOR_PURPLE) || (i.IS_FLAVOR_RED))
            {
              i = bt.getInt(com.tencent.mm.n.g.acA().getValue("ChatRoomEnableLive"), 0);
              if (i == 0)
              {
                localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(((ChatFooter)localObject1).EYT);
                if (localObject1 == null) {
                  break label3275;
                }
                if ((((ab)localObject1).field_chatroomStatus & 0x80000) == 524288)
                {
                  j = 1;
                  i = j;
                  if (j != 0) {
                    break label206;
                  }
                  if (com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IIY, 0) != 1) {
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
            if (((ChatFooter)localObject1).EYT == null) {
              continue;
            }
            i = bt.getInt(com.tencent.mm.n.g.acA().getValue("ChatRoomEnableLive"), 0);
            if (i == 0)
            {
              localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(((ChatFooter)localObject1).EYT);
              if (localObject1 == null) {
                continue;
              }
              if ((((ab)localObject1).field_chatroomStatus & 0x80000) == 524288)
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
            label2943:
            localObject1 = this.vHt.EYU;
            ((AppPanel)localObject1).EXF.wa(true);
            ((AppPanel)localObject1).fcY();
            break label268;
            label2969:
            this.vHt.EYU.fcP();
            this.vHt.aN(true, true);
            this.vHt.fdy();
            this.vHt.EYU.fcQ();
            this.vHt.EYU.fcX();
            continue;
          }
          i = 0;
          continue;
        }
        this.vHt.vS(true);
        continue;
        bool1 = false;
        continue;
        boolean bool2 = false;
        continue;
        if (!com.tencent.mm.model.w.zn(this.cWM.BYG.field_username)) {
          continue;
        }
        i = u.aBg();
        if ((i & 0x1) == 0) {
          this.vHt.vS(true);
        }
        if ((i & 0x2) == 0) {
          this.vHt.fdA();
        }
        if ((i & 0x4) != 0) {
          continue;
        }
        this.vHt.fdB();
        continue;
        bool1 = false;
        continue;
        if (com.tencent.mm.model.w.zl(this.cWM.getTalkerUserName()))
        {
          localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(this.cWM.getTalkerUserName());
          if ((localObject1 != null) && ((((ab)localObject1).fpL().type & 0x4) != 0L) && ((((ab)localObject1).field_chatroomfamilystatusmodifytime == 0L) || (((ab)localObject1).field_chatroomfamilystatusmodifytime - cf.aCL() >= 86400000L)))
          {
            ((ab)localObject1).field_chatroomfamilystatusmodifytime = cf.aCL();
            ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().update((com.tencent.mm.sdk.e.c)localObject1, new String[0]);
            a(this.cWM.getTalkerUserName(), paramString);
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
      label3275:
      j = 0;
    }
  }
  
  private static void aWf(String paramString)
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
        locala.EYF = paramString.optString("enter_id");
        locala.EYG = paramString.optInt("red_dot");
        locala.uxt = paramString.optInt("jump_type");
        locala.EYH = paramString.optString("wa_un");
        locala.EYI = paramString.optInt("wa_ver");
        locala.EYJ = paramString.optString("wa_path");
        locala.EYK = paramString.optString("wa_dgmode");
        locala.lYC = paramString.optString("h5_url");
        locala.iconUrl = paramString.optString("icon_url");
        locala.EYP = paramString.optString("icon_url_dark");
        if (bt.isNullOrNil(locala.iconUrl))
        {
          ad.e("MicroMsg.ChattingUI.FootComponent", "unCertainEnter.iconUrl is null");
        }
        else
        {
          locala.EYQ = paramString.optLong("busi_type");
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
      locala.EYL.title = ((JSONObject)localObject).optString("zh_cn");
      if (bt.isNullOrNil(locala.EYL.title))
      {
        ad.e("MicroMsg.ChattingUI.FootComponent", "unCertainEnter.simpleChWord.title is null");
      }
      else
      {
        a.b localb = locala.EYN;
        if (bt.isNullOrNil(((JSONObject)localObject).optString("zh_tw")))
        {
          paramString = locala.EYL.title;
          localb.title = paramString;
          localb = locala.EYM;
          if (!bt.isNullOrNil(((JSONObject)localObject).optString("zh_hk"))) {
            break label586;
          }
          paramString = locala.EYL.title;
          label391:
          localb.title = paramString;
          localb = locala.EYO;
          if (!bt.isNullOrNil(((JSONObject)localObject).optString("en"))) {
            break label598;
          }
          paramString = locala.EYL.title;
          label427:
          localb.title = paramString;
          if (localJSONObject != null)
          {
            locala.EYL.desc = localJSONObject.optString("zh_cn");
            localObject = locala.EYN;
            if (!bt.isNullOrNil(localJSONObject.optString("zh_tw"))) {
              break label610;
            }
            paramString = locala.EYL.desc;
            label484:
            ((a.b)localObject).desc = paramString;
            localObject = locala.EYM;
            if (!bt.isNullOrNil(localJSONObject.optString("zh_hk"))) {
              break label622;
            }
            paramString = locala.EYL.desc;
            label520:
            ((a.b)localObject).desc = paramString;
            localObject = locala.EYO;
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
        for (paramString = locala.EYL.desc;; paramString = localJSONObject.optString("en"))
        {
          ((a.b)localObject).desc = paramString;
          JIR.add(locala);
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
  
  private void fDE()
  {
    AppMethodBeat.i(35315);
    if (this.cWM.JOR.isCurrentActivity)
    {
      AppMethodBeat.o(35315);
      return;
    }
    this.cWM.JOT.fBS();
    if (this.vHt != null)
    {
      ChatFooter localChatFooter = this.vHt;
      Object localObject = localChatFooter.findViewById(2131298150);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localChatFooter.setSwitchButtonMode(0);
      localChatFooter.mHandler.removeMessages(1002);
      if (localChatFooter.EZb != null) {
        localChatFooter.EZb.setVisibility(8);
      }
      if (localChatFooter.EZc != null) {
        localChatFooter.EZc.setVisibility(8);
      }
      if (localChatFooter.EZd != null) {
        localChatFooter.EZd.setVisibility(8);
      }
      if (localChatFooter.EZg != null) {
        localChatFooter.EZg.setVisibility(8);
      }
      if (localChatFooter.EZe != null) {
        localChatFooter.EZe.setVisibility(8);
      }
      if (localChatFooter.EZh != null) {
        localChatFooter.EZh.setVisibility(8);
      }
      localChatFooter.gmY.setVisibility(8);
      if (localChatFooter.rxj != null) {
        localChatFooter.rxj.setVisibility(8);
      }
      if (localChatFooter.Fak != null) {
        localChatFooter.Fak.setVisibility(8);
      }
      if (localChatFooter.rxk != null) {
        localChatFooter.rxk.setVisibility(8);
      }
      if (localChatFooter.rxh != null) {
        localChatFooter.rxh.setVisibility(8);
      }
      if (localChatFooter.EUc != null)
      {
        localChatFooter.EUc.setVisibility(8);
        localChatFooter.EUf = false;
        localChatFooter.EUc.destroy();
      }
      if (localChatFooter.EZw != null) {
        localChatFooter.EZw.setVisibility(8);
      }
      if (localChatFooter.BoF != null) {
        localChatFooter.BoF.setVisibility(8);
      }
      if (localChatFooter.BoC != null) {
        localChatFooter.BoC.update();
      }
      if (localChatFooter.EYV != null) {
        localChatFooter.EYV.setVisibility(8);
      }
      if (localChatFooter.EYZ != null)
      {
        localChatFooter.EYZ.setVisibility(4);
        if (localChatFooter.pWJ != null) {
          localChatFooter.pWJ.setVisibility(4);
        }
      }
      localChatFooter.EYU = ((AppPanel)localChatFooter.findViewById(2131297977));
      if (localChatFooter.EYU != null)
      {
        localChatFooter.setAppPanelVisible(8);
        localObject = localChatFooter.EYU;
        if (((AppPanel)localObject).yuQ != null) {
          ((AppPanel)localObject).yuQ.setToScreen(0);
        }
        ((AppPanel)localObject).EXD = 0;
      }
      localChatFooter.a(ChatFooter.h.Fdc);
      localChatFooter.g(0, false, -1);
      localChatFooter.EZu = false;
      localChatFooter = this.vHt;
      if (!bt.ai(localChatFooter.vBp.getText())) {
        localChatFooter.vBp.setText("");
      }
      localChatFooter.wb(false);
      localChatFooter.fdk();
      this.vHt.fdl();
      this.vHt.EZr.FcS = null;
    }
    AppMethodBeat.o(35315);
  }
  
  private void fDJ()
  {
    AppMethodBeat.i(35319);
    ad.i("MicroMsg.ChattingUI.FootComponent", "[goneFooter] %s", new Object[] { bt.flS() });
    if (this.vHt != null)
    {
      this.vHt.g(0, false, -1);
      this.vHt.setVisibility(8);
    }
    if (this.JIU != null) {
      this.JIU.setVisibility(8);
    }
    this.vHt.wb(false);
    this.cWM.hideVKB();
    AppMethodBeat.o(35319);
  }
  
  private void fDN()
  {
    AppMethodBeat.i(184963);
    if (this.vHt == null)
    {
      ad.e("MicroMsg.ChattingUI.FootComponent", "initTodoView footer == null");
      AppMethodBeat.o(184963);
      return;
    }
    ad.i("MicroMsg.ChattingUI.FootComponent", "initTodoView()");
    ((com.tencent.mm.ui.chatting.d.b.w)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.w.class)).a(this.vHt.getIOnToDoBarCallback());
    this.vHt.setIOnTodoViewCallback(new z.c()
    {
      public final int dbF()
      {
        AppMethodBeat.i(185866);
        int i = ((com.tencent.mm.ui.chatting.d.b.w)v.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.w.class)).dbF();
        AppMethodBeat.o(185866);
        return i;
      }
      
      public final void xT(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(185864);
        ((com.tencent.mm.ui.chatting.d.b.w)v.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.w.class)).xT(paramAnonymousBoolean);
        AppMethodBeat.o(185864);
      }
      
      public final void xU(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(185865);
        ((com.tencent.mm.ui.chatting.d.b.w)v.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.w.class)).xU(paramAnonymousBoolean);
        AppMethodBeat.o(185865);
      }
    });
    AppMethodBeat.o(184963);
  }
  
  private static void fDO()
  {
    AppMethodBeat.i(163317);
    aWf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qEk, ""));
    aWf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qEl, ""));
    aWf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qEm, ""));
    aWf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qEn, ""));
    aWf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qEo, ""));
    aWf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qEp, ""));
    aWf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qEq, ""));
    aWf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qEr, ""));
    aWf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qEs, ""));
    aWf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qEt, ""));
    AppMethodBeat.o(163317);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(35327);
    if (paramObject != null) {
      paramObject.equals("");
    }
    ad.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", new Object[] { paramObject, this.cWM.getTalkerUserName() });
    if (paramObject.equals(this.cWM.getTalkerUserName()))
    {
      aWe(this.cWM.getTalkerUserName());
      fDM();
    }
    AppMethodBeat.o(35327);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(35328);
    if (paramString != null) {
      paramString.equals("");
    }
    ad.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", new Object[] { paramString, this.cWM.getTalkerUserName() });
    if (com.tencent.mm.model.w.zl(this.cWM.getTalkerUserName()))
    {
      aWe(this.cWM.getTalkerUserName());
      fDM();
    }
    AppMethodBeat.o(35328);
  }
  
  public final boolean aH(bu parambu)
  {
    AppMethodBeat.i(35323);
    if (this.vHt != null) {
      this.vHt.aH(parambu);
    }
    AppMethodBeat.o(35323);
    return true;
  }
  
  public final boolean al(am paramam)
  {
    AppMethodBeat.i(35322);
    boolean bool1 = ((com.tencent.mm.ui.chatting.d.b.ai)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.ai.class)).fEN();
    boolean bool2 = ((com.tencent.mm.ui.chatting.d.b.ai)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.ai.class)).fEM();
    boolean bool3 = ((com.tencent.mm.ui.chatting.d.b.l)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.l.class)).fDs();
    boolean bool4 = ((com.tencent.mm.ui.chatting.d.b.q)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.q.class)).fDB();
    boolean bool5 = ((af)this.cWM.bh(af.class)).fEz();
    if (this.JJe)
    {
      AppMethodBeat.o(35322);
      return true;
    }
    if ((bool1) || (bool2) || (bool3) || (bool4) || (bool5))
    {
      ad.i("MicroMsg.ChattingUI.FootComponent", bool1 + ", " + bool2 + ", " + bool3 + ", " + bool4 + ", " + bool5);
      fDJ();
      AppMethodBeat.o(35322);
      return false;
    }
    if ((paramam != null) && (com.tencent.mm.model.w.zA(paramam.field_username)))
    {
      this.JIY = new com.tencent.mm.ui.chatting.h(this.JIU);
      this.JIY.fyJ();
      fDH();
      AppMethodBeat.o(35322);
      return true;
    }
    com.tencent.mm.ui.chatting.d.b.d locald;
    Object localObject1;
    int i;
    if ((paramam != null) && (paramam.fqg()))
    {
      locald = (com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class);
      if (locald.fCE() != null)
      {
        localObject1 = locald.fCE().bX(false);
        if (localObject1 != null)
        {
          if (((c.b)localObject1).cQv != null) {
            ((c.b)localObject1).cQx = "1".equals(((c.b)localObject1).cQv.optString("IsHideInputToolbarInMsg"));
          }
          if (((c.b)localObject1).cQx)
          {
            ad.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + paramam.field_username + " is hide tool bar");
            fDJ();
            AppMethodBeat.o(35322);
            return false;
          }
        }
        if ((!bt.isNullOrNil(paramam.field_username)) && (localObject1 != null))
        {
          i = this.cWM.JOR.getIntExtra("key_temp_session_show_type", 0);
          switch (((c.b)localObject1).KF())
          {
          default: 
            fDI();
            paramam = paramam.field_username;
            if (localObject1 == null) {
              break;
            }
          }
        }
      }
    }
    for (bool1 = true;; bool1 = false)
    {
      ad.e("MicroMsg.ChattingUI.FootComponent", "bizinfo name=%s, %b, %d", new Object[] { paramam, Boolean.valueOf(bool1), Integer.valueOf(((c.b)localObject1).KF()) });
      for (;;)
      {
        AppMethodBeat.o(35322);
        return true;
        ad.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + paramam.field_username + " is show custom menu");
        if (this.JIU == null)
        {
          l.a(this.cWM.JOR, 2131302671);
          this.JIU = ((ChatFooterCustom)this.cWM.findViewById(2131302673));
          if (this.JIU != null) {
            this.JIU.C((ViewGroup)this.cWM.findViewById(2131298070));
          }
        }
        localObject1 = ((c.b)localObject1).KM();
        try
        {
          Iterator localIterator = ((c.b.c)localObject1).cRg.iterator();
          while (localIterator.hasNext())
          {
            Object localObject2 = (com.tencent.mm.am.k)localIterator.next();
            if (!bt.isNullOrNil(((com.tencent.mm.am.k)localObject2).dNL)) {
              ((com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).a(((com.tencent.mm.am.k)localObject2).dNL, -1, "", bt.bI(((com.tencent.mm.am.k)localObject2).name, ""), "", "", 4);
            }
            if (!bt.isNullOrNil(((com.tencent.mm.am.k)localObject2).value)) {
              ((com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).a(((com.tencent.mm.am.k)localObject2).value, -1, "", bt.bI(((com.tencent.mm.am.k)localObject2).name, ""), "", "", 4);
            }
            localObject2 = ((com.tencent.mm.am.k)localObject2).hQl.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              com.tencent.mm.am.k localk = (com.tencent.mm.am.k)((Iterator)localObject2).next();
              if (!bt.isNullOrNil(localk.dNL)) {
                ((com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).a(localk.dNL, -1, "", bt.bI(localk.name, ""), "", "", 4);
              }
              if (!bt.isNullOrNil(localk.value)) {
                ((com.tencent.mm.plugin.brandservice.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).a(localk.value, -1, "", bt.bI(localk.name, ""), "", "", 4);
              }
            }
          }
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.ChattingUI.FootComponent", localException, "preauth when chat foot", new Object[0]);
          if ((localObject1 != null) && (((c.b.c)localObject1).type == 1))
          {
            this.vHt.setSwitchButtonMode(1);
            this.vHt.setOnFooterSwitchListener(((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCL());
            fDI();
          }
          else
          {
            this.vHt.setSwitchButtonMode(0);
            try
            {
              if (!com.tencent.mm.model.w.zv(paramam.field_username)) {
                break label1060;
              }
              this.JIX = new com.tencent.mm.ui.chatting.w(this.JIU);
              this.JIX.fyJ();
              fDH();
            }
            catch (Exception paramam)
            {
              if (localObject1 == null) {
                break label1040;
              }
            }
            if ((((c.b.c)localObject1).cRg == null) || (((c.b.c)localObject1).cRg.size() == 0)) {
              label1040:
              fDI();
            }
          }
        }
      }
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.ChattingUI.FootComponent", paramam, "", new Object[0]);
        break;
        label1060:
        ChatFooterCustom localChatFooterCustom = this.JIU;
        if ((localChatFooterCustom.JyS != null) && (localChatFooterCustom.JyR != null))
        {
          localChatFooterCustom.JyS.setVisibility(0);
          localChatFooterCustom.JyR.setVisibility(0);
        }
        if (localChatFooterCustom.JyT != null) {
          localChatFooterCustom.JyT.fBg();
        }
        this.JIU.setTalker(this.cWM.BYG);
        this.JIU.a(this.cWM.JOR, locald.fCE(), paramam.field_username);
        this.JIU.setOnFooterSwitchListener(this.EZo);
        this.JIU.setOnProcessClickListener(((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCK());
        this.vHt.setOnFooterSwitchListener(this.EZo);
        if ((((ac)this.cWM.bh(ac.class)).fEy()) && (i == 1))
        {
          fDI();
          break;
        }
        fDH();
        break;
        this.EZo.wg(true);
      }
    }
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35332);
    super.fCC();
    if (this.vHt != null)
    {
      this.vHt.setFooterEventListener(null);
      com.tencent.mm.ui.chatting.p.ebV();
      this.JIT = null;
      this.vHt.setSmileyPanelCallback(null);
      this.vHt.setSmileyPanelCallback2(null);
    }
    if (this.JIU != null)
    {
      this.JIU.fBa();
      this.JIU = null;
    }
    fDE();
    if (this.JIU != null) {
      this.JIU.fBd();
    }
    com.tencent.mm.pluginsdk.ui.span.k.clearCache();
    if (this.vHt != null) {
      this.vHt.fdP();
    }
    if ((this.cWM.JOR.isCurrentActivity) && (this.vHt != null)) {
      this.vHt.destroy();
    }
    com.tencent.mm.kernel.g.ajD();
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().b(this);
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().remove(this);
    AppMethodBeat.o(35332);
  }
  
  public final ChatFooter fDC()
  {
    return this.vHt;
  }
  
  public final ChatFooterCustom fDD()
  {
    return this.JIU;
  }
  
  public final String fDF()
  {
    return this.JJa;
  }
  
  public final void fDG()
  {
    AppMethodBeat.i(35316);
    try
    {
      if (this.vHt.fdK()) {
        this.vHt.setBottomPanelVisibility(8);
      }
      AppMethodBeat.o(35316);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(35316);
    }
  }
  
  public final void fDH()
  {
    AppMethodBeat.i(35317);
    this.cWM.hideVKB();
    ad.i("MicroMsg.ChattingUI.FootComponent", "visibleCustomFooter customFooter is %s", new Object[] { this.JIU });
    if (this.JIU == null)
    {
      AppMethodBeat.o(35317);
      return;
    }
    this.JIU.setVisibility(0);
    if (this.vHt != null)
    {
      this.vHt.g(0, false, -1);
      this.vHt.setVisibility(8);
    }
    AppMethodBeat.o(35317);
  }
  
  public final void fDI()
  {
    AppMethodBeat.i(35318);
    if (this.vHt == null)
    {
      AppMethodBeat.o(35318);
      return;
    }
    this.vHt.setVisibility(0);
    if (this.JIU != null) {
      this.JIU.setVisibility(8);
    }
    AppMethodBeat.o(35318);
  }
  
  public final void fDK()
  {
    AppMethodBeat.i(35320);
    this.JIZ = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.JIZ.setInterpolator(new DecelerateInterpolator(1.5F));
    this.JIZ.addAnimation(localTranslateAnimation);
    this.JIZ.addAnimation(localAlphaAnimation);
    this.JIZ.setDuration(300L);
    this.JIZ.setFillBefore(true);
    if (this.vHt != null) {
      this.vHt.startAnimation(this.JIZ);
    }
    AppMethodBeat.o(35320);
  }
  
  public final void fDL()
  {
    AppMethodBeat.i(35321);
    ad.i("MicroMsg.ChattingUI.FootComponent", "triggerFooter, originChatFooterVisibility:%s", new Object[] { Integer.valueOf(this.JJb) });
    if (this.vHt == null)
    {
      this.vHt = ((ChatFooter)this.cWM.findViewById(2131302672));
      this.vHt.a(new ChatFooter.b()
      {
        public final com.tencent.mm.ui.chatting.i.b feo()
        {
          return v.this.cWM.JOO;
        }
        
        public final com.tencent.mm.ui.chatting.e.a fep()
        {
          return v.this.cWM;
        }
        
        public final String getTalkerUserName()
        {
          AppMethodBeat.i(35306);
          String str = v.this.cWM.getTalkerUserName();
          AppMethodBeat.o(35306);
          return str;
        }
      });
      ((r)this.cWM.bh(r.class)).bA(this.vHt);
      fDN();
    }
    boolean bool1 = ((com.tencent.mm.ui.chatting.d.b.l)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.l.class)).fDs();
    boolean bool2 = ((af)this.cWM.bh(af.class)).fEz();
    if ((bool1) || (bool2) || (com.tencent.mm.ui.widget.snackbar.b.bni()))
    {
      if (!this.JJd) {
        this.JJb = this.vHt.getVisibility();
      }
      this.vHt.g(0, true, -1);
      if (this.JIU != null) {
        if (this.JJd) {}
      }
      for (this.JJc = this.JIU.getVisibility();; this.JJc = -1)
      {
        fDJ();
        this.JJd = true;
        AppMethodBeat.o(35321);
        return;
      }
    }
    this.JJd = false;
    if ((this.JJb == 8) && (this.JJc == 8))
    {
      fDJ();
      AppMethodBeat.o(35321);
      return;
    }
    if (this.JJb == 0)
    {
      fDI();
      AppMethodBeat.o(35321);
      return;
    }
    fDH();
    AppMethodBeat.o(35321);
  }
  
  public final void fDM()
  {
    AppMethodBeat.i(35324);
    String str = this.cWM.getTalkerUserName();
    int i;
    if ((com.tencent.mm.model.w.zJ(str)) || (am.aSN(str))) {
      i = 1;
    }
    while (i == 2)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.cWM.JOR.getContext(), "android.permission.RECORD_AUDIO", 80, "", "");
      ad.i("MicroMsg.ChattingUI.FootComponent", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), this.cWM.JOR.getContext() });
      if (bool) {
        break;
      }
      this.vHt.ba(1, false);
      AppMethodBeat.o(35324);
      return;
      if (com.tencent.mm.model.w.Aa(str))
      {
        i = 2;
      }
      else
      {
        int j = this.cWM.JOR.getIntExtra("Chat_Mode", 0);
        ad.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", new Object[] { Integer.valueOf(this.JIV), Integer.valueOf(j) });
        if (this.JIV != 0) {
          j = this.JIV;
        }
        str = com.tencent.mm.n.g.acA().getValue("DefaultMsgType");
        i = j;
        if (this.JIV == 0)
        {
          i = j;
          if (str != null)
          {
            ad.d("MicroMsg.ChattingUI.FootComponent", "config def chatmode is %s", new Object[] { str });
            i = bt.getInt(com.tencent.mm.n.g.acA().getValue("DefaultMsgType"), 0);
          }
        }
        j = i;
        if (i == 0)
        {
          j = i;
          if (com.tencent.mm.o.b.lM(this.cWM.BYG.field_type))
          {
            com.tencent.mm.model.ba.aBQ();
            j = ((Integer)com.tencent.mm.model.c.ajl().get(18, Integer.valueOf(0))).intValue();
          }
        }
        i = j;
        if (j == 0) {
          i = 1;
        }
        ad.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", new Object[] { Integer.valueOf(this.JIV), Integer.valueOf(i) });
      }
    }
    this.vHt.ba(i, false);
    AppMethodBeat.o(35324);
  }
  
  public final void fws()
  {
    AppMethodBeat.i(194019);
    this.JJe = this.cWM.JOR.getBooleanExtra("show_footer", false).booleanValue();
    AppMethodBeat.o(194019);
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(35333);
    this.JJf = false;
    this.JJg = false;
    this.JJh = 0L;
    com.tencent.mm.model.ba.aBQ();
    Object localObject1 = com.tencent.mm.model.c.azv().aTz(this.cWM.getTalkerUserName());
    if (localObject1 != null) {
      this.JIV = ((com.tencent.mm.g.c.ba)localObject1).field_chatmode;
    }
    ad.d("MicroMsg.ChattingUI.FootComponent", "dkcm init old:%d   ", new Object[] { Integer.valueOf(this.JIV) });
    localObject1 = this.cWM.getTalkerUserName();
    if (this.vHt == null)
    {
      this.vHt = ((ChatFooter)this.cWM.findViewById(2131302672));
      this.vHt.a(new ChatFooter.b()
      {
        public final com.tencent.mm.ui.chatting.i.b feo()
        {
          return v.this.cWM.JOO;
        }
        
        public final com.tencent.mm.ui.chatting.e.a fep()
        {
          return v.this.cWM;
        }
        
        public final String getTalkerUserName()
        {
          AppMethodBeat.i(35307);
          String str = v.this.cWM.getTalkerUserName();
          AppMethodBeat.o(35307);
          return str;
        }
      });
      ((r)this.cWM.bh(r.class)).bA(this.vHt);
      fDN();
    }
    this.vHt.setCattingRootLayoutId(2131298066);
    ad.i("MicroMsg.ChattingUI.FootComponent", "resetFooter customFooter is %s", new Object[] { this.JIU });
    if (this.JIU != null)
    {
      this.JIU.fBa();
      this.JIU.setOnFooterSwitchListener(null);
      this.JIU.setOnProcessClickListener(null);
      this.vHt.setOnFooterSwitchListener(null);
      this.JIU.fBd();
    }
    fDJ();
    this.vHt.fdv();
    boolean bool1 = ((com.tencent.mm.ui.chatting.d.b.ai)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.ai.class)).fEN();
    boolean bool2 = ((com.tencent.mm.ui.chatting.d.b.ai)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.ai.class)).fEM();
    boolean bool3 = ((af)this.cWM.bh(af.class)).fEz();
    int i;
    if ((!this.JJe) && ((bool1) || (bool2) || (bool3)))
    {
      fDJ();
      fDE();
      this.JIT = new com.tencent.mm.ui.chatting.p(this.cWM, this.vHt, this.cWM.getTalkerUserName());
      this.JIT.JAU = this.cWM.JOR.getBooleanExtra("key_need_send_video", true).booleanValue();
      this.vHt.setFooterEventListener(this.JIT);
      localObject1 = new com.tencent.mm.ui.chatting.v(this.cWM, this.cWM.BYG, this.cWM.getTalkerUserName());
      this.vHt.setSmileyPanelCallback((com.tencent.mm.pluginsdk.ui.chat.f)localObject1);
      this.vHt.setSmileyPanelCallback2((com.tencent.mm.pluginsdk.ui.chat.j)localObject1);
      fDM();
      this.vHt.fdn();
      i = this.cWM.JOR.getIntExtra("key_temp_session_show_type", 0);
      localObject1 = (ac)this.cWM.bh(ac.class);
      ad.i("MicroMsg.ChattingUI.FootComponent", "isTempSession : %s, showType : %d.", new Object[] { Boolean.valueOf(((ac)localObject1).fEy()), Integer.valueOf(i) });
      ad.d("MicroMsg.ChattingUI.FootComponent", "is temp session : %s.", new Object[] { Boolean.valueOf(((ac)localObject1).fEy()) });
      if (((ac)localObject1).fEy())
      {
        if (i != 1) {
          break label1622;
        }
        this.EZo.wg(true);
      }
    }
    for (;;)
    {
      al(this.cWM.BYG);
      com.tencent.mm.kernel.g.ajD();
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().a(this);
      ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().add(this);
      AppMethodBeat.o(35333);
      return;
      if (com.tencent.mm.model.w.zH((String)localObject1))
      {
        fDJ();
        l.a(this.cWM.JOR, 2131302671);
        if (this.JIU == null)
        {
          i = 1;
          this.JIU = ((ChatFooterCustom)this.cWM.findViewById(2131302673));
          if (i != 0) {
            this.JIU.C((ViewGroup)this.cWM.findViewById(2131298070));
          }
          this.JIW = new t(this.JIU);
          localObject1 = this.JIW;
          if (com.tencent.mm.sdk.platformtools.j.cSc != 1) {
            break label903;
          }
          i = 1;
          label720:
          ((t)localObject1).JBS.findViewById(2131298098).setVisibility(8);
          ((t)localObject1).pPh = ((LinearLayout)((t)localObject1).JBS.findViewById(2131298093));
          ((t)localObject1).JBS.findViewById(2131298092).setVisibility(8);
          localObject2 = ((t)localObject1).pPh;
          if (i == 0) {
            break label908;
          }
        }
        label903:
        label908:
        for (float f = 1.0F;; f = 2.0F)
        {
          ((LinearLayout)localObject2).setWeightSum(f);
          ((t)localObject1).JBT = ((FrameLayout)((t)localObject1).pPh.getChildAt(0));
          ((t)localObject1).JBT.setVisibility(0);
          ((t)localObject1).JBT.setOnClickListener(((t)localObject1).JCb);
          ((TextView)((t)localObject1).JBT.findViewById(2131298095)).setText(2131757079);
          ((t)localObject1).JBT.findViewById(2131298094).setVisibility(8);
          if (i == 0) {
            break label913;
          }
          i = 1;
          while (i < 6)
          {
            ((t)localObject1).pPh.getChildAt(i).setVisibility(8);
            i += 1;
          }
          i = 0;
          break;
          i = 0;
          break label720;
        }
        label913:
        ((t)localObject1).JBU = ((FrameLayout)((t)localObject1).pPh.getChildAt(1));
        ((t)localObject1).JBU.setVisibility(0);
        ((t)localObject1).JBU.setOnClickListener(((t)localObject1).JCc);
        ((t)localObject1).JBV = ((TextView)((t)localObject1).JBU.findViewById(2131298095));
        ((t)localObject1).JBW = ((ImageView)((t)localObject1).JBU.findViewById(2131298094));
        ((t)localObject1).JBW.setVisibility(0);
        ((t)localObject1).fBK();
        com.tencent.mm.model.ba.aBQ();
        ((t)localObject1).uuf = ((Integer)com.tencent.mm.model.c.ajl().get(al.a.Iri, Integer.valueOf(-1))).intValue();
        if (((t)localObject1).uuf >= 0) {
          ((t)localObject1).fBM();
        }
        for (;;)
        {
          i = 2;
          while (i < 6)
          {
            ((t)localObject1).pPh.getChildAt(i).setVisibility(8);
            i += 1;
          }
          ((t)localObject1).JBV.setText(2131757092);
        }
        ((t)localObject1).JCa = com.tencent.mm.n.g.acB().getMailAppEnterUlAndroid();
        if (bt.isNullOrNil(((t)localObject1).JCa)) {
          ((t)localObject1).JCa = "qqmail://folderlist?app=weixin&action=list&uin=$uin$";
        }
        com.tencent.mm.model.ba.aBQ();
        localObject2 = new com.tencent.mm.b.p(bt.n((Integer)com.tencent.mm.model.c.ajl().get(9, null))).toString();
        ((t)localObject1).JCa = ((t)localObject1).JCa.replace("$uin$", (CharSequence)localObject2);
        ((t)localObject1).xhr = com.tencent.mm.n.g.acB().act();
        ((t)localObject1).JBY = true;
        fDH();
        break;
      }
      this.JIW = null;
      if (com.tencent.mm.model.w.zv((String)localObject1))
      {
        fDJ();
        l.a(this.cWM.JOR, 2131302671);
        if (this.JIU == null) {}
        for (i = 1;; i = 0)
        {
          this.JIU = ((ChatFooterCustom)this.cWM.findViewById(2131302673));
          if (i != 0) {
            this.JIU.C((ViewGroup)this.cWM.findViewById(2131298070));
          }
          this.JIX = new com.tencent.mm.ui.chatting.w(this.JIU);
          this.JIX.fyJ();
          fDH();
          break;
        }
      }
      this.JIX = null;
      if (com.tencent.mm.model.w.zA((String)localObject1))
      {
        fDJ();
        l.a(this.cWM.JOR, 2131302671);
        if (this.JIU == null) {}
        for (i = 1;; i = 0)
        {
          this.JIU = ((ChatFooterCustom)this.cWM.findViewById(2131302673));
          if (i != 0) {
            this.JIU.C((ViewGroup)this.cWM.findViewById(2131298070));
          }
          this.JIY = new com.tencent.mm.ui.chatting.h(this.JIU);
          this.JIY.fyJ();
          fDH();
          break;
        }
      }
      this.JIY = null;
      if ((!com.tencent.mm.model.w.zI((String)localObject1)) && (!com.tencent.mm.model.w.zv((String)localObject1)) && (!com.tencent.mm.model.w.zH((String)localObject1)) && (!com.tencent.mm.model.w.zA((String)localObject1)))
      {
        com.tencent.mm.model.w.aBj();
        if ((!com.tencent.mm.model.w.Ai((String)localObject1)) && (!com.tencent.mm.model.w.zy((String)localObject1)) && (!com.tencent.mm.model.w.An((String)localObject1))) {}
      }
      else
      {
        fDJ();
        break;
      }
      fDI();
      al(this.cWM.BYG);
      this.vHt.setUserName((String)localObject1);
      this.vHt.lx(this.cWM.fFr(), this.cWM.getTalkerUserName());
      aWe((String)localObject1);
      localObject1 = (com.tencent.mm.ui.chatting.d.b.l)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.l.class);
      Object localObject2 = (com.tencent.mm.ui.chatting.d.b.ai)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.ai.class);
      if (!((com.tencent.mm.ui.chatting.d.b.l)localObject1).fDs()) {
        break;
      }
      if (((com.tencent.mm.ui.chatting.d.b.ai)localObject2).fEK())
      {
        ((com.tencent.mm.ui.chatting.d.b.ai)localObject2).fEJ();
        ((com.tencent.mm.ui.chatting.d.b.l)localObject1).fDt();
        break;
      }
      ((com.tencent.mm.ui.chatting.d.b.l)localObject1).fDq();
      break;
      label1622:
      this.EZo.wg(false);
    }
  }
  
  public final void fwu() {}
  
  public final void fwv()
  {
    AppMethodBeat.i(35334);
    this.JJa = this.cWM.JOR.getStringExtra("smiley_product_id");
    if (this.vHt.uCj) {
      ((com.tencent.mm.ui.chatting.d.b.ak)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.ak.class)).keepSignalling();
    }
    if ((com.tencent.mm.model.w.zH(this.cWM.getTalkerUserName())) && (this.JIW != null) && (this.JIW.JBY)) {
      this.JIW.fBL();
    }
    ChatFooter localChatFooter = this.vHt;
    BaseChattingUIFragment localBaseChattingUIFragment = this.cWM.JOR;
    localChatFooter.Faf = localBaseChattingUIFragment;
    localChatFooter.a(localBaseChattingUIFragment.getContext(), localBaseChattingUIFragment.thisActivity());
    if ((localChatFooter.FaG != null) && (localChatFooter.FaG.isShowing())) {
      localChatFooter.FaG.dismiss();
    }
    if ((!bt.isNullOrNil(this.JJa)) && (this.vHt != null))
    {
      ad.d("MicroMsg.ChattingUI.FootComponent", "deal use smiley panel in product: %s", new Object[] { this.JJa });
      this.vHt.setDefaultSmileyByDetail(this.JJa);
      this.vHt.fdq();
    }
    this.cWM.JOR.getContext().getIntent().putExtra("smiley_product_id", "");
    this.vHt.setUserName(this.cWM.getTalkerUserName());
    com.tencent.mm.live.d.e.gYi = this.cWM.getTalkerUserName();
    this.vHt.lx(this.cWM.fFr(), this.cWM.getTalkerUserName());
    if (this.cWM.JOR.getBooleanExtra("key_show_bottom_app_panel", false).booleanValue())
    {
      localChatFooter = this.vHt;
      if (localChatFooter.EZb != null)
      {
        localChatFooter.EZb.performClick();
        ad.d("MicroMsg.ChatFooter", "perform click attach bt to show bottom panel");
      }
    }
    if (al(this.cWM.BYG))
    {
      if (this.vHt != null)
      {
        com.tencent.mm.model.ba.aBQ();
        bool1 = ((Boolean)com.tencent.mm.model.c.ajl().get(66832, Boolean.FALSE)).booleanValue();
        ad.d("MicroMsg.ChattingUI.FootComponent", "jacks refresh Footer Plugin Setting , Enable Enter Button: %B", new Object[] { Boolean.valueOf(bool1) });
        this.vHt.fdT();
        if (bool1)
        {
          this.vHt.fdG();
          this.vHt.fdn();
        }
        if (bool1) {
          this.vHt.fdw();
        }
        localChatFooter = this.vHt;
        if (localChatFooter.EYU != null) {
          localChatFooter.EYU.fcO();
        }
      }
      ((an)this.cWM.bh(an.class)).fDx();
      if (this.vHt != null)
      {
        this.vHt.EYU.refresh();
        this.vHt.addTextChangedListener(new a((byte)0));
        ad.i("MicroMsg.ChattingUI.FootComponent", "addTextChangedListener");
      }
    }
    boolean bool1 = ((com.tencent.mm.ui.chatting.d.b.ai)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.ai.class)).fEN();
    boolean bool2 = ((com.tencent.mm.ui.chatting.d.b.ai)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.ai.class)).fEM();
    boolean bool3 = ((com.tencent.mm.ui.chatting.d.b.l)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.l.class)).fDs();
    boolean bool4 = com.tencent.mm.model.w.zy(this.cWM.getTalkerUserName());
    boolean bool5 = ((af)this.cWM.bh(af.class)).fEz();
    if (((!bool1) && (!bool2) && (!bool3)) || ((this.JJe) && (this.cWM.BYG != null) && (!this.cWM.BYG.fqg()) && (!com.tencent.mm.model.w.Ak(this.cWM.getTalkerUserName())) && (!com.tencent.mm.ui.widget.snackbar.b.bni()) && (!com.tencent.mm.model.w.zA(this.cWM.getTalkerUserName())) && (!bool4) && (!bool5)))
    {
      ad.i("MicroMsg.ChattingUI.FootComponent", "call visibleFooter again.");
      fDI();
    }
    for (;;)
    {
      this.fLE.alive();
      this.fLD.alive();
      AppMethodBeat.o(35334);
      return;
      ad.i("MicroMsg.ChattingUI.FootComponent", "no call visibleFooter again.");
    }
  }
  
  public final void fww()
  {
    AppMethodBeat.i(35335);
    Object localObject;
    if (this.vHt != null)
    {
      localObject = this.vHt;
      if (((ChatFooter)localObject).FbF != null)
      {
        ((ChatFooter)localObject).vBp.removeTextChangedListener(((ChatFooter)localObject).FbF);
        ((ChatFooter)localObject).FbF = null;
      }
      ad.i("MicroMsg.ChattingUI.FootComponent", "removeTextChangeListener");
      this.vHt.onPause();
      this.fLE.dead();
      this.fLD.dead();
      if (!com.tencent.mm.kernel.g.ajx())
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
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.ajl().set(18, Integer.valueOf(this.vHt.getMode()));
    ad.d("MicroMsg.ChattingUI.FootComponent", "dkcm old:%d footer:%d ", new Object[] { Integer.valueOf(this.JIV), Integer.valueOf(this.vHt.getMode()) });
    if (this.JIV != this.vHt.getMode())
    {
      this.JIV = this.vHt.getMode();
      com.tencent.mm.model.ba.aBQ();
      localObject = com.tencent.mm.model.c.azv().aTz(this.cWM.getTalkerUserName());
      if ((localObject != null) && (this.cWM.getTalkerUserName().equals(((com.tencent.mm.g.c.ba)localObject).field_username)))
      {
        ((at)localObject).kq(this.JIV);
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azv().a((at)localObject, this.cWM.getTalkerUserName());
      }
    }
    this.vHt.a(ChatFooter.h.Fde);
    AppMethodBeat.o(35335);
  }
  
  public final void fwx() {}
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35329);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((1111 == paramInt1) && (-1 == paramInt2)) {
      this.vHt.fdq();
    }
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 200) || (paramInt1 == 201) || (paramInt1 == 203)) {
        this.vHt.clearFocus();
      }
      AppMethodBeat.o(35329);
      return;
    }
    if ((paramInt1 != 217) && (this.JIU != null)) {
      this.JIU.p(paramInt1, paramIntent);
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
      if (this.vHt != null) {
        this.vHt.setMode(paramInt1);
      }
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int j = 0;
    AppMethodBeat.i(35331);
    ad.i("MicroMsg.ChattingUI.FootComponent", "chatting onKeyDown, code:%d action:%d", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    if (paramKeyEvent.getKeyCode() == 4) {
      if (!this.cWM.cBJ) {
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
        if ((this.cWM.JOR.isSupportNavigationSwipeBack()) && (this.cWM.JOR.getSwipeBackLayout().fdJ()))
        {
          ad.w("MicroMsg.ChattingUI.FootComponent", "ashutest::onKeyDown back ScrollToFinishing");
          i = 1;
        }
        else
        {
          if (paramKeyEvent.getAction() == 0)
          {
            this.JJf = true;
            this.JJh = System.currentTimeMillis();
          }
          if (paramKeyEvent.getAction() != 1) {
            break label356;
          }
          ad.d("MicroMsg.ChattingUI.FootComponent", "hasBack %B, %d", new Object[] { Boolean.valueOf(this.JJf), Long.valueOf(System.currentTimeMillis() - this.JJh) });
          if ((this.JJf) && (System.currentTimeMillis() - this.JJh <= 30000L)) {
            break;
          }
          i = 1;
        }
      }
      this.JJg = true;
      Object localObject = (com.tencent.mm.ui.chatting.d.b.l)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.l.class);
      com.tencent.mm.ui.chatting.d.b.ai localai = (com.tencent.mm.ui.chatting.d.b.ai)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.ai.class);
      if (((com.tencent.mm.ui.chatting.d.b.l)localObject).fDs()) {
        if (localai.fEK())
        {
          localai.fEJ();
          ((com.tencent.mm.ui.chatting.d.b.l)localObject).fDt();
          label291:
          i = 1;
          label293:
          if (i == 0) {
            if (this.vHt != null)
            {
              localObject = this.vHt;
              if ((((ChatFooter)localObject).EZI == 0) && (!((ChatFooter)localObject).EUf)) {
                break label387;
              }
              if (!((ChatFooter)localObject).EUf) {
                break label376;
              }
              ((ChatFooter)localObject).fce();
              label339:
              i = 1;
            }
          }
        }
      }
      for (;;)
      {
        if (i == 0) {
          this.cWM.JOR.fAX();
        }
        label356:
        i = 1;
        break;
        ((com.tencent.mm.ui.chatting.d.b.l)localObject).fDq();
        break label291;
        i = 0;
        break label293;
        label376:
        ((ChatFooter)localObject).g(0, true, -1);
        break label339;
        label387:
        i = j;
        if (((ChatFooter)localObject).FaZ != null)
        {
          i = j;
          if (((ChatFooter)localObject).FaZ.getVisibility() == 0)
          {
            ((ChatFooter)localObject).FaZ.ery();
            i = 1;
          }
        }
      }
      if ((paramKeyEvent.getKeyCode() == 67) && (!this.cWM.cBJ)) {
        ad.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown back key fragment not foreground");
      } else if (!this.cWM.cBJ) {
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
        ad.w("MicroMsg.ChattingUI.FootComponent", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, bt.flS() });
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
        ad.i("MicroMsg.ChattingUI.FootComponent", "summerper doFooterLiveRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.JIT, bt.flS() });
        if (this.JIT != null) {
          this.JIT.vId.dlw();
        }
        AppMethodBeat.o(35330);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131761860;; paramInt = 2131761871)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(paramInt), this.cWM.JOR.getMMResources().getString(2131761885), this.cWM.JOR.getMMResources().getString(2131760598), this.cWM.JOR.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35311);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = v.this.cWM.JOR;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/component/FootComponent$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
        ad.i("MicroMsg.ChattingUI.FootComponent", "summerper doFooterSightRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.JIT, bt.flS() });
        if (this.JIT != null)
        {
          paramArrayOfString = this.JIT;
          if (!this.vHt.EYU.EXF.EYu.value) {
            break label446;
          }
        }
        label446:
        for (paramInt = i;; paramInt = 2)
        {
          paramArrayOfString.acQ(paramInt);
          AppMethodBeat.o(35330);
          return;
        }
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131761860;; paramInt = 2131761871)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(paramInt), this.cWM.JOR.getMMResources().getString(2131761885), this.cWM.JOR.getMMResources().getString(2131760598), this.cWM.JOR.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35302);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = v.this.cWM.JOR;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/component/FootComponent$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
          ad.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuVideoSelected,footerEventImpl[%s], stack[%s]", new Object[] { this.JIT, bt.flS() });
          if (this.JIT != null) {
            this.JIT.dAY();
          }
          AppMethodBeat.o(35330);
          return;
        }
        if (paramInt == 21)
        {
          ad.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.JIT, bt.flS() });
          if (this.JIT != null) {
            this.JIT.fBD();
          }
          AppMethodBeat.o(35330);
          return;
        }
        ad.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnEnterMultiTalk,footerEventImpl[%s], stack[%s]", new Object[] { this.JIT, bt.flS() });
        if (this.JIT != null) {
          this.JIT.fBB();
        }
        AppMethodBeat.o(35330);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131761860;; paramInt = 2131761871)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(paramInt), this.cWM.JOR.getMMResources().getString(2131761885), this.cWM.JOR.getMMResources().getString(2131760598), this.cWM.JOR.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(163307);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = v.this.cWM.JOR;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/component/FootComponent$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
        ad.i("MicroMsg.ChattingUI.FootComponent", "summerper doImageSelectTakePhotoRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.JIT, bt.flS() });
        if (this.JIT != null) {
          this.JIT.fBF();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131761860), this.cWM.JOR.getMMResources().getString(2131761885), this.cWM.JOR.getMMResources().getString(2131760598), this.cWM.JOR.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(169867);
          paramAnonymousDialogInterface = v.this.cWM.JOR;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/component/FootComponent$15", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$15", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(169867);
        }
      }, null);
      AppMethodBeat.o(35330);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ad.i("MicroMsg.ChattingUI.FootComponent", "summerper doTalkRoomRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.JIT, bt.flS() });
        if (this.JIT != null) {
          this.JIT.fBE();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131761869), this.cWM.JOR.getMMResources().getString(2131761885), this.cWM.JOR.getMMResources().getString(2131760598), this.cWM.JOR.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(184958);
          paramAnonymousDialogInterface = v.this.cWM.JOR;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/component/FootComponent$16", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
          ad.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuAudioSelected,footerEventImpl[%s], stack[%s]", new Object[] { this.JIT, bt.flS() });
          if (this.JIT != null) {
            this.JIT.dAX();
          }
          AppMethodBeat.o(35330);
          return;
        }
        ad.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipAudioRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.JIT, bt.flS() });
        if (this.JIT != null) {
          this.JIT.fBC();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131761871), this.cWM.JOR.getMMResources().getString(2131761885), this.cWM.JOR.getMMResources().getString(2131760598), this.cWM.JOR.getMMResources().getString(2131756766), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(194017);
          paramAnonymousDialogInterface = v.this.cWM.JOR;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/component/FootComponent$17", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$17", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(194017);
        }
      }, null);
      AppMethodBeat.o(35330);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ad.i("MicroMsg.ChattingUI.FootComponent", "doSendFileRequest, footerEventImpl[%s], stack[%s].", new Object[] { this.JIT, bt.flS() });
        if (this.JIT != null) {
          this.JIT.fBy();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131761878), this.cWM.JOR.getMMResources().getString(2131761885), this.cWM.JOR.getMMResources().getString(2131760598), this.cWM.JOR.getMMResources().getString(2131759760), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(194018);
          paramAnonymousDialogInterface = v.this.cWM.JOR;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/component/FootComponent$18", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$18", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(194018);
        }
      }, null);
    }
  }
  
  public final void setVoiceInputShowCallback(ChatFooter.d paramd)
  {
    AppMethodBeat.i(35326);
    this.vHt.setVoiceInputShowCallback(paramd);
    AppMethodBeat.o(35326);
  }
  
  final class a
    implements TextWatcher
  {
    private boolean JJn = false;
    private List<String> JJo = null;
    
    private a() {}
    
    private static boolean gz(String paramString, int paramInt)
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
      ad.i("MicroMsg.ChattingUI.FootComponent", "[onTextChanged]");
      ((com.tencent.mm.ui.chatting.d.b.ak)v.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.ak.class)).adn(1);
      Object localObject1 = (com.tencent.mm.ui.chatting.d.b.d)v.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class);
      paramCharSequence = String.valueOf(paramCharSequence);
      Object localObject2 = paramCharSequence.substring(paramInt1, paramInt1 + paramInt3);
      Object localObject3;
      Object localObject4;
      if ((v.this.cWM.fFu()) && ("@".equals(localObject2)) && (!paramCharSequence.equals(v.this.vHt.getLastContent())) && (!v.this.vHt.EZs))
      {
        v.this.vHt.setLastContent(paramCharSequence);
        v.this.vHt.setInsertPos(paramInt1 + 1);
        if (gz(paramCharSequence, paramInt1))
        {
          localObject3 = bt.m(com.tencent.mm.model.q.yQ(v.this.cWM.getTalkerUserName()), ",");
          localObject4 = new Intent();
          ((Intent)localObject4).setClass(v.this.cWM.JOR.getContext(), AtSomeoneUI.class);
          ((Intent)localObject4).putExtra("Block_list", u.aAm());
          ((Intent)localObject4).putExtra("Chatroom_member_list", (String)localObject3);
          ((Intent)localObject4).putExtra("Chat_User", v.this.cWM.getTalkerUserName());
          ((Intent)localObject4).putExtra("Add_address_titile", v.this.cWM.JOR.getMMString(2131762574));
          v.this.cWM.JOR.startActivityForResult((Intent)localObject4, 212);
        }
        ((aj)v.this.cWM.bh(aj.class)).F(paramCharSequence, paramInt1, (String)localObject2);
        if ((!((com.tencent.mm.ui.chatting.d.b.d)localObject1).fCH()) && (!am.ail(v.this.cWM.getTalkerUserName())) && (!am.aSV(v.this.cWM.getTalkerUserName())))
        {
          localObject2 = v.this.vHt;
          if ((((ChatFooter)localObject2).EZl != null) && (((ChatFooter)localObject2).gmY != null))
          {
            ((ChatFooter)localObject2).EZl.Fec = true;
            localObject1 = ((ChatFooter)localObject2).EZl;
            localObject2 = ((ChatFooter)localObject2).Fag.getTalkerUserName();
            if (!bt.isNullOrNil(paramCharSequence)) {
              break label785;
            }
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).mHandler.removeMessages(20003);
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).mHandler.sendEmptyMessage(20001);
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).uCF = paramCharSequence;
            if (((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Feg != null)
            {
              ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Feg.dead();
              ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Feg = null;
            }
          }
        }
      }
      for (;;)
      {
        if ((com.tencent.mm.model.w.vF(v.this.cWM.getTalkerUserName())) && (!v.this.vHt.fdR())) {
          v.this.vHt.aMY(paramCharSequence);
        }
        AppMethodBeat.o(35313);
        return;
        if ((((com.tencent.mm.ui.chatting.d.b.d)localObject1).fCI()) && ("@".equals(localObject2)) && (!paramCharSequence.equals(v.this.vHt.getLastContent())) && (!v.this.vHt.EZs))
        {
          v.this.vHt.setLastContent(paramCharSequence);
          v.this.vHt.setInsertPos(paramInt1 + 1);
          if (!gz(paramCharSequence, paramInt1)) {
            break;
          }
          localObject3 = ((com.tencent.mm.ui.chatting.d.b.d)localObject1).fCF().field_userList;
          localObject4 = new Intent();
          ((Intent)localObject4).setClass(v.this.cWM.JOR.getContext(), BizChatAtSomeoneUI.class);
          ((Intent)localObject4).putExtra("Block_list", ag.aGd().eL(v.this.cWM.getTalkerUserName()));
          ((Intent)localObject4).putExtra("Chatroom_member_list", (String)localObject3);
          ((Intent)localObject4).putExtra("Chat_User", v.this.cWM.getTalkerUserName());
          ((Intent)localObject4).putExtra("Add_address_titile", v.this.cWM.JOR.getMMString(2131762574));
          ((Intent)localObject4).putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.d.b.d)v.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCU());
          v.this.cWM.JOR.startActivityForResult((Intent)localObject4, 212);
          break;
        }
        if (paramCharSequence.equals(v.this.vHt.getLastContent())) {
          break;
        }
        v.this.vHt.setLastContent(paramCharSequence);
        break;
        label785:
        if (!paramCharSequence.equals(((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).uCF))
        {
          ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).hide();
          if (((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Feg != null)
          {
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Feg.dead();
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Feg = null;
          }
          ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Feg = new com.tencent.mm.vending.e.c();
          localObject3 = String.valueOf(bt.flT());
          localObject4 = ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Feh;
          ((gi)localObject4).dSb = ((gi)localObject4).t("SessionId", (String)localObject3, true);
          localObject4 = ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Feh;
          ((gi)localObject4).enR = ((gi)localObject4).t("ChatId", (String)localObject2, true);
          ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Fee.clear();
          ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Fei = 0;
          localObject4 = new com.tencent.mm.emoji.a.b.b(((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Feg);
          d.g.b.p.h(localObject3, "sessionId");
          com.tencent.mm.emoji.a.b.f localf = ((com.tencent.mm.emoji.a.b.b)localObject4).glZ;
          d.g.b.p.h(localObject3, "sessionId");
          localf.username = ((String)localObject2);
          localf.sessionId = ((String)localObject3);
          localObject2 = new m.5((com.tencent.mm.pluginsdk.ui.chat.m)localObject1, bt.flT());
          d.g.b.p.h(paramCharSequence, "desc");
          localObject3 = com.tencent.mm.emoji.a.b.d.gml;
          com.tencent.mm.emoji.a.b.d.ma(0);
          com.tencent.mm.ad.c.b("EmojiSuggest_searchSuggest", (d.g.a.a)new b.b((com.tencent.mm.emoji.a.b.b)localObject4, paramCharSequence, (j.b)localObject2));
        }
        ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).uCF = paramCharSequence;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.v
 * JD-Core Version:    0.7.0.1
 */