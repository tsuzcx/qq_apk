package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Util;

public class IconMsgPreference
  extends Preference
{
  private String GRG;
  private int GRH;
  private int GRI;
  private int WqY;
  private int WqZ;
  private int Wra;
  private ImageView Wrb;
  private ViewGroup Wrc;
  private TextView Wrd;
  private String Wre;
  private Context context;
  private Drawable drawable;
  private int height;
  
  public IconMsgPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconMsgPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142540);
    this.GRG = "";
    this.GRH = -1;
    this.GRI = 8;
    this.WqY = 8;
    this.WqZ = 0;
    this.Wra = 8;
    this.Wrb = null;
    this.Wrc = null;
    this.height = -1;
    this.Wre = "";
    this.context = paramContext;
    setLayoutResource(a.h.mm_preference);
    AppMethodBeat.o(142540);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142542);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(a.g.image_iv);
    if (localObject != null)
    {
      if (this.drawable == null) {
        break label222;
      }
      ((ImageView)localObject).setImageDrawable(this.drawable);
      ((ImageView)localObject).setVisibility(0);
    }
    for (;;)
    {
      localObject = (LinearLayout)paramView.findViewById(a.g.mm_preference_ll_id);
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      localObject = (TextView)paramView.findViewById(a.g.text_tv_one);
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(this.GRI);
        ((TextView)localObject).setText(this.GRG);
        if (this.GRH != -1) {
          ((TextView)localObject).setBackgroundDrawable(a.m(this.context, this.GRH));
        }
      }
      this.Wrb = ((ImageView)paramView.findViewById(a.g.text_prospect));
      this.Wrb.setVisibility(this.WqY);
      this.Wrc = ((ViewGroup)paramView.findViewById(a.g.right_rl));
      this.Wrc.setVisibility(this.WqZ);
      this.Wrd = ((TextView)paramView.findViewById(16908310));
      paramView = (TextView)paramView.findViewById(a.g.text_tv_right);
      if (!Util.isNullOrNil(this.Wre)) {
        break;
      }
      paramView.setVisibility(8);
      AppMethodBeat.o(142542);
      return;
      label222:
      if (cMV() != 0)
      {
        ((ImageView)localObject).setImageResource(cMV());
        ((ImageView)localObject).setVisibility(0);
      }
      else
      {
        ((ImageView)localObject).setVisibility(8);
      }
    }
    paramView.setVisibility(0);
    paramView.setText(this.Wre);
    AppMethodBeat.o(142542);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142541);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.g.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, a.h.mm_preference_icon_msg, localViewGroup);
    paramViewGroup.setMinimumHeight(paramViewGroup.getResources().getDimensionPixelSize(a.e.SmallListHeight));
    AppMethodBeat.o(142541);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconMsgPreference
 * JD-Core Version:    0.7.0.1
 */