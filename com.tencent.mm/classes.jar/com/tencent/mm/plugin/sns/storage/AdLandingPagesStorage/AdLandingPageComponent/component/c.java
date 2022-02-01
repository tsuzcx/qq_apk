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
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d;
import com.tencent.mm.pluginsdk.ui.span.e;
import com.tencent.mm.pluginsdk.ui.span.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends a
{
  private ImageView Kpd;
  private ImageView Kpe;
  LinearLayout Kpf;
  int clickCount;
  private TextView msF;
  LinearLayout wSF;
  
  public c(Context paramContext, d paramd, ViewGroup paramViewGroup)
  {
    super(paramContext, paramd, paramViewGroup);
  }
  
  public final boolean by(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96418);
    if (!super.by(paramJSONObject))
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
  
  protected final void fKe()
  {
    AppMethodBeat.i(96416);
    this.msF.setText((CharSequence)((d)this.KqB).Kle.get(0));
    if (((d)this.KqB).KmF)
    {
      this.Kpd.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.e.tel_w));
      this.Kpe.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.e.right_arrow_w));
      this.msF.setTextColor(-16777216);
      this.Kpf.setBackgroundResource(i.e.adlanding_comp_click_dark);
    }
    for (;;)
    {
      this.Kpf.setPadding((int)((d)this.KqB).paddingLeft, 0, (int)((d)this.KqB).paddingRight, 0);
      this.wSF.setPadding(0, (int)((d)this.KqB).paddingTop, 0, (int)((d)this.KqB).paddingBottom);
      d(this.Kpf);
      this.Kpf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96415);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingContactComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = c.this;
          paramAnonymousView.clickCount += 1;
          if (e.a.RrL == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingContactComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96415);
            return;
          }
          if (((d)c.this.KqB).Kle.size() > 1) {
            e.a.RrL.a(c.this.context, ((d)c.this.KqB).Kle, new e.b()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(96414);
                ao.ic(c.this.context);
                AppMethodBeat.o(96414);
              }
            });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingContactComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96415);
            return;
            if (((d)c.this.KqB).Kle.size() > 0) {
              AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)c.this.context, (String)((d)c.this.KqB).Kle.get(0));
            }
          }
        }
      });
      AppMethodBeat.o(96416);
      return;
      this.Kpd.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.e.tel));
      this.Kpe.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.e.right_arrow));
      this.msF.setTextColor(-1);
      this.Kpf.setBackgroundResource(i.e.adlanding_comp_click_light);
    }
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(96417);
    if (((d)this.KqB).Kle.isEmpty())
    {
      AppMethodBeat.o(96417);
      return;
    }
    View localView = this.contentView;
    this.Kpd = ((ImageView)localView.findViewById(i.f.left_icon));
    this.Kpe = ((ImageView)localView.findViewById(i.f.right_arrow));
    this.msF = ((TextView)localView.findViewById(i.f.desc));
    this.wSF = ((LinearLayout)localView.findViewById(i.f.container));
    this.Kpf = ((LinearLayout)localView.findViewById(i.f.innter_container));
    AppMethodBeat.o(96417);
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_lbs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c
 * JD-Core Version:    0.7.0.1
 */