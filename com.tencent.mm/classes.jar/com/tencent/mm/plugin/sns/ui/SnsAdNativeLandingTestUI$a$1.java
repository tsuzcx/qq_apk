package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class SnsAdNativeLandingTestUI$a$1
  implements SnsAdNativeLandingTestUI.a.a
{
  SnsAdNativeLandingTestUI$a$1(SnsAdNativeLandingTestUI.a parama, MMHandler paramMMHandler, SnsAdNativeLandingTestUI.a.a parama1) {}
  
  public final void Hn(final String paramString)
  {
    AppMethodBeat.i(98441);
    this.val$handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98438);
        SnsAdNativeLandingTestUI.a.1.this.Ezq.Hn(paramString);
        AppMethodBeat.o(98438);
      }
    });
    AppMethodBeat.o(98441);
  }
  
  public final void aas(final String paramString)
  {
    AppMethodBeat.i(98440);
    this.val$handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98437);
        SnsAdNativeLandingTestUI.a.1.this.Ezq.aas(paramString);
        AppMethodBeat.o(98437);
      }
    });
    AppMethodBeat.o(98440);
  }
  
  public final void dx(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(98439);
    this.val$handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98436);
        SnsAdNativeLandingTestUI.a.1.this.Ezq.dx(paramString, paramInt);
        AppMethodBeat.o(98436);
      }
    });
    AppMethodBeat.o(98439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.a.1
 * JD-Core Version:    0.7.0.1
 */