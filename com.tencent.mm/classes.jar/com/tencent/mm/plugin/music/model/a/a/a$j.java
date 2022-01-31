package com.tencent.mm.plugin.music.model.a.a;

import android.content.ContentValues;
import com.tencent.mm.a.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamRequest;
import com.tencent.mm.plugin.music.model.e.c;
import com.tencent.mm.plugin.music.model.e.d;
import com.tencent.mm.sdk.platformtools.y;

public final class a$j
  implements i<IPCAudioParamRequest, IPCVoid>
{
  private static IPCVoid a(IPCAudioParamRequest paramIPCAudioParamRequest)
  {
    for (boolean bool = true;; bool = false)
    {
      try
      {
        Object localObject = paramIPCAudioParamRequest.bSB;
        if (paramIPCAudioParamRequest.euY == null) {
          continue;
        }
        y.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc updateMusicFileIndexBitCache Task, musicId:%s, bitset is valid:%b", new Object[] { localObject, Boolean.valueOf(bool) });
        localObject = paramIPCAudioParamRequest.bSB;
        paramIPCAudioParamRequest = paramIPCAudioParamRequest.euY;
        d locald = com.tencent.mm.plugin.music.model.e.bns();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("indexBitData", paramIPCAudioParamRequest);
        int i = locald.dXw.update("PieceMusicInfo", localContentValues, "musicId=?", new String[] { localObject });
        if (i <= 0) {
          y.i("MicroMsg.Music.PieceMusicInfoStorage", "updateMusicFileIndexBitCache raw=%d musicId=%s", new Object[] { Integer.valueOf(i), localObject });
        }
        localObject = (c)locald.mAr.get(localObject);
        if (localObject != null) {
          ((c)localObject).field_indexBitData = paramIPCAudioParamRequest;
        }
      }
      catch (Exception paramIPCAudioParamRequest)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCAudioParamRequest, "ipc updateMusicFileIndexBitCache task", new Object[0]);
        }
      }
      return new IPCVoid();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.j
 * JD-Core Version:    0.7.0.1
 */