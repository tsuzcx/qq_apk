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
import com.tencent.mm.ui.g.a.a;

public final class HeadImgAndNamePreference
  extends Preference
{
  private View OXG;
  private LinearLayout OXH;
  private String OXI;
  private boolean OXJ;
  private boolean OXK;
  private a OXL;
  private ImageView gBZ;
  private int height;
  private TextView jBR;
  private ImageView qbE;
  private View.OnClickListener zHh;
  
  public HeadImgAndNamePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeadImgAndNamePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164162);
    this.height = -1;
    this.OXK = false;
    this.OXL = null;
    setLayoutResource(2131495538);
    AppMethodBeat.o(164162);
  }
  
  public final void a(a parama)
  {
    this.OXL = parama;
  }
  
  public final void bmf(String paramString)
  {
    AppMethodBeat.i(164164);
    this.OXI = null;
    if (this.qbE != null) {
      if (this.OXL != null) {
        this.OXL.b(paramString, this.qbE);
      }
    }
    while (paramString == null)
    {
      this.OXK = false;
      AppMethodBeat.o(164164);
      return;
      if (this.OXJ)
      {
        a.d(this.qbE, paramString);
      }
      else
      {
        a.c(this.qbE, paramString);
        continue;
        this.OXI = paramString;
      }
    }
    this.OXK = true;
    AppMethodBeat.o(164164);
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
    AppMethodBeat.i(164165);
    super.onBindView(paramView);
    if (this.qbE == null) {
      this.qbE = ((ImageView)paramView.findViewById(2131302570));
    }
    if (this.jBR == null) {
      this.jBR = ((TextView)paramView.findViewById(2131305451));
    }
    if (this.OXG == null) {
      this.OXG = paramView.findViewById(2131304503);
    }
    if (this.zHh != null) {
      this.OXG.setOnClickListener(this.zHh);
    }
    if (this.OXI != null)
    {
      if (this.OXL != null)
      {
        this.OXL.b(this.OXI, this.qbE);
        this.OXI = null;
      }
    }
    else
    {
      if (this.OXK) {
        break label212;
      }
      this.OXG.setVisibility(8);
      this.jBR.setVisibility(0);
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView.findViewById(2131304721);
      if (this.height != -1) {
        paramView.setMinimumHeight(this.height);
      }
      AppMethodBeat.o(164165);
      return;
      if (this.OXJ)
      {
        a.d(this.qbE, this.OXI);
        break;
      }
      a.c(this.qbE, this.OXI);
      break;
      label212:
      this.jBR.setVisibility(8);
      this.OXG.setVisibility(0);
      if (this.OXJ) {
        this.OXG.setBackground(this.mContext.getDrawable(2131234775));
      } else {
        this.OXG.setBackground(this.mContext.getDrawable(2131234773));
      }
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(164163);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131495557, localViewGroup);
    this.qbE = ((ImageView)paramViewGroup.findViewById(2131302570));
    this.OXG = paramViewGroup.findViewById(2131304504);
    this.OXH = ((LinearLayout)paramViewGroup.findViewById(2131299507));
    this.gBZ = ((ImageView)paramViewGroup.findViewById(2131302468));
    this.jBR = ((TextView)paramViewGroup.findViewById(2131299495));
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