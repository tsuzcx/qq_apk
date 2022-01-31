package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class a$i
  implements i<IPCVoid, IPCBoolean>
{
  private static IPCBoolean bnv()
  {
    try
    {
      y.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc showAudioToast");
      IPCBoolean localIPCBoolean = new IPCBoolean(((Boolean)g.DP().Dz().get(ac.a.uvE, Boolean.valueOf(false))).booleanValue());
      return localIPCBoolean;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", localException, "ipc showAudioToast task", new Object[0]);
    }
    return new IPCBoolean(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.i
 * JD-Core Version:    0.7.0.1
 */