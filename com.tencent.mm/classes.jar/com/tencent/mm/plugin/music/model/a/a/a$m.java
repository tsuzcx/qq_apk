package com.tencent.mm.plugin.music.model.a.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamRequest;
import com.tencent.mm.plugin.music.model.e.c;
import com.tencent.mm.plugin.music.model.e.d;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;

public final class a$m
  implements k<IPCAudioParamRequest, IPCVoid>
{
  private static IPCVoid a(IPCAudioParamRequest paramIPCAudioParamRequest)
  {
    AppMethodBeat.i(63090);
    try
    {
      ad.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc updateMusicFileCacheComplete Task, musicId:%s, complete:%d", new Object[] { paramIPCAudioParamRequest.dzL, Integer.valueOf(paramIPCAudioParamRequest.wjF) });
      String str = paramIPCAudioParamRequest.dzL;
      int i = paramIPCAudioParamRequest.wjF;
      paramIPCAudioParamRequest = com.tencent.mm.plugin.music.model.f.dth();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("fileCacheComplete", Integer.valueOf(i));
      if (i == 1) {
        localContentValues.put("removeDirtyBit", Integer.valueOf(1));
      }
      ad.i("MicroMsg.Music.PieceMusicInfoStorage", "updateMusicFileCacheComplete raw=%d musicId=%s fileCacheComplete=%d", new Object[] { Integer.valueOf(paramIPCAudioParamRequest.db.update("PieceMusicInfo", localContentValues, "musicId=?", new String[] { str })), str, Integer.valueOf(i) });
      paramIPCAudioParamRequest = (c)paramIPCAudioParamRequest.wlP.get(str);
      if (paramIPCAudioParamRequest != null)
      {
        paramIPCAudioParamRequest.field_fileCacheComplete = i;
        if (i == 1) {
          paramIPCAudioParamRequest.field_removeDirtyBit = 1;
        }
      }
    }
    catch (Exception paramIPCAudioParamRequest)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCAudioParamRequest, "ipc updateMusicFileCacheComplete task", new Object[0]);
      }
    }
    paramIPCAudioParamRequest = new IPCVoid();
    AppMethodBeat.o(63090);
    return paramIPCAudioParamRequest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.m
 * JD-Core Version:    0.7.0.1
 */