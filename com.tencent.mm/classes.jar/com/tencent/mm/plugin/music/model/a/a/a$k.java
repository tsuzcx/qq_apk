package com.tencent.mm.plugin.music.model.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.music.h.b;
import com.tencent.mm.plugin.music.model.e.c;
import com.tencent.mm.plugin.music.model.e.d;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.sdk.platformtools.Log;

public final class a$k
  implements m<IPCString, IPCString>
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
        Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc updatePieceMusicInfo Task, src:%s", new Object[] { paramIPCString });
        String str1 = paramIPCString.value;
        locald = o.feX();
        if (TextUtils.isEmpty(str1))
        {
          Log.i("MicroMsg.Music.PieceMusicInfoStorage", "updatePieceMusicByUrl url is empty!");
          paramIPCString = null;
          if (paramIPCString == null) {
            break label231;
          }
          paramIPCString = paramIPCString.field_musicId;
          paramIPCString = new IPCString(paramIPCString);
          AppMethodBeat.o(63088);
          return paramIPCString;
        }
        String str2 = b.aSt(str1);
        c localc = locald.aSn(str2);
        paramIPCString = localc;
        if (localc == null)
        {
          paramIPCString = new c();
          i = 0;
        }
        paramIPCString.field_musicId = str2;
        paramIPCString.field_musicUrl = str1;
        paramIPCString.field_fileName = b.aSu(str1);
        Log.i("MicroMsg.Music.PieceMusicInfoStorage", "updatePieceMusicByUrl musicId:%s, field_fileName:%s", new Object[] { str2, paramIPCString.field_fileName });
        if (i != 0)
        {
          Log.i("MicroMsg.Music.PieceMusicInfoStorage", "update PieceMusicInfo");
          locald.update(paramIPCString, new String[0]);
          locald.FSN.put(str2, paramIPCString);
          continue;
        }
        Log.i("MicroMsg.Music.PieceMusicInfoStorage", "insert PieceMusicInfo");
      }
      catch (Exception paramIPCString)
      {
        Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCString, "ipc updatePieceMusicInfo task", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.k
 * JD-Core Version:    0.7.0.1
 */