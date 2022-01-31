package com.tencent.mm.plugin.sns.ui.d;

import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.widget.b.a;

final class b$2
  implements View.OnLongClickListener
{
  b$2(b paramb) {}
  
  public final boolean onLongClick(View paramView)
  {
    String str = (String)paramView.getTag();
    y.d("MicroMsg.TimelineClickListener", "onCommentLongClick:" + str);
    if (bk.bl(str)) {
      return true;
    }
    if (str.equals(af.bDl())) {
      return true;
    }
    Object localObject;
    n localn;
    if ((((MaskImageButton)paramView).wdF != null) && ((((MaskImageButton)paramView).wdF instanceof String)))
    {
      localObject = (String)((MaskImageButton)paramView).wdF;
      new Intent();
      localn = af.bDF().OB((String)localObject);
      if ((localn == null) || (!localn.yr(32))) {
        break label227;
      }
    }
    label227:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        return false;
        localObject = "";
        break;
      }
      a locala = new a(this.ppl.activity, paramView);
      locala.wog = new b.2.1(this);
      locala.phI = new b.2.2(this, localn, str, (String)localObject);
      localObject = new int[2];
      if ((paramView.getTag(i.f.touch_loc) instanceof int[])) {
        localObject = (int[])paramView.getTag(i.f.touch_loc);
      }
      locala.ch(localObject[0], localObject[1]);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.2
 * JD-Core Version:    0.7.0.1
 */