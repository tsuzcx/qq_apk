package com.tencent.mm.plugin.sns.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

final class SnsHeader$1
  implements View.OnClickListener
{
  SnsHeader$1(SnsHeader paramSnsHeader, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38947);
    ab.d("MicroMsg.SnsHeader", "change backGround");
    if ((SnsHeader.a(this.rQJ) != null) && (SnsHeader.a(this.rQJ).isShowing()))
    {
      AppMethodBeat.o(38947);
      return;
    }
    if (SnsHeader.b(this.rQJ) != null) {
      SnsHeader.b(this.rQJ).cvj();
    }
    if (SnsHeader.c(this.rQJ) == 1) {}
    long l;
    for (paramView = SnsHeader.d(this.rQJ);; paramView = SnsHeader.e(this.rQJ))
    {
      paramView = ag.cpj().abz(paramView);
      l = paramView.field_snsBgId;
      if ((SnsHeader.f(this.rQJ)) || (l != 0L)) {
        break;
      }
      AppMethodBeat.o(38947);
      return;
    }
    SnsHeader.a(this.rQJ, paramView.csw());
    String str;
    if ((SnsHeader.c(this.rQJ) == 1) || (SnsHeader.d(this.rQJ).trim().equals(SnsHeader.e(this.rQJ).trim())))
    {
      paramView = new String[1];
      paramView[0] = this.val$context.getString(2131304030);
      SnsHeader.a(this.rQJ, false);
      if (!SnsHeader.g(this.rQJ)) {
        break label319;
      }
      str = this.val$context.getString(2131303951);
      label225:
      if (!SnsHeader.g(this.rQJ)) {
        break label326;
      }
      this.val$context.getString(2131297018);
    }
    for (;;)
    {
      SnsHeader.a(this.rQJ, h.a(this.rQJ.getContext(), str, paramView, new SnsHeader.1.1(this, l)));
      AppMethodBeat.o(38947);
      return;
      if (SnsHeader.g(this.rQJ))
      {
        paramView = new String[0];
        break;
      }
      paramView = new String[1];
      paramView[0] = this.val$context.getString(2131303878);
      break;
      label319:
      str = "";
      break label225;
      label326:
      this.val$context.getString(2131296888);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsHeader.1
 * JD-Core Version:    0.7.0.1
 */