package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;

public class NearbyFriendsIntroUI
  extends MMActivity
{
  private CheckBox AzQ;
  private d AzS = null;
  private Button hPX;
  private View jBV;
  
  public int getLayoutId()
  {
    return 2131495815;
  }
  
  public void initView()
  {
    AppMethodBeat.i(89837);
    this.jBV = View.inflate(this, 2131495206, null);
    this.AzQ = ((CheckBox)this.jBV.findViewById(2131303120));
    this.AzQ.setChecked(false);
    this.hPX = ((Button)findViewById(2131305243));
    this.hPX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(89834);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (NearbyFriendsIntroUI.a(NearbyFriendsIntroUI.this) == null) {
          NearbyFriendsIntroUI.a(NearbyFriendsIntroUI.this, h.a(NearbyFriendsIntroUI.this.getContext(), NearbyFriendsIntroUI.this.getString(2131755998), NearbyFriendsIntroUI.b(NearbyFriendsIntroUI.this), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(89833);
              g.aAh().azQ().set(4103, Boolean.TRUE);
              paramAnonymous2DialogInterface = g.aAh().azQ();
              boolean bool;
              Object localObject;
              if (!NearbyFriendsIntroUI.c(NearbyFriendsIntroUI.this).isChecked())
              {
                bool = true;
                paramAnonymous2DialogInterface.set(4104, Boolean.valueOf(bool));
                paramAnonymous2DialogInterface = bz.aWk();
                if (paramAnonymous2DialogInterface != null) {
                  break label175;
                }
                paramAnonymous2DialogInterface = NearbyFriendsIntroUI.this;
                localObject = new Intent(NearbyFriendsIntroUI.this, NearbyPersonalInfoUI.class);
                localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              for (;;)
              {
                NearbyFriendsIntroUI.this.finish();
                AppMethodBeat.o(89833);
                return;
                bool = false;
                break;
                label175:
                localObject = Util.nullAsNil(paramAnonymous2DialogInterface.getProvince());
                Util.nullAsNil(paramAnonymous2DialogInterface.getCity());
                paramAnonymous2Int = Util.nullAs(Integer.valueOf(paramAnonymous2DialogInterface.fuA), 0);
                if ((((String)localObject).equals("")) || (paramAnonymous2Int == 0))
                {
                  paramAnonymous2DialogInterface = NearbyFriendsIntroUI.this;
                  localObject = new Intent(NearbyFriendsIntroUI.this, NearbyPersonalInfoUI.class);
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                else
                {
                  paramAnonymous2DialogInterface = NearbyFriendsIntroUI.this;
                  localObject = new Intent(NearbyFriendsIntroUI.this, NearbyFriendsUI.class);
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
              }
            }
          }, null));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(89834);
          return;
          NearbyFriendsIntroUI.a(NearbyFriendsIntroUI.this).show();
        }
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(89835);
        NearbyFriendsIntroUI.this.hideVKB();
        NearbyFriendsIntroUI.this.finish();
        AppMethodBeat.o(89835);
        return true;
      }
    });
    AppMethodBeat.o(89837);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(89836);
    super.onCreate(paramBundle);
    setMMTitle(2131763462);
    initView();
    AppMethodBeat.o(89836);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsIntroUI
 * JD-Core Version:    0.7.0.1
 */