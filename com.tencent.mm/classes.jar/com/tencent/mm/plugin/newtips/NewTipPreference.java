package com.tencent.mm.plugin.newtips;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.a.a;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.fng;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.lang.ref.WeakReference;

public class NewTipPreference
  extends Preference
  implements a
{
  private WeakReference<f> MrH;
  private boolean MrI;
  private Context context;
  private View lBX;
  private View mView;
  public View mlS;
  private String path;
  
  public NewTipPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NewTipPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(184011);
    this.MrH = null;
    this.MrI = false;
    this.context = paramContext;
    setLayoutResource(b.d.mm_preference);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.g.NormalIconNewTipPreference, paramInt, 0);
    this.path = paramContext.getString(b.g.NormalIconNewTipPreference_path);
    paramContext.recycle();
    Log.i("MicroMsg.NewTips.NewTipPreference", "NewTipPreference() path:%s", new Object[] { this.path });
    AppMethodBeat.o(184011);
  }
  
  private boolean Ac(boolean paramBoolean)
  {
    AppMethodBeat.i(266281);
    if (this.mlS == null)
    {
      AppMethodBeat.o(266281);
      return false;
    }
    Log.i("MicroMsg.NewTips.NewTipPreference", "hash:%d, showRedDot() show:%s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.mlS.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(266281);
      return true;
      this.mlS.setVisibility(8);
    }
  }
  
  public final void a(k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(184015);
    g.a(this, paramk, paramBoolean);
    AppMethodBeat.o(184015);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(184018);
    this.MrH = new WeakReference(paramf);
    AppMethodBeat.o(184018);
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
    return false;
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
    AppMethodBeat.i(184014);
    if (this.lBX == null) {
      this.lBX = new View(this.context);
    }
    View localView = this.lBX;
    AppMethodBeat.o(184014);
    return localView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(184013);
    super.onBindView(paramView);
    this.mlS = paramView.findViewById(b.c.red_dot);
    Ac(this.MrI);
    i.aeJ(g.aPV(this.path));
    AppMethodBeat.o(184013);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(184012);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(b.c.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, b.d.mm_preference_new_tips, localViewGroup);
    this.mView = paramViewGroup;
    paramViewGroup = this.mView;
    AppMethodBeat.o(184012);
    return paramViewGroup;
  }
  
  public final boolean ym(boolean paramBoolean)
  {
    AppMethodBeat.i(184016);
    paramBoolean = g.a(paramBoolean, this);
    AppMethodBeat.o(184016);
    return paramBoolean;
  }
  
  public final boolean yn(boolean paramBoolean)
  {
    AppMethodBeat.i(184017);
    Log.i("MicroMsg.NewTips.NewTipPreference", "hash:%d, showRedPoint() show:%s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
    if (Ac(paramBoolean))
    {
      this.MrI = paramBoolean;
      if (this.MrH != null)
      {
        f localf = (f)this.MrH.get();
        if (localf != null) {
          localf.notifyDataSetChanged();
        }
      }
      AppMethodBeat.o(184017);
      return true;
    }
    AppMethodBeat.o(184017);
    return false;
  }
  
  public final boolean yo(boolean paramBoolean)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.NewTipPreference
 * JD-Core Version:    0.7.0.1
 */