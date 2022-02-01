package com.tencent.mm.view.manager;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aaf;
import com.tencent.mm.autogen.a.ed;
import com.tencent.mm.autogen.mmdata.rpt.bt;
import com.tencent.mm.emoji.c.b.aa;
import com.tencent.mm.emoji.c.b.af;
import com.tencent.mm.emoji.c.b.ah;
import com.tencent.mm.emoji.c.b.ai;
import com.tencent.mm.emoji.c.b.al;
import com.tencent.mm.emoji.c.b.am;
import com.tencent.mm.emoji.c.b.an;
import com.tencent.mm.emoji.c.b.x;
import com.tencent.mm.emoji.c.b.y;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.emoji.panel.a.ab;
import com.tencent.mm.emoji.panel.a.ad.b;
import com.tencent.mm.emoji.panel.layout.EmojiPanelLayoutManager;
import com.tencent.mm.emoji.panel.layout.a.b;
import com.tencent.mm.emoji.sync.g.i;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import com.tencent.mm.ui.widget.pulldown.NestedBounceView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.s;

public final class a
{
  private static boolean agMM = true;
  public LinearLayoutManager AJH;
  public final ab GHc;
  public ah GHd;
  private final String TAG;
  public final MStorage.IOnStorageChange adjP;
  public final IListener adjQ;
  public String agMC;
  public boolean agMD;
  public RecyclerView agME;
  public com.tencent.mm.emoji.panel.a.f agMF;
  public com.tencent.mm.emoji.panel.a.d agMG;
  public View agMH;
  public ImageView agMI;
  public RecyclerView agMJ;
  public NestedBounceView agMK;
  public com.tencent.mm.emoji.panel.a.ad agML;
  public com.tencent.mm.emoji.c.b.i agMN;
  public final com.tencent.mm.emoji.c.b.j agMO;
  private x agMP;
  private boolean agMQ;
  private am agMR;
  public final com.tencent.mm.emoji.panel.a.i agMS;
  private com.tencent.mm.plugin.emoji.ui.b agMT;
  private androidx.appcompat.app.e agMU;
  public final MStorage.IOnStorageChange agMV;
  public final IListener<ed> agMW;
  public ad.b agMX;
  public a.b agMY;
  public IListener<aaf> agMZ;
  public g.i agNa;
  public Context context;
  public boolean isResume;
  public ChatFooterPanel.a mkD;
  public String mpr;
  public String mps;
  public com.tencent.mm.pluginsdk.ui.chat.j mpu;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(235005);
    this.TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelManager";
    this.isResume = false;
    this.agMC = null;
    this.agMD = false;
    this.agMQ = false;
    this.agMS = new com.tencent.mm.emoji.panel.a.i();
    this.GHc = new ab();
    this.GHd = new ah();
    this.agMV = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(105285);
        if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals("event_update_group")))
        {
          Log.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "modify emoji group .");
          a.i(a.this).aVl();
        }
        AppMethodBeat.o(105285);
      }
    };
    this.adjP = new MStorage.IOnStorageChange()
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
        a.i(a.this).aVl();
        AppMethodBeat.o(105286);
      }
    };
    this.adjQ = new SmileyPanelManager.7(this, com.tencent.mm.app.f.hfK);
    this.agMW = new SmileyPanelManager.8(this, com.tencent.mm.app.f.hfK);
    this.agMX = new ad.b()
    {
      public final void c(int paramAnonymousInt, View paramAnonymousView)
      {
        AppMethodBeat.i(105290);
        Object localObject1 = a.d(a.this).rK(paramAnonymousInt);
        if (localObject1 == null)
        {
          Log.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab is null. ignore click action.");
          AppMethodBeat.o(105290);
          return;
        }
        if (((ai)localObject1).type == 2)
        {
          a.nN(paramAnonymousView.getContext());
          AppMethodBeat.o(105290);
          return;
        }
        if (((ai)localObject1).type == 3)
        {
          if (com.tencent.mm.search.a.iTt())
          {
            a.a(a.this, paramAnonymousView.getContext());
            AppMethodBeat.o(105290);
            return;
          }
          a.b(a.this, paramAnonymousView.getContext());
          AppMethodBeat.o(105290);
          return;
        }
        EmojiGroupInfo localEmojiGroupInfo = ((ai)localObject1).mgd;
        Object localObject2 = com.tencent.mm.emoji.d.g.mmw;
        paramAnonymousInt = ((ai)localObject1).aoB;
        localObject2 = localEmojiGroupInfo.field_productID;
        long l = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.h.OAn.b(18231, new Object[] { Long.valueOf(com.tencent.mm.emoji.d.g.mmo), Integer.valueOf(com.tencent.mm.emoji.d.g.scene), Integer.valueOf(com.tencent.mm.emoji.d.g.mmp), Long.valueOf(l), Integer.valueOf(paramAnonymousInt + 1), localObject2 });
        com.tencent.mm.emoji.d.g.mmp += 1;
        a.this.setTabSelected(((ai)localObject1).aoB);
        localObject2 = a.g(a.this);
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(((ai)localObject1).aoB, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/view/manager/SmileyPanelManager$9", "onItemClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView)localObject2).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/view/manager/SmileyPanelManager$9", "onItemClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        if ((localEmojiGroupInfo.field_productID.equals(af.aVv())) && (a.j(a.this).miD))
        {
          if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acWW, Boolean.TRUE);
          }
          paramAnonymousView = paramAnonymousView.findViewById(a.g.smiley_listview_item_dot);
          if (paramAnonymousView != null) {
            paramAnonymousView.setVisibility(8);
          }
        }
        AppMethodBeat.o(105290);
      }
    };
    this.agMY = new a.b()
    {
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(105281);
        a.this.setTabSelected(paramAnonymousInt);
        AppMethodBeat.o(105281);
      }
    };
    this.agMZ = new SmileyPanelManager.11(this, com.tencent.mm.app.f.hfK);
    this.agNa = new g.i()
    {
      public final void aVL()
      {
        AppMethodBeat.i(234999);
        a.i(a.this).aVl();
        AppMethodBeat.o(234999);
      }
    };
    this.context = paramContext;
    if (agMM)
    {
      agMM = false;
      Iterator localIterator = l.aUF().fe(true).iterator();
      while (localIterator.hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)localIterator.next();
        if (EmojiInfo.a.admf == localEmojiInfo.kMj())
        {
          localEmojiInfo.a(EmojiInfo.a.admg);
          localEmojiInfo.a(EmojiInfo.b.admx);
          ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
          EmojiCaptureReporter.i(localEmojiInfo.field_captureEnterTime, 5, localEmojiInfo.field_captureScene);
        }
        else if (localEmojiInfo.kMj() == EmojiInfo.a.admh)
        {
          localEmojiInfo.a(EmojiInfo.a.admi);
          ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
          EmojiCaptureReporter.h(localEmojiInfo.field_captureEnterTime, 3, localEmojiInfo.field_captureScene);
        }
      }
    }
    this.agMN = new com.tencent.mm.emoji.c.b.i();
    this.agMN.miE = true;
    this.agMN.miC = true;
    this.agML = new com.tencent.mm.emoji.panel.a.ad(this.agMN);
    this.agMF = new com.tencent.mm.emoji.panel.a.f(this.agMN, this.GHd, this.GHc, this.agMS);
    this.AJH = new EmojiPanelLayoutManager(paramContext);
    this.agMC = l.aUF().mhW;
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager: select %s", new Object[] { this.agMC });
    this.agMO = new com.tencent.mm.emoji.c.b.j(this.agMN, new aa(this.agMF, this.agML)
    {
      private boolean Nbi = true;
      
      public final void a(x paramAnonymousx)
      {
        AppMethodBeat.i(105280);
        a.a(a.this, paramAnonymousx);
        Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onUpdateData: group size %s", new Object[] { Integer.valueOf(a.a(a.this).aVn().size()) });
        label171:
        Object localObject1;
        int i;
        if (a.a(a.this).aVn().size() > 0)
        {
          paramAnonymousx = (com.tencent.mm.emoji.c.b.ad)a.a(a.this).aVn().get(0);
          if ((paramAnonymousx instanceof am))
          {
            a.a(a.this, (am)paramAnonymousx);
            com.tencent.mm.emoji.d.c.aWb().mjA = a.b(a.this).mjB.mjA;
            if ((a.a(a.this).aVo().size() != 1) || (a.b(a.this) == null)) {
              break label639;
            }
            a.c(a.this).setVisibility(8);
          }
        }
        else
        {
          paramAnonymousx = a.d(a.this);
          localObject1 = a.a(a.this).aVo();
          s.u(localObject1, "data");
          paramAnonymousx.mlK.clear();
          paramAnonymousx.mlK.addAll((Collection)localObject1);
          if (paramAnonymousx.mlM != null)
          {
            localObject2 = ((List)paramAnonymousx.mlK).iterator();
            i = 0;
            label243:
            if (!((Iterator)localObject2).hasNext()) {
              break label660;
            }
            if (!s.p(((ai)((Iterator)localObject2).next()).mgd.field_productID, paramAnonymousx.mlM)) {
              break label653;
            }
            label279:
            int j = i;
            if (i < 0) {
              j = 0;
            }
            paramAnonymousx.setSelection(j);
          }
          Log.i(com.tencent.mm.emoji.panel.a.ad.TAG, "update %s, %s", new Object[] { Integer.valueOf(paramAnonymousx.mlK.size()), Integer.valueOf(((List)localObject1).size()) });
          paramAnonymousx = a.e(a.this);
          localObject1 = a.a(a.this).aVm();
          Object localObject2 = a.a(a.this).aVn();
          s.u(localObject1, "groups");
          s.u(localObject2, "models");
          paramAnonymousx.mkV.clear();
          paramAnonymousx.mkV.addAll((Collection)localObject1);
          paramAnonymousx.mkW.clear();
          paramAnonymousx.mkW.addAll((Collection)localObject2);
          if (this.Nbi)
          {
            paramAnonymousx = a.f(a.this);
            i = 0;
            label437:
            if (i >= a.a(a.this).aVm().size()) {
              break label672;
            }
            if (!Util.isEqual(((EmojiGroupInfo)a.a(a.this).aVm().get(i)).field_productID, paramAnonymousx)) {
              break label665;
            }
          }
        }
        for (;;)
        {
          paramAnonymousx = a.g(a.this);
          localObject1 = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousx, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/view/manager/SmileyPanelManager$1", "onUpdateData", "(Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;)V", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousx.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousx, "com/tencent/mm/view/manager/SmileyPanelManager$1", "onUpdateData", "(Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;)V", "Undefined", "scrollToPosition", "(I)V");
          a.this.setTabSelected(i);
          if (i < a.a(a.this).aVn().size())
          {
            ((com.tencent.mm.emoji.c.b.ad)a.a(a.this).aVn().get(i)).aVl();
            this.Nbi = false;
          }
          AppMethodBeat.o(105280);
          return;
          a.a(a.this, null);
          break;
          label639:
          a.c(a.this).setVisibility(0);
          break label171;
          label653:
          i += 1;
          break label243;
          label660:
          i = -1;
          break label279;
          label665:
          i += 1;
          break label437;
          label672:
          i = 0;
        }
      }
    });
    AppMethodBeat.o(235005);
  }
  
  public final void Jy(boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(235072);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setShowCustom: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.FALSE });
    int i = j;
    if (paramBoolean == this.agMN.miA) {
      if (!this.agMN.miC) {
        break label92;
      }
    }
    label92:
    for (i = j;; i = 0)
    {
      this.agMN.miA = paramBoolean;
      this.agMN.miC = false;
      if (i != 0) {
        this.agMO.aVl();
      }
      AppMethodBeat.o(235072);
      return;
    }
  }
  
  public final void Jz(boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(235076);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setShowCapture: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.FALSE });
    int i = j;
    if (paramBoolean == this.agMN.miD) {
      if (!this.agMN.miE) {
        break label92;
      }
    }
    label92:
    for (i = j;; i = 0)
    {
      this.agMN.miD = paramBoolean;
      this.agMN.miE = false;
      if (i != 0) {
        this.agMO.aVl();
      }
      AppMethodBeat.o(235076);
      return;
    }
  }
  
  public final void aGb(int paramInt)
  {
    AppMethodBeat.i(105294);
    setTabSelected(paramInt);
    RecyclerView localRecyclerView = this.agME;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aYi(), "com/tencent/mm/view/manager/SmileyPanelManager", "setGroupSelected", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/view/manager/SmileyPanelManager", "setGroupSelected", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(105294);
  }
  
  public final void aNi()
  {
    AppMethodBeat.i(235060);
    this.agMO.aVl();
    this.agMN.aVk();
    AppMethodBeat.o(235060);
  }
  
  public final void bzP(String paramString)
  {
    AppMethodBeat.i(105296);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setCurrentTab: %s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(105296);
      return;
    }
    this.agMC = paramString;
    if (this.agMP == null)
    {
      AppMethodBeat.o(105296);
      return;
    }
    int i = 0;
    while (i < this.agMP.aVm().size())
    {
      if (Util.isEqual(((EmojiGroupInfo)this.agMP.aVm().get(i)).field_productID, paramString))
      {
        aGb(i);
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
    this.GHd.clear();
    AppMethodBeat.o(105292);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(235064);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onResume: ");
    this.isResume = true;
    this.agMN.aVk();
    if (this.agMR != null) {
      this.agMR.aVl();
    }
    if (this.mkD != null) {
      this.mkD.fp(this.agMQ);
    }
    if (this.isResume)
    {
      if ((Util.isEqual(this.agMC, af.aVv())) && (this.agMN.miE)) {
        com.tencent.mm.plugin.report.service.h.OAn.b(15982, new Object[] { Integer.valueOf(0) });
      }
      com.tencent.mm.emoji.d.d locald = com.tencent.mm.emoji.d.d.mmr;
      com.tencent.mm.emoji.d.d.rG(1);
      if (this.agMT != null) {
        this.agMT.dBD();
      }
    }
    AppMethodBeat.o(235064);
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(105293);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager remove listener. %s", new Object[] { this });
    ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().j(this.agMV);
    ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().h(this.adjP);
    this.adjQ.dead();
    this.agMW.dead();
    com.tencent.mm.emoji.sync.g.aWn().b(this.agNa);
    com.tencent.mm.emoji.sync.g.aWo().b(this.agNa);
    this.agMD = false;
    AppMethodBeat.o(105293);
  }
  
  public final void setShowSearch(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(235084);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setShowSearch: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean != this.agMN.miy) {}
    for (;;)
    {
      this.agMN.miy = paramBoolean;
      if (i != 0) {
        this.agMO.aVl();
      }
      AppMethodBeat.o(235084);
      return;
      i = 0;
    }
  }
  
  public final void setShowSend(boolean paramBoolean)
  {
    AppMethodBeat.i(169245);
    this.agMN.fk(paramBoolean);
    AppMethodBeat.o(169245);
  }
  
  public final void setShowStore(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(235080);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setShowStore: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean != this.agMN.miF) {}
    for (;;)
    {
      this.agMN.miF = paramBoolean;
      if (i != 0) {
        this.agMO.aVl();
      }
      AppMethodBeat.o(235080);
      return;
      i = 0;
    }
  }
  
  public final void setTabSelected(int paramInt)
  {
    int j = 2;
    AppMethodBeat.i(105295);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setTabSelected: %s, %s", new Object[] { Integer.valueOf(paramInt), this.agMC });
    if (this.agMP == null)
    {
      AppMethodBeat.o(105295);
      return;
    }
    final int i;
    String str;
    Object localObject1;
    if ((paramInt >= 0) && (paramInt < this.agMP.aVm().size()))
    {
      i = this.agMP.rD(paramInt);
      if ((this.agMJ != null) && (this.agML != null))
      {
        this.agML.setSelection(i);
        this.agMJ.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(105283);
            RecyclerView localRecyclerView = a.c(a.this);
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aYi(), "com/tencent/mm/view/manager/SmileyPanelManager$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            localRecyclerView.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/view/manager/SmileyPanelManager$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            AppMethodBeat.o(105283);
          }
        });
      }
      str = ((EmojiGroupInfo)this.agMP.aVm().get(paramInt)).field_productID;
      this.agMC = str;
      localObject1 = ((com.tencent.mm.emoji.c.b.ad)this.agMP.aVn().get(paramInt)).aVh();
      if (!(localObject1 instanceof an)) {
        break label453;
      }
      if (!((an)localObject1).aVB()) {
        ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoq(str);
      }
      Object localObject2 = com.tencent.mm.emoji.d.d.mmr;
      com.tencent.mm.emoji.d.d.aWc().lb(str);
      localObject2 = com.tencent.mm.emoji.d.d.mmr;
      localObject2 = com.tencent.mm.emoji.d.d.aWc();
      if (!((an)localObject1).mjf) {
        break label448;
      }
      i = 2;
      ((bt)localObject2).iuw = i;
      localObject1 = com.tencent.mm.emoji.d.d.mmr;
      com.tencent.mm.emoji.d.d.aWc().iuy = (paramInt + 1);
      localObject1 = com.tencent.mm.emoji.d.d.mmr;
      com.tencent.mm.emoji.d.d.rG(1);
      label277:
      com.tencent.mm.emoji.d.h.aWe().mmz = paramInt;
      localObject1 = com.tencent.mm.emoji.d.h.aWe();
      if (!Util.isEqual(str, af.aVu())) {
        break label483;
      }
      i = 1;
    }
    for (;;)
    {
      ((com.tencent.mm.emoji.d.h)localObject1).mmy = i;
      com.tencent.mm.emoji.d.h.aWe().mmA = ((com.tencent.mm.emoji.c.b.ad)this.agMP.aVn().get(paramInt)).aVh().getDataCount();
      this.agMQ = Util.isEqual(str, af.aVt());
      if (this.mkD != null) {
        this.mkD.fp(this.agMQ);
      }
      if ((!this.agMQ) && (this.agMR != null)) {
        this.agMR.aVl();
      }
      if ((this.isResume) && (Util.isEqual(str, af.aVv())) && (this.agMN.miE)) {
        com.tencent.mm.plugin.report.service.h.OAn.b(15982, new Object[] { Integer.valueOf(0) });
      }
      AppMethodBeat.o(105295);
      return;
      label448:
      i = 1;
      break;
      label453:
      localObject1 = com.tencent.mm.emoji.d.d.mmr;
      com.tencent.mm.emoji.d.d.aWc().lb("");
      localObject1 = com.tencent.mm.emoji.d.d.mmr;
      com.tencent.mm.emoji.d.d.aWc().iuy = 0;
      break label277;
      label483:
      i = j;
      if (!Util.isEqual(str, af.aVv())) {
        i = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.manager.a
 * JD-Core Version:    0.7.0.1
 */