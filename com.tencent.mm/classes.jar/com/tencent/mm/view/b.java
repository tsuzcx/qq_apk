package com.tencent.mm.view;

import android.content.Context;
import com.tencent.mm.api.d;
import com.tencent.mm.api.q.a;

public final class b
  extends a
{
  public b(Context paramContext, q.a parama)
  {
    super(paramContext, parama);
  }
  
  protected final com.tencent.mm.view.b.a cLu()
  {
    return new com.tencent.mm.view.b.b(getContext(), getPresenter());
  }
  
  protected final com.tencent.mm.view.footer.a cLv()
  {
    return new com.tencent.mm.view.footer.b(getContext(), getPresenter());
  }
  
  public final d[] getFeatures()
  {
    if (this.wvv == null) {
      this.wvv = new d[] { d.buL, d.buN, d.buM, d.buO, d.buP };
    }
    return this.wvv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.b
 * JD-Core Version:    0.7.0.1
 */