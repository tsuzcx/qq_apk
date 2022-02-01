package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.y;
import com.tencent.mm.model.ab;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryMpVideoReport;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "()V", "enterId", "", "getEnterId", "()I", "setEnterId", "(I)V", "enterTimeInMs", "", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "report17149", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "opType", "reportPause", "reportPlay", "updateMpVideoReportParams", "ui", "Lcom/tencent/mm/ui/chatting/gallery/ImageGalleryUI;", "oldPos", "newPos", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends com.tencent.mm.plugin.webview.ui.tools.media.g
{
  private static final String TAG;
  public static final l.a aeCq;
  int XlS;
  private long XlT;
  
  static
  {
    AppMethodBeat.i(39736);
    aeCq = new l.a((byte)0);
    TAG = "MicroMsg.ImageGalleryMpVideoReport";
    AppMethodBeat.o(39736);
  }
  
  public l()
  {
    AppMethodBeat.i(39735);
    this.XlT = System.currentTimeMillis();
    this.XlS = ((int)(this.XlT / 1000L));
    AppMethodBeat.o(39735);
  }
  
  public final void a(ImageGalleryUI paramImageGalleryUI, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39731);
    s.u(paramImageGalleryUI, "ui");
    Object localObject1;
    Object localObject2;
    int i;
    if (paramInt1 > 0)
    {
      localObject1 = paramImageGalleryUI.aeAg.aBV(paramInt1);
      if ((localObject1 != null) && (((cc)localObject1).dSI()))
      {
        localObject1 = p.dc((cc)localObject1);
        if (localObject1 != null)
        {
          this.Xmu = ((int)(System.currentTimeMillis() - this.XlT));
          localObject2 = paramImageGalleryUI.aeAg;
          if (localObject2 != null) {
            break label139;
          }
          i = 0;
          this.Xmt = i;
          a((y)localObject1, 2, this.XlS);
        }
      }
    }
    if (paramInt2 > 0)
    {
      if (paramInt1 > 0) {}
      for (paramImageGalleryUI.aeCD.oYt = 0;; paramImageGalleryUI.aeCD.oYt = 1)
      {
        localObject1 = paramImageGalleryUI.aeAg.aBV(paramInt2);
        if ((localObject1 != null) && (((cc)localObject1).dSI())) {
          break label217;
        }
        AppMethodBeat.o(39731);
        return;
        label139:
        localObject2 = ((h)localObject2).aeAH;
        if (localObject2 == null)
        {
          i = 0;
          break;
        }
        localObject2 = ((g)localObject2).aCt(paramInt1);
        if (localObject2 == null)
        {
          i = 0;
          break;
        }
        localObject2 = ((r)localObject2).aeFr;
        if (localObject2 == null)
        {
          i = 0;
          break;
        }
        i = ((i)localObject2).getCurrentPosition();
        break;
      }
      label217:
      this.XlT = System.currentTimeMillis();
      this.scene = paramImageGalleryUI.getIntent().getIntExtra("KOpenArticleSceneFromScene", 1);
      this.AcJ = 10000;
      paramImageGalleryUI = p.dc((cc)localObject1);
      if (paramImageGalleryUI == null)
      {
        Log.w(TAG, "report17537 mpShareVideoInfo is null");
        AppMethodBeat.o(39731);
        return;
      }
      this.Xmw = ab.IR(paramImageGalleryUI.hEE);
      a(paramImageGalleryUI, 1, this.XlS);
    }
    AppMethodBeat.o(39731);
  }
  
  public final void dt(cc paramcc)
  {
    AppMethodBeat.i(39732);
    if ((paramcc == null) || (!paramcc.dSI()))
    {
      AppMethodBeat.o(39732);
      return;
    }
    if (this.oYt != 4)
    {
      if (this.oYt != 3) {
        n(paramcc, 8);
      }
      this.oYt = 3;
    }
    AppMethodBeat.o(39732);
  }
  
  public final void du(cc paramcc)
  {
    AppMethodBeat.i(39733);
    if ((paramcc == null) || (!paramcc.dSI()))
    {
      AppMethodBeat.o(39733);
      return;
    }
    if (this.oYt != 2)
    {
      n(paramcc, getPlayType());
      this.oYt = 2;
    }
    AppMethodBeat.o(39733);
  }
  
  public final void n(cc paramcc, int paramInt)
  {
    AppMethodBeat.i(39734);
    if ((paramcc == null) || (!paramcc.dSI()))
    {
      AppMethodBeat.o(39734);
      return;
    }
    a(p.dc(paramcc), paramInt, this.XlS);
    AppMethodBeat.o(39734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.l
 * JD-Core Version:    0.7.0.1
 */