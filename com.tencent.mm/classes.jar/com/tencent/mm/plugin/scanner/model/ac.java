package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import com.tencent.qbar.d;
import kotlin.g.b.p;
import kotlin.n.n;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/ScanImageUtils;", "", "()V", "TAG", "", "computeImagePHash", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "imagePath", "getHDScanImagePath", "msgId", "", "canUseThumb", "", "getScanHDImageWithMsg", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "getScanImagePath", "getScanImageWithMsg", "plugin-scan_release"})
public final class ac
{
  public static final ac CGB;
  
  static
  {
    AppMethodBeat.i(240452);
    CGB = new ac();
    AppMethodBeat.o(240452);
  }
  
  public static String G(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(240451);
    Object localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).eiy().Hb(paramLong);
    p.g(localca, "msg");
    if ((!localca.gAz()) && (!localca.gDr()))
    {
      AppMethodBeat.o(240451);
      return null;
    }
    localObject = aN(localca);
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (n.aL(localCharSequence))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localObject = d(localca, paramBoolean);
      }
      AppMethodBeat.o(240451);
      return localObject;
    }
  }
  
  public static ScanImagePHashInfo aMA(String paramString)
  {
    AppMethodBeat.i(240448);
    p.h(paramString, "imagePath");
    for (;;)
    {
      try
      {
        localObject = BitmapUtil.decodeFile(paramString);
        if (localObject != null)
        {
          int i = ((Bitmap)localObject).getWidth();
          int j = ((Bitmap)localObject).getHeight();
          Log.i("MicroMsg.ScanImageUtils", "computeImagePHash width: %d, height: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          paramString = new int[i * j];
          ((Bitmap)localObject).getPixels(paramString, 0, ((Bitmap)localObject).getWidth(), 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
          ((Bitmap)localObject).recycle();
          localObject = new byte[i * j];
          int k = d.a(paramString, (byte[])localObject, i, j);
          if (k != 0)
          {
            Log.e("MicroMsg.ScanImageUtils", "computeImagePHash transBytes failed result: %d", new Object[] { Integer.valueOf(k) });
            AppMethodBeat.o(240448);
            return null;
          }
          ScanImagePHashInfo localScanImagePHashInfo = x.M((byte[])localObject, i, j);
          if (localScanImagePHashInfo == null) {
            break label219;
          }
          paramString = localScanImagePHashInfo.pHash;
          if (localScanImagePHashInfo == null) {
            break label224;
          }
          localObject = localScanImagePHashInfo.pHashVersion;
          Log.d("MicroMsg.ScanImageUtils", "alvinluo computeImagePHash pHash: %s, pHashVersion: %s", new Object[] { paramString, localObject });
          AppMethodBeat.o(240448);
          return localScanImagePHashInfo;
        }
      }
      catch (Throwable paramString)
      {
        Log.printErrStackTrace("MicroMsg.ScanImageUtils", paramString, "computeImagePHash exception", new Object[0]);
        AppMethodBeat.o(240448);
        return null;
      }
      label219:
      paramString = null;
      continue;
      label224:
      Object localObject = null;
    }
  }
  
  static String aN(ca paramca)
  {
    AppMethodBeat.i(240449);
    if (paramca == null)
    {
      AppMethodBeat.o(240449);
      return null;
    }
    if ((!paramca.gAz()) && (!paramca.gDr()))
    {
      AppMethodBeat.o(240449);
      return null;
    }
    paramca = q.bcR().OA(paramca.ajP()) + "hd";
    Log.i("MicroMsg.ScanImageUtils", "alvinluo getImagePath hdThumbPath: %s", new Object[] { paramca });
    if (s.YS(paramca))
    {
      AppMethodBeat.o(240449);
      return paramca;
    }
    AppMethodBeat.o(240449);
    return null;
  }
  
  static String d(ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(240450);
    if (paramca == null)
    {
      AppMethodBeat.o(240450);
      return null;
    }
    if ((!paramca.gAz()) && (!paramca.gDr()))
    {
      AppMethodBeat.o(240450);
      return null;
    }
    long l;
    Object localObject2;
    Object localObject1;
    String str;
    if (paramca.ajN() == 1)
    {
      l = paramca.ajL();
      localObject2 = q.bcR().H(paramca.ajO(), l);
      p.g(localObject2, "SubCoreImage.getImgStg()…sgLocalId(msg.talker, id)");
      localObject1 = localObject2;
      if (((com.tencent.mm.av.g)localObject2).getLocalId() == 0L)
      {
        l = paramca.ajM();
        Log.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath img invalid and try get by msgSvrId: %s", new Object[] { Long.valueOf(l) });
        localObject1 = q.bcR().G(paramca.ajO(), l);
        p.g(localObject1, "SubCoreImage.getImgStg()…yMsgSvrId(msg.talker, id)");
      }
      localObject2 = ((com.tencent.mm.av.g)localObject1).bcr();
      str = q.bcR().o((String)localObject2, "", "");
      Log.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath bigImagePath %s, %s", new Object[] { localObject2, str });
      if (s.YS(str))
      {
        AppMethodBeat.o(240450);
        return str;
      }
      paramca = q.bcR().a(paramca.ajO(), (com.tencent.mm.av.g)localObject1);
      localObject1 = q.bcR().o(paramca, "", "");
      Log.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath hdImagePath %s, %s", new Object[] { paramca, localObject1 });
      if (s.YS((String)localObject1))
      {
        AppMethodBeat.o(240450);
        return localObject1;
      }
    }
    else
    {
      l = paramca.ajM();
      localObject1 = q.bcR().G(paramca.ajO(), l);
      p.g(localObject1, "SubCoreImage.getImgStg()…yMsgSvrId(msg.talker, id)");
      localObject2 = ((com.tencent.mm.av.g)localObject1).bcr();
      str = q.bcR().o((String)localObject2, "", "");
      Log.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath receiver bigImagePath %s, %s", new Object[] { localObject2, str });
      if (s.YS(str))
      {
        AppMethodBeat.o(240450);
        return str;
      }
      if (((com.tencent.mm.av.g)localObject1).bcv())
      {
        paramca = q.bcR().a(paramca.ajO(), (com.tencent.mm.av.g)localObject1);
        localObject2 = q.bcR().o(paramca, "", "");
        Log.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath receiver hdImagePath %s, %s", new Object[] { paramca, localObject2 });
        if (s.YS((String)localObject2))
        {
          AppMethodBeat.o(240450);
          return localObject2;
        }
      }
      if (paramBoolean)
      {
        paramca = ((com.tencent.mm.av.g)localObject1).bct();
        localObject1 = q.bcR().OA(paramca);
        Log.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath receiver thumbImagePath: %s, %s", new Object[] { paramca, localObject1 });
        AppMethodBeat.o(240450);
        return localObject1;
      }
    }
    AppMethodBeat.o(240450);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ac
 * JD-Core Version:    0.7.0.1
 */