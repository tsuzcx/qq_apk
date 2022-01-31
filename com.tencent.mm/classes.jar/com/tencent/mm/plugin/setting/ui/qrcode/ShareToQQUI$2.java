package com.tencent.mm.plugin.setting.ui.qrcode;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.g.a.c;

final class ShareToQQUI$2
  implements MenuItem.OnMenuItemClickListener
{
  ShareToQQUI$2(ShareToQQUI paramShareToQQUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(126920);
    ShareToQQUI.a(this.qFA);
    boolean bool1;
    boolean bool2;
    if ((ShareToQQUI.b(this.qFA) == 2) || (ShareToQQUI.b(this.qFA) == 1))
    {
      paramMenuItem = ShareToQQUI.c(this.qFA).getText().toString();
      if (ShareToQQUI.b(this.qFA) == 1)
      {
        bool1 = true;
        if (ShareToQQUI.b(this.qFA) != 2) {
          break label162;
        }
        bool2 = true;
      }
    }
    label75:
    for (paramMenuItem = new x(paramMenuItem, bool1, bool2);; paramMenuItem = new x(ShareToQQUI.c(this.qFA).getText().toString()))
    {
      g.Rc().a(paramMenuItem, 0);
      Object localObject = this.qFA;
      AppCompatActivity localAppCompatActivity = this.qFA.getContext();
      this.qFA.getString(2131297087);
      ShareToQQUI.a((ShareToQQUI)localObject, com.tencent.mm.ui.base.h.b(localAppCompatActivity, this.qFA.getString(2131297069), true, new ShareToQQUI.2.2(this, paramMenuItem)));
      AppMethodBeat.o(126920);
      return true;
      bool1 = false;
      break;
      bool2 = false;
      break label75;
      if (ShareToQQUI.b(this.qFA) != 4) {
        break label304;
      }
      long l = bo.c((Long)g.RL().Ru().get(65831, null));
      paramMenuItem = bo.nullAsNil((String)g.RL().Ru().get(65830, null));
      if ((bo.hl(l) > 86400000L) && (paramMenuItem.length() > 0))
      {
        localObject = new c(this.qFA.getString(2131306163));
        ((c)localObject).auI(paramMenuItem);
        new com.tencent.mm.plugin.account.model.h((c)localObject, new ShareToQQUI.2.1(this)).apL();
      }
    }
    label162:
    label304:
    com.tencent.mm.ui.base.h.h(this.qFA.getContext(), 2131303661, 2131297087);
    AppMethodBeat.o(126920);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI.2
 * JD-Core Version:    0.7.0.1
 */