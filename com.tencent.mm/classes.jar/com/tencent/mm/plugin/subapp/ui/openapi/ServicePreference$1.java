package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class ServicePreference$1
  implements AdapterView.OnItemClickListener
{
  ServicePreference$1(ServicePreference paramServicePreference) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (ServicePreference.a(this.pxu).sk(paramInt)) {
      ServicePreference.a(this.pxu).jD(false);
    }
    do
    {
      do
      {
        return;
        if (!ServicePreference.a(this.pxu).pwV) {
          break;
        }
      } while (ServicePreference.b(this.pxu) == null);
      ServicePreference.b(this.pxu).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    } while (ServicePreference.c(this.pxu) == null);
    ServicePreference.c(this.pxu).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.ServicePreference.1
 * JD-Core Version:    0.7.0.1
 */