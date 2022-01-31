package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.mm.av.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamResponse;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.c;
import com.tencent.mm.plugin.music.model.e.d;
import com.tencent.mm.sdk.platformtools.y;

public final class a$e
  implements i<IPCString, IPCAudioParamResponse>
{
  private static IPCAudioParamResponse c(IPCString paramIPCString)
  {
    try
    {
      y.d("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getPieceMusicInfo Task, src:%s", new Object[] { paramIPCString });
      paramIPCString = paramIPCString.value;
      c localc = e.bns().JF(paramIPCString);
      if (localc == null)
      {
        y.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "initData pMusic is null!'");
        paramIPCString = null;
      }
      while (paramIPCString != null)
      {
        return new IPCAudioParamResponse(paramIPCString);
        paramIPCString = new h();
        paramIPCString.bSB = localc.field_musicId;
        paramIPCString.musicUrl = localc.field_musicUrl;
        paramIPCString.fileName = localc.field_fileName;
        paramIPCString.euZ = localc.field_fileCacheComplete;
        paramIPCString.eva = localc.field_pieceFileMIMEType;
        paramIPCString.euY = localc.field_indexBitData;
      }
      y.e("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "pmInfo is null");
    }
    catch (Exception paramIPCString)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCString, "ipc getPieceMusicInfo task", new Object[0]);
      }
    }
    return new IPCAudioParamResponse();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */