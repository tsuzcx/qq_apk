package com.tencent.mm.plugin.newtips;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.a.a;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.preference.PluginPreference;
import com.tencent.mm.protocal.protobuf.erx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.tools.w;
import java.lang.ref.WeakReference;

public final class NormalPluginNewTipPreference
  extends PluginPreference
  implements a
{
  private WeakReference<f> GvI = null;
  private Context context;
  protected View jac;
  private String path;
  
  public NormalPluginNewTipPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NormalPluginNewTipPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
  }
  
  private void notifyDataSetChanged()
  {
    AppMethodBeat.i(186664);
    if (this.GvI != null)
    {
      f localf = (f)this.GvI.get();
      if (localf != null) {
        localf.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(186664);
  }
  
  public final void a(k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(186645);
    g.a(this, paramk, paramBoolean);
    AppMethodBeat.o(186645);
  }
  
  public final boolean a(boolean paramBoolean, erx paramerx)
  {
    return false;
  }
  
  public final boolean b(boolean paramBoolean, erx paramerx)
  {
    return false;
  }
  
  public final boolean c(boolean paramBoolean, erx paramerx)
  {
    return false;
  }
  
  public final boolean d(boolean paramBoolean, erx paramerx)
  {
    AppMethodBeat.i(186663);
    Log.d("MicroMsg.NewTips.NormalPluginNewTipPreference", "showCounter() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      abe(0);
      String str = paramerx.num;
      if (paramerx.num > 99) {
        str = this.context.getString(b.e.tab_msg_tip_over);
      }
      fC(str, w.bj(this.mContext, paramerx.num));
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(186663);
      return true;
      this.GRJ = false;
      abe(8);
    }
  }
  
  public final boolean eQW()
  {
    return false;
  }
  
  public final String getPath()
  {
    return this.path;
  }
  
  public final View getRoot()
  {
    AppMethodBeat.i(186640);
    if (this.jac == null) {
      this.jac = new View(this.context);
    }
    View localView = this.jac;
    AppMethodBeat.o(186640);
    return localView;
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(186631);
    paramViewGroup = super.onCreateView(paramViewGroup);
    if (this.jac == null) {
      this.jac = paramViewGroup;
    }
    AppMethodBeat.o(186631);
    return paramViewGroup;
  }
  
  public final boolean tX(boolean paramBoolean)
  {
    AppMethodBeat.i(186648);
    paramBoolean = g.a(paramBoolean, this);
    AppMethodBeat.o(186648);
    return paramBoolean;
  }
  
  public final boolean tY(boolean paramBoolean)
  {
    AppMethodBeat.i(186651);
    Log.d("MicroMsg.NewTips.NormalPluginNewTipPreference", "showRedPoint() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.GRJ = true;
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(186651);
      return true;
      this.GRJ = false;
      abe(8);
    }
  }
  
  public final boolean tZ(boolean paramBoolean)
  {
    AppMethodBeat.i(186652);
    Log.d("MicroMsg.NewTips.NormalPluginNewTipPreference", "showNew() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.GRJ = false;
      abe(0);
      fC(this.context.getString(b.e.app_new), b.b.new_tips_bg);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(186652);
      return true;
      this.GRJ = false;
      abe(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.NormalPluginNewTipPreference
 * JD-Core Version:    0.7.0.1
 */