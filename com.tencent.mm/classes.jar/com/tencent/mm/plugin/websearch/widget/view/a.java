package com.tencent.mm.plugin.websearch.widget.view;

import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.sdk.platformtools.ac;
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
  private static final a CbI;
  public Map<Integer, e> CbG;
  private c CbH;
  
  static
  {
    AppMethodBeat.i(116674);
    CbI = new a();
    AppMethodBeat.o(116674);
  }
  
  private a()
  {
    AppMethodBeat.i(116672);
    this.CbG = new HashMap();
    c.a locala = new c.a();
    locala.hKx = true;
    locala.hKw = true;
    this.CbH = locala.aFT();
    AppMethodBeat.o(116672);
  }
  
  public static a exY()
  {
    return CbI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.a
 * JD-Core Version:    0.7.0.1
 */