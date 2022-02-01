package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.music.model.e.d;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ac;

public final class a$a
  implements k<IPCString, IPCVoid>
{
  private static IPCVoid c(IPCString paramIPCString)
  {
    AppMethodBeat.i(63066);
    try
    {
      ac.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc deletePieceMusicInfo Task, musicId:%s", new Object[] { paramIPCString });
      paramIPCString = paramIPCString.value;
      d locald = com.tencent.mm.plugin.music.model.f.diV();
      ac.i("MicroMsg.Music.PieceMusicInfoStorage", "deletePieceMusicInfo raw=%d musicId=%s", new Object[] { Integer.valueOf(locald.db.delete("PieceMusicInfo", "musicId=?", new String[] { paramIPCString })), paramIPCString });
      locald.vgu.remove(paramIPCString);
      paramIPCString = new IPCVoid();
      AppMethodBeat.o(63066);
      return paramIPCString;
    }
    catch (Exception paramIPCString)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCString, "ipc deletePieceMusicInfo task", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */