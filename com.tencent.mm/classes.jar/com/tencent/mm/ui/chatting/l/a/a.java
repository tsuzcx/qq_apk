package com.tencent.mm.ui.chatting.l.a;

import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.widget.MMTextView.a;

public class a
{
  private static volatile a Igk;
  private static final ao Igl;
  
  static
  {
    AppMethodBeat.i(36623);
    Igk = null;
    Igl = new ao("AAChattingHelper");
    AppMethodBeat.o(36623);
  }
  
  private a()
  {
    AppMethodBeat.i(185017);
    Igl.setLogging(false);
    AppMethodBeat.o(185017);
  }
  
  public static void a(CharSequence paramCharSequence, bo parambo)
  {
    AppMethodBeat.i(36621);
    a(paramCharSequence, parambo, 1);
    AppMethodBeat.o(36621);
  }
  
  private static void a(CharSequence paramCharSequence, bo parambo, int paramInt)
  {
    AppMethodBeat.i(36620);
    if ((paramCharSequence instanceof Spannable)) {
      Igl.postToWorker(new a.b(paramCharSequence, parambo, paramInt));
    }
    AppMethodBeat.o(36620);
  }
  
  public static a fqj()
  {
    AppMethodBeat.i(36619);
    if (Igk == null) {
      try
      {
        if (Igk == null) {
          Igk = new a();
        }
        a locala1 = Igk;
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(36619);
      }
    }
    a locala2 = Igk;
    AppMethodBeat.o(36619);
    return locala2;
  }
  
  public static MMTextView.a fqk()
  {
    return a.Igm;
  }
  
  static enum a
    implements MMTextView.a
  {
    static
    {
      AppMethodBeat.i(36616);
      Igm = new a("TEXT_CALLBACK");
      Ign = new a[] { Igm };
      AppMethodBeat.o(36616);
    }
    
    private a() {}
    
    public final void a(CharSequence paramCharSequence, long paramLong)
    {
      AppMethodBeat.i(36615);
      bo localbo = ((k)g.ab(k.class)).dcr().vP(paramLong);
      if (bs.isNullOrNil(localbo.field_talker))
      {
        ac.w("MicroMsg.AAChattingHelper", "hy: not retrieving correct msg from db. try use old one. msg id: %d", new Object[] { Long.valueOf(paramLong) });
        AppMethodBeat.o(36615);
        return;
      }
      if ((localbo.field_flag & 0x10) == 0)
      {
        a.b(paramCharSequence, localbo);
        AppMethodBeat.o(36615);
        return;
      }
      ac.v("MicroMsg.AAChattingHelper", "hy: show already checked. msg id is: %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(36615);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.a.a
 * JD-Core Version:    0.7.0.1
 */