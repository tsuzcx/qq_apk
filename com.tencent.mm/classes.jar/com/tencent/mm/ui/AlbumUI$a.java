package com.tencent.mm.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AlbumUI$a
  extends p
{
  public AlbumUI$a(AlbumUI paramAlbumUI, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(249077);
    if (AlbumUI.d(this.adue))
    {
      AppMethodBeat.o(249077);
      return 1;
    }
    AppMethodBeat.o(249077);
    return 2;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(249076);
    MMFragment localMMFragment = AlbumUI.a(this.adue, paramInt);
    AppMethodBeat.o(249076);
    return localMMFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.AlbumUI.a
 * JD-Core Version:    0.7.0.1
 */