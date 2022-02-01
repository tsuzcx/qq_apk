package com.tencent.mm.view.d;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.b.ab;
import com.tencent.mm.emoji.a.b.ad;
import com.tencent.mm.emoji.a.b.af;
import com.tencent.mm.emoji.a.b.ag;
import com.tencent.mm.emoji.a.b.ak;
import com.tencent.mm.emoji.a.b.al;
import com.tencent.mm.emoji.a.b.v;
import com.tencent.mm.emoji.a.b.w;
import com.tencent.mm.emoji.a.b.y;
import com.tencent.mm.emoji.b.b;
import com.tencent.mm.emoji.b.f;
import com.tencent.mm.emoji.panel.a.x.b;
import com.tencent.mm.emoji.panel.layout.EmojiPanelLayoutManager;
import com.tencent.mm.emoji.panel.layout.a.a;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.g.a.wf;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import d.g.b.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static boolean LRa = true;
  public final k.a Jgo;
  public final com.tencent.mm.sdk.b.c Jgp;
  public String LQR;
  public boolean LQS;
  public RecyclerView LQT;
  public com.tencent.mm.emoji.panel.a.g LQU;
  public com.tencent.mm.emoji.panel.a.d LQV;
  public View LQW;
  public ImageView LQX;
  public RecyclerView LQY;
  public com.tencent.mm.emoji.panel.a.x LQZ;
  public com.tencent.mm.emoji.a.b.i LRb;
  public final com.tencent.mm.emoji.a.b.j LRc;
  private v LRd;
  public boolean LRe;
  public ak LRf;
  public com.tencent.mm.pluginsdk.ui.chat.j LRg;
  public af LRh;
  public final k.a LRi;
  public final com.tencent.mm.sdk.b.c<dl> LRj;
  public x.b LRk;
  public a.a LRl;
  public com.tencent.mm.sdk.b.c<wf> LRm;
  private final String TAG;
  public Context context;
  public ChatFooterPanel.a gpy;
  public boolean isResume;
  public String vmW;
  public LinearLayoutManager zTo;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(188530);
    this.TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelManager";
    this.isResume = false;
    this.LQR = null;
    this.LQS = false;
    this.LRe = false;
    this.LRh = new af();
    this.LRi = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(105285);
        if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals("event_update_group")))
        {
          ae.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "modify emoji group .");
          a.i(a.this).afG();
        }
        AppMethodBeat.o(105285);
      }
    };
    this.Jgo = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(105286);
        ae.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "emoji storage notify %s", new Object[] { paramAnonymousString });
        if (paramAnonymousString == null)
        {
          AppMethodBeat.o(105286);
          return;
        }
        a.i(a.this).afG();
        AppMethodBeat.o(105286);
      }
    };
    this.Jgp = new com.tencent.mm.sdk.b.c() {};
    this.LRj = new com.tencent.mm.sdk.b.c() {};
    this.LRk = new x.b()
    {
      public final void b(int paramAnonymousInt, View paramAnonymousView)
      {
        AppMethodBeat.i(105290);
        Object localObject1 = a.d(a.this).mh(paramAnonymousInt);
        if (localObject1 == null)
        {
          ae.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab is null. ignore click action.");
          AppMethodBeat.o(105290);
          return;
        }
        if (((ag)localObject1).type == 1)
        {
          a.kR(paramAnonymousView.getContext());
          AppMethodBeat.o(105290);
          return;
        }
        if (((ag)localObject1).type == 2)
        {
          a.a(a.this, paramAnonymousView.getContext());
          AppMethodBeat.o(105290);
          return;
        }
        EmojiGroupInfo localEmojiGroupInfo = ((ag)localObject1).gkF;
        Object localObject2 = com.tencent.mm.emoji.b.e.grc;
        com.tencent.mm.emoji.b.e.z(((ag)localObject1).bEA + 1, localEmojiGroupInfo.field_productID);
        a.this.setTabSelected(((ag)localObject1).bEA);
        localObject2 = a.g(a.this);
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(((ag)localObject1).bEA, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/view/manager/SmileyPanelManager$9", "onItemClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView)localObject2).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/view/manager/SmileyPanelManager$9", "onItemClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        if ((localEmojiGroupInfo.field_productID.equals(ad.afP())) && (a.j(a.this).gnq))
        {
          if (((h)com.tencent.mm.kernel.g.ajO().ajq()).akL()) {
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYA, Boolean.TRUE);
          }
          paramAnonymousView = paramAnonymousView.findViewById(2131304866);
          if (paramAnonymousView != null) {
            paramAnonymousView.setVisibility(8);
          }
        }
        AppMethodBeat.o(105290);
      }
    };
    this.LRl = new a.a()
    {
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(105281);
        a.this.setTabSelected(paramAnonymousInt);
        AppMethodBeat.o(105281);
      }
    };
    this.LRm = new a.3(this);
    this.context = paramContext;
    if (LRa)
    {
      LRa = false;
      Iterator localIterator = com.tencent.mm.emoji.a.i.aeX().dk(true).iterator();
      while (localIterator.hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)localIterator.next();
        if (EmojiInfo.a.Jis == localEmojiInfo.fxx())
        {
          localEmojiInfo.a(EmojiInfo.a.Jit);
          localEmojiInfo.a(EmojiInfo.b.JiK);
          ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
          EmojiCaptureReporter.g(localEmojiInfo.field_captureEnterTime, 5, localEmojiInfo.field_captureScene);
        }
        else if (localEmojiInfo.fxx() == EmojiInfo.a.Jiu)
        {
          localEmojiInfo.a(EmojiInfo.a.Jiv);
          ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
          EmojiCaptureReporter.f(localEmojiInfo.field_captureEnterTime, 3, localEmojiInfo.field_captureScene);
        }
      }
    }
    this.LRb = new com.tencent.mm.emoji.a.b.i();
    this.LRb.gnr = true;
    this.LRb.gnp = true;
    this.LQZ = new com.tencent.mm.emoji.panel.a.x(this.LRb);
    this.LQU = new com.tencent.mm.emoji.panel.a.g(this.LRb, this.LRh);
    this.zTo = new EmojiPanelLayoutManager(paramContext);
    this.LQR = com.tencent.mm.emoji.a.i.aeX().gmx;
    ae.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager: select %s", new Object[] { this.LQR });
    this.LRc = new com.tencent.mm.emoji.a.b.j(this.LRb, new y(this.LQU, this.LQZ)
    {
      private boolean xkG = true;
      
      public final void a(v paramAnonymousv)
      {
        AppMethodBeat.i(105280);
        a.a(a.this, paramAnonymousv);
        label137:
        Object localObject;
        int i;
        if (a.a(a.this).afI().size() > 0)
        {
          paramAnonymousv = (ab)a.a(a.this).afI().get(0);
          if ((paramAnonymousv instanceof ak))
          {
            a.a(a.this, (ak)paramAnonymousv);
            b.agm().goq = a.b(a.this).gor.goq;
            if ((a.a(a.this).afI().size() != 1) || (a.b(a.this) == null)) {
              break label523;
            }
            a.c(a.this).setVisibility(8);
          }
        }
        else
        {
          paramAnonymousv = a.d(a.this);
          localObject = a.a(a.this).afJ();
          p.h(localObject, "data");
          paramAnonymousv.mData.clear();
          paramAnonymousv.mData.addAll((Collection)localObject);
          ae.i(com.tencent.mm.emoji.panel.a.x.TAG, "update %s, %s", new Object[] { Integer.valueOf(paramAnonymousv.mData.size()), Integer.valueOf(((List)localObject).size()) });
          paramAnonymousv = a.e(a.this);
          localObject = a.a(a.this).afH();
          List localList = a.a(a.this).afI();
          p.h(localObject, "groups");
          p.h(localList, "models");
          paramAnonymousv.gpO.clear();
          paramAnonymousv.gpO.addAll((Collection)localObject);
          paramAnonymousv.gpP.clear();
          paramAnonymousv.gpP.addAll((Collection)localList);
          if (this.xkG)
          {
            paramAnonymousv = a.f(a.this);
            i = 0;
            label324:
            if (i >= a.a(a.this).afH().size()) {
              break label544;
            }
            if (!bu.lX(((EmojiGroupInfo)a.a(a.this).afH().get(i)).field_productID, paramAnonymousv)) {
              break label537;
            }
          }
        }
        for (;;)
        {
          paramAnonymousv = a.g(a.this);
          localObject = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousv, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/view/manager/SmileyPanelManager$1", "onUpdateData", "(Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;)V", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousv.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousv, "com/tencent/mm/view/manager/SmileyPanelManager$1", "onUpdateData", "(Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;)V", "Undefined", "scrollToPosition", "(I)V");
          a.this.setTabSelected(i);
          if (i < a.a(a.this).afI().size())
          {
            ((ab)a.a(a.this).afI().get(i)).afG();
            this.xkG = false;
          }
          AppMethodBeat.o(105280);
          return;
          a.a(a.this, null);
          break;
          label523:
          a.c(a.this).setVisibility(0);
          break label137;
          label537:
          i += 1;
          break label324;
          label544:
          i = 0;
        }
      }
    });
    AppMethodBeat.o(188530);
  }
  
  public final void aWU(String paramString)
  {
    AppMethodBeat.i(105296);
    ae.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setCurrentTab: %s", new Object[] { paramString });
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(105296);
      return;
    }
    this.LQR = paramString;
    if (this.LRd == null)
    {
      AppMethodBeat.o(105296);
      return;
    }
    int i = 0;
    while (i < this.LRd.afH().size())
    {
      if (bu.lX(((EmojiGroupInfo)this.LRd.afH().get(i)).field_productID, paramString))
      {
        agN(i);
        AppMethodBeat.o(105296);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(105296);
  }
  
  public final void agN(int paramInt)
  {
    AppMethodBeat.i(105294);
    setTabSelected(paramInt);
    RecyclerView localRecyclerView = this.LQT;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahE(), "com/tencent/mm/view/manager/SmileyPanelManager", "setGroupSelected", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.ca(((Integer)locala.mt(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/view/manager/SmileyPanelManager", "setGroupSelected", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(105294);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(105292);
    ae.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onDestroy %s", new Object[] { this });
    removeListener();
    this.LRh.clear();
    AppMethodBeat.o(105292);
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(105293);
    ae.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager remove listener. %s", new Object[] { this });
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().j(this.LRi);
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().h(this.Jgo);
    com.tencent.mm.sdk.b.a.IvT.d(this.Jgp);
    com.tencent.mm.sdk.b.a.IvT.d(this.LRj);
    this.LQS = false;
    AppMethodBeat.o(105293);
  }
  
  public final void setShowSend(boolean paramBoolean)
  {
    AppMethodBeat.i(169245);
    this.LRb.dr(paramBoolean);
    AppMethodBeat.o(169245);
  }
  
  public final void setShowStore(boolean paramBoolean)
  {
    AppMethodBeat.i(188531);
    if (paramBoolean != this.LRb.gns) {}
    for (int i = 1;; i = 0)
    {
      this.LRb.gns = paramBoolean;
      if (i != 0) {
        this.LRc.afG();
      }
      AppMethodBeat.o(188531);
      return;
    }
  }
  
  public final void setTabSelected(int paramInt)
  {
    int j = 2;
    AppMethodBeat.i(105295);
    ae.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setTabSelected: %s, %s", new Object[] { Integer.valueOf(paramInt), this.LQR });
    if (this.LRd == null)
    {
      AppMethodBeat.o(105295);
      return;
    }
    final int i;
    String str;
    Object localObject1;
    if ((paramInt >= 0) && (paramInt < this.LRd.afH().size()))
    {
      i = this.LRd.ma(paramInt);
      if ((this.LQY != null) && (this.LQZ != null))
      {
        this.LQZ.setSelection(i);
        this.LQY.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(105283);
            RecyclerView localRecyclerView = a.c(a.this);
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahE(), "com/tencent/mm/view/manager/SmileyPanelManager$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            localRecyclerView.smoothScrollToPosition(((Integer)locala.mt(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/view/manager/SmileyPanelManager$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            AppMethodBeat.o(105283);
          }
        });
      }
      str = ((EmojiGroupInfo)this.LRd.afH().get(paramInt)).field_productID;
      this.LQR = str;
      localObject1 = ((ab)this.LRd.afI().get(paramInt)).afB();
      if (!(localObject1 instanceof al)) {
        break label422;
      }
      Object localObject2 = com.tencent.mm.emoji.b.c.gqZ;
      com.tencent.mm.emoji.b.c.agn().gW(str);
      localObject2 = com.tencent.mm.emoji.b.c.gqZ;
      localObject2 = com.tencent.mm.emoji.b.c.agn();
      if (!((al)localObject1).gnS) {
        break label417;
      }
      i = 2;
      ((com.tencent.mm.g.b.a.x)localObject2).dVM = i;
      localObject1 = com.tencent.mm.emoji.b.c.gqZ;
      com.tencent.mm.emoji.b.c.agn().dVO = (paramInt + 1);
      localObject1 = com.tencent.mm.emoji.b.c.gqZ;
      com.tencent.mm.emoji.b.c.md(1);
      label246:
      f.agp().grf = paramInt;
      localObject1 = f.agp();
      if (!bu.lX(str, ad.afO())) {
        break label452;
      }
      i = 1;
    }
    for (;;)
    {
      ((f)localObject1).gre = i;
      f.agp().grg = ((ab)this.LRd.afI().get(paramInt)).afB().afA();
      this.LRe = bu.lX(str, ad.afN());
      if (this.gpy != null) {
        this.gpy.dW(this.LRe);
      }
      if ((!this.LRe) && (this.LRf != null)) {
        this.LRf.afG();
      }
      if ((this.isResume) && (bu.lX(str, ad.afP())) && (this.LRb.gnr)) {
        com.tencent.mm.plugin.report.service.g.yxI.f(15982, new Object[] { Integer.valueOf(0) });
      }
      AppMethodBeat.o(105295);
      return;
      label417:
      i = 1;
      break;
      label422:
      localObject1 = com.tencent.mm.emoji.b.c.gqZ;
      com.tencent.mm.emoji.b.c.agn().gW("");
      localObject1 = com.tencent.mm.emoji.b.c.gqZ;
      com.tencent.mm.emoji.b.c.agn().dVO = 0;
      break label246;
      label452:
      i = j;
      if (!bu.lX(str, ad.afP())) {
        i = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.d.a
 * JD-Core Version:    0.7.0.1
 */