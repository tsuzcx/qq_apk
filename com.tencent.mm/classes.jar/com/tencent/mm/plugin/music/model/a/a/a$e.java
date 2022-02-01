package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.j;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamResponse;
import com.tencent.mm.plugin.music.model.e.c;
import com.tencent.mm.plugin.music.model.e.d;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.sdk.platformtools.Log;

public final class a$e
  implements m<IPCString, IPCAudioParamResponse>
{
  private static IPCAudioParamResponse i(IPCString paramIPCString)
  {
    AppMethodBeat.i(63074);
    try
    {
      Log.d("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getPieceMusicInfo Task, src:%s", new Object[] { paramIPCString });
      paramIPCString = paramIPCString.value;
      c localc = o.goe().aPh(paramIPCString);
      if (localc == null)
      {
        Log.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "initData pMusic is null!'");
        paramIPCString = null;
      }
      while (paramIPCString != null)
      {
        paramIPCString = new IPCAudioParamResponse(paramIPCString);
        AppMethodBeat.o(63074);
        return paramIPCString;
        paramIPCString = new j();
        paramIPCString.musicId = localc.field_musicId;
        paramIPCString.musicUrl = localc.field_musicUrl;
        paramIPCString.fileName = localc.field_fileName;
        paramIPCString.oPe = localc.field_fileCacheComplete;
        paramIPCString.oPf = localc.field_pieceFileMIMEType;
        paramIPCString.oPd = localc.field_indexBitData;
        paramIPCString.oPg = localc.field_removeDirtyBit;
      }
      Log.e("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "pmInfo is null");
    }
    catch (Exception paramIPCString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCString, "ipc getPieceMusicInfo task", new Object[0]);
      }
    }
    paramIPCString = new IPCAudioParamResponse();
    AppMethodBeat.o(63074);
    return paramIPCString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */