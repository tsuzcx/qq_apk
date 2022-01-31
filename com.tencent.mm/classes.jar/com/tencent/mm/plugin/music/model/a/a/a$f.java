package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class a$f
  implements i<IPCInteger, IPCInteger>
{
  private static IPCInteger b(IPCInteger paramIPCInteger)
  {
    AppMethodBeat.i(104945);
    try
    {
      ab.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getRemovePlayingAudioPlayerGroupCount task");
      int i = paramIPCInteger.value;
      IPCInteger localIPCInteger = new IPCInteger(((Integer)g.RL().Ru().get(ac.a.yFK, Integer.valueOf(i))).intValue());
      AppMethodBeat.o(104945);
      return localIPCInteger;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", localException, "ipc getRemovePlayingAudioPlayerGroupCount task", new Object[0]);
      paramIPCInteger = new IPCInteger(paramIPCInteger.value);
      AppMethodBeat.o(104945);
    }
    return paramIPCInteger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */