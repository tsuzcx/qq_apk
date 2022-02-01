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
  private View Gem;
  private LinearLayout Gen;
  private String Geo;
  private boolean Gep;
  private boolean Geq;
  private a Ger;
  private ImageView fxT;
  private TextView hJe;
  private int height;
  private ImageView nAV;
  private View.OnClickListener tOp;
  
  public HeadImgAndNamePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeadImgAndNamePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164162);
    this.height = -1;
    this.Geq = false;
    this.Ger = null;
    setLayoutResource(2131494804);
    AppMethodBeat.o(164162);
  }
  
  public final void a(a parama)
  {
    this.Ger = parama;
  }
  
  public final void aKj(String paramString)
  {
    AppMethodBeat.i(164164);
    this.Geo = null;
    if (this.nAV != null) {
      if (this.Ger != null) {
        this.Ger.b(paramString, this.nAV);
      }
    }
    while (paramString == null)
    {
      this.Geq = false;
      AppMethodBeat.o(164164);
      return;
      if (this.Gep)
      {
        a.d(this.nAV, paramString);
      }
      else
      {
        a.c(this.nAV, paramString);
        continue;
        this.Geo = paramString;
      }
    }
    this.Geq = true;
    AppMethodBeat.o(164164);
  }
  
  public final void eTy()
  {
    this.Gep = true;
  }
  
  public final void f(View.OnClickListener paramOnClickListener)
  {
    this.tOp = paramOnClickListener;
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(164165);
    super.onBindView(paramView);
    if (this.nAV == null) {
      this.nAV = ((ImageView)paramView.findViewById(2131300940));
    }
    if (this.hJe == null) {
      this.hJe = ((TextView)paramView.findViewById(2131302878));
    }
    if (this.Gem == null) {
      this.Gem = paramView.findViewById(2131302161);
    }
    if (this.tOp != null) {
      this.Gem.setOnClickListener(this.tOp);
    }
    if (this.Geo != null)
    {
      if (this.Ger != null)
      {
        this.Ger.b(this.Geo, this.nAV);
        this.Geo = null;
      }
    }
    else
    {
      if (this.Geq) {
        break label212;
      }
      this.Gem.setVisibility(8);
      this.hJe.setVisibility(0);
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView.findViewById(2131302326);
      if (this.height != -1) {
        paramView.setMinimumHeight(this.height);
      }
      AppMethodBeat.o(164165);
      return;
      if (this.Gep)
      {
        a.d(this.nAV, this.Geo);
        break;
      }
      a.c(this.nAV, this.Geo);
      break;
      label212:
      this.hJe.setVisibility(8);
      this.Gem.setVisibility(0);
      if (this.Gep) {
        this.Gem.setBackground(this.mContext.getDrawable(2131233939));
      } else {
        this.Gem.setBackground(this.mContext.getDrawable(2131233937));
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
    this.nAV = ((ImageView)paramViewGroup.findViewById(2131300940));
    this.Gem = paramViewGroup.findViewById(2131302162);
    this.Gen = ((LinearLayout)paramViewGroup.findViewById(2131299005));
    this.fxT = ((ImageView)paramViewGroup.findViewById(2131300874));
    this.hJe = ((TextView)paramViewGroup.findViewById(2131298996));
    AppMethodBeat.o(164163);
    return paramViewGroup;
  }
  
  public static abstract interface a
  {
    public abstract void b(String paramString, ImageView paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.HeadImgAndNamePreference
 * JD-Core Version:    0.7.0.1
 */