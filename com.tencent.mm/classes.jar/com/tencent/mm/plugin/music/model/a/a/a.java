package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.music.model.e.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  public static final class a
    implements i<IPCString, IPCVoid>
  {
    private static IPCVoid c(IPCString paramIPCString)
    {
      AppMethodBeat.i(104935);
      try
      {
        ab.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc deletePieceMusicInfo Task, musicId:%s", new Object[] { paramIPCString });
        paramIPCString = paramIPCString.value;
        d locald = com.tencent.mm.plugin.music.model.e.bVO();
        ab.i("MicroMsg.Music.PieceMusicInfoStorage", "deletePieceMusicInfo raw=%d musicId=%s", new Object[] { Integer.valueOf(locald.db.delete("PieceMusicInfo", "musicId=?", new String[] { paramIPCString })), paramIPCString });
        locald.pax.remove(paramIPCString);
        paramIPCString = new IPCVoid();
        AppMethodBeat.o(104935);
        return paramIPCString;
      }
      catch (Exception paramIPCString)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCString, "ipc deletePieceMusicInfo task", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a
 * JD-Core Version:    0.7.0.1
 */