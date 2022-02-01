package com.tencent.mm.search.d;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.b.b.aj;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.panel.a.aa;
import com.tencent.mm.emoji.panel.a.ab;
import com.tencent.mm.emoji.panel.a.ac;
import com.tencent.mm.emoji.panel.a.i;
import com.tencent.mm.emoji.panel.a.s;
import com.tencent.mm.emoji.panel.a.y;
import com.tencent.mm.emoji.panel.a.z;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.dui;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/search/ui/SimilarEmojiAdapter;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "()V", "gifAutoPlay", "", "maxBindViewPosition", "", "getMaxBindViewPosition", "()I", "setMaxBindViewPosition", "(I)V", "showHeadTip", "getGifAutoPlay", "getItemViewType", "position", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setBottomData", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setData", "list", "", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "setEmptyData", "setGifAutoPlay", "play", "setHeaderData", "setLoadData", "setShowHeadTip", "show", "setWebSearchHeaderData", "Companion", "plugin-emojisdk_release"})
public final class a
  extends i
{
  public static final a UXd;
  public boolean UXc;
  public boolean jMH = true;
  public int uJL;
  
  static
  {
    AppMethodBeat.i(105869);
    UXd = new a((byte)0);
    AppMethodBeat.o(105869);
  }
  
  public final void G(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105860);
    p.k(paramEmojiInfo, "emojiInfo");
    a(0, (ae)new h(paramEmojiInfo, 100));
    AppMethodBeat.o(105860);
  }
  
  public final void H(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(240159);
    p.k(paramEmojiInfo, "emojiInfo");
    a(0, (ae)new h(paramEmojiInfo, 107));
    AppMethodBeat.o(240159);
  }
  
  public final void I(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105861);
    p.k(paramEmojiInfo, "emojiInfo");
    a(getItemCount(), (ae)new aj(101));
    AppMethodBeat.o(105861);
  }
  
  public final void a(s<?> params, int paramInt)
  {
    AppMethodBeat.i(105866);
    p.k(params, "holder");
    if (getItemViewType(paramInt) == 100) {
      ((aa)params).jMD = this.UXc;
    }
    if (getItemViewType(paramInt) == 103) {
      ((ab)params).jMH = this.jMH;
    }
    if (getItemViewType(paramInt) == 102) {
      ((ab)params).jMH = this.jMH;
    }
    if (paramInt > this.uJL) {
      this.uJL = paramInt;
    }
    super.a(params, paramInt);
    AppMethodBeat.o(105866);
  }
  
  public final s<?> f(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(105864);
    p.k(paramViewGroup, "parent");
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    case 102: 
    default: 
      paramViewGroup = localLayoutInflater.inflate(a.h.similar_emoji_panel_item_emoji, paramViewGroup, false);
      p.j(paramViewGroup, "itemView");
      paramViewGroup = (s)new ab(paramViewGroup, this.jMH, this.jLP);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 100: 
      paramViewGroup = localLayoutInflater.inflate(a.h.similar_emoji_panel_item_head, paramViewGroup, false);
      p.j(paramViewGroup, "itemView");
      paramViewGroup = (s)new aa(paramViewGroup, this.UXc, this.jLP);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 101: 
      paramViewGroup = localLayoutInflater.inflate(a.h.similar_emoji_panel_item_bottom, paramViewGroup, false);
      p.j(paramViewGroup, "itemView");
      paramViewGroup = (s)new y(paramViewGroup, this.jLP);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 103: 
      paramViewGroup = localLayoutInflater.inflate(a.h.similar_emoji_panel_item_emoji_white_bg, paramViewGroup, false);
      p.j(paramViewGroup, "itemView");
      paramViewGroup = (s)new ab(paramViewGroup, this.jMH, this.jLP);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 104: 
      paramViewGroup = localLayoutInflater.inflate(a.h.similar_emoji_load_more_view, paramViewGroup, false);
      p.j(paramViewGroup, "itemView");
      paramViewGroup = (s)new y(paramViewGroup, null);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 106: 
      paramViewGroup = localLayoutInflater.inflate(a.h.similar_emoji_panel_full_page, paramViewGroup, false);
      p.j(paramViewGroup, "itemView");
      paramViewGroup = (s)new z(paramViewGroup, a.g.result_tv);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 105: 
      paramViewGroup = localLayoutInflater.inflate(a.h.similar_emoji_panel_full_page, paramViewGroup, false);
      p.j(paramViewGroup, "itemView");
      paramViewGroup = (s)new z(paramViewGroup, a.g.load_progress);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    }
    paramViewGroup = localLayoutInflater.inflate(a.h.similar_emoji_panel_websearch_head, paramViewGroup, false);
    p.j(paramViewGroup, "itemView");
    paramViewGroup = (s)new ac(paramViewGroup);
    AppMethodBeat.o(105864);
    return paramViewGroup;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(105868);
    if (rF(paramInt) == null)
    {
      AppMethodBeat.o(105868);
      return 100;
    }
    if ((rF(paramInt) instanceof h))
    {
      localObject = rF(paramInt);
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
        AppMethodBeat.o(105868);
        throw ((Throwable)localObject);
      }
      paramInt = ((h)localObject).jJc;
      AppMethodBeat.o(105868);
      return paramInt;
    }
    Object localObject = rF(paramInt);
    if (localObject == null) {
      p.iCn();
    }
    paramInt = ((ae)localObject).type;
    AppMethodBeat.o(105868);
    return paramInt;
  }
  
  public final void htA()
  {
    AppMethodBeat.i(105863);
    a(getItemCount(), (ae)new aj(106));
    AppMethodBeat.o(105863);
  }
  
  public final void htz()
  {
    AppMethodBeat.i(105862);
    a(getItemCount(), (ae)new aj(105));
    AppMethodBeat.o(105862);
  }
  
  public final void setData(List<? extends dui> paramList)
  {
    AppMethodBeat.i(105859);
    p.k(paramList, "list");
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      dui localdui = (dui)((Iterator)localObject).next();
      EmojiInfo localEmojiInfo = new EmojiInfo();
      b.a(localdui.UaH, localEmojiInfo, localdui.UaI);
      if ((localdui.type & 0x1) == 0) {
        localEmojiInfo.ZuP = 1;
      }
      if (((localdui.type & 0x1) == 0) && ((localdui.type & 0x10) == 0)) {
        localEmojiInfo.ZuO = 1;
      }
      localEmojiInfo.field_catalog = EmojiInfo.YCx;
      localEmojiInfo.field_groupId = localdui.UaH.ProductID;
      paramList.add(new h(localEmojiInfo, 102));
    }
    aa((List)paramList);
    AppMethodBeat.o(105859);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/search/ui/SimilarEmojiAdapter$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.search.d.a
 * JD-Core Version:    0.7.0.1
 */