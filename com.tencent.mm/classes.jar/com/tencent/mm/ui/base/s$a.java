package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.k;

final class s$a
{
  private static Toast kEZ = null;
  public static int uYM = 0;
  
  public static void ao(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getApplicationContext();
    if (uYM != paramInt)
    {
      kEZ = null;
      uYM = paramInt;
    }
    if (kEZ == null) {
      kEZ = Toast.makeText(paramContext, "", 1);
    }
    paramContext = View.inflate(paramContext, a.h.sdcard_eject_toast, null);
    if (paramInt == 1) {
      ((TextView)paramContext.findViewById(a.g.sdcard_toast_text)).setText(a.k.media_ejected);
    }
    for (;;)
    {
      kEZ.setView(paramContext);
      kEZ.show();
      return;
      if (paramInt == 3) {
        ((TextView)paramContext.findViewById(a.g.sdcard_toast_text)).setText(a.k.media_ejected_readonly);
      } else {
        ((TextView)paramContext.findViewById(a.g.sdcard_toast_text)).setText(a.k.media_full);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.s.a
 * JD-Core Version:    0.7.0.1
 */