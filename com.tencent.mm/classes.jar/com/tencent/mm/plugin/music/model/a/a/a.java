package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class a
{
  public static final class b
    implements m<IPCVoid, IPCString>
  {
    private static IPCString cBD()
    {
      AppMethodBeat.i(63068);
      try
      {
        Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getAccPath task");
        IPCString localIPCString1 = new IPCString(h.baE().mCJ);
        AppMethodBeat.o(63068);
        return localIPCString1;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", localException, "ipc getAccPath task", new Object[0]);
        IPCString localIPCString2 = new IPCString("");
        AppMethodBeat.o(63068);
        return localIPCString2;
      }
    }
  }
  
  public static final class c
    implements m<IPCVoid, IPCLong>
  {
    private static IPCLong goj()
    {
      AppMethodBeat.i(63070);
      try
      {
        Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getLastScanMusicPieceFileTime task");
        IPCLong localIPCLong1 = new IPCLong(((Long)h.baE().ban().get(at.a.acQM, Long.valueOf(0L))).longValue());
        AppMethodBeat.o(63070);
        return localIPCLong1;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", localException, "ipc getLastScanMusicPieceFileTime task", new Object[0]);
        IPCLong localIPCLong2 = new IPCLong(0L);
        AppMethodBeat.o(63070);
        return localIPCLong2;
      }
    }
  }
  
  public static final class f
    implements m<IPCInteger, IPCInteger>
  {
    private static IPCInteger a(IPCInteger paramIPCInteger)
    {
      AppMethodBeat.i(63076);
      try
      {
        Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getRemovePlayingAudioPlayerGroupCount task");
        int i = paramIPCInteger.value;
        IPCInteger localIPCInteger = new IPCInteger(((Integer)h.baE().ban().get(at.a.acQQ, Integer.valueOf(i))).intValue());
        AppMethodBeat.o(63076);
        return localIPCInteger;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", localException, "ipc getRemovePlayingAudioPlayerGroupCount task", new Object[0]);
        paramIPCInteger = new IPCInteger(paramIPCInteger.value);
        AppMethodBeat.o(63076);
      }
      return paramIPCInteger;
    }
  }
  
  public static final class g
    implements m<IPCLong, IPCVoid>
  {
    private static IPCVoid a(IPCLong paramIPCLong)
    {
      AppMethodBeat.i(63080);
      try
      {
        Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc setLastScanMusicPieceFileTime task");
        long l = paramIPCLong.value;
        h.baE().ban().set(at.a.acQM, Long.valueOf(l));
        paramIPCLong = new IPCVoid();
        AppMethodBeat.o(63080);
        return paramIPCLong;
      }
      catch (Exception paramIPCLong)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", paramIPCLong, "ipc setLastScanMusicPieceFileTime task", new Object[0]);
        }
      }
    }
  }
  
  public static final class i
    implements m<IPCVoid, IPCBoolean>
  {
    private static IPCBoolean bEi()
    {
      AppMethodBeat.i(63084);
      try
      {
        Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc showAudioToast");
        IPCBoolean localIPCBoolean1 = new IPCBoolean(((Boolean)h.baE().ban().get(at.a.acQR, Boolean.FALSE)).booleanValue());
        AppMethodBeat.o(63084);
        return localIPCBoolean1;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", localException, "ipc showAudioToast task", new Object[0]);
        IPCBoolean localIPCBoolean2 = new IPCBoolean(false);
        AppMethodBeat.o(63084);
        return localIPCBoolean2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a.a
 * JD-Core Version:    0.7.0.1
 */