package com.tencent.mm.search.c;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.emoji.panel.EmojiPanelRecyclerView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.cho;
import com.tencent.mm.protocal.protobuf.chu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/search/ui/SimilarEmojiView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "dialog", "Lcom/tencent/mm/search/ui/SimilarEmojiDialog;", "(Landroid/content/Context;Lcom/tencent/mm/search/ui/SimilarEmojiDialog;)V", "adapter", "Lcom/tencent/mm/search/ui/SimilarEmojiAdapter;", "dataManager", "Lcom/tencent/mm/search/data/ISimilarEmojiManager;", "getDialog", "()Lcom/tencent/mm/search/ui/SimilarEmojiDialog;", "enableSos", "", "recyclerView", "Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "loadData", "", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "onClick", "v", "Landroid/view/View;", "release", "Companion", "plugin-emojisdk_release"})
public final class c
  extends RelativeLayout
  implements View.OnClickListener
{
  public static final a EZA;
  a AOa;
  boolean EZb;
  com.tencent.mm.search.data.a EZx;
  private EmojiPanelRecyclerView EZy;
  private final b EZz;
  
  static
  {
    AppMethodBeat.i(105883);
    EZA = new a((byte)0);
    AppMethodBeat.o(105883);
  }
  
  public c(final Context paramContext, b paramb)
  {
    super(paramContext, null, 0);
    AppMethodBeat.i(105882);
    this.EZz = paramb;
    this.EZx = ((com.tencent.mm.search.data.a)new com.tencent.mm.search.data.c());
    this.AOa = new a();
    this.EZb = true;
    this.EZx.eHu();
    setBackgroundColor(paramContext.getResources().getColor(2131101053));
    paramContext = LayoutInflater.from(paramContext).inflate(2131495468, (ViewGroup)this, true);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(105882);
      throw paramContext;
    }
    paramContext = (RelativeLayout)paramContext;
    paramContext.findViewById(2131298372).setOnClickListener((View.OnClickListener)this);
    paramContext = paramContext.findViewById(2131299382);
    k.g(paramContext, "parent.findViewById(R.id.emoji_list)");
    this.EZy = ((EmojiPanelRecyclerView)paramContext);
    paramContext = new GridLayoutManager(4);
    paramContext.a((GridLayoutManager.b)new GridLayoutManager.b()
    {
      public final int bW(int paramAnonymousInt)
      {
        AppMethodBeat.i(105878);
        switch (c.a(this.EZB).getItemViewType(paramAnonymousInt))
        {
        case 102: 
        case 103: 
        case 104: 
        default: 
          AppMethodBeat.o(105878);
          return 1;
        }
        paramAnonymousInt = paramContext.jB();
        AppMethodBeat.o(105878);
        return paramAnonymousInt;
      }
    });
    this.EZy.setLayoutManager((RecyclerView.i)paramContext);
    this.EZy.setItemViewCacheSize(0);
    this.EZy.setAdapter((RecyclerView.a)this.AOa);
    this.EZy.acc();
    this.EZy.setScene(1);
    this.EZy.setEmojiPopupType(3);
    this.AOa.fPW = ((com.tencent.mm.emoji.panel.a.n)new com.tencent.mm.search.a.b(ChatFooterPanel.BUU));
    AppMethodBeat.o(105882);
  }
  
  public final b getDialog()
  {
    return this.EZz;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(105881);
    if (paramView != null) {}
    for (paramView = Integer.valueOf(paramView.getId()); paramView == null; paramView = null)
    {
      AppMethodBeat.o(105881);
      return;
    }
    if (paramView.intValue() == 2131298372)
    {
      paramView = this.EZz;
      if (paramView != null)
      {
        paramView.cancel();
        AppMethodBeat.o(105881);
        return;
      }
    }
    AppMethodBeat.o(105881);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/search/ui/SimilarEmojiView$Companion;", "", "()V", "SCENE_SimilarEmojiView", "", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class b
    implements g
  {
    b(c paramc, EmojiInfo paramEmojiInfo) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(105880);
      if (((paramn instanceof com.tencent.mm.search.data.b)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.search.data.b)paramn).rr.auM();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiResponse");
          AppMethodBeat.o(105880);
          throw paramString;
        }
        paramString = ((chu)paramString).Dte;
        k.g(paramString, "(rr.responseProtoBuf as …PanelEmojiResponse).Emoji");
        paramString = (List)paramString;
        ad.i("MicroMsg.SimilarEmoji", "get response success: " + paramString.size());
        aq.f((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(105879);
            c.a(this.EZD.EZB).setData(paramString);
            Object localObject1 = c.a(this.EZD.EZB);
            Object localObject2 = this.EZD.EZC;
            k.g(localObject2, "head");
            ((a)localObject1).G((EmojiInfo)localObject2);
            localObject1 = c.a(this.EZD.EZB);
            if (!((Collection)paramString).isEmpty()) {}
            for (boolean bool = true;; bool = false)
            {
              ((a)localObject1).EZp = bool;
              if (paramString.isEmpty()) {
                c.a(this.EZD.EZB).eHG();
              }
              if (c.b(this.EZD.EZB)) {
                c.a(this.EZD.EZB).H(new EmojiInfo());
              }
              c.a(this.EZD.EZB).notifyDataSetChanged();
              localObject1 = new ArrayList();
              Object localObject3 = (Iterable)paramString;
              localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                cho localcho = (cho)((Iterator)localObject3).next();
                EmojiInfo localEmojiInfo = new EmojiInfo();
                com.tencent.mm.plugin.emoji.h.b.a(localcho.Edc, localEmojiInfo);
                if ((localcho.type & 0x1) == 0) {
                  localEmojiInfo.LCo = 1;
                }
                if (((localcho.type & 0x1) == 0) && ((localcho.type & 0x10) == 0)) {
                  localEmojiInfo.LCn = 1;
                }
                localEmojiInfo.field_catalog = EmojiInfo.LBQ;
                localEmojiInfo.field_groupId = localcho.Edc.ProductID;
                ((Collection)localObject2).add(localEmojiInfo);
              }
            }
            localObject2 = (List)localObject2;
            if (((List)localObject2).size() >= 8) {}
            for (int i = 8;; i = ((List)localObject2).size())
            {
              ((ArrayList)localObject1).addAll((Collection)((List)localObject2).subList(0, i));
              localObject2 = com.tencent.mm.search.b.b.EZl;
              com.tencent.mm.search.b.b.b((ArrayList)localObject1, i);
              AppMethodBeat.o(105879);
              return;
            }
          }
        });
        AppMethodBeat.o(105880);
        return;
      }
      ad.e("MicroMsg.SimilarEmoji", "get response fail. errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = new ArrayList();
      c.a(this.EZB).setData((List)paramString);
      paramString = c.a(this.EZB);
      paramn = this.EZC;
      k.g(paramn, "head");
      paramString.G(paramn);
      c.a(this.EZB).eHG();
      if (c.b(this.EZB)) {
        c.a(this.EZB).H(new EmojiInfo());
      }
      c.a(this.EZB).notifyDataSetChanged();
      AppMethodBeat.o(105880);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.search.c.c
 * JD-Core Version:    0.7.0.1
 */