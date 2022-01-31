package com.tencent.mm.ui.chatting.k.a;

import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.widget.MMTextView.a;

public class a
{
  private static volatile a zPP;
  private static final al zPQ;
  
  static
  {
    AppMethodBeat.i(32683);
    zPP = null;
    zPQ = new al();
    AppMethodBeat.o(32683);
  }
  
  public static void a(CharSequence paramCharSequence, bi parambi)
  {
    AppMethodBeat.i(32681);
    a(paramCharSequence, parambi, 1);
    AppMethodBeat.o(32681);
  }
  
  private static void a(CharSequence paramCharSequence, bi parambi, int paramInt)
  {
    AppMethodBeat.i(32680);
    if ((paramCharSequence instanceof Spannable)) {
      zPQ.ac(new a.b(paramCharSequence, parambi, paramInt));
    }
    AppMethodBeat.o(32680);
  }
  
  public static a dLf()
  {
    AppMethodBeat.i(32679);
    if (zPP == null) {
      try
      {
        if (zPP == null) {
          zPP = new a();
        }
        a locala1 = zPP;
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(32679);
      }
    }
    a locala2 = zPP;
    AppMethodBeat.o(32679);
    return locala2;
  }
  
  public static MMTextView.a dLg()
  {
    return a.a.zPR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a.a
 * JD-Core Version:    0.7.0.1
 */