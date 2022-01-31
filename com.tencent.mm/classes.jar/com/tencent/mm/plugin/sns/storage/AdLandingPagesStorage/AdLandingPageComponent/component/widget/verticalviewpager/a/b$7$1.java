package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.sdk.platformtools.y;

final class b$7$1
  implements ViewTreeObserver.OnPreDrawListener
{
  b$7$1(b.7 param7) {}
  
  public final boolean onPreDraw()
  {
    if (b.a(this.oJH.oJz).oJL.getHeight() > 0)
    {
      b.a(this.oJH.oJz).oJL.getViewTreeObserver().removeOnPreDrawListener(this);
      b.b(this.oJH.oJz, b.a(this.oJH.oJz).oJL.getHeight());
      if (b.n(this.oJH.oJz) < b.f(this.oJH.oJz)) {
        b.b(this.oJH.oJz, b.f(this.oJH.oJz));
      }
      Object localObject = (FrameLayout.LayoutParams)b.a(this.oJH.oJz).oJI.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).height = b.n(this.oJH.oJz);
      b.a(this.oJH.oJz).oJI.setLayoutParams((ViewGroup.LayoutParams)localObject);
      y.i("ContentFragment", "set bgIV height " + b.a(this.oJH.oJz).oJL.getHeight() + ", count " + b.a(this.oJH.oJz).oJL.getChildCount());
      int i = 0;
      while (i < b.a(this.oJH.oJz).oJL.getChildCount())
      {
        localObject = b.a(this.oJH.oJz).oJL.getChildAt(i).getTag();
        if ((localObject instanceof i)) {
          ((i)localObject).bES();
        }
        i += 1;
      }
      b.a(this.oJH.oJz).oJL.removeAllViews();
      b.a(this.oJH.oJz).oJL.setVisibility(8);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.7.1
 * JD-Core Version:    0.7.0.1
 */