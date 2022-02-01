package com.tencent.mm.ui.vas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.pulldown.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@a(32)
@c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/vas/VASCommonForPadActivity;", "Lcom/tencent/mm/ui/vas/VASCommonActivity;", "()V", "TAG", "", "getCreateReplaceId", "", "getLayoutId", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VASCommonForPadActivity
  extends VASCommonActivity
{
  private final String TAG;
  
  public VASCommonForPadActivity()
  {
    AppMethodBeat.i(249913);
    this.TAG = s.X("MicroMsg.VAS.VASCommonForPadActivity@", Integer.valueOf(hashCode()));
    AppMethodBeat.o(249913);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return a.h.activity_common_pad_vas;
  }
  
  public final int jEk()
  {
    return a.g.layout_vas_container_main;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.vas.VASCommonForPadActivity
 * JD-Core Version:    0.7.0.1
 */