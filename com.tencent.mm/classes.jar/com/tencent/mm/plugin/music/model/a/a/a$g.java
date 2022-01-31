package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class a$g
  implements i<IPCLong, IPCVoid>
{
  private static IPCVoid a(IPCLong paramIPCLong)
  {
    try
    {
      y.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc setLastScanMusicPieceFileTime task");
      long l = paramIPCLong.value;
      g.DP().Dz().c(ac.a.uvz, Long.valueOf(l));
      return new IPCVoid();
    }
    catch (Exception paramIPCLong)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCLong, "ipc setLastScanMusicPieceFileTime task", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.g
 * JD-Core Version:    0.7.0.1
 */