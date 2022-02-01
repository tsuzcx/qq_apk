package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.i;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamResponse;
import com.tencent.mm.plugin.music.model.e.c;
import com.tencent.mm.plugin.music.model.e.d;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.sdk.platformtools.ad;

public final class a$e
  implements k<IPCString, IPCAudioParamResponse>
{
  private static IPCAudioParamResponse e(IPCString paramIPCString)
  {
    AppMethodBeat.i(63074);
    try
    {
      ad.d("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getPieceMusicInfo Task, src:%s", new Object[] { paramIPCString });
      paramIPCString = paramIPCString.value;
      c localc = f.cVp().aiQ(paramIPCString);
      if (localc == null)
      {
        ad.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "initData pMusic is null!'");
        paramIPCString = null;
      }
      while (paramIPCString != null)
      {
        paramIPCString = new IPCAudioParamResponse(paramIPCString);
        AppMethodBeat.o(63074);
        return paramIPCString;
        paramIPCString = new i();
        paramIPCString.dqm = localc.field_musicId;
        paramIPCString.musicUrl = localc.field_musicUrl;
        paramIPCString.fileName = localc.field_fileName;
        paramIPCString.hnS = localc.field_fileCacheComplete;
        paramIPCString.hnT = localc.field_pieceFileMIMEType;
        paramIPCString.hnR = localc.field_indexBitData;
        paramIPCString.hnU = localc.field_removeDirtyBit;
      }
      ad.e("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "pmInfo is null");
    }
    catch (Exception paramIPCString)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCString, "ipc getPieceMusicInfo task", new Object[0]);
      }
    }
    paramIPCString = new IPCAudioParamResponse();
    AppMethodBeat.o(63074);
    return paramIPCString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */