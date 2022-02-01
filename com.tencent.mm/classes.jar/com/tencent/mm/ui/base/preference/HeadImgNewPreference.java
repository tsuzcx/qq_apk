package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.f.a.a;

public final class HeadImgNewPreference
  extends Preference
{
  private View FpO;
  private String JMI;
  private boolean JMJ;
  private boolean JMK;
  private TextView JMM;
  private a JMN;
  private int height;
  private ImageView ka;
  public View.OnClickListener wme;
  
  public HeadImgNewPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeadImgNewPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164166);
    this.height = -1;
    this.JMK = false;
    this.JMN = null;
    setLayoutResource(2131494804);
    AppMethodBeat.o(164166);
  }
  
  public final void a(a parama)
  {
    this.JMN = parama;
  }
  
  public final void aXd(String paramString)
  {
    AppMethodBeat.i(164168);
    this.JMI = null;
    if (this.ka != null) {
      if (this.JMN != null) {
        this.JMN.b(paramString, this.ka);
      }
    }
    while (paramString == null)
    {
      this.JMK = false;
      AppMethodBeat.o(164168);
      return;
      if (this.JMJ)
      {
        a.d(this.ka, paramString);
      }
      else
      {
        a.c(this.ka, paramString);
        continue;
        this.JMI = paramString;
      }
    }
    this.JMK = true;
    AppMethodBeat.o(164168);
  }
  
  public final void d(View.OnClickListener paramOnClickListener)
  {
    this.wme = paramOnClickListener;
  }
  
  public final void fDB()
  {
    this.JMJ = true;
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(164169);
    super.onBindView(paramView);
    if (this.ka == null) {
      this.ka = ((ImageView)paramView.findViewById(2131300940));
    }
    if (this.JMM == null) {
      this.JMM = ((TextView)paramView.findViewById(2131302878));
    }
    if (this.FpO == null) {
      this.FpO = paramView.findViewById(2131302161);
    }
    if (this.wme != null) {
      this.FpO.setOnClickListener(this.wme);
    }
    if (this.JMI != null)
    {
      if (this.JMN != null)
      {
        this.JMN.b(this.JMI, this.ka);
        this.JMI = null;
      }
    }
    else
    {
      if (this.JMK) {
        break label212;
      }
      this.FpO.setVisibility(8);
      this.JMM.setVisibility(0);
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView.findViewById(2131302326);
      if (this.height != -1) {
        paramView.setMinimumHeight(this.height);
      }
      AppMethodBeat.o(164169);
      return;
      if (this.JMJ)
      {
        a.d(this.ka, this.JMI);
        break;
      }
      a.c(this.ka, this.JMI);
      break;
      label212:
      this.JMM.setVisibility(8);
      this.FpO.setVisibility(0);
      if (this.JMJ) {
        this.FpO.setBackground(this.mContext.getDrawable(2131233939));
      } else {
        this.FpO.setBackground(this.mContext.getDrawable(2131233937));
      }
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(164167);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131494822, localViewGroup);
    this.ka = ((ImageView)paramViewGroup.findViewById(2131300940));
    this.JMM = ((TextView)paramViewGroup.findViewById(2131302878));
    this.FpO = paramViewGroup.findViewById(2131302161);
    AppMethodBeat.o(164167);
    return paramViewGroup;
  }
  
  public static abstract interface a
  {
    public abstract void b(String paramString, ImageView paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.HeadImgNewPreference
 * JD-Core Version:    0.7.0.1
 */