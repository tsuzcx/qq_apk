package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.x;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelmulti.t;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.d;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

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
  
  @com.tencent.mm.remoteservice.f
  public int doFavInMM(String paramString)
  {
    AppMethodBeat.i(103246);
    dn localdn = new dn();
    ((af)h.ax(af.class)).a(localdn, 2, paramString);
    localdn.hDr.hDy = 44;
    localdn.publish();
    Log.i("MicroMsg.PhotoEditProxy", "[doFavInMM] path:%s", new Object[] { paramString });
    int i = localdn.hDs.ret;
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
  
  @com.tencent.mm.remoteservice.f
  public String getFullPathInMM(String paramString)
  {
    AppMethodBeat.i(103247);
    paramString = r.bKa().getFullPath(paramString);
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
  
  @com.tencent.mm.remoteservice.f
  public String getSelfUsernameInMM()
  {
    AppMethodBeat.i(103244);
    String str = z.bAM();
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
  
  @com.tencent.mm.remoteservice.f
  public boolean isAutoSavePhotoInMM()
  {
    AppMethodBeat.i(103245);
    boolean bool = h.baE().ban().getBoolean(at.a.acPr, true);
    AppMethodBeat.o(103245);
    return bool;
  }
  
  public void recordImage(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    AppMethodBeat.i(103241);
    REMOTE_CALL("recordImageInMM", new Object[] { paramString1, paramString2, Long.valueOf(paramLong), paramString3, paramString4 });
    AppMethodBeat.o(103241);
  }
  
  @com.tencent.mm.remoteservice.f
  public void recordImageInMM(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    AppMethodBeat.i(103248);
    ((x)h.ax(x.class)).recordImage(paramString1, paramString2, paramLong, paramString3, paramString4);
    AppMethodBeat.o(103248);
  }
  
  public void recordVideo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(103242);
    REMOTE_CALL("recordVideoInMM", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    AppMethodBeat.o(103242);
  }
  
  @com.tencent.mm.remoteservice.f
  public void recordVideoInMM(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(103249);
    ((x)h.ax(x.class)).recordVideo(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(103249);
  }
  
  public void sendImage(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(103237);
    REMOTE_CALL("sendImageInMM", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    AppMethodBeat.o(103237);
  }
  
  @com.tencent.mm.remoteservice.f
  public void sendImageInMM(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(103243);
    paramString3 = t.a(t.d.oNd).wg(4);
    paramString3.hQQ = z.bAM();
    paramString3.toUser = paramString4;
    paramString3.oIx = paramString2;
    paramString3.oGu = 0;
    paramString3.oNk = null;
    paramString3.hOX = 0;
    paramString3.oGC = "";
    paramString3.thumbPath = "";
    paramString3.oNn = true;
    paramString3.oNm = am.c.chat_img_template;
    paramString3.oNj = 11;
    paramString3.bKW().aXz();
    g.gaI().ke(paramString1, paramString4);
    AppMethodBeat.o(103243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.PhotoEditProxy
 * JD-Core Version:    0.7.0.1
 */