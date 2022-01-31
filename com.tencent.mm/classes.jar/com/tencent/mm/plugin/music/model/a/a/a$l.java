package com.tencent.mm.plugin.music.model.a.a;

import android.content.ContentValues;
import com.tencent.mm.a.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamRequest;
import com.tencent.mm.plugin.music.model.e.c;
import com.tencent.mm.plugin.music.model.e.d;
import com.tencent.mm.sdk.platformtools.y;

public final class a$l
  implements i<IPCAudioParamRequest, IPCVoid>
{
  private static IPCVoid a(IPCAudioParamRequest paramIPCAudioParamRequest)
  {
    try
    {
      y.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc updateMusicFileCacheComplete Task, musicId:%s, complete:%d", new Object[] { paramIPCAudioParamRequest.bSB, Integer.valueOf(paramIPCAudioParamRequest.myn) });
      String str = paramIPCAudioParamRequest.bSB;
      int i = paramIPCAudioParamRequest.myn;
      paramIPCAudioParamRequest = com.tencent.mm.plugin.music.model.e.bns();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("fileCacheComplete", Integer.valueOf(i));
      y.i("MicroMsg.Music.PieceMusicInfoStorage", "updateMusicFileCacheComplete raw=%d musicId=%s fileCacheComplete=%d", new Object[] { Integer.valueOf(paramIPCAudioParamRequest.dXw.update("PieceMusicInfo", localContentValues, "musicId=?", new String[] { str })), str, Integer.valueOf(i) });
      paramIPCAudioParamRequest = (c)paramIPCAudioParamRequest.mAr.get(str);
      if (paramIPCAudioParamRequest != null) {
        paramIPCAudioParamRequest.field_fileCacheComplete = i;
      }
    }
    catch (Exception paramIPCAudioParamRequest)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCAudioParamRequest, "ipc updateMusicFileCacheComplete task", new Object[0]);
      }
    }
    return new IPCVoid();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.l
 * JD-Core Version:    0.7.0.1
 */