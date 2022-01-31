package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.om;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.b.a;

final class NewBizInfoFollowPreference$1
  implements View.OnClickListener
{
  NewBizInfoFollowPreference$1(NewBizInfoFollowPreference paramNewBizInfoFollowPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(23849);
    Object localObject;
    if ((NewBizInfoFollowPreference.a(this.pDx) != null) && ((NewBizInfoFollowPreference.a(this.pDx) instanceof b)))
    {
      paramView = (b)NewBizInfoFollowPreference.a(this.pDx);
      if (paramView.pzR != null)
      {
        localObject = new om();
        paramView.pzR.fQt = 5;
        ((om)localObject).cFa.cFb = paramView.pzR;
        a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      }
      localObject = new Intent();
      if (paramView.pDe.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
        ((Intent)localObject).setFlags(268435456);
      }
      ((Intent)localObject).putExtra("chat_from_scene", paramView.pDe.getIntent().getIntExtra("chat_from_scene", 0));
      ((Intent)localObject).putExtra("KOpenArticleSceneFromScene", 126);
      ((Intent)localObject).putExtra("specific_chat_from_scene", 5);
      if (!paramView.pyp) {
        break label213;
      }
      ((Intent)localObject).putExtra("Chat_User", paramView.contact.field_username);
      ((Intent)localObject).putExtra("Chat_Mode", 1);
      paramView.pDe.setResult(-1, (Intent)localObject);
    }
    for (;;)
    {
      paramView.BK(5);
      c.cZ(paramView.contact.field_username, 300);
      AppMethodBeat.o(23849);
      return;
      label213:
      ((Intent)localObject).putExtra("Chat_User", paramView.contact.field_username);
      ((Intent)localObject).putExtra("Chat_Mode", 1);
      ((Intent)localObject).putExtra("finish_direct", true);
      com.tencent.mm.plugin.profile.b.gmO.d((Intent)localObject, paramView.pDe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoFollowPreference.1
 * JD-Core Version:    0.7.0.1
 */