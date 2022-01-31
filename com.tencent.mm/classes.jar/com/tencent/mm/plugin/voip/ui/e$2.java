package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.plugin.voip.video.f;

final class e$2
  implements View.OnClickListener
{
  e$2(e parame) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.pYP;
    if (!e.i(this.pYP)) {}
    for (boolean bool = true;; bool = false)
    {
      e.b(paramView, bool);
      if (!e.i(this.pYP)) {
        e.j(this.pYP).setVisibility(8);
      }
      Toast.makeText(this.pYP.getActivity(), String.format("mIsShowFaceRect:%b", new Object[] { Boolean.valueOf(e.i(this.pYP)) }), 0).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.e.2
 * JD-Core Version:    0.7.0.1
 */