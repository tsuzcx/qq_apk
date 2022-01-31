package com.tencent.mm.ui.bizchat;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends com.tencent.mm.ui.contact.a.a
{
  private static Map<String, c> zsV;
  public CharSequence gpH;
  public long jUy;
  public String username;
  public String zsU;
  private a.b zsW;
  a.a zsX;
  
  static
  {
    AppMethodBeat.i(105189);
    zsV = new HashMap();
    AppMethodBeat.o(105189);
  }
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(105186);
    this.jUy = -1L;
    this.zsW = new a.b(this);
    this.zsX = new a.a(this);
    AppMethodBeat.o(105186);
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama)
  {
    AppMethodBeat.i(105187);
    this.gpH = j.b(paramContext, this.gpH, com.tencent.mm.cb.a.ao(paramContext, 2131427809));
    AppMethodBeat.o(105187);
  }
  
  public final com.tencent.mm.ui.contact.a.a.b aoY()
  {
    return this.zsW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.a
 * JD-Core Version:    0.7.0.1
 */