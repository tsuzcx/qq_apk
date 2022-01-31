package com.tencent.mm.plugin.music.model.a.a;

import android.text.TextUtils;
import com.tencent.mm.a.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.music.h.b;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.c;
import com.tencent.mm.plugin.music.model.e.d;
import com.tencent.mm.sdk.platformtools.y;

public final class a$k
  implements i<IPCString, IPCString>
{
  private static IPCString b(IPCString paramIPCString)
  {
    int i = 1;
    for (;;)
    {
      d locald;
      try
      {
        y.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc updatePieceMusicInfo Task, src:%s", new Object[] { paramIPCString });
        String str1 = paramIPCString.value;
        locald = e.bns();
        if (TextUtils.isEmpty(str1))
        {
          y.i("MicroMsg.Music.PieceMusicInfoStorage", "updatePieceMusicByUrl url is empty!");
          paramIPCString = null;
          if (paramIPCString == null) {
            break label210;
          }
          paramIPCString = paramIPCString.field_musicId;
          return new IPCString(paramIPCString);
        }
        String str2 = b.JH(str1);
        c localc = locald.JF(str2);
        paramIPCString = localc;
        if (localc == null)
        {
          paramIPCString = new c();
          i = 0;
        }
        paramIPCString.field_musicId = str2;
        paramIPCString.field_musicUrl = str1;
        paramIPCString.field_fileName = b.JI(str1);
        y.i("MicroMsg.Music.PieceMusicInfoStorage", "updatePieceMusicByUrl musicId:%s, field_fileName:%s", new Object[] { str2, paramIPCString.field_fileName });
        if (i != 0)
        {
          y.i("MicroMsg.Music.PieceMusicInfoStorage", "update PieceMusicInfo");
          locald.c(paramIPCString, new String[0]);
          locald.mAr.put(str2, paramIPCString);
          continue;
        }
        y.i("MicroMsg.Music.PieceMusicInfoStorage", "insert PieceMusicInfo");
      }
      catch (Exception paramIPCString)
      {
        y.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCString, "ipc updatePieceMusicInfo task", new Object[0]);
        return new IPCString("");
      }
      locald.b(paramIPCString);
      continue;
      label210:
      paramIPCString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.k
 * JD-Core Version:    0.7.0.1
 */