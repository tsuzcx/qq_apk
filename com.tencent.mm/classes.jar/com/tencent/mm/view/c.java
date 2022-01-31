package com.tencent.mm.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.ca.a.b;
import com.tencent.mm.emoji.c.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.view.a.i;
import com.tencent.mm.view.e.a.3;
import com.tencent.mm.view.e.a.a;
import com.tencent.mm.view.f.a.1;
import java.util.ArrayList;
import java.util.Iterator;

public final class c
  extends SmileyPanel
  implements a.a
{
  private com.tencent.mm.view.e.a AQR;
  private com.tencent.mm.view.f.a AQS;
  private final String TAG;
  
  public c(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, paramBoolean, (byte)0);
  }
  
  private c(Context paramContext, boolean paramBoolean, byte paramByte) {}
  
  public final void AA()
  {
    AppMethodBeat.i(62932);
    ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "[hideDefaultBtn]");
    this.AQS.AVc = true;
    AppMethodBeat.o(62932);
  }
  
  public final void AB()
  {
    AppMethodBeat.i(151747);
    this.AQR.dRl();
    AppMethodBeat.o(151747);
  }
  
  public final void AC()
  {
    AppMethodBeat.i(62940);
    if (this.AQR != null) {
      this.AQR.atp("TAG_DEFAULT_TAB");
    }
    if (this.AQS != null)
    {
      com.tencent.mm.ca.a.dqM();
      a.b localb = com.tencent.mm.ca.a.yiH;
      a.b.aoG("TAG_DEFAULT_TAB");
    }
    AppMethodBeat.o(62940);
  }
  
  public final void AD()
  {
    this.AQS.AVj = true;
  }
  
  public final void AE()
  {
    AppMethodBeat.i(151746);
    this.AQR.atp(String.valueOf(EmojiGroupInfo.yPe));
    AppMethodBeat.o(151746);
  }
  
  public final void Ay()
  {
    this.vQj = null;
  }
  
  public final void Az()
  {
    AppMethodBeat.i(62931);
    ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideCustomBtn, %s", new Object[] { bo.dtY() });
    this.AQS.AVb = true;
    AppMethodBeat.o(62931);
  }
  
  public final void bo(boolean paramBoolean)
  {
    AppMethodBeat.i(62934);
    ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSendButton:B", new Object[] { Boolean.valueOf(paramBoolean) });
    this.AQR.rO(paramBoolean);
    this.AQS.AVh = true;
    AppMethodBeat.o(62934);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(62927);
    ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onDestroy");
    this.vQj = null;
    Object localObject;
    if (this.AQR != null)
    {
      ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "ui clear");
      localObject = this.AQR;
      ((com.tencent.mm.view.e.a)localObject).dRh();
      ((com.tencent.mm.view.e.a)localObject).jpJ = null;
      if (((com.tencent.mm.view.e.a)localObject).AUd != null) {
        ((com.tencent.mm.view.e.a)localObject).AUd.setAdapter(null);
      }
      ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager destroy remove listener.");
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().g(((com.tencent.mm.view.e.a)localObject).AUv);
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().e(((com.tencent.mm.view.e.a)localObject).yNF);
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().i(((com.tencent.mm.view.e.a)localObject).AUx);
      com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.view.e.a)localObject).yNG);
      com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.view.e.a)localObject).AUw);
      this.AQR = null;
    }
    if (this.AQS != null)
    {
      ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "stg clear");
      if (this.AQS.AHW) {
        this.AQS.onPause();
      }
      localObject = this.AQS;
      Iterator localIterator = ((com.tencent.mm.view.f.a)localObject).AVn.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.view.c.a locala = (com.tencent.mm.view.c.a)localIterator.next();
        if (locala != null)
        {
          locala.AQS = null;
          locala.ATS = null;
        }
      }
      ((com.tencent.mm.view.f.a)localObject).dRC();
    }
    ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().onDestroy();
    AppMethodBeat.o(62927);
  }
  
  public final int getBottomHeightPx()
  {
    return this.AQS.AUR;
  }
  
  public final com.tencent.mm.pluginsdk.ui.chat.j getSmileyPanelCallback()
  {
    return (com.tencent.mm.pluginsdk.ui.chat.j)this.vQk;
  }
  
  public final ChatFooterPanel.a getTextOpListener()
  {
    return this.vQj;
  }
  
  public final void j(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62933);
    ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSmiley: %B, hideEmojiSmiley: %B", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.AQS.AVe = paramBoolean1;
    this.AQS.AVf = paramBoolean2;
    AppMethodBeat.o(62933);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(62926);
    ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onPause");
    this.AQS.onPause();
    AppMethodBeat.o(62926);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(62924);
    ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onResume");
    Object localObject = this.AQS;
    ((com.tencent.mm.view.f.a)localObject).AHW = true;
    ((com.tencent.mm.view.f.a)localObject).dRD();
    ((com.tencent.mm.view.f.a)localObject).dRu();
    localObject = this.AQR;
    if ((((com.tencent.mm.view.e.a)localObject).AUe != null) && (((com.tencent.mm.view.e.a)localObject).AUd != null)) {
      ((com.tencent.mm.view.e.a)localObject).AUe.aM(((com.tencent.mm.view.e.a)localObject).AUd.getCurrentItem(), true);
    }
    ((com.tencent.mm.view.e.a)localObject).dRj();
    AppMethodBeat.o(62924);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(62936);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(62936);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(62930);
    ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "refresh");
    try
    {
      if (this.AQS != null)
      {
        com.tencent.mm.view.e.a locala = this.AQR;
        if (locala != null) {}
      }
      else
      {
        AppMethodBeat.o(62930);
        return;
      }
      this.AQR.dRo();
      AppMethodBeat.o(62930);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.emoji.SmileyPanel.SmileyPanel", localException, "", new Object[0]);
      AppMethodBeat.o(62930);
    }
  }
  
  public final void set16029ExtraInfo(String paramString)
  {
    AppMethodBeat.i(151748);
    com.tencent.mm.emoji.c.c.Pb().extraInfo = paramString;
    AppMethodBeat.o(151748);
  }
  
  public final void setCallback(com.tencent.mm.pluginsdk.ui.chat.f paramf)
  {
    AppMethodBeat.i(62928);
    super.setCallback(paramf);
    AppMethodBeat.o(62928);
  }
  
  public final void setDefaultEmojiByDetail(String paramString)
  {
    AppMethodBeat.i(62938);
    com.tencent.mm.view.f.a locala = this.AQS;
    locala.setShowProductId(paramString);
    locala.dRt();
    if (locala.AVq == null) {
      locala.AVq = new a.1(locala);
    }
    ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "add succeed send listener");
    com.tencent.mm.sdk.b.a.ymk.c(locala.AVq);
    AppMethodBeat.o(62938);
  }
  
  public final void setEntranceScene(int paramInt)
  {
    AppMethodBeat.i(62941);
    com.tencent.mm.emoji.c.c.Pb().scene = paramInt;
    b.Pa().scene = paramInt;
    if (this.AQS != null) {
      this.AQS.mScene = paramInt;
    }
    AppMethodBeat.o(62941);
  }
  
  public final void setPortHeightPx(int paramInt)
  {
    AppMethodBeat.i(62935);
    ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "setPortHeightPx: %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.view.f.a locala = this.AQS;
    if (locala.AUR != paramInt)
    {
      locala.AVm = false;
      locala.AVl = false;
    }
    locala.AUR = paramInt;
    this.AQS.dRt();
    locala = this.AQS;
    locala.RN(paramInt - locala.AUH);
    AppMethodBeat.o(62935);
  }
  
  public final void setSendButtonEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(62929);
    com.tencent.mm.view.e.a locala = this.AQR;
    if (locala.AUm != null) {
      locala.AUm.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(62929);
  }
  
  public final void setShowProductId(String paramString)
  {
    AppMethodBeat.i(62925);
    this.AQS.setShowProductId(paramString);
    AppMethodBeat.o(62925);
  }
  
  public final void setTalkerName(String paramString)
  {
    this.AQS.vVU = paramString;
  }
  
  public final void setVisibility(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(62937);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (this.AQR != null)
      {
        com.tencent.mm.view.e.a locala = this.AQR;
        ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initView begin");
        Object localObject = com.tencent.mm.emoji.c.c.Pb();
        ((com.tencent.mm.emoji.c.c)localObject).exk = System.currentTimeMillis();
        ((com.tencent.mm.emoji.c.c)localObject).clickCount = 0;
        localObject = b.Pa();
        ab.i("EmojiClickReport", "panelShow");
        ((b)localObject).exk = System.currentTimeMillis();
        ((b)localObject).clickCount = 0;
        if ((locala.mView != null) && (getChildCount() > 0))
        {
          ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "already load view --- pass");
          if ((locala.AUe != null) && (locala.AUd != null))
          {
            locala.AUe.aM(locala.AUd.getCurrentItem(), true);
            localObject = locala.AQS.avU("capture");
            if ((localObject != null) && (((com.tencent.mm.view.c.a)localObject).jpL == locala.AUd.getCurrentItem()) && (com.tencent.mm.view.f.a.RR(locala.AQS.mScene)) && (((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().OR()))
            {
              h.qsU.e(15982, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
              com.tencent.mm.cn.d.aNX();
            }
          }
          locala.aRM();
          AppMethodBeat.o(62937);
          return;
        }
        if (locala.AQS == null)
        {
          ab.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "mPanelStg is null");
          AppMethodBeat.o(62937);
          return;
        }
        locala.AQS.AVr = false;
        if (locala.mView == null)
        {
          locala.mView = LayoutInflater.from(getContext()).inflate(2130970764, null);
          locala.AUd = ((SmileyPanelViewPager)locala.findViewById(2131821544));
          locala.AUd.setPanelStg(locala.AQS);
          locala.AUd.setSmileyPanelViewPagerLayoutListener(locala);
          locala.AUd.setOnPageChangeListener(locala);
          locala.AUd.setOffscreenPageLimit(3);
          locala.AQS.jqf = locala.AUd.getWidth();
          locala.AUf = ((SmileyPanelScrollView)locala.findViewById(2131821543));
          locala.AUf.setOnPageSelectListener(locala);
          locala.AUf.setSmileyPanelStg(locala.AQS);
          locala.AUg = ((ScrollRectRecyclerView)locala.findViewById(2131827812));
          locala.AUh = new com.tencent.mm.view.a.j(locala.jpJ, locala.AQS);
          locala.AUh.ASx = locala.AUy;
          locala.AUg.setLayoutManager(new LinearLayoutManager(0));
          locala.AUg.setAdapter(locala.AUh);
          locala.AUg.setItemAnimator(null);
          locala.AUm = ((TextView)locala.findViewById(2131826461));
          locala.AUj = ((ImageView)locala.findViewById(2131827815));
          locala.AUj.setOnClickListener(locala);
          locala.AUi = locala.findViewById(2131827811);
          locala.AUk = ((ImageView)locala.findViewById(2131827816));
          locala.AUm.setOnClickListener(locala);
          localObject = locala.AUm;
          if (!locala.AQS.dRy()) {
            break label906;
          }
          paramInt = 0;
          label579:
          ((TextView)localObject).setVisibility(paramInt);
          addView(locala.mView, new LinearLayout.LayoutParams(-1, -1));
          locala.AQS.AVr = true;
          localObject = locala.AUi;
          if (locala.AQS.mScene != ChatFooterPanel.vQm) {
            break label912;
          }
          paramInt = 0;
          label631:
          ((View)localObject).setVisibility(paramInt);
          locala.AUl = ((ImageButton)locala.findViewById(2131827814));
          locala.AUl.setOnClickListener(locala);
          localObject = locala.AUl;
          if (!locala.AQS.AVc) {
            break label923;
          }
          com.tencent.mm.view.f.a locala1 = locala.AQS;
          if ((locala1.mScene != ChatFooterPanel.vQo) && (locala1.mScene != ChatFooterPanel.vQp) && (locala1.mScene != ChatFooterPanel.vQr) && (locala1.mScene != ChatFooterPanel.vQt) && (locala1.mScene != ChatFooterPanel.vQs) && (locala1.mScene != ChatFooterPanel.vQu) && (locala1.mScene != ChatFooterPanel.vQw) && (locala1.mScene != ChatFooterPanel.vQv)) {
            break label918;
          }
          paramInt = 1;
          label771:
          if (paramInt == 0) {
            break label923;
          }
          paramInt = 0;
          label777:
          ((ImageButton)localObject).setVisibility(paramInt);
          locala.AUn = ((ImageView)locala.findViewById(2131827813));
          localObject = locala.AUn;
          if ((locala.AQS.mScene != ChatFooterPanel.vQm) || (locala.AQS.AVc)) {
            break label929;
          }
        }
        label906:
        label912:
        label918:
        label923:
        label929:
        for (paramInt = i;; paramInt = 8)
        {
          ((ImageView)localObject).setVisibility(paramInt);
          locala.AUn.setOnClickListener(locala);
          if ((bp.dud()) || (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED)) {
            locala.AUn.setOnLongClickListener(new a.3(locala));
          }
          AppMethodBeat.o(62937);
          return;
          if (locala.mView.getParent() == null) {
            break;
          }
          ((ViewGroup)locala.mView.getParent()).removeView(locala.mView);
          break;
          paramInt = 8;
          break label579;
          paramInt = 8;
          break label631;
          paramInt = 0;
          break label771;
          paramInt = 8;
          break label777;
        }
      }
      ab.w("MicroMsg.emoji.SmileyPanel.SmileyPanel", "Smiley Panel Manager is null.");
      AppMethodBeat.o(62937);
      return;
    }
    if (this.AQS != null)
    {
      this.AQS.dRC();
      AppMethodBeat.o(62937);
      return;
    }
    ab.w("MicroMsg.emoji.SmileyPanel.SmileyPanel", "Smiley PanelStg Manager is null.");
    AppMethodBeat.o(62937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.view.c
 * JD-Core Version:    0.7.0.1
 */