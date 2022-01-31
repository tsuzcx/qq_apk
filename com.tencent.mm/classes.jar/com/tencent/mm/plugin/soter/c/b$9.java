package com.tencent.mm.plugin.soter.c;

import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.soter.a.b;
import com.tencent.mm.plugin.soter.a.c;
import com.tencent.mm.plugin.soter.a.f;

final class b$9
  implements Runnable
{
  b$9(b paramb) {}
  
  public final void run()
  {
    this.psa.gSp.setTextColor(this.psa.gSp.getResources().getColor(a.b.hint_color));
    this.psa.gSp.setText(this.psa.gSp.getResources().getString(a.f.soter_mp_fingerprint_hint));
    this.psa.prT.setImageResource(a.c.fingerprint_luggage_icon);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.b.9
 * JD-Core Version:    0.7.0.1
 */