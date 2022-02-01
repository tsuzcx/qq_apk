package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.y;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.webview.ui.tools.media.h;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryMpVideoReport;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "()V", "enterId", "", "getEnterId", "()I", "setEnterId", "(I)V", "enterTimeInMs", "", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "report17149", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "opType", "reportPause", "reportPlay", "updateMpVideoReportParams", "ui", "Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryUI;", "oldPos", "newPos", "Companion", "app_release"})
public final class j
  extends h
{
  private static final String TAG = "MicroMsg.ImageGalleryMpVideoReport";
  public static final j.a WSN;
  int QtB;
  private long QtC;
  
  static
  {
    AppMethodBeat.i(39736);
    WSN = new j.a((byte)0);
    TAG = "MicroMsg.ImageGalleryMpVideoReport";
    AppMethodBeat.o(39736);
  }
  
  public j()
  {
    AppMethodBeat.i(39735);
    this.QtC = System.currentTimeMillis();
    this.QtB = ((int)(this.QtC / 1000L));
    AppMethodBeat.o(39735);
  }
  
  public final void a(ImageGalleryUI paramImageGalleryUI, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39731);
    kotlin.g.b.p.k(paramImageGalleryUI, "ui");
    Object localObject1;
    int i;
    if (paramInt1 > 0)
    {
      localObject1 = paramImageGalleryUI.WQM.avt(paramInt1);
      if ((localObject1 != null) && (((ca)localObject1).dlS()))
      {
        localObject1 = n.cG((ca)localObject1);
        if (localObject1 != null)
        {
          this.Quu = ((int)(System.currentTimeMillis() - this.QtC));
          Object localObject2 = paramImageGalleryUI.WQM;
          if (localObject2 == null) {
            break label182;
          }
          localObject2 = ((f)localObject2).WRb;
          if (localObject2 == null) {
            break label182;
          }
          localObject2 = ((e)localObject2).avN(paramInt1);
          if (localObject2 == null) {
            break label182;
          }
          localObject2 = ((p)localObject2).WVL;
          if (localObject2 == null) {
            break label182;
          }
          i = ((k)localObject2).getCurrentPosition();
          this.Qut = i;
          a((y)localObject1, 2, this.QtB);
        }
      }
    }
    if (paramInt2 > 0)
    {
      if (paramInt1 > 0) {}
      for (paramImageGalleryUI.WTa.mfx = 0;; paramImageGalleryUI.WTa.mfx = 1)
      {
        localObject1 = paramImageGalleryUI.WQM.avt(paramInt2);
        if ((localObject1 != null) && (((ca)localObject1).dlS())) {
          break label199;
        }
        AppMethodBeat.o(39731);
        return;
        label182:
        i = 0;
        break;
      }
      label199:
      this.QtC = System.currentTimeMillis();
      this.scene = paramImageGalleryUI.getIntent().getIntExtra("KOpenArticleSceneFromScene", 1);
      this.wGA = 10000;
      paramImageGalleryUI = n.cG((ca)localObject1);
      if (paramImageGalleryUI == null)
      {
        Log.w(TAG, "report17537 mpShareVideoInfo is null");
        AppMethodBeat.o(39731);
        return;
      }
      this.Quw = ab.Ql(paramImageGalleryUI.fzT);
      a(paramImageGalleryUI, 1, this.QtB);
    }
    AppMethodBeat.o(39731);
  }
  
  public final void cW(ca paramca)
  {
    AppMethodBeat.i(39732);
    if ((paramca == null) || (!paramca.dlS()))
    {
      AppMethodBeat.o(39732);
      return;
    }
    if (this.mfx != 4)
    {
      if (this.mfx != 3) {
        n(paramca, 8);
      }
      this.mfx = 3;
    }
    AppMethodBeat.o(39732);
  }
  
  public final void cX(ca paramca)
  {
    AppMethodBeat.i(39733);
    if ((paramca == null) || (!paramca.dlS()))
    {
      AppMethodBeat.o(39733);
      return;
    }
    if (this.mfx != 2)
    {
      n(paramca, getPlayType());
      this.mfx = 2;
    }
    AppMethodBeat.o(39733);
  }
  
  public final void n(ca paramca, int paramInt)
  {
    AppMethodBeat.i(39734);
    if ((paramca == null) || (!paramca.dlS()))
    {
      AppMethodBeat.o(39734);
      return;
    }
    a(n.cG(paramca), paramInt, this.QtB);
    AppMethodBeat.o(39734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j
 * JD-Core Version:    0.7.0.1
 */