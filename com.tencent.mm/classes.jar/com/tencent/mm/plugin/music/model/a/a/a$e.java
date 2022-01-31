package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamResponse;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.c;
import com.tencent.mm.plugin.music.model.e.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class a$e
  implements i<IPCString, IPCAudioParamResponse>
{
  private static IPCAudioParamResponse e(IPCString paramIPCString)
  {
    AppMethodBeat.i(104943);
    try
    {
      ab.d("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getPieceMusicInfo Task, src:%s", new Object[] { paramIPCString });
      paramIPCString = paramIPCString.value;
      c localc = e.bVO().VD(paramIPCString);
      if (localc == null)
      {
        ab.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "initData pMusic is null!'");
        paramIPCString = null;
      }
      while (paramIPCString != null)
      {
        paramIPCString = new IPCAudioParamResponse(paramIPCString);
        AppMethodBeat.o(104943);
        return paramIPCString;
        paramIPCString = new h();
        paramIPCString.cAd = localc.field_musicId;
        paramIPCString.musicUrl = localc.field_musicUrl;
        paramIPCString.fileName = localc.field_fileName;
        paramIPCString.fKL = localc.field_fileCacheComplete;
        paramIPCString.fKM = localc.field_pieceFileMIMEType;
        paramIPCString.fKK = localc.field_indexBitData;
        paramIPCString.fKN = localc.field_removeDirtyBit;
      }
      ab.e("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "pmInfo is null");
    }
    catch (Exception paramIPCString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCString, "ipc getPieceMusicInfo task", new Object[0]);
      }
    }
    paramIPCString = new IPCAudioParamResponse();
    AppMethodBeat.o(104943);
    return paramIPCString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */