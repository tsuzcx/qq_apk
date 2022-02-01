package com.tencent.mm.plugin.music.model.a.a;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamRequest;
import com.tencent.mm.plugin.music.model.e.c;
import com.tencent.mm.plugin.music.model.e.d;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ac;

public final class a$i
  implements k<IPCAudioParamRequest, IPCVoid>
{
  private static IPCVoid a(IPCAudioParamRequest paramIPCAudioParamRequest)
  {
    AppMethodBeat.i(63082);
    for (;;)
    {
      try
      {
        ac.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc setMusicMIMETypeByMusicId Task, musicId:%s, mimeType:%s", new Object[] { paramIPCAudioParamRequest.dnX, paramIPCAudioParamRequest.mimeType });
        localObject1 = paramIPCAudioParamRequest.dnX;
        paramIPCAudioParamRequest = paramIPCAudioParamRequest.mimeType;
        localObject2 = com.tencent.mm.plugin.music.model.f.diV().anL((String)localObject1);
        if (localObject2 != null) {
          continue;
        }
        ac.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "setMusicMIMETypeByMusicId pMusic is null!'");
      }
      catch (Exception paramIPCAudioParamRequest)
      {
        Object localObject1;
        Object localObject2;
        ContentValues localContentValues;
        ac.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCAudioParamRequest, "ipc setMusicMIMETypeByMusicId task", new Object[0]);
        continue;
        ac.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "don't need update the piece file mime type");
        continue;
      }
      paramIPCAudioParamRequest = new IPCVoid();
      AppMethodBeat.o(63082);
      return paramIPCAudioParamRequest;
      if ((!TextUtils.isEmpty(((c)localObject2).field_pieceFileMIMEType)) && (((c)localObject2).field_pieceFileMIMEType.equals(paramIPCAudioParamRequest))) {
        continue;
      }
      ac.i("MicroMsg.Music.MusicDataSourceMainProcessImp", "updatePieceFileMIMEType()");
      localObject2 = com.tencent.mm.plugin.music.model.f.diV();
      localContentValues = new ContentValues();
      localContentValues.put("pieceFileMIMEType", paramIPCAudioParamRequest);
      ac.i("MicroMsg.Music.PieceMusicInfoStorage", "updatePieceFileMIMEType raw=%d musicId=%s", new Object[] { Integer.valueOf(((d)localObject2).db.update("PieceMusicInfo", localContentValues, "musicId=?", new String[] { localObject1 })), localObject1 });
      localObject1 = (c)((d)localObject2).vgu.get(localObject1);
      if (localObject1 != null) {
        ((c)localObject1).field_pieceFileMIMEType = paramIPCAudioParamRequest;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.i
 * JD-Core Version:    0.7.0.1
 */