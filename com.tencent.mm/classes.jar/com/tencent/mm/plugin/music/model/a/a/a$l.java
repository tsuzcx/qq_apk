package com.tencent.mm.plugin.music.model.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.music.h.b;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.c;
import com.tencent.mm.plugin.music.model.e.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class a$l
  implements i<IPCString, IPCString>
{
  private static IPCString d(IPCString paramIPCString)
  {
    int i = 1;
    AppMethodBeat.i(104957);
    for (;;)
    {
      d locald;
      try
      {
        ab.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc updatePieceMusicInfo Task, src:%s", new Object[] { paramIPCString });
        String str1 = paramIPCString.value;
        locald = e.bVO();
        if (TextUtils.isEmpty(str1))
        {
          ab.i("MicroMsg.Music.PieceMusicInfoStorage", "updatePieceMusicByUrl url is empty!");
          paramIPCString = null;
          if (paramIPCString == null) {
            break label231;
          }
          paramIPCString = paramIPCString.field_musicId;
          paramIPCString = new IPCString(paramIPCString);
          AppMethodBeat.o(104957);
          return paramIPCString;
        }
        String str2 = b.VH(str1);
        c localc = locald.VD(str2);
        paramIPCString = localc;
        if (localc == null)
        {
          paramIPCString = new c();
          i = 0;
        }
        paramIPCString.field_musicId = str2;
        paramIPCString.field_musicUrl = str1;
        paramIPCString.field_fileName = b.VI(str1);
        ab.i("MicroMsg.Music.PieceMusicInfoStorage", "updatePieceMusicByUrl musicId:%s, field_fileName:%s", new Object[] { str2, paramIPCString.field_fileName });
        if (i != 0)
        {
          ab.i("MicroMsg.Music.PieceMusicInfoStorage", "update PieceMusicInfo");
          locald.update(paramIPCString, new String[0]);
          locald.pax.put(str2, paramIPCString);
          continue;
        }
        ab.i("MicroMsg.Music.PieceMusicInfoStorage", "insert PieceMusicInfo");
      }
      catch (Exception paramIPCString)
      {
        ab.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCString, "ipc updatePieceMusicInfo task", new Object[0]);
        paramIPCString = new IPCString("");
        AppMethodBeat.o(104957);
        return paramIPCString;
      }
      locald.insert(paramIPCString);
      continue;
      label231:
      paramIPCString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.l
 * JD-Core Version:    0.7.0.1
 */