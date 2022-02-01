package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
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
import com.tencent.mm.R.a;
import com.tencent.mm.R.c;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.k;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.c;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.emoji.b.c.b.b;
import com.tencent.mm.emoji.b.c.j.b;
import com.tencent.mm.f.a.si;
import com.tencent.mm.f.a.tx;
import com.tencent.mm.f.a.ty;
import com.tencent.mm.f.b.a.mh;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.PluginOpenIM;
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
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.pluginsdk.ui.chat.m.5;
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
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI;
import com.tencent.mm.ui.chatting.AtSomeoneUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.ap;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.d.b.t;
import com.tencent.mm.ui.chatting.q;
import com.tencent.mm.ui.chatting.w;
import com.tencent.mm.ui.chatting.x;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.view.MaxHeightScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.d.a.a(hRc=com.tencent.mm.ui.chatting.d.b.u.class)
public class y
  extends a
  implements MStorage.IOnStorageChange, MStorageEx.IOnStorageChange, com.tencent.mm.ui.chatting.d.b.u
{
  private static ArrayList<com.tencent.mm.pluginsdk.ui.chat.a.a> WJZ = null;
  private static long WKa = 0L;
  protected ChatFooter ESU;
  private final ChatFooter.g Rjr;
  private q WKb;
  protected ChatFooterCustom WKc;
  private int WKd;
  private com.tencent.mm.ui.chatting.u WKe;
  private x WKf;
  private com.tencent.mm.ui.chatting.i WKg;
  private AnimationSet WKh;
  private String WKi;
  private int WKj;
  private int WKk;
  private boolean WKl;
  public boolean WKm;
  private boolean WKn;
  public boolean WKo;
  private long WKp;
  private IListener iXe;
  private IListener iXf;
  
  public y()
  {
    AppMethodBeat.i(35314);
    this.WKd = 0;
    this.WKi = null;
    this.WKl = false;
    this.WKm = false;
    this.iXe = new IListener() {};
    this.iXf = new IListener() {};
    this.Rjr = new ChatFooter.g()
    {
      private Animation WKr;
      private Animation WKs;
      
      public final boolean Et(boolean paramAnonymousBoolean)
      {
        int i = 1;
        AppMethodBeat.i(35305);
        if (this.WKr == null)
        {
          this.WKr = AnimationUtils.loadAnimation(y.this.fgR.WQv.getContext(), R.a.push_up_in);
          this.WKs = AnimationUtils.loadAnimation(y.this.fgR.WQv.getContext(), R.a.push_down_out);
        }
        com.tencent.mm.ui.chatting.d.b.d locald;
        String str;
        if (paramAnonymousBoolean)
        {
          Log.i("MicroMsg.ChattingUI.FootComponent", "switchFooterToInput customFooter is %s", new Object[] { y.this.WKc });
          if (y.this.WKc != null) {
            y.this.WKc.startAnimation(this.WKs);
          }
          y.this.hPp();
          y.this.ESU.startAnimation(this.WKr);
          y.this.ESU.postInvalidateDelayed(this.WKr.getDuration());
          locald = (com.tencent.mm.ui.chatting.d.b.d)y.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class);
          if (locald != null)
          {
            str = y.this.fgR.getTalkerUserName();
            if (!paramAnonymousBoolean) {
              break label264;
            }
          }
        }
        for (;;)
        {
          locald.hJ(str, i);
          AppMethodBeat.o(35305);
          return false;
          y.this.ESU.startAnimation(this.WKs);
          y.this.hPo();
          if (y.this.WKc == null) {
            break;
          }
          y.this.WKc.startAnimation(this.WKr);
          y.this.WKc.postInvalidateDelayed(this.WKr.getDuration());
          break;
          label264:
          i = 2;
        }
      }
    };
    this.WKn = false;
    this.WKo = false;
    this.WKp = 0L;
    AppMethodBeat.o(35314);
  }
  
  private void a(final String paramString, final az.b.a parama)
  {
    AppMethodBeat.i(163315);
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184961);
        az.a.ltq.a(paramString, "", parama);
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
  
  private void a(String paramString, com.tencent.mm.storage.as paramas, ArrayList<com.tencent.mm.pluginsdk.ui.chat.a.a> paramArrayList)
  {
    AppMethodBeat.i(163316);
    long l1;
    if (paramas == null)
    {
      l1 = 0L;
      Log.i("MicroMsg.ChattingUI.FootComponent", "ChatroomBusinessType user %s %s", new Object[] { paramString, Long.valueOf(l1) });
      if ((!this.fgR.hRh()) || (paramas == null) || (paramas.hDC == 0L)) {
        break label222;
      }
      if (WJZ != null) {
        break label166;
      }
      WJZ = new ArrayList();
      hPv();
      WKa = cm.bfC();
    }
    for (;;)
    {
      paramString = WJZ;
      if ((paramString == null) || (paramString.size() <= 0)) {
        break label222;
      }
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        com.tencent.mm.pluginsdk.ui.chat.a.a locala = (com.tencent.mm.pluginsdk.ui.chat.a.a)paramString.next();
        if ((locala.RiO & paramas.hDC) != 0L)
        {
          locala.fWY = paramas.field_username;
          paramArrayList.add(locala);
        }
      }
      l1 = paramas.hDC;
      break;
      label166:
      l1 = cm.bfC();
      long l2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vSn, 1800);
      if (l1 - WKa > l2)
      {
        WKa = l1;
        WJZ.clear();
        hPv();
      }
    }
    label222:
    this.ESU.setAppPanelUnCertainEnterArrayList(paramArrayList);
    AppMethodBeat.o(163316);
  }
  
  private void bzk(final String paramString)
  {
    AppMethodBeat.i(35325);
    Log.i("MicroMsg.ChattingUI.FootComponent", "initFooterPanelMenu %s", new Object[] { paramString });
    this.ESU.hls();
    this.ESU.hli();
    int i;
    Object localObject1;
    int j;
    label126:
    boolean bool1;
    if (((com.tencent.mm.ui.chatting.d.b.l)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.l.class)).hOT())
    {
      Log.w("MicroMsg.ChattingUI.FootComponent", "match shake, in show mode, do not open short video recode view");
      i = 0;
      if (i == 0) {
        this.ESU.hlu();
      }
      if (((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOe())
      {
        localObject1 = com.tencent.mm.ao.g.gu(this.fgR.getTalkerUserName());
        if ((localObject1 != null) && (((com.tencent.mm.api.c)localObject1).field_enterpriseFather != null)) {
          break label2738;
        }
        j = 0;
        if (j != 0)
        {
          localObject1 = this.ESU.RiU;
          ((AppPanel)localObject1).RhB.Rit.value = true;
          ((AppPanel)localObject1).hkT();
        }
      }
      if (!this.fgR.hRi()) {
        this.ESU.hlD();
      }
      bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vFY, true);
      localObject1 = this.ESU;
      if (!BuildInfo.DEBUG) {
        break label2792;
      }
      i = 1;
      label206:
      Log.i("MicroMsg.ChattingUI.FootComponent", "isGroupChat:%b enableLive:%b", new Object[] { Boolean.valueOf(this.fgR.hRi()), Boolean.valueOf(bool1) });
      if ((this.fgR.hRi()) && (bool1) && (i != 0)) {
        break label3020;
      }
      this.ESU.RiU.hkS();
      label268:
      if (!ab.PP(this.fgR.getTalkerUserName())) {
        this.ESU.RiU.hkS();
      }
      if ((this.fgR.NKq != null) && (!com.tencent.mm.contact.d.rk(this.fgR.NKq.field_type)) && (!ab.Lj(this.fgR.getTalkerUserName()))) {
        this.ESU.hlx();
      }
      if (com.tencent.mm.storage.as.PY(paramString))
      {
        this.ESU.RiU.hkK();
        this.ESU.RiU.hkM();
        this.ESU.RiU.hkN();
        this.ESU.hlv();
        this.ESU.hlw();
        this.ESU.RiU.hkL();
        this.ESU.bj(true, true);
        this.ESU.hlx();
        this.ESU.hlz();
        this.ESU.RiU.hkP();
        this.ESU.RiU.hkS();
      }
      if (com.tencent.mm.storage.as.bvJ(paramString))
      {
        this.ESU.RiU.hkK();
        this.ESU.RiU.hkM();
        this.ESU.RiU.hkN();
        this.ESU.hlv();
        this.ESU.hlw();
        this.ESU.RiU.hkL();
        this.ESU.bj(true, true);
        this.ESU.hlx();
        this.ESU.hlz();
        this.ESU.RiU.hkP();
        this.ESU.RiU.hkS();
      }
      if (com.tencent.mm.storage.as.bvH(paramString))
      {
        this.ESU.RiU.hkK();
        this.ESU.RiU.hkM();
        this.ESU.RiU.hkN();
        this.ESU.hlv();
        this.ESU.hlr();
        this.ESU.hlw();
        this.ESU.RiU.hkL();
        this.ESU.bj(true, true);
        this.ESU.hlx();
        this.ESU.hlz();
        this.ESU.RiU.hkP();
        this.ESU.RiU.hkS();
      }
      if (com.tencent.mm.storage.as.aEF(paramString))
      {
        this.ESU.hli();
        this.ESU.hlr();
        this.ESU.RiU.hkN();
        this.ESU.hlD();
        this.ESU.hlw();
        this.ESU.hlt();
        this.ESU.RiU.hkK();
        this.ESU.hlu();
        this.ESU.hlw();
        this.ESU.hlC();
        this.ESU.hjp();
        this.ESU.RiU.hkO();
        this.ESU.bj(true, true);
        this.ESU.Ed(true);
        this.ESU.Ee(true);
        this.ESU.hlx();
        this.ESU.hlz();
        this.ESU.RiU.hkL();
        this.ESU.RiU.hkK();
        this.ESU.RiU.hkM();
        this.ESU.RiU.hkP();
      }
      if (ab.QB(paramString))
      {
        this.ESU.RiU.hkK();
        this.ESU.RiU.hkM();
        this.ESU.RiU.hkN();
        this.ESU.hlw();
        this.ESU.RiU.hkL();
        this.ESU.bj(true, true);
        this.ESU.hlx();
        this.ESU.hlz();
        this.ESU.RiU.hkP();
        this.ESU.RiU.hkS();
      }
      if (ab.Qy(paramString))
      {
        this.ESU.RiU.hkK();
        this.ESU.bj(true, true);
        this.ESU.RiU.hkL();
        this.ESU.RiU.hkP();
        this.ESU.RiU.hkS();
      }
      bh.beI();
      localObject1 = com.tencent.mm.model.c.bbL().RG(paramString);
      if ((localObject1 != null) && (((com.tencent.mm.storage.as)localObject1).hxX()))
      {
        if (!((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOe()) {
          break label3046;
        }
        this.ESU.RiU.hkK();
        this.ESU.RiU.hkN();
        this.ESU.RiU.hkL();
        this.ESU.bj(true, true);
        this.ESU.hlx();
        this.ESU.hlz();
        this.ESU.hlu();
        this.ESU.RiU.hkO();
        this.ESU.hlt();
        this.ESU.hlC();
        this.ESU.hjp();
        this.ESU.RiU.hkS();
      }
    }
    for (;;)
    {
      try
      {
        EventCenter.instance.publish(new si());
        if (this.fgR.hRh())
        {
          if (com.tencent.mm.n.h.axc().getInt("MultitalkBlockCaller", 0) == 0)
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            this.ESU.Ed(false);
            if ((this.fgR.hRi()) || (this.fgR.hRg())) {
              this.ESU.bj(true, true);
            }
            if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vCK, 0) != 1) {
              continue;
            }
            i = 1;
            bool1 = ab.PP(this.fgR.getTalkerUserName());
            if (((this.fgR.hRi()) && (!bool1)) || (ab.PT(this.fgR.getTalkerUserName())) || ((bool1) && (!z.bdu())) || ((bool1) && (i == 0))) {
              this.ESU.hlz();
            }
            com.tencent.mm.by.c.hok();
            if (this.fgR.hRg()) {
              this.ESU.RiU.hkL();
            }
            if (this.fgR.getTalkerUserName().equals(z.bcZ()))
            {
              this.ESU.RiU.hkL();
              this.ESU.bj(true, true);
              this.ESU.hlx();
              this.ESU.hlz();
              this.ESU.RiU.hkS();
            }
            this.ESU.setAppPanelTip(null);
            if ((!com.tencent.mm.storage.as.bvK(this.fgR.NKq.field_username)) && (!ab.PQ(this.fgR.NKq.field_username))) {
              continue;
            }
            com.tencent.mm.kernel.h.aHH();
            Object localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.fgR.NKq.field_username);
            ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).bQ(((ax)localObject3).field_openImAppid, ((ax)localObject3).field_descWordingId);
            i = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).ZB(((ax)localObject3).field_openImAppid);
            Object localObject2 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).c(this.fgR.NKq.field_openImAppid, "openim_function_tip", com.tencent.mm.openim.a.a.a.mxX);
            Log.i("MicroMsg.ChattingUI.FootComponent", "openim showFlag:%d username: %s appid: %s tip %s", new Object[] { Integer.valueOf(i), this.fgR.NKq.field_username, ((ax)localObject3).field_openImAppid, localObject2 });
            if ((i & 0x1) == 0) {
              this.ESU.hlr();
            }
            if ((i & 0x2) == 0) {
              this.ESU.hlt();
            }
            if ((i & 0x4) == 0) {
              this.ESU.hlB();
            }
            if ((i & 0x8) == 0) {
              this.ESU.hlv();
            }
            if ((i & 0x10) == 0) {
              this.ESU.RiU.hkM();
            }
            if ((i & 0x20) == 0) {
              this.ESU.RiU.hkK();
            }
            if ((i & 0x40) == 0) {
              this.ESU.RiU.hkP();
            }
            if ((i & 0x80) == 0) {
              this.ESU.hlw();
            }
            if (((i & 0x100) == 0) || ((i & 0x2000) == 0))
            {
              localObject3 = this.ESU;
              if ((i & 0x100) != 0) {
                continue;
              }
              bool1 = true;
              if ((i & 0x2000) != 0) {
                continue;
              }
              bool2 = true;
              ((ChatFooter)localObject3).bj(bool1, bool2);
            }
            if ((i & 0x200) != 0) {
              continue;
            }
            this.ESU.hlx();
            Log.i("MicroMsg.ChattingUI.FootComponent", "openIM disableServiceLuckyMoney");
            if ((i & 0x4000) != 0) {
              continue;
            }
            this.ESU.hlz();
            Log.i("MicroMsg.ChattingUI.FootComponent", "openIM disableServiceRemittance");
            if ((i & 0x400) == 0) {
              this.ESU.hly();
            }
            if ((ab.PQ(this.fgR.NKq.field_username)) && ((i & 0x100) == 0)) {
              this.ESU.Ed(true);
            }
            this.ESU.setAppPanelTip((CharSequence)localObject2);
            localObject2 = this.ESU;
            com.tencent.mm.by.c.hok();
            if (((ChatFooter)localObject2).jPN != null) {
              ((ChatFooter)localObject2).jPN.DS(false);
            }
            localObject2 = this.ESU;
            com.tencent.mm.by.c.hok();
            if (!com.tencent.mm.az.b.bmW()) {
              continue;
            }
            bool1 = true;
            ((ChatFooter)localObject2).Ee(bool1);
            this.ESU.RiU.hkL();
            if (com.tencent.mm.storage.as.OS(this.fgR.getTalkerUserName()))
            {
              this.ESU.hli();
              this.ESU.hlr();
              this.ESU.RiU.hkN();
              this.ESU.hlD();
              this.ESU.RiU.hkS();
              this.ESU.hlw();
              this.ESU.hlt();
              this.ESU.hlv();
              this.ESU.RiU.hkK();
              this.ESU.hlu();
              this.ESU.hlw();
              this.ESU.hlt();
              this.ESU.hlC();
              this.ESU.hjp();
              this.ESU.RiU.hkO();
              this.ESU.bj(true, true);
              this.ESU.Ed(true);
              this.ESU.Ee(true);
              this.ESU.hlx();
              this.ESU.hlz();
              this.ESU.RiU.hkL();
              this.ESU.RiU.hkK();
              this.ESU.RiU.hkM();
              this.ESU.RiU.hkP();
            }
            if (com.tencent.mm.storage.as.bvQ(paramString))
            {
              this.ESU.hli();
              if (((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.d.class)).eAm()) {
                continue;
              }
              localObject2 = this.ESU;
              ((ChatFooter)localObject2).RjK = true;
              ((ChatFooter)localObject2).Rjb.setVisibility(8);
              ((ChatFooter)localObject2).Es(false);
              if (!((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.d.class)).eAp())
              {
                this.ESU.hlt();
                this.ESU.hlC();
                this.ESU.hjp();
                this.ESU.RiU.hkO();
              }
              this.ESU.hlr();
              this.ESU.RiU.hkN();
              this.ESU.hlD();
              this.ESU.hlw();
              this.ESU.bj(true, true);
              this.ESU.Ed(true);
              this.ESU.Ee(true);
              this.ESU.hlx();
              this.ESU.hlz();
              this.ESU.RiU.hkL();
              this.ESU.RiU.hkK();
              this.ESU.RiU.hkM();
              this.ESU.RiU.hkP();
              this.ESU.hly();
            }
            if ((!aa.asf()) || (!ab.PP(this.fgR.getTalkerUserName()))) {
              this.ESU.RiU.hkQ();
            }
            if (!((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aKU(this.fgR.getTalkerUserName())) {
              this.ESU.RiU.hkR();
            }
            localObject2 = new ArrayList();
            a(paramString, (com.tencent.mm.storage.as)localObject1, (ArrayList)localObject2);
            paramString = new az.b.a()
            {
              public final void s(String paramAnonymousString, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(163312);
                if ((paramAnonymousBoolean) && (Util.isEqual(y.this.fgR.getTalkerUserName(), paramAnonymousString))) {
                  com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(163310);
                      y.a(y.this, y.15.this.fgI, y.15.this.jkl, new ArrayList());
                      MMHandlerThread.postToMainThread(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(163309);
                          y.this.ESU.hlV();
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
            if ((((ArrayList)localObject2).size() != 0) || (localObject1 == null) || (((ax)localObject1).hDC != 0L)) {
              continue;
            }
            if (!ab.Lj(this.fgR.getTalkerUserName())) {
              continue;
            }
            localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(this.fgR.getTalkerUserName());
            if ((localObject1 != null) && ((((ah)localObject1).field_chatroomStatus & 0x8000) != 0L) && ((((ah)localObject1).field_chatroomfamilystatusmodifytime == 0L) || (((ah)localObject1).field_chatroomfamilystatusmodifytime - cm.bfD() >= 86400000L)))
            {
              ((ah)localObject1).field_chatroomfamilystatusmodifytime = cm.bfD();
              ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().update((IAutoDBItem)localObject1, new String[0]);
              a(this.fgR.getTalkerUserName(), paramString);
            }
            AppMethodBeat.o(35325);
            return;
            bool1 = ((an)this.fgR.bC(an.class)).hQx();
            bool2 = ((an)this.fgR.bC(an.class)).hQw();
            if ((bool1) || (bool2))
            {
              Log.w("MicroMsg.ChattingUI.FootComponent", "match shake, in search mode, do not open short video recode view");
              i = 0;
              break;
            }
            if ((com.tencent.mm.storage.as.bvJ(this.fgR.getTalkerUserName())) || (com.tencent.mm.storage.as.PY(this.fgR.getTalkerUserName())))
            {
              Log.w("MicroMsg.ChattingUI.FootComponent", "match shake, but is Qcontact or Bcontact");
              i = 0;
              break;
            }
            if (ab.QX(this.fgR.getTalkerUserName()))
            {
              i = 0;
              break;
            }
            i = 1;
            break;
            label2738:
            localObject1 = com.tencent.mm.ao.af.bjv().Uq(((com.tencent.mm.api.c)localObject1).field_enterpriseFather);
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
            label2792:
            if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
            {
              i = Util.getInt(com.tencent.mm.n.h.axc().getValue("ChatRoomEnableLive"), 0);
              if (i == 0)
              {
                localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(((ChatFooter)localObject1).RiT);
                if (localObject1 == null) {
                  break label3437;
                }
                if ((((ah)localObject1).field_chatroomStatus & 0x80000) == 524288)
                {
                  j = 1;
                  i = j;
                  if (j != 0) {
                    break label206;
                  }
                  if (com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VCw, 0) != 1) {
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
            if (((ChatFooter)localObject1).RiT == null) {
              continue;
            }
            i = Util.getInt(com.tencent.mm.n.h.axc().getValue("ChatRoomEnableLive"), 0);
            if (i == 0)
            {
              localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(((ChatFooter)localObject1).RiT);
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
            label3020:
            localObject1 = this.ESU.RiU;
            ((AppPanel)localObject1).RhB.El(true);
            ((AppPanel)localObject1).hkT();
            break label268;
            label3046:
            this.ESU.RiU.hkK();
            this.ESU.bj(true, true);
            this.ESU.hlv();
            this.ESU.RiU.hkL();
            this.ESU.RiU.hkS();
            continue;
          }
          i = 0;
          continue;
        }
        this.ESU.Ed(true);
        continue;
        i = 0;
        continue;
        bool1 = false;
        continue;
        boolean bool2 = false;
        continue;
        Log.i("MicroMsg.ChattingUI.FootComponent", "openIM enableServiceLuckyMoney");
        continue;
        Log.i("MicroMsg.ChattingUI.FootComponent", "openIM enableServiceRemittance");
        continue;
        if (!ab.PT(this.fgR.NKq.field_username)) {
          continue;
        }
        i = z.bdV();
        if ((i & 0x1) == 0) {
          this.ESU.Ed(true);
        }
        if ((i & 0x2) == 0) {
          this.ESU.hlx();
        }
        if ((i & 0x4) != 0) {
          continue;
        }
        this.ESU.hly();
        continue;
        bool1 = false;
        continue;
        if (!((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.d.class)).eAn()) {
          this.ESU.hlB();
        }
        if (((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.d.class)).eAo()) {
          continue;
        }
        this.ESU.hlv();
        this.ESU.hlu();
        continue;
        if (ab.PQ(this.fgR.getTalkerUserName()))
        {
          localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(this.fgR.getTalkerUserName());
          if ((localObject1 != null) && ((((ah)localObject1).hxC().type & 0x4) != 0L) && ((((ah)localObject1).field_chatroomfamilystatusmodifytime == 0L) || (((ah)localObject1).field_chatroomfamilystatusmodifytime - cm.bfD() >= 86400000L)))
          {
            ((ah)localObject1).field_chatroomfamilystatusmodifytime = cm.bfD();
            ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().update((IAutoDBItem)localObject1, new String[0]);
            a(this.fgR.getTalkerUserName(), paramString);
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
      label3437:
      j = 0;
    }
  }
  
  private static void bzl(String paramString)
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
        locala.RiB = paramString.optString("enter_id");
        locala.red_dot = paramString.optInt("red_dot");
        locala.jump_type = paramString.optInt("jump_type");
        locala.RiC = paramString.optString("wa_un");
        locala.RiE = paramString.optInt("wa_ver");
        locala.RiF = paramString.optString("wa_path");
        locala.RiG = paramString.optString("wa_dgmode");
        locala.qpi = paramString.optString("h5_url");
        locala.iconUrl = paramString.optString("icon_url");
        locala.RiL = paramString.optString("icon_url_dark");
        if (Util.isNullOrNil(locala.iconUrl))
        {
          Log.e("MicroMsg.ChattingUI.FootComponent", "unCertainEnter.iconUrl is null");
        }
        else
        {
          locala.RiO = paramString.optLong("busi_type");
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
      locala.RiH.title = ((JSONObject)localObject).optString("zh_cn");
      if (Util.isNullOrNil(locala.RiH.title))
      {
        Log.e("MicroMsg.ChattingUI.FootComponent", "unCertainEnter.simpleChWord.title is null");
      }
      else
      {
        a.b localb = locala.RiJ;
        if (Util.isNullOrNil(((JSONObject)localObject).optString("zh_tw")))
        {
          paramString = locala.RiH.title;
          localb.title = paramString;
          localb = locala.RiI;
          if (!Util.isNullOrNil(((JSONObject)localObject).optString("zh_hk"))) {
            break label586;
          }
          paramString = locala.RiH.title;
          label391:
          localb.title = paramString;
          localb = locala.RiK;
          if (!Util.isNullOrNil(((JSONObject)localObject).optString("en"))) {
            break label598;
          }
          paramString = locala.RiH.title;
          label427:
          localb.title = paramString;
          if (localJSONObject != null)
          {
            locala.RiH.desc = localJSONObject.optString("zh_cn");
            localObject = locala.RiJ;
            if (!Util.isNullOrNil(localJSONObject.optString("zh_tw"))) {
              break label610;
            }
            paramString = locala.RiH.desc;
            label484:
            ((a.b)localObject).desc = paramString;
            localObject = locala.RiI;
            if (!Util.isNullOrNil(localJSONObject.optString("zh_hk"))) {
              break label622;
            }
            paramString = locala.RiH.desc;
            label520:
            ((a.b)localObject).desc = paramString;
            localObject = locala.RiK;
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
        for (paramString = locala.RiH.desc;; paramString = localJSONObject.optString("en"))
        {
          ((a.b)localObject).desc = paramString;
          WJZ.add(locala);
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
  
  private void hPl()
  {
    AppMethodBeat.i(35315);
    if (this.fgR.WQv.isCurrentActivity)
    {
      AppMethodBeat.o(35315);
      return;
    }
    this.fgR.WQx.hNj();
    if (this.ESU != null)
    {
      ChatFooter localChatFooter = this.ESU;
      Object localObject = localChatFooter.findViewById(R.h.dyG);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localChatFooter.setSwitchButtonMode(0);
      localChatFooter.mHandler.removeMessages(1002);
      if (localChatFooter.Rjb != null) {
        localChatFooter.Rjb.setVisibility(8);
      }
      if (localChatFooter.Rjc != null) {
        localChatFooter.Rjc.setVisibility(8);
      }
      if (localChatFooter.Rjd != null) {
        localChatFooter.Rjd.setVisibility(8);
      }
      if (localChatFooter.Rjg != null) {
        localChatFooter.Rjg.setVisibility(8);
      }
      if (localChatFooter.Rje != null) {
        localChatFooter.Rje.setVisibility(8);
      }
      if (localChatFooter.Rjh != null) {
        localChatFooter.Rjh.setVisibility(8);
      }
      localChatFooter.jLo.setVisibility(8);
      if (localChatFooter.wLp != null) {
        localChatFooter.wLp.setVisibility(8);
      }
      if (localChatFooter.Rkp != null) {
        localChatFooter.Rkp.setVisibility(8);
      }
      if (localChatFooter.wLq != null) {
        localChatFooter.wLq.setVisibility(8);
      }
      if (localChatFooter.wLn != null) {
        localChatFooter.wLn.setVisibility(8);
      }
      if (localChatFooter.RdV != null)
      {
        localChatFooter.RdV.setVisibility(8);
        localChatFooter.RdY = false;
        localChatFooter.RdV.destroy();
      }
      if (localChatFooter.RjB != null) {
        localChatFooter.RjB.setVisibility(8);
      }
      if (localChatFooter.MkW != null) {
        localChatFooter.MkW.setVisibility(8);
      }
      if (localChatFooter.MkT != null) {
        localChatFooter.MkT.update();
      }
      if (localChatFooter.RiV != null) {
        localChatFooter.RiV.setVisibility(8);
      }
      if (localChatFooter.RiZ != null)
      {
        localChatFooter.RiZ.setVisibility(4);
        if (localChatFooter.jPN != null) {
          localChatFooter.jPN.setVisibility(4);
        }
      }
      localChatFooter.RiU = ((AppPanel)localChatFooter.findViewById(R.h.dvu));
      if (localChatFooter.RiU != null)
      {
        localChatFooter.setAppPanelVisible(8);
        localObject = localChatFooter.RiU;
        if (((AppPanel)localObject).IUf != null) {
          ((AppPanel)localObject).IUf.setToScreen(0);
        }
        ((AppPanel)localObject).Rhz = 0;
      }
      localChatFooter.a(ChatFooter.h.Rni);
      localChatFooter.k(0, false, -1);
      localChatFooter.Rjw = false;
      this.ESU.hlg();
      this.ESU.hlh();
      this.ESU.Rjt.RmY = null;
    }
    AppMethodBeat.o(35315);
  }
  
  private void hPq()
  {
    AppMethodBeat.i(35319);
    Log.i("MicroMsg.ChattingUI.FootComponent", "[goneFooter] %s", new Object[] { Util.getStack() });
    if (this.ESU != null)
    {
      this.ESU.Eq(false);
      this.ESU.setVisibility(8);
    }
    if (this.WKc != null) {
      this.WKc.setVisibility(8);
    }
    this.ESU.En(false);
    this.fgR.hideVKB();
    AppMethodBeat.o(35319);
  }
  
  private void hPu()
  {
    AppMethodBeat.i(184963);
    if (this.ESU == null)
    {
      Log.e("MicroMsg.ChattingUI.FootComponent", "initTodoView footer == null");
      AppMethodBeat.o(184963);
      return;
    }
    Log.i("MicroMsg.ChattingUI.FootComponent", "initTodoView()");
    ((com.tencent.mm.ui.chatting.d.b.y)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.y.class)).a(this.ESU.getIOnToDoBarCallback());
    this.ESU.setIOnTodoViewCallback(new ac.c()
    {
      public final void Gk(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(185864);
        ((com.tencent.mm.ui.chatting.d.b.y)y.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.y.class)).Gk(paramAnonymousBoolean);
        AppMethodBeat.o(185864);
      }
      
      public final void Gl(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(185865);
        ((com.tencent.mm.ui.chatting.d.b.y)y.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.y.class)).Gl(paramAnonymousBoolean);
        AppMethodBeat.o(185865);
      }
      
      public final int eBE()
      {
        AppMethodBeat.i(185866);
        int i = ((com.tencent.mm.ui.chatting.d.b.y)y.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.y.class)).eBE();
        AppMethodBeat.o(185866);
        return i;
      }
    });
    AppMethodBeat.o(184963);
  }
  
  private static void hPv()
  {
    AppMethodBeat.i(163317);
    bzl(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vSd, ""));
    bzl(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vSe, ""));
    bzl(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vSf, ""));
    bzl(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vSg, ""));
    bzl(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vSh, ""));
    bzl(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vSi, ""));
    bzl(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vSj, ""));
    bzl(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vSk, ""));
    bzl(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vSl, ""));
    bzl(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vSm, ""));
    AppMethodBeat.o(163317);
  }
  
  public final boolean aA(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(35322);
    boolean bool1 = ((an)this.fgR.bC(an.class)).hQx();
    boolean bool2 = ((an)this.fgR.bC(an.class)).hQw();
    boolean bool3 = ((com.tencent.mm.ui.chatting.d.b.l)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.l.class)).hOT();
    boolean bool4 = ((s)this.fgR.bC(s.class)).hPi();
    boolean bool5 = ((ai)this.fgR.bC(ai.class)).hQk();
    if (this.WKm)
    {
      AppMethodBeat.o(35322);
      return true;
    }
    if ((bool1) || (bool2) || (bool3) || (bool4) || (bool5))
    {
      Log.i("MicroMsg.ChattingUI.FootComponent", bool1 + ", " + bool2 + ", " + bool3 + ", " + bool4 + ", " + bool5);
      hPq();
      AppMethodBeat.o(35322);
      return false;
    }
    if ((paramas != null) && (ab.Qi(paramas.field_username)))
    {
      this.WKg = new com.tencent.mm.ui.chatting.i(this.WKc);
      this.WKg.hJJ();
      hPo();
      AppMethodBeat.o(35322);
      return true;
    }
    com.tencent.mm.ui.chatting.d.b.d locald;
    Object localObject1;
    int i;
    if ((paramas != null) && (paramas.hxX()))
    {
      locald = (com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class);
      if (locald.hOb() != null)
      {
        localObject1 = locald.hOb().dc(false);
        if (localObject1 != null)
        {
          if (((c.b)localObject1).eZg != null) {
            ((c.b)localObject1).eZi = "1".equals(((c.b)localObject1).eZg.optString("IsHideInputToolbarInMsg"));
          }
          if (((c.b)localObject1).eZi)
          {
            Log.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + paramas.field_username + " is hide tool bar");
            hPq();
            AppMethodBeat.o(35322);
            return false;
          }
        }
        if ((!Util.isNullOrNil(paramas.field_username)) && (localObject1 != null))
        {
          i = this.fgR.WQv.getIntExtra("key_temp_session_show_type", 0);
          switch (((c.b)localObject1).Zp())
          {
          default: 
            hPp();
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
      Log.e("MicroMsg.ChattingUI.FootComponent", "bizinfo name=%s, %b, %d", new Object[] { paramas, Boolean.valueOf(bool1), Integer.valueOf(((c.b)localObject1).Zp()) });
      for (;;)
      {
        AppMethodBeat.o(35322);
        return true;
        Log.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + paramas.field_username + " is show custom menu");
        if (this.WKc == null)
        {
          m.a(this.fgR.WQv, R.h.dNe);
          this.WKc = ((ChatFooterCustom)this.fgR.findViewById(R.h.dNg));
          if (this.WKc != null) {
            this.WKc.U((ViewGroup)this.fgR.findViewById(R.h.dxb));
          }
        }
        localObject1 = ((c.b)localObject1).Zw();
        try
        {
          Iterator localIterator = ((c.b.c)localObject1).eZQ.iterator();
          while (localIterator.hasNext())
          {
            Object localObject2 = (k)localIterator.next();
            if (!Util.isNullOrNil(((k)localObject2).gbn)) {
              ((com.tencent.mm.plugin.brandservice.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.f.class)).a(((k)localObject2).gbn, -1, "", Util.nullAs(((k)localObject2).name, ""), "", "", 4);
            }
            if (!Util.isNullOrNil(((k)localObject2).value)) {
              ((com.tencent.mm.plugin.brandservice.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.f.class)).a(((k)localObject2).value, -1, "", Util.nullAs(((k)localObject2).name, ""), "", "", 4);
            }
            localObject2 = ((k)localObject2).lEI.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              k localk = (k)((Iterator)localObject2).next();
              if (!Util.isNullOrNil(localk.gbn)) {
                ((com.tencent.mm.plugin.brandservice.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.f.class)).a(localk.gbn, -1, "", Util.nullAs(localk.name, ""), "", "", 4);
              }
              if (!Util.isNullOrNil(localk.value)) {
                ((com.tencent.mm.plugin.brandservice.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.f.class)).a(localk.value, -1, "", Util.nullAs(localk.name, ""), "", "", 4);
              }
            }
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.ChattingUI.FootComponent", localException, "preauth when chat foot", new Object[0]);
          if ((localObject1 != null) && (((c.b.c)localObject1).type == 1))
          {
            this.ESU.setSwitchButtonMode(1);
            this.ESU.setOnFooterSwitchListener(((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOi());
            hPp();
          }
          else
          {
            this.ESU.setSwitchButtonMode(0);
            try
            {
              if (!ab.Qb(paramas.field_username)) {
                break label1060;
              }
              this.WKf = new x(this.WKc);
              this.WKf.hJJ();
              hPo();
            }
            catch (Exception paramas)
            {
              if (localObject1 == null) {
                break label1040;
              }
            }
            if ((((c.b.c)localObject1).eZQ == null) || (((c.b.c)localObject1).eZQ.size() == 0)) {
              label1040:
              hPp();
            }
          }
        }
      }
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ChattingUI.FootComponent", paramas, "", new Object[0]);
        break;
        label1060:
        ChatFooterCustom localChatFooterCustom = this.WKc;
        if ((localChatFooterCustom.Wyf != null) && (localChatFooterCustom.Wye != null))
        {
          localChatFooterCustom.Wyf.setVisibility(0);
          localChatFooterCustom.Wye.setVisibility(0);
        }
        if (localChatFooterCustom.Wyg != null) {
          localChatFooterCustom.Wyg.cFD();
        }
        this.WKc.setTalker(this.fgR.NKq);
        this.WKc.a(this.fgR.WQv, locald.hOb(), paramas.field_username);
        this.WKc.setOnFooterSwitchListener(this.Rjr);
        this.WKc.setOnProcessClickListener(((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOh());
        this.ESU.setOnFooterSwitchListener(this.Rjr);
        if ((((ae)this.fgR.bC(ae.class)).hQj()) && (i == 1))
        {
          hPp();
          break;
        }
        hPo();
        break;
        this.Rjr.Et(true);
      }
    }
  }
  
  public final boolean bm(ca paramca)
  {
    AppMethodBeat.i(35323);
    if (this.ESU != null) {
      this.ESU.bm(paramca);
    }
    AppMethodBeat.o(35323);
    return true;
  }
  
  public final void hGU()
  {
    AppMethodBeat.i(285051);
    this.WKm = this.fgR.WQv.getBooleanExtra("show_footer", false).booleanValue();
    AppMethodBeat.o(285051);
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(35333);
    this.WKn = false;
    this.WKo = false;
    this.WKp = 0L;
    bh.beI();
    Object localObject1 = com.tencent.mm.model.c.bbR().bwx(this.fgR.getTalkerUserName());
    if (localObject1 != null) {
      this.WKd = ((bb)localObject1).field_chatmode;
    }
    Log.d("MicroMsg.ChattingUI.FootComponent", "dkcm init old:%d   ", new Object[] { Integer.valueOf(this.WKd) });
    localObject1 = this.fgR.getTalkerUserName();
    if (this.ESU == null)
    {
      this.ESU = ((ChatFooter)this.fgR.findViewById(R.h.dNf));
      this.ESU.a(new ChatFooter.b()
      {
        public final String getTalkerUserName()
        {
          AppMethodBeat.i(35307);
          String str = y.this.fgR.getTalkerUserName();
          AppMethodBeat.o(35307);
          return str;
        }
        
        public final com.tencent.mm.ui.chatting.i.b hmo()
        {
          return y.this.fgR.WQt;
        }
        
        public final com.tencent.mm.ui.chatting.e.a hmp()
        {
          return y.this.fgR;
        }
      });
      ((t)this.fgR.bC(t.class)).bD(this.ESU);
      hPu();
    }
    this.ESU.setCattingRootLayoutId(R.h.chatting_bg_ll);
    Log.i("MicroMsg.ChattingUI.FootComponent", "resetFooter customFooter is %s", new Object[] { this.WKc });
    if (this.WKc != null)
    {
      this.WKc.hMu();
      this.WKc.setOnFooterSwitchListener(null);
      this.WKc.setOnProcessClickListener(null);
      this.ESU.setOnFooterSwitchListener(null);
      this.WKc.hMx();
    }
    hPq();
    this.ESU.hls();
    boolean bool1 = ((an)this.fgR.bC(an.class)).hQx();
    boolean bool2 = ((an)this.fgR.bC(an.class)).hQw();
    boolean bool3 = ((ai)this.fgR.bC(ai.class)).hQk();
    int i;
    if ((!this.WKm) && ((bool1) || (bool2) || (bool3)))
    {
      hPq();
      hPl();
      this.WKb = new q(this.fgR, this.ESU, this.fgR.getTalkerUserName());
      this.WKb.WAr = this.fgR.WQv.getBooleanExtra("key_need_send_video", true).booleanValue();
      this.ESU.setFooterEventListener(this.WKb);
      localObject1 = new w(this.fgR, this.fgR.NKq, this.fgR.getTalkerUserName());
      this.ESU.setSmileyPanelCallback((com.tencent.mm.pluginsdk.ui.chat.f)localObject1);
      this.ESU.setSmileyPanelCallback2((j)localObject1);
      hPt();
      this.ESU.hlj();
      i = this.fgR.WQv.getIntExtra("key_temp_session_show_type", 0);
      localObject1 = (ae)this.fgR.bC(ae.class);
      Log.i("MicroMsg.ChattingUI.FootComponent", "isTempSession : %s, showType : %d.", new Object[] { Boolean.valueOf(((ae)localObject1).hQj()), Integer.valueOf(i) });
      Log.d("MicroMsg.ChattingUI.FootComponent", "is temp session : %s.", new Object[] { Boolean.valueOf(((ae)localObject1).hQj()) });
      if (((ae)localObject1).hQj())
      {
        if (i != 1) {
          break label1622;
        }
        this.Rjr.Et(true);
      }
    }
    for (;;)
    {
      aA(this.fgR.NKq);
      com.tencent.mm.kernel.h.aHH();
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().add(this);
      ((PluginOpenIM)com.tencent.mm.kernel.h.ag(PluginOpenIM.class)).getWordingInfoStg().add(this);
      AppMethodBeat.o(35333);
      return;
      if (ab.Qp((String)localObject1))
      {
        hPq();
        m.a(this.fgR.WQv, R.h.dNe);
        if (this.WKc == null)
        {
          i = 1;
          this.WKc = ((ChatFooterCustom)this.fgR.findViewById(R.h.dNg));
          if (i != 0) {
            this.WKc.U((ViewGroup)this.fgR.findViewById(R.h.dxb));
          }
          this.WKe = new com.tencent.mm.ui.chatting.u(this.WKc);
          localObject1 = this.WKe;
          if (ChannelUtil.channelId != 1) {
            break label903;
          }
          i = 1;
          label720:
          ((com.tencent.mm.ui.chatting.u)localObject1).WBz.findViewById(R.h.dxC).setVisibility(8);
          ((com.tencent.mm.ui.chatting.u)localObject1).uPX = ((LinearLayout)((com.tencent.mm.ui.chatting.u)localObject1).WBz.findViewById(R.h.dxx));
          ((com.tencent.mm.ui.chatting.u)localObject1).WBz.findViewById(R.h.dxw).setVisibility(8);
          localObject2 = ((com.tencent.mm.ui.chatting.u)localObject1).uPX;
          if (i == 0) {
            break label908;
          }
        }
        label903:
        label908:
        for (float f = 1.0F;; f = 2.0F)
        {
          ((LinearLayout)localObject2).setWeightSum(f);
          ((com.tencent.mm.ui.chatting.u)localObject1).WBA = ((FrameLayout)((com.tencent.mm.ui.chatting.u)localObject1).uPX.getChildAt(0));
          ((com.tencent.mm.ui.chatting.u)localObject1).WBA.setVisibility(0);
          ((com.tencent.mm.ui.chatting.u)localObject1).WBA.setOnClickListener(((com.tencent.mm.ui.chatting.u)localObject1).WBI);
          ((TextView)((com.tencent.mm.ui.chatting.u)localObject1).WBA.findViewById(R.h.dxz)).setText(R.l.eua);
          ((com.tencent.mm.ui.chatting.u)localObject1).WBA.findViewById(R.h.dxy).setVisibility(8);
          if (i == 0) {
            break label913;
          }
          i = 1;
          while (i < 6)
          {
            ((com.tencent.mm.ui.chatting.u)localObject1).uPX.getChildAt(i).setVisibility(8);
            i += 1;
          }
          i = 0;
          break;
          i = 0;
          break label720;
        }
        label913:
        ((com.tencent.mm.ui.chatting.u)localObject1).WBB = ((FrameLayout)((com.tencent.mm.ui.chatting.u)localObject1).uPX.getChildAt(1));
        ((com.tencent.mm.ui.chatting.u)localObject1).WBB.setVisibility(0);
        ((com.tencent.mm.ui.chatting.u)localObject1).WBB.setOnClickListener(((com.tencent.mm.ui.chatting.u)localObject1).WBJ);
        ((com.tencent.mm.ui.chatting.u)localObject1).WBC = ((TextView)((com.tencent.mm.ui.chatting.u)localObject1).WBB.findViewById(R.h.dxz));
        ((com.tencent.mm.ui.chatting.u)localObject1).WBD = ((ImageView)((com.tencent.mm.ui.chatting.u)localObject1).WBB.findViewById(R.h.dxy));
        ((com.tencent.mm.ui.chatting.u)localObject1).WBD.setVisibility(0);
        ((com.tencent.mm.ui.chatting.u)localObject1).hNa();
        bh.beI();
        ((com.tencent.mm.ui.chatting.u)localObject1).Dcg = ((Integer)com.tencent.mm.model.c.aHp().get(ar.a.VhG, Integer.valueOf(-1))).intValue();
        if (((com.tencent.mm.ui.chatting.u)localObject1).Dcg >= 0) {
          ((com.tencent.mm.ui.chatting.u)localObject1).hNc();
        }
        for (;;)
        {
          i = 2;
          while (i < 6)
          {
            ((com.tencent.mm.ui.chatting.u)localObject1).uPX.getChildAt(i).setVisibility(8);
            i += 1;
          }
          ((com.tencent.mm.ui.chatting.u)localObject1).WBC.setText(R.l.chatfooter_mail_without_unread_count);
        }
        ((com.tencent.mm.ui.chatting.u)localObject1).WBH = com.tencent.mm.n.h.axd().getMailAppEnterUlAndroid();
        if (Util.isNullOrNil(((com.tencent.mm.ui.chatting.u)localObject1).WBH)) {
          ((com.tencent.mm.ui.chatting.u)localObject1).WBH = "qqmail://folderlist?app=weixin&action=list&uin=$uin$";
        }
        bh.beI();
        localObject2 = new com.tencent.mm.b.p(Util.nullAsNil((Integer)com.tencent.mm.model.c.aHp().b(9, null))).toString();
        ((com.tencent.mm.ui.chatting.u)localObject1).WBH = ((com.tencent.mm.ui.chatting.u)localObject1).WBH.replace("$uin$", (CharSequence)localObject2);
        ((com.tencent.mm.ui.chatting.u)localObject1).HrG = com.tencent.mm.n.h.axd().awV();
        ((com.tencent.mm.ui.chatting.u)localObject1).WBF = true;
        hPo();
        break;
      }
      this.WKe = null;
      if (ab.Qb((String)localObject1))
      {
        hPq();
        m.a(this.fgR.WQv, R.h.dNe);
        if (this.WKc == null) {}
        for (i = 1;; i = 0)
        {
          this.WKc = ((ChatFooterCustom)this.fgR.findViewById(R.h.dNg));
          if (i != 0) {
            this.WKc.U((ViewGroup)this.fgR.findViewById(R.h.dxb));
          }
          this.WKf = new x(this.WKc);
          this.WKf.hJJ();
          hPo();
          break;
        }
      }
      this.WKf = null;
      if (ab.Qi((String)localObject1))
      {
        hPq();
        m.a(this.fgR.WQv, R.h.dNe);
        if (this.WKc == null) {}
        for (i = 1;; i = 0)
        {
          this.WKc = ((ChatFooterCustom)this.fgR.findViewById(R.h.dNg));
          if (i != 0) {
            this.WKc.U((ViewGroup)this.fgR.findViewById(R.h.dxb));
          }
          this.WKg = new com.tencent.mm.ui.chatting.i(this.WKc);
          this.WKg.hJJ();
          hPo();
          break;
        }
      }
      this.WKg = null;
      if ((!ab.Qq((String)localObject1)) && (!ab.Qb((String)localObject1)) && (!ab.Qp((String)localObject1)) && (!ab.Qi((String)localObject1)))
      {
        ab.bdY();
        if ((!ab.QQ((String)localObject1)) && (!ab.Qg((String)localObject1)) && (!ab.QV((String)localObject1))) {}
      }
      else
      {
        hPq();
        break;
      }
      hPp();
      aA(this.fgR.NKq);
      this.ESU.setUserName((String)localObject1);
      this.ESU.ns(this.fgR.getSelfUserName(), this.fgR.getTalkerUserName());
      bzk((String)localObject1);
      localObject1 = (com.tencent.mm.ui.chatting.d.b.l)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.l.class);
      Object localObject2 = (an)this.fgR.bC(an.class);
      if (!((com.tencent.mm.ui.chatting.d.b.l)localObject1).hOT()) {
        break;
      }
      if (((an)localObject2).hQu())
      {
        ((an)localObject2).hQt();
        ((com.tencent.mm.ui.chatting.d.b.l)localObject1).hOU();
        break;
      }
      ((com.tencent.mm.ui.chatting.d.b.l)localObject1).hOR();
      break;
      label1622:
      this.Rjr.Et(false);
    }
  }
  
  public final void hGW() {}
  
  public final void hGX()
  {
    AppMethodBeat.i(35334);
    this.WKi = this.fgR.WQv.getStringExtra("smiley_product_id");
    if (this.ESU.BSf) {
      ((ap)this.fgR.bC(ap.class)).keepSignalling();
    }
    if ((ab.Qp(this.fgR.getTalkerUserName())) && (this.WKe != null) && (this.WKe.WBF)) {
      this.WKe.hNb();
    }
    ChatFooter localChatFooter = this.ESU;
    BaseChattingUIFragment localBaseChattingUIFragment = this.fgR.WQv;
    localChatFooter.Rkk = localBaseChattingUIFragment;
    localChatFooter.a(localBaseChattingUIFragment.getContext(), localBaseChattingUIFragment.thisActivity());
    if ((localChatFooter.RkL != null) && (localChatFooter.RkL.isShowing())) {
      localChatFooter.RkL.dismiss();
    }
    localChatFooter.KQB.refresh(((PluginWebSearch)com.tencent.mm.kernel.h.ag(PluginWebSearch.class)).isUseSysEditText());
    if ((!Util.isNullOrNil(this.WKi)) && (this.ESU != null))
    {
      Log.d("MicroMsg.ChattingUI.FootComponent", "deal use smiley panel in product: %s", new Object[] { this.WKi });
      this.ESU.setDefaultSmileyByDetail(this.WKi);
      this.ESU.hln();
    }
    this.fgR.WQv.getContext().getIntent().putExtra("smiley_product_id", "");
    this.ESU.setUserName(this.fgR.getTalkerUserName());
    com.tencent.mm.live.d.e.kIk = this.fgR.getTalkerUserName();
    this.ESU.ns(this.fgR.getSelfUserName(), this.fgR.getTalkerUserName());
    if (this.fgR.WQv.getBooleanExtra("key_show_bottom_app_panel", false).booleanValue())
    {
      localChatFooter = this.ESU;
      if (localChatFooter.Rjb != null)
      {
        localChatFooter.Rjb.performClick();
        Log.d("MicroMsg.ChatFooter", "perform click attach bt to show bottom panel");
      }
    }
    if (aA(this.fgR.NKq))
    {
      if (this.ESU != null)
      {
        bh.beI();
        bool1 = ((Boolean)com.tencent.mm.model.c.aHp().b(66832, Boolean.FALSE)).booleanValue();
        Log.d("MicroMsg.ChattingUI.FootComponent", "jacks refresh Footer Plugin Setting , Enable Enter Button: %B", new Object[] { Boolean.valueOf(bool1) });
        this.ESU.hlR();
        if (bool1)
        {
          this.ESU.hlE();
          this.ESU.hlj();
        }
        if (bool1) {
          this.ESU.hlt();
        }
        localChatFooter = this.ESU;
        if (localChatFooter.RiU != null) {
          localChatFooter.RiU.hkJ();
        }
      }
      ((com.tencent.mm.ui.chatting.d.b.as)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.as.class)).hPd();
      if (this.ESU != null)
      {
        this.ESU.RiU.bfU();
        this.ESU.addTextChangedListener(new a((byte)0));
        Log.i("MicroMsg.ChattingUI.FootComponent", "addTextChangedListener");
      }
    }
    boolean bool1 = ((an)this.fgR.bC(an.class)).hQx();
    boolean bool2 = ((an)this.fgR.bC(an.class)).hQw();
    boolean bool3 = ((com.tencent.mm.ui.chatting.d.b.l)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.l.class)).hOT();
    boolean bool4 = ab.Qg(this.fgR.getTalkerUserName());
    boolean bool5 = ((ai)this.fgR.bC(ai.class)).hQk();
    if (((!bool1) && (!bool2) && (!bool3)) || ((this.WKm) && (this.fgR.NKq != null) && (!this.fgR.NKq.hxX()) && (!ab.QS(this.fgR.getTalkerUserName())) && (!com.tencent.mm.ui.widget.snackbar.b.bVd()) && (!ab.Qi(this.fgR.getTalkerUserName())) && (!bool4) && (!bool5)))
    {
      Log.i("MicroMsg.ChattingUI.FootComponent", "call visibleFooter again.");
      hPp();
    }
    for (;;)
    {
      this.iXf.alive();
      this.iXe.alive();
      AppMethodBeat.o(35334);
      return;
      Log.i("MicroMsg.ChattingUI.FootComponent", "no call visibleFooter again.");
    }
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(35335);
    Object localObject;
    if (this.ESU != null)
    {
      localObject = this.ESU;
      if (((ChatFooter)localObject).RlK != null)
      {
        ((ChatFooter)localObject).KQB.removeTextChangedListener(((ChatFooter)localObject).RlK);
        ((ChatFooter)localObject).RlK = null;
      }
      Log.i("MicroMsg.ChattingUI.FootComponent", "removeTextChangeListener");
      this.ESU.onPause();
      this.iXf.dead();
      this.iXe.dead();
      if (!com.tencent.mm.kernel.h.aHB())
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
    bh.beI();
    com.tencent.mm.model.c.aHp().i(18, Integer.valueOf(this.ESU.getMode()));
    Log.d("MicroMsg.ChattingUI.FootComponent", "dkcm old:%d footer:%d ", new Object[] { Integer.valueOf(this.WKd), Integer.valueOf(this.ESU.getMode()) });
    if (this.WKd != this.ESU.getMode())
    {
      this.WKd = this.ESU.getMode();
      bh.beI();
      localObject = com.tencent.mm.model.c.bbR().bwx(this.fgR.getTalkerUserName());
      if ((localObject != null) && (this.fgR.getTalkerUserName().equals(((bb)localObject).field_username)))
      {
        ((az)localObject).pI(this.WKd);
        bh.beI();
        com.tencent.mm.model.c.bbR().a((az)localObject, this.fgR.getTalkerUserName());
      }
    }
    this.ESU.a(ChatFooter.h.Rnk);
    AppMethodBeat.o(35335);
  }
  
  public final void hGZ() {}
  
  public final void hNZ()
  {
    AppMethodBeat.i(35332);
    super.hNZ();
    if (this.ESU != null)
    {
      this.ESU.setFooterEventListener(null);
      q localq = this.WKb;
      CaptureDataManager.HKJ.HKI = null;
      if (localq.WAl != null)
      {
        localq.WAl.a(null);
        localq.WAl.a(null);
      }
      this.WKb = null;
      this.ESU.setSmileyPanelCallback(null);
      this.ESU.setSmileyPanelCallback2(null);
    }
    if (this.WKc != null)
    {
      this.WKc.hMu();
      this.WKc = null;
    }
    hPl();
    if (this.WKc != null) {
      this.WKc.hMx();
    }
    com.tencent.mm.pluginsdk.ui.span.l.clearCache();
    if (this.ESU != null) {
      this.ESU.hlN();
    }
    if ((this.fgR.WQv.isCurrentActivity) && (this.ESU != null)) {
      this.ESU.destroy();
    }
    com.tencent.mm.kernel.h.aHH();
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().remove(this);
    ((PluginOpenIM)com.tencent.mm.kernel.h.ag(PluginOpenIM.class)).getWordingInfoStg().remove(this);
    AppMethodBeat.o(35332);
  }
  
  public final ChatFooter hPj()
  {
    return this.ESU;
  }
  
  public final ChatFooterCustom hPk()
  {
    return this.WKc;
  }
  
  public final String hPm()
  {
    return this.WKi;
  }
  
  public final void hPn()
  {
    AppMethodBeat.i(35316);
    try
    {
      if (this.ESU.hlI()) {
        this.ESU.setBottomPanelVisibility(8);
      }
      AppMethodBeat.o(35316);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(35316);
    }
  }
  
  public final void hPo()
  {
    AppMethodBeat.i(35317);
    this.fgR.hideVKB();
    Log.i("MicroMsg.ChattingUI.FootComponent", "visibleCustomFooter customFooter is %s", new Object[] { this.WKc });
    if (this.WKc == null)
    {
      AppMethodBeat.o(35317);
      return;
    }
    this.WKc.setVisibility(0);
    if (this.ESU != null)
    {
      this.ESU.Eq(false);
      this.ESU.setVisibility(8);
    }
    AppMethodBeat.o(35317);
  }
  
  public final void hPp()
  {
    AppMethodBeat.i(35318);
    if (this.ESU == null)
    {
      AppMethodBeat.o(35318);
      return;
    }
    this.ESU.setVisibility(0);
    if (this.WKc != null) {
      this.WKc.setVisibility(8);
    }
    AppMethodBeat.o(35318);
  }
  
  public final void hPr()
  {
    AppMethodBeat.i(35320);
    this.WKh = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.WKh.setInterpolator(new DecelerateInterpolator(1.5F));
    this.WKh.addAnimation(localTranslateAnimation);
    this.WKh.addAnimation(localAlphaAnimation);
    this.WKh.setDuration(300L);
    this.WKh.setFillBefore(true);
    if (this.ESU != null) {
      this.ESU.startAnimation(this.WKh);
    }
    AppMethodBeat.o(35320);
  }
  
  public final void hPs()
  {
    AppMethodBeat.i(35321);
    Log.i("MicroMsg.ChattingUI.FootComponent", "triggerFooter, originChatFooterVisibility:%s", new Object[] { Integer.valueOf(this.WKj) });
    if (this.ESU == null)
    {
      this.ESU = ((ChatFooter)this.fgR.findViewById(R.h.dNf));
      this.ESU.a(new ChatFooter.b()
      {
        public final String getTalkerUserName()
        {
          AppMethodBeat.i(35306);
          String str = y.this.fgR.getTalkerUserName();
          AppMethodBeat.o(35306);
          return str;
        }
        
        public final com.tencent.mm.ui.chatting.i.b hmo()
        {
          return y.this.fgR.WQt;
        }
        
        public final com.tencent.mm.ui.chatting.e.a hmp()
        {
          return y.this.fgR;
        }
      });
      ((t)this.fgR.bC(t.class)).bD(this.ESU);
      hPu();
    }
    boolean bool1 = ((com.tencent.mm.ui.chatting.d.b.l)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.l.class)).hOT();
    boolean bool2 = ((ai)this.fgR.bC(ai.class)).hQk();
    if ((bool1) || (bool2) || (com.tencent.mm.ui.widget.snackbar.b.bVd()))
    {
      if (!this.WKl) {
        this.WKj = this.ESU.getVisibility();
      }
      this.ESU.Eq(true);
      if (this.WKc != null) {
        if (this.WKl) {}
      }
      for (this.WKk = this.WKc.getVisibility();; this.WKk = -1)
      {
        hPq();
        this.WKl = true;
        AppMethodBeat.o(35321);
        return;
      }
    }
    this.WKl = false;
    if ((this.WKj == 8) && (this.WKk == 8))
    {
      hPq();
      AppMethodBeat.o(35321);
      return;
    }
    if (this.WKj == 0)
    {
      hPp();
      AppMethodBeat.o(35321);
      return;
    }
    hPo();
    AppMethodBeat.o(35321);
  }
  
  public final void hPt()
  {
    AppMethodBeat.i(35324);
    String str = this.fgR.getTalkerUserName();
    int i;
    if ((ab.Qr(str)) || (com.tencent.mm.storage.as.bvH(str))) {
      i = 1;
    }
    while (i == 2)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.fgR.WQv.getContext(), "android.permission.RECORD_AUDIO", 80, "", "");
      Log.i("MicroMsg.ChattingUI.FootComponent", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.fgR.WQv.getContext() });
      if (bool) {
        break;
      }
      this.ESU.bM(1, false);
      AppMethodBeat.o(35324);
      return;
      if (ab.QI(str))
      {
        i = 2;
      }
      else
      {
        int j = this.fgR.WQv.getIntExtra("Chat_Mode", 0);
        Log.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", new Object[] { Integer.valueOf(this.WKd), Integer.valueOf(j) });
        if (this.WKd != 0) {
          j = this.WKd;
        }
        str = com.tencent.mm.n.h.axc().getValue("DefaultMsgType");
        i = j;
        if (this.WKd == 0)
        {
          i = j;
          if (str != null)
          {
            Log.d("MicroMsg.ChattingUI.FootComponent", "config def chatmode is %s", new Object[] { str });
            i = Util.getInt(com.tencent.mm.n.h.axc().getValue("DefaultMsgType"), 0);
          }
        }
        j = i;
        if (i == 0)
        {
          j = i;
          if (com.tencent.mm.contact.d.rk(this.fgR.NKq.field_type))
          {
            bh.beI();
            j = ((Integer)com.tencent.mm.model.c.aHp().b(18, Integer.valueOf(0))).intValue();
          }
        }
        i = j;
        if (j == 0) {
          i = 1;
        }
        Log.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", new Object[] { Integer.valueOf(this.WKd), Integer.valueOf(i) });
      }
    }
    this.ESU.bM(i, false);
    AppMethodBeat.o(35324);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35329);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((1111 == paramInt1) && (-1 == paramInt2)) {
      this.ESU.hln();
    }
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 200) || (paramInt1 == 201) || (paramInt1 == 203)) {
        this.ESU.clearFocus();
      }
      AppMethodBeat.o(35329);
      return;
    }
    if ((paramInt1 != 217) && (this.WKc != null)) {
      this.WKc.w(paramInt1, paramIntent);
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
      if (this.ESU != null) {
        this.ESU.setMode(paramInt1);
      }
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int j = 0;
    AppMethodBeat.i(35331);
    Log.i("MicroMsg.ChattingUI.FootComponent", "chatting onKeyDown, code:%d action:%d", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    if (paramKeyEvent.getKeyCode() == 4) {
      if (!this.fgR.dgo) {
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
        if ((this.fgR.WQv.isSupportNavigationSwipeBack()) && (this.fgR.WQv.getSwipeBackLayout().hlH()))
        {
          Log.w("MicroMsg.ChattingUI.FootComponent", "ashutest::onKeyDown back ScrollToFinishing");
          i = 1;
        }
        else
        {
          if (paramKeyEvent.getAction() == 0)
          {
            this.WKn = true;
            this.WKp = System.currentTimeMillis();
          }
          if (paramKeyEvent.getAction() != 1) {
            break label356;
          }
          Log.d("MicroMsg.ChattingUI.FootComponent", "hasBack %B, %d", new Object[] { Boolean.valueOf(this.WKn), Long.valueOf(System.currentTimeMillis() - this.WKp) });
          if ((this.WKn) && (System.currentTimeMillis() - this.WKp <= 30000L)) {
            break;
          }
          i = 1;
        }
      }
      this.WKo = true;
      Object localObject = (com.tencent.mm.ui.chatting.d.b.l)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.l.class);
      an localan = (an)this.fgR.bC(an.class);
      if (((com.tencent.mm.ui.chatting.d.b.l)localObject).hOT()) {
        if (localan.hQu())
        {
          localan.hQt();
          ((com.tencent.mm.ui.chatting.d.b.l)localObject).hOU();
          label291:
          i = 1;
          label293:
          if (i == 0) {
            if (this.ESU != null)
            {
              localObject = this.ESU;
              if ((((ChatFooter)localObject).jJL == 0) && (!((ChatFooter)localObject).RdY)) {
                break label385;
              }
              if (!((ChatFooter)localObject).RdY) {
                break label376;
              }
              ((ChatFooter)localObject).hjU();
              label339:
              i = 1;
            }
          }
        }
      }
      for (;;)
      {
        if (i == 0) {
          this.fgR.WQv.hMr();
        }
        label356:
        i = 1;
        break;
        ((com.tencent.mm.ui.chatting.d.b.l)localObject).hOR();
        break label291;
        i = 0;
        break label293;
        label376:
        ((ChatFooter)localObject).Eq(true);
        break label339;
        label385:
        i = j;
        if (((ChatFooter)localObject).Rle != null)
        {
          i = j;
          if (((ChatFooter)localObject).Rle.getVisibility() == 0)
          {
            ((ChatFooter)localObject).Rle.gsz();
            i = 1;
          }
        }
      }
      if ((paramKeyEvent.getKeyCode() == 67) && (!this.fgR.dgo)) {
        Log.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown back key fragment not foreground");
      } else if (!this.fgR.dgo) {
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
    Log.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", new Object[] { paramObject, this.fgR.getTalkerUserName() });
    if (paramObject.equals(this.fgR.getTalkerUserName()))
    {
      bzk(this.fgR.getTalkerUserName());
      hPt();
    }
    AppMethodBeat.o(35327);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(35328);
    if (paramString != null) {
      paramString.equals("");
    }
    Log.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", new Object[] { paramString, this.fgR.getTalkerUserName() });
    if (ab.PQ(this.fgR.getTalkerUserName()))
    {
      bzk(this.fgR.getTalkerUserName());
      hPt();
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
        Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doFooterLiveRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.WKb, Util.getStack() });
        if (this.WKb != null) {
          this.WKb.ETE.eRQ();
        }
        AppMethodBeat.o(35330);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = R.l.permission_camera_request_again_msg;; paramInt = R.l.permission_microphone_request_again_msg)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(paramInt), this.fgR.WQv.getMMResources().getString(R.l.permission_tips_title), this.fgR.WQv.getMMResources().getString(R.l.jump_to_settings), this.fgR.WQv.getMMResources().getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35311);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = y.this.fgR.WQv;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/component/FootComponent$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
        Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doFooterSightRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.WKb, Util.getStack() });
        if (this.WKb != null)
        {
          paramArrayOfString = this.WKb;
          if (!this.ESU.RiU.RhB.Riq.value) {
            break label446;
          }
        }
        label446:
        for (paramInt = i;; paramInt = 2)
        {
          paramArrayOfString.avj(paramInt);
          AppMethodBeat.o(35330);
          return;
        }
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = R.l.permission_camera_request_again_msg;; paramInt = R.l.permission_microphone_request_again_msg)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(paramInt), this.fgR.WQv.getMMResources().getString(R.l.permission_tips_title), this.fgR.WQv.getMMResources().getString(R.l.jump_to_settings), this.fgR.WQv.getMMResources().getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35302);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = y.this.fgR.WQv;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/component/FootComponent$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
          Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuVideoSelected,footerEventImpl[%s], stack[%s]", new Object[] { this.WKb, Util.getStack() });
          if (this.WKb != null) {
            this.WKb.fqz();
          }
          AppMethodBeat.o(35330);
          return;
        }
        if (paramInt == 21)
        {
          Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.WKb, Util.getStack() });
          if (this.WKb != null) {
            this.WKb.hMV();
          }
          AppMethodBeat.o(35330);
          return;
        }
        Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnEnterMultiTalk,footerEventImpl[%s], stack[%s]", new Object[] { this.WKb, Util.getStack() });
        if (this.WKb != null) {
          this.WKb.hMT();
        }
        AppMethodBeat.o(35330);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = R.l.permission_camera_request_again_msg;; paramInt = R.l.permission_microphone_request_again_msg)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(paramInt), this.fgR.WQv.getMMResources().getString(R.l.permission_tips_title), this.fgR.WQv.getMMResources().getString(R.l.jump_to_settings), this.fgR.WQv.getMMResources().getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(163307);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = y.this.fgR.WQv;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/component/FootComponent$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
        Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doImageSelectTakePhotoRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.WKb, Util.getStack() });
        if (this.WKb != null) {
          this.WKb.hMX();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.permission_camera_request_again_msg), this.fgR.WQv.getMMResources().getString(R.l.permission_tips_title), this.fgR.WQv.getMMResources().getString(R.l.jump_to_settings), this.fgR.WQv.getMMResources().getString(R.l.cancel), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(169867);
          paramAnonymousDialogInterface = y.this.fgR.WQv;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/component/FootComponent$15", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$15", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(169867);
        }
      }, null);
      AppMethodBeat.o(35330);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doTalkRoomRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.WKb, Util.getStack() });
        if (this.WKb != null) {
          this.WKb.hMW();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.permission_location_request_again_msg), this.fgR.WQv.getMMResources().getString(R.l.permission_tips_title), this.fgR.WQv.getMMResources().getString(R.l.jump_to_settings), this.fgR.WQv.getMMResources().getString(R.l.cancel), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(184958);
          paramAnonymousDialogInterface = y.this.fgR.WQv;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/component/FootComponent$16", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$16", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(184958);
        }
      }, null);
      AppMethodBeat.o(35330);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        if (paramInt == 82)
        {
          Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuAudioSelected,footerEventImpl[%s], stack[%s]", new Object[] { this.WKb, Util.getStack() });
          if (this.WKb != null) {
            this.WKb.fqy();
          }
          AppMethodBeat.o(35330);
          return;
        }
        Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipAudioRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.WKb, Util.getStack() });
        if (this.WKb != null) {
          this.WKb.hMU();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.permission_microphone_request_again_msg), this.fgR.WQv.getMMResources().getString(R.l.permission_tips_title), this.fgR.WQv.getMMResources().getString(R.l.jump_to_settings), this.fgR.WQv.getMMResources().getString(R.l.cancel), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(288505);
          paramAnonymousDialogInterface = y.this.fgR.WQv;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/component/FootComponent$17", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$17", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(288505);
        }
      }, null);
      AppMethodBeat.o(35330);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        Log.i("MicroMsg.ChattingUI.FootComponent", "doSendFileRequest, footerEventImpl[%s], stack[%s].", new Object[] { this.WKb, Util.getStack() });
        if (this.WKb != null) {
          this.WKb.hMR();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.eON), this.fgR.WQv.getMMResources().getString(R.l.permission_tips_title), this.fgR.WQv.getMMResources().getString(R.l.jump_to_settings), this.fgR.WQv.getMMResources().getString(R.l.gallery_cancel), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(226113);
          paramAnonymousDialogInterface = y.this.fgR.WQv;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/component/FootComponent$18", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/FootComponent$18", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(226113);
        }
      }, null);
    }
  }
  
  public final void setVoiceInputShowCallback(ChatFooter.d paramd)
  {
    AppMethodBeat.i(35326);
    this.ESU.setVoiceInputShowCallback(paramd);
    AppMethodBeat.o(35326);
  }
  
  final class a
    implements TextWatcher
  {
    private boolean WKv = false;
    private List<String> WKw = null;
    
    private a() {}
    
    private static void c(List<String> paramList, String[] paramArrayOfString)
    {
      AppMethodBeat.i(289819);
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
      AppMethodBeat.o(289819);
    }
    
    private boolean hK(String paramString, int paramInt)
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
        if (this.WKw == null)
        {
          this.WKw = new LinkedList();
          localObject = y.this.fgR.WQv.getMMResources().getStringArray(R.c.merge_smiley_code_smiley);
          c(this.WKw, (String[])localObject);
          localObject = y.this.fgR.WQv.getMMResources().getStringArray(R.c.merge_smiley_softbank_emoji);
          c(this.WKw, (String[])localObject);
        }
        paramString = paramString.substring(0, paramInt);
        Object localObject = this.WKw.iterator();
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
      ((ap)y.this.fgR.bC(ap.class)).avG(1);
      Object localObject1 = (com.tencent.mm.ui.chatting.d.b.d)y.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class);
      paramCharSequence = String.valueOf(paramCharSequence);
      Object localObject2 = paramCharSequence.substring(paramInt1, paramInt1 + paramInt3);
      Object localObject3;
      if ((y.this.fgR.hRh()) && ("@".equals(localObject2)) && (!paramCharSequence.equals(y.this.ESU.getLastContent())) && (!y.this.ESU.Rju))
      {
        y.this.ESU.setLastContent(paramCharSequence);
        y.this.ESU.setInsertPos(paramInt1 + 1);
        if (hK(paramCharSequence, paramInt1))
        {
          localObject3 = com.tencent.mm.util.i.YyX;
          if (com.tencent.mm.util.i.a(com.tencent.mm.util.b.a.YxL, 1) == 1)
          {
            localObject3 = new com.tencent.mm.ui.chatting.atsomeone.d(y.this.fgR.WQv.getContext(), y.this.fgR.getTalkerUserName(), new com.tencent.mm.ui.chatting.atsomeone.b()
            {
              public final void oa(String paramAnonymousString1, String paramAnonymousString2)
              {
                AppMethodBeat.i(290512);
                ((com.tencent.mm.ui.chatting.d.b.as)y.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.as.class)).bp(y.this.fgR.getTalkerUserName(), paramAnonymousString2, paramAnonymousString1);
                AppMethodBeat.o(290512);
              }
            });
            ((com.tencent.mm.ui.chatting.atsomeone.d)localObject3).show();
            ((com.tencent.mm.ui.chatting.atsomeone.d)localObject3).setOnDismissListener(new DialogInterface.OnDismissListener()
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(219926);
                paramAnonymousDialogInterface = y.this.ESU;
                paramAnonymousDialogInterface.KQB.hZB();
                if (!paramAnonymousDialogInterface.BSf) {
                  paramAnonymousDialogInterface.showVKB();
                }
                AppMethodBeat.o(219926);
              }
            });
          }
        }
        else
        {
          ((com.tencent.mm.ui.chatting.d.b.ao)y.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.ao.class)).V(paramCharSequence, paramInt1, (String)localObject2);
          if ((!((com.tencent.mm.ui.chatting.d.b.d)localObject1).hOe()) && (!com.tencent.mm.storage.as.bvS(y.this.fgR.getTalkerUserName())))
          {
            localObject2 = y.this.ESU;
            if ((((ChatFooter)localObject2).Rjo != null) && (((ChatFooter)localObject2).jLo != null))
            {
              ((ChatFooter)localObject2).Rjo.Roh = true;
              localObject1 = ((ChatFooter)localObject2).Rjo;
              localObject2 = ((ChatFooter)localObject2).Rkl.getTalkerUserName();
              if (!Util.isNullOrNil(paramCharSequence)) {
                break label860;
              }
              ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).mHandler.removeMessages(20003);
              ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).mHandler.sendEmptyMessage(20001);
              ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).DqJ = paramCharSequence;
              if (((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Rol != null)
              {
                ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Rol.dead();
                ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Rol = null;
              }
            }
          }
        }
      }
      for (;;)
      {
        if ((ab.Lj(y.this.fgR.getTalkerUserName())) && (!y.this.ESU.hlP())) {
          y.this.ESU.brt(paramCharSequence);
        }
        AppMethodBeat.o(35313);
        return;
        localObject3 = Util.listToString(v.Ps(y.this.fgR.getTalkerUserName()), ",");
        Object localObject4 = new Intent();
        ((Intent)localObject4).setClass(y.this.fgR.WQv.getContext(), AtSomeoneUI.class);
        ((Intent)localObject4).putExtra("Block_list", z.bcZ());
        ((Intent)localObject4).putExtra("Chatroom_member_list", (String)localObject3);
        ((Intent)localObject4).putExtra("Chat_User", y.this.fgR.getTalkerUserName());
        ((Intent)localObject4).putExtra("Add_address_titile", y.this.fgR.WQv.getMMString(R.l.eQI));
        y.this.fgR.WQv.startActivityForResult((Intent)localObject4, 212);
        break;
        if ((((com.tencent.mm.ui.chatting.d.b.d)localObject1).hOf()) && ("@".equals(localObject2)) && (!paramCharSequence.equals(y.this.ESU.getLastContent())) && (!y.this.ESU.Rju))
        {
          y.this.ESU.setLastContent(paramCharSequence);
          y.this.ESU.setInsertPos(paramInt1 + 1);
          if (!hK(paramCharSequence, paramInt1)) {
            break;
          }
          localObject3 = ((com.tencent.mm.ui.chatting.d.b.d)localObject1).hOc().field_userList;
          localObject4 = new Intent();
          ((Intent)localObject4).setClass(y.this.fgR.WQv.getContext(), BizChatAtSomeoneUI.class);
          ((Intent)localObject4).putExtra("Block_list", com.tencent.mm.ao.af.bjz().gn(y.this.fgR.getTalkerUserName()));
          ((Intent)localObject4).putExtra("Chatroom_member_list", (String)localObject3);
          ((Intent)localObject4).putExtra("Chat_User", y.this.fgR.getTalkerUserName());
          ((Intent)localObject4).putExtra("Add_address_titile", y.this.fgR.WQv.getMMString(R.l.eQI));
          ((Intent)localObject4).putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.d.b.d)y.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOs());
          y.this.fgR.WQv.startActivityForResult((Intent)localObject4, 212);
          break;
        }
        if (paramCharSequence.equals(y.this.ESU.getLastContent())) {
          break;
        }
        y.this.ESU.setLastContent(paramCharSequence);
        break;
        label860:
        if (!paramCharSequence.equals(((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).DqJ))
        {
          ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).hide();
          if (((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Rol != null)
          {
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Rol.dead();
            ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Rol = null;
          }
          ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Rol = new com.tencent.mm.vending.e.c();
          localObject3 = String.valueOf(Util.nowMilliSecond());
          localObject4 = ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Rom;
          ((mh)localObject4).gcU = ((mh)localObject4).z("SessionId", (String)localObject3, true);
          localObject4 = ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Rom;
          ((mh)localObject4).gfa = ((mh)localObject4).z("ChatId", (String)localObject2, true);
          ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Roj.clear();
          ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Ron = 0;
          localObject4 = new com.tencent.mm.emoji.b.c.b(((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).Rol);
          kotlin.g.b.p.k(localObject3, "sessionId");
          com.tencent.mm.emoji.b.c.f localf = ((com.tencent.mm.emoji.b.c.b)localObject4).jKp;
          kotlin.g.b.p.k(localObject3, "sessionId");
          localf.username = ((String)localObject2);
          localf.sessionId = ((String)localObject3);
          localObject2 = new m.5((com.tencent.mm.pluginsdk.ui.chat.m)localObject1, Util.nowMilliSecond());
          kotlin.g.b.p.k(paramCharSequence, "desc");
          localObject3 = com.tencent.mm.emoji.b.c.d.jKB;
          com.tencent.mm.emoji.b.c.d.rE(0);
          com.tencent.mm.ae.d.b("EmojiSuggest_searchSuggest", (kotlin.g.a.a)new b.b((com.tencent.mm.emoji.b.c.b)localObject4, paramCharSequence, (j.b)localObject2));
        }
        ((com.tencent.mm.pluginsdk.ui.chat.m)localObject1).DqJ = paramCharSequence;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.y
 * JD-Core Version:    0.7.0.1
 */