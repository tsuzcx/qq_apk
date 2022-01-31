package com.tencent.mm.plugin.music.model.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.aw.h;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamRequest;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamResponse;
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
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  implements com.tencent.mm.plugin.music.cache.c
{
  public final String Vc(String paramString)
  {
    AppMethodBeat.i(104920);
    paramString = b.Vc(paramString);
    AppMethodBeat.o(104920);
    return paramString;
  }
  
  public final h Vd(String paramString)
  {
    AppMethodBeat.i(104923);
    paramString = (IPCAudioParamResponse)XIPCInvoker.a("com.tencent.mm", new IPCString(paramString), a.e.class);
    if (paramString != null)
    {
      h localh = new h();
      localh.cAd = paramString.cAd;
      localh.musicUrl = paramString.musicUrl;
      localh.fileName = paramString.fileName;
      localh.fKL = paramString.fKL;
      localh.fKM = paramString.fKM;
      localh.fKK = paramString.fKK;
      localh.fKN = paramString.fKN;
      AppMethodBeat.o(104923);
      return localh;
    }
    AppMethodBeat.o(104923);
    return null;
  }
  
  public final String Ve(String paramString)
  {
    AppMethodBeat.i(104924);
    IPCString localIPCString = (IPCString)XIPCInvoker.a("com.tencent.mm", new IPCString(paramString), a.l.class);
    if (localIPCString == null)
    {
      paramString = com.tencent.mm.plugin.music.h.b.VH(paramString);
      AppMethodBeat.o(104924);
      return paramString;
    }
    paramString = localIPCString.value;
    AppMethodBeat.o(104924);
    return paramString;
  }
  
  public final void Vf(String paramString)
  {
    AppMethodBeat.i(104925);
    XIPCInvoker.a("com.tencent.mm", new IPCString(paramString), com.tencent.mm.plugin.music.model.a.a.a.a.class);
    AppMethodBeat.o(104925);
  }
  
  public final String Vg(String paramString)
  {
    AppMethodBeat.i(104929);
    paramString = (IPCString)XIPCInvoker.a("com.tencent.mm", new IPCString(paramString), a.d.class);
    if (paramString == null)
    {
      AppMethodBeat.o(104929);
      return null;
    }
    paramString = paramString.value;
    AppMethodBeat.o(104929);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.music.c.a Vh(String paramString)
  {
    AppMethodBeat.i(104930);
    paramString = com.tencent.mm.plugin.music.model.a.a.b.Vz(paramString);
    paramString = com.tencent.mm.plugin.music.model.e.bVM().VC(paramString);
    com.tencent.mm.plugin.music.c.a locala = new com.tencent.mm.plugin.music.c.a();
    if (paramString != null)
    {
      locala.oYx = paramString.field_wifiDownloadedLength;
      locala.oYz = paramString.field_songWifiFileLength;
      locala.oYy = paramString.field_wifiEndFlag;
      locala.oYv = paramString.field_downloadedLength;
      locala.oYw = paramString.field_songFileLength;
      locala.endFlag = paramString.field_endFlag;
      locala.mimeType = paramString.field_mimetype;
    }
    AppMethodBeat.o(104930);
    return locala;
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.music.c.a parama)
  {
    AppMethodBeat.i(104931);
    paramString = com.tencent.mm.plugin.music.model.a.a.b.Vz(paramString);
    Object localObject = com.tencent.mm.plugin.music.model.e.bVM();
    long l = parama.oYx;
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("wifiDownloadedLength", Long.valueOf(l));
    ab.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiDownloadedLength=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).db.update("Music", localContentValues, "musicId=?", new String[] { paramString })), paramString, Long.valueOf(l) });
    localObject = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).pax.get(paramString);
    if (localObject != null) {
      ((com.tencent.mm.plugin.music.model.e.a)localObject).field_wifiDownloadedLength = l;
    }
    localObject = com.tencent.mm.plugin.music.model.e.bVM();
    int i = parama.oYy;
    localContentValues = new ContentValues();
    localContentValues.put("wifiEndFlag", Integer.valueOf(i));
    ab.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiEndFlag=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).db.update("Music", localContentValues, "musicId=?", new String[] { paramString })), paramString, Integer.valueOf(i) });
    localObject = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).pax.get(paramString);
    if (localObject != null) {
      ((com.tencent.mm.plugin.music.model.e.a)localObject).field_wifiEndFlag = i;
    }
    localObject = com.tencent.mm.plugin.music.model.e.bVM();
    l = parama.oYz;
    localContentValues = new ContentValues();
    localContentValues.put("songWifiFileLength", Long.valueOf(l));
    ab.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songWifiFileLength=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).db.update("Music", localContentValues, "musicId=?", new String[] { paramString })), paramString, Long.valueOf(l) });
    localObject = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).pax.get(paramString);
    if (localObject != null) {
      ((com.tencent.mm.plugin.music.model.e.a)localObject).field_songWifiFileLength = l;
    }
    localObject = com.tencent.mm.plugin.music.model.e.bVM();
    l = parama.oYv;
    localContentValues = new ContentValues();
    localContentValues.put("downloadedLength", Long.valueOf(l));
    ab.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s downloadedLength=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).db.update("Music", localContentValues, "musicId=?", new String[] { paramString })), paramString, Long.valueOf(l) });
    localObject = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).pax.get(paramString);
    if (localObject != null) {
      ((com.tencent.mm.plugin.music.model.e.a)localObject).field_downloadedLength = l;
    }
    localObject = com.tencent.mm.plugin.music.model.e.bVM();
    i = parama.endFlag;
    localContentValues = new ContentValues();
    localContentValues.put("endFlag", Integer.valueOf(i));
    ab.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s endFlag=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).db.update("Music", localContentValues, "musicId=?", new String[] { paramString })), paramString, Integer.valueOf(i) });
    localObject = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).pax.get(paramString);
    if (localObject != null) {
      ((com.tencent.mm.plugin.music.model.e.a)localObject).field_endFlag = i;
    }
    localObject = com.tencent.mm.plugin.music.model.e.bVM();
    l = parama.oYw;
    parama = new ContentValues();
    parama.put("songFileLength", Long.valueOf(l));
    ab.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songFileLength=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).db.update("Music", parama, "musicId=?", new String[] { paramString })), paramString, Long.valueOf(l) });
    paramString = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).pax.get(paramString);
    if (paramString != null) {
      paramString.field_songFileLength = l;
    }
    AppMethodBeat.o(104931);
  }
  
  public final boolean bVb()
  {
    AppMethodBeat.i(104917);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", null, a.j.class);
    if (localIPCBoolean == null)
    {
      AppMethodBeat.o(104917);
      return false;
    }
    boolean bool = localIPCBoolean.value;
    AppMethodBeat.o(104917);
    return bool;
  }
  
  public final int bVc()
  {
    AppMethodBeat.i(104918);
    IPCInteger localIPCInteger = (IPCInteger)XIPCInvoker.a("com.tencent.mm", new IPCInteger(3), a.f.class);
    if (localIPCInteger == null)
    {
      AppMethodBeat.o(104918);
      return 3;
    }
    int i = localIPCInteger.value;
    AppMethodBeat.o(104918);
    return i;
  }
  
  public final long bVd()
  {
    AppMethodBeat.i(104921);
    IPCLong localIPCLong = (IPCLong)XIPCInvoker.a("com.tencent.mm", null, a.c.class);
    if (localIPCLong == null)
    {
      AppMethodBeat.o(104921);
      return 0L;
    }
    long l = localIPCLong.value;
    AppMethodBeat.o(104921);
    return l;
  }
  
  public final boolean bVe()
  {
    AppMethodBeat.i(104933);
    int i = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lRE, 0);
    ab.i("MicroMsg.PieceDataSourceService", "open_mix_audio:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(104933);
      return true;
    }
    AppMethodBeat.o(104933);
    return false;
  }
  
  public final boolean bVf()
  {
    AppMethodBeat.i(104934);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", null, a.g.class);
    if (localIPCBoolean == null)
    {
      AppMethodBeat.o(104934);
      return false;
    }
    boolean bool = localIPCBoolean.value;
    AppMethodBeat.o(104934);
    return bool;
  }
  
  public final void cR(String paramString, int paramInt)
  {
    AppMethodBeat.i(104927);
    IPCAudioParamRequest localIPCAudioParamRequest = new IPCAudioParamRequest();
    localIPCAudioParamRequest.cAd = paramString;
    localIPCAudioParamRequest.oYu = paramInt;
    XIPCInvoker.a("com.tencent.mm", localIPCAudioParamRequest, a.m.class);
    AppMethodBeat.o(104927);
  }
  
  public final void fv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104928);
    IPCAudioParamRequest localIPCAudioParamRequest = new IPCAudioParamRequest();
    localIPCAudioParamRequest.cAd = paramString1;
    localIPCAudioParamRequest.mimeType = paramString2;
    XIPCInvoker.a("com.tencent.mm", localIPCAudioParamRequest, a.i.class);
    AppMethodBeat.o(104928);
  }
  
  public final void fw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104932);
    paramString1 = com.tencent.mm.plugin.music.model.a.a.b.Vz(paramString1);
    com.tencent.mm.plugin.music.model.e.b localb = com.tencent.mm.plugin.music.model.e.bVM();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("mimetype", paramString2);
    localb.db.update("Music", localContentValues, "musicId=?", new String[] { paramString1 });
    paramString1 = (com.tencent.mm.plugin.music.model.e.a)localb.pax.get(paramString1);
    if (paramString1 != null) {
      paramString1.field_mimetype = paramString2;
    }
    AppMethodBeat.o(104932);
  }
  
  public final String getAccPath()
  {
    AppMethodBeat.i(104919);
    Object localObject = (IPCString)XIPCInvoker.a("com.tencent.mm", null, a.b.class);
    if (localObject == null)
    {
      AppMethodBeat.o(104919);
      return null;
    }
    localObject = ((IPCString)localObject).value;
    AppMethodBeat.o(104919);
    return localObject;
  }
  
  public final void kI(long paramLong)
  {
    AppMethodBeat.i(104922);
    XIPCInvoker.a("com.tencent.mm", new IPCLong(paramLong), a.h.class);
    AppMethodBeat.o(104922);
  }
  
  public final void y(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104926);
    IPCAudioParamRequest localIPCAudioParamRequest = new IPCAudioParamRequest();
    localIPCAudioParamRequest.cAd = paramString;
    localIPCAudioParamRequest.fKK = paramArrayOfByte;
    XIPCInvoker.a("com.tencent.mm", localIPCAudioParamRequest, a.k.class);
    AppMethodBeat.o(104926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.c
 * JD-Core Version:    0.7.0.1
 */