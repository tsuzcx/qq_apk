package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;

public class NearbyFriendShowSayHiUI
  extends MMActivity
{
  String AzV = "";
  View AzW = null;
  ImageView gvv;
  
  public int getLayoutId()
  {
    return 2131495817;
  }
  
  public void initView()
  {
    AppMethodBeat.i(89831);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(89825);
        NearbyFriendShowSayHiUI.this.hideVKB();
        NearbyFriendShowSayHiUI.this.finish();
        AppMethodBeat.o(89825);
        return true;
      }
    });
    ((Button)findViewById(2131305243)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(89826);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendShowSayHiUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        paramAnonymousView = NearbyFriendShowSayHiUI.this;
        localObject = new Intent(NearbyFriendShowSayHiUI.this, NearbyFriendsUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendShowSayHiUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/nearby/ui/NearbyFriendShowSayHiUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendShowSayHiUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(89826);
      }
    });
    this.AzW = findViewById(2131302157);
    this.AzW.setVisibility(0);
    this.AzW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(89827);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendShowSayHiUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new Intent(NearbyFriendShowSayHiUI.this, NearbySayHiListUI.class);
        paramAnonymousView.putExtra("k_say_hi_type", 2);
        paramAnonymousView.putExtra("show_clear_header", true);
        NearbyFriendShowSayHiUI.this.startActivityForResult(paramAnonymousView, 2009);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendShowSayHiUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(89827);
      }
    });
    AppMethodBeat.o(89831);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(89832);
    if ((paramInt1 == 2009) && (paramInt2 == -1)) {
      finish();
    }
    AppMethodBeat.o(89832);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(89828);
    super.onCreate(paramBundle);
    setMMTitle(2131763462);
    initView();
    AppMethodBeat.o(89828);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(89830);
    super.onPause();
    AppMethodBeat.o(89830);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(89829);
    super.onResume();
    Object localObject = (TextView)findViewById(2131307220);
    com.tencent.mm.kernel.g.aAf().azk();
    int i = ((l)com.tencent.mm.kernel.g.af(l.class)).eiv().ctM();
    if (i == 0)
    {
      this.AzW.setVisibility(4);
      AppMethodBeat.o(89829);
      return;
    }
    ((TextView)localObject).setText(getResources().getQuantityString(2131623965, i, new Object[] { Integer.valueOf(i) }));
    this.gvv = ((ImageView)findViewById(2131304534));
    localObject = ((l)com.tencent.mm.kernel.g.af(l.class)).eiv().eiG();
    if (localObject != null)
    {
      this.AzV = ((bx)localObject).field_sayhiuser;
      a.b.c(this.gvv, this.AzV);
    }
    AppMethodBeat.o(89829);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendShowSayHiUI
 * JD-Core Version:    0.7.0.1
 */