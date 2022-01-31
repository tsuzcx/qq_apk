package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashSet;

final class UnfamiliarContactDetailUI$11
  implements UnfamiliarContactDetailUI.h
{
  long start;
  
  UnfamiliarContactDetailUI$11(UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI)
  {
    AppMethodBeat.i(127648);
    this.start = System.currentTimeMillis();
    AppMethodBeat.o(127648);
  }
  
  public final void a(UnfamiliarContactDetailUI.e parame)
  {
    AppMethodBeat.i(127651);
    ab.i("MicroMsg.UnfamiliarContactUI", "[onLoading] type:%s", new Object[] { parame.name() });
    this.qLi.findViewById(2131827679).setVisibility(0);
    this.qLi.findViewById(2131821119).setVisibility(0);
    if (parame == UnfamiliarContactDetailUI.e.qLD)
    {
      UnfamiliarContactDetailUI.k(this.qLi).setText(this.qLi.getString(2131301086));
      AppMethodBeat.o(127651);
      return;
    }
    if (parame == UnfamiliarContactDetailUI.e.qLC) {
      UnfamiliarContactDetailUI.k(this.qLi).setText(this.qLi.getString(2131304420));
    }
    AppMethodBeat.o(127651);
  }
  
  public final void e(HashSet paramHashSet)
  {
    AppMethodBeat.i(127652);
    if (paramHashSet == null) {}
    for (int i = 0;; i = paramHashSet.size())
    {
      ab.i("MicroMsg.UnfamiliarContactUI", "[onResult] size:%s", new Object[] { Integer.valueOf(i) });
      if (paramHashSet != null) {
        UnfamiliarContactDetailUI.a(this.qLi, paramHashSet);
      }
      AppMethodBeat.o(127652);
      return;
    }
  }
  
  public final void onError()
  {
    AppMethodBeat.i(127650);
    ab.e("MicroMsg.UnfamiliarContactUI", "[onError]");
    this.qLi.findViewById(2131827679).setVisibility(0);
    this.qLi.findViewById(2131821119).setVisibility(8);
    UnfamiliarContactDetailUI.k(this.qLi).setText(this.qLi.getString(2131304419));
    AppMethodBeat.o(127650);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(127649);
    ab.i("MicroMsg.UnfamiliarContactUI", "[onSuccess] size:%s cost:%sms", new Object[] { Integer.valueOf(UnfamiliarContactDetailUI.f(this.qLi).size()), Long.valueOf(System.currentTimeMillis() - this.start) });
    UnfamiliarContactDetailUI.g(this.qLi).setText(this.qLi.getString(2131304413) + "(" + UnfamiliarContactDetailUI.f(this.qLi).size() + ")");
    if (UnfamiliarContactDetailUI.f(this.qLi).size() == 0)
    {
      this.qLi.findViewById(2131827679).setVisibility(0);
      this.qLi.findViewById(2131821119).setVisibility(8);
      this.qLi.findViewById(2131821980).setVisibility(8);
      UnfamiliarContactDetailUI.k(this.qLi).setText(this.qLi.getString(2131301082));
      AppMethodBeat.o(127649);
      return;
    }
    this.qLi.findViewById(2131827679).setVisibility(8);
    this.qLi.findViewById(2131821980).setVisibility(0);
    if (UnfamiliarContactDetailUI.e(this.qLi) != null) {
      UnfamiliarContactDetailUI.e(this.qLi).ajb.notifyChanged();
    }
    AppMethodBeat.o(127649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.11
 * JD-Core Version:    0.7.0.1
 */