package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.y;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryMpVideoReport;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "()V", "enterId", "", "getEnterId", "()I", "setEnterId", "(I)V", "enterTimeInMs", "", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "report17149", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "opType", "reportPause", "reportPlay", "updateMpVideoReportParams", "ui", "Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryUI;", "oldPos", "newPos", "Companion", "app_release"})
public final class f
  extends com.tencent.mm.plugin.webview.ui.tools.media.h
{
  public static final f.a Kmr;
  private static final String TAG = "MicroMsg.ImageGalleryMpVideoReport";
  int otX;
  private long oyj;
  
  static
  {
    AppMethodBeat.i(39736);
    Kmr = new f.a((byte)0);
    TAG = "MicroMsg.ImageGalleryMpVideoReport";
    AppMethodBeat.o(39736);
  }
  
  public f()
  {
    AppMethodBeat.i(39735);
    this.oyj = System.currentTimeMillis();
    this.otX = ((int)(this.oyj / 1000L));
    AppMethodBeat.o(39735);
  }
  
  public final void a(ImageGalleryUI paramImageGalleryUI, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39731);
    p.h(paramImageGalleryUI, "ui");
    Object localObject1;
    int i;
    if (paramInt1 > 0)
    {
      localObject1 = paramImageGalleryUI.Kkv.adI(paramInt1);
      if ((localObject1 != null) && (((bv)localObject1).cyH()))
      {
        localObject1 = j.cq((bv)localObject1);
        if (localObject1 != null)
        {
          this.oxY = ((int)(System.currentTimeMillis() - this.oyj));
          Object localObject2 = paramImageGalleryUI.Kkv;
          if (localObject2 == null) {
            break label182;
          }
          localObject2 = ((b)localObject2).KkC;
          if (localObject2 == null) {
            break label182;
          }
          localObject2 = ((j)localObject2).aeb(paramInt1);
          if (localObject2 == null) {
            break label182;
          }
          localObject2 = ((k)localObject2).KoL;
          if (localObject2 == null) {
            break label182;
          }
          i = ((com.tencent.mm.pluginsdk.ui.tools.h)localObject2).getCurrentPosition();
          this.oxX = i;
          a((y)localObject1, 2, this.otX);
        }
      }
    }
    if (paramInt2 > 0)
    {
      if (paramInt1 > 0) {}
      for (paramImageGalleryUI.KmD.iuK = 0;; paramImageGalleryUI.KmD.iuK = 1)
      {
        localObject1 = paramImageGalleryUI.Kkv.adI(paramInt2);
        if ((localObject1 != null) && (((bv)localObject1).cyH())) {
          break label199;
        }
        AppMethodBeat.o(39731);
        return;
        label182:
        i = 0;
        break;
      }
      label199:
      this.oyj = System.currentTimeMillis();
      this.scene = paramImageGalleryUI.getIntent().getIntExtra("KOpenArticleSceneFromScene", 1);
      this.otZ = 10000;
      paramImageGalleryUI = j.cq((bv)localObject1);
      if (paramImageGalleryUI == null)
      {
        ae.w(TAG, "report17537 mpShareVideoInfo is null");
        AppMethodBeat.o(39731);
        return;
      }
      this.oya = x.An(paramImageGalleryUI.dpP);
      a(paramImageGalleryUI, 1, this.otX);
    }
    AppMethodBeat.o(39731);
  }
  
  public final void ck(bv parambv)
  {
    AppMethodBeat.i(39732);
    if ((parambv == null) || (!parambv.cyH()))
    {
      AppMethodBeat.o(39732);
      return;
    }
    if (this.iuK != 4)
    {
      if (this.iuK != 3) {
        i(parambv, 8);
      }
      this.iuK = 3;
    }
    AppMethodBeat.o(39732);
  }
  
  public final void cl(bv parambv)
  {
    AppMethodBeat.i(39733);
    if ((parambv == null) || (!parambv.cyH()))
    {
      AppMethodBeat.o(39733);
      return;
    }
    if (this.iuK != 2)
    {
      i(parambv, eYQ());
      this.iuK = 2;
    }
    AppMethodBeat.o(39733);
  }
  
  public final void i(bv parambv, int paramInt)
  {
    AppMethodBeat.i(39734);
    if ((parambv == null) || (!parambv.cyH()))
    {
      AppMethodBeat.o(39734);
      return;
    }
    a(j.cq(parambv), paramInt, this.otX);
    AppMethodBeat.o(39734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.f
 * JD-Core Version:    0.7.0.1
 */