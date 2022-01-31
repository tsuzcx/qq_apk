package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.ui.base.MMPageControlView;
import java.util.Map;

public class AdLandingControlView
  extends MMPageControlView
{
  public AdLandingControlView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdLandingControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected final void yh(int paramInt)
  {
    removeAllViews();
    if (paramInt >= this.count) {
      return;
    }
    int j = this.count;
    int i = 0;
    label20:
    if (i < j)
    {
      this.bNu = null;
      if (paramInt != i) {
        break label141;
      }
      if (this.map.size() > i) {
        this.bNu = ((ImageView)this.map.get(Integer.valueOf(i)));
      }
      if (this.bNu == null)
      {
        this.bNu = ((ImageView)View.inflate(this.context, this.uWI, null).findViewById(i.f.mmpage_control_img));
        this.map.put(Integer.valueOf(i), this.bNu);
      }
      this.bNu.setSelected(true);
    }
    for (;;)
    {
      addView(this.bNu);
      i += 1;
      break label20;
      break;
      label141:
      if (this.map.size() > i) {
        this.bNu = ((ImageView)this.map.get(Integer.valueOf(i)));
      }
      if (this.bNu == null)
      {
        this.bNu = ((ImageView)View.inflate(this.context, this.uWI, null).findViewById(i.f.mmpage_control_img));
        this.map.put(Integer.valueOf(i), this.bNu);
      }
      this.bNu.setSelected(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingControlView
 * JD-Core Version:    0.7.0.1
 */