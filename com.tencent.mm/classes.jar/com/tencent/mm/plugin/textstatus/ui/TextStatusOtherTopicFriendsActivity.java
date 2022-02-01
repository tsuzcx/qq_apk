package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.b;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.b.h;
import com.tencent.mm.plugin.textstatus.g.e.f.c;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.ak.a;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusOtherTopicFriendsActivity;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "()V", "MAX_AVATAR_NUM", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/textstatus/model/topic/SameTopicFriendsItem;", "Lkotlin/collections/ArrayList;", "rvOtherTopic", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "source", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getUvPerIconStr", "", "", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage$SameTopicStruct;", "Companion", "plugin-textstatus_release"})
public final class TextStatusOtherTopicFriendsActivity
  extends MMSecDataActivity
{
  public static final TextStatusOtherTopicFriendsActivity.a MNI;
  private WxRecyclerView MNG;
  private int MNH;
  private ArrayList<com.tencent.mm.plugin.textstatus.g.f.a> mXB;
  
  static
  {
    AppMethodBeat.i(233531);
    MNI = new TextStatusOtherTopicFriendsActivity.a((byte)0);
    AppMethodBeat.o(233531);
  }
  
  public TextStatusOtherTopicFriendsActivity()
  {
    AppMethodBeat.i(233529);
    this.mXB = new ArrayList();
    this.MNH = 2147483647;
    AppMethodBeat.o(233529);
  }
  
  private static String iq(List<f.c> paramList)
  {
    AppMethodBeat.i(233527);
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      f.c localc = (f.c)paramList.next();
      if (i != 0) {
        localStringBuilder.append(";");
      }
      if (localc.lxh.size() > 0)
      {
        localStringBuilder.append(((com.tencent.mm.plugin.textstatus.g.e.a)localc.lxh.get(0)).field_IconID);
        localStringBuilder.append("#");
        localStringBuilder.append(localc.lxh.size());
      }
      i += 1;
    }
    paramList = localStringBuilder.toString();
    p.j(paramList, "sb.toString()");
    AppMethodBeat.o(233527);
    return paramList;
  }
  
  public final int getLayoutId()
  {
    return b.f.MxT;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(233526);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
    setActionbarColor(getResources().getColor(b.b.Dark_3));
    setNavigationbarColor(getResources().getColor(b.b.Dark_3));
    hideActionbarLine();
    setMMTitle(b.h.Mzb);
    Object localObject = getIntent().getStringExtra("exclude_topic_id");
    final int i = getIntent().getIntExtra("key_source", 0);
    paramBundle = com.tencent.mm.plugin.textstatus.b.f.MAm;
    paramBundle = com.tencent.mm.plugin.textstatus.b.f.gly().lA((String)localObject, com.tencent.mm.plugin.auth.a.a.crN());
    new StringBuilder("oncreate ").append((String)localObject).append(' ').append(paramBundle.size());
    h.ioq();
    localObject = paramBundle.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f.c localc = (f.c)((Iterator)localObject).next();
      if (localc.isValid()) {
        this.mXB.add(new com.tencent.mm.plugin.textstatus.g.f.a(localc));
      }
    }
    localObject = findViewById(b.e.MwC);
    p.j(localObject, "findViewById(R.id.rv_other_topic)");
    this.MNG = ((WxRecyclerView)localObject);
    localObject = this.MNG;
    if (localObject == null) {
      p.bGy("rvOtherTopic");
    }
    ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    localObject = this.MNG;
    if (localObject == null) {
      p.bGy("rvOtherTopic");
    }
    ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new b(this, i), this.mXB));
    localObject = this.MNG;
    if (localObject == null) {
      p.bGy("rvOtherTopic");
    }
    ((WxRecyclerView)localObject).b((RecyclerView.h)new d(this));
    int j = ak.kU((Context)this).width;
    int k = com.tencent.mm.ci.a.fromDPToPix((Context)this, 24);
    int m = com.tencent.mm.ci.a.fromDPToPix((Context)this, 32);
    int n = com.tencent.mm.ci.a.fromDPToPix((Context)this, 24);
    int i1 = com.tencent.mm.ci.a.fromDPToPix((Context)this, 32);
    this.MNH = ((j - k * 2 - m - n) / (com.tencent.mm.ci.a.fromDPToPix((Context)this, 8) + i1));
    paramBundle = iq(paramBundle);
    localObject = com.tencent.mm.plugin.textstatus.h.a.MGJ;
    com.tencent.mm.plugin.textstatus.h.a.a(1L, null, 0, null, paramBundle, null, i, 46);
    AppMethodBeat.o(233526);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusOtherTopicFriendsActivity$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.f
  {
    b(int paramInt) {}
    
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(235658);
      e locale = (e)new com.tencent.mm.plugin.textstatus.b.d.a(TextStatusOtherTopicFriendsActivity.b(this.MNJ), i);
      AppMethodBeat.o(235658);
      return locale;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(TextStatusOtherTopicFriendsActivity paramTextStatusOtherTopicFriendsActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(237180);
      this.MNJ.onBackPressed();
      AppMethodBeat.o(237180);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusOtherTopicFriendsActivity$onCreate$2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-textstatus_release"})
  public static final class d
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(232900);
      p.k(paramRect, "outRect");
      p.k(paramRecyclerView, "parent");
      paramRecyclerView = TextStatusOtherTopicFriendsActivity.a(this.MNJ).getAdapter();
      if (paramRecyclerView != null) {}
      for (int i = paramRecyclerView.getItemCount(); paramInt == i - 1; i = 1)
      {
        paramRect.bottom = com.tencent.mm.ci.a.fromDPToPix((Context)this.MNJ, 16);
        AppMethodBeat.o(232900);
        return;
      }
      paramRect.bottom = com.tencent.mm.ci.a.fromDPToPix((Context)this.MNJ, 8);
      AppMethodBeat.o(232900);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusOtherTopicFriendsActivity
 * JD-Core Version:    0.7.0.1
 */