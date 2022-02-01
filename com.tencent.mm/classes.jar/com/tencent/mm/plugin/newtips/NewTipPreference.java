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
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.lang.ref.WeakReference;

public class NewTipPreference
  extends Preference
  implements a
{
  private WeakReference<f> ACF;
  private Context context;
  private View gvQ;
  private View hbJ;
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
    this.ACF = null;
    this.context = paramContext;
    setLayoutResource(2131495538);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.a.NormalIconNewTipPreference, paramInt, 0);
    this.path = paramContext.getString(0);
    paramContext.recycle();
    Log.i("MicroMsg.NewTips.NewTipPreference", "NewTipPreference() path:%s", new Object[] { this.path });
    AppMethodBeat.o(184011);
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
    this.ACF = new WeakReference(paramf);
    AppMethodBeat.o(184018);
  }
  
  public final boolean a(boolean paramBoolean, ehv paramehv)
  {
    return false;
  }
  
  public final boolean b(boolean paramBoolean, ehv paramehv)
  {
    return false;
  }
  
  public final boolean c(boolean paramBoolean, ehv paramehv)
  {
    return false;
  }
  
  public final boolean d(boolean paramBoolean, ehv paramehv)
  {
    return false;
  }
  
  public final boolean ehp()
  {
    return false;
  }
  
  public final boolean exi()
  {
    AppMethodBeat.i(188555);
    if (this.hbJ == null)
    {
      AppMethodBeat.o(188555);
      return false;
    }
    if (this.hbJ.getVisibility() == 0)
    {
      AppMethodBeat.o(188555);
      return true;
    }
    AppMethodBeat.o(188555);
    return false;
  }
  
  public final String getPath()
  {
    return this.path;
  }
  
  public final View getRoot()
  {
    AppMethodBeat.i(184014);
    if (this.gvQ == null) {
      this.gvQ = new View(this.context);
    }
    View localView = this.gvQ;
    AppMethodBeat.o(184014);
    return localView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(184013);
    super.onBindView(paramView);
    this.hbJ = paramView.findViewById(2131306759);
    i.TD(g.aIB(this.path));
    AppMethodBeat.o(184013);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(184012);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131495613, localViewGroup);
    this.mView = paramViewGroup;
    paramViewGroup = this.mView;
    AppMethodBeat.o(184012);
    return paramViewGroup;
  }
  
  public final boolean qV(boolean paramBoolean)
  {
    AppMethodBeat.i(184016);
    paramBoolean = g.a(paramBoolean, this);
    AppMethodBeat.o(184016);
    return paramBoolean;
  }
  
  public final boolean qW(boolean paramBoolean)
  {
    AppMethodBeat.i(184017);
    Log.d("MicroMsg.NewTips.NewTipPreference", "showRedPoint() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    int i;
    if (this.hbJ == null)
    {
      i = 0;
      if (i != 0)
      {
        if (this.ACF != null)
        {
          f localf = (f)this.ACF.get();
          if (localf != null) {
            localf.notifyDataSetChanged();
          }
        }
        AppMethodBeat.o(184017);
        return true;
      }
    }
    else
    {
      if (paramBoolean) {
        this.hbJ.setVisibility(0);
      }
      for (;;)
      {
        i = 1;
        break;
        this.hbJ.setVisibility(8);
      }
    }
    AppMethodBeat.o(184017);
    return false;
  }
  
  public final boolean qX(boolean paramBoolean)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.NewTipPreference
 * JD-Core Version:    0.7.0.1
 */