package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.welab.c.a.a;
import com.tencent.mm.plugin.welab.d.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Map;

final class WelabMainUI$4
  implements View.OnClickListener
{
  WelabMainUI$4(WelabMainUI paramWelabMainUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = paramView.getTag();
    Object localObject;
    if ((paramView instanceof a))
    {
      paramView = (a)paramView;
      localObject = new Intent();
      ((Intent)localObject).putExtra("para_appid", paramView.field_LabsAppId);
      if (!b.chq().e(paramView)) {
        break label178;
      }
    }
    label178:
    for (int i = 1;; i = 0)
    {
      ((Intent)localObject).putExtra("para_from_with_red_point", i);
      ((Intent)localObject).setClass(this.rEW, WelabAppInfoUI.class);
      this.rEW.startActivity((Intent)localObject);
      localObject = b.chq();
      String str = paramView.field_LabsAppId;
      ((b)localObject).rEw.put(str, Integer.valueOf(1));
      ((b)localObject).tag = (((b)localObject).tag + "&" + str + "=1");
      g.DP().Dz().c(ac.a.uwv, ((b)localObject).tag);
      b.chr();
      y.i("MicroMsg.WelabMainUI", "click " + paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabMainUI.4
 * JD-Core Version:    0.7.0.1
 */