package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;

public final class a$b
  implements i<IPCVoid, IPCString>
{
  private static IPCString amf()
  {
    try
    {
      y.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getAccPath task");
      IPCString localIPCString = new IPCString(g.DP().dKt);
      return localIPCString;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", localException, "ipc getAccPath task", new Object[0]);
    }
    return new IPCString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */