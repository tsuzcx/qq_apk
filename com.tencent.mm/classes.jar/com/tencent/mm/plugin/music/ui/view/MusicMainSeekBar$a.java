package com.tencent.mm.plugin.music.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar$Companion;", "", "()V", "TAG", "", "timeParse", "duration", "", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMainSeekBar$a
{
  public static String Ey(int paramInt)
  {
    AppMethodBeat.i(271040);
    Object localObject = new StringBuilder();
    long l1 = paramInt / 60000L;
    long l2 = Math.floor(paramInt % 60000L / 1000.0D);
    if (l1 < 10L) {
      ((StringBuilder)localObject).append("0");
    }
    ((StringBuilder)localObject).append(l1 + ':');
    if (l2 < 10L) {
      ((StringBuilder)localObject).append("0");
    }
    ((StringBuilder)localObject).append(l2);
    localObject = ((StringBuilder)localObject).toString();
    s.s(localObject, "time.toString()");
    AppMethodBeat.o(271040);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.MusicMainSeekBar.a
 * JD-Core Version:    0.7.0.1
 */