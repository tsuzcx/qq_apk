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

public final class a$c
  implements i<IPCVoid, IPCLong>
{
  private static IPCLong bVR()
  {
    AppMethodBeat.i(104939);
    try
    {
      ab.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getLastScanMusicPieceFileTime task");
      IPCLong localIPCLong1 = new IPCLong(((Long)g.RL().Ru().get(ac.a.yFG, Long.valueOf(0L))).longValue());
      AppMethodBeat.o(104939);
      return localIPCLong1;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", localException, "ipc getLastScanMusicPieceFileTime task", new Object[0]);
      IPCLong localIPCLong2 = new IPCLong(0L);
      AppMethodBeat.o(104939);
      return localIPCLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */