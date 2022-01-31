package com.tencent.mm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.ca.a.b;
import com.tencent.mm.plugin.l.a.e;
import com.tencent.mm.plugin.l.a.f;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import com.tencent.mm.view.e.a.2;
import com.tencent.mm.view.e.a.6;
import com.tencent.mm.view.e.a.a;
import com.tencent.mm.view.f.a.1;
import java.util.ArrayList;
import java.util.Iterator;

public class SmileyPanelImpl
  extends SmileyPanel
  implements a.a
{
  private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanel";
  private boolean hvi = false;
  private com.tencent.mm.view.e.a wvP;
  private com.tencent.mm.view.f.a wvQ;
  
  public SmileyPanelImpl(Context paramContext)
  {
    super(paramContext, null);
    init();
  }
  
  public SmileyPanelImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    this.wvQ = new com.tencent.mm.view.f.a();
    this.wvP = new com.tencent.mm.view.e.a(getContext(), this.wvQ, this);
  }
  
  public final void aN(boolean paramBoolean)
  {
    y.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSendButton:B", new Object[] { Boolean.valueOf(paramBoolean) });
    this.wvP.oe(paramBoolean);
    this.wvQ.wzL = true;
  }
  
  public final void destroy()
  {
    y.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onDestroy");
    this.rZs = null;
    Object localObject;
    if (this.wvP != null)
    {
      y.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "ui clear");
      localObject = this.wvP;
      ((com.tencent.mm.view.e.a)localObject).cLM();
      ((com.tencent.mm.view.e.a)localObject).hxz = null;
      if (((com.tencent.mm.view.e.a)localObject).wyK != null) {
        ((com.tencent.mm.view.e.a)localObject).wyK.setAdapter(null);
      }
      y.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager destroy remove listener.");
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().i(((com.tencent.mm.view.e.a)localObject).wzc);
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().g(((com.tencent.mm.view.e.a)localObject).uBw);
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().k(((com.tencent.mm.view.e.a)localObject).wze);
      com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.view.e.a)localObject).uBx);
      ((com.tencent.mm.view.e.a)localObject).wzd.dead();
      ((com.tencent.mm.view.e.a)localObject).xwi.dismiss();
      this.wvP = null;
    }
    if (this.wvQ != null)
    {
      y.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "stg clear");
      this.wvQ.onPause();
      localObject = this.wvQ;
      Iterator localIterator = ((com.tencent.mm.view.f.a)localObject).wzR.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.view.c.a locala = (com.tencent.mm.view.c.a)localIterator.next();
        if (locala != null)
        {
          locala.wvQ = null;
          locala.wyA = null;
        }
      }
      ((com.tencent.mm.view.f.a)localObject).cMe();
    }
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().onDestroy();
  }
  
  public int getBottomHeightPx()
  {
    return this.wvQ.wzw;
  }
  
  public j getSmileyPanelCallback()
  {
    return (j)this.rZt;
  }
  
  public ChatFooterPanel.a getTextOpListener()
  {
    return this.rZs;
  }
  
  public final void i(boolean paramBoolean1, boolean paramBoolean2)
  {
    y.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSmiley: %B, hideEmojiSmiley: %B", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.wvQ.wzH = paramBoolean1;
    this.wvQ.wzI = paramBoolean2;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.hvi)
    {
      setVisibility(8);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public final void onPause()
  {
    y.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onPause");
    this.wvQ.onPause();
  }
  
  public final void onResume()
  {
    y.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onResume");
    Object localObject = this.wvQ;
    ((com.tencent.mm.view.f.a)localObject).wzK = true;
    ((com.tencent.mm.view.f.a)localObject).cMf();
    ((com.tencent.mm.view.f.a)localObject).cLW();
    localObject = this.wvP;
    if ((((com.tencent.mm.view.e.a)localObject).wyL != null) && (((com.tencent.mm.view.e.a)localObject).wyK != null)) {
      ((com.tencent.mm.view.e.a)localObject).wyL.aw(((com.tencent.mm.view.e.a)localObject).wyK.getCurrentItem(), true);
    }
    ((com.tencent.mm.view.e.a)localObject).cLO();
    ((com.tencent.mm.view.e.a)localObject).cLQ();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void refresh()
  {
    y.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "reflesh");
    try
    {
      if (this.wvQ != null)
      {
        if (this.wvP == null) {
          return;
        }
        this.wvP.cLR();
        return;
      }
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.emoji.SmileyPanel.SmileyPanel", localException, "", new Object[0]);
    }
  }
  
  public void setCallback(f paramf)
  {
    super.setCallback(paramf);
  }
  
  public void setDefaultEmojiByDetail(String paramString)
  {
    com.tencent.mm.view.f.a locala = this.wvQ;
    locala.setShowProductId(paramString);
    locala.cLV();
    if (locala.wzU == null) {
      locala.wzU = new a.1(locala);
    }
    y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "add succeed send listener");
    com.tencent.mm.sdk.b.a.udP.c(locala.wzU);
  }
  
  public void setEntranceScene(int paramInt)
  {
    if (this.wvQ != null) {
      this.wvQ.fzn = paramInt;
    }
  }
  
  public void setHide(boolean paramBoolean)
  {
    this.hvi = paramBoolean;
  }
  
  public void setPortHeightPx(int paramInt)
  {
    y.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "setPortHeightPx: %d", new Object[] { Integer.valueOf(paramInt) });
    this.wvQ.adN = 0;
    com.tencent.mm.view.f.a locala = this.wvQ;
    if (locala.wzw != paramInt)
    {
      locala.wzQ = false;
      locala.wzP = false;
    }
    locala.wzw = paramInt;
    this.wvQ.cLV();
    this.wvQ.IU(paramInt - this.wvQ.wzm);
    this.wvQ.hxV = 0;
  }
  
  public void setSendButtonEnable(boolean paramBoolean)
  {
    com.tencent.mm.view.e.a locala = this.wvP;
    if (locala.wyU != null) {
      locala.wyU.setEnabled(paramBoolean);
    }
  }
  
  public void setShowProductId(String paramString)
  {
    this.wvQ.setShowProductId(paramString);
  }
  
  public void setTalkerName(String paramString)
  {
    this.wvQ.seQ = paramString;
  }
  
  public void setVisibility(int paramInt)
  {
    int i = 0;
    super.setVisibility(paramInt);
    com.tencent.mm.view.e.a locala;
    Object localObject;
    if (paramInt == 0)
    {
      this.hvi = false;
      if (this.wvP != null)
      {
        locala = this.wvP;
        y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initView begin");
        if (this != null)
        {
          if ((locala.mView == null) || (getChildCount() <= 0)) {
            break label229;
          }
          y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "already load view --- pass");
          if ((locala.wyL != null) && (locala.wyK != null))
          {
            locala.wyL.aw(locala.wyK.getCurrentItem(), true);
            localObject = locala.wvQ.afc(String.valueOf(EmojiGroupInfo.uCR));
            if ((localObject != null) && (((com.tencent.mm.view.c.a)localObject).hxB == locala.wyK.getCurrentItem()) && (locala.wvQ.fzn == ChatFooterPanel.rZv) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHu()))
            {
              com.tencent.mm.plugin.report.service.h.nFQ.f(15982, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
              locala.wyK.post(new a.2(locala));
            }
          }
          locala.cLL();
        }
      }
    }
    for (;;)
    {
      return;
      label229:
      if (locala.wvQ == null)
      {
        y.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "mPanelStg is null");
        return;
      }
      locala.wvQ.wzV = false;
      if (locala.mView == null)
      {
        locala.mView = View.inflate(locala.ze, a.f.smiley_panel_main, null);
        locala.wyK = ((SmileyPanelViewPager)locala.findViewById(a.e.smiley_panel_view_pager));
        locala.wyK.setPanelStg(locala.wvQ);
        locala.wyK.setSmileyPanelViewPagerLayoutListener(locala);
        locala.wyK.setOnPageChangeListener(locala);
        locala.wyK.setOffscreenPageLimit(3);
        locala.wvQ.hxV = locala.wyK.getWidth();
        locala.wyM = ((SmileyPanelScrollView)locala.findViewById(a.e.smiley_panel_dot));
        locala.wyM.setOnPageSelectListener(locala);
        locala.wyM.setSmileyPanelStg(locala.wvQ);
        locala.wyN = ((HorizontalListViewV2)locala.findViewById(a.e.smiley_list_view));
        locala.wyO = new com.tencent.mm.view.a.h(locala.hxz, locala.wvQ);
        locala.wyN.setAdapter(locala.wyO);
        locala.wyN.setOnItemClickListener(locala.wzf);
        locala.wyU = ((TextView)locala.findViewById(a.e.send_btn));
        locala.wyQ = ((ImageView)locala.findViewById(a.e.right_store_btn));
        locala.wyQ.setOnClickListener(locala);
        locala.wyP = locala.findViewById(a.e.right_stoe_btn_container);
        locala.wyR = ((ImageView)locala.findViewById(a.e.right_store_btn_new));
        locala.wyU.setOnClickListener(locala);
        localObject = locala.wyU;
        if (!locala.wvQ.cLZ()) {
          break label741;
        }
        paramInt = 0;
        label513:
        ((TextView)localObject).setVisibility(paramInt);
        addView(locala.mView, new LinearLayout.LayoutParams(-1, -1));
        locala.wvQ.wzV = true;
        localObject = locala.wyP;
        if ((!locala.wvQ.wzF) && (!locala.wvQ.wzG)) {
          break label747;
        }
        paramInt = 8;
        label573:
        ((View)localObject).setVisibility(paramInt);
        locala.wyT = ((ImageButton)locala.findViewById(a.e.hide_panel_btn));
        locala.wyT.setOnClickListener(locala);
        localObject = locala.wyT;
        if ((!locala.wvQ.wzG) || ((locala.wvQ.fzn != ChatFooterPanel.rZw) && (locala.wvQ.fzn != ChatFooterPanel.rZx))) {
          break label752;
        }
        paramInt = 0;
        label645:
        ((ImageButton)localObject).setVisibility(paramInt);
        locala.xwh = ((ImageView)locala.findViewById(a.e.settings_emoji_manager));
        localObject = locala.xwh;
        if ((locala.wvQ.fzn != ChatFooterPanel.rZv) || (locala.wvQ.wzG)) {
          break label758;
        }
      }
      label741:
      label747:
      label752:
      label758:
      for (paramInt = i;; paramInt = 8)
      {
        ((ImageView)localObject).setVisibility(paramInt);
        locala.xwh.setOnClickListener(locala);
        return;
        if (locala.mView.getParent() == null) {
          break;
        }
        ((ViewGroup)locala.mView.getParent()).removeView(locala.mView);
        break;
        paramInt = 8;
        break label513;
        paramInt = 0;
        break label573;
        paramInt = 8;
        break label645;
      }
      y.w("MicroMsg.emoji.SmileyPanel.SmileyPanel", "Smiley Panel Manager is null.");
      return;
      if (this.wvQ != null) {
        this.wvQ.cMe();
      }
      while (this.wvP != null)
      {
        this.wvP.xwi.dismiss();
        return;
        y.w("MicroMsg.emoji.SmileyPanel.SmileyPanel", "Smiley PanelStg Manager is null.");
      }
    }
  }
  
  public final void si()
  {
    y.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "dealOrientationChange");
    this.wvP.wvQ.adN = 0;
  }
  
  public final void sj()
  {
    this.rZs = null;
  }
  
  public final void sk()
  {
    y.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideCustomBtn, %s", new Object[] { bk.csb() });
    this.wvQ.wzF = true;
  }
  
  public final void sl()
  {
    y.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "[hideDefaultBtn]");
    this.wvQ.wzG = true;
  }
  
  public final void sm()
  {
    Object localObject;
    if (this.wvP != null)
    {
      localObject = this.wvP;
      if ((((com.tencent.mm.view.e.a)localObject).wyK != null) && (((com.tencent.mm.view.e.a)localObject).wvQ != null)) {
        break label48;
      }
    }
    for (;;)
    {
      if (this.wvQ != null)
      {
        com.tencent.mm.ca.a.cpp();
        localObject = com.tencent.mm.ca.a.uaN;
        a.b.YJ("TAG_DEFAULT_TAB");
      }
      return;
      label48:
      if (!((com.tencent.mm.view.e.a)localObject).wyY)
      {
        ((com.tencent.mm.view.e.a)localObject).wyZ = "TAG_DEFAULT_TAB";
      }
      else
      {
        ((com.tencent.mm.view.e.a)localObject).wyZ = null;
        ((com.tencent.mm.view.e.a)localObject).wyK.post(new a.6((com.tencent.mm.view.e.a)localObject, "TAG_DEFAULT_TAB"));
      }
    }
  }
  
  public final void sn()
  {
    this.wvQ.wzN = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.SmileyPanelImpl
 * JD-Core Version:    0.7.0.1
 */