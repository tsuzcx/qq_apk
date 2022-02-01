package com.tencent.mm.plugin.websearch.widget.view;

import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.b;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private static final a IIv;
  public Map<Integer, e> IIt;
  private c IIu;
  
  static
  {
    AppMethodBeat.i(116674);
    IIv = new a();
    AppMethodBeat.o(116674);
  }
  
  private a()
  {
    AppMethodBeat.i(116672);
    this.IIt = new HashMap();
    c.a locala = new c.a();
    locala.jbf = true;
    locala.jbe = true;
    this.IIu = locala.bdv();
    AppMethodBeat.o(116672);
  }
  
  public static a fYZ()
  {
    return IIv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.a
 * JD-Core Version:    0.7.0.1
 */