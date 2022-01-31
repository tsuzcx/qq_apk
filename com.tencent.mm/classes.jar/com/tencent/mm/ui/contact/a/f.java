package com.tencent.mm.ui.contact.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;

public class f
  extends a
{
  public CharSequence Agi;
  public int Agj;
  private f.b Agk;
  f.a Agl;
  public CharSequence gpH;
  public String username;
  
  public f(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(105287);
    this.Agj = 0;
    this.Agk = new f.b(this);
    this.Agl = new f.a(this);
    AppMethodBeat.o(105287);
  }
  
  public void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(105288);
    if ((this.Agj != 0) && (this.Agi != null))
    {
      AppMethodBeat.o(105288);
      return;
    }
    if (this.contact == null)
    {
      this.gpH = "";
      this.username = "";
      AppMethodBeat.o(105288);
      return;
    }
    this.gpH = j.b(paramContext, ((b)g.E(b.class)).c(this.contact), com.tencent.mm.cb.a.ao(paramContext, 2131427809));
    this.username = this.contact.field_username;
    AppMethodBeat.o(105288);
  }
  
  public a.b aoY()
  {
    return this.Agk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.f
 * JD-Core Version:    0.7.0.1
 */