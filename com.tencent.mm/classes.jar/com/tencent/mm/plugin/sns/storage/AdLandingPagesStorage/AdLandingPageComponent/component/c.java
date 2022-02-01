package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.pluginsdk.ui.span.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends a
{
  int clickCount;
  private TextView iDG;
  LinearLayout rEk;
  LinearLayout zCA;
  private ImageView zCy;
  private ImageView zCz;
  
  public c(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d paramd, ViewGroup paramViewGroup)
  {
    super(paramContext, paramd, paramViewGroup);
  }
  
  public final boolean aQ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96418);
    if (!super.aQ(paramJSONObject))
    {
      AppMethodBeat.o(96418);
      return false;
    }
    try
    {
      paramJSONObject.put("clickCount", this.clickCount);
      AppMethodBeat.o(96418);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      ad.printErrStackTrace("AdLandingBorderedComp", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96418);
    }
    return false;
  }
  
  public final void dRk()
  {
    AppMethodBeat.i(96417);
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.zDK).zyx.isEmpty())
    {
      AppMethodBeat.o(96417);
      return;
    }
    View localView = this.contentView;
    this.zCy = ((ImageView)localView.findViewById(2131301384));
    this.zCz = ((ImageView)localView.findViewById(2131304172));
    this.iDG = ((TextView)localView.findViewById(2131298996));
    this.rEk = ((LinearLayout)localView.findViewById(2131298736));
    this.zCA = ((LinearLayout)localView.findViewById(2131301023));
    AppMethodBeat.o(96417);
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(96416);
    this.iDG.setText((CharSequence)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.zDK).zyx.get(0));
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.zDK).zAk)
    {
      this.zCy.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131234338));
      this.zCz.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131233863));
      this.iDG.setTextColor(-16777216);
      this.zCA.setBackgroundResource(2131230900);
    }
    for (;;)
    {
      this.zCA.setPadding((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.zDK).paddingLeft, 0, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.zDK).paddingRight, 0);
      this.rEk.setPadding(0, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.zDK).paddingTop, 0, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.zDK).paddingBottom);
      a(this.zCA);
      this.zCA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96415);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingContactComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = c.this;
          paramAnonymousView.clickCount += 1;
          if (d.a.Fhe == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingContactComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96415);
            return;
          }
          if (c.a(c.this).zyx.size() > 1) {
            d.a.Fhe.a(c.this.context, c.a(c.this).zyx, new e.b()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(96414);
                am.gl(c.this.context);
                AppMethodBeat.o(96414);
              }
            });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingContactComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96415);
            return;
            if (c.a(c.this).zyx.size() > 0) {
              AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)c.this.context, (String)c.a(c.this).zyx.get(0));
            }
          }
        }
      });
      AppMethodBeat.o(96416);
      return;
      this.zCy.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131234337));
      this.zCz.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131233862));
      this.iDG.setTextColor(-1);
      this.zCA.setBackgroundResource(2131230901);
    }
  }
  
  protected final int getLayout()
  {
    return 2131495503;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c
 * JD-Core Version:    0.7.0.1
 */