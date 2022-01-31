package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class aa
  extends a
{
  private Runnable eKD;
  TextView flb;
  
  public aa(Context paramContext, u paramu, ViewGroup paramViewGroup)
  {
    super(paramContext, paramu, paramViewGroup);
  }
  
  public final void bES()
  {
    super.bES();
    if (!e.remove(this.eKD)) {
      e.Y(this.eKD);
    }
  }
  
  public final void bET()
  {
    super.bET();
  }
  
  public final void bEU()
  {
    super.bEU();
  }
  
  @TargetApi(17)
  public final View bFf()
  {
    View localView = this.contentView;
    localView.setBackgroundColor(this.backgroundColor);
    localView.findViewById(i.f.sns_ad_landingpage_text_layout).setBackgroundColor(this.backgroundColor);
    localView.findViewById(i.f.sns_ad_landingpage_text_wordTitle).setBackgroundColor(this.backgroundColor);
    this.flb = ((TextView)localView.findViewById(i.f.sns_ad_landingpage_text_wordTitle));
    return localView;
  }
  
  protected final void bFj()
  {
    Object localObject;
    if (((u)this.oFE).brC == 1)
    {
      if (!bk.bl(((u)this.oFE).oDD))
      {
        localObject = ((u)this.oFE).oDD.replace("<icon", "<img");
        e.remove(this.eKD);
        this.eKD = new aa.1(this, (String)localObject);
        e.post(this.eKD, "");
      }
      if (((u)this.oFE).textAlignment != 0) {
        break label362;
      }
      this.flb.setGravity(3);
      label99:
      if ((((u)this.oFE).oDE == null) || (((u)this.oFE).oDE.length() <= 0)) {
        break label447;
      }
    }
    for (;;)
    {
      try
      {
        i = Color.parseColor(((u)this.oFE).oDE);
        this.flb.setTextColor(i);
        if (((u)this.oFE).dOB > 0.0F) {
          this.flb.setTextSize(0, ((u)this.oFE).dOB);
        }
        if (((u)this.oFE).oDJ > 0.0F) {
          this.flb.setLineSpacing(0.0F, ((u)this.oFE).oDJ + 1.0F);
        }
        localObject = this.flb.getPaint();
        if (((u)this.oFE).oDF) {
          ((TextPaint)localObject).setFakeBoldText(true);
        }
        if (((u)this.oFE).oDG) {
          ((TextPaint)localObject).setTextSkewX(-0.25F);
        }
        if (((u)this.oFE).oDH) {
          ((TextPaint)localObject).setUnderlineText(true);
        }
        if (((u)this.oFE).maxLines > 0) {
          this.flb.setMaxLines(((u)this.oFE).maxLines);
        }
        if (((u)this.oFE).oDI == u.oDC) {
          this.flb.setTypeface(ad.ef(this.context));
        }
        return;
        this.flb.setText(((u)this.oFE).oDD);
        break;
        label362:
        if (((u)this.oFE).textAlignment == 1)
        {
          this.flb.setGravity(17);
          break label99;
        }
        if (((u)this.oFE).textAlignment != 2) {
          break label99;
        }
        this.flb.setGravity(5);
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.Sns.AdLandingPageTextComponent", "parse the color is error : " + ((u)this.oFE).oDE);
        continue;
      }
      label447:
      int i = Color.parseColor("#FFFFFF");
      this.flb.setTextColor(i);
    }
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_text;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa
 * JD-Core Version:    0.7.0.1
 */