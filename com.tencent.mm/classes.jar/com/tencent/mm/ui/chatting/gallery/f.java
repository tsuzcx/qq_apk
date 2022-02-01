package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.y;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.webview.ui.tools.media.g;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryMpVideoReport;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "()V", "enterId", "", "getEnterId", "()I", "setEnterId", "(I)V", "enterTimeInMs", "", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "report17149", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "opType", "reportPause", "reportPlay", "updateMpVideoReportParams", "ui", "Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryUI;", "oldPos", "newPos", "Companion", "app_release"})
public final class f
  extends g
{
  public static final f.a IbO;
  private static final String TAG = "MicroMsg.ImageGalleryMpVideoReport";
  int nLA;
  private long nPh;
  
  static
  {
    AppMethodBeat.i(39736);
    IbO = new f.a((byte)0);
    TAG = "MicroMsg.ImageGalleryMpVideoReport";
    AppMethodBeat.o(39736);
  }
  
  public f()
  {
    AppMethodBeat.i(39735);
    this.nPh = System.currentTimeMillis();
    this.nLA = ((int)(this.nPh / 1000L));
    AppMethodBeat.o(39735);
  }
  
  public final void a(ImageGalleryUI paramImageGalleryUI, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39731);
    d.g.b.k.h(paramImageGalleryUI, "ui");
    Object localObject1;
    int i;
    if (paramInt1 > 0)
    {
      localObject1 = paramImageGalleryUI.fpE().aaP(paramInt1);
      if ((localObject1 != null) && (((bo)localObject1).cru()))
      {
        localObject1 = j.cl((bo)localObject1);
        if (localObject1 != null)
        {
          this.nOW = ((int)(System.currentTimeMillis() - this.nPh));
          Object localObject2 = paramImageGalleryUI.fpE();
          if (localObject2 == null) {
            break label182;
          }
          localObject2 = ((b)localObject2).Iab;
          if (localObject2 == null) {
            break label182;
          }
          localObject2 = ((j)localObject2).abi(paramInt1);
          if (localObject2 == null) {
            break label182;
          }
          localObject2 = ((k)localObject2).IdK;
          if (localObject2 == null) {
            break label182;
          }
          i = ((h)localObject2).getCurrentPosition();
          this.nOV = i;
          a((y)localObject1, 2, this.nLA);
        }
      }
    }
    if (paramInt2 > 0)
    {
      if (paramInt1 > 0) {}
      for (paramImageGalleryUI.Ica.hYu = 0;; paramImageGalleryUI.Ica.hYu = 1)
      {
        localObject1 = paramImageGalleryUI.fpE().aaP(paramInt2);
        if ((localObject1 != null) && (((bo)localObject1).cru())) {
          break label199;
        }
        AppMethodBeat.o(39731);
        return;
        label182:
        i = 0;
        break;
      }
      label199:
      this.nPh = System.currentTimeMillis();
      this.scene = paramImageGalleryUI.getIntent().getIntExtra("KOpenArticleSceneFromScene", 1);
      this.nLC = 10000;
      paramImageGalleryUI = j.cl((bo)localObject1);
      if (paramImageGalleryUI == null)
      {
        ac.w(TAG, "report17537 mpShareVideoInfo is null");
        AppMethodBeat.o(39731);
        return;
      }
      this.nOY = w.wG(paramImageGalleryUI.ddo);
      a(paramImageGalleryUI, 1, this.nLA);
    }
    AppMethodBeat.o(39731);
  }
  
  public final void ce(bo parambo)
  {
    AppMethodBeat.i(39732);
    if ((parambo == null) || (!parambo.cru()))
    {
      AppMethodBeat.o(39732);
      return;
    }
    if (this.hYu != 4)
    {
      if (this.hYu != 3) {
        i(parambo, 8);
      }
      this.hYu = 3;
    }
    AppMethodBeat.o(39732);
  }
  
  public final void cf(bo parambo)
  {
    AppMethodBeat.i(39733);
    if ((parambo == null) || (!parambo.cru()))
    {
      AppMethodBeat.o(39733);
      return;
    }
    if (this.hYu != 2)
    {
      i(parambo, eGg());
      this.hYu = 2;
    }
    AppMethodBeat.o(39733);
  }
  
  public final void i(bo parambo, int paramInt)
  {
    AppMethodBeat.i(39734);
    if ((parambo == null) || (!parambo.cru()))
    {
      AppMethodBeat.o(39734);
      return;
    }
    a(j.cl(parambo), paramInt, this.nLA);
    AppMethodBeat.o(39734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.f
 * JD-Core Version:    0.7.0.1
 */