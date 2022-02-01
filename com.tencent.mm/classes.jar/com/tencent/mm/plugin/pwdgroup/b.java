package com.tencent.mm.plugin.pwdgroup;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;

public final class b
  extends i
  implements e.a
{
  private b(String paramString)
  {
    super(a.vQR, paramString);
  }
  
  public final void Af(String paramString)
  {
    AppMethodBeat.i(27614);
    super.Af(paramString);
    AppMethodBeat.o(27614);
  }
  
  public static final class a
  {
    static i.a vQR;
    
    public static void c(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(27613);
      Object localObject = paramImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof b))) {}
      for (localObject = (b)localObject;; localObject = new b(paramString, (byte)0))
      {
        ((b)localObject).setTag(paramString);
        paramImageView.setImageDrawable((Drawable)localObject);
        AppMethodBeat.o(27613);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.b
 * JD-Core Version:    0.7.0.1
 */