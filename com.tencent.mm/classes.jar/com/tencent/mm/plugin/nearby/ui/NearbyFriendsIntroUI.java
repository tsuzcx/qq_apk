package com.tencent.mm.plugin.nearby.ui;

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
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.nearby.b.c;
import com.tencent.mm.plugin.nearby.b.d;
import com.tencent.mm.plugin.nearby.b.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;

public class NearbyFriendsIntroUI
  extends MMActivity
{
  private CheckBox MoT;
  private com.tencent.mm.ui.widget.a.e MoV = null;
  private Button nhC;
  private View plv;
  
  public int getLayoutId()
  {
    return b.d.Mog;
  }
  
  public void initView()
  {
    AppMethodBeat.i(89837);
    this.plv = View.inflate(this, b.d.gli, null);
    this.MoT = ((CheckBox)this.plv.findViewById(b.c.fMB));
    this.MoT.setChecked(false);
    this.nhC = ((Button)findViewById(b.c.Moc));
    this.nhC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(89834);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (NearbyFriendsIntroUI.a(NearbyFriendsIntroUI.this) == null) {
          NearbyFriendsIntroUI.a(NearbyFriendsIntroUI.this, k.a(NearbyFriendsIntroUI.this.getContext(), NearbyFriendsIntroUI.this.getString(b.g.app_tip), NearbyFriendsIntroUI.b(NearbyFriendsIntroUI.this), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(89833);
              h.baE().ban().B(4103, Boolean.TRUE);
              paramAnonymous2DialogInterface = h.baE().ban();
              boolean bool;
              Object localObject;
              if (!NearbyFriendsIntroUI.c(NearbyFriendsIntroUI.this).isChecked())
              {
                bool = true;
                paramAnonymous2DialogInterface.B(4104, Boolean.valueOf(bool));
                paramAnonymous2DialogInterface = cb.bDf();
                if (paramAnonymous2DialogInterface != null) {
                  break label191;
                }
                paramAnonymous2DialogInterface = NearbyFriendsIntroUI.this;
                localObject = new Intent(NearbyFriendsIntroUI.this, NearbyPersonalInfoUI.class);
                localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2DialogInterface, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              for (;;)
              {
                ((com.tencent.d.a.b.a.e)h.az(com.tencent.d.a.b.a.e.class)).nearbyReport(14L);
                NearbyFriendsIntroUI.this.finish();
                AppMethodBeat.o(89833);
                return;
                bool = false;
                break;
                label191:
                localObject = Util.nullAsNil(paramAnonymous2DialogInterface.getProvince());
                Util.nullAsNil(paramAnonymous2DialogInterface.getCity());
                paramAnonymous2Int = Util.nullAs(Integer.valueOf(paramAnonymous2DialogInterface.sex), 0);
                if ((((String)localObject).equals("")) || (paramAnonymous2Int == 0))
                {
                  paramAnonymous2DialogInterface = NearbyFriendsIntroUI.this;
                  localObject = new Intent(NearbyFriendsIntroUI.this, NearbyPersonalInfoUI.class);
                  localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2DialogInterface, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                else
                {
                  paramAnonymous2DialogInterface = NearbyFriendsIntroUI.this;
                  localObject = new Intent(NearbyFriendsIntroUI.this, NearbyFriendsUI.class);
                  localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2DialogInterface, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    ((com.tencent.d.a.b.a.e)h.az(com.tencent.d.a.b.a.e.class)).nearbyReport(13L);
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
    setMMTitle(b.g.nearby_friend_title);
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