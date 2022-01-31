package com.tencent.mm.ui;

import com.tencent.mm.ah.p;
import com.tencent.mm.as.l;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.y;
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
    return ((Integer)REMOTE_CALL("doFavInMM", new Object[] { paramString })).intValue();
  }
  
  @f
  public int doFavInMM(String paramString)
  {
    cj localcj = new cj();
    ((ad)com.tencent.mm.kernel.g.r(ad.class)).a(localcj, paramString);
    localcj.bIw.bID = 44;
    com.tencent.mm.sdk.b.a.udP.m(localcj);
    y.i("MicroMsg.PhotoEditProxy", "[doFavInMM] path:%s", new Object[] { paramString });
    return localcj.bIx.ret;
  }
  
  public String getFullPath(String paramString)
  {
    return (String)REMOTE_CALL("getFullPathInMM", new Object[] { paramString });
  }
  
  @f
  public String getFullPathInMM(String paramString)
  {
    return o.OJ().getFullPath(paramString);
  }
  
  public String getSelfUsername()
  {
    return (String)REMOTE_CALL("getSelfUsernameInMM", new Object[0]);
  }
  
  @f
  public String getSelfUsernameInMM()
  {
    return q.Gj();
  }
  
  public boolean isAutoSave()
  {
    return ((Boolean)REMOTE_CALL("isAutoSavePhotoInMM", new Object[0])).booleanValue();
  }
  
  @f
  public boolean isAutoSavePhotoInMM()
  {
    return com.tencent.mm.kernel.g.DP().Dz().getBoolean(ac.a.uuF, true);
  }
  
  public void sendImage(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    REMOTE_CALL("sendImageInMM", new Object[] { paramString1, paramString2, paramString3, paramString4 });
  }
  
  @f
  public void sendImageInMM(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString2 = new l(4, paramString3, paramString4, paramString2, 0, null, 0, "", "", true, ag.a.chat_img_template);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.Dk().a(paramString2, 0);
    com.tencent.mm.plugin.messenger.a.g.bhI().dO(paramString1, paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.PhotoEditProxy
 * JD-Core Version:    0.7.0.1
 */