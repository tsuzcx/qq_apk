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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Util;

public class IconMsgPreference
  extends Preference
{
  private String Bgn;
  private int CZk;
  private int CZl;
  private int OXO;
  private int OXP;
  private int OXQ;
  private ImageView OXR;
  private ViewGroup OXS;
  private TextView OXT;
  private String OXU;
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
    this.Bgn = "";
    this.CZk = -1;
    this.CZl = 8;
    this.OXO = 8;
    this.OXP = 0;
    this.OXQ = 8;
    this.OXR = null;
    this.OXS = null;
    this.height = -1;
    this.OXU = "";
    this.context = paramContext;
    setLayoutResource(2131495538);
    AppMethodBeat.o(142540);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142542);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(2131302573);
    if (localObject != null)
    {
      if (this.drawable == null) {
        break label216;
      }
      ((ImageView)localObject).setImageDrawable(this.drawable);
      ((ImageView)localObject).setVisibility(0);
    }
    for (;;)
    {
      localObject = (LinearLayout)paramView.findViewById(2131304721);
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      localObject = (TextView)paramView.findViewById(2131309014);
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(this.CZl);
        ((TextView)localObject).setText(this.Bgn);
        if (this.CZk != -1) {
          ((TextView)localObject).setBackgroundDrawable(a.l(this.context, this.CZk));
        }
      }
      this.OXR = ((ImageView)paramView.findViewById(2131309007));
      this.OXR.setVisibility(this.OXO);
      this.OXS = ((ViewGroup)paramView.findViewById(2131307104));
      this.OXS.setVisibility(this.OXP);
      this.OXT = ((TextView)paramView.findViewById(16908310));
      paramView = (TextView)paramView.findViewById(2131309015);
      if (!Util.isNullOrNil(this.OXU)) {
        break;
      }
      paramView.setVisibility(8);
      AppMethodBeat.o(142542);
      return;
      label216:
      if (this.aeN != 0)
      {
        ((ImageView)localObject).setImageResource(this.aeN);
        ((ImageView)localObject).setVisibility(0);
      }
      else
      {
        ((ImageView)localObject).setVisibility(8);
      }
    }
    paramView.setVisibility(0);
    paramView.setText(this.OXU);
    AppMethodBeat.o(142542);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142541);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131495594, localViewGroup);
    paramViewGroup.setMinimumHeight(paramViewGroup.getResources().getDimensionPixelSize(2131165585));
    AppMethodBeat.o(142541);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconMsgPreference
 * JD-Core Version:    0.7.0.1
 */