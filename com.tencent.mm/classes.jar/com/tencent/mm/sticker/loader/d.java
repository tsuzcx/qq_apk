package com.tencent.mm.sticker.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.protocal.protobuf.bdc;
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;
import d.v;
import java.io.ByteArrayOutputStream;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sticker/loader/StickerFileIdTask;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "aesKey", "fileId", "fileSize", "", "netScene", "Lcom/tencent/mm/sticker/net/NetSceneGetLensInfo;", "outputPath", "task", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "zipPath", "call", "", "cancel", "handleFile", "", "onResult", "success", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "runTask", "uniqueId", "plugin-sticker_release"})
public final class d
  extends g
  implements com.tencent.mm.al.f
{
  private String ImA;
  private com.tencent.mm.sticker.b.a Imz;
  final String TAG;
  private String fileId;
  private int fileSize;
  private String gjI;
  private final String pSc;
  private final com.tencent.mm.i.g xzs;
  
  public d(StickerLoadInfo paramStickerLoadInfo)
  {
    super(paramStickerLoadInfo);
    AppMethodBeat.i(105924);
    this.TAG = "MicroMsg.StickerTask";
    this.fileId = paramStickerLoadInfo.fileId;
    this.gjI = paramStickerLoadInfo.gjI;
    this.fileSize = paramStickerLoadInfo.jFP;
    Object localObject = e.ImJ;
    this.pSc = e.aSe(paramStickerLoadInfo.pQo);
    localObject = new StringBuilder();
    e locale = e.ImJ;
    this.ImA = (e.fof() + paramStickerLoadInfo.pQo);
    this.xzs = new com.tencent.mm.i.g();
    this.xzs.fJi = "task_StickerFileIdTask";
    this.xzs.fJj = ((g.a)new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        Object localObject = null;
        AppMethodBeat.i(105918);
        String str = this.ImB.TAG;
        StringBuilder localStringBuilder = new StringBuilder("callback: ").append(paramAnonymousString).append(", ").append(paramAnonymousInt).append("; progress ");
        if (paramAnonymousc != null)
        {
          paramAnonymousString = Long.valueOf(paramAnonymousc.field_toltalLength);
          localStringBuilder = localStringBuilder.append(paramAnonymousString).append(", ");
          if (paramAnonymousc == null) {
            break label172;
          }
          paramAnonymousString = Long.valueOf(paramAnonymousc.field_finishedLength);
          label83:
          paramAnonymousc = localStringBuilder.append(paramAnonymousString).append("; result ");
          paramAnonymousString = localObject;
          if (paramAnonymousd != null) {
            paramAnonymousString = Integer.valueOf(paramAnonymousd.field_retCode);
          }
          ad.i(str, paramAnonymousString);
          if (paramAnonymousInt != 0) {
            break label177;
          }
          if (paramAnonymousd != null)
          {
            if ((paramAnonymousd.field_retCode != 0) || (!this.ImB.fod())) {
              break label177;
            }
            this.ImB.dg(true);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(105918);
          return 0;
          paramAnonymousString = null;
          break;
          label172:
          paramAnonymousString = null;
          break label83;
          label177:
          this.ImB.dg(false);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    });
    AppMethodBeat.o(105924);
  }
  
  private final void Ox()
  {
    AppMethodBeat.i(105920);
    if (((CharSequence)this.fileId).length() == 0)
    {
      i = 1;
      if (i == 0) {
        if (((CharSequence)this.gjI).length() != 0) {
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
    this.xzs.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    this.xzs.field_needStorage = true;
    this.xzs.field_mediaId = ("lensInfo_" + this.ImQ.pQo);
    this.xzs.field_fileId = this.fileId;
    this.xzs.field_aesKey = this.gjI;
    this.xzs.field_totalLen = this.fileSize;
    this.xzs.field_fullpath = this.ImA;
    com.tencent.mm.ao.f.aGI().e(this.xzs);
    AppMethodBeat.o(105920);
  }
  
  public final String aeK()
  {
    return this.ImQ.pQo;
  }
  
  public final void call()
  {
    AppMethodBeat.i(105919);
    if (((CharSequence)this.ImQ.pQo).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.w(this.TAG, "call: lensId is " + this.ImQ.pQo);
      dg(false);
      AppMethodBeat.o(105919);
      return;
    }
    if (i.fv(this.pSc))
    {
      ad.i(this.TAG, "call: file exists " + this.pSc);
      dg(true);
      AppMethodBeat.o(105919);
      return;
    }
    if (((CharSequence)this.fileId).length() == 0)
    {
      i = 1;
      if (i == 0) {
        if (((CharSequence)this.gjI).length() != 0) {
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
      this.Imz = new com.tencent.mm.sticker.b.a();
      com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajB();
      p.g(localb, "MMKernel.network()");
      localb.aiU().a(3903, (com.tencent.mm.al.f)this);
      localb = com.tencent.mm.kernel.g.ajB();
      p.g(localb, "MMKernel.network()");
      localb.aiU().b((n)this.Imz);
      AppMethodBeat.o(105919);
      return;
      i = 0;
      break;
    }
    label239:
    Ox();
    AppMethodBeat.o(105919);
  }
  
  public final void dg(boolean paramBoolean)
  {
    AppMethodBeat.i(105923);
    ad.i(this.TAG, "onResult: ".concat(String.valueOf(paramBoolean)));
    super.dg(paramBoolean);
    AppMethodBeat.o(105923);
  }
  
  final boolean fod()
  {
    AppMethodBeat.i(105921);
    i.aYg(this.pSc);
    if (i.fz(this.ImA, this.pSc) == 0)
    {
      i.deleteFile(this.ImA);
      com.tencent.mm.sticker.f localf = new com.tencent.mm.sticker.f();
      localf.aRZ(this.pSc);
      localf.aRY(this.ImQ.pQo);
      localf.aSb(this.pSc);
      AppMethodBeat.o(105921);
      return true;
    }
    i.deleteFile(this.ImA);
    i.deleteDir(this.pSc);
    AppMethodBeat.o(105921);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(105922);
    if (p.i(paramn, this.Imz))
    {
      paramString = com.tencent.mm.kernel.g.ajB();
      p.g(paramString, "MMKernel.network()");
      paramString.aiU().b(3903, (com.tencent.mm.al.f)this);
      paramString = this.Imz;
      if (paramString != null)
      {
        paramString = paramString.rr.aEF();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLensInfoResponse");
          AppMethodBeat.o(105922);
          throw paramString;
        }
        paramString = (bdc)paramString;
        if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
          break label248;
        }
        paramn = paramString.GzO;
        String str;
        if (paramn != null)
        {
          paramn = paramn.GOq;
          if (paramn != null)
          {
            str = paramn.FAe;
            paramn = str;
            if (str != null) {
              break label143;
            }
          }
        }
        paramn = "";
        label143:
        this.fileId = paramn;
        paramn = paramString.GzO;
        if (paramn != null)
        {
          paramn = paramn.GOq;
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
        this.gjI = paramn;
        paramString = paramString.GzO;
        if (paramString == null) {
          break label243;
        }
        paramString = paramString.GOq;
        if (paramString == null) {
          break label243;
        }
      }
      label243:
      for (paramInt1 = paramString.FileSize;; paramInt1 = 0)
      {
        this.fileSize = paramInt1;
        Ox();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.d
 * JD-Core Version:    0.7.0.1
 */