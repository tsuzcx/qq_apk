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
import com.tencent.mm.protocal.protobuf.dnc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.lang.ref.WeakReference;

public class NewTipPreference
  extends Preference
  implements a
{
  private Context context;
  private View fOB;
  private View goo;
  private View mView;
  private String path;
  private WeakReference<f> wrM;
  
  public NewTipPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NewTipPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(184011);
    this.wrM = null;
    this.context = paramContext;
    setLayoutResource(2131494804);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.a.NormalIconNewTipPreference, paramInt, 0);
    this.path = paramContext.getString(0);
    paramContext.recycle();
    ad.i("MicroMsg.NewTips.NewTipPreference", "NewTipPreference() path:%s", new Object[] { this.path });
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
    this.wrM = new WeakReference(paramf);
    AppMethodBeat.o(184018);
  }
  
  public final boolean a(boolean paramBoolean, dnc paramdnc)
  {
    return false;
  }
  
  public final boolean b(boolean paramBoolean, dnc paramdnc)
  {
    return false;
  }
  
  public final boolean c(boolean paramBoolean, dnc paramdnc)
  {
    return false;
  }
  
  public final boolean d(boolean paramBoolean, dnc paramdnc)
  {
    return false;
  }
  
  public final boolean dkD()
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
    if (this.fOB == null) {
      this.fOB = new View(this.context);
    }
    View localView = this.fOB;
    AppMethodBeat.o(184014);
    return localView;
  }
  
  public final boolean ol(boolean paramBoolean)
  {
    AppMethodBeat.i(184016);
    paramBoolean = g.a(paramBoolean, this);
    AppMethodBeat.o(184016);
    return paramBoolean;
  }
  
  public final boolean om(boolean paramBoolean)
  {
    AppMethodBeat.i(184017);
    ad.d("MicroMsg.NewTips.NewTipPreference", "showRedPoint() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    int i;
    if (this.goo == null)
    {
      i = 0;
      if (i != 0)
      {
        if (this.wrM != null)
        {
          f localf = (f)this.wrM.get();
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
        this.goo.setVisibility(0);
      }
      for (;;)
      {
        i = 1;
        break;
        this.goo.setVisibility(8);
      }
    }
    AppMethodBeat.o(184017);
    return false;
  }
  
  public final boolean on(boolean paramBoolean)
  {
    return false;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(184013);
    super.onBindView(paramView);
    this.goo = paramView.findViewById(2131303917);
    i.LR(g.atf(this.path));
    AppMethodBeat.o(184013);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(184012);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131494876, localViewGroup);
    this.mView = paramViewGroup;
    paramViewGroup = this.mView;
    AppMethodBeat.o(184012);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.NewTipPreference
 * JD-Core Version:    0.7.0.1
 */