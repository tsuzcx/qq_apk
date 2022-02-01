package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoFollowPreference
  extends Preference
{
  com.tencent.mm.pluginsdk.b.a Bdv;
  private TextView Bjr;
  private TextView Bjs;
  private MMActivity gte;
  private boolean rFe;
  
  public NewBizInfoFollowPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27501);
    this.rFe = false;
    this.gte = ((MMActivity)paramContext);
    this.rFe = false;
    AppMethodBeat.o(27501);
  }
  
  public NewBizInfoFollowPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27502);
    this.rFe = false;
    this.gte = ((MMActivity)paramContext);
    this.rFe = false;
    AppMethodBeat.o(27502);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27503);
    this.rFe = true;
    this.Bjr = ((TextView)paramView.findViewById(2131299052));
    if (this.Bjr.getPaint() != null) {
      this.Bjr.getPaint().setFakeBoldText(true);
    }
    this.Bjs = ((TextView)paramView.findViewById(2131299043));
    if (this.Bjs.getPaint() != null) {
      this.Bjs.getPaint().setFakeBoldText(true);
    }
    if (this.rFe)
    {
      this.Bjr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27499);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoFollowPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          if ((NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this) != null) && ((NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this) instanceof ContactWidgetNewBizInfo)))
          {
            paramAnonymousView = (ContactWidgetNewBizInfo)NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this);
            if (paramAnonymousView.Bfh != null)
            {
              localObject = new rr();
              paramAnonymousView.Bfh.jkU = 5;
              ((rr)localObject).dYk.dYl = paramAnonymousView.Bfh;
              EventCenter.instance.publish((IEvent)localObject);
            }
            localObject = new Intent();
            if (paramAnonymousView.BiT.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
              ((Intent)localObject).setFlags(268435456);
            }
            ((Intent)localObject).putExtra("chat_from_scene", paramAnonymousView.BiT.getIntent().getIntExtra("chat_from_scene", 0));
            ((Intent)localObject).putExtra("KOpenArticleSceneFromScene", 126);
            ((Intent)localObject).putExtra("specific_chat_from_scene", 5);
            if (!paramAnonymousView.Bdx) {
              break label262;
            }
            ((Intent)localObject).putExtra("Chat_User", paramAnonymousView.contact.field_username);
            ((Intent)localObject).putExtra("Chat_Mode", 1);
            paramAnonymousView.BiT.setResult(-1, (Intent)localObject);
          }
          for (;;)
          {
            paramAnonymousView.US(5);
            c.c(paramAnonymousView.contact.field_username, 300, paramAnonymousView.kgm, paramAnonymousView.enterTime);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoFollowPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27499);
            return;
            label262:
            ((Intent)localObject).putExtra("Chat_User", paramAnonymousView.contact.field_username);
            ((Intent)localObject).putExtra("Chat_Mode", 1);
            ((Intent)localObject).putExtra("finish_direct", true);
            com.tencent.mm.plugin.profile.b.jRt.d((Intent)localObject, paramAnonymousView.BiT);
          }
        }
      });
      this.Bjs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27500);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoFollowPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if ((NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this) != null) && ((NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this) instanceof ContactWidgetNewBizInfo)))
          {
            paramAnonymousView = (ContactWidgetNewBizInfo)NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this);
            ((com.tencent.mm.api.m)g.af(com.tencent.mm.api.m.class)).a(paramAnonymousView.Bdk, paramAnonymousView.BiT, paramAnonymousView.contact, true, new ContactWidgetNewBizInfo.6(paramAnonymousView));
            c.c(paramAnonymousView.contact.field_username, 1000, paramAnonymousView.kgm, paramAnonymousView.enterTime);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoFollowPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27500);
        }
      });
    }
    AppMethodBeat.o(27503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoFollowPreference
 * JD-Core Version:    0.7.0.1
 */