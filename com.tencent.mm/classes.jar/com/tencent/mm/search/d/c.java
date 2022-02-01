package com.tencent.mm.search.d;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.emoji.panel.EmojiPanelRecyclerView;
import com.tencent.mm.emoji.panel.a.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.dkt;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/search/ui/SimilarEmojiView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "dialog", "Lcom/tencent/mm/search/ui/SimilarEmojiDialog;", "(Landroid/content/Context;Lcom/tencent/mm/search/ui/SimilarEmojiDialog;)V", "adapter", "Lcom/tencent/mm/search/ui/SimilarEmojiAdapter;", "dataManager", "Lcom/tencent/mm/search/data/ISimilarEmojiManager;", "getDialog", "()Lcom/tencent/mm/search/ui/SimilarEmojiDialog;", "enableSos", "", "recyclerView", "Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "loadData", "", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "onClick", "v", "Landroid/view/View;", "release", "Companion", "plugin-emojisdk_release"})
public final class c
  extends RelativeLayout
  implements View.OnClickListener
{
  public static final c.a NJL;
  a INF;
  com.tencent.mm.search.data.a NJJ;
  private final b NJK;
  boolean NJm;
  private EmojiPanelRecyclerView rgQ;
  
  static
  {
    AppMethodBeat.i(105883);
    NJL = new c.a((byte)0);
    AppMethodBeat.o(105883);
  }
  
  public c(final Context paramContext, b paramb)
  {
    super(paramContext, null, 0);
    AppMethodBeat.i(105882);
    this.NJK = paramb;
    this.NJJ = ((com.tencent.mm.search.data.a)new com.tencent.mm.search.data.c());
    this.INF = new a();
    this.NJm = true;
    this.NJJ.awy();
    setBackgroundColor(paramContext.getResources().getColor(2131101287));
    paramContext = LayoutInflater.from(paramContext).inflate(2131496343, (ViewGroup)this, true);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(105882);
      throw paramContext;
    }
    paramContext = (RelativeLayout)paramContext;
    paramContext.findViewById(2131298781).setOnClickListener((View.OnClickListener)this);
    paramContext = paramContext.findViewById(2131299995);
    p.g(paramContext, "parent.findViewById(R.id.emoji_list)");
    this.rgQ = ((EmojiPanelRecyclerView)paramContext);
    paramContext = new GridLayoutManager(4);
    paramContext.a((GridLayoutManager.b)new GridLayoutManager.b()
    {
      public final int bX(int paramAnonymousInt)
      {
        AppMethodBeat.i(105878);
        switch (c.a(this.NJM).getItemViewType(paramAnonymousInt))
        {
        case 102: 
        case 103: 
        case 104: 
        default: 
          AppMethodBeat.o(105878);
          return 1;
        }
        paramAnonymousInt = paramContext.ki();
        AppMethodBeat.o(105878);
        return paramAnonymousInt;
      }
    });
    this.rgQ.setLayoutManager((RecyclerView.LayoutManager)paramContext);
    this.rgQ.setItemViewCacheSize(0);
    this.rgQ.setAdapter((RecyclerView.a)this.INF);
    this.rgQ.avQ();
    this.rgQ.setScene(1);
    this.rgQ.setEmojiPopupType(3);
    this.INF.haK = ((n)new com.tencent.mm.search.b.b(ChatFooterPanel.KbC));
    AppMethodBeat.o(105882);
  }
  
  public final b getDialog()
  {
    return this.NJK;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(105881);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/search/ui/SimilarEmojiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
      if (paramView.intValue() == 2131298781)
      {
        paramView = this.NJK;
        if (paramView != null) {
          paramView.cancel();
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class b
    implements i
  {
    b(c paramc, SimilarEmojiQueryModel paramSimilarEmojiQueryModel) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
    {
      AppMethodBeat.i(105880);
      if (((paramq instanceof com.tencent.mm.search.data.b)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.search.data.b)paramq).rr.aYK();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiResponse");
          AppMethodBeat.o(105880);
          throw paramString;
        }
        paramString = ((dld)paramString).LVc;
        p.g(paramString, "(rr.responseProtoBuf as …PanelEmojiResponse).Emoji");
        paramString = (List)paramString;
        Log.i("MicroMsg.SimilarEmoji", "get response success: " + paramString.size());
        MMHandlerThread.postToMainThread((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(105879);
            c.a(this.NJO.NJM).setData(paramString);
            Object localObject1;
            if (this.NJO.NJN.gau())
            {
              localObject1 = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
              p.g(localObject1, "plugin<IPluginEmoji>(IPluginEmoji::class.java)");
              localObject1 = ((com.tencent.mm.plugin.emoji.b.d)localObject1).getEmojiMgr().aml(this.NJO.NJN.emojiMD5);
              localObject2 = c.a(this.NJO.NJM);
              p.g(localObject1, "head");
              ((a)localObject2).F((EmojiInfo)localObject1);
              localObject1 = c.a(this.NJO.NJM);
              if (((Collection)paramString).isEmpty()) {
                break label379;
              }
            }
            label379:
            for (boolean bool = true;; bool = false)
            {
              ((a)localObject1).NJB = bool;
              if (paramString.isEmpty()) {
                c.a(this.NJO.NJM).gxC();
              }
              if (c.b(this.NJO.NJM)) {
                c.a(this.NJO.NJM).H(new EmojiInfo());
              }
              c.a(this.NJO.NJM).notifyDataSetChanged();
              localObject1 = new ArrayList();
              Object localObject3 = (Iterable)paramString;
              localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                dkt localdkt = (dkt)((Iterator)localObject3).next();
                EmojiInfo localEmojiInfo = new EmojiInfo();
                com.tencent.mm.plugin.emoji.h.b.a(localdkt.MOJ, localEmojiInfo);
                if ((localdkt.type & 0x1) == 0) {
                  localEmojiInfo.UuN = 1;
                }
                if (((localdkt.type & 0x1) == 0) && ((localdkt.type & 0x10) == 0)) {
                  localEmojiInfo.UuM = 1;
                }
                localEmojiInfo.field_catalog = EmojiInfo.Uup;
                localEmojiInfo.field_groupId = localdkt.MOJ.ProductID;
                ((Collection)localObject2).add(localEmojiInfo);
              }
              a.a(c.a(this.NJO.NJM));
              break;
            }
            Object localObject2 = (List)localObject2;
            if (((List)localObject2).size() >= 8) {}
            for (int i = 8;; i = ((List)localObject2).size())
            {
              ((ArrayList)localObject1).addAll((Collection)((List)localObject2).subList(0, i));
              localObject2 = com.tencent.mm.search.c.b.NJx;
              com.tencent.mm.search.c.b.b((ArrayList)localObject1, i);
              AppMethodBeat.o(105879);
              return;
            }
          }
        });
        AppMethodBeat.o(105880);
        return;
      }
      Log.e("MicroMsg.SimilarEmoji", "get response fail. errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = new ArrayList();
      c.a(this.NJM).setData((List)paramString);
      if (this.NJN.gau())
      {
        paramString = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(paramString, "plugin<IPluginEmoji>(IPluginEmoji::class.java)");
        paramString = ((com.tencent.mm.plugin.emoji.b.d)paramString).getEmojiMgr().aml(this.NJN.emojiMD5);
        paramq = c.a(this.NJM);
        p.g(paramString, "head");
        paramq.F(paramString);
      }
      for (;;)
      {
        c.a(this.NJM).gxC();
        if (c.b(this.NJM)) {
          c.a(this.NJM).H(new EmojiInfo());
        }
        c.a(this.NJM).notifyDataSetChanged();
        AppMethodBeat.o(105880);
        return;
        a.a(c.a(this.NJM));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.search.d.c
 * JD-Core Version:    0.7.0.1
 */