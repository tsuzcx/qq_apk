package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoFollowPreference
  extends Preference
{
  private MMActivity imP;
  private boolean paC;
  private TextView uFy;
  private TextView uFz;
  com.tencent.mm.pluginsdk.b.a uzY;
  
  public NewBizInfoFollowPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27501);
    this.paC = false;
    this.imP = ((MMActivity)paramContext);
    this.paC = false;
    AppMethodBeat.o(27501);
  }
  
  public NewBizInfoFollowPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27502);
    this.paC = false;
    this.imP = ((MMActivity)paramContext);
    this.paC = false;
    AppMethodBeat.o(27502);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27503);
    this.paC = true;
    this.uFy = ((TextView)paramView.findViewById(2131298615));
    if (this.uFy.getPaint() != null) {
      this.uFy.getPaint().setFakeBoldText(true);
    }
    this.uFz = ((TextView)paramView.findViewById(2131298606));
    if (this.uFz.getPaint() != null) {
      this.uFz.getPaint().setFakeBoldText(true);
    }
    if (this.paC)
    {
      this.uFy.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27499);
          Object localObject;
          if ((NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this) != null) && ((NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this) instanceof ContactWidgetNewBizInfo)))
          {
            paramAnonymousView = (ContactWidgetNewBizInfo)NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this);
            if (paramAnonymousView.uBA != null)
            {
              localObject = new qc();
              paramAnonymousView.uBA.hsX = 5;
              ((qc)localObject).dvG.dvH = paramAnonymousView.uBA;
              com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
            }
            localObject = new Intent();
            if (paramAnonymousView.uFc.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
              ((Intent)localObject).setFlags(268435456);
            }
            ((Intent)localObject).putExtra("chat_from_scene", paramAnonymousView.uFc.getIntent().getIntExtra("chat_from_scene", 0));
            ((Intent)localObject).putExtra("KOpenArticleSceneFromScene", 126);
            ((Intent)localObject).putExtra("specific_chat_from_scene", 5);
            if (!paramAnonymousView.uzZ) {
              break label217;
            }
            ((Intent)localObject).putExtra("Chat_User", paramAnonymousView.contact.field_username);
            ((Intent)localObject).putExtra("Chat_Mode", 1);
            paramAnonymousView.uFc.setResult(-1, (Intent)localObject);
          }
          for (;;)
          {
            paramAnonymousView.Jx(5);
            c.L(paramAnonymousView.contact.field_username, 300, paramAnonymousView.ima);
            AppMethodBeat.o(27499);
            return;
            label217:
            ((Intent)localObject).putExtra("Chat_User", paramAnonymousView.contact.field_username);
            ((Intent)localObject).putExtra("Chat_Mode", 1);
            ((Intent)localObject).putExtra("finish_direct", true);
            com.tencent.mm.plugin.profile.b.hYt.d((Intent)localObject, paramAnonymousView.uFc);
          }
        }
      });
      this.uFz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27500);
          if ((NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this) != null) && ((NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this) instanceof ContactWidgetNewBizInfo)))
          {
            paramAnonymousView = (ContactWidgetNewBizInfo)NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this);
            ((com.tencent.mm.api.l)g.ab(com.tencent.mm.api.l.class)).a(paramAnonymousView.uzN, paramAnonymousView.uFc, paramAnonymousView.contact, true, new ContactWidgetNewBizInfo.6(paramAnonymousView));
            c.L(paramAnonymousView.contact.field_username, 1000, paramAnonymousView.ima);
          }
          AppMethodBeat.o(27500);
        }
      });
    }
    AppMethodBeat.o(27503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoFollowPreference
 * JD-Core Version:    0.7.0.1
 */