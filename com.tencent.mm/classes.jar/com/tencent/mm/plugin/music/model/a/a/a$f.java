package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class a$f
  implements i<IPCInteger, IPCInteger>
{
  private static IPCInteger b(IPCInteger paramIPCInteger)
  {
    try
    {
      y.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getRemovePlayingAudioPlayerGroupCount task");
      int i = paramIPCInteger.value;
      IPCInteger localIPCInteger = new IPCInteger(((Integer)g.DP().Dz().get(ac.a.uvD, Integer.valueOf(i))).intValue());
      return localIPCInteger;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", localException, "ipc getRemovePlayingAudioPlayerGroupCount task", new Object[0]);
    }
    return new IPCInteger(paramIPCInteger.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */