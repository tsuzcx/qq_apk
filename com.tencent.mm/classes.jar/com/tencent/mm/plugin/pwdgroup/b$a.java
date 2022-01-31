package com.tencent.mm.plugin.pwdgroup;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.i.a;

public final class b$a
{
  static i.a pFL;
  
  public static void c(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(23974);
    Object localObject = paramImageView.getDrawable();
    if ((localObject != null) && ((localObject instanceof b))) {}
    for (localObject = (b)localObject;; localObject = new b(paramString, (byte)0))
    {
      ((b)localObject).setTag(paramString);
      paramImageView.setImageDrawable((Drawable)localObject);
      AppMethodBeat.o(23974);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.b.a
 * JD-Core Version:    0.7.0.1
 */