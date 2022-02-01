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
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public class IconSummaryPreference
  extends Preference
{
  private int FGP;
  private Bitmap FKj;
  RelativeLayout.LayoutParams GeC;
  private int GeH;
  private View GeJ;
  private int GeT;
  private TextView GeU;
  private int GeV;
  private int Gev;
  private int Gew;
  private ViewGroup Gey;
  private Context context;
  private Drawable drawable;
  private int height;
  private ImageView tto;
  private String uCA;
  private int wey;
  public int wez;
  
  public IconSummaryPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconSummaryPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142560);
    this.uCA = "";
    this.wey = -1;
    this.wez = 8;
    this.FKj = null;
    this.FGP = -1;
    this.GeH = 8;
    this.Gev = 0;
    this.Gew = 8;
    this.GeT = 8;
    this.tto = null;
    this.Gey = null;
    this.GeJ = null;
    this.GeU = null;
    this.GeV = -1;
    this.height = -1;
    this.context = paramContext;
    setLayoutResource(2131494804);
    AppMethodBeat.o(142560);
  }
  
  public final void aKn(String paramString)
  {
    this.uCA = paramString;
    this.wey = 2131233430;
  }
  
  public final void eTB()
  {
    AppMethodBeat.i(142564);
    this.GeT = 0;
    if (this.GeU != null) {
      this.GeU.setVisibility(this.GeT);
    }
    AppMethodBeat.o(142564);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142565);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(2131300943);
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
      localObject = (LinearLayout)paramView.findViewById(2131302326);
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      localObject = (TextView)paramView.findViewById(2131305745);
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(this.wez);
        ((TextView)localObject).setText(this.uCA);
        if (this.wey != -1) {
          ((TextView)localObject).setBackgroundDrawable(a.l(this.context, this.wey));
        }
      }
      if (this.tto == null) {
        this.tto = ((ImageView)paramView.findViewById(2131300959));
      }
      if (this.Gey == null) {
        this.Gey = ((ViewGroup)paramView.findViewById(2131304191));
      }
      if (this.GeJ == null) {
        this.GeJ = paramView.findViewById(2131304190);
      }
      this.GeJ.setVisibility(this.Gew);
      if (this.FKj == null) {
        break label425;
      }
      this.tto.setImageBitmap(this.FKj);
    }
    for (;;)
    {
      this.tto.setVisibility(this.GeH);
      this.Gey.setVisibility(this.Gev);
      if (this.GeC != null) {
        this.tto.setLayoutParams(this.GeC);
      }
      this.GeU = ((TextView)paramView.findViewById(2131304197));
      if ((this.GeU != null) && (getSummary() != null) && (getSummary().length() > 0))
      {
        this.GeU.setText(getSummary());
        this.GeU.setVisibility(this.GeT);
      }
      if ((this.GeU != null) && (this.GeV != -1))
      {
        this.GeU.setCompoundDrawablesWithIntrinsicBounds(this.GeV, 0, 0, 0);
        int i = BackwardSupportUtil.b.g(this.mContext, 2.0F);
        this.GeU.setCompoundDrawablePadding(i);
        this.GeU.setVisibility(this.GeT);
      }
      AppMethodBeat.o(142565);
      return;
      if (this.Uy != null)
      {
        ((ImageView)localObject).setImageDrawable(this.Uy);
        ((ImageView)localObject).setVisibility(0);
        break;
      }
      if (this.abP == 0) {
        break;
      }
      ((ImageView)localObject).setImageResource(this.abP);
      ((ImageView)localObject).setVisibility(0);
      break;
      label425:
      if (this.FGP != -1) {
        this.tto.setImageResource(this.FGP);
      }
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142561);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131494830, localViewGroup);
    AppMethodBeat.o(142561);
    return paramViewGroup;
  }
  
  public final void setSummary(int paramInt)
  {
    AppMethodBeat.i(142563);
    super.setSummary(paramInt);
    if ((this.GeU != null) && (getSummary() != null) && (getSummary().length() > 0)) {
      this.GeU.setText(getSummary());
    }
    AppMethodBeat.o(142563);
  }
  
  public final void setSummary(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142562);
    super.setSummary(paramCharSequence);
    if ((this.GeU != null) && (getSummary() != null) && (getSummary().length() > 0)) {
      this.GeU.setText(getSummary());
    }
    AppMethodBeat.o(142562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconSummaryPreference
 * JD-Core Version:    0.7.0.1
 */