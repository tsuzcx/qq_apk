package com.tencent.mm.plugin.radar.ui;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/ui/RadarAvatarDrawable;", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable;", "Lcom/tencent/mm/modelavatar/AvatarStorage$IOnAvatarChanged;", "tag", "", "(Ljava/lang/String;)V", "isCrop", "", "(Ljava/lang/String;Z)V", "notifyChanged", "", "Factory", "plugin-radar_release"})
public final class b
  extends i
  implements e.a
{
  private b(String paramString)
  {
    super(a.dsL(), paramString);
    AppMethodBeat.i(138590);
    AppMethodBeat.o(138590);
  }
  
  public final void Af(String paramString)
  {
    AppMethodBeat.i(138589);
    k.h(paramString, "tag");
    super.Af(paramString);
    AppMethodBeat.o(138589);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/ui/RadarAvatarDrawable$Factory;", "", "()V", "aLoader", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "getALoader", "()Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "setALoader", "(Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;)V", "attach", "", "iv", "Landroid/widget/ImageView;", "tag", "", "setLoader", "loader", "plugin-radar_release"})
  public static final class a
  {
    private static i.a wbM;
    public static final a wbN;
    
    static
    {
      AppMethodBeat.i(138588);
      wbN = new a();
      AppMethodBeat.o(138588);
    }
    
    public static void a(i.a parama)
    {
      AppMethodBeat.i(138586);
      k.h(parama, "loader");
      wbM = parama;
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
    
    public static i.a dsL()
    {
      return wbM;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.b
 * JD-Core Version:    0.7.0.1
 */