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
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;

public class NearbyFriendsIntroUI
  extends MMActivity
{
  private Button gUt;
  private View iCZ;
  private CheckBox woA;
  private d woC = null;
  
  public int getLayoutId()
  {
    return 2131495001;
  }
  
  public void initView()
  {
    AppMethodBeat.i(89837);
    this.iCZ = View.inflate(this, 2131494579, null);
    this.woA = ((CheckBox)this.iCZ.findViewById(2131301369));
    this.woA.setChecked(false);
    this.gUt = ((Button)findViewById(2131302689));
    this.gUt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(89834);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (NearbyFriendsIntroUI.a(NearbyFriendsIntroUI.this) == null) {
          NearbyFriendsIntroUI.a(NearbyFriendsIntroUI.this, h.a(NearbyFriendsIntroUI.this.getContext(), NearbyFriendsIntroUI.this.getString(2131755906), NearbyFriendsIntroUI.b(NearbyFriendsIntroUI.this), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(89833);
              g.ajC().ajl().set(4103, Boolean.TRUE);
              paramAnonymous2DialogInterface = g.ajC().ajl();
              boolean bool;
              Object localObject;
              if (!NearbyFriendsIntroUI.c(NearbyFriendsIntroUI.this).isChecked())
              {
                bool = true;
                paramAnonymous2DialogInterface.set(4104, Boolean.valueOf(bool));
                paramAnonymous2DialogInterface = com.tencent.mm.model.bt.aCw();
                if (paramAnonymous2DialogInterface != null) {
                  break label175;
                }
                paramAnonymous2DialogInterface = NearbyFriendsIntroUI.this;
                localObject = new Intent(NearbyFriendsIntroUI.this, NearbyPersonalInfoUI.class);
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
                localObject = com.tencent.mm.sdk.platformtools.bt.nullAsNil(paramAnonymous2DialogInterface.getProvince());
                com.tencent.mm.sdk.platformtools.bt.nullAsNil(paramAnonymous2DialogInterface.getCity());
                paramAnonymous2Int = com.tencent.mm.sdk.platformtools.bt.a(Integer.valueOf(paramAnonymous2DialogInterface.ePk), 0);
                if ((((String)localObject).equals("")) || (paramAnonymous2Int == 0))
                {
                  paramAnonymous2DialogInterface = NearbyFriendsIntroUI.this;
                  localObject = new Intent(NearbyFriendsIntroUI.this, NearbyPersonalInfoUI.class);
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                else
                {
                  paramAnonymous2DialogInterface = NearbyFriendsIntroUI.this;
                  localObject = new Intent(NearbyFriendsIntroUI.this, NearbyFriendsUI.class);
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsIntroUI
 * JD-Core Version:    0.7.0.1
 */