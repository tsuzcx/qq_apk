package com.tencent.mm.ui.component;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/UIComponentWithState;", "S", "Lcom/tencent/mm/ui/component/UicState;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/component/ApiUicWithState;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class o<S extends p>
  extends UIComponent
  implements d<S>
{
  public o(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public o(Fragment paramFragment)
  {
    super(paramFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.o
 * JD-Core Version:    0.7.0.1
 */