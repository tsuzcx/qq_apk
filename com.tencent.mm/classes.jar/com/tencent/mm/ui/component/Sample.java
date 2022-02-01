package com.tencent.mm.ui.component;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/Sample;", "", "()V", "ApiMainUIC", "ApiOneBizUIC", "ApiTwoBizUIC", "MainUIC", "OneBizUIC", "SampleActivity", "SampleFragment", "ThreeBizUIC", "TwoBizUIC", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class Sample
{
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/Sample$ThreeBizUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends UIComponent
  {
    public e(AppCompatActivity paramAppCompatActivity)
    {
      super();
      AppMethodBeat.i(250278);
      AppMethodBeat.o(250278);
    }
    
    public e(Fragment paramFragment)
    {
      super();
      AppMethodBeat.i(250286);
      AppMethodBeat.o(250286);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/Sample$TwoBizUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/component/Sample$ApiTwoBizUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "test", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends UIComponent
    implements h
  {
    public f(AppCompatActivity paramAppCompatActivity)
    {
      super();
      AppMethodBeat.i(250283);
      AppMethodBeat.o(250283);
    }
    
    public f(Fragment paramFragment)
    {
      super();
      AppMethodBeat.i(250289);
      AppMethodBeat.o(250289);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.component.Sample
 * JD-Core Version:    0.7.0.1
 */