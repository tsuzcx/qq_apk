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
import com.tencent.mm.protocal.protobuf.fng;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.tools.v;
import java.lang.ref.WeakReference;

public final class NormalPluginNewTipPreference
  extends PluginPreference
  implements a
{
  private WeakReference<f> MrH = null;
  private Context context;
  protected View lBX;
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
    AppMethodBeat.i(266261);
    if (this.MrH != null)
    {
      f localf = (f)this.MrH.get();
      if (localf != null) {
        localf.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(266261);
  }
  
  public final void a(k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(266271);
    g.a(this, paramk, paramBoolean);
    AppMethodBeat.o(266271);
  }
  
  public final boolean a(boolean paramBoolean, fng paramfng)
  {
    return false;
  }
  
  public final boolean b(boolean paramBoolean, fng paramfng)
  {
    return false;
  }
  
  public final boolean c(boolean paramBoolean, fng paramfng)
  {
    return false;
  }
  
  public final boolean d(boolean paramBoolean, fng paramfng)
  {
    AppMethodBeat.i(266293);
    Log.d("MicroMsg.NewTips.NormalPluginNewTipPreference", "showCounter() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      afx(0);
      String str = paramfng.num;
      if (paramfng.num > 99) {
        str = this.context.getString(b.f.tab_msg_tip_over);
      }
      gv(str, v.bC(this.mContext, paramfng.num));
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(266293);
      return true;
      this.MPn = false;
      afx(8);
    }
  }
  
  public final boolean fZD()
  {
    return false;
  }
  
  public final String getPath()
  {
    return this.path;
  }
  
  public final View getRoot()
  {
    AppMethodBeat.i(266270);
    if (this.lBX == null) {
      this.lBX = new View(this.context);
    }
    View localView = this.lBX;
    AppMethodBeat.o(266270);
    return localView;
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(266263);
    paramViewGroup = super.onCreateView(paramViewGroup);
    if (this.lBX == null) {
      this.lBX = paramViewGroup;
    }
    AppMethodBeat.o(266263);
    return paramViewGroup;
  }
  
  public final boolean ym(boolean paramBoolean)
  {
    AppMethodBeat.i(266274);
    paramBoolean = g.a(paramBoolean, this);
    AppMethodBeat.o(266274);
    return paramBoolean;
  }
  
  public final boolean yn(boolean paramBoolean)
  {
    AppMethodBeat.i(266278);
    Log.d("MicroMsg.NewTips.NormalPluginNewTipPreference", "showRedPoint() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.MPn = true;
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(266278);
      return true;
      this.MPn = false;
      afx(8);
    }
  }
  
  public final boolean yo(boolean paramBoolean)
  {
    AppMethodBeat.i(266285);
    Log.d("MicroMsg.NewTips.NormalPluginNewTipPreference", "showNew() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.MPn = false;
      afx(0);
      gv(this.context.getString(b.f.app_new), b.b.new_tips_bg);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(266285);
      return true;
      this.MPn = false;
      afx(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.NormalPluginNewTipPreference
 * JD-Core Version:    0.7.0.1
 */