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
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;

public class IconSummaryPreference
  extends Preference
{
  private ImageView KKj;
  private String MPk;
  private int MPl;
  public int MPm;
  private int adYA;
  private View adYC;
  private int adYP;
  private TextView adYQ;
  private int adYR;
  private int adYo;
  private int adYp;
  private ViewGroup adYr;
  RelativeLayout.LayoutParams adYv;
  private int adva;
  private Bitmap adzN;
  private Context context;
  private Drawable drawable;
  private int height;
  
  public IconSummaryPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconSummaryPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142560);
    this.MPk = "";
    this.MPl = -1;
    this.MPm = 8;
    this.adzN = null;
    this.adva = -1;
    this.adYA = 8;
    this.adYo = 0;
    this.adYp = 8;
    this.adYP = 8;
    this.KKj = null;
    this.adYr = null;
    this.adYC = null;
    this.adYQ = null;
    this.adYR = -1;
    this.height = -1;
    this.context = paramContext;
    setLayoutResource(a.h.mm_preference);
    AppMethodBeat.o(142560);
  }
  
  public final void aBk(int paramInt)
  {
    AppMethodBeat.i(142563);
    super.aBk(paramInt);
    if ((this.adYQ != null) && (gBR() != null) && (gBR().length() > 0)) {
      this.adYQ.setText(gBR());
    }
    AppMethodBeat.o(142563);
  }
  
  public final void aS(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142562);
    super.aS(paramCharSequence);
    if ((this.adYQ != null) && (gBR() != null) && (gBR().length() > 0)) {
      this.adYQ.setText(gBR());
    }
    AppMethodBeat.o(142562);
  }
  
  public final void gv(String paramString, int paramInt)
  {
    this.MPk = paramString;
    this.MPl = paramInt;
  }
  
  public final void jno()
  {
    AppMethodBeat.i(142564);
    this.adYP = 0;
    if (this.adYQ != null) {
      this.adYQ.setVisibility(this.adYP);
    }
    AppMethodBeat.o(142564);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142565);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(a.g.image_iv);
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
      localObject = (LinearLayout)paramView.findViewById(a.g.mm_preference_ll_id);
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      localObject = (TextView)paramView.findViewById(a.g.text_tv_one);
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(this.MPm);
        ((TextView)localObject).setText(this.MPk);
        if (this.MPl != -1) {
          ((TextView)localObject).setBackgroundDrawable(a.m(this.context, this.MPl));
        }
      }
      if (this.KKj == null) {
        this.KKj = ((ImageView)paramView.findViewById(a.g.image_right_iv));
      }
      if (this.adYr == null) {
        this.adYr = ((ViewGroup)paramView.findViewById(a.g.right_rl));
      }
      if (this.adYC == null) {
        this.adYC = paramView.findViewById(a.g.right_prospect);
      }
      this.adYC.setVisibility(this.adYp);
      if (this.adzN == null) {
        break label432;
      }
      this.KKj.setImageBitmap(this.adzN);
    }
    for (;;)
    {
      this.KKj.setVisibility(this.adYA);
      this.adYr.setVisibility(this.adYo);
      if (this.adYv != null) {
        this.KKj.setLayoutParams(this.adYv);
      }
      this.adYQ = ((TextView)paramView.findViewById(a.g.right_summary));
      if ((this.adYQ != null) && (gBR() != null) && (gBR().length() > 0))
      {
        this.adYQ.setText(gBR());
        this.adYQ.setVisibility(this.adYP);
      }
      if ((this.adYQ != null) && (this.adYR != -1))
      {
        this.adYQ.setCompoundDrawablesWithIntrinsicBounds(this.adYR, 0, 0, 0);
        int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 2.0F);
        this.adYQ.setCompoundDrawablePadding(i);
        this.adYQ.setVisibility(this.adYP);
      }
      AppMethodBeat.o(142565);
      return;
      if (getIcon() != null)
      {
        ((ImageView)localObject).setImageDrawable(getIcon());
        ((ImageView)localObject).setVisibility(0);
        break;
      }
      if (dqA() == 0) {
        break;
      }
      ((ImageView)localObject).setImageResource(dqA());
      ((ImageView)localObject).setVisibility(0);
      break;
      label432:
      if (this.adva != -1) {
        this.KKj.setImageResource(this.adva);
      }
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142561);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.g.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, a.h.mm_preference_content_icon_summary, localViewGroup);
    AppMethodBeat.o(142561);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconSummaryPreference
 * JD-Core Version:    0.7.0.1
 */