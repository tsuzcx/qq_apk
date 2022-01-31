package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.ui.base.preference.f;

final class CategoryWithTitlePreference$1
  implements Runnable
{
  CategoryWithTitlePreference$1(CategoryWithTitlePreference paramCategoryWithTitlePreference, Bitmap paramBitmap) {}
  
  public final void run()
  {
    CategoryWithTitlePreference.a(this.nJm).setImageBitmap(this.ara);
    CategoryWithTitlePreference.a(this.nJm).setVisibility(0);
    if (CategoryWithTitlePreference.b(this.nJm) != null) {
      CategoryWithTitlePreference.b(this.nJm).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.CategoryWithTitlePreference.1
 * JD-Core Version:    0.7.0.1
 */