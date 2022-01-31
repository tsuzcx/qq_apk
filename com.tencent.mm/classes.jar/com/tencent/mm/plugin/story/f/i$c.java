package com.tencent.mm.plugin.story.f;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/presenter/SelfGalleryPresenter$initLoad$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-story_release"})
public final class i$c
  implements android.support.v7.h.d
{
  i$c(ArrayList paramArrayList) {}
  
  public final void C(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109616);
    ab.i(i.access$getTAG$cp(), "onInserted: " + paramInt1 + ' ' + paramInt2);
    i.a(this.sCh).clear();
    i.a(this.sCh).addAll((Collection)this.sCi);
    this.sCh.sCf.j(0, (List)i.a(this.sCh));
    this.sCh.sCf.cCn();
    this.sCh.sCf.ah(0, paramInt1, paramInt2);
    AppMethodBeat.o(109616);
  }
  
  public final void D(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109617);
    ab.i(i.access$getTAG$cp(), "onRemoved: " + paramInt1 + ' ' + paramInt2);
    i.a(this.sCh).clear();
    i.a(this.sCh).addAll((Collection)this.sCi);
    this.sCh.sCf.j(0, (List)i.a(this.sCh));
    this.sCh.sCf.cCn();
    this.sCh.sCf.ai(0, paramInt1, paramInt2);
    AppMethodBeat.o(109617);
  }
  
  public final void E(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109615);
    ab.i(i.access$getTAG$cp(), "onMoved: " + paramInt1 + ' ' + paramInt2);
    AppMethodBeat.o(109615);
  }
  
  public final void c(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(109614);
    ab.i(i.access$getTAG$cp(), "onChanged: " + paramInt1 + ' ' + paramInt2);
    i.a(this.sCh).clear();
    i.a(this.sCh).addAll((Collection)this.sCi);
    this.sCh.sCf.j(0, (List)i.a(this.sCh));
    this.sCh.sCf.cCn();
    this.sCh.sCf.aj(0, paramInt1, paramInt2);
    AppMethodBeat.o(109614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.i.c
 * JD-Core Version:    0.7.0.1
 */