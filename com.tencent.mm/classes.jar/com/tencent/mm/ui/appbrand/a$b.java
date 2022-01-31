package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.l;

public final class a$b
  extends a.c
{
  public a$b(a parama)
  {
    super(parama);
  }
  
  public final void a(l paraml)
  {
    super.a(paraml);
    paraml.e(3, this.uRJ.context.getString(R.l.app_brand_service_menu_refuse_msg));
    paraml.e(8, this.uRJ.context.getString(R.l.app_brand_service_menu_expose));
    paraml.e(7, a.a(this.uRJ));
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    super.onMMMenuItemSelected(paramMenuItem, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.a.b
 * JD-Core Version:    0.7.0.1
 */