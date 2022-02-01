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
import com.tencent.mm.ca.a.b;
import com.tencent.mm.emoji.a.b.ad;
import com.tencent.mm.emoji.a.b.af;
import com.tencent.mm.emoji.a.b.n;
import com.tencent.mm.emoji.b.b;
import com.tencent.mm.emoji.panel.a.o;
import com.tencent.mm.emoji.panel.a.v;
import com.tencent.mm.emoji.panel.a.x.b;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.view.d.a.6;
import d.g.b.p;
import java.util.Iterator;
import java.util.LinkedList;

public class SmileyPanelImpl
  extends SmileyPanel
  implements LifecycleObserver
{
  private final com.tencent.mm.view.d.a LOu;
  private boolean LOv;
  private final String TAG;
  private boolean aMv;
  
  public SmileyPanelImpl(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean) {}
  
  public SmileyPanelImpl(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, paramBoolean);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(188527);
    com.tencent.mm.view.d.a locala = this.LOu;
    com.tencent.mm.emoji.a.b.j localj = locala.LRc;
    p.h(paramn, "externalPanelProvider");
    localj.gnA.add(paramn);
    locala.LRc.afG();
    AppMethodBeat.o(188527);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105191);
    if (this.aMv)
    {
      ae.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "destroy: has destroyed");
      AppMethodBeat.o(105191);
      return;
    }
    this.aMv = true;
    ae.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "destroy: ");
    this.FkH = null;
    this.LOu.LRm.dead();
    this.LOu.onDestroy();
    ((d)com.tencent.mm.kernel.g.ad(d.class)).getProvider().chT();
    ((d)com.tencent.mm.kernel.g.ad(d.class)).getProvider().onDestroy();
    AppMethodBeat.o(105191);
  }
  
  public final void ffs()
  {
    this.FkH = null;
  }
  
  public final void fft()
  {
    int j = 1;
    AppMethodBeat.i(105200);
    com.tencent.mm.view.d.a locala = this.LOu;
    if ((locala.LRb.gnn) || (locala.LRb.gnp))
    {
      i = 1;
      locala.LRb.gnn = false;
      locala.LRb.gnp = false;
      if (i != 0) {
        locala.LRc.afG();
      }
      locala = this.LOu;
      i = j;
      if (!locala.LRb.gnq) {
        if (!locala.LRb.gnr) {
          break label138;
        }
      }
    }
    label138:
    for (int i = j;; i = 0)
    {
      locala.LRb.gnq = false;
      locala.LRb.gnr = false;
      if (i != 0) {
        locala.LRc.afG();
      }
      this.LOu.setShowStore(false);
      AppMethodBeat.o(105200);
      return;
      i = 0;
      break;
    }
  }
  
  public final void ffu()
  {
    AppMethodBeat.i(105201);
    ae.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSmiley: %B, hideEmojiSmiley: %B", new Object[] { Boolean.FALSE, Boolean.FALSE });
    AppMethodBeat.o(105201);
  }
  
  public final void ffv()
  {
    AppMethodBeat.i(169244);
    this.LOu.setShowSend(false);
    AppMethodBeat.o(169244);
  }
  
  public final void ffw()
  {
    AppMethodBeat.i(105189);
    this.LOu.agN(0);
    AppMethodBeat.o(105189);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityDestroy()
  {
    AppMethodBeat.i(105187);
    ae.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onActivityDestroy:%s", new Object[] { getContext() });
    destroy();
    AppMethodBeat.o(105187);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(105192);
    super.onAttachedToWindow();
    ae.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onAttachedToWindow");
    com.tencent.mm.view.d.a locala = this.LOu;
    if (locala.LQS)
    {
      ae.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "listener added %s", new Object[] { locala });
      AppMethodBeat.o(105192);
      return;
    }
    locala.LQS = true;
    ((d)com.tencent.mm.kernel.g.ad(d.class)).getProvider().k(locala.LRi);
    ((d)com.tencent.mm.kernel.g.ad(d.class)).getProvider().i(locala.Jgo);
    com.tencent.mm.sdk.b.a.IvT.c(locala.Jgp);
    com.tencent.mm.sdk.b.a.IvT.c(locala.LRj);
    ae.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager add listener. %s", new Object[] { locala });
    AppMethodBeat.o(105192);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(105193);
    super.onDetachedFromWindow();
    ae.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onDetachedFromWindow");
    this.LOu.removeListener();
    AppMethodBeat.o(105193);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(105190);
    ae.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onPause");
    ((d)com.tencent.mm.kernel.g.ad(d.class)).getProvider().chT();
    Object localObject = this.LOu;
    ae.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "saveSelectedTab: %s", new Object[] { ((com.tencent.mm.view.d.a)localObject).LQR });
    com.tencent.mm.emoji.a.i locali = com.tencent.mm.emoji.a.i.aeX();
    locali.gmx = ((com.tencent.mm.view.d.a)localObject).LQR;
    if (com.tencent.mm.sdk.platformtools.ak.coh())
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(-29414086, locali.gmx);
      AppMethodBeat.o(105190);
      return;
    }
    com.tencent.mm.ca.a.flq();
    localObject = com.tencent.mm.ca.a.Ipp;
    a.b.aRa(locali.gmx);
    AppMethodBeat.o(105190);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(105188);
    ae.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onResume");
    if (!this.LOv)
    {
      this.LOv = true;
      com.tencent.mm.view.d.a locala = this.LOu;
      locala.LRc.afG();
      locala.LRb.afF();
    }
    AppMethodBeat.o(105188);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105203);
    ae.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onSizeChanged: %s, %s; %s, %s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    com.tencent.mm.view.d.a locala;
    ViewGroup.LayoutParams localLayoutParams;
    if (this.LOu != null)
    {
      locala = this.LOu;
      v.gqB.mf(paramInt1);
      com.tencent.mm.emoji.panel.a.j.gqh.mf(paramInt1);
      paramInt3 = locala.context.getResources().getDimensionPixelSize(2131166251);
      localLayoutParams = locala.LQY.getLayoutParams();
      ae.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "updateViewSize: %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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
        locala.LQY.setLayoutParams(localLayoutParams);
        locala.LQY.post(new a.6(locala));
      }
      b.agm().gqX = v.gqB.atv;
      com.tencent.mm.emoji.b.f.agp().gqX = com.tencent.mm.emoji.panel.a.j.gqh.atv;
      AppMethodBeat.o(105203);
      return;
    }
  }
  
  public void set16029ExtraInfo(String paramString)
  {
    AppMethodBeat.i(105208);
    com.tencent.mm.emoji.b.f.agp().extraInfo = paramString;
    AppMethodBeat.o(105208);
  }
  
  public void setCallback(com.tencent.mm.pluginsdk.ui.chat.f paramf)
  {
    AppMethodBeat.i(105194);
    super.setCallback(paramf);
    com.tencent.mm.view.d.a locala = this.LOu;
    paramf = (com.tencent.mm.pluginsdk.ui.chat.j)paramf;
    locala.LRg = paramf;
    locala.LQV.gpJ = paramf;
    AppMethodBeat.o(105194);
  }
  
  public void setDefaultEmojiByDetail(String paramString)
  {
    AppMethodBeat.i(105206);
    this.LOu.aWU(paramString);
    this.LOu.LRm.alive();
    AppMethodBeat.o(105206);
  }
  
  public void setEntranceScene(int paramInt)
  {
    AppMethodBeat.i(105207);
    com.tencent.mm.view.d.a locala = this.LOu;
    com.tencent.mm.emoji.b.f.agp().scene = paramInt;
    b.agm().scene = paramInt;
    Object localObject = com.tencent.mm.emoji.b.e.grc;
    com.tencent.mm.emoji.b.e.setScene(paramInt);
    int i = locala.LRb.scene;
    locala.LRb.scene = paramInt;
    locala.LRb.gnr = com.tencent.mm.emoji.a.b.i.lX(paramInt);
    locala.LRb.gnp = com.tencent.mm.emoji.a.b.i.lY(paramInt);
    localObject = locala.LRb;
    if (paramInt == ChatFooterPanel.FkK) {}
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.emoji.a.b.i)localObject).gnl = bool;
      if (i != paramInt) {
        locala.LRc.afG();
      }
      locala.LQV.scene = paramInt;
      AppMethodBeat.o(105207);
      return;
    }
  }
  
  public void setOnTextOperationListener(ChatFooterPanel.a parama)
  {
    AppMethodBeat.i(105195);
    super.setOnTextOperationListener(parama);
    com.tencent.mm.view.d.a locala = this.LOu;
    locala.gpy = parama;
    locala.LQV.gpy = parama;
    locala.LQU.gpy = parama;
    AppMethodBeat.o(105195);
  }
  
  public void setPortHeightPx(int paramInt)
  {
    AppMethodBeat.i(105202);
    ae.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "setPortHeightPx: %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(105202);
  }
  
  public void setSendButtonEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(105196);
    Object localObject = this.LOu.LRb;
    ((com.tencent.mm.emoji.a.b.i)localObject).gnu = paramBoolean;
    localObject = ((Iterable)((com.tencent.mm.emoji.a.b.i)localObject).gnv).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((d.g.a.a)((Iterator)localObject).next()).invoke();
    }
    AppMethodBeat.o(105196);
  }
  
  public void setShowClose(boolean paramBoolean)
  {
    AppMethodBeat.i(105199);
    Object localObject2 = this.LOu;
    Object localObject1 = ((com.tencent.mm.view.d.a)localObject2).LQX;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject1).setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      ((com.tencent.mm.view.d.a)localObject2).LQW.setBackgroundResource(2131232049);
      AppMethodBeat.o(105199);
      return;
    }
    localObject1 = ((com.tencent.mm.view.d.a)localObject2).LQW;
    Object localObject3 = ((com.tencent.mm.view.d.a)localObject2).LQW;
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
    this.LOu.setShowSend(paramBoolean);
    AppMethodBeat.o(105198);
  }
  
  public void setShowSmiley(boolean paramBoolean)
  {
    this.LOu.LRb.gnm = paramBoolean;
  }
  
  public void setShowStore(boolean paramBoolean)
  {
    AppMethodBeat.i(105197);
    this.LOu.setShowStore(paramBoolean);
    AppMethodBeat.o(105197);
  }
  
  public void setTalkerName(String paramString)
  {
    AppMethodBeat.i(105205);
    com.tencent.mm.view.d.a locala = this.LOu;
    locala.vmW = paramString;
    locala.LQV.gpK = paramString;
    if ((bu.isNullOrNil(paramString)) || ((!an.aUq(paramString)) && (!x.zV(paramString)))) {}
    for (boolean bool = true;; bool = false)
    {
      if (locala.LRb.gno != bool)
      {
        locala.LRb.gno = bool;
        locala.LRc.afG();
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
      localObject = this.LOu;
      ae.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onResume: ");
      ((com.tencent.mm.view.d.a)localObject).isResume = true;
      ((com.tencent.mm.view.d.a)localObject).LRb.afF();
      if (((com.tencent.mm.view.d.a)localObject).LRf != null) {
        ((com.tencent.mm.view.d.a)localObject).LRf.afG();
      }
      if (((com.tencent.mm.view.d.a)localObject).gpy != null) {
        ((com.tencent.mm.view.d.a)localObject).gpy.dW(((com.tencent.mm.view.d.a)localObject).LRe);
      }
      if (((com.tencent.mm.view.d.a)localObject).isResume)
      {
        if ((bu.lX(((com.tencent.mm.view.d.a)localObject).LQR, ad.afP())) && (((com.tencent.mm.view.d.a)localObject).LRb.gnr)) {
          com.tencent.mm.plugin.report.service.g.yxI.f(15982, new Object[] { Integer.valueOf(0) });
        }
        localObject = com.tencent.mm.emoji.b.c.gqZ;
        com.tencent.mm.emoji.b.c.md(1);
      }
      AppMethodBeat.o(105204);
      return;
    }
    Object localObject = this.LOu;
    ae.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onPause: ");
    ((com.tencent.mm.view.d.a)localObject).isResume = false;
    ((com.tencent.mm.view.d.a)localObject).LRh.clear();
    AppMethodBeat.o(105204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.SmileyPanelImpl
 * JD-Core Version:    0.7.0.1
 */