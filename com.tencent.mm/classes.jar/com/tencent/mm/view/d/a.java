package com.tencent.mm.view.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.aa;
import com.tencent.mm.emoji.b.b.ah;
import com.tencent.mm.emoji.b.b.ai;
import com.tencent.mm.emoji.b.b.al;
import com.tencent.mm.emoji.b.b.am;
import com.tencent.mm.emoji.b.b.an;
import com.tencent.mm.emoji.b.b.i;
import com.tencent.mm.emoji.b.b.x;
import com.tencent.mm.emoji.b.b.y;
import com.tencent.mm.emoji.panel.a.af.b;
import com.tencent.mm.emoji.panel.layout.EmojiPanelLayoutManager;
import com.tencent.mm.emoji.panel.layout.a.b;
import com.tencent.mm.emoji.sync.g.i;
import com.tencent.mm.f.a.dt;
import com.tencent.mm.f.a.si;
import com.tencent.mm.f.a.ym;
import com.tencent.mm.f.b.a.ay;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.m.a.g;
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
import com.tencent.mm.ui.widget.pulldown.NestedBounceView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;

public final class a
{
  private static boolean YRf = true;
  public LinearLayoutManager Arh;
  private final String TAG;
  public final MStorage.IOnStorageChange VGb;
  public final IListener VGc;
  public String YQW;
  public boolean YQX;
  public RecyclerView YQY;
  public com.tencent.mm.emoji.panel.a.h YQZ;
  public com.tencent.mm.emoji.panel.a.e YRa;
  public View YRb;
  public ImageView YRc;
  public RecyclerView YRd;
  public com.tencent.mm.emoji.panel.a.af YRe;
  public i YRg;
  public final com.tencent.mm.emoji.b.b.j YRh;
  private x YRi;
  public boolean YRj;
  public am YRk;
  public final com.tencent.mm.emoji.panel.a.k YRl;
  public final com.tencent.mm.emoji.panel.a.ad YRm;
  public ah YRn;
  public com.tencent.mm.plugin.emoji.ui.b YRo;
  public final MStorage.IOnStorageChange YRp;
  public final IListener<dt> YRq;
  public af.b YRr;
  public a.b YRs;
  public IListener<ym> YRt;
  public g.i YRu;
  public NestedBounceView abTh;
  public Context context;
  public boolean isResume;
  public ChatFooterPanel.a jLs;
  public String uJM;
  public String uJQ;
  public com.tencent.mm.pluginsdk.ui.chat.j uJR;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(226540);
    this.TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelManager";
    this.isResume = false;
    this.YQW = null;
    this.YQX = false;
    this.YRj = false;
    this.YRl = new com.tencent.mm.emoji.panel.a.k();
    this.YRm = new com.tencent.mm.emoji.panel.a.ad();
    this.YRn = new ah();
    this.YRp = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(105285);
        if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals("event_update_group")))
        {
          Log.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "modify emoji group .");
          a.i(a.this).aCp();
        }
        AppMethodBeat.o(105285);
      }
    };
    this.VGb = new MStorage.IOnStorageChange()
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
        a.i(a.this).aCp();
        AppMethodBeat.o(105286);
      }
    };
    this.VGc = new IListener() {};
    this.YRq = new a.11(this);
    this.YRr = new af.b()
    {
      public final void b(int paramAnonymousInt, View paramAnonymousView)
      {
        AppMethodBeat.i(105290);
        Object localObject1 = a.d(a.this).rI(paramAnonymousInt);
        if (localObject1 == null)
        {
          Log.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab is null. ignore click action.");
          AppMethodBeat.o(105290);
          return;
        }
        if (((ai)localObject1).type == 1)
        {
          a.lJ(paramAnonymousView.getContext());
          AppMethodBeat.o(105290);
          return;
        }
        if (((ai)localObject1).type == 2)
        {
          if (com.tencent.mm.search.a.htn())
          {
            a.a(a.this, paramAnonymousView.getContext());
            AppMethodBeat.o(105290);
            return;
          }
          a.b(a.this, paramAnonymousView.getContext());
          AppMethodBeat.o(105290);
          return;
        }
        EmojiGroupInfo localEmojiGroupInfo = ((ai)localObject1).jGw;
        Object localObject2 = com.tencent.mm.emoji.c.g.jNx;
        com.tencent.mm.emoji.c.g.C(((ai)localObject1).jKe + 1, localEmojiGroupInfo.field_productID);
        a.this.setTabSelected(((ai)localObject1).jKe);
        localObject2 = a.g(a.this);
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(((ai)localObject1).jKe, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/view/manager/SmileyPanelManager$9", "onItemClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView)localObject2).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/view/manager/SmileyPanelManager$9", "onItemClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        if ((localEmojiGroupInfo.field_productID.equals(com.tencent.mm.emoji.b.b.af.aCy())) && (a.j(a.this).jJk))
        {
          if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE()) {
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vvn, Boolean.TRUE);
          }
          paramAnonymousView = paramAnonymousView.findViewById(a.g.smiley_listview_item_dot);
          if (paramAnonymousView != null) {
            paramAnonymousView.setVisibility(8);
          }
        }
        AppMethodBeat.o(105290);
      }
    };
    this.YRs = new a.b()
    {
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(105281);
        a.this.setTabSelected(paramAnonymousInt);
        AppMethodBeat.o(105281);
      }
    };
    this.YRt = new IListener() {};
    this.YRu = new a.4(this);
    this.context = paramContext;
    if (YRf)
    {
      YRf = false;
      Iterator localIterator = com.tencent.mm.emoji.b.k.aBH().es(true).iterator();
      while (localIterator.hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)localIterator.next();
        if (EmojiInfo.a.VIj == localEmojiInfo.hBB())
        {
          localEmojiInfo.a(EmojiInfo.a.VIk);
          localEmojiInfo.a(EmojiInfo.b.VIB);
          ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
          EmojiCaptureReporter.g(localEmojiInfo.field_captureEnterTime, 5, localEmojiInfo.field_captureScene);
        }
        else if (localEmojiInfo.hBB() == EmojiInfo.a.VIl)
        {
          localEmojiInfo.a(EmojiInfo.a.VIm);
          ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
          EmojiCaptureReporter.f(localEmojiInfo.field_captureEnterTime, 3, localEmojiInfo.field_captureScene);
        }
      }
    }
    this.YRg = new i();
    this.YRg.jJl = true;
    this.YRg.jJj = true;
    this.YRe = new com.tencent.mm.emoji.panel.a.af(this.YRg);
    this.YQZ = new com.tencent.mm.emoji.panel.a.h(this.YRg, this.YRn, this.YRm, this.YRl);
    this.Arh = new EmojiPanelLayoutManager(paramContext);
    this.YQW = com.tencent.mm.emoji.b.k.aBH().jIn;
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager: select %s", new Object[] { this.YQW });
    this.YRh = new com.tencent.mm.emoji.b.b.j(this.YRg, new aa(this.YQZ, this.YRe)
    {
      private boolean HcV = true;
      
      public final void a(x paramAnonymousx)
      {
        AppMethodBeat.i(105280);
        a.a(a.this, paramAnonymousx);
        Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onUpdateData: group size %s", new Object[] { Integer.valueOf(a.a(a.this).aCr().size()) });
        label171:
        Object localObject;
        int i;
        if (a.a(a.this).aCr().size() > 0)
        {
          paramAnonymousx = (com.tencent.mm.emoji.b.b.ad)a.a(a.this).aCr().get(0);
          if ((paramAnonymousx instanceof am))
          {
            a.a(a.this, (am)paramAnonymousx);
            com.tencent.mm.emoji.c.c.aDb().jKk = a.b(a.this).jKl.jKk;
            if ((a.a(a.this).aCs().size() != 1) || (a.b(a.this) == null)) {
              break label557;
            }
            a.c(a.this).setVisibility(8);
          }
        }
        else
        {
          paramAnonymousx = a.d(a.this);
          localObject = a.a(a.this).aCs();
          p.k(localObject, "data");
          paramAnonymousx.mData.clear();
          paramAnonymousx.mData.addAll((Collection)localObject);
          Log.i(com.tencent.mm.emoji.panel.a.af.TAG, "update %s, %s", new Object[] { Integer.valueOf(paramAnonymousx.mData.size()), Integer.valueOf(((List)localObject).size()) });
          paramAnonymousx = a.e(a.this);
          localObject = a.a(a.this).aCq();
          List localList = a.a(a.this).aCr();
          p.k(localObject, "groups");
          p.k(localList, "models");
          paramAnonymousx.jLM.clear();
          paramAnonymousx.jLM.addAll((Collection)localObject);
          paramAnonymousx.jLN.clear();
          paramAnonymousx.jLN.addAll((Collection)localList);
          if (this.HcV)
          {
            paramAnonymousx = a.f(a.this);
            i = 0;
            label358:
            if (i >= a.a(a.this).aCq().size()) {
              break label578;
            }
            if (!Util.isEqual(((EmojiGroupInfo)a.a(a.this).aCq().get(i)).field_productID, paramAnonymousx)) {
              break label571;
            }
          }
        }
        for (;;)
        {
          paramAnonymousx = a.g(a.this);
          localObject = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousx, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/view/manager/SmileyPanelManager$1", "onUpdateData", "(Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;)V", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousx.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousx, "com/tencent/mm/view/manager/SmileyPanelManager$1", "onUpdateData", "(Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;)V", "Undefined", "scrollToPosition", "(I)V");
          a.this.setTabSelected(i);
          if (i < a.a(a.this).aCr().size())
          {
            ((com.tencent.mm.emoji.b.b.ad)a.a(a.this).aCr().get(i)).aCp();
            this.HcV = false;
          }
          AppMethodBeat.o(105280);
          return;
          a.a(a.this, null);
          break;
          label557:
          a.c(a.this).setVisibility(0);
          break label171;
          label571:
          i += 1;
          break label358;
          label578:
          i = 0;
        }
      }
    });
    AppMethodBeat.o(226540);
  }
  
  public final void azx(int paramInt)
  {
    AppMethodBeat.i(105294);
    setTabSelected(paramInt);
    RecyclerView localRecyclerView = this.YQY;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aFh(), "com/tencent/mm/view/manager/SmileyPanelManager", "setGroupSelected", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.scrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/view/manager/SmileyPanelManager", "setGroupSelected", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(105294);
  }
  
  public final void byt(String paramString)
  {
    AppMethodBeat.i(105296);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setCurrentTab: %s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(105296);
      return;
    }
    this.YQW = paramString;
    if (this.YRi == null)
    {
      AppMethodBeat.o(105296);
      return;
    }
    int i = 0;
    while (i < this.YRi.aCq().size())
    {
      if (Util.isEqual(((EmojiGroupInfo)this.YRi.aCq().get(i)).field_productID, paramString))
      {
        azx(i);
        AppMethodBeat.o(105296);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(105296);
  }
  
  public final void hjn()
  {
    int j = 1;
    AppMethodBeat.i(226549);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setShowCustom: %s, %s", new Object[] { Boolean.FALSE, Boolean.FALSE });
    int i = j;
    if (!this.YRg.jJh) {
      if (!this.YRg.jJj) {
        break label90;
      }
    }
    label90:
    for (i = j;; i = 0)
    {
      this.YRg.jJh = false;
      this.YRg.jJj = false;
      if (i != 0) {
        this.YRh.aCp();
      }
      AppMethodBeat.o(226549);
      return;
    }
  }
  
  public final void hjo()
  {
    int j = 1;
    AppMethodBeat.i(226553);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setShowCapture: %s, %s", new Object[] { Boolean.FALSE, Boolean.FALSE });
    int i = j;
    if (!this.YRg.jJk) {
      if (!this.YRg.jJl) {
        break label90;
      }
    }
    label90:
    for (i = j;; i = 0)
    {
      this.YRg.jJk = false;
      this.YRg.jJl = false;
      if (i != 0) {
        this.YRh.aCp();
      }
      AppMethodBeat.o(226553);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(105292);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onDestroy %s", new Object[] { this });
    removeListener();
    this.YRn.clear();
    AppMethodBeat.o(105292);
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(105293);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager remove listener. %s", new Object[] { this });
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().j(this.YRp);
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().h(this.VGb);
    EventCenter.instance.removeListener(this.VGc);
    EventCenter.instance.removeListener(this.YRq);
    com.tencent.mm.emoji.sync.g.aDr().b(this.YRu);
    com.tencent.mm.emoji.sync.g.aDs().b(this.YRu);
    this.YQX = false;
    AppMethodBeat.o(105293);
  }
  
  public final void setShowSend(boolean paramBoolean)
  {
    AppMethodBeat.i(169245);
    this.YRg.ey(paramBoolean);
    AppMethodBeat.o(169245);
  }
  
  public final void setShowStore(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(226555);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setShowStore: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean != this.YRg.jJm) {}
    for (;;)
    {
      this.YRg.jJm = paramBoolean;
      if (i != 0) {
        this.YRh.aCp();
      }
      AppMethodBeat.o(226555);
      return;
      i = 0;
    }
  }
  
  public final void setTabSelected(int paramInt)
  {
    int j = 2;
    AppMethodBeat.i(105295);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setTabSelected: %s, %s", new Object[] { Integer.valueOf(paramInt), this.YQW });
    if (this.YRi == null)
    {
      AppMethodBeat.o(105295);
      return;
    }
    final int i;
    String str;
    Object localObject1;
    if ((paramInt >= 0) && (paramInt < this.YRi.aCq().size()))
    {
      i = this.YRi.rB(paramInt);
      if ((this.YRd != null) && (this.YRe != null))
      {
        this.YRe.setSelection(i);
        this.YRd.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(105283);
            RecyclerView localRecyclerView = a.c(a.this);
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aFh(), "com/tencent/mm/view/manager/SmileyPanelManager$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            localRecyclerView.smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/view/manager/SmileyPanelManager$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            AppMethodBeat.o(105283);
          }
        });
      }
      str = ((EmojiGroupInfo)this.YRi.aCq().get(paramInt)).field_productID;
      this.YQW = str;
      localObject1 = ((com.tencent.mm.emoji.b.b.ad)this.YRi.aCr().get(paramInt)).aCk();
      if (!(localObject1 instanceof an)) {
        break label453;
      }
      if (!((an)localObject1).aCE()) {
        ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aup(str);
      }
      Object localObject2 = com.tencent.mm.emoji.c.d.jNt;
      com.tencent.mm.emoji.c.d.aDc().ju(str);
      localObject2 = com.tencent.mm.emoji.c.d.jNt;
      localObject2 = com.tencent.mm.emoji.c.d.aDc();
      if (!((an)localObject1).jJN) {
        break label448;
      }
      i = 2;
      ((ay)localObject2).glr = i;
      localObject1 = com.tencent.mm.emoji.c.d.jNt;
      com.tencent.mm.emoji.c.d.aDc().glt = (paramInt + 1);
      localObject1 = com.tencent.mm.emoji.c.d.jNt;
      com.tencent.mm.emoji.c.d.rE(1);
      label277:
      com.tencent.mm.emoji.c.h.aDe().jNA = paramInt;
      localObject1 = com.tencent.mm.emoji.c.h.aDe();
      if (!Util.isEqual(str, com.tencent.mm.emoji.b.b.af.aCx())) {
        break label483;
      }
      i = 1;
    }
    for (;;)
    {
      ((com.tencent.mm.emoji.c.h)localObject1).jNz = i;
      com.tencent.mm.emoji.c.h.aDe().jNB = ((com.tencent.mm.emoji.b.b.ad)this.YRi.aCr().get(paramInt)).aCk().getDataCount();
      this.YRj = Util.isEqual(str, com.tencent.mm.emoji.b.b.af.aCw());
      if (this.jLs != null) {
        this.jLs.eE(this.YRj);
      }
      if ((!this.YRj) && (this.YRk != null)) {
        this.YRk.aCp();
      }
      if ((this.isResume) && (Util.isEqual(str, com.tencent.mm.emoji.b.b.af.aCy())) && (this.YRg.jJl)) {
        com.tencent.mm.plugin.report.service.h.IzE.a(15982, new Object[] { Integer.valueOf(0) });
      }
      AppMethodBeat.o(105295);
      return;
      label448:
      i = 1;
      break;
      label453:
      localObject1 = com.tencent.mm.emoji.c.d.jNt;
      com.tencent.mm.emoji.c.d.aDc().ju("");
      localObject1 = com.tencent.mm.emoji.c.d.jNt;
      com.tencent.mm.emoji.c.d.aDc().glt = 0;
      break label277;
      label483:
      i = j;
      if (!Util.isEqual(str, com.tencent.mm.emoji.b.b.af.aCy())) {
        i = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.d.a
 * JD-Core Version:    0.7.0.1
 */