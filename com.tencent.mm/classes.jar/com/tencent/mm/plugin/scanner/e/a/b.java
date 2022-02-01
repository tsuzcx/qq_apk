package com.tencent.mm.plugin.scanner.e.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.g;
import com.tencent.mm.plugin.scanner.util.a.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/image/uploader/AiImageDefaultUploader;", "Lcom/tencent/mm/plugin/scanner/image/uploader/BaseAiImageUploader;", "()V", "TAG", "", "cancelUploadImage", "", "session", "", "doUploadImage", "requestWrapper", "Lcom/tencent/mm/plugin/scanner/image/uploader/AiImageUploader$AiImageUploadRequestWrapper;", "image", "", "resultCallback", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResultCallback;", "release", "uploadImage", "plugin-scan_release"})
public final class b
  extends e
{
  public static final b IJV;
  
  static
  {
    AppMethodBeat.i(219878);
    IJV = new b();
    AppMethodBeat.o(219878);
  }
  
  public final void PL(long paramLong)
  {
    AppMethodBeat.i(219876);
    Log.i("MicroMsg.AiImageDefaultUploader", "cancelUploadImage-default session: ".concat(String.valueOf(paramLong)));
    AppMethodBeat.o(219876);
  }
  
  public final void a(c.a parama, final g paramg)
  {
    AppMethodBeat.i(219874);
    p.k(parama, "requestWrapper");
    p.k(paramg, "resultCallback");
    h.ZvG.be((Runnable)new b(parama, paramg));
    AppMethodBeat.o(219874);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "image", "", "kotlin.jvm.PlatformType", "onCompressEnd"})
  static final class a
    implements j.a
  {
    a(c.a parama, long paramLong, com.tencent.mm.plugin.scanner.api.e parame, g paramg) {}
    
    public final void a(boolean paramBoolean, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(223310);
      if ((paramBoolean) && (paramArrayOfByte != null))
      {
        b localb = b.IJV;
        b.a(this.IJT, paramArrayOfByte);
        AppMethodBeat.o(223310);
        return;
      }
      paramArrayOfByte = b.IJV;
      b.a(this.IJu, this.IJv.IGy, 3, 101, "decode image failed", this.IJS);
      AppMethodBeat.o(223310);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c.a parama, g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(223638);
      b localb = b.IJV;
      b.c(this.IJT, paramg);
      AppMethodBeat.o(223638);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.a.b
 * JD-Core Version:    0.7.0.1
 */