package com.tencent.mm.plugin.welab.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.List;

final class WelabAppInfoUI$5
  implements View.OnClickListener
{
  WelabAppInfoUI$5(WelabAppInfoUI paramWelabAppInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(146274);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    localObject = paramView.getTag().toString();
    paramView = new Intent();
    paramView.putExtra("nowUrl", (String)localObject);
    paramView.putExtra("urlList", (String[])((WelabAppInfoUI.a)WelabAppInfoUI.e(this.QFB).getAdapter()).tYs.toArray(new String[0]));
    localObject = this.QFB;
    Intent localIntent = new Intent();
    localIntent.putExtras(paramView.getExtras());
    if (paramView.getFlags() != 0) {
      localIntent.addFlags(paramView.getFlags());
    }
    c.b((Context)localObject, "subapp", ".ui.gallery.GestureGalleryUI", localIntent);
    a.a(this, "com/tencent/mm/plugin/welab/ui/WelabAppInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(146274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabAppInfoUI.5
 * JD-Core Version:    0.7.0.1
 */