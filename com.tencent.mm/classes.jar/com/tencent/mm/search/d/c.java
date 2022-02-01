package com.tencent.mm.search.d;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.emoji.panel.EmojiPanelRecyclerView;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.m.a.d;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.dui;
import com.tencent.mm.protocal.protobuf.dut;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/search/ui/SimilarEmojiView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "dialog", "Lcom/tencent/mm/search/ui/SimilarEmojiDialog;", "(Landroid/content/Context;Lcom/tencent/mm/search/ui/SimilarEmojiDialog;)V", "adapter", "Lcom/tencent/mm/search/ui/SimilarEmojiAdapter;", "dataManager", "Lcom/tencent/mm/search/data/ISimilarEmojiManager;", "getDialog", "()Lcom/tencent/mm/search/ui/SimilarEmojiDialog;", "enableSos", "", "recyclerView", "Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "loadData", "", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "onClick", "v", "Landroid/view/View;", "release", "Companion", "plugin-emojisdk_release"})
public final class c
  extends RelativeLayout
  implements View.OnClickListener
{
  public static final a UXm;
  a PJX;
  boolean UWN;
  com.tencent.mm.search.data.a UXk;
  private final b UXl;
  private EmojiPanelRecyclerView uJZ;
  
  static
  {
    AppMethodBeat.i(105883);
    UXm = new a((byte)0);
    AppMethodBeat.o(105883);
  }
  
  public c(final Context paramContext, b paramb)
  {
    super(paramContext, null, 0);
    AppMethodBeat.i(105882);
    this.UXl = paramb;
    this.UXk = ((com.tencent.mm.search.data.a)new com.tencent.mm.search.data.c());
    this.PJX = new a();
    this.UWN = true;
    this.UXk.aDP();
    setBackgroundColor(paramContext.getResources().getColor(a.d.transparent));
    paramContext = LayoutInflater.from(paramContext).inflate(a.h.similar_emoji_ui, (ViewGroup)this, true);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(105882);
      throw paramContext;
    }
    paramContext = (RelativeLayout)paramContext;
    paramContext.findViewById(a.g.close_img).setOnClickListener((View.OnClickListener)this);
    paramContext = paramContext.findViewById(a.g.emoji_list);
    kotlin.g.b.p.j(paramContext, "parent.findViewById(R.id.emoji_list)");
    this.uJZ = ((EmojiPanelRecyclerView)paramContext);
    paramContext = new GridLayoutManager(4);
    paramContext.a((GridLayoutManager.b)new GridLayoutManager.b()
    {
      public final int cx(int paramAnonymousInt)
      {
        AppMethodBeat.i(105878);
        switch (c.a(this.UXn).getItemViewType(paramAnonymousInt))
        {
        case 102: 
        case 103: 
        case 104: 
        default: 
          AppMethodBeat.o(105878);
          return 1;
        }
        paramAnonymousInt = paramContext.ku();
        AppMethodBeat.o(105878);
        return paramAnonymousInt;
      }
    });
    this.uJZ.setLayoutManager((RecyclerView.LayoutManager)paramContext);
    this.uJZ.setItemViewCacheSize(0);
    this.uJZ.setAdapter((RecyclerView.a)this.PJX);
    this.uJZ.aCM();
    this.uJZ.setScene(1);
    this.uJZ.setEmojiPopupType(3);
    this.PJX.jLP = ((com.tencent.mm.emoji.panel.a.p)new com.tencent.mm.search.b.b(ChatFooterPanel.Rch));
    AppMethodBeat.o(105882);
  }
  
  public final b getDialog()
  {
    return this.UXl;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(105881);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/search/ui/SimilarEmojiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = a.g.close_img;
      if (paramView != null) {
        break label77;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/search/ui/SimilarEmojiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(105881);
      return;
      paramView = null;
      break;
      label77:
      if (paramView.intValue() == i)
      {
        paramView = this.UXl;
        if (paramView != null) {
          paramView.cancel();
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/search/ui/SimilarEmojiView$Companion;", "", "()V", "SCENE_SimilarEmojiView", "", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class b
    implements i
  {
    b(c paramc, SimilarEmojiQueryModel paramSimilarEmojiQueryModel) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
    {
      AppMethodBeat.i(105880);
      if (((paramq instanceof com.tencent.mm.search.data.b)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.search.data.b)paramq).rr.bhY();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiResponse");
          AppMethodBeat.o(105880);
          throw paramString;
        }
        paramString = ((dut)paramString).TdL;
        kotlin.g.b.p.j(paramString, "(rr.responseProtoBuf as …PanelEmojiResponse).Emoji");
        paramString = (List)paramString;
        Log.i("MicroMsg.SimilarEmoji", "get response success: " + paramString.size());
        MMHandlerThread.postToMainThread((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(105879);
            c.a(this.UXp.UXn).setData(paramString);
            Object localObject1;
            if (this.UXp.UXo.gTo())
            {
              localObject1 = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
              kotlin.g.b.p.j(localObject1, "plugin<IPluginEmoji>(IPluginEmoji::class.java)");
              localObject1 = ((com.tencent.mm.plugin.emoji.b.d)localObject1).getEmojiMgr().aud(this.UXp.UXo.emojiMD5);
              localObject2 = c.a(this.UXp.UXn);
              kotlin.g.b.p.j(localObject1, "head");
              ((a)localObject2).G((EmojiInfo)localObject1);
              localObject1 = c.a(this.UXp.UXn);
              if (((Collection)paramString).isEmpty()) {
                break label379;
              }
            }
            label379:
            for (boolean bool = true;; bool = false)
            {
              ((a)localObject1).UXc = bool;
              if (paramString.isEmpty()) {
                c.a(this.UXp.UXn).htA();
              }
              if (c.b(this.UXp.UXn)) {
                c.a(this.UXp.UXn).I(new EmojiInfo());
              }
              c.a(this.UXp.UXn).notifyDataSetChanged();
              localObject1 = new ArrayList();
              Object localObject3 = (Iterable)paramString;
              localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                dui localdui = (dui)((Iterator)localObject3).next();
                EmojiInfo localEmojiInfo = new EmojiInfo();
                com.tencent.mm.plugin.emoji.i.b.a(localdui.UaH, localEmojiInfo);
                if ((localdui.type & 0x1) == 0) {
                  localEmojiInfo.ZuP = 1;
                }
                if (((localdui.type & 0x1) == 0) && ((localdui.type & 0x10) == 0)) {
                  localEmojiInfo.ZuO = 1;
                }
                localEmojiInfo.field_catalog = EmojiInfo.YCx;
                localEmojiInfo.field_groupId = localdui.UaH.ProductID;
                ((Collection)localObject2).add(localEmojiInfo);
              }
              a.a(c.a(this.UXp.UXn));
              break;
            }
            Object localObject2 = (List)localObject2;
            if (((List)localObject2).size() >= 8) {}
            for (int i = 8;; i = ((List)localObject2).size())
            {
              ((ArrayList)localObject1).addAll((Collection)((List)localObject2).subList(0, i));
              localObject2 = com.tencent.mm.search.c.b.UWY;
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
      c.a(this.UXn).setData((List)paramString);
      if (this.UXo.gTo())
      {
        paramString = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
        kotlin.g.b.p.j(paramString, "plugin<IPluginEmoji>(IPluginEmoji::class.java)");
        paramString = ((com.tencent.mm.plugin.emoji.b.d)paramString).getEmojiMgr().aud(this.UXo.emojiMD5);
        paramq = c.a(this.UXn);
        kotlin.g.b.p.j(paramString, "head");
        paramq.G(paramString);
      }
      for (;;)
      {
        c.a(this.UXn).htA();
        if (c.b(this.UXn)) {
          c.a(this.UXn).I(new EmojiInfo());
        }
        c.a(this.UXn).notifyDataSetChanged();
        AppMethodBeat.o(105880);
        return;
        a.a(c.a(this.UXn));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.search.d.c
 * JD-Core Version:    0.7.0.1
 */