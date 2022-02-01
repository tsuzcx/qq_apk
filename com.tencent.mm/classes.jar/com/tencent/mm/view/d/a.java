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
import com.tencent.mm.emoji.a.a.ab;
import com.tencent.mm.emoji.a.a.af;
import com.tencent.mm.emoji.a.a.ag;
import com.tencent.mm.emoji.a.a.ah;
import com.tencent.mm.emoji.a.a.r;
import com.tencent.mm.emoji.a.a.s;
import com.tencent.mm.emoji.a.a.z;
import com.tencent.mm.emoji.b.b;
import com.tencent.mm.emoji.b.f;
import com.tencent.mm.emoji.panel.a.x.b;
import com.tencent.mm.emoji.panel.layout.EmojiPanelLayoutManager;
import com.tencent.mm.emoji.panel.layout.a.a;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.vi;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static boolean JBg = true;
  public final k.a GYt;
  public final com.tencent.mm.sdk.b.c GYu;
  public String JAX;
  public boolean JAY;
  public RecyclerView JAZ;
  public com.tencent.mm.emoji.panel.a.g JBa;
  public com.tencent.mm.emoji.panel.a.d JBb;
  public View JBc;
  public ImageView JBd;
  public RecyclerView JBe;
  public com.tencent.mm.emoji.panel.a.x JBf;
  public com.tencent.mm.emoji.a.a.i JBh;
  public final com.tencent.mm.emoji.a.a.j JBi;
  private r JBj;
  public boolean JBk;
  public ag JBl;
  public com.tencent.mm.pluginsdk.ui.chat.j JBm;
  public ab JBn;
  public final k.a JBo;
  public final com.tencent.mm.sdk.b.c<dh> JBp;
  public x.b JBq;
  public a.a JBr;
  public com.tencent.mm.sdk.b.c<vi> JBs;
  private final String TAG;
  public Context context;
  public ChatFooterPanel.a fTy;
  public boolean isResume;
  public String tYc;
  public LinearLayoutManager ylx;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(209806);
    this.TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelManager";
    this.isResume = false;
    this.JAX = null;
    this.JAY = false;
    this.JBk = false;
    this.JBn = new ab();
    this.JBo = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(105285);
        if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals("event_update_group")))
        {
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "modify emoji group .");
          a.i(a.this).acO();
        }
        AppMethodBeat.o(105285);
      }
    };
    this.GYt = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(105286);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "emoji storage notify %s", new Object[] { paramAnonymousString });
        if (paramAnonymousString == null)
        {
          AppMethodBeat.o(105286);
          return;
        }
        a.i(a.this).acO();
        AppMethodBeat.o(105286);
      }
    };
    this.GYu = new com.tencent.mm.sdk.b.c() {};
    this.JBp = new com.tencent.mm.sdk.b.c() {};
    this.JBq = new x.b()
    {
      public final void b(int paramAnonymousInt, View paramAnonymousView)
      {
        AppMethodBeat.i(105290);
        Object localObject1 = a.d(a.this).lE(paramAnonymousInt);
        if (localObject1 == null)
        {
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab is null. ignore click action.");
          AppMethodBeat.o(105290);
          return;
        }
        if (((com.tencent.mm.emoji.a.a.ac)localObject1).type == 1)
        {
          a.ky(paramAnonymousView.getContext());
          AppMethodBeat.o(105290);
          return;
        }
        if (((com.tencent.mm.emoji.a.a.ac)localObject1).type == 2)
        {
          a.a(a.this, paramAnonymousView.getContext());
          AppMethodBeat.o(105290);
          return;
        }
        EmojiGroupInfo localEmojiGroupInfo = ((com.tencent.mm.emoji.a.a.ac)localObject1).fON;
        Object localObject2 = com.tencent.mm.emoji.b.e.fVe;
        com.tencent.mm.emoji.b.e.z(((com.tencent.mm.emoji.a.a.ac)localObject1).bul + 1, localEmojiGroupInfo.field_productID);
        a.this.setTabSelected(((com.tencent.mm.emoji.a.a.ac)localObject1).bul);
        localObject2 = a.g(a.this);
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(((com.tencent.mm.emoji.a.a.ac)localObject1).bul, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/view/manager/SmileyPanelManager$9", "onItemClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView)localObject2).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/view/manager/SmileyPanelManager$9", "onItemClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        if ((localEmojiGroupInfo.field_productID.equals(z.acU())) && (a.j(a.this).fRv))
        {
          if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ahL()) {
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRw, Boolean.TRUE);
          }
          paramAnonymousView = paramAnonymousView.findViewById(2131304866);
          if (paramAnonymousView != null) {
            paramAnonymousView.setVisibility(8);
          }
        }
        AppMethodBeat.o(105290);
      }
    };
    this.JBr = new a.a()
    {
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(105281);
        a.this.setTabSelected(paramAnonymousInt);
        AppMethodBeat.o(105281);
      }
    };
    this.JBs = new com.tencent.mm.sdk.b.c() {};
    this.context = paramContext;
    if (JBg)
    {
      JBg = false;
      Iterator localIterator = com.tencent.mm.emoji.a.i.ach().di(true).iterator();
      while (localIterator.hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)localIterator.next();
        if (EmojiInfo.a.Haw == localEmojiInfo.fFY())
        {
          localEmojiInfo.a(EmojiInfo.a.Hax);
          localEmojiInfo.a(EmojiInfo.b.HaO);
          ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
          EmojiCaptureReporter.g(localEmojiInfo.field_captureEnterTime, 5, localEmojiInfo.field_captureScene);
        }
        else if (localEmojiInfo.fFY() == EmojiInfo.a.Hay)
        {
          localEmojiInfo.a(EmojiInfo.a.Haz);
          ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
          EmojiCaptureReporter.f(localEmojiInfo.field_captureEnterTime, 3, localEmojiInfo.field_captureScene);
        }
      }
    }
    this.JBh = new com.tencent.mm.emoji.a.a.i();
    this.JBh.fRw = true;
    this.JBh.fRu = true;
    this.JBf = new com.tencent.mm.emoji.panel.a.x(this.JBh);
    this.JBa = new com.tencent.mm.emoji.panel.a.g(this.JBh, this.JBn);
    this.ylx = new EmojiPanelLayoutManager(paramContext);
    this.JAX = com.tencent.mm.emoji.a.i.ach().fQD;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager: select %s", new Object[] { this.JAX });
    this.JBi = new com.tencent.mm.emoji.a.a.j(this.JBh, new com.tencent.mm.emoji.a.a.u(this.JBa, this.JBf)
    {
      private boolean vNG = true;
      
      public final void a(r paramAnonymousr)
      {
        AppMethodBeat.i(105280);
        a.a(a.this, paramAnonymousr);
        label137:
        Object localObject;
        int i;
        if (a.a(a.this).acQ().size() > 0)
        {
          paramAnonymousr = (com.tencent.mm.emoji.a.a.x)a.a(a.this).acQ().get(0);
          if ((paramAnonymousr instanceof ag))
          {
            a.a(a.this, (ag)paramAnonymousr);
            b.ads().fSq = a.b(a.this).fSr.fSq;
            if ((a.a(a.this).acQ().size() != 1) || (a.b(a.this) == null)) {
              break label502;
            }
            a.c(a.this).setVisibility(8);
          }
        }
        else
        {
          paramAnonymousr = a.d(a.this);
          localObject = a.a(a.this).acR();
          k.h(localObject, "data");
          paramAnonymousr.mData.clear();
          paramAnonymousr.mData.addAll((Collection)localObject);
          com.tencent.mm.sdk.platformtools.ac.i(com.tencent.mm.emoji.panel.a.x.TAG, "update %s, %s", new Object[] { Integer.valueOf(paramAnonymousr.mData.size()), Integer.valueOf(((List)localObject).size()) });
          paramAnonymousr = a.e(a.this);
          localObject = a.a(a.this).acP();
          List localList = a.a(a.this).acQ();
          k.h(localObject, "groups");
          k.h(localList, "models");
          paramAnonymousr.fTO.clear();
          paramAnonymousr.fTO.addAll((Collection)localObject);
          paramAnonymousr.fTP.clear();
          paramAnonymousr.fTP.addAll((Collection)localList);
          if (this.vNG)
          {
            paramAnonymousr = a.f(a.this);
            i = 0;
            label324:
            if (i >= a.a(a.this).acP().size()) {
              break label523;
            }
            if (!bs.lr(((EmojiGroupInfo)a.a(a.this).acP().get(i)).field_productID, paramAnonymousr)) {
              break label516;
            }
          }
        }
        for (;;)
        {
          paramAnonymousr = a.g(a.this);
          localObject = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousr, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/view/manager/SmileyPanelManager$1", "onUpdateData", "(Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;)V", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousr.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousr, "com/tencent/mm/view/manager/SmileyPanelManager$1", "onUpdateData", "(Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;)V", "Undefined", "scrollToPosition", "(I)V");
          a.this.setTabSelected(i);
          ((com.tencent.mm.emoji.a.a.x)a.a(a.this).acQ().get(i)).acO();
          this.vNG = false;
          AppMethodBeat.o(105280);
          return;
          a.a(a.this, null);
          break;
          label502:
          a.c(a.this).setVisibility(0);
          break label137;
          label516:
          i += 1;
          break label324;
          label523:
          i = 0;
        }
      }
    });
    AppMethodBeat.o(209806);
  }
  
  public final void aPD(String paramString)
  {
    AppMethodBeat.i(105296);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setCurrentTab: %s", new Object[] { paramString });
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(105296);
      return;
    }
    this.JAX = paramString;
    if (this.JBj == null)
    {
      AppMethodBeat.o(105296);
      return;
    }
    int i = 0;
    while (i < this.JBj.acP().size())
    {
      if (bs.lr(((EmojiGroupInfo)this.JBj.acP().get(i)).field_productID, paramString))
      {
        adE(i);
        AppMethodBeat.o(105296);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(105296);
  }
  
  public final void adE(int paramInt)
  {
    AppMethodBeat.i(105294);
    setTabSelected(paramInt);
    RecyclerView localRecyclerView = this.JAZ;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.aeD(), "com/tencent/mm/view/manager/SmileyPanelManager", "setGroupSelected", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.ca(((Integer)locala.lR(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/view/manager/SmileyPanelManager", "setGroupSelected", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(105294);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(105292);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onDestroy %s", new Object[] { this });
    removeListener();
    this.JBn.clear();
    AppMethodBeat.o(105292);
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(105293);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager remove listener. %s", new Object[] { this });
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().j(this.JBo);
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().h(this.GYt);
    com.tencent.mm.sdk.b.a.GpY.d(this.GYu);
    com.tencent.mm.sdk.b.a.GpY.d(this.JBp);
    this.JAY = false;
    AppMethodBeat.o(105293);
  }
  
  public final void setShowSend(boolean paramBoolean)
  {
    AppMethodBeat.i(169245);
    this.JBh.dp(paramBoolean);
    AppMethodBeat.o(169245);
  }
  
  public final void setShowStore(boolean paramBoolean)
  {
    this.JBh.fRx = paramBoolean;
  }
  
  public final void setTabSelected(int paramInt)
  {
    int j = 2;
    AppMethodBeat.i(105295);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setTabSelected: %s, %s", new Object[] { Integer.valueOf(paramInt), this.JAX });
    if (this.JBj == null)
    {
      AppMethodBeat.o(105295);
      return;
    }
    final int i;
    String str;
    Object localObject1;
    if ((paramInt >= 0) && (paramInt < this.JBj.acP().size()))
    {
      i = this.JBj.lz(paramInt);
      if ((this.JBe != null) && (this.JBf != null))
      {
        this.JBf.setSelection(i);
        this.JBe.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(105283);
            RecyclerView localRecyclerView = a.c(a.this);
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.aeD(), "com/tencent/mm/view/manager/SmileyPanelManager$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            localRecyclerView.smoothScrollToPosition(((Integer)locala.lR(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/view/manager/SmileyPanelManager$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            AppMethodBeat.o(105283);
          }
        });
      }
      str = ((EmojiGroupInfo)this.JBj.acP().get(paramInt)).field_productID;
      this.JAX = str;
      localObject1 = ((com.tencent.mm.emoji.a.a.x)this.JBj.acQ().get(paramInt)).acJ();
      if (!(localObject1 instanceof ah)) {
        break label422;
      }
      Object localObject2 = com.tencent.mm.emoji.b.c.fVb;
      com.tencent.mm.emoji.b.c.adt().fO(str);
      localObject2 = com.tencent.mm.emoji.b.c.fVb;
      localObject2 = com.tencent.mm.emoji.b.c.adt();
      if (!((ah)localObject1).fRT) {
        break label417;
      }
      i = 2;
      ((com.tencent.mm.g.b.a.u)localObject2).dHs = i;
      localObject1 = com.tencent.mm.emoji.b.c.fVb;
      com.tencent.mm.emoji.b.c.adt().dHu = (paramInt + 1);
      localObject1 = com.tencent.mm.emoji.b.c.fVb;
      com.tencent.mm.emoji.b.c.lA(1);
      label246:
      f.adv().fVh = paramInt;
      localObject1 = f.adv();
      if (!bs.lr(str, z.acT())) {
        break label452;
      }
      i = 1;
    }
    for (;;)
    {
      ((f)localObject1).fVg = i;
      f.adv().fVi = ((com.tencent.mm.emoji.a.a.x)this.JBj.acQ().get(paramInt)).acJ().acI();
      this.JBk = bs.lr(str, z.acS());
      if (this.fTy != null) {
        this.fTy.dS(this.JBk);
      }
      if ((!this.JBk) && (this.JBl != null)) {
        this.JBl.acO();
      }
      if ((this.isResume) && (bs.lr(str, z.acU())) && (this.JBh.fRw)) {
        com.tencent.mm.plugin.report.service.h.wUl.f(15982, new Object[] { Integer.valueOf(0) });
      }
      AppMethodBeat.o(105295);
      return;
      label417:
      i = 1;
      break;
      label422:
      localObject1 = com.tencent.mm.emoji.b.c.fVb;
      com.tencent.mm.emoji.b.c.adt().fO("");
      localObject1 = com.tencent.mm.emoji.b.c.fVb;
      com.tencent.mm.emoji.b.c.adt().dHu = 0;
      break label246;
      label452:
      i = j;
      if (!bs.lr(str, z.acU())) {
        i = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.d.a
 * JD-Core Version:    0.7.0.1
 */