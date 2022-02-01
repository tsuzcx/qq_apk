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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public class IconSummaryPreference
  extends Preference
{
  private int HEI;
  private TextView HEJ;
  private int HEK;
  private int HEk;
  private int HEl;
  private ViewGroup HEn;
  RelativeLayout.LayoutParams HEr;
  private int HEw;
  private View HEy;
  private int HfX;
  private Bitmap Hjr;
  private Context context;
  private Drawable drawable;
  private int height;
  private ImageView uBH;
  private String vLt;
  private int xpM;
  public int xpN;
  
  public IconSummaryPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconSummaryPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142560);
    this.vLt = "";
    this.xpM = -1;
    this.xpN = 8;
    this.Hjr = null;
    this.HfX = -1;
    this.HEw = 8;
    this.HEk = 0;
    this.HEl = 8;
    this.HEI = 8;
    this.uBH = null;
    this.HEn = null;
    this.HEy = null;
    this.HEJ = null;
    this.HEK = -1;
    this.height = -1;
    this.context = paramContext;
    setLayoutResource(2131494804);
    AppMethodBeat.o(142560);
  }
  
  public final void aPQ(String paramString)
  {
    this.vLt = paramString;
    this.xpM = 2131233430;
  }
  
  public final void fjn()
  {
    AppMethodBeat.i(142564);
    this.HEI = 0;
    if (this.HEJ != null) {
      this.HEJ.setVisibility(this.HEI);
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
        ((TextView)localObject).setVisibility(this.xpN);
        ((TextView)localObject).setText(this.vLt);
        if (this.xpM != -1) {
          ((TextView)localObject).setBackgroundDrawable(a.l(this.context, this.xpM));
        }
      }
      if (this.uBH == null) {
        this.uBH = ((ImageView)paramView.findViewById(2131300959));
      }
      if (this.HEn == null) {
        this.HEn = ((ViewGroup)paramView.findViewById(2131304191));
      }
      if (this.HEy == null) {
        this.HEy = paramView.findViewById(2131304190);
      }
      this.HEy.setVisibility(this.HEl);
      if (this.Hjr == null) {
        break label425;
      }
      this.uBH.setImageBitmap(this.Hjr);
    }
    for (;;)
    {
      this.uBH.setVisibility(this.HEw);
      this.HEn.setVisibility(this.HEk);
      if (this.HEr != null) {
        this.uBH.setLayoutParams(this.HEr);
      }
      this.HEJ = ((TextView)paramView.findViewById(2131304197));
      if ((this.HEJ != null) && (getSummary() != null) && (getSummary().length() > 0))
      {
        this.HEJ.setText(getSummary());
        this.HEJ.setVisibility(this.HEI);
      }
      if ((this.HEJ != null) && (this.HEK != -1))
      {
        this.HEJ.setCompoundDrawablesWithIntrinsicBounds(this.HEK, 0, 0, 0);
        int i = BackwardSupportUtil.b.g(this.mContext, 2.0F);
        this.HEJ.setCompoundDrawablePadding(i);
        this.HEJ.setVisibility(this.HEI);
      }
      AppMethodBeat.o(142565);
      return;
      if (this.Vu != null)
      {
        ((ImageView)localObject).setImageDrawable(this.Vu);
        ((ImageView)localObject).setVisibility(0);
        break;
      }
      if (this.acJ == 0) {
        break;
      }
      ((ImageView)localObject).setImageResource(this.acJ);
      ((ImageView)localObject).setVisibility(0);
      break;
      label425:
      if (this.HfX != -1) {
        this.uBH.setImageResource(this.HfX);
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
    if ((this.HEJ != null) && (getSummary() != null) && (getSummary().length() > 0)) {
      this.HEJ.setText(getSummary());
    }
    AppMethodBeat.o(142563);
  }
  
  public final void setSummary(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142562);
    super.setSummary(paramCharSequence);
    if ((this.HEJ != null) && (getSummary() != null) && (getSummary().length() > 0)) {
      this.HEJ.setText(getSummary());
    }
    AppMethodBeat.o(142562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconSummaryPreference
 * JD-Core Version:    0.7.0.1
 */