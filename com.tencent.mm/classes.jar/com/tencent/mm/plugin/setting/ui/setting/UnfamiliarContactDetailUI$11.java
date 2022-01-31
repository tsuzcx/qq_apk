package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashSet;

final class UnfamiliarContactDetailUI$11
  implements UnfamiliarContactDetailUI.h
{
  long start = System.currentTimeMillis();
  
  UnfamiliarContactDetailUI$11(UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final void a(UnfamiliarContactDetailUI.e parame)
  {
    y.i("MicroMsg.UnfamiliarContactUI", "[onLoading] type:%s", new Object[] { parame.name() });
    this.nWX.findViewById(a.f.tip_layout).setVisibility(0);
    this.nWX.findViewById(a.f.progress_bar).setVisibility(0);
    if (parame == UnfamiliarContactDetailUI.e.nXt) {
      UnfamiliarContactDetailUI.k(this.nWX).setText(this.nWX.getString(a.i.loading_tips));
    }
    while (parame != UnfamiliarContactDetailUI.e.nXs) {
      return;
    }
    UnfamiliarContactDetailUI.k(this.nWX).setText(this.nWX.getString(a.i.unfamiliar_loading_about_one_min));
  }
  
  public final void e(HashSet paramHashSet)
  {
    if (paramHashSet == null) {}
    for (int i = 0;; i = paramHashSet.size())
    {
      y.i("MicroMsg.UnfamiliarContactUI", "[onResult] size:%s", new Object[] { Integer.valueOf(i) });
      if (paramHashSet != null) {
        UnfamiliarContactDetailUI.a(this.nWX, paramHashSet);
      }
      return;
    }
  }
  
  public final void onError()
  {
    y.e("MicroMsg.UnfamiliarContactUI", "[onError]");
    this.nWX.findViewById(a.f.tip_layout).setVisibility(0);
    this.nWX.findViewById(a.f.progress_bar).setVisibility(8);
    UnfamiliarContactDetailUI.k(this.nWX).setText(this.nWX.getString(a.i.unfamiliar_load_err));
  }
  
  public final void onSuccess()
  {
    y.i("MicroMsg.UnfamiliarContactUI", "[onSuccess] size:%s cost:%sms", new Object[] { Integer.valueOf(UnfamiliarContactDetailUI.f(this.nWX).size()), Long.valueOf(System.currentTimeMillis() - this.start) });
    UnfamiliarContactDetailUI.g(this.nWX).setText(this.nWX.getString(a.i.unfamiliar_contact_member_list) + "(" + UnfamiliarContactDetailUI.f(this.nWX).size() + ")");
    if (UnfamiliarContactDetailUI.f(this.nWX).size() == 0)
    {
      this.nWX.findViewById(a.f.tip_layout).setVisibility(0);
      this.nWX.findViewById(a.f.progress_bar).setVisibility(8);
      this.nWX.findViewById(a.f.list_layout).setVisibility(8);
      UnfamiliarContactDetailUI.k(this.nWX).setText(this.nWX.getString(a.i.loaded_empty));
    }
    do
    {
      return;
      this.nWX.findViewById(a.f.tip_layout).setVisibility(8);
      this.nWX.findViewById(a.f.list_layout).setVisibility(0);
    } while (UnfamiliarContactDetailUI.e(this.nWX) == null);
    UnfamiliarContactDetailUI.e(this.nWX).agL.notifyChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.11
 * JD-Core Version:    0.7.0.1
 */