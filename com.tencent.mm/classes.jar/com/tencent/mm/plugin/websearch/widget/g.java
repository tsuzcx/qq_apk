package com.tencent.mm.plugin.websearch.widget;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.y;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.ui.widget.picker.d;
import com.tencent.mm.ui.widget.picker.d.a;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class g
  extends y
{
  Context context;
  
  public g(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void a(String paramString1, String paramString2, t paramt)
  {
    AppMethodBeat.i(116650);
    ap.f(new g.1(this, paramString2, paramString1, paramt));
    AppMethodBeat.o(116650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.g
 * JD-Core Version:    0.7.0.1
 */