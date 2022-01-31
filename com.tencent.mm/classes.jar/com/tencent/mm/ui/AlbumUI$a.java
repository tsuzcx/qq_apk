package com.tencent.mm.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AlbumUI$a
  extends j
{
  public AlbumUI$a(AlbumUI paramAlbumUI, g paramg)
  {
    super(paramg);
  }
  
  public final int getCount()
  {
    return 2;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(29108);
    MMFragment localMMFragment = AlbumUI.a(this.yTx, paramInt);
    AppMethodBeat.o(29108);
    return localMMFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.AlbumUI.a
 * JD-Core Version:    0.7.0.1
 */