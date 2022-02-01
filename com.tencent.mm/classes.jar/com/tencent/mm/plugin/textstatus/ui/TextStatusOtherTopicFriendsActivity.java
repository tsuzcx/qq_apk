package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.plugin.mvvmlist.e;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.plugin.textstatus.a.b;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.a.aa;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.plugin.textstatus.a.w.a;
import com.tencent.mm.plugin.textstatus.h.f.g.c;
import com.tencent.mm.plugin.textstatus.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusOtherTopicFriendsActivity;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataActivity;", "()V", "MAX_AVATAR_NUM", "", "dataList", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "Lcom/tencent/mm/plugin/textstatus/model/topic/SameTopicFriendsItem;", "getDataList", "()Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "setDataList", "(Lcom/tencent/mm/plugin/mvvmlist/MvvmList;)V", "isFirstOnResume", "", "()Z", "setFirstOnResume", "(Z)V", "llSetTextStatus", "Landroid/widget/LinearLayout;", "getLlSetTextStatus", "()Landroid/widget/LinearLayout;", "llSetTextStatus$delegate", "Lkotlin/Lazy;", "llWithoutFriendsStatus", "Landroid/view/ViewGroup;", "getLlWithoutFriendsStatus", "()Landroid/view/ViewGroup;", "llWithoutFriendsStatus$delegate", "notifyCallbackForOptionBtn", "Lkotlin/Function0;", "notifyCallbackForSource", "root", "getRoot", "root$delegate", "rvOtherTopic", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRvOtherTopic", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "rvOtherTopic$delegate", "source", "getSource", "()I", "source$delegate", "startTime", "", "getStartTime", "()J", "setStartTime", "(J)V", "tvWithoutFriendsStatus", "Landroid/widget/TextView;", "getTvWithoutFriendsStatus", "()Landroid/widget/TextView;", "tvWithoutFriendsStatus$delegate", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getLayoutId", "handleClickBackPos", "", "list", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusOtherTopicFriendsActivity
  extends MMSecDataActivity
{
  public static final TextStatusOtherTopicFriendsActivity.a TzE;
  private final kotlin.j TzF;
  private final kotlin.j TzG;
  private int TzH;
  private final kotlin.j TzI;
  private final kotlin.j TzJ;
  private final kotlin.j TzK;
  private final kotlin.j TzL;
  MvvmList<com.tencent.mm.plugin.textstatus.h.g.b> TzM;
  private final kotlin.g.a.a<Integer> TzN;
  private final kotlin.g.a.a<Integer> TzO;
  private boolean isFirstOnResume;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(291738);
    TzE = new TextStatusOtherTopicFriendsActivity.a((byte)0);
    AppMethodBeat.o(291738);
  }
  
  public TextStatusOtherTopicFriendsActivity()
  {
    AppMethodBeat.i(291671);
    this.TzF = kotlin.k.cm((kotlin.g.a.a)new k(this));
    this.TzG = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.TzH = 2147483647;
    this.TzI = kotlin.k.cm((kotlin.g.a.a)new l(this));
    this.TzJ = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.TzK = kotlin.k.cm((kotlin.g.a.a)new m(this));
    this.TzL = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.isFirstOnResume = true;
    this.TzN = ((kotlin.g.a.a)new e(this));
    this.TzO = ((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(291671);
  }
  
  private static final void a(TextStatusOtherTopicFriendsActivity paramTextStatusOtherTopicFriendsActivity, View paramView)
  {
    AppMethodBeat.i(291705);
    s.u(paramTextStatusOtherTopicFriendsActivity, "this$0");
    paramView = new w.a().ThS;
    paramView.Toi = 15L;
    aa localaa = aa.ThY;
    aa.a((Activity)paramTextStatusOtherTopicFriendsActivity.getContext(), paramView, 1001);
    paramTextStatusOtherTopicFriendsActivity = com.tencent.mm.plugin.textstatus.i.b.Trt;
    com.tencent.mm.plugin.textstatus.i.b.a(36L, null, null, 0L, null, 30);
    AppMethodBeat.o(291705);
  }
  
  private static final void a(TextStatusOtherTopicFriendsActivity paramTextStatusOtherTopicFriendsActivity, List paramList)
  {
    int j = 1;
    AppMethodBeat.i(291722);
    s.u(paramTextStatusOtherTopicFriendsActivity, "this$0");
    s.s(paramList, "it");
    int i;
    if (!((Collection)paramList).isEmpty())
    {
      i = 1;
      if (i != 0) {
        paramTextStatusOtherTopicFriendsActivity.hJW().setVisibility(8);
      }
    }
    for (;;)
    {
      try
      {
        String str = ((j)paramTextStatusOtherTopicFriendsActivity.component(j.class)).Tzm;
        Object localObject1 = (CharSequence)str;
        i = j;
        if (localObject1 != null)
        {
          if (!n.bp((CharSequence)localObject1)) {
            break label539;
          }
          i = j;
        }
        if (i == 0)
        {
          ((j)paramTextStatusOtherTopicFriendsActivity.component(j.class)).Tzm = null;
          paramList = ((Iterable)paramList).iterator();
          i = 0;
          if (paramList.hasNext())
          {
            localObject1 = paramList.next();
            if (i < 0) {
              p.kkW();
            }
            localObject1 = ((Iterable)((com.tencent.mm.plugin.textstatus.h.g.b)localObject1).TnV.bMQ).iterator();
            j = 0;
            if (!((Iterator)localObject1).hasNext()) {
              break label544;
            }
            Object localObject2 = ((Iterator)localObject1).next();
            if (j < 0) {
              p.kkW();
            }
            if (!s.p(((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_UserName, str)) {
              break label527;
            }
            localObject2 = (m)paramTextStatusOtherTopicFriendsActivity.component(m.class);
            ((m)localObject2).TAu = Integer.valueOf(i);
            RecyclerView localRecyclerView = ((m)localObject2).mkw;
            if (localRecyclerView == null)
            {
              k = 0;
              ((m)localObject2).ESj = (k / 3);
              new StringBuilder("initScrollPos() called pos:").append(((m)localObject2).TAu).append(" offset:").append(((m)localObject2).ESj);
              m.a((m)localObject2);
              break label527;
            }
            int k = localRecyclerView.getMeasuredHeight();
            continue;
          }
          AppMethodBeat.o(291722);
          return;
        }
        m.a((m)paramTextStatusOtherTopicFriendsActivity.component(m.class));
        AppMethodBeat.o(291722);
        return;
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.TextStatus.TextStatusOtherTopicFriendsActivity", paramTextStatusOtherTopicFriendsActivity, "handleClickBackPosErr", new Object[0]);
        AppMethodBeat.o(291722);
        return;
      }
      paramTextStatusOtherTopicFriendsActivity.hJW().setVisibility(0);
      paramList = paramTextStatusOtherTopicFriendsActivity.hJW();
      i = bf.fs((Context)paramTextStatusOtherTopicFriendsActivity.getContext());
      paramList.setPadding(0, 0, 0, (bf.getStatusBarHeight((Context)paramTextStatusOtherTopicFriendsActivity.getContext()) + i) / 2);
      aw.d((Paint)((TextView)paramTextStatusOtherTopicFriendsActivity.TzK.getValue()).getPaint());
      paramList = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      paramList = com.tencent.mm.plugin.textstatus.b.f.bdN(com.tencent.mm.plugin.auth.a.a.cUx());
      if (paramList == null)
      {
        paramList = null;
        paramList = (CharSequence)paramList;
        if ((paramList != null) && (!n.bp(paramList))) {
          break label496;
        }
        i = 1;
        label452:
        if (i == 0) {
          break label501;
        }
        paramTextStatusOtherTopicFriendsActivity.hJX().setVisibility(8);
      }
      for (;;)
      {
        paramTextStatusOtherTopicFriendsActivity = com.tencent.mm.plugin.textstatus.i.b.Trt;
        com.tencent.mm.plugin.textstatus.i.b.a(35L, null, null, 0L, null, 30);
        AppMethodBeat.o(291722);
        return;
        paramList = paramList.field_IconID;
        break;
        label496:
        i = 0;
        break label452;
        label501:
        paramTextStatusOtherTopicFriendsActivity.hJX().setVisibility(0);
        paramTextStatusOtherTopicFriendsActivity.hJX().setOnClickListener(new TextStatusOtherTopicFriendsActivity..ExternalSyntheticLambda1(paramTextStatusOtherTopicFriendsActivity));
      }
      label527:
      j += 1;
      continue;
      i = 0;
      break;
      label539:
      i = 0;
      continue;
      label544:
      i += 1;
    }
  }
  
  private static final boolean a(TextStatusOtherTopicFriendsActivity paramTextStatusOtherTopicFriendsActivity, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(291698);
    s.u(paramTextStatusOtherTopicFriendsActivity, "this$0");
    paramTextStatusOtherTopicFriendsActivity.onBackPressed();
    AppMethodBeat.o(291698);
    return true;
  }
  
  private final WxRecyclerView hJV()
  {
    AppMethodBeat.i(291678);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)this.TzF.getValue();
    AppMethodBeat.o(291678);
    return localWxRecyclerView;
  }
  
  private final ViewGroup hJW()
  {
    AppMethodBeat.i(291687);
    ViewGroup localViewGroup = (ViewGroup)this.TzJ.getValue();
    AppMethodBeat.o(291687);
    return localViewGroup;
  }
  
  private final LinearLayout hJX()
  {
    AppMethodBeat.i(291692);
    LinearLayout localLinearLayout = (LinearLayout)this.TzL.getValue();
    AppMethodBeat.o(291692);
    return localLinearLayout;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return a.f.TfB;
  }
  
  public final int getSource()
  {
    AppMethodBeat.i(291760);
    int i = ((Number)this.TzI.getValue()).intValue();
    AppMethodBeat.o(291760);
    return i;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(291811);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(291811);
      return;
    case 1001: 
      finish();
      AppMethodBeat.o(291811);
      return;
    }
    if (paramIntent == null) {
      paramIntent = "";
    }
    for (;;)
    {
      ((j)component(j.class)).Tzm = paramIntent;
      break;
      paramIntent = paramIntent.getStringExtra("KEY_SCROLL_USER_NAME");
      if (paramIntent == null) {
        paramIntent = "";
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(291787);
    super.onCreate(paramBundle);
    this.startTime = cn.bDw();
    setBackBtn(new TextStatusOtherTopicFriendsActivity..ExternalSyntheticLambda0(this));
    if (ac.hGq())
    {
      setActionbarColor(getResources().getColor(a.b.white));
      setNavigationbarColor(getResources().getColor(a.b.white));
    }
    for (;;)
    {
      hideActionbarLine();
      setMMTitle(a.h.TgU);
      Object localObject = getIntent().getStringExtra("exclude_topic_id");
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      paramBundle = com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(j.class);
      s.s(paramBundle, "UICProvider.of(this).get…pPageDataUIC::class.java)");
      paramBundle = (j)paramBundle;
      hJV().setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      localObject = (com.tencent.mm.plugin.mvvmlist.a.f)new com.tencent.mm.plugin.textstatus.h.c.f((Context)this, (String)localObject, getSource());
      e locale = new e();
      locale.wDG = true;
      ah localah = ah.aiuX;
      localObject = new MvvmList((com.tencent.mm.plugin.mvvmlist.a.f)localObject, locale, (q)this);
      this.TzM = ((MvvmList)localObject);
      ((MvvmList)localObject).MmR.a((q)this, new TextStatusOtherTopicFriendsActivity..ExternalSyntheticLambda2(this));
      paramBundle.mlt = ((RecyclerView.a)new g((MvvmList)localObject, (com.tencent.mm.view.recyclerview.g)new b(this, getSource())));
      hJV().setAdapter(paramBundle.mlt);
      hJV().setAnimation(null);
      paramBundle = hJV().getItemAnimator();
      if (paramBundle != null) {
        paramBundle.bZL = 0L;
      }
      hJV().setItemAnimator(null);
      hJV().a((RecyclerView.h)new h(this));
      if (ac.hGq())
      {
        ((LinearLayout)this.TzG.getValue()).setBackgroundColor(getResources().getColor(a.b.white));
        hJV().setBackgroundColor(getResources().getColor(a.b.white));
      }
      int i = ao.mX((Context)this).width;
      int j = com.tencent.mm.cd.a.fromDPToPix((Context)this, 24);
      int k = com.tencent.mm.cd.a.fromDPToPix((Context)this, 32);
      int m = com.tencent.mm.cd.a.fromDPToPix((Context)this, 24);
      int n = com.tencent.mm.cd.a.fromDPToPix((Context)this, 32);
      this.TzH = ((i - j * 2 - k - m) / (com.tencent.mm.cd.a.fromDPToPix((Context)this, 8) + n));
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      ((k)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(k.class)).TzD = this.TzN;
      ((m)component(m.class)).K((RecyclerView)hJV());
      AppMethodBeat.o(291787);
      return;
      setActionbarColor(getResources().getColor(a.b.Dark_3));
      setNavigationbarColor(getResources().getColor(a.b.Dark_3));
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(291771);
    super.onDestroy();
    long l1 = cn.bDw();
    long l2 = this.startTime;
    Object localObject = com.tencent.mm.plugin.textstatus.i.b.Trt;
    com.tencent.mm.plugin.textstatus.i.b.a(9L, null, 0, null, null, null, 0, l1 - l2, 126);
    localObject = TextStatusCardFeedsActivity.Txc;
    TextStatusCardFeedsActivity.hIF().clear();
    AppMethodBeat.o(291771);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(291794);
    super.onResume();
    if (!this.isFirstOnResume) {
      d.e("MicroMsg.TextStatus.TextStatusOtherTopicFriendsActivity", (kotlin.g.a.a)new i(this));
    }
    if (this.isFirstOnResume) {
      this.isFirstOnResume = false;
    }
    AppMethodBeat.o(291794);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(291801);
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(k.class);
    paramHashSet.add(j.class);
    paramHashSet.add(f.class);
    paramHashSet.add(c.class);
    paramHashSet.add(m.class);
    AppMethodBeat.o(291801);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusOtherTopicFriendsActivity$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.view.recyclerview.g
  {
    b(TextStatusOtherTopicFriendsActivity paramTextStatusOtherTopicFriendsActivity, int paramInt) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(291717);
      if (paramInt == -2)
      {
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.textstatus.b.c.a(TextStatusOtherTopicFriendsActivity.b(this.TzP));
        AppMethodBeat.o(291717);
        return localf;
      }
      if (ac.hGq())
      {
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.textstatus.b.c.f(this.Bym);
        AppMethodBeat.o(291717);
        return localf;
      }
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.textstatus.b.c.b(TextStatusOtherTopicFriendsActivity.c(this.TzP), this.Bym);
      AppMethodBeat.o(291717);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    c(TextStatusOtherTopicFriendsActivity paramTextStatusOtherTopicFriendsActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    d(TextStatusOtherTopicFriendsActivity paramTextStatusOtherTopicFriendsActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<Integer>
  {
    e(TextStatusOtherTopicFriendsActivity paramTextStatusOtherTopicFriendsActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<Integer>
  {
    f(TextStatusOtherTopicFriendsActivity paramTextStatusOtherTopicFriendsActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusOtherTopicFriendsActivity$onCreate$3", "Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "Lcom/tencent/mm/plugin/textstatus/model/topic/SameTopicFriendsItem;", "needBindClickEvent", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends com.tencent.mm.plugin.mvvmlist.g<com.tencent.mm.plugin.textstatus.h.g.b>
  {
    g(MvvmList<com.tencent.mm.plugin.textstatus.h.g.b> paramMvvmList, com.tencent.mm.view.recyclerview.g paramg)
    {
      super(paramg, (byte)0);
    }
    
    public final boolean bZD()
    {
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusOtherTopicFriendsActivity$onCreate$4", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends RecyclerView.h
  {
    h(TextStatusOtherTopicFriendsActivity paramTextStatusOtherTopicFriendsActivity) {}
    
    public final void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(291684);
      s.u(paramRect, "outRect");
      s.u(paramRecyclerView, "parent");
      paramRecyclerView = TextStatusOtherTopicFriendsActivity.a(this.TzP).getAdapter();
      if (paramRecyclerView == null) {}
      for (int i = 1; paramInt == i - 1; i = paramRecyclerView.getItemCount())
      {
        paramRect.bottom = com.tencent.mm.cd.a.fromDPToPix((Context)this.TzP, 16);
        AppMethodBeat.o(291684);
        return;
      }
      paramRect.bottom = com.tencent.mm.cd.a.fromDPToPix((Context)this.TzP, 8);
      AppMethodBeat.o(291684);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(TextStatusOtherTopicFriendsActivity paramTextStatusOtherTopicFriendsActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    j(TextStatusOtherTopicFriendsActivity paramTextStatusOtherTopicFriendsActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<WxRecyclerView>
  {
    k(TextStatusOtherTopicFriendsActivity paramTextStatusOtherTopicFriendsActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<Integer>
  {
    l(TextStatusOtherTopicFriendsActivity paramTextStatusOtherTopicFriendsActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<TextView>
  {
    m(TextStatusOtherTopicFriendsActivity paramTextStatusOtherTopicFriendsActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusOtherTopicFriendsActivity
 * JD-Core Version:    0.7.0.1
 */