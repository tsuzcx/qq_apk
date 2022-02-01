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

public final class a$k
  implements k<IPCAudioParamRequest, IPCVoid>
{
  private static IPCVoid a(IPCAudioParamRequest paramIPCAudioParamRequest)
  {
    boolean bool = true;
    AppMethodBeat.i(63086);
    for (;;)
    {
      try
      {
        Object localObject = paramIPCAudioParamRequest.dzL;
        if (paramIPCAudioParamRequest.ihI == null) {
          continue;
        }
        ad.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc updateMusicFileIndexBitCache Task, musicId:%s, bitset is valid:%b", new Object[] { localObject, Boolean.valueOf(bool) });
        localObject = paramIPCAudioParamRequest.dzL;
        paramIPCAudioParamRequest = paramIPCAudioParamRequest.ihI;
        d locald = com.tencent.mm.plugin.music.model.f.dth();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("indexBitData", paramIPCAudioParamRequest);
        int i = locald.db.update("PieceMusicInfo", localContentValues, "musicId=?", new String[] { localObject });
        if (i <= 0) {
          ad.i("MicroMsg.Music.PieceMusicInfoStorage", "updateMusicFileIndexBitCache raw=%d musicId=%s", new Object[] { Integer.valueOf(i), localObject });
        }
        localObject = (c)locald.wlP.get(localObject);
        if (localObject != null) {
          ((c)localObject).field_indexBitData = paramIPCAudioParamRequest;
        }
      }
      catch (Exception paramIPCAudioParamRequest)
      {
        ad.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCAudioParamRequest, "ipc updateMusicFileIndexBitCache task", new Object[0]);
        continue;
      }
      paramIPCAudioParamRequest = new IPCVoid();
      AppMethodBeat.o(63086);
      return paramIPCAudioParamRequest;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.k
 * JD-Core Version:    0.7.0.1
 */