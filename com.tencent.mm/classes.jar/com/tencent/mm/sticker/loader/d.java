package com.tencent.mm.sticker.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.g.g.a;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.protocal.protobuf.cmd;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.protocal.protobuf.dhr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.f;
import com.tencent.mm.sticker.f.a;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/loader/StickerFileIdTask;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "aesKey", "fileId", "fileSize", "", "netScene", "Lcom/tencent/mm/sticker/net/NetSceneGetLensInfo;", "outputPath", "task", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "zipPath", "call", "", "cancel", "fixBitmap", "path", "foreachFile", "file", "Lcom/tencent/mm/vfs/VFSFile;", "process", "Lkotlin/Function1;", "handleFile", "", "onResult", "success", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "runTask", "uniqueId", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends g
  implements com.tencent.mm.am.h
{
  private final String TAG;
  private com.tencent.mm.sticker.b.a acCG;
  private String acCH;
  private String aesKey;
  private String fileId;
  private int fileSize;
  private final String outputPath;
  private final com.tencent.mm.g.g ozc;
  
  public d(StickerLoadInfo paramStickerLoadInfo)
  {
    super(paramStickerLoadInfo);
    AppMethodBeat.i(105924);
    this.TAG = "MicroMsg.StickerTask";
    this.fileId = paramStickerLoadInfo.fileId;
    this.aesKey = paramStickerLoadInfo.aesKey;
    this.fileSize = paramStickerLoadInfo.qEw;
    e locale = e.acCJ;
    this.outputPath = e.buU(paramStickerLoadInfo.ygo);
    locale = e.acCJ;
    this.acCH = kotlin.g.b.s.X(e.iWB(), paramStickerLoadInfo.ygo);
    this.ozc = new com.tencent.mm.g.g();
    this.ozc.taskName = "task_StickerFileIdTask";
    this.ozc.lwL = ((g.a)new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        Object localObject = null;
        AppMethodBeat.i(105918);
        String str = d.a(this.acCI);
        StringBuilder localStringBuilder = new StringBuilder("callback: ").append(paramAnonymousString).append(", ").append(paramAnonymousInt).append("; progress ");
        if (paramAnonymousc == null)
        {
          paramAnonymousString = null;
          localStringBuilder = localStringBuilder.append(paramAnonymousString).append(", ");
          if (paramAnonymousc != null) {
            break label157;
          }
          paramAnonymousString = null;
          label71:
          paramAnonymousc = localStringBuilder.append(paramAnonymousString).append("; result ");
          if (paramAnonymousd != null) {
            break label168;
          }
          paramAnonymousString = localObject;
          label91:
          Log.i(str, paramAnonymousString);
          if (paramAnonymousInt != 0) {
            break label180;
          }
          if (paramAnonymousd != null)
          {
            if ((paramAnonymousd.field_retCode != 0) || (!d.b(this.acCI))) {
              break label180;
            }
            this.acCI.onResult(true);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(105918);
          return 0;
          paramAnonymousString = Long.valueOf(paramAnonymousc.field_toltalLength);
          break;
          label157:
          paramAnonymousString = Long.valueOf(paramAnonymousc.field_finishedLength);
          break label71;
          label168:
          paramAnonymousString = Integer.valueOf(paramAnonymousd.field_retCode);
          break label91;
          label180:
          this.acCI.onResult(false);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    });
    AppMethodBeat.o(105924);
  }
  
  private final void aFi()
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
      onResult(false);
      AppMethodBeat.o(105920);
      return;
      i = 0;
      break;
    }
    label68:
    this.ozc.field_fileType = com.tencent.mm.g.a.MediaType_FILE;
    this.ozc.field_needStorage = true;
    this.ozc.field_mediaId = kotlin.g.b.s.X("lensInfo_", this.acCU.ygo);
    this.ozc.field_fileId = this.fileId;
    this.ozc.field_aesKey = this.aesKey;
    this.ozc.field_totalLen = this.fileSize;
    this.ozc.field_fullpath = this.acCH;
    k.bHW().b(this.ozc, -1);
    AppMethodBeat.o(105920);
  }
  
  private final boolean iWy()
  {
    AppMethodBeat.i(105921);
    y.bDX(this.outputPath);
    if (y.aA(this.acCH, this.outputPath) == 0)
    {
      y.deleteFile(this.acCH);
      f localf = new f();
      localf.buM(this.outputPath);
      localf.buN(this.acCU.ygo);
      localf.buP(this.outputPath);
      AppMethodBeat.o(105921);
      return true;
    }
    y.deleteFile(this.acCH);
    y.ew(this.outputPath, true);
    AppMethodBeat.o(105921);
    return false;
  }
  
  public final String aUE()
  {
    return this.acCU.ygo;
  }
  
  public final void call()
  {
    AppMethodBeat.i(105919);
    if (((CharSequence)this.acCU.ygo).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w(this.TAG, kotlin.g.b.s.X("call: lensId is ", this.acCU.ygo));
      onResult(false);
      AppMethodBeat.o(105919);
      return;
    }
    f.a locala = f.acCu;
    if (f.a.buR(this.outputPath))
    {
      Log.i(this.TAG, kotlin.g.b.s.X("call: file exists ", this.outputPath));
      onResult(true);
      AppMethodBeat.o(105919);
      return;
    }
    if (((CharSequence)this.fileId).length() == 0)
    {
      i = 1;
      if (i == 0) {
        if (((CharSequence)this.aesKey).length() != 0) {
          break label204;
        }
      }
    }
    label204:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label209;
      }
      this.acCG = new com.tencent.mm.sticker.b.a();
      com.tencent.mm.kernel.h.baD().mCm.a(3903, (com.tencent.mm.am.h)this);
      com.tencent.mm.kernel.h.baD().mCm.a((p)this.acCG, 0);
      AppMethodBeat.o(105919);
      return;
      i = 0;
      break;
    }
    label209:
    aFi();
    AppMethodBeat.o(105919);
  }
  
  public final void onResult(boolean paramBoolean)
  {
    AppMethodBeat.i(105923);
    Log.i(this.TAG, kotlin.g.b.s.X("onResult: ", Boolean.valueOf(paramBoolean)));
    super.onResult(paramBoolean);
    AppMethodBeat.o(105923);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(105922);
    if (kotlin.g.b.s.p(paramp, this.acCG))
    {
      com.tencent.mm.kernel.h.baD().mCm.b(3903, (com.tencent.mm.am.h)this);
      paramString = this.acCG;
      if (paramString == null)
      {
        paramp = null;
        if ((paramInt1 != 0) || (paramInt2 != 0) || (paramp == null)) {
          break label264;
        }
        paramString = paramp.aauh;
        if (paramString != null) {
          break label168;
        }
        paramString = "";
        label73:
        this.fileId = paramString;
        paramString = paramp.aauh;
        if (paramString != null) {
          break label205;
        }
        paramString = "";
        label92:
        this.aesKey = paramString;
        paramString = paramp.aauh;
        if (paramString != null) {
          break label242;
        }
        paramInt1 = 0;
      }
      for (;;)
      {
        this.fileSize = paramInt1;
        aFi();
        AppMethodBeat.o(105922);
        return;
        paramString = c.c.b(paramString.rr.otC);
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLensInfoResponse");
          AppMethodBeat.o(105922);
          throw paramString;
        }
        paramp = (cmd)paramString;
        break;
        label168:
        paramString = paramString.aaMU;
        if (paramString == null)
        {
          paramString = "";
          break label73;
        }
        String str = paramString.YKw;
        paramString = str;
        if (str != null) {
          break label73;
        }
        paramString = "";
        break label73;
        label205:
        paramString = paramString.aaMU;
        if (paramString == null)
        {
          paramString = "";
          break label92;
        }
        str = paramString.AesKey;
        paramString = str;
        if (str != null) {
          break label92;
        }
        paramString = "";
        break label92;
        label242:
        paramString = paramString.aaMU;
        if (paramString == null) {
          paramInt1 = 0;
        } else {
          paramInt1 = paramString.Nju;
        }
      }
      label264:
      onResult(false);
    }
    AppMethodBeat.o(105922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.d
 * JD-Core Version:    0.7.0.1
 */