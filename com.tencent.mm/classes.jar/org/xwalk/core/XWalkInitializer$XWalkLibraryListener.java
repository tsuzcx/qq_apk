package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

class XWalkInitializer$XWalkLibraryListener
  implements XWalkLibraryLoader.ActivateListener, XWalkLibraryLoader.DecompressListener
{
  private XWalkInitializer$XWalkLibraryListener(XWalkInitializer paramXWalkInitializer) {}
  
  public void onActivateCompleted()
  {
    AppMethodBeat.i(85657);
    XWalkInitializer.access$102(this.this$0, true);
    XWalkLibraryLoader.finishInit(XWalkInitializer.access$200(this.this$0));
    XWalkInitializer.access$000(this.this$0).onXWalkInitCompleted();
    AppMethodBeat.o(85657);
  }
  
  public void onActivateFailed()
  {
    AppMethodBeat.i(85656);
    XWalkInitializer.access$000(this.this$0).onXWalkInitFailed();
    AppMethodBeat.o(85656);
  }
  
  public void onActivateStarted() {}
  
  public void onDecompressCancelled()
  {
    AppMethodBeat.i(85655);
    XWalkInitializer.access$000(this.this$0).onXWalkInitCancelled();
    AppMethodBeat.o(85655);
  }
  
  public void onDecompressCompleted() {}
  
  public void onDecompressStarted() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     org.xwalk.core.XWalkInitializer.XWalkLibraryListener
 * JD-Core Version:    0.7.0.1
 */