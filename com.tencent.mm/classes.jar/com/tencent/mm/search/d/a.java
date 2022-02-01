package com.tencent.mm.search.d;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.ad;
import com.tencent.mm.emoji.a.a.y;
import com.tencent.mm.emoji.panel.a.q;
import com.tencent.mm.emoji.panel.a.r;
import com.tencent.mm.emoji.panel.a.s;
import com.tencent.mm.emoji.panel.a.t;
import com.tencent.mm.emoji.panel.a.u;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.protocal.protobuf.cmr;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/search/ui/SimilarEmojiAdapter;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "()V", "gifAutoPlay", "", "maxBindViewPosition", "", "getMaxBindViewPosition", "()I", "setMaxBindViewPosition", "(I)V", "showHeadTip", "getGifAutoPlay", "getItemViewType", "position", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setBottomData", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setData", "list", "", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "setEmptyData", "setGifAutoPlay", "play", "setHeaderData", "setLoadData", "setShowHeadTip", "show", "Companion", "plugin-emojisdk_release"})
public final class a
  extends com.tencent.mm.emoji.panel.a.h
{
  public static final a.a GwG;
  public boolean GwE;
  public int GwF;
  public boolean fUz = true;
  
  static
  {
    AppMethodBeat.i(105869);
    GwG = new a.a((byte)0);
    AppMethodBeat.o(105869);
  }
  
  public final void G(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105860);
    k.h(paramEmojiInfo, "emojiInfo");
    a(0, (y)new com.tencent.mm.emoji.a.a.h(paramEmojiInfo, 100));
    AppMethodBeat.o(105860);
  }
  
  public final void H(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105861);
    k.h(paramEmojiInfo, "emojiInfo");
    a(getItemCount(), (y)new ad(101));
    AppMethodBeat.o(105861);
  }
  
  public final void a(q<?> paramq, int paramInt)
  {
    AppMethodBeat.i(105866);
    k.h(paramq, "holder");
    if (getItemViewType(paramInt) == 100) {
      ((t)paramq).fUv = this.GwE;
    }
    if (getItemViewType(paramInt) == 103) {
      ((u)paramq).fUz = this.fUz;
    }
    if (getItemViewType(paramInt) == 102) {
      ((u)paramq).fUz = this.fUz;
    }
    if (paramInt > this.GwF) {
      this.GwF = paramInt;
    }
    super.a(paramq, paramInt);
    AppMethodBeat.o(105866);
  }
  
  public final q<?> e(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(105864);
    k.h(paramViewGroup, "parent");
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    case 102: 
    default: 
      paramViewGroup = localLayoutInflater.inflate(2131495465, paramViewGroup, false);
      k.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new u(paramViewGroup, this.fUz, this.fUd);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 100: 
      paramViewGroup = localLayoutInflater.inflate(2131495467, paramViewGroup, false);
      k.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new t(paramViewGroup, this.GwE, this.fUd);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 101: 
      paramViewGroup = localLayoutInflater.inflate(2131495464, paramViewGroup, false);
      k.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new r(paramViewGroup, this.fUd);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 103: 
      paramViewGroup = localLayoutInflater.inflate(2131495466, paramViewGroup, false);
      k.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new u(paramViewGroup, this.fUz, this.fUd);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 104: 
      paramViewGroup = localLayoutInflater.inflate(2131495462, paramViewGroup, false);
      k.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new r(paramViewGroup, null);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 106: 
      paramViewGroup = localLayoutInflater.inflate(2131495463, paramViewGroup, false);
      k.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new s(paramViewGroup, 2131304144);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    }
    paramViewGroup = localLayoutInflater.inflate(2131495463, paramViewGroup, false);
    k.g(paramViewGroup, "itemView");
    paramViewGroup = (q)new s(paramViewGroup, 2131301489);
    AppMethodBeat.o(105864);
    return paramViewGroup;
  }
  
  public final void eXb()
  {
    AppMethodBeat.i(105862);
    a(getItemCount(), (y)new ad(105));
    AppMethodBeat.o(105862);
  }
  
  public final void eXc()
  {
    AppMethodBeat.i(105863);
    a(getItemCount(), (y)new ad(106));
    AppMethodBeat.o(105863);
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(105868);
    if (lB(paramInt) == null)
    {
      AppMethodBeat.o(105868);
      return 100;
    }
    if ((lB(paramInt) instanceof com.tencent.mm.emoji.a.a.h))
    {
      localObject = lB(paramInt);
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
        AppMethodBeat.o(105868);
        throw ((Throwable)localObject);
      }
      paramInt = ((com.tencent.mm.emoji.a.a.h)localObject).fRp;
      AppMethodBeat.o(105868);
      return paramInt;
    }
    Object localObject = lB(paramInt);
    if (localObject == null) {
      k.fOy();
    }
    paramInt = ((y)localObject).type;
    AppMethodBeat.o(105868);
    return paramInt;
  }
  
  public final void setData(List<? extends cmr> paramList)
  {
    AppMethodBeat.i(105859);
    k.h(paramList, "list");
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      cmr localcmr = (cmr)((Iterator)localObject).next();
      EmojiInfo localEmojiInfo = new EmojiInfo();
      b.a(localcmr.FzX, localEmojiInfo);
      if ((localcmr.type & 0x1) == 0) {
        localEmojiInfo.Kgp = 1;
      }
      if (((localcmr.type & 0x1) == 0) && ((localcmr.type & 0x10) == 0)) {
        localEmojiInfo.Kgo = 1;
      }
      localEmojiInfo.field_catalog = EmojiInfo.Jss;
      localEmojiInfo.field_groupId = localcmr.FzX.ProductID;
      paramList.add(new com.tencent.mm.emoji.a.a.h(localEmojiInfo, 102));
    }
    U((List)paramList);
    AppMethodBeat.o(105859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.search.d.a
 * JD-Core Version:    0.7.0.1
 */