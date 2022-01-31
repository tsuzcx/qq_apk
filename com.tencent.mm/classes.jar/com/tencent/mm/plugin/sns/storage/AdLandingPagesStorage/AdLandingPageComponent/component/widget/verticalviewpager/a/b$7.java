package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.ui.al;
import java.util.LinkedList;

final class b$7
  implements Runnable
{
  b$7(b paramb) {}
  
  public final void run()
  {
    if (b.a(this.oJz) == null) {}
    for (;;)
    {
      return;
      if (((b.d(this.oJz).oKw) || (!TextUtils.isEmpty(b.d(this.oJz).oKv))) && (!b.l(this.oJz)))
      {
        b.m(this.oJz);
        b.a(this.oJz).oJL.setVisibility(0);
        b.a(this.oJz).oJI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        b.a(this.oJz).oJL.getViewTreeObserver().addOnPreDrawListener(new b.7.1(this));
        a locala = b.o(this.oJz);
        LinearLayout localLinearLayout = b.a(this.oJz).oJL;
        int i = 0;
        while (i < locala.oJg.oKx.size())
        {
          Object localObject = (s)locala.oJg.oKx.get(i);
          localObject = al.a(localLinearLayout.getContext(), (s)localObject, localLinearLayout, locala.bgColor);
          if (localObject != null)
          {
            if ((((i)localObject).getView().getParent() != null) && ((((i)localObject).getView().getParent() instanceof ViewGroup))) {
              ((ViewGroup)((i)localObject).getView().getParent()).removeView(((i)localObject).getView());
            }
            ((i)localObject).getView().setTag(localObject);
            localLinearLayout.addView(((i)localObject).getView());
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.7
 * JD-Core Version:    0.7.0.1
 */