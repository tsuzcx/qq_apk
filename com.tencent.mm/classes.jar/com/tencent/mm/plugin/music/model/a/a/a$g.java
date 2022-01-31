package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class a$g
  implements i<IPCVoid, IPCBoolean>
{
  private static IPCBoolean bVS()
  {
    AppMethodBeat.i(104947);
    try
    {
      ab.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc isSupportMixAudioByCP task");
      IPCBoolean localIPCBoolean1 = new IPCBoolean(((Boolean)g.RL().Ru().get(ac.a.yFM, Boolean.FALSE)).booleanValue());
      AppMethodBeat.o(104947);
      return localIPCBoolean1;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", localException, "ipc isSupportMixAudioByCP task", new Object[0]);
      IPCBoolean localIPCBoolean2 = new IPCBoolean(false);
      AppMethodBeat.o(104947);
      return localIPCBoolean2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.g
 * JD-Core Version:    0.7.0.1
 */