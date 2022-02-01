package com.tencent.mm.plugin.textstatus.h;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.util.a;
import com.tencent.mm.plugin.textstatus.util.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$StatusSpanWithDescListener;", "Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "userName", "", "iconTV", "Landroid/widget/TextView;", "iconType", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "(Ljava/lang/String;Landroid/widget/TextView;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;)V", "getIconScene", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "getIconType", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "onChange", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o$e
  extends o.a
{
  public static final o.e.a Tng;
  private final a.c Tnd;
  private final a.b Tne;
  
  static
  {
    AppMethodBeat.i(290444);
    Tng = new o.e.a((byte)0);
    AppMethodBeat.o(290444);
  }
  
  public o$e(String paramString, TextView paramTextView, a.c paramc, a.b paramb)
  {
    super(paramTextView, paramString);
    AppMethodBeat.i(290437);
    this.Tnd = paramc;
    this.Tne = paramb;
    onChange();
    AppMethodBeat.o(290437);
  }
  
  public final void onChange()
  {
    AppMethodBeat.i(290452);
    Log.d("MicroMsg.TextStatus.StatusSpanWithDescListener", s.X("onChange ", this.key));
    Object localObject = hHA().get();
    if ((localObject instanceof TextView)) {}
    for (localObject = (TextView)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(290452);
      return;
    }
    b.hKh();
    CharSequence localCharSequence = a.b((View)localObject, this.key, ((TextView)localObject).getText(), (int)((TextView)localObject).getTextSize(), this.Tnd, this.Tne);
    if ((localCharSequence != null) && (!s.p(((TextView)localObject).getText(), localCharSequence)))
    {
      ((TextView)localObject).setTextSize(12.0F);
      ((TextView)localObject).setText(localCharSequence);
    }
    AppMethodBeat.o(290452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.o.e
 * JD-Core Version:    0.7.0.1
 */