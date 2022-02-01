package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.conversation.g.d;
import com.tencent.mm.plugin.textstatus.conversation.h.b;
import com.tencent.mm.plugin.textstatus.h.f.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusNotifyItemUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "msgBtnCallback", "Lkotlin/Function0;", "", "getMsgBtnCallback", "()Lkotlin/jvm/functions/Function0;", "setMsgBtnCallback", "(Lkotlin/jvm/functions/Function0;)V", "checkNotifyItem", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onResume", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends UIComponent
  implements MStorage.IOnStorageChange
{
  public static final k.a TzC;
  kotlin.g.a.a<Integer> TzD;
  
  static
  {
    AppMethodBeat.i(291257);
    TzC = new k.a((byte)0);
    AppMethodBeat.o(291257);
  }
  
  public k(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(291243);
    AppMethodBeat.o(291243);
  }
  
  private static final boolean a(k paramk, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(291250);
    s.u(paramk, "this$0");
    paramMenuItem = TextStatusLikeListActivity.Tzn;
    paramMenuItem = (Context)paramk.getActivity();
    paramk = paramk.TzD;
    int i;
    if (paramk == null) {
      i = 0;
    }
    for (;;)
    {
      s.u(paramMenuItem, "context");
      paramk = new Intent(paramMenuItem, TextStatusLikeListActivity.class);
      paramk.putExtra("scene", 3);
      paramk.putExtra("reportEnterScene", i);
      paramk = new com.tencent.mm.hellhoundlib.b.a().cG(paramk);
      com.tencent.mm.hellhoundlib.a.a.b(paramMenuItem, paramk.aYi(), "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForSelfMsg", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramMenuItem.startActivity((Intent)paramk.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramMenuItem, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForSelfMsg", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(291250);
      return true;
      paramk = (Integer)paramk.invoke();
      if (paramk == null) {
        i = 0;
      } else {
        i = paramk.intValue();
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(291273);
    super.onCreate(paramBundle);
    Log.d("MicroMsg.TextStatus.TextStatusNotifyItemUIC", s.X("onCreate() called with: savedInstanceState = ", paramBundle));
    paramBundle = getActivity();
    if ((paramBundle instanceof MMActivity))
    {
      paramBundle = (MMActivity)paramBundle;
      if (paramBundle != null) {
        paramBundle.addTextOptionMenu(0, getString(a.h.finder_self_wx_msg), new k..ExternalSyntheticLambda0(this));
      }
      paramBundle = getActivity();
      if (!(paramBundle instanceof MMActivity)) {
        break label147;
      }
    }
    label147:
    for (paramBundle = (MMActivity)paramBundle;; paramBundle = null)
    {
      if (paramBundle != null)
      {
        d locald = d.Tjx;
        paramBundle.showOptionMenu(d.hGA());
      }
      paramBundle = f.TjQ;
      f.hGL().add((MStorage.IOnStorageChange)this);
      paramBundle = f.TjQ;
      f.hGN().add((MStorage.IOnStorageChange)this);
      paramBundle = f.TjQ;
      f.hGK().add((MStorage.IOnStorageChange)this);
      AppMethodBeat.o(291273);
      return;
      paramBundle = null;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(291284);
    super.onDestroy();
    f localf = f.TjQ;
    f.hGL().remove((MStorage.IOnStorageChange)this);
    localf = f.TjQ;
    f.hGN().remove((MStorage.IOnStorageChange)this);
    localf = f.TjQ;
    f.hGK().remove((MStorage.IOnStorageChange)this);
    AppMethodBeat.o(291284);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(291290);
    Log.i("MicroMsg.TextStatus.TextStatusNotifyItemUIC", "onNotifyChange");
    AppMethodBeat.o(291290);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(291277);
    super.onResume();
    AppMethodBeat.o(291277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.k
 * JD-Core Version:    0.7.0.1
 */