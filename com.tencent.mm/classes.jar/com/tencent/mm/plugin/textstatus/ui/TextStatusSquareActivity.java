package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.textstatus.f.e.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g.b;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/textstatus/model/square/SquareItem;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getMProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setMProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "onSceneEnd", "com/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$onSceneEnd$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$onSceneEnd$1;", "recycleView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecycleView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecycleView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "topicId", "", "getTopicId", "()Ljava/lang/String;", "setTopicId", "(Ljava/lang/String;)V", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-textstatus_release"})
public final class TextStatusSquareActivity
  extends MMActivity
{
  public static final TextStatusSquareActivity.a GfR;
  private String FZz;
  private final e GfQ;
  com.tencent.mm.ui.base.q gxX;
  private ArrayList<e> kgc;
  WxRecyclerView rHX;
  
  static
  {
    AppMethodBeat.i(216672);
    GfR = new TextStatusSquareActivity.a((byte)0);
    AppMethodBeat.o(216672);
  }
  
  public TextStatusSquareActivity()
  {
    AppMethodBeat.i(216671);
    this.kgc = new ArrayList();
    this.GfQ = new e(this);
    AppMethodBeat.o(216671);
  }
  
  public final int getLayoutId()
  {
    return 2131496703;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(216670);
    super.onCreate(paramBundle);
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
    paramBundle = getIntent();
    p.g(paramBundle, "intent");
    paramBundle = paramBundle.getExtras();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("TEXT_STATUS");
      localObject = getIntent();
      p.g(localObject, "intent");
      localObject = ((Intent)localObject).getExtras();
      if (localObject == null) {
        break label164;
      }
    }
    label164:
    for (Object localObject = ((Bundle)localObject).getString("TOPIC_ID");; localObject = null)
    {
      this.FZz = ((String)localObject);
      localObject = getIntent();
      p.g(localObject, "intent");
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        ((Bundle)localObject).getString("STATUS_ID");
      }
      int i = 0;
      while (i <= 10)
      {
        this.kgc.add(new e(String.valueOf(i), "test", "", "", ""));
        i += 1;
      }
      paramBundle = null;
      break;
    }
    this.rHX = ((WxRecyclerView)findViewById(2131306757));
    localObject = this.rHX;
    if (localObject != null) {
      ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    }
    localObject = this.rHX;
    if (localObject != null) {
      ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)new WxRecyclerAdapter((f)new TextStatusSquareActivity.b(), this.kgc));
    }
    localObject = this.rHX;
    if (localObject != null) {}
    for (localObject = ((WxRecyclerView)localObject).getAdapter(); localObject == null; localObject = null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
      AppMethodBeat.o(216670);
      throw paramBundle;
    }
    com.tencent.mm.view.recyclerview.g.a((WxRecyclerAdapter)localObject, (g.b)new com.tencent.mm.plugin.textstatus.f.e.d("#".concat(String.valueOf(paramBundle)), "共324人 同城23人"));
    paramBundle = this.rHX;
    if (paramBundle != null)
    {
      paramBundle.b((RecyclerView.h)new d(this));
      AppMethodBeat.o(216670);
      return;
    }
    AppMethodBeat.o(216670);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(TextStatusSquareActivity paramTextStatusSquareActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(216667);
      this.GfS.onBackPressed();
      AppMethodBeat.o(216667);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$onCreate$2", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "plugin-textstatus_release"})
  public static final class d
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(216668);
      p.h(paramRect, "outRect");
      p.h(paramRecyclerView, "parent");
      paramRecyclerView = this.GfS.rHX;
      if (paramRecyclerView != null)
      {
        paramRecyclerView = paramRecyclerView.getAdapter();
        if (paramRecyclerView == null) {}
      }
      for (int i = paramRecyclerView.getItemCount(); paramInt == i - 1; i = 1)
      {
        paramRect.bottom = a.fromDPToPix((Context)this.GfS, 16);
        AppMethodBeat.o(216668);
        return;
      }
      paramRect.bottom = a.fromDPToPix((Context)this.GfS, 8);
      AppMethodBeat.o(216668);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$onSceneEnd$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-textstatus_release"})
  public static final class e
    implements i
  {
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(216669);
      if ((paramq instanceof com.tencent.mm.plugin.textstatus.f.d))
      {
        com.tencent.mm.kernel.g.azz().b(((com.tencent.mm.plugin.textstatus.f.d)paramq).getType(), (i)this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = this.GfS.rHX;
          if (paramString != null)
          {
            paramString = paramString.getAdapter();
            if (paramString != null) {
              paramString.notifyDataSetChanged();
            }
          }
        }
      }
      paramString = this.GfS.gxX;
      if (paramString != null)
      {
        paramString.dismiss();
        AppMethodBeat.o(216669);
        return;
      }
      AppMethodBeat.o(216669);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusSquareActivity
 * JD-Core Version:    0.7.0.1
 */