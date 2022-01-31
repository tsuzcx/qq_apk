package com.tencent.mm.view.a;

import a.f.b.j;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.pluginsdk.ui.chat.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.view.SmileyGrid;
import com.tencent.mm.view.SmileySubGrid;
import com.tencent.mm.view.f.a.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class i
  extends com.tencent.mm.ui.base.x
{
  com.tencent.mm.view.f.a AQS;
  public boolean ASf;
  public int ASg;
  public boolean ASh;
  public f ASi;
  WeakReference<h> ASj;
  private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter";
  Context mContext;
  public int mCount;
  
  public i(com.tencent.mm.view.f.a parama, Context paramContext)
  {
    this.mContext = paramContext;
    this.AQS = parama;
  }
  
  public final void aM(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(63006);
    this.ASg = paramInt;
    if ((this.ASg != 0) || (paramBoolean))
    {
      this.AQS.dRG();
      if (this.ASj != null)
      {
        h localh = (h)this.ASj.get();
        if (localh != null)
        {
          ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "update at page " + this.ASg);
          localh.update();
        }
        AppMethodBeat.o(63006);
      }
    }
    else
    {
      this.ASh = true;
    }
    AppMethodBeat.o(63006);
  }
  
  public final int getCount()
  {
    return this.mCount;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(63004);
    if (this.ASf)
    {
      ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "get item position always changed");
      AppMethodBeat.o(63004);
      return -2;
    }
    int i = super.getItemPosition(paramObject);
    AppMethodBeat.o(63004);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(63001);
    Object localObject = this.AQS.RO(paramInt);
    String str = ((com.tencent.mm.view.c.a)localObject).liu;
    boolean bool = ((com.tencent.mm.view.c.a)localObject).ATW;
    if ("TAG_DEFAULT_TAB".equals(str)) {
      localObject = a.a.AVu;
    }
    for (;;)
    {
      switch (i.1.ASk[localObject.ordinal()])
      {
      default: 
        paramInt = super.getItemViewType(paramInt);
        AppMethodBeat.o(63001);
        return paramInt;
        if ((String.valueOf(EmojiGroupInfo.yPe).equals(str)) || (String.valueOf(EmojiGroupInfo.yPd).equals(str))) {
          localObject = a.a.AVv;
        } else if (!bool) {
          localObject = a.a.AVt;
        } else if ("capture".equals(str)) {
          localObject = a.a.AVw;
        } else {
          localObject = a.a.AVx;
        }
        break;
      }
    }
    AppMethodBeat.o(63001);
    return 0;
    if ((this.AQS.dRF()) && (paramInt == 0))
    {
      AppMethodBeat.o(63001);
      return 3;
    }
    AppMethodBeat.o(63001);
    return 1;
    AppMethodBeat.o(63001);
    return 4;
    AppMethodBeat.o(63001);
    return 5;
    AppMethodBeat.o(63001);
    return 6;
  }
  
  public final float getPageWidth(int paramInt)
  {
    AppMethodBeat.i(63002);
    if ((this.AQS.dRF()) && (paramInt == 0))
    {
      f = 4.0F / this.AQS.RO(paramInt).uEK;
      AppMethodBeat.o(63002);
      return f;
    }
    float f = super.getPageWidth(paramInt);
    AppMethodBeat.o(63002);
    return f;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(63003);
    int k = getItemViewType(paramInt);
    int i;
    com.tencent.mm.view.c.a locala;
    Object localObject1;
    if ((this.AQS.dRF()) && (paramInt > 0))
    {
      i = paramInt - 1;
      locala = this.AQS.RO(paramInt);
      if (paramView != null) {
        break label261;
      }
      localObject1 = null;
      label48:
      if (!(localObject1 instanceof Integer)) {
        break label2079;
      }
    }
    label152:
    label2079:
    for (int j = ((Integer)localObject1).intValue();; j = -1)
    {
      Object localObject2;
      label180:
      int m;
      if ((paramView == null) || (paramView.getTag() == null) || (j != k)) {
        switch (k)
        {
        case 1: 
        case 2: 
        case 4: 
        default: 
          localObject1 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970765, null);
          paramView = new i.c(this, (View)localObject1, k);
          ((View)localObject1).setTag(paramView);
          ((View)localObject1).setTag(2131820666, Integer.valueOf(k));
          localObject2 = paramView;
          paramView = (View)localObject1;
          localObject1 = localObject2;
          j = this.AQS.avU(locala.liu).ATU;
          m = locala.ATV;
          switch (k)
          {
          }
          break;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(63003);
        return paramView;
        i = paramInt;
        break;
        localObject1 = paramView.getTag(2131820666);
        break label48;
        localObject1 = com.tencent.mm.pluginsdk.ui.chat.e.vYJ.t(this.mContext, com.tencent.mm.sdk.platformtools.x.gN(this.AQS.zF));
        paramView = new i.c(this, (View)localObject1, k);
        break label152;
        localObject1 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970766, null);
        paramView = new i.b(this, (View)localObject1, k);
        break label152;
        localObject1 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130969375, null);
        paramView = new i.a(this, (View)localObject1, k);
        break label152;
        localObject1 = (i.c)paramView.getTag();
        paramView.setTag(2131820666, Integer.valueOf(k));
        break label180;
        ((i.c)localObject1).ASt.setProductID(locala.liu);
        continue;
        if ((localObject1 instanceof i.b))
        {
          localObject1 = (i.b)localObject1;
          paramInt = paramViewGroup.getWidth();
          i = ((i.b)localObject1).ASp.AQS.avU(locala.liu).ATU;
          j = locala.ATV;
          paramViewGroup = (RelativeLayout.LayoutParams)((i.b)localObject1).ASu.getLayoutParams();
          paramViewGroup.width = (paramInt / locala.uEK * 3);
          paramViewGroup.topMargin = j;
          paramViewGroup.height = (((i.b)localObject1).ASp.AQS.AUN * locala.uEJ + (locala.uEJ - 1) * i);
          ((i.b)localObject1).ASu.setLayoutParams(paramViewGroup);
          paramViewGroup = (RelativeLayout.LayoutParams)((i.b)localObject1).ASs.getLayoutParams();
          paramViewGroup.height = j;
          ((i.b)localObject1).ASs.setLayoutParams(paramViewGroup);
          paramViewGroup = (RelativeLayout.LayoutParams)((i.b)localObject1).gqg.getLayoutParams();
          paramViewGroup.leftMargin = (paramInt / locala.uEK / 2);
          paramViewGroup.topMargin = (((i.b)localObject1).ASp.AQS.AUN / 4);
          paramViewGroup.bottomMargin = (((i.b)localObject1).ASp.AQS.AUN / 4);
          ((i.b)localObject1).gqg.setLayoutParams(paramViewGroup);
          paramViewGroup = new h(((i.b)localObject1).ASp.mContext, ((i.b)localObject1).ASp.AQS);
          ((i.b)localObject1).ASu.setAdapter(paramViewGroup);
          ((i.b)localObject1).ASu.setNumColumns(3);
          ((i.b)localObject1).ASu.setColumnWidth(locala.getColumnWidth());
          ((i.b)localObject1).ASu.setVerticalSpacing(i);
          ((i.b)localObject1).ASu.setOnTextOperationListener(locala.ATS.dRm());
          localObject2 = ((i.b)localObject1).ASu;
          ((SmileyGrid)localObject2).setOnItemClickListener(((SmileyGrid)localObject2).AQN);
          ((i.b)localObject1).ASu.setLongClickable(true);
          ((i.b)localObject1).ASu.setIsShowPopWin(true);
          ((i.b)localObject1).ASu.setVerticalScrollBarEnabled(false);
          ((i.b)localObject1).ASu.setScene(((i.b)localObject1).ASp.AQS.mScene);
          ((i.b)localObject1).ASu.setScrollbarFadingEnabled(false);
          ((i.b)localObject1).ASu.setSelector(2130839676);
          ((i.b)localObject1).ASu.setHorizontalScrollBarEnabled(false);
          ((i.b)localObject1).ASu.setViewParent(locala.ATS.AUd);
          paramViewGroup.b(com.tencent.mm.view.f.a.avR(locala.liu), locala.ATT, locala.aRG(), locala.dRf() * locala.uEK, locala.jpL, locala.uEJ, 3);
          paramViewGroup.update();
          ((i.b)localObject1).ASp.ASj = new WeakReference(paramViewGroup);
          continue;
          if ((this.AQS.dRF()) && (paramInt == 1)) {
            this.ASi = new f(this.mContext, this.AQS);
          }
          for (paramViewGroup = this.ASi;; paramViewGroup = new d(this.mContext, this.AQS))
          {
            ((i.c)localObject1).ASu.setAdapter(paramViewGroup);
            ((i.c)localObject1).ASu.dQO();
            ((i.c)localObject1).ASu.setCallback(locala.ATS.getSmileyPanelCallback());
            ((i.c)localObject1).ASu.setOnTextOperationListener(locala.ATS.dRm());
            ((i.c)localObject1).ASu.setNumColumns(locala.uEK);
            ((i.c)localObject1).ASu.setColumnWidth(locala.getColumnWidth());
            ((i.c)localObject1).ASu.setScrollbarFadingEnabled(false);
            ((i.c)localObject1).ASu.setVerticalScrollBarEnabled(false);
            ((i.c)localObject1).ASu.setSelector(2130839676);
            ((i.c)localObject1).ASu.setHorizontalScrollBarEnabled(false);
            ((i.c)localObject1).ASu.setLongClickable(false);
            ((i.c)localObject1).ASu.setViewParent(locala.ATS.AUd);
            ((i.c)localObject1).ASu.setPadding(0, m, 0, 0);
            ((i.c)localObject1).ASu.setVerticalSpacing(j);
            ((i.c)localObject1).ASu.j(com.tencent.mm.view.f.a.avR(locala.liu), i - locala.jpL, locala.ATT, locala.aRG(), locala.dRf());
            ((i.c)localObject1).ASu.setIsShowPopWin(true);
            ((i.c)localObject1).ASu.setScene(this.AQS.mScene);
            paramViewGroup.b(com.tencent.mm.view.f.a.avR(locala.liu), locala.ATT, locala.aRG(), locala.dRf(), i - locala.jpL, locala.uEJ, locala.uEK);
            paramViewGroup.ARO = locala.liu;
            break;
          }
          paramViewGroup = new e(this.mContext, this.AQS);
          ((i.c)localObject1).ASu.setAdapter(paramViewGroup);
          ((i.c)localObject1).ASu.dQO();
          ((i.c)localObject1).ASu.setNumColumns(locala.uEK);
          ((i.c)localObject1).ASu.setColumnWidth(locala.getColumnWidth());
          ((i.c)localObject1).ASu.setScrollbarFadingEnabled(false);
          ((i.c)localObject1).ASu.setHorizontalScrollBarEnabled(false);
          ((i.c)localObject1).ASu.setVerticalScrollBarEnabled(false);
          ((i.c)localObject1).ASu.setCallback(locala.ATS.getSmileyPanelCallback());
          ((i.c)localObject1).ASu.setFastScrollEnabled(false);
          ((i.c)localObject1).ASu.setViewParent(locala.ATS.AUd);
          ((i.c)localObject1).ASu.setPadding(0, m, 0, 0);
          ((i.c)localObject1).ASu.setVerticalSpacing(j / 2);
          ((i.c)localObject1).ASu.setIsShowPopWin(true);
          ((i.c)localObject1).ASu.setScene(this.AQS.mScene);
          ((i.c)localObject1).ASu.j(com.tencent.mm.view.f.a.avR(locala.liu), paramInt - locala.jpL, locala.ATT, locala.aRG(), locala.dRf());
          paramViewGroup.b(com.tencent.mm.view.f.a.avR(locala.liu), locala.ATT, locala.dRe(), locala.dRf(), paramInt - locala.jpL, locala.uEJ, locala.uEK);
          paramViewGroup.ARO = locala.liu;
          if (paramViewGroup.AQI == 23) {
            paramViewGroup.lnB = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().lL(paramViewGroup.ARO);
          } else if (paramViewGroup.AQI == 25) {
            if ((paramViewGroup.AQU != null) && (!bo.isNullOrNil(paramViewGroup.AQU.vVU)) && ((ad.arf(paramViewGroup.AQU.vVU)) || (t.nK(paramViewGroup.AQU.vVU))))
            {
              paramViewGroup.lnB = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().OA();
            }
            else if (ChatFooterPanel.vQp == paramViewGroup.scene)
            {
              paramViewGroup.lnB = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().ch(true);
            }
            else
            {
              paramViewGroup.lnB = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().ch(false);
              continue;
              if ((localObject1 instanceof i.a))
              {
                paramViewGroup = (i.a)localObject1;
                if (paramViewGroup.ASp.AQS.mScene == ChatFooterPanel.vQm) {}
                for (boolean bool = true;; bool = false)
                {
                  localObject1 = com.tencent.mm.emoji.a.d.Oz().ci(bool);
                  if (!bo.es((List)localObject1)) {
                    break label1753;
                  }
                  paramViewGroup.ASu.setVisibility(8);
                  paramViewGroup.ASl.setVisibility(0);
                  break;
                }
                label1753:
                paramViewGroup.ASu.setVisibility(0);
                paramViewGroup.ASl.setVisibility(8);
                i = paramViewGroup.ASp.AQS.avU(locala.liu).ATU;
                j = locala.ATV;
                localObject2 = new b(paramViewGroup.ASp.mContext, paramViewGroup.ASp.AQS);
                paramViewGroup.ASu.setAdapter((ListAdapter)localObject2);
                paramViewGroup.ASu.dQO();
                paramViewGroup.ASu.setNumColumns(locala.uEK);
                paramViewGroup.ASu.setColumnWidth(locala.getColumnWidth());
                paramViewGroup.ASu.setScrollbarFadingEnabled(false);
                paramViewGroup.ASu.setHorizontalScrollBarEnabled(false);
                paramViewGroup.ASu.setVerticalScrollBarEnabled(false);
                paramViewGroup.ASu.setCallback(locala.ATS.getSmileyPanelCallback());
                paramViewGroup.ASu.setViewParent(locala.ATS.AUd);
                paramViewGroup.ASu.setPadding(0, j, 0, 0);
                paramViewGroup.ASu.setVerticalSpacing(i / 2);
                paramViewGroup.ASu.setIsShowPopWin(true);
                paramViewGroup.ASu.setScene(paramViewGroup.ASp.AQS.mScene);
                paramViewGroup.ASu.j(com.tencent.mm.view.f.a.avR(locala.liu), paramInt - locala.jpL, locala.ATT, locala.aRG(), locala.dRf());
                ((b)localObject2).b(com.tencent.mm.view.f.a.avR(locala.liu), locala.ATT, locala.dRe(), locala.dRf(), paramInt - locala.jpL, locala.uEJ, locala.uEK);
                ((a)localObject2).ARO = locala.liu;
                j.q(localObject1, "emoji");
                ((b)localObject2).ARQ.addAll((Collection)localObject1);
              }
            }
          }
        }
      }
    }
  }
  
  public final void refreshData()
  {
    AppMethodBeat.i(63005);
    this.mCount = this.AQS.dRA();
    ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "refresh data mCount:%d", new Object[] { Integer.valueOf(this.mCount) });
    AppMethodBeat.o(63005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.a.i
 * JD-Core Version:    0.7.0.1
 */