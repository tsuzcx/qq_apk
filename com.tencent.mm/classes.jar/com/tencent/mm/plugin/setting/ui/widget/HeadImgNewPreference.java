package com.tencent.mm.plugin.setting.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.Preference;

public final class HeadImgNewPreference
  extends Preference
{
  private int height;
  private ImageView iTH;
  private TextView qMd;
  private View qMe;
  private String qMf;
  public View.OnClickListener qMg;
  private boolean qMh;
  private boolean qMi;
  
  public HeadImgNewPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeadImgNewPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(127698);
    this.height = -1;
    this.qMh = false;
    this.qMi = false;
    setLayoutResource(2130970179);
    AppMethodBeat.o(127698);
  }
  
  public final void YZ(String paramString)
  {
    AppMethodBeat.i(127700);
    this.qMf = null;
    if (this.iTH != null) {
      a.b.c(this.iTH, paramString);
    }
    while (paramString == null)
    {
      this.qMh = false;
      AppMethodBeat.o(127700);
      return;
      this.qMf = paramString;
    }
    this.qMh = true;
    AppMethodBeat.o(127700);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(127701);
    super.onBindView(paramView);
    if (this.iTH == null) {
      this.iTH = ((ImageView)paramView.findViewById(2131826214));
    }
    if (this.qMd == null) {
      this.qMd = ((TextView)paramView.findViewById(2131826216));
    }
    if (this.qMe == null) {
      this.qMe = paramView.findViewById(2131821062);
    }
    if (this.qMg != null) {
      this.qMe.setOnClickListener(this.qMg);
    }
    if (this.qMf != null)
    {
      a.b.c(this.iTH, this.qMf);
      this.qMf = null;
    }
    if (!this.qMh)
    {
      this.qMe.setVisibility(8);
      this.qMd.setVisibility(0);
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView.findViewById(2131822408);
      if (this.height != -1) {
        paramView.setMinimumHeight(this.height);
      }
      AppMethodBeat.o(127701);
      return;
      this.qMd.setVisibility(8);
      this.qMe.setVisibility(0);
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(127699);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    if (this.qMi) {
      View.inflate(this.mContext, 2130970301, localViewGroup);
    }
    for (;;)
    {
      this.iTH = ((ImageView)paramViewGroup.findViewById(2131826214));
      this.qMd = ((TextView)paramViewGroup.findViewById(2131826216));
      this.qMe = paramViewGroup.findViewById(2131821062);
      AppMethodBeat.o(127699);
      return paramViewGroup;
      View.inflate(this.mContext, 2130970202, localViewGroup);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.HeadImgNewPreference
 * JD-Core Version:    0.7.0.1
 */