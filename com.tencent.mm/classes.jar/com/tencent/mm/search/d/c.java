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
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.emoji.panel.EmojiPanelRecyclerView;
import com.tencent.mm.emoji.panel.a.g;
import com.tencent.mm.emoji.panel.a.n;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.m.a.d;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.eng;
import com.tencent.mm.protocal.protobuf.enr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/search/ui/SimilarEmojiView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "dialog", "Lcom/tencent/mm/search/ui/SimilarEmojiDialog;", "(Landroid/content/Context;Lcom/tencent/mm/search/ui/SimilarEmojiDialog;)V", "adapter", "Lcom/tencent/mm/search/ui/SimilarEmojiAdapter;", "dataManager", "Lcom/tencent/mm/search/data/ISimilarEmojiManager;", "getDialog", "()Lcom/tencent/mm/search/ui/SimilarEmojiDialog;", "enableSos", "", "recyclerView", "Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "loadData", "", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "onClick", "v", "Landroid/view/View;", "release", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends RelativeLayout
  implements View.OnClickListener
{
  public static final c.a acsr;
  private a WAq;
  private boolean acsa;
  private final b acss;
  com.tencent.mm.search.data.a acst;
  private EmojiPanelRecyclerView mpy;
  
  static
  {
    AppMethodBeat.i(105883);
    acsr = new c.a((byte)0);
    AppMethodBeat.o(105883);
  }
  
  public c(final Context paramContext, b paramb)
  {
    super(paramContext, null, 0);
    AppMethodBeat.i(105882);
    this.acss = paramb;
    this.acst = ((com.tencent.mm.search.data.a)new com.tencent.mm.search.data.c());
    this.WAq = new a();
    this.acsa = true;
    this.acst.iTu();
    setBackgroundColor(paramContext.getResources().getColor(a.d.transparent));
    paramContext = LayoutInflater.from(paramContext).inflate(a.h.similar_emoji_ui, (ViewGroup)this, true);
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(105882);
      throw paramContext;
    }
    paramContext = (RelativeLayout)paramContext;
    paramContext.findViewById(a.g.close_img).setOnClickListener((View.OnClickListener)this);
    paramContext = paramContext.findViewById(a.g.emoji_list);
    s.s(paramContext, "parent.findViewById(R.id.emoji_list)");
    this.mpy = ((EmojiPanelRecyclerView)paramContext);
    paramContext = new GridLayoutManager(4);
    paramContext.bWq = ((GridLayoutManager.b)new GridLayoutManager.b()
    {
      public final int fJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(105878);
        switch (c.a(this.acsu).getItemViewType(paramAnonymousInt))
        {
        case 102: 
        case 103: 
        case 104: 
        default: 
          AppMethodBeat.o(105878);
          return 1;
        }
        paramAnonymousInt = paramContext.bWl;
        AppMethodBeat.o(105878);
        return paramAnonymousInt;
      }
    });
    this.mpy.setLayoutManager((RecyclerView.LayoutManager)paramContext);
    this.mpy.setItemViewCacheSize(0);
    this.mpy.setAdapter((RecyclerView.a)this.WAq);
    this.mpy.aVK();
    this.mpy.setScene(1);
    this.mpy.setEmojiPopupType(3);
    this.WAq.mkY = ((n)new com.tencent.mm.search.b.b(ChatFooterPanel.XYm));
    AppMethodBeat.o(105882);
  }
  
  private static final void a(c paramc, SimilarEmojiQueryModel paramSimilarEmojiQueryModel, int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(236879);
    s.u(paramc, "this$0");
    s.u(paramSimilarEmojiQueryModel, "$model");
    if (((paramp instanceof com.tencent.mm.search.data.b)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = c.c.b(((com.tencent.mm.search.data.b)paramp).rr.otC);
      if (paramString == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiResponse");
        AppMethodBeat.o(236879);
        throw paramc;
      }
      paramString = ((enr)paramString).aaqZ;
      s.s(paramString, "rr.responseProtoBuf as R…PanelEmojiResponse).Emoji");
      paramString = (List)paramString;
      Log.i("MicroMsg.SimilarEmoji", s.X("get response success: ", Integer.valueOf(paramString.size())));
      MMHandlerThread.postToMainThread(new c..ExternalSyntheticLambda1(paramc, paramString, paramSimilarEmojiQueryModel));
      AppMethodBeat.o(236879);
      return;
    }
    Log.e("MicroMsg.SimilarEmoji", "get response fail. errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = new ArrayList();
    paramc.WAq.setData((List)paramString);
    if (paramSimilarEmojiQueryModel.itb())
    {
      paramSimilarEmojiQueryModel = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramSimilarEmojiQueryModel.emojiMD5);
      paramString = paramc.WAq;
      s.s(paramSimilarEmojiQueryModel, "head");
      paramString.G(paramSimilarEmojiQueryModel);
    }
    for (;;)
    {
      paramc.WAq.iTF();
      if (paramc.acsa) {
        paramc.WAq.I(new EmojiInfo());
      }
      paramc.WAq.bZE.notifyChanged();
      AppMethodBeat.o(236879);
      return;
      a.a(paramc.WAq);
    }
  }
  
  private static final void a(c paramc, List paramList, SimilarEmojiQueryModel paramSimilarEmojiQueryModel)
  {
    AppMethodBeat.i(236875);
    s.u(paramc, "this$0");
    s.u(paramList, "$list");
    s.u(paramSimilarEmojiQueryModel, "$model");
    paramc.WAq.setData(paramList);
    Object localObject;
    if (paramSimilarEmojiQueryModel.itb())
    {
      paramSimilarEmojiQueryModel = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramSimilarEmojiQueryModel.emojiMD5);
      localObject = paramc.WAq;
      s.s(paramSimilarEmojiQueryModel, "head");
      ((a)localObject).G(paramSimilarEmojiQueryModel);
      paramSimilarEmojiQueryModel = paramc.WAq;
      if (((Collection)paramList).isEmpty()) {
        break label318;
      }
    }
    label318:
    for (boolean bool = true;; bool = false)
    {
      paramSimilarEmojiQueryModel.acsm = bool;
      if (paramList.isEmpty()) {
        paramc.WAq.iTF();
      }
      if (paramc.acsa) {
        paramc.WAq.I(new EmojiInfo());
      }
      paramc.WAq.bZE.notifyChanged();
      paramc = new ArrayList();
      paramSimilarEmojiQueryModel = (Iterable)paramList;
      paramList = (Collection)new ArrayList(kotlin.a.p.a(paramSimilarEmojiQueryModel, 10));
      paramSimilarEmojiQueryModel = paramSimilarEmojiQueryModel.iterator();
      while (paramSimilarEmojiQueryModel.hasNext())
      {
        localObject = (eng)paramSimilarEmojiQueryModel.next();
        EmojiInfo localEmojiInfo = new EmojiInfo();
        com.tencent.mm.plugin.emoji.g.d.a(((eng)localObject).abrK, localEmojiInfo);
        if ((((eng)localObject).type & 0x1) == 0) {
          localEmojiInfo.akmd = 1;
        }
        if (((((eng)localObject).type & 0x1) == 0) && ((((eng)localObject).type & 0x10) == 0)) {
          localEmojiInfo.pay = 1;
        }
        localEmojiInfo.field_catalog = EmojiInfo.aklG;
        localEmojiInfo.field_groupId = ((eng)localObject).abrK.ProductID;
        paramList.add(localEmojiInfo);
      }
      a.a(paramc.WAq);
      break;
    }
    paramList = (List)paramList;
    if (paramList.size() >= 8) {}
    for (int i = 8;; i = paramList.size())
    {
      paramc.addAll((Collection)paramList.subList(0, i));
      paramList = com.tencent.mm.search.c.b.acsj;
      com.tencent.mm.search.c.b.b(paramc, i);
      AppMethodBeat.o(236875);
      return;
    }
  }
  
  public final void a(SimilarEmojiQueryModel paramSimilarEmojiQueryModel)
  {
    AppMethodBeat.i(236889);
    s.u(paramSimilarEmojiQueryModel, "model");
    this.acsa = paramSimilarEmojiQueryModel.acsa;
    if (paramSimilarEmojiQueryModel.itb())
    {
      localObject = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramSimilarEmojiQueryModel.emojiMD5);
      a locala = this.WAq;
      s.s(localObject, "head");
      locala.G((EmojiInfo)localObject);
    }
    for (;;)
    {
      this.WAq.acsm = false;
      this.WAq.iTE();
      this.WAq.bZE.notifyChanged();
      localObject = this.WAq.mkY;
      if (localObject != null) {
        break;
      }
      paramSimilarEmojiQueryModel = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.search.logic.SimilarEmojiPanelClickListener");
      AppMethodBeat.o(236889);
      throw paramSimilarEmojiQueryModel;
      a.a(this.WAq);
    }
    ((com.tencent.mm.search.b.b)localObject).moX = paramSimilarEmojiQueryModel;
    Object localObject = this.WAq.mkY;
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.EmojiPanelClickListener");
      AppMethodBeat.o(236889);
      throw paramSimilarEmojiQueryModel;
    }
    ((com.tencent.mm.emoji.panel.a.d)localObject).mkP = paramSimilarEmojiQueryModel.acsb;
    this.acst.a(paramSimilarEmojiQueryModel, new c..ExternalSyntheticLambda0(this, paramSimilarEmojiQueryModel));
    AppMethodBeat.o(236889);
  }
  
  public final b getDialog()
  {
    return this.acss;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(105881);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/search/ui/SimilarEmojiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = a.g.close_img;
      if (paramView != null) {
        break label87;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/search/ui/SimilarEmojiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(105881);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label87:
      if (paramView.intValue() == i)
      {
        paramView = this.acss;
        if (paramView != null) {
          paramView.cancel();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.d.c
 * JD-Core Version:    0.7.0.1
 */