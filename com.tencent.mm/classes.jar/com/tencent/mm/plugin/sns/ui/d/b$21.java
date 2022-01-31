package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.protocal.protobuf.TimeLineObject;

final class b$21
  implements View.OnClickListener
{
  b$21(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40270);
    if ((paramView.getTag() instanceof as))
    {
      paramView = (as)paramView.getTag();
      paramView = ag.cpf().abu(paramView.czw);
      if (paramView == null)
      {
        AppMethodBeat.o(40270);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("sns_text_show", paramView.csh().xTP);
      localIntent.putExtra("sns_local_id", paramView.csH());
      localIntent.setClass(this.skd.activity, SnsSingleTextViewUI.class);
      this.skd.activity.startActivity(localIntent);
    }
    AppMethodBeat.o(40270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.21
 * JD-Core Version:    0.7.0.1
 */