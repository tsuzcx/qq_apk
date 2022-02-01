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
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ui.h.a.a;

public final class HeadImgAndNamePreference
  extends Preference
{
  private View.OnClickListener Fms;
  private View WqQ;
  private LinearLayout WqR;
  private String WqS;
  private boolean WqT;
  private boolean WqU;
  private a WqV;
  private int height;
  private ImageView jmf;
  private TextView mrM;
  private ImageView txC;
  
  public HeadImgAndNamePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeadImgAndNamePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164162);
    this.height = -1;
    this.WqU = false;
    this.WqV = null;
    setLayoutResource(a.h.mm_preference);
    AppMethodBeat.o(164162);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(164165);
    super.onBindView(paramView);
    if (this.txC == null) {
      this.txC = ((ImageView)paramView.findViewById(a.g.image_headimg));
    }
    if (this.mrM == null) {
      this.mrM = ((TextView)paramView.findViewById(a.g.no_header_icon_tip));
    }
    if (this.WqQ == null) {
      this.WqQ = paramView.findViewById(a.g.mask_header_icon);
    }
    if (this.Fms != null) {
      this.WqQ.setOnClickListener(this.Fms);
    }
    if (this.WqS != null)
    {
      if (this.WqV == null)
      {
        if (this.WqT) {
          a.d(this.txC, this.WqS);
        }
      }
      else {
        this.WqS = null;
      }
    }
    else
    {
      if (this.WqU) {
        break label196;
      }
      this.WqQ.setVisibility(8);
      this.mrM.setVisibility(0);
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView.findViewById(a.g.mm_preference_ll_id);
      if (this.height != -1) {
        paramView.setMinimumHeight(this.height);
      }
      AppMethodBeat.o(164165);
      return;
      a.c(this.txC, this.WqS);
      break;
      label196:
      this.mrM.setVisibility(8);
      this.WqQ.setVisibility(0);
      if (this.WqT) {
        this.WqQ.setBackground(this.mContext.getDrawable(a.f.self_qrcode_header_round_icon_click));
      } else {
        this.WqQ.setBackground(this.mContext.getDrawable(a.f.self_qrcode_header_icon_click));
      }
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(164163);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.g.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, a.h.mm_preference_content_avatar_name, localViewGroup);
    this.txC = ((ImageView)paramViewGroup.findViewById(a.g.image_headimg));
    this.WqQ = paramViewGroup.findViewById(a.g.mask_header_img);
    this.WqR = ((LinearLayout)paramViewGroup.findViewById(a.g.desc_layout));
    this.jmf = ((ImageView)paramViewGroup.findViewById(a.g.icon));
    this.mrM = ((TextView)paramViewGroup.findViewById(a.g.desc));
    AppMethodBeat.o(164163);
    return paramViewGroup;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.HeadImgAndNamePreference
 * JD-Core Version:    0.7.0.1
 */