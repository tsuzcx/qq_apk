package com.tencent.mm.plugin.music.model.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.j;
import com.tencent.mm.b.f;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamRequest;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamResponse;
import com.tencent.mm.plugin.music.model.a.a.a.a;
import com.tencent.mm.plugin.music.model.a.a.a.b;
import com.tencent.mm.plugin.music.model.a.a.a.c;
import com.tencent.mm.plugin.music.model.a.a.a.d;
import com.tencent.mm.plugin.music.model.a.a.a.e;
import com.tencent.mm.plugin.music.model.a.a.a.f;
import com.tencent.mm.plugin.music.model.a.a.a.g;
import com.tencent.mm.plugin.music.model.a.a.a.h;
import com.tencent.mm.plugin.music.model.a.a.a.i;
import com.tencent.mm.plugin.music.model.a.a.a.j;
import com.tencent.mm.plugin.music.model.a.a.a.k;
import com.tencent.mm.plugin.music.model.a.a.a.l;
import com.tencent.mm.plugin.music.model.a.a.a.m;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;

public final class c
  implements com.tencent.mm.plugin.music.cache.c
{
  public final void Hn(long paramLong)
  {
    AppMethodBeat.i(63053);
    XIPCInvoker.a(MainProcessIPCService.dkO, new IPCLong(paramLong), a.h.class);
    AppMethodBeat.o(63053);
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.music.c.a parama)
  {
    AppMethodBeat.i(63062);
    paramString = com.tencent.mm.plugin.music.model.a.a.b.aHT(paramString);
    Object localObject = o.euD();
    long l = parama.AiV;
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("wifiDownloadedLength", Long.valueOf(l));
    Log.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiDownloadedLength=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).db.update("Music", localContentValues, "musicId=?", new String[] { paramString })), paramString, Long.valueOf(l) });
    localObject = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).AlG.get(paramString);
    if (localObject != null) {
      ((com.tencent.mm.plugin.music.model.e.a)localObject).field_wifiDownloadedLength = l;
    }
    localObject = o.euD();
    int i = parama.AiW;
    localContentValues = new ContentValues();
    localContentValues.put("wifiEndFlag", Integer.valueOf(i));
    Log.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiEndFlag=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).db.update("Music", localContentValues, "musicId=?", new String[] { paramString })), paramString, Integer.valueOf(i) });
    localObject = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).AlG.get(paramString);
    if (localObject != null) {
      ((com.tencent.mm.plugin.music.model.e.a)localObject).field_wifiEndFlag = i;
    }
    localObject = o.euD();
    l = parama.AiX;
    localContentValues = new ContentValues();
    localContentValues.put("songWifiFileLength", Long.valueOf(l));
    Log.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songWifiFileLength=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).db.update("Music", localContentValues, "musicId=?", new String[] { paramString })), paramString, Long.valueOf(l) });
    localObject = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).AlG.get(paramString);
    if (localObject != null) {
      ((com.tencent.mm.plugin.music.model.e.a)localObject).field_songWifiFileLength = l;
    }
    localObject = o.euD();
    l = parama.AiT;
    localContentValues = new ContentValues();
    localContentValues.put("downloadedLength", Long.valueOf(l));
    Log.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s downloadedLength=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).db.update("Music", localContentValues, "musicId=?", new String[] { paramString })), paramString, Long.valueOf(l) });
    localObject = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).AlG.get(paramString);
    if (localObject != null) {
      ((com.tencent.mm.plugin.music.model.e.a)localObject).field_downloadedLength = l;
    }
    localObject = o.euD();
    i = parama.endFlag;
    localContentValues = new ContentValues();
    localContentValues.put("endFlag", Integer.valueOf(i));
    Log.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s endFlag=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).db.update("Music", localContentValues, "musicId=?", new String[] { paramString })), paramString, Integer.valueOf(i) });
    localObject = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).AlG.get(paramString);
    if (localObject != null) {
      ((com.tencent.mm.plugin.music.model.e.a)localObject).field_endFlag = i;
    }
    localObject = o.euD();
    l = parama.AiU;
    parama = new ContentValues();
    parama.put("songFileLength", Long.valueOf(l));
    Log.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songFileLength=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).db.update("Music", parama, "musicId=?", new String[] { paramString })), paramString, Long.valueOf(l) });
    paramString = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).AlG.get(paramString);
    if (paramString != null) {
      paramString.field_songFileLength = l;
    }
    AppMethodBeat.o(63062);
  }
  
  public final String aHr(String paramString)
  {
    AppMethodBeat.i(63051);
    paramString = b.aHr(paramString);
    AppMethodBeat.o(63051);
    return paramString;
  }
  
  public final j aHs(String paramString)
  {
    AppMethodBeat.i(63054);
    paramString = (IPCAudioParamResponse)XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(paramString), a.e.class);
    if (paramString != null)
    {
      j localj = new j();
      localj.dSF = paramString.dSF;
      localj.musicUrl = paramString.musicUrl;
      localj.fileName = paramString.fileName;
      localj.jfB = paramString.jfB;
      localj.jfC = paramString.jfC;
      localj.jfA = paramString.jfA;
      localj.jfD = paramString.jfD;
      AppMethodBeat.o(63054);
      return localj;
    }
    AppMethodBeat.o(63054);
    return null;
  }
  
  public final String aHt(String paramString)
  {
    AppMethodBeat.i(63055);
    IPCString localIPCString = (IPCString)XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(paramString), a.l.class);
    if (localIPCString == null)
    {
      paramString = com.tencent.mm.plugin.music.h.b.aId(paramString);
      AppMethodBeat.o(63055);
      return paramString;
    }
    paramString = localIPCString.value;
    AppMethodBeat.o(63055);
    return paramString;
  }
  
  public final void aHu(String paramString)
  {
    AppMethodBeat.i(63056);
    XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(paramString), a.a.class);
    AppMethodBeat.o(63056);
  }
  
  public final String aHv(String paramString)
  {
    AppMethodBeat.i(63060);
    paramString = (IPCString)XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(paramString), a.d.class);
    if (paramString == null)
    {
      AppMethodBeat.o(63060);
      return null;
    }
    paramString = paramString.value;
    AppMethodBeat.o(63060);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.music.c.a aHw(String paramString)
  {
    AppMethodBeat.i(63061);
    paramString = com.tencent.mm.plugin.music.model.a.a.b.aHT(paramString);
    paramString = o.euD().aHW(paramString);
    com.tencent.mm.plugin.music.c.a locala = new com.tencent.mm.plugin.music.c.a();
    if (paramString != null)
    {
      locala.AiV = paramString.field_wifiDownloadedLength;
      locala.AiX = paramString.field_songWifiFileLength;
      locala.AiW = paramString.field_wifiEndFlag;
      locala.AiT = paramString.field_downloadedLength;
      locala.AiU = paramString.field_songFileLength;
      locala.endFlag = paramString.field_endFlag;
      locala.mimeType = paramString.field_mimetype;
    }
    AppMethodBeat.o(63061);
    return locala;
  }
  
  public final void eS(String paramString, int paramInt)
  {
    AppMethodBeat.i(63058);
    IPCAudioParamRequest localIPCAudioParamRequest = new IPCAudioParamRequest();
    localIPCAudioParamRequest.dSF = paramString;
    localIPCAudioParamRequest.AiS = paramInt;
    XIPCInvoker.a(MainProcessIPCService.dkO, localIPCAudioParamRequest, a.m.class);
    AppMethodBeat.o(63058);
  }
  
  public final boolean etD()
  {
    AppMethodBeat.i(63048);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.dkO, null, a.j.class);
    if (localIPCBoolean == null)
    {
      AppMethodBeat.o(63048);
      return false;
    }
    boolean bool = localIPCBoolean.value;
    AppMethodBeat.o(63048);
    return bool;
  }
  
  public final int etE()
  {
    AppMethodBeat.i(63049);
    IPCInteger localIPCInteger = (IPCInteger)XIPCInvoker.a(MainProcessIPCService.dkO, new IPCInteger(3), a.f.class);
    if (localIPCInteger == null)
    {
      AppMethodBeat.o(63049);
      return 3;
    }
    int i = localIPCInteger.value;
    AppMethodBeat.o(63049);
    return i;
  }
  
  public final long etF()
  {
    AppMethodBeat.i(63052);
    IPCLong localIPCLong = (IPCLong)XIPCInvoker.a(MainProcessIPCService.dkO, null, a.c.class);
    if (localIPCLong == null)
    {
      AppMethodBeat.o(63052);
      return 0L;
    }
    long l = localIPCLong.value;
    AppMethodBeat.o(63052);
    return l;
  }
  
  public final boolean etG()
  {
    AppMethodBeat.i(63064);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rOk, 0);
    Log.i("MicroMsg.PieceDataSourceService", "open_mix_audio:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(63064);
      return true;
    }
    AppMethodBeat.o(63064);
    return false;
  }
  
  public final boolean etH()
  {
    AppMethodBeat.i(63065);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.dkO, null, a.g.class);
    if (localIPCBoolean == null)
    {
      AppMethodBeat.o(63065);
      return false;
    }
    boolean bool = localIPCBoolean.value;
    AppMethodBeat.o(63065);
    return bool;
  }
  
  public final String getAccPath()
  {
    AppMethodBeat.i(63050);
    Object localObject = (IPCString)XIPCInvoker.a(MainProcessIPCService.dkO, null, a.b.class);
    if (localObject == null)
    {
      AppMethodBeat.o(63050);
      return null;
    }
    localObject = ((IPCString)localObject).value;
    AppMethodBeat.o(63050);
    return localObject;
  }
  
  public final void iU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63059);
    IPCAudioParamRequest localIPCAudioParamRequest = new IPCAudioParamRequest();
    localIPCAudioParamRequest.dSF = paramString1;
    localIPCAudioParamRequest.mimeType = paramString2;
    XIPCInvoker.a(MainProcessIPCService.dkO, localIPCAudioParamRequest, a.i.class);
    AppMethodBeat.o(63059);
  }
  
  public final void iV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63063);
    paramString1 = com.tencent.mm.plugin.music.model.a.a.b.aHT(paramString1);
    com.tencent.mm.plugin.music.model.e.b localb = o.euD();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("mimetype", paramString2);
    localb.db.update("Music", localContentValues, "musicId=?", new String[] { paramString1 });
    paramString1 = (com.tencent.mm.plugin.music.model.e.a)localb.AlG.get(paramString1);
    if (paramString1 != null) {
      paramString1.field_mimetype = paramString2;
    }
    AppMethodBeat.o(63063);
  }
  
  public final void t(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63057);
    IPCAudioParamRequest localIPCAudioParamRequest = new IPCAudioParamRequest();
    localIPCAudioParamRequest.dSF = paramString;
    localIPCAudioParamRequest.jfA = paramArrayOfByte;
    XIPCInvoker.a(MainProcessIPCService.dkO, localIPCAudioParamRequest, a.k.class);
    AppMethodBeat.o(63057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.c
 * JD-Core Version:    0.7.0.1
 */