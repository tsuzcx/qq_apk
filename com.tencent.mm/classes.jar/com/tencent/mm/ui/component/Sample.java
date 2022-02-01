package com.tencent.mm.ui.component;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.ui.MMActivity;
import d.a.ak;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/component/Sample;", "", "()V", "ABizUIC", "BBizUIC", "CBizUIC", "MainUIC", "SampleActivity", "SampleFragment", "libmmui_release"})
public final class Sample
{
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/component/Sample$ABizUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "libmmui_release"})
  public static final class ABizUIC
    extends UIComponent
  {
    public ABizUIC(Fragment paramFragment)
    {
      super();
      AppMethodBeat.i(203926);
      AppMethodBeat.o(203926);
    }
    
    public ABizUIC(MMActivity paramMMActivity)
    {
      super();
      AppMethodBeat.i(203925);
      AppMethodBeat.o(203925);
    }
    
    public final void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(203923);
      super.onCreate(paramBundle);
      AppMethodBeat.o(203923);
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(203924);
      super.onDestroy();
      AppMethodBeat.o(203924);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/component/Sample$BBizUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "libmmui_release"})
  public static final class BBizUIC
    extends UIComponent
  {
    public BBizUIC(Fragment paramFragment)
    {
      super();
      AppMethodBeat.i(203928);
      AppMethodBeat.o(203928);
    }
    
    public BBizUIC(MMActivity paramMMActivity)
    {
      super();
      AppMethodBeat.i(203927);
      AppMethodBeat.o(203927);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/component/Sample$CBizUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "libmmui_release"})
  public static final class CBizUIC
    extends UIComponent
  {
    public CBizUIC(Fragment paramFragment)
    {
      super();
      AppMethodBeat.i(203930);
      AppMethodBeat.o(203930);
    }
    
    public CBizUIC(MMActivity paramMMActivity)
    {
      super();
      AppMethodBeat.i(203929);
      AppMethodBeat.o(203929);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/component/Sample$MainUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "libmmui_release"})
  public static final class MainUIC
    extends UIComponent
  {
    public MainUIC(Fragment paramFragment)
    {
      super();
      AppMethodBeat.i(203935);
      AppMethodBeat.o(203935);
    }
    
    public MainUIC(MMActivity paramMMActivity)
    {
      super();
      AppMethodBeat.i(203934);
      AppMethodBeat.o(203934);
    }
    
    public final int getLayoutId()
    {
      AppMethodBeat.i(203931);
      int i = super.getLayoutId();
      AppMethodBeat.o(203931);
      return i;
    }
    
    public final void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(203932);
      super.onCreate(paramBundle);
      AppMethodBeat.o(203932);
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(203933);
      super.onDestroy();
      AppMethodBeat.o(203933);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/component/Sample$SampleActivity;", "Lcom/tencent/mm/ui/component/UIComponentActivity;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "libmmui_release"})
  public static final class SampleActivity
    extends UIComponentActivity
  {
    private HashMap _$_findViewCache;
    
    public final View _$_findCachedViewById(int paramInt)
    {
      AppMethodBeat.i(203937);
      if (this._$_findViewCache == null) {
        this._$_findViewCache = new HashMap();
      }
      View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
      View localView1 = localView2;
      if (localView2 == null)
      {
        localView1 = findViewById(paramInt);
        this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
      }
      AppMethodBeat.o(203937);
      return localView1;
    }
    
    public final Set<Class<? extends UIComponent>> fTM()
    {
      AppMethodBeat.i(203936);
      Set localSet = ak.setOf(new Class[] { Sample.MainUIC.class, Sample.ABizUIC.class, Sample.BBizUIC.class, Sample.CBizUIC.class });
      AppMethodBeat.o(203936);
      return localSet;
    }
    
    public void onWindowFocusChanged(boolean paramBoolean)
    {
      super.onWindowFocusChanged(paramBoolean);
      AppMethodBeat.at(this, paramBoolean);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/component/Sample$SampleFragment;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "libmmui_release"})
  public static final class SampleFragment
    extends UIComponentFragment
  {
    private HashMap _$_findViewCache;
    
    public final void _$_clearFindViewByIdCache()
    {
      AppMethodBeat.i(203940);
      if (this._$_findViewCache != null) {
        this._$_findViewCache.clear();
      }
      AppMethodBeat.o(203940);
    }
    
    public final Set<Class<? extends UIComponent>> fTM()
    {
      AppMethodBeat.i(203938);
      Set localSet = ak.setOf(new Class[] { Sample.MainUIC.class, Sample.ABizUIC.class, Sample.BBizUIC.class, Sample.CBizUIC.class });
      AppMethodBeat.o(203938);
      return localSet;
    }
    
    public final void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(203939);
      super.onCreate(paramBundle);
      paramBundle = a.LCX;
      ((Sample.ABizUIC)a.of((Fragment)this).get(Sample.ABizUIC.class)).hashCode();
      paramBundle = a.LCX;
      paramBundle = getActivity();
      if (paramBundle == null)
      {
        paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(203939);
        throw paramBundle;
      }
      ((Sample.BBizUIC)a.s((MMActivity)paramBundle).get(Sample.BBizUIC.class)).hashCode();
      paramBundle = a.LCX;
      ((Sample.CBizUIC)a.bE(PluginReport.class).get(Sample.CBizUIC.class)).hashCode();
      AppMethodBeat.o(203939);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.component.Sample
 * JD-Core Version:    0.7.0.1
 */