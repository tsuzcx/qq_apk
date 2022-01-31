package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.f;

final class CategoryWithTitlePreference$1
  implements Runnable
{
  CategoryWithTitlePreference$1(CategoryWithTitlePreference paramCategoryWithTitlePreference, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(81000);
    CategoryWithTitlePreference.a(this.qwO).setImageBitmap(this.val$bitmap);
    CategoryWithTitlePreference.a(this.qwO).setVisibility(0);
    if (CategoryWithTitlePreference.b(this.qwO) != null) {
      CategoryWithTitlePreference.b(this.qwO).notifyDataSetChanged();
    }
    AppMethodBeat.o(81000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.CategoryWithTitlePreference.1
 * JD-Core Version:    0.7.0.1
 */