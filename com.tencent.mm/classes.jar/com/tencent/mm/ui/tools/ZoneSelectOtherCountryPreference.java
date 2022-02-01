package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public class ZoneSelectOtherCountryPreference
  extends Preference
{
  a XVH;
  String text;
  
  public ZoneSelectOtherCountryPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ZoneSelectOtherCountryPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ZoneSelectOtherCountryPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(39217);
    setLayoutResource(R.i.mm_preference);
    AppMethodBeat.o(39217);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(39219);
    super.onBindView(paramView);
    TextView localTextView = (TextView)paramView.findViewById(R.h.zonename);
    if (!Util.isNullOrNil(this.text)) {
      localTextView.setText(this.text);
    }
    paramView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39216);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/ui/tools/ZoneSelectOtherCountryPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (ZoneSelectOtherCountryPreference.a(ZoneSelectOtherCountryPreference.this) != null) {
          ZoneSelectOtherCountryPreference.a(ZoneSelectOtherCountryPreference.this).onClick();
        }
        a.a(this, "com/tencent/mm/ui/tools/ZoneSelectOtherCountryPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(39216);
      }
    });
    AppMethodBeat.o(39219);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39218);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.eja, localViewGroup);
    AppMethodBeat.o(39218);
    return paramViewGroup;
  }
  
  public static abstract interface a
  {
    public abstract void onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ZoneSelectOtherCountryPreference
 * JD-Core Version:    0.7.0.1
 */