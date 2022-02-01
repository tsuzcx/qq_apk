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
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;

public class IconSummaryPreference
  extends Preference
{
  private ImageView EPM;
  private String GRG;
  private int GRH;
  public int GRI;
  private int VQS;
  private Bitmap VVp;
  private int WqZ;
  private TextView WrA;
  private int WrB;
  private int Wra;
  private ViewGroup Wrc;
  RelativeLayout.LayoutParams Wrg;
  private int Wrl;
  private View Wrn;
  private int Wrz;
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
    this.GRG = "";
    this.GRH = -1;
    this.GRI = 8;
    this.VVp = null;
    this.VQS = -1;
    this.Wrl = 8;
    this.WqZ = 0;
    this.Wra = 8;
    this.Wrz = 8;
    this.EPM = null;
    this.Wrc = null;
    this.Wrn = null;
    this.WrA = null;
    this.WrB = -1;
    this.height = -1;
    this.context = paramContext;
    setLayoutResource(a.h.mm_preference);
    AppMethodBeat.o(142560);
  }
  
  public final void aF(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142562);
    super.aF(paramCharSequence);
    if ((this.WrA != null) && (fqw() != null) && (fqw().length() > 0)) {
      this.WrA.setText(fqw());
    }
    AppMethodBeat.o(142562);
  }
  
  public final void auI(int paramInt)
  {
    AppMethodBeat.i(142563);
    super.auI(paramInt);
    if ((this.WrA != null) && (fqw() != null) && (fqw().length() > 0)) {
      this.WrA.setText(fqw());
    }
    AppMethodBeat.o(142563);
  }
  
  public final void fC(String paramString, int paramInt)
  {
    this.GRG = paramString;
    this.GRH = paramInt;
  }
  
  public final void hKL()
  {
    AppMethodBeat.i(142564);
    this.Wrz = 0;
    if (this.WrA != null) {
      this.WrA.setVisibility(this.Wrz);
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
        ((TextView)localObject).setVisibility(this.GRI);
        ((TextView)localObject).setText(this.GRG);
        if (this.GRH != -1) {
          ((TextView)localObject).setBackgroundDrawable(a.m(this.context, this.GRH));
        }
      }
      if (this.EPM == null) {
        this.EPM = ((ImageView)paramView.findViewById(a.g.image_right_iv));
      }
      if (this.Wrc == null) {
        this.Wrc = ((ViewGroup)paramView.findViewById(a.g.right_rl));
      }
      if (this.Wrn == null) {
        this.Wrn = paramView.findViewById(a.g.right_prospect);
      }
      this.Wrn.setVisibility(this.Wra);
      if (this.VVp == null) {
        break label432;
      }
      this.EPM.setImageBitmap(this.VVp);
    }
    for (;;)
    {
      this.EPM.setVisibility(this.Wrl);
      this.Wrc.setVisibility(this.WqZ);
      if (this.Wrg != null) {
        this.EPM.setLayoutParams(this.Wrg);
      }
      this.WrA = ((TextView)paramView.findViewById(a.g.right_summary));
      if ((this.WrA != null) && (fqw() != null) && (fqw().length() > 0))
      {
        this.WrA.setText(fqw());
        this.WrA.setVisibility(this.Wrz);
      }
      if ((this.WrA != null) && (this.WrB != -1))
      {
        this.WrA.setCompoundDrawablesWithIntrinsicBounds(this.WrB, 0, 0, 0);
        int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 2.0F);
        this.WrA.setCompoundDrawablePadding(i);
        this.WrA.setVisibility(this.Wrz);
      }
      AppMethodBeat.o(142565);
      return;
      if (getIcon() != null)
      {
        ((ImageView)localObject).setImageDrawable(getIcon());
        ((ImageView)localObject).setVisibility(0);
        break;
      }
      if (cMV() == 0) {
        break;
      }
      ((ImageView)localObject).setImageResource(cMV());
      ((ImageView)localObject).setVisibility(0);
      break;
      label432:
      if (this.VQS != -1) {
        this.EPM.setImageResource(this.VQS);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconSummaryPreference
 * JD-Core Version:    0.7.0.1
 */