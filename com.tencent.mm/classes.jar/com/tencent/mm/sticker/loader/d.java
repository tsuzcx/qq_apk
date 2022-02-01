package com.tencent.mm.sticker.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.ao.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.protocal.protobuf.blr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import d.v;
import java.io.ByteArrayOutputStream;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/loader/StickerFileIdTask;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "aesKey", "fileId", "fileSize", "", "netScene", "Lcom/tencent/mm/sticker/net/NetSceneGetLensInfo;", "outputPath", "task", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "zipPath", "call", "", "cancel", "handleFile", "", "onResult", "success", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "runTask", "uniqueId", "plugin-sticker_release"})
public final class d
  extends g
  implements com.tencent.mm.al.g
{
  private com.tencent.mm.sticker.b.a Fdi;
  private String Fdj;
  final String TAG;
  private String fMw;
  private String fileId;
  private int fileSize;
  private final String oLh;
  private final com.tencent.mm.i.g viP;
  
  public d(StickerLoadInfo paramStickerLoadInfo)
  {
    super(paramStickerLoadInfo);
    AppMethodBeat.i(105924);
    this.TAG = "MicroMsg.StickerTask";
    this.fileId = paramStickerLoadInfo.fileId;
    this.fMw = paramStickerLoadInfo.fMw;
    this.fileSize = paramStickerLoadInfo.iLS;
    Object localObject = e.Fds;
    this.oLh = e.aHd(paramStickerLoadInfo.oJp);
    localObject = new StringBuilder();
    e locale = e.Fds;
    this.Fdj = (e.eIZ() + paramStickerLoadInfo.oJp);
    this.viP = new com.tencent.mm.i.g();
    this.viP.fnH = ((g.a)new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        Object localObject = null;
        AppMethodBeat.i(105918);
        String str = this.Fdk.TAG;
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
          ad.i(str, paramAnonymousString);
          if (paramAnonymousInt != 0) {
            break label175;
          }
          if (paramAnonymousd != null)
          {
            if (paramAnonymousd.field_retCode != 0) {
              break label175;
            }
            this.Fdk.eIX();
            this.Fdk.df(true);
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
          this.Fdk.df(false);
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
  
  private final void MQ()
  {
    AppMethodBeat.i(105920);
    if (((CharSequence)this.fileId).length() == 0)
    {
      i = 1;
      if (i == 0) {
        if (((CharSequence)this.fMw).length() != 0) {
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
      df(false);
      AppMethodBeat.o(105920);
      return;
      i = 0;
      break;
    }
    label68:
    this.viP.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    this.viP.field_needStorage = true;
    this.viP.field_mediaId = ("lensInfo_" + this.Fdv.oJp);
    this.viP.field_fileId = this.fileId;
    this.viP.field_aesKey = this.fMw;
    this.viP.field_totalLen = this.fileSize;
    this.viP.field_fullpath = this.Fdj;
    f.awL().d(this.viP);
    AppMethodBeat.o(105920);
  }
  
  public final String abi()
  {
    return this.Fdv.oJp;
  }
  
  public final void call()
  {
    AppMethodBeat.i(105919);
    if (((CharSequence)this.Fdv.oJp).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.w(this.TAG, "call: lensId is " + this.Fdv.oJp);
      df(false);
      AppMethodBeat.o(105919);
      return;
    }
    if (i.eK(this.oLh))
    {
      ad.i(this.TAG, "call: file exists " + this.oLh);
      df(true);
      AppMethodBeat.o(105919);
      return;
    }
    if (((CharSequence)this.fileId).length() == 0)
    {
      i = 1;
      if (i == 0) {
        if (((CharSequence)this.fMw).length() != 0) {
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
      this.Fdi = new com.tencent.mm.sticker.b.a();
      com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.afA();
      k.g(localb, "MMKernel.network()");
      localb.aeS().a(3903, (com.tencent.mm.al.g)this);
      localb = com.tencent.mm.kernel.g.afA();
      k.g(localb, "MMKernel.network()");
      localb.aeS().b((n)this.Fdi);
      AppMethodBeat.o(105919);
      return;
      i = 0;
      break;
    }
    label239:
    MQ();
    AppMethodBeat.o(105919);
  }
  
  public final void df(boolean paramBoolean)
  {
    AppMethodBeat.i(105923);
    ad.i(this.TAG, "onResult: ".concat(String.valueOf(paramBoolean)));
    super.df(paramBoolean);
    AppMethodBeat.o(105923);
  }
  
  final boolean eIX()
  {
    AppMethodBeat.i(105921);
    i.aMF(this.oLh);
    if (i.fc(this.Fdj, this.oLh) == 0)
    {
      i.deleteFile(this.Fdj);
      com.tencent.mm.sticker.e locale = new com.tencent.mm.sticker.e();
      locale.aGZ(this.oLh);
      locale.aGY(this.Fdv.oJp);
      locale.aHb(this.oLh);
    }
    AppMethodBeat.o(105921);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(105922);
    if (k.g(paramn, this.Fdi))
    {
      paramString = com.tencent.mm.kernel.g.afA();
      k.g(paramString, "MMKernel.network()");
      paramString.aeS().b(3903, (com.tencent.mm.al.g)this);
      paramString = this.Fdi;
      if (paramString != null)
      {
        paramString = paramString.rr.auM();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLensInfoResponse");
          AppMethodBeat.o(105922);
          throw paramString;
        }
        paramString = (avs)paramString;
        if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
          break label248;
        }
        paramn = paramString.Dvo;
        String str;
        if (paramn != null)
        {
          paramn = paramn.DJr;
          if (paramn != null)
          {
            str = paramn.CCm;
            paramn = str;
            if (str != null) {
              break label143;
            }
          }
        }
        paramn = "";
        label143:
        this.fileId = paramn;
        paramn = paramString.Dvo;
        if (paramn != null)
        {
          paramn = paramn.DJr;
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
        this.fMw = paramn;
        paramString = paramString.Dvo;
        if (paramString == null) {
          break label243;
        }
        paramString = paramString.DJr;
        if (paramString == null) {
          break label243;
        }
      }
      label243:
      for (paramInt1 = paramString.FileSize;; paramInt1 = 0)
      {
        this.fileSize = paramInt1;
        MQ();
        AppMethodBeat.o(105922);
        return;
        paramString = null;
        break;
      }
      label248:
      df(false);
    }
    AppMethodBeat.o(105922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.d
 * JD-Core Version:    0.7.0.1
 */