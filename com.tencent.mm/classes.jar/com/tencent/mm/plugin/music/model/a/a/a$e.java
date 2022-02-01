package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.i;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamResponse;
import com.tencent.mm.plugin.music.model.e.c;
import com.tencent.mm.plugin.music.model.e.d;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.sdk.platformtools.ac;

public final class a$e
  implements k<IPCString, IPCAudioParamResponse>
{
  private static IPCAudioParamResponse e(IPCString paramIPCString)
  {
    AppMethodBeat.i(63074);
    try
    {
      ac.d("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getPieceMusicInfo Task, src:%s", new Object[] { paramIPCString });
      paramIPCString = paramIPCString.value;
      c localc = f.diV().anL(paramIPCString);
      if (localc == null)
      {
        ac.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "initData pMusic is null!'");
        paramIPCString = null;
      }
      while (paramIPCString != null)
      {
        paramIPCString = new IPCAudioParamResponse(paramIPCString);
        AppMethodBeat.o(63074);
        return paramIPCString;
        paramIPCString = new i();
        paramIPCString.dnX = localc.field_musicId;
        paramIPCString.musicUrl = localc.field_musicUrl;
        paramIPCString.fileName = localc.field_fileName;
        paramIPCString.hOv = localc.field_fileCacheComplete;
        paramIPCString.hOw = localc.field_pieceFileMIMEType;
        paramIPCString.hOu = localc.field_indexBitData;
        paramIPCString.hOx = localc.field_removeDirtyBit;
      }
      ac.e("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "pmInfo is null");
    }
    catch (Exception paramIPCString)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCString, "ipc getPieceMusicInfo task", new Object[0]);
      }
    }
    paramIPCString = new IPCAudioParamResponse();
    AppMethodBeat.o(63074);
    return paramIPCString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */