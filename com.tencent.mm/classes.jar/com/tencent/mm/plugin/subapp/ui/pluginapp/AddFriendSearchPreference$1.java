package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AddFriendSearchPreference$1
  implements View.OnClickListener
{
  AddFriendSearchPreference$1(AddFriendSearchPreference paramAddFriendSearchPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25493);
    if ((AddFriendSearchPreference.a(this.sZq) != null) && (AddFriendSearchPreference.b(this.sZq) != null))
    {
      if (AddFriendSearchPreference.b(this.sZq).getText() == null)
      {
        AddFriendSearchPreference.a(this.sZq);
        AppMethodBeat.o(25493);
        return;
      }
      AddFriendSearchPreference.a(this.sZq);
      AddFriendSearchPreference.b(this.sZq).getText().toString();
    }
    AppMethodBeat.o(25493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddFriendSearchPreference.1
 * JD-Core Version:    0.7.0.1
 */