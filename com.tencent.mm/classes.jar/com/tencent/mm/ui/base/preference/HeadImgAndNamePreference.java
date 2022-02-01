package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.f.a.a;

public final class HeadImgAndNamePreference
  extends Preference
{
  private View HEb;
  private LinearLayout HEc;
  private String HEd;
  private boolean HEe;
  private boolean HEf;
  private a HEg;
  private ImageView fBA;
  private int height;
  private TextView ijE;
  private ImageView odV;
  private View.OnClickListener uWS;
  
  public HeadImgAndNamePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeadImgAndNamePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164162);
    this.height = -1;
    this.HEf = false;
    this.HEg = null;
    setLayoutResource(2131494804);
    AppMethodBeat.o(164162);
  }
  
  public final void a(a parama)
  {
    this.HEg = parama;
  }
  
  public final void aPM(String paramString)
  {
    AppMethodBeat.i(164164);
    this.HEd = null;
    if (this.odV != null) {
      if (this.HEg != null) {
        this.HEg.b(paramString, this.odV);
      }
    }
    while (paramString == null)
    {
      this.HEf = false;
      AppMethodBeat.o(164164);
      return;
      if (this.HEe)
      {
        a.d(this.odV, paramString);
      }
      else
      {
        a.c(this.odV, paramString);
        continue;
        this.HEd = paramString;
      }
    }
    this.HEf = true;
    AppMethodBeat.o(164164);
  }
  
  public final void f(View.OnClickListener paramOnClickListener)
  {
    this.uWS = paramOnClickListener;
  }
  
  public final void fjk()
  {
    this.HEe = true;
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(164165);
    super.onBindView(paramView);
    if (this.odV == null) {
      this.odV = ((ImageView)paramView.findViewById(2131300940));
    }
    if (this.ijE == null) {
      this.ijE = ((TextView)paramView.findViewById(2131302878));
    }
    if (this.HEb == null) {
      this.HEb = paramView.findViewById(2131302161);
    }
    if (this.uWS != null) {
      this.HEb.setOnClickListener(this.uWS);
    }
    if (this.HEd != null)
    {
      if (this.HEg != null)
      {
        this.HEg.b(this.HEd, this.odV);
        this.HEd = null;
      }
    }
    else
    {
      if (this.HEf) {
        break label212;
      }
      this.HEb.setVisibility(8);
      this.ijE.setVisibility(0);
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView.findViewById(2131302326);
      if (this.height != -1) {
        paramView.setMinimumHeight(this.height);
      }
      AppMethodBeat.o(164165);
      return;
      if (this.HEe)
      {
        a.d(this.odV, this.HEd);
        break;
      }
      a.c(this.odV, this.HEd);
      break;
      label212:
      this.ijE.setVisibility(8);
      this.HEb.setVisibility(0);
      if (this.HEe) {
        this.HEb.setBackground(this.mContext.getDrawable(2131233939));
      } else {
        this.HEb.setBackground(this.mContext.getDrawable(2131233937));
      }
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(164163);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131494823, localViewGroup);
    this.odV = ((ImageView)paramViewGroup.findViewById(2131300940));
    this.HEb = paramViewGroup.findViewById(2131302162);
    this.HEc = ((LinearLayout)paramViewGroup.findViewById(2131299005));
    this.fBA = ((ImageView)paramViewGroup.findViewById(2131300874));
    this.ijE = ((TextView)paramViewGroup.findViewById(2131298996));
    AppMethodBeat.o(164163);
    return paramViewGroup;
  }
  
  public static abstract interface a
  {
    public abstract void b(String paramString, ImageView paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.HeadImgAndNamePreference
 * JD-Core Version:    0.7.0.1
 */