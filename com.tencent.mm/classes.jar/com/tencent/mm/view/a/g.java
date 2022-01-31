package com.tencent.mm.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.l.a.d;
import com.tencent.mm.plugin.l.a.e;
import com.tencent.mm.plugin.l.a.f;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.pluginsdk.ui.chat.e.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.view.SmileyGrid;
import com.tencent.mm.view.SmileySubGrid;
import com.tencent.mm.view.f.a.a;
import java.lang.ref.WeakReference;

public final class g
  extends w
{
  private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter";
  Context mContext;
  public int mCount;
  com.tencent.mm.view.f.a wvQ;
  public boolean wwX;
  public int wwY;
  public boolean wwZ;
  public d wxa;
  WeakReference<f> wxb;
  
  public g(com.tencent.mm.view.f.a parama, Context paramContext)
  {
    this.mContext = paramContext;
    this.wvQ = parama;
  }
  
  public final int F(Object paramObject)
  {
    if (this.wwX)
    {
      y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "get item position always changed");
      return -2;
    }
    return super.F(paramObject);
  }
  
  public final void aw(int paramInt, boolean paramBoolean)
  {
    this.wwY = paramInt;
    if ((this.wwY != 0) || (paramBoolean))
    {
      this.wvQ.cMi();
      if (this.wxb != null)
      {
        f localf = (f)this.wxb.get();
        if (localf != null)
        {
          y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "update at page " + this.wwY);
          localf.update();
        }
      }
      return;
    }
    this.wwZ = true;
  }
  
  public final float ax(int paramInt)
  {
    if ((this.wvQ.cMh()) && (paramInt == 0)) {
      return 4.0F / this.wvQ.IV(paramInt).qPC;
    }
    return super.ax(paramInt);
  }
  
  public final void cLz()
  {
    com.tencent.mm.view.f.a locala = this.wvQ;
    if (locala.wzF) {}
    for (int i = locala.afc("TAG_DEFAULT_TAB").cLI();; i = locala.kih)
    {
      this.mCount = i;
      y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "refresh data mCount:%d", new Object[] { Integer.valueOf(this.mCount) });
      return;
    }
  }
  
  public final int getCount()
  {
    return this.mCount;
  }
  
  public final int getItemViewType(int paramInt)
  {
    Object localObject = this.wvQ.IV(paramInt);
    String str = ((com.tencent.mm.view.c.a)localObject).iZD;
    boolean bool = ((com.tencent.mm.view.c.a)localObject).wyE;
    if ("TAG_DEFAULT_TAB".equals(str)) {
      localObject = a.a.wzY;
    }
    for (;;)
    {
      switch (g.1.wxc[localObject.ordinal()])
      {
      default: 
        return super.getItemViewType(paramInt);
        if ((String.valueOf(EmojiGroupInfo.uCR).equals(str)) || (String.valueOf(EmojiGroupInfo.uCQ).equals(str))) {
          localObject = a.a.wzZ;
        } else if (!bool) {
          localObject = a.a.wzX;
        } else {
          localObject = a.a.wzZ;
        }
        break;
      }
    }
    return 0;
    if ((this.wvQ.cMh()) && (paramInt == 0)) {
      return 3;
    }
    return 1;
    return 2;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int k = getItemViewType(paramInt);
    int i;
    com.tencent.mm.view.c.a locala;
    Object localObject1;
    if ((this.wvQ.cMh()) && (paramInt > 0))
    {
      i = paramInt - 1;
      locala = this.wvQ.IV(paramInt);
      if (paramView != null) {
        break label236;
      }
      localObject1 = null;
      label43:
      if (!(localObject1 instanceof Integer)) {
        break label1573;
      }
    }
    label141:
    label1573:
    for (int j = ((Integer)localObject1).intValue();; j = -1)
    {
      Object localObject2;
      label170:
      int m;
      if ((paramView == null) || (paramView.getTag() == null) || (j != k)) {
        switch (k)
        {
        case 1: 
        case 2: 
        default: 
          localObject1 = LayoutInflater.from(this.mContext).inflate(a.f.smiley_panel_middle_page, null);
          paramView = new g.b(this, (View)localObject1, k);
          ((View)localObject1).setTag(paramView);
          ((View)localObject1).setTag(a.e.smiley_panel_id, Integer.valueOf(k));
          localObject2 = paramView;
          paramView = (View)localObject1;
          localObject1 = localObject2;
          j = this.wvQ.afc(locala.iZD).wyC;
          m = locala.wyD;
          switch (k)
          {
          }
          break;
        }
      }
      label236:
      do
      {
        do
        {
          return paramView;
          i = paramInt;
          break;
          localObject1 = paramView.getTag(a.e.smiley_panel_id);
          break label43;
          localObject1 = com.tencent.mm.pluginsdk.ui.chat.e.sgs.q(this.mContext, this.wvQ.cMd());
          paramView = new g.b(this, (View)localObject1, k);
          break label141;
          localObject1 = LayoutInflater.from(this.mContext).inflate(a.f.smiley_panel_recent_page, null);
          paramView = new g.a(this, (View)localObject1, k);
          break label141;
          localObject1 = (g.b)paramView.getTag();
          paramView.setTag(a.e.smiley_panel_id, Integer.valueOf(k));
          break label170;
          ((g.b)localObject1).wxf.setProductID(locala.iZD);
          return paramView;
        } while (!(localObject1 instanceof g.a));
        localObject1 = (g.a)localObject1;
        paramInt = paramViewGroup.getWidth();
        i = ((g.a)localObject1).wxe.wvQ.afc(locala.iZD).wyC;
        j = locala.wyD;
        paramViewGroup = (RelativeLayout.LayoutParams)((g.a)localObject1).wxg.getLayoutParams();
        paramViewGroup.width = (paramInt / locala.qPC * 3);
        paramViewGroup.topMargin = j;
        paramViewGroup.height = (((g.a)localObject1).wxe.wvQ.wzs * locala.qPB + (locala.qPB - 1) * i);
        ((g.a)localObject1).wxg.setLayoutParams(paramViewGroup);
        paramViewGroup = (RelativeLayout.LayoutParams)((g.a)localObject1).wxd.getLayoutParams();
        paramViewGroup.height = j;
        ((g.a)localObject1).wxd.setLayoutParams(paramViewGroup);
        paramViewGroup = (RelativeLayout.LayoutParams)((g.a)localObject1).eYp.getLayoutParams();
        paramViewGroup.leftMargin = (paramInt / locala.qPC / 2);
        paramViewGroup.topMargin = (((g.a)localObject1).wxe.wvQ.wzs / 4);
        paramViewGroup.bottomMargin = (((g.a)localObject1).wxe.wvQ.wzs / 4);
        ((g.a)localObject1).eYp.setLayoutParams(paramViewGroup);
        paramViewGroup = new f(((g.a)localObject1).wxe.mContext, ((g.a)localObject1).wxe.wvQ);
        ((g.a)localObject1).wxg.setAdapter(paramViewGroup);
        ((g.a)localObject1).wxg.setNumColumns(3);
        ((g.a)localObject1).wxg.setColumnWidth(locala.getColumnWidth());
        ((g.a)localObject1).wxg.setVerticalSpacing(i);
        ((g.a)localObject1).wxg.setOnTextOperationListener(locala.cLJ());
        localObject2 = ((g.a)localObject1).wxg;
        ((SmileyGrid)localObject2).setOnItemClickListener(((SmileyGrid)localObject2).wvN);
        ((g.a)localObject1).wxg.setLongClickable(true);
        ((g.a)localObject1).wxg.setIsShowPopWin(true);
        ((g.a)localObject1).wxg.setVerticalScrollBarEnabled(false);
        ((g.a)localObject1).wxg.setScene(((g.a)localObject1).wxe.wvQ.fzn);
        ((g.a)localObject1).wxg.setScrollbarFadingEnabled(false);
        ((g.a)localObject1).wxg.setSelector(a.d.mm_trans);
        ((g.a)localObject1).wxg.setHorizontalScrollBarEnabled(false);
        ((g.a)localObject1).wxg.setViewParent(locala.wyA.wyK);
        paramViewGroup.b(locala.getType(), locala.wyB, locala.asD(), locala.cLI() * locala.qPC, locala.hxB, locala.qPB, 3);
        paramViewGroup.update();
        ((g.a)localObject1).wxe.wxb = new WeakReference(paramViewGroup);
        return paramView;
        if ((this.wvQ.cMh()) && (paramInt == 1)) {
          this.wxa = new d(this.mContext, this.wvQ);
        }
        for (paramViewGroup = this.wxa;; paramViewGroup = new b(this.mContext, this.wvQ))
        {
          ((g.b)localObject1).wxg.setAdapter(paramViewGroup);
          ((g.b)localObject1).wxg.cLw();
          ((g.b)localObject1).wxg.setCallback(locala.getSmileyPanelCallback());
          ((g.b)localObject1).wxg.setOnTextOperationListener(locala.cLJ());
          ((g.b)localObject1).wxg.setNumColumns(locala.qPC);
          ((g.b)localObject1).wxg.setColumnWidth(locala.getColumnWidth());
          ((g.b)localObject1).wxg.setScrollbarFadingEnabled(false);
          ((g.b)localObject1).wxg.setVerticalScrollBarEnabled(false);
          ((g.b)localObject1).wxg.setSelector(a.d.mm_trans);
          ((g.b)localObject1).wxg.setHorizontalScrollBarEnabled(false);
          ((g.b)localObject1).wxg.setLongClickable(false);
          ((g.b)localObject1).wxg.setViewParent(locala.wyA.wyK);
          ((g.b)localObject1).wxg.setPadding(0, m, 0, 0);
          ((g.b)localObject1).wxg.setVerticalSpacing(j);
          ((g.b)localObject1).wxg.i(locala.getType(), i - locala.hxB, locala.wyB, locala.asD(), locala.cLI());
          ((g.b)localObject1).wxg.setIsShowPopWin(true);
          ((g.b)localObject1).wxg.setScene(this.wvQ.fzn);
          paramViewGroup.b(locala.getType(), locala.wyB, locala.asD(), locala.cLI(), i - locala.hxB, locala.qPB, locala.qPC);
          paramViewGroup.wwM = locala.iZD;
          return paramView;
        }
        paramViewGroup = new c(this.mContext, this.wvQ);
        ((g.b)localObject1).wxg.setAdapter(paramViewGroup);
        ((g.b)localObject1).wxg.cLw();
        ((g.b)localObject1).wxg.setNumColumns(locala.qPC);
        ((g.b)localObject1).wxg.setColumnWidth(locala.getColumnWidth());
        ((g.b)localObject1).wxg.setScrollbarFadingEnabled(false);
        ((g.b)localObject1).wxg.setHorizontalScrollBarEnabled(false);
        ((g.b)localObject1).wxg.setVerticalScrollBarEnabled(false);
        ((g.b)localObject1).wxg.setCallback(locala.getSmileyPanelCallback());
        ((g.b)localObject1).wxg.setFastScrollEnabled(false);
        ((g.b)localObject1).wxg.setViewParent(locala.wyA.wyK);
        ((g.b)localObject1).wxg.cLw();
        ((g.b)localObject1).wxg.setPadding(0, m, 0, 0);
        ((g.b)localObject1).wxg.setVerticalSpacing(j / 2);
        ((g.b)localObject1).wxg.setIsShowPopWin(true);
        ((g.b)localObject1).wxg.setScene(this.wvQ.fzn);
        ((g.b)localObject1).wxg.i(locala.getType(), paramInt - locala.hxB, locala.wyB, locala.asD(), locala.cLI());
        i = locala.getType();
        j = locala.wyB;
        k = locala.qPB;
        paramViewGroup.b(i, j, locala.qPC * k, locala.cLI(), paramInt - locala.hxB, locala.qPB, locala.qPC);
        paramViewGroup.wwM = locala.iZD;
        if (paramViewGroup.wvI == 23)
        {
          paramViewGroup.jeL = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().AF(paramViewGroup.wwM);
          return paramView;
        }
      } while (paramViewGroup.wvI != 25);
      if ((paramViewGroup.wvS != null) && (!bk.bl(paramViewGroup.wvS.seQ)) && ((ad.aaU(paramViewGroup.wvS.seQ)) || (s.hb(paramViewGroup.wvS.seQ))))
      {
        paramViewGroup.jeL = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHq();
        return paramView;
      }
      paramViewGroup.jeL = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHp();
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.a.g
 * JD-Core Version:    0.7.0.1
 */