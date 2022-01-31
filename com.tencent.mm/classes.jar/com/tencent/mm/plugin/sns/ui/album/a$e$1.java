package com.tencent.mm.plugin.sns.ui.album;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.SnsUserUI;

final class a$e$1
  implements View.OnClickListener
{
  a$e$1(a.e parame, a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39963);
    paramView = this.sew.sep;
    Intent localIntent = new Intent(paramView.mContext, SnsUserUI.class);
    localIntent.putExtra("sns_userName", paramView.eaX);
    paramView.mContext.startActivity(localIntent);
    AppMethodBeat.o(39963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.a.e.1
 * JD-Core Version:    0.7.0.1
 */