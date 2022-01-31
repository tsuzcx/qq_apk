package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  
  public final void Eg(int paramInt)
  {
    AppMethodBeat.i(37368);
    removeAllViews();
    if (paramInt >= this.count)
    {
      AppMethodBeat.o(37368);
      return;
    }
    int j = this.count;
    int i = 0;
    if (i < j)
    {
      this.cuM = null;
      if (paramInt == i)
      {
        if (this.map.size() > i) {
          this.cuM = ((ImageView)this.map.get(Integer.valueOf(i)));
        }
        if (this.cuM == null)
        {
          this.cuM = ((ImageView)View.inflate(this.context, this.zlb, null).findViewById(2131826286));
          this.map.put(Integer.valueOf(i), this.cuM);
        }
        this.cuM.setSelected(true);
      }
      for (;;)
      {
        addView(this.cuM);
        i += 1;
        break;
        if (this.map.size() > i) {
          this.cuM = ((ImageView)this.map.get(Integer.valueOf(i)));
        }
        if (this.cuM == null)
        {
          this.cuM = ((ImageView)View.inflate(this.context, this.zlb, null).findViewById(2131826286));
          this.map.put(Integer.valueOf(i), this.cuM);
        }
        this.cuM.setSelected(false);
      }
    }
    AppMethodBeat.o(37368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingControlView
 * JD-Core Version:    0.7.0.1
 */