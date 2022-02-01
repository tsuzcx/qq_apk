package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ci.a;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactMoreInfoPreference
  extends Preference
{
  private ImageView GXY;
  private ImageView GXZ;
  private ImageView GYa;
  private ImageView GYb;
  private ImageView GYc;
  private ImageView GYd;
  private int GYe;
  private int GYf;
  private int GYg;
  private int GYh;
  private int GYi;
  private int GYj;
  private TextView txT;
  
  public ContactMoreInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.GYe = 8;
    this.GYf = 8;
    this.GYg = 8;
    this.GYh = 8;
    this.GYi = 8;
    this.GYj = 8;
  }
  
  public ContactMoreInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27018);
    this.GYe = 8;
    this.GYf = 8;
    this.GYg = 8;
    this.GYh = 8;
    this.GYi = 8;
    this.GYj = 8;
    setLayoutResource(R.i.mm_preference);
    AppMethodBeat.o(27018);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27020);
    this.GXY = ((ImageView)paramView.findViewById(R.h.dIP));
    this.GXZ = ((ImageView)paramView.findViewById(R.h.dIT));
    this.GYa = ((ImageView)paramView.findViewById(R.h.dIO));
    this.GYb = ((ImageView)paramView.findViewById(R.h.dIE));
    this.GYc = ((ImageView)paramView.findViewById(R.h.dIK));
    this.GYd = ((ImageView)paramView.findViewById(R.h.dIW));
    this.txT = ((TextView)paramView.findViewById(R.h.title));
    if (this.GXY != null) {
      this.GXY.setVisibility(this.GYe);
    }
    if (this.GXZ != null) {
      this.GXZ.setVisibility(this.GYf);
    }
    if (this.GYa != null) {
      this.GYa.setVisibility(this.GYg);
    }
    if (this.GYb != null) {
      this.GYb.setVisibility(this.GYh);
    }
    if (this.GYc != null) {
      this.GYc.setVisibility(this.GYi);
    }
    if (this.txT != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.txT.getLayoutParams();
      localLayoutParams.width = a.aY(this.mContext, R.f.FixedTitleWidth);
      this.txT.setLayoutParams(localLayoutParams);
    }
    if (this.GYd != null) {
      this.GYd.setVisibility(this.GYj);
    }
    super.onBindView(paramView);
    AppMethodBeat.o(27020);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27019);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.eiV, localViewGroup);
    AppMethodBeat.o(27019);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMoreInfoPreference
 * JD-Core Version:    0.7.0.1
 */