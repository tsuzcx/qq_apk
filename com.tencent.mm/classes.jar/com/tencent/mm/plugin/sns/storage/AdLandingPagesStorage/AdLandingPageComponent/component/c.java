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
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d;
import com.tencent.mm.pluginsdk.ui.span.e;
import com.tencent.mm.pluginsdk.ui.span.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.f.b;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends a
{
  LinearLayout Api;
  private ImageView QNk;
  private ImageView QNl;
  LinearLayout QNm;
  int clickCount;
  private TextView pmf;
  
  public c(Context paramContext, d paramd, ViewGroup paramViewGroup)
  {
    super(paramContext, paramd, paramViewGroup);
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(96417);
    if (((d)this.QOV).QJl.isEmpty())
    {
      AppMethodBeat.o(96417);
      return;
    }
    View localView = this.contentView;
    this.QNk = ((ImageView)localView.findViewById(b.f.left_icon));
    this.QNl = ((ImageView)localView.findViewById(b.f.right_arrow));
    this.pmf = ((TextView)localView.findViewById(b.f.desc));
    this.Api = ((LinearLayout)localView.findViewById(b.f.container));
    this.QNm = ((LinearLayout)localView.findViewById(b.f.innter_container));
    AppMethodBeat.o(96417);
  }
  
  public final boolean bP(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96418);
    if (!super.bP(paramJSONObject))
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
      Log.printErrStackTrace("AdLandingBorderedComp", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96418);
    }
    return false;
  }
  
  protected final int getLayout()
  {
    return b.g.sns_ad_native_landing_pages_item_lbs;
  }
  
  protected final void had()
  {
    AppMethodBeat.i(96416);
    this.pmf.setText((CharSequence)((d)this.QOV).QJl.get(0));
    if (((d)this.QOV).QKK)
    {
      this.QNk.setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.e.tel_w));
      this.QNl.setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.e.right_arrow_w));
      this.pmf.setTextColor(-16777216);
      this.QNm.setBackgroundResource(b.e.adlanding_comp_click_dark);
    }
    for (;;)
    {
      this.QNm.setPadding((int)((d)this.QOV).paddingLeft, 0, (int)((d)this.QOV).paddingRight, 0);
      this.Api.setPadding(0, (int)((d)this.QOV).paddingTop, 0, (int)((d)this.QOV).paddingBottom);
      f(this.QNm);
      this.QNm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96415);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingContactComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = c.this;
          paramAnonymousView.clickCount += 1;
          if (e.a.YnZ == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingContactComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96415);
            return;
          }
          if (((d)c.this.QOV).QJl.size() > 1) {
            e.a.YnZ.a(c.this.context, ((d)c.this.QOV).QJl, new f.b()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(96414);
                ar.jS(c.this.context);
                AppMethodBeat.o(96414);
              }
            });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingContactComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96415);
            return;
            if (((d)c.this.QOV).QJl.size() > 0) {
              AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)c.this.context, (String)((d)c.this.QOV).QJl.get(0));
            }
          }
        }
      });
      AppMethodBeat.o(96416);
      return;
      this.QNk.setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.e.tel));
      this.QNl.setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.e.right_arrow));
      this.pmf.setTextColor(-1);
      this.QNm.setBackgroundResource(b.e.adlanding_comp_click_light);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c
 * JD-Core Version:    0.7.0.1
 */