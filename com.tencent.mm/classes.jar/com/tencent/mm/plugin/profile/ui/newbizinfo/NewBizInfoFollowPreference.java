package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ql;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoFollowPreference
  extends Preference
{
  private MMActivity iMV;
  private boolean pDN;
  com.tencent.mm.pluginsdk.b.a vIR;
  private TextView vOq;
  private TextView vOr;
  
  public NewBizInfoFollowPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27501);
    this.pDN = false;
    this.iMV = ((MMActivity)paramContext);
    this.pDN = false;
    AppMethodBeat.o(27501);
  }
  
  public NewBizInfoFollowPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27502);
    this.pDN = false;
    this.iMV = ((MMActivity)paramContext);
    this.pDN = false;
    AppMethodBeat.o(27502);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27503);
    this.pDN = true;
    this.vOq = ((TextView)paramView.findViewById(2131298615));
    if (this.vOq.getPaint() != null) {
      this.vOq.getPaint().setFakeBoldText(true);
    }
    this.vOr = ((TextView)paramView.findViewById(2131298606));
    if (this.vOr.getPaint() != null) {
      this.vOr.getPaint().setFakeBoldText(true);
    }
    if (this.pDN)
    {
      this.vOq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27499);
          Object localObject;
          if ((NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this) != null) && ((NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this) instanceof ContactWidgetNewBizInfo)))
          {
            paramAnonymousView = (ContactWidgetNewBizInfo)NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this);
            if (paramAnonymousView.vKt != null)
            {
              localObject = new ql();
              paramAnonymousView.vKt.hTz = 5;
              ((ql)localObject).dtt.dtu = paramAnonymousView.vKt;
              com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
            }
            localObject = new Intent();
            if (paramAnonymousView.vNT.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
              ((Intent)localObject).setFlags(268435456);
            }
            ((Intent)localObject).putExtra("chat_from_scene", paramAnonymousView.vNT.getIntent().getIntExtra("chat_from_scene", 0));
            ((Intent)localObject).putExtra("KOpenArticleSceneFromScene", 126);
            ((Intent)localObject).putExtra("specific_chat_from_scene", 5);
            if (!paramAnonymousView.vIS) {
              break label217;
            }
            ((Intent)localObject).putExtra("Chat_User", paramAnonymousView.contact.field_username);
            ((Intent)localObject).putExtra("Chat_Mode", 1);
            paramAnonymousView.vNT.setResult(-1, (Intent)localObject);
          }
          for (;;)
          {
            paramAnonymousView.Lw(5);
            c.K(paramAnonymousView.contact.field_username, 300, paramAnonymousView.iMg);
            AppMethodBeat.o(27499);
            return;
            label217:
            ((Intent)localObject).putExtra("Chat_User", paramAnonymousView.contact.field_username);
            ((Intent)localObject).putExtra("Chat_Mode", 1);
            ((Intent)localObject).putExtra("finish_direct", true);
            com.tencent.mm.plugin.profile.b.iyx.d((Intent)localObject, paramAnonymousView.vNT);
          }
        }
      });
      this.vOr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27500);
          if ((NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this) != null) && ((NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this) instanceof ContactWidgetNewBizInfo)))
          {
            paramAnonymousView = (ContactWidgetNewBizInfo)NewBizInfoFollowPreference.a(NewBizInfoFollowPreference.this);
            ((com.tencent.mm.api.l)g.ab(com.tencent.mm.api.l.class)).a(paramAnonymousView.vIG, paramAnonymousView.vNT, paramAnonymousView.contact, true, new ContactWidgetNewBizInfo.6(paramAnonymousView));
            c.K(paramAnonymousView.contact.field_username, 1000, paramAnonymousView.iMg);
          }
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