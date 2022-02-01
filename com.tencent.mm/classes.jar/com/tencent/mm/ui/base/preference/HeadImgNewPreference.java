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
import com.tencent.mm.ui.g.a.a;

public final class HeadImgNewPreference
  extends Preference
{
  private View KgF;
  private String OXI;
  private boolean OXJ;
  private boolean OXK;
  private TextView OXM;
  private a OXN;
  private int height;
  private ImageView kc;
  public View.OnClickListener zHh;
  
  public HeadImgNewPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeadImgNewPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164166);
    this.height = -1;
    this.OXK = false;
    this.OXN = null;
    setLayoutResource(2131495538);
    AppMethodBeat.o(164166);
  }
  
  public final void a(a parama)
  {
    this.OXN = parama;
  }
  
  public final void bmf(String paramString)
  {
    AppMethodBeat.i(164168);
    this.OXI = null;
    if (this.kc != null) {
      if (this.OXN != null) {
        this.OXN.b(paramString, this.kc);
      }
    }
    while (paramString == null)
    {
      this.OXK = false;
      AppMethodBeat.o(164168);
      return;
      if (this.OXJ)
      {
        a.d(this.kc, paramString);
      }
      else
      {
        a.c(this.kc, paramString);
        continue;
        this.OXI = paramString;
      }
    }
    this.OXK = true;
    AppMethodBeat.o(164168);
  }
  
  public final void gLE()
  {
    this.OXJ = true;
  }
  
  public final void h(View.OnClickListener paramOnClickListener)
  {
    this.zHh = paramOnClickListener;
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(164169);
    super.onBindView(paramView);
    if (this.kc == null) {
      this.kc = ((ImageView)paramView.findViewById(2131302570));
    }
    if (this.OXM == null) {
      this.OXM = ((TextView)paramView.findViewById(2131305451));
    }
    if (this.KgF == null) {
      this.KgF = paramView.findViewById(2131304503);
    }
    if (this.zHh != null) {
      this.KgF.setOnClickListener(this.zHh);
    }
    if (this.OXI != null)
    {
      if (this.OXN != null)
      {
        this.OXN.b(this.OXI, this.kc);
        this.OXI = null;
      }
    }
    else
    {
      if (this.OXK) {
        break label212;
      }
      this.KgF.setVisibility(8);
      this.OXM.setVisibility(0);
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView.findViewById(2131304721);
      if (this.height != -1) {
        paramView.setMinimumHeight(this.height);
      }
      AppMethodBeat.o(164169);
      return;
      if (this.OXJ)
      {
        a.d(this.kc, this.OXI);
        break;
      }
      a.c(this.kc, this.OXI);
      break;
      label212:
      this.OXM.setVisibility(8);
      this.KgF.setVisibility(0);
      if (this.OXJ) {
        this.KgF.setBackground(this.mContext.getDrawable(2131234775));
      } else {
        this.KgF.setBackground(this.mContext.getDrawable(2131234773));
      }
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(164167);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131495556, localViewGroup);
    this.kc = ((ImageView)paramViewGroup.findViewById(2131302570));
    this.OXM = ((TextView)paramViewGroup.findViewById(2131305451));
    this.KgF = paramViewGroup.findViewById(2131304503);
    AppMethodBeat.o(164167);
    return paramViewGroup;
  }
  
  public static abstract interface a
  {
    public abstract void b(String paramString, ImageView paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.HeadImgNewPreference
 * JD-Core Version:    0.7.0.1
 */