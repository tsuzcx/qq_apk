package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h.b;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/textstatus/model/square/SquareItem;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getMProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setMProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "onSceneEnd", "com/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$onSceneEnd$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$onSceneEnd$1;", "recycleView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecycleView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecycleView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "topicId", "", "getTopicId", "()Ljava/lang/String;", "setTopicId", "(Ljava/lang/String;)V", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-textstatus_release"})
public final class TextStatusSquareActivity
  extends MMActivity
{
  public static final a MOl;
  private final e MOk;
  s jhZ;
  private ArrayList<com.tencent.mm.plugin.textstatus.g.d.e> mXB;
  private String topicId;
  WxRecyclerView vnF;
  
  static
  {
    AppMethodBeat.i(234782);
    MOl = new a((byte)0);
    AppMethodBeat.o(234782);
  }
  
  public TextStatusSquareActivity()
  {
    AppMethodBeat.i(234779);
    this.mXB = new ArrayList();
    this.MOk = new e(this);
    AppMethodBeat.o(234779);
  }
  
  public final int getLayoutId()
  {
    return b.f.Myi;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(234778);
    super.onCreate(paramBundle);
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
    paramBundle = getIntent();
    p.j(paramBundle, "intent");
    paramBundle = paramBundle.getExtras();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("TEXT_STATUS");
      localObject = getIntent();
      p.j(localObject, "intent");
      localObject = ((Intent)localObject).getExtras();
      if (localObject == null) {
        break label164;
      }
    }
    label164:
    for (Object localObject = ((Bundle)localObject).getString("TOPIC_ID");; localObject = null)
    {
      this.topicId = ((String)localObject);
      localObject = getIntent();
      p.j(localObject, "intent");
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        ((Bundle)localObject).getString("STATUS_ID");
      }
      int i = 0;
      while (i <= 10)
      {
        this.mXB.add(new com.tencent.mm.plugin.textstatus.g.d.e(String.valueOf(i), "test", "", "", ""));
        i += 1;
      }
      paramBundle = null;
      break;
    }
    this.vnF = ((WxRecyclerView)findViewById(b.e.recycler_view));
    localObject = this.vnF;
    if (localObject != null) {
      ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    }
    localObject = this.vnF;
    if (localObject != null) {
      ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)new WxRecyclerAdapter((f)new b(), this.mXB));
    }
    localObject = this.vnF;
    if (localObject != null) {}
    for (localObject = ((WxRecyclerView)localObject).getAdapter(); localObject == null; localObject = null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
      AppMethodBeat.o(234778);
      throw paramBundle;
    }
    com.tencent.mm.view.recyclerview.h.a((WxRecyclerAdapter)localObject, (h.b)new com.tencent.mm.plugin.textstatus.g.d.d("#".concat(String.valueOf(paramBundle)), "共324人 同城23人"));
    paramBundle = this.vnF;
    if (paramBundle != null)
    {
      paramBundle.b((RecyclerView.h)new d(this));
      AppMethodBeat.o(234778);
      return;
    }
    AppMethodBeat.o(234778);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$Companion;", "", "()V", "TAG", "", "start", "", "context", "Landroid/content/Context;", "p", "Landroid/os/Bundle;", "plugin-textstatus_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"})
  public static final class b
    implements f
  {
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(233251);
      switch (paramInt)
      {
      default: 
        locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.textstatus.b.e();
        AppMethodBeat.o(233251);
        return locale;
      }
      com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.textstatus.b.d();
      AppMethodBeat.o(233251);
      return locale;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(TextStatusSquareActivity paramTextStatusSquareActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(235301);
      this.MOm.onBackPressed();
      AppMethodBeat.o(235301);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$onCreate$2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-textstatus_release"})
  public static final class d
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(233231);
      p.k(paramRect, "outRect");
      p.k(paramRecyclerView, "parent");
      paramRecyclerView = this.MOm.vnF;
      if (paramRecyclerView != null)
      {
        paramRecyclerView = paramRecyclerView.getAdapter();
        if (paramRecyclerView == null) {}
      }
      for (int i = paramRecyclerView.getItemCount(); paramInt == i - 1; i = 1)
      {
        paramRect.bottom = a.fromDPToPix((Context)this.MOm, 16);
        AppMethodBeat.o(233231);
        return;
      }
      paramRect.bottom = a.fromDPToPix((Context)this.MOm, 8);
      AppMethodBeat.o(233231);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$onSceneEnd$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-textstatus_release"})
  public static final class e
    implements i
  {
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(237042);
      if ((paramq instanceof com.tencent.mm.plugin.textstatus.g.e))
      {
        com.tencent.mm.kernel.h.aGY();
        AppMethodBeat.o(237042);
        throw null;
      }
      paramString = this.MOm.jhZ;
      if (paramString != null)
      {
        paramString.dismiss();
        AppMethodBeat.o(237042);
        return;
      }
      AppMethodBeat.o(237042);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusSquareActivity
 * JD-Core Version:    0.7.0.1
 */