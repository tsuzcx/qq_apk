package com.tencent.mm.plugin.profile.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import java.lang.ref.WeakReference;

public final class a
  implements AvatarStorage.a
{
  private WeakReference<AvatarStorage.a> eIW;
  
  public a(AvatarStorage.a parama)
  {
    AppMethodBeat.i(27599);
    this.eIW = new WeakReference(parama);
    AppMethodBeat.o(27599);
  }
  
  public final void LM(String paramString)
  {
    AppMethodBeat.i(27600);
    if (this.eIW.get() != null) {
      ((AvatarStorage.a)this.eIW.get()).LM(paramString);
    }
    AppMethodBeat.o(27600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.a
 * JD-Core Version:    0.7.0.1
 */