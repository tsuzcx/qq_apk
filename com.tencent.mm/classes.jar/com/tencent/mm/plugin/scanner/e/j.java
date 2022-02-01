package com.tencent.mm.plugin.scanner.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/image/AiScanSnsImageCDNStrategy;", "Lcom/tencent/mm/plugin/scanner/image/IAiScanImageCDNStrategy;", "()V", "getCDNImageInfoList", "", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "getCDNInfoCallback", "Lcom/tencent/mm/plugin/scanner/image/IAiScanImageCDNStrategy$GetCDNInfoCallback;", "name", "", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements k
{
  public static final j.a OQC;
  
  static
  {
    AppMethodBeat.i(313610);
    OQC = new j.a((byte)0);
    AppMethodBeat.o(313610);
  }
  
  public final void a(e parame, k.a parama)
  {
    AppMethodBeat.i(313631);
    s.u(parame, "request");
    Object localObject1 = null;
    Object localObject2 = parame.OMx.getByteArray("key_sns_media_data");
    if (localObject2 != null) {
      localObject1 = new dmz();
    }
    try
    {
      ((dmz)localObject1).parseFrom((byte[])localObject2);
      label44:
      localObject2 = kotlin.ah.aiuX;
      if (localObject1 == null)
      {
        Log.e("MicroMsg.AiScanSnsImageCDNStrategy", "alvinluo getCDNImageInfoList-sns parse mediaObj failed");
        parama.j(3, 999, "media object parse failed");
        AppMethodBeat.o(313631);
        return;
      }
      localObject2 = new ArrayList();
      nn localnn = new nn();
      localnn.YPA = 1;
      localnn.YPx = 4;
      localnn.url = ((dmz)localObject1).Url;
      localnn.token = ((dmz)localObject1).msf;
      localnn.YPB = ((dmz)localObject1).aaTz;
      localnn.YPC = d.FK(((dmz)localObject1).aaTA);
      Log.i("MicroMsg.AiScanSnsImageCDNStrategy", "alvinluo getCDNImageInfoList-sns url: %s", new Object[] { localnn.url });
      Log.d("MicroMsg.AiScanSnsImageCDNStrategy", "alvinluo getCDNImageInfoList-sns url: %s, token: %s, enc_idx: %s, enc_key: [%s, %s]", new Object[] { localnn.url, localnn.token, Integer.valueOf(localnn.YPB), Long.valueOf(localnn.YPC), ((dmz)localObject1).aaTA });
      ((ArrayList)localObject2).add(localnn);
      Log.i("MicroMsg.AiScanSnsImageCDNStrategy", "alvinluo getCDNImageInfoList-sns request.pHash: %s, needPHash: %s", new Object[] { parame.OMJ, Boolean.valueOf(parame.OMK) });
      if ((parame.OMJ == null) && (parame.OMK) && (y.ZC(parame.imagePath)))
      {
        localObject1 = com.tencent.mm.plugin.scanner.model.ah.OSL;
        localObject1 = parame.imagePath;
        s.s(localObject1, "request.imagePath");
        parame.OMJ = com.tencent.mm.plugin.scanner.model.ah.aUL((String)localObject1);
      }
      parama.bx((ArrayList)localObject2);
      AppMethodBeat.o(313631);
      return;
    }
    catch (Exception localException)
    {
      break label44;
    }
  }
  
  public final String name()
  {
    return "MicroMsg.AiScanSnsImageCDNStrategy";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.j
 * JD-Core Version:    0.7.0.1
 */