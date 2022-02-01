package com.tencent.mm.plugin.scanner.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.plugin.scanner.api.g;
import com.tencent.mm.plugin.scanner.e.a;
import com.tencent.mm.plugin.scanner.model.ah;
import com.tencent.mm.plugin.scanner.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/image/uploader/AiImageDefaultUploader;", "Lcom/tencent/mm/plugin/scanner/image/uploader/BaseAiImageUploader;", "()V", "TAG", "", "cancelUploadImage", "", "session", "", "doUploadImage", "requestWrapper", "Lcom/tencent/mm/plugin/scanner/image/uploader/AiImageUploader$AiImageUploadRequestWrapper;", "image", "", "resultCallback", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResultCallback;", "release", "uploadImage", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends e
{
  public static final b OQH;
  
  static
  {
    AppMethodBeat.i(313629);
    OQH = new b();
    AppMethodBeat.o(313629);
  }
  
  private static final void a(c.a parama, long paramLong, com.tencent.mm.plugin.scanner.api.e parame, g paramg, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(313622);
    kotlin.g.b.s.u(parame, "$request");
    kotlin.g.b.s.u(paramg, "$resultCallback");
    if ((paramBoolean) && (paramArrayOfByte != null))
    {
      com.tencent.mm.plugin.scanner.api.e locale = parama.OQI;
      kotlin.g.b.s.checkNotNull(locale);
      int i = paramArrayOfByte.length;
      paramLong = locale.sessionId;
      int j = locale.mode;
      paramBoolean = locale.OMK;
      parame = locale.OMJ;
      if (parame == null)
      {
        parame = null;
        paramg = locale.OMJ;
        if (paramg != null) {
          break label213;
        }
        paramg = null;
        label91:
        Log.i("MicroMsg.AiImageDefaultUploader", "uploadImageDefault imageData: %d, session: %s, mode: %d, needPHash: %s, pHash: %s, %s", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong), Integer.valueOf(j), Boolean.valueOf(paramBoolean), parame, paramg });
        switch (locale.OMG)
        {
        case 2: 
        default: 
          parame = null;
        }
      }
      for (;;)
      {
        if (parame != null)
        {
          parama.OQJ = parame.hashCode();
          com.tencent.mm.kernel.h.aZW().a(parame, 0);
        }
        AppMethodBeat.o(313622);
        return;
        parame = parame.pHash;
        break;
        label213:
        paramg = paramg.pHashVersion;
        break label91;
        parame = (p)new com.tencent.mm.plugin.scanner.model.j(paramArrayOfByte, locale.sessionId, locale.type, locale.mode, locale.OMH, locale.OMI, locale.OMJ);
        continue;
        parame = (p)new com.tencent.mm.plugin.scanner.f.i(paramArrayOfByte, locale.sessionId, locale.source, null, 112);
      }
    }
    a(paramLong, parame.OMG, 3, 101, "decode image failed", paramg);
    AppMethodBeat.o(313622);
  }
  
  private static final void b(c.a parama, g paramg)
  {
    AppMethodBeat.i(313611);
    kotlin.g.b.s.u(parama, "$requestWrapper");
    kotlin.g.b.s.u(paramg, "$resultCallback");
    com.tencent.mm.plugin.scanner.api.e locale;
    long l;
    int i;
    if (parama == null)
    {
      locale = null;
      if (locale == null) {
        break label223;
      }
      locale = parama.OQI;
      kotlin.g.b.s.checkNotNull(locale);
      l = locale.sessionId;
      if (locale.OMG == 2) {
        break label161;
      }
      i = 1;
    }
    for (;;)
    {
      if (y.ZC(locale.imagePath))
      {
        if ((locale.OMJ == null) && (locale.OMK))
        {
          Object localObject = ah.OSL;
          localObject = locale.imagePath;
          kotlin.g.b.s.s(localObject, "request.imagePath");
          locale.OMJ = ah.aUL((String)localObject);
        }
        if (i != 0)
        {
          com.tencent.mm.plugin.scanner.util.a.j.a(locale.imagePath, a.ahJ(locale.OMG), new b..ExternalSyntheticLambda0(parama, l, locale, paramg));
          AppMethodBeat.o(313611);
          return;
          locale = parama.OQI;
          break;
          label161:
          i = 0;
          continue;
        }
        paramg = new k(l, locale.OMJ, (byte)0);
        parama.OQJ = paramg.hashCode();
        com.tencent.mm.kernel.h.aZW().a((p)paramg, 0);
        AppMethodBeat.o(313611);
        return;
      }
    }
    a(l, locale.OMG, 3, 999, "image not exist", paramg);
    label223:
    AppMethodBeat.o(313611);
  }
  
  public final void a(c.a parama, g paramg)
  {
    AppMethodBeat.i(313654);
    kotlin.g.b.s.u(parama, "requestWrapper");
    kotlin.g.b.s.u(paramg, "resultCallback");
    com.tencent.threadpool.h.ahAA.bm(new b..ExternalSyntheticLambda1(parama, paramg));
    AppMethodBeat.o(313654);
  }
  
  public final void tN(long paramLong)
  {
    AppMethodBeat.i(313663);
    Log.i("MicroMsg.AiImageDefaultUploader", kotlin.g.b.s.X("cancelUploadImage-default session: ", Long.valueOf(paramLong)));
    AppMethodBeat.o(313663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.a.b
 * JD-Core Version:    0.7.0.1
 */