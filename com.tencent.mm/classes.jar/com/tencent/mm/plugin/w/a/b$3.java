package com.tencent.mm.plugin.w.a;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$3
  extends a.b
{
  b$3(b paramb) {}
  
  protected final Intent cmt()
  {
    AppMethodBeat.i(156001);
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.bbk.launcher2", "com.bbk.launcher2.installshortcut.PurviewActivity"));
    AppMethodBeat.o(156001);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.w.a.b.3
 * JD-Core Version:    0.7.0.1
 */