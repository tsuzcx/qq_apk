package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.mm.a.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.music.model.e.d;
import com.tencent.mm.sdk.platformtools.y;

public final class a$a
  implements i<IPCString, IPCVoid>
{
  private static IPCVoid a(IPCString paramIPCString)
  {
    try
    {
      y.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc deletePieceMusicInfo Task, musicId:%s", new Object[] { paramIPCString });
      paramIPCString = paramIPCString.value;
      d locald = com.tencent.mm.plugin.music.model.e.bns();
      y.i("MicroMsg.Music.PieceMusicInfoStorage", "deletePieceMusicInfo raw=%d musicId=%s", new Object[] { Integer.valueOf(locald.dXw.delete("PieceMusicInfo", "musicId=?", new String[] { paramIPCString })), paramIPCString });
      locald.mAr.remove(paramIPCString);
      return new IPCVoid();
    }
    catch (Exception paramIPCString)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCString, "ipc deletePieceMusicInfo task", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */