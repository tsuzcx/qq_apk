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
import com.tencent.mm.sdk.platformtools.bu;

public class IconMsgPreference
  extends Preference
{
  private int JMO;
  private int JMP;
  private int JMQ;
  private ImageView JMR;
  private ViewGroup JMS;
  private TextView JMT;
  private String JMU;
  private Context context;
  private Drawable drawable;
  private int height;
  private String xit;
  private int yUu;
  private int yUv;
  
  public IconMsgPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconMsgPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142540);
    this.xit = "";
    this.yUu = -1;
    this.yUv = 8;
    this.JMO = 8;
    this.JMP = 0;
    this.JMQ = 8;
    this.JMR = null;
    this.JMS = null;
    this.height = -1;
    this.JMU = "";
    this.context = paramContext;
    setLayoutResource(2131494804);
    AppMethodBeat.o(142540);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142542);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(2131300943);
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
      localObject = (LinearLayout)paramView.findViewById(2131302326);
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      localObject = (TextView)paramView.findViewById(2131305745);
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(this.yUv);
        ((TextView)localObject).setText(this.xit);
        if (this.yUu != -1) {
          ((TextView)localObject).setBackgroundDrawable(a.l(this.context, this.yUu));
        }
      }
      this.JMR = ((ImageView)paramView.findViewById(2131305740));
      this.JMR.setVisibility(this.JMO);
      this.JMS = ((ViewGroup)paramView.findViewById(2131304191));
      this.JMS.setVisibility(this.JMP);
      this.JMT = ((TextView)paramView.findViewById(16908310));
      paramView = (TextView)paramView.findViewById(2131305746);
      if (!bu.isNullOrNil(this.JMU)) {
        break;
      }
      paramView.setVisibility(8);
      AppMethodBeat.o(142542);
      return;
      label216:
      if (this.aeA != 0)
      {
        ((ImageView)localObject).setImageResource(this.aeA);
        ((ImageView)localObject).setVisibility(0);
      }
      else
      {
        ((ImageView)localObject).setVisibility(8);
      }
    }
    paramView.setVisibility(0);
    paramView.setText(this.JMU);
    AppMethodBeat.o(142542);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142541);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131494858, localViewGroup);
    paramViewGroup.setMinimumHeight(paramViewGroup.getResources().getDimensionPixelSize(2131165567));
    AppMethodBeat.o(142541);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconMsgPreference
 * JD-Core Version:    0.7.0.1
 */