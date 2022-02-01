package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.a.g;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.protocal.protobuf.djm;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;
import d.v;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload;", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "mPath", "", "thumbPath", "callback", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1;", "cdnMediaType", "", "clientId", "mMd5", "postinfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "sendScene", "st_new", "", "startTime", "useCdnTransClientId", "checkUpload", "", "doUpload", "extInfo", "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "onErrorServer", "", "errCode", "onPostScene", "url", "urlType", "thumbUrl", "thumbType", "meidiaId", "updateMd5Info", "updatePostInfo", "isOk", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.f.g
{
  private final com.tencent.mm.plugin.story.i.j ANZ;
  private djm AOe;
  private final a AOf;
  final com.tencent.mm.plugin.story.f.g.a AOg;
  final String TAG;
  private String clientId;
  private long iSB;
  String ibe;
  private int itF;
  private String ksR;
  private final String mPath;
  private final String thumbPath;
  
  public b(com.tencent.mm.plugin.story.i.j paramj, String paramString1, String paramString2, com.tencent.mm.plugin.story.f.g.a parama)
  {
    AppMethodBeat.i(119103);
    this.ANZ = paramj;
    this.mPath = paramString1;
    this.thumbPath = paramString2;
    this.AOg = parama;
    this.clientId = "";
    this.ksR = "";
    this.AOe = new djm();
    this.TAG = "MicroMsg.StorySightCdnUpload";
    this.AOf = new a(this);
    this.iSB = cf.aCL();
    this.AOe = this.ANZ.elz();
    paramString1 = this.AOe.hCW;
    paramj = paramString1;
    if (paramString1 == null) {
      paramj = "";
    }
    this.clientId = paramj;
    paramString1 = this.AOe.md5;
    paramj = paramString1;
    if (paramString1 == null) {
      paramj = "";
    }
    this.ksR = paramj;
    if (bt.isNullOrNil(this.clientId))
    {
      paramj = bt.HI();
      paramString1 = d.n.d.UTF_8;
      if (paramj == null)
      {
        paramj = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(119103);
        throw paramj;
      }
      paramj = paramj.getBytes(paramString1);
      p.g(paramj, "(this as java.lang.String).getBytes(charset)");
      this.clientId = com.tencent.mm.b.g.getMessageDigest(paramj);
      this.AOe.hCW = this.clientId;
    }
    try
    {
      paramj = this.ANZ;
      paramString1 = this.AOe.toByteArray();
      p.g(paramString1, "postinfo.toByteArray()");
      paramj.bK(paramString1);
      paramj = com.tencent.mm.plugin.story.f.j.AKb;
      j.b.ehT().a((int)this.ANZ.systemRowid, this.ANZ);
      int i = (int)i.aYo(this.mPath);
      ad.i(this.TAG, "storyUpload  videopath %s sightFileSize %d md5 %s", new Object[] { this.mPath, Integer.valueOf(i), this.ksR });
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
    p.h(paramString1, "url");
    p.h(paramString2, "thumbUrl");
    p.h(paramString3, "meidiaId");
    ad.d(this.TAG, "upload ok " + paramString1 + "  " + paramString3 + "  " + paramInt1);
    paramString3 = this.AOe;
    Object localObject = a.g.ATG;
    paramString3.GPx = a.g.elj();
    this.AOe.hfV = 0;
    this.AOe.GTk = cf.aCN();
    paramString3 = this.ANZ;
    localObject = this.AOe.toByteArray();
    p.g(localObject, "postinfo.toByteArray()");
    paramString3.bK((byte[])localObject);
    paramString3 = (djl)this.ANZ.elx().HyN.GaQ.get(0);
    paramString3.Url = paramString1;
    paramString3.nEf = paramInt1;
    paramString3.GSI = paramString2;
    paramString3.nEf = paramInt2;
    f.aGJ();
    paramString3.GTd = com.tencent.mm.ao.a.EL(this.mPath);
    ad.i(this.TAG, "mediaObj.videomd5 " + paramString3.GTd);
    paramString1 = this.ANZ.elx();
    paramString1.HyN.GaQ.set(0, paramString3);
    this.ANZ.b(paramString1);
    paramString1 = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.ehT().a((int)this.ANZ.systemRowid, this.ANZ);
    AppMethodBeat.o(119101);
    return true;
  }
  
  final void ejk()
  {
    AppMethodBeat.i(119100);
    ad.i(this.TAG, "snsupload sight by cdn error! " + bt.flS());
    try
    {
      this.AOe.hfV += 1;
      Object localObject1 = this.AOe;
      Object localObject2 = a.g.ATG;
      ((djm)localObject1).GPx = a.g.elk();
      localObject1 = this.ANZ;
      localObject2 = this.AOe.toByteArray();
      p.g(localObject2, "postinfo.toByteArray()");
      ((com.tencent.mm.plugin.story.i.j)localObject1).bK((byte[])localObject2);
      localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
      j.b.ehT().a((int)this.ANZ.systemRowid, this.ANZ);
      AppMethodBeat.o(119100);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(119100);
    }
  }
  
  public final boolean ejl()
  {
    AppMethodBeat.i(119102);
    Object localObject1 = i.aPK(this.mPath);
    if ((!bt.isNullOrNil(this.ksR)) && ((p.i(this.ksR, localObject1) ^ true)))
    {
      ad.i(this.TAG, "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.ksR, localObject1 });
      ejk();
      this.AOg.a(-2, false, (com.tencent.mm.plugin.story.f.g)this);
      AppMethodBeat.o(119102);
      return false;
    }
    localObject1 = new bxm();
    ad.i(this.TAG, "check upload %s %d %s", new Object[] { this.mPath, Integer.valueOf(((bxm)localObject1).sJZ), Boolean.valueOf(((bxm)localObject1).GRA) });
    Object localObject2 = e.axx(this.mPath);
    if (localObject2 != null) {
      ad.i(this.TAG, "mediaInfo: %s", new Object[] { localObject2 });
    }
    if ((this.AOe.Hyr & 0x1) == 0) {
      SightVideoJNI.optimizeMP4VFS(this.mPath);
    }
    try
    {
      localObject2 = i.aPK(this.mPath);
      p.g(localObject2, "VFSFileOp.getFileMD5String(mPath)");
      this.ksR = ((String)localObject2);
      this.AOe.md5 = this.ksR;
      this.AOe.Hyr |= 0x1;
      localObject2 = this.ANZ;
      Object localObject3 = this.AOe.toByteArray();
      p.g(localObject3, "postinfo.toByteArray()");
      ((com.tencent.mm.plugin.story.i.j)localObject2).bK((byte[])localObject3);
      ad.i(this.TAG, "new md5 is %s %s", new Object[] { this.mPath, this.ksR });
      localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
      j.b.ehT().a((int)this.ANZ.systemRowid, this.ANZ);
      this.ibe = this.clientId;
      localObject2 = new com.tencent.mm.i.g();
      ((com.tencent.mm.i.g)localObject2).fJi = "task_StorySightCdnUpload";
      ((com.tencent.mm.i.g)localObject2).fJj = ((com.tencent.mm.i.g.a)this.AOf);
      ((com.tencent.mm.i.g)localObject2).field_mediaId = this.ibe;
      ((com.tencent.mm.i.g)localObject2).field_fullpath = this.mPath;
      ((com.tencent.mm.i.g)localObject2).field_thumbpath = this.thumbPath;
      ((com.tencent.mm.i.g)localObject2).field_fileType = 20302;
      ((com.tencent.mm.i.g)localObject2).field_talker = "";
      ((com.tencent.mm.i.g)localObject2).field_priority = com.tencent.mm.i.a.fIw;
      ((com.tencent.mm.i.g)localObject2).field_needStorage = true;
      ((com.tencent.mm.i.g)localObject2).field_isStreamMedia = false;
      ((com.tencent.mm.i.g)localObject2).field_appType = 205;
      ((com.tencent.mm.i.g)localObject2).field_bzScene = 2;
      localObject3 = (c.a)com.tencent.mm.plugin.story.c.a.c.AIy.ate();
      if (localObject3 != null)
      {
        ad.i(this.TAG, "StoryEncodeElementConfig " + ((c.a)localObject3).duration);
        ((com.tencent.mm.i.g)localObject2).field_largesvideo = (((c.a)localObject3).duration + 3);
        ((com.tencent.mm.i.g)localObject2).fJA = 6;
        localObject3 = i.aPK(this.mPath);
        if ((bt.isNullOrNil(this.ksR)) || (!(p.i(this.ksR, localObject3) ^ true))) {
          break label595;
        }
        ad.i(this.TAG, "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.ksR, localObject3 });
        ejk();
        this.AOg.a(-2, false, (com.tencent.mm.plugin.story.f.g)this);
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
      label595:
      ad.d(this.TAG, "will addSendTask");
      if (!f.aGI().f(localException))
      {
        ad.e(this.TAG, "cdntra addSendTask failed. clientid:%s", new Object[] { this.ibe });
        this.AOg.a(-3, false, (com.tencent.mm.plugin.story.f.g)this);
        AppMethodBeat.o(119102);
        return false;
      }
      if (!((bxm)localObject1).GRA) {}
    }
    for (int i = 4;; i = 5)
    {
      this.itF = i;
      AppMethodBeat.o(119102);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
  public static final class a
    implements com.tencent.mm.i.g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(119097);
      p.h(paramString, "mediaId");
      if (paramInt == -21005)
      {
        ad.d(this.AOh.TAG, "cdntra cdnCallback1 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.AOh.ibe, Integer.valueOf(paramInt), paramc, paramd });
        this.AOh.AOg.a(0, true, (com.tencent.mm.plugin.story.f.g)this.AOh);
        AppMethodBeat.o(119097);
        return 0;
      }
      if ((paramd != null) && (paramd.field_retCode == 0))
      {
        ad.i(this.AOh.TAG, "cdntra cdnCallback2 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.AOh.ibe, Integer.valueOf(paramInt), paramc, paramd });
        b localb = this.AOh;
        String str = paramd.field_fileUrl;
        p.g(str, "sceneResult.field_fileUrl");
        paramString = com.tencent.mm.plugin.story.i.a.ATp;
        paramInt = com.tencent.mm.plugin.story.i.a.ekE();
        paramd = paramd.field_thumbUrl;
        p.g(paramd, "sceneResult.field_thumbUrl");
        paramString = com.tencent.mm.plugin.story.i.a.ATp;
        int i = com.tencent.mm.plugin.story.i.a.ekE();
        StringBuilder localStringBuilder = new StringBuilder("upload_ + ");
        paramc = this.AOh.ibe;
        paramString = paramc;
        if (paramc == null) {
          paramString = "null";
        }
        localb.b(str, paramInt, paramd, i, paramString);
        this.AOh.AOg.a(0, true, (com.tencent.mm.plugin.story.f.g)this.AOh);
        AppMethodBeat.o(119097);
        return 0;
      }
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        ad.i(this.AOh.TAG, "cdntra cdnCallback3 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.AOh.ibe, Integer.valueOf(paramInt), paramc, paramd });
        this.AOh.ejk();
        this.AOh.AOg.a(paramd.field_retCode, false, (com.tencent.mm.plugin.story.f.g)this.AOh);
        AppMethodBeat.o(119097);
        return 0;
      }
      if (paramInt != 0)
      {
        ad.i(this.AOh.TAG, "cdntra cdnCallback4 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.AOh.ibe, Integer.valueOf(paramInt), paramc, paramd });
        this.AOh.ejk();
        this.AOh.AOg.a(paramInt, false, (com.tencent.mm.plugin.story.f.g)this.AOh);
        AppMethodBeat.o(119097);
        return 0;
      }
      ad.d(this.AOh.TAG, "cdntra cdnCallback5 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.AOh.ibe, Integer.valueOf(paramInt), paramc, paramd });
      AppMethodBeat.o(119097);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(119098);
      p.h(paramString, "mediaId");
      p.h(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(119098);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(119099);
      p.h(paramString, "mediaId");
      p.h(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(119099);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.b
 * JD-Core Version:    0.7.0.1
 */