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
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public class IconSummaryPreference
  extends Preference
{
  private Context context;
  private Drawable drawable;
  private int height;
  private ImageView oyN;
  private String pAS;
  private int qGe;
  public int qGf;
  private int yUb;
  private Bitmap yXe;
  private int zqM;
  private int zqN;
  private ViewGroup zqP;
  RelativeLayout.LayoutParams zqS;
  private int zqX;
  private View zqZ;
  private int zri;
  private TextView zrj;
  private int zrk;
  
  public IconSummaryPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconSummaryPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107183);
    this.pAS = "";
    this.qGe = -1;
    this.qGf = 8;
    this.yXe = null;
    this.yUb = -1;
    this.zqX = 8;
    this.zqM = 0;
    this.zqN = 8;
    this.zri = 8;
    this.oyN = null;
    this.zqP = null;
    this.zqZ = null;
    this.zrj = null;
    this.zrk = -1;
    this.height = -1;
    this.context = paramContext;
    setLayoutResource(2130970179);
    AppMethodBeat.o(107183);
  }
  
  public final void atA(String paramString)
  {
    this.pAS = paramString;
    this.qGe = 2130839787;
  }
  
  public final void dEL()
  {
    AppMethodBeat.i(107187);
    this.zri = 0;
    if (this.zrj != null) {
      this.zrj.setVisibility(this.zri);
    }
    AppMethodBeat.o(107187);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(107188);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(2131822243);
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
      localObject = (LinearLayout)paramView.findViewById(2131822408);
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      localObject = (TextView)paramView.findViewById(2131822409);
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(this.qGf);
        ((TextView)localObject).setText(this.pAS);
        if (this.qGe != -1) {
          ((TextView)localObject).setBackgroundDrawable(a.k(this.context, this.qGe));
        }
      }
      if (this.oyN == null) {
        this.oyN = ((ImageView)paramView.findViewById(2131822413));
      }
      if (this.zqP == null) {
        this.zqP = ((ViewGroup)paramView.findViewById(2131822412));
      }
      if (this.zqZ == null) {
        this.zqZ = paramView.findViewById(2131822414);
      }
      this.zqZ.setVisibility(this.zqN);
      if (this.yXe == null) {
        break label425;
      }
      this.oyN.setImageBitmap(this.yXe);
    }
    for (;;)
    {
      this.oyN.setVisibility(this.zqX);
      this.zqP.setVisibility(this.zqM);
      if (this.zqS != null) {
        this.oyN.setLayoutParams(this.zqS);
      }
      this.zrj = ((TextView)paramView.findViewById(2131826217));
      if ((this.zrj != null) && (getSummary() != null) && (getSummary().length() > 0))
      {
        this.zrj.setText(getSummary());
        this.zrj.setVisibility(this.zri);
      }
      if ((this.zrj != null) && (this.zrk != -1))
      {
        this.zrj.setCompoundDrawablesWithIntrinsicBounds(this.zrk, 0, 0, 0);
        int i = BackwardSupportUtil.b.b(this.mContext, 2.0F);
        this.zrj.setCompoundDrawablePadding(i);
        this.zrj.setVisibility(this.zri);
      }
      AppMethodBeat.o(107188);
      return;
      if (this.la != null)
      {
        ((ImageView)localObject).setImageDrawable(this.la);
        ((ImageView)localObject).setVisibility(0);
        break;
      }
      if (this.UM == 0) {
        break;
      }
      ((ImageView)localObject).setImageResource(this.UM);
      ((ImageView)localObject).setVisibility(0);
      break;
      label425:
      if (this.yUb != -1) {
        this.oyN.setImageResource(this.yUb);
      }
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107184);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2130970204, localViewGroup);
    AppMethodBeat.o(107184);
    return paramViewGroup;
  }
  
  public final void setSummary(int paramInt)
  {
    AppMethodBeat.i(107186);
    super.setSummary(paramInt);
    if ((this.zrj != null) && (getSummary() != null) && (getSummary().length() > 0)) {
      this.zrj.setText(getSummary());
    }
    AppMethodBeat.o(107186);
  }
  
  public final void setSummary(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(107185);
    super.setSummary(paramCharSequence);
    if ((this.zrj != null) && (getSummary() != null) && (getSummary().length() > 0)) {
      this.zrj.setText(getSummary());
    }
    AppMethodBeat.o(107185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconSummaryPreference
 * JD-Core Version:    0.7.0.1
 */