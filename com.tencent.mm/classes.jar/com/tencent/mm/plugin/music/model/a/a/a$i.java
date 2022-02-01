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
import com.tencent.mm.sdk.platformtools.ad;

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
        ad.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc setMusicMIMETypeByMusicId Task, musicId:%s, mimeType:%s", new Object[] { paramIPCAudioParamRequest.dqm, paramIPCAudioParamRequest.mimeType });
        localObject1 = paramIPCAudioParamRequest.dqm;
        paramIPCAudioParamRequest = paramIPCAudioParamRequest.mimeType;
        localObject2 = com.tencent.mm.plugin.music.model.f.cVp().aiQ((String)localObject1);
        if (localObject2 != null) {
          continue;
        }
        ad.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "setMusicMIMETypeByMusicId pMusic is null!'");
      }
      catch (Exception paramIPCAudioParamRequest)
      {
        Object localObject1;
        Object localObject2;
        ContentValues localContentValues;
        ad.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCAudioParamRequest, "ipc setMusicMIMETypeByMusicId task", new Object[0]);
        continue;
        ad.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "don't need update the piece file mime type");
        continue;
      }
      paramIPCAudioParamRequest = new IPCVoid();
      AppMethodBeat.o(63082);
      return paramIPCAudioParamRequest;
      if ((!TextUtils.isEmpty(((c)localObject2).field_pieceFileMIMEType)) && (((c)localObject2).field_pieceFileMIMEType.equals(paramIPCAudioParamRequest))) {
        continue;
      }
      ad.i("MicroMsg.Music.MusicDataSourceMainProcessImp", "updatePieceFileMIMEType()");
      localObject2 = com.tencent.mm.plugin.music.model.f.cVp();
      localContentValues = new ContentValues();
      localContentValues.put("pieceFileMIMEType", paramIPCAudioParamRequest);
      ad.i("MicroMsg.Music.PieceMusicInfoStorage", "updatePieceFileMIMEType raw=%d musicId=%s", new Object[] { Integer.valueOf(((d)localObject2).db.update("PieceMusicInfo", localContentValues, "musicId=?", new String[] { localObject1 })), localObject1 });
      localObject1 = (c)((d)localObject2).tXI.get(localObject1);
      if (localObject1 != null) {
        ((c)localObject1).field_pieceFileMIMEType = paramIPCAudioParamRequest;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.i
 * JD-Core Version:    0.7.0.1
 */