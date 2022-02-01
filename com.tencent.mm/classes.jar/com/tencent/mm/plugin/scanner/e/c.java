package com.tencent.mm.plugin.scanner.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/image/AiScanChatImageUtils;", "", "()V", "TAG", "", "fillChatImageCDNInfo", "", "request", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageRequest;", "msgId", "", "compressType", "", "getHDImagePath", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "imagePath", "", "isHd", "hasHd", "getHDImageWithMsg", "canUseThumb", "getMidImageWithMsg", "getScanImagePath", "plugin-scan_release"})
public final class c
{
  public static final c IJz;
  
  static
  {
    AppMethodBeat.i(218457);
    IJz = new c();
    AppMethodBeat.o(218457);
  }
  
  public static final void a(f.b paramb, long paramLong, int paramInt)
  {
    AppMethodBeat.i(218454);
    p.k(paramb, "request");
    Object localObject1 = h.ae(n.class);
    p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    localObject1 = ((n)localObject1).eSe().Oq(paramLong);
    g localg = com.tencent.mm.ay.q.bmh().C(((ca)localObject1).apJ(), ((ca)localObject1).apH());
    Map localMap = XmlParser.parseXml(localg.blL(), "msg", null);
    if (localMap == null)
    {
      Log.e("MicroMsg.AiScanChatImageUtils", "fillImageCDNInfo parse cdnInfo failed. [%s]", new Object[] { localg.blL() });
      AppMethodBeat.o(218454);
      return;
    }
    String str1;
    if (paramInt != 1)
    {
      localObject1 = (String)localMap.get(".msg.img.$cdnmidimgurl");
      if (paramInt == 1) {
        break label320;
      }
      str1 = (String)localMap.get(".msg.img.$tpurl");
      label142:
      if (localObject1 != null) {
        break label342;
      }
    }
    label320:
    label342:
    for (Object localObject2 = "";; localObject2 = localObject1)
    {
      paramb.setFileId((String)localObject2);
      String str2 = (String)localMap.get(".msg.img.$aeskey");
      localObject2 = str2;
      if (str2 == null) {
        localObject2 = "";
      }
      paramb.setAesKey((String)localObject2);
      localObject2 = (CharSequence)str1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
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
        Log.v("MicroMsg.AiScanChatImageUtils", "alvinluo fillImageCDNInfo msg content: %s", new Object[] { localg.blL() });
        AppMethodBeat.o(218454);
        return;
        localObject1 = (String)localMap.get(".msg.img.$cdnbigimgurl");
        break;
        str1 = (String)localMap.get(".msg.img.$tphdurl");
        break label142;
      }
    }
  }
  
  static void a(ca paramca, kotlin.g.a.q<? super String, ? super Boolean, ? super Boolean, x> paramq)
  {
    AppMethodBeat.i(218452);
    if (paramca == null)
    {
      paramca = Boolean.FALSE;
      paramq.c(null, paramca, paramca);
      AppMethodBeat.o(218452);
      return;
    }
    if ((!paramca.hwG()) && (!paramca.hzF()))
    {
      paramca = Boolean.FALSE;
      paramq.c(null, paramca, paramca);
      AppMethodBeat.o(218452);
      return;
    }
    long l;
    Object localObject2;
    Object localObject1;
    if (paramca.apA() == 1)
    {
      l = paramca.apG();
      localObject2 = com.tencent.mm.ay.q.bmh().D(paramca.apJ(), l);
      p.j(localObject2, "SubCoreImage.getImgStg()…sgLocalId(msg.talker, id)");
      localObject1 = localObject2;
      if (((g)localObject2).getLocalId() == 0L)
      {
        l = paramca.apH();
        Log.d("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath img invalid and try get by msgSvrId: %s", new Object[] { Long.valueOf(l) });
        localObject1 = com.tencent.mm.ay.q.bmh().C(paramca.apJ(), l);
        p.j(localObject1, "SubCoreImage.getImgStg()…yMsgSvrId(msg.talker, id)");
      }
      localObject2 = com.tencent.mm.ay.q.bmh().a(paramca.apJ(), (g)localObject1);
      paramca = com.tencent.mm.ay.q.bmh().r((String)localObject2, "", "");
      Log.d("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath hdImagePath %s, %s", new Object[] { localObject2, paramca });
      if (u.agG(paramca))
      {
        localObject1 = Boolean.TRUE;
        paramq.c(paramca, localObject1, localObject1);
        AppMethodBeat.o(218452);
        return;
      }
      localObject1 = ((g)localObject1).blG();
      paramca = com.tencent.mm.ay.q.bmh().r((String)localObject1, "", "");
      Log.d("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath bigImagePath %s, %s", new Object[] { localObject1, paramca });
      if (u.agG(paramca))
      {
        localObject1 = Boolean.FALSE;
        paramq.c(paramca, localObject1, localObject1);
        AppMethodBeat.o(218452);
      }
    }
    else
    {
      l = paramca.apH();
      localObject1 = com.tencent.mm.ay.q.bmh().C(paramca.apJ(), l);
      p.j(localObject1, "SubCoreImage.getImgStg()…yMsgSvrId(msg.talker, id)");
      if (((g)localObject1).blK())
      {
        localObject2 = com.tencent.mm.ay.q.bmh().a(paramca.apJ(), (g)localObject1);
        paramca = com.tencent.mm.ay.q.bmh().r((String)localObject2, "", "");
        Log.d("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath receiver hdImagePath %s, %s", new Object[] { localObject2, paramca });
        if (u.agG(paramca))
        {
          localObject1 = Boolean.TRUE;
          paramq.c(paramca, localObject1, localObject1);
          AppMethodBeat.o(218452);
          return;
        }
      }
      paramca = ((g)localObject1).blG();
      localObject2 = com.tencent.mm.ay.q.bmh().r(paramca, "", "");
      Log.d("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath receiver bigImagePath %s, %s", new Object[] { paramca, localObject2 });
      if (u.agG((String)localObject2)) {
        paramq.c(localObject2, Boolean.FALSE, Boolean.valueOf(((g)localObject1).blK()));
      }
    }
    AppMethodBeat.o(218452);
  }
  
  public static String bb(ca paramca)
  {
    AppMethodBeat.i(218449);
    if (paramca == null)
    {
      AppMethodBeat.o(218449);
      return null;
    }
    if ((!paramca.hwG()) && (!paramca.hzF()))
    {
      AppMethodBeat.o(218449);
      return null;
    }
    paramca = com.tencent.mm.ay.q.bmh().VY(paramca.apK()) + "hd";
    Log.i("MicroMsg.AiScanChatImageUtils", "alvinluo getImagePath hdThumbPath: %s", new Object[] { paramca });
    if (u.agG(paramca))
    {
      AppMethodBeat.o(218449);
      return paramca;
    }
    AppMethodBeat.o(218449);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.c
 * JD-Core Version:    0.7.0.1
 */