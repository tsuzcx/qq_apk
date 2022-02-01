package com.tencent.mm.plugin.textstatus.h;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.util.a;
import com.tencent.mm.plugin.textstatus.util.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$StatusSpanListenerNoMeasure;", "Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "userName", "", "iconTV", "Lcom/tencent/mm/ui/base/NoMeasuredTextView;", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "(Ljava/lang/String;Lcom/tencent/mm/ui/base/NoMeasuredTextView;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;)V", "getIconScene", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "onChange", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o$d
  extends o.a
{
  public static final o.d.a Tnf;
  private final a.b Tne;
  
  static
  {
    AppMethodBeat.i(290453);
    Tnf = new o.d.a((byte)0);
    AppMethodBeat.o(290453);
  }
  
  public o$d(String paramString, NoMeasuredTextView paramNoMeasuredTextView, a.b paramb)
  {
    super(paramNoMeasuredTextView, paramString);
    AppMethodBeat.i(290448);
    this.Tne = paramb;
    onChange();
    AppMethodBeat.o(290448);
  }
  
  public final void onChange()
  {
    AppMethodBeat.i(290464);
    Log.d("MicroMsg.TextStatus.StatusSpanListenerNoMeasure", s.X("onChange ", this.key));
    Object localObject = hHA().get();
    if ((localObject instanceof NoMeasuredTextView)) {}
    for (localObject = (NoMeasuredTextView)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(290464);
      return;
    }
    b.hKh();
    CharSequence localCharSequence = a.a((View)localObject, this.key, ((NoMeasuredTextView)localObject).getText(), (int)((NoMeasuredTextView)localObject).getTextSize(), a.c.ThP, this.Tne);
    if ((localCharSequence != null) && (!s.p(((NoMeasuredTextView)localObject).getText(), localCharSequence))) {
      ((NoMeasuredTextView)localObject).setText(localCharSequence);
    }
    AppMethodBeat.o(290464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.o.d
 * JD-Core Version:    0.7.0.1
 */