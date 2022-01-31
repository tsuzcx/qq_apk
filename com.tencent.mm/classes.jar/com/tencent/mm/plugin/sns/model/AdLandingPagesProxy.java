package com.tencent.mm.plugin.sns.model;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.rx;
import com.tencent.mm.h.a.ry;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.e.a;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.c;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.SnsTransparentUI;
import com.tencent.mm.protocal.c.asw;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.z;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AdLandingPagesProxy
  extends com.tencent.mm.remoteservice.a
{
  private static AdLandingPagesProxy oon;
  public static AdLandingPagesProxy.b oor = new AdLandingPagesProxy.b();
  private com.tencent.mm.ah.f eeo = new AdLandingPagesProxy.1(this);
  private Map<Long, AdLandingPagesProxy.a> ooo = new HashMap();
  private Map<com.tencent.mm.ah.m, Long> oop = new HashMap();
  private com.tencent.mm.remoteservice.d ooq;
  private Map<Long, a.a> oos = new HashMap();
  private Map<Long, a.a> oot = new HashMap();
  private Map<String, AdLandingPagesProxy.d> oou = new HashMap();
  private b.b oov = new AdLandingPagesProxy.3(this);
  
  public AdLandingPagesProxy(com.tencent.mm.remoteservice.d paramd)
  {
    super(paramd);
    if (paramd == null)
    {
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(1337, this.eeo);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(1210, this.eeo);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(2874, this.eeo);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(2721, this.eeo);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(1802, this.eeo);
      af.bDA().a(this.oov);
    }
    this.ooq = paramd;
  }
  
  private static SharedPreferences bCz()
  {
    return ae.getContext().getSharedPreferences(ae.getPackageName() + "_comm_preferences", 0);
  }
  
  public static void downloadLandingPagesImageMMImpl(String paramString1, String paramString2, String paramString3)
  {
    y.i("AdLandingPagesProxy", "downloadLandingPagesImageMMImpl");
    paramString3 = com.tencent.mm.modelsns.e.a(paramString2, 2, paramString3, paramString3, 1, 1, "");
    com.tencent.mm.plugin.sns.data.e locale = new com.tencent.mm.plugin.sns.data.e(paramString3);
    locale.omU = 3;
    locale.lJQ = paramString3.lsK;
    b localb = af.bDA();
    az localaz = az.cuY();
    localaz.time = ((int)(System.currentTimeMillis() / 1000L));
    localb.a(paramString3, locale, localaz, paramString1, paramString2);
  }
  
  public static AdLandingPagesProxy getInstance()
  {
    if (oon == null) {
      oon = new AdLandingPagesProxy(new com.tencent.mm.remoteservice.d(ae.getContext()));
    }
    return oon;
  }
  
  @com.tencent.mm.remoteservice.e
  public void addCanvasCache(long paramLong, String paramString)
  {
    REMOTE_CALL("addCanvasCacheMM", new Object[] { Long.valueOf(paramLong), paramString });
  }
  
  @com.tencent.mm.remoteservice.f
  public void addCanvasCacheMM(long paramLong, String paramString)
  {
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.bFY().t(paramLong, paramString);
  }
  
  public void addReportInfo(String paramString1, String paramString2, String paramString3)
  {
    REMOTE_CALL("addReportInfoMM", new Object[] { paramString1, paramString2, paramString3 });
  }
  
  @com.tencent.mm.remoteservice.f
  public void addReportInfoMM(String paramString1, String paramString2, String paramString3)
  {
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.c.oBZ;
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      return;
    }
    paramString2 = new a.b(paramString2, paramString3);
    locala.oBX.put(paramString1, paramString2);
  }
  
  @com.tencent.mm.remoteservice.e
  public void asyncCacheXml(String paramString)
  {
    REMOTE_CALL("asyncCacheXmlMM", new Object[] { paramString });
  }
  
  @com.tencent.mm.remoteservice.f
  public void asyncCacheXmlMM(String paramString)
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DS().k(new AdLandingPagesProxy.2(this, paramString), 5000L);
  }
  
  public void clearDownloadCallback()
  {
    this.oou.clear();
  }
  
  public void confirmDialPhoneNum(Activity paramActivity, String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return;
    }
    Intent localIntent = new Intent(ae.getContext(), SnsTransparentUI.class);
    localIntent.putExtra("phoneNum", paramString);
    localIntent.putExtra("op", 4);
    paramActivity.startActivity(localIntent);
  }
  
  public void connect(Runnable paramRunnable)
  {
    this.ooq.connect(paramRunnable);
  }
  
  public int contactGetTypeTextFromUserName(String paramString)
  {
    paramString = REMOTE_CALL("contactGetTypeTextFromUserNameMM", new Object[] { paramString });
    if (paramString == null) {
      return 0;
    }
    return ((Integer)paramString).intValue();
  }
  
  @com.tencent.mm.remoteservice.f
  public int contactGetTypeTextFromUserNameMM(String paramString)
  {
    return s.hW(paramString);
  }
  
  public void deleteDeferredDeepLink(String paramString)
  {
    REMOTE_CALL("deleteDeferredDeepLinkMM", new Object[] { paramString });
  }
  
  @com.tencent.mm.remoteservice.f
  public void deleteDeferredDeepLinkMM(String paramString)
  {
    bCz().edit().remove(paramString).commit();
  }
  
  public void doAdChannelScene(String paramString1, String paramString2, AdLandingPagesProxy.a parama)
  {
    long l = System.currentTimeMillis();
    this.ooo.put(Long.valueOf(l), parama);
    REMOTE_CALL("doAdChannelSceneMM", new Object[] { Long.valueOf(l), paramString1, paramString2 });
  }
  
  @com.tencent.mm.remoteservice.f
  public void doAdChannelSceneMM(long paramLong, String paramString1, String paramString2)
  {
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a(paramString1, paramString2);
    this.oop.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(paramString1, 0);
  }
  
  public void doCgiReportCanvasBrowseInfo(int paramInt, String paramString)
  {
    REMOTE_CALL("doCgiReportCanvasBrowseInfoMM", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  @com.tencent.mm.remoteservice.f
  public void doCgiReportCanvasBrowseInfoMM(int paramInt, String paramString)
  {
    asw localasw = new asw();
    localasw.tou = paramInt;
    localasw.toC = ((int)(System.currentTimeMillis() / 1000L));
    localasw.hPS = 1;
    localasw.tov = new com.tencent.mm.bv.b(paramString.getBytes());
    paramString = new ArrayList();
    paramString.add(localasw);
    paramString = new com.tencent.mm.plugin.sns.a.b.e(paramString);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(paramString, 0);
  }
  
  public void doDynamicUpdateScene(String paramString1, String paramString2, String paramString3, AdLandingPagesProxy.a parama)
  {
    long l = System.currentTimeMillis();
    this.ooo.put(Long.valueOf(l), parama);
    REMOTE_CALL("doDynamicUpdateSceneMM", new Object[] { Long.valueOf(l), paramString1, paramString2, paramString3 });
  }
  
  @com.tencent.mm.remoteservice.f
  public void doDynamicUpdateSceneMM(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c(paramString1, paramString2, paramString3);
    this.oop.put(paramString1, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(paramString1, 0);
  }
  
  public int doFav(Intent paramIntent, int paramInt)
  {
    paramIntent = REMOTE_CALL("doFavMM", new Object[] { paramIntent, Integer.valueOf(paramInt) });
    if (paramIntent == null) {
      return 0;
    }
    return ((Integer)paramIntent).intValue();
  }
  
  public int doFavAdlanding(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, String paramString7, String paramString8)
  {
    paramString1 = REMOTE_CALL("doFavAdlandingMM", new Object[] { Long.valueOf(paramLong), paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, paramString4, paramString5, paramString6, Integer.valueOf(paramInt2), paramString7, paramString8 });
    if (paramString1 == null) {
      return 0;
    }
    return ((Integer)paramString1).intValue();
  }
  
  @com.tencent.mm.remoteservice.f
  public int doFavAdlandingMM(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, String paramString7, String paramString8)
  {
    cj localcj = new cj();
    if ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4) || (paramInt1 == 9) || (paramInt1 == 10) || (paramInt1 == 11)) {
      bk.bl(paramString1);
    }
    ((ad)com.tencent.mm.kernel.g.r(ad.class)).a(localcj, paramString6.hashCode(), com.tencent.mm.model.q.Gj(), paramString4, paramString5, paramString6, paramString7, paramString2);
    paramString1 = u.ij(paramString3);
    localcj.bIw.bIB = paramString1;
    localcj.bIw.title = paramString4;
    localcj.bIw.desc = paramString5;
    paramString1 = localcj.bIw.bIy;
    if ((paramString1 != null) && (paramString1.sXc != null) && (paramString1.sXc.size() > 0) && (paramString1.sXc.get(0) != null))
    {
      ((xv)paramString1.sXc.get(0)).XT(paramString6);
      ((xv)paramString1.sXc.get(0)).Xu(paramString4);
      ((xv)paramString1.sXc.get(0)).Xv(paramString5);
      ((xv)paramString1.sXc.get(0)).XS(paramString8);
    }
    if (paramString1 != null)
    {
      paramString1.Yo(paramString4);
      paramString1.Yp(paramString5);
    }
    localcj.bIw.bID = paramInt2;
    com.tencent.mm.sdk.b.a.udP.m(localcj);
    return localcj.bIw.bIC;
  }
  
  @com.tencent.mm.remoteservice.f
  public int doFavMM(Intent paramIntent, int paramInt)
  {
    cj localcj = new cj();
    ((ad)com.tencent.mm.kernel.g.r(ad.class)).a(localcj, paramIntent);
    localcj.bIw.bID = paramInt;
    com.tencent.mm.sdk.b.a.udP.m(localcj);
    return localcj.bIw.bIC;
  }
  
  public void doFavOfficialItemScene(String paramString, AdLandingPagesProxy.a parama)
  {
    if (bk.bl(paramString))
    {
      y.e("AdLandingPagesProxy", "doFavOfficialItemScene with empty itemBuff, interrupted!");
      return;
    }
    long l = System.currentTimeMillis();
    this.ooo.put(Long.valueOf(l), parama);
    REMOTE_CALL("doFavOfficialItemSceneMM", new Object[] { Long.valueOf(l), paramString });
  }
  
  @com.tencent.mm.remoteservice.f
  public void doFavOfficialItemSceneMM(long paramLong, String paramString)
  {
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b(paramString);
    this.oop.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(paramString, 0);
  }
  
  public void doSearchDynamicUpdateScene(String paramString, AdLandingPagesProxy.a parama)
  {
    long l = System.currentTimeMillis();
    this.ooo.put(Long.valueOf(l), parama);
    REMOTE_CALL("doSearchDynamicUpdateSceneMM", new Object[] { Long.valueOf(l), paramString });
  }
  
  @com.tencent.mm.remoteservice.f
  public void doSearchDynamicUpdateSceneMM(long paramLong, String paramString)
  {
    paramString = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c(paramString);
    this.oop.put(paramString, Long.valueOf(paramLong));
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(paramString, 0);
  }
  
  public void doTransimt(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Intent localIntent = new Intent(ae.getContext(), SnsTransparentUI.class);
    localIntent.putExtra("adlandingXml", paramString1);
    localIntent.putExtra("shareTitle", paramString2);
    localIntent.putExtra("shareThumbUrl", paramString3);
    localIntent.putExtra("shareDesc", paramString4);
    localIntent.putExtra("shareUrl", paramString5);
    localIntent.putExtra("statExtStr", paramString6);
    localIntent.putExtra("op", 2);
    paramActivity.startActivity(localIntent);
  }
  
  @com.tencent.mm.remoteservice.f
  public void doTransimtMM(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void downloadLandingPagesImage(String paramString1, String paramString2, String paramString3, AdLandingPagesProxy.d paramd)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)) || (bk.bl(paramString3)))
    {
      if (paramd != null) {
        paramd.bCF();
      }
      return;
    }
    if (paramd != null) {
      this.oou.put(paramString2, paramd);
    }
    REMOTE_CALL("downloadLandingPagesImageMM", new Object[] { paramString1, paramString2, paramString3 });
  }
  
  @com.tencent.mm.remoteservice.f
  public void downloadLandingPagesImageMM(String paramString1, String paramString2, String paramString3)
  {
    downloadLandingPagesImageMMImpl(paramString1, paramString2, paramString3);
  }
  
  @com.tencent.mm.remoteservice.e
  public void failed(long paramLong)
  {
    a.a locala = (a.a)this.oot.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.bCD();
      this.oot.remove(Long.valueOf(paramLong));
    }
  }
  
  public void favEditTag()
  {
    REMOTE_CALL("favEditTagMM", new Object[0]);
  }
  
  @com.tencent.mm.remoteservice.f
  public void favEditTagMM()
  {
    gf localgf = new gf();
    localgf.bNF.type = 35;
    com.tencent.mm.sdk.b.a.udP.m(localgf);
  }
  
  public String getAccSnsPath()
  {
    return (String)REMOTE_CALL("getAccSnsPathMM", new Object[0]);
  }
  
  @com.tencent.mm.remoteservice.f
  public String getAccSnsPathMM()
  {
    return af.getAccSnsPath();
  }
  
  public int getAdVoteIndex(String paramString1, String paramString2, String paramString3)
  {
    return ((Integer)REMOTE_CALL("getAdVoteIndexMM", new Object[] { paramString1, paramString2, paramString3 })).intValue();
  }
  
  @com.tencent.mm.remoteservice.f
  public int getAdVoteIndexMM(String paramString1, String paramString2, String paramString3)
  {
    return v.ac(paramString1, paramString2, paramString3);
  }
  
  public String getAdVoteInfo(String paramString1, String paramString2, String paramString3)
  {
    return (String)REMOTE_CALL("getAdVoteInfoMM", new Object[] { paramString1, paramString2, paramString3 });
  }
  
  @com.tencent.mm.remoteservice.f
  public String getAdVoteInfoMM(String paramString1, String paramString2, String paramString3)
  {
    return v.ad(paramString1, paramString2, paramString3);
  }
  
  public Object getCfg(int paramInt, Object paramObject)
  {
    Object localObject = REMOTE_CALL("getCfgMM", new Object[] { Integer.valueOf(paramInt), paramObject });
    if (localObject == null) {
      return paramObject;
    }
    return localObject;
  }
  
  @com.tencent.mm.remoteservice.f
  public Object getCfgMM(int paramInt, Object paramObject)
  {
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().Dz().get(paramInt, paramObject);
  }
  
  public String getExpIdByKey(String paramString)
  {
    return (String)REMOTE_CALL("getExpIdByKeyMM", new Object[] { paramString });
  }
  
  @com.tencent.mm.remoteservice.f
  public String getExpIdByKeyMM(String paramString)
  {
    return com.tencent.mm.model.c.c.IY().getExpIdByKey(paramString);
  }
  
  public int getExpValueByKey(String paramString, int paramInt)
  {
    paramString = REMOTE_CALL("getExpValueByKeyMM", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramString == null) {
      return -1;
    }
    return ((Integer)paramString).intValue();
  }
  
  @com.tencent.mm.remoteservice.f
  public int getExpValueByKeyMM(String paramString, int paramInt)
  {
    return com.tencent.mm.model.c.c.IY().dt(paramString, paramInt);
  }
  
  public String getSnsAdCanvasExtXml(String paramString)
  {
    return (String)REMOTE_CALL("getSnsAdCanvasExtXmlMM", new Object[] { paramString });
  }
  
  @com.tencent.mm.remoteservice.f
  public String getSnsAdCanvasExtXmlMM(String paramString)
  {
    paramString = af.bDF().OA(paramString);
    if (paramString != null) {
      return paramString.bGb().oAm;
    }
    return "";
  }
  
  public int getSnsAdType(String paramString)
  {
    return ((Integer)REMOTE_CALL("getSnsAdTypeMM", new Object[] { paramString })).intValue();
  }
  
  @com.tencent.mm.remoteservice.f
  public int getSnsAdTypeMM(String paramString)
  {
    paramString = af.bDF().OA(paramString);
    if (paramString != null) {
      return paramString.bGP();
    }
    return 0;
  }
  
  public String getSnsAid(String paramString)
  {
    return (String)REMOTE_CALL("getSnsAidMM", new Object[] { paramString });
  }
  
  @com.tencent.mm.remoteservice.f
  public String getSnsAidMM(String paramString)
  {
    paramString = af.bDF().OA(paramString);
    if (paramString != null) {
      return paramString.bGJ();
    }
    return "";
  }
  
  public n getSnsInfo(String paramString)
  {
    localn = null;
    try
    {
      paramString = (Bundle)REMOTE_CALL("getSnsInfoMM", new Object[] { paramString });
      if (paramString == null) {
        return null;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject;
        y.printErrStackTrace("AdLandingPagesProxy", paramString, "", new Object[0]);
        paramString = localn;
      }
    }
    localn = new n();
    if (paramString != null)
    {
      localObject = (ContentValues)paramString.getParcelable("values");
      localn.field_snsId = ((ContentValues)localObject).getAsLong("snsId").longValue();
      localn.field_userName = ((ContentValues)localObject).getAsString("userName");
      localn.field_localFlag = ((ContentValues)localObject).getAsInteger("localFlag").intValue();
      localn.field_createTime = ((ContentValues)localObject).getAsInteger("createTime").intValue();
      localn.field_head = ((ContentValues)localObject).getAsInteger("head").intValue();
      localn.field_localPrivate = ((ContentValues)localObject).getAsInteger("localPrivate").intValue();
      localn.field_type = ((ContentValues)localObject).getAsInteger("type").intValue();
      localn.field_sourceType = ((ContentValues)localObject).getAsInteger("sourceType").intValue();
      localn.field_likeFlag = ((ContentValues)localObject).getAsInteger("likeFlag").intValue();
      localn.field_pravited = ((ContentValues)localObject).getAsInteger("pravited").intValue();
      localn.field_stringSeq = ((ContentValues)localObject).getAsString("stringSeq");
      localn.field_content = ((ContentValues)localObject).getAsByteArray("content");
      localn.field_attrBuf = ((ContentValues)localObject).getAsByteArray("attrBuf");
      localn.field_postBuf = ((ContentValues)localObject).getAsByteArray("postBuf");
      localn.field_subType = ((ContentValues)localObject).getAsInteger("subType").intValue();
      if (((ContentValues)localObject).containsKey("rowid")) {
        localn.ujK = ((ContentValues)localObject).getAsLong("rowid").longValue();
      }
      localn.oLk = paramString.getInt("localid");
      paramString = paramString.getBundle("adValues");
      if (paramString != null)
      {
        localObject = new com.tencent.mm.plugin.sns.storage.e();
        ((com.tencent.mm.plugin.sns.storage.e)localObject).D(paramString);
        localn.oLu = ((com.tencent.mm.plugin.sns.storage.e)localObject);
      }
    }
    return localn;
  }
  
  @com.tencent.mm.remoteservice.f
  public Bundle getSnsInfoMM(String paramString)
  {
    paramString = af.bDF().OA(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.bGm();
  }
  
  public String getSnsStatExtBySnsId(long paramLong)
  {
    return (String)REMOTE_CALL("getSnsStatExtBySnsIdMM", new Object[] { Long.valueOf(paramLong) });
  }
  
  @com.tencent.mm.remoteservice.f
  public String getSnsStatExtBySnsIdMM(long paramLong)
  {
    com.tencent.mm.plugin.sns.storage.e locale = af.bDI().gk(paramLong);
    if (locale != null) {
      return com.tencent.mm.plugin.sns.a.b.f.a(locale.bGe());
    }
    y.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", new Object[] { Long.valueOf(paramLong) });
    return "";
  }
  
  public String getSnsTraceid(String paramString)
  {
    return (String)REMOTE_CALL("getSnsTraceidMM", new Object[] { paramString });
  }
  
  @com.tencent.mm.remoteservice.f
  public String getSnsTraceidMM(String paramString)
  {
    paramString = af.bDF().OA(paramString);
    if (paramString != null) {
      return paramString.bGK();
    }
    return "";
  }
  
  public int getTaskProgress(String paramString)
  {
    paramString = REMOTE_CALL("getTaskProgressMM", new Object[] { paramString });
    if (paramString == null) {
      return -1;
    }
    return ((Integer)paramString).intValue();
  }
  
  @com.tencent.mm.remoteservice.f
  public int getTaskProgressMM(String paramString)
  {
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.c.oBZ;
    paramString = com.tencent.mm.plugin.downloader.model.d.aFP().zL(paramString);
    if (paramString.hFz != 0L) {
      return (int)(paramString.iPM * 100L / paramString.hFz);
    }
    return 0;
  }
  
  public String getUin()
  {
    Object localObject = REMOTE_CALL("getUinMM", new Object[0]);
    if (localObject == null) {
      return "";
    }
    return (String)localObject;
  }
  
  @com.tencent.mm.remoteservice.f
  public String getUinMM()
  {
    com.tencent.mm.kernel.g.DN();
    return com.tencent.mm.kernel.a.CL();
  }
  
  public boolean installApp(Context paramContext, String paramString)
  {
    paramContext = REMOTE_CALL("installAppMM", new Object[] { paramString });
    if (paramContext == null) {
      return false;
    }
    return ((Boolean)paramContext).booleanValue();
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean installAppMM(String paramString)
  {
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.c.oBZ;
    Context localContext = ae.getContext();
    if ((localContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return false;
      paramString = com.tencent.mm.plugin.downloader.model.d.aFP().zL(paramString);
    } while ((paramString == null) || (paramString.status != 3) || (TextUtils.isEmpty(paramString.path)));
    Uri localUri = Uri.fromFile(new File(paramString.path));
    locala.N(4, paramString.id);
    return com.tencent.mm.pluginsdk.model.app.q.g(localContext, localUri);
  }
  
  @com.tencent.mm.remoteservice.e
  public boolean isApkExist(String paramString)
  {
    paramString = REMOTE_CALL("isApkExistMM", new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isApkExistMM(String paramString)
  {
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.c.oBZ;
    paramString = com.tencent.mm.plugin.downloader.model.d.aFP().zL(paramString);
    return (paramString != null) && (!TextUtils.isEmpty(paramString.path)) && (com.tencent.mm.vfs.e.bK(paramString.path));
  }
  
  public int isAutoAdDownload()
  {
    Object localObject = REMOTE_CALL("isAutoAdDownloadMM", new Object[0]);
    if (localObject == null) {
      return 0;
    }
    return ((Integer)localObject).intValue();
  }
  
  @com.tencent.mm.remoteservice.f
  public int isAutoAdDownloadMM()
  {
    return af.bDC().b(null, null);
  }
  
  public boolean isConnected()
  {
    if (this.ooq == null) {
      return false;
    }
    return this.ooq.isConnected();
  }
  
  public boolean isDownloading(String paramString)
  {
    paramString = REMOTE_CALL("isDownloadingMM", new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isDownloadingMM(String paramString)
  {
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.c.oBZ;
    paramString = com.tencent.mm.plugin.downloader.model.d.aFP().zL(paramString);
    return (paramString != null) && (paramString.status == 1);
  }
  
  public boolean isPaused(String paramString)
  {
    paramString = REMOTE_CALL("isPausedMM", new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isPausedMM(String paramString)
  {
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.c.oBZ;
    paramString = com.tencent.mm.plugin.downloader.model.d.aFP().zL(paramString);
    return (paramString != null) && (paramString.status == 2);
  }
  
  public boolean isPkgInstalled(String paramString)
  {
    paramString = REMOTE_CALL("isPkgInstalledMM", new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isPkgInstalledMM(String paramString)
  {
    Object localObject = a.c.oBZ;
    localObject = ae.getContext();
    if ((localObject == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    return com.tencent.mm.pluginsdk.model.app.p.o((Context)localObject, paramString);
  }
  
  public boolean isRecExpAd(String paramString)
  {
    paramString = REMOTE_CALL("isRecExpAdMM", new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isRecExpAdMM(String paramString)
  {
    paramString = af.bDF().OA(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.bEQ();
  }
  
  public boolean isUseSnsDownloadImage()
  {
    Object localObject = REMOTE_CALL("isUseSnsDownloadImageMM", new Object[0]);
    if (localObject == null) {
      return false;
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean isUseSnsDownloadImageMM()
  {
    AdLandingPagesProxy.b localb = oor;
    int i;
    if (bk.UZ() - localb.lastUpdateTime > 3600L)
    {
      i = 1;
      if (i != 0) {
        localb.oox = false;
      }
    }
    for (;;)
    {
      try
      {
        if (com.tencent.mm.kernel.g.DK())
        {
          com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100348");
          if (localc.isValid())
          {
            if (bk.getInt((String)localc.ctr().get("downloadMode"), 0) != 1) {
              continue;
            }
            bool = true;
            localb.oox = bool;
          }
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        y.printErrStackTrace("AdLandingPagesProxy", localException, "get abtest failed!", new Object[0]);
        continue;
      }
      localb.lastUpdateTime = bk.UZ();
      return oor.oox;
      i = 0;
      break;
      bool = false;
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void onAdChannelEnd(long paramLong, int paramInt1, int paramInt2, Object paramObject)
  {
    AdLandingPagesProxy.a locala = (AdLandingPagesProxy.a)this.ooo.remove(Long.valueOf(paramLong));
    if (locala != null) {
      locala.e(paramInt1, paramInt2, paramObject);
    }
  }
  
  public void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    y.d("AdLandingPagesProxy", "class:%s, method:%s, clientCall:%B", new Object[] { getClass().getName(), paramString, Boolean.valueOf(paramBoolean) });
    Object localObject2 = null;
    for (;;)
    {
      int i;
      Object localObject1;
      try
      {
        Method[] arrayOfMethod = getClass().getMethods();
        int j = arrayOfMethod.length;
        i = 0;
        localObject1 = localObject2;
        if (i >= j) {
          break label170;
        }
        localObject1 = arrayOfMethod[i];
        if (!((Method)localObject1).getName().equalsIgnoreCase(paramString)) {
          break label187;
        }
      }
      catch (Exception paramString)
      {
        y.e("AdLandingPagesProxy", "exception:%s", new Object[] { bk.j(paramString) });
        return;
      }
      if (((Method)localObject1).isAnnotationPresent(paramString))
      {
        paramString = ((Method)localObject1).invoke(this, getArgs(paramBundle));
        if (((Method)localObject1).getReturnType() != Void.TYPE)
        {
          if ((paramString instanceof Parcelable))
          {
            paramBundle.putParcelable("result_key", (Parcelable)paramString);
            return;
          }
          paramBundle.putSerializable("result_key", (Serializable)paramString);
          return;
          label170:
          if (localObject1 != null)
          {
            if (!paramBoolean) {
              break label196;
            }
            paramString = com.tencent.mm.remoteservice.e.class;
            continue;
          }
        }
      }
      return;
      label187:
      i += 1;
      continue;
      label196:
      paramString = com.tencent.mm.remoteservice.f.class;
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void onDynamicUpdateEnd(long paramLong, String paramString)
  {
    AdLandingPagesProxy.a locala = (AdLandingPagesProxy.a)this.ooo.remove(Long.valueOf(paramLong));
    if ((locala != null) && (!bk.bl(paramString))) {
      locala.U(paramString);
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void onFavOfficialItemEnd(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    AdLandingPagesProxy.a locala = (AdLandingPagesProxy.a)this.ooo.remove(Long.valueOf(paramLong));
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      y.e("AdLandingPagesProxy", "FavOfficialItem fail, errrType[%d], errCode[%d], item_buff[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    for (;;)
    {
      if (locala != null) {
        locala.e(paramInt1, paramInt2, null);
      }
      return;
      y.i("AdLandingPagesProxy", "FavOfficialItem succeed, item_buff[%s]", new Object[] { paramString });
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void onImgDownloadCallback(String paramString, boolean paramBoolean)
  {
    y.i("AdLandingPagesProxy", "onImgDownloadCallback");
    if (bk.bl(paramString)) {}
    do
    {
      return;
      paramString = (AdLandingPagesProxy.d)this.oou.remove(paramString);
    } while (paramString == null);
    if (paramBoolean)
    {
      paramString.bCG();
      return;
    }
    paramString.bCF();
  }
  
  public void onRelease()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(1337, this.eeo);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(1210, this.eeo);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(2874, this.eeo);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(2721, this.eeo);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(1802, this.eeo);
    af.bDA().b(this.oov);
  }
  
  public boolean pauseTask(long paramLong)
  {
    Object localObject = REMOTE_CALL("pauseTaskMM", new Object[] { Long.valueOf(paramLong) });
    if (localObject == null) {
      return false;
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public boolean pauseTask(String paramString)
  {
    paramString = REMOTE_CALL("pauseTaskMM", new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public boolean pauseTaskByAppid(String paramString)
  {
    paramString = REMOTE_CALL("pauseTaskByAppidMM", new Object[] { paramString });
    if (paramString == null) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean pauseTaskByAppidMM(String paramString)
  {
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.c.oBZ;
    long l = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(paramString);
    return com.tencent.mm.plugin.downloader.model.d.aFP().de(l);
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean pauseTaskMM(long paramLong)
  {
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.c.oBZ;
    return com.tencent.mm.plugin.downloader.model.d.aFP().de(paramLong);
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean pauseTaskMM(String paramString)
  {
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.c.oBZ;
    long l = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(paramString);
    return com.tencent.mm.plugin.downloader.model.d.aFP().de(l);
  }
  
  @com.tencent.mm.remoteservice.e
  public void paused(long paramLong)
  {
    a.a locala = (a.a)this.oot.get(Long.valueOf(paramLong));
    if (locala != null) {
      locala.bCA();
    }
  }
  
  public void playTimelineBackAnimation(long paramLong)
  {
    long l = System.currentTimeMillis();
    this.ooo.put(Long.valueOf(l), null);
    REMOTE_CALL("playTimelineBackAnimationMM", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) });
  }
  
  @com.tencent.mm.remoteservice.f
  public void playTimelineBackAnimationMM(long paramLong1, long paramLong2)
  {
    rx localrx = new rx();
    localrx.cbA.brn = paramLong2;
    com.tencent.mm.sdk.b.a.udP.m(localrx);
  }
  
  public void playTimelineClickAnimation(long paramLong)
  {
    long l = System.currentTimeMillis();
    this.ooo.put(Long.valueOf(l), null);
    REMOTE_CALL("playTimelineClickAnimationMM", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) });
  }
  
  @com.tencent.mm.remoteservice.f
  public void playTimelineClickAnimationMM(long paramLong1, long paramLong2)
  {
    ry localry = new ry();
    localry.cbB.brn = paramLong2;
    com.tencent.mm.sdk.b.a.udP.m(localry);
  }
  
  @com.tencent.mm.remoteservice.e
  public void progress(long paramLong, int paramInt)
  {
    y.v("AdLandingPagesProxy", "progress client id %d , progress %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    a.a locala = (a.a)this.oot.get(Long.valueOf(paramLong));
    if (locala != null) {
      locala.xE(paramInt);
    }
  }
  
  public long queryIdByAppid(String paramString)
  {
    paramString = REMOTE_CALL("queryIdByAppidMM", new Object[] { paramString });
    if (paramString == null) {
      return -1L;
    }
    return ((Long)paramString).longValue();
  }
  
  @com.tencent.mm.remoteservice.f
  public long queryIdByAppidMM(String paramString)
  {
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.c.oBZ;
    return com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(paramString);
  }
  
  public void reportDownloadInfo(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    REMOTE_CALL("reportDownloadInfoMM", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3, paramString4 });
  }
  
  @com.tencent.mm.remoteservice.f
  public void reportDownloadInfoMM(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a.c.oBZ.e(paramInt, paramString1, paramString2, paramString4);
  }
  
  public boolean resumeTask(String paramString1, a.a parama, String paramString2, String paramString3)
  {
    paramString2 = REMOTE_CALL("resumeTaskMM", new Object[] { paramString1, paramString2, paramString3 });
    if (paramString2 == null) {}
    for (boolean bool = false;; bool = ((Boolean)paramString2).booleanValue())
    {
      if (bool) {
        this.oot.put(Long.valueOf(queryIdByAppid(paramString1)), parama);
      }
      return bool;
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean resumeTaskMM(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = false;
    AdLandingPagesProxy.c localc = new AdLandingPagesProxy.c(this, (byte)0);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.c.oBZ;
    long l = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.queryIdByAppid(paramString1);
    this.oos.put(Long.valueOf(l), localc);
    localc.id = l;
    locala = a.c.oBZ;
    FileDownloadTaskInfo localFileDownloadTaskInfo = com.tencent.mm.plugin.downloader.model.d.aFP().zL(paramString1);
    if (localFileDownloadTaskInfo != null)
    {
      locala.oBW.put(Long.valueOf(localFileDownloadTaskInfo.id), new WeakReference(localc));
      locala.oBX.put(paramString1, new a.b(paramString2, paramString3));
      bool = com.tencent.mm.plugin.downloader.model.d.aFP().df(localFileDownloadTaskInfo.id);
    }
    return bool;
  }
  
  @com.tencent.mm.remoteservice.e
  public void resumed(long paramLong)
  {
    a.a locala = (a.a)this.oot.get(Long.valueOf(paramLong));
    if (locala != null) {
      locala.bCE();
    }
  }
  
  public void saveAdVoteInfo(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    REMOTE_CALL("saveAdVoteInfoMM", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  @com.tencent.mm.remoteservice.f
  public void saveAdVoteInfoMM(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    v.g(paramString1, paramString2, paramString3, paramInt1, paramInt2);
  }
  
  @com.tencent.mm.remoteservice.e
  public void start(long paramLong)
  {
    a.a locala = (a.a)this.oot.get(Long.valueOf(paramLong));
    if (locala != null) {
      locala.start();
    }
  }
  
  public long startDownload(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, a.a parama, String paramString6, String paramString7)
  {
    y.v("AdLandingPagesProxy", "startDownload");
    paramString1 = REMOTE_CALL("startDownloadMM", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, Boolean.valueOf(paramBoolean), paramString6, paramString7 });
    if (paramString1 == null) {}
    for (long l = -1L;; l = ((Long)paramString1).longValue())
    {
      this.oot.put(Long.valueOf(l), parama);
      return l;
    }
  }
  
  @com.tencent.mm.remoteservice.f
  public long startDownloadMM(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, String paramString7)
  {
    AdLandingPagesProxy.c localc = new AdLandingPagesProxy.c(this, (byte)0);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.c.oBZ;
    e.a locala1 = new e.a();
    locala1.setAppId(paramString1);
    locala1.cq(paramString2);
    locala1.zQ(paramString3);
    locala1.zN(paramString4);
    locala1.zP(paramString5);
    locala1.eO(paramBoolean);
    paramString2 = locala1.iPG;
    long l = com.tencent.mm.plugin.downloader.model.d.aFP().a(paramString2);
    locala.oBW.put(Long.valueOf(l), new WeakReference(localc));
    locala.oBX.put(paramString1, new a.b(paramString6, paramString7));
    this.oos.put(Long.valueOf(l), localc);
    y.v("AdLandingPagesProxy", "startDownloadMM, id %d", new Object[] { Long.valueOf(l) });
    localc.id = l;
    return l;
  }
  
  public void stopTask(long paramLong)
  {
    REMOTE_CALL("stopTaskMM", new Object[] { Long.valueOf(paramLong) });
  }
  
  public void stopTask(String paramString)
  {
    REMOTE_CALL("stopTaskMM", new Object[] { paramString });
  }
  
  public void stopTaskMM(long paramLong)
  {
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.c.oBZ;
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.stopTask(paramLong);
  }
  
  @com.tencent.mm.remoteservice.f
  public void stopTaskMM(String paramString)
  {
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a locala = a.c.oBZ;
    paramString = com.tencent.mm.plugin.downloader.model.d.aFP().zL(paramString);
    if (paramString != null) {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.stopTask(paramString.id);
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void stopped(long paramLong)
  {
    a.a locala = (a.a)this.oot.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.bCB();
      this.oot.remove(Long.valueOf(paramLong));
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public void succeed(long paramLong)
  {
    a.a locala = (a.a)this.oot.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.bCC();
      this.oot.remove(Long.valueOf(paramLong));
    }
  }
  
  public boolean useOnlineStreamPlayer()
  {
    Object localObject = REMOTE_CALL("useOnlineStreamPlayerMM", new Object[0]);
    if (localObject == null) {
      return false;
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  @com.tencent.mm.remoteservice.f
  public boolean useOnlineStreamPlayerMM()
  {
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100208");
    if (localc.isValid())
    {
      int i = bk.getInt((String)localc.ctr().get("useOnlineVideoPlayer"), 0);
      y.i("AdLandingPagesProxy", "useOnlineVideoPlayer abtest=" + i);
      return i == 1;
    }
    return false;
  }
  
  public void writeDeferredDeepLink(String paramString1, String paramString2)
  {
    REMOTE_CALL("writeDeferredDeepLinkMM", new Object[] { paramString1, paramString2 });
  }
  
  @com.tencent.mm.remoteservice.f
  public void writeDeferredDeepLinkMM(String paramString1, String paramString2)
  {
    bCz().edit().putString(paramString1, paramString2).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy
 * JD-Core Version:    0.7.0.1
 */