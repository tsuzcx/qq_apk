package com.tencent.mm.view;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.cb.a.b;
import com.tencent.mm.emoji.a.a.af;
import com.tencent.mm.emoji.a.a.ak;
import com.tencent.mm.emoji.a.a.n;
import com.tencent.mm.emoji.b.b;
import com.tencent.mm.emoji.panel.a.o;
import com.tencent.mm.emoji.panel.a.v;
import com.tencent.mm.emoji.panel.a.x.b;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.view.d.a.6;
import d.g.b.p;
import java.util.Iterator;
import java.util.LinkedList;

public class SmileyPanelImpl
  extends SmileyPanel
  implements LifecycleObserver
{
  private final com.tencent.mm.view.d.a LrJ;
  private boolean LrK;
  private final String TAG;
  private boolean aMv;
  
  public SmileyPanelImpl(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean) {}
  
  public SmileyPanelImpl(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, paramBoolean);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(219046);
    com.tencent.mm.view.d.a locala = this.LrJ;
    com.tencent.mm.emoji.a.a.j localj = locala.Lup;
    p.h(paramn, "externalPanelProvider");
    localj.glf.add(paramn);
    locala.Lup.afs();
    AppMethodBeat.o(219046);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105191);
    if (this.aMv)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "destroy: has destroyed");
      AppMethodBeat.o(105191);
      return;
    }
    this.aMv = true;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "destroy: ");
    this.ESm = null;
    this.LrJ.Luz.dead();
    this.LrJ.onDestroy();
    ((d)com.tencent.mm.kernel.g.ad(d.class)).getProvider().cgD();
    ((d)com.tencent.mm.kernel.g.ad(d.class)).getProvider().onDestroy();
    AppMethodBeat.o(105191);
  }
  
  public final void fbE()
  {
    this.ESm = null;
  }
  
  public final void fbF()
  {
    int j = 1;
    AppMethodBeat.i(105200);
    com.tencent.mm.view.d.a locala = this.LrJ;
    if ((locala.Luo.gkS) || (locala.Luo.gkU))
    {
      i = 1;
      locala.Luo.gkS = false;
      locala.Luo.gkU = false;
      if (i != 0) {
        locala.Lup.afs();
      }
      locala = this.LrJ;
      i = j;
      if (!locala.Luo.gkV) {
        if (!locala.Luo.gkW) {
          break label138;
        }
      }
    }
    label138:
    for (int i = j;; i = 0)
    {
      locala.Luo.gkV = false;
      locala.Luo.gkW = false;
      if (i != 0) {
        locala.Lup.afs();
      }
      this.LrJ.setShowStore(false);
      AppMethodBeat.o(105200);
      return;
      i = 0;
      break;
    }
  }
  
  public final void fbG()
  {
    AppMethodBeat.i(105201);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSmiley: %B, hideEmojiSmiley: %B", new Object[] { Boolean.FALSE, Boolean.FALSE });
    AppMethodBeat.o(105201);
  }
  
  public final void fbH()
  {
    AppMethodBeat.i(169244);
    this.LrJ.setShowSend(false);
    AppMethodBeat.o(169244);
  }
  
  public final void fbI()
  {
    AppMethodBeat.i(105189);
    this.LrJ.age(0);
    AppMethodBeat.o(105189);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityDestroy()
  {
    AppMethodBeat.i(105187);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onActivityDestroy:%s", new Object[] { getContext() });
    destroy();
    AppMethodBeat.o(105187);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(105192);
    super.onAttachedToWindow();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onAttachedToWindow");
    com.tencent.mm.view.d.a locala = this.LrJ;
    if (locala.Luf)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "listener added %s", new Object[] { locala });
      AppMethodBeat.o(105192);
      return;
    }
    locala.Luf = true;
    ((d)com.tencent.mm.kernel.g.ad(d.class)).getProvider().k(locala.Luv);
    ((d)com.tencent.mm.kernel.g.ad(d.class)).getProvider().i(locala.ILH);
    com.tencent.mm.sdk.b.a.IbL.c(locala.ILI);
    com.tencent.mm.sdk.b.a.IbL.c(locala.Luw);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager add listener. %s", new Object[] { locala });
    AppMethodBeat.o(105192);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(105193);
    super.onDetachedFromWindow();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onDetachedFromWindow");
    this.LrJ.removeListener();
    AppMethodBeat.o(105193);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(105190);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onPause");
    ((d)com.tencent.mm.kernel.g.ad(d.class)).getProvider().cgD();
    Object localObject = this.LrJ;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "saveSelectedTab: %s", new Object[] { ((com.tencent.mm.view.d.a)localObject).Lue });
    com.tencent.mm.emoji.a.i locali = com.tencent.mm.emoji.a.i.aeL();
    locali.gkd = ((com.tencent.mm.view.d.a)localObject).Lue;
    if (aj.cmR())
    {
      com.tencent.mm.kernel.g.ajC().ajl().set(-29414086, locali.gkd);
      AppMethodBeat.o(105190);
      return;
    }
    com.tencent.mm.cb.a.fhy();
    localObject = com.tencent.mm.cb.a.HVh;
    a.b.aPD(locali.gkd);
    AppMethodBeat.o(105190);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(105188);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onResume");
    if (!this.LrK)
    {
      this.LrK = true;
      com.tencent.mm.view.d.a locala = this.LrJ;
      locala.Lup.afs();
      locala.Luo.afr();
    }
    AppMethodBeat.o(105188);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105203);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onSizeChanged: %s, %s; %s, %s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    com.tencent.mm.view.d.a locala;
    ViewGroup.LayoutParams localLayoutParams;
    if (this.LrJ != null)
    {
      locala = this.LrJ;
      v.gof.mc(paramInt1);
      com.tencent.mm.emoji.panel.a.j.gnL.mc(paramInt1);
      paramInt3 = locala.context.getResources().getDimensionPixelSize(2131166251);
      localLayoutParams = locala.Lul.getLayoutParams();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "updateViewSize: %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (paramInt2 >= paramInt3 * 4) {
        break label225;
      }
    }
    label225:
    for (paramInt1 = paramInt3;; paramInt1 = locala.context.getResources().getDimensionPixelSize(2131166250))
    {
      if (localLayoutParams.height != paramInt1)
      {
        localLayoutParams.height = paramInt1;
        locala.Lul.setLayoutParams(localLayoutParams);
        locala.Lul.post(new a.6(locala));
      }
      b.afY().goC = v.gof.atv;
      com.tencent.mm.emoji.b.f.agb().goC = com.tencent.mm.emoji.panel.a.j.gnL.atv;
      AppMethodBeat.o(105203);
      return;
    }
  }
  
  public void set16029ExtraInfo(String paramString)
  {
    AppMethodBeat.i(105208);
    com.tencent.mm.emoji.b.f.agb().extraInfo = paramString;
    AppMethodBeat.o(105208);
  }
  
  public void setCallback(com.tencent.mm.pluginsdk.ui.chat.f paramf)
  {
    AppMethodBeat.i(105194);
    super.setCallback(paramf);
    com.tencent.mm.view.d.a locala = this.LrJ;
    paramf = (com.tencent.mm.pluginsdk.ui.chat.j)paramf;
    locala.Lut = paramf;
    locala.Lui.gnn = paramf;
    AppMethodBeat.o(105194);
  }
  
  public void setDefaultEmojiByDetail(String paramString)
  {
    AppMethodBeat.i(105206);
    this.LrJ.aVt(paramString);
    this.LrJ.Luz.alive();
    AppMethodBeat.o(105206);
  }
  
  public void setEntranceScene(int paramInt)
  {
    AppMethodBeat.i(105207);
    com.tencent.mm.view.d.a locala = this.LrJ;
    com.tencent.mm.emoji.b.f.agb().scene = paramInt;
    b.afY().scene = paramInt;
    Object localObject = com.tencent.mm.emoji.b.e.goH;
    com.tencent.mm.emoji.b.e.setScene(paramInt);
    int i = locala.Luo.scene;
    locala.Luo.scene = paramInt;
    locala.Luo.gkW = com.tencent.mm.emoji.a.a.i.lV(paramInt);
    locala.Luo.gkU = com.tencent.mm.emoji.a.a.i.lW(paramInt);
    localObject = locala.Luo;
    if (paramInt == ChatFooterPanel.ESp) {}
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.emoji.a.a.i)localObject).gkQ = bool;
      if (i != paramInt) {
        locala.Lup.afs();
      }
      locala.Lui.scene = paramInt;
      AppMethodBeat.o(105207);
      return;
    }
  }
  
  public void setOnTextOperationListener(ChatFooterPanel.a parama)
  {
    AppMethodBeat.i(105195);
    super.setOnTextOperationListener(parama);
    com.tencent.mm.view.d.a locala = this.LrJ;
    locala.gnc = parama;
    locala.Lui.gnc = parama;
    locala.Luh.gnc = parama;
    AppMethodBeat.o(105195);
  }
  
  public void setPortHeightPx(int paramInt)
  {
    AppMethodBeat.i(105202);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "setPortHeightPx: %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(105202);
  }
  
  public void setSendButtonEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(105196);
    Object localObject = this.LrJ.Luo;
    ((com.tencent.mm.emoji.a.a.i)localObject).gkZ = paramBoolean;
    localObject = ((Iterable)((com.tencent.mm.emoji.a.a.i)localObject).gla).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((d.g.a.a)((Iterator)localObject).next()).invoke();
    }
    AppMethodBeat.o(105196);
  }
  
  public void setShowClose(boolean paramBoolean)
  {
    AppMethodBeat.i(105199);
    Object localObject2 = this.LrJ;
    Object localObject1 = ((com.tencent.mm.view.d.a)localObject2).Luk;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject1).setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      ((com.tencent.mm.view.d.a)localObject2).Luj.setBackgroundResource(2131232049);
      AppMethodBeat.o(105199);
      return;
    }
    localObject1 = ((com.tencent.mm.view.d.a)localObject2).Luj;
    Object localObject3 = ((com.tencent.mm.view.d.a)localObject2).Luj;
    p.h(localObject3, "$this$getAttrResId");
    localObject2 = new TypedValue();
    localObject3 = ((View)localObject3).getContext();
    p.g(localObject3, "context");
    ((Context)localObject3).getTheme().resolveAttribute(2130968959, (TypedValue)localObject2, true);
    ((View)localObject1).setBackgroundResource(((TypedValue)localObject2).resourceId);
    AppMethodBeat.o(105199);
  }
  
  public void setShowSend(boolean paramBoolean)
  {
    AppMethodBeat.i(105198);
    this.LrJ.setShowSend(paramBoolean);
    AppMethodBeat.o(105198);
  }
  
  public void setShowSmiley(boolean paramBoolean)
  {
    this.LrJ.Luo.gkR = paramBoolean;
  }
  
  public void setShowStore(boolean paramBoolean)
  {
    AppMethodBeat.i(105197);
    this.LrJ.setShowStore(paramBoolean);
    AppMethodBeat.o(105197);
  }
  
  public void setTalkerName(String paramString)
  {
    AppMethodBeat.i(105205);
    com.tencent.mm.view.d.a locala = this.LrJ;
    locala.vaL = paramString;
    locala.Lui.gno = paramString;
    if ((bt.isNullOrNil(paramString)) || ((!am.aSQ(paramString)) && (!w.zl(paramString)))) {}
    for (boolean bool = true;; bool = false)
    {
      if (locala.Luo.gkT != bool)
      {
        locala.Luo.gkT = bool;
        locala.Lup.afs();
      }
      AppMethodBeat.o(105205);
      return;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(105204);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      localObject = this.LrJ;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onResume: ");
      ((com.tencent.mm.view.d.a)localObject).isResume = true;
      ((com.tencent.mm.view.d.a)localObject).Luo.afr();
      if (((com.tencent.mm.view.d.a)localObject).Lus != null) {
        ((com.tencent.mm.view.d.a)localObject).Lus.afs();
      }
      if (((com.tencent.mm.view.d.a)localObject).gnc != null) {
        ((com.tencent.mm.view.d.a)localObject).gnc.dU(((com.tencent.mm.view.d.a)localObject).Lur);
      }
      if (((com.tencent.mm.view.d.a)localObject).isResume)
      {
        if ((bt.lQ(((com.tencent.mm.view.d.a)localObject).Lue, com.tencent.mm.emoji.a.a.ad.afB())) && (((com.tencent.mm.view.d.a)localObject).Luo.gkW)) {
          com.tencent.mm.plugin.report.service.g.yhR.f(15982, new Object[] { Integer.valueOf(0) });
        }
        localObject = com.tencent.mm.emoji.b.c.goE;
        com.tencent.mm.emoji.b.c.ma(1);
      }
      AppMethodBeat.o(105204);
      return;
    }
    Object localObject = this.LrJ;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onPause: ");
    ((com.tencent.mm.view.d.a)localObject).isResume = false;
    ((com.tencent.mm.view.d.a)localObject).Luu.clear();
    AppMethodBeat.o(105204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.SmileyPanelImpl
 * JD-Core Version:    0.7.0.1
 */