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
import com.tencent.mm.emoji.a.a.ab;
import com.tencent.mm.emoji.a.a.ag;
import com.tencent.mm.emoji.a.a.z;
import com.tencent.mm.emoji.b.b;
import com.tencent.mm.emoji.panel.a.o;
import com.tencent.mm.emoji.panel.a.v;
import com.tencent.mm.emoji.panel.a.x.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.view.d.a.6;
import d.g.b.k;
import java.util.Iterator;

public class SmileyPanelImpl
  extends SmileyPanel
  implements LifecycleObserver
{
  private final com.tencent.mm.view.d.a JyC;
  private boolean JyD;
  private final String TAG;
  private boolean aKE;
  
  public SmileyPanelImpl(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean) {}
  
  public SmileyPanelImpl(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, paramBoolean);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105191);
    if (this.aKE)
    {
      ac.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "destroy: has destroyed");
      AppMethodBeat.o(105191);
      return;
    }
    this.aKE = true;
    ac.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "destroy: ");
    this.Dnh = null;
    this.JyC.JBs.dead();
    this.JyC.onDestroy();
    ((d)g.ad(d.class)).getProvider().cbZ();
    ((d)g.ad(d.class)).getProvider().onDestroy();
    AppMethodBeat.o(105191);
  }
  
  public final void eMG()
  {
    this.Dnh = null;
  }
  
  public final void eMH()
  {
    AppMethodBeat.i(105200);
    com.tencent.mm.view.d.a locala = this.JyC;
    locala.JBh.fRs = false;
    locala.JBh.fRu = false;
    locala = this.JyC;
    locala.JBh.fRv = false;
    locala.JBh.fRw = false;
    this.JyC.setShowStore(false);
    AppMethodBeat.o(105200);
  }
  
  public final void eMI()
  {
    AppMethodBeat.i(105201);
    ac.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSmiley: %B, hideEmojiSmiley: %B", new Object[] { Boolean.FALSE, Boolean.FALSE });
    AppMethodBeat.o(105201);
  }
  
  public final void eMJ()
  {
    AppMethodBeat.i(169244);
    this.JyC.setShowSend(false);
    AppMethodBeat.o(169244);
  }
  
  public final void eMK()
  {
    AppMethodBeat.i(105189);
    this.JyC.adE(0);
    AppMethodBeat.o(105189);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityDestroy()
  {
    AppMethodBeat.i(105187);
    ac.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onActivityDestroy:%s", new Object[] { getContext() });
    destroy();
    AppMethodBeat.o(105187);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(105192);
    super.onAttachedToWindow();
    ac.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onAttachedToWindow");
    com.tencent.mm.view.d.a locala = this.JyC;
    if (locala.JAY)
    {
      ac.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "listener added %s", new Object[] { locala });
      AppMethodBeat.o(105192);
      return;
    }
    locala.JAY = true;
    ((d)g.ad(d.class)).getProvider().k(locala.JBo);
    ((d)g.ad(d.class)).getProvider().i(locala.GYt);
    com.tencent.mm.sdk.b.a.GpY.c(locala.GYu);
    com.tencent.mm.sdk.b.a.GpY.c(locala.JBp);
    ac.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager add listener. %s", new Object[] { locala });
    AppMethodBeat.o(105192);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(105193);
    super.onDetachedFromWindow();
    ac.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onDetachedFromWindow");
    this.JyC.removeListener();
    AppMethodBeat.o(105193);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(105190);
    ac.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onPause");
    ((d)g.ad(d.class)).getProvider().cbZ();
    Object localObject = this.JyC;
    ac.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "saveSelectedTab: %s", new Object[] { ((com.tencent.mm.view.d.a)localObject).JAX });
    com.tencent.mm.emoji.a.i locali = com.tencent.mm.emoji.a.i.ach();
    locali.fQD = ((com.tencent.mm.view.d.a)localObject).JAX;
    if (com.tencent.mm.sdk.platformtools.ai.cin())
    {
      g.agR().agA().set(-29414086, locali.fQD);
      AppMethodBeat.o(105190);
      return;
    }
    com.tencent.mm.cb.a.eSf();
    localObject = com.tencent.mm.cb.a.Gju;
    a.b.aJX(locali.fQD);
    AppMethodBeat.o(105190);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(105188);
    ac.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onResume");
    if (!this.JyD)
    {
      this.JyD = true;
      com.tencent.mm.view.d.a locala = this.JyC;
      locala.JBi.acO();
      locala.JBh.acN();
    }
    AppMethodBeat.o(105188);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105203);
    ac.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onSizeChanged: %s, %s; %s, %s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    com.tencent.mm.view.d.a locala;
    ViewGroup.LayoutParams localLayoutParams;
    if (this.JyC != null)
    {
      locala = this.JyC;
      v.fUD.lC(paramInt1);
      com.tencent.mm.emoji.panel.a.j.fUj.lC(paramInt1);
      paramInt3 = locala.context.getResources().getDimensionPixelSize(2131166251);
      localLayoutParams = locala.JBe.getLayoutParams();
      ac.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "updateViewSize: %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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
        locala.JBe.setLayoutParams(localLayoutParams);
        locala.JBe.post(new a.6(locala));
      }
      b.ads().fUZ = v.fUD.arE;
      com.tencent.mm.emoji.b.f.adv().fUZ = com.tencent.mm.emoji.panel.a.j.fUj.arE;
      AppMethodBeat.o(105203);
      return;
    }
  }
  
  public void set16029ExtraInfo(String paramString)
  {
    AppMethodBeat.i(105208);
    com.tencent.mm.emoji.b.f.adv().extraInfo = paramString;
    AppMethodBeat.o(105208);
  }
  
  public void setCallback(com.tencent.mm.pluginsdk.ui.chat.f paramf)
  {
    AppMethodBeat.i(105194);
    super.setCallback(paramf);
    com.tencent.mm.view.d.a locala = this.JyC;
    paramf = (com.tencent.mm.pluginsdk.ui.chat.j)paramf;
    locala.JBm = paramf;
    locala.JBb.fTJ = paramf;
    AppMethodBeat.o(105194);
  }
  
  public void setDefaultEmojiByDetail(String paramString)
  {
    AppMethodBeat.i(105206);
    this.JyC.aPD(paramString);
    this.JyC.JBs.alive();
    AppMethodBeat.o(105206);
  }
  
  public void setEntranceScene(int paramInt)
  {
    AppMethodBeat.i(105207);
    com.tencent.mm.view.d.a locala = this.JyC;
    com.tencent.mm.emoji.b.f.adv().scene = paramInt;
    b.ads().scene = paramInt;
    Object localObject = com.tencent.mm.emoji.b.e.fVe;
    com.tencent.mm.emoji.b.e.setScene(paramInt);
    int i = locala.JBh.scene;
    locala.JBh.scene = paramInt;
    locala.JBh.fRw = com.tencent.mm.emoji.a.a.i.lw(paramInt);
    locala.JBh.fRu = com.tencent.mm.emoji.a.a.i.lx(paramInt);
    localObject = locala.JBh;
    if (paramInt == ChatFooterPanel.Dnk) {}
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.emoji.a.a.i)localObject).fRq = bool;
      if (i != paramInt) {
        locala.JBi.acO();
      }
      locala.JBb.scene = paramInt;
      AppMethodBeat.o(105207);
      return;
    }
  }
  
  public void setOnTextOperationListener(ChatFooterPanel.a parama)
  {
    AppMethodBeat.i(105195);
    super.setOnTextOperationListener(parama);
    com.tencent.mm.view.d.a locala = this.JyC;
    locala.fTy = parama;
    locala.JBb.fTy = parama;
    locala.JBa.fTy = parama;
    AppMethodBeat.o(105195);
  }
  
  public void setPortHeightPx(int paramInt)
  {
    AppMethodBeat.i(105202);
    ac.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "setPortHeightPx: %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(105202);
  }
  
  public void setSendButtonEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(105196);
    Object localObject = this.JyC.JBh;
    ((com.tencent.mm.emoji.a.a.i)localObject).fRz = paramBoolean;
    localObject = ((Iterable)((com.tencent.mm.emoji.a.a.i)localObject).fRA).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((d.g.a.a)((Iterator)localObject).next()).invoke();
    }
    AppMethodBeat.o(105196);
  }
  
  public void setShowClose(boolean paramBoolean)
  {
    AppMethodBeat.i(105199);
    Object localObject2 = this.JyC;
    Object localObject1 = ((com.tencent.mm.view.d.a)localObject2).JBd;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject1).setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      ((com.tencent.mm.view.d.a)localObject2).JBc.setBackgroundResource(2131232049);
      AppMethodBeat.o(105199);
      return;
    }
    localObject1 = ((com.tencent.mm.view.d.a)localObject2).JBc;
    Object localObject3 = ((com.tencent.mm.view.d.a)localObject2).JBc;
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
    this.JyC.setShowSend(paramBoolean);
    AppMethodBeat.o(105198);
  }
  
  public void setShowSmiley(boolean paramBoolean)
  {
    this.JyC.JBh.fRr = paramBoolean;
  }
  
  public void setShowStore(boolean paramBoolean)
  {
    AppMethodBeat.i(105197);
    this.JyC.setShowStore(paramBoolean);
    AppMethodBeat.o(105197);
  }
  
  public void setTalkerName(String paramString)
  {
    AppMethodBeat.i(105205);
    com.tencent.mm.view.d.a locala = this.JyC;
    locala.tYc = paramString;
    locala.JBb.fTK = paramString;
    if ((bs.isNullOrNil(paramString)) || ((!com.tencent.mm.storage.ai.aNc(paramString)) && (!w.wq(paramString)))) {}
    for (boolean bool = true;; bool = false)
    {
      if (locala.JBh.fRt != bool)
      {
        locala.JBh.fRt = bool;
        locala.JBi.acO();
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
      localObject = this.JyC;
      ac.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onResume: ");
      ((com.tencent.mm.view.d.a)localObject).isResume = true;
      ((com.tencent.mm.view.d.a)localObject).JBh.acN();
      if (((com.tencent.mm.view.d.a)localObject).JBl != null) {
        ((com.tencent.mm.view.d.a)localObject).JBl.acO();
      }
      if (((com.tencent.mm.view.d.a)localObject).fTy != null) {
        ((com.tencent.mm.view.d.a)localObject).fTy.dS(((com.tencent.mm.view.d.a)localObject).JBk);
      }
      if (((com.tencent.mm.view.d.a)localObject).isResume)
      {
        if ((bs.lr(((com.tencent.mm.view.d.a)localObject).JAX, z.acU())) && (((com.tencent.mm.view.d.a)localObject).JBh.fRw)) {
          h.wUl.f(15982, new Object[] { Integer.valueOf(0) });
        }
        localObject = com.tencent.mm.emoji.b.c.fVb;
        com.tencent.mm.emoji.b.c.lA(1);
      }
      AppMethodBeat.o(105204);
      return;
    }
    Object localObject = this.JyC;
    ac.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onPause: ");
    ((com.tencent.mm.view.d.a)localObject).isResume = false;
    ((com.tencent.mm.view.d.a)localObject).JBn.clear();
    AppMethodBeat.o(105204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.SmileyPanelImpl
 * JD-Core Version:    0.7.0.1
 */