package com.tencent.mm.search.d;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.aj;
import com.tencent.mm.emoji.c.b.h;
import com.tencent.mm.emoji.panel.a.aa;
import com.tencent.mm.emoji.panel.a.g;
import com.tencent.mm.emoji.panel.a.q;
import com.tencent.mm.emoji.panel.a.w;
import com.tencent.mm.emoji.panel.a.x;
import com.tencent.mm.emoji.panel.a.y;
import com.tencent.mm.emoji.panel.a.z;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.eng;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/search/ui/SimilarEmojiAdapter;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "()V", "gifAutoPlay", "", "maxBindViewPosition", "", "getMaxBindViewPosition", "()I", "setMaxBindViewPosition", "(I)V", "showHeadTip", "getGifAutoPlay", "getItemViewType", "position", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setBottomData", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setData", "list", "", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "setEmptyData", "setGifAutoPlay", "play", "setHeaderData", "setLoadData", "setShowHeadTip", "show", "setWebSearchHeaderData", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends g
{
  public static final a.a acsl;
  public boolean acsm;
  public boolean mlE = true;
  public int xSC;
  
  static
  {
    AppMethodBeat.i(105869);
    acsl = new a.a((byte)0);
    AppMethodBeat.o(105869);
  }
  
  public final void G(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105860);
    s.u(paramEmojiInfo, "emojiInfo");
    a(0, (ae)new h(paramEmojiInfo, 100));
    AppMethodBeat.o(105860);
  }
  
  public final void H(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(236878);
    s.u(paramEmojiInfo, "emojiInfo");
    a(0, (ae)new h(paramEmojiInfo, 107));
    AppMethodBeat.o(236878);
  }
  
  public final void I(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105861);
    s.u(paramEmojiInfo, "emojiInfo");
    a(getItemCount(), (ae)new aj(101));
    AppMethodBeat.o(105861);
  }
  
  public final void a(q<?> paramq, int paramInt)
  {
    AppMethodBeat.i(105866);
    s.u(paramq, "holder");
    if (getItemViewType(paramInt) == 100) {
      ((y)paramq).mlC = this.acsm;
    }
    if (getItemViewType(paramInt) == 103) {
      ((z)paramq).mlE = this.mlE;
    }
    if (getItemViewType(paramInt) == 102) {
      ((z)paramq).mlE = this.mlE;
    }
    if (paramInt > this.xSC) {
      this.xSC = paramInt;
    }
    super.a(paramq, paramInt);
    AppMethodBeat.o(105866);
  }
  
  public final q<?> f(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(105864);
    s.u(paramViewGroup, "parent");
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    case 102: 
    default: 
      paramViewGroup = localLayoutInflater.inflate(a.h.similar_emoji_panel_item_emoji, paramViewGroup, false);
      s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new z(paramViewGroup, this.mlE, this.mkY);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 100: 
      paramViewGroup = localLayoutInflater.inflate(a.h.similar_emoji_panel_item_head, paramViewGroup, false);
      s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new y(paramViewGroup, this.acsm, this.mkY);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 101: 
      paramViewGroup = localLayoutInflater.inflate(a.h.similar_emoji_panel_item_bottom, paramViewGroup, false);
      s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new w(paramViewGroup, this.mkY);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 103: 
      paramViewGroup = localLayoutInflater.inflate(a.h.similar_emoji_panel_item_emoji_white_bg, paramViewGroup, false);
      s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new z(paramViewGroup, this.mlE, this.mkY);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 104: 
      paramViewGroup = localLayoutInflater.inflate(a.h.similar_emoji_load_more_view, paramViewGroup, false);
      s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new w(paramViewGroup, null);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 106: 
      paramViewGroup = localLayoutInflater.inflate(a.h.similar_emoji_panel_full_page, paramViewGroup, false);
      s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new x(paramViewGroup, a.g.result_tv);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 105: 
      paramViewGroup = localLayoutInflater.inflate(a.h.similar_emoji_panel_full_page, paramViewGroup, false);
      s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new x(paramViewGroup, a.g.load_progress);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    }
    paramViewGroup = localLayoutInflater.inflate(a.h.similar_emoji_panel_websearch_head, paramViewGroup, false);
    s.s(paramViewGroup, "itemView");
    paramViewGroup = (q)new aa(paramViewGroup);
    AppMethodBeat.o(105864);
    return paramViewGroup;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(105868);
    if (rH(paramInt) == null)
    {
      AppMethodBeat.o(105868);
      return 100;
    }
    if ((rH(paramInt) instanceof h))
    {
      localObject = rH(paramInt);
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
        AppMethodBeat.o(105868);
        throw ((Throwable)localObject);
      }
      paramInt = ((h)localObject).miu;
      AppMethodBeat.o(105868);
      return paramInt;
    }
    Object localObject = rH(paramInt);
    s.checkNotNull(localObject);
    paramInt = ((ae)localObject).type;
    AppMethodBeat.o(105868);
    return paramInt;
  }
  
  public final void iTE()
  {
    AppMethodBeat.i(105862);
    a(getItemCount(), (ae)new aj(105));
    AppMethodBeat.o(105862);
  }
  
  public final void iTF()
  {
    AppMethodBeat.i(105863);
    a(getItemCount(), (ae)new aj(106));
    AppMethodBeat.o(105863);
  }
  
  public final void setData(List<? extends eng> paramList)
  {
    AppMethodBeat.i(105859);
    s.u(paramList, "list");
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      eng localeng = (eng)((Iterator)localObject).next();
      EmojiInfo localEmojiInfo = new EmojiInfo();
      d.a(localeng.abrK, localEmojiInfo, localeng.abrL);
      if ((localeng.type & 0x1) == 0) {
        localEmojiInfo.akmd = 1;
      }
      if (((localeng.type & 0x1) == 0) && ((localeng.type & 0x10) == 0)) {
        localEmojiInfo.pay = 1;
      }
      localEmojiInfo.field_catalog = EmojiInfo.aklG;
      localEmojiInfo.field_groupId = localeng.abrK.ProductID;
      paramList.add(new h(localEmojiInfo, 102));
    }
    bz((List)paramList);
    AppMethodBeat.o(105859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.d.a
 * JD-Core Version:    0.7.0.1
 */