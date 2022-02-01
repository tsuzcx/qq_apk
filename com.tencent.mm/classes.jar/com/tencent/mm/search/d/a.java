package com.tencent.mm.search.d;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.b.ac;
import com.tencent.mm.emoji.a.b.ah;
import com.tencent.mm.emoji.panel.a.q;
import com.tencent.mm.emoji.panel.a.r;
import com.tencent.mm.emoji.panel.a.s;
import com.tencent.mm.emoji.panel.a.t;
import com.tencent.mm.emoji.panel.a.u;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.protocal.protobuf.cso;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/search/ui/SimilarEmojiAdapter;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "()V", "gifAutoPlay", "", "maxBindViewPosition", "", "getMaxBindViewPosition", "()I", "setMaxBindViewPosition", "(I)V", "showHeadTip", "getGifAutoPlay", "getItemViewType", "position", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setBottomData", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setData", "list", "", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "setEmptyData", "setGifAutoPlay", "play", "setHeaderData", "setLoadData", "setShowHeadTip", "show", "Companion", "plugin-emojisdk_release"})
public final class a
  extends com.tencent.mm.emoji.panel.a.h
{
  public static final a.a ICL;
  public boolean ICJ;
  public int ICK;
  public boolean gqx = true;
  
  static
  {
    AppMethodBeat.i(105869);
    ICL = new a.a((byte)0);
    AppMethodBeat.o(105869);
  }
  
  public final void F(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105860);
    p.h(paramEmojiInfo, "emojiInfo");
    a(0, (ac)new com.tencent.mm.emoji.a.b.h(paramEmojiInfo, 100));
    AppMethodBeat.o(105860);
  }
  
  public final void G(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105861);
    p.h(paramEmojiInfo, "emojiInfo");
    a(getItemCount(), (ac)new ah(101));
    AppMethodBeat.o(105861);
  }
  
  public final void a(q<?> paramq, int paramInt)
  {
    AppMethodBeat.i(105866);
    p.h(paramq, "holder");
    if (getItemViewType(paramInt) == 100) {
      ((t)paramq).gqt = this.ICJ;
    }
    if (getItemViewType(paramInt) == 103) {
      ((u)paramq).gqx = this.gqx;
    }
    if (getItemViewType(paramInt) == 102) {
      ((u)paramq).gqx = this.gqx;
    }
    if (paramInt > this.ICK) {
      this.ICK = paramInt;
    }
    super.a(paramq, paramInt);
    AppMethodBeat.o(105866);
  }
  
  public final q<?> f(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(105864);
    p.h(paramViewGroup, "parent");
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    case 102: 
    default: 
      paramViewGroup = localLayoutInflater.inflate(2131495465, paramViewGroup, false);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new u(paramViewGroup, this.gqx, this.gpR);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 100: 
      paramViewGroup = localLayoutInflater.inflate(2131495467, paramViewGroup, false);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new t(paramViewGroup, this.ICJ, this.gpR);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 101: 
      paramViewGroup = localLayoutInflater.inflate(2131495464, paramViewGroup, false);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new r(paramViewGroup, this.gpR);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 103: 
      paramViewGroup = localLayoutInflater.inflate(2131495466, paramViewGroup, false);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new u(paramViewGroup, this.gqx, this.gpR);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 104: 
      paramViewGroup = localLayoutInflater.inflate(2131495462, paramViewGroup, false);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new r(paramViewGroup, null);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 106: 
      paramViewGroup = localLayoutInflater.inflate(2131495463, paramViewGroup, false);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new s(paramViewGroup, 2131304144);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    }
    paramViewGroup = localLayoutInflater.inflate(2131495463, paramViewGroup, false);
    p.g(paramViewGroup, "itemView");
    paramViewGroup = (q)new s(paramViewGroup, 2131301489);
    AppMethodBeat.o(105864);
    return paramViewGroup;
  }
  
  public final void fqG()
  {
    AppMethodBeat.i(105862);
    a(getItemCount(), (ac)new ah(105));
    AppMethodBeat.o(105862);
  }
  
  public final void fqH()
  {
    AppMethodBeat.i(105863);
    a(getItemCount(), (ac)new ah(106));
    AppMethodBeat.o(105863);
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(105868);
    if (me(paramInt) == null)
    {
      AppMethodBeat.o(105868);
      return 100;
    }
    if ((me(paramInt) instanceof com.tencent.mm.emoji.a.b.h))
    {
      localObject = me(paramInt);
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
        AppMethodBeat.o(105868);
        throw ((Throwable)localObject);
      }
      paramInt = ((com.tencent.mm.emoji.a.b.h)localObject).gnk;
      AppMethodBeat.o(105868);
      return paramInt;
    }
    Object localObject = me(paramInt);
    if (localObject == null) {
      p.gkB();
    }
    paramInt = ((ac)localObject).type;
    AppMethodBeat.o(105868);
    return paramInt;
  }
  
  public final void setData(List<? extends cso> paramList)
  {
    AppMethodBeat.i(105859);
    p.h(paramList, "list");
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      cso localcso = (cso)((Iterator)localObject).next();
      EmojiInfo localEmojiInfo = new EmojiInfo();
      b.a(localcso.HDL, localEmojiInfo);
      if ((localcso.type & 0x1) == 0) {
        localEmojiInfo.OAs = 1;
      }
      if (((localcso.type & 0x1) == 0) && ((localcso.type & 0x10) == 0)) {
        localEmojiInfo.OAr = 1;
      }
      localEmojiInfo.field_catalog = EmojiInfo.OzU;
      localEmojiInfo.field_groupId = localcso.HDL.ProductID;
      paramList.add(new com.tencent.mm.emoji.a.b.h(localEmojiInfo, 102));
    }
    V((List)paramList);
    AppMethodBeat.o(105859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.d.a
 * JD-Core Version:    0.7.0.1
 */