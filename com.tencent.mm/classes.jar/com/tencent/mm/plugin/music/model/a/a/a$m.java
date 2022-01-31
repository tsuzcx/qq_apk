package com.tencent.mm.plugin.music.model.a.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamRequest;
import com.tencent.mm.plugin.music.model.e.c;
import com.tencent.mm.plugin.music.model.e.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class a$m
  implements i<IPCAudioParamRequest, IPCVoid>
{
  private static IPCVoid a(IPCAudioParamRequest paramIPCAudioParamRequest)
  {
    AppMethodBeat.i(104959);
    try
    {
      ab.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc updateMusicFileCacheComplete Task, musicId:%s, complete:%d", new Object[] { paramIPCAudioParamRequest.cAd, Integer.valueOf(paramIPCAudioParamRequest.oYu) });
      String str = paramIPCAudioParamRequest.cAd;
      int i = paramIPCAudioParamRequest.oYu;
      paramIPCAudioParamRequest = com.tencent.mm.plugin.music.model.e.bVO();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("fileCacheComplete", Integer.valueOf(i));
      if (i == 1) {
        localContentValues.put("removeDirtyBit", Integer.valueOf(1));
      }
      ab.i("MicroMsg.Music.PieceMusicInfoStorage", "updateMusicFileCacheComplete raw=%d musicId=%s fileCacheComplete=%d", new Object[] { Integer.valueOf(paramIPCAudioParamRequest.db.update("PieceMusicInfo", localContentValues, "musicId=?", new String[] { str })), str, Integer.valueOf(i) });
      paramIPCAudioParamRequest = (c)paramIPCAudioParamRequest.pax.get(str);
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
        ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCAudioParamRequest, "ipc updateMusicFileCacheComplete task", new Object[0]);
      }
    }
    paramIPCAudioParamRequest = new IPCVoid();
    AppMethodBeat.o(104959);
    return paramIPCAudioParamRequest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.m
 * JD-Core Version:    0.7.0.1
 */