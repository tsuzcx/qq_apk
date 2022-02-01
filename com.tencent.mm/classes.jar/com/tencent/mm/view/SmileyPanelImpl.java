package com.tencent.mm.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.cc.a.b;
import com.tencent.mm.emoji.c.b.ah;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.emoji.d.c;
import com.tencent.mm.emoji.panel.a.ab;
import com.tencent.mm.emoji.panel.a.ad.b;
import com.tencent.mm.emoji.panel.a.o;
import com.tencent.mm.plugin.m.a.c;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.m.a.f;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.widget.pulldown.NestedBounceView;
import com.tencent.mm.view.manager.a.6;
import java.util.Iterator;
import kotlin.g.b.s;

public class SmileyPanelImpl
  extends SmileyPanel
  implements p
{
  private final String TAG;
  private boolean aUP;
  public final com.tencent.mm.view.manager.a agJZ;
  private boolean agKa;
  
  public SmileyPanelImpl(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, paramBoolean, (byte)0);
  }
  
  private SmileyPanelImpl(Context paramContext, boolean paramBoolean, byte paramByte) {}
  
  public final void JA(boolean paramBoolean)
  {
    AppMethodBeat.i(234817);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSmiley: %B, hideEmojiSmiley: %B", new Object[] { Boolean.valueOf(paramBoolean), Boolean.FALSE });
    AppMethodBeat.o(234817);
  }
  
  public final void Jy(boolean paramBoolean)
  {
    AppMethodBeat.i(234797);
    this.agJZ.Jy(paramBoolean);
    AppMethodBeat.o(234797);
  }
  
  public final void Jz(boolean paramBoolean)
  {
    AppMethodBeat.i(234802);
    this.agJZ.Jz(paramBoolean);
    AppMethodBeat.o(234802);
  }
  
  public final void aBI()
  {
    AppMethodBeat.i(234762);
    this.agJZ.agMK.setBounce(false);
    AppMethodBeat.o(234762);
  }
  
  public final void bDL()
  {
    AppMethodBeat.i(234815);
    this.agJZ.onResume();
    AppMethodBeat.o(234815);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105191);
    if (this.aUP)
    {
      Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "destroy: has destroyed");
      AppMethodBeat.o(105191);
      return;
    }
    this.aUP = true;
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "destroy: ");
    this.XYj = null;
    this.agJZ.agMZ.dead();
    this.agJZ.onDestroy();
    ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().dzF();
    ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider();
    AppMethodBeat.o(105191);
  }
  
  public final void iKg()
  {
    this.XYj = null;
  }
  
  public final void iKh()
  {
    AppMethodBeat.i(105200);
    this.agJZ.Jy(false);
    this.agJZ.Jz(false);
    this.agJZ.setShowStore(false);
    AppMethodBeat.o(105200);
  }
  
  public final void iKi()
  {
    AppMethodBeat.i(169244);
    this.agJZ.setShowSend(false);
    AppMethodBeat.o(169244);
  }
  
  public final void iKj()
  {
    AppMethodBeat.i(105189);
    this.agJZ.aGb(0);
    AppMethodBeat.o(105189);
  }
  
  @z(Ho=j.a.ON_DESTROY)
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
    com.tencent.mm.view.manager.a locala = this.agJZ;
    if (locala.agMD)
    {
      Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "listener added %s", new Object[] { locala });
      AppMethodBeat.o(105192);
      return;
    }
    locala.agMD = true;
    ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().k(locala.agMV);
    ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().i(locala.adjP);
    locala.adjQ.alive();
    locala.agMW.alive();
    com.tencent.mm.emoji.sync.g.aWn().a(locala.agNa);
    com.tencent.mm.emoji.sync.g.aWo().a(locala.agNa);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager add listener. %s", new Object[] { locala });
    AppMethodBeat.o(105192);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(105193);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onDetachedFromWindow");
    this.agJZ.removeListener();
    AppMethodBeat.o(105193);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(105190);
    Log.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onPause");
    ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().dzF();
    Object localObject = this.agJZ;
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "saveSelectedTab: %s", new Object[] { ((com.tencent.mm.view.manager.a)localObject).agMC });
    l locall = l.aUF();
    locall.mhW = ((com.tencent.mm.view.manager.a)localObject).agMC;
    if (MMApplicationContext.isMainProcess())
    {
      com.tencent.mm.kernel.h.baE().ban().B(-29414086, locall.mhW);
      AppMethodBeat.o(105190);
      return;
    }
    com.tencent.mm.cc.a.iRg();
    localObject = com.tencent.mm.cc.a.aclv;
    a.b.btU(locall.mhW);
    AppMethodBeat.o(105190);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(105188);
    Log.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onResume");
    if (!this.agKa)
    {
      this.agKa = true;
      this.agJZ.aNi();
    }
    AppMethodBeat.o(105188);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105203);
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onSizeChanged: %s, %s; %s, %s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    com.tencent.mm.view.manager.a locala;
    ViewGroup.LayoutParams localLayoutParams;
    if (this.agJZ != null)
    {
      locala = this.agJZ;
      locala.GHc.rI(paramInt1);
      locala.agMS.rI(paramInt1);
      locala.agMN.miI = locala.GHc.spanCount;
      paramInt3 = locala.context.getResources().getDimensionPixelSize(a.e.emoji_panel_tab_height_min);
      localLayoutParams = locala.agMJ.getLayoutParams();
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
        locala.agMJ.setLayoutParams(localLayoutParams);
        locala.agMJ.post(new a.6(locala));
      }
      c.aWb().mmq = locala.GHc.spanCount;
      com.tencent.mm.emoji.d.h.aWe().mmq = locala.agMS.spanCount;
      AppMethodBeat.o(105203);
      return;
    }
  }
  
  public void set16029ExtraInfo(String paramString)
  {
    AppMethodBeat.i(105208);
    com.tencent.mm.emoji.d.h.aWe().extraInfo = paramString;
    AppMethodBeat.o(105208);
  }
  
  public void setCallback(com.tencent.mm.pluginsdk.ui.chat.f paramf)
  {
    AppMethodBeat.i(105194);
    super.setCallback(paramf);
    com.tencent.mm.view.manager.a locala = this.agJZ;
    paramf = (com.tencent.mm.pluginsdk.ui.chat.j)paramf;
    locala.mpu = paramf;
    locala.agMG.mkP = paramf;
    AppMethodBeat.o(105194);
  }
  
  public void setDefaultEmojiByDetail(String paramString)
  {
    AppMethodBeat.i(105206);
    this.agJZ.bzP(paramString);
    this.agJZ.agMZ.alive();
    AppMethodBeat.o(105206);
  }
  
  public void setEntranceScene(int paramInt)
  {
    AppMethodBeat.i(105207);
    com.tencent.mm.view.manager.a locala = this.agJZ;
    com.tencent.mm.emoji.d.h.aWe().scene = paramInt;
    c.aWb().scene = paramInt;
    com.tencent.mm.emoji.d.g localg = com.tencent.mm.emoji.d.g.mmw;
    com.tencent.mm.emoji.d.g.setScene(paramInt);
    int i = locala.agMN.scene;
    locala.agMN.scene = paramInt;
    locala.agMN.miE = com.tencent.mm.emoji.c.b.i.rA(paramInt);
    locala.agMN.miC = com.tencent.mm.emoji.c.b.i.rB(paramInt);
    if (i != paramInt) {
      locala.agMO.aVl();
    }
    locala.agMG.scene = paramInt;
    AppMethodBeat.o(105207);
  }
  
  public void setOnTextOperationListener(ChatFooterPanel.a parama)
  {
    AppMethodBeat.i(105195);
    super.setOnTextOperationListener(parama);
    com.tencent.mm.view.manager.a locala = this.agJZ;
    locala.mkD = parama;
    locala.agMG.mkD = parama;
    locala.agMF.mkD = parama;
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
    Object localObject = this.agJZ.agMN;
    ((com.tencent.mm.emoji.c.b.i)localObject).miH = paramBoolean;
    localObject = ((Iterable)((com.tencent.mm.emoji.c.b.i)localObject).miJ).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((kotlin.g.a.a)((Iterator)localObject).next()).invoke();
    }
    AppMethodBeat.o(105196);
  }
  
  public void setShowClose(boolean paramBoolean)
  {
    AppMethodBeat.i(105199);
    Object localObject2 = this.agJZ;
    Object localObject1 = ((com.tencent.mm.view.manager.a)localObject2).agMI;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject1).setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      ((com.tencent.mm.view.manager.a)localObject2).agMH.setBackgroundResource(a.f.emoji_panel_tab_bg_corner);
      AppMethodBeat.o(105199);
      return;
    }
    localObject1 = ((com.tencent.mm.view.manager.a)localObject2).agMH;
    localObject2 = ((com.tencent.mm.view.manager.a)localObject2).agMH;
    i = a.c.emojiPanelTabColor;
    s.u(localObject2, "<this>");
    TypedValue localTypedValue = new TypedValue();
    ((View)localObject2).getContext().getTheme().resolveAttribute(i, localTypedValue, true);
    ((View)localObject1).setBackgroundResource(localTypedValue.resourceId);
    AppMethodBeat.o(105199);
  }
  
  public void setShowGame(boolean paramBoolean)
  {
    AppMethodBeat.i(234800);
    com.tencent.mm.view.manager.a locala = this.agJZ;
    if (paramBoolean != locala.agMN.miB) {}
    for (int i = 1;; i = 0)
    {
      locala.agMN.miB = paramBoolean;
      if (i != 0) {
        locala.agMO.aVl();
      }
      AppMethodBeat.o(234800);
      return;
    }
  }
  
  public void setShowSearch(boolean paramBoolean)
  {
    AppMethodBeat.i(234813);
    if (!((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
    {
      this.agJZ.setShowSearch(paramBoolean);
      AppMethodBeat.o(234813);
      return;
    }
    this.agJZ.setShowSearch(false);
    AppMethodBeat.o(234813);
  }
  
  public void setShowSend(boolean paramBoolean)
  {
    AppMethodBeat.i(105198);
    this.agJZ.setShowSend(paramBoolean);
    AppMethodBeat.o(105198);
  }
  
  public void setShowSmiley(boolean paramBoolean)
  {
    AppMethodBeat.i(234792);
    com.tencent.mm.view.manager.a locala = this.agJZ;
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "setShowSmiley: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    locala.agMN.miz = paramBoolean;
    AppMethodBeat.o(234792);
  }
  
  public void setShowStore(boolean paramBoolean)
  {
    AppMethodBeat.i(105197);
    this.agJZ.setShowStore(paramBoolean);
    AppMethodBeat.o(105197);
  }
  
  public void setTalkerName(String paramString)
  {
    AppMethodBeat.i(105205);
    com.tencent.mm.view.manager.a locala = this.agJZ;
    locala.mpr = paramString;
    locala.agMG.mkQ = paramString;
    if ((Util.isNullOrNil(paramString)) || ((!au.bwO(paramString)) && (!au.bwF(paramString)))) {}
    for (boolean bool = true;; bool = false)
    {
      if (locala.agMN.miB != bool)
      {
        locala.agMN.miB = bool;
        locala.agMO.aVl();
      }
      if ((au.bwW(locala.mpr)) && (locala.agMN.miD))
      {
        locala.agMN.miD = false;
        locala.agMO.aVl();
      }
      AppMethodBeat.o(105205);
      return;
    }
  }
  
  public void setToSendText(String paramString)
  {
    this.agJZ.mps = paramString;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(105204);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.agJZ.onResume();
      AppMethodBeat.o(105204);
      return;
    }
    com.tencent.mm.view.manager.a locala = this.agJZ;
    Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onPause: ");
    locala.isResume = false;
    locala.GHd.clear();
    AppMethodBeat.o(105204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.SmileyPanelImpl
 * JD-Core Version:    0.7.0.1
 */