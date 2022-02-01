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
  private View JMG;
  private LinearLayout JMH;
  private String JMI;
  private boolean JMJ;
  private boolean JMK;
  private a JML;
  private ImageView fWT;
  private int height;
  private TextView iFO;
  private ImageView oNQ;
  private View.OnClickListener wme;
  
  public HeadImgAndNamePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeadImgAndNamePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164162);
    this.height = -1;
    this.JMK = false;
    this.JML = null;
    setLayoutResource(2131494804);
    AppMethodBeat.o(164162);
  }
  
  public final void a(a parama)
  {
    this.JML = parama;
  }
  
  public final void aXd(String paramString)
  {
    AppMethodBeat.i(164164);
    this.JMI = null;
    if (this.oNQ != null) {
      if (this.JML != null) {
        this.JML.b(paramString, this.oNQ);
      }
    }
    while (paramString == null)
    {
      this.JMK = false;
      AppMethodBeat.o(164164);
      return;
      if (this.JMJ)
      {
        a.d(this.oNQ, paramString);
      }
      else
      {
        a.c(this.oNQ, paramString);
        continue;
        this.JMI = paramString;
      }
    }
    this.JMK = true;
    AppMethodBeat.o(164164);
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
    AppMethodBeat.i(164165);
    super.onBindView(paramView);
    if (this.oNQ == null) {
      this.oNQ = ((ImageView)paramView.findViewById(2131300940));
    }
    if (this.iFO == null) {
      this.iFO = ((TextView)paramView.findViewById(2131302878));
    }
    if (this.JMG == null) {
      this.JMG = paramView.findViewById(2131302161);
    }
    if (this.wme != null) {
      this.JMG.setOnClickListener(this.wme);
    }
    if (this.JMI != null)
    {
      if (this.JML != null)
      {
        this.JML.b(this.JMI, this.oNQ);
        this.JMI = null;
      }
    }
    else
    {
      if (this.JMK) {
        break label212;
      }
      this.JMG.setVisibility(8);
      this.iFO.setVisibility(0);
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView.findViewById(2131302326);
      if (this.height != -1) {
        paramView.setMinimumHeight(this.height);
      }
      AppMethodBeat.o(164165);
      return;
      if (this.JMJ)
      {
        a.d(this.oNQ, this.JMI);
        break;
      }
      a.c(this.oNQ, this.JMI);
      break;
      label212:
      this.iFO.setVisibility(8);
      this.JMG.setVisibility(0);
      if (this.JMJ) {
        this.JMG.setBackground(this.mContext.getDrawable(2131233939));
      } else {
        this.JMG.setBackground(this.mContext.getDrawable(2131233937));
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
    this.oNQ = ((ImageView)paramViewGroup.findViewById(2131300940));
    this.JMG = paramViewGroup.findViewById(2131302162);
    this.JMH = ((LinearLayout)paramViewGroup.findViewById(2131299005));
    this.fWT = ((ImageView)paramViewGroup.findViewById(2131300874));
    this.iFO = ((TextView)paramViewGroup.findViewById(2131298996));
    AppMethodBeat.o(164163);
    return paramViewGroup;
  }
  
  public static abstract interface a
  {
    public abstract void b(String paramString, ImageView paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.HeadImgAndNamePreference
 * JD-Core Version:    0.7.0.1
 */