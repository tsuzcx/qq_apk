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
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ui.h.a.a;

public final class HeadImgNewPreference
  extends Preference
{
  public View.OnClickListener Fms;
  private View Rhq;
  private String WqS;
  private boolean WqT;
  private boolean WqU;
  private TextView WqW;
  private a WqX;
  private ImageView bwJ;
  private int height;
  
  public HeadImgNewPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeadImgNewPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164166);
    this.height = -1;
    this.WqU = false;
    this.WqX = null;
    setLayoutResource(a.h.mm_preference);
    AppMethodBeat.o(164166);
  }
  
  public final void a(a parama)
  {
    this.WqX = parama;
  }
  
  public final void byF(String paramString)
  {
    AppMethodBeat.i(164168);
    this.WqS = null;
    if (this.bwJ != null) {
      if (this.WqX != null) {
        this.WqX.b(paramString, this.bwJ);
      }
    }
    while (paramString == null)
    {
      this.WqU = false;
      AppMethodBeat.o(164168);
      return;
      if (this.WqT)
      {
        a.d(this.bwJ, paramString);
      }
      else
      {
        a.c(this.bwJ, paramString);
        continue;
        this.WqS = paramString;
      }
    }
    this.WqU = true;
    AppMethodBeat.o(164168);
  }
  
  public final void hKG()
  {
    this.WqT = true;
  }
  
  public final void j(View.OnClickListener paramOnClickListener)
  {
    this.Fms = paramOnClickListener;
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(164169);
    super.onBindView(paramView);
    if (this.bwJ == null) {
      this.bwJ = ((ImageView)paramView.findViewById(a.g.image_headimg));
    }
    if (this.WqW == null) {
      this.WqW = ((TextView)paramView.findViewById(a.g.no_header_icon_tip));
    }
    if (this.Rhq == null) {
      this.Rhq = paramView.findViewById(a.g.mask_header_icon);
    }
    if (this.Fms != null) {
      this.Rhq.setOnClickListener(this.Fms);
    }
    if (this.WqS != null)
    {
      if (this.WqX != null)
      {
        this.WqX.b(this.WqS, this.bwJ);
        this.WqS = null;
      }
    }
    else
    {
      if (this.WqU) {
        break label216;
      }
      this.Rhq.setVisibility(8);
      this.WqW.setVisibility(0);
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView.findViewById(a.g.mm_preference_ll_id);
      if (this.height != -1) {
        paramView.setMinimumHeight(this.height);
      }
      AppMethodBeat.o(164169);
      return;
      if (this.WqT)
      {
        a.d(this.bwJ, this.WqS);
        break;
      }
      a.c(this.bwJ, this.WqS);
      break;
      label216:
      this.WqW.setVisibility(8);
      this.Rhq.setVisibility(0);
      if (this.WqT) {
        this.Rhq.setBackground(this.mContext.getDrawable(a.f.self_qrcode_header_round_icon_click));
      } else {
        this.Rhq.setBackground(this.mContext.getDrawable(a.f.self_qrcode_header_icon_click));
      }
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(164167);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.g.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, a.h.mm_preference_content_avatar, localViewGroup);
    this.bwJ = ((ImageView)paramViewGroup.findViewById(a.g.image_headimg));
    this.WqW = ((TextView)paramViewGroup.findViewById(a.g.no_header_icon_tip));
    this.Rhq = paramViewGroup.findViewById(a.g.mask_header_icon);
    AppMethodBeat.o(164167);
    return paramViewGroup;
  }
  
  public static abstract interface a
  {
    public abstract void b(String paramString, ImageView paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.HeadImgNewPreference
 * JD-Core Version:    0.7.0.1
 */