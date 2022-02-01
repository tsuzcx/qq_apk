package com.tencent.mm.ui.chatting.m.a;

import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.widget.MMTextView.a;

public class a
{
  private static volatile a KsO;
  private static final aq KsP;
  
  static
  {
    AppMethodBeat.i(36623);
    KsO = null;
    KsP = new aq("AAChattingHelper");
    AppMethodBeat.o(36623);
  }
  
  private a()
  {
    AppMethodBeat.i(185017);
    KsP.setLogging(false);
    AppMethodBeat.o(185017);
  }
  
  public static void a(CharSequence paramCharSequence, bv parambv)
  {
    AppMethodBeat.i(36621);
    a(paramCharSequence, parambv, 1);
    AppMethodBeat.o(36621);
  }
  
  private static void a(CharSequence paramCharSequence, bv parambv, int paramInt)
  {
    AppMethodBeat.i(36620);
    if ((paramCharSequence instanceof Spannable)) {
      KsP.postToWorker(new a.b(paramCharSequence, parambv, paramInt));
    }
    AppMethodBeat.o(36620);
  }
  
  public static a fLp()
  {
    AppMethodBeat.i(36619);
    if (KsO == null) {
      try
      {
        if (KsO == null) {
          KsO = new a();
        }
        a locala1 = KsO;
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(36619);
      }
    }
    a locala2 = KsO;
    AppMethodBeat.o(36619);
    return locala2;
  }
  
  public static MMTextView.a fLq()
  {
    return a.a.KsQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.a.a
 * JD-Core Version:    0.7.0.1
 */