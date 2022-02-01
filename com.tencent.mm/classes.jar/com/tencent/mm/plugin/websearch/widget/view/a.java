package com.tencent.mm.plugin.websearch.widget.view;

import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private static final a DEG;
  public Map<Integer, e> DEE;
  private c DEF;
  
  static
  {
    AppMethodBeat.i(116674);
    DEG = new a();
    AppMethodBeat.o(116674);
  }
  
  private a()
  {
    AppMethodBeat.i(116672);
    this.DEE = new HashMap();
    c.a locala = new c.a();
    locala.idr = true;
    locala.idq = true;
    this.DEF = locala.aJc();
    AppMethodBeat.o(116672);
  }
  
  public static a eMP()
  {
    return DEG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.a
 * JD-Core Version:    0.7.0.1
 */