package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.i;
import java.util.Iterator;

final class VideoSegmentUI$8
  implements Runnable
{
  VideoSegmentUI$8(VideoSegmentUI paramVideoSegmentUI, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(94474);
    Object localObject = i.cZ(CaptureMMProxy.getInstance().getAccVideoPath(), false);
    if (localObject == null)
    {
      AppMethodBeat.o(94474);
      return;
    }
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FileSystem.a locala = (FileSystem.a)((Iterator)localObject).next();
      if ((!locala.Jsg) && (locala.name != null) && (((locala.name.startsWith("vsg_output_")) && (!locala.name.equals(this.uQp))) || ((locala.name.startsWith("vsg_thumb_")) && (!locala.name.equals(this.uQq))))) {
        locala.delete();
      }
    }
    AppMethodBeat.o(94474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.8
 * JD-Core Version:    0.7.0.1
 */