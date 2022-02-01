package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ac;

final class WelabMainUI$1
  implements View.OnClickListener
{
  WelabMainUI$1(WelabMainUI paramWelabMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(146285);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/welab/ui/WelabMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    localObject = new Intent();
    ((Intent)localObject).putExtra("title", paramView.getResources().getString(2131766203));
    ((Intent)localObject).putExtra("rawUrl", this.Eyq.getContext().getString(2131766198, new Object[] { ac.fks(), Integer.valueOf(com.tencent.mm.protocal.d.Fnj) }));
    ((Intent)localObject).putExtra("showShare", false);
    com.tencent.mm.bs.d.b(paramView.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    a.a(this, "com/tencent/mm/plugin/welab/ui/WelabMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(146285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabMainUI.1
 * JD-Core Version:    0.7.0.1
 */