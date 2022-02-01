package com.tencent.mm.plugin.subapp.ui.pluginapp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.profile.ui.a.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.PreferenceInfoCategory.a;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;

final class AddMoreFriendsUI$4
  implements PreferenceInfoCategory.a
{
  AddMoreFriendsUI$4(AddMoreFriendsUI paramAddMoreFriendsUI) {}
  
  public final void ar(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(292052);
    Object localObject = this.SIv.getString(R.l.gHW, new Object[] { "" });
    if ((!Util.isNullOrNil(paramCharSequence)) && (paramCharSequence.toString().contains((CharSequence)localObject))) {
      if (((String)localObject).length() < paramCharSequence.length()) {
        paramCharSequence = (String)localObject + Util.addSpace(paramCharSequence.subSequence(((String)localObject).length(), paramCharSequence.length()));
      }
    }
    for (;;)
    {
      localObject = k.aeZF;
      ((a)k.d(this.SIv.getContext()).q(a.class)).setValue("title_key", paramCharSequence);
      AppMethodBeat.o(292052);
      return;
      paramCharSequence = paramCharSequence.toString();
      continue;
      paramCharSequence = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI.4
 * JD-Core Version:    0.7.0.1
 */