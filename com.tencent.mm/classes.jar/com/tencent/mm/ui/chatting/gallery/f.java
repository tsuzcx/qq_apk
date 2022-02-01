package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.y;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryMpVideoReport;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "()V", "enterId", "", "getEnterId", "()I", "setEnterId", "(I)V", "enterTimeInMs", "", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "report17149", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "opType", "reportPause", "reportPlay", "updateMpVideoReportParams", "ui", "Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryUI;", "oldPos", "newPos", "Companion", "app_release"})
public final class f
  extends com.tencent.mm.plugin.webview.ui.tools.media.h
{
  public static final f.a JRg;
  private static final String TAG = "MicroMsg.ImageGalleryMpVideoReport";
  int oog;
  private long orN;
  
  static
  {
    AppMethodBeat.i(39736);
    JRg = new f.a((byte)0);
    TAG = "MicroMsg.ImageGalleryMpVideoReport";
    AppMethodBeat.o(39736);
  }
  
  public f()
  {
    AppMethodBeat.i(39735);
    this.orN = System.currentTimeMillis();
    this.oog = ((int)(this.orN / 1000L));
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
      localObject1 = paramImageGalleryUI.JPj.ada(paramInt1);
      if ((localObject1 != null) && (((bu)localObject1).cxg()))
      {
        localObject1 = j.cr((bu)localObject1);
        if (localObject1 != null)
        {
          this.orC = ((int)(System.currentTimeMillis() - this.orN));
          Object localObject2 = paramImageGalleryUI.JPj;
          if (localObject2 == null) {
            break label182;
          }
          localObject2 = ((b)localObject2).JPq;
          if (localObject2 == null) {
            break label182;
          }
          localObject2 = ((j)localObject2).adu(paramInt1);
          if (localObject2 == null) {
            break label182;
          }
          localObject2 = ((k)localObject2).JTl;
          if (localObject2 == null) {
            break label182;
          }
          i = ((com.tencent.mm.pluginsdk.ui.tools.h)localObject2).getCurrentPosition();
          this.orB = i;
          a((y)localObject1, 2, this.oog);
        }
      }
    }
    if (paramInt2 > 0)
    {
      if (paramInt1 > 0) {}
      for (paramImageGalleryUI.JRs.irQ = 0;; paramImageGalleryUI.JRs.irQ = 1)
      {
        localObject1 = paramImageGalleryUI.JPj.ada(paramInt2);
        if ((localObject1 != null) && (((bu)localObject1).cxg())) {
          break label199;
        }
        AppMethodBeat.o(39731);
        return;
        label182:
        i = 0;
        break;
      }
      label199:
      this.orN = System.currentTimeMillis();
      this.scene = paramImageGalleryUI.getIntent().getIntExtra("KOpenArticleSceneFromScene", 1);
      this.ooi = 10000;
      paramImageGalleryUI = j.cr((bu)localObject1);
      if (paramImageGalleryUI == null)
      {
        ad.w(TAG, "report17537 mpShareVideoInfo is null");
        AppMethodBeat.o(39731);
        return;
      }
      this.orE = w.zD(paramImageGalleryUI.doK);
      a(paramImageGalleryUI, 1, this.oog);
    }
    AppMethodBeat.o(39731);
  }
  
  public final void ck(bu parambu)
  {
    AppMethodBeat.i(39732);
    if ((parambu == null) || (!parambu.cxg()))
    {
      AppMethodBeat.o(39732);
      return;
    }
    if (this.irQ != 4)
    {
      if (this.irQ != 3) {
        i(parambu, 8);
      }
      this.irQ = 3;
    }
    AppMethodBeat.o(39732);
  }
  
  public final void cl(bu parambu)
  {
    AppMethodBeat.i(39733);
    if ((parambu == null) || (!parambu.cxg()))
    {
      AppMethodBeat.o(39733);
      return;
    }
    if (this.irQ != 2)
    {
      i(parambu, eVd());
      this.irQ = 2;
    }
    AppMethodBeat.o(39733);
  }
  
  public final void i(bu parambu, int paramInt)
  {
    AppMethodBeat.i(39734);
    if ((parambu == null) || (!parambu.cxg()))
    {
      AppMethodBeat.o(39734);
      return;
    }
    a(j.cr(parambu), paramInt, this.oog);
    AppMethodBeat.o(39734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.f
 * JD-Core Version:    0.7.0.1
 */