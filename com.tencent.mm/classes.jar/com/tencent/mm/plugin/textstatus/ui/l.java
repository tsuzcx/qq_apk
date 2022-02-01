package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextPaint;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.p;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.b;
import com.google.android.material.tabs.TabLayout.e;
import com.google.android.material.tabs.TabLayout.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.conversation.d.e;
import com.tencent.mm.plugin.textstatus.conversation.d.f.a;
import com.tencent.mm.plugin.textstatus.conversation.h.b;
import com.tencent.mm.plugin.textstatus.conversation.ui.TextStatusConversationFragment;
import com.tencent.mm.plugin.textstatus.h.f.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.y;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusPagerUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "convFragment", "Landroidx/fragment/app/Fragment;", "getConvFragment", "()Landroidx/fragment/app/Fragment;", "convFragment$delegate", "Lkotlin/Lazy;", "isOnResumeFirstCalled", "", "()Z", "setOnResumeFirstCalled", "(Z)V", "lastConvTabCnt", "", "getLastConvTabCnt", "()I", "setLastConvTabCnt", "(I)V", "lastInteractCnt", "getLastInteractCnt", "setLastInteractCnt", "likeListFragment", "getLikeListFragment", "likeListFragment$delegate", "pageAdapter", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusPagerUIC$MyPageAdapter;", "getPageAdapter", "()Lcom/tencent/mm/plugin/textstatus/ui/TextStatusPagerUIC$MyPageAdapter;", "pageAdapter$delegate", "pageCnt", "getPageCnt", "pageCnt$delegate", "scene", "getScene", "scene$delegate", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "getTabLayout", "()Lcom/google/android/material/tabs/TabLayout;", "tabLayout$delegate", "initActionBar", "", "markShownTime", "index", "onDestroy", "onFinished", "onNotifyChange", "event", "", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onPause", "onResume", "updateTab", "updateIndex", "attachRedInfo", "Lcom/google/android/material/tabs/TabLayout$Tab;", "redInfo", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusPagerUIC$RedInfo;", "getTabCnt", "setSelected", "selected", "setTitle", "charSequence", "", "Companion", "MyPageAdapter", "RedInfo", "TextStatusTabHolder", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends UIComponent
  implements MStorage.IOnStorageChange
{
  public static final l.a TzR;
  final j Tja;
  final j TzS;
  final j TzT;
  boolean TzU;
  private final j TzV;
  int TzW;
  int TzX;
  private final j Tzo;
  private final j pmx;
  
  static
  {
    AppMethodBeat.i(291362);
    TzR = new l.a((byte)0);
    AppMethodBeat.o(291362);
  }
  
  public l(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(291268);
    this.Tzo = kotlin.k.cm((kotlin.g.a.a)new i(this, paramAppCompatActivity));
    this.TzS = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.TzT = kotlin.k.cm((kotlin.g.a.a)e.TAf);
    this.TzU = true;
    this.TzV = kotlin.k.cm((kotlin.g.a.a)new l(this));
    this.pmx = kotlin.k.cm((kotlin.g.a.a)new k(this));
    this.Tja = kotlin.k.cm((kotlin.g.a.a)new j(this));
    AppMethodBeat.o(291268);
  }
  
  private static void a(TabLayout.e parame, l.c paramc)
  {
    AppMethodBeat.i(291302);
    Log.d("MicroMsg.TextStatus.TextStatusPagerUIC", "attachRedInfo() called with: tabpos = " + parame.position + " redInfo = " + paramc);
    Object localObject = parame.tag;
    if ((localObject instanceof d))
    {
      localObject = (d)localObject;
      if (localObject != null)
      {
        ((d)localObject).TAd = paramc;
        switch (paramc.hAN)
        {
        default: 
          label96:
          paramc = parame.dyM;
          if ((paramc instanceof View))
          {
            paramc = (View)paramc;
            label113:
            if (paramc != null)
            {
              paramc = paramc.getLayoutParams();
              if (paramc != null)
              {
                paramc.width = -2;
                parame = parame.dyM;
                if (!(parame instanceof View)) {
                  break label300;
                }
              }
            }
          }
          break;
        }
      }
    }
    label300:
    for (parame = (View)parame;; parame = null)
    {
      if (parame != null) {
        parame.setLayoutParams(paramc);
      }
      AppMethodBeat.o(291302);
      return;
      localObject = null;
      break;
      paramc = ((d)localObject).hKa();
      if (paramc != null) {
        paramc.setVisibility(8);
      }
      paramc = ((d)localObject).hKb();
      if (paramc == null) {
        break label96;
      }
      paramc.setVisibility(8);
      break label96;
      TextView localTextView = ((d)localObject).hKa();
      if (localTextView != null) {
        localTextView.setVisibility(0);
      }
      localTextView = ((d)localObject).hKa();
      if (localTextView != null) {
        localTextView.setText((CharSequence)s.X("+", Integer.valueOf(paramc.count)));
      }
      paramc = ((d)localObject).hKb();
      if (paramc == null) {
        break label96;
      }
      paramc.setVisibility(8);
      break label96;
      paramc = ((d)localObject).hKb();
      if (paramc != null) {
        paramc.setVisibility(0);
      }
      paramc = ((d)localObject).hKa();
      if (paramc == null) {
        break label96;
      }
      paramc.setVisibility(8);
      break label96;
      paramc = null;
      break label113;
    }
  }
  
  private static final boolean a(l paraml, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(291329);
    s.u(paraml, "this$0");
    paraml = paraml.getActivity();
    if ((paraml instanceof MMActivity)) {}
    for (paraml = (MMActivity)paraml;; paraml = null)
    {
      if (paraml != null) {
        paraml.onBackPressed();
      }
      AppMethodBeat.o(291329);
      return true;
    }
  }
  
  public static void aoA(int paramInt)
  {
    AppMethodBeat.i(291314);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(291314);
      return;
      com.tencent.mm.plugin.textstatus.b.f localf = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      com.tencent.mm.plugin.textstatus.b.f.hGR();
      AppMethodBeat.o(291314);
      return;
      localf = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      com.tencent.mm.plugin.textstatus.b.f.hGS();
    }
  }
  
  private TabLayout fmz()
  {
    AppMethodBeat.i(291279);
    Object localObject = this.TzV.getValue();
    s.s(localObject, "<get-tabLayout>(...)");
    localObject = (TabLayout)localObject;
    AppMethodBeat.o(291279);
    return localObject;
  }
  
  public final void aoz(int paramInt)
  {
    AppMethodBeat.i(291457);
    if (paramInt != -1)
    {
      TabLayout.e locale = fmz().js(paramInt);
      if (locale != null)
      {
        hJY();
        a(locale, b.aoB(paramInt));
      }
    }
    AppMethodBeat.o(291457);
  }
  
  public final b hJY()
  {
    AppMethodBeat.i(291378);
    b localb = (b)this.Tzo.getValue();
    AppMethodBeat.o(291378);
    return localb;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(291436);
    super.onDestroy();
    com.tencent.mm.plugin.textstatus.b.f localf = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    com.tencent.mm.plugin.textstatus.b.f.hGQ();
    com.tencent.mm.plugin.textstatus.b.f.hGU();
    com.tencent.mm.plugin.textstatus.b.f.hGN().remove((MStorage.IOnStorageChange)this);
    com.tencent.mm.plugin.textstatus.b.f.hGL().remove((MStorage.IOnStorageChange)this);
    com.tencent.mm.plugin.textstatus.b.f.hGI().remove((MStorage.IOnStorageChange)this);
    com.tencent.mm.plugin.textstatus.b.f.hGJ().remove((MStorage.IOnStorageChange)this);
    AppMethodBeat.o(291436);
  }
  
  public final void onFinished()
  {
    AppMethodBeat.i(291420);
    super.onFinished();
    f.a locala = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
    f.a.ko((Context)getContext());
    com.tencent.mm.plugin.textstatus.conversation.d.f.o(4, 0, 0, 0, 14);
    AppMethodBeat.o(291420);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(291449);
    Log.d("MicroMsg.TextStatus.TextStatusPagerUIC", "onNotifyChange() called with: event = " + paramString + ", eventData = " + paramMStorageEventData);
    boolean bool;
    label54:
    int i;
    if (paramMStorageEventData == null)
    {
      paramString = null;
      if (!(paramString instanceof d)) {
        break label96;
      }
      bool = true;
      if (!bool) {
        break label105;
      }
      i = 0;
    }
    for (;;)
    {
      aoz(i);
      if (i == fmz().getSelectedTabPosition()) {
        aoA(i);
      }
      AppMethodBeat.o(291449);
      return;
      paramString = paramMStorageEventData.stg;
      break;
      label96:
      bool = paramString instanceof com.tencent.mm.plugin.textstatus.h.f.f;
      break label54;
      label105:
      if ((paramString instanceof com.tencent.mm.plugin.textstatus.conversation.h.a)) {}
      for (bool = true;; bool = paramString instanceof b)
      {
        if (!bool) {
          break label134;
        }
        i = 1;
        break;
      }
      label134:
      i = -1;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(291408);
    super.onPause();
    com.tencent.mm.plugin.textstatus.b.f localf = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    com.tencent.mm.plugin.textstatus.b.f.hGU();
    AppMethodBeat.o(291408);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(291400);
    super.onResume();
    if (this.TzU)
    {
      localObject1 = getActivity();
      if ((localObject1 instanceof MMActivity)) {}
      for (localObject1 = (MMActivity)localObject1;; localObject1 = null)
      {
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = ((MMActivity)localObject1).getController();
          if (localObject1 != null)
          {
            localObject2 = getActivity();
            ((y)localObject1).adEp = a.f.TeZ;
            ((y)localObject1).bR((Activity)localObject2);
          }
        }
        int j = hJY().getCount();
        i = 0;
        while (i < j)
        {
          hJY();
          localObject1 = b.b(fmz());
          localObject2 = hJY();
          s.u(localObject1, "tab");
          localObject2 = ((b)localObject2).getPageTitle(i);
          Object localObject3 = ((TabLayout.e)localObject1).tag;
          if ((localObject3 instanceof d))
          {
            localObject3 = ((d)localObject3).hJZ();
            if (localObject3 != null) {
              ((TextView)localObject3).setText((CharSequence)localObject2);
            }
          }
          a((TabLayout.e)localObject1, b.aoB(i));
          fmz().a((TabLayout.e)localObject1, false);
          i += 1;
        }
      }
      localObject1 = (ViewPager)getActivity().findViewById(a.e.pager);
      fmz().a((TabLayout.b)new f(this, (ViewPager)localObject1));
      ((ViewPager)localObject1).addOnPageChangeListener((ViewPager.OnPageChangeListener)new l.g(fmz()));
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      int i = ((e)com.tencent.mm.ui.component.k.nq((Context)getContext()).q(e.class)).hGw();
      localObject1 = fmz().js(i);
      if (localObject1 != null) {
        ((TabLayout.e)localObject1).Xf();
      }
      localObject1 = getActivity();
      if (!(localObject1 instanceof MMActivity)) {
        break label399;
      }
      localObject1 = (MMActivity)localObject1;
      if (localObject1 != null) {
        ((MMActivity)localObject1).setMMTitle("");
      }
      localObject1 = getActivity();
      if (!(localObject1 instanceof MMActivity)) {
        break label404;
      }
    }
    label399:
    label404:
    for (Object localObject1 = (MMActivity)localObject1;; localObject1 = null)
    {
      if (localObject1 != null) {
        ((MMActivity)localObject1).setBackBtn(new l..ExternalSyntheticLambda0(this));
      }
      localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      com.tencent.mm.plugin.textstatus.b.f.hGN().add((MStorage.IOnStorageChange)this);
      com.tencent.mm.plugin.textstatus.b.f.hGL().add((MStorage.IOnStorageChange)this);
      com.tencent.mm.plugin.textstatus.b.f.hGI().add((MStorage.IOnStorageChange)this);
      com.tencent.mm.plugin.textstatus.b.f.hGJ().add((MStorage.IOnStorageChange)this);
      this.TzU = false;
      localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      com.tencent.mm.plugin.textstatus.b.f.hGQ();
      AppMethodBeat.o(291400);
      return;
      localObject1 = null;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusPagerUIC$MyPageAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusPagerUIC;Landroidx/fragment/app/FragmentManager;)V", "createTab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getPageTitle", "", "getRedInfo", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusPagerUIC$RedInfo;", "setTabContent", "", "tab", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends p
  {
    public b()
    {
      super();
      AppMethodBeat.i(291286);
      AppMethodBeat.o(291286);
    }
    
    public static l.c aoB(int paramInt)
    {
      AppMethodBeat.i(291296);
      l.c localc = new l.c((byte)0);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(291296);
        return localc;
        com.tencent.mm.plugin.textstatus.b.f localf = com.tencent.mm.plugin.textstatus.b.f.TjQ;
        paramInt = com.tencent.mm.plugin.textstatus.b.f.hGP();
        if (paramInt > 0)
        {
          localc.hAN = 1;
          localc.count = paramInt;
        }
        else
        {
          localc.hAN = 0;
          localc.count = 0;
          continue;
          localf = com.tencent.mm.plugin.textstatus.b.f.TjQ;
          paramInt = com.tencent.mm.plugin.textstatus.b.f.hGL().hGB();
          if (paramInt > 0)
          {
            localc.hAN = 1;
            localc.count = paramInt;
          }
          else
          {
            localf = com.tencent.mm.plugin.textstatus.b.f.TjQ;
            paramInt = com.tencent.mm.plugin.textstatus.b.f.hGT();
            localf = com.tencent.mm.plugin.textstatus.b.f.TjQ;
            if (com.tencent.mm.plugin.textstatus.b.f.aop(paramInt) != null)
            {
              localc.hAN = 2;
              localc.count = 0;
            }
            else
            {
              localc.hAN = 0;
              localc.count = 0;
            }
          }
        }
      }
    }
    
    public static TabLayout.e b(TabLayout paramTabLayout)
    {
      AppMethodBeat.i(291308);
      s.u(paramTabLayout, "tabLayout");
      paramTabLayout = paramTabLayout.WW();
      s.s(paramTabLayout, "tabLayout.newTab()");
      new l.d(paramTabLayout);
      AppMethodBeat.o(291308);
      return paramTabLayout;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(291317);
      int i = ((Number)l.this.Tja.getValue()).intValue();
      AppMethodBeat.o(291317);
      return i;
    }
    
    public final Fragment getItem(int paramInt)
    {
      AppMethodBeat.i(291326);
      if (paramInt == 0)
      {
        localFragment = (Fragment)l.this.TzS.getValue();
        AppMethodBeat.o(291326);
        return localFragment;
      }
      Fragment localFragment = (Fragment)l.this.TzT.getValue();
      AppMethodBeat.o(291326);
      return localFragment;
    }
    
    public final CharSequence getPageTitle(int paramInt)
    {
      AppMethodBeat.i(291336);
      switch (paramInt)
      {
      default: 
        localCharSequence = (CharSequence)String.valueOf(paramInt);
        AppMethodBeat.o(291336);
        return localCharSequence;
      case 0: 
        localCharSequence = (CharSequence)l.this.getString(a.h.TgZ);
        AppMethodBeat.o(291336);
        return localCharSequence;
      }
      CharSequence localCharSequence = (CharSequence)l.this.getString(a.h.TgW);
      AppMethodBeat.o(291336);
      return localCharSequence;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusPagerUIC$TextStatusTabHolder;", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "(Lcom/google/android/material/tabs/TabLayout$Tab;)V", "redInfo", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusPagerUIC$RedInfo;", "getRedInfo", "()Lcom/tencent/mm/plugin/textstatus/ui/TextStatusPagerUIC$RedInfo;", "setRedInfo", "(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusPagerUIC$RedInfo;)V", "tvNewTip", "Landroid/widget/TextView;", "getTvNewTip", "()Landroid/widget/TextView;", "tvNewTip$delegate", "Lkotlin/Lazy;", "tvTitle", "getTvTitle", "tvTitle$delegate", "vRedDot", "Landroid/view/View;", "getVRedDot", "()Landroid/view/View;", "vRedDot$delegate", "setTextBold", "", "isBold", "", "setTextColor", "id", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
  {
    private final j TAa;
    private final j TAb;
    private final j TAc;
    l.c TAd;
    final TabLayout.e dyQ;
    
    public d(TabLayout.e parame)
    {
      AppMethodBeat.i(291297);
      this.dyQ = parame;
      this.TAa = kotlin.k.cm((kotlin.g.a.a)new b(this));
      this.TAb = kotlin.k.cm((kotlin.g.a.a)new a(this));
      this.TAc = kotlin.k.cm((kotlin.g.a.a)new c(this));
      this.dyQ.jw(a.f.TfQ);
      this.dyQ.tag = this;
      AppMethodBeat.o(291297);
    }
    
    public final TextView hJZ()
    {
      AppMethodBeat.i(291307);
      TextView localTextView = (TextView)this.TAa.getValue();
      AppMethodBeat.o(291307);
      return localTextView;
    }
    
    public final TextView hKa()
    {
      AppMethodBeat.i(291315);
      TextView localTextView = (TextView)this.TAb.getValue();
      AppMethodBeat.o(291315);
      return localTextView;
    }
    
    public final View hKb()
    {
      AppMethodBeat.i(291324);
      View localView = (View)this.TAc.getValue();
      AppMethodBeat.o(291324);
      return localView;
    }
    
    public final void setTextBold(boolean paramBoolean)
    {
      AppMethodBeat.i(291338);
      TextView localTextView = hJZ();
      if (localTextView != null)
      {
        if (paramBoolean)
        {
          aw.a((Paint)localTextView.getPaint(), 0.8F);
          AppMethodBeat.o(291338);
          return;
        }
        localTextView.getPaint().setFakeBoldText(false);
        localTextView.getPaint().setStrokeWidth(0.0F);
      }
      AppMethodBeat.o(291338);
    }
    
    public final void setTextColor(int paramInt)
    {
      AppMethodBeat.i(291335);
      TextView localTextView = hJZ();
      if (localTextView != null)
      {
        View localView = this.dyQ.dyK;
        s.checkNotNull(localView);
        localTextView.setTextColor(localView.getContext().getResources().getColor(paramInt));
      }
      AppMethodBeat.o(291335);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<TextView>
    {
      a(l.d paramd)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<TextView>
    {
      b(l.d paramd)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.a<View>
    {
      c(l.d paramd)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/conversation/ui/TextStatusConversationFragment;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<TextStatusConversationFragment>
  {
    public static final e TAf;
    
    static
    {
      AppMethodBeat.i(291294);
      TAf = new e();
      AppMethodBeat.o(291294);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusPagerUIC$initActionBar$2", "Lcom/google/android/material/tabs/TabLayout$ViewPagerOnTabSelectedListener;", "onTabSelected", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabUnselected", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends TabLayout.h
  {
    f(l paraml, ViewPager paramViewPager)
    {
      super();
    }
    
    public final void i(TabLayout.e parame)
    {
      int k = -1;
      AppMethodBeat.i(291270);
      super.i(parame);
      Object localObject = new StringBuilder("onTabSelected() called with: tab = ");
      int i;
      label75:
      int j;
      if (parame == null)
      {
        i = -1;
        Log.d("MicroMsg.TextStatus.TextStatusPagerUIC", i + ' ' + this.TzY.TzU);
        if (!this.TzY.TzU)
        {
          if (parame != null) {
            break label185;
          }
          i = -1;
          switch (i)
          {
          default: 
            i = 0;
            j = 0;
            localObject = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
            localObject = f.a.ko((Context)this.TzY.getContext());
            if (parame == null) {
              label128:
              if (k != 0) {
                break label258;
              }
            }
            break;
          }
        }
      }
      label258:
      for (k = 2;; k = 3)
      {
        com.tencent.mm.plugin.textstatus.conversation.d.f.o(k, j, i, 0, 8);
        ((com.tencent.mm.plugin.textstatus.conversation.d.f)localObject).Tjf += 1;
        if (parame != null) {
          l.a(this.TzY, parame, true);
        }
        AppMethodBeat.o(291270);
        return;
        i = parame.position;
        break;
        label185:
        i = parame.position;
        break label75;
        if (parame == null) {}
        for (i = 0;; i = l.m(parame))
        {
          j = this.TzY.TzX;
          break;
        }
        if (parame == null) {}
        for (i = 0;; i = l.m(parame))
        {
          int m = this.TzY.TzW;
          j = i;
          i = m;
          break;
        }
        k = parame.position;
        break label128;
      }
    }
    
    public final void j(TabLayout.e parame)
    {
      int j = -1;
      AppMethodBeat.i(291281);
      super.j(parame);
      label38:
      label79:
      label89:
      Object localObject;
      if (parame == null)
      {
        i = -1;
        Log.d("MicroMsg.TextStatus.TextStatusPagerUIC", s.X("onTabUnSelected() called with: tab = ", Integer.valueOf(i)));
        if (parame != null) {
          break label134;
        }
        i = -1;
        switch (i)
        {
        default: 
          if (parame != null) {
            l.a(this.TzY, parame, false);
          }
          if (parame == null)
          {
            i = -1;
            l.aoA(i);
            if (parame != null) {
              break label208;
            }
            i = -1;
            if (i == 1)
            {
              localObject = com.tencent.mm.plugin.textstatus.b.f.TjQ;
              com.tencent.mm.plugin.textstatus.b.f.hGU();
            }
            localObject = this.TzY;
            if (parame != null) {
              break label216;
            }
          }
          break;
        }
      }
      label134:
      label208:
      label216:
      for (int i = j;; i = parame.position)
      {
        ((l)localObject).aoz(i);
        AppMethodBeat.o(291281);
        return;
        i = parame.position;
        break;
        i = parame.position;
        break label38;
        localObject = this.TzY;
        if (parame == null) {}
        for (i = 0;; i = l.m(parame))
        {
          ((l)localObject).TzW = i;
          break;
        }
        localObject = this.TzY;
        if (parame == null) {}
        for (i = 0;; i = l.m(parame))
        {
          ((l)localObject).TzX = i;
          break;
        }
        i = parame.position;
        break label79;
        i = parame.position;
        break label89;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListFragment;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<TextStatusLikeListFragment>
  {
    h(l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusPagerUIC$MyPageAdapter;", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusPagerUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<l.b>
  {
    i(l paraml, AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<Integer>
  {
    j(l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<Integer>
  {
    k(l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/google/android/material/tabs/TabLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<TabLayout>
  {
    l(l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.l
 * JD-Core Version:    0.7.0.1
 */