package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.widget.TextView;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import java.lang.ref.WeakReference;

final class a$j
  implements Runnable
{
  private a$j(a parama) {}
  
  public final void run()
  {
    if ((a.e(this.oIA) < 0) || (a.j(this.oIA) == null) || (a.j(this.oIA).get() == null)) {
      return;
    }
    String str = SightVideoJNI.getVideoInfo(a.e(this.oIA));
    ((TextView)a.j(this.oIA).get()).setText(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.j
 * JD-Core Version:    0.7.0.1
 */