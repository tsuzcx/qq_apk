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
import com.tencent.mm.sdk.platformtools.bo;

public class IconMsgPreference
  extends Preference
{
  private Context context;
  private Drawable drawable;
  private int height;
  private String pAS;
  private int qGe;
  private int qGf;
  private int zqL;
  private int zqM;
  private int zqN;
  private ImageView zqO;
  private ViewGroup zqP;
  private TextView zqQ;
  private String zqR;
  
  public IconMsgPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconMsgPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107163);
    this.pAS = "";
    this.qGe = -1;
    this.qGf = 8;
    this.zqL = 8;
    this.zqM = 0;
    this.zqN = 8;
    this.zqO = null;
    this.zqP = null;
    this.height = -1;
    this.zqR = "";
    this.context = paramContext;
    setLayoutResource(2130970179);
    AppMethodBeat.o(107163);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(107165);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(2131822243);
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
      this.zqO = ((ImageView)paramView.findViewById(2131822410));
      this.zqO.setVisibility(this.zqL);
      this.zqP = ((ViewGroup)paramView.findViewById(2131822412));
      this.zqP.setVisibility(this.zqM);
      this.zqQ = ((TextView)paramView.findViewById(16908310));
      paramView = (TextView)paramView.findViewById(2131826240);
      if (!bo.isNullOrNil(this.zqR)) {
        break;
      }
      paramView.setVisibility(8);
      AppMethodBeat.o(107165);
      return;
      label216:
      if (this.UM != 0)
      {
        ((ImageView)localObject).setImageResource(this.UM);
        ((ImageView)localObject).setVisibility(0);
      }
      else
      {
        ((ImageView)localObject).setVisibility(8);
      }
    }
    paramView.setVisibility(0);
    paramView.setText(this.zqR);
    AppMethodBeat.o(107165);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107164);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2130970231, localViewGroup);
    paramViewGroup.setMinimumHeight(paramViewGroup.getResources().getDimensionPixelSize(2131427853));
    AppMethodBeat.o(107164);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconMsgPreference
 * JD-Core Version:    0.7.0.1
 */