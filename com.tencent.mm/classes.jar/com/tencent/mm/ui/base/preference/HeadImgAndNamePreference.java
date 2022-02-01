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
import com.tencent.mm.ui.i.a.a;

public final class HeadImgAndNamePreference
  extends Preference
{
  private View adYf;
  private LinearLayout adYg;
  private String adYh;
  private boolean adYi;
  private boolean adYj;
  private a adYk;
  private int height;
  private ImageView lPb;
  private TextView plr;
  private View.OnClickListener tyA;
  private ImageView wBY;
  
  public HeadImgAndNamePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeadImgAndNamePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164162);
    this.height = -1;
    this.adYj = false;
    this.adYk = null;
    setLayoutResource(a.h.mm_preference);
    AppMethodBeat.o(164162);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(164165);
    super.onBindView(paramView);
    if (this.wBY == null) {
      this.wBY = ((ImageView)paramView.findViewById(a.g.image_headimg));
    }
    if (this.plr == null) {
      this.plr = ((TextView)paramView.findViewById(a.g.no_header_icon_tip));
    }
    if (this.adYf == null) {
      this.adYf = paramView.findViewById(a.g.mask_header_icon);
    }
    if (this.tyA != null) {
      this.adYf.setOnClickListener(this.tyA);
    }
    if (this.adYh != null)
    {
      if (this.adYk == null)
      {
        if (this.adYi) {
          a.h(this.wBY, this.adYh);
        }
      }
      else {
        this.adYh = null;
      }
    }
    else
    {
      if (this.adYj) {
        break label196;
      }
      this.adYf.setVisibility(8);
      this.plr.setVisibility(0);
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView.findViewById(a.g.mm_preference_ll_id);
      if (this.height != -1) {
        paramView.setMinimumHeight(this.height);
      }
      AppMethodBeat.o(164165);
      return;
      a.g(this.wBY, this.adYh);
      break;
      label196:
      this.plr.setVisibility(8);
      this.adYf.setVisibility(0);
      if (this.adYi) {
        this.adYf.setBackground(this.mContext.getDrawable(a.f.self_qrcode_header_round_icon_click));
      } else {
        this.adYf.setBackground(this.mContext.getDrawable(a.f.self_qrcode_header_icon_click));
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
    this.wBY = ((ImageView)paramViewGroup.findViewById(a.g.image_headimg));
    this.adYf = paramViewGroup.findViewById(a.g.mask_header_img);
    this.adYg = ((LinearLayout)paramViewGroup.findViewById(a.g.desc_layout));
    this.lPb = ((ImageView)paramViewGroup.findViewById(a.g.icon));
    this.plr = ((TextView)paramViewGroup.findViewById(a.g.desc));
    AppMethodBeat.o(164163);
    return paramViewGroup;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.HeadImgAndNamePreference
 * JD-Core Version:    0.7.0.1
 */