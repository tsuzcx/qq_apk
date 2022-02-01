package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.w;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public class PhotoEditProxy
  extends a
{
  public PhotoEditProxy(com.tencent.mm.remoteservice.d paramd)
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
    cz localcz = new cz();
    ((ad)com.tencent.mm.kernel.g.af(ad.class)).a(localcz, 2, paramString);
    localcz.dFZ.dGf = 44;
    EventCenter.instance.publish(localcz);
    Log.i("MicroMsg.PhotoEditProxy", "[doFavInMM] path:%s", new Object[] { paramString });
    int i = localcz.dGa.ret;
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
    paramString = q.bcR().getFullPath(paramString);
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
    String str = z.aTY();
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
    boolean bool = com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.NZV, true);
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
    ((w)com.tencent.mm.kernel.g.af(w.class)).recordImage(paramString1, paramString2, paramLong, paramString3, paramString4);
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
    ((w)com.tencent.mm.kernel.g.af(w.class)).recordVideo(paramString1, paramString2, paramString3, paramString4);
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
    paramString3 = o.a(o.d.jdL).tc(4);
    paramString3.dRL = z.aTY();
    paramString3.toUser = paramString4;
    paramString3.iZt = paramString2;
    paramString3.iXp = 0;
    paramString3.jdS = null;
    paramString3.dQd = 0;
    paramString3.iXy = "";
    paramString3.thumbPath = "";
    paramString3.jdV = true;
    paramString3.jdU = 2131231628;
    paramString3.jdR = 11;
    paramString3.bdQ().execute();
    com.tencent.mm.plugin.messenger.a.g.eir().iF(paramString1, paramString4);
    AppMethodBeat.o(103243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.PhotoEditProxy
 * JD-Core Version:    0.7.0.1
 */