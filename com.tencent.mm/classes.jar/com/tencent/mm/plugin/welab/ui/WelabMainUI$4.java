package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.welab.d.a.a;
import com.tencent.mm.plugin.welab.e.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Map;

final class WelabMainUI$4
  implements View.OnClickListener
{
  WelabMainUI$4(WelabMainUI paramWelabMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(80618);
    paramView = paramView.getTag();
    Object localObject;
    if ((paramView instanceof a))
    {
      paramView = (a)paramView;
      localObject = new Intent();
      ((Intent)localObject).putExtra("para_appid", paramView.field_LabsAppId);
      if (!b.dhC().e(paramView)) {
        break label181;
      }
    }
    label181:
    for (int i = 1;; i = 0)
    {
      ((Intent)localObject).putExtra("para_from_with_red_point", i);
      ((Intent)localObject).setClass(this.vvF, WelabAppInfoUI.class);
      this.vvF.startActivity((Intent)localObject);
      localObject = b.dhC();
      String str = paramView.field_LabsAppId;
      ((b)localObject).vuY.put(str, Integer.valueOf(1));
      ((b)localObject).tag = (((b)localObject).tag + "&" + str + "=1");
      g.RL().Ru().set(ac.a.yGD, ((b)localObject).tag);
      b.dhE();
      ab.i("MicroMsg.WelabMainUI", "click ".concat(String.valueOf(paramView)));
      AppMethodBeat.o(80618);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabMainUI.4
 * JD-Core Version:    0.7.0.1
 */