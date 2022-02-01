package com.tencent.mm.sns_compose;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.q;
import coil.b.a;
import coil.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.MomentsTogetherHistoryBrowsingStruct;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMComposeActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/SnsWithTaUI;", "Lcom/tencent/mm/ui/MMComposeActivity;", "()V", "source", "", "startTime", "", "viewModel", "Lcom/tencent/mm/sns_compose/page/WithTaViewModel;", "getViewModel", "()Lcom/tencent/mm/sns_compose/page/WithTaViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getLayoutId", "getLayoutView", "Landroid/view/View;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "sns-compose_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SnsWithTaUI
  extends MMComposeActivity
{
  public static final int Ue = 8;
  private int source;
  private final long startTime;
  private final j ujH;
  
  public SnsWithTaUI()
  {
    AppMethodBeat.i(235390);
    this.startTime = System.currentTimeMillis();
    this.ujH = k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(235390);
  }
  
  private static final boolean a(SnsWithTaUI paramSnsWithTaUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(235403);
    s.u(paramSnsWithTaUI, "this$0");
    paramSnsWithTaUI.onBackPressed();
    AppMethodBeat.o(235403);
    return true;
  }
  
  private final com.tencent.mm.sns_compose.c.g iVu()
  {
    AppMethodBeat.i(235396);
    com.tencent.mm.sns_compose.c.g localg = (com.tencent.mm.sns_compose.c.g)this.ujH.getValue();
    AppMethodBeat.o(235396);
    return localg;
  }
  
  public final int getLayoutId()
  {
    return 1;
  }
  
  public final View getLayoutView()
  {
    AppMethodBeat.i(235434);
    Object localObject = new ComposeView((Context)this, null, 6, (byte)0);
    ((ComposeView)localObject).setContent((m)androidx.compose.runtime.c.c.a(-985533145, true, new a(this)));
    localObject = (View)localObject;
    AppMethodBeat.o(235434);
    return localObject;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(235445);
    super.onCreate(paramBundle);
    paramBundle = iVu();
    Object localObject1 = (Context)this;
    s.u(localObject1, "context");
    paramBundle.aczV = new LifecycleScope("compose_playVideo", (q)localObject1, 0, 4, null);
    paramBundle = MMApplicationContext.getContext();
    s.s(paramBundle, "getContext()");
    s.u(paramBundle, "context");
    if (!com.tencent.mm.sns_compose.d.b.isInit)
    {
      com.tencent.mm.sns_compose.d.b.isInit = true;
      localObject1 = new d.a(paramBundle);
      Object localObject2 = Bitmap.Config.ARGB_8888;
      s.u(localObject2, "bitmapConfig");
      d.a locala = (d.a)localObject1;
      locala.cld = coil.j.c.a(locala.cld, null, null, null, (Bitmap.Config)localObject2, false, false, null, null, null, null, null, null, 4087);
      localObject1 = (d.a)localObject1;
      localObject2 = coil.j.b.cpd;
      s.u(localObject2, "policy");
      locala = (d.a)localObject1;
      locala.cld = coil.j.c.a(locala.cld, null, null, null, null, false, false, null, null, null, (coil.j.b)localObject2, null, null, 3583);
      localObject1 = (d.a)localObject1;
      paramBundle = new b.a().a((coil.g.g)new com.tencent.mm.sns_compose.d.h(), Uri.class).a((coil.e.e)new com.tencent.mm.sns_compose.b.a(paramBundle)).MA();
      s.u(paramBundle, "registry");
      ((d.a)localObject1).clg = paramBundle;
      coil.a.a(((d.a)localObject1).MC());
    }
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    this.source = getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0);
    paramBundle = com.tencent.mm.plugin.comm.b.e.xfd;
    paramBundle = com.tencent.mm.plugin.comm.b.b.xeN.name();
    localObject1 = ai.cz(MomentsTogetherHistoryBrowsingStruct.class).klu();
    s.checkNotNull(localObject1);
    e.a.gt(paramBundle, (String)localObject1);
    com.tencent.mm.plugin.comm.b.e.xfd.f(com.tencent.mm.plugin.comm.b.b.xeN.name(), "ifRedDot", Integer.valueOf(getIntent().getIntExtra("has_dot", 0)));
    com.tencent.mm.plugin.comm.b.e.xfd.f(com.tencent.mm.plugin.comm.b.b.xeN.name(), "source", Integer.valueOf(this.source));
    com.tencent.mm.plugin.comm.b.e.xfd.f(com.tencent.mm.plugin.comm.b.b.xeN.name(), "withFriendFeedTime", Long.valueOf(System.currentTimeMillis()));
    com.tencent.mm.plugin.comm.b.e.xfd.f(com.tencent.mm.plugin.comm.b.b.xeN.name(), "pageOwnerUsername", a.acyR.getUsername());
    setBackBtn(new SnsWithTaUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(235445);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(235452);
    super.onDestroy();
    long l = System.currentTimeMillis() - this.startTime;
    com.tencent.mm.plugin.comm.b.e.xfd.f(com.tencent.mm.plugin.comm.b.b.xeN.name(), "withFriendFeedTime", Long.valueOf(l));
    com.tencent.mm.plugin.comm.b.e.xfd.f(com.tencent.mm.plugin.comm.b.b.xeN.name(), "ownerSetting", Integer.valueOf(a.acyR.hhY()));
    com.tencent.mm.plugin.comm.b.e.xfd.f(com.tencent.mm.plugin.comm.b.b.xeO.name(), "withFriendsStayTime", Long.valueOf(l));
    e.a.a(com.tencent.mm.plugin.comm.b.e.xfd, com.tencent.mm.plugin.comm.b.b.xeN.name());
    AppMethodBeat.o(235452);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<androidx.compose.runtime.h, Integer, ah>
  {
    a(SnsWithTaUI paramSnsWithTaUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sns_compose/page/WithTaViewModel;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.sns_compose.c.g>
  {
    b(SnsWithTaUI paramSnsWithTaUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sns_compose.SnsWithTaUI
 * JD-Core Version:    0.7.0.1
 */