package com.tencent.mm.ui.e;

import android.graphics.drawable.AnimationDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
  extends AnimationDrawable
{
  private static String TAG = "MMAnimationDrawable";
  
  public final void start()
  {
    AppMethodBeat.i(155823);
    ab.i(TAG, "[start] %s %s", new Object[] { Integer.valueOf(hashCode()), bo.dtY() });
    super.start();
    AppMethodBeat.o(155823);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(155824);
    ab.i(TAG, "[stop] %s %s", new Object[] { Integer.valueOf(hashCode()), bo.dtY() });
    super.stop();
    AppMethodBeat.o(155824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.e.a
 * JD-Core Version:    0.7.0.1
 */