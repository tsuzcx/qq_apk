package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.nn;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.pluginsdk.m;

final class NewBizInfoFollowPreference$1
  implements View.OnClickListener
{
  NewBizInfoFollowPreference$1(NewBizInfoFollowPreference paramNewBizInfoFollowPreference) {}
  
  public final void onClick(View paramView)
  {
    Object localObject;
    if ((NewBizInfoFollowPreference.a(this.mZG) != null) && ((NewBizInfoFollowPreference.a(this.mZG) instanceof b)))
    {
      paramView = (b)NewBizInfoFollowPreference.a(this.mZG);
      if (paramView.mWW != null)
      {
        localObject = new nn();
        paramView.mWW.eAB = 5;
        ((nn)localObject).bXh.bXi = paramView.mWW;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      }
      localObject = new Intent();
      if (paramView.mZy.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
        ((Intent)localObject).setFlags(268435456);
      }
      ((Intent)localObject).putExtra("chat_from_scene", paramView.mZy.getIntent().getIntExtra("chat_from_scene", 0));
      ((Intent)localObject).putExtra("KOpenArticleSceneFromScene", 126);
      ((Intent)localObject).putExtra("specific_chat_from_scene", 5);
      if (!paramView.mVI) {
        break label201;
      }
      ((Intent)localObject).putExtra("Chat_User", paramView.dnp.field_username);
      ((Intent)localObject).putExtra("Chat_Mode", 1);
      paramView.mZy.setResult(-1, (Intent)localObject);
    }
    for (;;)
    {
      paramView.wf(5);
      c.cg(paramView.dnp.field_username, 300);
      return;
      label201:
      ((Intent)localObject).putExtra("Chat_User", paramView.dnp.field_username);
      ((Intent)localObject).putExtra("Chat_Mode", 1);
      ((Intent)localObject).putExtra("finish_direct", true);
      com.tencent.mm.plugin.profile.a.eUR.e((Intent)localObject, paramView.mZy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoFollowPreference.1
 * JD-Core Version:    0.7.0.1
 */