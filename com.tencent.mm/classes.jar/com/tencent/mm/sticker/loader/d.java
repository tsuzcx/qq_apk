package com.tencent.mm.sticker.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.aq.b;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.bxa;
import com.tencent.mm.protocal.protobuf.cqv;
import com.tencent.mm.protocal.protobuf.cqx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.f.a;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/loader/StickerFileIdTask;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "aesKey", "fileId", "fileSize", "", "netScene", "Lcom/tencent/mm/sticker/net/NetSceneGetLensInfo;", "outputPath", "task", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "zipPath", "call", "", "cancel", "fixBitmap", "path", "foreachFile", "file", "Lcom/tencent/mm/vfs/VFSFile;", "process", "Lkotlin/Function1;", "handleFile", "", "onResult", "success", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "runTask", "uniqueId", "plugin-sticker_release"})
public final class d
  extends g
  implements i
{
  private final com.tencent.mm.i.g HMd;
  private final String TAG;
  private com.tencent.mm.sticker.b.a Vbn;
  private String Vbo;
  private String aesKey;
  private String fileId;
  private int fileSize;
  private final String uVk;
  
  public d(StickerLoadInfo paramStickerLoadInfo)
  {
    super(paramStickerLoadInfo);
    AppMethodBeat.i(105924);
    this.TAG = "MicroMsg.StickerTask";
    this.fileId = paramStickerLoadInfo.fileId;
    this.aesKey = paramStickerLoadInfo.aesKey;
    this.fileSize = paramStickerLoadInfo.nEz;
    Object localObject = e.Vbx;
    this.uVk = e.buN(paramStickerLoadInfo.uTz);
    localObject = new StringBuilder();
    e locale = e.Vbx;
    this.Vbo = (e.huZ() + paramStickerLoadInfo.uTz);
    this.HMd = new com.tencent.mm.i.g();
    this.HMd.taskName = "task_StickerFileIdTask";
    this.HMd.iUG = ((g.a)new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        Object localObject = null;
        AppMethodBeat.i(105918);
        String str = d.a(this.Vbp);
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
          Log.i(str, paramAnonymousString);
          if (paramAnonymousInt != 0) {
            break label177;
          }
          if (paramAnonymousd != null)
          {
            if ((paramAnonymousd.field_retCode != 0) || (!d.b(this.Vbp))) {
              break label177;
            }
            this.Vbp.ep(true);
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
          this.Vbp.ep(false);
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
  
  private final void adj()
  {
    AppMethodBeat.i(105920);
    if (((CharSequence)this.fileId).length() == 0)
    {
      i = 1;
      if (i == 0) {
        if (((CharSequence)this.aesKey).length() != 0) {
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
      ep(false);
      AppMethodBeat.o(105920);
      return;
      i = 0;
      break;
    }
    label68:
    this.HMd.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    this.HMd.field_needStorage = true;
    this.HMd.field_mediaId = ("lensInfo_" + this.VbE.uTz);
    this.HMd.field_fileId = this.fileId;
    this.HMd.field_aesKey = this.aesKey;
    this.HMd.field_totalLen = this.fileSize;
    this.HMd.field_fullpath = this.Vbo;
    com.tencent.mm.aq.f.bkg().e(this.HMd);
    AppMethodBeat.o(105920);
  }
  
  private final boolean huW()
  {
    AppMethodBeat.i(105921);
    u.bBD(this.uVk);
    if (u.gj(this.Vbo, this.uVk) == 0)
    {
      u.deleteFile(this.Vbo);
      com.tencent.mm.sticker.f localf = new com.tencent.mm.sticker.f();
      localf.buG(this.uVk);
      localf.buH(this.VbE.uTz);
      localf.buJ(this.uVk);
      AppMethodBeat.o(105921);
      return true;
    }
    u.deleteFile(this.Vbo);
    u.deleteDir(this.uVk);
    AppMethodBeat.o(105921);
    return false;
  }
  
  public final String aBG()
  {
    return this.VbE.uTz;
  }
  
  public final void call()
  {
    AppMethodBeat.i(105919);
    if (((CharSequence)this.VbE.uTz).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w(this.TAG, "call: lensId is " + this.VbE.uTz);
      ep(false);
      AppMethodBeat.o(105919);
      return;
    }
    Object localObject = com.tencent.mm.sticker.f.Vbg;
    if (f.a.buL(this.uVk))
    {
      Log.i(this.TAG, "call: file exists " + this.uVk);
      ep(true);
      AppMethodBeat.o(105919);
      return;
    }
    if (((CharSequence)this.fileId).length() == 0)
    {
      i = 1;
      if (i == 0) {
        if (((CharSequence)this.aesKey).length() != 0) {
          break label241;
        }
      }
    }
    label241:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label246;
      }
      this.Vbn = new com.tencent.mm.sticker.b.a();
      localObject = h.aHF();
      p.j(localObject, "MMKernel.network()");
      ((com.tencent.mm.kernel.c)localObject).aGY().a(3903, (i)this);
      localObject = h.aHF();
      p.j(localObject, "MMKernel.network()");
      ((com.tencent.mm.kernel.c)localObject).aGY().b((q)this.Vbn);
      AppMethodBeat.o(105919);
      return;
      i = 0;
      break;
    }
    label246:
    adj();
    AppMethodBeat.o(105919);
  }
  
  public final void ep(boolean paramBoolean)
  {
    AppMethodBeat.i(105923);
    Log.i(this.TAG, "onResult: ".concat(String.valueOf(paramBoolean)));
    super.ep(paramBoolean);
    AppMethodBeat.o(105923);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(105922);
    if (p.h(paramq, this.Vbn))
    {
      paramString = h.aHF();
      p.j(paramString, "MMKernel.network()");
      paramString.aGY().b(3903, (i)this);
      paramString = this.Vbn;
      if (paramString != null)
      {
        paramString = paramString.rr.bhY();
        if (paramString == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLensInfoResponse");
          AppMethodBeat.o(105922);
          throw paramString;
        }
        paramString = (bxa)paramString;
        if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
          break label249;
        }
        paramq = paramString.TgR;
        String str;
        if (paramq != null)
        {
          paramq = paramq.Tyn;
          if (paramq != null)
          {
            str = paramq.RNi;
            paramq = str;
            if (str != null) {
              break label144;
            }
          }
        }
        paramq = "";
        label144:
        this.fileId = paramq;
        paramq = paramString.TgR;
        if (paramq != null)
        {
          paramq = paramq.Tyn;
          if (paramq != null)
          {
            str = paramq.AesKey;
            paramq = str;
            if (str != null) {
              break label194;
            }
          }
        }
        paramq = "";
        label194:
        this.aesKey = paramq;
        paramString = paramString.TgR;
        if (paramString == null) {
          break label244;
        }
        paramString = paramString.Tyn;
        if (paramString == null) {
          break label244;
        }
      }
      label244:
      for (paramInt1 = paramString.HlG;; paramInt1 = 0)
      {
        this.fileSize = paramInt1;
        adj();
        AppMethodBeat.o(105922);
        return;
        paramString = null;
        break;
      }
      label249:
      ep(false);
    }
    AppMethodBeat.o(105922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.d
 * JD-Core Version:    0.7.0.1
 */