package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class a$c
  implements i<IPCVoid, IPCLong>
{
  private static IPCLong bnu()
  {
    try
    {
      y.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getLastScanMusicPieceFileTime task");
      IPCLong localIPCLong = new IPCLong(((Long)g.DP().Dz().get(ac.a.uvz, Long.valueOf(0L))).longValue());
      return localIPCLong;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", localException, "ipc getLastScanMusicPieceFileTime task", new Object[0]);
    }
    return new IPCLong(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */