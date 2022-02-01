package com.tencent.mm.plugin.performance.watchdogs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class f
{
  static final class a
  {
    private static List<String> GRA;
    private static List<Integer> GRB;
    private static List<String> GRC;
    
    static
    {
      AppMethodBeat.i(202377);
      GRA = new ArrayList();
      GRB = new ArrayList();
      GRC = new ArrayList();
      GRA.add("OnePlus");
      GRB.add(Integer.valueOf(29));
      GRC.add("audio_mix_threa");
      GRC.add("com.tencent.mm");
      GRC.add("[GT]VideoPlayer");
      GRC.add("AudioTrack");
      AppMethodBeat.o(202377);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.f
 * JD-Core Version:    0.7.0.1
 */