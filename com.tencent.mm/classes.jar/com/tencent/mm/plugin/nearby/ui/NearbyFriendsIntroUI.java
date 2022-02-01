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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;

public class NearbyFriendsIntroUI
  extends MMActivity
{
  private Button hJh;
  private View hJk;
  private CheckBox uai;
  private d uak = null;
  
  public int getLayoutId()
  {
    return 2131495001;
  }
  
  public void initView()
  {
    AppMethodBeat.i(89837);
    this.hJk = View.inflate(this, 2131494579, null);
    this.uai = ((CheckBox)this.hJk.findViewById(2131301369));
    this.uai.setChecked(false);
    this.hJh = ((Button)findViewById(2131302689));
    this.hJh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(89834);
        if (NearbyFriendsIntroUI.a(NearbyFriendsIntroUI.this) == null)
        {
          NearbyFriendsIntroUI.a(NearbyFriendsIntroUI.this, h.a(NearbyFriendsIntroUI.this.getContext(), NearbyFriendsIntroUI.this.getString(2131755906), NearbyFriendsIntroUI.b(NearbyFriendsIntroUI.this), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(89833);
              g.afB().afk().set(4103, Boolean.TRUE);
              paramAnonymous2DialogInterface = g.afB().afk();
              boolean bool;
              Object localObject;
              if (!NearbyFriendsIntroUI.c(NearbyFriendsIntroUI.this).isChecked())
              {
                bool = true;
                paramAnonymous2DialogInterface.set(4104, Boolean.valueOf(bool));
                paramAnonymous2DialogInterface = bs.asC();
                if (paramAnonymous2DialogInterface != null) {
                  break label175;
                }
                paramAnonymous2DialogInterface = NearbyFriendsIntroUI.this;
                localObject = new Intent(NearbyFriendsIntroUI.this, NearbyPersonalInfoUI.class);
                localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
                localObject = bt.nullAsNil(paramAnonymous2DialogInterface.getProvince());
                bt.nullAsNil(paramAnonymous2DialogInterface.getCity());
                paramAnonymous2Int = bt.a(Integer.valueOf(paramAnonymous2DialogInterface.evp), 0);
                if ((((String)localObject).equals("")) || (paramAnonymous2Int == 0))
                {
                  paramAnonymous2DialogInterface = NearbyFriendsIntroUI.this;
                  localObject = new Intent(NearbyFriendsIntroUI.this, NearbyPersonalInfoUI.class);
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                else
                {
                  paramAnonymous2DialogInterface = NearbyFriendsIntroUI.this;
                  localObject = new Intent(NearbyFriendsIntroUI.this, NearbyFriendsUI.class);
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
              }
            }
          }, null));
          AppMethodBeat.o(89834);
          return;
        }
        NearbyFriendsIntroUI.a(NearbyFriendsIntroUI.this).show();
        AppMethodBeat.o(89834);
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
    setMMTitle(2131761520);
    initView();
    AppMethodBeat.o(89836);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsIntroUI
 * JD-Core Version:    0.7.0.1
 */