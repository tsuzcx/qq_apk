package com.tencent.mm.plugin.music.model.a.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamRequest;
import com.tencent.mm.plugin.music.model.e.c;
import com.tencent.mm.plugin.music.model.e.d;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;

public final class a$j
  implements m<IPCAudioParamRequest, IPCVoid>
{
  private static IPCVoid a(IPCAudioParamRequest paramIPCAudioParamRequest)
  {
    boolean bool = true;
    AppMethodBeat.i(63086);
    for (;;)
    {
      try
      {
        Object localObject = paramIPCAudioParamRequest.musicId;
        if (paramIPCAudioParamRequest.oPd == null) {
          continue;
        }
        Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc updateMusicFileIndexBitCache Task, musicId:%s, bitset is valid:%b", new Object[] { localObject, Boolean.valueOf(bool) });
        localObject = paramIPCAudioParamRequest.musicId;
        paramIPCAudioParamRequest = paramIPCAudioParamRequest.oPd;
        d locald = o.goe();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("indexBitData", paramIPCAudioParamRequest);
        int i = locald.db.update("PieceMusicInfo", localContentValues, "musicId=?", new String[] { localObject });
        if (i <= 0) {
          Log.i("MicroMsg.Music.PieceMusicInfoStorage", "updateMusicFileIndexBitCache raw=%d musicId=%s", new Object[] { Integer.valueOf(i), localObject });
        }
        localObject = (c)locald.LNJ.get(localObject);
        if (localObject != null) {
          ((c)localObject).field_indexBitData = paramIPCAudioParamRequest;
        }
      }
      catch (Exception paramIPCAudioParamRequest)
      {
        Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCAudioParamRequest, "ipc updateMusicFileIndexBitCache task", new Object[0]);
        continue;
      }
      paramIPCAudioParamRequest = new IPCVoid();
      AppMethodBeat.o(63086);
      return paramIPCAudioParamRequest;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.j
 * JD-Core Version:    0.7.0.1
 */