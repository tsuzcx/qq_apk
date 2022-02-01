package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;

final class WelabMainUI$1
  implements View.OnClickListener
{
  WelabMainUI$1(WelabMainUI paramWelabMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(146285);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/welab/ui/WelabMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    localObject = new Intent();
    ((Intent)localObject).putExtra("title", paramView.getResources().getString(2131768711));
    ((Intent)localObject).putExtra("rawUrl", this.JGz.getContext().getString(2131768706, new Object[] { LocaleUtil.getApplicationLanguage(), Integer.valueOf(d.KyO) }));
    ((Intent)localObject).putExtra("showShare", false);
    c.b(paramView.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    a.a(this, "com/tencent/mm/plugin/welab/ui/WelabMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(146285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabMainUI.1
 * JD-Core Version:    0.7.0.1
 */