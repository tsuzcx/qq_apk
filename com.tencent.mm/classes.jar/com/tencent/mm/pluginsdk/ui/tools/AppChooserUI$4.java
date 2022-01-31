package com.tencent.mm.pluginsdk.ui.tools;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.c;
import java.io.File;

final class AppChooserUI$4
  implements View.OnClickListener
{
  AppChooserUI$4(AppChooserUI paramAppChooserUI) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.AppChooserUI", "mDownloadOnClickListener");
    if (AppChooserUI.a(this.slj) != null)
    {
      paramView = AppChooserUI.a(this.slj).slk;
      if (paramView != AppChooserUI.f.slv) {
        break label301;
      }
      if ((AppChooserUI.b(this.slj) != null) && (AppChooserUI.b(this.slj).fvH.isShowing()))
      {
        AppChooserUI.a(this.slj).slk = AppChooserUI.f.slw;
        AppChooserUI.a(this.slj).notifyDataSetChanged();
      }
      paramView = new e.a();
      if (AppChooserUI.f(this.slj) != 1) {
        break label248;
      }
      paramView.zN("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10375");
      paramView.zP(AppChooserUI.h(this.slj).cks());
      paramView.pE(1);
      paramView.eO(true);
      d.aFP().a(paramView.iPG);
      com.tencent.mm.pluginsdk.model.s.ckE();
      com.tencent.mm.pluginsdk.model.s.DI(AppChooserUI.g(this.slj));
      if (AppChooserUI.g(this.slj) == 0)
      {
        if (!AppChooserUI.i(this.slj)) {
          break label265;
        }
        h.nFQ.f(11168, new Object[] { Integer.valueOf(4), Integer.valueOf(AppChooserUI.f(this.slj)) });
      }
      label211:
      if (AppChooserUI.g(this.slj) == 1) {
        h.nFQ.f(12809, new Object[] { Integer.valueOf(5), "" });
      }
    }
    label248:
    do
    {
      do
      {
        do
        {
          return;
          paramView.zN(AppChooserUI.h(this.slj).UP());
          break;
          h.nFQ.f(11168, new Object[] { Integer.valueOf(3), Integer.valueOf(AppChooserUI.f(this.slj)) });
          break label211;
        } while (paramView != AppChooserUI.f.slx);
        paramView = this.slj;
        long l = AppChooserUI.j(this.slj);
        y.i("MicroMsg.AppChooserUI", "installRecommendApp");
        Object localObject = d.aFP().dd(l).path;
        y.d("MicroMsg.AppChooserUI", "filepath:%s", new Object[] { localObject });
        localObject = new File((String)localObject);
        if (q.g(paramView.mController.uMN, Uri.fromFile((File)localObject))) {
          break label429;
        }
        g.DP().Dz().o(paramView.Ev(274560), Long.valueOf(0L));
      } while (paramView.skM == null);
      paramView.skM.slk = AppChooserUI.f.slv;
      paramView.skM.notifyDataSetChanged();
      return;
    } while (paramView.skM == null);
    label265:
    label301:
    label429:
    paramView.skM.slk = AppChooserUI.f.slx;
    paramView.skM.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.4
 * JD-Core Version:    0.7.0.1
 */