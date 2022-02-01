package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.api.t;
import com.tencent.mm.aw.l;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public class PhotoEditProxy
  extends com.tencent.mm.remoteservice.a
{
  public PhotoEditProxy(d paramd)
  {
    super(paramd);
  }
  
  public int doFav(String paramString)
  {
    AppMethodBeat.i(103236);
    int i = ((Integer)REMOTE_CALL("doFavInMM", new Object[] { paramString })).intValue();
    AppMethodBeat.o(103236);
    return i;
  }
  
  @f
  public int doFavInMM(String paramString)
  {
    AppMethodBeat.i(103246);
    cs localcs = new cs();
    ((com.tencent.mm.plugin.fav.a.ad)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fav.a.ad.class)).a(localcs, 2, paramString);
    localcs.deQ.deW = 44;
    com.tencent.mm.sdk.b.a.ESL.l(localcs);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PhotoEditProxy", "[doFavInMM] path:%s", new Object[] { paramString });
    int i = localcs.deR.ret;
    AppMethodBeat.o(103246);
    return i;
  }
  
  public String getFullPath(String paramString)
  {
    AppMethodBeat.i(103240);
    paramString = (String)REMOTE_CALL("getFullPathInMM", new Object[] { paramString });
    AppMethodBeat.o(103240);
    return paramString;
  }
  
  @f
  public String getFullPathInMM(String paramString)
  {
    AppMethodBeat.i(103247);
    paramString = o.ayF().getFullPath(paramString);
    AppMethodBeat.o(103247);
    return paramString;
  }
  
  public String getSelfUsername()
  {
    AppMethodBeat.i(103239);
    String str = (String)REMOTE_CALL("getSelfUsernameInMM", new Object[0]);
    AppMethodBeat.o(103239);
    return str;
  }
  
  @f
  public String getSelfUsernameInMM()
  {
    AppMethodBeat.i(103244);
    String str = u.aqG();
    AppMethodBeat.o(103244);
    return str;
  }
  
  public boolean isAutoSave()
  {
    AppMethodBeat.i(103238);
    boolean bool = ((Boolean)REMOTE_CALL("isAutoSavePhotoInMM", new Object[0])).booleanValue();
    AppMethodBeat.o(103238);
    return bool;
  }
  
  @f
  public boolean isAutoSavePhotoInMM()
  {
    AppMethodBeat.i(103245);
    boolean bool = com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.Fno, true);
    AppMethodBeat.o(103245);
    return bool;
  }
  
  public void recordImage(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    AppMethodBeat.i(103241);
    REMOTE_CALL("recordImageInMM", new Object[] { paramString1, paramString2, Long.valueOf(paramLong), paramString3, paramString4 });
    AppMethodBeat.o(103241);
  }
  
  @f
  public void recordImageInMM(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    AppMethodBeat.i(103248);
    ((t)com.tencent.mm.kernel.g.ab(t.class)).recordImage(paramString1, paramString2, paramLong, paramString3, paramString4);
    AppMethodBeat.o(103248);
  }
  
  public void recordVideo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(103242);
    REMOTE_CALL("recordVideoInMM", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    AppMethodBeat.o(103242);
  }
  
  @f
  public void recordVideoInMM(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(103249);
    ((t)com.tencent.mm.kernel.g.ab(t.class)).recordVideo(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(103249);
  }
  
  public void sendImage(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(103237);
    REMOTE_CALL("sendImageInMM", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    AppMethodBeat.o(103237);
  }
  
  @f
  public void sendImageInMM(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(103243);
    paramString2 = new l(4, paramString3, paramString4, paramString2, 0, null, 0, "", "", true, 2131231564);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.aeS().a(paramString2, 0);
    j.cOB().hm(paramString1, paramString4);
    AppMethodBeat.o(103243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.PhotoEditProxy
 * JD-Core Version:    0.7.0.1
 */