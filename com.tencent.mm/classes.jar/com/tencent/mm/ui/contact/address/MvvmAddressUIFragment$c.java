package com.tencent.mm.ui.contact.address;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.repairer.PluginRepairer;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u.i;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/address/MvvmAddressUIFragment$MenuItemSelectedListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "dataItem", "Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "position", "", "(Lcom/tencent/mm/ui/contact/address/MvvmAddressUIFragment;Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;I)V", "getDataItem", "()Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "getPosition", "()I", "onMMMenuItemSelected", "", "menuItem", "Landroid/view/MenuItem;", "index", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MvvmAddressUIFragment$c
  implements u.i
{
  private final d afju;
  private final int position;
  
  public MvvmAddressUIFragment$c(d paramd, int paramInt)
  {
    AppMethodBeat.i(253182);
    this.afju = paramInt;
    int i;
    this.position = i;
    AppMethodBeat.o(253182);
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(253195);
    if (paramMenuItem != null)
    {
      MvvmAddressUIFragment localMvvmAddressUIFragment = this.afjv;
      switch (paramMenuItem.getItemId())
      {
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      default: 
        AppMethodBeat.o(253195);
        return;
      case 1: 
      case 2: 
        MvvmAddressUIFragment.aK(this.afju.contact);
        AppMethodBeat.o(253195);
        return;
      case 7: 
        MvvmAddressUIFragment.a(localMvvmAddressUIFragment, this.afju.contact);
        AppMethodBeat.o(253195);
        return;
      }
      paramMenuItem = Util.secPrint(this.afju.contact.field_username) + '-' + f.formatTime("yyyy-MM-dd_HH:mm:ss", cn.getSyncServerTimeSecond()) + ".txt";
      ((PluginRepairer)h.az(PluginRepairer.class)).sendContactInfo(paramMenuItem, this.afju.contact);
      AppMethodBeat.o(253195);
      return;
    }
    AppMethodBeat.o(253195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.address.MvvmAddressUIFragment.c
 * JD-Core Version:    0.7.0.1
 */