package com.tencent.mm.plugin.profile.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import java.lang.ref.WeakReference;

public final class b
  implements MStorageEx.IOnStorageChange
{
  private WeakReference<MStorageEx.IOnStorageChange> eIW;
  
  public b(MStorageEx.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(27601);
    this.eIW = new WeakReference(paramIOnStorageChange);
    AppMethodBeat.o(27601);
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(27602);
    if (this.eIW.get() != null) {
      ((MStorageEx.IOnStorageChange)this.eIW.get()).onNotifyChange(paramInt, paramMStorageEx, paramObject);
    }
    AppMethodBeat.o(27602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.b
 * JD-Core Version:    0.7.0.1
 */