package com.tencent.mm.pluginsdk.ui.tools;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.c;
import java.io.File;

final class AppChooserUI$4
  implements View.OnClickListener
{
  AppChooserUI$4(AppChooserUI paramAppChooserUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125857);
    ab.i("MicroMsg.AppChooserUI", "mDownloadOnClickListener");
    if (AppChooserUI.a(this.wdL) != null)
    {
      paramView = AppChooserUI.a(this.wdL).wdM;
      if (paramView == AppChooserUI.f.wdX)
      {
        if ((AppChooserUI.b(this.wdL) != null) && (AppChooserUI.b(this.wdL).gNn.isShowing()))
        {
          AppChooserUI.a(this.wdL).wdM = AppChooserUI.f.wdY;
          AppChooserUI.a(this.wdL).notifyDataSetChanged();
        }
        paramView = new g.a();
        if (AppChooserUI.f(this.wdL) == 1)
        {
          paramView.JJ("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10375");
          paramView.JL(AppChooserUI.h(this.wdL).dkX());
          paramView.tV(1);
          paramView.gr(true);
          f.bjl().a(paramView.kYR);
          r.dlm();
          r.Lz(AppChooserUI.g(this.wdL));
          if (AppChooserUI.g(this.wdL) == 0)
          {
            if (!AppChooserUI.i(this.wdL)) {
              break label275;
            }
            h.qsU.e(11168, new Object[] { Integer.valueOf(4), Integer.valueOf(AppChooserUI.f(this.wdL)) });
          }
        }
        for (;;)
        {
          if (AppChooserUI.g(this.wdL) == 1) {
            h.qsU.e(12809, new Object[] { Integer.valueOf(5), "" });
          }
          AppMethodBeat.o(125857);
          return;
          paramView.JJ(AppChooserUI.h(this.wdL).aoo());
          break;
          label275:
          h.qsU.e(11168, new Object[] { Integer.valueOf(3), Integer.valueOf(AppChooserUI.f(this.wdL)) });
        }
      }
      if (paramView == AppChooserUI.f.wdZ)
      {
        paramView = this.wdL;
        long l = AppChooserUI.j(this.wdL);
        ab.i("MicroMsg.AppChooserUI", "installRecommendApp");
        Object localObject = f.bjl().iA(l).path;
        ab.d("MicroMsg.AppChooserUI", "filepath:%s", new Object[] { String.valueOf(localObject) });
        localObject = new File((String)localObject);
        com.tencent.mm.pluginsdk.model.app.q.a(paramView.getContext(), Uri.fromFile((File)localObject), new AppChooserUI.7(paramView));
      }
    }
    AppMethodBeat.o(125857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.4
 * JD-Core Version:    0.7.0.1
 */