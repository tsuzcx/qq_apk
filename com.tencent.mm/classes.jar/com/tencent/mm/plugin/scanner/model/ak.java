package com.tencent.mm.plugin.scanner.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.scan_goods_new.f;
import com.tencent.mm.plugin.scanner.scan_goods_new.g;
import com.tencent.mm.plugin.scanner.scan_goods_new.i;
import com.tencent.mm.plugin.scanner.scan_goods_new.k;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanCodeProductMergeMaskView;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.tools.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/ScanProductGalleryHelper;", "", "scanUIModel", "Lcom/tencent/mm/plugin/scanner/model/IScanUIModel;", "(Lcom/tencent/mm/plugin/scanner/model/IScanUIModel;)V", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "currentSession", "", "newAiImageHandler", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/NewAiImageHandler;", "resultCallback", "Lcom/tencent/mm/plugin/scanner/model/ScanProductGalleryHelper$ScanProductGalleryResultCallback;", "scanProductCallbackForGalleryImage", "com/tencent/mm/plugin/scanner/model/ScanProductGalleryHelper$scanProductCallbackForGalleryImage$1", "Lcom/tencent/mm/plugin/scanner/model/ScanProductGalleryHelper$scanProductCallbackForGalleryImage$1;", "handleScanGalleryImage", "", "session", "resultCode", "", "data", "Landroid/content/Intent;", "currentMode", "scanSource", "callback", "release", "scanProductByFile", "source", "filePath", "", "rotation", "Companion", "ScanProductGalleryResultCallback", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ak
{
  public static final ak.a OSV;
  private long ORb;
  private final h OSW;
  private b OSX;
  private c OSY;
  private g OSZ;
  private DialogInterface.OnCancelListener OTa;
  
  static
  {
    AppMethodBeat.i(314302);
    OSV = new ak.a((byte)0);
    AppMethodBeat.o(314302);
  }
  
  public ak(h paramh)
  {
    AppMethodBeat.i(314281);
    this.OSW = paramh;
    this.ORb = -1L;
    this.OSY = new c(this);
    AppMethodBeat.o(314281);
  }
  
  private static final void a(ak paramak, long paramLong, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(314287);
    s.u(paramak, "this$0");
    Log.i("MicroMsg.ScanProductForGalleryHelper", "processGoodsImage onCancel and resumeScan");
    paramak.OSW.gQM();
    paramak = paramak.OSZ;
    if (paramak != null) {
      paramak.Q(paramLong, false);
    }
    AppMethodBeat.o(314287);
  }
  
  public final void a(long paramLong, int paramInt1, Intent paramIntent, int paramInt2, b paramb)
  {
    AppMethodBeat.i(314320);
    s.u(paramb, "callback");
    boolean bool;
    label89:
    Object localObject1;
    if (paramIntent == null)
    {
      bool = true;
      Log.i("MicroMsg.ScanProductForGalleryHelper", "handleScanGalleryImage resultCode: %d, data == null: %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool) });
      this.ORb = paramLong;
      if (paramInt1 != -1) {
        break label689;
      }
      this.OSX = paramb;
      paramb = b.i(this.OSW.getUIContext(), paramIntent, com.tencent.mm.plugin.image.d.bzL());
      if (paramIntent != null) {
        break label552;
      }
      bool = true;
      Log.d("MicroMsg.ScanProductForGalleryHelper", "handleScanGalleryImage session: %d, resultCode: %d, filePath: %s, data == null: %b", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), paramb, Boolean.valueOf(bool) });
      paramIntent = this.OSW.gQP();
      if (paramIntent != null) {
        paramIntent.setScanSource(paramInt2);
      }
      paramInt1 = BackwardSupportUtil.ExifHelper.getExifOrientation(paramb);
      long l1 = System.currentTimeMillis();
      paramIntent = BitmapUtil.decodeFileWithSample(paramb);
      long l2 = System.currentTimeMillis();
      switch (paramInt1)
      {
      default: 
        label200:
        Log.i("MicroMsg.ScanProductForGalleryHelper", "handleScanGalleryImage decode image cost: %d, rotation: %s", new Object[] { Long.valueOf(l2 - l1), Integer.valueOf(paramInt1) });
        if ((paramIntent != null) && (!paramIntent.isRecycled()))
        {
          localObject1 = this.OSW.gQP();
          if ((localObject1 instanceof ScanGoodsMaskView)) {
            ((ScanGoodsMaskView)localObject1).az(paramIntent);
          }
        }
        else
        {
          label271:
          this.OTa = new ak..ExternalSyntheticLambda0(this, paramLong);
          paramIntent = this.OSW.gQP();
          if (paramIntent != null) {
            paramIntent.b(true, this.OTa);
          }
          s.s(paramb, "filePath");
          localObject1 = com.tencent.mm.plugin.scanner.util.a.j.a(paramb, paramInt1, 122880, null);
          if ((localObject1 == null) || (localObject1.length > 122880)) {
            break label599;
          }
          paramInt1 = 1;
          label343:
          paramb = new d.a();
          if (paramInt1 == 0) {
            break label615;
          }
          if (localObject1 != null) {
            break label604;
          }
        }
        break;
      }
    }
    label552:
    label599:
    label604:
    for (paramIntent = null;; paramIntent = Integer.valueOf(localObject1.length))
    {
      Log.i("MicroMsg.ScanProductForGalleryHelper", "scanProductForFile compressImage success final data length: %d", new Object[] { paramIntent });
      if (this.OSZ == null) {
        this.OSZ = new g((f)this.OSY);
      }
      paramIntent = this.OSZ;
      if (paramIntent == null) {
        break label683;
      }
      k localk = new k();
      localk.source = paramInt2;
      localk.hBk = paramLong;
      localk.OWB = 1;
      ArrayList localArrayList = localk.OWA;
      Object localObject2 = new ScanProductInfo();
      ((ScanProductInfo)localObject2).setId(-1);
      ah localah = ah.aiuX;
      localObject2 = new com.tencent.mm.plugin.scanner.scan_goods_new.j((ScanProductInfo)localObject2);
      paramb.ORm = localObject1.length;
      paramb.ORl = 1;
      localah = ah.aiuX;
      ((com.tencent.mm.plugin.scanner.scan_goods_new.j)localObject2).OWg = paramb;
      ((com.tencent.mm.plugin.scanner.scan_goods_new.j)localObject2).OWj = ((byte[])localObject1);
      paramb = ah.aiuX;
      localArrayList.add(localObject2);
      paramb = ah.aiuX;
      paramIntent.c(localk);
      AppMethodBeat.o(314320);
      return;
      bool = false;
      break;
      bool = false;
      break label89;
      paramIntent = BitmapUtil.rotate(paramIntent, paramInt1);
      break label200;
      if (!(localObject1 instanceof ScanCodeProductMergeMaskView)) {
        break label271;
      }
      ((ScanCodeProductMergeMaskView)localObject1).az(paramIntent);
      ((ScanCodeProductMergeMaskView)localObject1).gTp();
      break label271;
      paramInt1 = 0;
      break label343;
    }
    label615:
    Log.e("MicroMsg.ScanProductForGalleryHelper", "scanProductByFile compressImage failed");
    if (this.ORb == paramLong)
    {
      d.a(11, paramb);
      paramIntent = this.OSY;
      localObject1 = new i(paramInt2, paramLong, 2);
      ((i)localObject1).OWg = paramb;
      paramb = ah.aiuX;
      paramIntent.a((i)localObject1, 1001, "scan by file compressImage failed");
    }
    label683:
    AppMethodBeat.o(314320);
    return;
    label689:
    this.OSW.gQM();
    if (paramInt1 == 0) {
      am.aia(12);
    }
    AppMethodBeat.o(314320);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/ScanProductGalleryHelper$ScanProductGalleryResultCallback;", "", "onScanCancel", "", "session", "", "onScanFailed", "result", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeResult;", "source", "", "errCode", "errMsg", "", "onScanSuccess", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(i parami);
    
    public abstract void a(i parami, int paramInt1, long paramLong, int paramInt2, String paramString);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/model/ScanProductGalleryHelper$scanProductCallbackForGalleryImage$1", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanProductHandleCallback;", "onAddScanProductResult", "", "scanProductResult", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductResult;", "onRetrievalImageFailed", "", "result", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeResult;", "errCode", "", "errMsg", "", "onRetrievalImageSuccess", "onUploadImageFailed", "onUploadImageSuccess", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements f
  {
    c(ak paramak) {}
    
    public final void a(i parami, int paramInt, String paramString)
    {
      AppMethodBeat.i(314352);
      s.u(parami, "result");
      if (ak.a(this.OTb) == parami.hBk)
      {
        ak.b localb = ak.b(this.OTb);
        if (localb != null) {
          localb.a(parami, parami.source, parami.hBk, paramInt, paramString);
        }
        parami = ak.c(this.OTb).gQP();
        if (parami != null) {
          parami.b(false, null);
        }
      }
      AppMethodBeat.o(314352);
    }
    
    public final void b(i parami)
    {
      AppMethodBeat.i(314346);
      s.u(parami, "result");
      if (ak.a(this.OTb) == parami.hBk)
      {
        ak.b localb = ak.b(this.OTb);
        if (localb != null) {
          localb.a(parami);
        }
      }
      AppMethodBeat.o(314346);
    }
    
    public final boolean b(k paramk)
    {
      AppMethodBeat.i(314343);
      s.u(paramk, "scanProductResult");
      AppMethodBeat.o(314343);
      return false;
    }
    
    public final void c(i parami)
    {
      AppMethodBeat.i(314355);
      s.u(parami, "result");
      AppMethodBeat.o(314355);
    }
    
    public final void d(i parami)
    {
      AppMethodBeat.i(314358);
      s.u(parami, "result");
      AppMethodBeat.o(314358);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ak
 * JD-Core Version:    0.7.0.1
 */