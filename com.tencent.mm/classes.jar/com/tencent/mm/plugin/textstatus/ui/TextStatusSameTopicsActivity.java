package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.secdata.h;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.b.b;
import com.tencent.mm.plugin.textstatus.b.c;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/textstatus/model/topic/SameTopicItem;", "Lkotlin/collections/ArrayList;", "layoutOtherTopic", "Landroid/view/View;", "mClickPosListener", "com/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$mClickPosListener$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$mClickPosListener$1;", "mClickPosition", "", "getMClickPosition", "()I", "setMClickPosition", "(I)V", "pageSource", "rvSameTopic", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "tvOtherTopic", "Landroid/widget/TextView;", "tvOtherTopicNum", "tvSameFriendsStatusShowHere", "getTvSameFriendsStatusShowHere", "()Landroid/widget/TextView;", "tvSameFriendsStatusShowHere$delegate", "Lkotlin/Lazy;", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "limitTopicId", "", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "OnClickPosListener", "plugin-textstatus_release"})
public final class TextStatusSameTopicsActivity
  extends MMSecDataActivity
{
  public static final TextStatusSameTopicsActivity.a MNZ;
  private WxRecyclerView MNR;
  private View MNS;
  private TextView MNT;
  private TextView MNU;
  private final kotlin.f MNV;
  private int MNW;
  int MNX;
  private final d MNY;
  private ArrayList<com.tencent.mm.plugin.textstatus.g.f.b> mXB;
  
  static
  {
    AppMethodBeat.i(236313);
    MNZ = new TextStatusSameTopicsActivity.a((byte)0);
    AppMethodBeat.o(236313);
  }
  
  public TextStatusSameTopicsActivity()
  {
    AppMethodBeat.i(236312);
    this.MNV = kotlin.g.ar((kotlin.g.a.a)new h(this));
    this.mXB = new ArrayList();
    this.MNX = -1;
    this.MNY = new d(this);
    AppMethodBeat.o(236312);
  }
  
  private final TextView gnw()
  {
    AppMethodBeat.i(236299);
    TextView localTextView = (TextView)this.MNV.getValue();
    AppMethodBeat.o(236299);
    return localTextView;
  }
  
  public final int getLayoutId()
  {
    return b.f.Myc;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(236306);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new e(this));
    setActionbarColor(getResources().getColor(b.b.Dark_3));
    setNavigationbarColor(getResources().getColor(b.b.Dark_3));
    hideActionbarLine();
    paramBundle = com.tencent.mm.ui.component.g.Xox;
    ((com.tencent.mm.plugin.secdata.ui.a)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.secdata.ui.a.class)).a((h)new com.tencent.mm.plugin.secdata.c(com.tencent.mm.plugin.textstatus.proto.f.class, 9, (byte)0));
    paramBundle = com.tencent.mm.plugin.secdata.ui.a.JbV;
    paramBundle = (com.tencent.mm.plugin.textstatus.proto.f)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)this, 9, com.tencent.mm.plugin.textstatus.proto.f.class);
    if (paramBundle != null) {
      paramBundle.sessionId = d.Sx(1);
    }
    paramBundle = getIntent().getStringExtra("topic_id");
    boolean bool = getIntent().getBooleanExtra("is_show_other_topics", true);
    this.MNW = getIntent().getIntExtra("same_friend_page_source", 0);
    Object localObject1 = getIntent().getStringExtra("enter_username");
    Object localObject2 = com.tencent.mm.plugin.textstatus.b.f.MAm;
    localObject1 = com.tencent.mm.plugin.textstatus.b.f.bep((String)localObject1);
    localObject2 = com.tencent.mm.plugin.textstatus.b.f.MAm;
    localObject2 = com.tencent.mm.plugin.textstatus.b.f.gly();
    Object localObject3 = com.tencent.mm.plugin.auth.a.a.crN();
    p.j(localObject3, "Account.username()");
    localObject3 = ((com.tencent.mm.plugin.textstatus.g.e.f)localObject2).o(paramBundle, j.ag(new String[] { localObject3 }));
    localObject2 = ((List)localObject3).iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (com.tencent.mm.plugin.textstatus.g.e.a)((Iterator)localObject2).next();
      this.mXB.add(new com.tencent.mm.plugin.textstatus.g.f.b((com.tencent.mm.plugin.textstatus.g.e.a)localObject4));
    }
    Log.i("MicroMsg.TextStatus.TextStatusSameStatusActivity", "oncreate " + paramBundle + ',' + ((List)localObject3).size());
    localObject2 = findViewById(b.e.MvY);
    p.j(localObject2, "findViewById(R.id.layout_other_topics)");
    this.MNS = ((View)localObject2);
    localObject2 = new aa.d();
    ((aa.d)localObject2).aaBA = 0;
    int i;
    if (bool)
    {
      localObject4 = this.MNS;
      if (localObject4 == null) {
        p.bGy("layoutOtherTopic");
      }
      ((View)localObject4).setVisibility(0);
      localObject4 = findViewById(b.e.Mxd);
      p.j(localObject4, "findViewById(R.id.tv_other_topics)");
      this.MNT = ((TextView)localObject4);
      localObject4 = findViewById(b.e.Mxe);
      p.j(localObject4, "findViewById(R.id.tv_other_topics_num)");
      this.MNU = ((TextView)localObject4);
      localObject4 = com.tencent.mm.plugin.textstatus.b.f.MAm;
      localObject4 = com.tencent.mm.plugin.textstatus.b.f.bep(com.tencent.mm.plugin.auth.a.a.crN());
      com.tencent.mm.plugin.textstatus.b.f localf = com.tencent.mm.plugin.textstatus.b.f.MAm;
      int j = com.tencent.mm.plugin.textstatus.b.f.gly().gmg();
      int k = ((List)localObject3).size();
      if (localObject4 != null)
      {
        i = 1;
        ((aa.d)localObject2).aaBA = (j - (i + k));
        if ((((aa.d)localObject2).aaBA <= 0) || (this.mXB.size() <= 0)) {
          break label940;
        }
        localObject3 = this.MNS;
        if (localObject3 == null) {
          p.bGy("layoutOtherTopic");
        }
        ((View)localObject3).setVisibility(0);
        localObject3 = this.MNU;
        if (localObject3 == null) {
          p.bGy("tvOtherTopicNum");
        }
        ((TextView)localObject3).setText((CharSequence)String.valueOf(((aa.d)localObject2).aaBA));
        localObject3 = this.MNS;
        if (localObject3 == null) {
          p.bGy("layoutOtherTopic");
        }
        ((View)localObject3).setOnClickListener((View.OnClickListener)new f(this, paramBundle, (aa.d)localObject2));
        label599:
        localObject3 = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        i = this.MNW;
        if (((aa.d)localObject2).aaBA <= 0) {
          break label994;
        }
        bool = true;
        label620:
        com.tencent.mm.plugin.textstatus.h.a.a(1L, i, bool, ((aa.d)localObject2).aaBA);
        localObject2 = new SpannableStringBuilder();
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_IconID;
          ((SpannableStringBuilder)localObject2).append((CharSequence)com.tencent.mm.plugin.textstatus.k.c.gnz().beJ((String)localObject1));
          localObject1 = com.tencent.mm.plugin.textstatus.k.c.gnz().a((View)getMMTitleView(), (String)localObject1, a.c.MzI, com.tencent.mm.plugin.textstatus.a.a.a.Mzu, null, getResources().getDimensionPixelSize(b.c.Edge_3A), null);
          ((SpannableStringBuilder)localObject2).insert(0, (CharSequence)"  ");
          ((SpannableStringBuilder)localObject2).setSpan(localObject1, 0, 1, 34);
        }
        if (this.mXB.size() <= 0) {
          break label1000;
        }
        ((SpannableStringBuilder)localObject2).append((CharSequence)("(" + this.mXB.size() + ')'));
        gnw().setVisibility(8);
      }
    }
    for (;;)
    {
      setMMTitle((CharSequence)localObject2);
      localObject1 = findViewById(b.e.MwD);
      p.j(localObject1, "findViewById(R.id.rv_same_topic)");
      this.MNR = ((WxRecyclerView)localObject1);
      localObject1 = this.MNR;
      if (localObject1 == null) {
        p.bGy("rvSameTopic");
      }
      ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      localObject1 = this.MNR;
      if (localObject1 == null) {
        p.bGy("rvSameTopic");
      }
      ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new c(this, paramBundle), this.mXB));
      paramBundle = this.MNR;
      if (paramBundle == null) {
        p.bGy("rvSameTopic");
      }
      paramBundle.b((RecyclerView.h)new g(this));
      AppMethodBeat.o(236306);
      return;
      i = 0;
      break;
      label940:
      localObject3 = this.MNS;
      if (localObject3 == null) {
        p.bGy("layoutOtherTopic");
      }
      ((View)localObject3).setVisibility(8);
      break label599;
      localObject3 = this.MNS;
      if (localObject3 == null) {
        p.bGy("layoutOtherTopic");
      }
      ((View)localObject3).setVisibility(8);
      break label599;
      label994:
      bool = false;
      break label620;
      label1000:
      gnw().setVisibility(0);
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(236308);
    setRequestedOrientation(1);
    super.onResume();
    if (this.MNX > 0)
    {
      Object localObject = this.MNR;
      if (localObject == null) {
        p.bGy("rvSameTopic");
      }
      localObject = ((WxRecyclerView)localObject).getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).cL(this.MNX);
      }
      this.MNX = -1;
    }
    AppMethodBeat.o(236308);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$OnClickPosListener;", "", "onClickCard", "", "position", "", "plugin-textstatus_release"})
  public static abstract interface b
  {
    public abstract void ajn(int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"})
  public static final class c
    implements com.tencent.mm.view.recyclerview.f
  {
    c(String paramString) {}
    
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(234755);
      e locale = (e)new com.tencent.mm.plugin.textstatus.b.d.b(paramBundle, (TextStatusSameTopicsActivity.b)TextStatusSameTopicsActivity.c(this.MOa), TextStatusSameTopicsActivity.a(this.MOa));
      AppMethodBeat.o(234755);
      return locale;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$mClickPosListener$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$OnClickPosListener;", "onClickCard", "", "position", "", "plugin-textstatus_release"})
  public static final class d
    implements TextStatusSameTopicsActivity.b
  {
    public final void ajn(int paramInt)
    {
      this.MOa.MNX = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(TextStatusSameTopicsActivity paramTextStatusSameTopicsActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(232591);
      this.MOa.onBackPressed();
      AppMethodBeat.o(232591);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(TextStatusSameTopicsActivity paramTextStatusSameTopicsActivity, String paramString, aa.d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(233261);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = TextStatusOtherTopicFriendsActivity.MNI;
      TextStatusOtherTopicFriendsActivity.a.p((Context)this.MOa, paramBundle, 2);
      paramView = com.tencent.mm.plugin.textstatus.h.a.MGJ;
      int i = TextStatusSameTopicsActivity.a(this.MOa);
      if (this.MOd.aaBA > 0) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.plugin.textstatus.h.a.a(2L, i, bool, this.MOd.aaBA);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(233261);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$onCreate$4", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-textstatus_release"})
  public static final class g
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(233174);
      p.k(paramRect, "outRect");
      p.k(paramRecyclerView, "parent");
      paramRecyclerView = TextStatusSameTopicsActivity.b(this.MOa).getAdapter();
      if (paramRecyclerView != null) {}
      for (int i = paramRecyclerView.getItemCount(); paramInt == i - 1; i = 1)
      {
        paramRect.bottom = com.tencent.mm.ci.a.fromDPToPix((Context)this.MOa, 16);
        AppMethodBeat.o(233174);
        return;
      }
      paramRect.bottom = com.tencent.mm.ci.a.fromDPToPix((Context)this.MOa, 8);
      AppMethodBeat.o(233174);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<TextView>
  {
    h(TextStatusSameTopicsActivity paramTextStatusSameTopicsActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusSameTopicsActivity
 * JD-Core Version:    0.7.0.1
 */