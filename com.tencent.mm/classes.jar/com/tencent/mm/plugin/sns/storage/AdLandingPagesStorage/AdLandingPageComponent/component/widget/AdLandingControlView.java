package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.ui.base.MMPageControlView;
import java.util.Map;

public class AdLandingControlView
  extends MMPageControlView
{
  public AdLandingControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void ali(int paramInt)
  {
    AppMethodBeat.i(96829);
    removeAllViews();
    if (paramInt >= this.count)
    {
      AppMethodBeat.o(96829);
      return;
    }
    int j = this.count;
    int i = 0;
    if (i < j)
    {
      this.hIz = null;
      if (paramInt == i)
      {
        if (this.map.size() > i) {
          this.hIz = ((ImageView)this.map.get(Integer.valueOf(i)));
        }
        if (this.hIz == null)
        {
          this.hIz = ((ImageView)View.inflate(this.context, this.adSt, null).findViewById(b.f.mmpage_control_img));
          this.map.put(Integer.valueOf(i), this.hIz);
        }
        this.hIz.setSelected(true);
      }
      for (;;)
      {
        addView(this.hIz);
        i += 1;
        break;
        if (this.map.size() > i) {
          this.hIz = ((ImageView)this.map.get(Integer.valueOf(i)));
        }
        if (this.hIz == null)
        {
          this.hIz = ((ImageView)View.inflate(this.context, this.adSt, null).findViewById(b.f.mmpage_control_img));
          this.map.put(Integer.valueOf(i), this.hIz);
        }
        this.hIz.setSelected(false);
      }
    }
    AppMethodBeat.o(96829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingControlView
 * JD-Core Version:    0.7.0.1
 */