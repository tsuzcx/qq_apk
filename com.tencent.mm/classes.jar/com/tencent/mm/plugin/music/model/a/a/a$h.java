package com.tencent.mm.plugin.music.model.a.a;

import android.content.ContentValues;
import android.text.TextUtils;
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

public final class a$h
  implements m<IPCAudioParamRequest, IPCVoid>
{
  private static IPCVoid a(IPCAudioParamRequest paramIPCAudioParamRequest)
  {
    AppMethodBeat.i(63082);
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc setMusicMIMETypeByMusicId Task, musicId:%s, mimeType:%s", new Object[] { paramIPCAudioParamRequest.fMd, paramIPCAudioParamRequest.mimeType });
        localObject1 = paramIPCAudioParamRequest.fMd;
        paramIPCAudioParamRequest = paramIPCAudioParamRequest.mimeType;
        localObject2 = o.feX().aSn((String)localObject1);
        if (localObject2 != null) {
          continue;
        }
        Log.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "setMusicMIMETypeByMusicId pMusic is null!'");
      }
      catch (Exception paramIPCAudioParamRequest)
      {
        Object localObject1;
        Object localObject2;
        ContentValues localContentValues;
        Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCAudioParamRequest, "ipc setMusicMIMETypeByMusicId task", new Object[0]);
        continue;
        Log.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "don't need update the piece file mime type");
        continue;
      }
      paramIPCAudioParamRequest = new IPCVoid();
      AppMethodBeat.o(63082);
      return paramIPCAudioParamRequest;
      if ((!TextUtils.isEmpty(((c)localObject2).field_pieceFileMIMEType)) && (((c)localObject2).field_pieceFileMIMEType.equals(paramIPCAudioParamRequest))) {
        continue;
      }
      Log.i("MicroMsg.Music.MusicDataSourceMainProcessImp", "updatePieceFileMIMEType()");
      localObject2 = o.feX();
      localContentValues = new ContentValues();
      localContentValues.put("pieceFileMIMEType", paramIPCAudioParamRequest);
      Log.i("MicroMsg.Music.PieceMusicInfoStorage", "updatePieceFileMIMEType raw=%d musicId=%s", new Object[] { Integer.valueOf(((d)localObject2).db.update("PieceMusicInfo", localContentValues, "musicId=?", new String[] { localObject1 })), localObject1 });
      localObject1 = (c)((d)localObject2).FSN.get(localObject1);
      if (localObject1 != null) {
        ((c)localObject1).field_pieceFileMIMEType = paramIPCAudioParamRequest;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.h
 * JD-Core Version:    0.7.0.1
 */