package com.tencent.mm.ui.chatting.component;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.an.af;
import com.tencent.mm.an.g;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.c;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.autogen.a.ty;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cn;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.api.e.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.textstatus.a.ac;
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
import com.tencent.mm.pluginsdk.ui.chat.a.a;
import com.tencent.mm.pluginsdk.ui.chat.a.b;
import com.tencent.mm.pluginsdk.ui.chat.a.c;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.pluginsdk.ui.chat.m;
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
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.ai;
import com.tencent.mm.ui.chatting.component.api.ah;
import com.tencent.mm.ui.chatting.component.api.ap;
import com.tencent.mm.ui.chatting.component.api.av;
import com.tencent.mm.ui.chatting.component.api.aw;
import com.tencent.mm.ui.chatting.component.api.x;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.chatting.y;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.view.MaxHeightScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=x.class)
public class ab
  extends a
  implements MStorage.IOnStorageChange, MStorageEx.IOnStorageChange, x
{
  private static ArrayList<a.a> aesc = null;
  private static long aesd = 0L;
  protected ChatFooter KNy;
  private final ChatFooter.g YfB;
  private s aese;
  protected ChatFooterCustom aesf;
  private int aesg;
  private com.tencent.mm.ui.chatting.w aesh;
  private com.tencent.mm.ui.chatting.z aesi;
  private com.tencent.mm.ui.chatting.k aesj;
  private com.tencent.mm.ui.chatting.i aesk;
  private AnimationSet aesl;
  private String aesm;
  private int aesn;
  private int aeso;
  private boolean aesp;
  public boolean aesq;
  private boolean aesr;
  public boolean aess;
  private long aest;
  private IListener lzh;
  private IListener lzi;
  
  public ab()
  {
    AppMethodBeat.i(35314);
    this.aesg = 0;
    this.aesm = null;
    this.aesp = false;
    this.aesq = false;
    this.lzh = new FootComponent.1(this, com.tencent.mm.app.f.hfK);
    this.lzi = new FootComponent.2(this, com.tencent.mm.app.f.hfK);
    this.YfB = new ChatFooter.g()
    {
      private Animation aesv;
      private Animation aesw;
      
      public final boolean Ke(boolean paramAnonymousBoolean)
      {
        int i = 1;
        AppMethodBeat.i(35305);
        if (this.aesv == null)
        {
          this.aesv = AnimationUtils.loadAnimation(ab.this.hlc.aezO.getContext(), R.a.push_up_in);
          this.aesw = AnimationUtils.loadAnimation(ab.this.hlc.aezO.getContext(), R.a.push_down_out);
        }
        com.tencent.mm.ui.chatting.component.api.e locale;
        String str;
        if (paramAnonymousBoolean)
        {
          Log.i("MicroMsg.ChattingUI.FootComponent", "switchFooterToInput customFooter is %s", new Object[] { ab.this.aesf });
          if (ab.this.aesf != null) {
            ab.this.aesf.startAnimation(this.aesw);
          }
          ab.this.jsj();
          ab.this.KNy.startAnimation(this.aesv);
          ab.this.KNy.postInvalidateDelayed(this.aesv.getDuration());
          locale = (com.tencent.mm.ui.chatting.component.api.e)ab.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class);
          if (locale != null)
          {
            str = ab.this.hlc.getTalkerUserName();
            if (!paramAnonymousBoolean) {
              break label264;
            }
          }
        }
        for (;;)
        {
          locale.iQ(str, i);
          AppMethodBeat.o(35305);
          return false;
          ab.this.KNy.startAnimation(this.aesw);
          ab.this.jsi();
          if (ab.this.aesf == null) {
            break;
          }
          ab.this.aesf.startAnimation(this.aesv);
          ab.this.aesf.postInvalidateDelayed(this.aesv.getDuration());
          break;
          label264:
          i = 2;
        }
      }
    };
    this.aesr = false;
    this.aess = false;
    this.aest = 0L;
    AppMethodBeat.o(35314);
  }
  
  private void a(String paramString, com.tencent.mm.storage.au paramau, ArrayList<a.a> paramArrayList)
  {
    AppMethodBeat.i(163316);
    long l1;
    if (paramau == null)
    {
      l1 = 0L;
      Log.i("MicroMsg.ChattingUI.FootComponent", "ChatroomBusinessType user %s %s", new Object[] { paramString, Long.valueOf(l1) });
      if ((!this.hlc.juF()) || (paramau == null) || (paramau.kax == 0L)) {
        break label222;
      }
      if (aesc != null) {
        break label166;
      }
      aesc = new ArrayList();
      jsq();
      aesd = cn.bDu();
    }
    for (;;)
    {
      paramString = aesc;
      if ((paramString == null) || (paramString.size() <= 0)) {
        break label222;
      }
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        a.a locala = (a.a)paramString.next();
        if ((locala.YeV & paramau.kax) != 0L)
        {
          locala.icX = paramau.field_username;
          paramArrayList.add(locala);
        }
      }
      l1 = paramau.kax;
      break;
      label166:
      l1 = cn.bDu();
      long l2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkQ, 1800);
      if (l1 - aesd > l2)
      {
        aesd = l1;
        aesc.clear();
        jsq();
      }
    }
    label222:
    this.KNy.setAppPanelUnCertainEnterArrayList(paramArrayList);
    AppMethodBeat.o(163316);
  }
  
  private void b(final String paramString, final az.b.a parama)
  {
    AppMethodBeat.i(163315);
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(256307);
        az.a.okP.a(paramString, "", parama);
        AppMethodBeat.o(256307);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(256308);
        String str = super.toString() + "|getContactCallBack2";
        AppMethodBeat.o(256308);
        return str;
      }
    });
    AppMethodBeat.o(163315);
  }
  
  private void bAO(final String paramString)
  {
    AppMethodBeat.i(35325);
    Log.i("MicroMsg.ChattingUI.FootComponent", "initFooterPanelMenu %s", new Object[] { paramString });
    this.KNy.iMj();
    this.KNy.iLZ();
    int i;
    Object localObject1;
    int j;
    label126:
    boolean bool1;
    if (((com.tencent.mm.ui.chatting.component.api.n)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.n.class)).jrJ())
    {
      Log.w("MicroMsg.ChattingUI.FootComponent", "match shake, in show mode, do not open short video recode view");
      i = 0;
      if (i == 0) {
        this.KNy.iMl();
      }
      if (((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jqV())
      {
        localObject1 = g.hU(this.hlc.getTalkerUserName());
        if ((localObject1 != null) && (((com.tencent.mm.api.c)localObject1).field_enterpriseFather != null)) {
          break label3149;
        }
        j = 0;
        if (j != 0)
        {
          localObject1 = this.KNy.Yfb;
          ((AppPanel)localObject1).YdH.Yez.value = true;
          ((AppPanel)localObject1).iLL();
        }
      }
      if (!this.hlc.juG()) {
        this.KNy.iMu();
      }
      bool1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVD, true);
      localObject1 = this.KNy;
      if (!BuildInfo.DEBUG) {
        break label3203;
      }
      i = 1;
      label206:
      Log.i("MicroMsg.ChattingUI.FootComponent", "isGroupChat:%b enableLive:%b", new Object[] { Boolean.valueOf(this.hlc.juG()), Boolean.valueOf(bool1) });
      if ((this.hlc.juG()) && (bool1) && (i != 0)) {
        break label3431;
      }
      this.KNy.Yfb.iLJ();
      label268:
      if (!com.tencent.mm.storage.au.bwG(this.hlc.getTalkerUserName())) {
        this.KNy.Yfb.iLJ();
      }
      if ((this.hlc.Uxa != null) && (!com.tencent.mm.contact.d.rs(this.hlc.Uxa.field_type)) && (!com.tencent.mm.storage.au.bwE(this.hlc.getTalkerUserName()))) {
        this.KNy.iMo();
      }
      if (com.tencent.mm.storage.au.bwS(paramString))
      {
        this.KNy.Yfb.iLB();
        this.KNy.Yfb.iLD();
        this.KNy.Yfb.iLE();
        this.KNy.iMm();
        this.KNy.iMn();
        this.KNy.Yfb.iLC();
        this.KNy.bG(true, true);
        this.KNy.iMo();
        this.KNy.iMq();
        this.KNy.Yfb.iLG();
        this.KNy.Yfb.iLJ();
        this.KNy.Yfb.iLK();
      }
      if (com.tencent.mm.storage.au.bwN(paramString))
      {
        this.KNy.Yfb.iLB();
        this.KNy.Yfb.iLD();
        this.KNy.Yfb.iLE();
        this.KNy.iMm();
        this.KNy.iMn();
        this.KNy.Yfb.iLC();
        this.KNy.bG(true, true);
        this.KNy.iMo();
        this.KNy.iMq();
        this.KNy.Yfb.iLG();
        this.KNy.Yfb.iLJ();
        this.KNy.Yfb.iLK();
      }
      if (com.tencent.mm.storage.au.bwL(paramString))
      {
        this.KNy.Yfb.iLB();
        this.KNy.Yfb.iLD();
        this.KNy.Yfb.iLE();
        this.KNy.iMm();
        this.KNy.iMi();
        this.KNy.iMn();
        this.KNy.Yfb.iLC();
        this.KNy.bG(true, true);
        this.KNy.iMo();
        this.KNy.iMq();
        this.KNy.Yfb.iLG();
        this.KNy.Yfb.iLJ();
        this.KNy.Yfb.iLK();
      }
      if (com.tencent.mm.storage.au.bwY(paramString))
      {
        this.KNy.iLZ();
        if (!ac.hGo())
        {
          this.KNy.iMk();
          this.KNy.iMt();
          this.KNy.iKh();
          this.KNy.Yfb.iLF();
          this.KNy.getChatFooterPanel().setShowSearch(false);
        }
        this.KNy.iMi();
        this.KNy.Yfb.iLE();
        this.KNy.iMu();
        this.KNy.iMn();
        this.KNy.bG(true, true);
        this.KNy.JN(true);
        this.KNy.JO(true);
        this.KNy.iMo();
        this.KNy.iMq();
        this.KNy.Yfb.iLC();
        this.KNy.Yfb.iLB();
        this.KNy.Yfb.iLD();
        this.KNy.Yfb.iLG();
        this.KNy.iMp();
        this.KNy.Yfb.iLK();
      }
      if (com.tencent.mm.storage.au.aAy(paramString))
      {
        this.KNy.iLZ();
        this.KNy.iMi();
        this.KNy.Yfb.iLE();
        this.KNy.iMu();
        this.KNy.iMn();
        this.KNy.iMk();
        this.KNy.Yfb.iLB();
        this.KNy.iMl();
        this.KNy.iMn();
        this.KNy.iMt();
        this.KNy.iKh();
        this.KNy.Yfb.iLF();
        this.KNy.bG(true, true);
        this.KNy.JN(true);
        this.KNy.JO(true);
        this.KNy.iMo();
        this.KNy.iMq();
        this.KNy.Yfb.iLC();
        this.KNy.Yfb.iLB();
        this.KNy.Yfb.iLD();
        this.KNy.Yfb.iLG();
        this.KNy.Yfb.iLK();
      }
      if (com.tencent.mm.storage.au.bwf(paramString))
      {
        this.KNy.Yfb.iLB();
        this.KNy.Yfb.iLD();
        this.KNy.Yfb.iLE();
        this.KNy.iMn();
        this.KNy.Yfb.iLC();
        this.KNy.bG(true, true);
        this.KNy.iMo();
        this.KNy.iMq();
        this.KNy.Yfb.iLG();
        this.KNy.Yfb.iLJ();
        this.KNy.Yfb.iLK();
      }
      if (com.tencent.mm.storage.au.bwc(paramString))
      {
        this.KNy.Yfb.iLB();
        this.KNy.bG(true, true);
        this.KNy.Yfb.iLC();
        this.KNy.Yfb.iLG();
        this.KNy.Yfb.iLJ();
        this.KNy.Yfb.iLK();
      }
      if (com.tencent.mm.storage.au.bwQ(paramString))
      {
        this.KNy.iMk();
        this.KNy.iKh();
        this.KNy.Yfb.iLF();
      }
      bh.bCz();
      localObject1 = com.tencent.mm.model.c.bzA().JE(paramString);
      if ((localObject1 != null) && (((com.tencent.mm.storage.au)localObject1).iZC()))
      {
        if (!((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jqV()) {
          break label3457;
        }
        this.KNy.Yfb.iLB();
        this.KNy.Yfb.iLE();
        this.KNy.Yfb.iLC();
        this.KNy.bG(true, true);
        this.KNy.iMo();
        this.KNy.iMq();
        this.KNy.iMl();
        this.KNy.Yfb.iLF();
        this.KNy.iMk();
        this.KNy.iMt();
        this.KNy.iKh();
        this.KNy.Yfb.iLJ();
      }
    }
    for (;;)
    {
      try
      {
        new ty().publish();
        if ((com.tencent.mm.storage.au.bwO(paramString)) || (com.tencent.mm.storage.au.bwF(paramString))) {
          this.KNy.Yfb.iLK();
        }
        if (this.hlc.juF())
        {
          if (com.tencent.mm.k.i.aRC().getInt("MultitalkBlockCaller", 0) == 0)
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            this.KNy.JN(false);
            if ((this.hlc.juG()) || (this.hlc.juE())) {
              this.KNy.bG(true, true);
            }
            if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRg, 0) != 1) {
              continue;
            }
            i = 1;
            bool1 = com.tencent.mm.storage.au.bwG(this.hlc.getTalkerUserName());
            if (((this.hlc.juG()) && (!bool1)) || (com.tencent.mm.model.ab.II(this.hlc.getTalkerUserName())) || ((bool1) && (!com.tencent.mm.model.z.bBm())) || ((bool1) && (i == 0))) {
              this.KNy.iMq();
            }
            if (com.tencent.mm.br.c.iPe())
            {
              this.KNy.Yfb.iLC();
              this.KNy.bG(true, true);
              this.KNy.iMm();
              this.KNy.Yfb.iLD();
              this.KNy.Yfb.iLJ();
            }
            if (this.hlc.juE()) {
              this.KNy.Yfb.iLC();
            }
            if (this.hlc.getTalkerUserName().equals(com.tencent.mm.model.z.bAM()))
            {
              this.KNy.Yfb.iLC();
              this.KNy.bG(true, true);
              this.KNy.iMo();
              this.KNy.iMq();
              this.KNy.Yfb.iLJ();
            }
            this.KNy.setAppPanelTip(null);
            if ((!com.tencent.mm.storage.au.bwO(this.hlc.Uxa.field_username)) && (!com.tencent.mm.storage.au.bwF(this.hlc.Uxa.field_username)) && (!com.tencent.mm.storage.au.bwQ(this.hlc.Uxa.field_username))) {
              continue;
            }
            if (!com.tencent.mm.storage.au.bwQ(this.hlc.Uxa.field_username)) {
              continue;
            }
            i = 1;
            com.tencent.mm.kernel.h.baF();
            Object localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.hlc.Uxa.field_username);
            ((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).u(((com.tencent.mm.autogen.b.az)localObject4).field_openImAppid, ((com.tencent.mm.autogen.b.az)localObject4).field_descWordingId, i);
            j = ((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).bl(((com.tencent.mm.autogen.b.az)localObject4).field_openImAppid, i);
            Object localObject2 = ((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).a(this.hlc.Uxa.field_openImAppid, "openim_function_tip", e.a.prb, i);
            Log.i("MicroMsg.ChattingUI.FootComponent", "openim showFlag:%d username: %s appid: %s tip %s", new Object[] { Integer.valueOf(j), this.hlc.Uxa.field_username, ((com.tencent.mm.autogen.b.az)localObject4).field_openImAppid, localObject2 });
            if ((j & 0x1) == 0) {
              this.KNy.iMi();
            }
            if ((j & 0x2) == 0) {
              this.KNy.iMk();
            }
            if ((j & 0x4) == 0) {
              this.KNy.iMs();
            }
            if ((j & 0x8) == 0) {
              this.KNy.iMm();
            }
            if ((j & 0x10) == 0) {
              this.KNy.Yfb.iLD();
            }
            if ((j & 0x20) == 0) {
              this.KNy.Yfb.iLB();
            }
            if ((j & 0x40) == 0) {
              this.KNy.Yfb.iLG();
            }
            if ((j & 0x80) == 0) {
              this.KNy.iMn();
            }
            if (((j & 0x100) == 0) || ((j & 0x2000) == 0))
            {
              localObject4 = this.KNy;
              if ((j & 0x100) != 0) {
                continue;
              }
              bool1 = true;
              if ((j & 0x2000) != 0) {
                continue;
              }
              bool2 = true;
              ((ChatFooter)localObject4).bG(bool1, bool2);
            }
            if ((j & 0x200) != 0) {
              continue;
            }
            this.KNy.iMo();
            Log.i("MicroMsg.ChattingUI.FootComponent", "openIM disableServiceLuckyMoney");
            if ((j & 0x4000) != 0) {
              continue;
            }
            this.KNy.iMq();
            Log.i("MicroMsg.ChattingUI.FootComponent", "openIM disableServiceRemittance");
            if ((j & 0x400) == 0) {
              this.KNy.iMp();
            }
            if ((com.tencent.mm.storage.au.bwF(this.hlc.Uxa.field_username)) && ((j & 0x100) == 0)) {
              this.KNy.JN(true);
            }
            if (com.tencent.mm.storage.au.bwQ(paramString)) {
              continue;
            }
            this.KNy.setAppPanelTip((CharSequence)localObject2);
            localObject2 = this.KNy;
            bool1 = com.tencent.mm.br.c.iPe();
            if (((ChatFooter)localObject2).moD != null) {
              ((ChatFooter)localObject2).moD.JA(bool1);
            }
            localObject2 = this.KNy;
            if ((!com.tencent.mm.br.c.iPe()) && (!com.tencent.mm.au.b.bKI())) {
              continue;
            }
            bool1 = true;
            ((ChatFooter)localObject2).JO(bool1);
            this.KNy.Yfb.iLC();
            if (com.tencent.mm.storage.au.Hh(this.hlc.getTalkerUserName()))
            {
              this.KNy.iLZ();
              this.KNy.iMi();
              this.KNy.Yfb.iLE();
              this.KNy.iMu();
              this.KNy.Yfb.iLJ();
              this.KNy.iMn();
              this.KNy.iMk();
              this.KNy.iMm();
              this.KNy.Yfb.iLB();
              this.KNy.iMl();
              this.KNy.iMn();
              this.KNy.iMk();
              this.KNy.iMt();
              this.KNy.iKh();
              this.KNy.Yfb.iLF();
              this.KNy.bG(true, true);
              this.KNy.JN(true);
              this.KNy.JO(true);
              this.KNy.iMo();
              this.KNy.iMq();
              this.KNy.Yfb.iLC();
              this.KNy.Yfb.iLB();
              this.KNy.Yfb.iLD();
              this.KNy.Yfb.iLG();
              this.KNy.Yfb.iLK();
            }
            if (com.tencent.mm.storage.au.bwW(paramString))
            {
              this.KNy.iLZ();
              if (((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.d.class)).fIm()) {
                continue;
              }
              localObject2 = this.KNy;
              ((ChatFooter)localObject2).YfU = true;
              ((ChatFooter)localObject2).Yfi.setVisibility(8);
              ((ChatFooter)localObject2).Kd(false);
              if (!((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.d.class)).fIp())
              {
                this.KNy.iMk();
                this.KNy.iMt();
                this.KNy.iKh();
                this.KNy.Yfb.iLF();
              }
              this.KNy.iMi();
              this.KNy.Yfb.iLE();
              this.KNy.iMu();
              this.KNy.iMn();
              this.KNy.bG(true, true);
              this.KNy.JN(true);
              this.KNy.JO(true);
              this.KNy.iMo();
              this.KNy.iMq();
              this.KNy.Yfb.iLC();
              this.KNy.Yfb.iLB();
              this.KNy.Yfb.iLD();
              this.KNy.Yfb.iLG();
              this.KNy.iMp();
              this.KNy.Yfb.iLK();
            }
            if (!com.tencent.mm.storage.au.bwG(this.hlc.getTalkerUserName())) {
              this.KNy.Yfb.iLH();
            }
            if (!((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aHL(this.hlc.getTalkerUserName())) {
              this.KNy.Yfb.iLI();
            }
            localObject2 = new ArrayList();
            a(paramString, (com.tencent.mm.storage.au)localObject1, (ArrayList)localObject2);
            paramString = new az.b.a()
            {
              public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(163312);
                if ((paramAnonymousBoolean) && (Util.isEqual(ab.this.hlc.getTalkerUserName(), paramAnonymousString))) {
                  com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(163310);
                      ab.a(ab.this, ab.14.this.hkS, ab.14.this.lMP, new ArrayList());
                      MMHandlerThread.postToMainThread(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(163309);
                          ab.this.KNy.iMM();
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
            if ((((ArrayList)localObject2).size() != 0) || (localObject1 == null) || (((com.tencent.mm.autogen.b.az)localObject1).kax != 0L)) {
              continue;
            }
            if (!com.tencent.mm.storage.au.bwE(this.hlc.getTalkerUserName())) {
              continue;
            }
            localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.hlc.getTalkerUserName());
            if ((localObject1 != null) && ((((aj)localObject1).field_chatroomStatus & 0x8000) != 0L) && ((((aj)localObject1).field_chatroomfamilystatusmodifytime == 0L) || (((aj)localObject1).field_chatroomfamilystatusmodifytime - cn.bDv() >= 86400000L)))
            {
              ((aj)localObject1).field_chatroomfamilystatusmodifytime = cn.bDv();
              ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().update((IAutoDBItem)localObject1, new String[0]);
              b(this.hlc.getTalkerUserName(), paramString);
            }
            AppMethodBeat.o(35325);
            return;
            bool1 = ((com.tencent.mm.ui.chatting.component.api.au)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class)).jtz();
            bool2 = ((com.tencent.mm.ui.chatting.component.api.au)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class)).jty();
            if ((bool1) || (bool2))
            {
              Log.w("MicroMsg.ChattingUI.FootComponent", "match shake, in search mode, do not open short video recode view");
              i = 0;
              break;
            }
            if ((com.tencent.mm.storage.au.bwN(this.hlc.getTalkerUserName())) || (com.tencent.mm.storage.au.bwS(this.hlc.getTalkerUserName())))
            {
              Log.w("MicroMsg.ChattingUI.FootComponent", "match shake, but is Qcontact or Bcontact");
              i = 0;
              break;
            }
            if (com.tencent.mm.model.ab.IV(this.hlc.getTalkerUserName()))
            {
              i = 0;
              break;
            }
            i = 1;
            break;
            label3149:
            localObject1 = af.bHf().Mp(((com.tencent.mm.api.c)localObject1).field_enterpriseFather);
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
            label3203:
            if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
            {
              i = Util.getInt(com.tencent.mm.k.i.aRC().getValue("ChatRoomEnableLive"), 0);
              if (i == 0)
              {
                localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(((ChatFooter)localObject1).Yfa);
                if (localObject1 == null) {
                  break label3864;
                }
                if ((((aj)localObject1).field_chatroomStatus & 0x80000) == 524288)
                {
                  j = 1;
                  i = j;
                  if (j != 0) {
                    break label206;
                  }
                  if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adfp, 0) != 1) {
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
            if (((ChatFooter)localObject1).Yfa == null) {
              continue;
            }
            i = Util.getInt(com.tencent.mm.k.i.aRC().getValue("ChatRoomEnableLive"), 0);
            if (i == 0)
            {
              localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(((ChatFooter)localObject1).Yfa);
              if (localObject1 == null) {
                continue;
              }
              if ((((aj)localObject1).field_chatroomStatus & 0x80000) == 524288)
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
            label3431:
            localObject1 = this.KNy.Yfb;
            ((AppPanel)localObject1).YdH.JV(true);
            ((AppPanel)localObject1).iLL();
            break label268;
            label3457:
            this.KNy.Yfb.iLB();
            this.KNy.bG(true, true);
            this.KNy.iMm();
            this.KNy.Yfb.iLC();
            this.KNy.Yfb.iLJ();
            continue;
          }
          i = 0;
          continue;
        }
        this.KNy.JN(true);
        continue;
        i = 0;
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
        this.KNy.setAppPanelTip(null);
        continue;
        if (!com.tencent.mm.model.ab.II(this.hlc.Uxa.field_username)) {
          continue;
        }
        i = com.tencent.mm.model.z.bBN();
        if ((i & 0x1) == 0) {
          this.KNy.JN(true);
        }
        if ((i & 0x2) == 0) {
          this.KNy.iMo();
        }
        if ((i & 0x4) != 0) {
          continue;
        }
        this.KNy.iMp();
        continue;
        bool1 = false;
        continue;
        if (!((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.d.class)).fIn()) {
          this.KNy.iMs();
        }
        if (((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.d.class)).fIo()) {
          continue;
        }
        this.KNy.iMm();
        this.KNy.iMl();
        continue;
        if (com.tencent.mm.storage.au.bwF(this.hlc.getTalkerUserName()))
        {
          localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.hlc.getTalkerUserName());
          if ((localObject1 != null) && ((((aj)localObject1).iZg().type & 0x4) != 0L) && ((((aj)localObject1).field_chatroomfamilystatusmodifytime == 0L) || (((aj)localObject1).field_chatroomfamilystatusmodifytime - cn.bDv() >= 86400000L)))
          {
            ((aj)localObject1).field_chatroomfamilystatusmodifytime = cn.bDv();
            ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().update((IAutoDBItem)localObject1, new String[0]);
            b(this.hlc.getTalkerUserName(), paramString);
          }
          AppMethodBeat.o(35325);
          return;
        }
        AppMethodBeat.o(35325);
        return;
      }
      finally
      {
        continue;
        i = 0;
      }
      break label206;
      label3864:
      j = 0;
    }
  }
  
  private static void bAP(String paramString)
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
        locala.YeJ = paramString.optString("enter_id");
        locala.red_dot = paramString.optInt("red_dot");
        locala.jump_type = paramString.optInt("jump_type");
        locala.YeK = paramString.optString("wa_un");
        locala.YeM = paramString.optInt("wa_ver");
        locala.YeN = paramString.optString("wa_path");
        locala.YeO = paramString.optString("wa_dgmode");
        locala.ttL = paramString.optString("h5_url");
        locala.iconUrl = paramString.optString("icon_url");
        locala.PNd = paramString.optString("icon_url_dark");
        if (Util.isNullOrNil(locala.iconUrl))
        {
          Log.e("MicroMsg.ChattingUI.FootComponent", "unCertainEnter.iconUrl is null");
        }
        else
        {
          locala.YeV = paramString.optLong("busi_type");
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
      locala.YeP.title = ((JSONObject)localObject).optString("zh_cn");
      if (Util.isNullOrNil(locala.YeP.title))
      {
        Log.e("MicroMsg.ChattingUI.FootComponent", "unCertainEnter.simpleChWord.title is null");
      }
      else
      {
        a.b localb = locala.YeR;
        if (Util.isNullOrNil(((JSONObject)localObject).optString("zh_tw")))
        {
          paramString = locala.YeP.title;
          localb.title = paramString;
          localb = locala.YeQ;
          if (!Util.isNullOrNil(((JSONObject)localObject).optString("zh_hk"))) {
            break label586;
          }
          paramString = locala.YeP.title;
          label391:
          localb.title = paramString;
          localb = locala.YeS;
          if (!Util.isNullOrNil(((JSONObject)localObject).optString("en"))) {
            break label598;
          }
          paramString = locala.YeP.title;
          label427:
          localb.title = paramString;
          if (localJSONObject != null)
          {
            locala.YeP.desc = localJSONObject.optString("zh_cn");
            localObject = locala.YeR;
            if (!Util.isNullOrNil(localJSONObject.optString("zh_tw"))) {
              break label610;
            }
            paramString = locala.YeP.desc;
            label484:
            ((a.b)localObject).desc = paramString;
            localObject = locala.YeQ;
            if (!Util.isNullOrNil(localJSONObject.optString("zh_hk"))) {
              break label622;
            }
            paramString = locala.YeP.desc;
            label520:
            ((a.b)localObject).desc = paramString;
            localObject = locala.YeS;
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
        for (paramString = locala.YeP.desc;; paramString = localJSONObject.optString("en"))
        {
          ((a.b)localObject).desc = paramString;
          aesc.add(locala);
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
  
  private void jsf()
  {
    AppMethodBeat.i(35315);
    if (this.hlc.aezO.isCurrentActivity)
    {
      AppMethodBeat.o(35315);
      return;
    }
    this.hlc.aezQ.jpN();
    if (this.KNy != null)
    {
      ChatFooter localChatFooter = this.KNy;
      Object localObject = localChatFooter.findViewById(R.h.fzq);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localChatFooter.setSwitchButtonMode(0);
      localChatFooter.mHandler.removeMessages(1002);
      if (localChatFooter.Yfi != null) {
        localChatFooter.Yfi.setVisibility(8);
      }
      if (localChatFooter.Yfj != null) {
        localChatFooter.Yfj.setVisibility(8);
      }
      if (localChatFooter.Yfk != null) {
        localChatFooter.Yfk.setVisibility(8);
      }
      if (localChatFooter.Yfn != null) {
        localChatFooter.Yfn.setVisibility(8);
      }
      if (localChatFooter.Yfl != null) {
        localChatFooter.Yfl.setVisibility(8);
      }
      if (localChatFooter.Yfo != null) {
        localChatFooter.Yfo.setVisibility(8);
      }
      localChatFooter.mkz.setVisibility(8);
      if (localChatFooter.AhM != null) {
        localChatFooter.AhM.setVisibility(8);
      }
      if (localChatFooter.YgD != null) {
        localChatFooter.YgD.setVisibility(8);
      }
      if (localChatFooter.AhN != null) {
        localChatFooter.AhN.setVisibility(8);
      }
      if (localChatFooter.AhK != null) {
        localChatFooter.AhK.setVisibility(8);
      }
      if (localChatFooter.Yab != null)
      {
        localChatFooter.Yab.setVisibility(8);
        localChatFooter.Yae = false;
        localChatFooter.Yab.destroy();
      }
      if (localChatFooter.YfM != null) {
        localChatFooter.YfM.setVisibility(8);
      }
      if (localChatFooter.SOq != null) {
        localChatFooter.SOq.setVisibility(8);
      }
      if (localChatFooter.SOn != null) {
        localChatFooter.SOn.update();
      }
      if (localChatFooter.Yfc != null) {
        localChatFooter.Yfc.setVisibility(8);
      }
      if (localChatFooter.Yfg != null)
      {
        localChatFooter.Yfg.setVisibility(4);
        if (localChatFooter.moD != null) {
          localChatFooter.moD.setVisibility(4);
        }
      }
      localChatFooter.Yfb = ((AppPanel)localChatFooter.findViewById(R.h.fvL));
      if (localChatFooter.Yfb != null)
      {
        localChatFooter.Yfb.setChattingContext(localChatFooter.Ygv);
        localChatFooter.setAppPanelVisible(8);
        localObject = localChatFooter.Yfb;
        if (((AppPanel)localObject).PcX != null) {
          ((AppPanel)localObject).PcX.setToScreen(0);
        }
        ((AppPanel)localObject).YdF = 0;
      }
      localChatFooter.a(ChatFooter.h.Yjy);
      localChatFooter.s(0, false, -1);
      localChatFooter.YfG = false;
      this.KNy.iLX();
      this.KNy.iLY();
      this.KNy.YfD.Yjo = null;
    }
    AppMethodBeat.o(35315);
  }
  
  private void jsk()
  {
    AppMethodBeat.i(35319);
    Log.i("MicroMsg.ChattingUI.FootComponent", "[goneFooter] %s", new Object[] { Util.getStack() });
    if (this.KNy != null)
    {
      this.KNy.Kb(false);
      this.KNy.setVisibility(8);
    }
    if (this.aesf != null) {
      this.aesf.setVisibility(8);
    }
    this.KNy.JY(false);
    this.hlc.hideVKB();
    AppMethodBeat.o(35319);
  }
  
  private void jso()
  {
    AppMethodBeat.i(184963);
    if (this.KNy == null)
    {
      Log.e("MicroMsg.ChattingUI.FootComponent", "initTodoView footer == null");
      AppMethodBeat.o(184963);
      return;
    }
    Log.i("MicroMsg.ChattingUI.FootComponent", "initTodoView()");
    ((com.tencent.mm.ui.chatting.component.api.ab)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.ab.class)).a(this.KNy.getIOnToDoBarCallback());
    this.KNy.setIOnTodoViewCallback(new af.c()
    {
      public final void LW(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(185864);
        ((com.tencent.mm.ui.chatting.component.api.ab)ab.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.ab.class)).LW(paramAnonymousBoolean);
        AppMethodBeat.o(185864);
      }
      
      public final void LX(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(185865);
        ((com.tencent.mm.ui.chatting.component.api.ab)ab.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.ab.class)).LX(paramAnonymousBoolean);
        AppMethodBeat.o(185865);
      }
      
      public final int fJG()
      {
        AppMethodBeat.i(185866);
        int i = ((com.tencent.mm.ui.chatting.component.api.ab)ab.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.ab.class)).fJG();
        AppMethodBeat.o(185866);
        return i;
      }
    });
    AppMethodBeat.o(184963);
  }
  
  private void jsp()
  {
    AppMethodBeat.i(255887);
    if (this.KNy == null)
    {
      Log.e("MicroMsg.ChattingUI.FootComponent", "initTranslateView footer == null");
      AppMethodBeat.o(255887);
      return;
    }
    Log.i("MicroMsg.ChattingUI.FootComponent", "initTranslateView()");
    ((com.tencent.mm.ui.chatting.component.api.bd)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.bd.class)).a(this.KNy.getIOnTranslateResCallback());
    this.KNy.setIOnTranslateViewController(new bq.d()
    {
      public final void LY(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(256302);
        ((com.tencent.mm.ui.chatting.component.api.bd)ab.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.bd.class)).Md(paramAnonymousBoolean);
        AppMethodBeat.o(256302);
      }
      
      public final boolean jsr()
      {
        AppMethodBeat.i(256304);
        boolean bool = ((com.tencent.mm.ui.chatting.component.api.bd)ab.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.bd.class)).jsr();
        AppMethodBeat.o(256304);
        return bool;
      }
    });
    AppMethodBeat.o(255887);
  }
  
  private static void jsq()
  {
    AppMethodBeat.i(163317);
    bAP(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkG, ""));
    bAP(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkH, ""));
    bAP(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkI, ""));
    bAP(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkJ, ""));
    bAP(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkK, ""));
    bAP(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkL, ""));
    bAP(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkM, ""));
    bAP(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkN, ""));
    bAP(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkO, ""));
    bAP(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkP, ""));
    AppMethodBeat.o(163317);
  }
  
  public final boolean aG(com.tencent.mm.storage.au paramau)
  {
    AppMethodBeat.i(35322);
    boolean bool1 = ((com.tencent.mm.ui.chatting.component.api.au)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class)).jtz();
    boolean bool2 = ((com.tencent.mm.ui.chatting.component.api.au)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class)).jty();
    boolean bool3 = ((com.tencent.mm.ui.chatting.component.api.n)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.n.class)).jrJ();
    boolean bool4 = ((com.tencent.mm.ui.chatting.component.api.v)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.v.class)).jsc();
    boolean bool5 = ((ap)this.hlc.cm(ap.class)).jtm();
    if (this.aesq)
    {
      AppMethodBeat.o(35322);
      return true;
    }
    if ((bool1) || (bool2) || (bool3) || (bool4) || (bool5))
    {
      Log.i("MicroMsg.ChattingUI.FootComponent", bool1 + ", " + bool2 + ", " + bool3 + ", " + bool4 + ", " + bool5);
      jsk();
      AppMethodBeat.o(35322);
      return false;
    }
    if ((paramau != null) && (com.tencent.mm.model.ab.IP(paramau.field_username)))
    {
      this.aesj = new com.tencent.mm.ui.chatting.k(this.aesf);
      this.aesj.jmr();
      jsi();
      AppMethodBeat.o(35322);
      return true;
    }
    if ((paramau != null) && (com.tencent.mm.storage.au.bwE(paramau.field_username)) && (((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).alQ(paramau.field_username)))
    {
      if (this.aesf == null)
      {
        jsk();
        n.c(this.hlc.aezO, R.h.fOY);
        this.aesf = ((ChatFooterCustom)this.hlc.findViewById(R.h.fPa));
        this.aesf.ae((ViewGroup)this.hlc.findViewById(R.h.fxv));
      }
      this.aesk = new com.tencent.mm.ui.chatting.i(this.aesf);
      this.aesk.jmr();
      jsi();
      AppMethodBeat.o(35322);
      return false;
    }
    com.tencent.mm.ui.chatting.component.api.e locale;
    Object localObject1;
    int i;
    if ((paramau != null) && (paramau.iZC()))
    {
      locale = (com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class);
      if (locale.jqS() != null)
      {
        localObject1 = locale.jqS().dO(false);
        if (localObject1 != null)
        {
          if (((c.b)localObject1).hcG != null) {
            ((c.b)localObject1).hcI = "1".equals(((c.b)localObject1).hcG.optString("IsHideInputToolbarInMsg"));
          }
          if (((c.b)localObject1).hcI)
          {
            Log.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + paramau.field_username + " is hide tool bar");
            jsk();
            AppMethodBeat.o(35322);
            return false;
          }
        }
        if ((!Util.isNullOrNil(paramau.field_username)) && (localObject1 != null))
        {
          i = this.hlc.aezO.getIntExtra("key_temp_session_show_type", 0);
          switch (((c.b)localObject1).aBh())
          {
          default: 
            jsj();
            paramau = paramau.field_username;
            if (localObject1 == null) {
              break;
            }
          }
        }
      }
    }
    for (bool1 = true;; bool1 = false)
    {
      Log.e("MicroMsg.ChattingUI.FootComponent", "bizinfo name=%s, %b, %d", new Object[] { paramau, Boolean.valueOf(bool1), Integer.valueOf(((c.b)localObject1).aBh()) });
      for (;;)
      {
        AppMethodBeat.o(35322);
        return true;
        Log.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + paramau.field_username + " is show custom menu");
        if (this.aesf == null)
        {
          n.c(this.hlc.aezO, R.h.fOY);
          this.aesf = ((ChatFooterCustom)this.hlc.findViewById(R.h.fPa));
          if (this.aesf != null) {
            this.aesf.ae((ViewGroup)this.hlc.findViewById(R.h.fxv));
          }
        }
        localObject1 = ((c.b)localObject1).aBo();
        try
        {
          Iterator localIterator = ((c.b.c)localObject1).hdq.iterator();
          while (localIterator.hasNext())
          {
            Object localObject2 = (com.tencent.mm.an.k)localIterator.next();
            if (!Util.isNullOrNil(((com.tencent.mm.an.k)localObject2).ihx)) {
              ((com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class)).a(((com.tencent.mm.an.k)localObject2).ihx, -1, "", Util.nullAs(((com.tencent.mm.an.k)localObject2).name, ""), "", "", 4);
            }
            if (!Util.isNullOrNil(((com.tencent.mm.an.k)localObject2).value)) {
              ((com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class)).a(((com.tencent.mm.an.k)localObject2).value, -1, "", Util.nullAs(((com.tencent.mm.an.k)localObject2).name, ""), "", "", 4);
            }
            localObject2 = ((com.tencent.mm.an.k)localObject2).owo.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              com.tencent.mm.an.k localk = (com.tencent.mm.an.k)((Iterator)localObject2).next();
              if (!Util.isNullOrNil(localk.ihx)) {
                ((com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class)).a(localk.ihx, -1, "", Util.nullAs(localk.name, ""), "", "", 4);
              }
              if (!Util.isNullOrNil(localk.value)) {
                ((com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class)).a(localk.value, -1, "", Util.nullAs(localk.name, ""), "", "", 4);
              }
            }
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.ChattingUI.FootComponent", localException, "preauth when chat foot", new Object[0]);
          if ((localObject1 != null) && (((c.b.c)localObject1).type == 1))
          {
            this.KNy.setSwitchButtonMode(1);
            this.KNy.setOnFooterSwitchListener(((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jqZ());
            jsj();
          }
          else
          {
            this.KNy.setSwitchButtonMode(0);
            try
            {
              if (!com.tencent.mm.storage.au.bxe(paramau.field_username)) {
                break label1192;
              }
              this.aesi = new com.tencent.mm.ui.chatting.z(this.aesf);
              this.aesi.jmr();
              jsi();
            }
            catch (Exception paramau)
            {
              if (localObject1 == null) {
                break label1172;
              }
            }
            if ((((c.b.c)localObject1).hdq == null) || (((c.b.c)localObject1).hdq.size() == 0)) {
              label1172:
              jsj();
            }
          }
        }
      }
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ChattingUI.FootComponent", paramau, "", new Object[0]);
        break;
        label1192:
        ChatFooterCustom localChatFooterCustom = this.aesf;
        if ((localChatFooterCustom.aefC != null) && (localChatFooterCustom.aefB != null))
        {
          localChatFooterCustom.aefC.setVisibility(0);
          localChatFooterCustom.aefB.setVisibility(0);
        }
        if (localChatFooterCustom.aefD != null) {
          localChatFooterCustom.aefD.diW();
        }
        this.aesf.setTalker(this.hlc.Uxa);
        this.aesf.a(this.hlc.aezO, locale.jqS(), paramau.field_username);
        this.aesf.setOnFooterSwitchListener(this.YfB);
        this.aesf.setOnProcessClickListener(((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jqY());
        this.KNy.setOnFooterSwitchListener(this.YfB);
        if ((((ah)this.hlc.cm(ah.class)).jti()) && (i == 1))
        {
          jsj();
          break;
        }
        jsi();
        break;
        this.YfB.Ke(true);
      }
    }
  }
  
  public final boolean bC(cc paramcc)
  {
    AppMethodBeat.i(35323);
    if (this.KNy != null) {
      this.KNy.bC(paramcc);
    }
    AppMethodBeat.o(35323);
    return true;
  }
  
  public final void jjf()
  {
    AppMethodBeat.i(255922);
    this.aesq = this.hlc.aezO.getBooleanExtra("show_footer", false).booleanValue();
    AppMethodBeat.o(255922);
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(35333);
    this.aesr = false;
    this.aess = false;
    this.aest = 0L;
    bh.bCz();
    Object localObject1 = com.tencent.mm.model.c.bzG().bxM(this.hlc.getTalkerUserName());
    if (localObject1 != null) {
      this.aesg = ((com.tencent.mm.autogen.b.bd)localObject1).field_chatmode;
    }
    Log.d("MicroMsg.ChattingUI.FootComponent", "dkcm init old:%d   ", new Object[] { Integer.valueOf(this.aesg) });
    localObject1 = this.hlc.getTalkerUserName();
    if (this.KNy == null)
    {
      this.KNy = ((ChatFooter)this.hlc.findViewById(R.h.fOZ));
      this.KNy.a(new ChatFooter.b()
      {
        public final String getTalkerUserName()
        {
          AppMethodBeat.i(35307);
          String str = ab.this.hlc.getTalkerUserName();
          AppMethodBeat.o(35307);
          return str;
        }
        
        public final com.tencent.mm.ui.chatting.g.b iNg()
        {
          return ab.this.hlc.aezM;
        }
        
        public final com.tencent.mm.ui.chatting.d.a iNh()
        {
          return ab.this.hlc;
        }
      });
      ((com.tencent.mm.ui.chatting.component.api.w)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.w.class)).bL(this.KNy);
      jso();
      jsp();
    }
    this.KNy.setCattingRootLayoutId(R.h.chatting_bg_ll);
    Log.i("MicroMsg.ChattingUI.FootComponent", "resetFooter customFooter is %s", new Object[] { this.aesf });
    Object localObject2;
    if (this.aesf != null)
    {
      this.aesf.joX();
      localObject2 = this.aesf;
      if (((ChatFooterCustom)localObject2).xYI == null) {
        ((ChatFooterCustom)localObject2).xYI = ((LinearLayout)((ChatFooterCustom)localObject2).findViewById(R.h.fyb));
      }
      if ((((ChatFooterCustom)localObject2).xYI != null) && (((ChatFooterCustom)localObject2).xYI.getChildCount() > 0))
      {
        localObject2 = ((ChatFooterCustom)localObject2).xYI.getChildAt(0);
        if (localObject2 != null)
        {
          ((View)localObject2).setBackgroundDrawable(((View)localObject2).getContext().getResources().getDrawable(R.g.comm_list_item_selector));
          Object localObject3 = ((View)localObject2).findViewById(R.h.fyd);
          if ((localObject3 instanceof TextView))
          {
            localObject3 = (TextView)localObject3;
            ((TextView)localObject3).setTextColor(((View)localObject2).getContext().getResources().getColor(R.e.FG_0));
            ((TextView)localObject3).setTextSize(0, ((View)localObject2).getContext().getResources().getDimension(R.f.NormalTextSize));
          }
        }
      }
      this.aesf.setOnFooterSwitchListener(null);
      this.aesf.setOnProcessClickListener(null);
      this.KNy.setOnFooterSwitchListener(null);
      this.aesf.jpa();
    }
    jsk();
    this.KNy.iMj();
    boolean bool1 = ((com.tencent.mm.ui.chatting.component.api.au)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class)).jtz();
    boolean bool2 = ((com.tencent.mm.ui.chatting.component.api.au)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class)).jty();
    boolean bool3 = ((ap)this.hlc.cm(ap.class)).jtm();
    int i;
    if ((!this.aesq) && ((bool1) || (bool2) || (bool3)))
    {
      jsk();
      jsf();
      this.aese = new s(this.hlc, this.KNy, this.hlc.getTalkerUserName());
      this.aese.aehN = this.hlc.aezO.getBooleanExtra("key_need_send_video", true).booleanValue();
      this.KNy.setFooterEventListener(this.aese);
      localObject1 = new y(this.hlc, this.hlc.Uxa, this.hlc.getTalkerUserName());
      this.KNy.setSmileyPanelCallback((com.tencent.mm.pluginsdk.ui.chat.f)localObject1);
      this.KNy.setSmileyPanelCallback2((j)localObject1);
      jsn();
      this.KNy.iMa();
      i = this.hlc.aezO.getIntExtra("key_temp_session_show_type", 0);
      localObject1 = (ah)this.hlc.cm(ah.class);
      Log.i("MicroMsg.ChattingUI.FootComponent", "isTempSession : %s, showType : %d.", new Object[] { Boolean.valueOf(((ah)localObject1).jti()), Integer.valueOf(i) });
      Log.d("MicroMsg.ChattingUI.FootComponent", "is temp session : %s.", new Object[] { Boolean.valueOf(((ah)localObject1).jti()) });
      if (((ah)localObject1).jti())
      {
        if (i != 1) {
          break label1937;
        }
        this.YfB.Ke(true);
      }
    }
    for (;;)
    {
      aG(this.hlc.Uxa);
      com.tencent.mm.kernel.h.baF();
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().add(this);
      ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getWordingInfoStg().add(this);
      AppMethodBeat.o(35333);
      return;
      if (com.tencent.mm.storage.au.bvS((String)localObject1))
      {
        jsk();
        n.c(this.hlc.aezO, R.h.fOY);
        if (this.aesf == null)
        {
          i = 1;
          this.aesf = ((ChatFooterCustom)this.hlc.findViewById(R.h.fPa));
          if (i != 0) {
            this.aesf.ae((ViewGroup)this.hlc.findViewById(R.h.fxv));
          }
          this.aesh = new com.tencent.mm.ui.chatting.w(this.aesf);
          localObject1 = this.aesh;
          if (ChannelUtil.channelId != 1) {
            break label1055;
          }
          i = 1;
          label872:
          ((com.tencent.mm.ui.chatting.w)localObject1).aeiT.findViewById(R.h.fyg).setVisibility(8);
          ((com.tencent.mm.ui.chatting.w)localObject1).xYI = ((LinearLayout)((com.tencent.mm.ui.chatting.w)localObject1).aeiT.findViewById(R.h.fyb));
          ((com.tencent.mm.ui.chatting.w)localObject1).aeiT.findViewById(R.h.fya).setVisibility(8);
          localObject2 = ((com.tencent.mm.ui.chatting.w)localObject1).xYI;
          if (i == 0) {
            break label1060;
          }
        }
        label1055:
        label1060:
        for (float f = 1.0F;; f = 2.0F)
        {
          ((LinearLayout)localObject2).setWeightSum(f);
          ((com.tencent.mm.ui.chatting.w)localObject1).aeiU = ((FrameLayout)((com.tencent.mm.ui.chatting.w)localObject1).xYI.getChildAt(0));
          ((com.tencent.mm.ui.chatting.w)localObject1).aeiU.setVisibility(0);
          ((com.tencent.mm.ui.chatting.w)localObject1).aeiU.setOnClickListener(((com.tencent.mm.ui.chatting.w)localObject1).aejc);
          ((TextView)((com.tencent.mm.ui.chatting.w)localObject1).aeiU.findViewById(R.h.fyd)).setText(R.l.gwy);
          ((com.tencent.mm.ui.chatting.w)localObject1).aeiU.findViewById(R.h.fyc).setVisibility(8);
          if (i == 0) {
            break label1065;
          }
          i = 1;
          while (i < 6)
          {
            ((com.tencent.mm.ui.chatting.w)localObject1).xYI.getChildAt(i).setVisibility(8);
            i += 1;
          }
          i = 0;
          break;
          i = 0;
          break label872;
        }
        label1065:
        ((com.tencent.mm.ui.chatting.w)localObject1).aeiV = ((FrameLayout)((com.tencent.mm.ui.chatting.w)localObject1).xYI.getChildAt(1));
        ((com.tencent.mm.ui.chatting.w)localObject1).aeiV.setVisibility(0);
        ((com.tencent.mm.ui.chatting.w)localObject1).aeiV.setOnClickListener(((com.tencent.mm.ui.chatting.w)localObject1).aejd);
        ((com.tencent.mm.ui.chatting.w)localObject1).aeiW = ((TextView)((com.tencent.mm.ui.chatting.w)localObject1).aeiV.findViewById(R.h.fyd));
        ((com.tencent.mm.ui.chatting.w)localObject1).aeiX = ((ImageView)((com.tencent.mm.ui.chatting.w)localObject1).aeiV.findViewById(R.h.fyc));
        ((com.tencent.mm.ui.chatting.w)localObject1).aeiX.setVisibility(0);
        ((com.tencent.mm.ui.chatting.w)localObject1).jpD();
        bh.bCz();
        ((com.tencent.mm.ui.chatting.w)localObject1).IWA = ((Integer)com.tencent.mm.model.c.ban().get(at.a.acJa, Integer.valueOf(-1))).intValue();
        if (((com.tencent.mm.ui.chatting.w)localObject1).IWA >= 0) {
          ((com.tencent.mm.ui.chatting.w)localObject1).jpF();
        }
        for (;;)
        {
          i = 2;
          while (i < 6)
          {
            ((com.tencent.mm.ui.chatting.w)localObject1).xYI.getChildAt(i).setVisibility(8);
            i += 1;
          }
          ((com.tencent.mm.ui.chatting.w)localObject1).aeiW.setText(R.l.chatfooter_mail_without_unread_count);
        }
        ((com.tencent.mm.ui.chatting.w)localObject1).aejb = com.tencent.mm.k.i.aRD().getMailAppEnterUlAndroid();
        if (Util.isNullOrNil(((com.tencent.mm.ui.chatting.w)localObject1).aejb)) {
          ((com.tencent.mm.ui.chatting.w)localObject1).aejb = "qqmail://folderlist?app=weixin&action=list&uin=$uin$";
        }
        bh.bCz();
        localObject2 = new com.tencent.mm.b.p(Util.nullAsNil((Integer)com.tencent.mm.model.c.ban().d(9, null))).toString();
        ((com.tencent.mm.ui.chatting.w)localObject1).aejb = ((com.tencent.mm.ui.chatting.w)localObject1).aejb.replace("$uin$", (CharSequence)localObject2);
        ((com.tencent.mm.ui.chatting.w)localObject1).Npt = com.tencent.mm.k.i.aRD().aRv();
        ((com.tencent.mm.ui.chatting.w)localObject1).aeiZ = true;
        jsi();
        break;
      }
      this.aesh = null;
      if (com.tencent.mm.storage.au.bxe((String)localObject1))
      {
        jsk();
        n.c(this.hlc.aezO, R.h.fOY);
        if (this.aesf == null) {}
        for (i = 1;; i = 0)
        {
          this.aesf = ((ChatFooterCustom)this.hlc.findViewById(R.h.fPa));
          if (i != 0) {
            this.aesf.ae((ViewGroup)this.hlc.findViewById(R.h.fxv));
          }
          this.aesi = new com.tencent.mm.ui.chatting.z(this.aesf);
          this.aesi.jmr();
          jsi();
          break;
        }
      }
      this.aesi = null;
      if ((com.tencent.mm.storage.au.bwE((String)localObject1)) && (((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).alQ((String)localObject1)))
      {
        jsk();
        n.c(this.hlc.aezO, R.h.fOY);
        if (this.aesf == null) {}
        for (i = 1;; i = 0)
        {
          this.aesf = ((ChatFooterCustom)this.hlc.findViewById(R.h.fPa));
          if (i != 0) {
            this.aesf.ae((ViewGroup)this.hlc.findViewById(R.h.fxv));
          }
          this.aesk = new com.tencent.mm.ui.chatting.i(this.aesf);
          this.aesk.jmr();
          jsi();
          break;
        }
      }
      this.aesk = null;
      if (com.tencent.mm.model.ab.IP((String)localObject1))
      {
        jsk();
        n.c(this.hlc.aezO, R.h.fOY);
        if (this.aesf == null) {}
        for (i = 1;; i = 0)
        {
          this.aesf = ((ChatFooterCustom)this.hlc.findViewById(R.h.fPa));
          if (i != 0) {
            this.aesf.ae((ViewGroup)this.hlc.findViewById(R.h.fxv));
          }
          this.aesj = new com.tencent.mm.ui.chatting.k(this.aesf);
          this.aesj.jmr();
          jsi();
          break;
        }
      }
      this.aesj = null;
      if ((com.tencent.mm.storage.au.bvT((String)localObject1)) || (com.tencent.mm.storage.au.bxe((String)localObject1)) || (com.tencent.mm.storage.au.bvS((String)localObject1)) || (com.tencent.mm.model.ab.IP((String)localObject1)) || (com.tencent.mm.storage.au.iZB()) || (com.tencent.mm.storage.au.bwu((String)localObject1)) || (com.tencent.mm.model.ab.IN((String)localObject1)) || (com.tencent.mm.storage.au.bwA((String)localObject1)) || ((com.tencent.mm.storage.au.bwE((String)localObject1)) && (((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).alQ((String)localObject1))))
      {
        jsk();
        break;
      }
      jsj();
      aG(this.hlc.Uxa);
      this.KNy.setUserName((String)localObject1);
      this.KNy.pn(this.hlc.getSelfUserName(), this.hlc.getTalkerUserName());
      bAO((String)localObject1);
      localObject1 = (com.tencent.mm.ui.chatting.component.api.n)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.n.class);
      localObject2 = (com.tencent.mm.ui.chatting.component.api.au)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class);
      if (!((com.tencent.mm.ui.chatting.component.api.n)localObject1).jrJ()) {
        break;
      }
      if (((com.tencent.mm.ui.chatting.component.api.au)localObject2).jtw())
      {
        ((com.tencent.mm.ui.chatting.component.api.au)localObject2).jtv();
        ((com.tencent.mm.ui.chatting.component.api.n)localObject1).jrK();
        break;
      }
      ((com.tencent.mm.ui.chatting.component.api.n)localObject1).jrH();
      break;
      label1937:
      this.YfB.Ke(false);
    }
  }
  
  public final void jjh() {}
  
  public final void jji()
  {
    AppMethodBeat.i(35334);
    this.aesm = this.hlc.aezO.getStringExtra("smiley_product_id");
    if (this.KNy.HDO) {
      ((aw)this.hlc.cm(aw.class)).keepSignalling();
    }
    if ((com.tencent.mm.storage.au.bvS(this.hlc.getTalkerUserName())) && (this.aesh != null) && (this.aesh.aeiZ)) {
      this.aesh.jpE();
    }
    ChatFooter localChatFooter = this.KNy;
    BaseChattingUIFragment localBaseChattingUIFragment = this.hlc.aezO;
    localChatFooter.Fgt = localBaseChattingUIFragment;
    localChatFooter.a(localBaseChattingUIFragment.getContext(), localBaseChattingUIFragment.thisActivity());
    if ((localChatFooter.YgZ != null) && (localChatFooter.YgZ.isShowing())) {
      localChatFooter.YgZ.dismiss();
    }
    localChatFooter.Rqt.refresh(((PluginWebSearch)com.tencent.mm.kernel.h.az(PluginWebSearch.class)).isUseSysEditText());
    if ((!Util.isNullOrNil(this.aesm)) && (this.KNy != null))
    {
      Log.d("MicroMsg.ChattingUI.FootComponent", "deal use smiley panel in product: %s", new Object[] { this.aesm });
      this.KNy.setDefaultSmileyByDetail(this.aesm);
      this.KNy.iMe();
    }
    this.hlc.aezO.getContext().getIntent().putExtra("smiley_product_id", "");
    this.KNy.setUserName(this.hlc.getTalkerUserName());
    com.tencent.mm.live.c.e.nkO = this.hlc.getTalkerUserName();
    this.KNy.pn(this.hlc.getSelfUserName(), this.hlc.getTalkerUserName());
    if (this.hlc.aezO.getBooleanExtra("key_show_bottom_app_panel", false).booleanValue())
    {
      localChatFooter = this.KNy;
      if (localChatFooter.Yfi != null)
      {
        localChatFooter.Yfi.performClick();
        Log.d("MicroMsg.ChatFooter", "perform click attach bt to show bottom panel");
      }
    }
    if (aG(this.hlc.Uxa))
    {
      if (this.KNy != null)
      {
        bh.bCz();
        bool1 = ((Boolean)com.tencent.mm.model.c.ban().d(66832, Boolean.FALSE)).booleanValue();
        Log.d("MicroMsg.ChattingUI.FootComponent", "jacks refresh Footer Plugin Setting , Enable Enter Button: %B", new Object[] { Boolean.valueOf(bool1) });
        this.KNy.iMI();
        if (bool1)
        {
          this.KNy.iMv();
          this.KNy.iMa();
        }
        if (bool1) {
          this.KNy.iMk();
        }
        localChatFooter = this.KNy;
        if (localChatFooter.Yfb != null) {
          localChatFooter.Yfb.iLA();
        }
      }
      ((com.tencent.mm.ui.chatting.component.api.az)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.az.class)).jrU();
      if (this.KNy != null)
      {
        this.KNy.Yfb.bDL();
        this.KNy.addTextChangedListener(new a((byte)0));
        Log.i("MicroMsg.ChattingUI.FootComponent", "addTextChangedListener");
      }
    }
    boolean bool1 = ((com.tencent.mm.ui.chatting.component.api.au)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class)).jtz();
    boolean bool2 = ((com.tencent.mm.ui.chatting.component.api.au)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class)).jty();
    boolean bool3 = ((com.tencent.mm.ui.chatting.component.api.n)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.n.class)).jrJ();
    boolean bool4 = com.tencent.mm.model.ab.IN(this.hlc.getTalkerUserName());
    boolean bool5 = ((ap)this.hlc.cm(ap.class)).jtm();
    if (((!bool1) && (!bool2) && (!bool3)) || ((this.aesq) && (this.hlc.Uxa != null) && (!this.hlc.Uxa.iZC()) && (!com.tencent.mm.storage.au.bww(this.hlc.getTalkerUserName())) && (!com.tencent.mm.ui.widget.snackbar.b.cvt()) && (!com.tencent.mm.model.ab.IP(this.hlc.getTalkerUserName())) && ((!com.tencent.mm.storage.au.bwE(this.hlc.getTalkerUserName())) || (!((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).alQ(this.hlc.getTalkerUserName()))) && (!bool4) && (!bool5)))
    {
      Log.i("MicroMsg.ChattingUI.FootComponent", "call visibleFooter again.");
      jsj();
    }
    for (;;)
    {
      this.lzi.alive();
      this.lzh.alive();
      AppMethodBeat.o(35334);
      return;
      Log.i("MicroMsg.ChattingUI.FootComponent", "no call visibleFooter again.");
    }
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(35335);
    Object localObject;
    if (this.KNy != null)
    {
      localObject = this.KNy;
      if (((ChatFooter)localObject).YhY != null)
      {
        ((ChatFooter)localObject).Rqt.removeTextChangedListener(((ChatFooter)localObject).YhY);
        ((ChatFooter)localObject).YhY = null;
      }
      Log.i("MicroMsg.ChattingUI.FootComponent", "removeTextChangeListener");
      this.KNy.onPause();
      this.lzi.dead();
      this.lzh.dead();
      if (!com.tencent.mm.kernel.h.baz())
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
    bh.bCz();
    com.tencent.mm.model.c.ban().B(18, Integer.valueOf(this.KNy.getMode()));
    Log.d("MicroMsg.ChattingUI.FootComponent", "dkcm old:%d footer:%d ", new Object[] { Integer.valueOf(this.aesg), Integer.valueOf(this.KNy.getMode()) });
    if (this.aesg != this.KNy.getMode())
    {
      this.aesg = this.KNy.getMode();
      bh.bCz();
      localObject = com.tencent.mm.model.c.bzG().bxM(this.hlc.getTalkerUserName());
      if ((localObject != null) && (this.hlc.getTalkerUserName().equals(((com.tencent.mm.autogen.b.bd)localObject).field_username)))
      {
        ((bb)localObject).pH(this.aesg);
        bh.bCz();
        com.tencent.mm.model.c.bzG().c((bb)localObject, this.hlc.getTalkerUserName());
      }
    }
    this.KNy.a(ChatFooter.h.YjA);
    AppMethodBeat.o(35335);
  }
  
  public final void jjk() {}
  
  public final void jqF()
  {
    AppMethodBeat.i(35332);
    super.jqF();
    if (this.KNy != null)
    {
      this.KNy.setFooterEventListener(null);
      s locals = this.aese;
      Object localObject = AppForegroundDelegate.heY;
      localObject = AppForegroundDelegate.aCa();
      Log.i("MicroMsg.ChattingFooterEventImpl", "getCurrentActivity: %s", new Object[] { localObject });
      if ((localObject == null) || (!((String)localObject).contains("MMRecordUI")))
      {
        Log.i("MicroMsg.ChattingFooterEventImpl", "clear video generate callback");
        CaptureDataManager.NHH.NHG = null;
      }
      if (locals.aehH != null)
      {
        locals.aehH.a(null);
        locals.aehH.a(null);
      }
      this.aese = null;
      this.KNy.setSmileyPanelCallback(null);
      this.KNy.setSmileyPanelCallback2(null);
    }
    if (this.aesf != null)
    {
      this.aesf.joX();
      this.aesf = null;
    }
    jsf();
    if (this.aesf != null) {
      this.aesf.jpa();
    }
    com.tencent.mm.pluginsdk.ui.span.p.clearCache();
    if (this.KNy != null) {
      this.KNy.iME();
    }
    if ((this.hlc.aezO.isCurrentActivity) && (this.KNy != null)) {
      this.KNy.destroy();
    }
    com.tencent.mm.kernel.h.baF();
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().remove(this);
    ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getWordingInfoStg().remove(this);
    AppMethodBeat.o(35332);
  }
  
  public final ChatFooter jsd()
  {
    return this.KNy;
  }
  
  public final ChatFooterCustom jse()
  {
    return this.aesf;
  }
  
  public final String jsg()
  {
    return this.aesm;
  }
  
  public final void jsh()
  {
    AppMethodBeat.i(35316);
    try
    {
      if (this.KNy.iMz()) {
        this.KNy.setBottomPanelVisibility(8);
      }
      AppMethodBeat.o(35316);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(35316);
    }
  }
  
  public final void jsi()
  {
    AppMethodBeat.i(35317);
    this.hlc.hideVKB();
    Log.i("MicroMsg.ChattingUI.FootComponent", "visibleCustomFooter customFooter is %s", new Object[] { this.aesf });
    if (this.aesf == null)
    {
      AppMethodBeat.o(35317);
      return;
    }
    this.aesf.setVisibility(0);
    if (this.KNy != null)
    {
      this.KNy.Kb(false);
      this.KNy.setVisibility(8);
    }
    AppMethodBeat.o(35317);
  }
  
  public final void jsj()
  {
    AppMethodBeat.i(35318);
    if (this.KNy == null)
    {
      AppMethodBeat.o(35318);
      return;
    }
    this.KNy.setVisibility(0);
    if (this.aesf != null) {
      this.aesf.setVisibility(8);
    }
    AppMethodBeat.o(35318);
  }
  
  public final void jsl()
  {
    AppMethodBeat.i(35320);
    this.aesl = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.aesl.setInterpolator(new DecelerateInterpolator(1.5F));
    this.aesl.addAnimation(localTranslateAnimation);
    this.aesl.addAnimation(localAlphaAnimation);
    this.aesl.setDuration(300L);
    this.aesl.setFillBefore(true);
    if (this.KNy != null) {
      this.KNy.startAnimation(this.aesl);
    }
    AppMethodBeat.o(35320);
  }
  
  public final void jsm()
  {
    AppMethodBeat.i(35321);
    Log.i("MicroMsg.ChattingUI.FootComponent", "triggerFooter, originChatFooterVisibility:%s", new Object[] { Integer.valueOf(this.aesn) });
    if (this.KNy == null)
    {
      this.KNy = ((ChatFooter)this.hlc.findViewById(R.h.fOZ));
      this.KNy.a(new ChatFooter.b()
      {
        public final String getTalkerUserName()
        {
          AppMethodBeat.i(35306);
          String str = ab.this.hlc.getTalkerUserName();
          AppMethodBeat.o(35306);
          return str;
        }
        
        public final com.tencent.mm.ui.chatting.g.b iNg()
        {
          return ab.this.hlc.aezM;
        }
        
        public final com.tencent.mm.ui.chatting.d.a iNh()
        {
          return ab.this.hlc;
        }
      });
      ((com.tencent.mm.ui.chatting.component.api.w)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.w.class)).bL(this.KNy);
      jso();
      jsp();
    }
    boolean bool1 = ((com.tencent.mm.ui.chatting.component.api.n)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.n.class)).jrJ();
    boolean bool2 = ((ap)this.hlc.cm(ap.class)).jtm();
    if ((bool1) || (bool2) || (com.tencent.mm.ui.widget.snackbar.b.cvt()))
    {
      if (!this.aesp) {
        this.aesn = this.KNy.getVisibility();
      }
      this.KNy.Kb(true);
      if (this.aesf != null) {
        if (this.aesp) {}
      }
      for (this.aeso = this.aesf.getVisibility();; this.aeso = -1)
      {
        jsk();
        this.aesp = true;
        AppMethodBeat.o(35321);
        return;
      }
    }
    this.aesp = false;
    if ((this.aesn == 8) && (this.aeso == 8))
    {
      jsk();
      AppMethodBeat.o(35321);
      return;
    }
    if (this.aesn == 0)
    {
      jsj();
      AppMethodBeat.o(35321);
      return;
    }
    jsi();
    AppMethodBeat.o(35321);
  }
  
  public final void jsn()
  {
    AppMethodBeat.i(35324);
    String str = this.hlc.getTalkerUserName();
    int i;
    if ((com.tencent.mm.storage.au.bvV(str)) || (com.tencent.mm.storage.au.bwL(str))) {
      i = 1;
    }
    while (i == 2)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.hlc.aezO.getContext(), "android.permission.RECORD_AUDIO", 80, "");
      Log.i("MicroMsg.ChattingUI.FootComponent", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.hlc.aezO.getContext() });
      if (bool) {
        break;
      }
      this.KNy.cu(1, false);
      AppMethodBeat.o(35324);
      return;
      if (com.tencent.mm.storage.au.bwm(str))
      {
        i = 2;
      }
      else
      {
        int j = this.hlc.aezO.getIntExtra("Chat_Mode", 0);
        Log.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", new Object[] { Integer.valueOf(this.aesg), Integer.valueOf(j) });
        if (this.aesg != 0) {
          j = this.aesg;
        }
        str = com.tencent.mm.k.i.aRC().getValue("DefaultMsgType");
        i = j;
        if (this.aesg == 0)
        {
          i = j;
          if (str != null)
          {
            Log.d("MicroMsg.ChattingUI.FootComponent", "config def chatmode is %s", new Object[] { str });
            i = Util.getInt(com.tencent.mm.k.i.aRC().getValue("DefaultMsgType"), 0);
          }
        }
        j = i;
        if (i == 0)
        {
          j = i;
          if (com.tencent.mm.contact.d.rs(this.hlc.Uxa.field_type))
          {
            bh.bCz();
            j = ((Integer)com.tencent.mm.model.c.ban().d(18, Integer.valueOf(0))).intValue();
          }
        }
        i = j;
        if (j == 0) {
          i = 1;
        }
        Log.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", new Object[] { Integer.valueOf(this.aesg), Integer.valueOf(i) });
      }
    }
    this.KNy.cu(i, false);
    AppMethodBeat.o(35324);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35329);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((1111 == paramInt1) && (-1 == paramInt2)) {
      this.KNy.iMe();
    }
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 200) || (paramInt1 == 201) || (paramInt1 == 203)) {
        this.KNy.clearFocus();
      }
      AppMethodBeat.o(35329);
      return;
    }
    if ((paramInt1 != 217) && (this.aesf != null) && (!this.aesf.Q(paramInt1, paramIntent)))
    {
      Log.w("MicroMsg.ChattingUI.FootComponent", "customFooter is null and isContinue is false");
      AppMethodBeat.o(35329);
      return;
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
      if (this.KNy != null) {
        this.KNy.setMode(paramInt1);
      }
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int j = 0;
    AppMethodBeat.i(35331);
    Log.i("MicroMsg.ChattingUI.FootComponent", "chatting onKeyDown, code:%d action:%d", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    if (paramKeyEvent.getKeyCode() == 4) {
      if (!this.hlc.ffv) {
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
        if ((this.hlc.aezO.isSupportNavigationSwipeBack()) && (this.hlc.aezO.getSwipeBackLayout().iMy()))
        {
          Log.w("MicroMsg.ChattingUI.FootComponent", "ashutest::onKeyDown back ScrollToFinishing");
          i = 1;
        }
        else
        {
          if (paramKeyEvent.getAction() == 0)
          {
            this.aesr = true;
            this.aest = System.currentTimeMillis();
          }
          if (paramKeyEvent.getAction() != 1) {
            break label356;
          }
          Log.d("MicroMsg.ChattingUI.FootComponent", "hasBack %B, %d", new Object[] { Boolean.valueOf(this.aesr), Long.valueOf(System.currentTimeMillis() - this.aest) });
          if ((this.aesr) && (System.currentTimeMillis() - this.aest <= 30000L)) {
            break;
          }
          i = 1;
        }
      }
      this.aess = true;
      Object localObject = (com.tencent.mm.ui.chatting.component.api.n)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.n.class);
      com.tencent.mm.ui.chatting.component.api.au localau = (com.tencent.mm.ui.chatting.component.api.au)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class);
      if (((com.tencent.mm.ui.chatting.component.api.n)localObject).jrJ()) {
        if (localau.jtw())
        {
          localau.jtv();
          ((com.tencent.mm.ui.chatting.component.api.n)localObject).jrK();
          label291:
          i = 1;
          label293:
          if (i == 0) {
            if (this.KNy != null)
            {
              localObject = this.KNy;
              if ((((ChatFooter)localObject).mjd == 0) && (!((ChatFooter)localObject).Yae)) {
                break label385;
              }
              if (!((ChatFooter)localObject).Yae) {
                break label376;
              }
              ((ChatFooter)localObject).iKM();
              label339:
              i = 1;
            }
          }
        }
      }
      for (;;)
      {
        if (i == 0) {
          this.hlc.aezO.joU();
        }
        label356:
        i = 1;
        break;
        ((com.tencent.mm.ui.chatting.component.api.n)localObject).jrH();
        break label291;
        i = 0;
        break label293;
        label376:
        ((ChatFooter)localObject).Kb(true);
        break label339;
        label385:
        i = j;
        if (((ChatFooter)localObject).Yhs != null)
        {
          i = j;
          if (((ChatFooter)localObject).Yhs.getVisibility() == 0)
          {
            ((ChatFooter)localObject).Yhs.hPH();
            i = 1;
          }
        }
      }
      if ((paramKeyEvent.getKeyCode() == 67) && (!this.hlc.ffv)) {
        Log.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown back key fragment not foreground");
      } else if (!this.hlc.ffv) {
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
    Log.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange obj %s talker %s", new Object[] { paramObject, this.hlc.getTalkerUserName() });
    if (paramObject.equals(this.hlc.getTalkerUserName()))
    {
      bAO(this.hlc.getTalkerUserName());
      jsn();
    }
    AppMethodBeat.o(35327);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(35328);
    if (paramString != null) {
      paramString.equals("");
    }
    Log.i("MicroMsg.ChattingUI.FootComponent", "onNotifyChange event %s talker %s", new Object[] { paramString, this.hlc.getTalkerUserName() });
    if ((com.tencent.mm.storage.au.bwF(this.hlc.getTalkerUserName())) || (com.tencent.mm.storage.au.bwQ(this.hlc.getTalkerUserName())))
    {
      bAO(this.hlc.getTalkerUserName());
      jsn();
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
        Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doFooterLiveRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.aese, Util.getStack() });
        if (this.aese != null) {
          this.aese.KOi.gaz();
        }
        AppMethodBeat.o(35330);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = R.l.permission_camera_request_again_msg;; paramInt = R.l.permission_microphone_request_again_msg)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(paramInt), this.hlc.aezO.getMMResources().getString(R.l.permission_tips_title), this.hlc.aezO.getMMResources().getString(R.l.jump_to_settings), this.hlc.aezO.getMMResources().getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35301);
              paramAnonymousDialogInterface.dismiss();
              com.tencent.mm.pluginsdk.permission.b.lx(ab.this.hlc.aezO.getContext());
              AppMethodBeat.o(35301);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35302);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35302);
            }
          });
        }
        AppMethodBeat.o(35330);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doFooterSightRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.aese, Util.getStack() });
        if (this.aese != null)
        {
          paramArrayOfString = this.aese;
          if (!this.KNy.Yfb.YdH.Yew.value) {
            break label446;
          }
        }
        label446:
        for (paramInt = i;; paramInt = 2)
        {
          paramArrayOfString.aBL(paramInt);
          AppMethodBeat.o(35330);
          return;
        }
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = R.l.permission_camera_request_again_msg;; paramInt = R.l.permission_microphone_request_again_msg)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(paramInt), this.hlc.aezO.getMMResources().getString(R.l.permission_tips_title), this.hlc.aezO.getMMResources().getString(R.l.jump_to_settings), this.hlc.aezO.getMMResources().getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35303);
              paramAnonymousDialogInterface.dismiss();
              com.tencent.mm.pluginsdk.permission.b.lx(ab.this.hlc.aezO.getContext());
              AppMethodBeat.o(35303);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(163307);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(163307);
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
          Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuVideoSelected,footerEventImpl[%s], stack[%s]", new Object[] { this.aese, Util.getStack() });
          if (this.aese != null) {
            this.aese.gBU();
          }
          AppMethodBeat.o(35330);
          return;
        }
        if (paramInt == 21)
        {
          Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.aese, Util.getStack() });
          if (this.aese != null) {
            this.aese.jpy();
          }
          AppMethodBeat.o(35330);
          return;
        }
        Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnEnterMultiTalk,footerEventImpl[%s], stack[%s]", new Object[] { this.aese, Util.getStack() });
        if (this.aese != null) {
          this.aese.jpw();
        }
        AppMethodBeat.o(35330);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = R.l.permission_camera_request_again_msg;; paramInt = R.l.permission_microphone_request_again_msg)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(paramInt), this.hlc.aezO.getMMResources().getString(R.l.permission_tips_title), this.hlc.aezO.getMMResources().getString(R.l.jump_to_settings), this.hlc.aezO.getMMResources().getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(163308);
              paramAnonymousDialogInterface.dismiss();
              com.tencent.mm.pluginsdk.permission.b.lx(ab.this.hlc.aezO.getContext());
              AppMethodBeat.o(163308);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(169867);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(169867);
            }
          });
        }
        AppMethodBeat.o(35330);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doImageSelectTakePhotoRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.aese, Util.getStack() });
        if (this.aese != null) {
          this.aese.jpA();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.permission_camera_request_again_msg), this.hlc.aezO.getMMResources().getString(R.l.permission_tips_title), this.hlc.aezO.getMMResources().getString(R.l.jump_to_settings), this.hlc.aezO.getMMResources().getString(R.l.cancel), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(184958);
          com.tencent.mm.pluginsdk.permission.b.lx(ab.this.hlc.aezO.getContext());
          AppMethodBeat.o(184958);
        }
      }, null);
      AppMethodBeat.o(35330);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doTalkRoomRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.aese, Util.getStack() });
        if (this.aese != null) {
          this.aese.jpz();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.permission_location_request_again_msg), this.hlc.aezO.getMMResources().getString(R.l.permission_tips_title), this.hlc.aezO.getMMResources().getString(R.l.jump_to_settings), this.hlc.aezO.getMMResources().getString(R.l.cancel), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(256020);
          com.tencent.mm.pluginsdk.permission.b.lx(ab.this.hlc.aezO.getContext());
          AppMethodBeat.o(256020);
        }
      }, null);
      AppMethodBeat.o(35330);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        if (paramInt == 82)
        {
          Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuAudioSelected,footerEventImpl[%s], stack[%s]", new Object[] { this.aese, Util.getStack() });
          if (this.aese != null) {
            this.aese.gBT();
          }
          AppMethodBeat.o(35330);
          return;
        }
        Log.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipAudioRequest,footerEventImpl[%s], stack[%s]", new Object[] { this.aese, Util.getStack() });
        if (this.aese != null) {
          this.aese.jpx();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.permission_microphone_request_again_msg), this.hlc.aezO.getMMResources().getString(R.l.permission_tips_title), this.hlc.aezO.getMMResources().getString(R.l.jump_to_settings), this.hlc.aezO.getMMResources().getString(R.l.cancel), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(256018);
          com.tencent.mm.pluginsdk.permission.b.lx(ab.this.hlc.aezO.getContext());
          AppMethodBeat.o(256018);
        }
      }, null);
      AppMethodBeat.o(35330);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        Log.i("MicroMsg.ChattingUI.FootComponent", "doSendFileRequest, footerEventImpl[%s], stack[%s].", new Object[] { this.aese, Util.getStack() });
        if (this.aese != null) {
          this.aese.jpu();
        }
        AppMethodBeat.o(35330);
        return;
      }
      com.tencent.mm.ui.base.k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.gRo), this.hlc.aezO.getMMResources().getString(R.l.permission_tips_title), this.hlc.aezO.getMMResources().getString(R.l.jump_to_settings), this.hlc.aezO.getMMResources().getString(R.l.gallery_cancel), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(256317);
          com.tencent.mm.pluginsdk.permission.b.lx(ab.this.hlc.aezO.getContext());
          AppMethodBeat.o(256317);
        }
      }, null);
    }
  }
  
  public final void setVoiceInputShowCallback(ChatFooter.d paramd)
  {
    AppMethodBeat.i(35326);
    this.KNy.setVoiceInputShowCallback(paramd);
    AppMethodBeat.o(35326);
  }
  
  final class a
    implements TextWatcher
  {
    private List<String> aesA = null;
    private boolean aesz = false;
    
    private a() {}
    
    private static void c(List<String> paramList, String[] paramArrayOfString)
    {
      AppMethodBeat.i(255800);
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
      AppMethodBeat.o(255800);
    }
    
    private boolean iR(String paramString, int paramInt)
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
        if (this.aesA == null)
        {
          this.aesA = new LinkedList();
          localObject = ab.this.hlc.aezO.getMMResources().getStringArray(R.c.merge_smiley_code_smiley);
          c(this.aesA, (String[])localObject);
          localObject = ab.this.hlc.aezO.getMMResources().getStringArray(R.c.merge_smiley_softbank_emoji);
          c(this.aesA, (String[])localObject);
        }
        paramString = paramString.substring(0, paramInt);
        Object localObject = this.aesA.iterator();
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
      ((aw)ab.this.hlc.cm(aw.class)).aCk(1);
      Object localObject1 = (com.tencent.mm.ui.chatting.component.api.e)ab.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class);
      paramCharSequence = String.valueOf(paramCharSequence);
      String str = paramCharSequence.substring(paramInt1, paramInt1 + paramInt3);
      Object localObject2;
      if ((ab.this.hlc.juF()) && ("@".equals(str)) && (!paramCharSequence.equals(ab.this.KNy.getLastContent())) && (!ab.this.KNy.YfE))
      {
        ab.this.KNy.setLastContent(paramCharSequence);
        ab.this.KNy.setInsertPos(paramInt1 + 1);
        if (iR(paramCharSequence, paramInt1))
        {
          localObject2 = new com.tencent.mm.ui.chatting.atsomeone.d(ab.this.hlc.aezO.getContext(), ab.this.hlc.getTalkerUserName(), new com.tencent.mm.ui.chatting.atsomeone.b()
          {
            public final void hM(String paramAnonymousString1, String paramAnonymousString2)
            {
              AppMethodBeat.i(256316);
              ((com.tencent.mm.ui.chatting.component.api.az)ab.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.az.class)).bL(ab.this.hlc.getTalkerUserName(), paramAnonymousString2, paramAnonymousString1);
              AppMethodBeat.o(256316);
            }
          });
          ((com.tencent.mm.ui.chatting.atsomeone.d)localObject2).show();
          ((com.tencent.mm.ui.chatting.atsomeone.d)localObject2).setOnDismissListener(new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(256292);
              paramAnonymousDialogInterface = ab.this.KNy;
              paramAnonymousDialogInterface.Rqt.jEJ();
              if (!paramAnonymousDialogInterface.HDO) {
                paramAnonymousDialogInterface.showVKB();
              }
              AppMethodBeat.o(256292);
            }
          });
        }
      }
      for (;;)
      {
        ((av)ab.this.hlc.cm(av.class)).X(paramCharSequence, paramInt1, str);
        if ((!((com.tencent.mm.ui.chatting.component.api.e)localObject1).jqV()) && (!com.tencent.mm.storage.au.bwZ(ab.this.hlc.getTalkerUserName())) && (!com.tencent.mm.storage.au.bwQ(ab.this.hlc.getTalkerUserName())))
        {
          localObject1 = ab.this.KNy;
          if ((((ChatFooter)localObject1).Yfy != null) && (((ChatFooter)localObject1).mkz != null))
          {
            ((ChatFooter)localObject1).Yfy.Yky = true;
            ((ChatFooter)localObject1).Yfy.pp(paramCharSequence, ((ChatFooter)localObject1).Ygv.getTalkerUserName());
          }
        }
        if ((com.tencent.mm.storage.au.bwE(ab.this.hlc.getTalkerUserName())) && (!ab.this.KNy.iMG())) {
          ab.this.KNy.brh(paramCharSequence);
        }
        AppMethodBeat.o(35313);
        return;
        if ((((com.tencent.mm.ui.chatting.component.api.e)localObject1).jqW()) && ("@".equals(str)) && (!paramCharSequence.equals(ab.this.KNy.getLastContent())) && (!ab.this.KNy.YfE))
        {
          ab.this.KNy.setLastContent(paramCharSequence);
          ab.this.KNy.setInsertPos(paramInt1 + 1);
          if (iR(paramCharSequence, paramInt1))
          {
            localObject2 = ((com.tencent.mm.ui.chatting.component.api.e)localObject1).jqT().field_userList;
            Intent localIntent = new Intent();
            localIntent.setClass(ab.this.hlc.aezO.getContext(), BizChatAtSomeoneUI.class);
            localIntent.putExtra("Block_list", af.bHj().hN(ab.this.hlc.getTalkerUserName()));
            localIntent.putExtra("Chatroom_member_list", (String)localObject2);
            localIntent.putExtra("Chat_User", ab.this.hlc.getTalkerUserName());
            localIntent.putExtra("Add_address_titile", ab.this.hlc.aezO.getMMString(R.l.gTo));
            localIntent.putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.component.api.e)ab.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jrk());
            ab.this.hlc.aezO.startActivityForResult(localIntent, 212);
          }
        }
        else if (!paramCharSequence.equals(ab.this.KNy.getLastContent()))
        {
          ab.this.KNy.setLastContent(paramCharSequence);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.ab
 * JD-Core Version:    0.7.0.1
 */