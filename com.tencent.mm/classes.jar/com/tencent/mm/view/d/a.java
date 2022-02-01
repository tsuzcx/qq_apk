package com.tencent.mm.view.d;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.af;
import com.tencent.mm.emoji.b.b.ag;
import com.tencent.mm.emoji.b.b.aj;
import com.tencent.mm.emoji.b.b.ak;
import com.tencent.mm.emoji.b.b.al;
import com.tencent.mm.emoji.b.b.i;
import com.tencent.mm.emoji.b.b.v;
import com.tencent.mm.emoji.b.b.w;
import com.tencent.mm.emoji.b.b.y;
import com.tencent.mm.emoji.panel.a.ad.b;
import com.tencent.mm.emoji.panel.layout.EmojiPanelLayoutManager;
import com.tencent.mm.emoji.panel.layout.a.b;
import com.tencent.mm.g.a.do;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.g.a.xf;
import com.tencent.mm.g.b.a.aq;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;

public final class a
{
  private static boolean RpJ = true;
  public String RpA;
  public boolean RpB;
  public RecyclerView RpC;
  public com.tencent.mm.emoji.panel.a.g RpD;
  public com.tencent.mm.emoji.panel.a.d RpE;
  public View RpF;
  public ImageView RpG;
  public RecyclerView RpH;
  public com.tencent.mm.emoji.panel.a.ad RpI;
  public i RpK;
  public final com.tencent.mm.emoji.b.b.j RpL;
  private v RpM;
  public boolean RpN;
  public ak RpO;
  public final com.tencent.mm.emoji.panel.a.j RpP;
  public final com.tencent.mm.emoji.panel.a.ab RpQ;
  public af RpR;
  public com.tencent.mm.plugin.emoji.ui.b RpS;
  public final IListener<do> RpT;
  public ad.b RpU;
  public a.b RpV;
  public IListener<xf> RpW;
  private final String TAG;
  public Context context;
  public ChatFooterPanel.a har;
  public boolean isResume;
  public String rgD;
  public String rgH;
  public com.tencent.mm.pluginsdk.ui.chat.j rgI;
  public LinearLayoutManager vKp;
  public final MStorage.IOnStorageChange wKe;
  public final MStorage.IOnStorageChange wKf;
  public final IListener wKg;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(199833);
    this.TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelManager";
    this.isResume = false;
    this.RpA = null;
    this.RpB = false;
    this.RpN = false;
    this.RpP = new com.tencent.mm.emoji.panel.a.j();
    this.RpQ = new com.tencent.mm.emoji.panel.a.ab();
    this.RpR = new af();
    this.wKe = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(105285);
        if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals("event_update_group")))
        {
          Log.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "modify emoji group .");
          a.i(a.this).avu();
        }
        AppMethodBeat.o(105285);
      }
    };
    this.wKf = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(105286);
        Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "emoji storage notify %s", new Object[] { paramAnonymousString });
        if (paramAnonymousString == null)
        {
          AppMethodBeat.o(105286);
          return;
        }
        a.i(a.this).avu();
        AppMethodBeat.o(105286);
      }
    };
    this.wKg = new IListener() {};
    this.RpT = new IListener() {};
    this.RpU = new ad.b()
    {
      public final void b(int paramAnonymousInt, View paramAnonymousView)
      {
        AppMethodBeat.i(105290);
        Object localObject1 = a.d(a.this).pp(paramAnonymousInt);
        if (localObject1 == null)
        {
          Log.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab is null. ignore click action.");
          AppMethodBeat.o(105290);
          return;
        }
        if (((ag)localObject1).type == 1)
        {
          a.kN(paramAnonymousView.getContext());
          AppMethodBeat.o(105290);
          return;
        }
        if (((ag)localObject1).type == 2)
        {
          if (com.tencent.mm.search.a.gxp())
          {
            a.a(a.this, paramAnonymousView.getContext());
            AppMethodBeat.o(105290);
            return;
          }
          a.b(a.this, paramAnonymousView.getContext());
          AppMethodBeat.o(105290);
          return;
        }
        EmojiGroupInfo localEmojiGroupInfo = ((ag)localObject1).gVA;
        Object localObject2 = com.tencent.mm.emoji.c.g.hcn;
        com.tencent.mm.emoji.c.g.B(((ag)localObject1).bEC + 1, localEmojiGroupInfo.field_productID);
        a.this.setTabSelected(((ag)localObject1).bEC);
        localObject2 = a.g(a.this);
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(((ag)localObject1).bEC, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/view/manager/SmileyPanelManager$9", "onItemClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView)localObject2).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/view/manager/SmileyPanelManager$9", "onItemClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        if ((localEmojiGroupInfo.field_productID.equals(com.tencent.mm.emoji.b.b.ad.avD())) && (a.j(a.this).gYk))
        {
          if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).aBb()) {
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OgX, Boolean.TRUE);
          }
          paramAnonymousView = paramAnonymousView.findViewById(2131307952);
          if (paramAnonymousView != null) {
            paramAnonymousView.setVisibility(8);
          }
        }
        AppMethodBeat.o(105290);
      }
    };
    this.RpV = new a.b()
    {
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(105281);
        a.this.setTabSelected(paramAnonymousInt);
        AppMethodBeat.o(105281);
      }
    };
    this.RpW = new IListener() {};
    this.context = paramContext;
    if (RpJ)
    {
      RpJ = false;
      Iterator localIterator = com.tencent.mm.emoji.b.j.auL().dU(true).iterator();
      while (localIterator.hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)localIterator.next();
        if (EmojiInfo.a.Osk == localEmojiInfo.hRH())
        {
          localEmojiInfo.a(EmojiInfo.a.Osl);
          localEmojiInfo.a(EmojiInfo.b.OsC);
          ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
          EmojiCaptureReporter.g(localEmojiInfo.field_captureEnterTime, 5, localEmojiInfo.field_captureScene);
        }
        else if (localEmojiInfo.hRH() == EmojiInfo.a.Osm)
        {
          localEmojiInfo.a(EmojiInfo.a.Osn);
          ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
          EmojiCaptureReporter.f(localEmojiInfo.field_captureEnterTime, 3, localEmojiInfo.field_captureScene);
        }
      }
    }
    this.RpK = new i();
    this.RpK.gYl = true;
    this.RpK.gYj = true;
    this.RpI = new com.tencent.mm.emoji.panel.a.ad(this.RpK);
    this.RpD = new com.tencent.mm.emoji.panel.a.g(this.RpK, this.RpR, this.RpQ, this.RpP);
    this.vKp = new EmojiPanelLayoutManager(paramContext);
    this.RpA = com.tencent.mm.emoji.b.j.auL().gXo;
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager: select %s", new Object[] { this.RpA });
    this.RpL = new com.tencent.mm.emoji.b.b.j(this.RpK, new y(this.RpD, this.RpI)
    {
      private boolean BiE = true;
      
      public final void a(v paramAnonymousv)
      {
        AppMethodBeat.i(105280);
        a.a(a.this, paramAnonymousv);
        label137:
        Object localObject;
        int i;
        if (a.a(a.this).avw().size() > 0)
        {
          paramAnonymousv = (com.tencent.mm.emoji.b.b.ab)a.a(a.this).avw().get(0);
          if ((paramAnonymousv instanceof ak))
          {
            a.a(a.this, (ak)paramAnonymousv);
            com.tencent.mm.emoji.c.c.awc().gZj = a.b(a.this).gZk.gZj;
            if ((a.a(a.this).avw().size() != 1) || (a.b(a.this) == null)) {
              break label523;
            }
            a.c(a.this).setVisibility(8);
          }
        }
        else
        {
          paramAnonymousv = a.d(a.this);
          localObject = a.a(a.this).avx();
          p.h(localObject, "data");
          paramAnonymousv.mData.clear();
          paramAnonymousv.mData.addAll((Collection)localObject);
          Log.i(com.tencent.mm.emoji.panel.a.ad.TAG, "update %s, %s", new Object[] { Integer.valueOf(paramAnonymousv.mData.size()), Integer.valueOf(((List)localObject).size()) });
          paramAnonymousv = a.e(a.this);
          localObject = a.a(a.this).avv();
          List localList = a.a(a.this).avw();
          p.h(localObject, "groups");
          p.h(localList, "models");
          paramAnonymousv.haH.clear();
          paramAnonymousv.haH.addAll((Collection)localObject);
          paramAnonymousv.haI.clear();
          paramAnonymousv.haI.addAll((Collection)localList);
          if (this.BiE)
          {
            paramAnonymousv = a.f(a.this);
            i = 0;
            label324:
            if (i >= a.a(a.this).avv().size()) {
              break label544;
            }
            if (!Util.isEqual(((EmojiGroupInfo)a.a(a.this).avv().get(i)).field_productID, paramAnonymousv)) {
              break label537;
            }
          }
        }
        for (;;)
        {
          paramAnonymousv = a.g(a.this);
          localObject = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousv, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/view/manager/SmileyPanelManager$1", "onUpdateData", "(Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;)V", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousv.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousv, "com/tencent/mm/view/manager/SmileyPanelManager$1", "onUpdateData", "(Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;)V", "Undefined", "scrollToPosition", "(I)V");
          a.this.setTabSelected(i);
          if (i < a.a(a.this).avw().size())
          {
            ((com.tencent.mm.emoji.b.b.ab)a.a(a.this).avw().get(i)).avu();
            this.BiE = false;
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
    AppMethodBeat.o(199833);
  }
  
  public final void apY(int paramInt)
  {
    AppMethodBeat.i(105294);
    setTabSelected(paramInt);
    RecyclerView localRecyclerView = this.RpC;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.axQ(), "com/tencent/mm/view/manager/SmileyPanelManager", "setGroupSelected", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.scrollToPosition(((Integer)locala.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/view/manager/SmileyPanelManager", "setGroupSelected", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(105294);
  }
  
  public final void blU(String paramString)
  {
    AppMethodBeat.i(105296);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setCurrentTab: %s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(105296);
      return;
    }
    this.RpA = paramString;
    if (this.RpM == null)
    {
      AppMethodBeat.o(105296);
      return;
    }
    int i = 0;
    while (i < this.RpM.avv().size())
    {
      if (Util.isEqual(((EmojiGroupInfo)this.RpM.avv().get(i)).field_productID, paramString))
      {
        apY(i);
        AppMethodBeat.o(105296);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(105296);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(105292);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onDestroy %s", new Object[] { this });
    removeListener();
    this.RpR.clear();
    AppMethodBeat.o(105292);
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(105293);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager remove listener. %s", new Object[] { this });
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().j(this.wKe);
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().h(this.wKf);
    EventCenter.instance.removeListener(this.wKg);
    EventCenter.instance.removeListener(this.RpT);
    this.RpB = false;
    AppMethodBeat.o(105293);
  }
  
  public final void setShowSend(boolean paramBoolean)
  {
    AppMethodBeat.i(169245);
    this.RpK.eb(paramBoolean);
    AppMethodBeat.o(169245);
  }
  
  public final void setShowStore(boolean paramBoolean)
  {
    AppMethodBeat.i(199834);
    if (paramBoolean != this.RpK.gYm) {}
    for (int i = 1;; i = 0)
    {
      this.RpK.gYm = paramBoolean;
      if (i != 0) {
        this.RpL.avu();
      }
      AppMethodBeat.o(199834);
      return;
    }
  }
  
  public final void setTabSelected(int paramInt)
  {
    int j = 2;
    AppMethodBeat.i(105295);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setTabSelected: %s, %s", new Object[] { Integer.valueOf(paramInt), this.RpA });
    if (this.RpM == null)
    {
      AppMethodBeat.o(105295);
      return;
    }
    final int i;
    String str;
    Object localObject1;
    if ((paramInt >= 0) && (paramInt < this.RpM.avv().size()))
    {
      i = this.RpM.pi(paramInt);
      if ((this.RpH != null) && (this.RpI != null))
      {
        this.RpI.setSelection(i);
        this.RpH.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(105283);
            RecyclerView localRecyclerView = a.c(a.this);
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.axQ(), "com/tencent/mm/view/manager/SmileyPanelManager$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            localRecyclerView.smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/view/manager/SmileyPanelManager$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            AppMethodBeat.o(105283);
          }
        });
      }
      str = ((EmojiGroupInfo)this.RpM.avv().get(paramInt)).field_productID;
      this.RpA = str;
      localObject1 = ((com.tencent.mm.emoji.b.b.ab)this.RpM.avw().get(paramInt)).avp();
      if (!(localObject1 instanceof al)) {
        break label422;
      }
      Object localObject2 = com.tencent.mm.emoji.c.d.hcj;
      com.tencent.mm.emoji.c.d.awd().it(str);
      localObject2 = com.tencent.mm.emoji.c.d.hcj;
      localObject2 = com.tencent.mm.emoji.c.d.awd();
      if (!((al)localObject1).gYN) {
        break label417;
      }
      i = 2;
      ((aq)localObject2).eqf = i;
      localObject1 = com.tencent.mm.emoji.c.d.hcj;
      com.tencent.mm.emoji.c.d.awd().eqh = (paramInt + 1);
      localObject1 = com.tencent.mm.emoji.c.d.hcj;
      com.tencent.mm.emoji.c.d.pl(1);
      label246:
      com.tencent.mm.emoji.c.h.awf().hcq = paramInt;
      localObject1 = com.tencent.mm.emoji.c.h.awf();
      if (!Util.isEqual(str, com.tencent.mm.emoji.b.b.ad.avC())) {
        break label452;
      }
      i = 1;
    }
    for (;;)
    {
      ((com.tencent.mm.emoji.c.h)localObject1).hcp = i;
      com.tencent.mm.emoji.c.h.awf().hcr = ((com.tencent.mm.emoji.b.b.ab)this.RpM.avw().get(paramInt)).avp().avo();
      this.RpN = Util.isEqual(str, com.tencent.mm.emoji.b.b.ad.avB());
      if (this.har != null) {
        this.har.eP(this.RpN);
      }
      if ((!this.RpN) && (this.RpO != null)) {
        this.RpO.avu();
      }
      if ((this.isResume) && (Util.isEqual(str, com.tencent.mm.emoji.b.b.ad.avD())) && (this.RpK.gYl)) {
        com.tencent.mm.plugin.report.service.h.CyF.a(15982, new Object[] { Integer.valueOf(0) });
      }
      AppMethodBeat.o(105295);
      return;
      label417:
      i = 1;
      break;
      label422:
      localObject1 = com.tencent.mm.emoji.c.d.hcj;
      com.tencent.mm.emoji.c.d.awd().it("");
      localObject1 = com.tencent.mm.emoji.c.d.hcj;
      com.tencent.mm.emoji.c.d.awd().eqh = 0;
      break label246;
      label452:
      i = j;
      if (!Util.isEqual(str, com.tencent.mm.emoji.b.b.ad.avD())) {
        i = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.d.a
 * JD-Core Version:    0.7.0.1
 */