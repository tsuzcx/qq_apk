package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.d.b.c;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.e;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooterBottom;
import com.tencent.mm.pluginsdk.ui.chat.a.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.w;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.List;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.c.a.a(dJy=com.tencent.mm.ui.chatting.c.b.o.class)
public class q
  extends a
  implements k.a, n.b, com.tencent.mm.ui.chatting.c.b.o
{
  protected ChatFooter oBw;
  private final ChatFooter.e vWj;
  private com.tencent.mm.ui.chatting.p zFK;
  protected ChatFooterCustom zFL;
  private int zFM;
  private com.tencent.mm.ui.chatting.t zFN;
  private w zFO;
  private com.tencent.mm.ui.chatting.h zFP;
  private AnimationSet zFQ;
  private String zFR;
  private int zFS;
  private int zFT;
  private boolean zFU;
  private boolean zFV;
  public boolean zFW;
  private long zFX;
  
  public q()
  {
    AppMethodBeat.i(31419);
    this.zFM = 0;
    this.zFR = null;
    this.zFU = false;
    this.vWj = new q.1(this);
    this.zFV = false;
    this.zFW = false;
    this.zFX = 0L;
    AppMethodBeat.o(31419);
  }
  
  private void atU(String paramString)
  {
    boolean bool3 = false;
    AppMethodBeat.i(31429);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "initFooterPanelMenu %s", new Object[] { paramString });
    this.oBw.don();
    this.oBw.doe();
    int i;
    Object localObject;
    int j;
    label776:
    label801:
    label813:
    boolean bool1;
    if (((com.tencent.mm.ui.chatting.c.b.i)this.caz.ay(com.tencent.mm.ui.chatting.c.b.i.class)).dHW())
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ChattingUI.FootComponent", "match shake, in show mode, do not open short video recode view");
      i = 0;
      if (i == 0) {
        this.oBw.dop();
      }
      if (((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHv())
      {
        localObject = com.tencent.mm.aj.f.rS(this.caz.getTalkerUserName());
        if ((localObject != null) && (((com.tencent.mm.aj.d)localObject).field_enterpriseFather != null)) {
          break label1782;
        }
        j = 0;
        if (j != 0)
        {
          localObject = this.oBw.vVV;
          ((AppPanel)localObject).vUY.vVP.value = true;
          ((AppPanel)localObject).dnT();
        }
      }
      if (!this.caz.dJG()) {
        this.oBw.dov();
      }
      if ((this.caz.txj != null) && (!com.tencent.mm.n.a.je(this.caz.txj.field_type)) && (!com.tencent.mm.model.t.lA(this.caz.getTalkerUserName()))) {
        this.oBw.dos();
      }
      if (ad.nM(paramString))
      {
        this.oBw.vVV.dnN();
        this.oBw.vVV.dnP();
        this.oBw.vVV.dnQ();
        this.oBw.doq();
        this.oBw.dor();
        this.oBw.vVV.dnO();
        this.oBw.ad(true, true);
        this.oBw.dos();
        this.oBw.dot();
        this.oBw.vVV.dnS();
      }
      if (ad.are(paramString))
      {
        this.oBw.vVV.dnN();
        this.oBw.vVV.dnP();
        this.oBw.vVV.dnQ();
        this.oBw.doq();
        this.oBw.dor();
        this.oBw.vVV.dnO();
        this.oBw.ad(true, true);
        this.oBw.dos();
        this.oBw.dot();
        this.oBw.vVV.dnS();
      }
      if (ad.arc(paramString))
      {
        this.oBw.vVV.dnN();
        this.oBw.vVV.dnP();
        this.oBw.vVV.dnQ();
        this.oBw.doq();
        this.oBw.dom();
        this.oBw.dor();
        this.oBw.vVV.dnO();
        this.oBw.ad(true, true);
        this.oBw.dos();
        this.oBw.dot();
        this.oBw.vVV.dnS();
      }
      if (com.tencent.mm.model.t.oj(paramString))
      {
        this.oBw.vVV.dnN();
        this.oBw.vVV.dnP();
        this.oBw.vVV.dnQ();
        this.oBw.dor();
        this.oBw.vVV.dnO();
        this.oBw.ad(true, true);
        this.oBw.dos();
        this.oBw.dot();
        this.oBw.vVV.dnS();
      }
      if (com.tencent.mm.model.t.og(paramString))
      {
        this.oBw.vVV.dnN();
        this.oBw.ad(true, true);
        this.oBw.vVV.dnO();
        this.oBw.vVV.dnS();
      }
      aw.aaz();
      paramString = com.tencent.mm.model.c.YA().arw(paramString);
      if ((paramString != null) && (paramString.dwz()))
      {
        if (!((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHv()) {
          break label1836;
        }
        this.oBw.vVV.dnN();
        this.oBw.vVV.dnQ();
        this.oBw.vVV.dnO();
        this.oBw.ad(true, true);
        this.oBw.dos();
        this.oBw.dot();
        this.oBw.dop();
        this.oBw.vVV.dnR();
        this.oBw.doo();
        this.oBw.dou();
        this.oBw.Az();
      }
      if (!this.caz.dJF()) {
        break label1880;
      }
      if (com.tencent.mm.m.g.Nq().getInt("MultitalkBlockCaller", 0) != 0) {
        break label1875;
      }
      i = 1;
      if (i == 0) {
        break label1880;
      }
      this.oBw.pj(false);
      if ((this.caz.dJG()) || (this.caz.dJE()))
      {
        this.oBw.ad(true, true);
        this.oBw.dot();
      }
      com.tencent.mm.bq.d.dpU();
      if (this.caz.dJE()) {
        this.oBw.vVV.dnO();
      }
      if (this.caz.getTalkerUserName().equals(r.Zn()))
      {
        this.oBw.vVV.dnO();
        this.oBw.ad(true, true);
        this.oBw.dos();
        this.oBw.dot();
      }
      this.oBw.setAppPanelTip(null);
      if ((ad.arf(this.caz.txj.field_username)) || (com.tencent.mm.model.t.nK(this.caz.txj.field_username)))
      {
        com.tencent.mm.kernel.g.RM();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.caz.txj.field_username);
        ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).bc(((aq)localObject).field_openImAppid, ((aq)localObject).field_descWordingId);
        i = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).wk(((aq)localObject).field_openImAppid);
        paramString = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).c(this.caz.txj.field_openImAppid, "openim_function_tip", b.a.gfD);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "openim showFlag:%d username: %s appid: %s tip %s", new Object[] { Integer.valueOf(i), this.caz.txj.field_username, ((aq)localObject).field_openImAppid, paramString });
        if ((i & 0x1) == 0) {
          this.oBw.dom();
        }
        if ((i & 0x2) == 0) {
          this.oBw.doo();
        }
        if ((i & 0x4) == 0)
        {
          localObject = this.oBw.vVV;
          ((AppPanel)localObject).vUY.vVw.value = false;
          ((AppPanel)localObject).dnT();
        }
        if ((i & 0x8) == 0) {
          this.oBw.doq();
        }
        if ((i & 0x10) == 0) {
          this.oBw.vVV.dnP();
        }
        if ((i & 0x20) == 0) {
          this.oBw.vVV.dnN();
        }
        if ((i & 0x40) == 0) {
          this.oBw.vVV.dnS();
        }
        if ((i & 0x80) == 0) {
          this.oBw.dor();
        }
        if (((i & 0x100) == 0) || ((i & 0x2000) == 0))
        {
          localObject = this.oBw;
          if ((i & 0x100) != 0) {
            break label1891;
          }
          bool1 = true;
          label1287:
          if ((i & 0x2000) != 0) {
            break label1897;
          }
        }
      }
    }
    label1836:
    label1875:
    label1880:
    label1891:
    label1897:
    for (boolean bool2 = true;; bool2 = false)
    {
      ((ChatFooter)localObject).ad(bool1, bool2);
      if ((i & 0x200) == 0)
      {
        this.oBw.dos();
        this.oBw.dot();
      }
      if ((i & 0x400) == 0) {
        this.oBw.vVV.vVj = true;
      }
      if ((com.tencent.mm.model.t.nK(this.caz.txj.field_username)) && ((i & 0x100) == 0)) {
        this.oBw.pj(true);
      }
      this.oBw.setAppPanelTip(paramString);
      paramString = this.oBw;
      com.tencent.mm.bq.d.dpU();
      if (paramString.eys != null) {
        paramString.eys.j(false, false);
      }
      paramString = this.oBw;
      com.tencent.mm.bq.d.dpU();
      bool1 = bool3;
      if (com.tencent.mm.au.b.aic()) {
        bool1 = true;
      }
      paramString.pk(bool1);
      this.oBw.vVV.dnO();
      if (ad.na(this.caz.getTalkerUserName()))
      {
        this.oBw.doe();
        this.oBw.dom();
        this.oBw.vVV.dnQ();
        this.oBw.dov();
        this.oBw.dor();
        this.oBw.doo();
        this.oBw.doq();
        this.oBw.vVV.dnN();
        this.oBw.dop();
        this.oBw.dor();
        this.oBw.doo();
        this.oBw.dou();
        this.oBw.Az();
        this.oBw.vVV.dnR();
        this.oBw.ad(true, true);
        this.oBw.pj(true);
        this.oBw.pk(true);
        this.oBw.dos();
        this.oBw.dot();
        this.oBw.vVV.dnO();
        this.oBw.vVV.dnN();
        this.oBw.vVV.dnP();
        this.oBw.vVV.dnS();
      }
      AppMethodBeat.o(31429);
      return;
      bool1 = ((com.tencent.mm.ui.chatting.c.b.z)this.caz.ay(com.tencent.mm.ui.chatting.c.b.z.class)).dJc();
      bool2 = ((com.tencent.mm.ui.chatting.c.b.z)this.caz.ay(com.tencent.mm.ui.chatting.c.b.z.class)).dJb();
      if ((bool1) || (bool2))
      {
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ChattingUI.FootComponent", "match shake, in search mode, do not open short video recode view");
        i = 0;
        break;
      }
      if ((ad.are(this.caz.getTalkerUserName())) || (ad.nM(this.caz.getTalkerUserName())))
      {
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ChattingUI.FootComponent", "match shake, but is Qcontact or Bcontact");
        i = 0;
        break;
      }
      if (com.tencent.mm.model.t.oD(this.caz.getTalkerUserName()))
      {
        i = 0;
        break;
      }
      i = 1;
      break;
      label1782:
      localObject = com.tencent.mm.aj.z.afi().rL(((com.tencent.mm.aj.d)localObject).field_enterpriseFather);
      if ((localObject != null) && (((Cursor)localObject).getCount() > 0)) {}
      for (i = 1;; i = 0)
      {
        j = i;
        if (localObject == null) {
          break;
        }
        ((Cursor)localObject).close();
        j = i;
        break;
      }
      this.oBw.vVV.dnN();
      this.oBw.ad(true, true);
      this.oBw.doq();
      this.oBw.vVV.dnO();
      break label776;
      i = 0;
      break label801;
      this.oBw.pj(true);
      break label813;
      bool1 = false;
      break label1287;
    }
  }
  
  private void dIi()
  {
    AppMethodBeat.i(31420);
    if (this.caz.zJz.isCurrentActivity)
    {
      AppMethodBeat.o(31420);
      return;
    }
    this.caz.zJB.dGK();
    if (this.oBw != null)
    {
      ChatFooter localChatFooter = this.oBw;
      Object localObject = localChatFooter.findViewById(2131822473);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localChatFooter.setSwitchButtonMode(0);
      localChatFooter.mHandler.removeMessages(1002);
      if (localChatFooter.vWc != null) {
        localChatFooter.vWc.setVisibility(8);
      }
      if (localChatFooter.vWd != null) {
        localChatFooter.vWd.setVisibility(8);
      }
      if (localChatFooter.vWe != null) {
        localChatFooter.vWe.setVisibility(8);
      }
      if (localChatFooter.vWn != null) {
        localChatFooter.vWn.setVisibility(8);
      }
      localChatFooter.oxn.setVisibility(8);
      if (localChatFooter.mwR != null) {
        localChatFooter.mwR.setVisibility(8);
      }
      if (localChatFooter.vWS != null) {
        localChatFooter.vWS.setVisibility(8);
      }
      if (localChatFooter.mwS != null) {
        localChatFooter.mwS.setVisibility(8);
      }
      if (localChatFooter.mwP != null) {
        localChatFooter.mwP.setVisibility(8);
      }
      if (localChatFooter.vSd != null)
      {
        localChatFooter.vSd.setVisibility(8);
        localChatFooter.vSg = false;
        localChatFooter.vSd.destroy();
      }
      if (localChatFooter.vWn != null) {
        localChatFooter.vWn.setVisibility(8);
      }
      if (localChatFooter.tdt != null) {
        localChatFooter.tdt.setVisibility(8);
      }
      if (localChatFooter.tdq != null) {
        localChatFooter.tdq.update();
      }
      if (localChatFooter.vVW != null) {
        localChatFooter.vVW.setVisibility(8);
      }
      if (localChatFooter.vWa != null)
      {
        localChatFooter.vWa.setVisibility(4);
        if (localChatFooter.eys != null) {
          localChatFooter.eys.setVisibility(4);
        }
      }
      localChatFooter.vVV = ((AppPanel)localChatFooter.findViewById(2131822487));
      if (localChatFooter.vVV != null)
      {
        localChatFooter.setAppPanelVisible(8);
        localObject = localChatFooter.vVV;
        if (((AppPanel)localObject).qBC != null) {
          ((AppPanel)localObject).qBC.setToScreen(0);
        }
      }
      if (localChatFooter.eys != null)
      {
        localChatFooter.eys.destroy();
        localChatFooter.vWa.removeView(localChatFooter.eys);
        localChatFooter.eys.animate().cancel();
        localChatFooter.eys = null;
      }
      localChatFooter.doG();
      localChatFooter.aB(0, false);
      localChatFooter = this.oBw;
      if (!bo.aa(localChatFooter.oxm.getText())) {
        localChatFooter.oxm.setText("");
      }
      localChatFooter.pr(false);
      localChatFooter.dod();
      this.oBw.vWk.vYd = null;
    }
    AppMethodBeat.o(31420);
  }
  
  private void dIn()
  {
    AppMethodBeat.i(31424);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "[goneFooter] %s", new Object[] { bo.dtY() });
    if (this.oBw != null)
    {
      this.oBw.aB(0, false);
      this.oBw.setVisibility(8);
    }
    if (this.zFL != null) {
      this.zFL.setVisibility(8);
    }
    this.oBw.pr(false);
    this.caz.hideVKB();
    AppMethodBeat.o(31424);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(31431);
    if (paramObject != null) {
      paramObject.equals("");
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", new Object[] { paramObject, this.caz.getTalkerUserName() });
    if (paramObject.equals(this.caz.getTalkerUserName()))
    {
      atU(this.caz.getTalkerUserName());
      dIq();
    }
    AppMethodBeat.o(31431);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(31432);
    if (paramString != null) {
      paramString.equals("");
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", new Object[] { paramString, this.caz.getTalkerUserName() });
    if (com.tencent.mm.model.t.nK(this.caz.getTalkerUserName()))
    {
      atU(this.caz.getTalkerUserName());
      dIq();
    }
    AppMethodBeat.o(31432);
  }
  
  public final boolean ad(ad paramad)
  {
    AppMethodBeat.i(31427);
    boolean bool1 = ((com.tencent.mm.ui.chatting.c.b.z)this.caz.ay(com.tencent.mm.ui.chatting.c.b.z.class)).dJc();
    boolean bool2 = ((com.tencent.mm.ui.chatting.c.b.z)this.caz.ay(com.tencent.mm.ui.chatting.c.b.z.class)).dJb();
    boolean bool3 = ((com.tencent.mm.ui.chatting.c.b.i)this.caz.ay(com.tencent.mm.ui.chatting.c.b.i.class)).dHW();
    boolean bool4 = ((com.tencent.mm.ui.chatting.c.b.n)this.caz.ay(com.tencent.mm.ui.chatting.c.b.n.class)).dIf();
    if ((bool1) || (bool2) || (bool3) || (bool4))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", bool1 + ", " + bool2 + ", " + bool3 + ", " + bool4);
      dIn();
      AppMethodBeat.o(31427);
      return false;
    }
    if ((paramad != null) && (com.tencent.mm.model.t.nQ(paramad.field_username)))
    {
      this.zFP = new com.tencent.mm.ui.chatting.h(this.zFL);
      this.zFP.dDW();
      dIl();
      AppMethodBeat.o(31427);
      return true;
    }
    com.tencent.mm.ui.chatting.c.b.d locald;
    Object localObject;
    int i;
    if ((paramad != null) && (paramad.dwz()))
    {
      locald = (com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class);
      if (locald.dHs() != null)
      {
        localObject = locald.dHs().cU(false);
        if (localObject != null)
        {
          if (((d.b)localObject).fvc != null) {
            ((d.b)localObject).fve = "1".equals(((d.b)localObject).fvc.optString("IsHideInputToolbarInMsg"));
          }
          if (((d.b)localObject).fve)
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + paramad.field_username + " is hide tool bar");
            dIn();
            AppMethodBeat.o(31427);
            return false;
          }
        }
        if ((!bo.isNullOrNil(paramad.field_username)) && (localObject != null))
        {
          i = this.caz.zJz.getIntExtra("key_temp_session_show_type", 0);
          switch (((d.b)localObject).aey())
          {
          default: 
            dIm();
            paramad = paramad.field_username;
            if (localObject == null) {
              break;
            }
          }
        }
      }
    }
    for (bool1 = true;; bool1 = false)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ChattingUI.FootComponent", "bizinfo name=%s, %b, %d", new Object[] { paramad, Boolean.valueOf(bool1), Integer.valueOf(((d.b)localObject).aey()) });
      for (;;)
      {
        AppMethodBeat.o(31427);
        return true;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + paramad.field_username + " is show custom menu");
        if (this.zFL == null)
        {
          i.a(this.caz.zJz, 2131822455);
          this.zFL = ((ChatFooterCustom)this.caz.findViewById(2131822497));
          if (this.zFL != null) {
            this.zFL.u((ViewGroup)this.caz.findViewById(2131822440));
          }
        }
        localObject = ((d.b)localObject).aeF();
        if ((localObject != null) && (((d.b.c)localObject).type == 1))
        {
          this.oBw.setSwitchButtonMode(1);
          this.oBw.setOnFooterSwitchListener(((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHz());
          dIm();
        }
        else
        {
          this.oBw.setSwitchButtonMode(0);
          try
          {
            if (!com.tencent.mm.model.t.nP(paramad.field_username)) {
              break label712;
            }
            this.zFO = new w(this.zFL);
            this.zFO.dDW();
            dIl();
          }
          catch (Exception paramad)
          {
            if (localObject == null) {
              break label692;
            }
          }
        }
      }
      if ((((d.b.c)localObject).fvL == null) || (((d.b.c)localObject).fvL.size() == 0)) {
        label692:
        dIm();
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.ChattingUI.FootComponent", paramad, "", new Object[0]);
        break;
        label712:
        ChatFooterCustom localChatFooterCustom = this.zFL;
        if ((localChatFooterCustom.zxc != null) && (localChatFooterCustom.zxb != null))
        {
          localChatFooterCustom.zxc.setVisibility(0);
          localChatFooterCustom.zxb.setVisibility(0);
        }
        if (localChatFooterCustom.zxd != null) {
          localChatFooterCustom.zxd.dGj();
        }
        this.zFL.setTalker(this.caz.txj);
        this.zFL.a(this.caz.zJz, locald.dHs(), paramad.field_username);
        this.zFL.setOnFooterSwitchListener(this.vWj);
        this.zFL.setOnProcessClickListener(((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHy());
        this.oBw.setOnFooterSwitchListener(this.vWj);
        if ((((com.tencent.mm.ui.chatting.c.b.v)this.caz.ay(com.tencent.mm.ui.chatting.c.b.v.class)).dIU()) && (i == 1))
        {
          dIm();
          break;
        }
        dIl();
        break;
        this.vWj.pu(true);
      }
    }
  }
  
  public final void dBZ()
  {
    AppMethodBeat.i(31437);
    this.zFV = false;
    this.zFW = false;
    this.zFX = 0L;
    aw.aaz();
    Object localObject1 = com.tencent.mm.model.c.YF().arH(this.caz.getTalkerUserName());
    if (localObject1 != null) {
      this.zFM = ((au)localObject1).field_chatmode;
    }
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ChattingUI.FootComponent", "dkcm init old:%d   ", new Object[] { Integer.valueOf(this.zFM) });
    localObject1 = this.caz.getTalkerUserName();
    if (this.oBw == null)
    {
      this.oBw = ((ChatFooter)this.caz.findViewById(2131822454));
      this.oBw.vWO = new q.4(this);
    }
    this.oBw.setCattingRootLayoutId(2131821559);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "resetFooter customFooter is %s", new Object[] { this.zFL });
    if (this.zFL != null)
    {
      this.zFL.cvl();
      this.zFL.setOnFooterSwitchListener(null);
      this.zFL.setOnProcessClickListener(null);
      this.oBw.setOnFooterSwitchListener(null);
      this.zFL.dGg();
    }
    dIn();
    this.oBw.don();
    boolean bool1 = ((com.tencent.mm.ui.chatting.c.b.z)this.caz.ay(com.tencent.mm.ui.chatting.c.b.z.class)).dJc();
    boolean bool2 = ((com.tencent.mm.ui.chatting.c.b.z)this.caz.ay(com.tencent.mm.ui.chatting.c.b.z.class)).dJb();
    int i;
    if ((bool1) || (bool2))
    {
      dIn();
      dIi();
      this.zFK = new com.tencent.mm.ui.chatting.p(this.caz, this.oBw, this.caz.getTalkerUserName());
      this.zFK.zyO = this.caz.zJz.getBooleanExtra("key_need_send_video", true).booleanValue();
      this.oBw.setFooterEventListener(this.zFK);
      localObject1 = new com.tencent.mm.ui.chatting.v(this.caz.zJz.getContext(), this.caz.txj, this.caz.getTalkerUserName());
      this.oBw.setSmileyPanelCallback((com.tencent.mm.pluginsdk.ui.chat.f)localObject1);
      this.oBw.setSmileyPanelCallback2((com.tencent.mm.pluginsdk.ui.chat.j)localObject1);
      dIq();
      this.oBw.dog();
      i = this.caz.zJz.getIntExtra("key_temp_session_show_type", 0);
      localObject1 = (com.tencent.mm.ui.chatting.c.b.v)this.caz.ay(com.tencent.mm.ui.chatting.c.b.v.class);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "isTempSession : %s, showType : %d.", new Object[] { Boolean.valueOf(((com.tencent.mm.ui.chatting.c.b.v)localObject1).dIU()), Integer.valueOf(i) });
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ChattingUI.FootComponent", "is temp session : %s.", new Object[] { Boolean.valueOf(((com.tencent.mm.ui.chatting.c.b.v)localObject1).dIU()) });
      if (((com.tencent.mm.ui.chatting.c.b.v)localObject1).dIU())
      {
        if (i != 1) {
          break label1560;
        }
        this.vWj.pu(true);
      }
    }
    for (;;)
    {
      ad(this.caz.txj);
      com.tencent.mm.kernel.g.RM();
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().a(this);
      ((PluginOpenIM)com.tencent.mm.kernel.g.G(PluginOpenIM.class)).getWordingInfoStg().add(this);
      AppMethodBeat.o(31437);
      return;
      if (com.tencent.mm.model.t.nX((String)localObject1))
      {
        dIn();
        i.a(this.caz.zJz, 2131822455);
        if (this.zFL == null)
        {
          i = 1;
          this.zFL = ((ChatFooterCustom)this.caz.findViewById(2131822497));
          if (i != 0) {
            this.zFL.u((ViewGroup)this.caz.findViewById(2131822440));
          }
          this.zFN = new com.tencent.mm.ui.chatting.t(this.zFL);
          localObject1 = this.zFN;
          if (com.tencent.mm.sdk.platformtools.g.bWu != 1) {
            break label865;
          }
          i = 1;
          label668:
          ((com.tencent.mm.ui.chatting.t)localObject1).zzZ.findViewById(2131822498).setVisibility(8);
          ((com.tencent.mm.ui.chatting.t)localObject1).lrN = ((LinearLayout)((com.tencent.mm.ui.chatting.t)localObject1).zzZ.findViewById(2131822500));
          ((com.tencent.mm.ui.chatting.t)localObject1).zzZ.findViewById(2131822501).setVisibility(8);
          localObject2 = ((com.tencent.mm.ui.chatting.t)localObject1).lrN;
          if (i == 0) {
            break label870;
          }
        }
        label865:
        label870:
        for (float f = 1.0F;; f = 2.0F)
        {
          ((LinearLayout)localObject2).setWeightSum(f);
          ((com.tencent.mm.ui.chatting.t)localObject1).zAa = ((FrameLayout)((com.tencent.mm.ui.chatting.t)localObject1).lrN.getChildAt(0));
          ((com.tencent.mm.ui.chatting.t)localObject1).zAa.setVisibility(0);
          ((com.tencent.mm.ui.chatting.t)localObject1).zAa.setOnClickListener(((com.tencent.mm.ui.chatting.t)localObject1).zAj);
          ((TextView)((com.tencent.mm.ui.chatting.t)localObject1).zAa.findViewById(2131822496)).setText(2131298113);
          ((com.tencent.mm.ui.chatting.t)localObject1).zAa.findViewById(2131822495).setVisibility(8);
          ((com.tencent.mm.ui.chatting.t)localObject1).zAa.getChildAt(2).setVisibility(8);
          if (i == 0) {
            break label875;
          }
          i = 1;
          while (i < 6)
          {
            ((com.tencent.mm.ui.chatting.t)localObject1).lrN.getChildAt(i).setVisibility(8);
            i += 1;
          }
          i = 0;
          break;
          i = 0;
          break label668;
        }
        label875:
        ((com.tencent.mm.ui.chatting.t)localObject1).zAb = ((FrameLayout)((com.tencent.mm.ui.chatting.t)localObject1).lrN.getChildAt(1));
        ((com.tencent.mm.ui.chatting.t)localObject1).zAb.setVisibility(0);
        ((com.tencent.mm.ui.chatting.t)localObject1).zAb.setOnClickListener(((com.tencent.mm.ui.chatting.t)localObject1).zAk);
        ((com.tencent.mm.ui.chatting.t)localObject1).zAc = ((TextView)((com.tencent.mm.ui.chatting.t)localObject1).zAb.findViewById(2131822496));
        ((com.tencent.mm.ui.chatting.t)localObject1).zAd = ((ImageView)((com.tencent.mm.ui.chatting.t)localObject1).zAb.findViewById(2131822495));
        ((com.tencent.mm.ui.chatting.t)localObject1).zAd.setVisibility(0);
        ((com.tencent.mm.ui.chatting.t)localObject1).dGC();
        aw.aaz();
        ((com.tencent.mm.ui.chatting.t)localObject1).zAf = ((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yyG, Integer.valueOf(-1))).intValue();
        if (((com.tencent.mm.ui.chatting.t)localObject1).zAf >= 0) {
          ((com.tencent.mm.ui.chatting.t)localObject1).dGE();
        }
        for (;;)
        {
          ((com.tencent.mm.ui.chatting.t)localObject1).zAb.getChildAt(2).setVisibility(8);
          i = 2;
          while (i < 6)
          {
            ((com.tencent.mm.ui.chatting.t)localObject1).lrN.getChildAt(i).setVisibility(8);
            i += 1;
          }
          ((com.tencent.mm.ui.chatting.t)localObject1).zAc.setText(2131298126);
        }
        ((com.tencent.mm.ui.chatting.t)localObject1).zAi = com.tencent.mm.m.g.Nr().getMailAppEnterUlAndroid();
        if (bo.isNullOrNil(((com.tencent.mm.ui.chatting.t)localObject1).zAi)) {
          ((com.tencent.mm.ui.chatting.t)localObject1).zAi = "qqmail://folderlist?app=weixin&action=list&uin=$uin$";
        }
        aw.aaz();
        localObject2 = new com.tencent.mm.a.p(bo.g((Integer)com.tencent.mm.model.c.Ru().get(9, null))).toString();
        ((com.tencent.mm.ui.chatting.t)localObject1).zAi = ((com.tencent.mm.ui.chatting.t)localObject1).zAi.replace("$uin$", (CharSequence)localObject2);
        ((com.tencent.mm.ui.chatting.t)localObject1).pOH = com.tencent.mm.m.g.Nr().Nh();
        ((com.tencent.mm.ui.chatting.t)localObject1).zAg = true;
        dIl();
        break;
      }
      this.zFN = null;
      if (com.tencent.mm.model.t.nP((String)localObject1))
      {
        dIn();
        i.a(this.caz.zJz, 2131822455);
        if (this.zFL == null) {}
        for (i = 1;; i = 0)
        {
          this.zFL = ((ChatFooterCustom)this.caz.findViewById(2131822497));
          if (i != 0) {
            this.zFL.u((ViewGroup)this.caz.findViewById(2131822440));
          }
          this.zFO = new w(this.zFL);
          this.zFO.dDW();
          dIl();
          break;
        }
      }
      this.zFO = null;
      if (com.tencent.mm.model.t.nQ((String)localObject1))
      {
        dIn();
        i.a(this.caz.zJz, 2131822455);
        if (this.zFL == null) {}
        for (i = 1;; i = 0)
        {
          this.zFL = ((ChatFooterCustom)this.caz.findViewById(2131822497));
          if (i != 0) {
            this.zFL.u((ViewGroup)this.caz.findViewById(2131822440));
          }
          this.zFP = new com.tencent.mm.ui.chatting.h(this.zFL);
          this.zFP.dDW();
          dIl();
          break;
        }
      }
      this.zFP = null;
      if ((!com.tencent.mm.model.t.nY((String)localObject1)) && (!com.tencent.mm.model.t.nP((String)localObject1)) && (!com.tencent.mm.model.t.nX((String)localObject1)) && (!com.tencent.mm.model.t.nQ((String)localObject1)))
      {
        com.tencent.mm.model.t.ZY();
        if (!com.tencent.mm.model.t.oy((String)localObject1)) {}
      }
      else
      {
        dIn();
        break;
      }
      dIm();
      ad(this.caz.txj);
      this.oBw.setUserName((String)localObject1);
      atU((String)localObject1);
      localObject1 = (com.tencent.mm.ui.chatting.c.b.i)this.caz.ay(com.tencent.mm.ui.chatting.c.b.i.class);
      Object localObject2 = (com.tencent.mm.ui.chatting.c.b.z)this.caz.ay(com.tencent.mm.ui.chatting.c.b.z.class);
      if (!((com.tencent.mm.ui.chatting.c.b.i)localObject1).dHW()) {
        break;
      }
      if (((com.tencent.mm.ui.chatting.c.b.z)localObject2).dIZ())
      {
        ((com.tencent.mm.ui.chatting.c.b.z)localObject2).dIY();
        ((com.tencent.mm.ui.chatting.c.b.i)localObject1).dHX();
        break;
      }
      ((com.tencent.mm.ui.chatting.c.b.i)localObject1).dHU();
      break;
      label1560:
      this.vWj.pu(false);
    }
  }
  
  public final void dCa() {}
  
  public final void dCb()
  {
    AppMethodBeat.i(31438);
    this.zFR = this.caz.zJz.getStringExtra("smiley_product_id");
    if (this.oBw.vWC) {
      ((com.tencent.mm.ui.chatting.c.b.ab)this.caz.ay(com.tencent.mm.ui.chatting.c.b.ab.class)).keepSignalling();
    }
    if ((com.tencent.mm.model.t.nX(this.caz.getTalkerUserName())) && (this.zFN != null) && (this.zFN.zAg)) {
      this.zFN.dGD();
    }
    ChatFooter localChatFooter = this.oBw;
    Object localObject = this.caz.zJz;
    localChatFooter.vWN = ((MMFragment)localObject);
    localChatFooter.a(((MMFragment)localObject).getContext(), ((MMFragment)localObject).thisActivity());
    if ((localChatFooter.vXo != null) && (localChatFooter.vXo.isShowing())) {
      localChatFooter.vXo.dismiss();
    }
    if ((!bo.isNullOrNil(this.zFR)) && (this.oBw != null))
    {
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ChattingUI.FootComponent", "deal use smiley panel in product: %s", new Object[] { this.zFR });
      this.oBw.setDefaultSmileyByDetail(this.zFR);
      this.oBw.doj();
    }
    this.caz.zJz.getContext().getIntent().putExtra("smiley_product_id", "");
    this.oBw.setUserName(this.caz.getTalkerUserName());
    localChatFooter = this.oBw;
    localObject = this.caz.dJD();
    String str = this.caz.getTalkerUserName();
    localChatFooter.czp = ((String)localObject);
    localChatFooter.toUser = str;
    if (this.caz.zJz.getBooleanExtra("key_show_bottom_app_panel", false).booleanValue())
    {
      localChatFooter = this.oBw;
      if (localChatFooter.vWc != null)
      {
        localChatFooter.vWc.performClick();
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ChatFooter", "perform click attach bt to show bottom panel");
      }
    }
    if (ad(this.caz.txj))
    {
      if (this.oBw != null)
      {
        aw.aaz();
        bool1 = ((Boolean)com.tencent.mm.model.c.Ru().get(66832, Boolean.FALSE)).booleanValue();
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ChattingUI.FootComponent", "jacks refresh Footer Plugin Setting , Enable Enter Button: %B", new Object[] { Boolean.valueOf(bool1) });
        this.oBw.doH();
        if (bool1)
        {
          this.oBw.dow();
          this.oBw.dog();
        }
        if (bool1) {
          this.oBw.doo();
        }
        localChatFooter = this.oBw;
        if (localChatFooter.vVV != null) {
          localChatFooter.vVV.dnM();
        }
      }
      ((com.tencent.mm.ui.chatting.c.b.ae)this.caz.ay(com.tencent.mm.ui.chatting.c.b.ae.class)).dIb();
      if (this.oBw != null)
      {
        this.oBw.vVV.refresh();
        this.oBw.addTextChangedListener(new q.a(this, (byte)0));
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "addTextChangedListener");
      }
    }
    boolean bool1 = ((com.tencent.mm.ui.chatting.c.b.z)this.caz.ay(com.tencent.mm.ui.chatting.c.b.z.class)).dJc();
    boolean bool2 = ((com.tencent.mm.ui.chatting.c.b.z)this.caz.ay(com.tencent.mm.ui.chatting.c.b.z.class)).dJb();
    boolean bool3 = ((com.tencent.mm.ui.chatting.c.b.i)this.caz.ay(com.tencent.mm.ui.chatting.c.b.i.class)).dHW();
    if ((!bool1) && (!bool2) && (!bool3) && (this.caz.txj != null) && (!this.caz.txj.dwz()) && (!com.tencent.mm.model.t.oA(this.caz.getTalkerUserName())) && (!com.tencent.mm.ui.widget.snackbar.b.Pk()) && (!com.tencent.mm.model.t.nQ(this.caz.getTalkerUserName())))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "call visibleFooter again.");
      dIm();
      AppMethodBeat.o(31438);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "no call visibleFooter again.");
    AppMethodBeat.o(31438);
  }
  
  public final void dCc()
  {
    AppMethodBeat.i(31439);
    Object localObject;
    if (this.oBw != null)
    {
      localObject = this.oBw;
      if (((ChatFooter)localObject).vXx != null)
      {
        ((ChatFooter)localObject).oxm.removeTextChangedListener(((ChatFooter)localObject).vXx);
        ((ChatFooter)localObject).vXx = null;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "removeTextChangeListener");
      this.oBw.onPause();
      if (!com.tencent.mm.kernel.g.RG())
      {
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ChattingUI.FootComponent", "account not ready");
        AppMethodBeat.o(31439);
      }
    }
    else
    {
      AppMethodBeat.o(31439);
      return;
    }
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(18, Integer.valueOf(this.oBw.getMode()));
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ChattingUI.FootComponent", "dkcm old:%d footer:%d ", new Object[] { Integer.valueOf(this.zFM), Integer.valueOf(this.oBw.getMode()) });
    if (this.zFM != this.oBw.getMode())
    {
      this.zFM = this.oBw.getMode();
      aw.aaz();
      localObject = com.tencent.mm.model.c.YF().arH(this.caz.getTalkerUserName());
      if ((localObject != null) && (this.caz.getTalkerUserName().equals(((au)localObject).field_username)))
      {
        ((com.tencent.mm.storage.ak)localObject).hK(this.zFM);
        aw.aaz();
        com.tencent.mm.model.c.YF().a((com.tencent.mm.storage.ak)localObject, this.caz.getTalkerUserName());
      }
    }
    this.oBw.bxy();
    AppMethodBeat.o(31439);
  }
  
  public final void dCd() {}
  
  public final void dHq()
  {
    AppMethodBeat.i(31436);
    super.dHq();
    if (this.oBw != null)
    {
      this.oBw.setFooterEventListener(null);
      this.zFK = null;
      this.oBw.setSmileyPanelCallback(null);
      this.oBw.setSmileyPanelCallback2(null);
    }
    if (this.zFL != null)
    {
      this.zFL.cvl();
      this.zFL = null;
    }
    dIi();
    if (this.zFL != null) {
      this.zFL.dGg();
    }
    com.tencent.mm.pluginsdk.ui.d.j.clearCache();
    if (this.oBw != null)
    {
      ChatFooter localChatFooter = this.oBw;
      if (localChatFooter.vWh != null)
      {
        localChatFooter.vWh.vZf = false;
        localChatFooter.vWh.hide();
      }
    }
    if ((this.caz.zJz.isCurrentActivity) && (this.oBw != null)) {
      this.oBw.destroy();
    }
    com.tencent.mm.kernel.g.RM();
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().b(this);
    ((PluginOpenIM)com.tencent.mm.kernel.g.G(PluginOpenIM.class)).getWordingInfoStg().remove(this);
    AppMethodBeat.o(31436);
  }
  
  public final ChatFooter dIg()
  {
    return this.oBw;
  }
  
  public final ChatFooterCustom dIh()
  {
    return this.zFL;
  }
  
  public final String dIj()
  {
    return this.zFR;
  }
  
  public final void dIk()
  {
    AppMethodBeat.i(31421);
    try
    {
      if (this.oBw.doB()) {
        this.oBw.setBottomPanelVisibility(8);
      }
      AppMethodBeat.o(31421);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(31421);
    }
  }
  
  public final void dIl()
  {
    AppMethodBeat.i(31422);
    this.caz.hideVKB();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "visibleCustomFooter customFooter is %s", new Object[] { this.zFL });
    if (this.zFL == null)
    {
      AppMethodBeat.o(31422);
      return;
    }
    this.zFL.setVisibility(0);
    if (this.oBw != null)
    {
      this.oBw.aB(0, false);
      this.oBw.setVisibility(8);
    }
    AppMethodBeat.o(31422);
  }
  
  public final void dIm()
  {
    AppMethodBeat.i(31423);
    if (this.oBw == null)
    {
      AppMethodBeat.o(31423);
      return;
    }
    this.oBw.setVisibility(0);
    if (this.zFL != null) {
      this.zFL.setVisibility(8);
    }
    AppMethodBeat.o(31423);
  }
  
  public final void dIo()
  {
    AppMethodBeat.i(31425);
    this.zFQ = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.zFQ.setInterpolator(new DecelerateInterpolator(1.5F));
    this.zFQ.addAnimation(localTranslateAnimation);
    this.zFQ.addAnimation(localAlphaAnimation);
    this.zFQ.setDuration(300L);
    this.zFQ.setFillBefore(true);
    if (this.oBw != null) {
      this.oBw.startAnimation(this.zFQ);
    }
    AppMethodBeat.o(31425);
  }
  
  public final void dIp()
  {
    AppMethodBeat.i(31426);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "triggerFooter, originChatFooterVisibility:%s", new Object[] { Integer.valueOf(this.zFS) });
    if (this.oBw == null)
    {
      this.oBw = ((ChatFooter)this.caz.findViewById(2131822454));
      this.oBw.vWO = new ChatFooter.b()
      {
        public final String getTalkerUserName()
        {
          AppMethodBeat.i(31409);
          String str = q.this.caz.getTalkerUserName();
          AppMethodBeat.o(31409);
          return str;
        }
      };
    }
    if ((((com.tencent.mm.ui.chatting.c.b.i)this.caz.ay(com.tencent.mm.ui.chatting.c.b.i.class)).dHW()) || (com.tencent.mm.ui.widget.snackbar.b.Pk()))
    {
      if (!this.zFU) {
        this.zFS = this.oBw.getVisibility();
      }
      this.oBw.aB(0, true);
      if (this.zFL != null) {
        if (this.zFU) {}
      }
      for (this.zFT = this.zFL.getVisibility();; this.zFT = -1)
      {
        dIn();
        this.zFU = true;
        AppMethodBeat.o(31426);
        return;
      }
    }
    this.zFU = false;
    if ((this.zFS == 8) && (this.zFT == 8))
    {
      dIn();
      AppMethodBeat.o(31426);
      return;
    }
    if (this.zFS == 0)
    {
      dIm();
      AppMethodBeat.o(31426);
      return;
    }
    dIl();
    AppMethodBeat.o(31426);
  }
  
  public final void dIq()
  {
    AppMethodBeat.i(31428);
    String str = this.caz.getTalkerUserName();
    int i;
    if ((com.tencent.mm.model.t.nZ(str)) || (ad.arc(str))) {
      i = 1;
    }
    while (i == 2)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.caz.zJz.getContext(), "android.permission.RECORD_AUDIO", 80, "", "");
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this.caz.zJz.getContext() });
      if (bool) {
        this.oBw.aA(i, false);
      }
      AppMethodBeat.o(31428);
      return;
      if (com.tencent.mm.model.t.oq(str))
      {
        i = 2;
      }
      else
      {
        int j = this.caz.zJz.getIntExtra("Chat_Mode", 0);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", new Object[] { Integer.valueOf(this.zFM), Integer.valueOf(j) });
        if (this.zFM != 0) {
          j = this.zFM;
        }
        str = com.tencent.mm.m.g.Nq().getValue("DefaultMsgType");
        i = j;
        if (this.zFM == 0)
        {
          i = j;
          if (str != null)
          {
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ChattingUI.FootComponent", "config def chatmode is %s", new Object[] { str });
            i = bo.getInt(com.tencent.mm.m.g.Nq().getValue("DefaultMsgType"), 0);
          }
        }
        j = i;
        if (i == 0)
        {
          j = i;
          if (com.tencent.mm.n.a.je(this.caz.txj.field_type))
          {
            aw.aaz();
            j = ((Integer)com.tencent.mm.model.c.Ru().get(18, Integer.valueOf(0))).intValue();
          }
        }
        i = j;
        if (j == 0) {
          i = 1;
        }
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", new Object[] { Integer.valueOf(this.zFM), Integer.valueOf(i) });
      }
    }
    this.oBw.aA(i, false);
    AppMethodBeat.o(31428);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(31433);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((1111 == paramInt1) && (-1 == paramInt2)) {
      this.oBw.doj();
    }
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 200) || (paramInt1 == 201) || (paramInt1 == 203)) {
        this.oBw.clearFocus();
      }
      AppMethodBeat.o(31433);
      return;
    }
    if ((paramInt1 != 217) && (this.zFL != null)) {
      this.zFL.s(paramInt1, paramIntent);
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31433);
      return;
      if (paramIntent == null)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ChattingUI.FootComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
        AppMethodBeat.o(31433);
        return;
      }
      paramInt1 = paramIntent.getIntExtra("Chat_Mode", 1);
      if (this.oBw != null) {
        this.oBw.setMode(paramInt1);
      }
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int j = 0;
    AppMethodBeat.i(31435);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "chatting onKeyDown, code:%d action:%d", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    if (paramKeyEvent.getKeyCode() == 4) {
      if (!this.caz.bSe) {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown back key fragment not foreground");
      }
    }
    for (;;)
    {
      int i = 0;
      for (;;)
      {
        if (i != 0) {
          break label439;
        }
        boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
        AppMethodBeat.o(31435);
        return bool;
        if ((this.caz.zJz.isSupportNavigationSwipeBack()) && (this.caz.zJz.getSwipeBackLayout().doA()))
        {
          com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ChattingUI.FootComponent", "ashutest::onKeyDown back ScrollToFinishing");
          i = 1;
        }
        else
        {
          if (paramKeyEvent.getAction() == 0)
          {
            this.zFV = true;
            this.zFX = System.currentTimeMillis();
          }
          if (paramKeyEvent.getAction() != 1) {
            break label358;
          }
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ChattingUI.FootComponent", "hasBack %B, %d", new Object[] { Boolean.valueOf(this.zFV), Long.valueOf(System.currentTimeMillis() - this.zFX) });
          if ((this.zFV) && (System.currentTimeMillis() - this.zFX <= 30000L)) {
            break;
          }
          i = 1;
        }
      }
      this.zFW = true;
      Object localObject = (com.tencent.mm.ui.chatting.c.b.i)this.caz.ay(com.tencent.mm.ui.chatting.c.b.i.class);
      com.tencent.mm.ui.chatting.c.b.z localz = (com.tencent.mm.ui.chatting.c.b.z)this.caz.ay(com.tencent.mm.ui.chatting.c.b.z.class);
      if (((com.tencent.mm.ui.chatting.c.b.i)localObject).dHW()) {
        if (localz.dIZ())
        {
          localz.dIY();
          ((com.tencent.mm.ui.chatting.c.b.i)localObject).dHX();
          label290:
          i = 1;
          label292:
          if (i == 0) {
            if (this.oBw != null)
            {
              localObject = this.oBw;
              if (((ChatFooter)localObject).vWw == 0)
              {
                i = j;
                if (!((ChatFooter)localObject).vSg) {}
              }
              else
              {
                if (!((ChatFooter)localObject).vSg) {
                  break label378;
                }
                ((ChatFooter)localObject).dnr();
              }
            }
          }
        }
      }
      for (;;)
      {
        i = 1;
        if (i == 0) {
          this.caz.zJz.dGb();
        }
        label358:
        i = 1;
        break;
        ((com.tencent.mm.ui.chatting.c.b.i)localObject).dHU();
        break label290;
        i = 0;
        break label292;
        label378:
        ((ChatFooter)localObject).aB(0, true);
      }
      if ((paramKeyEvent.getKeyCode() == 67) && (!this.caz.bSe)) {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown back key fragment not foreground");
      } else if (!this.caz.bSe) {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown fragment not foreground");
      }
    }
    label439:
    AppMethodBeat.o(31435);
    return true;
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(31434);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      if (paramArrayOfInt == null) {}
      for (i = -1;; i = paramArrayOfInt.length)
      {
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ChattingUI.FootComponent", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, bo.dtY() });
        AppMethodBeat.o(31434);
        return;
      }
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31434);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "summerper doFooterSightRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.zFK, bo.dtY() });
        if (this.zFK != null)
        {
          paramArrayOfString = this.zFK;
          if (!this.oBw.vVV.vUY.vVM.value) {
            break label244;
          }
        }
        label244:
        for (paramInt = i;; paramInt = 2)
        {
          paramArrayOfString.Pq(paramInt);
          AppMethodBeat.o(31434);
          return;
        }
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131302067;; paramInt = 2131302075)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(paramInt), this.caz.zJz.getMMResources().getString(2131302083), this.caz.zJz.getMMResources().getString(2131300996), this.caz.zJz.getMMResources().getString(2131297837), false, new q.5(this), new q.6(this));
        }
        AppMethodBeat.o(31434);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        if (paramInt == 19)
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuVideoSelected,footerEventImpl[%s], stack[%s]", new Object[] { this.zFK, bo.dtY() });
          if (this.zFK != null) {
            this.zFK.ccw();
          }
          AppMethodBeat.o(31434);
          return;
        }
        if (paramInt == 21)
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.zFK, bo.dtY() });
          if (this.zFK != null) {
            this.zFK.dGx();
          }
          AppMethodBeat.o(31434);
          return;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnEnterMultiTalk,footerEventImpl[%s], stack[%s]", new Object[] { this.zFK, bo.dtY() });
        if (this.zFK != null) {
          this.zFK.dGv();
        }
        AppMethodBeat.o(31434);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131302067;; paramInt = 2131302075)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(paramInt), this.caz.zJz.getMMResources().getString(2131302083), this.caz.zJz.getMMResources().getString(2131300996), this.caz.zJz.getMMResources().getString(2131297837), false, new q.7(this), new q.8(this));
        }
        AppMethodBeat.o(31434);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "summerper doImageSelectTakePhotoRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.zFK, bo.dtY() });
        if (this.zFK != null) {
          this.zFK.dGz();
        }
        AppMethodBeat.o(31434);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131302067), this.caz.zJz.getMMResources().getString(2131302083), this.caz.zJz.getMMResources().getString(2131300996), this.caz.zJz.getMMResources().getString(2131297837), false, new q.9(this), null);
      AppMethodBeat.o(31434);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "summerper doTalkRoomRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.zFK, bo.dtY() });
        if (this.zFK != null) {
          this.zFK.dGy();
        }
        AppMethodBeat.o(31434);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131302073), this.caz.zJz.getMMResources().getString(2131302083), this.caz.zJz.getMMResources().getString(2131300996), this.caz.zJz.getMMResources().getString(2131297837), false, new q.10(this), null);
      AppMethodBeat.o(31434);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        if (paramInt == 82)
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuAudioSelected,footerEventImpl[%s], stack[%s]", new Object[] { this.zFK, bo.dtY() });
          if (this.zFK != null) {
            this.zFK.ccv();
          }
          AppMethodBeat.o(31434);
          return;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipAudioRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.zFK, bo.dtY() });
        if (this.zFK != null) {
          this.zFK.dGw();
        }
        AppMethodBeat.o(31434);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131302075), this.caz.zJz.getMMResources().getString(2131302083), this.caz.zJz.getMMResources().getString(2131300996), this.caz.zJz.getMMResources().getString(2131297837), false, new q.2(this), null);
    }
  }
  
  public final void setVoiceInputShowCallback(ChatFooter.d paramd)
  {
    AppMethodBeat.i(31430);
    this.oBw.setVoiceInputShowCallback(paramd);
    AppMethodBeat.o(31430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.q
 * JD-Core Version:    0.7.0.1
 */