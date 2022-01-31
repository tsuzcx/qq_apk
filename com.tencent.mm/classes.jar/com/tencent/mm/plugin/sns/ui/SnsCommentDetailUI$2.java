package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.plugin.sns.model.ae;

final class SnsCommentDetailUI$2
  extends com.tencent.mm.plugin.sns.ui.d.b
{
  SnsCommentDetailUI$2(SnsCommentDetailUI paramSnsCommentDetailUI, int paramInt, Activity paramActivity, ae paramae)
  {
    super(paramInt, paramActivity, paramae);
  }
  
  public final void b(View paramView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void bE(Object paramObject)
  {
    SnsCommentDetailUI.g(this.oWW);
    SnsCommentDetailUI.p(this.oWW).l((View)paramObject, 2, SnsCommentDetailUI.f(this.oWW));
  }
  
  public final void bHo() {}
  
  public final void bHp()
  {
    SnsCommentDetailUI.q(this.oWW).bHf();
  }
  
  public final void cT(View paramView) {}
  
  public final void cU(View paramView) {}
  
  public final void cV(View paramView) {}
  
  public final void cW(View paramView) {}
  
  public final void cX(View paramView)
  {
    SnsCommentDetailUI.q(this.oWW).cS(paramView);
  }
  
  public final void cY(View paramView)
  {
    SnsCommentDetailUI.q(this.oWW).bEx();
    paramView = new Intent();
    paramView.putExtra("result_finish", true);
    this.oWW.setResult(-1, paramView);
    this.oWW.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.2
 * JD-Core Version:    0.7.0.1
 */