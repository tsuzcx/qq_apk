package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.y;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.webview.ui.tools.media.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryMpVideoReport;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "()V", "enterId", "", "getEnterId", "()I", "setEnterId", "(I)V", "enterTimeInMs", "", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "report17149", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "opType", "reportPause", "reportPlay", "updateMpVideoReportParams", "ui", "Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryUI;", "oldPos", "newPos", "Companion", "app_release"})
public final class f
  extends h
{
  public static final f.a Pyo;
  private static final String TAG = "MicroMsg.ImageGalleryMpVideoReport";
  int pHu;
  private long pLN;
  
  static
  {
    AppMethodBeat.i(39736);
    Pyo = new f.a((byte)0);
    TAG = "MicroMsg.ImageGalleryMpVideoReport";
    AppMethodBeat.o(39736);
  }
  
  public f()
  {
    AppMethodBeat.i(39735);
    this.pLN = System.currentTimeMillis();
    this.pHu = ((int)(this.pLN / 1000L));
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
      localObject1 = paramImageGalleryUI.Pwu.amt(paramInt1);
      if ((localObject1 != null) && (((ca)localObject1).cWK()))
      {
        localObject1 = j.cG((ca)localObject1);
        if (localObject1 != null)
        {
          this.pLC = ((int)(System.currentTimeMillis() - this.pLN));
          Object localObject2 = paramImageGalleryUI.Pwu;
          if (localObject2 == null) {
            break label182;
          }
          localObject2 = ((b)localObject2).PwB;
          if (localObject2 == null) {
            break label182;
          }
          localObject2 = ((j)localObject2).amM(paramInt1);
          if (localObject2 == null) {
            break label182;
          }
          localObject2 = ((k)localObject2).PAO;
          if (localObject2 == null) {
            break label182;
          }
          i = ((com.tencent.mm.pluginsdk.ui.tools.j)localObject2).getCurrentPosition();
          this.pLB = i;
          a((y)localObject1, 2, this.pHu);
        }
      }
    }
    if (paramInt2 > 0)
    {
      if (paramInt1 > 0) {}
      for (paramImageGalleryUI.PyB.jpW = 0;; paramImageGalleryUI.PyB.jpW = 1)
      {
        localObject1 = paramImageGalleryUI.Pwu.amt(paramInt2);
        if ((localObject1 != null) && (((ca)localObject1).cWK())) {
          break label199;
        }
        AppMethodBeat.o(39731);
        return;
        label182:
        i = 0;
        break;
      }
      label199:
      this.pLN = System.currentTimeMillis();
      this.scene = paramImageGalleryUI.getIntent().getIntExtra("KOpenArticleSceneFromScene", 1);
      this.pHw = 10000;
      paramImageGalleryUI = j.cG((ca)localObject1);
      if (paramImageGalleryUI == null)
      {
        Log.w(TAG, "report17537 mpShareVideoInfo is null");
        AppMethodBeat.o(39731);
        return;
      }
      this.pLE = ab.IS(paramImageGalleryUI.dHc);
      a(paramImageGalleryUI, 1, this.pHu);
    }
    AppMethodBeat.o(39731);
  }
  
  public final void cA(ca paramca)
  {
    AppMethodBeat.i(39732);
    if ((paramca == null) || (!paramca.cWK()))
    {
      AppMethodBeat.o(39732);
      return;
    }
    if (this.jpW != 4)
    {
      if (this.jpW != 3) {
        i(paramca, 8);
      }
      this.jpW = 3;
    }
    AppMethodBeat.o(39732);
  }
  
  public final void cB(ca paramca)
  {
    AppMethodBeat.i(39733);
    if ((paramca == null) || (!paramca.cWK()))
    {
      AppMethodBeat.o(39733);
      return;
    }
    if (this.jpW != 2)
    {
      i(paramca, getPlayType());
      this.jpW = 2;
    }
    AppMethodBeat.o(39733);
  }
  
  public final void i(ca paramca, int paramInt)
  {
    AppMethodBeat.i(39734);
    if ((paramca == null) || (!paramca.cWK()))
    {
      AppMethodBeat.o(39734);
      return;
    }
    a(j.cG(paramca), paramInt, this.pHu);
    AppMethodBeat.o(39734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.f
 * JD-Core Version:    0.7.0.1
 */