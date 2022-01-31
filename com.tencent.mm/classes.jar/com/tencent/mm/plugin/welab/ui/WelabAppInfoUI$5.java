package com.tencent.mm.plugin.welab.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import java.util.List;

final class WelabAppInfoUI$5
  implements View.OnClickListener
{
  WelabAppInfoUI$5(WelabAppInfoUI paramWelabAppInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(80603);
    Object localObject = paramView.getTag().toString();
    paramView = new Intent();
    paramView.putExtra("nowUrl", (String)localObject);
    paramView.putExtra("urlList", (String[])((WelabAppInfoUI.a)WelabAppInfoUI.e(this.vvu).getAdapter()).kQw.toArray(new String[0]));
    localObject = this.vvu;
    Intent localIntent = new Intent();
    localIntent.putExtras(paramView.getExtras());
    if (paramView.getFlags() != 0) {
      localIntent.addFlags(paramView.getFlags());
    }
    d.b((Context)localObject, "subapp", ".ui.gallery.GestureGalleryUI", localIntent);
    AppMethodBeat.o(80603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabAppInfoUI.5
 * JD-Core Version:    0.7.0.1
 */