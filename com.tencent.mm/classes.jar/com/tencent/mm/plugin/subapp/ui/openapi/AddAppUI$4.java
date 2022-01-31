package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.f;

final class AddAppUI$4
  implements AdapterView.OnItemClickListener
{
  AddAppUI$4(AddAppUI paramAddAppUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(25419);
    paramAdapterView = AddAppUI.b(this.sYJ).Gn(paramInt);
    AddAppUI.a(this.sYJ, paramAdapterView.field_appId);
    AppMethodBeat.o(25419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AddAppUI.4
 * JD-Core Version:    0.7.0.1
 */