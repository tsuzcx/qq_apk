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
  private int ITn;
  private Bitmap IWY;
  private TextView JsA;
  private int JsB;
  private int Jsa;
  private int Jsb;
  private ViewGroup Jsd;
  RelativeLayout.LayoutParams Jsh;
  private int Jsm;
  private View Jso;
  private int Jsz;
  private Context context;
  private Drawable drawable;
  private int height;
  private ImageView vEo;
  private String wSC;
  private int yEp;
  public int yEq;
  
  public IconSummaryPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconSummaryPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142560);
    this.wSC = "";
    this.yEp = -1;
    this.yEq = 8;
    this.IWY = null;
    this.ITn = -1;
    this.Jsm = 8;
    this.Jsa = 0;
    this.Jsb = 8;
    this.Jsz = 8;
    this.vEo = null;
    this.Jsd = null;
    this.Jso = null;
    this.JsA = null;
    this.JsB = -1;
    this.height = -1;
    this.context = paramContext;
    setLayoutResource(2131494804);
    AppMethodBeat.o(142560);
  }
  
  public final void aVG(String paramString)
  {
    this.wSC = paramString;
    this.yEp = 2131233430;
  }
  
  public final void fzC()
  {
    AppMethodBeat.i(142564);
    this.Jsz = 0;
    if (this.JsA != null) {
      this.JsA.setVisibility(this.Jsz);
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
        ((TextView)localObject).setVisibility(this.yEq);
        ((TextView)localObject).setText(this.wSC);
        if (this.yEp != -1) {
          ((TextView)localObject).setBackgroundDrawable(a.l(this.context, this.yEp));
        }
      }
      if (this.vEo == null) {
        this.vEo = ((ImageView)paramView.findViewById(2131300959));
      }
      if (this.Jsd == null) {
        this.Jsd = ((ViewGroup)paramView.findViewById(2131304191));
      }
      if (this.Jso == null) {
        this.Jso = paramView.findViewById(2131304190);
      }
      this.Jso.setVisibility(this.Jsb);
      if (this.IWY == null) {
        break label425;
      }
      this.vEo.setImageBitmap(this.IWY);
    }
    for (;;)
    {
      this.vEo.setVisibility(this.Jsm);
      this.Jsd.setVisibility(this.Jsa);
      if (this.Jsh != null) {
        this.vEo.setLayoutParams(this.Jsh);
      }
      this.JsA = ((TextView)paramView.findViewById(2131304197));
      if ((this.JsA != null) && (getSummary() != null) && (getSummary().length() > 0))
      {
        this.JsA.setText(getSummary());
        this.JsA.setVisibility(this.Jsz);
      }
      if ((this.JsA != null) && (this.JsB != -1))
      {
        this.JsA.setCompoundDrawablesWithIntrinsicBounds(this.JsB, 0, 0, 0);
        int i = BackwardSupportUtil.b.g(this.mContext, 2.0F);
        this.JsA.setCompoundDrawablePadding(i);
        this.JsA.setVisibility(this.Jsz);
      }
      AppMethodBeat.o(142565);
      return;
      if (this.Xj != null)
      {
        ((ImageView)localObject).setImageDrawable(this.Xj);
        ((ImageView)localObject).setVisibility(0);
        break;
      }
      if (this.aeA == 0) {
        break;
      }
      ((ImageView)localObject).setImageResource(this.aeA);
      ((ImageView)localObject).setVisibility(0);
      break;
      label425:
      if (this.ITn != -1) {
        this.vEo.setImageResource(this.ITn);
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
    if ((this.JsA != null) && (getSummary() != null) && (getSummary().length() > 0)) {
      this.JsA.setText(getSummary());
    }
    AppMethodBeat.o(142563);
  }
  
  public final void setSummary(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142562);
    super.setSummary(paramCharSequence);
    if ((this.JsA != null) && (getSummary() != null) && (getSummary().length() > 0)) {
      this.JsA.setText(getSummary());
    }
    AppMethodBeat.o(142562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconSummaryPreference
 * JD-Core Version:    0.7.0.1
 */