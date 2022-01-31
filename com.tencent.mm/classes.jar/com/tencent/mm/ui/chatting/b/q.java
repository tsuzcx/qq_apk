package com.tencent.mm.ui.chatting.b;

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
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.d.b.c;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.e;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooterBottom;
import com.tencent.mm.pluginsdk.ui.chat.a.a;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.b.b.aa;
import com.tencent.mm.ui.chatting.w;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.List;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.b.a.a(cFA=com.tencent.mm.ui.chatting.b.b.n.class)
public class q
  extends a
  implements j.a, m.b, com.tencent.mm.ui.chatting.b.b.n
{
  protected ChatFooter maV;
  private final ChatFooter.e sfe = new ChatFooter.e()
  {
    private Animation vqs;
    private Animation vqt;
    
    public final boolean me(boolean paramAnonymousBoolean)
    {
      if (this.vqs == null)
      {
        this.vqs = AnimationUtils.loadAnimation(q.this.byx.vtz.getContext(), R.a.push_up_in);
        this.vqt = AnimationUtils.loadAnimation(q.this.byx.vtz.getContext(), R.a.push_down_out);
      }
      if (paramAnonymousBoolean)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "switchFooterToInput customFooter is %s", new Object[] { q.this.vqf });
        if (q.this.vqf != null) {
          q.this.vqf.startAnimation(this.vqt);
        }
        q.this.cEw();
        q.this.maV.startAnimation(this.vqs);
        q.this.maV.postInvalidateDelayed(this.vqs.getDuration());
      }
      do
      {
        return false;
        q.this.byx.XM();
        q.this.maV.startAnimation(this.vqt);
        q.this.cEv();
      } while (q.this.vqf == null);
      q.this.vqf.startAnimation(this.vqs);
      q.this.vqf.postInvalidateDelayed(this.vqs.getDuration());
      return false;
    }
  };
  private com.tencent.mm.ui.chatting.q vqe;
  protected ChatFooterCustom vqf;
  private int vqg = 0;
  private com.tencent.mm.ui.chatting.u vqh;
  private com.tencent.mm.ui.chatting.x vqi;
  private com.tencent.mm.ui.chatting.i vqj;
  private AnimationSet vqk;
  private String vql = null;
  private int vqm;
  private int vqn;
  private boolean vqo = false;
  private boolean vqp = false;
  public boolean vqq = false;
  private long vqr = 0L;
  
  private void adt(String paramString)
  {
    boolean bool3 = true;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "initFooterPanelMenu %s", new Object[] { paramString });
    this.maV.cnk();
    this.maV.cnc();
    int i;
    Object localObject;
    int j;
    label689:
    label714:
    label726:
    boolean bool2;
    if (((com.tencent.mm.ui.chatting.b.b.h)this.byx.ac(com.tencent.mm.ui.chatting.b.b.h.class)).cEh())
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ChattingUI.FootComponent", "match shake, in show mode, do not open short video recode view");
      i = 0;
      if (i == 0) {
        this.maV.cnm();
      }
      if (((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG())
      {
        localObject = com.tencent.mm.ai.f.kX(this.byx.getTalkerUserName());
        if ((localObject != null) && (((com.tencent.mm.ai.d)localObject).field_enterpriseFather != null)) {
          break label1454;
        }
        j = 0;
        if (j != 0)
        {
          localObject = this.maV.seR;
          ((AppPanel)localObject).sdT.seL.value = true;
          ((AppPanel)localObject).cmV();
        }
      }
      if (!this.byx.cFE()) {
        this.maV.cny();
      }
      if ((this.byx.pSb != null) && (!com.tencent.mm.n.a.gR(this.byx.pSb.field_type)) && (!s.fn(this.byx.getTalkerUserName()))) {
        this.maV.cnr();
      }
      if (com.tencent.mm.storage.ad.hd(paramString))
      {
        this.maV.cno();
        this.maV.cnu();
        this.maV.cnv();
        this.maV.cnn();
        this.maV.cnp();
        this.maV.cnt();
        this.maV.T(true, true);
        this.maV.cnr();
        this.maV.cns();
        this.maV.cnz();
      }
      if (com.tencent.mm.storage.ad.aaT(paramString))
      {
        this.maV.cno();
        this.maV.cnu();
        this.maV.cnv();
        this.maV.cnn();
        this.maV.cnp();
        this.maV.cnt();
        this.maV.T(true, true);
        this.maV.cnr();
        this.maV.cns();
        this.maV.cnz();
      }
      if (com.tencent.mm.storage.ad.aaR(paramString))
      {
        this.maV.cno();
        this.maV.cnu();
        this.maV.cnv();
        this.maV.cnn();
        this.maV.cnj();
        this.maV.cnp();
        this.maV.cnt();
        this.maV.T(true, true);
        this.maV.cnr();
        this.maV.cns();
        this.maV.cnz();
      }
      if (s.hA(paramString))
      {
        this.maV.cno();
        this.maV.cnu();
        this.maV.cnv();
        this.maV.cnp();
        this.maV.cnt();
        this.maV.T(true, true);
        this.maV.cnr();
        this.maV.cns();
        this.maV.cnz();
      }
      if (s.hx(paramString))
      {
        this.maV.cno();
        this.maV.T(true, true);
        this.maV.cnt();
        this.maV.cnz();
      }
      au.Hx();
      paramString = com.tencent.mm.model.c.Fw().abl(paramString);
      if ((paramString != null) && (paramString.cua()))
      {
        if (!((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG()) {
          break label1508;
        }
        this.maV.cno();
        this.maV.cnv();
        this.maV.cnt();
        this.maV.T(true, true);
        this.maV.cnr();
        this.maV.cns();
        this.maV.cnm();
        this.maV.cnq();
        this.maV.cnl();
        this.maV.cnx();
        this.maV.sk();
      }
      if (!this.byx.cFD()) {
        break label1546;
      }
      if (com.tencent.mm.m.g.AA().getInt("MultitalkBlockCaller", 0) != 0) {
        break label1541;
      }
      i = 1;
      if (i == 0) {
        break label1546;
      }
      this.maV.mb(false);
      if ((this.byx.cFE()) || (this.byx.cFC()))
      {
        this.maV.T(true, true);
        this.maV.cns();
      }
      com.tencent.mm.br.d.coz();
      if (this.byx.cFC()) {
        this.maV.cnt();
      }
      if (this.byx.getTalkerUserName().equals(com.tencent.mm.model.q.Gj()))
      {
        this.maV.cnt();
        this.maV.T(true, true);
        this.maV.cnr();
        this.maV.cns();
      }
      this.maV.setAppPanelTip(null);
      if ((com.tencent.mm.storage.ad.aaU(this.byx.pSb.field_username)) || (s.hb(this.byx.pSb.field_username)))
      {
        com.tencent.mm.kernel.g.DQ();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.byx.pSb.field_username);
        ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class)).aJ(((ao)localObject).field_openImAppid, ((ao)localObject).field_descWordingId);
        i = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class)).oS(((ao)localObject).field_openImAppid);
        paramString = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class)).c(this.byx.pSb.field_openImAppid, "openim_function_tip", b.a.ePI);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "openim showFlag:%d username: %s appid: %s tip %s", new Object[] { Integer.valueOf(i), this.byx.pSb.field_username, ((ao)localObject).field_openImAppid, paramString });
        if ((i & 0x1) == 0) {
          this.maV.cnj();
        }
        if ((i & 0x2) == 0) {
          this.maV.cnl();
        }
        if ((i & 0x4) == 0)
        {
          localObject = this.maV.seR;
          ((AppPanel)localObject).sdT.ser.value = false;
          ((AppPanel)localObject).cmV();
        }
        if ((i & 0x8) == 0) {
          this.maV.cnn();
        }
        if ((i & 0x10) == 0) {
          this.maV.cnu();
        }
        if ((i & 0x20) == 0) {
          this.maV.cno();
        }
        if ((i & 0x40) == 0) {
          this.maV.cnz();
        }
        if ((i & 0x80) == 0) {
          this.maV.cnp();
        }
        if (((i & 0x100) == 0) || ((i & 0x2000) == 0))
        {
          localObject = this.maV;
          if ((i & 0x100) != 0) {
            break label1557;
          }
          bool1 = true;
          label1185:
          if ((i & 0x2000) != 0) {
            break label1563;
          }
          bool2 = true;
          label1196:
          ((ChatFooter)localObject).T(bool1, bool2);
        }
        if ((i & 0x200) == 0)
        {
          this.maV.cnr();
          this.maV.cns();
        }
        if ((i & 0x400) == 0) {
          this.maV.seR.see = true;
        }
        if ((s.hb(this.byx.pSb.field_username)) && ((i & 0x100) == 0)) {
          this.maV.mb(true);
        }
        this.maV.setAppPanelTip(paramString);
      }
      this.maV.ma(com.tencent.mm.br.d.coz());
      paramString = this.maV;
      com.tencent.mm.br.d.coz();
      if (!com.tencent.mm.at.b.Pb()) {
        break label1569;
      }
    }
    label1541:
    label1546:
    label1557:
    label1563:
    label1569:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      paramString.mc(bool1);
      this.maV.cnt();
      return;
      bool1 = ((com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFk();
      bool2 = ((com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFj();
      if ((bool1) || (bool2))
      {
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ChattingUI.FootComponent", "match shake, in search mode, do not open short video recode view");
        i = 0;
        break;
      }
      if ((com.tencent.mm.storage.ad.aaT(this.byx.getTalkerUserName())) || (com.tencent.mm.storage.ad.hd(this.byx.getTalkerUserName())))
      {
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ChattingUI.FootComponent", "match shake, but is Qcontact or Bcontact");
        i = 0;
        break;
      }
      if (s.hU(this.byx.getTalkerUserName()))
      {
        i = 0;
        break;
      }
      i = 1;
      break;
      label1454:
      localObject = com.tencent.mm.ai.z.My().kR(((com.tencent.mm.ai.d)localObject).field_enterpriseFather);
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
      label1508:
      this.maV.cno();
      this.maV.T(true, true);
      this.maV.cnn();
      this.maV.cnt();
      break label689;
      i = 0;
      break label714;
      this.maV.mb(true);
      break label726;
      bool1 = false;
      break label1185;
      bool2 = false;
      break label1196;
    }
  }
  
  private void cEs()
  {
    if (this.byx.vtz.isCurrentActivity) {}
    do
    {
      return;
      this.byx.vtB.cCY();
    } while (this.maV == null);
    ChatFooter localChatFooter = this.maV;
    Object localObject = localChatFooter.findViewById(R.h.chatting_mode_switcher);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localChatFooter.setSwitchButtonMode(0);
    localChatFooter.mHandler.removeMessages(1002);
    if (localChatFooter.seX != null) {
      localChatFooter.seX.setVisibility(8);
    }
    if (localChatFooter.seY != null) {
      localChatFooter.seY.setVisibility(8);
    }
    if (localChatFooter.seZ != null) {
      localChatFooter.seZ.setVisibility(8);
    }
    if (localChatFooter.kch != null) {
      localChatFooter.kch.setVisibility(8);
    }
    localChatFooter.lXO.setVisibility(8);
    if (localChatFooter.kcj != null) {
      localChatFooter.kcj.setVisibility(8);
    }
    if (localChatFooter.kck != null) {
      localChatFooter.kck.setVisibility(8);
    }
    if (localChatFooter.kci != null) {
      localChatFooter.kci.setVisibility(8);
    }
    if (localChatFooter.saW != null)
    {
      localChatFooter.saW.setVisibility(8);
      localChatFooter.saZ = false;
      localChatFooter.saW.destroy();
      if (localChatFooter.lXN != null) {
        localChatFooter.lXN.setVisibility(0);
      }
    }
    if (localChatFooter.kch != null) {
      localChatFooter.kch.setVisibility(8);
    }
    if (localChatFooter.pBJ != null) {
      localChatFooter.pBJ.setVisibility(8);
    }
    if (localChatFooter.pBG != null) {
      localChatFooter.pBG.update();
    }
    if (localChatFooter.seS != null) {
      localChatFooter.seS.setVisibility(8);
    }
    if (localChatFooter.seV != null) {
      localChatFooter.seV.setVisibility(8);
    }
    localChatFooter.seR = ((AppPanel)localChatFooter.findViewById(R.h.chatting_app_panel));
    if (localChatFooter.seR != null)
    {
      localChatFooter.setAppPanelVisible(8);
      localObject = localChatFooter.seR;
      if (((AppPanel)localObject).nNS != null) {
        ((AppPanel)localObject).nNS.setToScreen(0);
      }
    }
    if (localChatFooter.jpC != null)
    {
      localChatFooter.jpC.destroy();
      localChatFooter.seV.removeView(localChatFooter.jpC);
      localChatFooter.jpC = null;
    }
    localChatFooter.cnH();
    localChatFooter = this.maV;
    localChatFooter.lXN.setText("");
    localChatFooter.lZ(false);
    localChatFooter.cnb();
    this.maV.sff.sgi = null;
  }
  
  private void cEx()
  {
    if (this.maV != null) {
      this.maV.setVisibility(8);
    }
    if (this.vqf != null) {
      this.vqf.setVisibility(8);
    }
    this.maV.lZ(false);
    this.byx.XM();
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    if (paramObject != null) {
      paramObject.equals("");
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", new Object[] { paramObject, this.byx.getTalkerUserName() });
    if (paramObject.equals(this.byx.getTalkerUserName()))
    {
      adt(this.byx.getTalkerUserName());
      cEA();
    }
  }
  
  public final void a(String paramString, l paraml)
  {
    if (paramString != null) {
      paramString.equals("");
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", new Object[] { paramString, this.byx.getTalkerUserName() });
    if (s.hb(this.byx.getTalkerUserName()))
    {
      adt(this.byx.getTalkerUserName());
      cEA();
    }
  }
  
  public final boolean aa(com.tencent.mm.storage.ad paramad)
  {
    boolean bool2 = true;
    boolean bool1 = ((com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFk();
    boolean bool3 = ((com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFj();
    boolean bool4 = ((com.tencent.mm.ui.chatting.b.b.h)this.byx.ac(com.tencent.mm.ui.chatting.b.b.h.class)).cEh();
    boolean bool5 = ((com.tencent.mm.ui.chatting.b.b.m)this.byx.ac(com.tencent.mm.ui.chatting.b.b.m.class)).cEp();
    if ((bool1) || (bool3) || (bool4) || (bool5))
    {
      cEx();
      bool1 = false;
    }
    com.tencent.mm.ui.chatting.b.b.c localc;
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              if ((paramad != null) && (s.hh(paramad.field_username)))
              {
                this.vqj = new com.tencent.mm.ui.chatting.i(this.vqf);
                this.vqj.cAN();
                cEv();
                return true;
              }
              bool1 = bool2;
            } while (paramad == null);
            bool1 = bool2;
          } while (!paramad.cua());
          localc = (com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class);
          bool1 = bool2;
        } while (localc.cDD() == null);
        localObject = localc.cDD().bS(false);
        if (localObject != null)
        {
          if (((d.b)localObject).efa != null) {
            ((d.b)localObject).efc = "1".equals(((d.b)localObject).efa.optString("IsHideInputToolbarInMsg"));
          }
          if (((d.b)localObject).efc)
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + paramad.field_username + " is hide tool bar");
            cEx();
            return false;
          }
        }
        bool1 = bool2;
      } while (bk.bl(paramad.field_username));
      bool1 = bool2;
    } while (localObject == null);
    int i = this.byx.vtz.getIntExtra("key_temp_session_show_type", 0);
    switch (((d.b)localObject).LQ())
    {
    default: 
      cEw();
      paramad = paramad.field_username;
      if (localObject == null) {
        break;
      }
    }
    for (bool1 = true;; bool1 = false)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ChattingUI.FootComponent", "bizinfo name=%s, %b, %d", new Object[] { paramad, Boolean.valueOf(bool1), Integer.valueOf(((d.b)localObject).LQ()) });
      return true;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + paramad.field_username + " is show custom menu");
      if (this.vqf == null)
      {
        i.a(this.byx.vtz, R.h.nav_custom_footer_viewstub);
        this.vqf = ((ChatFooterCustom)this.byx.findViewById(R.h.nav_footer_custom));
        this.vqf.p((ViewGroup)this.byx.findViewById(R.h.chatting_content));
      }
      localObject = ((d.b)localObject).LY();
      if ((localObject != null) && (((d.b.c)localObject).type == 1))
      {
        this.maV.setSwitchButtonMode(1);
        this.maV.setOnFooterSwitchListener(((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDK());
        cEw();
        return true;
      }
      this.maV.setSwitchButtonMode(0);
      try
      {
        if (!s.hg(paramad.field_username)) {
          break label640;
        }
        this.vqi = new com.tencent.mm.ui.chatting.x(this.vqf);
        this.vqi.cAN();
        cEv();
        return true;
      }
      catch (Exception paramad)
      {
        if (localObject == null) {
          break label621;
        }
      }
      if ((((d.b.c)localObject).efJ == null) || (((d.b.c)localObject).efJ.size() == 0)) {
        label621:
        cEw();
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.ChattingUI.FootComponent", paramad, "", new Object[0]);
        return true;
        label640:
        ChatFooterCustom localChatFooterCustom = this.vqf;
        if (localChatFooterCustom.vii != null) {
          localChatFooterCustom.vii.setVisibility(0);
        }
        if (localChatFooterCustom.vij != null) {
          localChatFooterCustom.vij.cCw();
        }
        this.vqf.setTalker(this.byx.pSb);
        this.vqf.a(this.byx.vtz, localc.cDD(), paramad.field_username);
        this.vqf.setOnFooterSwitchListener(this.sfe);
        this.vqf.setOnProcessClickListener(((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDJ());
        this.maV.setOnFooterSwitchListener(this.sfe);
        if ((((com.tencent.mm.ui.chatting.b.b.u)this.byx.ac(com.tencent.mm.ui.chatting.b.b.u.class)).cFc()) && (i == 1))
        {
          cEw();
          return true;
        }
        cEv();
        return true;
        this.sfe.me(true);
      }
    }
  }
  
  public final void cDC()
  {
    super.cDC();
    if (this.maV != null)
    {
      this.maV.setFooterEventListener(null);
      this.vqe = null;
      this.maV.setSmileyPanelCallback(null);
      this.maV.setSmileyPanelCallback2(null);
    }
    if (this.vqf != null)
    {
      this.vqf.bIQ();
      this.vqf = null;
    }
    cEs();
    if (this.vqf != null) {
      this.vqf.cCt();
    }
    com.tencent.mm.pluginsdk.ui.d.j.clearCache();
    if (this.maV != null)
    {
      ChatFooter localChatFooter = this.maV;
      if (localChatFooter.sfc != null)
      {
        localChatFooter.sfc.sgM = false;
        localChatFooter.sfc.hide();
      }
    }
    if ((this.byx.vtz.isCurrentActivity) && (this.maV != null)) {
      this.maV.destroy();
    }
    com.tencent.mm.kernel.g.DQ();
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().b(this);
    ((PluginOpenIM)com.tencent.mm.kernel.g.t(PluginOpenIM.class)).getWordingInfoStg().d(this);
  }
  
  public final void cEA()
  {
    String str = this.byx.getTalkerUserName();
    int i;
    if ((s.hq(str)) || (com.tencent.mm.storage.ad.aaR(str))) {
      i = 1;
    }
    while (i == 2)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this.byx.vtz.getContext(), "android.permission.RECORD_AUDIO", 80, "", "");
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.byx.vtz.getContext() });
      if (bool) {
        this.maV.al(i, false);
      }
      return;
      if (s.hH(str))
      {
        i = 2;
      }
      else
      {
        int j = this.byx.vtz.getIntExtra("Chat_Mode", 0);
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", new Object[] { Integer.valueOf(this.vqg), Integer.valueOf(j) });
        if (this.vqg != 0) {
          j = this.vqg;
        }
        str = com.tencent.mm.m.g.AA().getValue("DefaultMsgType");
        i = j;
        if (this.vqg == 0)
        {
          i = j;
          if (str != null)
          {
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUI.FootComponent", "config def chatmode is %s", new Object[] { str });
            i = bk.getInt(com.tencent.mm.m.g.AA().getValue("DefaultMsgType"), 0);
          }
        }
        j = i;
        if (i == 0)
        {
          j = i;
          if (com.tencent.mm.n.a.gR(this.byx.pSb.field_type))
          {
            au.Hx();
            j = ((Integer)com.tencent.mm.model.c.Dz().get(18, Integer.valueOf(0))).intValue();
          }
        }
        i = j;
        if (j == 0) {
          i = 1;
        }
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", new Object[] { Integer.valueOf(this.vqg), Integer.valueOf(i) });
      }
    }
    this.maV.al(i, false);
  }
  
  public final ChatFooter cEq()
  {
    return this.maV;
  }
  
  public final ChatFooterCustom cEr()
  {
    return this.vqf;
  }
  
  public final String cEt()
  {
    return this.vql;
  }
  
  public final void cEu()
  {
    try
    {
      if (this.maV.cnD()) {
        this.maV.setBottomPanelVisibility(8);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void cEv()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "visibleCustomFooter customFooter is %s", new Object[] { this.vqf });
    if (this.vqf == null) {}
    do
    {
      return;
      this.vqf.setVisibility(0);
    } while (this.maV == null);
    this.maV.setVisibility(8);
  }
  
  public final void cEw()
  {
    if (this.maV == null) {}
    do
    {
      return;
      this.maV.setVisibility(0);
    } while (this.vqf == null);
    this.vqf.setVisibility(8);
  }
  
  public final void cEy()
  {
    this.vqk = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.vqk.setInterpolator(new DecelerateInterpolator(1.5F));
    this.vqk.addAnimation(localTranslateAnimation);
    this.vqk.addAnimation(localAlphaAnimation);
    this.vqk.setDuration(300L);
    this.vqk.setFillBefore(true);
    if (this.maV != null) {
      this.maV.startAnimation(this.vqk);
    }
  }
  
  public final void cEz()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "triggerFooter");
    if (this.maV == null)
    {
      this.maV = ((ChatFooter)this.byx.findViewById(R.h.nav_footer));
      this.maV.sfv = new q.3(this);
    }
    if ((((com.tencent.mm.ui.chatting.b.b.h)this.byx.ac(com.tencent.mm.ui.chatting.b.b.h.class)).cEh()) || (com.tencent.mm.ui.widget.snackbar.b.akH()))
    {
      if (!this.vqo) {
        this.vqm = this.maV.getVisibility();
      }
      this.maV.r(0, -1, false);
      if (this.vqf != null) {
        if (this.vqo) {}
      }
      for (this.vqn = this.vqf.getVisibility();; this.vqn = -1)
      {
        cEx();
        this.vqo = true;
        return;
      }
    }
    this.vqo = false;
    if ((this.vqm == 8) && (this.vqn == 8))
    {
      cEx();
      return;
    }
    if (this.vqm == 0)
    {
      cEw();
      return;
    }
    cEv();
  }
  
  public final void cyN()
  {
    this.vqp = false;
    this.vqq = false;
    this.vqr = 0L;
    au.Hx();
    Object localObject1 = com.tencent.mm.model.c.FB().abv(this.byx.getTalkerUserName());
    if (localObject1 != null) {
      this.vqg = ((as)localObject1).field_chatmode;
    }
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUI.FootComponent", "dkcm init old:%d   ", new Object[] { Integer.valueOf(this.vqg) });
    localObject1 = this.byx.getTalkerUserName();
    if (this.maV == null)
    {
      this.maV = ((ChatFooter)this.byx.findViewById(R.h.nav_footer));
      this.maV.sfv = new q.4(this);
    }
    this.maV.setCattingRootLayoutId(R.h.chatting_bg_ll);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "resetFooter customFooter is %s", new Object[] { this.vqf });
    if (this.vqf != null)
    {
      this.vqf.bIQ();
      this.vqf.setOnFooterSwitchListener(null);
      this.vqf.setOnProcessClickListener(null);
      this.maV.setOnFooterSwitchListener(null);
      this.vqf.cCt();
    }
    cEx();
    this.maV.cnk();
    boolean bool1 = ((com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFk();
    boolean bool2 = ((com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFj();
    int i;
    if ((bool1) || (bool2))
    {
      cEx();
      cEs();
      this.vqe = new com.tencent.mm.ui.chatting.q(this.byx, this.maV, this.byx.getTalkerUserName());
      this.vqe.vjO = this.byx.vtz.getBooleanExtra("key_need_send_video", true).booleanValue();
      this.maV.setFooterEventListener(this.vqe);
      localObject1 = new w(this.byx.vtz.getContext(), this.byx.pSb, this.byx.getTalkerUserName());
      this.maV.setSmileyPanelCallback((com.tencent.mm.pluginsdk.ui.chat.f)localObject1);
      this.maV.setSmileyPanelCallback2((com.tencent.mm.pluginsdk.ui.chat.j)localObject1);
      cEA();
      this.maV.cnw();
      i = this.byx.vtz.getIntExtra("key_temp_session_show_type", 0);
      localObject1 = (com.tencent.mm.ui.chatting.b.b.u)this.byx.ac(com.tencent.mm.ui.chatting.b.b.u.class);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "isTempSession : %s, showType : %d.", new Object[] { Boolean.valueOf(((com.tencent.mm.ui.chatting.b.b.u)localObject1).cFc()), Integer.valueOf(i) });
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUI.FootComponent", "is temp session : %s.", new Object[] { Boolean.valueOf(((com.tencent.mm.ui.chatting.b.b.u)localObject1).cFc()) });
      if (((com.tencent.mm.ui.chatting.b.b.u)localObject1).cFc())
      {
        if (i != 1) {
          break label1568;
        }
        this.sfe.me(true);
      }
    }
    for (;;)
    {
      aa(this.byx.pSb);
      com.tencent.mm.kernel.g.DQ();
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().a(this);
      ((PluginOpenIM)com.tencent.mm.kernel.g.t(PluginOpenIM.class)).getWordingInfoStg().c(this);
      return;
      if (s.ho((String)localObject1))
      {
        cEx();
        i.a(this.byx.vtz, R.h.nav_custom_footer_viewstub);
        if (this.vqf == null)
        {
          i = 1;
          this.vqf = ((ChatFooterCustom)this.byx.findViewById(R.h.nav_footer_custom));
          if (i != 0) {
            this.vqf.p((ViewGroup)this.byx.findViewById(R.h.chatting_content));
          }
          this.vqh = new com.tencent.mm.ui.chatting.u(this.vqf);
          localObject1 = this.vqh;
          if (com.tencent.mm.sdk.platformtools.e.bvj != 1) {
            break label861;
          }
          i = 1;
          label656:
          ((com.tencent.mm.ui.chatting.u)localObject1).vky.findViewById(R.h.chatting_footer_switch2input).setVisibility(8);
          ((com.tencent.mm.ui.chatting.u)localObject1).jiW = ((LinearLayout)((com.tencent.mm.ui.chatting.u)localObject1).vky.findViewById(R.h.chatting_footer_menu_container));
          ((com.tencent.mm.ui.chatting.u)localObject1).vky.findViewById(R.h.chatting_footer_menu_arrow).setVisibility(8);
          localObject2 = ((com.tencent.mm.ui.chatting.u)localObject1).jiW;
          if (i == 0) {
            break label866;
          }
        }
        label861:
        label866:
        for (float f = 1.0F;; f = 2.0F)
        {
          ((LinearLayout)localObject2).setWeightSum(f);
          ((com.tencent.mm.ui.chatting.u)localObject1).vkz = ((FrameLayout)((com.tencent.mm.ui.chatting.u)localObject1).jiW.getChildAt(0));
          ((com.tencent.mm.ui.chatting.u)localObject1).vkz.setVisibility(0);
          ((com.tencent.mm.ui.chatting.u)localObject1).vkz.setOnClickListener(((com.tencent.mm.ui.chatting.u)localObject1).vkI);
          ((TextView)((com.tencent.mm.ui.chatting.u)localObject1).vkz.getChildAt(0).findViewById(R.h.chatting_footer_menu_text)).setText(R.l.chatfooter_compose_mail);
          ((com.tencent.mm.ui.chatting.u)localObject1).vkz.getChildAt(0).findViewById(R.h.chatting_footer_menu_icon).setVisibility(8);
          ((com.tencent.mm.ui.chatting.u)localObject1).vkz.getChildAt(1).setVisibility(8);
          if (i == 0) {
            break label871;
          }
          i = 1;
          while (i < 6)
          {
            ((com.tencent.mm.ui.chatting.u)localObject1).jiW.getChildAt(i).setVisibility(8);
            i += 1;
          }
          i = 0;
          break;
          i = 0;
          break label656;
        }
        label871:
        ((com.tencent.mm.ui.chatting.u)localObject1).vkA = ((FrameLayout)((com.tencent.mm.ui.chatting.u)localObject1).jiW.getChildAt(1));
        ((com.tencent.mm.ui.chatting.u)localObject1).vkA.setVisibility(0);
        ((com.tencent.mm.ui.chatting.u)localObject1).vkA.setOnClickListener(((com.tencent.mm.ui.chatting.u)localObject1).vkJ);
        ((com.tencent.mm.ui.chatting.u)localObject1).vkB = ((TextView)((com.tencent.mm.ui.chatting.u)localObject1).vkA.getChildAt(0).findViewById(R.h.chatting_footer_menu_text));
        ((com.tencent.mm.ui.chatting.u)localObject1).vkC = ((ImageView)((com.tencent.mm.ui.chatting.u)localObject1).vkA.getChildAt(0).findViewById(R.h.chatting_footer_menu_icon));
        ((com.tencent.mm.ui.chatting.u)localObject1).vkC.setVisibility(0);
        ((com.tencent.mm.ui.chatting.u)localObject1).cCQ();
        au.Hx();
        ((com.tencent.mm.ui.chatting.u)localObject1).vkE = ((Integer)com.tencent.mm.model.c.Dz().get(ac.a.uoK, Integer.valueOf(-1))).intValue();
        if (((com.tencent.mm.ui.chatting.u)localObject1).vkE >= 0) {
          ((com.tencent.mm.ui.chatting.u)localObject1).cCS();
        }
        for (;;)
        {
          ((com.tencent.mm.ui.chatting.u)localObject1).vkA.getChildAt(1).setVisibility(8);
          i = 2;
          while (i < 6)
          {
            ((com.tencent.mm.ui.chatting.u)localObject1).jiW.getChildAt(i).setVisibility(8);
            i += 1;
          }
          ((com.tencent.mm.ui.chatting.u)localObject1).vkB.setText(R.l.chatfooter_mail_without_unread_count);
        }
        ((com.tencent.mm.ui.chatting.u)localObject1).vkH = com.tencent.mm.m.g.AB().getMailAppEnterUlAndroid();
        if (bk.bl(((com.tencent.mm.ui.chatting.u)localObject1).vkH)) {
          ((com.tencent.mm.ui.chatting.u)localObject1).vkH = "qqmail://folderlist?app=weixin&action=list&uin=$uin$";
        }
        au.Hx();
        localObject2 = new com.tencent.mm.a.o(bk.g((Integer)com.tencent.mm.model.c.Dz().get(9, null))).toString();
        ((com.tencent.mm.ui.chatting.u)localObject1).vkH = ((com.tencent.mm.ui.chatting.u)localObject1).vkH.replace("$uin$", (CharSequence)localObject2);
        ((com.tencent.mm.ui.chatting.u)localObject1).nju = com.tencent.mm.m.g.AB().Ar();
        ((com.tencent.mm.ui.chatting.u)localObject1).vkF = true;
        cEv();
        break;
      }
      this.vqh = null;
      if (s.hg((String)localObject1))
      {
        cEx();
        i.a(this.byx.vtz, R.h.nav_custom_footer_viewstub);
        if (this.vqf == null) {}
        for (i = 1;; i = 0)
        {
          this.vqf = ((ChatFooterCustom)this.byx.findViewById(R.h.nav_footer_custom));
          if (i != 0) {
            this.vqf.p((ViewGroup)this.byx.findViewById(R.h.chatting_content));
          }
          this.vqi = new com.tencent.mm.ui.chatting.x(this.vqf);
          this.vqi.cAN();
          cEv();
          break;
        }
      }
      this.vqi = null;
      if (s.hh((String)localObject1))
      {
        cEx();
        i.a(this.byx.vtz, R.h.nav_custom_footer_viewstub);
        if (this.vqf == null) {}
        for (i = 1;; i = 0)
        {
          this.vqf = ((ChatFooterCustom)this.byx.findViewById(R.h.nav_footer_custom));
          if (i != 0) {
            this.vqf.p((ViewGroup)this.byx.findViewById(R.h.chatting_content));
          }
          this.vqj = new com.tencent.mm.ui.chatting.i(this.vqf);
          this.vqj.cAN();
          cEv();
          break;
        }
      }
      this.vqj = null;
      if ((!s.hp((String)localObject1)) && (!s.hg((String)localObject1)) && (!s.ho((String)localObject1)) && (!s.hh((String)localObject1)))
      {
        s.GW();
        if (!s.hP((String)localObject1)) {}
      }
      else
      {
        cEx();
        break;
      }
      cEw();
      aa(this.byx.pSb);
      cEA();
      this.maV.setUserName((String)localObject1);
      adt((String)localObject1);
      localObject1 = (com.tencent.mm.ui.chatting.b.b.h)this.byx.ac(com.tencent.mm.ui.chatting.b.b.h.class);
      Object localObject2 = (com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class);
      if (!((com.tencent.mm.ui.chatting.b.b.h)localObject1).cEh()) {
        break;
      }
      if (((com.tencent.mm.ui.chatting.b.b.y)localObject2).cFh())
      {
        ((com.tencent.mm.ui.chatting.b.b.y)localObject2).cFg();
        ((com.tencent.mm.ui.chatting.b.b.h)localObject1).cEi();
        break;
      }
      ((com.tencent.mm.ui.chatting.b.b.h)localObject1).cEf();
      break;
      label1568:
      this.sfe.me(false);
    }
  }
  
  public final void cyO() {}
  
  public final void cyP()
  {
    this.vql = this.byx.vtz.getStringExtra("smiley_product_id");
    if (this.maV.cnI()) {
      ((aa)this.byx.ac(aa.class)).keepSignalling();
    }
    if ((s.ho(this.byx.getTalkerUserName())) && (this.vqh != null) && (this.vqh.vkF)) {
      this.vqh.cCR();
    }
    ChatFooter localChatFooter = this.maV;
    Object localObject = this.byx.vtz;
    localChatFooter.sfu = ((com.tencent.mm.ui.x)localObject);
    if (!localChatFooter.saZ) {
      localChatFooter.findViewById(R.h.chatting_foot_bar_group).setVisibility(0);
    }
    localChatFooter.a(((com.tencent.mm.ui.x)localObject).getContext(), ((com.tencent.mm.ui.x)localObject).thisActivity());
    localChatFooter.sgb = true;
    if ((!bk.bl(this.vql)) && (this.maV != null))
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUI.FootComponent", "deal use smiley panel in product: %s", new Object[] { this.vql });
      this.maV.setDefaultSmileyByDetail(this.vql);
      this.maV.cng();
    }
    this.byx.vtz.getContext().getIntent().putExtra("smiley_product_id", "");
    this.maV.setUserName(this.byx.getTalkerUserName());
    localChatFooter = this.maV;
    localObject = this.byx.cFB();
    String str = this.byx.getTalkerUserName();
    localChatFooter.bRO = ((String)localObject);
    localChatFooter.toUser = str;
    if (this.byx.vtz.getBooleanExtra("key_show_bottom_app_panel", false).booleanValue())
    {
      localChatFooter = this.maV;
      localChatFooter.cVs();
      if (localChatFooter.seX != null)
      {
        localChatFooter.seX.performClick();
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChatFooter", "perform click attach bt to show bottom panel");
      }
    }
    if (aa(this.byx.pSb))
    {
      if (this.maV != null)
      {
        au.Hx();
        bool1 = ((Boolean)com.tencent.mm.model.c.Dz().get(66832, Boolean.valueOf(false))).booleanValue();
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUI.FootComponent", "jacks refresh Footer Plugin Setting , Enable Enter Button: %B", new Object[] { Boolean.valueOf(bool1) });
        this.maV.cnJ();
        if (bool1)
        {
          this.maV.cnA();
          this.maV.cnw();
        }
        if (bool1) {
          this.maV.cnl();
        }
        localChatFooter = this.maV;
        if (localChatFooter.seR != null) {
          localChatFooter.seR.cmU();
        }
      }
      ((com.tencent.mm.ui.chatting.b.b.ad)this.byx.ac(com.tencent.mm.ui.chatting.b.b.ad.class)).cEl();
      if (this.maV != null)
      {
        this.maV.seR.refresh();
        this.maV.addTextChangedListener(new q.a(this, (byte)0));
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "addTextChangedListener");
      }
    }
    boolean bool1 = ((com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFk();
    boolean bool2 = ((com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFj();
    boolean bool3 = ((com.tencent.mm.ui.chatting.b.b.h)this.byx.ac(com.tencent.mm.ui.chatting.b.b.h.class)).cEh();
    if ((!bool1) && (!bool2) && (!bool3) && (this.byx.pSb != null) && (!this.byx.pSb.cua()) && (!s.hR(this.byx.getTalkerUserName())) && (!com.tencent.mm.ui.widget.snackbar.b.akH()) && (!s.hh(this.byx.getTalkerUserName())))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "call visibleFooter again.");
      cEw();
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "no call visibleFooter again.");
  }
  
  public final void cyQ()
  {
    Object localObject;
    if (this.maV != null)
    {
      localObject = this.maV;
      if (((ChatFooter)localObject).sfB != null)
      {
        ((ChatFooter)localObject).lXN.removeTextChangedListener(((ChatFooter)localObject).sfB);
        ((ChatFooter)localObject).sfB = null;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "removeTextChangeListener");
      this.maV.onPause();
      if (!com.tencent.mm.kernel.g.DK()) {
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ChattingUI.FootComponent", "account not ready");
      }
    }
    else
    {
      return;
    }
    au.Hx();
    com.tencent.mm.model.c.Dz().o(18, Integer.valueOf(this.maV.getMode()));
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUI.FootComponent", "dkcm old:%d footer:%d ", new Object[] { Integer.valueOf(this.vqg), Integer.valueOf(this.maV.getMode()) });
    if (this.vqg != this.maV.getMode())
    {
      this.vqg = this.maV.getMode();
      au.Hx();
      localObject = com.tencent.mm.model.c.FB().abv(this.byx.getTalkerUserName());
      if ((localObject != null) && (this.byx.getTalkerUserName().equals(((as)localObject).field_username)))
      {
        ((ak)localObject).fz(this.vqg);
        au.Hx();
        com.tencent.mm.model.c.FB().a((ak)localObject, this.byx.getTalkerUserName());
      }
    }
    this.maV.aRj();
  }
  
  public final void cyR() {}
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1) {
      if ((paramInt1 == 200) || (paramInt1 == 201) || (paramInt1 == 203)) {
        this.maV.clearFocus();
      }
    }
    do
    {
      return;
      if ((paramInt1 != 217) && (this.vqf != null)) {
        this.vqf.l(paramInt1, paramIntent);
      }
      switch (paramInt1)
      {
      default: 
        return;
      }
      if (paramIntent == null)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ChattingUI.FootComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
        return;
      }
      paramInt1 = paramIntent.getIntExtra("Chat_Mode", 1);
    } while (this.maV == null);
    this.maV.setMode(paramInt1);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "chatting onKeyDown, code:%d action:%d", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    if (paramKeyEvent.getKeyCode() == 4) {
      if (!this.byx.euf) {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown back key fragment not foreground");
      }
    }
    for (;;)
    {
      int i = 0;
      for (;;)
      {
        if (i != 0) {
          break label390;
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
        if ((this.byx.vtz.isSupportNavigationSwipeBack()) && (this.byx.vtz.getSwipeBackLayout().cnC()))
        {
          com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ChattingUI.FootComponent", "ashutest::onKeyDown back ScrollToFinishing");
          i = 1;
        }
        else
        {
          if (paramKeyEvent.getAction() == 0)
          {
            this.vqp = true;
            this.vqr = System.currentTimeMillis();
          }
          if (paramKeyEvent.getAction() != 1) {
            break label305;
          }
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUI.FootComponent", "hasBack %B, %d", new Object[] { Boolean.valueOf(this.vqp), Long.valueOf(System.currentTimeMillis() - this.vqr) });
          if ((this.vqp) && (System.currentTimeMillis() - this.vqr <= 30000L)) {
            break;
          }
          i = 1;
        }
      }
      this.vqq = true;
      com.tencent.mm.ui.chatting.b.b.h localh = (com.tencent.mm.ui.chatting.b.b.h)this.byx.ac(com.tencent.mm.ui.chatting.b.b.h.class);
      com.tencent.mm.ui.chatting.b.b.y localy = (com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class);
      if (localh.cEh()) {
        if (localy.cFh())
        {
          localy.cFg();
          localh.cEi();
          label271:
          i = 1;
          label273:
          if (i == 0)
          {
            if ((this.maV == null) || (!this.maV.cnD())) {
              break label325;
            }
            this.maV.r(2, 23, false);
          }
        }
      }
      for (;;)
      {
        label305:
        i = 1;
        break;
        localh.cEf();
        break label271;
        i = 0;
        break label273;
        label325:
        this.byx.vtz.cCo();
      }
      if ((paramKeyEvent.getKeyCode() == 67) && (!this.byx.euf)) {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown back key fragment not foreground");
      } else if (!this.byx.euf) {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown fragment not foreground");
      }
    }
    label390:
    return true;
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 0;
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      if (paramArrayOfInt == null)
      {
        i = -1;
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ChattingUI.FootComponent", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, bk.csb() });
      }
    }
    label225:
    label486:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    i = paramArrayOfInt.length;
                    break;
                    switch (paramInt)
                    {
                    default: 
                      return;
                    case 18: 
                      if (paramArrayOfInt[0] != 0) {
                        break label225;
                      }
                      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "summerper doFooterSightRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.vqe, bk.csb() });
                    }
                  } while (this.vqe == null);
                  paramArrayOfString = this.vqe;
                  if (this.maV.seR.sdT.seI.value) {}
                  for (paramInt = i;; paramInt = 2)
                  {
                    paramArrayOfString.GP(paramInt);
                    return;
                  }
                  if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
                  for (paramInt = R.l.permission_camera_request_again_msg; paramArrayOfInt[0] != 0; paramInt = R.l.permission_microphone_request_again_msg)
                  {
                    com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(paramInt), this.byx.vtz.getMMResources().getString(R.l.permission_tips_title), this.byx.vtz.getMMResources().getString(R.l.jump_to_settings), this.byx.vtz.getMMResources().getString(R.l.cancel), false, new q.5(this), new q.6(this));
                    return;
                  }
                  if (paramArrayOfInt[0] != 0) {
                    break label486;
                  }
                  if (paramInt != 19) {
                    break label400;
                  }
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuVideoSelected,footerEventImpl[%s], stack[%s]", new Object[] { this.vqe, bk.csb() });
                } while (this.vqe == null);
                this.vqe.bsH();
                return;
                if (paramInt != 21) {
                  break label446;
                }
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.vqe, bk.csb() });
              } while (this.vqe == null);
              this.vqe.cCK();
              return;
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnEnterMultiTalk,footerEventImpl[%s], stack[%s]", new Object[] { this.vqe, bk.csb() });
            } while (this.vqe == null);
            this.vqe.cCI();
            return;
            if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
            for (paramInt = R.l.permission_camera_request_again_msg; paramArrayOfInt[0] != 0; paramInt = R.l.permission_microphone_request_again_msg)
            {
              com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(paramInt), this.byx.vtz.getMMResources().getString(R.l.permission_tips_title), this.byx.vtz.getMMResources().getString(R.l.jump_to_settings), this.byx.vtz.getMMResources().getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  paramAnonymousDialogInterface.dismiss();
                  q.this.byx.vtz.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  paramAnonymousDialogInterface.dismiss();
                }
              });
              return;
            }
            if (paramArrayOfInt[0] != 0) {
              break label655;
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "summerper doImageSelectTakePhotoRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.vqe, bk.csb() });
          } while (this.vqe == null);
          this.vqe.cCM();
          return;
          com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.permission_camera_request_again_msg), this.byx.vtz.getMMResources().getString(R.l.permission_tips_title), this.byx.vtz.getMMResources().getString(R.l.jump_to_settings), this.byx.vtz.getMMResources().getString(R.l.cancel), false, new q.9(this), null);
          return;
          if (paramArrayOfInt[0] != 0) {
            break label790;
          }
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "summerper doTalkRoomRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.vqe, bk.csb() });
        } while (this.vqe == null);
        this.vqe.cCL();
        return;
        com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.permission_location_request_again_msg), this.byx.vtz.getMMResources().getString(R.l.permission_tips_title), this.byx.vtz.getMMResources().getString(R.l.jump_to_settings), this.byx.vtz.getMMResources().getString(R.l.cancel), false, new q.10(this), null);
        return;
        if (paramArrayOfInt[0] != 0) {
          break label971;
        }
        if (paramInt != 82) {
          break label931;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuAudioSelected,footerEventImpl[%s], stack[%s]", new Object[] { this.vqe, bk.csb() });
      } while (this.vqe == null);
      this.vqe.bsG();
      return;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipAudioRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.vqe, bk.csb() });
    } while (this.vqe == null);
    label400:
    label446:
    this.vqe.cCJ();
    label655:
    label790:
    label931:
    return;
    label971:
    com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.permission_microphone_request_again_msg), this.byx.vtz.getMMResources().getString(R.l.permission_tips_title), this.byx.vtz.getMMResources().getString(R.l.jump_to_settings), this.byx.vtz.getMMResources().getString(R.l.cancel), false, new q.2(this), null);
  }
  
  public final void setVoiceInputShowCallback(ChatFooter.d paramd)
  {
    this.maV.setVoiceInputShowCallback(paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.q
 * JD-Core Version:    0.7.0.1
 */