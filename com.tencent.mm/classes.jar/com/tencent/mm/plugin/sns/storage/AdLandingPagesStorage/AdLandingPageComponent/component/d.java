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
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends b
{
  LinearLayout kjd;
  private ImageView oFo;
  private ImageView oFp;
  private TextView oFq;
  LinearLayout oFr;
  int oFs;
  
  public d(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d paramd, ViewGroup paramViewGroup)
  {
    super(paramContext, paramd, paramViewGroup);
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
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.oFE).oCu.isEmpty()) {
      return null;
    }
    View localView = this.contentView;
    this.oFo = ((ImageView)localView.findViewById(i.f.left_icon));
    this.oFp = ((ImageView)localView.findViewById(i.f.right_arrow));
    this.oFq = ((TextView)localView.findViewById(i.f.desc));
    this.kjd = ((LinearLayout)localView.findViewById(i.f.container));
    this.oFr = ((LinearLayout)localView.findViewById(i.f.innter_container));
    return this.contentView;
  }
  
  protected final void bFj()
  {
    this.oFq.setText((CharSequence)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.oFE).oCu.get(0));
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.oFE).oDo)
    {
      this.oFo.setImageDrawable(a.g(this.context, i.e.tel_w));
      this.oFp.setImageDrawable(a.g(this.context, i.e.right_arrow_w));
      this.oFq.setTextColor(-16777216);
      this.oFr.setBackgroundResource(i.e.adlanding_comp_click_dark);
    }
    for (;;)
    {
      this.oFr.setPadding((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.oFE).oDk, 0, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.oFE).oDl, 0);
      this.kjd.setPadding(0, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.oFE).oDi, 0, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.oFE).oDj);
      a(this.oFr);
      this.oFr.setOnClickListener(new d.1(this));
      return;
      this.oFo.setImageDrawable(a.g(this.context, i.e.tel));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d
 * JD-Core Version:    0.7.0.1
 */