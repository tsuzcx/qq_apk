package com.tencent.mm.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import androidx.lifecycle.h.a;
import androidx.lifecycle.t;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.ch.a.b;
import com.tencent.mm.emoji.b.b.af;
import com.tencent.mm.emoji.b.b.ah;
import com.tencent.mm.emoji.b.b.am;
import com.tencent.mm.emoji.b.b.i;
import com.tencent.mm.emoji.b.b.n;
import com.tencent.mm.emoji.panel.a.ad;
import com.tencent.mm.emoji.panel.a.af.b;
import com.tencent.mm.emoji.panel.a.q;
import com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.emoji.ui.b;
import com.tencent.mm.plugin.m.a.c;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.m.a.f;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.widget.pulldown.NestedBounceView;
import com.tencent.mm.view.d.a.7;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;

public class SmileyPanelImpl
  extends SmileyPanel
  implements androidx.lifecycle.k
{
  private final String TAG;
  private final com.tencent.mm.view.d.a YOn;
  private boolean YOo;
  private boolean aJQ;
  
  public SmileyPanelImpl(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, paramBoolean, (byte)0);
  }
  
  private SmileyPanelImpl(Context paramContext, boolean paramBoolean, byte paramByte) {}
  
  public final void DS(boolean paramBoolean)
  {
    AppMethodBeat.i(228220);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSmiley: %B, hideEmojiSmiley: %B", new Object[] { Boolean.valueOf(paramBoolean), Boolean.FALSE });
    AppMethodBeat.o(228220);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(228240);
    com.tencent.mm.view.d.a locala = this.YOn;
    com.tencent.mm.emoji.b.b.j localj = locala.YRh;
    p.k(paramn, "externalPanelProvider");
    localj.jJv.add(paramn);
    locala.YRh.aCp();
    AppMethodBeat.o(228240);
  }
  
  public final void bhB()
  {
    AppMethodBeat.i(293013);
    this.YOn.abTh.setBounce(false);
    AppMethodBeat.o(293013);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105191);
    if (this.aJQ)
    {
      Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "destroy: has destroyed");
      AppMethodBeat.o(105191);
      return;
    }
    this.aJQ = true;
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "destroy: ");
    this.Rce = null;
    this.YOn.YRt.dead();
    this.YOn.onDestroy();
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().cUy();
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getProvider();
    AppMethodBeat.o(105191);
  }
  
  public final void hjm()
  {
    this.Rce = null;
  }
  
  public final void hjn()
  {
    AppMethodBeat.i(228209);
    this.YOn.hjn();
    AppMethodBeat.o(228209);
  }
  
  public final void hjo()
  {
    AppMethodBeat.i(228211);
    this.YOn.hjo();
    AppMethodBeat.o(228211);
  }
  
  public final void hjp()
  {
    AppMethodBeat.i(105200);
    this.YOn.hjn();
    this.YOn.hjo();
    this.YOn.setShowStore(false);
    AppMethodBeat.o(105200);
  }
  
  public final void hjq()
  {
    AppMethodBeat.i(169244);
    this.YOn.setShowSend(false);
    AppMethodBeat.o(169244);
  }
  
  public final void hjr()
  {
    AppMethodBeat.i(105189);
    this.YOn.azx(0);
    AppMethodBeat.o(105189);
  }
  
  @t(jl=h.a.ON_DESTROY)
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
    com.tencent.mm.view.d.a locala = this.YOn;
    if (locala.YQX)
    {
      Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "listener added %s", new Object[] { locala });
      AppMethodBeat.o(105192);
      return;
    }
    locala.YQX = true;
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().k(locala.YRp);
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().i(locala.VGb);
    EventCenter.instance.addListener(locala.VGc);
    EventCenter.instance.addListener(locala.YRq);
    com.tencent.mm.emoji.sync.g.aDr().a(locala.YRu);
    com.tencent.mm.emoji.sync.g.aDs().a(locala.YRu);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager add listener. %s", new Object[] { locala });
    AppMethodBeat.o(105192);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(105193);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onDetachedFromWindow");
    this.YOn.removeListener();
    AppMethodBeat.o(105193);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(105190);
    Log.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onPause");
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().cUy();
    Object localObject = this.YOn;
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "saveSelectedTab: %s", new Object[] { ((com.tencent.mm.view.d.a)localObject).YQW });
    com.tencent.mm.emoji.b.k localk = com.tencent.mm.emoji.b.k.aBH();
    localk.jIn = ((com.tencent.mm.view.d.a)localObject).YQW;
    if (MMApplicationContext.isMainProcess())
    {
      com.tencent.mm.kernel.h.aHG().aHp().i(-29414086, localk.jIn);
      AppMethodBeat.o(105190);
      return;
    }
    com.tencent.mm.ch.a.hqW();
    localObject = com.tencent.mm.ch.a.UQl;
    a.b.btV(localk.jIn);
    AppMethodBeat.o(105190);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(105188);
    Log.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onResume");
    if (!this.YOo)
    {
      this.YOo = true;
      com.tencent.mm.view.d.a locala = this.YOn;
      locala.YRh.aCp();
      locala.YRg.aCo();
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
    if (this.YOn != null)
    {
      locala = this.YOn;
      locala.YRm.rG(paramInt1);
      locala.YRl.rG(paramInt1);
      locala.YRg.jJp = locala.YRm.spanCount;
      paramInt3 = locala.context.getResources().getDimensionPixelSize(a.e.emoji_panel_tab_height_min);
      localLayoutParams = locala.YRd.getLayoutParams();
      Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "updateViewSize: %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (paramInt2 >= paramInt3 * 4) {
        break label249;
      }
    }
    label249:
    for (paramInt1 = paramInt3;; paramInt1 = locala.context.getResources().getDimensionPixelSize(a.e.emoji_panel_tab_height))
    {
      if (localLayoutParams.height != paramInt1)
      {
        localLayoutParams.height = paramInt1;
        locala.YRd.setLayoutParams(localLayoutParams);
        locala.YRd.post(new a.7(locala));
      }
      com.tencent.mm.emoji.c.c.aDb().jNr = locala.YRm.spanCount;
      com.tencent.mm.emoji.c.h.aDe().jNr = locala.YRl.spanCount;
      AppMethodBeat.o(105203);
      return;
    }
  }
  
  public void set16029ExtraInfo(String paramString)
  {
    AppMethodBeat.i(105208);
    com.tencent.mm.emoji.c.h.aDe().extraInfo = paramString;
    AppMethodBeat.o(105208);
  }
  
  public void setCallback(com.tencent.mm.pluginsdk.ui.chat.f paramf)
  {
    AppMethodBeat.i(105194);
    super.setCallback(paramf);
    com.tencent.mm.view.d.a locala = this.YOn;
    paramf = (com.tencent.mm.pluginsdk.ui.chat.j)paramf;
    locala.uJR = paramf;
    locala.YRa.jLH = paramf;
    AppMethodBeat.o(105194);
  }
  
  public void setDefaultEmojiByDetail(String paramString)
  {
    AppMethodBeat.i(105206);
    this.YOn.byt(paramString);
    this.YOn.YRt.alive();
    AppMethodBeat.o(105206);
  }
  
  public void setEntranceScene(int paramInt)
  {
    AppMethodBeat.i(105207);
    com.tencent.mm.view.d.a locala = this.YOn;
    com.tencent.mm.emoji.c.h.aDe().scene = paramInt;
    com.tencent.mm.emoji.c.c.aDb().scene = paramInt;
    Object localObject = com.tencent.mm.emoji.c.g.jNx;
    com.tencent.mm.emoji.c.g.setScene(paramInt);
    int i = locala.YRg.scene;
    locala.YRg.scene = paramInt;
    locala.YRg.jJl = i.ry(paramInt);
    locala.YRg.jJj = i.rz(paramInt);
    localObject = locala.YRg;
    if (paramInt == ChatFooterPanel.Rch) {}
    for (boolean bool = true;; bool = false)
    {
      ((i)localObject).jJf = bool;
      if (i != paramInt) {
        locala.YRh.aCp();
      }
      locala.YRa.scene = paramInt;
      AppMethodBeat.o(105207);
      return;
    }
  }
  
  public void setOnTextOperationListener(ChatFooterPanel.a parama)
  {
    AppMethodBeat.i(105195);
    super.setOnTextOperationListener(parama);
    com.tencent.mm.view.d.a locala = this.YOn;
    locala.jLs = parama;
    locala.YRa.jLs = parama;
    locala.YQZ.jLs = parama;
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
    Object localObject = this.YOn.YRg;
    ((i)localObject).jJo = paramBoolean;
    localObject = ((Iterable)((i)localObject).jJq).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((kotlin.g.a.a)((Iterator)localObject).next()).invoke();
    }
    AppMethodBeat.o(105196);
  }
  
  public void setShowClose(boolean paramBoolean)
  {
    AppMethodBeat.i(105199);
    Object localObject2 = this.YOn;
    Object localObject1 = ((com.tencent.mm.view.d.a)localObject2).YRc;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject1).setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      ((com.tencent.mm.view.d.a)localObject2).YRb.setBackgroundResource(a.f.emoji_panel_tab_bg_corner);
      AppMethodBeat.o(105199);
      return;
    }
    localObject1 = ((com.tencent.mm.view.d.a)localObject2).YRb;
    Object localObject3 = ((com.tencent.mm.view.d.a)localObject2).YRb;
    i = a.c.emojiPanelTabColor;
    p.k(localObject3, "$this$getAttrResId");
    localObject2 = new TypedValue();
    localObject3 = ((View)localObject3).getContext();
    p.j(localObject3, "context");
    ((Context)localObject3).getTheme().resolveAttribute(i, (TypedValue)localObject2, true);
    ((View)localObject1).setBackgroundResource(((TypedValue)localObject2).resourceId);
    AppMethodBeat.o(105199);
  }
  
  public void setShowSend(boolean paramBoolean)
  {
    AppMethodBeat.i(105198);
    this.YOn.setShowSend(paramBoolean);
    AppMethodBeat.o(105198);
  }
  
  public void setShowSmiley(boolean paramBoolean)
  {
    AppMethodBeat.i(228208);
    com.tencent.mm.view.d.a locala = this.YOn;
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setShowSmiley: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    locala.YRg.jJg = paramBoolean;
    AppMethodBeat.o(228208);
  }
  
  public void setShowStore(boolean paramBoolean)
  {
    AppMethodBeat.i(105197);
    this.YOn.setShowStore(paramBoolean);
    AppMethodBeat.o(105197);
  }
  
  public void setTalkerName(String paramString)
  {
    AppMethodBeat.i(105205);
    com.tencent.mm.view.d.a locala = this.YOn;
    locala.uJM = paramString;
    locala.YRa.jLI = paramString;
    if ((Util.isNullOrNil(paramString)) || ((!as.bvK(paramString)) && (!ab.PQ(paramString)))) {}
    for (boolean bool = true;; bool = false)
    {
      if (locala.YRg.jJi != bool)
      {
        locala.YRg.jJi = bool;
        locala.YRh.aCp();
      }
      if ((as.bvQ(locala.uJM)) && (locala.YRg.jJk))
      {
        locala.YRg.jJk = false;
        locala.YRh.aCp();
      }
      AppMethodBeat.o(105205);
      return;
    }
  }
  
  public void setToSendText(String paramString)
  {
    this.YOn.uJQ = paramString;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(105204);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      localObject = this.YOn;
      Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onResume: ");
      ((com.tencent.mm.view.d.a)localObject).isResume = true;
      ((com.tencent.mm.view.d.a)localObject).YRg.aCo();
      if (((com.tencent.mm.view.d.a)localObject).YRk != null) {
        ((com.tencent.mm.view.d.a)localObject).YRk.aCp();
      }
      if (((com.tencent.mm.view.d.a)localObject).jLs != null) {
        ((com.tencent.mm.view.d.a)localObject).jLs.eE(((com.tencent.mm.view.d.a)localObject).YRj);
      }
      if (((com.tencent.mm.view.d.a)localObject).isResume)
      {
        if ((Util.isEqual(((com.tencent.mm.view.d.a)localObject).YQW, af.aCy())) && (((com.tencent.mm.view.d.a)localObject).YRg.jJl)) {
          com.tencent.mm.plugin.report.service.h.IzE.a(15982, new Object[] { Integer.valueOf(0) });
        }
        com.tencent.mm.emoji.c.d locald = com.tencent.mm.emoji.c.d.jNt;
        com.tencent.mm.emoji.c.d.rE(1);
        if (((com.tencent.mm.view.d.a)localObject).YRo != null)
        {
          localObject = ((com.tencent.mm.view.d.a)localObject).YRo.uJO;
          if (((com.tencent.mm.plugin.emoji.ui.c)localObject).uJY.hasFocus()) {
            ((com.tencent.mm.plugin.emoji.ui.c)localObject).uJY.aDT();
          }
        }
      }
      AppMethodBeat.o(105204);
      return;
    }
    Object localObject = this.YOn;
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onPause: ");
    ((com.tencent.mm.view.d.a)localObject).isResume = false;
    ((com.tencent.mm.view.d.a)localObject).YRn.clear();
    AppMethodBeat.o(105204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.SmileyPanelImpl
 * JD-Core Version:    0.7.0.1
 */