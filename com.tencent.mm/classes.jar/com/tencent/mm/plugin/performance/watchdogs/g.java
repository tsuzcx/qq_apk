package com.tencent.mm.plugin.performance.watchdogs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class g
{
  static final class a
  {
    private static List<String> MOY;
    private static List<Integer> MOZ;
    private static List<String> MPa;
    
    static
    {
      AppMethodBeat.i(300984);
      MOY = new ArrayList();
      MOZ = new ArrayList();
      MPa = new ArrayList();
      MOY.add("OnePlus");
      MOZ.add(Integer.valueOf(29));
      MPa.add("audio_mix_threa");
      MPa.add("com.tencent.mm");
      MPa.add("[GT]VideoPlayer");
      MPa.add("AudioTrack");
      AppMethodBeat.o(300984);
    }
  }
  
  static final class b
  {
    private static final String MPb;
    private static final int MPc;
    private static final String MPd;
    private static final List<String> MPe;
    
    static
    {
      AppMethodBeat.i(300986);
      MPe = new ArrayList();
      MPb = "vivo";
      MPc = 29;
      MPd = "CameraJ";
      MPe.add("V2057A");
      MPe.add("V2031EA");
      MPe.add("V2036A");
      MPe.add("V2031A");
      MPe.add("V2061A");
      MPe.add("V2020A");
      MPe.add("V2034A");
      MPe.add("V2020CA");
      MPe.add("vivo 2018");
      MPe.add("vivo 1806");
      MPe.add("V2057A");
      MPe.add("V2031EA");
      MPe.add("V2024A");
      MPe.add("V2099A");
      AppMethodBeat.o(300986);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.g
 * JD-Core Version:    0.7.0.1
 */