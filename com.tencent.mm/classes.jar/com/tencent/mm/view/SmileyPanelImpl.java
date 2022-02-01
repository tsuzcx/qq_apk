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
import com.tencent.mm.emoji.b.b.ad;
import com.tencent.mm.emoji.b.b.af;
import com.tencent.mm.emoji.b.b.ak;
import com.tencent.mm.emoji.b.b.i;
import com.tencent.mm.emoji.b.b.n;
import com.tencent.mm.emoji.panel.a.ad.b;
import com.tencent.mm.emoji.panel.a.o;
import com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView;
import com.tencent.mm.plugin.emoji.ui.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.view.d.a.6;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;

public class SmileyPanelImpl
  extends SmileyPanel
  implements LifecycleObserver
{
  private final com.tencent.mm.view.d.a RmS;
  private boolean RmT;
  private final String TAG;
  private boolean aMn;
  
  public SmileyPanelImpl(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean) {}
  
  public SmileyPanelImpl(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, paramBoolean);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(199829);
    com.tencent.mm.view.d.a locala = this.RmS;
    com.tencent.mm.emoji.b.b.j localj = locala.RpL;
    p.h(paramn, "externalPanelProvider");
    localj.gYv.add(paramn);
    locala.RpL.avu();
    AppMethodBeat.o(199829);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105191);
    if (this.aMn)
    {
      Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "destroy: has destroyed");
      AppMethodBeat.o(105191);
      return;
    }
    this.aMn = true;
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "destroy: ");
    this.Kbz = null;
    this.RmS.RpW.dead();
    this.RmS.onDestroy();
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().cFR();
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().onDestroy();
    AppMethodBeat.o(105191);
  }
  
  public final void goC()
  {
    this.Kbz = null;
  }
  
  public final void goD()
  {
    int j = 1;
    AppMethodBeat.i(105200);
    com.tencent.mm.view.d.a locala = this.RmS;
    if ((locala.RpK.gYh) || (locala.RpK.gYj))
    {
      i = 1;
      locala.RpK.gYh = false;
      locala.RpK.gYj = false;
      if (i != 0) {
        locala.RpL.avu();
      }
      locala = this.RmS;
      i = j;
      if (!locala.RpK.gYk) {
        if (!locala.RpK.gYl) {
          break label138;
        }
      }
    }
    label138:
    for (int i = j;; i = 0)
    {
      locala.RpK.gYk = false;
      locala.RpK.gYl = false;
      if (i != 0) {
        locala.RpL.avu();
      }
      this.RmS.setShowStore(false);
      AppMethodBeat.o(105200);
      return;
      i = 0;
      break;
    }
  }
  
  public final void goE()
  {
    AppMethodBeat.i(169244);
    this.RmS.setShowSend(false);
    AppMethodBeat.o(169244);
  }
  
  public final void goF()
  {
    AppMethodBeat.i(105189);
    this.RmS.apY(0);
    AppMethodBeat.o(105189);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityDestroy()
  {
    AppMethodBeat.i(105187);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onActivityDestroy:%s", new Object[] { getContext() });
    destroy();
    AppMethodBeat.o(105187);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(105192);
    super.onAttachedToWindow();
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onAttachedToWindow");
    com.tencent.mm.view.d.a locala = this.RmS;
    if (locala.RpB)
    {
      Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "listener added %s", new Object[] { locala });
      AppMethodBeat.o(105192);
      return;
    }
    locala.RpB = true;
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().k(locala.wKe);
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().i(locala.wKf);
    EventCenter.instance.addListener(locala.wKg);
    EventCenter.instance.addListener(locala.RpT);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager add listener. %s", new Object[] { locala });
    AppMethodBeat.o(105192);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(105193);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onDetachedFromWindow");
    this.RmS.removeListener();
    AppMethodBeat.o(105193);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(105190);
    Log.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onPause");
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().cFR();
    Object localObject = this.RmS;
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "saveSelectedTab: %s", new Object[] { ((com.tencent.mm.view.d.a)localObject).RpA });
    com.tencent.mm.emoji.b.j localj = com.tencent.mm.emoji.b.j.auL();
    localj.gXo = ((com.tencent.mm.view.d.a)localObject).RpA;
    if (MMApplicationContext.isMainProcess())
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(-29414086, localj.gXo);
      AppMethodBeat.o(105190);
      return;
    }
    com.tencent.mm.ca.a.gvc();
    localObject = com.tencent.mm.ca.a.NCN;
    a.b.bhD(localj.gXo);
    AppMethodBeat.o(105190);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(105188);
    Log.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onResume");
    if (!this.RmT)
    {
      this.RmT = true;
      com.tencent.mm.view.d.a locala = this.RmS;
      locala.RpL.avu();
      locala.RpK.avt();
    }
    AppMethodBeat.o(105188);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105203);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onSizeChanged: %s, %s; %s, %s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    com.tencent.mm.view.d.a locala;
    ViewGroup.LayoutParams localLayoutParams;
    if (this.RmS != null)
    {
      locala = this.RmS;
      locala.RpQ.pn(paramInt1);
      locala.RpP.pn(paramInt1);
      locala.RpK.gYp = locala.RpQ.att;
      paramInt3 = locala.context.getResources().getDimensionPixelSize(2131166294);
      localLayoutParams = locala.RpH.getLayoutParams();
      Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "updateViewSize: %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (paramInt2 >= paramInt3 * 4) {
        break label249;
      }
    }
    label249:
    for (paramInt1 = paramInt3;; paramInt1 = locala.context.getResources().getDimensionPixelSize(2131166293))
    {
      if (localLayoutParams.height != paramInt1)
      {
        localLayoutParams.height = paramInt1;
        locala.RpH.setLayoutParams(localLayoutParams);
        locala.RpH.post(new a.6(locala));
      }
      com.tencent.mm.emoji.c.c.awc().hch = locala.RpQ.att;
      com.tencent.mm.emoji.c.h.awf().hch = locala.RpP.att;
      AppMethodBeat.o(105203);
      return;
    }
  }
  
  public void set16029ExtraInfo(String paramString)
  {
    AppMethodBeat.i(105208);
    com.tencent.mm.emoji.c.h.awf().extraInfo = paramString;
    AppMethodBeat.o(105208);
  }
  
  public void setCallback(f paramf)
  {
    AppMethodBeat.i(105194);
    super.setCallback(paramf);
    com.tencent.mm.view.d.a locala = this.RmS;
    paramf = (com.tencent.mm.pluginsdk.ui.chat.j)paramf;
    locala.rgI = paramf;
    locala.RpE.haC = paramf;
    AppMethodBeat.o(105194);
  }
  
  public void setDefaultEmojiByDetail(String paramString)
  {
    AppMethodBeat.i(105206);
    this.RmS.blU(paramString);
    this.RmS.RpW.alive();
    AppMethodBeat.o(105206);
  }
  
  public void setEntranceScene(int paramInt)
  {
    AppMethodBeat.i(105207);
    com.tencent.mm.view.d.a locala = this.RmS;
    com.tencent.mm.emoji.c.h.awf().scene = paramInt;
    com.tencent.mm.emoji.c.c.awc().scene = paramInt;
    Object localObject = com.tencent.mm.emoji.c.g.hcn;
    com.tencent.mm.emoji.c.g.setScene(paramInt);
    int i = locala.RpK.scene;
    locala.RpK.scene = paramInt;
    locala.RpK.gYl = i.pf(paramInt);
    locala.RpK.gYj = i.pg(paramInt);
    localObject = locala.RpK;
    if (paramInt == ChatFooterPanel.KbC) {}
    for (boolean bool = true;; bool = false)
    {
      ((i)localObject).gYf = bool;
      if (i != paramInt) {
        locala.RpL.avu();
      }
      locala.RpE.scene = paramInt;
      AppMethodBeat.o(105207);
      return;
    }
  }
  
  public void setOnTextOperationListener(ChatFooterPanel.a parama)
  {
    AppMethodBeat.i(105195);
    super.setOnTextOperationListener(parama);
    com.tencent.mm.view.d.a locala = this.RmS;
    locala.har = parama;
    locala.RpE.har = parama;
    locala.RpD.har = parama;
    AppMethodBeat.o(105195);
  }
  
  public void setPortHeightPx(int paramInt)
  {
    AppMethodBeat.i(105202);
    Log.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "setPortHeightPx: %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(105202);
  }
  
  public void setSendButtonEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(105196);
    Object localObject = this.RmS.RpK;
    ((i)localObject).gYo = paramBoolean;
    localObject = ((Iterable)((i)localObject).gYq).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((kotlin.g.a.a)((Iterator)localObject).next()).invoke();
    }
    AppMethodBeat.o(105196);
  }
  
  public void setShowClose(boolean paramBoolean)
  {
    AppMethodBeat.i(105199);
    Object localObject2 = this.RmS;
    Object localObject1 = ((com.tencent.mm.view.d.a)localObject2).RpG;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject1).setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      ((com.tencent.mm.view.d.a)localObject2).RpF.setBackgroundResource(2131232140);
      AppMethodBeat.o(105199);
      return;
    }
    localObject1 = ((com.tencent.mm.view.d.a)localObject2).RpF;
    Object localObject3 = ((com.tencent.mm.view.d.a)localObject2).RpF;
    p.h(localObject3, "$this$getAttrResId");
    localObject2 = new TypedValue();
    localObject3 = ((View)localObject3).getContext();
    p.g(localObject3, "context");
    ((Context)localObject3).getTheme().resolveAttribute(2130968988, (TypedValue)localObject2, true);
    ((View)localObject1).setBackgroundResource(((TypedValue)localObject2).resourceId);
    AppMethodBeat.o(105199);
  }
  
  public void setShowSend(boolean paramBoolean)
  {
    AppMethodBeat.i(105198);
    this.RmS.setShowSend(paramBoolean);
    AppMethodBeat.o(105198);
  }
  
  public void setShowSmiley(boolean paramBoolean)
  {
    this.RmS.RpK.gYg = paramBoolean;
  }
  
  public void setShowStore(boolean paramBoolean)
  {
    AppMethodBeat.i(105197);
    this.RmS.setShowStore(paramBoolean);
    AppMethodBeat.o(105197);
  }
  
  public void setTalkerName(String paramString)
  {
    AppMethodBeat.i(105205);
    com.tencent.mm.view.d.a locala = this.RmS;
    locala.rgD = paramString;
    locala.RpE.haD = paramString;
    if ((Util.isNullOrNil(paramString)) || ((!as.bjp(paramString)) && (!com.tencent.mm.model.ab.Iy(paramString)))) {}
    for (boolean bool = true;; bool = false)
    {
      if (locala.RpK.gYi != bool)
      {
        locala.RpK.gYi = bool;
        locala.RpL.avu();
      }
      if ((as.bju(locala.rgD)) && (locala.RpK.gYk))
      {
        locala.RpK.gYk = false;
        locala.RpL.avu();
      }
      AppMethodBeat.o(105205);
      return;
    }
  }
  
  public void setToSendText(String paramString)
  {
    this.RmS.rgH = paramString;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(105204);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      localObject = this.RmS;
      Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onResume: ");
      ((com.tencent.mm.view.d.a)localObject).isResume = true;
      ((com.tencent.mm.view.d.a)localObject).RpK.avt();
      if (((com.tencent.mm.view.d.a)localObject).RpO != null) {
        ((com.tencent.mm.view.d.a)localObject).RpO.avu();
      }
      if (((com.tencent.mm.view.d.a)localObject).har != null) {
        ((com.tencent.mm.view.d.a)localObject).har.eP(((com.tencent.mm.view.d.a)localObject).RpN);
      }
      if (((com.tencent.mm.view.d.a)localObject).isResume)
      {
        if ((Util.isEqual(((com.tencent.mm.view.d.a)localObject).RpA, ad.avD())) && (((com.tencent.mm.view.d.a)localObject).RpK.gYl)) {
          com.tencent.mm.plugin.report.service.h.CyF.a(15982, new Object[] { Integer.valueOf(0) });
        }
        com.tencent.mm.emoji.c.d locald = com.tencent.mm.emoji.c.d.hcj;
        com.tencent.mm.emoji.c.d.pl(1);
        if (((com.tencent.mm.view.d.a)localObject).RpS != null)
        {
          localObject = ((com.tencent.mm.view.d.a)localObject).RpS.rgF;
          if (((com.tencent.mm.plugin.emoji.ui.c)localObject).rgP.hasFocus()) {
            ((com.tencent.mm.plugin.emoji.ui.c)localObject).rgP.awC();
          }
        }
      }
      AppMethodBeat.o(105204);
      return;
    }
    Object localObject = this.RmS;
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onPause: ");
    ((com.tencent.mm.view.d.a)localObject).isResume = false;
    ((com.tencent.mm.view.d.a)localObject).RpR.clear();
    AppMethodBeat.o(105204);
  }
  
  public final void zN(boolean paramBoolean)
  {
    AppMethodBeat.i(199828);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSmiley: %B, hideEmojiSmiley: %B", new Object[] { Boolean.valueOf(paramBoolean), Boolean.FALSE });
    AppMethodBeat.o(199828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.SmileyPanelImpl
 * JD-Core Version:    0.7.0.1
 */