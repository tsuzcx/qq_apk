package com.tencent.mm.plugin.recordvideo.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.recordvideo.b.h;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/accessibility/RecordDecAccessibility;", "", "()V", "TAG", "", "setPainColor", "", "view", "Landroid/view/View;", "colorId", "", "setStringDesc", "desc", "setTagToAccessibility", "id", "tag", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c NDf;
  
  static
  {
    AppMethodBeat.i(279357);
    NDf = new c();
    AppMethodBeat.o(279357);
  }
  
  public static void aO(View paramView, int paramInt)
  {
    AppMethodBeat.i(279341);
    s.u(paramView, "view");
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(279341);
      return;
    case -1: 
      paramInt = b.h.aging_color_white;
    }
    for (;;)
    {
      Object localObject = am.aixg;
      localObject = a.bt(paramView.getContext(), b.h.aging_color_pencil);
      s.s(localObject, "getString(view.context, …tring.aging_color_pencil)");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { a.bt(paramView.getContext(), paramInt) }, 1));
      s.s(localObject, "java.lang.String.format(format, *args)");
      s.u(paramView, "view");
      s.u(localObject, "desc");
      paramView.setContentDescription((CharSequence)localObject);
      AppMethodBeat.o(279341);
      return;
      paramInt = b.h.aging_color_black;
      continue;
      paramInt = b.h.aging_color_red;
      continue;
      paramInt = b.h.aging_color_yellow;
      continue;
      paramInt = b.h.aging_color_green;
      continue;
      paramInt = b.h.aging_color_blue;
      continue;
      paramInt = b.h.aging_color_purple;
      continue;
      paramInt = b.h.aging_color_mosaic;
      continue;
      paramInt = b.h.aging_color_poor;
    }
  }
  
  public static void x(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(279349);
    s.u(paramView, "view");
    paramView.setTag(paramInt1, a.bt(paramView.getContext(), paramInt2));
    AppMethodBeat.o(279349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.a.c
 * JD-Core Version:    0.7.0.1
 */