package com.tencent.mm.view.d;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.ab;
import com.tencent.mm.emoji.a.a.af;
import com.tencent.mm.emoji.a.a.ag;
import com.tencent.mm.emoji.a.a.aj;
import com.tencent.mm.emoji.a.a.ak;
import com.tencent.mm.emoji.a.a.al;
import com.tencent.mm.emoji.a.a.v;
import com.tencent.mm.emoji.a.a.w;
import com.tencent.mm.emoji.a.a.y;
import com.tencent.mm.emoji.b.b;
import com.tencent.mm.emoji.b.f;
import com.tencent.mm.emoji.panel.a.x.b;
import com.tencent.mm.emoji.panel.layout.EmojiPanelLayoutManager;
import com.tencent.mm.emoji.panel.layout.a.a;
import com.tencent.mm.g.a.dk;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.g.a.wb;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  private static boolean Lun = true;
  public final k.a ILH;
  public final com.tencent.mm.sdk.b.c ILI;
  public String Lue;
  public boolean Luf;
  public RecyclerView Lug;
  public com.tencent.mm.emoji.panel.a.g Luh;
  public com.tencent.mm.emoji.panel.a.d Lui;
  public View Luj;
  public ImageView Luk;
  public RecyclerView Lul;
  public com.tencent.mm.emoji.panel.a.x Lum;
  public com.tencent.mm.emoji.a.a.i Luo;
  public final com.tencent.mm.emoji.a.a.j Lup;
  private v Luq;
  public boolean Lur;
  public ak Lus;
  public com.tencent.mm.pluginsdk.ui.chat.j Lut;
  public af Luu;
  public final k.a Luv;
  public final com.tencent.mm.sdk.b.c<dk> Luw;
  public x.b Lux;
  public a.a Luy;
  public com.tencent.mm.sdk.b.c<wb> Luz;
  private final String TAG;
  public Context context;
  public ChatFooterPanel.a gnc;
  public boolean isResume;
  public String vaL;
  public LinearLayoutManager zCm;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(219049);
    this.TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelManager";
    this.isResume = false;
    this.Lue = null;
    this.Luf = false;
    this.Lur = false;
    this.Luu = new af();
    this.Luv = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(105285);
        if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals("event_update_group")))
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "modify emoji group .");
          a.i(a.this).afs();
        }
        AppMethodBeat.o(105285);
      }
    };
    this.ILH = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(105286);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "emoji storage notify %s", new Object[] { paramAnonymousString });
        if (paramAnonymousString == null)
        {
          AppMethodBeat.o(105286);
          return;
        }
        a.i(a.this).afs();
        AppMethodBeat.o(105286);
      }
    };
    this.ILI = new com.tencent.mm.sdk.b.c() {};
    this.Luw = new com.tencent.mm.sdk.b.c() {};
    this.Lux = new x.b()
    {
      public final void b(int paramAnonymousInt, View paramAnonymousView)
      {
        AppMethodBeat.i(105290);
        Object localObject1 = a.d(a.this).me(paramAnonymousInt);
        if (localObject1 == null)
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab is null. ignore click action.");
          AppMethodBeat.o(105290);
          return;
        }
        if (((ag)localObject1).type == 1)
        {
          a.kK(paramAnonymousView.getContext());
          AppMethodBeat.o(105290);
          return;
        }
        if (((ag)localObject1).type == 2)
        {
          a.a(a.this, paramAnonymousView.getContext());
          AppMethodBeat.o(105290);
          return;
        }
        EmojiGroupInfo localEmojiGroupInfo = ((ag)localObject1).gin;
        Object localObject2 = com.tencent.mm.emoji.b.e.goH;
        com.tencent.mm.emoji.b.e.z(((ag)localObject1).bEA + 1, localEmojiGroupInfo.field_productID);
        a.this.setTabSelected(((ag)localObject1).bEA);
        localObject2 = a.g(a.this);
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(((ag)localObject1).bEA, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/view/manager/SmileyPanelManager$9", "onItemClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView)localObject2).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/view/manager/SmileyPanelManager$9", "onItemClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        if ((localEmojiGroupInfo.field_productID.equals(com.tencent.mm.emoji.a.a.ad.afB())) && (a.j(a.this).gkV))
        {
          if (((h)com.tencent.mm.kernel.g.ajz().ajb()).akw()) {
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IEa, Boolean.TRUE);
          }
          paramAnonymousView = paramAnonymousView.findViewById(2131304866);
          if (paramAnonymousView != null) {
            paramAnonymousView.setVisibility(8);
          }
        }
        AppMethodBeat.o(105290);
      }
    };
    this.Luy = new a.a()
    {
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(105281);
        a.this.setTabSelected(paramAnonymousInt);
        AppMethodBeat.o(105281);
      }
    };
    this.Luz = new com.tencent.mm.sdk.b.c() {};
    this.context = paramContext;
    if (Lun)
    {
      Lun = false;
      Iterator localIterator = com.tencent.mm.emoji.a.i.aeL().dk(true).iterator();
      while (localIterator.hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)localIterator.next();
        if (EmojiInfo.a.INL == localEmojiInfo.gzL())
        {
          localEmojiInfo.a(EmojiInfo.a.INM);
          localEmojiInfo.a(EmojiInfo.b.IOe);
          ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
          EmojiCaptureReporter.g(localEmojiInfo.field_captureEnterTime, 5, localEmojiInfo.field_captureScene);
        }
        else if (localEmojiInfo.gzL() == EmojiInfo.a.INN)
        {
          localEmojiInfo.a(EmojiInfo.a.INO);
          ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
          EmojiCaptureReporter.f(localEmojiInfo.field_captureEnterTime, 3, localEmojiInfo.field_captureScene);
        }
      }
    }
    this.Luo = new com.tencent.mm.emoji.a.a.i();
    this.Luo.gkW = true;
    this.Luo.gkU = true;
    this.Lum = new com.tencent.mm.emoji.panel.a.x(this.Luo);
    this.Luh = new com.tencent.mm.emoji.panel.a.g(this.Luo, this.Luu);
    this.zCm = new EmojiPanelLayoutManager(paramContext);
    this.Lue = com.tencent.mm.emoji.a.i.aeL().gkd;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager: select %s", new Object[] { this.Lue });
    this.Lup = new com.tencent.mm.emoji.a.a.j(this.Luo, new y(this.Luh, this.Lum)
    {
      private boolean wUP = true;
      
      public final void a(v paramAnonymousv)
      {
        AppMethodBeat.i(105280);
        a.a(a.this, paramAnonymousv);
        label137:
        Object localObject;
        int i;
        if (a.a(a.this).afu().size() > 0)
        {
          paramAnonymousv = (ab)a.a(a.this).afu().get(0);
          if ((paramAnonymousv instanceof ak))
          {
            a.a(a.this, (ak)paramAnonymousv);
            b.afY().glU = a.b(a.this).glV.glU;
            if ((a.a(a.this).afu().size() != 1) || (a.b(a.this) == null)) {
              break label523;
            }
            a.c(a.this).setVisibility(8);
          }
        }
        else
        {
          paramAnonymousv = a.d(a.this);
          localObject = a.a(a.this).afv();
          p.h(localObject, "data");
          paramAnonymousv.mData.clear();
          paramAnonymousv.mData.addAll((Collection)localObject);
          com.tencent.mm.sdk.platformtools.ad.i(com.tencent.mm.emoji.panel.a.x.TAG, "update %s, %s", new Object[] { Integer.valueOf(paramAnonymousv.mData.size()), Integer.valueOf(((List)localObject).size()) });
          paramAnonymousv = a.e(a.this);
          localObject = a.a(a.this).aft();
          List localList = a.a(a.this).afu();
          p.h(localObject, "groups");
          p.h(localList, "models");
          paramAnonymousv.gns.clear();
          paramAnonymousv.gns.addAll((Collection)localObject);
          paramAnonymousv.gnt.clear();
          paramAnonymousv.gnt.addAll((Collection)localList);
          if (this.wUP)
          {
            paramAnonymousv = a.f(a.this);
            i = 0;
            label324:
            if (i >= a.a(a.this).aft().size()) {
              break label544;
            }
            if (!bt.lQ(((EmojiGroupInfo)a.a(a.this).aft().get(i)).field_productID, paramAnonymousv)) {
              break label537;
            }
          }
        }
        for (;;)
        {
          paramAnonymousv = a.g(a.this);
          localObject = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousv, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/view/manager/SmileyPanelManager$1", "onUpdateData", "(Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;)V", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousv.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousv, "com/tencent/mm/view/manager/SmileyPanelManager$1", "onUpdateData", "(Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;)V", "Undefined", "scrollToPosition", "(I)V");
          a.this.setTabSelected(i);
          if (i < a.a(a.this).afu().size())
          {
            ((ab)a.a(a.this).afu().get(i)).afs();
            this.wUP = false;
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
    AppMethodBeat.o(219049);
  }
  
  public final void aVt(String paramString)
  {
    AppMethodBeat.i(105296);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setCurrentTab: %s", new Object[] { paramString });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(105296);
      return;
    }
    this.Lue = paramString;
    if (this.Luq == null)
    {
      AppMethodBeat.o(105296);
      return;
    }
    int i = 0;
    while (i < this.Luq.aft().size())
    {
      if (bt.lQ(((EmojiGroupInfo)this.Luq.aft().get(i)).field_productID, paramString))
      {
        age(i);
        AppMethodBeat.o(105296);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(105296);
  }
  
  public final void age(int paramInt)
  {
    AppMethodBeat.i(105294);
    setTabSelected(paramInt);
    RecyclerView localRecyclerView = this.Lug;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahp(), "com/tencent/mm/view/manager/SmileyPanelManager", "setGroupSelected", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.ca(((Integer)locala.mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/view/manager/SmileyPanelManager", "setGroupSelected", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(105294);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(105292);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onDestroy %s", new Object[] { this });
    removeListener();
    this.Luu.clear();
    AppMethodBeat.o(105292);
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(105293);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager remove listener. %s", new Object[] { this });
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().j(this.Luv);
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().h(this.ILH);
    com.tencent.mm.sdk.b.a.IbL.d(this.ILI);
    com.tencent.mm.sdk.b.a.IbL.d(this.Luw);
    this.Luf = false;
    AppMethodBeat.o(105293);
  }
  
  public final void setShowSend(boolean paramBoolean)
  {
    AppMethodBeat.i(169245);
    this.Luo.dr(paramBoolean);
    AppMethodBeat.o(169245);
  }
  
  public final void setShowStore(boolean paramBoolean)
  {
    AppMethodBeat.i(219050);
    if (paramBoolean != this.Luo.gkX) {}
    for (int i = 1;; i = 0)
    {
      this.Luo.gkX = paramBoolean;
      if (i != 0) {
        this.Lup.afs();
      }
      AppMethodBeat.o(219050);
      return;
    }
  }
  
  public final void setTabSelected(int paramInt)
  {
    int j = 2;
    AppMethodBeat.i(105295);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setTabSelected: %s, %s", new Object[] { Integer.valueOf(paramInt), this.Lue });
    if (this.Luq == null)
    {
      AppMethodBeat.o(105295);
      return;
    }
    final int i;
    String str;
    Object localObject1;
    if ((paramInt >= 0) && (paramInt < this.Luq.aft().size()))
    {
      i = this.Luq.lY(paramInt);
      if ((this.Lul != null) && (this.Lum != null))
      {
        this.Lum.setSelection(i);
        this.Lul.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(105283);
            RecyclerView localRecyclerView = a.c(a.this);
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahp(), "com/tencent/mm/view/manager/SmileyPanelManager$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            localRecyclerView.smoothScrollToPosition(((Integer)locala.mq(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/view/manager/SmileyPanelManager$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            AppMethodBeat.o(105283);
          }
        });
      }
      str = ((EmojiGroupInfo)this.Luq.aft().get(paramInt)).field_productID;
      this.Lue = str;
      localObject1 = ((ab)this.Luq.afu().get(paramInt)).afn();
      if (!(localObject1 instanceof al)) {
        break label422;
      }
      Object localObject2 = com.tencent.mm.emoji.b.c.goE;
      com.tencent.mm.emoji.b.c.afZ().gQ(str);
      localObject2 = com.tencent.mm.emoji.b.c.goE;
      localObject2 = com.tencent.mm.emoji.b.c.afZ();
      if (!((al)localObject1).glx) {
        break label417;
      }
      i = 2;
      ((com.tencent.mm.g.b.a.x)localObject2).dUw = i;
      localObject1 = com.tencent.mm.emoji.b.c.goE;
      com.tencent.mm.emoji.b.c.afZ().dUy = (paramInt + 1);
      localObject1 = com.tencent.mm.emoji.b.c.goE;
      com.tencent.mm.emoji.b.c.ma(1);
      label246:
      f.agb().goK = paramInt;
      localObject1 = f.agb();
      if (!bt.lQ(str, com.tencent.mm.emoji.a.a.ad.afA())) {
        break label452;
      }
      i = 1;
    }
    for (;;)
    {
      ((f)localObject1).goJ = i;
      f.agb().goL = ((ab)this.Luq.afu().get(paramInt)).afn().afm();
      this.Lur = bt.lQ(str, com.tencent.mm.emoji.a.a.ad.afz());
      if (this.gnc != null) {
        this.gnc.dU(this.Lur);
      }
      if ((!this.Lur) && (this.Lus != null)) {
        this.Lus.afs();
      }
      if ((this.isResume) && (bt.lQ(str, com.tencent.mm.emoji.a.a.ad.afB())) && (this.Luo.gkW)) {
        com.tencent.mm.plugin.report.service.g.yhR.f(15982, new Object[] { Integer.valueOf(0) });
      }
      AppMethodBeat.o(105295);
      return;
      label417:
      i = 1;
      break;
      label422:
      localObject1 = com.tencent.mm.emoji.b.c.goE;
      com.tencent.mm.emoji.b.c.afZ().gQ("");
      localObject1 = com.tencent.mm.emoji.b.c.goE;
      com.tencent.mm.emoji.b.c.afZ().dUy = 0;
      break label246;
      label452:
      i = j;
      if (!bt.lQ(str, com.tencent.mm.emoji.a.a.ad.afB())) {
        i = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.d.a
 * JD-Core Version:    0.7.0.1
 */