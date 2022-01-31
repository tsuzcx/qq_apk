package com.tencent.mm.remoteservice;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  implements Runnable
{
  a$1(a parama, Object[] paramArrayOfObject, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(80216);
    Bundle localBundle = this.yir.objectsToBundle(this.rei);
    a.a(this.yir).a(this.yir, this.uYW, localBundle);
    AppMethodBeat.o(80216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.remoteservice.a.1
 * JD-Core Version:    0.7.0.1
 */