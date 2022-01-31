package com.tencent.mm.plugin.sight.draft.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.modelvideo.j;

final class b$b
  implements View.OnLongClickListener
{
  private b$b(b paramb) {}
  
  public final boolean onLongClick(View paramView)
  {
    if (!(paramView.getTag() instanceof b.e)) {}
    do
    {
      return true;
      paramView = (b.e)paramView.getTag();
    } while ((paramView.ogR == null) || (-1 == paramView.ogR.field_fileStatus));
    this.ogK.a(b.d.ogM, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.b.b
 * JD-Core Version:    0.7.0.1
 */