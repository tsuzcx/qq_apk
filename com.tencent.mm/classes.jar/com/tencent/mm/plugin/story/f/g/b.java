package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.a.g;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.edu;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload;", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "mPath", "", "thumbPath", "callback", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1;", "cdnMediaType", "", "clientId", "mMd5", "postinfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "sendScene", "st_new", "", "startTime", "useCdnTransClientId", "checkUpload", "", "doUpload", "extInfo", "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "onErrorServer", "", "errCode", "onPostScene", "url", "urlType", "thumbUrl", "thumbType", "meidiaId", "updateMd5Info", "updatePostInfo", "isOk", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.f.g
{
  private final com.tencent.mm.plugin.story.i.j Fqr;
  private edu Fqw;
  private final a Fqx;
  final com.tencent.mm.plugin.story.f.g.a Fqy;
  final String TAG;
  private String clientId;
  String iYT;
  private long jSo;
  private int jrO;
  private String lAl;
  private final String mPath;
  private final String thumbPath;
  
  public b(com.tencent.mm.plugin.story.i.j paramj, String paramString1, String paramString2, com.tencent.mm.plugin.story.f.g.a parama)
  {
    AppMethodBeat.i(119103);
    this.Fqr = paramj;
    this.mPath = paramString1;
    this.thumbPath = paramString2;
    this.Fqy = parama;
    this.clientId = "";
    this.lAl = "";
    this.Fqw = new edu();
    this.TAG = "MicroMsg.StorySightCdnUpload";
    this.Fqx = new a(this);
    this.jSo = cl.aWz();
    this.Fqw = this.Fqr.frI();
    paramString1 = this.Fqw.izX;
    paramj = paramString1;
    if (paramString1 == null) {
      paramj = "";
    }
    this.clientId = paramj;
    paramString1 = this.Fqw.md5;
    paramj = paramString1;
    if (paramString1 == null) {
      paramj = "";
    }
    this.lAl = paramj;
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
      p.g(paramj, "(this as java.lang.String).getBytes(charset)");
      this.clientId = com.tencent.mm.b.g.getMessageDigest(paramj);
      this.Fqw.izX = this.clientId;
    }
    try
    {
      paramj = this.Fqr;
      paramString1 = this.Fqw.toByteArray();
      p.g(paramString1, "postinfo.toByteArray()");
      paramj.setPostBuf(paramString1);
      paramj = com.tencent.mm.plugin.story.f.j.Fmy;
      j.b.foc().a((int)this.Fqr.systemRowid, this.Fqr);
      int i = (int)s.boW(this.mPath);
      Log.i(this.TAG, "storyUpload  videopath %s sightFileSize %d md5 %s", new Object[] { this.mPath, Integer.valueOf(i), this.lAl });
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
  
  public final boolean b(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(119101);
    p.h(paramString1, "url");
    p.h(paramString2, "thumbUrl");
    p.h(paramString3, "meidiaId");
    Log.d(this.TAG, "upload ok " + paramString1 + "  " + paramString3 + "  " + paramInt1);
    paramString3 = this.Fqw;
    Object localObject = a.g.FvU;
    paramString3.Mpa = a.g.frs();
    this.Fqw.ibG = 0;
    this.Fqw.MsZ = cl.aWB();
    paramString3 = this.Fqr;
    localObject = this.Fqw.toByteArray();
    p.g(localObject, "postinfo.toByteArray()");
    paramString3.setPostBuf((byte[])localObject);
    paramString3 = (edt)this.Fqr.frG().NeB.LoV.get(0);
    paramString3.Url = paramString1;
    paramString3.oUv = paramInt1;
    paramString3.Msz = paramString2;
    paramString3.oUv = paramInt2;
    f.baR();
    paramString3.MsS = com.tencent.mm.an.a.NX(this.mPath);
    Log.i(this.TAG, "mediaObj.videomd5 " + paramString3.MsS);
    paramString1 = this.Fqr.frG();
    paramString1.NeB.LoV.set(0, paramString3);
    this.Fqr.b(paramString1);
    paramString1 = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.foc().a((int)this.Fqr.systemRowid, this.Fqr);
    AppMethodBeat.o(119101);
    return true;
  }
  
  final void fpt()
  {
    AppMethodBeat.i(119100);
    Log.i(this.TAG, "snsupload sight by cdn error! " + Util.getStack());
    try
    {
      this.Fqw.ibG += 1;
      Object localObject1 = this.Fqw;
      Object localObject2 = a.g.FvU;
      ((edu)localObject1).Mpa = a.g.frt();
      localObject1 = this.Fqr;
      localObject2 = this.Fqw.toByteArray();
      p.g(localObject2, "postinfo.toByteArray()");
      ((com.tencent.mm.plugin.story.i.j)localObject1).setPostBuf((byte[])localObject2);
      localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
      j.b.foc().a((int)this.Fqr.systemRowid, this.Fqr);
      AppMethodBeat.o(119100);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(119100);
    }
  }
  
  public final boolean fpu()
  {
    AppMethodBeat.i(119102);
    Object localObject1 = s.bhK(this.mPath);
    if ((!Util.isNullOrNil(this.lAl)) && ((p.j(this.lAl, localObject1) ^ true)))
    {
      Log.i(this.TAG, "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.lAl, localObject1 });
      fpt();
      this.Fqy.a(-2, false, (com.tencent.mm.plugin.story.f.g)this);
      AppMethodBeat.o(119102);
      return false;
    }
    localObject1 = new cly();
    Log.i(this.TAG, "check upload %s %d %s", new Object[] { this.mPath, Integer.valueOf(((cly)localObject1).vUh), Boolean.valueOf(((cly)localObject1).Mrn) });
    Object localObject2 = e.aNx(this.mPath);
    if (localObject2 != null) {
      Log.i(this.TAG, "mediaInfo: %s", new Object[] { localObject2 });
    }
    if ((this.Fqw.Nee & 0x1) == 0) {
      SightVideoJNI.optimizeMP4VFS(this.mPath);
    }
    try
    {
      localObject2 = s.bhK(this.mPath);
      p.g(localObject2, "VFSFileOp.getFileMD5String(mPath)");
      this.lAl = ((String)localObject2);
      this.Fqw.md5 = this.lAl;
      this.Fqw.Nee |= 0x1;
      localObject2 = this.Fqr;
      Object localObject3 = this.Fqw.toByteArray();
      p.g(localObject3, "postinfo.toByteArray()");
      ((com.tencent.mm.plugin.story.i.j)localObject2).setPostBuf((byte[])localObject3);
      Log.i(this.TAG, "new md5 is %s %s", new Object[] { this.mPath, this.lAl });
      localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
      j.b.foc().a((int)this.Fqr.systemRowid, this.Fqr);
      this.iYT = this.clientId;
      localObject2 = new com.tencent.mm.i.g();
      ((com.tencent.mm.i.g)localObject2).taskName = "task_StorySightCdnUpload";
      ((com.tencent.mm.i.g)localObject2).gqy = ((com.tencent.mm.i.g.a)this.Fqx);
      ((com.tencent.mm.i.g)localObject2).field_mediaId = this.iYT;
      ((com.tencent.mm.i.g)localObject2).field_fullpath = this.mPath;
      ((com.tencent.mm.i.g)localObject2).field_thumbpath = this.thumbPath;
      ((com.tencent.mm.i.g)localObject2).field_fileType = 20302;
      ((com.tencent.mm.i.g)localObject2).field_talker = "";
      ((com.tencent.mm.i.g)localObject2).field_priority = com.tencent.mm.i.a.gpM;
      ((com.tencent.mm.i.g)localObject2).field_needStorage = true;
      ((com.tencent.mm.i.g)localObject2).field_isStreamMedia = false;
      ((com.tencent.mm.i.g)localObject2).field_appType = 205;
      ((com.tencent.mm.i.g)localObject2).field_bzScene = 2;
      localObject3 = (c.a)com.tencent.mm.plugin.story.c.a.c.FkZ.aLT();
      if (localObject3 != null)
      {
        Log.i(this.TAG, "StoryEncodeElementConfig " + ((c.a)localObject3).duration);
        ((com.tencent.mm.i.g)localObject2).field_largesvideo = (((c.a)localObject3).duration + 3);
        ((com.tencent.mm.i.g)localObject2).gqP = 6;
        localObject3 = s.bhK(this.mPath);
        if ((Util.isNullOrNil(this.lAl)) || (!(p.j(this.lAl, localObject3) ^ true))) {
          break label596;
        }
        Log.i(this.TAG, "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.lAl, localObject3 });
        fpt();
        this.Fqy.a(-2, false, (com.tencent.mm.plugin.story.f.g)this);
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
      if (!f.baQ().f(localException))
      {
        Log.e(this.TAG, "cdntra addSendTask failed. clientid:%s", new Object[] { this.iYT });
        this.Fqy.a(-3, false, (com.tencent.mm.plugin.story.f.g)this);
        AppMethodBeat.o(119102);
        return false;
      }
      if (!((cly)localObject1).Mrn) {}
    }
    for (int i = 4;; i = 5)
    {
      this.jrO = i;
      AppMethodBeat.o(119102);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
  public static final class a
    implements com.tencent.mm.i.g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(119097);
      p.h(paramString, "mediaId");
      if (paramInt == -21005)
      {
        Log.d(this.Fqz.TAG, "cdntra cdnCallback1 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.Fqz.iYT, Integer.valueOf(paramInt), paramc, paramd });
        this.Fqz.Fqy.a(0, true, (com.tencent.mm.plugin.story.f.g)this.Fqz);
        AppMethodBeat.o(119097);
        return 0;
      }
      if ((paramd != null) && (paramd.field_retCode == 0))
      {
        Log.i(this.Fqz.TAG, "cdntra cdnCallback2 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.Fqz.iYT, Integer.valueOf(paramInt), paramc, paramd });
        b localb = this.Fqz;
        String str = paramd.field_fileUrl;
        p.g(str, "sceneResult.field_fileUrl");
        paramString = com.tencent.mm.plugin.story.i.a.FvD;
        paramInt = com.tencent.mm.plugin.story.i.a.fqN();
        paramd = paramd.field_thumbUrl;
        p.g(paramd, "sceneResult.field_thumbUrl");
        paramString = com.tencent.mm.plugin.story.i.a.FvD;
        int i = com.tencent.mm.plugin.story.i.a.fqN();
        StringBuilder localStringBuilder = new StringBuilder("upload_ + ");
        paramc = this.Fqz.iYT;
        paramString = paramc;
        if (paramc == null) {
          paramString = "null";
        }
        localb.b(str, paramInt, paramd, i, paramString);
        this.Fqz.Fqy.a(0, true, (com.tencent.mm.plugin.story.f.g)this.Fqz);
        AppMethodBeat.o(119097);
        return 0;
      }
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        Log.i(this.Fqz.TAG, "cdntra cdnCallback3 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.Fqz.iYT, Integer.valueOf(paramInt), paramc, paramd });
        this.Fqz.fpt();
        this.Fqz.Fqy.a(paramd.field_retCode, false, (com.tencent.mm.plugin.story.f.g)this.Fqz);
        AppMethodBeat.o(119097);
        return 0;
      }
      if (paramInt != 0)
      {
        Log.i(this.Fqz.TAG, "cdntra cdnCallback4 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.Fqz.iYT, Integer.valueOf(paramInt), paramc, paramd });
        this.Fqz.fpt();
        this.Fqz.Fqy.a(paramInt, false, (com.tencent.mm.plugin.story.f.g)this.Fqz);
        AppMethodBeat.o(119097);
        return 0;
      }
      Log.d(this.Fqz.TAG, "cdntra cdnCallback5 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.Fqz.iYT, Integer.valueOf(paramInt), paramc, paramd });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.b
 * JD-Core Version:    0.7.0.1
 */