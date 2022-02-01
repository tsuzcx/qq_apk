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
import com.tencent.mm.cc.a;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactSocialInfoPreference
  extends Preference
{
  private TextView oel;
  private int vJA;
  private ImageView vJp;
  private ImageView vJq;
  private ImageView vJr;
  private ImageView vJs;
  private ImageView vJt;
  private ImageView vJu;
  private int vJv;
  private int vJw;
  private int vJx;
  private int vJy;
  private int vJz;
  
  public ContactSocialInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.vJv = 8;
    this.vJw = 8;
    this.vJx = 8;
    this.vJy = 8;
    this.vJz = 8;
    this.vJA = 8;
  }
  
  public ContactSocialInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27047);
    this.vJv = 8;
    this.vJw = 8;
    this.vJx = 8;
    this.vJy = 8;
    this.vJz = 8;
    this.vJA = 8;
    setLayoutResource(2131494804);
    AppMethodBeat.o(27047);
  }
  
  private void cL()
  {
    AppMethodBeat.i(27055);
    if (this.vJp != null) {
      this.vJp.setVisibility(this.vJv);
    }
    if (this.vJq != null) {
      this.vJq.setVisibility(this.vJw);
    }
    if (this.vJr != null) {
      this.vJr.setVisibility(this.vJx);
    }
    if (this.vJs != null) {
      this.vJs.setVisibility(this.vJy);
    }
    if (this.vJt != null) {
      this.vJt.setVisibility(this.vJz);
    }
    if (this.oel != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.oel.getLayoutParams();
      localLayoutParams.width = a.au(this.mContext, 2131165370);
      this.oel.setLayoutParams(localLayoutParams);
    }
    if (this.vJu != null) {
      this.vJu.setVisibility(this.vJA);
    }
    AppMethodBeat.o(27055);
  }
  
  public final void Lk(int paramInt)
  {
    AppMethodBeat.i(27051);
    this.vJw = paramInt;
    cL();
    AppMethodBeat.o(27051);
  }
  
  public final void Ll(int paramInt)
  {
    AppMethodBeat.i(27052);
    this.vJx = paramInt;
    cL();
    AppMethodBeat.o(27052);
  }
  
  public final void Lm(int paramInt)
  {
    AppMethodBeat.i(27053);
    this.vJz = paramInt;
    cL();
    AppMethodBeat.o(27053);
  }
  
  public final void Ln(int paramInt)
  {
    AppMethodBeat.i(27054);
    this.vJA = paramInt;
    cL();
    AppMethodBeat.o(27054);
  }
  
  public final void Lo(int paramInt)
  {
    AppMethodBeat.i(27050);
    this.vJv = paramInt;
    cL();
    AppMethodBeat.o(27050);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27049);
    this.vJp = ((ImageView)paramView.findViewById(2131300953));
    this.vJq = ((ImageView)paramView.findViewById(2131300958));
    this.vJr = ((ImageView)paramView.findViewById(2131300949));
    this.vJs = ((ImageView)paramView.findViewById(2131300927));
    this.vJt = ((ImageView)paramView.findViewById(2131300937));
    this.vJu = ((ImageView)paramView.findViewById(2131300967));
    this.oel = ((TextView)paramView.findViewById(2131305902));
    cL();
    super.onBindView(paramView);
    AppMethodBeat.o(27049);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27048);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131494848, localViewGroup);
    AppMethodBeat.o(27048);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactSocialInfoPreference
 * JD-Core Version:    0.7.0.1
 */