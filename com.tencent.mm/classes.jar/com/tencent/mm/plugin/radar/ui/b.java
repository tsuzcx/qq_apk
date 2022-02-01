package com.tencent.mm.plugin.radar.ui;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/RadarAvatarDrawable;", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable;", "Lcom/tencent/mm/modelavatar/AvatarStorage$IOnAvatarChanged;", "tag", "", "(Ljava/lang/String;)V", "isCrop", "", "(Ljava/lang/String;Z)V", "notifyChanged", "", "Factory", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends j
  implements AvatarStorage.a
{
  private b(String paramString)
  {
    super(a.gFe(), paramString);
    AppMethodBeat.i(138590);
    AppMethodBeat.o(138590);
  }
  
  public final void LM(String paramString)
  {
    AppMethodBeat.i(138589);
    s.u(paramString, "tag");
    super.LM(paramString);
    AppMethodBeat.o(138589);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/RadarAvatarDrawable$Factory;", "", "()V", "aLoader", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "getALoader", "()Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "setALoader", "(Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;)V", "attach", "", "iv", "Landroid/widget/ImageView;", "tag", "", "setLoader", "loader", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a NsB;
    private static j.a NsC;
    
    static
    {
      AppMethodBeat.i(138588);
      NsB = new a();
      AppMethodBeat.o(138588);
    }
    
    public static void a(j.a parama)
    {
      AppMethodBeat.i(138586);
      s.u(parama, "loader");
      NsC = parama;
      AppMethodBeat.o(138586);
    }
    
    public static void g(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(138587);
      s.u(paramImageView, "iv");
      s.u(paramString, "tag");
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
    
    public static j.a gFe()
    {
      return NsC;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.b
 * JD-Core Version:    0.7.0.1
 */