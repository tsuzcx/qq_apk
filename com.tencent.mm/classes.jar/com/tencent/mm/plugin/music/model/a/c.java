package com.tencent.mm.plugin.music.model.a;

import android.content.ContentValues;
import com.tencent.mm.a.f;
import com.tencent.mm.av.h;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCString;
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
import com.tencent.mm.sdk.platformtools.y;

public final class c
  implements com.tencent.mm.plugin.music.cache.c
{
  public final String FU()
  {
    IPCString localIPCString = (IPCString)XIPCInvoker.a("com.tencent.mm", null, a.b.class);
    if (localIPCString == null) {
      return null;
    }
    return localIPCString.value;
  }
  
  public final String Jf(String paramString)
  {
    return b.Jf(paramString);
  }
  
  public final h Jg(String paramString)
  {
    paramString = (IPCAudioParamResponse)XIPCInvoker.a("com.tencent.mm", new IPCString(paramString), a.e.class);
    if (paramString != null)
    {
      h localh = new h();
      localh.bSB = paramString.bSB;
      localh.musicUrl = paramString.musicUrl;
      localh.fileName = paramString.fileName;
      localh.euZ = paramString.euZ;
      localh.eva = paramString.eva;
      localh.euY = paramString.euY;
      return localh;
    }
    return null;
  }
  
  public final String Jh(String paramString)
  {
    IPCString localIPCString = (IPCString)XIPCInvoker.a("com.tencent.mm", new IPCString(paramString), a.k.class);
    if (localIPCString == null) {
      return com.tencent.mm.plugin.music.h.b.JH(paramString);
    }
    return localIPCString.value;
  }
  
  public final void Ji(String paramString)
  {
    XIPCInvoker.a("com.tencent.mm", new IPCString(paramString), a.a.class);
  }
  
  public final String Jj(String paramString)
  {
    paramString = (IPCString)XIPCInvoker.a("com.tencent.mm", new IPCString(paramString), a.d.class);
    if (paramString == null) {
      return null;
    }
    return paramString.value;
  }
  
  public final com.tencent.mm.plugin.music.c.a Jk(String paramString)
  {
    paramString = com.tencent.mm.plugin.music.model.a.a.b.JC(paramString);
    paramString = com.tencent.mm.plugin.music.model.e.bnq().JE(paramString);
    com.tencent.mm.plugin.music.c.a locala = new com.tencent.mm.plugin.music.c.a();
    if (paramString != null)
    {
      locala.myq = paramString.field_wifiDownloadedLength;
      locala.mys = paramString.field_songWifiFileLength;
      locala.myr = paramString.field_wifiEndFlag;
      locala.myo = paramString.field_downloadedLength;
      locala.myp = paramString.field_songFileLength;
      locala.endFlag = paramString.field_endFlag;
      locala.mimeType = paramString.field_mimetype;
    }
    return locala;
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.music.c.a parama)
  {
    paramString = com.tencent.mm.plugin.music.model.a.a.b.JC(paramString);
    Object localObject = com.tencent.mm.plugin.music.model.e.bnq();
    long l = parama.myq;
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("wifiDownloadedLength", Long.valueOf(l));
    y.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiDownloadedLength=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).dXw.update("Music", localContentValues, "musicId=?", new String[] { paramString })), paramString, Long.valueOf(l) });
    localObject = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).mAr.get(paramString);
    if (localObject != null) {
      ((com.tencent.mm.plugin.music.model.e.a)localObject).field_wifiDownloadedLength = l;
    }
    localObject = com.tencent.mm.plugin.music.model.e.bnq();
    int i = parama.myr;
    localContentValues = new ContentValues();
    localContentValues.put("wifiEndFlag", Integer.valueOf(i));
    y.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiEndFlag=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).dXw.update("Music", localContentValues, "musicId=?", new String[] { paramString })), paramString, Integer.valueOf(i) });
    localObject = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).mAr.get(paramString);
    if (localObject != null) {
      ((com.tencent.mm.plugin.music.model.e.a)localObject).field_wifiEndFlag = i;
    }
    localObject = com.tencent.mm.plugin.music.model.e.bnq();
    l = parama.mys;
    localContentValues = new ContentValues();
    localContentValues.put("songWifiFileLength", Long.valueOf(l));
    y.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songWifiFileLength=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).dXw.update("Music", localContentValues, "musicId=?", new String[] { paramString })), paramString, Long.valueOf(l) });
    localObject = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).mAr.get(paramString);
    if (localObject != null) {
      ((com.tencent.mm.plugin.music.model.e.a)localObject).field_songWifiFileLength = l;
    }
    localObject = com.tencent.mm.plugin.music.model.e.bnq();
    l = parama.myo;
    localContentValues = new ContentValues();
    localContentValues.put("downloadedLength", Long.valueOf(l));
    y.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s downloadedLength=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).dXw.update("Music", localContentValues, "musicId=?", new String[] { paramString })), paramString, Long.valueOf(l) });
    localObject = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).mAr.get(paramString);
    if (localObject != null) {
      ((com.tencent.mm.plugin.music.model.e.a)localObject).field_downloadedLength = l;
    }
    localObject = com.tencent.mm.plugin.music.model.e.bnq();
    i = parama.endFlag;
    localContentValues = new ContentValues();
    localContentValues.put("endFlag", Integer.valueOf(i));
    y.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s endFlag=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).dXw.update("Music", localContentValues, "musicId=?", new String[] { paramString })), paramString, Integer.valueOf(i) });
    localObject = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).mAr.get(paramString);
    if (localObject != null) {
      ((com.tencent.mm.plugin.music.model.e.a)localObject).field_endFlag = i;
    }
    localObject = com.tencent.mm.plugin.music.model.e.bnq();
    l = parama.myp;
    parama = new ContentValues();
    parama.put("songFileLength", Long.valueOf(l));
    y.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songFileLength=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.music.model.e.b)localObject).dXw.update("Music", parama, "musicId=?", new String[] { paramString })), paramString, Long.valueOf(l) });
    paramString = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject).mAr.get(paramString);
    if (paramString != null) {
      paramString.field_songFileLength = l;
    }
  }
  
  public final void bZ(String paramString, int paramInt)
  {
    IPCAudioParamRequest localIPCAudioParamRequest = new IPCAudioParamRequest();
    localIPCAudioParamRequest.bSB = paramString;
    localIPCAudioParamRequest.myn = paramInt;
    XIPCInvoker.a("com.tencent.mm", localIPCAudioParamRequest, a.l.class);
  }
  
  public final boolean bmI()
  {
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", null, a.i.class);
    if (localIPCBoolean == null) {
      return false;
    }
    return localIPCBoolean.value;
  }
  
  public final int bmJ()
  {
    IPCInteger localIPCInteger = (IPCInteger)XIPCInvoker.a("com.tencent.mm", new IPCInteger(3), a.f.class);
    if (localIPCInteger == null) {
      return 3;
    }
    return localIPCInteger.value;
  }
  
  public final long bmK()
  {
    IPCLong localIPCLong = (IPCLong)XIPCInvoker.a("com.tencent.mm", null, a.c.class);
    if (localIPCLong == null) {
      return 0L;
    }
    return localIPCLong.value;
  }
  
  public final void eb(String paramString1, String paramString2)
  {
    IPCAudioParamRequest localIPCAudioParamRequest = new IPCAudioParamRequest();
    localIPCAudioParamRequest.bSB = paramString1;
    localIPCAudioParamRequest.mimeType = paramString2;
    XIPCInvoker.a("com.tencent.mm", localIPCAudioParamRequest, a.h.class);
  }
  
  public final void ec(String paramString1, String paramString2)
  {
    paramString1 = com.tencent.mm.plugin.music.model.a.a.b.JC(paramString1);
    com.tencent.mm.plugin.music.model.e.b localb = com.tencent.mm.plugin.music.model.e.bnq();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("mimetype", paramString2);
    localb.dXw.update("Music", localContentValues, "musicId=?", new String[] { paramString1 });
    paramString1 = (com.tencent.mm.plugin.music.model.e.a)localb.mAr.get(paramString1);
    if (paramString1 != null) {
      paramString1.field_mimetype = paramString2;
    }
  }
  
  public final void fk(long paramLong)
  {
    XIPCInvoker.a("com.tencent.mm", new IPCLong(paramLong), a.g.class);
  }
  
  public final void q(String paramString, byte[] paramArrayOfByte)
  {
    IPCAudioParamRequest localIPCAudioParamRequest = new IPCAudioParamRequest();
    localIPCAudioParamRequest.bSB = paramString;
    localIPCAudioParamRequest.euY = paramArrayOfByte;
    XIPCInvoker.a("com.tencent.mm", localIPCAudioParamRequest, a.j.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.c
 * JD-Core Version:    0.7.0.1
 */