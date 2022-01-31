package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckx;

public final class l
  extends f
{
  public l(Context paramContext)
  {
    super(paramContext);
  }
  
  public final int getLayoutId()
  {
    return 2130971012;
  }
  
  public final void init()
  {
    AppMethodBeat.i(141949);
    super.init();
    findViewById(2131821148).setVisibility(8);
    this.tkA.setVisibility(8);
    this.tkz.setVisibility(8);
    this.tky.setVisibility(8);
    findViewById(2131828548).setVisibility(8);
    AppMethodBeat.o(141949);
  }
  
  public final void j(ckx paramckx)
  {
    AppMethodBeat.i(141950);
    super.j(paramckx);
    findViewById(2131821148).setVisibility(8);
    this.tkA.setVisibility(8);
    this.tkz.setVisibility(8);
    this.tky.setVisibility(8);
    findViewById(2131828548).setVisibility(8);
    AppMethodBeat.o(141950);
  }
  
  public final void setOnUpdateProgressLenListener(f.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.l
 * JD-Core Version:    0.7.0.1
 */