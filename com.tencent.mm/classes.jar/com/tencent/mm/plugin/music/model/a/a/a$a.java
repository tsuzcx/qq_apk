package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.music.model.e.d;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;

public final class a$a
  implements k<IPCString, IPCVoid>
{
  private static IPCVoid c(IPCString paramIPCString)
  {
    AppMethodBeat.i(63066);
    try
    {
      Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc deletePieceMusicInfo Task, musicId:%s", new Object[] { paramIPCString });
      paramIPCString = paramIPCString.value;
      d locald = o.euE();
      Log.i("MicroMsg.Music.PieceMusicInfoStorage", "deletePieceMusicInfo raw=%d musicId=%s", new Object[] { Integer.valueOf(locald.db.delete("PieceMusicInfo", "musicId=?", new String[] { paramIPCString })), paramIPCString });
      locald.AlG.remove(paramIPCString);
      paramIPCString = new IPCVoid();
      AppMethodBeat.o(63066);
      return paramIPCString;
    }
    catch (Exception paramIPCString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCString, "ipc deletePieceMusicInfo task", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */