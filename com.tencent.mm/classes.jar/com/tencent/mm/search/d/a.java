package com.tencent.mm.search.d;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.ah;
import com.tencent.mm.emoji.panel.a.aa;
import com.tencent.mm.emoji.panel.a.q;
import com.tencent.mm.emoji.panel.a.w;
import com.tencent.mm.emoji.panel.a.x;
import com.tencent.mm.emoji.panel.a.y;
import com.tencent.mm.emoji.panel.a.z;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.dkt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/search/ui/SimilarEmojiAdapter;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "()V", "gifAutoPlay", "", "maxBindViewPosition", "", "getMaxBindViewPosition", "()I", "setMaxBindViewPosition", "(I)V", "showHeadTip", "getGifAutoPlay", "getItemViewType", "position", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setBottomData", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setData", "list", "", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "setEmptyData", "setGifAutoPlay", "play", "setHeaderData", "setLoadData", "setShowHeadTip", "show", "setWebSearchHeaderData", "Companion", "plugin-emojisdk_release"})
public final class a
  extends com.tencent.mm.emoji.panel.a.h
{
  public static final a.a NJC;
  public boolean NJB;
  public boolean hbx = true;
  public int rgC;
  
  static
  {
    AppMethodBeat.i(105869);
    NJC = new a.a((byte)0);
    AppMethodBeat.o(105869);
  }
  
  public final void F(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105860);
    p.h(paramEmojiInfo, "emojiInfo");
    a(0, (ac)new com.tencent.mm.emoji.b.b.h(paramEmojiInfo, 100));
    AppMethodBeat.o(105860);
  }
  
  public final void G(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(200089);
    p.h(paramEmojiInfo, "emojiInfo");
    a(0, (ac)new com.tencent.mm.emoji.b.b.h(paramEmojiInfo, 107));
    AppMethodBeat.o(200089);
  }
  
  public final void H(EmojiInfo paramEmojiInfo)
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
      ((y)paramq).hbt = this.NJB;
    }
    if (getItemViewType(paramInt) == 103) {
      ((z)paramq).hbx = this.hbx;
    }
    if (getItemViewType(paramInt) == 102) {
      ((z)paramq).hbx = this.hbx;
    }
    if (paramInt > this.rgC) {
      this.rgC = paramInt;
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
      paramViewGroup = localLayoutInflater.inflate(2131496339, paramViewGroup, false);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new z(paramViewGroup, this.hbx, this.haK);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 100: 
      paramViewGroup = localLayoutInflater.inflate(2131496341, paramViewGroup, false);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new y(paramViewGroup, this.NJB, this.haK);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 101: 
      paramViewGroup = localLayoutInflater.inflate(2131496338, paramViewGroup, false);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new w(paramViewGroup, this.haK);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 103: 
      paramViewGroup = localLayoutInflater.inflate(2131496340, paramViewGroup, false);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new z(paramViewGroup, this.hbx, this.haK);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 104: 
      paramViewGroup = localLayoutInflater.inflate(2131496336, paramViewGroup, false);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new w(paramViewGroup, null);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 106: 
      paramViewGroup = localLayoutInflater.inflate(2131496337, paramViewGroup, false);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new x(paramViewGroup, 2131307040);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    case 105: 
      paramViewGroup = localLayoutInflater.inflate(2131496337, paramViewGroup, false);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new x(paramViewGroup, 2131303688);
      AppMethodBeat.o(105864);
      return paramViewGroup;
    }
    paramViewGroup = localLayoutInflater.inflate(2131496342, paramViewGroup, false);
    p.g(paramViewGroup, "itemView");
    paramViewGroup = (q)new aa(paramViewGroup);
    AppMethodBeat.o(105864);
    return paramViewGroup;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(105868);
    if (pm(paramInt) == null)
    {
      AppMethodBeat.o(105868);
      return 100;
    }
    if ((pm(paramInt) instanceof com.tencent.mm.emoji.b.b.h))
    {
      localObject = pm(paramInt);
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
        AppMethodBeat.o(105868);
        throw ((Throwable)localObject);
      }
      paramInt = ((com.tencent.mm.emoji.b.b.h)localObject).gYc;
      AppMethodBeat.o(105868);
      return paramInt;
    }
    Object localObject = pm(paramInt);
    if (localObject == null) {
      p.hyc();
    }
    paramInt = ((ac)localObject).type;
    AppMethodBeat.o(105868);
    return paramInt;
  }
  
  public final void gxB()
  {
    AppMethodBeat.i(105862);
    a(getItemCount(), (ac)new ah(105));
    AppMethodBeat.o(105862);
  }
  
  public final void gxC()
  {
    AppMethodBeat.i(105863);
    a(getItemCount(), (ac)new ah(106));
    AppMethodBeat.o(105863);
  }
  
  public final void setData(List<? extends dkt> paramList)
  {
    AppMethodBeat.i(105859);
    p.h(paramList, "list");
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      dkt localdkt = (dkt)((Iterator)localObject).next();
      EmojiInfo localEmojiInfo = new EmojiInfo();
      b.a(localdkt.MOJ, localEmojiInfo, localdkt.MOK);
      if ((localdkt.type & 0x1) == 0) {
        localEmojiInfo.UuN = 1;
      }
      if (((localdkt.type & 0x1) == 0) && ((localdkt.type & 0x10) == 0)) {
        localEmojiInfo.UuM = 1;
      }
      localEmojiInfo.field_catalog = EmojiInfo.Uup;
      localEmojiInfo.field_groupId = localdkt.MOJ.ProductID;
      paramList.add(new com.tencent.mm.emoji.b.b.h(localEmojiInfo, 102));
    }
    ad((List)paramList);
    AppMethodBeat.o(105859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.search.d.a
 * JD-Core Version:    0.7.0.1
 */