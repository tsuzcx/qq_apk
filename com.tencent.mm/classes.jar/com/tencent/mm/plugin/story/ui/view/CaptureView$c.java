package com.tencent.mm.plugin.story.ui.view;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.a.a;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.c.a.c;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.model.i;
import com.tencent.mm.plugin.story.model.i.a;
import com.tencent.mm.vfs.e;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/CaptureView$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-story_release"})
public final class CaptureView$c
  implements a
{
  public final int Xh()
  {
    AppMethodBeat.i(110299);
    int i = ((c.a)c.srQ.Uw()).eqK;
    AppMethodBeat.o(110299);
    return i;
  }
  
  public final String Xi()
  {
    AppMethodBeat.i(110303);
    Object localObject = i.suJ;
    localObject = i.a.mu(cb.abq());
    AppMethodBeat.o(110303);
    return localObject;
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(110302);
    Object localObject = i.suJ;
    long l = cb.abq();
    e.um(i.cAs());
    localObject = i.cAs() + "record" + l + ".mp4";
    AppMethodBeat.o(110302);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CaptureView.c
 * JD-Core Version:    0.7.0.1
 */