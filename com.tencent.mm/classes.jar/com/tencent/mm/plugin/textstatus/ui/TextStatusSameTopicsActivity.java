package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.j.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/textstatus/model/topic/SameTopicItem;", "Lkotlin/collections/ArrayList;", "rvSameTopic", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-textstatus_release"})
public final class TextStatusSameTopicsActivity
  extends MMActivity
{
  public static final TextStatusSameTopicsActivity.a GfI;
  private WxRecyclerView GfF;
  private ArrayList<com.tencent.mm.plugin.textstatus.f.g.a> kgc;
  
  static
  {
    AppMethodBeat.i(216658);
    GfI = new TextStatusSameTopicsActivity.a((byte)0);
    AppMethodBeat.o(216658);
  }
  
  public TextStatusSameTopicsActivity()
  {
    AppMethodBeat.i(216657);
    this.kgc = new ArrayList();
    AppMethodBeat.o(216657);
  }
  
  public final int getLayoutId()
  {
    return 2131496698;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(216656);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
    setActionbarColor(getResources().getColor(2131099743));
    setNavigationbarColor(getResources().getColor(2131099743));
    hideActionbarLine();
    Object localObject1 = getIntent().getStringExtra("topic_id");
    paramBundle = com.tencent.mm.plugin.textstatus.b.f.FXJ;
    paramBundle = com.tencent.mm.plugin.textstatus.b.f.fvM();
    Object localObject2 = com.tencent.mm.plugin.auth.a.a.ceA();
    p.g(localObject2, "Account.username()");
    paramBundle = paramBundle.m((String)localObject1, j.ac(new String[] { localObject2 }));
    new StringBuilder("oncreate ").append((String)localObject1).append(',').append(paramBundle.size());
    h.hkS();
    localObject1 = paramBundle.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.textstatus.f.f.a)((Iterator)localObject1).next();
      this.kgc.add(new com.tencent.mm.plugin.textstatus.f.g.a((com.tencent.mm.plugin.textstatus.f.f.a)localObject2));
    }
    if (this.kgc.size() > 0)
    {
      localObject2 = ((com.tencent.mm.plugin.textstatus.f.g.a)this.kgc.get(0)).FYx.field_IconID;
      localObject1 = b.GfZ;
      p.g(localObject2, "iconId");
      localObject1 = new SpannableStringBuilder((CharSequence)b.aTp((String)localObject2));
      b localb = b.GfZ;
      localObject2 = b.a((String)localObject2, a.c.FXp, null, 4);
      if (localObject2 != null)
      {
        ((Drawable)localObject2).setBounds(0, 0, getResources().getDimensionPixelSize(2131165203), getResources().getDimensionPixelSize(2131165203));
        localObject2 = new com.tencent.mm.plugin.textstatus.j.d((Drawable)localObject2);
        ((SpannableStringBuilder)localObject1).insert(0, (CharSequence)"  ");
        ((SpannableStringBuilder)localObject1).setSpan(localObject2, 0, 1, 34);
      }
      ((SpannableStringBuilder)localObject1).append((CharSequence)("(" + paramBundle.size() + ')'));
      setMMTitle((CharSequence)localObject1);
    }
    paramBundle = findViewById(2131307201);
    p.g(paramBundle, "findViewById(R.id.rv_same_topic)");
    this.GfF = ((WxRecyclerView)paramBundle);
    paramBundle = this.GfF;
    if (paramBundle == null) {
      p.btv("rvSameTopic");
    }
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    paramBundle = this.GfF;
    if (paramBundle == null) {
      p.btv("rvSameTopic");
    }
    paramBundle.setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new b(), this.kgc));
    paramBundle = this.GfF;
    if (paramBundle == null) {
      p.btv("rvSameTopic");
    }
    paramBundle.b((RecyclerView.h)new e(this));
    AppMethodBeat.o(216656);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(216652);
      e locale = (e)new com.tencent.mm.plugin.textstatus.b.d.a();
      AppMethodBeat.o(216652);
      return locale;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(TextStatusSameTopicsActivity paramTextStatusSameTopicsActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(258456);
      this.GfJ.onBackPressed();
      AppMethodBeat.o(258456);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$onCreate$3", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "plugin-textstatus_release"})
  public static final class e
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(258457);
      p.h(paramRect, "outRect");
      p.h(paramRecyclerView, "parent");
      paramRecyclerView = TextStatusSameTopicsActivity.a(this.GfJ).getAdapter();
      if (paramRecyclerView != null) {}
      for (int i = paramRecyclerView.getItemCount(); paramInt == i - 1; i = 1)
      {
        paramRect.bottom = com.tencent.mm.cb.a.fromDPToPix((Context)this.GfJ, 16);
        AppMethodBeat.o(258457);
        return;
      }
      paramRect.bottom = com.tencent.mm.cb.a.fromDPToPix((Context)this.GfJ, 8);
      AppMethodBeat.o(258457);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusSameTopicsActivity
 * JD-Core Version:    0.7.0.1
 */