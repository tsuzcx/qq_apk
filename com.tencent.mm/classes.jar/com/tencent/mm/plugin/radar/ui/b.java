package com.tencent.mm.plugin.radar.ui;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/ui/RadarAvatarDrawable;", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable;", "Lcom/tencent/mm/modelavatar/AvatarStorage$IOnAvatarChanged;", "tag", "", "(Ljava/lang/String;)V", "isCrop", "", "(Ljava/lang/String;Z)V", "notifyChanged", "", "Factory", "plugin-radar_release"})
public final class b
  extends j
  implements e.a
{
  private b(String paramString)
  {
    super(a.eHn(), paramString);
    AppMethodBeat.i(138590);
    AppMethodBeat.o(138590);
  }
  
  public final void Mr(String paramString)
  {
    AppMethodBeat.i(138589);
    p.h(paramString, "tag");
    super.Mr(paramString);
    AppMethodBeat.o(138589);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/ui/RadarAvatarDrawable$Factory;", "", "()V", "aLoader", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "getALoader", "()Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "setALoader", "(Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;)V", "attach", "", "iv", "Landroid/widget/ImageView;", "tag", "", "setLoader", "loader", "plugin-radar_release"})
  public static final class a
  {
    private static j.a Bzt;
    public static final a Bzu;
    
    static
    {
      AppMethodBeat.i(138588);
      Bzu = new a();
      AppMethodBeat.o(138588);
    }
    
    public static void a(j.a parama)
    {
      AppMethodBeat.i(138586);
      p.h(parama, "loader");
      Bzt = parama;
      AppMethodBeat.o(138586);
    }
    
    public static void c(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(138587);
      p.h(paramImageView, "iv");
      p.h(paramString, "tag");
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
    
    public static j.a eHn()
    {
      return Bzt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.b
 * JD-Core Version:    0.7.0.1
 */