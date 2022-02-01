package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;

public class IconSummaryPreference
  extends Preference
{
  private String Bgn;
  private int CZk;
  public int CZl;
  private Bitmap OBX;
  private int OXP;
  private int OXQ;
  private ViewGroup OXS;
  RelativeLayout.LayoutParams OXW;
  private int OYb;
  private View OYd;
  private int OYq;
  private TextView OYr;
  private int OYs;
  private int OxP;
  private Context context;
  private Drawable drawable;
  private int height;
  private ImageView zkw;
  
  public IconSummaryPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconSummaryPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142560);
    this.Bgn = "";
    this.CZk = -1;
    this.CZl = 8;
    this.OBX = null;
    this.OxP = -1;
    this.OYb = 8;
    this.OXP = 0;
    this.OXQ = 8;
    this.OYq = 8;
    this.zkw = null;
    this.OXS = null;
    this.OYd = null;
    this.OYr = null;
    this.OYs = -1;
    this.height = -1;
    this.context = paramContext;
    setLayoutResource(2131495538);
    AppMethodBeat.o(142560);
  }
  
  public final void bmk(String paramString)
  {
    this.Bgn = paramString;
    this.CZk = 2131234232;
  }
  
  public final void gLH()
  {
    AppMethodBeat.i(142564);
    this.OYq = 0;
    if (this.OYr != null) {
      this.OYr.setVisibility(this.OYq);
    }
    AppMethodBeat.o(142564);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142565);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(2131302573);
    if (localObject != null)
    {
      ((ImageView)localObject).setVisibility(8);
      if (this.drawable != null)
      {
        ((ImageView)localObject).setImageDrawable(this.drawable);
        ((ImageView)localObject).setVisibility(0);
      }
    }
    else
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
      if (this.zkw == null) {
        this.zkw = ((ImageView)paramView.findViewById(2131302595));
      }
      if (this.OXS == null) {
        this.OXS = ((ViewGroup)paramView.findViewById(2131307104));
      }
      if (this.OYd == null) {
        this.OYd = paramView.findViewById(2131307102);
      }
      this.OYd.setVisibility(this.OXQ);
      if (this.OBX == null) {
        break label425;
      }
      this.zkw.setImageBitmap(this.OBX);
    }
    for (;;)
    {
      this.zkw.setVisibility(this.OYb);
      this.OXS.setVisibility(this.OXP);
      if (this.OXW != null) {
        this.zkw.setLayoutParams(this.OXW);
      }
      this.OYr = ((TextView)paramView.findViewById(2131307111));
      if ((this.OYr != null) && (getSummary() != null) && (getSummary().length() > 0))
      {
        this.OYr.setText(getSummary());
        this.OYr.setVisibility(this.OYq);
      }
      if ((this.OYr != null) && (this.OYs != -1))
      {
        this.OYr.setCompoundDrawablesWithIntrinsicBounds(this.OYs, 0, 0, 0);
        int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 2.0F);
        this.OYr.setCompoundDrawablePadding(i);
        this.OYr.setVisibility(this.OYq);
      }
      AppMethodBeat.o(142565);
      return;
      if (this.Xw != null)
      {
        ((ImageView)localObject).setImageDrawable(this.Xw);
        ((ImageView)localObject).setVisibility(0);
        break;
      }
      if (this.aeN == 0) {
        break;
      }
      ((ImageView)localObject).setImageResource(this.aeN);
      ((ImageView)localObject).setVisibility(0);
      break;
      label425:
      if (this.OxP != -1) {
        this.zkw.setImageResource(this.OxP);
      }
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142561);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131495565, localViewGroup);
    AppMethodBeat.o(142561);
    return paramViewGroup;
  }
  
  public final void setSummary(int paramInt)
  {
    AppMethodBeat.i(142563);
    super.setSummary(paramInt);
    if ((this.OYr != null) && (getSummary() != null) && (getSummary().length() > 0)) {
      this.OYr.setText(getSummary());
    }
    AppMethodBeat.o(142563);
  }
  
  public final void setSummary(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142562);
    super.setSummary(paramCharSequence);
    if ((this.OYr != null) && (getSummary() != null) && (getSummary().length() > 0)) {
      this.OYr.setText(getSummary());
    }
    AppMethodBeat.o(142562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconSummaryPreference
 * JD-Core Version:    0.7.0.1
 */