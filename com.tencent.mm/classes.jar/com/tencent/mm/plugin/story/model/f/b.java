package com.tencent.mm.plugin.story.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.h.a.g;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.fij;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.protocal.protobuf.fit;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload;", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "mPath", "", "thumbPath", "callback", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1;", "cdnMediaType", "", "clientId", "mMd5", "postinfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "sendScene", "st_new", "", "startTime", "useCdnTransClientId", "checkUpload", "", "doUpload", "extInfo", "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "onErrorServer", "", "errCode", "onPostScene", "url", "urlType", "thumbUrl", "thumbType", "meidiaId", "updateMd5Info", "updatePostInfo", "isOk", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.plugin.story.model.g
{
  private final j SnL;
  final com.tencent.mm.plugin.story.model.g.a SnQ;
  private fit SnR;
  private final a SnS;
  final String TAG;
  private String clientId;
  private final String mPath;
  String oHX;
  private long osG;
  private int paC;
  private String ryW;
  private final String thumbPath;
  
  public b(j paramj, String paramString1, String paramString2, com.tencent.mm.plugin.story.model.g.a parama)
  {
    AppMethodBeat.i(119103);
    this.SnL = paramj;
    this.mPath = paramString1;
    this.thumbPath = paramString2;
    this.SnQ = parama;
    this.clientId = "";
    this.ryW = "";
    this.SnR = new fit();
    this.TAG = "MicroMsg.StorySightCdnUpload";
    this.SnS = new a(this);
    this.osG = cn.bDv();
    this.SnR = this.SnL.hzv();
    paramString1 = this.SnR.nUv;
    paramj = paramString1;
    if (paramString1 == null) {
      paramj = "";
    }
    this.clientId = paramj;
    paramString1 = this.SnR.md5;
    paramj = paramString1;
    if (paramString1 == null) {
      paramj = "";
    }
    this.ryW = paramj;
    if (Util.isNullOrNil(this.clientId))
    {
      paramj = s.X("", Long.valueOf(Util.currentTicks()));
      paramString1 = kotlin.n.d.UTF_8;
      if (paramj == null)
      {
        paramj = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(119103);
        throw paramj;
      }
      paramj = paramj.getBytes(paramString1);
      s.s(paramj, "(this as java.lang.String).getBytes(charset)");
      this.clientId = com.tencent.mm.b.g.getMessageDigest(paramj);
      this.SnR.nUv = this.clientId;
    }
    try
    {
      paramj = this.SnL;
      paramString1 = this.SnR.toByteArray();
      s.s(paramString1, "postinfo.toByteArray()");
      paramj.setPostBuf(paramString1);
      paramj = StoryCore.SjP;
      StoryCore.b.hvR().a((int)this.SnL.systemRowid, this.SnL);
      int i = (int)y.bEl(this.mPath);
      Log.i(this.TAG, "storyUpload  videopath %s sightFileSize %d md5 %s", new Object[] { this.mPath, Integer.valueOf(i), this.ryW });
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
    s.u(paramString1, "url");
    s.u(paramString2, "thumbUrl");
    s.u(paramString3, "meidiaId");
    Log.d(this.TAG, "upload ok " + paramString1 + "  " + paramString3 + "  " + paramInt1);
    paramString3 = this.SnR;
    Object localObject = a.g.SsG;
    paramString3.aaPu = a.g.hzg();
    this.SnR.nrQ = 0;
    this.SnR.aaTL = cn.getSyncServerTimeSecond();
    paramString3 = this.SnL;
    localObject = this.SnR.toByteArray();
    s.s(localObject, "postinfo.toByteArray()");
    paramString3.setPostBuf((byte[])localObject);
    paramString3 = (fis)this.SnL.hzt().abJZ.Zpr.get(0);
    paramString3.Url = paramString1;
    paramString3.vhJ = paramInt1;
    paramString3.aaTl = paramString2;
    paramString3.vhJ = paramInt2;
    com.tencent.mm.modelcdntran.k.bHX();
    paramString3.aaTE = com.tencent.mm.modelcdntran.d.Nu(this.mPath);
    Log.i(this.TAG, s.X("mediaObj.videomd5 ", paramString3.aaTE));
    paramString1 = this.SnL.hzt();
    paramString1.abJZ.Zpr.set(0, paramString3);
    this.SnL.b(paramString1);
    paramString1 = StoryCore.SjP;
    StoryCore.b.hvR().a((int)this.SnL.systemRowid, this.SnL);
    AppMethodBeat.o(119101);
    return true;
  }
  
  final void hxh()
  {
    AppMethodBeat.i(119100);
    Log.i(this.TAG, s.X("snsupload sight by cdn error! ", Util.getStack()));
    try
    {
      this.SnR.nrQ += 1;
      Object localObject1 = this.SnR;
      Object localObject2 = a.g.SsG;
      ((fit)localObject1).aaPu = a.g.hzh();
      localObject1 = this.SnL;
      localObject2 = this.SnR.toByteArray();
      s.s(localObject2, "postinfo.toByteArray()");
      ((j)localObject1).setPostBuf((byte[])localObject2);
      localObject1 = StoryCore.SjP;
      StoryCore.b.hvR().a((int)this.SnL.systemRowid, this.SnL);
      AppMethodBeat.o(119100);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(119100);
    }
  }
  
  public final boolean hxi()
  {
    AppMethodBeat.i(119102);
    Object localObject1 = y.bub(this.mPath);
    if ((!Util.isNullOrNil(this.ryW)) && (!s.p(this.ryW, localObject1)))
    {
      Log.i(this.TAG, "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.ryW, localObject1 });
      hxh();
      this.SnQ.a(-2, false, (com.tencent.mm.plugin.story.model.g)this);
      AppMethodBeat.o(119102);
      return false;
    }
    localObject1 = new dmb();
    Log.i(this.TAG, "check upload %s %d %s", new Object[] { this.mPath, Integer.valueOf(((dmb)localObject1).Gad), Boolean.valueOf(((dmb)localObject1).aaSg) });
    Object localObject2 = f.aVX(this.mPath);
    if (localObject2 != null) {
      Log.i(this.TAG, "mediaInfo: %s", new Object[] { localObject2 });
    }
    if ((this.SnR.abJC & 0x1) == 0) {
      SightVideoJNI.optimizeMP4VFS(this.mPath);
    }
    try
    {
      localObject2 = y.bub(this.mPath);
      s.s(localObject2, "getFileMD5String(mPath)");
      this.ryW = ((String)localObject2);
      this.SnR.md5 = this.ryW;
      this.SnR.abJC |= 0x1;
      localObject2 = this.SnL;
      Object localObject3 = this.SnR.toByteArray();
      s.s(localObject3, "postinfo.toByteArray()");
      ((j)localObject2).setPostBuf((byte[])localObject3);
      Log.i(this.TAG, "new md5 is %s %s", new Object[] { this.mPath, this.ryW });
      localObject2 = StoryCore.SjP;
      StoryCore.b.hvR().a((int)this.SnL.systemRowid, this.SnL);
      this.oHX = this.clientId;
      localObject2 = new com.tencent.mm.g.g();
      ((com.tencent.mm.g.g)localObject2).taskName = "task_StorySightCdnUpload";
      ((com.tencent.mm.g.g)localObject2).lwL = ((com.tencent.mm.g.g.a)this.SnS);
      ((com.tencent.mm.g.g)localObject2).field_mediaId = this.oHX;
      ((com.tencent.mm.g.g)localObject2).field_fullpath = this.mPath;
      ((com.tencent.mm.g.g)localObject2).field_thumbpath = this.thumbPath;
      ((com.tencent.mm.g.g)localObject2).field_fileType = 20302;
      ((com.tencent.mm.g.g)localObject2).field_talker = "";
      ((com.tencent.mm.g.g)localObject2).field_priority = com.tencent.mm.g.a.lvZ;
      ((com.tencent.mm.g.g)localObject2).field_needStorage = true;
      ((com.tencent.mm.g.g)localObject2).field_isStreamMedia = false;
      ((com.tencent.mm.g.g)localObject2).field_appType = 205;
      ((com.tencent.mm.g.g)localObject2).field_bzScene = 2;
      localObject3 = (c.a)com.tencent.mm.plugin.story.c.a.c.SiN.boF();
      if (localObject3 != null)
      {
        Log.i(this.TAG, s.X("StoryEncodeElementConfig ", Integer.valueOf(((c.a)localObject3).duration)));
        ((com.tencent.mm.g.g)localObject2).field_largesvideo = (((c.a)localObject3).duration + 3);
        ((com.tencent.mm.g.g)localObject2).lxc = 6;
        localObject3 = y.bub(this.mPath);
        if ((Util.isNullOrNil(this.ryW)) || (s.p(this.ryW, localObject3))) {
          break label585;
        }
        Log.i(this.TAG, "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.ryW, localObject3 });
        hxh();
        this.SnQ.a(-2, false, (com.tencent.mm.plugin.story.model.g)this);
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
      label585:
      Log.d(this.TAG, "will addSendTask");
      if (!com.tencent.mm.modelcdntran.k.bHW().g(localException))
      {
        Log.e(this.TAG, "cdntra addSendTask failed. clientid:%s", new Object[] { this.oHX });
        this.SnQ.a(-3, false, (com.tencent.mm.plugin.story.model.g)this);
        AppMethodBeat.o(119102);
        return false;
      }
      if (!((dmb)localObject1).aaSg) {}
    }
    for (int i = 4;; i = 5)
    {
      this.paC = i;
      AppMethodBeat.o(119102);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.g.g.a
  {
    a(b paramb) {}
    
    public final int a(String paramString, int paramInt, com.tencent.mm.g.c paramc, com.tencent.mm.g.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(119097);
      s.u(paramString, "mediaId");
      if (paramInt == -21005)
      {
        Log.d(this.SnT.TAG, "cdntra cdnCallback1 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.SnT.oHX, Integer.valueOf(paramInt), paramc, paramd });
        this.SnT.SnQ.a(0, true, (com.tencent.mm.plugin.story.model.g)this.SnT);
        AppMethodBeat.o(119097);
        return 0;
      }
      if ((paramd != null) && (paramd.field_retCode == 0))
      {
        Log.i(this.SnT.TAG, "cdntra cdnCallback2 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.SnT.oHX, Integer.valueOf(paramInt), paramc, paramd });
        b localb = this.SnT;
        String str = paramd.field_fileUrl;
        s.s(str, "sceneResult.field_fileUrl");
        paramString = com.tencent.mm.plugin.story.h.a.Sry;
        paramInt = com.tencent.mm.plugin.story.h.a.hyB();
        paramd = paramd.field_thumbUrl;
        s.s(paramd, "sceneResult.field_thumbUrl");
        paramString = com.tencent.mm.plugin.story.h.a.Sry;
        int i = com.tencent.mm.plugin.story.h.a.hyB();
        paramc = this.SnT.oHX;
        paramString = paramc;
        if (paramc == null) {
          paramString = "null";
        }
        localb.b(str, paramInt, paramd, i, s.X("upload_ + ", paramString));
        this.SnT.SnQ.a(0, true, (com.tencent.mm.plugin.story.model.g)this.SnT);
        AppMethodBeat.o(119097);
        return 0;
      }
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        Log.i(this.SnT.TAG, "cdntra cdnCallback3 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.SnT.oHX, Integer.valueOf(paramInt), paramc, paramd });
        this.SnT.hxh();
        this.SnT.SnQ.a(paramd.field_retCode, false, (com.tencent.mm.plugin.story.model.g)this.SnT);
        AppMethodBeat.o(119097);
        return 0;
      }
      if (paramInt != 0)
      {
        Log.i(this.SnT.TAG, "cdntra cdnCallback4 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.SnT.oHX, Integer.valueOf(paramInt), paramc, paramd });
        this.SnT.hxh();
        this.SnT.SnQ.a(paramInt, false, (com.tencent.mm.plugin.story.model.g)this.SnT);
        AppMethodBeat.o(119097);
        return 0;
      }
      Log.d(this.SnT.TAG, "cdntra cdnCallback5 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.SnT.oHX, Integer.valueOf(paramInt), paramc, paramd });
      AppMethodBeat.o(119097);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(119098);
      s.u(paramString, "mediaId");
      s.u(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(119098);
    }
    
    public final byte[] h(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(119099);
      s.u(paramString, "mediaId");
      s.u(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(119099);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.f.b
 * JD-Core Version:    0.7.0.1
 */