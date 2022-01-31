package com.tencent.mm.plugin.profile.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.c;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

final class FriendPreference$1
  implements View.OnClickListener
{
  FriendPreference$1(FriendPreference paramFriendPreference, String paramString) {}
  
  public final void onClick(View paramView)
  {
    if ((FriendPreference.a(this.mXY) != null) && (!bk.bl(FriendPreference.a(this.mXY).ebN))) {}
    for (paramView = FriendPreference.b(this.mXY).getResources().getStringArray(R.c.profile_alert_all);; paramView = FriendPreference.b(this.mXY).getResources().getStringArray(R.c.profile_alert_short))
    {
      Object localObject = paramView;
      if (com.tencent.mm.plugin.profile.a.eUS.tp())
      {
        paramView = bk.G(paramView);
        paramView.add(FriendPreference.b(this.mXY).getResources().getString(R.l.chatting_phone_download_wxpb));
        localObject = (String[])paramView.toArray(new String[paramView.size()]);
        com.tencent.mm.plugin.report.service.h.nFQ.f(11621, new Object[] { Integer.valueOf(2), Integer.valueOf(3) });
      }
      com.tencent.mm.ui.base.h.a(FriendPreference.b(this.mXY), null, (String[])localObject, null, new FriendPreference.1.1(this, (String[])localObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.FriendPreference.1
 * JD-Core Version:    0.7.0.1
 */