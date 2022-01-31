package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.y;

public final class a$f
  extends a.c
{
  public a$f(a parama)
  {
    super(parama);
  }
  
  public final void a(l paraml)
  {
    super.a(paraml);
    paraml.e(5, this.uRJ.context.getString(R.l.app_brand_menu_accept_msg));
    paraml.e(4, this.uRJ.context.getString(R.l.app_brand_service_menu_cancel));
  }
  
  public final View cAl()
  {
    View localView = y.gt(this.uRJ.context).inflate(R.i.chatting_appbrand_action_sheet_title, null);
    ((TextView)localView.findViewById(R.h.appbrand_view_title)).setText(this.uRJ.context.getString(R.l.app_brand_service_menu_receive_confirm_msg));
    return localView;
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    super.onMMMenuItemSelected(paramMenuItem, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.a.f
 * JD-Core Version:    0.7.0.1
 */