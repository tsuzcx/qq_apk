package com.tencent.mm.search.d;

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
import com.tencent.mm.ak.g;
import com.tencent.mm.emoji.panel.EmojiPanelRecyclerView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.protocal.protobuf.cmr;
import com.tencent.mm.protocal.protobuf.cmx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/search/ui/SimilarEmojiView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "dialog", "Lcom/tencent/mm/search/ui/SimilarEmojiDialog;", "(Landroid/content/Context;Lcom/tencent/mm/search/ui/SimilarEmojiDialog;)V", "adapter", "Lcom/tencent/mm/search/ui/SimilarEmojiAdapter;", "dataManager", "Lcom/tencent/mm/search/data/ISimilarEmojiManager;", "getDialog", "()Lcom/tencent/mm/search/ui/SimilarEmojiDialog;", "enableSos", "", "recyclerView", "Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "loadData", "", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "onClick", "v", "Landroid/view/View;", "release", "Companion", "plugin-emojisdk_release"})
public final class c
  extends RelativeLayout
  implements View.OnClickListener
{
  public static final c.a GwR;
  a Cgs;
  com.tencent.mm.search.data.a GwO;
  private EmojiPanelRecyclerView GwP;
  private final b GwQ;
  boolean Gwn;
  
  static
  {
    AppMethodBeat.i(105883);
    GwR = new c.a((byte)0);
    AppMethodBeat.o(105883);
  }
  
  public c(final Context paramContext, b paramb)
  {
    super(paramContext, null, 0);
    AppMethodBeat.i(105882);
    this.GwQ = paramb;
    this.GwO = ((com.tencent.mm.search.data.a)new com.tencent.mm.search.data.c());
    this.Cgs = new a();
    this.Gwn = true;
    this.GwO.eWP();
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
    this.GwP = ((EmojiPanelRecyclerView)paramContext);
    paramContext = new GridLayoutManager(4);
    paramContext.a((GridLayoutManager.b)new GridLayoutManager.b()
    {
      public final int bW(int paramAnonymousInt)
      {
        AppMethodBeat.i(105878);
        switch (c.a(this.GwS).getItemViewType(paramAnonymousInt))
        {
        case 102: 
        case 103: 
        case 104: 
        default: 
          AppMethodBeat.o(105878);
          return 1;
        }
        paramAnonymousInt = paramContext.jJ();
        AppMethodBeat.o(105878);
        return paramAnonymousInt;
      }
    });
    this.GwP.setLayoutManager((RecyclerView.i)paramContext);
    this.GwP.setItemViewCacheSize(0);
    this.GwP.setAdapter((RecyclerView.a)this.Cgs);
    this.GwP.adi();
    this.GwP.setScene(1);
    this.GwP.setEmojiPopupType(3);
    this.Cgs.fTR = ((com.tencent.mm.emoji.panel.a.n)new com.tencent.mm.search.b.b(ChatFooterPanel.Dnk));
    AppMethodBeat.o(105882);
  }
  
  public final b getDialog()
  {
    return this.GwQ;
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
      paramView = this.GwQ;
      if (paramView != null)
      {
        paramView.cancel();
        AppMethodBeat.o(105881);
        return;
      }
    }
    AppMethodBeat.o(105881);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class b
    implements g
  {
    b(c paramc, EmojiInfo paramEmojiInfo) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(105880);
      if (((paramn instanceof com.tencent.mm.search.data.b)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.search.data.b)paramn).rr.aBD();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiResponse");
          AppMethodBeat.o(105880);
          throw paramString;
        }
        paramString = ((cmx)paramString).EOi;
        k.g(paramString, "(rr.responseProtoBuf as …PanelEmojiResponse).Emoji");
        paramString = (List)paramString;
        ac.i("MicroMsg.SimilarEmoji", "get response success: " + paramString.size());
        ap.f((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(105879);
            c.a(this.GwU.GwS).setData(paramString);
            Object localObject1 = c.a(this.GwU.GwS);
            Object localObject2 = this.GwU.GwT;
            k.g(localObject2, "head");
            ((a)localObject1).G((EmojiInfo)localObject2);
            localObject1 = c.a(this.GwU.GwS);
            if (!((Collection)paramString).isEmpty()) {}
            for (boolean bool = true;; bool = false)
            {
              ((a)localObject1).GwE = bool;
              if (paramString.isEmpty()) {
                c.a(this.GwU.GwS).eXc();
              }
              if (c.b(this.GwU.GwS)) {
                c.a(this.GwU.GwS).H(new EmojiInfo());
              }
              c.a(this.GwU.GwS).notifyDataSetChanged();
              localObject1 = new ArrayList();
              Object localObject3 = (Iterable)paramString;
              localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                cmr localcmr = (cmr)((Iterator)localObject3).next();
                EmojiInfo localEmojiInfo = new EmojiInfo();
                com.tencent.mm.plugin.emoji.h.b.a(localcmr.FzX, localEmojiInfo);
                if ((localcmr.type & 0x1) == 0) {
                  localEmojiInfo.Kgp = 1;
                }
                if (((localcmr.type & 0x1) == 0) && ((localcmr.type & 0x10) == 0)) {
                  localEmojiInfo.Kgo = 1;
                }
                localEmojiInfo.field_catalog = EmojiInfo.Jss;
                localEmojiInfo.field_groupId = localcmr.FzX.ProductID;
                ((Collection)localObject2).add(localEmojiInfo);
              }
            }
            localObject2 = (List)localObject2;
            if (((List)localObject2).size() >= 8) {}
            for (int i = 8;; i = ((List)localObject2).size())
            {
              ((ArrayList)localObject1).addAll((Collection)((List)localObject2).subList(0, i));
              localObject2 = com.tencent.mm.search.c.b.GwA;
              com.tencent.mm.search.c.b.b((ArrayList)localObject1, i);
              AppMethodBeat.o(105879);
              return;
            }
          }
        });
        AppMethodBeat.o(105880);
        return;
      }
      ac.e("MicroMsg.SimilarEmoji", "get response fail. errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = new ArrayList();
      c.a(this.GwS).setData((List)paramString);
      paramString = c.a(this.GwS);
      paramn = this.GwT;
      k.g(paramn, "head");
      paramString.G(paramn);
      c.a(this.GwS).eXc();
      if (c.b(this.GwS)) {
        c.a(this.GwS).H(new EmojiInfo());
      }
      c.a(this.GwS).notifyDataSetChanged();
      AppMethodBeat.o(105880);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.search.d.c
 * JD-Core Version:    0.7.0.1
 */