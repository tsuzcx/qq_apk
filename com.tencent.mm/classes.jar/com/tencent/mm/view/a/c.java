package com.tencent.mm.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.as.a.c.l;
import com.tencent.mm.ca.a.c;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.l.a.d;
import com.tencent.mm.plugin.l.a.f;
import com.tencent.mm.plugin.l.a.g;
import com.tencent.mm.plugin.l.a.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;

public final class c
  extends a
{
  private static l erY = new c.3();
  private static com.tencent.mm.as.a.c.d jcQ = new c.2();
  ArrayList<EmojiInfo> jeL;
  private com.tencent.mm.as.a.c.e wwP = new c.1(this);
  
  public c(Context paramContext, com.tencent.mm.view.f.a parama)
  {
    super(paramContext, parama);
  }
  
  private EmojiInfo pW(int paramInt)
  {
    int i = this.wwL * this.wwK + paramInt;
    paramInt = i;
    if (this.wvI == 25)
    {
      paramInt = i;
      if (this.wvS.fzn != ChatFooterPanel.rZw)
      {
        paramInt = i;
        if (this.wvS.fzn != ChatFooterPanel.rZx) {
          paramInt = i - 1;
        }
      }
    }
    if ((this.jeL == null) || (paramInt < 0) || (paramInt >= this.jeL.size())) {
      return null;
    }
    return (EmojiInfo)this.jeL.get(paramInt);
  }
  
  public final int getCount()
  {
    if (this.wwL == this.wvK - 1)
    {
      int j = this.dsr - this.wwL * this.wwK;
      int i = j;
      if (j < 0) {
        i = 0;
      }
      return i;
    }
    return this.wwK;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = com.tencent.mm.ui.y.gt(this.mContext).inflate(a.f.smiley_grid_item_l, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.wvS.getColumnWidth(), this.wvS.wzp));
      paramViewGroup = new c.a(this, paramView);
      paramView.setTag(paramViewGroup);
      if ((this.wvI != 25) || (this.wwL != 0) || (paramInt != 0) || (this.wvS.fzn == ChatFooterPanel.rZw) || (this.wvS.fzn == ChatFooterPanel.rZx)) {
        break label331;
      }
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHr().a("", paramViewGroup.gSx);
      if (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHu()) {
        break label284;
      }
      paramViewGroup.gSx.setImageResource(a.g.emoji_add_entrance);
      label170:
      paramViewGroup.gSx.setContentDescription(paramView.getContext().getString(a.h.settings_emoji_manager));
      int i = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().fc(false);
      com.tencent.mm.ca.a.cpp();
      localObject1 = com.tencent.mm.ca.a.uaO;
      if (!((h)com.tencent.mm.kernel.g.DM().Dr()).Ex()) {
        break label307;
      }
      paramInt = bk.getInt(com.tencent.mm.m.g.AA().getValue("CustomEmojiMaxSize"), 150);
      label247:
      if (i <= paramInt) {
        break label320;
      }
      paramViewGroup.wwR.setVisibility(0);
      paramViewGroup.wwR.setText(a.h.emoji_over_size);
    }
    label284:
    label307:
    label320:
    label331:
    do
    {
      return paramView;
      paramViewGroup = (c.a)paramView.getTag();
      break;
      paramViewGroup.gSx.setBackgroundResource(a.d.app_panel_shade);
      paramViewGroup.gSx.setImageResource(a.g.app_panel_setting_icon);
      break label170;
      paramInt = ((a.c)localObject1).getInt("EmotionRecommandCount", 3);
      break label247;
      paramViewGroup.wwR.setVisibility(8);
      return paramView;
      paramViewGroup.wwR.setVisibility(8);
      localObject1 = pW(paramInt);
      if (localObject1 == null)
      {
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.smiley.EmojiSmileyAdapter", "emoji is null.");
        paramViewGroup.gSx.setVisibility(8);
        paramViewGroup.eXP.setVisibility(8);
        ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHr().a("", paramViewGroup.gSx);
        return paramView;
      }
      paramViewGroup.gSx.setVisibility(0);
      localObject2 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().Aw(((EmojiInfo)localObject1).Wv());
      if ((!bk.bl((String)localObject2)) && (this.wvI == 23))
      {
        paramViewGroup.eXP.setText((CharSequence)localObject2);
        paramViewGroup.eXP.setVisibility(0);
      }
      for (;;)
      {
        paramViewGroup.gSx.setBackgroundResource(a.d.smiley_item_bg2);
        if (this.wvI != 25) {
          break label900;
        }
        if ((((EmojiInfo)localObject1).field_catalog != EmojiGroupInfo.uCR) && (((EmojiInfo)localObject1).field_catalog != EmojiInfo.uCY) && (((EmojiInfo)localObject1).field_catalog != EmojiInfo.uCX)) {
          break label700;
        }
        localObject1 = ((EmojiInfo)localObject1).getName();
        if (bk.bl((String)localObject1)) {
          break label689;
        }
        localObject1 = ((String)localObject1).replaceAll(".png", "");
        localObject2 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHr();
        localObject3 = paramViewGroup.gSx;
        locala = new com.tencent.mm.as.a.a.c.a();
        locala.erk = 3;
        locala.ery = a.d.smiley_item_bg2;
        ((com.tencent.mm.as.a.a)localObject2).a((String)localObject1, (ImageView)localObject3, locala.OV());
        if (!((String)localObject1).equalsIgnoreCase("dice")) {
          break;
        }
        paramViewGroup.gSx.setContentDescription(paramView.getContext().getString(a.h.emoji_dice));
        return paramView;
        paramViewGroup.eXP.setVisibility(8);
      }
    } while (!((String)localObject1).equalsIgnoreCase("jsb"));
    paramViewGroup.gSx.setContentDescription(paramView.getContext().getString(a.h.emoji_jsb));
    return paramView;
    label689:
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.smiley.EmojiSmileyAdapter", "name is null");
    return paramView;
    label700:
    Object localObject2 = ((EmojiInfo)localObject1).cwL();
    Object localObject3 = (String)localObject2 + "_cover";
    com.tencent.mm.as.a.a.c.a locala = new com.tencent.mm.as.a.a.c.a();
    locala.erk = 1;
    locala.ery = a.d.smiley_item_bg2;
    locala.err = true;
    locala.thumbPath = ((String)localObject3);
    locala.erh = ((String)localObject2);
    locala.ers = true;
    locala.erJ = new Object[] { localObject1 };
    locala.erH = true;
    Object localObject1 = locala.OV();
    if (((h)com.tencent.mm.kernel.g.DM().Dr()).Ex())
    {
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHr().a((String)localObject2, paramViewGroup.gSx, (com.tencent.mm.as.a.a.c)localObject1, this.wwP, jcQ, erY);
      return paramView;
    }
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHr().a((String)localObject2, paramViewGroup.gSx, (com.tencent.mm.as.a.a.c)localObject1, null, jcQ, erY);
    return paramView;
    label900:
    if (((EmojiInfo)localObject1).field_groupId.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.uCQ)))
    {
      if (!bk.bl(((EmojiInfo)localObject1).getName()))
      {
        if (bk.bl(((EmojiInfo)localObject1).getContent())) {}
        for (localObject1 = ((EmojiInfo)localObject1).getName();; localObject1 = ((EmojiInfo)localObject1).getContent())
        {
          localObject1 = ((String)localObject1).replaceAll(".png", "");
          localObject2 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHr();
          paramViewGroup = paramViewGroup.gSx;
          localObject3 = new com.tencent.mm.as.a.a.c.a();
          ((com.tencent.mm.as.a.a.c.a)localObject3).erk = 3;
          ((com.tencent.mm.as.a.a.c.a)localObject3).ery = a.d.smiley_item_bg2;
          ((com.tencent.mm.as.a.a)localObject2).a((String)localObject1, paramViewGroup, ((com.tencent.mm.as.a.a.c.a)localObject3).OV());
          return paramView;
        }
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.smiley.EmojiSmileyAdapter", "name is null");
      return paramView;
    }
    localObject2 = ((EmojiInfo)localObject1).cwL();
    localObject3 = (String)localObject2 + "_cover";
    locala = new com.tencent.mm.as.a.a.c.a();
    locala.erk = 1;
    locala.ery = a.d.smiley_item_bg2;
    locala.err = true;
    locala.thumbPath = ((String)localObject3);
    locala.erh = ((String)localObject2);
    locala.ers = true;
    locala.erJ = new Object[] { localObject1 };
    locala.erH = true;
    localObject1 = locala.OV();
    if (((h)com.tencent.mm.kernel.g.DM().Dr()).Ex())
    {
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHr().a((String)localObject2, paramViewGroup.gSx, (com.tencent.mm.as.a.a.c)localObject1, this.wwP, jcQ, erY);
      return paramView;
    }
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHr().a((String)localObject2, paramViewGroup.gSx, (com.tencent.mm.as.a.a.c)localObject1, null, jcQ, erY);
    return paramView;
  }
  
  public final boolean pY(int paramInt)
  {
    return (this.wvS.fzn == ChatFooterPanel.rZv) && ((this.wvI != 25) || (this.wwL != 0) || (paramInt != 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.a.c
 * JD-Core Version:    0.7.0.1
 */