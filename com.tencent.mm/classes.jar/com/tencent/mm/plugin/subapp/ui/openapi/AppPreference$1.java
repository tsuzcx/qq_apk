package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class AppPreference$1
  implements AdapterView.OnItemClickListener
{
  AppPreference$1(AppPreference paramAppPreference) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (AppPreference.a(this.pxf).sk(paramInt)) {
      AppPreference.a(this.pxf).jD(false);
    }
    do
    {
      do
      {
        return;
        if (!AppPreference.a(this.pxf).pwV) {
          break;
        }
      } while (AppPreference.b(this.pxf) == null);
      AppPreference.b(this.pxf).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    } while (AppPreference.c(this.pxf) == null);
    AppPreference.c(this.pxf).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppPreference.1
 * JD-Core Version:    0.7.0.1
 */