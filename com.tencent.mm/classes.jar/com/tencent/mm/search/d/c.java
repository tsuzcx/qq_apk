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
import com.tencent.mm.ak.f;
import com.tencent.mm.emoji.panel.EmojiPanelRecyclerView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.protocal.protobuf.cso;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/search/ui/SimilarEmojiView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "dialog", "Lcom/tencent/mm/search/ui/SimilarEmojiDialog;", "(Landroid/content/Context;Lcom/tencent/mm/search/ui/SimilarEmojiDialog;)V", "adapter", "Lcom/tencent/mm/search/ui/SimilarEmojiAdapter;", "dataManager", "Lcom/tencent/mm/search/data/ISimilarEmojiManager;", "getDialog", "()Lcom/tencent/mm/search/ui/SimilarEmojiDialog;", "enableSos", "", "recyclerView", "Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "loadData", "", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "onClick", "v", "Landroid/view/View;", "release", "Companion", "plugin-emojisdk_release"})
public final class c
  extends RelativeLayout
  implements View.OnClickListener
{
  public static final c.a ICW;
  a Ebt;
  com.tencent.mm.search.data.a ICT;
  private EmojiPanelRecyclerView ICU;
  private final b ICV;
  boolean ICs;
  
  static
  {
    AppMethodBeat.i(105883);
    ICW = new c.a((byte)0);
    AppMethodBeat.o(105883);
  }
  
  public c(final Context paramContext, b paramb)
  {
    super(paramContext, null, 0);
    AppMethodBeat.i(105882);
    this.ICV = paramb;
    this.ICT = ((com.tencent.mm.search.data.a)new com.tencent.mm.search.data.c());
    this.Ebt = new a();
    this.ICs = true;
    this.ICT.fqu();
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
    p.g(paramContext, "parent.findViewById(R.id.emoji_list)");
    this.ICU = ((EmojiPanelRecyclerView)paramContext);
    paramContext = new GridLayoutManager(4);
    paramContext.a((GridLayoutManager.b)new GridLayoutManager.b()
    {
      public final int bW(int paramAnonymousInt)
      {
        AppMethodBeat.i(105878);
        switch (c.a(this.ICX).getItemViewType(paramAnonymousInt))
        {
        case 102: 
        case 103: 
        case 104: 
        default: 
          AppMethodBeat.o(105878);
          return 1;
        }
        paramAnonymousInt = paramContext.jZ();
        AppMethodBeat.o(105878);
        return paramAnonymousInt;
      }
    });
    this.ICU.setLayoutManager((RecyclerView.i)paramContext);
    this.ICU.setItemViewCacheSize(0);
    this.ICU.setAdapter((RecyclerView.a)this.Ebt);
    this.ICU.agc();
    this.ICU.setScene(1);
    this.ICU.setEmojiPopupType(3);
    this.Ebt.gpR = ((com.tencent.mm.emoji.panel.a.n)new com.tencent.mm.search.b.b(ChatFooterPanel.FkK));
    AppMethodBeat.o(105882);
  }
  
  public final b getDialog()
  {
    return this.ICV;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(105881);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/search/ui/SimilarEmojiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label73;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/search/ui/SimilarEmojiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(105881);
      return;
      paramView = null;
      break;
      label73:
      if (paramView.intValue() == 2131298372)
      {
        paramView = this.ICV;
        if (paramView != null) {
          paramView.cancel();
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class b
    implements f
  {
    b(c paramc, EmojiInfo paramEmojiInfo) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(105880);
      if (((paramn instanceof com.tencent.mm.search.data.b)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.search.data.b)paramn).rr.aEV();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiResponse");
          AppMethodBeat.o(105880);
          throw paramString;
        }
        paramString = ((csu)paramString).GQM;
        p.g(paramString, "(rr.responseProtoBuf as …PanelEmojiResponse).Emoji");
        paramString = (List)paramString;
        ae.i("MicroMsg.SimilarEmoji", "get response success: " + paramString.size());
        ar.f((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(105879);
            c.a(this.ICZ.ICX).setData(paramString);
            Object localObject1 = c.a(this.ICZ.ICX);
            Object localObject2 = this.ICZ.ICY;
            p.g(localObject2, "head");
            ((a)localObject1).F((EmojiInfo)localObject2);
            localObject1 = c.a(this.ICZ.ICX);
            if (!((Collection)paramString).isEmpty()) {}
            for (boolean bool = true;; bool = false)
            {
              ((a)localObject1).ICJ = bool;
              if (paramString.isEmpty()) {
                c.a(this.ICZ.ICX).fqH();
              }
              if (c.b(this.ICZ.ICX)) {
                c.a(this.ICZ.ICX).G(new EmojiInfo());
              }
              c.a(this.ICZ.ICX).notifyDataSetChanged();
              localObject1 = new ArrayList();
              Object localObject3 = (Iterable)paramString;
              localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                cso localcso = (cso)((Iterator)localObject3).next();
                EmojiInfo localEmojiInfo = new EmojiInfo();
                com.tencent.mm.plugin.emoji.h.b.a(localcso.HDL, localEmojiInfo);
                if ((localcso.type & 0x1) == 0) {
                  localEmojiInfo.OAs = 1;
                }
                if (((localcso.type & 0x1) == 0) && ((localcso.type & 0x10) == 0)) {
                  localEmojiInfo.OAr = 1;
                }
                localEmojiInfo.field_catalog = EmojiInfo.OzU;
                localEmojiInfo.field_groupId = localcso.HDL.ProductID;
                ((Collection)localObject2).add(localEmojiInfo);
              }
            }
            localObject2 = (List)localObject2;
            if (((List)localObject2).size() >= 8) {}
            for (int i = 8;; i = ((List)localObject2).size())
            {
              ((ArrayList)localObject1).addAll((Collection)((List)localObject2).subList(0, i));
              localObject2 = com.tencent.mm.search.c.b.ICF;
              com.tencent.mm.search.c.b.b((ArrayList)localObject1, i);
              AppMethodBeat.o(105879);
              return;
            }
          }
        });
        AppMethodBeat.o(105880);
        return;
      }
      ae.e("MicroMsg.SimilarEmoji", "get response fail. errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = new ArrayList();
      c.a(this.ICX).setData((List)paramString);
      paramString = c.a(this.ICX);
      paramn = this.ICY;
      p.g(paramn, "head");
      paramString.F(paramn);
      c.a(this.ICX).fqH();
      if (c.b(this.ICX)) {
        c.a(this.ICX).G(new EmojiInfo());
      }
      c.a(this.ICX).notifyDataSetChanged();
      AppMethodBeat.o(105880);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.d.c
 * JD-Core Version:    0.7.0.1
 */