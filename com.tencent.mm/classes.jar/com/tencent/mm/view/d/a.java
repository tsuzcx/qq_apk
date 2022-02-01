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
import com.tencent.mm.emoji.a.a.ac;
import com.tencent.mm.emoji.a.a.af;
import com.tencent.mm.emoji.a.a.ag;
import com.tencent.mm.emoji.a.a.ah;
import com.tencent.mm.emoji.a.a.i;
import com.tencent.mm.emoji.a.a.r;
import com.tencent.mm.emoji.a.a.u;
import com.tencent.mm.emoji.a.a.z;
import com.tencent.mm.emoji.b.b;
import com.tencent.mm.emoji.b.f;
import com.tencent.mm.emoji.panel.a.x.b;
import com.tencent.mm.emoji.panel.layout.EmojiPanelLayoutManager;
import com.tencent.mm.emoji.panel.layout.a.a;
import com.tencent.mm.g.a.dg;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.a.uy;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
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
  private static boolean Iaq = true;
  public final k.a Fzr;
  public final com.tencent.mm.sdk.b.c Fzs;
  public x.b IaA;
  public a.a IaB;
  public com.tencent.mm.sdk.b.c<uy> IaC;
  public String Iah;
  public boolean Iai;
  public RecyclerView Iaj;
  public com.tencent.mm.emoji.panel.a.g Iak;
  public com.tencent.mm.emoji.panel.a.d Ial;
  public View Iam;
  public ImageView Ian;
  public RecyclerView Iao;
  public com.tencent.mm.emoji.panel.a.x Iap;
  public i Iar;
  public final com.tencent.mm.emoji.a.a.j Ias;
  private r Iat;
  public boolean Iau;
  public ag Iav;
  public com.tencent.mm.pluginsdk.ui.chat.j Iaw;
  public com.tencent.mm.emoji.a.a.ab Iax;
  public final k.a Iay;
  public final com.tencent.mm.sdk.b.c<dg> Iaz;
  private final String TAG;
  public Context context;
  public ChatFooterPanel.a fPD;
  public boolean isResume;
  public String sPP;
  public LinearLayoutManager wYJ;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(193437);
    this.TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelManager";
    this.isResume = false;
    this.Iah = null;
    this.Iai = false;
    this.Iau = false;
    this.Iax = new com.tencent.mm.emoji.a.a.ab();
    this.Iay = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(105285);
        if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals("event_update_group")))
        {
          ad.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "modify emoji group .");
          a.i(a.this).abO();
        }
        AppMethodBeat.o(105285);
      }
    };
    this.Fzr = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(105286);
        ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "emoji storage notify %s", new Object[] { paramAnonymousString });
        if (paramAnonymousString == null)
        {
          AppMethodBeat.o(105286);
          return;
        }
        a.i(a.this).abO();
        AppMethodBeat.o(105286);
      }
    };
    this.Fzs = new com.tencent.mm.sdk.b.c() {};
    this.Iaz = new com.tencent.mm.sdk.b.c() {};
    this.IaA = new x.b()
    {
      public final void b(int paramAnonymousInt, View paramAnonymousView)
      {
        AppMethodBeat.i(105290);
        Object localObject1 = a.d(a.this).lH(paramAnonymousInt);
        if (localObject1 == null)
        {
          ad.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab is null. ignore click action.");
          AppMethodBeat.o(105290);
          return;
        }
        if (((ac)localObject1).type == 1)
        {
          a.km(paramAnonymousView.getContext());
          AppMethodBeat.o(105290);
          return;
        }
        if (((ac)localObject1).type == 2)
        {
          a.a(a.this, paramAnonymousView.getContext());
          AppMethodBeat.o(105290);
          return;
        }
        EmojiGroupInfo localEmojiGroupInfo = ((ac)localObject1).fLb;
        Object localObject2 = com.tencent.mm.emoji.b.e.fRj;
        com.tencent.mm.emoji.b.e.z(((ac)localObject1).bwm + 1, localEmojiGroupInfo.field_productID);
        a.this.setTabSelected(((ac)localObject1).bwm);
        localObject2 = a.g(a.this);
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(((ac)localObject1).bwm, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/view/manager/SmileyPanelManager$9", "onItemClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView)localObject2).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/view/manager/SmileyPanelManager$9", "onItemClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        if ((localEmojiGroupInfo.field_productID.equals(z.abU())) && (a.j(a.this).fNK))
        {
          if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).agu()) {
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtC, Boolean.TRUE);
          }
          paramAnonymousView = paramAnonymousView.findViewById(2131304866);
          if (paramAnonymousView != null) {
            paramAnonymousView.setVisibility(8);
          }
        }
        AppMethodBeat.o(105290);
      }
    };
    this.IaB = new a.a()
    {
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(105281);
        a.this.setTabSelected(paramAnonymousInt);
        AppMethodBeat.o(105281);
      }
    };
    this.IaC = new com.tencent.mm.sdk.b.c() {};
    this.context = paramContext;
    if (Iaq)
    {
      Iaq = false;
      Iterator localIterator = com.tencent.mm.emoji.a.h.abj().dj(true).iterator();
      while (localIterator.hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)localIterator.next();
        if (EmojiInfo.a.FBw == localEmojiInfo.fZV())
        {
          localEmojiInfo.a(EmojiInfo.a.FBx);
          localEmojiInfo.a(EmojiInfo.b.FBO);
          ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
          EmojiCaptureReporter.g(localEmojiInfo.field_captureEnterTime, 5, localEmojiInfo.field_captureScene);
        }
        else if (localEmojiInfo.fZV() == EmojiInfo.a.FBy)
        {
          localEmojiInfo.a(EmojiInfo.a.FBz);
          ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
          EmojiCaptureReporter.f(localEmojiInfo.field_captureEnterTime, 3, localEmojiInfo.field_captureScene);
        }
      }
    }
    this.Iar = new i();
    this.Iar.fNL = true;
    this.Iar.fNJ = true;
    this.Iap = new com.tencent.mm.emoji.panel.a.x(this.Iar);
    this.Iak = new com.tencent.mm.emoji.panel.a.g(this.Iar, this.Iax);
    this.wYJ = new EmojiPanelLayoutManager(paramContext);
    this.Iah = com.tencent.mm.emoji.a.h.abj().fMR;
    ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager: select %s", new Object[] { this.Iah });
    this.Ias = new com.tencent.mm.emoji.a.a.j(this.Iar, new u(this.Iak, this.Iap)
    {
      private boolean uEP = true;
      
      public final void a(r paramAnonymousr)
      {
        AppMethodBeat.i(105280);
        a.a(a.this, paramAnonymousr);
        label137:
        Object localObject;
        int i;
        if (a.a(a.this).abQ().size() > 0)
        {
          paramAnonymousr = (com.tencent.mm.emoji.a.a.x)a.a(a.this).abQ().get(0);
          if ((paramAnonymousr instanceof ag))
          {
            a.a(a.this, (ag)paramAnonymousr);
            b.acm().fOF = a.b(a.this).fOG.fOF;
            if ((a.a(a.this).abQ().size() != 1) || (a.b(a.this) == null)) {
              break label502;
            }
            a.c(a.this).setVisibility(8);
          }
        }
        else
        {
          paramAnonymousr = a.d(a.this);
          localObject = a.a(a.this).abR();
          k.h(localObject, "data");
          paramAnonymousr.mData.clear();
          paramAnonymousr.mData.addAll((Collection)localObject);
          ad.i(com.tencent.mm.emoji.panel.a.x.TAG, "update %s, %s", new Object[] { Integer.valueOf(paramAnonymousr.mData.size()), Integer.valueOf(((List)localObject).size()) });
          paramAnonymousr = a.e(a.this);
          localObject = a.a(a.this).abP();
          List localList = a.a(a.this).abQ();
          k.h(localObject, "groups");
          k.h(localList, "models");
          paramAnonymousr.fPT.clear();
          paramAnonymousr.fPT.addAll((Collection)localObject);
          paramAnonymousr.fPU.clear();
          paramAnonymousr.fPU.addAll((Collection)localList);
          if (this.uEP)
          {
            paramAnonymousr = a.f(a.this);
            i = 0;
            label324:
            if (i >= a.a(a.this).abP().size()) {
              break label523;
            }
            if (!bt.kU(((EmojiGroupInfo)a.a(a.this).abP().get(i)).field_productID, paramAnonymousr)) {
              break label516;
            }
          }
        }
        for (;;)
        {
          paramAnonymousr = a.g(a.this);
          localObject = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousr, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/view/manager/SmileyPanelManager$1", "onUpdateData", "(Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;)V", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousr.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousr, "com/tencent/mm/view/manager/SmileyPanelManager$1", "onUpdateData", "(Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;)V", "Undefined", "scrollToPosition", "(I)V");
          a.this.setTabSelected(i);
          ((com.tencent.mm.emoji.a.a.x)a.a(a.this).abQ().get(i)).abO();
          this.uEP = false;
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
    AppMethodBeat.o(193437);
  }
  
  public final void aKb(String paramString)
  {
    AppMethodBeat.i(105296);
    ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setCurrentTab: %s", new Object[] { paramString });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(105296);
      return;
    }
    this.Iah = paramString;
    if (this.Iat == null)
    {
      AppMethodBeat.o(105296);
      return;
    }
    int i = 0;
    while (i < this.Iat.abP().size())
    {
      if (bt.kU(((EmojiGroupInfo)this.Iat.abP().get(i)).field_productID, paramString))
      {
        abm(i);
        AppMethodBeat.o(105296);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(105296);
  }
  
  public final void abm(int paramInt)
  {
    AppMethodBeat.i(105294);
    setTabSelected(paramInt);
    RecyclerView localRecyclerView = this.Iaj;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.adn(), "com/tencent/mm/view/manager/SmileyPanelManager", "setGroupSelected", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.ca(((Integer)locala.lS(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/view/manager/SmileyPanelManager", "setGroupSelected", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(105294);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(105292);
    ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onDestroy %s", new Object[] { this });
    removeListener();
    this.Iax.clear();
    AppMethodBeat.o(105292);
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(105293);
    ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager remove listener. %s", new Object[] { this });
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().j(this.Iay);
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().h(this.Fzr);
    com.tencent.mm.sdk.b.a.ESL.d(this.Fzs);
    com.tencent.mm.sdk.b.a.ESL.d(this.Iaz);
    this.Iai = false;
    AppMethodBeat.o(105293);
  }
  
  public final void setShowSend(boolean paramBoolean)
  {
    AppMethodBeat.i(169245);
    this.Iar.dq(paramBoolean);
    AppMethodBeat.o(169245);
  }
  
  public final void setShowStore(boolean paramBoolean)
  {
    this.Iar.fNM = paramBoolean;
  }
  
  public final void setTabSelected(int paramInt)
  {
    int j = 2;
    AppMethodBeat.i(105295);
    ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setTabSelected: %s, %s", new Object[] { Integer.valueOf(paramInt), this.Iah });
    if (this.Iat == null)
    {
      AppMethodBeat.o(105295);
      return;
    }
    final int i;
    String str;
    Object localObject1;
    if ((paramInt >= 0) && (paramInt < this.Iat.abP().size()))
    {
      i = this.Iat.lD(paramInt);
      if ((this.Iao != null) && (this.Iap != null))
      {
        this.Iap.setSelection(i);
        this.Iao.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(105283);
            RecyclerView localRecyclerView = a.c(a.this);
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.adn(), "com/tencent/mm/view/manager/SmileyPanelManager$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            localRecyclerView.smoothScrollToPosition(((Integer)locala.lS(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/view/manager/SmileyPanelManager$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            AppMethodBeat.o(105283);
          }
        });
      }
      str = ((EmojiGroupInfo)this.Iat.abP().get(paramInt)).field_productID;
      this.Iah = str;
      localObject1 = ((com.tencent.mm.emoji.a.a.x)this.Iat.abQ().get(paramInt)).abJ();
      if (!(localObject1 instanceof ah)) {
        break label422;
      }
      Object localObject2 = com.tencent.mm.emoji.b.c.fRg;
      com.tencent.mm.emoji.b.c.acn().fX(str);
      localObject2 = com.tencent.mm.emoji.b.c.fRg;
      localObject2 = com.tencent.mm.emoji.b.c.acn();
      if (!((ah)localObject1).fOi) {
        break label417;
      }
      i = 2;
      ((com.tencent.mm.g.b.a.s)localObject2).dJq = i;
      localObject1 = com.tencent.mm.emoji.b.c.fRg;
      com.tencent.mm.emoji.b.c.acn().dJs = (paramInt + 1);
      localObject1 = com.tencent.mm.emoji.b.c.fRg;
      com.tencent.mm.emoji.b.c.lI(1);
      label246:
      f.acp().fRm = paramInt;
      localObject1 = f.acp();
      if (!bt.kU(str, z.abT())) {
        break label452;
      }
      i = 1;
    }
    for (;;)
    {
      ((f)localObject1).fRl = i;
      f.acp().fRn = ((com.tencent.mm.emoji.a.a.x)this.Iat.abQ().get(paramInt)).abJ().abI();
      this.Iau = bt.kU(str, z.abS());
      if (this.fPD != null) {
        this.fPD.lf(this.Iau);
      }
      if ((!this.Iau) && (this.Iav != null)) {
        this.Iav.abO();
      }
      if ((this.isResume) && (bt.kU(str, z.abU())) && (this.Iar.fNL)) {
        com.tencent.mm.plugin.report.service.h.vKh.f(15982, new Object[] { Integer.valueOf(0) });
      }
      AppMethodBeat.o(105295);
      return;
      label417:
      i = 1;
      break;
      label422:
      localObject1 = com.tencent.mm.emoji.b.c.fRg;
      com.tencent.mm.emoji.b.c.acn().fX("");
      localObject1 = com.tencent.mm.emoji.b.c.fRg;
      com.tencent.mm.emoji.b.c.acn().dJs = 0;
      break label246;
      label452:
      i = j;
      if (!bt.kU(str, z.abU())) {
        i = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.d.a
 * JD-Core Version:    0.7.0.1
 */