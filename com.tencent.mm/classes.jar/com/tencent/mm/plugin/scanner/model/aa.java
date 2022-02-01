package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.o;
import com.tencent.qbar.d;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/ScanImageUtils;", "", "()V", "TAG", "", "computeImagePHash", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "imagePath", "getScanImagePath", "msgId", "", "canUseThumb", "", "plugin-scan_release"})
public final class aa
{
  public static final aa yDM;
  
  static
  {
    AppMethodBeat.i(189607);
    yDM = new aa();
    AppMethodBeat.o(189607);
  }
  
  public static String A(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(189606);
    Object localObject1 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).doJ().ys(paramLong);
    p.g(localObject1, "msg");
    if ((!((bv)localObject1).ftg()) && (!((bv)localObject1).fvK()))
    {
      AppMethodBeat.o(189606);
      return null;
    }
    Object localObject2 = q.aIX().FP(((bv)localObject1).Wb()) + "hd";
    ae.i("MicroMsg.ScanImageUtils", "alvinluo getImagePath hdThumbPath: %s", new Object[] { localObject2 });
    if (o.fB((String)localObject2))
    {
      AppMethodBeat.o(189606);
      return localObject2;
    }
    String str1;
    String str2;
    if (((bv)localObject1).VZ() == 1)
    {
      paramLong = ((bv)localObject1).VX();
      localObject2 = q.aIX().G(((bv)localObject1).Wa(), paramLong);
      p.g(localObject2, "SubCoreImage.getImgStg()…sgLocalId(msg.talker, id)");
      str1 = ((com.tencent.mm.av.g)localObject2).aIx();
      str2 = q.aIX().o(str1, "", "");
      ae.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath bigImagePath %s, %s", new Object[] { str1, str2 });
      if (o.fB(str2))
      {
        AppMethodBeat.o(189606);
        return str2;
      }
      localObject1 = q.aIX().a(((bv)localObject1).Wa(), (com.tencent.mm.av.g)localObject2);
      localObject2 = q.aIX().o((String)localObject1, "", "");
      ae.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath hdImagePath %s, %s", new Object[] { localObject1, localObject2 });
      if (o.fB((String)localObject2))
      {
        AppMethodBeat.o(189606);
        return localObject2;
      }
    }
    else
    {
      paramLong = ((bv)localObject1).VY();
      localObject2 = q.aIX().F(((bv)localObject1).Wa(), paramLong);
      p.g(localObject2, "SubCoreImage.getImgStg()…yMsgSvrId(msg.talker, id)");
      str1 = ((com.tencent.mm.av.g)localObject2).aIx();
      str2 = q.aIX().o(str1, "", "");
      ae.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath receiver bigImagePath %s, %s", new Object[] { str1, str2 });
      if (o.fB(str2))
      {
        AppMethodBeat.o(189606);
        return str2;
      }
      if (((com.tencent.mm.av.g)localObject2).aIB())
      {
        localObject1 = q.aIX().a(((bv)localObject1).Wa(), (com.tencent.mm.av.g)localObject2);
        str1 = q.aIX().o((String)localObject1, "", "");
        ae.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath receiver hdImagePath %s, %s", new Object[] { localObject1, str1 });
        if (o.fB(str1))
        {
          AppMethodBeat.o(189606);
          return str1;
        }
      }
      if (paramBoolean)
      {
        localObject1 = ((com.tencent.mm.av.g)localObject2).aIz();
        localObject2 = q.aIX().FP((String)localObject1);
        ae.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath receiver thumbImagePath: %s, %s", new Object[] { localObject1, localObject2 });
        AppMethodBeat.o(189606);
        return localObject2;
      }
    }
    AppMethodBeat.o(189606);
    return null;
  }
  
  public static ScanImagePHashInfo axW(String paramString)
  {
    AppMethodBeat.i(189605);
    p.h(paramString, "imagePath");
    for (;;)
    {
      try
      {
        localObject = h.decodeFile(paramString);
        if (localObject != null)
        {
          int i = ((Bitmap)localObject).getWidth();
          int j = ((Bitmap)localObject).getHeight();
          ae.i("MicroMsg.ScanImageUtils", "computeImagePHash width: %d, height: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          paramString = new int[i * j];
          ((Bitmap)localObject).getPixels(paramString, 0, ((Bitmap)localObject).getWidth(), 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
          ((Bitmap)localObject).recycle();
          localObject = new byte[i * j];
          int k = d.a(paramString, (byte[])localObject, i, j);
          if (k != 0)
          {
            ae.e("MicroMsg.ScanImageUtils", "computeImagePHash transBytes failed result: %d", new Object[] { Integer.valueOf(k) });
            AppMethodBeat.o(189605);
            return null;
          }
          ScanImagePHashInfo localScanImagePHashInfo = v.C((byte[])localObject, i, j);
          if (localScanImagePHashInfo == null) {
            break label219;
          }
          paramString = localScanImagePHashInfo.pHash;
          if (localScanImagePHashInfo == null) {
            break label224;
          }
          localObject = localScanImagePHashInfo.pHashVersion;
          ae.d("MicroMsg.ScanImageUtils", "alvinluo computeImagePHash pHash: %s, pHashVersion: %s", new Object[] { paramString, localObject });
          AppMethodBeat.o(189605);
          return localScanImagePHashInfo;
        }
      }
      catch (Throwable paramString)
      {
        ae.printErrStackTrace("MicroMsg.ScanImageUtils", paramString, "computeImagePHash exception", new Object[0]);
        AppMethodBeat.o(189605);
        return null;
      }
      label219:
      paramString = null;
      continue;
      label224:
      Object localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.aa
 * JD-Core Version:    0.7.0.1
 */