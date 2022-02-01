package com.tencent.mm.plugin.scanner.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/image/AiScanChatImageUtils;", "", "()V", "TAG", "", "fillChatImageCDNInfo", "", "request", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageRequest;", "msgId", "", "compressType", "", "getHDImagePath", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "imagePath", "", "isHd", "hasHd", "getHDImageWithMsg", "canUseThumb", "getMidImageWithMsg", "getScanImagePath", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c OQm;
  
  static
  {
    AppMethodBeat.i(313674);
    OQm = new c();
    AppMethodBeat.o(313674);
  }
  
  public static final void a(f.b paramb, long paramLong, int paramInt)
  {
    AppMethodBeat.i(313670);
    s.u(paramb, "request");
    Object localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramLong);
    if (localObject1 == null)
    {
      AppMethodBeat.o(313670);
      return;
    }
    com.tencent.mm.modelimage.h localh = r.bKa().G(((fi)localObject1).field_talker, ((fi)localObject1).field_msgSvrId);
    if (localh == null)
    {
      AppMethodBeat.o(313670);
      return;
    }
    Map localMap = XmlParser.parseXml(localh.oGC, "msg", null);
    if (localMap == null)
    {
      Log.e("MicroMsg.AiScanChatImageUtils", "fillImageCDNInfo parse cdnInfo failed. [%s]", new Object[] { localh.oGC });
      AppMethodBeat.o(313670);
      return;
    }
    String str1;
    label153:
    Object localObject2;
    label162:
    String str2;
    if (paramInt != 1)
    {
      localObject1 = (String)localMap.get(".msg.img.$cdnmidimgurl");
      if (paramInt == 1) {
        break label331;
      }
      str1 = (String)localMap.get(".msg.img.$tpurl");
      if (localObject1 != null) {
        break label348;
      }
      localObject2 = "";
      paramb.setFileId((String)localObject2);
      str2 = (String)localMap.get(".msg.img.$aeskey");
      localObject2 = str2;
      if (str2 == null) {
        localObject2 = "";
      }
      paramb.setAesKey((String)localObject2);
      localObject2 = (CharSequence)str1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label355;
      }
    }
    label331:
    label348:
    label355:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0)
      {
        paramb.setFileId(str1);
        str2 = (String)localMap.get(".msg.img.$tpauthkey");
        localObject2 = str2;
        if (str2 == null) {
          localObject2 = "";
        }
        paramb.setAesKey((String)localObject2);
      }
      Log.d("MicroMsg.AiScanChatImageUtils", "alvinluo fillImageCDNInfo url: %s, tpUrl: %s", new Object[] { localObject1, str1 });
      Log.v("MicroMsg.AiScanChatImageUtils", "alvinluo fillImageCDNInfo msg content: %s", new Object[] { localh.oGC });
      AppMethodBeat.o(313670);
      return;
      localObject1 = (String)localMap.get(".msg.img.$cdnbigimgurl");
      break;
      str1 = (String)localMap.get(".msg.img.$tphdurl");
      break label153;
      localObject2 = localObject1;
      break label162;
    }
  }
  
  static void a(cc paramcc, q<? super String, ? super Boolean, ? super Boolean, ah> paramq)
  {
    AppMethodBeat.i(313656);
    if (paramcc == null)
    {
      paramcc = Boolean.FALSE;
      paramq.invoke(null, paramcc, paramcc);
      AppMethodBeat.o(313656);
      return;
    }
    if ((!paramcc.iYk()) && (!paramcc.jbK()))
    {
      paramcc = Boolean.FALSE;
      paramq.invoke(null, paramcc, paramcc);
      AppMethodBeat.o(313656);
      return;
    }
    long l;
    Object localObject2;
    Object localObject1;
    if (paramcc.field_isSend == 1)
    {
      l = paramcc.field_msgId;
      localObject2 = r.bKa().H(paramcc.field_talker, l);
      s.s(localObject2, "getImgStg().getByMsgLocalId(msg.talker, id)");
      localObject1 = localObject2;
      if (((com.tencent.mm.modelimage.h)localObject2).localId == 0L)
      {
        l = paramcc.field_msgSvrId;
        Log.d("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath img invalid and try get by msgSvrId: %s", new Object[] { Long.valueOf(l) });
        localObject1 = r.bKa().G(paramcc.field_talker, l);
        s.s(localObject1, "getImgStg().getByMsgSvrId(msg.talker, id)");
      }
      localObject2 = r.bKa().a(paramcc.field_talker, (com.tencent.mm.modelimage.h)localObject1);
      paramcc = r.bKa().v((String)localObject2, "", "");
      Log.d("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath hdImagePath %s, %s", new Object[] { localObject2, paramcc });
      if (y.ZC(paramcc))
      {
        localObject1 = Boolean.TRUE;
        paramq.invoke(paramcc, localObject1, localObject1);
        AppMethodBeat.o(313656);
        return;
      }
      localObject1 = ((com.tencent.mm.modelimage.h)localObject1).oGr;
      paramcc = r.bKa().v((String)localObject1, "", "");
      Log.d("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath bigImagePath %s, %s", new Object[] { localObject1, paramcc });
      if (y.ZC(paramcc))
      {
        localObject1 = Boolean.FALSE;
        paramq.invoke(paramcc, localObject1, localObject1);
        AppMethodBeat.o(313656);
      }
    }
    else
    {
      l = paramcc.field_msgSvrId;
      localObject1 = r.bKa().G(paramcc.field_talker, l);
      s.s(localObject1, "getImgStg().getByMsgSvrId(msg.talker, id)");
      if (((com.tencent.mm.modelimage.h)localObject1).bJE())
      {
        localObject2 = r.bKa().a(paramcc.field_talker, (com.tencent.mm.modelimage.h)localObject1);
        paramcc = r.bKa().v((String)localObject2, "", "");
        Log.d("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath receiver hdImagePath %s, %s", new Object[] { localObject2, paramcc });
        if (y.ZC(paramcc))
        {
          localObject1 = Boolean.TRUE;
          paramq.invoke(paramcc, localObject1, localObject1);
          AppMethodBeat.o(313656);
          return;
        }
      }
      paramcc = ((com.tencent.mm.modelimage.h)localObject1).oGr;
      localObject2 = r.bKa().v(paramcc, "", "");
      Log.d("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath receiver bigImagePath %s, %s", new Object[] { paramcc, localObject2 });
      if (y.ZC((String)localObject2)) {
        paramq.invoke(localObject2, Boolean.FALSE, Boolean.valueOf(((com.tencent.mm.modelimage.h)localObject1).bJE()));
      }
    }
    AppMethodBeat.o(313656);
  }
  
  public static String bs(cc paramcc)
  {
    AppMethodBeat.i(313637);
    if (paramcc == null)
    {
      AppMethodBeat.o(313637);
      return null;
    }
    if ((!paramcc.iYk()) && (!paramcc.jbK()))
    {
      AppMethodBeat.o(313637);
      return null;
    }
    paramcc = s.X(r.bKa().X(paramcc.field_imgPath, true), "hd");
    Log.i("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath hdThumbPath: %s", new Object[] { paramcc });
    if (y.ZC(paramcc))
    {
      AppMethodBeat.o(313637);
      return paramcc;
    }
    AppMethodBeat.o(313637);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.c
 * JD-Core Version:    0.7.0.1
 */