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
import com.tencent.mm.cc.a.b;
import com.tencent.mm.emoji.a.a.ag;
import com.tencent.mm.emoji.a.a.i;
import com.tencent.mm.emoji.a.a.z;
import com.tencent.mm.emoji.b.b;
import com.tencent.mm.emoji.panel.a.o;
import com.tencent.mm.emoji.panel.a.v;
import com.tencent.mm.emoji.panel.a.x.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.view.d.a.6;
import d.g.b.k;
import java.util.Iterator;

public class SmileyPanelImpl
  extends SmileyPanel
  implements LifecycleObserver
{
  private final com.tencent.mm.view.d.a HXN;
  private boolean HXO;
  private final String TAG;
  private boolean aJO;
  
  public SmileyPanelImpl(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean) {}
  
  public SmileyPanelImpl(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, paramBoolean);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105191);
    if (this.aJO)
    {
      ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "destroy: has destroyed");
      AppMethodBeat.o(105191);
      return;
    }
    this.aJO = true;
    ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "destroy: ");
    this.BUR = null;
    this.HXN.IaC.dead();
    this.HXN.onDestroy();
    ((d)g.ad(d.class)).getProvider().bUM();
    ((d)g.ad(d.class)).getProvider().onDestroy();
    AppMethodBeat.o(105191);
  }
  
  public final void exm()
  {
    this.BUR = null;
  }
  
  public final void exn()
  {
    AppMethodBeat.i(105200);
    com.tencent.mm.view.d.a locala = this.HXN;
    locala.Iar.fNH = false;
    locala.Iar.fNJ = false;
    locala = this.HXN;
    locala.Iar.fNK = false;
    locala.Iar.fNL = false;
    this.HXN.setShowStore(false);
    AppMethodBeat.o(105200);
  }
  
  public final void exo()
  {
    AppMethodBeat.i(105201);
    ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSmiley: %B, hideEmojiSmiley: %B", new Object[] { Boolean.FALSE, Boolean.FALSE });
    AppMethodBeat.o(105201);
  }
  
  public final void exp()
  {
    AppMethodBeat.i(169244);
    this.HXN.setShowSend(false);
    AppMethodBeat.o(169244);
  }
  
  public final void exq()
  {
    AppMethodBeat.i(105189);
    this.HXN.abm(0);
    AppMethodBeat.o(105189);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityDestroy()
  {
    AppMethodBeat.i(105187);
    ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onActivityDestroy:%s", new Object[] { getContext() });
    destroy();
    AppMethodBeat.o(105187);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(105192);
    super.onAttachedToWindow();
    ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onAttachedToWindow");
    com.tencent.mm.view.d.a locala = this.HXN;
    if (locala.Iai)
    {
      ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "listener added %s", new Object[] { locala });
      AppMethodBeat.o(105192);
      return;
    }
    locala.Iai = true;
    ((d)g.ad(d.class)).getProvider().k(locala.Iay);
    ((d)g.ad(d.class)).getProvider().i(locala.Fzr);
    com.tencent.mm.sdk.b.a.ESL.c(locala.Fzs);
    com.tencent.mm.sdk.b.a.ESL.c(locala.Iaz);
    ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager add listener. %s", new Object[] { locala });
    AppMethodBeat.o(105192);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(105193);
    super.onDetachedFromWindow();
    ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onDetachedFromWindow");
    this.HXN.removeListener();
    AppMethodBeat.o(105193);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(105190);
    ad.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onPause");
    ((d)g.ad(d.class)).getProvider().bUM();
    Object localObject = this.HXN;
    ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "saveSelectedTab: %s", new Object[] { ((com.tencent.mm.view.d.a)localObject).Iah });
    com.tencent.mm.emoji.a.h localh = com.tencent.mm.emoji.a.h.abj();
    localh.fMR = ((com.tencent.mm.view.d.a)localObject).Iah;
    if (aj.cbe())
    {
      g.afB().afk().set(-29414086, localh.fMR);
      AppMethodBeat.o(105190);
      return;
    }
    com.tencent.mm.cc.a.eCL();
    localObject = com.tencent.mm.cc.a.EMi;
    a.b.aEG(localh.fMR);
    AppMethodBeat.o(105190);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(105188);
    ad.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onResume");
    if (!this.HXO)
    {
      this.HXO = true;
      com.tencent.mm.view.d.a locala = this.HXN;
      locala.Ias.abO();
      locala.Iar.abN();
    }
    AppMethodBeat.o(105188);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105203);
    ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onSizeChanged: %s, %s; %s, %s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    com.tencent.mm.view.d.a locala;
    ViewGroup.LayoutParams localLayoutParams;
    if (this.HXN != null)
    {
      locala = this.HXN;
      v.fQI.lF(paramInt1);
      com.tencent.mm.emoji.panel.a.j.fQo.lF(paramInt1);
      paramInt3 = locala.context.getResources().getDimensionPixelSize(2131166251);
      localLayoutParams = locala.Iao.getLayoutParams();
      ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "updateViewSize: %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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
        locala.Iao.setLayoutParams(localLayoutParams);
        locala.Iao.post(new a.6(locala));
      }
      b.acm().fRe = v.fQI.aqI;
      com.tencent.mm.emoji.b.f.acp().fRe = com.tencent.mm.emoji.panel.a.j.fQo.aqI;
      AppMethodBeat.o(105203);
      return;
    }
  }
  
  public void set16029ExtraInfo(String paramString)
  {
    AppMethodBeat.i(105208);
    com.tencent.mm.emoji.b.f.acp().extraInfo = paramString;
    AppMethodBeat.o(105208);
  }
  
  public void setCallback(com.tencent.mm.pluginsdk.ui.chat.f paramf)
  {
    AppMethodBeat.i(105194);
    super.setCallback(paramf);
    com.tencent.mm.view.d.a locala = this.HXN;
    paramf = (com.tencent.mm.pluginsdk.ui.chat.j)paramf;
    locala.Iaw = paramf;
    locala.Ial.fPO = paramf;
    AppMethodBeat.o(105194);
  }
  
  public void setDefaultEmojiByDetail(String paramString)
  {
    AppMethodBeat.i(105206);
    this.HXN.aKb(paramString);
    this.HXN.IaC.alive();
    AppMethodBeat.o(105206);
  }
  
  public void setEntranceScene(int paramInt)
  {
    AppMethodBeat.i(105207);
    com.tencent.mm.view.d.a locala = this.HXN;
    com.tencent.mm.emoji.b.f.acp().scene = paramInt;
    b.acm().scene = paramInt;
    Object localObject = com.tencent.mm.emoji.b.e.fRj;
    com.tencent.mm.emoji.b.e.setScene(paramInt);
    int i = locala.Iar.scene;
    locala.Iar.scene = paramInt;
    locala.Iar.fNL = i.lA(paramInt);
    locala.Iar.fNJ = i.lB(paramInt);
    localObject = locala.Iar;
    if (paramInt == ChatFooterPanel.BUU) {}
    for (boolean bool = true;; bool = false)
    {
      ((i)localObject).fNF = bool;
      if (i != paramInt) {
        locala.Ias.abO();
      }
      locala.Ial.scene = paramInt;
      AppMethodBeat.o(105207);
      return;
    }
  }
  
  public void setOnTextOperationListener(ChatFooterPanel.a parama)
  {
    AppMethodBeat.i(105195);
    super.setOnTextOperationListener(parama);
    com.tencent.mm.view.d.a locala = this.HXN;
    locala.fPD = parama;
    locala.Ial.fPD = parama;
    locala.Iak.fPD = parama;
    AppMethodBeat.o(105195);
  }
  
  public void setPortHeightPx(int paramInt)
  {
    AppMethodBeat.i(105202);
    ad.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "setPortHeightPx: %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(105202);
  }
  
  public void setSendButtonEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(105196);
    Object localObject = this.HXN.Iar;
    ((i)localObject).fNO = paramBoolean;
    localObject = ((Iterable)((i)localObject).fNP).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((d.g.a.a)((Iterator)localObject).next()).invoke();
    }
    AppMethodBeat.o(105196);
  }
  
  public void setShowClose(boolean paramBoolean)
  {
    AppMethodBeat.i(105199);
    Object localObject2 = this.HXN;
    Object localObject1 = ((com.tencent.mm.view.d.a)localObject2).Ian;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject1).setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      ((com.tencent.mm.view.d.a)localObject2).Iam.setBackgroundResource(2131232049);
      AppMethodBeat.o(105199);
      return;
    }
    localObject1 = ((com.tencent.mm.view.d.a)localObject2).Iam;
    Object localObject3 = ((com.tencent.mm.view.d.a)localObject2).Iam;
    k.h(localObject3, "$this$getAttrResId");
    localObject2 = new TypedValue();
    localObject3 = ((View)localObject3).getContext();
    k.g(localObject3, "context");
    ((Context)localObject3).getTheme().resolveAttribute(2130968959, (TypedValue)localObject2, true);
    ((View)localObject1).setBackgroundResource(((TypedValue)localObject2).resourceId);
    AppMethodBeat.o(105199);
  }
  
  public void setShowSend(boolean paramBoolean)
  {
    AppMethodBeat.i(105198);
    this.HXN.setShowSend(paramBoolean);
    AppMethodBeat.o(105198);
  }
  
  public void setShowSmiley(boolean paramBoolean)
  {
    this.HXN.Iar.fNG = paramBoolean;
  }
  
  public void setShowStore(boolean paramBoolean)
  {
    AppMethodBeat.i(105197);
    this.HXN.setShowStore(paramBoolean);
    AppMethodBeat.o(105197);
  }
  
  public void setTalkerName(String paramString)
  {
    AppMethodBeat.i(105205);
    com.tencent.mm.view.d.a locala = this.HXN;
    locala.sPP = paramString;
    locala.Ial.fPP = paramString;
    if ((bt.isNullOrNil(paramString)) || ((!af.aHH(paramString)) && (!w.sn(paramString)))) {}
    for (boolean bool = true;; bool = false)
    {
      if (locala.Iar.fNI != bool)
      {
        locala.Iar.fNI = bool;
        locala.Ias.abO();
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
      localObject = this.HXN;
      ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onResume: ");
      ((com.tencent.mm.view.d.a)localObject).isResume = true;
      ((com.tencent.mm.view.d.a)localObject).Iar.abN();
      if (((com.tencent.mm.view.d.a)localObject).Iav != null) {
        ((com.tencent.mm.view.d.a)localObject).Iav.abO();
      }
      if (((com.tencent.mm.view.d.a)localObject).fPD != null) {
        ((com.tencent.mm.view.d.a)localObject).fPD.lf(((com.tencent.mm.view.d.a)localObject).Iau);
      }
      if (((com.tencent.mm.view.d.a)localObject).isResume)
      {
        if ((bt.kU(((com.tencent.mm.view.d.a)localObject).Iah, z.abU())) && (((com.tencent.mm.view.d.a)localObject).Iar.fNL)) {
          com.tencent.mm.plugin.report.service.h.vKh.f(15982, new Object[] { Integer.valueOf(0) });
        }
        localObject = com.tencent.mm.emoji.b.c.fRg;
        com.tencent.mm.emoji.b.c.lI(1);
      }
      AppMethodBeat.o(105204);
      return;
    }
    Object localObject = this.HXN;
    ad.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onPause: ");
    ((com.tencent.mm.view.d.a)localObject).isResume = false;
    ((com.tencent.mm.view.d.a)localObject).Iax.clear();
    AppMethodBeat.o(105204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.SmileyPanelImpl
 * JD-Core Version:    0.7.0.1
 */