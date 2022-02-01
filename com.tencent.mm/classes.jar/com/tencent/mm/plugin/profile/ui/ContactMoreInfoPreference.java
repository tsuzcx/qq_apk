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
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactMoreInfoPreference
  extends Preference
{
  private TextView oOh;
  private int xgA;
  private ImageView xgp;
  private ImageView xgq;
  private ImageView xgr;
  private ImageView xgs;
  private ImageView xgt;
  private ImageView xgu;
  private int xgv;
  private int xgw;
  private int xgx;
  private int xgy;
  private int xgz;
  
  public ContactMoreInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.xgv = 8;
    this.xgw = 8;
    this.xgx = 8;
    this.xgy = 8;
    this.xgz = 8;
    this.xgA = 8;
  }
  
  public ContactMoreInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27018);
    this.xgv = 8;
    this.xgw = 8;
    this.xgx = 8;
    this.xgy = 8;
    this.xgz = 8;
    this.xgA = 8;
    setLayoutResource(2131494804);
    AppMethodBeat.o(27018);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(27025);
    if (this.xgp != null) {
      this.xgp.setVisibility(this.xgv);
    }
    if (this.xgq != null) {
      this.xgq.setVisibility(this.xgw);
    }
    if (this.xgr != null) {
      this.xgr.setVisibility(this.xgx);
    }
    if (this.xgs != null) {
      this.xgs.setVisibility(this.xgy);
    }
    if (this.xgt != null) {
      this.xgt.setVisibility(this.xgz);
    }
    if (this.oOh != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.oOh.getLayoutParams();
      localLayoutParams.width = a.ax(this.mContext, 2131165370);
      this.oOh.setLayoutParams(localLayoutParams);
    }
    if (this.xgu != null) {
      this.xgu.setVisibility(this.xgA);
    }
    AppMethodBeat.o(27025);
  }
  
  public final void Ns(int paramInt)
  {
    AppMethodBeat.i(27021);
    this.xgw = paramInt;
    updateView();
    AppMethodBeat.o(27021);
  }
  
  public final void Nt(int paramInt)
  {
    AppMethodBeat.i(27022);
    this.xgx = paramInt;
    updateView();
    AppMethodBeat.o(27022);
  }
  
  public final void Nu(int paramInt)
  {
    AppMethodBeat.i(27023);
    this.xgz = paramInt;
    updateView();
    AppMethodBeat.o(27023);
  }
  
  public final void Nv(int paramInt)
  {
    AppMethodBeat.i(27024);
    this.xgA = paramInt;
    updateView();
    AppMethodBeat.o(27024);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27020);
    this.xgp = ((ImageView)paramView.findViewById(2131300953));
    this.xgq = ((ImageView)paramView.findViewById(2131300958));
    this.xgr = ((ImageView)paramView.findViewById(2131300949));
    this.xgs = ((ImageView)paramView.findViewById(2131300927));
    this.xgt = ((ImageView)paramView.findViewById(2131300937));
    this.xgu = ((ImageView)paramView.findViewById(2131300967));
    this.oOh = ((TextView)paramView.findViewById(2131305902));
    updateView();
    super.onBindView(paramView);
    AppMethodBeat.o(27020);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27019);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131494836, localViewGroup);
    AppMethodBeat.o(27019);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMoreInfoPreference
 * JD-Core Version:    0.7.0.1
 */