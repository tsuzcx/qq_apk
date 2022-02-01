package com.tencent.mm.plugin.websearch.widget.view;

import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private static final a AJr;
  public Map<Integer, e> AJp;
  private c AJq;
  
  static
  {
    AppMethodBeat.i(116674);
    AJr = new a();
    AppMethodBeat.o(116674);
  }
  
  private a()
  {
    AppMethodBeat.i(116672);
    this.AJp = new HashMap();
    c.a locala = new c.a();
    locala.hjU = true;
    locala.hjT = true;
    this.AJq = locala.azc();
    AppMethodBeat.o(116672);
  }
  
  public static a eiE()
  {
    return AJr;
  }
  
  public final void Sp(int paramInt)
  {
    AppMethodBeat.i(116673);
    e locale = (e)this.AJp.remove(Integer.valueOf(paramInt));
    if (locale != null) {
      locale.bfo();
    }
    AppMethodBeat.o(116673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.a
 * JD-Core Version:    0.7.0.1
 */