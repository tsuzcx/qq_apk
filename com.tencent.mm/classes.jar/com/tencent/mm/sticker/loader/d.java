package com.tencent.mm.sticker.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.g.a;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.protocal.protobuf.buu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sticker/loader/StickerFileIdTask;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "aesKey", "fileId", "fileSize", "", "netScene", "Lcom/tencent/mm/sticker/net/NetSceneGetLensInfo;", "outputPath", "task", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "zipPath", "call", "", "cancel", "handleFile", "", "onResult", "success", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "runTask", "uniqueId", "plugin-sticker_release"})
public final class d
  extends g
  implements com.tencent.mm.ak.f
{
  private com.tencent.mm.sticker.b.a IGK;
  private String IGL;
  final String TAG;
  private String fileId;
  private int fileSize;
  private String gmb;
  private final String pYH;
  private final com.tencent.mm.i.g xPo;
  
  public d(StickerLoadInfo paramStickerLoadInfo)
  {
    super(paramStickerLoadInfo);
    AppMethodBeat.i(105924);
    this.TAG = "MicroMsg.StickerTask";
    this.fileId = paramStickerLoadInfo.fileId;
    this.gmb = paramStickerLoadInfo.gmb;
    this.fileSize = paramStickerLoadInfo.jIO;
    Object localObject = e.IGU;
    this.pYH = e.aTB(paramStickerLoadInfo.pWT);
    localObject = new StringBuilder();
    e locale = e.IGU;
    this.IGL = (e.frY() + paramStickerLoadInfo.pWT);
    this.xPo = new com.tencent.mm.i.g();
    this.xPo.fLl = "task_StickerFileIdTask";
    this.xPo.fLm = ((g.a)new d.1(this));
    AppMethodBeat.o(105924);
  }
  
  private final void Ov()
  {
    AppMethodBeat.i(105920);
    if (((CharSequence)this.fileId).length() == 0)
    {
      i = 1;
      if (i == 0) {
        if (((CharSequence)this.gmb).length() != 0) {
          break label63;
        }
      }
    }
    label63:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label68;
      }
      dg(false);
      AppMethodBeat.o(105920);
      return;
      i = 0;
      break;
    }
    label68:
    this.xPo.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    this.xPo.field_needStorage = true;
    this.xPo.field_mediaId = ("lensInfo_" + this.IHb.pWT);
    this.xPo.field_fileId = this.fileId;
    this.xPo.field_aesKey = this.gmb;
    this.xPo.field_totalLen = this.fileSize;
    this.xPo.field_fullpath = this.IGL;
    com.tencent.mm.an.f.aGZ().e(this.xPo);
    AppMethodBeat.o(105920);
  }
  
  public final String aeW()
  {
    return this.IHb.pWT;
  }
  
  public final void call()
  {
    AppMethodBeat.i(105919);
    if (((CharSequence)this.IHb.pWT).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.w(this.TAG, "call: lensId is " + this.IHb.pWT);
      dg(false);
      AppMethodBeat.o(105919);
      return;
    }
    if (o.fB(this.pYH))
    {
      ae.i(this.TAG, "call: file exists " + this.pYH);
      dg(true);
      AppMethodBeat.o(105919);
      return;
    }
    if (((CharSequence)this.fileId).length() == 0)
    {
      i = 1;
      if (i == 0) {
        if (((CharSequence)this.gmb).length() != 0) {
          break label234;
        }
      }
    }
    label234:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label239;
      }
      this.IGK = new com.tencent.mm.sticker.b.a();
      com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajQ();
      p.g(localb, "MMKernel.network()");
      localb.ajj().a(3903, (com.tencent.mm.ak.f)this);
      localb = com.tencent.mm.kernel.g.ajQ();
      p.g(localb, "MMKernel.network()");
      localb.ajj().b((n)this.IGK);
      AppMethodBeat.o(105919);
      return;
      i = 0;
      break;
    }
    label239:
    Ov();
    AppMethodBeat.o(105919);
  }
  
  public final void dg(boolean paramBoolean)
  {
    AppMethodBeat.i(105923);
    ae.i(this.TAG, "onResult: ".concat(String.valueOf(paramBoolean)));
    super.dg(paramBoolean);
    AppMethodBeat.o(105923);
  }
  
  final boolean frW()
  {
    AppMethodBeat.i(105921);
    o.aZI(this.pYH);
    if (o.fD(this.IGL, this.pYH) == 0)
    {
      o.deleteFile(this.IGL);
      com.tencent.mm.sticker.f localf = new com.tencent.mm.sticker.f();
      localf.aTw(this.pYH);
      localf.aTv(this.IHb.pWT);
      localf.aTy(this.pYH);
      AppMethodBeat.o(105921);
      return true;
    }
    o.deleteFile(this.IGL);
    o.deleteDir(this.pYH);
    AppMethodBeat.o(105921);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(105922);
    if (p.i(paramn, this.IGK))
    {
      paramString = com.tencent.mm.kernel.g.ajQ();
      p.g(paramString, "MMKernel.network()");
      paramString.ajj().b(3903, (com.tencent.mm.ak.f)this);
      paramString = this.IGK;
      if (paramString != null)
      {
        paramString = paramString.rr.aEV();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLensInfoResponse");
          AppMethodBeat.o(105922);
          throw paramString;
        }
        paramString = (bds)paramString;
        if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
          break label248;
        }
        paramn = paramString.GTo;
        String str;
        if (paramn != null)
        {
          paramn = paramn.HhQ;
          if (paramn != null)
          {
            str = paramn.FSC;
            paramn = str;
            if (str != null) {
              break label143;
            }
          }
        }
        paramn = "";
        label143:
        this.fileId = paramn;
        paramn = paramString.GTo;
        if (paramn != null)
        {
          paramn = paramn.HhQ;
          if (paramn != null)
          {
            str = paramn.AesKey;
            paramn = str;
            if (str != null) {
              break label193;
            }
          }
        }
        paramn = "";
        label193:
        this.gmb = paramn;
        paramString = paramString.GTo;
        if (paramString == null) {
          break label243;
        }
        paramString = paramString.HhQ;
        if (paramString == null) {
          break label243;
        }
      }
      label243:
      for (paramInt1 = paramString.FileSize;; paramInt1 = 0)
      {
        this.fileSize = paramInt1;
        Ov();
        AppMethodBeat.o(105922);
        return;
        paramString = null;
        break;
      }
      label248:
      dg(false);
    }
    AppMethodBeat.o(105922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.d
 * JD-Core Version:    0.7.0.1
 */