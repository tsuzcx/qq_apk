package com.tencent.mm.plugin.radar.ui;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/ui/RadarAvatarDrawable;", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable;", "Lcom/tencent/mm/modelavatar/AvatarStorage$IOnAvatarChanged;", "tag", "", "(Ljava/lang/String;)V", "isCrop", "", "(Ljava/lang/String;Z)V", "notifyChanged", "", "Factory", "plugin-radar_release"})
public final class b
  extends i
  implements e.a
{
  private b(String paramString)
  {
    super(a.dfe(), paramString);
    AppMethodBeat.i(138590);
    AppMethodBeat.o(138590);
  }
  
  public final void vZ(String paramString)
  {
    AppMethodBeat.i(138589);
    k.h(paramString, "tag");
    super.vZ(paramString);
    AppMethodBeat.o(138589);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/ui/RadarAvatarDrawable$Factory;", "", "()V", "aLoader", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "getALoader", "()Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "setALoader", "(Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;)V", "attach", "", "iv", "Landroid/widget/ImageView;", "tag", "", "setLoader", "loader", "plugin-radar_release"})
  public static final class a
  {
    private static i.a uSX;
    public static final a uSY;
    
    static
    {
      AppMethodBeat.i(138588);
      uSY = new a();
      AppMethodBeat.o(138588);
    }
    
    public static void a(i.a parama)
    {
      AppMethodBeat.i(138586);
      k.h(parama, "loader");
      uSX = parama;
      AppMethodBeat.o(138586);
    }
    
    public static void c(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(138587);
      k.h(paramImageView, "iv");
      k.h(paramString, "tag");
      Object localObject = paramImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof b))) {}
      for (localObject = (b)localObject;; localObject = new b(paramString, (byte)0))
      {
        ((b)localObject).setTag(paramString);
        paramImageView.setImageDrawable((Drawable)localObject);
        AppMethodBeat.o(138587);
        return;
      }
    }
    
    public static i.a dfe()
    {
      return uSX;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.b
 * JD-Core Version:    0.7.0.1
 */