package com.tencent.mm.plugin.story.model.g;

import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.story.c.a.c;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.h.a.g;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.chm;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload;", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "mPath", "", "thumbPath", "callback", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1;", "cdnMediaType", "", "clientId", "mMd5", "postinfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "sendScene", "st_new", "", "startTime", "useCdnTransClientId", "checkUpload", "", "doUpload", "extInfo", "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "onErrorServer", "", "errCode", "onPostScene", "url", "urlType", "thumbUrl", "thumbType", "meidiaId", "updateMd5Info", "updatePostInfo", "isOk", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.model.g
{
  final String TAG;
  private String clientId;
  String fFo;
  private int fWX;
  private String hyD;
  private final String mPath;
  private long rfC;
  private final com.tencent.mm.plugin.story.h.j szQ;
  private chm szX;
  private final b.a szY;
  final com.tencent.mm.plugin.story.model.g.a szZ;
  private final String thumbPath;
  
  public b(com.tencent.mm.plugin.story.h.j paramj, String paramString1, String paramString2, com.tencent.mm.plugin.story.model.g.a parama)
  {
    AppMethodBeat.i(109449);
    this.szQ = paramj;
    this.mPath = paramString1;
    this.thumbPath = paramString2;
    this.szZ = parama;
    this.clientId = "";
    this.hyD = "";
    this.szX = new chm();
    this.TAG = "MicroMsg.StorySightCdnUpload";
    this.szY = new b.a(this);
    this.rfC = cb.abq();
    this.szX = this.szQ.cFb();
    paramString1 = this.szX.pIw;
    paramj = paramString1;
    if (paramString1 == null) {
      paramj = "";
    }
    this.clientId = paramj;
    paramString1 = this.szX.cqq;
    paramj = paramString1;
    if (paramString1 == null) {
      paramj = "";
    }
    this.hyD = paramj;
    if (bo.isNullOrNil(this.clientId))
    {
      paramj = bo.yB();
      paramString1 = a.l.d.UTF_8;
      if (paramj == null)
      {
        paramj = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(109449);
        throw paramj;
      }
      paramj = paramj.getBytes(paramString1);
      a.f.b.j.p(paramj, "(this as java.lang.String).getBytes(charset)");
      this.clientId = com.tencent.mm.a.g.w(paramj);
      this.szX.pIw = this.clientId;
    }
    try
    {
      paramj = this.szQ;
      paramString1 = this.szX.toByteArray();
      a.f.b.j.p(paramString1, "postinfo.toByteArray()");
      paramj.bl(paramString1);
      paramj = com.tencent.mm.plugin.story.model.j.svi;
      j.b.cAB().a((int)this.szQ.systemRowid, this.szQ);
      int i = (int)e.avI(this.mPath);
      ab.i(this.TAG, "storyUpload  videopath %s sightFileSize %d md5 %s", new Object[] { this.mPath, Integer.valueOf(i), this.hyD });
      AppMethodBeat.o(109449);
      return;
    }
    catch (Exception paramj)
    {
      for (;;)
      {
        ab.printErrStackTrace(this.TAG, (Throwable)paramj, "", new Object[0]);
      }
    }
  }
  
  public final boolean a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(109447);
    a.f.b.j.q(paramString1, "url");
    a.f.b.j.q(paramString2, "thumbUrl");
    a.f.b.j.q(paramString3, "meidiaId");
    ab.d(this.TAG, "upload ok " + paramString1 + "  " + paramString3 + "  " + paramInt1);
    paramString3 = this.szX;
    Object localObject = a.g.sGo;
    paramString3.nkT = a.g.cEG();
    this.szX.ePG = 0;
    this.szX.xst = cb.abr();
    paramString3 = this.szQ;
    localObject = this.szX.toByteArray();
    a.f.b.j.p(localObject, "postinfo.toByteArray()");
    paramString3.bl((byte[])localObject);
    paramString3 = (chl)this.szQ.cEY().xSK.wOa.get(0);
    paramString3.Url = paramString1;
    paramString3.jKs = paramInt1;
    paramString3.xrS = paramString2;
    paramString3.jKs = paramInt2;
    f.afP();
    paramString3.xsn = com.tencent.mm.al.a.sE(this.mPath);
    ab.i(this.TAG, "mediaObj.videomd5 " + paramString3.xsn);
    paramString1 = this.szQ.cEY();
    paramString1.xSK.wOa.set(0, paramString3);
    this.szQ.b(paramString1);
    paramString1 = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAB().a((int)this.szQ.systemRowid, this.szQ);
    AppMethodBeat.o(109447);
    return true;
  }
  
  final void cCf()
  {
    AppMethodBeat.i(109446);
    ab.i(this.TAG, "snsupload sight by cdn error! " + bo.dtY());
    try
    {
      this.szX.ePG += 1;
      Object localObject1 = this.szX;
      Object localObject2 = a.g.sGo;
      ((chm)localObject1).nkT = a.g.cEH();
      localObject1 = this.szQ;
      localObject2 = this.szX.toByteArray();
      a.f.b.j.p(localObject2, "postinfo.toByteArray()");
      ((com.tencent.mm.plugin.story.h.j)localObject1).bl((byte[])localObject2);
      localObject1 = com.tencent.mm.plugin.story.model.j.svi;
      j.b.cAB().a((int)this.szQ.systemRowid, this.szQ);
      AppMethodBeat.o(109446);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(109446);
    }
  }
  
  public final boolean cCg()
  {
    AppMethodBeat.i(109448);
    Object localObject1 = com.tencent.mm.a.g.getMD5(this.mPath);
    if ((!bo.isNullOrNil(this.hyD)) && ((a.f.b.j.e(this.hyD, localObject1) ^ true)))
    {
      ab.i(this.TAG, "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.hyD, localObject1 });
      cCf();
      this.szZ.a(-2, false, (com.tencent.mm.plugin.story.model.g)this);
      AppMethodBeat.o(109448);
      return false;
    }
    localObject1 = new bby();
    ab.i(this.TAG, "check upload %s %d %s", new Object[] { this.mPath, Integer.valueOf(((bby)localObject1).xrb), Boolean.valueOf(((bby)localObject1).xra) });
    Object localObject2 = com.tencent.mm.plugin.sight.base.d.Zo(this.mPath);
    if (localObject2 != null) {
      ab.i(this.TAG, "mediaInfo: %s", new Object[] { localObject2 });
    }
    if ((this.szX.xSq & 0x1) == 0) {
      SightVideoJNI.optimizeMP4(this.mPath);
    }
    try
    {
      localObject2 = com.tencent.mm.a.g.getMD5(this.mPath);
      a.f.b.j.p(localObject2, "MD5.getMD5(mPath)");
      this.hyD = ((String)localObject2);
      this.szX.cqq = this.hyD;
      this.szX.xSq |= 0x1;
      localObject2 = this.szQ;
      Object localObject3 = this.szX.toByteArray();
      a.f.b.j.p(localObject3, "postinfo.toByteArray()");
      ((com.tencent.mm.plugin.story.h.j)localObject2).bl((byte[])localObject3);
      ab.i(this.TAG, "new md5 is %s %s", new Object[] { this.mPath, this.hyD });
      localObject2 = com.tencent.mm.plugin.story.model.j.svi;
      j.b.cAB().a((int)this.szQ.systemRowid, this.szQ);
      this.fFo = this.clientId;
      localObject2 = new com.tencent.mm.i.g();
      ((com.tencent.mm.i.g)localObject2).edp = ((com.tencent.mm.i.g.a)this.szY);
      ((com.tencent.mm.i.g)localObject2).field_mediaId = this.fFo;
      ((com.tencent.mm.i.g)localObject2).field_fullpath = this.mPath;
      ((com.tencent.mm.i.g)localObject2).field_thumbpath = this.thumbPath;
      ((com.tencent.mm.i.g)localObject2).field_fileType = 20302;
      ((com.tencent.mm.i.g)localObject2).field_talker = "";
      ((com.tencent.mm.i.g)localObject2).field_priority = com.tencent.mm.i.a.ecF;
      ((com.tencent.mm.i.g)localObject2).field_needStorage = true;
      ((com.tencent.mm.i.g)localObject2).field_isStreamMedia = false;
      ((com.tencent.mm.i.g)localObject2).field_appType = 205;
      ((com.tencent.mm.i.g)localObject2).field_bzScene = 2;
      localObject3 = (c.a)c.srQ.Uw();
      if (localObject3 != null)
      {
        ab.i(this.TAG, "StoryEncodeElementConfig " + ((c.a)localObject3).duration);
        ((com.tencent.mm.i.g)localObject2).field_largesvideo = (((c.a)localObject3).duration + 3);
        ((com.tencent.mm.i.g)localObject2).edE = 6;
        localObject3 = com.tencent.mm.a.g.getMD5(this.mPath);
        if ((bo.isNullOrNil(this.hyD)) || (!(a.f.b.j.e(this.hyD, localObject3) ^ true))) {
          break label588;
        }
        ab.i(this.TAG, "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[] { this.hyD, localObject3 });
        cCf();
        this.szZ.a(-2, false, (com.tencent.mm.plugin.story.model.g)this);
        AppMethodBeat.o(109448);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e(this.TAG, "parseFrom MediaUploadInfo error in updateMd5Info %s", new Object[] { localException.getMessage() });
        continue;
        localException.field_largesvideo = 18;
      }
      label588:
      ab.d(this.TAG, "will addSendTask");
      if (!f.afO().e(localException))
      {
        ab.e(this.TAG, "cdntra addSendTask failed. clientid:%s", new Object[] { this.fFo });
        this.szZ.a(-3, false, (com.tencent.mm.plugin.story.model.g)this);
        AppMethodBeat.o(109448);
        return false;
      }
      if (!((bby)localObject1).xra) {}
    }
    for (int i = 4;; i = 5)
    {
      this.fWX = i;
      AppMethodBeat.o(109448);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.g.b
 * JD-Core Version:    0.7.0.1
 */