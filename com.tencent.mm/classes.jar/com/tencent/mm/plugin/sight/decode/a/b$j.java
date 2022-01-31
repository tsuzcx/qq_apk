package com.tencent.mm.plugin.sight.decode.a;

import android.widget.TextView;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import java.lang.ref.WeakReference;

final class b$j
  implements Runnable
{
  private b$j(b paramb) {}
  
  public final void run()
  {
    if ((b.e(this.oeY) < 0) || (b.j(this.oeY) == null) || (b.j(this.oeY).get() == null)) {
      return;
    }
    String str = SightVideoJNI.getVideoInfo(b.e(this.oeY));
    ((TextView)b.j(this.oeY).get()).setText(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.j
 * JD-Core Version:    0.7.0.1
 */