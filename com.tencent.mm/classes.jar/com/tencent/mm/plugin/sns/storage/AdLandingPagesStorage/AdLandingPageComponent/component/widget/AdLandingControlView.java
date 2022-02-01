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
  
  public final void ON(int paramInt)
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
      this.dhf = null;
      if (paramInt == i)
      {
        if (this.map.size() > i) {
          this.dhf = ((ImageView)this.map.get(Integer.valueOf(i)));
        }
        if (this.dhf == null)
        {
          this.dhf = ((ImageView)View.inflate(this.context, this.Hyp, null).findViewById(2131302343));
          this.map.put(Integer.valueOf(i), this.dhf);
        }
        this.dhf.setSelected(true);
      }
      for (;;)
      {
        addView(this.dhf);
        i += 1;
        break;
        if (this.map.size() > i) {
          this.dhf = ((ImageView)this.map.get(Integer.valueOf(i)));
        }
        if (this.dhf == null)
        {
          this.dhf = ((ImageView)View.inflate(this.context, this.Hyp, null).findViewById(2131302343));
          this.map.put(Integer.valueOf(i), this.dhf);
        }
        this.dhf.setSelected(false);
      }
    }
    AppMethodBeat.o(96829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingControlView
 * JD-Core Version:    0.7.0.1
 */