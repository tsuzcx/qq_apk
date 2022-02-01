package com.tencent.mm.sticker.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.protocal.protobuf.bpg;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.protocal.protobuf.cib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.f.a;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/loader/StickerFileIdTask;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "aesKey", "fileId", "fileSize", "", "netScene", "Lcom/tencent/mm/sticker/net/NetSceneGetLensInfo;", "outputPath", "task", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "zipPath", "call", "", "cancel", "fixBitmap", "path", "foreachFile", "file", "Lcom/tencent/mm/vfs/VFSFile;", "process", "Lkotlin/Function1;", "handleFile", "", "onResult", "success", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "runTask", "uniqueId", "plugin-sticker_release"})
public final class d
  extends g
  implements i
{
  private final com.tencent.mm.i.g BPr;
  private com.tencent.mm.sticker.b.a NND;
  private String NNE;
  final String TAG;
  private String aesKey;
  private String fileId;
  private int fileSize;
  private final String rpE;
  
  public d(StickerLoadInfo paramStickerLoadInfo)
  {
    super(paramStickerLoadInfo);
    AppMethodBeat.i(105924);
    this.TAG = "MicroMsg.StickerTask";
    this.fileId = paramStickerLoadInfo.fileId;
    this.aesKey = paramStickerLoadInfo.aesKey;
    this.fileSize = paramStickerLoadInfo.kKK;
    Object localObject = e.NNN;
    this.rpE = e.biw(paramStickerLoadInfo.rnS);
    localObject = new StringBuilder();
    e locale = e.NNN;
    this.NNE = (e.gyY() + paramStickerLoadInfo.rnS);
    this.BPr = new com.tencent.mm.i.g();
    this.BPr.taskName = "task_StickerFileIdTask";
    this.BPr.gqy = ((g.a)new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        Object localObject = null;
        AppMethodBeat.i(105918);
        String str = this.NNF.TAG;
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
            if ((paramAnonymousd.field_retCode != 0) || (!d.a(this.NNF))) {
              break label177;
            }
            this.NNF.dQ(true);
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
          this.NNF.dQ(false);
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
  
  private final void YC()
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
      dQ(false);
      AppMethodBeat.o(105920);
      return;
      i = 0;
      break;
    }
    label68:
    this.BPr.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    this.BPr.field_needStorage = true;
    this.BPr.field_mediaId = ("lensInfo_" + this.NNU.rnS);
    this.BPr.field_fileId = this.fileId;
    this.BPr.field_aesKey = this.aesKey;
    this.BPr.field_totalLen = this.fileSize;
    this.BPr.field_fullpath = this.NNE;
    com.tencent.mm.an.f.baQ().e(this.BPr);
    AppMethodBeat.o(105920);
  }
  
  private final void a(o paramo, kotlin.g.a.b<? super o, x> paramb)
  {
    AppMethodBeat.i(194223);
    if (paramo.isDirectory())
    {
      paramo = paramo.het();
      if (paramo != null)
      {
        int j = paramo.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramo[i];
          p.g(localObject, "it");
          a(localObject, paramb);
          i += 1;
        }
        AppMethodBeat.o(194223);
        return;
      }
      AppMethodBeat.o(194223);
      return;
    }
    paramb.invoke(paramo);
    AppMethodBeat.o(194223);
  }
  
  public final String auK()
  {
    return this.NNU.rnS;
  }
  
  public final void call()
  {
    AppMethodBeat.i(105919);
    if (((CharSequence)this.NNU.rnS).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w(this.TAG, "call: lensId is " + this.NNU.rnS);
      dQ(false);
      AppMethodBeat.o(105919);
      return;
    }
    Object localObject = com.tencent.mm.sticker.f.NNw;
    if (f.a.biu(this.rpE))
    {
      Log.i(this.TAG, "call: file exists " + this.rpE);
      dQ(true);
      AppMethodBeat.o(105919);
      return;
    }
    if (((CharSequence)this.fileId).length() == 0)
    {
      i = 1;
      if (i == 0) {
        if (((CharSequence)this.aesKey).length() != 0) {
          break label246;
        }
      }
    }
    label246:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label251;
      }
      this.NND = new com.tencent.mm.sticker.b.a();
      localObject = com.tencent.mm.kernel.g.aAg();
      p.g(localObject, "MMKernel.network()");
      ((com.tencent.mm.kernel.b)localObject).azz().a(3903, (i)this);
      localObject = com.tencent.mm.kernel.g.aAg();
      p.g(localObject, "MMKernel.network()");
      ((com.tencent.mm.kernel.b)localObject).azz().b((q)this.NND);
      AppMethodBeat.o(105919);
      return;
      i = 0;
      break;
    }
    label251:
    YC();
    AppMethodBeat.o(105919);
  }
  
  public final void dQ(boolean paramBoolean)
  {
    AppMethodBeat.i(105923);
    Log.i(this.TAG, "onResult: ".concat(String.valueOf(paramBoolean)));
    super.dQ(paramBoolean);
    AppMethodBeat.o(105923);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(105922);
    if (p.j(paramq, this.NND))
    {
      paramString = com.tencent.mm.kernel.g.aAg();
      p.g(paramString, "MMKernel.network()");
      paramString.azz().b(3903, (i)this);
      paramString = this.NND;
      if (paramString != null)
      {
        paramString = paramString.rr.aYK();
        if (paramString == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLensInfoResponse");
          AppMethodBeat.o(105922);
          throw paramString;
        }
        paramString = (bpg)paramString;
        if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
          break label249;
        }
        paramq = paramString.LXA;
        String str;
        if (paramq != null)
        {
          paramq = paramq.Mns;
          if (paramq != null)
          {
            str = paramq.KMl;
            paramq = str;
            if (str != null) {
              break label144;
            }
          }
        }
        paramq = "";
        label144:
        this.fileId = paramq;
        paramq = paramString.LXA;
        if (paramq != null)
        {
          paramq = paramq.Mns;
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
        paramString = paramString.LXA;
        if (paramString == null) {
          break label244;
        }
        paramString = paramString.Mns;
        if (paramString == null) {
          break label244;
        }
      }
      label244:
      for (paramInt1 = paramString.FileSize;; paramInt1 = 0)
      {
        this.fileSize = paramInt1;
        YC();
        AppMethodBeat.o(105922);
        return;
        paramString = null;
        break;
      }
      label249:
      dQ(false);
    }
    AppMethodBeat.o(105922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.d
 * JD-Core Version:    0.7.0.1
 */