package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.a.g;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.protocal.protobuf.ddp;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.ddz;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import d.l;
import d.v;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload;", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "mPath", "", "thumbPath", "callback", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1;", "cdnMediaType", "", "clientId", "mMd5", "postinfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "sendScene", "st_new", "", "startTime", "useCdnTransClientId", "checkUpload", "", "doUpload", "extInfo", "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "onErrorServer", "", "errCode", "onPostScene", "url", "urlType", "thumbUrl", "thumbType", "meidiaId", "updateMd5Info", "updatePostInfo", "isOk", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.f.g
{
  final String TAG;
  private String clientId;
  String hIq;
  private int iak;
  private long izs;
  private String jYv;
  private final String mPath;
  private final String thumbPath;
  private final com.tencent.mm.plugin.story.i.j zwd;
  private ddz zwi;
  private final a zwj;
  final com.tencent.mm.plugin.story.f.g.a zwk;
  
  public b(com.tencent.mm.plugin.story.i.j paramj, String paramString1, String paramString2, com.tencent.mm.plugin.story.f.g.a parama)
  {
    AppMethodBeat.i(119103);
    this.zwd = paramj;
    this.mPath = paramString1;
    this.thumbPath = paramString2;
    this.zwk = parama;
    this.clientId = "";
    this.jYv = "";
    this.zwi = new ddz();
    this.TAG = "MicroMsg.StorySightCdnUpload";
    this.zwj = new a(this);
    this.izs = ce.azI();
    this.zwi = this.zwd.dZk();
    paramString1 = this.zwi.hkN;
    paramj = paramString1;
    if (paramString1 == null) {
      paramj = "";
    }
    this.clientId = paramj;
    paramString1 = this.zwi.md5;
    paramj = paramString1;
    if (paramString1 == null) {
      paramj = "";
    }
    this.jYv = paramj;
    if (bs.isNullOrNil(this.clientId))
    {
      paramj = bs.Gn();
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
      this.zwi.hkN = this.clientId;
    }
    try
    {
      paramj = this.zwd;
      paramString1 = this.zwi.toByteArray();
      d.g.b.k.g(paramString1, "postinfo.toByteArray()");
      paramj.bD(paramString1);
      paramj = com.tencent.mm.plugin.story.f.j.zsh;
      j.b.dVE().a((int)this.zwd.systemRowid, this.zwd);
      int i = (int)i.aSp(this.mPath);
      ac.i(this.TAG, "storyUpload  videopath %s sightFileSize %d md5 %s", new Object[] { this.mPath, Integer.valueOf(i), this.jYv });
      AppMethodBeat.o(119103);
      return;
    }
    catch (Exception paramj)
    {
      for (;;)
      {
        ac.printErrStackTrace(this.TAG, (Throwable)paramj, "", new Object[0]);
      }
    }
  }
  
  public final boolean b(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(119101);
    d.g.b.k.h(paramString1, "url");
    d.g.b.k.h(paramString2, "thumbUrl");
    d.g.b.k.h(paramString3, "meidiaId");
    ac.d(this.TAG, "upload ok " + paramString1 + "  " + paramString3 + "  " + paramInt1);
    paramString3 = this.zwi;
    Object localObject = a.g.zCh;
    paramString3.FfT = a.g.dYU();
    this.zwi.gLY = 0;
    this.zwi.FjJ = ce.azK();
    paramString3 = this.zwd;
    localObject = this.zwi.toByteArray();
    d.g.b.k.g(localObject, "postinfo.toByteArray()");
    paramString3.bD((byte[])localObject);
    paramString3 = (ddy)this.zwd.dZi().FOc.Etz.get(0);
    paramString3.Url = paramString1;
    paramString3.ndI = paramInt1;
    paramString3.Fjh = paramString2;
    paramString3.ndI = paramInt2;
    f.aDE();
    paramString3.FjC = com.tencent.mm.an.a.BM(this.mPath);
    ac.i(this.TAG, "mediaObj.videomd5 " + paramString3.FjC);
    paramString1 = this.zwd.dZi();
    paramString1.FOc.Etz.set(0, paramString3);
    this.zwd.b(paramString1);
    paramString1 = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dVE().a((int)this.zwd.systemRowid, this.zwd);
    AppMethodBeat.o(119101);
    return true;
  }
  
  final void dWV()
  {
    AppMethodBeat.i(119100);
    ac.i(this.TAG, "snsupload sight by cdn error! " + bs.eWi());
    try
    {
      this.zwi.gLY += 1;
      Object localObject1 = this.zwi;
      Object localObject2 = a.g.zCh;
      ((ddz)localObject1).FfT = a.g.dYV();
      localObject1 = this.zwd;
      localObject2 = this.zwi.toByteArray();
      d.g.b.k.g(localObject2, "postinfo.toByteArray()");
      ((com.tencent.mm.plugin.story.i.j)localObject1).bD((byte[])localObject2);
      localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
      j.b.dVE().a((int)this.zwd.systemRowid, this.zwd);
      AppMethodBeat.o(119100);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(119100);
    }
  }
  
  public final boolean dWW()
  {
    AppMethodBeat.i(119102);
    Object localObject1 = i.aKe(this.mPath);
    if ((!bs.isNullOrNil(this.jYv)) && ((d.g.b.k.g(this.jYv, localObject1) ^ true)))
    {
      ac.i(this.TAG, "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.jYv, localObject1 });
      dWV();
      this.zwk.a(-2, false, (com.tencent.mm.plugin.story.f.g)this);
      AppMethodBeat.o(119102);
      return false;
    }
    localObject1 = new bsz();
    ac.i(this.TAG, "check upload %s %d %s", new Object[] { this.mPath, Integer.valueOf(((bsz)localObject1).rNU), Boolean.valueOf(((bsz)localObject1).FhZ) });
    Object localObject2 = e.asx(this.mPath);
    if (localObject2 != null) {
      ac.i(this.TAG, "mediaInfo: %s", new Object[] { localObject2 });
    }
    if ((this.zwi.FNG & 0x1) == 0) {
      SightVideoJNI.optimizeMP4VFS(this.mPath);
    }
    try
    {
      localObject2 = i.aKe(this.mPath);
      d.g.b.k.g(localObject2, "VFSFileOp.getFileMD5String(mPath)");
      this.jYv = ((String)localObject2);
      this.zwi.md5 = this.jYv;
      this.zwi.FNG |= 0x1;
      localObject2 = this.zwd;
      Object localObject3 = this.zwi.toByteArray();
      d.g.b.k.g(localObject3, "postinfo.toByteArray()");
      ((com.tencent.mm.plugin.story.i.j)localObject2).bD((byte[])localObject3);
      ac.i(this.TAG, "new md5 is %s %s", new Object[] { this.mPath, this.jYv });
      localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
      j.b.dVE().a((int)this.zwd.systemRowid, this.zwd);
      this.hIq = this.clientId;
      localObject2 = new com.tencent.mm.i.g();
      ((com.tencent.mm.i.g)localObject2).frb = ((com.tencent.mm.i.g.a)this.zwj);
      ((com.tencent.mm.i.g)localObject2).field_mediaId = this.hIq;
      ((com.tencent.mm.i.g)localObject2).field_fullpath = this.mPath;
      ((com.tencent.mm.i.g)localObject2).field_thumbpath = this.thumbPath;
      ((com.tencent.mm.i.g)localObject2).field_fileType = 20302;
      ((com.tencent.mm.i.g)localObject2).field_talker = "";
      ((com.tencent.mm.i.g)localObject2).field_priority = com.tencent.mm.i.a.fqp;
      ((com.tencent.mm.i.g)localObject2).field_needStorage = true;
      ((com.tencent.mm.i.g)localObject2).field_isStreamMedia = false;
      ((com.tencent.mm.i.g)localObject2).field_appType = 205;
      ((com.tencent.mm.i.g)localObject2).field_bzScene = 2;
      localObject3 = (c.a)com.tencent.mm.plugin.story.c.a.c.zqE.aqp();
      if (localObject3 != null)
      {
        ac.i(this.TAG, "StoryEncodeElementConfig " + ((c.a)localObject3).duration);
        ((com.tencent.mm.i.g)localObject2).field_largesvideo = (((c.a)localObject3).duration + 3);
        ((com.tencent.mm.i.g)localObject2).frr = 6;
        localObject3 = i.aKe(this.mPath);
        if ((bs.isNullOrNil(this.jYv)) || (!(d.g.b.k.g(this.jYv, localObject3) ^ true))) {
          break label588;
        }
        ac.i(this.TAG, "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.jYv, localObject3 });
        dWV();
        this.zwk.a(-2, false, (com.tencent.mm.plugin.story.f.g)this);
        AppMethodBeat.o(119102);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e(this.TAG, "parseFrom MediaUploadInfo error in updateMd5Info %s", new Object[] { localException.getMessage() });
        continue;
        localException.field_largesvideo = 18;
      }
      label588:
      ac.d(this.TAG, "will addSendTask");
      if (!f.aDD().f(localException))
      {
        ac.e(this.TAG, "cdntra addSendTask failed. clientid:%s", new Object[] { this.hIq });
        this.zwk.a(-3, false, (com.tencent.mm.plugin.story.f.g)this);
        AppMethodBeat.o(119102);
        return false;
      }
      if (!((bsz)localObject1).FhZ) {}
    }
    for (int i = 4;; i = 5)
    {
      this.iak = i;
      AppMethodBeat.o(119102);
      return true;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
  public static final class a
    implements com.tencent.mm.i.g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(119097);
      d.g.b.k.h(paramString, "mediaId");
      if (paramInt == -21005)
      {
        ac.d(this.zwl.TAG, "cdntra cdnCallback1 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.zwl.hIq, Integer.valueOf(paramInt), paramc, paramd });
        this.zwl.zwk.a(0, true, (com.tencent.mm.plugin.story.f.g)this.zwl);
        AppMethodBeat.o(119097);
        return 0;
      }
      if ((paramd != null) && (paramd.field_retCode == 0))
      {
        ac.i(this.zwl.TAG, "cdntra cdnCallback2 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.zwl.hIq, Integer.valueOf(paramInt), paramc, paramd });
        b localb = this.zwl;
        String str = paramd.field_fileUrl;
        d.g.b.k.g(str, "sceneResult.field_fileUrl");
        paramString = com.tencent.mm.plugin.story.i.a.zBQ;
        paramInt = com.tencent.mm.plugin.story.i.a.dYp();
        paramd = paramd.field_thumbUrl;
        d.g.b.k.g(paramd, "sceneResult.field_thumbUrl");
        paramString = com.tencent.mm.plugin.story.i.a.zBQ;
        int i = com.tencent.mm.plugin.story.i.a.dYp();
        StringBuilder localStringBuilder = new StringBuilder("upload_ + ");
        paramc = this.zwl.hIq;
        paramString = paramc;
        if (paramc == null) {
          paramString = "null";
        }
        localb.b(str, paramInt, paramd, i, paramString);
        this.zwl.zwk.a(0, true, (com.tencent.mm.plugin.story.f.g)this.zwl);
        AppMethodBeat.o(119097);
        return 0;
      }
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        ac.i(this.zwl.TAG, "cdntra cdnCallback3 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.zwl.hIq, Integer.valueOf(paramInt), paramc, paramd });
        this.zwl.dWV();
        this.zwl.zwk.a(paramd.field_retCode, false, (com.tencent.mm.plugin.story.f.g)this.zwl);
        AppMethodBeat.o(119097);
        return 0;
      }
      if (paramInt != 0)
      {
        ac.i(this.zwl.TAG, "cdntra cdnCallback4 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.zwl.hIq, Integer.valueOf(paramInt), paramc, paramd });
        this.zwl.dWV();
        this.zwl.zwk.a(paramInt, false, (com.tencent.mm.plugin.story.f.g)this.zwl);
        AppMethodBeat.o(119097);
        return 0;
      }
      ac.d(this.zwl.TAG, "cdntra cdnCallback5 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.zwl.hIq, Integer.valueOf(paramInt), paramc, paramd });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.b
 * JD-Core Version:    0.7.0.1
 */