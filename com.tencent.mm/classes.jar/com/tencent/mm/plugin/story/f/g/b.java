package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.a.g;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import d.v;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload;", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "mPath", "", "thumbPath", "callback", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1;", "cdnMediaType", "", "clientId", "mMd5", "postinfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "sendScene", "st_new", "", "startTime", "useCdnTransClientId", "checkUpload", "", "doUpload", "extInfo", "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "onErrorServer", "", "errCode", "onPostScene", "url", "urlType", "thumbUrl", "thumbType", "meidiaId", "updateMd5Info", "updatePostInfo", "isOk", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.f.g
{
  private final com.tencent.mm.plugin.story.i.j BfA;
  private dkh BfF;
  private final a BfG;
  final com.tencent.mm.plugin.story.f.g.a BfH;
  final String TAG;
  private String clientId;
  private long iVu;
  String idX;
  private int iwz;
  private String kwh;
  private final String mPath;
  private final String thumbPath;
  
  public b(com.tencent.mm.plugin.story.i.j paramj, String paramString1, String paramString2, com.tencent.mm.plugin.story.f.g.a parama)
  {
    AppMethodBeat.i(119103);
    this.BfA = paramj;
    this.mPath = paramString1;
    this.thumbPath = paramString2;
    this.BfH = parama;
    this.clientId = "";
    this.kwh = "";
    this.BfF = new dkh();
    this.TAG = "MicroMsg.StorySightCdnUpload";
    this.BfG = new a(this);
    this.iVu = ch.aDb();
    this.BfF = this.BfA.epi();
    paramString1 = this.BfF.hFO;
    paramj = paramString1;
    if (paramString1 == null) {
      paramj = "";
    }
    this.clientId = paramj;
    paramString1 = this.BfF.md5;
    paramj = paramString1;
    if (paramString1 == null) {
      paramj = "";
    }
    this.kwh = paramj;
    if (bu.isNullOrNil(this.clientId))
    {
      paramj = bu.HQ();
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
      this.BfF.hFO = this.clientId;
    }
    try
    {
      paramj = this.BfA;
      paramString1 = this.BfF.toByteArray();
      p.g(paramString1, "postinfo.toByteArray()");
      paramj.bN(paramString1);
      paramj = com.tencent.mm.plugin.story.f.j.BbE;
      j.b.elB().a((int)this.BfA.systemRowid, this.BfA);
      int i = (int)o.aZR(this.mPath);
      ae.i(this.TAG, "storyUpload  videopath %s sightFileSize %d md5 %s", new Object[] { this.mPath, Integer.valueOf(i), this.kwh });
      AppMethodBeat.o(119103);
      return;
    }
    catch (Exception paramj)
    {
      for (;;)
      {
        ae.printErrStackTrace(this.TAG, (Throwable)paramj, "", new Object[0]);
      }
    }
  }
  
  public final boolean b(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(119101);
    p.h(paramString1, "url");
    p.h(paramString2, "thumbUrl");
    p.h(paramString3, "meidiaId");
    ae.d(this.TAG, "upload ok " + paramString1 + "  " + paramString3 + "  " + paramInt1);
    paramString3 = this.BfF;
    Object localObject = a.g.Ble;
    paramString3.HiZ = a.g.eoS();
    this.BfF.hiJ = 0;
    this.BfF.HmL = ch.aDd();
    paramString3 = this.BfA;
    localObject = this.BfF.toByteArray();
    p.g(localObject, "postinfo.toByteArray()");
    paramString3.bN((byte[])localObject);
    paramString3 = (dkg)this.BfA.epg().HSy.Gtx.get(0);
    paramString3.Url = paramString1;
    paramString3.nJA = paramInt1;
    paramString3.Hmj = paramString2;
    paramString3.nJA = paramInt2;
    f.aHa();
    paramString3.HmE = com.tencent.mm.an.a.Fn(this.mPath);
    ae.i(this.TAG, "mediaObj.videomd5 " + paramString3.HmE);
    paramString1 = this.BfA.epg();
    paramString1.HSy.Gtx.set(0, paramString3);
    this.BfA.b(paramString1);
    paramString1 = com.tencent.mm.plugin.story.f.j.BbE;
    j.b.elB().a((int)this.BfA.systemRowid, this.BfA);
    AppMethodBeat.o(119101);
    return true;
  }
  
  final void emS()
  {
    AppMethodBeat.i(119100);
    ae.i(this.TAG, "snsupload sight by cdn error! " + bu.fpN());
    try
    {
      this.BfF.hiJ += 1;
      Object localObject1 = this.BfF;
      Object localObject2 = a.g.Ble;
      ((dkh)localObject1).HiZ = a.g.eoT();
      localObject1 = this.BfA;
      localObject2 = this.BfF.toByteArray();
      p.g(localObject2, "postinfo.toByteArray()");
      ((com.tencent.mm.plugin.story.i.j)localObject1).bN((byte[])localObject2);
      localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
      j.b.elB().a((int)this.BfA.systemRowid, this.BfA);
      AppMethodBeat.o(119100);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(119100);
    }
  }
  
  public final boolean emT()
  {
    AppMethodBeat.i(119102);
    Object localObject1 = o.aRh(this.mPath);
    if ((!bu.isNullOrNil(this.kwh)) && ((p.i(this.kwh, localObject1) ^ true)))
    {
      ae.i(this.TAG, "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.kwh, localObject1 });
      emS();
      this.BfH.a(-2, false, (com.tencent.mm.plugin.story.f.g)this);
      AppMethodBeat.o(119102);
      return false;
    }
    localObject1 = new byg();
    ae.i(this.TAG, "check upload %s %d %s", new Object[] { this.mPath, Integer.valueOf(((byg)localObject1).sVm), Boolean.valueOf(((byg)localObject1).Hlb) });
    Object localObject2 = e.ayN(this.mPath);
    if (localObject2 != null) {
      ae.i(this.TAG, "mediaInfo: %s", new Object[] { localObject2 });
    }
    if ((this.BfF.HSc & 0x1) == 0) {
      SightVideoJNI.optimizeMP4VFS(this.mPath);
    }
    try
    {
      localObject2 = o.aRh(this.mPath);
      p.g(localObject2, "VFSFileOp.getFileMD5String(mPath)");
      this.kwh = ((String)localObject2);
      this.BfF.md5 = this.kwh;
      this.BfF.HSc |= 0x1;
      localObject2 = this.BfA;
      Object localObject3 = this.BfF.toByteArray();
      p.g(localObject3, "postinfo.toByteArray()");
      ((com.tencent.mm.plugin.story.i.j)localObject2).bN((byte[])localObject3);
      ae.i(this.TAG, "new md5 is %s %s", new Object[] { this.mPath, this.kwh });
      localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
      j.b.elB().a((int)this.BfA.systemRowid, this.BfA);
      this.idX = this.clientId;
      localObject2 = new com.tencent.mm.i.g();
      ((com.tencent.mm.i.g)localObject2).fLl = "task_StorySightCdnUpload";
      ((com.tencent.mm.i.g)localObject2).fLm = ((com.tencent.mm.i.g.a)this.BfG);
      ((com.tencent.mm.i.g)localObject2).field_mediaId = this.idX;
      ((com.tencent.mm.i.g)localObject2).field_fullpath = this.mPath;
      ((com.tencent.mm.i.g)localObject2).field_thumbpath = this.thumbPath;
      ((com.tencent.mm.i.g)localObject2).field_fileType = 20302;
      ((com.tencent.mm.i.g)localObject2).field_talker = "";
      ((com.tencent.mm.i.g)localObject2).field_priority = com.tencent.mm.i.a.fKA;
      ((com.tencent.mm.i.g)localObject2).field_needStorage = true;
      ((com.tencent.mm.i.g)localObject2).field_isStreamMedia = false;
      ((com.tencent.mm.i.g)localObject2).field_appType = 205;
      ((com.tencent.mm.i.g)localObject2).field_bzScene = 2;
      localObject3 = (c.a)com.tencent.mm.plugin.story.c.a.c.Bab.att();
      if (localObject3 != null)
      {
        ae.i(this.TAG, "StoryEncodeElementConfig " + ((c.a)localObject3).duration);
        ((com.tencent.mm.i.g)localObject2).field_largesvideo = (((c.a)localObject3).duration + 3);
        ((com.tencent.mm.i.g)localObject2).fLD = 6;
        localObject3 = o.aRh(this.mPath);
        if ((bu.isNullOrNil(this.kwh)) || (!(p.i(this.kwh, localObject3) ^ true))) {
          break label595;
        }
        ae.i(this.TAG, "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.kwh, localObject3 });
        emS();
        this.BfH.a(-2, false, (com.tencent.mm.plugin.story.f.g)this);
        AppMethodBeat.o(119102);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e(this.TAG, "parseFrom MediaUploadInfo error in updateMd5Info %s", new Object[] { localException.getMessage() });
        continue;
        localException.field_largesvideo = 18;
      }
      label595:
      ae.d(this.TAG, "will addSendTask");
      if (!f.aGZ().f(localException))
      {
        ae.e(this.TAG, "cdntra addSendTask failed. clientid:%s", new Object[] { this.idX });
        this.BfH.a(-3, false, (com.tencent.mm.plugin.story.f.g)this);
        AppMethodBeat.o(119102);
        return false;
      }
      if (!((byg)localObject1).Hlb) {}
    }
    for (int i = 4;; i = 5)
    {
      this.iwz = i;
      AppMethodBeat.o(119102);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
  public static final class a
    implements com.tencent.mm.i.g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(119097);
      p.h(paramString, "mediaId");
      if (paramInt == -21005)
      {
        ae.d(this.BfI.TAG, "cdntra cdnCallback1 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.BfI.idX, Integer.valueOf(paramInt), paramc, paramd });
        this.BfI.BfH.a(0, true, (com.tencent.mm.plugin.story.f.g)this.BfI);
        AppMethodBeat.o(119097);
        return 0;
      }
      if ((paramd != null) && (paramd.field_retCode == 0))
      {
        ae.i(this.BfI.TAG, "cdntra cdnCallback2 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.BfI.idX, Integer.valueOf(paramInt), paramc, paramd });
        b localb = this.BfI;
        String str = paramd.field_fileUrl;
        p.g(str, "sceneResult.field_fileUrl");
        paramString = com.tencent.mm.plugin.story.i.a.BkN;
        paramInt = com.tencent.mm.plugin.story.i.a.eon();
        paramd = paramd.field_thumbUrl;
        p.g(paramd, "sceneResult.field_thumbUrl");
        paramString = com.tencent.mm.plugin.story.i.a.BkN;
        int i = com.tencent.mm.plugin.story.i.a.eon();
        StringBuilder localStringBuilder = new StringBuilder("upload_ + ");
        paramc = this.BfI.idX;
        paramString = paramc;
        if (paramc == null) {
          paramString = "null";
        }
        localb.b(str, paramInt, paramd, i, paramString);
        this.BfI.BfH.a(0, true, (com.tencent.mm.plugin.story.f.g)this.BfI);
        AppMethodBeat.o(119097);
        return 0;
      }
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        ae.i(this.BfI.TAG, "cdntra cdnCallback3 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.BfI.idX, Integer.valueOf(paramInt), paramc, paramd });
        this.BfI.emS();
        this.BfI.BfH.a(paramd.field_retCode, false, (com.tencent.mm.plugin.story.f.g)this.BfI);
        AppMethodBeat.o(119097);
        return 0;
      }
      if (paramInt != 0)
      {
        ae.i(this.BfI.TAG, "cdntra cdnCallback4 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.BfI.idX, Integer.valueOf(paramInt), paramc, paramd });
        this.BfI.emS();
        this.BfI.BfH.a(paramInt, false, (com.tencent.mm.plugin.story.f.g)this.BfI);
        AppMethodBeat.o(119097);
        return 0;
      }
      ae.d(this.BfI.TAG, "cdntra cdnCallback5 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.BfI.idX, Integer.valueOf(paramInt), paramc, paramd });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.b
 * JD-Core Version:    0.7.0.1
 */