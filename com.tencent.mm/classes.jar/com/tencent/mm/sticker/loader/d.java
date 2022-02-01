package com.tencent.mm.sticker.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.protocal.protobuf.ayy;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.protocal.protobuf.bpn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import d.v;
import java.io.ByteArrayOutputStream;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sticker/loader/StickerFileIdTask;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "aesKey", "fileId", "fileSize", "", "netScene", "Lcom/tencent/mm/sticker/net/NetSceneGetLensInfo;", "outputPath", "task", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "zipPath", "call", "", "cancel", "handleFile", "", "onResult", "success", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "runTask", "uniqueId", "plugin-sticker_release"})
public final class d
  extends g
  implements com.tencent.mm.ak.g
{
  private com.tencent.mm.sticker.b.a GAF;
  private String GAG;
  final String TAG;
  private String fQi;
  private String fileId;
  private int fileSize;
  private final String poB;
  private final com.tencent.mm.i.g wrB;
  
  public d(StickerLoadInfo paramStickerLoadInfo)
  {
    super(paramStickerLoadInfo);
    AppMethodBeat.i(105924);
    this.TAG = "MicroMsg.StickerTask";
    this.fileId = paramStickerLoadInfo.fileId;
    this.fQi = paramStickerLoadInfo.fQi;
    this.fileSize = paramStickerLoadInfo.jlZ;
    Object localObject = e.GAP;
    this.poB = e.aMx(paramStickerLoadInfo.pmO);
    localObject = new StringBuilder();
    e locale = e.GAP;
    this.GAG = (e.eYv() + paramStickerLoadInfo.pmO);
    this.wrB = new com.tencent.mm.i.g();
    this.wrB.frb = ((g.a)new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        Object localObject = null;
        AppMethodBeat.i(105918);
        String str = this.GAH.TAG;
        StringBuilder localStringBuilder = new StringBuilder("callback: ").append(paramAnonymousString).append(", ").append(paramAnonymousInt).append("; progress ");
        if (paramAnonymousc != null)
        {
          paramAnonymousString = Long.valueOf(paramAnonymousc.field_toltalLength);
          localStringBuilder = localStringBuilder.append(paramAnonymousString).append(", ");
          if (paramAnonymousc == null) {
            break label170;
          }
          paramAnonymousString = Long.valueOf(paramAnonymousc.field_finishedLength);
          label83:
          paramAnonymousc = localStringBuilder.append(paramAnonymousString).append("; result ");
          paramAnonymousString = localObject;
          if (paramAnonymousd != null) {
            paramAnonymousString = Integer.valueOf(paramAnonymousd.field_retCode);
          }
          ac.i(str, paramAnonymousString);
          if (paramAnonymousInt != 0) {
            break label175;
          }
          if (paramAnonymousd != null)
          {
            if (paramAnonymousd.field_retCode != 0) {
              break label175;
            }
            this.GAH.eYt();
            this.GAH.de(true);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(105918);
          return 0;
          paramAnonymousString = null;
          break;
          label170:
          paramAnonymousString = null;
          break label83;
          label175:
          this.GAH.de(false);
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
  
  private final void MO()
  {
    AppMethodBeat.i(105920);
    if (((CharSequence)this.fileId).length() == 0)
    {
      i = 1;
      if (i == 0) {
        if (((CharSequence)this.fQi).length() != 0) {
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
      de(false);
      AppMethodBeat.o(105920);
      return;
      i = 0;
      break;
    }
    label68:
    this.wrB.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    this.wrB.field_needStorage = true;
    this.wrB.field_mediaId = ("lensInfo_" + this.GAW.pmO);
    this.wrB.field_fileId = this.fileId;
    this.wrB.field_aesKey = this.fQi;
    this.wrB.field_totalLen = this.fileSize;
    this.wrB.field_fullpath = this.GAG;
    com.tencent.mm.an.f.aDD().e(this.wrB);
    AppMethodBeat.o(105920);
  }
  
  public final String acg()
  {
    return this.GAW.pmO;
  }
  
  public final void call()
  {
    AppMethodBeat.i(105919);
    if (((CharSequence)this.GAW.pmO).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ac.w(this.TAG, "call: lensId is " + this.GAW.pmO);
      de(false);
      AppMethodBeat.o(105919);
      return;
    }
    if (i.eA(this.poB))
    {
      ac.i(this.TAG, "call: file exists " + this.poB);
      de(true);
      AppMethodBeat.o(105919);
      return;
    }
    if (((CharSequence)this.fileId).length() == 0)
    {
      i = 1;
      if (i == 0) {
        if (((CharSequence)this.fQi).length() != 0) {
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
      this.GAF = new com.tencent.mm.sticker.b.a();
      com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
      k.g(localb, "MMKernel.network()");
      localb.agi().a(3903, (com.tencent.mm.ak.g)this);
      localb = com.tencent.mm.kernel.g.agQ();
      k.g(localb, "MMKernel.network()");
      localb.agi().b((n)this.GAF);
      AppMethodBeat.o(105919);
      return;
      i = 0;
      break;
    }
    label239:
    MO();
    AppMethodBeat.o(105919);
  }
  
  public final void de(boolean paramBoolean)
  {
    AppMethodBeat.i(105923);
    ac.i(this.TAG, "onResult: ".concat(String.valueOf(paramBoolean)));
    super.de(paramBoolean);
    AppMethodBeat.o(105923);
  }
  
  final boolean eYt()
  {
    AppMethodBeat.i(105921);
    i.aSh(this.poB);
    if (i.fp(this.GAG, this.poB) == 0)
    {
      i.deleteFile(this.GAG);
      com.tencent.mm.sticker.f localf = new com.tencent.mm.sticker.f();
      localf.aMs(this.poB);
      localf.aMr(this.GAW.pmO);
      localf.aMu(this.poB);
    }
    AppMethodBeat.o(105921);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(105922);
    if (k.g(paramn, this.GAF))
    {
      paramString = com.tencent.mm.kernel.g.agQ();
      k.g(paramString, "MMKernel.network()");
      paramString.agi().b(3903, (com.tencent.mm.ak.g)this);
      paramString = this.GAF;
      if (paramString != null)
      {
        paramString = paramString.rr.aBD();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLensInfoResponse");
          AppMethodBeat.o(105922);
          throw paramString;
        }
        paramString = (ayy)paramString;
        if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
          break label248;
        }
        paramn = paramString.EQx;
        String str;
        if (paramn != null)
        {
          paramn = paramn.FeM;
          if (paramn != null)
          {
            str = paramn.DUJ;
            paramn = str;
            if (str != null) {
              break label143;
            }
          }
        }
        paramn = "";
        label143:
        this.fileId = paramn;
        paramn = paramString.EQx;
        if (paramn != null)
        {
          paramn = paramn.FeM;
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
        this.fQi = paramn;
        paramString = paramString.EQx;
        if (paramString == null) {
          break label243;
        }
        paramString = paramString.FeM;
        if (paramString == null) {
          break label243;
        }
      }
      label243:
      for (paramInt1 = paramString.FileSize;; paramInt1 = 0)
      {
        this.fileSize = paramInt1;
        MO();
        AppMethodBeat.o(105922);
        return;
        paramString = null;
        break;
      }
      label248:
      de(false);
    }
    AppMethodBeat.o(105922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.d
 * JD-Core Version:    0.7.0.1
 */