package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class a$h
  implements i<IPCLong, IPCVoid>
{
  private static IPCVoid a(IPCLong paramIPCLong)
  {
    AppMethodBeat.i(104949);
    try
    {
      ab.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc setLastScanMusicPieceFileTime task");
      long l = paramIPCLong.value;
      g.RL().Ru().set(ac.a.yFG, Long.valueOf(l));
      paramIPCLong = new IPCVoid();
      AppMethodBeat.o(104949);
      return paramIPCLong;
    }
    catch (Exception paramIPCLong)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCLong, "ipc setLastScanMusicPieceFileTime task", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.h
 * JD-Core Version:    0.7.0.1
 */