package com.tencent.mm.plugin.scanner.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.plugin.scanner.model.aa;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/image/AiScanSnsImageCDNStrategy;", "Lcom/tencent/mm/plugin/scanner/image/IAiScanImageCDNStrategy;", "()V", "getCDNImageInfoList", "", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "getCDNInfoCallback", "Lcom/tencent/mm/plugin/scanner/image/IAiScanImageCDNStrategy$GetCDNInfoCallback;", "name", "", "Companion", "plugin-scan_release"})
public final class j
  implements k
{
  public static final j.a IJP;
  
  static
  {
    AppMethodBeat.i(220191);
    IJP = new j.a((byte)0);
    AppMethodBeat.o(220191);
  }
  
  public final void a(e parame, k.a parama)
  {
    AppMethodBeat.i(220189);
    p.k(parame, "request");
    Object localObject1 = null;
    Object localObject2 = parame.IGp.getByteArray("key_sns_media_data");
    if (localObject2 != null) {
      localObject1 = new cvt();
    }
    try
    {
      ((cvt)localObject1).parseFrom((byte[])localObject2);
      label44:
      if (localObject1 == null)
      {
        Log.e("MicroMsg.AiScanSnsImageCDNStrategy", "alvinluo getCDNImageInfoList-sns parse mediaObj failed");
        parama.i(3, 999, "media object parse failed");
        AppMethodBeat.o(220189);
        return;
      }
      localObject2 = new ArrayList();
      mi localmi = new mi();
      localmi.RSa = 1;
      localmi.RRX = 4;
      localmi.url = ((cvt)localObject1).Url;
      localmi.token = ((cvt)localObject1).zZu;
      localmi.RSb = ((cvt)localObject1).TDT;
      localmi.RSc = d.Nb(((cvt)localObject1).TDU);
      Log.i("MicroMsg.AiScanSnsImageCDNStrategy", "alvinluo getCDNImageInfoList-sns url: %s", new Object[] { localmi.url });
      Log.d("MicroMsg.AiScanSnsImageCDNStrategy", "alvinluo getCDNImageInfoList-sns url: %s, token: %s, enc_idx: %s, enc_key: [%s, %s]", new Object[] { localmi.url, localmi.token, Integer.valueOf(localmi.RSb), Long.valueOf(localmi.RSc), ((cvt)localObject1).TDU });
      ((ArrayList)localObject2).add(localmi);
      Log.i("MicroMsg.AiScanSnsImageCDNStrategy", "alvinluo getCDNImageInfoList-sns request.pHash: %s, needPHash: %s", new Object[] { parame.IGB, Boolean.valueOf(parame.IGC) });
      if ((parame.IGB == null) && (parame.IGC) && (u.agG(parame.imagePath)))
      {
        localObject1 = aa.ILM;
        localObject1 = parame.imagePath;
        p.j(localObject1, "request.imagePath");
        parame.IGB = aa.aXh((String)localObject1);
      }
      parama.aZ((ArrayList)localObject2);
      AppMethodBeat.o(220189);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.j
 * JD-Core Version:    0.7.0.1
 */