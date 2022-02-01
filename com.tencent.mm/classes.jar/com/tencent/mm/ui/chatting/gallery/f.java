package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.y;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.webview.ui.tools.media.g;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryMpVideoReport;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "()V", "enterId", "", "getEnterId", "()I", "setEnterId", "(I)V", "enterTimeInMs", "", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "report17149", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "opType", "reportPause", "reportPlay", "updateMpVideoReportParams", "ui", "Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryUI;", "oldPos", "newPos", "Companion", "app_release"})
public final class f
  extends g
{
  public static final f.a GBU;
  private static final String TAG = "MicroMsg.ImageGalleryMpVideoReport";
  int niH;
  private long nmh;
  
  static
  {
    AppMethodBeat.i(39736);
    GBU = new f.a((byte)0);
    TAG = "MicroMsg.ImageGalleryMpVideoReport";
    AppMethodBeat.o(39736);
  }
  
  public f()
  {
    AppMethodBeat.i(39735);
    this.nmh = System.currentTimeMillis();
    this.niH = ((int)(this.nmh / 1000L));
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
      localObject1 = paramImageGalleryUI.eZO().YE(paramInt1);
      if ((localObject1 != null) && (((bl)localObject1).cjN()))
      {
        localObject1 = j.ci((bl)localObject1);
        if (localObject1 != null)
        {
          this.nlW = ((int)(System.currentTimeMillis() - this.nmh));
          Object localObject2 = paramImageGalleryUI.eZO();
          if (localObject2 == null) {
            break label182;
          }
          localObject2 = ((b)localObject2).GAg;
          if (localObject2 == null) {
            break label182;
          }
          localObject2 = ((j)localObject2).YW(paramInt1);
          if (localObject2 == null) {
            break label182;
          }
          localObject2 = ((k)localObject2).GDN;
          if (localObject2 == null) {
            break label182;
          }
          i = ((h)localObject2).getCurrentPosition();
          this.nlV = i;
          a((y)localObject1, 2, this.niH);
        }
      }
    }
    if (paramInt2 > 0)
    {
      if (paramInt1 > 0) {}
      for (paramImageGalleryUI.GCg.hxT = 0;; paramImageGalleryUI.GCg.hxT = 1)
      {
        localObject1 = paramImageGalleryUI.eZO().YE(paramInt2);
        if ((localObject1 != null) && (((bl)localObject1).cjN())) {
          break label199;
        }
        AppMethodBeat.o(39731);
        return;
        label182:
        i = 0;
        break;
      }
      label199:
      this.nmh = System.currentTimeMillis();
      this.scene = paramImageGalleryUI.getIntent().getIntExtra("KOpenArticleSceneFromScene", 1);
      this.niJ = 10000;
      paramImageGalleryUI = j.ci((bl)localObject1);
      if (paramImageGalleryUI == null)
      {
        ad.w(TAG, "report17537 mpShareVideoInfo is null");
        AppMethodBeat.o(39731);
        return;
      }
      this.nlY = w.sD(paramImageGalleryUI.dfT);
      a(paramImageGalleryUI, 1, this.niH);
    }
    AppMethodBeat.o(39731);
  }
  
  public final void cb(bl parambl)
  {
    AppMethodBeat.i(39732);
    if ((parambl == null) || (!parambl.cjN()))
    {
      AppMethodBeat.o(39732);
      return;
    }
    if (this.hxT != 4)
    {
      if (this.hxT != 3) {
        i(parambl, 8);
      }
      this.hxT = 3;
    }
    AppMethodBeat.o(39732);
  }
  
  public final void cc(bl parambl)
  {
    AppMethodBeat.i(39733);
    if ((parambl == null) || (!parambl.cjN()))
    {
      AppMethodBeat.o(39733);
      return;
    }
    if (this.hxT != 2)
    {
      i(parambl, eqM());
      this.hxT = 2;
    }
    AppMethodBeat.o(39733);
  }
  
  public final void i(bl parambl, int paramInt)
  {
    AppMethodBeat.i(39734);
    if ((parambl == null) || (!parambl.cjN()))
    {
      AppMethodBeat.o(39734);
      return;
    }
    a(j.ci(parambl), paramInt, this.niH);
    AppMethodBeat.o(39734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.f
 * JD-Core Version:    0.7.0.1
 */