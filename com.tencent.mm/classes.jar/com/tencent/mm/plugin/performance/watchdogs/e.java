package com.tencent.mm.plugin.performance.watchdogs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class e
{
  static final class a
  {
    private static List<String> AXL;
    private static List<Integer> AXM;
    private static List<String> AXN;
    
    static
    {
      AppMethodBeat.i(201207);
      AXL = new ArrayList();
      AXM = new ArrayList();
      AXN = new ArrayList();
      AXL.add("OnePlus");
      AXM.add(Integer.valueOf(29));
      AXN.add("audio_mix_threa");
      AXN.add("com.tencent.mm");
      AXN.add("[GT]VideoPlayer");
      AXN.add("AudioTrack");
      AppMethodBeat.o(201207);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.e
 * JD-Core Version:    0.7.0.1
 */