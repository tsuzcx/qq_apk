package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.model.af;

final class SnsCommentDetailUI$3
  extends com.tencent.mm.plugin.sns.ui.d.b
{
  SnsCommentDetailUI$3(SnsCommentDetailUI paramSnsCommentDetailUI, int paramInt, Activity paramActivity, af paramaf)
  {
    super(paramInt, paramActivity, paramaf);
  }
  
  public final void b(View paramView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void ci(Object paramObject)
  {
    AppMethodBeat.i(38775);
    SnsCommentDetailUI.g(this.rPu);
    SnsCommentDetailUI.p(this.rPu).u((View)paramObject, 2, SnsCommentDetailUI.f(this.rPu));
    AppMethodBeat.o(38775);
  }
  
  public final void cts() {}
  
  public final void ctt()
  {
    AppMethodBeat.i(38777);
    SnsCommentDetailUI.q(this.rPu).ctj();
    AppMethodBeat.o(38777);
  }
  
  public final void dJ(View paramView) {}
  
  public final void dK(View paramView) {}
  
  public final void dL(View paramView) {}
  
  public final void dM(View paramView) {}
  
  public final void dN(View paramView)
  {
    AppMethodBeat.i(38776);
    SnsCommentDetailUI.q(this.rPu).dI(paramView);
    AppMethodBeat.o(38776);
  }
  
  public final void dO(View paramView)
  {
    AppMethodBeat.i(38778);
    Intent localIntent = new Intent();
    localIntent.putExtra("result_finish", true);
    this.rPu.setResult(-1, localIntent);
    if ((paramView.getTag() != null) && (this.rOU != null))
    {
      paramView = (com.tencent.mm.plugin.sns.data.b)paramView.getTag();
      this.rOU.k(paramView.position, paramView.crk, 2);
    }
    this.rPu.finish();
    AppMethodBeat.o(38778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.3
 * JD-Core Version:    0.7.0.1
 */