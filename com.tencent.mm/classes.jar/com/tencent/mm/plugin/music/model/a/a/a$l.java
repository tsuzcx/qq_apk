package com.tencent.mm.plugin.music.model.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.music.h.b;
import com.tencent.mm.plugin.music.model.e.c;
import com.tencent.mm.plugin.music.model.e.d;
import com.tencent.mm.sdk.platformtools.ad;

public final class a$l
  implements k<IPCString, IPCString>
{
  private static IPCString d(IPCString paramIPCString)
  {
    int i = 1;
    AppMethodBeat.i(63088);
    for (;;)
    {
      d locald;
      try
      {
        ad.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc updatePieceMusicInfo Task, src:%s", new Object[] { paramIPCString });
        String str1 = paramIPCString.value;
        locald = com.tencent.mm.plugin.music.model.f.cVp();
        if (TextUtils.isEmpty(str1))
        {
          ad.i("MicroMsg.Music.PieceMusicInfoStorage", "updatePieceMusicByUrl url is empty!");
          paramIPCString = null;
          if (paramIPCString == null) {
            break label231;
          }
          paramIPCString = paramIPCString.field_musicId;
          paramIPCString = new IPCString(paramIPCString);
          AppMethodBeat.o(63088);
          return paramIPCString;
        }
        String str2 = b.aiU(str1);
        c localc = locald.aiQ(str2);
        paramIPCString = localc;
        if (localc == null)
        {
          paramIPCString = new c();
          i = 0;
        }
        paramIPCString.field_musicId = str2;
        paramIPCString.field_musicUrl = str1;
        paramIPCString.field_fileName = b.aiV(str1);
        ad.i("MicroMsg.Music.PieceMusicInfoStorage", "updatePieceMusicByUrl musicId:%s, field_fileName:%s", new Object[] { str2, paramIPCString.field_fileName });
        if (i != 0)
        {
          ad.i("MicroMsg.Music.PieceMusicInfoStorage", "update PieceMusicInfo");
          locald.update(paramIPCString, new String[0]);
          locald.tXI.put(str2, paramIPCString);
          continue;
        }
        ad.i("MicroMsg.Music.PieceMusicInfoStorage", "insert PieceMusicInfo");
      }
      catch (Exception paramIPCString)
      {
        ad.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCString, "ipc updatePieceMusicInfo task", new Object[0]);
        paramIPCString = new IPCString("");
        AppMethodBeat.o(63088);
        return paramIPCString;
      }
      locald.insert(paramIPCString);
      continue;
      label231:
      paramIPCString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.l
 * JD-Core Version:    0.7.0.1
 */