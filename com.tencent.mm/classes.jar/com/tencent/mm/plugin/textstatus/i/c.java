package com.tencent.mm.plugin.textstatus.i;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/report/TextStatusSceneSessionIdUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "onCreateBefore", "", "savedInstanceState", "Landroid/os/Bundle;", "onPostDestroyed", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends UIComponent
{
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(289637);
    AppMethodBeat.o(289637);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(289644);
    super.onCreateBefore(paramBundle);
    e.Tru.hFB();
    AppMethodBeat.o(289644);
  }
  
  public final void onPostDestroyed()
  {
    AppMethodBeat.i(289647);
    super.onPostDestroyed();
    e.Tru.hFC();
    AppMethodBeat.o(289647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.i.c
 * JD-Core Version:    0.7.0.1
 */