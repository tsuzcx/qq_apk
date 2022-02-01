package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import com.tencent.qbar.d;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/ScanImageUtils;", "", "()V", "TAG", "", "computeImagePHash", "Lcom/tencent/mm/plugin/scanner/model/ScanImagePHashInfo;", "imagePath", "getScanImagePath", "msgId", "", "plugin-scan_release"})
public final class z
{
  public static final z ynN;
  
  static
  {
    AppMethodBeat.i(186317);
    ynN = new z();
    AppMethodBeat.o(186317);
  }
  
  public static ScanImagePHashInfo awH(String paramString)
  {
    AppMethodBeat.i(186315);
    p.h(paramString, "imagePath");
    for (;;)
    {
      try
      {
        localObject = com.tencent.mm.sdk.platformtools.g.decodeFile(paramString);
        if (localObject != null)
        {
          int i = ((Bitmap)localObject).getWidth();
          int j = ((Bitmap)localObject).getHeight();
          ad.i("MicroMsg.ScanImageUtils", "computeImagePHash width: %d, height: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          paramString = new int[i * j];
          ((Bitmap)localObject).getPixels(paramString, 0, ((Bitmap)localObject).getWidth(), 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
          ((Bitmap)localObject).recycle();
          localObject = new byte[i * j];
          int k = d.a(paramString, (byte[])localObject, i, j);
          if (k != 0)
          {
            ad.e("MicroMsg.ScanImageUtils", "computeImagePHash transBytes failed result: %d", new Object[] { Integer.valueOf(k) });
            AppMethodBeat.o(186315);
            return null;
          }
          ScanImagePHashInfo localScanImagePHashInfo = u.B((byte[])localObject, i, j);
          if (localScanImagePHashInfo == null) {
            break label219;
          }
          paramString = localScanImagePHashInfo.getPHash();
          if (localScanImagePHashInfo == null) {
            break label224;
          }
          localObject = localScanImagePHashInfo.getPHashVersion();
          ad.d("MicroMsg.ScanImageUtils", "alvinluo computeImagePHash pHash: %s, pHashVersion: %s", new Object[] { paramString, localObject });
          AppMethodBeat.o(186315);
          return localScanImagePHashInfo;
        }
      }
      catch (Throwable paramString)
      {
        ad.printErrStackTrace("MicroMsg.ScanImageUtils", paramString, "computeImagePHash exception", new Object[0]);
        AppMethodBeat.o(186315);
        return null;
      }
      label219:
      paramString = null;
      continue;
      label224:
      Object localObject = null;
    }
  }
  
  public static String yY(long paramLong)
  {
    AppMethodBeat.i(186316);
    Object localObject1 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).dlK().xY(paramLong);
    p.g(localObject1, "msg");
    if ((!((bu)localObject1).fpi()) && (!((bu)localObject1).frK()))
    {
      AppMethodBeat.o(186316);
      return null;
    }
    Object localObject2 = q.aIF().Fn(((bu)localObject1).VT()) + "hd";
    ad.i("MicroMsg.ScanImageUtils", "alvinluo getImagePath hdThumbPath: %s", new Object[] { localObject2 });
    if (com.tencent.mm.vfs.i.fv((String)localObject2))
    {
      AppMethodBeat.o(186316);
      return localObject2;
    }
    String str1;
    String str2;
    if (((bu)localObject1).VR() == 1)
    {
      paramLong = ((bu)localObject1).VP();
      localObject2 = q.aIF().G(((bu)localObject1).VS(), paramLong);
      p.g(localObject2, "SubCoreImage.getImgStg()…sgLocalId(msg.talker, id)");
      str1 = ((com.tencent.mm.aw.g)localObject2).aIf();
      str2 = q.aIF().o(str1, "", "");
      ad.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath bigImagePath %s, %s", new Object[] { str1, str2 });
      if (com.tencent.mm.vfs.i.fv(str2))
      {
        AppMethodBeat.o(186316);
        return str2;
      }
      localObject1 = q.aIF().a(((bu)localObject1).VS(), (com.tencent.mm.aw.g)localObject2);
      localObject2 = q.aIF().o((String)localObject1, "", "");
      ad.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath hdImagePath %s, %s", new Object[] { localObject1, localObject2 });
      if (com.tencent.mm.vfs.i.fv((String)localObject2))
      {
        AppMethodBeat.o(186316);
        return localObject2;
      }
    }
    else
    {
      paramLong = ((bu)localObject1).VQ();
      localObject2 = q.aIF().F(((bu)localObject1).VS(), paramLong);
      p.g(localObject2, "SubCoreImage.getImgStg()…yMsgSvrId(msg.talker, id)");
      str1 = ((com.tencent.mm.aw.g)localObject2).aIf();
      str2 = q.aIF().o(str1, "", "");
      ad.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath receiver bigImagePath %s, %s", new Object[] { str1, str2 });
      if (com.tencent.mm.vfs.i.fv(str2))
      {
        AppMethodBeat.o(186316);
        return str2;
      }
      if (((com.tencent.mm.aw.g)localObject2).aIj())
      {
        localObject1 = q.aIF().a(((bu)localObject1).VS(), (com.tencent.mm.aw.g)localObject2);
        str1 = q.aIF().o((String)localObject1, "", "");
        ad.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath receiver hdImagePath %s, %s", new Object[] { localObject1, str1 });
        if (com.tencent.mm.vfs.i.fv(str1))
        {
          AppMethodBeat.o(186316);
          return str1;
        }
      }
      localObject1 = ((com.tencent.mm.aw.g)localObject2).aIh();
      localObject2 = q.aIF().Fn((String)localObject1);
      ad.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath receiver thumbImagePath: %s, %s", new Object[] { localObject1, localObject2 });
      AppMethodBeat.o(186316);
      return localObject2;
    }
    AppMethodBeat.o(186316);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.z
 * JD-Core Version:    0.7.0.1
 */