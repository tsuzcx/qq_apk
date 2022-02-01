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
import com.tencent.mm.protocal.protobuf.erx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.lang.ref.WeakReference;

public class NewTipPreference
  extends Preference
  implements a
{
  private WeakReference<f> GvI;
  private boolean GvJ;
  private Context context;
  private View jMT;
  private View jac;
  private View mView;
  private String path;
  
  public NewTipPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NewTipPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(184011);
    this.GvI = null;
    this.GvJ = false;
    this.context = paramContext;
    setLayoutResource(b.d.mm_preference);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.f.NormalIconNewTipPreference, paramInt, 0);
    this.path = paramContext.getString(b.f.NormalIconNewTipPreference_path);
    paramContext.recycle();
    Log.i("MicroMsg.NewTips.NewTipPreference", "NewTipPreference() path:%s", new Object[] { this.path });
    AppMethodBeat.o(184011);
  }
  
  private boolean vG(boolean paramBoolean)
  {
    AppMethodBeat.i(186550);
    if (this.jMT == null)
    {
      AppMethodBeat.o(186550);
      return false;
    }
    Log.i("MicroMsg.NewTips.NewTipPreference", "hash:%d, showRedDot() show:%s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.jMT.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(186550);
      return true;
      this.jMT.setVisibility(8);
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
    this.GvI = new WeakReference(paramf);
    AppMethodBeat.o(184018);
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
    return false;
  }
  
  public final boolean eQW()
  {
    return false;
  }
  
  public final boolean fiL()
  {
    AppMethodBeat.i(186552);
    if (this.jMT == null)
    {
      AppMethodBeat.o(186552);
      return false;
    }
    if (this.jMT.getVisibility() == 0)
    {
      AppMethodBeat.o(186552);
      return true;
    }
    AppMethodBeat.o(186552);
    return false;
  }
  
  public final String getPath()
  {
    return this.path;
  }
  
  public final View getRoot()
  {
    AppMethodBeat.i(184014);
    if (this.jac == null) {
      this.jac = new View(this.context);
    }
    View localView = this.jac;
    AppMethodBeat.o(184014);
    return localView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(184013);
    super.onBindView(paramView);
    this.jMT = paramView.findViewById(b.c.red_dot);
    vG(this.GvJ);
    i.aaq(g.aSW(this.path));
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
  
  public final boolean tX(boolean paramBoolean)
  {
    AppMethodBeat.i(184016);
    paramBoolean = g.a(paramBoolean, this);
    AppMethodBeat.o(184016);
    return paramBoolean;
  }
  
  public final boolean tY(boolean paramBoolean)
  {
    AppMethodBeat.i(184017);
    Log.i("MicroMsg.NewTips.NewTipPreference", "hash:%d, showRedPoint() show:%s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
    if (vG(paramBoolean))
    {
      this.GvJ = paramBoolean;
      if (this.GvI != null)
      {
        f localf = (f)this.GvI.get();
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
  
  public final boolean tZ(boolean paramBoolean)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.NewTipPreference
 * JD-Core Version:    0.7.0.1
 */