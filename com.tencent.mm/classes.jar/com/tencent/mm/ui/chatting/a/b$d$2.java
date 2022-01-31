package com.tencent.mm.ui.chatting.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.mm.ui.chatting.gallery.h;
import com.tencent.mm.ui.chatting.gallery.h.a;
import java.util.ArrayList;

final class b$d$2
  implements View.OnClickListener
{
  b$d$2(b.d paramd, b paramb) {}
  
  public final void onClick(View paramView)
  {
    boolean bool;
    if (!this.vop.khV.isChecked())
    {
      bool = true;
      if (h.a.cGc().khB.size() >= 9) {
        break label130;
      }
      this.vop.khV.setChecked(bool);
      if (bool) {
        break label116;
      }
      this.vop.khT.setVisibility(8);
    }
    for (;;)
    {
      if (this.vop.vol.vok != null)
      {
        int i = ((Integer)paramView.getTag()).intValue();
        paramView = this.vop.vol.GZ(i);
        this.vop.vol.vok.a(bool, paramView, i);
      }
      return;
      bool = false;
      break;
      label116:
      this.vop.khT.setVisibility(0);
      continue;
      label130:
      if (!bool) {
        this.vop.khV.setChecked(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.b.d.2
 * JD-Core Version:    0.7.0.1
 */