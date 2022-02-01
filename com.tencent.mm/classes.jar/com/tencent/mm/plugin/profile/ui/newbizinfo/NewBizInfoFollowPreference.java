package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.f.a.sr;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoFollowPreference
  extends Preference
{
  com.tencent.mm.pluginsdk.c.a GXu;
  private TextView HdN;
  private TextView HdO;
  private MMActivity iXq;
  private boolean vkO;
  
  public NewBizInfoFollowPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27501);
    this.vkO = false;
    this.iXq = ((MMActivity)paramContext);
    this.vkO = false;
    AppMethodBeat.o(27501);
  }
  
  public NewBizInfoFollowPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27502);
    this.vkO = false;
    this.iXq = ((MMActivity)paramContext);
    this.vkO = false;
    AppMethodBeat.o(27502);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27503);
    this.vkO = true;
    this.HdN = ((TextView)paramView.findViewById(R.h.dBa));
    if (this.HdN.getPaint() != null) {
      this.HdN.getPaint().setFakeBoldText(true);
    }
    this.HdO = ((TextView)paramView.findViewById(R.h.dAT));
    if (this.HdO.getPaint() != null) {
      this.HdO.getPaint().setFakeBoldText(true);
    }
    if (this.vkO)
    {
      this.HdN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27499);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoFollowPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if ((NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this) != null) && ((NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this) instanceof ContactWidgetNewBizInfo)))
          {
            paramAnonymousView = (ContactWidgetNewBizInfo)NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this);
            if (paramAnonymousView.GZf != null)
            {
              localObject = new sr();
              paramAnonymousView.GZf.maV = 5;
              ((sr)localObject).fSb.fSc = paramAnonymousView.GZf;
              EventCenter.instance.publish((IEvent)localObject);
            }
            localObject = new Intent();
            if (paramAnonymousView.Hdt.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
              ((Intent)localObject).setFlags(268435456);
            }
            ((Intent)localObject).putExtra("chat_from_scene", paramAnonymousView.Hdt.getIntent().getIntExtra("chat_from_scene", 0));
            ((Intent)localObject).putExtra("KOpenArticleSceneFromScene", 126);
            ((Intent)localObject).putExtra("specific_chat_from_scene", 5);
            if (!paramAnonymousView.GXw) {
              break label262;
            }
            ((Intent)localObject).putExtra("Chat_User", paramAnonymousView.contact.field_username);
            ((Intent)localObject).putExtra("Chat_Mode", 1);
            paramAnonymousView.Hdt.setResult(-1, (Intent)localObject);
          }
          for (;;)
          {
            paramAnonymousView.aby(5);
            c.c(paramAnonymousView.contact.field_username, 300, paramAnonymousView.mXL, paramAnonymousView.enterTime);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoFollowPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27499);
            return;
            label262:
            ((Intent)localObject).putExtra("Chat_User", paramAnonymousView.contact.field_username);
            ((Intent)localObject).putExtra("Chat_Mode", 1);
            ((Intent)localObject).putExtra("finish_direct", true);
            com.tencent.mm.plugin.profile.b.mIG.d((Intent)localObject, paramAnonymousView.Hdt);
          }
        }
      });
      this.HdO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27500);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoFollowPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if ((NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this) != null) && ((NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this) instanceof ContactWidgetNewBizInfo)))
          {
            paramAnonymousView = (ContactWidgetNewBizInfo)NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this);
            ((com.tencent.mm.api.m)h.ae(com.tencent.mm.api.m.class)).a(paramAnonymousView.GXj, paramAnonymousView.Hdt, paramAnonymousView.contact, true, new ContactWidgetNewBizInfo.5(paramAnonymousView));
            c.c(paramAnonymousView.contact.field_username, 1000, paramAnonymousView.mXL, paramAnonymousView.enterTime);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoFollowPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27500);
        }
      });
    }
    AppMethodBeat.o(27503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoFollowPreference
 * JD-Core Version:    0.7.0.1
 */