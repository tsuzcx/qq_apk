package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.t;
import com.tencent.mm.aw.i;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public class PhotoEditProxy
  extends com.tencent.mm.remoteservice.a
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
    cv localcv = new cv();
    ((com.tencent.mm.plugin.fav.a.ad)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fav.a.ad.class)).a(localcv, 2, paramString);
    localcv.dnG.dnM = 44;
    com.tencent.mm.sdk.b.a.IbL.l(localcv);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.PhotoEditProxy", "[doFavInMM] path:%s", new Object[] { paramString });
    int i = localcv.dnH.ret;
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
    paramString = q.aIF().getFullPath(paramString);
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
    String str = u.aAm();
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
    boolean bool = com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.Ixv, true);
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
    paramString3 = o.a(o.d.ifX).pk(4);
    paramString3.dyU = u.aAm();
    paramString3.toUser = paramString4;
    paramString3.ibF = paramString2;
    paramString3.hZz = 0;
    paramString3.igd = null;
    paramString3.dxr = 0;
    paramString3.hZI = "";
    paramString3.thumbPath = "";
    paramString3.igg = true;
    paramString3.igf = 2131231564;
    paramString3.igc = 11;
    paramString3.aJv().execute();
    com.tencent.mm.plugin.messenger.a.g.dlD().hP(paramString1, paramString4);
    AppMethodBeat.o(103243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.PhotoEditProxy
 * JD-Core Version:    0.7.0.1
 */