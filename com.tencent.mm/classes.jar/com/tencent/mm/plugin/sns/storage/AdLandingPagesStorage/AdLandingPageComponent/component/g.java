package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h.a;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  extends b
{
  private LinearLayout kjd;
  private View oFA;
  private ImageView oFB;
  private ImageView oFp;
  private TextView oFq;
  private LinearLayout oFr;
  int oFs;
  h oFz;
  
  public g(Context paramContext, h paramh, ViewGroup paramViewGroup)
  {
    super(paramContext, paramh, paramViewGroup);
    this.oFz = paramh;
  }
  
  public final boolean ah(JSONObject paramJSONObject)
  {
    if (!super.ah(paramJSONObject)) {
      return false;
    }
    try
    {
      paramJSONObject.put("clickCount", this.oFs);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      y.printErrStackTrace("AdLandingBorderedComp", paramJSONObject, "", new Object[0]);
    }
    return false;
  }
  
  public final View bFf()
  {
    View localView = this.contentView;
    this.oFB = ((ImageView)localView.findViewById(i.f.left_icon));
    this.oFp = ((ImageView)localView.findViewById(i.f.right_arrow));
    this.oFq = ((TextView)localView.findViewById(i.f.desc));
    this.oFr = ((LinearLayout)localView.findViewById(i.f.innter_container));
    this.kjd = ((LinearLayout)localView.findViewById(i.f.container));
    this.oFA = this.oFr;
    return this.contentView;
  }
  
  protected final void bFj()
  {
    this.oFq.setText(this.oFz.oCw.lCM);
    if (this.oFz.oDo)
    {
      this.oFB.setImageDrawable(a.g(this.context, i.e.lbs_w));
      this.oFp.setImageDrawable(a.g(this.context, i.e.right_arrow_w));
      this.oFq.setTextColor(-16777216);
      this.oFr.setBackgroundResource(i.e.adlanding_comp_click_dark);
    }
    for (;;)
    {
      this.oFr.setPadding((int)this.oFz.oDk, 0, (int)this.oFz.oDl, 0);
      this.kjd.setPadding(0, (int)this.oFz.oDi, 0, (int)this.oFz.oDj);
      a(this.oFr);
      g.1 local1 = new g.1(this);
      if (this.oFA != null) {
        this.oFA.setOnClickListener(local1);
      }
      return;
      this.oFB.setImageDrawable(a.g(this.context, i.e.lbs));
      this.oFp.setImageDrawable(a.g(this.context, i.e.right_arrow));
      this.oFq.setTextColor(-1);
      this.oFr.setBackgroundResource(i.e.adlanding_comp_click_light);
    }
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_lbs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g
 * JD-Core Version:    0.7.0.1
 */