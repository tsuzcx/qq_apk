package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.vfs.j;
import com.tencent.mm.vfs.y;
import java.util.Iterator;

final class VideoSegmentUI$8
  implements Runnable
{
  VideoSegmentUI$8(VideoSegmentUI paramVideoSegmentUI, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(94474);
    Object localObject = y.eB(CaptureMMProxy.getInstance().getAccVideoPath(), false);
    if (localObject == null)
    {
      AppMethodBeat.o(94474);
      return;
    }
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      j localj = (j)((Iterator)localObject).next();
      if ((!localj.agxh) && (localj.name != null) && (((localj.name.startsWith("vsg_output_")) && (!localj.name.equals(this.LaH))) || ((localj.name.startsWith("vsg_thumb_")) && (!localj.name.equals(this.LaI))))) {
        localj.NP(true);
      }
    }
    AppMethodBeat.o(94474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.8
 * JD-Core Version:    0.7.0.1
 */