package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.a.g;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.cyn;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.l;
import d.v;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload;", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "mPath", "", "thumbPath", "callback", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1;", "cdnMediaType", "", "clientId", "mMd5", "postinfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "sendScene", "st_new", "", "startTime", "useCdnTransClientId", "checkUpload", "", "doUpload", "extInfo", "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "onErrorServer", "", "errCode", "onPostScene", "url", "urlType", "thumbUrl", "thumbType", "meidiaId", "updateMd5Info", "updatePostInfo", "isOk", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.f.g
{
  final String TAG;
  private String clientId;
  private long hZo;
  String hhN;
  private int hzJ;
  private String jya;
  private final String mPath;
  private final String thumbPath;
  private final com.tencent.mm.plugin.story.i.j yje;
  private cyn yjj;
  private final a yjk;
  final com.tencent.mm.plugin.story.f.g.a yjl;
  
  public b(com.tencent.mm.plugin.story.i.j paramj, String paramString1, String paramString2, com.tencent.mm.plugin.story.f.g.a parama)
  {
    AppMethodBeat.i(119103);
    this.yje = paramj;
    this.mPath = paramString1;
    this.thumbPath = paramString2;
    this.yjl = parama;
    this.clientId = "";
    this.jya = "";
    this.yjj = new cyn();
    this.TAG = "MicroMsg.StorySightCdnUpload";
    this.yjk = new a(this);
    this.hZo = ce.asR();
    this.yjj = this.yje.dKJ();
    paramString1 = this.yjj.gKn;
    paramj = paramString1;
    if (paramString1 == null) {
      paramj = "";
    }
    this.clientId = paramj;
    paramString1 = this.yjj.md5;
    paramj = paramString1;
    if (paramString1 == null) {
      paramj = "";
    }
    this.jya = paramj;
    if (bt.isNullOrNil(this.clientId))
    {
      paramj = bt.GC();
      paramString1 = d.n.d.UTF_8;
      if (paramj == null)
      {
        paramj = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(119103);
        throw paramj;
      }
      paramj = paramj.getBytes(paramString1);
      d.g.b.k.g(paramj, "(this as java.lang.String).getBytes(charset)");
      this.clientId = com.tencent.mm.b.g.getMessageDigest(paramj);
      this.yjj.gKn = this.clientId;
    }
    try
    {
      paramj = this.yje;
      paramString1 = this.yjj.toByteArray();
      d.g.b.k.g(paramString1, "postinfo.toByteArray()");
      paramj.bE(paramString1);
      paramj = com.tencent.mm.plugin.story.f.j.yfh;
      j.b.dHd().a((int)this.yje.systemRowid, this.yje);
      int i = (int)i.aMN(this.mPath);
      ad.i(this.TAG, "storyUpload  videopath %s sightFileSize %d md5 %s", new Object[] { this.mPath, Integer.valueOf(i), this.jya });
      AppMethodBeat.o(119103);
      return;
    }
    catch (Exception paramj)
    {
      for (;;)
      {
        ad.printErrStackTrace(this.TAG, (Throwable)paramj, "", new Object[0]);
      }
    }
  }
  
  public final boolean b(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(119101);
    d.g.b.k.h(paramString1, "url");
    d.g.b.k.h(paramString2, "thumbUrl");
    d.g.b.k.h(paramString3, "meidiaId");
    ad.d(this.TAG, "upload ok " + paramString1 + "  " + paramString3 + "  " + paramInt1);
    paramString3 = this.yjj;
    Object localObject = a.g.yoI;
    paramString3.DJF = a.g.dKt();
    this.yjj.gll = 0;
    this.yjj.DNs = ce.asT();
    paramString3 = this.yje;
    localObject = this.yjj.toByteArray();
    d.g.b.k.g(localObject, "postinfo.toByteArray()");
    paramString3.bE((byte[])localObject);
    paramString3 = (cym)this.yje.dKH().Era.DaC.get(0);
    paramString3.Url = paramString1;
    paramString3.mBH = paramInt1;
    paramString3.DMQ = paramString2;
    paramString3.mBH = paramInt2;
    f.awM();
    paramString3.DNl = com.tencent.mm.ao.a.xG(this.mPath);
    ad.i(this.TAG, "mediaObj.videomd5 " + paramString3.DNl);
    paramString1 = this.yje.dKH();
    paramString1.Era.DaC.set(0, paramString3);
    this.yje.b(paramString1);
    paramString1 = com.tencent.mm.plugin.story.f.j.yfh;
    j.b.dHd().a((int)this.yje.systemRowid, this.yje);
    AppMethodBeat.o(119101);
    return true;
  }
  
  final void dIu()
  {
    AppMethodBeat.i(119100);
    ad.i(this.TAG, "snsupload sight by cdn error! " + bt.eGN());
    try
    {
      this.yjj.gll += 1;
      Object localObject1 = this.yjj;
      Object localObject2 = a.g.yoI;
      ((cyn)localObject1).DJF = a.g.dKu();
      localObject1 = this.yje;
      localObject2 = this.yjj.toByteArray();
      d.g.b.k.g(localObject2, "postinfo.toByteArray()");
      ((com.tencent.mm.plugin.story.i.j)localObject1).bE((byte[])localObject2);
      localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
      j.b.dHd().a((int)this.yje.systemRowid, this.yje);
      AppMethodBeat.o(119100);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(119100);
    }
  }
  
  public final boolean dIv()
  {
    AppMethodBeat.i(119102);
    Object localObject1 = i.aEN(this.mPath);
    if ((!bt.isNullOrNil(this.jya)) && ((d.g.b.k.g(this.jya, localObject1) ^ true)))
    {
      ad.i(this.TAG, "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.jya, localObject1 });
      dIu();
      this.yjl.a(-2, false, (com.tencent.mm.plugin.story.f.g)this);
      AppMethodBeat.o(119102);
      return false;
    }
    localObject1 = new boj();
    ad.i(this.TAG, "check upload %s %d %s", new Object[] { this.mPath, Integer.valueOf(((boj)localObject1).qRG), Boolean.valueOf(((boj)localObject1).DLK) });
    Object localObject2 = e.ano(this.mPath);
    if (localObject2 != null) {
      ad.i(this.TAG, "mediaInfo: %s", new Object[] { localObject2 });
    }
    if ((this.yjj.EqE & 0x1) == 0) {
      SightVideoJNI.optimizeMP4VFS(this.mPath);
    }
    try
    {
      localObject2 = i.aEN(this.mPath);
      d.g.b.k.g(localObject2, "VFSFileOp.getFileMD5String(mPath)");
      this.jya = ((String)localObject2);
      this.yjj.md5 = this.jya;
      this.yjj.EqE |= 0x1;
      localObject2 = this.yje;
      Object localObject3 = this.yjj.toByteArray();
      d.g.b.k.g(localObject3, "postinfo.toByteArray()");
      ((com.tencent.mm.plugin.story.i.j)localObject2).bE((byte[])localObject3);
      ad.i(this.TAG, "new md5 is %s %s", new Object[] { this.mPath, this.jya });
      localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
      j.b.dHd().a((int)this.yje.systemRowid, this.yje);
      this.hhN = this.clientId;
      localObject2 = new com.tencent.mm.i.g();
      ((com.tencent.mm.i.g)localObject2).fnH = ((com.tencent.mm.i.g.a)this.yjk);
      ((com.tencent.mm.i.g)localObject2).field_mediaId = this.hhN;
      ((com.tencent.mm.i.g)localObject2).field_fullpath = this.mPath;
      ((com.tencent.mm.i.g)localObject2).field_thumbpath = this.thumbPath;
      ((com.tencent.mm.i.g)localObject2).field_fileType = 20302;
      ((com.tencent.mm.i.g)localObject2).field_talker = "";
      ((com.tencent.mm.i.g)localObject2).field_priority = com.tencent.mm.i.a.fmV;
      ((com.tencent.mm.i.g)localObject2).field_needStorage = true;
      ((com.tencent.mm.i.g)localObject2).field_isStreamMedia = false;
      ((com.tencent.mm.i.g)localObject2).field_appType = 205;
      ((com.tencent.mm.i.g)localObject2).field_bzScene = 2;
      localObject3 = (c.a)com.tencent.mm.plugin.story.c.a.c.ydE.ajp();
      if (localObject3 != null)
      {
        ad.i(this.TAG, "StoryEncodeElementConfig " + ((c.a)localObject3).duration);
        ((com.tencent.mm.i.g)localObject2).field_largesvideo = (((c.a)localObject3).duration + 3);
        ((com.tencent.mm.i.g)localObject2).fnX = 6;
        localObject3 = i.aEN(this.mPath);
        if ((bt.isNullOrNil(this.jya)) || (!(d.g.b.k.g(this.jya, localObject3) ^ true))) {
          break label588;
        }
        ad.i(this.TAG, "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.jya, localObject3 });
        dIu();
        this.yjl.a(-2, false, (com.tencent.mm.plugin.story.f.g)this);
        AppMethodBeat.o(119102);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e(this.TAG, "parseFrom MediaUploadInfo error in updateMd5Info %s", new Object[] { localException.getMessage() });
        continue;
        localException.field_largesvideo = 18;
      }
      label588:
      ad.d(this.TAG, "will addSendTask");
      if (!f.awL().e(localException))
      {
        ad.e(this.TAG, "cdntra addSendTask failed. clientid:%s", new Object[] { this.hhN });
        this.yjl.a(-3, false, (com.tencent.mm.plugin.story.f.g)this);
        AppMethodBeat.o(119102);
        return false;
      }
      if (!((boj)localObject1).DLK) {}
    }
    for (int i = 4;; i = 5)
    {
      this.hzJ = i;
      AppMethodBeat.o(119102);
      return true;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
  public static final class a
    implements com.tencent.mm.i.g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(119097);
      d.g.b.k.h(paramString, "mediaId");
      if (paramInt == -21005)
      {
        ad.d(this.yjm.TAG, "cdntra cdnCallback1 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.yjm.hhN, Integer.valueOf(paramInt), paramc, paramd });
        this.yjm.yjl.a(0, true, (com.tencent.mm.plugin.story.f.g)this.yjm);
        AppMethodBeat.o(119097);
        return 0;
      }
      if ((paramd != null) && (paramd.field_retCode == 0))
      {
        ad.i(this.yjm.TAG, "cdntra cdnCallback2 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.yjm.hhN, Integer.valueOf(paramInt), paramc, paramd });
        b localb = this.yjm;
        String str = paramd.field_fileUrl;
        d.g.b.k.g(str, "sceneResult.field_fileUrl");
        paramString = com.tencent.mm.plugin.story.i.a.yor;
        paramInt = com.tencent.mm.plugin.story.i.a.dJO();
        paramd = paramd.field_thumbUrl;
        d.g.b.k.g(paramd, "sceneResult.field_thumbUrl");
        paramString = com.tencent.mm.plugin.story.i.a.yor;
        int i = com.tencent.mm.plugin.story.i.a.dJO();
        StringBuilder localStringBuilder = new StringBuilder("upload_ + ");
        paramc = this.yjm.hhN;
        paramString = paramc;
        if (paramc == null) {
          paramString = "null";
        }
        localb.b(str, paramInt, paramd, i, paramString);
        this.yjm.yjl.a(0, true, (com.tencent.mm.plugin.story.f.g)this.yjm);
        AppMethodBeat.o(119097);
        return 0;
      }
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        ad.i(this.yjm.TAG, "cdntra cdnCallback3 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.yjm.hhN, Integer.valueOf(paramInt), paramc, paramd });
        this.yjm.dIu();
        this.yjm.yjl.a(paramd.field_retCode, false, (com.tencent.mm.plugin.story.f.g)this.yjm);
        AppMethodBeat.o(119097);
        return 0;
      }
      if (paramInt != 0)
      {
        ad.i(this.yjm.TAG, "cdntra cdnCallback4 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.yjm.hhN, Integer.valueOf(paramInt), paramc, paramd });
        this.yjm.dIu();
        this.yjm.yjl.a(paramInt, false, (com.tencent.mm.plugin.story.f.g)this.yjm);
        AppMethodBeat.o(119097);
        return 0;
      }
      ad.d(this.yjm.TAG, "cdntra cdnCallback5 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.yjm.hhN, Integer.valueOf(paramInt), paramc, paramd });
      AppMethodBeat.o(119097);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(119098);
      d.g.b.k.h(paramString, "mediaId");
      d.g.b.k.h(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(119098);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(119099);
      d.g.b.k.h(paramString, "mediaId");
      d.g.b.k.h(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(119099);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.b
 * JD-Core Version:    0.7.0.1
 */