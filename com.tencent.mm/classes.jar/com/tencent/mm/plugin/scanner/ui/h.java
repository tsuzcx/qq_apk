package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.a.a;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;

public final class h
  extends Preference
{
  private Context mContext;
  private View mView;
  List<a.a> pvs;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(81069);
    this.mView = null;
    this.mContext = null;
    this.pvs = null;
    this.mContext = paramContext;
    setLayoutResource(2130970443);
    AppMethodBeat.o(81069);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(81070);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(81070);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(81071);
    super.onBindView(paramView);
    paramView = (GridView)this.mView.findViewById(2131826775);
    h.b localb = new h.b(this);
    paramView.setAdapter(localb);
    if (this.pvs != null) {
      localb.setItemList(this.pvs);
    }
    AppMethodBeat.o(81071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.h
 * JD-Core Version:    0.7.0.1
 */