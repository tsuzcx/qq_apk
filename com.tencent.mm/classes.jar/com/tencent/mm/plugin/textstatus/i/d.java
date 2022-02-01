package com.tencent.mm.plugin.textstatus.i;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/report/TextStatusSessionIdUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends UIComponent
{
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(289636);
    AppMethodBeat.o(289636);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(289639);
    super.onCreate(paramBundle);
    e.Tru.hFz();
    AppMethodBeat.o(289639);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(289642);
    super.onDestroy();
    e.Tru.hFA();
    AppMethodBeat.o(289642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.i.d
 * JD-Core Version:    0.7.0.1
 */