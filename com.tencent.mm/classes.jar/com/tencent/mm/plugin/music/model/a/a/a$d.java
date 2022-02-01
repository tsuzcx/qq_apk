package com.tencent.mm.plugin.music.model.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.music.model.e.c;
import com.tencent.mm.plugin.music.model.e.d;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.sdk.platformtools.Log;

public final class a$d
  implements k<IPCString, IPCString>
{
  private static IPCString d(IPCString paramIPCString)
  {
    AppMethodBeat.i(63072);
    try
    {
      Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getMusicMIMETypeByMusicId Task, musicId:%s", new Object[] { paramIPCString });
      paramIPCString = paramIPCString.value;
      paramIPCString = o.euE().aHX(paramIPCString);
      if (paramIPCString == null)
      {
        Log.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "getMusicMIMETypeByMusicId pMusic is null!'");
        paramIPCString = null;
      }
      for (;;)
      {
        paramIPCString = new IPCString(paramIPCString);
        AppMethodBeat.o(63072);
        return paramIPCString;
        Log.i("MicroMsg.Music.MusicDataSourceMainProcessImp", "music field_pieceFileMIMEType:%s", new Object[] { paramIPCString.field_pieceFileMIMEType });
        if (TextUtils.isEmpty(paramIPCString.field_pieceFileMIMEType))
        {
          Log.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "field_pieceFileMIMEType is null!'");
          paramIPCString = null;
        }
        else
        {
          paramIPCString = paramIPCString.field_pieceFileMIMEType;
        }
      }
      return paramIPCString;
    }
    catch (Exception paramIPCString)
    {
      Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCString, "ipc getMusicMIMETypeByMusicId task", new Object[0]);
      paramIPCString = new IPCString("");
      AppMethodBeat.o(63072);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */