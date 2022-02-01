package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.a.g;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.enl;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.protocal.protobuf.env;
import com.tencent.mm.protocal.protobuf.eol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload;", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "mPath", "", "thumbPath", "callback", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1;", "cdnMediaType", "", "clientId", "mMd5", "postinfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "sendScene", "st_new", "", "startTime", "useCdnTransClientId", "checkUpload", "", "doUpload", "extInfo", "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "onErrorServer", "", "errCode", "onPostScene", "url", "urlType", "thumbUrl", "thumbType", "meidiaId", "updateMd5Info", "updatePostInfo", "isOk", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.f.g
{
  private final a LKA;
  final com.tencent.mm.plugin.story.f.g.a LKB;
  private final com.tencent.mm.plugin.story.i.j LKu;
  private env LKz;
  final String TAG;
  private String clientId;
  String lPn;
  private long mJB;
  private final String mPath;
  private int mhr;
  private String ovC;
  private final String thumbPath;
  
  public b(com.tencent.mm.plugin.story.i.j paramj, String paramString1, String paramString2, com.tencent.mm.plugin.story.f.g.a parama)
  {
    AppMethodBeat.i(119103);
    this.LKu = paramj;
    this.mPath = paramString1;
    this.thumbPath = paramString2;
    this.LKB = parama;
    this.clientId = "";
    this.ovC = "";
    this.LKz = new env();
    this.TAG = "MicroMsg.StorySightCdnUpload";
    this.LKA = new a(this);
    this.mJB = cm.bfD();
    this.LKz = this.LKu.gge();
    paramString1 = this.LKz.lps;
    paramj = paramString1;
    if (paramString1 == null) {
      paramj = "";
    }
    this.clientId = paramj;
    paramString1 = this.LKz.md5;
    paramj = paramString1;
    if (paramString1 == null) {
      paramj = "";
    }
    this.ovC = paramj;
    if (Util.isNullOrNil(this.clientId))
    {
      paramj = Util.currentTicks();
      paramString1 = kotlin.n.d.UTF_8;
      if (paramj == null)
      {
        paramj = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(119103);
        throw paramj;
      }
      paramj = paramj.getBytes(paramString1);
      p.j(paramj, "(this as java.lang.String).getBytes(charset)");
      this.clientId = com.tencent.mm.b.g.getMessageDigest(paramj);
      this.LKz.lps = this.clientId;
    }
    try
    {
      paramj = this.LKu;
      paramString1 = this.LKz.toByteArray();
      p.j(paramString1, "postinfo.toByteArray()");
      paramj.setPostBuf(paramString1);
      paramj = com.tencent.mm.plugin.story.f.j.LGA;
      j.b.gcw().a((int)this.LKu.systemRowid, this.LKu);
      int i = (int)u.bBQ(this.mPath);
      Log.i(this.TAG, "storyUpload  videopath %s sightFileSize %d md5 %s", new Object[] { this.mPath, Integer.valueOf(i), this.ovC });
      AppMethodBeat.o(119103);
      return;
    }
    catch (Exception paramj)
    {
      for (;;)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramj, "", new Object[0]);
      }
    }
  }
  
  public final boolean c(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(119101);
    p.k(paramString1, "url");
    p.k(paramString2, "thumbUrl");
    p.k(paramString3, "meidiaId");
    Log.d(this.TAG, "upload ok " + paramString1 + "  " + paramString3 + "  " + paramInt1);
    paramString3 = this.LKz;
    Object localObject = a.g.LPX;
    paramString3.TAg = a.g.gfO();
    this.LKz.kQn = 0;
    this.LKz.TEf = cm.bfF();
    paramString3 = this.LKu;
    localObject = this.LKz.toByteArray();
    p.j(localObject, "postinfo.toByteArray()");
    paramString3.setPostBuf((byte[])localObject);
    paramString3 = (enu)this.LKu.ggc().Ura.Sqr.get(0);
    paramString3.Url = paramString1;
    paramString3.rWu = paramInt1;
    paramString3.TDF = paramString2;
    paramString3.rWu = paramInt2;
    com.tencent.mm.aq.f.bkh();
    paramString3.TDY = com.tencent.mm.aq.a.Vu(this.mPath);
    Log.i(this.TAG, "mediaObj.videomd5 " + paramString3.TDY);
    paramString1 = this.LKu.ggc();
    paramString1.Ura.Sqr.set(0, paramString3);
    this.LKu.b(paramString1);
    paramString1 = com.tencent.mm.plugin.story.f.j.LGA;
    j.b.gcw().a((int)this.LKu.systemRowid, this.LKu);
    AppMethodBeat.o(119101);
    return true;
  }
  
  final void gdN()
  {
    AppMethodBeat.i(119100);
    Log.i(this.TAG, "snsupload sight by cdn error! " + Util.getStack());
    try
    {
      this.LKz.kQn += 1;
      Object localObject1 = this.LKz;
      Object localObject2 = a.g.LPX;
      ((env)localObject1).TAg = a.g.gfP();
      localObject1 = this.LKu;
      localObject2 = this.LKz.toByteArray();
      p.j(localObject2, "postinfo.toByteArray()");
      ((com.tencent.mm.plugin.story.i.j)localObject1).setPostBuf((byte[])localObject2);
      localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
      j.b.gcw().a((int)this.LKu.systemRowid, this.LKu);
      AppMethodBeat.o(119100);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(119100);
    }
  }
  
  public final boolean gdO()
  {
    AppMethodBeat.i(119102);
    Object localObject1 = u.buc(this.mPath);
    if ((!Util.isNullOrNil(this.ovC)) && ((p.h(this.ovC, localObject1) ^ true)))
    {
      Log.i(this.TAG, "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.ovC, localObject1 });
      gdN();
      this.LKB.a(-2, false, (com.tencent.mm.plugin.story.f.g)this);
      AppMethodBeat.o(119102);
      return false;
    }
    localObject1 = new cuv();
    Log.i(this.TAG, "check upload %s %d %s", new Object[] { this.mPath, Integer.valueOf(((cuv)localObject1).ABK), Boolean.valueOf(((cuv)localObject1).TCA) });
    Object localObject2 = com.tencent.mm.plugin.sight.base.f.aYg(this.mPath);
    if (localObject2 != null) {
      Log.i(this.TAG, "mediaInfo: %s", new Object[] { localObject2 });
    }
    if ((this.LKz.UqD & 0x1) == 0) {
      SightVideoJNI.optimizeMP4VFS(this.mPath);
    }
    try
    {
      localObject2 = u.buc(this.mPath);
      p.j(localObject2, "VFSFileOp.getFileMD5String(mPath)");
      this.ovC = ((String)localObject2);
      this.LKz.md5 = this.ovC;
      this.LKz.UqD |= 0x1;
      localObject2 = this.LKu;
      Object localObject3 = this.LKz.toByteArray();
      p.j(localObject3, "postinfo.toByteArray()");
      ((com.tencent.mm.plugin.story.i.j)localObject2).setPostBuf((byte[])localObject3);
      Log.i(this.TAG, "new md5 is %s %s", new Object[] { this.mPath, this.ovC });
      localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
      j.b.gcw().a((int)this.LKu.systemRowid, this.LKu);
      this.lPn = this.clientId;
      localObject2 = new com.tencent.mm.i.g();
      ((com.tencent.mm.i.g)localObject2).taskName = "task_StorySightCdnUpload";
      ((com.tencent.mm.i.g)localObject2).iUG = ((com.tencent.mm.i.g.a)this.LKA);
      ((com.tencent.mm.i.g)localObject2).field_mediaId = this.lPn;
      ((com.tencent.mm.i.g)localObject2).field_fullpath = this.mPath;
      ((com.tencent.mm.i.g)localObject2).field_thumbpath = this.thumbPath;
      ((com.tencent.mm.i.g)localObject2).field_fileType = 20302;
      ((com.tencent.mm.i.g)localObject2).field_talker = "";
      ((com.tencent.mm.i.g)localObject2).field_priority = com.tencent.mm.i.a.iTU;
      ((com.tencent.mm.i.g)localObject2).field_needStorage = true;
      ((com.tencent.mm.i.g)localObject2).field_isStreamMedia = false;
      ((com.tencent.mm.i.g)localObject2).field_appType = 205;
      ((com.tencent.mm.i.g)localObject2).field_bzScene = 2;
      localObject3 = (c.a)com.tencent.mm.plugin.story.c.a.c.LFb.aUb();
      if (localObject3 != null)
      {
        Log.i(this.TAG, "StoryEncodeElementConfig " + ((c.a)localObject3).duration);
        ((com.tencent.mm.i.g)localObject2).field_largesvideo = (((c.a)localObject3).duration + 3);
        ((com.tencent.mm.i.g)localObject2).iUX = 6;
        localObject3 = u.buc(this.mPath);
        if ((Util.isNullOrNil(this.ovC)) || (!(p.h(this.ovC, localObject3) ^ true))) {
          break label596;
        }
        Log.i(this.TAG, "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.ovC, localObject3 });
        gdN();
        this.LKB.a(-2, false, (com.tencent.mm.plugin.story.f.g)this);
        AppMethodBeat.o(119102);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e(this.TAG, "parseFrom MediaUploadInfo error in updateMd5Info %s", new Object[] { localException.getMessage() });
        continue;
        localException.field_largesvideo = 18;
      }
      label596:
      Log.d(this.TAG, "will addSendTask");
      if (!com.tencent.mm.aq.f.bkg().f(localException))
      {
        Log.e(this.TAG, "cdntra addSendTask failed. clientid:%s", new Object[] { this.lPn });
        this.LKB.a(-3, false, (com.tencent.mm.plugin.story.f.g)this);
        AppMethodBeat.o(119102);
        return false;
      }
      if (!((cuv)localObject1).TCA) {}
    }
    for (int i = 4;; i = 5)
    {
      this.mhr = i;
      AppMethodBeat.o(119102);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
  public static final class a
    implements com.tencent.mm.i.g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(119097);
      p.k(paramString, "mediaId");
      if (paramInt == -21005)
      {
        Log.d(this.LKC.TAG, "cdntra cdnCallback1 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.LKC.lPn, Integer.valueOf(paramInt), paramc, paramd });
        this.LKC.LKB.a(0, true, (com.tencent.mm.plugin.story.f.g)this.LKC);
        AppMethodBeat.o(119097);
        return 0;
      }
      if ((paramd != null) && (paramd.field_retCode == 0))
      {
        Log.i(this.LKC.TAG, "cdntra cdnCallback2 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.LKC.lPn, Integer.valueOf(paramInt), paramc, paramd });
        b localb = this.LKC;
        String str = paramd.field_fileUrl;
        p.j(str, "sceneResult.field_fileUrl");
        paramString = com.tencent.mm.plugin.story.i.a.LPG;
        paramInt = com.tencent.mm.plugin.story.i.a.gfj();
        paramd = paramd.field_thumbUrl;
        p.j(paramd, "sceneResult.field_thumbUrl");
        paramString = com.tencent.mm.plugin.story.i.a.LPG;
        int i = com.tencent.mm.plugin.story.i.a.gfj();
        StringBuilder localStringBuilder = new StringBuilder("upload_ + ");
        paramc = this.LKC.lPn;
        paramString = paramc;
        if (paramc == null) {
          paramString = "null";
        }
        localb.c(str, paramInt, paramd, i, paramString);
        this.LKC.LKB.a(0, true, (com.tencent.mm.plugin.story.f.g)this.LKC);
        AppMethodBeat.o(119097);
        return 0;
      }
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        Log.i(this.LKC.TAG, "cdntra cdnCallback3 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.LKC.lPn, Integer.valueOf(paramInt), paramc, paramd });
        this.LKC.gdN();
        this.LKC.LKB.a(paramd.field_retCode, false, (com.tencent.mm.plugin.story.f.g)this.LKC);
        AppMethodBeat.o(119097);
        return 0;
      }
      if (paramInt != 0)
      {
        Log.i(this.LKC.TAG, "cdntra cdnCallback4 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.LKC.lPn, Integer.valueOf(paramInt), paramc, paramd });
        this.LKC.gdN();
        this.LKC.LKB.a(paramInt, false, (com.tencent.mm.plugin.story.f.g)this.LKC);
        AppMethodBeat.o(119097);
        return 0;
      }
      Log.d(this.LKC.TAG, "cdntra cdnCallback5 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.LKC.lPn, Integer.valueOf(paramInt), paramc, paramd });
      AppMethodBeat.o(119097);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(119098);
      p.k(paramString, "mediaId");
      p.k(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(119098);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(119099);
      p.k(paramString, "mediaId");
      p.k(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(119099);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.b
 * JD-Core Version:    0.7.0.1
 */