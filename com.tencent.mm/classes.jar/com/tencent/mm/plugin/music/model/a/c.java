package com.tencent.mm.plugin.music.model.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.i;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
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
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  implements com.tencent.mm.plugin.music.cache.c
{
  public final void a(String paramString, com.tencent.mm.plugin.music.c.a parama)
  {
    AppMethodBeat.i(63062);
    paramString = com.tencent.mm.plugin.music.model.a.a.b.aiM(paramString);
    Object localObject = com.tencent.mm.plugin.music.model.f.cVn();
    long l = parama.tVE;
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("wifiDownloadedLength", Long.valueOf(l));
    ad.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiDownloadedLength=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).db.update("Music", localContentValues, "musicId=?", new String[] { paramString })), paramString, Long.valueOf(l) });
    localObject = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).tXI.get(paramString);
    if (localObject != null) {
      ((com.tencent.mm.plugin.music.model.e.a)localObject).field_wifiDownloadedLength = l;
    }
    localObject = com.tencent.mm.plugin.music.model.f.cVn();
    int i = parama.tVF;
    localContentValues = new ContentValues();
    localContentValues.put("wifiEndFlag", Integer.valueOf(i));
    ad.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiEndFlag=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).db.update("Music", localContentValues, "musicId=?", new String[] { paramString })), paramString, Integer.valueOf(i) });
    localObject = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).tXI.get(paramString);
    if (localObject != null) {
      ((com.tencent.mm.plugin.music.model.e.a)localObject).field_wifiEndFlag = i;
    }
    localObject = com.tencent.mm.plugin.music.model.f.cVn();
    l = parama.tVG;
    localContentValues = new ContentValues();
    localContentValues.put("songWifiFileLength", Long.valueOf(l));
    ad.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songWifiFileLength=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).db.update("Music", localContentValues, "musicId=?", new String[] { paramString })), paramString, Long.valueOf(l) });
    localObject = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).tXI.get(paramString);
    if (localObject != null) {
      ((com.tencent.mm.plugin.music.model.e.a)localObject).field_songWifiFileLength = l;
    }
    localObject = com.tencent.mm.plugin.music.model.f.cVn();
    l = parama.tVC;
    localContentValues = new ContentValues();
    localContentValues.put("downloadedLength", Long.valueOf(l));
    ad.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s downloadedLength=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).db.update("Music", localContentValues, "musicId=?", new String[] { paramString })), paramString, Long.valueOf(l) });
    localObject = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).tXI.get(paramString);
    if (localObject != null) {
      ((com.tencent.mm.plugin.music.model.e.a)localObject).field_downloadedLength = l;
    }
    localObject = com.tencent.mm.plugin.music.model.f.cVn();
    i = parama.endFlag;
    localContentValues = new ContentValues();
    localContentValues.put("endFlag", Integer.valueOf(i));
    ad.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s endFlag=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).db.update("Music", localContentValues, "musicId=?", new String[] { paramString })), paramString, Integer.valueOf(i) });
    localObject = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).tXI.get(paramString);
    if (localObject != null) {
      ((com.tencent.mm.plugin.music.model.e.a)localObject).field_endFlag = i;
    }
    localObject = com.tencent.mm.plugin.music.model.f.cVn();
    l = parama.tVD;
    parama = new ContentValues();
    parama.put("songFileLength", Long.valueOf(l));
    ad.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songFileLength=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).db.update("Music", parama, "musicId=?", new String[] { paramString })), paramString, Long.valueOf(l) });
    paramString = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).tXI.get(paramString);
    if (paramString != null) {
      paramString.field_songFileLength = l;
    }
    AppMethodBeat.o(63062);
  }
  
  public final String aim(String paramString)
  {
    AppMethodBeat.i(63051);
    paramString = b.aim(paramString);
    AppMethodBeat.o(63051);
    return paramString;
  }
  
  public final i ain(String paramString)
  {
    AppMethodBeat.i(63054);
    paramString = (IPCAudioParamResponse)XIPCInvoker.a("com.tencent.mm", new IPCString(paramString), a.e.class);
    if (paramString != null)
    {
      i locali = new i();
      locali.dqm = paramString.dqm;
      locali.musicUrl = paramString.musicUrl;
      locali.fileName = paramString.fileName;
      locali.hnS = paramString.hnS;
      locali.hnT = paramString.hnT;
      locali.hnR = paramString.hnR;
      locali.hnU = paramString.hnU;
      AppMethodBeat.o(63054);
      return locali;
    }
    AppMethodBeat.o(63054);
    return null;
  }
  
  public final String aio(String paramString)
  {
    AppMethodBeat.i(63055);
    IPCString localIPCString = (IPCString)XIPCInvoker.a("com.tencent.mm", new IPCString(paramString), a.l.class);
    if (localIPCString == null)
    {
      paramString = com.tencent.mm.plugin.music.h.b.aiU(paramString);
      AppMethodBeat.o(63055);
      return paramString;
    }
    paramString = localIPCString.value;
    AppMethodBeat.o(63055);
    return paramString;
  }
  
  public final void aip(String paramString)
  {
    AppMethodBeat.i(63056);
    XIPCInvoker.a("com.tencent.mm", new IPCString(paramString), a.a.class);
    AppMethodBeat.o(63056);
  }
  
  public final String aiq(String paramString)
  {
    AppMethodBeat.i(63060);
    paramString = (IPCString)XIPCInvoker.a("com.tencent.mm", new IPCString(paramString), a.d.class);
    if (paramString == null)
    {
      AppMethodBeat.o(63060);
      return null;
    }
    paramString = paramString.value;
    AppMethodBeat.o(63060);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.music.c.a air(String paramString)
  {
    AppMethodBeat.i(63061);
    paramString = com.tencent.mm.plugin.music.model.a.a.b.aiM(paramString);
    paramString = com.tencent.mm.plugin.music.model.f.cVn().aiP(paramString);
    com.tencent.mm.plugin.music.c.a locala = new com.tencent.mm.plugin.music.c.a();
    if (paramString != null)
    {
      locala.tVE = paramString.field_wifiDownloadedLength;
      locala.tVG = paramString.field_songWifiFileLength;
      locala.tVF = paramString.field_wifiEndFlag;
      locala.tVC = paramString.field_downloadedLength;
      locala.tVD = paramString.field_songFileLength;
      locala.endFlag = paramString.field_endFlag;
      locala.mimeType = paramString.field_mimetype;
    }
    AppMethodBeat.o(63061);
    return locala;
  }
  
  public final boolean cUC()
  {
    AppMethodBeat.i(63048);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", null, a.j.class);
    if (localIPCBoolean == null)
    {
      AppMethodBeat.o(63048);
      return false;
    }
    boolean bool = localIPCBoolean.value;
    AppMethodBeat.o(63048);
    return bool;
  }
  
  public final int cUD()
  {
    AppMethodBeat.i(63049);
    IPCInteger localIPCInteger = (IPCInteger)XIPCInvoker.a("com.tencent.mm", new IPCInteger(3), a.f.class);
    if (localIPCInteger == null)
    {
      AppMethodBeat.o(63049);
      return 3;
    }
    int i = localIPCInteger.value;
    AppMethodBeat.o(63049);
    return i;
  }
  
  public final long cUE()
  {
    AppMethodBeat.i(63052);
    IPCLong localIPCLong = (IPCLong)XIPCInvoker.a("com.tencent.mm", null, a.c.class);
    if (localIPCLong == null)
    {
      AppMethodBeat.o(63052);
      return 0L;
    }
    long l = localIPCLong.value;
    AppMethodBeat.o(63052);
    return l;
  }
  
  public final boolean cUF()
  {
    AppMethodBeat.i(63064);
    int i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.piR, 0);
    ad.i("MicroMsg.PieceDataSourceService", "open_mix_audio:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(63064);
      return true;
    }
    AppMethodBeat.o(63064);
    return false;
  }
  
  public final boolean cUG()
  {
    AppMethodBeat.i(63065);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", null, a.g.class);
    if (localIPCBoolean == null)
    {
      AppMethodBeat.o(63065);
      return false;
    }
    boolean bool = localIPCBoolean.value;
    AppMethodBeat.o(63065);
    return bool;
  }
  
  public final void dW(String paramString, int paramInt)
  {
    AppMethodBeat.i(63058);
    IPCAudioParamRequest localIPCAudioParamRequest = new IPCAudioParamRequest();
    localIPCAudioParamRequest.dqm = paramString;
    localIPCAudioParamRequest.tVB = paramInt;
    XIPCInvoker.a("com.tencent.mm", localIPCAudioParamRequest, a.m.class);
    AppMethodBeat.o(63058);
  }
  
  public final String getAccPath()
  {
    AppMethodBeat.i(63050);
    Object localObject = (IPCString)XIPCInvoker.a("com.tencent.mm", null, a.b.class);
    if (localObject == null)
    {
      AppMethodBeat.o(63050);
      return null;
    }
    localObject = ((IPCString)localObject).value;
    AppMethodBeat.o(63050);
    return localObject;
  }
  
  public final void hB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63059);
    IPCAudioParamRequest localIPCAudioParamRequest = new IPCAudioParamRequest();
    localIPCAudioParamRequest.dqm = paramString1;
    localIPCAudioParamRequest.mimeType = paramString2;
    XIPCInvoker.a("com.tencent.mm", localIPCAudioParamRequest, a.i.class);
    AppMethodBeat.o(63059);
  }
  
  public final void hC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63063);
    paramString1 = com.tencent.mm.plugin.music.model.a.a.b.aiM(paramString1);
    com.tencent.mm.plugin.music.model.e.b localb = com.tencent.mm.plugin.music.model.f.cVn();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("mimetype", paramString2);
    localb.db.update("Music", localContentValues, "musicId=?", new String[] { paramString1 });
    paramString1 = (com.tencent.mm.plugin.music.model.e.a)localb.tXI.get(paramString1);
    if (paramString1 != null) {
      paramString1.field_mimetype = paramString2;
    }
    AppMethodBeat.o(63063);
  }
  
  public final void rx(long paramLong)
  {
    AppMethodBeat.i(63053);
    XIPCInvoker.a("com.tencent.mm", new IPCLong(paramLong), a.h.class);
    AppMethodBeat.o(63053);
  }
  
  public final void s(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63057);
    IPCAudioParamRequest localIPCAudioParamRequest = new IPCAudioParamRequest();
    localIPCAudioParamRequest.dqm = paramString;
    localIPCAudioParamRequest.hnR = paramArrayOfByte;
    XIPCInvoker.a("com.tencent.mm", localIPCAudioParamRequest, a.k.class);
    AppMethodBeat.o(63057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.c
 * JD-Core Version:    0.7.0.1
 */