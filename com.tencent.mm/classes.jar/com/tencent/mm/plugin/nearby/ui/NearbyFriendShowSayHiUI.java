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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMActivity;

public class NearbyFriendShowSayHiUI
  extends MMActivity
{
  ImageView fuY;
  String vjm = "";
  View vjn = null;
  
  public int getLayoutId()
  {
    return 2131495003;
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
    ((Button)findViewById(2131302689)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(89826);
        paramAnonymousView = NearbyFriendShowSayHiUI.this;
        Object localObject = new Intent(NearbyFriendShowSayHiUI.this, NearbyFriendsUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendShowSayHiUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/nearby/ui/NearbyFriendShowSayHiUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(89826);
      }
    });
    this.vjn = findViewById(2131300604);
    this.vjn.setVisibility(0);
    this.vjn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(89827);
        paramAnonymousView = new Intent(NearbyFriendShowSayHiUI.this, NearbySayHiListUI.class);
        paramAnonymousView.putExtra("k_say_hi_type", 2);
        paramAnonymousView.putExtra("show_clear_header", true);
        NearbyFriendShowSayHiUI.this.startActivityForResult(paramAnonymousView, 2009);
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
    setMMTitle(2131761520);
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
    Object localObject = (TextView)findViewById(2131304292);
    g.agP().afT();
    int i = ((k)g.ab(k.class)).dco().bQe();
    if (i == 0)
    {
      this.vjn.setVisibility(4);
      AppMethodBeat.o(89829);
      return;
    }
    ((TextView)localObject).setText(getResources().getQuantityString(2131623965, i, new Object[] { Integer.valueOf(i) }));
    this.fuY = ((ImageView)findViewById(2131302192));
    localObject = ((k)g.ab(k.class)).dco().dcy();
    if (localObject != null)
    {
      this.vjm = ((bl)localObject).field_sayhiuser;
      a.b.c(this.fuY, this.vjm);
    }
    AppMethodBeat.o(89829);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendShowSayHiUI
 * JD-Core Version:    0.7.0.1
 */