package com.tencent.mm.plugin.textstatus.h;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.util.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$StatusIconListener;", "Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "userName", "", "iconIV", "Landroid/widget/ImageView;", "(Ljava/lang/String;Landroid/widget/ImageView;)V", "onChange", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o$b
  extends o.a
{
  public static final o.b.a Tnb;
  
  static
  {
    AppMethodBeat.i(290466);
    Tnb = new o.b.a((byte)0);
    AppMethodBeat.o(290466);
  }
  
  public o$b(String paramString, ImageView paramImageView)
  {
    super(paramImageView, paramString);
    AppMethodBeat.i(290457);
    paramImageView = o.Tna;
    o.bdU(paramString);
    AppMethodBeat.o(290457);
  }
  
  public final void onChange()
  {
    Object localObject2 = null;
    AppMethodBeat.i(290483);
    Log.i("MicroMsg.TextStatus.StatusIconListener", s.X("onChange ", this.key));
    Object localObject1 = hHA().get();
    Object localObject3;
    com.tencent.mm.plugin.textstatus.h.f.b localb;
    if ((localObject1 instanceof ImageView))
    {
      localObject1 = (ImageView)localObject1;
      localObject3 = f.TjQ;
      localb = f.bdN(this.key);
      if (localb != null) {
        break label84;
      }
    }
    for (;;)
    {
      if ((localObject2 == null) && (localObject1 != null)) {
        ((ImageView)localObject1).setVisibility(8);
      }
      AppMethodBeat.o(290483);
      return;
      localObject1 = null;
      break;
      label84:
      localObject3 = localb.field_IconID;
      if (localObject3 != null)
      {
        a.a(com.tencent.mm.plugin.textstatus.util.b.hKh(), (ImageView)localObject1, (String)localObject3, a.c.ThP, null, localb, 8);
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(0);
        }
        localObject2 = localObject3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.o.b
 * JD-Core Version:    0.7.0.1
 */