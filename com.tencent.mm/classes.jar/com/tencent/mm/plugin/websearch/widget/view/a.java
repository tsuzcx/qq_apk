package com.tencent.mm.plugin.websearch.widget.view;

import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.b;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.f.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private static final a Wtv;
  public Map<Integer, f> Wtt;
  private c Wtu;
  
  static
  {
    AppMethodBeat.i(116674);
    Wtv = new a();
    AppMethodBeat.o(116674);
  }
  
  private a()
  {
    AppMethodBeat.i(116672);
    this.Wtt = new HashMap();
    c.a locala = new c.a();
    locala.oKp = true;
    locala.oKo = true;
    this.Wtu = locala.bKx();
    AppMethodBeat.o(116672);
  }
  
  public static a irf()
  {
    return Wtv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.a
 * JD-Core Version:    0.7.0.1
 */