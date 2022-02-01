package com.tencent.mm.plugin.topstory.ui.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.e;
import java.util.Objects;

public final class b
  extends e
{
  public b(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final int cuS()
  {
    return 0;
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(203599);
    Activity localActivity = (Activity)Objects.requireNonNull(super.getActivity());
    AppMethodBeat.o(203599);
    return localActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.b
 * JD-Core Version:    0.7.0.1
 */