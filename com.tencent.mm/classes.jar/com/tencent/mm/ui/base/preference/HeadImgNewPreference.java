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
  private View Dsq;
  private String HEd;
  private boolean HEe;
  private boolean HEf;
  private TextView HEh;
  private a HEi;
  private int height;
  private ImageView ig;
  public View.OnClickListener uWS;
  
  public HeadImgNewPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeadImgNewPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164166);
    this.height = -1;
    this.HEf = false;
    this.HEi = null;
    setLayoutResource(2131494804);
    AppMethodBeat.o(164166);
  }
  
  public final void a(a parama)
  {
    this.HEi = parama;
  }
  
  public final void aPM(String paramString)
  {
    AppMethodBeat.i(164168);
    this.HEd = null;
    if (this.ig != null) {
      if (this.HEi != null) {
        this.HEi.b(paramString, this.ig);
      }
    }
    while (paramString == null)
    {
      this.HEf = false;
      AppMethodBeat.o(164168);
      return;
      if (this.HEe)
      {
        a.d(this.ig, paramString);
      }
      else
      {
        a.c(this.ig, paramString);
        continue;
        this.HEd = paramString;
      }
    }
    this.HEf = true;
    AppMethodBeat.o(164168);
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
    AppMethodBeat.i(164169);
    super.onBindView(paramView);
    if (this.ig == null) {
      this.ig = ((ImageView)paramView.findViewById(2131300940));
    }
    if (this.HEh == null) {
      this.HEh = ((TextView)paramView.findViewById(2131302878));
    }
    if (this.Dsq == null) {
      this.Dsq = paramView.findViewById(2131302161);
    }
    if (this.uWS != null) {
      this.Dsq.setOnClickListener(this.uWS);
    }
    if (this.HEd != null)
    {
      if (this.HEi != null)
      {
        this.HEi.b(this.HEd, this.ig);
        this.HEd = null;
      }
    }
    else
    {
      if (this.HEf) {
        break label212;
      }
      this.Dsq.setVisibility(8);
      this.HEh.setVisibility(0);
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView.findViewById(2131302326);
      if (this.height != -1) {
        paramView.setMinimumHeight(this.height);
      }
      AppMethodBeat.o(164169);
      return;
      if (this.HEe)
      {
        a.d(this.ig, this.HEd);
        break;
      }
      a.c(this.ig, this.HEd);
      break;
      label212:
      this.HEh.setVisibility(8);
      this.Dsq.setVisibility(0);
      if (this.HEe) {
        this.Dsq.setBackground(this.mContext.getDrawable(2131233939));
      } else {
        this.Dsq.setBackground(this.mContext.getDrawable(2131233937));
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
    this.ig = ((ImageView)paramViewGroup.findViewById(2131300940));
    this.HEh = ((TextView)paramViewGroup.findViewById(2131302878));
    this.Dsq = paramViewGroup.findViewById(2131302161);
    AppMethodBeat.o(164167);
    return paramViewGroup;
  }
  
  public static abstract interface a
  {
    public abstract void b(String paramString, ImageView paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.HeadImgNewPreference
 * JD-Core Version:    0.7.0.1
 */