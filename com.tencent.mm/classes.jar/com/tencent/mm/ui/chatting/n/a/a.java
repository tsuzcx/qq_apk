package com.tencent.mm.ui.chatting.n.a;

import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.widget.MMTextView.a;

public class a
{
  private static volatile a WZP;
  private static final MMHandler WZQ;
  
  static
  {
    AppMethodBeat.i(36623);
    WZP = null;
    WZQ = new MMHandler("AAChattingHelper");
    AppMethodBeat.o(36623);
  }
  
  private a()
  {
    AppMethodBeat.i(185017);
    WZQ.setLogging(false);
    AppMethodBeat.o(185017);
  }
  
  public static void a(CharSequence paramCharSequence, ca paramca)
  {
    AppMethodBeat.i(36621);
    a(paramCharSequence, paramca, 1);
    AppMethodBeat.o(36621);
  }
  
  private static void a(CharSequence paramCharSequence, ca paramca, int paramInt)
  {
    AppMethodBeat.i(36620);
    if ((paramCharSequence instanceof Spannable)) {
      WZQ.postToWorker(new a.b(paramCharSequence, paramca, paramInt));
    }
    AppMethodBeat.o(36620);
  }
  
  public static a hTq()
  {
    AppMethodBeat.i(36619);
    if (WZP == null) {
      try
      {
        if (WZP == null) {
          WZP = new a();
        }
        a locala1 = WZP;
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(36619);
      }
    }
    a locala2 = WZP;
    AppMethodBeat.o(36619);
    return locala2;
  }
  
  public static MMTextView.a hTr()
  {
    return a.WZR;
  }
  
  static enum a
    implements MMTextView.a
  {
    static
    {
      AppMethodBeat.i(36616);
      WZR = new a("TEXT_CALLBACK");
      WZS = new a[] { WZR };
      AppMethodBeat.o(36616);
    }
    
    private a() {}
    
    public final void a(CharSequence paramCharSequence, long paramLong)
    {
      AppMethodBeat.i(36615);
      ca localca = ((n)h.ae(n.class)).eSe().Oq(paramLong);
      if (Util.isNullOrNil(localca.field_talker))
      {
        Log.w("MicroMsg.AAChattingHelper", "hy: not retrieving correct msg from db. try use old one. msg id: %d", new Object[] { Long.valueOf(paramLong) });
        AppMethodBeat.o(36615);
        return;
      }
      if ((localca.field_flag & 0x10) == 0)
      {
        a.b(paramCharSequence, localca);
        AppMethodBeat.o(36615);
        return;
      }
      Log.v("MicroMsg.AAChattingHelper", "hy: show already checked. msg id is: %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(36615);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.a.a
 * JD-Core Version:    0.7.0.1
 */