package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.l;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoFollowPreference
  extends Preference
{
  private MMActivity fLP;
  private boolean qhs;
  com.tencent.mm.pluginsdk.b.a wPY;
  private TextView wVA;
  private TextView wVz;
  
  public NewBizInfoFollowPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27501);
    this.qhs = false;
    this.fLP = ((MMActivity)paramContext);
    this.qhs = false;
    AppMethodBeat.o(27501);
  }
  
  public NewBizInfoFollowPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27502);
    this.qhs = false;
    this.fLP = ((MMActivity)paramContext);
    this.qhs = false;
    AppMethodBeat.o(27502);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27503);
    this.qhs = true;
    this.wVz = ((TextView)paramView.findViewById(2131298615));
    if (this.wVz.getPaint() != null) {
      this.wVz.getPaint().setFakeBoldText(true);
    }
    this.wVA = ((TextView)paramView.findViewById(2131298606));
    if (this.wVA.getPaint() != null) {
      this.wVA.getPaint().setFakeBoldText(true);
    }
    if (this.qhs)
    {
      this.wVz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27499);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoFollowPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          if ((NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this) != null) && ((NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this) instanceof ContactWidgetNewBizInfo)))
          {
            paramAnonymousView = (ContactWidgetNewBizInfo)NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this);
            if (paramAnonymousView.wRC != null)
            {
              localObject = new qw();
              paramAnonymousView.wRC.imT = 5;
              ((qw)localObject).dFu.dFv = paramAnonymousView.wRC;
              com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
            }
            localObject = new Intent();
            if (paramAnonymousView.wVc.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
              ((Intent)localObject).setFlags(268435456);
            }
            ((Intent)localObject).putExtra("chat_from_scene", paramAnonymousView.wVc.getIntent().getIntExtra("chat_from_scene", 0));
            ((Intent)localObject).putExtra("KOpenArticleSceneFromScene", 126);
            ((Intent)localObject).putExtra("specific_chat_from_scene", 5);
            if (!paramAnonymousView.wPZ) {
              break label262;
            }
            ((Intent)localObject).putExtra("Chat_User", paramAnonymousView.contact.field_username);
            ((Intent)localObject).putExtra("Chat_Mode", 1);
            paramAnonymousView.wVc.setResult(-1, (Intent)localObject);
          }
          for (;;)
          {
            paramAnonymousView.MY(5);
            c.b(paramAnonymousView.contact.field_username, 300, paramAnonymousView.jfq, paramAnonymousView.enterTime);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoFollowPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27499);
            return;
            label262:
            ((Intent)localObject).putExtra("Chat_User", paramAnonymousView.contact.field_username);
            ((Intent)localObject).putExtra("Chat_Mode", 1);
            ((Intent)localObject).putExtra("finish_direct", true);
            com.tencent.mm.plugin.profile.b.iRG.d((Intent)localObject, paramAnonymousView.wVc);
          }
        }
      });
      this.wVA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27500);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoFollowPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if ((NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this) != null) && ((NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this) instanceof ContactWidgetNewBizInfo)))
          {
            paramAnonymousView = (ContactWidgetNewBizInfo)NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this);
            ((l)g.ab(l.class)).a(paramAnonymousView.wPN, paramAnonymousView.wVc, paramAnonymousView.contact, true, new ContactWidgetNewBizInfo.6(paramAnonymousView));
            c.b(paramAnonymousView.contact.field_username, 1000, paramAnonymousView.jfq, paramAnonymousView.enterTime);
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