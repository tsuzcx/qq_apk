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
import com.tencent.mm.al.k;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.c;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.emoji.b.c.b.b;
import com.tencent.mm.emoji.b.c.j.b;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.g.b.a.jy;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout;
import com.tencent.mm.plugin.websearch.PluginWebSearch;
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
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI;
import com.tencent.mm.ui.chatting.AtSomeoneUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.ar;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.d.b.t;
import com.tencent.mm.ui.chatting.d.b.y;
import com.tencent.mm.ui.chatting.i;
import com.tencent.mm.ui.chatting.q;
import com.tencent.mm.ui.chatting.w;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.view.MaxHeightScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.d.a.a(gRF=com.tencent.mm.ui.chatting.d.b.u.class)
public class x
  extends a
  implements MStorage.IOnStorageChange, MStorageEx.IOnStorageChange, com.tencent.mm.ui.chatting.d.b.u
{
  private static ArrayList<com.tencent.mm.pluginsdk.ui.chat.a.a> PpE = null;
  private static long PpF = 0L;
  private final ChatFooter.g KiE;
  private q PpG;
  protected ChatFooterCustom PpH;
  private int PpI;
  private com.tencent.mm.ui.chatting.u PpJ;
  private com.tencent.mm.ui.chatting.x PpK;
  private i PpL;
  private AnimationSet PpM;
  private String PpN;
  private int PpO;
  private int PpP;
  private boolean PpQ;
  public boolean PpR;
  private boolean PpS;
  public boolean PpT;
  private long PpU;
  private IListener gsS;
  private IListener gsT;
  protected ChatFooter znD;
  
  public x()
  {
    AppMethodBeat.i(35314);
    this.PpI = 0;
    this.PpN = null;
    this.PpQ = false;
    this.PpR = false;
    this.gsS = new IListener() {};
    this.gsT = new IListener() {};
    this.KiE = new ChatFooter.g()
    {
      private Animation PpW;
      private Animation PpX;
      
      public final boolean An(boolean paramAnonymousBoolean)
      {
        int i = 1;
        AppMethodBeat.i(35305);
        if (this.PpW == null)
        {
          this.PpW = AnimationUtils.loadAnimation(x.this.dom.Pwc.getContext(), 2130772132);
          this.PpX = AnimationUtils.loadAnimation(x.this.dom.Pwc.getContext(), 2130772130);
        }
        com.tencent.mm.ui.chatting.d.b.d locald;
        String str;
        if (paramAnonymousBoolean)
        {
          Log.i("MicroMsg.ChattingUI.FootComponent", "switchFooterToInput customFooter is %s", new Object[] { x.this.PpH });
          if (x.this.PpH != null) {
            x.this.PpH.startAnimation(this.PpX);
          }
          x.this.gPU();
          x.this.znD.startAnimation(this.PpW);
          x.this.znD.postInvalidateDelayed(this.PpW.getDuration());
          locald = (com.tencent.mm.ui.chatting.d.b.d)x.this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class);
          if (locald != null)
          {
            str = x.this.dom.getTalkerUserName();
            if (!paramAnonymousBoolean) {
              break label262;
            }
          }
        }
        for (;;)
        {
          locald.ha(str, i);
          AppMethodBeat.o(35305);
          return false;
          x.this.znD.startAnimation(this.PpX);
          x.this.gPT();
          if (x.this.PpH == null) {
            break;
          }
          x.this.PpH.startAnimation(this.PpW);
          x.this.PpH.postInvalidateDelayed(this.PpW.getDuration());
          break;
          label262:
          i = 2;
        }
      }
    };
    this.PpS = false;
    this.PpT = false;
    this.PpU = 0L;
    AppMethodBeat.o(35314);
  }
  
  private void a(final String paramString, final ay.b.a parama)
  {
    AppMethodBeat.i(163315);
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184961);
        ay.a.iDq.a(paramString, "", parama);
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
  
  private void a(String paramString, as paramas, ArrayList<com.tencent.mm.pluginsdk.ui.chat.a.a> paramArrayList)
  {
    AppMethodBeat.i(163316);
    long l1;
    if (paramas == null)
    {
      l1 = 0L;
      Log.i("MicroMsg.ChattingUI.FootComponent", "ChatroomBusinessType user %s %s", new Object[] { paramString, Long.valueOf(l1) });
      if ((!this.dom.gRL()) || (paramas == null) || (paramas.fvd == 0L)) {
        break label222;
      }
      if (PpE != null) {
        break label166;
      }
      PpE = new ArrayList();
      gQa();
      PpF = cl.aWy();
    }
    for (;;)
    {
      paramString = PpE;
      if ((paramString == null) || (paramString.size() <= 0)) {
        break label222;
      }
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        com.tencent.mm.pluginsdk.ui.chat.a.a locala = (com.tencent.mm.pluginsdk.ui.chat.a.a)paramString.next();
        if ((locala.Kie & paramas.fvd) != 0L)
        {
          locala.kHG = paramas.field_username;
          paramArrayList.add(locala);
        }
      }
      l1 = paramas.fvd;
      break;
      label166:
      l1 = cl.aWy();
      long l2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.siq, 1800);
      if (l1 - PpF > l2)
      {
        PpF = l1;
        PpE.clear();
        gQa();
      }
    }
    label222:
    this.znD.setAppPanelUnCertainEnterArrayList(paramArrayList);
    AppMethodBeat.o(163316);
  }
  
  private void bmK(final String paramString)
  {
    AppMethodBeat.i(35325);
    Log.i("MicroMsg.ChattingUI.FootComponent", "initFooterPanelMenu %s", new Object[] { paramString });
    this.znD.gqt();
    this.znD.gqk();
    int i;
    Object localObject1;
    int j;
    label126:
    boolean bool1;
    if (((com.tencent.mm.ui.chatting.d.b.l)this.dom.bh(com.tencent.mm.ui.chatting.d.b.l.class)).gPB())
    {
      Log.w("MicroMsg.ChattingUI.FootComponent", "match shake, in show mode, do not open short video recode view");
      i = 0;
      if (i == 0) {
        this.znD.gqv();
      }
      if (((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP())
      {
        localObject1 = com.tencent.mm.al.g.fJ(this.dom.getTalkerUserName());
        if ((localObject1 != null) && (((com.tencent.mm.api.c)localObject1).field_enterpriseFather != null)) {
          break label2655;
        }
        j = 0;
        if (j != 0)
        {
          localObject1 = this.znD.Kik;
          ((AppPanel)localObject1).KgQ.KhI.value = true;
          ((AppPanel)localObject1).gpV();
        }
      }
      if (!this.dom.gRM()) {
        this.znD.gqE();
      }
      bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZb, true);
      localObject1 = this.znD;
      if (!BuildInfo.DEBUG) {
        break label2709;
      }
      i = 1;
      label206:
      Log.i("MicroMsg.ChattingUI.FootComponent", "isGroupChat:%b enableLive:%b", new Object[] { Boolean.valueOf(this.dom.gRM()), Boolean.valueOf(bool1) });
      if ((this.dom.gRM()) && (bool1) && (i != 0)) {
        break label2937;
      }
      this.znD.Kik.gpU();
      label268:
      if (!ab.Ix(this.dom.getTalkerUserName())) {
        this.znD.Kik.gpU();
      }
      if ((this.dom.GUe != null) && (!com.tencent.mm.contact.c.oR(this.dom.GUe.field_type)) && (!ab.Eq(this.dom.getTalkerUserName()))) {
        this.znD.gqy();
      }
      if (as.IG(paramString))
      {
        this.znD.Kik.gpM();
        this.znD.Kik.gpO();
        this.znD.Kik.gpP();
        this.znD.gqw();
        this.znD.gqx();
        this.znD.Kik.gpN();
        this.znD.aX(true, true);
        this.znD.gqy();
        this.znD.gqA();
        this.znD.Kik.gpR();
        this.znD.Kik.gpU();
      }
      if (as.bjo(paramString))
      {
        this.znD.Kik.gpM();
        this.znD.Kik.gpO();
        this.znD.Kik.gpP();
        this.znD.gqw();
        this.znD.gqx();
        this.znD.Kik.gpN();
        this.znD.aX(true, true);
        this.znD.gqy();
        this.znD.gqA();
        this.znD.Kik.gpR();
        this.znD.Kik.gpU();
      }
      if (as.bjm(paramString))
      {
        this.znD.Kik.gpM();
        this.znD.Kik.gpO();
        this.znD.Kik.gpP();
        this.znD.gqw();
        this.znD.gqs();
        this.znD.gqx();
        this.znD.Kik.gpN();
        this.znD.aX(true, true);
        this.znD.gqy();
        this.znD.gqA();
        this.znD.Kik.gpR();
        this.znD.Kik.gpU();
      }
      if (as.avl(paramString))
      {
        this.znD.gqk();
        this.znD.gqs();
        this.znD.Kik.gpP();
        this.znD.gqE();
        this.znD.gqx();
        this.znD.gqu();
        this.znD.Kik.gpM();
        this.znD.gqv();
        this.znD.gqx();
        this.znD.gqD();
        this.znD.goD();
        this.znD.Kik.gpQ();
        this.znD.aX(true, true);
        this.znD.zY(true);
        this.znD.zZ(true);
        this.znD.gqy();
        this.znD.gqA();
        this.znD.Kik.gpN();
        this.znD.Kik.gpM();
        this.znD.Kik.gpO();
        this.znD.Kik.gpR();
      }
      if (ab.Ji(paramString))
      {
        this.znD.Kik.gpM();
        this.znD.Kik.gpO();
        this.znD.Kik.gpP();
        this.znD.gqx();
        this.znD.Kik.gpN();
        this.znD.aX(true, true);
        this.znD.gqy();
        this.znD.gqA();
        this.znD.Kik.gpR();
        this.znD.Kik.gpU();
      }
      if (ab.Jf(paramString))
      {
        this.znD.Kik.gpM();
        this.znD.aX(true, true);
        this.znD.Kik.gpN();
        this.znD.Kik.gpR();
        this.znD.Kik.gpU();
      }
      bg.aVF();
      localObject1 = com.tencent.mm.model.c.aSN().Kn(paramString);
      if ((localObject1 != null) && (((as)localObject1).gBM()))
      {
        if (!((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()) {
          break label2963;
        }
        this.znD.Kik.gpM();
        this.znD.Kik.gpP();
        this.znD.Kik.gpN();
        this.znD.aX(true, true);
        this.znD.gqy();
        this.znD.gqA();
        this.znD.gqv();
        this.znD.Kik.gpQ();
        this.znD.gqu();
        this.znD.gqD();
        this.znD.goD();
        this.znD.Kik.gpU();
      }
    }
    for (;;)
    {
      try
      {
        EventCenter.instance.publish(new rj());
        if (this.dom.gRL())
        {
          if (com.tencent.mm.n.h.aqJ().getInt("MultitalkBlockCaller", 0) == 0)
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            this.znD.zY(false);
            if ((this.dom.gRM()) || (this.dom.gRK()))
            {
              this.znD.aX(true, true);
              this.znD.gqA();
            }
            com.tencent.mm.br.c.gsX();
            if (this.dom.gRK()) {
              this.znD.Kik.gpN();
            }
            if (this.dom.getTalkerUserName().equals(z.aTY()))
            {
              this.znD.Kik.gpN();
              this.znD.aX(true, true);
              this.znD.gqy();
              this.znD.gqA();
              this.znD.Kik.gpU();
            }
            this.znD.setAppPanelTip(null);
            if ((!as.bjp(this.dom.GUe.field_username)) && (!ab.Iy(this.dom.GUe.field_username))) {
              continue;
            }
            com.tencent.mm.kernel.g.aAi();
            Object localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.dom.GUe.field_username);
            ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).bM(((ax)localObject3).field_openImAppid, ((ax)localObject3).field_descWordingId);
            i = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).RZ(((ax)localObject3).field_openImAppid);
            Object localObject2 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).c(this.dom.GUe.field_openImAppid, "openim_function_tip", com.tencent.mm.openim.a.a.a.jGS);
            Log.i("MicroMsg.ChattingUI.FootComponent", "openim showFlag:%d username: %s appid: %s tip %s", new Object[] { Integer.valueOf(i), this.dom.GUe.field_username, ((ax)localObject3).field_openImAppid, localObject2 });
            if ((i & 0x1) == 0) {
              this.znD.gqs();
            }
            if ((i & 0x2) == 0) {
              this.znD.gqu();
            }
            if ((i & 0x4) == 0) {
              this.znD.gqC();
            }
            if ((i & 0x8) == 0) {
              this.znD.gqw();
            }
            if ((i & 0x10) == 0) {
              this.znD.Kik.gpO();
            }
            if ((i & 0x20) == 0) {
              this.znD.Kik.gpM();
            }
            if ((i & 0x40) == 0) {
              this.znD.Kik.gpR();
            }
            if ((i & 0x80) == 0) {
              this.znD.gqx();
            }
            if (((i & 0x100) == 0) || ((i & 0x2000) == 0))
            {
              localObject3 = this.znD;
              if ((i & 0x100) != 0) {
                continue;
              }
              bool1 = true;
              if ((i & 0x2000) != 0) {
                continue;
              }
              bool2 = true;
              ((ChatFooter)localObject3).aX(bool1, bool2);
            }
            if ((i & 0x200) != 0) {
              continue;
            }
            this.znD.gqy();
            Log.i("MicroMsg.ChattingUI.FootComponent", "openIM disableServiceLuckyMoney");
            if ((i & 0x4000) != 0) {
              continue;
            }
            this.znD.gqA();
            Log.i("MicroMsg.ChattingUI.FootComponent", "openIM disableServiceRemittance");
            if ((i & 0x400) == 0) {
              this.znD.gqz();
            }
            if ((ab.Iy(this.dom.GUe.field_username)) && ((i & 0x100) == 0)) {
              this.znD.zY(true);
            }
            this.znD.setAppPanelTip((CharSequence)localObject2);
            localObject2 = this.znD;
            com.tencent.mm.br.c.gsX();
            if (((ChatFooter)localObject2).rum != null) {
              ((ChatFooter)localObject2).rum.zN(false);
            }
            localObject2 = this.znD;
            com.tencent.mm.br.c.gsX();
            if (!com.tencent.mm.aw.b.bdC()) {
              continue;
            }
            bool1 = true;
            ((ChatFooter)localObject2).zZ(bool1);
            this.znD.Kik.gpN();
            if (as.HF(this.dom.getTalkerUserName()))
            {
              this.znD.gqk();
              this.znD.gqs();
              this.znD.Kik.gpP();
              this.znD.gqE();
              this.znD.Kik.gpU();
              this.znD.gqx();
              this.znD.gqu();
              this.znD.gqw();
              this.znD.Kik.gpM();
              this.znD.gqv();
              this.znD.gqx();
              this.znD.gqu();
              this.znD.gqD();
              this.znD.goD();
              this.znD.Kik.gpQ();
              this.znD.aX(true, true);
              this.znD.zY(true);
              this.znD.zZ(true);
              this.znD.gqy();
              this.znD.gqA();
              this.znD.Kik.gpN();
              this.znD.Kik.gpM();
              this.znD.Kik.gpO();
              this.znD.Kik.gpR();
            }
            if (as.bju(paramString))
            {
              this.znD.gqk();
              if (((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.d.class)).dXd()) {
                continue;
              }
              localObject2 = this.znD;
              ((ChatFooter)localObject2).KiW = true;
              ((ChatFooter)localObject2).Kir.setVisibility(8);
              ((ChatFooter)localObject2).Am(false);
              if (!((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.d.class)).dXg())
              {
                this.znD.gqu();
                this.znD.gqD();
                this.znD.goD();
                this.znD.Kik.gpQ();
              }
              this.znD.gqs();
              this.znD.Kik.gpP();
              this.znD.gqE();
              this.znD.gqx();
              this.znD.aX(true, true);
              this.znD.zY(true);
              this.znD.zZ(true);
              this.znD.gqy();
              this.znD.gqA();
              this.znD.Kik.gpN();
              this.znD.Kik.gpM();
              this.znD.Kik.gpO();
              this.znD.Kik.gpR();
              this.znD.gqz();
            }
            if ((!aa.ame()) || (!ab.Ix(this.dom.getTalkerUserName()))) {
              this.znD.Kik.gpS();
            }
            if (!((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.j.class)).aBg(this.dom.getTalkerUserName())) {
              this.znD.Kik.gpT();
            }
            localObject2 = new ArrayList();
            a(paramString, (as)localObject1, (ArrayList)localObject2);
            paramString = new ay.b.a()
            {
              public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(163312);
                if ((paramAnonymousBoolean) && (Util.isEqual(x.this.dom.getTalkerUserName(), paramAnonymousString))) {
                  com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(163310);
                      x.a(x.this, x.15.this.dod, x.15.this.gAi, new ArrayList());
                      MMHandlerThread.postToMainThread(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(163309);
                          x.this.znD.gqW();
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
            if ((((ArrayList)localObject2).size() != 0) || (localObject1 == null) || (((ax)localObject1).fvd != 0L)) {
              continue;
            }
            if (!ab.Eq(this.dom.getTalkerUserName())) {
              continue;
            }
            localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.dom.getTalkerUserName());
            if ((localObject1 != null) && ((((ah)localObject1).field_chatroomStatus & 0x8000) != 0L) && ((((ah)localObject1).field_chatroomfamilystatusmodifytime == 0L) || (((ah)localObject1).field_chatroomfamilystatusmodifytime - cl.aWz() >= 86400000L)))
            {
              ((ah)localObject1).field_chatroomfamilystatusmodifytime = cl.aWz();
              ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().update((IAutoDBItem)localObject1, new String[0]);
              a(this.dom.getTalkerUserName(), paramString);
            }
            AppMethodBeat.o(35325);
            return;
            bool1 = ((am)this.dom.bh(am.class)).gRa();
            bool2 = ((am)this.dom.bh(am.class)).gQZ();
            if ((bool1) || (bool2))
            {
              Log.w("MicroMsg.ChattingUI.FootComponent", "match shake, in search mode, do not open short video recode view");
              i = 0;
              break;
            }
            if ((as.bjo(this.dom.getTalkerUserName())) || (as.IG(this.dom.getTalkerUserName())))
            {
              Log.w("MicroMsg.ChattingUI.FootComponent", "match shake, but is Qcontact or Bcontact");
              i = 0;
              break;
            }
            if (ab.JE(this.dom.getTalkerUserName()))
            {
              i = 0;
              break;
            }
            i = 1;
            break;
            label2655:
            localObject1 = ag.bah().MU(((com.tencent.mm.api.c)localObject1).field_enterpriseFather);
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
            label2709:
            if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
            {
              i = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("ChatRoomEnableLive"), 0);
              if (i == 0)
              {
                localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(((ChatFooter)localObject1).Kij);
                if (localObject1 == null) {
                  break label3349;
                }
                if ((((ah)localObject1).field_chatroomStatus & 0x80000) == 524288)
                {
                  j = 1;
                  i = j;
                  if (j != 0) {
                    break label206;
                  }
                  if (com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.Onk, 0) != 1) {
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
            if (((ChatFooter)localObject1).Kij == null) {
              continue;
            }
            i = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("ChatRoomEnableLive"), 0);
            if (i == 0)
            {
              localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(((ChatFooter)localObject1).Kij);
              if (localObject1 == null) {
                continue;
              }
              if ((((ah)localObject1).field_chatroomStatus & 0x80000) == 524288)
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
            label2937:
            localObject1 = this.znD.Kik;
            ((AppPanel)localObject1).KgQ.Ag(true);
            ((AppPanel)localObject1).gpV();
            break label268;
            label2963:
            this.znD.Kik.gpM();
            this.znD.aX(true, true);
            this.znD.gqw();
            this.znD.Kik.gpN();
            this.znD.Kik.gpU();
            continue;
          }
          i = 0;
          continue;
        }
        this.znD.zY(true);
        continue;
        bool1 = false;
        continue;
        boolean bool2 = false;
        continue;
        Log.i("MicroMsg.ChattingUI.FootComponent", "openIM enableServiceLuckyMoney");
        continue;
        Log.i("MicroMsg.ChattingUI.FootComponent", "openIM enableServiceRemittance");
        continue;
        if (!ab.IB(this.dom.GUe.field_username)) {
          continue;
        }
        i = z.aUT();
        if ((i & 0x1) == 0) {
          this.znD.zY(true);
        }
        if ((i & 0x2) == 0) {
          this.znD.gqy();
        }
        if ((i & 0x4) != 0) {
          continue;
        }
        this.znD.gqz();
        continue;
        bool1 = false;
        continue;
        if (!((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.d.class)).dXe()) {
          this.znD.gqC();
        }
        if (((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.d.class)).dXf()) {
          continue;
        }
        this.znD.gqw();
        this.znD.gqv();
        continue;
        if (ab.Iy(this.dom.getTalkerUserName()))
        {
          localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.dom.getTalkerUserName());
          if ((localObject1 != null) && ((((ah)localObject1).gBr().type & 0x4) != 0L) && ((((ah)localObject1).field_chatroomfamilystatusmodifytime == 0L) || (((ah)localObject1).field_chatroomfamilystatusmodifytime - cl.aWz() >= 86400000L)))
          {
            ((ah)localObject1).field_chatroomfamilystatusmodifytime = cl.aWz();
            ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().update((IAutoDBItem)localObject1, new String[0]);
            a(this.dom.getTalkerUserName(), paramString);
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
      label3349:
      j = 0;
    }
  }
  
  private static void bmL(String paramString)
  {
    AppMethodBeat.i(163318);
    if (Util.isNullOrNil(paramString))
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
        locala.KhQ = paramString.optString("enter_id");
        locala.KhR = paramString.optInt("red_dot");
        locala.uSc = paramString.optInt("jump_type");
        locala.KhS = paramString.optString("wa_un");
        locala.KhU = paramString.optInt("wa_ver");
        locala.KhV = paramString.optString("wa_path");
        locala.KhW = paramString.optString("wa_dgmode");
        locala.nnB = paramString.optString("h5_url");
        locala.iconUrl = paramString.optString("icon_url");
        locala.Kib = paramString.optString("icon_url_dark");
        if (Util.isNullOrNil(locala.iconUrl))
        {
          Log.e("MicroMsg.ChattingUI.FootComponent", "unCertainEnter.iconUrl is null");
        }
        else
        {
          locala.Kie = paramString.optLong("busi_type");
          localObject = paramString.optJSONObject("title");
          localJSONObject = paramString.optJSONObject("desc");
          if (localObject == null) {
            Log.e("MicroMsg.ChattingUI.FootComponent", "titleJson is null");
          }
        }
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.ChattingUI.FootComponent", "handleAppPanelUnCertainEnterConfig() Exception:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(163318);
        return;
      }
      locala.KhX.title = ((JSONObject)localObject).optString("zh_cn");
      if (Util.isNullOrNil(locala.KhX.title))
      {
        Log.e("MicroMsg.ChattingUI.FootComponent", "unCertainEnter.simpleChWord.title is null");
      }
      else
      {
        a.b localb = locala.KhZ;
        if (Util.isNullOrNil(((JSONObject)localObject).optString("zh_tw")))
        {
          paramString = locala.KhX.title;
          localb.title = paramString;
          localb = locala.KhY;
          if (!Util.isNullOrNil(((JSONObject)localObject).optString("zh_hk"))) {
            break label586;
          }
          paramString = locala.KhX.title;
          label391:
          localb.title = paramString;
          localb = locala.Kia;
          if (!Util.isNullOrNil(((JSONObject)localObject).optString("en"))) {
            break label598;
          }
          paramString = locala.KhX.title;
          label427:
          localb.title = paramString;
          if (localJSONObject != null)
          {
            locala.KhX.desc = localJSONObject.optString("zh_cn");
            localObject = locala.KhZ;
            if (!Util.isNullOrNil(localJSONObject.optString("zh_tw"))) {
              break label610;
            }
            paramString = locala.KhX.desc;
            label484:
            ((a.b)localObject).desc = paramString;
            localObject = locala.KhY;
            if (!Util.isNullOrNil(localJSONObject.optString("zh_hk"))) {
              break label622;
            }
            paramString = locala.KhX.desc;
            label520:
            ((a.b)localObject).desc = paramString;
            localObject = locala.Kia;
            if (!Util.isNullOrNil(localJSONObject.optString("en"))) {
              break label634;
            }
          }
        }
        label586:
        label598:
        label610:
        label622:
        label634:
        for (paramString = locala.KhX.desc;; paramString = localJSONObject.optString("en"))
        {
          ((a.b)localObject).desc = paramString;
          PpE.add(locala);
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
  
  private void gPQ()
  {
    AppMethodBeat.i(35315);
    if (this.dom.Pwc.isCurrentActivity)
    {
      AppMethodBeat.o(35315);
      return;
    }
    this.dom.Pwe.gNZ();
    if (this.znD != null)
    {
      ChatFooter localChatFooter = this.znD;
      Object localObject = localChatFooter.findViewById(2131298513);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localChatFooter.setSwitchButtonMode(0);
      localChatFooter.mHandler.removeMessages(1002);
      if (localChatFooter.Kir != null) {
        localChatFooter.Kir.setVisibility(8);
      }
      if (localChatFooter.Kis != null) {
        localChatFooter.Kis.setVisibility(8);
      }
      if (localChatFooter.Kit != null) {
        localChatFooter.Kit.setVisibility(8);
      }
      if (localChatFooter.Kiw != null) {
        localChatFooter.Kiw.setVisibility(8);
      }
      if (localChatFooter.Kiu != null) {
        localChatFooter.Kiu.setVisibility(8);
      }
      if (localChatFooter.Kix != null) {
        localChatFooter.Kix.setVisibility(8);
      }
      localChatFooter.han.setVisibility(8);
      if (localChatFooter.tfb != null) {
        localChatFooter.tfb.setVisibility(8);
      }
      if (localChatFooter.KjC != null) {
        localChatFooter.KjC.setVisibility(8);
      }
      if (localChatFooter.tfc != null) {
        localChatFooter.tfc.setVisibility(8);
      }
      if (localChatFooter.teZ != null) {
        localChatFooter.teZ.setVisibility(8);
      }
      if (localChatFooter.Kdp != null)
      {
        localChatFooter.Kdp.setVisibility(8);
        localChatFooter.Kds = false;
        localChatFooter.Kdp.destroy();
      }
      if (localChatFooter.KiN != null) {
        localChatFooter.KiN.setVisibility(8);
      }
      if (localChatFooter.FQV != null) {
        localChatFooter.FQV.setVisibility(8);
      }
      if (localChatFooter.FQS != null) {
        localChatFooter.FQS.update();
      }
      if (localChatFooter.Kil != null) {
        localChatFooter.Kil.setVisibility(8);
      }
      if (localChatFooter.Kip != null)
      {
        localChatFooter.Kip.setVisibility(4);
        if (localChatFooter.rum != null) {
          localChatFooter.rum.setVisibility(4);
        }
      }
      localChatFooter.Kik = ((AppPanel)localChatFooter.findViewById(2131298318));
      if (localChatFooter.Kik != null)
      {
        localChatFooter.setAppPanelVisible(8);
        localObject = localChatFooter.Kik;
        if (((AppPanel)localObject).COD != null) {
          ((AppPanel)localObject).COD.setToScreen(0);
        }
        ((AppPanel)localObject).KgO = 0;
      }
      localChatFooter.a(ChatFooter.h.Kmv);
      localChatFooter.i(0, false, -1);
      localChatFooter.KiJ = false;
      this.znD.gqi();
      this.znD.gqj();
      this.znD.KiG.Kml = null;
    }
    AppMethodBeat.o(35315);
  }
  
  private void gPV()
  {
    AppMethodBeat.i(35319);
    Log.i("MicroMsg.ChattingUI.FootComponent", "[goneFooter] %s", new Object[] { Util.getStack() });
    if (this.znD != null)
    {
      this.znD.Ak(false);
      this.znD.setVisibility(8);
    }
    if (this.PpH != null) {
      this.PpH.setVisibility(8);
    }
    this.znD.Ah(false);
    this.dom.hideVKB();
    AppMethodBeat.o(35319);
  }
  
  private void gPZ()
  {
    AppMethodBeat.i(184963);
    if (this.znD == null)
    {
      Log.e("MicroMsg.ChattingUI.FootComponent", "initTodoView footer == null");
      AppMethodBeat.o(184963);
      return;
    }
    Log.i("MicroMsg.ChattingUI.FootComponent", "initTodoView()");
    ((y)this.dom.bh(y.class)).a(this.znD.getIOnToDoBarCallback());
    this.znD.setIOnTodoViewCallback(new ab.c()
    {
      public final void BP(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(185864);
        ((y)x.this.dom.bh(y.class)).BP(paramAnonymousBoolean);
        AppMethodBeat.o(185864);
      }
      
      public final void BQ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(185865);
        ((y)x.this.dom.bh(y.class)).BQ(paramAnonymousBoolean);
        AppMethodBeat.o(185865);
      }
      
      public final int dYg()
      {
        AppMethodBeat.i(185866);
        int i = ((y)x.this.dom.bh(y.class)).dYg();
        AppMethodBeat.o(185866);
        return i;
      }
    });
    AppMethodBeat.o(184963);
  }
  
  private static void gQa()
  {
    AppMethodBeat.i(163317);
    bmL(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sig, ""));
    bmL(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sih, ""));
    bmL(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sii, ""));
    bmL(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sij, ""));
    bmL(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sik, ""));
    bmL(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sil, ""));
    bmL(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sim, ""));
    bmL(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sin, ""));
    bmL(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sio, ""));
    bmL(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sip, ""));
    AppMethodBeat.o(163317);
  }
  
  public final boolean aT(ca paramca)
  {
    AppMethodBeat.i(35323);
    if (this.znD != null) {
      this.znD.aT(paramca);
    }
    AppMethodBeat.o(35323);
    return true;
  }
  
  public final boolean au(as paramas)
  {
    AppMethodBeat.i(35322);
    boolean bool1 = ((am)this.dom.bh(am.class)).gRa();
    boolean bool2 = ((am)this.dom.bh(am.class)).gQZ();
    boolean bool3 = ((com.tencent.mm.ui.chatting.d.b.l)this.dom.bh(com.tencent.mm.ui.chatting.d.b.l.class)).gPB();
    boolean bool4 = ((s)this.dom.bh(s.class)).gPN();
    boolean bool5 = ((ai)this.dom.bh(ai.class)).gQN();
    if (this.PpR)
    {
      AppMethodBeat.o(35322);
      return true;
    }
    if ((bool1) || (bool2) || (bool3) || (bool4) || (bool5))
    {
      Log.i("MicroMsg.ChattingUI.FootComponent", bool1 + ", " + bool2 + ", " + bool3 + ", " + bool4 + ", " + bool5);
      gPV();
      AppMethodBeat.o(35322);
      return false;
    }
    if ((paramas != null) && (ab.IP(paramas.field_username)))
    {
      this.PpL = new i(this.PpH);
      this.PpL.gKK();
      gPT();
      AppMethodBeat.o(35322);
      return true;
    }
    com.tencent.mm.ui.chatting.d.b.d locald;
    Object localObject1;
    int i;
    if ((paramas != null) && (paramas.gBM()))
    {
      locald = (com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class);
      if (locald.gOM() != null)
      {
        localObject1 = locald.gOM().cG(false);
        if (localObject1 != null)
        {
          if (((c.b)localObject1).dhz != null) {
            ((c.b)localObject1).dhB = "1".equals(((c.b)localObject1).dhz.optString("IsHideInputToolbarInMsg"));
          }
          if (((c.b)localObject1).dhB)
          {
            Log.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + paramas.field_username + " is hide tool bar");
            gPV();
            AppMethodBeat.o(35322);
            return false;
          }
        }
        if ((!Util.isNullOrNil(paramas.field_username)) && (localObject1 != null))
        {
          i = this.dom.Pwc.getIntExtra("key_temp_session_show_type", 0);
          switch (((c.b)localObject1).UX())
          {
          default: 
            gPU();
            paramas = paramas.field_username;
            if (localObject1 == null) {
              break;
            }
          }
        }
      }
    }
    for (bool1 = true;; bool1 = false)
    {
      Log.e("MicroMsg.ChattingUI.FootComponent", "bizinfo name=%s, %b, %d", new Object[] { paramas, Boolean.valueOf(bool1), Integer.valueOf(((c.b)localObject1).UX()) });
      for (;;)
      {
        AppMethodBeat.o(35322);
        return true;
        Log.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + paramas.field_username + " is show custom menu");
        if (this.PpH == null)
        {
          l.a(this.dom.Pwc, 2131305224);
          this.PpH = ((ChatFooterCustom)this.dom.findViewById(2131305226));
          if (this.PpH != null) {
            this.PpH.M((ViewGroup)this.dom.findViewById(2131298413));
          }
        }
        localObject1 = ((c.b)localObject1).Ve();
        try
        {
          Iterator localIterator = ((c.b.c)localObject1).dij.iterator();
          while (localIterator.hasNext())
          {
            Object localObject2 = (k)localIterator.next();
            if (!Util.isNullOrNil(((k)localObject2).egX)) {
              ((com.tencent.mm.plugin.brandservice.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.e.class)).a(((k)localObject2).egX, -1, "", Util.nullAs(((k)localObject2).name, ""), "", "", 4);
            }
            if (!Util.isNullOrNil(((k)localObject2).value)) {
              ((com.tencent.mm.plugin.brandservice.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.e.class)).a(((k)localObject2).value, -1, "", Util.nullAs(((k)localObject2).name, ""), "", "", 4);
            }
            localObject2 = ((k)localObject2).iOs.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              k localk = (k)((Iterator)localObject2).next();
              if (!Util.isNullOrNil(localk.egX)) {
                ((com.tencent.mm.plugin.brandservice.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.e.class)).a(localk.egX, -1, "", Util.nullAs(localk.name, ""), "", "", 4);
              }
              if (!Util.isNullOrNil(localk.value)) {
                ((com.tencent.mm.plugin.brandservice.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.e.class)).a(localk.value, -1, "", Util.nullAs(localk.name, ""), "", "", 4);
              }
            }
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.ChattingUI.FootComponent", localException, "preauth when chat foot", new Object[0]);
          if ((localObject1 != null) && (((c.b.c)localObject1).type == 1))
          {
            this.znD.setSwitchButtonMode(1);
            this.znD.setOnFooterSwitchListener(((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOT());
            gPU();
          }
          else
          {
            this.znD.setSwitchButtonMode(0);
            try
            {
              if (!ab.IJ(paramas.field_username)) {
                break label1060;
              }
              this.PpK = new com.tencent.mm.ui.chatting.x(this.PpH);
              this.PpK.gKK();
              gPT();
            }
            catch (Exception paramas)
            {
              if (localObject1 == null) {
                break label1040;
              }
            }
            if ((((c.b.c)localObject1).dij == null) || (((c.b.c)localObject1).dij.size() == 0)) {
              label1040:
              gPU();
            }
          }
        }
      }
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ChattingUI.FootComponent", paramas, "", new Object[0]);
        break;
        label1060:
        ChatFooterCustom localChatFooterCustom = this.PpH;
        if ((localChatFooterCustom.PeN != null) && (localChatFooterCustom.PeM != null))
        {
          localChatFooterCustom.PeN.setVisibility(0);
          localChatFooterCustom.PeM.setVisibility(0);
        }
        if (localChatFooterCustom.PeO != null) {
          localChatFooterCustom.PeO.gNq();
        }
        this.PpH.setTalker(this.dom.GUe);
        this.PpH.a(this.dom.Pwc, locald.gOM(), paramas.field_username);
        this.PpH.setOnFooterSwitchListener(this.KiE);
        this.PpH.setOnProcessClickListener(((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOS());
        this.znD.setOnFooterSwitchListener(this.KiE);
        if ((((ae)this.dom.bh(ae.class)).gQM()) && (i == 1))
        {
          gPU();
          break;
        }
        gPT();
        break;
        this.KiE.An(true);
      }
    }
  }
  
  public final void cFx()
  {
    AppMethodBeat.i(35334);
    this.PpN = this.dom.Pwc.getStringExtra("smiley_product_id");
    if (this.znD.xfU) {
      ((com.tencent.mm.ui.chatting.d.b.ao)this.dom.bh(com.tencent.mm.ui.chatting.d.b.ao.class)).keepSignalling();
    }
    if ((ab.IW(this.dom.getTalkerUserName())) && (this.PpJ != null) && (this.PpJ.Pid)) {
      this.PpJ.gNS();
    }
    ChatFooter localChatFooter = this.znD;
    BaseChattingUIFragment localBaseChattingUIFragment = this.dom.Pwc;
    localChatFooter.Kjx = localBaseChattingUIFragment;
    localChatFooter.a(localBaseChattingUIFragment.getContext(), localBaseChattingUIFragment.thisActivity());
    if ((localChatFooter.KjY != null) && (localChatFooter.KjY.isShowing())) {
      localChatFooter.KjY.dismiss();
    }
    localChatFooter.ECK.refresh(((PluginWebSearch)com.tencent.mm.kernel.g.ah(PluginWebSearch.class)).isUseSysEditText());
    if ((!Util.isNullOrNil(this.PpN)) && (this.znD != null))
    {
      Log.d("MicroMsg.ChattingUI.FootComponent", "deal use smiley panel in product: %s", new Object[] { this.PpN });
      this.znD.setDefaultSmileyByDetail(this.PpN);
      this.znD.gqo();
    }
    this.dom.Pwc.getContext().getIntent().putExtra("smiley_product_id", "");
    this.znD.setUserName(this.dom.getTalkerUserName());
    com.tencent.mm.live.d.e.hTN = this.dom.getTalkerUserName();
    this.znD.mC(this.dom.gRI(), this.dom.getTalkerUserName());
    if (this.dom.Pwc.getBooleanExtra("key_show_bottom_app_panel", false).booleanValue())
    {
      localChatFooter = this.znD;
      if (localChatFooter.Kir != null)
      {
        localChatFooter.Kir.performClick();
        Log.d("MicroMsg.ChatFooter", "perform click attach bt to show bottom panel");
      }
    }
    if (au(this.dom.GUe))
    {
      if (this.znD != null)
      {
        bg.aVF();
        bool1 = ((Boolean)com.tencent.mm.model.c.azQ().get(66832, Boolean.FALSE)).booleanValue();
        Log.d("MicroMsg.ChattingUI.FootComponent", "jacks refresh Footer Plugin Setting , Enable Enter Button: %B", new Object[] { Boolean.valueOf(bool1) });
        this.znD.gqS();
        if (bool1)
        {
          this.znD.gqF();
          this.znD.gql();
        }
        if (bool1) {
          this.znD.gqu();
        }
        localChatFooter = this.znD;
        if (localChatFooter.Kik != null) {
          localChatFooter.Kik.gpL();
        }
      }
      ((ar)this.dom.bh(ar.class)).gPJ();
      if (this.znD != null)
      {
        this.znD.Kik.refresh();
        this.znD.addTextChangedListener(new a((byte)0));
        Log.i("MicroMsg.ChattingUI.FootComponent", "addTextChangedListener");
      }
    }
    boolean bool1 = ((am)this.dom.bh(am.class)).gRa();
    boolean bool2 = ((am)this.dom.bh(am.class)).gQZ();
    boolean bool3 = ((com.tencent.mm.ui.chatting.d.b.l)this.dom.bh(com.tencent.mm.ui.chatting.d.b.l.class)).gPB();
    boolean bool4 = ab.IN(this.dom.getTalkerUserName());
    boolean bool5 = ((ai)this.dom.bh(ai.class)).gQN();
    if (((!bool1) && (!bool2) && (!bool3)) || ((this.PpR) && (this.dom.GUe != null) && (!this.dom.GUe.gBM()) && (!ab.Jz(this.dom.getTalkerUserName())) && (!com.tencent.mm.ui.widget.snackbar.b.bJw()) && (!ab.IP(this.dom.getTalkerUserName())) && (!bool4) && (!bool5)))
    {
      Log.i("MicroMsg.ChattingUI.FootComponent", "call visibleFooter again.");
      gPU();
    }
    for (;;)
    {
      this.gsT.alive();
      this.gsS.alive();
      AppMethodBeat.o(35334);
      return;
      Log.i("MicroMsg.ChattingUI.FootComponent", "no call visibleFooter again.");
    }
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(35335);
    Object localObject;
    if (this.znD != null)
    {
      localObject = this.znD;
      if (((ChatFooter)localObject).KkX != null)
      {
        ((ChatFooter)localObject).ECK.removeTextChangedListener(((ChatFooter)localObject).KkX);
        ((ChatFooter)localObject).KkX = null;
      }
      Log.i("MicroMsg.ChattingUI.FootComponent", "removeTextChangeListener");
      this.znD.onPause();
      this.gsT.dead();
      this.gsS.dead();
      if (!com.tencent.mm.kernel.g.aAc())
      {
        Log.w("MicroMsg.ChattingUI.FootComponent", "account not ready");
        AppMethodBeat.o(35335);
      }
    }
    else
    {
      AppMethodBeat.o(35335);
      return;
    }
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(18, Integer.valueOf(this.znD.getMode()));
    Log.d("MicroMsg.ChattingUI.FootComponent", "dkcm old:%d footer:%d ", new Object[] { Integer.valueOf(this.PpI), Integer.valueOf(this.znD.getMode()) });
    if (this.PpI != this.znD.getMode())
    {
      this.PpI = this.znD.getMode();
      bg.aVF();
      localObject = com.tencent.mm.model.c.aST().bjY(this.dom.getTalkerUserName());
      if ((localObject != null) && (this.dom.getTalkerUserName().equals(((bb)localObject).field_username)))
      {
        ((az)localObject).nu(this.PpI);
        bg.aVF();
        com.tencent.mm.model.c.aST().a((az)localObject, this.dom.getTalkerUserName());
      }
    }
    this.znD.a(ChatFooter.h.Kmx);
    AppMethodBeat.o(35335);
  }
  
  public final void gIk()
  {
    AppMethodBeat.i(233103);
    this.PpR = this.dom.Pwc.getBooleanExtra("show_footer", false).booleanValue();
    AppMethodBeat.o(233103);
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(35333);
    this.PpS = false;
    this.PpT = false;
    this.PpU = 0L;
    bg.aVF();
    Object localObject1 = com.tencent.mm.model.c.aST().bjY(this.dom.getTalkerUserName());
    if (localObject1 != null) {
      this.PpI = ((bb)localObject1).field_chatmode;
    }
    Log.d("MicroMsg.ChattingUI.FootComponent", "dkcm init old:%d   ", new Object[] { Integer.valueOf(this.PpI) });
    localObject1 = this.dom.getTalkerUserName();
    if (this.znD == null)
    {
      this.znD = ((ChatFooter)this.dom.findViewById(2131305225));
      this.znD.a(new ChatFooter.b()
      {
        public final String getTalkerUserName()
        {
          AppMethodBeat.i(35307);
          String str = x.this.dom.getTalkerUserName();
          AppMethodBeat.o(35307);
          return str;
        }
        
        public final com.tencent.mm.ui.chatting.i.b grp()
        {
          return x.this.dom.Pwa;
        }
        
        public final com.tencent.mm.ui.chatting.e.a grq()
        {
          return x.this.dom;
        }
      });
      ((t)this.dom.bh(t.class)).bD(this.znD);
      gPZ();
    }
    this.znD.setCattingRootLayoutId(2131298408);
    Log.i("MicroMsg.ChattingUI.FootComponent", "resetFooter customFooter is %s", new Object[] { this.PpH });
    if (this.PpH != null)
    {
      this.PpH.gNk();
      this.PpH.setOnFooterSwitchListener(null);
      this.PpH.setOnProcessClickListener(null);
      this.znD.setOnFooterSwitchListener(null);
      this.PpH.gNn();
    }
    gPV();
    this.znD.gqt();
    boolean bool1 = ((am)this.dom.bh(am.class)).gRa();
    boolean bool2 = ((am)this.dom.bh(am.class)).gQZ();
    boolean bool3 = ((ai)this.dom.bh(ai.class)).gQN();
    int i;
    if ((!this.PpR) && ((bool1) || (bool2) || (bool3)))
    {
      gPV();
      gPQ();
      this.PpG = new q(this.dom, this.znD, this.dom.getTalkerUserName());
      this.PpG.PgY = this.dom.Pwc.getBooleanExtra("key_need_send_video", true).booleanValue();
      this.znD.setFooterEventListener(this.PpG);
      localObject1 = new w(this.dom, this.dom.GUe, this.dom.getTalkerUserName());
      this.znD.setSmileyPanelCallback((com.tencent.mm.pluginsdk.ui.chat.f)localObject1);
      this.znD.setSmileyPanelCallback2((com.tencent.mm.pluginsdk.ui.chat.j)localObject1);
      gPY();
      this.znD.gql();
      i = this.dom.Pwc.getIntExtra("key_temp_session_show_type", 0);
      localObject1 = (ae)this.dom.bh(ae.class);
      Log.i("MicroMsg.ChattingUI.FootComponent", "isTempSession : %s, showType : %d.", new Object[] { Boolean.valueOf(((ae)localObject1).gQM()), Integer.valueOf(i) });
      Log.d("MicroMsg.ChattingUI.FootComponent", "is temp session : %s.", new Object[] { Boolean.valueOf(((ae)localObject1).gQM()) });
      if (((ae)localObject1).gQM())
      {
        if (i != 1) {
          break label1622;
        }
        this.KiE.An(true);
      }
    }
    for (;;)
    {
      au(this.dom.GUe);
      com.tencent.mm.kernel.g.aAi();
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().add(this);
      ((PluginOpenIM)com.tencent.mm.kernel.g.ah(PluginOpenIM.class)).getWordingInfoStg().add(this);
      AppMethodBeat.o(35333);
      return;
      if (ab.IW((String)localObject1))
      {
        gPV();
        l.a(this.dom.Pwc, 2131305224);
        if (this.PpH == null)
        {
          i = 1;
          this.PpH = ((ChatFooterCustom)this.dom.findViewById(2131305226));
          if (i != 0) {
            this.PpH.M((ViewGroup)this.dom.findViewById(2131298413));
          }
          this.PpJ = new com.tencent.mm.ui.chatting.u(this.PpH);
          localObject1 = this.PpJ;
          if (ChannelUtil.channelId != 1) {
            break label903;
          }
          i = 1;
          label720:
          ((com.tencent.mm.ui.chatting.u)localObject1).PhX.findViewById(2131298443).setVisibility(8);
          ((com.tencent.mm.ui.chatting.u)localObject1).rmL = ((LinearLayout)((com.tencent.mm.ui.chatting.u)localObject1).PhX.findViewById(2131298438));
          ((com.tencent.mm.ui.chatting.u)localObject1).PhX.findViewById(2131298437).setVisibility(8);
          localObject2 = ((com.tencent.mm.ui.chatting.u)localObject1).rmL;
          if (i == 0) {
            break label908;
          }
        }
        label903:
        label908:
        for (float f = 1.0F;; f = 2.0F)
        {
          ((LinearLayout)localObject2).setWeightSum(f);
          ((com.tencent.mm.ui.chatting.u)localObject1).PhY = ((FrameLayout)((com.tencent.mm.ui.chatting.u)localObject1).rmL.getChildAt(0));
          ((com.tencent.mm.ui.chatting.u)localObject1).PhY.setVisibility(0);
          ((com.tencent.mm.ui.chatting.u)localObject1).PhY.setOnClickListener(((com.tencent.mm.ui.chatting.u)localObject1).Pig);
          ((TextView)((com.tencent.mm.ui.chatting.u)localObject1).PhY.findViewById(2131298440)).setText(2131757280);
          ((com.tencent.mm.ui.chatting.u)localObject1).PhY.findViewById(2131298439).setVisibility(8);
          if (i == 0) {
            break label913;
          }
          i = 1;
          while (i < 6)
          {
            ((com.tencent.mm.ui.chatting.u)localObject1).rmL.getChildAt(i).setVisibility(8);
            i += 1;
          }
          i = 0;
          break;
          i = 0;
          break label720;
        }
        label913:
        ((com.tencent.mm.ui.chatting.u)localObject1).PhZ = ((FrameLayout)((com.tencent.mm.ui.chatting.u)localObject1).rmL.getChildAt(1));
        ((com.tencent.mm.ui.chatting.u)localObject1).PhZ.setVisibility(0);
        ((com.tencent.mm.ui.chatting.u)localObject1).PhZ.setOnClickListener(((com.tencent.mm.ui.chatting.u)localObject1).Pih);
        ((com.tencent.mm.ui.chatting.u)localObject1).Pia = ((TextView)((com.tencent.mm.ui.chatting.u)localObject1).PhZ.findViewById(2131298440));
        ((com.tencent.mm.ui.chatting.u)localObject1).Pib = ((ImageView)((com.tencent.mm.ui.chatting.u)localObject1).PhZ.findViewById(2131298439));
        ((com.tencent.mm.ui.chatting.u)localObject1).Pib.setVisibility(0);
        ((com.tencent.mm.ui.chatting.u)localObject1).gNR();
        bg.aVF();
        ((com.tencent.mm.ui.chatting.u)localObject1).xXB = ((Integer)com.tencent.mm.model.c.azQ().get(ar.a.NTG, Integer.valueOf(-1))).intValue();
        if (((com.tencent.mm.ui.chatting.u)localObject1).xXB >= 0) {
          ((com.tencent.mm.ui.chatting.u)localObject1).gNT();
        }
        for (;;)
        {
          i = 2;
          while (i < 6)
          {
            ((com.tencent.mm.ui.chatting.u)localObject1).rmL.getChildAt(i).setVisibility(8);
            i += 1;
          }
          ((com.tencent.mm.ui.chatting.u)localObject1).Pia.setText(2131757293);
        }
        ((com.tencent.mm.ui.chatting.u)localObject1).Pif = com.tencent.mm.n.h.aqK().getMailAppEnterUlAndroid();
        if (Util.isNullOrNil(((com.tencent.mm.ui.chatting.u)localObject1).Pif)) {
          ((com.tencent.mm.ui.chatting.u)localObject1).Pif = "qqmail://folderlist?app=weixin&action=list&uin=$uin$";
        }
        bg.aVF();
        localObject2 = new com.tencent.mm.b.p(Util.nullAsNil((Integer)com.tencent.mm.model.c.azQ().get(9, null))).toString();
        ((com.tencent.mm.ui.chatting.u)localObject1).Pif = ((com.tencent.mm.ui.chatting.u)localObject1).Pif.replace("$uin$", (CharSequence)localObject2);
        ((com.tencent.mm.ui.chatting.u)localObject1).Bxl = com.tencent.mm.n.h.aqK().aqC();
        ((com.tencent.mm.ui.chatting.u)localObject1).Pid = true;
        gPT();
        break;
      }
      this.PpJ = null;
      if (ab.IJ((String)localObject1))
      {
        gPV();
        l.a(this.dom.Pwc, 2131305224);
        if (this.PpH == null) {}
        for (i = 1;; i = 0)
        {
          this.PpH = ((ChatFooterCustom)this.dom.findViewById(2131305226));
          if (i != 0) {
            this.PpH.M((ViewGroup)this.dom.findViewById(2131298413));
          }
          this.PpK = new com.tencent.mm.ui.chatting.x(this.PpH);
          this.PpK.gKK();
          gPT();
          break;
        }
      }
      this.PpK = null;
      if (ab.IP((String)localObject1))
      {
        gPV();
        l.a(this.dom.Pwc, 2131305224);
        if (this.PpH == null) {}
        for (i = 1;; i = 0)
        {
          this.PpH = ((ChatFooterCustom)this.dom.findViewById(2131305226));
          if (i != 0) {
            this.PpH.M((ViewGroup)this.dom.findViewById(2131298413));
          }
          this.PpL = new i(this.PpH);
          this.PpL.gKK();
          gPT();
          break;
        }
      }
      this.PpL = null;
      if ((!ab.IX((String)localObject1)) && (!ab.IJ((String)localObject1)) && (!ab.IW((String)localObject1)) && (!ab.IP((String)localObject1)))
      {
        ab.aUW();
        if ((!ab.Jx((String)localObject1)) && (!ab.IN((String)localObject1)) && (!ab.JC((String)localObject1))) {}
      }
      else
      {
        gPV();
        break;
      }
      gPU();
      au(this.dom.GUe);
      this.znD.setUserName((String)localObject1);
      this.znD.mC(this.dom.gRI(), this.dom.getTalkerUserName());
      bmK((String)localObject1);
      localObject1 = (com.tencent.mm.ui.chatting.d.b.l)this.dom.bh(com.tencent.mm.ui.chatting.d.b.l.class);
      Object localObject2 = (am)this.dom.bh(am.class);
      if (!((com.tencent.mm.ui.chatting.d.b.l)localObject1).gPB()) {
        break;
      }
      if (((am)localObject2).gQX())
      {
        ((am)localObject2).gQW();
        ((com.tencent.mm.ui.chatting.d.b.l)localObject1).gPC();
        break;
      }
      ((com.tencent.mm.ui.chatting.d.b.l)localObject1).gPz();
      break;
      label1622:
      this.KiE.An(false);
    }
  }
  
  public final void gIm() {}
  
  public final void gIn() {}
  
  public final void gOK()
  {
    AppMethodBeat.i(35332);
    super.gOK();
    if (this.znD != null)
    {
      this.znD.setFooterEventListener(null);
      q localq = this.PpG;
      CaptureDataManager.BOb.BOa = null;
      if (localq.PgS != null)
      {
        localq.PgS.a(null);
        localq.PgS.a(null);
      }
      this.PpG = null;
      this.znD.setSmileyPanelCallback(null);
      this.znD.setSmileyPanelCallback2(null);
    }
    if (this.PpH != null)
    {
      this.PpH.gNk();
      this.PpH = null;
    }
    gPQ();
    if (this.PpH != null) {
      this.PpH.gNn();
    }
    com.tencent.mm.pluginsdk.ui.span.l.clearCache();
    if (this.znD != null) {
      this.znD.gqO();
    }
    if ((this.dom.Pwc.isCurrentActivity) && (this.znD != null)) {
      this.znD.destroy();
    }
    com.tencent.mm.kernel.g.aAi();
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().remove(this);
    ((PluginOpenIM)com.tencent.mm.kernel.g.ah(PluginOpenIM.class)).getWordingInfoStg().remove(this);
    AppMethodBeat.o(35332);
  }
  
  public final ChatFooter gPO()
  {
    return this.znD;
  }
  
  public final ChatFooterCustom gPP()
  {
    return this.PpH;
  }
  
  public final String gPR()
  {
    return this.PpN;
  }
  
  public final void gPS()
  {
    AppMethodBeat.i(35316);
    try
    {
      if (this.znD.gqJ()) {
        this.znD.setBottomPanelVisibility(8);
      }
      AppMethodBeat.o(35316);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(35316);
    }
  }
  
  public final void gPT()
  {
    AppMethodBeat.i(35317);
    this.dom.hideVKB();
    Log.i("MicroMsg.ChattingUI.FootComponent", "visibleCustomFooter customFooter is %s", new Object[] { this.PpH });
    if (this.PpH == null)
    {
      AppMethodBeat.o(35317);
      return;
    }
    this.PpH.setVisibility(0);
    if (this.znD != null)
    {
      this.znD.Ak(false);
      this.znD.setVisibility(8);
    }
    AppMethodBeat.o(35317);
  }
  
  public final void gPU()
  {
    AppMethodBeat.i(35318);
    if (this.znD == null)
    {
      AppMethodBeat.o(35318);
      return;
    }
    this.znD.setVisibility(0);
    if (this.PpH != null) {
      this.PpH.setVisibility(8);
    }
    AppMethodBeat.o(35318);
  }
  
  public final void gPW()
  {
    AppMethodBeat.i(35320);
    this.PpM = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.PpM.setInterpolator(new DecelerateInterpolator(1.5F));
    this.PpM.addAnimation(localTranslateAnimation);
    this.PpM.addAnimation(localAlphaAnimation);
    this.PpM.setDuration(300L);
    this.PpM.setFillBefore(true);
    if (this.znD != null) {
      this.znD.startAnimation(this.PpM);
    }
    AppMethodBeat.o(35320);
  }
  
  public final void gPX()
  {
    AppMethodBeat.i(35321);
    Log.i("MicroMsg.ChattingUI.FootComponent", "triggerFooter, originChatFooterVisibility:%s", new Object[] { Integer.valueOf(this.PpO) });
    if (this.znD == null)
    {
      this.znD = ((ChatFooter)this.dom.findViewById(2131305225));
      this.znD.a(new ChatFooter.b()
      {
        public final String getTalkerUserName()
        {
          AppMethodBeat.i(35306);
          String str = x.this.dom.getTalkerUserName();
          AppMethodBeat.o(35306);
          return str;
        }
        
        public final com.tencent.mm.ui.chatting.i.b grp()
        {
          return x.this.dom.Pwa;
        }
        
        public final com.tencent.mm.ui.chatting.e.a grq()
        {
          return x.this.dom;
        }
      });
      ((t)this.dom.bh(t.class)).bD(this.znD);
      gPZ();
    }
    boolean bool1 = ((com.tencent.mm.ui.chatting.d.b.l)this.dom.bh(com.tencent.mm.ui.chatting.d.b.l.class)).gPB();
    boolean bool2 = ((ai)this.dom.bh(ai.class)).gQN();
    if ((bool1) || (bool2) || (com.tencent.mm.ui.widget.snackbar.b.bJw()))
    {
      if (!this.PpQ) {
        this.PpO = this.znD.getVisibility();
      }
      this.znD.Ak(true);
      if (this.PpH != null) {
        if (this.PpQ) {}
      }
      for (this.PpP = this.PpH.getVisibility();; this.PpP = -1)
      {
        gPV();
        this.PpQ = true;
        AppMethodBeat.o(35321);
        return;
      }
    }
    this.PpQ = false;
    if ((this.PpO == 8) && (this.PpP == 8))
    {
      gPV();
      AppMethodBeat.o(35321);
      return;
    }
    if (this.PpO == 0)
    {
      gPU();
      AppMethodBeat.o(35321);
      return;
    }
    gPT();
    AppMethodBeat.o(35321);
  }
  
  public final void gPY()
  {
    AppMethodBeat.i(35324);
    String str = this.dom.getTalkerUserName();
    int i;
    if ((ab.IY(str)) || (as.bjm(str))) {
      i = 1;
    }
    while (i == 2)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.dom.Pwc.getContext(), "android.permission.RECORD_AUDIO", 80, "", "");
      Log.i("MicroMsg.ChattingUI.FootComponent", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.dom.Pwc.getContext() });
      if (bool) {
        break;
      }
      this.znD.bA(1, false);
      AppMethodBeat.o(35324);
      return;
      if (ab.Jp(str))
      {
        i = 2;
      }
      else
      {
        int j = this.dom.Pwc.getIntExtra("Chat_Mode", 0);
        Log.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", new Object[] { Integer.valueOf(this.PpI), Integer.valueOf(j) });
        if (this.PpI != 0) {
          j = this.PpI;
        }
        str = com.tencent.mm.n.h.aqJ().getValue("DefaultMsgType");
        i = j;
        if (this.PpI == 0)
        {
          i = j;
          if (str != null)
          {
            Log.d("MicroMsg.ChattingUI.FootComponent", "config def chatmode is %s", new Object[] { str });
            i = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("DefaultMsgType"), 0);
          }
        }
        j = i;
        if (i == 0)
        {
          j = i;
          if (com.tencent.mm.contact.c.oR(this.dom.GUe.field_type))
          {
            bg.aVF();
            j = ((Integer)com.tencent.mm.model.c.azQ().get(18, Integer.valueOf(0))).intValue();
          }
        }
        i = j;
        if (j == 0) {
          i = 1;
        }
        Log.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", new Object[] { Integer.valueOf(this.PpI), Integer.valueOf(i) });
      }
    }
    this.znD.bA(i, false);
    AppMethodBeat.o(35324);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35329);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((1111 == paramInt1) && (-1 == paramInt2)) {
      this.znD.gqo();
    }
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 200) || (paramInt1 == 201) || (paramInt1 == 203)) {
        this.znD.clearFocus();
      }
      AppMethodBeat.o(35329);
      return;
    }
    if ((paramInt1 != 217) && (this.PpH != null)) {
      this.PpH.s(paramInt1, paramIntent);
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
        Log.e("MicroMsg.ChattingUI.FootComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
        AppMethodBeat.o(35329);
        return;
      }
      paramInt1 = paramIntent.getIntExtra("Chat_Mode", 1);
      if (this.znD != null) {
        this.znD.setMode(paramInt1);
      }
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int j = 0;
    AppMethodBeat.i(35331);
    Log.i("MicroMsg.ChattingUI.FootComponent", "chatting onKeyDown, code:%d action:%d", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    if (paramKeyEvent.getKeyCode() == 4) {
      if (!this.dom.cQp) {
        Log.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown back key fragment not foreground");
      }
    }
    for (;;)
    {
      int i = 0;
      for (;;)
      {
        if (i != 0) {
          break label474;
        }
        boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
        AppMethodBeat.o(35331);
        return bool;
        if ((this.dom.Pwc.isSupportNavigationSwipeBack()) && (this.dom.Pwc.getSwipeBackLayout().gqI()))
        {
          Log.w("MicroMsg.ChattingUI.FootComponent", "ashutest::onKeyDown back ScrollToFinishing");
          i = 1;
        }
        else
        {
          if (paramKeyEvent.getAction() == 0)
          {
            this.PpS = true;
            this.PpU = System.currentTimeMillis();
          }
          if (paramKeyEvent.getAction() != 1) {
            break label356;
          }
          Log.d("MicroMsg.ChattingUI.FootComponent", "hasBack %B, %d", new Object[] { Boolean.valueOf(this.PpS), Long.valueOf(System.currentTimeMillis() - this.PpU) });
          if ((this.PpS) && (System.currentTimeMillis() - this.PpU <= 30000L)) {
            break;
          }
          i = 1;
        }
      }
      this.PpT = true;
      Object localObject = (com.tencent.mm.ui.chatting.d.b.l)this.dom.bh(com.tencent.mm.ui.chatting.d.b.l.class);
      am localam = (am)this.dom.bh(am.class);
      if (((com.tencent.mm.ui.chatting.d.b.l)localObject).gPB()) {
        if (localam.gQX())
        {
          localam.gQW();
          ((com.tencent.mm.ui.chatting.d.b.l)localObject).gPC();
          label291:
          i = 1;
          label293:
          if (i == 0) {
            if (this.znD != null)
            {
              localObject = this.znD;
              if ((((ChatFooter)localObject).KiY == 0) && (!((ChatFooter)localObject).Kds)) {
                break label385;
              }
              if (!((ChatFooter)localObject).Kds) {
                break label376;
              }
              ((ChatFooter)localObject).gpb();
              label339:
              i = 1;
            }
          }
        }
      }
      for (;;)
      {
        if (i == 0) {
          this.dom.Pwc.gNh();
        }
        label356:
        i = 1;
        break;
        ((com.tencent.mm.ui.chatting.d.b.l)localObject).gPz();
        break label291;
        i = 0;
        break label293;
        label376:
        ((ChatFooter)localObject).Ak(true);
        break label339;
        label385:
        i = j;
        if (((ChatFooter)localObject).Kkr != null)
        {
          i = j;
          if (((ChatFooter)localObject).Kkr.getVisibility() == 0)
          {
            ((ChatFooter)localObject).Kkr.fAy();
            i = 1;
          }
        }
      }
      if ((paramKeyEvent.getKeyCode() == 67) && (!this.dom.cQp)) {
        Log.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown back key fragment not foreground");
      } else if (!this.dom.cQp) {
        Log.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown fragment not foreground");
      }
    }
    label474:
    AppMethodBeat.o(35331);
    return true;
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(35327);
    if (paramObject != null) {
      paramObject.equals("");
    }
    Log.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", new Object[] { paramObject, this.dom.getTalkerUserName() });
    if (paramObject.equals(this.dom.getTalkerUserName()))
    {
      bmK(this.dom.getTalkerUserName());
      gPY();
    }
    AppMethodBeat.o(35327);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(35328);
    if (paramString != null) {
      paramString.equals("");
    }
    Log.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", new Object[] { paramString, this.dom.getTalkerUserName() });
    if (ab.Iy(this.dom.getTalkerUserName()))
    {
      bmK(this.dom.getTalkerUserName());
      gPY();
    }
    AppMethodBeat.o(35328);
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
        Log.w("MicroMsg.ChattingUI.FootComponent", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, Util.getStack() });
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
        Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doFooterLiveRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.PpG, Util.getStack() });
        if (this.PpG != null) {
          this.PpG.zon.eij();
        }
        AppMethodBeat.o(35330);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131763864;; paramInt = 2131763876)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(paramInt), this.dom.Pwc.getMMResources().getString(2131763890), this.dom.Pwc.getMMResources().getString(2131762043), this.dom.Pwc.getMMResources().getString(2131756929), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35311);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = x.this.dom.Pwc;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/component/FootComponent$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
        Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doFooterSightRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.PpG, Util.getStack() });
        if (this.PpG != null)
        {
          paramArrayOfString = this.PpG;
          if (!this.znD.Kik.KgQ.KhF.value) {
            break label446;
          }
        }
        label446:
        for (paramInt = i;; paramInt = 2)
        {
          paramArrayOfString.ami(paramInt);
          AppMethodBeat.o(35330);
          return;
        }
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131763864;; paramInt = 2131763876)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(paramInt), this.dom.Pwc.getMMResources().getString(2131763890), this.dom.Pwc.getMMResources().getString(2131762043), this.dom.Pwc.getMMResources().getString(2131756929), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35302);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = x.this.dom.Pwc;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/component/FootComponent$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
          Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuVideoSelected,footerEventImpl[%s], stack[%s]", new Object[] { this.PpG, Util.getStack() });
          if (this.PpG != null) {
            this.PpG.eEL();
          }
          AppMethodBeat.o(35330);
          return;
        }
        if (paramInt == 21)
        {
          Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.PpG, Util.getStack() });
          if (this.PpG != null) {
            this.PpG.gNM();
          }
          AppMethodBeat.o(35330);
          return;
        }
        Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnEnterMultiTalk,footerEventImpl[%s], stack[%s]", new Object[] { this.PpG, Util.getStack() });
        if (this.PpG != null) {
          this.PpG.gNK();
        }
        AppMethodBeat.o(35330);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131763864;; paramInt = 2131763876)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(paramInt), this.dom.Pwc.getMMResources().getString(2131763890), this.dom.Pwc.getMMResources().getString(2131762043), this.dom.Pwc.getMMResources().getString(2131756929), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(163307);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = x.this.dom.Pwc;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/component/FootComponent$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
        Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doImageSelectTakePhotoRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.PpG, Util.getStack() });
        if (this.PpG != null) {
          this.PpG.gNO();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131763864), this.dom.Pwc.getMMResources().getString(2131763890), this.dom.Pwc.getMMResources().getString(2131762043), this.dom.Pwc.getMMResources().getString(2131756929), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(169867);
          paramAnonymousDialogInterface = x.this.dom.Pwc;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/component/FootComponent$15", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$15", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(169867);
        }
      }, null);
      AppMethodBeat.o(35330);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doTalkRoomRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.PpG, Util.getStack() });
        if (this.PpG != null) {
          this.PpG.gNN();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131763874), this.dom.Pwc.getMMResources().getString(2131763890), this.dom.Pwc.getMMResources().getString(2131762043), this.dom.Pwc.getMMResources().getString(2131756929), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(184958);
          paramAnonymousDialogInterface = x.this.dom.Pwc;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/component/FootComponent$16", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
          Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuAudioSelected,footerEventImpl[%s], stack[%s]", new Object[] { this.PpG, Util.getStack() });
          if (this.PpG != null) {
            this.PpG.eEK();
          }
          AppMethodBeat.o(35330);
          return;
        }
        Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipAudioRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.PpG, Util.getStack() });
        if (this.PpG != null) {
          this.PpG.gNL();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131763876), this.dom.Pwc.getMMResources().getString(2131763890), this.dom.Pwc.getMMResources().getString(2131762043), this.dom.Pwc.getMMResources().getString(2131756929), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(233100);
          paramAnonymousDialogInterface = x.this.dom.Pwc;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/component/FootComponent$17", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$17", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(233100);
        }
      }, null);
      AppMethodBeat.o(35330);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        Log.i("MicroMsg.ChattingUI.FootComponent", "doSendFileRequest, footerEventImpl[%s], stack[%s].", new Object[] { this.PpG, Util.getStack() });
        if (this.PpG != null) {
          this.PpG.gNI();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131763883), this.dom.Pwc.getMMResources().getString(2131763890), this.dom.Pwc.getMMResources().getString(2131762043), this.dom.Pwc.getMMResources().getString(2131761084), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(233101);
          paramAnonymousDialogInterface = x.this.dom.Pwc;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/component/FootComponent$18", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$18", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(233101);
        }
      }, null);
    }
  }
  
  public final void setVoiceInputShowCallback(ChatFooter.d paramd)
  {
    AppMethodBeat.i(35326);
    this.znD.setVoiceInputShowCallback(paramd);
    AppMethodBeat.o(35326);
  }
  
  final class a
    implements TextWatcher
  {
    private boolean Pqa = false;
    private List<String> Pqb = null;
    
    private a() {}
    
    private static void c(List<String> paramList, String[] paramArrayOfString)
    {
      AppMethodBeat.i(233102);
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if ((str.length() > 0) && (str.substring(str.length() - 1, str.length()).matches("[_0-9a-zA-Z]$"))) {
          paramList.add(str);
        }
        i += 1;
      }
      AppMethodBeat.o(233102);
    }
    
    private boolean hb(String paramString, int paramInt)
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
      if (paramString.substring(paramInt - 1, paramInt).matches("[_0-9a-zA-Z]$"))
      {
        if (this.Pqb == null)
        {
          this.Pqb = new LinkedList();
          localObject = x.this.dom.Pwc.getMMResources().getStringArray(2130903069);
          c(this.Pqb, (String[])localObject);
          localObject = x.this.dom.Pwc.getMMResources().getStringArray(2130903070);
          c(this.Pqb, (String[])localObject);
        }
        paramString = paramString.substring(0, paramInt);
        Object localObject = this.Pqb.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramString.endsWith((String)((Iterator)localObject).next()))
          {
            AppMethodBeat.o(35312);
            return true;
          }
        }
        AppMethodBeat.o(35312);
        return false;
      }
      AppMethodBeat.o(35312);
      return true;
    }
    
    public final void afterTextChanged(Editable paramEditable) {}
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(35313);
      Log.i("MicroMsg.ChattingUI.FootComponent", "[onTextChanged]");
      ((com.tencent.mm.ui.chatting.d.b.ao)x.this.dom.bh(com.tencent.mm.ui.chatting.d.b.ao.class)).amF(1);
      Object localObject1 = (com.tencent.mm.ui.chatting.d.b.d)x.this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class);
      paramCharSequence = String.valueOf(paramCharSequence);
      Object localObject2 = paramCharSequence.substring(paramInt1, paramInt1 + paramInt3);
      Object localObject3;
      Object localObject4;
      if ((x.this.dom.gRL()) && ("@".equals(localObject2)) && (!paramCharSequence.equals(x.this.znD.getLastContent())) && (!x.this.znD.KiH))
      {
        x.this.znD.setLastContent(paramCharSequence);
        x.this.znD.setInsertPos(paramInt1 + 1);
        if (hb(paramCharSequence, paramInt1))
        {
          localObject3 = Util.listToString(v.Ic(x.this.dom.getTalkerUserName()), ",");
          localObject4 = new Intent();
          ((Intent)localObject4).setClass(x.this.dom.Pwc.getContext(), AtSomeoneUI.class);
          ((Intent)localObject4).putExtra("Block_list", z.aTY());
          ((Intent)localObject4).putExtra("Chatroom_member_list", (String)localObject3);
          ((Intent)localObject4).putExtra("Chat_User", x.this.dom.getTalkerUserName());
          ((Intent)localObject4).putExtra("Add_address_titile", x.this.dom.Pwc.getMMString(2131764652));
          x.this.dom.Pwc.startActivityForResult((Intent)localObject4, 212);
        }
        ((an)x.this.dom.bh(an.class)).Q(paramCharSequence, paramInt1, (String)localObject2);
        if ((!((com.tencent.mm.ui.chatting.d.b.d)localObject1).gOP()) && (!as.bjw(x.this.dom.getTalkerUserName())))
        {
          localObject2 = x.this.znD;
          if ((((ChatFooter)localObject2).KiB != null) && (((ChatFooter)localObject2).han != null))
          {
            ((ChatFooter)localObject2).KiB.Knv = true;
            localObject1 = ((ChatFooter)localObject2).KiB;
            localObject2 = ((ChatFooter)localObject2).Kjy.getTalkerUserName();
            if (!Util.isNullOrNil(paramCharSequence)) {
              break label771;
            }
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).mHandler.removeMessages(20003);
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).mHandler.sendEmptyMessage(20001);
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).ygH = paramCharSequence;
            if (((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Knz != null)
            {
              ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Knz.dead();
              ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Knz = null;
            }
          }
        }
      }
      for (;;)
      {
        if ((ab.Eq(x.this.dom.getTalkerUserName())) && (!x.this.znD.gqQ())) {
          x.this.znD.beX(paramCharSequence);
        }
        AppMethodBeat.o(35313);
        return;
        if ((((com.tencent.mm.ui.chatting.d.b.d)localObject1).gOQ()) && ("@".equals(localObject2)) && (!paramCharSequence.equals(x.this.znD.getLastContent())) && (!x.this.znD.KiH))
        {
          x.this.znD.setLastContent(paramCharSequence);
          x.this.znD.setInsertPos(paramInt1 + 1);
          if (!hb(paramCharSequence, paramInt1)) {
            break;
          }
          localObject3 = ((com.tencent.mm.ui.chatting.d.b.d)localObject1).gON().field_userList;
          localObject4 = new Intent();
          ((Intent)localObject4).setClass(x.this.dom.Pwc.getContext(), BizChatAtSomeoneUI.class);
          ((Intent)localObject4).putExtra("Block_list", ag.bal().fC(x.this.dom.getTalkerUserName()));
          ((Intent)localObject4).putExtra("Chatroom_member_list", (String)localObject3);
          ((Intent)localObject4).putExtra("Chat_User", x.this.dom.getTalkerUserName());
          ((Intent)localObject4).putExtra("Add_address_titile", x.this.dom.Pwc.getMMString(2131764652));
          ((Intent)localObject4).putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.d.b.d)x.this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gPc());
          x.this.dom.Pwc.startActivityForResult((Intent)localObject4, 212);
          break;
        }
        if (paramCharSequence.equals(x.this.znD.getLastContent())) {
          break;
        }
        x.this.znD.setLastContent(paramCharSequence);
        break;
        label771:
        if (!paramCharSequence.equals(((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).ygH))
        {
          ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).hide();
          if (((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Knz != null)
          {
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Knz.dead();
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Knz = null;
          }
          ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Knz = new com.tencent.mm.vending.e.c();
          localObject3 = String.valueOf(Util.nowMilliSecond());
          localObject4 = ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).KnA;
          ((jy)localObject4).eiB = ((jy)localObject4).x("SessionId", (String)localObject3, true);
          localObject4 = ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).KnA;
          ((jy)localObject4).ekv = ((jy)localObject4).x("ChatId", (String)localObject2, true);
          ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Knx.clear();
          ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).KnB = 0;
          localObject4 = new com.tencent.mm.emoji.b.c.b(((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Knz);
          kotlin.g.b.p.h(localObject3, "sessionId");
          com.tencent.mm.emoji.b.c.f localf = ((com.tencent.mm.emoji.b.c.b)localObject4).gZo;
          kotlin.g.b.p.h(localObject3, "sessionId");
          localf.username = ((String)localObject2);
          localf.sessionId = ((String)localObject3);
          localObject2 = new m.5((com.tencent.mm.pluginsdk.ui.chat.m)localObject1, Util.nowMilliSecond());
          kotlin.g.b.p.h(paramCharSequence, "desc");
          localObject3 = com.tencent.mm.emoji.b.c.d.gZA;
          com.tencent.mm.emoji.b.c.d.pl(0);
          com.tencent.mm.ac.d.b("EmojiSuggest_searchSuggest", (kotlin.g.a.a)new b.b((com.tencent.mm.emoji.b.c.b)localObject4, paramCharSequence, (j.b)localObject2));
        }
        ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).ygH = paramCharSequence;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.x
 * JD-Core Version:    0.7.0.1
 */