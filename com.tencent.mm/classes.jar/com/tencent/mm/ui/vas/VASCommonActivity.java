package com.tencent.mm.ui.vas;

import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.statusbar.d;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.pulldown.c;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@com.tencent.mm.ui.base.a(32)
@c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/vas/VASCommonActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "commonTitleView", "Lcom/tencent/mm/ui/vas/page/ICommonAnimTitle;", "getCommonTitleView", "()Lcom/tencent/mm/ui/vas/page/ICommonAnimTitle;", "commonTitleView$delegate", "Lkotlin/Lazy;", "layoutCommonActionBarWrapper", "Landroid/view/View;", "getLayoutCommonActionBarWrapper", "()Landroid/view/View;", "layoutCommonActionBarWrapper$delegate", "layoutMain", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getLayoutMain", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "layoutMain$delegate", "finish", "", "getCreateReplaceId", "", "getFirstFragment", "Lcom/tencent/mm/ui/vas/VASCommonFragment;", "getLayoutId", "isCallSuperOnSaveInstanceState", "", "isForceFixStatusBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEnterAnimationComplete", "onPause", "onResume", "onWindowFocusChanged", "hasFocus", "setFullScreen", "isFullScreen", "startActivity", "intent", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class VASCommonActivity
  extends MMActivity
{
  private final String TAG;
  private final j afQu;
  private final j afQv;
  final j afQw;
  
  public VASCommonActivity()
  {
    AppMethodBeat.i(249918);
    this.TAG = s.X("MicroMsg.VAS.VASCommonActivity@", Integer.valueOf(hashCode()));
    this.afQu = k.cm((kotlin.g.a.a)new c(this));
    this.afQv = k.cm((kotlin.g.a.a)new b(this));
    this.afQw = k.cm((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(249918);
  }
  
  private final VASCommonFragment jEl()
  {
    AppMethodBeat.i(249922);
    Object localObject = getSupportFragmentManager().getFragments();
    s.s(localObject, "supportFragmentManager.fragments");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Fragment localFragment = (Fragment)((Iterator)localObject).next();
      if ((localFragment instanceof VASCommonFragment))
      {
        localObject = (VASCommonFragment)localFragment;
        AppMethodBeat.o(249922);
        return localObject;
      }
    }
    AppMethodBeat.o(249922);
    return null;
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public void finish()
  {
    boolean bool = true;
    AppMethodBeat.i(249956);
    Object localObject = jEl();
    if (localObject == null)
    {
      if (!bool) {
        break label113;
      }
      localObject = com.tencent.mm.ui.vas.e.a.afRq;
      if (com.tencent.mm.ui.vas.e.a.afRr) {
        break label84;
      }
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        setResult(((Number)((kotlin.u)localObject).bsC).intValue(), (Intent)((kotlin.u)localObject).bsD);
      }
      super.finish();
      AppMethodBeat.o(249956);
      return;
      localObject = ((VASCommonFragment)localObject).afQn;
      if (localObject == null) {
        break;
      }
      bool = ((VASActivity)localObject).get_isFinishing();
      break;
      label84:
      localObject = new kotlin.u(Integer.valueOf(com.tencent.mm.ui.vas.e.a.resultCode), com.tencent.mm.ui.vas.e.a.Ofj, Integer.valueOf(com.tencent.mm.ui.vas.e.a.hPm));
      com.tencent.mm.ui.vas.e.a.reset();
    }
    label113:
    localObject = jEl();
    if (localObject != null)
    {
      localObject = ((VASCommonFragment)localObject).afQn;
      if (localObject != null) {
        ((VASActivity)localObject).finishWithNoAnim();
      }
    }
    AppMethodBeat.o(249956);
  }
  
  public int getLayoutId()
  {
    return a.h.activity_common_vas;
  }
  
  public final void hUb()
  {
    AppMethodBeat.i(249993);
    ViewGroup localViewGroup = this.mWrappingFrame;
    if ((localViewGroup != null) && ((localViewGroup instanceof b))) {
      ((b)localViewGroup).MU(true);
    }
    AppMethodBeat.o(249993);
  }
  
  public boolean isCallSuperOnSaveInstanceState()
  {
    return true;
  }
  
  public boolean isForceFixStatusBar()
  {
    return true;
  }
  
  public final View jEj()
  {
    AppMethodBeat.i(249928);
    Object localObject = this.afQv.getValue();
    s.s(localObject, "<get-layoutCommonActionBarWrapper>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(249928);
    return localObject;
  }
  
  public int jEk()
  {
    return a.g.layout_vas_container;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(249982);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.d(this.TAG, "onActivityResult() called with: requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent);
    VASCommonFragment localVASCommonFragment = jEl();
    if (localVASCommonFragment != null) {
      localVASCommonFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(249982);
  }
  
  public void onBackPressed()
  {
    int j = 1;
    AppMethodBeat.i(249959);
    Object localObject = jEl();
    if (localObject != null)
    {
      localObject = ((VASCommonFragment)localObject).afQn;
      if (localObject != null)
      {
        ((VASActivity)localObject).onBackPressed();
        i = 1;
        if (i != 1) {
          break label59;
        }
      }
    }
    label59:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        super.onBackPressed();
      }
      AppMethodBeat.o(249959);
      return;
      i = 0;
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(249947);
    Log.d(this.TAG, s.X("onCreate() called with: savedInstanceState = ", paramBundle));
    h.w((MMActivity)this);
    super.onCreate(paramBundle);
    Log.d(this.TAG, "onCreate() after called");
    setActionbarColor(0);
    getWindow().getDecorView().setSystemUiVisibility(1792);
    d.g(getWindow());
    setNavigationbarColor(getResources().getColor(a.d.transparent));
    hideActionbarLine();
    hideActionBarOperationArea();
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.hide();
    }
    if (paramBundle == null)
    {
      paramBundle = VASCommonFragment.afQz;
      paramBundle = VASCommonFragment.a.cb(getIntent().getExtras());
      getSupportFragmentManager().beginTransaction().a(jEk(), (Fragment)paramBundle).FW();
    }
    AppMethodBeat.o(249947);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(249972);
    super.onDestroy();
    Log.d(this.TAG, "onDestroy() called");
    AppMethodBeat.o(249972);
  }
  
  public void onEnterAnimationComplete()
  {
    AppMethodBeat.i(249977);
    super.onEnterAnimationComplete();
    MMActivity.aReporter.a(getIntent(), System.currentTimeMillis() - 300L);
    MMActivity.aReporter.bt(getIntent());
    AppMethodBeat.o(249977);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(249968);
    super.onPause();
    Log.d(this.TAG, "onPause() called");
    AppMethodBeat.o(249968);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(249962);
    super.onResume();
    Log.d(this.TAG, "onResume() called");
    AppMethodBeat.o(249962);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(249940);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    Object localObject = getSupportFragmentManager().getFragments();
    if (((List)localObject).size() > 0)
    {
      localObject = (Fragment)((List)localObject).get(((List)localObject).size() - 1);
      if ((localObject instanceof a)) {
        ((a)localObject).onWindowFocusChanged(paramBoolean);
      }
    }
    AppMethodBeat.o(249940);
  }
  
  public void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(249988);
    if (MMActivity.isVASActivity(paramIntent))
    {
      VASCommonFragment localVASCommonFragment = jEl();
      if (localVASCommonFragment != null)
      {
        Object localObject1;
        if (paramIntent == null) {
          localObject1 = "";
        }
        for (;;)
        {
          localObject1 = Class.forName((String)localObject1);
          Object localObject2 = localVASCommonFragment.afQn;
          if (localObject2 != null)
          {
            s.s(localObject1, "curClass");
            s.u(localObject2, "<this>");
            s.u(localObject1, "uiCls");
            f.a((VASActivity)localObject2, (Class)localObject1, paramIntent, null, -1);
          }
          AppMethodBeat.o(249988);
          return;
          localObject1 = paramIntent.getComponent();
          if (localObject1 == null)
          {
            localObject1 = "";
          }
          else
          {
            localObject2 = ((ComponentName)localObject1).getClassName();
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
          }
        }
      }
    }
    else
    {
      super.startActivity(paramIntent);
    }
    AppMethodBeat.o(249988);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/ui/vas/VASCommonActivity$commonTitleView$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.a<1>
  {
    a(VASCommonActivity paramVASCommonActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    b(VASCommonActivity paramVASCommonActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/constraintlayout/widget/ConstraintLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ConstraintLayout>
  {
    c(VASCommonActivity paramVASCommonActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.vas.VASCommonActivity
 * JD-Core Version:    0.7.0.1
 */