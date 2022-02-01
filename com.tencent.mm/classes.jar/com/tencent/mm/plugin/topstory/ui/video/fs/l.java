package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eiw;

public final class l
  extends f
{
  public l(Context paramContext)
  {
    super(paramContext);
  }
  
  public final int getLayoutId()
  {
    return 2131496734;
  }
  
  public final void init()
  {
    AppMethodBeat.i(126405);
    super.init();
    findViewById(2131299682).setVisibility(8);
    this.GoL.setVisibility(8);
    this.GoK.setVisibility(8);
    this.GoJ.setVisibility(8);
    findViewById(2131308311).setVisibility(8);
    AppMethodBeat.o(126405);
  }
  
  public final void n(eiw parameiw)
  {
    AppMethodBeat.i(126406);
    super.n(parameiw);
    findViewById(2131299682).setVisibility(8);
    this.GoL.setVisibility(8);
    this.GoK.setVisibility(8);
    this.GoJ.setVisibility(8);
    findViewById(2131308311).setVisibility(8);
    AppMethodBeat.o(126406);
  }
  
  public final void setOnUpdateProgressLenListener(f.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.l
 * JD-Core Version:    0.7.0.1
 */