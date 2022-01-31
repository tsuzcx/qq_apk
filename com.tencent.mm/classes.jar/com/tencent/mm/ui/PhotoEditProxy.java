package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.l;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public class PhotoEditProxy
  extends com.tencent.mm.remoteservice.a
{
  public PhotoEditProxy(com.tencent.mm.remoteservice.d paramd)
  {
    super(paramd);
  }
  
  public int doFav(String paramString)
  {
    AppMethodBeat.i(11944);
    int i = ((Integer)REMOTE_CALL("doFavInMM", new Object[] { paramString })).intValue();
    AppMethodBeat.o(11944);
    return i;
  }
  
  @f
  public int doFavInMM(String paramString)
  {
    AppMethodBeat.i(11954);
    cm localcm = new cm();
    ((ad)com.tencent.mm.kernel.g.E(ad.class)).a(localcm, 2, paramString);
    localcm.cpR.cpY = 44;
    com.tencent.mm.sdk.b.a.ymk.l(localcm);
    ab.i("MicroMsg.PhotoEditProxy", "[doFavInMM] path:%s", new Object[] { paramString });
    int i = localcm.cpS.ret;
    AppMethodBeat.o(11954);
    return i;
  }
  
  public String getFullPath(String paramString)
  {
    AppMethodBeat.i(11948);
    paramString = (String)REMOTE_CALL("getFullPathInMM", new Object[] { paramString });
    AppMethodBeat.o(11948);
    return paramString;
  }
  
  @f
  public String getFullPathInMM(String paramString)
  {
    AppMethodBeat.i(11955);
    paramString = com.tencent.mm.at.o.ahC().getFullPath(paramString);
    AppMethodBeat.o(11955);
    return paramString;
  }
  
  public String getSelfUsername()
  {
    AppMethodBeat.i(11947);
    String str = (String)REMOTE_CALL("getSelfUsernameInMM", new Object[0]);
    AppMethodBeat.o(11947);
    return str;
  }
  
  @f
  public String getSelfUsernameInMM()
  {
    AppMethodBeat.i(11952);
    String str = r.Zn();
    AppMethodBeat.o(11952);
    return str;
  }
  
  public boolean isAutoSave()
  {
    AppMethodBeat.i(11946);
    boolean bool = ((Boolean)REMOTE_CALL("isAutoSavePhotoInMM", new Object[0])).booleanValue();
    AppMethodBeat.o(11946);
    return bool;
  }
  
  @f
  public boolean isAutoSavePhotoInMM()
  {
    AppMethodBeat.i(11953);
    boolean bool = com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yEI, true);
    AppMethodBeat.o(11953);
    return bool;
  }
  
  public void recordImage(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    AppMethodBeat.i(11949);
    REMOTE_CALL("recordImageInMM", new Object[] { paramString1, paramString2, Long.valueOf(paramLong), paramString3, paramString4 });
    AppMethodBeat.o(11949);
  }
  
  @f
  public void recordImageInMM(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    AppMethodBeat.i(11956);
    ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.E(com.tencent.mm.api.o.class)).recordImage(paramString1, paramString2, paramLong, paramString3, paramString4);
    AppMethodBeat.o(11956);
  }
  
  public void recordVideo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(11950);
    REMOTE_CALL("recordVideoInMM", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    AppMethodBeat.o(11950);
  }
  
  @f
  public void recordVideoInMM(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(11957);
    ((com.tencent.mm.api.o)com.tencent.mm.kernel.g.E(com.tencent.mm.api.o.class)).recordVideo(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(11957);
  }
  
  public void sendImage(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(11945);
    REMOTE_CALL("sendImageInMM", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    AppMethodBeat.o(11945);
  }
  
  @f
  public void sendImageInMM(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(11951);
    paramString2 = new l(4, paramString3, paramString4, paramString2, 0, null, 0, "", "", true, 2130838228);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.Rc().a(paramString2, 0);
    com.tencent.mm.plugin.messenger.a.g.bPJ().fh(paramString1, paramString4);
    AppMethodBeat.o(11951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.PhotoEditProxy
 * JD-Core Version:    0.7.0.1
 */