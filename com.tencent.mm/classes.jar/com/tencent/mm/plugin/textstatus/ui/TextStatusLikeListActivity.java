package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.p;
import androidx.fragment.app.r;
import androidx.viewpager.widget.ViewPager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatting.b;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.conversation.d.e;
import com.tencent.mm.plugin.textstatus.conversation.d.e.a;
import com.tencent.mm.plugin.textstatus.conversation.d.f.a;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "pageAdapter", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "getPageAdapter", "()Landroidx/fragment/app/FragmentStatePagerAdapter;", "pageAdapter$delegate", "Lkotlin/Lazy;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onResume", "refreshNewTipsCnt", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lkotlin/collections/HashSet;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusLikeListActivity
  extends MMActivity
  implements MStorage.IOnStorageChange
{
  public static final a Tzn;
  private final j Tzo;
  
  static
  {
    AppMethodBeat.i(291861);
    Tzn = new a((byte)0);
    AppMethodBeat.o(291861);
  }
  
  public TextStatusLikeListActivity()
  {
    AppMethodBeat.i(291848);
    this.Tzo = k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(291848);
  }
  
  private static final boolean a(TextStatusLikeListActivity paramTextStatusLikeListActivity, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(291858);
    s.u(paramTextStatusLikeListActivity, "this$0");
    paramTextStatusLikeListActivity.onBackPressed();
    AppMethodBeat.o(291858);
    return true;
  }
  
  private final p hJQ()
  {
    AppMethodBeat.i(291852);
    p localp = (p)this.Tzo.getValue();
    AppMethodBeat.o(291852);
    return localp;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return a.f.Tfz;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(291880);
    Object localObject = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
    localObject = d.We(2);
    s.s(localObject, "getUnsignedMd5UInt(Const…atus.SessionScene.NOTIFY)");
    f.a.bdH((String)localObject);
    super.onCreate(paramBundle);
    paramBundle = e.TiZ;
    if (e.a.kn((Context)this) > 1)
    {
      ((ViewPager)findViewById(a.e.pager)).setAdapter((androidx.viewpager.widget.a)hJQ());
      AppMethodBeat.o(291880);
      return;
    }
    getSupportFragmentManager().beginTransaction().a(a.e.main_content, hJQ().getItem(0)).FW();
    if (getIntent().getIntExtra("scene", 0) == 1) {
      setMMTitle(a.h.TgQ);
    }
    for (;;)
    {
      setBackBtn(new TextStatusLikeListActivity..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(291880);
      return;
      setMMTitle(a.h.TgZ);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(291885);
    super.onDestroy();
    AppMethodBeat.o(291885);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData) {}
  
  public final void onResume()
  {
    AppMethodBeat.i(291890);
    super.onResume();
    AppMethodBeat.o(291890);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(291894);
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(e.class);
    paramHashSet.add(f.class);
    paramHashSet.add(com.tencent.mm.plugin.textstatus.conversation.d.f.class);
    e.a locala = e.TiZ;
    if (e.a.kn((Context)this) > 1)
    {
      paramHashSet.add(b.class);
      paramHashSet.add(l.class);
    }
    AppMethodBeat.o(291894);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion;", "", "()V", "INDEX_CONV", "", "INDEX_INTERACTIVE", "TAB_SUM_1", "TAB_SUM_2", "TAG", "", "startForSelfAllHistory", "", "context", "Landroid/content/Context;", "reportEnterScene", "startForSelfMsg", "startForSingleStatusHistory", "statusId", "startForUnRead", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void ba(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(291357);
      s.u(paramContext, "context");
      Object localObject = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      if (com.tencent.mm.plugin.textstatus.b.f.hGW().hHC() == 0)
      {
        AppMethodBeat.o(291357);
        return;
      }
      localObject = new Intent(paramContext, TextStatusLikeListActivity.class);
      ((Intent)localObject).putExtra("scene", 1);
      ((Intent)localObject).putExtra("reportEnterScene", paramInt);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForUnRead", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForUnRead", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(291357);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusPagerUIC$MyPageAdapter;", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusPagerUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<l.b>
  {
    b(TextStatusLikeListActivity paramTextStatusLikeListActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity
 * JD-Core Version:    0.7.0.1
 */